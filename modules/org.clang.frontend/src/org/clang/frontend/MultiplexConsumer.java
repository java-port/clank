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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import org.clang.frontend.impl.*;


// Has a list of ASTConsumers and calls each of them. Owns its children.
//<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/MultiplexConsumer.h", line = 29,
 FQN="clang::MultiplexConsumer", NM="_ZN5clang17MultiplexConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumerE")
//</editor-fold>
public class MultiplexConsumer extends /*public*/ SemaConsumer implements Destructors.ClassWithDestructor {
/*public:*/
  // Takes ownership of the pointers in C.
  // end namespace clang
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::MultiplexConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 237,
   FQN="clang::MultiplexConsumer::MultiplexConsumer", NM="_ZN5clang17MultiplexConsumerC1ESt6vectorISt10unique_ptrINS_11ASTConsumerESt14default_deleteIS3_EESaIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumerC1ESt6vectorISt10unique_ptrINS_11ASTConsumerESt14default_deleteIS3_EESaIS6_EE")
  //</editor-fold>
  public MultiplexConsumer(std.vector<std.unique_ptr<ASTConsumer>> C) {
    // : SemaConsumer(), Consumers(std::move(C)), MutationListener(), DeserializationListener() 
    //START JInit
    super();
    this.Consumers = new std.vector<std.unique_ptr<ASTConsumer>>(JD$Move.INSTANCE, std.move(C));
    this.MutationListener = new std.unique_ptr<MultiplexASTMutationListener>();
    this.DeserializationListener = new std.unique_ptr<MultiplexASTDeserializationListener>();
    //END JInit
    std.vector<ASTMutationListener /*P*/ > mutationListeners = null;
    std.vector<ASTDeserializationListener /*P*/ > serializationListeners = null;
    try {
      // Collect the mutation listeners and deserialization listeners of all
      // children, and create a multiplex listener each if so.
      mutationListeners/*J*/= new std.vector<ASTMutationListener /*P*/ >((ASTMutationListener /*P*/ )null);
      serializationListeners/*J*/= new std.vector<ASTDeserializationListener /*P*/ >((ASTDeserializationListener /*P*/ )null);
      for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers) {
        {
          ASTMutationListener /*P*/ mutationListener = Consumer.$arrow().GetASTMutationListener();
          if ((mutationListener != null)) {
            mutationListeners.push_back_T$C$R(mutationListener);
          }
        }
        {
          ASTDeserializationListener /*P*/ serializationListener = (ASTDeserializationListener)Consumer.$arrow().GetASTDeserializationListener();
          if ((serializationListener != null)) {
            serializationListeners.push_back_T$C$R(serializationListener);
          }
        }
      }
      if (!mutationListeners.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(MutationListener.$assignMove(
              $c$.track(llvm.make_unique(new MultiplexASTMutationListener(mutationListeners)))
          ));
        } finally {
          $c$.$destroy();
        }
      }
      if (!serializationListeners.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(DeserializationListener.$assignMove(
              $c$.track(llvm.make_unique(new MultiplexASTDeserializationListener(serializationListeners)))
          ));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (serializationListeners != null) { serializationListeners.$destroy(); }
      if (mutationListeners != null) { mutationListeners.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::~MultiplexConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 261,
   FQN="clang::MultiplexConsumer::~MultiplexConsumer", NM="_ZN5clang17MultiplexConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    DeserializationListener.$destroy();
    MutationListener.$destroy();
    Consumers.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  // ASTConsumer
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 270,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 263,
   FQN="clang::MultiplexConsumer::Initialize", NM="_ZN5clang17MultiplexConsumer10InitializeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer10InitializeERNS_10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(ASTContext /*&*/ Context)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().Initialize(Context);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleCXXStaticMemberVarInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 287,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 280,
   FQN="clang::MultiplexConsumer::HandleCXXStaticMemberVarInstantiation", NM="_ZN5clang17MultiplexConsumer37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE")
  //</editor-fold>
  @Override public void HandleCXXStaticMemberVarInstantiation(VarDecl /*P*/ VD)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleCXXStaticMemberVarInstantiation(VD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 268,
   FQN="clang::MultiplexConsumer::HandleTopLevelDecl", NM="_ZN5clang17MultiplexConsumer18HandleTopLevelDeclENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer18HandleTopLevelDeclENS_12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    boolean Continue = true;
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Continue = Continue && Consumer.$arrow().HandleTopLevelDecl(new DeclGroupRef(D));
    }
    return Continue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleInlineFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 282,
   FQN="clang::MultiplexConsumer::HandleInlineFunctionDefinition", NM="_ZN5clang17MultiplexConsumer30HandleInlineFunctionDefinitionEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer30HandleInlineFunctionDefinitionEPNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void HandleInlineFunctionDefinition(FunctionDecl /*P*/ D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleInlineFunctionDefinition(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleInterestingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 292,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 285,
   FQN="clang::MultiplexConsumer::HandleInterestingDecl", NM="_ZN5clang17MultiplexConsumer21HandleInterestingDeclENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer21HandleInterestingDeclENS_12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleInterestingDecl(DeclGroupRef D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleInterestingDecl(new DeclGroupRef(D));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 297,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 290,
   FQN="clang::MultiplexConsumer::HandleTranslationUnit", NM="_ZN5clang17MultiplexConsumer21HandleTranslationUnitERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer21HandleTranslationUnitERNS_10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ Ctx)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleTranslationUnit(Ctx);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleTagDeclDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 302,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 295,
   FQN="clang::MultiplexConsumer::HandleTagDeclDefinition", NM="_ZN5clang17MultiplexConsumer23HandleTagDeclDefinitionEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer23HandleTagDeclDefinitionEPNS_7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclDefinition(TagDecl /*P*/ D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleTagDeclDefinition(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleTagDeclRequiredDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 300,
   FQN="clang::MultiplexConsumer::HandleTagDeclRequiredDefinition", NM="_ZN5clang17MultiplexConsumer31HandleTagDeclRequiredDefinitionEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer31HandleTagDeclRequiredDefinitionEPKNS_7TagDeclE")
  //</editor-fold>
  @Override public void HandleTagDeclRequiredDefinition(/*const*/ TagDecl /*P*/ D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleTagDeclRequiredDefinition(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleCXXImplicitFunctionInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 312,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 305,
   FQN="clang::MultiplexConsumer::HandleCXXImplicitFunctionInstantiation", NM="_ZN5clang17MultiplexConsumer38HandleCXXImplicitFunctionInstantiationEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer38HandleCXXImplicitFunctionInstantiationEPNS_12FunctionDeclE")
  //</editor-fold>
  @Override public void HandleCXXImplicitFunctionInstantiation(FunctionDecl /*P*/ D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleCXXImplicitFunctionInstantiation(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 317,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 310,
   FQN="clang::MultiplexConsumer::HandleTopLevelDeclInObjCContainer", NM="_ZN5clang17MultiplexConsumer33HandleTopLevelDeclInObjCContainerENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer33HandleTopLevelDeclInObjCContainerENS_12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleTopLevelDeclInObjCContainer(DeclGroupRef D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleTopLevelDeclInObjCContainer(new DeclGroupRef(D));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleImplicitImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 322,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 315,
   FQN="clang::MultiplexConsumer::HandleImplicitImportDecl", NM="_ZN5clang17MultiplexConsumer24HandleImplicitImportDeclEPNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer24HandleImplicitImportDeclEPNS_10ImportDeclE")
  //</editor-fold>
  @Override public void HandleImplicitImportDecl(ImportDecl /*P*/ D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleImplicitImportDecl(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::CompleteTentativeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 327,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 335,
   FQN="clang::MultiplexConsumer::CompleteTentativeDefinition", NM="_ZN5clang17MultiplexConsumer27CompleteTentativeDefinitionEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer27CompleteTentativeDefinitionEPNS_7VarDeclE")
  //</editor-fold>
  @Override public void CompleteTentativeDefinition(VarDecl /*P*/ D)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().CompleteTentativeDefinition(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::AssignInheritanceModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 332,
   FQN="clang::MultiplexConsumer::AssignInheritanceModel", NM="_ZN5clang17MultiplexConsumer22AssignInheritanceModelEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer22AssignInheritanceModelEPNS_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void AssignInheritanceModel(CXXRecordDecl /*P*/ RD)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().AssignInheritanceModel(RD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::HandleVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 337,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 340,
   FQN="clang::MultiplexConsumer::HandleVTable", NM="_ZN5clang17MultiplexConsumer12HandleVTableEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer12HandleVTableEPNS_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void HandleVTable(CXXRecordDecl /*P*/ RD)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().HandleVTable(RD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::GetASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 342,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 345,
   FQN="clang::MultiplexConsumer::GetASTMutationListener", NM="_ZN5clang17MultiplexConsumer22GetASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer22GetASTMutationListenerEv")
  //</editor-fold>
  @Override public ASTMutationListener /*P*/ GetASTMutationListener()/* override*/ {
    return MutationListener.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::GetASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 346,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 349,
   FQN="clang::MultiplexConsumer::GetASTDeserializationListener", NM="_ZN5clang17MultiplexConsumer29GetASTDeserializationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer29GetASTDeserializationListenerEv")
  //</editor-fold>
  @Override public ASTDeserializationListener /*P*/ GetASTDeserializationListener()/* override*/ {
    return DeserializationListener.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 350,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 353,
   FQN="clang::MultiplexConsumer::PrintStats", NM="_ZN5clang17MultiplexConsumer10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer10PrintStatsEv")
  //</editor-fold>
  @Override public void PrintStats()/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Consumer.$arrow().PrintStats();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::shouldSkipFunctionBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 355,
   FQN="clang::MultiplexConsumer::shouldSkipFunctionBody", NM="_ZN5clang17MultiplexConsumer22shouldSkipFunctionBodyEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer22shouldSkipFunctionBodyEPNS_4DeclE")
  //</editor-fold>
  @Override public boolean shouldSkipFunctionBody(Decl /*P*/ D)/* override*/ {
    boolean Skip = true;
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      Skip = Skip && Consumer.$arrow().shouldSkipFunctionBody(D);
    }
    return Skip;
  }

  
  // SemaConsumer
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::InitializeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 362,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 358,
   FQN="clang::MultiplexConsumer::InitializeSema", NM="_ZN5clang17MultiplexConsumer14InitializeSemaERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer14InitializeSemaERNS_4SemaE")
  //</editor-fold>
  @Override public void InitializeSema(Sema /*&*/ S)/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      {
        SemaConsumer /*P*/ SC = dyn_cast(SemaConsumer.class, Consumer.get());
        if ((SC != null)) {
          SC.InitializeSema(S);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexConsumer::ForgetSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", line = 368,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp", old_line = 364,
   FQN="clang::MultiplexConsumer::ForgetSema", NM="_ZN5clang17MultiplexConsumer10ForgetSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp -nm=_ZN5clang17MultiplexConsumer10ForgetSemaEv")
  //</editor-fold>
  @Override public void ForgetSema()/* override*/ {
    for (unique_ptr<ASTConsumer> /*&*/ Consumer : Consumers)  {
      {
        SemaConsumer /*P*/ SC = dyn_cast(SemaConsumer.class, Consumer.get());
        if ((SC != null)) {
          SC.ForgetSema();
        }
      }
    }
  }

/*private:*/
  private std.vector<std.unique_ptr<ASTConsumer>> Consumers; // Owns these.
  private std.unique_ptr<MultiplexASTMutationListener> MutationListener;
  private std.unique_ptr<MultiplexASTDeserializationListener> DeserializationListener;
  
  @Override public String toString() {
    return "" + "Consumers=" + Consumers // NOI18N
              + ", MutationListener=" + MutationListener // NOI18N
              + ", DeserializationListener=" + DeserializationListener // NOI18N
              + super.toString(); // NOI18N
  }
}
