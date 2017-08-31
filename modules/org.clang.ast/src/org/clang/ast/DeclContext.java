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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstMemberPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.ast.impl.DeclBaseStatics.*;


/// DeclContext - This is used only as base class of specific decl types that
/// can act as declaration contexts. These decls are (only the top classes
/// that directly derive from DeclContext are mentioned, not their subclasses):
///
///   TranslationUnitDecl
///   NamespaceDecl
///   FunctionDecl
///   TagDecl
///   ObjCMethodDecl
///   ObjCContainerDecl
///   LinkageSpecDecl
///   BlockDecl
///   OMPDeclareReductionDecl
///
//<editor-fold defaultstate="collapsed" desc="clang::DeclContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1135,
 FQN="clang::DeclContext", NM="_ZN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContextE")
//</editor-fold>
public interface/*class*/ DeclContext extends org.clang.basic.declcontext.DeclContextImplementation, Destructors.ClassWithDestructor { 
/////////////////  JAVA: Moved into DeclContext$Fields //////////////////////////////////
//  /// DeclKind - This indicates which class this is.
//  public/*private*/ /*JBYTE unsigned int*/ byte DeclKind /*: 8*/;
//  
//  /// \brief Whether this declaration context also has some external
//  /// storage that contains additional declarations that are lexically
//  /// part of this context.
//  public/*private*/ /*mutable *//*JBIT bool*/ boolean ExternalLexicalStorage /*: 1*/;
//  
//  /// \brief Whether this declaration context also has some external
//  /// storage that contains additional declarations that are visible
//  /// in this context.
//  public/*private*/ /*mutable *//*JBIT bool*/ boolean ExternalVisibleStorage /*: 1*/;
//  
//  /// \brief Whether this declaration context has had external visible
//  /// storage added since the last lookup. In this case, \c LookupPtr's
//  /// invariant may not hold and needs to be fixed before we perform
//  /// another lookup.
//  public/*private*/ /*mutable *//*JBIT bool*/ boolean NeedToReconcileExternalVisibleStorage /*: 1*/;
//  
//  /// \brief If \c true, this context may have local lexical declarations
//  /// that are missing from the lookup table.
//  public/*private*/ /*mutable *//*JBIT bool*/ boolean HasLazyLocalLexicalLookups /*: 1*/;
//  
//  /// \brief If \c true, the external source may have lexical declarations
//  /// that are missing from the lookup table.
//  public/*private*/ /*mutable *//*JBIT bool*/ boolean HasLazyExternalLexicalLookups /*: 1*/;
//  
//  /// \brief If \c true, lookups should only return identifier from
//  /// DeclContext scope (for example TranslationUnit). Used in
//  /// LookupQualifiedName()
//  public/*private*/ /*mutable *//*JBIT bool*/ boolean UseQualifiedLookup /*: 1*/;
//  
//  /// \brief Pointer to the data structure used to lookup declarations
//  /// within this context (or a DependentStoredDeclsMap if this is a
//  /// dependent context). We maintain the invariant that, if the map
//  /// contains an entry for a DeclarationName (and we haven't lazily
//  /// omitted anything), then it contains all relevant entries for that
//  /// name (modulo the hasExternalDecls() flag).
//  public/*private*/ /*mutable */StoredDeclsMap /*P*/ LookupPtr;
///*protected:*/
//  /// FirstDecl - The first declaration stored within this declaration
//  /// context.
//  public/*protected*/ /*mutable */Decl /*P*/ FirstDecl;
//  
//  /// LastDecl - The last declaration stored within this declaration
//  /// context. FIXME: We could probably cache this value somewhere
//  /// outside of the DeclContext, to reduce the size of DeclContext by
//  /// another pointer.
//  public/*protected*/ /*mutable */Decl /*P*/ LastDecl;
//  
  /*friend  class ExternalASTSource*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTWriter*/
  
  /// \brief Build up a chain of declarations.
  ///
  /// \returns the first/last pair of declarations.
  
  /// \brief Build up a chain of declarations.
  ///
  /// \returns the first/last pair of declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::BuildDeclChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1072,
   FQN="clang::DeclContext::BuildDeclChain", NM="_ZN5clang11DeclContext14BuildDeclChainEN4llvm8ArrayRefIPNS_4DeclEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14BuildDeclChainEN4llvm8ArrayRefIPNS_4DeclEEEb")
  //</editor-fold>
  public/*protected*/ /*interface*/ static std.pair<Decl /*P*/ , Decl /*P*/ > BuildDeclChain(ArrayRef<Decl /*P*/ > Decls, 
                boolean FieldsAlreadyLoaded) {
    // Build up a chain of declarations via the Decl::NextInContextAndBits field.
    Decl /*P*/ FirstNewDecl = null;
    Decl /*P*/ PrevDecl = null;
    for (/*uint*/int I = 0, N = Decls.size(); I != N; ++I) {
      if (FieldsAlreadyLoaded && isa_FieldDecl(Decls.$at(I))) {
        continue;
      }
      
      Decl /*P*/ D = Decls.$at(I);
      if ((PrevDecl != null)) {
        PrevDecl.NextInContextAndBits.setPointer(D);
      } else {
        FirstNewDecl = D;
      }
      
      PrevDecl = D;
    }
    
    return std.make_pair_Ptr_Ptr(FirstNewDecl, PrevDecl);
  }


//  JAVA: Moved into DeclContext$Fields
//  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::DeclContext">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1197,
//   FQN="clang::DeclContext::DeclContext", NM="_ZN5clang11DeclContextC1ENS_4Decl4KindE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContextC1ENS_4Decl4KindE")
//  //</editor-fold>
//  public/*protected*/ default/*interface*/ void $DeclContext(Decl.Kind K) {
//    // : DeclKind(K), ExternalLexicalStorage(false), ExternalVisibleStorage(false), NeedToReconcileExternalVisibleStorage(false), HasLazyLocalLexicalLookups(false), HasLazyExternalLexicalLookups(false), UseQualifiedLookup(false), LookupPtr(null), FirstDecl(null), LastDecl(null) 
//    //START JInit
//    this.DeclKind = $uint2uint_8bits(K.getValue());
//    this.ExternalLexicalStorage = false;
//    this.ExternalVisibleStorage = false;
//    this.NeedToReconcileExternalVisibleStorage = false;
//    this.HasLazyLocalLexicalLookups = false;
//    this.HasLazyExternalLexicalLookups = false;
//    this.UseQualifiedLookup = false;
//    this.LookupPtr = null;
//    this.FirstDecl = null;
//    this.LastDecl = null;
//    //END JInit
//  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::~DeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 883,
   FQN="clang::DeclContext::~DeclContext", NM="_ZN5clang11DeclContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContextD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$DeclContext() {
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getDeclKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1208,
   FQN="clang::DeclContext::getDeclKind", NM="_ZNK5clang11DeclContext11getDeclKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext11getDeclKindEv")
  //</editor-fold>
  public default/*interface*/ Decl.Kind getDeclKind() /*const*/ {
    return /*static_cast*/Decl.Kind.valueOf($8bits_uint2uint($DeclContext$Fields().DeclKind));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getDeclKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 123,
   FQN="clang::DeclContext::getDeclKindName", NM="_ZNK5clang11DeclContext15getDeclKindNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext15getDeclKindNameEv")
  //</editor-fold>
  public default/*interface*/ /*const*/char$ptr/*char P*/ getDeclKindName() /*const*/ {
    switch (Decl.Kind.valueOf($8bits_uint2uint($DeclContext$Fields().DeclKind))) {
     default:
      throw new llvm_unreachable("Declaration context not in DeclNodes.inc!");
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


  
  /// getParent - Returns the containing DeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1214,
   FQN="clang::DeclContext::getParent", NM="_ZN5clang11DeclContext9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext9getParentEv")
  //</editor-fold>
  public default/*interface*/ DeclContext /*P*/ getParent() {
    return cast_Decl(this).getDeclContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1217,
   FQN="clang::DeclContext::getParent", NM="_ZNK5clang11DeclContext9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext9getParentEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ DeclContext /*P*/ getParent$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getParent();
  }

  
  /// getLexicalParent - Returns the containing lexical DeclContext. May be
  /// different from getParent, e.g.:
  ///
  ///   namespace A {
  ///      struct S;
  ///   }
  ///   struct A::S {}; // getParent() == namespace 'A'
  ///                   // getLexicalParent() == translation unit
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getLexicalParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1230,
   FQN="clang::DeclContext::getLexicalParent", NM="_ZN5clang11DeclContext16getLexicalParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext16getLexicalParentEv")
  //</editor-fold>
  public default/*interface*/ DeclContext /*P*/ getLexicalParent() {
    return cast_Decl(this).getLexicalDeclContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getLexicalParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1233,
   FQN="clang::DeclContext::getLexicalParent", NM="_ZNK5clang11DeclContext16getLexicalParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext16getLexicalParentEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ DeclContext /*P*/ getLexicalParent$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getLexicalParent();
  }

  
  /// \brief Find the parent context of this context that will be
  /// used for unqualified name lookup.
  ///
  /// Generally, the parent lookup context is the semantic context. However, for
  /// a friend function the parent lookup context is the lexical context, which
  /// is the class in which the friend is declared.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getLookupParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 891,
   FQN="clang::DeclContext::getLookupParent", NM="_ZN5clang11DeclContext15getLookupParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext15getLookupParentEv")
  //</editor-fold>
  public default/*interface*/ DeclContext /*P*/ getLookupParent() {
    // FIXME: Find a better way to identify friends
    if (isa_FunctionDecl(this)) {
      if (this.getParent().getRedeclContext().isFileContext()
         && this.getLexicalParent().getRedeclContext().isRecord()) {
        return this.getLexicalParent();
      }
    }
    
    return this.getParent();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getLookupParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1239,
   FQN="clang::DeclContext::getLookupParent", NM="_ZNK5clang11DeclContext15getLookupParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext15getLookupParentEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ DeclContext /*P*/ getLookupParent$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getLookupParent();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getParentASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1243,
   FQN="clang::DeclContext::getParentASTContext", NM="_ZNK5clang11DeclContext19getParentASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext19getParentASTContextEv")
  //</editor-fold>
  public default/*interface*/ ASTContext /*&*/ getParentASTContext() /*const*/ {
    return cast_Decl(this).getASTContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isClosure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1247,
   FQN="clang::DeclContext::isClosure", NM="_ZNK5clang11DeclContext9isClosureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext9isClosureEv")
  //</editor-fold>
  public default/*interface*/ boolean isClosure() /*const*/ {
    return $8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.Block.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1251,
   FQN="clang::DeclContext::isObjCContainer", NM="_ZNK5clang11DeclContext15isObjCContainerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext15isObjCContainerEv")
  //</editor-fold>
  public default/*interface*/ boolean isObjCContainer() /*const*/ {
    switch (Decl.Kind.valueOf($8bits_uint2uint($DeclContext$Fields().DeclKind))) {
     case ObjCCategory:
     case ObjCCategoryImpl:
     case ObjCImplementation:
     case ObjCInterface:
     case ObjCProtocol:
      return true;
    }
    return false;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isFunctionOrMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1263,
   FQN="clang::DeclContext::isFunctionOrMethod", NM="_ZNK5clang11DeclContext18isFunctionOrMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext18isFunctionOrMethodEv")
  //</editor-fold>
  public default/*interface*/ boolean isFunctionOrMethod() /*const*/ {
    switch (Decl.Kind.valueOf($8bits_uint2uint($DeclContext$Fields().DeclKind))) {
     case Block:
     case Captured:
     case ObjCMethod:
      return true;
     default:
      return $8bits_uint2uint($DeclContext$Fields().DeclKind) >= Decl.Kind.firstFunction.getValue() && $8bits_uint2uint($DeclContext$Fields().DeclKind) <= Decl.Kind.lastFunction.getValue();
    }
  }

  
  /// \brief Test whether the context supports looking up names.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isLookupContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1275,
   FQN="clang::DeclContext::isLookupContext", NM="_ZNK5clang11DeclContext15isLookupContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext15isLookupContextEv")
  //</editor-fold>
  public default/*interface*/ boolean isLookupContext() /*const*/ {
    return !this.isFunctionOrMethod() && $8bits_uint2uint($DeclContext$Fields().DeclKind) != Decl.Kind.LinkageSpec.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isFileContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1279,
   FQN="clang::DeclContext::isFileContext", NM="_ZNK5clang11DeclContext13isFileContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext13isFileContextEv")
  //</editor-fold>
  public default/*interface*/ boolean isFileContext() /*const*/ {
    return $8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.TranslationUnit.getValue() || $8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.Namespace.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1283,
   FQN="clang::DeclContext::isTranslationUnit", NM="_ZNK5clang11DeclContext17isTranslationUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext17isTranslationUnitEv")
  //</editor-fold>
  public default/*interface*/ boolean isTranslationUnit() /*const*/ {
    return $8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.TranslationUnit.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1287,
   FQN="clang::DeclContext::isRecord", NM="_ZNK5clang11DeclContext8isRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext8isRecordEv")
  //</editor-fold>
  public default/*interface*/ boolean isRecord() /*const*/ {
    return $8bits_uint2uint($DeclContext$Fields().DeclKind) >= Decl.Kind.firstRecord.getValue() && $8bits_uint2uint($DeclContext$Fields().DeclKind) <= Decl.Kind.lastRecord.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1291,
   FQN="clang::DeclContext::isNamespace", NM="_ZNK5clang11DeclContext11isNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext11isNamespaceEv")
  //</editor-fold>
  public default/*interface*/ boolean isNamespace() /*const*/ {
    return $8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.Namespace.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isStdNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 906,
   FQN="clang::DeclContext::isStdNamespace", NM="_ZNK5clang11DeclContext14isStdNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext14isStdNamespaceEv")
  //</editor-fold>
  public default/*interface*/ boolean isStdNamespace() /*const*/ {
    if (!this.isNamespace()) {
      return false;
    }
    
    /*const*/ NamespaceDecl /*P*/ ND = cast_NamespaceDecl(this);
    if (ND.isInline()) {
      return ND.getParent$Const().isStdNamespace();
    }
    if (!this.getParent$Const().getRedeclContext$Const().isTranslationUnit()) {
      return false;
    }
    
    /*const*/ IdentifierInfo /*P*/ II = ND.getIdentifier();
    return (II != null) && II.isStr(/*KEEP_STR*/"std");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isInlineNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 901,
   FQN="clang::DeclContext::isInlineNamespace", NM="_ZNK5clang11DeclContext17isInlineNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext17isInlineNamespaceEv")
  //</editor-fold>
  public default/*interface*/ boolean isInlineNamespace() /*const*/ {
    return this.isNamespace()
       && cast_NamespaceDecl(this).isInline();
  }


  
  /// \brief Determines whether this context is dependent on a
  /// template parameter.
  
  /// \brief Determines whether this context is dependent on a
  /// template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isDependentContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 922,
   FQN="clang::DeclContext::isDependentContext", NM="_ZNK5clang11DeclContext18isDependentContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext18isDependentContextEv")
  //</editor-fold>
  public default/*interface*/ boolean isDependentContext() /*const*/ {
    if (this.isFileContext()) {
      return false;
    }
    if (isa_ClassTemplatePartialSpecializationDecl(this)) {
      return true;
    }
    {
      
      /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(this);
      if ((Record != null)) {
        if ((Record.getDescribedClassTemplate() != null)) {
          return true;
        }
        if (Record.isDependentLambda()) {
          return true;
        }
      }
    }
    {
      
      /*const*/ FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(this);
      if ((Function != null)) {
        if ((Function.getDescribedFunctionTemplate() != null)) {
          return true;
        }
        
        // Friend function declarations are dependent if their *lexical*
        // context is dependent.
        if ((cast_Decl(this).getFriendObjectKind().getValue() != 0)) {
          return this.getLexicalParent$Const().isDependentContext();
        }
      }
    }
    
    // FIXME: A variable template is a dependent context, but is not a
    // DeclContext. A context within it (such as a lambda-expression)
    // should be considered dependent.
    return (this.getParent$Const() != null) && this.getParent$Const().isDependentContext();
  }


  
  /// isTransparentContext - Determines whether this context is a
  /// "transparent" context, meaning that the members declared in this
  /// context are semantically declared in the nearest enclosing
  /// non-transparent (opaque) context but are lexically declared in
  /// this context. For example, consider the enumerators of an
  /// enumeration type:
  /// @code
  /// enum E {
  ///   Val1
  /// };
  /// @endcode
  /// Here, E is a transparent context, so its enumerator (Val1) will
  /// appear (semantically) that it is in the same context of E.
  /// Examples of transparent contexts include: enumerations (except for
  /// C++0x scoped enums), and C++ linkage specifications.
  
  /// isTransparentContext - Determines whether this context is a
  /// "transparent" context, meaning that the members declared in this
  /// context are semantically declared in the nearest enclosing
  /// non-transparent (opaque) context but are lexically declared in
  /// this context. For example, consider the enumerators of an
  /// enumeration type:
  /// @code
  /// enum E {
  ///   Val1
  /// };
  /// @endcode
  /// Here, E is a transparent context, so its enumerator (Val1) will
  /// appear (semantically) that it is in the same context of E.
  /// Examples of transparent contexts include: enumerations (except for
  /// C++0x scoped enums), and C++ linkage specifications.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isTransparentContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 954,
   FQN="clang::DeclContext::isTransparentContext", NM="_ZNK5clang11DeclContext20isTransparentContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext20isTransparentContextEv")
  //</editor-fold>
  public default/*interface*/ boolean isTransparentContext() /*const*/ {
    if ($8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.Enum.getValue()) {
      return !cast_EnumDecl(this).isScoped();
    } else if ($8bits_uint2uint($DeclContext$Fields().DeclKind) == Decl.Kind.LinkageSpec.getValue()) {
      return true;
    }
    
    return false;  
  }


  
  /// \brief Determines whether this context or some of its ancestors is a
  /// linkage specification context that specifies C linkage.
  
  /// \brief Determines whether this context or some of its ancestors is a
  /// linkage specification context that specifies C linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isExternCContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 973,
   FQN="clang::DeclContext::isExternCContext", NM="_ZNK5clang11DeclContext16isExternCContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext16isExternCContextEv")
  //</editor-fold>
  public default/*interface*/ boolean isExternCContext() /*const*/ {
    return isLinkageSpecContext(this, LinkageSpecDecl.LanguageIDs.lang_c);
  }


  
  /// \brief Determines whether this context or some of its ancestors is a
  /// linkage specification context that specifies C++ linkage.
  
  /// \brief Determines whether this context or some of its ancestors is a
  /// linkage specification context that specifies C++ linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isExternCXXContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 977,
   FQN="clang::DeclContext::isExternCXXContext", NM="_ZNK5clang11DeclContext18isExternCXXContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext18isExternCXXContextEv")
  //</editor-fold>
  public default/*interface*/ boolean isExternCXXContext() /*const*/ {
    return isLinkageSpecContext(this, LinkageSpecDecl.LanguageIDs.lang_cxx);
  }


  
  /// \brief Determine whether this declaration context is equivalent
  /// to the declaration context DC.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::Equals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1330,
   FQN="clang::DeclContext::Equals", NM="_ZNK5clang11DeclContext6EqualsEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext6EqualsEPKS0_")
  //</editor-fold>
  public default/*interface*/ boolean Equals(/*const*/ DeclContext /*P*/ DC) /*const*/ {
    return (DC != null) && this.getPrimaryContext$Const() == DC.getPrimaryContext$Const();
  }

  
  /// \brief Determine whether this declaration context encloses the
  /// declaration context DC.
  
  /// \brief Determine whether this declaration context encloses the
  /// declaration context DC.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::Encloses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 981,
   FQN="clang::DeclContext::Encloses", NM="_ZNK5clang11DeclContext8EnclosesEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext8EnclosesEPKS0_")
  //</editor-fold>
  public default/*interface*/ boolean Encloses(/*const*/ DeclContext /*P*/ DC) /*const*/ {
    if (this.getPrimaryContext$Const() != this) {
      return this.getPrimaryContext$Const().Encloses(DC);
    }
    
    for (; (DC != null); DC = DC.getParent$Const())  {
      if (DC.getPrimaryContext$Const() == this) {
        return true;
      }
    }
    return false;
  }


  
  /// \brief Find the nearest non-closure ancestor of this context,
  /// i.e. the innermost semantic parent of this context which is not
  /// a closure.  A context may be its own non-closure ancestor.
  
  /// \brief Find the nearest non-closure ancestor of this context,
  /// i.e. the innermost semantic parent of this context which is not
  /// a closure.  A context may be its own non-closure ancestor.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getNonClosureAncestor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 857,
   FQN="clang::DeclContext::getNonClosureAncestor", NM="_ZN5clang11DeclContext21getNonClosureAncestorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext21getNonClosureAncestorEv")
  //</editor-fold>
  public default/*interface*/ Decl /*P*/ getNonClosureAncestor() {
    return /*::*/getNonClosureContext$T(this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getNonClosureAncestor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1342,
   FQN="clang::DeclContext::getNonClosureAncestor", NM="_ZNK5clang11DeclContext21getNonClosureAncestorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext21getNonClosureAncestorEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ Decl /*P*/ getNonClosureAncestor$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getNonClosureAncestor();
  }

  
  /// getPrimaryContext - There may be many different
  /// declarations of the same entity (including forward declarations
  /// of classes, multiple definitions of namespaces, etc.), each with
  /// a different set of declarations. This routine returns the
  /// "primary" DeclContext structure, which will contain the
  /// information needed to perform name lookup into this context.
  
  /// getPrimaryContext - There may be many different
  /// declarations of the same entity (including forward declarations
  /// of classes, multiple definitions of namespaces, etc.), each with
  /// a different set of declarations. This routine returns the
  /// "primary" DeclContext structure, which will contain the
  /// information needed to perform name lookup into this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getPrimaryContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 991,
   FQN="clang::DeclContext::getPrimaryContext", NM="_ZN5clang11DeclContext17getPrimaryContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext17getPrimaryContextEv")
  //</editor-fold>
  public default/*interface*/ DeclContext /*P*/ getPrimaryContext() {    
    switch (Decl.Kind.valueOf($8bits_uint2uint($DeclContext$Fields().DeclKind))) {
     case TranslationUnit:
     case ExternCContext:
     case LinkageSpec:
     case Block:
     case Captured:
     case OMPDeclareReduction:
      // There is only one DeclContext for these entities.
      return this;
     case Namespace:
      // The original namespace is our primary context.
      return ((/*static_cast*/NamespaceDecl /*P*/ )(this)).getOriginalNamespace();
     case ObjCMethod:
      return this;
     case ObjCInterface:
      {
        ObjCInterfaceDecl /*P*/ Def = cast_ObjCInterfaceDecl(this).getDefinition();
        if ((Def != null)) {
          return Def;
        }
      }
      
      return this;
     case ObjCProtocol:
      {
        ObjCProtocolDecl /*P*/ Def = cast_ObjCProtocolDecl(this).getDefinition();
        if ((Def != null)) {
          return Def;
        }
      }
      
      return this;
     case ObjCCategory:
      return this;
     case ObjCImplementation:
     case ObjCCategoryImpl:
      return this;
     default:
      if ($8bits_uint2uint($DeclContext$Fields().DeclKind) >= Decl.Kind.firstTag.getValue() && $8bits_uint2uint($DeclContext$Fields().DeclKind) <= Decl.Kind.lastTag.getValue()) {
        // If this is a tag type that has a definition or is currently
        // being defined, that definition is our primary context.
        TagDecl /*P*/ Tag = cast_TagDecl(this);
        {
          
          TagDecl /*P*/ Def = Tag.getDefinition();
          if ((Def != null)) {
            return Def;
          }
        }
        {
          
          /*const*/ TagType /*P*/ TagTy = dyn_cast_TagType(Tag.getTypeForDecl());
          if ((TagTy != null)) {
            // Note, TagType::getDecl returns the (partial) definition one exists.
            TagDecl /*P*/ PossiblePartialDef = TagTy.getDecl();
            if (PossiblePartialDef.isBeingDefined()) {
              return PossiblePartialDef;
            }
          } else {
            assert (isa_InjectedClassNameType(Tag.getTypeForDecl()));
          }
        }
        
        return Tag;
      }
      assert ($8bits_uint2uint($DeclContext$Fields().DeclKind) >= Decl.Kind.firstFunction.getValue() && $8bits_uint2uint($DeclContext$Fields().DeclKind) <= Decl.Kind.lastFunction.getValue()) : "Unknown DeclContext kind:" + Decl.Kind.valueOf($uchar2uint($DeclContext$Fields().DeclKind));
      return this;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getPrimaryContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1353,
   FQN="clang::DeclContext::getPrimaryContext", NM="_ZNK5clang11DeclContext17getPrimaryContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext17getPrimaryContextEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ DeclContext /*P*/ getPrimaryContext$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getPrimaryContext();
  }

  
  /// getRedeclContext - Retrieve the context in which an entity conflicts with
  /// other entities of the same name, or where it is a redeclaration if the
  /// two entities are compatible. This skips through transparent contexts.
  
  /// getRedeclContext - Retrieve the context in which an entity conflicts with
  /// other entities of the same name, or where it is a redeclaration if the
  /// two entities are compatible. This skips through transparent contexts.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getRedeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1534,
   FQN="clang::DeclContext::getRedeclContext", NM="_ZN5clang11DeclContext16getRedeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext16getRedeclContextEv")
  //</editor-fold>
  public default/*interface*/ DeclContext /*P*/ getRedeclContext() {
    DeclContext /*P*/ Ctx = this;
    // Skip through transparent contexts.
    while (Ctx.isTransparentContext()) {
      Ctx = Ctx.getParent();
    }
    return Ctx;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getRedeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1361,
   FQN="clang::DeclContext::getRedeclContext", NM="_ZNK5clang11DeclContext16getRedeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext16getRedeclContextEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ DeclContext /*P*/ getRedeclContext$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getRedeclContext();
  }

  
  /// \brief Retrieve the nearest enclosing namespace context.
  
  /// \brief Retrieve the nearest enclosing namespace context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getEnclosingNamespaceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1542,
   FQN="clang::DeclContext::getEnclosingNamespaceContext", NM="_ZN5clang11DeclContext28getEnclosingNamespaceContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext28getEnclosingNamespaceContextEv")
  //</editor-fold>
  public default/*interface*/ DeclContext /*P*/ getEnclosingNamespaceContext() {
    DeclContext /*P*/ Ctx = this;
    // Skip through non-namespace, non-translation-unit contexts.
    while (!Ctx.isFileContext()) {
      Ctx = Ctx.getParent();
    }
    return Ctx.getPrimaryContext();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getEnclosingNamespaceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1367,
   FQN="clang::DeclContext::getEnclosingNamespaceContext", NM="_ZNK5clang11DeclContext28getEnclosingNamespaceContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext28getEnclosingNamespaceContextEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ DeclContext /*P*/ getEnclosingNamespaceContext$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getEnclosingNamespaceContext();
  }

  
  /// \brief Retrieve the outermost lexically enclosing record context.
  
  /// \brief Retrieve the outermost lexically enclosing record context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getOuterLexicalRecordContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1550,
   FQN="clang::DeclContext::getOuterLexicalRecordContext", NM="_ZN5clang11DeclContext28getOuterLexicalRecordContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext28getOuterLexicalRecordContextEv")
  //</editor-fold>
  public default/*interface*/ RecordDecl /*P*/ getOuterLexicalRecordContext() {
    // Loop until we find a non-record context.
    RecordDecl /*P*/ OutermostRD = null;
    DeclContext /*P*/ DC = this;
    while (DC.isRecord()) {
      OutermostRD = cast_RecordDecl(DC);
      DC = DC.getLexicalParent();
    }
    return OutermostRD;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getOuterLexicalRecordContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1373,
   FQN="clang::DeclContext::getOuterLexicalRecordContext", NM="_ZNK5clang11DeclContext28getOuterLexicalRecordContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext28getOuterLexicalRecordContextEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ RecordDecl /*P*/ getOuterLexicalRecordContext$Const() /*const*/ {
    return ((/*const_cast*/DeclContext /*P*/ )(this)).getOuterLexicalRecordContext();
  }

  
  /// \brief Test if this context is part of the enclosing namespace set of
  /// the context NS, as defined in C++0x [namespace.def]p9. If either context
  /// isn't a namespace, this is equivalent to Equals().
  ///
  /// The enclosing namespace set of a namespace is the namespace and, if it is
  /// inline, its enclosing namespace, recursively.
  
  /// \brief Test if this context is part of the enclosing namespace set of
  /// the context NS, as defined in C++0x [namespace.def]p9. If either context
  /// isn't a namespace, this is equivalent to Equals().
  ///
  /// The enclosing namespace set of a namespace is the namespace and, if it is
  /// inline, its enclosing namespace, recursively.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::InEnclosingNamespaceSetOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1561,
   FQN="clang::DeclContext::InEnclosingNamespaceSetOf", NM="_ZNK5clang11DeclContext25InEnclosingNamespaceSetOfEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext25InEnclosingNamespaceSetOfEPKS0_")
  //</editor-fold>
  public default/*interface*/ boolean InEnclosingNamespaceSetOf(/*const*/ DeclContext /*P*/ O) /*const*/ {
    // For non-file contexts, this is equivalent to Equals.
    if (!this.isFileContext()) {
      return O.Equals(this);
    }

    do {
      if (O.Equals(this)) {
        return true;
      }

      /*const*/ NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(O);
      if (!(NS != null) || !NS.isInline()) {
        break;
      }
      O = NS.getParent$Const();
    } while ((O != null));
  
    return false;
  }


  
  /// \brief Collects all of the declaration contexts that are semantically
  /// connected to this declaration context.
  ///
  /// For declaration contexts that have multiple semantically connected but
  /// syntactically distinct contexts, such as C++ namespaces, this routine 
  /// retrieves the complete set of such declaration contexts in source order.
  /// For example, given:
  ///
  /// \code
  /// namespace N {
  ///   int x;
  /// }
  /// namespace N {
  ///   int y;
  /// }
  /// \endcode
  ///
  /// The \c Contexts parameter will contain both definitions of N.
  ///
  /// \param Contexts Will be cleared and set to the set of declaration
  /// contexts that are semanticaly connected to this declaration context,
  /// in source order, including this context (which may be the only result,
  /// for non-namespace contexts).
  
  /// \brief Collects all of the declaration contexts that are semantically
  /// connected to this declaration context.
  ///
  /// For declaration contexts that have multiple semantically connected but
  /// syntactically distinct contexts, such as C++ namespaces, this routine 
  /// retrieves the complete set of such declaration contexts in source order.
  /// For example, given:
  ///
  /// \code
  /// namespace N {
  ///   int x;
  /// }
  /// namespace N {
  ///   int y;
  /// }
  /// \endcode
  ///
  /// The \c Contexts parameter will contain both definitions of N.
  ///
  /// \param Contexts Will be cleared and set to the set of declaration
  /// contexts that are semanticaly connected to this declaration context,
  /// in source order, including this context (which may be the only result,
  /// for non-namespace contexts).
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::collectAllContexts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1055,
   FQN="clang::DeclContext::collectAllContexts", NM="_ZN5clang11DeclContext18collectAllContextsERN4llvm15SmallVectorImplIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext18collectAllContextsERN4llvm15SmallVectorImplIPS0_EE")
  //</editor-fold>
  public default/*interface*/ void collectAllContexts(final SmallVectorImpl<DeclContext /*P*/ > /*&*/ Contexts) {
    Contexts.clear();
    if ($8bits_uint2uint($DeclContext$Fields().DeclKind) != Decl.Kind.Namespace.getValue()) {
      Contexts.push_back(this);
      return;
    }

    NamespaceDecl /*P*/ Self = ((/*static_cast*/NamespaceDecl /*P*/ )(this));
    for (NamespaceDecl /*P*/ N = Self.getMostRecentDecl$Redeclarable(); (N != null);
         N = N.getPreviousDecl$Redeclarable())  {
      Contexts.push_back(N);
    }

    std.reverse(Contexts.begin(), Contexts.end());
  }
  

  
  /// decl_iterator - Iterates through the declarations stored
  /// within this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1412,
   FQN="clang::DeclContext::decl_iterator", NM="_ZN5clang11DeclContext13decl_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorE")
  //</editor-fold>
  public static class decl_iterator implements type$iterator<decl_iterator, Decl/*P*/> {
    /// Current - The current declaration.
    private Decl /*P*/ Current;
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
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::decl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1423,
     FQN="clang::DeclContext::decl_iterator::decl_iterator", NM="_ZN5clang11DeclContext13decl_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorC1Ev")
    //</editor-fold>
    public decl_iterator() {
      // : Current(null) 
      //START JInit
      this.Current = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::decl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1424,
     FQN="clang::DeclContext::decl_iterator::decl_iterator", NM="_ZN5clang11DeclContext13decl_iteratorC1EPNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorC1EPNS_4DeclE")
    //</editor-fold>
    public /*explicit*/ decl_iterator(Decl /*P*/ C) {
      // : Current(C) 
      //START JInit
      this.Current = C;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1426,
     FQN="clang::DeclContext::decl_iterator::operator*", NM="_ZNK5clang11DeclContext13decl_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext13decl_iteratordeEv")
    //</editor-fold>
    public Decl /*P*/ /*const*/ /*&*/ $star() /*const*/ {
      return Current;
    }

    // This doesn't meet the iterator requirements, but it's convenient
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1428,
     FQN="clang::DeclContext::decl_iterator::operator->", NM="_ZNK5clang11DeclContext13decl_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext13decl_iteratorptEv")
    //</editor-fold>
    public Decl /*P*/ $arrow() /*const*/ {
      return Current;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1430,
     FQN="clang::DeclContext::decl_iterator::operator++", NM="_ZN5clang11DeclContext13decl_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorppEv")
    //</editor-fold>
    public decl_iterator /*&*/ $preInc() {
      Current = Current.getNextDeclInContext();
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1435,
     FQN="clang::DeclContext::decl_iterator::operator++", NM="_ZN5clang11DeclContext13decl_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorppEi")
    //</editor-fold>
    public decl_iterator $postInc(int $Prm0) {
      decl_iterator tmp/*J*/= new decl_iterator(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1441,
     FQN="clang::operator==", NM="_ZN5clangeqENS_11DeclContext13decl_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangeqENS_11DeclContext13decl_iteratorES1_")
    //</editor-fold>
    public static boolean $eq_decl_iterator(DeclContext.decl_iterator x, DeclContext.decl_iterator y) {
      return x.Current == y.Current;
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1444,
     FQN="clang::operator!=", NM="_ZN5clangneENS_11DeclContext13decl_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangneENS_11DeclContext13decl_iteratorES1_")
    //</editor-fold>
    public static boolean $noteq_decl_iterator(DeclContext.decl_iterator x, DeclContext.decl_iterator y) {
      return x.Current != y.Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::decl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1412,
     FQN="clang::DeclContext::decl_iterator::decl_iterator", NM="_ZN5clang11DeclContext13decl_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ decl_iterator(final /*const*/ decl_iterator /*&*/ $Prm0) {
      // : Current(.Current) 
      //START JInit
      this.Current = $Prm0.Current;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::decl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1412,
     FQN="clang::DeclContext::decl_iterator::decl_iterator", NM="_ZN5clang11DeclContext13decl_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13decl_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ decl_iterator(JD$Move _dparam, final decl_iterator /*&&*/$Prm0) {
      // : Current(static_cast<decl_iterator &&>().Current) 
      //START JInit
      this.Current = $Prm0.Current;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1412,
     FQN="clang::DeclContext::decl_iterator::operator=", NM="_ZN5clang11DeclContext13decl_iteratoraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang11DeclContext13decl_iteratoraSERKS1_")
    //</editor-fold>
    public /*inline*/ decl_iterator /*&*/ $assign(final /*const*/ decl_iterator /*&*/ $Prm0) {
      this.Current = $Prm0.Current;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decl_iterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1412,
     FQN="clang::DeclContext::decl_iterator::operator=", NM="_ZN5clang11DeclContext13decl_iteratoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCast.cpp -nm=_ZN5clang11DeclContext13decl_iteratoraSEOS1_")
    //</editor-fold>
    public /*inline*/ decl_iterator /*&*/ $assignMove(final decl_iterator /*&&*/$Prm0) {
      this.Current = $Prm0.Current;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public boolean $noteq(Object other) { return $noteq_decl_iterator(this, (decl_iterator)other); }
    
    @Override public boolean $eq(Object other) { return $eq_decl_iterator(this, (decl_iterator)other); }
    
    @Override public decl_iterator clone() { return new decl_iterator(this); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Current=" + Current; // NOI18N
    }
  };
  
  /*typedef llvm::iterator_range<decl_iterator> decl_range*/
//  public final class decl_range extends iterator_range<Decl /*P*/ /*const*/ /*&*/ >{ };
  
  /// decls_begin/decls_end - Iterate over the declarations stored in
  /// this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1453,
   FQN="clang::DeclContext::decls", NM="_ZNK5clang11DeclContext5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext5declsEv")
  //</editor-fold>
  public default/*interface*/ iterator_range<Decl /*P*/ /*const*/ /*&*/ > decls() /*const*/ {
    return new iterator_range<Decl /*P*/ /*const*/ /*&*/ >(this.decls_begin(), this.decls_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decls_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1206,
   FQN="clang::DeclContext::decls_begin", NM="_ZNK5clang11DeclContext11decls_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext11decls_beginEv")
  //</editor-fold>
  public default/*interface*/ DeclContext.decl_iterator decls_begin() /*const*/ {
    if (this.hasExternalLexicalStorage()) {
      this.LoadLexicalDeclsFromExternalStorage();
    }
    return new decl_iterator($DeclContext$Fields().FirstDecl);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decls_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1455,
   FQN="clang::DeclContext::decls_end", NM="_ZNK5clang11DeclContext9decls_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext9decls_endEv")
  //</editor-fold>
  public default/*interface*/ decl_iterator decls_end() /*const*/ {
    return new decl_iterator();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::decls_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1212,
   FQN="clang::DeclContext::decls_empty", NM="_ZNK5clang11DeclContext11decls_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext11decls_emptyEv")
  //</editor-fold>
  public default/*interface*/ boolean decls_empty() /*const*/ {
    if (this.hasExternalLexicalStorage()) {
      this.LoadLexicalDeclsFromExternalStorage();
    }

    return !($DeclContext$Fields().FirstDecl != null);
  }

  
  
  /// noload_decls_begin/end - Iterate over the declarations stored in this
  /// context that are currently loaded; don't attempt to retrieve anything
  /// from an external source.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1461,
   FQN="clang::DeclContext::noload_decls", NM="_ZNK5clang11DeclContext12noload_declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext12noload_declsEv")
  //</editor-fold>
  public default/*interface*/ iterator_range<Decl /*P*/ /*const*/ /*&*/ > noload_decls() /*const*/ {
    return new iterator_range<Decl /*P*/ /*const*/ /*&*/ >(this.noload_decls_begin(), this.noload_decls_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_decls_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1464,
   FQN="clang::DeclContext::noload_decls_begin", NM="_ZNK5clang11DeclContext18noload_decls_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext18noload_decls_beginEv")
  //</editor-fold>
  public default/*interface*/ decl_iterator noload_decls_begin() /*const*/ {
    return new decl_iterator($DeclContext$Fields().FirstDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_decls_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1465,
   FQN="clang::DeclContext::noload_decls_end", NM="_ZNK5clang11DeclContext16noload_decls_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext16noload_decls_endEv")
  //</editor-fold>
  public default/*interface*/ decl_iterator noload_decls_end() /*const*/ {
    return new decl_iterator();
  }

  
  /// specific_decl_iterator - Iterates over a subrange of
  /// declarations stored in a DeclContext, providing only those that
  /// are of type SpecificDecl (or a class derived from it). This
  /// iterator is used, for example, to provide iteration over just
  /// the fields within a RecordDecl (with SpecificDecl = FieldDecl).
  /*template <typename SpecificDecl> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*SpecificDecl class field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1472,
   FQN="clang::DeclContext::specific_decl_iterator", NM="_ZN5clang11DeclContext22specific_decl_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorE")
  //</editor-fold>
  public static class specific_decl_iterator</*typename*/ SpecificDecl extends Decl> implements type$iterator<specific_decl_iterator, SpecificDecl> {
    
    /// Current - The current, underlying declaration iterator, which
    /// will either be NULL or will point to a declaration of
    /// type SpecificDecl.
    private DeclContext.decl_iterator Current;
    
    /// SkipToNextDecl - Advances the current position up to the next
    /// declaration of type SpecificDecl that also meets the criteria
    /// required by Acceptable.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::SkipToNextDecl">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1482,
     FQN="clang::DeclContext::specific_decl_iterator::SkipToNextDecl", NM="_ZN5clang11DeclContext22specific_decl_iterator14SkipToNextDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22specific_decl_iterator14SkipToNextDeclEv")
    //</editor-fold>
    private void SkipToNextDecl() {
      while (Current.$star() != null && !isa(this.clazz, $Deref(Current.$star()))) {
        Current.$preInc();
      }
    }

  /*public:*/
    /*typedef SpecificDecl *value_type*/
//    public final class value_type extends SpecificDecl /*P*/ { };
    // TODO: Add reference and pointer typedefs (with some appropriate proxy
    // type) if we ever have a need for them.
    /*typedef void reference*/;
    /*typedef void pointer*/;
    /*typedef std::iterator_traits<DeclContext::decl_iterator>::difference_type difference_type*/;
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::specific_decl_iterator<SpecificDecl>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*SpecificDecl class*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1497,
     FQN="clang::DeclContext::specific_decl_iterator::specific_decl_iterator<SpecificDecl>", NM="_ZN5clang11DeclContext22specific_decl_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorC1Ev")
    //</editor-fold>
    public specific_decl_iterator(Class<SpecificDecl> clazz) {
      // : Current(C) 
      this.Current = new DeclContext.decl_iterator();
      this.clazz = clazz;
    }

    
    /// specific_decl_iterator - Construct a new iterator over a
    /// subset of the declarations the range [C,
    /// end-of-declarations). If A is non-NULL, it is a pointer to a
    /// member function of SpecificDecl that should return true for
    /// all of the SpecificDecl instances that will be in the subset
    /// of iterators. For example, if you want Objective-C instance
    /// methods, SpecificDecl will be ObjCMethodDecl and A will be
    /// &ObjCMethodDecl::isInstanceMethod.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::specific_decl_iterator<SpecificDecl>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*SpecificDecl class*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1507,
     FQN="clang::DeclContext::specific_decl_iterator::specific_decl_iterator<SpecificDecl>", NM="_ZN5clang11DeclContext22specific_decl_iteratorC1ENS0_13decl_iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorC1ENS0_13decl_iteratorE")
    //</editor-fold>
    public /*explicit*/ specific_decl_iterator(Class<SpecificDecl> clazz, DeclContext.decl_iterator C) {
      // : Current(C) 
      //START JInit
      this.Current = new DeclContext.decl_iterator(C);
      //END JInit
      this.clazz = clazz;
      SkipToNextDecl();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1511,
     FQN="clang::DeclContext::specific_decl_iterator::operator*", NM="_ZNK5clang11DeclContext22specific_decl_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext22specific_decl_iteratordeEv")
    //</editor-fold>
    public SpecificDecl /*P*/ $star() /*const*/ {
      return cast(this.clazz, $Deref(Current.$star()));
    }

    // This doesn't meet the iterator requirements, but it's convenient
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1513,
     FQN="clang::DeclContext::specific_decl_iterator::operator->", NM="_ZNK5clang11DeclContext22specific_decl_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext22specific_decl_iteratorptEv")
    //</editor-fold>
    public SpecificDecl /*P*/ $arrow() /*const*/ {
      return $Deref($Deref($star()));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1515,
     FQN="clang::DeclContext::specific_decl_iterator::operator++", NM="_ZN5clang11DeclContext22specific_decl_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorppEv")
    //</editor-fold>
    public specific_decl_iterator<SpecificDecl> /*&*/ $preInc() {
      Current.$preInc();
      SkipToNextDecl();
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1521,
     FQN="clang::DeclContext::specific_decl_iterator::operator++", NM="_ZN5clang11DeclContext22specific_decl_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorppEi")
    //</editor-fold>
    public specific_decl_iterator<SpecificDecl> $postInc(int $Prm0) {
      specific_decl_iterator<SpecificDecl> tmp/*J*/= /*ParenList*/new specific_decl_iterator<SpecificDecl>(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1527,
     FQN="clang::operator==", NM="_ZN5clangeqERKNS_11DeclContext22specific_decl_iteratorIT_EES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangeqERKNS_11DeclContext22specific_decl_iteratorIT_EES6_")
    //</editor-fold>
    public static <SpecificDecl extends Decl> boolean $eq_specific_decl_iterator$SpecificDecl$C(final /*const*/ specific_decl_iterator<SpecificDecl> /*&*/ x, 
                                             final /*const*/ specific_decl_iterator<SpecificDecl> /*&*/ y) {
      return x.Current.$eq(y.Current);
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1532,
     FQN="clang::operator!=", NM="_ZN5clangneERKNS_11DeclContext22specific_decl_iteratorIT_EES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangneERKNS_11DeclContext22specific_decl_iteratorIT_EES6_")
    //</editor-fold>
    public static <SpecificDecl extends Decl> boolean $noteq_specific_decl_iterator$SpecificDecl$C(final /*const*/ specific_decl_iterator<SpecificDecl> /*&*/ x, 
                                   final /*const*/ specific_decl_iterator<SpecificDecl> /*&*/ y) {
      return x.Current.$noteq(y.Current);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private final Class<SpecificDecl> clazz;
        
    public specific_decl_iterator(specific_decl_iterator  C) {
      // : Current(C) 
      this.Current = new DeclContext.decl_iterator(C.Current);
      this.clazz = C.clazz;
    }
    
    public specific_decl_iterator<SpecificDecl> $assignMove(specific_decl_iterator<SpecificDecl> $Prm0) {
      assert this.clazz == $Prm0.clazz;
      this.Current.$assign($Prm0.Current);
      return /*Deref*/this;
    }
    
    @Override public boolean $eq(Object other) { 
      return $eq_specific_decl_iterator$SpecificDecl$C(this, (specific_decl_iterator)other); 
    }
    
    @Override public boolean $noteq(Object other) { 
      return $noteq_specific_decl_iterator$SpecificDecl$C(this, (specific_decl_iterator)other); 
    }
    
    @Override
    public DeclContext.specific_decl_iterator<SpecificDecl> clone() {
      return new specific_decl_iterator(this);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::specific_decl_iterator<clang::FieldDecl>::operator=">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1473,
     FQN="clang::DeclContext::specific_decl_iterator<clang::FieldDecl>::operator=", NM="_ZN5clang11DeclContext22specific_decl_iteratorINS_9FieldDeclEEaSERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang11DeclContext22specific_decl_iteratorINS_9FieldDeclEEaSERKS3_")
    //</editor-fold>
    public /*inline*/ specific_decl_iterator<SpecificDecl> /*&*/ $assign(final /*const*/ specific_decl_iterator<SpecificDecl> /*&*/ $Prm0) {
      assert this.clazz == $Prm0.clazz;
      this.Current.$assign($Prm0.Current);
      return /*Deref*/this;
    }

    @Override
    public int $sub(specific_decl_iterator __first) {
      int dist = 0;
      if (__first.$noteq(this)) {
        specific_decl_iterator<?> iter = __first.clone();
        do {
          ++dist;
          iter.$preInc();
        } while (iter.$noteq(this));
      }
      return dist;      
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Current=" + Current; // NOI18N
    }
  };
  
  /// \brief Iterates over a filtered subrange of declarations stored
  /// in a DeclContext.
  ///
  /// This iterator visits only those declarations that are of type
  /// SpecificDecl (or a class derived from it) and that meet some
  /// additional run-time criteria. This iterator is used, for
  /// example, to provide access to the instance methods within an
  /// Objective-C interface (with SpecificDecl = ObjCMethodDecl and
  /// Acceptable = ObjCMethodDecl::isInstanceMethod).
  /*template <typename SpecificDecl, bool (SpecificDecl::*)() const Acceptable> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class and predicate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1547,
   FQN="clang::DeclContext::filtered_decl_iterator", NM="_ZN5clang11DeclContext22filtered_decl_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22filtered_decl_iteratorE")
  //</editor-fold>
  public static class filtered_decl_iterator</*typename*/ SpecificDecl extends Decl/*, SpecificDecl$BoolPredicate<SpecificDecl> const Acceptable*/> implements type$iterator<filtered_decl_iterator, SpecificDecl>  {
    
    /// Current - The current, underlying declaration iterator, which
    /// will either be NULL or will point to a declaration of
    /// type SpecificDecl.
    private DeclContext.decl_iterator Current;
    
    /// SkipToNextDecl - Advances the current position up to the next
    /// declaration of type SpecificDecl that also meets the criteria
    /// required by Acceptable.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::SkipToNextDecl">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1557,
     FQN="clang::DeclContext::filtered_decl_iterator::SkipToNextDecl", NM="_ZN5clang11DeclContext22filtered_decl_iterator14SkipToNextDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22filtered_decl_iterator14SkipToNextDeclEv")
    //</editor-fold>
    private void SkipToNextDecl() {
      while ((Current.$star() != null) && 
              (!isa(clazz, Current.$star()) || 
               (((/*FPtr*/$AddrOf(Acceptable)) != null) && !/*FPtr*/$AddrOf(Acceptable.$call(/*PtrMemI*/cast(clazz, Current.$star())))))) {
       Current.$preInc();
     }
    }

  /*public:*/
    /*typedef SpecificDecl *value_type*/
//    public final class value_type extends SpecificDecl /*P*/ { };
    // TODO: Add reference and pointer typedefs (with some appropriate proxy
    // type) if we ever have a need for them.
    /*typedef void reference*/;
    /*typedef void pointer*/;
    /*typedef std::iterator_traits<DeclContext::decl_iterator>::difference_type difference_type*/;
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::filtered_decl_iterator<SpecificDecl, Acceptable>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class and predicate*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1574,
     FQN="clang::DeclContext::filtered_decl_iterator::filtered_decl_iterator<SpecificDecl, Acceptable>", NM="_ZN5clang11DeclContext22filtered_decl_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22filtered_decl_iteratorC1Ev")
    //</editor-fold>
    public filtered_decl_iterator(Class<SpecificDecl> clazz, SpecificDecl$BoolPredicate<SpecificDecl>/*const*/ Acceptable) {
      // : Current() 
      //START JInit
      this.Current = new DeclContext.decl_iterator();
      //END JInit
      assert clazz != null;
      this.clazz = clazz;
      this.Acceptable = Acceptable;      
    }

    
    /// filtered_decl_iterator - Construct a new iterator over a
    /// subset of the declarations the range [C,
    /// end-of-declarations). If A is non-NULL, it is a pointer to a
    /// member function of SpecificDecl that should return true for
    /// all of the SpecificDecl instances that will be in the subset
    /// of iterators. For example, if you want Objective-C instance
    /// methods, SpecificDecl will be ObjCMethodDecl and A will be
    /// &ObjCMethodDecl::isInstanceMethod.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::filtered_decl_iterator<SpecificDecl, Acceptable>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class and predicate*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1584,
     FQN="clang::DeclContext::filtered_decl_iterator::filtered_decl_iterator<SpecificDecl, Acceptable>", NM="_ZN5clang11DeclContext22filtered_decl_iteratorC1ENS0_13decl_iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22filtered_decl_iteratorC1ENS0_13decl_iteratorE")
    //</editor-fold>
    public /*explicit*/ filtered_decl_iterator(Class<SpecificDecl> clazz, DeclContext.decl_iterator C, SpecificDecl$BoolPredicate<SpecificDecl>/*const*/ Acceptable) {
      // : Current(C) 
      //START JInit
      this.Current = new DeclContext.decl_iterator(C);
      //END JInit
      this.clazz = clazz;
      assert clazz != null;
      this.Acceptable = Acceptable;
      SkipToNextDecl();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1588,
     FQN="clang::DeclContext::filtered_decl_iterator::operator*", NM="_ZNK5clang11DeclContext22filtered_decl_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext22filtered_decl_iteratordeEv")
    //</editor-fold>
    public SpecificDecl /*P*/ $star() /*const*/ {
      return cast(clazz, $Deref(Current.$star()));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*class*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1589,
     FQN="clang::DeclContext::filtered_decl_iterator::operator->", NM="_ZNK5clang11DeclContext22filtered_decl_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext22filtered_decl_iteratorptEv")
    //</editor-fold>
    public SpecificDecl /*P*/ $arrow() /*const*/ {
      return cast(clazz, $Deref(Current.$star()));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1591,
     FQN="clang::DeclContext::filtered_decl_iterator::operator++", NM="_ZN5clang11DeclContext22filtered_decl_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22filtered_decl_iteratorppEv")
    //</editor-fold>
    public filtered_decl_iterator<SpecificDecl/*, Acceptable*/> /*&*/ $preInc() {
      Current.$preInc();
      SkipToNextDecl();
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::filtered_decl_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1597,
     FQN="clang::DeclContext::filtered_decl_iterator::operator++", NM="_ZN5clang11DeclContext22filtered_decl_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext22filtered_decl_iteratorppEi")
    //</editor-fold>
    public filtered_decl_iterator<SpecificDecl/*, Acceptable*/> $postInc(int $Prm0) {
      filtered_decl_iterator<SpecificDecl/*, Acceptable*/> tmp/*J*/= /*ParenList*/new filtered_decl_iterator<SpecificDecl/*, Acceptable*/>(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1603,
     FQN="clang::operator==", NM="_ZN5clangeqERKNS_11DeclContext22filtered_decl_iteratorIT_XT0_EEES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangeqERKNS_11DeclContext22filtered_decl_iteratorIT_XT0_EEES6_")
    //</editor-fold>
    public static <SpecificDecl extends Decl> boolean $eq_filtered_decl_iterator$C(final /*const*/ filtered_decl_iterator<SpecificDecl/*, Acceptable*/> /*&*/ x, 
                                final /*const*/ filtered_decl_iterator<SpecificDecl/*, Acceptable*/> /*&*/ y) {
      return x.Current.$eq(y.Current);
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1608,
     FQN="clang::operator!=", NM="_ZN5clangneERKNS_11DeclContext22filtered_decl_iteratorIT_XT0_EEES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangneERKNS_11DeclContext22filtered_decl_iteratorIT_XT0_EEES6_")
    //</editor-fold>
    public static <SpecificDecl extends Decl> boolean $noteq_filtered_decl_iterator$C(final /*const*/ filtered_decl_iterator<SpecificDecl/*, Acceptable*/> /*&*/ x, 
                                   final /*const*/ filtered_decl_iterator<SpecificDecl/*, Acceptable*/> /*&*/ y) {
      return x.Current.$noteq(y.Current);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private final SpecificDecl$BoolPredicate<SpecificDecl>/*const*/ Acceptable;
    private final Class<SpecificDecl> clazz;
    
    public filtered_decl_iterator(filtered_decl_iterator<SpecificDecl> $Prm0) {
      this.clazz = $Prm0.clazz;
      this.Acceptable = $Prm0.Acceptable;
      this.Current = new DeclContext.decl_iterator($Prm0.Current);
    }
    
    @Override public boolean $eq(Object other) { 
      return $eq_filtered_decl_iterator$C(this, (filtered_decl_iterator)other); 
    }

    @Override public boolean $noteq(Object other) { 
      return $noteq_filtered_decl_iterator$C(this, (filtered_decl_iterator)other); 
    }

    @Override
    public filtered_decl_iterator clone() {
      return new filtered_decl_iterator(this);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Current=" + Current; // NOI18N
    }
  };
  
  /// @brief Add the declaration D into this context.
  ///
  /// This routine should be invoked when the declaration D has first
  /// been declared, to place D into the context where it was
  /// (lexically) defined. Every declaration must be added to one
  /// (and only one!) context, where it can be visited via
  /// [decls_begin(), decls_end()). Once a declaration has been added
  /// to its lexical context, the corresponding DeclContext owns the
  /// declaration.
  ///
  /// If D is also a NamedDecl, it will be made visible within its
  /// semantic context via makeDeclVisibleInContext.
  
  /// @brief Add the declaration D into this context.
  ///
  /// This routine should be invoked when the declaration D has first
  /// been declared, to place D into the context where it was
  /// (lexically) defined. Every declaration must be added to one
  /// (and only one!) context, where it can be visited via
  /// [decls_begin(), decls_end()). Once a declaration has been added
  /// to its lexical context, the corresponding DeclContext owns the
  /// declaration.
  ///
  /// If D is also a NamedDecl, it will be made visible within its
  /// semantic context via makeDeclVisibleInContext.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1296,
   FQN="clang::DeclContext::addDecl", NM="_ZN5clang11DeclContext7addDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext7addDeclEPNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ void addDecl(Decl /*P*/ D) {
    this.addHiddenDecl(D);
    {
      
      NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
      if ((ND != null)) {
        ND.getDeclContext().getPrimaryContext().
            makeDeclVisibleInContextWithFlags(ND, false, true);
      }
    }
  }


  
  /// @brief Add the declaration D into this context, but suppress
  /// searches for external declarations with the same name.
  ///
  /// Although analogous in function to addDecl, this removes an
  /// important check.  This is only useful if the Decl is being
  /// added in response to an external search; in all other cases,
  /// addDecl() is the right function to use.
  /// See the ASTImporter for use cases.
  
  /// @brief Add the declaration D into this context, but suppress
  /// searches for external declarations with the same name.
  ///
  /// Although analogous in function to addDecl, this removes an
  /// important check.  This is only useful if the Decl is being
  /// added in response to an external search; in all other cases,
  /// addDecl() is the right function to use.
  /// See the ASTImporter for use cases.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::addDeclInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1304,
   FQN="clang::DeclContext::addDeclInternal", NM="_ZN5clang11DeclContext15addDeclInternalEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext15addDeclInternalEPNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ void addDeclInternal(Decl /*P*/ D) {
    this.addHiddenDecl(D);
    {
      
      NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
      if ((ND != null)) {
        ND.getDeclContext().getPrimaryContext().
            makeDeclVisibleInContextWithFlags(ND, true, true);
      }
    }
  }


  
  /// @brief Add the declaration D to this context without modifying
  /// any lookup tables.
  ///
  /// This is useful for some operations in dependent contexts where
  /// the semantic context might not be dependent;  this basically
  /// only happens with friends.
  
  /// @brief Add the declaration D to this context without modifying
  /// any lookup tables.
  ///
  /// This is useful for some operations in dependent contexts where
  /// the semantic context might not be dependent;  this basically
  /// only happens with friends.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::addHiddenDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1270,
   FQN="clang::DeclContext::addHiddenDecl", NM="_ZN5clang11DeclContext13addHiddenDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext13addHiddenDeclEPNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ void addHiddenDecl(Decl /*P*/ D) {
    assert (D.getLexicalDeclContext() == this) : "Decl inserted into wrong lexical context";
    assert (!(D.getNextDeclInContext() != null) && D != $DeclContext$Fields().LastDecl) : "Decl already inserted into a DeclContext";
    if (($DeclContext$Fields().FirstDecl != null)) {
      $DeclContext$Fields().LastDecl.NextInContextAndBits.setPointer(D);
      $DeclContext$Fields().LastDecl = D;
    } else {
      $DeclContext$Fields().FirstDecl = $DeclContext$Fields().LastDecl = D;
    }
    {

      // Notify a C++ record declaration that we've added a member, so it can
      // update its class-specific state.
      CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(this);
      if ((Record != null)) {
        Record.addedMember(D);
      }
    }

    // If this is a newly-created (not de-serialized) import declaration, wire
    // it in to the list of local import declarations.
    if (!D.isFromASTFile()) {
      {
        ImportDecl /*P*/ Import = dyn_cast_ImportDecl(D);
        if ((Import != null)) {
          D.getASTContext().addedLocalImportDecl(Import);
        }
      }
    }
  }
  

  
  /// @brief Removes a declaration from this context.
  
  /// @brief Removes a declaration from this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::removeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1224,
   FQN="clang::DeclContext::removeDecl", NM="_ZN5clang11DeclContext10removeDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext10removeDeclEPNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ void removeDecl(Decl /*P*/ D) {
    assert (D.getLexicalDeclContext() == this) : "decl being removed from non-lexical context";
    assert (((D.NextInContextAndBits.getPointer() != null) || D == $DeclContext$Fields().LastDecl)) : "decl is not in decls list";
    
    // Remove D from the decl chain.  This is O(n) but hopefully rare.
    if (D == $DeclContext$Fields().FirstDecl) {
      if (D == $DeclContext$Fields().LastDecl) {
        $DeclContext$Fields().FirstDecl = $DeclContext$Fields().LastDecl = null;
      } else {
        $DeclContext$Fields().FirstDecl = D.NextInContextAndBits.getPointer();
      }
    } else {
      for (Decl /*P*/ I = $DeclContext$Fields().FirstDecl; true; I = I.NextInContextAndBits.getPointer()) {
        assert ((I != null)) : "decl not found in linked list";
        if (I.NextInContextAndBits.getPointer() == D) {
          I.NextInContextAndBits.setPointer(D.NextInContextAndBits.getPointer());
          if (D == $DeclContext$Fields().LastDecl) {
            $DeclContext$Fields().LastDecl = I;
          }
          break;
        }
      }
    }

    // Mark that D is no longer in the decl chain.
    D.NextInContextAndBits.setPointer((Decl /*P*/ )null);

    // Remove D from the lookup table if necessary.
    if (isa_NamedDecl(D)) {
      NamedDecl /*P*/ ND = cast_NamedDecl(D);
  
      // Remove only decls that have a name
      if (!ND.getDeclName().$bool()) {
        return;
      }
      
      DeclContext /*P*/ DC = this;
      do {
        StoredDeclsMap /*P*/ Map = DC.getPrimaryContext().$DeclContext$Fields().LookupPtr;
        if ((Map != null)) {
          DenseMapIterator<DeclarationName, StoredDeclsList> Pos = Map.find(ND.getDeclName());
          assert (Pos.$noteq(/*NO_ITER_COPY*/Map.end())) : "no lookup entry for decl";
          if ((Pos.$arrow().second.getAsVector() != null) || Pos.$arrow().second.getAsDecl() == ND) {
            Pos.$arrow().second.remove(ND);
          }
        }
      } while (DC.isTransparentContext() && ((DC = DC.getParent()) != null));
    }
  }


  
  /// @brief Checks whether a declaration is in this context.
  
  /// @brief Checks whether a declaration is in this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::containsDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1219,
   FQN="clang::DeclContext::containsDecl", NM="_ZNK5clang11DeclContext12containsDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext12containsDeclEPNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ boolean containsDecl(Decl /*P*/ D) /*const*/ {
    return (D.getLexicalDeclContext() == this
       && ((D.NextInContextAndBits.getPointer() != null) || D == $DeclContext$Fields().LastDecl));
  }


  
  /*typedef DeclContextLookupResult lookup_result*/
//  public final class lookup_result extends DeclContextLookupResult{ };
  /*typedef lookup_result::iterator lookup_iterator*/
//  public final class lookup_iterator extends DeclContextLookupResult.iterator{ };
  
  /// lookup - Find the declarations (if any) with the given Name in
  /// this context. Returns a range of iterators that contains all of
  /// the declarations with this name, with object, function, member,
  /// and enumerator names preceding any tag name. Note that this
  /// routine will not look into parent contexts.
  
  /// lookup - Find the declarations (if any) with the given Name in
  /// this context. Returns a range of iterators that contains all of
  /// the declarations with this name, with object, function, member,
  /// and enumerator names preceding any tag name. Note that this
  /// routine will not look into parent contexts.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1406,
   FQN="clang::DeclContext::lookup", NM="_ZNK5clang11DeclContext6lookupENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext6lookupENS_15DeclarationNameE")
  //</editor-fold>
  public default/*interface*/ DeclContextLookupResult lookup(DeclarationName Name) /*const*/ {
    assert ($8bits_uint2uint($DeclContext$Fields().DeclKind) != Decl.Kind.LinkageSpec.getValue()) : "Should not perform lookups into linkage specs!";
    
    /*const*/ DeclContext /*P*/ PrimaryContext = this.getPrimaryContext$Const();
    if (PrimaryContext != this) {
      return PrimaryContext.lookup(new DeclarationName(Name));
    }

    // If we have an external source, ensure that any later redeclarations of this
    // context have been loaded, since they may add names to the result of this
    // lookup (or add external visible storage).
    ExternalASTSource /*P*/ Source = this.getParentASTContext().getExternalSource();
    if ((Source != null)) {
      /*J:(void)*/cast_Decl(this).getMostRecentDecl$Decl$Const();
    }
    if (this.hasExternalVisibleStorage()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert ((Source != null)) : "external visible storage but no external source?";
        if ($DeclContext$Fields().NeedToReconcileExternalVisibleStorage) {
          this.reconcileExternalVisibleStorage();
        }

        StoredDeclsMap /*P*/ Map = $DeclContext$Fields().LookupPtr;
        if ($DeclContext$Fields().HasLazyLocalLexicalLookups || $DeclContext$Fields().HasLazyExternalLexicalLookups) {
          // FIXME: Make buildLookup const?
          Map = ((/*const_cast*/DeclContext /*P*/ )(this)).buildLookup();
        }
        if (!(Map != null)) {
          Map = this.CreateStoredDeclsMap(this.getParentASTContext());
        }
  
        // If we have a lookup result with no external decls, we are done.
        std.pairTypeBool<DenseMapIterator<DeclarationName, StoredDeclsList>> R = $c$.clean(Map.insert_pair$KeyT$ValueT($c$.track(std.make_pair(Name, $c$.track(new StoredDeclsList())))));
        if (!R.second && !R.first.$arrow().second.hasExternalDecls()) {
          return R.first.$arrow().second.getLookupResult();
        }
        if (Source.FindExternalVisibleDeclsByName(this, new DeclarationName(Name)) || !R.second) {
          {
            StoredDeclsMap /*P*/ Map$1 = $DeclContext$Fields().LookupPtr;
            if ((Map$1 != null)) {
              DenseMapIterator<DeclarationName, StoredDeclsList> I = Map$1.find(Name);
              if (I.$noteq(/*NO_ITER_COPY*/Map$1.end())) {
                return I.$arrow().second.getLookupResult();
              }
            }
          }
        }
        
        return new DeclContextLookupResult();
      } finally {
        $c$.$destroy();
      }
    }
    
    StoredDeclsMap /*P*/ Map = $DeclContext$Fields().LookupPtr;
    if ($DeclContext$Fields().HasLazyLocalLexicalLookups || $DeclContext$Fields().HasLazyExternalLexicalLookups) {
      Map = ((/*const_cast*/DeclContext /*P*/ )(this)).buildLookup();
    }
    if (!(Map != null)) {
      return new DeclContextLookupResult();
    }
    
    DenseMapIterator<DeclarationName, StoredDeclsList> I = Map.find(Name);
    if (I.$eq(/*NO_ITER_COPY*/Map.end())) {
      return new DeclContextLookupResult();
    }
    
    return I.$arrow().second.getLookupResult();
  }


  
  /// \brief Find the declarations with the given name that are visible
  /// within this context; don't attempt to retrieve anything from an
  /// external source.
  
  /// \brief Find the declarations with the given name that are visible
  /// within this context; don't attempt to retrieve anything from an
  /// external source.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1468,
   FQN="clang::DeclContext::noload_lookup", NM="_ZN5clang11DeclContext13noload_lookupENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext13noload_lookupENS_15DeclarationNameE")
  //</editor-fold>
  public default/*interface*/ DeclContextLookupResult noload_lookup(DeclarationName Name) {
    assert ($8bits_uint2uint($DeclContext$Fields().DeclKind) != Decl.Kind.LinkageSpec.getValue()) : "Should not perform lookups into linkage specs!";
    
    DeclContext /*P*/ PrimaryContext = this.getPrimaryContext();
    if (PrimaryContext != this) {
      return PrimaryContext.noload_lookup(new DeclarationName(Name));
    }

    // If we have any lazy lexical declarations not in our lookup map, add them
    // now. Don't import any external declarations, not even if we know we have
    // some missing from the external visible lookups.
    if ($DeclContext$Fields().HasLazyLocalLexicalLookups) {
      SmallVector<DeclContext /*P*/ > Contexts/*J*/= new SmallVector<DeclContext /*P*/ >(2, (DeclContext /*P*/ )null);
      this.collectAllContexts(Contexts);
      for (/*uint*/int I = 0, N = Contexts.size(); I != N; ++I)  {
        this.buildLookupImpl(Contexts.$at(I), this.hasExternalVisibleStorage());
      }
      $DeclContext$Fields().HasLazyLocalLexicalLookups = false;
    }

    StoredDeclsMap /*P*/ Map = $DeclContext$Fields().LookupPtr;
    if (!(Map != null)) {
      return new DeclContextLookupResult();
    }
  
    DenseMapIterator<DeclarationName, StoredDeclsList> I = Map.find(Name);
    return I.$noteq(/*NO_ITER_COPY*/Map.end()) ? I.$arrow().second.getLookupResult() : new DeclContextLookupResult();
  }


  
  /// \brief A simplistic name lookup mechanism that performs name lookup
  /// into this declaration context without consulting the external source.
  ///
  /// This function should almost never be used, because it subverts the
  /// usual relationship between a DeclContext and the external source.
  /// See the ASTImporter for the (few, but important) use cases.
  ///
  /// FIXME: This is very inefficient; replace uses of it with uses of
  /// noload_lookup.
  
  /// \brief A simplistic name lookup mechanism that performs name lookup
  /// into this declaration context without consulting the external source.
  ///
  /// This function should almost never be used, because it subverts the
  /// usual relationship between a DeclContext and the external source.
  /// See the ASTImporter for the (few, but important) use cases.
  ///
  /// FIXME: This is very inefficient; replace uses of it with uses of
  /// noload_lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::localUncachedLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1497,
   FQN="clang::DeclContext::localUncachedLookup", NM="_ZN5clang11DeclContext19localUncachedLookupENS_15DeclarationNameERN4llvm15SmallVectorImplIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext19localUncachedLookupENS_15DeclarationNameERN4llvm15SmallVectorImplIPNS_9NamedDeclEEE")
  //</editor-fold>
  public default/*interface*/ void localUncachedLookup(DeclarationName Name, 
                     final SmallVectorImpl<NamedDecl /*P*/ > /*&*/ Results) {
    Results.clear();
    
    // If there's no external storage, just perform a normal lookup and copy
    // the results.
    if (!this.hasExternalVisibleStorage() && !this.hasExternalLexicalStorage() && Name.$bool()) {
      DeclContextLookupResult LookupResults = this.lookup(new DeclarationName(Name));
      Results.insert$T$value_T(Results.end(), LookupResults.begin(), LookupResults.end());
      return;
    }

    // If we have a lookup table, check there first. Maybe we'll get lucky.
    // FIXME: Should we be checking these flags on the primary context?
    if (Name.$bool() && !$DeclContext$Fields().HasLazyLocalLexicalLookups && !$DeclContext$Fields().HasLazyExternalLexicalLookups) {
      {
        StoredDeclsMap /*P*/ Map = $DeclContext$Fields().LookupPtr;
        if ((Map != null)) {
          DenseMapIterator<DeclarationName, StoredDeclsList> Pos = Map.find(Name);
          if (Pos.$noteq(/*NO_ITER_COPY*/Map.end())) {
            Results.insert$T$value_T(Results.end(), 
                Pos.$arrow().second.getLookupResult().begin(), 
                Pos.$arrow().second.getLookupResult().end());
            return;
          }
        }
      }
    }

    // Slow case: grovel through the declarations in our chain looking for 
    // matches.
    // FIXME: If we have lazy external declarations, this will not find them!
    // FIXME: Should we CollectAllContexts and walk them all here?
    for (Decl /*P*/ D = $DeclContext$Fields().FirstDecl; (D != null); D = D.getNextDeclInContext()) {
      {
        NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
        if ((ND != null)) {
          if ($eq_DeclarationName(ND.getDeclName(), /*NO_COPY*/Name)) {
            Results.push_back(ND);
          }
        }
      }
    }
  }
  

  
  /// @brief Makes a declaration visible within this context.
  ///
  /// This routine makes the declaration D visible to name lookup
  /// within this context and, if this is a transparent context,
  /// within its parent contexts up to the first enclosing
  /// non-transparent context. Making a declaration visible within a
  /// context does not transfer ownership of a declaration, and a
  /// declaration can be visible in many contexts that aren't its
  /// lexical context.
  ///
  /// If D is a redeclaration of an existing declaration that is
  /// visible from this context, as determined by
  /// NamedDecl::declarationReplaces, the previous declaration will be
  /// replaced with D.
  
  /// @brief Makes a declaration visible within this context.
  ///
  /// This routine makes the declaration D visible to name lookup
  /// within this context and, if this is a transparent context,
  /// within its parent contexts up to the first enclosing
  /// non-transparent context. Making a declaration visible within a
  /// context does not transfer ownership of a declaration, and a
  /// declaration can be visible in many contexts that aren't its
  /// lexical context.
  ///
  /// If D is a redeclaration of an existing declaration that is
  /// visible from this context, as determined by
  /// NamedDecl::declarationReplaces, the previous declaration will be
  /// replaced with D.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::makeDeclVisibleInContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1579,
   FQN="clang::DeclContext::makeDeclVisibleInContext", NM="_ZN5clang11DeclContext24makeDeclVisibleInContextEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext24makeDeclVisibleInContextEPNS_9NamedDeclE")
  //</editor-fold>
  public default/*interface*/ void makeDeclVisibleInContext(NamedDecl /*P*/ D) {
    DeclContext /*P*/ PrimaryDC = this.getPrimaryContext();
    DeclContext /*P*/ DeclDC = D.getDeclContext().getPrimaryContext();
    // If the decl is being added outside of its semantic decl context, we
    // need to ensure that we eagerly build the lookup information for it.
    PrimaryDC.makeDeclVisibleInContextWithFlags(D, false, PrimaryDC == DeclDC);
  }


  
  /// all_lookups_iterator - An iterator that provides a view over the results
  /// of looking up every possible name.

  /// all_lookups_iterator - An iterator that provides a view over the results
  /// of looking up every possible name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 26,
   FQN="clang::DeclContext::all_lookups_iterator", NM="_ZN5clang11DeclContext20all_lookups_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorE")
  //</editor-fold>
  public static class all_lookups_iterator implements type$iterator<all_lookups_iterator, DeclContextLookupResult> {
    private DenseMapIterator<DeclarationName, StoredDeclsList> It;
    private DenseMapIterator<DeclarationName, StoredDeclsList> End;
  /*public:*/
    /*typedef lookup_result value_type*/
//    public final class value_type extends DeclContextLookupResult{ };
    /*typedef lookup_result reference*/
//    public final class reference extends DeclContextLookupResult{ };
    /*typedef lookup_result pointer*/
//    public final class pointer extends DeclContextLookupResult{ };
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    /*typedef std::ptrdiff_t difference_type*/;

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::all_lookups_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 35,
     FQN="clang::DeclContext::all_lookups_iterator::all_lookups_iterator", NM="_ZN5clang11DeclContext20all_lookups_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorC1Ev")
    //</editor-fold>
    public all_lookups_iterator() {
      // : It(), End() 
      //START JInit
      this.It = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>());
      this.End = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::all_lookups_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 36,
     FQN="clang::DeclContext::all_lookups_iterator::all_lookups_iterator", NM="_ZN5clang11DeclContext20all_lookups_iteratorC1EN4llvm16DenseMapIteratorINS_15DeclarationNameENS_15StoredDeclsListENS2_12DenseMapInfoIS4_EENS2_6detail12DenseMapPairIS4_S5_EELb0EEESB_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorC1EN4llvm16DenseMapIteratorINS_15DeclarationNameENS_15StoredDeclsListENS2_12DenseMapInfoIS4_EENS2_6detail12DenseMapPairIS4_S5_EELb0EEESB_")
    //</editor-fold>
    public all_lookups_iterator(DenseMapIterator<DeclarationName, StoredDeclsList> It, 
        DenseMapIterator<DeclarationName, StoredDeclsList> End) {
      // : It(It), End(End) 
      //START JInit
      this.It = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>(It));
      this.End = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>(End));
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::getLookupName">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 40,
     FQN="clang::DeclContext::all_lookups_iterator::getLookupName", NM="_ZNK5clang11DeclContext20all_lookups_iterator13getLookupNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext20all_lookups_iterator13getLookupNameEv")
    //</editor-fold>
    public DeclarationName getLookupName() /*const*/ {
      return new DeclarationName(It.$arrow().first);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 42,
     FQN="clang::DeclContext::all_lookups_iterator::operator*", NM="_ZNK5clang11DeclContext20all_lookups_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext20all_lookups_iteratordeEv")
    //</editor-fold>
    public DeclContextLookupResult $star() /*const*/ {
      return It.$arrow().second.getLookupResult();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 43,
     FQN="clang::DeclContext::all_lookups_iterator::operator->", NM="_ZNK5clang11DeclContext20all_lookups_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext20all_lookups_iteratorptEv")
    //</editor-fold>
    public DeclContextLookupResult $arrow() /*const*/ {
      return It.$arrow().second.getLookupResult();
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 45,
     FQN="clang::DeclContext::all_lookups_iterator::operator++", NM="_ZN5clang11DeclContext20all_lookups_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorppEv")
    //</editor-fold>
    public all_lookups_iterator /*&*/ $preInc() {
      // Filter out using directives. They don't belong as results from name
      // lookup anyways, except as an implementation detail. Users of the API
      // should not expect to get them (or worse, rely on it).
      do {
        It.$preInc();
      } while (It.$noteq(/*NO_ITER_COPY*/End)
         && $eq_DeclarationName(/*NO_COPY*/It.$arrow().first, DeclarationName.getUsingDirectiveName()));
      
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 57,
     FQN="clang::DeclContext::all_lookups_iterator::operator++", NM="_ZN5clang11DeclContext20all_lookups_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorppEi")
    //</editor-fold>
    public all_lookups_iterator $postInc(int $Prm0) {
      all_lookups_iterator tmp/*J*/= new all_lookups_iterator(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return tmp;
    }


    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 63,
     FQN="clang::operator==", NM="_ZN5clangeqENS_11DeclContext20all_lookups_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangeqENS_11DeclContext20all_lookups_iteratorES1_")
    //</editor-fold>
    public static boolean $eq_all_lookups_iterator(DeclContext.all_lookups_iterator x, DeclContext.all_lookups_iterator y) {
      return x.It.$eq(/*NO_ITER_COPY*/y.It);
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 66,
     FQN="clang::operator!=", NM="_ZN5clangneENS_11DeclContext20all_lookups_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clangneENS_11DeclContext20all_lookups_iteratorES1_")
    //</editor-fold>
    public static boolean $noteq_all_lookups_iterator(DeclContext.all_lookups_iterator x, DeclContext.all_lookups_iterator y) {
      return x.It.$noteq(/*NO_ITER_COPY*/y.It);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::all_lookups_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 26,
     FQN="clang::DeclContext::all_lookups_iterator::all_lookups_iterator", NM="_ZN5clang11DeclContext20all_lookups_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ all_lookups_iterator(final /*const*/ all_lookups_iterator /*&*/ $Prm0) {
      // : It(.It), End(.End) 
      //START JInit
      this.It = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>($Prm0.It));
      this.End = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>($Prm0.End));
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::all_lookups_iterator::all_lookups_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 26,
     FQN="clang::DeclContext::all_lookups_iterator::all_lookups_iterator", NM="_ZN5clang11DeclContext20all_lookups_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext20all_lookups_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ all_lookups_iterator(JD$Move _dparam, final all_lookups_iterator /*&&*/$Prm0) {
      // : It(static_cast<all_lookups_iterator &&>().It), End(static_cast<all_lookups_iterator &&>().End) 
      //START JInit
      this.It = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>(JD$Move.INSTANCE, $Prm0.It));
      this.End = $tryClone(new DenseMapIterator<DeclarationName, StoredDeclsList>(JD$Move.INSTANCE, $Prm0.End));
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    @Override public boolean $noteq(Object other) { return $noteq_all_lookups_iterator(this, (all_lookups_iterator)other); }
    
    @Override public boolean $eq(Object other) { return $eq_all_lookups_iterator(this, (all_lookups_iterator)other); }

    @Override public all_lookups_iterator clone() { return new all_lookups_iterator(this); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "It=" + It // NOI18N
                + ", End=" + End; // NOI18N
    }
  };
  
  /*typedef llvm::iterator_range<all_lookups_iterator> lookups_range*/
//  public final class lookups_range extends iterator_range<DeclContextLookupResult>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::lookups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 71,
   FQN="clang::DeclContext::lookups", NM="_ZNK5clang11DeclContext7lookupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext7lookupsEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ iterator_range<DeclContextLookupResult> lookups() /*const*/ {
    DeclContext /*P*/ Primary = ((/*const_cast*/DeclContext /*P*/ )(this)).getPrimaryContext();
    if (Primary.hasExternalVisibleStorage()) {
      this.getParentASTContext().getExternalSource().completeVisibleDeclsMap(Primary);
    }
    {
      StoredDeclsMap /*P*/ Map = Primary.buildLookup();
      if ((Map != null)) {
        return new iterator_range<DeclContextLookupResult>(new all_lookups_iterator(Map.begin(), Map.end()), 
            new all_lookups_iterator(Map.end(), Map.end()));
      }
    }

    // Synthesize an empty range. This requires that two default constructed
    // versions of these iterators form a valid empty range.
    return new iterator_range<DeclContextLookupResult>(new all_lookups_iterator(), new all_lookups_iterator());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_lookups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 92,
   FQN="clang::DeclContext::noload_lookups", NM="_ZNK5clang11DeclContext14noload_lookupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext14noload_lookupsEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ iterator_range<DeclContextLookupResult> noload_lookups() /*const*/ {
    DeclContext /*P*/ Primary = ((/*const_cast*/DeclContext /*P*/ )(this)).getPrimaryContext();
    {
      StoredDeclsMap /*P*/ Map = Primary.getLookupPtr();
      if ((Map != null)) {
        return new iterator_range<DeclContextLookupResult>(new all_lookups_iterator(Map.begin(), Map.end()), 
            new all_lookups_iterator(Map.end(), Map.end()));
      }
    }

    // Synthesize an empty range. This requires that two default constructed
    // versions of these iterators form a valid empty range.
    return new iterator_range<DeclContextLookupResult>(new all_lookups_iterator(), new all_lookups_iterator());
  }
  
  
  /// \brief Iterators over all possible lookups within this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::lookups_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 84,
   FQN="clang::DeclContext::lookups_begin", NM="_ZNK5clang11DeclContext13lookups_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext13lookups_beginEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ DeclContext.all_lookups_iterator lookups_begin() /*const*/ {
    return ((all_lookups_iterator)this.lookups().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::lookups_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 88,
   FQN="clang::DeclContext::lookups_end", NM="_ZNK5clang11DeclContext11lookups_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext11lookups_endEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ DeclContext.all_lookups_iterator lookups_end() /*const*/ {
    return ((all_lookups_iterator)this.lookups().end());
  }

  
  /// \brief Iterators over all possible lookups within this context that are
  /// currently loaded; don't attempt to retrieve anything from an external
  /// source.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_lookups_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 103,
   FQN="clang::DeclContext::noload_lookups_begin", NM="_ZNK5clang11DeclContext20noload_lookups_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext20noload_lookups_beginEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ DeclContext.all_lookups_iterator noload_lookups_begin() /*const*/ {
    return ((all_lookups_iterator)this.noload_lookups().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::noload_lookups_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclLookups.h", line = 108,
   FQN="clang::DeclContext::noload_lookups_end", NM="_ZNK5clang11DeclContext18noload_lookups_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext18noload_lookups_endEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ DeclContext.all_lookups_iterator noload_lookups_end() /*const*/ {
    return ((all_lookups_iterator)this.noload_lookups().end());
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::udir_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1718,
   FQN="clang::DeclContext::udir_iterator", NM="_ZN5clang11DeclContext13udir_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13udir_iteratorE")
  //</editor-fold>
  public static class/*struct*/ udir_iterator extends /**/ iterator_adaptor_base<udir_iterator, DeclContextLookupResult.iterator, std.random_access_iterator_tag, UsingDirectiveDecl /*P*/, UsingDirectiveDecl /*P*/ > {
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::udir_iterator::udir_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1719,
     FQN="clang::DeclContext::udir_iterator::udir_iterator", NM="_ZN5clang11DeclContext13udir_iteratorC1ENS_23DeclContextLookupResult8iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext13udir_iteratorC1ENS_23DeclContextLookupResult8iteratorE")
    //</editor-fold>
    public udir_iterator(DeclContextLookupResult.iterator I) {
      // : udir_iterator_base(I) 
      //START JInit
      super(new DeclContextLookupResult.iterator(I));
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::udir_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1682,
     FQN="clang::DeclContext::udir_iterator::operator*", NM="_ZNK5clang11DeclContext13udir_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext13udir_iteratordeEv")
    //</editor-fold>
    public UsingDirectiveDecl /*P*/ $star() /*const*/ {
      return cast_UsingDirectiveDecl(I.$star());
    }



    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::udir_iterator::udir_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1718,
     FQN="clang::DeclContext::udir_iterator::udir_iterator", NM="_ZN5clang11DeclContext13udir_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext13udir_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ udir_iterator(JD$Move _dparam, final udir_iterator /*&&*/$Prm0) {
      // : udir_iterator_base(static_cast<udir_iterator &&>()) 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::udir_iterator::~udir_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1718,
     FQN="clang::DeclContext::udir_iterator::~udir_iterator", NM="_ZN5clang11DeclContext13udir_iteratorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext13udir_iteratorD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::udir_iterator::udir_iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1718,
     FQN="clang::DeclContext::udir_iterator::udir_iterator", NM="_ZN5clang11DeclContext13udir_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang11DeclContext13udir_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ udir_iterator(final /*const*/ udir_iterator /*&*/ $Prm0) {
      // : udir_iterator_base() 
      //START JInit
      super(JD$BaseOf.INSTANCE, $Prm0);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    @Override public udir_iterator clone() { return new udir_iterator(this); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  /*typedef llvm::iterator_adaptor_base<udir_iterator, lookup_iterator, std::random_access_iterator_tag, UsingDirectiveDecl *> udir_iterator_base*/
//  public final class udir_iterator_base extends iterator_adaptor_base<udir_iterator, DeclContextLookupResult.iterator, std.random_access_iterator_tag, UsingDirectiveDecl /*P*/ >{ };
  ;
  
  /*typedef llvm::iterator_range<udir_iterator> udir_range*/
//  public final class udir_range extends iterator_range<UsingDirectiveDecl /*P*/ >{ };
  
  /// Returns iterator range [First, Last) of UsingDirectiveDecls stored within
  /// this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::using_directives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1688,
   FQN="clang::DeclContext::using_directives", NM="_ZNK5clang11DeclContext16using_directivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext16using_directivesEv")
  //</editor-fold>
  public default/*interface*/ iterator_range<UsingDirectiveDecl /*P*/ > using_directives() /*const*/ {
    // FIXME: Use something more efficient than normal lookup for using
    // directives. In C++, using directives are looked up more than anything else.
    DeclContextLookupResult Result = this.lookup(UsingDirectiveDecl.getUsingDirectiveName());
    return new iterator_range<UsingDirectiveDecl /*P*/ >(new udir_iterator(Result.begin()), new udir_iterator(Result.end()));
  }


  
  // These are all defined in DependentDiagnostic.h.
  
  
  // These are all defined in DependentDiagnostic.h.
  
  /// 
  
  /// An iterator over the dependent diagnostics in a dependent context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 124,
   FQN="clang::DeclContext::ddiag_iterator", NM="_ZN5clang11DeclContext14ddiag_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorE")
  //</editor-fold>
  public static class ddiag_iterator implements type$iterator<ddiag_iterator, DependentDiagnostic /*P*/>, Native.NativeComparable {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::ddiag_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 126,
     FQN="clang::DeclContext::ddiag_iterator::ddiag_iterator", NM="_ZN5clang11DeclContext14ddiag_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorC1Ev")
    //</editor-fold>
    public ddiag_iterator() {
      // : Ptr(null) 
      //START JInit
      this.Ptr = null;
      //END JInit
    }
  
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::ddiag_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 127,
     FQN="clang::DeclContext::ddiag_iterator::ddiag_iterator", NM="_ZN5clang11DeclContext14ddiag_iteratorC1EPNS_19DependentDiagnosticE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorC1EPNS_19DependentDiagnosticE")
    //</editor-fold>
    public /*explicit*/ ddiag_iterator(DependentDiagnostic /*P*/ Ptr) {
      // : Ptr(Ptr) 
      //START JInit
      this.Ptr = Ptr;
      //END JInit
    }
  
    
    /*typedef DependentDiagnostic *value_type*/
  //  public final class value_type extends DependentDiagnostic /*P*/ { };
    /*typedef DependentDiagnostic *reference*/
  //  public final class reference extends DependentDiagnostic /*P*/ { };
    /*typedef DependentDiagnostic *pointer*/
  //  public final class pointer extends DependentDiagnostic /*P*/ { };
    /*typedef int difference_type*/;
    /*typedef std::forward_iterator_tag iterator_category*/
  //  public final class iterator_category extends std.forward_iterator_tag{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 135,
     FQN="clang::DeclContext::ddiag_iterator::operator*", NM="_ZNK5clang11DeclContext14ddiag_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext14ddiag_iteratordeEv")
    //</editor-fold>
    public DependentDiagnostic /*P*/ $star() /*const*/ {
      return Ptr;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 137,
     FQN="clang::DeclContext::ddiag_iterator::operator++", NM="_ZN5clang11DeclContext14ddiag_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorppEv")
    //</editor-fold>
    public ddiag_iterator /*&*/ $preInc() {
      assert ((Ptr != null)) : "attempt to increment past end of diag list";
      Ptr = Ptr.NextDiagnostic;
      return /*Deref*/this;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 143,
     FQN="clang::DeclContext::ddiag_iterator::operator++", NM="_ZN5clang11DeclContext14ddiag_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorppEi")
    //</editor-fold>
    public ddiag_iterator $postInc(int $Prm0) {
      ddiag_iterator tmp = new ddiag_iterator(/*Deref*/this);
      $Deref(this.$preInc());
      return tmp;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 149,
     FQN="clang::DeclContext::ddiag_iterator::operator==", NM="_ZNK5clang11DeclContext14ddiag_iteratoreqES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext14ddiag_iteratoreqES1_")
    //</editor-fold>
    public boolean $eq(ddiag_iterator Other) /*const*/ {
      return Ptr == Other.Ptr;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 153,
     FQN="clang::DeclContext::ddiag_iterator::operator!=", NM="_ZNK5clang11DeclContext14ddiag_iteratorneES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext14ddiag_iteratorneES1_")
    //</editor-fold>
    public boolean $noteq(ddiag_iterator Other) /*const*/ {
      return Ptr != Other.Ptr;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator+=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 157,
     FQN="clang::DeclContext::ddiag_iterator::operator+=", NM="_ZN5clang11DeclContext14ddiag_iteratorpLEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorpLEi")
    //</editor-fold>
    public ddiag_iterator /*&*/ $addassign(int N) {
      assert (N >= 0) : "cannot rewind a DeclContext::ddiag_iterator";
      while (((N--) != 0)) {
        $Deref(this.$preInc());
      }
      return /*Deref*/this;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::operator+">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 164,
     FQN="clang::DeclContext::ddiag_iterator::operator+", NM="_ZNK5clang11DeclContext14ddiag_iteratorplEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext14ddiag_iteratorplEi")
    //</editor-fold>
    public ddiag_iterator $add(int N) /*const*/ {
      ddiag_iterator tmp = new ddiag_iterator(/*Deref*/this);
      tmp.$addassign(N);
      return tmp;
    }
  
  /*private:*/
    private DependentDiagnostic /*P*/ Ptr;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::ddiag_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 124,
     FQN="clang::DeclContext::ddiag_iterator::ddiag_iterator", NM="_ZN5clang11DeclContext14ddiag_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ddiag_iterator(final /*const*/ ddiag_iterator /*&*/ $Prm0) {
      // : Ptr(.Ptr) 
      //START JInit
      this.Ptr = $Prm0.Ptr;
      //END JInit
    }
  
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiag_iterator::ddiag_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 124,
     FQN="clang::DeclContext::ddiag_iterator::ddiag_iterator", NM="_ZN5clang11DeclContext14ddiag_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext14ddiag_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ ddiag_iterator(JD$Move _dparam, final ddiag_iterator /*&&*/$Prm0) {
      // : Ptr(static_cast<ddiag_iterator &&>().Ptr) 
      //START JInit
      this.Ptr = $Prm0.Ptr;
      //END JInit
    }
  
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    @Override public boolean $eq(Object other) { return this.$eq((ddiag_iterator)other); }
    
    @Override public boolean $noteq(Object other) { return this.$noteq((ddiag_iterator)other); }
    
    @Override public ddiag_iterator clone() { return new ddiag_iterator(this); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Ptr=" + "[DependentDiagnostic]"; // NOI18N
    }
  };
  /*typedef llvm::iterator_range<DeclContext::ddiag_iterator> ddiag_range*/
//  public final class ddiag_range extends iterator_range<DeclContext.ddiag_iterator>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::ddiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 174,
   FQN="clang::DeclContext::ddiags", NM="_ZNK5clang11DeclContext6ddiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext6ddiagsEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ iterator_range<DependentDiagnostic /*P*/ > ddiags() /*const*/ {
    assert (this.isDependentContext()) : "cannot iterate dependent diagnostics of non-dependent context";
    /*const*/ DependentStoredDeclsMap /*P*/ Map = ((/*static_cast*/DependentStoredDeclsMap /*P*/ )(this.getPrimaryContext$Const().getLookupPtr()));
    if (!(Map != null)) {
      // Return an empty range using the always-end default constructor.
      return new iterator_range<DependentDiagnostic /*P*/ >(new ddiag_iterator(), new ddiag_iterator());
    }

    return new iterator_range<DependentDiagnostic /*P*/ >(new ddiag_iterator(Map.FirstDiagnostic), new ddiag_iterator());
  }

  
  
  // Low-level accessors
  
  /// \brief Mark that there are external lexical declarations that we need
  /// to include in our lookup table (and that are not available as external
  /// visible lookups). These extra lookup results will be found by walking
  /// the lexical declarations of this context. This should be used only if
  /// setHasExternalLexicalStorage() has been called on any decl context for
  /// which this is the primary context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::setMustBuildLookupTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1741,
   FQN="clang::DeclContext::setMustBuildLookupTable", NM="_ZN5clang11DeclContext23setMustBuildLookupTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext23setMustBuildLookupTableEv")
  //</editor-fold>
  public default/*interface*/ void setMustBuildLookupTable() {
    assert (this == this.getPrimaryContext()) : "should only be called on primary context";
    $DeclContext$Fields().HasLazyExternalLexicalLookups = true;
  }

  
  /// \brief Retrieve the internal representation of the lookup structure.
  /// This may omit some names if we are lazily building the structure.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::getLookupPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1749,
   FQN="clang::DeclContext::getLookupPtr", NM="_ZNK5clang11DeclContext12getLookupPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext12getLookupPtrEv")
  //</editor-fold>
  public default/*interface*/ StoredDeclsMap /*P*/ getLookupPtr() /*const*/ {
    return $DeclContext$Fields().LookupPtr;
  }

  
  /// \brief Ensure the lookup structure is fully-built and return it.
  
  /// \brief Ensure the lookup structure is fully-built and return it.
  
  /// buildLookup - Build the lookup data structure with all of the
  /// declarations in this DeclContext (and any other contexts linked
  /// to it or transparent contexts nested within it) and return it.
  ///
  /// Note that the produced map may miss out declarations from an
  /// external source. If it does, those entries will be marked with
  /// the 'hasExternalDecls' flag.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::buildLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1345,
   FQN="clang::DeclContext::buildLookup", NM="_ZN5clang11DeclContext11buildLookupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext11buildLookupEv")
  //</editor-fold>
  public default/*interface*/ StoredDeclsMap /*P*/ buildLookup() {
    assert (this == this.getPrimaryContext()) : "buildLookup called on non-primary DC";
    if (!$DeclContext$Fields().HasLazyLocalLexicalLookups && !$DeclContext$Fields().HasLazyExternalLexicalLookups) {
      return $DeclContext$Fields().LookupPtr;
    }

    SmallVector<DeclContext /*P*/ > Contexts/*J*/= new SmallVector<DeclContext /*P*/ >(2, (DeclContext /*P*/ )null);
    this.collectAllContexts(Contexts);
    if ($DeclContext$Fields().HasLazyExternalLexicalLookups) {
      $DeclContext$Fields().HasLazyExternalLexicalLookups = false;
      for (DeclContext /*P*/ DC : Contexts) {
        if (DC.hasExternalLexicalStorage()) {
          $DeclContext$Fields().HasLazyLocalLexicalLookups |= DC.LoadLexicalDeclsFromExternalStorage();
        }
      }
      if (!$DeclContext$Fields().HasLazyLocalLexicalLookups) {
        return $DeclContext$Fields().LookupPtr;
      }
    }

    for (DeclContext /*P*/ DC : Contexts)  {
      this.buildLookupImpl(DC, this.hasExternalVisibleStorage());
    }
  
    // We no longer have any lazy decls.
    $DeclContext$Fields().HasLazyLocalLexicalLookups = false;
    return $DeclContext$Fields().LookupPtr;
  }


  
  /// \brief Whether this DeclContext has external storage containing
  /// additional declarations that are lexically in this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::hasExternalLexicalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1756,
   FQN="clang::DeclContext::hasExternalLexicalStorage", NM="_ZNK5clang11DeclContext25hasExternalLexicalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext25hasExternalLexicalStorageEv")
  //</editor-fold>
  public default/*interface*/ boolean hasExternalLexicalStorage() /*const*/ {
    return $DeclContext$Fields().ExternalLexicalStorage;
  }

  
  /// \brief State whether this DeclContext has external storage for
  /// declarations lexically in this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::setHasExternalLexicalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1760,
   FQN="clang::DeclContext::setHasExternalLexicalStorage", NM="_ZN5clang11DeclContext28setHasExternalLexicalStorageEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext28setHasExternalLexicalStorageEb")
  //</editor-fold>
  public default/*interface*/ void setHasExternalLexicalStorage() {
    setHasExternalLexicalStorage(true);
  }
  public default/*interface*/ void setHasExternalLexicalStorage(boolean ES/*= true*/) {
    $DeclContext$Fields().ExternalLexicalStorage = ES;
  }

  
  /// \brief Whether this DeclContext has external storage containing
  /// additional declarations that are visible in this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::hasExternalVisibleStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1766,
   FQN="clang::DeclContext::hasExternalVisibleStorage", NM="_ZNK5clang11DeclContext25hasExternalVisibleStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext25hasExternalVisibleStorageEv")
  //</editor-fold>
  public default/*interface*/ boolean hasExternalVisibleStorage() /*const*/ {
    return $DeclContext$Fields().ExternalVisibleStorage;
  }

  
  /// \brief State whether this DeclContext has external storage for
  /// declarations visible in this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::setHasExternalVisibleStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1770,
   FQN="clang::DeclContext::setHasExternalVisibleStorage", NM="_ZN5clang11DeclContext28setHasExternalVisibleStorageEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext28setHasExternalVisibleStorageEb")
  //</editor-fold>
  public default/*interface*/ void setHasExternalVisibleStorage() {
    setHasExternalVisibleStorage(true);
  }
  public default/*interface*/ void setHasExternalVisibleStorage(boolean ES/*= true*/) {
    $DeclContext$Fields().ExternalVisibleStorage = ES;
    if (ES && ($DeclContext$Fields().LookupPtr != null)) {
      $DeclContext$Fields().NeedToReconcileExternalVisibleStorage = true;
    }
  }

  
  /// \brief Determine whether the given declaration is stored in the list of
  /// declarations lexically within this context.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::isDeclInLexicalTraversal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1778,
   FQN="clang::DeclContext::isDeclInLexicalTraversal", NM="_ZNK5clang11DeclContext24isDeclInLexicalTraversalEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext24isDeclInLexicalTraversalEPKNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ boolean isDeclInLexicalTraversal(/*const*/ Decl /*P*/ D) /*const*/ {
    return (D != null) && ((D.NextInContextAndBits.getPointer() != null) || D == $DeclContext$Fields().FirstDecl
       || D == $DeclContext$Fields().LastDecl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::setUseQualifiedLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1783,
   FQN="clang::DeclContext::setUseQualifiedLookup", NM="_ZN5clang11DeclContext21setUseQualifiedLookupEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext21setUseQualifiedLookupEb")
  //</editor-fold>
  public default/*interface*/ boolean setUseQualifiedLookup() {
    return setUseQualifiedLookup(true);
  }
  public default/*interface*/ boolean setUseQualifiedLookup(boolean use/*= true*/) {
    boolean old_value = $DeclContext$Fields().UseQualifiedLookup;
    $DeclContext$Fields().UseQualifiedLookup = use;
    return old_value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::shouldUseQualifiedLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1789,
   FQN="clang::DeclContext::shouldUseQualifiedLookup", NM="_ZNK5clang11DeclContext24shouldUseQualifiedLookupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext24shouldUseQualifiedLookupEv")
  //</editor-fold>
  public default/*interface*/ boolean shouldUseQualifiedLookup() /*const*/ {
    return $DeclContext$Fields().UseQualifiedLookup;
  }

  
  //===----------------------------------------------------------------------===//
  // DeclContext Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 865,
   FQN="clang::DeclContext::classof", NM="_ZN5clang11DeclContext7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext7classofEPKNS_4DeclE")
  //</editor-fold>
  public /*interface*/ static boolean classof(/*const*/ Decl /*P*/ D) {
    switch (D.getKind()) {
     case Block:
     case Captured:
     case ExternCContext:
     case LinkageSpec:
     case Namespace:
     case OMPDeclareReduction:
     case ObjCMethod:
     case TranslationUnit:
      return true;
     default:
      if (D.getKind().getValue() >= Decl.Kind.firstFunction.getValue() && D.getKind().getValue() <= Decl.Kind.lastFunction.getValue()) {
        return true;
      }
      if (D.getKind().getValue() >= Decl.Kind.firstTag.getValue() && D.getKind().getValue() <= Decl.Kind.lastTag.getValue()) {
        return true;
      }
      if (D.getKind().getValue() >= Decl.Kind.firstObjCContainer.getValue() && D.getKind().getValue() <= Decl.Kind.lastObjCContainer.getValue()) {
        return true;
      }
      return false;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1794,
   FQN="clang::DeclContext::classof", NM="_ZN5clang11DeclContext7classofEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext7classofEPKS0_")
  //</editor-fold>
  public /*interface*/ static boolean classof(/*const*/ DeclContext /*P*/ D) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::dumpDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 183,
   FQN="clang::DeclContext::dumpDeclContext", NM="_ZNK5clang11DeclContext15dumpDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZNK5clang11DeclContext15dumpDeclContextEv")
  //</editor-fold>
  public default/*interface*/ void dumpDeclContext() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    // Get the translation unit
    /*const*/ DeclContext /*P*/ DC = this;
    while (!DC.isTranslationUnit()) {
      DC = DC.getParent$Const();
    }

    final ASTContext /*&*/ Ctx = cast_TranslationUnitDecl(DC).getASTContext();
    DeclPrinter Printer/*J*/= new DeclPrinter(llvm.errs(), Ctx.getPrintingPolicy(), 0);
    Printer.VisitDeclContext(((/*const_cast*/DeclContext /*P*/ )(this)), /*Indent=*/ false);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::dumpLookups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2479,
   FQN="clang::DeclContext::dumpLookups", NM="_ZNK5clang11DeclContext11dumpLookupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext11dumpLookupsEv")
  //</editor-fold>
  public default/*interface*/ void dumpLookups() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    this.dumpLookups(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::dumpLookups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2483,
   FQN="clang::DeclContext::dumpLookups", NM="_ZNK5clang11DeclContext11dumpLookupsERN4llvm11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang11DeclContext11dumpLookupsERN4llvm11raw_ostreamEb")
  //</editor-fold>
  public default/*interface*/ void dumpLookups(final raw_ostream /*&*/ OS) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpLookups(OS, 
             false);
  }
  public default/*interface*/ void dumpLookups(final raw_ostream /*&*/ OS, 
             boolean DumpDecls/*= false*/) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      /*const*/ DeclContext /*P*/ DC = this;
      while (!DC.isTranslationUnit()) {
        DC = DC.getParent$Const();
      }
      final ASTContext /*&*/ Ctx = cast_TranslationUnitDecl(DC).getASTContext();
      P/*J*/= new ASTDumper(OS, $AddrOf(Ctx.getCommentCommandTraits()), $AddrOf(Ctx.getSourceManager()));
      P.dumpLookups(this, DumpDecls);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

/*private:*/
  
  /// \brief We have just acquired external visible storage, and we already have
  /// built a lookup map. For every name in the map, pull in the new names from
  /// the external storage.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::reconcileExternalVisibleStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1097,
   FQN="clang::DeclContext::reconcileExternalVisibleStorage", NM="_ZNK5clang11DeclContext31reconcileExternalVisibleStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext31reconcileExternalVisibleStorageEv")
  //</editor-fold>
  public/*private*/ default/*interface*/ void reconcileExternalVisibleStorage() /*const*/ {
    assert ($DeclContext$Fields().NeedToReconcileExternalVisibleStorage && ($DeclContext$Fields().LookupPtr != null));
    $DeclContext$Fields().NeedToReconcileExternalVisibleStorage = false;
    
    for (final std.pair<DeclarationName, StoredDeclsList> /*&*/ Lookup : $Deref($DeclContext$Fields().LookupPtr))  {
      Lookup.second.setHasExternalDecls();
    }
  }


  
  /// \brief Load the declarations within this lexical storage from an
  /// external source.
  /// \return \c true if any declarations were added.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::LoadLexicalDeclsFromExternalStorage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1108,
   FQN="clang::DeclContext::LoadLexicalDeclsFromExternalStorage", NM="_ZNK5clang11DeclContext35LoadLexicalDeclsFromExternalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext35LoadLexicalDeclsFromExternalStorageEv")
  //</editor-fold>
  public/*private*/ default/*interface*/ boolean LoadLexicalDeclsFromExternalStorage() /*const*/ {
    ExternalASTSource.Deserializing ADeclContext = null;
    try {
      ExternalASTSource /*P*/ Source = this.getParentASTContext().getExternalSource();
      assert (this.hasExternalLexicalStorage() && (Source != null)) : "No external storage?";
      
      // Notify that we have a DeclContext that is initializing.
      ADeclContext/*J*/= new ExternalASTSource.Deserializing(Source);
      
      // Load the external declarations, if any.
      SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(64, null);
      $DeclContext$Fields().ExternalLexicalStorage = false;
      Source.FindExternalLexicalDecls(this, Decls);
      if (Decls.empty()) {
        return false;
      }

      // We may have already loaded just the fields of this record, in which case
      // we need to ignore them.
      boolean FieldsAlreadyLoaded = false;
      {
        /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(this);
        if ((RD != null)) {
          FieldsAlreadyLoaded = RD.LoadedFieldsFromExternalStorage;
        }
      }

      // Splice the newly-read declarations into the beginning of the list
      // of declarations.
      // JAVA: unfold tie
      pair<Decl, Decl> $BuildDeclChain = BuildDeclChain(new ArrayRef<Decl /*P*/ >(Decls, true), FieldsAlreadyLoaded);
      Decl /*P*/ ExternalFirst = $BuildDeclChain.first;
      Decl /*P*/ ExternalLast = $BuildDeclChain.second;
//      std.tie(ExternalFirst, ExternalLast).$assign(
//          BuildDeclChain(new ArrayRef<Decl /*P*/ >(Decls, true), FieldsAlreadyLoaded)
//      );
      ExternalLast.NextInContextAndBits.setPointer($DeclContext$Fields().FirstDecl);
      $DeclContext$Fields().FirstDecl = ExternalFirst;
      if (!($DeclContext$Fields().LastDecl != null)) {
        $DeclContext$Fields().LastDecl = ExternalLast;
      }
      return true;
    } finally {
      if (ADeclContext != null) { ADeclContext.$destroy(); }
    }
  }
  

  
  /// @brief Makes a declaration visible within this context, but
  /// suppresses searches for external declarations with the same
  /// name.
  ///
  /// Analogous to makeDeclVisibleInContext, but for the exclusive
  /// use of addDeclInternal().
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::makeDeclVisibleInContextInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1810,
   FQN="clang::DeclContext::makeDeclVisibleInContextInternal", NM="_ZN5clang11DeclContext32makeDeclVisibleInContextInternalEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContext32makeDeclVisibleInContextInternalEPNS_9NamedDeclE")
  //</editor-fold>
  public/*private*/ default/*interface*/ void makeDeclVisibleInContextInternal(NamedDecl /*P*/ D) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /*friend  class DependentDiagnostic*/
  
  //===----------------------------------------------------------------------===//
  // Creation and Destruction of StoredDeclsMaps.                               //
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::CreateStoredDeclsMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1699,
   FQN="clang::DeclContext::CreateStoredDeclsMap", NM="_ZNK5clang11DeclContext20CreateStoredDeclsMapERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang11DeclContext20CreateStoredDeclsMapERNS_10ASTContextE")
  //</editor-fold>
  public/*private*/ default/*interface*/ StoredDeclsMap /*P*/ CreateStoredDeclsMap(final ASTContext /*&*/ C) /*const*/ {
    assert (!($DeclContext$Fields().LookupPtr != null)) : "context already has a decls map";
    assert (this.getPrimaryContext$Const() == this) : "creating decls map on non-primary context";
    
    StoredDeclsMap /*P*/ M;
    boolean Dependent = this.isDependentContext();
    if (Dependent) {
      M = new DependentStoredDeclsMap();
    } else {
      M = new StoredDeclsMap();
    }
    M.Previous.$assign(C.LastSDM);
    C.LastSDM.$assignMove(new PointerIntPair<StoredDeclsMap /*P*/ >(M, (Dependent ? 1 : 0)));
    $DeclContext$Fields().LookupPtr = M;
    return M;
  }


  
  /// buildLookupImpl - Build part of the lookup data structure for the
  /// declarations contained within DCtx, which will either be this
  /// DeclContext, a DeclContext linked to it, or a transparent context
  /// nested within it.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::buildLookupImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1378,
   FQN="clang::DeclContext::buildLookupImpl", NM="_ZN5clang11DeclContext15buildLookupImplEPS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext15buildLookupImplEPS0_b")
  //</editor-fold>
  public/*private*/ default/*interface*/ void buildLookupImpl(DeclContext /*P*/ DCtx, boolean Internal) {
    for (Decl /*P*/ D : DCtx.noload_decls()) {
      {
        // Insert this declaration into the lookup structure, but only if
        // it's semantically within its decl context. Any other decls which
        // should be found in this context are added eagerly.
        //
        // If it's from an AST file, don't add it now. It'll get handled by
        // FindExternalVisibleDeclsByName if needed. Exception: if we're not
        // in C++, we do not track external visible decls for the TU, so in
        // that case we need to collect them all here.
        NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
        if ((ND != null)) {
          if (ND.getDeclContext() == DCtx && !shouldBeHidden(ND)
             && (!ND.isFromASTFile()
             || (this.isTranslationUnit()
             && !this.getParentASTContext().getLangOpts().CPlusPlus))) {
            this.makeDeclVisibleInContextImpl(ND, Internal);
          }
        }
      }
      {

        // If this declaration is itself a transparent declaration context
        // or inline namespace, add the members of this declaration of that
        // context (recursively).
        DeclContext /*P*/ InnerCtx = dyn_cast_DeclContext(D);
        if ((InnerCtx != null)) {
          if (InnerCtx.isTransparentContext() || InnerCtx.isInlineNamespace()) {
            this.buildLookupImpl(InnerCtx, Internal);
          }
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::makeDeclVisibleInContextWithFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1587,
   FQN="clang::DeclContext::makeDeclVisibleInContextWithFlags", NM="_ZN5clang11DeclContext33makeDeclVisibleInContextWithFlagsEPNS_9NamedDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext33makeDeclVisibleInContextWithFlagsEPNS_9NamedDeclEbb")
  //</editor-fold>
  public/*private*/ default/*interface*/ void makeDeclVisibleInContextWithFlags(NamedDecl /*P*/ D, boolean Internal, 
                                   boolean Recoverable) {
    assert (this == this.getPrimaryContext()) : "expected a primary DC";
    if (!this.isLookupContext()) {
      if (this.isTransparentContext()) {
        this.getParent().getPrimaryContext().
            makeDeclVisibleInContextWithFlags(D, Internal, Recoverable);
      }
      return;
    }

    // Skip declarations which should be invisible to name lookup.
    if (shouldBeHidden(D)) {
      return;
    }

    // If we already have a lookup data structure, perform the insertion into
    // it. If we might have externally-stored decls with this name, look them
    // up and perform the insertion. If this decl was declared outside its
    // semantic context, buildLookup won't add it, so add it now.
    //
    // FIXME: As a performance hack, don't add such decls into the translation
    // unit unless we're in C++, since qualified lookup into the TU is never
    // performed.
    if (($DeclContext$Fields().LookupPtr != null) || this.hasExternalVisibleStorage()
       || ((!Recoverable || D.getDeclContext() != D.getLexicalDeclContext())
       && (this.getParentASTContext().getLangOpts().CPlusPlus
       || !this.isTranslationUnit()))) {
      // If we have lazily omitted any decls, they might have the same name as
      // the decl which we are adding, so build a full lookup table before adding
      // this decl.
      this.buildLookup();
      this.makeDeclVisibleInContextImpl(D, Internal);
    } else {
      $DeclContext$Fields().HasLazyLocalLexicalLookups = true;
    }
    
    // If we are a transparent context or inline namespace, insert into our
    // parent context, too. This operation is recursive.
    if (this.isTransparentContext() || this.isInlineNamespace()) {
      this.getParent().getPrimaryContext().
          makeDeclVisibleInContextWithFlags(D, Internal, Recoverable);
    }
    
    Decl /*P*/ DCAsDecl = cast_Decl(this);
    // Notify that a decl was made visible unless we are a Tag being defined.
    if (!(isa_TagDecl(DCAsDecl) && cast_TagDecl(DCAsDecl).isBeingDefined())) {
      {
        ASTMutationListener /*P*/ L = DCAsDecl.getASTMutationListener();
        if ((L != null)) {
          L.AddedVisibleDecl(this, D);
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::makeDeclVisibleInContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1636,
   FQN="clang::DeclContext::makeDeclVisibleInContextImpl", NM="_ZN5clang11DeclContext28makeDeclVisibleInContextImplEPNS_9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang11DeclContext28makeDeclVisibleInContextImplEPNS_9NamedDeclEb")
  //</editor-fold>
  public/*private*/ default/*interface*/ void makeDeclVisibleInContextImpl(NamedDecl /*P*/ D, boolean Internal) {
    // Find or create the stored declaration map.
    StoredDeclsMap /*P*/ Map = $DeclContext$Fields().LookupPtr;
    if (!(Map != null)) {
      ASTContext /*P*/ C = $AddrOf(this.getParentASTContext());
      Map = this.CreateStoredDeclsMap($Deref(C));
    }

    // If there is an external AST source, load any declarations it knows about
    // with this declaration's name.
    // If the lookup table contains an entry about this name it means that we
    // have already checked the external source.
    if (!Internal) {
      {
        ExternalASTSource /*P*/ Source = this.getParentASTContext().getExternalSource();
        if ((Source != null)) {
          if (this.hasExternalVisibleStorage()
             && Map.find(D.getDeclName()).$eq(/*NO_ITER_COPY*/Map.end())) {
            Source.FindExternalVisibleDeclsByName(this, D.getDeclName());
          }
        }
      }
    }
    
    // Insert this declaration into the map.
    final StoredDeclsList /*&*/ DeclNameEntries = (/*Deref*/Map).$at_T1$RR(D.getDeclName());
    if (Internal) {
      // If this is being added as part of loading an external declaration,
      // this may not be the only external declaration with this name.
      // In this case, we never try to replace an existing declaration; we'll
      // handle that when we finalize the list of declarations for this name.
      DeclNameEntries.setHasExternalDecls();
      DeclNameEntries.AddSubsequentDecl(D);
      return;
    }
    if (DeclNameEntries.isNull()) {
      DeclNameEntries.setOnlyValue(D);
      return;
    }
    if (DeclNameEntries.HandleRedeclaration(D, /*IsKnownNewer*/ !Internal)) {
      // This declaration has replaced an existing one for which
      // declarationReplaces returns true.
      return;
    }
    
    // Put this declaration into the appropriate slot.
    DeclNameEntries.AddSubsequentDecl(D);
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static final class DeclContext$Fields {  
  /// DeclKind - This indicates which class this is.
  public/*private*/ /*JBYTE unsigned int*/ byte DeclKind /*: 8*/;
  
  /// \brief Whether this declaration context also has some external
  /// storage that contains additional declarations that are lexically
  /// part of this context.
  public/*private*/ /*mutable *//*JBIT bool*/ boolean ExternalLexicalStorage /*: 1*/;
  
  /// \brief Whether this declaration context also has some external
  /// storage that contains additional declarations that are visible
  /// in this context.
  public/*private*/ /*mutable *//*JBIT bool*/ boolean ExternalVisibleStorage /*: 1*/;
  
  /// \brief Whether this declaration context has had external visible
  /// storage added since the last lookup. In this case, \c LookupPtr's
  /// invariant may not hold and needs to be fixed before we perform
  /// another lookup.
  public/*private*/ /*mutable *//*JBIT bool*/ boolean NeedToReconcileExternalVisibleStorage /*: 1*/;
  
  /// \brief If \c true, this context may have local lexical declarations
  /// that are missing from the lookup table.
  public/*private*/ /*mutable *//*JBIT bool*/ boolean HasLazyLocalLexicalLookups /*: 1*/;
  
  /// \brief If \c true, the external source may have lexical declarations
  /// that are missing from the lookup table.
  public/*private*/ /*mutable *//*JBIT bool*/ boolean HasLazyExternalLexicalLookups /*: 1*/;
  
  /// \brief If \c true, lookups should only return identifier from
  /// DeclContext scope (for example TranslationUnit). Used in
  /// LookupQualifiedName()
  public/*private*/ /*mutable *//*JBIT bool*/ boolean UseQualifiedLookup /*: 1*/;
  
  /// \brief Pointer to the data structure used to lookup declarations
  /// within this context (or a DependentStoredDeclsMap if this is a
  /// dependent context). We maintain the invariant that, if the map
  /// contains an entry for a DeclarationName (and we haven't lazily
  /// omitted anything), then it contains all relevant entries for that
  /// name (modulo the hasExternalDecls() flag).
  public/*private*/ /*mutable */StoredDeclsMap /*P*/ LookupPtr;
  /*protected:*/
  /// FirstDecl - The first declaration stored within this declaration
  /// context.
  public/*protected*/ /*mutable */Decl /*P*/ FirstDecl;
  
  /// LastDecl - The last declaration stored within this declaration
  /// context. FIXME: We could probably cache this value somewhere
  /// outside of the DeclContext, to reduce the size of DeclContext by
  /// another pointer.
  public/*protected*/ /*mutable */Decl /*P*/ LastDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::DeclContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1197,
   FQN="clang::DeclContext::DeclContext", NM="_ZN5clang11DeclContextC1ENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContextC1ENS_4Decl4KindE")
  //</editor-fold>
  protected/*protected*/ DeclContext$Fields(Decl.Kind K) {
    // : DeclKind(K), ExternalLexicalStorage(false), ExternalVisibleStorage(false), NeedToReconcileExternalVisibleStorage(false), HasLazyLocalLexicalLookups(false), HasLazyExternalLexicalLookups(false), UseQualifiedLookup(false), LookupPtr(null), FirstDecl(null), LastDecl(null) 
    //START JInit
    this.DeclKind = $uint2uint_8bits(K.getValue());
    this.ExternalLexicalStorage = false;
    this.ExternalVisibleStorage = false;
    this.NeedToReconcileExternalVisibleStorage = false;
    this.HasLazyLocalLexicalLookups = false;
    this.HasLazyExternalLexicalLookups = false;
    this.UseQualifiedLookup = false;
    this.LookupPtr = null;
    this.FirstDecl = null;
    this.LastDecl = null;
    //END JInit
  }
  public String toString() {
    return "As$DC{" + "DeclKind=" + Decl.Kind.valueOf($uchar2uint(DeclKind)) // NOI18N
            + ", ExternalLexicalStorage=" + ExternalLexicalStorage // NOI18N
            + ", ExternalVisibleStorage=" + ExternalVisibleStorage // NOI18N
            + ", NeedToReconcileExternalVisibleStorage=" + NeedToReconcileExternalVisibleStorage // NOI18N
            + ", HasLazyLocalLexicalLookups=" + HasLazyLocalLexicalLookups // NOI18N
            + ", HasLazyExternalLexicalLookups=" + HasLazyExternalLexicalLookups // NOI18N
            + ", UseQualifiedLookup=" + UseQualifiedLookup // NOI18N
            + ", LookupPtr=" + NativeTrace.getIdentityStr(LookupPtr) // NOI18N
            + ", FirstDecl=" + NativeTrace.getIdentityStr(FirstDecl) // NOI18N
            + ", LastDecl=" + NativeTrace.getIdentityStr(LastDecl) + "}"; // NOI18N
  }  
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*private*/ default DeclContext$Fields $DeclContext$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived? " + this.getClass() + ": Keep what was returned from $DeclContext in your final field and just return it here.");
  }  
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContext::DeclContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1197,
   FQN="clang::DeclContext::DeclContext", NM="_ZN5clang11DeclContextC1ENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang11DeclContextC1ENS_4Decl4KindE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ DeclContext$Fields $DeclContext(Decl.Kind K) {
    // : DeclKind(K), ExternalLexicalStorage(false), ExternalVisibleStorage(false), NeedToReconcileExternalVisibleStorage(false), HasLazyLocalLexicalLookups(false), HasLazyExternalLexicalLookups(false), UseQualifiedLookup(false), LookupPtr(null), FirstDecl(null), LastDecl(null) 
    //START JInit
    return new DeclContext$Fields(K);
    //END JInit
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
