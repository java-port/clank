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


/// NullStmt - This is the null statement ";": C99 6.8.3p3.
///
//<editor-fold defaultstate="collapsed" desc="clang::NullStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 511,
 FQN="clang::NullStmt", NM="_ZN5clang8NullStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8NullStmtE")
//</editor-fold>
public class NullStmt extends /*public*/ Stmt {
  private SourceLocation SemiLoc;
  
  /// \brief True if the null statement was preceded by an empty macro, e.g:
  /// @code
  ///   #define CALL(x)
  ///   CALL(0);
  /// @endcode
  /*friend*/public boolean HasLeadingEmptyMacro;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::NullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 521,
   FQN="clang::NullStmt::NullStmt", NM="_ZN5clang8NullStmtC1ENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8NullStmtC1ENS_14SourceLocationEb")
  //</editor-fold>
  public NullStmt(SourceLocation L) {
    this(L, false);
  }
  public NullStmt(SourceLocation L, boolean hasLeadingEmptyMacro/*= false*/) {
    // : Stmt(NullStmtClass), SemiLoc(L), HasLeadingEmptyMacro(hasLeadingEmptyMacro) 
    //START JInit
    super(StmtClass.NullStmtClass);
    this.SemiLoc = new SourceLocation(L);
    this.HasLeadingEmptyMacro = hasLeadingEmptyMacro;
    //END JInit
  }

  
  /// \brief Build an empty null statement.
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::NullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 526,
   FQN="clang::NullStmt::NullStmt", NM="_ZN5clang8NullStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8NullStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ NullStmt(EmptyShell Empty) {
    // : Stmt(NullStmtClass, Empty), SemiLoc(), HasLeadingEmptyMacro(false) 
    //START JInit
    super(StmtClass.NullStmtClass, new EmptyShell(Empty));
    this.SemiLoc = new SourceLocation();
    this.HasLeadingEmptyMacro = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::getSemiLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 529,
   FQN="clang::NullStmt::getSemiLoc", NM="_ZNK5clang8NullStmt10getSemiLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8NullStmt10getSemiLocEv")
  //</editor-fold>
  public SourceLocation getSemiLoc() /*const*/ {
    return new SourceLocation(SemiLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::setSemiLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 530,
   FQN="clang::NullStmt::setSemiLoc", NM="_ZN5clang8NullStmt10setSemiLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8NullStmt10setSemiLocENS_14SourceLocationE")
  //</editor-fold>
  public void setSemiLoc(SourceLocation L) {
    SemiLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::hasLeadingEmptyMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 532,
   FQN="clang::NullStmt::hasLeadingEmptyMacro", NM="_ZNK5clang8NullStmt20hasLeadingEmptyMacroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8NullStmt20hasLeadingEmptyMacroEv")
  //</editor-fold>
  public boolean hasLeadingEmptyMacro() /*const*/ {
    return HasLeadingEmptyMacro;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 534,
   FQN="clang::NullStmt::getLocStart", NM="_ZNK5clang8NullStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8NullStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(SemiLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 535,
   FQN="clang::NullStmt::getLocEnd", NM="_ZNK5clang8NullStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8NullStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(SemiLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 537,
   FQN="clang::NullStmt::classof", NM="_ZN5clang8NullStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8NullStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.NullStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NullStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 541,
   FQN="clang::NullStmt::children", NM="_ZN5clang8NullStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8NullStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  @Override public String toString() {
    return "" + "SemiLoc=" + SemiLoc // NOI18N
              + ", HasLeadingEmptyMacro=" + HasLeadingEmptyMacro // NOI18N
              + super.toString(); // NOI18N
  }
}
