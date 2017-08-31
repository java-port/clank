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

package org.clang.ast;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.AstClangGlobals.*;


/// CastExpr - Base class for type casts, including both implicit
/// casts (ImplicitCastExpr) and explicit casts that have some
/// representation in the source code (ExplicitCastExpr's derived
/// classes).
//<editor-fold defaultstate="collapsed" desc="clang::CastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2632,
 FQN="clang::CastExpr", NM="_ZN5clang8CastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExprE")
//</editor-fold>
public class CastExpr extends /*public*/ Expr {
/*private:*/
  private Stmt /*P*/ Op;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::CastConsistency">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1485,
   FQN="clang::CastExpr::CastConsistency", NM="_ZNK5clang8CastExpr15CastConsistencyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr15CastConsistencyEv")
  //</editor-fold>
  private boolean CastConsistency() /*const*/ {
    switch (getCastKind()) {
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
     case CK_DerivedToBaseMemberPointer:
     case CK_BaseToDerived:
     case CK_BaseToDerivedMemberPointer:
      assert (!path_empty()) : "Cast kind should have a base path!";
      break;
     case CK_CPointerToObjCPointerCast:
      assert (getType().$arrow().isObjCObjectPointerType());
      assert (getSubExpr$Const().getType().$arrow().isPointerType());
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_BlockPointerToObjCPointerCast:
      assert (getType().$arrow().isObjCObjectPointerType());
      assert (getSubExpr$Const().getType().$arrow().isBlockPointerType());
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_ReinterpretMemberPointer:
      assert (getType().$arrow().isMemberPointerType());
      assert (getSubExpr$Const().getType().$arrow().isMemberPointerType());
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_BitCast:
      // Arbitrary casts to C pointer types count as bitcasts.
      // Otherwise, we should only have block and ObjC pointer casts
      // here if they stay within the type kind.
      if (!getType().$arrow().isPointerType()) {
        assert (getType().$arrow().isObjCObjectPointerType() == getSubExpr$Const().getType().$arrow().isObjCObjectPointerType());
        assert (getType().$arrow().isBlockPointerType() == getSubExpr$Const().getType().$arrow().isBlockPointerType());
      }
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_AnyPointerToBlockPointerCast:
      assert (getType().$arrow().isBlockPointerType());
      assert (getSubExpr$Const().getType().$arrow().isAnyPointerType() && !getSubExpr$Const().getType().$arrow().isBlockPointerType());
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_CopyAndAutoreleaseBlockObject:
      assert (getType().$arrow().isBlockPointerType());
      assert (getSubExpr$Const().getType().$arrow().isBlockPointerType());
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_FunctionToPointerDecay:
      assert (getType().$arrow().isPointerType());
      assert (getSubExpr$Const().getType().$arrow().isFunctionType());
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_AddressSpaceConversion:
      assert (getType().$arrow().isPointerType());
      assert (getSubExpr$Const().getType().$arrow().isPointerType());
      assert (getType().$arrow().getPointeeType().getAddressSpace() != getSubExpr$Const().getType().$arrow().getPointeeType().getAddressSpace());
     case CK_Dynamic:
     case CK_ToUnion:
     case CK_ArrayToPointerDecay:
     case CK_NullToMemberPointer:
     case CK_NullToPointer:
     case CK_ConstructorConversion:
     case CK_IntegralToPointer:
     case CK_PointerToIntegral:
     case CK_ToVoid:
     case CK_VectorSplat:
     case CK_IntegralCast:
     case CK_BooleanToSignedIntegral:
     case CK_IntegralToFloating:
     case CK_FloatingToIntegral:
     case CK_FloatingCast:
     case CK_ObjCObjectLValueCast:
     case CK_FloatingRealToComplex:
     case CK_FloatingComplexToReal:
     case CK_FloatingComplexCast:
     case CK_FloatingComplexToIntegralComplex:
     case CK_IntegralRealToComplex:
     case CK_IntegralComplexToReal:
     case CK_IntegralComplexCast:
     case CK_IntegralComplexToFloatingComplex:
     case CK_ARCProduceObject:
     case CK_ARCConsumeObject:
     case CK_ARCReclaimReturnedObject:
     case CK_ARCExtendBlockObject:
     case CK_ZeroToOCLEvent:
      // These should not have an inheritance path.
      assert (!getType().$arrow().isBooleanType()) : "unheralded conversion to bool";
      /*goto CheckNoBasePath;*/ assert (path_empty()) : "Cast kind should not have a base path!"; break;
     case CK_Dependent:
     case CK_LValueToRValue:
     case CK_NoOp:
     case CK_AtomicToNonAtomic:
     case CK_NonAtomicToAtomic:
     case CK_PointerToBoolean:
     case CK_IntegralToBoolean:
     case CK_FloatingToBoolean:
     case CK_MemberPointerToBoolean:
     case CK_FloatingComplexToBoolean:
     case CK_IntegralComplexToBoolean:
     case CK_LValueBitCast: // -> bool&
     case CK_UserDefinedConversion: // operator bool()
     case CK_BuiltinFnToFnPtr:
     //CheckNoBasePath:
      assert (path_empty()) : "Cast kind should not have a base path!";
      break;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_buffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2638,
   FQN="clang::CastExpr::path_buffer", NM="_ZNK5clang8CastExpr11path_bufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr11path_bufferEv")
  //</editor-fold>
  private type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> path_buffer$Const() /*const*/ {
    return ((/*const_cast*/CastExpr /*P*/ )(this)).path_buffer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_buffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1639,
   FQN="clang::CastExpr::path_buffer", NM="_ZN5clang8CastExpr11path_bufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr11path_bufferEv")
  //</editor-fold>
  private type$ptr<CXXBaseSpecifier /*P*/ /*P*/> path_buffer() {
    switch (getStmtClass()) {
     case CStyleCastExprClass:
      return ((/*static_cast*/CStyleCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case CXXFunctionalCastExprClass:
      return ((/*static_cast*/CXXFunctionalCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case CXXConstCastExprClass:
      return ((/*static_cast*/CXXConstCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case CXXDynamicCastExprClass:
      return ((/*static_cast*/CXXDynamicCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case CXXReinterpretCastExprClass:
      return ((/*static_cast*/CXXReinterpretCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case CXXStaticCastExprClass:
      return ((/*static_cast*/CXXStaticCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case ObjCBridgedCastExprClass:
      return ((/*static_cast*/ObjCBridgedCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     case ImplicitCastExprClass:
      return ((/*static_cast*/ImplicitCastExpr /*P*/ )(this)).<CXXBaseSpecifier /*P*/ >getTrailingObjects(CXXBaseSpecifier.class);
     default:
      throw new llvm_unreachable("non-cast expressions not possible here");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::setBasePathSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2643,
   FQN="clang::CastExpr::setBasePathSize", NM="_ZN5clang8CastExpr15setBasePathSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr15setBasePathSizeEj")
  //</editor-fold>
  private void setBasePathSize(/*uint*/int basePathSize) {
    Unnamed_field.CastExprBits.BasePathSize = $uint2uint_10bits(basePathSize);
    assert (Unnamed_field.CastExprBits.BasePathSize == $uint2uint_10bits(basePathSize)) : "basePathSize doesn't fit in bits of CastExprBits.BasePathSize!";
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::CastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2650,
   FQN="clang::CastExpr::CastExpr", NM="_ZN5clang8CastExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEj")
  //</editor-fold>
  protected CastExpr(StmtClass SC, QualType ty, ExprValueKind VK, /*const*/ CastKind kind, 
      Expr /*P*/ op, /*uint*/int BasePathSize) {
    // : Expr(SC, ty, VK, OK_Ordinary, ty->isDependentType(), ty->isDependentType() || (op && op->isValueDependent()), (ty->isInstantiationDependentType() || (op && op->isInstantiationDependent())), ((SC != ImplicitCastExprClass && ty->containsUnexpandedParameterPack()) || (op && op->containsUnexpandedParameterPack()))), Op(op) 
    //START JInit
    super(SC, new QualType(ty), VK, ExprObjectKind.OK_Ordinary, 
        // Cast expressions are type-dependent if the type is
        // dependent (C++ [temp.dep.expr]p3).
        ty.$arrow().isDependentType(), 
        // Cast expressions are value-dependent if the type is
        // dependent or if the subexpression is value-dependent.
        ty.$arrow().isDependentType() || ((op != null) && op.isValueDependent()), 
        (ty.$arrow().isInstantiationDependentType()
           || ((op != null) && op.isInstantiationDependent())), 
        // An implicit cast expression doesn't (lexically) contain an
        // unexpanded pack, even if its target type does.
        ((SC != StmtClass.ImplicitCastExprClass
           && ty.$arrow().containsUnexpandedParameterPack())
           || ((op != null) && op.containsUnexpandedParameterPack())));
    this.Op = op;
    //END JInit
    assert (kind != CK_Invalid) : "creating cast with invalid cast kind";
    Unnamed_field.CastExprBits.Kind = $uint2uint_6bits(kind.getValue());
    setBasePathSize(BasePathSize);
    assert (CastConsistency());
  }

  
  /// \brief Construct an empty cast.
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::CastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2674,
   FQN="clang::CastExpr::CastExpr", NM="_ZN5clang8CastExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellEj")
  //</editor-fold>
  protected CastExpr(StmtClass SC, EmptyShell Empty, /*uint*/int BasePathSize) {
    // : Expr(SC, Empty) 
    //START JInit
    super(SC, new EmptyShell(Empty));
    //END JInit
    setBasePathSize(BasePathSize);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::getCastKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2680,
   FQN="clang::CastExpr::getCastKind", NM="_ZNK5clang8CastExpr11getCastKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr11getCastKindEv")
  //</editor-fold>
  public CastKind getCastKind() /*const*/ {
    return CastKind.valueOf(Unnamed_field.CastExprBits.Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::setCastKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2681,
   FQN="clang::CastExpr::setCastKind", NM="_ZN5clang8CastExpr11setCastKindENS_8CastKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr11setCastKindENS_8CastKindE")
  //</editor-fold>
  public void setCastKind(CastKind K) {
    Unnamed_field.CastExprBits.Kind = $uint2uint_6bits(K.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::getCastKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1597,
   FQN="clang::CastExpr::getCastKindName", NM="_ZNK5clang8CastExpr15getCastKindNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr15getCastKindNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCastKindName() /*const*/ {
    switch (getCastKind()) {
     case CK_Dependent:
      
      //===- Cast Operations  ---------------------------------------------------===//
      
      /// CK_Dependent - A conversion which cannot yet be analyzed because
      /// either the expression or target type is dependent.  These are
      /// created only for explicit casts; dependent ASTs aren't required
      /// to even approximately type-check.
      ///   (T*) malloc(sizeof(T))
      ///   reinterpret_cast<intptr_t>(A<T>::alloc());
      return $("Dependent");
     case CK_BitCast:
      
      /// CK_BitCast - A conversion which causes a bit pattern of one type
      /// to be reinterpreted as a bit pattern of another type.  Generally
      /// the operands must have equivalent size and unrelated types.
      ///
      /// The pointer conversion char* -> int* is a bitcast.  A conversion
      /// from any pointer type to a C pointer type is a bitcast unless
      /// it's actually BaseToDerived or DerivedToBase.  A conversion to a
      /// block pointer or ObjC pointer type is a bitcast only if the
      /// operand has the same type kind; otherwise, it's one of the
      /// specialized casts below.
      ///
      /// Vector coercions are bitcasts.
      return $("BitCast");
     case CK_LValueBitCast:
      
      /// CK_LValueBitCast - A conversion which reinterprets the address of
      /// an l-value as an l-value of a different kind.  Used for
      /// reinterpret_casts of l-value expressions to reference types.
      ///    bool b; reinterpret_cast<char&>(b) = 'a';
      return $("LValueBitCast");
     case CK_LValueToRValue:
      
      /// CK_LValueToRValue - A conversion which causes the extraction of
      /// an r-value from the operand gl-value.  The result of an r-value
      /// conversion is always unqualified.
      return $("LValueToRValue");
     case CK_NoOp:
      
      /// CK_NoOp - A conversion which does not affect the type other than
      /// (possibly) adding qualifiers.
      ///   int    -> int
      ///   char** -> const char * const *
      return $("NoOp");
     case CK_BaseToDerived:
      
      /// CK_BaseToDerived - A conversion from a C++ class pointer/reference
      /// to a derived class pointer/reference.
      ///   B *b = static_cast<B*>(a);
      return $("BaseToDerived");
     case CK_DerivedToBase:
      
      /// CK_DerivedToBase - A conversion from a C++ class pointer
      /// to a base class pointer.
      ///   A *a = new B();
      return $("DerivedToBase");
     case CK_UncheckedDerivedToBase:
      
      /// CK_UncheckedDerivedToBase - A conversion from a C++ class
      /// pointer/reference to a base class that can assume that the
      /// derived pointer is not null.
      ///   const A &a = B();
      ///   b->method_from_a();
      return $("UncheckedDerivedToBase");
     case CK_Dynamic:
      
      /// CK_Dynamic - A C++ dynamic_cast.
      return $("Dynamic");
     case CK_ToUnion:
      
      /// CK_ToUnion - The GCC cast-to-union extension.
      ///   int   -> union { int x; float y; }
      ///   float -> union { int x; float y; }
      return $("ToUnion");
     case CK_ArrayToPointerDecay:
      
      /// CK_ArrayToPointerDecay - Array to pointer decay.
      ///   int[10] -> int*
      ///   char[5][6] -> char(*)[6]
      return $("ArrayToPointerDecay");
     case CK_FunctionToPointerDecay:
      
      /// CK_FunctionToPointerDecay - Function to pointer decay.
      ///   void(int) -> void(*)(int)
      return $("FunctionToPointerDecay");
     case CK_NullToPointer:
      
      /// CK_NullToPointer - Null pointer constant to pointer, ObjC
      /// pointer, or block pointer.
      ///   (void*) 0
      ///   void (^block)() = 0;
      return $("NullToPointer");
     case CK_NullToMemberPointer:
      
      /// CK_NullToMemberPointer - Null pointer constant to member pointer.
      ///   int A::*mptr = 0;
      ///   int (A::*fptr)(int) = nullptr;
      return $("NullToMemberPointer");
     case CK_BaseToDerivedMemberPointer:
      
      /// CK_BaseToDerivedMemberPointer - Member pointer in base class to
      /// member pointer in derived class.
      ///   int B::*mptr = &A::member;
      return $("BaseToDerivedMemberPointer");
     case CK_DerivedToBaseMemberPointer:
      
      /// CK_DerivedToBaseMemberPointer - Member pointer in derived class to
      /// member pointer in base class.
      ///   int A::*mptr = static_cast<int A::*>(&B::member);
      return $("DerivedToBaseMemberPointer");
     case CK_MemberPointerToBoolean:
      
      /// CK_MemberPointerToBoolean - Member pointer to boolean.  A check
      /// against the null member pointer.
      return $("MemberPointerToBoolean");
     case CK_ReinterpretMemberPointer:
      
      /// CK_ReinterpretMemberPointer - Reinterpret a member pointer as a
      /// different kind of member pointer.  C++ forbids this from
      /// crossing between function and object types, but otherwise does
      /// not restrict it.  However, the only operation that is permitted
      /// on a "punned" member pointer is casting it back to the original
      /// type, which is required to be a lossless operation (although
      /// many ABIs do not guarantee this on all possible intermediate types).
      return $("ReinterpretMemberPointer");
     case CK_UserDefinedConversion:
      
      /// CK_UserDefinedConversion - Conversion using a user defined type
      /// conversion function.
      ///    struct A { operator int(); }; int i = int(A());
      return $("UserDefinedConversion");
     case CK_ConstructorConversion:
      
      /// CK_ConstructorConversion - Conversion by constructor.
      ///    struct A { A(int); }; A a = A(10);
      return $("ConstructorConversion");
     case CK_IntegralToPointer:
      
      /// CK_IntegralToPointer - Integral to pointer.  A special kind of
      /// reinterpreting conversion.  Applies to normal, ObjC, and block
      /// pointers.
      ///    (char*) 0x1001aab0
      ///    reinterpret_cast<int*>(0)
      return $("IntegralToPointer");
     case CK_PointerToIntegral:
      
      /// CK_PointerToIntegral - Pointer to integral.  A special kind of
      /// reinterpreting conversion.  Applies to normal, ObjC, and block
      /// pointers.
      ///    (intptr_t) "help!"
      return $("PointerToIntegral");
     case CK_PointerToBoolean:
      
      /// CK_PointerToBoolean - Pointer to boolean conversion.  A check
      /// against null.  Applies to normal, ObjC, and block pointers.
      return $("PointerToBoolean");
     case CK_ToVoid:
      
      /// CK_ToVoid - Cast to void, discarding the computed value.
      ///    (void) malloc(2048)
      return $("ToVoid");
     case CK_VectorSplat:
      
      /// CK_VectorSplat - A conversion from an arithmetic type to a
      /// vector of that element type.  Fills all elements ("splats") with
      /// the source value.
      ///    __attribute__((ext_vector_type(4))) int v = 5;
      return $("VectorSplat");
     case CK_IntegralCast:
      
      /// CK_IntegralCast - A cast between integral types (other than to
      /// boolean).  Variously a bitcast, a truncation, a sign-extension,
      /// or a zero-extension.
      ///    long l = 5;
      ///    (unsigned) i
      return $("IntegralCast");
     case CK_IntegralToBoolean:
      
      /// CK_IntegralToBoolean - Integral to boolean.  A check against zero.
      ///    (bool) i
      return $("IntegralToBoolean");
     case CK_IntegralToFloating:
      
      /// CK_IntegralToFloating - Integral to floating point.
      ///    float f = i;
      return $("IntegralToFloating");
     case CK_FloatingToIntegral:
      
      /// CK_FloatingToIntegral - Floating point to integral.  Rounds
      /// towards zero, discarding any fractional component.
      ///    (int) f
      return $("FloatingToIntegral");
     case CK_FloatingToBoolean:
      
      /// CK_FloatingToBoolean - Floating point to boolean.
      ///    (bool) f
      return $("FloatingToBoolean");
     case CK_BooleanToSignedIntegral:
      
      // CK_BooleanToSignedIntegral - Convert a boolean to -1 or 0 for true and
      // false, respectively.
      return $("BooleanToSignedIntegral");
     case CK_FloatingCast:
      
      /// CK_FloatingCast - Casting between floating types of different size.
      ///    (double) f
      ///    (float) ld
      return $("FloatingCast");
     case CK_CPointerToObjCPointerCast:
      
      /// CK_CPointerToObjCPointerCast - Casting a C pointer kind to an
      /// Objective-C pointer.
      return $("CPointerToObjCPointerCast");
     case CK_BlockPointerToObjCPointerCast:
      
      /// CK_BlockPointerToObjCPointerCast - Casting a block pointer to an
      /// ObjC pointer.
      return $("BlockPointerToObjCPointerCast");
     case CK_AnyPointerToBlockPointerCast:
      
      /// CK_AnyPointerToBlockPointerCast - Casting any non-block pointer
      /// to a block pointer.  Block-to-block casts are bitcasts.
      return $("AnyPointerToBlockPointerCast");
     case CK_ObjCObjectLValueCast:
      
      /// \brief Converting between two Objective-C object types, which
      /// can occur when performing reference binding to an Objective-C
      /// object.
      return $("ObjCObjectLValueCast");
     case CK_FloatingRealToComplex:
      
      /// \brief A conversion of a floating point real to a floating point
      /// complex of the original type.  Injects the value as the real
      /// component with a zero imaginary component.
      ///   float -> _Complex float
      return $("FloatingRealToComplex");
     case CK_FloatingComplexToReal:
      
      /// \brief Converts a floating point complex to floating point real
      /// of the source's element type.  Just discards the imaginary
      /// component.
      ///   _Complex long double -> long double
      return $("FloatingComplexToReal");
     case CK_FloatingComplexToBoolean:
      
      /// \brief Converts a floating point complex to bool by comparing
      /// against 0+0i.
      return $("FloatingComplexToBoolean");
     case CK_FloatingComplexCast:
      
      /// \brief Converts between different floating point complex types.
      ///   _Complex float -> _Complex double
      return $("FloatingComplexCast");
     case CK_FloatingComplexToIntegralComplex:
      
      /// \brief Converts from a floating complex to an integral complex.
      ///   _Complex float -> _Complex int
      return $("FloatingComplexToIntegralComplex");
     case CK_IntegralRealToComplex:
      
      /// \brief Converts from an integral real to an integral complex
      /// whose element type matches the source.  Injects the value as
      /// the real component with a zero imaginary component.
      ///   long -> _Complex long
      return $("IntegralRealToComplex");
     case CK_IntegralComplexToReal:
      
      /// \brief Converts an integral complex to an integral real of the
      /// source's element type by discarding the imaginary component.
      ///   _Complex short -> short
      return $("IntegralComplexToReal");
     case CK_IntegralComplexToBoolean:
      
      /// \brief Converts an integral complex to bool by comparing against
      /// 0+0i.
      return $("IntegralComplexToBoolean");
     case CK_IntegralComplexCast:
      
      /// \brief Converts between different integral complex types.
      ///   _Complex char -> _Complex long long
      ///   _Complex unsigned int -> _Complex signed int
      return $("IntegralComplexCast");
     case CK_IntegralComplexToFloatingComplex:
      
      /// \brief Converts from an integral complex to a floating complex.
      ///   _Complex unsigned -> _Complex float
      return $("IntegralComplexToFloatingComplex");
     case CK_ARCProduceObject:
      
      /// \brief [ARC] Produces a retainable object pointer so that it may
      /// be consumed, e.g. by being passed to a consuming parameter.
      /// Calls objc_retain.
      return $("ARCProduceObject");
     case CK_ARCConsumeObject:
      
      /// \brief [ARC] Consumes a retainable object pointer that has just
      /// been produced, e.g. as the return value of a retaining call.
      /// Enters a cleanup to call objc_release at some indefinite time.
      return $("ARCConsumeObject");
     case CK_ARCReclaimReturnedObject:
      
      /// \brief [ARC] Reclaim a retainable object pointer object that may
      /// have been produced and autoreleased as part of a function return
      /// sequence.
      return $("ARCReclaimReturnedObject");
     case CK_ARCExtendBlockObject:
      
      /// \brief [ARC] Causes a value of block type to be copied to the
      /// heap, if it is not already there.  A number of other operations
      /// in ARC cause blocks to be copied; this is for cases where that
      /// would not otherwise be guaranteed, such as when casting to a
      /// non-block pointer type.
      return $("ARCExtendBlockObject");
     case CK_AtomicToNonAtomic:
      
      /// \brief Converts from _Atomic(T) to T.
      return $("AtomicToNonAtomic");
     case CK_NonAtomicToAtomic:
      /// \brief Converts from T to _Atomic(T).
      return $("NonAtomicToAtomic");
     case CK_CopyAndAutoreleaseBlockObject:
      
      /// \brief Causes a block literal to by copied to the heap and then 
      /// autoreleased.
      ///
      /// This particular cast kind is used for the conversion from a C++11
      /// lambda expression to a block pointer.
      return $("CopyAndAutoreleaseBlockObject");
     case CK_BuiltinFnToFnPtr:
      
      // Convert a builtin function to a function pointer; only allowed in the
      // callee of a call expression.
      return $("BuiltinFnToFnPtr");
     case CK_ZeroToOCLEvent:
      
      // Convert a zero value for OpenCL event_t initialization.
      return $("ZeroToOCLEvent");
     case CK_AddressSpaceConversion:
      
      // Convert a pointer to a different address space.
      return $("AddressSpaceConversion");
    }
    throw new llvm_unreachable("Unhandled cast kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2684,
   FQN="clang::CastExpr::getSubExpr", NM="_ZN5clang8CastExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(Op);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2685,
   FQN="clang::CastExpr::getSubExpr", NM="_ZNK5clang8CastExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(Op);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::setSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2686,
   FQN="clang::CastExpr::setSubExpr", NM="_ZN5clang8CastExpr10setSubExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr10setSubExprEPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(Expr /*P*/ E) {
    Op = E;
  }

  
  /// \brief Retrieve the cast subexpression as it was written in the source
  /// code, looking through any implicit casts or other intermediate nodes
  /// introduced by semantic analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::getSubExprAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1605,
   FQN="clang::CastExpr::getSubExprAsWritten", NM="_ZN5clang8CastExpr19getSubExprAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr19getSubExprAsWrittenEv")
  //</editor-fold>
  public Expr /*P*/ getSubExprAsWritten() {
    Expr /*P*/ SubExpr = null;
    CastExpr /*P*/ E = this;
    do {
      SubExpr = E.getSubExpr();
      {
        
        // Skip through reference binding to temporary.
        MaterializeTemporaryExpr /*P*/ Materialize = dyn_cast_MaterializeTemporaryExpr(SubExpr);
        if ((Materialize != null)) {
          SubExpr = Materialize.GetTemporaryExpr();
        }
      }
      {
        
        // Skip any temporary bindings; they're implicit.
        CXXBindTemporaryExpr /*P*/ Binder = dyn_cast_CXXBindTemporaryExpr(SubExpr);
        if ((Binder != null)) {
          SubExpr = Binder.getSubExpr();
        }
      }
      
      // Conversions by constructor and conversion functions have a
      // subexpression describing the call; strip it off.
      if (E.getCastKind() == CastKind.CK_ConstructorConversion) {
        SubExpr = cast_CXXConstructExpr(SubExpr).getArg(0);
      } else if (E.getCastKind() == CastKind.CK_UserDefinedConversion) {
        assert ((isa_CXXMemberCallExpr(SubExpr) || isa_BlockExpr(SubExpr))) : "Unexpected SubExpr for CK_UserDefinedConversion.";
        if (isa_CXXMemberCallExpr(SubExpr)) {
          SubExpr = cast_CXXMemberCallExpr(SubExpr).getImplicitObjectArgument();
        }
      }
      // If the subexpression we're left with is an implicit cast, look
      // through that, too.
    } while (((E = dyn_cast_ImplicitCastExpr(SubExpr)) != null));
    
    return SubExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::getSubExprAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2692,
   FQN="clang::CastExpr::getSubExprAsWritten", NM="_ZNK5clang8CastExpr19getSubExprAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr19getSubExprAsWrittenEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExprAsWritten$Const() /*const*/ {
    return ((/*const_cast*/CastExpr /*P*/ )(this)).getSubExprAsWritten();
  }

  
  /*typedef CXXBaseSpecifier **path_iterator*/
//  public final class path_iterator extends type$ptr<CXXBaseSpecifier /*P*/ /*P*/>{ };
  /*typedef const CXXBaseSpecifier *const *path_const_iterator*/
//  public final class path_const_iterator extends type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2698,
   FQN="clang::CastExpr::path_empty", NM="_ZNK5clang8CastExpr10path_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr10path_emptyEv")
  //</editor-fold>
  public boolean path_empty() /*const*/ {
    return Unnamed_field.CastExprBits.BasePathSize == $int2uint_10bits(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2699,
   FQN="clang::CastExpr::path_size", NM="_ZNK5clang8CastExpr9path_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr9path_sizeEv")
  //</editor-fold>
  public /*uint*/int path_size() /*const*/ {
    return Unnamed_field.CastExprBits.BasePathSize;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2700,
   FQN="clang::CastExpr::path_begin", NM="_ZN5clang8CastExpr10path_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr10path_beginEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier /*P*/ /*P*/> path_begin() {
    return path_buffer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2701,
   FQN="clang::CastExpr::path_end", NM="_ZN5clang8CastExpr8path_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr8path_endEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier /*P*/ /*P*/> path_end() {
    return path_buffer().$add(path_size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2702,
   FQN="clang::CastExpr::path_begin", NM="_ZNK5clang8CastExpr10path_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr10path_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> path_begin$Const() /*const*/ {
    return path_buffer$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::path_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2703,
   FQN="clang::CastExpr::path_end", NM="_ZNK5clang8CastExpr8path_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang8CastExpr8path_endEv")
  //</editor-fold>
  public type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> path_end$Const() /*const*/ {
    return path_buffer$Const().$add(path_size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2705,
   FQN="clang::CastExpr::classof", NM="_ZN5clang8CastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass().getValue() >= StmtClass.firstCastExprConstant.getValue()
       && T.getStmtClass().getValue() <= StmtClass.lastCastExprConstant.getValue();
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CastExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2711,
   FQN="clang::CastExpr::children", NM="_ZN5clang8CastExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang8CastExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Op))), new StmtIterator(create_type$ptr($AddrOf(Op)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Op=" + Op // NOI18N
              + super.toString(); // NOI18N
  }
}
