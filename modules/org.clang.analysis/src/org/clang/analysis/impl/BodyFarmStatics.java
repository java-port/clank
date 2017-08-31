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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type BodyFarmStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL15findBackingIvarPKN5clang16ObjCPropertyDeclE;_ZL15isDispatchBlockN5clang8QualTypeE;_ZL20create_dispatch_onceRN5clang10ASTContextEPKNS_12FunctionDeclE;_ZL20create_dispatch_syncRN5clang10ASTContextEPKNS_12FunctionDeclE;_ZL24createObjCPropertyGetterRN5clang10ASTContextEPKNS_16ObjCPropertyDeclE;_ZL29create_OSAtomicCompareAndSwapRN5clang10ASTContextEPKNS_12FunctionDeclE; -static-type=BodyFarmStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class BodyFarmStatics {


//===----------------------------------------------------------------------===//
// Helper creation functions for constructing faux ASTs.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isDispatchBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 29,
 FQN="isDispatchBlock", NM="_ZL15isDispatchBlockN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL15isDispatchBlockN5clang8QualTypeE")
//</editor-fold>
public static boolean isDispatchBlock(QualType Ty) {
  // Is it a block pointer?
  /*const*/ BlockPointerType /*P*/ BPT = Ty.$arrow().getAs(BlockPointerType.class);
  if (!(BPT != null)) {
    return false;
  }
  
  // Check if the block pointer type takes no arguments and
  // returns void.
  /*const*/ FunctionProtoType /*P*/ FT = BPT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
  return (FT != null) && FT.getReturnType().$arrow().isVoidType() && FT.getNumParams() == 0;
}


/// Create a fake body for dispatch_once.
//<editor-fold defaultstate="collapsed" desc="create_dispatch_once">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 171,
 FQN="create_dispatch_once", NM="_ZL20create_dispatch_onceRN5clang10ASTContextEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL20create_dispatch_onceRN5clang10ASTContextEPKNS_12FunctionDeclE")
//</editor-fold>
public static Stmt /*P*/ create_dispatch_once(final ASTContext /*&*/ C, /*const*/ FunctionDecl /*P*/ D) {
  // Check if we have at least two parameters.
  if (D.param_size() != 2) {
    return null;
  }
  
  // Check if the first parameter is a pointer to integer type.
  /*const*/ ParmVarDecl /*P*/ Predicate = D.getParamDecl$Const(0);
  QualType PredicateQPtrTy = Predicate.getType();
  /*const*/ PointerType /*P*/ PredicatePtrTy = PredicateQPtrTy.$arrow().getAs(PointerType.class);
  if (!(PredicatePtrTy != null)) {
    return null;
  }
  QualType PredicateTy = PredicatePtrTy.getPointeeType();
  if (!PredicateTy.$arrow().isIntegerType()) {
    return null;
  }
  
  // Check if the second parameter is the proper block type.
  /*const*/ ParmVarDecl /*P*/ Block = D.getParamDecl$Const(1);
  QualType Ty = Block.getType();
  if (!isDispatchBlock(new QualType(Ty))) {
    return null;
  }
  
  // Everything checks out.  Create a fakse body that checks the predicate,
  // sets it, and calls the block.  Basically, an AST dump of:
  //
  // void dispatch_once(dispatch_once_t *predicate, dispatch_block_t block) {
  //  if (!*predicate) {
  //    *predicate = 1;
  //    block();
  //  }
  // }
  ASTMaker M/*J*/= new ASTMaker(C);
  
  // (1) Create the call.
  DeclRefExpr /*P*/ DR = M.makeDeclRefExpr(Block);
  ImplicitCastExpr /*P*/ ICE = M.makeLvalueToRvalue(DR, new QualType(Ty));
  CallExpr /*P*/ CE = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
      return new CallExpr(C, ICE, new ArrayRef<Expr /*P*/ >(None, true), C.VoidTy.$QualType(), ExprValueKind.VK_RValue, 
              new SourceLocation());
   });
  
  // (2) Create the assignment to the predicate.
  IntegerLiteral /*P*/ IL = IntegerLiteral.Create(C, new APInt($ulong2uint(C.getTypeSize(C.IntTy.$QualType())), (long/*uint64_t*/)$int2ulong(1)), 
      C.IntTy.$QualType(), new SourceLocation());
  BinaryOperator /*P*/ B = M.makeAssignment(M.makeDereference(M.makeLvalueToRvalue(M.makeDeclRefExpr(Predicate), new QualType(PredicateQPtrTy)), 
          new QualType(PredicateTy)), 
      M.makeIntegralCast(IL, new QualType(PredicateTy)), 
      new QualType(PredicateTy));
  
  // (3) Create the compound statement.
  Stmt /*P*/ Stmts[/*2*/] = new Stmt /*P*/  [/*2*/] {B, CE};
  CompoundStmt /*P*/ CS = M.makeCompound(new ArrayRef<Stmt /*P*/ >(Stmts, true));
  
  // (4) Create the 'if' condition.
  ImplicitCastExpr /*P*/ LValToRval = M.makeLvalueToRvalue(M.makeDereference(M.makeLvalueToRvalue(M.makeDeclRefExpr(Predicate), 
              new QualType(PredicateQPtrTy)), 
          new QualType(PredicateTy)), 
      new QualType(PredicateTy));
  
  UnaryOperator /*P*/ UO = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
      return new UnaryOperator(LValToRval, UnaryOperatorKind.UO_LNot, C.IntTy.$QualType(), 
              ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
              new SourceLocation());
   });
  
  // (5) Create the 'if' statement.
  IfStmt /*P*/ If = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
      return new IfStmt(C, new SourceLocation(), false, (Stmt /*P*/ )null, (VarDecl /*P*/ )null, 
              UO, CS);
   });
  return If;
}


/// Create a fake body for dispatch_sync.
//<editor-fold defaultstate="collapsed" desc="create_dispatch_sync">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 248,
 FQN="create_dispatch_sync", NM="_ZL20create_dispatch_syncRN5clang10ASTContextEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL20create_dispatch_syncRN5clang10ASTContextEPKNS_12FunctionDeclE")
//</editor-fold>
public static Stmt /*P*/ create_dispatch_sync(final ASTContext /*&*/ C, /*const*/ FunctionDecl /*P*/ D) {
  // Check if we have at least two parameters.
  if (D.param_size() != 2) {
    return null;
  }
  
  // Check if the second parameter is a block.
  /*const*/ ParmVarDecl /*P*/ PV = D.getParamDecl$Const(1);
  QualType Ty = PV.getType();
  if (!isDispatchBlock(new QualType(Ty))) {
    return null;
  }
  
  // Everything checks out.  Create a fake body that just calls the block.
  // This is basically just an AST dump of:
  //
  // void dispatch_sync(dispatch_queue_t queue, void (^block)(void)) {
  //   block();
  // }
  //  
  ASTMaker M/*J*/= new ASTMaker(C);
  DeclRefExpr /*P*/ DR = M.makeDeclRefExpr(PV);
  ImplicitCastExpr /*P*/ ICE = M.makeLvalueToRvalue(DR, new QualType(Ty));
  CallExpr /*P*/ CE = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
      return new CallExpr(C, ICE, new ArrayRef<Expr /*P*/ >(None, true), C.VoidTy.$QualType(), ExprValueKind.VK_RValue, 
              new SourceLocation());
   });
  return CE;
}

//<editor-fold defaultstate="collapsed" desc="create_OSAtomicCompareAndSwap">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 274,
 FQN="create_OSAtomicCompareAndSwap", NM="_ZL29create_OSAtomicCompareAndSwapRN5clang10ASTContextEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL29create_OSAtomicCompareAndSwapRN5clang10ASTContextEPKNS_12FunctionDeclE")
//</editor-fold>
public static Stmt /*P*/ create_OSAtomicCompareAndSwap(final ASTContext /*&*/ C, /*const*/ FunctionDecl /*P*/ D) {
  // There are exactly 3 arguments.
  if (D.param_size() != 3) {
    return null;
  }
  
  // Signature:
  // _Bool OSAtomicCompareAndSwapPtr(void *__oldValue,
  //                                 void *__newValue,
  //                                 void * volatile *__theValue)
  // Generate body:
  //   if (oldValue == *theValue) {
  //    *theValue = newValue;
  //    return YES;
  //   }
  //   else return NO;
  QualType ResultTy = D.getReturnType();
  boolean isBoolean = ResultTy.$arrow().isBooleanType();
  if (!isBoolean && !ResultTy.$arrow().isIntegralType(C)) {
    return null;
  }
  
  /*const*/ ParmVarDecl /*P*/ OldValue = D.getParamDecl$Const(0);
  QualType OldValueTy = OldValue.getType();
  
  /*const*/ ParmVarDecl /*P*/ NewValue = D.getParamDecl$Const(1);
  QualType NewValueTy = NewValue.getType();
  assert (QualType.$eq_QualType$C(OldValueTy, NewValueTy));
  
  /*const*/ ParmVarDecl /*P*/ TheValue = D.getParamDecl$Const(2);
  QualType TheValueTy = TheValue.getType();
  /*const*/ PointerType /*P*/ PT = TheValueTy.$arrow().getAs(PointerType.class);
  if (!(PT != null)) {
    return null;
  }
  QualType PointeeTy = PT.getPointeeType();
  
  ASTMaker M/*J*/= new ASTMaker(C);
  // Construct the comparison.
  Expr /*P*/ Comparison = M.makeComparison(M.makeLvalueToRvalue(M.makeDeclRefExpr(OldValue), new QualType(OldValueTy)), 
      M.makeLvalueToRvalue(M.makeDereference(M.makeLvalueToRvalue(M.makeDeclRefExpr(TheValue), new QualType(TheValueTy)), 
              new QualType(PointeeTy)), 
          new QualType(PointeeTy)), 
      BinaryOperatorKind.BO_EQ);
  
  // Construct the body of the IfStmt.
  Stmt /*P*/ Stmts[/*2*/] = new Stmt /*P*/  [2];
  Stmts[0]
     = M.makeAssignment(M.makeDereference(M.makeLvalueToRvalue(M.makeDeclRefExpr(TheValue), new QualType(TheValueTy)), 
          new QualType(PointeeTy)), 
      M.makeLvalueToRvalue(M.makeDeclRefExpr(NewValue), new QualType(NewValueTy)), 
      new QualType(NewValueTy));
  
  Expr /*P*/ BoolVal = M.makeObjCBool(true);
  Expr /*P*/ RetVal = isBoolean ? M.makeIntegralCastToBoolean(BoolVal) : M.makeIntegralCast(BoolVal, new QualType(ResultTy));
  Stmts[1] = M.makeReturn(RetVal);
  CompoundStmt /*P*/ Body = M.makeCompound(new ArrayRef<Stmt /*P*/ >(Stmts, true));
  
  // Construct the else clause.
  BoolVal = M.makeObjCBool(false);
  RetVal = isBoolean ? M.makeIntegralCastToBoolean(BoolVal) : M.makeIntegralCast(BoolVal, new QualType(ResultTy));
  Stmt /*P*/ Else = M.makeReturn(RetVal);
  
  /// Construct the If.
  Stmt /*P*/ If = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
      return new IfStmt(C, new SourceLocation(), false, (Stmt /*P*/ )null, (VarDecl /*P*/ )null, 
              Comparison, Body, new SourceLocation(), Else);
   });
  
  return If;
}

//<editor-fold defaultstate="collapsed" desc="findBackingIvar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 386,
 FQN="findBackingIvar", NM="_ZL15findBackingIvarPKN5clang16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL15findBackingIvarPKN5clang16ObjCPropertyDeclE")
//</editor-fold>
public static /*const*/ ObjCIvarDecl /*P*/ findBackingIvar(/*const*/ ObjCPropertyDecl /*P*/ Prop) {
  /*const*/ ObjCIvarDecl /*P*/ IVar = Prop.getPropertyIvarDecl();
  if ((IVar != null)) {
    return IVar;
  }
  
  // When a readonly property is shadowed in a class extensions with a
  // a readwrite property, the instance variable belongs to the shadowing
  // property rather than the shadowed property. If there is no instance
  // variable on a readonly property, check to see whether the property is
  // shadowed and if so try to get the instance variable from shadowing
  // property.
  if (!Prop.isReadOnly()) {
    return null;
  }
  
  /*const*/ ObjCContainerDecl /*P*/ Container = cast_ObjCContainerDecl(Prop.getDeclContext$Const());
  /*const*/ ObjCInterfaceDecl /*P*/ PrimaryInterface = null;
  {
    /*const*/ ObjCInterfaceDecl /*P*/ InterfaceDecl = dyn_cast_ObjCInterfaceDecl(Container);
    if ((InterfaceDecl != null)) {
      PrimaryInterface = InterfaceDecl;
    } else {
      /*const*/ ObjCCategoryDecl /*P*/ CategoryDecl = dyn_cast_ObjCCategoryDecl(Container);
      if ((CategoryDecl != null)) {
        PrimaryInterface = CategoryDecl.getClassInterface$Const();
      } else {
        /*const*/ ObjCImplDecl /*P*/ ImplDecl = dyn_cast_ObjCImplDecl(Container);
        if ((ImplDecl != null)) {
          PrimaryInterface = ImplDecl.getClassInterface$Const();
        } else {
          return null;
        }
      }
    }
  }
  
  // FindPropertyVisibleInPrimaryClass() looks first in class extensions, so it
  // is guaranteed to find the shadowing property, if it exists, rather than
  // the shadowed property.
  ObjCPropertyDecl /*P*/ ShadowingProp = PrimaryInterface.FindPropertyVisibleInPrimaryClass(Prop.getIdentifier(), Prop.getQueryKind());
  if ((ShadowingProp != null) && ShadowingProp != Prop) {
    IVar = ShadowingProp.getPropertyIvarDecl();
  }
  
  return IVar;
}

//<editor-fold defaultstate="collapsed" desc="createObjCPropertyGetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 425,
 FQN="createObjCPropertyGetter", NM="_ZL24createObjCPropertyGetterRN5clang10ASTContextEPKNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZL24createObjCPropertyGetterRN5clang10ASTContextEPKNS_16ObjCPropertyDeclE")
//</editor-fold>
public static Stmt /*P*/ createObjCPropertyGetter(final ASTContext /*&*/ Ctx, 
                        /*const*/ ObjCPropertyDecl /*P*/ Prop) {
  // First, find the backing ivar.
  /*const*/ ObjCIvarDecl /*P*/ IVar = findBackingIvar(Prop);
  if (!(IVar != null)) {
    return null;
  }
  
  // Ignore weak variables, which have special behavior.
  if (((Prop.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
    return null;
  }
  
  // Look to see if Sema has synthesized a body for us. This happens in
  // Objective-C++ because the return value may be a C++ class type with a
  // non-trivial copy constructor. We can only do this if we can find the
  // @synthesize for this property, though (or if we know it's been auto-
  // synthesized).
  /*const*/ ObjCImplementationDecl /*P*/ ImplDecl = IVar.getContainingInterface().getImplementation();
  if ((ImplDecl != null)) {
    for (/*const*/ ObjCPropertyImplDecl /*P*/ I : ImplDecl.property_impls()) {
      if (I.getPropertyDecl() != Prop) {
        continue;
      }
      if ((I.getGetterCXXConstructor() != null)) {
        ASTMaker M/*J*/= new ASTMaker(Ctx);
        return M.makeReturn(I.getGetterCXXConstructor());
      }
    }
  }
  
  // Sanity check that the property is the same type as the ivar, or a
  // reference to it, and that it is either an object pointer or trivially
  // copyable.
  if (!Ctx.hasSameUnqualifiedType(IVar.getType(), 
      Prop.getType().getNonReferenceType())) {
    return null;
  }
  if (!IVar.getType().$arrow().isObjCLifetimeType()
     && !IVar.getType().isTriviallyCopyableType(Ctx)) {
    return null;
  }
  
  // Generate our body:
  //   return self->_ivar;
  ASTMaker M/*J*/= new ASTMaker(Ctx);
  
  /*const*/ VarDecl /*P*/ selfVar = Prop.getGetterMethodDecl().getSelfDecl();
  
  Expr /*P*/ loadedIVar = M.makeObjCIvarRef(M.makeLvalueToRvalue(M.makeDeclRefExpr(selfVar), 
          selfVar.getType()), 
      IVar);
  if (!Prop.getType().$arrow().isReferenceType()) {
    loadedIVar = M.makeLvalueToRvalue(loadedIVar, IVar.getType());
  }
  
  return M.makeReturn(loadedIVar);
}

} // END OF class BodyFarmStatics
