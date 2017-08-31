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

/// \brief Represents C++ using-directive.
///
/// For example:
/// \code
///    using namespace std;
/// \endcode
///
/// \note UsingDirectiveDecl should be Decl not NamedDecl, but we provide
/// artificial names for all using-directives in order to store
/// them in DeclContext effectively.
//<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2615,
 FQN="clang::UsingDirectiveDecl", NM="_ZN5clang18UsingDirectiveDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDeclE")
//</editor-fold>
public class UsingDirectiveDecl extends /*public*/ NamedDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2040,
   FQN="clang::UsingDirectiveDecl::anchor", NM="_ZN5clang18UsingDirectiveDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /// \brief The location of the \c using keyword.
  /*friend*/public SourceLocation UsingLoc;
  
  /// \brief The location of the \c namespace keyword.
  /*friend*/public SourceLocation NamespaceLoc;
  
  /// \brief The nested-name-specifier that precedes the namespace.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief The namespace nominated by this using-directive.
  /*friend*/public NamedDecl /*P*/ NominatedNamespace;
  
  /// Enclosing context containing both using-directive and nominated
  /// namespace.
  /*friend*/public DeclContext /*P*/ CommonAncestor;
  
  /// \brief Returns special DeclarationName used by using-directives.
  ///
  /// This is only used by DeclContext for storing UsingDirectiveDecls in
  /// its lookup structure.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2637,
   FQN="clang::UsingDirectiveDecl::getName", NM="_ZN5clang18UsingDirectiveDecl7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl7getNameEv")
  //</editor-fold>
  /*friend*/final protected/*private*/ static DeclarationName getUsingDirectiveName() {
    return DeclarationName.getUsingDirectiveName();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::UsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2641,
   FQN="clang::UsingDirectiveDecl::UsingDirectiveDecl", NM="_ZN5clang18UsingDirectiveDeclC1EPNS_11DeclContextENS_14SourceLocationES3_NS_22NestedNameSpecifierLocES3_PNS_9NamedDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDeclC1EPNS_11DeclContextENS_14SourceLocationES3_NS_22NestedNameSpecifierLocES3_PNS_9NamedDeclES2_")
  //</editor-fold>
  private UsingDirectiveDecl(DeclContext /*P*/ DC, SourceLocation UsingLoc, 
      SourceLocation NamespcLoc, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation IdentLoc, 
      NamedDecl /*P*/ Nominated, 
      DeclContext /*P*/ CommonAncestor) {
    // : NamedDecl(UsingDirective, DC, IdentLoc, getName()), UsingLoc(UsingLoc), NamespaceLoc(NamespcLoc), QualifierLoc(QualifierLoc), NominatedNamespace(Nominated), CommonAncestor(CommonAncestor) 
    //START JInit
    super(Kind.UsingDirective, DC, new SourceLocation(IdentLoc), getUsingDirectiveName());
    this.UsingLoc = new SourceLocation(UsingLoc);
    this.NamespaceLoc = new SourceLocation(NamespcLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.NominatedNamespace = Nominated;
    this.CommonAncestor = CommonAncestor;
    //END JInit
  }

/*public:*/
  /// \brief Retrieve the nested-name-specifier that qualifies the
  /// name of the namespace, with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2654,
   FQN="clang::UsingDirectiveDecl::getQualifierLoc", NM="_ZNK5clang18UsingDirectiveDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the
  /// name of the namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2658,
   FQN="clang::UsingDirectiveDecl::getQualifier", NM="_ZNK5clang18UsingDirectiveDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getNominatedNamespaceAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2662,
   FQN="clang::UsingDirectiveDecl::getNominatedNamespaceAsWritten", NM="_ZN5clang18UsingDirectiveDecl30getNominatedNamespaceAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl30getNominatedNamespaceAsWrittenEv")
  //</editor-fold>
  public NamedDecl /*P*/ getNominatedNamespaceAsWritten() {
    return NominatedNamespace;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getNominatedNamespaceAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2663,
   FQN="clang::UsingDirectiveDecl::getNominatedNamespaceAsWritten", NM="_ZNK5clang18UsingDirectiveDecl30getNominatedNamespaceAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl30getNominatedNamespaceAsWrittenEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getNominatedNamespaceAsWritten$Const() /*const*/ {
    return NominatedNamespace;
  }

  
  /// \brief Returns the namespace nominated by this using-directive.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getNominatedNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2063,
   FQN="clang::UsingDirectiveDecl::getNominatedNamespace", NM="_ZN5clang18UsingDirectiveDecl21getNominatedNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl21getNominatedNamespaceEv")
  //</editor-fold>
  public NamespaceDecl /*P*/ getNominatedNamespace() {
    {
      NamespaceAliasDecl /*P*/ NA = dyn_cast_or_null_NamespaceAliasDecl(NominatedNamespace);
      if ((NA != null)) {
        return NA.getNamespace();
      }
    }
    return cast_or_null_NamespaceDecl(NominatedNamespace);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getNominatedNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2670,
   FQN="clang::UsingDirectiveDecl::getNominatedNamespace", NM="_ZNK5clang18UsingDirectiveDecl21getNominatedNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl21getNominatedNamespaceEv")
  //</editor-fold>
  public /*const*/ NamespaceDecl /*P*/ getNominatedNamespace$Const() /*const*/ {
    return ((/*const_cast*/UsingDirectiveDecl /*P*/ )(this)).getNominatedNamespace();
  }

  
  /// \brief Returns the common ancestor context of this using-directive and
  /// its nominated namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getCommonAncestor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2676,
   FQN="clang::UsingDirectiveDecl::getCommonAncestor", NM="_ZN5clang18UsingDirectiveDecl17getCommonAncestorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl17getCommonAncestorEv")
  //</editor-fold>
  public DeclContext /*P*/ getCommonAncestor() {
    return CommonAncestor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getCommonAncestor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2677,
   FQN="clang::UsingDirectiveDecl::getCommonAncestor", NM="_ZNK5clang18UsingDirectiveDecl17getCommonAncestorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl17getCommonAncestorEv")
  //</editor-fold>
  public /*const*/ DeclContext /*P*/ getCommonAncestor$Const() /*const*/ {
    return CommonAncestor;
  }

  
  /// \brief Return the location of the \c using keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getUsingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2680,
   FQN="clang::UsingDirectiveDecl::getUsingLoc", NM="_ZNK5clang18UsingDirectiveDecl11getUsingLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl11getUsingLocEv")
  //</editor-fold>
  public SourceLocation getUsingLoc() /*const*/ {
    return new SourceLocation(UsingLoc);
  }

  
  // FIXME: Could omit 'Key' in name.
  /// \brief Returns the location of the \c namespace keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getNamespaceKeyLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2684,
   FQN="clang::UsingDirectiveDecl::getNamespaceKeyLocation", NM="_ZNK5clang18UsingDirectiveDecl23getNamespaceKeyLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl23getNamespaceKeyLocationEv")
  //</editor-fold>
  public SourceLocation getNamespaceKeyLocation() /*const*/ {
    return new SourceLocation(NamespaceLoc);
  }

  
  /// \brief Returns the location of this using declaration's identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getIdentLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2687,
   FQN="clang::UsingDirectiveDecl::getIdentLocation", NM="_ZNK5clang18UsingDirectiveDecl16getIdentLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl16getIdentLocationEv")
  //</editor-fold>
  public SourceLocation getIdentLocation() /*const*/ {
    return getLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2042,
   FQN="clang::UsingDirectiveDecl::Create", NM="_ZN5clang18UsingDirectiveDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS_22NestedNameSpecifierLocES5_PNS_9NamedDeclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS_22NestedNameSpecifierLocES5_PNS_9NamedDeclES4_")
  //</editor-fold>
  public static UsingDirectiveDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, 
        SourceLocation NamespaceLoc, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation IdentLoc, 
        NamedDecl /*P*/ Used, 
        DeclContext /*P*/ CommonAncestor) {
    {
      NamespaceDecl /*P*/ NS = dyn_cast_or_null_NamespaceDecl(Used);
      if ((NS != null)) {
        Used = NS.getOriginalNamespace();
      }
    }
    final NamedDecl finalUsed = Used;
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new UsingDirectiveDecl(DC, new SourceLocation(L), new SourceLocation(NamespaceLoc), new NestedNameSpecifierLoc(QualifierLoc), 
                new SourceLocation(IdentLoc), finalUsed, CommonAncestor);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2055,
   FQN="clang::UsingDirectiveDecl::CreateDeserialized", NM="_ZN5clang18UsingDirectiveDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static UsingDirectiveDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new UsingDirectiveDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), 
                new NestedNameSpecifierLoc(), 
                new SourceLocation(), (NamedDecl /*P*/ )null, (DeclContext /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2698,
   FQN="clang::UsingDirectiveDecl::getSourceRange", NM="_ZNK5clang18UsingDirectiveDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang18UsingDirectiveDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/UsingLoc, getLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2702,
   FQN="clang::UsingDirectiveDecl::classof", NM="_ZN5clang18UsingDirectiveDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2703,
   FQN="clang::UsingDirectiveDecl::classofKind", NM="_ZN5clang18UsingDirectiveDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.UsingDirective;
  }

  
  // Friend for getUsingDirectiveName.
  /*friend  class DeclContext*/
  
  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::UsingDirectiveDecl::~UsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2615,
   FQN="clang::UsingDirectiveDecl::~UsingDirectiveDecl", NM="_ZN5clang18UsingDirectiveDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang18UsingDirectiveDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "UsingLoc=" + UsingLoc // NOI18N
              + ", NamespaceLoc=" + NamespaceLoc // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", NominatedNamespace=" + NominatedNamespace // NOI18N
              + ", CommonAncestor=" + "[DeclContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
