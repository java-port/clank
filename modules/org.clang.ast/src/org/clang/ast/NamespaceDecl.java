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
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import org.clang.basic.*;
import org.clang.ast.DeclContext.*;


/// NamespaceDecl - Represent a C++ namespace.
//<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 471,
 FQN="clang::NamespaceDecl", NM="_ZN5clang13NamespaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDeclE")
//</editor-fold>
public class NamespaceDecl extends /*public*/ NamedDecl implements /*public*/ DeclContext, /*public*/ Redeclarable<NamespaceDecl>, Destructors.ClassWithDestructor, Native.ComparableLower {
  /// LocStart - The starting location of the source range, pointing
  /// to either the namespace or the inline keyword.
  /*friend*/public SourceLocation LocStart;
  /// RBraceLoc - The ending location of the source range.
  /*friend*/public SourceLocation RBraceLoc;
  
  /// \brief A pointer to either the anonymous namespace that lives just inside
  /// this namespace or to the first namespace in the chain (the latter case
  /// only when this is not the first in the chain), along with a 
  /// boolean value indicating whether this is an inline namespace.
  /*friend*/public PointerBoolPair<NamespaceDecl /*P*/ > AnonOrFirstNamespaceAndInline;
  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::NamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2070,
   FQN="clang::NamespaceDecl::NamespaceDecl", NM="_ZN5clang13NamespaceDeclC1ERNS_10ASTContextEPNS_11DeclContextEbNS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDeclC1ERNS_10ASTContextEPNS_11DeclContextEbNS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_")
  //</editor-fold>
  private NamespaceDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, boolean Inline, 
      SourceLocation StartLoc, SourceLocation IdLoc, 
      IdentifierInfo /*P*/ Id, NamespaceDecl /*P*/ PrevDecl) {
    // : NamedDecl(Namespace, DC, IdLoc, Id), DeclContext(Namespace), redeclarable_base(C), LocStart(StartLoc), RBraceLoc(), AnonOrFirstNamespaceAndInline(null, Inline) 
    //START JInit
    super(Kind.Namespace, DC, new SourceLocation(IdLoc), new DeclarationName(Id));
    this.DeclContext$Flds = $DeclContext(Kind.Namespace);
    this.Redeclarable$Flds = $Redeclarable(C);
    this.LocStart = new SourceLocation(StartLoc);
    this.RBraceLoc = new SourceLocation();
    this.AnonOrFirstNamespaceAndInline = new PointerBoolPair<NamespaceDecl /*P*/ >((NamespaceDecl /*P*/ )null, Inline);
    //END JInit
    setPreviousDecl(PrevDecl);
    if ((PrevDecl != null)) {
      AnonOrFirstNamespaceAndInline.setPointer(PrevDecl.getOriginalNamespace());
    }
  }

  
  /*typedef Redeclarable<NamespaceDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<NamespaceDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2111,
   FQN="clang::NamespaceDecl::getNextRedeclarationImpl", NM="_ZN5clang13NamespaceDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ NamespaceDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2114,
   FQN="clang::NamespaceDecl::getPreviousDeclImpl", NM="_ZN5clang13NamespaceDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ NamespaceDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2117,
   FQN="clang::NamespaceDecl::getMostRecentDeclImpl", NM="_ZN5clang13NamespaceDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ NamespaceDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2082,
   FQN="clang::NamespaceDecl::Create", NM="_ZN5clang13NamespaceDecl6CreateERNS_10ASTContextEPNS_11DeclContextEbNS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl6CreateERNS_10ASTContextEPNS_11DeclContextEbNS_14SourceLocationES5_PNS_14IdentifierInfoEPS0_")
  //</editor-fold>
  public static NamespaceDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        boolean Inline, SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        NamespaceDecl /*P*/ PrevDecl) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new NamespaceDecl(C, DC, Inline, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, 
                PrevDecl);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2090,
   FQN="clang::NamespaceDecl::CreateDeserialized", NM="_ZN5clang13NamespaceDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static NamespaceDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new NamespaceDecl(C, (DeclContext /*P*/ )null, false, new SourceLocation(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, (NamespaceDecl /*P*/ )null);
     });
  }

  
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<redecl_iterator>{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<NamespaceDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<NamespaceDecl>::redecls_begin;
  //JAVA: using Redeclarable<NamespaceDecl>::redecls_end;
  //JAVA: using Redeclarable<NamespaceDecl>::redecls;
  //JAVA: using Redeclarable<NamespaceDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<NamespaceDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<NamespaceDecl>::isFirstDecl;
  
  /// \brief Returns true if this is an anonymous namespace declaration.
  ///
  /// For example:
  /// \code
  ///   namespace {
  ///     ...
  ///   };
  /// \endcode
  /// q.v. C++ [namespace.unnamed]
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::isAnonymousNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 521,
   FQN="clang::NamespaceDecl::isAnonymousNamespace", NM="_ZNK5clang13NamespaceDecl20isAnonymousNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl20isAnonymousNamespaceEv")
  //</editor-fold>
  public boolean isAnonymousNamespace() /*const*/ {
    return !(getIdentifier() != null);
  }

  
  /// \brief Returns true if this is an inline namespace declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::isInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 526,
   FQN="clang::NamespaceDecl::isInline", NM="_ZNK5clang13NamespaceDecl8isInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl8isInlineEv")
  //</editor-fold>
  public boolean isInline() /*const*/ {
    return AnonOrFirstNamespaceAndInline.getInt();
  }

  
  /// \brief Set whether this is an inline namespace declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::setInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 531,
   FQN="clang::NamespaceDecl::setInline", NM="_ZN5clang13NamespaceDecl9setInlineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl9setInlineEb")
  //</editor-fold>
  public void setInline(boolean Inline) {
    AnonOrFirstNamespaceAndInline.setInt(Inline);
  }

  
  /// \brief Get the original (first) namespace declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getOriginalNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2095,
   FQN="clang::NamespaceDecl::getOriginalNamespace", NM="_ZN5clang13NamespaceDecl20getOriginalNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl20getOriginalNamespaceEv")
  //</editor-fold>
  public NamespaceDecl /*P*/ getOriginalNamespace() {
    if (isFirstDecl$Redeclarable()) {
      return this;
    }
    
    return AnonOrFirstNamespaceAndInline.getPointer();
  }

  
  /// \brief Get the original (first) namespace declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getOriginalNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2102,
   FQN="clang::NamespaceDecl::getOriginalNamespace", NM="_ZNK5clang13NamespaceDecl20getOriginalNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl20getOriginalNamespaceEv")
  //</editor-fold>
  public /*const*/ NamespaceDecl /*P*/ getOriginalNamespace$Const() /*const*/ {
    if (isFirstDecl$Redeclarable()) {
      return this;
    }
    
    return AnonOrFirstNamespaceAndInline.getPointer();
  }

  
  /// \brief Return true if this declaration is an original (first) declaration
  /// of the namespace. This is false for non-original (subsequent) namespace
  /// declarations and anonymous namespaces.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::isOriginalNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2109,
   FQN="clang::NamespaceDecl::isOriginalNamespace", NM="_ZNK5clang13NamespaceDecl19isOriginalNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl19isOriginalNamespaceEv")
  //</editor-fold>
  public boolean isOriginalNamespace() /*const*/ {
    return isFirstDecl$Redeclarable();
  }

  
  /// \brief Retrieve the anonymous namespace nested inside this namespace,
  /// if any.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getAnonymousNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 548,
   FQN="clang::NamespaceDecl::getAnonymousNamespace", NM="_ZNK5clang13NamespaceDecl21getAnonymousNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl21getAnonymousNamespaceEv")
  //</editor-fold>
  public NamespaceDecl /*P*/ getAnonymousNamespace() /*const*/ {
    return getOriginalNamespace$Const().AnonOrFirstNamespaceAndInline.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::setAnonymousNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 552,
   FQN="clang::NamespaceDecl::setAnonymousNamespace", NM="_ZN5clang13NamespaceDecl21setAnonymousNamespaceEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl21setAnonymousNamespaceEPS0_")
  //</editor-fold>
  public void setAnonymousNamespace(NamespaceDecl /*P*/ D) {
    getOriginalNamespace().AnonOrFirstNamespaceAndInline.setPointer(D);
  }

  
  /// Retrieves the canonical declaration of this namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 557,
   FQN="clang::NamespaceDecl::getCanonicalDecl", NM="_ZN5clang13NamespaceDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public NamespaceDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getOriginalNamespace();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 560,
   FQN="clang::NamespaceDecl::getCanonicalDecl", NM="_ZNK5clang13NamespaceDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ NamespaceDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getOriginalNamespace$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 564,
   FQN="clang::NamespaceDecl::getSourceRange", NM="_ZNK5clang13NamespaceDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/LocStart, /*NO_COPY*/RBraceLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 568,
   FQN="clang::NamespaceDecl::getLocStart", NM="_ZNK5clang13NamespaceDecl11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LocStart);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::getRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 569,
   FQN="clang::NamespaceDecl::getRBraceLoc", NM="_ZNK5clang13NamespaceDecl12getRBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13NamespaceDecl12getRBraceLocEv")
  //</editor-fold>
  public SourceLocation getRBraceLoc() /*const*/ {
    return new SourceLocation(RBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::setLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 570,
   FQN="clang::NamespaceDecl::setLocStart", NM="_ZN5clang13NamespaceDecl11setLocStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl11setLocStartENS_14SourceLocationE")
  //</editor-fold>
  public void setLocStart(SourceLocation L) {
    LocStart.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::setRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 571,
   FQN="clang::NamespaceDecl::setRBraceLoc", NM="_ZN5clang13NamespaceDecl12setRBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl12setRBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBraceLoc(SourceLocation L) {
    RBraceLoc.$assign(L);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 574,
   FQN="clang::NamespaceDecl::classof", NM="_ZN5clang13NamespaceDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 575,
   FQN="clang::NamespaceDecl::classofKind", NM="_ZN5clang13NamespaceDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Namespace;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 576,
   FQN="clang::NamespaceDecl::castToDeclContext", NM="_ZN5clang13NamespaceDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ NamespaceDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/NamespaceDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 579,
   FQN="clang::NamespaceDecl::castFromDeclContext", NM="_ZN5clang13NamespaceDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static NamespaceDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/NamespaceDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceDecl::~NamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 471,
   FQN="clang::NamespaceDecl::~NamespaceDecl", NM="_ZN5clang13NamespaceDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13NamespaceDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final NamespaceDecl getPreviousDecl() { 
    return (NamespaceDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final NamespaceDecl getPreviousDecl$Const() { 
    return (NamespaceDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public final NamespaceDecl getMostRecentDecl() { 
    return (NamespaceDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final NamespaceDecl getMostRecentDecl$Const() { 
    return (NamespaceDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
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
  
  @Override
  public boolean $less(Object obj) {
    NamespaceDecl other = (NamespaceDecl) obj;
    return BasicClangGlobals.$less_SourceLocation$C(this.LocStart, other.LocStart);
  }

  @Override public String toString() {
    return "" + "LocStart=" + LocStart // NOI18N
              + ", RBraceLoc=" + RBraceLoc // NOI18N
              + ", AnonOrFirstNamespaceAndInline=" + AnonOrFirstNamespaceAndInline // NOI18N
              + super.toString(); // NOI18N
  }

}
