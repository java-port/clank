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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

// In cases like:
//   struct Q { int a, b, c; };
//   Q *getQ();
//   void foo() {
//     struct A { Q q; } a = { *getQ(), .q.b = 3 };
//   }
//
// We will have an InitListExpr for a, with type A, and then a
// DesignatedInitUpdateExpr for "a.q" with type Q. The "base" for this DIUE
// is the call expression *getQ(); the "updater" for the DIUE is ".q.b = 3"
//
//<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4273,
 FQN="clang::DesignatedInitUpdateExpr", NM="_ZN5clang24DesignatedInitUpdateExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExprE")
//</editor-fold>
public class DesignatedInitUpdateExpr extends /*public*/ Expr {
  // BaseAndUpdaterExprs[0] is the base expression;
  // BaseAndUpdaterExprs[1] is an InitListExpr overwriting part of the base.
  private Stmt /*P*/ BaseAndUpdaterExprs[/*2*/] = new Stmt /*P*/  [2];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::DesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3685,
   FQN="clang::DesignatedInitUpdateExpr::DesignatedInitUpdateExpr", NM="_ZN5clang24DesignatedInitUpdateExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprES4_")
  //</editor-fold>
  public DesignatedInitUpdateExpr(final /*const*/ ASTContext /*&*/ C, 
      SourceLocation lBraceLoc, Expr /*P*/ baseExpr, SourceLocation rBraceLoc) {
    // : Expr(DesignatedInitUpdateExprClass, baseExpr->getType(), VK_RValue, OK_Ordinary, false, false, false, false) 
    //START JInit
    super(StmtClass.DesignatedInitUpdateExprClass, baseExpr.getType(), ExprValueKind.VK_RValue, 
        ExprObjectKind.OK_Ordinary, false, false, false, false);
    //END JInit
    BaseAndUpdaterExprs[0] = baseExpr;
    
    InitListExpr /*P*/ ILE = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new InitListExpr(C, new SourceLocation(lBraceLoc), new ArrayRef<Expr /*P*/ >(None, true), new SourceLocation(rBraceLoc));
     });
    ILE.setType(baseExpr.getType());
    BaseAndUpdaterExprs[1] = ILE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::DesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4282,
   FQN="clang::DesignatedInitUpdateExpr::DesignatedInitUpdateExpr", NM="_ZN5clang24DesignatedInitUpdateExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ DesignatedInitUpdateExpr(EmptyShell Empty) {
    // : Expr(DesignatedInitUpdateExprClass, Empty) 
    //START JInit
    super(StmtClass.DesignatedInitUpdateExprClass, new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3696,
   FQN="clang::DesignatedInitUpdateExpr::getLocStart", NM="_ZNK5clang24DesignatedInitUpdateExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24DesignatedInitUpdateExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBase().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3700,
   FQN="clang::DesignatedInitUpdateExpr::getLocEnd", NM="_ZNK5clang24DesignatedInitUpdateExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24DesignatedInitUpdateExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getBase().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4288,
   FQN="clang::DesignatedInitUpdateExpr::classof", NM="_ZN5clang24DesignatedInitUpdateExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.DesignatedInitUpdateExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4292,
   FQN="clang::DesignatedInitUpdateExpr::getBase", NM="_ZNK5clang24DesignatedInitUpdateExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24DesignatedInitUpdateExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() /*const*/ {
    return cast_Expr(BaseAndUpdaterExprs[0]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4293,
   FQN="clang::DesignatedInitUpdateExpr::setBase", NM="_ZN5clang24DesignatedInitUpdateExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  public void setBase(Expr /*P*/ Base) {
    BaseAndUpdaterExprs[0] = Base;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::getUpdater">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4295,
   FQN="clang::DesignatedInitUpdateExpr::getUpdater", NM="_ZNK5clang24DesignatedInitUpdateExpr10getUpdaterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24DesignatedInitUpdateExpr10getUpdaterEv")
  //</editor-fold>
  public InitListExpr /*P*/ getUpdater() /*const*/ {
    return cast_InitListExpr(BaseAndUpdaterExprs[1]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::setUpdater">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4298,
   FQN="clang::DesignatedInitUpdateExpr::setUpdater", NM="_ZN5clang24DesignatedInitUpdateExpr10setUpdaterEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExpr10setUpdaterEPNS_4ExprE")
  //</editor-fold>
  public void setUpdater(Expr /*P*/ Updater) {
    BaseAndUpdaterExprs[1] = Updater;
  }

  
  // Iterators
  // children = the base and the updater
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitUpdateExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4302,
   FQN="clang::DesignatedInitUpdateExpr::children", NM="_ZN5clang24DesignatedInitUpdateExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24DesignatedInitUpdateExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(BaseAndUpdaterExprs)/*[0]*/)), new StmtIterator(create_type$ptr($AddrOf(BaseAndUpdaterExprs)/*[0]*/).$add(2)));
  }

  
  @Override public String toString() {
    return "" + "BaseAndUpdaterExprs=" + BaseAndUpdaterExprs // NOI18N
              + super.toString(); // NOI18N
  }
}
