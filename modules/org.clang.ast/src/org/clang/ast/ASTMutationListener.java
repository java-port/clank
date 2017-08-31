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
import org.clang.basic.*;


/// \brief An abstract interface that should be implemented by listeners
/// that want to be notified when an AST entity gets modified after its
/// initial creation.
//<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 44,
 FQN="clang::ASTMutationListener", NM="_ZN5clang19ASTMutationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListenerE")
//</editor-fold>
public interface/*class*/ ASTMutationListener extends Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::~ASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8074,
   FQN="clang::ASTMutationListener::~ASTMutationListener", NM="_ZN5clang19ASTMutationListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListenerD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy() {
  }
  public default/*interface*/ void $destroy$ASTMutationListener() {
  }
  
  
  /// \brief A new TagDecl definition was completed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::CompletedTagDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 49,
   FQN="clang::ASTMutationListener::CompletedTagDefinition", NM="_ZN5clang19ASTMutationListener22CompletedTagDefinitionEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener22CompletedTagDefinitionEPKNS_7TagDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CompletedTagDefinition(/*const*/ TagDecl /*P*/ D) {
  }

  
  /// \brief A new declaration with name has been added to a DeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedVisibleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 52,
   FQN="clang::ASTMutationListener::AddedVisibleDecl", NM="_ZN5clang19ASTMutationListener16AddedVisibleDeclEPKNS_11DeclContextEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener16AddedVisibleDeclEPKNS_11DeclContextEPKNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedVisibleDecl(/*const*/ DeclContext /*P*/ DC, /*const*/ Decl /*P*/ D) {
  }

  
  /// \brief An implicit member was added after the definition was completed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedCXXImplicitMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 55,
   FQN="clang::ASTMutationListener::AddedCXXImplicitMember", NM="_ZN5clang19ASTMutationListener22AddedCXXImplicitMemberEPKNS_13CXXRecordDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener22AddedCXXImplicitMemberEPKNS_13CXXRecordDeclEPKNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedCXXImplicitMember(/*const*/ CXXRecordDecl /*P*/ RD, /*const*/ Decl /*P*/ D) {
  }

  
  /// \brief A template specialization (or partial one) was added to the
  /// template declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedCXXTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 59,
   FQN="clang::ASTMutationListener::AddedCXXTemplateSpecialization", NM="_ZN5clang19ASTMutationListener30AddedCXXTemplateSpecializationEPKNS_17ClassTemplateDeclEPKNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener30AddedCXXTemplateSpecializationEPKNS_17ClassTemplateDeclEPKNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedCXXTemplateSpecialization(/*const*/ ClassTemplateDecl /*P*/ TD, 
                                /*const*/ ClassTemplateSpecializationDecl /*P*/ D) {
  }

  
  /// \brief A template specialization (or partial one) was added to the
  /// template declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedCXXTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 64,
   FQN="clang::ASTMutationListener::AddedCXXTemplateSpecialization", NM="_ZN5clang19ASTMutationListener30AddedCXXTemplateSpecializationEPKNS_15VarTemplateDeclEPKNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener30AddedCXXTemplateSpecializationEPKNS_15VarTemplateDeclEPKNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedCXXTemplateSpecialization(/*const*/ VarTemplateDecl /*P*/ TD, 
                                /*const*/ VarTemplateSpecializationDecl /*P*/ D) {
  }

  
  /// \brief A template specialization (or partial one) was added to the
  /// template declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedCXXTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 70,
   FQN="clang::ASTMutationListener::AddedCXXTemplateSpecialization", NM="_ZN5clang19ASTMutationListener30AddedCXXTemplateSpecializationEPKNS_20FunctionTemplateDeclEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener30AddedCXXTemplateSpecializationEPKNS_20FunctionTemplateDeclEPKNS_12FunctionDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedCXXTemplateSpecialization(/*const*/ FunctionTemplateDecl /*P*/ TD, 
                                /*const*/ FunctionDecl /*P*/ D) {
  }

  
  /// \brief A function's exception specification has been evaluated or
  /// instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::ResolvedExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 75,
   FQN="clang::ASTMutationListener::ResolvedExceptionSpec", NM="_ZN5clang19ASTMutationListener21ResolvedExceptionSpecEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener21ResolvedExceptionSpecEPKNS_12FunctionDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void ResolvedExceptionSpec(/*const*/ FunctionDecl /*P*/ FD) {
  }

  
  /// \brief A function's return type has been deduced.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::DeducedReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8076,
   FQN="clang::ASTMutationListener::DeducedReturnType", NM="_ZN5clang19ASTMutationListener17DeducedReturnTypeEPKNS_12FunctionDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener17DeducedReturnTypeEPKNS_12FunctionDeclENS_8QualTypeE")
  //</editor-fold>
  public default/*interface*/ void DeducedReturnType(/*const*/ FunctionDecl /*P*/ FD, 
                   QualType ReturnType) {
  }

  
  /// \brief A virtual destructor's operator delete has been resolved.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::ResolvedOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 81,
   FQN="clang::ASTMutationListener::ResolvedOperatorDelete", NM="_ZN5clang19ASTMutationListener22ResolvedOperatorDeleteEPKNS_17CXXDestructorDeclEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener22ResolvedOperatorDeleteEPKNS_17CXXDestructorDeclEPKNS_12FunctionDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void ResolvedOperatorDelete(/*const*/ CXXDestructorDecl /*P*/ DD, 
                        /*const*/ FunctionDecl /*P*/ Delete) {
  }

  
  /// \brief An implicit member got a definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::CompletedImplicitDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 85,
   FQN="clang::ASTMutationListener::CompletedImplicitDefinition", NM="_ZN5clang19ASTMutationListener27CompletedImplicitDefinitionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener27CompletedImplicitDefinitionEPKNS_12FunctionDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void CompletedImplicitDefinition(/*const*/ FunctionDecl /*P*/ D) {
  }

  
  /// \brief A static data member was implicitly instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::StaticDataMemberInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 88,
   FQN="clang::ASTMutationListener::StaticDataMemberInstantiated", NM="_ZN5clang19ASTMutationListener28StaticDataMemberInstantiatedEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener28StaticDataMemberInstantiatedEPKNS_7VarDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void StaticDataMemberInstantiated(/*const*/ VarDecl /*P*/ D) {
  }

  
  /// \brief A function template's definition was instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::FunctionDefinitionInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 91,
   FQN="clang::ASTMutationListener::FunctionDefinitionInstantiated", NM="_ZN5clang19ASTMutationListener30FunctionDefinitionInstantiatedEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener30FunctionDefinitionInstantiatedEPKNS_12FunctionDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void FunctionDefinitionInstantiated(/*const*/ FunctionDecl /*P*/ D) {
  }

  
  /// \brief A default argument was instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::DefaultArgumentInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 94,
   FQN="clang::ASTMutationListener::DefaultArgumentInstantiated", NM="_ZN5clang19ASTMutationListener27DefaultArgumentInstantiatedEPKNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener27DefaultArgumentInstantiatedEPKNS_11ParmVarDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void DefaultArgumentInstantiated(/*const*/ ParmVarDecl /*P*/ D) {
  }

  
  /// \brief A new objc category class was added for an interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedObjCCategoryToInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 97,
   FQN="clang::ASTMutationListener::AddedObjCCategoryToInterface", NM="_ZN5clang19ASTMutationListener28AddedObjCCategoryToInterfaceEPKNS_16ObjCCategoryDeclEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener28AddedObjCCategoryToInterfaceEPKNS_16ObjCCategoryDeclEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedObjCCategoryToInterface(/*const*/ ObjCCategoryDecl /*P*/ CatD, 
                              /*const*/ ObjCInterfaceDecl /*P*/ IFD) {
  }

  
  /// \brief A declaration is marked used which was not previously marked used.
  ///
  /// \param D the declaration marked used
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::DeclarationMarkedUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 103,
   FQN="clang::ASTMutationListener::DeclarationMarkedUsed", NM="_ZN5clang19ASTMutationListener21DeclarationMarkedUsedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener21DeclarationMarkedUsedEPKNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void DeclarationMarkedUsed(/*const*/ Decl /*P*/ D) {
  }

  
  /// \brief A declaration is marked as OpenMP threadprivate which was not
  /// previously marked as threadprivate.
  ///
  /// \param D the declaration marked OpenMP threadprivate.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::DeclarationMarkedOpenMPThreadPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 109,
   FQN="clang::ASTMutationListener::DeclarationMarkedOpenMPThreadPrivate", NM="_ZN5clang19ASTMutationListener36DeclarationMarkedOpenMPThreadPrivateEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener36DeclarationMarkedOpenMPThreadPrivateEPKNS_4DeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void DeclarationMarkedOpenMPThreadPrivate(/*const*/ Decl /*P*/ D) {
  }

  
  /// \brief A declaration is marked as OpenMP declaretarget which was not
  /// previously marked as declaretarget.
  ///
  /// \param D the declaration marked OpenMP declaretarget.
  /// \param Attr the added attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::DeclarationMarkedOpenMPDeclareTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 116,
   FQN="clang::ASTMutationListener::DeclarationMarkedOpenMPDeclareTarget", NM="_ZN5clang19ASTMutationListener36DeclarationMarkedOpenMPDeclareTargetEPKNS_4DeclEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener36DeclarationMarkedOpenMPDeclareTargetEPKNS_4DeclEPKNS_4AttrE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void DeclarationMarkedOpenMPDeclareTarget(/*const*/ Decl /*P*/ D, 
                                      /*const*/ Attr /*P*/ Attr) {
  }

  
  /// \brief A definition has been made visible by being redefined locally.
  ///
  /// \param D The definition that was previously not visible.
  /// \param M The containing module in which the definition was made visible,
  ///        if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::RedefinedHiddenDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 124,
   FQN="clang::ASTMutationListener::RedefinedHiddenDefinition", NM="_ZN5clang19ASTMutationListener25RedefinedHiddenDefinitionEPKNS_9NamedDeclEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener25RedefinedHiddenDefinitionEPKNS_9NamedDeclEPNS_6ModuleE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void RedefinedHiddenDefinition(/*const*/ NamedDecl /*P*/ D, Module /*P*/ M) {
  }

  
  /// \brief An attribute was added to a RecordDecl
  ///
  /// \param Attr The attribute that was added to the Record
  ///
  /// \param Record The RecordDecl that got a new attribute
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::AddedAttributeToRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 131,
   FQN="clang::ASTMutationListener::AddedAttributeToRecord", NM="_ZN5clang19ASTMutationListener22AddedAttributeToRecordEPKNS_4AttrEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang19ASTMutationListener22AddedAttributeToRecordEPKNS_4AttrEPKNS_10RecordDeclE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ void AddedAttributeToRecord(/*const*/ Attr /*P*/ Attr, 
                        /*const*/ RecordDecl /*P*/ Record) {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTMutationListener::ASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTMutationListener.h", line = 44,
   FQN="clang::ASTMutationListener::ASTMutationListener", NM="_ZN5clang19ASTMutationListenerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang19ASTMutationListenerC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $ASTMutationListener() {
  }

// NOTE: If new methods are added they should also be added to
// MultiplexASTMutationListener.
}
