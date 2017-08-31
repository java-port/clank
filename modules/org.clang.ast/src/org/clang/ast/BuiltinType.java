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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// This class is used for builtin types like 'int'.  Builtin
/// types are always canonical and have a literal name field.
//<editor-fold defaultstate="collapsed" desc="clang::BuiltinType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2039,
 FQN="clang::BuiltinType", NM="_ZN5clang11BuiltinTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11BuiltinTypeE")
//</editor-fold>
public class BuiltinType extends /*public*/ Type {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2041,
   FQN="clang::BuiltinType::Kind", NM="_ZN5clang11BuiltinType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11BuiltinType4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    OCLImage1dRO(0),
    OCLImage1dArrayRO(OCLImage1dRO.getValue() + 1),
    OCLImage1dBufferRO(OCLImage1dArrayRO.getValue() + 1),
    OCLImage2dRO(OCLImage1dBufferRO.getValue() + 1),
    OCLImage2dArrayRO(OCLImage2dRO.getValue() + 1),
    OCLImage2dDepthRO(OCLImage2dArrayRO.getValue() + 1),
    OCLImage2dArrayDepthRO(OCLImage2dDepthRO.getValue() + 1),
    OCLImage2dMSAARO(OCLImage2dArrayDepthRO.getValue() + 1),
    OCLImage2dArrayMSAARO(OCLImage2dMSAARO.getValue() + 1),
    OCLImage2dMSAADepthRO(OCLImage2dArrayMSAARO.getValue() + 1),
    OCLImage2dArrayMSAADepthRO(OCLImage2dMSAADepthRO.getValue() + 1),
    OCLImage3dRO(OCLImage2dArrayMSAADepthRO.getValue() + 1),
    OCLImage1dWO(OCLImage3dRO.getValue() + 1),
    OCLImage1dArrayWO(OCLImage1dWO.getValue() + 1),
    OCLImage1dBufferWO(OCLImage1dArrayWO.getValue() + 1),
    OCLImage2dWO(OCLImage1dBufferWO.getValue() + 1),
    OCLImage2dArrayWO(OCLImage2dWO.getValue() + 1),
    OCLImage2dDepthWO(OCLImage2dArrayWO.getValue() + 1),
    OCLImage2dArrayDepthWO(OCLImage2dDepthWO.getValue() + 1),
    OCLImage2dMSAAWO(OCLImage2dArrayDepthWO.getValue() + 1),
    OCLImage2dArrayMSAAWO(OCLImage2dMSAAWO.getValue() + 1),
    OCLImage2dMSAADepthWO(OCLImage2dArrayMSAAWO.getValue() + 1),
    OCLImage2dArrayMSAADepthWO(OCLImage2dMSAADepthWO.getValue() + 1),
    OCLImage3dWO(OCLImage2dArrayMSAADepthWO.getValue() + 1),
    OCLImage1dRW(OCLImage3dWO.getValue() + 1),
    OCLImage1dArrayRW(OCLImage1dRW.getValue() + 1),
    OCLImage1dBufferRW(OCLImage1dArrayRW.getValue() + 1),
    OCLImage2dRW(OCLImage1dBufferRW.getValue() + 1),
    OCLImage2dArrayRW(OCLImage2dRW.getValue() + 1),
    OCLImage2dDepthRW(OCLImage2dArrayRW.getValue() + 1),
    OCLImage2dArrayDepthRW(OCLImage2dDepthRW.getValue() + 1),
    OCLImage2dMSAARW(OCLImage2dArrayDepthRW.getValue() + 1),
    OCLImage2dArrayMSAARW(OCLImage2dMSAARW.getValue() + 1),
    OCLImage2dMSAADepthRW(OCLImage2dArrayMSAARW.getValue() + 1),
    OCLImage2dArrayMSAADepthRW(OCLImage2dMSAADepthRW.getValue() + 1),
    OCLImage3dRW(OCLImage2dArrayMSAADepthRW.getValue() + 1),
    
    //===- Builtin Types ------------------------------------------------------===//
    
    // void
    Void(OCLImage3dRW.getValue() + 1),
    
    //===- Unsigned Types -----------------------------------------------------===//
    
    // 'bool' in C++, '_Bool' in C99
    Bool(Void.getValue() + 1),
    
    // 'char' for targets where it's unsigned
    Char_U(Bool.getValue() + 1),
    
    // 'unsigned char', explicitly qualified
    UChar(Char_U.getValue() + 1),
    
    // 'wchar_t' for targets where it's unsigned
    WChar_U(UChar.getValue() + 1),
    
    // 'char16_t' in C++
    Char16(WChar_U.getValue() + 1),
    
    // 'char32_t' in C++
    Char32(Char16.getValue() + 1),
    
    // 'unsigned short'
    UShort(Char32.getValue() + 1),
    
    // 'unsigned int'
    UInt(UShort.getValue() + 1),
    
    // 'unsigned long'
    ULong(UInt.getValue() + 1),
    
    // 'unsigned long long'
    ULongLong(ULong.getValue() + 1),
    
    // '__uint128_t'
    UInt128(ULongLong.getValue() + 1),
    
    //===- Signed Types -------------------------------------------------------===//
    
    // 'char' for targets where it's signed
    Char_S(UInt128.getValue() + 1),
    
    // 'signed char', explicitly qualified
    SChar(Char_S.getValue() + 1),
    
    // 'wchar_t' for targets where it's signed
    WChar_S(SChar.getValue() + 1),
    
    // 'short' or 'signed short'
    Short(WChar_S.getValue() + 1),
    
    // 'int' or 'signed int'
    Int(Short.getValue() + 1),
    
    // 'long' or 'signed long'
    Long(Int.getValue() + 1),
    
    // 'long long' or 'signed long long'
    LongLong(Long.getValue() + 1),
    
    // '__int128_t'
    Int128(LongLong.getValue() + 1),
    
    //===- Floating point types -----------------------------------------------===//
    
    // 'half' in OpenCL, '__fp16' in ARM NEON.
    Half(Int128.getValue() + 1),
    
    // 'float'
    Float(Half.getValue() + 1),
    
    // 'double'
    Double(Float.getValue() + 1),
    
    // 'long double'
    LongDouble(Double.getValue() + 1),
    
    // '__float128'
    Float128(LongDouble.getValue() + 1),
    
    //===- Language-specific types --------------------------------------------===//
    
    // This is the type of C++0x 'nullptr'.
    NullPtr(Float128.getValue() + 1),
    
    // The primitive Objective C 'id' type.  The user-visible 'id'
    // type is a typedef of an ObjCObjectPointerType to an
    // ObjCObjectType with this as its base.  In fact, this only ever
    // shows up in an AST as the base type of an ObjCObjectType.
    ObjCId(NullPtr.getValue() + 1),
    
    // The primitive Objective C 'Class' type.  The user-visible
    // 'Class' type is a typedef of an ObjCObjectPointerType to an
    // ObjCObjectType with this as its base.  In fact, this only ever
    // shows up in an AST as the base type of an ObjCObjectType.
    ObjCClass(ObjCId.getValue() + 1),
    
    // The primitive Objective C 'SEL' type.  The user-visible 'SEL'
    // type is a typedef of a PointerType to this.
    ObjCSel(ObjCClass.getValue() + 1),
    
    // OpenCL sampler_t.
    OCLSampler(ObjCSel.getValue() + 1),
    
    // OpenCL event_t.
    OCLEvent(OCLSampler.getValue() + 1),
    
    // OpenCL clk_event_t.
    OCLClkEvent(OCLEvent.getValue() + 1),
    
    // OpenCL queue_t.
    OCLQueue(OCLClkEvent.getValue() + 1),
    
    // OpenCL ndrange_t.
    OCLNDRange(OCLQueue.getValue() + 1),
    
    // OpenCL reserve_id_t.
    OCLReserveID(OCLNDRange.getValue() + 1),
    
    // This represents the type of an expression whose type is
    // totally unknown, e.g. 'T::foo'.  It is permitted for this to
    // appear in situations where the structure of the type is
    // theoretically deducible.
    Dependent(OCLReserveID.getValue() + 1),
    
    // The type of an unresolved overload set.  A placeholder type.
    // Expressions with this type have one of the following basic
    // forms, with parentheses generally permitted:
    //   foo          # possibly qualified, not if an implicit access
    //   foo          # possibly qualified, not if an implicit access
    //   &foo         # possibly qualified, not if an implicit access
    //   x->foo       # only if might be a static member function
    //   &x->foo      # only if might be a static member function
    //   &Class::foo  # when a pointer-to-member; sub-expr also has this type
    // OverloadExpr::find can be used to analyze the expression.
    //
    // Overload should be the first placeholder type, or else change
    // BuiltinType::isNonOverloadPlaceholderType()
    Overload(Dependent.getValue() + 1),
    
    // The type of a bound C++ non-static member function.
    // A placeholder type.  Expressions with this type have one of the
    // following basic forms:
    //   foo          # if an implicit access
    //   x->foo       # if only contains non-static members
    BoundMember(Overload.getValue() + 1),
    
    // The type of an expression which refers to a pseudo-object,
    // such as those introduced by Objective C's @property or
    // VS.NET's __property declarations.  A placeholder type.  The
    // pseudo-object is actually accessed by emitting a call to
    // some sort of function or method;  typically there is a pair
    // of a setter and a getter, with the setter used if the
    // pseudo-object reference is used syntactically as the
    // left-hand-side of an assignment operator.
    //
    // A pseudo-object reference naming an Objective-C @property is
    // always a dot access with a base of object-pointer type,
    // e.g. 'x.foo'.
    //
    // In VS.NET, a __property declaration creates an implicit
    // member with an associated name, which can then be named
    // in any of the normal ways an ordinary member could be.
    PseudoObject(BoundMember.getValue() + 1),
    
    // __builtin_any_type.  A placeholder type.  Useful for clients
    // like debuggers that don't know what type to give something.
    // Only a small number of operations are valid on expressions of
    // unknown type, most notably explicit casts.
    UnknownAny(PseudoObject.getValue() + 1),
    BuiltinFn(UnknownAny.getValue() + 1),
    
    // The type of a cast which, in ARC, would normally require a
    // __bridge, but which might be okay depending on the immediate
    // context.
    ARCUnbridgedCast(BuiltinFn.getValue() + 1),
    
    // A placeholder type for OpenMP array sections.
    OMPArraySection(ARCUnbridgedCast.getValue() + 1),
    LastKind(Kind.OMPArraySection.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::BuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2052,
   FQN="clang::BuiltinType::BuiltinType", NM="_ZN5clang11BuiltinTypeC1ENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11BuiltinTypeC1ENS0_4KindE")
  //</editor-fold>
  public BuiltinType(Kind K) {
    // : Type(Builtin, QualType(), /*Dependent=*/ (K == Dependent), /*InstantiationDependent=*/ (K == Dependent), /*VariablyModified=*/ false, /*Unexpanded paramter pack=*/ false) 
    //START JInit
    super(TypeClass.Builtin, new QualType(), (K == Kind.Dependent), 
        (K == Kind.Dependent), 
        false, 
        false);
    //END JInit
    Unnamed_field.BuiltinTypeBits.Kind = $uint2uint_8bits(K.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::getKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*uchar=>uint*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2060,
   FQN="clang::BuiltinType::getKind", NM="_ZNK5clang11BuiltinType7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return /*static_cast*/Kind.valueOf($8bits_uint2uint(Unnamed_field.BuiltinTypeBits.Kind));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2519,
   FQN="clang::BuiltinType::getName", NM="_ZNK5clang11BuiltinType7getNameERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType7getNameERKNS_14PrintingPolicyE")
  //</editor-fold>
  public StringRef getName(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (getKind()) {
     case Void:
      return new StringRef(/*KEEP_STR*/$void);
     case Bool:
      return new StringRef(Policy.Bool ? $bool : $_Bool);
     case Char_S:
      return new StringRef(/*KEEP_STR*/$char);
     case Char_U:
      return new StringRef(/*KEEP_STR*/$char);
     case SChar:
      return new StringRef(/*KEEP_STR*/$signed_char);
     case Short:
      return new StringRef(/*KEEP_STR*/$short);
     case Int:
      return new StringRef(/*KEEP_STR*/$int);
     case Long:
      return new StringRef(/*KEEP_STR*/$long);
     case LongLong:
      return new StringRef(/*KEEP_STR*/"long long");
     case Int128:
      return new StringRef(/*KEEP_STR*/$__int128);
     case UChar:
      return new StringRef(/*KEEP_STR*/$unsigned_char);
     case UShort:
      return new StringRef(/*KEEP_STR*/$unsigned_short);
     case UInt:
      return new StringRef(/*KEEP_STR*/$unsigned_int);
     case ULong:
      return new StringRef(/*KEEP_STR*/"unsigned long");
     case ULongLong:
      return new StringRef(/*KEEP_STR*/"unsigned long long");
     case UInt128:
      return new StringRef(/*KEEP_STR*/"unsigned __int128");
     case Half:
      return new StringRef(Policy.Half ? $half : $__fp16);
     case Float:
      return new StringRef(/*KEEP_STR*/$float);
     case Double:
      return new StringRef(/*KEEP_STR*/$double);
     case LongDouble:
      return new StringRef(/*KEEP_STR*/"long double");
     case Float128:
      return new StringRef(/*KEEP_STR*/$__float128);
     case WChar_S:
     case WChar_U:
      return new StringRef(Policy.MSWChar ? $__wchar_t : $wchar_t);
     case Char16:
      return new StringRef(/*KEEP_STR*/$char16_t);
     case Char32:
      return new StringRef(/*KEEP_STR*/$char32_t);
     case NullPtr:
      return new StringRef(/*KEEP_STR*/"nullptr_t");
     case Overload:
      return new StringRef(/*KEEP_STR*/"<overloaded function type>");
     case BoundMember:
      return new StringRef(/*KEEP_STR*/"<bound member function type>");
     case PseudoObject:
      return new StringRef(/*KEEP_STR*/"<pseudo-object type>");
     case Dependent:
      return new StringRef(/*KEEP_STR*/"<dependent type>");
     case UnknownAny:
      return new StringRef(/*KEEP_STR*/"<unknown type>");
     case ARCUnbridgedCast:
      return new StringRef(/*KEEP_STR*/"<ARC unbridged cast type>");
     case BuiltinFn:
      return new StringRef(/*KEEP_STR*/"<builtin fn type>");
     case ObjCId:
      return new StringRef(/*KEEP_STR*/"id");
     case ObjCClass:
      return new StringRef(/*KEEP_STR*/"Class");
     case ObjCSel:
      return new StringRef(/*KEEP_STR*/"SEL");
     case OCLImage1dRO:
      return new StringRef(/*KEEP_STR*/"__read_only image1d_t");
     case OCLImage1dArrayRO:
      return new StringRef(/*KEEP_STR*/"__read_only image1d_array_t");
     case OCLImage1dBufferRO:
      return new StringRef(/*KEEP_STR*/"__read_only image1d_buffer_t");
     case OCLImage2dRO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_t");
     case OCLImage2dArrayRO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_array_t");
     case OCLImage2dDepthRO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_depth_t");
     case OCLImage2dArrayDepthRO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_array_depth_t");
     case OCLImage2dMSAARO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_msaa_t");
     case OCLImage2dArrayMSAARO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_array_msaa_t");
     case OCLImage2dMSAADepthRO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_msaa_depth_t");
     case OCLImage2dArrayMSAADepthRO:
      return new StringRef(/*KEEP_STR*/"__read_only image2d_array_msaa_depth_t");
     case OCLImage3dRO:
      return new StringRef(/*KEEP_STR*/"__read_only image3d_t");
     case OCLImage1dWO:
      return new StringRef(/*KEEP_STR*/"__write_only image1d_t");
     case OCLImage1dArrayWO:
      return new StringRef(/*KEEP_STR*/"__write_only image1d_array_t");
     case OCLImage1dBufferWO:
      return new StringRef(/*KEEP_STR*/"__write_only image1d_buffer_t");
     case OCLImage2dWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_t");
     case OCLImage2dArrayWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_array_t");
     case OCLImage2dDepthWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_depth_t");
     case OCLImage2dArrayDepthWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_array_depth_t");
     case OCLImage2dMSAAWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_msaa_t");
     case OCLImage2dArrayMSAAWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_array_msaa_t");
     case OCLImage2dMSAADepthWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_msaa_depth_t");
     case OCLImage2dArrayMSAADepthWO:
      return new StringRef(/*KEEP_STR*/"__write_only image2d_array_msaa_depth_t");
     case OCLImage3dWO:
      return new StringRef(/*KEEP_STR*/"__write_only image3d_t");
     case OCLImage1dRW:
      return new StringRef(/*KEEP_STR*/"__read_write image1d_t");
     case OCLImage1dArrayRW:
      return new StringRef(/*KEEP_STR*/"__read_write image1d_array_t");
     case OCLImage1dBufferRW:
      return new StringRef(/*KEEP_STR*/"__read_write image1d_buffer_t");
     case OCLImage2dRW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_t");
     case OCLImage2dArrayRW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_array_t");
     case OCLImage2dDepthRW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_depth_t");
     case OCLImage2dArrayDepthRW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_array_depth_t");
     case OCLImage2dMSAARW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_msaa_t");
     case OCLImage2dArrayMSAARW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_array_msaa_t");
     case OCLImage2dMSAADepthRW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_msaa_depth_t");
     case OCLImage2dArrayMSAADepthRW:
      return new StringRef(/*KEEP_STR*/"__read_write image2d_array_msaa_depth_t");
     case OCLImage3dRW:
      return new StringRef(/*KEEP_STR*/"__read_write image3d_t");
     case OCLSampler:
      return new StringRef(/*KEEP_STR*/"sampler_t");
     case OCLEvent:
      return new StringRef(/*KEEP_STR*/"event_t");
     case OCLClkEvent:
      return new StringRef(/*KEEP_STR*/"clk_event_t");
     case OCLQueue:
      return new StringRef(/*KEEP_STR*/"queue_t");
     case OCLNDRange:
      return new StringRef(/*KEEP_STR*/"ndrange_t");
     case OCLReserveID:
      return new StringRef(/*KEEP_STR*/"reserve_id_t");
     case OMPArraySection:
      return new StringRef(/*KEEP_STR*/"<OpenMP array section type>");
    }
    throw new llvm_unreachable("Invalid builtin type.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::getNameAsCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2062,
   FQN="clang::BuiltinType::getNameAsCString", NM="_ZNK5clang11BuiltinType16getNameAsCStringERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType16getNameAsCStringERKNS_14PrintingPolicyE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getNameAsCString(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    // The StringRef is null-terminated.
    StringRef str = getName(Policy);
    assert (!str.empty() && str.data().$at(str.size()) == $$TERM);
    return str.data();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2069,
   FQN="clang::BuiltinType::isSugared", NM="_ZNK5clang11BuiltinType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2070,
   FQN="clang::BuiltinType::desugar", NM="_ZNK5clang11BuiltinType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2072,
   FQN="clang::BuiltinType::isInteger", NM="_ZNK5clang11BuiltinType9isIntegerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType9isIntegerEv")
  //</editor-fold>
  public boolean isInteger() /*const*/ {
    return getKind().getValue() >= Kind.Bool.getValue() && getKind().getValue() <= Kind.Int128.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isSignedInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2076,
   FQN="clang::BuiltinType::isSignedInteger", NM="_ZNK5clang11BuiltinType15isSignedIntegerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType15isSignedIntegerEv")
  //</editor-fold>
  public boolean isSignedInteger() /*const*/ {
    return getKind().getValue() >= Kind.Char_S.getValue() && getKind().getValue() <= Kind.Int128.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isUnsignedInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2080,
   FQN="clang::BuiltinType::isUnsignedInteger", NM="_ZNK5clang11BuiltinType17isUnsignedIntegerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType17isUnsignedIntegerEv")
  //</editor-fold>
  public boolean isUnsignedInteger() /*const*/ {
    return getKind().getValue() >= Kind.Bool.getValue() && getKind().getValue() <= Kind.UInt128.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isFloatingPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2084,
   FQN="clang::BuiltinType::isFloatingPoint", NM="_ZNK5clang11BuiltinType15isFloatingPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType15isFloatingPointEv")
  //</editor-fold>
  public boolean isFloatingPoint() /*const*/ {
    return getKind().getValue() >= Kind.Half.getValue() && getKind().getValue() <= Kind.Float128.getValue();
  }

  
  /// Determines whether the given kind corresponds to a placeholder type.
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isPlaceholderTypeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2089,
   FQN="clang::BuiltinType::isPlaceholderTypeKind", NM="_ZN5clang11BuiltinType21isPlaceholderTypeKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11BuiltinType21isPlaceholderTypeKindENS0_4KindE")
  //</editor-fold>
  public static boolean isPlaceholderTypeKind(Kind K) {
    return K.getValue() >= Kind.Overload.getValue();
  }

  
  /// Determines whether this type is a placeholder type, i.e. a type
  /// which cannot appear in arbitrary positions in a fully-formed
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2096,
   FQN="clang::BuiltinType::isPlaceholderType", NM="_ZNK5clang11BuiltinType17isPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType17isPlaceholderTypeEv")
  //</editor-fold>
  public boolean isPlaceholderType() /*const*/ {
    return isPlaceholderTypeKind(getKind());
  }

  
  /// Determines whether this type is a placeholder type other than
  /// Overload.  Most placeholder types require only syntactic
  /// information about their context in order to be resolved (e.g.
  /// whether it is a call expression), which means they can (and
  /// should) be resolved in an earlier "phase" of analysis.
  /// Overload expressions sometimes pick up further information
  /// from their context, like whether the context expects a
  /// specific function-pointer type, and so frequently need
  /// special treatment.
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::isNonOverloadPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2109,
   FQN="clang::BuiltinType::isNonOverloadPlaceholderType", NM="_ZNK5clang11BuiltinType28isNonOverloadPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11BuiltinType28isNonOverloadPlaceholderTypeEv")
  //</editor-fold>
  public boolean isNonOverloadPlaceholderType() /*const*/ {
    return getKind().getValue() > Kind.Overload.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2113,
   FQN="clang::BuiltinType::classof", NM="_ZN5clang11BuiltinType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11BuiltinType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Builtin;
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
