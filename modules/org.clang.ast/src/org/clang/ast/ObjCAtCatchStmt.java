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


/// \brief Represents Objective-C's \@catch statement.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 74,
 FQN="clang::ObjCAtCatchStmt", NM="_ZN5clang15ObjCAtCatchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmtE")
//</editor-fold>
public class ObjCAtCatchStmt extends /*public*/ Stmt {
/*private:*/
  private VarDecl /*P*/ ExceptionDecl;
  private Stmt /*P*/ Body;
  private SourceLocation AtCatchLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::ObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 81,
   FQN="clang::ObjCAtCatchStmt::ObjCAtCatchStmt", NM="_ZN5clang15ObjCAtCatchStmtC1ENS_14SourceLocationES1_PNS_7VarDeclEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmtC1ENS_14SourceLocationES1_PNS_7VarDeclEPNS_4StmtE")
  //</editor-fold>
  public ObjCAtCatchStmt(SourceLocation atCatchLoc, SourceLocation rparenloc, 
      VarDecl /*P*/ catchVarDecl, 
      Stmt /*P*/ atCatchStmt) {
    // : Stmt(ObjCAtCatchStmtClass), ExceptionDecl(catchVarDecl), Body(atCatchStmt), AtCatchLoc(atCatchLoc), RParenLoc(rparenloc) 
    //START JInit
    super(StmtClass.ObjCAtCatchStmtClass);
    this.ExceptionDecl = catchVarDecl;
    this.Body = atCatchStmt;
    this.AtCatchLoc = new SourceLocation(atCatchLoc);
    this.RParenLoc = new SourceLocation(rparenloc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::ObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 87,
   FQN="clang::ObjCAtCatchStmt::ObjCAtCatchStmt", NM="_ZN5clang15ObjCAtCatchStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCAtCatchStmt(EmptyShell Empty) {
    // : Stmt(ObjCAtCatchStmtClass, Empty), AtCatchLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.ObjCAtCatchStmtClass, new EmptyShell(Empty));
    this.AtCatchLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getCatchBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 90,
   FQN="clang::ObjCAtCatchStmt::getCatchBody", NM="_ZNK5clang15ObjCAtCatchStmt12getCatchBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt12getCatchBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getCatchBody$Const() /*const*/ {
    return Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getCatchBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 91,
   FQN="clang::ObjCAtCatchStmt::getCatchBody", NM="_ZN5clang15ObjCAtCatchStmt12getCatchBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt12getCatchBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getCatchBody() {
    return Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::setCatchBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 92,
   FQN="clang::ObjCAtCatchStmt::setCatchBody", NM="_ZN5clang15ObjCAtCatchStmt12setCatchBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt12setCatchBodyEPNS_4StmtE")
  //</editor-fold>
  public void setCatchBody(Stmt /*P*/ S) {
    Body = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getCatchParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 94,
   FQN="clang::ObjCAtCatchStmt::getCatchParamDecl", NM="_ZNK5clang15ObjCAtCatchStmt17getCatchParamDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt17getCatchParamDeclEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getCatchParamDecl$Const() /*const*/ {
    return ExceptionDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getCatchParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 97,
   FQN="clang::ObjCAtCatchStmt::getCatchParamDecl", NM="_ZN5clang15ObjCAtCatchStmt17getCatchParamDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt17getCatchParamDeclEv")
  //</editor-fold>
  public VarDecl /*P*/ getCatchParamDecl() {
    return ExceptionDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::setCatchParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 100,
   FQN="clang::ObjCAtCatchStmt::setCatchParamDecl", NM="_ZN5clang15ObjCAtCatchStmt17setCatchParamDeclEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt17setCatchParamDeclEPNS_7VarDeclE")
  //</editor-fold>
  public void setCatchParamDecl(VarDecl /*P*/ D) {
    ExceptionDecl = D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getAtCatchLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 102,
   FQN="clang::ObjCAtCatchStmt::getAtCatchLoc", NM="_ZNK5clang15ObjCAtCatchStmt13getAtCatchLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt13getAtCatchLocEv")
  //</editor-fold>
  public SourceLocation getAtCatchLoc() /*const*/ {
    return new SourceLocation(AtCatchLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::setAtCatchLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 103,
   FQN="clang::ObjCAtCatchStmt::setAtCatchLoc", NM="_ZN5clang15ObjCAtCatchStmt13setAtCatchLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt13setAtCatchLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtCatchLoc(SourceLocation Loc) {
    AtCatchLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 104,
   FQN="clang::ObjCAtCatchStmt::getRParenLoc", NM="_ZNK5clang15ObjCAtCatchStmt12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 105,
   FQN="clang::ObjCAtCatchStmt::setRParenLoc", NM="_ZN5clang15ObjCAtCatchStmt12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation Loc) {
    RParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 107,
   FQN="clang::ObjCAtCatchStmt::getLocStart", NM="_ZNK5clang15ObjCAtCatchStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtCatchLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 108,
   FQN="clang::ObjCAtCatchStmt::getLocEnd", NM="_ZNK5clang15ObjCAtCatchStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Body.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::hasEllipsis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 110,
   FQN="clang::ObjCAtCatchStmt::hasEllipsis", NM="_ZNK5clang15ObjCAtCatchStmt11hasEllipsisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtCatchStmt11hasEllipsisEv")
  //</editor-fold>
  public boolean hasEllipsis() /*const*/ {
    return getCatchParamDecl$Const() == null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 112,
   FQN="clang::ObjCAtCatchStmt::classof", NM="_ZN5clang15ObjCAtCatchStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAtCatchStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtCatchStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 116,
   FQN="clang::ObjCAtCatchStmt::children", NM="_ZN5clang15ObjCAtCatchStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtCatchStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Body))), new StmtIterator(create_type$ptr($AddrOf(Body)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "ExceptionDecl=" + ExceptionDecl // NOI18N
              + ", Body=" + Body // NOI18N
              + ", AtCatchLoc=" + AtCatchLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
