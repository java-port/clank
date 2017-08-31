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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// AsmStmt is the base class for GCCAsmStmt and MSAsmStmt.
///
//<editor-fold defaultstate="collapsed" desc="clang::AsmStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1414,
 FQN="clang::AsmStmt", NM="_ZN5clang7AsmStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmtE")
//</editor-fold>
public class AsmStmt extends /*public*/ Stmt {
/*protected:*/
  protected SourceLocation AsmLoc;
  /// \brief True if the assembly statement does not have any input or output
  /// operands.
  protected boolean IsSimple;
  
  /// \brief If true, treat this inline assembly as having side effects.
  /// This assembly statement should not be optimized, deleted or moved.
  protected boolean IsVolatile;
  
  /*friend*/public /*uint*/int NumOutputs;
  /*friend*/public /*uint*/int NumInputs;
  /*friend*/public /*uint*/int NumClobbers;
  
  protected type$ptr<Stmt /*P*/ /*P*/> Exprs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::AsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1431,
   FQN="clang::AsmStmt::AsmStmt", NM="_ZN5clang7AsmStmtC1ENS_4Stmt9StmtClassENS_14SourceLocationEbbjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmtC1ENS_4Stmt9StmtClassENS_14SourceLocationEbbjjj")
  //</editor-fold>
  protected AsmStmt(StmtClass SC, SourceLocation asmloc, boolean issimple, boolean isvolatile, 
      /*uint*/int numoutputs, /*uint*/int numinputs, /*uint*/int numclobbers) {
    // : Stmt(SC), AsmLoc(asmloc), IsSimple(issimple), IsVolatile(isvolatile), NumOutputs(numoutputs), NumInputs(numinputs), NumClobbers(numclobbers) 
    //START JInit
    super(SC);
    this.AsmLoc = new SourceLocation(asmloc);
    this.IsSimple = issimple;
    this.IsVolatile = isvolatile;
    this.NumOutputs = numoutputs;
    this.NumInputs = numinputs;
    this.NumClobbers = numclobbers;
    //END JInit
  }

  
  /*friend  class ASTStmtReader*/
/*public:*/
  /// \brief Build an empty inline-assembly statement.
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::AsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1440,
   FQN="clang::AsmStmt::AsmStmt", NM="_ZN5clang7AsmStmtC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmtC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ AsmStmt(StmtClass SC, EmptyShell Empty) {
    // : Stmt(SC, Empty), AsmLoc(), Exprs(null) 
    //START JInit
    super(SC, new EmptyShell(Empty));
    this.AsmLoc = new SourceLocation();
    this.Exprs = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getAsmLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1443,
   FQN="clang::AsmStmt::getAsmLoc", NM="_ZNK5clang7AsmStmt9getAsmLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt9getAsmLocEv")
  //</editor-fold>
  public SourceLocation getAsmLoc() /*const*/ {
    return new SourceLocation(AsmLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::setAsmLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1444,
   FQN="clang::AsmStmt::setAsmLoc", NM="_ZN5clang7AsmStmt9setAsmLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt9setAsmLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAsmLoc(SourceLocation L) {
    AsmLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1446,
   FQN="clang::AsmStmt::isSimple", NM="_ZNK5clang7AsmStmt8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    return IsSimple;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::setSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1447,
   FQN="clang::AsmStmt::setSimple", NM="_ZN5clang7AsmStmt9setSimpleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt9setSimpleEb")
  //</editor-fold>
  public void setSimple(boolean V) {
    IsSimple = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1449,
   FQN="clang::AsmStmt::isVolatile", NM="_ZNK5clang7AsmStmt10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return IsVolatile;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1450,
   FQN="clang::AsmStmt::setVolatile", NM="_ZN5clang7AsmStmt11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean V) {
    IsVolatile = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1452,
   FQN="clang::AsmStmt::getLocStart", NM="_ZNK5clang7AsmStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1453,
   FQN="clang::AsmStmt::getLocEnd", NM="_ZNK5clang7AsmStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation();
  }

  
  //===--- Asm String Analysis ---===//
  
  /// Assemble final IR asm string.
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::generateAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 330,
   FQN="clang::AsmStmt::generateAsmString", NM="_ZNK5clang7AsmStmt17generateAsmStringERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt17generateAsmStringERKNS_10ASTContextE")
  //</editor-fold>
  public std.string generateAsmString(final /*const*/ ASTContext /*&*/ C) /*const*/ {
    {
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt(this);
      if ((gccAsmStmt != null)) {
        return gccAsmStmt.generateAsmString(C);
      }
    }
    {
      /*const*/ MSAsmStmt /*P*/ msAsmStmt = dyn_cast_MSAsmStmt(this);
      if ((msAsmStmt != null)) {
        return msAsmStmt.generateAsmString(C);
      }
    }
    throw new llvm_unreachable("unknown asm statement kind!");
  }

  
  //===--- Output operands ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getNumOutputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1462,
   FQN="clang::AsmStmt::getNumOutputs", NM="_ZNK5clang7AsmStmt13getNumOutputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt13getNumOutputsEv")
  //</editor-fold>
  public /*uint*/int getNumOutputs() /*const*/ {
    return NumOutputs;
  }

  
  /// getOutputConstraint - Return the constraint string for the specified
  /// output operand.  All output constraints are known to be non-empty (either
  /// '=' or '+').
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getOutputConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 338,
   FQN="clang::AsmStmt::getOutputConstraint", NM="_ZNK5clang7AsmStmt19getOutputConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt19getOutputConstraintEj")
  //</editor-fold>
  public StringRef getOutputConstraint(/*uint*/int i) /*const*/ {
    {
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt(this);
      if ((gccAsmStmt != null)) {
        return gccAsmStmt.getOutputConstraint(i);
      }
    }
    {
      /*const*/ MSAsmStmt /*P*/ msAsmStmt = dyn_cast_MSAsmStmt(this);
      if ((msAsmStmt != null)) {
        return msAsmStmt.getOutputConstraint(i);
      }
    }
    throw new llvm_unreachable("unknown asm statement kind!");
  }

  
  /// isOutputPlusConstraint - Return true if the specified output constraint
  /// is a "+" constraint (which is both an input and an output) or false if it
  /// is an "=" constraint (just an output).
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::isOutputPlusConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1472,
   FQN="clang::AsmStmt::isOutputPlusConstraint", NM="_ZNK5clang7AsmStmt22isOutputPlusConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt22isOutputPlusConstraintEj")
  //</editor-fold>
  public boolean isOutputPlusConstraint(/*uint*/int i) /*const*/ {
    return getOutputConstraint(i).$at(0) == $$PLUS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getOutputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 346,
   FQN="clang::AsmStmt::getOutputExpr", NM="_ZNK5clang7AsmStmt13getOutputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt13getOutputExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getOutputExpr(/*uint*/int i) /*const*/ {
    {
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt(this);
      if ((gccAsmStmt != null)) {
        return gccAsmStmt.getOutputExpr$Const(i);
      }
    }
    {
      /*const*/ MSAsmStmt /*P*/ msAsmStmt = dyn_cast_MSAsmStmt(this);
      if ((msAsmStmt != null)) {
        return msAsmStmt.getOutputExpr$Const(i);
      }
    }
    throw new llvm_unreachable("unknown asm statement kind!");
  }

  
  /// getNumPlusOperands - Return the number of output operands that have a "+"
  /// constraint.
  
  /// getNumPlusOperands - Return the number of output operands that have a "+"
  /// constraint.
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getNumPlusOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 380,
   FQN="clang::AsmStmt::getNumPlusOperands", NM="_ZNK5clang7AsmStmt18getNumPlusOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt18getNumPlusOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumPlusOperands() /*const*/ {
    /*uint*/int Res = 0;
    for (/*uint*/int i = 0, e = getNumOutputs(); i != e; ++i)  {
      if (isOutputPlusConstraint(i)) {
        ++Res;
      }
    }
    return Res;
  }

  
  //===--- Input operands ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getNumInputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1484,
   FQN="clang::AsmStmt::getNumInputs", NM="_ZNK5clang7AsmStmt12getNumInputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt12getNumInputsEv")
  //</editor-fold>
  public /*uint*/int getNumInputs() /*const*/ {
    return NumInputs;
  }

  
  /// getInputConstraint - Return the specified input constraint.  Unlike output
  /// constraints, these can be empty.
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getInputConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 354,
   FQN="clang::AsmStmt::getInputConstraint", NM="_ZNK5clang7AsmStmt18getInputConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt18getInputConstraintEj")
  //</editor-fold>
  public StringRef getInputConstraint(/*uint*/int i) /*const*/ {
    {
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt(this);
      if ((gccAsmStmt != null)) {
        return gccAsmStmt.getInputConstraint(i);
      }
    }
    {
      /*const*/ MSAsmStmt /*P*/ msAsmStmt = dyn_cast_MSAsmStmt(this);
      if ((msAsmStmt != null)) {
        return msAsmStmt.getInputConstraint(i);
      }
    }
    throw new llvm_unreachable("unknown asm statement kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 362,
   FQN="clang::AsmStmt::getInputExpr", NM="_ZNK5clang7AsmStmt12getInputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt12getInputExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInputExpr(/*uint*/int i) /*const*/ {
    {
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt(this);
      if ((gccAsmStmt != null)) {
        return gccAsmStmt.getInputExpr$Const(i);
      }
    }
    {
      /*const*/ MSAsmStmt /*P*/ msAsmStmt = dyn_cast_MSAsmStmt(this);
      if ((msAsmStmt != null)) {
        return msAsmStmt.getInputExpr$Const(i);
      }
    }
    throw new llvm_unreachable("unknown asm statement kind!");
  }

  
  //===--- Other ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getNumClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1494,
   FQN="clang::AsmStmt::getNumClobbers", NM="_ZNK5clang7AsmStmt14getNumClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt14getNumClobbersEv")
  //</editor-fold>
  public /*uint*/int getNumClobbers() /*const*/ {
    return NumClobbers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::getClobber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 370,
   FQN="clang::AsmStmt::getClobber", NM="_ZNK5clang7AsmStmt10getClobberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt10getClobberEj")
  //</editor-fold>
  public StringRef getClobber(/*uint*/int i) /*const*/ {
    {
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt(this);
      if ((gccAsmStmt != null)) {
        return gccAsmStmt.getClobber(i);
      }
    }
    {
      /*const*/ MSAsmStmt /*P*/ msAsmStmt = dyn_cast_MSAsmStmt(this);
      if ((msAsmStmt != null)) {
        return msAsmStmt.getClobber(i);
      }
    }
    throw new llvm_unreachable("unknown asm statement kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1497,
   FQN="clang::AsmStmt::classof", NM="_ZN5clang7AsmStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.GCCAsmStmtClass
       || T.getStmtClass() == StmtClass.MSAsmStmtClass;
  }

  
  // Input expr iterators.
  /*typedef ExprIterator inputs_iterator*/
//  public final class inputs_iterator extends ExprIterator{ };
  /*typedef ConstExprIterator const_inputs_iterator*/
//  public final class const_inputs_iterator extends ConstExprIterator{ };
  /*typedef llvm::iterator_range<inputs_iterator> inputs_range*/
//  public final class inputs_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<const_inputs_iterator> inputs_const_range*/
//  public final class inputs_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::begin_inputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1509,
   FQN="clang::AsmStmt::begin_inputs", NM="_ZN5clang7AsmStmt12begin_inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt12begin_inputsEv")
  //</editor-fold>
  public ExprIterator begin_inputs() {
    return new ExprIterator(Exprs.$add(NumOutputs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::end_inputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1513,
   FQN="clang::AsmStmt::end_inputs", NM="_ZN5clang7AsmStmt10end_inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt10end_inputsEv")
  //</editor-fold>
  public ExprIterator end_inputs() {
    return new ExprIterator(Exprs.$add(NumOutputs).$add(NumInputs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::inputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1517,
   FQN="clang::AsmStmt::inputs", NM="_ZN5clang7AsmStmt6inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt6inputsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > inputs() {
    return new iterator_range<Expr /*P*/ >(begin_inputs(), end_inputs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::begin_inputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1519,
   FQN="clang::AsmStmt::begin_inputs", NM="_ZNK5clang7AsmStmt12begin_inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt12begin_inputsEv")
  //</editor-fold>
  public ConstExprIterator begin_inputs$Const() /*const*/ {
    return new ConstExprIterator(Exprs.$add(NumOutputs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::end_inputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1523,
   FQN="clang::AsmStmt::end_inputs", NM="_ZNK5clang7AsmStmt10end_inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt10end_inputsEv")
  //</editor-fold>
  public ConstExprIterator end_inputs$Const() /*const*/ {
    return new ConstExprIterator(Exprs.$add(NumOutputs).$add(NumInputs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::inputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1527,
   FQN="clang::AsmStmt::inputs", NM="_ZNK5clang7AsmStmt6inputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt6inputsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> inputs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(begin_inputs$Const(), end_inputs$Const());
  }

  
  // Output expr iterators.
  /*typedef ExprIterator outputs_iterator*/
//  public final class outputs_iterator extends ExprIterator{ };
  /*typedef ConstExprIterator const_outputs_iterator*/
//  public final class const_outputs_iterator extends ConstExprIterator{ };
  /*typedef llvm::iterator_range<outputs_iterator> outputs_range*/
//  public final class outputs_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<const_outputs_iterator> outputs_const_range*/
//  public final class outputs_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::begin_outputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1538,
   FQN="clang::AsmStmt::begin_outputs", NM="_ZN5clang7AsmStmt13begin_outputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt13begin_outputsEv")
  //</editor-fold>
  public ExprIterator begin_outputs() {
    return new ExprIterator(Exprs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::end_outputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1541,
   FQN="clang::AsmStmt::end_outputs", NM="_ZN5clang7AsmStmt11end_outputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt11end_outputsEv")
  //</editor-fold>
  public ExprIterator end_outputs() {
    return new ExprIterator(Exprs.$add(NumOutputs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::outputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1544,
   FQN="clang::AsmStmt::outputs", NM="_ZN5clang7AsmStmt7outputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt7outputsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > outputs() {
    return new iterator_range<Expr /*P*/ >(begin_outputs(), end_outputs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::begin_outputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1548,
   FQN="clang::AsmStmt::begin_outputs", NM="_ZNK5clang7AsmStmt13begin_outputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt13begin_outputsEv")
  //</editor-fold>
  public ConstExprIterator begin_outputs$Const() /*const*/ {
    return new ConstExprIterator(Exprs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::end_outputs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1551,
   FQN="clang::AsmStmt::end_outputs", NM="_ZNK5clang7AsmStmt11end_outputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt11end_outputsEv")
  //</editor-fold>
  public ConstExprIterator end_outputs$Const() /*const*/ {
    return new ConstExprIterator(Exprs.$add(NumOutputs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::outputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1554,
   FQN="clang::AsmStmt::outputs", NM="_ZNK5clang7AsmStmt7outputsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang7AsmStmt7outputsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> outputs$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(begin_outputs$Const(), end_outputs$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AsmStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1558,
   FQN="clang::AsmStmt::children", NM="_ZN5clang7AsmStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang7AsmStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Exprs), new StmtIterator(Exprs.$add(NumOutputs).$add(NumInputs)));
  }

  
  @Override public String toString() {
    return "" + "AsmLoc=" + AsmLoc // NOI18N
              + ", IsSimple=" + IsSimple // NOI18N
              + ", IsVolatile=" + IsVolatile // NOI18N
              + ", NumOutputs=" + NumOutputs // NOI18N
              + ", NumInputs=" + NumInputs // NOI18N
              + ", NumClobbers=" + NumClobbers // NOI18N
              + ", Exprs=" + Exprs // NOI18N
              + super.toString(); // NOI18N
  }
}
