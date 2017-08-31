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

/// ConvertVectorExpr - Clang builtin function __builtin_convertvector
/// This AST node provides support for converting a vector type to another
/// vector type of the same arity.
//<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3487,
 FQN="clang::ConvertVectorExpr", NM="_ZN5clang17ConvertVectorExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ConvertVectorExprE")
//</editor-fold>
public class ConvertVectorExpr extends /*public*/ Expr {
/*private:*/
  /*friend*/public Stmt /*P*/ SrcExpr;
  /*friend*/public TypeSourceInfo /*P*/ TInfo;
  /*friend*/public SourceLocation BuiltinLoc;
  /*friend*/public SourceLocation RParenLoc;
  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::ConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3495,
   FQN="clang::ConvertVectorExpr::ConvertVectorExpr", NM="_ZN5clang17ConvertVectorExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ConvertVectorExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ ConvertVectorExpr(EmptyShell Empty) {
    // : Expr(ConvertVectorExprClass, Empty), BuiltinLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ConvertVectorExprClass, new EmptyShell(Empty));
    this.BuiltinLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::ConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3498,
   FQN="clang::ConvertVectorExpr::ConvertVectorExpr", NM="_ZN5clang17ConvertVectorExprC1EPNS_4ExprEPNS_14TypeSourceInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ConvertVectorExprC1EPNS_4ExprEPNS_14TypeSourceInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES8_")
  //</editor-fold>
  public ConvertVectorExpr(Expr /*P*/ SrcExpr, TypeSourceInfo /*P*/ TI, QualType DstType, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation BuiltinLoc, SourceLocation RParenLoc) {
    // : Expr(ConvertVectorExprClass, DstType, VK, OK, DstType->isDependentType(), DstType->isDependentType() || SrcExpr->isValueDependent(), (DstType->isInstantiationDependentType() || SrcExpr->isInstantiationDependent()), (DstType->containsUnexpandedParameterPack() || SrcExpr->containsUnexpandedParameterPack())), SrcExpr(SrcExpr), TInfo(TI), BuiltinLoc(BuiltinLoc), RParenLoc(RParenLoc) 
    //START JInit
    super(StmtClass.ConvertVectorExprClass, new QualType(DstType), VK, OK, 
        DstType.$arrow().isDependentType(), 
        DstType.$arrow().isDependentType() || SrcExpr.isValueDependent(), 
        (DstType.$arrow().isInstantiationDependentType()
           || SrcExpr.isInstantiationDependent()), 
        (DstType.$arrow().containsUnexpandedParameterPack()
           || SrcExpr.containsUnexpandedParameterPack()));
    this.SrcExpr = SrcExpr;
    this.TInfo = TI;
    this.BuiltinLoc = new SourceLocation(BuiltinLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    //END JInit
  }

  
  /// getSrcExpr - Return the Expr to be converted.
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::getSrcExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3511,
   FQN="clang::ConvertVectorExpr::getSrcExpr", NM="_ZNK5clang17ConvertVectorExpr10getSrcExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ConvertVectorExpr10getSrcExprEv")
  //</editor-fold>
  public Expr /*P*/ getSrcExpr() /*const*/ {
    return cast_Expr(SrcExpr);
  }

  
  /// getTypeSourceInfo - Return the destination type.
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3514,
   FQN="clang::ConvertVectorExpr::getTypeSourceInfo", NM="_ZNK5clang17ConvertVectorExpr17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ConvertVectorExpr17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return TInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::setTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3517,
   FQN="clang::ConvertVectorExpr::setTypeSourceInfo", NM="_ZN5clang17ConvertVectorExpr17setTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ConvertVectorExpr17setTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeSourceInfo(TypeSourceInfo /*P*/ ti) {
    TInfo = ti;
  }

  
  /// getBuiltinLoc - Return the location of the __builtin_convertvector token.
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3522,
   FQN="clang::ConvertVectorExpr::getBuiltinLoc", NM="_ZNK5clang17ConvertVectorExpr13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ConvertVectorExpr13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(BuiltinLoc);
  }

  
  /// getRParenLoc - Return the location of final right parenthesis.
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3525,
   FQN="clang::ConvertVectorExpr::getRParenLoc", NM="_ZNK5clang17ConvertVectorExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ConvertVectorExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3527,
   FQN="clang::ConvertVectorExpr::getLocStart", NM="_ZNK5clang17ConvertVectorExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ConvertVectorExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3528,
   FQN="clang::ConvertVectorExpr::getLocEnd", NM="_ZNK5clang17ConvertVectorExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang17ConvertVectorExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3530,
   FQN="clang::ConvertVectorExpr::classof", NM="_ZN5clang17ConvertVectorExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ConvertVectorExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ConvertVectorExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ConvertVectorExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3535,
   FQN="clang::ConvertVectorExpr::children", NM="_ZN5clang17ConvertVectorExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang17ConvertVectorExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SrcExpr))), new StmtIterator(create_type$ptr($AddrOf(SrcExpr)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "SrcExpr=" + SrcExpr // NOI18N
              + ", TInfo=" + TInfo // NOI18N
              + ", BuiltinLoc=" + BuiltinLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
