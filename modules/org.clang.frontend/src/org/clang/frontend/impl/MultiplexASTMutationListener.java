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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


// This ASTMutationListener forwards its notifications to a set of
// child listeners.
//<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 103,
 FQN="clang::MultiplexASTMutationListener", NM="_ZN5clang28MultiplexASTMutationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListenerE")
//</editor-fold>
public class MultiplexASTMutationListener implements /*public*/ ASTMutationListener, Destructors.ClassWithDestructor {
/*public:*/
  // Does NOT take ownership of the elements in L.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::MultiplexASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 136,
   FQN="clang::MultiplexASTMutationListener::MultiplexASTMutationListener", NM="_ZN5clang28MultiplexASTMutationListenerC1EN4llvm8ArrayRefIPNS_19ASTMutationListenerEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListenerC1EN4llvm8ArrayRefIPNS_19ASTMutationListenerEEE")
  //</editor-fold>
  public MultiplexASTMutationListener(ArrayRef<ASTMutationListener /*P*/ > L) {
    // : ASTMutationListener(), Listeners(L.begin(), L.end()) 
    //START JInit
    $ASTMutationListener();
    this.Listeners = new std.vector<ASTMutationListener /*P*/ >(L.begin(), L.end(), (ASTMutationListener /*P*/ )null);
    //END JInit
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public MultiplexASTMutationListener(vector<ASTMutationListener /*P*/ > L) {
    this(new ArrayRef<>(L));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::CompletedTagDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 143,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 141,
   FQN="clang::MultiplexASTMutationListener::CompletedTagDefinition", NM="_ZN5clang28MultiplexASTMutationListener22CompletedTagDefinitionEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener22CompletedTagDefinitionEPKNS_7TagDeclE")
  //</editor-fold>
  @Override public void CompletedTagDefinition(/*const*/ TagDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).CompletedTagDefinition(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedVisibleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 148,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 146,
   FQN="clang::MultiplexASTMutationListener::AddedVisibleDecl", NM="_ZN5clang28MultiplexASTMutationListener16AddedVisibleDeclEPKNS_11DeclContextEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener16AddedVisibleDeclEPKNS_11DeclContextEPKNS_4DeclE")
  //</editor-fold>
  @Override public void AddedVisibleDecl(/*const*/ DeclContext /*P*/ DC, /*const*/ Decl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).AddedVisibleDecl(DC, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedCXXImplicitMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 154,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 152,
   FQN="clang::MultiplexASTMutationListener::AddedCXXImplicitMember", NM="_ZN5clang28MultiplexASTMutationListener22AddedCXXImplicitMemberEPKNS_13CXXRecordDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener22AddedCXXImplicitMemberEPKNS_13CXXRecordDeclEPKNS_4DeclE")
  //</editor-fold>
  @Override public void AddedCXXImplicitMember(/*const*/ CXXRecordDecl /*P*/ RD, /*const*/ Decl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).AddedCXXImplicitMember(RD, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedCXXTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 157,
   FQN="clang::MultiplexASTMutationListener::AddedCXXTemplateSpecialization", NM="_ZN5clang28MultiplexASTMutationListener30AddedCXXTemplateSpecializationEPKNS_17ClassTemplateDeclEPKNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener30AddedCXXTemplateSpecializationEPKNS_17ClassTemplateDeclEPKNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  @Override public void AddedCXXTemplateSpecialization(/*const*/ ClassTemplateDecl /*P*/ TD, /*const*/ ClassTemplateSpecializationDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).AddedCXXTemplateSpecialization(TD, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedCXXTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 162,
   FQN="clang::MultiplexASTMutationListener::AddedCXXTemplateSpecialization", NM="_ZN5clang28MultiplexASTMutationListener30AddedCXXTemplateSpecializationEPKNS_15VarTemplateDeclEPKNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener30AddedCXXTemplateSpecializationEPKNS_15VarTemplateDeclEPKNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  @Override public void AddedCXXTemplateSpecialization(/*const*/ VarTemplateDecl /*P*/ TD, /*const*/ VarTemplateSpecializationDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).AddedCXXTemplateSpecialization(TD, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedCXXTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 169,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 167,
   FQN="clang::MultiplexASTMutationListener::AddedCXXTemplateSpecialization", NM="_ZN5clang28MultiplexASTMutationListener30AddedCXXTemplateSpecializationEPKNS_20FunctionTemplateDeclEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener30AddedCXXTemplateSpecializationEPKNS_20FunctionTemplateDeclEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void AddedCXXTemplateSpecialization(/*const*/ FunctionTemplateDecl /*P*/ TD, /*const*/ FunctionDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).AddedCXXTemplateSpecialization(TD, D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::ResolvedExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 174,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 172,
   FQN="clang::MultiplexASTMutationListener::ResolvedExceptionSpec", NM="_ZN5clang28MultiplexASTMutationListener21ResolvedExceptionSpecEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener21ResolvedExceptionSpecEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void ResolvedExceptionSpec(/*const*/ FunctionDecl /*P*/ FD)/* override*/ {
    for (ASTMutationListener /*P*/ /*&*/ Listener : Listeners)  {
      Listener.ResolvedExceptionSpec(FD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::DeducedReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 177,
   FQN="clang::MultiplexASTMutationListener::DeducedReturnType", NM="_ZN5clang28MultiplexASTMutationListener17DeducedReturnTypeEPKNS_12FunctionDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener17DeducedReturnTypeEPKNS_12FunctionDeclENS_8QualTypeE")
  //</editor-fold>
  @Override public void DeducedReturnType(/*const*/ FunctionDecl /*P*/ FD, 
                   QualType ReturnType)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).DeducedReturnType(FD, new QualType(ReturnType));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::ResolvedOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 182,
   FQN="clang::MultiplexASTMutationListener::ResolvedOperatorDelete", NM="_ZN5clang28MultiplexASTMutationListener22ResolvedOperatorDeleteEPKNS_17CXXDestructorDeclEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener22ResolvedOperatorDeleteEPKNS_17CXXDestructorDeclEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void ResolvedOperatorDelete(/*const*/ CXXDestructorDecl /*P*/ DD, /*const*/ FunctionDecl /*P*/ Delete)/* override*/ {
    for (ASTMutationListener /*P*/ L : Listeners)  {
      L.ResolvedOperatorDelete(DD, Delete);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::CompletedImplicitDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 189,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 187,
   FQN="clang::MultiplexASTMutationListener::CompletedImplicitDefinition", NM="_ZN5clang28MultiplexASTMutationListener27CompletedImplicitDefinitionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener27CompletedImplicitDefinitionEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void CompletedImplicitDefinition(/*const*/ FunctionDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).CompletedImplicitDefinition(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::StaticDataMemberInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 194,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 192,
   FQN="clang::MultiplexASTMutationListener::StaticDataMemberInstantiated", NM="_ZN5clang28MultiplexASTMutationListener28StaticDataMemberInstantiatedEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener28StaticDataMemberInstantiatedEPKNS_7VarDeclE")
  //</editor-fold>
  @Override public void StaticDataMemberInstantiated(/*const*/ VarDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).StaticDataMemberInstantiated(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::DefaultArgumentInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 197,
   FQN="clang::MultiplexASTMutationListener::DefaultArgumentInstantiated", NM="_ZN5clang28MultiplexASTMutationListener27DefaultArgumentInstantiatedEPKNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener27DefaultArgumentInstantiatedEPKNS_11ParmVarDeclE")
  //</editor-fold>
  @Override public void DefaultArgumentInstantiated(/*const*/ ParmVarDecl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).DefaultArgumentInstantiated(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedObjCCategoryToInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 204,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 202,
   FQN="clang::MultiplexASTMutationListener::AddedObjCCategoryToInterface", NM="_ZN5clang28MultiplexASTMutationListener28AddedObjCCategoryToInterfaceEPKNS_16ObjCCategoryDeclEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener28AddedObjCCategoryToInterfaceEPKNS_16ObjCCategoryDeclEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  @Override public void AddedObjCCategoryToInterface(/*const*/ ObjCCategoryDecl /*P*/ CatD, 
                              /*const*/ ObjCInterfaceDecl /*P*/ IFD)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).AddedObjCCategoryToInterface(CatD, IFD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::FunctionDefinitionInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 210,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 208,
   FQN="clang::MultiplexASTMutationListener::FunctionDefinitionInstantiated", NM="_ZN5clang28MultiplexASTMutationListener30FunctionDefinitionInstantiatedEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener30FunctionDefinitionInstantiatedEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void FunctionDefinitionInstantiated(/*const*/ FunctionDecl /*P*/ D)/* override*/ {
    for (ASTMutationListener /*P*/ /*&*/ Listener : Listeners)  {
      Listener.FunctionDefinitionInstantiated(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::DeclarationMarkedUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 215,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 213,
   FQN="clang::MultiplexASTMutationListener::DeclarationMarkedUsed", NM="_ZN5clang28MultiplexASTMutationListener21DeclarationMarkedUsedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener21DeclarationMarkedUsedEPKNS_4DeclE")
  //</editor-fold>
  @Override public void DeclarationMarkedUsed(/*const*/ Decl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).DeclarationMarkedUsed(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::DeclarationMarkedOpenMPThreadPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 219,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 217,
   FQN="clang::MultiplexASTMutationListener::DeclarationMarkedOpenMPThreadPrivate", NM="_ZN5clang28MultiplexASTMutationListener36DeclarationMarkedOpenMPThreadPrivateEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener36DeclarationMarkedOpenMPThreadPrivateEPKNS_4DeclE")
  //</editor-fold>
  @Override public void DeclarationMarkedOpenMPThreadPrivate(/*const*/ Decl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0, e = Listeners.size(); i != e; ++i)  {
      Listeners.$at(i).DeclarationMarkedOpenMPThreadPrivate(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::DeclarationMarkedOpenMPDeclareTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 224,
   FQN="clang::MultiplexASTMutationListener::DeclarationMarkedOpenMPDeclareTarget", NM="_ZN5clang28MultiplexASTMutationListener36DeclarationMarkedOpenMPDeclareTargetEPKNS_4DeclEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener36DeclarationMarkedOpenMPDeclareTargetEPKNS_4DeclEPKNS_4AttrE")
  //</editor-fold>
  @Override public void DeclarationMarkedOpenMPDeclareTarget(/*const*/ Decl /*P*/ D, /*const*/ Attr /*P*/ Attr)/* override*/ {
    for (ASTMutationListener /*P*/ L : Listeners)  {
      L.DeclarationMarkedOpenMPDeclareTarget(D, Attr);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::RedefinedHiddenDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 229,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 222,
   FQN="clang::MultiplexASTMutationListener::RedefinedHiddenDefinition", NM="_ZN5clang28MultiplexASTMutationListener25RedefinedHiddenDefinitionEPKNS_9NamedDeclEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener25RedefinedHiddenDefinitionEPKNS_9NamedDeclEPNS_6ModuleE")
  //</editor-fold>
  @Override public void RedefinedHiddenDefinition(/*const*/ NamedDecl /*P*/ D, 
                           Module /*P*/ M)/* override*/ {
    for (ASTMutationListener /*P*/ L : Listeners)  {
      L.RedefinedHiddenDefinition(D, M);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::AddedAttributeToRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 228,
   FQN="clang::MultiplexASTMutationListener::AddedAttributeToRecord", NM="_ZN5clang28MultiplexASTMutationListener22AddedAttributeToRecordEPKNS_4AttrEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListener22AddedAttributeToRecordEPKNS_4AttrEPKNS_10RecordDeclE")
  //</editor-fold>
  @Override public void AddedAttributeToRecord(/*const*/ Attr /*P*/ Attr, 
                        /*const*/ RecordDecl /*P*/ Record)/* override*/ {
    for (ASTMutationListener /*P*/ L : Listeners)  {
      L.AddedAttributeToRecord(Attr, Record);
    }
  }

/*private:*/
  private std.vector<ASTMutationListener /*P*/ > Listeners;
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexASTMutationListener::~MultiplexASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 103,
   FQN="clang::MultiplexASTMutationListener::~MultiplexASTMutationListener", NM="_ZN5clang28MultiplexASTMutationListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang28MultiplexASTMutationListenerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Listeners.$destroy();
    //~ASTMutationListener;
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Listeners=" + Listeners // NOI18N
              + super.toString(); // NOI18N
  }
}
