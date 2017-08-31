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
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// IndirectGotoStmt - This represents an indirect goto.
///
//<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1258,
 FQN="clang::IndirectGotoStmt", NM="_ZN5clang16IndirectGotoStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmtE")
//</editor-fold>
public class IndirectGotoStmt extends /*public*/ Stmt {
  private SourceLocation GotoLoc;
  private SourceLocation StarLoc;
  private Stmt /*P*/ Target;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::IndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1263,
   FQN="clang::IndirectGotoStmt::IndirectGotoStmt", NM="_ZN5clang16IndirectGotoStmtC1ENS_14SourceLocationES1_PNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmtC1ENS_14SourceLocationES1_PNS_4ExprE")
  //</editor-fold>
  public IndirectGotoStmt(SourceLocation gotoLoc, SourceLocation starLoc, 
      Expr /*P*/ target) {
    // : Stmt(IndirectGotoStmtClass), GotoLoc(gotoLoc), StarLoc(starLoc), Target((Stmt * )target) 
    //START JInit
    super(StmtClass.IndirectGotoStmtClass);
    this.GotoLoc = new SourceLocation(gotoLoc);
    this.StarLoc = new SourceLocation(starLoc);
    this.Target = (Stmt /*P*/ )target;
    //END JInit
  }

  
  /// \brief Build an empty indirect goto statement.
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::IndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1269,
   FQN="clang::IndirectGotoStmt::IndirectGotoStmt", NM="_ZN5clang16IndirectGotoStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ IndirectGotoStmt(EmptyShell Empty) {
    // : Stmt(IndirectGotoStmtClass, Empty), GotoLoc(), StarLoc() 
    //START JInit
    super(StmtClass.IndirectGotoStmtClass, new EmptyShell(Empty));
    this.GotoLoc = new SourceLocation();
    this.StarLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::setGotoLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1272,
   FQN="clang::IndirectGotoStmt::setGotoLoc", NM="_ZN5clang16IndirectGotoStmt10setGotoLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt10setGotoLocENS_14SourceLocationE")
  //</editor-fold>
  public void setGotoLoc(SourceLocation L) {
    GotoLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getGotoLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1273,
   FQN="clang::IndirectGotoStmt::getGotoLoc", NM="_ZNK5clang16IndirectGotoStmt10getGotoLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang16IndirectGotoStmt10getGotoLocEv")
  //</editor-fold>
  public SourceLocation getGotoLoc() /*const*/ {
    return new SourceLocation(GotoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::setStarLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1274,
   FQN="clang::IndirectGotoStmt::setStarLoc", NM="_ZN5clang16IndirectGotoStmt10setStarLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt10setStarLocENS_14SourceLocationE")
  //</editor-fold>
  public void setStarLoc(SourceLocation L) {
    StarLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getStarLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1275,
   FQN="clang::IndirectGotoStmt::getStarLoc", NM="_ZNK5clang16IndirectGotoStmt10getStarLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang16IndirectGotoStmt10getStarLocEv")
  //</editor-fold>
  public SourceLocation getStarLoc() /*const*/ {
    return new SourceLocation(StarLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1277,
   FQN="clang::IndirectGotoStmt::getTarget", NM="_ZN5clang16IndirectGotoStmt9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt9getTargetEv")
  //</editor-fold>
  public Expr /*P*/ getTarget() {
    return reinterpret_cast(Expr /*P*/ .class, Target);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1278,
   FQN="clang::IndirectGotoStmt::getTarget", NM="_ZNK5clang16IndirectGotoStmt9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang16IndirectGotoStmt9getTargetEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getTarget$Const() /*const*/ {
    return reinterpret_cast(/*const*/ Expr /*P*/ .class, Target);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::setTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1279,
   FQN="clang::IndirectGotoStmt::setTarget", NM="_ZN5clang16IndirectGotoStmt9setTargetEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt9setTargetEPNS_4ExprE")
  //</editor-fold>
  public void setTarget(Expr /*P*/ E) {
    Target = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  
  /// getConstantTarget - Returns the fixed target of this indirect
  /// goto, if one exists.
  
  // IndirectGotoStmt
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getConstantTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 891,
   FQN="clang::IndirectGotoStmt::getConstantTarget", NM="_ZN5clang16IndirectGotoStmt17getConstantTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt17getConstantTargetEv")
  //</editor-fold>
  public LabelDecl /*P*/ getConstantTarget() {
    {
      AddrLabelExpr /*P*/ E = dyn_cast_AddrLabelExpr(getTarget().IgnoreParenImpCasts());
      if ((E != null)) {
        return E.getLabel();
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getConstantTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1284,
   FQN="clang::IndirectGotoStmt::getConstantTarget", NM="_ZNK5clang16IndirectGotoStmt17getConstantTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang16IndirectGotoStmt17getConstantTargetEv")
  //</editor-fold>
  public /*const*/ LabelDecl /*P*/ getConstantTarget$Const() /*const*/ {
    return ((/*const_cast*/IndirectGotoStmt /*P*/ )(this)).getConstantTarget();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1288,
   FQN="clang::IndirectGotoStmt::getLocStart", NM="_ZNK5clang16IndirectGotoStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang16IndirectGotoStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(GotoLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1289,
   FQN="clang::IndirectGotoStmt::getLocEnd", NM="_ZNK5clang16IndirectGotoStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang16IndirectGotoStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Target.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1291,
   FQN="clang::IndirectGotoStmt::classof", NM="_ZN5clang16IndirectGotoStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.IndirectGotoStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectGotoStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1296,
   FQN="clang::IndirectGotoStmt::children", NM="_ZN5clang16IndirectGotoStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang16IndirectGotoStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Target))), new StmtIterator(create_type$ptr($AddrOf(Target)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "GotoLoc=" + GotoLoc // NOI18N
              + ", StarLoc=" + StarLoc // NOI18N
              + ", Target=" + Target // NOI18N
              + super.toString(); // NOI18N
  }
}
