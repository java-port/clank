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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import static org.clang.basic.SourceLocation.*;


/// BreakStmt - This represents a break.
///
//<editor-fold defaultstate="collapsed" desc="clang::BreakStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1328,
 FQN="clang::BreakStmt", NM="_ZN5clang9BreakStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9BreakStmtE")
//</editor-fold>
public class BreakStmt extends /*public*/ Stmt {
  private SourceLocation BreakLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::BreakStmt">
  @Converted(kind = Converted.Kind.MANUAL/*assert*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1332,
   FQN="clang::BreakStmt::BreakStmt", NM="_ZN5clang9BreakStmtC1ENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9BreakStmtC1ENS_14SourceLocationE")
  //</editor-fold>
  public BreakStmt(SourceLocation BL) {
    // : Stmt(BreakStmtClass), BreakLoc(BL) 
    //START JInit
    super(StmtClass.BreakStmtClass);
    this.BreakLoc = new SourceLocation(BL);
    //END JInit
    static_assert(/*java*/true || ($sizeof_BreakStmt() == 2 * $sizeof_SourceLocation()), $("BreakStmt too large"));
  }

  
  /// \brief Build an empty break statement.
  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::BreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1338,
   FQN="clang::BreakStmt::BreakStmt", NM="_ZN5clang9BreakStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9BreakStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ BreakStmt(EmptyShell Empty) {
    // : Stmt(BreakStmtClass, Empty), BreakLoc() 
    //START JInit
    super(StmtClass.BreakStmtClass, new EmptyShell(Empty));
    this.BreakLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::getBreakLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1340,
   FQN="clang::BreakStmt::getBreakLoc", NM="_ZNK5clang9BreakStmt11getBreakLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9BreakStmt11getBreakLocEv")
  //</editor-fold>
  public SourceLocation getBreakLoc() /*const*/ {
    return new SourceLocation(BreakLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::setBreakLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1341,
   FQN="clang::BreakStmt::setBreakLoc", NM="_ZN5clang9BreakStmt11setBreakLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9BreakStmt11setBreakLocENS_14SourceLocationE")
  //</editor-fold>
  public void setBreakLoc(SourceLocation L) {
    BreakLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1343,
   FQN="clang::BreakStmt::getLocStart", NM="_ZNK5clang9BreakStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9BreakStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BreakLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1344,
   FQN="clang::BreakStmt::getLocEnd", NM="_ZNK5clang9BreakStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9BreakStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BreakLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1346,
   FQN="clang::BreakStmt::classof", NM="_ZN5clang9BreakStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9BreakStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.BreakStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::BreakStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1351,
   FQN="clang::BreakStmt::children", NM="_ZN5clang9BreakStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9BreakStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "BreakLoc=" + BreakLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
