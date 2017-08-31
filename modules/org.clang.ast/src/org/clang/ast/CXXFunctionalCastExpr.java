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


/// \brief Represents an explicit C++ type conversion that uses "functional"
/// notation (C++ [expr.type.conv]).
///
/// Example:
/// \code
///   x = int(0.5);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1395,
 FQN="clang::CXXFunctionalCastExpr", NM="_ZN5clang21CXXFunctionalCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExprE")
//</editor-fold>
public final class CXXFunctionalCastExpr extends /*public*/ ExplicitCastExpr implements /*private*/ TrailingObjects<CXXFunctionalCastExpr, CXXBaseSpecifier /*P*/ > {
  private SourceLocation LParenLoc;
  private SourceLocation RParenLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::CXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1401,
   FQN="clang::CXXFunctionalCastExpr::CXXFunctionalCastExpr", NM="_ZN5clang21CXXFunctionalCastExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_14TypeSourceInfoENS_8CastKindEPNS_4ExprEjNS_14SourceLocationES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_14TypeSourceInfoENS_8CastKindEPNS_4ExprEjNS_14SourceLocationES8_")
  //</editor-fold>
  private CXXFunctionalCastExpr(QualType ty, ExprValueKind VK, 
      TypeSourceInfo /*P*/ writtenTy, 
      CastKind kind, Expr /*P*/ castExpr, /*uint*/int pathSize, 
      SourceLocation lParenLoc, SourceLocation rParenLoc) {
    // : ExplicitCastExpr(CXXFunctionalCastExprClass, ty, VK, kind, castExpr, pathSize, writtenTy), TrailingObjects<CXXFunctionalCastExpr, CXXBaseSpecifier * >(), LParenLoc(lParenLoc), RParenLoc(rParenLoc) 
    //START JInit
    super(StmtClass.CXXFunctionalCastExprClass, new QualType(ty), VK, kind, 
        castExpr, pathSize, writtenTy);
    $TrailingObjects();
    this.LParenLoc = new SourceLocation(lParenLoc);
    this.RParenLoc = new SourceLocation(rParenLoc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::CXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1409,
   FQN="clang::CXXFunctionalCastExpr::CXXFunctionalCastExpr", NM="_ZN5clang21CXXFunctionalCastExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private /*explicit*/ CXXFunctionalCastExpr(EmptyShell Shell, /*uint*/int PathSize) {
    // : ExplicitCastExpr(CXXFunctionalCastExprClass, Shell, PathSize), TrailingObjects<CXXFunctionalCastExpr, CXXBaseSpecifier * >(), LParenLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.CXXFunctionalCastExprClass, new EmptyShell(Shell), PathSize);
    $TrailingObjects();
    this.LParenLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 630,
   FQN="clang::CXXFunctionalCastExpr::Create", NM="_ZN5clang21CXXFunctionalCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindEPNS_14TypeSourceInfoENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS_14SourceLocationESI_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindEPNS_14TypeSourceInfoENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS_14SourceLocationESI_")
  //</editor-fold>
  public static CXXFunctionalCastExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, ExprValueKind VK, 
        TypeSourceInfo /*P*/ Written, CastKind K, Expr /*P*/ Op, 
        /*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath, 
        SourceLocation L, SourceLocation R) {
    /*uint*/int PathSize = ((BasePath != null) ? BasePath.size() : 0);
    Object/*void P*/ Buffer;
    if (false) {
      Buffer = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    } else {
      Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    }
    CXXFunctionalCastExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new CXXFunctionalCastExpr(new QualType(T), VK, Written, K, Op, PathSize, new SourceLocation(L), new SourceLocation(R));
     });
    if ((PathSize != 0)) {
      std.uninitialized_copy_n(BasePath.data$Const(), BasePath.size(), 
          E.getTrailingObjects(CXXBaseSpecifier /*P*/.class));
    }
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 645,
   FQN="clang::CXXFunctionalCastExpr::CreateEmpty", NM="_ZN5clang21CXXFunctionalCastExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static CXXFunctionalCastExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int PathSize) {
    Object/*void P*/ Buffer; 
    if (false) {
      Buffer = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    } else {
      Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new CXXFunctionalCastExpr(new EmptyShell(), PathSize);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1423,
   FQN="clang::CXXFunctionalCastExpr::getLParenLoc", NM="_ZNK5clang21CXXFunctionalCastExpr12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang21CXXFunctionalCastExpr12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1424,
   FQN="clang::CXXFunctionalCastExpr::setLParenLoc", NM="_ZN5clang21CXXFunctionalCastExpr12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExpr12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation L) {
    LParenLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1425,
   FQN="clang::CXXFunctionalCastExpr::getRParenLoc", NM="_ZNK5clang21CXXFunctionalCastExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang21CXXFunctionalCastExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1426,
   FQN="clang::CXXFunctionalCastExpr::setRParenLoc", NM="_ZN5clang21CXXFunctionalCastExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 651,
   FQN="clang::CXXFunctionalCastExpr::getLocStart", NM="_ZNK5clang21CXXFunctionalCastExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang21CXXFunctionalCastExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getTypeInfoAsWritten().getTypeLoc().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 655,
   FQN="clang::CXXFunctionalCastExpr::getLocEnd", NM="_ZNK5clang21CXXFunctionalCastExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang21CXXFunctionalCastExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return RParenLoc.isValid() ? new SourceLocation(RParenLoc) : getSubExpr$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFunctionalCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1431,
   FQN="clang::CXXFunctionalCastExpr::classof", NM="_ZN5clang21CXXFunctionalCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang21CXXFunctionalCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXFunctionalCastExprClass;
  }

  
  /*friend  TrailingObjects<CXXFunctionalCastExpr, CXXBaseSpecifier *>*/
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
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
