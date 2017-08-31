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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstFunctionPointers.*;


/// \brief Abstract interface for external sources of AST nodes.
///
/// External AST sources provide AST nodes constructed from some
/// external source, such as a precompiled header. External AST
/// sources can resolve types and declarations from abstract IDs into
/// actual type and declaration nodes, and read parts of declaration
/// contexts.
//<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 43,
 FQN="clang::ExternalASTSource", NM="_ZN5clang17ExternalASTSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSourceE")
//</editor-fold>
public class ExternalASTSource extends /*public*/ RefCountedBase<ExternalASTSource> implements Destructors.ClassWithDestructor {
  /// Generation number for this external AST source. Must be increased
  /// whenever we might have added new redeclarations for existing decls.
  private /*uint32_t*/int CurrentGeneration;
  
  /// \brief Whether this AST source also provides information for
  /// semantic analysis.
  public/*friend*//*private*/ boolean SemaSource;
  
  /*friend  class ExternalSemaSource*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ExternalASTSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 55,
   FQN="clang::ExternalASTSource::ExternalASTSource", NM="_ZN5clang17ExternalASTSourceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSourceC1Ev")
  //</editor-fold>
  public ExternalASTSource() {
    // : RefCountedBase<ExternalASTSource>(), CurrentGeneration(0), SemaSource(false) 
    //START JInit
    super();
    this.CurrentGeneration = 0;
    this.SemaSource = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::~ExternalASTSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 24,
   FQN="clang::ExternalASTSource::~ExternalASTSource", NM="_ZN5clang17ExternalASTSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSourceD0Ev")
  //</editor-fold>
  public void $destroy() {
    super.$destroy();
  }


  
  /// \brief RAII class for safely pairing a StartedDeserializing call
  /// with FinishedDeserializing.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::Deserializing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 61,
   FQN="clang::ExternalASTSource::Deserializing", NM="_ZN5clang17ExternalASTSource13DeserializingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource13DeserializingE")
  //</editor-fold>
  public static class Deserializing implements Destructors.ClassWithDestructor {
    private ExternalASTSource /*P*/ Source;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::Deserializing::Deserializing">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 64,
     FQN="clang::ExternalASTSource::Deserializing::Deserializing", NM="_ZN5clang17ExternalASTSource13DeserializingC1EPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource13DeserializingC1EPS0_")
    //</editor-fold>
    public /*explicit*/ Deserializing(ExternalASTSource /*P*/ source) {
      // : Source(source) 
      //START JInit
      this.Source = source;
      //END JInit
      assert Native.$bool(Source);
      Source.StartedDeserializing();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::Deserializing::~Deserializing">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 68,
     FQN="clang::ExternalASTSource::Deserializing::~Deserializing", NM="_ZN5clang17ExternalASTSource13DeserializingD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource13DeserializingD0Ev")
    //</editor-fold>
    public void $destroy() {
      Source.FinishedDeserializing();
    }

    
    @Override public String toString() {
      return "" + "Source=" + "[ExternalASTSource]"; // NOI18N
    }
  };
  
  /// \brief Get the current generation of this AST source. This number
  /// is incremented each time the AST source lazily extends an existing
  /// entity.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::getGeneration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 76,
   FQN="clang::ExternalASTSource::getGeneration", NM="_ZNK5clang17ExternalASTSource13getGenerationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang17ExternalASTSource13getGenerationEv")
  //</editor-fold>
  public /*uint32_t*/int getGeneration() /*const*/ {
    return CurrentGeneration;
  }

  
  /// \brief Resolve a declaration ID into a declaration, potentially
  /// building a new declaration.
  ///
  /// This method only needs to be implemented if the AST source ever
  /// passes back decl sets as VisibleDeclaration objects.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Resolve a declaration ID into a declaration, potentially
  /// building a new declaration.
  ///
  /// This method only needs to be implemented if the AST source ever
  /// passes back decl sets as VisibleDeclaration objects.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::GetExternalDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 74,
   FQN="clang::ExternalASTSource::GetExternalDecl", NM="_ZN5clang17ExternalASTSource15GetExternalDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource15GetExternalDeclEj")
  //</editor-fold>
  public Decl /*P*/ GetExternalDecl(/*uint32_t*/long ID) {
    return null;
  }


  
  /// \brief Resolve a selector ID into a selector.
  ///
  /// This operation only needs to be implemented if the AST source
  /// returns non-zero for GetNumKnownSelectors().
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Resolve a selector ID into a selector.
  ///
  /// This operation only needs to be implemented if the AST source
  /// returns non-zero for GetNumKnownSelectors().
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::GetExternalSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 78,
   FQN="clang::ExternalASTSource::GetExternalSelector", NM="_ZN5clang17ExternalASTSource19GetExternalSelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19GetExternalSelectorEj")
  //</editor-fold>
  public Selector GetExternalSelector(/*uint32_t*/int ID) {
    return new Selector();
  }


  
  /// \brief Returns the number of selectors known to the external AST
  /// source.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Returns the number of selectors known to the external AST
  /// source.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::GetNumExternalSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 82,
   FQN="clang::ExternalASTSource::GetNumExternalSelectors", NM="_ZN5clang17ExternalASTSource23GetNumExternalSelectorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource23GetNumExternalSelectorsEv")
  //</editor-fold>
  public /*uint32_t*/int GetNumExternalSelectors() {
    return 0;
  }


  
  /// \brief Resolve the offset of a statement in the decl stream into
  /// a statement.
  ///
  /// This operation is meant to be used via a LazyOffsetPtr.  It only
  /// needs to be implemented if the AST source uses methods like
  /// FunctionDecl::setLazyBody when building decls.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Resolve the offset of a statement in the decl stream into
  /// a statement.
  ///
  /// This operation is meant to be used via a LazyOffsetPtr.  It only
  /// needs to be implemented if the AST source uses methods like
  /// FunctionDecl::setLazyBody when building decls.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::GetExternalDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 86,
   FQN="clang::ExternalASTSource::GetExternalDeclStmt", NM="_ZN5clang17ExternalASTSource19GetExternalDeclStmtEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19GetExternalDeclStmtEy")
  //</editor-fold>
  public Stmt /*P*/ GetExternalDeclStmt(long/*uint64_t*/ Offset) {
    return null;
  }


  
  /// \brief Resolve the offset of a set of C++ constructor initializers in
  /// the decl stream into an array of initializers.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Resolve the offset of a set of C++ constructor initializers in
  /// the decl stream into an array of initializers.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::GetExternalCXXCtorInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 90,
   FQN="clang::ExternalASTSource::GetExternalCXXCtorInitializers", NM="_ZN5clang17ExternalASTSource30GetExternalCXXCtorInitializersEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource30GetExternalCXXCtorInitializersEy")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*P*/> GetExternalCXXCtorInitializers(long/*uint64_t*/ Offset) {
    return null;
  }


  
  /// \brief Resolve the offset of a set of C++ base specifiers in the decl
  /// stream into an array of specifiers.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Resolve the offset of a set of C++ base specifiers in the decl
  /// stream into an array of specifiers.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::GetExternalCXXBaseSpecifiers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 95,
   FQN="clang::ExternalASTSource::GetExternalCXXBaseSpecifiers", NM="_ZN5clang17ExternalASTSource28GetExternalCXXBaseSpecifiersEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource28GetExternalCXXBaseSpecifiersEy")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier /*P*/> GetExternalCXXBaseSpecifiers(long/*uint64_t*/ Offset) {
    return null;
  }


  
  /// \brief Update an out-of-date identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::updateOutOfDateIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 124,
   FQN="clang::ExternalASTSource::updateOutOfDateIdentifier", NM="_ZN5clang17ExternalASTSource25updateOutOfDateIdentifierERNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource25updateOutOfDateIdentifierERNS_14IdentifierInfoE")
  //</editor-fold>
  public /*virtual*/ void updateOutOfDateIdentifier(final IdentifierInfo /*&*/ II) {
  }

  
  /// \brief Find all declarations with the given name in the given context,
  /// and add them to the context by calling SetExternalVisibleDeclsForName
  /// or SetNoExternalVisibleDeclsForName.
  /// \return \c true if any declarations might have been found, \c false if
  /// we definitely have no declarations with tbis name.
  ///
  /// The default implementation of this method is a no-op returning \c false.
  
  /// \brief Find all declarations with the given name in the given context,
  /// and add them to the context by calling SetExternalVisibleDeclsForName
  /// or SetNoExternalVisibleDeclsForName.
  /// \return \c true if any declarations might have been found, \c false if
  /// we definitely have no declarations with tbis name.
  ///
  /// The default implementation of this method is a no-op returning \c false.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::FindExternalVisibleDeclsByName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 100,
   FQN="clang::ExternalASTSource::FindExternalVisibleDeclsByName", NM="_ZN5clang17ExternalASTSource30FindExternalVisibleDeclsByNameEPKNS_11DeclContextENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource30FindExternalVisibleDeclsByNameEPKNS_11DeclContextENS_15DeclarationNameE")
  //</editor-fold>
  public boolean FindExternalVisibleDeclsByName(/*const*/ DeclContext /*P*/ DC, 
                                DeclarationName Name) {
    return false;
  }


  
  /// \brief Ensures that the table of all visible declarations inside this
  /// context is up to date.
  ///
  /// The default implementation of this function is a no-op.
  
  /// \brief Ensures that the table of all visible declarations inside this
  /// context is up to date.
  ///
  /// The default implementation of this function is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::completeVisibleDeclsMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 106,
   FQN="clang::ExternalASTSource::completeVisibleDeclsMap", NM="_ZN5clang17ExternalASTSource23completeVisibleDeclsMapEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource23completeVisibleDeclsMapEPKNS_11DeclContextE")
  //</editor-fold>
  public void completeVisibleDeclsMap(/*const*/ DeclContext /*P*/ DC) {
  }


  
  /// \brief Retrieve the module that corresponds to the given module ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 143,
   FQN="clang::ExternalASTSource::getModule", NM="_ZN5clang17ExternalASTSource9getModuleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource9getModuleEj")
  //</editor-fold>
  public /*virtual*/ Module /*P*/ getModule(/*uint*/int ID) {
    return null;
  }

  
  /// Abstracts clang modules and precompiled header files and holds
  /// everything needed to generate debug info for an imported module
  /// or PCH.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 148,
   FQN="clang::ExternalASTSource::ASTSourceDescriptor", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptorE")
  //</editor-fold>
  public static class ASTSourceDescriptor {
    private StringRef PCHModuleName;
    private StringRef Path;
    private StringRef ASTFile;
    private long/*uint64_t*/ Signature/* = 0*/;
    private /*const*/ Module /*P*/ ClangModule/* = null*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 156,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1Ev")
    //</editor-fold>
    public ASTSourceDescriptor() {
      // : PCHModuleName(), Path(), ASTFile(), Signature(0), ClangModule(null) 
      //START JInit
      this.PCHModuleName = new StringRef();
      this.Path = new StringRef();
      this.ASTFile = new StringRef();
      /*InClass*/this.Signature = $int2ulong(0);
      /*InClass*/this.ClangModule = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 157,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1EN4llvm9StringRefES3_S3_y",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1EN4llvm9StringRefES3_S3_y")
    //</editor-fold>
    public ASTSourceDescriptor(StringRef Name, StringRef Path, StringRef ASTFile, 
        long/*uint64_t*/ Signature) {
      // : PCHModuleName(std::move(Name)), Path(std::move(Path)), ASTFile(std::move(ASTFile)), Signature(Signature), ClangModule(null) 
      //START JInit
      this.PCHModuleName = new StringRef(JD$Move.INSTANCE, std.move(Name));
      this.Path = new StringRef(JD$Move.INSTANCE, std.move(Path));
      this.ASTFile = new StringRef(JD$Move.INSTANCE, std.move(ASTFile));
      this.Signature = Signature;
      /*InClass*/this.ClangModule = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 31,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1ERKNS_6ModuleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1ERKNS_6ModuleE")
    //</editor-fold>
    public ASTSourceDescriptor(final /*const*/ Module /*&*/ M) {
      // : PCHModuleName(), Path(), ASTFile(), Signature(M.Signature), ClangModule(&M) 
      //START JInit
      this.PCHModuleName = new StringRef();
      this.Path = new StringRef();
      this.ASTFile = new StringRef();
      this.Signature = M.Signature;
      this.ClangModule = $AddrOf(M);
      //END JInit
      if ((M.Directory != null)) {
        Path.$assignMove(/*STRINGREF_STR*/M.Directory.getName());
      }
      {
        /*const*/ FileEntry /*P*/ File = M.getASTFile();
        if ((File != null)) {
          ASTFile.$assignMove(/*STRINGREF_STR*/File.getName());
        }
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::getModuleName">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 39,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::getModuleName", NM="_ZNK5clang17ExternalASTSource19ASTSourceDescriptor13getModuleNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang17ExternalASTSource19ASTSourceDescriptor13getModuleNameEv")
    //</editor-fold>
    public std.string getModuleName() /*const*/ {
      if ((ClangModule != null)) {
        return new std.string(ClangModule.Name);
      } else {
        return PCHModuleName.$string();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::getPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 163,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::getPath", NM="_ZNK5clang17ExternalASTSource19ASTSourceDescriptor7getPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang17ExternalASTSource19ASTSourceDescriptor7getPathEv")
    //</editor-fold>
    public StringRef getPath() /*const*/ {
      return new StringRef(Path);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::getASTFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 164,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::getASTFile", NM="_ZNK5clang17ExternalASTSource19ASTSourceDescriptor10getASTFileEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang17ExternalASTSource19ASTSourceDescriptor10getASTFileEv")
    //</editor-fold>
    public StringRef getASTFile() /*const*/ {
      return new StringRef(ASTFile);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::getSignature">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 165,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::getSignature", NM="_ZNK5clang17ExternalASTSource19ASTSourceDescriptor12getSignatureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang17ExternalASTSource19ASTSourceDescriptor12getSignatureEv")
    //</editor-fold>
    public long/*uint64_t*/ getSignature() /*const*/ {
      return Signature;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::getModuleOrNull">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 166,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::getModuleOrNull", NM="_ZNK5clang17ExternalASTSource19ASTSourceDescriptor15getModuleOrNullEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang17ExternalASTSource19ASTSourceDescriptor15getModuleOrNullEv")
    //</editor-fold>
    public /*const*/ Module /*P*/ getModuleOrNull() /*const*/ {
      return ClangModule;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 148,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::operator=", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptoraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptoraSERKS1_")
    //</editor-fold>
    public /*inline*/ ASTSourceDescriptor /*&*/ $assign(final /*const*/ ASTSourceDescriptor /*&*/ $Prm0) {
      this.PCHModuleName.$assign($Prm0.PCHModuleName);
      this.Path.$assign($Prm0.Path);
      this.ASTFile.$assign($Prm0.ASTFile);
      this.Signature = $Prm0.Signature;
      this.ClangModule = $Prm0.ClangModule;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 148,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ASTSourceDescriptor(final /*const*/ ASTSourceDescriptor /*&*/ $Prm0) {
      // : PCHModuleName(.PCHModuleName), Path(.Path), ASTFile(.ASTFile), Signature(.Signature), ClangModule(.ClangModule) 
      //START JInit
      this.PCHModuleName = new StringRef($Prm0.PCHModuleName);
      this.Path = new StringRef($Prm0.Path);
      this.ASTFile = new StringRef($Prm0.ASTFile);
      this.Signature = $Prm0.Signature;
      this.ClangModule = $Prm0.ClangModule;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 148,
     FQN="clang::ExternalASTSource::ASTSourceDescriptor::ASTSourceDescriptor", NM="_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource19ASTSourceDescriptorC1EOS1_")
    //</editor-fold>
    public /*inline*/ ASTSourceDescriptor(JD$Move _dparam, final ASTSourceDescriptor /*&&*/$Prm0) {
      // : PCHModuleName(static_cast<ASTSourceDescriptor &&>().PCHModuleName), Path(static_cast<ASTSourceDescriptor &&>().Path), ASTFile(static_cast<ASTSourceDescriptor &&>().ASTFile), Signature(static_cast<ASTSourceDescriptor &&>().Signature), ClangModule(static_cast<ASTSourceDescriptor &&>().ClangModule) 
      //START JInit
      this.PCHModuleName = new StringRef(JD$Move.INSTANCE, $Prm0.PCHModuleName);
      this.Path = new StringRef(JD$Move.INSTANCE, $Prm0.Path);
      this.ASTFile = new StringRef(JD$Move.INSTANCE, $Prm0.ASTFile);
      this.Signature = $Prm0.Signature;
      this.ClangModule = $Prm0.ClangModule;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "PCHModuleName=" + PCHModuleName // NOI18N
                + ", Path=" + Path // NOI18N
                + ", ASTFile=" + ASTFile // NOI18N
                + ", Signature=" + Signature // NOI18N
                + ", ClangModule=" + ClangModule; // NOI18N
    }
  };
  
  /// Return a descriptor for the corresponding module, if one exists.
  
  /// Return a descriptor for the corresponding module, if one exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::getSourceDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 26,
   FQN="clang::ExternalASTSource::getSourceDescriptor", NM="_ZN5clang17ExternalASTSource19getSourceDescriptorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19getSourceDescriptorEj")
  //</editor-fold>
  public Optional<ExternalASTSource.ASTSourceDescriptor> getSourceDescriptor(/*uint*/int ID) {
    return new Optional<ExternalASTSource.ASTSourceDescriptor>(None);
  }


  
  /// \brief Finds all declarations lexically contained within the given
  /// DeclContext, after applying an optional filter predicate.
  ///
  /// \param IsKindWeWant a predicate function that returns true if the passed
  /// declaration kind is one we are looking for.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Finds all declarations lexically contained within the given
  /// DeclContext, after applying an optional filter predicate.
  ///
  /// \param IsKindWeWant a predicate function that returns true if the passed
  /// declaration kind is one we are looking for.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::FindExternalLexicalDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 108,
   FQN="clang::ExternalASTSource::FindExternalLexicalDecls", NM="_ZN5clang17ExternalASTSource24FindExternalLexicalDeclsEPKNS_11DeclContextEN4llvm12function_refIFbNS_4Decl4KindEEEERNS4_15SmallVectorImplIPS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource24FindExternalLexicalDeclsEPKNS_11DeclContextEN4llvm12function_refIFbNS_4Decl4KindEEEERNS4_15SmallVectorImplIPS6_EE")
  //</editor-fold>
  public void FindExternalLexicalDecls(/*const*/ DeclContext /*P*/ DC, DeclKind2Bool IsKindWeWant, 
                          final SmallVectorImpl<Decl /*P*/ > /*&*/ Result) {
  }


  
  /// \brief Finds all declarations lexically contained within the given
  /// DeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::FindExternalLexicalDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 186,
   FQN="clang::ExternalASTSource::FindExternalLexicalDecls", NM="_ZN5clang17ExternalASTSource24FindExternalLexicalDeclsEPKNS_11DeclContextERN4llvm15SmallVectorImplIPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource24FindExternalLexicalDeclsEPKNS_11DeclContextERN4llvm15SmallVectorImplIPNS_4DeclEEE")
  //</editor-fold>
  public void FindExternalLexicalDecls(/*const*/ DeclContext /*P*/ DC, 
                          final SmallVectorImpl<Decl /*P*/ > /*&*/ Result) {
    FindExternalLexicalDecls(DC, /*FuncArg*//*[]*/ (Decl.Kind $Prm0) -> {
              return true;
            }, Result);
  }

  
  /// \brief Get the decls that are contained in a file in the Offset/Length
  /// range. \p Length can be 0 to indicate a point at \p Offset instead of
  /// a range.
  
  /// \brief Get the decls that are contained in a file in the Offset/Length
  /// range. \p Length can be 0 to indicate a point at \p Offset instead of
  /// a range.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::FindFileRegionDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 46,
   FQN="clang::ExternalASTSource::FindFileRegionDecls", NM="_ZN5clang17ExternalASTSource19FindFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19FindFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE")
  //</editor-fold>
  public void FindFileRegionDecls(FileID File, /*uint*/int Offset, 
                     /*uint*/int Length, 
                     final SmallVectorImpl<Decl /*P*/ > /*&*/ Decls) {
  }


  
  /// \brief Gives the external AST source an opportunity to complete
  /// the redeclaration chain for a declaration. Called each time we
  /// need the most recent declaration of a declaration after the
  /// generation count is incremented.
  
  /// \brief Gives the external AST source an opportunity to complete
  /// the redeclaration chain for a declaration. Called each time we
  /// need the most recent declaration of a declaration after the
  /// generation count is incremented.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::CompleteRedeclChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 50,
   FQN="clang::ExternalASTSource::CompleteRedeclChain", NM="_ZN5clang17ExternalASTSource19CompleteRedeclChainEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19CompleteRedeclChainEPKNS_4DeclE")
  //</editor-fold>
  public void CompleteRedeclChain(/*const*/ Decl /*P*/ D) {
  }


  
  /// \brief Gives the external AST source an opportunity to complete
  /// an incomplete type.
  
  /// \brief Gives the external AST source an opportunity to complete
  /// an incomplete type.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::CompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 52,
   FQN="clang::ExternalASTSource::CompleteType", NM="_ZN5clang17ExternalASTSource12CompleteTypeEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource12CompleteTypeEPNS_7TagDeclE")
  //</editor-fold>
  public void CompleteType(TagDecl /*P*/ Tag) {
  }


  
  /// \brief Gives the external AST source an opportunity to complete an
  /// incomplete Objective-C class.
  ///
  /// This routine will only be invoked if the "externally completed" bit is
  /// set on the ObjCInterfaceDecl via the function
  /// \c ObjCInterfaceDecl::setExternallyCompleted().
  
  /// \brief Gives the external AST source an opportunity to complete an
  /// incomplete Objective-C class.
  ///
  /// This routine will only be invoked if the "externally completed" bit is
  /// set on the ObjCInterfaceDecl via the function
  /// \c ObjCInterfaceDecl::setExternallyCompleted().
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::CompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 54,
   FQN="clang::ExternalASTSource::CompleteType", NM="_ZN5clang17ExternalASTSource12CompleteTypeEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource12CompleteTypeEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void CompleteType(ObjCInterfaceDecl /*P*/ Class) {
  }


  
  /// \brief Loads comment ranges.
  
  /// \brief Loads comment ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::ReadComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 56,
   FQN="clang::ExternalASTSource::ReadComments", NM="_ZN5clang17ExternalASTSource12ReadCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource12ReadCommentsEv")
  //</editor-fold>
  public void ReadComments() {
  }


  
  /// \brief Notify ExternalASTSource that we started deserialization of
  /// a decl or type so until FinishedDeserializing is called there may be
  /// decls that are initializing. Must be paired with FinishedDeserializing.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Notify ExternalASTSource that we started deserialization of
  /// a decl or type so until FinishedDeserializing is called there may be
  /// decls that are initializing. Must be paired with FinishedDeserializing.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::StartedDeserializing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 58,
   FQN="clang::ExternalASTSource::StartedDeserializing", NM="_ZN5clang17ExternalASTSource20StartedDeserializingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource20StartedDeserializingEv")
  //</editor-fold>
  public void StartedDeserializing() {
  }


  
  /// \brief Notify ExternalASTSource that we finished the deserialization of
  /// a decl or type. Must be paired with StartedDeserializing.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Notify ExternalASTSource that we finished the deserialization of
  /// a decl or type. Must be paired with StartedDeserializing.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::FinishedDeserializing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 60,
   FQN="clang::ExternalASTSource::FinishedDeserializing", NM="_ZN5clang17ExternalASTSource21FinishedDeserializingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource21FinishedDeserializingEv")
  //</editor-fold>
  public void FinishedDeserializing() {
  }


  
  /// \brief Function that will be invoked when we begin parsing a new
  /// translation unit involving this external AST source.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Function that will be invoked when we begin parsing a new
  /// translation unit involving this external AST source.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::StartTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 62,
   FQN="clang::ExternalASTSource::StartTranslationUnit", NM="_ZN5clang17ExternalASTSource20StartTranslationUnitEPNS_11ASTConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource20StartTranslationUnitEPNS_11ASTConsumerE")
  //</editor-fold>
  public void StartTranslationUnit(ASTConsumer /*P*/ Consumer) {
  }


  
  /// \brief Print any statistics that have been gathered regarding
  /// the external AST source.
  ///
  /// The default implementation of this method is a no-op.
  
  /// \brief Print any statistics that have been gathered regarding
  /// the external AST source.
  ///
  /// The default implementation of this method is a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 64,
   FQN="clang::ExternalASTSource::PrintStats", NM="_ZN5clang17ExternalASTSource10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() {
  }


  
  /// \brief Perform layout on the given record.
  ///
  /// This routine allows the external AST source to provide an specific 
  /// layout for a record, overriding the layout that would normally be
  /// constructed. It is intended for clients who receive specific layout
  /// details rather than source code (such as LLDB). The client is expected
  /// to fill in the field offsets, base offsets, virtual base offsets, and
  /// complete object size.
  ///
  /// \param Record The record whose layout is being requested.
  ///
  /// \param Size The final size of the record, in bits.
  ///
  /// \param Alignment The final alignment of the record, in bits.
  ///
  /// \param FieldOffsets The offset of each of the fields within the record,
  /// expressed in bits. All of the fields must be provided with offsets.
  ///
  /// \param BaseOffsets The offset of each of the direct, non-virtual base
  /// classes. If any bases are not given offsets, the bases will be laid 
  /// out according to the ABI.
  ///
  /// \param VirtualBaseOffsets The offset of each of the virtual base classes
  /// (either direct or not). If any bases are not given offsets, the bases will be laid 
  /// out according to the ABI.
  /// 
  /// \returns true if the record layout was provided, false otherwise.
  
  /// \brief Perform layout on the given record.
  ///
  /// This routine allows the external AST source to provide an specific 
  /// layout for a record, overriding the layout that would normally be
  /// constructed. It is intended for clients who receive specific layout
  /// details rather than source code (such as LLDB). The client is expected
  /// to fill in the field offsets, base offsets, virtual base offsets, and
  /// complete object size.
  ///
  /// \param Record The record whose layout is being requested.
  ///
  /// \param Size The final size of the record, in bits.
  ///
  /// \param Alignment The final alignment of the record, in bits.
  ///
  /// \param FieldOffsets The offset of each of the fields within the record,
  /// expressed in bits. All of the fields must be provided with offsets.
  ///
  /// \param BaseOffsets The offset of each of the direct, non-virtual base
  /// classes. If any bases are not given offsets, the bases will be laid 
  /// out according to the ABI.
  ///
  /// \param VirtualBaseOffsets The offset of each of the virtual base classes
  /// (either direct or not). If any bases are not given offsets, the bases will be laid 
  /// out according to the ABI.
  /// 
  /// \returns true if the record layout was provided, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::layoutRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 66,
   FQN="clang::ExternalASTSource::layoutRecordType", NM="_ZN5clang17ExternalASTSource16layoutRecordTypeEPKNS_10RecordDeclERyS4_RN4llvm8DenseMapIPKNS_9FieldDeclEyNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_yEEEERNS6_IPKNS_13CXXRecordDeclENS_9CharUnitsENSA_ISJ_EENSD_ISJ_SK_EEEESO_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource16layoutRecordTypeEPKNS_10RecordDeclERyS4_RN4llvm8DenseMapIPKNS_9FieldDeclEyNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_yEEEERNS6_IPKNS_13CXXRecordDeclENS_9CharUnitsENSA_ISJ_EENSD_ISJ_SK_EEEESO_")
  //</editor-fold>
  public boolean layoutRecordType(/*const*/ RecordDecl /*P*/ Record, final ulong$ref/*uint64_t &*/ Size, final ulong$ref/*uint64_t &*/ Alignment, 
                  final DenseMapTypeULong</*const*/ FieldDecl /*P*/>/*&*/ FieldOffsets, 
                  final DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ BaseOffsets, 
                  final DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ VirtualBaseOffsets) {
    return false;
  }


  
  //===--------------------------------------------------------------------===//
  // Queries for performance analysis.
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::MemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 282,
   FQN="clang::ExternalASTSource::MemoryBufferSizes", NM="_ZN5clang17ExternalASTSource17MemoryBufferSizesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource17MemoryBufferSizesE")
  //</editor-fold>
  public static class/*struct*/ MemoryBufferSizes {
    public /*size_t*/int malloc_bytes;
    public /*size_t*/int mmap_bytes;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::MemoryBufferSizes::MemoryBufferSizes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 286,
     FQN="clang::ExternalASTSource::MemoryBufferSizes::MemoryBufferSizes", NM="_ZN5clang17ExternalASTSource17MemoryBufferSizesC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource17MemoryBufferSizesC1Ejj")
    //</editor-fold>
    public MemoryBufferSizes(/*size_t*/int malloc_bytes, /*size_t*/int mmap_bytes) {
      // : malloc_bytes(malloc_bytes), mmap_bytes(mmap_bytes) 
      //START JInit
      this.malloc_bytes = malloc_bytes;
      this.mmap_bytes = mmap_bytes;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::MemoryBufferSizes::MemoryBufferSizes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 282,
     FQN="clang::ExternalASTSource::MemoryBufferSizes::MemoryBufferSizes", NM="_ZN5clang17ExternalASTSource17MemoryBufferSizesC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang17ExternalASTSource17MemoryBufferSizesC1EOS1_")
    //</editor-fold>
    public /*inline*/ MemoryBufferSizes(JD$Move _dparam, final MemoryBufferSizes /*&&*/$Prm0) {
      // : malloc_bytes(static_cast<MemoryBufferSizes &&>().malloc_bytes), mmap_bytes(static_cast<MemoryBufferSizes &&>().mmap_bytes) 
      //START JInit
      this.malloc_bytes = $Prm0.malloc_bytes;
      this.mmap_bytes = $Prm0.mmap_bytes;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::MemoryBufferSizes::~MemoryBufferSizes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 282,
     FQN="clang::ExternalASTSource::MemoryBufferSizes::~MemoryBufferSizes", NM="_ZN5clang17ExternalASTSource17MemoryBufferSizesD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang17ExternalASTSource17MemoryBufferSizesD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    @Override public String toString() {
      return "" + "malloc_bytes=" + malloc_bytes // NOI18N
                + ", mmap_bytes=" + mmap_bytes; // NOI18N
    }
  };
  
  /// Return the amount of memory used by memory buffers, breaking down
  /// by heap-backed versus mmap'ed memory.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::getMemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 292,
   FQN="clang::ExternalASTSource::getMemoryBufferSizes", NM="_ZNK5clang17ExternalASTSource20getMemoryBufferSizesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang17ExternalASTSource20getMemoryBufferSizesEv")
  //</editor-fold>
  public MemoryBufferSizes getMemoryBufferSizes() /*const*/ {
    MemoryBufferSizes sizes/*J*/= new MemoryBufferSizes(0, 0);
    getMemoryBufferSizes(sizes);
    return sizes;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::getMemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 112,
   FQN="clang::ExternalASTSource::getMemoryBufferSizes", NM="_ZNK5clang17ExternalASTSource20getMemoryBufferSizesERNS0_17MemoryBufferSizesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang17ExternalASTSource20getMemoryBufferSizesERNS0_17MemoryBufferSizesE")
  //</editor-fold>
  public void getMemoryBufferSizes(final MemoryBufferSizes /*&*/ sizes) /*const*/ {
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::SetExternalVisibleDeclsForName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1157,
   FQN="clang::ExternalASTSource::SetExternalVisibleDeclsForName", NM="_ZN5clang17ExternalASTSource30SetExternalVisibleDeclsForNameEPKNS_11DeclContextENS_15DeclarationNameEN4llvm8ArrayRefIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang17ExternalASTSource30SetExternalVisibleDeclsForNameEPKNS_11DeclContextENS_15DeclarationNameEN4llvm8ArrayRefIPNS_9NamedDeclEEE")
  //</editor-fold>
  protected static DeclContextLookupResult SetExternalVisibleDeclsForName(/*const*/ DeclContext /*P*/ DC, 
                                DeclarationName Name, 
                                ArrayRef<NamedDecl /*P*/ > Decls) {
    final ASTContext /*&*/ Context = DC.getParentASTContext();
    StoredDeclsMap /*P*/ Map;
    if (!((Map = DC.$DeclContext$Fields().LookupPtr) != null)) {
      Map = DC.CreateStoredDeclsMap(Context);
    }
    if (DC.$DeclContext$Fields().NeedToReconcileExternalVisibleStorage) {
      DC.reconcileExternalVisibleStorage();
    }
    
    final StoredDeclsList /*&*/ List = (/*Deref*/Map).$at_T1$C$R(Name);
    
    // Clear out any old external visible declarations, to avoid quadratic
    // performance in the redeclaration checks below.
    List.removeExternalDecls();
    if (!List.isNull()) {
      // We have both existing declarations and new declarations for this name.
      // Some of the declarations may simply replace existing ones. Handle those
      // first.
      SmallVectorUInt Skip/*J*/= new SmallVectorUInt(8, 0);
      for (/*uint*/int I = 0, N = Decls.size(); I != N; ++I)  {
        if (List.HandleRedeclaration(Decls.$at(I), /*IsKnownNewer*/ false)) {
          Skip.push_back(I);
        }
      }
      Skip.push_back(Decls.size());
      
      // Add in any new declarations.
      /*uint*/int SkipPos = 0;
      for (/*uint*/int I = 0, N = Decls.size(); I != N; ++I) {
        if (I == Skip.$at(SkipPos)) {
          ++SkipPos;
        } else {
          List.AddSubsequentDecl(Decls.$at(I));
        }
      }
    } else {
      // Convert the array to a StoredDeclsList.
      for (type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(Decls.begin()), /*P*/ E = $tryClone(Decls.end()); $noteq_ptr(I, E); I.$preInc()) {
        if (List.isNull()) {
          List.setOnlyValue(I.$star());
        } else {
          List.AddSubsequentDecl(I.$star());
        }
      }
    }
    
    return List.getLookupResult();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::SetNoExternalVisibleDeclsForName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1142,
   FQN="clang::ExternalASTSource::SetNoExternalVisibleDeclsForName", NM="_ZN5clang17ExternalASTSource32SetNoExternalVisibleDeclsForNameEPKNS_11DeclContextENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang17ExternalASTSource32SetNoExternalVisibleDeclsForNameEPKNS_11DeclContextENS_15DeclarationNameE")
  //</editor-fold>
  protected static DeclContextLookupResult SetNoExternalVisibleDeclsForName(/*const*/ DeclContext /*P*/ DC, 
                                  DeclarationName Name) {
    final ASTContext /*&*/ Context = DC.getParentASTContext();
    StoredDeclsMap /*P*/ Map;
    if (!((Map = DC.$DeclContext$Fields().LookupPtr) != null)) {
      Map = DC.CreateStoredDeclsMap(Context);
    }
    if (DC.$DeclContext$Fields().NeedToReconcileExternalVisibleStorage) {
      DC.reconcileExternalVisibleStorage();
    }
    
    ($Deref(Map)).$at_T1$C$R(Name).removeExternalDecls();
    
    return new DeclContextLookupResult();
  }


  
  /// \brief Increment the current generation.
  
  /// \brief Increment the current generation.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalASTSource::incrementGeneration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp", line = 114,
   FQN="clang::ExternalASTSource::incrementGeneration", NM="_ZN5clang17ExternalASTSource19incrementGenerationERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang17ExternalASTSource19incrementGenerationERNS_10ASTContextE")
  //</editor-fold>
  protected /*uint32_t*/int incrementGeneration(final ASTContext /*&*/ C) {
    /*uint32_t*/int OldGeneration = CurrentGeneration;
    
    // Make sure the generation of the topmost external source for the context is
    // incremented. That might not be us.
    ExternalASTSource /*P*/ P = C.getExternalSource();
    if ((P != null) && P != this) {
      CurrentGeneration = P.incrementGeneration(C);
    } else {
      // FIXME: Only bump the generation counter if the current generation number
      // has been observed?
      if (!(++CurrentGeneration != 0)) {
        llvm.report_fatal_error($("generation counter overflowed"), false);
      }
    }
    
    return OldGeneration;
  }


  
  @Override public String toString() {
    return "" + "CurrentGeneration=" + CurrentGeneration // NOI18N
              + ", SemaSource=" + SemaSource // NOI18N
              + super.toString(); // NOI18N
  }
}
