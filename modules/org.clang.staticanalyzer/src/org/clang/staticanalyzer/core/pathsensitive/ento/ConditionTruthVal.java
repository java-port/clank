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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 30,
 FQN="clang::ento::ConditionTruthVal", NM="_ZN5clang4ento17ConditionTruthValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConditionTruthValE")
//</editor-fold>
public class ConditionTruthVal implements Destructors.ClassWithDestructor {
  private OptionalBool Val;
/*public:*/
  /// Construct a ConditionTruthVal indicating the constraint is constrained
  /// to either true or false, depending on the boolean value provided.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::ConditionTruthVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 35,
   FQN="clang::ento::ConditionTruthVal::ConditionTruthVal", NM="_ZN5clang4ento17ConditionTruthValC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConditionTruthValC1Eb")
  //</editor-fold>
  public ConditionTruthVal(boolean constraint) {
    // : Val(constraint) 
    //START JInit
    this.Val = new OptionalBool(JD$T$C$R.INSTANCE, constraint);
    //END JInit
  }

  
  /// Construct a ConstraintVal indicating the constraint is underconstrained.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::ConditionTruthVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 38,
   FQN="clang::ento::ConditionTruthVal::ConditionTruthVal", NM="_ZN5clang4ento17ConditionTruthValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConditionTruthValC1Ev")
  //</editor-fold>
  public ConditionTruthVal() {
    // : Val() 
    //START JInit
    this.Val = new OptionalBool();
    //END JInit
  }

  
  /// Return true if the constraint is perfectly constrained to 'true'.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::isConstrainedTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 41,
   FQN="clang::ento::ConditionTruthVal::isConstrainedTrue", NM="_ZNK5clang4ento17ConditionTruthVal17isConstrainedTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZNK5clang4ento17ConditionTruthVal17isConstrainedTrueEv")
  //</editor-fold>
  public boolean isConstrainedTrue() /*const*/ {
    return Val.hasValue() && Val.getValue$Const();
  }

  
  /// Return true if the constraint is perfectly constrained to 'false'.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::isConstrainedFalse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 46,
   FQN="clang::ento::ConditionTruthVal::isConstrainedFalse", NM="_ZNK5clang4ento17ConditionTruthVal18isConstrainedFalseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZNK5clang4ento17ConditionTruthVal18isConstrainedFalseEv")
  //</editor-fold>
  public boolean isConstrainedFalse() /*const*/ {
    return Val.hasValue() && !Val.getValue$Const();
  }

  
  /// Return true if the constrained is perfectly constrained.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::isConstrained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 51,
   FQN="clang::ento::ConditionTruthVal::isConstrained", NM="_ZNK5clang4ento17ConditionTruthVal13isConstrainedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZNK5clang4ento17ConditionTruthVal13isConstrainedEv")
  //</editor-fold>
  public boolean isConstrained() /*const*/ {
    return Val.hasValue();
  }

  
  /// Return true if the constrained is underconstrained and we do not know
  /// if the constraint is true of value.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::isUnderconstrained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 57,
   FQN="clang::ento::ConditionTruthVal::isUnderconstrained", NM="_ZNK5clang4ento17ConditionTruthVal18isUnderconstrainedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZNK5clang4ento17ConditionTruthVal18isUnderconstrainedEv")
  //</editor-fold>
  public boolean isUnderconstrained() /*const*/ {
    return !Val.hasValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::ConditionTruthVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 30,
   FQN="clang::ento::ConditionTruthVal::ConditionTruthVal", NM="_ZN5clang4ento17ConditionTruthValC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConditionTruthValC1EOS1_")
  //</editor-fold>
  public /*inline*/ ConditionTruthVal(JD$Move _dparam, final ConditionTruthVal /*&&*/$Prm0) {
    // : Val(static_cast<ConditionTruthVal &&>().Val) 
    //START JInit
    this.Val = new OptionalBool(JD$Move.INSTANCE, $Prm0.Val);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ConditionTruthVal::~ConditionTruthVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ConstraintManager.h", line = 30,
   FQN="clang::ento::ConditionTruthVal::~ConditionTruthVal", NM="_ZN5clang4ento17ConditionTruthValD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ConstraintManager.cpp -nm=_ZN5clang4ento17ConditionTruthValD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Val.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Val=" + Val; // NOI18N
  }
}
