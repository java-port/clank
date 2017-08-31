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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.clang.basic.*;


/// \brief Abstract class common to all of the C++ "named"/"keyword" casts.
///
/// This abstract class is inherited by all of the classes
/// representing "named" casts: CXXStaticCastExpr for \c static_cast,
/// CXXDynamicCastExpr for \c dynamic_cast, CXXReinterpretCastExpr for
/// reinterpret_cast, and CXXConstCastExpr for \c const_cast.
//<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 203,
 FQN="clang::CXXNamedCastExpr", NM="_ZN5clang16CXXNamedCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXNamedCastExprE")
//</editor-fold>
public class CXXNamedCastExpr extends /*public*/ ExplicitCastExpr {
/*private:*/
  /*friend*/public SourceLocation Loc; // the location of the casting op
  /*friend*/public SourceLocation RParenLoc; // the location of the right parenthesis
  /*friend*/public SourceRange AngleBrackets; // range for '<' '>'
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::CXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 210,
   FQN="clang::CXXNamedCastExpr::CXXNamedCastExpr", NM="_ZN5clang16CXXNamedCastExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoENS_14SourceLocationESA_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXNamedCastExprC1ENS_4Stmt9StmtClassENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoENS_14SourceLocationESA_NS_11SourceRangeE")
  //</editor-fold>
  protected CXXNamedCastExpr(StmtClass SC, QualType ty, ExprValueKind VK, 
      CastKind kind, Expr /*P*/ op, /*uint*/int PathSize, 
      TypeSourceInfo /*P*/ writtenTy, SourceLocation l, 
      SourceLocation RParenLoc, 
      SourceRange AngleBrackets) {
    // : ExplicitCastExpr(SC, ty, VK, kind, op, PathSize, writtenTy), Loc(l), RParenLoc(RParenLoc), AngleBrackets(AngleBrackets) 
    //START JInit
    super(SC, new QualType(ty), VK, kind, op, PathSize, writtenTy);
    this.Loc = new SourceLocation(l);
    this.RParenLoc = new SourceLocation(RParenLoc);
    this.AngleBrackets = new SourceRange(AngleBrackets);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::CXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 218,
   FQN="clang::CXXNamedCastExpr::CXXNamedCastExpr", NM="_ZN5clang16CXXNamedCastExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXNamedCastExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellEj")
  //</editor-fold>
  protected /*explicit*/ CXXNamedCastExpr(StmtClass SC, EmptyShell Shell, /*uint*/int PathSize) {
    // : ExplicitCastExpr(SC, Shell, PathSize), Loc(), RParenLoc(), AngleBrackets() 
    //START JInit
    super(SC, new EmptyShell(Shell), PathSize);
    this.Loc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    this.AngleBrackets = new SourceRange();
    //END JInit
  }

  
  /*friend  class ASTStmtReader*/
/*public:*/
  
  //===----------------------------------------------------------------------===//
  //  Named casts
  //===----------------------------------------------------------------------===//
  
  /// getCastName - Get the name of the C++ cast being used, e.g.,
  /// "static_cast", "dynamic_cast", "reinterpret_cast", or
  /// "const_cast". The returned pointer must not be freed.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::getCastName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 500,
   FQN="clang::CXXNamedCastExpr::getCastName", NM="_ZNK5clang16CXXNamedCastExpr11getCastNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXNamedCastExpr11getCastNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCastName() /*const*/ {
    switch (getStmtClass()) {
     case CXXStaticCastExprClass:
      return $static_cast;
     case CXXDynamicCastExprClass:
      return $dynamic_cast;
     case CXXReinterpretCastExprClass:
      return $reinterpret_cast;
     case CXXConstCastExprClass:
      return $const_cast;
     default:
      return $("<invalid cast>");
    }
  }

  
  /// \brief Retrieve the location of the cast operator keyword, e.g.,
  /// \c static_cast.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 228,
   FQN="clang::CXXNamedCastExpr::getOperatorLoc", NM="_ZNK5clang16CXXNamedCastExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXNamedCastExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  /// \brief Retrieve the location of the closing parenthesis.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 231,
   FQN="clang::CXXNamedCastExpr::getRParenLoc", NM="_ZNK5clang16CXXNamedCastExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXNamedCastExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 233,
   FQN="clang::CXXNamedCastExpr::getLocStart", NM="_ZNK5clang16CXXNamedCastExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXNamedCastExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 234,
   FQN="clang::CXXNamedCastExpr::getLocEnd", NM="_ZNK5clang16CXXNamedCastExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXNamedCastExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::getAngleBrackets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 235,
   FQN="clang::CXXNamedCastExpr::getAngleBrackets", NM="_ZNK5clang16CXXNamedCastExpr16getAngleBracketsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXNamedCastExpr16getAngleBracketsEv")
  //</editor-fold>
  public SourceRange getAngleBrackets() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(AngleBrackets);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNamedCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 237,
   FQN="clang::CXXNamedCastExpr::classof", NM="_ZN5clang16CXXNamedCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXNamedCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    switch (T.getStmtClass()) {
     case CXXStaticCastExprClass:
     case CXXDynamicCastExprClass:
     case CXXReinterpretCastExprClass:
     case CXXConstCastExprClass:
      return true;
     default:
      return false;
    }
  }

  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", AngleBrackets=" + AngleBrackets // NOI18N
              + super.toString(); // NOI18N
  }
}
