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
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Represents a C++ namespace alias.
///
/// For example:
///
/// \code
/// namespace Foo = Bar;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2718,
 FQN="clang::NamespaceAliasDecl", NM="_ZN5clang18NamespaceAliasDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDeclE")
//</editor-fold>
public class NamespaceAliasDecl extends /*public*/ NamedDecl implements /*public*/ Redeclarable<NamespaceAliasDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2121,
   FQN="clang::NamespaceAliasDecl::anchor", NM="_ZN5clang18NamespaceAliasDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The location of the \c namespace keyword.
  /*friend*/public SourceLocation NamespaceLoc;
  
  /// \brief The location of the namespace's identifier.
  ///
  /// This is accessed by TargetNameLoc.
  /*friend*/public SourceLocation IdentLoc;
  
  /// \brief The nested-name-specifier that precedes the namespace.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief The Decl that this alias points to, either a NamespaceDecl or
  /// a NamespaceAliasDecl.
  /*friend*/public NamedDecl /*P*/ Namespace;
  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::NamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2737,
   FQN="clang::NamespaceAliasDecl::NamespaceAliasDecl", NM="_ZN5clang18NamespaceAliasDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_22NestedNameSpecifierLocES5_PNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_22NestedNameSpecifierLocES5_PNS_9NamedDeclE")
  //</editor-fold>
  private NamespaceAliasDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation NamespaceLoc, SourceLocation AliasLoc, 
      IdentifierInfo /*P*/ Alias, NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation IdentLoc, NamedDecl /*P*/ Namespace) {
    // : NamedDecl(NamespaceAlias, DC, AliasLoc, Alias), redeclarable_base(C), NamespaceLoc(NamespaceLoc), IdentLoc(IdentLoc), QualifierLoc(QualifierLoc), Namespace(Namespace) 
    //START JInit
    super(Kind.NamespaceAlias, DC, new SourceLocation(AliasLoc), new DeclarationName(Alias));
    this.Redeclarable$Flds = $Redeclarable(C);
    this.NamespaceLoc = new SourceLocation(NamespaceLoc);
    this.IdentLoc = new SourceLocation(IdentLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.Namespace = Namespace;
    //END JInit
  }

  
  /*typedef Redeclarable<NamespaceAliasDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<NamespaceAliasDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2123,
   FQN="clang::NamespaceAliasDecl::getNextRedeclarationImpl", NM="_ZN5clang18NamespaceAliasDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ NamespaceAliasDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2126,
   FQN="clang::NamespaceAliasDecl::getPreviousDeclImpl", NM="_ZN5clang18NamespaceAliasDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ NamespaceAliasDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2129,
   FQN="clang::NamespaceAliasDecl::getMostRecentDeclImpl", NM="_ZN5clang18NamespaceAliasDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ NamespaceAliasDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

  
  /*friend  class ASTDeclReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2133,
   FQN="clang::NamespaceAliasDecl::Create", NM="_ZN5clang18NamespaceAliasDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_22NestedNameSpecifierLocES5_PNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_22NestedNameSpecifierLocES5_PNS_9NamedDeclE")
  //</editor-fold>
  public static NamespaceAliasDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation UsingLoc, 
        SourceLocation AliasLoc, 
        IdentifierInfo /*P*/ Alias, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation IdentLoc, 
        NamedDecl /*P*/ Namespace) {
    {
      // FIXME: Preserve the aliased namespace as written.
      NamespaceDecl /*P*/ NS = dyn_cast_or_null_NamespaceDecl(Namespace);
      if ((NS != null)) {
        Namespace = NS.getOriginalNamespace();
      }
    }
    final NamedDecl L$Namespace = Namespace;
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new NamespaceAliasDecl(C, DC, new SourceLocation(UsingLoc), new SourceLocation(AliasLoc), Alias, 
                new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(IdentLoc), L$Namespace);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2147,
   FQN="clang::NamespaceAliasDecl::CreateDeserialized", NM="_ZN5clang18NamespaceAliasDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static NamespaceAliasDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new NamespaceAliasDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, 
                new NestedNameSpecifierLoc(), 
                new SourceLocation(), (NamedDecl /*P*/ )null);
     });
  }

  
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<redecl_iterator>{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<NamespaceAliasDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<NamespaceAliasDecl>::redecls_begin;
  //JAVA: using Redeclarable<NamespaceAliasDecl>::redecls_end;
  //JAVA: using Redeclarable<NamespaceAliasDecl>::redecls;
  //JAVA: using Redeclarable<NamespaceAliasDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<NamespaceAliasDecl>::getMostRecentDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2771,
   FQN="clang::NamespaceAliasDecl::getCanonicalDecl", NM="_ZN5clang18NamespaceAliasDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public NamespaceAliasDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2774,
   FQN="clang::NamespaceAliasDecl::getCanonicalDecl", NM="_ZNK5clang18NamespaceAliasDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ NamespaceAliasDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the
  /// name of the namespace, with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2780,
   FQN="clang::NamespaceAliasDecl::getQualifierLoc", NM="_ZNK5clang18NamespaceAliasDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the
  /// name of the namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2784,
   FQN="clang::NamespaceAliasDecl::getQualifier", NM="_ZNK5clang18NamespaceAliasDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  /// \brief Retrieve the namespace declaration aliased by this directive.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2789,
   FQN="clang::NamespaceAliasDecl::getNamespace", NM="_ZN5clang18NamespaceAliasDecl12getNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl12getNamespaceEv")
  //</editor-fold>
  public NamespaceDecl /*P*/ getNamespace() {
    {
      NamespaceAliasDecl /*P*/ AD = dyn_cast_NamespaceAliasDecl(Namespace);
      if ((AD != null)) {
        return AD.getNamespace();
      }
    }
    
    return cast_NamespaceDecl(Namespace);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2796,
   FQN="clang::NamespaceAliasDecl::getNamespace", NM="_ZNK5clang18NamespaceAliasDecl12getNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl12getNamespaceEv")
  //</editor-fold>
  public /*const*/ NamespaceDecl /*P*/ getNamespace$Const() /*const*/ {
    return ((/*const_cast*/NamespaceAliasDecl /*P*/ )(this)).getNamespace();
  }

  
  /// Returns the location of the alias name, i.e. 'foo' in
  /// "namespace foo = ns::bar;".
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getAliasLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2802,
   FQN="clang::NamespaceAliasDecl::getAliasLoc", NM="_ZNK5clang18NamespaceAliasDecl11getAliasLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl11getAliasLocEv")
  //</editor-fold>
  public SourceLocation getAliasLoc() /*const*/ {
    return getLocation();
  }

  
  /// Returns the location of the \c namespace keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getNamespaceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2805,
   FQN="clang::NamespaceAliasDecl::getNamespaceLoc", NM="_ZNK5clang18NamespaceAliasDecl15getNamespaceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl15getNamespaceLocEv")
  //</editor-fold>
  public SourceLocation getNamespaceLoc() /*const*/ {
    return new SourceLocation(NamespaceLoc);
  }

  
  /// Returns the location of the identifier in the named namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getTargetNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2808,
   FQN="clang::NamespaceAliasDecl::getTargetNameLoc", NM="_ZNK5clang18NamespaceAliasDecl16getTargetNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl16getTargetNameLocEv")
  //</editor-fold>
  public SourceLocation getTargetNameLoc() /*const*/ {
    return new SourceLocation(IdentLoc);
  }

  
  /// \brief Retrieve the namespace that this alias refers to, which
  /// may either be a NamespaceDecl or a NamespaceAliasDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getAliasedNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2812,
   FQN="clang::NamespaceAliasDecl::getAliasedNamespace", NM="_ZNK5clang18NamespaceAliasDecl19getAliasedNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl19getAliasedNamespaceEv")
  //</editor-fold>
  public NamedDecl /*P*/ getAliasedNamespace() /*const*/ {
    return Namespace;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2814,
   FQN="clang::NamespaceAliasDecl::getSourceRange", NM="_ZNK5clang18NamespaceAliasDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18NamespaceAliasDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/NamespaceLoc, /*NO_COPY*/IdentLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2818,
   FQN="clang::NamespaceAliasDecl::classof", NM="_ZN5clang18NamespaceAliasDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2819,
   FQN="clang::NamespaceAliasDecl::classofKind", NM="_ZN5clang18NamespaceAliasDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.NamespaceAlias;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamespaceAliasDecl::~NamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2718,
   FQN="clang::NamespaceAliasDecl::~NamespaceAliasDecl", NM="_ZN5clang18NamespaceAliasDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18NamespaceAliasDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final NamespaceAliasDecl getPreviousDecl() { 
    return (NamespaceAliasDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final NamespaceAliasDecl getPreviousDecl$Const() { 
    return (NamespaceAliasDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public final NamespaceAliasDecl getMostRecentDecl() { 
    return (NamespaceAliasDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final NamespaceAliasDecl getMostRecentDecl$Const() { 
    return (NamespaceAliasDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "NamespaceLoc=" + NamespaceLoc // NOI18N
              + ", IdentLoc=" + IdentLoc // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", Namespace=" + Namespace // NOI18N
              + super.toString(); // NOI18N
  }
}
