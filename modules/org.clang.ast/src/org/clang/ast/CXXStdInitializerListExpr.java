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


/// \brief Implicit construction of a std::initializer_list<T> object from an
/// array temporary within list-initialization (C++11 [dcl.init.list]p5).
//<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 533,
 FQN="clang::CXXStdInitializerListExpr", NM="_ZN5clang25CXXStdInitializerListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25CXXStdInitializerListExprE")
//</editor-fold>
public class CXXStdInitializerListExpr extends /*public*/ Expr {
  /*friend*/public Stmt /*P*/ SubExpr;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::CXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 536,
   FQN="clang::CXXStdInitializerListExpr::CXXStdInitializerListExpr", NM="_ZN5clang25CXXStdInitializerListExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25CXXStdInitializerListExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ CXXStdInitializerListExpr(EmptyShell Empty) {
    // : Expr(CXXStdInitializerListExprClass, Empty), SubExpr(null) 
    //START JInit
    super(StmtClass.CXXStdInitializerListExprClass, new EmptyShell(Empty));
    this.SubExpr = null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::CXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 540,
   FQN="clang::CXXStdInitializerListExpr::CXXStdInitializerListExpr", NM="_ZN5clang25CXXStdInitializerListExprC1ENS_8QualTypeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25CXXStdInitializerListExprC1ENS_8QualTypeEPNS_4ExprE")
  //</editor-fold>
  public CXXStdInitializerListExpr(QualType Ty, Expr /*P*/ SubExpr) {
    // : Expr(CXXStdInitializerListExprClass, Ty, VK_RValue, OK_Ordinary, Ty->isDependentType(), SubExpr->isValueDependent(), SubExpr->isInstantiationDependent(), SubExpr->containsUnexpandedParameterPack()), SubExpr(SubExpr) 
    //START JInit
    super(StmtClass.CXXStdInitializerListExprClass, new QualType(Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        Ty.$arrow().isDependentType(), SubExpr.isValueDependent(), 
        SubExpr.isInstantiationDependent(), 
        SubExpr.containsUnexpandedParameterPack());
    this.SubExpr = SubExpr;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 547,
   FQN="clang::CXXStdInitializerListExpr::getSubExpr", NM="_ZN5clang25CXXStdInitializerListExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25CXXStdInitializerListExpr10getSubExprEv")
  //</editor-fold>
  public Expr /*P*/ getSubExpr() {
    return ((/*static_cast*/Expr /*P*/ )(SubExpr));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 548,
   FQN="clang::CXXStdInitializerListExpr::getSubExpr", NM="_ZNK5clang25CXXStdInitializerListExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25CXXStdInitializerListExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSubExpr$Const() /*const*/ {
    return ((/*static_cast*//*const*/ Expr /*P*/ )(SubExpr));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 550,
   FQN="clang::CXXStdInitializerListExpr::getLocStart", NM="_ZNK5clang25CXXStdInitializerListExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25CXXStdInitializerListExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 553,
   FQN="clang::CXXStdInitializerListExpr::getLocEnd", NM="_ZNK5clang25CXXStdInitializerListExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25CXXStdInitializerListExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getLocEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 556,
   FQN="clang::CXXStdInitializerListExpr::getSourceRange", NM="_ZNK5clang25CXXStdInitializerListExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang25CXXStdInitializerListExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return SubExpr.getSourceRange();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 560,
   FQN="clang::CXXStdInitializerListExpr::classof", NM="_ZN5clang25CXXStdInitializerListExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25CXXStdInitializerListExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ S) {
    return S.getStmtClass() == StmtClass.CXXStdInitializerListExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStdInitializerListExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 564,
   FQN="clang::CXXStdInitializerListExpr::children", NM="_ZN5clang25CXXStdInitializerListExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang25CXXStdInitializerListExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubExpr))), new StmtIterator(create_type$ptr($AddrOf(SubExpr)).$add(1)));
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "SubExpr=" + SubExpr // NOI18N
              + super.toString(); // NOI18N
  }
}
