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
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief A default argument (C++ [dcl.fct.default]).
///
/// This wraps up a function call argument that was created from the
/// corresponding parameter's default argument, when the call did not
/// explicitly supply arguments for all of the parameters.
//<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 967,
 FQN="clang::CXXDefaultArgExpr", NM="_ZN5clang17CXXDefaultArgExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExprE")
//</editor-fold>
public final class CXXDefaultArgExpr extends /*public*/ Expr {
  /// \brief The parameter whose default is being used.
  /*friend*/public ParmVarDecl /*P*/ Param;
  
  /// \brief The location where the default argument expression was used.
  /*friend*/public SourceLocation Loc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::CXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 974,
   FQN="clang::CXXDefaultArgExpr::CXXDefaultArgExpr", NM="_ZN5clang17CXXDefaultArgExprC1ENS_4Stmt9StmtClassENS_14SourceLocationEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExprC1ENS_4Stmt9StmtClassENS_14SourceLocationEPNS_11ParmVarDeclE")
  //</editor-fold>
  private CXXDefaultArgExpr(StmtClass SC, SourceLocation Loc, ParmVarDecl /*P*/ param) {
    // : Expr(SC, param->hasUnparsedDefaultArg() ? param->getType().getNonReferenceType() : param->getDefaultArg()->getType(), param->getDefaultArg()->getValueKind(), param->getDefaultArg()->getObjectKind(), false, false, false, false), Param(param), Loc(Loc) 
    //START JInit
    super(SC, 
        param.hasUnparsedDefaultArg() ? param.getType().getNonReferenceType() : param.getDefaultArg().getType(), 
        param.getDefaultArg().getValueKind(), 
        param.getDefaultArg().getObjectKind(), false, false, false, false);
    this.Param = param;
    this.Loc = new SourceLocation(Loc);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::CXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 984,
   FQN="clang::CXXDefaultArgExpr::CXXDefaultArgExpr", NM="_ZN5clang17CXXDefaultArgExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXDefaultArgExpr(EmptyShell Empty) {
    // : Expr(CXXDefaultArgExprClass, Empty), Loc() 
    //START JInit
    super(StmtClass.CXXDefaultArgExprClass, new EmptyShell(Empty));
    this.Loc = new SourceLocation();
    //END JInit
  }

  
  // \p Param is the parameter whose default argument is used by this
  // expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 988,
   FQN="clang::CXXDefaultArgExpr::Create", NM="_ZN5clang17CXXDefaultArgExpr6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExpr6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_11ParmVarDeclE")
  //</editor-fold>
  public static CXXDefaultArgExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation Loc, 
        ParmVarDecl /*P*/ Param) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new CXXDefaultArgExpr(StmtClass.CXXDefaultArgExprClass, new SourceLocation(Loc), Param);
     });
  }

  
  // Retrieve the parameter that the argument was created from.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 994,
   FQN="clang::CXXDefaultArgExpr::getParam", NM="_ZNK5clang17CXXDefaultArgExpr8getParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXDefaultArgExpr8getParamEv")
  //</editor-fold>
  public /*const*/ ParmVarDecl /*P*/ getParam$Const() /*const*/ {
    return Param;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 995,
   FQN="clang::CXXDefaultArgExpr::getParam", NM="_ZN5clang17CXXDefaultArgExpr8getParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExpr8getParamEv")
  //</editor-fold>
  public ParmVarDecl /*P*/ getParam() {
    return Param;
  }

  
  // Retrieve the actual argument to the function call.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 998,
   FQN="clang::CXXDefaultArgExpr::getExpr", NM="_ZNK5clang17CXXDefaultArgExpr7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXDefaultArgExpr7getExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr$Const() /*const*/ {
    return getParam$Const().getDefaultArg$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1001,
   FQN="clang::CXXDefaultArgExpr::getExpr", NM="_ZN5clang17CXXDefaultArgExpr7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExpr7getExprEv")
  //</editor-fold>
  public Expr /*P*/ getExpr() {
    return getParam().getDefaultArg();
  }

  
  /// \brief Retrieve the location where this default argument was actually
  /// used.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getUsedLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1007,
   FQN="clang::CXXDefaultArgExpr::getUsedLocation", NM="_ZNK5clang17CXXDefaultArgExpr15getUsedLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXDefaultArgExpr15getUsedLocationEv")
  //</editor-fold>
  public SourceLocation getUsedLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  /// Default argument expressions have no representation in the
  /// source, so they have an empty source range.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1011,
   FQN="clang::CXXDefaultArgExpr::getLocStart", NM="_ZNK5clang17CXXDefaultArgExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXDefaultArgExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1012,
   FQN="clang::CXXDefaultArgExpr::getLocEnd", NM="_ZNK5clang17CXXDefaultArgExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXDefaultArgExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1014,
   FQN="clang::CXXDefaultArgExpr::getExprLoc", NM="_ZNK5clang17CXXDefaultArgExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17CXXDefaultArgExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1016,
   FQN="clang::CXXDefaultArgExpr::classof", NM="_ZN5clang17CXXDefaultArgExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXDefaultArgExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDefaultArgExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1021,
   FQN="clang::CXXDefaultArgExpr::children", NM="_ZN5clang17CXXDefaultArgExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17CXXDefaultArgExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  
  @Override public String toString() {
    return "" + "Param=" + Param // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
