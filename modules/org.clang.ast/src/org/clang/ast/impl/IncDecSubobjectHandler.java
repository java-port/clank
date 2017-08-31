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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3058,
 FQN="(anonymous namespace)::IncDecSubobjectHandler", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandlerE")
//</editor-fold>
public class/*struct*/ IncDecSubobjectHandler implements SubobjectHandler {
  public final EvalInfo /*&*/ Info;
  public /*const*/ Expr /*P*/ E;
  public AccessKinds AccessKind;
  public APValue /*P*/ Old;
  
  /*typedef bool result_type*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::checkConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3066,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::checkConst", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler10checkConstEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler10checkConstEN5clang8QualTypeE")
  //</editor-fold>
  public boolean checkConst(QualType QT) {
    // Assigning to a const object has undefined behavior.
    if (QT.isConstQualified()) {
      Info.FFDiag(E, diag.note_constexpr_modify_const_type).$out$T(QT);
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3075,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::failed", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler6failedEv")
  //</editor-fold>
  public boolean failed() {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3076,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::found", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler5foundERN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler5foundERN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  public boolean found(final APValue /*&*/ Subobj, QualType SubobjType) {
    // Stash the old value. Also clear Old, so we don't clobber it later
    // if we're post-incrementing a complex.
    if ((Old != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(/*Deref*/Old.$assign($c$.track(new APValue(Subobj))));
        Old = null;
      } finally {
        $c$.$destroy();
      }
    }
    switch (Subobj.getKind()) {
     case Int:
      return found(Subobj.getInt(), new QualType(SubobjType));
     case Float:
      return found(Subobj.getFloat(), new QualType(SubobjType));
     case ComplexInt:
      return found(Subobj.getComplexIntReal(), 
          SubobjType.$arrow().castAs(ComplexType.class).getElementType().
              withCVRQualifiers(SubobjType.getCVRQualifiers()));
     case ComplexFloat:
      return found(Subobj.getComplexFloatReal(), 
          SubobjType.$arrow().castAs(ComplexType.class).getElementType().
              withCVRQualifiers(SubobjType.getCVRQualifiers()));
     case LValue:
      return foundPointer(Subobj, new QualType(SubobjType));
     default:
      // FIXME: can this happen?
      Info.FFDiag(E);
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3105,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::found", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler5foundERN4llvm6APSIntEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler5foundERN4llvm6APSIntEN5clang8QualTypeE")
  //</editor-fold>
  public boolean found(final APSInt /*&*/ Value, QualType SubobjType) {
    if (!checkConst(new QualType(SubobjType))) {
      return false;
    }
    if (!SubobjType.$arrow().isIntegerType()) {
      // We don't support increment / decrement on integer-cast-to-pointer
      // values.
      Info.FFDiag(E);
      return false;
    }
    if ((Old != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(/*Deref*/Old.$assign($c$.track(new APValue(new APSInt(Value)))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // bool arithmetic promotes to int, and the conversion back to bool
    // doesn't reduce mod 2^n, so special-case it.
    if (SubobjType.$arrow().isBooleanType()) {
      if (AccessKind == AccessKinds.AK_Increment) {
        Value.$assign($int2ulong(1));
      } else {
        Value.$assign(/*KEEP_BOOL*/Value.$not());
      }
      return true;
    }
    
    boolean WasNegative = Value.isNegative();
    if (AccessKind == AccessKinds.AK_Increment) {
      Value.$preInc();
      if (!WasNegative && Value.isNegative()
         && isOverflowingIntegerType(Info.Ctx, new QualType(SubobjType))) {
        APSInt ActualValue/*J*/= new APSInt(new APInt(Value), /*IsUnsigned*/ true);
        return HandleOverflow(Info, E, ActualValue, new QualType(SubobjType));
      }
    } else {
      Value.$preDec();
      if (WasNegative && !Value.isNegative()
         && isOverflowingIntegerType(Info.Ctx, new QualType(SubobjType))) {
        /*uint*/int BitWidth = Value.getBitWidth();
        APSInt ActualValue/*J*/= new APSInt(Value.sext(BitWidth + 1), /*IsUnsigned*/ false);
        ActualValue.setBit(BitWidth);
        return HandleOverflow(Info, E, ActualValue, new QualType(SubobjType));
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3150,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::found", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler5foundERN4llvm7APFloatEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler5foundERN4llvm7APFloatEN5clang8QualTypeE")
  //</editor-fold>
  public boolean found(final APFloat /*&*/ Value, QualType SubobjType) {
    if (!checkConst(new QualType(SubobjType))) {
      return false;
    }
    if ((Old != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(/*Deref*/Old.$assign($c$.track(new APValue(new APFloat(Value)))));
      } finally {
        $c$.$destroy();
      }
    }
    
    APFloat One/*J*/= new APFloat(Value.getSemantics(), $int2ulong(1));
    if (AccessKind == AccessKinds.AK_Increment) {
      Value.add(One, APFloat.roundingMode.rmNearestTiesToEven);
    } else {
      Value.subtract(One, APFloat.roundingMode.rmNearestTiesToEven);
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::foundPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3163,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::foundPointer", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler12foundPointerERN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler12foundPointerERN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  public boolean foundPointer(final APValue /*&*/ Subobj, QualType SubobjType) {
    LValue LVal = null;
    try {
      if (!checkConst(new QualType(SubobjType))) {
        return false;
      }
      
      QualType PointeeType/*J*/= new QualType();
      {
        /*const*/ PointerType /*P*/ PT = SubobjType.$arrow().getAs(PointerType.class);
        if ((PT != null)) {
          PointeeType.$assignMove(PT.getPointeeType());
        } else {
          Info.FFDiag(E);
          return false;
        }
      }
      
      LVal/*J*/= new LValue();
      LVal.setFrom(Info.Ctx, Subobj);
      if (!HandleLValueArrayAdjustment(Info, E, LVal, new QualType(PointeeType), 
          AccessKind == AccessKinds.AK_Increment ? 1 : -1)) {
        return false;
      }
      LVal.moveInto(Subobj);
      return true;
    } finally {
      if (LVal != null) { LVal.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IncDecSubobjectHandler::foundString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3183,
   FQN="(anonymous namespace)::IncDecSubobjectHandler::foundString", NM="_ZN12_GLOBAL__N_122IncDecSubobjectHandler11foundStringERN5clang7APValueENS1_8QualTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122IncDecSubobjectHandler11foundStringERN5clang7APValueENS1_8QualTypeEy")
  //</editor-fold>
  public boolean foundString(final APValue /*&*/ Subobj, QualType SubobjType, long/*uint64_t*/ Character) {
    throw new llvm_unreachable("shouldn't encounter string elements here");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public AccessKinds AccessKind() {return AccessKind;}

  public IncDecSubobjectHandler(EvalInfo I, Expr E, AccessKinds AK, APValue Old) { this.Info = I; this.E = E; this.AccessKind = AK; this.Old = Old; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", E=" + E // NOI18N
              + ", AccessKind=" + AccessKind // NOI18N
              + ", Old=" + Old; // NOI18N
  }
}
