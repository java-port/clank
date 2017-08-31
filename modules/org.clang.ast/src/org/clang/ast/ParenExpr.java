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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// ParenExpr - This represents a parethesized expression, e.g. "(1)".  This
/// AST node is only formed if full location information is requested.
//<editor-fold defaultstate="collapsed" desc="clang::ParenExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1619,
 FQN="clang::ParenExpr", NM="_ZN5clang9ParenExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExprE")
//</editor-fold>
public class ParenExpr extends /*public*/ Expr {
  private SourceLocation L;
  private SourceLocation R;
  private Stmt /*P*/ Val;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::ParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1623,
   FQN="clang::ParenExpr::ParenExpr", NM="_ZN5clang9ParenExprC1ENS_14SourceLocationES1_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExprC1ENS_14SourceLocationES1_PNS_4ExprE")
  //</editor-fold>
  public ParenExpr(SourceLocation l, SourceLocation r, Expr /*P*/ val) {
    // : Expr(ParenExprClass, val->getType(), val->getValueKind(), val->getObjectKind(), val->isTypeDependent(), val->isValueDependent(), val->isInstantiationDependent(), val->containsUnexpandedParameterPack()), L(l), R(r), Val(val) 
    //START JInit
    super(StmtClass.ParenExprClass, val.getType(), 
        val.getValueKind(), val.getObjectKind(), 
        val.isTypeDependent(), val.isValueDependent(), 
        val.isInstantiationDependent(), 
        val.containsUnexpandedParameterPack());
    this.L = new SourceLocation(l);
    this.R = new SourceLocation(r);
    this.Val = val;
    //END JInit
  }

  
  /// \brief Construct an empty parenthesized expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::ParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1632,
   FQN="clang::ParenExpr::ParenExpr", NM="_ZN5clang9ParenExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ParenExpr(EmptyShell Empty) {
    // : Expr(ParenExprClass, Empty), L(), R() 
    //START JInit
    super(StmtClass.ParenExprClass, new EmptyShell(Empty));
    this.L = new SourceLocation();
    this.R = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1635,
   FQN="clang::ParenExpr::getSubExpr", NM="_ZNK5clang9ParenExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9ParenExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_Expr(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1636,
   FQN="clang::ParenExpr::getSubExpr", NM="_ZN5clang9ParenExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_Expr(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::setSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1637,
   FQN="clang::ParenExpr::setSubExpr", NM="_ZN5clang9ParenExpr10setSubExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExpr10setSubExprEPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(Expr /*P*/ E) {
    Val = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1639,
   FQN="clang::ParenExpr::getLocStart", NM="_ZNK5clang9ParenExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9ParenExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1640,
   FQN="clang::ParenExpr::getLocEnd", NM="_ZNK5clang9ParenExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9ParenExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(R);
  }

  
  /// \brief Get the location of the left parentheses '('.
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::getLParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1643,
   FQN="clang::ParenExpr::getLParen", NM="_ZNK5clang9ParenExpr9getLParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9ParenExpr9getLParenEv")
  //</editor-fold>
  public SourceLocation getLParen() /*const*/ {
    return new SourceLocation(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::setLParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1644,
   FQN="clang::ParenExpr::setLParen", NM="_ZN5clang9ParenExpr9setLParenENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExpr9setLParenENS_14SourceLocationE")
  //</editor-fold>
  public void setLParen(SourceLocation Loc) {
    L.$assign(Loc);
  }

  
  /// \brief Get the location of the right parentheses ')'.
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::getRParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1647,
   FQN="clang::ParenExpr::getRParen", NM="_ZNK5clang9ParenExpr9getRParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang9ParenExpr9getRParenEv")
  //</editor-fold>
  public SourceLocation getRParen() /*const*/ {
    return new SourceLocation(R);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::setRParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1648,
   FQN="clang::ParenExpr::setRParen", NM="_ZN5clang9ParenExpr9setRParenENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExpr9setRParenENS_14SourceLocationE")
  //</editor-fold>
  public void setRParen(SourceLocation Loc) {
    R.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1650,
   FQN="clang::ParenExpr::classof", NM="_ZN5clang9ParenExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ParenExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ParenExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1655,
   FQN="clang::ParenExpr::children", NM="_ZN5clang9ParenExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang9ParenExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Val))), new StmtIterator(create_type$ptr($AddrOf(Val)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + ", R=" + R // NOI18N
              + ", Val=" + Val // NOI18N
              + super.toString(); // NOI18N
  }
}
