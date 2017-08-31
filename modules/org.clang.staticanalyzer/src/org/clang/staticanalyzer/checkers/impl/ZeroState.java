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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 27,
 FQN="(anonymous namespace)::ZeroState", NM="_ZN12_GLOBAL__N_19ZeroStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_19ZeroStateE")
//</editor-fold>
public class ZeroState implements Native.NativeComparable<ZeroState>, FoldingSetTrait.Profilable, NativeCloneable<ZeroState>, Native.ComparableLower {
/*private:*/
  private /*const*/ SymExpr /*P*/ ZeroSymbol;
  private /*uint*/int BlockID;
  private /*const*/ StackFrameContext /*P*/ SFC;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::ZeroState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 34,
   FQN="(anonymous namespace)::ZeroState::ZeroState", NM="_ZN12_GLOBAL__N_19ZeroStateC1EPKN5clang4ento7SymExprEjPKNS1_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_19ZeroStateC1EPKN5clang4ento7SymExprEjPKNS1_17StackFrameContextE")
  //</editor-fold>
  public ZeroState(/*const*/ SymExpr /*P*/ S, /*uint*/int B, /*const*/ StackFrameContext /*P*/ SFC) {
    // : ZeroSymbol(S), BlockID(B), SFC(SFC) 
    //START JInit
    this.ZeroSymbol = S;
    this.BlockID = B;
    this.SFC = SFC;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::getStackFrameContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 37,
   FQN="(anonymous namespace)::ZeroState::getStackFrameContext", NM="_ZNK12_GLOBAL__N_19ZeroState20getStackFrameContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_19ZeroState20getStackFrameContextEv")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrameContext() /*const*/ {
    return SFC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 39,
   FQN="(anonymous namespace)::ZeroState::operator==", NM="_ZNK12_GLOBAL__N_19ZeroStateeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_19ZeroStateeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ ZeroState /*&*/ X) /*const*/ {
    return BlockID == X.BlockID && SFC == X.SFC && ZeroSymbol == X.ZeroSymbol;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 43,
   FQN="(anonymous namespace)::ZeroState::operator<", NM="_ZNK12_GLOBAL__N_19ZeroStateltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_19ZeroStateltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ ZeroState /*&*/ X) /*const*/ {
    if (BlockID != X.BlockID) {
      return $less_uint(BlockID, X.BlockID);
    }
// The orifinal code is exactly as generated java.
// It compares pointers, i.e. two elements of type StackFrameContext*
// and two elements of type SymExpr*
//    if (SFC != X.SFC) {
//      return SFC < X.SFC; 
//    }
//    return ZeroSymbol < X.ZeroSymbol;
    if (SFC != X.SFC) {
      return Native.$less$JavaRef(this.SFC, X.SFC);
    }
    return Native.$less$JavaRef(ZeroSymbol, X.ZeroSymbol);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 51,
   FQN="(anonymous namespace)::ZeroState::Profile", NM="_ZNK12_GLOBAL__N_19ZeroState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZNK12_GLOBAL__N_19ZeroState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint(BlockID);
    ID.AddPointer(SFC);
    ID.AddPointer(ZeroSymbol);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::ZeroState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ZeroState::ZeroState", NM="_ZN12_GLOBAL__N_19ZeroStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_19ZeroStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ZeroState(final /*const*/ ZeroState /*&*/ $Prm0) {
    // : ZeroSymbol(.ZeroSymbol), BlockID(.BlockID), SFC(.SFC) 
    //START JInit
    this.ZeroSymbol = $Prm0.ZeroSymbol;
    this.BlockID = $Prm0.BlockID;
    this.SFC = $Prm0.SFC;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ZeroState::ZeroState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ZeroState::ZeroState", NM="_ZN12_GLOBAL__N_19ZeroStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN12_GLOBAL__N_19ZeroStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ ZeroState(JD$Move _dparam, final ZeroState /*&&*/$Prm0) {
    // : ZeroSymbol(static_cast<ZeroState &&>().ZeroSymbol), BlockID(static_cast<ZeroState &&>().BlockID), SFC(static_cast<ZeroState &&>().SFC) 
    //START JInit
    this.ZeroSymbol = $Prm0.ZeroSymbol;
    this.BlockID = $Prm0.BlockID;
    this.SFC = $Prm0.SFC;
    //END JInit
  }

  @Override
  public ZeroState clone() {
    return new ZeroState(this);
  }

  @Override
  public boolean $less(Object obj) {
    return $less((ZeroState) obj);
  }
  
  @Override public String toString() {
    return "" + "ZeroSymbol=" + ZeroSymbol // NOI18N
              + ", BlockID=" + BlockID // NOI18N
              + ", SFC=" + "[StackFrameContext]"; // NOI18N
  }
}
