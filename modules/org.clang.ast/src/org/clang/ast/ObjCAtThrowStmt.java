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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents Objective-C's \@throw statement.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 313,
 FQN="clang::ObjCAtThrowStmt", NM="_ZN5clang15ObjCAtThrowStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmtE")
//</editor-fold>
public class ObjCAtThrowStmt extends /*public*/ Stmt {
  private SourceLocation AtThrowLoc;
  private Stmt /*P*/ Throw;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::ObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 318,
   FQN="clang::ObjCAtThrowStmt::ObjCAtThrowStmt", NM="_ZN5clang15ObjCAtThrowStmtC1ENS_14SourceLocationEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmtC1ENS_14SourceLocationEPNS_4StmtE")
  //</editor-fold>
  public ObjCAtThrowStmt(SourceLocation atThrowLoc, Stmt /*P*/ throwExpr) {
    // : Stmt(ObjCAtThrowStmtClass), AtThrowLoc(), Throw(throwExpr) 
    //START JInit
    super(StmtClass.ObjCAtThrowStmtClass);
    this.AtThrowLoc = new SourceLocation();
    this.Throw = throwExpr;
    //END JInit
    AtThrowLoc.$assign(atThrowLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::ObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 322,
   FQN="clang::ObjCAtThrowStmt::ObjCAtThrowStmt", NM="_ZN5clang15ObjCAtThrowStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCAtThrowStmt(EmptyShell Empty) {
    // : Stmt(ObjCAtThrowStmtClass, Empty), AtThrowLoc() 
    //START JInit
    super(StmtClass.ObjCAtThrowStmtClass, new EmptyShell(Empty));
    this.AtThrowLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::getThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 325,
   FQN="clang::ObjCAtThrowStmt::getThrowExpr", NM="_ZNK5clang15ObjCAtThrowStmt12getThrowExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtThrowStmt12getThrowExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getThrowExpr$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, Throw);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::getThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 326,
   FQN="clang::ObjCAtThrowStmt::getThrowExpr", NM="_ZN5clang15ObjCAtThrowStmt12getThrowExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmt12getThrowExprEv")
  //</editor-fold>
  public Expr /*P*/ getThrowExpr() {
    return reinterpret_cast(Expr /*P*/ .class, Throw);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::setThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 327,
   FQN="clang::ObjCAtThrowStmt::setThrowExpr", NM="_ZN5clang15ObjCAtThrowStmt12setThrowExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmt12setThrowExprEPNS_4StmtE")
  //</editor-fold>
  public void setThrowExpr(Stmt /*P*/ S) {
    Throw = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::getThrowLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 329,
   FQN="clang::ObjCAtThrowStmt::getThrowLoc", NM="_ZNK5clang15ObjCAtThrowStmt11getThrowLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtThrowStmt11getThrowLocEv")
  //</editor-fold>
  public SourceLocation getThrowLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtThrowLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::setThrowLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 330,
   FQN="clang::ObjCAtThrowStmt::setThrowLoc", NM="_ZN5clang15ObjCAtThrowStmt11setThrowLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmt11setThrowLocENS_14SourceLocationE")
  //</editor-fold>
  public void setThrowLoc(SourceLocation Loc) {
    AtThrowLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 332,
   FQN="clang::ObjCAtThrowStmt::getLocStart", NM="_ZNK5clang15ObjCAtThrowStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtThrowStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtThrowLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 333,
   FQN="clang::ObjCAtThrowStmt::getLocEnd", NM="_ZNK5clang15ObjCAtThrowStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang15ObjCAtThrowStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return (Throw != null) ? Throw.getLocEnd() : new SourceLocation(AtThrowLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 337,
   FQN="clang::ObjCAtThrowStmt::classof", NM="_ZN5clang15ObjCAtThrowStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAtThrowStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtThrowStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 341,
   FQN="clang::ObjCAtThrowStmt::children", NM="_ZN5clang15ObjCAtThrowStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang15ObjCAtThrowStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Throw))), new StmtIterator(create_type$ptr($AddrOf(Throw)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "AtThrowLoc=" + AtThrowLoc // NOI18N
              + ", Throw=" + Throw // NOI18N
              + super.toString(); // NOI18N
  }
}
