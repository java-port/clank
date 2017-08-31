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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.impl.DeclSpecStatics.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;


/// \brief Captures information about "declaration specifiers".
///
/// "Declaration specifiers" encompasses storage-class-specifiers,
/// type-specifiers, type-qualifiers, and function-specifiers.
//<editor-fold defaultstate="collapsed" desc="clang::DeclSpec">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 228,
 FQN="clang::DeclSpec", NM="_ZN5clang8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpecE")
//</editor-fold>
public class DeclSpec implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief storage-class-specifier
  /// \note The order of these enumerators is important for diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SCS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 232,
   FQN="clang::DeclSpec::SCS", NM="_ZN5clang8DeclSpec3SCSE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec3SCSE")
  //</editor-fold>
  public enum SCS implements Native.ComparableLower {
    SCS_unspecified(0),
    SCS_typedef(SCS_unspecified.getValue() + 1),
    SCS_extern(SCS_typedef.getValue() + 1),
    SCS_static(SCS_extern.getValue() + 1),
    SCS_auto(SCS_static.getValue() + 1),
    SCS_register(SCS_auto.getValue() + 1),
    SCS_private_extern(SCS_register.getValue() + 1),
    SCS_mutable(SCS_private_extern.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SCS valueOf(int val) {
      SCS out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SCS[] VALUES;
      private static final SCS[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SCS kind : SCS.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SCS[min < 0 ? (1-min) : 0];
        VALUES = new SCS[max >= 0 ? (1+max) : 0];
        for (SCS kind : SCS.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SCS(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SCS)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SCS)obj).value);}
    //</editor-fold>
  };
  
  // Import thread storage class specifier enumeration and constants.
  // These can be combined with SCS_extern and SCS_static.
  /*typedef ThreadStorageClassSpecifier TSCS*/
//  public final class TSCS extends ThreadStorageClassSpecifier{ };
  public static /*const*/ ThreadStorageClassSpecifier TSCS_unspecified = ThreadStorageClassSpecifier.TSCS_unspecified;
  public static /*const*/ ThreadStorageClassSpecifier TSCS___thread = ThreadStorageClassSpecifier.TSCS___thread;
  public static /*const*/ ThreadStorageClassSpecifier TSCS_thread_local = ThreadStorageClassSpecifier.TSCS_thread_local;
  public static /*const*/ ThreadStorageClassSpecifier TSCS__Thread_local = ThreadStorageClassSpecifier.TSCS__Thread_local;
  
  // Import type specifier width enumeration and constants.
  /*typedef TypeSpecifierWidth TSW*/
//  public final class TSW extends TypeSpecifierWidth{ };
  public static /*const*/ TypeSpecifierWidth TSW_unspecified = TypeSpecifierWidth.TSW_unspecified;
  public static /*const*/ TypeSpecifierWidth TSW_short = TypeSpecifierWidth.TSW_short;
  public static /*const*/ TypeSpecifierWidth TSW_long = TypeSpecifierWidth.TSW_long;
  public static /*const*/ TypeSpecifierWidth TSW_longlong = TypeSpecifierWidth.TSW_longlong;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::TSC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 258,
   FQN="clang::DeclSpec::TSC", NM="_ZN5clang8DeclSpec3TSCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec3TSCE")
  //</editor-fold>
  public enum TSC implements Native.ComparableLower {
    TSC_unspecified(0),
    TSC_imaginary(TSC_unspecified.getValue() + 1),
    TSC_complex(TSC_imaginary.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TSC valueOf(int val) {
      TSC out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TSC[] VALUES;
      private static final TSC[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TSC kind : TSC.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TSC[min < 0 ? (1-min) : 0];
        VALUES = new TSC[max >= 0 ? (1+max) : 0];
        for (TSC kind : TSC.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TSC(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TSC)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TSC)obj).value);}
    //</editor-fold>
  };
  
  // Import type specifier sign enumeration and constants.
  /*typedef TypeSpecifierSign TSS*/
//  public final class TSS extends TypeSpecifierSign{ };
  public static /*const*/ TypeSpecifierSign TSS_unspecified = TypeSpecifierSign.TSS_unspecified;
  public static /*const*/ TypeSpecifierSign TSS_signed = TypeSpecifierSign.TSS_signed;
  public static /*const*/ TypeSpecifierSign TSS_unsigned = TypeSpecifierSign.TSS_unsigned;
  
  // Import type specifier type enumeration and constants.
  /*typedef TypeSpecifierType TST*/
//  public final class TST extends TypeSpecifierType{ };
  public static /*const*/ TypeSpecifierType TST_unspecified = TypeSpecifierType.TST_unspecified;
  public static /*const*/ TypeSpecifierType TST_void = TypeSpecifierType.TST_void;
  public static /*const*/ TypeSpecifierType TST_char = TypeSpecifierType.TST_char;
  public static /*const*/ TypeSpecifierType TST_wchar = TypeSpecifierType.TST_wchar;
  public static /*const*/ TypeSpecifierType TST_char16 = TypeSpecifierType.TST_char16;
  public static /*const*/ TypeSpecifierType TST_char32 = TypeSpecifierType.TST_char32;
  public static /*const*/ TypeSpecifierType TST_int = TypeSpecifierType.TST_int;
  public static /*const*/ TypeSpecifierType TST_int128 = TypeSpecifierType.TST_int128;
  public static /*const*/ TypeSpecifierType TST_half = TypeSpecifierType.TST_half;
  public static /*const*/ TypeSpecifierType TST_float = TypeSpecifierType.TST_float;
  public static /*const*/ TypeSpecifierType TST_double = TypeSpecifierType.TST_double;
  public static /*const*/ TypeSpecifierType TST_float128 = TypeSpecifierType.TST_float128;
  public static /*const*/ TypeSpecifierType TST_bool = TypeSpecifierType.TST_bool;
  public static /*const*/ TypeSpecifierType TST_decimal32 = TypeSpecifierType.TST_decimal32;
  public static /*const*/ TypeSpecifierType TST_decimal64 = TypeSpecifierType.TST_decimal64;
  public static /*const*/ TypeSpecifierType TST_decimal128 = TypeSpecifierType.TST_decimal128;
  public static /*const*/ TypeSpecifierType TST_enum = TypeSpecifierType.TST_enum;
  public static /*const*/ TypeSpecifierType TST_union = TypeSpecifierType.TST_union;
  public static /*const*/ TypeSpecifierType TST_struct = TypeSpecifierType.TST_struct;
  public static /*const*/ TypeSpecifierType TST_interface = TypeSpecifierType.TST_interface;
  public static /*const*/ TypeSpecifierType TST_class = TypeSpecifierType.TST_class;
  public static /*const*/ TypeSpecifierType TST_typename = TypeSpecifierType.TST_typename;
  public static /*const*/ TypeSpecifierType TST_typeofType = TypeSpecifierType.TST_typeofType;
  public static /*const*/ TypeSpecifierType TST_typeofExpr = TypeSpecifierType.TST_typeofExpr;
  public static /*const*/ TypeSpecifierType TST_decltype = TypeSpecifierType.TST_decltype;
  public static /*const*/ TypeSpecifierType TST_decltype_auto = TypeSpecifierType.TST_decltype_auto;
  public static /*const*/ TypeSpecifierType TST_underlyingType = TypeSpecifierType.TST_underlyingType;
  public static /*const*/ TypeSpecifierType TST_auto = TypeSpecifierType.TST_auto;
  public static /*const*/ TypeSpecifierType TST_auto_type = TypeSpecifierType.TST_auto_type;
  public static /*const*/ TypeSpecifierType TST_unknown_anytype = TypeSpecifierType.TST_unknown_anytype;
  public static /*const*/ TypeSpecifierType TST_atomic = TypeSpecifierType.TST_atomic;
  public static /*const*/ TypeSpecifierType TST_image1d_t = TypeSpecifierType.TST_image1d_t;
  public static /*const*/ TypeSpecifierType TST_image1d_array_t = TypeSpecifierType.TST_image1d_array_t;
  public static /*const*/ TypeSpecifierType TST_image1d_buffer_t = TypeSpecifierType.TST_image1d_buffer_t;
  public static /*const*/ TypeSpecifierType TST_image2d_t = TypeSpecifierType.TST_image2d_t;
  public static /*const*/ TypeSpecifierType TST_image2d_array_t = TypeSpecifierType.TST_image2d_array_t;
  public static /*const*/ TypeSpecifierType TST_image2d_depth_t = TypeSpecifierType.TST_image2d_depth_t;
  public static /*const*/ TypeSpecifierType TST_image2d_array_depth_t = TypeSpecifierType.TST_image2d_array_depth_t;
  public static /*const*/ TypeSpecifierType TST_image2d_msaa_t = TypeSpecifierType.TST_image2d_msaa_t;
  public static /*const*/ TypeSpecifierType TST_image2d_array_msaa_t = TypeSpecifierType.TST_image2d_array_msaa_t;
  public static /*const*/ TypeSpecifierType TST_image2d_msaa_depth_t = TypeSpecifierType.TST_image2d_msaa_depth_t;
  public static /*const*/ TypeSpecifierType TST_image2d_array_msaa_depth_t = TypeSpecifierType.TST_image2d_array_msaa_depth_t;
  public static /*const*/ TypeSpecifierType TST_image3d_t = TypeSpecifierType.TST_image3d_t;
  public static /*const*/ TypeSpecifierType TST_error = TypeSpecifierType.TST_error;
  
  // type-qualifiers
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::TQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 309,
   FQN="clang::DeclSpec::TQ", NM="_ZN5clang8DeclSpec2TQE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec2TQE")
  //</editor-fold>
  public enum TQ implements Native.ComparableLower {
    // NOTE: These flags must be kept in sync with Qualifiers::TQ.
    TQ_unspecified(0),
    TQ_const(1),
    TQ_restrict(2),
    TQ_volatile(4),
    TQ_unaligned(8),
    // This has no corresponding Qualifiers::TQ value, because it's not treated
    // as a qualifier in our type system.
    TQ_atomic(16);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TQ valueOf(int val) {
      TQ out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TQ[] VALUES;
      private static final TQ[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TQ kind : TQ.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TQ[min < 0 ? (1-min) : 0];
        VALUES = new TQ[max >= 0 ? (1+max) : 0];
        for (TQ kind : TQ.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TQ(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TQ)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TQ)obj).value);}
    //</editor-fold>
  };
  
  /// ParsedSpecifiers - Flags to query which specifiers were applied.  This is
  /// returned by getParsedSpecifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ParsedSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 322,
   FQN="clang::DeclSpec::ParsedSpecifiers", NM="_ZN5clang8DeclSpec16ParsedSpecifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16ParsedSpecifiersE")
  //</editor-fold>
  public enum ParsedSpecifiers implements Native.ComparableLower {
    PQ_None(0),
    PQ_StorageClassSpecifier(1),
    PQ_TypeSpecifier(2),
    PQ_TypeQualifier(4),
    PQ_FunctionSpecifier(8);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ParsedSpecifiers valueOf(int val) {
      ParsedSpecifiers out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ParsedSpecifiers[] VALUES;
      private static final ParsedSpecifiers[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ParsedSpecifiers kind : ParsedSpecifiers.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ParsedSpecifiers[min < 0 ? (1-min) : 0];
        VALUES = new ParsedSpecifiers[max >= 0 ? (1+max) : 0];
        for (ParsedSpecifiers kind : ParsedSpecifiers.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ParsedSpecifiers(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ParsedSpecifiers)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ParsedSpecifiers)obj).value);}
    //</editor-fold>
  };
/*private:*/
  // storage-class-specifier
  /*SCS*/
  private /*JBYTE unsigned int*/ byte StorageClassSpec /*: 3*/;
  /*TSCS*/
  private /*JBYTE unsigned int*/ byte ThreadStorageClassSpec /*: 2*/;
  private /*JBIT unsigned int*/ boolean SCS_extern_in_linkage_spec /*: 1*/;
  
  // type-specifier
  /*TSW*/
  private /*JBYTE unsigned int*/ byte TypeSpecWidth /*: 2*/;
  /*TSC*/
  private /*JBYTE unsigned int*/ byte TypeSpecComplex /*: 2*/;
  /*TSS*/
  private /*JBYTE unsigned int*/ byte TypeSpecSign /*: 2*/;
  /*TST*/
  private /*JBYTE unsigned int*/ byte TypeSpecType /*: 6*/;
  private /*JBIT unsigned int*/ boolean TypeAltiVecVector /*: 1*/;
  private /*JBIT unsigned int*/ boolean TypeAltiVecPixel /*: 1*/;
  private /*JBIT unsigned int*/ boolean TypeAltiVecBool /*: 1*/;
  private /*JBIT unsigned int*/ boolean TypeSpecOwned /*: 1*/;
  private /*JBIT unsigned int*/ boolean TypeSpecPipe /*: 1*/;
  
  // type-qualifiers
  private /*JBYTE unsigned int*/ byte TypeQualifiers /*: 5*/; // Bitwise OR of TQ.
  
  // function-specifier
  private /*JBIT unsigned int*/ boolean FS_inline_specified /*: 1*/;
  private /*JBIT unsigned int*/ boolean FS_forceinline_specified /*: 1*/;
  private /*JBIT unsigned int*/ boolean FS_virtual_specified /*: 1*/;
  private /*JBIT unsigned int*/ boolean FS_explicit_specified /*: 1*/;
  private /*JBIT unsigned int*/ boolean FS_noreturn_specified /*: 1*/;
  
  // friend-specifier
  private /*JBIT unsigned int*/ boolean Friend_specified /*: 1*/;
  
  // constexpr-specifier
  private /*JBIT unsigned int*/ boolean Constexpr_specified /*: 1*/;
  
  // concept-specifier
  private /*JBIT unsigned int*/ boolean Concept_specified /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 366,
   FQN="clang::DeclSpec::(anonymous)", NM="_ZN5clang8DeclSpecE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpecE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public final UnionOpaquePtr<QualType> TypeRep = new UnionOpaquePtr();
    public Decl /*P*/ DeclRep;
    public Expr /*P*/ ExprRep;
    
    @Override public String toString() {
      return "" + "TypeRep=" + TypeRep // NOI18N
                + ", DeclRep=" + DeclRep // NOI18N
                + ", ExprRep=" + ExprRep; // NOI18N
    }
  };
  private final Unnamed_union1 Unnamed_field21 = new Unnamed_union1();
  
  // attributes.
  private ParsedAttributes Attrs;
  
  // Scope specifier for the type spec, if applicable.
  private CXXScopeSpec TypeScope;
  
  // SourceLocation info.  These are null if the item wasn't specified or if
  // the setting was synthesized.
  private SourceRange Range;
  
  private SourceLocation StorageClassSpecLoc;
  
  private SourceLocation ThreadStorageClassSpecLoc;
  private SourceLocation TSWLoc;
  private SourceLocation TSCLoc;
  private SourceLocation TSSLoc;
  private SourceLocation TSTLoc;
  private SourceLocation AltiVecLoc;
  /// TSTNameLoc - If TypeSpecType is any of class, enum, struct, union,
  /// typename, then this is the location of the named type (if present);
  /// otherwise, it is the same as TSTLoc. Hence, the pair TSTLoc and
  /// TSTNameLoc provides source range info for tag types.
  private SourceLocation TSTNameLoc;
  private SourceRange TypeofParensRange;
  private SourceLocation TQ_constLoc;
  private SourceLocation TQ_restrictLoc;
  private SourceLocation TQ_volatileLoc;
  private SourceLocation TQ_atomicLoc;
  private SourceLocation TQ_unalignedLoc;
  private SourceLocation FS_inlineLoc;
  private SourceLocation FS_virtualLoc;
  private SourceLocation FS_explicitLoc;
  private SourceLocation FS_noreturnLoc;
  private SourceLocation FS_forceinlineLoc;
  private SourceLocation FriendLoc;
  private SourceLocation ModulePrivateLoc;
  private SourceLocation ConstexprLoc;
  private SourceLocation ConceptLoc;
  private SourceLocation TQ_pipeLoc;
  
  private WrittenBuiltinSpecs writtenBS;
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SaveWrittenBuiltinSpecs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 933,
   FQN="clang::DeclSpec::SaveWrittenBuiltinSpecs", NM="_ZN5clang8DeclSpec23SaveWrittenBuiltinSpecsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec23SaveWrittenBuiltinSpecsEv")
  //</editor-fold>
  private void SaveWrittenBuiltinSpecs() {
    writtenBS.Sign = $uint2uint_2bits(getTypeSpecSign().getValue());
    writtenBS.Width = $uint2uint_2bits(getTypeSpecWidth().getValue());
    writtenBS.Type = $uint2uint_6bits(getTypeSpecType().getValue());
    // Search the list of attributes for the presence of a mode attribute.
    writtenBS.ModeAttr = false;
    AttributeList /*P*/ attrs = getAttributes().getList();
    while ((attrs != null)) {
      if (attrs.getKind() == AttributeList.Kind.AT_Mode) {
        writtenBS.ModeAttr = true;
        break;
      }
      attrs = attrs.getNext();
    }
  }

  
  private ObjCDeclSpec /*P*/ ObjCQualifiers;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 402,
   FQN="clang::DeclSpec::isTypeRep", NM="_ZN5clang8DeclSpec9isTypeRepENS_17TypeSpecifierTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec9isTypeRepENS_17TypeSpecifierTypeE")
  //</editor-fold>
  private static boolean isTypeRep(TypeSpecifierType T) {
    return (T == TST_typename || T == TST_typeofType
       || T == TST_underlyingType || T == TST_atomic);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isExprRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 406,
   FQN="clang::DeclSpec::isExprRep", NM="_ZN5clang8DeclSpec9isExprRepENS_17TypeSpecifierTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec9isExprRepENS_17TypeSpecifierTypeE")
  //</editor-fold>
  private static boolean isExprRep(TypeSpecifierType T) {
    return (T == TST_typeofExpr || T == TST_decltype);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::DeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 410,
   FQN="clang::DeclSpec::DeclSpec", NM="_ZN5clang8DeclSpecC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpecC1ERKS0_")
  //</editor-fold>
  private DeclSpec(final /*const*/ DeclSpec /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 411,
   FQN="clang::DeclSpec::operator=", NM="_ZN5clang8DeclSpecaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpecaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ DeclSpec /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isDeclRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 413,
   FQN="clang::DeclSpec::isDeclRep", NM="_ZN5clang8DeclSpec9isDeclRepENS_17TypeSpecifierTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec9isDeclRepENS_17TypeSpecifierTypeE")
  //</editor-fold>
  public static boolean isDeclRep(TypeSpecifierType T) {
    return (T == TST_enum || T == TST_struct
       || T == TST_interface || T == TST_union
       || T == TST_class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::DeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 419,
   FQN="clang::DeclSpec::DeclSpec", NM="_ZN5clang8DeclSpecC1ERNS_16AttributeFactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpecC1ERNS_16AttributeFactoryE")
  //</editor-fold>
  public DeclSpec(final AttributeFactory /*&*/ attrFactory) {
    // : StorageClassSpec(SCS_unspecified), ThreadStorageClassSpec(TSCS_unspecified), SCS_extern_in_linkage_spec(false), TypeSpecWidth(TSW_unspecified), TypeSpecComplex(TSC_unspecified), TypeSpecSign(TSS_unspecified), TypeSpecType(TST_unspecified), TypeAltiVecVector(false), TypeAltiVecPixel(false), TypeAltiVecBool(false), TypeSpecOwned(false), TypeSpecPipe(false), TypeQualifiers(TQ_unspecified), FS_inline_specified(false), FS_forceinline_specified(false), FS_virtual_specified(false), FS_explicit_specified(false), FS_noreturn_specified(false), Friend_specified(false), Constexpr_specified(false), Concept_specified(false), Attrs(attrFactory), TypeScope(), Range(), StorageClassSpecLoc(), ThreadStorageClassSpecLoc(), TSWLoc(), TSCLoc(), TSSLoc(), TSTLoc(), AltiVecLoc(), TSTNameLoc(), TypeofParensRange(), TQ_constLoc(), TQ_restrictLoc(), TQ_volatileLoc(), TQ_atomicLoc(), TQ_unalignedLoc(), FS_inlineLoc(), FS_virtualLoc(), FS_explicitLoc(), FS_noreturnLoc(), FS_forceinlineLoc(), FriendLoc(), ModulePrivateLoc(), ConstexprLoc(), ConceptLoc(), TQ_pipeLoc(), writtenBS(), ObjCQualifiers(null) 
    //START JInit
    this.StorageClassSpec = $uint2uint_3bits(SCS.SCS_unspecified.getValue());
    this.ThreadStorageClassSpec = $uint2uint_2bits(TSCS_unspecified.getValue());
    this.SCS_extern_in_linkage_spec = false;
    this.TypeSpecWidth = $uint2uint_2bits(TSW_unspecified.getValue());
    this.TypeSpecComplex = $uint2uint_2bits(TSC.TSC_unspecified.getValue());
    this.TypeSpecSign = $uint2uint_2bits(TSS_unspecified.getValue());
    this.TypeSpecType = $uint2uint_6bits(TST_unspecified.getValue());
    this.TypeAltiVecVector = false;
    this.TypeAltiVecPixel = false;
    this.TypeAltiVecBool = false;
    this.TypeSpecOwned = false;
    this.TypeSpecPipe = false;
    this.TypeQualifiers = $uint2uint_5bits(TQ.TQ_unspecified.getValue());
    this.FS_inline_specified = false;
    this.FS_forceinline_specified = false;
    this.FS_virtual_specified = false;
    this.FS_explicit_specified = false;
    this.FS_noreturn_specified = false;
    this.Friend_specified = false;
    this.Constexpr_specified = false;
    this.Concept_specified = false;
    this.Attrs = new ParsedAttributes(attrFactory);
    this.TypeScope = new CXXScopeSpec();
    this.Range = new SourceRange();
    this.StorageClassSpecLoc = new SourceLocation();
    this.ThreadStorageClassSpecLoc = new SourceLocation();
    this.TSWLoc = new SourceLocation();
    this.TSCLoc = new SourceLocation();
    this.TSSLoc = new SourceLocation();
    this.TSTLoc = new SourceLocation();
    this.AltiVecLoc = new SourceLocation();
    this.TSTNameLoc = new SourceLocation();
    this.TypeofParensRange = new SourceRange();
    this.TQ_constLoc = new SourceLocation();
    this.TQ_restrictLoc = new SourceLocation();
    this.TQ_volatileLoc = new SourceLocation();
    this.TQ_atomicLoc = new SourceLocation();
    this.TQ_unalignedLoc = new SourceLocation();
    this.FS_inlineLoc = new SourceLocation();
    this.FS_virtualLoc = new SourceLocation();
    this.FS_explicitLoc = new SourceLocation();
    this.FS_noreturnLoc = new SourceLocation();
    this.FS_forceinlineLoc = new SourceLocation();
    this.FriendLoc = new SourceLocation();
    this.ModulePrivateLoc = new SourceLocation();
    this.ConstexprLoc = new SourceLocation();
    this.ConceptLoc = new SourceLocation();
    this.TQ_pipeLoc = new SourceLocation();
    this.writtenBS = new WrittenBuiltinSpecs();
    this.ObjCQualifiers = null;
    //END JInit
  }

  
  // storage-class-specifier
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getStorageClassSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 447,
   FQN="clang::DeclSpec::getStorageClassSpec", NM="_ZNK5clang8DeclSpec19getStorageClassSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19getStorageClassSpecEv")
  //</editor-fold>
  public SCS getStorageClassSpec() /*const*/ {
    return SCS.valueOf(StorageClassSpec);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getThreadStorageClassSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 448,
   FQN="clang::DeclSpec::getThreadStorageClassSpec", NM="_ZNK5clang8DeclSpec25getThreadStorageClassSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec25getThreadStorageClassSpecEv")
  //</editor-fold>
  public ThreadStorageClassSpecifier getThreadStorageClassSpec() /*const*/ {
    return ThreadStorageClassSpecifier.valueOf(ThreadStorageClassSpec);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isExternInLinkageSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 451,
   FQN="clang::DeclSpec::isExternInLinkageSpec", NM="_ZNK5clang8DeclSpec21isExternInLinkageSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec21isExternInLinkageSpecEv")
  //</editor-fold>
  public boolean isExternInLinkageSpec() /*const*/ {
    return SCS_extern_in_linkage_spec;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setExternInLinkageSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 452,
   FQN="clang::DeclSpec::setExternInLinkageSpec", NM="_ZN5clang8DeclSpec22setExternInLinkageSpecEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec22setExternInLinkageSpecEb")
  //</editor-fold>
  public void setExternInLinkageSpec(boolean Value) {
    SCS_extern_in_linkage_spec = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getStorageClassSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 456,
   FQN="clang::DeclSpec::getStorageClassSpecLoc", NM="_ZNK5clang8DeclSpec22getStorageClassSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec22getStorageClassSpecLocEv")
  //</editor-fold>
  public SourceLocation getStorageClassSpecLoc() /*const*/ {
    return new SourceLocation(StorageClassSpecLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getThreadStorageClassSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 457,
   FQN="clang::DeclSpec::getThreadStorageClassSpecLoc", NM="_ZNK5clang8DeclSpec28getThreadStorageClassSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec28getThreadStorageClassSpecLocEv")
  //</editor-fold>
  public SourceLocation getThreadStorageClassSpecLoc() /*const*/ {
    return new SourceLocation(ThreadStorageClassSpecLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ClearStorageClassSpecs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 461,
   FQN="clang::DeclSpec::ClearStorageClassSpecs", NM="_ZN5clang8DeclSpec22ClearStorageClassSpecsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec22ClearStorageClassSpecsEv")
  //</editor-fold>
  public void ClearStorageClassSpecs() {
    StorageClassSpec = $uint2uint_3bits(DeclSpec.SCS.SCS_unspecified.getValue());
    ThreadStorageClassSpec = $uint2uint_2bits(DeclSpec.TSCS_unspecified.getValue());
    SCS_extern_in_linkage_spec = false;
    StorageClassSpecLoc.$assignMove(new SourceLocation());
    ThreadStorageClassSpecLoc.$assignMove(new SourceLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ClearTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 469,
   FQN="clang::DeclSpec::ClearTypeSpecType", NM="_ZN5clang8DeclSpec17ClearTypeSpecTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec17ClearTypeSpecTypeEv")
  //</editor-fold>
  public void ClearTypeSpecType() {
    TypeSpecType = $uint2uint_6bits(DeclSpec.TST_unspecified.getValue());
    TypeSpecOwned = false;
    TSTLoc.$assignMove(new SourceLocation());
  }

  
  // type-specifier
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 476,
   FQN="clang::DeclSpec::getTypeSpecWidth", NM="_ZNK5clang8DeclSpec16getTypeSpecWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16getTypeSpecWidthEv")
  //</editor-fold>
  public TypeSpecifierWidth getTypeSpecWidth() /*const*/ {
    return TypeSpecifierWidth.valueOf(TypeSpecWidth);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 477,
   FQN="clang::DeclSpec::getTypeSpecComplex", NM="_ZNK5clang8DeclSpec18getTypeSpecComplexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getTypeSpecComplexEv")
  //</editor-fold>
  public TSC getTypeSpecComplex() /*const*/ {
    return TSC.valueOf(TypeSpecComplex);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecSign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 478,
   FQN="clang::DeclSpec::getTypeSpecSign", NM="_ZNK5clang8DeclSpec15getTypeSpecSignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec15getTypeSpecSignEv")
  //</editor-fold>
  public TypeSpecifierSign getTypeSpecSign() /*const*/ {
    return TypeSpecifierSign.valueOf(TypeSpecSign);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 479,
   FQN="clang::DeclSpec::getTypeSpecType", NM="_ZNK5clang8DeclSpec15getTypeSpecTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec15getTypeSpecTypeEv")
  //</editor-fold>
  public TypeSpecifierType getTypeSpecType() /*const*/ {
    return TypeSpecifierType.valueOf(TypeSpecType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeAltiVecVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 480,
   FQN="clang::DeclSpec::isTypeAltiVecVector", NM="_ZNK5clang8DeclSpec19isTypeAltiVecVectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19isTypeAltiVecVectorEv")
  //</editor-fold>
  public boolean isTypeAltiVecVector() /*const*/ {
    return TypeAltiVecVector;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeAltiVecPixel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 481,
   FQN="clang::DeclSpec::isTypeAltiVecPixel", NM="_ZNK5clang8DeclSpec18isTypeAltiVecPixelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18isTypeAltiVecPixelEv")
  //</editor-fold>
  public boolean isTypeAltiVecPixel() /*const*/ {
    return TypeAltiVecPixel;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeAltiVecBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 482,
   FQN="clang::DeclSpec::isTypeAltiVecBool", NM="_ZNK5clang8DeclSpec17isTypeAltiVecBoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17isTypeAltiVecBoolEv")
  //</editor-fold>
  public boolean isTypeAltiVecBool() /*const*/ {
    return TypeAltiVecBool;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeSpecOwned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 483,
   FQN="clang::DeclSpec::isTypeSpecOwned", NM="_ZNK5clang8DeclSpec15isTypeSpecOwnedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec15isTypeSpecOwnedEv")
  //</editor-fold>
  public boolean isTypeSpecOwned() /*const*/ {
    return TypeSpecOwned;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 484,
   FQN="clang::DeclSpec::isTypeRep", NM="_ZNK5clang8DeclSpec9isTypeRepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec9isTypeRepEv")
  //</editor-fold>
  public boolean isTypeRep() /*const*/ {
    return isTypeRep(TypeSpecifierType.valueOf(TypeSpecType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isTypeSpecPipe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 485,
   FQN="clang::DeclSpec::isTypeSpecPipe", NM="_ZNK5clang8DeclSpec14isTypeSpecPipeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec14isTypeSpecPipeEv")
  //</editor-fold>
  public boolean isTypeSpecPipe() /*const*/ {
    return TypeSpecPipe;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getRepAsType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 487,
   FQN="clang::DeclSpec::getRepAsType", NM="_ZNK5clang8DeclSpec12getRepAsTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec12getRepAsTypeEv")
  //</editor-fold>
  public OpaquePtr<QualType> getRepAsType() /*const*/ {
    assert (isTypeRep(TypeSpecifierType.valueOf(TypeSpecType))) : "DeclSpec does not store a type";
    return Unnamed_field21.TypeRep.$OpaquePtr$T();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getRepAsDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 491,
   FQN="clang::DeclSpec::getRepAsDecl", NM="_ZNK5clang8DeclSpec12getRepAsDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec12getRepAsDeclEv")
  //</editor-fold>
  public Decl /*P*/ getRepAsDecl() /*const*/ {
    assert (isDeclRep(TypeSpecifierType.valueOf(TypeSpecType))) : "DeclSpec does not store a decl";
    return Unnamed_field21.DeclRep;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getRepAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 495,
   FQN="clang::DeclSpec::getRepAsExpr", NM="_ZNK5clang8DeclSpec12getRepAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec12getRepAsExprEv")
  //</editor-fold>
  public Expr /*P*/ getRepAsExpr() /*const*/ {
    assert (isExprRep(TypeSpecifierType.valueOf(TypeSpecType))) : "DeclSpec does not store an expr";
    return Unnamed_field21.ExprRep;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 499,
   FQN="clang::DeclSpec::getTypeSpecScope", NM="_ZN5clang8DeclSpec16getTypeSpecScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getTypeSpecScopeEv")
  //</editor-fold>
  public CXXScopeSpec /*&*/ getTypeSpecScope() {
    return TypeScope;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 500,
   FQN="clang::DeclSpec::getTypeSpecScope", NM="_ZNK5clang8DeclSpec16getTypeSpecScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16getTypeSpecScopeEv")
  //</editor-fold>
  public /*const*/ CXXScopeSpec /*&*/ getTypeSpecScope$Const() /*const*/ {
    return TypeScope;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 502,
   FQN="clang::DeclSpec::getSourceRange", NM="_ZNK5clang8DeclSpec14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 503,
   FQN="clang::DeclSpec::getLocStart", NM="_ZNK5clang8DeclSpec11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 504,
   FQN="clang::DeclSpec::getLocEnd", NM="_ZNK5clang8DeclSpec9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecWidthLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 506,
   FQN="clang::DeclSpec::getTypeSpecWidthLoc", NM="_ZNK5clang8DeclSpec19getTypeSpecWidthLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19getTypeSpecWidthLocEv")
  //</editor-fold>
  public SourceLocation getTypeSpecWidthLoc() /*const*/ {
    return new SourceLocation(TSWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecComplexLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 507,
   FQN="clang::DeclSpec::getTypeSpecComplexLoc", NM="_ZNK5clang8DeclSpec21getTypeSpecComplexLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec21getTypeSpecComplexLocEv")
  //</editor-fold>
  public SourceLocation getTypeSpecComplexLoc() /*const*/ {
    return new SourceLocation(TSCLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecSignLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 508,
   FQN="clang::DeclSpec::getTypeSpecSignLoc", NM="_ZNK5clang8DeclSpec18getTypeSpecSignLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getTypeSpecSignLocEv")
  //</editor-fold>
  public SourceLocation getTypeSpecSignLoc() /*const*/ {
    return new SourceLocation(TSSLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 509,
   FQN="clang::DeclSpec::getTypeSpecTypeLoc", NM="_ZNK5clang8DeclSpec18getTypeSpecTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getTypeSpecTypeLocEv")
  //</editor-fold>
  public SourceLocation getTypeSpecTypeLoc() /*const*/ {
    return new SourceLocation(TSTLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getAltiVecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 510,
   FQN="clang::DeclSpec::getAltiVecLoc", NM="_ZNK5clang8DeclSpec13getAltiVecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec13getAltiVecLocEv")
  //</editor-fold>
  public SourceLocation getAltiVecLoc() /*const*/ {
    return new SourceLocation(AltiVecLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeSpecTypeNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 512,
   FQN="clang::DeclSpec::getTypeSpecTypeNameLoc", NM="_ZNK5clang8DeclSpec22getTypeSpecTypeNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec22getTypeSpecTypeNameLocEv")
  //</editor-fold>
  public SourceLocation getTypeSpecTypeNameLoc() /*const*/ {
    assert (isDeclRep(TypeSpecifierType.valueOf(TypeSpecType)) || TypeSpecType == $int2uint_6bits(TST_typename.getValue()));
    return new SourceLocation(TSTNameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeofParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 517,
   FQN="clang::DeclSpec::getTypeofParensRange", NM="_ZNK5clang8DeclSpec20getTypeofParensRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec20getTypeofParensRangeEv")
  //</editor-fold>
  public SourceRange getTypeofParensRange() /*const*/ {
    return new SourceRange(TypeofParensRange);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setTypeofParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 518,
   FQN="clang::DeclSpec::setTypeofParensRange", NM="_ZN5clang8DeclSpec20setTypeofParensRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec20setTypeofParensRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setTypeofParensRange(SourceRange range) {
    TypeofParensRange.$assign(range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::containsPlaceholderType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 520,
   FQN="clang::DeclSpec::containsPlaceholderType", NM="_ZNK5clang8DeclSpec23containsPlaceholderTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec23containsPlaceholderTypeEv")
  //</editor-fold>
  public boolean containsPlaceholderType() /*const*/ {
    return (TypeSpecType == $int2uint_6bits(TST_auto.getValue()) || TypeSpecType == $int2uint_6bits(TST_auto_type.getValue())
       || TypeSpecType == $int2uint_6bits(TST_decltype_auto.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::hasTagDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 354,
   FQN="clang::DeclSpec::hasTagDefinition", NM="_ZNK5clang8DeclSpec16hasTagDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16hasTagDefinitionEv")
  //</editor-fold>
  public boolean hasTagDefinition() /*const*/ {
    if (!TypeSpecOwned) {
      return false;
    }
    return cast(TagDecl.class, getRepAsDecl()).isCompleteDefinition();
  }

  
  /// \brief Turn a type-specifier-type into a string like "_Bool" or "union".
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 447,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS_17TypeSpecifierTypeERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS_17TypeSpecifierTypeERKNS_14PrintingPolicyE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName(TypeSpecifierType T, 
                  final /*const*/ PrintingPolicy /*&*/ Policy) {
    switch (T) {
     case TST_unspecified:
      return $("unspecified");
     case TST_void:
      return $void;
     case TST_char:
      return $char;
     case TST_wchar:
      return Policy.MSWChar ? $__wchar_t : $wchar_t;
     case TST_char16:
      return $char16_t;
     case TST_char32:
      return $char32_t;
     case TST_int:
      return $int;
     case TST_int128:
      return $__int128;
     case TST_half:
      return $half;
     case TST_float:
      return $float;
     case TST_double:
      return $double;
     case TST_float128:
      return $__float128;
     case TST_bool:
      return Policy.Bool ? $bool : $_Bool;
     case TST_decimal32:
      return $_Decimal32;
     case TST_decimal64:
      return $_Decimal64;
     case TST_decimal128:
      return $_Decimal128;
     case TST_enum:
      return $enum;
     case TST_class:
      return $class;
     case TST_union:
      return $union;
     case TST_struct:
      return $struct;
     case TST_interface:
      return $__interface;
     case TST_typename:
      return $("type-name");
     case TST_typeofType:
     case TST_typeofExpr:
      return $typeof;
     case TST_auto:
      return $auto;
     case TST_auto_type:
      return $__auto_type;
     case TST_decltype:
      return $("(decltype)");
     case TST_decltype_auto:
      return $("decltype(auto)");
     case TST_underlyingType:
      return $__underlying_type;
     case TST_unknown_anytype:
      return $__unknown_anytype;
     case TST_atomic:
      return $_Atomic;
     case TST_image1d_t:
      return $image1d_t;
     case TST_image1d_array_t:
      return $image1d_array_t;
     case TST_image1d_buffer_t:
      return $image1d_buffer_t;
     case TST_image2d_t:
      return $image2d_t;
     case TST_image2d_array_t:
      return $image2d_array_t;
     case TST_image2d_depth_t:
      return $image2d_depth_t;
     case TST_image2d_array_depth_t:
      return $image2d_array_depth_t;
     case TST_image2d_msaa_t:
      return $image2d_msaa_t;
     case TST_image2d_array_msaa_t:
      return image2d_array_msaa_t;
     case TST_image2d_msaa_depth_t:
      return $image2d_msaa_depth_t;
     case TST_image2d_array_msaa_depth_t:
      return $image2d_array_msaa_depth_t;
     case TST_image3d_t:
      return $image3d_t;
     case TST_error:
      return $("(error)");
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 490,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS0_2TQE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS0_2TQE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName_TQ(TQ T) {
    switch (T) {
     case TQ_unspecified:
      return $("unspecified");
     case TQ_const:
      return $const;
     case TQ_restrict:
      return $restrict;
     case TQ_volatile:
      return $volatile;
     case TQ_atomic:
      return $_Atomic;
     case TQ_unaligned:
      return $__unaligned;
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 438,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS_17TypeSpecifierSignE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS_17TypeSpecifierSignE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName_TypeSpecifierSign(TypeSpecifierSign S) {
    switch (S) {
     case TSS_unspecified:
      return $("unspecified");
     case TSS_signed:
      return $signed;
     case TSS_unsigned:
      return $unsigned;
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 428,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS0_3TSCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS0_3TSCE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName_TSC(TSC C) {
    switch (C) {
     case TSC_unspecified:
      return $("unspecified");
     case TSC_imaginary:
      return $("imaginary");
     case TSC_complex:
      return $("complex");
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 418,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS_18TypeSpecifierWidthE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS_18TypeSpecifierWidthE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName_TypeSpecifierWidth(TypeSpecifierWidth W) {
    switch (W) {
     case TSW_unspecified:
      return $("unspecified");
     case TSW_short:
      return $short;
     case TSW_long:
      return $long;
     case TSW_longlong:
      return $("long long");
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 394,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS0_3SCSE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS0_3SCSE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName_SCS(DeclSpec.SCS S) {
    switch (S) {
     case SCS_unspecified:
      return $("unspecified");
     case SCS_typedef:
      return $typedef;
     case SCS_extern:
      return $extern;
     case SCS_static:
      return $static;
     case SCS_auto:
      return $auto;
     case SCS_register:
      return $register;
     case SCS_private_extern:
      return $__private_extern__;
     case SCS_mutable:
      return $mutable;
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getSpecifierName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 408,
   FQN="clang::DeclSpec::getSpecifierName", NM="_ZN5clang8DeclSpec16getSpecifierNameENS_27ThreadStorageClassSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16getSpecifierNameENS_27ThreadStorageClassSpecifierE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName_ThreadStorageClassSpecifier(ThreadStorageClassSpecifier S) {
    switch (S) {
     case TSCS_unspecified:
      return $("unspecified");
     case TSCS___thread:
      return $__thread;
     case TSCS_thread_local:
      return $thread_local;
     case TSCS__Thread_local:
      return $_Thread_local;
    }
    throw new llvm_unreachable("Unknown typespec!");
  }

  
  // type-qualifiers
  
  /// getTypeQualifiers - Return a set of TQs.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getTypeQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 540,
   FQN="clang::DeclSpec::getTypeQualifiers", NM="_ZNK5clang8DeclSpec17getTypeQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17getTypeQualifiersEv")
  //</editor-fold>
  public /*uint*/int getTypeQualifiers() /*const*/ {
    return TypeQualifiers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getConstSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 541,
   FQN="clang::DeclSpec::getConstSpecLoc", NM="_ZNK5clang8DeclSpec15getConstSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec15getConstSpecLocEv")
  //</editor-fold>
  public SourceLocation getConstSpecLoc() /*const*/ {
    return new SourceLocation(TQ_constLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getRestrictSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 542,
   FQN="clang::DeclSpec::getRestrictSpecLoc", NM="_ZNK5clang8DeclSpec18getRestrictSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getRestrictSpecLocEv")
  //</editor-fold>
  public SourceLocation getRestrictSpecLoc() /*const*/ {
    return new SourceLocation(TQ_restrictLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getVolatileSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 543,
   FQN="clang::DeclSpec::getVolatileSpecLoc", NM="_ZNK5clang8DeclSpec18getVolatileSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getVolatileSpecLocEv")
  //</editor-fold>
  public SourceLocation getVolatileSpecLoc() /*const*/ {
    return new SourceLocation(TQ_volatileLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getAtomicSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 544,
   FQN="clang::DeclSpec::getAtomicSpecLoc", NM="_ZNK5clang8DeclSpec16getAtomicSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16getAtomicSpecLocEv")
  //</editor-fold>
  public SourceLocation getAtomicSpecLoc() /*const*/ {
    return new SourceLocation(TQ_atomicLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getUnalignedSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 545,
   FQN="clang::DeclSpec::getUnalignedSpecLoc", NM="_ZNK5clang8DeclSpec19getUnalignedSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19getUnalignedSpecLocEv")
  //</editor-fold>
  public SourceLocation getUnalignedSpecLoc() /*const*/ {
    return new SourceLocation(TQ_unalignedLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getPipeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 546,
   FQN="clang::DeclSpec::getPipeLoc", NM="_ZNK5clang8DeclSpec10getPipeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec10getPipeLocEv")
  //</editor-fold>
  public SourceLocation getPipeLoc() /*const*/ {
    return new SourceLocation(TQ_pipeLoc);
  }

  
  /// \brief Clear out all of the type qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ClearTypeQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 549,
   FQN="clang::DeclSpec::ClearTypeQualifiers", NM="_ZN5clang8DeclSpec19ClearTypeQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec19ClearTypeQualifiersEv")
  //</editor-fold>
  public void ClearTypeQualifiers() {
    TypeQualifiers = $uint2uint_5bits(0);
    TQ_constLoc.$assignMove(new SourceLocation());
    TQ_restrictLoc.$assignMove(new SourceLocation());
    TQ_volatileLoc.$assignMove(new SourceLocation());
    TQ_atomicLoc.$assignMove(new SourceLocation());
    TQ_unalignedLoc.$assignMove(new SourceLocation());
    TQ_pipeLoc.$assignMove(new SourceLocation());
  }

  
  // function-specifier
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isInlineSpecified">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 560,
   FQN="clang::DeclSpec::isInlineSpecified", NM="_ZNK5clang8DeclSpec17isInlineSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17isInlineSpecifiedEv")
  //</editor-fold>
  public boolean isInlineSpecified() /*const*/ {
    return ((FS_inline_specified | FS_forceinline_specified));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getInlineSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 563,
   FQN="clang::DeclSpec::getInlineSpecLoc", NM="_ZNK5clang8DeclSpec16getInlineSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16getInlineSpecLocEv")
  //</editor-fold>
  public SourceLocation getInlineSpecLoc() /*const*/ {
    return new SourceLocation(FS_inline_specified ? FS_inlineLoc : FS_forceinlineLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isVirtualSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 567,
   FQN="clang::DeclSpec::isVirtualSpecified", NM="_ZNK5clang8DeclSpec18isVirtualSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18isVirtualSpecifiedEv")
  //</editor-fold>
  public boolean isVirtualSpecified() /*const*/ {
    return FS_virtual_specified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getVirtualSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 568,
   FQN="clang::DeclSpec::getVirtualSpecLoc", NM="_ZNK5clang8DeclSpec17getVirtualSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17getVirtualSpecLocEv")
  //</editor-fold>
  public SourceLocation getVirtualSpecLoc() /*const*/ {
    return new SourceLocation(FS_virtualLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isExplicitSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 570,
   FQN="clang::DeclSpec::isExplicitSpecified", NM="_ZNK5clang8DeclSpec19isExplicitSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19isExplicitSpecifiedEv")
  //</editor-fold>
  public boolean isExplicitSpecified() /*const*/ {
    return FS_explicit_specified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getExplicitSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 571,
   FQN="clang::DeclSpec::getExplicitSpecLoc", NM="_ZNK5clang8DeclSpec18getExplicitSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getExplicitSpecLocEv")
  //</editor-fold>
  public SourceLocation getExplicitSpecLoc() /*const*/ {
    return new SourceLocation(FS_explicitLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isNoreturnSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 573,
   FQN="clang::DeclSpec::isNoreturnSpecified", NM="_ZNK5clang8DeclSpec19isNoreturnSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19isNoreturnSpecifiedEv")
  //</editor-fold>
  public boolean isNoreturnSpecified() /*const*/ {
    return FS_noreturn_specified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getNoreturnSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 574,
   FQN="clang::DeclSpec::getNoreturnSpecLoc", NM="_ZNK5clang8DeclSpec18getNoreturnSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18getNoreturnSpecLocEv")
  //</editor-fold>
  public SourceLocation getNoreturnSpecLoc() /*const*/ {
    return new SourceLocation(FS_noreturnLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ClearFunctionSpecs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 576,
   FQN="clang::DeclSpec::ClearFunctionSpecs", NM="_ZN5clang8DeclSpec18ClearFunctionSpecsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec18ClearFunctionSpecsEv")
  //</editor-fold>
  public void ClearFunctionSpecs() {
    FS_inline_specified = false;
    FS_inlineLoc.$assignMove(new SourceLocation());
    FS_forceinline_specified = false;
    FS_forceinlineLoc.$assignMove(new SourceLocation());
    FS_virtual_specified = false;
    FS_virtualLoc.$assignMove(new SourceLocation());
    FS_explicit_specified = false;
    FS_explicitLoc.$assignMove(new SourceLocation());
    FS_noreturn_specified = false;
    FS_noreturnLoc.$assignMove(new SourceLocation());
  }

  
  /// \brief Return true if any type-specifier has been found.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::hasTypeSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 590,
   FQN="clang::DeclSpec::hasTypeSpecifier", NM="_ZNK5clang8DeclSpec16hasTypeSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16hasTypeSpecifierEv")
  //</editor-fold>
  public boolean hasTypeSpecifier() /*const*/ {
    return getTypeSpecType() != DeclSpec.TST_unspecified
       || getTypeSpecWidth() != DeclSpec.TSW_unspecified
       || getTypeSpecComplex() != DeclSpec.TSC.TSC_unspecified
       || getTypeSpecSign() != DeclSpec.TSS_unspecified;
  }

  
  /// \brief Return a bitmask of which flavors of specifiers this
  /// DeclSpec includes.
  
  /// getParsedSpecifiers - Return a bitmask of which flavors of specifiers this
  /// declaration specifier includes.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getParsedSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 363,
   FQN="clang::DeclSpec::getParsedSpecifiers", NM="_ZNK5clang8DeclSpec19getParsedSpecifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19getParsedSpecifiersEv")
  //</editor-fold>
  public /*uint*/int getParsedSpecifiers() /*const*/ {
    /*uint*/int Res = 0;
    if (StorageClassSpec != $int2uint_3bits(SCS.SCS_unspecified.getValue())
       || ThreadStorageClassSpec != $int2uint_2bits(TSCS_unspecified.getValue())) {
      Res |= ParsedSpecifiers.PQ_StorageClassSpecifier.getValue();
    }
    if (TypeQualifiers != $int2uint_5bits(TQ.TQ_unspecified.getValue())) {
      Res |= ParsedSpecifiers.PQ_TypeQualifier.getValue();
    }
    if (hasTypeSpecifier()) {
      Res |= ParsedSpecifiers.PQ_TypeSpecifier.getValue();
    }
    if (FS_inline_specified || FS_virtual_specified || FS_explicit_specified
       || FS_noreturn_specified || FS_forceinline_specified) {
      Res |= ParsedSpecifiers.PQ_FunctionSpecifier.getValue();
    }
    return Res;
  }

  
  /// isEmpty - Return true if this declaration specifier is completely empty:
  /// no tokens were parsed in the production of it.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 603,
   FQN="clang::DeclSpec::isEmpty", NM="_ZNK5clang8DeclSpec7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return getParsedSpecifiers() == DeclSpec.ParsedSpecifiers.PQ_None.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetRangeStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 607,
   FQN="clang::DeclSpec::SetRangeStart", NM="_ZN5clang8DeclSpec13SetRangeStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13SetRangeStartENS_14SourceLocationE")
  //</editor-fold>
  public void SetRangeStart(SourceLocation Loc) {
    Range.setBegin(/*NO_COPY*/Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 608,
   FQN="clang::DeclSpec::SetRangeEnd", NM="_ZN5clang8DeclSpec11SetRangeEndENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec11SetRangeEndENS_14SourceLocationE")
  //</editor-fold>
  public void SetRangeEnd(SourceLocation Loc) {
    Range.setEnd(/*NO_COPY*/Loc);
  }

  
  /// These methods set the specified attribute of the DeclSpec and
  /// return false if there was no error.  If an error occurs (for
  /// example, if we tried to set "auto" on a spec with "extern"
  /// already set), they return true and set PrevSpec and DiagID
  /// such that
  ///   Diag(Loc, DiagID) << PrevSpec;
  /// will yield a useful result.
  ///
  /// TODO: use a more general approach that still allows these
  /// diagnostics to be ignored when desired.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetStorageClassSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 502,
   FQN="clang::DeclSpec::SetStorageClassSpec", NM="_ZN5clang8DeclSpec19SetStorageClassSpecERNS_4SemaENS0_3SCSENS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec19SetStorageClassSpecERNS_4SemaENS0_3SCSENS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetStorageClassSpec(final Sema /*&*/ S, SCS SC, SourceLocation Loc, 
                     final char$ptr/*const char P &*/ PrevSpec, 
                     final uint$ref/*uint &*/ DiagID, 
                     final /*const*/ PrintingPolicy /*&*/ Policy) {
    // OpenCL v1.1 s6.8g: "The extern, static, auto and register storage-class
    // specifiers are not supported.
    // It seems sensible to prohibit private_extern too
    // The cl_clang_storage_class_specifiers extension enables support for
    // these storage-class specifiers.
    // OpenCL v1.2 s6.8 changes this to "The auto and register storage-class
    // specifiers are not supported."
    if (S.getLangOpts().OpenCL
       && !S.getOpenCLOptions().cl_clang_storage_class_specifiers) {
      switch (SC) {
       case SCS_extern:
       case SCS_private_extern:
       case SCS_static:
        if ($less_uint(S.getLangOpts().OpenCLVersion, 120)) {
          DiagID.$set(diag.err_opencl_unknown_type_specifier);
          PrevSpec.$assign(getSpecifierName_SCS(SC));
          return true;
        }
        break;
       case SCS_auto:
       case SCS_register:
        DiagID.$set(diag.err_opencl_unknown_type_specifier);
        PrevSpec.$assign(getSpecifierName_SCS(SC));
        return true;
       default:
        break;
      }
    }
    if (StorageClassSpec != $int2uint_3bits(SCS.SCS_unspecified.getValue())) {
      // Maybe this is an attempt to use C++11 'auto' outside of C++11 mode.
      boolean isInvalid = true;
      if (TypeSpecType == $int2uint_6bits(TST_unspecified.getValue()) && S.getLangOpts().CPlusPlus) {
        if (SC == SCS.SCS_auto) {
          return SetTypeSpecType(TST_auto, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
        }
        if (StorageClassSpec == $int2uint_3bits(SCS.SCS_auto.getValue())) {
          isInvalid = SetTypeSpecType(TST_auto, new SourceLocation(StorageClassSpecLoc), 
              PrevSpec, DiagID, Policy);
          assert (!isInvalid) : "auto SCS -> TST recovery failed";
        }
      }
      
      // Changing storage class is allowed only if the previous one
      // was the 'extern' that is part of a linkage specification and
      // the new storage class is 'typedef'.
      if (isInvalid
         && !(SCS_extern_in_linkage_spec
         && StorageClassSpec == $int2uint_3bits(SCS.SCS_extern.getValue())
         && SC == SCS.SCS_typedef)) {
        return BadSpecifier(SC, SCS.valueOf(StorageClassSpec), PrevSpec, DiagID);
      }
    }
    StorageClassSpec = $uint2uint_3bits(SC.getValue());
    StorageClassSpecLoc.$assign(Loc);
    assert ((/*uint*/int)SC.getValue() == StorageClassSpec) : "SCS constants overflow bitfield";
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetStorageClassSpecThread">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 563,
   FQN="clang::DeclSpec::SetStorageClassSpecThread", NM="_ZN5clang8DeclSpec25SetStorageClassSpecThreadENS_27ThreadStorageClassSpecifierENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec25SetStorageClassSpecThreadENS_27ThreadStorageClassSpecifierENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean SetStorageClassSpecThread(ThreadStorageClassSpecifier TSC, SourceLocation Loc, 
                           final char$ptr/*const char P &*/ PrevSpec, 
                           final uint$ref/*uint &*/ DiagID) {
    if (ThreadStorageClassSpec != $int2uint_2bits(TSCS_unspecified.getValue())) {
      return BadSpecifier(TSC, ThreadStorageClassSpecifier.valueOf(ThreadStorageClassSpec), PrevSpec, DiagID);
    }
    
    ThreadStorageClassSpec = $uint2uint_2bits(TSC.getValue());
    ThreadStorageClassSpecLoc.$assign(Loc);
    return false;
  }

  
  /// These methods set the specified attribute of the DeclSpec, but return true
  /// and ignore the request if invalid (e.g. "extern" then "auto" is
  /// specified).
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 577,
   FQN="clang::DeclSpec::SetTypeSpecWidth", NM="_ZN5clang8DeclSpec16SetTypeSpecWidthENS_18TypeSpecifierWidthENS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16SetTypeSpecWidthENS_18TypeSpecifierWidthENS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecWidth(TypeSpecifierWidth W, SourceLocation Loc, 
                  final char$ptr/*const char P &*/ PrevSpec, 
                  final uint$ref/*uint &*/ DiagID, 
                  final /*const*/ PrintingPolicy /*&*/ Policy) {
    // Overwrite TSWLoc only if TypeSpecWidth was unspecified, so that
    // for 'long long' we will keep the source location of the first 'long'.
    if (TypeSpecWidth == $int2uint_2bits(TSW_unspecified.getValue())) {
      TSWLoc.$assign(Loc);
    } else // Allow turning long -> long long.
    if (W != TSW_longlong || TypeSpecWidth != $int2uint_2bits(TSW_long.getValue())) {
      return BadSpecifier(W, TypeSpecifierWidth.valueOf(TypeSpecWidth), PrevSpec, DiagID);
    }
    TypeSpecWidth = $uint2uint_2bits(W.getValue());
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecComplex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 592,
   FQN="clang::DeclSpec::SetTypeSpecComplex", NM="_ZN5clang8DeclSpec18SetTypeSpecComplexENS0_3TSCENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec18SetTypeSpecComplexENS0_3TSCENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean SetTypeSpecComplex(TSC C, SourceLocation Loc, 
                    final char$ptr/*const char P &*/ PrevSpec, 
                    final uint$ref/*uint &*/ DiagID) {
    if (TypeSpecComplex != $int2uint_2bits(TSC.TSC_unspecified.getValue())) {
      return BadSpecifier(C, TSC.valueOf(TypeSpecComplex), PrevSpec, DiagID);
    }
    TypeSpecComplex = $uint2uint_2bits(C.getValue());
    TSCLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecSign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 602,
   FQN="clang::DeclSpec::SetTypeSpecSign", NM="_ZN5clang8DeclSpec15SetTypeSpecSignENS_17TypeSpecifierSignENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecSignENS_17TypeSpecifierSignENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean SetTypeSpecSign(TypeSpecifierSign S, SourceLocation Loc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID) {
    if (TypeSpecSign != $int2uint_2bits(TSS_unspecified.getValue())) {
      return BadSpecifier(S, TypeSpecifierSign.valueOf(TypeSpecSign), PrevSpec, DiagID);
    }
    TypeSpecSign = $uint2uint_2bits(S.getValue());
    TSSLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 691,
   FQN="clang::DeclSpec::SetTypeSpecType", NM="_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecType(TypeSpecifierType T, SourceLocation Loc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID, 
                 final /*const*/ PrintingPolicy /*&*/ Policy) {
    assert (!isDeclRep(T) && !isTypeRep(T) && !isExprRep(T)) : "rep required for these type-spec kinds!";
    if (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_decl_spec_combination);
      return true;
    }
    TSTLoc.$assign(Loc);
    TSTNameLoc.$assign(Loc);
    if (TypeAltiVecVector && (T == TST_bool) && !TypeAltiVecBool) {
      TypeAltiVecBool = true;
      return false;
    }
    TypeSpecType = $uint2uint_6bits(T.getValue());
    TypeSpecOwned = false;
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 612,
   FQN="clang::DeclSpec::SetTypeSpecType", NM="_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjNS_9OpaquePtrINS_8QualTypeEEERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjNS_9OpaquePtrINS_8QualTypeEEERKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecType(TypeSpecifierType T, SourceLocation Loc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID, 
                 OpaquePtr<QualType> Rep, 
                 final /*const*/ PrintingPolicy /*&*/ Policy) {
    return SetTypeSpecType(T, new SourceLocation(Loc), new SourceLocation(Loc), PrevSpec, DiagID, new OpaquePtr<QualType>(Rep), Policy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 661,
   FQN="clang::DeclSpec::SetTypeSpecType", NM="_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjPNS_4DeclEbRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjPNS_4DeclEbRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecType(TypeSpecifierType T, SourceLocation Loc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID, 
                 Decl /*P*/ Rep, boolean Owned, 
                 final /*const*/ PrintingPolicy /*&*/ Policy) {
    return SetTypeSpecType(T, new SourceLocation(Loc), new SourceLocation(Loc), PrevSpec, DiagID, Rep, Owned, Policy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 620,
   FQN="clang::DeclSpec::SetTypeSpecType", NM="_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationES2_RPKcRjNS_9OpaquePtrINS_8QualTypeEEERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationES2_RPKcRjNS_9OpaquePtrINS_8QualTypeEEERKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecType(TypeSpecifierType T, SourceLocation TagKwLoc, 
                 SourceLocation TagNameLoc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID, 
                 OpaquePtr<QualType> Rep, 
                 final /*const*/ PrintingPolicy /*&*/ Policy) {
    assert (isTypeRep(T)) : "T does not store a type";
    assert (Rep.$bool()) : "no type provided!";
    if (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_decl_spec_combination);
      return true;
    }
    TypeSpecType = $uint2uint_6bits(T.getValue());
    Unnamed_field21.TypeRep.$assign(/*NO_COPY*/Rep);
    TSTLoc.$assign(TagKwLoc);
    TSTNameLoc.$assign(TagNameLoc);
    TypeSpecOwned = false;
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 669,
   FQN="clang::DeclSpec::SetTypeSpecType", NM="_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationES2_RPKcRjPNS_4DeclEbRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationES2_RPKcRjPNS_4DeclEbRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecType(TypeSpecifierType T, SourceLocation TagKwLoc, 
                 SourceLocation TagNameLoc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID, 
                 Decl /*P*/ Rep, boolean Owned, 
                 final /*const*/ PrintingPolicy /*&*/ Policy) {
    assert (isDeclRep(T)) : "T does not store a decl";
    // Unlike the other cases, we don't assert that we actually get a decl.
    if (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_decl_spec_combination);
      return true;
    }
    TypeSpecType = $uint2uint_6bits(T.getValue());
    Unnamed_field21.DeclRep = Rep;
    TSTLoc.$assign(TagKwLoc);
    TSTNameLoc.$assign(TagNameLoc);
    TypeSpecOwned = Owned && Rep != null;
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 641,
   FQN="clang::DeclSpec::SetTypeSpecType", NM="_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjPNS_4ExprERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec15SetTypeSpecTypeENS_17TypeSpecifierTypeENS_14SourceLocationERPKcRjPNS_4ExprERKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeSpecType(TypeSpecifierType T, SourceLocation Loc, 
                 final char$ptr/*const char P &*/ PrevSpec, 
                 final uint$ref/*uint &*/ DiagID, 
                 Expr /*P*/ Rep, 
                 final /*const*/ PrintingPolicy /*&*/ Policy) {
    assert (isExprRep(T)) : "T does not store an expr";
    assert ((Rep != null)) : "no expression provided!";
    if (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_decl_spec_combination);
      return true;
    }
    TypeSpecType = $uint2uint_6bits(T.getValue());
    Unnamed_field21.ExprRep = Rep;
    TSTLoc.$assign(Loc);
    TSTNameLoc.$assign(Loc);
    TypeSpecOwned = false;
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeAltiVecVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 713,
   FQN="clang::DeclSpec::SetTypeAltiVecVector", NM="_ZN5clang8DeclSpec20SetTypeAltiVecVectorEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec20SetTypeAltiVecVectorEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeAltiVecVector(boolean isAltiVecVector, SourceLocation Loc, 
                      final char$ptr/*const char P &*/ PrevSpec, final uint$ref/*uint &*/ DiagID, 
                      final /*const*/ PrintingPolicy /*&*/ Policy) {
    if (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_vector_decl_spec_combination);
      return true;
    }
    TypeAltiVecVector = isAltiVecVector;
    AltiVecLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeAltiVecPixel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 742,
   FQN="clang::DeclSpec::SetTypeAltiVecPixel", NM="_ZN5clang8DeclSpec19SetTypeAltiVecPixelEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec19SetTypeAltiVecPixelEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeAltiVecPixel(boolean isAltiVecPixel, SourceLocation Loc, 
                     final char$ptr/*const char P &*/ PrevSpec, final uint$ref/*uint &*/ DiagID, 
                     final /*const*/ PrintingPolicy /*&*/ Policy) {
    if (!TypeAltiVecVector || TypeAltiVecPixel
       || (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue()))) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_pixel_decl_spec_combination);
      return true;
    }
    TypeAltiVecPixel = isAltiVecPixel;
    TSTLoc.$assign(Loc);
    TSTNameLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeAltiVecBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 757,
   FQN="clang::DeclSpec::SetTypeAltiVecBool", NM="_ZN5clang8DeclSpec18SetTypeAltiVecBoolEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec18SetTypeAltiVecBoolEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypeAltiVecBool(boolean isAltiVecBool, SourceLocation Loc, 
                    final char$ptr/*const char P &*/ PrevSpec, final uint$ref/*uint &*/ DiagID, 
                    final /*const*/ PrintingPolicy /*&*/ Policy) {
    if (!TypeAltiVecVector || TypeAltiVecBool
       || (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue()))) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_vector_bool_decl_spec);
      return true;
    }
    TypeAltiVecBool = isAltiVecBool;
    TSTLoc.$assign(Loc);
    TSTNameLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypePipe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 726,
   FQN="clang::DeclSpec::SetTypePipe", NM="_ZN5clang8DeclSpec11SetTypePipeEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec11SetTypePipeEbNS_14SourceLocationERPKcRjRKNS_14PrintingPolicyE")
  //</editor-fold>
  public boolean SetTypePipe(boolean isPipe, SourceLocation Loc, 
             final char$ptr/*const char P &*/ PrevSpec, final uint$ref/*uint &*/ DiagID, 
             final /*const*/ PrintingPolicy /*&*/ Policy) {
    if (TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) {
      PrevSpec.$assign(DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy));
      DiagID.$set(diag.err_invalid_decl_spec_combination);
      return true;
    }
    if (isPipe) {
      TypeSpecPipe = $uint2uint_1bit(TypeSpecifiersPipe.TSP_pipe.getValue());
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeSpecError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 772,
   FQN="clang::DeclSpec::SetTypeSpecError", NM="_ZN5clang8DeclSpec16SetTypeSpecErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16SetTypeSpecErrorEv")
  //</editor-fold>
  public boolean SetTypeSpecError() {
    TypeSpecType = $uint2uint_6bits(TST_error.getValue());
    TypeSpecOwned = false;
    TSTLoc.$assignMove(new SourceLocation());
    TSTNameLoc.$assignMove(new SourceLocation());
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::UpdateDeclRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 664,
   FQN="clang::DeclSpec::UpdateDeclRep", NM="_ZN5clang8DeclSpec13UpdateDeclRepEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13UpdateDeclRepEPNS_4DeclE")
  //</editor-fold>
  public void UpdateDeclRep(Decl /*P*/ Rep) {
    assert (isDeclRep(TypeSpecifierType.valueOf(TypeSpecType)));
    Unnamed_field21.DeclRep = Rep;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::UpdateTypeRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 668,
   FQN="clang::DeclSpec::UpdateTypeRep", NM="_ZN5clang8DeclSpec13UpdateTypeRepENS_9OpaquePtrINS_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13UpdateTypeRepENS_9OpaquePtrINS_8QualTypeEEE")
  //</editor-fold>
  public void UpdateTypeRep(OpaquePtr<QualType> Rep) {
    assert (isTypeRep(TypeSpecifierType.valueOf(TypeSpecType)));
    Unnamed_field21.TypeRep.$assign(/*NO_COPY*/Rep);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::UpdateExprRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 672,
   FQN="clang::DeclSpec::UpdateExprRep", NM="_ZN5clang8DeclSpec13UpdateExprRepEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13UpdateExprRepEPNS_4ExprE")
  //</editor-fold>
  public void UpdateExprRep(Expr /*P*/ Rep) {
    assert (isExprRep(TypeSpecifierType.valueOf(TypeSpecType)));
    Unnamed_field21.ExprRep = Rep;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetTypeQual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 780,
   FQN="clang::DeclSpec::SetTypeQual", NM="_ZN5clang8DeclSpec11SetTypeQualENS0_2TQENS_14SourceLocationERPKcRjRKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec11SetTypeQualENS0_2TQENS_14SourceLocationERPKcRjRKNS_11LangOptionsE")
  //</editor-fold>
  public boolean SetTypeQual(TQ T, SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
             final uint$ref/*uint &*/ DiagID, final /*const*/ LangOptions /*&*/ Lang) {
    // Duplicates are permitted in C99 onwards, but are not permitted in C89 or
    // C++.  However, since this is likely not what the user intended, we will
    // always warn.  We do not need to set the qualifier's location since we
    // already have it.
    if (((TypeQualifiers & $int2uint_5bits(T.getValue())) != 0)) {
      boolean IsExtension = true;
      if (Lang.C99) {
        IsExtension = false;
      }
      return BadSpecifier(T, T, PrevSpec, DiagID, IsExtension);
    }
    TypeQualifiers |= $int2uint_5bits(T.getValue());
    switch (T) {
     case TQ_unspecified:
      break;
     case TQ_const:
      TQ_constLoc.$assign(Loc);
      return false;
     case TQ_restrict:
      TQ_restrictLoc.$assign(Loc);
      return false;
     case TQ_volatile:
      TQ_volatileLoc.$assign(Loc);
      return false;
     case TQ_unaligned:
      TQ_unalignedLoc.$assign(Loc);
      return false;
     case TQ_atomic:
      TQ_atomicLoc.$assign(Loc);
      return false;
    }
    throw new llvm_unreachable("Unknown type qualifier!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setFunctionSpecInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 806,
   FQN="clang::DeclSpec::setFunctionSpecInline", NM="_ZN5clang8DeclSpec21setFunctionSpecInlineENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec21setFunctionSpecInlineENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean setFunctionSpecInline(SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
                       final uint$ref/*uint &*/ DiagID) {
    // 'inline inline' is ok.  However, since this is likely not what the user
    // intended, we will always warn, similar to duplicates of type qualifiers.
    if (FS_inline_specified) {
      DiagID.$set(diag.warn_duplicate_declspec);
      PrevSpec.$assign($inline);
      return true;
    }
    FS_inline_specified = true;
    FS_inlineLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setFunctionSpecForceInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 820,
   FQN="clang::DeclSpec::setFunctionSpecForceInline", NM="_ZN5clang8DeclSpec26setFunctionSpecForceInlineENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec26setFunctionSpecForceInlineENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean setFunctionSpecForceInline(SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
                            final uint$ref/*uint &*/ DiagID) {
    if (FS_forceinline_specified) {
      DiagID.$set(diag.warn_duplicate_declspec);
      PrevSpec.$assign($__forceinline);
      return true;
    }
    FS_forceinline_specified = true;
    FS_forceinlineLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setFunctionSpecVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 832,
   FQN="clang::DeclSpec::setFunctionSpecVirtual", NM="_ZN5clang8DeclSpec22setFunctionSpecVirtualENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec22setFunctionSpecVirtualENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean setFunctionSpecVirtual(SourceLocation Loc, 
                        final char$ptr/*const char P &*/ PrevSpec, 
                        final uint$ref/*uint &*/ DiagID) {
    // 'virtual virtual' is ok, but warn as this is likely not what the user
    // intended.
    if (FS_virtual_specified) {
      DiagID.$set(diag.warn_duplicate_declspec);
      PrevSpec.$assign($virtual);
      return true;
    }
    FS_virtual_specified = true;
    FS_virtualLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setFunctionSpecExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 847,
   FQN="clang::DeclSpec::setFunctionSpecExplicit", NM="_ZN5clang8DeclSpec23setFunctionSpecExplicitENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec23setFunctionSpecExplicitENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean setFunctionSpecExplicit(SourceLocation Loc, 
                         final char$ptr/*const char P &*/ PrevSpec, 
                         final uint$ref/*uint &*/ DiagID) {
    // 'explicit explicit' is ok, but warn as this is likely not what the user
    // intended.
    if (FS_explicit_specified) {
      DiagID.$set(diag.warn_duplicate_declspec);
      PrevSpec.$assign($explicit);
      return true;
    }
    FS_explicit_specified = true;
    FS_explicitLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setFunctionSpecNoreturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 862,
   FQN="clang::DeclSpec::setFunctionSpecNoreturn", NM="_ZN5clang8DeclSpec23setFunctionSpecNoreturnENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec23setFunctionSpecNoreturnENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean setFunctionSpecNoreturn(SourceLocation Loc, 
                         final char$ptr/*const char P &*/ PrevSpec, 
                         final uint$ref/*uint &*/ DiagID) {
    // '_Noreturn _Noreturn' is ok, but warn as this is likely not what the user
    // intended.
    if (FS_noreturn_specified) {
      DiagID.$set(diag.warn_duplicate_declspec);
      PrevSpec.$assign($_Noreturn);
      return true;
    }
    FS_noreturn_specified = true;
    FS_noreturnLoc.$assign(Loc);
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetFriendSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 877,
   FQN="clang::DeclSpec::SetFriendSpec", NM="_ZN5clang8DeclSpec13SetFriendSpecENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13SetFriendSpecENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean SetFriendSpec(SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
               final uint$ref/*uint &*/ DiagID) {
    if (Friend_specified) {
      PrevSpec.$assign($friend);
      // Keep the later location, so that we can later diagnose ill-formed
      // declarations like 'friend class X friend;'. Per [class.friend]p3,
      // 'friend' must be the first token in a friend declaration that is
      // not a function declaration.
      FriendLoc.$assign(Loc);
      DiagID.$set(diag.warn_duplicate_declspec);
      return true;
    }
    
    Friend_specified = true;
    FriendLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setModulePrivateSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 895,
   FQN="clang::DeclSpec::setModulePrivateSpec", NM="_ZN5clang8DeclSpec20setModulePrivateSpecENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec20setModulePrivateSpecENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean setModulePrivateSpec(SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
                      final uint$ref/*uint &*/ DiagID) {
    if (isModulePrivateSpecified()) {
      PrevSpec.$assign($__module_private__);
      DiagID.$set(diag.ext_duplicate_declspec);
      return true;
    }
    
    ModulePrivateLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetConstexprSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 907,
   FQN="clang::DeclSpec::SetConstexprSpec", NM="_ZN5clang8DeclSpec16SetConstexprSpecENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16SetConstexprSpecENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean SetConstexprSpec(SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
                  final uint$ref/*uint &*/ DiagID) {
    // 'constexpr constexpr' is ok, but warn as this is likely not what the user
    // intended.
    if (Constexpr_specified) {
      DiagID.$set(diag.warn_duplicate_declspec);
      PrevSpec.$assign($constexpr);
      return true;
    }
    Constexpr_specified = true;
    ConstexprLoc.$assign(Loc);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::SetConceptSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 921,
   FQN="clang::DeclSpec::SetConceptSpec", NM="_ZN5clang8DeclSpec14SetConceptSpecENS_14SourceLocationERPKcRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec14SetConceptSpecENS_14SourceLocationERPKcRj")
  //</editor-fold>
  public boolean SetConceptSpec(SourceLocation Loc, final char$ptr/*const char P &*/ PrevSpec, 
                final uint$ref/*uint &*/ DiagID) {
    if (Concept_specified) {
      DiagID.$set(diag.ext_duplicate_declspec);
      PrevSpec.$assign($concept);
      return true;
    }
    Concept_specified = true;
    ConceptLoc.$assign(Loc);
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isFriendSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 700,
   FQN="clang::DeclSpec::isFriendSpecified", NM="_ZNK5clang8DeclSpec17isFriendSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17isFriendSpecifiedEv")
  //</editor-fold>
  public boolean isFriendSpecified() /*const*/ {
    return Friend_specified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getFriendSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 701,
   FQN="clang::DeclSpec::getFriendSpecLoc", NM="_ZNK5clang8DeclSpec16getFriendSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16getFriendSpecLocEv")
  //</editor-fold>
  public SourceLocation getFriendSpecLoc() /*const*/ {
    return new SourceLocation(FriendLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isModulePrivateSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 703,
   FQN="clang::DeclSpec::isModulePrivateSpecified", NM="_ZNK5clang8DeclSpec24isModulePrivateSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec24isModulePrivateSpecifiedEv")
  //</editor-fold>
  public boolean isModulePrivateSpecified() /*const*/ {
    return ModulePrivateLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getModulePrivateSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 704,
   FQN="clang::DeclSpec::getModulePrivateSpecLoc", NM="_ZNK5clang8DeclSpec23getModulePrivateSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec23getModulePrivateSpecLocEv")
  //</editor-fold>
  public SourceLocation getModulePrivateSpecLoc() /*const*/ {
    return new SourceLocation(ModulePrivateLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isConstexprSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 706,
   FQN="clang::DeclSpec::isConstexprSpecified", NM="_ZNK5clang8DeclSpec20isConstexprSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec20isConstexprSpecifiedEv")
  //</editor-fold>
  public boolean isConstexprSpecified() /*const*/ {
    return Constexpr_specified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getConstexprSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 707,
   FQN="clang::DeclSpec::getConstexprSpecLoc", NM="_ZNK5clang8DeclSpec19getConstexprSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec19getConstexprSpecLocEv")
  //</editor-fold>
  public SourceLocation getConstexprSpecLoc() /*const*/ {
    return new SourceLocation(ConstexprLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isConceptSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 709,
   FQN="clang::DeclSpec::isConceptSpecified", NM="_ZNK5clang8DeclSpec18isConceptSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec18isConceptSpecifiedEv")
  //</editor-fold>
  public boolean isConceptSpecified() /*const*/ {
    return Concept_specified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getConceptSpecLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 710,
   FQN="clang::DeclSpec::getConceptSpecLoc", NM="_ZNK5clang8DeclSpec17getConceptSpecLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17getConceptSpecLocEv")
  //</editor-fold>
  public SourceLocation getConceptSpecLoc() /*const*/ {
    return new SourceLocation(ConceptLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ClearConstexprSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 712,
   FQN="clang::DeclSpec::ClearConstexprSpec", NM="_ZN5clang8DeclSpec18ClearConstexprSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec18ClearConstexprSpecEv")
  //</editor-fold>
  public void ClearConstexprSpec() {
    Constexpr_specified = false;
    ConstexprLoc.$assignMove(new SourceLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::ClearConceptSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 717,
   FQN="clang::DeclSpec::ClearConceptSpec", NM="_ZN5clang8DeclSpec16ClearConceptSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec16ClearConceptSpecEv")
  //</editor-fold>
  public void ClearConceptSpec() {
    Concept_specified = false;
    ConceptLoc.$assignMove(new SourceLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getAttributePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 722,
   FQN="clang::DeclSpec::getAttributePool", NM="_ZNK5clang8DeclSpec16getAttributePoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec16getAttributePoolEv")
  //</editor-fold>
  public AttributePool /*&*/ getAttributePool() /*const*/ {
    return Attrs.getPool();
  }

  
  /// \brief Concatenates two attribute lists.
  ///
  /// The GCC attribute syntax allows for the following:
  ///
  /// \code
  /// short __attribute__(( unused, deprecated ))
  /// int __attribute__(( may_alias, aligned(16) )) var;
  /// \endcode
  ///
  /// This declares 4 attributes using 2 lists. The following syntax is
  /// also allowed and equivalent to the previous declaration.
  ///
  /// \code
  /// short __attribute__((unused)) __attribute__((deprecated))
  /// int __attribute__((may_alias)) __attribute__((aligned(16))) var;
  /// \endcode
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::addAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 743,
   FQN="clang::DeclSpec::addAttributes", NM="_ZN5clang8DeclSpec13addAttributesEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13addAttributesEPNS_13AttributeListE")
  //</editor-fold>
  public void addAttributes(AttributeList /*P*/ AL) {
    Attrs.addAll(AL);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::hasAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 747,
   FQN="clang::DeclSpec::hasAttributes", NM="_ZNK5clang8DeclSpec13hasAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec13hasAttributesEv")
  //</editor-fold>
  public boolean hasAttributes() /*const*/ {
    return !Attrs.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 749,
   FQN="clang::DeclSpec::getAttributes", NM="_ZN5clang8DeclSpec13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec13getAttributesEv")
  //</editor-fold>
  public ParsedAttributes /*&*/ getAttributes() {
    return Attrs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 750,
   FQN="clang::DeclSpec::getAttributes", NM="_ZNK5clang8DeclSpec13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec13getAttributesEv")
  //</editor-fold>
  public /*const*/ ParsedAttributes /*&*/ getAttributes$Const() /*const*/ {
    return Attrs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::takeAttributesFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 752,
   FQN="clang::DeclSpec::takeAttributesFrom", NM="_ZN5clang8DeclSpec18takeAttributesFromERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec18takeAttributesFromERNS_16ParsedAttributesE")
  //</editor-fold>
  public void takeAttributesFrom(final ParsedAttributes /*&*/ attrs) {
    Attrs.takeAllFrom(attrs);
  }

  
  /// Finish - This does final analysis of the declspec, issuing diagnostics for
  /// things like "_Imaginary" (lacking an FP type).  After calling this method,
  /// DeclSpec is guaranteed self-consistent, even if an error occurred.
  
  /// Finish - This does final analysis of the declspec, rejecting things like
  /// "_Imaginary" (lacking an FP type).  This returns a diagnostic to issue or
  /// diag::NUM_DIAGNOSTICS if there is no error.  After calling this method,
  /// DeclSpec is guaranteed self-consistent, even if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::Finish">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 953,
   FQN="clang::DeclSpec::Finish", NM="_ZN5clang8DeclSpec6FinishERNS_4SemaERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec6FinishERNS_4SemaERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void Finish(final Sema /*&*/ S, final /*const*/ PrintingPolicy /*&*/ Policy) {
    // Before possibly changing their values, save specs as written.
    SaveWrittenBuiltinSpecs();
    
    // Check the type specifier components first.
    
    // If decltype(auto) is used, no other type specifiers are permitted.
    if (TypeSpecType == $int2uint_6bits(TST_decltype_auto.getValue())
       && (TypeSpecWidth != $int2uint_2bits(TSW_unspecified.getValue())
       || TypeSpecComplex != $int2uint_2bits(TSC.TSC_unspecified.getValue())
       || TypeSpecSign != $int2uint_2bits(TSS_unspecified.getValue())
       || TypeAltiVecVector || TypeAltiVecPixel || TypeAltiVecBool
       || (TypeQualifiers != 0))) {
      FixItHint Hints[/*9*/] = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*//*uint*/int NumLocs = 9;
        SourceLocation ExtraLocs[/*9*/] = new SourceLocation [/*9*/] {
          TSWLoc, TSCLoc, TSSLoc, AltiVecLoc, 
          TQ_constLoc, TQ_restrictLoc, TQ_volatileLoc, TQ_atomicLoc, TQ_unalignedLoc
        };
        Hints/*J*/= new$T(new FixItHint [9], ()->new FixItHint());
        SourceLocation FirstLoc/*J*/= new SourceLocation();
        for (/*uint*/int I = 0; I != NumLocs; ++I) {
          if (ExtraLocs[I].isValid()) {
            if (FirstLoc.isInvalid()
               || S.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/ExtraLocs[I], 
                /*NO_COPY*/FirstLoc)) {
              FirstLoc.$assign(ExtraLocs[I]);
            }
            Hints[I].$assignMove(FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ExtraLocs[I])));
          }
        }
        TypeSpecWidth = $uint2uint_2bits(TSW_unspecified.getValue());
        TypeSpecComplex = $uint2uint_2bits(TSC.TSC_unspecified.getValue());
        TypeSpecSign = $uint2uint_2bits(TSS_unspecified.getValue());
        TypeAltiVecVector = TypeAltiVecPixel = TypeAltiVecBool = false;
        TypeQualifiers = $uint2uint_5bits(0);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.err_decltype_auto_cannot_be_combined)), 
                                        Hints[0]), Hints[1]), Hints[2]), Hints[3]), 
                        Hints[4]), Hints[5]), Hints[6]), Hints[7]));
      } finally {
        if (Hints != null) { Destructors.$destroyArray(Hints); }
        $c$.$destroy();
      }
    }
    
    // Validate and finalize AltiVec vector declspec.
    if (TypeAltiVecVector) {
      if (TypeAltiVecBool) {
        // Sign specifiers are not allowed with vector bool. (PIM 2.1)
        if (TypeSpecSign != $int2uint_2bits(TSS_unspecified.getValue())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSSLoc), diag.err_invalid_vector_bool_decl_spec)), 
                getSpecifierName_TypeSpecifierSign(TypeSpecifierSign.valueOf(TypeSpecSign))));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Only char/int are valid with vector bool. (PIM 2.1)
        if (((TypeSpecType != $int2uint_6bits(TST_unspecified.getValue())) && (TypeSpecType != $int2uint_6bits(TST_char.getValue()))
           && (TypeSpecType != $int2uint_6bits(TST_int.getValue()))) || TypeAltiVecPixel) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.err_invalid_vector_bool_decl_spec)), 
                (TypeAltiVecPixel ? $__pixel : getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy))));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Only 'short' and 'long long' are valid with vector bool. (PIM 2.1)
        if ((TypeSpecWidth != $int2uint_2bits(TSW_unspecified.getValue())) && (TypeSpecWidth != $int2uint_2bits(TSW_short.getValue()))
           && (TypeSpecWidth != $int2uint_2bits(TSW_longlong.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSWLoc), diag.err_invalid_vector_bool_decl_spec)), 
                getSpecifierName_TypeSpecifierWidth(TypeSpecifierWidth.valueOf(TypeSpecWidth))));
          } finally {
            $c$.$destroy();
          }
        }
        
        // vector bool long long requires VSX support or ZVector.
        if ((TypeSpecWidth == $int2uint_2bits(TSW_longlong.getValue()))
           && (!S.Context.getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"vsx")))
           && (!S.Context.getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"power8-vector")))
           && !S.getLangOpts().ZVector) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.err_invalid_vector_long_long_decl_spec)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Elements of vector bool are interpreted as unsigned. (PIM 2.1)
        if ((TypeSpecType == $int2uint_6bits(TST_char.getValue())) || (TypeSpecType == $int2uint_6bits(TST_int.getValue()))
           || (TypeSpecWidth != $int2uint_2bits(TSW_unspecified.getValue()))) {
          TypeSpecSign = $uint2uint_2bits(TSS_unsigned.getValue());
        }
      } else if (TypeSpecType == $int2uint_6bits(TST_double.getValue())) {
        // vector long double and vector long long double are never allowed.
        // vector double is OK for Power7 and later, and ZVector.
        if (TypeSpecWidth == $int2uint_2bits(TSW_long.getValue()) || TypeSpecWidth == $int2uint_2bits(TSW_longlong.getValue())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(TSWLoc), diag.err_invalid_vector_long_double_decl_spec)));
          } finally {
            $c$.$destroy();
          }
        } else if (!S.Context.getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"vsx"))
           && !S.getLangOpts().ZVector) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.err_invalid_vector_double_decl_spec)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (TypeSpecType == $int2uint_6bits(TST_float.getValue())) {
        // vector float is unsupported for ZVector.
        if (S.getLangOpts().ZVector) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.err_invalid_vector_float_decl_spec)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (TypeSpecWidth == $int2uint_2bits(TSW_long.getValue())) {
        // vector long is unsupported for ZVector and deprecated for AltiVec.
        if (S.getLangOpts().ZVector) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(TSWLoc), diag.err_invalid_vector_long_decl_spec)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSWLoc), diag.warn_vector_long_decl_spec_combination)), 
                getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (TypeAltiVecPixel) {
        //TODO: perform validation
        TypeSpecType = $uint2uint_6bits(TST_int.getValue());
        TypeSpecSign = $uint2uint_2bits(TSS_unsigned.getValue());
        TypeSpecWidth = $uint2uint_2bits(TSW_short.getValue());
        TypeSpecOwned = false;
      }
    }
    
    // signed/unsigned are only valid with int/char/wchar_t.
    if (TypeSpecSign != $int2uint_2bits(TSS_unspecified.getValue())) {
      if (TypeSpecType == $int2uint_6bits(TST_unspecified.getValue())) {
        TypeSpecType = $uint2uint_6bits(TST_int.getValue()); // unsigned -> unsigned int, signed -> signed int.
      } else if (TypeSpecType != $int2uint_6bits(TST_int.getValue()) && TypeSpecType != $int2uint_6bits(TST_int128.getValue())
         && TypeSpecType != $int2uint_6bits(TST_char.getValue()) && TypeSpecType != $int2uint_6bits(TST_wchar.getValue())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSSLoc), diag.err_invalid_sign_spec)), 
              getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy)));
          // signed double -> double.
          TypeSpecSign = $uint2uint_2bits(TSS_unspecified.getValue());
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Validate the width of the type.
    switch (TypeSpecifierWidth.valueOf($uchar2uint(TypeSpecWidth))) {
     case TSW_unspecified:
      break;
     case TSW_short: // short int
     case TSW_longlong: // long long int
      if (TypeSpecType == $int2uint_6bits(TST_unspecified.getValue())) {
        TypeSpecType = $uint2uint_6bits(TST_int.getValue()); // short -> short int, long long -> long long int.
      } else if (TypeSpecType != $int2uint_6bits(TST_int.getValue())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSWLoc), diag.err_invalid_width_spec)), (int)TypeSpecWidth), 
              getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy)));
          TypeSpecType = $uint2uint_6bits(TST_int.getValue());
          TypeSpecOwned = false;
        } finally {
          $c$.$destroy();
        }
      }
      break;
     case TSW_long: // long double, long int
      if (TypeSpecType == $int2uint_6bits(TST_unspecified.getValue())) {
        TypeSpecType = $uint2uint_6bits(TST_int.getValue()); // long -> long int.
      } else if (TypeSpecType != $int2uint_6bits(TST_int.getValue()) && TypeSpecType != $int2uint_6bits(TST_double.getValue())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSWLoc), diag.err_invalid_width_spec)), (int)TypeSpecWidth), 
              getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy)));
          TypeSpecType = $uint2uint_6bits(TST_int.getValue());
          TypeSpecOwned = false;
        } finally {
          $c$.$destroy();
        }
      }
      break;
    }
    
    // TODO: if the implementation does not implement _Complex or _Imaginary,
    // disallow their use.  Need information about the backend.
    if (TypeSpecComplex != $int2uint_2bits(TSC.TSC_unspecified.getValue())) {
      if (TypeSpecType == $int2uint_6bits(TST_unspecified.getValue())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSCLoc), diag.ext_plain_complex)), 
              FixItHint.CreateInsertion(S.getLocForEndOfToken(getTypeSpecComplexLoc()), 
                  new StringRef(/*KEEP_STR*/" double"))));
          TypeSpecType = $uint2uint_6bits(TST_double.getValue()); // _Complex -> _Complex double.
        } finally {
          $c$.$destroy();
        }
      } else if (TypeSpecType == $int2uint_6bits(TST_int.getValue()) || TypeSpecType == $int2uint_6bits(TST_char.getValue())) {
        // Note that this intentionally doesn't include _Complex _Bool.
        if (!S.getLangOpts().CPlusPlus) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.ext_integer_complex)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (TypeSpecType != $int2uint_6bits(TST_float.getValue()) && TypeSpecType != $int2uint_6bits(TST_double.getValue())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSCLoc), diag.err_invalid_complex_spec)), 
              getSpecifierName(TypeSpecifierType.valueOf(TypeSpecType), Policy)));
          TypeSpecComplex = $uint2uint_2bits(TSC.TSC_unspecified.getValue());
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // C11 6.7.1/3, C++11 [dcl.stc]p1, GNU TLS: __thread, thread_local and
    // _Thread_local can only appear with the 'static' and 'extern' storage class
    // specifiers. We also allow __private_extern__ as an extension.
    if (ThreadStorageClassSpec != $int2uint_2bits(TSCS_unspecified.getValue())) {
      switch (SCS.valueOf(StorageClassSpec)) {
       case SCS_unspecified:
       case SCS_extern:
       case SCS_private_extern:
       case SCS_static:
        break;
       default:
        if (S.getSourceManager().isBeforeInTranslationUnit(getThreadStorageClassSpecLoc(), getStorageClassSpecLoc())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(getStorageClassSpecLoc(), 
                        diag.err_invalid_decl_spec_combination)), 
                    DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(getThreadStorageClassSpec())), 
                new SourceRange(getThreadStorageClassSpecLoc())));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(getThreadStorageClassSpecLoc(), 
                        diag.err_invalid_decl_spec_combination)), 
                    DeclSpec.getSpecifierName_SCS(getStorageClassSpec())), 
                new SourceRange(getStorageClassSpecLoc())));
          } finally {
            $c$.$destroy();
          }
        }
        // Discard the thread storage class specifier to recover.
        ThreadStorageClassSpec = $uint2uint_2bits(TSCS_unspecified.getValue());
        ThreadStorageClassSpecLoc.$assignMove(new SourceLocation());
      }
    }
    
    // If no type specifier was provided and we're parsing a language where
    // the type specifier is not optional, but we got 'auto' as a storage
    // class specifier, then assume this is an attempt to use C++0x's 'auto'
    // type specifier.
    if (S.getLangOpts().CPlusPlus
       && TypeSpecType == $int2uint_6bits(TST_unspecified.getValue()) && StorageClassSpec == $int2uint_3bits(SCS.SCS_auto.getValue())) {
      TypeSpecType = $uint2uint_6bits(TST_auto.getValue());
      StorageClassSpec = $uint2uint_3bits(SCS.SCS_unspecified.getValue());
      TSTLoc.$assign(TSTNameLoc.$assign(StorageClassSpecLoc));
      StorageClassSpecLoc.$assignMove(new SourceLocation());
    }
    // Diagnose if we've recovered from an ill-formed 'auto' storage class
    // specifier in a pre-C++11 dialect of C++.
    if (!S.getLangOpts().CPlusPlus11 && TypeSpecType == $int2uint_6bits(TST_auto.getValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.ext_auto_type_specifier)));
      } finally {
        $c$.$destroy();
      }
    }
    if (S.getLangOpts().CPlusPlus && !S.getLangOpts().CPlusPlus11
       && StorageClassSpec == $int2uint_3bits(SCS.SCS_auto.getValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(StorageClassSpecLoc), diag.warn_auto_storage_class)), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/StorageClassSpecLoc))));
      } finally {
        $c$.$destroy();
      }
    }
    if (TypeSpecType == $int2uint_6bits(TST_char16.getValue()) || TypeSpecType == $int2uint_6bits(TST_char32.getValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(TSTLoc), diag.warn_cxx98_compat_unicode_type)), 
            (TypeSpecType == $int2uint_6bits(TST_char16.getValue()) ? $char16_t : $char32_t)));
      } finally {
        $c$.$destroy();
      }
    }
    if (Constexpr_specified) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(ConstexprLoc), diag.warn_cxx98_compat_constexpr)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++ [class.friend]p6:
    //   No storage-class-specifier shall appear in the decl-specifier-seq
    //   of a friend declaration.
    if (isFriendSpecified()
       && ((getStorageClassSpec().getValue() != 0) || (getThreadStorageClassSpec().getValue() != 0))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SmallString/*32*/ SpecName/*J*/= new SmallString/*32*/(32);
        SourceLocation SCLoc/*J*/= new SourceLocation();
        FixItHint StorageHint/*J*/= new FixItHint(), ThreadHint/*J*/= new FixItHint();
        {
          
          DeclSpec.SCS SC = getStorageClassSpec();
          if ((SC.getValue() != 0)) {
            SpecName.$assign(/*STRINGREF_STR*/getSpecifierName_SCS(SC));
            SCLoc.$assignMove(getStorageClassSpecLoc());
            StorageHint.$assignMove(FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/SCLoc)));
          }
        }
        {
          
          ThreadStorageClassSpecifier TSC = getThreadStorageClassSpec();
          if ((TSC.getValue() != 0)) {
            if (!SpecName.empty()) {
              SpecName.$addassign(/*STRINGREF_STR*/" ");
            }
            SpecName.$addassign(/*STRINGREF_STR*/getSpecifierName_ThreadStorageClassSpecifier(TSC));
            SCLoc.$assignMove(getThreadStorageClassSpecLoc());
            ThreadHint.$assignMove(FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/SCLoc)));
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SCLoc), diag.err_friend_decl_spec)), 
                    SpecName), StorageHint), ThreadHint));
        
        ClearStorageClassSpecs();
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++11 [dcl.fct.spec]p5:
    //   The virtual specifier shall be used only in the initial
    //   declaration of a non-static class member function;
    // C++11 [dcl.fct.spec]p6:
    //   The explicit specifier shall be used only in the declaration of
    //   a constructor or conversion function within its class
    //   definition;
    if (isFriendSpecified() && (isVirtualSpecified() || isExplicitSpecified())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef Keyword/*J*/= new StringRef();
        SourceLocation SCLoc/*J*/= new SourceLocation();
        if (isVirtualSpecified()) {
          Keyword.$assignMove(/*STRINGREF_STR*/$virtual);
          SCLoc.$assignMove(getVirtualSpecLoc());
        } else {
          Keyword.$assignMove(/*STRINGREF_STR*/$explicit);
          SCLoc.$assignMove(getExplicitSpecLoc());
        }
        
        FixItHint Hint = FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/SCLoc));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SCLoc), diag.err_friend_decl_spec)), 
                Keyword), Hint));
        
        FS_virtual_specified = FS_explicit_specified = false;
        FS_virtualLoc.$assign(FS_explicitLoc.$assignMove(new SourceLocation()));
      } finally {
        $c$.$destroy();
      }
    }
    assert (!TypeSpecOwned || isDeclRep(TypeSpecifierType.valueOf(TypeSpecType)));

    // Okay, now we can infer the real type.

    // TODO: return "auto function" and other bad things based on the real type.

    // 'data definition has no type or storage class'?
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getWrittenBuiltinSpecs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 761,
   FQN="clang::DeclSpec::getWrittenBuiltinSpecs", NM="_ZNK5clang8DeclSpec22getWrittenBuiltinSpecsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec22getWrittenBuiltinSpecsEv")
  //</editor-fold>
  public /*const*/ WrittenBuiltinSpecs /*&*/ getWrittenBuiltinSpecs() /*const*/ {
    return writtenBS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::getObjCQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 765,
   FQN="clang::DeclSpec::getObjCQualifiers", NM="_ZNK5clang8DeclSpec17getObjCQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang8DeclSpec17getObjCQualifiersEv")
  //</editor-fold>
  public ObjCDeclSpec /*P*/ getObjCQualifiers() /*const*/ {
    return ObjCQualifiers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::setObjCQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 766,
   FQN="clang::DeclSpec::setObjCQualifiers", NM="_ZN5clang8DeclSpec17setObjCQualifiersEPNS_12ObjCDeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec17setObjCQualifiersEPNS_12ObjCDeclSpecE")
  //</editor-fold>
  public void setObjCQualifiers(ObjCDeclSpec /*P*/ quals) {
    ObjCQualifiers = quals;
  }

  
  /// \brief Checks if this DeclSpec can stand alone, without a Declarator.
  ///
  /// Only tag declspecs can stand alone.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::isMissingDeclaratorOk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 1232,
   FQN="clang::DeclSpec::isMissingDeclaratorOk", NM="_ZN5clang8DeclSpec21isMissingDeclaratorOkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang8DeclSpec21isMissingDeclaratorOkEv")
  //</editor-fold>
  public boolean isMissingDeclaratorOk() {
    TypeSpecifierType tst = getTypeSpecType();
    return isDeclRep(tst) && getRepAsDecl() != null
       && StorageClassSpec != $int2uint_3bits(DeclSpec.SCS.SCS_typedef.getValue());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclSpec::~DeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 228,
   FQN="clang::DeclSpec::~DeclSpec", NM="_ZN5clang8DeclSpecD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang8DeclSpecD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TypeScope.$destroy();
    Attrs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "StorageClassSpec=" + StorageClassSpec // NOI18N
              + ", ThreadStorageClassSpec=" + ThreadStorageClassSpec // NOI18N
              + ", SCS_extern_in_linkage_spec=" + SCS_extern_in_linkage_spec // NOI18N
              + ", TypeSpecWidth=" + TypeSpecWidth // NOI18N
              + ", TypeSpecComplex=" + TypeSpecComplex // NOI18N
              + ", TypeSpecSign=" + TypeSpecSign // NOI18N
              + ", TypeSpecType=" + TypeSpecType // NOI18N
              + ", TypeAltiVecVector=" + TypeAltiVecVector // NOI18N
              + ", TypeAltiVecPixel=" + TypeAltiVecPixel // NOI18N
              + ", TypeAltiVecBool=" + TypeAltiVecBool // NOI18N
              + ", TypeSpecOwned=" + TypeSpecOwned // NOI18N
              + ", TypeSpecPipe=" + TypeSpecPipe // NOI18N
              + ", TypeQualifiers=" + TypeQualifiers // NOI18N
              + ", FS_inline_specified=" + FS_inline_specified // NOI18N
              + ", FS_forceinline_specified=" + FS_forceinline_specified // NOI18N
              + ", FS_virtual_specified=" + FS_virtual_specified // NOI18N
              + ", FS_explicit_specified=" + FS_explicit_specified // NOI18N
              + ", FS_noreturn_specified=" + FS_noreturn_specified // NOI18N
              + ", Friend_specified=" + Friend_specified // NOI18N
              + ", Constexpr_specified=" + Constexpr_specified // NOI18N
              + ", Concept_specified=" + Concept_specified // NOI18N
              + ", Unnamed_field21=" + Unnamed_field21 // NOI18N
              + ", Attrs=" + Attrs // NOI18N
              + ", TypeScope=" + TypeScope // NOI18N
              + ", Range=" + Range // NOI18N
              + ", StorageClassSpecLoc=" + StorageClassSpecLoc // NOI18N
              + ", ThreadStorageClassSpecLoc=" + ThreadStorageClassSpecLoc // NOI18N
              + ", TSWLoc=" + TSWLoc // NOI18N
              + ", TSCLoc=" + TSCLoc // NOI18N
              + ", TSSLoc=" + TSSLoc // NOI18N
              + ", TSTLoc=" + TSTLoc // NOI18N
              + ", AltiVecLoc=" + AltiVecLoc // NOI18N
              + ", TSTNameLoc=" + TSTNameLoc // NOI18N
              + ", TypeofParensRange=" + TypeofParensRange // NOI18N
              + ", TQ_constLoc=" + TQ_constLoc // NOI18N
              + ", TQ_restrictLoc=" + TQ_restrictLoc // NOI18N
              + ", TQ_volatileLoc=" + TQ_volatileLoc // NOI18N
              + ", TQ_atomicLoc=" + TQ_atomicLoc // NOI18N
              + ", TQ_unalignedLoc=" + TQ_unalignedLoc // NOI18N
              + ", FS_inlineLoc=" + FS_inlineLoc // NOI18N
              + ", FS_virtualLoc=" + FS_virtualLoc // NOI18N
              + ", FS_explicitLoc=" + FS_explicitLoc // NOI18N
              + ", FS_noreturnLoc=" + FS_noreturnLoc // NOI18N
              + ", FS_forceinlineLoc=" + FS_forceinlineLoc // NOI18N
              + ", FriendLoc=" + FriendLoc // NOI18N
              + ", ModulePrivateLoc=" + ModulePrivateLoc // NOI18N
              + ", ConstexprLoc=" + ConstexprLoc // NOI18N
              + ", ConceptLoc=" + ConceptLoc // NOI18N
              + ", TQ_pipeLoc=" + TQ_pipeLoc // NOI18N
              + ", writtenBS=" + writtenBS // NOI18N
              + ", ObjCQualifiers=" + ObjCQualifiers; // NOI18N
  }
}
