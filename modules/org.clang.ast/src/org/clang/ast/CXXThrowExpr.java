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

/// \brief A C++ throw-expression (C++ [except.throw]).
///
/// This handles 'throw' (for re-throwing the current exception) and
/// 'throw' assignment-expression.  When assignment-expression isn't
/// present, Op will be null.
//<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 913,
 FQN="clang::CXXThrowExpr", NM="_ZN5clang12CXXThrowExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXThrowExprE")
//</editor-fold>
public class CXXThrowExpr extends /*public*/ Expr {
  /*friend*/public Stmt /*P*/ Op;
  /*friend*/public SourceLocation ThrowLoc;
  /// \brief Whether the thrown variable (if any) is in scope.
  /*friend*/public /*JBIT unsigned int*/ boolean IsThrownVariableInScope /*: 1*/;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  // \p Ty is the void type which is used as the result type of the
  // expression.  The \p l is the location of the throw keyword.  \p expr
  // can by null, if the optional expression to throw isn't present.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::CXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 925,
   FQN="clang::CXXThrowExpr::CXXThrowExpr", NM="_ZN5clang12CXXThrowExprC1EPNS_4ExprENS_8QualTypeENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXThrowExprC1EPNS_4ExprENS_8QualTypeENS_14SourceLocationEb")
  //</editor-fold>
  public CXXThrowExpr(Expr /*P*/ expr, QualType Ty, SourceLocation l, 
      boolean IsThrownVariableInScope) {
    // : Expr(CXXThrowExprClass, Ty, VK_RValue, OK_Ordinary, false, false, expr && expr->isInstantiationDependent(), expr && expr->containsUnexpandedParameterPack()), Op(expr), ThrowLoc(l), IsThrownVariableInScope(IsThrownVariableInScope) 
    //START JInit
    super(StmtClass.CXXThrowExprClass, new QualType(Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        (expr != null) && expr.isInstantiationDependent(), 
        (expr != null) && expr.containsUnexpandedParameterPack());
    this.Op = expr;
    this.ThrowLoc = new SourceLocation(l);
    this.IsThrownVariableInScope = IsThrownVariableInScope;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::CXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 931,
   FQN="clang::CXXThrowExpr::CXXThrowExpr", NM="_ZN5clang12CXXThrowExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXThrowExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXThrowExpr(EmptyShell Empty) {
    // : Expr(CXXThrowExprClass, Empty), ThrowLoc() 
    //START JInit
    super(StmtClass.CXXThrowExprClass, new EmptyShell(Empty));
    this.ThrowLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 933,
   FQN="clang::CXXThrowExpr::getSubExpr", NM="_ZNK5clang12CXXThrowExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12CXXThrowExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return cast_or_null_Expr(Op);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 934,
   FQN="clang::CXXThrowExpr::getSubExpr", NM="_ZN5clang12CXXThrowExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXThrowExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return cast_or_null_Expr(Op);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::getThrowLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 936,
   FQN="clang::CXXThrowExpr::getThrowLoc", NM="_ZNK5clang12CXXThrowExpr11getThrowLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12CXXThrowExpr11getThrowLocEv")
  //</editor-fold>
  public SourceLocation getThrowLoc() /*const*/ {
    return new SourceLocation(ThrowLoc);
  }

  
  /// \brief Determines whether the variable thrown by this expression (if any!)
  /// is within the innermost try block.
  ///
  /// This information is required to determine whether the NRVO can apply to
  /// this variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::isThrownVariableInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 943,
   FQN="clang::CXXThrowExpr::isThrownVariableInScope", NM="_ZNK5clang12CXXThrowExpr23isThrownVariableInScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12CXXThrowExpr23isThrownVariableInScopeEv")
  //</editor-fold>
  public boolean isThrownVariableInScope() /*const*/ {
    return IsThrownVariableInScope;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 945,
   FQN="clang::CXXThrowExpr::getLocStart", NM="_ZNK5clang12CXXThrowExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12CXXThrowExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(ThrowLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 946,
   FQN="clang::CXXThrowExpr::getLocEnd", NM="_ZNK5clang12CXXThrowExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12CXXThrowExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (!(getSubExpr$Const() != null)) {
      return new SourceLocation(ThrowLoc);
    }
    return getSubExpr$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 952,
   FQN="clang::CXXThrowExpr::classof", NM="_ZN5clang12CXXThrowExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXThrowExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXThrowExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXThrowExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 957,
   FQN="clang::CXXThrowExpr::children", NM="_ZN5clang12CXXThrowExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12CXXThrowExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator($AddrOf(create_type$ptr2ConstT(Op))), new StmtIterator((Op != null) ? $AddrOf(create_type$ptr2ConstT(Op)).$add(1) : $AddrOf(create_type$ptr2ConstT(Op))));
  }

  
  @Override public String toString() {
    return "" + "Op=" + Op // NOI18N
              + ", ThrowLoc=" + ThrowLoc // NOI18N
              + ", IsThrownVariableInScope=" + IsThrownVariableInScope // NOI18N
              + super.toString(); // NOI18N
  }
}
