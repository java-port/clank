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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;


/// Structure for specifying position in CFG during its build process. It
/// consists of CFGBlock that specifies position in CFG and
/// LocalScope::const_iterator that specifies position in LocalScope graph.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 281,
 FQN="(anonymous namespace)::BlockScopePosPair", NM="_ZN12_GLOBAL__N_117BlockScopePosPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairE")
//</editor-fold>
public class/*struct*/ BlockScopePosPair implements NativePOD<BlockScopePosPair> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 282,
   FQN="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair", NM="_ZN12_GLOBAL__N_117BlockScopePosPairC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairC1Ev")
  //</editor-fold>
  public BlockScopePosPair() {
    // : block(null), scopePosition() 
    //START JInit
    this.block = null;
    this.scopePosition = $tryClone(new LocalScope.const_iterator());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 283,
   FQN="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair", NM="_ZN12_GLOBAL__N_117BlockScopePosPairC1EPN5clang8CFGBlockENS_10LocalScope14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairC1EPN5clang8CFGBlockENS_10LocalScope14const_iteratorE")
  //</editor-fold>
  public BlockScopePosPair(CFGBlock /*P*/ b, LocalScope.const_iterator scopePos) {
    // : block(b), scopePosition(scopePos) 
    //START JInit
    this.block = b;
    this.scopePosition = $tryClone(new LocalScope.const_iterator(scopePos));
    //END JInit
  }

  
  public CFGBlock /*P*/ block;
  public LocalScope.const_iterator scopePosition;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 281,
   FQN="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair", NM="_ZN12_GLOBAL__N_117BlockScopePosPairC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BlockScopePosPair(final /*const*/ BlockScopePosPair /*&*/ $Prm0) {
    // : block(.block), scopePosition(.scopePosition) 
    //START JInit
    this.block = $Prm0.block;
    this.scopePosition = $tryClone(new LocalScope.const_iterator($Prm0.scopePosition));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 281,
   FQN="(anonymous namespace)::BlockScopePosPair::BlockScopePosPair", NM="_ZN12_GLOBAL__N_117BlockScopePosPairC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairC1EOS0_")
  //</editor-fold>
  public /*inline*/ BlockScopePosPair(JD$Move _dparam, final BlockScopePosPair /*&&*/$Prm0) {
    // : block(static_cast<BlockScopePosPair &&>().block), scopePosition(static_cast<BlockScopePosPair &&>().scopePosition) 
    //START JInit
    this.block = $Prm0.block;
    this.scopePosition = $tryClone(new LocalScope.const_iterator(JD$Move.INSTANCE, $Prm0.scopePosition));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 281,
   FQN="(anonymous namespace)::BlockScopePosPair::operator=", NM="_ZN12_GLOBAL__N_117BlockScopePosPairaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairaSERKS0_")
  //</editor-fold>
  public /*inline*/ BlockScopePosPair /*&*/ $assign(final /*const*/ BlockScopePosPair /*&*/ $Prm0) {
    this.block = $Prm0.block;
    this.scopePosition.$assign($Prm0.scopePosition);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockScopePosPair::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 281,
   FQN="(anonymous namespace)::BlockScopePosPair::operator=", NM="_ZN12_GLOBAL__N_117BlockScopePosPairaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117BlockScopePosPairaSEOS0_")
  //</editor-fold>
  public /*inline*/ BlockScopePosPair /*&*/ $assignMove(final BlockScopePosPair /*&&*/$Prm0) {
    this.block = $Prm0.block;
    this.scopePosition.$assignMove($Prm0.scopePosition);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public BlockScopePosPair clone() { return new BlockScopePosPair(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "block=" + block // NOI18N
              + ", scopePosition=" + scopePosition; // NOI18N
  }
}
