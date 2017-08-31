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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// An attributed type is a type to which a type attribute has been applied.
///
/// The "modified type" is the fully-sugared type to which the attributed
/// type was applied; generally it is not canonically equivalent to the
/// attributed type. The "equivalent type" is the minimally-desugared type
/// which the type is canonically equivalent to.
///
/// For example, in the following attributed type:
///     int32_t __attribute__((vector_size(16)))
///   - the modified type is the TypedefType for int32_t
///   - the equivalent type is VectorType(16, int32_t)
///   - the canonical type is VectorType(16, int)
//<editor-fold defaultstate="collapsed" desc="clang::AttributedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3761,
 FQN="clang::AttributedType", NM="_ZN5clang14AttributedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedTypeE")
//</editor-fold>
public class AttributedType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
/*public:*/
  // It is really silly to have yet another attribute-kind enum, but
  // clang::attr::Kind doesn't currently cover the pure type attrs.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3765,
   FQN="clang::AttributedType::Kind", NM="_ZN5clang14AttributedType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedType4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    // Expression operand.
    attr_address_space(0),
    attr_regparm(attr_address_space.getValue() + 1),
    attr_vector_size(attr_regparm.getValue() + 1),
    attr_neon_vector_type(attr_vector_size.getValue() + 1),
    attr_neon_polyvector_type(attr_neon_vector_type.getValue() + 1),
    
    FirstExprOperandKind(Kind.attr_address_space.getValue()),
    LastExprOperandKind(Kind.attr_neon_polyvector_type.getValue()),
    
    // Enumerated operand (string or keyword).
    attr_objc_gc(LastExprOperandKind.getValue() + 1),
    attr_objc_ownership(attr_objc_gc.getValue() + 1),
    attr_pcs(attr_objc_ownership.getValue() + 1),
    attr_pcs_vfp(attr_pcs.getValue() + 1),
    
    FirstEnumOperandKind(Kind.attr_objc_gc.getValue()),
    LastEnumOperandKind(Kind.attr_pcs_vfp.getValue()),
    
    // No operand.
    attr_noreturn(LastEnumOperandKind.getValue() + 1),
    attr_cdecl(attr_noreturn.getValue() + 1),
    attr_fastcall(attr_cdecl.getValue() + 1),
    attr_stdcall(attr_fastcall.getValue() + 1),
    attr_thiscall(attr_stdcall.getValue() + 1),
    attr_pascal(attr_thiscall.getValue() + 1),
    attr_swiftcall(attr_pascal.getValue() + 1),
    attr_vectorcall(attr_swiftcall.getValue() + 1),
    attr_inteloclbicc(attr_vectorcall.getValue() + 1),
    attr_ms_abi(attr_inteloclbicc.getValue() + 1),
    attr_sysv_abi(attr_ms_abi.getValue() + 1),
    attr_preserve_most(attr_sysv_abi.getValue() + 1),
    attr_preserve_all(attr_preserve_most.getValue() + 1),
    attr_ptr32(attr_preserve_all.getValue() + 1),
    attr_ptr64(attr_ptr32.getValue() + 1),
    attr_sptr(attr_ptr64.getValue() + 1),
    attr_uptr(attr_sptr.getValue() + 1),
    attr_nonnull(attr_uptr.getValue() + 1),
    attr_nullable(attr_nonnull.getValue() + 1),
    attr_null_unspecified(attr_nullable.getValue() + 1),
    attr_objc_kindof(attr_null_unspecified.getValue() + 1),
    attr_objc_inert_unsafe_unretained(attr_objc_kindof.getValue() + 1);

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
/*private:*/
  private QualType ModifiedType;
  private QualType EquivalentType;
  
  /*friend  class ASTContext*/ // creates these
  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::AttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3816,
   FQN="clang::AttributedType::AttributedType", NM="_ZN5clang14AttributedTypeC1ENS_8QualTypeENS0_4KindES1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedTypeC1ENS_8QualTypeENS0_4KindES1_S1_")
  //</editor-fold>
  /*friend*//*package*/ AttributedType(QualType canon, Kind attrKind, 
      QualType modified, QualType equivalent) {
    // : Type(Attributed, canon, canon->isDependentType(), canon->isInstantiationDependentType(), canon->isVariablyModifiedType(), canon->containsUnexpandedParameterPack()), FoldingSetNode(), ModifiedType(modified), EquivalentType(equivalent) 
    //START JInit
    super(TypeClass.Attributed, new QualType(canon), canon.$arrow().isDependentType(), 
        canon.$arrow().isInstantiationDependentType(), 
        canon.$arrow().isVariablyModifiedType(), 
        canon.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.ModifiedType = new QualType(modified);
    this.EquivalentType = new QualType(equivalent);
    //END JInit
    Unnamed_field.AttributedTypeBits.AttrKind = $uint2uint_14bits(attrKind.getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::getAttrKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3827,
   FQN="clang::AttributedType::getAttrKind", NM="_ZNK5clang14AttributedType11getAttrKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType11getAttrKindEv")
  //</editor-fold>
  public Kind getAttrKind() /*const*/ {
    return /*static_cast*/Kind.valueOf($ushort2uint(Unnamed_field.AttributedTypeBits.AttrKind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::getModifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3831,
   FQN="clang::AttributedType::getModifiedType", NM="_ZNK5clang14AttributedType15getModifiedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType15getModifiedTypeEv")
  //</editor-fold>
  public QualType getModifiedType() /*const*/ {
    return new QualType(ModifiedType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::getEquivalentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3832,
   FQN="clang::AttributedType::getEquivalentType", NM="_ZNK5clang14AttributedType17getEquivalentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType17getEquivalentTypeEv")
  //</editor-fold>
  public QualType getEquivalentType() /*const*/ {
    return new QualType(EquivalentType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3834,
   FQN="clang::AttributedType::isSugared", NM="_ZNK5clang14AttributedType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3835,
   FQN="clang::AttributedType::desugar", NM="_ZNK5clang14AttributedType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getEquivalentType();
  }

  
  /// Does this attribute behave like a type qualifier?
  ///
  /// A type qualifier adjusts a type to provide specialized rules for
  /// a specific object, like the standard const and volatile qualifiers.
  /// This includes attributes controlling things like nullability,
  /// address spaces, and ARC ownership.  The value of the object is still
  /// largely described by the modified type.
  ///
  /// In contrast, many type attributes "rewrite" their modified type to
  /// produce a fundamentally different type, not necessarily related in any
  /// formalizable way to the original type.  For example, calling convention
  /// and vector attributes are not simple type qualifiers.
  ///
  /// Type qualifiers are often, but not always, reflected in the canonical
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::isQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2968,
   FQN="clang::AttributedType::isQualifier", NM="_ZNK5clang14AttributedType11isQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType11isQualifierEv")
  //</editor-fold>
  public boolean isQualifier() /*const*/ {
    switch (getAttrKind()) {
     case attr_address_space:
     case attr_objc_gc:
     case attr_objc_ownership:
     case attr_objc_inert_unsafe_unretained:
     case attr_nonnull:
     case attr_nullable:
     case attr_null_unspecified:
      // These are type qualifiers in the traditional C sense: they annotate
      // something about a specific value/variable of a type.  (They aren't
      // always part of the canonical type, though.)
      return true;
     case attr_regparm:
     case attr_vector_size:
     case attr_neon_vector_type:
     case attr_neon_polyvector_type:
     case attr_pcs:
     case attr_pcs_vfp:
     case attr_noreturn:
     case attr_cdecl:
     case attr_fastcall:
     case attr_stdcall:
     case attr_thiscall:
     case attr_pascal:
     case attr_swiftcall:
     case attr_vectorcall:
     case attr_inteloclbicc:
     case attr_preserve_most:
     case attr_preserve_all:
     case attr_ms_abi:
     case attr_sysv_abi:
     case attr_ptr32:
     case attr_ptr64:
     case attr_sptr:
     case attr_uptr:
     case attr_objc_kindof:
      
      // These aren't qualifiers; they rewrite the modified type to be a
      // semantically different type.
      return false;
    }
    throw new llvm_unreachable("bad attributed type kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::isMSTypeSpec">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3013,
   FQN="clang::AttributedType::isMSTypeSpec", NM="_ZNK5clang14AttributedType12isMSTypeSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType12isMSTypeSpecEv")
  //</editor-fold>
  public boolean isMSTypeSpec() /*const*/ {
    switch (getAttrKind()) {
     default:
      return false;
     case attr_ptr32:
     case attr_ptr64:
     case attr_sptr:
     case attr_uptr:
      return true;
    }
    // throw new llvm_unreachable("invalid attr kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::isCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3025,
   FQN="clang::AttributedType::isCallingConv", NM="_ZNK5clang14AttributedType13isCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType13isCallingConvEv")
  //</editor-fold>
  public boolean isCallingConv() /*const*/ {
    switch (getAttrKind()) {
     case attr_ptr32:
     case attr_ptr64:
     case attr_sptr:
     case attr_uptr:
     case attr_address_space:
     case attr_regparm:
     case attr_vector_size:
     case attr_neon_vector_type:
     case attr_neon_polyvector_type:
     case attr_objc_gc:
     case attr_objc_ownership:
     case attr_objc_inert_unsafe_unretained:
     case attr_noreturn:
     case attr_nonnull:
     case attr_nullable:
     case attr_null_unspecified:
     case attr_objc_kindof:
      return false;
     case attr_pcs:
     case attr_pcs_vfp:
     case attr_cdecl:
     case attr_fastcall:
     case attr_stdcall:
     case attr_thiscall:
     case attr_swiftcall:
     case attr_vectorcall:
     case attr_pascal:
     case attr_ms_abi:
     case attr_sysv_abi:
     case attr_inteloclbicc:
     case attr_preserve_most:
     case attr_preserve_all:
      return true;
    }
    throw new llvm_unreachable("invalid attr kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::getImmediateNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3609,
   FQN="clang::AttributedType::getImmediateNullability", NM="_ZNK5clang14AttributedType23getImmediateNullabilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang14AttributedType23getImmediateNullabilityEv")
  //</editor-fold>
  public Optional<NullabilityKind> getImmediateNullability() /*const*/ {
    if (getAttrKind() == AttributedType.Kind.attr_nonnull) {
      return new Optional<NullabilityKind>(JD$T$RR.INSTANCE, NullabilityKind.NonNull);
    }
    if (getAttrKind() == AttributedType.Kind.attr_nullable) {
      return new Optional<NullabilityKind>(JD$T$RR.INSTANCE, NullabilityKind.Nullable);
    }
    if (getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
      return new Optional<NullabilityKind>(JD$T$RR.INSTANCE, NullabilityKind.Unspecified);
    }
    return new Optional<NullabilityKind>(None);
  }

  
  /// Retrieve the attribute kind corresponding to the given
  /// nullability kind.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::getNullabilityAttrKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3862,
   FQN="clang::AttributedType::getNullabilityAttrKind", NM="_ZN5clang14AttributedType22getNullabilityAttrKindENS_15NullabilityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedType22getNullabilityAttrKindENS_15NullabilityKindE")
  //</editor-fold>
  public static Kind getNullabilityAttrKind(NullabilityKind kind) {
    switch (kind) {
     case NonNull:
      return Kind.attr_nonnull;
     case Nullable:
      return Kind.attr_nullable;
     case Unspecified:
      return Kind.attr_null_unspecified;
    }
    throw new llvm_unreachable("Unknown nullability kind.");
  }

  
  /// Strip off the top-level nullability annotation on the given
  /// type, if it's there.
  ///
  /// \param T The type to strip. If the type is exactly an
  /// AttributedType specifying nullability (without looking through
  /// type sugar), the nullability is returned and this type changed
  /// to the underlying modified type.
  ///
  /// \returns the top-level nullability, if present.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::stripOuterNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3619,
   FQN="clang::AttributedType::stripOuterNullability", NM="_ZN5clang14AttributedType21stripOuterNullabilityERNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedType21stripOuterNullabilityERNS_8QualTypeE")
  //</editor-fold>
  public static Optional<NullabilityKind> stripOuterNullability(final QualType /*&*/ T) {
    {
      /*const*/ AttributedType /*P*/ attributed = dyn_cast_AttributedType(T.getTypePtr());
      if ((attributed != null)) {
        {
          Optional<NullabilityKind> nullability = attributed.getImmediateNullability();
          if (nullability.$bool()) {
            T.$assignMove(attributed.getModifiedType());
            return nullability;
          }
        }
      }
    }
    
    return new Optional<NullabilityKind>(None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3887,
   FQN="clang::AttributedType::Profile", NM="_ZN5clang14AttributedType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getAttrKind(), /*NO_COPY*/ModifiedType, /*NO_COPY*/EquivalentType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3891,
   FQN="clang::AttributedType::Profile", NM="_ZN5clang14AttributedType7ProfileERN4llvm16FoldingSetNodeIDENS0_4KindENS_8QualTypeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedType7ProfileERN4llvm16FoldingSetNodeIDENS0_4KindENS_8QualTypeES5_")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, Kind attrKind, 
         QualType modified, QualType equivalent) {
    ID.AddInteger_int(attrKind.getValue());
    ID.AddPointer(modified.getAsOpaquePtr());
    ID.AddPointer(equivalent.getAsOpaquePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3898,
   FQN="clang::AttributedType::classof", NM="_ZN5clang14AttributedType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang14AttributedType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Attributed;
  }

  @Override public String toString() {
    return "" + "ModifiedType=" + ModifiedType // NOI18N
              + ", EquivalentType=" + EquivalentType // NOI18N
              + super.toString(); // NOI18N
  }
}
