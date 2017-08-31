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


/// \brief Represents Objective-C's \@autoreleasepool Statement
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 345,
 FQN="clang::ObjCAutoreleasePoolStmt", NM="_ZN5clang23ObjCAutoreleasePoolStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmtE")
//</editor-fold>
public class ObjCAutoreleasePoolStmt extends /*public*/ Stmt {
  private SourceLocation AtLoc;
  private Stmt /*P*/ SubStmt;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::ObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 350,
   FQN="clang::ObjCAutoreleasePoolStmt::ObjCAutoreleasePoolStmt", NM="_ZN5clang23ObjCAutoreleasePoolStmtC1ENS_14SourceLocationEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmtC1ENS_14SourceLocationEPNS_4StmtE")
  //</editor-fold>
  public ObjCAutoreleasePoolStmt(SourceLocation atLoc, Stmt /*P*/ subStmt) {
    // : Stmt(ObjCAutoreleasePoolStmtClass), AtLoc(atLoc), SubStmt(subStmt) 
    //START JInit
    super(StmtClass.ObjCAutoreleasePoolStmtClass);
    this.AtLoc = new SourceLocation(atLoc);
    this.SubStmt = subStmt;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::ObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 353,
   FQN="clang::ObjCAutoreleasePoolStmt::ObjCAutoreleasePoolStmt", NM="_ZN5clang23ObjCAutoreleasePoolStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ObjCAutoreleasePoolStmt(EmptyShell Empty) {
    // : Stmt(ObjCAutoreleasePoolStmtClass, Empty), AtLoc() 
    //START JInit
    super(StmtClass.ObjCAutoreleasePoolStmtClass, new EmptyShell(Empty));
    this.AtLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 356,
   FQN="clang::ObjCAutoreleasePoolStmt::getSubStmt", NM="_ZNK5clang23ObjCAutoreleasePoolStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang23ObjCAutoreleasePoolStmt10getSubStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getSubStmt$Const() /*const*/ {
    return SubStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 357,
   FQN="clang::ObjCAutoreleasePoolStmt::getSubStmt", NM="_ZN5clang23ObjCAutoreleasePoolStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmt10getSubStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getSubStmt() {
    return SubStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::setSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 358,
   FQN="clang::ObjCAutoreleasePoolStmt::setSubStmt", NM="_ZN5clang23ObjCAutoreleasePoolStmt10setSubStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmt10setSubStmtEPNS_4StmtE")
  //</editor-fold>
  public void setSubStmt(Stmt /*P*/ S) {
    SubStmt = S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 360,
   FQN="clang::ObjCAutoreleasePoolStmt::getLocStart", NM="_ZNK5clang23ObjCAutoreleasePoolStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang23ObjCAutoreleasePoolStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 361,
   FQN="clang::ObjCAutoreleasePoolStmt::getLocEnd", NM="_ZNK5clang23ObjCAutoreleasePoolStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang23ObjCAutoreleasePoolStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubStmt.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 363,
   FQN="clang::ObjCAutoreleasePoolStmt::getAtLoc", NM="_ZNK5clang23ObjCAutoreleasePoolStmt8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang23ObjCAutoreleasePoolStmt8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 364,
   FQN="clang::ObjCAutoreleasePoolStmt::setAtLoc", NM="_ZN5clang23ObjCAutoreleasePoolStmt8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmt8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation Loc) {
    AtLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 366,
   FQN="clang::ObjCAutoreleasePoolStmt::classof", NM="_ZN5clang23ObjCAutoreleasePoolStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAutoreleasePoolStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAutoreleasePoolStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 370,
   FQN="clang::ObjCAutoreleasePoolStmt::children", NM="_ZN5clang23ObjCAutoreleasePoolStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang23ObjCAutoreleasePoolStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubStmt))), new StmtIterator(create_type$ptr($AddrOf(SubStmt)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "AtLoc=" + AtLoc // NOI18N
              + ", SubStmt=" + SubStmt // NOI18N
              + super.toString(); // NOI18N
  }
}
