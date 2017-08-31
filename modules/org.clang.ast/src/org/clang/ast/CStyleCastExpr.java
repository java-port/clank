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


/// CStyleCastExpr - An explicit cast in C (C99 6.5.4) or a C-style
/// cast in C++ (C++ [expr.cast]), which uses the syntax
/// (Type)expr. For example: @c (int)f.
//<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2834,
 FQN="clang::CStyleCastExpr", NM="_ZN5clang14CStyleCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExprE")
//</editor-fold>
public final class CStyleCastExpr extends /*public*/ ExplicitCastExpr implements /*private*/ TrailingObjects<CStyleCastExpr, CXXBaseSpecifier /*P*/ >, ITrailingObjectsJavaBase<CStyleCastExpr> {
  private SourceLocation LPLoc; // the location of the left paren
  private SourceLocation RPLoc; // the location of the right paren
  
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::CStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2840,
   FQN="clang::CStyleCastExpr::CStyleCastExpr", NM="_ZN5clang14CStyleCastExprC1ENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoENS_14SourceLocationES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExprC1ENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEjPNS_14TypeSourceInfoENS_14SourceLocationES8_")
  //</editor-fold>
  private CStyleCastExpr(QualType exprTy, ExprValueKind vk, CastKind kind, Expr /*P*/ op, 
      /*uint*/int PathSize, TypeSourceInfo /*P*/ writtenTy, 
      SourceLocation l, SourceLocation r) {
    // : ExplicitCastExpr(CStyleCastExprClass, exprTy, vk, kind, op, PathSize, writtenTy), TrailingObjects<CStyleCastExpr, CXXBaseSpecifier * >(), LPLoc(l), RPLoc(r) 
    //START JInit
    super(StmtClass.CStyleCastExprClass, new QualType(exprTy), vk, kind, op, PathSize, 
        writtenTy);
    $TrailingObjects();
    this.LPLoc = new SourceLocation(l);
    this.RPLoc = new SourceLocation(r);
    //END JInit
  }

  
  /// \brief Construct an empty C-style explicit cast.
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::CStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2847,
   FQN="clang::CStyleCastExpr::CStyleCastExpr", NM="_ZN5clang14CStyleCastExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private /*explicit*/ CStyleCastExpr(EmptyShell Shell, /*uint*/int PathSize) {
    // : ExplicitCastExpr(CStyleCastExprClass, Shell, PathSize), TrailingObjects<CStyleCastExpr, CXXBaseSpecifier * >(), LPLoc(), RPLoc() 
    //START JInit
    super(StmtClass.CStyleCastExprClass, new EmptyShell(Shell), PathSize);
    $TrailingObjects();
    this.LPLoc = new SourceLocation();
    this.RPLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1673,
   FQN="clang::CStyleCastExpr::Create", NM="_ZN5clang14CStyleCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_14TypeSourceInfoENS_14SourceLocationESI_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_13ExprValueKindENS_8CastKindEPNS_4ExprEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_14TypeSourceInfoENS_14SourceLocationESI_")
  //</editor-fold>
  public static CStyleCastExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, 
        ExprValueKind VK, CastKind K, Expr /*P*/ Op, 
        /*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath, 
        TypeSourceInfo /*P*/ WrittenTy, 
        SourceLocation L, SourceLocation R) {
    /*uint*/int PathSize = ((BasePath != null) ? BasePath.size() : 0);
    // JAVA: MEMORY
    Object/*void P*/ Buffer;
    if (false) {
      Buffer = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    } else {
      Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    }
    CStyleCastExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new CStyleCastExpr(new QualType(T), VK, K, Op, PathSize, WrittenTy, new SourceLocation(L), new SourceLocation(R));
     });
    if ((PathSize != 0)) {
      std.uninitialized_copy_n(BasePath.data$Const(), BasePath.size(), 
          E.getTrailingObjects(CXXBaseSpecifier /*P*/.class));
    }
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1688,
   FQN="clang::CStyleCastExpr::CreateEmpty", NM="_ZN5clang14CStyleCastExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static CStyleCastExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int PathSize) {
    Object/*void P*/ Buffer;
    if (false) {
      Buffer = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    } else {
      Buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(CXXBaseSpecifier.class, PathSize));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Buffer)*/ Stmt.$new(Buffer, (type$ptr<?> Mem)->{
        return new CStyleCastExpr(new EmptyShell(), PathSize);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2860,
   FQN="clang::CStyleCastExpr::getLParenLoc", NM="_ZNK5clang14CStyleCastExpr12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14CStyleCastExpr12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LPLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2861,
   FQN="clang::CStyleCastExpr::setLParenLoc", NM="_ZN5clang14CStyleCastExpr12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExpr12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation L) {
    LPLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2863,
   FQN="clang::CStyleCastExpr::getRParenLoc", NM="_ZNK5clang14CStyleCastExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14CStyleCastExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RPLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2864,
   FQN="clang::CStyleCastExpr::setRParenLoc", NM="_ZN5clang14CStyleCastExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RPLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2866,
   FQN="clang::CStyleCastExpr::getLocStart", NM="_ZNK5clang14CStyleCastExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14CStyleCastExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LPLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2867,
   FQN="clang::CStyleCastExpr::getLocEnd", NM="_ZNK5clang14CStyleCastExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14CStyleCastExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getSubExpr$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CStyleCastExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2871,
   FQN="clang::CStyleCastExpr::classof", NM="_ZN5clang14CStyleCastExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14CStyleCastExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CStyleCastExprClass;
  }

  
  /*friend  TrailingObjects<CStyleCastExpr, CXXBaseSpecifier *>*/
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
    return "" + "LPLoc=" + LPLoc // NOI18N
              + ", RPLoc=" + RPLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
