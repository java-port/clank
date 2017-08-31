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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.DeclStatics.*;
import org.clang.ast.java.ExternC;
import org.clang.basic.java.OptionalNotes;


/// VarDecl - An instance of this class is created to represent a variable
/// declaration or definition.
//<editor-fold defaultstate="collapsed" desc="clang::VarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 768,
 FQN="clang::VarDecl", NM="_ZN5clang7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDeclE")
//</editor-fold>
public class VarDecl extends /*public*/ DeclaratorDecl implements /*public*/ Redeclarable<VarDecl>, ExternC, Destructors.ClassWithDestructor {
/*public:*/
  /// getStorageClassSpecifierString - Return the string used to
  /// specify the storage class \p SC.
  ///
  /// It is illegal to call this function with SC == None.
  
  //===----------------------------------------------------------------------===//
  // VarDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getStorageClassSpecifierString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1770,
   FQN="clang::VarDecl::getStorageClassSpecifierString", NM="_ZN5clang7VarDecl30getStorageClassSpecifierStringENS_12StorageClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl30getStorageClassSpecifierStringENS_12StorageClassE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getStorageClassSpecifierString(StorageClass SC) {
    switch (SC) {
     case SC_None:
      break;
     case SC_Auto:
      return $auto;
     case SC_Extern:
      return $extern;
     case SC_PrivateExtern:
      return $__private_extern__;
     case SC_Register:
      return $register;
     case SC_Static:
      return $static;
    }
    throw new llvm_unreachable("Invalid storage class");
  }

  
  /// \brief Initialization styles.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::InitializationStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 777,
   FQN="clang::VarDecl::InitializationStyle", NM="_ZN5clang7VarDecl19InitializationStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl19InitializationStyleE")
  //</editor-fold>
  public enum InitializationStyle implements Native.ComparableLower {
    CInit(0), ///< C-style initialization with assignment
    CallInit(CInit.getValue() + 1), ///< Call-style initialization (C++98)
    ListInit(CallInit.getValue() + 1); ///< Direct list-initialization (C++11)

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InitializationStyle valueOf(int val) {
      InitializationStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InitializationStyle[] VALUES;
      private static final InitializationStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InitializationStyle kind : InitializationStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InitializationStyle[min < 0 ? (1-min) : 0];
        VALUES = new InitializationStyle[max >= 0 ? (1+max) : 0];
        for (InitializationStyle kind : InitializationStyle.values()) {
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
    private InitializationStyle(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InitializationStyle)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InitializationStyle)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Kinds of thread-local storage.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::TLSKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 784,
   FQN="clang::VarDecl::TLSKind", NM="_ZN5clang7VarDecl7TLSKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl7TLSKindE")
  //</editor-fold>
  public enum TLSKind implements Native.ComparableLower {
    TLS_None(0), ///< Not a TLS variable.
    TLS_Static(TLS_None.getValue() + 1), ///< TLS with a known-constant initializer.
    TLS_Dynamic(TLS_Static.getValue() + 1); ///< TLS with a dynamic initializer.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TLSKind valueOf(int val) {
      TLSKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TLSKind[] VALUES;
      private static final TLSKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TLSKind kind : TLSKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TLSKind[min < 0 ? (1-min) : 0];
        VALUES = new TLSKind[max >= 0 ? (1+max) : 0];
        for (TLSKind kind : TLSKind.values()) {
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
    private TLSKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TLSKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TLSKind)obj).value);}
    //</editor-fold>
  };
/*protected:*/
  // A pointer union of Stmt * and EvaluatedStmt *. When an EvaluatedStmt, we
  // have allocated the auxilliary struct of information there.
  //
  // TODO: It is a bit unfortunate to use a PointerUnion inside the VarDecl for
  // this as *many* VarDecls are ParmVarDecls that don't have default
  // arguments. We could save some space by moving this pointer union to be
  // allocated in trailing space when necessary.
  /*typedef llvm::PointerUnion<Stmt *, EvaluatedStmt *> InitType*/
//  public final class InitType extends PointerUnion<Stmt /*P*/ , EvaluatedStmt /*P*/ >{ };
  
  /// \brief The initializer for this variable or, for a ParmVarDecl, the
  /// C++ default argument.
  protected /*mutable */PointerUnion<Stmt /*P*/ , EvaluatedStmt /*P*/ > Init;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::VarDeclBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 805,
   FQN="clang::VarDecl::VarDeclBitfields", NM="_ZN5clang7VarDecl16VarDeclBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl16VarDeclBitfieldsE")
  //</editor-fold>
  /*friend*/public static class VarDeclBitfields {
    /*friend  class VarDecl*/
    /*friend  class ASTDeclReader*/
    
    /*friend*/public /*JBYTE unsigned int*/ byte SClass /*: 3*/;
    /*friend*/public /*JBYTE unsigned int*/ byte TSCSpec /*: 2*/;
    /*friend*/public /*JBYTE unsigned int*/ byte InitStyle /*: 2*/;
    
    @Override public String toString() {
      return "" + "SClass=" + $uchar2uint(SClass) // NOI18N
                + ", TSCSpec=" + $uchar2uint(TSCSpec) // NOI18N
                + ", InitStyle=" + $uchar2uint(InitStyle); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 813,
   FQN="clang::VarDecl::(anonymous)", NM="_ZN5clang7VarDeclE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDeclE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumVarDeclBits = 7;
  /*}*/;
  
  /*friend  class ASTDeclReader*/
  /*friend  class StmtIteratorBase*/
  /*friend  class ASTNodeImporter*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 820,
   FQN="clang::VarDecl::(anonymous)", NM="_ZN5clang7VarDeclE_Unnamed_enum3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDeclE_Unnamed_enum3")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumParameterIndexBits = 8;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::DefaultArgKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 822,
   FQN="clang::VarDecl::DefaultArgKind", NM="_ZN5clang7VarDecl14DefaultArgKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl14DefaultArgKindE")
  //</editor-fold>
  protected enum DefaultArgKind implements Native.ComparableLower {
    DAK_None(0),
    DAK_Unparsed(DAK_None.getValue() + 1),
    DAK_Uninstantiated(DAK_Unparsed.getValue() + 1),
    DAK_Normal(DAK_Uninstantiated.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DefaultArgKind valueOf(int val) {
      DefaultArgKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DefaultArgKind[] VALUES;
      private static final DefaultArgKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DefaultArgKind kind : DefaultArgKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DefaultArgKind[min < 0 ? (1-min) : 0];
        VALUES = new DefaultArgKind[max >= 0 ? (1+max) : 0];
        for (DefaultArgKind kind : DefaultArgKind.values()) {
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
    private DefaultArgKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DefaultArgKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DefaultArgKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::ParmVarDeclBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 829,
   FQN="clang::VarDecl::ParmVarDeclBitfields", NM="_ZN5clang7VarDecl20ParmVarDeclBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl20ParmVarDeclBitfieldsE")
  //</editor-fold>
  /*friend*/public static class ParmVarDeclBitfields {
    /*friend  class ParmVarDecl*/
    /*friend  class ASTDeclReader*/
    
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumVarDeclBits*/;
    
    /// Whether this parameter inherits a default argument from a
    /// prior declaration.
    public/*private*/ /*JBIT unsigned int*/ boolean HasInheritedDefaultArg /*: 1*/;
    
    /// Describes the kind of default argument for this parameter. By default
    /// this is none. If this is normal, then the default argument is stored in
    /// the \c VarDecl initalizer expression unless we were unble to parse
    /// (even an invalid) expression for the default argument.
    protected/*private*/ /*JBYTE unsigned int*/ byte DefaultArgKind /*: 2*/;
    
    /// Whether this parameter undergoes K&R argument promotion.
    public/*private*/ /*JBIT unsigned int*/ boolean IsKNRPromoted /*: 1*/;
    
    /// Whether this parameter is an ObjC method parameter or not.
    protected/*private*/ /*JBIT unsigned int*/ boolean IsObjCMethodParam /*: 1*/;
    
    /// If IsObjCMethodParam, a Decl::ObjCDeclQualifier.
    /// Otherwise, the number of function parameter scopes enclosing
    /// the function parameter scope in which this parameter was
    /// declared.
    public/*private*/ /*JBYTE unsigned int*/ byte ScopeDepthOrObjCQuals /*: 7*/;
    
    /// The number of parameters preceding this parameter in the
    /// function parameter scope in which it was declared.
    protected/*private*/ /*JBYTE unsigned int*/ byte ParameterIndex /*: NumParameterIndexBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", HasInheritedDefaultArg=" + HasInheritedDefaultArg // NOI18N
                + ", DefaultArgKind=" + $uchar2uint(DefaultArgKind) // NOI18N
                + ", IsKNRPromoted=" + IsKNRPromoted // NOI18N
                + ", IsObjCMethodParam=" + IsObjCMethodParam // NOI18N
                + ", ScopeDepthOrObjCQuals=" + $uchar2uint(ScopeDepthOrObjCQuals) // NOI18N
                + ", ParameterIndex=" + $uchar2uint(ParameterIndex); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::NonParmVarDeclBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 862,
   FQN="clang::VarDecl::NonParmVarDeclBitfields", NM="_ZN5clang7VarDecl23NonParmVarDeclBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl23NonParmVarDeclBitfieldsE")
  //</editor-fold>
  /*friend*/public static class NonParmVarDeclBitfields {
    /*friend  class VarDecl*/
    /*friend  class ASTDeclReader*/
    
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumVarDeclBits*/;
    
    /// \brief Whether this variable is the exception variable in a C++ catch
    /// or an Objective-C @catch statement.
    /*friend*/public /*JBIT unsigned int*/ boolean ExceptionVar /*: 1*/;
    
    /// \brief Whether this local variable could be allocated in the return
    /// slot of its function, enabling the named return value optimization
    /// (NRVO).
    /*friend*/public /*JBIT unsigned int*/ boolean NRVOVariable /*: 1*/;
    
    /// \brief Whether this variable is the for-range-declaration in a C++0x
    /// for-range statement.
    /*friend*/public /*JBIT unsigned int*/ boolean CXXForRangeDecl /*: 1*/;
    
    /// \brief Whether this variable is an ARC pseudo-__strong
    /// variable;  see isARCPseudoStrong() for details.
    /*friend*/public /*JBIT unsigned int*/ boolean ARCPseudoStrong /*: 1*/;
    
    /// \brief Whether this variable is (C++1z) inline.
    /*friend*/public /*JBIT unsigned int*/ boolean IsInline /*: 1*/;
    
    /// \brief Whether this variable has (C++1z) inline explicitly specified.
    /*friend*/public /*JBIT unsigned int*/ boolean IsInlineSpecified /*: 1*/;
    
    /// \brief Whether this variable is (C++0x) constexpr.
    /*friend*/public /*JBIT unsigned int*/ boolean IsConstexpr /*: 1*/;
    
    /// \brief Whether this variable is the implicit variable for a lambda
    /// init-capture.
    /*friend*/public /*JBIT unsigned int*/ boolean IsInitCapture /*: 1*/;
    
    /// \brief Whether this local extern variable's previous declaration was
    /// declared in the same block scope. This controls whether we should merge
    /// the type of this declaration with its previous declaration.
    /*friend*/public /*JBIT unsigned int*/ boolean PreviousDeclInSameBlockScope /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", ExceptionVar=" + ExceptionVar // NOI18N
                + ", NRVOVariable=" + NRVOVariable // NOI18N
                + ", CXXForRangeDecl=" + CXXForRangeDecl // NOI18N
                + ", ARCPseudoStrong=" + ARCPseudoStrong // NOI18N
                + ", IsInline=" + IsInline // NOI18N
                + ", IsInlineSpecified=" + IsInlineSpecified // NOI18N
                + ", IsConstexpr=" + IsConstexpr // NOI18N
                + ", IsInitCapture=" + IsInitCapture // NOI18N
                + ", PreviousDeclInSameBlockScope=" + PreviousDeclInSameBlockScope; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL/*init fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 904,
   FQN="clang::VarDecl::(anonymous)", NM="_ZN5clang7VarDeclE_Unnamed_union4",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDeclE_Unnamed_union4")
  //</editor-fold>
  /*friend*/public static class/*union*/ Unnamed_union4 {
    public /*uint*/int AllBits;
    public VarDeclBitfields VarDeclBits = new VarDeclBitfields();
    public ParmVarDeclBitfields ParmVarDeclBits = new ParmVarDeclBitfields();
    public NonParmVarDeclBitfields NonParmVarDeclBits = new NonParmVarDeclBitfields();
    
    @Override public String toString() {
      return "" + "AllBits=" + AllBits // NOI18N
                + ", VarDeclBits=" + VarDeclBits // NOI18N
                + ", ParmVarDeclBits=" + ParmVarDeclBits // NOI18N
                + ", NonParmVarDeclBits=" + NonParmVarDeclBits; // NOI18N
    }
  };
  /*friend*/public Unnamed_union4 Unnamed_field1 = new Unnamed_union4();
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::VarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1783,
   FQN="clang::VarDecl::VarDecl", NM="_ZN5clang7VarDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE")
  //</editor-fold>
  protected VarDecl(Kind DK, final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation StartLoc, SourceLocation IdLoc, 
      IdentifierInfo /*P*/ Id, QualType T, TypeSourceInfo /*P*/ TInfo, 
      StorageClass SC) {
    // : DeclaratorDecl(DK, DC, IdLoc, Id, T, TInfo, StartLoc), redeclarable_base(C), Init() 
    //START JInit
    super(DK, DC, new SourceLocation(IdLoc), new DeclarationName(Id), new QualType(T), TInfo, new SourceLocation(StartLoc));
    this.Redeclarable$Flds = $Redeclarable(C);
    this.Init = new PointerUnion<Stmt /*P*/ , EvaluatedStmt /*P*/ >(Stmt /*P*/.class);
    //END JInit
    static_assert($lesseq_uint($sizeof_VarDeclBitfields(), $sizeof_UInt()), $("VarDeclBitfields too large!"));
    static_assert($lesseq_uint($sizeof_ParmVarDeclBitfields(), $sizeof_UInt()), $("ParmVarDeclBitfields too large!"));
    static_assert($lesseq_uint($sizeof_NonParmVarDeclBitfields(), $sizeof_UInt()), $("NonParmVarDeclBitfields too large!"));
    Unnamed_field1.AllBits = 0;
    Unnamed_field1.VarDeclBits.SClass = $uint2uint_3bits(SC.getValue());
    // Everything else is implicitly initialized to false.
  }

  
  /*typedef Redeclarable<VarDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<VarDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 916,
   FQN="clang::VarDecl::getNextRedeclarationImpl", NM="_ZN5clang7VarDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected VarDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 919,
   FQN="clang::VarDecl::getPreviousDeclImpl", NM="_ZN5clang7VarDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected VarDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 922,
   FQN="clang::VarDecl::getMostRecentDeclImpl", NM="_ZN5clang7VarDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected VarDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*public:*/
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<VarDecl /*P*/ >{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<VarDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<VarDecl>::redecls_begin;
  //JAVA: using Redeclarable<VarDecl>::redecls_end;
  //JAVA: using Redeclarable<VarDecl>::redecls;
  //JAVA: using Redeclarable<VarDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<VarDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<VarDecl>::isFirstDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1800,
   FQN="clang::VarDecl::Create", NM="_ZN5clang7VarDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE")
  //</editor-fold>
  public static VarDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartL, SourceLocation IdL, 
        IdentifierInfo /*P*/ Id, QualType T, TypeSourceInfo /*P*/ TInfo, 
        StorageClass S) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new VarDecl(Kind.Var, C, DC, new SourceLocation(StartL), new SourceLocation(IdL), Id, new QualType(T), TInfo, S);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1807,
   FQN="clang::VarDecl::CreateDeserialized", NM="_ZN5clang7VarDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static VarDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new VarDecl(Kind.Var, C, (DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), (IdentifierInfo /*P*/ )null, 
                new QualType(), (TypeSourceInfo /*P*/ )null, StorageClass.SC_None);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1840,
   FQN="clang::VarDecl::getSourceRange", NM="_ZNK5clang7VarDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    {
      /*const*/ Expr /*P*/ Init = getInit$Const();
      if ((Init != null)) {
        SourceLocation InitEnd = Init.getLocEnd();
        // If Init is implicit, ignore its source range and fallback on 
        // DeclaratorDecl::getSourceRange() to handle postfix elements.
        if (InitEnd.isValid() && $noteq_SourceLocation$C(InitEnd, getLocation())) {
          return new SourceRange(getOuterLocStart(), /*NO_COPY*/InitEnd);
        }
      }
    }
    return super.getSourceRange();
  }

  
  /// \brief Returns the storage class as written in the source. For the
  /// computed linkage of symbol, see getLinkage.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 947,
   FQN="clang::VarDecl::getStorageClass", NM="_ZNK5clang7VarDecl15getStorageClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl15getStorageClassEv")
  //</editor-fold>
  public StorageClass getStorageClass() /*const*/ {
    return StorageClass.valueOf(Unnamed_field1.VarDeclBits.SClass);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1813,
   FQN="clang::VarDecl::setStorageClass", NM="_ZN5clang7VarDecl15setStorageClassENS_12StorageClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl15setStorageClassENS_12StorageClassE")
  //</editor-fold>
  public void setStorageClass(StorageClass SC) {
    assert (isLegalForVariable(SC));
    Unnamed_field1.VarDeclBits.SClass = $uint2uint_3bits(SC.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setTSCSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 952,
   FQN="clang::VarDecl::setTSCSpec", NM="_ZN5clang7VarDecl10setTSCSpecENS_27ThreadStorageClassSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl10setTSCSpecENS_27ThreadStorageClassSpecifierE")
  //</editor-fold>
  public void setTSCSpec(ThreadStorageClassSpecifier TSC) {
    Unnamed_field1.VarDeclBits.TSCSpec = $uint2uint_2bits(TSC.getValue());
    assert (Unnamed_field1.VarDeclBits.TSCSpec == $int2uint_2bits(TSC.getValue())) : "truncation";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getTSCSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 956,
   FQN="clang::VarDecl::getTSCSpec", NM="_ZNK5clang7VarDecl10getTSCSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl10getTSCSpecEv")
  //</editor-fold>
  public ThreadStorageClassSpecifier getTSCSpec() /*const*/ {
    return /*static_cast*/ThreadStorageClassSpecifier.valueOf(Unnamed_field1.VarDeclBits.TSCSpec);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getTLSKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1818,
   FQN="clang::VarDecl::getTLSKind", NM="_ZNK5clang7VarDecl10getTLSKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl10getTLSKindEv")
  //</editor-fold>
  public VarDecl.TLSKind getTLSKind() /*const*/ {
    switch (ThreadStorageClassSpecifier.valueOf(Unnamed_field1.VarDeclBits.TSCSpec)) {
     case TSCS_unspecified:
      if (!hasAttr(ThreadAttr.class)
         && !(getASTContext().getLangOpts().OpenMPUseTLS
         && getASTContext().getTargetInfo().isTLSSupported()
         && hasAttr(OMPThreadPrivateDeclAttr.class))) {
        return TLSKind.TLS_None;
      }
      return ((getASTContext().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015))
         || hasAttr(OMPThreadPrivateDeclAttr.class)) ? TLSKind.TLS_Dynamic : TLSKind.TLS_Static;
     case TSCS___thread: // Fall through.
     case TSCS__Thread_local:
      return TLSKind.TLS_Static;
     case TSCS_thread_local:
      return TLSKind.TLS_Dynamic;
    }
    throw new llvm_unreachable("Unknown thread storage class specifier!");
  }

  
  /// hasLocalStorage - Returns true if a variable with function scope
  ///  is a non-static local variable.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::hasLocalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 963,
   FQN="clang::VarDecl::hasLocalStorage", NM="_ZNK5clang7VarDecl15hasLocalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl15hasLocalStorageEv")
  //</editor-fold>
  public boolean hasLocalStorage() /*const*/ {
    if (getStorageClass() == StorageClass.SC_None) {
      // Second check is for C++11 [dcl.stc]p4.
      return !isFileVarDecl() && getTSCSpec() == ThreadStorageClassSpecifier.TSCS_unspecified;
    }
    
    // Global Named Register (GNU extension)
    if (getStorageClass() == StorageClass.SC_Register && !isLocalVarDeclOrParm()) {
      return false;
    }
    
    // Return true for:  Auto, Register.
    // Return false for: Extern, Static, PrivateExtern, OpenCLWorkGroupLocal.
    return getStorageClass().getValue() >= StorageClass.SC_Auto.getValue();
  }

  
  /// isStaticLocal - Returns true if a variable with function scope is a
  /// static local variable.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isStaticLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 980,
   FQN="clang::VarDecl::isStaticLocal", NM="_ZNK5clang7VarDecl13isStaticLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13isStaticLocalEv")
  //</editor-fold>
  public boolean isStaticLocal() /*const*/ {
    return (getStorageClass() == StorageClass.SC_Static
      // C++11 [dcl.stc]p4
       || (getStorageClass() == StorageClass.SC_None && getTSCSpec() == ThreadStorageClassSpecifier.TSCS_thread_local))
       && !isFileVarDecl();
  }

  
  /// \brief Returns true if a variable has extern or __private_extern__
  /// storage.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::hasExternalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 989,
   FQN="clang::VarDecl::hasExternalStorage", NM="_ZNK5clang7VarDecl18hasExternalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl18hasExternalStorageEv")
  //</editor-fold>
  public boolean hasExternalStorage() /*const*/ {
    return getStorageClass() == StorageClass.SC_Extern
       || getStorageClass() == StorageClass.SC_PrivateExtern;
  }

  
  /// \brief Returns true for all variables that do not have local storage.
  ///
  /// This includes all global variables as well as static variables declared
  /// within a function.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::hasGlobalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 998,
   FQN="clang::VarDecl::hasGlobalStorage", NM="_ZNK5clang7VarDecl16hasGlobalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl16hasGlobalStorageEv")
  //</editor-fold>
  public boolean hasGlobalStorage() /*const*/ {
    return !hasLocalStorage();
  }

  
  /// \brief Get the storage duration of this variable, per C++ [basic.stc].
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getStorageDuration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1001,
   FQN="clang::VarDecl::getStorageDuration", NM="_ZNK5clang7VarDecl18getStorageDurationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl18getStorageDurationEv")
  //</editor-fold>
  public StorageDuration getStorageDuration() /*const*/ {
    return hasLocalStorage() ? StorageDuration.SD_Automatic : (getTSCSpec().getValue() != 0) ? StorageDuration.SD_Thread : StorageDuration.SD_Static;
  }

  
  /// \brief Compute the language linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getLanguageLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1892,
   FQN="clang::VarDecl::getLanguageLinkage", NM="_ZNK5clang7VarDecl18getLanguageLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl18getLanguageLinkageEv")
  //</editor-fold>
  public LanguageLinkage getLanguageLinkage() /*const*/ {
    return getDeclLanguageLinkage(/*Deref*/this);
  }

  
  /// \brief Determines whether this variable is a variable with
  /// external, C linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isExternC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1896,
   FQN="clang::VarDecl::isExternC", NM="_ZNK5clang7VarDecl9isExternCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl9isExternCEv")
  //</editor-fold>
  public boolean isExternC() /*const*/ {
    return isDeclExternC(/*Deref*/this);
  }

  
  /// \brief Determines whether this variable's context is, or is nested within,
  /// a C++ extern "C" linkage spec.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInExternCContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1900,
   FQN="clang::VarDecl::isInExternCContext", NM="_ZNK5clang7VarDecl18isInExternCContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl18isInExternCContextEv")
  //</editor-fold>
  public boolean isInExternCContext() /*const*/ {
    return getLexicalDeclContext$Const().isExternCContext();
  }

  
  /// \brief Determines whether this variable's context is, or is nested within,
  /// a C++ extern "C++" linkage spec.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInExternCXXContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1904,
   FQN="clang::VarDecl::isInExternCXXContext", NM="_ZNK5clang7VarDecl20isInExternCXXContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl20isInExternCXXContextEv")
  //</editor-fold>
  public boolean isInExternCXXContext() /*const*/ {
    return getLexicalDeclContext$Const().isExternCXXContext();
  }

  
  /// isLocalVarDecl - Returns true for local variable declarations
  /// other than parameters.  Note that this includes static variables
  /// inside of functions. It also includes variables inside blocks.
  ///
  ///   void foo() { int x; static int y; extern int z; }
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isLocalVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1027,
   FQN="clang::VarDecl::isLocalVarDecl", NM="_ZNK5clang7VarDecl14isLocalVarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl14isLocalVarDeclEv")
  //</editor-fold>
  public boolean isLocalVarDecl() /*const*/ {
    if (getKind() != Decl.Kind.Var) {
      return false;
    }
    {
      /*const*/ DeclContext /*P*/ DC = getLexicalDeclContext$Const();
      if ((DC != null)) {
        return DC.getRedeclContext$Const().isFunctionOrMethod();
      }
    }
    return false;
  }

  
  /// \brief Similar to isLocalVarDecl but also includes parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isLocalVarDeclOrParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1036,
   FQN="clang::VarDecl::isLocalVarDeclOrParm", NM="_ZNK5clang7VarDecl20isLocalVarDeclOrParmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl20isLocalVarDeclOrParmEv")
  //</editor-fold>
  public boolean isLocalVarDeclOrParm() /*const*/ {
    return isLocalVarDecl() || getKind() == Decl.Kind.ParmVar;
  }

  
  /// isFunctionOrMethodVarDecl - Similar to isLocalVarDecl, but
  /// excludes variables declared in blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isFunctionOrMethodVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1042,
   FQN="clang::VarDecl::isFunctionOrMethodVarDecl", NM="_ZNK5clang7VarDecl25isFunctionOrMethodVarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl25isFunctionOrMethodVarDeclEv")
  //</editor-fold>
  public boolean isFunctionOrMethodVarDecl() /*const*/ {
    if (getKind() != Decl.Kind.Var) {
      return false;
    }
    /*const*/ DeclContext /*P*/ DC = getLexicalDeclContext$Const().getRedeclContext$Const();
    return DC.isFunctionOrMethod() && DC.getDeclKind() != Decl.Kind.Block;
  }

  
  /// \brief Determines whether this is a static data member.
  ///
  /// This will only be true in C++, and applies to, e.g., the
  /// variable 'x' in:
  /// \code
  /// struct S {
  ///   static int x;
  /// };
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isStaticDataMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1058,
   FQN="clang::VarDecl::isStaticDataMember", NM="_ZNK5clang7VarDecl18isStaticDataMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl18isStaticDataMemberEv")
  //</editor-fold>
  public boolean isStaticDataMember() /*const*/ {
    // If it wasn't static, it would be a FieldDecl.
    return getKind() != Decl.Kind.ParmVar && getDeclContext$Const().isRecord();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1908,
   FQN="clang::VarDecl::getCanonicalDecl", NM="_ZN5clang7VarDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public VarDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1064,
   FQN="clang::VarDecl::getCanonicalDecl", NM="_ZNK5clang7VarDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/VarDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::DefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1068,
   FQN="clang::VarDecl::DefinitionKind", NM="_ZN5clang7VarDecl14DefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl14DefinitionKindE")
  //</editor-fold>
  public enum DefinitionKind implements Native.ComparableLower {
    DeclarationOnly(0), ///< This declaration is only a declaration.
    TentativeDefinition(DeclarationOnly.getValue() + 1), ///< This declaration is a tentative definition.
    Definition(TentativeDefinition.getValue() + 1); ///< This declaration is definitely a definition.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DefinitionKind valueOf(int val) {
      DefinitionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DefinitionKind[] VALUES;
      private static final DefinitionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DefinitionKind kind : DefinitionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DefinitionKind[min < 0 ? (1-min) : 0];
        VALUES = new DefinitionKind[max >= 0 ? (1+max) : 0];
        for (DefinitionKind kind : DefinitionKind.values()) {
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
    private DefinitionKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DefinitionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DefinitionKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Check whether this declaration is a definition. If this could be
  /// a tentative definition (in C), don't check whether there's an overriding
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1910,
   FQN="clang::VarDecl::isThisDeclarationADefinition", NM="_ZNK5clang7VarDecl28isThisDeclarationADefinitionERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl28isThisDeclarationADefinitionERNS_10ASTContextE")
  //</editor-fold>
  public VarDecl.DefinitionKind isThisDeclarationADefinition(final ASTContext /*&*/ C) /*const*/ {
    // C++ [basic.def]p2:
    //   A declaration is a definition unless [...] it contains the 'extern'
    //   specifier or a linkage-specification and neither an initializer [...],
    //   it declares a non-inline static data member in a class declaration [...],
    //   it declares a static data member outside a class definition and the variable
    //   was defined within the class with the constexpr specifier [...],
    // C++1y [temp.expl.spec]p15:
    //   An explicit specialization of a static data member or an explicit
    //   specialization of a static data member template is a definition if the
    //   declaration includes an initializer; otherwise, it is a declaration.
    //
    // FIXME: How do you declare (but not define) a partial specialization of
    // a static data member template outside the containing class?
    if (isStaticDataMember()) {
      if (isOutOfLine()
         && !(getCanonicalDecl$Const().isInline()
         && getCanonicalDecl$Const().isConstexpr())
         && (hasInit()
        // If the first declaration is out-of-line, this may be an
        // instantiation of an out-of-line partial specialization of a variable
        // template for which we have not yet instantiated the initializer.
         || (getFirstDecl$Const().isOutOfLine() ? getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_Undeclared : getTemplateSpecializationKind()
         != TemplateSpecializationKind.TSK_ExplicitSpecialization)
         || isa_VarTemplatePartialSpecializationDecl(this))) {
        return DefinitionKind.Definition;
      } else if (!isOutOfLine() && isInline()) {
        return DefinitionKind.Definition;
      } else {
        return DefinitionKind.DeclarationOnly;
      }
    }
    // C99 6.7p5:
    //   A definition of an identifier is a declaration for that identifier that
    //   [...] causes storage to be reserved for that object.
    // Note: that applies for all non-file-scope objects.
    // C99 6.9.2p1:
    //   If the declaration of an identifier for an object has file scope and an
    //   initializer, the declaration is an external definition for the identifier
    if (hasInit()) {
      return DefinitionKind.Definition;
    }
    if (hasDefiningAttr()) {
      return DefinitionKind.Definition;
    }
    {
      
      /*const*/ SelectAnyAttr /*P*/ SAA = getAttr(SelectAnyAttr.class);
      if ((SAA != null)) {
        if (!SAA.isInherited()) {
          return DefinitionKind.Definition;
        }
      }
    }
    
    // A variable template specialization (other than a static data member
    // template or an explicit specialization) is a declaration until we
    // instantiate its initializer.
    if (isa_VarTemplateSpecializationDecl(this)
       && getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ExplicitSpecialization) {
      return DefinitionKind.DeclarationOnly;
    }
    if (hasExternalStorage()) {
      return DefinitionKind.DeclarationOnly;
    }
    
    // [dcl.link] p7:
    //   A declaration directly contained in a linkage-specification is treated
    //   as if it contains the extern specifier for the purpose of determining
    //   the linkage of the declared name and whether it is a definition.
    if (isSingleLineLanguageLinkage(/*Deref*/this)) {
      return DefinitionKind.DeclarationOnly;
    }
    
    // C99 6.9.2p2:
    //   A declaration of an object that has file scope without an initializer,
    //   and without a storage class specifier or the scs 'static', constitutes
    //   a tentative definition.
    // No such thing in C++.
    if (!C.getLangOpts().CPlusPlus && isFileVarDecl()) {
      return DefinitionKind.TentativeDefinition;
    }
    
    // What's left is (in C, block-scope) declarations without initializers or
    // external storage. These are definitions.
    return DefinitionKind.Definition;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1078,
   FQN="clang::VarDecl::isThisDeclarationADefinition", NM="_ZNK5clang7VarDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public DefinitionKind isThisDeclarationADefinition() /*const*/ {
    return isThisDeclarationADefinition(getASTContext());
  }

  
  /// \brief Check whether this variable is defined in this
  /// translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::hasDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2017,
   FQN="clang::VarDecl::hasDefinition", NM="_ZNK5clang7VarDecl13hasDefinitionERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13hasDefinitionERNS_10ASTContextE")
  //</editor-fold>
  public VarDecl.DefinitionKind hasDefinition(final ASTContext /*&*/ C) /*const*/ {
    DefinitionKind Kind = DefinitionKind.DeclarationOnly;
    
    /*const*/ VarDecl /*P*/ First = getFirstDecl$Const();
    for (VarDecl /*P*/ I : First.redeclarable_redecls()) {
      Kind = std.max(Kind, I.isThisDeclarationADefinition(C));
      if (Kind == DefinitionKind.Definition) {
        break;
      }
    }
    
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::hasDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1085,
   FQN="clang::VarDecl::hasDefinition", NM="_ZNK5clang7VarDecl13hasDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13hasDefinitionEv")
  //</editor-fold>
  public DefinitionKind hasDefinition() /*const*/ {
    return hasDefinition(getASTContext());
  }

  
  /// \brief Get the tentative definition that acts as the real definition in
  /// a TU. Returns null if there is a proper definition available.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getActingDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1991,
   FQN="clang::VarDecl::getActingDefinition", NM="_ZN5clang7VarDecl19getActingDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl19getActingDefinitionEv")
  //</editor-fold>
  public VarDecl /*P*/ getActingDefinition() {
    DefinitionKind Kind = isThisDeclarationADefinition();
    if (Kind != DefinitionKind.TentativeDefinition) {
      return null;
    }
    
    VarDecl /*P*/ LastTentative = null;
    VarDecl /*P*/ First = getFirstDecl();
    for (VarDecl /*P*/ I : First.redeclarable_redecls()) {
      Kind = I.isThisDeclarationADefinition();
      if (Kind == DefinitionKind.Definition) {
        return null;
      } else if (Kind == DefinitionKind.TentativeDefinition) {
        LastTentative = I;
      }
    }
    return LastTentative;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getActingDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1092,
   FQN="clang::VarDecl::getActingDefinition", NM="_ZNK5clang7VarDecl19getActingDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl19getActingDefinitionEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getActingDefinition$Const() /*const*/ {
    return ((/*const_cast*/VarDecl /*P*/ )(this)).getActingDefinition();
  }

  
  /// \brief Get the real (not just tentative) definition for this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2008,
   FQN="clang::VarDecl::getDefinition", NM="_ZN5clang7VarDecl13getDefinitionERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl13getDefinitionERNS_10ASTContextE")
  //</editor-fold>
  public VarDecl /*P*/ getDefinition(final ASTContext /*&*/ C) {
    VarDecl /*P*/ First = getFirstDecl();
    for (VarDecl /*P*/ I : First.redeclarable_redecls()) {
      if (I.isThisDeclarationADefinition(C) == DefinitionKind.Definition) {
        return I;
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1098,
   FQN="clang::VarDecl::getDefinition", NM="_ZNK5clang7VarDecl13getDefinitionERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13getDefinitionERNS_10ASTContextE")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getDefinition$Const(final ASTContext /*&*/ C) /*const*/ {
    return ((/*const_cast*/VarDecl /*P*/ )(this)).getDefinition(C);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1101,
   FQN="clang::VarDecl::getDefinition", NM="_ZN5clang7VarDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl13getDefinitionEv")
  //</editor-fold>
  public VarDecl /*P*/ getDefinition() {
    return getDefinition(getASTContext());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1104,
   FQN="clang::VarDecl::getDefinition", NM="_ZNK5clang7VarDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13getDefinitionEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getDefinition$Const() /*const*/ {
    return ((/*const_cast*/VarDecl /*P*/ )(this)).getDefinition();
  }

  
  /// \brief Determine whether this is or was instantiated from an out-of-line
  /// definition of a static data member.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isOutOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2065,
   FQN="clang::VarDecl::isOutOfLine", NM="_ZNK5clang7VarDecl11isOutOfLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl11isOutOfLineEv")
  //</editor-fold>
  @Override public boolean isOutOfLine() /*const*//* override*/ {
    if (super.isOutOfLine()) {
      return true;
    }
    if (!isStaticDataMember()) {
      return false;
    }
    {
      
      // If this static data member was instantiated from a static data member of
      // a class template, check whether that static data member was defined 
      // out-of-line.
      VarDecl /*P*/ VD = getInstantiatedFromStaticDataMember();
      if ((VD != null)) {
        return VD.isOutOfLine();
      }
    }
    
    return false;
  }

  
  /// isFileVarDecl - Returns true for file scoped variable declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isFileVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1113,
   FQN="clang::VarDecl::isFileVarDecl", NM="_ZNK5clang7VarDecl13isFileVarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13isFileVarDeclEv")
  //</editor-fold>
  public boolean isFileVarDecl() /*const*/ {
    Kind K = getKind();
    if (K == Kind.ParmVar || K == Kind.ImplicitParam) {
      return false;
    }
    if (getLexicalDeclContext$Const().getRedeclContext$Const().isFileContext()) {
      return true;
    }
    if (isStaticDataMember()) {
      return true;
    }
    
    return false;
  }

  
  /// getAnyInitializer - Get the initializer for this variable, no matter which
  /// declaration it is attached to.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getAnyInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1129,
   FQN="clang::VarDecl::getAnyInitializer", NM="_ZNK5clang7VarDecl17getAnyInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl17getAnyInitializerEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getAnyInitializer() /*const*/ {
    type$ref</*const*/ VarDecl /*P*/ > D = create_type$ref();
    return getAnyInitializer(D);
  }

  
  /// getAnyInitializer - Get the initializer for this variable, no matter which
  /// declaration it is attached to. Also get that declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getAnyInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2030,
   FQN="clang::VarDecl::getAnyInitializer", NM="_ZNK5clang7VarDecl17getAnyInitializerERPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl17getAnyInitializerERPKS0_")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getAnyInitializer(final type$ref</*const*/ VarDecl /*P*/ /*&*/> D) /*const*/ {
    for (VarDecl /*P*/ I : redeclarable_redecls()) {
      {
        Expr /*P*/ $Expr = I.getInit();
        if (($Expr != null)) {
          D.$set(I);
          return $Expr;
        }
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::hasInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2040,
   FQN="clang::VarDecl::hasInit", NM="_ZNK5clang7VarDecl7hasInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl7hasInitEv")
  //</editor-fold>
  public boolean hasInit() /*const*/ {
    {
      /*const*/ ParmVarDecl /*P*/ P = dyn_cast_ParmVarDecl(this);
      if ((P != null)) {
        if (P.hasUnparsedDefaultArg() || P.hasUninstantiatedDefaultArg()) {
          return false;
        }
      }
    }
    
    return !Init.isNull();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1139,
   FQN="clang::VarDecl::getInit", NM="_ZNK5clang7VarDecl7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl7getInitEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInit$Const() /*const*/ {
    return ((/*const_cast*/VarDecl /*P*/ )(this)).getInit();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2048,
   FQN="clang::VarDecl::getInit", NM="_ZN5clang7VarDecl7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl7getInitEv")
  //</editor-fold>
  public Expr /*P*/ getInit() {
    if (!hasInit()) {
      return null;
    }
    {
      
      Stmt /*P*/ S = Init.dyn_cast(Stmt /*P*/.class);
      if ((S != null)) {
        return cast_Expr(S);
      }
    }
    
    return cast_or_null_Expr(Init.get(EvaluatedStmt /*P*/.class).Value);
  }

  
  /// \brief Retrieve the address of the initializer expression.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getInitAddress">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2058,
   FQN="clang::VarDecl::getInitAddress", NM="_ZN5clang7VarDecl14getInitAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl14getInitAddressEv")
  //</editor-fold>
  public type$ptr<Stmt /*P*/ /*P*/> getInitAddress() {
    {
      final EvaluatedStmt /*P*/ ES = Init.dyn_cast(EvaluatedStmt /*P*/.class);
      if ((ES != null)) {
        return /*AddrOf*/new type$ptr$inout<Stmt /*P*/>(this) {
          @Override public Stmt/*P*/ $star$impl() { return ES.Value; }
          @Override public Stmt/*P*/ $set$impl(Stmt/*P*/ value) { return ES.Value = value; }
        };
      }
    }
    
    return Init.getAddrOfPtr1(Stmt /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2081,
   FQN="clang::VarDecl::setInit", NM="_ZN5clang7VarDecl7setInitEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl7setInitEPNS_4ExprE")
  //</editor-fold>
  public void setInit(Expr /*P*/ I) {
    {
      EvaluatedStmt /*P*/ Eval = Init.dyn_cast(EvaluatedStmt /*P*/.class);
      if ((Eval != null)) {
        Eval.$destroy();
        getASTContext().Deallocate(Eval);
      }
    }
    
    Init.$assign_T$C$R(Stmt /*P*/ /*const*/ /*&*/.class, I);
  }

  
  /// \brief Determine whether this variable's value can be used in a
  /// constant expression, according to the relevant language standard.
  /// This only checks properties of the declaration, and does not check
  /// whether the initializer is in fact a constant expression.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isUsableInConstantExpressions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2090,
   FQN="clang::VarDecl::isUsableInConstantExpressions", NM="_ZNK5clang7VarDecl29isUsableInConstantExpressionsERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl29isUsableInConstantExpressionsERNS_10ASTContextE")
  //</editor-fold>
  public boolean isUsableInConstantExpressions(final ASTContext /*&*/ C) /*const*/ {
    final /*const*/ LangOptions /*&*/ Lang = C.getLangOpts();
    if (!Lang.CPlusPlus) {
      return false;
    }
    
    // In C++11, any variable of reference type can be used in a constant
    // expression if it is initialized by a constant expression.
    if (Lang.CPlusPlus11 && getType().$arrow().isReferenceType()) {
      return true;
    }
    
    // Only const objects can be used in constant expressions in C++. C++98 does
    // not require the variable to be non-volatile, but we consider this to be a
    // defect.
    if (!getType().isConstQualified() || getType().isVolatileQualified()) {
      return false;
    }
    
    // In C++, const, non-volatile variables of integral or enumeration types
    // can be used in constant expressions.
    if (getType().$arrow().isIntegralOrEnumerationType()) {
      return true;
    }
    
    // Additionally, in C++11, non-volatile constexpr variables can be used in
    // constant expressions.
    return Lang.CPlusPlus11 && isConstexpr();
  }

  
  
  /// Convert the initializer for this declaration to the elaborated EvaluatedStmt
  /// form, which contains extra information on the evaluated value of the
  /// initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::ensureEvaluatedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2120,
   FQN="clang::VarDecl::ensureEvaluatedStmt", NM="_ZNK5clang7VarDecl19ensureEvaluatedStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl19ensureEvaluatedStmtEv")
  //</editor-fold>
  public EvaluatedStmt /*P*/ ensureEvaluatedStmt() /*const*/ {
    EvaluatedStmt /*P*/ Eval = Init.dyn_cast(EvaluatedStmt /*P*/.class);
    if (!(Eval != null)) {
      // Note: EvaluatedStmt contains an APValue, which usually holds
      // resources not allocated from the ASTContext.  We need to do some
      // work to avoid leaking those, but we do so in VarDecl::evaluateValue
      // where we can detect whether there's anything to clean up or not.
      Eval = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
          return new EvaluatedStmt();
       });
      Eval.Value = Init.get(Stmt /*P*/.class);
      Init.$assign_T1$C$R(EvaluatedStmt /*P*/ /*const*/ /*&*/.class, Eval);
    }
    return Eval;
  }

  
  /// \brief Attempt to evaluate the value of the initializer attached to this
  /// declaration, and produce notes explaining why it cannot be evaluated or is
  /// not a constant expression. Returns a pointer to the value if evaluation
  /// succeeded, 0 otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::evaluateValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2134,
   FQN="clang::VarDecl::evaluateValue", NM="_ZNK5clang7VarDecl13evaluateValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13evaluateValueEv")
  //</editor-fold>
  public APValue /*P*/ evaluateValue() /*const*/ {
    OptionalNotes Notes = null;
    try {
      Notes/*J*/= new OptionalNotes(8);
      return evaluateValue(Notes);
    } finally {
      if (Notes != null) { Notes.$destroy(); }
    }
  }

  // namespace
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::evaluateValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2146,
   FQN="clang::VarDecl::evaluateValue", NM="_ZNK5clang7VarDecl13evaluateValueERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13evaluateValueERN4llvm15SmallVectorImplISt4pairINS_14SourceLocationENS_17PartialDiagnosticEEEE")
  //</editor-fold>
  public APValue /*P*/ evaluateValue(final OptionalNotes /*&*/ Notes) /*const*/ {
    EvaluatedStmt /*P*/ Eval = ensureEvaluatedStmt();
    
    // We only produce notes indicating why an initializer is non-constant the
    // first time it is evaluated. FIXME: The notes won't always be emitted the
    // first time we try evaluation, so might not be produced at all.
    if (Eval.WasEvaluated) {
      return Eval.Evaluated.isUninit() ? null : $AddrOf(Eval.Evaluated);
    }
    
    /*const*/ Expr /*P*/ Init = cast_Expr(Eval.Value);
    assert (!Init.isValueDependent());
    if (Eval.IsEvaluating) {
      // FIXME: Produce a diagnostic for self-initialization.
      Eval.CheckedICE = true;
      Eval.IsICE = false;
      return null;
    }
    
    Eval.IsEvaluating = true;
    
    boolean Result = Init.EvaluateAsInitializer(Eval.Evaluated, getASTContext(), 
        this, Notes);
    
    // Ensure the computed APValue is cleaned up later if evaluation succeeded,
    // or that it's empty (so that there's nothing to clean up) if evaluation
    // failed.
    if (!Result) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Eval.Evaluated.$assign($c$.track(new APValue())));
      } finally {
        $c$.$destroy();
      }
    } else if (Eval.Evaluated.needsCleanup()) {
      getASTContext().AddDeallocation(DeclStatics::/*FuncRef*/DestroyAPValue, $AddrOf(Eval.Evaluated));
    }
    
    Eval.IsEvaluating = false;
    Eval.WasEvaluated = true;
    
    // In C++11, we have determined whether the initializer was a constant
    // expression as a side-effect.
    if (getASTContext().getLangOpts().CPlusPlus11 && !Eval.CheckedICE) {
      Eval.CheckedICE = true;
      Eval.IsICE = Result && Notes.empty();
    }
    
    return Result ? $AddrOf(Eval.Evaluated) : null;
  }

  
  /// \brief Return the already-evaluated value of this variable's
  /// initializer, or NULL if the value is not yet known. Returns pointer
  /// to untyped APValue if the value could not be evaluated.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getEvaluatedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2192,
   FQN="clang::VarDecl::getEvaluatedValue", NM="_ZNK5clang7VarDecl17getEvaluatedValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl17getEvaluatedValueEv")
  //</editor-fold>
  public APValue /*P*/ getEvaluatedValue() /*const*/ {
    {
      EvaluatedStmt /*P*/ Eval = Init.dyn_cast(EvaluatedStmt /*P*/.class);
      if ((Eval != null)) {
        if (Eval.WasEvaluated) {
          return $AddrOf(Eval.Evaluated);
        }
      }
    }
    
    return null;
  }

  
  /// \brief Determines whether it is already known whether the
  /// initializer is an integral constant expression or not.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInitKnownICE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2200,
   FQN="clang::VarDecl::isInitKnownICE", NM="_ZNK5clang7VarDecl14isInitKnownICEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl14isInitKnownICEEv")
  //</editor-fold>
  public boolean isInitKnownICE() /*const*/ {
    {
      EvaluatedStmt /*P*/ Eval = Init.dyn_cast(EvaluatedStmt /*P*/.class);
      if ((Eval != null)) {
        return Eval.CheckedICE;
      }
    }
    
    return false;
  }

  
  /// \brief Determines whether the initializer is an integral constant
  /// expression, or in C++11, whether the initializer is a constant
  /// expression.
  ///
  /// \pre isInitKnownICE()
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInitICE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2207,
   FQN="clang::VarDecl::isInitICE", NM="_ZNK5clang7VarDecl9isInitICEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl9isInitICEEv")
  //</editor-fold>
  public boolean isInitICE() /*const*/ {
    assert (isInitKnownICE()) : "Check whether we already know that the initializer is an ICE";
    return Init.get(EvaluatedStmt /*P*/.class).IsICE;
  }

  
  /// \brief Determine whether the value of the initializer attached to this
  /// declaration is an integral constant expression.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::checkInitIsICE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2213,
   FQN="clang::VarDecl::checkInitIsICE", NM="_ZNK5clang7VarDecl14checkInitIsICEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl14checkInitIsICEEv")
  //</editor-fold>
  public boolean checkInitIsICE() /*const*/ {
    // Initializers of weak variables are never ICEs.
    if (isWeak()) {
      return false;
    }
    
    EvaluatedStmt /*P*/ Eval = ensureEvaluatedStmt();
    if (Eval.CheckedICE) {
      // We have already checked whether this subexpression is an
      // integral constant expression.
      return Eval.IsICE;
    }
    
    /*const*/ Expr /*P*/ Init = cast_Expr(Eval.Value);
    assert (!Init.isValueDependent());
    
    // In C++11, evaluate the initializer to check whether it's a constant
    // expression.
    if (getASTContext().getLangOpts().CPlusPlus11) {
      OptionalNotes Notes = null;
      try {
        Notes/*J*/= new OptionalNotes(8);
        evaluateValue(Notes);
        return Eval.IsICE;
      } finally {
        if (Notes != null) { Notes.$destroy(); }
      }
    }
    
    // It's an ICE whether or not the definition we found is
    // out-of-line.  See DR 721 and the discussion in Clang PR
    // 6206 for details.
    if (Eval.CheckingICE) {
      return false;
    }
    Eval.CheckingICE = true;
    
    Eval.IsICE = Init.isIntegerConstantExpr(getASTContext());
    Eval.CheckingICE = false;
    Eval.CheckedICE = true;
    return Eval.IsICE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setInitStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1184,
   FQN="clang::VarDecl::setInitStyle", NM="_ZN5clang7VarDecl12setInitStyleENS0_19InitializationStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl12setInitStyleENS0_19InitializationStyleE")
  //</editor-fold>
  public void setInitStyle(InitializationStyle Style) {
    Unnamed_field1.VarDeclBits.InitStyle = $uint2uint_2bits(Style.getValue());
  }

  
  /// \brief The style of initialization for this declaration.
  ///
  /// C-style initialization is "int x = 1;". Call-style initialization is
  /// a C++98 direct-initializer, e.g. "int x(1);". The Init expression will be
  /// the expression inside the parens or a "ClassType(a,b,c)" class constructor
  /// expression for class types. List-style initialization is C++11 syntax,
  /// e.g. "int x{1};". Clients can distinguish between different forms of
  /// initialization by checking this value. In particular, "int x = {1};" is
  /// C-style, "int x({1})" is call-style, and "int x{1};" is list-style; the
  /// Init expression in all three cases is an InitListExpr.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getInitStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1198,
   FQN="clang::VarDecl::getInitStyle", NM="_ZNK5clang7VarDecl12getInitStyleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl12getInitStyleEv")
  //</editor-fold>
  public InitializationStyle getInitStyle() /*const*/ {
    return /*static_cast*/InitializationStyle.valueOf(Unnamed_field1.VarDeclBits.InitStyle);
  }

  
  /// \brief Whether the initializer is a direct-initializer (list or call).
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isDirectInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1203,
   FQN="clang::VarDecl::isDirectInit", NM="_ZNK5clang7VarDecl12isDirectInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl12isDirectInitEv")
  //</editor-fold>
  public boolean isDirectInit() /*const*/ {
    return getInitStyle() != InitializationStyle.CInit;
  }

  
  /// \brief Determine whether this variable is the exception variable in a
  /// C++ catch statememt or an Objective-C \@catch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isExceptionVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1209,
   FQN="clang::VarDecl::isExceptionVariable", NM="_ZNK5clang7VarDecl19isExceptionVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl19isExceptionVariableEv")
  //</editor-fold>
  public boolean isExceptionVariable() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.ExceptionVar));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setExceptionVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1212,
   FQN="clang::VarDecl::setExceptionVariable", NM="_ZN5clang7VarDecl20setExceptionVariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl20setExceptionVariableEb")
  //</editor-fold>
  public void setExceptionVariable(boolean EV) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.ExceptionVar = EV;
  }

  
  /// \brief Determine whether this local variable can be used with the named
  /// return value optimization (NRVO).
  ///
  /// The named return value optimization (NRVO) works by marking certain
  /// non-volatile local variables of class type as NRVO objects. These
  /// locals can be allocated within the return slot of their containing
  /// function, in which case there is no need to copy the object to the
  /// return slot when returning from the function. Within the function body,
  /// each return that returns the NRVO object will have this variable as its
  /// NRVO candidate.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isNRVOVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1227,
   FQN="clang::VarDecl::isNRVOVariable", NM="_ZNK5clang7VarDecl14isNRVOVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl14isNRVOVariableEv")
  //</editor-fold>
  public boolean isNRVOVariable() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.NRVOVariable));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setNRVOVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1230,
   FQN="clang::VarDecl::setNRVOVariable", NM="_ZN5clang7VarDecl15setNRVOVariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl15setNRVOVariableEb")
  //</editor-fold>
  public void setNRVOVariable(boolean NRVO) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.NRVOVariable = NRVO;
  }

  
  /// \brief Determine whether this variable is the for-range-declaration in
  /// a C++0x for-range statement.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isCXXForRangeDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1237,
   FQN="clang::VarDecl::isCXXForRangeDecl", NM="_ZNK5clang7VarDecl17isCXXForRangeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl17isCXXForRangeDeclEv")
  //</editor-fold>
  public boolean isCXXForRangeDecl() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.CXXForRangeDecl));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setCXXForRangeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1240,
   FQN="clang::VarDecl::setCXXForRangeDecl", NM="_ZN5clang7VarDecl18setCXXForRangeDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl18setCXXForRangeDeclEb")
  //</editor-fold>
  public void setCXXForRangeDecl(boolean FRD) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.CXXForRangeDecl = FRD;
  }

  
  /// \brief Determine whether this variable is an ARC pseudo-__strong
  /// variable.  A pseudo-__strong variable has a __strong-qualified
  /// type but does not actually retain the object written into it.
  /// Generally such variables are also 'const' for safety.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isARCPseudoStrong">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1249,
   FQN="clang::VarDecl::isARCPseudoStrong", NM="_ZNK5clang7VarDecl17isARCPseudoStrongEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl17isARCPseudoStrongEv")
  //</editor-fold>
  public boolean isARCPseudoStrong() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.ARCPseudoStrong));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setARCPseudoStrong">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1252,
   FQN="clang::VarDecl::setARCPseudoStrong", NM="_ZN5clang7VarDecl18setARCPseudoStrongEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl18setARCPseudoStrongEb")
  //</editor-fold>
  public void setARCPseudoStrong(boolean ps) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.ARCPseudoStrong = ps;
  }

  
  /// Whether this variable is (C++1z) inline.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInline">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1258,
   FQN="clang::VarDecl::isInline", NM="_ZNK5clang7VarDecl8isInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl8isInlineEv")
  //</editor-fold>
  public boolean isInline() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.IsInline));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInlineSpecified">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1261,
   FQN="clang::VarDecl::isInlineSpecified", NM="_ZNK5clang7VarDecl17isInlineSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl17isInlineSpecifiedEv")
  //</editor-fold>
  public boolean isInlineSpecified() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.IsInlineSpecified));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setInlineSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1265,
   FQN="clang::VarDecl::setInlineSpecified", NM="_ZN5clang7VarDecl18setInlineSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl18setInlineSpecifiedEv")
  //</editor-fold>
  public void setInlineSpecified() {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.IsInline = true;
    Unnamed_field1.NonParmVarDeclBits.IsInlineSpecified = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setImplicitlyInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1270,
   FQN="clang::VarDecl::setImplicitlyInline", NM="_ZN5clang7VarDecl19setImplicitlyInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl19setImplicitlyInlineEv")
  //</editor-fold>
  public void setImplicitlyInline() {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.IsInline = true;
  }

  
  /// Whether this variable is (C++11) constexpr.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isConstexpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1276,
   FQN="clang::VarDecl::isConstexpr", NM="_ZNK5clang7VarDecl11isConstexprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl11isConstexprEv")
  //</editor-fold>
  public boolean isConstexpr() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.IsConstexpr));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setConstexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1279,
   FQN="clang::VarDecl::setConstexpr", NM="_ZN5clang7VarDecl12setConstexprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl12setConstexprEb")
  //</editor-fold>
  public void setConstexpr(boolean IC) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.IsConstexpr = IC;
  }

  
  /// Whether this variable is the implicit variable for a lambda init-capture.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isInitCapture">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1285,
   FQN="clang::VarDecl::isInitCapture", NM="_ZNK5clang7VarDecl13isInitCaptureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl13isInitCaptureEv")
  //</editor-fold>
  public boolean isInitCapture() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.IsInitCapture));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setInitCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1288,
   FQN="clang::VarDecl::setInitCapture", NM="_ZN5clang7VarDecl14setInitCaptureEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl14setInitCaptureEb")
  //</editor-fold>
  public void setInitCapture(boolean IC) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.IsInitCapture = IC;
  }

  
  /// Whether this local extern variable declaration's previous declaration
  /// was declared in the same block scope. Only correct in C++.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::isPreviousDeclInSameBlockScope">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1295,
   FQN="clang::VarDecl::isPreviousDeclInSameBlockScope", NM="_ZNK5clang7VarDecl30isPreviousDeclInSameBlockScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl30isPreviousDeclInSameBlockScopeEv")
  //</editor-fold>
  public boolean isPreviousDeclInSameBlockScope() /*const*/ {
    return ((isa_ParmVarDecl(this) ? false : Unnamed_field1.NonParmVarDeclBits.PreviousDeclInSameBlockScope));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setPreviousDeclInSameBlockScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1300,
   FQN="clang::VarDecl::setPreviousDeclInSameBlockScope", NM="_ZN5clang7VarDecl31setPreviousDeclInSameBlockScopeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl31setPreviousDeclInSameBlockScopeEb")
  //</editor-fold>
  public void setPreviousDeclInSameBlockScope(boolean Same) {
    assert (!isa_ParmVarDecl(this));
    Unnamed_field1.NonParmVarDeclBits.PreviousDeclInSameBlockScope = Same;
  }

  
  /// \brief If this variable is an instantiated static data member of a
  /// class template specialization, returns the templated static data member
  /// from which it was instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getInstantiatedFromStaticDataMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2249,
   FQN="clang::VarDecl::getInstantiatedFromStaticDataMember", NM="_ZNK5clang7VarDecl35getInstantiatedFromStaticDataMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl35getInstantiatedFromStaticDataMemberEv")
  //</editor-fold>
  public VarDecl /*P*/ getInstantiatedFromStaticDataMember() /*const*/ {
    {
      MemberSpecializationInfo /*P*/ MSI = getMemberSpecializationInfo();
      if ((MSI != null)) {
        return cast_VarDecl(MSI.getInstantiatedFrom());
      }
    }
    
    return null;
  }

  
  /// \brief If this variable is an instantiation of a variable template or a
  /// static data member of a class template, determine what kind of
  /// template specialization or instantiation this is.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2256,
   FQN="clang::VarDecl::getTemplateSpecializationKind", NM="_ZNK5clang7VarDecl29getTemplateSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl29getTemplateSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getTemplateSpecializationKind() /*const*/ {
    {
      /*const*/ VarTemplateSpecializationDecl /*P*/ Spec = dyn_cast_VarTemplateSpecializationDecl(this);
      if ((Spec != null)) {
        return Spec.getSpecializationKind();
      }
    }
    {
      
      MemberSpecializationInfo /*P*/ MSI = getMemberSpecializationInfo();
      if ((MSI != null)) {
        return MSI.getTemplateSpecializationKind();
      }
    }
    
    return TemplateSpecializationKind.TSK_Undeclared;
  }

  
  /// \brief If this variable is an instantiation of a variable template or a
  /// static data member of a class template, determine its point of
  /// instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2266,
   FQN="clang::VarDecl::getPointOfInstantiation", NM="_ZNK5clang7VarDecl23getPointOfInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl23getPointOfInstantiationEv")
  //</editor-fold>
  public SourceLocation getPointOfInstantiation() /*const*/ {
    {
      /*const*/ VarTemplateSpecializationDecl /*P*/ Spec = dyn_cast_VarTemplateSpecializationDecl(this);
      if ((Spec != null)) {
        return Spec.getPointOfInstantiation();
      }
    }
    {
      
      MemberSpecializationInfo /*P*/ MSI = getMemberSpecializationInfo();
      if ((MSI != null)) {
        return MSI.getPointOfInstantiation();
      }
    }
    
    return new SourceLocation();
  }

  
  /// \brief If this variable is an instantiation of a static data member of a
  /// class template specialization, retrieves the member specialization
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getMemberSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2285,
   FQN="clang::VarDecl::getMemberSpecializationInfo", NM="_ZNK5clang7VarDecl27getMemberSpecializationInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl27getMemberSpecializationInfoEv")
  //</editor-fold>
  public MemberSpecializationInfo /*P*/ getMemberSpecializationInfo() /*const*/ {
    if (isStaticDataMember()) {
      // FIXME: Remove ?
      // return getASTContext().getInstantiatedFromStaticDataMember(this);
      return getASTContext().getTemplateOrSpecializationInfo(this).dyn_cast(MemberSpecializationInfo /*P*/.class);
    }
    return null;
  }

  
  /// \brief For a static data member that was instantiated from a static
  /// data member of a class template, set the template specialiation kind.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2294,
   FQN="clang::VarDecl::setTemplateSpecializationKind", NM="_ZN5clang7VarDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK) {
    setTemplateSpecializationKind(TSK, 
                               new SourceLocation());
  }
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK, 
                               SourceLocation PointOfInstantiation/*= SourceLocation()*/) {
    assert ((isa_VarTemplateSpecializationDecl(this) || (getMemberSpecializationInfo() != null))) : "not a variable or static data member template specialization";
    {
      
      VarTemplateSpecializationDecl /*P*/ Spec = dyn_cast_VarTemplateSpecializationDecl(this);
      if ((Spec != null)) {
        Spec.setSpecializationKind(TSK);
        if (TSK != TemplateSpecializationKind.TSK_ExplicitSpecialization && PointOfInstantiation.isValid()
           && Spec.getPointOfInstantiation().isInvalid()) {
          Spec.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
        }
      }
    }
    {
      
      MemberSpecializationInfo /*P*/ MSI = getMemberSpecializationInfo();
      if ((MSI != null)) {
        MSI.setTemplateSpecializationKind(TSK);
        if (TSK != TemplateSpecializationKind.TSK_ExplicitSpecialization && PointOfInstantiation.isValid()
           && MSI.getPointOfInstantiation().isInvalid()) {
          MSI.setPointOfInstantiation(new SourceLocation(PointOfInstantiation));
        }
      }
    }
  }

  
  /// \brief Specify that this variable is an instantiation of the
  /// static data member VD.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setInstantiationOfStaticDataMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2316,
   FQN="clang::VarDecl::setInstantiationOfStaticDataMember", NM="_ZN5clang7VarDecl34setInstantiationOfStaticDataMemberEPS0_NS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl34setInstantiationOfStaticDataMemberEPS0_NS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setInstantiationOfStaticDataMember(VarDecl /*P*/ VD, 
                                    TemplateSpecializationKind TSK) {
    assert (getASTContext().getTemplateOrSpecializationInfo(this).isNull()) : "Previous template or instantiation?";
    getASTContext().setInstantiatedFromStaticDataMember(this, VD, TSK);
  }

  
  /// \brief Retrieves the variable template that is described by this
  /// variable declaration.
  ///
  /// Every variable template is represented as a VarTemplateDecl and a
  /// VarDecl. The former contains template properties (such as
  /// the template parameter lists) while the latter contains the
  /// actual description of the template's
  /// contents. VarTemplateDecl::getTemplatedDecl() retrieves the
  /// VarDecl that from a VarTemplateDecl, while
  /// getDescribedVarTemplate() retrieves the VarTemplateDecl from
  /// a VarDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::getDescribedVarTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2276,
   FQN="clang::VarDecl::getDescribedVarTemplate", NM="_ZNK5clang7VarDecl23getDescribedVarTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7VarDecl23getDescribedVarTemplateEv")
  //</editor-fold>
  public VarTemplateDecl /*P*/ getDescribedVarTemplate() /*const*/ {
    return getASTContext().getTemplateOrSpecializationInfo(this).dyn_cast(VarTemplateDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::setDescribedVarTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 2281,
   FQN="clang::VarDecl::setDescribedVarTemplate", NM="_ZN5clang7VarDecl23setDescribedVarTemplateEPNS_15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl23setDescribedVarTemplateEPNS_15VarTemplateDeclE")
  //</editor-fold>
  public void setDescribedVarTemplate(VarTemplateDecl /*P*/ Template) {
    getASTContext().setTemplateOrSpecializationInfo(this, new PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >(JD$T.INSTANCE, VarTemplateDecl /*P*/.class, Template));
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1351,
   FQN="clang::VarDecl::classof", NM="_ZN5clang7VarDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 1352,
   FQN="clang::VarDecl::classofKind", NM="_ZN5clang7VarDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstVar.getValue() && K.getValue() <= Kind.lastVar.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarDecl::~VarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 768,
   FQN="clang::VarDecl::~VarDecl", NM="_ZN5clang7VarDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7VarDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final VarDecl getPreviousDecl() { 
    return (VarDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final VarDecl getPreviousDecl$Const() { 
    return (VarDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public /*derived non-final*/ VarDecl getMostRecentDecl() { 
    return (VarDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final VarDecl getMostRecentDecl$Const() { 
    return (VarDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "Init=" + Init // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
              + super.toString(); // NOI18N
  }
}
