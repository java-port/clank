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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// Represents a call to a member function that
/// may be written either with member call syntax (e.g., "obj.func()"
/// or "objptr->func()") or with normal function-call syntax
/// ("func()") within a member function that ends up calling a member
/// function. The callee in either case is a MemberExpr that contains
/// both the object argument and the member function, while the
/// arguments are the arguments within the parentheses (not including
/// the object argument).
//<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 121,
 FQN="clang::CXXMemberCallExpr", NM="_ZN5clang17CXXMemberCallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXMemberCallExprE")
//</editor-fold>
public class CXXMemberCallExpr extends /*public*/ CallExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::CXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 123,
   FQN="clang::CXXMemberCallExpr::CXXMemberCallExpr", NM="_ZN5clang17CXXMemberCallExprC1ERNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS4_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXMemberCallExprC1ERNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS4_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE")
  //</editor-fold>
  public CXXMemberCallExpr(final ASTContext /*&*/ C, Expr /*P*/ fn, ArrayRef<Expr /*P*/ > args, 
      QualType t, ExprValueKind VK, SourceLocation RP) {
    // : CallExpr(C, CXXMemberCallExprClass, fn, args, t, VK, RP) 
    //START JInit
    super(C, StmtClass.CXXMemberCallExprClass, fn, new ArrayRef<Expr /*P*/ >(args), new QualType(t), VK, new SourceLocation(RP));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::CXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 127,
   FQN="clang::CXXMemberCallExpr::CXXMemberCallExpr", NM="_ZN5clang17CXXMemberCallExprC1ERNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXMemberCallExprC1ERNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXMemberCallExpr(final ASTContext /*&*/ C, EmptyShell Empty) {
    // : CallExpr(C, CXXMemberCallExprClass, Empty) 
    //START JInit
    super(C, StmtClass.CXXMemberCallExprClass, new EmptyShell(Empty));
    //END JInit
  }

  
  /// \brief Retrieves the implicit object argument for the member call.
  ///
  /// For example, in "x.f(5)", this returns the sub-expression "x".
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::getImplicitObjectArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 459,
   FQN="clang::CXXMemberCallExpr::getImplicitObjectArgument", NM="_ZNK5clang17CXXMemberCallExpr25getImplicitObjectArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXMemberCallExpr25getImplicitObjectArgumentEv")
  //</editor-fold>
  public Expr /*P*/ getImplicitObjectArgument() /*const*/ {
    /*const*/ Expr /*P*/ Callee = getCallee$Const().IgnoreParens$Const();
    {
      /*const*/ MemberExpr /*P*/ MemExpr = dyn_cast_MemberExpr(Callee);
      if ((MemExpr != null)) {
        return MemExpr.getBase();
      }
    }
    {
      /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(Callee);
      if ((BO != null)) {
        if (BO.getOpcode() == BinaryOperatorKind.BO_PtrMemD || BO.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
          return BO.getLHS();
        }
      }
    }
    
    // FIXME: Will eventually need to cope with member pointers.
    return null;
  }

  
  /// \brief Retrieves the declaration of the called method.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::getMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 471,
   FQN="clang::CXXMemberCallExpr::getMethodDecl", NM="_ZNK5clang17CXXMemberCallExpr13getMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXMemberCallExpr13getMethodDeclEv")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getMethodDecl() /*const*/ {
    {
      /*const*/ MemberExpr /*P*/ MemExpr = dyn_cast_MemberExpr(getCallee$Const().IgnoreParens$Const());
      if ((MemExpr != null)) {
        return cast_CXXMethodDecl(MemExpr.getMemberDecl());
      }
    }
    
    // FIXME: Will eventually need to cope with member pointers.
    return null;
  }

  
  /// \brief Retrieves the CXXRecordDecl for the underlying type of
  /// the implicit object argument.
  ///
  /// Note that this is may not be the same declaration as that of the class
  /// context of the CXXMethodDecl which this function is calling.
  /// FIXME: Returns 0 for member pointer call exprs.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::getRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 481,
   FQN="clang::CXXMemberCallExpr::getRecordDecl", NM="_ZNK5clang17CXXMemberCallExpr13getRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXMemberCallExpr13getRecordDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getRecordDecl() /*const*/ {
    Expr /*P*/ ThisArg = getImplicitObjectArgument();
    if (!(ThisArg != null)) {
      return null;
    }
    if (ThisArg.getType().$arrow().isAnyPointerType()) {
      return ThisArg.getType().$arrow().getPointeeType().$arrow().getAsCXXRecordDecl();
    }
    
    return ThisArg.getType().$arrow().getAsCXXRecordDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 146,
   FQN="clang::CXXMemberCallExpr::getExprLoc", NM="_ZNK5clang17CXXMemberCallExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXMemberCallExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    SourceLocation CLoc = getCallee$Const().getExprLoc();
    if (CLoc.isValid()) {
      return CLoc;
    }
    
    return getLocStart();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMemberCallExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 154,
   FQN="clang::CXXMemberCallExpr::classof", NM="_ZN5clang17CXXMemberCallExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXMemberCallExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXMemberCallExprClass;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
