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


/// ObjCSelectorExpr used for \@selector in Objective-C.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 397,
 FQN="clang::ObjCSelectorExpr", NM="_ZN5clang16ObjCSelectorExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExprE")
//</editor-fold>
public class ObjCSelectorExpr extends /*public*/ Expr {
  private Selector SelName;
  private SourceLocation AtLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::ObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 401,
   FQN="clang::ObjCSelectorExpr::ObjCSelectorExpr", NM="_ZN5clang16ObjCSelectorExprC1ENS_8QualTypeENS_8SelectorENS_14SourceLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExprC1ENS_8QualTypeENS_8SelectorENS_14SourceLocationES3_")
  //</editor-fold>
  public ObjCSelectorExpr(QualType T, Selector selInfo, 
      SourceLocation at, SourceLocation rp) {
    // : Expr(ObjCSelectorExprClass, T, VK_RValue, OK_Ordinary, false, false, false, false), SelName(selInfo), AtLoc(at), RParenLoc(rp) 
    //START JInit
    super(StmtClass.ObjCSelectorExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.SelName = new Selector(selInfo);
    this.AtLoc = new SourceLocation(at);
    this.RParenLoc = new SourceLocation(rp);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::ObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 406,
   FQN="clang::ObjCSelectorExpr::ObjCSelectorExpr", NM="_ZN5clang16ObjCSelectorExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCSelectorExpr(EmptyShell Empty) {
    // : Expr(ObjCSelectorExprClass, Empty), SelName(), AtLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ObjCSelectorExprClass, new EmptyShell(Empty));
    this.SelName = new Selector();
    this.AtLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::getSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 409,
   FQN="clang::ObjCSelectorExpr::getSelector", NM="_ZNK5clang16ObjCSelectorExpr11getSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCSelectorExpr11getSelectorEv")
  //</editor-fold>
  public Selector getSelector() /*const*/ {
    return new Selector(SelName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::setSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 410,
   FQN="clang::ObjCSelectorExpr::setSelector", NM="_ZN5clang16ObjCSelectorExpr11setSelectorENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExpr11setSelectorENS_8SelectorE")
  //</editor-fold>
  public void setSelector(Selector S) {
    SelName.$assign(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 412,
   FQN="clang::ObjCSelectorExpr::getAtLoc", NM="_ZNK5clang16ObjCSelectorExpr8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCSelectorExpr8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 413,
   FQN="clang::ObjCSelectorExpr::getRParenLoc", NM="_ZNK5clang16ObjCSelectorExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCSelectorExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 414,
   FQN="clang::ObjCSelectorExpr::setAtLoc", NM="_ZN5clang16ObjCSelectorExpr8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExpr8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation L) {
    AtLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 415,
   FQN="clang::ObjCSelectorExpr::setRParenLoc", NM="_ZN5clang16ObjCSelectorExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 417,
   FQN="clang::ObjCSelectorExpr::getLocStart", NM="_ZNK5clang16ObjCSelectorExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCSelectorExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 418,
   FQN="clang::ObjCSelectorExpr::getLocEnd", NM="_ZNK5clang16ObjCSelectorExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCSelectorExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  /// getNumArgs - Return the number of actual arguments to this call.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 421,
   FQN="clang::ObjCSelectorExpr::getNumArgs", NM="_ZNK5clang16ObjCSelectorExpr10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZNK5clang16ObjCSelectorExpr10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return SelName.getNumArgs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 423,
   FQN="clang::ObjCSelectorExpr::classof", NM="_ZN5clang16ObjCSelectorExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCSelectorExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCSelectorExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprObjC.h", line = 428,
   FQN="clang::ObjCSelectorExpr::children", NM="_ZN5clang16ObjCSelectorExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprObjC.cpp -nm=_ZN5clang16ObjCSelectorExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "SelName=" + SelName // NOI18N
              + ", AtLoc=" + AtLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
