/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.tools.services.support;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.clang.lex.PPCallbacks;
import org.clang.lex.Token;
import org.clank.support.Casts;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.aliases.SmallVectorInt;

/**
 *
 * @author Vladimir Voskresensky
 */
/*package*/final class SkippedRangeBuilder {
  private static final boolean TEMPORARY_DISABLE_CHECK_IN_PTH_MODE = false;//!PreprocessorSupport.TOKEN_CACHE_PTH_FILE_PATH.isEmpty()  || PreprocessorSupport.SHARED_PTH_MANAGER;
  private static final int ERROR_DIRECTIVE_MARKER = Integer.MAX_VALUE;
  private static final int PRAGMA_ONCE_DIRECTIVE_MARKER = Integer.MAX_VALUE - 1;

  private final SortedSet<int[]> blocks = new TreeSet<>(COMPARATOR);
  private final char$ptr name;

  /*package*/SkippedRangeBuilder(char$ptr name) {
    this.name = name;
  }

  /*package*/
  final SkippedRangeBuilder addBlockImpl(int startDeadBlock, int endDeadBlock) {
    assert endDeadBlock >= startDeadBlock : "incorrect offsets " + startDeadBlock + " and " + endDeadBlock; // NOI18N
    if (endDeadBlock > startDeadBlock) {
      blocks.add(new int[]{startDeadBlock, endDeadBlock});
    }
    return this;
  }

  /**
   * Implements APTParseFileWalker.EvalCallback - adds offset of dead branch
   * to offsets array
   */
  //        @Override
  public void onErrorDirective(Token tok) {
    // on error directive we add special dead block
    //            addBlockImpl(ERROR_DIRECTIVE_MARKER-apt.getToken().getOffset(), ERROR_DIRECTIVE_MARKER);
  }

  /**
   * Implements APTParseFileWalker.EvalCallback - adds offset of dead branch
   * to offsets array
   */
  //        @Override
  public void onPragmaOnceDirective(Token tok) {
    // on pragma once directive we add dead block from pragma till the end
    //            addBlockImpl(apt.getToken().getOffset(), PRAGMA_ONCE_DIRECTIVE_MARKER);
  }

  public int[] build() {
    int size = 0;
    for (int[] deadInterval : blocks) {
      size++;
      if (deadInterval[1] == ERROR_DIRECTIVE_MARKER) {
        break;
      }
    }
    int[] offsets = new int[size * 2];
    int index = 0;
    for (int[] deadInterval : blocks) {
      offsets[index++] = deadInterval[0];
      offsets[index++] = deadInterval[1];
      if (deadInterval[1] == ERROR_DIRECTIVE_MARKER) {
        break;
      }
    }
    assert TEMPORARY_DISABLE_CHECK_IN_PTH_MODE || checkConsistency(offsets);
    return offsets;
  }

  private boolean checkConsistency(int[] offsets) {
    // check consistency for ordering and absence of intersections
    boolean ok = true;
    for (int i = 0; i < offsets.length; i++) {
      if (i + 1 < offsets.length) {
        if (!(offsets[i] < offsets[i + 1])) {
          ok = false;
          assert false : "inconsistent state " + this; // NOI18N
        }
      }
    }
    return ok;
  }

  @Override
  public String toString() {
    return toString(true);
  }
  
  public String toString(boolean withName) {
    StringBuilder sb = new StringBuilder();
    if (withName && name != null) {
      sb.append(Casts.toJavaString(name));
    }
    sb.append("["); //NOI18N
    int i = 0;
    for (int[] deadInterval : blocks) {
      if (i++ > 0) {
        sb.append("]["); //NOI18N
      }
      if (deadInterval[1] == ERROR_DIRECTIVE_MARKER) {
        sb.append(ERROR_DIRECTIVE_MARKER - deadInterval[0]);
        sb.append("#error"); //NOI18N
      } else if (deadInterval[1] == PRAGMA_ONCE_DIRECTIVE_MARKER) {
        sb.append(deadInterval[0]);
        sb.append("#pragma once"); //NOI18N
      } else {
        sb.append(deadInterval[0]);
        sb.append("-"); //NOI18N
        sb.append(deadInterval[1]);
      }
    }
    sb.append("]"); //NOI18N
    return sb.toString();
  }
  private static final Comparator<int[]> COMPARATOR = new Comparator<int[]>() {
    @Override
    public int compare(int[] segment1, int[] segment2) {
      return segment1[0] - segment2[0];
    }
  };
  private final SmallVectorInt someBlocksWithState = new SmallVectorInt(16);
  private static final int DEAD = 0;
  private static final int LIVE = 1;
  private static final int SEEN_LIVE = 2;
  private static final int SEEN_ONLY_DEAD = 3;

  /*package*/ void startIf(int hash, int eod, int ifOffset, PPCallbacks.ConditionValueKind ConditionValue) {
    if (NativeTrace.isDebugMode()) {
      NativeTrace.assertTrueInConsole((eod >= hash), "error in " + Casts.toJavaString(name) + " for #=" + hash + "; EOD=" + eod + "; if=" +ifOffset);
    }
    // push block state
    int blockState = ConditionValue == PPCallbacks.ConditionValueKind.CVK_True ? LIVE : DEAD;
    int seenLiveState = ConditionValue == PPCallbacks.ConditionValueKind.CVK_True ? SEEN_LIVE : SEEN_ONLY_DEAD;
    pushBlockState(ifOffset, seenLiveState, blockState, eod);
  }

  /*package*/ void handleElif(int hash, int eod, int ifOffset, PPCallbacks.ConditionValueKind ConditionValue) {
    boolean recoveredFromError = false; // indicates that #if directive wasn't parsed properly (i.e. we haven't registered it).
    if (someBlocksWithState.empty()) {
      recoveredFromError = true;
    } else if (someBlocksWithState.$at(someBlocksWithState.size() - 4) != ifOffset) { // IfLocMarker != ifOffset
      recoveredFromError = true;
    } else if (hash > eod) {
      recoveredFromError = true;
    }
    if (recoveredFromError) {
      if (TEMPORARY_DISABLE_CHECK_IN_PTH_MODE) return;
      NativeTrace.assertTrueInConsole(false, "error in " + Casts.toJavaString(name) + " for #=" + hash + "; EOD=" + eod + "; if=" +ifOffset);
    }
    int prevEOD;
    int blockState;
    int seenLiveState;
    int IfLocMarker;
    if (!recoveredFromError) {
      // pop in backward order
      prevEOD = someBlocksWithState.pop_back_val();
      blockState = someBlocksWithState.pop_back_val();
      seenLiveState = someBlocksWithState.pop_back_val();
      IfLocMarker = someBlocksWithState.pop_back_val();
    } else {
      prevEOD = ifOffset;
      blockState = DEAD;
      seenLiveState = SEEN_ONLY_DEAD;
      IfLocMarker = ifOffset;
    }
    assert IfLocMarker == ifOffset : IfLocMarker + " vs. " + ifOffset;
    assert blockState == LIVE || blockState == DEAD;
    assert seenLiveState == SEEN_LIVE || seenLiveState == SEEN_ONLY_DEAD;
    // finish prev block if needed
    finishPrevBlock(blockState, prevEOD, hash);
    // adjust started block states
    if (ConditionValue == PPCallbacks.ConditionValueKind.CVK_True && seenLiveState == SEEN_ONLY_DEAD) {
      blockState = LIVE;
      seenLiveState = SEEN_LIVE;
    } else {
      blockState = DEAD;
    }
    // push block state
    pushBlockState(ifOffset, seenLiveState, blockState, eod);
  }

  /*package*/ void handleElse(int hash, int eod, int ifOffset) {
    boolean recoveredFromError = false; // indicates that #if directive wasn't parsed properly (i.e. we haven't registered it).
    if (someBlocksWithState.empty()) {
      recoveredFromError = true;
    } else if (someBlocksWithState.$at(someBlocksWithState.size() - 4) != ifOffset) { // IfLocMarker != ifOffset
      recoveredFromError = true;
    } else if (hash > eod) {
      recoveredFromError = true;
    }
    if (recoveredFromError) {
      if (TEMPORARY_DISABLE_CHECK_IN_PTH_MODE) return;
      NativeTrace.assertTrueInConsole(false, "error in " + Casts.toJavaString(name) + " for #=" + hash + "; EOD=" + eod + "; if=" +ifOffset);
    }
    int prevEOD;
    int blockState;
    int seenLiveState;
    int IfLocMarker;
    if (!recoveredFromError) {
      // pop in backward order
      prevEOD = someBlocksWithState.pop_back_val();
      blockState = someBlocksWithState.pop_back_val();
      seenLiveState = someBlocksWithState.pop_back_val();
      IfLocMarker = someBlocksWithState.pop_back_val();
    } else {
      prevEOD = ifOffset;
      blockState = DEAD;
      seenLiveState = SEEN_ONLY_DEAD;
      IfLocMarker = ifOffset;
    }
    assert IfLocMarker == ifOffset : IfLocMarker + " vs. " + ifOffset;
    assert blockState == LIVE || blockState == DEAD;
    assert seenLiveState == SEEN_LIVE || seenLiveState == SEEN_ONLY_DEAD;
    // finish prev block if needed
    finishPrevBlock(blockState, prevEOD, hash);
    // on else:
    // - if not seen any live blocks above then current is alive
    // - otherwise current is dead
    if (seenLiveState == SEEN_LIVE) {
      blockState = DEAD;
    } else {
      blockState = LIVE;
      // just for mistakes with multi #else
      seenLiveState = SEEN_LIVE;
    }
    // push block state
    pushBlockState(ifOffset, seenLiveState, blockState, eod);
  }

  /*package*/ void handleEndif(int hash, int eod, int ifOffset) {
    boolean recoveredFromError = false; // indicates that #if directive wasn't parsed properly (i.e. we haven't registered it).
    if (someBlocksWithState.empty()) {
      recoveredFromError = true;
    } else if (someBlocksWithState.$at(someBlocksWithState.size() - 4) != ifOffset) { // IfLocMarker != ifOffset
      recoveredFromError = true;
    } else if (hash > eod) {
      recoveredFromError = true;
    }
    if (recoveredFromError) {
      if (TEMPORARY_DISABLE_CHECK_IN_PTH_MODE) return;
      NativeTrace.assertTrueInConsole(false, "error in " + Casts.toJavaString(name) + " for #=" + hash + "; EOD=" + eod + "; if=" +ifOffset);
    }   
    // pop in backward order
    if (!someBlocksWithState.empty()) {
      int prevEOD = someBlocksWithState.pop_back_val();
      int blockState = someBlocksWithState.pop_back_val();
      int seenLiveState = someBlocksWithState.pop_back_val();
      int IfLocMarker = someBlocksWithState.pop_back_val();
      assert IfLocMarker == ifOffset : IfLocMarker + " vs. " + ifOffset;
      assert blockState == LIVE || blockState == DEAD;
      assert seenLiveState == SEEN_LIVE || seenLiveState == SEEN_ONLY_DEAD;
      // finish prev block if needed
      finishPrevBlock(blockState, prevEOD, hash);
    }
  }

  /*package*/ void handleErrorDiagnostic(int hash, int eod) {
    assert eod >= hash : "incorrect offsets " + hash + " and " + eod; // NOI18N
    // for #error directives
    // dead block is special: marker-hash till special marker
    addBlockImpl(ERROR_DIRECTIVE_MARKER - hash, ERROR_DIRECTIVE_MARKER);
  }

  private void pushBlockState(int ifOffsetMarker, int seenLiveState, int blockState, int eod) {
    assert blockState == LIVE || blockState == DEAD;
    assert seenLiveState == SEEN_LIVE || seenLiveState == SEEN_ONLY_DEAD;
    assert ifOffsetMarker <= eod;
    someBlocksWithState.push_back(ifOffsetMarker);
    someBlocksWithState.push_back(seenLiveState);
    someBlocksWithState.push_back(blockState);
    someBlocksWithState.push_back(eod);
  }

  private void finishPrevBlock(int blockState, int prevEOD, int stopAtHash) {
    // finish prev block if needed
    if (blockState == DEAD) {
      // from the end of directive position which started dead code block
      // till the previous position of the hash for closing dead code
      addBlockImpl(prevEOD, stopAtHash - 1);
    }
  }

}
