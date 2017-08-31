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


/// GotoStmt - This represents a direct goto.
///
//<editor-fold defaultstate="collapsed" desc="clang::GotoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1224,
 FQN="clang::GotoStmt", NM="_ZN5clang8GotoStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmtE")
//</editor-fold>
public class GotoStmt extends /*public*/ Stmt {
  private LabelDecl /*P*/ Label;
  private SourceLocation GotoLoc;
  private SourceLocation LabelLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::GotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1229,
   FQN="clang::GotoStmt::GotoStmt", NM="_ZN5clang8GotoStmtC1EPNS_9LabelDeclENS_14SourceLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmtC1EPNS_9LabelDeclENS_14SourceLocationES3_")
  //</editor-fold>
  public GotoStmt(LabelDecl /*P*/ label, SourceLocation GL, SourceLocation LL) {
    // : Stmt(GotoStmtClass), Label(label), GotoLoc(GL), LabelLoc(LL) 
    //START JInit
    super(StmtClass.GotoStmtClass);
    this.Label = label;
    this.GotoLoc = new SourceLocation(GL);
    this.LabelLoc = new SourceLocation(LL);
    //END JInit
  }

  
  /// \brief Build an empty goto statement.
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::GotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1233,
   FQN="clang::GotoStmt::GotoStmt", NM="_ZN5clang8GotoStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ GotoStmt(EmptyShell Empty) {
    // : Stmt(GotoStmtClass, Empty), GotoLoc(), LabelLoc() 
    //START JInit
    super(StmtClass.GotoStmtClass, new EmptyShell(Empty));
    this.GotoLoc = new SourceLocation();
    this.LabelLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1235,
   FQN="clang::GotoStmt::getLabel", NM="_ZNK5clang8GotoStmt8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8GotoStmt8getLabelEv")
  //</editor-fold>
  public LabelDecl /*P*/ getLabel() /*const*/ {
    return Label;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::setLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1236,
   FQN="clang::GotoStmt::setLabel", NM="_ZN5clang8GotoStmt8setLabelEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmt8setLabelEPNS_9LabelDeclE")
  //</editor-fold>
  public void setLabel(LabelDecl /*P*/ D) {
    Label = D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::getGotoLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1238,
   FQN="clang::GotoStmt::getGotoLoc", NM="_ZNK5clang8GotoStmt10getGotoLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8GotoStmt10getGotoLocEv")
  //</editor-fold>
  public SourceLocation getGotoLoc() /*const*/ {
    return new SourceLocation(GotoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::setGotoLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1239,
   FQN="clang::GotoStmt::setGotoLoc", NM="_ZN5clang8GotoStmt10setGotoLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmt10setGotoLocENS_14SourceLocationE")
  //</editor-fold>
  public void setGotoLoc(SourceLocation L) {
    GotoLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::getLabelLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1240,
   FQN="clang::GotoStmt::getLabelLoc", NM="_ZNK5clang8GotoStmt11getLabelLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8GotoStmt11getLabelLocEv")
  //</editor-fold>
  public SourceLocation getLabelLoc() /*const*/ {
    return new SourceLocation(LabelLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::setLabelLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1241,
   FQN="clang::GotoStmt::setLabelLoc", NM="_ZN5clang8GotoStmt11setLabelLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmt11setLabelLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLabelLoc(SourceLocation L) {
    LabelLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1243,
   FQN="clang::GotoStmt::getLocStart", NM="_ZNK5clang8GotoStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8GotoStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(GotoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1244,
   FQN="clang::GotoStmt::getLocEnd", NM="_ZNK5clang8GotoStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8GotoStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LabelLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1246,
   FQN="clang::GotoStmt::classof", NM="_ZN5clang8GotoStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.GotoStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::GotoStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1251,
   FQN="clang::GotoStmt::children", NM="_ZN5clang8GotoStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8GotoStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "Label=" + Label // NOI18N
              + ", GotoLoc=" + GotoLoc // NOI18N
              + ", LabelLoc=" + LabelLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
