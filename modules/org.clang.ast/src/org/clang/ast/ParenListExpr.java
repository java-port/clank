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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4338,
 FQN="clang::ParenListExpr", NM="_ZN5clang13ParenListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExprE")
//</editor-fold>
public class ParenListExpr extends /*public*/ Expr {
  /*friend*/public type$ptr<Stmt /*P*/ /*P*/> Exprs;
  /*friend*/public /*uint*/int NumExprs;
  /*friend*/public SourceLocation LParenLoc;
  /*friend*/public SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::ParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3704,
   FQN="clang::ParenListExpr::ParenListExpr", NM="_ZN5clang13ParenListExprC1ERKNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExprC1ERKNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES4_")
  //</editor-fold>
  public ParenListExpr(final /*const*/ ASTContext /*&*/ C, SourceLocation lparenloc, 
      ArrayRef<Expr /*P*/ > exprs, 
      SourceLocation rparenloc) {
    // : Expr(ParenListExprClass, QualType(), VK_RValue, OK_Ordinary, false, false, false, false), NumExprs(exprs.size()), LParenLoc(lparenloc), RParenLoc(rparenloc) 
    //START JInit
    super(StmtClass.ParenListExprClass, new QualType(), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, false, false, false);
    this.NumExprs = exprs.size();
    this.LParenLoc = new SourceLocation(lparenloc);
    this.RParenLoc = new SourceLocation(rparenloc);
    //END JInit
    Exprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [exprs.size()]);
    for (/*uint*/int i = 0; i != exprs.size(); ++i) {
      if (exprs.$at(i).isTypeDependent()) {
        Unnamed_field.ExprBits.TypeDependent = true;
      }
      if (exprs.$at(i).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (exprs.$at(i).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (exprs.$at(i).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      Exprs.$set(i, exprs.$at(i));
    }
  }

  
  /// \brief Build an empty paren list.
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::ParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4348,
   FQN="clang::ParenListExpr::ParenListExpr", NM="_ZN5clang13ParenListExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ParenListExpr(EmptyShell Empty) {
    // : Expr(ParenListExprClass, Empty), LParenLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ParenListExprClass, new EmptyShell(Empty));
    this.LParenLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getNumExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4350,
   FQN="clang::ParenListExpr::getNumExprs", NM="_ZNK5clang13ParenListExpr11getNumExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13ParenListExpr11getNumExprsEv")
  //</editor-fold>
  public /*uint*/int getNumExprs() /*const*/ {
    return NumExprs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4352,
   FQN="clang::ParenListExpr::getExpr", NM="_ZNK5clang13ParenListExpr7getExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13ParenListExpr7getExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr$Const(/*uint*/int Init) /*const*/ {
    assert ($less_uint(Init, getNumExprs())) : "Initializer access out of range!";
    return cast_or_null_Expr(Exprs.$at(Init));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4357,
   FQN="clang::ParenListExpr::getExpr", NM="_ZN5clang13ParenListExpr7getExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExpr7getExprEj")
  //</editor-fold>
  public Expr /*P*/ getExpr(/*uint*/int Init) {
    assert ($less_uint(Init, getNumExprs())) : "Initializer access out of range!";
    return cast_or_null_Expr(Exprs.$at(Init));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4362,
   FQN="clang::ParenListExpr::getExprs", NM="_ZN5clang13ParenListExpr8getExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExpr8getExprsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getExprs() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, Exprs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::exprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4364,
   FQN="clang::ParenListExpr::exprs", NM="_ZN5clang13ParenListExpr5exprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExpr5exprsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > exprs() {
    return llvm.makeArrayRef(getExprs(), getNumExprs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4368,
   FQN="clang::ParenListExpr::getLParenLoc", NM="_ZNK5clang13ParenListExpr12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13ParenListExpr12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4369,
   FQN="clang::ParenListExpr::getRParenLoc", NM="_ZNK5clang13ParenListExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13ParenListExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4371,
   FQN="clang::ParenListExpr::getLocStart", NM="_ZNK5clang13ParenListExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13ParenListExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4372,
   FQN="clang::ParenListExpr::getLocEnd", NM="_ZNK5clang13ParenListExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13ParenListExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4374,
   FQN="clang::ParenListExpr::classof", NM="_ZN5clang13ParenListExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ParenListExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ParenListExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4379,
   FQN="clang::ParenListExpr::children", NM="_ZN5clang13ParenListExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13ParenListExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Exprs), new StmtIterator(Exprs.$add(NumExprs)));
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  @Override public String toString() {
    return "" + "Exprs=" + Exprs // NOI18N
              + ", NumExprs=" + NumExprs // NOI18N
              + ", LParenLoc=" + LParenLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
