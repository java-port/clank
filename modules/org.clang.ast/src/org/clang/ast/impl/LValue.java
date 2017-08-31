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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1067,
 FQN="(anonymous namespace)::LValue", NM="_ZN12_GLOBAL__N_16LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValueE")
//</editor-fold>
public class/*struct*/ LValue implements LValueBase, Destructors.ClassWithDestructor {
  public PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > Base;
  public CharUnits Offset;
  public /*JBIT unsigned int*/ boolean InvalidBase /*: 1*/;
  public /*uint*/int CallIndex /*: 31*/;
  public SubobjectDesignator Designator;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::getLValueBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1074,
   FQN="(anonymous namespace)::LValue::getLValueBase", NM="_ZNK12_GLOBAL__N_16LValue13getLValueBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_16LValue13getLValueBaseEv")
  //</editor-fold>
  public /*const*/ PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > getLValueBase() /*const*/ {
    return new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::getLValueOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1075,
   FQN="(anonymous namespace)::LValue::getLValueOffset", NM="_ZN12_GLOBAL__N_16LValue15getLValueOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue15getLValueOffsetEv")
  //</editor-fold>
  public CharUnits /*&*/ getLValueOffset() {
    return Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::getLValueOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1076,
   FQN="(anonymous namespace)::LValue::getLValueOffset", NM="_ZNK12_GLOBAL__N_16LValue15getLValueOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_16LValue15getLValueOffsetEv")
  //</editor-fold>
  public /*const*/ CharUnits /*&*/ getLValueOffset$Const() /*const*/ {
    return Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::getLValueCallIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1077,
   FQN="(anonymous namespace)::LValue::getLValueCallIndex", NM="_ZNK12_GLOBAL__N_16LValue18getLValueCallIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_16LValue18getLValueCallIndexEv")
  //</editor-fold>
  public /*uint*/int getLValueCallIndex() /*const*/ {
    return CallIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::getLValueDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1078,
   FQN="(anonymous namespace)::LValue::getLValueDesignator", NM="_ZN12_GLOBAL__N_16LValue19getLValueDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue19getLValueDesignatorEv")
  //</editor-fold>
  public SubobjectDesignator /*&*/ getLValueDesignator() {
    return Designator;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::getLValueDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1079,
   FQN="(anonymous namespace)::LValue::getLValueDesignator", NM="_ZNK12_GLOBAL__N_16LValue19getLValueDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_16LValue19getLValueDesignatorEv")
  //</editor-fold>
  public /*const*/ SubobjectDesignator /*&*/ getLValueDesignator$Const() /*const*/ {
    return Designator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::moveInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1081,
   FQN="(anonymous namespace)::LValue::moveInto", NM="_ZNK12_GLOBAL__N_16LValue8moveIntoERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_16LValue8moveIntoERN5clang7APValueE")
  //</editor-fold>
  public void moveInto(final APValue /*&*/ V) /*const*/ {
    if (Designator.Invalid) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(V.$assign($c$.track(new APValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base), Offset, new APValue.NoLValuePath(), CallIndex))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(V.$assign($c$.track(new APValue(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(Base), Offset, new ArrayRef<APValue.LValuePathEntry>(Designator.Entries, false), 
                Designator.IsOnePastTheEnd, CallIndex))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::setFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1088,
   FQN="(anonymous namespace)::LValue::setFrom", NM="_ZN12_GLOBAL__N_16LValue7setFromERN5clang10ASTContextERKNS1_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue7setFromERN5clang10ASTContextERKNS1_7APValueE")
  //</editor-fold>
  public void setFrom(final ASTContext /*&*/ Ctx, final /*const*/ APValue /*&*/ V) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (V.isLValue());
      Base.$assign(V.getLValueBase());
      Offset.$assign(V.getLValueOffset$Const());
      InvalidBase = false;
      CallIndex = V.getLValueCallIndex();
      $c$.clean(Designator.$assignMove($c$.track(new SubobjectDesignator(Ctx, V))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1097,
   FQN="(anonymous namespace)::LValue::set", NM="_ZN12_GLOBAL__N_16LValue3setEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue3setEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEEjb")
  //</editor-fold>
  public void set(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B) {
    set(B, 0, false);
  }
  public void set(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, /*uint*/int I/*= 0*/) {
    set(B, I, false);
  }
  public void set(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, /*uint*/int I/*= 0*/, boolean BInvalid/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Base.$assign(B);
      Offset.$assignMove(CharUnits.Zero());
      InvalidBase = BInvalid;
      CallIndex = I;
      $c$.clean(Designator.$assignMove($c$.track(new SubobjectDesignator(getType(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(B))))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::setInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1105,
   FQN="(anonymous namespace)::LValue::setInvalid", NM="_ZN12_GLOBAL__N_16LValue10setInvalidEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue10setInvalidEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEEj")
  //</editor-fold>
  public void setInvalid(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B) {
    setInvalid(B, 0);
  }
  public void setInvalid(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > B, /*uint*/int I/*= 0*/) {
    set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(B), I, true);
  }

  
  // Check that this LValue is not based on a null pointer. If it is, produce
  // a diagnostic and mark the designator as invalid.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::checkNullPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1111,
   FQN="(anonymous namespace)::LValue::checkNullPointer", NM="_ZN12_GLOBAL__N_16LValue16checkNullPointerERNS_8EvalInfoEPKN5clang4ExprENS_18CheckSubobjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue16checkNullPointerERNS_8EvalInfoEPKN5clang4ExprENS_18CheckSubobjectKindE")
  //</editor-fold>
  public boolean checkNullPointer(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                  CheckSubobjectKind CSK) {
    if (Designator.Invalid) {
      return false;
    }
    if (!Base.$bool()) {
      Info.CCEDiag(E, diag.note_constexpr_null_subobject).$out$T(
          CSK
      );
      Designator.setInvalid();
      return false;
    }
    return true;
  }

  
  // Check this LValue refers to an object. If not, set the designator to be
  // invalid and emit a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::checkSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1126,
   FQN="(anonymous namespace)::LValue::checkSubobject", NM="_ZN12_GLOBAL__N_16LValue14checkSubobjectERNS_8EvalInfoEPKN5clang4ExprENS_18CheckSubobjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue14checkSubobjectERNS_8EvalInfoEPKN5clang4ExprENS_18CheckSubobjectKindE")
  //</editor-fold>
  public boolean checkSubobject(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, CheckSubobjectKind CSK) {
    return (CSK == CheckSubobjectKind.CSK_ArrayToPointer || checkNullPointer(Info, E, CSK))
       && Designator.checkSubobject(Info, E, CSK);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1131,
   FQN="(anonymous namespace)::LValue::addDecl", NM="_ZN12_GLOBAL__N_16LValue7addDeclERNS_8EvalInfoEPKN5clang4ExprEPKNS3_4DeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue7addDeclERNS_8EvalInfoEPKN5clang4ExprEPKNS3_4DeclEb")
  //</editor-fold>
  public void addDecl(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
         /*const*/ Decl /*P*/ D) {
    addDecl(Info, E, 
         D, false);
  }
  public void addDecl(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
         /*const*/ Decl /*P*/ D, boolean Virtual/*= false*/) {
    if (checkSubobject(Info, E, isa_FieldDecl(D) ? CheckSubobjectKind.CSK_Field : CheckSubobjectKind.CSK_Base)) {
      Designator.addDeclUnchecked(D, Virtual);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::addArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1136,
   FQN="(anonymous namespace)::LValue::addArray", NM="_ZN12_GLOBAL__N_16LValue8addArrayERNS_8EvalInfoEPKN5clang4ExprEPKNS3_17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue8addArrayERNS_8EvalInfoEPKN5clang4ExprEPKNS3_17ConstantArrayTypeE")
  //</editor-fold>
  public void addArray(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, /*const*/ ConstantArrayType /*P*/ CAT) {
    if (checkSubobject(Info, E, CheckSubobjectKind.CSK_ArrayToPointer)) {
      Designator.addArrayUnchecked(CAT);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::addComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1140,
   FQN="(anonymous namespace)::LValue::addComplex", NM="_ZN12_GLOBAL__N_16LValue10addComplexERNS_8EvalInfoEPKN5clang4ExprENS3_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue10addComplexERNS_8EvalInfoEPKN5clang4ExprENS3_8QualTypeEb")
  //</editor-fold>
  public void addComplex(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, QualType EltTy, boolean Imag) {
    if (checkSubobject(Info, E, Imag ? CheckSubobjectKind.CSK_Imag : CheckSubobjectKind.CSK_Real)) {
      Designator.addComplexUnchecked(new QualType(EltTy), Imag);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::adjustIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1144,
   FQN="(anonymous namespace)::LValue::adjustIndex", NM="_ZN12_GLOBAL__N_16LValue11adjustIndexERNS_8EvalInfoEPKN5clang4ExprEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValue11adjustIndexERNS_8EvalInfoEPKN5clang4ExprEy")
  //</editor-fold>
  public void adjustIndex(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, long/*uint64_t*/ N) {
    if ((N != 0) && checkNullPointer(Info, E, CheckSubobjectKind.CSK_ArrayIndex)) {
      Designator.adjustIndex(Info, E, N);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::LValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1067,
   FQN="(anonymous namespace)::LValue::LValue", NM="_ZN12_GLOBAL__N_16LValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValueC1Ev")
  //</editor-fold>
  public /*inline*/ LValue() {
    // : Base(), Offset(), Designator() 
    //START JInit
    this.Base = new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(/*const*/ ValueDecl /*P*/.class);
    this.Offset = new CharUnits();
    this.Designator = new SubobjectDesignator();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::LValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1067,
   FQN="(anonymous namespace)::LValue::LValue", NM="_ZN12_GLOBAL__N_16LValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValueC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LValue(final /*const*/ LValue /*&*/ $Prm0) {
    // : Base(.Base), Offset(.Offset), InvalidBase(.InvalidBase), CallIndex(.CallIndex), Designator(.Designator) 
    //START JInit
    this.Base = new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >($Prm0.Base);
    this.Offset = new CharUnits($Prm0.Offset);
    this.InvalidBase = $Prm0.InvalidBase;
    this.CallIndex = $Prm0.CallIndex;
    this.Designator = new SubobjectDesignator($Prm0.Designator);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::~LValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1067,
   FQN="(anonymous namespace)::LValue::~LValue", NM="_ZN12_GLOBAL__N_16LValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValueD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Designator.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1067,
   FQN="(anonymous namespace)::LValue::operator=", NM="_ZN12_GLOBAL__N_16LValueaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_16LValueaSERKS0_")
  //</editor-fold>
  public /*inline*/ LValue /*&*/ $assign(final /*const*/ LValue /*&*/ $Prm0) {
    this.Base.$assign($Prm0.Base);
    this.Offset.$assign($Prm0.Offset);
    this.InvalidBase = $Prm0.InvalidBase;
    this.CallIndex = $Prm0.CallIndex;
    this.Designator.$assign($Prm0.Designator);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", InvalidBase=" + InvalidBase // NOI18N
              + ", CallIndex=" + CallIndex // NOI18N
              + ", Designator=" + Designator; // NOI18N
  }
}
