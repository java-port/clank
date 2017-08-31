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
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//===----------------------------------------------------------------------===//
// Primary Expressions.
//===----------------------------------------------------------------------===//

/// OpaqueValueExpr - An expression referring to an opaque object of a
/// fixed type and value class.  These don't correspond to concrete
/// syntax; instead they're used to express operations (usually copy
/// operations) on values whose source is generally obvious from
/// context.
//<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 848,
 FQN="clang::OpaqueValueExpr", NM="_ZN5clang15OpaqueValueExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15OpaqueValueExprE")
//</editor-fold>
public class OpaqueValueExpr extends /*public*/ Expr implements NativeCloneable<OpaqueValueExpr> {
  /*friend  class ASTStmtReader*/
  /*friend*/public Expr /*P*/ SourceExpr;
  /*friend*/public SourceLocation Loc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::OpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 854,
   FQN="clang::OpaqueValueExpr::OpaqueValueExpr", NM="_ZN5clang15OpaqueValueExprC1ENS_14SourceLocationENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15OpaqueValueExprC1ENS_14SourceLocationENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindEPNS_4ExprE")
  //</editor-fold>
  public OpaqueValueExpr(SourceLocation Loc, QualType T, ExprValueKind VK) {
    this(Loc, T, VK, 
      ExprObjectKind.OK_Ordinary, 
      (Expr /*P*/ )null);
  }
  public OpaqueValueExpr(SourceLocation Loc, QualType T, ExprValueKind VK, 
      ExprObjectKind OK/*= OK_Ordinary*/) {
    this(Loc, T, VK, 
      OK, 
      (Expr /*P*/ )null);
  }
  public OpaqueValueExpr(SourceLocation Loc, QualType T, ExprValueKind VK, 
      ExprObjectKind OK/*= OK_Ordinary*/, 
      Expr /*P*/ SourceExpr/*= null*/) {
    // : Expr(OpaqueValueExprClass, T, VK, OK, T->isDependentType() || (SourceExpr && SourceExpr->isTypeDependent()), T->isDependentType() || (SourceExpr && SourceExpr->isValueDependent()), T->isInstantiationDependentType() || (SourceExpr && SourceExpr->isInstantiationDependent()), false), SourceExpr(SourceExpr), Loc(Loc) 
    //START JInit
    super(StmtClass.OpaqueValueExprClass, new QualType(T), VK, OK, 
        T.$arrow().isDependentType()
           || ((SourceExpr != null) && SourceExpr.isTypeDependent()), 
        T.$arrow().isDependentType()
           || ((SourceExpr != null) && SourceExpr.isValueDependent()), 
        T.$arrow().isInstantiationDependentType()
           || ((SourceExpr != null) && SourceExpr.isInstantiationDependent()), 
        false);
    this.SourceExpr = SourceExpr;
    this.Loc = new SourceLocation(Loc);
    //END JInit
  }

  
  /// Given an expression which invokes a copy constructor --- i.e.  a
  /// CXXConstructExpr, possibly wrapped in an ExprWithCleanups ---
  /// find the OpaqueValueExpr that's the source of the construction.
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::findInCopyConstruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3725,
   FQN="clang::OpaqueValueExpr::findInCopyConstruct", NM="_ZN5clang15OpaqueValueExpr19findInCopyConstructEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15OpaqueValueExpr19findInCopyConstructEPKNS_4ExprE")
  //</editor-fold>
  public static /*const*/ OpaqueValueExpr /*P*/ findInCopyConstruct(/*const*/ Expr /*P*/ e) {
    {
      /*const*/ ExprWithCleanups /*P*/ ewc = dyn_cast_ExprWithCleanups(e);
      if ((ewc != null)) {
        e = ewc.getSubExpr$Const();
      }
    }
    {
      /*const*/ MaterializeTemporaryExpr /*P*/ m = dyn_cast_MaterializeTemporaryExpr(e);
      if ((m != null)) {
        e = m.GetTemporaryExpr();
      }
    }
    e = cast_CXXConstructExpr(e).getArg$Const(0);
    {
      /*const*/ ImplicitCastExpr /*P*/ ice;
      while (((/*P*/ ice = dyn_cast_ImplicitCastExpr(e)) != null)) {
        e = ice.getSubExpr$Const();
      }
    }
    return cast_OpaqueValueExpr(e);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::OpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 873,
   FQN="clang::OpaqueValueExpr::OpaqueValueExpr", NM="_ZN5clang15OpaqueValueExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15OpaqueValueExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ OpaqueValueExpr(EmptyShell Empty) {
    // : Expr(OpaqueValueExprClass, Empty), Loc() 
    //START JInit
    super(StmtClass.OpaqueValueExprClass, new EmptyShell(Empty));
    this.Loc = new SourceLocation();
    //END JInit
  }

  /// \brief Retrieve the location of this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 877,
   FQN="clang::OpaqueValueExpr::getLocation", NM="_ZNK5clang15OpaqueValueExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15OpaqueValueExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 879,
   FQN="clang::OpaqueValueExpr::getLocStart", NM="_ZNK5clang15OpaqueValueExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15OpaqueValueExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return (SourceExpr != null) ? SourceExpr.getLocStart() : new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 882,
   FQN="clang::OpaqueValueExpr::getLocEnd", NM="_ZNK5clang15OpaqueValueExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15OpaqueValueExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return (SourceExpr != null) ? SourceExpr.getLocEnd() : new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 885,
   FQN="clang::OpaqueValueExpr::getExprLoc", NM="_ZNK5clang15OpaqueValueExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15OpaqueValueExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    if ((SourceExpr != null)) {
      return SourceExpr.getExprLoc();
    }
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 890,
   FQN="clang::OpaqueValueExpr::children", NM="_ZN5clang15OpaqueValueExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15OpaqueValueExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /// The source expression of an opaque value expression is the
  /// expression which originally generated the value.  This is
  /// provided as a convenience for analyses that don't wish to
  /// precisely model the execution behavior of the program.
  ///
  /// The source expression is typically set when building the
  /// expression which binds the opaque value expression in the first
  /// place.
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::getSourceExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 902,
   FQN="clang::OpaqueValueExpr::getSourceExpr", NM="_ZNK5clang15OpaqueValueExpr13getSourceExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15OpaqueValueExpr13getSourceExprEv")
  //</editor-fold>
  public Expr /*P*/ getSourceExpr() /*const*/ {
    return SourceExpr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 904,
   FQN="clang::OpaqueValueExpr::classof", NM="_ZN5clang15OpaqueValueExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15OpaqueValueExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OpaqueValueExprClass;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OpaqueValueExpr::~OpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 848,
   FQN="clang::OpaqueValueExpr::~OpaqueValueExpr", NM="_ZN5clang15OpaqueValueExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang15OpaqueValueExprD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public OpaqueValueExpr() {
    this.SourceExpr = null;
    this.Loc = new SourceLocation();
  }
    
  private OpaqueValueExpr(OpaqueValueExpr $Prm0) {
    super($Prm0);
    this.SourceExpr = $Prm0.SourceExpr;
    this.Loc = new SourceLocation($Prm0.Loc);
  }

  @Override
  public OpaqueValueExpr clone() {
    return new OpaqueValueExpr(this);
  }

  @Override public String toString() {
    return "" + "SourceExpr=" + SourceExpr // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
