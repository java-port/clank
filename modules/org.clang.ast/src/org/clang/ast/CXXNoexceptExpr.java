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


/// \brief Represents a C++11 noexcept expression (C++ [expr.unary.noexcept]).
///
/// The noexcept expression tests whether a given expression might throw. Its
/// result is a boolean constant.
//<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3526,
 FQN="clang::CXXNoexceptExpr", NM="_ZN5clang15CXXNoexceptExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang15CXXNoexceptExprE")
//</editor-fold>
public class CXXNoexceptExpr extends /*public*/ Expr {
  /*friend*/public /*JBIT bool*/ boolean Value /*: 1*/;
  /*friend*/public Stmt /*P*/ Operand;
  /*friend*/public SourceRange Range;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::CXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3534,
   FQN="clang::CXXNoexceptExpr::CXXNoexceptExpr", NM="_ZN5clang15CXXNoexceptExprC1ENS_8QualTypeEPNS_4ExprENS_14CanThrowResultENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang15CXXNoexceptExprC1ENS_8QualTypeEPNS_4ExprENS_14CanThrowResultENS_14SourceLocationES5_")
  //</editor-fold>
  public CXXNoexceptExpr(QualType Ty, Expr /*P*/ Operand, CanThrowResult Val, 
      SourceLocation Keyword, SourceLocation RParen) {
    // : Expr(CXXNoexceptExprClass, Ty, VK_RValue, OK_Ordinary, /*TypeDependent*/ false, /*ValueDependent*/ Val == CT_Dependent, Val == CT_Dependent || Operand->isInstantiationDependent(), Operand->containsUnexpandedParameterPack()), Value(Val == CT_Cannot), Operand(Operand), Range(Keyword, RParen) 
    //START JInit
    super(StmtClass.CXXNoexceptExprClass, new QualType(Ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, 
        Val == CanThrowResult.CT_Dependent, 
        Val == CanThrowResult.CT_Dependent || Operand.isInstantiationDependent(), 
        Operand.containsUnexpandedParameterPack());
    this.Value = Val == CanThrowResult.CT_Cannot;
    this.Operand = Operand;
    this.Range = new SourceRange(/*NO_COPY*/Keyword, /*NO_COPY*/RParen);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::CXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3544,
   FQN="clang::CXXNoexceptExpr::CXXNoexceptExpr", NM="_ZN5clang15CXXNoexceptExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang15CXXNoexceptExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXNoexceptExpr(EmptyShell Empty) {
    // : Expr(CXXNoexceptExprClass, Empty), Range() 
    //START JInit
    super(StmtClass.CXXNoexceptExprClass, new EmptyShell(Empty));
    this.Range = new SourceRange();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3548,
   FQN="clang::CXXNoexceptExpr::getOperand", NM="_ZNK5clang15CXXNoexceptExpr10getOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang15CXXNoexceptExpr10getOperandEv")
  //</editor-fold>
  public Expr /*P*/ getOperand() /*const*/ {
    return ((/*static_cast*/Expr /*P*/ )(Operand));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3550,
   FQN="clang::CXXNoexceptExpr::getLocStart", NM="_ZNK5clang15CXXNoexceptExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang15CXXNoexceptExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3551,
   FQN="clang::CXXNoexceptExpr::getLocEnd", NM="_ZNK5clang15CXXNoexceptExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang15CXXNoexceptExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3552,
   FQN="clang::CXXNoexceptExpr::getSourceRange", NM="_ZNK5clang15CXXNoexceptExpr14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang15CXXNoexceptExpr14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3554,
   FQN="clang::CXXNoexceptExpr::getValue", NM="_ZNK5clang15CXXNoexceptExpr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang15CXXNoexceptExpr8getValueEv")
  //</editor-fold>
  public boolean getValue() /*const*/ {
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3556,
   FQN="clang::CXXNoexceptExpr::classof", NM="_ZN5clang15CXXNoexceptExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang15CXXNoexceptExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXNoexceptExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXNoexceptExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3561,
   FQN="clang::CXXNoexceptExpr::children", NM="_ZN5clang15CXXNoexceptExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang15CXXNoexceptExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Operand))), new StmtIterator(create_type$ptr($AddrOf(Operand)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Operand=" + Operand // NOI18N
              + ", Range=" + Range // NOI18N
              + super.toString(); // NOI18N
  }
}
