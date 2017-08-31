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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.MicrosoftMangleStatics.*;


/// MicrosoftCXXNameMangler - Manage the mangling of a single name for the
/// Microsoft Visual C++ ABI.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 246,
 FQN="(anonymous namespace)::MicrosoftCXXNameMangler", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerE")
//</editor-fold>
public class MicrosoftCXXNameMangler implements Destructors.ClassWithDestructor {
  private final MicrosoftMangleContextImpl /*&*/ Context;
  private final raw_ostream /*&*/ Out;
  
  /// The "structor" is the top-level declaration being mangled, if
  /// that's not a template specialization; otherwise it's the pattern
  /// for that specialization.
  private /*const*/ NamedDecl /*P*/ Structor;
  private /*uint*/int StructorType;
  
  /*typedef llvm::SmallVector<std::string, 10> BackRefVec*/
//  public final class BackRefVec extends SmallVector<std.string>{ };
  private SmallVector<std.string> NameBackReferences;
  
  /*typedef llvm::DenseMap<const void *, unsigned int> ArgBackRefMap*/
//  public final class ArgBackRefMap extends DenseMapTypeUInt</*const*/Object/*void P*/>{ };
  private DenseMapTypeUInt</*const*/Object/*void P*/> TypeBackReferences;
  
  /*typedef std::set<int> PassObjectSizeArgsSet*/
//  public final class PassObjectSizeArgsSet extends std.setInt{ };
  private std.setInt PassObjectSizeArgs;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 265,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::getASTContext", NM="_ZNK12_GLOBAL__N_123MicrosoftCXXNameMangler13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZNK12_GLOBAL__N_123MicrosoftCXXNameMangler13getASTContextEv")
  //</editor-fold>
  private ASTContext /*&*/ getASTContext() /*const*/ {
    return Context.getASTContext();
  }

  
  // FIXME: If we add support for __ptr32/64 qualifiers, then we should push
  // this check into mangleQualifiers().
  private /*const*/boolean PointersAre64Bit;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::QualifierMangleMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 272,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::QualifierMangleMode", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler19QualifierMangleModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler19QualifierMangleModeE")
  //</editor-fold>
  public enum QualifierMangleMode implements Native.ComparableLower {
    QMM_Drop(0),
    QMM_Mangle(QMM_Drop.getValue() + 1),
    QMM_Escape(QMM_Mangle.getValue() + 1),
    QMM_Result(QMM_Escape.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static QualifierMangleMode valueOf(int val) {
      QualifierMangleMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final QualifierMangleMode[] VALUES;
      private static final QualifierMangleMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (QualifierMangleMode kind : QualifierMangleMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new QualifierMangleMode[min < 0 ? (1-min) : 0];
        VALUES = new QualifierMangleMode[max >= 0 ? (1+max) : 0];
        for (QualifierMangleMode kind : QualifierMangleMode.values()) {
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
    private QualifierMangleMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((QualifierMangleMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((QualifierMangleMode)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::MicrosoftCXXNameMangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 274,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::MicrosoftCXXNameMangler", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerC1ERNS_26MicrosoftMangleContextImplERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerC1ERNS_26MicrosoftMangleContextImplERN4llvm11raw_ostreamE")
  //</editor-fold>
  public MicrosoftCXXNameMangler(final MicrosoftMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_) {
    // : Context(C), Out(Out_), Structor(null), StructorType(-1), NameBackReferences(), TypeBackReferences(), PassObjectSizeArgs(), PointersAre64Bit(C.getASTContext().getTargetInfo().getPointerWidth(0) == 64) 
    //START JInit
    this./*&*/Context=/*&*/C;
    this./*&*/Out=/*&*/Out_;
    this.Structor = null;
    this.StructorType = -1;
    this.NameBackReferences = new SmallVector<std.string>(10, new std.string());
    this.TypeBackReferences = new DenseMapTypeUInt</*const*/Object/*void P*/>(DenseMapInfo$LikePtr.$Info(), 0);
    this.PassObjectSizeArgs = new std.setInt();
    this.PointersAre64Bit = C.getASTContext().getTargetInfo().getPointerWidth(0)
       == $int2ullong(64);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::MicrosoftCXXNameMangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 279,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::MicrosoftCXXNameMangler", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerC1ERNS_26MicrosoftMangleContextImplERN4llvm11raw_ostreamEPKN5clang18CXXConstructorDeclENS6_11CXXCtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerC1ERNS_26MicrosoftMangleContextImplERN4llvm11raw_ostreamEPKN5clang18CXXConstructorDeclENS6_11CXXCtorTypeE")
  //</editor-fold>
  public MicrosoftCXXNameMangler(JD$MicrosoftMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType _dparam, final MicrosoftMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_, 
      /*const*/ CXXConstructorDecl /*P*/ D, CXXCtorType Type) {
    // : Context(C), Out(Out_), Structor(getStructor(D)), StructorType(Type), NameBackReferences(), TypeBackReferences(), PassObjectSizeArgs(), PointersAre64Bit(C.getASTContext().getTargetInfo().getPointerWidth(0) == 64) 
    //START JInit
    this./*&*/Context=/*&*/C;
    this./*&*/Out=/*&*/Out_;
    this.Structor = getStructor(D);
    this.StructorType = Type.getValue();
    this.NameBackReferences = new SmallVector<std.string>(10, new std.string());
    this.TypeBackReferences = new DenseMapTypeUInt</*const*/Object/*void P*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
    this.PassObjectSizeArgs = new std.setInt();
    this.PointersAre64Bit = C.getASTContext().getTargetInfo().getPointerWidth(0)
       == $int2ullong(64);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::MicrosoftCXXNameMangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 285,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::MicrosoftCXXNameMangler", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerC1ERNS_26MicrosoftMangleContextImplERN4llvm11raw_ostreamEPKN5clang17CXXDestructorDeclENS6_11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerC1ERNS_26MicrosoftMangleContextImplERN4llvm11raw_ostreamEPKN5clang17CXXDestructorDeclENS6_11CXXDtorTypeE")
  //</editor-fold>
  public MicrosoftCXXNameMangler(JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType _dparam, final MicrosoftMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_, 
      /*const*/ CXXDestructorDecl /*P*/ D, CXXDtorType Type) {
    // : Context(C), Out(Out_), Structor(getStructor(D)), StructorType(Type), NameBackReferences(), TypeBackReferences(), PassObjectSizeArgs(), PointersAre64Bit(C.getASTContext().getTargetInfo().getPointerWidth(0) == 64) 
    //START JInit
    this./*&*/Context=/*&*/C;
    this./*&*/Out=/*&*/Out_;
    this.Structor = getStructor(D);
    this.StructorType = Type.getValue();
    this.NameBackReferences = new SmallVector<std.string>(10, new std.string());
    this.TypeBackReferences = new DenseMapTypeUInt</*const*/Object/*void P*/>(DenseMapInfo$LikePtr.$Info(), 0);
    this.PassObjectSizeArgs = new std.setInt();
    this.PointersAre64Bit = C.getASTContext().getTargetInfo().getPointerWidth(0)
       == $int2ullong(64);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::getStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 291,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::getStream", NM="_ZNK12_GLOBAL__N_123MicrosoftCXXNameMangler9getStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZNK12_GLOBAL__N_123MicrosoftCXXNameMangler9getStreamEv")
  //</editor-fold>
  public raw_ostream /*&*/ getStream() /*const*/ {
    return Out;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 423,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangle", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler6mangleEPKN5clang9NamedDeclEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler6mangleEPKN5clang9NamedDeclEN4llvm9StringRefE")
  //</editor-fold>
  public void mangle(/*const*/ NamedDecl /*P*/ D) {
    mangle(D, new StringRef(/*KEEP_STR*/"\001?"));
  }
  public void mangle(/*const*/ NamedDecl /*P*/ D, StringRef Prefix/*= "\001?"*/) {
    // MSVC doesn't mangle C++ names the same way it mangles extern "C" names.
    // Therefore it's really important that we don't decorate the
    // name with leading underscores or leading/trailing at signs. So, by
    // default, we emit an asm marker at the start so we get the name right.
    // Callers can override this with a custom prefix.
    
    // <mangled-name> ::= ? <name> <type-encoding>
    Out.$out(/*NO_COPY*/Prefix);
    mangleName(D);
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        mangleFunctionEncoding(FD, Context.shouldMangleDeclName(FD));
      } else {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          mangleVariableEncoding(VD);
        } else {
          throw new llvm_unreachable("Tried to mangle unexpected NamedDecl!");
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 653,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public void mangleName(/*const*/ NamedDecl /*P*/ ND) {
    // <name> ::= <unscoped-name> {[<named-scope>]+ | [<nested-name>]}? @
    
    // Always start with the unqualified name.
    mangleUnqualifiedName(ND);
    
    mangleNestedName(ND);
    
    // Terminate the whole name with an '@'.
    Out.$out_char($$AT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleFunctionEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 441,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleFunctionEncoding", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleFunctionEncodingEPKN5clang12FunctionDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleFunctionEncodingEPKN5clang12FunctionDeclEb")
  //</editor-fold>
  public void mangleFunctionEncoding(/*const*/ FunctionDecl /*P*/ FD, 
                        boolean ShouldMangle) {
    // <type-encoding> ::= <function-class> <function-type>
    
    // Since MSVC operates on the type as written and not the canonical type, it
    // actually matters which decl we have here.  MSVC appears to choose the
    // first, since it is most likely to be the declaration in a header file.
    FD = FD.getFirstDecl$Const();
    
    // We should never ever see a FunctionNoProtoType at this point.
    // We don't even know how to mangle their types anyway :).
    /*const*/ FunctionProtoType /*P*/ FT = FD.getType().$arrow().castAs(FunctionProtoType.class);
    
    // extern "C" functions can hold entities that must be mangled.
    // As it stands, these functions still need to get expressed in the full
    // external name.  They have their class and type omitted, replaced with '9'.
    if (ShouldMangle) {
      // We would like to mangle all extern "C" functions using this additional
      // component but this would break compatibility with MSVC's behavior.
      // Instead, do this when we know that compatibility isn't important (in
      // other words, when it is an overloaded extern "C" function).
      if (FD.isExternC() && FD.hasAttr(OverloadableAttr.class)) {
        Out.$out(/*KEEP_STR*/"$$J0");
      }
      
      mangleFunctionClass(FD);
      
      mangleFunctionType(FT, FD);
    } else {
      Out.$out_char($$9);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleVariableEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 473,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleVariableEncoding", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleVariableEncodingEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleVariableEncodingEPKN5clang7VarDeclE")
  //</editor-fold>
  public void mangleVariableEncoding(/*const*/ VarDecl /*P*/ VD) {
    // <type-encoding> ::= <storage-class> <variable-type>
    // <storage-class> ::= 0  # private static member
    //                 ::= 1  # protected static member
    //                 ::= 2  # public static member
    //                 ::= 3  # global
    //                 ::= 4  # static local
    
    // The first character in the encoding (after the name) is the storage class.
    if (VD.isStaticDataMember()) {
      // If it's a static member, it also encodes the access level.
      switch (VD.getAccess()) {
       default:
       case AS_private:
        Out.$out_char($$0);
        break;
       case AS_protected:
        Out.$out_char($$1);
        break;
       case AS_public:
        Out.$out_char($$2);
        break;
      }
    } else if (!VD.isStaticLocal()) {
      Out.$out_char($$3);
    } else {
      Out.$out_char($$4);
    }
    // Now mangle the type.
    // <variable-type> ::= <type> <cvr-qualifiers>
    //                 ::= <type> <pointee-cvr-qualifiers> # pointers, references
    // Pointers and references are odd. The type of 'int * const foo;' gets
    // mangled as 'QAHA' instead of 'PAHB', for example.
    SourceRange SR = VD.getSourceRange();
    QualType Ty = VD.getType();
    if (Ty.$arrow().isPointerType() || Ty.$arrow().isReferenceType()
       || Ty.$arrow().isMemberPointerType()) {
      mangleType(new QualType(Ty), new SourceRange(SR), QualifierMangleMode.QMM_Drop);
      manglePointerExtQualifiers(Ty.getDesugaredType(getASTContext()).getLocalQualifiers(), new QualType());
      {
        /*const*/ MemberPointerType /*P*/ MPT = Ty.$arrow().getAs(MemberPointerType.class);
        if ((MPT != null)) {
          mangleQualifiers(MPT.getPointeeType().getQualifiers(), true);
          // Member pointers are suffixed with a back reference to the member
          // pointer's class name.
          mangleName(MPT.__getClass().getAsCXXRecordDecl());
        } else {
          mangleQualifiers(Ty.$arrow().getPointeeType().getQualifiers(), false);
        }
      }
    } else {
      /*const*/ ArrayType /*P*/ AT = getASTContext().getAsArrayType(new QualType(Ty));
      if ((AT != null)) {
        // Global arrays are funny, too.
        mangleDecayedArrayType(AT);
        if (AT.getElementType().$arrow().isArrayType()) {
          Out.$out_char($$A);
        } else {
          mangleQualifiers(Ty.getQualifiers(), false);
        }
      } else {
        mangleType(new QualType(Ty), new SourceRange(SR), QualifierMangleMode.QMM_Drop);
        mangleQualifiers(Ty.getQualifiers(), false);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleMemberDataPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 527,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleMemberDataPointer", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23mangleMemberDataPointerEPKN5clang13CXXRecordDeclEPKNS1_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23mangleMemberDataPointerEPKN5clang13CXXRecordDeclEPKNS1_9ValueDeclE")
  //</editor-fold>
  public void mangleMemberDataPointer(/*const*/ CXXRecordDecl /*P*/ RD, 
                         /*const*/ ValueDecl /*P*/ VD) {
    // <member-data-pointer> ::= <integer-literal>
    //                       ::= $F <number> <number>
    //                       ::= $G <number> <number> <number>
    long/*int64_t*/ FieldOffset;
    long/*int64_t*/ VBTableOffset;
    MSInheritanceAttr.Spelling IM = RD.getMSInheritanceModel();
    if ((VD != null)) {
      FieldOffset = getASTContext().getFieldOffset(VD);
      assert ($rem_ullong_ulong(FieldOffset, getASTContext().getCharWidth()) == $int2ullong(0)) : "cannot take address of bitfield";
      FieldOffset /= getASTContext().getCharWidth();
      
      VBTableOffset = 0;
      if (IM == MSInheritanceAttr.Spelling.Keyword_virtual_inheritance) {
        FieldOffset -= getASTContext().getOffsetOfBaseWithVBPtr(RD).getQuantity();
      }
    } else {
      FieldOffset = RD.nullFieldOffsetIsZero() ? 0 : -1;
      
      VBTableOffset = -1;
    }
    
    /*char*/byte Code = $$TERM;
    switch (IM) {
     case Keyword_single_inheritance:
      Code = $$0;
      break;
     case Keyword_multiple_inheritance:
      Code = $$0;
      break;
     case Keyword_virtual_inheritance:
      Code = $$F;
      break;
     case Keyword_unspecified_inheritance:
      Code = $$G;
      break;
    }
    
    Out.$out_char($$DOLLAR).$out_char(Code);
    
    mangleNumber(FieldOffset);
    
    // The C++ standard doesn't allow base-to-derived member pointer conversions
    // in template parameter contexts, so the vbptr offset of data member pointers
    // is always zero.
    if (MSInheritanceAttr.hasVBPtrOffsetField(IM)) {
      mangleNumber(0);
    }
    if (MSInheritanceAttr.hasVBTableOffsetField(IM)) {
      mangleNumber(VBTableOffset);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 573,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleMemberFunctionPointer", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler27mangleMemberFunctionPointerEPKN5clang13CXXRecordDeclEPKNS1_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler27mangleMemberFunctionPointerEPKN5clang13CXXRecordDeclEPKNS1_13CXXMethodDeclE")
  //</editor-fold>
  public void mangleMemberFunctionPointer(/*const*/ CXXRecordDecl /*P*/ RD, 
                             /*const*/ CXXMethodDecl /*P*/ MD) {
    // <member-function-pointer> ::= $1? <name>
    //                           ::= $H? <name> <number>
    //                           ::= $I? <name> <number> <number>
    //                           ::= $J? <name> <number> <number> <number>
    MSInheritanceAttr.Spelling IM = RD.getMSInheritanceModel();
    
    /*char*/byte Code = $$TERM;
    switch (IM) {
     case Keyword_single_inheritance:
      Code = $$1;
      break;
     case Keyword_multiple_inheritance:
      Code = $$H;
      break;
     case Keyword_virtual_inheritance:
      Code = $$I;
      break;
     case Keyword_unspecified_inheritance:
      Code = $$J;
      break;
    }
    
    // If non-virtual, mangle the name.  If virtual, mangle as a virtual memptr
    // thunk.
    long/*uint64_t*/ NVOffset = $int2ulong(0);
    long/*uint64_t*/ VBTableOffset = $int2ulong(0);
    long/*uint64_t*/ VBPtrOffset = $int2ulong(0);
    if ((MD != null)) {
      Out.$out_char($$DOLLAR).$out_char(Code).$out_char($$QMARK);
      if (MD.isVirtual()) {
        MicrosoftVTableContext /*P*/ VTContext = cast_MicrosoftVTableContext(getASTContext().getVTableContext());
        final /*const*/ MicrosoftVTableContext.MethodVFTableLocation /*&*/ ML = VTContext.getMethodVFTableLocation(new GlobalDecl(MD));
        mangleVirtualMemPtrThunk(MD, ML);
        NVOffset = ML.VFPtrOffset.getQuantity();
        VBTableOffset = ML.VBTableIndex * $int2ullong(4);
        if ((ML.VBase != null)) {
          final /*const*/ ASTRecordLayout /*&*/ Layout = getASTContext().getASTRecordLayout(RD);
          VBPtrOffset = Layout.getVBPtrOffset().getQuantity();
        }
      } else {
        mangleName(MD);
        mangleFunctionEncoding(MD, /*ShouldMangle=*/ true);
      }
      if (VBTableOffset == $int2ullong(0)
         && IM == MSInheritanceAttr.Spelling.Keyword_virtual_inheritance) {
        NVOffset -= getASTContext().getOffsetOfBaseWithVBPtr(RD).getQuantity();
      }
    } else {
      // Null single inheritance member functions are encoded as a simple nullptr.
      if (IM == MSInheritanceAttr.Spelling.Keyword_single_inheritance) {
        Out.$out(/*KEEP_STR*/"$0A@");
        return;
      }
      if (IM == MSInheritanceAttr.Spelling.Keyword_unspecified_inheritance) {
        VBTableOffset = $int2ulong(-1);
      }
      Out.$out_char($$DOLLAR).$out_char(Code);
    }
    if (MSInheritanceAttr.hasNVOffsetField(/*IsMemberFunction=*/ true, IM)) {
      mangleNumber($uint2long(((/*static_cast*//*uint32_t*/int)($ulong2uint(NVOffset)))));
    }
    if (MSInheritanceAttr.hasVBPtrOffsetField(IM)) {
      mangleNumber(VBPtrOffset);
    }
    if (MSInheritanceAttr.hasVBTableOffsetField(IM)) {
      mangleNumber(VBTableOffset);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleVirtualMemPtrThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 637,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleVirtualMemPtrThunk", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler24mangleVirtualMemPtrThunkEPKN5clang13CXXMethodDeclERKNS1_22MicrosoftVTableContext21MethodVFTableLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler24mangleVirtualMemPtrThunkEPKN5clang13CXXMethodDeclERKNS1_22MicrosoftVTableContext21MethodVFTableLocationE")
  //</editor-fold>
  public void mangleVirtualMemPtrThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
                          final /*const*/ MicrosoftVTableContext.MethodVFTableLocation /*&*/ ML) {
    // Get the vftable offset.
    CharUnits PointerWidth = getASTContext().toCharUnitsFromBits(getASTContext().getTargetInfo().getPointerWidth(0));
    long/*uint64_t*/ OffsetInVFTable = ML.Index * PointerWidth.getQuantity();
    
    Out.$out(/*KEEP_STR*/"?_9");
    mangleName(MD.getParent$Const());
    Out.$out(/*KEEP_STR*/"$B");
    mangleNumber(OffsetInVFTable);
    Out.$out_char($$A);
    mangleCallingConvention(MD.getType().$arrow().getAs(FunctionProtoType.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 665,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleNumber", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler12mangleNumberEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler12mangleNumberEx")
  //</editor-fold>
  public void mangleNumber(long/*int64_t*/ Number) {
    // <non-negative integer> ::= A@              # when Number == 0
    //                        ::= <decimal digit> # when 1 <= Number <= 10
    //                        ::= <hex digit>+ @  # when Number >= 10
    //
    // <number>               ::= [?] <non-negative integer>
    long/*uint64_t*/ Value = ((/*static_cast*/long/*uint64_t*/)(Number));
    if (Number < 0) {
      Value = -Value;
      Out.$out_char($$QMARK);
    }
    if (Value == $int2ullong(0)) {
      Out.$out(/*KEEP_STR*/"A@");
    } else if ($greatereq_ulong_ullong(Value, $int2ullong(1)) && $lesseq_ulong_ullong(Value, $int2ullong(10))) {
      Out.$out_ullong((Value - $int2ullong(1)));
    } else {
      // Numbers that are not encoded as decimal digits are represented as nibbles
      // in the range of ASCII characters 'A' to 'P'.
      // The number 0x123450 would be encoded as 'BCDEFA'
      /*char*/byte EncodedNumberBuffer[/*16*/] = new$char(16);
      MutableArrayRefChar BufferRef/*J*/= new MutableArrayRefChar(EncodedNumberBuffer);
      std.reverse_iteratorChar I = BufferRef.rbegin();
      for (; Value != $int2ullong(0); Value >>>= 4)  {
        I.$postInc(0).star$ref().$set($ullong2char($char2ullong($$A) + (Value & $int2ullong(0xf))));
      }
      Out.write(I.base(), $sub_reverse_iterator$C(I, BufferRef.rbegin()));
      Out.$out_char($$AT);
    }
  }

  
  // <type>        ::= <union-type> | <struct-type> | <class-type> | <enum-type>
  // <union-type>  ::= T <name>
  // <struct-type> ::= U <name>
  // <class-type>  ::= V <name>
  // <enum-type>   ::= W4 <name>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTagTypeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2045,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTagTypeKind", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler17mangleTagTypeKindEN5clang11TagTypeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler17mangleTagTypeKindEN5clang11TagTypeKindE")
  //</editor-fold>
  public void mangleTagTypeKind(TagTypeKind TTK) {
    switch (TTK) {
     case TTK_Union:
      Out.$out_char($$T);
      break;
     case TTK_Struct:
     case TTK_Interface:
      Out.$out_char($$U);
      break;
     case TTK_Class:
      Out.$out_char($$V);
      break;
     case TTK_Enum:
      Out.$out(/*KEEP_STR*/"W4");
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleArtificalTagType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2074,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleArtificalTagType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleArtificalTagTypeEN5clang11TagTypeKindEN4llvm9StringRefENS3_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleArtificalTagTypeEN5clang11TagTypeKindEN4llvm9StringRefENS3_8ArrayRefIS4_EE")
  //</editor-fold>
  public void mangleArtificalTagType(TagTypeKind TK, StringRef UnqualifiedName) {
    mangleArtificalTagType(TK, UnqualifiedName, new ArrayRef<StringRef>(None, false));
  }
  public void mangleArtificalTagType(TagTypeKind TK, StringRef UnqualifiedName, ArrayRef<StringRef> NestedNames/*= None*/) {
    // <name> ::= <unscoped-name> {[<named-scope>]+ | [<nested-name>]}? @
    mangleTagTypeKind(TK);
    
    // Always start with the unqualified name.
    mangleSourceName(new StringRef(UnqualifiedName));
    
    for (reverse_iterator</*const*/ StringRef> I = NestedNames.rbegin(), E = NestedNames.rend(); $noteq_reverse_iterator$C(I, E); I.$preInc())  {
      mangleSourceName(new StringRef(I.$star()));
    }
    
    // Terminate the whole name with an '@'.
    Out.$out_char($$AT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1547,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEN5clang8QualTypeENS1_11SourceRangeENS0_19QualifierMangleModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEN5clang8QualTypeENS1_11SourceRangeENS0_19QualifierMangleModeE")
  //</editor-fold>
  public void mangleType(QualType T, SourceRange Range) {
    mangleType(T, Range, 
            QualifierMangleMode.QMM_Mangle);
  }
  public void mangleType(QualType T, SourceRange Range, 
            QualifierMangleMode QMM/*= QMM_Mangle*/) {
    // Don't use the canonical types.  MSVC includes things like 'const' on
    // pointer arguments to function pointers that canonicalization strips away.
    T.$assignMove(T.getDesugaredType(getASTContext()));
    Qualifiers Quals = T.getLocalQualifiers();
    {
      /*const*/ ArrayType /*P*/ AT = getASTContext().getAsArrayType(new QualType(T));
      if ((AT != null)) {
        // If there were any Quals, getAsArrayType() pushed them onto the array
        // element type.
        if (QMM == QualifierMangleMode.QMM_Mangle) {
          Out.$out_char($$A);
        } else if (QMM == QualifierMangleMode.QMM_Escape || QMM == QualifierMangleMode.QMM_Result) {
          Out.$out(/*KEEP_STR*/"$$B");
        }
        mangleArrayType(AT);
        return;
      }
    }
    
    boolean IsPointer = T.$arrow().isAnyPointerType() || T.$arrow().isMemberPointerType()
       || T.$arrow().isReferenceType() || T.$arrow().isBlockPointerType();
    switch (QMM) {
     case QMM_Drop:
      break;
     case QMM_Mangle:
      {
        /*const*/ FunctionType /*P*/ FT = dyn_cast_FunctionType(T);
        if ((FT != null)) {
          Out.$out_char($$6);
          mangleFunctionType(FT);
          return;
        }
      }
      mangleQualifiers(new Qualifiers(Quals), false);
      break;
     case QMM_Escape:
      if (!IsPointer && Quals.$bool()) {
        Out.$out(/*KEEP_STR*/"$$C");
        mangleQualifiers(new Qualifiers(Quals), false);
      }
      break;
     case QMM_Result:
      // Presence of __unaligned qualifier shouldn't affect mangling here.
      Quals.removeUnaligned();
      if ((!IsPointer && Quals.$bool()) || isa_TagType(T)) {
        Out.$out_char($$QMARK);
        mangleQualifiers(new Qualifiers(Quals), false);
      }
      break;
    }
    
    /*const*/ Type /*P*/ ty = T.getTypePtr();
    switch (ty.getTypeClass()) {
     case Builtin:
      mangleType(cast_BuiltinType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Complex:
      mangleType(cast_ComplexType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Pointer:
      mangleType(cast_PointerType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case BlockPointer:
      mangleType(cast_BlockPointerType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case LValueReference:
      mangleType(cast_LValueReferenceType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case RValueReference:
      mangleType(cast_RValueReferenceType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case MemberPointer:
      mangleType(cast_MemberPointerType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case ConstantArray:
      mangleType(cast_ConstantArrayType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case IncompleteArray:
      mangleType(cast_IncompleteArrayType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case VariableArray:
      mangleType(cast_VariableArrayType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case DependentSizedArray:
      mangleType(cast_DependentSizedArrayType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case DependentSizedExtVector:
      mangleType(cast_DependentSizedExtVectorType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Vector:
      mangleType(cast_VectorType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case ExtVector:
      mangleType(cast_ExtVectorType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case FunctionProto:
      mangleType(cast_FunctionProtoType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case FunctionNoProto:
      mangleType(cast_FunctionNoProtoType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case UnresolvedUsing:
      mangleType(cast_UnresolvedUsingType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Paren:
      throw new llvm_unreachable("can't mangle non-canonical type ParenType");
//      return;
     case Typedef:
      throw new llvm_unreachable("can't mangle non-canonical type TypedefType");
//      return;
     case Adjusted:
      throw new llvm_unreachable("can't mangle non-canonical type AdjustedType");
//      return;
     case Decayed:
      throw new llvm_unreachable("can't mangle non-canonical type DecayedType");
//      return;
     case TypeOfExpr:
      mangleType(cast_TypeOfExprType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case TypeOf:
      mangleType(cast_TypeOfType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Decltype:
      mangleType(cast_DecltypeType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case UnaryTransform:
      mangleType(cast_UnaryTransformType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Record:
      mangleType(cast_RecordType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Enum:
      mangleType(cast_EnumType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Elaborated:
      throw new llvm_unreachable("can't mangle non-canonical type ElaboratedType");
//      return;
     case Attributed:
      throw new llvm_unreachable("can't mangle non-canonical type AttributedType");
//      return;
     case TemplateTypeParm:
      mangleType(cast_TemplateTypeParmType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case SubstTemplateTypeParm:
      throw new llvm_unreachable("can't mangle non-canonical type SubstTemplateTypeParmType");
//      return;
     case SubstTemplateTypeParmPack:
      mangleType(cast_SubstTemplateTypeParmPackType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case TemplateSpecialization:
      mangleType(cast_TemplateSpecializationType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Auto:
      mangleType(cast_AutoType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case InjectedClassName:
      mangleType(cast_InjectedClassNameType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case DependentName:
      mangleType(cast_DependentNameType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case DependentTemplateSpecialization:
      mangleType(cast_DependentTemplateSpecializationType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case PackExpansion:
      mangleType(cast_PackExpansionType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case ObjCObject:
      mangleType(cast_ObjCObjectType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case ObjCInterface:
      mangleType(cast_ObjCInterfaceType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case ObjCObjectPointer:
      mangleType(cast_ObjCObjectPointerType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Pipe:
      mangleType(cast_PipeType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
     case Atomic:
      mangleType(cast_AtomicType(ty), new Qualifiers(Quals), new SourceRange(Range));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1793,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleFunctionType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleFunctionTypeEPKN5clang12FunctionTypeEPKNS1_12FunctionDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleFunctionTypeEPKN5clang12FunctionTypeEPKNS1_12FunctionDeclEb")
  //</editor-fold>
  public void mangleFunctionType(/*const*/ FunctionType /*P*/ T) {
    mangleFunctionType(T, 
                    (/*const*/ FunctionDecl /*P*/ )null, 
                    false);
  }
  public void mangleFunctionType(/*const*/ FunctionType /*P*/ T, 
                    /*const*/ FunctionDecl /*P*/ D/*= null*/) {
    mangleFunctionType(T, 
                    D, 
                    false);
  }
  public void mangleFunctionType(/*const*/ FunctionType /*P*/ T, 
                    /*const*/ FunctionDecl /*P*/ D/*= null*/, 
                    boolean ForceThisQuals/*= false*/) {
    // <function-type> ::= <this-cvr-qualifiers> <calling-convention>
    //                     <return-type> <argument-list> <throw-spec>
    /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(T);
    
    SourceRange Range/*J*/= new SourceRange();
    if ((D != null)) {
      Range.$assignMove(D.getSourceRange());
    }
    
    boolean IsInLambda = false;
    boolean IsStructor = false;
    boolean HasThisQuals = ForceThisQuals;
    boolean IsCtorClosure = false;
    CallingConv CC = T.getCallConv();
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(D);
      if ((MD != null)) {
        if (MD.getParent$Const().isLambda()) {
          IsInLambda = true;
        }
        if (MD.isInstance()) {
          HasThisQuals = true;
        }
        if (isa_CXXDestructorDecl(MD)) {
          IsStructor = true;
        } else if (isa_CXXConstructorDecl(MD)) {
          IsStructor = true;
          IsCtorClosure = (StructorType == CXXCtorType.Ctor_CopyingClosure.getValue()
             || StructorType == CXXCtorType.Ctor_DefaultClosure.getValue())
             && getStructor(MD) == Structor;
          if (IsCtorClosure) {
            CC = getASTContext().getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true);
          }
        }
      }
    }
    
    // If this is a C++ instance method, mangle the CVR qualifiers for the
    // this pointer.
    if (HasThisQuals) {
      Qualifiers Quals = Qualifiers.fromCVRUMask(Proto.getTypeQuals());
      manglePointerExtQualifiers(new Qualifiers(Quals), /*PointeeType=*/ new QualType());
      mangleRefQualifier(Proto.getRefQualifier());
      mangleQualifiers(new Qualifiers(Quals), /*IsMember=*/ false);
    }
    
    mangleCallingConvention(CC);
    
    // <return-type> ::= <type>
    //               ::= @ # structors (they have no declared return type)
    if (IsStructor) {
      if (isa_CXXDestructorDecl(D) && D == Structor
         && StructorType == CXXDtorType.Dtor_Deleting.getValue()) {
        // The scalar deleting destructor takes an extra int argument.
        // However, the FunctionType generated has 0 arguments.
        // FIXME: This is a temporary hack.
        // Maybe should fix the FunctionType creation instead?
        Out.$out((PointersAre64Bit ? $("PEAXI@Z") : $("PAXI@Z")));
        return;
      }
      if (IsCtorClosure) {
        // Default constructor closure and copy constructor closure both return
        // void.
        Out.$out_char($$X);
        if (StructorType == CXXCtorType.Ctor_DefaultClosure.getValue()) {
          // Default constructor closure always has no arguments.
          Out.$out_char($$X);
        } else if (StructorType == CXXCtorType.Ctor_CopyingClosure.getValue()) {
          // Copy constructor closure always takes an unqualified reference.
          mangleArgumentType(getASTContext().getLValueReferenceType(Proto.getParamType(0).$arrow().getAs(LValueReferenceType.class).
                      getPointeeType(), 
                  /*SpelledAsLValue=*/ true), 
              new SourceRange(Range));
          Out.$out_char($$AT);
        } else {
          throw new llvm_unreachable("unexpected constructor closure!");
        }
        Out.$out_char($$Z);
        return;
      }
      Out.$out_char($$AT);
    } else {
      QualType ResultType = T.getReturnType();
      {
        /*const*/ AutoType /*P*/ AT = dyn_cast_or_null_AutoType(ResultType.$arrow().getContainedAutoType());
        if ((AT != null)) {
          Out.$out_char($$QMARK);
          mangleQualifiers(ResultType.getLocalQualifiers(), /*IsMember=*/ false);
          Out.$out_char($$QMARK);
          assert (AT.getKeyword() != AutoTypeKeyword.GNUAutoType) : "shouldn't need to mangle __auto_type!";
          mangleSourceName(new StringRef(AT.isDecltypeAuto() ? $("<decltype-auto>") : $("<auto>")));
          Out.$out_char($$AT);
        } else if (IsInLambda) {
          Out.$out_char($$AT);
        } else {
          if (ResultType.$arrow().isVoidType()) {
            ResultType.$assignMove(ResultType.getUnqualifiedType());
          }
          mangleType(new QualType(ResultType), new SourceRange(Range), QualifierMangleMode.QMM_Result);
        }
      }
    }
    
    // <argument-list> ::= X # void
    //                 ::= <type>+ @
    //                 ::= <type>* Z # varargs
    if (!(Proto != null)) {
      // Function types without prototypes can arise when mangling a function type
      // within an overloadable function in C. We mangle these as the absence of
      // any parameter types (not even an empty parameter list).
      Out.$out_char($$AT);
    } else if (Proto.getNumParams() == 0 && !Proto.isVariadic()) {
      Out.$out_char($$X);
    } else {
      // Happens for function pointer type arguments for example.
      for (/*uint*/int I = 0, E = Proto.getNumParams(); I != E; ++I) {
        mangleArgumentType(Proto.getParamType(I), new SourceRange(Range));
        // Mangle each pass_object_size parameter as if it's a paramater of enum
        // type passed directly after the parameter with the pass_object_size
        // attribute. The aforementioned enum's name is __pass_object_size, and we
        // pretend it resides in a top-level namespace called __clang.
        //
        // FIXME: Is there a defined extension notation for the MS ABI, or is it
        // necessary to just cross our fingers and hope this type+namespace
        // combination doesn't conflict with anything?
        if ((D != null)) {
          {
            /*const*/ PassObjectSizeAttr /*P*/ P = D.getParamDecl$Const(I).getAttr(PassObjectSizeAttr.class);
            if ((P != null)) {
              manglePassObjectSizeArg(P);
            }
          }
        }
      }
      // <builtin-type>      ::= Z  # ellipsis
      if (Proto.isVariadic()) {
        Out.$out_char($$Z);
      } else {
        Out.$out_char($$AT);
      }
    }
    
    mangleThrowSpecification(Proto);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleNestedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 898,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleNestedName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleNestedNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleNestedNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public void mangleNestedName(/*const*/ NamedDecl /*P*/ ND) {
    // <postfix> ::= <unqualified-name> [<postfix>]
    //           ::= <substitution> [<postfix>]
    /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(ND);
    while (!DC.isTranslationUnit()) {
      if (isa_TagDecl(ND) || isa_VarDecl(ND)) {
        uint$ref Disc = create_uint$ref();
        if (Context.getNextDiscriminator(ND, Disc)) {
          Out.$out_char($$QMARK);
          mangleNumber($uint2long(Disc.$deref()));
          Out.$out_char($$QMARK);
        }
      }
      {
        
        /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(DC);
        if ((BD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
            /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                /*KEEP_STR*/"cannot mangle a local inside this block yet");
            $c$.clean($c$.track(Diags.Report(BD.getLocation(), DiagID)));
            
            // FIXME: This is completely, utterly, wrong; see ItaniumMangle
            // for how this should be done.
            Out.$out(/*KEEP_STR*/"__block_invoke").$out_uint(Context.getBlockId(BD, false));
            Out.$out_char($$AT);
            continue;
          } finally {
            $c$.$destroy();
          }
        } else {
          /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(DC);
          if ((Method != null)) {
            mangleObjCMethodName(Method);
          } else if (isa_NamedDecl(DC)) {
            ND = cast_NamedDecl(DC);
            {
              /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
              if ((FD != null)) {
                mangle(FD, new StringRef(/*KEEP_STR*/$QMARK));
                break;
              } else {
                mangleUnqualifiedName(ND);
              }
            }
          }
        }
      }
      DC = DC.getParent$Const();
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleUnqualifiedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 315,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleUnqualifiedName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  private void mangleUnqualifiedName(/*const*/ NamedDecl /*P*/ ND) {
    mangleUnqualifiedName(ND, ND.getDeclName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleUnqualifiedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 723,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleUnqualifiedName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclENS1_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclENS1_15DeclarationNameE")
  //</editor-fold>
  private void mangleUnqualifiedName(/*const*/ NamedDecl /*P*/ ND, 
                       DeclarationName Name) {
    //  <unqualified-name> ::= <operator-name>
    //                     ::= <ctor-dtor-name>
    //                     ::= <source-name>
    //                     ::= <template-name>
    
    // Check if we have a template.
    type$ref</*const*/ TemplateArgumentList /*P*/ > TemplateArgs = create_type$null$ref(null);
    {
      /*const*/ TemplateDecl /*P*/ TD = isTemplate(ND, TemplateArgs);
      if ((TD != null)) {
        raw_svector_ostream Stream = null;
        MicrosoftCXXNameMangler Extra = null;
        try {
          // Function templates aren't considered for name back referencing.  This
          // makes sense since function templates aren't likely to occur multiple
          // times in a symbol.
          if (isa_FunctionTemplateDecl(TD)) {
            mangleTemplateInstantiationName(TD, $Deref(TemplateArgs.$deref()));
            Out.$out_char($$AT);
            return;
          }
          
          // Here comes the tricky thing: if we need to mangle something like
          //   void foo(A::X<Y>, B::X<Y>),
          // the X<Y> part is aliased. However, if you need to mangle
          //   void foo(A::X<A::Y>, A::X<B::Y>),
          // the A::X<> part is not aliased.
          // That said, from the mangler's perspective we have a structure like this:
          //   namespace[s] -> type[ -> template-parameters]
          // but from the Clang perspective we have
          //   type [ -> template-parameters]
          //      \-> namespace[s]
          // What we do is we create a new mangler, mangle the same type (without
          // a namespace suffix) to a string using the extra mangler and then use 
          // the mangled type name as a key to check the mangling of different types
          // for aliasing.
          SmallString/*64*/ TemplateMangling/*J*/= new SmallString/*64*/(64);
          Stream/*J*/= new raw_svector_ostream(TemplateMangling);
          Extra/*J*/= new MicrosoftCXXNameMangler(Context, Stream);
          Extra.mangleTemplateInstantiationName(TD, $Deref(TemplateArgs.$deref()));
          
          mangleSourceName(TemplateMangling.$StringRef());
          return;
        } finally {
          if (Extra != null) { Extra.$destroy(); }
          if (Stream != null) { Stream.$destroy(); }
        }
      }
    }
    switch (Name.getNameKind()) {
     case Identifier:
      {
        {
          /*const*/ IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
          if ((II != null)) {
            mangleSourceName(II.getName());
            break;
          }
        }
        
        // Otherwise, an anonymous entity.  We must have a declaration.
        assert ((ND != null)) : "mangling empty name without declaration";
        {
          
          /*const*/ NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(ND);
          if ((NS != null)) {
            if (NS.isAnonymousNamespace()) {
              Out.$out(/*KEEP_STR*/"?A@");
              break;
            }
          }
        }
        {
          
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
          if ((VD != null)) {
            // We must have an anonymous union or struct declaration.
            /*const*/ CXXRecordDecl /*P*/ RD = VD.getType().$arrow().getAsCXXRecordDecl();
            assert ((RD != null)) : "expected variable decl to have a record type";
            // Anonymous types with no tag or typedef get the name of their
            // declarator mangled in.  If they have no declarator, number them with
            // a $S prefix.
            SmallString/*64*/ Name$1/*J*/= new SmallString/*64*/(64, new StringRef(/*KEEP_STR*/"$S"));
            // Get a unique id for the anonymous struct.
            Name$1.$addassign(new StringRef(llvm.utostr(Context.getAnonymousStructId(RD) + $int2ullong(1))));
            mangleSourceName(Name$1.str());
            break;
          }
        }
        
        // We must have an anonymous struct.
        /*const*/ TagDecl /*P*/ TD = cast_TagDecl(ND);
        {
          /*const*/ TypedefNameDecl /*P*/ D = TD.getTypedefNameForAnonDecl();
          if ((D != null)) {
            assert (TD.getDeclContext$Const() == D.getDeclContext$Const()) : "Typedef should not be in another decl context!";
            assert ((D.getDeclName().getAsIdentifierInfo() != null)) : "Typedef was not named!";
            mangleSourceName(D.getDeclName().getAsIdentifierInfo().getName());
            break;
          }
        }
        {
          
          /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(TD);
          if ((Record != null)) {
            if (Record.isLambda()) {
              SmallString/*10*/ Name$1/*J*/= new SmallString/*10*/(10, new StringRef(/*KEEP_STR*/"<lambda_"));
              /*uint*/int LambdaId;
              if ((Record.getLambdaManglingNumber() != 0)) {
                LambdaId = Record.getLambdaManglingNumber();
              } else {
                LambdaId = Context.getLambdaId(Record);
              }
              
              Name$1.$addassign(new StringRef(llvm.utostr($uint2ulong(LambdaId))));
              Name$1.$addassign(/*STRINGREF_STR*/">");
              
              mangleSourceName(Name$1.$StringRef());
              break;
            }
          }
        }
        
        SmallString/*64*/ Name$1/*J*/= new SmallString/*64*/(64, new StringRef(/*KEEP_STR*/"<unnamed-type-"));
        {
          DeclaratorDecl /*P*/ DD = Context.getASTContext().getDeclaratorForUnnamedTagDecl(TD);
          if ((DD != null)) {
            // Anonymous types without a name for linkage purposes have their
            // declarator mangled in if they have one.
            Name$1.$addassign(DD.getName());
          } else {
            TypedefNameDecl /*P*/ TND = Context.getASTContext().getTypedefNameForUnnamedTagDecl(TD);
            if ((TND != null)) {
              // Anonymous types without a name for linkage purposes have their
              // associate typedef mangled in if they have one.
              Name$1.$addassign(TND.getName());
            } else {
              // Otherwise, number the types using a $S prefix.
              Name$1.$addassign(/*STRINGREF_STR*/"$S");
              Name$1.$addassign(new StringRef(llvm.utostr(Context.getAnonymousStructId(TD) + $int2ullong(1))));
            }
          }
        }
        Name$1.$addassign(/*STRINGREF_STR*/">");
        mangleSourceName(Name$1.str());
        break;
      }
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      throw new llvm_unreachable("Can't mangle Objective-C selector names here!");
     case CXXConstructorName:
      if (Structor == getStructor(ND)) {
        if (StructorType == CXXCtorType.Ctor_CopyingClosure.getValue()) {
          Out.$out(/*KEEP_STR*/"?_O");
          return;
        }
        if (StructorType == CXXCtorType.Ctor_DefaultClosure.getValue()) {
          Out.$out(/*KEEP_STR*/"?_F");
          return;
        }
      }
      Out.$out(/*KEEP_STR*/"?0");
      return;
     case CXXDestructorName:
      if (ND == Structor) {
        // If the named decl is the C++ destructor we're mangling,
        // use the type we were given.
        mangleCXXDtorType(/*static_cast*/CXXDtorType.valueOf(StructorType));
      } else {
        // Otherwise, use the base destructor name. This is relevant if a
        // class with a destructor is declared within a destructor.
        mangleCXXDtorType(CXXDtorType.Dtor_Base);
      }
      break;
     case CXXConversionFunctionName:
      // <operator-name> ::= ?B # (cast)
      // The target type is encoded as the return type.
      Out.$out(/*KEEP_STR*/"?B");
      break;
     case CXXOperatorName:
      mangleOperatorName(Name.getCXXOverloadedOperator(), ND.getLocation());
      break;
     case CXXLiteralOperatorName:
      {
        Out.$out(/*KEEP_STR*/"?__K");
        mangleSourceName(Name.getCXXLiteralIdentifier().getName());
        break;
      }
     case CXXUsingDirective:
      throw new llvm_unreachable("Can't mangle a using directive name!");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleSourceName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1099,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleSourceName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleSourceNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleSourceNameEN4llvm9StringRefE")
  //</editor-fold>
  private void mangleSourceName(StringRef Name) {
    // <source name> ::= <identifier> @
    type$ptr<std.string/*P*/ > Found = std.find(NameBackReferences.begin(), NameBackReferences.end(), Name);
    if ($eq_ptr(Found, NameBackReferences.end())) {
      if ($less_uint(NameBackReferences.size(), 10)) {
        NameBackReferences.push_back_T$RR(Name.$string());
      }
      Out.$out(/*NO_COPY*/Name).$out_char($$AT);
    } else {
      Out.$out_int((Found.$sub(NameBackReferences.begin())));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleOperatorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 959,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleOperatorName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleOperatorNameEN5clang22OverloadedOperatorKindENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleOperatorNameEN5clang22OverloadedOperatorKindENS1_14SourceLocationE")
  //</editor-fold>
  private void mangleOperatorName(OverloadedOperatorKind OO, 
                    SourceLocation Loc) {
    switch (OO) {
     case OO_New:
      //                     ?0 # constructor
      //                     ?1 # destructor
      // <operator-name> ::= ?2 # new
      Out.$out(/*KEEP_STR*/"?2");
      break;
     case OO_Delete:
      // <operator-name> ::= ?3 # delete
      Out.$out(/*KEEP_STR*/"?3");
      break;
     case OO_Equal:
      // <operator-name> ::= ?4 # =
      Out.$out(/*KEEP_STR*/"?4");
      break;
     case OO_GreaterGreater:
      // <operator-name> ::= ?5 # >>
      Out.$out(/*KEEP_STR*/"?5");
      break;
     case OO_LessLess:
      // <operator-name> ::= ?6 # <<
      Out.$out(/*KEEP_STR*/"?6");
      break;
     case OO_Exclaim:
      // <operator-name> ::= ?7 # !
      Out.$out(/*KEEP_STR*/"?7");
      break;
     case OO_EqualEqual:
      // <operator-name> ::= ?8 # ==
      Out.$out(/*KEEP_STR*/"?8");
      break;
     case OO_ExclaimEqual:
      // <operator-name> ::= ?9 # !=
      Out.$out(/*KEEP_STR*/"?9");
      break;
     case OO_Subscript:
      // <operator-name> ::= ?A # []
      Out.$out(/*KEEP_STR*/"?A");
      break;
     case OO_Arrow:
      //                     ?B # conversion
      // <operator-name> ::= ?C # ->
      Out.$out(/*KEEP_STR*/"?C");
      break;
     case OO_Star:
      // <operator-name> ::= ?D # *
      Out.$out(/*KEEP_STR*/"?D");
      break;
     case OO_PlusPlus:
      // <operator-name> ::= ?E # ++
      Out.$out(/*KEEP_STR*/"?E");
      break;
     case OO_MinusMinus:
      // <operator-name> ::= ?F # --
      Out.$out(/*KEEP_STR*/"?F");
      break;
     case OO_Minus:
      // <operator-name> ::= ?G # -
      Out.$out(/*KEEP_STR*/"?G");
      break;
     case OO_Plus:
      // <operator-name> ::= ?H # +
      Out.$out(/*KEEP_STR*/"?H");
      break;
     case OO_Amp:
      // <operator-name> ::= ?I # &
      Out.$out(/*KEEP_STR*/"?I");
      break;
     case OO_ArrowStar:
      // <operator-name> ::= ?J # ->*
      Out.$out(/*KEEP_STR*/"?J");
      break;
     case OO_Slash:
      // <operator-name> ::= ?K # /
      Out.$out(/*KEEP_STR*/"?K");
      break;
     case OO_Percent:
      // <operator-name> ::= ?L # %
      Out.$out(/*KEEP_STR*/"?L");
      break;
     case OO_Less:
      // <operator-name> ::= ?M # <
      Out.$out(/*KEEP_STR*/"?M");
      break;
     case OO_LessEqual:
      // <operator-name> ::= ?N # <=
      Out.$out(/*KEEP_STR*/"?N");
      break;
     case OO_Greater:
      // <operator-name> ::= ?O # >
      Out.$out(/*KEEP_STR*/"?O");
      break;
     case OO_GreaterEqual:
      // <operator-name> ::= ?P # >=
      Out.$out(/*KEEP_STR*/"?P");
      break;
     case OO_Comma:
      // <operator-name> ::= ?Q # ,
      Out.$out(/*KEEP_STR*/"?Q");
      break;
     case OO_Call:
      // <operator-name> ::= ?R # ()
      Out.$out(/*KEEP_STR*/"?R");
      break;
     case OO_Tilde:
      // <operator-name> ::= ?S # ~
      Out.$out(/*KEEP_STR*/"?S");
      break;
     case OO_Caret:
      // <operator-name> ::= ?T # ^
      Out.$out(/*KEEP_STR*/"?T");
      break;
     case OO_Pipe:
      // <operator-name> ::= ?U # |
      Out.$out(/*KEEP_STR*/"?U");
      break;
     case OO_AmpAmp:
      // <operator-name> ::= ?V # &&
      Out.$out(/*KEEP_STR*/"?V");
      break;
     case OO_PipePipe:
      // <operator-name> ::= ?W # ||
      Out.$out(/*KEEP_STR*/"?W");
      break;
     case OO_StarEqual:
      // <operator-name> ::= ?X # *=
      Out.$out(/*KEEP_STR*/"?X");
      break;
     case OO_PlusEqual:
      // <operator-name> ::= ?Y # +=
      Out.$out(/*KEEP_STR*/"?Y");
      break;
     case OO_MinusEqual:
      // <operator-name> ::= ?Z # -=
      Out.$out(/*KEEP_STR*/"?Z");
      break;
     case OO_SlashEqual:
      // <operator-name> ::= ?_0 # /=
      Out.$out(/*KEEP_STR*/"?_0");
      break;
     case OO_PercentEqual:
      // <operator-name> ::= ?_1 # %=
      Out.$out(/*KEEP_STR*/"?_1");
      break;
     case OO_GreaterGreaterEqual:
      // <operator-name> ::= ?_2 # >>=
      Out.$out(/*KEEP_STR*/"?_2");
      break;
     case OO_LessLessEqual:
      // <operator-name> ::= ?_3 # <<=
      Out.$out(/*KEEP_STR*/"?_3");
      break;
     case OO_AmpEqual:
      // <operator-name> ::= ?_4 # &=
      Out.$out(/*KEEP_STR*/"?_4");
      break;
     case OO_PipeEqual:
      // <operator-name> ::= ?_5 # |=
      Out.$out(/*KEEP_STR*/"?_5");
      break;
     case OO_CaretEqual:
      // <operator-name> ::= ?_6 # ^=
      Out.$out(/*KEEP_STR*/"?_6");
      break;
     case OO_Array_New:
      //                     ?_7 # vftable
      //                     ?_8 # vbtable
      //                     ?_9 # vcall
      //                     ?_A # typeof
      //                     ?_B # local static guard
      //                     ?_C # string
      //                     ?_D # vbase destructor
      //                     ?_E # vector deleting destructor
      //                     ?_F # default constructor closure
      //                     ?_G # scalar deleting destructor
      //                     ?_H # vector constructor iterator
      //                     ?_I # vector destructor iterator
      //                     ?_J # vector vbase constructor iterator
      //                     ?_K # virtual displacement map
      //                     ?_L # eh vector constructor iterator
      //                     ?_M # eh vector destructor iterator
      //                     ?_N # eh vector vbase constructor iterator
      //                     ?_O # copy constructor closure
      //                     ?_P<name> # udt returning <name>
      //                     ?_Q # <unknown>
      //                     ?_R0 # RTTI Type Descriptor
      //                     ?_R1 # RTTI Base Class Descriptor at (a,b,c,d)
      //                     ?_R2 # RTTI Base Class Array
      //                     ?_R3 # RTTI Class Hierarchy Descriptor
      //                     ?_R4 # RTTI Complete Object Locator
      //                     ?_S # local vftable
      //                     ?_T # local vftable constructor closure
      // <operator-name> ::= ?_U # new[]
      Out.$out(/*KEEP_STR*/"?_U");
      break;
     case OO_Array_Delete:
      // <operator-name> ::= ?_V # delete[]
      Out.$out(/*KEEP_STR*/"?_V");
      break;
     case OO_Conditional:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
          /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
              /*KEEP_STR*/"cannot mangle this conditional operator yet");
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OO_Coawait:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
          /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
              /*KEEP_STR*/"cannot mangle this operator co_await yet");
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OO_None:
     case NUM_OVERLOADED_OPERATORS:
      throw new llvm_unreachable("Not an overloaded operator");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleCXXDtorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 939,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleCXXDtorType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler17mangleCXXDtorTypeEN5clang11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler17mangleCXXDtorTypeEN5clang11CXXDtorTypeE")
  //</editor-fold>
  private void mangleCXXDtorType(CXXDtorType T) {
    // Microsoft uses the names on the case labels for these dtor variants.  Clang
    // uses the Itanium terminology internally.  Everything in this ABI delegates
    // towards the base dtor.
    switch (T) {
     case Dtor_Base:
      // <operator-name> ::= ?1  # destructor
      Out.$out(/*KEEP_STR*/"?1");
      return;
     case Dtor_Complete:
      // <operator-name> ::= ?_D # vbase destructor
      Out.$out(/*KEEP_STR*/"?_D");
      return;
     case Dtor_Deleting:
      // <operator-name> ::= ?_G # scalar deleting destructor
      Out.$out(/*KEEP_STR*/"?_G");
      return;
     case Dtor_Comdat:
      // <operator-name> ::= ?_E # vector deleting destructor
      // FIXME: Add a vector deleting dtor type.  It goes in the vtable, so we need
      // it.
      throw new llvm_unreachable("not expecting a COMDAT");
    }
    throw new llvm_unreachable("Unsupported dtor type?");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1341,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleQualifiers", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleQualifiersEN5clang10QualifiersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleQualifiersEN5clang10QualifiersEb")
  //</editor-fold>
  private void mangleQualifiers(Qualifiers Quals, 
                  boolean IsMember) {
    // <cvr-qualifiers> ::= [E] [F] [I] <base-cvr-qualifiers>
    // 'E' means __ptr64 (32-bit only); 'F' means __unaligned (32/64-bit only);
    // 'I' means __restrict (32/64-bit).
    // Note that the MSVC __restrict keyword isn't the same as the C99 restrict
    // keyword!
    // <base-cvr-qualifiers> ::= A  # near
    //                       ::= B  # near const
    //                       ::= C  # near volatile
    //                       ::= D  # near const volatile
    //                       ::= E  # far (16-bit)
    //                       ::= F  # far const (16-bit)
    //                       ::= G  # far volatile (16-bit)
    //                       ::= H  # far const volatile (16-bit)
    //                       ::= I  # huge (16-bit)
    //                       ::= J  # huge const (16-bit)
    //                       ::= K  # huge volatile (16-bit)
    //                       ::= L  # huge const volatile (16-bit)
    //                       ::= M <basis> # based
    //                       ::= N <basis> # based const
    //                       ::= O <basis> # based volatile
    //                       ::= P <basis> # based const volatile
    //                       ::= Q  # near member
    //                       ::= R  # near const member
    //                       ::= S  # near volatile member
    //                       ::= T  # near const volatile member
    //                       ::= U  # far member (16-bit)
    //                       ::= V  # far const member (16-bit)
    //                       ::= W  # far volatile member (16-bit)
    //                       ::= X  # far const volatile member (16-bit)
    //                       ::= Y  # huge member (16-bit)
    //                       ::= Z  # huge const member (16-bit)
    //                       ::= 0  # huge volatile member (16-bit)
    //                       ::= 1  # huge const volatile member (16-bit)
    //                       ::= 2 <basis> # based member
    //                       ::= 3 <basis> # based const member
    //                       ::= 4 <basis> # based volatile member
    //                       ::= 5 <basis> # based const volatile member
    //                       ::= 6  # near function (pointers only)
    //                       ::= 7  # far function (pointers only)
    //                       ::= 8  # near method (pointers only)
    //                       ::= 9  # far method (pointers only)
    //                       ::= _A <basis> # based function (pointers only)
    //                       ::= _B <basis> # based function (far?) (pointers only)
    //                       ::= _C <basis> # based method (pointers only)
    //                       ::= _D <basis> # based method (far?) (pointers only)
    //                       ::= _E # block (Clang)
    // <basis> ::= 0 # __based(void)
    //         ::= 1 # __based(segment)?
    //         ::= 2 <name> # __based(name)
    //         ::= 3 # ?
    //         ::= 4 # ?
    //         ::= 5 # not really based
    boolean HasConst = Quals.hasConst();
    boolean HasVolatile = Quals.hasVolatile();
    if (!IsMember) {
      if (HasConst && HasVolatile) {
        Out.$out_char($$D);
      } else if (HasVolatile) {
        Out.$out_char($$C);
      } else if (HasConst) {
        Out.$out_char($$B);
      } else {
        Out.$out_char($$A);
      }
    } else {
      if (HasConst && HasVolatile) {
        Out.$out_char($$T);
      } else if (HasVolatile) {
        Out.$out_char($$S);
      } else if (HasConst) {
        Out.$out_char($$R);
      } else {
        Out.$out_char($$Q);
      }
    }
    // FIXME: For now, just drop all extension qualifiers on the floor.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleRefQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1423,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleRefQualifier", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleRefQualifierEN5clang16RefQualifierKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleRefQualifierEN5clang16RefQualifierKindE")
  //</editor-fold>
  private void mangleRefQualifier(RefQualifierKind RefQualifier) {
    // <ref-qualifier> ::= G                # lvalue reference
    //                 ::= H                # rvalue-reference
    switch (RefQualifier) {
     case RQ_None:
      break;
     case RQ_LValue:
      Out.$out_char($$G);
      break;
     case RQ_RValue:
      Out.$out_char($$H);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::manglePointerCVQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1456,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::manglePointerCVQualifiers", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler25manglePointerCVQualifiersEN5clang10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler25manglePointerCVQualifiersEN5clang10QualifiersE")
  //</editor-fold>
  private void manglePointerCVQualifiers(Qualifiers Quals) {
    // <pointer-cv-qualifiers> ::= P  # no qualifiers
    //                         ::= Q  # const
    //                         ::= R  # volatile
    //                         ::= S  # const volatile
    boolean HasConst = Quals.hasConst();
    boolean HasVolatile = Quals.hasVolatile();
    if (HasConst && HasVolatile) {
      Out.$out_char($$S);
    } else if (HasVolatile) {
      Out.$out_char($$R);
    } else if (HasConst) {
      Out.$out_char($$Q);
    } else {
      Out.$out_char($$P);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::manglePointerExtQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1441,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::manglePointerExtQualifiers", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler26manglePointerExtQualifiersEN5clang10QualifiersENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler26manglePointerExtQualifiersEN5clang10QualifiersENS1_8QualTypeE")
  //</editor-fold>
  private void manglePointerExtQualifiers(Qualifiers Quals, 
                            QualType PointeeType) {
    boolean HasRestrict = Quals.hasRestrict();
    if (PointersAre64Bit
       && (PointeeType.isNull() || !PointeeType.$arrow().isFunctionType())) {
      Out.$out_char($$E);
    }
    if (HasRestrict) {
      Out.$out_char($$I);
    }
    if (Quals.hasUnaligned()
       || (!PointeeType.isNull() && PointeeType.getLocalQualifiers().hasUnaligned())) {
      Out.$out_char($$F);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleUnscopedTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1139,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleUnscopedTemplateName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler26mangleUnscopedTemplateNameEPKN5clang12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler26mangleUnscopedTemplateNameEPKN5clang12TemplateDeclE")
  //</editor-fold>
  private void mangleUnscopedTemplateName(/*const*/ TemplateDecl /*P*/ TD) {
    // <unscoped-template-name> ::= ?$ <unqualified-name>
    Out.$out(/*KEEP_STR*/"?$");
    mangleUnqualifiedName(TD);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTemplateInstantiationName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1116,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTemplateInstantiationName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler31mangleTemplateInstantiationNameEPKN5clang12TemplateDeclERKNS1_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler31mangleTemplateInstantiationNameEPKN5clang12TemplateDeclERKNS1_20TemplateArgumentListE")
  //</editor-fold>
  private void mangleTemplateInstantiationName(/*const*/ TemplateDecl /*P*/ TD, final /*const*/ TemplateArgumentList /*&*/ TemplateArgs) {
    std.setInt OuterPassObjectSizeArgs = null;
    try {
      // <template-name> ::= <unscoped-template-name> <template-args>
      //                 ::= <substitution>
      // Always start with the unqualified name.
      
      // Templates have their own context for back references.
      DenseMapTypeUInt</*const*/Object/*void P*/> OuterArgsContext/*J*/= new DenseMapTypeUInt</*const*/Object/*void P*/>(DenseMapInfo$LikePtr.$Info(), 0);
      SmallVector<std.string> OuterTemplateContext/*J*/= new SmallVector<std.string>(10, new std.string());
      OuterPassObjectSizeArgs/*J*/= new std.setInt();
      NameBackReferences.swap(OuterTemplateContext);
      TypeBackReferences.swap(OuterArgsContext);
      PassObjectSizeArgs.swap(OuterPassObjectSizeArgs);
      
      mangleUnscopedTemplateName(TD);
      mangleTemplateArgs(TD, TemplateArgs);
      
      // Restore the previous back reference contexts.
      NameBackReferences.swap(OuterTemplateContext);
      TypeBackReferences.swap(OuterArgsContext);
      PassObjectSizeArgs.swap(OuterPassObjectSizeArgs);
    } finally {
      if (OuterPassObjectSizeArgs != null) { OuterPassObjectSizeArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleObjCMethodName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1112,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleObjCMethodName", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler20mangleObjCMethodNameEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler20mangleObjCMethodNameEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  private void mangleObjCMethodName(/*const*/ ObjCMethodDecl /*P*/ MD) {
    Context.mangleObjCMethodName(MD, Out);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1475,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleArgumentType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleArgumentTypeEN5clang8QualTypeENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleArgumentTypeEN5clang8QualTypeENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleArgumentType(QualType T, 
                    SourceRange Range) {
    // MSVC will backreference two canonically equivalent types that have slightly
    // different manglings when mangled alone.
    
    // Decayed types do not match up with non-decayed versions of the same type.
    //
    // e.g.
    // void (*x)(void) will not form a backreference with void x(void)
    Object/*void P*/ TypePtr;
    {
      /*const*/ DecayedType /*P*/ DT = T.$arrow().getAs(DecayedType.class);
      if ((DT != null)) {
        QualType OriginalType = DT.getOriginalType();
        {
          // All decayed ArrayTypes should be treated identically; as-if they were
          // a decayed IncompleteArrayType.
          /*const*/ ArrayType /*P*/ AT = getASTContext().getAsArrayType(new QualType(OriginalType));
          if ((AT != null)) {
            OriginalType.$assignMove(getASTContext().getIncompleteArrayType(AT.getElementType(), AT.getSizeModifier(), 
                    AT.getIndexTypeCVRQualifiers()));
          }
        }
        
        TypePtr = OriginalType.getCanonicalType().getAsOpaquePtr();
        // If the original parameter was textually written as an array,
        // instead treat the decayed parameter like it's const.
        //
        // e.g.
        // int [] -> int * const
        if (OriginalType.$arrow().isArrayType()) {
          T.$assignMove(T.withConst());
        }
      } else {
        TypePtr = T.getCanonicalType().getAsOpaquePtr();
      }
    }
    
      DenseMapIteratorTypeUInt</*const*/Object/*void P*/> Found = TypeBackReferences.find(TypePtr);    if (Found.$eq(/*NO_ITER_COPY*/TypeBackReferences.end())) {
      /*size_t*/int OutSizeBefore = $ulong2uint(Out.tell());
      
      mangleType(new QualType(T), new SourceRange(Range), QualifierMangleMode.QMM_Drop);
      
      // See if it's worth creating a back reference.
      // Only types longer than 1 character are considered
      // and only 10 back references slots are available:
      boolean LongerThanOneChar = ($greater_ullong(Out.tell() - $uint2ullong(OutSizeBefore), $int2ullong(1)));
      if (LongerThanOneChar && $less_uint(TypeBackReferences.size(), 10)) {
        /*size_t*/int Size = TypeBackReferences.size();
        TypeBackReferences.$set(TypePtr, Size);
      }
    } else {
      Out.$out_uint(Found.$arrow().second);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::manglePassObjectSizeArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1526,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::manglePassObjectSizeArg", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23manglePassObjectSizeArgEPKN5clang18PassObjectSizeAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23manglePassObjectSizeArgEPKN5clang18PassObjectSizeAttrE")
  //</editor-fold>
  private void manglePassObjectSizeArg(/*const*/ PassObjectSizeAttr /*P*/ POSA) {
    int Type = POSA.getType();

    std.setInt.iterator Iter = new std.setInt.iterator(JD$Move.INSTANCE, PassObjectSizeArgs.insert_T$C$R(Type).first);
    /*const*/Object/*void P*/ TypePtr = reinterpret_cast(/*const*/Object/*void P*/ .class, $AddrOf(Iter.$star()));
    DenseMapIteratorTypeUInt</*const*/Object/*void P*/> Found = TypeBackReferences.find(TypePtr);
    if (Found.$eq(/*NO_ITER_COPY*/TypeBackReferences.end())) {
      mangleArtificalTagType(TagTypeKind.TTK_Enum, new StringRef($add_T$C$P_string(/*KEEP_STR*/"__pass_object_size", llvm.utostr($int2ulong(Type)))), 
          /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*1*/] {new StringRef("__clang")}, false)/* }*/);
      if ($less_uint(TypeBackReferences.size(), 10)) {
        /*size_t*/int Size = TypeBackReferences.size();
        TypeBackReferences.$set(TypePtr, Size);
      }
    } else {
      Out.$out_uint(Found.$arrow().second);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1613,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang11BuiltinTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang11BuiltinTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ BuiltinType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    //  <type>         ::= <builtin-type>
    //  <builtin-type> ::= X  # void
    //                 ::= C  # signed char
    //                 ::= D  # char
    //                 ::= E  # unsigned char
    //                 ::= F  # short
    //                 ::= G  # unsigned short (or wchar_t if it's not a builtin)
    //                 ::= H  # int
    //                 ::= I  # unsigned int
    //                 ::= J  # long
    //                 ::= K  # unsigned long
    //                     L  # <none>
    //                 ::= M  # float
    //                 ::= N  # double
    //                 ::= O  # long double (__float80 is mangled differently)
    //                 ::= _J # long long, __int64
    //                 ::= _K # unsigned long long, __int64
    //                 ::= _L # __int128
    //                 ::= _M # unsigned __int128
    //                 ::= _N # bool
    //                     _O # <array in parameter>
    //                 ::= _T # __float80 (Intel)
    //                 ::= _W # wchar_t
    //                 ::= _Z # __float80 (Digital Mars)
    switch (T.getKind()) {
     case Void:
      Out.$out_char($$X);
      break;
     case SChar:
      Out.$out_char($$C);
      break;
     case Char_U:
     case Char_S:
      Out.$out_char($$D);
      break;
     case UChar:
      Out.$out_char($$E);
      break;
     case Short:
      Out.$out_char($$F);
      break;
     case UShort:
      Out.$out_char($$G);
      break;
     case Int:
      Out.$out_char($$H);
      break;
     case UInt:
      Out.$out_char($$I);
      break;
     case Long:
      Out.$out_char($$J);
      break;
     case ULong:
      Out.$out_char($$K);
      break;
     case Float:
      Out.$out_char($$M);
      break;
     case Double:
      Out.$out_char($$N);
      break;
     case LongDouble:
      // TODO: Determine size and mangle accordingly
      Out.$out_char($$O);
      break;
     case LongLong:
      Out.$out(/*KEEP_STR*/"_J");
      break;
     case ULongLong:
      Out.$out(/*KEEP_STR*/"_K");
      break;
     case Int128:
      Out.$out(/*KEEP_STR*/"_L");
      break;
     case UInt128:
      Out.$out(/*KEEP_STR*/"_M");
      break;
     case Bool:
      Out.$out(/*KEEP_STR*/"_N");
      break;
     case Char16:
      Out.$out(/*KEEP_STR*/"_S");
      break;
     case Char32:
      Out.$out(/*KEEP_STR*/"_U");
      break;
     case WChar_S:
     case WChar_U:
      Out.$out(/*KEEP_STR*/"_W");
      break;
     case Overload:
     case BoundMember:
     case PseudoObject:
     case UnknownAny:
     case BuiltinFn:
     case ARCUnbridgedCast:
     case OMPArraySection:
     case Dependent:
      throw new llvm_unreachable("placeholder types shouldn't get to name mangling");
     case ObjCId:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"objc_object"));
      break;
     case ObjCClass:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"objc_class"));
      break;
     case ObjCSel:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"objc_selector"));
      break;
     case OCLImage1dRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_ro@@");
      break;
     case OCLImage1dArrayRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_array_ro@@");
      break;
     case OCLImage1dBufferRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_buffer_ro@@");
      break;
     case OCLImage2dRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_ro@@");
      break;
     case OCLImage2dArrayRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_ro@@");
      break;
     case OCLImage2dDepthRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_depth_ro@@");
      break;
     case OCLImage2dArrayDepthRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_depth_ro@@");
      break;
     case OCLImage2dMSAARO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_msaa_ro@@");
      break;
     case OCLImage2dArrayMSAARO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_msaa_ro@@");
      break;
     case OCLImage2dMSAADepthRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_msaa_depth_ro@@");
      break;
     case OCLImage2dArrayMSAADepthRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_msaa_depth_ro@@");
      break;
     case OCLImage3dRO:
      Out.$out(/*KEEP_STR*/"PAUocl_image3d_ro@@");
      break;
     case OCLImage1dWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_wo@@");
      break;
     case OCLImage1dArrayWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_array_wo@@");
      break;
     case OCLImage1dBufferWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_buffer_wo@@");
      break;
     case OCLImage2dWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_wo@@");
      break;
     case OCLImage2dArrayWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_wo@@");
      break;
     case OCLImage2dDepthWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_depth_wo@@");
      break;
     case OCLImage2dArrayDepthWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_depth_wo@@");
      break;
     case OCLImage2dMSAAWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_msaa_wo@@");
      break;
     case OCLImage2dArrayMSAAWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_msaa_wo@@");
      break;
     case OCLImage2dMSAADepthWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_msaa_depth_wo@@");
      break;
     case OCLImage2dArrayMSAADepthWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_msaa_depth_wo@@");
      break;
     case OCLImage3dWO:
      Out.$out(/*KEEP_STR*/"PAUocl_image3d_wo@@");
      break;
     case OCLImage1dRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_rw@@");
      break;
     case OCLImage1dArrayRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_array_rw@@");
      break;
     case OCLImage1dBufferRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image1d_buffer_rw@@");
      break;
     case OCLImage2dRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_rw@@");
      break;
     case OCLImage2dArrayRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_rw@@");
      break;
     case OCLImage2dDepthRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_depth_rw@@");
      break;
     case OCLImage2dArrayDepthRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_depth_rw@@");
      break;
     case OCLImage2dMSAARW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_msaa_rw@@");
      break;
     case OCLImage2dArrayMSAARW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_msaa_rw@@");
      break;
     case OCLImage2dMSAADepthRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_msaa_depth_rw@@");
      break;
     case OCLImage2dArrayMSAADepthRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image2d_array_msaa_depth_rw@@");
      break;
     case OCLImage3dRW:
      Out.$out(/*KEEP_STR*/"PAUocl_image3d_rw@@");
      break;
     case OCLSampler:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"ocl_sampler"));
      break;
     case OCLEvent:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"ocl_event"));
      break;
     case OCLClkEvent:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"ocl_clkevent"));
      break;
     case OCLQueue:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"ocl_queue"));
      break;
     case OCLNDRange:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"ocl_ndrange"));
      break;
     case OCLReserveID:
      Out.$out(/*KEEP_STR*/"PA");
      mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"ocl_reserveid"));
      break;
     case NullPtr:
      Out.$out(/*KEEP_STR*/"$$T");
      break;
     case Float128:
     case Half:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
          /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, /*KEEP_STR*/"cannot mangle this built-in %0 type yet");
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
                  T.getName(Context.getASTContext().getPrintingPolicy())), /*NO_COPY*/Range));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2240,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang11ComplexTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang11ComplexTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ ComplexType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    raw_svector_ostream Stream = null;
    MicrosoftCXXNameMangler Extra = null;
    try {
      QualType ElementType = T.getElementType();
      
      SmallString/*64*/ TemplateMangling/*J*/= new SmallString/*64*/(64);
      Stream/*J*/= new raw_svector_ostream(TemplateMangling);
      Extra/*J*/= new MicrosoftCXXNameMangler(Context, Stream);
      Stream.$out(/*KEEP_STR*/"?$");
      Extra.mangleSourceName(new StringRef(/*KEEP_STR*/$_Complex));
      Extra.mangleType(new QualType(ElementType), new SourceRange(Range), QualifierMangleMode.QMM_Escape);
      
      mangleArtificalTagType(TagTypeKind.TTK_Struct, TemplateMangling.$StringRef(), /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*1*/] {new StringRef("__clang")}, false)/* }*/);
    } finally {
      if (Extra != null) { Extra.$destroy(); }
      if (Stream != null) { Stream.$destroy(); }
    }
  }

  
  // <type> ::= <pointer-type>
  // <pointer-type> ::= E? <pointer-cvr-qualifiers> <cvr-qualifiers> <type>
  //                       # the E is required for 64-bit non-static pointers
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2199,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang11PointerTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang11PointerTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ PointerType /*P*/ T, Qualifiers Quals, 
            SourceRange Range) {
    QualType PointeeType = T.getPointeeType();
    manglePointerCVQualifiers(new Qualifiers(Quals));
    manglePointerExtQualifiers(new Qualifiers(Quals), new QualType(PointeeType));
    mangleType(new QualType(PointeeType), new SourceRange(Range));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2323,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang16BlockPointerTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang16BlockPointerTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ BlockPointerType /*P*/ T, 
            Qualifiers Quals, SourceRange Range) {
    QualType PointeeType = T.getPointeeType();
    manglePointerCVQualifiers(new Qualifiers(Quals));
    manglePointerExtQualifiers(new Qualifiers(Quals), new QualType(PointeeType));
    
    Out.$out(/*KEEP_STR*/"_E");
    
    mangleFunctionType(PointeeType.$arrow().castAs(FunctionProtoType.class));
  }

  
  // <type> ::= <reference-type>
  // <reference-type> ::= A E? <cvr-qualifiers> <type>
  //                 # the E is required for 64-bit non-static lvalue references
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2219,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19LValueReferenceTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19LValueReferenceTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ LValueReferenceType /*P*/ T, 
            Qualifiers Quals, SourceRange Range) {
    QualType PointeeType = T.getPointeeType();
    assert (!Quals.hasConst() && !Quals.hasVolatile()) : "unexpected qualifier!";
    Out.$out_char($$A);
    manglePointerExtQualifiers(new Qualifiers(Quals), new QualType(PointeeType));
    mangleType(new QualType(PointeeType), new SourceRange(Range));
  }

  
  // <type> ::= <r-value-reference-type>
  // <r-value-reference-type> ::= $$Q E? <cvr-qualifiers> <type>
  //                 # the E is required for 64-bit non-static rvalue references
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2231,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19RValueReferenceTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19RValueReferenceTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ RValueReferenceType /*P*/ T, 
            Qualifiers Quals, SourceRange Range) {
    QualType PointeeType = T.getPointeeType();
    assert (!Quals.hasConst() && !Quals.hasVolatile()) : "unexpected qualifier!";
    Out.$out(/*KEEP_STR*/"$$Q");
    manglePointerExtQualifiers(new Qualifiers(Quals), new QualType(PointeeType));
    mangleType(new QualType(PointeeType), new SourceRange(Range));
  }

  
  // <type>                   ::= <pointer-to-member-type>
  // <pointer-to-member-type> ::= <pointer-cvr-qualifiers> <cvr-qualifiers>
  //                                                          <class name> <type>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2162,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17MemberPointerTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17MemberPointerTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ MemberPointerType /*P*/ T, Qualifiers Quals, 
            SourceRange Range) {
    QualType PointeeType = T.getPointeeType();
    manglePointerCVQualifiers(new Qualifiers(Quals));
    manglePointerExtQualifiers(new Qualifiers(Quals), new QualType(PointeeType));
    {
      /*const*/ FunctionProtoType /*P*/ FPT = PointeeType.$arrow().getAs(FunctionProtoType.class);
      if ((FPT != null)) {
        Out.$out_char($$8);
        mangleName(T.__getClass().castAs$RecordType().getDecl());
        mangleFunctionType(FPT, (/*const*/ FunctionDecl /*P*/ )null, true);
      } else {
        mangleQualifiers(PointeeType.getQualifiers(), true);
        mangleName(T.__getClass().castAs$RecordType().getDecl());
        mangleType(new QualType(PointeeType), new SourceRange(Range), QualifierMangleMode.QMM_Drop);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2102,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17ConstantArrayTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17ConstantArrayTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ ConstantArrayType /*P*/ T, Qualifiers $Prm1, 
            SourceRange $Prm2) {
    throw new llvm_unreachable("Should have been special cased");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2114,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19IncompleteArrayTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19IncompleteArrayTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ IncompleteArrayType /*P*/ T, 
            Qualifiers $Prm1, SourceRange $Prm2) {
    throw new llvm_unreachable("Should have been special cased");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2106,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17VariableArrayTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17VariableArrayTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ VariableArrayType /*P*/ T, Qualifiers $Prm1, 
            SourceRange $Prm2) {
    throw new llvm_unreachable("Should have been special cased");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2110,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang23DependentSizedArrayTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang23DependentSizedArrayTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentSizedArrayType /*P*/ T, 
            Qualifiers $Prm1, SourceRange $Prm2) {
    throw new llvm_unreachable("Should have been special cased");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2300,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang27DependentSizedExtVectorTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang27DependentSizedExtVectorTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentSizedExtVectorType /*P*/ T, 
            Qualifiers $Prm1, SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this dependent-sized extended vector type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2254,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10VectorTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10VectorTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ VectorType /*P*/ T, Qualifiers Quals, 
            SourceRange Range) {
    /*const*/ BuiltinType /*P*/ ET = T.getElementType().$arrow().getAs$BuiltinType();
    assert ((ET != null)) : "vectors with non-builtin elements are unsupported";
    long/*uint64_t*/ Width = getASTContext().getTypeSize(T);
    // Pattern match exactly the typedefs in our intrinsic headers.  Anything that
    // doesn't match the Intel types uses a custom mangling below.
    /*size_t*/int OutSizeBefore = $ulong2uint(Out.tell());
    Triple.ArchType AT = getASTContext().getTargetInfo().getTriple().getArch();
    if (AT == Triple.ArchType.x86 || AT == Triple.ArchType.x86_64) {
      if (Width == $int2ullong(64) && ET.getKind() == BuiltinType.Kind.LongLong) {
        mangleArtificalTagType(TagTypeKind.TTK_Union, new StringRef(/*KEEP_STR*/"__m64"));
      } else if ($greatereq_ulong_ullong(Width, $int2ullong(128))) {
        if (ET.getKind() == BuiltinType.Kind.Float) {
          mangleArtificalTagType(TagTypeKind.TTK_Union, new StringRef($add_T$C$P_string(/*KEEP_STR*/"__m", llvm.utostr(Width))));
        } else if (ET.getKind() == BuiltinType.Kind.LongLong) {
          mangleArtificalTagType(TagTypeKind.TTK_Union, new StringRef($add_string_T($add_T$C$P_string(/*KEEP_STR*/"__m", llvm.utostr(Width)), $$i)));
        } else if (ET.getKind() == BuiltinType.Kind.Double) {
          mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef($add_string_T($add_T$C$P_string(/*KEEP_STR*/"__m", llvm.utostr(Width)), $$d)));
        }
      }
    }
    
    boolean IsBuiltin = Out.tell() != $uint2ullong(OutSizeBefore);
    if (!IsBuiltin) {
      raw_svector_ostream Stream = null;
      MicrosoftCXXNameMangler Extra = null;
      try {
        // The MS ABI doesn't have a special mangling for vector types, so we define
        // our own mangling to handle uses of __vector_size__ on user-specified
        // types, and for extensions like __v4sf.
        SmallString/*64*/ TemplateMangling/*J*/= new SmallString/*64*/(64);
        Stream/*J*/= new raw_svector_ostream(TemplateMangling);
        Extra/*J*/= new MicrosoftCXXNameMangler(Context, Stream);
        Stream.$out(/*KEEP_STR*/"?$");
        Extra.mangleSourceName(new StringRef(/*KEEP_STR*/$__vector));
        Extra.mangleType(new QualType(ET, 0), new SourceRange(Range), QualifierMangleMode.QMM_Escape);
        Extra.mangleIntegerLiteral(APSInt.getUnsigned($uint2ulong(T.getNumElements())), 
            /*IsBoolean=*/ false);
        
        mangleArtificalTagType(TagTypeKind.TTK_Union, TemplateMangling.$StringRef(), /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*1*/] {new StringRef("__clang")}, false)/* }*/);
      } finally {
        if (Extra != null) { Extra.$destroy(); }
        if (Stream != null) { Stream.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2296,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang13ExtVectorTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang13ExtVectorTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ ExtVectorType /*P*/ T, 
            Qualifiers Quals, SourceRange Range) {
    mangleType(((/*static_cast*//*const*/ VectorType /*P*/ )(T)), new Qualifiers(Quals), new SourceRange(Range));
  }

  
  // <type>          ::= <function-type>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1774,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17FunctionProtoTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17FunctionProtoTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ FunctionProtoType /*P*/ T, Qualifiers $Prm1, 
            SourceRange $Prm2) {
    // Structors only appear in decls, so at this point we know it's not a
    // structor type.
    // FIXME: This may not be lambda-friendly.
    if ((T.getTypeQuals() != 0) || T.getRefQualifier() != RefQualifierKind.RQ_None) {
      Out.$out(/*KEEP_STR*/"$$A8@@");
      mangleFunctionType(T, /*D=*/ (/*const*/ FunctionDecl /*P*/ )null, /*ForceThisQuals=*/ true);
    } else {
      Out.$out(/*KEEP_STR*/"$$A6");
      mangleFunctionType(T);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1787,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19FunctionNoProtoTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19FunctionNoProtoTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ FunctionNoProtoType /*P*/ T, 
            Qualifiers $Prm1, SourceRange $Prm2) {
    Out.$out(/*KEEP_STR*/"$$A6");
    mangleFunctionType(T);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2029,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19UnresolvedUsingTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang19UnresolvedUsingTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ UnresolvedUsingType /*P*/ T, 
            Qualifiers $Prm1, SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Probably should be mangled as a template instantiation; need to see what
      // VC does first.
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this unresolved dependent type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2385,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang14TypeOfExprTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang14TypeOfExprTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ TypeOfExprType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this typeof(expression) yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2376,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10TypeOfTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10TypeOfTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ TypeOfType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this typeof(type) yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2394,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang12DecltypeTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang12DecltypeTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ DecltypeType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this decltype() yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2403,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang18UnaryTransformTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang18UnaryTransformTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ UnaryTransformType /*P*/ T, 
            Qualifiers $Prm1, SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this unary transform type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2066,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10RecordTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10RecordTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ RecordType /*P*/ T, Qualifiers $Prm1, 
            SourceRange $Prm2) {
    mangleType(cast_TagType(T).getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2062,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang8EnumTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang8EnumTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ EnumType /*P*/ T, Qualifiers $Prm1, 
            SourceRange $Prm2) {
    mangleType(cast_TagType(T).getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2178,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang20TemplateTypeParmTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang20TemplateTypeParmTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ TemplateTypeParmType /*P*/ T, 
            Qualifiers $Prm1, SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this template type parameter type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2187,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang29SubstTemplateTypeParmPackTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang29SubstTemplateTypeParmPackTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T, 
            Qualifiers $Prm1, SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this substituted parameter pack yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2339,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang26TemplateSpecializationTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang26TemplateSpecializationTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ TemplateSpecializationType /*P*/ T, 
            Qualifiers $Prm1, SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this template specialization type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2412,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang8AutoTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang8AutoTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ AutoType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (T.getDeducedType().isNull()) : "expecting a dependent type!";
      
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this 'auto' type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2334,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang21InjectedClassNameTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang21InjectedClassNameTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ InjectedClassNameType /*P*/ $Prm0, 
            Qualifiers $Prm1, SourceRange $Prm2) {
    throw new llvm_unreachable("Cannot mangle injected class name type.");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2348,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17DependentNameTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17DependentNameTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentNameType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this dependent name type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2357,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang35DependentTemplateSpecializationTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang35DependentTemplateSpecializationTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentTemplateSpecializationType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this dependent template specialization type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2367,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17PackExpansionTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17PackExpansionTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ PackExpansionType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this pack expansion yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2316,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang14ObjCObjectTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang14ObjCObjectTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ ObjCObjectType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    // We don't allow overloading by different protocol qualification,
    // so mangling them isn't necessary.
    mangleType(T.getBaseType(), new SourceRange(Range));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2309,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17ObjCInterfaceTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang17ObjCInterfaceTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ ObjCInterfaceType /*P*/ T, Qualifiers $Prm1, 
            SourceRange $Prm2) {
    // ObjC interfaces have structs underlying them.
    mangleTagTypeKind(TagTypeKind.TTK_Struct);
    mangleName(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2206,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang21ObjCObjectPointerTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang21ObjCObjectPointerTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ ObjCObjectPointerType /*P*/ T, 
            Qualifiers Quals, SourceRange Range) {
    QualType PointeeType = T.getPointeeType();
    manglePointerCVQualifiers(new Qualifiers(Quals));
    manglePointerExtQualifiers(new Qualifiers(Quals), new QualType(PointeeType));
    // Object pointers never have qualifiers.
    Out.$out_char($$A);
    mangleType(new QualType(PointeeType), new SourceRange(Range));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2437,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang8PipeTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang8PipeTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ PipeType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot mangle this OpenCL pipe type yet");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Range.getBegin(), DiagID)), 
          /*NO_COPY*/Range));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2423,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10AtomicTypeENS1_10QualifiersENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang10AtomicTypeENS1_10QualifiersENS1_11SourceRangeE")
  //</editor-fold>
  private void mangleType(/*const*/ AtomicType /*P*/ T, Qualifiers $Prm1, 
            SourceRange Range) {
    raw_svector_ostream Stream = null;
    MicrosoftCXXNameMangler Extra = null;
    try {
      QualType ValueType = T.getValueType();
      
      SmallString/*64*/ TemplateMangling/*J*/= new SmallString/*64*/(64);
      Stream/*J*/= new raw_svector_ostream(TemplateMangling);
      Extra/*J*/= new MicrosoftCXXNameMangler(Context, Stream);
      Stream.$out(/*KEEP_STR*/"?$");
      Extra.mangleSourceName(new StringRef(/*KEEP_STR*/$_Atomic));
      Extra.mangleType(new QualType(ValueType), new SourceRange(Range), QualifierMangleMode.QMM_Escape);
      
      mangleArtificalTagType(TagTypeKind.TTK_Struct, TemplateMangling.$StringRef(), /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*1*/] {new StringRef("__clang")}, false)/* }*/);
    } finally {
      if (Extra != null) { Extra.$destroy(); }
      if (Stream != null) { Stream.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2070,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler10mangleTypeEPKN5clang7TagDeclE")
  //</editor-fold>
  private void mangleType(/*const*/ TagDecl /*P*/ TD) {
    mangleTagTypeKind(TD.getTagKind());
    mangleName(TD);
  }

  
  // <type>       ::= <array-type>
  // <array-type> ::= <pointer-cvr-qualifiers> <cvr-qualifiers>
  //                  [Y <dimension-count> <dimension>+]
  //                  <element-type> # as global, E is never required
  // It's supposed to be the other way around, but for some strange reason, it
  // isn't. Today this behavior is retained for the sole purpose of backwards
  // compatibility.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleDecayedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2096,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleDecayedArrayType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleDecayedArrayTypeEPKN5clang9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler22mangleDecayedArrayTypeEPKN5clang9ArrayTypeE")
  //</editor-fold>
  private void mangleDecayedArrayType(/*const*/ ArrayType /*P*/ T) {
    // This isn't a recursive mangling, so now we have to do it all in this
    // one call.
    manglePointerCVQualifiers(T.getElementType().getQualifiers());
    mangleType(T.getElementType(), new SourceRange());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2118,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleArrayType", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler15mangleArrayTypeEPKN5clang9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler15mangleArrayTypeEPKN5clang9ArrayTypeE")
  //</editor-fold>
  private void mangleArrayType(/*const*/ ArrayType /*P*/ T) {
    QualType ElementTy/*J*/= new QualType(T, 0);
    SmallVector<APInt> Dimensions/*J*/= new SmallVector<APInt>(3, new APInt());
    for (;;) {
      if (ElementTy.$arrow().isConstantArrayType()) {
        /*const*/ ConstantArrayType /*P*/ CAT = getASTContext().getAsConstantArrayType(new QualType(ElementTy));
        Dimensions.push_back_T$C$R(CAT.getSize());
        ElementTy.$assignMove(CAT.getElementType());
      } else if (ElementTy.$arrow().isIncompleteArrayType()) {
        /*const*/ IncompleteArrayType /*P*/ IAT = getASTContext().getAsIncompleteArrayType(new QualType(ElementTy));
        Dimensions.push_back_T$RR(new APInt(32, $int2ulong(0)));
        ElementTy.$assignMove(IAT.getElementType());
      } else if (ElementTy.$arrow().isVariableArrayType()) {
        /*const*/ VariableArrayType /*P*/ VAT = getASTContext().getAsVariableArrayType(new QualType(ElementTy));
        Dimensions.push_back_T$RR(new APInt(32, $int2ulong(0)));
        ElementTy.$assignMove(VAT.getElementType());
      } else if (ElementTy.$arrow().isDependentSizedArrayType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The dependent expression has to be folded into a constant (TODO).
          /*const*/ DependentSizedArrayType /*P*/ DSAT = getASTContext().getAsDependentSizedArrayType(new QualType(ElementTy));
          final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
          /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
              /*KEEP_STR*/"cannot mangle this dependent-length array yet");
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(DSAT.getSizeExpr().getExprLoc(), DiagID)), 
              DSAT.getBracketsRange()));
          return;
        } finally {
          $c$.$destroy();
        }
      } else {
        break;
      }
    }
    Out.$out_char($$Y);
    // <dimension-count> ::= <number> # number of extra dimensions
    mangleNumber($uint2long(Dimensions.size()));
    for (final /*const*/ APInt /*&*/ Dimension : Dimensions)  {
      mangleNumber(Dimension.getLimitedValue());
    }
    mangleType(new QualType(ElementTy), new SourceRange(), QualifierMangleMode.QMM_Escape);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleFunctionClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1927,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleFunctionClass", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler19mangleFunctionClassEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler19mangleFunctionClassEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private void mangleFunctionClass(/*const*/ FunctionDecl /*P*/ FD) {
    {
      // <function-class>  ::= <member-function> E? # E designates a 64-bit 'this'
      //                                            # pointer. in 64-bit mode *all*
      //                                            # 'this' pointers are 64-bit.
      //                   ::= <global-function>
      // <member-function> ::= A # private: near
      //                   ::= B # private: far
      //                   ::= C # private: static near
      //                   ::= D # private: static far
      //                   ::= E # private: virtual near
      //                   ::= F # private: virtual far
      //                   ::= I # protected: near
      //                   ::= J # protected: far
      //                   ::= K # protected: static near
      //                   ::= L # protected: static far
      //                   ::= M # protected: virtual near
      //                   ::= N # protected: virtual far
      //                   ::= Q # public: near
      //                   ::= R # public: far
      //                   ::= S # public: static near
      //                   ::= T # public: static far
      //                   ::= U # public: virtual near
      //                   ::= V # public: virtual far
      // <global-function> ::= Y # global near
      //                   ::= Z # global far
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
      if ((MD != null)) {
        switch (MD.getAccess()) {
         case AS_none:
          throw new llvm_unreachable("Unsupported access specifier");
         case AS_private:
          if (MD.isStatic()) {
            Out.$out_char($$C);
          } else if (MD.isVirtual()) {
            Out.$out_char($$E);
          } else {
            Out.$out_char($$A);
          }
          break;
         case AS_protected:
          if (MD.isStatic()) {
            Out.$out_char($$K);
          } else if (MD.isVirtual()) {
            Out.$out_char($$M);
          } else {
            Out.$out_char($$I);
          }
          break;
         case AS_public:
          if (MD.isStatic()) {
            Out.$out_char($$S);
          } else if (MD.isVirtual()) {
            Out.$out_char($$U);
          } else {
            Out.$out_char($$Q);
          }
        }
      } else {
        Out.$out_char($$Y);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1984,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleCallingConvention", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23mangleCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23mangleCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  private void mangleCallingConvention(CallingConv CC) {
    // <calling-convention> ::= A # __cdecl
    //                      ::= B # __export __cdecl
    //                      ::= C # __pascal
    //                      ::= D # __export __pascal
    //                      ::= E # __thiscall
    //                      ::= F # __export __thiscall
    //                      ::= G # __stdcall
    //                      ::= H # __export __stdcall
    //                      ::= I # __fastcall
    //                      ::= J # __export __fastcall
    //                      ::= Q # __vectorcall
    // The 'export' calling conventions are from a bygone era
    // (*cough*Win16*cough*) when functions were declared for export with
    // that keyword. (It didn't actually export them, it just made them so
    // that they could be in a DLL and somebody from another module could call
    // them.)
    switch (CC) {
     default:
      throw new llvm_unreachable("Unsupported CC for mangling");
     case CC_X86_64Win64:
     case CC_X86_64SysV:
     case CC_C:
      Out.$out_char($$A);
      break;
     case CC_X86Pascal:
      Out.$out_char($$C);
      break;
     case CC_X86ThisCall:
      Out.$out_char($$E);
      break;
     case CC_X86StdCall:
      Out.$out_char($$G);
      break;
     case CC_X86FastCall:
      Out.$out_char($$I);
      break;
     case CC_X86VectorCall:
      Out.$out_char($$Q);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2015,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleCallingConvention", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23mangleCallingConventionEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler23mangleCallingConventionEPKN5clang12FunctionTypeE")
  //</editor-fold>
  private void mangleCallingConvention(/*const*/ FunctionType /*P*/ T) {
    mangleCallingConvention(T.getCallConv());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1146,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleIntegerLiteral", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler20mangleIntegerLiteralERKN4llvm6APSIntEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler20mangleIntegerLiteralERKN4llvm6APSIntEb")
  //</editor-fold>
  private void mangleIntegerLiteral(final /*const*/ APSInt /*&*/ Value, 
                      boolean IsBoolean) {
    // <integer-literal> ::= $0 <number>
    Out.$out(/*KEEP_STR*/"$0");
    // Make sure booleans are encoded as 0/1.
    if (IsBoolean && Value.getBoolValue()) {
      mangleNumber(1);
    } else if (Value.isSigned()) {
      mangleNumber(Value.getSExtValue());
    } else {
      mangleNumber(Value.getZExtValue());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1159,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleExpression", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleExpressionEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler16mangleExpressionEPKN5clang4ExprE")
  //</editor-fold>
  private void mangleExpression(/*const*/ Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // See if this is a constant expression.
      APSInt Value/*J*/= new APSInt();
      if (E.isIntegerConstantExpr(Value, Context.getASTContext())) {
        mangleIntegerLiteral(Value, E.getType().$arrow().isBooleanType());
        return;
      }
      
      // Look through no-op casts like template parameter substitutions.
      E = E.IgnoreParenNoopCasts$Const(Context.getASTContext());
      
      /*const*/ CXXUuidofExpr /*P*/ UE = null;
      {
        /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
        if ((UO != null)) {
          if (UO.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
            UE = dyn_cast_CXXUuidofExpr(UO.getSubExpr());
          }
        } else {
          UE = dyn_cast_CXXUuidofExpr(E);
        }
      }
      if ((UE != null)) {
        // If we had to peek through an address-of operator, treat this like we are
        // dealing with a pointer type.  Otherwise, treat it like a const reference.
        //
        // N.B. This matches up with the handling of TemplateArgument::Declaration
        // in mangleTemplateArg
        if (UE == E) {
          Out.$out(/*KEEP_STR*/"$E?");
        } else {
          Out.$out(/*KEEP_STR*/"$1?");
        }
        
        // This CXXUuidofExpr is mangled as-if it were actually a VarDecl from
        // const __s_GUID _GUID_{lower case UUID with underscores}
        StringRef Uuid = UE.getUuidStr();
        std.string Name = $add_T$C$P_string(/*KEEP_STR*/"_GUID_", Uuid.lower());
        std.replace(Name.begin(), Name.end(), $$MINUS, $$UNDERSCORE);
        
        mangleSourceName(new StringRef(Name));
        // Terminate the whole name with an '@'.
        Out.$out_char($$AT);
        // It's a global variable.
        Out.$out_char($$3);
        // It's a struct called __s_GUID.
        mangleArtificalTagType(TagTypeKind.TTK_Struct, new StringRef(/*KEEP_STR*/"__s_GUID"));
        // It's const.
        Out.$out_char($$B);
        return;
      }
      
      // As bad as this diagnostic is, it's better than crashing.
      final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, /*KEEP_STR*/"cannot yet mangle expression type %0");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(E.getExprLoc(), DiagID)), E.getStmtClassName()), 
          E.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleThrowSpecification">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2018,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleThrowSpecification", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler24mangleThrowSpecificationEPKN5clang17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler24mangleThrowSpecificationEPKN5clang17FunctionProtoTypeE")
  //</editor-fold>
  private void mangleThrowSpecification(/*const*/ FunctionProtoType /*P*/ FT) {
    // <throw-spec> ::= Z # throw(...) (default)
    //              ::= @ # throw() or __declspec/__attribute__((nothrow))
    //              ::= <type>+
    // NOTE: Since the Microsoft compiler ignores throw specifications, they are
    // all actually mangled as 'Z'. (They're ignored because their associated
    // functionality isn't implemented, and probably never will be.)
    Out.$out_char($$Z);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1214,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTemplateArgs", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleTemplateArgsEPKN5clang12TemplateDeclERKNS1_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler18mangleTemplateArgsEPKN5clang12TemplateDeclERKNS1_20TemplateArgumentListE")
  //</editor-fold>
  private void mangleTemplateArgs(/*const*/ TemplateDecl /*P*/ TD, final /*const*/ TemplateArgumentList /*&*/ TemplateArgs) {
    // <template-args> ::= <template-arg>+
    /*const*/ TemplateParameterList /*P*/ TPL = TD.getTemplateParameters();
    assert (TPL.size() == TemplateArgs.size()) : "size mismatch between args and parms!";
    
    /*uint*/int Idx = 0;
    for (final /*const*/ TemplateArgument /*&*/ TA : TemplateArgs.asArray())  {
      mangleTemplateArg(TD, TA, TPL.getParam$Const(Idx++));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTemplateArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 1226,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::mangleTemplateArg", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler17mangleTemplateArgEPKN5clang12TemplateDeclERKNS1_16TemplateArgumentEPKNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameMangler17mangleTemplateArgEPKN5clang12TemplateDeclERKNS1_16TemplateArgumentEPKNS1_9NamedDeclE")
  //</editor-fold>
  private void mangleTemplateArg(/*const*/ TemplateDecl /*P*/ TD, 
                   final /*const*/ TemplateArgument /*&*/ TA, 
                   /*const*/ NamedDecl /*P*/ Parm) {
    // <template-arg> ::= <type>
    //                ::= <integer-literal>
    //                ::= <member-data-pointer>
    //                ::= <member-function-pointer>
    //                ::= $E? <name> <type-encoding>
    //                ::= $1? <name> <type-encoding>
    //                ::= $0A@
    //                ::= <template-args>
    switch (TA.getKind()) {
     case Null:
      throw new llvm_unreachable("Can't mangle null template arguments!");
     case TemplateExpansion:
      throw new llvm_unreachable("Can't mangle template expansion arguments!");
     case Type:
      {
        QualType T = TA.getAsType();
        mangleType(new QualType(T), new SourceRange(), QualifierMangleMode.QMM_Escape);
        break;
      }
     case Declaration:
      {
        /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(TA.getAsDecl());
        if (isa_FieldDecl(ND) || isa_IndirectFieldDecl(ND)) {
          mangleMemberDataPointer(cast_CXXRecordDecl(ND.getDeclContext$Const()).getMostRecentDecl$Const(), 
              cast_ValueDecl(ND));
        } else {
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
          if ((FD != null)) {
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
            if ((MD != null) && MD.isInstance()) {
              mangleMemberFunctionPointer(MD.getParent$Const().getMostRecentDecl$Const(), MD);
            } else {
              Out.$out(/*KEEP_STR*/"$1?");
              mangleName(FD);
              mangleFunctionEncoding(FD, /*ShouldMangle=*/ true);
            }
          } else {
            mangle(ND, new StringRef(TA.getParamTypeForDecl().$arrow().isReferenceType() ? $("$E?") : $("$1?")));
          }
        }
        break;
      }
     case Integral:
      mangleIntegerLiteral(TA.getAsIntegral(), 
          TA.getIntegralType().$arrow().isBooleanType());
      break;
     case NullPtr:
      {
        QualType T = TA.getNullPtrType();
        {
          /*const*/ MemberPointerType /*P*/ MPT = T.$arrow().getAs(MemberPointerType.class);
          if ((MPT != null)) {
            /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
            if (MPT.isMemberFunctionPointerType()
               && !isa_FunctionTemplateDecl(TD)) {
              mangleMemberFunctionPointer(RD, (/*const*/ CXXMethodDecl /*P*/ )null);
              return;
            }
            if (MPT.isMemberDataPointer()) {
              if (!isa_FunctionTemplateDecl(TD)) {
                mangleMemberDataPointer(RD, (/*const*/ ValueDecl /*P*/ )null);
                return;
              }
              // nullptr data pointers are always represented with a single field
              // which is initialized with either 0 or -1.  Why -1?  Well, we need to
              // distinguish the case where the data member is at offset zero in the
              // record.
              // However, we are free to use 0 *if* we would use multiple fields for
              // non-nullptr member pointers.
              if (!RD.nullFieldOffsetIsZero()) {
                mangleIntegerLiteral(APSInt.get(-1), /*IsBoolean=*/ false);
                return;
              }
            }
          }
        }
        mangleIntegerLiteral(APSInt.getUnsigned($int2ulong(0)), /*IsBoolean=*/ false);
        break;
      }
     case Expression:
      mangleExpression(TA.getAsExpr());
      break;
     case Pack:
      {
        ArrayRef<TemplateArgument> TemplateArgs = TA.getPackAsArray();
        if (TemplateArgs.empty()) {
          if (isa_TemplateTypeParmDecl(Parm)
             || isa_TemplateTemplateParmDecl(Parm)) {
            // MSVC 2015 changed the mangling for empty expanded template packs,
            // use the old mangling for link compatibility for old versions.
            Out.$out((Context.getASTContext().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015) ? $("$$V") : $("$$$V")));
          } else if (isa_NonTypeTemplateParmDecl(Parm)) {
            Out.$out(/*KEEP_STR*/"$S");
          } else {
            throw new llvm_unreachable("unexpected template parameter decl!");
          }
        } else {
          for (final /*const*/ TemplateArgument /*&*/ PA : TemplateArgs)  {
            mangleTemplateArg(TD, PA, Parm);
          }
        }
        break;
      }
     case Template:
      {
        /*const*/ NamedDecl /*P*/ ND = TA.getAsTemplate().getAsTemplateDecl().getTemplatedDecl();
        {
          /*const*/ TagDecl /*P*/ TD$1 = dyn_cast_TagDecl(ND);
          if ((TD$1 != null)) {
            mangleType(TD$1);
          } else if (isa_TypeAliasDecl(ND)) {
            Out.$out(/*KEEP_STR*/"$$Y");
            mangleName(ND);
          } else {
            throw new llvm_unreachable("unexpected template template NamedDecl!");
          }
        }
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXNameMangler::~MicrosoftCXXNameMangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 246,
   FQN="(anonymous namespace)::MicrosoftCXXNameMangler::~MicrosoftCXXNameMangler", NM="_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_123MicrosoftCXXNameManglerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PassObjectSizeArgs.$destroy();
    TypeBackReferences.$destroy();
    NameBackReferences.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + Context // NOI18N
              + ", Out=" + Out // NOI18N
              + ", Structor=" + Structor // NOI18N
              + ", StructorType=" + StructorType // NOI18N
              + ", NameBackReferences=" + NameBackReferences // NOI18N
              + ", TypeBackReferences=" + TypeBackReferences // NOI18N
              + ", PassObjectSizeArgs=" + PassObjectSizeArgs // NOI18N
              + ", PointersAre64Bit=" + PointersAre64Bit; // NOI18N
  }
}
