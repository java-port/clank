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


/// ExplicitCastExpr - An explicit cast written in the source
/// code.
///
/// This class is effectively an abstract class, because it provides
/// the basic representation of an explicitly-written cast without
/// specifying which kind of cast (C cast, functional cast, static
/// cast, etc.) was written; specific derived classes represent the
/// particular style of cast and its location information.
///
/// Unlike implicit casts, explicit cast nodes have two different
/// types: the type that was written into the source code, and the
/// actual type of the expression as determined by semantic
/// analysis. These types may differ slightly. For example, in C++ one
/// can cast to a reference type, which indicates that the resulting
/// expression will be an lvalue or xvalue. The reference type, however,
/// will not be used as the type of the expression.
//<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2800,
 FQN="clang::ExplicitCastExpr", NM="_ZN5clang16ExplicitCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ExplicitCastExprE")
//</editor-fold>
public class ExplicitCastExpr extends /*public*/ CastExpr {
  /// TInfo - Source type info for the (written) type
  /// this expression is casting to.
  private TypeSourceInfo /*P*/ TInfo;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr::ExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2806,
   FQN="clang::ExplicitCastExpr::ExplicitCastExpr", NM="_ZN5clang16ExplicitCastExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ExplicitCastExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoE")
  //</editor-fold>
  protected ExplicitCastExpr(StmtClass SC, QualType exprTy, ExprValueKind VK, 
      CastKind kind, Expr /*P*/ op, /*uint*/int PathSize, 
      TypeSourceInfo /*P*/ writtenTy) {
    // : CastExpr(SC, exprTy, VK, kind, op, PathSize), TInfo(writtenTy) 
    //START JInit
    super(SC, new QualType(exprTy), VK, kind, op, PathSize);
    this.TInfo = writtenTy;
    //END JInit
  }

  
  /// \brief Construct an empty explicit cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr::ExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2812,
   FQN="clang::ExplicitCastExpr::ExplicitCastExpr", NM="_ZN5clang16ExplicitCastExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ExplicitCastExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellEj")
  //</editor-fold>
  protected ExplicitCastExpr(StmtClass SC, EmptyShell Shell, /*uint*/int PathSize) {
    // : CastExpr(SC, Shell, PathSize) 
    //START JInit
    super(SC, new EmptyShell(Shell), PathSize);
    //END JInit
  }

/*public:*/
  /// getTypeInfoAsWritten - Returns the type source info for the type
  /// that this expression is casting to.
  //<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr::getTypeInfoAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2818,
   FQN="clang::ExplicitCastExpr::getTypeInfoAsWritten", NM="_ZNK5clang16ExplicitCastExpr20getTypeInfoAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16ExplicitCastExpr20getTypeInfoAsWrittenEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeInfoAsWritten() /*const*/ {
    return TInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr::setTypeInfoAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2819,
   FQN="clang::ExplicitCastExpr::setTypeInfoAsWritten", NM="_ZN5clang16ExplicitCastExpr20setTypeInfoAsWrittenEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ExplicitCastExpr20setTypeInfoAsWrittenEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeInfoAsWritten(TypeSourceInfo /*P*/ writtenTy) {
    TInfo = writtenTy;
  }

  
  /// getTypeAsWritten - Returns the type that this expression is
  /// casting to, as written in the source code.
  //<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr::getTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2823,
   FQN="clang::ExplicitCastExpr::getTypeAsWritten", NM="_ZNK5clang16ExplicitCastExpr16getTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16ExplicitCastExpr16getTypeAsWrittenEv")
  //</editor-fold>
  public QualType getTypeAsWritten() /*const*/ {
    return TInfo.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExplicitCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2825,
   FQN="clang::ExplicitCastExpr::classof", NM="_ZN5clang16ExplicitCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16ExplicitCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass().getValue() >= StmtClass.firstExplicitCastExprConstant.getValue()
       && T.getStmtClass().getValue() <= StmtClass.lastExplicitCastExprConstant.getValue();
  }

  
  @Override public String toString() {
    return "" + "TInfo=" + TInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
