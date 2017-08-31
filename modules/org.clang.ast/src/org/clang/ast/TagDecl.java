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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.impl.DeclStatics.*;


/// TagDecl - Represents the declaration of a struct/union/class/enum.
//<editor-fold defaultstate="collapsed" desc="clang::TagDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2727,
 FQN="clang::TagDecl", NM="_ZN5clang7TagDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDeclE")
//</editor-fold>
public class TagDecl extends /*public*/ TypeDecl implements /*public*/ DeclContext, /*public*/ Redeclarable<TagDecl>, Destructors.ClassWithDestructor {
/*public:*/
  // This is really ugly.
  /*typedef TagTypeKind TagKind*/
//  public final class TagKind extends TagTypeKind{ };
/*private:*/
  // FIXME: This can be packed into the bitfields in Decl.
  /// TagDeclKind - The TagKind enum.
  private /*JBYTE unsigned int*/ byte TagDeclKind /*: 3*/;
  
  /// IsCompleteDefinition - True if this is a definition ("struct foo
  /// {};"), false if it is a declaration ("struct foo;").  It is not
  /// a definition until the definition has been fully processed.
  /*friend*/public /*JBIT unsigned int*/ boolean IsCompleteDefinition /*: 1*/;
/*protected:*/
  /// IsBeingDefined - True if this is currently being defined.
  protected /*JBIT unsigned int*/ boolean IsBeingDefined /*: 1*/;
/*private:*/
  /// IsEmbeddedInDeclarator - True if this tag declaration is
  /// "embedded" (i.e., defined or declared for the very first time)
  /// in the syntax of a declarator.
  private /*JBIT unsigned int*/ boolean IsEmbeddedInDeclarator /*: 1*/;
  
  /// \brief True if this tag is free standing, e.g. "struct foo;".
  private /*JBIT unsigned int*/ boolean IsFreeStanding /*: 1*/;
/*protected:*/
  // These are used by (and only defined for) EnumDecl.
  protected /*JBYTE unsigned int*/ byte NumPositiveBits /*: 8*/;
  protected /*JBYTE unsigned int*/ byte NumNegativeBits /*: 8*/;
  
  /// IsScoped - True if this tag declaration is a scoped enumeration. Only
  /// possible in C++11 mode.
  /*friend*/public /*JBIT unsigned int*/ boolean IsScoped /*: 1*/;
  /// IsScopedUsingClassTag - If this tag declaration is a scoped enum,
  /// then this is true if the scoped enum was declared using the class
  /// tag, false if it was declared with the struct tag. No meaning is
  /// associated if this tag declaration is not a scoped enum.
  /*friend*/public /*JBIT unsigned int*/ boolean IsScopedUsingClassTag /*: 1*/;
  
  /// IsFixed - True if this is an enumeration with fixed underlying type. Only
  /// possible in C++11, Microsoft extensions, or Objective C mode.
  /*friend*/public /*JBIT unsigned int*/ boolean IsFixed /*: 1*/;
  
  /// \brief Indicates whether it is possible for declarations of this kind
  /// to have an out-of-date definition.
  ///
  /// This option is only enabled when modules are enabled.
  protected /*JBIT unsigned int*/ boolean MayHaveOutOfDateDef /*: 1*/;
  
  /// Has the full definition of this type been required by a use somewhere in
  /// the TU.
  protected /*JBIT unsigned int*/ boolean IsCompleteDefinitionRequired /*: 1*/;
/*private:*/
  private SourceRange BraceRange;
  
  // A struct representing syntactic qualifier info,
  // to be used for the (uncommon) case of out-of-line declarations.
  /*typedef QualifierInfo ExtInfo*/
//  public final class ExtInfo extends QualifierInfo{ };
  
  /// \brief If the (out-of-line) tag declaration name
  /// is qualified, it points to the qualifier info (nns and range);
  /// otherwise, if the tag declaration is anonymous and it is part of
  /// a typedef or alias, it points to the TypedefNameDecl (used for mangling);
  /// otherwise, if the tag declaration is anonymous and it is used as a
  /// declaration specifier for variables, it points to the first VarDecl (used
  /// for mangling);
  /// otherwise, it is a null (TypedefNameDecl) pointer.
  /*friend*/public PointerUnion<TypedefNameDecl /*P*/ , QualifierInfo /*P*/ > TypedefNameDeclOrQualifier;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::hasExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2800,
   FQN="clang::TagDecl::hasExtInfo", NM="_ZNK5clang7TagDecl10hasExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl10hasExtInfoEv")
  //</editor-fold>
  /*friend*/public boolean hasExtInfo() /*const*/ {
    return (TypedefNameDeclOrQualifier.is(QualifierInfo /*P*/.class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2801,
   FQN="clang::TagDecl::getExtInfo", NM="_ZN5clang7TagDecl10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl10getExtInfoEv")
  //</editor-fold>
  /*friend*/public QualifierInfo /*P*/ getExtInfo() {
    return TypedefNameDeclOrQualifier.get(QualifierInfo /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2802,
   FQN="clang::TagDecl::getExtInfo", NM="_ZNK5clang7TagDecl10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl10getExtInfoEv")
  //</editor-fold>
  private /*const*/ QualifierInfo /*P*/ getExtInfo$Const() /*const*/ {
    return TypedefNameDeclOrQualifier.get(QualifierInfo /*P*/.class);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::TagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2807,
   FQN="clang::TagDecl::TagDecl", NM="_ZN5clang7TagDeclC1ENS_4Decl4KindENS_11TagTypeKindERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPS0_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDeclC1ENS_4Decl4KindENS_11TagTypeKindERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPS0_S9_")
  //</editor-fold>
  protected TagDecl(Kind DK, TagTypeKind TK, final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation L, IdentifierInfo /*P*/ Id, TagDecl /*P*/ PrevDecl, 
      SourceLocation StartL) {
    // : TypeDecl(DK, DC, L, Id, StartL), DeclContext(DK), redeclarable_base(C), TagDeclKind(TK), IsCompleteDefinition(false), IsBeingDefined(false), IsEmbeddedInDeclarator(false), IsFreeStanding(false), IsCompleteDefinitionRequired(false), BraceRange(), TypedefNameDeclOrQualifier((TypedefNameDecl * )null) 
    //START JInit
    super(DK, DC, new SourceLocation(L), Id, new SourceLocation(StartL));
    this.DeclContext$Flds = $DeclContext(DK);
    this.Redeclarable$Flds = $Redeclarable(C);
    this.TagDeclKind = $uint2uint_3bits(TK.getValue());
    this.IsCompleteDefinition = false;
    this.IsBeingDefined = false;
    this.IsEmbeddedInDeclarator = false;
    this.IsFreeStanding = false;
    this.IsCompleteDefinitionRequired = false;
    this.BraceRange = new SourceRange();
    this.TypedefNameDeclOrQualifier = new PointerUnion<TypedefNameDecl /*P*/ , QualifierInfo /*P*/ >(JD$T.INSTANCE, TypedefNameDecl /*P*/.class, (TypedefNameDecl /*P*/ )(TypedefNameDecl /*P*/ )null);
    //END JInit
    assert ((DK != Kind.Enum || TK == TagTypeKind.TTK_Enum)) : "EnumDecl not matched with TTK_Enum";
    setPreviousDecl(PrevDecl);
  }

  
  /*typedef Redeclarable<TagDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<TagDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2821,
   FQN="clang::TagDecl::getNextRedeclarationImpl", NM="_ZN5clang7TagDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected TagDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2824,
   FQN="clang::TagDecl::getPreviousDeclImpl", NM="_ZN5clang7TagDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected TagDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2827,
   FQN="clang::TagDecl::getMostRecentDeclImpl", NM="_ZN5clang7TagDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected TagDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

  
  /// @brief Completes the definition of this tag declaration.
  ///
  /// This is a helper function for derived classes.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::completeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3555,
   FQN="clang::TagDecl::completeDefinition", NM="_ZN5clang7TagDecl18completeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl18completeDefinitionEv")
  //</editor-fold>
  protected void completeDefinition() {
    assert ((!isa_CXXRecordDecl(this) || cast_CXXRecordDecl(this).hasDefinition())) : "definition completed but not started";
    
    IsCompleteDefinition = true;
    IsBeingDefined = false;
    {
      
      ASTMutationListener /*P*/ L = getASTMutationListener();
      if ((L != null)) {
        L.CompletedTagDefinition(this);
      }
    }
  }

/*public:*/
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<TagDecl /*P*/ >{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<TagDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<TagDecl>::redecls_begin;
  //JAVA: using Redeclarable<TagDecl>::redecls_end;
  //JAVA: using Redeclarable<TagDecl>::redecls;
  //JAVA: using Redeclarable<TagDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<TagDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<TagDecl>::isFirstDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getBraceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2846,
   FQN="clang::TagDecl::getBraceRange", NM="_ZNK5clang7TagDecl13getBraceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl13getBraceRangeEv")
  //</editor-fold>
  public SourceRange getBraceRange() /*const*/ {
    return new SourceRange(BraceRange);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setBraceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2847,
   FQN="clang::TagDecl::setBraceRange", NM="_ZN5clang7TagDecl13setBraceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl13setBraceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setBraceRange(SourceRange R) {
    BraceRange.$assign(R);
  }

  
  /// getInnerLocStart - Return SourceLocation representing start of source
  /// range ignoring outer template declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getInnerLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2851,
   FQN="clang::TagDecl::getInnerLocStart", NM="_ZNK5clang7TagDecl16getInnerLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl16getInnerLocStartEv")
  //</editor-fold>
  public SourceLocation getInnerLocStart() /*const*/ {
    return getLocStart();
  }

  
  /// getOuterLocStart - Return SourceLocation representing start of source
  /// range taking into account any outer template declarations.
  
  //===----------------------------------------------------------------------===//
  // TagDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getOuterLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3523,
   FQN="clang::TagDecl::getOuterLocStart", NM="_ZNK5clang7TagDecl16getOuterLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl16getOuterLocStartEv")
  //</editor-fold>
  public SourceLocation getOuterLocStart() /*const*/ {
    return getTemplateOrInnerLocStart(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3527,
   FQN="clang::TagDecl::getSourceRange", NM="_ZNK5clang7TagDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation RBraceLoc = BraceRange.getEnd();
    SourceLocation E = RBraceLoc.isValid() ? new SourceLocation(RBraceLoc) : getLocation();
    return new SourceRange(getOuterLocStart(), /*NO_COPY*/E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3533,
   FQN="clang::TagDecl::getCanonicalDecl", NM="_ZN5clang7TagDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public TagDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2859,
   FQN="clang::TagDecl::getCanonicalDecl", NM="_ZNK5clang7TagDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ TagDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/TagDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  /// isThisDeclarationADefinition() - Return true if this declaration
  /// is a completion definition of the type.  Provided for consistency.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2865,
   FQN="clang::TagDecl::isThisDeclarationADefinition", NM="_ZNK5clang7TagDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return isCompleteDefinition();
  }

  
  /// isCompleteDefinition - Return true if this decl has its body
  /// fully specified.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isCompleteDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2871,
   FQN="clang::TagDecl::isCompleteDefinition", NM="_ZNK5clang7TagDecl20isCompleteDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl20isCompleteDefinitionEv")
  //</editor-fold>
  public boolean isCompleteDefinition() /*const*/ {
    return IsCompleteDefinition;
  }

  
  /// \brief Return true if this complete decl is
  /// required to be complete for some existing use.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isCompleteDefinitionRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2877,
   FQN="clang::TagDecl::isCompleteDefinitionRequired", NM="_ZNK5clang7TagDecl28isCompleteDefinitionRequiredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl28isCompleteDefinitionRequiredEv")
  //</editor-fold>
  public boolean isCompleteDefinitionRequired() /*const*/ {
    return IsCompleteDefinitionRequired;
  }

  
  /// isBeingDefined - Return true if this decl is currently being defined.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isBeingDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2882,
   FQN="clang::TagDecl::isBeingDefined", NM="_ZNK5clang7TagDecl14isBeingDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl14isBeingDefinedEv")
  //</editor-fold>
  public boolean isBeingDefined() /*const*/ {
    return IsBeingDefined;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isEmbeddedInDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2886,
   FQN="clang::TagDecl::isEmbeddedInDeclarator", NM="_ZNK5clang7TagDecl22isEmbeddedInDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl22isEmbeddedInDeclaratorEv")
  //</editor-fold>
  public boolean isEmbeddedInDeclarator() /*const*/ {
    return IsEmbeddedInDeclarator;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setEmbeddedInDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2889,
   FQN="clang::TagDecl::setEmbeddedInDeclarator", NM="_ZN5clang7TagDecl23setEmbeddedInDeclaratorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl23setEmbeddedInDeclaratorEb")
  //</editor-fold>
  public void setEmbeddedInDeclarator(boolean isInDeclarator) {
    IsEmbeddedInDeclarator = isInDeclarator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isFreeStanding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2893,
   FQN="clang::TagDecl::isFreeStanding", NM="_ZNK5clang7TagDecl14isFreeStandingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl14isFreeStandingEv")
  //</editor-fold>
  public boolean isFreeStanding() /*const*/ {
    return IsFreeStanding;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setFreeStanding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2894,
   FQN="clang::TagDecl::setFreeStanding", NM="_ZN5clang7TagDecl15setFreeStandingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl15setFreeStandingEb")
  //</editor-fold>
  public void setFreeStanding() {
    setFreeStanding(true);
  }
  public void setFreeStanding(boolean isFreeStanding/*= true*/) {
    IsFreeStanding = isFreeStanding;
  }

  
  /// \brief Whether this declaration declares a type that is
  /// dependent, i.e., a type that somehow depends on template
  /// parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isDependentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2901,
   FQN="clang::TagDecl::isDependentType", NM="_ZNK5clang7TagDecl15isDependentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl15isDependentTypeEv")
  //</editor-fold>
  public boolean isDependentType() /*const*/ {
    return isDependentContext();
  }

  
  /// @brief Starts the definition of this tag declaration.
  ///
  /// This method should be invoked at the beginning of the definition
  /// of this tag declaration. It will set the tag type into a state
  /// where it is in the process of being defined.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::startDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3544,
   FQN="clang::TagDecl::startDefinition", NM="_ZN5clang7TagDecl15startDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl15startDefinitionEv")
  //</editor-fold>
  public void startDefinition() {
    IsBeingDefined = true;
    {
      
      CXXRecordDecl /*P*/ D = dyn_cast_CXXRecordDecl(this);
      if ((D != null)) {
         CXXRecordDecl.DefinitionData /*P*/ Data = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
            return new  CXXRecordDecl.DefinitionData(D);
         });
        for (TagDecl /*P*/ I : redeclarable_redecls())  {
          cast_CXXRecordDecl(I).DefinitionData = Data;
        }
      }
    }
  }

  
  /// getDefinition - Returns the TagDecl that actually defines this
  ///  struct/union/class/enum.  When determining whether or not a
  ///  struct/union/class/enum has a definition, one should use this
  ///  method as opposed to 'isDefinition'.  'isDefinition' indicates
  ///  whether or not a specific TagDecl is defining declaration, not
  ///  whether or not the struct/union/class/enum type is defined.
  ///  This method returns NULL if there is no TagDecl that defines
  ///  the struct/union/class/enum.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3567,
   FQN="clang::TagDecl::getDefinition", NM="_ZNK5clang7TagDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl13getDefinitionEv")
  //</editor-fold>
  public TagDecl /*P*/ getDefinition() /*const*/ {
    if (isCompleteDefinition()) {
      return ((/*const_cast*/TagDecl /*P*/ )(this));
    }
    
    // If it's possible for us to have an out-of-date definition, check now.
    if (MayHaveOutOfDateDef) {
      {
        IdentifierInfo /*P*/ II = getIdentifier();
        if ((II != null)) {
          if (II.isOutOfDate()) {
            updateOutOfDate($Deref(II));
          }
        }
      }
    }
    {
      
      /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(this);
      if ((CXXRD != null)) {
        return CXXRD.getDefinition();
      }
    }
    
    for (TagDecl /*P*/ R : redeclarable_redecls())  {
      if (R.isCompleteDefinition()) {
        return R;
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setCompleteDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2920,
   FQN="clang::TagDecl::setCompleteDefinition", NM="_ZN5clang7TagDecl21setCompleteDefinitionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl21setCompleteDefinitionEb")
  //</editor-fold>
  public void setCompleteDefinition(boolean V) {
    IsCompleteDefinition = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setCompleteDefinitionRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2922,
   FQN="clang::TagDecl::setCompleteDefinitionRequired", NM="_ZN5clang7TagDecl29setCompleteDefinitionRequiredEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl29setCompleteDefinitionRequiredEb")
  //</editor-fold>
  public void setCompleteDefinitionRequired() {
    setCompleteDefinitionRequired(true);
  }
  public void setCompleteDefinitionRequired(boolean V/*= true*/) {
    IsCompleteDefinitionRequired = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2926,
   FQN="clang::TagDecl::getKindName", NM="_ZNK5clang7TagDecl11getKindNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl11getKindNameEv")
  //</editor-fold>
  public StringRef getKindName() /*const*/ {
    return TypeWithKeyword.getTagTypeKindName(getTagKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getTagKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2930,
   FQN="clang::TagDecl::getTagKind", NM="_ZNK5clang7TagDecl10getTagKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl10getTagKindEv")
  //</editor-fold>
  public TagTypeKind getTagKind() /*const*/ {
    return TagTypeKind.valueOf(TagDeclKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setTagKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2934,
   FQN="clang::TagDecl::setTagKind", NM="_ZN5clang7TagDecl10setTagKindENS_11TagTypeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl10setTagKindENS_11TagTypeKindE")
  //</editor-fold>
  public void setTagKind(TagTypeKind TK) {
    TagDeclKind = $uint2uint_3bits(TK.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2936,
   FQN="clang::TagDecl::isStruct", NM="_ZNK5clang7TagDecl8isStructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl8isStructEv")
  //</editor-fold>
  public boolean isStruct() /*const*/ {
    return getTagKind() == TagTypeKind.TTK_Struct;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2937,
   FQN="clang::TagDecl::isInterface", NM="_ZNK5clang7TagDecl11isInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl11isInterfaceEv")
  //</editor-fold>
  public boolean isInterface() /*const*/ {
    return getTagKind() == TagTypeKind.TTK_Interface;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2938,
   FQN="clang::TagDecl::isClass", NM="_ZNK5clang7TagDecl7isClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl7isClassEv")
  //</editor-fold>
  public boolean isClass() /*const*/ {
    return getTagKind() == TagTypeKind.TTK_Class;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2939,
   FQN="clang::TagDecl::isUnion", NM="_ZNK5clang7TagDecl7isUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl7isUnionEv")
  //</editor-fold>
  public boolean isUnion() /*const*/ {
    return getTagKind() == TagTypeKind.TTK_Union;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::isEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2940,
   FQN="clang::TagDecl::isEnum", NM="_ZNK5clang7TagDecl6isEnumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl6isEnumEv")
  //</editor-fold>
  public boolean isEnum() /*const*/ {
    return getTagKind() == TagTypeKind.TTK_Enum;
  }

  
  /// Is this tag type named, either directly or via being defined in
  /// a typedef of this type?
  ///
  /// C++11 [basic.link]p8:
  ///   A type is said to have linkage if and only if:
  ///     - it is a class or enumeration type that is named (or has a
  ///       name for linkage purposes) and the name has linkage; ...
  /// C++11 [dcl.typedef]p9:
  ///   If the typedef declaration defines an unnamed class (or enum),
  ///   the first typedef-name declared by the declaration to be that
  ///   class type (or enum type) is used to denote the class type (or
  ///   enum type) for linkage purposes only.
  ///
  /// C does not have an analogous rule, but the same concept is
  /// nonetheless useful in some places.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::hasNameForLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2957,
   FQN="clang::TagDecl::hasNameForLinkage", NM="_ZNK5clang7TagDecl17hasNameForLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl17hasNameForLinkageEv")
  //</editor-fold>
  public boolean hasNameForLinkage() /*const*/ {
    return (getDeclName().$bool() || (getTypedefNameForAnonDecl() != null));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getTypedefNameForAnonDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2961,
   FQN="clang::TagDecl::getTypedefNameForAnonDecl", NM="_ZNK5clang7TagDecl25getTypedefNameForAnonDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl25getTypedefNameForAnonDeclEv")
  //</editor-fold>
  public TypedefNameDecl /*P*/ getTypedefNameForAnonDecl() /*const*/ {
    return hasExtInfo() ? null : TypedefNameDeclOrQualifier.get(TypedefNameDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setTypedefNameForAnonDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3535,
   FQN="clang::TagDecl::setTypedefNameForAnonDecl", NM="_ZN5clang7TagDecl25setTypedefNameForAnonDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl25setTypedefNameForAnonDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public void setTypedefNameForAnonDecl(TypedefNameDecl /*P*/ TDD) {
    TypedefNameDeclOrQualifier.$assign_T$C$R(TypedefNameDecl /*P*/ /*const*/ /*&*/.class, TDD);
    {
      /*const*/ Type /*P*/ T = getTypeForDecl();
      if ((T != null)) {
        ///*J:(void)*/T;
        assert (T.isLinkageValid());
      }
    }
    assert (isLinkageValid());
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name of this
  /// declaration, if it was present in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2970,
   FQN="clang::TagDecl::getQualifier", NM="_ZNK5clang7TagDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return hasExtInfo() ? getExtInfo$Const().QualifierLoc.getNestedNameSpecifier() : null;
  }

  
  /// \brief Retrieve the nested-name-specifier (with source-location
  /// information) that qualifies the name of this declaration, if it was
  /// present in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2978,
   FQN="clang::TagDecl::getQualifierLoc", NM="_ZNK5clang7TagDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return hasExtInfo() ? new NestedNameSpecifierLoc(getExtInfo$Const().QualifierLoc) : new NestedNameSpecifierLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setQualifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3590,
   FQN="clang::TagDecl::setQualifierInfo", NM="_ZN5clang7TagDecl16setQualifierInfoENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl16setQualifierInfoENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void setQualifierInfo(NestedNameSpecifierLoc QualifierLoc) {
    if (QualifierLoc.$bool()) {
      // Make sure the extended qualifier info is allocated.
      if (!hasExtInfo()) {
        TypedefNameDeclOrQualifier.$assign_T1$C$R(QualifierInfo /*P*/ /*const*/ /*&*/.class, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
                return new QualifierInfo();
             }));
      }
      // Set qualifier info.
      getExtInfo().QualifierLoc.$assign(QualifierLoc);
    } else {
      // Here Qualifier == 0, i.e., we are removing the qualifier (if any).
      if (hasExtInfo()) {
        if (getExtInfo().NumTemplParamLists == 0) {
          getASTContext().Deallocate(getExtInfo());
          TypedefNameDeclOrQualifier.$assign_T$C$R(TypedefNameDecl /*P*/ /*const*/ /*&*/.class, (TypedefNameDecl /*P*/ )(TypedefNameDecl /*P*/ )null);
        } else {
          getExtInfo().QualifierLoc.$assign(QualifierLoc);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getNumTemplateParameterLists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2985,
   FQN="clang::TagDecl::getNumTemplateParameterLists", NM="_ZNK5clang7TagDecl28getNumTemplateParameterListsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl28getNumTemplateParameterListsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateParameterLists() /*const*/ {
    return hasExtInfo() ? getExtInfo$Const().NumTemplParamLists : 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::getTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2988,
   FQN="clang::TagDecl::getTemplateParameterList", NM="_ZNK5clang7TagDecl24getTemplateParameterListEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang7TagDecl24getTemplateParameterListEj")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameterList(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumTemplateParameterLists()));
    return getExtInfo$Const().TemplParamLists.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::setTemplateParameterListsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3610,
   FQN="clang::TagDecl::setTemplateParameterListsInfo", NM="_ZN5clang7TagDecl29setTemplateParameterListsInfoERNS_10ASTContextEN4llvm8ArrayRefIPNS_21TemplateParameterListEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl29setTemplateParameterListsInfoERNS_10ASTContextEN4llvm8ArrayRefIPNS_21TemplateParameterListEEE")
  //</editor-fold>
  public void setTemplateParameterListsInfo(final ASTContext /*&*/ Context, ArrayRef<TemplateParameterList /*P*/ > TPLists) {
    assert (!TPLists.empty());
    // Make sure the extended decl info is allocated.
    if (!hasExtInfo()) {
      // Allocate external info struct.
      TypedefNameDeclOrQualifier.$assign_T1$C$R(QualifierInfo /*P*/ /*const*/ /*&*/.class, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
              return new QualifierInfo();
           }));
    }
    // Set the template parameter lists info.
    getExtInfo().setTemplateParameterListsInfo(Context, new ArrayRef<TemplateParameterList /*P*/ >(TPLists));
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2996,
   FQN="clang::TagDecl::classof", NM="_ZN5clang7TagDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2997,
   FQN="clang::TagDecl::classofKind", NM="_ZN5clang7TagDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstTag.getValue() && K.getValue() <= Kind.lastTag.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2999,
   FQN="clang::TagDecl::castToDeclContext", NM="_ZN5clang7TagDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ TagDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/TagDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3002,
   FQN="clang::TagDecl::castFromDeclContext", NM="_ZN5clang7TagDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static TagDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/TagDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::TagDecl::~TagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2727,
   FQN="clang::TagDecl::~TagDecl", NM="_ZN5clang7TagDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang7TagDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public/*derived non-final*/ TagDecl getPreviousDecl() { 
    return (TagDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public/*derived non-final*/ TagDecl getPreviousDecl$Const() { 
    return (TagDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public/*derived non-final*/ TagDecl getMostRecentDecl() { 
    return (TagDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public/*derived non-final*/ TagDecl getMostRecentDecl$Const() { 
    return (TagDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 
  


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return " As$TagDecl{" + "TagDeclKind=" + TagTypeKind.valueOf($uchar2uint(TagDeclKind)) // NOI18N
              + ", IsCompleteDefinition=" + IsCompleteDefinition // NOI18N
              + ", IsBeingDefined=" + IsBeingDefined // NOI18N
              + ", IsEmbeddedInDeclarator=" + IsEmbeddedInDeclarator // NOI18N
              + ", IsFreeStanding=" + IsFreeStanding // NOI18N
              + ", NumPositiveBits=" + $uchar2uint(NumPositiveBits) // NOI18N
              + ", NumNegativeBits=" + $uchar2uint(NumNegativeBits) // NOI18N
              + ", IsScoped=" + IsScoped // NOI18N
              + ", IsScopedUsingClassTag=" + IsScopedUsingClassTag // NOI18N
              + ", IsFixed=" + IsFixed // NOI18N
              + ", MayHaveOutOfDateDef=" + MayHaveOutOfDateDef // NOI18N
              + ", IsCompleteDefinitionRequired=" + IsCompleteDefinitionRequired // NOI18N
              + ", BraceRange=" + BraceRange // NOI18N
              + ", TypedefNameDeclOrQualifier=" + TypedefNameDeclOrQualifier + "}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}
