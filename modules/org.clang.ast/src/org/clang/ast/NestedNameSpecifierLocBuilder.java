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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.impl.NestedNameSpecifierStatics.*;

/// \brief Class that aids in the construction of nested-name-specifiers along
/// with source-location information for all of the components of the
/// nested-name-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 339,
 FQN="clang::NestedNameSpecifierLocBuilder", NM="_ZN5clang29NestedNameSpecifierLocBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilderE")
//</editor-fold>
public class NestedNameSpecifierLocBuilder implements Destructors.ClassWithDestructor {
  /// \brief The current representation of the nested-name-specifier we're
  /// building.
  private NestedNameSpecifier /*P*/ Representation;
  
  /// \brief Buffer used to store source-location information for the
  /// nested-name-specifier.
  ///
  /// Note that we explicitly manage the buffer (rather than using a
  /// SmallVector) because \c Declarator expects it to be possible to memcpy()
  /// a \c CXXScopeSpec, and CXXScopeSpec uses a NestedNameSpecifierLocBuilder.
  private type$ptr<?>/*char P*/ Buffer; // JAVA: changed to pointer of objects
  
  /// \brief The size of the buffer used to store source-location information
  /// for the nested-name-specifier.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private uint$ref/*uint*/ BufferSize;
  
  /// \brief The capacity of the buffer used to store source-location
  /// information for the nested-name-specifier.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private uint$ref/*uint*/ BufferCapacity;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::NestedNameSpecifierLocBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 361,
   FQN="clang::NestedNameSpecifierLocBuilder::NestedNameSpecifierLocBuilder", NM="_ZN5clang29NestedNameSpecifierLocBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilderC1Ev")
  //</editor-fold>
  public NestedNameSpecifierLocBuilder() {
    // : Representation(null), Buffer(null), BufferSize(0), BufferCapacity(0) 
    //START JInit
    this.Representation = null;
    this.Buffer = null;
    this.BufferSize = create_uint$ref(0);
    this.BufferCapacity = create_uint$ref(0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::NestedNameSpecifierLocBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 491,
   FQN="clang::NestedNameSpecifierLocBuilder::NestedNameSpecifierLocBuilder", NM="_ZN5clang29NestedNameSpecifierLocBuilderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilderC1ERKS0_")
  //</editor-fold>
  public NestedNameSpecifierLocBuilder(final /*const*/ NestedNameSpecifierLocBuilder /*&*/ Other) {
    // : Representation(Other.Representation), Buffer(null), BufferSize(0), BufferCapacity(0) 
    //START JInit
    this.Representation = Other.Representation;
    this.Buffer = null;
    this.BufferSize = create_uint$ref(0);
    this.BufferCapacity = create_uint$ref(0);
    //END JInit
    if (!Native.$bool(Other.Buffer)) {
      return;
    }
    if (Other.BufferCapacity.$deref() == 0) {
      // Shallow copy is okay.
      Buffer = $tryClone(Other.Buffer);
      BufferSize.$set(Other.BufferSize.$deref());
      return;
    }
    
    // Deep copy
    Append(Other.Buffer, Other.Buffer.$add(Other.BufferSize.$deref()), Buffer$Ref, BufferSize, 
        BufferCapacity);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 511,
   FQN="clang::NestedNameSpecifierLocBuilder::operator=", NM="_ZN5clang29NestedNameSpecifierLocBuilderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilderaSERKS0_")
  //</editor-fold>
  public NestedNameSpecifierLocBuilder /*&*/ $assign(final /*const*/ NestedNameSpecifierLocBuilder /*&*/ Other) {
    Representation = Other.Representation;
    if (Native.$bool(Buffer) && Native.$bool(Other.Buffer) && $greatereq_uint(BufferCapacity.$deref(), Other.BufferSize.$deref())) {
      // Re-use our storage.
      BufferSize.$set(Other.BufferSize.$deref());
      memcpy(Buffer, Other.Buffer, BufferSize.$deref());
      return /*Deref*/this;
    }
    
    // Free our storage, if we have any.
    if ((BufferCapacity.$deref() != 0)) {
      free(Buffer);
      BufferCapacity.$set(0);
    }
    if (!Native.$bool(Other.Buffer)) {
      // Empty.
      Buffer = null;
      BufferSize.$set(0);
      return /*Deref*/this;
    }
    if (Other.BufferCapacity.$deref() == 0) {
      // Shallow copy is okay.
      Buffer = $tryClone(Other.Buffer);
      BufferSize.$set(Other.BufferSize.$deref());
      return /*Deref*/this;
    }
    
    // Deep copy.
    Append(Other.Buffer, Other.Buffer.$add(Other.BufferSize.$deref()), Buffer$Ref, BufferSize, 
        BufferCapacity);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::~NestedNameSpecifierLocBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 370,
   FQN="clang::NestedNameSpecifierLocBuilder::~NestedNameSpecifierLocBuilder", NM="_ZN5clang29NestedNameSpecifierLocBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilderD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((BufferCapacity.$deref() != 0)) {
      free(Buffer);
    }
  }

  
  /// \brief Retrieve the representation of the nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::getRepresentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 376,
   FQN="clang::NestedNameSpecifierLocBuilder::getRepresentation", NM="_ZNK5clang29NestedNameSpecifierLocBuilder17getRepresentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang29NestedNameSpecifierLocBuilder17getRepresentationEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getRepresentation() /*const*/ {
    return Representation;
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
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::Extend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 549,
   FQN="clang::NestedNameSpecifierLocBuilder::Extend", NM="_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextENS_14SourceLocationENS_7TypeLocES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextENS_14SourceLocationENS_7TypeLocES3_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, 
        SourceLocation TemplateKWLoc, 
        TypeLoc TL, 
        SourceLocation ColonColonLoc) {
    Representation = NestedNameSpecifier.Create(Context, Representation, 
        TemplateKWLoc.isValid(), 
        TL.getTypePtr());
    
    // Push source-location info into the buffer.
    SavePointer(TL.getOpaqueData(), Buffer$Ref, BufferSize, BufferCapacity);
    SaveSourceLocation(new SourceLocation(ColonColonLoc), Buffer$Ref, BufferSize, BufferCapacity);
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
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::Extend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 562,
   FQN="clang::NestedNameSpecifierLocBuilder::Extend", NM="_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextEPNS_14IdentifierInfoENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextEPNS_14IdentifierInfoENS_14SourceLocationES5_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, 
        IdentifierInfo /*P*/ Identifier, 
        SourceLocation IdentifierLoc, 
        SourceLocation ColonColonLoc) {
    Representation = NestedNameSpecifier.Create(Context, Representation, 
        Identifier);
    
    // Push source-location info into the buffer.
    SaveSourceLocation(new SourceLocation(IdentifierLoc), Buffer$Ref, BufferSize, BufferCapacity);
    SaveSourceLocation(new SourceLocation(ColonColonLoc), Buffer$Ref, BufferSize, BufferCapacity);
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
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::Extend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 574,
   FQN="clang::NestedNameSpecifierLocBuilder::Extend", NM="_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextEPNS_13NamespaceDeclENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextEPNS_13NamespaceDeclENS_14SourceLocationES5_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, 
        NamespaceDecl /*P*/ Namespace, 
        SourceLocation NamespaceLoc, 
        SourceLocation ColonColonLoc) {
    Representation = NestedNameSpecifier.Create(Context, Representation, 
        Namespace);
    
    // Push source-location info into the buffer.
    SaveSourceLocation(new SourceLocation(NamespaceLoc), Buffer$Ref, BufferSize, BufferCapacity);
    SaveSourceLocation(new SourceLocation(ColonColonLoc), Buffer$Ref, BufferSize, BufferCapacity);
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
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::Extend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 586,
   FQN="clang::NestedNameSpecifierLocBuilder::Extend", NM="_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextEPNS_18NamespaceAliasDeclENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder6ExtendERNS_10ASTContextEPNS_18NamespaceAliasDeclENS_14SourceLocationES5_")
  //</editor-fold>
  public void Extend(final ASTContext /*&*/ Context, 
        NamespaceAliasDecl /*P*/ Alias, 
        SourceLocation AliasLoc, 
        SourceLocation ColonColonLoc) {
    Representation = NestedNameSpecifier.Create(Context, Representation, Alias);
    
    // Push source-location info into the buffer.
    SaveSourceLocation(new SourceLocation(AliasLoc), Buffer$Ref, BufferSize, BufferCapacity);
    SaveSourceLocation(new SourceLocation(ColonColonLoc), Buffer$Ref, BufferSize, BufferCapacity);
  }

  
  /// \brief Turn this (empty) nested-name-specifier into the global
  /// nested-name-specifier '::'.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::MakeGlobal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 597,
   FQN="clang::NestedNameSpecifierLocBuilder::MakeGlobal", NM="_ZN5clang29NestedNameSpecifierLocBuilder10MakeGlobalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder10MakeGlobalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void MakeGlobal(final ASTContext /*&*/ Context, 
            SourceLocation ColonColonLoc) {
    assert (!(Representation != null)) : "Already have a nested-name-specifier!?";
    Representation = NestedNameSpecifier.GlobalSpecifier(Context);
    
    // Push source-location info into the buffer.
    SaveSourceLocation(new SourceLocation(ColonColonLoc), Buffer$Ref, BufferSize, BufferCapacity);
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
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::MakeSuper">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 606,
   FQN="clang::NestedNameSpecifierLocBuilder::MakeSuper", NM="_ZN5clang29NestedNameSpecifierLocBuilder9MakeSuperERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder9MakeSuperERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationES5_")
  //</editor-fold>
  public void MakeSuper(final ASTContext /*&*/ Context, 
           CXXRecordDecl /*P*/ RD, 
           SourceLocation SuperLoc, 
           SourceLocation ColonColonLoc) {
    Representation = NestedNameSpecifier.SuperSpecifier(Context, RD);
    
    // Push source-location info into the buffer.
    SaveSourceLocation(new SourceLocation(SuperLoc), Buffer$Ref, BufferSize, BufferCapacity);
    SaveSourceLocation(new SourceLocation(ColonColonLoc), Buffer$Ref, BufferSize, BufferCapacity);
  }

  /// \brief Make a new nested-name-specifier from incomplete source-location
  /// information.
  ///
  /// This routine should be used very, very rarely, in cases where we
  /// need to synthesize a nested-name-specifier. Most code should instead use
  /// \c Adopt() with a proper \c NestedNameSpecifierLoc.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::MakeTrivial">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 617,
   FQN="clang::NestedNameSpecifierLocBuilder::MakeTrivial", NM="_ZN5clang29NestedNameSpecifierLocBuilder11MakeTrivialERNS_10ASTContextEPNS_19NestedNameSpecifierENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder11MakeTrivialERNS_10ASTContextEPNS_19NestedNameSpecifierENS_11SourceRangeE")
  //</editor-fold>
  public void MakeTrivial(final ASTContext /*&*/ Context, 
             NestedNameSpecifier /*P*/ Qualifier, 
             SourceRange R) {
    Representation = Qualifier;
    
    // Construct bogus (but well-formed) source information for the 
    // nested-name-specifier.
    BufferSize.$set(0);
    SmallVector<NestedNameSpecifier /*P*/ > Stack/*J*/= new SmallVector<NestedNameSpecifier /*P*/ >(4, (NestedNameSpecifier /*P*/ )null);
    for (NestedNameSpecifier /*P*/ NNS = Qualifier; (NNS != null); NNS = NNS.getPrefix())  {
      Stack.push_back(NNS);
    }
    while (!Stack.empty()) {
      NestedNameSpecifier /*P*/ NNS = Stack.pop_back_val();
      switch (NNS.getKind()) {
       case Identifier:
       case Namespace:
       case NamespaceAlias:
        SaveSourceLocation(R.getBegin(), Buffer$Ref, BufferSize, BufferCapacity);
        break;
       case TypeSpec:
       case TypeSpecWithTemplate:
        {
          TypeSourceInfo /*P*/ TSInfo = Context.getTrivialTypeSourceInfo(new QualType(NNS.getAsType(), 0), 
              R.getBegin());
          SavePointer(TSInfo.getTypeLoc().getOpaqueData(), Buffer$Ref, BufferSize, 
              BufferCapacity);
          break;
        }
       case Global:
       case Super:
        break;
      }
      
      // Save the location of the '::'.
      SaveSourceLocation(Stack.empty() ? R.getEnd() : R.getBegin(), 
          Buffer$Ref, BufferSize, BufferCapacity);
    }
  }

  
  /// \brief Adopt an existing nested-name-specifier (with source-range
  /// information).
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::Adopt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 658,
   FQN="clang::NestedNameSpecifierLocBuilder::Adopt", NM="_ZN5clang29NestedNameSpecifierLocBuilder5AdoptENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder5AdoptENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void Adopt(NestedNameSpecifierLoc Other) {
    if ((BufferCapacity.$deref() != 0)) {
      free(Buffer);
    }
    if (!Other.$bool()) {
      Representation = null;
      BufferSize.$set(0);
      return;
    }
    
    // Rather than copying the data (which is wasteful), "adopt" the 
    // pointer (which points into the ASTContext) but set the capacity to zero to
    // indicate that we don't own it.
    Representation = Other.getNestedNameSpecifier();
    Buffer = $tryClone((reinterpret_cast(/*static_cast*/type$ptr/*char P*/ .class, (Other.getOpaqueData()))));
    BufferSize.$set(Other.getDataLength());
    BufferCapacity.$set(0);
  }

  
  /// \brief Retrieve the source range covered by this nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 468,
   FQN="clang::NestedNameSpecifierLocBuilder::getSourceRange", NM="_ZNK5clang29NestedNameSpecifierLocBuilder14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang29NestedNameSpecifierLocBuilder14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new NestedNameSpecifierLoc(Representation, Buffer).getSourceRange();
  }

  
  /// \brief Retrieve a nested-name-specifier with location information,
  /// copied into the given AST context.
  ///
  /// \param Context The context into which this nested-name-specifier will be
  /// copied.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::getWithLocInContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp", line = 677,
   FQN="clang::NestedNameSpecifierLocBuilder::getWithLocInContext", NM="_ZNK5clang29NestedNameSpecifierLocBuilder19getWithLocInContextERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang29NestedNameSpecifierLocBuilder19getWithLocInContextERNS_10ASTContextE")
  //</editor-fold>
  public NestedNameSpecifierLoc getWithLocInContext(final ASTContext /*&*/ Context) /*const*/ {
    if (!(Representation != null)) {
      return new NestedNameSpecifierLoc();
    }
    
    // If we adopted our data pointer from elsewhere in the AST context, there's
    // no need to copy the memory.
    if (BufferCapacity.$deref() == 0) {
      return new NestedNameSpecifierLoc(Representation, Buffer);
    }
    
    // FIXME: After copying the source-location information, should we free
    // our (temporary) buffer and adopt the ASTContext-allocated memory?
    // Doing so would optimize repeated calls to getWithLocInContext().
    type$ptr/*void P*/ Mem = Context.Allocate$JavaRef(BufferSize.$deref(), true ? 1 : alignOf(Object.class));
    memcpy(Mem, Buffer, BufferSize.$deref());
    return new NestedNameSpecifierLoc(Representation, Mem);
  }

  
  /// \brief Retrieve a nested-name-specifier with location
  /// information based on the information in this builder.
  ///
  /// This loc will contain references to the builder's internal data and may
  /// be invalidated by any change to the builder.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 484,
   FQN="clang::NestedNameSpecifierLocBuilder::getTemporary", NM="_ZNK5clang29NestedNameSpecifierLocBuilder12getTemporaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang29NestedNameSpecifierLocBuilder12getTemporaryEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getTemporary() /*const*/ {
    return new NestedNameSpecifierLoc(Representation, Buffer);
  }

  
  /// \brief Clear out this builder, and prepare it to build another
  /// nested-name-specifier with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::Clear">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 490,
   FQN="clang::NestedNameSpecifierLocBuilder::Clear", NM="_ZN5clang29NestedNameSpecifierLocBuilder5ClearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZN5clang29NestedNameSpecifierLocBuilder5ClearEv")
  //</editor-fold>
  public void Clear() {
    Representation = null;
    BufferSize.$set(0);
  }

  
  /// \brief Retrieve the underlying buffer.
  ///
  /// \returns A pair containing a pointer to the buffer of source-location
  /// data and the size of the source-location data that resides in that
  /// buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::NestedNameSpecifierLocBuilder::getBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 500,
   FQN="clang::NestedNameSpecifierLocBuilder::getBuffer", NM="_ZNK5clang29NestedNameSpecifierLocBuilder9getBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp -nm=_ZNK5clang29NestedNameSpecifierLocBuilder9getBufferEv")
  //</editor-fold>
  public std.pairTypeUInt<type$ptr/*char P*/> getBuffer() /*const*/ {
    return std.make_pair_T_uint(Buffer, BufferSize.$deref());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final type$ref<type$ptr<?>>/*char P*/ Buffer$Ref = new type$ref<type$ptr<?>>() {
    @Override public type$ptr<?> $deref() {return Buffer;} 
    @Override public type$ptr<?> $set(type$ptr<?> value) {return Buffer = $tryClone(value);}
  };
  
  public void $MemoryCopy(final /*const*/ NestedNameSpecifierLocBuilder /*&*/ Other) {
    this.Representation = Other.Representation;
    this.Buffer = $tryClone(Other.Buffer);
    this.BufferSize.$assign(Other.BufferSize.$deref());
    this.BufferCapacity.$assign(Other.BufferCapacity.$deref());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Representation=" + Representation // NOI18N
              + ", Buffer=" + Buffer // NOI18N
              + ", BufferSize=" + BufferSize // NOI18N
              + ", BufferCapacity=" + BufferCapacity; // NOI18N
  }
}
