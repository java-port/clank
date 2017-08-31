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
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import static org.clang.basic.SourceLocation.*;


/// LabelStmt - Represents a label, which has a substatement.  For example:
///    foo: return;
///
//<editor-fold defaultstate="collapsed" desc="clang::LabelStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 789,
 FQN="clang::LabelStmt", NM="_ZN5clang9LabelStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmtE")
//</editor-fold>
public class LabelStmt extends /*public*/ Stmt {
  private SourceLocation IdentLoc;
  private LabelDecl /*P*/ TheDecl;
  private Stmt /*P*/ SubStmt;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::LabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 795,
   FQN="clang::LabelStmt::LabelStmt", NM="_ZN5clang9LabelStmtC1ENS_14SourceLocationEPNS_9LabelDeclEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmtC1ENS_14SourceLocationEPNS_9LabelDeclEPNS_4StmtE")
  //</editor-fold>
  public LabelStmt(SourceLocation IL, LabelDecl /*P*/ D, Stmt /*P*/ substmt) {
    // : Stmt(LabelStmtClass), IdentLoc(IL), TheDecl(D), SubStmt(substmt) 
    //START JInit
    super(StmtClass.LabelStmtClass);
    this.IdentLoc = new SourceLocation(IL);
    this.TheDecl = D;
    this.SubStmt = substmt;
    //END JInit
    if (false) {
      // JAVA: do not need to check sizeof
      static_assert($sizeof_LabelStmt()
         == 2 * $sizeof_SourceLocation() + 2 * $sizeof_ptr(/*Object */), $("LabelStmt too big"));
    }
  }

  
  // \brief Build an empty label statement.
  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::LabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 803,
   FQN="clang::LabelStmt::LabelStmt", NM="_ZN5clang9LabelStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ LabelStmt(EmptyShell Empty) {
    // : Stmt(LabelStmtClass, Empty), IdentLoc() 
    //START JInit
    super(StmtClass.LabelStmtClass, new EmptyShell(Empty));
    this.IdentLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getIdentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 805,
   FQN="clang::LabelStmt::getIdentLoc", NM="_ZNK5clang9LabelStmt11getIdentLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9LabelStmt11getIdentLocEv")
  //</editor-fold>
  public SourceLocation getIdentLoc() /*const*/ {
    return new SourceLocation(IdentLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 806,
   FQN="clang::LabelStmt::getDecl", NM="_ZNK5clang9LabelStmt7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9LabelStmt7getDeclEv")
  //</editor-fold>
  public LabelDecl /*P*/ getDecl() /*const*/ {
    return TheDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::setDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 807,
   FQN="clang::LabelStmt::setDecl", NM="_ZN5clang9LabelStmt7setDeclEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmt7setDeclEPNS_9LabelDeclE")
  //</editor-fold>
  public void setDecl(LabelDecl /*P*/ D) {
    TheDecl = D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 309,
   FQN="clang::LabelStmt::getName", NM="_ZNK5clang9LabelStmt7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9LabelStmt7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return getDecl().getIdentifier().getNameStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 809,
   FQN="clang::LabelStmt::getSubStmt", NM="_ZN5clang9LabelStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmt10getSubStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getSubStmt() {
    return SubStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 810,
   FQN="clang::LabelStmt::getSubStmt", NM="_ZNK5clang9LabelStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9LabelStmt10getSubStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getSubStmt$Const() /*const*/ {
    return SubStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::setIdentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 811,
   FQN="clang::LabelStmt::setIdentLoc", NM="_ZN5clang9LabelStmt11setIdentLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmt11setIdentLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIdentLoc(SourceLocation L) {
    IdentLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::setSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 812,
   FQN="clang::LabelStmt::setSubStmt", NM="_ZN5clang9LabelStmt10setSubStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmt10setSubStmtEPNS_4StmtE")
  //</editor-fold>
  public void setSubStmt(Stmt /*P*/ SS) {
    SubStmt = SS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 814,
   FQN="clang::LabelStmt::getLocStart", NM="_ZNK5clang9LabelStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9LabelStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(IdentLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 815,
   FQN="clang::LabelStmt::getLocEnd", NM="_ZNK5clang9LabelStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9LabelStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubStmt.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 817,
   FQN="clang::LabelStmt::children", NM="_ZN5clang9LabelStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubStmt))), new StmtIterator(create_type$ptr($AddrOf(SubStmt)).$add(1)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 819,
   FQN="clang::LabelStmt::classof", NM="_ZN5clang9LabelStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9LabelStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.LabelStmtClass;
  }

  
  @Override public String toString() {
    return "" + "IdentLoc=" + IdentLoc // NOI18N
              + ", TheDecl=" + NativeTrace.getIdentityStr(TheDecl) // NOI18N
              + ", SubStmt=" + NativeTrace.getIdentityStr(SubStmt) // NOI18N
              + super.toString(); // NOI18N
  }
}
