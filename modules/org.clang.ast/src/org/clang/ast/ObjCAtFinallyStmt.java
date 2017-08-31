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


/// \brief Represents Objective-C's \@finally statement
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 120,
 FQN="clang::ObjCAtFinallyStmt", NM="_ZN5clang17ObjCAtFinallyStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmtE")
//</editor-fold>
public class ObjCAtFinallyStmt extends /*public*/ Stmt {
  private SourceLocation AtFinallyLoc;
  private Stmt /*P*/ AtFinallyStmt;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::ObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 125,
   FQN="clang::ObjCAtFinallyStmt::ObjCAtFinallyStmt", NM="_ZN5clang17ObjCAtFinallyStmtC1ENS_14SourceLocationEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmtC1ENS_14SourceLocationEPNS_4StmtE")
  //</editor-fold>
  public ObjCAtFinallyStmt(SourceLocation atFinallyLoc, Stmt /*P*/ atFinallyStmt) {
    // : Stmt(ObjCAtFinallyStmtClass), AtFinallyLoc(atFinallyLoc), AtFinallyStmt(atFinallyStmt) 
    //START JInit
    super(StmtClass.ObjCAtFinallyStmtClass);
    this.AtFinallyLoc = new SourceLocation(atFinallyLoc);
    this.AtFinallyStmt = atFinallyStmt;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::ObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 129,
   FQN="clang::ObjCAtFinallyStmt::ObjCAtFinallyStmt", NM="_ZN5clang17ObjCAtFinallyStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCAtFinallyStmt(EmptyShell Empty) {
    // : Stmt(ObjCAtFinallyStmtClass, Empty), AtFinallyLoc() 
    //START JInit
    super(StmtClass.ObjCAtFinallyStmtClass, new EmptyShell(Empty));
    this.AtFinallyLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::getFinallyBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 132,
   FQN="clang::ObjCAtFinallyStmt::getFinallyBody", NM="_ZNK5clang17ObjCAtFinallyStmt14getFinallyBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang17ObjCAtFinallyStmt14getFinallyBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getFinallyBody$Const() /*const*/ {
    return AtFinallyStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::getFinallyBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 133,
   FQN="clang::ObjCAtFinallyStmt::getFinallyBody", NM="_ZN5clang17ObjCAtFinallyStmt14getFinallyBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmt14getFinallyBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getFinallyBody() {
    return AtFinallyStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::setFinallyBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 134,
   FQN="clang::ObjCAtFinallyStmt::setFinallyBody", NM="_ZN5clang17ObjCAtFinallyStmt14setFinallyBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmt14setFinallyBodyEPNS_4StmtE")
  //</editor-fold>
  public void setFinallyBody(Stmt /*P*/ S) {
    AtFinallyStmt = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 136,
   FQN="clang::ObjCAtFinallyStmt::getLocStart", NM="_ZNK5clang17ObjCAtFinallyStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang17ObjCAtFinallyStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtFinallyLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 137,
   FQN="clang::ObjCAtFinallyStmt::getLocEnd", NM="_ZNK5clang17ObjCAtFinallyStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang17ObjCAtFinallyStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return AtFinallyStmt.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::getAtFinallyLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 141,
   FQN="clang::ObjCAtFinallyStmt::getAtFinallyLoc", NM="_ZNK5clang17ObjCAtFinallyStmt15getAtFinallyLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang17ObjCAtFinallyStmt15getAtFinallyLocEv")
  //</editor-fold>
  public SourceLocation getAtFinallyLoc() /*const*/ {
    return new SourceLocation(AtFinallyLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::setAtFinallyLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 142,
   FQN="clang::ObjCAtFinallyStmt::setAtFinallyLoc", NM="_ZN5clang17ObjCAtFinallyStmt15setAtFinallyLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmt15setAtFinallyLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtFinallyLoc(SourceLocation Loc) {
    AtFinallyLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 144,
   FQN="clang::ObjCAtFinallyStmt::classof", NM="_ZN5clang17ObjCAtFinallyStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAtFinallyStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtFinallyStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 148,
   FQN="clang::ObjCAtFinallyStmt::children", NM="_ZN5clang17ObjCAtFinallyStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang17ObjCAtFinallyStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(AtFinallyStmt))), new StmtIterator(create_type$ptr($AddrOf(AtFinallyStmt)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "AtFinallyLoc=" + AtFinallyLoc // NOI18N
              + ", AtFinallyStmt=" + AtFinallyStmt // NOI18N
              + super.toString(); // NOI18N
  }
}
