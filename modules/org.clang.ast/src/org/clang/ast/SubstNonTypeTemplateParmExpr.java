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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a reference to a non-type template parameter
/// that has been substituted with a template argument.
//<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3767,
 FQN="clang::SubstNonTypeTemplateParmExpr", NM="_ZN5clang28SubstNonTypeTemplateParmExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang28SubstNonTypeTemplateParmExprE")
//</editor-fold>
public class SubstNonTypeTemplateParmExpr extends /*public*/ Expr {
  /// \brief The replaced parameter.
  /*friend*/public NonTypeTemplateParmDecl /*P*/ Param;
  
  /// \brief The replacement expression.
  /*friend*/public Stmt /*P*/ Replacement;
  
  /// \brief The location of the non-type template parameter reference.
  /*friend*/public SourceLocation NameLoc;
  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::SubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3779,
   FQN="clang::SubstNonTypeTemplateParmExpr::SubstNonTypeTemplateParmExpr", NM="_ZN5clang28SubstNonTypeTemplateParmExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang28SubstNonTypeTemplateParmExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ SubstNonTypeTemplateParmExpr(EmptyShell Empty) {
    // : Expr(SubstNonTypeTemplateParmExprClass, Empty), NameLoc() 
    //START JInit
    super(StmtClass.SubstNonTypeTemplateParmExprClass, new EmptyShell(Empty));
    this.NameLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::SubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3783,
   FQN="clang::SubstNonTypeTemplateParmExpr::SubstNonTypeTemplateParmExpr", NM="_ZN5clang28SubstNonTypeTemplateParmExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_23NonTypeTemplateParmDeclEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang28SubstNonTypeTemplateParmExprC1ENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPNS_23NonTypeTemplateParmDeclEPNS_4ExprE")
  //</editor-fold>
  public SubstNonTypeTemplateParmExpr(QualType type, 
      ExprValueKind valueKind, 
      SourceLocation loc, 
      NonTypeTemplateParmDecl /*P*/ param, 
      Expr /*P*/ replacement) {
    // : Expr(SubstNonTypeTemplateParmExprClass, type, valueKind, OK_Ordinary, replacement->isTypeDependent(), replacement->isValueDependent(), replacement->isInstantiationDependent(), replacement->containsUnexpandedParameterPack()), Param(param), Replacement(replacement), NameLoc(loc) 
    //START JInit
    super(StmtClass.SubstNonTypeTemplateParmExprClass, new QualType(type), valueKind, ExprObjectKind.OK_Ordinary, 
        replacement.isTypeDependent(), replacement.isValueDependent(), 
        replacement.isInstantiationDependent(), 
        replacement.containsUnexpandedParameterPack());
    this.Param = param;
    this.Replacement = replacement;
    this.NameLoc = new SourceLocation(loc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3794,
   FQN="clang::SubstNonTypeTemplateParmExpr::getNameLoc", NM="_ZNK5clang28SubstNonTypeTemplateParmExpr10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang28SubstNonTypeTemplateParmExpr10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return new SourceLocation(NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3795,
   FQN="clang::SubstNonTypeTemplateParmExpr::getLocStart", NM="_ZNK5clang28SubstNonTypeTemplateParmExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang28SubstNonTypeTemplateParmExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3796,
   FQN="clang::SubstNonTypeTemplateParmExpr::getLocEnd", NM="_ZNK5clang28SubstNonTypeTemplateParmExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang28SubstNonTypeTemplateParmExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(NameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::getReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3798,
   FQN="clang::SubstNonTypeTemplateParmExpr::getReplacement", NM="_ZNK5clang28SubstNonTypeTemplateParmExpr14getReplacementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang28SubstNonTypeTemplateParmExpr14getReplacementEv")
  //</editor-fold>
  public Expr /*P*/ getReplacement() /*const*/ {
    return cast_Expr(Replacement);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::getParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3800,
   FQN="clang::SubstNonTypeTemplateParmExpr::getParameter", NM="_ZNK5clang28SubstNonTypeTemplateParmExpr12getParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang28SubstNonTypeTemplateParmExpr12getParameterEv")
  //</editor-fold>
  public NonTypeTemplateParmDecl /*P*/ getParameter() /*const*/ {
    return Param;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3802,
   FQN="clang::SubstNonTypeTemplateParmExpr::classof", NM="_ZN5clang28SubstNonTypeTemplateParmExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang28SubstNonTypeTemplateParmExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ s) {
    return s.getStmtClass() == StmtClass.SubstNonTypeTemplateParmExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3807,
   FQN="clang::SubstNonTypeTemplateParmExpr::children", NM="_ZN5clang28SubstNonTypeTemplateParmExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang28SubstNonTypeTemplateParmExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Replacement))), new StmtIterator(create_type$ptr($AddrOf(Replacement)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Param=" + Param // NOI18N
              + ", Replacement=" + Replacement // NOI18N
              + ", NameLoc=" + NameLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
