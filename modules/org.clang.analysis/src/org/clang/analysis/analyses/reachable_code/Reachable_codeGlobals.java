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
package org.clang.analysis.analyses.reachable_code;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import org.clang.lex.Preprocessor;
import static org.clang.analysis.impl.ReachableCodeStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Reachable_codeGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN5clang14reachable_code19FindUnreachableCodeERNS_19AnalysisDeclContextERNS_12PreprocessorERNS0_8CallbackE;_ZN5clang14reachable_code22ScanReachableFromBlockEPKNS_8CFGBlockERN4llvm9BitVectorE; -static-type=Reachable_codeGlobals -package=org.clang.analysis.analyses.reachable_code")
//</editor-fold>
public final class Reachable_codeGlobals {


/// ScanReachableFromBlock - Mark all blocks reachable from Start.
/// Returns the total number of blocks that were marked reachable.  
//<editor-fold defaultstate="collapsed" desc="clang::reachable_code::ScanReachableFromBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 632,
 FQN="clang::reachable_code::ScanReachableFromBlock", NM="_ZN5clang14reachable_code22ScanReachableFromBlockEPKNS_8CFGBlockERN4llvm9BitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN5clang14reachable_code22ScanReachableFromBlockEPKNS_8CFGBlockERN4llvm9BitVectorE")
//</editor-fold>
public static /*uint*/int ScanReachableFromBlock(/*const*/ CFGBlock /*P*/ Start, 
                      final BitVector /*&*/ Reachable) {
  return scanFromBlock(Start, Reachable, /* SourceManager* */ (Preprocessor /*P*/ )null, false);
}

//<editor-fold defaultstate="collapsed" desc="clang::reachable_code::FindUnreachableCode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp", line = 637,
 FQN="clang::reachable_code::FindUnreachableCode", NM="_ZN5clang14reachable_code19FindUnreachableCodeERNS_19AnalysisDeclContextERNS_12PreprocessorERNS0_8CallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ReachableCode.cpp -nm=_ZN5clang14reachable_code19FindUnreachableCodeERNS_19AnalysisDeclContextERNS_12PreprocessorERNS0_8CallbackE")
//</editor-fold>
public static void FindUnreachableCode(final AnalysisDeclContext /*&*/ AC, final Preprocessor /*&*/ PP, 
                   final Callback /*&*/ CB) {
  
  CFG /*P*/ cfg = AC.getCFG();
  if (!(cfg != null)) {
    return;
  }
  
  // Scan for reachable blocks from the entrance of the CFG.
  // If there are no unreachable blocks, we're done.
  BitVector reachable/*J*/= new BitVector(cfg.getNumBlockIDs());
  /*uint*/int numReachable = scanMaybeReachableFromBlock($AddrOf(cfg.getEntry()), PP, reachable);
  if (numReachable == cfg.getNumBlockIDs()) {
    return;
  }
  
  // If there aren't explicit EH edges, we should include the 'try' dispatch
  // blocks as roots.
  if (!AC.getCFGBuildOptions().AddEHEdges) {
    for (std.vector.iterator</*const*/ CFGBlock /*P*/> I = cfg.try_blocks_begin(), 
        E = cfg.try_blocks_end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
      numReachable += scanMaybeReachableFromBlock(I.$star(), PP, reachable);
    }
    if (numReachable == cfg.getNumBlockIDs()) {
      return;
    }
  }
  
  // There are some unreachable blocks.  We need to find the root blocks that
  // contain code that should be considered unreachable.  
  for (type$ptr<CFGBlock> I = $tryClone(cfg.begin()), /*P*/ E = $tryClone(cfg.end()); $noteq_ptr(I, E); I.$preInc()) {
    DeadCodeScan DS = null;
    try {
      /*const*/ CFGBlock /*P*/ block = I.$star();
      // A block may have been marked reachable during this loop.
      if (reachable.$at(block.getBlockID()).$bool()) {
        continue;
      }
      
      DS/*J*/= new DeadCodeScan(reachable, PP);
      numReachable += DS.scanBackwards(block, CB);
      if (numReachable == cfg.getNumBlockIDs()) {
        return;
      }
    } finally {
      if (DS != null) { DS.$destroy(); }
    }
  }
}

} // END OF class Reachable_codeGlobals
