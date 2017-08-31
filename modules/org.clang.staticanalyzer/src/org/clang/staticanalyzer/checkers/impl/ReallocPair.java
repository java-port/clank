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

package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \class ReallocPair
/// \brief Stores information about the symbol being reallocated by a call to
/// 'realloc' to allow modeling failed reallocation later in the path.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReallocPair">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 139,
 FQN="(anonymous namespace)::ReallocPair", NM="_ZN12_GLOBAL__N_111ReallocPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_111ReallocPairE")
//</editor-fold>
public class/*struct*/ ReallocPair implements Native.NativeComparable<ReallocPair>, FoldingSetTrait.Profilable, NativeCloneable<ReallocPair> {
  // \brief The symbol which realloc reallocated.
  public /*const*/ SymExpr /*P*/ ReallocatedSym;
  public ReallocPairKind Kind;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReallocPair::ReallocPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 144,
   FQN="(anonymous namespace)::ReallocPair::ReallocPair", NM="_ZN12_GLOBAL__N_111ReallocPairC1EPKN5clang4ento7SymExprENS_15ReallocPairKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_111ReallocPairC1EPKN5clang4ento7SymExprENS_15ReallocPairKindE")
  //</editor-fold>
  public ReallocPair(/*const*/ SymExpr /*P*/ S, ReallocPairKind K) {
    // : ReallocatedSym(S), Kind(K) 
    //START JInit
    this.ReallocatedSym = S;
    this.Kind = K;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReallocPair::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 146,
   FQN="(anonymous namespace)::ReallocPair::Profile", NM="_ZNK12_GLOBAL__N_111ReallocPair7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_111ReallocPair7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_int(Kind.getValue());
    ID.AddPointer(ReallocatedSym);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReallocPair::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 150,
   FQN="(anonymous namespace)::ReallocPair::operator==", NM="_ZNK12_GLOBAL__N_111ReallocPaireqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZNK12_GLOBAL__N_111ReallocPaireqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ReallocPair /*&*/ X) /*const*/ {
    return ReallocatedSym == X.ReallocatedSym
       && Kind == X.Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReallocPair::ReallocPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 139,
   FQN="(anonymous namespace)::ReallocPair::ReallocPair", NM="_ZN12_GLOBAL__N_111ReallocPairC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_111ReallocPairC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ReallocPair(final /*const*/ ReallocPair /*&*/ $Prm0) {
    // : ReallocatedSym(.ReallocatedSym), Kind(.Kind) 
    //START JInit
    this.ReallocatedSym = $Prm0.ReallocatedSym;
    this.Kind = $Prm0.Kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReallocPair::ReallocPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 139,
   FQN="(anonymous namespace)::ReallocPair::ReallocPair", NM="_ZN12_GLOBAL__N_111ReallocPairC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN12_GLOBAL__N_111ReallocPairC1EOS0_")
  //</editor-fold>
  public /*inline*/ ReallocPair(JD$Move _dparam, final ReallocPair /*&&*/$Prm0) {
    // : ReallocatedSym(static_cast<ReallocPair &&>().ReallocatedSym), Kind(static_cast<ReallocPair &&>().Kind) 
    //START JInit
    this.ReallocatedSym = $Prm0.ReallocatedSym;
    this.Kind = $Prm0.Kind;
    //END JInit
  }

  @Override public ReallocPair clone() { return new ReallocPair(this); }
  
  @Override public String toString() {
    return "" + "ReallocatedSym=" + ReallocatedSym // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
