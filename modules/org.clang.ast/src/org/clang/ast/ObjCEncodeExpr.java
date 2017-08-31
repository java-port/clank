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


/// ObjCEncodeExpr, used for \@encode in Objective-C.  \@encode has the same
/// type and behavior as StringLiteral except that the string initializer is
/// obtained from ASTContext with the encoding type as an argument.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 355,
 FQN="clang::ObjCEncodeExpr", NM="_ZN5clang14ObjCEncodeExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExprE")
//</editor-fold>
public class ObjCEncodeExpr extends /*public*/ Expr {
  private TypeSourceInfo /*P*/ EncodedType;
  private SourceLocation AtLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::ObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 359,
   FQN="clang::ObjCEncodeExpr::ObjCEncodeExpr", NM="_ZN5clang14ObjCEncodeExprC1ENS_8QualTypeEPNS_14TypeSourceInfoENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExprC1ENS_8QualTypeEPNS_14TypeSourceInfoENS_14SourceLocationES4_")
  //</editor-fold>
  public ObjCEncodeExpr(QualType T, TypeSourceInfo /*P*/ EncodedType, 
      SourceLocation at, SourceLocation rp) {
    // : Expr(ObjCEncodeExprClass, T, VK_LValue, OK_Ordinary, EncodedType->getType()->isDependentType(), EncodedType->getType()->isDependentType(), EncodedType->getType()->isInstantiationDependentType(), EncodedType->getType()->containsUnexpandedParameterPack()), EncodedType(EncodedType), AtLoc(at), RParenLoc(rp) 
    //START JInit
    super(StmtClass.ObjCEncodeExprClass, new QualType(T), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
        EncodedType.getType().$arrow().isDependentType(), 
        EncodedType.getType().$arrow().isDependentType(), 
        EncodedType.getType().$arrow().isInstantiationDependentType(), 
        EncodedType.getType().$arrow().containsUnexpandedParameterPack());
    this.EncodedType = EncodedType;
    this.AtLoc = new SourceLocation(at);
    this.RParenLoc = new SourceLocation(rp);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::ObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 368,
   FQN="clang::ObjCEncodeExpr::ObjCEncodeExpr", NM="_ZN5clang14ObjCEncodeExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCEncodeExpr(EmptyShell Empty) {
    // : Expr(ObjCEncodeExprClass, Empty), AtLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ObjCEncodeExprClass, new EmptyShell(Empty));
    this.AtLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 371,
   FQN="clang::ObjCEncodeExpr::getAtLoc", NM="_ZNK5clang14ObjCEncodeExpr8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang14ObjCEncodeExpr8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 372,
   FQN="clang::ObjCEncodeExpr::setAtLoc", NM="_ZN5clang14ObjCEncodeExpr8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExpr8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation L) {
    AtLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 373,
   FQN="clang::ObjCEncodeExpr::getRParenLoc", NM="_ZNK5clang14ObjCEncodeExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang14ObjCEncodeExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 374,
   FQN="clang::ObjCEncodeExpr::setRParenLoc", NM="_ZN5clang14ObjCEncodeExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::getEncodedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 376,
   FQN="clang::ObjCEncodeExpr::getEncodedType", NM="_ZNK5clang14ObjCEncodeExpr14getEncodedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang14ObjCEncodeExpr14getEncodedTypeEv")
  //</editor-fold>
  public QualType getEncodedType() /*const*/ {
    return EncodedType.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::getEncodedTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 378,
   FQN="clang::ObjCEncodeExpr::getEncodedTypeSourceInfo", NM="_ZNK5clang14ObjCEncodeExpr24getEncodedTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang14ObjCEncodeExpr24getEncodedTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getEncodedTypeSourceInfo() /*const*/ {
    return EncodedType;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::setEncodedTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 379,
   FQN="clang::ObjCEncodeExpr::setEncodedTypeSourceInfo", NM="_ZN5clang14ObjCEncodeExpr24setEncodedTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExpr24setEncodedTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setEncodedTypeSourceInfo(TypeSourceInfo /*P*/ EncType) {
    EncodedType = EncType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 383,
   FQN="clang::ObjCEncodeExpr::getLocStart", NM="_ZNK5clang14ObjCEncodeExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang14ObjCEncodeExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 384,
   FQN="clang::ObjCEncodeExpr::getLocEnd", NM="_ZNK5clang14ObjCEncodeExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang14ObjCEncodeExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 386,
   FQN="clang::ObjCEncodeExpr::classof", NM="_ZN5clang14ObjCEncodeExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCEncodeExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCEncodeExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 391,
   FQN="clang::ObjCEncodeExpr::children", NM="_ZN5clang14ObjCEncodeExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang14ObjCEncodeExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "EncodedType=" + EncodedType // NOI18N
              + ", AtLoc=" + AtLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
