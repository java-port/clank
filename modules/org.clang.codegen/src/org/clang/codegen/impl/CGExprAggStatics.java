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
package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGExprAggStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL12findPeepholePN5clang4ExprENS_8CastKindE;_ZL12isSimpleZeroPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE;_ZL13isBlockVarRefPKN5clang4ExprE;_ZL15isTrivialFillerPN5clang4ExprE;_ZL24CheckAggExprForMemSetUseRN5clang7CodeGen12AggValueSlotEPKNS_4ExprERNS0_15CodeGenFunctionE;_ZL24GetNumNonZeroBytesInInitPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE; -static-type=CGExprAggStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExprAggStatics {


/// \brief Determine if E is a trivial array filler, that is, one that is
/// equivalent to zero-initialization.
//<editor-fold defaultstate="collapsed" desc="isTrivialFiller">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 380,
 FQN="isTrivialFiller", NM="_ZL15isTrivialFillerPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL15isTrivialFillerPN5clang4ExprE")
//</editor-fold>
public static boolean isTrivialFiller(Expr /*P*/ E) {
  if (!(E != null)) {
    return true;
  }
  if (isa_ImplicitValueInitExpr(E)) {
    return true;
  }
  {
    
    InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(E);
    if ((ILE != null)) {
      if ((ILE.getNumInits() != 0)) {
        return false;
      }
      return isTrivialFiller(ILE.getArrayFiller());
    }
  }
  {
    
    CXXConstructExpr /*P*/ Cons = dyn_cast_or_null_CXXConstructExpr(E);
    if ((Cons != null)) {
      return Cons.getConstructor().isDefaultConstructor()
         && Cons.getConstructor().isTrivial();
    }
  }
  
  // FIXME: Are there other cases where we can avoid emitting an initializer?
  return false;
}


/// Attempt to look through various unimportant expressions to find a
/// cast of the given kind.
//<editor-fold defaultstate="collapsed" desc="findPeephole">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 562,
 FQN="findPeephole", NM="_ZL12findPeepholePN5clang4ExprENS_8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL12findPeepholePN5clang4ExprENS_8CastKindE")
//</editor-fold>
public static Expr /*P*/ findPeephole(Expr /*P*/ op, CastKind kind) {
  while (true) {
    op = op.IgnoreParens();
    {
      CastExpr /*P*/ castE = dyn_cast_CastExpr(op);
      if ((castE != null)) {
        if (castE.getCastKind() == kind) {
          return castE.getSubExpr();
        }
        if (castE.getCastKind() == CastKind.CK_NoOp) {
          continue;
        }
      }
    }
    return null;
  }
}


/// Is the value of the given expression possibly a reference to or
/// into a __block variable?
//<editor-fold defaultstate="collapsed" desc="isBlockVarRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 797,
 FQN="isBlockVarRef", NM="_ZL13isBlockVarRefPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL13isBlockVarRefPKN5clang4ExprE")
//</editor-fold>
public static boolean isBlockVarRef(/*const*/ Expr /*P*/ E) {
  // Make sure we look through parens.
  E = E.IgnoreParens$Const();
  {
    
    // Check for a direct reference to a __block variable.
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      /*const*/ VarDecl /*P*/ var = dyn_cast_VarDecl(DRE.getDecl$Const());
      return ((var != null) && var.hasAttr(BlocksAttr.class));
    }
  }
  {
    
    // More complicated stuff.
    
    // Binary operators.
    /*const*/ org.clang.ast.BinaryOperator /*P*/ op = dyn_cast_BinaryOperator(E);
    if ((op != null)) {
      // For an assignment or pointer-to-member operation, just care
      // about the LHS.
      if (op.isAssignmentOp() || op.isPtrMemOp()) {
        return isBlockVarRef(op.getLHS());
      }
      
      // For a comma, just care about the RHS.
      if (op.getOpcode() == BinaryOperatorKind.BO_Comma) {
        return isBlockVarRef(op.getRHS());
      }
      
      // FIXME: pointer arithmetic?
      return false;
      // Check both sides of a conditional operator.
    } else {
      /*const*/ AbstractConditionalOperator /*P*/ op$1 = dyn_cast_AbstractConditionalOperator(E);
      if ((op$1 != null)) {
        return isBlockVarRef(op$1.getTrueExpr())
           || isBlockVarRef(op$1.getFalseExpr());
        // OVEs are required to support BinaryConditionalOperators.
      } else {
        /*const*/ OpaqueValueExpr /*P*/ op$2 = dyn_cast_OpaqueValueExpr(E);
        if ((op$2 != null)) {
          {
            /*const*/ Expr /*P*/ src = op$2.getSourceExpr();
            if ((src != null)) {
              return isBlockVarRef(src);
            }
          }
          // Casts are necessary to get things like (*(int*)&var) = foo().
          // We don't really care about the kind of cast here, except
          // we don't want to look through l2r casts, because it's okay
          // to get the *value* in a __block variable.
        } else {
          /*const*/ CastExpr /*P*/ cast = dyn_cast_CastExpr(E);
          if ((cast != null)) {
            if (cast.getCastKind() == CastKind.CK_LValueToRValue) {
              return false;
            }
            return isBlockVarRef(cast.getSubExpr$Const());
            // Handle unary operators.  Again, just aggressively look through
            // it, ignoring the operation.
          } else {
            /*const*/ UnaryOperator /*P*/ uop = dyn_cast_UnaryOperator(E);
            if ((uop != null)) {
              return isBlockVarRef(uop.getSubExpr());
              // Look into the base of a field access.
            } else {
              /*const*/ MemberExpr /*P*/ mem = dyn_cast_MemberExpr(E);
              if ((mem != null)) {
                return isBlockVarRef(mem.getBase());
                // Look into the base of a subscript.
              } else {
                /*const*/ ArraySubscriptExpr /*P*/ sub = dyn_cast_ArraySubscriptExpr(E);
                if ((sub != null)) {
                  return isBlockVarRef(sub.getBase$Const());
                }
              }
            }
          }
        }
      }
    }
  }
  
  return false;
}


/// isSimpleZero - If emitting this value will obviously just cause a store of
/// zero to memory, return true.  This can return false if uncertain, so it just
/// handles simple cases.
//<editor-fold defaultstate="collapsed" desc="isSimpleZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1037,
 FQN="isSimpleZero", NM="_ZL12isSimpleZeroPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL12isSimpleZeroPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static boolean isSimpleZero(/*const*/ Expr /*P*/ E, final CodeGenFunction /*&*/ CGF) {
  E = E.IgnoreParens$Const();
  {
    
    // 0
    /*const*/ IntegerLiteral /*P*/ IL = dyn_cast_IntegerLiteral(E);
    if ((IL != null)) {
      return IL.getValue().$eq($int2ulong(0));
    }
  }
  {
    // +0.0
    /*const*/ FloatingLiteral /*P*/ FL = dyn_cast_FloatingLiteral(E);
    if ((FL != null)) {
      return FL.getValue().isPosZero();
    }
  }
  // int()
  if ((isa_ImplicitValueInitExpr(E) || isa_CXXScalarValueInitExpr(E))
     && CGF.getTypes().isZeroInitializable(E.getType())) {
    return true;
  }
  {
    // (int*)0 - Null pointer expressions.
    /*const*/ CastExpr /*P*/ ICE = dyn_cast_CastExpr(E);
    if ((ICE != null)) {
      return ICE.getCastKind() == CastKind.CK_NullToPointer;
    }
  }
  {
    // '\0'
    /*const*/ CharacterLiteral /*P*/ CL = dyn_cast_CharacterLiteral(E);
    if ((CL != null)) {
      return CL.getValue() == 0;
    }
  }
  
  // Otherwise, hard case: conservatively return false.
  return false;
}


//===----------------------------------------------------------------------===//
//                        Entry Points into this File
//===----------------------------------------------------------------------===//

/// GetNumNonZeroBytesInInit - Get an approximate count of the number of
/// non-zero bytes that will be stored when outputting the initializer for the
/// specified initializer expression.
//<editor-fold defaultstate="collapsed" desc="GetNumNonZeroBytesInInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1334,
 FQN="GetNumNonZeroBytesInInit", NM="_ZL24GetNumNonZeroBytesInInitPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL24GetNumNonZeroBytesInInitPKN5clang4ExprERNS_7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static CharUnits GetNumNonZeroBytesInInit(/*const*/ Expr /*P*/ E, final CodeGenFunction /*&*/ CGF) {
  E = E.IgnoreParens$Const();
  
  // 0 and 0.0 won't require any non-zero stores!
  if (isSimpleZero(E, CGF)) {
    return CharUnits.Zero();
  }
  
  // If this is an initlist expr, sum up the size of sizes of the (present)
  // elements.  If this is something weird, assume the whole thing is non-zero.
  /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(E);
  if (!(ILE != null) || !CGF.getTypes().isZeroInitializable(ILE.getType())) {
    return CGF.getContext().getTypeSizeInChars(E.getType());
  }
  {
    
    // InitListExprs for structs have to be handled carefully.  If there are
    // reference members, we need to consider the size of the reference, not the
    // referencee.  InitListExprs for unions and arrays can't have references.
    /*const*/ RecordType /*P*/ RT = E.getType().$arrow().getAs$RecordType();
    if ((RT != null)) {
      if (!RT.isUnionType()) {
        RecordDecl /*P*/ SD = E.getType().$arrow().getAs$RecordType().getDecl();
        CharUnits NumNonZeroBytes = CharUnits.Zero();
        
        /*uint*/int ILEElement = 0;
        {
          CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(SD);
          if ((CXXRD != null)) {
            while (ILEElement != CXXRD.getNumBases()) {
              NumNonZeroBytes.$addassign(
                  GetNumNonZeroBytesInInit(ILE.getInit$Const(ILEElement++), CGF)
              );
            }
          }
        }
        for (/*const*/ FieldDecl /*P*/ Field : SD.fields()) {
          // We're done once we hit the flexible array member or run out of
          // InitListExpr elements.
          if (Field.getType().$arrow().isIncompleteArrayType()
             || ILEElement == ILE.getNumInits()) {
            break;
          }
          if (Field.isUnnamedBitfield()) {
            continue;
          }
          
          /*const*/ Expr /*P*/ E$1 = ILE.getInit$Const(ILEElement++);
          
          // Reference values are always non-null and have the width of a pointer.
          if (Field.getType().$arrow().isReferenceType()) {
            NumNonZeroBytes.$addassign(CGF.getContext().toCharUnitsFromBits(CGF.getTarget().getPointerWidth(0)));
          } else {
            NumNonZeroBytes.$addassign(GetNumNonZeroBytesInInit(E$1, CGF));
          }
        }
        
        return NumNonZeroBytes;
      }
    }
  }
  
  CharUnits NumNonZeroBytes = CharUnits.Zero();
  for (/*uint*/int i = 0, e = ILE.getNumInits(); i != e; ++i)  {
    NumNonZeroBytes.$addassign(GetNumNonZeroBytesInInit(ILE.getInit$Const(i), CGF));
  }
  return NumNonZeroBytes;
}


/// CheckAggExprForMemSetUse - If the initializer is large and has a lot of
/// zeros in it, emit a memset and avoid storing the individual zeros.
///
//<editor-fold defaultstate="collapsed" desc="CheckAggExprForMemSetUse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp", line = 1392,
 FQN="CheckAggExprForMemSetUse", NM="_ZL24CheckAggExprForMemSetUseRN5clang7CodeGen12AggValueSlotEPKNS_4ExprERNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprAgg.cpp -nm=_ZL24CheckAggExprForMemSetUseRN5clang7CodeGen12AggValueSlotEPKNS_4ExprERNS0_15CodeGenFunctionE")
//</editor-fold>
public static void CheckAggExprForMemSetUse(final AggValueSlot /*&*/ Slot, /*const*/ Expr /*P*/ E, 
                        final CodeGenFunction /*&*/ CGF) {
  // If the slot is already known to be zeroed, nothing to do.  Don't mess with
  // volatile stores.
  if ((Slot.isZeroed().getValue() != 0) || Slot.isVolatile() || !Slot.getAddress().isValid()) {
    return;
  }
  
  // C++ objects with a user-declared constructor don't need zero'ing.
  if (CGF.getLangOpts().CPlusPlus) {
    {
      /*const*/ RecordType /*P*/ RT = CGF.getContext().
          getBaseElementType(E.getType()).$arrow().getAs$RecordType();
      if ((RT != null)) {
        /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
        if (RD.hasUserDeclaredConstructor()) {
          return;
        }
      }
    }
  }
  
  // If the type is 16-bytes or smaller, prefer individual stores over memset.
  CharUnits Size = CGF.getContext().getTypeSizeInChars(E.getType());
  if (Size.$lesseq(CharUnits.fromQuantity(16))) {
    return;
  }
  
  // Check to see if over 3/4 of the initializer are known to be zero.  If so,
  // we prefer to emit memset + individual stores for the rest.
  CharUnits NumNonZeroBytes = GetNumNonZeroBytesInInit(E, CGF);
  if (NumNonZeroBytes.$star(4).$greater(Size)) {
    return;
  }
  
  // Okay, it seems like a good idea to use an initial memset, emit the call.
  Constant /*P*/ SizeVal = CGF.Builder.getInt64(Size.getQuantity());
  
  Address Loc = Slot.getAddress();
  Loc.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Loc), CGF.Int8Ty));
  CGF.Builder.CreateMemSet(new Address(Loc), CGF.Builder.getInt8($int2uchar(0)), SizeVal, false);
  
  // Tell the AggExprEmitter that the slot is known zero.
  Slot.setZeroed();
}

} // END OF class CGExprAggStatics
