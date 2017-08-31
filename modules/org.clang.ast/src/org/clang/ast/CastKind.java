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

import org.clank.support.*;


/// CastKind - The kind of operation required for a conversion.
//<editor-fold defaultstate="collapsed" desc="clang::CastKind">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added CK_Invalid*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OperationKinds.h", line = 21,
 FQN="clang::CastKind", NM="_ZN5clang8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/utils/OptionsUtils.cpp -nm=_ZN5clang8CastKindE")
//</editor-fold>
public enum CastKind implements Native.ComparableLower, Native.NativeUIntEnum {
  CK_Invalid(-1), // JAVA: new member for -1 value
  
  //===- Cast Operations  ---------------------------------------------------===//
  
  /// CK_Dependent - A conversion which cannot yet be analyzed because
  /// either the expression or target type is dependent.  These are
  /// created only for explicit casts; dependent ASTs aren't required
  /// to even approximately type-check.
  ///   (T*) malloc(sizeof(T))
  ///   reinterpret_cast<intptr_t>(A<T>::alloc());
  CK_Dependent(0),
  
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
  CK_BitCast(CK_Dependent.getValue() + 1),
  
  /// CK_LValueBitCast - A conversion which reinterprets the address of
  /// an l-value as an l-value of a different kind.  Used for
  /// reinterpret_casts of l-value expressions to reference types.
  ///    bool b; reinterpret_cast<char&>(b) = 'a';
  CK_LValueBitCast(CK_BitCast.getValue() + 1),
  
  /// CK_LValueToRValue - A conversion which causes the extraction of
  /// an r-value from the operand gl-value.  The result of an r-value
  /// conversion is always unqualified.
  CK_LValueToRValue(CK_LValueBitCast.getValue() + 1),
  
  /// CK_NoOp - A conversion which does not affect the type other than
  /// (possibly) adding qualifiers.
  ///   int    -> int
  ///   char** -> const char * const *
  CK_NoOp(CK_LValueToRValue.getValue() + 1),
  
  /// CK_BaseToDerived - A conversion from a C++ class pointer/reference
  /// to a derived class pointer/reference.
  ///   B *b = static_cast<B*>(a);
  CK_BaseToDerived(CK_NoOp.getValue() + 1),
  
  /// CK_DerivedToBase - A conversion from a C++ class pointer
  /// to a base class pointer.
  ///   A *a = new B();
  CK_DerivedToBase(CK_BaseToDerived.getValue() + 1),
  
  /// CK_UncheckedDerivedToBase - A conversion from a C++ class
  /// pointer/reference to a base class that can assume that the
  /// derived pointer is not null.
  ///   const A &a = B();
  ///   b->method_from_a();
  CK_UncheckedDerivedToBase(CK_DerivedToBase.getValue() + 1),
  
  /// CK_Dynamic - A C++ dynamic_cast.
  CK_Dynamic(CK_UncheckedDerivedToBase.getValue() + 1),
  
  /// CK_ToUnion - The GCC cast-to-union extension.
  ///   int   -> union { int x; float y; }
  ///   float -> union { int x; float y; }
  CK_ToUnion(CK_Dynamic.getValue() + 1),
  
  /// CK_ArrayToPointerDecay - Array to pointer decay.
  ///   int[10] -> int*
  ///   char[5][6] -> char(*)[6]
  CK_ArrayToPointerDecay(CK_ToUnion.getValue() + 1),
  
  /// CK_FunctionToPointerDecay - Function to pointer decay.
  ///   void(int) -> void(*)(int)
  CK_FunctionToPointerDecay(CK_ArrayToPointerDecay.getValue() + 1),
  
  /// CK_NullToPointer - Null pointer constant to pointer, ObjC
  /// pointer, or block pointer.
  ///   (void*) 0
  ///   void (^block)() = 0;
  CK_NullToPointer(CK_FunctionToPointerDecay.getValue() + 1),
  
  /// CK_NullToMemberPointer - Null pointer constant to member pointer.
  ///   int A::*mptr = 0;
  ///   int (A::*fptr)(int) = nullptr;
  CK_NullToMemberPointer(CK_NullToPointer.getValue() + 1),
  
  /// CK_BaseToDerivedMemberPointer - Member pointer in base class to
  /// member pointer in derived class.
  ///   int B::*mptr = &A::member;
  CK_BaseToDerivedMemberPointer(CK_NullToMemberPointer.getValue() + 1),
  
  /// CK_DerivedToBaseMemberPointer - Member pointer in derived class to
  /// member pointer in base class.
  ///   int A::*mptr = static_cast<int A::*>(&B::member);
  CK_DerivedToBaseMemberPointer(CK_BaseToDerivedMemberPointer.getValue() + 1),
  
  /// CK_MemberPointerToBoolean - Member pointer to boolean.  A check
  /// against the null member pointer.
  CK_MemberPointerToBoolean(CK_DerivedToBaseMemberPointer.getValue() + 1),
  
  /// CK_ReinterpretMemberPointer - Reinterpret a member pointer as a
  /// different kind of member pointer.  C++ forbids this from
  /// crossing between function and object types, but otherwise does
  /// not restrict it.  However, the only operation that is permitted
  /// on a "punned" member pointer is casting it back to the original
  /// type, which is required to be a lossless operation (although
  /// many ABIs do not guarantee this on all possible intermediate types).
  CK_ReinterpretMemberPointer(CK_MemberPointerToBoolean.getValue() + 1),
  
  /// CK_UserDefinedConversion - Conversion using a user defined type
  /// conversion function.
  ///    struct A { operator int(); }; int i = int(A());
  CK_UserDefinedConversion(CK_ReinterpretMemberPointer.getValue() + 1),
  
  /// CK_ConstructorConversion - Conversion by constructor.
  ///    struct A { A(int); }; A a = A(10);
  CK_ConstructorConversion(CK_UserDefinedConversion.getValue() + 1),
  
  /// CK_IntegralToPointer - Integral to pointer.  A special kind of
  /// reinterpreting conversion.  Applies to normal, ObjC, and block
  /// pointers.
  ///    (char*) 0x1001aab0
  ///    reinterpret_cast<int*>(0)
  CK_IntegralToPointer(CK_ConstructorConversion.getValue() + 1),
  
  /// CK_PointerToIntegral - Pointer to integral.  A special kind of
  /// reinterpreting conversion.  Applies to normal, ObjC, and block
  /// pointers.
  ///    (intptr_t) "help!"
  CK_PointerToIntegral(CK_IntegralToPointer.getValue() + 1),
  
  /// CK_PointerToBoolean - Pointer to boolean conversion.  A check
  /// against null.  Applies to normal, ObjC, and block pointers.
  CK_PointerToBoolean(CK_PointerToIntegral.getValue() + 1),
  
  /// CK_ToVoid - Cast to void, discarding the computed value.
  ///    (void) malloc(2048)
  CK_ToVoid(CK_PointerToBoolean.getValue() + 1),
  
  /// CK_VectorSplat - A conversion from an arithmetic type to a
  /// vector of that element type.  Fills all elements ("splats") with
  /// the source value.
  ///    __attribute__((ext_vector_type(4))) int v = 5;
  CK_VectorSplat(CK_ToVoid.getValue() + 1),
  
  /// CK_IntegralCast - A cast between integral types (other than to
  /// boolean).  Variously a bitcast, a truncation, a sign-extension,
  /// or a zero-extension.
  ///    long l = 5;
  ///    (unsigned) i
  CK_IntegralCast(CK_VectorSplat.getValue() + 1),
  
  /// CK_IntegralToBoolean - Integral to boolean.  A check against zero.
  ///    (bool) i
  CK_IntegralToBoolean(CK_IntegralCast.getValue() + 1),
  
  /// CK_IntegralToFloating - Integral to floating point.
  ///    float f = i;
  CK_IntegralToFloating(CK_IntegralToBoolean.getValue() + 1),
  
  /// CK_FloatingToIntegral - Floating point to integral.  Rounds
  /// towards zero, discarding any fractional component.
  ///    (int) f
  CK_FloatingToIntegral(CK_IntegralToFloating.getValue() + 1),
  
  /// CK_FloatingToBoolean - Floating point to boolean.
  ///    (bool) f
  CK_FloatingToBoolean(CK_FloatingToIntegral.getValue() + 1),
  
  // CK_BooleanToSignedIntegral - Convert a boolean to -1 or 0 for true and
  // false, respectively.
  CK_BooleanToSignedIntegral(CK_FloatingToBoolean.getValue() + 1),
  
  /// CK_FloatingCast - Casting between floating types of different size.
  ///    (double) f
  ///    (float) ld
  CK_FloatingCast(CK_BooleanToSignedIntegral.getValue() + 1),
  
  /// CK_CPointerToObjCPointerCast - Casting a C pointer kind to an
  /// Objective-C pointer.
  CK_CPointerToObjCPointerCast(CK_FloatingCast.getValue() + 1),
  
  /// CK_BlockPointerToObjCPointerCast - Casting a block pointer to an
  /// ObjC pointer.
  CK_BlockPointerToObjCPointerCast(CK_CPointerToObjCPointerCast.getValue() + 1),
  
  /// CK_AnyPointerToBlockPointerCast - Casting any non-block pointer
  /// to a block pointer.  Block-to-block casts are bitcasts.
  CK_AnyPointerToBlockPointerCast(CK_BlockPointerToObjCPointerCast.getValue() + 1),
  
  /// \brief Converting between two Objective-C object types, which
  /// can occur when performing reference binding to an Objective-C
  /// object.
  CK_ObjCObjectLValueCast(CK_AnyPointerToBlockPointerCast.getValue() + 1),
  
  /// \brief A conversion of a floating point real to a floating point
  /// complex of the original type.  Injects the value as the real
  /// component with a zero imaginary component.
  ///   float -> _Complex float
  CK_FloatingRealToComplex(CK_ObjCObjectLValueCast.getValue() + 1),
  
  /// \brief Converts a floating point complex to floating point real
  /// of the source's element type.  Just discards the imaginary
  /// component.
  ///   _Complex long double -> long double
  CK_FloatingComplexToReal(CK_FloatingRealToComplex.getValue() + 1),
  
  /// \brief Converts a floating point complex to bool by comparing
  /// against 0+0i.
  CK_FloatingComplexToBoolean(CK_FloatingComplexToReal.getValue() + 1),
  
  /// \brief Converts between different floating point complex types.
  ///   _Complex float -> _Complex double
  CK_FloatingComplexCast(CK_FloatingComplexToBoolean.getValue() + 1),
  
  /// \brief Converts from a floating complex to an integral complex.
  ///   _Complex float -> _Complex int
  CK_FloatingComplexToIntegralComplex(CK_FloatingComplexCast.getValue() + 1),
  
  /// \brief Converts from an integral real to an integral complex
  /// whose element type matches the source.  Injects the value as
  /// the real component with a zero imaginary component.
  ///   long -> _Complex long
  CK_IntegralRealToComplex(CK_FloatingComplexToIntegralComplex.getValue() + 1),
  
  /// \brief Converts an integral complex to an integral real of the
  /// source's element type by discarding the imaginary component.
  ///   _Complex short -> short
  CK_IntegralComplexToReal(CK_IntegralRealToComplex.getValue() + 1),
  
  /// \brief Converts an integral complex to bool by comparing against
  /// 0+0i.
  CK_IntegralComplexToBoolean(CK_IntegralComplexToReal.getValue() + 1),
  
  /// \brief Converts between different integral complex types.
  ///   _Complex char -> _Complex long long
  ///   _Complex unsigned int -> _Complex signed int
  CK_IntegralComplexCast(CK_IntegralComplexToBoolean.getValue() + 1),
  
  /// \brief Converts from an integral complex to a floating complex.
  ///   _Complex unsigned -> _Complex float
  CK_IntegralComplexToFloatingComplex(CK_IntegralComplexCast.getValue() + 1),
  
  /// \brief [ARC] Produces a retainable object pointer so that it may
  /// be consumed, e.g. by being passed to a consuming parameter.
  /// Calls objc_retain.
  CK_ARCProduceObject(CK_IntegralComplexToFloatingComplex.getValue() + 1),
  
  /// \brief [ARC] Consumes a retainable object pointer that has just
  /// been produced, e.g. as the return value of a retaining call.
  /// Enters a cleanup to call objc_release at some indefinite time.
  CK_ARCConsumeObject(CK_ARCProduceObject.getValue() + 1),
  
  /// \brief [ARC] Reclaim a retainable object pointer object that may
  /// have been produced and autoreleased as part of a function return
  /// sequence.
  CK_ARCReclaimReturnedObject(CK_ARCConsumeObject.getValue() + 1),
  
  /// \brief [ARC] Causes a value of block type to be copied to the
  /// heap, if it is not already there.  A number of other operations
  /// in ARC cause blocks to be copied; this is for cases where that
  /// would not otherwise be guaranteed, such as when casting to a
  /// non-block pointer type.
  CK_ARCExtendBlockObject(CK_ARCReclaimReturnedObject.getValue() + 1),
  
  /// \brief Converts from _Atomic(T) to T.
  CK_AtomicToNonAtomic(CK_ARCExtendBlockObject.getValue() + 1),
  /// \brief Converts from T to _Atomic(T).
  CK_NonAtomicToAtomic(CK_AtomicToNonAtomic.getValue() + 1),
  
  /// \brief Causes a block literal to by copied to the heap and then 
  /// autoreleased.
  ///
  /// This particular cast kind is used for the conversion from a C++11
  /// lambda expression to a block pointer.
  CK_CopyAndAutoreleaseBlockObject(CK_NonAtomicToAtomic.getValue() + 1),
  
  // Convert a builtin function to a function pointer; only allowed in the
  // callee of a call expression.
  CK_BuiltinFnToFnPtr(CK_CopyAndAutoreleaseBlockObject.getValue() + 1),
  
  // Convert a zero value for OpenCL event_t initialization.
  CK_ZeroToOCLEvent(CK_BuiltinFnToFnPtr.getValue() + 1),
  
  // Convert a pointer to a different address space.
  CK_AddressSpaceConversion(CK_ZeroToOCLEvent.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CastKind valueOf(int val) {
    CastKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CastKind[] VALUES;
    private static final CastKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CastKind kind : CastKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CastKind[min < 0 ? (1-min) : 0];
      VALUES = new CastKind[max >= 0 ? (1+max) : 0];
      for (CastKind kind : CastKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private CastKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CastKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CastKind)obj).value);}
  //</editor-fold>
}
