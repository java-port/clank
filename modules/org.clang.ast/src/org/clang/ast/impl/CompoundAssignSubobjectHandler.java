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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2940,
 FQN="(anonymous namespace)::CompoundAssignSubobjectHandler", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandlerE")
//</editor-fold>
public class/*struct*/ CompoundAssignSubobjectHandler implements SubobjectHandler {
  public final EvalInfo /*&*/ Info;
  public /*const*/ Expr /*P*/ E;
  public QualType PromotedLHSType;
  public BinaryOperatorKind Opcode;
  public final /*const*/ APValue /*&*/ RHS;
  
  // end anonymous namespace
  public static /*const*/ AccessKinds AccessKind = AccessKinds.AK_Assign;
  
  /*typedef bool result_type*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::checkConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2951,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::checkConst", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler10checkConstEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler10checkConstEN5clang8QualTypeE")
  //</editor-fold>
  public boolean checkConst(QualType QT) {
    // Assigning to a const object has undefined behavior.
    if (QT.isConstQualified()) {
      Info.FFDiag(E, diag.note_constexpr_modify_const_type).$out$T(QT);
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2960,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::failed", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler6failedEv")
  //</editor-fold>
  public boolean failed() {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2961,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::found", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler5foundERN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler5foundERN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  public boolean found(final APValue /*&*/ Subobj, QualType SubobjType) {
    switch (Subobj.getKind()) {
     case Int:
      return found(Subobj.getInt(), new QualType(SubobjType));
     case Float:
      return found(Subobj.getFloat(), new QualType(SubobjType));
     case ComplexInt:
     case ComplexFloat:
      // FIXME: Implement complex compound assignment.
      Info.FFDiag(E);
      return false;
     case LValue:
      return foundPointer(Subobj, new QualType(SubobjType));
     default:
      // FIXME: can this happen?
      Info.FFDiag(E);
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2980,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::found", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler5foundERN4llvm6APSIntEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler5foundERN4llvm6APSIntEN5clang8QualTypeE")
  //</editor-fold>
  public boolean found(final APSInt /*&*/ Value, QualType SubobjType) {
    if (!checkConst(new QualType(SubobjType))) {
      return false;
    }
    if (!SubobjType.$arrow().isIntegerType() || !RHS.isInt()) {
      // We don't support compound assignment on integer-cast-to-pointer
      // values.
      Info.FFDiag(E);
      return false;
    }
    
    APSInt LHS = HandleIntToIntCast(Info, E, new QualType(PromotedLHSType), 
        new QualType(SubobjType), Value);
    if (!handleIntIntBinOp(Info, E, LHS, Opcode, new APSInt(RHS.getInt$Const()), LHS)) {
      return false;
    }
    Value.$assignMove(HandleIntToIntCast(Info, E, new QualType(SubobjType), new QualType(PromotedLHSType), LHS));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::found">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2998,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::found", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler5foundERN4llvm7APFloatEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler5foundERN4llvm7APFloatEN5clang8QualTypeE")
  //</editor-fold>
  public boolean found(final APFloat /*&*/ Value, QualType SubobjType) {
    return checkConst(new QualType(SubobjType))
       && HandleFloatToFloatCast(Info, E, new QualType(SubobjType), new QualType(PromotedLHSType), 
        Value)
       && handleFloatFloatBinOp(Info, E, Value, Opcode, RHS.getFloat$Const())
       && HandleFloatToFloatCast(Info, E, new QualType(PromotedLHSType), new QualType(SubobjType), Value);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::foundPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3005,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::foundPointer", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler12foundPointerERN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler12foundPointerERN5clang7APValueENS1_8QualTypeE")
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
        }
      }
      if (PointeeType.isNull() || !RHS.isInt()
         || (Opcode != BinaryOperatorKind.BO_Add && Opcode != BinaryOperatorKind.BO_Sub)) {
        Info.FFDiag(E);
        return false;
      }
      
      long/*int64_t*/ Offset = getExtValue(RHS.getInt$Const());
      if (Opcode == BinaryOperatorKind.BO_Sub) {
        Offset = -Offset;
      }
      
      LVal/*J*/= new LValue();
      LVal.setFrom(Info.Ctx, Subobj);
      if (!HandleLValueArrayAdjustment(Info, E, LVal, new QualType(PointeeType), Offset)) {
        return false;
      }
      LVal.moveInto(Subobj);
      return true;
    } finally {
      if (LVal != null) { LVal.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompoundAssignSubobjectHandler::foundString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 3030,
   FQN="(anonymous namespace)::CompoundAssignSubobjectHandler::foundString", NM="_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler11foundStringERN5clang7APValueENS1_8QualTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_130CompoundAssignSubobjectHandler11foundStringERN5clang7APValueENS1_8QualTypeEy")
  //</editor-fold>
  public boolean foundString(final APValue /*&*/ Subobj, QualType SubobjType, long/*uint64_t*/ Character) {
    throw new llvm_unreachable("shouldn't encounter string elements here");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public AccessKinds AccessKind() {return AccessKind;}
  
  public CompoundAssignSubobjectHandler(EvalInfo I, Expr E, QualType Q, BinaryOperatorKind O, APValue R) {this.Info = I; this.E = E; this.PromotedLHSType = Q; this.Opcode = O; this.RHS = R;}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", E=" + E // NOI18N
              + ", PromotedLHSType=" + PromotedLHSType // NOI18N
              + ", Opcode=" + Opcode // NOI18N
              + ", RHS=" + RHS; // NOI18N
  }
}
