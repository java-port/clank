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

/// ReturnStmt - This represents a return, optionally of an expression:
///   return;
///   return 4;
///
/// Note that GCC allows return with no argument in a function declared to
/// return a value, and it allows returning a value in functions declared to
/// return void.  We explicitly model this in the AST, which means you can't
/// depend on the return type of the function and the presence of an argument.
///
//<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1366,
 FQN="clang::ReturnStmt", NM="_ZN5clang10ReturnStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmtE")
//</editor-fold>
public class ReturnStmt extends /*public*/ Stmt {
  private SourceLocation RetLoc;
  private Stmt /*P*/ RetExpr;
  private /*const*/ VarDecl /*P*/ NRVOCandidate;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::ReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1372,
   FQN="clang::ReturnStmt::ReturnStmt", NM="_ZN5clang10ReturnStmtC1ENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmtC1ENS_14SourceLocationE")
  //</editor-fold>
  public /*explicit*/ ReturnStmt(SourceLocation RL) {
    // : ReturnStmt(RL, null, null) 
    //START JInit
    this(new SourceLocation(RL), (Expr /*P*/ )null, (/*const*/ VarDecl /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::ReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1374,
   FQN="clang::ReturnStmt::ReturnStmt", NM="_ZN5clang10ReturnStmtC1ENS_14SourceLocationEPNS_4ExprEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmtC1ENS_14SourceLocationEPNS_4ExprEPKNS_7VarDeclE")
  //</editor-fold>
  public ReturnStmt(SourceLocation RL, Expr /*P*/ E, /*const*/ VarDecl /*P*/ NRVOCandidate) {
    // : Stmt(ReturnStmtClass), RetLoc(RL), RetExpr((Stmt * )E), NRVOCandidate(NRVOCandidate) 
    //START JInit
    super(StmtClass.ReturnStmtClass);
    this.RetLoc = new SourceLocation(RL);
    this.RetExpr = (Stmt /*P*/ )E;
    this.NRVOCandidate = NRVOCandidate;
    //END JInit
  }

  
  /// \brief Build an empty return expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::ReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1379,
   FQN="clang::ReturnStmt::ReturnStmt", NM="_ZN5clang10ReturnStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ReturnStmt(EmptyShell Empty) {
    // : Stmt(ReturnStmtClass, Empty), RetLoc() 
    //START JInit
    super(StmtClass.ReturnStmtClass, new EmptyShell(Empty));
    this.RetLoc = new SourceLocation();
    //END JInit
  }

  
  
  // ReturnStmt
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::getRetValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 899,
   FQN="clang::ReturnStmt::getRetValue", NM="_ZNK5clang10ReturnStmt11getRetValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10ReturnStmt11getRetValueEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getRetValue$Const() /*const*/ {
    return cast_or_null_Expr(RetExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::getRetValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 902,
   FQN="clang::ReturnStmt::getRetValue", NM="_ZN5clang10ReturnStmt11getRetValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmt11getRetValueEv")
  //</editor-fold>
  public Expr /*P*/ getRetValue() {
    return cast_or_null_Expr(RetExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::setRetValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1383,
   FQN="clang::ReturnStmt::setRetValue", NM="_ZN5clang10ReturnStmt11setRetValueEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmt11setRetValueEPNS_4ExprE")
  //</editor-fold>
  public void setRetValue(Expr /*P*/ E) {
    RetExpr = reinterpret_cast(Stmt /*P*/ .class, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::getReturnLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1385,
   FQN="clang::ReturnStmt::getReturnLoc", NM="_ZNK5clang10ReturnStmt12getReturnLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10ReturnStmt12getReturnLocEv")
  //</editor-fold>
  public SourceLocation getReturnLoc() /*const*/ {
    return new SourceLocation(RetLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::setReturnLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1386,
   FQN="clang::ReturnStmt::setReturnLoc", NM="_ZN5clang10ReturnStmt12setReturnLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmt12setReturnLocENS_14SourceLocationE")
  //</editor-fold>
  public void setReturnLoc(SourceLocation L) {
    RetLoc.$assign(L);
  }

  
  /// \brief Retrieve the variable that might be used for the named return
  /// value optimization.
  ///
  /// The optimization itself can only be performed if the variable is
  /// also marked as an NRVO object.
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::getNRVOCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1393,
   FQN="clang::ReturnStmt::getNRVOCandidate", NM="_ZNK5clang10ReturnStmt16getNRVOCandidateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10ReturnStmt16getNRVOCandidateEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getNRVOCandidate() /*const*/ {
    return NRVOCandidate;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::setNRVOCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1394,
   FQN="clang::ReturnStmt::setNRVOCandidate", NM="_ZN5clang10ReturnStmt16setNRVOCandidateEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmt16setNRVOCandidateEPKNS_7VarDeclE")
  //</editor-fold>
  public void setNRVOCandidate(/*const*/ VarDecl /*P*/ Var) {
    NRVOCandidate = Var;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1396,
   FQN="clang::ReturnStmt::getLocStart", NM="_ZNK5clang10ReturnStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10ReturnStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RetLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1397,
   FQN="clang::ReturnStmt::getLocEnd", NM="_ZNK5clang10ReturnStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10ReturnStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return (RetExpr != null) ? RetExpr.getLocEnd() : new SourceLocation(RetLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1401,
   FQN="clang::ReturnStmt::classof", NM="_ZN5clang10ReturnStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ReturnStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ReturnStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1406,
   FQN="clang::ReturnStmt::children", NM="_ZN5clang10ReturnStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10ReturnStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if ((RetExpr != null)) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(RetExpr))), new StmtIterator(create_type$ptr($AddrOf(RetExpr)).$add(1)));
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "RetLoc=" + RetLoc // NOI18N
              + ", RetExpr=" + RetExpr // NOI18N
              + ", NRVOCandidate=" + NRVOCandidate // NOI18N
              + super.toString(); // NOI18N
  }
}
