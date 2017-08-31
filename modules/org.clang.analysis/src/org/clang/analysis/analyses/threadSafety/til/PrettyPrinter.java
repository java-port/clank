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

package org.clang.analysis.analyses.threadSafety.til;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import static org.clang.analysis.analyses.threadSafety.ThreadSafetyGlobals.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import static org.clang.analysis.analyses.threadSafety.til.TilGlobals.*;
import org.llvm.adt.StringRef;


// inline std::ostream& operator<<(std::ostream& SS, StringRef R) {
//   return SS.write(R.data(), R.size());
// }

// Pretty printer for TIL expressions
/*template <typename Self, typename StreamType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 383,
 FQN="clang::threadSafety::til::PrettyPrinter", NM="_ZN5clang12threadSafety3til13PrettyPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinterE")
//</editor-fold>
public class PrettyPrinter</*typename*/ Self extends PrettyPrinter, /*typename*/ StreamType extends basic_ostream>  {
/*private:*/
  private boolean Verbose; // Print out additional information
  private boolean Cleanup; // Omit redundant decls.
  private boolean CStyle; // Print exprs in C-like syntax.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::PrettyPrinter<Self, StreamType>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 391,
   FQN="clang::threadSafety::til::PrettyPrinter::PrettyPrinter<Self, StreamType>", NM="_ZN5clang12threadSafety3til13PrettyPrinterC1Ebbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinterC1Ebbb")
  //</editor-fold>
  public PrettyPrinter() {
    this(false, true, true);
  }
  public PrettyPrinter(boolean V/*= false*/) {
    this(V, true, true);
  }
  public PrettyPrinter(boolean V/*= false*/, boolean C/*= true*/) {
    this(V, C, true);
  }
  public PrettyPrinter(boolean V/*= false*/, boolean C/*= true*/, boolean CS/*= true*/) {
    // : Verbose(V), Cleanup(C), CStyle(CS) 
    //START JInit
    this.Verbose = V;
    this.Cleanup = C;
    this.CStyle = CS;
    //END JInit
  }

  
//  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::print">
//  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 395,
//   FQN="clang::threadSafety::til::PrettyPrinter::print", NM="_ZN5clang12threadSafety3til13PrettyPrinter5printEPKNS1_5SExprERT0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter5printEPKNS1_5SExprERT0_")
//  //</editor-fold>
//  public static </*typename*/ Self extends PrettyPrinter, /*typename*/ StreamType extends basic_ostream> void print(/*const*/ SExpr /*P*/ E, final StreamType /*&*/ SS) {
//    //basic_ostream/*<char>*/ x;
//    //raw_ostream y;
//    Self printer;
//    printer.printSExpr(E, SS, Prec_MAX);
//  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::self">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 401,
   FQN="clang::threadSafety::til::PrettyPrinter::self", NM="_ZN5clang12threadSafety3til13PrettyPrinter4selfEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter4selfEv")
  //</editor-fold>
  protected Self /*P*/ self() {
    return (Self) this;//reinterpret_cast(Self /*P*/ .class, this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::newline">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 403,
   FQN="clang::threadSafety::til::PrettyPrinter::newline", NM="_ZN5clang12threadSafety3til13PrettyPrinter7newlineERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter7newlineERT0_")
  //</editor-fold>
  protected void newline(final StreamType /*&*/ SS) {
    SS.$out($LF);
  }

  
  // TODO: further distinguish between binary operations.
  protected static /*const*//*uint*/int Prec_Atom = 0;
  protected static /*const*//*uint*/int Prec_Postfix = 1;
  protected static /*const*//*uint*/int Prec_Unary = 2;
  protected static /*const*//*uint*/int Prec_Binary = 3;
  protected static /*const*//*uint*/int Prec_Other = 4;
  protected static /*const*//*uint*/int Prec_Decl = 5;
  protected static /*const*//*uint*/int Prec_MAX = 6;
  
  // Return the precedence of a given node, for use in pretty printing.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::precedence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 417,
   FQN="clang::threadSafety::til::PrettyPrinter::precedence", NM="_ZN5clang12threadSafety3til13PrettyPrinter10precedenceEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter10precedenceEPKNS1_5SExprE")
  //</editor-fold>
  protected /*uint*/int precedence(/*const*/ SExpr /*P*/ E) {
    switch (E.opcode()) {
     case COP_Future:
      return Prec_Atom;
     case COP_Undefined:
      return Prec_Atom;
     case COP_Wildcard:
      return Prec_Atom;
     case COP_Literal:
      return Prec_Atom;
     case COP_LiteralPtr:
      return Prec_Atom;
     case COP_Variable:
      return Prec_Atom;
     case COP_Function:
      return Prec_Decl;
     case COP_SFunction:
      return Prec_Decl;
     case COP_Code:
      return Prec_Decl;
     case COP_Field:
      return Prec_Decl;
     case COP_Apply:
      return Prec_Postfix;
     case COP_SApply:
      return Prec_Postfix;
     case COP_Project:
      return Prec_Postfix;
     case COP_Call:
      return Prec_Postfix;
     case COP_Alloc:
      return Prec_Other;
     case COP_Load:
      return Prec_Postfix;
     case COP_Store:
      return Prec_Other;
     case COP_ArrayIndex:
      return Prec_Postfix;
     case COP_ArrayAdd:
      return Prec_Postfix;
     case COP_UnaryOp:
      return Prec_Unary;
     case COP_BinaryOp:
      return Prec_Binary;
     case COP_Cast:
      return Prec_Atom;
     case COP_SCFG:
      return Prec_Decl;
     case COP_BasicBlock:
      return Prec_MAX;
     case COP_Phi:
      return Prec_Atom;
     case COP_Goto:
      return Prec_Atom;
     case COP_Branch:
      return Prec_Atom;
     case COP_Return:
      return Prec_Other;
     case COP_Identifier:
      return Prec_Atom;
     case COP_IfThenElse:
      return Prec_Other;
     case COP_Let:
      return Prec_Decl;
    }
    return Prec_MAX;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printBlockLabel">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 460,
   FQN="clang::threadSafety::til::PrettyPrinter::printBlockLabel", NM="_ZN5clang12threadSafety3til13PrettyPrinter15printBlockLabelERT0_PKNS1_10BasicBlockEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter15printBlockLabelERT0_PKNS1_10BasicBlockEi")
  //</editor-fold>
  protected void printBlockLabel(final StreamType /*&*/ SS, /*const*/ BasicBlock /*P*/ BB, int index) {
    if (!(BB != null)) {
      SS.$out($("BB_null"));
      return;
    }
    SS.$out($("BB_"));
   SS.$out(BB.blockID());
    if (index >= 0) {
      SS.$out($COLON);
      SS.$out(index);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printSExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 474,
   FQN="clang::threadSafety::til::PrettyPrinter::printSExpr", NM="_ZN5clang12threadSafety3til13PrettyPrinter10printSExprEPKNS1_5SExprERT0_jb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter10printSExprEPKNS1_5SExprERT0_jb")
  //</editor-fold>
  protected void printSExpr(/*const*/ SExpr /*P*/ E, final StreamType /*&*/ SS, /*uint*/int P) {
    //basic_ostream/*<char>*/ x;
    //raw_ostream y;
    printSExpr(E, SS, P, true);
  }
  protected void printSExpr(/*const*/ SExpr /*P*/ E, final StreamType /*&*/ SS, /*uint*/int P, boolean Sub/*= true*/) {
    if (!(E != null)) {
      self().printNull(SS);
      return;
    }
    if (Sub && (E.block() != null) && E.opcode() != TIL_Opcode.COP_Variable) {
      SS.$out($("_x")).$out(E.id());
      return;
    }
    if (Native.$greater(self().precedence(E), P)) {
      // Wrap expr in () if necessary.
      SS.$out($LPAREN);
      self().printSExpr(E, SS, Prec_MAX);
      SS.$out($RPAREN);
      return;
    }
    switch (E.opcode()) {
     case COP_Future:
      //===- ThreadSafetyTIL.h ---------------------------------------*- C++ --*-===//
      //
      //                     The LLVM Compiler Infrastructure
      //
      // This file is distributed under the University of Illinois Open Source
      // License. See LICENSE.TXT for details.
      //
      //===----------------------------------------------------------------------===//
      //
      // This file defines the list of core opcodes for the Thread Safety
      // Typed Intermediate language.  Please see ThreadSafetyTIL.h for more
      // information.
      //
      //===----------------------------------------------------------------------===//
      self().printFuture(cast_Future(E), SS);
      return;
     case COP_Undefined:
      self().printUndefined(cast_Undefined(E), SS);
      return;
     case COP_Wildcard:
      self().printWildcard(cast_Wildcard(E), SS);
      return;
     case COP_Literal:
      self().printLiteral(cast_Literal(E), SS);
      return;
     case COP_LiteralPtr:
      self().printLiteralPtr(cast_LiteralPtr(E), SS);
      return;
     case COP_Variable:
      self().printVariable(cast_Variable(E), SS);
      return;
     case COP_Function:
      self().printFunction(cast_Function(E), SS);
      return;
     case COP_SFunction:
      self().printSFunction(cast_SFunction(E), SS);
      return;
     case COP_Code:
      self().printCode(cast_Code(E), SS);
      return;
     case COP_Field:
      self().printField(cast_Field(E), SS);
      return;
     case COP_Apply:
      self().printApply(cast_Apply(E), SS);
      return;
     case COP_SApply:
      self().printSApply(cast_SApply(E), SS);
      return;
     case COP_Project:
      self().printProject(cast_Project(E), SS);
      return;
     case COP_Call:
      self().printCall(cast_Call(E), SS);
      return;
     case COP_Alloc:
      self().printAlloc(cast_Alloc(E), SS);
      return;
     case COP_Load:
      self().printLoad(cast_Load(E), SS);
      return;
     case COP_Store:
      self().printStore(cast_Store(E), SS);
      return;
     case COP_ArrayIndex:
      self().printArrayIndex(cast_ArrayIndex(E), SS);
      return;
     case COP_ArrayAdd:
      self().printArrayAdd(cast_ArrayAdd(E), SS);
      return;
     case COP_UnaryOp:
      self().printUnaryOp(cast_UnaryOp(E), SS);
      return;
     case COP_BinaryOp:
      self().printBinaryOp(cast_BinaryOp(E), SS);
      return;
     case COP_Cast:
      self().printCast(cast_Cast(E), SS);
      return;
     case COP_SCFG:
      self().printSCFG(cast_SCFG(E), SS);
      return;
     case COP_BasicBlock:
      self().printBasicBlock(cast_BasicBlock(E), SS);
      return;
     case COP_Phi:
      self().printPhi(cast_Phi(E), SS);
      return;
     case COP_Goto:
      
      // Terminator instructions
      self().printGoto(cast_Goto(E), SS);
      return;
     case COP_Branch:
      self().printBranch(cast_Branch(E), SS);
      return;
     case COP_Return:
      self().printReturn(cast_Return(E), SS);
      return;
     case COP_Identifier:
      
      // pseudo-terms
      self().printIdentifier(cast_Identifier(E), SS);
      return;
     case COP_IfThenElse:
      self().printIfThenElse(cast_IfThenElse(E), SS);
      return;
     case COP_Let:
      self().printLet(cast_Let(E), SS);
      return;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 501,
   FQN="clang::threadSafety::til::PrettyPrinter::printNull", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printNullERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printNullERT0_")
  //</editor-fold>
  protected void printNull(final StreamType /*&*/ SS) {
    SS.$out($("#null"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printFuture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 505,
   FQN="clang::threadSafety::til::PrettyPrinter::printFuture", NM="_ZN5clang12threadSafety3til13PrettyPrinter11printFutureEPKNS1_6FutureERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter11printFutureEPKNS1_6FutureERT0_")
  //</editor-fold>
  protected void printFuture(/*const*/ Future /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.maybeGetResult(), SS, Prec_Atom);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printUndefined">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 509,
   FQN="clang::threadSafety::til::PrettyPrinter::printUndefined", NM="_ZN5clang12threadSafety3til13PrettyPrinter14printUndefinedEPKNS1_9UndefinedERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter14printUndefinedEPKNS1_9UndefinedERT0_")
  //</editor-fold>
  protected void printUndefined(/*const*/ Undefined /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("#undefined"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printWildcard">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 513,
   FQN="clang::threadSafety::til::PrettyPrinter::printWildcard", NM="_ZN5clang12threadSafety3til13PrettyPrinter13printWildcardEPKNS1_8WildcardERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter13printWildcardEPKNS1_8WildcardERT0_")
  //</editor-fold>
  protected void printWildcard(/*const*/ Wildcard /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($STAR);
  }

  
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printLiteralT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 518,
   FQN="clang::threadSafety::til::PrettyPrinter::printLiteralT", NM="Tpl__ZN5clang12threadSafety3til13PrettyPrinter13printLiteralTEPKNS1_8LiteralTIT_EERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZN5clang12threadSafety3til13PrettyPrinter13printLiteralTEPKNS1_8LiteralTIT_EERT0_")
  //</editor-fold>
  protected </*class*/ T> void printLiteralT_LiteralT$T$C$P_T1$R(/*const*/ LiteralT<T> /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out(E.value());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printLiteralT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 522,
   FQN="clang::threadSafety::til::PrettyPrinter::printLiteralT", NM="_ZN5clang12threadSafety3til13PrettyPrinter13printLiteralTEPKNS1_8LiteralTIhEERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter13printLiteralTEPKNS1_8LiteralTIhEERT0_")
  //</editor-fold>
  protected void printLiteralT_LiteralTByte$C_T$R(/*const*/LiteralTByte E, StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 526,
   FQN="clang::threadSafety::til::PrettyPrinter::printLiteral", NM="_ZN5clang12threadSafety3til13PrettyPrinter12printLiteralEPKNS1_7LiteralERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter12printLiteralEPKNS1_7LiteralERT0_")
  //</editor-fold>
  protected void printLiteral(/*const*/ Literal /*P*/ E, final StreamType /*&*/ SS) {
    if ((E.clangExpr() != null)) {
      SS.$out_os_str(getSourceLiteralString(E.clangExpr()));
      return;
    } else {
      ValueType VT = E.valueType();
      switch (VT.Base) {
       case BT_Void:
        {
          SS.$out($void);
          return;
        }
       case BT_Bool:
        {
          if (E.as$Const$Bool().value$Const()) {
            SS.$out($true);
          } else {
            SS.$out($false);
          }
          return;
        }
       case BT_Int:
        {
          switch (VT.Size) {
           case ST_8:
            if (VT.Signed) {
              printLiteralT_LiteralTByte($AddrOf(E.as$Const$Byte()), SS);
            } else {
              printLiteralT_LiteralTByte($AddrOf(E.as$Const$Byte()), SS);
            }
            return;
           case ST_16:
            if (VT.Signed) {
              printLiteralT_LiteralTShort($AddrOf(E.as$Const$Short()), SS);
            } else {
              printLiteralT_LiteralTUshort($AddrOf(E.as$Const$Ushort()), SS);
            }
            return;
           case ST_32:
            if (VT.Signed) {
              printLiteralT_LiteralTInt($AddrOf(E.as$Const$Int()), SS);
            } else {
              printLiteralT_LiteralTUint($AddrOf(E.as$Const$Uint()), SS);
            }
            return;
           case ST_64:
            if (VT.Signed) {
              printLiteralT_LiteralTLlong($AddrOf(E.as$Const$Llong()), SS);
            } else {
              printLiteralT_LiteralTUllong($AddrOf(E.as$Const$Ullong()), SS);
            }
            return;
           default:
            break;
          }
          break;
        }
       case BT_Float:
        {
          switch (VT.Size) {
           case ST_32:
            printLiteralT_LiteralTFloat($AddrOf(E.as$Const$Float()), SS);
            return;
           case ST_64:
            printLiteralT_LiteralTDouble($AddrOf(E.as$Const$Double()), SS);
            return;
           default:
            break;
          }
          break;
        }
       case BT_String:
        {
          SS.$out($DBL_QUOTE);
          printLiteralT_LiteralTStringRef($AddrOf(E.as$Const$StringRef()), SS);
          SS.$out($DBL_QUOTE);
          return;
        }
       case BT_Pointer:
        {
          SS.$out($("#ptr"));
          return;
        }
       case BT_ValueRef:
        {
          SS.$out($("#vref"));
          return;
        }
      }
    }
    SS.$out($("#lit"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printLiteralPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 608,
   FQN="clang::threadSafety::til::PrettyPrinter::printLiteralPtr", NM="_ZN5clang12threadSafety3til13PrettyPrinter15printLiteralPtrEPKNS1_10LiteralPtrERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter15printLiteralPtrEPKNS1_10LiteralPtrERT0_")
  //</editor-fold>
  protected void printLiteralPtr(/*const*/ LiteralPtr /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out_os_str(E.clangDecl().getNameAsString());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printVariable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*print as strings*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 612,
   FQN="clang::threadSafety::til::PrettyPrinter::printVariable", NM="_ZN5clang12threadSafety3til13PrettyPrinter13printVariableEPKNS1_8VariableERT0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter13printVariableEPKNS1_8VariableERT0_b")
  //</editor-fold>
  protected void printVariable(/*const*/ Variable /*P*/ V, final StreamType /*&*/ SS) {
    printVariable(V, SS, false);
  }
  protected void printVariable(/*const*/ Variable /*P*/ V, final StreamType /*&*/ SS, boolean IsVarDecl/*= false*/) {
    if (CStyle && V.kind() == Variable.VariableKind.VK_SFun) {
      SS.$out($this);
    } else {
      SS.$out(V.name().data()).$out(V.id());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 619,
   FQN="clang::threadSafety::til::PrettyPrinter::printFunction", NM="_ZN5clang12threadSafety3til13PrettyPrinter13printFunctionEPKNS1_8FunctionERT0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter13printFunctionEPKNS1_8FunctionERT0_j")
  //</editor-fold>
  protected void printFunction(/*const*/ Function /*P*/ E, final StreamType /*&*/ SS) {
    printFunction(E, SS, 0);
  }
  protected void printFunction(/*const*/ Function /*P*/ E, final StreamType /*&*/ SS, /*uint*/int sugared/*= 0*/) {
    switch (sugared) {
     default:
      SS.$out($("\\(")); // Lambda
      break;
     case 1:
      SS.$out($LPAREN); // Slot declarations
      break;
     case 2:
      SS.$out($COMMA_SPACE); // Curried functions
      break;
    }
    self().printVariable(E.variableDecl$Const(), SS, true);
    SS.$out($(": "));
    self().printSExpr(E.variableDecl$Const().definition$Const(), SS, Prec_MAX);
    
    /*const*/ SExpr /*P*/ B = E.body$Const();
    if ((B != null) && B.opcode() == TIL_Opcode.COP_Function) {
      self().printFunction(cast_Function(B), SS, 2);
    } else {
      SS.$out($RPAREN);
      self().printSExpr(B, SS, Prec_Decl);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printSFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 644,
   FQN="clang::threadSafety::til::PrettyPrinter::printSFunction", NM="_ZN5clang12threadSafety3til13PrettyPrinter14printSFunctionEPKNS1_9SFunctionERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter14printSFunctionEPKNS1_9SFunctionERT0_")
  //</editor-fold>
  protected void printSFunction(/*const*/ SFunction /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($AT);
    self().printVariable(E.variableDecl$Const(), SS, true);
    SS.$out($SPACE);
    self().printSExpr(E.body$Const(), SS, Prec_Decl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printCode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 651,
   FQN="clang::threadSafety::til::PrettyPrinter::printCode", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printCodeEPKNS1_4CodeERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printCodeEPKNS1_4CodeERT0_")
  //</editor-fold>
  protected void printCode(/*const*/ Code /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($(": "));
    self().printSExpr(E.returnType$Const(), SS, Prec_Decl - 1);
    SS.$out($(" -> "));
    self().printSExpr(E.body$Const(), SS, Prec_Decl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printField">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 658,
   FQN="clang::threadSafety::til::PrettyPrinter::printField", NM="_ZN5clang12threadSafety3til13PrettyPrinter10printFieldEPKNS1_5FieldERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter10printFieldEPKNS1_5FieldERT0_")
  //</editor-fold>
  protected void printField(/*const*/ Field /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($(": "));
    self().printSExpr(E.range$Const(), SS, Prec_Decl - 1);
    SS.$out($(" = "));
    self().printSExpr(E.body$Const(), SS, Prec_Decl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printApply">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 665,
   FQN="clang::threadSafety::til::PrettyPrinter::printApply", NM="_ZN5clang12threadSafety3til13PrettyPrinter10printApplyEPKNS1_5ApplyERT0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter10printApplyEPKNS1_5ApplyERT0_b")
  //</editor-fold>
  protected void printApply(/*const*/ Apply /*P*/ E, final StreamType /*&*/ SS) {
    printApply(E, SS, false);
  }
  protected void printApply(/*const*/ Apply /*P*/ E, final StreamType /*&*/ SS, boolean sugared/*= false*/) {
    /*const*/ SExpr /*P*/ F = E.fun$Const();
    if (F.opcode() == TIL_Opcode.COP_Apply) {
      printApply(cast_Apply(F), SS, true);
      SS.$out($COMMA_SPACE);
    } else {
      self().printSExpr(F, SS, Prec_Postfix);
      SS.$out($LPAREN);
    }
    self().printSExpr(E.arg$Const(), SS, Prec_MAX);
    if (!sugared) {
      SS.$out($(")$"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printSApply">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 679,
   FQN="clang::threadSafety::til::PrettyPrinter::printSApply", NM="_ZN5clang12threadSafety3til13PrettyPrinter11printSApplyEPKNS1_6SApplyERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter11printSApplyEPKNS1_6SApplyERT0_")
  //</editor-fold>
  protected void printSApply(/*const*/ SApply /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.sfun$Const(), SS, Prec_Postfix);
    if (E.isDelegation()) {
      SS.$out($("@("));
      self().printSExpr(E.arg$Const(), SS, Prec_MAX);
      SS.$out($RPAREN);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printProject">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 688,
   FQN="clang::threadSafety::til::PrettyPrinter::printProject", NM="_ZN5clang12threadSafety3til13PrettyPrinter12printProjectEPKNS1_7ProjectERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter12printProjectEPKNS1_7ProjectERT0_")
  //</editor-fold>
  protected void printProject(/*const*/ Project /*P*/ E, final StreamType /*&*/ SS) {
    if (CStyle) {
      {
        // Omit the  this->
        /*const*/ SApply /*P*/ SAP = dyn_cast_SApply(E.record$Const());
        if ((SAP != null)) {
          {
            /*const*/ Variable /*P*/ V = dyn_cast_Variable(SAP.sfun$Const());
            if ((V != null)) {
              if (!SAP.isDelegation() && V.kind() == Variable.VariableKind.VK_SFun) {
                SS.$out(E.slotName().data());
                return;
              }
            }
          }
        }
      }
      if (isa_Wildcard(E.record$Const())) {
        // handle existentials
        SS.$out($AMP);
        SS.$out_os_str(E.clangDecl().getQualifiedNameAsString());
        return;
      }
    }
    self().printSExpr(E.record$Const(), SS, Prec_Postfix);
    if (CStyle && E.isArrow()) {
      SS.$out($ARROW);
    } else {
      SS.$out($DOT);
    }
    SS.$out(E.slotName().data());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 716,
   FQN="clang::threadSafety::til::PrettyPrinter::printCall", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printCallEPKNS1_4CallERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printCallEPKNS1_4CallERT0_")
  //</editor-fold>
  protected void printCall(/*const*/ Call /*P*/ E, final StreamType /*&*/ SS) {
    /*const*/ SExpr /*P*/ T = E.target$Const();
    if (T.opcode() == TIL_Opcode.COP_Apply) {
      self().printApply(cast_Apply(T), SS, true);
      SS.$out($RPAREN);
    } else {
      self().printSExpr(T, SS, Prec_Postfix);
      SS.$out($LPAREN_RPAREN);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printAlloc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 728,
   FQN="clang::threadSafety::til::PrettyPrinter::printAlloc", NM="_ZN5clang12threadSafety3til13PrettyPrinter10printAllocEPKNS1_5AllocERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter10printAllocEPKNS1_5AllocERT0_")
  //</editor-fold>
  protected void printAlloc(/*const*/ Alloc /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("new "));
    self().printSExpr(E.dataType$Const(), SS, Prec_Other - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printLoad">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 733,
   FQN="clang::threadSafety::til::PrettyPrinter::printLoad", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printLoadEPKNS1_4LoadERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printLoadEPKNS1_4LoadERT0_")
  //</editor-fold>
  protected void printLoad(/*const*/ Load /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.pointer$Const(), SS, Prec_Postfix);
    if (!CStyle) {
      SS.$out($CARET);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printStore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 739,
   FQN="clang::threadSafety::til::PrettyPrinter::printStore", NM="_ZN5clang12threadSafety3til13PrettyPrinter10printStoreEPKNS1_5StoreERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter10printStoreEPKNS1_5StoreERT0_")
  //</editor-fold>
  protected void printStore(/*const*/ Store /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.destination$Const(), SS, Prec_Other - 1);
    SS.$out($(" := "));
    self().printSExpr(E.source$Const(), SS, Prec_Other - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printArrayIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 745,
   FQN="clang::threadSafety::til::PrettyPrinter::printArrayIndex", NM="_ZN5clang12threadSafety3til13PrettyPrinter15printArrayIndexEPKNS1_10ArrayIndexERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter15printArrayIndexEPKNS1_10ArrayIndexERT0_")
  //</editor-fold>
  protected void printArrayIndex(/*const*/ ArrayIndex /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.array$Const(), SS, Prec_Postfix);
    SS.$out($LSQUARE);
    self().printSExpr(E.index$Const(), SS, Prec_MAX);
    SS.$out($RSQUARE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printArrayAdd">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 752,
   FQN="clang::threadSafety::til::PrettyPrinter::printArrayAdd", NM="_ZN5clang12threadSafety3til13PrettyPrinter13printArrayAddEPKNS1_8ArrayAddERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter13printArrayAddEPKNS1_8ArrayAddERT0_")
  //</editor-fold>
  protected void printArrayAdd(/*const*/ ArrayAdd /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.array$Const(), SS, Prec_Postfix);
    SS.$out($(" + "));
    self().printSExpr(E.index$Const(), SS, Prec_Atom);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printUnaryOp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 758,
   FQN="clang::threadSafety::til::PrettyPrinter::printUnaryOp", NM="_ZN5clang12threadSafety3til13PrettyPrinter12printUnaryOpEPKNS1_7UnaryOpERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter12printUnaryOpEPKNS1_7UnaryOpERT0_")
  //</editor-fold>
  protected void printUnaryOp(/*const*/ UnaryOp /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out(getUnaryOpcodeString(E.unaryOpcode()).data());
    self().printSExpr(E.expr$Const(), SS, Prec_Unary);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printBinaryOp">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 763,
   FQN="clang::threadSafety::til::PrettyPrinter::printBinaryOp", NM="_ZN5clang12threadSafety3til13PrettyPrinter13printBinaryOpEPKNS1_8BinaryOpERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter13printBinaryOpEPKNS1_8BinaryOpERT0_")
  //</editor-fold>
  protected void printBinaryOp(/*const*/ BinaryOp /*P*/ E, final StreamType /*&*/ SS) {
    self().printSExpr(E.expr0$Const(), SS, Prec_Binary - 1);
    SS.$out($SPACE).$out(getBinaryOpcodeString(E.binaryOpcode()).data()).$out($SPACE);
    self().printSExpr(E.expr1$Const(), SS, Prec_Binary - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printCast">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 769,
   FQN="clang::threadSafety::til::PrettyPrinter::printCast", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printCastEPKNS1_4CastERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printCastEPKNS1_4CastERT0_")
  //</editor-fold>
  protected void printCast(/*const*/ Cast /*P*/ E, final StreamType /*&*/ SS) {
    if (!CStyle) {
      SS.$out($("cast["));
      SS.$out(E.castOpcode());
      SS.$out($("]("));
      self().printSExpr(E.expr$Const(), SS, Prec_Unary);
      SS.$out($RPAREN);
      return;
    }
    self().printSExpr(E.expr$Const(), SS, Prec_Unary);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printSCFG">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 781,
   FQN="clang::threadSafety::til::PrettyPrinter::printSCFG", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printSCFGEPKNS1_4SCFGERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printSCFGEPKNS1_4SCFGERT0_")
  //</editor-fold>
  protected void printSCFG(/*const*/ SCFG /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("CFG {\n"));
    for (BasicBlock /*P*/ BBI : $Deref(E)) {
      printBasicBlock(BBI, SS);
    }
    SS.$out($RCURLY);
    newline(SS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printBBInstr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 791,
   FQN="clang::threadSafety::til::PrettyPrinter::printBBInstr", NM="_ZN5clang12threadSafety3til13PrettyPrinter12printBBInstrEPKNS1_5SExprERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter12printBBInstrEPKNS1_5SExprERT0_")
  //</editor-fold>
  protected void printBBInstr(/*const*/ SExpr /*P*/ E, final StreamType /*&*/ SS) {
    boolean Sub = false;
    if (E.opcode() == TIL_Opcode.COP_Variable) {
      /*const*/ Variable /*P*/ V = cast_Variable(E);
      SS.$out($("let ")).$out(V.name().data()).$out(V.id()).$out($(" = "));
      E = V.definition$Const();
      Sub = true;
    } else if (E.opcode() != TIL_Opcode.COP_Store) {
      SS.$out($("let _x")).$out(E.id()).$out($(" = "));
    }
    self().printSExpr(E, SS, Prec_MAX, Sub);
    SS.$out($SEMI);
    newline(SS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printBasicBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 807,
   FQN="clang::threadSafety::til::PrettyPrinter::printBasicBlock", NM="_ZN5clang12threadSafety3til13PrettyPrinter15printBasicBlockEPKNS1_10BasicBlockERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter15printBasicBlockEPKNS1_10BasicBlockERT0_")
  //</editor-fold>
  protected void printBasicBlock(/*const*/ BasicBlock /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("BB_")).$out(E.blockID()).$out($COLON);
    if ((E.parent$Const() != null)) {
      SS.$out($(" BB_")).$out(E.parent$Const().blockID());
    }
    newline(SS);
    
    for (SExpr /*P*/ A : E.arguments$Const())  {
      printBBInstr(A, SS);
    }
    
    for (SExpr /*P*/ I : E.instructions$Const())  {
      printBBInstr(I, SS);
    }
    
    /*const*/ SExpr /*P*/ T = E.terminator$Const();
    if ((T != null)) {
      self().printSExpr(T, SS, Prec_MAX, false);
      SS.$out($SEMI);
      newline(SS);
    }
    newline(SS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printPhi">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 828,
   FQN="clang::threadSafety::til::PrettyPrinter::printPhi", NM="_ZN5clang12threadSafety3til13PrettyPrinter8printPhiEPKNS1_3PhiERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter8printPhiEPKNS1_3PhiERT0_")
  //</editor-fold>
  protected void printPhi(/*const*/ Phi /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("phi("));
    if (E.status() == Phi.Status.PH_SingleVal) {
      self().printSExpr(E.values$Const().$at$Const(0), SS, Prec_MAX);
    } else {
      /*uint*/int i = 0;
      for (SExpr /*P*/ V : E.values$Const()) {
        if ($greater_uint(i++, 0)) {
          SS.$out($COMMA_SPACE);
        }
        self().printSExpr(V, SS, Prec_MAX);
      }
    }
    SS.$out($RPAREN);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printGoto">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 843,
   FQN="clang::threadSafety::til::PrettyPrinter::printGoto", NM="_ZN5clang12threadSafety3til13PrettyPrinter9printGotoEPKNS1_4GotoERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter9printGotoEPKNS1_4GotoERT0_")
  //</editor-fold>
  protected void printGoto(/*const*/ Goto /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("goto "));
    printBlockLabel(SS, E.targetBlock$Const(), E.index());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printBranch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 848,
   FQN="clang::threadSafety::til::PrettyPrinter::printBranch", NM="_ZN5clang12threadSafety3til13PrettyPrinter11printBranchEPKNS1_6BranchERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter11printBranchEPKNS1_6BranchERT0_")
  //</editor-fold>
  protected void printBranch(/*const*/ Branch /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("branch ("));
    self().printSExpr(E.condition$Const(), SS, Prec_MAX);
    SS.$out($(") "));
    printBlockLabel(SS, E.thenBlock$Const(), -1);
    SS.$out($SPACE);
    printBlockLabel(SS, E.elseBlock$Const(), -1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printReturn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 857,
   FQN="clang::threadSafety::til::PrettyPrinter::printReturn", NM="_ZN5clang12threadSafety3til13PrettyPrinter11printReturnEPKNS1_6ReturnERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter11printReturnEPKNS1_6ReturnERT0_")
  //</editor-fold>
  protected void printReturn(/*const*/ Return /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("return "));
    self().printSExpr(E.returnValue$Const(), SS, Prec_Other);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 862,
   FQN="clang::threadSafety::til::PrettyPrinter::printIdentifier", NM="_ZN5clang12threadSafety3til13PrettyPrinter15printIdentifierEPKNS1_10IdentifierERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter15printIdentifierEPKNS1_10IdentifierERT0_")
  //</editor-fold>
  protected void printIdentifier(/*const*/ Identifier /*P*/ E, final StreamType /*&*/ SS) {
    StringRef $Name = E.name();
    SS.$out($Name.data(), $Name.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printIfThenElse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 866,
   FQN="clang::threadSafety::til::PrettyPrinter::printIfThenElse", NM="_ZN5clang12threadSafety3til13PrettyPrinter15printIfThenElseEPKNS1_10IfThenElseERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter15printIfThenElseEPKNS1_10IfThenElseERT0_")
  //</editor-fold>
  protected void printIfThenElse(/*const*/ IfThenElse /*P*/ E, final StreamType /*&*/ SS) {
    if (CStyle) {
      printSExpr(E.condition$Const(), SS, Prec_Unary);
      SS.$out($(" ? "));
      printSExpr(E.thenExpr$Const(), SS, Prec_Unary);
      SS.$out($(" : "));
      printSExpr(E.elseExpr$Const(), SS, Prec_Unary);
      return;
    }
    SS.$out($("if ("));
    printSExpr(E.condition$Const(), SS, Prec_MAX);
    SS.$out($(") then "));
    printSExpr(E.thenExpr$Const(), SS, Prec_Other);
    SS.$out($(" else "));
    printSExpr(E.elseExpr$Const(), SS, Prec_Other);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::PrettyPrinter::printLet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 883,
   FQN="clang::threadSafety::til::PrettyPrinter::printLet", NM="_ZN5clang12threadSafety3til13PrettyPrinter8printLetEPKNS1_3LetERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til13PrettyPrinter8printLetEPKNS1_3LetERT0_")
  //</editor-fold>
  protected void printLet(/*const*/ Let /*P*/ E, final StreamType /*&*/ SS) {
    SS.$out($("let "));
    printVariable(E.variableDecl$Const(), SS, true);
    SS.$out($(" = "));
    printSExpr(E.variableDecl$Const().definition$Const(), SS, Prec_Decl - 1);
    SS.$out( $("; "));
    printSExpr(E.body$Const(), SS, Prec_Decl - 1);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected void printLiteralT_LiteralTByte(/*const*/LiteralTByte E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTShort(/*const*/LiteralTShort E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTUshort(/*const*/LiteralTUshort E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTInt(/*const*/LiteralTInt E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTUint(/*const*/LiteralTUint E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTLlong(/*const*/LiteralTLlong E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTUllong(/*const*/LiteralTUllong E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTFloat(/*const*/LiteralTFloat E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTDouble(/*const*/LiteralTDouble E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }
  protected void printLiteralT_LiteralTStringRef(/*const*/LiteralTStringRef E, final StreamType /*&*/ SS) {
    SS.$out($SGL_QUOTE).$out(E.value$Const()).$out($SGL_QUOTE);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Verbose=" + Verbose // NOI18N
              + ", Cleanup=" + Cleanup // NOI18N
              + ", CStyle=" + CStyle; // NOI18N
  }
}
