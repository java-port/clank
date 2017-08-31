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

package org.clang.ast.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1027,
 FQN="(anonymous namespace)::ComplexValue", NM="_ZN12_GLOBAL__N_112ComplexValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValueE")
//</editor-fold>
public class/*struct*/ ComplexValue implements Destructors.ClassWithDestructor {
/*private:*/
  private boolean IsInt;
/*public:*/
  public APSInt IntReal;
  public APSInt IntImag;
  public APFloat FloatReal;
  public APFloat FloatImag;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::ComplexValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1035,
   FQN="(anonymous namespace)::ComplexValue::ComplexValue", NM="_ZN12_GLOBAL__N_112ComplexValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValueC1Ev")
  //</editor-fold>
  public ComplexValue() {
    // : IntReal(), IntImag(), FloatReal(APFloat::Bogus), FloatImag(APFloat::Bogus) 
    //START JInit
    this.IntReal = new APSInt();
    this.IntImag = new APSInt();
    this.FloatReal = new APFloat(APFloat.Bogus);
    this.FloatImag = new APFloat(APFloat.Bogus);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::makeComplexFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1037,
   FQN="(anonymous namespace)::ComplexValue::makeComplexFloat", NM="_ZN12_GLOBAL__N_112ComplexValue16makeComplexFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue16makeComplexFloatEv")
  //</editor-fold>
  public void makeComplexFloat() {
    IsInt = false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::isComplexFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1038,
   FQN="(anonymous namespace)::ComplexValue::isComplexFloat", NM="_ZNK12_GLOBAL__N_112ComplexValue14isComplexFloatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_112ComplexValue14isComplexFloatEv")
  //</editor-fold>
  public boolean isComplexFloat() /*const*/ {
    return !IsInt;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::getComplexFloatReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1039,
   FQN="(anonymous namespace)::ComplexValue::getComplexFloatReal", NM="_ZN12_GLOBAL__N_112ComplexValue19getComplexFloatRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue19getComplexFloatRealEv")
  //</editor-fold>
  public APFloat /*&*/ getComplexFloatReal() {
    return FloatReal;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::getComplexFloatImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1040,
   FQN="(anonymous namespace)::ComplexValue::getComplexFloatImag", NM="_ZN12_GLOBAL__N_112ComplexValue19getComplexFloatImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue19getComplexFloatImagEv")
  //</editor-fold>
  public APFloat /*&*/ getComplexFloatImag() {
    return FloatImag;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::makeComplexInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1042,
   FQN="(anonymous namespace)::ComplexValue::makeComplexInt", NM="_ZN12_GLOBAL__N_112ComplexValue14makeComplexIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue14makeComplexIntEv")
  //</editor-fold>
  public void makeComplexInt() {
    IsInt = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::isComplexInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1043,
   FQN="(anonymous namespace)::ComplexValue::isComplexInt", NM="_ZNK12_GLOBAL__N_112ComplexValue12isComplexIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_112ComplexValue12isComplexIntEv")
  //</editor-fold>
  public boolean isComplexInt() /*const*/ {
    return IsInt;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::getComplexIntReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1044,
   FQN="(anonymous namespace)::ComplexValue::getComplexIntReal", NM="_ZN12_GLOBAL__N_112ComplexValue17getComplexIntRealEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue17getComplexIntRealEv")
  //</editor-fold>
  public APSInt /*&*/ getComplexIntReal() {
    return IntReal;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::getComplexIntImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1045,
   FQN="(anonymous namespace)::ComplexValue::getComplexIntImag", NM="_ZN12_GLOBAL__N_112ComplexValue17getComplexIntImagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue17getComplexIntImagEv")
  //</editor-fold>
  public APSInt /*&*/ getComplexIntImag() {
    return IntImag;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::moveInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1047,
   FQN="(anonymous namespace)::ComplexValue::moveInto", NM="_ZNK12_GLOBAL__N_112ComplexValue8moveIntoERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_112ComplexValue8moveIntoERN5clang7APValueE")
  //</editor-fold>
  public void moveInto(final APValue /*&*/ v) /*const*/ {
    if (isComplexFloat()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(v.$assign($c$.track(new APValue(new APFloat(FloatReal), new APFloat(FloatImag)))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(v.$assign($c$.track(new APValue(new APSInt(IntReal), new APSInt(IntImag)))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::setFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1053,
   FQN="(anonymous namespace)::ComplexValue::setFrom", NM="_ZN12_GLOBAL__N_112ComplexValue7setFromERKN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValue7setFromERKN5clang7APValueE")
  //</editor-fold>
  public void setFrom(final /*const*/ APValue /*&*/ v) {
    assert (v.isComplexFloat() || v.isComplexInt());
    if (v.isComplexFloat()) {
      makeComplexFloat();
      FloatReal.$assign(v.getComplexFloatReal$Const());
      FloatImag.$assign(v.getComplexFloatImag$Const());
    } else {
      makeComplexInt();
      IntReal.$assign(v.getComplexIntReal$Const());
      IntImag.$assign(v.getComplexIntImag$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::~ComplexValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1027,
   FQN="(anonymous namespace)::ComplexValue::~ComplexValue", NM="_ZN12_GLOBAL__N_112ComplexValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValueD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FloatImag.$destroy();
    FloatReal.$destroy();
    IntImag.$destroy();
    IntReal.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComplexValue::ComplexValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1027,
   FQN="(anonymous namespace)::ComplexValue::ComplexValue", NM="_ZN12_GLOBAL__N_112ComplexValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112ComplexValueC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ComplexValue(final /*const*/ ComplexValue /*&*/ $Prm0) {
    // : IsInt(.IsInt), IntReal(.IntReal), IntImag(.IntImag), FloatReal(.FloatReal), FloatImag(.FloatImag) 
    //START JInit
    this.IsInt = $Prm0.IsInt;
    this.IntReal = new APSInt($Prm0.IntReal);
    this.IntImag = new APSInt($Prm0.IntImag);
    this.FloatReal = new APFloat($Prm0.FloatReal);
    this.FloatImag = new APFloat($Prm0.FloatImag);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "IsInt=" + IsInt // NOI18N
              + ", IntReal=" + IntReal // NOI18N
              + ", IntImag=" + IntImag // NOI18N
              + ", FloatReal=" + FloatReal // NOI18N
              + ", FloatImag=" + FloatImag; // NOI18N
  }
}
