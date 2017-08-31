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
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief An expression trait intrinsic.
///
/// Example:
/// \code
///   __is_lvalue_expr(std::cout) == true
///   __is_lvalue_expr(1) == false
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2428,
 FQN="clang::ExpressionTraitExpr", NM="_ZN5clang19ExpressionTraitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19ExpressionTraitExprE")
//</editor-fold>
public class ExpressionTraitExpr extends /*public*/ Expr {
  /// \brief The trait. A ExpressionTrait enum in MSVC compatible unsigned.
  /*friend*/public /*uint*/int ET /*: 31*/;
  /// \brief The value of the type trait. Unspecified if dependent.
  /*friend*/public /*JBIT unsigned int*/ boolean Value /*: 1*/;
  
  /// \brief The location of the type trait keyword.
  /*friend*/public SourceLocation Loc;
  
  /// \brief The location of the closing paren.
  /*friend*/public SourceLocation RParen;
  
  /// \brief The expression being queried.
  /*friend*/public Expr /*P*/ QueriedExpression;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::ExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2443,
   FQN="clang::ExpressionTraitExpr::ExpressionTraitExpr", NM="_ZN5clang19ExpressionTraitExprC1ENS_14SourceLocationENS_15ExpressionTraitEPNS_4ExprEbS1_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19ExpressionTraitExprC1ENS_14SourceLocationENS_15ExpressionTraitEPNS_4ExprEbS1_NS_8QualTypeE")
  //</editor-fold>
  public ExpressionTraitExpr(SourceLocation loc, ExpressionTrait et, 
      Expr /*P*/ queried, boolean value, 
      SourceLocation rparen, QualType resultType) {
    // : Expr(ExpressionTraitExprClass, resultType, VK_RValue, OK_Ordinary, false, queried->isTypeDependent(), queried->isInstantiationDependent(), queried->containsUnexpandedParameterPack()), ET(et), Value(value), Loc(loc), RParen(rparen), QueriedExpression(queried) 
    //START JInit
    super(StmtClass.ExpressionTraitExprClass, new QualType(resultType), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false,  // Not type-dependent
        // Value-dependent if the argument is type-dependent.
        queried.isTypeDependent(), 
        queried.isInstantiationDependent(), 
        queried.containsUnexpandedParameterPack());
    this.ET = et.getValue();
    this.Value = value;
    this.Loc = new SourceLocation(loc);
    this.RParen = new SourceLocation(rparen);
    this.QueriedExpression = queried;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::ExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2455,
   FQN="clang::ExpressionTraitExpr::ExpressionTraitExpr", NM="_ZN5clang19ExpressionTraitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19ExpressionTraitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ExpressionTraitExpr(EmptyShell Empty) {
    // : Expr(ExpressionTraitExprClass, Empty), ET(0), Value(false), Loc(), RParen(), QueriedExpression(implicit Expr * ()) 
    //START JInit
    super(StmtClass.ExpressionTraitExprClass, new EmptyShell(Empty));
    this.ET = 0;
    this.Value = false;
    this.Loc = new SourceLocation();
    this.RParen = new SourceLocation();
    this.QueriedExpression = /*implicit-init*/((Expr /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2459,
   FQN="clang::ExpressionTraitExpr::getLocStart", NM="_ZNK5clang19ExpressionTraitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19ExpressionTraitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2460,
   FQN="clang::ExpressionTraitExpr::getLocEnd", NM="_ZNK5clang19ExpressionTraitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19ExpressionTraitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::getTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2462,
   FQN="clang::ExpressionTraitExpr::getTrait", NM="_ZNK5clang19ExpressionTraitExpr8getTraitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19ExpressionTraitExpr8getTraitEv")
  //</editor-fold>
  public ExpressionTrait getTrait() /*const*/ {
    return /*static_cast*/ExpressionTrait.valueOf(ET);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::getQueriedExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2464,
   FQN="clang::ExpressionTraitExpr::getQueriedExpression", NM="_ZNK5clang19ExpressionTraitExpr20getQueriedExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19ExpressionTraitExpr20getQueriedExpressionEv")
  //</editor-fold>
  public Expr /*P*/ getQueriedExpression() /*const*/ {
    return QueriedExpression;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2466,
   FQN="clang::ExpressionTraitExpr::getValue", NM="_ZNK5clang19ExpressionTraitExpr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang19ExpressionTraitExpr8getValueEv")
  //</editor-fold>
  public boolean getValue() /*const*/ {
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2468,
   FQN="clang::ExpressionTraitExpr::classof", NM="_ZN5clang19ExpressionTraitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19ExpressionTraitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ExpressionTraitExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ExpressionTraitExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2473,
   FQN="clang::ExpressionTraitExpr::children", NM="_ZN5clang19ExpressionTraitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang19ExpressionTraitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "ET=" + ET // NOI18N
              + ", Value=" + Value // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", RParen=" + RParen // NOI18N
              + ", QueriedExpression=" + QueriedExpression // NOI18N
              + super.toString(); // NOI18N
  }
}
