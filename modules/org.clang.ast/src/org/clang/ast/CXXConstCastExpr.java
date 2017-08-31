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
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief A C++ \c const_cast expression (C++ [expr.const.cast]).
///
/// This expression node represents a const cast, e.g.,
/// \c const_cast<char*>(PtrToConstChar).
///
/// A const_cast can remove type qualifiers but does not change the underlying
/// value.
//<editor-fold defaultstate="collapsed" desc="clang::CXXConstCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 372,
 FQN="clang::CXXConstCastExpr", NM="_ZN5clang16CXXConstCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstCastExprE")
//</editor-fold>
public final class CXXConstCastExpr extends /*public*/ CXXNamedCastExpr implements /*private*/ TrailingObjects<CXXConstCastExpr, CXXBaseSpecifier /*P*/ > {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstCastExpr::CXXConstCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 375,
   FQN="clang::CXXConstCastExpr::CXXConstCastExpr", NM="_ZN5clang16CXXConstCastExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationES7_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstCastExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationES7_NS_11SourceRangeE")
  //</editor-fold>
  private CXXConstCastExpr(QualType ty, ExprValueKind VK, Expr /*P*/ op, 
      TypeSourceInfo /*P*/ writtenTy, SourceLocation l, 
      SourceLocation RParenLoc, SourceRange AngleBrackets) {
    // : CXXNamedCastExpr(CXXConstCastExprClass, ty, VK, CK_NoOp, op, 0, writtenTy, l, RParenLoc, AngleBrackets), TrailingObjects<CXXConstCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.CXXConstCastExprClass, new QualType(ty), VK, CastKind.CK_NoOp, op, 
        0, writtenTy, new SourceLocation(l), new SourceLocation(RParenLoc), new SourceRange(AngleBrackets));
    $TrailingObjects();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstCastExpr::CXXConstCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 381,
   FQN="clang::CXXConstCastExpr::CXXConstCastExpr", NM="_ZN5clang16CXXConstCastExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstCastExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private /*explicit*/ CXXConstCastExpr(EmptyShell Empty) {
    // : CXXNamedCastExpr(CXXConstCastExprClass, Empty, 0), TrailingObjects<CXXConstCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.CXXConstCastExprClass, new EmptyShell(Empty), 0);
    $TrailingObjects();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstCastExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 617,
   FQN="clang::CXXConstCastExpr::Create", NM="_ZN5clang16CXXConstCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationESA_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationESA_NS_11SourceRangeE")
  //</editor-fold>
  public static CXXConstCastExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, 
        ExprValueKind VK, Expr /*P*/ Op, 
        TypeSourceInfo /*P*/ WrittenTy, 
        SourceLocation L, 
        SourceLocation RParenLoc, 
        SourceRange AngleBrackets) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new CXXConstCastExpr(new QualType(T), VK, Op, WrittenTy, new SourceLocation(L), new SourceLocation(RParenLoc), new SourceRange(AngleBrackets));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstCastExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 626,
   FQN="clang::CXXConstCastExpr::CreateEmpty", NM="_ZN5clang16CXXConstCastExpr11CreateEmptyERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstCastExpr11CreateEmptyERKNS_10ASTContextE")
  //</editor-fold>
  public static CXXConstCastExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new CXXConstCastExpr(new EmptyShell());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 392,
   FQN="clang::CXXConstCastExpr::classof", NM="_ZN5clang16CXXConstCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXConstCastExprClass;
  }

  
  /*friend  TrailingObjects<CXXConstCastExpr, CXXBaseSpecifier *>*/
  /*friend  class CastExpr*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == CXXBaseSpecifier.class;
    return 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
