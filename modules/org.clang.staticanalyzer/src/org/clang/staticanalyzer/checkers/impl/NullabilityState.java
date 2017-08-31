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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.impl.*;
import static org.clang.staticanalyzer.checkers.impl.NullabilityCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 213,
 FQN="(anonymous namespace)::NullabilityState", NM="_ZN12_GLOBAL__N_116NullabilityStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_116NullabilityStateE")
//</editor-fold>
public class NullabilityState implements FoldingSetTrait.Profilable, NativeCloneable<NullabilityState> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::NullabilityState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 215,
   FQN="(anonymous namespace)::NullabilityState::NullabilityState", NM="_ZN12_GLOBAL__N_116NullabilityStateC1ENS_11NullabilityEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_116NullabilityStateC1ENS_11NullabilityEPKN5clang4StmtE")
  //</editor-fold>
  public NullabilityState(Nullability Nullab) {
    this(Nullab, (/*const*/ Stmt /*P*/ )null);
  }
  public NullabilityState(Nullability Nullab, /*const*/ Stmt /*P*/ Source/*= null*/) {
    // : Nullab(Nullab), Source(Source) 
    //START JInit
    this.Nullab = Nullab;
    this.Source = Source;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::getNullabilitySource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 218,
   FQN="(anonymous namespace)::NullabilityState::getNullabilitySource", NM="_ZNK12_GLOBAL__N_116NullabilityState20getNullabilitySourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_116NullabilityState20getNullabilitySourceEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getNullabilitySource() /*const*/ {
    return Source;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 220,
   FQN="(anonymous namespace)::NullabilityState::getValue", NM="_ZNK12_GLOBAL__N_116NullabilityState8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_116NullabilityState8getValueEv")
  //</editor-fold>
  public Nullability getValue() /*const*/ {
    return Nullab;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 222,
   FQN="(anonymous namespace)::NullabilityState::Profile", NM="_ZNK12_GLOBAL__N_116NullabilityState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_116NullabilityState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_int(((/*static_cast*//*char*/byte)Nullab.getValue()));
    ID.AddPointer(Source);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 227,
   FQN="(anonymous namespace)::NullabilityState::print", NM="_ZNK12_GLOBAL__N_116NullabilityState5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZNK12_GLOBAL__N_116NullabilityState5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out) /*const*/ {
    Out.$out(getNullabilityString(Nullab)).$out(/*KEEP_STR*/$LF);
  }

/*private:*/
  private Nullability Nullab;
  // Source is the expression which determined the nullability. For example in a
  // message like [nullable nonnull_returning] has nullable nullability, because
  // the receiver is nullable. Here the receiver will be the source of the
  // nullability. This is useful information when the diagnostics are generated.
  private /*const*/ Stmt /*P*/ Source;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::NullabilityState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 213,
   FQN="(anonymous namespace)::NullabilityState::NullabilityState", NM="_ZN12_GLOBAL__N_116NullabilityStateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_116NullabilityStateC1ERKS0_")
  //</editor-fold>
  public /*inline*/ NullabilityState(final /*const*/ NullabilityState /*&*/ $Prm0) {
    // : Nullab(.Nullab), Source(.Source) 
    //START JInit
    this.Nullab = $Prm0.Nullab;
    this.Source = $Prm0.Source;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullabilityState::NullabilityState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 213,
   FQN="(anonymous namespace)::NullabilityState::NullabilityState", NM="_ZN12_GLOBAL__N_116NullabilityStateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN12_GLOBAL__N_116NullabilityStateC1EOS0_")
  //</editor-fold>
  public /*inline*/ NullabilityState(JD$Move _dparam, final NullabilityState /*&&*/$Prm0) {
    // : Nullab(static_cast<NullabilityState &&>().Nullab), Source(static_cast<NullabilityState &&>().Source) 
    //START JInit
    this.Nullab = $Prm0.Nullab;
    this.Source = $Prm0.Source;
    //END JInit
  }

  @Override public NullabilityState clone() { return new NullabilityState(this); }
  
  @Override public String toString() {
    return "" + "Nullab=" + Nullab // NOI18N
              + ", Source=" + Source; // NOI18N
  }
}
