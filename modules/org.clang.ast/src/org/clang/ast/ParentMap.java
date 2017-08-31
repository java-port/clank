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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::ParentMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ParentMap.h", line = 21,
 FQN="clang::ParentMap", NM="_ZN5clang9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZN5clang9ParentMapE")
//</editor-fold>
public class ParentMap implements Destructors.ClassWithDestructor {
  private Object/*void P*/ Impl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::ParentMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 97,
   FQN="clang::ParentMap::ParentMap", NM="_ZN5clang9ParentMapC1EPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZN5clang9ParentMapC1EPNS_4StmtE")
  //</editor-fold>
  public ParentMap(Stmt /*P*/ S) {
    // : Impl(null) 
    //START JInit
    this.Impl = null;
    //END JInit
    if ((S != null)) {
      DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/ M = new DenseMap<Stmt /*P*/ , Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Stmt /*P*/ )null);
      ParentMapStatics.BuildParentMap($Deref(M), S);
      Impl = M;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::~ParentMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 105,
   FQN="clang::ParentMap::~ParentMap", NM="_ZN5clang9ParentMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZN5clang9ParentMapD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/)Impl != null) { ((DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/)Impl).$destroy();};
  }

  
  /// \brief Adds and/or updates the parent/child-relations of the complete
  /// stmt tree of S. All children of S including indirect descendants are
  /// visited and updated or inserted but not the parents of S.
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::addStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 109,
   FQN="clang::ParentMap::addStmt", NM="_ZN5clang9ParentMap7addStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZN5clang9ParentMap7addStmtEPNS_4StmtE")
  //</editor-fold>
  public void addStmt(Stmt /*P*/ S) {
    if ((S != null)) {
      ParentMapStatics.BuildParentMap(/*Deref*/(DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/)Impl, S);
    }
  }

  
  /// Manually sets the parent of \p S to \p Parent.
  ///
  /// If \p S is already in the map, this method will update the mapping.
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 115,
   FQN="clang::ParentMap::setParent", NM="_ZN5clang9ParentMap9setParentEPKNS_4StmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZN5clang9ParentMap9setParentEPKNS_4StmtES3_")
  //</editor-fold>
  public void setParent(/*const*/ Stmt /*P*/ S, /*const*/ Stmt /*P*/ Parent) {
    assert Native.$bool(S);
    assert Native.$bool(Parent);
    DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/ M = ((DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/)reinterpret_cast(DenseMap.class, Impl));
    M.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(((/*const_cast*/Stmt /*P*/ )(S)), ((/*const_cast*/Stmt /*P*/ )(Parent))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 122,
   FQN="clang::ParentMap::getParent", NM="_ZNK5clang9ParentMap9getParentEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap9getParentEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ getParent_Stmt$P(Stmt /*P*/ S) /*const*/ {
    DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/ M = (DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*P*/)Impl;
    DenseMapIterator<Stmt /*P*/ , Stmt /*P*/ > I = M.find(S);
    return I.$eq(/*NO_ITER_COPY*/M.end()) ? null : I.$arrow().second;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParentIgnoreParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 128,
   FQN="clang::ParentMap::getParentIgnoreParens", NM="_ZNK5clang9ParentMap21getParentIgnoreParensEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap21getParentIgnoreParensEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ getParentIgnoreParens_Stmt$P(Stmt /*P*/ S) /*const*/ {
    do {
      S = getParent_Stmt$P(S);
    } while ((S != null) && isa_ParenExpr(S));
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParentIgnoreParenCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 133,
   FQN="clang::ParentMap::getParentIgnoreParenCasts", NM="_ZNK5clang9ParentMap25getParentIgnoreParenCastsEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap25getParentIgnoreParenCastsEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ getParentIgnoreParenCasts_Stmt$P(Stmt /*P*/ S) /*const*/ {
    do {
      S = getParent_Stmt$P(S);
    } while ((S != null) && (isa_ParenExpr(S) || isa_CastExpr(S)));
    
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParentIgnoreParenImpCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 142,
   FQN="clang::ParentMap::getParentIgnoreParenImpCasts", NM="_ZNK5clang9ParentMap28getParentIgnoreParenImpCastsEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap28getParentIgnoreParenImpCastsEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ getParentIgnoreParenImpCasts(Stmt /*P*/ S) /*const*/ {
    do {
      S = getParent_Stmt$P(S);
    } while ((S != null) && isa_Expr(S) && cast_Expr(S).IgnoreParenImpCasts() != S);
    
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getOuterParenParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 150,
   FQN="clang::ParentMap::getOuterParenParent", NM="_ZNK5clang9ParentMap19getOuterParenParentEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap19getOuterParenParentEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ getOuterParenParent(Stmt /*P*/ S) /*const*/ {
    Stmt /*P*/ Paren = null;
    while (isa_ParenExpr(S)) {
      Paren = S;
      S = getParent_Stmt$P(S);
    }
    ;
    return Paren;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ParentMap.h", line = 43,
   FQN="clang::ParentMap::getParent", NM="_ZNK5clang9ParentMap9getParentEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap9getParentEPKNS_4StmtE")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getParent_Stmt$C$P(/*const*/ Stmt /*P*/ S) /*const*/ {
    return getParent_Stmt$P(((/*const_cast*/Stmt /*P*/ )(S)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParentIgnoreParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ParentMap.h", line = 47,
   FQN="clang::ParentMap::getParentIgnoreParens", NM="_ZNK5clang9ParentMap21getParentIgnoreParensEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap21getParentIgnoreParensEPKNS_4StmtE")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getParentIgnoreParens_Stmt$C$P(/*const*/ Stmt /*P*/ S) /*const*/ {
    return getParentIgnoreParens_Stmt$P(((/*const_cast*/Stmt /*P*/ )(S)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::getParentIgnoreParenCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ParentMap.h", line = 51,
   FQN="clang::ParentMap::getParentIgnoreParenCasts", NM="_ZNK5clang9ParentMap25getParentIgnoreParenCastsEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap25getParentIgnoreParenCastsEPKNS_4StmtE")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getParentIgnoreParenCasts_Stmt$C$P(/*const*/ Stmt /*P*/ S) /*const*/ {
    return getParentIgnoreParenCasts_Stmt$P(((/*const_cast*/Stmt /*P*/ )(S)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::hasParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ParentMap.h", line = 55,
   FQN="clang::ParentMap::hasParent", NM="_ZNK5clang9ParentMap9hasParentEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap9hasParentEPNS_4StmtE")
  //</editor-fold>
  public boolean hasParent(Stmt /*P*/ S) /*const*/ {
    return getParent_Stmt$P(S) != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::isConsumedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 159,
   FQN="clang::ParentMap::isConsumedExpr", NM="_ZNK5clang9ParentMap14isConsumedExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap14isConsumedExprEPNS_4ExprE")
  //</editor-fold>
  public boolean isConsumedExpr_Expr$P(Expr /*P*/ E) /*const*/ {
    Stmt /*P*/ P = getParent_Stmt$P(E);
    Stmt /*P*/ DirectChild = E;
    
    // Ignore parents that don't guarantee consumption.
    while ((P != null) && (isa_ParenExpr(P) || isa_CastExpr(P)
       || isa_ExprWithCleanups(P))) {
      DirectChild = P;
      P = getParent_Stmt$P(P);
    }
    if (!(P != null)) {
      return false;
    }
    switch (P.getStmtClass()) {
     default:
      return isa_Expr(P);
     case DeclStmtClass:
      return true;
     case BinaryOperatorClass:
      {
        BinaryOperator /*P*/ BE = cast_BinaryOperator(P);
        // If it is a comma, only the right side is consumed.
        // If it isn't a comma, both sides are consumed.
        return BE.getOpcode() != BinaryOperatorKind.BO_Comma || DirectChild == BE.getRHS();
      }
     case ForStmtClass:
      return DirectChild == cast_ForStmt(P).getCond();
     case WhileStmtClass:
      return DirectChild == cast_WhileStmt(P).getCond();
     case DoStmtClass:
      return DirectChild == cast_DoStmt(P).getCond();
     case IfStmtClass:
      return DirectChild == cast_IfStmt(P).getCond();
     case IndirectGotoStmtClass:
      return DirectChild == cast_IndirectGotoStmt(P).getTarget();
     case SwitchStmtClass:
      return DirectChild == cast_SwitchStmt(P).getCond();
     case ReturnStmtClass:
      return true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParentMap::isConsumedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ParentMap.h", line = 61,
   FQN="clang::ParentMap::isConsumedExpr", NM="_ZNK5clang9ParentMap14isConsumedExprEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZNK5clang9ParentMap14isConsumedExprEPKNS_4ExprE")
  //</editor-fold>
  public boolean isConsumedExpr_Expr$C$P(/*const*/ Expr /*P*/ E) /*const*/ {
    return isConsumedExpr_Expr$P(((/*const_cast*/Expr /*P*/ )(E)));
  }

  
  @Override public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
