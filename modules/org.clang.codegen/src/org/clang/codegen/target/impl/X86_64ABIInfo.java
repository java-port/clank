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

package org.clang.codegen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import org.clang.ast.VectorType;
import org.llvm.ir.Type;
import org.clang.ast.DeclContext.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.cast_CXXRecordDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_CXXRecordDecl;
import static org.llvm.ir.java.IrRTTI.*;


/// X86_64ABIInfo - The X86_64 ABI information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1822,
 FQN="(anonymous namespace)::X86_64ABIInfo", NM="_ZN12_GLOBAL__N_113X86_64ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_64ABIInfoE")
//</editor-fold>
public class X86_64ABIInfo extends /*public*/ SwiftABIInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::Class">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1823,
   FQN="(anonymous namespace)::X86_64ABIInfo::Class", NM="_ZN12_GLOBAL__N_113X86_64ABIInfo5ClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_64ABIInfo5ClassE")
  //</editor-fold>
  private enum Class implements Native.NativeUIntEnum {
    Integer(0),
    SSE(Integer.getValue() + 1),
    SSEUp(SSE.getValue() + 1),
    X87(SSEUp.getValue() + 1),
    X87Up(X87.getValue() + 1),
    ComplexX87(X87Up.getValue() + 1),
    NoClass(ComplexX87.getValue() + 1),
    Memory(NoClass.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Class valueOf(int val) {
      Class out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Class[] VALUES;
      private static final Class[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Class kind : Class.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Class[min < 0 ? (1-min) : 0];
        VALUES = new Class[max >= 0 ? (1+max) : 0];
        for (Class kind : Class.values()) {
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
    private Class(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// merge - Implement the X86_64 ABI merging algorithm.
  ///
  /// Merge an accumulating classification \arg Accum with a field
  /// classification \arg Field.
  ///
  /// \param Accum - The accumulating classification. This should
  /// always be either NoClass or the result of a previous merge
  /// call. In addition, this should never be Memory (the caller
  /// should just return Memory for the aggregate).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::merge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2249,
   FQN="(anonymous namespace)::X86_64ABIInfo::merge", NM="_ZN12_GLOBAL__N_113X86_64ABIInfo5mergeENS0_5ClassES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_64ABIInfo5mergeENS0_5ClassES1_")
  //</editor-fold>
  private static X86_64ABIInfo.Class merge(Class Accum, Class Field) {
    // AMD64-ABI 3.2.3p2: Rule 4. Each field of an object is
    // classified recursively so that always two fields are
    // considered. The resulting class is calculated according to
    // the classes of the fields in the eightbyte:
    //
    // (a) If both classes are equal, this is the resulting class.
    //
    // (b) If one of the classes is NO_CLASS, the resulting class is
    // the other class.
    //
    // (c) If one of the classes is MEMORY, the result is the MEMORY
    // class.
    //
    // (d) If one of the classes is INTEGER, the result is the
    // INTEGER.
    //
    // (e) If one of the classes is X87, X87UP, COMPLEX_X87 class,
    // MEMORY is used as class.
    //
    // (f) Otherwise class SSE is used.
    
    // Accum should never be memory (we should have returned) or
    // ComplexX87 (because this cannot be passed in a structure).
    assert ((Accum != Class.Memory && Accum != Class.ComplexX87)) : "Invalid accumulated classification during merge.";
    if (Accum == Field || Field == Class.NoClass) {
      return Accum;
    }
    if (Field == Class.Memory) {
      return Class.Memory;
    }
    if (Accum == Class.NoClass) {
      return Field;
    }
    if (Accum == Class.Integer || Field == Class.Integer) {
      return Class.Integer;
    }
    if (Field == Class.X87 || Field == Class.X87Up || Field == Class.ComplexX87
       || Accum == Class.X87 || Accum == Class.X87Up) {
      return Class.Memory;
    }
    return Class.SSE;
  }

  
  /// postMerge - Implement the X86_64 ABI post merging algorithm.
  ///
  /// Post merger cleanup, reduces a malformed Hi and Lo pair to
  /// final MEMORY or SSE classes when necessary.
  ///
  /// \param AggregateSize - The size of the current aggregate in
  /// the classification process.
  ///
  /// \param Lo - The classification for the parts of the type
  /// residing in the low word of the containing object.
  ///
  /// \param Hi - The classification for the parts of the type
  /// residing in the higher words of the containing object.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::postMerge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2216,
   FQN="(anonymous namespace)::X86_64ABIInfo::postMerge", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo9postMergeEjRNS0_5ClassES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo9postMergeEjRNS0_5ClassES2_")
  //</editor-fold>
  private void postMerge(/*uint*/int AggregateSize, final type$ref<Class /*&*/> Lo, 
           final type$ref<Class /*&*/> Hi) /*const*/ {
    // AMD64-ABI 3.2.3p2: Rule 5. Then a post merger cleanup is done:
    //
    // (a) If one of the classes is Memory, the whole argument is passed in
    //     memory.
    //
    // (b) If X87UP is not preceded by X87, the whole argument is passed in
    //     memory.
    //
    // (c) If the size of the aggregate exceeds two eightbytes and the first
    //     eightbyte isn't SSE or any other eightbyte isn't SSEUP, the whole
    //     argument is passed in memory. NOTE: This is necessary to keep the
    //     ABI working for processors that don't support the __m256 type.
    //
    // (d) If SSEUP is not preceded by SSE or SSEUP, it is converted to SSE.
    //
    // Some of these are enforced by the merging logic.  Others can arise
    // only with unions; for example:
    //   union { _Complex double; unsigned; }
    //
    // Note that clauses (b) and (c) were added in 0.98.
    //
    if (Hi.$deref() == Class.Memory) {
      Lo.$set(Class.Memory);
    }
    if (Hi.$deref() == Class.X87Up && Lo.$deref() != Class.X87 && honorsRevision0_98()) {
      Lo.$set(Class.Memory);
    }
    if ($greater_uint(AggregateSize, 128) && (Lo.$deref() != Class.SSE || Hi.$deref() != Class.SSEUp)) {
      Lo.$set(Class.Memory);
    }
    if (Hi.$deref() == Class.SSEUp && Lo.$deref() != Class.SSE) {
      Hi.$set(Class.SSE);
    }
  }

  
  /// classify - Determine the x86_64 register classes in which the
  /// given type T should be passed.
  ///
  /// \param Lo - The classification for the parts of the type
  /// residing in the low word of the containing object.
  ///
  /// \param Hi - The classification for the parts of the type
  /// residing in the high word of the containing object.
  ///
  /// \param OffsetBase - The bit offset of this type in the
  /// containing object.  Some parameters are classified different
  /// depending on whether they straddle an eightbyte boundary.
  ///
  /// \param isNamedArg - Whether the argument in question is a "named"
  /// argument, as used in AMD64-ABI 3.5.7.
  ///
  /// If a word is unused its result will be NoClass; if a type should
  /// be passed in Memory then at least the classification of \arg Lo
  /// will be Memory.
  ///
  /// The \arg Lo class will be NoClass iff the argument is ignored.
  ///
  /// If the \arg Lo class is ComplexX87, then the \arg Hi class will
  /// also be ComplexX87.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::classify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2289,
   FQN="(anonymous namespace)::X86_64ABIInfo::classify", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo8classifyEN5clang8QualTypeEyRNS0_5ClassES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo8classifyEN5clang8QualTypeEyRNS0_5ClassES4_b")
  //</editor-fold>
  private void classify(QualType Ty, long/*uint64_t*/ OffsetBase, 
          final type$ref<Class /*&*/> Lo, final type$ref<Class /*&*/> Hi, boolean isNamedArg) /*const*/ {
    // FIXME: This code can be simplified by introducing a simple value class for
    // Class pairs with appropriate constructor methods for the various
    // situations.
    
    // FIXME: Some of the split computations are wrong; unaligned vectors
    // shouldn't be passed in registers for example, so there is no chance they
    // can straddle an eightbyte. Verify & simplify.
    Lo.$set(Hi.$set(Class.NoClass));
    
    final type$ref<Class /*&*/> Current = $less_ulong_ullong(OffsetBase, $int2ullong(64)) ? Lo : Hi;
    Current.$set(Class.Memory);
    {
      
      /*const*/ BuiltinType /*P*/ BT = Ty.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        BuiltinType.Kind k = BT.getKind();
        if (k == BuiltinType.Kind.Void) {
          Current.$set(Class.NoClass);
        } else if (k == BuiltinType.Kind.Int128 || k == BuiltinType.Kind.UInt128) {
          Lo.$set(Class.Integer);
          Hi.$set(Class.Integer);
        } else if (k.getValue() >= BuiltinType.Kind.Bool.getValue() && k.getValue() <= BuiltinType.Kind.LongLong.getValue()) {
          Current.$set(Class.Integer);
        } else if (k == BuiltinType.Kind.Float || k == BuiltinType.Kind.Double) {
          Current.$set(Class.SSE);
        } else if (k == BuiltinType.Kind.LongDouble) {
          /*const*/ fltSemantics /*P*/ LDF = /*AddrOf*/getTarget().getLongDoubleFormat();
          if (LDF == /*AddrOf*/APFloat.IEEEquad) {
            Lo.$set(Class.SSE);
            Hi.$set(Class.SSEUp);
          } else if (LDF == /*AddrOf*/APFloat.x87DoubleExtended) {
            Lo.$set(Class.X87);
            Hi.$set(Class.X87Up);
          } else if (LDF == /*AddrOf*/APFloat.IEEEdouble) {
            Current.$set(Class.SSE);
          } else {
            throw new llvm_unreachable("unexpected long double representation!");
          }
        }
        // FIXME: _Decimal32 and _Decimal64 are SSE.
        // FIXME: _float128 and _Decimal128 are (SSE, SSEUp).
        return;
      }
    }
    {
      
      /*const*/ EnumType /*P*/ ET = Ty.$arrow().getAs$EnumType();
      if ((ET != null)) {
        // Classify the underlying integer type.
        classify(ET.getDecl().getIntegerType(), OffsetBase, Lo, Hi, isNamedArg);
        return;
      }
    }
    if (Ty.$arrow().hasPointerRepresentation()) {
      Current.$set(Class.Integer);
      return;
    }
    if (Ty.$arrow().isMemberPointerType()) {
      if (Ty.$arrow().isMemberFunctionPointerType()) {
        if (Has64BitPointers) {
          // If Has64BitPointers, this is an {i64, i64}, so classify both
          // Lo and Hi now.
          Lo.$set(Hi.$set(Class.Integer));
        } else {
          // Otherwise, with 32-bit pointers, this is an {i32, i32}. If that
          // straddles an eightbyte boundary, Hi should be classified as well.
          long/*uint64_t*/ EB_FuncPtr = $div_ulong_ullong((OffsetBase), $int2ullong(64));
          long/*uint64_t*/ EB_ThisAdj = $div_ullong((OffsetBase + $int2ullong(64) - $int2ullong(1)), $int2ullong(64));
          if (EB_FuncPtr != EB_ThisAdj) {
            Lo.$set(Hi.$set(Class.Integer));
          } else {
            Current.$set(Class.Integer);
          }
        }
      } else {
        Current.$set(Class.Integer);
      }
      return;
    }
    {
      
      /*const*/ VectorType /*P*/ VT = Ty.$arrow().getAs(VectorType.class);
      if ((VT != null)) {
        long/*uint64_t*/ Size = getContext().getTypeSize(VT);
        if (Size == $int2ullong(1) || Size == $int2ullong(8) || Size == $int2ullong(16) || Size == $int2ullong(32)) {
          // gcc passes the following as integer:
          // 4 bytes - <4 x char>, <2 x short>, <1 x int>, <1 x float>
          // 2 bytes - <2 x char>, <1 x short>
          // 1 byte  - <1 x char>
          Current.$set(Class.Integer);
          
          // If this type crosses an eightbyte boundary, it should be
          // split.
          long/*uint64_t*/ EB_Lo = $div_ulong_ullong((OffsetBase), $int2ullong(64));
          long/*uint64_t*/ EB_Hi = $div_ullong((OffsetBase + Size - $int2ullong(1)), $int2ullong(64));
          if (EB_Lo != EB_Hi) {
            Hi.$set(Lo.$deref());
          }
        } else if (Size == $int2ullong(64)) {
          QualType ElementType = VT.getElementType();
          
          // gcc passes <1 x double> in memory. :(
          if (ElementType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Double.getValue())) {
            return;
          }
          
          // gcc passes <1 x long long> as SSE but clang used to unconditionally
          // pass them as integer.  For platforms where clang is the de facto
          // platform compiler, we must continue to use integer.
          if (!classifyIntegerMMXAsSSE()
             && (ElementType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.LongLong.getValue())
             || ElementType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.ULongLong.getValue())
             || ElementType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Long.getValue())
             || ElementType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.ULong.getValue()))) {
            Current.$set(Class.Integer);
          } else {
            Current.$set(Class.SSE);
          }
          
          // If this type crosses an eightbyte boundary, it should be
          // split.
          if ((OffsetBase != 0) && OffsetBase != $int2ullong(64)) {
            Hi.$set(Lo.$deref());
          }
        } else if (Size == $int2ullong(128)
           || (isNamedArg && $lesseq_ulong_uint(Size, getNativeVectorSizeForAVXABI(AVXLevel)))) {
          // Arguments of 256-bits are split into four eightbyte chunks. The
          // least significant one belongs to class SSE and all the others to class
          // SSEUP. The original Lo and Hi design considers that types can't be
          // greater than 128-bits, so a 64-bit split in Hi and Lo makes sense.
          // This design isn't correct for 256-bits, but since there're no cases
          // where the upper parts would need to be inspected, avoid adding
          // complexity and just consider Hi to match the 64-256 part.
          //
          // Note that per 3.5.7 of AMD64-ABI, 256-bit args are only passed in
          // registers if they are "named", i.e. not part of the "..." of a
          // variadic function.
          //
          // Similarly, per 3.2.3. of the AVX512 draft, 512-bits ("named") args are
          // split into eight eightbyte chunks, one SSE and seven SSEUP.
          Lo.$set(Class.SSE);
          Hi.$set(Class.SSEUp);
        }
        return;
      }
    }
    {
      
      /*const*/ ComplexType /*P*/ CT = Ty.$arrow().getAs(ComplexType.class);
      if ((CT != null)) {
        QualType ET = getContext().getCanonicalType(CT.getElementType()).$QualType();
        
        long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
        if (ET.$arrow().isIntegralOrEnumerationType()) {
          if ($lesseq_ulong_ullong(Size, $int2ullong(64))) {
            Current.$set(Class.Integer);
          } else if ($lesseq_ulong_ullong(Size, $int2ullong(128))) {
            Lo.$set(Hi.$set(Class.Integer));
          }
        } else if (QualType.$eq_QualType$C(ET, getContext().FloatTy.$QualType())) {
          Current.$set(Class.SSE);
        } else if (QualType.$eq_QualType$C(ET, getContext().DoubleTy.$QualType())) {
          Lo.$set(Hi.$set(Class.SSE));
        } else if (QualType.$eq_QualType$C(ET, getContext().LongDoubleTy.$QualType())) {
          /*const*/ fltSemantics /*P*/ LDF = /*AddrOf*/getTarget().getLongDoubleFormat();
          if (LDF == /*AddrOf*/APFloat.IEEEquad) {
            Current.$set(Class.Memory);
          } else if (LDF == /*AddrOf*/APFloat.x87DoubleExtended) {
            Current.$set(Class.ComplexX87);
          } else if (LDF == /*AddrOf*/APFloat.IEEEdouble) {
            Lo.$set(Hi.$set(Class.SSE));
          } else {
            throw new llvm_unreachable("unexpected long double representation!");
          }
        }
        
        // If this complex type crosses an eightbyte boundary then it
        // should be split.
        long/*uint64_t*/ EB_Real = $div_ulong_ullong((OffsetBase), $int2ullong(64));
        long/*uint64_t*/ EB_Imag = $div_ullong((OffsetBase + getContext().getTypeSize(new QualType(ET))), $int2ullong(64));
        if (Hi.$deref() == Class.NoClass && EB_Real != EB_Imag) {
          Hi.$set(Lo.$deref());
        }
        
        return;
      }
    }
    {
      
      /*const*/ ConstantArrayType /*P*/ AT = getContext().getAsConstantArrayType(new QualType(Ty));
      if ((AT != null)) {
        // Arrays are treated like structures.
        long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
        
        // AMD64-ABI 3.2.3p2: Rule 1. If the size of an object is larger
        // than four eightbytes, ..., it has class MEMORY.
        if ($greater_ulong_ullong(Size, $int2ullong(256))) {
          return;
        }
        
        // AMD64-ABI 3.2.3p2: Rule 1. If ..., or it contains unaligned
        // fields, it has class MEMORY.
        //
        // Only need to check alignment of array base.
        if ((($rem_ulong_uint(OffsetBase, getContext().getTypeAlign(AT.getElementType()))) != 0)) {
          return;
        }
        
        // Otherwise implement simplified merge. We could be smarter about
        // this, but it isn't worth it and would be harder to verify.
        Current.$set(Class.NoClass);
        long/*uint64_t*/ EltSize = getContext().getTypeSize(AT.getElementType());
        long/*uint64_t*/ ArraySize = AT.getSize().getZExtValue();
        
        // The only case a 256-bit wide vector could be used is when the array
        // contains a single 256-bit element. Since Lo and Hi logic isn't extended
        // to work for sizes wider than 128, early check and fallback to memory.
        if ($greater_ulong_ullong(Size, $int2ullong(128)) && EltSize != $int2ullong(256)) {
          return;
        }
        
        for (long/*uint64_t*/ i = $int2ulong(0), Offset = OffsetBase; $less_ulong(i, ArraySize); ++i , Offset += EltSize) {
          type$ref<Class> FieldLo = create_type$ref();
          type$ref<Class> FieldHi = create_type$ref();
          classify(AT.getElementType(), Offset, FieldLo, FieldHi, isNamedArg);
          Lo.$set(merge(Lo.$deref(), FieldLo.$deref()));
          Hi.$set(merge(Hi.$deref(), FieldHi.$deref()));
          if (Lo.$deref() == Class.Memory || Hi.$deref() == Class.Memory) {
            break;
          }
        }
        
        postMerge($ulong2uint(Size), Lo, Hi);
        assert ((Hi.$deref() != Class.SSEUp || Lo.$deref() == Class.SSE)) : "Invalid SSEUp array classification.";
        return;
      }
    }
    {
      
      /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
      if ((RT != null)) {
        long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
        
        // AMD64-ABI 3.2.3p2: Rule 1. If the size of an object is larger
        // than four eightbytes, ..., it has class MEMORY.
        if ($greater_ulong_ullong(Size, $int2ullong(256))) {
          return;
        }
        
        // AMD64-ABI 3.2.3p2: Rule 2. If a C++ object has either a non-trivial
        // copy constructor or a non-trivial destructor, it is passed by invisible
        // reference.
        if ((getRecordArgABI(RT, getCXXABI()).getValue() != 0)) {
          return;
        }
        
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        
        // Assume variable sized types are passed in memory.
        if (RD.hasFlexibleArrayMember()) {
          return;
        }
        
        final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(RD);
        
        // Reset Lo class, this will be recomputed.
        Current.$set(Class.NoClass);
        {
          
          // If this is a C++ record, classify the bases first.
          /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
          if ((CXXRD != null)) {
            for (final /*const*/ CXXBaseSpecifier /*&*/ I : CXXRD.bases$Const()) {
              assert (!I.isVirtual() && !I.getType().$arrow().isDependentType()) : "Unexpected base class!";
              /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
              
              // Classify this field.
              //
              // AMD64-ABI 3.2.3p2: Rule 3. If the size of the aggregate exceeds a
              // single eightbyte, each is classified separately. Each eightbyte gets
              // initialized to class NO_CLASS.
              type$ref<Class> FieldLo = create_type$ref();
              type$ref<Class> FieldHi = create_type$ref();
              long/*uint64_t*/ Offset = OffsetBase + getContext().toBits(Layout.getBaseClassOffset(Base));
              classify(I.getType(), Offset, FieldLo, FieldHi, isNamedArg);
              Lo.$set(merge(Lo.$deref(), FieldLo.$deref()));
              Hi.$set(merge(Hi.$deref(), FieldHi.$deref()));
              if (Lo.$deref() == Class.Memory || Hi.$deref() == Class.Memory) {
                postMerge($ulong2uint(Size), Lo, Hi);
                return;
              }
            }
          }
        }
        
        // Classify the fields one at a time, merging the results.
        /*uint*/int idx = 0;
        for (specific_decl_iterator<FieldDecl> i = RD.field_begin(), e = RD.field_end();
             specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc() , ++idx) {
          long/*uint64_t*/ Offset = OffsetBase + Layout.getFieldOffset(idx);
          boolean BitField = i.$arrow().isBitField();
          
          // AMD64-ABI 3.2.3p2: Rule 1. If the size of an object is larger than
          // four eightbytes, or it contains unaligned fields, it has class MEMORY.
          //
          // The only case a 256-bit wide vector could be used is when the struct
          // contains a single 256-bit element. Since Lo and Hi logic isn't extended
          // to work for sizes wider than 128, early check and fallback to memory.
          //
          if ($greater_ulong_ullong(Size, $int2ullong(128)) && getContext().getTypeSize(i.$arrow().getType()) != $int2ullong(256)) {
            Lo.$set(Class.Memory);
            postMerge($ulong2uint(Size), Lo, Hi);
            return;
          }
          // Note, skip this test for bit-fields, see below.
          if (!BitField && (($rem_ulong_uint(Offset, getContext().getTypeAlign(i.$arrow().getType()))) != 0)) {
            Lo.$set(Class.Memory);
            postMerge($ulong2uint(Size), Lo, Hi);
            return;
          }
          
          // Classify this field.
          //
          // AMD64-ABI 3.2.3p2: Rule 3. If the size of the aggregate
          // exceeds a single eightbyte, each is classified
          // separately. Each eightbyte gets initialized to class
          // NO_CLASS.
          type$ref<Class> FieldLo = create_type$ref();
          type$ref<Class> FieldHi = create_type$ref();
          
          // Bit-fields require special handling, they do not force the
          // structure to be passed in memory even if unaligned, and
          // therefore they can straddle an eightbyte.
          if (BitField) {
            // Ignore padding bit-fields.
            if (i.$arrow().isUnnamedBitfield()) {
              continue;
            }
            
            long/*uint64_t*/ Offset$1 = OffsetBase + Layout.getFieldOffset(idx);
            long/*uint64_t*/ Size$1 = $uint2ulong(i.$arrow().getBitWidthValue(getContext()));
            
            long/*uint64_t*/ EB_Lo = $div_ulong_ullong(Offset$1, $int2ullong(64));
            long/*uint64_t*/ EB_Hi = $div_ullong((Offset$1 + Size$1 - $int2ullong(1)), $int2ullong(64));
            if ((EB_Lo != 0)) {
              assert (EB_Hi == EB_Lo) : "Invalid classification, type > 16 bytes.";
              FieldLo.$set(Class.NoClass);
              FieldHi.$set(Class.Integer);
            } else {
              FieldLo.$set(Class.Integer);
              FieldHi.$set((EB_Hi != 0) ? Class.Integer : Class.NoClass);
            }
          } else {
            classify(i.$arrow().getType(), Offset, FieldLo, FieldHi, isNamedArg);
          }
          Lo.$set(merge(Lo.$deref(), FieldLo.$deref()));
          Hi.$set(merge(Hi.$deref(), FieldHi.$deref()));
          if (Lo.$deref() == Class.Memory || Hi.$deref() == Class.Memory) {
            break;
          }
        }
        
        postMerge($ulong2uint(Size), Lo, Hi);
      }
    }
  }

  
  
  /// The ABI specifies that a value should be passed in a full vector XMM/YMM
  /// register. Pick an LLVM IR type that will be passed as a vector register.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::GetByteVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2713,
   FQN="(anonymous namespace)::X86_64ABIInfo::GetByteVectorType", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo17GetByteVectorTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo17GetByteVectorTypeEN5clang8QualTypeE")
  //</editor-fold>
  private org.llvm.ir.Type /*P*/ GetByteVectorType(QualType Ty) /*const*/ {
    {
      // Wrapper structs/arrays that only contain vectors are passed just like
      // vectors; strip them off if present.
      /*const*/ org.clang.ast.Type /*P*/ InnerTy = isSingleElementStruct(new QualType(Ty), getContext());
      if ((InnerTy != null)) {
        Ty.$assignMove(new QualType(InnerTy, 0));
      }
    }
    
    org.llvm.ir.Type /*P*/ IRType = CGT.ConvertType(new QualType(Ty));
    if (isa_VectorType(IRType)
       || IRType.getTypeID() == Type.TypeID.FP128TyID) {
      return IRType;
    }
    
    // We couldn't find the preferred IR vector type for 'Ty'.
    long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
    assert ((Size == $int2ullong(128) || Size == $int2ullong(256))) : "Invalid type found!";
    
    // Return a LLVM IR vector type based on the size of 'Ty'.
    return org.llvm.ir.VectorType.get(Type.getDoubleTy(getVMContext()), 
        $ullong2uint($div_ulong_ullong(Size, $int2ullong(64))));
  }

  
  /// GetSSETypeAtOffset - Return a type that will be passed by the backend in the
  /// low 8 bytes of an XMM register, corresponding to the SSE class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::GetSSETypeAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2849,
   FQN="(anonymous namespace)::X86_64ABIInfo::GetSSETypeAtOffset", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo18GetSSETypeAtOffsetEPN4llvm4TypeEjN5clang8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo18GetSSETypeAtOffsetEPN4llvm4TypeEjN5clang8QualTypeEj")
  //</editor-fold>
  private Type /*P*/ GetSSETypeAtOffset(Type /*P*/ IRType, /*uint*/int IROffset, 
                    QualType SourceTy, /*uint*/int SourceOffset) /*const*/ {
    // The only three choices we have are either double, <2 x float>, or float. We
    // pass as float if the last 4 bytes is just padding.  This happens for
    // structs that contain 3 floats.
    if (BitsContainNoUserData(new QualType(SourceTy), SourceOffset * 8 + 32, 
        SourceOffset * 8 + 64, getContext())) {
      return Type.getFloatTy(getVMContext());
    }
    
    // We want to pass as <2 x float> if the LLVM IR type contains a float at
    // offset+0 and offset+4.  Walk the LLVM IR type to find out if this is the
    // case.
    if (ContainsFloatAtOffset(IRType, IROffset, getDataLayout())
       && ContainsFloatAtOffset(IRType, IROffset + 4, getDataLayout())) {
      return org.llvm.ir.VectorType.get(Type.getFloatTy(getVMContext()), 2);
    }
    
    return Type.getDoubleTy(getVMContext());
  }

  
  /// GetINTEGERTypeAtOffset - The ABI specifies that a value should be passed in
  /// an 8-byte GPR.  This means that we either have a scalar or we are talking
  /// about the high or low part of an up-to-16-byte struct.  This routine picks
  /// the best LLVM IR type to represent this, which may be i64 or may be anything
  /// else that the backend will pass in a GPR that works better (e.g. i8, %foo*,
  /// etc).
  ///
  /// PrefType is an LLVM IR type that corresponds to (part of) the IR type for
  /// the source type.  IROffset is an offset in bytes into the LLVM IR type that
  /// the 8-byte value references.  PrefType may be null.
  ///
  /// SourceTy is the source-level type for the entire argument.  SourceOffset is
  /// an offset into this that we're processing (which is always either 0 or 8).
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::GetINTEGERTypeAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2884,
   FQN="(anonymous namespace)::X86_64ABIInfo::GetINTEGERTypeAtOffset", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo22GetINTEGERTypeAtOffsetEPN4llvm4TypeEjN5clang8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo22GetINTEGERTypeAtOffsetEPN4llvm4TypeEjN5clang8QualTypeEj")
  //</editor-fold>
  private Type /*P*/ GetINTEGERTypeAtOffset(Type /*P*/ IRType, /*uint*/int IROffset, 
                        QualType SourceTy, /*uint*/int SourceOffset) /*const*/ {
    // If we're dealing with an un-offset LLVM IR type, then it means that we're
    // returning an 8-byte unit starting with it.  See if we can safely use it.
    if (IROffset == 0) {
      // Pointers and int64's always fill the 8-byte unit.
      if ((isa_PointerType(IRType) && Has64BitPointers)
         || IRType.isIntegerTy(64)) {
        return IRType;
      }
      
      // If we have a 1/2/4-byte integer, we can use it only if the rest of the
      // goodness in the source type is just tail padding.  This is allowed to
      // kick in for struct {double,int} on the int, but not on
      // struct{double,int,int} because we wouldn't return the second int.  We
      // have to do this analysis on the source type because we can't depend on
      // unions being lowered a specific way etc.
      if (IRType.isIntegerTy(8) || IRType.isIntegerTy(16)
         || IRType.isIntegerTy(32)
         || (isa_PointerType(IRType) && !Has64BitPointers)) {
        /*uint*/int BitWidth = isa_PointerType(IRType) ? 32 : cast_IntegerType(IRType).getBitWidth();
        if (BitsContainNoUserData(new QualType(SourceTy), SourceOffset * 8 + BitWidth, 
            SourceOffset * 8 + 64, getContext())) {
          return IRType;
        }
      }
    }
    {
      
      StructType /*P*/ STy = dyn_cast_StructType(IRType);
      if ((STy != null)) {
        // If this is a struct, recurse into the field at the specified offset.
        /*const*/ StructLayout /*P*/ SL = getDataLayout().getStructLayout(STy);
        if ($less_uint_ulong(IROffset, SL.getSizeInBytes())) {
          /*uint*/int FieldIdx = SL.getElementContainingOffset($uint2ulong(IROffset));
          IROffset -= SL.getElementOffset(FieldIdx);
          
          return GetINTEGERTypeAtOffset(STy.getElementType(FieldIdx), IROffset, 
              new QualType(SourceTy), SourceOffset);
        }
      }
    }
    {
      
      org.llvm.ir.ArrayType /*P*/ ATy = dyn_cast_ArrayType(IRType);
      if ((ATy != null)) {
        Type /*P*/ EltTy = ATy.getElementType();
        /*uint*/int EltSize = $ulong2uint(getDataLayout().getTypeAllocSize(EltTy));
        /*uint*/int EltOffset = $div_uint(IROffset, EltSize) * EltSize;
        return GetINTEGERTypeAtOffset(EltTy, IROffset - EltOffset, new QualType(SourceTy), 
            SourceOffset);
      }
    }
    
    // Okay, we don't have any better idea of what to pass, so we pass this in an
    // integer register that isn't too big to fit the rest of the struct.
    /*uint*/int TySizeInBytes = (/*uint*/int)$long2uint(getContext().getTypeSizeInChars(/*NO_COPY*/SourceTy).getQuantity());
    assert (TySizeInBytes != SourceOffset) : "Empty field?";
    
    // It is always safe to classify this as an integer type up to i64 that
    // isn't larger than the structure.
    return IntegerType.get(getVMContext(), 
        std.min_uint(TySizeInBytes - SourceOffset, 8/*U*/) * 8);
  }

  
  /// getIndirectResult - Give a source type \arg Ty, return a suitable result
  /// such that the argument will be returned in memory.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::getIndirectReturnResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2625,
   FQN="(anonymous namespace)::X86_64ABIInfo::getIndirectReturnResult", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo23getIndirectReturnResultEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo23getIndirectReturnResultEN5clang8QualTypeE")
  //</editor-fold>
  private ABIArgInfo getIndirectReturnResult(QualType Ty) /*const*/ {
    // If this is a scalar LLVM value then assume LLVM will pass it in the right
    // place naturally.
    if (!isAggregateTypeForABI(new QualType(Ty))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          Ty.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (Ty.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    
    return getNaturalAlignIndirect(new QualType(Ty));
  }

  
  /// getIndirectResult - Give a source type \arg Ty, return a suitable result
  /// such that the argument will be passed in memory.
  ///
  /// \param freeIntRegs - The number of free integer registers remaining
  /// available.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::getIndirectResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2651,
   FQN="(anonymous namespace)::X86_64ABIInfo::getIndirectResult", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo17getIndirectResultEN5clang8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo17getIndirectResultEN5clang8QualTypeEj")
  //</editor-fold>
  private ABIArgInfo getIndirectResult(QualType Ty, 
                   /*uint*/int freeIntRegs) /*const*/ {
    // If this is a scalar LLVM value then assume LLVM will pass it in the right
    // place naturally.
    //
    // This assumption is optimistic, as there could be free registers available
    // when we need to pass this argument in memory, and LLVM could try to pass
    // the argument in the free register. This does not seem to happen currently,
    // but this code would be much safer if we could mark the argument with
    // 'onstack'. See PR12193.
    if (!isAggregateTypeForABI(new QualType(Ty)) && !IsIllegalVectorType(new QualType(Ty))) {
      {
        // Treat an enum type as its underlying type.
        /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
        if ((EnumTy != null)) {
          Ty.$assignMove(EnumTy.getDecl().getIntegerType());
        }
      }
      
      return (Ty.$arrow().isPromotableIntegerType() ? ABIArgInfo.getExtend() : ABIArgInfo.getDirect());
    }
    {
      
      CGCXXABI.RecordArgABI RAA = getRecordArgABI(new QualType(Ty), getCXXABI());
      if ((RAA.getValue() != 0)) {
        return getNaturalAlignIndirect(new QualType(Ty), RAA == CGCXXABI.RecordArgABI.RAA_DirectInMemory);
      }
    }
    
    // Compute the byval alignment. We specify the alignment of the byval in all
    // cases so that the mid-level optimizer knows the alignment of the byval.
    /*uint*/int Align = std.max($div_uint(getContext().getTypeAlign(new QualType(Ty)), 8), 8/*U*/);
    
    // Attempt to avoid passing indirect results using byval when possible. This
    // is important for good codegen.
    //
    // We do this by coercing the value into a scalar type which the backend can
    // handle naturally (i.e., without using byval).
    //
    // For simplicity, we currently only do this when we have exhausted all of the
    // free integer registers. Doing this when there are free integer registers
    // would require more care, as we would have to ensure that the coerced value
    // did not claim the unused register. That would require either reording the
    // arguments to the function (so that any subsequent inreg values came first),
    // or only doing this optimization when there were no following arguments that
    // might be inreg.
    //
    // We currently expect it to be rare (particularly in well written code) for
    // arguments to be passed on the stack when there are still free integer
    // registers available (this would typically imply large structs being passed
    // by value), so this seems like a fair tradeoff for now.
    //
    // We can revisit this if the backend grows support for 'onstack' parameter
    // attributes. See PR12193.
    if (freeIntRegs == 0) {
      long/*uint64_t*/ Size = getContext().getTypeSize(new QualType(Ty));
      
      // If this type fits in an eightbyte, coerce it into the matching integral
      // type, which will end up on the stack (with alignment 8).
      if (Align == 8 && $lesseq_ulong_ullong(Size, $int2ullong(64))) {
        return ABIArgInfo.getDirect(IntegerType.get(getVMContext(), 
                $ulong2uint(Size)));
      }
    }
    
    return ABIArgInfo.getIndirect(CharUnits.fromQuantity($uint2long(Align)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2992,
   FQN="(anonymous namespace)::X86_64ABIInfo::classifyReturnType", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo18classifyReturnTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo18classifyReturnTypeEN5clang8QualTypeE")
  //</editor-fold>
  private ABIArgInfo classifyReturnType(QualType RetTy) /*const*/ {
    // AMD64-ABI 3.2.3p4: Rule 1. Classify the return type with the
    // classification algorithm.
    type$ref<X86_64ABIInfo.Class> Lo = create_type$ref();
    type$ref<X86_64ABIInfo.Class> Hi = create_type$ref();
    classify(new QualType(RetTy), $int2ulong(0), Lo, Hi, /*isNamedArg*/ true);
    
    // Check some invariants.
    assert ((Hi.$deref() != Class.Memory || Lo.$deref() == Class.Memory)) : "Invalid memory classification.";
    assert ((Hi.$deref() != Class.SSEUp || Lo.$deref() == Class.SSE)) : "Invalid SSEUp classification.";
    
    org.llvm.ir.Type /*P*/ ResType = null;
    switch (Lo.$deref()) {
     case NoClass:
      if (Hi.$deref() == Class.NoClass) {
        return ABIArgInfo.getIgnore();
      }
      // If the low part is just padding, it takes no register, leave ResType
      // null.
      assert ((Hi.$deref() == Class.SSE || Hi.$deref() == Class.Integer || Hi.$deref() == Class.X87Up)) : "Unknown missing lo part";
      break;
     case SSEUp:
     case X87Up:
      throw new llvm_unreachable("Invalid classification for lo word.");
     case Memory:
      
      // AMD64-ABI 3.2.3p4: Rule 2. Types of class memory are returned via
      // hidden argument.
      return getIndirectReturnResult(new QualType(RetTy));
     case Integer:
      
      // AMD64-ABI 3.2.3p4: Rule 3. If the class is INTEGER, the next
      // available register of the sequence %rax, %rdx is used.
      ResType = GetINTEGERTypeAtOffset(CGT.ConvertType(new QualType(RetTy)), 0, new QualType(RetTy), 0);
      
      // If we have a sign or zero extended integer, make sure to return Extend
      // so that the parameter gets the right LLVM IR attributes.
      if (Hi.$deref() == Class.NoClass && isa_IntegerType(ResType)) {
        {
          // Treat an enum type as its underlying type.
          /*const*/ EnumType /*P*/ EnumTy = RetTy.$arrow().getAs$EnumType();
          if ((EnumTy != null)) {
            RetTy.$assignMove(EnumTy.getDecl().getIntegerType());
          }
        }
        if (RetTy.$arrow().isIntegralOrEnumerationType()
           && RetTy.$arrow().isPromotableIntegerType()) {
          return ABIArgInfo.getExtend();
        }
      }
      break;
     case SSE:
      
      // AMD64-ABI 3.2.3p4: Rule 4. If the class is SSE, the next
      // available SSE register of the sequence %xmm0, %xmm1 is used.
      ResType = GetSSETypeAtOffset(CGT.ConvertType(new QualType(RetTy)), 0, new QualType(RetTy), 0);
      break;
     case X87:
      
      // AMD64-ABI 3.2.3p4: Rule 6. If the class is X87, the value is
      // returned on the X87 stack in %st0 as 80-bit x87 number.
      ResType = Type.getX86_FP80Ty(getVMContext());
      break;
     case ComplexX87:
      
      // AMD64-ABI 3.2.3p4: Rule 8. If the class is COMPLEX_X87, the real
      // part of the value is returned in %st0 and the imaginary part in
      // %st1.
      assert (Hi.$deref() == Class.ComplexX87) : "Unexpected ComplexX87 classification.";
      ResType = StructType.get(Type.getX86_FP80Ty(getVMContext()), 
          Type.getX86_FP80Ty(getVMContext()), 
          null);
      break;
    }
    
    Type /*P*/ HighPart = null;
    switch (Hi.$deref()) {
     case Memory:
     case X87:
      // Memory was handled previously and X87 should
      // never occur as a hi class.
      throw new llvm_unreachable("Invalid classification for hi word.");
     case ComplexX87: // Previously handled.
     case NoClass:
      break;
     case Integer:
      HighPart = GetINTEGERTypeAtOffset(CGT.ConvertType(new QualType(RetTy)), 8, new QualType(RetTy), 8);
      if (Lo.$deref() == Class.NoClass) { // Return HighPart at offset 8 in memory.
        return ABIArgInfo.getDirect(HighPart, 8);
      }
      break;
     case SSE:
      HighPart = GetSSETypeAtOffset(CGT.ConvertType(new QualType(RetTy)), 8, new QualType(RetTy), 8);
      if (Lo.$deref() == Class.NoClass) { // Return HighPart at offset 8 in memory.
        return ABIArgInfo.getDirect(HighPart, 8);
      }
      break;
     case SSEUp:
      
      // AMD64-ABI 3.2.3p4: Rule 5. If the class is SSEUP, the eightbyte
      // is passed in the next available eightbyte chunk if the last used
      // vector register.
      //
      // SSEUP should always be preceded by SSE, just widen.
      assert (Lo.$deref() == Class.SSE) : "Unexpected SSEUp classification.";
      ResType = GetByteVectorType(new QualType(RetTy));
      break;
     case X87Up:
      // If X87Up is preceded by X87, we don't need to do
      // anything. However, in some cases with unions it may not be
      // preceded by X87. In such situations we follow gcc and pass the
      // extra bits in an SSE reg.
      if (Lo.$deref() != Class.X87) {
        HighPart = GetSSETypeAtOffset(CGT.ConvertType(new QualType(RetTy)), 8, new QualType(RetTy), 8);
        if (Lo.$deref() == Class.NoClass) { // Return HighPart at offset 8 in memory.
          return ABIArgInfo.getDirect(HighPart, 8);
        }
      }
      break;
    }
    
    // If a high part was specified, merge it together with the low part.  It is
    // known to pass in the high eightbyte of the result.  We do this by forming a
    // first class struct aggregate with the high and low part: {low, high}
    if ((HighPart != null)) {
      ResType = GetX86_64ByValArgumentPair(ResType, HighPart, getDataLayout());
    }
    
    return ABIArgInfo.getDirect(ResType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::classifyArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3121,
   FQN="(anonymous namespace)::X86_64ABIInfo::classifyArgumentType", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo20classifyArgumentTypeEN5clang8QualTypeEjRjS3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo20classifyArgumentTypeEN5clang8QualTypeEjRjS3_b")
  //</editor-fold>
  private ABIArgInfo classifyArgumentType(QualType Ty, /*uint*/int freeIntRegs, final uint$ref/*uint &*/ neededInt, final uint$ref/*uint &*/ neededSSE, 
                      boolean isNamedArg) /*const*/ {
    Ty.$assignMove(useFirstFieldIfTransparentUnion(new QualType(Ty)));
    
    type$ref<X86_64ABIInfo.Class> Lo = create_type$ref();
    type$ref<X86_64ABIInfo.Class> Hi = create_type$ref();
    classify(new QualType(Ty), $int2ulong(0), Lo, Hi, isNamedArg);
    
    // Check some invariants.
    // FIXME: Enforce these by construction.
    assert ((Hi.$deref() != Class.Memory || Lo.$deref() == Class.Memory)) : "Invalid memory classification.";
    assert ((Hi.$deref() != Class.SSEUp || Lo.$deref() == Class.SSE)) : "Invalid SSEUp classification.";
    
    neededInt.$set(0);
    neededSSE.$set(0);
    Type /*P*/ ResType = null;
    switch (Lo.$deref()) {
     case NoClass:
      if (Hi.$deref() == Class.NoClass) {
        return ABIArgInfo.getIgnore();
      }
      // If the low part is just padding, it takes no register, leave ResType
      // null.
      assert ((Hi.$deref() == Class.SSE || Hi.$deref() == Class.Integer || Hi.$deref() == Class.X87Up)) : "Unknown missing lo part";
      break;
     case Memory:
     case X87:
     case ComplexX87:
      
      // AMD64-ABI 3.2.3p3: Rule 5. If the class is X87, X87UP or
      // COMPLEX_X87, it is passed in memory.
      if (getRecordArgABI(new QualType(Ty), getCXXABI()) == CGCXXABI.RecordArgABI.RAA_Indirect) {
        neededInt.$set$preInc();
      }
      return getIndirectResult(new QualType(Ty), freeIntRegs);
     case SSEUp:
     case X87Up:
      throw new llvm_unreachable("Invalid classification for lo word.");
     case Integer:
      
      // AMD64-ABI 3.2.3p3: Rule 2. If the class is INTEGER, the next
      // available register of the sequence %rdi, %rsi, %rdx, %rcx, %r8
      // and %r9 is used.
      neededInt.$set$preInc();
      
      // Pick an 8-byte type based on the preferred type.
      ResType = GetINTEGERTypeAtOffset(CGT.ConvertType(new QualType(Ty)), 0, new QualType(Ty), 0);
      
      // If we have a sign or zero extended integer, make sure to return Extend
      // so that the parameter gets the right LLVM IR attributes.
      if (Hi.$deref() == Class.NoClass && isa_IntegerType(ResType)) {
        {
          // Treat an enum type as its underlying type.
          /*const*/ EnumType /*P*/ EnumTy = Ty.$arrow().getAs$EnumType();
          if ((EnumTy != null)) {
            Ty.$assignMove(EnumTy.getDecl().getIntegerType());
          }
        }
        if (Ty.$arrow().isIntegralOrEnumerationType()
           && Ty.$arrow().isPromotableIntegerType()) {
          return ABIArgInfo.getExtend();
        }
      }
      
      break;
     case SSE:
      {
        Type /*P*/ IRType = CGT.ConvertType(new QualType(Ty));
        ResType = GetSSETypeAtOffset(IRType, 0, new QualType(Ty), 0);
        neededSSE.$set$preInc();
        break;
      }
    }
    
    Type /*P*/ HighPart = null;
    switch (Hi.$deref()) {
     case Memory:
     case X87:
     case ComplexX87:
      // Memory was handled previously, ComplexX87 and X87 should
      // never occur as hi classes, and X87Up must be preceded by X87,
      // which is passed in memory.
      throw new llvm_unreachable("Invalid classification for hi word.");
     case NoClass:
      break;
     case Integer:
      neededInt.$set$preInc();
      // Pick an 8-byte type based on the preferred type.
      HighPart = GetINTEGERTypeAtOffset(CGT.ConvertType(new QualType(Ty)), 8, new QualType(Ty), 8);
      if (Lo.$deref() == Class.NoClass) { // Pass HighPart at offset 8 in memory.
        return ABIArgInfo.getDirect(HighPart, 8);
      }
      break;
     case X87Up:
     case SSE:
      
      // X87Up generally doesn't occur here (long double is passed in
      // memory), except in situations involving unions.
      HighPart = GetSSETypeAtOffset(CGT.ConvertType(new QualType(Ty)), 8, new QualType(Ty), 8);
      if (Lo.$deref() == Class.NoClass) { // Pass HighPart at offset 8 in memory.
        return ABIArgInfo.getDirect(HighPart, 8);
      }
      
      neededSSE.$set$preInc();
      break;
     case SSEUp:
      
      // AMD64-ABI 3.2.3p3: Rule 4. If the class is SSEUP, the
      // eightbyte is passed in the upper half of the last used SSE
      // register.  This only happens when 128-bit vectors are passed.
      assert (Lo.$deref() == Class.SSE) : "Unexpected SSEUp classification";
      ResType = GetByteVectorType(new QualType(Ty));
      break;
    }
    
    // If a high part was specified, merge it together with the low part.  It is
    // known to pass in the high eightbyte of the result.  We do this by forming a
    // first class struct aggregate with the high and low part: {low, high}
    if ((HighPart != null)) {
      ResType = GetX86_64ByValArgumentPair(ResType, HighPart, getDataLayout());
    }
    
    return ABIArgInfo.getDirect(ResType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::IsIllegalVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2640,
   FQN="(anonymous namespace)::X86_64ABIInfo::IsIllegalVectorType", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo19IsIllegalVectorTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo19IsIllegalVectorTypeEN5clang8QualTypeE")
  //</editor-fold>
  private boolean IsIllegalVectorType(QualType Ty) /*const*/ {
    {
      /*const*/ VectorType /*P*/ VecTy = Ty.$arrow().getAs(VectorType.class);
      if ((VecTy != null)) {
        long/*uint64_t*/ Size = getContext().getTypeSize(VecTy);
        /*uint*/int LargestVector = getNativeVectorSizeForAVXABI(AVXLevel);
        if ($lesseq_ulong_ullong(Size, $int2ullong(64)) || $greater_ulong_uint(Size, LargestVector)) {
          return true;
        }
      }
    }
    
    return false;
  }

  
  /// The 0.98 ABI revision clarified a lot of ambiguities,
  /// unfortunately in ways that were not always consistent with
  /// certain previous compilers.  In particular, platforms which
  /// required strict binary compatibility with older versions of GCC
  /// may need to exempt themselves.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::honorsRevision0_98">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1922,
   FQN="(anonymous namespace)::X86_64ABIInfo::honorsRevision0_98", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo18honorsRevision0_98Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo18honorsRevision0_98Ev")
  //</editor-fold>
  private boolean honorsRevision0_98() /*const*/ {
    return !getTarget().getTriple().isOSDarwin();
  }

  
  /// GCC classifies <1 x long long> as SSE but compatibility with older clang
  // compilers require us to classify it as INTEGER.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::classifyIntegerMMXAsSSE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1928,
   FQN="(anonymous namespace)::X86_64ABIInfo::classifyIntegerMMXAsSSE", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo23classifyIntegerMMXAsSSEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo23classifyIntegerMMXAsSSEEv")
  //</editor-fold>
  private boolean classifyIntegerMMXAsSSE() /*const*/ {
    final /*const*/ Triple /*&*/ $Triple = getTarget().getTriple();
    if ($Triple.isOSDarwin() || $Triple.getOS() == Triple.OSType.PS4) {
      return false;
    }
    if ($Triple.isOSFreeBSD() && $greatereq_uint($Triple.getOSMajorVersion(), 10)) {
      return false;
    }
    return true;
  }

  
  private X86AVXABILevel AVXLevel;
  // Some ABIs (e.g. X32 ABI and Native Client OS) use 32 bit pointers on
  // 64-bit hardware.
  private boolean Has64BitPointers;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::X86_64ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1943,
   FQN="(anonymous namespace)::X86_64ABIInfo::X86_64ABIInfo", NM="_ZN12_GLOBAL__N_113X86_64ABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS_14X86AVXABILevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_64ABIInfoC1ERN5clang7CodeGen12CodeGenTypesENS_14X86AVXABILevelE")
  //</editor-fold>
  public X86_64ABIInfo(final CodeGenTypes /*&*/ CGT, X86AVXABILevel AVXLevel) {
    // : SwiftABIInfo(CGT), AVXLevel(AVXLevel), Has64BitPointers(CGT.getDataLayout().getPointerSize(0) == 8) 
    //START JInit
    super(CGT);
    this.AVXLevel = AVXLevel;
    this.Has64BitPointers = CGT.getDataLayout().getPointerSize(0) == 8;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::isPassedUsingAVXType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1948,
   FQN="(anonymous namespace)::X86_64ABIInfo::isPassedUsingAVXType", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo20isPassedUsingAVXTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo20isPassedUsingAVXTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean isPassedUsingAVXType(QualType type) /*const*/ {
    uint$ref neededInt = create_uint$ref();
    uint$ref neededSSE = create_uint$ref();
    // The freeIntRegs argument doesn't matter here.
    ABIArgInfo info = classifyArgumentType(new QualType(type), 0, neededInt, neededSSE, 
        /*isNamedArg*/ true);
    if (info.isDirect()) {
      Type /*P*/ ty = info.getCoerceToType();
      {
        org.llvm.ir.VectorType /*P*/ vectorTy = dyn_cast_or_null_VectorType(ty);
        if ((vectorTy != null)) {
          return ($greater_uint(vectorTy.getBitWidth(), 128));
        }
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::computeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3250,
   FQN="(anonymous namespace)::X86_64ABIInfo::computeInfo", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo11computeInfoERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public void computeInfo(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    if (!getCXXABI().classifyReturnType(FI)) {
      FI.getReturnInfo().$assignMove(classifyReturnType(FI.getReturnType().$QualType()));
    }
    
    // Keep track of the number of assigned registers.
    /*uint*/int freeIntRegs = 6;
    /*uint*/int freeSSERegs = 8;
    
    // If the return value is indirect, then the hidden argument is consuming one
    // integer register.
    if (FI.getReturnInfo().isIndirect()) {
      --freeIntRegs;
    }
    
    // The chain argument effectively gives us another free register.
    if (FI.isChainCall()) {
      ++freeIntRegs;
    }
    
    /*uint*/int NumRequiredArgs = FI.getNumRequiredArgs();
    // AMD64-ABI 3.2.3p3: Once arguments are classified, the registers
    // get assigned (in left-to-right order) for passing as follows...
    /*uint*/int ArgNo = 0;
    for (type$ptr<CGFunctionInfoArgInfo /*P*/ > it = $tryClone(FI.arg_begin()), /*P*/ ie = $tryClone(FI.arg_end());
         $noteq_ptr(it, ie); it.$preInc() , ++ArgNo) {
      boolean IsNamedArg = $less_uint(ArgNo, NumRequiredArgs);
      
      uint$ref neededInt = create_uint$ref();
      uint$ref neededSSE = create_uint$ref();
      it./*->*/$star().info.$assignMove(classifyArgumentType(it./*->*/$star().type.$QualType(), freeIntRegs, neededInt, 
              neededSSE, IsNamedArg));
      
      // AMD64-ABI 3.2.3p3: If there are no registers available for any
      // eightbyte of an argument, the whole argument is passed on the
      // stack. If registers have already been assigned for some
      // eightbytes of such an argument, the assignments get reverted.
      if ($greatereq_uint(freeIntRegs, neededInt.$deref()) && $greatereq_uint(freeSSERegs, neededSSE.$deref())) {
        freeIntRegs -= neededInt.$deref();
        freeSSERegs -= neededSSE.$deref();
      } else {
        it./*->*/$star().info.$assignMove(getIndirectResult(it./*->*/$star().type.$QualType(), freeIntRegs));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3331,
   FQN="(anonymous namespace)::X86_64ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
           QualType Ty) /*const*//* override*/ {
    // Assume that va_list type is correct; should be pointer to LLVM type:
    // struct {
    //   i32 gp_offset;
    //   i32 fp_offset;
    //   i8* overflow_arg_area;
    //   i8* reg_save_area;
    // };
    uint$ref neededInt = create_uint$ref();
    uint$ref neededSSE = create_uint$ref();
    
    Ty.$assignMove(getContext().getCanonicalType(/*NO_COPY*/Ty).$QualType());
    ABIArgInfo AI = classifyArgumentType(new QualType(Ty), 0, neededInt, neededSSE, 
        /*isNamedArg*/ false);
    
    // AMD64-ABI 3.5.7p5: Step 1. Determine whether type may be passed
    // in the registers. If not go to step 7.
    if (!(neededInt.$deref() != 0) && !(neededSSE.$deref() != 0)) {
      return EmitX86_64VAArgFromMemory(CGF, new Address(VAListAddr), new QualType(Ty));
    }
    
    // AMD64-ABI 3.5.7p5: Step 2. Compute num_gp to hold the number of
    // general purpose registers needed to pass type and num_fp to hold
    // the number of floating point registers needed.
    
    // AMD64-ABI 3.5.7p5: Step 3. Verify whether arguments fit into
    // registers. In the case: l->gp_offset > 48 - num_gp * 8 or
    // l->fp_offset > 304 - num_fp * 16 go to step 7.
    //
    // NOTE: 304 is a typo, there are (6 * 8 + 8 * 16) = 176 bytes of
    // register save space).
    Value /*P*/ InRegs = null;
    Address gp_offset_p = Address.invalid();
    Address fp_offset_p = Address.invalid();
    Value /*P*/ gp_offset = null;
    Value /*P*/ fp_offset = null;
    if ((neededInt.$deref() != 0)) {
      gp_offset_p.$assignMove(
          CGF.Builder.CreateStructGEP(new Address(VAListAddr), 0, CharUnits.Zero(), 
              new Twine(/*KEEP_STR*/"gp_offset_p"))
      );
      gp_offset = CGF.Builder.CreateLoad(new Address(gp_offset_p), $("gp_offset"));
      InRegs = ConstantInt.get(CGF.Int32Ty, $uint2ulong(48 - neededInt.$deref() * 8));
      InRegs = CGF.Builder.CreateICmpULE(gp_offset, InRegs, new Twine(/*KEEP_STR*/"fits_in_gp"));
    }
    if ((neededSSE.$deref() != 0)) {
      fp_offset_p.$assignMove(
          CGF.Builder.CreateStructGEP(new Address(VAListAddr), 1, CharUnits.fromQuantity(4), 
              new Twine(/*KEEP_STR*/"fp_offset_p"))
      );
      fp_offset = CGF.Builder.CreateLoad(new Address(fp_offset_p), $("fp_offset"));
      Value /*P*/ FitsInFP = ConstantInt.get(CGF.Int32Ty, $uint2ulong(176 - neededSSE.$deref() * 16));
      FitsInFP = CGF.Builder.CreateICmpULE(fp_offset, FitsInFP, new Twine(/*KEEP_STR*/"fits_in_fp"));
      InRegs = (InRegs != null) ? CGF.Builder.CreateAnd(InRegs, FitsInFP) : FitsInFP;
    }
    
    BasicBlock /*P*/ InRegBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.in_reg"));
    BasicBlock /*P*/ InMemBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.in_mem"));
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vaarg.end"));
    CGF.Builder.CreateCondBr(InRegs, InRegBlock, InMemBlock);
    
    // Emit code to load the value if it was passed in registers.
    CGF.EmitBlock(InRegBlock);
    
    // AMD64-ABI 3.5.7p5: Step 4. Fetch type from l->reg_save_area with
    // an offset of l->gp_offset and/or l->fp_offset. This may require
    // copying to a temporary location in case the parameter is passed
    // in different register classes or requires an alignment greater
    // than 8 for general purpose registers and 16 for XMM registers.
    //
    // FIXME: This really results in shameful code when we end up needing to
    // collect arguments from different places; often what should result in a
    // simple assembling of a structure from scattered addresses has many more
    // loads than necessary. Can we clean this up?
    Type /*P*/ LTy = CGF.ConvertTypeForMem(new QualType(Ty));
    Value /*P*/ RegSaveArea = CGF.Builder.CreateLoad(CGF.Builder.CreateStructGEP(new Address(VAListAddr), 3, CharUnits.fromQuantity(16)), 
        $("reg_save_area"));
    
    Address RegAddr = Address.invalid();
    if ((neededInt.$deref() != 0) && (neededSSE.$deref() != 0)) {
      // FIXME: Cleanup.
      assert (AI.isDirect()) : "Unexpected ABI info for mixed regs";
      StructType /*P*/ ST = cast_StructType(AI.getCoerceToType());
      Address Tmp = CGF.CreateMemTemp(new QualType(Ty));
      Tmp.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Tmp), ST));
      assert (ST.getNumElements() == 2) : "Unexpected ABI info for mixed regs";
      Type /*P*/ TyLo = ST.getElementType(0);
      Type /*P*/ TyHi = ST.getElementType(1);
      assert ((((TyLo.isFPOrFPVectorTy() ? 1 : 0) ^ (TyHi.isFPOrFPVectorTy() ? 1 : 0)) != 0)) : "Unexpected ABI info for mixed regs";
      Type /*P*/ PTyLo = org.llvm.ir.PointerType.getUnqual(TyLo);
      Type /*P*/ PTyHi = org.llvm.ir.PointerType.getUnqual(TyHi);
      Value /*P*/ GPAddr = CGF.Builder.CreateGEP(RegSaveArea, gp_offset);
      Value /*P*/ FPAddr = CGF.Builder.CreateGEP(RegSaveArea, fp_offset);
      Value /*P*/ RegLoAddr = TyLo.isFPOrFPVectorTy() ? FPAddr : GPAddr;
      Value /*P*/ RegHiAddr = TyLo.isFPOrFPVectorTy() ? GPAddr : FPAddr;
      
      // Copy the first element.
      Value /*P*/ V = CGF.Builder.CreateDefaultAlignedLoad(CGF.Builder.CreateBitCast(RegLoAddr, PTyLo));
      CGF.Builder.CreateStore(V, 
          CGF.Builder.CreateStructGEP(new Address(Tmp), 0, CharUnits.Zero()));
      
      // Copy the second element.
      V = CGF.Builder.CreateDefaultAlignedLoad(CGF.Builder.CreateBitCast(RegHiAddr, PTyHi));
      CharUnits Offset = CharUnits.fromQuantity(getDataLayout().getStructLayout(ST).getElementOffset(1));
      CGF.Builder.CreateStore(V, CGF.Builder.CreateStructGEP(new Address(Tmp), 1, new CharUnits(Offset)));
      
      RegAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Tmp), LTy));
    } else if ((neededInt.$deref() != 0)) {
      RegAddr.$assignMove(new Address(CGF.Builder.CreateGEP(RegSaveArea, gp_offset), 
              CharUnits.fromQuantity(8)));
      RegAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(RegAddr), LTy));
      
      // Copy to a temporary if necessary to ensure the appropriate alignment.
      std.pair<CharUnits, CharUnits> SizeAlign = getContext().getTypeInfoInChars(new QualType(Ty));
      long/*uint64_t*/ TySize = SizeAlign.first.getQuantity();
      CharUnits TyAlign = new CharUnits(SizeAlign.second);
      
      // Copy into a temporary if the type is more aligned than the
      // register save area.
      if (TyAlign.getQuantity() > 8) {
        Address Tmp = CGF.CreateMemTemp(new QualType(Ty));
        CGF.Builder.CreateMemCpy(new Address(Tmp), new Address(RegAddr), TySize, false);
        RegAddr.$assign(Tmp);
      }
    } else if (neededSSE.$deref() == 1) {
      RegAddr.$assignMove(new Address(CGF.Builder.CreateGEP(RegSaveArea, fp_offset), 
              CharUnits.fromQuantity(16)));
      RegAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(RegAddr), LTy));
    } else {
      assert (neededSSE.$deref() == 2) : "Invalid number of needed registers!";
      // SSE registers are spaced 16 bytes apart in the register save
      // area, we need to collect the two eightbytes together.
      // The ABI isn't explicit about this, but it seems reasonable
      // to assume that the slots are 16-byte aligned, since the stack is
      // naturally 16-byte aligned and the prologue is expected to store
      // all the SSE registers to the RSA.
      Address RegAddrLo = new Address(CGF.Builder.CreateGEP(RegSaveArea, fp_offset), 
          CharUnits.fromQuantity(16));
      Address RegAddrHi = CGF.Builder.CreateConstInBoundsByteGEP(new Address(RegAddrLo), 
          CharUnits.fromQuantity(16));
      Type /*P*/ DoubleTy = CGF.DoubleTy;
      StructType /*P*/ ST = StructType.get(DoubleTy, DoubleTy, null);
      Value /*P*/ V;
      Address Tmp = CGF.CreateMemTemp(new QualType(Ty));
      Tmp.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Tmp), ST));
      V = CGF.Builder.CreateLoad(CGF.Builder.CreateElementBitCast(new Address(RegAddrLo), DoubleTy));
      CGF.Builder.CreateStore(V, 
          CGF.Builder.CreateStructGEP(new Address(Tmp), 0, CharUnits.Zero()));
      V = CGF.Builder.CreateLoad(CGF.Builder.CreateElementBitCast(new Address(RegAddrHi), DoubleTy));
      CGF.Builder.CreateStore(V, 
          CGF.Builder.CreateStructGEP(new Address(Tmp), 1, CharUnits.fromQuantity(8)));
      
      RegAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Tmp), LTy));
    }
    
    // AMD64-ABI 3.5.7p5: Step 5. Set:
    // l->gp_offset = l->gp_offset + num_gp * 8
    // l->fp_offset = l->fp_offset + num_fp * 16.
    if ((neededInt.$deref() != 0)) {
      Value /*P*/ Offset = ConstantInt.get(CGF.Int32Ty, $uint2ulong(neededInt.$deref() * 8));
      CGF.Builder.CreateStore(CGF.Builder.CreateAdd(gp_offset, Offset), 
          new Address(gp_offset_p));
    }
    if ((neededSSE.$deref() != 0)) {
      Value /*P*/ Offset = ConstantInt.get(CGF.Int32Ty, $uint2ulong(neededSSE.$deref() * 16));
      CGF.Builder.CreateStore(CGF.Builder.CreateAdd(fp_offset, Offset), 
          new Address(fp_offset_p));
    }
    CGF.EmitBranch(ContBlock);
    
    // Emit code to load the value if it was passed in memory.
    CGF.EmitBlock(InMemBlock);
    Address MemAddr = EmitX86_64VAArgFromMemory(CGF, new Address(VAListAddr), new QualType(Ty));
    
    // Return the appropriate result.
    CGF.EmitBlock(ContBlock);
    Address ResAddr = emitMergePHI(CGF, new Address(RegAddr), InRegBlock, new Address(MemAddr), InMemBlock, 
        new Twine(/*KEEP_STR*/"vaarg.addr"));
    return ResAddr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::EmitMSVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3524,
   FQN="(anonymous namespace)::X86_64ABIInfo::EmitMSVAArg", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo11EmitMSVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo11EmitMSVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitMSVAArg(final CodeGenFunction /*&*/ CGF, Address VAListAddr, 
             QualType Ty) /*const*//* override*/ {
    return emitVoidPtrVAArg(CGF, new Address(VAListAddr), new QualType(Ty), /*indirect*/ false, 
        CGF.getContext().getTypeInfoInChars(new QualType(Ty)), 
        CharUnits.fromQuantity(8), 
        /*allowHigherAlign*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::has64BitPointers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1968,
   FQN="(anonymous namespace)::X86_64ABIInfo::has64BitPointers", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo16has64BitPointersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo16has64BitPointersEv")
  //</editor-fold>
  public boolean has64BitPointers() /*const*/ {
    return Has64BitPointers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::shouldPassIndirectlyForSwift">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1972,
   FQN="(anonymous namespace)::X86_64ABIInfo::shouldPassIndirectlyForSwift", NM="_ZNK12_GLOBAL__N_113X86_64ABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_113X86_64ABIInfo28shouldPassIndirectlyForSwiftEN5clang9CharUnitsEN4llvm8ArrayRefIPNS3_4TypeEEEb")
  //</editor-fold>
  @Override public boolean shouldPassIndirectlyForSwift(CharUnits totalSize, 
                              ArrayRef<org.llvm.ir.Type /*P*/ > scalars, 
                              boolean asReturnValue) /*const*//* override*/ {
    return occupiesMoreThan(CGT, new ArrayRef<org.llvm.ir.Type /*P*/ >(scalars), /*total*/ 4);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64ABIInfo::~X86_64ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1822,
   FQN="(anonymous namespace)::X86_64ABIInfo::~X86_64ABIInfo", NM="_ZN12_GLOBAL__N_113X86_64ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_113X86_64ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AVXLevel=" + AVXLevel // NOI18N
              + ", Has64BitPointers=" + Has64BitPointers // NOI18N
              + super.toString(); // NOI18N
  }
}
