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


/// ASTConsumer - This is an abstract interface that should be implemented by
/// clients that read ASTs.  This abstraction layer allows the client to be
/// independent of the AST producer (e.g. parser vs AST dump file reader, etc).
//<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 36,
 FQN="clang::ASTConsumer", NM="_ZN5clang11ASTConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumerE")
//</editor-fold>
public class ASTConsumer implements Destructors.ClassWithDestructor {
  /// \brief Whether this AST consumer also requires information about
  /// semantic analysis.
  public/*friend*//*private*/ boolean SemaConsumer;
  
  /*friend  class SemaConsumer*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::ASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 44,
   FQN="clang::ASTConsumer::ASTConsumer", NM="_ZN5clang11ASTConsumerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumerC1Ev")
  //</editor-fold>
  public ASTConsumer() {
    // : SemaConsumer(false) 
    //START JInit
    this.SemaConsumer = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::~ASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 46,
   FQN="clang::ASTConsumer::~ASTConsumer", NM="_ZN5clang11ASTConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumerD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// Initialize - This is called to initialize the consumer, providing the
  /// ASTContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 50,
   FQN="clang::ASTConsumer::Initialize", NM="_ZN5clang11ASTConsumer10InitializeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer10InitializeERNS_10ASTContextE")
  //</editor-fold>
  public /*virtual*/ void Initialize(final ASTContext /*&*/ Context) {
  }

  
  /// HandleTopLevelDecl - Handle the specified top-level declaration.  This is
  /// called by the parser to process every top-level Decl*.
  ///
  /// \returns true to continue parsing, or false to abort parsing.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp", line = 19,
   FQN="clang::ASTConsumer::HandleTopLevelDecl", NM="_ZN5clang11ASTConsumer18HandleTopLevelDeclENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer18HandleTopLevelDeclENS_12DeclGroupRefE")
  //</editor-fold>
  public boolean HandleTopLevelDecl(DeclGroupRef D) {
    return true;
  }

  
  /// \brief This callback is invoked each time an inline (method or friend)
  /// function definition in a class is completed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleInlineFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 60,
   FQN="clang::ASTConsumer::HandleInlineFunctionDefinition", NM="_ZN5clang11ASTConsumer30HandleInlineFunctionDefinitionEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer30HandleInlineFunctionDefinitionEPNS_12FunctionDeclE")
  //</editor-fold>
  public /*virtual*/ void HandleInlineFunctionDefinition(FunctionDecl /*P*/ D) {
  }

  
  /// HandleInterestingDecl - Handle the specified interesting declaration. This
  /// is called by the AST reader when deserializing things that might interest
  /// the consumer. The default implementation forwards to HandleTopLevelDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleInterestingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp", line = 23,
   FQN="clang::ASTConsumer::HandleInterestingDecl", NM="_ZN5clang11ASTConsumer21HandleInterestingDeclENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer21HandleInterestingDeclENS_12DeclGroupRefE")
  //</editor-fold>
  public void HandleInterestingDecl(DeclGroupRef D) {
    HandleTopLevelDecl(new DeclGroupRef(D));
  }

  
  /// HandleTranslationUnit - This method is called when the ASTs for entire
  /// translation unit have been parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 69,
   FQN="clang::ASTConsumer::HandleTranslationUnit", NM="_ZN5clang11ASTConsumer21HandleTranslationUnitERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer21HandleTranslationUnitERNS_10ASTContextE")
  //</editor-fold>
  public /*virtual*/ void HandleTranslationUnit(final ASTContext /*&*/ Ctx) {
  }

  
  /// HandleTagDeclDefinition - This callback is invoked each time a TagDecl
  /// (e.g. struct, union, enum, class) is completed.  This allows the client to
  /// hack on the type, which can occur at any point in the file (because these
  /// can be defined in declspecs).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleTagDeclDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 75,
   FQN="clang::ASTConsumer::HandleTagDeclDefinition", NM="_ZN5clang11ASTConsumer23HandleTagDeclDefinitionEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer23HandleTagDeclDefinitionEPNS_7TagDeclE")
  //</editor-fold>
  public /*virtual*/ void HandleTagDeclDefinition(TagDecl /*P*/ D) {
  }

  
  /// \brief This callback is invoked the first time each TagDecl is required to
  /// be complete.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleTagDeclRequiredDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 79,
   FQN="clang::ASTConsumer::HandleTagDeclRequiredDefinition", NM="_ZN5clang11ASTConsumer31HandleTagDeclRequiredDefinitionEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer31HandleTagDeclRequiredDefinitionEPKNS_7TagDeclE")
  //</editor-fold>
  public /*virtual*/ void HandleTagDeclRequiredDefinition(/*const*/ TagDecl /*P*/ D) {
  }

  
  /// \brief Invoked when a function is implicitly instantiated.
  /// Note that at this point point it does not have a body, its body is
  /// instantiated at the end of the translation unit and passed to
  /// HandleTopLevelDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleCXXImplicitFunctionInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 85,
   FQN="clang::ASTConsumer::HandleCXXImplicitFunctionInstantiation", NM="_ZN5clang11ASTConsumer38HandleCXXImplicitFunctionInstantiationEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer38HandleCXXImplicitFunctionInstantiationEPNS_12FunctionDeclE")
  //</editor-fold>
  public /*virtual*/ void HandleCXXImplicitFunctionInstantiation(FunctionDecl /*P*/ D) {
  }

  
  /// \brief Handle the specified top-level declaration that occurred inside
  /// and ObjC container.
  /// The default implementation ignored them.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleTopLevelDeclInObjCContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp", line = 27,
   FQN="clang::ASTConsumer::HandleTopLevelDeclInObjCContainer", NM="_ZN5clang11ASTConsumer33HandleTopLevelDeclInObjCContainerENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer33HandleTopLevelDeclInObjCContainerENS_12DeclGroupRefE")
  //</editor-fold>
  public void HandleTopLevelDeclInObjCContainer(DeclGroupRef D) {
  }

  
  /// \brief Handle an ImportDecl that was implicitly created due to an
  /// inclusion directive.
  /// The default implementation passes it to HandleTopLevelDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleImplicitImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp", line = 29,
   FQN="clang::ASTConsumer::HandleImplicitImportDecl", NM="_ZN5clang11ASTConsumer24HandleImplicitImportDeclEPNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer24HandleImplicitImportDeclEPNS_10ImportDeclE")
  //</editor-fold>
  public void HandleImplicitImportDecl(ImportDecl /*P*/ D) {
    HandleTopLevelDecl(new DeclGroupRef(D));
  }

  
  /// CompleteTentativeDefinition - Callback invoked at the end of a translation
  /// unit to notify the consumer that the given tentative definition should be
  /// completed.
  ///
  /// The variable declaration itself will be a tentative
  /// definition. If it had an incomplete array type, its type will
  /// have already been changed to an array of size 1. However, the
  /// declaration remains a tentative definition and has not been
  /// modified by the introduction of an implicit zero initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::CompleteTentativeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 106,
   FQN="clang::ASTConsumer::CompleteTentativeDefinition", NM="_ZN5clang11ASTConsumer27CompleteTentativeDefinitionEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer27CompleteTentativeDefinitionEPNS_7VarDeclE")
  //</editor-fold>
  public /*virtual*/ void CompleteTentativeDefinition(VarDecl /*P*/ D) {
  }

  
  /// \brief Callback invoked when an MSInheritanceAttr has been attached to a
  /// CXXRecordDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::AssignInheritanceModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 110,
   FQN="clang::ASTConsumer::AssignInheritanceModel", NM="_ZN5clang11ASTConsumer22AssignInheritanceModelEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer22AssignInheritanceModelEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*virtual*/ void AssignInheritanceModel(CXXRecordDecl /*P*/ RD) {
  }

  
  /// HandleCXXStaticMemberVarInstantiation - Tell the consumer that this
  // variable has been instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleCXXStaticMemberVarInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 114,
   FQN="clang::ASTConsumer::HandleCXXStaticMemberVarInstantiation", NM="_ZN5clang11ASTConsumer37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer37HandleCXXStaticMemberVarInstantiationEPNS_7VarDeclE")
  //</editor-fold>
  public /*virtual*/ void HandleCXXStaticMemberVarInstantiation(VarDecl /*P*/ D) {
  }

  
  /// \brief Callback involved at the end of a translation unit to
  /// notify the consumer that a vtable for the given C++ class is
  /// required.
  ///
  /// \param RD The class whose vtable was used.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::HandleVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 121,
   FQN="clang::ASTConsumer::HandleVTable", NM="_ZN5clang11ASTConsumer12HandleVTableEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer12HandleVTableEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*virtual*/ void HandleVTable(CXXRecordDecl /*P*/ RD) {
  }

  
  /// \brief If the consumer is interested in entities getting modified after
  /// their initial creation, it should return a pointer to
  /// an ASTMutationListener here.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::GetASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 126,
   FQN="clang::ASTConsumer::GetASTMutationListener", NM="_ZN5clang11ASTConsumer22GetASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer22GetASTMutationListenerEv")
  //</editor-fold>
  public /*virtual*/ ASTMutationListener /*P*/ GetASTMutationListener() {
    return null;
  }

  
  /// \brief If the consumer is interested in entities being deserialized from
  /// AST files, it should return a pointer to a ASTDeserializationListener here
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::GetASTDeserializationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 130,
   FQN="clang::ASTConsumer::GetASTDeserializationListener", NM="_ZN5clang11ASTConsumer29GetASTDeserializationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer29GetASTDeserializationListenerEv")
  //</editor-fold>
  public /*virtual*/ ASTDeserializationListenerImplementation/*P*/ GetASTDeserializationListener() {
    return null;
  }

  
  /// PrintStats - If desired, print any statistics.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 135,
   FQN="clang::ASTConsumer::PrintStats", NM="_ZN5clang11ASTConsumer10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer10PrintStatsEv")
  //</editor-fold>
  public /*virtual*/ void PrintStats() {
  }

  
  /// \brief This callback is called for each function if the Parser was
  /// initialized with \c SkipFunctionBodies set to \c true.
  ///
  /// \return \c true if the function's body should be skipped. The function
  /// body may be parsed anyway if it is needed (for instance, if it contains
  /// the code completion point or is constexpr).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTConsumer::shouldSkipFunctionBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTConsumer.h", line = 143,
   FQN="clang::ASTConsumer::shouldSkipFunctionBody", NM="_ZN5clang11ASTConsumer22shouldSkipFunctionBodyEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTConsumer.cpp -nm=_ZN5clang11ASTConsumer22shouldSkipFunctionBodyEPNS_4DeclE")
  //</editor-fold>
  public /*virtual*/ boolean shouldSkipFunctionBody(Decl /*P*/ D) {
    return true;
  }

  
  @Override public String toString() {
    return "" + "SemaConsumer=" + SemaConsumer; // NOI18N
  }
}
