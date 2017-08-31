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

/// ObjCIsaExpr - Represent X->isa and X.isa when X is an ObjC 'id' type.
/// (similar in spirit to MemberExpr).
//<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1383,
 FQN="clang::ObjCIsaExpr", NM="_ZN5clang11ObjCIsaExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExprE")
//</editor-fold>
public class ObjCIsaExpr extends /*public*/ Expr {
  /// Base - the expression for the base object pointer.
  private Stmt /*P*/ Base;
  
  /// IsaMemberLoc - This is the location of the 'isa'.
  private SourceLocation IsaMemberLoc;
  
  /// OpLoc - This is the location of '.' or '->'
  private SourceLocation OpLoc;
  
  /// IsArrow - True if this is "X->F", false if this is "X.F".
  private boolean IsArrow;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::ObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1396,
   FQN="clang::ObjCIsaExpr::ObjCIsaExpr", NM="_ZN5clang11ObjCIsaExprC1EPNS_4ExprEbNS_14SourceLocationES3_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExprC1EPNS_4ExprEbNS_14SourceLocationES3_NS_8QualTypeE")
  //</editor-fold>
  public ObjCIsaExpr(Expr /*P*/ base, boolean isarrow, SourceLocation l, SourceLocation oploc, 
      QualType ty) {
    // : Expr(ObjCIsaExprClass, ty, VK_LValue, OK_Ordinary, /*TypeDependent=*/ false, base->isValueDependent(), base->isInstantiationDependent(), /*ContainsUnexpandedParameterPack=*/ false), Base(base), IsaMemberLoc(l), OpLoc(oploc), IsArrow(isarrow) 
    //START JInit
    super(StmtClass.ObjCIsaExprClass, new QualType(ty), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        false, base.isValueDependent(), 
        base.isInstantiationDependent(), 
        false);
    this.Base = base;
    this.IsaMemberLoc = new SourceLocation(l);
    this.OpLoc = new SourceLocation(oploc);
    this.IsArrow = isarrow;
    //END JInit
  }

  
  /// \brief Build an empty expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::ObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1405,
   FQN="clang::ObjCIsaExpr::ObjCIsaExpr", NM="_ZN5clang11ObjCIsaExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCIsaExpr(EmptyShell Empty) {
    // : Expr(ObjCIsaExprClass, Empty), IsaMemberLoc(), OpLoc() 
    //START JInit
    super(StmtClass.ObjCIsaExprClass, new EmptyShell(Empty));
    this.IsaMemberLoc = new SourceLocation();
    this.OpLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1407,
   FQN="clang::ObjCIsaExpr::setBase", NM="_ZN5clang11ObjCIsaExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  public void setBase(Expr /*P*/ E) {
    Base = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1408,
   FQN="clang::ObjCIsaExpr::getBase", NM="_ZNK5clang11ObjCIsaExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() /*const*/ {
    return cast_Expr(Base);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1410,
   FQN="clang::ObjCIsaExpr::isArrow", NM="_ZNK5clang11ObjCIsaExpr7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return IsArrow;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::setArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1411,
   FQN="clang::ObjCIsaExpr::setArrow", NM="_ZN5clang11ObjCIsaExpr8setArrowEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExpr8setArrowEb")
  //</editor-fold>
  public void setArrow(boolean A) {
    IsArrow = A;
  }

  
  /// getMemberLoc - Return the location of the "member", in X->F, it is the
  /// location of 'F'.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getIsaMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1415,
   FQN="clang::ObjCIsaExpr::getIsaMemberLoc", NM="_ZNK5clang11ObjCIsaExpr15getIsaMemberLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr15getIsaMemberLocEv")
  //</editor-fold>
  public SourceLocation getIsaMemberLoc() /*const*/ {
    return new SourceLocation(IsaMemberLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::setIsaMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1416,
   FQN="clang::ObjCIsaExpr::setIsaMemberLoc", NM="_ZN5clang11ObjCIsaExpr15setIsaMemberLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExpr15setIsaMemberLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIsaMemberLoc(SourceLocation L) {
    IsaMemberLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getOpLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1418,
   FQN="clang::ObjCIsaExpr::getOpLoc", NM="_ZNK5clang11ObjCIsaExpr8getOpLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr8getOpLocEv")
  //</editor-fold>
  public SourceLocation getOpLoc() /*const*/ {
    return new SourceLocation(OpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::setOpLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1419,
   FQN="clang::ObjCIsaExpr::setOpLoc", NM="_ZN5clang11ObjCIsaExpr8setOpLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExpr8setOpLocENS_14SourceLocationE")
  //</editor-fold>
  public void setOpLoc(SourceLocation L) {
    OpLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1421,
   FQN="clang::ObjCIsaExpr::getLocStart", NM="_ZNK5clang11ObjCIsaExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getBase().getLocStart();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getBaseLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1425,
   FQN="clang::ObjCIsaExpr::getBaseLocEnd", NM="_ZNK5clang11ObjCIsaExpr13getBaseLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr13getBaseLocEndEv")
  //</editor-fold>
  public SourceLocation getBaseLocEnd() /*const*//* __attribute__((pure))*/ {
    return getBase().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1429,
   FQN="clang::ObjCIsaExpr::getLocEnd", NM="_ZNK5clang11ObjCIsaExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(IsaMemberLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1431,
   FQN="clang::ObjCIsaExpr::getExprLoc", NM="_ZNK5clang11ObjCIsaExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang11ObjCIsaExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(IsaMemberLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1433,
   FQN="clang::ObjCIsaExpr::classof", NM="_ZN5clang11ObjCIsaExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCIsaExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIsaExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 1438,
   FQN="clang::ObjCIsaExpr::children", NM="_ZN5clang11ObjCIsaExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang11ObjCIsaExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Base))), new StmtIterator(create_type$ptr($AddrOf(Base)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", IsaMemberLoc=" + IsaMemberLoc // NOI18N
              + ", OpLoc=" + OpLoc // NOI18N
              + ", IsArrow=" + IsArrow // NOI18N
              + super.toString(); // NOI18N
  }
}
