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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.*;


/// This represents a GCC inline-assembly statement extension.
///
//<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1565,
 FQN="clang::GCCAsmStmt", NM="_ZN5clang10GCCAsmStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmtE")
//</editor-fold>
public class GCCAsmStmt extends /*public*/ AsmStmt {
  private SourceLocation RParenLoc;
  private StringLiteral /*P*/ AsmStr;
  
  // FIXME: If we wanted to, we could allocate all of these in one big array.
  private type$ptr<StringLiteral /*P*/ /*P*/> Constraints;
  private type$ptr<StringLiteral /*P*/ /*P*/> Clobbers;
  private type$ptr<IdentifierInfo /*P*/ /*P*/> Names;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // Constructors
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::GCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 691,
   FQN="clang::GCCAsmStmt::GCCAsmStmt", NM="_ZN5clang10GCCAsmStmtC1ERKNS_10ASTContextENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEPPNS_13StringLiteralEPPNS_4ExprES9_jSA_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmtC1ERKNS_10ASTContextENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEPPNS_13StringLiteralEPPNS_4ExprES9_jSA_S4_")
  //</editor-fold>
  public GCCAsmStmt(final /*const*/ ASTContext /*&*/ C, SourceLocation asmloc, 
      boolean issimple, boolean isvolatile, /*uint*/int numoutputs, 
      /*uint*/int numinputs, type$ptr<IdentifierInfo /*P*/ /*P*/> names, 
      type$ptr<StringLiteral /*P*/ /*P*/> constraints, type$ptr<Expr /*P*/ /*P*/> exprs, 
      StringLiteral /*P*/ asmstr, /*uint*/int numclobbers, 
      type$ptr<StringLiteral /*P*/ /*P*/> clobbers, SourceLocation rparenloc) {
    // : AsmStmt(GCCAsmStmtClass, asmloc, issimple, isvolatile, numoutputs, numinputs, numclobbers), RParenLoc(rparenloc), AsmStr(asmstr) 
    //START JInit
    super(StmtClass.GCCAsmStmtClass, new SourceLocation(asmloc), issimple, isvolatile, numoutputs, 
        numinputs, numclobbers);
    this.RParenLoc = new SourceLocation(rparenloc);
    this.AsmStr = asmstr;
    //END JInit
    
    /*uint*/int NumExprs = NumOutputs + NumInputs;
    
    Names = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new IdentifierInfo /*P*/ [NumExprs]);
    std.copy(names, names.$add(NumExprs), Names);
    
    Exprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [NumExprs]);
    std.copy(exprs, exprs.$add(NumExprs), Exprs);
    
    Constraints = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new StringLiteral /*P*/ [NumExprs]);
    std.copy(constraints, constraints.$add(NumExprs), Constraints);
    
    Clobbers = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new StringLiteral /*P*/ [NumClobbers]);
    std.copy(clobbers, clobbers.$add(NumClobbers), Clobbers);
  }

  
  /// \brief Build an empty inline-assembly statement.
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::GCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1584,
   FQN="clang::GCCAsmStmt::GCCAsmStmt", NM="_ZN5clang10GCCAsmStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ GCCAsmStmt(EmptyShell Empty) {
    // : AsmStmt(GCCAsmStmtClass, Empty), RParenLoc(), Constraints(null), Clobbers(null), Names(null) 
    //START JInit
    super(StmtClass.GCCAsmStmtClass, new EmptyShell(Empty));
    this.RParenLoc = new SourceLocation();
    this.Constraints = null;
    this.Clobbers = null;
    this.Names = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1587,
   FQN="clang::GCCAsmStmt::getRParenLoc", NM="_ZNK5clang10GCCAsmStmt12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1588,
   FQN="clang::GCCAsmStmt::setRParenLoc", NM="_ZN5clang10GCCAsmStmt12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //===--- Asm String Analysis ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1592,
   FQN="clang::GCCAsmStmt::getAsmString", NM="_ZNK5clang10GCCAsmStmt12getAsmStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt12getAsmStringEv")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getAsmString$Const() /*const*/ {
    return AsmStr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1593,
   FQN="clang::GCCAsmStmt::getAsmString", NM="_ZN5clang10GCCAsmStmt12getAsmStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt12getAsmStringEv")
  //</editor-fold>
  public StringLiteral /*P*/ getAsmString() {
    return AsmStr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::setAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1594,
   FQN="clang::GCCAsmStmt::setAsmString", NM="_ZN5clang10GCCAsmStmt12setAsmStringEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt12setAsmStringEPNS_13StringLiteralE")
  //</editor-fold>
  public void setAsmString(StringLiteral /*P*/ E) {
    AsmStr = E;
  }

  
  /// AsmStringPiece - this is part of a decomposed asm string specification
  /// (for use with the AnalyzeAsmString function below).  An asm string is
  /// considered to be a concatenation of these parts.
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1599,
   FQN="clang::GCCAsmStmt::AsmStringPiece", NM="_ZN5clang10GCCAsmStmt14AsmStringPieceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt14AsmStringPieceE")
  //</editor-fold>
  public static class AsmStringPiece implements Destructors.ClassWithDestructor, NativeCloneable<AsmStringPiece> {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::Kind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1601,
     FQN="clang::GCCAsmStmt::AsmStringPiece::Kind", NM="_ZN5clang10GCCAsmStmt14AsmStringPiece4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt14AsmStringPiece4KindE")
    //</editor-fold>
    public enum Kind implements Native.ComparableLower {
      String(0), // String in .ll asm string form, "$" -> "$$" and "%%" -> "%".
      Operand(String.getValue() + 1); // Operand reference, with optional modifier %c4.

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Kind valueOf(int val) {
        Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Kind[] VALUES;
        private static final Kind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Kind kind : Kind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Kind[min < 0 ? (1-min) : 0];
          VALUES = new Kind[max >= 0 ? (1+max) : 0];
          for (Kind kind : Kind.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private Kind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
      //</editor-fold>
    };
  /*private:*/
    private Kind MyKind;
    private std.string Str;
    private /*uint*/int OperandNo;
    
    // Source range for operand references.
    private CharSourceRange Range;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::AsmStringPiece">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1613,
     FQN="clang::GCCAsmStmt::AsmStringPiece::AsmStringPiece", NM="_ZN5clang10GCCAsmStmt14AsmStringPieceC1ERKSs",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt14AsmStringPieceC1ERKSs")
    //</editor-fold>
    public AsmStringPiece(final /*const*/std.string/*&*/ S) {
      // : MyKind(String), Str(S), Range() 
      //START JInit
      this.MyKind = Kind.String;
      this.Str = new std.string(S);
      this.Range = new CharSourceRange();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::AsmStringPiece">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1614,
     FQN="clang::GCCAsmStmt::AsmStringPiece::AsmStringPiece", NM="_ZN5clang10GCCAsmStmt14AsmStringPieceC1EjRKSsNS_14SourceLocationES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt14AsmStringPieceC1EjRKSsNS_14SourceLocationES4_")
    //</editor-fold>
    public AsmStringPiece(/*uint*/int OpNo, final /*const*/std.string/*&*/ S, SourceLocation Begin, 
        SourceLocation End) {
      // : MyKind(Operand), Str(S), OperandNo(OpNo), Range(CharSourceRange::getCharRange(Begin, End)) 
      //START JInit
      this.MyKind = Kind.Operand;
      this.Str = new std.string(S);
      this.OperandNo = OpNo;
      this.Range = CharSourceRange.getCharRange(/*NO_COPY*/Begin, /*NO_COPY*/End);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::isString">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1620,
     FQN="clang::GCCAsmStmt::AsmStringPiece::isString", NM="_ZNK5clang10GCCAsmStmt14AsmStringPiece8isStringEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt14AsmStringPiece8isStringEv")
    //</editor-fold>
    public boolean isString() /*const*/ {
      return MyKind == Kind.String;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::isOperand">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1621,
     FQN="clang::GCCAsmStmt::AsmStringPiece::isOperand", NM="_ZNK5clang10GCCAsmStmt14AsmStringPiece9isOperandEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt14AsmStringPiece9isOperandEv")
    //</editor-fold>
    public boolean isOperand() /*const*/ {
      return MyKind == Kind.Operand;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::getString">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1623,
     FQN="clang::GCCAsmStmt::AsmStringPiece::getString", NM="_ZNK5clang10GCCAsmStmt14AsmStringPiece9getStringEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt14AsmStringPiece9getStringEv")
    //</editor-fold>
    public /*const*/std.string/*&*/ getString() /*const*/ {
      return Str;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::getOperandNo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1627,
     FQN="clang::GCCAsmStmt::AsmStringPiece::getOperandNo", NM="_ZNK5clang10GCCAsmStmt14AsmStringPiece12getOperandNoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt14AsmStringPiece12getOperandNoEv")
    //</editor-fold>
    public /*uint*/int getOperandNo() /*const*/ {
      assert (isOperand());
      return OperandNo;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::getRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1632,
     FQN="clang::GCCAsmStmt::AsmStringPiece::getRange", NM="_ZNK5clang10GCCAsmStmt14AsmStringPiece8getRangeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt14AsmStringPiece8getRangeEv")
    //</editor-fold>
    public CharSourceRange getRange() /*const*/ {
      assert (isOperand()) : "Range is currently used only for Operands.";
      return new CharSourceRange(Range);
    }

    
    /// getModifier - Get the modifier for this operand, if present.  This
    /// returns '\0' if there was no modifier.
    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::getModifier">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 388,
     FQN="clang::GCCAsmStmt::AsmStringPiece::getModifier", NM="_ZNK5clang10GCCAsmStmt14AsmStringPiece11getModifierEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt14AsmStringPiece11getModifierEv")
    //</editor-fold>
    public /*char*/byte getModifier() /*const*/ {
      assert (isOperand()) : "Only Operands can have modifiers.";
      return isLetter(Str.$at$Const(0)) ? Str.$at$Const(0) : $$TERM;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::AsmStringPiece">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1599,
     FQN="clang::GCCAsmStmt::AsmStringPiece::AsmStringPiece", NM="_ZN5clang10GCCAsmStmt14AsmStringPieceC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt14AsmStringPieceC1EOS1_")
    //</editor-fold>
    public /*inline*/ AsmStringPiece(JD$Move _dparam, final AsmStringPiece /*&&*/$Prm0) {
      // : MyKind(static_cast<AsmStringPiece &&>().MyKind), Str(static_cast<AsmStringPiece &&>().Str), OperandNo(static_cast<AsmStringPiece &&>().OperandNo), Range(static_cast<AsmStringPiece &&>().Range) 
      //START JInit
      this.MyKind = $Prm0.MyKind;
      this.Str = new std.string(JD$Move.INSTANCE, $Prm0.Str);
      this.OperandNo = $Prm0.OperandNo;
      this.Range = new CharSourceRange(JD$Move.INSTANCE, $Prm0.Range);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AsmStringPiece::~AsmStringPiece">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1599,
     FQN="clang::GCCAsmStmt::AsmStringPiece::~AsmStringPiece", NM="_ZN5clang10GCCAsmStmt14AsmStringPieceD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt14AsmStringPieceD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Str.$destroy();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public AsmStringPiece() {
      this.MyKind = Kind.valueOf(0);
      this.Str = std.string.EMPTY;
      this.OperandNo = 0;
      this.Range = new CharSourceRange();
    }

    private AsmStringPiece(AsmStringPiece $Prm0) {
      // : MyKind(static_cast<AsmStringPiece &&>().MyKind), Str(static_cast<AsmStringPiece &&>().Str), OperandNo(static_cast<AsmStringPiece &&>().OperandNo), Range(static_cast<AsmStringPiece &&>().Range) 
      //START JInit
      this.MyKind = $Prm0.MyKind;
      this.Str = new std.string($Prm0.Str);
      this.OperandNo = $Prm0.OperandNo;
      this.Range = new CharSourceRange($Prm0.Range);
      //END JInit      
    }
    
    @Override public AsmStringPiece clone() {
      return new AsmStringPiece(this);
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "MyKind=" + MyKind // NOI18N
                + ", Str=" + Str // NOI18N
                + ", OperandNo=" + OperandNo // NOI18N
                + ", Range=" + Range; // NOI18N
    }
  };
  
  /// AnalyzeAsmString - Analyze the asm string of the current asm, decomposing
  /// it into pieces.  If the asm string is erroneous, emit errors and return
  /// true, otherwise return false.  This handles canonicalization and
  /// translation of strings from GCC syntax to LLVM IR syntax, and handles
  //// flattening of named references like %[foo] to Operand AsmStringPiece's.
  
  /// AnalyzeAsmString - Analyze the asm string of the current asm, decomposing
  /// it into pieces.  If the asm string is erroneous, emit errors and return
  /// true, otherwise return false.
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::AnalyzeAsmString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 475,
   FQN="clang::GCCAsmStmt::AnalyzeAsmString", NM="_ZNK5clang10GCCAsmStmt16AnalyzeAsmStringERN4llvm15SmallVectorImplINS0_14AsmStringPieceEEERKNS_10ASTContextERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt16AnalyzeAsmStringERN4llvm15SmallVectorImplINS0_14AsmStringPieceEEERKNS_10ASTContextERj")
  //</editor-fold>
  public /*uint*/int AnalyzeAsmString(final SmallVectorImpl<AsmStringPiece> /*&*/ Pieces, 
                  final /*const*/ ASTContext /*&*/ C, final uint$ref/*uint &*/ DiagOffs) /*const*/ {
    StringRef Str = getAsmString$Const().getString();
    /*const*/char$ptr/*char P*/ StrStart = $tryClone(Str.begin());
    /*const*/char$ptr/*char P*/ StrEnd = $tryClone(Str.end());
    /*const*/char$ptr/*char P*/ CurPtr = $tryClone(StrStart);
    
    // "Simple" inline asms have no constraints or operands, just convert the asm
    // string to escape $'s.
    if (isSimple()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        std.string Result/*J*/= new std.string();
        for (; $noteq_ptr(CurPtr, StrEnd); CurPtr.$preInc()) {
          switch (CurPtr.$star()) {
           case '$':
            Result.$addassign_T$C$P(/*KEEP_STR*/"$$");
            break;
           default:
            Result.$addassign_T(CurPtr.$star());
            break;
          }
        }
        Pieces.push_back_T$RR($c$.track(new AsmStringPiece(Result))); $c$.clean();
        return 0;
      } finally {
        $c$.$destroy();
      }
    }
    
    // CurStringPiece - The current string that we are building up as we scan the
    // asm string.
    std.string CurStringPiece/*J*/= new std.string();
    
    boolean HasVariants = !C.getTargetInfo().hasNoAsmVariants();
    
    uint$ptr LastAsmStringToken = create_uint$ptr(0);
    uint$ptr LastAsmStringOffset = create_uint$ptr(0);
    while (true) {
      // Done with the string?
      if ($eq_ptr(CurPtr, StrEnd)) {
        if (!CurStringPiece.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Pieces.push_back_T$RR($c$.track(new AsmStringPiece(CurStringPiece))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
        return 0;
      }
      
      /*char*/byte CurChar = CurPtr.$postInc().$star();
      switch (CurChar) {
       case '$':
        CurStringPiece.$addassign_T$C$P(/*KEEP_STR*/"$$");
        continue;
       case '{':
        CurStringPiece.$addassign_T$C$P((HasVariants ? $("$(") : $LCURLY));
        continue;
       case '|':
        CurStringPiece.$addassign_T$C$P((HasVariants ? $("$|") : $PIPE));
        continue;
       case '}':
        CurStringPiece.$addassign_T$C$P((HasVariants ? $("$)") : $RCURLY));
        continue;
       case '%':
        break;
       default:
        CurStringPiece.$addassign_T(CurChar);
        continue;
      }
      
      // Escaped "%" character in asm string.
      if ($eq_ptr(CurPtr, StrEnd)) {
        // % at end of string is invalid (no escape).
        DiagOffs.$set(CurPtr.$sub(StrStart) - 1);
        return diag.err_asm_invalid_escape;
      }
      
      /*char*/byte EscapedChar = CurPtr.$postInc().$star();
      if (EscapedChar == $$PERCENT) { // %% -> %
// Escaped percentage sign.
        CurStringPiece.$addassign_T($$PERCENT);
        continue;
      }
      if (EscapedChar == $$EQ) { // %= -> Generate an unique ID.
        CurStringPiece.$addassign_T$C$P(/*KEEP_STR*/"${:uid}");
        continue;
      }
      
      // Otherwise, we have an operand.  If we have accumulated a string so far,
      // add it to the Pieces list.
      if (!CurStringPiece.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Pieces.push_back_T$RR($c$.track(new AsmStringPiece(CurStringPiece))); $c$.clean();
          CurStringPiece.clear();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Handle operands that have asmSymbolicName (e.g., %x[foo]) and those that
      // don't (e.g., %x4). 'x' following the '%' is the constraint modifier.
      /*const*/char$ptr/*char P*/ Begin = $tryClone(CurPtr.$sub(1)); // Points to the character following '%'.
      /*const*/char$ptr/*char P*/ Percent = $tryClone(Begin.$sub(1)); // Points to '%'.
      if (isLetter(EscapedChar)) {
        if ($eq_ptr(CurPtr, StrEnd)) { // Premature end.
          DiagOffs.$set(CurPtr.$sub(StrStart) - 1);
          return diag.err_asm_invalid_escape;
        }
        EscapedChar = CurPtr.$postInc().$star();
      }
      
      final /*const*/ TargetInfo /*&*/ TI = C.getTargetInfo();
      final /*const*/ SourceManager /*&*/ SM = C.getSourceManager$Const();
      final /*const*/ LangOptions /*&*/ LO = C.getLangOpts();
      
      // Handle operands that don't have asmSymbolicName (e.g., %x4).
      if (isDigit(EscapedChar)) {
        // %n - Assembler operand n
        /*uint*/int N = 0;
        
        CurPtr.$preDec();
        while ($noteq_ptr(CurPtr, StrEnd) && isDigit(CurPtr.$star())) {
          N = N * 10 + ((CurPtr.$postInc().$star()) - $$0);
        }
        
        /*uint*/int NumOperands = getNumOutputs() + getNumPlusOperands() + getNumInputs();
        if ($greatereq_uint(N, NumOperands)) {
          DiagOffs.$set(CurPtr.$sub(StrStart) - 1);
          return diag.err_asm_invalid_operand_number;
        }
        
        // Str contains "x4" (Operand without the leading %).
        std.string Str$1/*J*/= new std.string(Begin, CurPtr.$sub(Begin));
        
        // (BeginLoc, EndLoc) represents the range of the operand we are currently
        // processing. Unlike Str, the range includes the leading '%'.
        SourceLocation BeginLoc = getAsmString$Const().getLocationOfByte(Percent.$sub(StrStart), SM, LO, TI, $AddrOf(LastAsmStringToken), 
            $AddrOf(LastAsmStringOffset));
        SourceLocation EndLoc = getAsmString$Const().getLocationOfByte(CurPtr.$sub(StrStart), SM, LO, TI, $AddrOf(LastAsmStringToken), 
            $AddrOf(LastAsmStringOffset));
        
        Pieces./*emplace_back*/push_back_T$RR(new AsmStringPiece(N, std.move(Str$1), BeginLoc, EndLoc));
        continue;
      }
      
      // Handle operands that have asmSymbolicName (e.g., %x[foo]).
      if (EscapedChar == $$LSQUARE) {
        DiagOffs.$set(CurPtr.$sub(StrStart) - 1);
        
        // Find the ']'.
        /*const*/char$ptr/*char P*/ NameEnd = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, memchr(CurPtr, $$RSQUARE, StrEnd.$sub(CurPtr))));
        if ($eq_ptr(NameEnd, null)) {
          return diag.err_asm_unterminated_symbolic_operand_name;
        }
        if ($eq_ptr(NameEnd, CurPtr)) {
          return diag.err_asm_empty_symbolic_operand_name;
        }
        
        StringRef SymbolicName/*J*/= new StringRef(CurPtr, NameEnd.$sub(CurPtr));
        
        int N = getNamedOperand(new StringRef(SymbolicName));
        if (N == -1) {
          // Verify that an operand with that name exists.
          DiagOffs.$set(CurPtr.$sub(StrStart));
          return diag.err_asm_unknown_symbolic_operand_name;
        }
        
        // Str contains "x[foo]" (Operand without the leading %).
        std.string Str$1/*J*/= new std.string(Begin, NameEnd.$add(1).$sub(Begin));
        
        // (BeginLoc, EndLoc) represents the range of the operand we are currently
        // processing. Unlike Str, the range includes the leading '%'.
        SourceLocation BeginLoc = getAsmString$Const().getLocationOfByte(Percent.$sub(StrStart), SM, LO, TI, $AddrOf(LastAsmStringToken), 
            $AddrOf(LastAsmStringOffset));
        SourceLocation EndLoc = getAsmString$Const().getLocationOfByte(NameEnd.$add(1).$sub(StrStart), SM, LO, TI, $AddrOf(LastAsmStringToken), 
            $AddrOf(LastAsmStringOffset));
        
        Pieces./*emplace_back*/push_back_T$RR(new AsmStringPiece(N, std.move(Str$1), BeginLoc, EndLoc));
        
        CurPtr = $tryClone(NameEnd.$add(1));
        continue;
      }
      
      DiagOffs.$set(CurPtr.$sub(StrStart) - 1);
      return diag.err_asm_invalid_escape;
    }
  }

  
  /// Assemble final IR asm string.
  
  /// Assemble final IR asm string (GCC-style).
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::generateAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 650,
   FQN="clang::GCCAsmStmt::generateAsmString", NM="_ZNK5clang10GCCAsmStmt17generateAsmStringERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt17generateAsmStringERKNS_10ASTContextE")
  //</editor-fold>
  public std.string generateAsmString(final /*const*/ ASTContext /*&*/ C) /*const*/ {
    SmallVector<GCCAsmStmt.AsmStringPiece> Pieces = null;
    try {
      // Analyze the asm string to decompose it into its pieces.  We know that Sema
      // has already done this, so it is guaranteed to be successful.
      Pieces/*J*/= new SmallVector<GCCAsmStmt.AsmStringPiece>(4, new GCCAsmStmt.AsmStringPiece());
      uint$ref DiagOffs = create_uint$ref();
      AnalyzeAsmString(Pieces, C, DiagOffs);
      
      std.string AsmString/*J*/= new std.string();
      for (/*uint*/int i = 0, e = Pieces.size(); i != e; ++i) {
        if (Pieces.$at(i).isString()) {
          AsmString.$addassign(Pieces.$at(i).getString());
        } else if (Pieces.$at(i).getModifier() == $$TERM) {
          AsmString.$addassign($add_T_string($$DOLLAR, llvm.utostr($uint2ulong(Pieces.$at(i).getOperandNo()))));
        } else {
          AsmString.$addassign($add_string_T($add_string_T($add_string_T($add_T$C$P_string(/*KEEP_STR*/"${", llvm.utostr($uint2ulong(Pieces.$at(i).getOperandNo()))), $$COLON), 
                      Pieces.$at(i).getModifier()), $$RCURLY));
        }
      }
      return AsmString;
    } finally {
      if (Pieces != null) { Pieces.$destroy(); }
    }
  }

  
  //===--- Output operands ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1655,
   FQN="clang::GCCAsmStmt::getOutputIdentifier", NM="_ZNK5clang10GCCAsmStmt19getOutputIdentifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt19getOutputIdentifierEj")
  //</editor-fold>
  public IdentifierInfo /*P*/ getOutputIdentifier(/*uint*/int i) /*const*/ {
    return Names.$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1659,
   FQN="clang::GCCAsmStmt::getOutputName", NM="_ZNK5clang10GCCAsmStmt13getOutputNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt13getOutputNameEj")
  //</editor-fold>
  public StringRef getOutputName(/*uint*/int i) /*const*/ {
    {
      IdentifierInfo /*P*/ II = getOutputIdentifier(i);
      if ((II != null)) {
        return II.getName();
      }
    }
    
    return new StringRef();
  }

  
  
  /// getOutputConstraint - Return the constraint string for the specified
  /// output operand.  All output constraints are known to be non-empty (either
  /// '=' or '+').
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 404,
   FQN="clang::GCCAsmStmt::getOutputConstraint", NM="_ZNK5clang10GCCAsmStmt19getOutputConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt19getOutputConstraintEj")
  //</editor-fold>
  public StringRef getOutputConstraint(/*uint*/int i) /*const*/ {
    return getOutputConstraintLiteral$Const(i).getString();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputConstraintLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1668,
   FQN="clang::GCCAsmStmt::getOutputConstraintLiteral", NM="_ZNK5clang10GCCAsmStmt26getOutputConstraintLiteralEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt26getOutputConstraintLiteralEj")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getOutputConstraintLiteral$Const(/*uint*/int i) /*const*/ {
    return Constraints.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputConstraintLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1671,
   FQN="clang::GCCAsmStmt::getOutputConstraintLiteral", NM="_ZN5clang10GCCAsmStmt26getOutputConstraintLiteralEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt26getOutputConstraintLiteralEj")
  //</editor-fold>
  public StringLiteral /*P*/ getOutputConstraintLiteral(/*uint*/int i) {
    return Constraints.$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 397,
   FQN="clang::GCCAsmStmt::getOutputExpr", NM="_ZN5clang10GCCAsmStmt13getOutputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt13getOutputExprEj")
  //</editor-fold>
  public Expr /*P*/ getOutputExpr(/*uint*/int i) {
    return cast_Expr(Exprs.$at(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getOutputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1677,
   FQN="clang::GCCAsmStmt::getOutputExpr", NM="_ZNK5clang10GCCAsmStmt13getOutputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt13getOutputExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getOutputExpr$Const(/*uint*/int i) /*const*/ {
    return ((/*const_cast*/GCCAsmStmt /*P*/ )(this)).getOutputExpr(i);
  }

  
  //===--- Input operands ---===//
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1683,
   FQN="clang::GCCAsmStmt::getInputIdentifier", NM="_ZNK5clang10GCCAsmStmt18getInputIdentifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt18getInputIdentifierEj")
  //</editor-fold>
  public IdentifierInfo /*P*/ getInputIdentifier(/*uint*/int i) /*const*/ {
    return Names.$at(i + NumOutputs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1687,
   FQN="clang::GCCAsmStmt::getInputName", NM="_ZNK5clang10GCCAsmStmt12getInputNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt12getInputNameEj")
  //</editor-fold>
  public StringRef getInputName(/*uint*/int i) /*const*/ {
    {
      IdentifierInfo /*P*/ II = getInputIdentifier(i);
      if ((II != null)) {
        return II.getName();
      }
    }
    
    return new StringRef();
  }

  
  
  /// getInputConstraint - Return the specified input constraint.  Unlike output
  /// constraints, these can be empty.
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 417,
   FQN="clang::GCCAsmStmt::getInputConstraint", NM="_ZNK5clang10GCCAsmStmt18getInputConstraintEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt18getInputConstraintEj")
  //</editor-fold>
  public StringRef getInputConstraint(/*uint*/int i) /*const*/ {
    return getInputConstraintLiteral$Const(i).getString();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputConstraintLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1696,
   FQN="clang::GCCAsmStmt::getInputConstraintLiteral", NM="_ZNK5clang10GCCAsmStmt25getInputConstraintLiteralEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt25getInputConstraintLiteralEj")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getInputConstraintLiteral$Const(/*uint*/int i) /*const*/ {
    return Constraints.$at(i + NumOutputs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputConstraintLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1699,
   FQN="clang::GCCAsmStmt::getInputConstraintLiteral", NM="_ZN5clang10GCCAsmStmt25getInputConstraintLiteralEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt25getInputConstraintLiteralEj")
  //</editor-fold>
  public StringLiteral /*P*/ getInputConstraintLiteral(/*uint*/int i) {
    return Constraints.$at(i + NumOutputs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 408,
   FQN="clang::GCCAsmStmt::getInputExpr", NM="_ZN5clang10GCCAsmStmt12getInputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt12getInputExprEj")
  //</editor-fold>
  public Expr /*P*/ getInputExpr(/*uint*/int i) {
    return cast_Expr(Exprs.$at(i + NumOutputs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::setInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 411,
   FQN="clang::GCCAsmStmt::setInputExpr", NM="_ZN5clang10GCCAsmStmt12setInputExprEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt12setInputExprEjPNS_4ExprE")
  //</editor-fold>
  public void setInputExpr(/*uint*/int i, Expr /*P*/ E) {
    Exprs.$set(i + NumOutputs, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getInputExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1706,
   FQN="clang::GCCAsmStmt::getInputExpr", NM="_ZNK5clang10GCCAsmStmt12getInputExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt12getInputExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getInputExpr$Const(/*uint*/int i) /*const*/ {
    return ((/*const_cast*/GCCAsmStmt /*P*/ )(this)).getInputExpr(i);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::setOutputsAndInputsAndClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 421,
   FQN="clang::GCCAsmStmt::setOutputsAndInputsAndClobbers", NM="_ZN5clang10GCCAsmStmt30setOutputsAndInputsAndClobbersERKNS_10ASTContextEPPNS_14IdentifierInfoEPPNS_13StringLiteralEPPNS_4StmtEjjS9_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt30setOutputsAndInputsAndClobbersERKNS_10ASTContextEPPNS_14IdentifierInfoEPPNS_13StringLiteralEPPNS_4StmtEjjS9_j")
  //</editor-fold>
  /*friend*/public void setOutputsAndInputsAndClobbers(final /*const*/ ASTContext /*&*/ C, 
                                type$ptr<IdentifierInfo /*P*/ /*P*/> Names, 
                                type$ptr<StringLiteral /*P*/ /*P*/> Constraints, 
                                type$ptr<Stmt /*P*/ /*P*/> Exprs, 
                                /*uint*/int NumOutputs, 
                                /*uint*/int NumInputs, 
                                type$ptr<StringLiteral /*P*/ /*P*/> Clobbers, 
                                /*uint*/int NumClobbers) {
    this.NumOutputs = NumOutputs;
    this.NumInputs = NumInputs;
    this.NumClobbers = NumClobbers;
    
    /*uint*/int NumExprs = NumOutputs + NumInputs;
    
    C.Deallocate(this.Names);
    this.Names = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new IdentifierInfo /*P*/ [NumExprs]);
    std.copy(Names, Names.$add(NumExprs), this.Names);
    
    C.Deallocate(this.Exprs);
    this.Exprs = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [NumExprs]);
    std.copy(Exprs, Exprs.$add(NumExprs), this.Exprs);
    
    C.Deallocate(this.Constraints);
    this.Constraints = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new StringLiteral /*P*/ [NumExprs]);
    std.copy(Constraints, Constraints.$add(NumExprs), this.Constraints);
    
    C.Deallocate(this.Clobbers);
    this.Clobbers = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new StringLiteral /*P*/ [NumClobbers]);
    std.copy(Clobbers, Clobbers.$add(NumClobbers), this.Clobbers);
  }

/*public:*/
  
  //===--- Other ---===//
  
  /// getNamedOperand - Given a symbolic operand reference like %[foo],
  /// translate this into a numeric value needed to reference the same operand.
  /// This returns -1 if the operand name is invalid.
  
  /// getNamedOperand - Given a symbolic operand reference like %[foo],
  /// translate this into a numeric value needed to reference the same operand.
  /// This returns -1 if the operand name is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getNamedOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 455,
   FQN="clang::GCCAsmStmt::getNamedOperand", NM="_ZNK5clang10GCCAsmStmt15getNamedOperandEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt15getNamedOperandEN4llvm9StringRefE")
  //</editor-fold>
  public int getNamedOperand(StringRef SymbolicName) /*const*/ {
    /*uint*/int NumPlusOperands = 0;
    
    // Check if this is an output operand.
    for (/*uint*/int i = 0, e = getNumOutputs(); i != e; ++i) {
      if ($eq_StringRef(getOutputName(i), /*NO_COPY*/SymbolicName)) {
        return i;
      }
    }
    
    for (/*uint*/int i = 0, e = getNumInputs(); i != e; ++i)  {
      if ($eq_StringRef(getInputName(i), /*NO_COPY*/SymbolicName)) {
        return getNumOutputs() + NumPlusOperands + i;
      }
    }
    
    // Not found.
    return -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getClobber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 393,
   FQN="clang::GCCAsmStmt::getClobber", NM="_ZNK5clang10GCCAsmStmt10getClobberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt10getClobberEj")
  //</editor-fold>
  public StringRef getClobber(/*uint*/int i) /*const*/ {
    return getClobberStringLiteral$Const(i).getString();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getClobberStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1729,
   FQN="clang::GCCAsmStmt::getClobberStringLiteral", NM="_ZN5clang10GCCAsmStmt23getClobberStringLiteralEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt23getClobberStringLiteralEj")
  //</editor-fold>
  public StringLiteral /*P*/ getClobberStringLiteral(/*uint*/int i) {
    return Clobbers.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getClobberStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1730,
   FQN="clang::GCCAsmStmt::getClobberStringLiteral", NM="_ZNK5clang10GCCAsmStmt23getClobberStringLiteralEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt23getClobberStringLiteralEj")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getClobberStringLiteral$Const(/*uint*/int i) /*const*/ {
    return Clobbers.$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1734,
   FQN="clang::GCCAsmStmt::getLocStart", NM="_ZNK5clang10GCCAsmStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AsmLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1735,
   FQN="clang::GCCAsmStmt::getLocEnd", NM="_ZNK5clang10GCCAsmStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang10GCCAsmStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GCCAsmStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 1737,
   FQN="clang::GCCAsmStmt::classof", NM="_ZN5clang10GCCAsmStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang10GCCAsmStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.GCCAsmStmtClass;
  }

  
  @Override public String toString() {
    return "" + "RParenLoc=" + RParenLoc // NOI18N
              + ", AsmStr=" + AsmStr // NOI18N
              + ", Constraints=" + Constraints // NOI18N
              + ", Clobbers=" + Clobbers // NOI18N
              + ", Names=" + Names // NOI18N
              + super.toString(); // NOI18N
  }
}
