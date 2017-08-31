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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// ShuffleVectorExpr - clang-specific builtin-in function
/// __builtin_shufflevector.
/// This AST node represents a operator that does a constant
/// shuffle, similar to LLVM's shufflevector instruction. It takes
/// two vectors and a variable number of constant indices,
/// and returns the appropriately shuffled vector.
//<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3422,
 FQN="clang::ShuffleVectorExpr", NM="_ZN5clang17ShuffleVectorExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExprE")
//</editor-fold>
public class ShuffleVectorExpr extends /*public*/ Expr {
  private SourceLocation BuiltinLoc;
  private SourceLocation RParenLoc;
  
  // SubExprs - the list of values passed to the __builtin_shufflevector
  // function. The first two are vectors, and the rest are constant
  // indices.  The number of values in this list is always
  // 2+the number of indices in the vector type.
  private type$ptr<Stmt /*P*/ /*P*/> SubExprs;
  private /*uint*/int NumExprs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::ShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3425,
   FQN="clang::ShuffleVectorExpr::ShuffleVectorExpr", NM="_ZN5clang17ShuffleVectorExprC1ERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeENS_14SourceLocationESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExprC1ERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeENS_14SourceLocationESA_")
  //</editor-fold>
  public ShuffleVectorExpr(final /*const*/ ASTContext /*&*/ C, ArrayRef<Expr /*P*/ > args, 
      QualType Type, SourceLocation BLoc, 
      SourceLocation RP) {
    // : Expr(ShuffleVectorExprClass, Type, VK_RValue, OK_Ordinary, Type->isDependentType(), Type->isDependentType(), Type->isInstantiationDependentType(), Type->containsUnexpandedParameterPack()), BuiltinLoc(BLoc), RParenLoc(RP), NumExprs(args.size()) 
    //START JInit
    super(StmtClass.ShuffleVectorExprClass, new QualType(Type), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        Type.$arrow().isDependentType(), Type.$arrow().isDependentType(), 
        Type.$arrow().isInstantiationDependentType(), 
        Type.$arrow().containsUnexpandedParameterPack());
    this.BuiltinLoc = new SourceLocation(BLoc);
    this.RParenLoc = new SourceLocation(RP);
    this.NumExprs = args.size();
    //END JInit
    SubExprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [args.size()]);
    for (/*uint*/int i = 0; i != args.size(); i++) {
      if (args.$at(i).isTypeDependent()) {
        Unnamed_field.ExprBits.TypeDependent = true;
      }
      if (args.$at(i).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (args.$at(i).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (args.$at(i).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      SubExprs.$set(i, args.$at(i));
    }
  }

  
  /// \brief Build an empty vector-shuffle expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::ShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3437,
   FQN="clang::ShuffleVectorExpr::ShuffleVectorExpr", NM="_ZN5clang17ShuffleVectorExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ShuffleVectorExpr(EmptyShell Empty) {
    // : Expr(ShuffleVectorExprClass, Empty), BuiltinLoc(), RParenLoc(), SubExprs(null) 
    //START JInit
    super(StmtClass.ShuffleVectorExprClass, new EmptyShell(Empty));
    this.BuiltinLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    this.SubExprs = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3440,
   FQN="clang::ShuffleVectorExpr::getBuiltinLoc", NM="_ZNK5clang17ShuffleVectorExpr13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::setBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3441,
   FQN="clang::ShuffleVectorExpr::setBuiltinLoc", NM="_ZN5clang17ShuffleVectorExpr13setBuiltinLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr13setBuiltinLocENS_14SourceLocationE")
  //</editor-fold>
  public void setBuiltinLoc(SourceLocation L) {
    BuiltinLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3443,
   FQN="clang::ShuffleVectorExpr::getRParenLoc", NM="_ZNK5clang17ShuffleVectorExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3444,
   FQN="clang::ShuffleVectorExpr::setRParenLoc", NM="_ZN5clang17ShuffleVectorExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3446,
   FQN="clang::ShuffleVectorExpr::getLocStart", NM="_ZNK5clang17ShuffleVectorExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3447,
   FQN="clang::ShuffleVectorExpr::getLocEnd", NM="_ZNK5clang17ShuffleVectorExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3449,
   FQN="clang::ShuffleVectorExpr::classof", NM="_ZN5clang17ShuffleVectorExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ShuffleVectorExprClass;
  }

  
  /// getNumSubExprs - Return the size of the SubExprs array.  This includes the
  /// constant expression, the actual arguments passed in, and the function
  /// pointers.
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getNumSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3456,
   FQN="clang::ShuffleVectorExpr::getNumSubExprs", NM="_ZNK5clang17ShuffleVectorExpr14getNumSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr14getNumSubExprsEv")
  //</editor-fold>
  public /*uint*/int getNumSubExprs() /*const*/ {
    return NumExprs;
  }

  
  /// \brief Retrieve the array of expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3459,
   FQN="clang::ShuffleVectorExpr::getSubExprs", NM="_ZN5clang17ShuffleVectorExpr11getSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr11getSubExprsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getSubExprs() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, SubExprs));
  }

  
  /// getExpr - Return the Expr at the specified index.
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3462,
   FQN="clang::ShuffleVectorExpr::getExpr", NM="_ZN5clang17ShuffleVectorExpr7getExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr7getExprEj")
  //</editor-fold>
  public Expr /*P*/ getExpr(/*uint*/int Index) {
    assert (($less_uint(Index, NumExprs))) : "Arg access out of range!";
    return cast_Expr(SubExprs.$at(Index));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3466,
   FQN="clang::ShuffleVectorExpr::getExpr", NM="_ZNK5clang17ShuffleVectorExpr7getExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr7getExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr$Const(/*uint*/int Index) /*const*/ {
    assert (($less_uint(Index, NumExprs))) : "Arg access out of range!";
    return cast_Expr(SubExprs.$at(Index));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::setExprs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3449,
   FQN="clang::ShuffleVectorExpr::setExprs", NM="_ZN5clang17ShuffleVectorExpr8setExprsERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr8setExprsERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public void setExprs(final /*const*/ ASTContext /*&*/ C, ArrayRef<Expr /*P*/ > Exprs) {
    if (Native.$bool(SubExprs)) {
      C.Deallocate(SubExprs);
    }
    
    this.NumExprs = Exprs.size();
    SubExprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [NumExprs]);
    memcpy(SubExprs, Exprs.data(), (true/*JAVA*/? 1 : $sizeof_ptr(/*Expr  */)) * Exprs.size(), true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::getShuffleMaskIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3473,
   FQN="clang::ShuffleVectorExpr::getShuffleMaskIdx", NM="_ZNK5clang17ShuffleVectorExpr17getShuffleMaskIdxERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ShuffleVectorExpr17getShuffleMaskIdxERKNS_10ASTContextEj")
  //</editor-fold>
  public APSInt getShuffleMaskIdx(final /*const*/ ASTContext /*&*/ Ctx, /*uint*/int N) /*const*/ {
    assert (($less_uint(N, NumExprs - 2))) : "Shuffle idx out of range!";
    return getExpr$Const(N + 2).EvaluateKnownConstInt(Ctx);
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ShuffleVectorExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3479,
   FQN="clang::ShuffleVectorExpr::children", NM="_ZN5clang17ShuffleVectorExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ShuffleVectorExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(SubExprs/*.$set$addr(0)*/), new StmtIterator(SubExprs/*.$set$addr(0)*/.$add(NumExprs)));
  }

  
  @Override public String toString() {
    return "" + "BuiltinLoc=" + BuiltinLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", NumExprs=" + NumExprs // NOI18N
              + super.toString(); // NOI18N
  }
}
