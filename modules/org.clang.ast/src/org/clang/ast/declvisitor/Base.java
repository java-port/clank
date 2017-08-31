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

package org.clang.ast.declvisitor;

import org.clank.support.*;
import org.llvm.support.*;
import org.clang.ast.*;


/// \brief A simple visitor class that helps create declaration visitors.
/*template <template <typename > class Ptr, typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclVisitor.h", line = 30,
 FQN="clang::declvisitor::Base", NM="_ZN5clang11declvisitor4BaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4BaseE")
//</editor-fold>
public interface/*class*/ Base</*template <typename > TEMPLATE*/ 
/*class*/Ptr, /*typename*/ ImplClass extends Base<?, ?, RetTy>, /*typename*/ RetTy/* = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::Visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclVisitor.h", line = 38,
   FQN="clang::declvisitor::Base::Visit", NM="_ZN5clang11declvisitor4Base5VisitENT_INS_4DeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base5VisitENT_INS_4DeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy Visit(Decl/*P*/ D) {
    switch (D.getKind()) {
     case AccessSpec:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAccessSpecDecl(((/*static_cast*/AccessSpecDecl/*P*/)(D)));
     case Block:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockDecl(((/*static_cast*/BlockDecl/*P*/)(D)));
     case Captured:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCapturedDecl(((/*static_cast*/CapturedDecl/*P*/)(D)));
     case ClassScopeFunctionSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitClassScopeFunctionSpecializationDecl(((/*static_cast*/ClassScopeFunctionSpecializationDecl/*P*/)(D)));
     case Empty:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEmptyDecl(((/*static_cast*/EmptyDecl/*P*/)(D)));
     case ExternCContext:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExternCContextDecl(((/*static_cast*/ExternCContextDecl/*P*/)(D)));
     case FileScopeAsm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFileScopeAsmDecl(((/*static_cast*/FileScopeAsmDecl/*P*/)(D)));
     case Friend:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFriendDecl(((/*static_cast*/FriendDecl/*P*/)(D)));
     case FriendTemplate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFriendTemplateDecl(((/*static_cast*/FriendTemplateDecl/*P*/)(D)));
     case Import:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitImportDecl(((/*static_cast*/ImportDecl/*P*/)(D)));
     case LinkageSpec:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLinkageSpecDecl(((/*static_cast*/LinkageSpecDecl/*P*/)(D)));
     case Label:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLabelDecl(((/*static_cast*/LabelDecl/*P*/)(D)));
     case Namespace:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamespaceDecl(((/*static_cast*/NamespaceDecl/*P*/)(D)));
     case NamespaceAlias:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamespaceAliasDecl(((/*static_cast*/NamespaceAliasDecl/*P*/)(D)));
     case ObjCCompatibleAlias:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCCompatibleAliasDecl(((/*static_cast*/ObjCCompatibleAliasDecl/*P*/)(D)));
     case ObjCCategory:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCCategoryDecl(((/*static_cast*/ObjCCategoryDecl/*P*/)(D)));
     case ObjCCategoryImpl:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCCategoryImplDecl(((/*static_cast*/ObjCCategoryImplDecl/*P*/)(D)));
     case ObjCImplementation:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCImplementationDecl(((/*static_cast*/ObjCImplementationDecl/*P*/)(D)));
     case ObjCInterface:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCInterfaceDecl(((/*static_cast*/ObjCInterfaceDecl/*P*/)(D)));
     case ObjCProtocol:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCProtocolDecl(((/*static_cast*/ObjCProtocolDecl/*P*/)(D)));
     case ObjCMethod:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCMethodDecl(((/*static_cast*/ObjCMethodDecl/*P*/)(D)));
     case ObjCProperty:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCPropertyDecl(((/*static_cast*/ObjCPropertyDecl/*P*/)(D)));
     case BuiltinTemplate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBuiltinTemplateDecl(((/*static_cast*/BuiltinTemplateDecl/*P*/)(D)));
     case ClassTemplate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitClassTemplateDecl(((/*static_cast*/ClassTemplateDecl/*P*/)(D)));
     case FunctionTemplate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionTemplateDecl(((/*static_cast*/FunctionTemplateDecl/*P*/)(D)));
     case TypeAliasTemplate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeAliasTemplateDecl(((/*static_cast*/TypeAliasTemplateDecl/*P*/)(D)));
     case VarTemplate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarTemplateDecl(((/*static_cast*/VarTemplateDecl/*P*/)(D)));
     case TemplateTemplateParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTemplateParmDecl(((/*static_cast*/TemplateTemplateParmDecl/*P*/)(D)));
     case Enum:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumDecl(((/*static_cast*/EnumDecl/*P*/)(D)));
     case Record:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordDecl(((/*static_cast*/RecordDecl/*P*/)(D)));
     case CXXRecord:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXRecordDecl(((/*static_cast*/CXXRecordDecl/*P*/)(D)));
     case ClassTemplateSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitClassTemplateSpecializationDecl(((/*static_cast*/ClassTemplateSpecializationDecl/*P*/)(D)));
     case ClassTemplatePartialSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitClassTemplatePartialSpecializationDecl(((/*static_cast*/ClassTemplatePartialSpecializationDecl/*P*/)(D)));
     case TemplateTypeParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTypeParmDecl(((/*static_cast*/TemplateTypeParmDecl/*P*/)(D)));
     case ObjCTypeParam:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCTypeParamDecl(((/*static_cast*/ObjCTypeParamDecl/*P*/)(D)));
     case TypeAlias:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeAliasDecl(((/*static_cast*/TypeAliasDecl/*P*/)(D)));
     case Typedef:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefDecl(((/*static_cast*/TypedefDecl/*P*/)(D)));
     case UnresolvedUsingTypename:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingTypenameDecl(((/*static_cast*/UnresolvedUsingTypenameDecl/*P*/)(D)));
     case Using:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUsingDecl(((/*static_cast*/UsingDecl/*P*/)(D)));
     case UsingDirective:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUsingDirectiveDecl(((/*static_cast*/UsingDirectiveDecl/*P*/)(D)));
     case UsingShadow:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUsingShadowDecl(((/*static_cast*/UsingShadowDecl/*P*/)(D)));
     case ConstructorUsingShadow:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConstructorUsingShadowDecl(((/*static_cast*/ConstructorUsingShadowDecl/*P*/)(D)));
     case Field:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFieldDecl(((/*static_cast*/FieldDecl/*P*/)(D)));
     case ObjCAtDefsField:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCAtDefsFieldDecl(((/*static_cast*/ObjCAtDefsFieldDecl/*P*/)(D)));
     case ObjCIvar:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCIvarDecl(((/*static_cast*/ObjCIvarDecl/*P*/)(D)));
     case Function:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionDecl(((/*static_cast*/FunctionDecl/*P*/)(D)));
     case CXXMethod:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXMethodDecl(((/*static_cast*/CXXMethodDecl/*P*/)(D)));
     case CXXConstructor:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXConstructorDecl(((/*static_cast*/CXXConstructorDecl/*P*/)(D)));
     case CXXConversion:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXConversionDecl(((/*static_cast*/CXXConversionDecl/*P*/)(D)));
     case CXXDestructor:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXDestructorDecl(((/*static_cast*/CXXDestructorDecl/*P*/)(D)));
     case MSProperty:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMSPropertyDecl(((/*static_cast*/MSPropertyDecl/*P*/)(D)));
     case NonTypeTemplateParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonTypeTemplateParmDecl(((/*static_cast*/NonTypeTemplateParmDecl/*P*/)(D)));
     case Var:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarDecl(((/*static_cast*/VarDecl/*P*/)(D)));
     case ImplicitParam:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitImplicitParamDecl(((/*static_cast*/ImplicitParamDecl/*P*/)(D)));
     case OMPCapturedExpr:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCapturedExprDecl(((/*static_cast*/OMPCapturedExprDecl/*P*/)(D)));
     case ParmVar:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParmVarDecl(((/*static_cast*/ParmVarDecl/*P*/)(D)));
     case VarTemplateSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarTemplateSpecializationDecl(((/*static_cast*/VarTemplateSpecializationDecl/*P*/)(D)));
     case VarTemplatePartialSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarTemplatePartialSpecializationDecl(((/*static_cast*/VarTemplatePartialSpecializationDecl/*P*/)(D)));
     case EnumConstant:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumConstantDecl(((/*static_cast*/EnumConstantDecl/*P*/)(D)));
     case IndirectField:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIndirectFieldDecl(((/*static_cast*/IndirectFieldDecl/*P*/)(D)));
     case OMPDeclareReduction:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDeclareReductionDecl(((/*static_cast*/OMPDeclareReductionDecl/*P*/)(D)));
     case UnresolvedUsingValue:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingValueDecl(((/*static_cast*/UnresolvedUsingValueDecl/*P*/)(D)));
     case OMPThreadPrivate:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPThreadPrivateDecl(((/*static_cast*/OMPThreadPrivateDecl/*P*/)(D)));
     case ObjCPropertyImpl:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCPropertyImplDecl(((/*static_cast*/ObjCPropertyImplDecl/*P*/)(D)));
     case PragmaComment:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPragmaCommentDecl(((/*static_cast*/PragmaCommentDecl/*P*/)(D)));
     case PragmaDetectMismatch:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPragmaDetectMismatchDecl(((/*static_cast*/PragmaDetectMismatchDecl/*P*/)(D)));
     case StaticAssert:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStaticAssertDecl(((/*static_cast*/StaticAssertDecl/*P*/)(D)));
     case TranslationUnit:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTranslationUnitDecl(((/*static_cast*/TranslationUnitDecl/*P*/)(D)));
    }
    throw new llvm_unreachable("Decl that isn't part of DeclNodes.inc!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitAccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 23,
   FQN="clang::declvisitor::Base::VisitAccessSpecDecl", NM="_ZN5clang11declvisitor4Base19VisitAccessSpecDeclENT_INS_14AccessSpecDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base19VisitAccessSpecDeclENT_INS_14AccessSpecDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAccessSpecDecl(AccessSpecDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 29,
   FQN="clang::declvisitor::Base::VisitBlockDecl", NM="_ZN5clang11declvisitor4Base14VisitBlockDeclENT_INS_9BlockDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitBlockDeclENT_INS_9BlockDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBlockDecl(BlockDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 35,
   FQN="clang::declvisitor::Base::VisitCapturedDecl", NM="_ZN5clang11declvisitor4Base17VisitCapturedDeclENT_INS_12CapturedDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base17VisitCapturedDeclENT_INS_12CapturedDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCapturedDecl(CapturedDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 41,
   FQN="clang::declvisitor::Base::VisitClassScopeFunctionSpecializationDecl", NM="_ZN5clang11declvisitor4Base41VisitClassScopeFunctionSpecializationDeclENT_INS_36ClassScopeFunctionSpecializationDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base41VisitClassScopeFunctionSpecializationDeclENT_INS_36ClassScopeFunctionSpecializationDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitClassScopeFunctionSpecializationDecl(ClassScopeFunctionSpecializationDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitEmptyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 47,
   FQN="clang::declvisitor::Base::VisitEmptyDecl", NM="_ZN5clang11declvisitor4Base14VisitEmptyDeclENT_INS_9EmptyDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitEmptyDeclENT_INS_9EmptyDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitEmptyDecl(EmptyDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitExternCContextDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 53,
   FQN="clang::declvisitor::Base::VisitExternCContextDecl", NM="_ZN5clang11declvisitor4Base23VisitExternCContextDeclENT_INS_18ExternCContextDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base23VisitExternCContextDeclENT_INS_18ExternCContextDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitExternCContextDecl(ExternCContextDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitFileScopeAsmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 59,
   FQN="clang::declvisitor::Base::VisitFileScopeAsmDecl", NM="_ZN5clang11declvisitor4Base21VisitFileScopeAsmDeclENT_INS_16FileScopeAsmDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base21VisitFileScopeAsmDeclENT_INS_16FileScopeAsmDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFileScopeAsmDecl(FileScopeAsmDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 65,
   FQN="clang::declvisitor::Base::VisitFriendDecl", NM="_ZN5clang11declvisitor4Base15VisitFriendDeclENT_INS_10FriendDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base15VisitFriendDeclENT_INS_10FriendDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFriendDecl(FriendDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitFriendTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 71,
   FQN="clang::declvisitor::Base::VisitFriendTemplateDecl", NM="_ZN5clang11declvisitor4Base23VisitFriendTemplateDeclENT_INS_18FriendTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base23VisitFriendTemplateDeclENT_INS_18FriendTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFriendTemplateDecl(FriendTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 77,
   FQN="clang::declvisitor::Base::VisitImportDecl", NM="_ZN5clang11declvisitor4Base15VisitImportDeclENT_INS_10ImportDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base15VisitImportDeclENT_INS_10ImportDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitImportDecl(ImportDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitLinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 83,
   FQN="clang::declvisitor::Base::VisitLinkageSpecDecl", NM="_ZN5clang11declvisitor4Base20VisitLinkageSpecDeclENT_INS_15LinkageSpecDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base20VisitLinkageSpecDeclENT_INS_15LinkageSpecDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLinkageSpecDecl(LinkageSpecDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitNamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 89,
   FQN="clang::declvisitor::Base::VisitNamedDecl", NM="_ZN5clang11declvisitor4Base14VisitNamedDeclENT_INS_9NamedDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitNamedDeclENT_INS_9NamedDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNamedDecl(NamedDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitLabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 93,
   FQN="clang::declvisitor::Base::VisitLabelDecl", NM="_ZN5clang11declvisitor4Base14VisitLabelDeclENT_INS_9LabelDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitLabelDeclENT_INS_9LabelDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLabelDecl(LabelDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 99,
   FQN="clang::declvisitor::Base::VisitNamespaceDecl", NM="_ZN5clang11declvisitor4Base18VisitNamespaceDeclENT_INS_13NamespaceDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base18VisitNamespaceDeclENT_INS_13NamespaceDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNamespaceDecl(NamespaceDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitNamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 105,
   FQN="clang::declvisitor::Base::VisitNamespaceAliasDecl", NM="_ZN5clang11declvisitor4Base23VisitNamespaceAliasDeclENT_INS_18NamespaceAliasDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base23VisitNamespaceAliasDeclENT_INS_18NamespaceAliasDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNamespaceAliasDecl(NamespaceAliasDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 111,
   FQN="clang::declvisitor::Base::VisitObjCCompatibleAliasDecl", NM="_ZN5clang11declvisitor4Base28VisitObjCCompatibleAliasDeclENT_INS_23ObjCCompatibleAliasDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base28VisitObjCCompatibleAliasDeclENT_INS_23ObjCCompatibleAliasDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCCompatibleAliasDecl(ObjCCompatibleAliasDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCContainerDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 117,
   FQN="clang::declvisitor::Base::VisitObjCContainerDecl", NM="_ZN5clang11declvisitor4Base22VisitObjCContainerDeclENT_INS_17ObjCContainerDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitObjCContainerDeclENT_INS_17ObjCContainerDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCContainerDecl(ObjCContainerDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 121,
   FQN="clang::declvisitor::Base::VisitObjCCategoryDecl", NM="_ZN5clang11declvisitor4Base21VisitObjCCategoryDeclENT_INS_16ObjCCategoryDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base21VisitObjCCategoryDeclENT_INS_16ObjCCategoryDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCCategoryDecl(ObjCCategoryDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCContainerDecl(((/*static_cast*/ObjCContainerDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 127,
   FQN="clang::declvisitor::Base::VisitObjCImplDecl", NM="_ZN5clang11declvisitor4Base17VisitObjCImplDeclENT_INS_12ObjCImplDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base17VisitObjCImplDeclENT_INS_12ObjCImplDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCImplDecl(ObjCImplDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCContainerDecl(((/*static_cast*/ObjCContainerDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 131,
   FQN="clang::declvisitor::Base::VisitObjCCategoryImplDecl", NM="_ZN5clang11declvisitor4Base25VisitObjCCategoryImplDeclENT_INS_20ObjCCategoryImplDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base25VisitObjCCategoryImplDeclENT_INS_20ObjCCategoryImplDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCCategoryImplDecl(ObjCCategoryImplDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCImplDecl(((/*static_cast*/ObjCImplDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 137,
   FQN="clang::declvisitor::Base::VisitObjCImplementationDecl", NM="_ZN5clang11declvisitor4Base27VisitObjCImplementationDeclENT_INS_22ObjCImplementationDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base27VisitObjCImplementationDeclENT_INS_22ObjCImplementationDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCImplementationDecl(ObjCImplementationDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCImplDecl(((/*static_cast*/ObjCImplDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 147,
   FQN="clang::declvisitor::Base::VisitObjCInterfaceDecl", NM="_ZN5clang11declvisitor4Base22VisitObjCInterfaceDeclENT_INS_17ObjCInterfaceDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitObjCInterfaceDeclENT_INS_17ObjCInterfaceDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCInterfaceDecl(ObjCInterfaceDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCContainerDecl(((/*static_cast*/ObjCContainerDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 153,
   FQN="clang::declvisitor::Base::VisitObjCProtocolDecl", NM="_ZN5clang11declvisitor4Base21VisitObjCProtocolDeclENT_INS_16ObjCProtocolDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base21VisitObjCProtocolDeclENT_INS_16ObjCProtocolDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCProtocolDecl(ObjCProtocolDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCContainerDecl(((/*static_cast*/ObjCContainerDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 163,
   FQN="clang::declvisitor::Base::VisitObjCMethodDecl", NM="_ZN5clang11declvisitor4Base19VisitObjCMethodDeclENT_INS_14ObjCMethodDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base19VisitObjCMethodDeclENT_INS_14ObjCMethodDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCMethodDecl(ObjCMethodDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 169,
   FQN="clang::declvisitor::Base::VisitObjCPropertyDecl", NM="_ZN5clang11declvisitor4Base21VisitObjCPropertyDeclENT_INS_16ObjCPropertyDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base21VisitObjCPropertyDeclENT_INS_16ObjCPropertyDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCPropertyDecl(ObjCPropertyDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 175,
   FQN="clang::declvisitor::Base::VisitTemplateDecl", NM="_ZN5clang11declvisitor4Base17VisitTemplateDeclENT_INS_12TemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base17VisitTemplateDeclENT_INS_12TemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTemplateDecl(TemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitBuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 179,
   FQN="clang::declvisitor::Base::VisitBuiltinTemplateDecl", NM="_ZN5clang11declvisitor4Base24VisitBuiltinTemplateDeclENT_INS_19BuiltinTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base24VisitBuiltinTemplateDeclENT_INS_19BuiltinTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBuiltinTemplateDecl(BuiltinTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateDecl(((/*static_cast*/TemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitRedeclarableTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 185,
   FQN="clang::declvisitor::Base::VisitRedeclarableTemplateDecl", NM="_ZN5clang11declvisitor4Base29VisitRedeclarableTemplateDeclENT_INS_24RedeclarableTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base29VisitRedeclarableTemplateDeclENT_INS_24RedeclarableTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitRedeclarableTemplateDecl(RedeclarableTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateDecl(((/*static_cast*/TemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 189,
   FQN="clang::declvisitor::Base::VisitClassTemplateDecl", NM="_ZN5clang11declvisitor4Base22VisitClassTemplateDeclENT_INS_17ClassTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitClassTemplateDeclENT_INS_17ClassTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitClassTemplateDecl(ClassTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRedeclarableTemplateDecl(((/*static_cast*/RedeclarableTemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 195,
   FQN="clang::declvisitor::Base::VisitFunctionTemplateDecl", NM="_ZN5clang11declvisitor4Base25VisitFunctionTemplateDeclENT_INS_20FunctionTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base25VisitFunctionTemplateDeclENT_INS_20FunctionTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFunctionTemplateDecl(FunctionTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRedeclarableTemplateDecl(((/*static_cast*/RedeclarableTemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 201,
   FQN="clang::declvisitor::Base::VisitTypeAliasTemplateDecl", NM="_ZN5clang11declvisitor4Base26VisitTypeAliasTemplateDeclENT_INS_21TypeAliasTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base26VisitTypeAliasTemplateDeclENT_INS_21TypeAliasTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypeAliasTemplateDecl(TypeAliasTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRedeclarableTemplateDecl(((/*static_cast*/RedeclarableTemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitVarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 207,
   FQN="clang::declvisitor::Base::VisitVarTemplateDecl", NM="_ZN5clang11declvisitor4Base20VisitVarTemplateDeclENT_INS_15VarTemplateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base20VisitVarTemplateDeclENT_INS_15VarTemplateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitVarTemplateDecl(VarTemplateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRedeclarableTemplateDecl(((/*static_cast*/RedeclarableTemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 217,
   FQN="clang::declvisitor::Base::VisitTemplateTemplateParmDecl", NM="_ZN5clang11declvisitor4Base29VisitTemplateTemplateParmDeclENT_INS_24TemplateTemplateParmDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base29VisitTemplateTemplateParmDeclENT_INS_24TemplateTemplateParmDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTemplateTemplateParmDecl(TemplateTemplateParmDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateDecl(((/*static_cast*/TemplateDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTypeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 227,
   FQN="clang::declvisitor::Base::VisitTypeDecl", NM="_ZN5clang11declvisitor4Base13VisitTypeDeclENT_INS_8TypeDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base13VisitTypeDeclENT_INS_8TypeDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypeDecl(TypeDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 231,
   FQN="clang::declvisitor::Base::VisitTagDecl", NM="_ZN5clang11declvisitor4Base12VisitTagDeclENT_INS_7TagDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base12VisitTagDeclENT_INS_7TagDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTagDecl(TagDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeDecl(((/*static_cast*/TypeDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitEnumDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 235,
   FQN="clang::declvisitor::Base::VisitEnumDecl", NM="_ZN5clang11declvisitor4Base13VisitEnumDeclENT_INS_8EnumDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base13VisitEnumDeclENT_INS_8EnumDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitEnumDecl(EnumDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagDecl(((/*static_cast*/TagDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 241,
   FQN="clang::declvisitor::Base::VisitRecordDecl", NM="_ZN5clang11declvisitor4Base15VisitRecordDeclENT_INS_10RecordDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base15VisitRecordDeclENT_INS_10RecordDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitRecordDecl(RecordDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagDecl(((/*static_cast*/TagDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 245,
   FQN="clang::declvisitor::Base::VisitCXXRecordDecl", NM="_ZN5clang11declvisitor4Base18VisitCXXRecordDeclENT_INS_13CXXRecordDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base18VisitCXXRecordDeclENT_INS_13CXXRecordDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXRecordDecl(CXXRecordDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordDecl(((/*static_cast*/RecordDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 249,
   FQN="clang::declvisitor::Base::VisitClassTemplateSpecializationDecl", NM="_ZN5clang11declvisitor4Base36VisitClassTemplateSpecializationDeclENT_INS_31ClassTemplateSpecializationDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base36VisitClassTemplateSpecializationDeclENT_INS_31ClassTemplateSpecializationDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitClassTemplateSpecializationDecl(ClassTemplateSpecializationDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXRecordDecl(((/*static_cast*/CXXRecordDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 253,
   FQN="clang::declvisitor::Base::VisitClassTemplatePartialSpecializationDecl", NM="_ZN5clang11declvisitor4Base43VisitClassTemplatePartialSpecializationDeclENT_INS_38ClassTemplatePartialSpecializationDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base43VisitClassTemplatePartialSpecializationDeclENT_INS_38ClassTemplatePartialSpecializationDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitClassTemplatePartialSpecializationDecl(ClassTemplatePartialSpecializationDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitClassTemplateSpecializationDecl(((/*static_cast*/ClassTemplateSpecializationDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 275,
   FQN="clang::declvisitor::Base::VisitTemplateTypeParmDecl", NM="_ZN5clang11declvisitor4Base25VisitTemplateTypeParmDeclENT_INS_20TemplateTypeParmDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base25VisitTemplateTypeParmDeclENT_INS_20TemplateTypeParmDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTemplateTypeParmDecl(TemplateTypeParmDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeDecl(((/*static_cast*/TypeDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 281,
   FQN="clang::declvisitor::Base::VisitTypedefNameDecl", NM="_ZN5clang11declvisitor4Base20VisitTypedefNameDeclENT_INS_15TypedefNameDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base20VisitTypedefNameDeclENT_INS_15TypedefNameDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypedefNameDecl(TypedefNameDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeDecl(((/*static_cast*/TypeDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 285,
   FQN="clang::declvisitor::Base::VisitObjCTypeParamDecl", NM="_ZN5clang11declvisitor4Base22VisitObjCTypeParamDeclENT_INS_17ObjCTypeParamDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitObjCTypeParamDeclENT_INS_17ObjCTypeParamDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCTypeParamDecl(ObjCTypeParamDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefNameDecl(((/*static_cast*/TypedefNameDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 291,
   FQN="clang::declvisitor::Base::VisitTypeAliasDecl", NM="_ZN5clang11declvisitor4Base18VisitTypeAliasDeclENT_INS_13TypeAliasDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base18VisitTypeAliasDeclENT_INS_13TypeAliasDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypeAliasDecl(TypeAliasDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefNameDecl(((/*static_cast*/TypedefNameDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 297,
   FQN="clang::declvisitor::Base::VisitTypedefDecl", NM="_ZN5clang11declvisitor4Base16VisitTypedefDeclENT_INS_11TypedefDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base16VisitTypedefDeclENT_INS_11TypedefDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypedefDecl(TypedefDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefNameDecl(((/*static_cast*/TypedefNameDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitUnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 307,
   FQN="clang::declvisitor::Base::VisitUnresolvedUsingTypenameDecl", NM="_ZN5clang11declvisitor4Base32VisitUnresolvedUsingTypenameDeclENT_INS_27UnresolvedUsingTypenameDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base32VisitUnresolvedUsingTypenameDeclENT_INS_27UnresolvedUsingTypenameDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnresolvedUsingTypenameDecl(UnresolvedUsingTypenameDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeDecl(((/*static_cast*/TypeDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 317,
   FQN="clang::declvisitor::Base::VisitUsingDecl", NM="_ZN5clang11declvisitor4Base14VisitUsingDeclENT_INS_9UsingDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitUsingDeclENT_INS_9UsingDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUsingDecl(UsingDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitUsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 323,
   FQN="clang::declvisitor::Base::VisitUsingDirectiveDecl", NM="_ZN5clang11declvisitor4Base23VisitUsingDirectiveDeclENT_INS_18UsingDirectiveDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base23VisitUsingDirectiveDeclENT_INS_18UsingDirectiveDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUsingDirectiveDecl(UsingDirectiveDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 329,
   FQN="clang::declvisitor::Base::VisitUsingShadowDecl", NM="_ZN5clang11declvisitor4Base20VisitUsingShadowDeclENT_INS_15UsingShadowDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base20VisitUsingShadowDeclENT_INS_15UsingShadowDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUsingShadowDecl(UsingShadowDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 333,
   FQN="clang::declvisitor::Base::VisitConstructorUsingShadowDecl", NM="_ZN5clang11declvisitor4Base31VisitConstructorUsingShadowDeclENT_INS_26ConstructorUsingShadowDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base31VisitConstructorUsingShadowDeclENT_INS_26ConstructorUsingShadowDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitConstructorUsingShadowDecl(ConstructorUsingShadowDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUsingShadowDecl(((/*static_cast*/UsingShadowDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 343,
   FQN="clang::declvisitor::Base::VisitValueDecl", NM="_ZN5clang11declvisitor4Base14VisitValueDeclENT_INS_9ValueDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitValueDeclENT_INS_9ValueDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitValueDecl(ValueDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNamedDecl(((/*static_cast*/NamedDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitDeclaratorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 347,
   FQN="clang::declvisitor::Base::VisitDeclaratorDecl", NM="_ZN5clang11declvisitor4Base19VisitDeclaratorDeclENT_INS_14DeclaratorDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base19VisitDeclaratorDeclENT_INS_14DeclaratorDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDeclaratorDecl(DeclaratorDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitValueDecl(((/*static_cast*/ValueDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 351,
   FQN="clang::declvisitor::Base::VisitFieldDecl", NM="_ZN5clang11declvisitor4Base14VisitFieldDeclENT_INS_9FieldDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base14VisitFieldDeclENT_INS_9FieldDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFieldDecl(FieldDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclaratorDecl(((/*static_cast*/DeclaratorDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCAtDefsFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 355,
   FQN="clang::declvisitor::Base::VisitObjCAtDefsFieldDecl", NM="_ZN5clang11declvisitor4Base24VisitObjCAtDefsFieldDeclENT_INS_19ObjCAtDefsFieldDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base24VisitObjCAtDefsFieldDeclENT_INS_19ObjCAtDefsFieldDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCAtDefsFieldDecl(ObjCAtDefsFieldDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFieldDecl(((/*static_cast*/FieldDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 361,
   FQN="clang::declvisitor::Base::VisitObjCIvarDecl", NM="_ZN5clang11declvisitor4Base17VisitObjCIvarDeclENT_INS_12ObjCIvarDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base17VisitObjCIvarDeclENT_INS_12ObjCIvarDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCIvarDecl(ObjCIvarDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFieldDecl(((/*static_cast*/FieldDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 371,
   FQN="clang::declvisitor::Base::VisitFunctionDecl", NM="_ZN5clang11declvisitor4Base17VisitFunctionDeclENT_INS_12FunctionDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base17VisitFunctionDeclENT_INS_12FunctionDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFunctionDecl(FunctionDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclaratorDecl(((/*static_cast*/DeclaratorDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitCXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 375,
   FQN="clang::declvisitor::Base::VisitCXXMethodDecl", NM="_ZN5clang11declvisitor4Base18VisitCXXMethodDeclENT_INS_13CXXMethodDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base18VisitCXXMethodDeclENT_INS_13CXXMethodDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXMethodDecl(CXXMethodDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionDecl(((/*static_cast*/FunctionDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitCXXConstructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 379,
   FQN="clang::declvisitor::Base::VisitCXXConstructorDecl", NM="_ZN5clang11declvisitor4Base23VisitCXXConstructorDeclENT_INS_18CXXConstructorDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base23VisitCXXConstructorDeclENT_INS_18CXXConstructorDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXConstructorDecl(CXXConstructorDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXMethodDecl(((/*static_cast*/CXXMethodDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitCXXConversionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 385,
   FQN="clang::declvisitor::Base::VisitCXXConversionDecl", NM="_ZN5clang11declvisitor4Base22VisitCXXConversionDeclENT_INS_17CXXConversionDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitCXXConversionDeclENT_INS_17CXXConversionDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXConversionDecl(CXXConversionDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXMethodDecl(((/*static_cast*/CXXMethodDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitCXXDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 391,
   FQN="clang::declvisitor::Base::VisitCXXDestructorDecl", NM="_ZN5clang11declvisitor4Base22VisitCXXDestructorDeclENT_INS_17CXXDestructorDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitCXXDestructorDeclENT_INS_17CXXDestructorDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXDestructorDecl(CXXDestructorDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXMethodDecl(((/*static_cast*/CXXMethodDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitMSPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 405,
   FQN="clang::declvisitor::Base::VisitMSPropertyDecl", NM="_ZN5clang11declvisitor4Base19VisitMSPropertyDeclENT_INS_14MSPropertyDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base19VisitMSPropertyDeclENT_INS_14MSPropertyDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMSPropertyDecl(MSPropertyDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclaratorDecl(((/*static_cast*/DeclaratorDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitNonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 411,
   FQN="clang::declvisitor::Base::VisitNonTypeTemplateParmDecl", NM="_ZN5clang11declvisitor4Base28VisitNonTypeTemplateParmDeclENT_INS_23NonTypeTemplateParmDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base28VisitNonTypeTemplateParmDeclENT_INS_23NonTypeTemplateParmDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonTypeTemplateParmDecl(NonTypeTemplateParmDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclaratorDecl(((/*static_cast*/DeclaratorDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 417,
   FQN="clang::declvisitor::Base::VisitVarDecl", NM="_ZN5clang11declvisitor4Base12VisitVarDeclENT_INS_7VarDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base12VisitVarDeclENT_INS_7VarDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitVarDecl(VarDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclaratorDecl(((/*static_cast*/DeclaratorDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitImplicitParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 421,
   FQN="clang::declvisitor::Base::VisitImplicitParamDecl", NM="_ZN5clang11declvisitor4Base22VisitImplicitParamDeclENT_INS_17ImplicitParamDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitImplicitParamDeclENT_INS_17ImplicitParamDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitImplicitParamDecl(ImplicitParamDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarDecl(((/*static_cast*/VarDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitOMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 427,
   FQN="clang::declvisitor::Base::VisitOMPCapturedExprDecl", NM="_ZN5clang11declvisitor4Base24VisitOMPCapturedExprDeclENT_INS_19OMPCapturedExprDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base24VisitOMPCapturedExprDeclENT_INS_19OMPCapturedExprDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPCapturedExprDecl(OMPCapturedExprDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarDecl(((/*static_cast*/VarDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 433,
   FQN="clang::declvisitor::Base::VisitParmVarDecl", NM="_ZN5clang11declvisitor4Base16VisitParmVarDeclENT_INS_11ParmVarDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base16VisitParmVarDeclENT_INS_11ParmVarDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitParmVarDecl(ParmVarDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarDecl(((/*static_cast*/VarDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 439,
   FQN="clang::declvisitor::Base::VisitVarTemplateSpecializationDecl", NM="_ZN5clang11declvisitor4Base34VisitVarTemplateSpecializationDeclENT_INS_29VarTemplateSpecializationDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base34VisitVarTemplateSpecializationDeclENT_INS_29VarTemplateSpecializationDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitVarTemplateSpecializationDecl(VarTemplateSpecializationDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarDecl(((/*static_cast*/VarDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitVarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 443,
   FQN="clang::declvisitor::Base::VisitVarTemplatePartialSpecializationDecl", NM="_ZN5clang11declvisitor4Base41VisitVarTemplatePartialSpecializationDeclENT_INS_36VarTemplatePartialSpecializationDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base41VisitVarTemplatePartialSpecializationDeclENT_INS_36VarTemplatePartialSpecializationDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitVarTemplatePartialSpecializationDecl(VarTemplatePartialSpecializationDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarTemplateSpecializationDecl(((/*static_cast*/VarTemplateSpecializationDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 461,
   FQN="clang::declvisitor::Base::VisitEnumConstantDecl", NM="_ZN5clang11declvisitor4Base21VisitEnumConstantDeclENT_INS_16EnumConstantDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base21VisitEnumConstantDeclENT_INS_16EnumConstantDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitEnumConstantDecl(EnumConstantDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitValueDecl(((/*static_cast*/ValueDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitIndirectFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 467,
   FQN="clang::declvisitor::Base::VisitIndirectFieldDecl", NM="_ZN5clang11declvisitor4Base22VisitIndirectFieldDeclENT_INS_17IndirectFieldDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitIndirectFieldDeclENT_INS_17IndirectFieldDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitIndirectFieldDecl(IndirectFieldDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitValueDecl(((/*static_cast*/ValueDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitOMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 473,
   FQN="clang::declvisitor::Base::VisitOMPDeclareReductionDecl", NM="_ZN5clang11declvisitor4Base28VisitOMPDeclareReductionDeclENT_INS_23OMPDeclareReductionDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base28VisitOMPDeclareReductionDeclENT_INS_23OMPDeclareReductionDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPDeclareReductionDecl(OMPDeclareReductionDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitValueDecl(((/*static_cast*/ValueDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitUnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 479,
   FQN="clang::declvisitor::Base::VisitUnresolvedUsingValueDecl", NM="_ZN5clang11declvisitor4Base29VisitUnresolvedUsingValueDeclENT_INS_24UnresolvedUsingValueDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base29VisitUnresolvedUsingValueDeclENT_INS_24UnresolvedUsingValueDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnresolvedUsingValueDecl(UnresolvedUsingValueDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitValueDecl(((/*static_cast*/ValueDecl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitOMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 493,
   FQN="clang::declvisitor::Base::VisitOMPThreadPrivateDecl", NM="_ZN5clang11declvisitor4Base25VisitOMPThreadPrivateDeclENT_INS_20OMPThreadPrivateDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base25VisitOMPThreadPrivateDeclENT_INS_20OMPThreadPrivateDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitOMPThreadPrivateDecl(OMPThreadPrivateDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 499,
   FQN="clang::declvisitor::Base::VisitObjCPropertyImplDecl", NM="_ZN5clang11declvisitor4Base25VisitObjCPropertyImplDeclENT_INS_20ObjCPropertyImplDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base25VisitObjCPropertyImplDeclENT_INS_20ObjCPropertyImplDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCPropertyImplDecl(ObjCPropertyImplDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitPragmaCommentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 505,
   FQN="clang::declvisitor::Base::VisitPragmaCommentDecl", NM="_ZN5clang11declvisitor4Base22VisitPragmaCommentDeclENT_INS_17PragmaCommentDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base22VisitPragmaCommentDeclENT_INS_17PragmaCommentDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitPragmaCommentDecl(PragmaCommentDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitPragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 511,
   FQN="clang::declvisitor::Base::VisitPragmaDetectMismatchDecl", NM="_ZN5clang11declvisitor4Base29VisitPragmaDetectMismatchDeclENT_INS_24PragmaDetectMismatchDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base29VisitPragmaDetectMismatchDeclENT_INS_24PragmaDetectMismatchDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitPragmaDetectMismatchDecl(PragmaDetectMismatchDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitStaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 517,
   FQN="clang::declvisitor::Base::VisitStaticAssertDecl", NM="_ZN5clang11declvisitor4Base21VisitStaticAssertDeclENT_INS_16StaticAssertDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base21VisitStaticAssertDeclENT_INS_16StaticAssertDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStaticAssertDecl(StaticAssertDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/DeclNodes.inc", line = 523,
   FQN="clang::declvisitor::Base::VisitTranslationUnitDecl", NM="_ZN5clang11declvisitor4Base24VisitTranslationUnitDeclENT_INS_19TranslationUnitDeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base24VisitTranslationUnitDeclENT_INS_19TranslationUnitDeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTranslationUnitDecl(TranslationUnitDecl/*P*/ D) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecl(((/*static_cast*/Decl/*P*/)(D)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::declvisitor::Base::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclVisitor.h", line = 54,
   FQN="clang::declvisitor::Base::VisitDecl", NM="_ZN5clang11declvisitor4Base9VisitDeclENT_INS_4DeclEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZN5clang11declvisitor4Base9VisitDeclENT_INS_4DeclEE4typeE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDecl(Decl/*P*/ D) {
    return $Base$RetTy();
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default RetTy $Base$RetTy() {
    throw new UnsupportedOperationException("Why not overridden new RetTy()?");
  }  
  
  public default void $destroy$Base() {
  }
  
}
