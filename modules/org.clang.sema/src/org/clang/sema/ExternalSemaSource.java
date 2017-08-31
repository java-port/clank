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

package org.clang.sema;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief An abstract interface that should be implemented by
/// external AST sources that also provide information for semantic
/// analysis.
//<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 53,
 FQN="clang::ExternalSemaSource", NM="_ZN5clang18ExternalSemaSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSourceE")
//</editor-fold>
public class ExternalSemaSource extends /*public*/ ExternalASTSource implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ExternalSemaSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 55,
   FQN="clang::ExternalSemaSource::ExternalSemaSource", NM="_ZN5clang18ExternalSemaSourceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSourceC1Ev")
  //</editor-fold>
  public ExternalSemaSource() {
    // : ExternalASTSource() 
    //START JInit
    super();
    //END JInit
    super.SemaSource = true;
  }  
  
  // Pin this vtable to this file.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::~ExternalSemaSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1253,
   FQN="clang::ExternalSemaSource::~ExternalSemaSource", NM="_ZN5clang18ExternalSemaSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSourceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  /// \brief Initialize the semantic source with the Sema instance
  /// being used to perform semantic analysis on the abstract syntax
  /// tree.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::InitializeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 64,
   FQN="clang::ExternalSemaSource::InitializeSema", NM="_ZN5clang18ExternalSemaSource14InitializeSemaERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource14InitializeSemaERNS_4SemaE")
  //</editor-fold>
  public /*virtual*/ void InitializeSema(final Sema /*&*/ S) {
  }

  
  /// \brief Inform the semantic consumer that Sema is no longer available.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ForgetSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 67,
   FQN="clang::ExternalSemaSource::ForgetSema", NM="_ZN5clang18ExternalSemaSource10ForgetSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource10ForgetSemaEv")
  //</editor-fold>
  public /*virtual*/ void ForgetSema() {
  }

  
  /// \brief Load the contents of the global method pool for a given
  /// selector.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadMethodPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1255,
   FQN="clang::ExternalSemaSource::ReadMethodPool", NM="_ZN5clang18ExternalSemaSource14ReadMethodPoolENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource14ReadMethodPoolENS_8SelectorE")
  //</editor-fold>
  public void ReadMethodPool(Selector Sel) {
  }

  
  /// Load the contents of the global method pool for a given
  /// selector if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::updateOutOfDateSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1256,
   FQN="clang::ExternalSemaSource::updateOutOfDateSelector", NM="_ZN5clang18ExternalSemaSource23updateOutOfDateSelectorENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource23updateOutOfDateSelectorENS_8SelectorE")
  //</editor-fold>
  public void updateOutOfDateSelector(Selector Sel) {
  }

  
  /// \brief Load the set of namespaces that are known to the external source,
  /// which will be used during typo correction.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadKnownNamespaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1258,
   FQN="clang::ExternalSemaSource::ReadKnownNamespaces", NM="_ZN5clang18ExternalSemaSource19ReadKnownNamespacesERN4llvm15SmallVectorImplIPNS_13NamespaceDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource19ReadKnownNamespacesERN4llvm15SmallVectorImplIPNS_13NamespaceDeclEEE")
  //</editor-fold>
  public void ReadKnownNamespaces(final SmallVectorImpl<NamespaceDecl /*P*/ > /*&*/ Namespaces) {
  }

  
  /// \brief Load the set of used but not defined functions or variables with
  /// internal linkage, or used but not defined internal functions.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadUndefinedButUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1262,
   FQN="clang::ExternalSemaSource::ReadUndefinedButUsed", NM="_ZN5clang18ExternalSemaSource20ReadUndefinedButUsedERN4llvm9MapVectorIPNS_9NamedDeclENS_14SourceLocationENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S5_ESaISF_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource20ReadUndefinedButUsedERN4llvm9MapVectorIPNS_9NamedDeclENS_14SourceLocationENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S5_ESaISF_EEEE")
  //</editor-fold>
  public void ReadUndefinedButUsed(final MapVectorPtrType<NamedDecl /*P*/ , SourceLocation> /*&*/ Undefined) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadMismatchingDeleteExpressions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1265,
   FQN="clang::ExternalSemaSource::ReadMismatchingDeleteExpressions", NM="_ZN5clang18ExternalSemaSource32ReadMismatchingDeleteExpressionsERN4llvm9MapVectorIPNS_9FieldDeclENS1_11SmallVectorISt4pairINS_14SourceLocationEbELj4EEENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorIS6_IS4_S9_ESaISI_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource32ReadMismatchingDeleteExpressionsERN4llvm9MapVectorIPNS_9FieldDeclENS1_11SmallVectorISt4pairINS_14SourceLocationEbELj4EEENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorIS6_IS4_S9_ESaISI_EEEE")
  //</editor-fold>
  public void ReadMismatchingDeleteExpressions(final MapVectorPtrType<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> > /*&*/ $Prm0) {
  }

  
  /// \brief Do last resort, unqualified lookup on a LookupResult that
  /// Sema cannot find.
  ///
  /// \param R a LookupResult that is being recovered.
  ///
  /// \param S the Scope of the identifier occurrence.
  ///
  /// \return true to tell Sema to recover using the LookupResult.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::LookupUnqualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 98,
   FQN="clang::ExternalSemaSource::LookupUnqualified", NM="_ZN5clang18ExternalSemaSource17LookupUnqualifiedERNS_12LookupResultEPNS_5ScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource17LookupUnqualifiedERNS_12LookupResultEPNS_5ScopeE")
  //</editor-fold>
  public /*virtual*/ boolean LookupUnqualified(final LookupResult /*&*/ R, Scope /*P*/ S) {
    return false;
  }

  
  /// \brief Read the set of tentative definitions known to the external Sema
  /// source.
  ///
  /// The external source should append its own tentative definitions to the
  /// given vector of tentative definitions. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadTentativeDefinitions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 107,
   FQN="clang::ExternalSemaSource::ReadTentativeDefinitions", NM="_ZN5clang18ExternalSemaSource24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIPNS_7VarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIPNS_7VarDeclEEE")
  //</editor-fold>
  public /*virtual*/ void ReadTentativeDefinitions(final SmallVectorImpl<VarDecl /*P*/ > /*&*/ TentativeDefs) {
  }

  
  /// \brief Read the set of unused file-scope declarations known to the
  /// external Sema source.
  ///
  /// The external source should append its own unused, filed-scope to the
  /// given vector of declarations. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadUnusedFileScopedDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 117,
   FQN="clang::ExternalSemaSource::ReadUnusedFileScopedDecls", NM="_ZN5clang18ExternalSemaSource25ReadUnusedFileScopedDeclsERN4llvm15SmallVectorImplIPKNS_14DeclaratorDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource25ReadUnusedFileScopedDeclsERN4llvm15SmallVectorImplIPKNS_14DeclaratorDeclEEE")
  //</editor-fold>
  public /*virtual*/ void ReadUnusedFileScopedDecls(final SmallVectorImpl</*const*/ DeclaratorDecl /*P*/ > /*&*/ Decls) {
  }

  
  /// \brief Read the set of delegating constructors known to the
  /// external Sema source.
  ///
  /// The external source should append its own delegating constructors to the
  /// given vector of declarations. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadDelegatingConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 127,
   FQN="clang::ExternalSemaSource::ReadDelegatingConstructors", NM="_ZN5clang18ExternalSemaSource26ReadDelegatingConstructorsERN4llvm15SmallVectorImplIPNS_18CXXConstructorDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource26ReadDelegatingConstructorsERN4llvm15SmallVectorImplIPNS_18CXXConstructorDeclEEE")
  //</editor-fold>
  public /*virtual*/ void ReadDelegatingConstructors(final SmallVectorImpl<CXXConstructorDecl /*P*/ > /*&*/ Decls) {
  }

  
  /// \brief Read the set of ext_vector type declarations known to the
  /// external Sema source.
  ///
  /// The external source should append its own ext_vector type declarations to
  /// the given vector of declarations. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadExtVectorDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 137,
   FQN="clang::ExternalSemaSource::ReadExtVectorDecls", NM="_ZN5clang18ExternalSemaSource18ReadExtVectorDeclsERN4llvm15SmallVectorImplIPNS_15TypedefNameDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource18ReadExtVectorDeclsERN4llvm15SmallVectorImplIPNS_15TypedefNameDeclEEE")
  //</editor-fold>
  public /*virtual*/ void ReadExtVectorDecls(final SmallVectorImpl<TypedefNameDecl /*P*/ > /*&*/ Decls) {
  }

  
  /// \brief Read the set of potentially unused typedefs known to the source.
  ///
  /// The external source should append its own potentially unused local
  /// typedefs to the given vector of declarations. Note that this routine may
  /// be invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadUnusedLocalTypedefNameCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 145,
   FQN="clang::ExternalSemaSource::ReadUnusedLocalTypedefNameCandidates", NM="_ZN5clang18ExternalSemaSource36ReadUnusedLocalTypedefNameCandidatesERN4llvm14SmallSetVectorIPKNS_15TypedefNameDeclELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource36ReadUnusedLocalTypedefNameCandidatesERN4llvm14SmallSetVectorIPKNS_15TypedefNameDeclELj4EEE")
  //</editor-fold>
  public /*virtual*/ void ReadUnusedLocalTypedefNameCandidates(final SmallSetVector</*const*/ TypedefNameDecl /*P*/> /*&*/ Decls) {
  }

  
  /// \brief Read the set of referenced selectors known to the
  /// external Sema source.
  ///
  /// The external source should append its own referenced selectors to the 
  /// given vector of selectors. Note that this routine 
  /// may be invoked multiple times; the external source should take care not 
  /// to introduce the same selectors repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadReferencedSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 155,
   FQN="clang::ExternalSemaSource::ReadReferencedSelectors", NM="_ZN5clang18ExternalSemaSource23ReadReferencedSelectorsERN4llvm15SmallVectorImplISt4pairINS_8SelectorENS_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource23ReadReferencedSelectorsERN4llvm15SmallVectorImplISt4pairINS_8SelectorENS_14SourceLocationEEEE")
  //</editor-fold>
  public /*virtual*/ void ReadReferencedSelectors(final SmallVectorImpl<std.pairTypeType<Selector, SourceLocation> > /*&*/ Sels) {
  }

  
  /// \brief Read the set of weak, undeclared identifiers known to the
  /// external Sema source.
  ///
  /// The external source should append its own weak, undeclared identifiers to
  /// the given vector. Note that this routine may be invoked multiple times; 
  /// the external source should take care not to introduce the same identifiers
  /// repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadWeakUndeclaredIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 165,
   FQN="clang::ExternalSemaSource::ReadWeakUndeclaredIdentifiers", NM="_ZN5clang18ExternalSemaSource29ReadWeakUndeclaredIdentifiersERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoENS_8WeakInfoEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource29ReadWeakUndeclaredIdentifiersERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoENS_8WeakInfoEEEE")
  //</editor-fold>
  public /*virtual*/ void ReadWeakUndeclaredIdentifiers(final SmallVectorImpl<std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo> > /*&*/ WI) {
  }

  
  /// \brief Read the set of used vtables known to the external Sema source.
  ///
  /// The external source should append its own used vtables to the given
  /// vector. Note that this routine may be invoked multiple times; the external
  /// source should take care not to introduce the same vtables repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadUsedVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 173,
   FQN="clang::ExternalSemaSource::ReadUsedVTables", NM="_ZN5clang18ExternalSemaSource15ReadUsedVTablesERN4llvm15SmallVectorImplINS_17ExternalVTableUseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource15ReadUsedVTablesERN4llvm15SmallVectorImplINS_17ExternalVTableUseEEE")
  //</editor-fold>
  public /*virtual*/ void ReadUsedVTables(final SmallVectorImpl<ExternalVTableUse> /*&*/ VTables) {
  }

  
  /// \brief Read the set of pending instantiations known to the external
  /// Sema source.
  ///
  /// The external source should append its own pending instantiations to the
  /// given vector. Note that this routine may be invoked multiple times; the
  /// external source should take care not to introduce the same instantiations
  /// repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadPendingInstantiations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 182,
   FQN="clang::ExternalSemaSource::ReadPendingInstantiations", NM="_ZN5clang18ExternalSemaSource25ReadPendingInstantiationsERN4llvm15SmallVectorImplISt4pairIPNS_9ValueDeclENS_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource25ReadPendingInstantiationsERN4llvm15SmallVectorImplISt4pairIPNS_9ValueDeclENS_14SourceLocationEEEE")
  //</editor-fold>
  public /*virtual*/ void ReadPendingInstantiations(final SmallVectorImpl<std.pair<ValueDecl /*P*/ , SourceLocation> > /*&*/ Pending) {
  }

  
  /// \brief Read the set of late parsed template functions for this source.
  ///
  /// The external source should insert its own late parsed template functions
  /// into the map. Note that this routine may be invoked multiple times; the
  /// external source should take care not to introduce the same map entries
  /// repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::ReadLateParsedTemplates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 192,
   FQN="clang::ExternalSemaSource::ReadLateParsedTemplates", NM="_ZN5clang18ExternalSemaSource23ReadLateParsedTemplatesERN4llvm9MapVectorIPKNS_12FunctionDeclEPNS_18LateParsedTemplateENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource23ReadLateParsedTemplatesERN4llvm9MapVectorIPKNS_12FunctionDeclEPNS_18LateParsedTemplateENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE")
  //</editor-fold>
  public /*virtual*/ void ReadLateParsedTemplates(final MapVectorPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ > /*&*/ LPTMap) {
  }

  
  /// \copydoc Sema::CorrectTypo
  /// \note LookupKind must correspond to a valid Sema::LookupNameKind
  ///
  /// ExternalSemaSource::CorrectTypo is always given the first chance to
  /// correct a typo (really, to offer suggestions to repair a failed lookup).
  /// It will even be called when SpellChecking is turned off or after a
  /// fatal error has already been detected.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::CorrectTypo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 202,
   FQN="clang::ExternalSemaSource::CorrectTypo", NM="_ZN5clang18ExternalSemaSource11CorrectTypoERKNS_19DeclarationNameInfoEiPNS_5ScopeEPNS_12CXXScopeSpecERNS_27CorrectionCandidateCallbackEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource11CorrectTypoERKNS_19DeclarationNameInfoEiPNS_5ScopeEPNS_12CXXScopeSpecERNS_27CorrectionCandidateCallbackEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE")
  //</editor-fold>
  public /*virtual*/ TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ Typo, 
             int LookupKind, Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
             final CorrectionCandidateCallback /*&*/ CCC, 
             DeclContext /*P*/ MemberContext, 
             boolean EnteringContext, 
             /*const*/ ObjCObjectPointerType /*P*/ OPT) {
    return new TypoCorrection();
  }

  
  /// \brief Produces a diagnostic note if the external source contains a
  /// complete definition for \p T.
  ///
  /// \param Loc the location at which a complete type was required but not
  /// provided
  ///
  /// \param T the \c QualType that should have been complete at \p Loc
  ///
  /// \return true if a diagnostic was produced, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::MaybeDiagnoseMissingCompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 220,
   FQN="clang::ExternalSemaSource::MaybeDiagnoseMissingCompleteType", NM="_ZN5clang18ExternalSemaSource32MaybeDiagnoseMissingCompleteTypeENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource32MaybeDiagnoseMissingCompleteTypeENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public /*virtual*/ boolean MaybeDiagnoseMissingCompleteType(SourceLocation Loc, 
                                  QualType T) {
    return false;
  }

  
  // isa/cast/dyn_cast support
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalSemaSource::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ExternalSemaSource.h", line = 226,
   FQN="clang::ExternalSemaSource::classof", NM="_ZN5clang18ExternalSemaSource7classofEPKNS_17ExternalASTSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18ExternalSemaSource7classofEPKNS_17ExternalASTSourceE")
  //</editor-fold>
  public static boolean classof(/*const*/ ExternalASTSource /*P*/ Source) {
    return Source.SemaSource;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
