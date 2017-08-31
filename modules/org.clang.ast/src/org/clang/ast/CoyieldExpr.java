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


/// \brief Represents a 'co_yield' expression.
//<editor-fold defaultstate="collapsed" desc="clang::CoyieldExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4228,
 FQN="clang::CoyieldExpr", NM="_ZN5clang11CoyieldExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoyieldExprE")
//</editor-fold>
public class CoyieldExpr extends /*public*/ CoroutineSuspendExpr {
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CoyieldExpr::CoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4231,
   FQN="clang::CoyieldExpr::CoyieldExpr", NM="_ZN5clang11CoyieldExprC1ENS_14SourceLocationEPNS_4ExprES3_S3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoyieldExprC1ENS_14SourceLocationEPNS_4ExprES3_S3_S3_")
  //</editor-fold>
  public CoyieldExpr(SourceLocation CoyieldLoc, Expr /*P*/ Operand, Expr /*P*/ Ready, 
      Expr /*P*/ Suspend, Expr /*P*/ Resume) {
    // : CoroutineSuspendExpr(CoyieldExprClass, CoyieldLoc, Operand, Ready, Suspend, Resume) 
    //START JInit
    super(StmtClass.CoyieldExprClass, new SourceLocation(CoyieldLoc), Operand, Ready, 
        Suspend, Resume);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoyieldExpr::CoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4235,
   FQN="clang::CoyieldExpr::CoyieldExpr", NM="_ZN5clang11CoyieldExprC1ENS_14SourceLocationENS_8QualTypeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoyieldExprC1ENS_14SourceLocationENS_8QualTypeEPNS_4ExprE")
  //</editor-fold>
  public CoyieldExpr(SourceLocation CoyieldLoc, QualType Ty, Expr /*P*/ Operand) {
    // : CoroutineSuspendExpr(CoyieldExprClass, CoyieldLoc, Ty, Operand) 
    //START JInit
    super(StmtClass.CoyieldExprClass, new SourceLocation(CoyieldLoc), new QualType(Ty), Operand);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CoyieldExpr::CoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4237,
   FQN="clang::CoyieldExpr::CoyieldExpr", NM="_ZN5clang11CoyieldExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoyieldExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CoyieldExpr(EmptyShell Empty) {
    // : CoroutineSuspendExpr(CoyieldExprClass, Empty) 
    //START JInit
    super(StmtClass.CoyieldExprClass, new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoyieldExpr::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4240,
   FQN="clang::CoyieldExpr::getOperand", NM="_ZNK5clang11CoyieldExpr10getOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang11CoyieldExpr10getOperandEv")
  //</editor-fold>
  public Expr /*P*/ getOperand() /*const*/ {
    // FIXME: Dig out the actual operand or store it.
    return getCommonExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CoyieldExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 4245,
   FQN="clang::CoyieldExpr::classof", NM="_ZN5clang11CoyieldExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang11CoyieldExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CoyieldExprClass;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
