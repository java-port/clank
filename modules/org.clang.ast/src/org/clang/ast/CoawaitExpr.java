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


/// \brief Represents a 'co_await' expression.
//<editor-fold defaultstate="collapsed" desc="clang::CoawaitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4205,
 FQN="clang::CoawaitExpr", NM="_ZN5clang11CoawaitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoawaitExprE")
//</editor-fold>
public class CoawaitExpr extends /*public*/ CoroutineSuspendExpr {
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CoawaitExpr::CoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4208,
   FQN="clang::CoawaitExpr::CoawaitExpr", NM="_ZN5clang11CoawaitExprC1ENS_14SourceLocationEPNS_4ExprES3_S3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoawaitExprC1ENS_14SourceLocationEPNS_4ExprES3_S3_S3_")
  //</editor-fold>
  public CoawaitExpr(SourceLocation CoawaitLoc, Expr /*P*/ Operand, Expr /*P*/ Ready, 
      Expr /*P*/ Suspend, Expr /*P*/ Resume) {
    // : CoroutineSuspendExpr(CoawaitExprClass, CoawaitLoc, Operand, Ready, Suspend, Resume) 
    //START JInit
    super(StmtClass.CoawaitExprClass, new SourceLocation(CoawaitLoc), Operand, Ready, 
        Suspend, Resume);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoawaitExpr::CoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4212,
   FQN="clang::CoawaitExpr::CoawaitExpr", NM="_ZN5clang11CoawaitExprC1ENS_14SourceLocationENS_8QualTypeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoawaitExprC1ENS_14SourceLocationENS_8QualTypeEPNS_4ExprE")
  //</editor-fold>
  public CoawaitExpr(SourceLocation CoawaitLoc, QualType Ty, Expr /*P*/ Operand) {
    // : CoroutineSuspendExpr(CoawaitExprClass, CoawaitLoc, Ty, Operand) 
    //START JInit
    super(StmtClass.CoawaitExprClass, new SourceLocation(CoawaitLoc), new QualType(Ty), Operand);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoawaitExpr::CoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4214,
   FQN="clang::CoawaitExpr::CoawaitExpr", NM="_ZN5clang11CoawaitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoawaitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CoawaitExpr(EmptyShell Empty) {
    // : CoroutineSuspendExpr(CoawaitExprClass, Empty) 
    //START JInit
    super(StmtClass.CoawaitExprClass, new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoawaitExpr::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4217,
   FQN="clang::CoawaitExpr::getOperand", NM="_ZNK5clang11CoawaitExpr10getOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CoawaitExpr10getOperandEv")
  //</editor-fold>
  public Expr /*P*/ getOperand() /*const*/ {
    // FIXME: Dig out the actual operand or store it.
    return getCommonExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoawaitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4222,
   FQN="clang::CoawaitExpr::classof", NM="_ZN5clang11CoawaitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoawaitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CoawaitExprClass;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
