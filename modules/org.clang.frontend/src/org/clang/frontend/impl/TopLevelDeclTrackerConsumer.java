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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import static org.clang.frontend.impl.ASTUnitStatics.AddTopLevelDeclarationToHash;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 819,
 FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumerE")
//</editor-fold>
public class TopLevelDeclTrackerConsumer extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  private ASTUnit /*&*/ Unit;
  private uint$ref/*uint &*/ Hash;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::TopLevelDeclTrackerConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 824,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::TopLevelDeclTrackerConsumer", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumerC1ERN5clang7ASTUnitERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumerC1ERN5clang7ASTUnitERj")
  //</editor-fold>
  public TopLevelDeclTrackerConsumer(ASTUnit /*&*/ _Unit, uint$ref/*uint &*/ Hash) {
    // : ASTConsumer(), Unit(_Unit), Hash(Hash) 
    //START JInit
    super();
    this./*&*/Unit=/*&*/_Unit;
    this./*&*/Hash=/*&*/Hash;
    //END JInit
    Hash.$set(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::handleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 829,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::handleTopLevelDecl", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer18handleTopLevelDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer18handleTopLevelDeclEPN5clang4DeclE")
  //</editor-fold>
  public void handleTopLevelDecl(Decl /*P*/ D) {
    if (!(D != null)) {
      return;
    }
    
    // FIXME: Currently ObjC method declarations are incorrectly being
    // reported as top-level declarations, even though their DeclContext
    // is the containing ObjC @interface/@implementation.  This is a
    // fundamental problem in the parser right now.
    if (isa(ObjCMethodDecl.class, D)) {
      return;
    }
    
    AddTopLevelDeclarationToHash(D, Hash);
    Unit.addTopLevelDecl(D);
    
    handleFileLevelDecl(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::handleFileLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 846,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::handleFileLevelDecl", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer19handleFileLevelDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer19handleFileLevelDeclEPN5clang4DeclE")
  //</editor-fold>
  public void handleFileLevelDecl(Decl /*P*/ D) {
    Unit.addFileLevelDecl(D);
    {
      NamespaceDecl /*P*/ NSD = dyn_cast(NamespaceDecl.class, D);
      if ((NSD != null)) {
        for (Decl /*P*/ I : NSD.decls())  {
          handleFileLevelDecl(I);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 854,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef D)/* override*/ {
    for (Decl /*P*/ TopLevelDecl : D)  {
      handleTopLevelDecl(TopLevelDecl);
    }
    return true;
  }

  
  // We're not interested in "interesting" decls.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::HandleInterestingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 861,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::HandleInterestingDecl", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer21HandleInterestingDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer21HandleInterestingDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleInterestingDecl(DeclGroupRef $Prm0)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::HandleTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 863,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::HandleTopLevelDeclInObjCContainer", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer33HandleTopLevelDeclInObjCContainerEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public void HandleTopLevelDeclInObjCContainer(DeclGroupRef D)/* override*/ {
    for (Decl /*P*/ TopLevelDecl : D)  {
      handleTopLevelDecl(TopLevelDecl);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::GetASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 868,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::GetASTMutationListener", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer22GetASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer22GetASTMutationListenerEv")
  //</editor-fold>
  @Override public ASTMutationListener /*P*/ GetASTMutationListener()/* override*/ {
    return Unit.getASTMutationListener();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::GetASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 872,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::GetASTDeserializationListener", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer29GetASTDeserializationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumer29GetASTDeserializationListenerEv")
  //</editor-fold>
  @Override public ASTDeserializationListener /*P*/ GetASTDeserializationListener()/* override*/ {
    return Unit.getDeserializationListener();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TopLevelDeclTrackerConsumer::~TopLevelDeclTrackerConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 819,
   FQN="(anonymous namespace)::TopLevelDeclTrackerConsumer::~TopLevelDeclTrackerConsumer", NM="_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_127TopLevelDeclTrackerConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Unit=" + Unit // NOI18N
              + ", Hash=" + Hash // NOI18N
              + super.toString(); // NOI18N
  }
}
