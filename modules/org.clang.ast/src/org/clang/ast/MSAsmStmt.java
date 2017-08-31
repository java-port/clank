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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.Token;
import org.clang.lex.llvm.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.impl.StmtStatics.*;


/// This represents a Microsoft inline-assembly statement extension.
///
//<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1744,
 FQN="clang::MSAsmStmt", NM="_ZN5clang9MSAsmStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmtE")
//</editor-fold>
public class MSAsmStmt extends /*public*/ AsmStmt {
  /*friend*/public SourceLocation LBraceLoc;
  /*friend*/public SourceLocation EndLoc;
  private StringRef AsmStr;
  
  /*friend*/public /*uint*/int NumAsmToks;
  
  private type$ptr<Token> /*P*/ AsmToks;
  private type$ptr<StringRef/*P*/> Constraints;
  private type$ptr<StringRef/*P*/> Clobbers;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::MSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 715,
   FQN="clang::MSAsmStmt::MSAsmStmt", NM="_ZN5clang9MSAsmStmtC1ERKNS_10ASTContextENS_14SourceLocationES4_bbN4llvm8ArrayRefINS_5TokenEEEjjNS6_INS5_9StringRefEEENS6_IPNS_4ExprEEES9_SA_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmtC1ERKNS_10ASTContextENS_14SourceLocationES4_bbN4llvm8ArrayRefINS_5TokenEEEjjNS6_INS5_9StringRefEEENS6_IPNS_4ExprEEES9_SA_S4_")
  //</editor-fold>
  public MSAsmStmt(final /*const*/ ASTContext /*&*/ C, SourceLocation asmloc, 
      SourceLocation lbraceloc, boolean issimple, boolean isvolatile, 
      ArrayRefToken asmtoks, /*uint*/int numoutputs, 
      /*uint*/int numinputs, 
      ArrayRef<StringRef> constraints, ArrayRef<Expr /*P*/ > exprs, 
      StringRef asmstr, ArrayRef<StringRef> clobbers, 
      SourceLocation endloc) {
    // : AsmStmt(MSAsmStmtClass, asmloc, issimple, isvolatile, numoutputs, numinputs, clobbers.size()), LBraceLoc(lbraceloc), EndLoc(endloc), AsmStr(), NumAsmToks(asmtoks.size()) 
    //START JInit
    super(StmtClass.MSAsmStmtClass, new SourceLocation(asmloc), issimple, isvolatile, numoutputs, 
        numinputs, clobbers.size());
    this.LBraceLoc = new SourceLocation(lbraceloc);
    this.EndLoc = new SourceLocation(endloc);
    this.AsmStr = new StringRef();
    this.NumAsmToks = asmtoks.size();
    //END JInit
    
    initialize(C, new StringRef(asmstr), new ArrayRefToken(asmtoks), new ArrayRef<StringRef>(constraints), new ArrayRef<Expr /*P*/ >(exprs), new ArrayRef<StringRef>(clobbers));
  }

  
  /// \brief Build an empty MS-style inline-assembly statement.
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::MSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1765,
   FQN="clang::MSAsmStmt::MSAsmStmt", NM="_ZN5clang9MSAsmStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ MSAsmStmt(EmptyShell Empty) {
    // : AsmStmt(MSAsmStmtClass, Empty), LBraceLoc(), EndLoc(), AsmStr(), NumAsmToks(0), AsmToks(null), Constraints(null), Clobbers(null) 
    //START JInit
    super(StmtClass.MSAsmStmtClass, new EmptyShell(Empty));
    this.LBraceLoc = new SourceLocation();
    this.EndLoc = new SourceLocation();
    this.AsmStr = new StringRef();
    this.NumAsmToks = 0;
    this.AsmToks = null;
    this.Constraints = null;
    this.Clobbers = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1768,
   FQN="clang::MSAsmStmt::getLBraceLoc", NM="_ZNK5clang9MSAsmStmt12getLBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt12getLBraceLocEv")
  //</editor-fold>
  public SourceLocation getLBraceLoc() /*const*/ {
    return new SourceLocation(LBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::setLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1769,
   FQN="clang::MSAsmStmt::setLBraceLoc", NM="_ZN5clang9MSAsmStmt12setLBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt12setLBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLBraceLoc(SourceLocation L) {
    LBraceLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1770,
   FQN="clang::MSAsmStmt::getEndLoc", NM="_ZNK5clang9MSAsmStmt9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return new SourceLocation(EndLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::setEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1771,
   FQN="clang::MSAsmStmt::setEndLoc", NM="_ZN5clang9MSAsmStmt9setEndLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt9setEndLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEndLoc(SourceLocation L) {
    EndLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::hasBraces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1773,
   FQN="clang::MSAsmStmt::hasBraces", NM="_ZNK5clang9MSAsmStmt9hasBracesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt9hasBracesEv")
  //</editor-fold>
  public boolean hasBraces() /*const*/ {
    return LBraceLoc.isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getNumAsmToks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1775,
   FQN="clang::MSAsmStmt::getNumAsmToks", NM="_ZN5clang9MSAsmStmt13getNumAsmToksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt13getNumAsmToksEv")
  //</editor-fold>
  public /*uint*/int getNumAsmToks() {
    return NumAsmToks;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getAsmToks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1776,
   FQN="clang::MSAsmStmt::getAsmToks", NM="_ZN5clang9MSAsmStmt10getAsmToksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt10getAsmToksEv")
  //</editor-fold>
  public type$ptr<Token> /*P*/ getAsmToks() {
    return AsmToks;
  }

  
  //===--- Asm String Analysis ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1779,
   FQN="clang::MSAsmStmt::getAsmString", NM="_ZNK5clang9MSAsmStmt12getAsmStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt12getAsmStringEv")
  //</editor-fold>
  public StringRef getAsmString() /*const*/ {
    return new StringRef(AsmStr);
  }

  
  /// Assemble final IR asm string.
  
  /// Assemble final IR asm string (MS-style).
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::generateAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 671,
   FQN="clang::MSAsmStmt::generateAsmString", NM="_ZNK5clang9MSAsmStmt17generateAsmStringERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt17generateAsmStringERKNS_10ASTContextE")
  //</editor-fold>
  public std.string generateAsmString(final /*const*/ ASTContext /*&*/ C) /*const*/ {
    // FIXME: This needs to be translated into the IR string representation.
    return AsmStr.$string();
  }

  
  //===--- Output operands ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getOutputConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1786,
   FQN="clang::MSAsmStmt::getOutputConstraint", NM="_ZNK5clang9MSAsmStmt19getOutputConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt19getOutputConstraintEj")
  //</editor-fold>
  public StringRef getOutputConstraint(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumOutputs));
    return new StringRef(Constraints.$at(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getOutputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 676,
   FQN="clang::MSAsmStmt::getOutputExpr", NM="_ZN5clang9MSAsmStmt13getOutputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt13getOutputExprEj")
  //</editor-fold>
  public Expr /*P*/ getOutputExpr(/*uint*/int i) {
    return cast_Expr(Exprs.$at(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getOutputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1793,
   FQN="clang::MSAsmStmt::getOutputExpr", NM="_ZNK5clang9MSAsmStmt13getOutputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt13getOutputExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getOutputExpr$Const(/*uint*/int i) /*const*/ {
    return ((/*const_cast*/MSAsmStmt /*P*/ )(this)).getOutputExpr(i);
  }

  
  //===--- Input operands ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getInputConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1799,
   FQN="clang::MSAsmStmt::getInputConstraint", NM="_ZNK5clang9MSAsmStmt18getInputConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt18getInputConstraintEj")
  //</editor-fold>
  public StringRef getInputConstraint(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumInputs));
    return new StringRef(Constraints.$at(i + NumOutputs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 680,
   FQN="clang::MSAsmStmt::getInputExpr", NM="_ZN5clang9MSAsmStmt12getInputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt12getInputExprEj")
  //</editor-fold>
  public Expr /*P*/ getInputExpr(/*uint*/int i) {
    return cast_Expr(Exprs.$at(i + NumOutputs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::setInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 683,
   FQN="clang::MSAsmStmt::setInputExpr", NM="_ZN5clang9MSAsmStmt12setInputExprEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt12setInputExprEjPNS_4ExprE")
  //</editor-fold>
  public void setInputExpr(/*uint*/int i, Expr /*P*/ E) {
    Exprs.$set(i + NumOutputs, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1807,
   FQN="clang::MSAsmStmt::getInputExpr", NM="_ZNK5clang9MSAsmStmt12getInputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt12getInputExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInputExpr$Const(/*uint*/int i) /*const*/ {
    return ((/*const_cast*/MSAsmStmt /*P*/ )(this)).getInputExpr(i);
  }

  
  //===--- Other ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getAllConstraints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1813,
   FQN="clang::MSAsmStmt::getAllConstraints", NM="_ZNK5clang9MSAsmStmt17getAllConstraintsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt17getAllConstraintsEv")
  //</editor-fold>
  public ArrayRef<StringRef> getAllConstraints() /*const*/ {
    return llvm.makeArrayRef(Constraints, NumInputs + NumOutputs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1816,
   FQN="clang::MSAsmStmt::getClobbers", NM="_ZNK5clang9MSAsmStmt11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt11getClobbersEv")
  //</editor-fold>
  public ArrayRef<StringRef> getClobbers() /*const*/ {
    return llvm.makeArrayRef(Clobbers, NumClobbers);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getAllExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1819,
   FQN="clang::MSAsmStmt::getAllExprs", NM="_ZNK5clang9MSAsmStmt11getAllExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt11getAllExprsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > getAllExprs() /*const*/ {
    return llvm.makeArrayRef(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, Exprs)), 
        NumInputs + NumOutputs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getClobber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1824,
   FQN="clang::MSAsmStmt::getClobber", NM="_ZNK5clang9MSAsmStmt10getClobberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt10getClobberEj")
  //</editor-fold>
  public StringRef getClobber(/*uint*/int i) /*const*/ {
    return new StringRef(getClobbers().$at(i));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 733,
   FQN="clang::MSAsmStmt::initialize", NM="_ZN5clang9MSAsmStmt10initializeERKNS_10ASTContextEN4llvm9StringRefENS4_8ArrayRefINS_5TokenEEENS6_IS5_EENS6_IPNS_4ExprEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt10initializeERKNS_10ASTContextEN4llvm9StringRefENS4_8ArrayRefINS_5TokenEEENS6_IS5_EENS6_IPNS_4ExprEEES9_")
  //</editor-fold>
  /*friend*/public void initialize(final /*const*/ ASTContext /*&*/ C, StringRef asmstr, 
            ArrayRefToken asmtoks, 
            ArrayRef<StringRef> constraints, 
            ArrayRef<Expr /*P*/ > exprs, 
            ArrayRef<StringRef> clobbers) {
    assert (NumAsmToks == asmtoks.size());
    assert (NumClobbers == clobbers.size());
    assert (exprs.size() == NumOutputs + NumInputs);
    assert (exprs.size() == constraints.size());
    
    AsmStr.$assignMove(copyIntoContext(C, new StringRef(asmstr)));
    
    Exprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [exprs.size()]);
    std.copy(exprs.begin(), exprs.end(), Exprs);
    
    AsmToks = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Token [asmtoks.size()]);
    std.copy(asmtoks.begin(), asmtoks.end(), AsmToks);
    
    Constraints = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new StringRef [exprs.size()]);
    std.transform(constraints.begin(), constraints.end(), Constraints, 
        /*[&, &C]*/ (StringRef Constraint) -> {
              return copyIntoContext(C, new StringRef(Constraint));
            });
    
    Clobbers = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new StringRef [NumClobbers]);
    // FIXME: Avoid the allocation/copy if at all possible.
    std.transform(clobbers.begin(), clobbers.end(), Clobbers, 
        /*[&, &C]*/ (StringRef Clobber) -> {
              return copyIntoContext(C, new StringRef(Clobber));
            });
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1832,
   FQN="clang::MSAsmStmt::getLocStart", NM="_ZNK5clang9MSAsmStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AsmLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1833,
   FQN="clang::MSAsmStmt::getLocEnd", NM="_ZNK5clang9MSAsmStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang9MSAsmStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(EndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1835,
   FQN="clang::MSAsmStmt::classof", NM="_ZN5clang9MSAsmStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.MSAsmStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSAsmStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1839,
   FQN="clang::MSAsmStmt::children", NM="_ZN5clang9MSAsmStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang9MSAsmStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Exprs), new StmtIterator(Exprs.$add(NumInputs + NumOutputs)));
  }

  
  @Override public String toString() {
    return "" + "LBraceLoc=" + LBraceLoc // NOI18N
              + ", EndLoc=" + EndLoc // NOI18N
              + ", AsmStr=" + AsmStr // NOI18N
              + ", NumAsmToks=" + NumAsmToks // NOI18N
              + ", AsmToks=" + AsmToks // NOI18N
              + ", Constraints=" + Constraints // NOI18N
              + ", Clobbers=" + Clobbers // NOI18N
              + super.toString(); // NOI18N
  }
}
