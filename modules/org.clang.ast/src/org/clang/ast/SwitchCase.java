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
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

// SwitchCase is the base class for CaseStmt and DefaultStmt,
//<editor-fold defaultstate="collapsed" desc="clang::SwitchCase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 648,
 FQN="clang::SwitchCase", NM="_ZN5clang10SwitchCaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCaseE")
//</editor-fold>
public class SwitchCase extends /*public*/ Stmt {
/*protected:*/
  // A pointer to the following CaseStmt or DefaultStmt class,
  // used by SwitchStmt.
  protected SwitchCase /*P*/ NextSwitchCase;
  protected SourceLocation KeywordLoc;
  protected SourceLocation ColonLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::SwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 656,
   FQN="clang::SwitchCase::SwitchCase", NM="_ZN5clang10SwitchCaseC1ENS_4Stmt9StmtClassENS_14SourceLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCaseC1ENS_4Stmt9StmtClassENS_14SourceLocationES3_")
  //</editor-fold>
  protected SwitchCase(StmtClass SC, SourceLocation KWLoc, SourceLocation ColonLoc) {
    // : Stmt(SC), NextSwitchCase(null), KeywordLoc(KWLoc), ColonLoc(ColonLoc) 
    //START JInit
    super(SC);
    this.NextSwitchCase = null;
    this.KeywordLoc = new SourceLocation(KWLoc);
    this.ColonLoc = new SourceLocation(ColonLoc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::SwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 660,
   FQN="clang::SwitchCase::SwitchCase", NM="_ZN5clang10SwitchCaseC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCaseC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  protected SwitchCase(StmtClass SC, Stmt.EmptyShell $Prm1) {
    // : Stmt(SC), NextSwitchCase(null), KeywordLoc(), ColonLoc() 
    //START JInit
    super(SC);
    this.NextSwitchCase = null;
    this.KeywordLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getNextSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 664,
   FQN="clang::SwitchCase::getNextSwitchCase", NM="_ZNK5clang10SwitchCase17getNextSwitchCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchCase17getNextSwitchCaseEv")
  //</editor-fold>
  public /*const*/ SwitchCase /*P*/ getNextSwitchCase$Const() /*const*/ {
    return NextSwitchCase;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getNextSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 666,
   FQN="clang::SwitchCase::getNextSwitchCase", NM="_ZN5clang10SwitchCase17getNextSwitchCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCase17getNextSwitchCaseEv")
  //</editor-fold>
  public SwitchCase /*P*/ getNextSwitchCase() {
    return NextSwitchCase;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::setNextSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 668,
   FQN="clang::SwitchCase::setNextSwitchCase", NM="_ZN5clang10SwitchCase17setNextSwitchCaseEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCase17setNextSwitchCaseEPS0_")
  //</editor-fold>
  public void setNextSwitchCase(SwitchCase /*P*/ SC) {
    NextSwitchCase = SC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 670,
   FQN="clang::SwitchCase::getKeywordLoc", NM="_ZNK5clang10SwitchCase13getKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchCase13getKeywordLocEv")
  //</editor-fold>
  public SourceLocation getKeywordLoc() /*const*/ {
    return new SourceLocation(KeywordLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::setKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 671,
   FQN="clang::SwitchCase::setKeywordLoc", NM="_ZN5clang10SwitchCase13setKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCase13setKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setKeywordLoc(SourceLocation L) {
    KeywordLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 672,
   FQN="clang::SwitchCase::getColonLoc", NM="_ZNK5clang10SwitchCase11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchCase11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 673,
   FQN="clang::SwitchCase::setColonLoc", NM="_ZN5clang10SwitchCase11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCase11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setColonLoc(SourceLocation L) {
    ColonLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 856,
   FQN="clang::SwitchCase::getSubStmt", NM="_ZN5clang10SwitchCase10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCase10getSubStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getSubStmt() {
    if (isa_CaseStmt(this)) {
      return cast_CaseStmt(this).getSubStmt();
    }
    return cast_DefaultStmt(this).getSubStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 676,
   FQN="clang::SwitchCase::getSubStmt", NM="_ZNK5clang10SwitchCase10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchCase10getSubStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getSubStmt$Const() /*const*/ {
    return ((/*const_cast*/SwitchCase /*P*/ )(this)).getSubStmt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 680,
   FQN="clang::SwitchCase::getLocStart", NM="_ZNK5clang10SwitchCase11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchCase11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(KeywordLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 780,
   FQN="clang::SwitchCase::getLocEnd", NM="_ZNK5clang10SwitchCase9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10SwitchCase9getLocEndEv")
  //</editor-fold>
  public /*inline*/ SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    {
      /*const*/ CaseStmt /*P*/ CS = dyn_cast_CaseStmt(this);
      if ((CS != null)) {
        return CS.getLocEnd();
      }
    }
    return cast_DefaultStmt(this).getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SwitchCase::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 683,
   FQN="clang::SwitchCase::classof", NM="_ZN5clang10SwitchCase7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10SwitchCase7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CaseStmtClass
       || T.getStmtClass() == StmtClass.DefaultStmtClass;
  }

  
  @Override public String toString() {
    return "" + "NextSwitchCase=" + NextSwitchCase // NOI18N
              + ", KeywordLoc=" + KeywordLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
