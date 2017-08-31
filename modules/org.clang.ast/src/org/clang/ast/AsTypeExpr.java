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

/// AsTypeExpr - Clang builtin function __builtin_astype [OpenCL 6.2.4.2]
/// This AST node provides support for reinterpreting a type to another
/// type of the same size.
//<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4609,
 FQN="clang::AsTypeExpr", NM="_ZN5clang10AsTypeExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AsTypeExprE")
//</editor-fold>
public class AsTypeExpr extends /*public*/ Expr {
/*private:*/
  /*friend*/public Stmt /*P*/ SrcExpr;
  /*friend*/public SourceLocation BuiltinLoc;
  /*friend*/public SourceLocation RParenLoc;
  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::AsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4616,
   FQN="clang::AsTypeExpr::AsTypeExpr", NM="_ZN5clang10AsTypeExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AsTypeExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ AsTypeExpr(EmptyShell Empty) {
    // : Expr(AsTypeExprClass, Empty), BuiltinLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.AsTypeExprClass, new EmptyShell(Empty));
    this.BuiltinLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::AsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4619,
   FQN="clang::AsTypeExpr::AsTypeExpr", NM="_ZN5clang10AsTypeExprC1EPNS_4ExprENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AsTypeExprC1EPNS_4ExprENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationES6_")
  //</editor-fold>
  public AsTypeExpr(Expr /*P*/ SrcExpr, QualType DstType, 
      ExprValueKind VK, ExprObjectKind OK, 
      SourceLocation BuiltinLoc, SourceLocation RParenLoc) {
    // : Expr(AsTypeExprClass, DstType, VK, OK, DstType->isDependentType(), DstType->isDependentType() || SrcExpr->isValueDependent(), (DstType->isInstantiationDependentType() || SrcExpr->isInstantiationDependent()), (DstType->containsUnexpandedParameterPack() || SrcExpr->containsUnexpandedParameterPack())), SrcExpr(SrcExpr), BuiltinLoc(BuiltinLoc), RParenLoc(RParenLoc) 
    //START JInit
    super(StmtClass.AsTypeExprClass, new QualType(DstType), VK, OK, 
        DstType.$arrow().isDependentType(), 
        DstType.$arrow().isDependentType() || SrcExpr.isValueDependent(), 
        (DstType.$arrow().isInstantiationDependentType()
           || SrcExpr.isInstantiationDependent()), 
        (DstType.$arrow().containsUnexpandedParameterPack()
           || SrcExpr.containsUnexpandedParameterPack()));
    this.SrcExpr = SrcExpr;
    this.BuiltinLoc = new SourceLocation(BuiltinLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    //END JInit
  }

  
  /// getSrcExpr - Return the Expr to be converted.
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::getSrcExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4632,
   FQN="clang::AsTypeExpr::getSrcExpr", NM="_ZNK5clang10AsTypeExpr10getSrcExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AsTypeExpr10getSrcExprEv")
  //</editor-fold>
  public Expr /*P*/ getSrcExpr() /*const*/ {
    return cast_Expr(SrcExpr);
  }

  
  /// getBuiltinLoc - Return the location of the __builtin_astype token.
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4635,
   FQN="clang::AsTypeExpr::getBuiltinLoc", NM="_ZNK5clang10AsTypeExpr13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AsTypeExpr13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(BuiltinLoc);
  }

  
  /// getRParenLoc - Return the location of final right parenthesis.
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4638,
   FQN="clang::AsTypeExpr::getRParenLoc", NM="_ZNK5clang10AsTypeExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AsTypeExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4640,
   FQN="clang::AsTypeExpr::getLocStart", NM="_ZNK5clang10AsTypeExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AsTypeExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4641,
   FQN="clang::AsTypeExpr::getLocEnd", NM="_ZNK5clang10AsTypeExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AsTypeExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4643,
   FQN="clang::AsTypeExpr::classof", NM="_ZN5clang10AsTypeExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AsTypeExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.AsTypeExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::AsTypeExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4648,
   FQN="clang::AsTypeExpr::children", NM="_ZN5clang10AsTypeExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AsTypeExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SrcExpr))), new StmtIterator(create_type$ptr($AddrOf(SrcExpr)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "SrcExpr=" + SrcExpr // NOI18N
              + ", BuiltinLoc=" + BuiltinLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
