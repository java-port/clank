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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// CompoundLiteralExpr - [C99 6.5.2.5]
///
//<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2562,
 FQN="clang::CompoundLiteralExpr", NM="_ZN5clang19CompoundLiteralExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExprE")
//</editor-fold>
public class CompoundLiteralExpr extends /*public*/ Expr {
  /// LParenLoc - If non-null, this is the location of the left paren in a
  /// compound literal like "(int){4}".  This can be null if this is a
  /// synthesized compound expression.
  private SourceLocation LParenLoc;
  
  /// The type as written.  This can be an incomplete array type, in
  /// which case the actual expression type will be different.
  /// The int part of the pair stores whether this expr is file scope.
  private PointerBoolPair<TypeSourceInfo /*P*/ > TInfoAndScope;
  private Stmt /*P*/ Init;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::CompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2574,
   FQN="clang::CompoundLiteralExpr::CompoundLiteralExpr", NM="_ZN5clang19CompoundLiteralExprC1ENS_14SourceLocationEPNS_14TypeSourceInfoENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExprC1ENS_14SourceLocationEPNS_14TypeSourceInfoENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEb")
  //</editor-fold>
  public CompoundLiteralExpr(SourceLocation lparenloc, TypeSourceInfo /*P*/ tinfo, 
      QualType T, ExprValueKind VK, Expr /*P*/ init, boolean fileScope) {
    // : Expr(CompoundLiteralExprClass, T, VK, OK_Ordinary, tinfo->getType()->isDependentType(), init->isValueDependent(), (init->isInstantiationDependent() || tinfo->getType()->isInstantiationDependentType()), init->containsUnexpandedParameterPack()), LParenLoc(lparenloc), TInfoAndScope(tinfo, fileScope), Init(init) 
    //START JInit
    super(StmtClass.CompoundLiteralExprClass, new QualType(T), VK, ExprObjectKind.OK_Ordinary, 
        tinfo.getType().$arrow().isDependentType(), 
        init.isValueDependent(), 
        (init.isInstantiationDependent()
           || tinfo.getType().$arrow().isInstantiationDependentType()), 
        init.containsUnexpandedParameterPack());
    this.LParenLoc = new SourceLocation(lparenloc);
    this.TInfoAndScope = new PointerBoolPair<TypeSourceInfo /*P*/ >(tinfo, fileScope);
    this.Init = init;
    //END JInit
  }

  
  /// \brief Construct an empty compound literal.
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::CompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2585,
   FQN="clang::CompoundLiteralExpr::CompoundLiteralExpr", NM="_ZN5clang19CompoundLiteralExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CompoundLiteralExpr(EmptyShell Empty) {
    // : Expr(CompoundLiteralExprClass, Empty), LParenLoc(), TInfoAndScope() 
    //START JInit
    super(StmtClass.CompoundLiteralExprClass, new EmptyShell(Empty));
    this.LParenLoc = new SourceLocation();
    this.TInfoAndScope = new PointerBoolPair<TypeSourceInfo /*P*/ >();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2588,
   FQN="clang::CompoundLiteralExpr::getInitializer", NM="_ZNK5clang19CompoundLiteralExpr14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19CompoundLiteralExpr14getInitializerEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInitializer$Const() /*const*/ {
    return cast_Expr(Init);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::getInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2589,
   FQN="clang::CompoundLiteralExpr::getInitializer", NM="_ZN5clang19CompoundLiteralExpr14getInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr14getInitializerEv")
  //</editor-fold>
  public Expr /*P*/ getInitializer() {
    return cast_Expr(Init);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::setInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2590,
   FQN="clang::CompoundLiteralExpr::setInitializer", NM="_ZN5clang19CompoundLiteralExpr14setInitializerEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr14setInitializerEPNS_4ExprE")
  //</editor-fold>
  public void setInitializer(Expr /*P*/ E) {
    Init = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::isFileScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2592,
   FQN="clang::CompoundLiteralExpr::isFileScope", NM="_ZNK5clang19CompoundLiteralExpr11isFileScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19CompoundLiteralExpr11isFileScopeEv")
  //</editor-fold>
  public boolean isFileScope() /*const*/ {
    return TInfoAndScope.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::setFileScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2593,
   FQN="clang::CompoundLiteralExpr::setFileScope", NM="_ZN5clang19CompoundLiteralExpr12setFileScopeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr12setFileScopeEb")
  //</editor-fold>
  public void setFileScope(boolean FS) {
    TInfoAndScope.setInt(FS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2595,
   FQN="clang::CompoundLiteralExpr::getLParenLoc", NM="_ZNK5clang19CompoundLiteralExpr12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19CompoundLiteralExpr12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2596,
   FQN="clang::CompoundLiteralExpr::setLParenLoc", NM="_ZN5clang19CompoundLiteralExpr12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation L) {
    LParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2598,
   FQN="clang::CompoundLiteralExpr::getTypeSourceInfo", NM="_ZNK5clang19CompoundLiteralExpr17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19CompoundLiteralExpr17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return TInfoAndScope.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::setTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2601,
   FQN="clang::CompoundLiteralExpr::setTypeSourceInfo", NM="_ZN5clang19CompoundLiteralExpr17setTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr17setTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeSourceInfo(TypeSourceInfo /*P*/ tinfo) {
    TInfoAndScope.setPointer(tinfo);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2605,
   FQN="clang::CompoundLiteralExpr::getLocStart", NM="_ZNK5clang19CompoundLiteralExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19CompoundLiteralExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    // FIXME: Init should never be null.
    if (!(Init != null)) {
      return new SourceLocation();
    }
    if (LParenLoc.isInvalid()) {
      return Init.getLocStart();
    }
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2613,
   FQN="clang::CompoundLiteralExpr::getLocEnd", NM="_ZNK5clang19CompoundLiteralExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19CompoundLiteralExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    // FIXME: Init should never be null.
    if (!(Init != null)) {
      return new SourceLocation();
    }
    return Init.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2620,
   FQN="clang::CompoundLiteralExpr::classof", NM="_ZN5clang19CompoundLiteralExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CompoundLiteralExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundLiteralExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2625,
   FQN="clang::CompoundLiteralExpr::children", NM="_ZN5clang19CompoundLiteralExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19CompoundLiteralExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Init))), new StmtIterator(create_type$ptr($AddrOf(Init)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", TInfoAndScope=" + TInfoAndScope // NOI18N
              + ", Init=" + Init // NOI18N
              + super.toString(); // NOI18N
  }
}
