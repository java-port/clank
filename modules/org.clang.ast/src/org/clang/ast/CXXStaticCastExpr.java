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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief A C++ \c static_cast expression (C++ [expr.static.cast]).
///
/// This expression node represents a C++ static cast, e.g.,
/// \c static_cast<int>(1.0).
//<editor-fold defaultstate="collapsed" desc="clang::CXXStaticCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 254,
 FQN="clang::CXXStaticCastExpr", NM="_ZN5clang17CXXStaticCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXStaticCastExprE")
//</editor-fold>
public final class CXXStaticCastExpr extends /*public*/ CXXNamedCastExpr implements /*private*/ TrailingObjects<CXXStaticCastExpr, CXXBaseSpecifier /*P*/ > {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStaticCastExpr::CXXStaticCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 257,
   FQN="clang::CXXStaticCastExpr::CXXStaticCastExpr", NM="_ZN5clang17CXXStaticCastExprC1ENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoENS_14SourceLocationES8_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXStaticCastExprC1ENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoENS_14SourceLocationES8_NS_11SourceRangeE")
  //</editor-fold>
  private CXXStaticCastExpr(QualType ty, ExprValueKind vk, CastKind kind, Expr /*P*/ op, 
      /*uint*/int pathSize, TypeSourceInfo /*P*/ writtenTy, 
      SourceLocation l, SourceLocation RParenLoc, 
      SourceRange AngleBrackets) {
    // : CXXNamedCastExpr(CXXStaticCastExprClass, ty, vk, kind, op, pathSize, writtenTy, l, RParenLoc, AngleBrackets), TrailingObjects<CXXStaticCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.CXXStaticCastExprClass, new QualType(ty), vk, kind, op, pathSize, 
        writtenTy, new SourceLocation(l), new SourceLocation(RParenLoc), new SourceRange(AngleBrackets));
    $TrailingObjects();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStaticCastExpr::CXXStaticCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 264,
   FQN="clang::CXXStaticCastExpr::CXXStaticCastExpr", NM="_ZN5clang17CXXStaticCastExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXStaticCastExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private /*explicit*/ CXXStaticCastExpr(EmptyShell Empty, /*uint*/int PathSize) {
    // : CXXNamedCastExpr(CXXStaticCastExprClass, Empty, PathSize), TrailingObjects<CXXStaticCastExpr, CXXBaseSpecifier * >() 
    //START JInit
    super(StmtClass.CXXStaticCastExprClass, new EmptyShell(Empty), PathSize);
    $TrailingObjects();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStaticCastExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 510,
   FQN="clang::CXXStaticCastExpr::Create", NM="_ZN5clang17CXXStaticCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_14TypeSourceInfoENS_14SourceLocationESI_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXStaticCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_14TypeSourceInfoENS_14SourceLocationESI_NS_11SourceRangeE")
  //</editor-fold>
  public static CXXStaticCastExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, 
        ExprValueKind VK, 
        CastKind K, Expr /*P*/ Op, 
        /*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath, 
        TypeSourceInfo /*P*/ WrittenTy, 
        SourceLocation L, 
        SourceLocation RParenLoc, 
        SourceRange AngleBrackets) {
    /*uint*/int PathSize = ((BasePath != null) ? BasePath.size() : 0);
    Object/*void P*/ Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    CXXStaticCastExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new CXXStaticCastExpr(new QualType(T), VK, K, Op, PathSize, WrittenTy, new SourceLocation(L), 
                new SourceLocation(RParenLoc), new SourceRange(AngleBrackets));
     });
    if ((PathSize != 0)) {
      std.uninitialized_copy_n(BasePath.data$Const(), BasePath.size(), 
          E.getTrailingObjects(CXXBaseSpecifier /*P*/.class));
    }
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXStaticCastExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 529,
   FQN="clang::CXXStaticCastExpr::CreateEmpty", NM="_ZN5clang17CXXStaticCastExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXStaticCastExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static CXXStaticCastExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int PathSize) {
    Object/*void P*/ Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    return /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new CXXStaticCastExpr(new EmptyShell(), PathSize);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXStaticCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 277,
   FQN="clang::CXXStaticCastExpr::classof", NM="_ZN5clang17CXXStaticCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXStaticCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXStaticCastExprClass;
  }

  
  /*friend  TrailingObjects<CXXStaticCastExpr, CXXBaseSpecifier *>*/
  /*friend  class CastExpr*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
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
