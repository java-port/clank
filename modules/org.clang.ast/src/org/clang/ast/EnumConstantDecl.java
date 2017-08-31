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
import org.llvm.adt.*;
import org.clang.basic.*;


/// EnumConstantDecl - An instance of this object exists for each enum constant
/// that is defined.  For example, in "enum X {a,b}", each of a/b are
/// EnumConstantDecl's, X is an instance of EnumDecl, and the type of a/b is a
/// TagType for the X EnumDecl.
//<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2481,
 FQN="clang::EnumConstantDecl", NM="_ZN5clang16EnumConstantDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDeclE")
//</editor-fold>
public class EnumConstantDecl extends /*public*/ ValueDecl implements /*public*/ Mergeable<EnumConstantDecl>, Destructors.ClassWithDestructor {
  private Stmt /*P*/ Init; // an integer constant expression
  private APSInt Val; // The value.
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::EnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2485,
   FQN="clang::EnumConstantDecl::EnumConstantDecl", NM="_ZN5clang16EnumConstantDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEPNS_4ExprERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEPNS_4ExprERKN4llvm6APSIntE")
  //</editor-fold>
  protected EnumConstantDecl(DeclContext /*P*/ DC, SourceLocation L, 
      IdentifierInfo /*P*/ Id, QualType T, Expr /*P*/ E, 
      final /*const*/ APSInt /*&*/ V) {
    // : ValueDecl(EnumConstant, DC, L, Id, T), Mergeable<EnumConstantDecl>(), Init((Stmt * )E), Val(V) 
    //START JInit
    super(Kind.EnumConstant, DC, new SourceLocation(L), new DeclarationName(Id), new QualType(T));
    $Mergeable();
    this.Init = (Stmt /*P*/ )E;
    this.Val = new APSInt(V);
    //END JInit
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4080,
   FQN="clang::EnumConstantDecl::Create", NM="_ZN5clang16EnumConstantDecl6CreateERNS_10ASTContextEPNS_8EnumDeclENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEPNS_4ExprERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl6CreateERNS_10ASTContextEPNS_8EnumDeclENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEPNS_4ExprERKN4llvm6APSIntE")
  //</editor-fold>
  public static EnumConstantDecl /*P*/ Create(final ASTContext /*&*/ C, EnumDecl /*P*/ CD, 
        SourceLocation L, 
        IdentifierInfo /*P*/ Id, QualType T, 
        Expr /*P*/ E, final /*const*/ APSInt /*&*/ V) {
    return /*NEW_EXPR [Decl::new]*//*new (C, CD)*/ Decl.$new(C, CD, (type$ptr<?> New$Mem)->{
        return new EnumConstantDecl(CD, new SourceLocation(L), Id, new QualType(T), E, V);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4087,
   FQN="clang::EnumConstantDecl::CreateDeserialized", NM="_ZN5clang16EnumConstantDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static EnumConstantDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new EnumConstantDecl((DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
                new QualType(), (Expr /*P*/ )null, new APSInt());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::getInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2498,
   FQN="clang::EnumConstantDecl::getInitExpr", NM="_ZNK5clang16EnumConstantDecl11getInitExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16EnumConstantDecl11getInitExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInitExpr$Const() /*const*/ {
    return (/*const*/ Expr /*P*/ )Init;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::getInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2499,
   FQN="clang::EnumConstantDecl::getInitExpr", NM="_ZN5clang16EnumConstantDecl11getInitExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl11getInitExprEv")
  //</editor-fold>
  public Expr /*P*/ getInitExpr() {
    return (Expr /*P*/ )Init;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::getInitVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2500,
   FQN="clang::EnumConstantDecl::getInitVal", NM="_ZNK5clang16EnumConstantDecl10getInitValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16EnumConstantDecl10getInitValEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getInitVal() /*const*/ {
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::setInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2502,
   FQN="clang::EnumConstantDecl::setInitExpr", NM="_ZN5clang16EnumConstantDecl11setInitExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl11setInitExprEPNS_4ExprE")
  //</editor-fold>
  public void setInitExpr(Expr /*P*/ E) {
    Init = (Stmt /*P*/ )E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::setInitVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2503,
   FQN="clang::EnumConstantDecl::setInitVal", NM="_ZN5clang16EnumConstantDecl10setInitValERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl10setInitValERKN4llvm6APSIntE")
  //</editor-fold>
  public void setInitVal(final /*const*/ APSInt /*&*/ V) {
    Val.$assign(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4120,
   FQN="clang::EnumConstantDecl::getSourceRange", NM="_ZNK5clang16EnumConstantDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16EnumConstantDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation End = getLocation();
    if ((Init != null)) {
      End.$assignMove(Init.getLocEnd());
    }
    return new SourceRange(getLocation(), /*NO_COPY*/End);
  }

  
  /// Retrieves the canonical declaration of this enumerator.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2508,
   FQN="clang::EnumConstantDecl::getCanonicalDecl", NM="_ZN5clang16EnumConstantDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public EnumConstantDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2509,
   FQN="clang::EnumConstantDecl::getCanonicalDecl", NM="_ZNK5clang16EnumConstantDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang16EnumConstantDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ EnumConstantDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2512,
   FQN="clang::EnumConstantDecl::classof", NM="_ZN5clang16EnumConstantDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2513,
   FQN="clang::EnumConstantDecl::classofKind", NM="_ZN5clang16EnumConstantDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.EnumConstant;
  }

  
  /*friend  class StmtIteratorBase*/
  //<editor-fold defaultstate="collapsed" desc="clang::EnumConstantDecl::~EnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2481,
   FQN="clang::EnumConstantDecl::~EnumConstantDecl", NM="_ZN5clang16EnumConstantDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16EnumConstantDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Val.$destroy();
    super.$destroy();
    Mergeable.super.$destroy$Mergeable();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //public final EnumConstantDecl /*P*/ getFirstDecl() { return Mergeable.super.getFirstDecl$Mergeable(); }
  
  //public final /*const*/ EnumConstantDecl /*P*/ getFirstDecl$Const() /*const*/ { return Mergeable.super.getFirstDecl$Mergeable$Const(); }
  
  public final boolean isFirstDecl() /*const*/ { return Mergeable.super.isFirstDecl$Mergeable(); }
  
  public final Class<? extends EnumConstantDecl> getDeclType$Mergeable() { return this.getClass(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Init=" + Init // NOI18N
              + ", Val=" + Val // NOI18N
              + super.toString(); // NOI18N
  }
}
