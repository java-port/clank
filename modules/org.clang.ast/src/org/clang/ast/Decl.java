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

import java.util.function.Supplier;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import static org.clang.ast.impl.DeclBaseStatics.CheckAvailability;


/// Decl - This represents one declaration (or definition), e.g. a variable,
/// typedef, function, struct, etc.
///
/// Note: There are objects tacked on before the *beginning* of Decl
/// (and its subclasses) in its Decl::operator new(). Proper alignment
/// of all subclasses (not requiring more than the alignment of Decl) is
/// asserted in DeclBase.cpp.
//<editor-fold defaultstate="collapsed" desc="clang::Decl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 78,
 FQN="clang::Decl", NM="_ZN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4DeclE")
//</editor-fold>
public class Decl extends FoldingSetImpl.NodeImpl implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Lists the kind of concrete classes of Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 81,
   FQN="clang::Decl::Kind", NM="_ZN5clang4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    AccessSpec(0),
    Block(AccessSpec.getValue() + 1),
    Captured(Block.getValue() + 1),
    ClassScopeFunctionSpecialization(Captured.getValue() + 1),
    Empty(ClassScopeFunctionSpecialization.getValue() + 1),
    ExternCContext(Empty.getValue() + 1),
    FileScopeAsm(ExternCContext.getValue() + 1),
    Friend(FileScopeAsm.getValue() + 1),
    FriendTemplate(Friend.getValue() + 1),
    Import(FriendTemplate.getValue() + 1),
    LinkageSpec(Import.getValue() + 1),
    Label(LinkageSpec.getValue() + 1),
    Namespace(Label.getValue() + 1),
    NamespaceAlias(Namespace.getValue() + 1),
    ObjCCompatibleAlias(NamespaceAlias.getValue() + 1),
    ObjCCategory(ObjCCompatibleAlias.getValue() + 1),
    ObjCCategoryImpl(ObjCCategory.getValue() + 1),
    ObjCImplementation(ObjCCategoryImpl.getValue() + 1),
    firstObjCImpl(Kind.ObjCCategoryImpl.getValue()),
    lastObjCImpl(Kind.ObjCImplementation.getValue()),
    ObjCInterface(lastObjCImpl.getValue() + 1),
    ObjCProtocol(ObjCInterface.getValue() + 1),
    firstObjCContainer(Kind.ObjCCategory.getValue()),
    lastObjCContainer(Kind.ObjCProtocol.getValue()),
    ObjCMethod(lastObjCContainer.getValue() + 1),
    ObjCProperty(ObjCMethod.getValue() + 1),
    BuiltinTemplate(ObjCProperty.getValue() + 1),
    ClassTemplate(BuiltinTemplate.getValue() + 1),
    FunctionTemplate(ClassTemplate.getValue() + 1),
    TypeAliasTemplate(FunctionTemplate.getValue() + 1),
    VarTemplate(TypeAliasTemplate.getValue() + 1),
    firstRedeclarableTemplate(Kind.ClassTemplate.getValue()),
    lastRedeclarableTemplate(Kind.VarTemplate.getValue()),
    TemplateTemplateParm(lastRedeclarableTemplate.getValue() + 1),
    firstTemplate(Kind.BuiltinTemplate.getValue()),
    lastTemplate(Kind.TemplateTemplateParm.getValue()),
    Enum(lastTemplate.getValue() + 1),
    Record(Enum.getValue() + 1),
    CXXRecord(Record.getValue() + 1),
    ClassTemplateSpecialization(CXXRecord.getValue() + 1),
    ClassTemplatePartialSpecialization(ClassTemplateSpecialization.getValue() + 1),
    firstClassTemplateSpecialization(Kind.ClassTemplateSpecialization.getValue()),
    lastClassTemplateSpecialization(Kind.ClassTemplatePartialSpecialization.getValue()),
    firstCXXRecord(Kind.CXXRecord.getValue()),
    lastCXXRecord(Kind.ClassTemplatePartialSpecialization.getValue()),
    firstRecord(Kind.Record.getValue()),
    lastRecord(Kind.ClassTemplatePartialSpecialization.getValue()),
    firstTag(Kind.Enum.getValue()),
    lastTag(Kind.ClassTemplatePartialSpecialization.getValue()),
    TemplateTypeParm(lastTag.getValue() + 1),
    ObjCTypeParam(TemplateTypeParm.getValue() + 1),
    TypeAlias(ObjCTypeParam.getValue() + 1),
    Typedef(TypeAlias.getValue() + 1),
    firstTypedefName(Kind.ObjCTypeParam.getValue()),
    lastTypedefName(Kind.Typedef.getValue()),
    UnresolvedUsingTypename(lastTypedefName.getValue() + 1),
    firstType(Kind.Enum.getValue()),
    lastType(Kind.UnresolvedUsingTypename.getValue()),
    Using(lastType.getValue() + 1),
    UsingDirective(Using.getValue() + 1),
    UsingShadow(UsingDirective.getValue() + 1),
    ConstructorUsingShadow(UsingShadow.getValue() + 1),
    firstUsingShadow(Kind.UsingShadow.getValue()),
    lastUsingShadow(Kind.ConstructorUsingShadow.getValue()),
    Field(lastUsingShadow.getValue() + 1),
    ObjCAtDefsField(Field.getValue() + 1),
    ObjCIvar(ObjCAtDefsField.getValue() + 1),
    firstField(Kind.Field.getValue()),
    lastField(Kind.ObjCIvar.getValue()),
    Function(lastField.getValue() + 1),
    CXXMethod(Function.getValue() + 1),
    CXXConstructor(CXXMethod.getValue() + 1),
    CXXConversion(CXXConstructor.getValue() + 1),
    CXXDestructor(CXXConversion.getValue() + 1),
    firstCXXMethod(Kind.CXXMethod.getValue()),
    lastCXXMethod(Kind.CXXDestructor.getValue()),
    firstFunction(Kind.Function.getValue()),
    lastFunction(Kind.CXXDestructor.getValue()),
    MSProperty(lastFunction.getValue() + 1),
    NonTypeTemplateParm(MSProperty.getValue() + 1),
    Var(NonTypeTemplateParm.getValue() + 1),
    ImplicitParam(Var.getValue() + 1),
    OMPCapturedExpr(ImplicitParam.getValue() + 1),
    ParmVar(OMPCapturedExpr.getValue() + 1),
    VarTemplateSpecialization(ParmVar.getValue() + 1),
    VarTemplatePartialSpecialization(VarTemplateSpecialization.getValue() + 1),
    firstVarTemplateSpecialization(Kind.VarTemplateSpecialization.getValue()),
    lastVarTemplateSpecialization(Kind.VarTemplatePartialSpecialization.getValue()),
    firstVar(Kind.Var.getValue()),
    lastVar(Kind.VarTemplatePartialSpecialization.getValue()),
    firstDeclarator(Kind.Field.getValue()),
    lastDeclarator(Kind.VarTemplatePartialSpecialization.getValue()),
    EnumConstant(lastDeclarator.getValue() + 1),
    IndirectField(EnumConstant.getValue() + 1),
    OMPDeclareReduction(IndirectField.getValue() + 1),
    UnresolvedUsingValue(OMPDeclareReduction.getValue() + 1),
    firstValue(Kind.Field.getValue()),
    lastValue(Kind.UnresolvedUsingValue.getValue()),
    firstNamed(Kind.Label.getValue()),
    lastNamed(Kind.UnresolvedUsingValue.getValue()),
    OMPThreadPrivate(lastNamed.getValue() + 1),
    ObjCPropertyImpl(OMPThreadPrivate.getValue() + 1),
    PragmaComment(ObjCPropertyImpl.getValue() + 1),
    PragmaDetectMismatch(PragmaComment.getValue() + 1),
    StaticAssert(PragmaDetectMismatch.getValue() + 1),
    TranslationUnit(StaticAssert.getValue() + 1),
    firstDecl(Kind.AccessSpec.getValue()),
    lastDecl(Kind.TranslationUnit.getValue());

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
  
  /// \brief A placeholder type used to construct an empty shell of a
  /// decl-derived type that will be filled in later (e.g., by some
  /// deserialization method).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::EmptyShell">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 94,
   FQN="clang::Decl::EmptyShell", NM="_ZN5clang4Decl10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl10EmptyShellE")
  //</editor-fold>
  public static class/*struct*/ EmptyShell {
    //<editor-fold defaultstate="collapsed" desc="clang::Decl::EmptyShell::EmptyShell">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 94,
     FQN="clang::Decl::EmptyShell::EmptyShell", NM="_ZN5clang4Decl10EmptyShellC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl10EmptyShellC1ERKS1_")
    //</editor-fold>
    public /*inline*/ EmptyShell(final /*const*/ EmptyShell /*&*/ $Prm0) {
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public EmptyShell() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Decl::EmptyShell::EmptyShell">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 94,
     FQN="clang::Decl::EmptyShell::EmptyShell", NM="_ZN5clang4Decl10EmptyShellC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang4Decl10EmptyShellC1EOS1_")
    //</editor-fold>
    public /*inline*/ EmptyShell(JD$Move _dparam, final EmptyShell /*&&*/$Prm0) {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// IdentifierNamespace - The different namespaces in which
  /// declarations may appear.  According to C99 6.2.3, there are
  /// four namespaces, labels, tags, members and ordinary
  /// identifiers.  C++ describes lookup completely differently:
  /// certain lookups merely "ignore" certain kinds of declarations,
  /// usually based on whether the declaration is of a type, etc.
  ///
  /// These are meant as bitmasks, so that searches in
  /// C++ can look into the "tag" namespace during ordinary lookup.
  ///
  /// Decl currently provides 15 bits of IDNS bits.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::IdentifierNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 107,
   FQN="clang::Decl::IdentifierNamespace", NM="_ZN5clang4Decl19IdentifierNamespaceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl19IdentifierNamespaceE")
  //</editor-fold>
  public static final class/*enum*/ IdentifierNamespace {
    /// Labels, declared with 'x:' and referenced with 'goto x'.
    public static final /*uint*/int IDNS_Label = 0x0001;
    
    /// Tags, declared with 'struct foo;' and referenced with
    /// 'struct foo'.  All tags are also types.  This is what
    /// elaborated-type-specifiers look for in C.
    /// This also contains names that conflict with tags in the
    /// same scope but that are otherwise ordinary names (non-type
    /// template parameters and indirect field declarations).
    public static final /*uint*/int IDNS_Tag = 0x0002;
    
    /// Types, declared with 'struct foo', typedefs, etc.
    /// This is what elaborated-type-specifiers look for in C++,
    /// but note that it's ill-formed to find a non-tag.
    public static final /*uint*/int IDNS_Type = 0x0004;
    
    /// Members, declared with object declarations within tag
    /// definitions.  In C, these can only be found by "qualified"
    /// lookup in member expressions.  In C++, they're found by
    /// normal lookup.
    public static final /*uint*/int IDNS_Member = 0x0008;
    
    /// Namespaces, declared with 'namespace foo {}'.
    /// Lookup for nested-name-specifiers find these.
    public static final /*uint*/int IDNS_Namespace = 0x0010;
    
    /// Ordinary names.  In C, everything that's not a label, tag,
    /// member, or function-local extern ends up here.
    public static final /*uint*/int IDNS_Ordinary = 0x0020;
    
    /// Objective C \@protocol.
    public static final /*uint*/int IDNS_ObjCProtocol = 0x0040;
    
    /// This declaration is a friend function.  A friend function
    /// declaration is always in this namespace but may also be in
    /// IDNS_Ordinary if it was previously declared.
    public static final /*uint*/int IDNS_OrdinaryFriend = 0x0080;
    
    /// This declaration is a friend class.  A friend class
    /// declaration is always in this namespace but may also be in
    /// IDNS_Tag|IDNS_Type if it was previously declared.
    public static final /*uint*/int IDNS_TagFriend = 0x0100;
    
    /// This declaration is a using declaration.  A using declaration
    /// *introduces* a number of other declarations into the current
    /// scope, and those declarations use the IDNS of their targets,
    /// but the actual using declarations go in this namespace.
    public static final /*uint*/int IDNS_Using = 0x0200;
    
    /// This declaration is a C++ operator declared in a non-class
    /// context.  All such operators are also in IDNS_Ordinary.
    /// C++ lexical operator lookup looks for these.
    public static final /*uint*/int IDNS_NonMemberOperator = 0x0400;
    
    /// This declaration is a function-local extern declaration of a
    /// variable or function. This may also be IDNS_Ordinary if it
    /// has been declared outside any function. These act mostly like
    /// invisible friend declarations, but are also visible to unqualified
    /// lookup within the scope of the declaring function.
    public static final /*uint*/int IDNS_LocalExtern = 0x0800;
    
    /// This declaration is an OpenMP user defined reduction construction.
    public static final /*uint*/int IDNS_OMPReduction = 0x1000;
  };
  
  /// ObjCDeclQualifier - 'Qualifiers' written next to the return and
  /// parameter types in method declarations.  Other than remembering
  /// them and mangling them into the method's signature string, these
  /// are ignored by the compiler; they are consumed by certain
  /// remote-messaging frameworks.
  ///
  /// in, inout, and out are mutually exclusive and apply only to
  /// method parameters.  bycopy and byref are mutually exclusive and
  /// apply only to method parameters (?).  oneway applies only to
  /// results.  All of these expect their corresponding parameter to
  /// have a particular type.  None of this is currently enforced by
  /// clang.
  ///
  /// This should be kept in sync with ObjCDeclSpec::ObjCDeclQualifier.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::ObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 187,
   FQN="clang::Decl::ObjCDeclQualifier", NM="_ZN5clang4Decl17ObjCDeclQualifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl17ObjCDeclQualifierE")
  //</editor-fold>
  public static final class/*enum*/ ObjCDeclQualifier {
    public static final /*uint*/int OBJC_TQ_None = 0x0;
    public static final /*uint*/int OBJC_TQ_In = 0x1;
    public static final /*uint*/int OBJC_TQ_Inout = 0x2;
    public static final /*uint*/int OBJC_TQ_Out = 0x4;
    public static final /*uint*/int OBJC_TQ_Bycopy = 0x8;
    public static final /*uint*/int OBJC_TQ_Byref = 0x10;
    public static final /*uint*/int OBJC_TQ_Oneway = 0x20;
    
    /// The nullability qualifier is set when the nullability of the
    /// result or parameter was expressed via a context-sensitive
    /// keyword.
    public static final /*uint*/int OBJC_TQ_CSNullability = 0x40;
  };
/*protected:*/
  // Enumeration values used in the bits stored in NextInContextAndBits.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 204,
   FQN="clang::Decl::(anonymous)", NM="_ZN5clang4DeclE_Unnamed_enum3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4DeclE_Unnamed_enum3")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// \brief Whether this declaration is a top-level declaration (function,
    /// global variable, etc.) that is lexically inside an objc container
    /// definition.
    public static final /*uint*/int TopLevelDeclInObjCContainerFlag = 0x01;
    
    /// \brief Whether this declaration is private to the module in which it was
    /// defined.
    public static final /*uint*/int ModulePrivateFlag = 0x02;
  /*}*/;
  
  /// \brief The next declaration within the same lexical
  /// DeclContext. These pointers form the linked list that is
  /// traversed via DeclContext's decls_begin()/decls_end().
  ///
  /// The extra two bits are used for the TopLevelDeclInObjCContainer and
  /// ModulePrivate bits.
  protected PointerUInt2Pair<Decl /*P*/> NextInContextAndBits;
/*private:*/
  /*friend  class DeclContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::MultipleDC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 226,
   FQN="clang::Decl::MultipleDC", NM="_ZN5clang4Decl10MultipleDCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl10MultipleDCE")
  //</editor-fold>
  private static class/*struct*/ MultipleDC {
    public DeclContext /*P*/ SemanticDC;
    public DeclContext /*P*/ LexicalDC;
    
    @Override public String toString() {
      return "" + "SemanticDC=" + NativeTrace.getIdentityStr(SemanticDC) // NOI18N
                + ", LexicalDC=" + NativeTrace.getIdentityStr(LexicalDC); // NOI18N
    }
  };
  
  /// DeclCtx - Holds either a DeclContext* or a MultipleDC*.
  /// For declarations that don't contain C++ scope specifiers, it contains
  /// the DeclContext where the Decl was declared.
  /// For declarations with C++ scope specifiers, it contains a MultipleDC*
  /// with the context where it semantically belongs (SemanticDC) and the
  /// context where it was lexically declared (LexicalDC).
  /// e.g.:
  ///
  ///   namespace A {
  ///      void f(); // SemanticDC == LexicalDC == 'namespace A'
  ///   }
  ///   void A::f(); // SemanticDC == namespace 'A'
  ///                // LexicalDC == global namespace
  private final PointerUnion<DeclContext /*P*/ , MultipleDC /*P*/ > DeclCtx;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isInSemaDC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 247,
   FQN="clang::Decl::isInSemaDC", NM="_ZNK5clang4Decl10isInSemaDCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl10isInSemaDCEv")
  //</editor-fold>
  private /*inline*/ boolean isInSemaDC() /*const*/ {
    return (DeclCtx.is(DeclContext /*P*/.class) != 0);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isOutOfSemaDC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 248,
   FQN="clang::Decl::isOutOfSemaDC", NM="_ZNK5clang4Decl13isOutOfSemaDCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13isOutOfSemaDCEv")
  //</editor-fold>
  private /*inline*/ boolean isOutOfSemaDC() /*const*/ {
    return (DeclCtx.is(MultipleDC /*P*/.class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getMultipleDC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 249,
   FQN="clang::Decl::getMultipleDC", NM="_ZNK5clang4Decl13getMultipleDCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13getMultipleDCEv")
  //</editor-fold>
  private /*inline*/ MultipleDC /*P*/ getMultipleDC() /*const*/ {
    return DeclCtx.get(MultipleDC /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getSemanticDC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 252,
   FQN="clang::Decl::getSemanticDC", NM="_ZNK5clang4Decl13getSemanticDCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13getSemanticDCEv")
  //</editor-fold>
  private /*inline*/ DeclContext /*P*/ getSemanticDC() /*const*/ {
    return DeclCtx.get(DeclContext /*P*/.class);
  }

  
  /// Loc - The location of this decl.
  private final SourceLocation Loc;
  
  /// DeclKind - This indicates which class this is.
  private final /*JBYTE unsigned int*/ byte DeclKind /*: 7*/;
  
  /// InvalidDecl - This indicates a semantic error occurred.
  private /*JBIT unsigned int*/ boolean InvalidDecl /*: 1*/;
  
  /// HasAttrs - This indicates whether the decl has attributes or not.
  private /*JBIT unsigned int*/ boolean HasAttrs /*: 1*/;
  
  /// Implicit - Whether this declaration was implicitly generated by
  /// the implementation rather than explicitly written by the user.
  private /*JBIT unsigned int*/ boolean Implicit /*: 1*/;
  
  /// \brief Whether this declaration was "used", meaning that a definition is
  /// required.
  /*friend*/public /*JBIT unsigned int*/ boolean Used /*: 1*/;
  
  /// \brief Whether this declaration was "referenced".
  /// The difference with 'Used' is whether the reference appears in a
  /// evaluated context or not, e.g. functions used in uninstantiated templates
  /// are regarded as "referenced" but not "used".
  private /*JBIT unsigned int*/ boolean Referenced /*: 1*/;
  
  /// \brief Whether statistic collection is enabled.
  private static boolean StatisticsEnabled;
/*protected:*/
  /// Access - Used by C++ decls for the access specifier.
  // NOTE: VC++ treats enums as signed, avoid using the AccessSpecifier enum
  protected /*JBYTE unsigned int*/ byte Access /*: 2*/;
  /*friend  class CXXClassMemberWrapper*/
  
  /// \brief Whether this declaration was loaded from an AST file.
  /*friend*/public /*JBIT unsigned int*/ boolean FromASTFile /*: 1*/;
  
  /// \brief Whether this declaration is hidden from normal name lookup, e.g.,
  /// because it is was loaded from an AST file is either module-private or
  /// because its submodule has not been made visible.
  /*friend*/public /*JBIT unsigned int*/ boolean Hidden /*: 1*/;
  
  /// IdentifierNamespace - This specifies what IDNS_* namespace this lives in.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  public /*JCHAR unsigned int*/ char IdentifierNamespace_field /*: 13*/;
  
  /// \brief If 0, we have not computed the linkage of this declaration.
  /// Otherwise, it is the linkage + 1.
  protected /*mutable *//*JBYTE unsigned int*/ byte CacheValidAndLinkage /*: 3*/;
  
  /*friend  class ASTDeclWriter*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTReader*/
  /*friend  class LinkageComputer*/
  
  /*friend template <typename decl_type> class Redeclarable*/
  
  // JAVA: moved into extra members part
//  /// \brief Allocate memory for a deserialized declaration.
//  ///
//  /// This routine must be used to allocate memory for any declaration that is
//  /// deserialized from a module file.
//  ///
//  /// \param Size The size of the allocated object.
//  /// \param Ctx The context in which we will allocate memory.
//  /// \param ID The global ID of the deserialized declaration.
//  /// \param Extra The amount of extra space to allocate after the object.
//  
//  /// \brief Allocate memory for a deserialized declaration.
//  ///
//  /// This routine must be used to allocate memory for any declaration that is
//  /// deserialized from a module file.
//  ///
//  /// \param Size The size of the allocated object.
//  /// \param Ctx The context in which we will allocate memory.
//  /// \param ID The global ID of the deserialized declaration.
//  /// \param Extra The amount of extra space to allocate after the object.
//  //<editor-fold defaultstate="collapsed" desc="clang::Decl::operator new">
//  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*operator new (Ctx, ID) Decl(...) */,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 55,
//   FQN="clang::Decl::operator new", NM="_ZN5clang4DeclnwEjRKNS_10ASTContextEjj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclnwEjRKNS_10ASTContextEjj")
//  //</editor-fold>
//  protected static Object/*void P*/ $new(/*uint*/int Size, final /*const*/ ASTContext /*&*/ Context, 
//      /*uint*/int ID) {
//    return $new(Size, Context, 
//      ID, 0);
//  }
//  protected static Object/*void P*/ $new(/*uint*/int Size, final /*const*/ ASTContext /*&*/ Context, 
//      /*uint*/int ID, /*uint*/int Extra/*= 0*/) {
//    // Allocate an extra 8 bytes worth of storage, which ensures that the
//    // resulting pointer will still be 8-byte aligned.
//    static_assert($greatereq_uint($sizeof_UInt() * 2, AlignOf/*<Decl>*/.Unnamed_enum.Alignment), $("Decl won't be misaligned"));
//    Object/*void P*/ Start = Context.Allocate(Size + Extra + 8);
//    Object/*void P*/ Result = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, Start).$add(8));
//    
//    uint$ptr/*uint P*/ PrefixPtr = $tryClone(reinterpret_cast(uint$ptr/*uint P*/ .class, Result).$sub(2));
//    
//    // Zero out the first 4 bytes; this is used to store the owning module ID.
//    PrefixPtr.$set(0, 0);
//    
//    // Store the global declaration ID in the second 4 bytes.
//    PrefixPtr.$set(1, ID);
//    
//    return Result;
//  }
//
//  
//
//  /// \brief Allocate memory for a non-deserialized declaration.
//  
//  /// \brief Allocate memory for a non-deserialized declaration.
//  //<editor-fold defaultstate="collapsed" desc="clang::Decl::operator new">
//  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*operator new (Ctx, DC) Decl(...) */,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 75,
//   FQN="clang::Decl::operator new", NM="_ZN5clang4DeclnwEjRKNS_10ASTContextEPNS_11DeclContextEj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclnwEjRKNS_10ASTContextEPNS_11DeclContextEj")
//  //</editor-fold>
//  protected static Object/*void P*/ $new(/*uint*/int Size, final /*const*/ ASTContext /*&*/ Ctx, 
//      DeclContext /*P*/ Parent) {
//    return $new(Size, Ctx, 
//      Parent, 0);
//  }
//  protected static Object/*void P*/ $new(/*uint*/int Size, final /*const*/ ASTContext /*&*/ Ctx, 
//      DeclContext /*P*/ Parent, /*uint*/int Extra/*= 0*/) {
//    assert (!(Parent != null) || /*AddrOf*/Parent.getParentASTContext() == /*AddrOf*/Ctx);
//    // With local visibility enabled, we track the owning module even for local
//    // declarations.
//    if (Ctx.getLangOpts().ModulesLocalVisibility) {
//      // Ensure required alignment of the resulting object by adding extra
//      // padding at the start if required.
//      /*size_t*/int ExtraAlign = $ulong2uint(llvm.OffsetToAlignment($uint2ulong($sizeof_ptr(/*Module  */)), 
//          $uint2ulong(AlignOf/*<Decl>*/.Unnamed_enum.Alignment)));
//      char$ptr/*char P*/ Buffer = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, /*::*/$new_uint_ASTContext$C_uint(ExtraAlign + $sizeof_ptr(/*Module  */) + Size + Extra, Ctx)));
//      Buffer.$inc(ExtraAlign);
//      return /*FIXME:NEW_EXPR*//*new (Buffer)*/ new Module /*P*/ (Buffer.$add(1));
//    }
//    return /*::*/$new_uint_ASTContext$C_uint(Size + Extra, Ctx);
//  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::AccessDeclContextSanity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 780,
   FQN="clang::Decl::AccessDeclContextSanity", NM="_ZNK5clang4Decl23AccessDeclContextSanityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl23AccessDeclContextSanityEv")
  //</editor-fold>
  private boolean AccessDeclContextSanity() /*const*/ {
    // Suppress this check if any of the following hold:
    // 1. this is the translation unit (and thus has no parent)
    // 2. this is a template parameter (and thus doesn't belong to its context)
    // 3. this is a non-type template parameter
    // 4. the context is not a record
    // 5. it's invalid
    // 6. it's a C++0x static_assert.
    if (isa_TranslationUnitDecl(this)
       || isa_TemplateTypeParmDecl(this)
       || isa_NonTypeTemplateParmDecl(this)
       || !isa_CXXRecordDecl(getDeclContext$Const())
       || isInvalidDecl()
       || isa_StaticAssertDecl(this)
      // FIXME: a ParmVarDecl can have ClassTemplateSpecialization
      // as DeclContext (?).
       || isa_ParmVarDecl(this)
      // FIXME: a ClassTemplateSpecialization or CXXRecordDecl can have
      // AS_none as access specifier.
       || isa_CXXRecordDecl(this)
       || isa_ClassScopeFunctionSpecializationDecl(this)) {
      return true;
    }
    assert (Access != $int2uint_2bits(AccessSpecifier.AS_none.getValue())) : "Access specifier is AS_none inside a record decl";
    return true;
  }


/*protected:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::Decl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 334,
   FQN="clang::Decl::Decl", NM="_ZN5clang4DeclC1ENS0_4KindEPNS_11DeclContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4DeclC1ENS0_4KindEPNS_11DeclContextENS_14SourceLocationE")
  //</editor-fold>
  protected Decl(Kind DK, DeclContext /*P*/ DC, SourceLocation L) {
    assert !(this instanceof Mergeable && this instanceof Redeclarable): "can not be Mergeable and Redeclarable at the same time" + this.getClass();
    // : NextInContextAndBits(), DeclCtx(DC), Loc(L), DeclKind(DK), InvalidDecl(0), HasAttrs(false), Implicit(false), Used(false), Referenced(false), Access(AS_none), FromASTFile(0), Hidden(DC && cast<Decl>(DC)->Hidden), IdentifierNamespace(getIdentifierNamespaceForKind(DK)), CacheValidAndLinkage(0)     
    //START JInit
    this.NextInContextAndBits = new PointerUInt2Pair<Decl /*P*/>();
    this.DeclCtx = new PointerUnion<DeclContext /*P*/ , MultipleDC /*P*/ >(JD$T.INSTANCE, DeclContext /*P*/ .class, DC);
    this.Loc = new SourceLocation(L);
    this.DeclKind = $uint2uint_7bits(DK.getValue());
    this.InvalidDecl = false;
    this.HasAttrs = false;
    this.Implicit = false;
    this.Used = false;
    this.Referenced = false;
    this.Access = $uint2uint_2bits(AccessSpecifier.AS_none.getValue());
    this.FromASTFile = false;
    this.Hidden = (DC != null) && cast_Decl(DC).Hidden;
    this.IdentifierNamespace_field = $uint2uint_13bits(getIdentifierNamespaceForKind(DK));
    this.CacheValidAndLinkage = $uint2uint_3bits(0);
    //END JInit
    if (StatisticsEnabled) {
      add(DK);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::Decl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 345,
   FQN="clang::Decl::Decl", NM="_ZN5clang4DeclC1ENS0_4KindENS0_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4DeclC1ENS0_4KindENS0_10EmptyShellE")
  //</editor-fold>
  protected Decl(Kind DK, EmptyShell Empty) {
    assert !(this instanceof Mergeable && this instanceof Redeclarable): "can not be Mergeable and Redeclarable at the same time" + this.getClass();
    // : NextInContextAndBits(), DeclCtx(), Loc(), DeclKind(DK), InvalidDecl(0), HasAttrs(false), Implicit(false), Used(false), Referenced(false), Access(AS_none), FromASTFile(0), Hidden(0), IdentifierNamespace(getIdentifierNamespaceForKind(DK)), CacheValidAndLinkage(0) 
    //START JInit
    this.NextInContextAndBits = new PointerUInt2Pair<Decl /*P*/>();
    this.DeclCtx = new PointerUnion<DeclContext /*P*/ , MultipleDC /*P*/ >(DeclContext /*P*/ .class);
    this.Loc = new SourceLocation();
    this.DeclKind = $uint2uint_7bits(DK.getValue());
    this.InvalidDecl = false;
    this.HasAttrs = false;
    this.Implicit = false;
    this.Used = false;
    this.Referenced = false;
    this.Access = $uint2uint_2bits(AccessSpecifier.AS_none.getValue());
    this.FromASTFile = false;
    this.Hidden = false;
    this.IdentifierNamespace_field = $uint2uint_13bits(getIdentifierNamespaceForKind(DK));
    this.CacheValidAndLinkage = $uint2uint_3bits(0);
    //END JInit
    if (StatisticsEnabled) {
      add(DK);
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Decl Implementation
  //===----------------------------------------------------------------------===//
  
  // Out-of-line virtual method providing a home for Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::~Decl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 251,
   FQN="clang::Decl::~Decl", NM="_ZN5clang4DeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
  }


  
  /// \brief Update a potentially out-of-date declaration.
  
  /// \brief Update a potentially out-of-date declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::updateOutOfDate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 44,
   FQN="clang::Decl::updateOutOfDate", NM="_ZNK5clang4Decl15updateOutOfDateERNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15updateOutOfDateERNS_14IdentifierInfoE")
  //</editor-fold>
  protected void updateOutOfDate(final IdentifierInfo /*&*/ II) /*const*/ {
    getASTContext().getExternalSource().updateOutOfDateIdentifier(II);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getCachedLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 360,
   FQN="clang::Decl::getCachedLinkage", NM="_ZNK5clang4Decl16getCachedLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl16getCachedLinkageEv")
  //</editor-fold>
  /*friend*/public Linkage getCachedLinkage() /*const*/ {
    return Linkage.valueOf(CacheValidAndLinkage - $int2uint_3bits(1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setCachedLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 364,
   FQN="clang::Decl::setCachedLinkage", NM="_ZNK5clang4Decl16setCachedLinkageENS_7LinkageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl16setCachedLinkageENS_7LinkageE")
  //</editor-fold>
  /*friend*/public void setCachedLinkage(Linkage L) /*const*/ {
    CacheValidAndLinkage = $uint2uint_3bits(L.getValue() + 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasCachedLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 368,
   FQN="clang::Decl::hasCachedLinkage", NM="_ZNK5clang4Decl16hasCachedLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl16hasCachedLinkageEv")
  //</editor-fold>
  /*friend*/public boolean hasCachedLinkage() /*const*/ {
    return (CacheValidAndLinkage != 0);
  }

/*public:*/
  
  /// \brief Source range that this declaration covers.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 375,
   FQN="clang::Decl::getSourceRange", NM="_ZNK5clang4Decl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl14getSourceRangeEv")
  //</editor-fold>
  public /*virtual*/ SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(getLocation(), getLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 378,
   FQN="clang::Decl::getLocStart", NM="_ZNK5clang4Decl11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getSourceRange().getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 381,
   FQN="clang::Decl::getLocEnd", NM="_ZNK5clang4Decl9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getSourceRange().getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 385,
   FQN="clang::Decl::getLocation", NM="_ZNK5clang4Decl11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 386,
   FQN="clang::Decl::setLocation", NM="_ZN5clang4Decl11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    Loc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 388,
   FQN="clang::Decl::getKind", NM="_ZNK5clang4Decl7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return /*static_cast*/Kind.valueOf($uchar2uint(DeclKind));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getDeclKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 103,
   FQN="clang::Decl::getDeclKindName", NM="_ZNK5clang4Decl15getDeclKindNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15getDeclKindNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getDeclKindName() /*const*/ {
    switch (Kind.valueOf(DeclKind)) {
     default:
      throw new llvm_unreachable("Declaration not in DeclNodes.inc!");
     case AccessSpec:
      return $("AccessSpec");
     case Block:
      return $("Block");
     case Captured:
      return $("Captured");
     case ClassScopeFunctionSpecialization:
      return $("ClassScopeFunctionSpecialization");
     case Empty:
      return $("Empty");
     case ExternCContext:
      return $("ExternCContext");
     case FileScopeAsm:
      return $("FileScopeAsm");
     case Friend:
      return $("Friend");
     case FriendTemplate:
      return $("FriendTemplate");
     case Import:
      return $("Import");
     case LinkageSpec:
      return $("LinkageSpec");
     case Label:
      return $("Label");
     case Namespace:
      return $("Namespace");
     case NamespaceAlias:
      return $("NamespaceAlias");
     case ObjCCompatibleAlias:
      return $("ObjCCompatibleAlias");
     case ObjCCategory:
      return $("ObjCCategory");
     case ObjCCategoryImpl:
      return $("ObjCCategoryImpl");
     case ObjCImplementation:
      return $("ObjCImplementation");
     case ObjCInterface:
      return $("ObjCInterface");
     case ObjCProtocol:
      return $("ObjCProtocol");
     case ObjCMethod:
      return $("ObjCMethod");
     case ObjCProperty:
      return $("ObjCProperty");
     case BuiltinTemplate:
      return $("BuiltinTemplate");
     case ClassTemplate:
      return $("ClassTemplate");
     case FunctionTemplate:
      return $("FunctionTemplate");
     case TypeAliasTemplate:
      return $("TypeAliasTemplate");
     case VarTemplate:
      return $("VarTemplate");
     case TemplateTemplateParm:
      return $("TemplateTemplateParm");
     case Enum:
      return $("Enum");
     case Record:
      return $("Record");
     case CXXRecord:
      return $("CXXRecord");
     case ClassTemplateSpecialization:
      return $("ClassTemplateSpecialization");
     case ClassTemplatePartialSpecialization:
      return $("ClassTemplatePartialSpecialization");
     case TemplateTypeParm:
      return $("TemplateTypeParm");
     case ObjCTypeParam:
      return $("ObjCTypeParam");
     case TypeAlias:
      return $("TypeAlias");
     case Typedef:
      return $("Typedef");
     case UnresolvedUsingTypename:
      return $("UnresolvedUsingTypename");
     case Using:
      return $("Using");
     case UsingDirective:
      return $("UsingDirective");
     case UsingShadow:
      return $("UsingShadow");
     case ConstructorUsingShadow:
      return $("ConstructorUsingShadow");
     case Field:
      return $("Field");
     case ObjCAtDefsField:
      return $("ObjCAtDefsField");
     case ObjCIvar:
      return $("ObjCIvar");
     case Function:
      return $("Function");
     case CXXMethod:
      return $("CXXMethod");
     case CXXConstructor:
      return $("CXXConstructor");
     case CXXConversion:
      return $("CXXConversion");
     case CXXDestructor:
      return $("CXXDestructor");
     case MSProperty:
      return $("MSProperty");
     case NonTypeTemplateParm:
      return $("NonTypeTemplateParm");
     case Var:
      return $("Var");
     case ImplicitParam:
      return $("ImplicitParam");
     case OMPCapturedExpr:
      return $("OMPCapturedExpr");
     case ParmVar:
      return $("ParmVar");
     case VarTemplateSpecialization:
      return $("VarTemplateSpecialization");
     case VarTemplatePartialSpecialization:
      return $("VarTemplatePartialSpecialization");
     case EnumConstant:
      return $("EnumConstant");
     case IndirectField:
      return $("IndirectField");
     case OMPDeclareReduction:
      return $("OMPDeclareReduction");
     case UnresolvedUsingValue:
      return $("UnresolvedUsingValue");
     case OMPThreadPrivate:
      return $("OMPThreadPrivate");
     case ObjCPropertyImpl:
      return $("ObjCPropertyImpl");
     case PragmaComment:
      return $("PragmaComment");
     case PragmaDetectMismatch:
      return $("PragmaDetectMismatch");
     case StaticAssert:
      return $("StaticAssert");
     case TranslationUnit:
      return $("TranslationUnit");
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getNextDeclInContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 391,
   FQN="clang::Decl::getNextDeclInContext", NM="_ZN5clang4Decl20getNextDeclInContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl20getNextDeclInContextEv")
  //</editor-fold>
  public Decl /*P*/ getNextDeclInContext() {
    return NextInContextAndBits.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getNextDeclInContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 392,
   FQN="clang::Decl::getNextDeclInContext", NM="_ZNK5clang4Decl20getNextDeclInContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl20getNextDeclInContextEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getNextDeclInContext$Const() /*const*/ {
    return NextInContextAndBits.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 394,
   FQN="clang::Decl::getDeclContext", NM="_ZN5clang4Decl14getDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl14getDeclContextEv")
  //</editor-fold>
  public DeclContext /*P*/ getDeclContext() {
    if (isInSemaDC()) {
      return getSemanticDC();
    }
    return getMultipleDC().SemanticDC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 399,
   FQN="clang::Decl::getDeclContext", NM="_ZNK5clang4Decl14getDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl14getDeclContextEv")
  //</editor-fold>
  public /*const*/ DeclContext /*P*/ getDeclContext$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getDeclContext();
  }

  
  /// Find the innermost non-closure ancestor of this declaration,
  /// walking up through blocks, lambdas, etc.  If that ancestor is
  /// not a code context (!isFunctionOrMethod()), returns null.
  ///
  /// A declaration may be its own non-closure context.
  
  /// Find the innermost non-closure ancestor of this declaration,
  /// walking up through blocks, lambdas, etc.  If that ancestor is
  /// not a code context (!isFunctionOrMethod()), returns null.
  ///
  /// A declaration may be its own non-closure context.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getNonClosureContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 853,
   FQN="clang::Decl::getNonClosureContext", NM="_ZN5clang4Decl20getNonClosureContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl20getNonClosureContextEv")
  //</editor-fold>
  public Decl /*P*/ getNonClosureContext() {
    return DeclBaseStatics./*::*/getNonClosureContext$T(this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getNonClosureContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 409,
   FQN="clang::Decl::getNonClosureContext", NM="_ZNK5clang4Decl20getNonClosureContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl20getNonClosureContextEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getNonClosureContext$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getNonClosureContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 308,
   FQN="clang::Decl::getTranslationUnitDecl", NM="_ZN5clang4Decl22getTranslationUnitDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl22getTranslationUnitDeclEv")
  //</editor-fold>
  public TranslationUnitDecl /*P*/ getTranslationUnitDecl() {
    {
      TranslationUnitDecl /*P*/ TUD = dyn_cast_TranslationUnitDecl(this);
      if ((TUD != null)) {
        return TUD;
      }
    }
    
    DeclContext /*P*/ DC = getDeclContext();
    assert ((DC != null)) : "This decl is not contained in a translation unit!";
    while (!DC.isTranslationUnit()) {
      DC = DC.getParent();
      assert ((DC != null)) : "This decl is not contained in a translation unit!";
    }
    
    return cast_TranslationUnitDecl(DC);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 414,
   FQN="clang::Decl::getTranslationUnitDecl", NM="_ZNK5clang4Decl22getTranslationUnitDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl22getTranslationUnitDeclEv")
  //</editor-fold>
  public /*const*/ TranslationUnitDecl /*P*/ getTranslationUnitDecl$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getTranslationUnitDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isInAnonymousNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 293,
   FQN="clang::Decl::isInAnonymousNamespace", NM="_ZNK5clang4Decl22isInAnonymousNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl22isInAnonymousNamespaceEv")
  //</editor-fold>
  public boolean isInAnonymousNamespace() /*const*/ {
    /*const*/ DeclContext /*P*/ DC = getDeclContext$Const();
    do {
      {
        /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(DC);
        if ((ND != null)) {
          if (ND.isAnonymousNamespace()) {
            return true;
          }
        }
      }
    } while (((DC = DC.getParent$Const()) != null));
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isInStdNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 304,
   FQN="clang::Decl::isInStdNamespace", NM="_ZNK5clang4Decl16isInStdNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl16isInStdNamespaceEv")
  //</editor-fold>
  public boolean isInStdNamespace() /*const*/ {
    return getDeclContext$Const().isStdNamespace();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 323,
   FQN="clang::Decl::getASTContext", NM="_ZNK5clang4Decl13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() /*const*//* __attribute__((pure))*/ {
    return getTranslationUnitDecl$Const().getASTContext();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 424,
   FQN="clang::Decl::setAccess", NM="_ZN5clang4Decl9setAccessENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl9setAccessENS_15AccessSpecifierE")
  //</editor-fold>
  public void setAccess(AccessSpecifier AS) {
    Access = $uint2uint_2bits(AS.getValue());
    assert (AccessDeclContextSanity());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 429,
   FQN="clang::Decl::getAccess", NM="_ZNK5clang4Decl9getAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl9getAccessEv")
  //</editor-fold>
  public AccessSpecifier getAccess() /*const*/ {
    assert (AccessDeclContextSanity());
    return AccessSpecifier.valueOf($uchar2uint(Access));
  }

  
  /// \brief Retrieve the access specifier for this declaration, even though
  /// it may not yet have been properly set.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAccessUnsafe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 436,
   FQN="clang::Decl::getAccessUnsafe", NM="_ZNK5clang4Decl15getAccessUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl15getAccessUnsafeEv")
  //</editor-fold>
  public AccessSpecifier getAccessUnsafe() /*const*/ {
    return AccessSpecifier.valueOf(Access);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 440,
   FQN="clang::Decl::hasAttrs", NM="_ZNK5clang4Decl8hasAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl8hasAttrsEv")
  //</editor-fold>
  public boolean hasAttrs() /*const*/ {
    return HasAttrs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 441,
   FQN="clang::Decl::setAttrs", NM="_ZN5clang4Decl8setAttrsERKN4llvm11SmallVectorIPNS_4AttrELj2EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl8setAttrsERKN4llvm11SmallVectorIPNS_4AttrELj2EEE")
  //</editor-fold>
  public void setAttrs(final /*const*/SmallVector<Attr /*P*/>/*&*/ Attrs) {
    setAttrsImpl(Attrs, getASTContext());
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 444,
   FQN="clang::Decl::getAttrs", NM="_ZN5clang4Decl8getAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl8getAttrsEv")
  //</editor-fold>
  public SmallVector<Attr /*P*/>/*&*/ getAttrs() {
    return ((/*const_cast*/SmallVector<Attr /*P*/>/*&*/ )(((/*const_cast*//*const*/ Decl /*P*/ )(this)).getAttrs$Const()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 721,
   FQN="clang::Decl::getAttrs", NM="_ZNK5clang4Decl8getAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl8getAttrsEv")
  //</editor-fold>
  public /*const*/SmallVector<Attr /*P*/>/*&*/ getAttrs$Const() /*const*/ {
    assert (HasAttrs) : "No attrs to get!";
    return getASTContext().getDeclAttrs(this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::dropAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 714,
   FQN="clang::Decl::dropAttrs", NM="_ZN5clang4Decl9dropAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl9dropAttrsEv")
  //</editor-fold>
  public void dropAttrs() {
    if (!HasAttrs) {
      return;
    }
    
    HasAttrs = false;
    getASTContext().eraseDeclAttrs(this);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::addAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 450,
   FQN="clang::Decl::addAttr", NM="_ZN5clang4Decl7addAttrEPNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl7addAttrEPNS_4AttrE")
  //</editor-fold>
  public void addAttr(Attr /*P*/ A) {
    if (hasAttrs()) {
      getAttrs().push_back(A);
    } else {
      setAttrs(new SmallVector<Attr /*P*/>(JD$UInt_T$C$R.INSTANCE, 4, 1, A, null));
    }
  }

  
  /*typedef AttrVec::const_iterator attr_iterator*/
//  public final class attr_iterator extends type$ptr<Attr /*P*/>{ };
  /*typedef llvm::iterator_range<attr_iterator> attr_range*/
//  public final class attr_range extends iterator_range<Attr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::attrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 460,
   FQN="clang::Decl::attrs", NM="_ZNK5clang4Decl5attrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl5attrsEv")
  //</editor-fold>
  public iterator_range<Attr /*P*/ /*const*/> attrs() /*const*/ {
    return new iterator_range<Attr /*P*/ /*const*/>(attr_begin(), attr_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::attr_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 464,
   FQN="clang::Decl::attr_begin", NM="_ZNK5clang4Decl10attr_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl10attr_beginEv")
  //</editor-fold>
  public type$ptr<Attr /*P*/> attr_begin() /*const*/ {
    return hasAttrs() ? getAttrs$Const().begin$Const() : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::attr_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 467,
   FQN="clang::Decl::attr_end", NM="_ZNK5clang4Decl8attr_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl8attr_endEv")
  //</editor-fold>
  public type$ptr<Attr /*P*/> attr_end() /*const*/ {
    return hasAttrs() ? getAttrs$Const().end$Const() : null;
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::dropAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 472,
   FQN="clang::Decl::dropAttr", NM="Tpl__ZN5clang4Decl8dropAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZN5clang4Decl8dropAttrEv")
  //</editor-fold>
  public </*typename*/ T extends Attr> void dropAttr(Class<T> clazz) {
    if (!HasAttrs) {
      return;
    }
    
    final SmallVector<Attr /*P*/>/*&*/ Vec = getAttrs();
    Vec.erase(std.remove_if(Vec.begin(), Vec.end(), (Attr a)->llvm.isa(clazz, a)), Vec.end());
    if (Vec.empty()) {
      HasAttrs = false;
    }
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::specific_attrs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 483,
   FQN="clang::Decl::specific_attrs", NM="Tpl__ZNK5clang4Decl14specific_attrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Decl14specific_attrsEv")
  //</editor-fold>
  public </*typename*/ T extends Attr> iterator_range<T /*P*/ > specific_attrs(Class<T> clazz) /*const*/ {
    return llvm.make_range(specific_attr_begin(clazz), specific_attr_end(clazz));
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::specific_attr_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 488,
   FQN="clang::Decl::specific_attr_begin", NM="Tpl__ZNK5clang4Decl19specific_attr_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Decl19specific_attr_beginEv")
  //</editor-fold>
  public </*typename*/ T extends Attr> specific_attr_iterator<T> specific_attr_begin(Class<T> clazz) /*const*/ {
    return new specific_attr_iterator<T>(clazz, attr_begin());
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::specific_attr_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 492,
   FQN="clang::Decl::specific_attr_end", NM="Tpl__ZNK5clang4Decl17specific_attr_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Decl17specific_attr_endEv")
  //</editor-fold>
  public </*typename*/ T extends Attr> specific_attr_iterator<T> specific_attr_end(Class<T> clazz) /*const*/ {
    return new specific_attr_iterator<T>(clazz, attr_end());
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 496,
   FQN="clang::Decl::getAttr", NM="Tpl__ZNK5clang4Decl7getAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Decl7getAttrEv")
  //</editor-fold>
  public </*typename*/ T extends Attr> T /*P*/ getAttr(Class<T> clazz) /*const*/ {
    return hasAttrs() ? getSpecificAttr/*<T>*/(clazz, getAttrs$Const()) : null;
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 499,
   FQN="clang::Decl::hasAttr", NM="Tpl__ZNK5clang4Decl7hasAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZNK5clang4Decl7hasAttrEv")
  //</editor-fold>
  public </*typename*/ T extends Attr> boolean hasAttr(Class<T> clazz) /*const*/ {
    return hasAttrs() && hasSpecificAttr/*<T>*/(clazz, getAttrs$Const());
  }

  
  /// getMaxAlignment - return the maximum alignment specified by attributes
  /// on this decl, 0 if there are none.
  
  /// getMaxAlignment - return the maximum alignment specified by attributes
  /// on this decl, 0 if there are none.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getMaxAlignment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 331,
   FQN="clang::Decl::getMaxAlignment", NM="_ZNK5clang4Decl15getMaxAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15getMaxAlignmentEv")
  //</editor-fold>
  public /*uint*/int getMaxAlignment() /*const*/ {
    if (!hasAttrs()) {
      return 0;
    }
    
    /*uint*/int Align = 0;
    final /*const*/SmallVector<Attr /*P*/>/*&*/ V = getAttrs$Const();
    final ASTContext /*&*/ Ctx = getASTContext();
    specific_attr_iterator<AlignedAttr> I/*J*/= new specific_attr_iterator<AlignedAttr>(AlignedAttr.class, V.begin$Const());
    specific_attr_iterator<AlignedAttr> E/*J*/= new specific_attr_iterator<AlignedAttr>(AlignedAttr.class, V.end$Const());
    for (; specific_attr_iterator.$noteq_specific_attr_iterator$SpecificAttr(/*NO_COPY*/I, /*NO_COPY*/E); I.$preInc())  {
      Align = std.max(Align, I.$arrow().getAlignment(Ctx));
    }
    return Align;
  }


  
  /// setInvalidDecl - Indicates the Decl had a semantic error. This
  /// allows for graceful error recovery.
  
  /// setInvalidDecl - Indicates the Decl had a semantic error. This
  /// allows for graceful error recovery.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setInvalidDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 112,
   FQN="clang::Decl::setInvalidDecl", NM="_ZN5clang4Decl14setInvalidDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl14setInvalidDeclEb")
  //</editor-fold>
  public void setInvalidDecl() {
    setInvalidDecl(true);
  }
  public void setInvalidDecl(boolean Invalid/*= true*/) {
    InvalidDecl = Invalid;
    assert (!isa_TagDecl(this) || !cast_TagDecl(this).isCompleteDefinition());
    if (Invalid && !isa_ParmVarDecl(this)) {
      // Defensive maneuver for ill-formed code: we're likely not to make it to
      // a point where we set the access specifier, so default it to "public"
      // to avoid triggering asserts elsewhere in the front end. 
      setAccess(AccessSpecifier.AS_public);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isInvalidDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 510,
   FQN="clang::Decl::isInvalidDecl", NM="_ZNK5clang4Decl13isInvalidDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13isInvalidDeclEv")
  //</editor-fold>
  public boolean isInvalidDecl() /*const*/ {
    return (boolean)InvalidDecl;
  }

  
  /// isImplicit - Indicates whether the declaration was implicitly
  /// generated by the implementation. If false, this declaration
  /// was written explicitly in the source code.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 515,
   FQN="clang::Decl::isImplicit", NM="_ZNK5clang4Decl10isImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl10isImplicitEv")
  //</editor-fold>
  public boolean isImplicit() /*const*/ {
    return Implicit;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 516,
   FQN="clang::Decl::setImplicit", NM="_ZN5clang4Decl11setImplicitEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl11setImplicitEb")
  //</editor-fold>
  public void setImplicit() {
    setImplicit(true);
  }
  public void setImplicit(boolean I/*= true*/) {
    Implicit = I;
  }

  
  /// \brief Whether *any* (re-)declaration of the entity was used, meaning that
  /// a definition is required.
  ///
  /// \param CheckUsedAttr When true, also consider the "used" attribute
  /// (in addition to the "used" bit set by \c setUsed()) when determining
  /// whether the function is used.
  
  /// \brief Whether *any* (re-)declaration of the entity was used, meaning that
  /// a definition is required.
  ///
  /// \param CheckUsedAttr When true, also consider the "used" attribute
  /// (in addition to the "used" bit set by \c setUsed()) when determining
  /// whether the function is used.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 344,
   FQN="clang::Decl::isUsed", NM="_ZNK5clang4Decl6isUsedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl6isUsedEb")
  //</editor-fold>
  public boolean isUsed() /*const*/ {
    return isUsed(true);
  }
  public boolean isUsed(boolean CheckUsedAttr/*= true*/) /*const*/ {
    /*const*/ Decl /*P*/ CanonD = getCanonicalDecl$Const();
    if (CanonD.Used) {
      return true;
    }
    
    // Check for used attribute.
    // Ask the most recent decl, since attributes accumulate in the redecl chain.
    if (CheckUsedAttr && getMostRecentDecl$Decl$Const().hasAttr(UsedAttr.class)) {
      return true;
    }
    
    // The information may have not been deserialized yet. Force deserialization
    // to complete the needed information.
    return getMostRecentDecl$Decl$Const().getCanonicalDecl$Const().Used;
  }


  
  /// \brief Set whether the declaration is used, in the sense of odr-use.
  ///
  /// This should only be used immediately after creating a declaration.
  /// It intentionally doesn't notify any listeners.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setIsUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 530,
   FQN="clang::Decl::setIsUsed", NM="_ZN5clang4Decl9setIsUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl9setIsUsedEv")
  //</editor-fold>
  public void setIsUsed() {
    getCanonicalDecl().Used = true;
  }

  
  /// \brief Mark the declaration used, in the sense of odr-use.
  ///
  /// This notifies any mutation listeners in addition to setting a bit
  /// indicating the declaration is used.
  
  /// \brief Mark the declaration used, in the sense of odr-use.
  ///
  /// This notifies any mutation listeners in addition to setting a bit
  /// indicating the declaration is used.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::markUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 359,
   FQN="clang::Decl::markUsed", NM="_ZN5clang4Decl8markUsedERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl8markUsedERNS_10ASTContextE")
  //</editor-fold>
  public void markUsed(final ASTContext /*&*/ C) {
    if (isUsed(false)) {
      return;
    }
    if ((C.getASTMutationListener() != null)) {
      C.getASTMutationListener().DeclarationMarkedUsed(this);
    }
    
    setIsUsed();
  }


  
  /// \brief Whether any declaration of this entity was referenced.
  
  /// \brief Whether any declaration of this entity was referenced.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isReferenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 369,
   FQN="clang::Decl::isReferenced", NM="_ZNK5clang4Decl12isReferencedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl12isReferencedEv")
  //</editor-fold>
  public boolean isReferenced() /*const*/ {
    if (Referenced) {
      return true;
    }
    
    // Check redeclarations.
    for (Decl /*P*/ I : decl_redecls())  {
      if (I.Referenced) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Whether this declaration was referenced. This should not be relied
  /// upon for anything other than debugging.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isThisDeclarationReferenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 543,
   FQN="clang::Decl::isThisDeclarationReferenced", NM="_ZNK5clang4Decl27isThisDeclarationReferencedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl27isThisDeclarationReferencedEv")
  //</editor-fold>
  public boolean isThisDeclarationReferenced() /*const*/ {
    return Referenced;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setReferenced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 545,
   FQN="clang::Decl::setReferenced", NM="_ZN5clang4Decl13setReferencedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl13setReferencedEb")
  //</editor-fold>
  public void setReferenced() {
    setReferenced(true);
  }
  public void setReferenced(boolean R/*= true*/) {
    Referenced = R;
  }

  
  /// \brief Whether this declaration is a top-level declaration (function,
  /// global variable, etc.) that is lexically inside an objc container
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 550,
   FQN="clang::Decl::isTopLevelDeclInObjCContainer", NM="_ZNK5clang4Decl29isTopLevelDeclInObjCContainerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl29isTopLevelDeclInObjCContainerEv")
  //</editor-fold>
  public boolean isTopLevelDeclInObjCContainer() /*const*/ {
    return ((NextInContextAndBits.getInt() & TopLevelDeclInObjCContainerFlag) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 554,
   FQN="clang::Decl::setTopLevelDeclInObjCContainer", NM="_ZN5clang4Decl30setTopLevelDeclInObjCContainerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl30setTopLevelDeclInObjCContainerEb")
  //</editor-fold>
  public void setTopLevelDeclInObjCContainer() {
    setTopLevelDeclInObjCContainer(true);
  }
  public void setTopLevelDeclInObjCContainer(boolean V/*= true*/) {
    /*uint*/int Bits = NextInContextAndBits.getInt();
    if (V) {
      Bits |= TopLevelDeclInObjCContainerFlag;
    } else {
      Bits &= ~TopLevelDeclInObjCContainerFlag;
    }
    NextInContextAndBits.setInt(Bits);
  }

  
  /// \brief Whether this declaration was marked as being private to the
  /// module in which it was defined.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isModulePrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 565,
   FQN="clang::Decl::isModulePrivate", NM="_ZNK5clang4Decl15isModulePrivateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl15isModulePrivateEv")
  //</editor-fold>
  public boolean isModulePrivate() /*const*/ {
    return ((NextInContextAndBits.getInt() & ModulePrivateFlag) != 0);
  }

  
  /// Return true if this declaration has an attribute which acts as
  /// definition of the entity, such as 'alias' or 'ifunc'.
  
  /// Return true if this declaration has an attribute which acts as
  /// definition of the entity, such as 'alias' or 'ifunc'.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasDefiningAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 381,
   FQN="clang::Decl::hasDefiningAttr", NM="_ZNK5clang4Decl15hasDefiningAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15hasDefiningAttrEv")
  //</editor-fold>
  public boolean hasDefiningAttr() /*const*/ {
    return hasAttr(AliasAttr.class) || hasAttr(IFuncAttr.class);
  }


  
  /// Return this declaration's defining attribute if it has one.
  
  /// Return this declaration's defining attribute if it has one.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getDefiningAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 385,
   FQN="clang::Decl::getDefiningAttr", NM="_ZNK5clang4Decl15getDefiningAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15getDefiningAttrEv")
  //</editor-fold>
  public /*const*/ Attr /*P*/ getDefiningAttr() /*const*/ {
    {
      AliasAttr /*P*/ AA = getAttr(AliasAttr.class);
      if ((AA != null)) {
        return AA;
      }
    }
    {
      IFuncAttr /*P*/ IFA = getAttr(IFuncAttr.class);
      if ((IFA != null)) {
        return IFA;
      }
    }
    return null;
  }


/*protected:*/
  /// \brief Specify whether this declaration was marked as being private
  /// to the module in which it was defined.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setModulePrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 579,
   FQN="clang::Decl::setModulePrivate", NM="_ZN5clang4Decl16setModulePrivateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl16setModulePrivateEb")
  //</editor-fold>
  public void setModulePrivate() {
    setModulePrivate(true);
  }
  public void setModulePrivate(boolean MP/*= true*/) {
    /*uint*/int Bits = NextInContextAndBits.getInt();
    if (MP) {
      Bits |= ModulePrivateFlag;
    } else {
      Bits &= ~ModulePrivateFlag;
    }
    NextInContextAndBits.setInt(Bits);
  }

  
  /// \brief Set the owning module ID.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setOwningModuleID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 589,
   FQN="clang::Decl::setOwningModuleID", NM="_ZN5clang4Decl17setOwningModuleIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl17setOwningModuleIDEj")
  //</editor-fold>
  /*friend*/public void setOwningModuleID(/*uint*/int ID) {
    assert (isFromASTFile()) : "Only works on a deserialized declaration";
    ((type$ptr/*uint P*/ )$This$InASTContext.$sub(2)).$set(Integer.valueOf(ID));
  }
  

/*public:*/
  
  /// \brief Determine the availability of the given declaration.
  ///
  /// This routine will determine the most restrictive availability of
  /// the given declaration (e.g., preferring 'unavailable' to
  /// 'deprecated').
  ///
  /// \param Message If non-NULL and the result is not \c
  /// AR_Available, will be set to a (possibly empty) message
  /// describing why the declaration has not been introduced, is
  /// deprecated, or is unavailable.
  
  /// \brief Determine the availability of the given declaration.
  ///
  /// This routine will determine the most restrictive availability of
  /// the given declaration (e.g., preferring 'unavailable' to
  /// 'deprecated').
  ///
  /// \param Message If non-NULL and the result is not \c
  /// AR_Available, will be set to a (possibly empty) message
  /// describing why the declaration has not been introduced, is
  /// deprecated, or is unavailable.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAvailability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 497,
   FQN="clang::Decl::getAvailability", NM="_ZNK5clang4Decl15getAvailabilityEPSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15getAvailabilityEPSs")
  //</editor-fold>
  public AvailabilityResult getAvailability() /*const*/ {
    return getAvailability((std.string/*P*/ )null);
  }
  public AvailabilityResult getAvailability(std.string/*P*/ Message/*= null*/) /*const*/ {
    {
      /*const*/ FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(this);
      if ((FTD != null)) {
        return FTD.getTemplatedDecl().getAvailability(Message);
      }
    }
    
    AvailabilityResult Result = AvailabilityResult.AR_Available;
    std.string ResultMessage/*J*/= new std.string();
    
    for (/*const*/ Attr /*P*/ A : attrs()) {
      {
        /*const*/ DeprecatedAttr /*P*/ Deprecated = dyn_cast_DeprecatedAttr(A);
        if ((Deprecated != null)) {
          if (Result.getValue() >= AvailabilityResult.AR_Deprecated.getValue()) {
            continue;
          }
          if ((Message != null)) {
            ResultMessage.$assignMove(Deprecated.getMessage().$string());
          }
          
          Result = AvailabilityResult.AR_Deprecated;
          continue;
        }
      }
      {
        
        /*const*/ UnavailableAttr /*P*/ Unavailable = dyn_cast_UnavailableAttr(A);
        if ((Unavailable != null)) {
          if ((Message != null)) {
            /*Deref*/Message.$assignMove(Unavailable.getMessage().$string());
          }
          return AvailabilityResult.AR_Unavailable;
        }
      }
      {
        
        /*const*/ AvailabilityAttr /*P*/ Availability = dyn_cast_AvailabilityAttr(A);
        if ((Availability != null)) {
          AvailabilityResult AR = CheckAvailability(getASTContext(), Availability, 
              Message);
          if (AR == AvailabilityResult.AR_Unavailable) {
            return AvailabilityResult.AR_Unavailable;
          }
          if (AR.getValue() > Result.getValue()) {
            Result = AR;
            if ((Message != null)) {
              ResultMessage.swap($Deref(Message));
            }
          }
          continue;
        }
      }
    }
    if ((Message != null)) {
      Message.swap(ResultMessage);
    }
    return Result;
  }


  
  /// \brief Determine whether this declaration is marked 'deprecated'.
  ///
  /// \param Message If non-NULL and the declaration is deprecated,
  /// this will be set to the message describing why the declaration
  /// was deprecated (which may be empty).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isDeprecated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 613,
   FQN="clang::Decl::isDeprecated", NM="_ZNK5clang4Decl12isDeprecatedEPSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl12isDeprecatedEPSs")
  //</editor-fold>
  public boolean isDeprecated() /*const*/ {
    return isDeprecated((std.string/*P*/ )null);
  }
  public boolean isDeprecated(std.string/*P*/ Message/*= null*/) /*const*/ {
    return getAvailability(Message) == AvailabilityResult.AR_Deprecated;
  }

  
  /// \brief Determine whether this declaration is marked 'unavailable'.
  ///
  /// \param Message If non-NULL and the declaration is unavailable,
  /// this will be set to the message describing why the declaration
  /// was made unavailable (which may be empty).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isUnavailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 622,
   FQN="clang::Decl::isUnavailable", NM="_ZNK5clang4Decl13isUnavailableEPSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13isUnavailableEPSs")
  //</editor-fold>
  public boolean isUnavailable() /*const*/ {
    return isUnavailable((std.string/*P*/ )null);
  }
  public boolean isUnavailable(std.string/*P*/ Message/*= null*/) /*const*/ {
    return getAvailability(Message) == AvailabilityResult.AR_Unavailable;
  }

  
  /// \brief Determine whether this is a weak-imported symbol.
  ///
  /// Weak-imported symbols are typically marked with the
  /// 'weak_import' attribute, but may also be marked with an
  /// 'availability' attribute where we're targing a platform prior to
  /// the introduction of this feature.
  
  /// \brief Determine whether this is a weak-imported symbol.
  ///
  /// Weak-imported symbols are typically marked with the
  /// 'weak_import' attribute, but may also be marked with an
  /// 'availability' attribute where we're targing a platform prior to
  /// the introduction of this feature.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isWeakImported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 573,
   FQN="clang::Decl::isWeakImported", NM="_ZNK5clang4Decl14isWeakImportedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl14isWeakImportedEv")
  //</editor-fold>
  public boolean isWeakImported() /*const*/ {
    bool$ref IsDefinition = create_bool$ref();
    if (!canBeWeakImported(IsDefinition)) {
      return false;
    }
    
    for (/*const*/ Attr /*P*/ A : attrs()) {
      if (isa_WeakImportAttr(A)) {
        return true;
      }
      {
        
        /*const*/ AvailabilityAttr /*P*/ Availability = dyn_cast_AvailabilityAttr(A);
        if ((Availability != null)) {
          if (CheckAvailability(getASTContext(), Availability, 
              (std.string/*P*/ )null) == AvailabilityResult.AR_NotYetIntroduced) {
            return true;
          }
        }
      }
    }
    
    return false;
  }


  
  /// \brief Determines whether this symbol can be weak-imported,
  /// e.g., whether it would be well-formed to add the weak_import
  /// attribute.
  ///
  /// \param IsDefinition Set to \c true to indicate that this
  /// declaration cannot be weak-imported because it has a definition.
  
  /// \brief Determines whether this symbol can be weak-imported,
  /// e.g., whether it would be well-formed to add the weak_import
  /// attribute.
  ///
  /// \param IsDefinition Set to \c true to indicate that this
  /// declaration cannot be weak-imported because it has a definition.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::canBeWeakImported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 543,
   FQN="clang::Decl::canBeWeakImported", NM="_ZNK5clang4Decl17canBeWeakImportedERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl17canBeWeakImportedERb")
  //</editor-fold>
  public boolean canBeWeakImported(final bool$ref/*bool &*/ IsDefinition) /*const*/ {
    IsDefinition.$set(false);
    {
      
      // Variables, if they aren't definitions.
      /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(this);
      if ((Var != null)) {
        if ((Var.isThisDeclarationADefinition().getValue() != 0)) {
          IsDefinition.$set(true);
          return false;
        }
        return true;
        // Functions, if they aren't definitions.
      } else {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(this);
        if ((FD != null)) {
          if (FD.hasBody()) {
            IsDefinition.$set(true);
            return false;
          }
          return true;
          // Objective-C classes, if this is the non-fragile runtime.
        } else if (isa_ObjCInterfaceDecl(this)
           && getASTContext().getLangOpts().ObjCRuntime.hasWeakClassImport()) {
          return true;
          // Nothing else.
        } else {
          return false;
        }
      }
    }
  }


  
  /// \brief Determine whether this declaration came from an AST file (such as
  /// a precompiled header or module) rather than having been parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isFromASTFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 644,
   FQN="clang::Decl::isFromASTFile", NM="_ZNK5clang4Decl13isFromASTFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13isFromASTFileEv")
  //</editor-fold>
  public boolean isFromASTFile() /*const*/ {
    return FromASTFile;
  }

  
  /// \brief Retrieve the global declaration ID associated with this 
  /// declaration, which specifies where in the 
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getGlobalID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 648,
   FQN="clang::Decl::getGlobalID", NM="_ZNK5clang4Decl11getGlobalIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl11getGlobalIDEv")
  //</editor-fold>
  public /*uint*/int getGlobalID() /*const*/ {
    if (isFromASTFile()) {
      return (Integer)((/*const*/type$ptr/*uint P*/ )$This$InASTContext.$sub(1)).$star();
    }
    return 0;
  }

  
  /// \brief Retrieve the global ID of the module that owns this particular
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getOwningModuleID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 656,
   FQN="clang::Decl::getOwningModuleID", NM="_ZNK5clang4Decl17getOwningModuleIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl17getOwningModuleIDEv")
  //</editor-fold>
  public /*uint*/int getOwningModuleID() /*const*/ {
    if (isFromASTFile()) {
      return (Integer)((/*const*/type$ptr/*uint P*/ )$This$InASTContext.$sub(2)).$star();
    }
    
    return 0;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getOwningModuleSlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 94,
   FQN="clang::Decl::getOwningModuleSlow", NM="_ZNK5clang4Decl19getOwningModuleSlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl19getOwningModuleSlowEv")
  //</editor-fold>
  private Module /*P*/ getOwningModuleSlow() /*const*/ {
    assert (isFromASTFile()) : "Not from AST file?";
    return getASTContext().getExternalSource().getModule(getOwningModuleID());
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasLocalOwningModuleStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 99,
   FQN="clang::Decl::hasLocalOwningModuleStorage", NM="_ZNK5clang4Decl27hasLocalOwningModuleStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl27hasLocalOwningModuleStorageEv")
  //</editor-fold>
  protected boolean hasLocalOwningModuleStorage() /*const*/ {
    return getASTContext().getLangOpts().ModulesLocalVisibility;
  }


/*public:*/
  /// \brief Get the imported owning module, if this decl is from an imported
  /// (non-local) module.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getImportedOwningModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 671,
   FQN="clang::Decl::getImportedOwningModule", NM="_ZNK5clang4Decl23getImportedOwningModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl23getImportedOwningModuleEv")
  //</editor-fold>
  public Module /*P*/ getImportedOwningModule() /*const*/ {
    if (!isFromASTFile()) {
      return null;
    }
    
    return getOwningModuleSlow();
  }

  
  /// \brief Get the local owning module, if known. Returns nullptr if owner is
  /// not yet known or declaration is not from a module.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getLocalOwningModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 680,
   FQN="clang::Decl::getLocalOwningModule", NM="_ZNK5clang4Decl20getLocalOwningModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl20getLocalOwningModuleEv")
  //</editor-fold>
  public Module /*P*/ getLocalOwningModule() /*const*/ {
    if (isFromASTFile() || !Hidden) {
      return null;
    }
    return ((type$ptr<Module /*P*/ /*const*/ /*P*/>)$This$InASTContext).$at(-1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setLocalOwningModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 685,
   FQN="clang::Decl::setLocalOwningModule", NM="_ZN5clang4Decl20setLocalOwningModuleEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl20setLocalOwningModuleEPNS_6ModuleE")
  //</editor-fold>
  public void setLocalOwningModule(Module /*P*/ M) {
    assert (!isFromASTFile() && Hidden && hasLocalOwningModuleStorage()) : "should not have a cached owning module";
    ((type$ptr<Module /*P*/ /*P*/>)$This$InASTContext).$set(-1, M);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getIdentifierNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 691,
   FQN="clang::Decl::getIdentifierNamespace", NM="_ZNK5clang4Decl22getIdentifierNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl22getIdentifierNamespaceEv")
  //</editor-fold>
  public /*uint*/int getIdentifierNamespace() /*const*/ {
    return IdentifierNamespace_field;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isInIdentifierNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 694,
   FQN="clang::Decl::isInIdentifierNamespace", NM="_ZNK5clang4Decl23isInIdentifierNamespaceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl23isInIdentifierNamespaceEj")
  //</editor-fold>
  public boolean isInIdentifierNamespace(/*uint*/int NS) /*const*/ {
    return ((getIdentifierNamespace() & NS) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getIdentifierNamespaceForKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 592,
   FQN="clang::Decl::getIdentifierNamespaceForKind", NM="_ZN5clang4Decl29getIdentifierNamespaceForKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl29getIdentifierNamespaceForKindENS0_4KindE")
  //</editor-fold>
  public static /*uint*/int getIdentifierNamespaceForKind(Kind DeclKind) {
    switch (DeclKind) {
     case Function:
     case CXXMethod:
     case CXXConstructor:
     case ConstructorUsingShadow:
     case CXXDestructor:
     case CXXConversion:
     case EnumConstant:
     case Var:
     case ImplicitParam:
     case ParmVar:
     case ObjCMethod:
     case ObjCProperty:
     case MSProperty:
      return IdentifierNamespace.IDNS_Ordinary;
     case Label:
      return IdentifierNamespace.IDNS_Label;
     case IndirectField:
      return IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Member;
     case NonTypeTemplateParm:
      // Non-type template parameters are not found by lookups that ignore
      // non-types, but they are found by redeclaration lookups for tag types,
      // so we include them in the tag namespace.
      return IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Tag;
     case ObjCCompatibleAlias:
     case ObjCInterface:
      return IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Type;
     case Typedef:
     case TypeAlias:
     case TypeAliasTemplate:
     case UnresolvedUsingTypename:
     case TemplateTypeParm:
     case ObjCTypeParam:
      return IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Type;
     case UsingShadow:
      return 0; // we'll actually overwrite this later
     case UnresolvedUsingValue:
      return IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Using;
     case Using:
      return IdentifierNamespace.IDNS_Using;
     case ObjCProtocol:
      return IdentifierNamespace.IDNS_ObjCProtocol;
     case Field:
     case ObjCAtDefsField:
     case ObjCIvar:
      return IdentifierNamespace.IDNS_Member;
     case Record:
     case CXXRecord:
     case Enum:
      return IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Type;
     case Namespace:
     case NamespaceAlias:
      return IdentifierNamespace.IDNS_Namespace;
     case FunctionTemplate:
     case VarTemplate:
      return IdentifierNamespace.IDNS_Ordinary;
     case ClassTemplate:
     case TemplateTemplateParm:
      return IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Type;
     case OMPDeclareReduction:
      return IdentifierNamespace.IDNS_OMPReduction;
     case Friend:
     case FriendTemplate:
     case AccessSpec:
     case LinkageSpec:
     case FileScopeAsm:
     case StaticAssert:
     case ObjCPropertyImpl:
     case PragmaComment:
     case PragmaDetectMismatch:
     case Block:
     case Captured:
     case TranslationUnit:
     case ExternCContext:
     case UsingDirective:
     case BuiltinTemplate:
     case ClassTemplateSpecialization:
     case ClassTemplatePartialSpecialization:
     case ClassScopeFunctionSpecialization:
     case VarTemplateSpecialization:
     case VarTemplatePartialSpecialization:
     case ObjCImplementation:
     case ObjCCategory:
     case ObjCCategoryImpl:
     case Import:
     case OMPThreadPrivate:
     case OMPCapturedExpr:
     case Empty:
      // Never looked up by name.
      return 0;
    }
    throw new llvm_unreachable("Invalid DeclKind!");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasTagIdentifierNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 699,
   FQN="clang::Decl::hasTagIdentifierNamespace", NM="_ZNK5clang4Decl25hasTagIdentifierNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl25hasTagIdentifierNamespaceEv")
  //</editor-fold>
  public boolean hasTagIdentifierNamespace() /*const*/ {
    return isTagIdentifierNamespace(getIdentifierNamespace());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isTagIdentifierNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 702,
   FQN="clang::Decl::isTagIdentifierNamespace", NM="_ZN5clang4Decl24isTagIdentifierNamespaceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl24isTagIdentifierNamespaceEj")
  //</editor-fold>
  public static boolean isTagIdentifierNamespace(/*uint*/int NS) {
    // TagDecls have Tag and Type set and may also have TagFriend.
    return (NS & ~IdentifierNamespace.IDNS_TagFriend) == (IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Type);
  }

  
  /// getLexicalDeclContext - The declaration context where this Decl was
  /// lexically declared (LexicalDC). May be different from
  /// getDeclContext() (SemanticDC).
  /// e.g.:
  ///
  ///   namespace A {
  ///      void f(); // SemanticDC == LexicalDC == 'namespace A'
  ///   }
  ///   void A::f(); // SemanticDC == namespace 'A'
  ///                // LexicalDC == global namespace
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getLexicalDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 717,
   FQN="clang::Decl::getLexicalDeclContext", NM="_ZN5clang4Decl21getLexicalDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl21getLexicalDeclContextEv")
  //</editor-fold>
  public DeclContext /*P*/ getLexicalDeclContext() {
    if (isInSemaDC()) {
      return getSemanticDC();
    }
    return getMultipleDC().LexicalDC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getLexicalDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 722,
   FQN="clang::Decl::getLexicalDeclContext", NM="_ZNK5clang4Decl21getLexicalDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl21getLexicalDeclContextEv")
  //</editor-fold>
  public /*const*/ DeclContext /*P*/ getLexicalDeclContext$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getLexicalDeclContext();
  }

  
  /// Determine whether this declaration is declared out of line (outside its
  /// semantic context).
  
  /// Determine whether this declaration is declared out of line (outside its
  /// semantic context).
  
  // Defined here so that it can be inlined into its direct callers.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isOutOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 44,
   FQN="clang::Decl::isOutOfLine", NM="_ZNK5clang4Decl11isOutOfLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang4Decl11isOutOfLineEv")
  //</editor-fold>
  public boolean isOutOfLine() /*const*/ {
    return !getLexicalDeclContext$Const().Equals(getDeclContext$Const());
  }


  
  /// setDeclContext - Set both the semantic and lexical DeclContext
  /// to DC.
  
  /// setDeclContext - Set both the semantic and lexical DeclContext
  /// to DC.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setDeclContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 253,
   FQN="clang::Decl::setDeclContext", NM="_ZN5clang4Decl14setDeclContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl14setDeclContextEPNS_11DeclContextE")
  //</editor-fold>
  public void setDeclContext(DeclContext /*P*/ DC) {
    DeclCtx.$assign_T$C$R(DeclContext /*P*/.class, DC);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setLexicalDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 257,
   FQN="clang::Decl::setLexicalDeclContext", NM="_ZN5clang4Decl21setLexicalDeclContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl21setLexicalDeclContextEPNS_11DeclContextE")
  //</editor-fold>
  public void setLexicalDeclContext(DeclContext /*P*/ DC) {
    if (DC == getLexicalDeclContext()) {
      return;
    }
    if (isInSemaDC()) {
      setDeclContextsImpl(getDeclContext(), DC, getASTContext());
    } else {
      getMultipleDC().LexicalDC = DC;
    }
    Hidden = cast_Decl(DC).Hidden;
  }


  
  /// isDefinedOutsideFunctionOrMethod - This predicate returns true if this
  /// scoped decl is defined outside the current function or method.  This is
  /// roughly global variables and functions, but also handles enums (which
  /// could be defined inside or outside a function etc).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isDefinedOutsideFunctionOrMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 740,
   FQN="clang::Decl::isDefinedOutsideFunctionOrMethod", NM="_ZNK5clang4Decl32isDefinedOutsideFunctionOrMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl32isDefinedOutsideFunctionOrMethodEv")
  //</editor-fold>
  public boolean isDefinedOutsideFunctionOrMethod() /*const*/ {
    return getParentFunctionOrMethod$Const() == null;
  }

  
  /// \brief Returns true if this declaration lexically is inside a function.
  /// It recognizes non-defining declarations as well as members of local
  /// classes:
  /// \code
  ///     void foo() { void bar(); }
  ///     void foo2() { class ABC { void bar(); }; }
  /// \endcode
  
  /// \brief Returns true if this declaration lexically is inside a function.
  /// It recognizes non-defining declarations as well as members of local
  /// classes:
  /// \code
  ///     void foo() { void bar(); }
  ///     void foo2() { class ABC { void bar(); }; }
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isLexicallyWithinFunctionOrMethod">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 281,
   FQN="clang::Decl::isLexicallyWithinFunctionOrMethod", NM="_ZNK5clang4Decl33isLexicallyWithinFunctionOrMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl33isLexicallyWithinFunctionOrMethodEv")
  //</editor-fold>
  public boolean isLexicallyWithinFunctionOrMethod() /*const*/ {
    /*const*/ DeclContext /*P*/ LDC = getLexicalDeclContext$Const();
    while (true) {
      if (LDC.isFunctionOrMethod()) {
        return true;
      }
      if (!isa_TagDecl(LDC)) {
        return false;
      }
      LDC = LDC.getLexicalParent$Const();
    }
    //JAVA: return false;
  }


  
  /// \brief If this decl is defined inside a function/method/block it returns
  /// the corresponding DeclContext, otherwise it returns null.
  
  /// \brief If this decl is defined inside a function/method/block it returns
  /// the corresponding DeclContext, otherwise it returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getParentFunctionOrMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 211,
   FQN="clang::Decl::getParentFunctionOrMethod", NM="_ZNK5clang4Decl25getParentFunctionOrMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl25getParentFunctionOrMethodEv")
  //</editor-fold>
  public /*const*/ DeclContext /*P*/ getParentFunctionOrMethod$Const() /*const*/ {
    for (/*const*/ DeclContext /*P*/ DC = getDeclContext$Const();
         (DC != null) && !DC.isTranslationUnit() && !DC.isNamespace();
         DC = DC.getParent$Const())  {
      if (DC.isFunctionOrMethod()) {
        return DC;
      }
    }
    
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getParentFunctionOrMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 756,
   FQN="clang::Decl::getParentFunctionOrMethod", NM="_ZN5clang4Decl25getParentFunctionOrMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl25getParentFunctionOrMethodEv")
  //</editor-fold>
  public DeclContext /*P*/ getParentFunctionOrMethod() {
    return ((/*const_cast*/DeclContext /*P*/ )(((/*const_cast*//*const*/ Decl /*P*/ )(this)).getParentFunctionOrMethod$Const()));
  }

  
  /// \brief Retrieves the "canonical" declaration of the given declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 762,
   FQN="clang::Decl::getCanonicalDecl", NM="_ZN5clang4Decl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl16getCanonicalDeclEv")
  //</editor-fold>
  public /*virtual*/ Decl /*P*/ getCanonicalDecl() {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 763,
   FQN="clang::Decl::getCanonicalDecl", NM="_ZNK5clang4Decl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getCanonicalDecl();
  }

  
  /// \brief Whether this particular Decl is a canonical one.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 768,
   FQN="clang::Decl::isCanonicalDecl", NM="_ZNK5clang4Decl15isCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl15isCanonicalDeclEv")
  //</editor-fold>
  public boolean isCanonicalDecl() /*const*/ {
    return getCanonicalDecl$Const() == this;
  }

/*protected:*/
  /// \brief Returns the next redeclaration or itself if this is the only decl.
  ///
  /// Decl subclasses that can be redeclared should override this method so that
  /// Decl::redecl_iterator can iterate over them.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 775,
   FQN="clang::Decl::getNextRedeclarationImpl", NM="_ZN5clang4Decl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl24getNextRedeclarationImplEv")
  //</editor-fold>
  protected /*virtual*/ Decl /*P*/ getNextRedeclarationImpl() {
    return this;
  }

  
  /// \brief Implementation of getPreviousDecl(), to be overridden by any
  /// subclass that has a redeclaration chain.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 779,
   FQN="clang::Decl::getPreviousDeclImpl", NM="_ZN5clang4Decl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl19getPreviousDeclImplEv")
  //</editor-fold>
  protected /*virtual*/ Decl /*P*/ getPreviousDeclImpl() {
    return null;
  }

  
  /// \brief Implementation of getMostRecentDecl(), to be overridden by any
  /// subclass that has a redeclaration chain.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 783,
   FQN="clang::Decl::getMostRecentDeclImpl", NM="_ZN5clang4Decl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl21getMostRecentDeclImplEv")
  //</editor-fold>
  protected /*virtual*/ Decl /*P*/ getMostRecentDeclImpl() {
    return this;
  }

/*public:*/
  /// \brief Iterates through all the redeclarations of the same decl.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 787,
   FQN="clang::Decl::redecl_iterator", NM="_ZN5clang4Decl15redecl_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorE")
  //</editor-fold>
  public static class redecl_iterator implements type$iterator<redecl_iterator, Decl> {
    /// Current - The current declaration.
    private Decl /*P*/ Current;
    private Decl /*P*/ Starter;
  /*public:*/
    /*typedef Decl *value_type*/
//    public final class value_type extends Decl /*P*/ { };
    /*typedef const value_type &reference*/
//    public final class reference extends Decl /*P*/ /*const*/ /*&*/ { };
    /*typedef const value_type *pointer*/
//    public final class pointer extends type$ptr<Decl /*P*/ /*const*/ /*P*/>{ };
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    /*typedef std::ptrdiff_t difference_type*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::redecl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 799,
     FQN="clang::Decl::redecl_iterator::redecl_iterator", NM="_ZN5clang4Decl15redecl_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorC1Ev")
    //</editor-fold>
    public redecl_iterator() {
      // : Current(null) 
      //START JInit
      this.Current = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::redecl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 800,
     FQN="clang::Decl::redecl_iterator::redecl_iterator", NM="_ZN5clang4Decl15redecl_iteratorC1EPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorC1EPS0_")
    //</editor-fold>
    public /*explicit*/ redecl_iterator(Decl /*P*/ C) {
      // : Current(C), Starter(C) 
      //START JInit
      this.Current = C;
      this.Starter = C;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 802,
     FQN="clang::Decl::redecl_iterator::operator*", NM="_ZNK5clang4Decl15redecl_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl15redecl_iteratordeEv")
    //</editor-fold>
    public Decl /*P*/ /*const*/ /*&*/ $star() /*const*/ {
      return Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 803,
     FQN="clang::Decl::redecl_iterator::operator->", NM="_ZNK5clang4Decl15redecl_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl15redecl_iteratorptEv")
    //</editor-fold>
    public Decl /*P*/ $arrow() /*const*/ {
      return Current;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 805,
     FQN="clang::Decl::redecl_iterator::operator++", NM="_ZN5clang4Decl15redecl_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorppEv")
    //</editor-fold>
    public redecl_iterator /*&*/ $preInc() {
      assert ((Current != null)) : "Advancing while iterator has reached end";
      // Get either previous decl or latest decl.
      Decl /*P*/ Next = Current.getNextRedeclarationImpl();
      assert ((Next != null)) : "Should return next redeclaration or itself, never null!";
      Current = (Next != Starter) ? Next : null;
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 814,
     FQN="clang::Decl::redecl_iterator::operator++", NM="_ZN5clang4Decl15redecl_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorppEi")
    //</editor-fold>
    public redecl_iterator $postInc(int $Prm0) {
      redecl_iterator tmp/*J*/= new redecl_iterator(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 820,
     FQN="clang::operator==", NM="_ZN5clangeqENS_4Decl15redecl_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangeqENS_4Decl15redecl_iteratorES1_")
    //</editor-fold>
    public static boolean $eq_redecl_iterator(redecl_iterator x, redecl_iterator y) {
      return x.Current == y.Current;
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 823,
     FQN="clang::operator!=", NM="_ZN5clangneENS_4Decl15redecl_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangneENS_4Decl15redecl_iteratorES1_")
    //</editor-fold>
    public static boolean $noteq_redecl_iterator(redecl_iterator x, redecl_iterator y) {
      return x.Current != y.Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::redecl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 787,
     FQN="clang::Decl::redecl_iterator::redecl_iterator", NM="_ZN5clang4Decl15redecl_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ redecl_iterator(final /*const*/ redecl_iterator /*&*/ $Prm0) {
      // : Current(.Current), Starter(.Starter) 
      //START JInit
      this.Current = $Prm0.Current;
      this.Starter = $Prm0.Starter;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecl_iterator::redecl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 787,
     FQN="clang::Decl::redecl_iterator::redecl_iterator", NM="_ZN5clang4Decl15redecl_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15redecl_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ redecl_iterator(JD$Move _dparam, final redecl_iterator /*&&*/$Prm0) {
      // : Current(static_cast<redecl_iterator &&>().Current), Starter(static_cast<redecl_iterator &&>().Starter) 
      //START JInit
      this.Current = $Prm0.Current;
      this.Starter = $Prm0.Starter;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Current=" + Current // NOI18N
                + ", Starter=" + Starter; // NOI18N
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public type$ref<Decl> star$ref() {
      return new type$ref<Decl>() {
        private redecl_iterator localIter = $tryClone(redecl_iterator.this);
        @Override
        public Decl $deref() {
          return localIter.$star();
        }

        @Override
        public Decl $set(Decl value) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
      };
    }

    @Override public redecl_iterator clone() { return new redecl_iterator(this); }
    
    @Override public boolean $eq(Object other) { return $eq_redecl_iterator(this, (redecl_iterator)other); }
  };
  
  /*typedef llvm::iterator_range<redecl_iterator> redecl_range*/
//  public final class redecl_range extends iterator_range<Decl /*P*/ /*const*/ /*&*/ >{ };
  
  /// \brief Returns an iterator range for all the redeclarations of the same
  /// decl. It will iterate at least once (when this decl is the only one).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 832,
   FQN="clang::Decl::redecls", NM="_ZNK5clang4Decl7redeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl7redeclsEv")
  //</editor-fold>
  public final iterator_range<Decl /*P*/ /*const*/ /*&*/ > decl_redecls() /*const*/ {
    return new iterator_range<Decl /*P*/ /*const*/ /*&*/ >(decl_redecls_begin(), decl_redecls_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecls_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 836,
   FQN="clang::Decl::redecls_begin", NM="_ZNK5clang4Decl13redecls_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13redecls_beginEv")
  //</editor-fold>
  public final redecl_iterator decl_redecls_begin() /*const*/ {
    return new redecl_iterator(((/*const_cast*/Decl /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::redecls_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 839,
   FQN="clang::Decl::redecls_end", NM="_ZNK5clang4Decl11redecls_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl11redecls_endEv")
  //</editor-fold>
  public final redecl_iterator decl_redecls_end() /*const*/ {
    return new redecl_iterator();
  }

  
  /// \brief Retrieve the previous declaration that declares the same entity
  /// as this declaration, or NULL if there is no previous declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 843,
   FQN="clang::Decl::getPreviousDecl", NM="_ZN5clang4Decl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl15getPreviousDeclEv")
  //</editor-fold>
  public final Decl /*P*/ getPreviousDecl$Decl() {
    return getPreviousDeclImpl();
  }

  
  /// \brief Retrieve the most recent declaration that declares the same entity
  /// as this declaration, or NULL if there is no previous declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 847,
   FQN="clang::Decl::getPreviousDecl", NM="_ZNK5clang4Decl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl15getPreviousDeclEv")
  //</editor-fold>
  public final /*const*/ Decl /*P*/ getPreviousDecl$Decl$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getPreviousDeclImpl();
  }

  
  /// \brief True if this is the first declaration in its redeclaration chain.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isFirstDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 852,
   FQN="clang::Decl::isFirstDecl", NM="_ZNK5clang4Decl11isFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl11isFirstDeclEv")
  //</editor-fold>
  public final boolean isFirstDecl$Decl() /*const*/ {
    return getMostRecentDecl$Decl$Const() == null;
  }

  
  /// \brief Retrieve the most recent declaration that declares the same entity
  /// as this declaration (which may be this declaration).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 858,
   FQN="clang::Decl::getMostRecentDecl", NM="_ZN5clang4Decl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl17getMostRecentDeclEv")
  //</editor-fold>
  public final Decl /*P*/ getMostRecentDecl$Decl() {
    return getMostRecentDeclImpl();
  }

  
  /// \brief Retrieve the most recent declaration that declares the same entity
  /// as this declaration (which may be this declaration).
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 862,
   FQN="clang::Decl::getMostRecentDecl", NM="_ZNK5clang4Decl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl17getMostRecentDeclEv")
  //</editor-fold>
  public final /*const*/ Decl /*P*/ getMostRecentDecl$Decl$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getMostRecentDeclImpl();
  }

  
  /// getBody - If this Decl represents a declaration for a body of code,
  ///  such as a function or method definition, this method returns the
  ///  top-level Stmt* of that body.  Otherwise this method returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 869,
   FQN="clang::Decl::getBody", NM="_ZNK5clang4Decl7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl7getBodyEv")
  //</editor-fold>
  public /*virtual*/ Stmt /*P*/ getBody() /*const*/ {
    return null;
  }

  
  /// \brief Returns true if this \c Decl represents a declaration for a body of
  /// code, such as a function or method definition.
  /// Note that \c hasBody can also return true if any redeclaration of this
  /// \c Decl represents a declaration for a body of code.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::hasBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 875,
   FQN="clang::Decl::hasBody", NM="_ZNK5clang4Decl7hasBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl7hasBodyEv")
  //</editor-fold>
  public /*virtual*/ boolean hasBody() /*const*/ {
    return getBody() != null;
  }

  
  /// getBodyRBrace - Gets the right brace of the body, if a body exists.
  /// This works whether the body is a CompoundStmt or a CXXTryStmt.
  
  /// getBodyRBrace - Gets the right brace of the body, if a body exists.
  /// This works whether the body is a CompoundStmt or a CXXTryStmt.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getBodyRBrace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 764,
   FQN="clang::Decl::getBodyRBrace", NM="_ZNK5clang4Decl13getBodyRBraceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl13getBodyRBraceEv")
  //</editor-fold>
  public SourceLocation getBodyRBrace() /*const*/ {
    {
      // Special handling of FunctionDecl to avoid de-serializing the body from PCH.
      // FunctionDecl stores EndRangeLoc for this purpose.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(this);
      if ((FD != null)) {
        type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
        if (FD.hasBody(Definition)) {
          return Definition.$deref().getSourceRange().getEnd();
        }
        return new SourceLocation();
      }
    }
    {
      
      Stmt /*P*/ Body = getBody();
      if ((Body != null)) {
        return Body.getSourceRange().getEnd();
      }
    }
    
    return new SourceLocation();
  }


  
  // global temp stats (until we have a per-module visitor)
  
  // global temp stats (until we have a per-module visitor)
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::add">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 161,
   FQN="clang::Decl::add", NM="_ZN5clang4Decl3addENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl3addENS0_4KindE")
  //</editor-fold>
  public static void add(Kind k) {
    switch (k) {
     case AccessSpec:
      ++DeclNodesGlobals.nAccessSpecs;
      break;
     case Block:
      ++DeclNodesGlobals.nBlocks;
      break;
     case Captured:
      ++DeclNodesGlobals.nCaptureds;
      break;
     case ClassScopeFunctionSpecialization:
      ++DeclNodesGlobals.nClassScopeFunctionSpecializations;
      break;
     case Empty:
      ++DeclNodesGlobals.nEmptys;
      break;
     case ExternCContext:
      ++DeclNodesGlobals.nExternCContexts;
      break;
     case FileScopeAsm:
      ++DeclNodesGlobals.nFileScopeAsms;
      break;
     case Friend:
      ++DeclNodesGlobals.nFriends;
      break;
     case FriendTemplate:
      ++DeclNodesGlobals.nFriendTemplates;
      break;
     case Import:
      ++DeclNodesGlobals.nImports;
      break;
     case LinkageSpec:
      ++DeclNodesGlobals.nLinkageSpecs;
      break;
     case Label:
      ++DeclNodesGlobals.nLabels;
      break;
     case Namespace:
      ++DeclNodesGlobals.nNamespaces;
      break;
     case NamespaceAlias:
      ++DeclNodesGlobals.nNamespaceAliass;
      break;
     case ObjCCompatibleAlias:
      ++DeclNodesGlobals.nObjCCompatibleAliass;
      break;
     case ObjCCategory:
      ++DeclNodesGlobals.nObjCCategorys;
      break;
     case ObjCCategoryImpl:
      ++DeclNodesGlobals.nObjCCategoryImpls;
      break;
     case ObjCImplementation:
      ++DeclNodesGlobals.nObjCImplementations;
      break;
     case ObjCInterface:
      ++DeclNodesGlobals.nObjCInterfaces;
      break;
     case ObjCProtocol:
      ++DeclNodesGlobals.nObjCProtocols;
      break;
     case ObjCMethod:
      ++DeclNodesGlobals.nObjCMethods;
      break;
     case ObjCProperty:
      ++DeclNodesGlobals.nObjCPropertys;
      break;
     case BuiltinTemplate:
      ++DeclNodesGlobals.nBuiltinTemplates;
      break;
     case ClassTemplate:
      ++DeclNodesGlobals.nClassTemplates;
      break;
     case FunctionTemplate:
      ++DeclNodesGlobals.nFunctionTemplates;
      break;
     case TypeAliasTemplate:
      ++DeclNodesGlobals.nTypeAliasTemplates;
      break;
     case VarTemplate:
      ++DeclNodesGlobals.nVarTemplates;
      break;
     case TemplateTemplateParm:
      ++DeclNodesGlobals.nTemplateTemplateParms;
      break;
     case Enum:
      ++DeclNodesGlobals.nEnums;
      break;
     case Record:
      ++DeclNodesGlobals.nRecords;
      break;
     case CXXRecord:
      ++DeclNodesGlobals.nCXXRecords;
      break;
     case ClassTemplateSpecialization:
      ++DeclNodesGlobals.nClassTemplateSpecializations;
      break;
     case ClassTemplatePartialSpecialization:
      ++DeclNodesGlobals.nClassTemplatePartialSpecializations;
      break;
     case TemplateTypeParm:
      ++DeclNodesGlobals.nTemplateTypeParms;
      break;
     case ObjCTypeParam:
      ++DeclNodesGlobals.nObjCTypeParams;
      break;
     case TypeAlias:
      ++DeclNodesGlobals.nTypeAliass;
      break;
     case Typedef:
      ++DeclNodesGlobals.nTypedefs;
      break;
     case UnresolvedUsingTypename:
      ++DeclNodesGlobals.nUnresolvedUsingTypenames;
      break;
     case Using:
      ++DeclNodesGlobals.nUsings;
      break;
     case UsingDirective:
      ++DeclNodesGlobals.nUsingDirectives;
      break;
     case UsingShadow:
      ++DeclNodesGlobals.nUsingShadows;
      break;
     case ConstructorUsingShadow:
      ++DeclNodesGlobals.nConstructorUsingShadows;
      break;
     case Field:
      ++DeclNodesGlobals.nFields;
      break;
     case ObjCAtDefsField:
      ++DeclNodesGlobals.nObjCAtDefsFields;
      break;
     case ObjCIvar:
      ++DeclNodesGlobals.nObjCIvars;
      break;
     case Function:
      ++DeclNodesGlobals.nFunctions;
      break;
     case CXXMethod:
      ++DeclNodesGlobals.nCXXMethods;
      break;
     case CXXConstructor:
      ++DeclNodesGlobals.nCXXConstructors;
      break;
     case CXXConversion:
      ++DeclNodesGlobals.nCXXConversions;
      break;
     case CXXDestructor:
      ++DeclNodesGlobals.nCXXDestructors;
      break;
     case MSProperty:
      ++DeclNodesGlobals.nMSPropertys;
      break;
     case NonTypeTemplateParm:
      ++DeclNodesGlobals.nNonTypeTemplateParms;
      break;
     case Var:
      ++DeclNodesGlobals.nVars;
      break;
     case ImplicitParam:
      ++DeclNodesGlobals.nImplicitParams;
      break;
     case OMPCapturedExpr:
      ++DeclNodesGlobals.nOMPCapturedExprs;
      break;
     case ParmVar:
      ++DeclNodesGlobals.nParmVars;
      break;
     case VarTemplateSpecialization:
      ++DeclNodesGlobals.nVarTemplateSpecializations;
      break;
     case VarTemplatePartialSpecialization:
      ++DeclNodesGlobals.nVarTemplatePartialSpecializations;
      break;
     case EnumConstant:
      ++DeclNodesGlobals.nEnumConstants;
      break;
     case IndirectField:
      ++DeclNodesGlobals.nIndirectFields;
      break;
     case OMPDeclareReduction:
      ++DeclNodesGlobals.nOMPDeclareReductions;
      break;
     case UnresolvedUsingValue:
      ++DeclNodesGlobals.nUnresolvedUsingValues;
      break;
     case OMPThreadPrivate:
      ++DeclNodesGlobals.nOMPThreadPrivates;
      break;
     case ObjCPropertyImpl:
      ++DeclNodesGlobals.nObjCPropertyImpls;
      break;
     case PragmaComment:
      ++DeclNodesGlobals.nPragmaComments;
      break;
     case PragmaDetectMismatch:
      ++DeclNodesGlobals.nPragmaDetectMismatchs;
      break;
     case StaticAssert:
      ++DeclNodesGlobals.nStaticAsserts;
      break;
     case TranslationUnit:
      ++DeclNodesGlobals.nTranslationUnits;
      break;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::EnableStatistics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 133,
   FQN="clang::Decl::EnableStatistics", NM="_ZN5clang4Decl16EnableStatisticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl16EnableStatisticsEv")
  //</editor-fold>
  public static void EnableStatistics() {
    StatisticsEnabled = true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::PrintStats">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 137,
   FQN="clang::Decl::PrintStats", NM="_ZN5clang4Decl10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl10PrintStatsEv")
  //</editor-fold>
  public static void PrintStats() {
    llvm.errs().$out(/*KEEP_STR*/"\n*** Decl Stats:\n");
    
    int totalDecls = 0;
    totalDecls += DeclNodesGlobals.nAccessSpecs;
    totalDecls += DeclNodesGlobals.nBlocks;
    totalDecls += DeclNodesGlobals.nCaptureds;
    totalDecls += DeclNodesGlobals.nClassScopeFunctionSpecializations;
    totalDecls += DeclNodesGlobals.nEmptys;
    totalDecls += DeclNodesGlobals.nExternCContexts;
    totalDecls += DeclNodesGlobals.nFileScopeAsms;
    totalDecls += DeclNodesGlobals.nFriends;
    totalDecls += DeclNodesGlobals.nFriendTemplates;
    totalDecls += DeclNodesGlobals.nImports;
    totalDecls += DeclNodesGlobals.nLinkageSpecs;
    totalDecls += DeclNodesGlobals.nLabels;
    totalDecls += DeclNodesGlobals.nNamespaces;
    totalDecls += DeclNodesGlobals.nNamespaceAliass;
    totalDecls += DeclNodesGlobals.nObjCCompatibleAliass;
    totalDecls += DeclNodesGlobals.nObjCCategorys;
    totalDecls += DeclNodesGlobals.nObjCCategoryImpls;
    totalDecls += DeclNodesGlobals.nObjCImplementations;
    totalDecls += DeclNodesGlobals.nObjCInterfaces;
    totalDecls += DeclNodesGlobals.nObjCProtocols;
    totalDecls += DeclNodesGlobals.nObjCMethods;
    totalDecls += DeclNodesGlobals.nObjCPropertys;
    totalDecls += DeclNodesGlobals.nBuiltinTemplates;
    totalDecls += DeclNodesGlobals.nClassTemplates;
    totalDecls += DeclNodesGlobals.nFunctionTemplates;
    totalDecls += DeclNodesGlobals.nTypeAliasTemplates;
    totalDecls += DeclNodesGlobals.nVarTemplates;
    totalDecls += DeclNodesGlobals.nTemplateTemplateParms;
    totalDecls += DeclNodesGlobals.nEnums;
    totalDecls += DeclNodesGlobals.nRecords;
    totalDecls += DeclNodesGlobals.nCXXRecords;
    totalDecls += DeclNodesGlobals.nClassTemplateSpecializations;
    totalDecls += DeclNodesGlobals.nClassTemplatePartialSpecializations;
    totalDecls += DeclNodesGlobals.nTemplateTypeParms;
    totalDecls += DeclNodesGlobals.nObjCTypeParams;
    totalDecls += DeclNodesGlobals.nTypeAliass;
    totalDecls += DeclNodesGlobals.nTypedefs;
    totalDecls += DeclNodesGlobals.nUnresolvedUsingTypenames;
    totalDecls += DeclNodesGlobals.nUsings;
    totalDecls += DeclNodesGlobals.nUsingDirectives;
    totalDecls += DeclNodesGlobals.nUsingShadows;
    totalDecls += DeclNodesGlobals.nConstructorUsingShadows;
    totalDecls += DeclNodesGlobals.nFields;
    totalDecls += DeclNodesGlobals.nObjCAtDefsFields;
    totalDecls += DeclNodesGlobals.nObjCIvars;
    totalDecls += DeclNodesGlobals.nFunctions;
    totalDecls += DeclNodesGlobals.nCXXMethods;
    totalDecls += DeclNodesGlobals.nCXXConstructors;
    totalDecls += DeclNodesGlobals.nCXXConversions;
    totalDecls += DeclNodesGlobals.nCXXDestructors;
    totalDecls += DeclNodesGlobals.nMSPropertys;
    totalDecls += DeclNodesGlobals.nNonTypeTemplateParms;
    totalDecls += DeclNodesGlobals.nVars;
    totalDecls += DeclNodesGlobals.nImplicitParams;
    totalDecls += DeclNodesGlobals.nOMPCapturedExprs;
    totalDecls += DeclNodesGlobals.nParmVars;
    totalDecls += DeclNodesGlobals.nVarTemplateSpecializations;
    totalDecls += DeclNodesGlobals.nVarTemplatePartialSpecializations;
    totalDecls += DeclNodesGlobals.nEnumConstants;
    totalDecls += DeclNodesGlobals.nIndirectFields;
    totalDecls += DeclNodesGlobals.nOMPDeclareReductions;
    totalDecls += DeclNodesGlobals.nUnresolvedUsingValues;
    totalDecls += DeclNodesGlobals.nOMPThreadPrivates;
    totalDecls += DeclNodesGlobals.nObjCPropertyImpls;
    totalDecls += DeclNodesGlobals.nPragmaComments;
    totalDecls += DeclNodesGlobals.nPragmaDetectMismatchs;
    totalDecls += DeclNodesGlobals.nStaticAsserts;
    totalDecls += DeclNodesGlobals.nTranslationUnits;
    llvm.errs().$out(/*KEEP_STR*/"  ").$out_int(totalDecls).$out(/*KEEP_STR*/" decls total.\n");
    
    int totalBytes = 0;
    if (DeclNodesGlobals.nAccessSpecs > 0) {
      totalBytes += (int)(DeclNodesGlobals.nAccessSpecs * $sizeof_AccessSpecDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nAccessSpecs).$out(/*KEEP_STR*/" AccessSpec decls, ").$out_uint($sizeof_AccessSpecDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nAccessSpecs * $sizeof_AccessSpecDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nBlocks > 0) {
      totalBytes += (int)(DeclNodesGlobals.nBlocks * $sizeof_BlockDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nBlocks).$out(/*KEEP_STR*/" Block decls, ").$out_uint($sizeof_BlockDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nBlocks * $sizeof_BlockDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nCaptureds > 0) {
      totalBytes += (int)(DeclNodesGlobals.nCaptureds * $sizeof_CapturedDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nCaptureds).$out(/*KEEP_STR*/" Captured decls, ").$out_uint($sizeof_CapturedDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nCaptureds * $sizeof_CapturedDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nClassScopeFunctionSpecializations > 0) {
      totalBytes += (int)(DeclNodesGlobals.nClassScopeFunctionSpecializations * $sizeof_ClassScopeFunctionSpecializationDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nClassScopeFunctionSpecializations).$out(/*KEEP_STR*/" ClassScopeFunctionSpecialization decls, ").$out_uint($sizeof_ClassScopeFunctionSpecializationDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nClassScopeFunctionSpecializations * $sizeof_ClassScopeFunctionSpecializationDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nEmptys > 0) {
      totalBytes += (int)(DeclNodesGlobals.nEmptys * $sizeof_EmptyDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nEmptys).$out(/*KEEP_STR*/" Empty decls, ").$out_uint($sizeof_EmptyDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nEmptys * $sizeof_EmptyDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nExternCContexts > 0) {
      totalBytes += (int)(DeclNodesGlobals.nExternCContexts * $sizeof_ExternCContextDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nExternCContexts).$out(/*KEEP_STR*/" ExternCContext decls, ").$out_uint($sizeof_ExternCContextDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nExternCContexts * $sizeof_ExternCContextDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nFileScopeAsms > 0) {
      totalBytes += (int)(DeclNodesGlobals.nFileScopeAsms * $sizeof_FileScopeAsmDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nFileScopeAsms).$out(/*KEEP_STR*/" FileScopeAsm decls, ").$out_uint($sizeof_FileScopeAsmDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nFileScopeAsms * $sizeof_FileScopeAsmDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nFriends > 0) {
      totalBytes += (int)(DeclNodesGlobals.nFriends * $sizeof_FriendDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nFriends).$out(/*KEEP_STR*/" Friend decls, ").$out_uint($sizeof_FriendDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nFriends * $sizeof_FriendDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nFriendTemplates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nFriendTemplates * $sizeof_FriendTemplateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nFriendTemplates).$out(/*KEEP_STR*/" FriendTemplate decls, ").$out_uint($sizeof_FriendTemplateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nFriendTemplates * $sizeof_FriendTemplateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nImports > 0) {
      totalBytes += (int)(DeclNodesGlobals.nImports * $sizeof_ImportDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nImports).$out(/*KEEP_STR*/" Import decls, ").$out_uint($sizeof_ImportDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nImports * $sizeof_ImportDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nLinkageSpecs > 0) {
      totalBytes += (int)(DeclNodesGlobals.nLinkageSpecs * $sizeof_LinkageSpecDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nLinkageSpecs).$out(/*KEEP_STR*/" LinkageSpec decls, ").$out_uint($sizeof_LinkageSpecDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nLinkageSpecs * $sizeof_LinkageSpecDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nLabels > 0) {
      totalBytes += (int)(DeclNodesGlobals.nLabels * $sizeof_LabelDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nLabels).$out(/*KEEP_STR*/" Label decls, ").$out_uint($sizeof_LabelDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nLabels * $sizeof_LabelDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nNamespaces > 0) {
      totalBytes += (int)(DeclNodesGlobals.nNamespaces * $sizeof_NamespaceDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nNamespaces).$out(/*KEEP_STR*/" Namespace decls, ").$out_uint($sizeof_NamespaceDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nNamespaces * $sizeof_NamespaceDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nNamespaceAliass > 0) {
      totalBytes += (int)(DeclNodesGlobals.nNamespaceAliass * $sizeof_NamespaceAliasDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nNamespaceAliass).$out(/*KEEP_STR*/" NamespaceAlias decls, ").$out_uint($sizeof_NamespaceAliasDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nNamespaceAliass * $sizeof_NamespaceAliasDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCCompatibleAliass > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCCompatibleAliass * $sizeof_ObjCCompatibleAliasDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCCompatibleAliass).$out(/*KEEP_STR*/" ObjCCompatibleAlias decls, ").$out_uint($sizeof_ObjCCompatibleAliasDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCCompatibleAliass * $sizeof_ObjCCompatibleAliasDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCCategorys > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCCategorys * $sizeof_ObjCCategoryDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCCategorys).$out(/*KEEP_STR*/" ObjCCategory decls, ").$out_uint($sizeof_ObjCCategoryDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCCategorys * $sizeof_ObjCCategoryDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCCategoryImpls > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCCategoryImpls * $sizeof_ObjCCategoryImplDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCCategoryImpls).$out(/*KEEP_STR*/" ObjCCategoryImpl decls, ").$out_uint($sizeof_ObjCCategoryImplDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCCategoryImpls * $sizeof_ObjCCategoryImplDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCImplementations > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCImplementations * $sizeof_ObjCImplementationDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCImplementations).$out(/*KEEP_STR*/" ObjCImplementation decls, ").$out_uint($sizeof_ObjCImplementationDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCImplementations * $sizeof_ObjCImplementationDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCInterfaces > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCInterfaces * $sizeof_ObjCInterfaceDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCInterfaces).$out(/*KEEP_STR*/" ObjCInterface decls, ").$out_uint($sizeof_ObjCInterfaceDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCInterfaces * $sizeof_ObjCInterfaceDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCProtocols > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCProtocols * $sizeof_ObjCProtocolDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCProtocols).$out(/*KEEP_STR*/" ObjCProtocol decls, ").$out_uint($sizeof_ObjCProtocolDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCProtocols * $sizeof_ObjCProtocolDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCMethods > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCMethods * $sizeof_ObjCMethodDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCMethods).$out(/*KEEP_STR*/" ObjCMethod decls, ").$out_uint($sizeof_ObjCMethodDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCMethods * $sizeof_ObjCMethodDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCPropertys > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCPropertys * $sizeof_ObjCPropertyDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCPropertys).$out(/*KEEP_STR*/" ObjCProperty decls, ").$out_uint($sizeof_ObjCPropertyDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCPropertys * $sizeof_ObjCPropertyDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nBuiltinTemplates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nBuiltinTemplates * $sizeof_BuiltinTemplateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nBuiltinTemplates).$out(/*KEEP_STR*/" BuiltinTemplate decls, ").$out_uint($sizeof_BuiltinTemplateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nBuiltinTemplates * $sizeof_BuiltinTemplateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nClassTemplates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nClassTemplates * $sizeof_ClassTemplateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nClassTemplates).$out(/*KEEP_STR*/" ClassTemplate decls, ").$out_uint($sizeof_ClassTemplateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nClassTemplates * $sizeof_ClassTemplateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nFunctionTemplates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nFunctionTemplates * $sizeof_FunctionTemplateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nFunctionTemplates).$out(/*KEEP_STR*/" FunctionTemplate decls, ").$out_uint($sizeof_FunctionTemplateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nFunctionTemplates * $sizeof_FunctionTemplateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nTypeAliasTemplates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nTypeAliasTemplates * $sizeof_TypeAliasTemplateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nTypeAliasTemplates).$out(/*KEEP_STR*/" TypeAliasTemplate decls, ").$out_uint($sizeof_TypeAliasTemplateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nTypeAliasTemplates * $sizeof_TypeAliasTemplateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nVarTemplates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nVarTemplates * $sizeof_VarTemplateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nVarTemplates).$out(/*KEEP_STR*/" VarTemplate decls, ").$out_uint($sizeof_VarTemplateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nVarTemplates * $sizeof_VarTemplateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nTemplateTemplateParms > 0) {
      totalBytes += (int)(DeclNodesGlobals.nTemplateTemplateParms * $sizeof_TemplateTemplateParmDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nTemplateTemplateParms).$out(/*KEEP_STR*/" TemplateTemplateParm decls, ").$out_uint($sizeof_TemplateTemplateParmDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nTemplateTemplateParms * $sizeof_TemplateTemplateParmDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nEnums > 0) {
      totalBytes += (int)(DeclNodesGlobals.nEnums * $sizeof_EnumDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nEnums).$out(/*KEEP_STR*/" Enum decls, ").$out_uint($sizeof_EnumDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nEnums * $sizeof_EnumDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nRecords > 0) {
      totalBytes += (int)(DeclNodesGlobals.nRecords * $sizeof_RecordDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nRecords).$out(/*KEEP_STR*/" Record decls, ").$out_uint($sizeof_RecordDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nRecords * $sizeof_RecordDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nCXXRecords > 0) {
      totalBytes += (int)(DeclNodesGlobals.nCXXRecords * $sizeof_CXXRecordDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nCXXRecords).$out(/*KEEP_STR*/" CXXRecord decls, ").$out_uint($sizeof_CXXRecordDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nCXXRecords * $sizeof_CXXRecordDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nClassTemplateSpecializations > 0) {
      totalBytes += (int)(DeclNodesGlobals.nClassTemplateSpecializations * $sizeof_ClassTemplateSpecializationDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nClassTemplateSpecializations).$out(/*KEEP_STR*/" ClassTemplateSpecialization decls, ").$out_uint($sizeof_ClassTemplateSpecializationDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nClassTemplateSpecializations * $sizeof_ClassTemplateSpecializationDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nClassTemplatePartialSpecializations > 0) {
      totalBytes += (int)(DeclNodesGlobals.nClassTemplatePartialSpecializations * $sizeof_ClassTemplatePartialSpecializationDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nClassTemplatePartialSpecializations).$out(/*KEEP_STR*/" ClassTemplatePartialSpecialization decls, ").$out_uint($sizeof_ClassTemplatePartialSpecializationDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nClassTemplatePartialSpecializations * $sizeof_ClassTemplatePartialSpecializationDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nTemplateTypeParms > 0) {
      totalBytes += (int)(DeclNodesGlobals.nTemplateTypeParms * $sizeof_TemplateTypeParmDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nTemplateTypeParms).$out(/*KEEP_STR*/" TemplateTypeParm decls, ").$out_uint($sizeof_TemplateTypeParmDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nTemplateTypeParms * $sizeof_TemplateTypeParmDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCTypeParams > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCTypeParams * $sizeof_ObjCTypeParamDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCTypeParams).$out(/*KEEP_STR*/" ObjCTypeParam decls, ").$out_uint($sizeof_ObjCTypeParamDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCTypeParams * $sizeof_ObjCTypeParamDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nTypeAliass > 0) {
      totalBytes += (int)(DeclNodesGlobals.nTypeAliass * $sizeof_TypeAliasDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nTypeAliass).$out(/*KEEP_STR*/" TypeAlias decls, ").$out_uint($sizeof_TypeAliasDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nTypeAliass * $sizeof_TypeAliasDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nTypedefs > 0) {
      totalBytes += (int)(DeclNodesGlobals.nTypedefs * $sizeof_TypedefDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nTypedefs).$out(/*KEEP_STR*/" Typedef decls, ").$out_uint($sizeof_TypedefDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nTypedefs * $sizeof_TypedefDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nUnresolvedUsingTypenames > 0) {
      totalBytes += (int)(DeclNodesGlobals.nUnresolvedUsingTypenames * $sizeof_UnresolvedUsingTypenameDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nUnresolvedUsingTypenames).$out(/*KEEP_STR*/" UnresolvedUsingTypename decls, ").$out_uint($sizeof_UnresolvedUsingTypenameDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nUnresolvedUsingTypenames * $sizeof_UnresolvedUsingTypenameDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nUsings > 0) {
      totalBytes += (int)(DeclNodesGlobals.nUsings * $sizeof_UsingDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nUsings).$out(/*KEEP_STR*/" Using decls, ").$out_uint($sizeof_UsingDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nUsings * $sizeof_UsingDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nUsingDirectives > 0) {
      totalBytes += (int)(DeclNodesGlobals.nUsingDirectives * $sizeof_UsingDirectiveDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nUsingDirectives).$out(/*KEEP_STR*/" UsingDirective decls, ").$out_uint($sizeof_UsingDirectiveDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nUsingDirectives * $sizeof_UsingDirectiveDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nUsingShadows > 0) {
      totalBytes += (int)(DeclNodesGlobals.nUsingShadows * $sizeof_UsingShadowDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nUsingShadows).$out(/*KEEP_STR*/" UsingShadow decls, ").$out_uint($sizeof_UsingShadowDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nUsingShadows * $sizeof_UsingShadowDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nConstructorUsingShadows > 0) {
      totalBytes += (int)(DeclNodesGlobals.nConstructorUsingShadows * $sizeof_ConstructorUsingShadowDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nConstructorUsingShadows).$out(/*KEEP_STR*/" ConstructorUsingShadow decls, ").$out_uint($sizeof_ConstructorUsingShadowDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nConstructorUsingShadows * $sizeof_ConstructorUsingShadowDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nFields > 0) {
      totalBytes += (int)(DeclNodesGlobals.nFields * $sizeof_FieldDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nFields).$out(/*KEEP_STR*/" Field decls, ").$out_uint($sizeof_FieldDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nFields * $sizeof_FieldDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCAtDefsFields > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCAtDefsFields * $sizeof_ObjCAtDefsFieldDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCAtDefsFields).$out(/*KEEP_STR*/" ObjCAtDefsField decls, ").$out_uint($sizeof_ObjCAtDefsFieldDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCAtDefsFields * $sizeof_ObjCAtDefsFieldDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCIvars > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCIvars * $sizeof_ObjCIvarDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCIvars).$out(/*KEEP_STR*/" ObjCIvar decls, ").$out_uint($sizeof_ObjCIvarDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCIvars * $sizeof_ObjCIvarDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nFunctions > 0) {
      totalBytes += (int)(DeclNodesGlobals.nFunctions * $sizeof_FunctionDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nFunctions).$out(/*KEEP_STR*/" Function decls, ").$out_uint($sizeof_FunctionDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nFunctions * $sizeof_FunctionDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nCXXMethods > 0) {
      totalBytes += (int)(DeclNodesGlobals.nCXXMethods * $sizeof_CXXMethodDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nCXXMethods).$out(/*KEEP_STR*/" CXXMethod decls, ").$out_uint($sizeof_CXXMethodDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nCXXMethods * $sizeof_CXXMethodDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nCXXConstructors > 0) {
      totalBytes += (int)(DeclNodesGlobals.nCXXConstructors * $sizeof_CXXConstructorDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nCXXConstructors).$out(/*KEEP_STR*/" CXXConstructor decls, ").$out_uint($sizeof_CXXConstructorDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nCXXConstructors * $sizeof_CXXConstructorDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nCXXConversions > 0) {
      totalBytes += (int)(DeclNodesGlobals.nCXXConversions * $sizeof_CXXConversionDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nCXXConversions).$out(/*KEEP_STR*/" CXXConversion decls, ").$out_uint($sizeof_CXXConversionDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nCXXConversions * $sizeof_CXXConversionDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nCXXDestructors > 0) {
      totalBytes += (int)(DeclNodesGlobals.nCXXDestructors * $sizeof_CXXDestructorDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nCXXDestructors).$out(/*KEEP_STR*/" CXXDestructor decls, ").$out_uint($sizeof_CXXDestructorDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nCXXDestructors * $sizeof_CXXDestructorDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nMSPropertys > 0) {
      totalBytes += (int)(DeclNodesGlobals.nMSPropertys * $sizeof_MSPropertyDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nMSPropertys).$out(/*KEEP_STR*/" MSProperty decls, ").$out_uint($sizeof_MSPropertyDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nMSPropertys * $sizeof_MSPropertyDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nNonTypeTemplateParms > 0) {
      totalBytes += (int)(DeclNodesGlobals.nNonTypeTemplateParms * $sizeof_NonTypeTemplateParmDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nNonTypeTemplateParms).$out(/*KEEP_STR*/" NonTypeTemplateParm decls, ").$out_uint($sizeof_NonTypeTemplateParmDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nNonTypeTemplateParms * $sizeof_NonTypeTemplateParmDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nVars > 0) {
      totalBytes += (int)(DeclNodesGlobals.nVars * $sizeof_VarDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nVars).$out(/*KEEP_STR*/" Var decls, ").$out_uint($sizeof_VarDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nVars * $sizeof_VarDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nImplicitParams > 0) {
      totalBytes += (int)(DeclNodesGlobals.nImplicitParams * $sizeof_ImplicitParamDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nImplicitParams).$out(/*KEEP_STR*/" ImplicitParam decls, ").$out_uint($sizeof_ImplicitParamDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nImplicitParams * $sizeof_ImplicitParamDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nOMPCapturedExprs > 0) {
      totalBytes += (int)(DeclNodesGlobals.nOMPCapturedExprs * $sizeof_OMPCapturedExprDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nOMPCapturedExprs).$out(/*KEEP_STR*/" OMPCapturedExpr decls, ").$out_uint($sizeof_OMPCapturedExprDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nOMPCapturedExprs * $sizeof_OMPCapturedExprDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nParmVars > 0) {
      totalBytes += (int)(DeclNodesGlobals.nParmVars * $sizeof_ParmVarDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nParmVars).$out(/*KEEP_STR*/" ParmVar decls, ").$out_uint($sizeof_ParmVarDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nParmVars * $sizeof_ParmVarDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nVarTemplateSpecializations > 0) {
      totalBytes += (int)(DeclNodesGlobals.nVarTemplateSpecializations * $sizeof_VarTemplateSpecializationDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nVarTemplateSpecializations).$out(/*KEEP_STR*/" VarTemplateSpecialization decls, ").$out_uint($sizeof_VarTemplateSpecializationDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nVarTemplateSpecializations * $sizeof_VarTemplateSpecializationDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nVarTemplatePartialSpecializations > 0) {
      totalBytes += (int)(DeclNodesGlobals.nVarTemplatePartialSpecializations * $sizeof_VarTemplatePartialSpecializationDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nVarTemplatePartialSpecializations).$out(/*KEEP_STR*/" VarTemplatePartialSpecialization decls, ").$out_uint($sizeof_VarTemplatePartialSpecializationDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nVarTemplatePartialSpecializations * $sizeof_VarTemplatePartialSpecializationDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nEnumConstants > 0) {
      totalBytes += (int)(DeclNodesGlobals.nEnumConstants * $sizeof_EnumConstantDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nEnumConstants).$out(/*KEEP_STR*/" EnumConstant decls, ").$out_uint($sizeof_EnumConstantDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nEnumConstants * $sizeof_EnumConstantDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nIndirectFields > 0) {
      totalBytes += (int)(DeclNodesGlobals.nIndirectFields * $sizeof_IndirectFieldDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nIndirectFields).$out(/*KEEP_STR*/" IndirectField decls, ").$out_uint($sizeof_IndirectFieldDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nIndirectFields * $sizeof_IndirectFieldDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nOMPDeclareReductions > 0) {
      totalBytes += (int)(DeclNodesGlobals.nOMPDeclareReductions * $sizeof_OMPDeclareReductionDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nOMPDeclareReductions).$out(/*KEEP_STR*/" OMPDeclareReduction decls, ").$out_uint($sizeof_OMPDeclareReductionDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nOMPDeclareReductions * $sizeof_OMPDeclareReductionDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nUnresolvedUsingValues > 0) {
      totalBytes += (int)(DeclNodesGlobals.nUnresolvedUsingValues * $sizeof_UnresolvedUsingValueDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nUnresolvedUsingValues).$out(/*KEEP_STR*/" UnresolvedUsingValue decls, ").$out_uint($sizeof_UnresolvedUsingValueDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nUnresolvedUsingValues * $sizeof_UnresolvedUsingValueDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nOMPThreadPrivates > 0) {
      totalBytes += (int)(DeclNodesGlobals.nOMPThreadPrivates * $sizeof_OMPThreadPrivateDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nOMPThreadPrivates).$out(/*KEEP_STR*/" OMPThreadPrivate decls, ").$out_uint($sizeof_OMPThreadPrivateDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nOMPThreadPrivates * $sizeof_OMPThreadPrivateDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nObjCPropertyImpls > 0) {
      totalBytes += (int)(DeclNodesGlobals.nObjCPropertyImpls * $sizeof_ObjCPropertyImplDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nObjCPropertyImpls).$out(/*KEEP_STR*/" ObjCPropertyImpl decls, ").$out_uint($sizeof_ObjCPropertyImplDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nObjCPropertyImpls * $sizeof_ObjCPropertyImplDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nPragmaComments > 0) {
      totalBytes += (int)(DeclNodesGlobals.nPragmaComments * $sizeof_PragmaCommentDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nPragmaComments).$out(/*KEEP_STR*/" PragmaComment decls, ").$out_uint($sizeof_PragmaCommentDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nPragmaComments * $sizeof_PragmaCommentDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nPragmaDetectMismatchs > 0) {
      totalBytes += (int)(DeclNodesGlobals.nPragmaDetectMismatchs * $sizeof_PragmaDetectMismatchDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nPragmaDetectMismatchs).$out(/*KEEP_STR*/" PragmaDetectMismatch decls, ").$out_uint($sizeof_PragmaDetectMismatchDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nPragmaDetectMismatchs * $sizeof_PragmaDetectMismatchDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nStaticAsserts > 0) {
      totalBytes += (int)(DeclNodesGlobals.nStaticAsserts * $sizeof_StaticAssertDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nStaticAsserts).$out(/*KEEP_STR*/" StaticAssert decls, ").$out_uint($sizeof_StaticAssertDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nStaticAsserts * $sizeof_StaticAssertDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    if (DeclNodesGlobals.nTranslationUnits > 0) {
      totalBytes += (int)(DeclNodesGlobals.nTranslationUnits * $sizeof_TranslationUnitDecl());
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_int(DeclNodesGlobals.nTranslationUnits).$out(/*KEEP_STR*/" TranslationUnit decls, ").$out_uint($sizeof_TranslationUnitDecl()).$out(/*KEEP_STR*/" each (").$out_uint(DeclNodesGlobals.nTranslationUnits * $sizeof_TranslationUnitDecl()).$out(/*KEEP_STR*/" bytes)\n");
    }
    
    llvm.errs().$out(/*KEEP_STR*/"Total bytes = ").$out_int(totalBytes).$out(/*KEEP_STR*/$LF);
  }


  
  /// isTemplateParameter - Determines whether this declaration is a
  /// template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isTemplateParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1821,
   FQN="clang::Decl::isTemplateParameter", NM="_ZNK5clang4Decl19isTemplateParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl19isTemplateParameterEv")
  //</editor-fold>
  public /*inline*/ boolean isTemplateParameter() /*const*/ {
    return getKind() == Kind.TemplateTypeParm || getKind() == Kind.NonTypeTemplateParm
       || getKind() == Kind.TemplateTemplateParm;
  }

  
  /// isTemplateParameter - Determines whether this declaration is a
  /// template parameter pack.
  
  /// isTemplateParameter - Determines whether this declaration is a
  /// template parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isTemplateParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 169,
   FQN="clang::Decl::isTemplateParameterPack", NM="_ZNK5clang4Decl23isTemplateParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl23isTemplateParameterPackEv")
  //</editor-fold>
  public boolean isTemplateParameterPack() /*const*/ {
    {
      /*const*/ TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(this);
      if ((TTP != null)) {
        return TTP.isParameterPack();
      }
    }
    {
      /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(this);
      if ((NTTP != null)) {
        return NTTP.isParameterPack();
      }
    }
    {
      /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(this);
      if ((TTP != null)) {
        return TTP.isParameterPack();
      }
    }
    return false;
  }


  
  /// \brief Whether this declaration is a parameter pack.
  
  /// \brief Whether this declaration is a parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 181,
   FQN="clang::Decl::isParameterPack", NM="_ZNK5clang4Decl15isParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15isParameterPackEv")
  //</editor-fold>
  public boolean isParameterPack() /*const*/ {
    {
      /*const*/ ParmVarDecl /*P*/ Parm = dyn_cast_ParmVarDecl(this);
      if ((Parm != null)) {
        return Parm.isParameterPack();
      }
    }
    
    return isTemplateParameterPack();
  }


  
  /// \brief returns true if this declaration is a template
  
  /// \brief returns true if this declaration is a template
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 196,
   FQN="clang::Decl::isTemplateDecl", NM="_ZNK5clang4Decl14isTemplateDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl14isTemplateDeclEv")
  //</editor-fold>
  public boolean isTemplateDecl() /*const*/ {
    return isa_TemplateDecl(this);
  }


  
  /// \brief Whether this declaration is a function or function template.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isFunctionOrFunctionTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 901,
   FQN="clang::Decl::isFunctionOrFunctionTemplate", NM="_ZNK5clang4Decl28isFunctionOrFunctionTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl28isFunctionOrFunctionTemplateEv")
  //</editor-fold>
  public boolean isFunctionOrFunctionTemplate() /*const*/ {
    return (DeclKind >= $int2uint_7bits(Decl.Kind.firstFunction.getValue())
       && DeclKind <= $int2uint_7bits(Decl.Kind.lastFunction.getValue()))
       || DeclKind == $int2uint_7bits(Kind.FunctionTemplate.getValue());
  }

  
  /// \brief If this is a declaration that describes some template, this
  /// method returns that template declaration.
  
  /// \brief If this is a declaration that describes some template, this
  /// method returns that template declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getDescribedTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 200,
   FQN="clang::Decl::getDescribedTemplate", NM="_ZNK5clang4Decl20getDescribedTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl20getDescribedTemplateEv")
  //</editor-fold>
  public TemplateDecl /*P*/ getDescribedTemplate() /*const*/ {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(this);
      if ((FD != null)) {
        return FD.getDescribedFunctionTemplate();
      } else {
        /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(this);
        if ((RD != null)) {
          return RD.getDescribedClassTemplate();
        } else {
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(this);
          if ((VD != null)) {
            return VD.getDescribedVarTemplate();
          }
        }
      }
    }
    
    return null;
  }


  
  /// \brief Returns the function itself, or the templated function if this is a
  /// function template.
  
  /// \brief Returns the function itself, or the templated function if this is a
  /// function template.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAsFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 188,
   FQN="clang::Decl::getAsFunction", NM="_ZN5clang4Decl13getAsFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl13getAsFunctionEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getAsFunction()/* __attribute__((pure))*/ {
    {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(this);
      if ((FD != null)) {
        return FD;
      }
    }
    {
      /*const*/ FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(this);
      if ((FTD != null)) {
        return FTD.getTemplatedDecl();
      }
    }
    return null;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getAsFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 915,
   FQN="clang::Decl::getAsFunction", NM="_ZNK5clang4Decl13getAsFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl13getAsFunctionEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getAsFunction$Const() /*const*/ {
    return ((/*const_cast*/Decl /*P*/ )(this)).getAsFunction();
  }

  
  /// \brief Changes the namespace of this declaration to reflect that it's
  /// a function-local extern declaration.
  ///
  /// These declarations appear in the lexical context of the extern
  /// declaration, but in the semantic context of the enclosing namespace
  /// scope.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setLocalExternDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 925,
   FQN="clang::Decl::setLocalExternDecl", NM="_ZN5clang4Decl18setLocalExternDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl18setLocalExternDeclEv")
  //</editor-fold>
  public void setLocalExternDecl() {
    assert ((IdentifierNamespace_field == $int2uint_13bits(IdentifierNamespace.IDNS_Ordinary) || IdentifierNamespace_field == $int2uint_13bits(IdentifierNamespace.IDNS_OrdinaryFriend))) : "namespace is not ordinary";
    
    Decl /*P*/ Prev = getPreviousDecl$Decl();
    IdentifierNamespace_field &= $int2uint_13bits(~IdentifierNamespace.IDNS_Ordinary);
    
    IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_LocalExtern);
    if ((Prev != null) && ((Prev.getIdentifierNamespace() & IdentifierNamespace.IDNS_Ordinary) != 0)) {
      IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_Ordinary);
    }
  }

  
  /// \brief Determine whether this is a block-scope declaration with linkage.
  /// This will either be a local variable declaration declared 'extern', or a
  /// local function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::isLocalExternDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 941,
   FQN="clang::Decl::isLocalExternDecl", NM="_ZN5clang4Decl17isLocalExternDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl17isLocalExternDeclEv")
  //</editor-fold>
  public boolean isLocalExternDecl() {
    return ((IdentifierNamespace_field & $int2uint_13bits(IdentifierNamespace.IDNS_LocalExtern)) != 0);
  }

  
  /// \brief Changes the namespace of this declaration to reflect that it's
  /// the object of a friend declaration.
  ///
  /// These declarations appear in the lexical context of the friending
  /// class, but in the semantic context of the actual entity.  This property
  /// applies only to a specific decl object;  other redeclarations of the
  /// same entity may not (and probably don't) share this property.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setObjectOfFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 952,
   FQN="clang::Decl::setObjectOfFriendDecl", NM="_ZN5clang4Decl21setObjectOfFriendDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl21setObjectOfFriendDeclEb")
  //</editor-fold>
  public void setObjectOfFriendDecl() {
    setObjectOfFriendDecl(false);
  }
  public void setObjectOfFriendDecl(boolean PerformFriendInjection/*= false*/) {
    /*uint*/int OldNS = IdentifierNamespace_field;
    assert (((OldNS & (IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_TagFriend | IdentifierNamespace.IDNS_OrdinaryFriend | IdentifierNamespace.IDNS_LocalExtern)) != 0)) : "namespace includes neither ordinary nor tag";
    assert (!((OldNS & ~(IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Type | IdentifierNamespace.IDNS_TagFriend | IdentifierNamespace.IDNS_OrdinaryFriend | IdentifierNamespace.IDNS_LocalExtern)) != 0)) : "namespace includes other than ordinary or tag";
    
    Decl /*P*/ Prev = getPreviousDecl$Decl();
    IdentifierNamespace_field &= $int2uint_13bits(~(IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Type));
    if (((OldNS & (IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_TagFriend)) != 0)) {
      IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_TagFriend);
      if (PerformFriendInjection
         || ((Prev != null) && ((Prev.getIdentifierNamespace() & IdentifierNamespace.IDNS_Tag) != 0))) {
        IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Type);
      }
    }
    if (((OldNS & (IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_OrdinaryFriend | IdentifierNamespace.IDNS_LocalExtern)) != 0)) {
      IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_OrdinaryFriend);
      if (PerformFriendInjection
         || ((Prev != null) && ((Prev.getIdentifierNamespace() & IdentifierNamespace.IDNS_Ordinary) != 0))) {
        IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_Ordinary);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::FriendObjectKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 981,
   FQN="clang::Decl::FriendObjectKind", NM="_ZN5clang4Decl16FriendObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl16FriendObjectKindE")
  //</editor-fold>
  public enum FriendObjectKind implements Native.ComparableLower {
    FOK_None(0), ///< Not a friend object.
    FOK_Declared(FOK_None.getValue() + 1), ///< A friend of a previously-declared entity.
    FOK_Undeclared(FOK_Declared.getValue() + 1); ///< A friend of a previously-undeclared entity.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FriendObjectKind valueOf(int val) {
      FriendObjectKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FriendObjectKind[] VALUES;
      private static final FriendObjectKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FriendObjectKind kind : FriendObjectKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FriendObjectKind[min < 0 ? (1-min) : 0];
        VALUES = new FriendObjectKind[max >= 0 ? (1+max) : 0];
        for (FriendObjectKind kind : FriendObjectKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FriendObjectKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FriendObjectKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FriendObjectKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Determines whether this declaration is the object of a
  /// friend declaration and, if so, what kind.
  ///
  /// There is currently no direct way to find the associated FriendDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getFriendObjectKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 991,
   FQN="clang::Decl::getFriendObjectKind", NM="_ZNK5clang4Decl19getFriendObjectKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl19getFriendObjectKindEv")
  //</editor-fold>
  public FriendObjectKind getFriendObjectKind() /*const*/ {
    /*uint*/int mask = (IdentifierNamespace_field & $int2uint_13bits((IdentifierNamespace.IDNS_TagFriend | IdentifierNamespace.IDNS_OrdinaryFriend)));
    if (!(mask != 0)) {
      return FriendObjectKind.FOK_None;
    }
    return (((IdentifierNamespace_field & $int2uint_13bits((IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Ordinary))) != 0) ? FriendObjectKind.FOK_Declared : FriendObjectKind.FOK_Undeclared);
  }

  
  /// Specifies that this declaration is a C++ overloaded non-member.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setNonMemberOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1000,
   FQN="clang::Decl::setNonMemberOperator", NM="_ZN5clang4Decl20setNonMemberOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl20setNonMemberOperatorEv")
  //</editor-fold>
  public void setNonMemberOperator() {
    assert (getKind() == Kind.Function || getKind() == Kind.FunctionTemplate);
    assert (((IdentifierNamespace_field & $int2uint_13bits(IdentifierNamespace.IDNS_Ordinary)) != 0)) : "visible non-member operators should be in ordinary namespace";
    IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_NonMemberOperator);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1007,
   FQN="clang::Decl::classofKind", NM="_ZN5clang4Decl11classofKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Decl11classofKindENS0_4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 745,
   FQN="clang::Decl::castToDeclContext", NM="_ZN5clang4Decl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ Decl /*P*/ D) {
    Decl.Kind DK = D.getKind();
    switch (DK) {
     case Block:
      return ((/*static_cast*/BlockDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case Captured:
      return ((/*static_cast*/CapturedDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case ExternCContext:
      return ((/*static_cast*/ExternCContextDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case LinkageSpec:
      return ((/*static_cast*/LinkageSpecDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case Namespace:
      return ((/*static_cast*/NamespaceDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case OMPDeclareReduction:
      return ((/*static_cast*/OMPDeclareReductionDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case ObjCMethod:
      return ((/*static_cast*/ObjCMethodDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     case TranslationUnit:
      return ((/*static_cast*/TranslationUnitDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
     default:
      if (DK.getValue() >= Kind.firstFunction.getValue() && DK.getValue() <= Kind.lastFunction.getValue()) {
        return ((/*static_cast*/FunctionDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
      }
      if (DK.getValue() >= Kind.firstTag.getValue() && DK.getValue() <= Kind.lastTag.getValue()) {
        return ((/*static_cast*/TagDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
      }
      if (DK.getValue() >= Kind.firstObjCContainer.getValue() && DK.getValue() <= Kind.lastObjCContainer.getValue()) {
        return ((/*static_cast*/ObjCContainerDecl /*P*/ )(((/*const_cast*/Decl /*P*/ )(D))));
      }
      throw new llvm_unreachable("a decl that inherits DeclContext isn't handled");
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 726,
   FQN="clang::Decl::castFromDeclContext", NM="_ZN5clang4Decl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static Decl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ D) {
    Decl.Kind DK = D.getDeclKind();
    switch (DK) {
     case Block:
      return ((/*static_cast*/BlockDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case Captured:
      return ((/*static_cast*/CapturedDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case ExternCContext:
      return ((/*static_cast*/ExternCContextDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case LinkageSpec:
      return ((/*static_cast*/LinkageSpecDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case Namespace:
      return ((/*static_cast*/NamespaceDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case OMPDeclareReduction:
      return ((/*static_cast*/OMPDeclareReductionDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case ObjCMethod:
      return ((/*static_cast*/ObjCMethodDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     case TranslationUnit:
      return ((/*static_cast*/TranslationUnitDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
     default:
      if (DK.getValue() >= Kind.firstFunction.getValue() && DK.getValue() <= Kind.lastFunction.getValue()) {
        return ((/*static_cast*/FunctionDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
      }
      if (DK.getValue() >= Kind.firstTag.getValue() && DK.getValue() <= Kind.lastTag.getValue()) {
        return ((/*static_cast*/TagDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
      }
      if (DK.getValue() >= Kind.firstObjCContainer.getValue() && DK.getValue() <= Kind.lastObjCContainer.getValue()) {
        return ((/*static_cast*/ObjCContainerDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(D))));
      }
      throw new llvm_unreachable("a decl that inherits DeclContext isn't handled");
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 106,
   FQN="clang::Decl::print", NM="_ZNK5clang4Decl5printERN4llvm11raw_ostreamEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZNK5clang4Decl5printERN4llvm11raw_ostreamEjb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out) /*const*/ {
    print(Out, 0, 
       false);
  }
  public void print(final raw_ostream /*&*/ Out, /*uint*/int Indentation/*= 0*/) /*const*/ {
    print(Out, Indentation, 
       false);
  }
  public void print(final raw_ostream /*&*/ Out, /*uint*/int Indentation/*= 0*/, 
       boolean PrintInstantiation/*= false*/) /*const*/ {
    print(Out, getASTContext().getPrintingPolicy(), Indentation, PrintInstantiation);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 111,
   FQN="clang::Decl::print", NM="_ZNK5clang4Decl5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZNK5clang4Decl5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyEjb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    print(Out, Policy, 
       0, false);
  }
  public void print(final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy, 
       /*uint*/int Indentation/*= 0*/) /*const*/ {
    print(Out, Policy, 
       Indentation, false);
  }
  public void print(final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy, 
       /*uint*/int Indentation/*= 0*/, boolean PrintInstantiation/*= false*/) /*const*/ {
    DeclPrinter Printer/*J*/= new DeclPrinter(Out, Policy, Indentation, PrintInstantiation);
    Printer.Visit(((/*const_cast*/Decl /*P*/ )(this)));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::printGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 151,
   FQN="clang::Decl::printGroup", NM="_ZN5clang4Decl10printGroupEPPS0_jRN4llvm11raw_ostreamERKNS_14PrintingPolicyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang4Decl10printGroupEPPS0_jRN4llvm11raw_ostreamERKNS_14PrintingPolicyEj")
  //</editor-fold>
  public static void printGroup(type$ptr<Decl /*P*/ /*P*/> Begin, /*uint*/int NumDecls, 
            final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy) {
    printGroup(Begin, NumDecls, 
            Out, Policy, 
            0);
  }
  public static void printGroup(type$ptr<Decl /*P*/ /*P*/> Begin, /*uint*/int NumDecls, 
            final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy, 
            /*uint*/int Indentation/*= 0*/) {
    if (NumDecls == 1) {
      (Begin.$star()).print(Out, Policy, Indentation);
      return;
    }
    
    type$ptr<Decl /*P*/ /*P*/> End = $tryClone(Begin.$add(NumDecls));
    TagDecl /*P*/ TD = dyn_cast_TagDecl(Begin.$star());
    if ((TD != null)) {
      Begin.$preInc();
    }
    
    PrintingPolicy SubPolicy/*J*/= new PrintingPolicy(Policy);
    
    boolean isFirst = true;
    for (; $noteq_ptr(Begin, End); Begin.$preInc()) {
      if (isFirst) {
        if ((TD != null)) {
          SubPolicy.IncludeTagDefinition = true;
        }
        SubPolicy.SuppressSpecifiers = false;
        isFirst = false;
      } else {
        if (!isFirst) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        SubPolicy.IncludeTagDefinition = false;
        SubPolicy.SuppressSpecifiers = true;
      }
      
      (Begin.$star()).print(Out, SubPolicy, Indentation);
    }
  }


  // Debuggers don't usually respect default arguments.
  
  //===----------------------------------------------------------------------===//
  // Decl method implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2465,
   FQN="clang::Decl::dump", NM="_ZNK5clang4Decl4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs());
  }

  // Same as dump(), but forces color printing.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::dumpColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2473,
   FQN="clang::Decl::dumpColor", NM="_ZNK5clang4Decl9dumpColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl9dumpColorEv")
  //</editor-fold>
  public void dumpColor() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      P/*J*/= new ASTDumper(llvm.errs(), $AddrOf(getASTContext().getCommentCommandTraits()), 
          $AddrOf(getASTContext().getSourceManager()), /*ShowColors*/ true);
      P.dumpDecl(this);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Decl::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2467,
   FQN="clang::Decl::dump", NM="_ZNK5clang4Decl4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Decl4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      P/*J*/= new ASTDumper(OS, $AddrOf(getASTContext().getCommentCommandTraits()), 
          $AddrOf(getASTContext().getSourceManager()));
      P.dumpDecl(this);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

  
  /// \brief Looks through the Decl's underlying type to extract a FunctionType
  /// when possible. Will return null if the type underlying the Decl does not
  /// have a FunctionType.
  
  /// \brief Looks through the Decl's underlying type to extract a FunctionType
  /// when possible. Will return null if the type underlying the Decl does not
  /// have a FunctionType.
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 813,
   FQN="clang::Decl::getFunctionType", NM="_ZNK5clang4Decl15getFunctionTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl15getFunctionTypeEb")
  //</editor-fold>
  public /*const*/ FunctionType /*P*/ getFunctionType() /*const*/ {
    return getFunctionType(true);
  }
  public /*const*/ FunctionType /*P*/ getFunctionType(boolean BlocksToo/*= true*/) /*const*/ {
    QualType Ty/*J*/= new QualType();
    {
      /*const*/ ValueDecl /*P*/ D = dyn_cast_ValueDecl(this);
      if ((D != null)) {
        Ty.$assignMove(D.getType());
      } else {
        /*const*/ TypedefNameDecl /*P*/ D$1 = dyn_cast_TypedefNameDecl(this);
        if ((D$1 != null)) {
          Ty.$assignMove(D$1.getUnderlyingType());
        } else {
          return null;
        }
      }
    }
    if (Ty.$arrow().isFunctionPointerType()) {
      Ty.$assignMove(Ty.$arrow().getAs(PointerType.class).getPointeeType());
    } else if (BlocksToo && Ty.$arrow().isBlockPointerType()) {
      Ty.$assignMove(Ty.$arrow().getAs(BlockPointerType.class).getPointeeType());
    }
    
    return Ty.$arrow().getAs(FunctionType.class);
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setAttrsImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 704,
   FQN="clang::Decl::setAttrsImpl", NM="_ZN5clang4Decl12setAttrsImplERKN4llvm11SmallVectorIPNS_4AttrELj2EEERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl12setAttrsImplERKN4llvm11SmallVectorIPNS_4AttrELj2EEERNS_10ASTContextE")
  //</editor-fold>
  /*friend*/public void setAttrsImpl(final /*const*/SmallVector<Attr /*P*/>/*&*/ attrs, final ASTContext /*&*/ Ctx) {
    assert (!HasAttrs) : "Decl already contains attrs.";
    
    final SmallVector<Attr /*P*/>/*&*/ AttrBlank = Ctx.getDeclAttrs(this);
    assert (AttrBlank.empty()) : "HasAttrs was wrong?";
    
    AttrBlank.$assign(attrs);
    HasAttrs = true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Decl::setDeclContextsImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 269,
   FQN="clang::Decl::setDeclContextsImpl", NM="_ZN5clang4Decl19setDeclContextsImplEPNS_11DeclContextES2_RNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4Decl19setDeclContextsImplEPNS_11DeclContextES2_RNS_10ASTContextE")
  //</editor-fold>
  /*friend*/public/*private*/ void setDeclContextsImpl(DeclContext /*P*/ SemaDC, DeclContext /*P*/ LexicalDC, 
                     final ASTContext /*&*/ Ctx) {
    if (SemaDC == LexicalDC) {
      DeclCtx.$assign_T$C$R(DeclContext /*P*/.class, SemaDC);
    } else {
      Decl.MultipleDC /*P*/ MDC = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new Decl.MultipleDC();
      MDC.SemanticDC = SemaDC;
      MDC.LexicalDC = LexicalDC;
      DeclCtx.$assign_T1$C$R(Decl.MultipleDC /*P*/.class, MDC);
    }
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::getASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 327,
   FQN="clang::Decl::getASTMutationListener", NM="_ZNK5clang4Decl22getASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang4Decl22getASTMutationListenerEv")
  //</editor-fold>
  protected ASTMutationListener /*P*/ getASTMutationListener() /*const*/ {
    return getASTContext().getASTMutationListener();
  }

  //////////////////////////////////////////////////////////////////////////////
    
  private static boolean assertThisConsumedByCreatedDecl(Decl createdDecl, type$ptr Mem) {
    assert createdDecl.$This$InASTContext.$eq(Mem) : "expected " + Mem + " vs. " + createdDecl.$This$InASTContext;
    assert Mem.$star() == createdDecl : "createdDecl should be in Mem, but got: " + Mem.$star();
    return true;
  }
  
  private static final ThreadLocalThisSupplier<Decl> MemoryForDecl$Supplier = ThreadLocalThisSupplier.Create(Decl::assertThisConsumedByCreatedDecl, Decl.class.getName(), false);
  
  private final type$ptr<?> $This$InASTContext = MemoryForDecl$Supplier.consumeAssignedMemory(this);
  
  /*friend*/type$ptr<?> $This$Ptr() { return $This$InASTContext; }
    
  /// \brief Allocate memory for a deserialized declaration.
  ///
  /// This routine must be used to allocate memory for any declaration that is
  /// deserialized from a module file.
  ///
  /// \param Size The size of the allocated object.
  /// \param Ctx The context in which we will allocate memory.
  /// \param ID The global ID of the deserialized declaration.
  /// \param Extra The amount of extra space to allocate after the object.  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*operator new (Ctx, ID) Decl(...) */,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 55,
   FQN="clang::Decl::operator new", NM="_ZN5clang4DeclnwEjRKNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclnwEjRKNS_10ASTContextEjj")
  //</editor-fold>
  protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
      /*uint*/int ID, New$ConstructorCallback<T/*P*/> New$DeclCtr) {
    return $new(Context, 
      ID, 0, New$DeclCtr);
  }
  protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
      /*uint*/int ID, /*uint*/int Extra/*= 0*/, New$ConstructorCallback<T/*P*/> New$DeclCtr, std.pairIntPtr<Supplier> ... ExtraInitializers) {
    // Allocate an extra 8 bytes worth of storage, which ensures that the
    // resulting pointer will still be 8-byte aligned.
//    static_assert($greatereq_uint($sizeof_UInt() * 2, AlignOf/*<Decl>*/.Unnamed_enum.Alignment), $("Decl won't be misaligned"));
    type$ptr<?>/*void P*/ Start = Context.Allocate$JavaRef(2/*leading integers*/ + 1/*Decl object*/ + Extra/*trailing objects*/);
    type$ptr<?>/*void P*/ Result = Start.$add(/*8*/2/*2 integers in the head*/);
    
    type$ptr<Integer>/*uint P*/ PrefixPtr = (type$ptr<Integer>)Start;
    
    // Zero out the first 4 bytes; this is used to store the owning module ID.
    PrefixPtr.$set(0, Integer.valueOf(0));
    
    // Store the global declaration ID in the second 4 bytes.
    PrefixPtr.$set(1, Integer.valueOf(ID));
    
    return initExtraTrailingsAndCallConstructorImpl(Result, New$DeclCtr, Extra, ExtraInitializers); 
  }  
  
  /// \brief Allocate memory for a non-deserialized declaration.  
  //<editor-fold defaultstate="collapsed" desc="clang::Decl::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*operator new (Ctx, DC) Decl(...) */,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 75,
   FQN="clang::Decl::operator new", NM="_ZN5clang4DeclnwEjRKNS_10ASTContextEPNS_11DeclContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclnwEjRKNS_10ASTContextEPNS_11DeclContextEj")
  //</editor-fold>
  protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
      DeclContext /*P*/ Parent, New$ConstructorCallback<T/*P*/> New$DeclCtr) {
    return $new(Context, 
      Parent, 0, New$DeclCtr);
  }
  protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
      DeclContext /*P*/ Parent, /*uint*/int Extra/*= 0*/, New$ConstructorCallback<T/*P*/> New$DeclCtr, std.pairIntPtr<Supplier> ... ExtraInitializers) {
    assert (!(Parent != null) || $AddrOf(Parent.getParentASTContext()) == $AddrOf(Context));
    // With local visibility enabled, we track the owning module even for local
    // declarations.
    type$ptr<?>/*void P*/ Result;
    if (Context.getLangOpts().ModulesLocalVisibility) {
      type$ptr/*void P*/ Start = Context.Allocate$JavaRef(1/*Decl object*/ + Extra + 1/*Module P*/);
      Result = (type$ptr<?>)Start.$add(/*8*/1/*Module P in the head*/);
//      /*size_t*/int ExtraAlign = $ulong2uint(llvm.OffsetToAlignment($uint2ulong($sizeof_ptr(/*Module  */)), 
//          $uint2ulong(AlignOf/*<Decl>*/.Unnamed_enum.Alignment)));
//      char$ptr/*char P*/ Buffer = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, /*::*/$new_uint_ASTContext$C_uint(ExtraAlign + $sizeof_ptr(/*Module  */) + Size + Extra, Context)));
//      Buffer.$inc(ExtraAlign);
//      return /*FIXME:NEW_EXPR*//*new (Buffer)*/ new Module /*P*/ (Buffer.$add(1));
      Start.$set((Module/*P*/)null);
    } else {
      Result = Context.Allocate$JavaRef(1/*Decl object*/ + Extra);
    }
    return initExtraTrailingsAndCallConstructorImpl(Result, New$DeclCtr, Extra, ExtraInitializers);
  }  

  private static <T extends Decl> T initExtraTrailingsAndCallConstructorImpl(type$ptr<?> MemoryLocation, New$ConstructorCallback<T> New$DeclCtr, 
          /*uint*/int ExtraTrailings/*= 0*/, std.pairIntPtr<Supplier> ... ExtraInitializers) {
    // Initialize extra memory before constructor call
    // because constructors usually access it's trailing objects
    if (ExtraTrailings != 0) {
      assert ExtraInitializers != null;
      int TrailingIndex = 1;
      for (std.pairIntType<Supplier> numAndSupplier : ExtraInitializers) {
        for (int counter = 0; counter < numAndSupplier.first; ++counter) {
          assert ((type$ptr)MemoryLocation).$at(TrailingIndex) == null : "how could it be already occupied by " + NativeTrace.getIdentityStr(((type$ptr)MemoryLocation).$at(TrailingIndex));
          ((type$ptr)MemoryLocation).$set(TrailingIndex, numAndSupplier.second.get());
          ++TrailingIndex;
        }
      }          
    }
    T createdDecl = New$DeclCtr.$call(MemoryForDecl$Supplier.assignMemory(MemoryLocation));
    assert (ExtraTrailings == 0) || createdDecl instanceof TrailingObjectsImpl : 
            "Extra [" + ExtraTrailings + "] is incorrect for Decl class without TrailingObjects:" + NativeTrace.getIdentityStr(createdDecl);    
    assert MemoryForDecl$Supplier.assertConsumed(createdDecl, MemoryLocation);
    return createdDecl;
  } 
  
  public boolean isFirstDecl() /*const*/ { return isFirstDecl$Decl(); }
  public Decl /*P*/ getPreviousDecl() { return getPreviousDecl$Decl(); }
  public /*const*/ Decl /*P*/ getPreviousDecl$Const() /*const*/ { return getPreviousDecl$Decl$Const(); }
  public Decl /*P*/ getMostRecentDecl() { return getMostRecentDecl$Decl(); }
  public /*const*/ Decl /*P*/ getMostRecentDecl$Const() /*const*/ { return getMostRecentDecl$Decl$Const(); }
  
  //////////////////////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    String DeclCtxStr = "<null>";
    if (!DeclCtx.isNull()) {
      DeclContext DC = DeclCtx.dyn_cast(DeclContext.class);
      if (DC != null) {
        DeclCtxStr = NativeTrace.getIdentityStr(DC);
      } else {
        DeclCtxStr = "" + DeclCtx.get(MultipleDC.class); // NOI18N
      }
    }
    return " As$Decl{" + NativeTrace.getIdentityStr(this)
              + ", DeclKind=" + Kind.valueOf($uchar2uint(DeclKind)) // NOI18N
              + ", NextInContextAndBits=" + NextInContextAndBits // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", DeclCtx={" + DeclCtxStr // NOI18N
              + "}, InvalidDecl=" + InvalidDecl // NOI18N
              + ", HasAttrs=" + HasAttrs // NOI18N
              + ", Implicit=" + Implicit // NOI18N
              + ", Used=" + Used // NOI18N
              + ", Referenced=" + Referenced // NOI18N
              + ", Access=" + AccessSpecifier.valueOf($uchar2uint(Access)) // NOI18N
              + ", FromASTFile=" + FromASTFile // NOI18N
              + ", Hidden=" + Hidden // NOI18N
              + ", _IdentifierNamespace=" + $ushort2uint(IdentifierNamespace_field) // NOI18N
              + ", CacheValidAndLinkage=" + $uchar2uint(CacheValidAndLinkage) + "}\n" // NOI18N
              + ((this instanceof DeclContext) ? ((DeclContext)this).$DeclContext$Fields().toString() : ""); // NOI18N
  }
}
