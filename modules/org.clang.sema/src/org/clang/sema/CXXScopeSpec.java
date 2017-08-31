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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief Represents a C++ nested-name-specifier or a global scope specifier.
///
/// These can be in 3 states:
///   1) Not present, identified by isEmpty()
///   2) Present, identified by isNotEmpty()
///      2.a) Valid, identified by isValid()
///      2.b) Invalid, identified by isInvalid().
///
/// isSet() is deprecated because it mostly corresponded to "valid" but was
/// often used as if it meant "present".
///
/// The actual scope is described by getScopeRep().
//<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
 FQN="clang::CXXScopeSpec", NM="_ZN5clang12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpecE")
//</editor-fold>
public class CXXScopeSpec implements Destructors.ClassWithDestructor {
  private SourceRange Range;
  private NestedNameSpecifierLocBuilder Builder;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 68,
   FQN="clang::CXXScopeSpec::getRange", NM="_ZNK5clang12CXXScopeSpec8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec8getRangeEv")
  //</editor-fold>
  public SourceRange getRange() /*const*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::setRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 69,
   FQN="clang::CXXScopeSpec::setRange", NM="_ZN5clang12CXXScopeSpec8setRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec8setRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setRange(SourceRange R) {
    Range.$assign(R);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::setBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 70,
   FQN="clang::CXXScopeSpec::setBeginLoc", NM="_ZN5clang12CXXScopeSpec11setBeginLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec11setBeginLocENS_14SourceLocationE")
  //</editor-fold>
  public void setBeginLoc(SourceLocation Loc) {
    Range.setBegin(/*NO_COPY*/Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::setEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 71,
   FQN="clang::CXXScopeSpec::setEndLoc", NM="_ZN5clang12CXXScopeSpec9setEndLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec9setEndLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEndLoc(SourceLocation Loc) {
    Range.setEnd(/*NO_COPY*/Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::getBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 72,
   FQN="clang::CXXScopeSpec::getBeginLoc", NM="_ZNK5clang12CXXScopeSpec11getBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec11getBeginLocEv")
  //</editor-fold>
  public SourceLocation getBeginLoc() /*const*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 73,
   FQN="clang::CXXScopeSpec::getEndLoc", NM="_ZNK5clang12CXXScopeSpec9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return Range.getEnd();
  }

  
  /// \brief Retrieve the representation of the nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::getScopeRep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 76,
   FQN="clang::CXXScopeSpec::getScopeRep", NM="_ZNK5clang12CXXScopeSpec11getScopeRepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec11getScopeRepEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getScopeRep() /*const*/ {
    return Builder.getRepresentation();
  }

  
  /// \brief Extend the current nested-name-specifier by another
  /// nested-name-specifier component of the form 'type::'.
  ///
  /// \param Context The AST context in which this nested-name-specifier
  /// resides.
  ///
  /// \param TemplateKWLoc The location of the 'template' keyword, if present.
  ///
  /// \param TL The TypeLoc that describes the type preceding the '::'.
  ///
  /// \param ColonColonLoc The location of the trailing '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::Extend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 47,
   FQN="clang::CXXScopeSpec::Extend", NM="_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextENS_14SourceLocationENS_7TypeLocES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextENS_14SourceLocationENS_7TypeLocES3_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, SourceLocation TemplateKWLoc, 
        TypeLoc TL, SourceLocation ColonColonLoc) {
    Builder.Extend(Context, new SourceLocation(TemplateKWLoc), new TypeLoc(TL), new SourceLocation(ColonColonLoc));
    if (Range.getBegin().isInvalid()) {
      Range.setBegin(TL.getBeginLoc());
    }
    Range.setEnd(/*NO_COPY*/ColonColonLoc);
    assert (Range.$eq(Builder.getSourceRange())) : "NestedNameSpecifierLoc range computation incorrect";
  }

  
  /// \brief Extend the current nested-name-specifier by another 
  /// nested-name-specifier component of the form 'identifier::'.
  ///
  /// \param Context The AST context in which this nested-name-specifier
  /// resides.
  ///
  /// \param Identifier The identifier.
  ///
  /// \param IdentifierLoc The location of the identifier.
  ///
  /// \param ColonColonLoc The location of the trailing '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::Extend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 58,
   FQN="clang::CXXScopeSpec::Extend", NM="_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextEPNS_14IdentifierInfoENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextEPNS_14IdentifierInfoENS_14SourceLocationES5_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, IdentifierInfo /*P*/ Identifier, 
        SourceLocation IdentifierLoc, 
        SourceLocation ColonColonLoc) {
    Builder.Extend(Context, Identifier, new SourceLocation(IdentifierLoc), new SourceLocation(ColonColonLoc));
    if (Range.getBegin().isInvalid()) {
      Range.setBegin(/*NO_COPY*/IdentifierLoc);
    }
    Range.setEnd(/*NO_COPY*/ColonColonLoc);
    assert (Range.$eq(Builder.getSourceRange())) : "NestedNameSpecifierLoc range computation incorrect";
  }

  
  /// \brief Extend the current nested-name-specifier by another 
  /// nested-name-specifier component of the form 'namespace::'.
  ///
  /// \param Context The AST context in which this nested-name-specifier
  /// resides.
  ///
  /// \param Namespace The namespace.
  ///
  /// \param NamespaceLoc The location of the namespace name.
  ///
  /// \param ColonColonLoc The location of the trailing '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::Extend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 71,
   FQN="clang::CXXScopeSpec::Extend", NM="_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextEPNS_13NamespaceDeclENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextEPNS_13NamespaceDeclENS_14SourceLocationES5_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, NamespaceDecl /*P*/ Namespace, 
        SourceLocation NamespaceLoc, 
        SourceLocation ColonColonLoc) {
    Builder.Extend(Context, Namespace, new SourceLocation(NamespaceLoc), new SourceLocation(ColonColonLoc));
    if (Range.getBegin().isInvalid()) {
      Range.setBegin(/*NO_COPY*/NamespaceLoc);
    }
    Range.setEnd(/*NO_COPY*/ColonColonLoc);
    assert (Range.$eq(Builder.getSourceRange())) : "NestedNameSpecifierLoc range computation incorrect";
  }

  
  /// \brief Extend the current nested-name-specifier by another 
  /// nested-name-specifier component of the form 'namespace-alias::'.
  ///
  /// \param Context The AST context in which this nested-name-specifier
  /// resides.
  ///
  /// \param Alias The namespace alias.
  ///
  /// \param AliasLoc The location of the namespace alias 
  /// name.
  ///
  /// \param ColonColonLoc The location of the trailing '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::Extend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 84,
   FQN="clang::CXXScopeSpec::Extend", NM="_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextEPNS_18NamespaceAliasDeclENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec6ExtendERNS_10ASTContextEPNS_18NamespaceAliasDeclENS_14SourceLocationES5_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, NamespaceAliasDecl /*P*/ Alias, 
        SourceLocation AliasLoc, 
        SourceLocation ColonColonLoc) {
    Builder.Extend(Context, Alias, new SourceLocation(AliasLoc), new SourceLocation(ColonColonLoc));
    if (Range.getBegin().isInvalid()) {
      Range.setBegin(/*NO_COPY*/AliasLoc);
    }
    Range.setEnd(/*NO_COPY*/ColonColonLoc);
    assert (Range.$eq(Builder.getSourceRange())) : "NestedNameSpecifierLoc range computation incorrect";
  }

  
  /// \brief Turn this (empty) nested-name-specifier into the global
  /// nested-name-specifier '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::MakeGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 97,
   FQN="clang::CXXScopeSpec::MakeGlobal", NM="_ZN5clang12CXXScopeSpec10MakeGlobalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec10MakeGlobalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void MakeGlobal(final ASTContext /*&*/ Context, 
            SourceLocation ColonColonLoc) {
    Builder.MakeGlobal(Context, new SourceLocation(ColonColonLoc));
    
    Range.$assignMove(new SourceRange(/*NO_COPY*/ColonColonLoc));
    assert (Range.$eq(Builder.getSourceRange())) : "NestedNameSpecifierLoc range computation incorrect";
  }

  
  /// \brief Turns this (empty) nested-name-specifier into '__super'
  /// nested-name-specifier.
  ///
  /// \param Context The AST context in which this nested-name-specifier
  /// resides.
  ///
  /// \param RD The declaration of the class in which nested-name-specifier
  /// appeared.
  ///
  /// \param SuperLoc The location of the '__super' keyword.
  /// name.
  ///
  /// \param ColonColonLoc The location of the trailing '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::MakeSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 107,
   FQN="clang::CXXScopeSpec::MakeSuper", NM="_ZN5clang12CXXScopeSpec9MakeSuperERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec9MakeSuperERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationES5_")
  //</editor-fold>
  public void MakeSuper(final ASTContext /*&*/ Context, CXXRecordDecl /*P*/ RD, 
           SourceLocation SuperLoc, 
           SourceLocation ColonColonLoc) {
    Builder.MakeSuper(Context, RD, new SourceLocation(SuperLoc), new SourceLocation(ColonColonLoc));
    
    Range.setBegin(/*NO_COPY*/SuperLoc);
    Range.setEnd(/*NO_COPY*/ColonColonLoc);
    assert (Range.$eq(Builder.getSourceRange())) : "NestedNameSpecifierLoc range computation incorrect";
  }

  
  /// \brief Make a new nested-name-specifier from incomplete source-location
  /// information.
  ///
  /// FIXME: This routine should be used very, very rarely, in cases where we
  /// need to synthesize a nested-name-specifier. Most code should instead use
  /// \c Adopt() with a proper \c NestedNameSpecifierLoc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::MakeTrivial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 119,
   FQN="clang::CXXScopeSpec::MakeTrivial", NM="_ZN5clang12CXXScopeSpec11MakeTrivialERNS_10ASTContextEPNS_19NestedNameSpecifierENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec11MakeTrivialERNS_10ASTContextEPNS_19NestedNameSpecifierENS_11SourceRangeE")
  //</editor-fold>
  public void MakeTrivial(final ASTContext /*&*/ Context, 
             NestedNameSpecifier /*P*/ Qualifier, SourceRange R) {
    Builder.MakeTrivial(Context, Qualifier, new SourceRange(R));
    Range.$assign(R);
  }

  
  /// \brief Adopt an existing nested-name-specifier (with source-range 
  /// information).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::Adopt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 125,
   FQN="clang::CXXScopeSpec::Adopt", NM="_ZN5clang12CXXScopeSpec5AdoptENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec5AdoptENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void Adopt(NestedNameSpecifierLoc Other) {
    if (!Other.$bool()) {
      Range.$assignMove(new SourceRange());
      Builder.Clear();
      return;
    }
    
    Range.$assignMove(Other.getSourceRange());
    Builder.Adopt(new NestedNameSpecifierLoc(Other));
  }

  
  /// \brief Retrieve a nested-name-specifier with location information, copied
  /// into the given AST context.
  ///
  /// \param Context The context into which this nested-name-specifier will be
  /// copied.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::getWithLocInContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 142,
   FQN="clang::CXXScopeSpec::getWithLocInContext", NM="_ZNK5clang12CXXScopeSpec19getWithLocInContextERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec19getWithLocInContextERNS_10ASTContextE")
  //</editor-fold>
  public NestedNameSpecifierLoc getWithLocInContext(final ASTContext /*&*/ Context) /*const*/ {
    if (!(Builder.getRepresentation() != null)) {
      return new NestedNameSpecifierLoc();
    }
    
    return Builder.getWithLocInContext(Context);
  }

  
  /// \brief Retrieve the location of the name in the last qualifier
  /// in this nested name specifier.
  ///
  /// For example, the location of \c bar
  /// in
  /// \verbatim
  ///   \::foo::bar<0>::
  ///           ^~~
  /// \endverbatim
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::getLastQualifierNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 136,
   FQN="clang::CXXScopeSpec::getLastQualifierNameLoc", NM="_ZNK5clang12CXXScopeSpec23getLastQualifierNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec23getLastQualifierNameLocEv")
  //</editor-fold>
  public SourceLocation getLastQualifierNameLoc() /*const*/ {
    if (!(Builder.getRepresentation() != null)) {
      return new SourceLocation();
    }
    return Builder.getTemporary().getLocalBeginLoc();
  }

  
  /// No scope specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 189,
   FQN="clang::CXXScopeSpec::isEmpty", NM="_ZNK5clang12CXXScopeSpec7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return !Range.isValid();
  }

  /// A scope specifier is present, but may be valid or invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::isNotEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 191,
   FQN="clang::CXXScopeSpec::isNotEmpty", NM="_ZNK5clang12CXXScopeSpec10isNotEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec10isNotEmptyEv")
  //</editor-fold>
  public boolean isNotEmpty() /*const*/ {
    return !isEmpty();
  }

  
  /// An error occurred during parsing of the scope specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 194,
   FQN="clang::CXXScopeSpec::isInvalid", NM="_ZNK5clang12CXXScopeSpec9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return isNotEmpty() && getScopeRep() == null;
  }

  /// A scope specifier is present, and it refers to a real scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 196,
   FQN="clang::CXXScopeSpec::isValid", NM="_ZNK5clang12CXXScopeSpec7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return isNotEmpty() && getScopeRep() != null;
  }

  
  /// \brief Indicate that this nested-name-specifier is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::SetInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 199,
   FQN="clang::CXXScopeSpec::SetInvalid", NM="_ZN5clang12CXXScopeSpec10SetInvalidENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec10SetInvalidENS_11SourceRangeE")
  //</editor-fold>
  public void SetInvalid(SourceRange R) {
    assert (R.isValid()) : "Must have a valid source range";
    if (Range.getBegin().isInvalid()) {
      Range.setBegin(R.getBegin());
    }
    Range.setEnd(R.getEnd());
    Builder.Clear();
  }

  
  /// Deprecated.  Some call sites intend isNotEmpty() while others intend
  /// isValid().
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::isSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 209,
   FQN="clang::CXXScopeSpec::isSet", NM="_ZNK5clang12CXXScopeSpec5isSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec5isSetEv")
  //</editor-fold>
  public boolean isSet() /*const*/ {
    return getScopeRep() != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 211,
   FQN="clang::CXXScopeSpec::clear", NM="_ZN5clang12CXXScopeSpec5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpec5clearEv")
  //</editor-fold>
  public void clear() {
    Range.$assignMove(new SourceRange());
    Builder.Clear();
  }

  
  /// \brief Retrieve the data associated with the source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::location_data">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 217,
   FQN="clang::CXXScopeSpec::location_data", NM="_ZNK5clang12CXXScopeSpec13location_dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec13location_dataEv")
  //</editor-fold>
  public type$ptr<?>/*char P*/ location_data() /*const*/ {
    return Builder.getBuffer().first;
  }

  
  /// \brief Retrieve the size of the data associated with source-location 
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::location_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 221,
   FQN="clang::CXXScopeSpec::location_size", NM="_ZNK5clang12CXXScopeSpec13location_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12CXXScopeSpec13location_sizeEv")
  //</editor-fold>
  public /*uint*/int location_size() /*const*/ {
    return Builder.getBuffer().second;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::~CXXScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
   FQN="clang::CXXScopeSpec::~CXXScopeSpec", NM="_ZN5clang12CXXScopeSpecD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpecD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Builder.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::CXXScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
   FQN="clang::CXXScopeSpec::CXXScopeSpec", NM="_ZN5clang12CXXScopeSpecC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpecC1Ev")
  //</editor-fold>
  public /*inline*/ CXXScopeSpec() {
    // : Range(), Builder() 
    //START JInit
    this.Range = new SourceRange();
    this.Builder = new NestedNameSpecifierLocBuilder();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::CXXScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
   FQN="clang::CXXScopeSpec::CXXScopeSpec", NM="_ZN5clang12CXXScopeSpecC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12CXXScopeSpecC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CXXScopeSpec(final /*const*/ CXXScopeSpec /*&*/ $Prm0) {
    // : Range(.Range), Builder(.Builder) 
    //START JInit
    this.Range = new SourceRange($Prm0.Range);
    this.Builder = new NestedNameSpecifierLocBuilder($Prm0.Builder);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::CXXScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
   FQN="clang::CXXScopeSpec::CXXScopeSpec", NM="_ZN5clang12CXXScopeSpecC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang12CXXScopeSpecC1EOS0_")
  //</editor-fold>
  public /*inline*/ CXXScopeSpec(JD$Move _dparam, final CXXScopeSpec /*&&*/$Prm0) {
    // : Range(static_cast<CXXScopeSpec &&>().Range), Builder(static_cast<CXXScopeSpec &&>().Builder) 
    //START JInit
    this.Range = new SourceRange(JD$Move.INSTANCE, $Prm0.Range);
    this.Builder = new NestedNameSpecifierLocBuilder($Prm0.Builder);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
   FQN="clang::CXXScopeSpec::operator=", NM="_ZN5clang12CXXScopeSpecaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang12CXXScopeSpecaSEOS0_")
  //</editor-fold>
  public /*inline*/ CXXScopeSpec /*&*/ $assignMove(final CXXScopeSpec /*&&*/$Prm0) {
    this.Range.$assignMove($Prm0.Range);
    this.Builder.$assign($Prm0.Builder);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXScopeSpec::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 63,
   FQN="clang::CXXScopeSpec::operator=", NM="_ZN5clang12CXXScopeSpecaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang12CXXScopeSpecaSERKS0_")
  //</editor-fold>
  public /*inline*/ CXXScopeSpec /*&*/ $assign(final /*const*/ CXXScopeSpec /*&*/ $Prm0) {
    this.Range.$assign($Prm0.Range);
    this.Builder.$assign($Prm0.Builder);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void $MemoryCopy(final /*const*/ CXXScopeSpec /*&*/ Other) {
    this.Range.$assign(Other.Range); // It is ok to use assign here
    this.Builder.$MemoryCopy(Other.Builder);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", Builder=" + "[NestedNameSpecifierLocBuilder]"; // NOI18N
  }
}
