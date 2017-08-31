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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.ast.Stmt.ExprIterator;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.StmtPrinterStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 36,
 FQN="(anonymous namespace)::StmtPrinter", NM="_ZN12_GLOBAL__N_111StmtPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinterE")
//</editor-fold>
public class StmtPrinter implements /*public*/ StmtVisitorVoid<StmtPrinter> {
  private final raw_ostream /*&*/ OS;
  private /*uint*/int IndentLevel;
  private PrinterHelper /*P*/ Helper;
  private PrintingPolicy Policy;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::StmtPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 43,
   FQN="(anonymous namespace)::StmtPrinter::StmtPrinter", NM="_ZN12_GLOBAL__N_111StmtPrinterC1ERN4llvm11raw_ostreamEPN5clang13PrinterHelperERKNS4_14PrintingPolicyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinterC1ERN4llvm11raw_ostreamEPN5clang13PrinterHelperERKNS4_14PrintingPolicyEj")
  //</editor-fold>
  public StmtPrinter(final raw_ostream /*&*/ os, PrinterHelper /*P*/ helper, 
      final /*const*/ PrintingPolicy /*&*/ Policy) {
    this(os, helper, 
      Policy, 
      0);
  }
  public StmtPrinter(final raw_ostream /*&*/ os, PrinterHelper /*P*/ helper, 
      final /*const*/ PrintingPolicy /*&*/ Policy, 
      /*uint*/int Indentation/*= 0*/) {
    // : StmtVisitor<StmtPrinter>(), OS(os), IndentLevel(Indentation), Helper(helper), Policy(Policy) 
    //START JInit
    $StmtVisitor();
    this./*&*/OS=/*&*/os;
    this.IndentLevel = Indentation;
    this.Helper = helper;
    this.Policy = new PrintingPolicy(Policy);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 48,
   FQN="(anonymous namespace)::StmtPrinter::PrintStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter9PrintStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter9PrintStmtEPN5clang4StmtE")
  //</editor-fold>
  public void PrintStmt(Stmt /*P*/ S) {
    PrintStmt(S, $8bits_uint2uint(Policy.Indentation));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 52,
   FQN="(anonymous namespace)::StmtPrinter::PrintStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter9PrintStmtEPN5clang4StmtEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter9PrintStmtEPN5clang4StmtEi")
  //</editor-fold>
  public void PrintStmt(Stmt /*P*/ S, int SubIndent) {
    IndentLevel += SubIndent;
    if ((S != null) && isa_Expr(S)) {
      // If this is an expr used in a stmt context, indent and newline it.
      Indent();
      Visit(S);
      OS.$out(/*KEEP_STR*/";\n");
    } else if ((S != null)) {
      Visit(S);
    } else {
      Indent().$out(/*KEEP_STR*/"<<<NULL STATEMENT>>>\n");
    }
    IndentLevel -= SubIndent;
  }

  
  
  //===----------------------------------------------------------------------===//
  //  Stmt printing methods.
  //===----------------------------------------------------------------------===//
  
  /// PrintRawCompoundStmt - Print a compound stmt without indenting the {, and
  /// with no newline after the }.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 117,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawCompoundStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter20PrintRawCompoundStmtEPN5clang12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20PrintRawCompoundStmtEPN5clang12CompoundStmtE")
  //</editor-fold>
  public void PrintRawCompoundStmt(CompoundStmt /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"{\n");
    for (Stmt /*P*/ I : Node.body())  {
      PrintStmt(I);
    }
    
    Indent().$out(/*KEEP_STR*/$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 125,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawDecl", NM="_ZN12_GLOBAL__N_111StmtPrinter12PrintRawDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter12PrintRawDeclEPN5clang4DeclE")
  //</editor-fold>
  public void PrintRawDecl(Decl /*P*/ D) {
    D.print(OS, Policy, IndentLevel);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawDeclStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 129,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawDeclStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter16PrintRawDeclStmtEPKN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16PrintRawDeclStmtEPKN5clang8DeclStmtE")
  //</editor-fold>
  public void PrintRawDeclStmt(/*const*/ DeclStmt /*P*/ S) {
    //SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(2, S.decls$Const(), (Decl)null);
    //JAVA: we don't have SmallVector(int, iterator_range,...) ctor yet
    final iterator_range<Decl> $range = S.decls$Const();
    SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(2, $range.begin(), $range.end(), (Decl)null);
    Decl.printGroup(Decls.data(), Decls.size(), OS, Policy, IndentLevel);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 180,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawIfStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter14PrintRawIfStmtEPN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14PrintRawIfStmtEPN5clang6IfStmtE")
  //</editor-fold>
  public void PrintRawIfStmt(IfStmt /*P*/ If) {
    OS.$out(/*KEEP_STR*/"if (");
    {
      /*const*/ DeclStmt /*P*/ DS = If.getConditionVariableDeclStmt();
      if ((DS != null)) {
        PrintRawDeclStmt(DS);
      } else {
        PrintExpr(If.getCond());
      }
    }
    OS.$out_char($$RPAREN);
    {
      
      CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(If.getThen());
      if ((CS != null)) {
        OS.$out_char($$SPACE);
        PrintRawCompoundStmt(CS);
        OS.$out_char(((If.getElse() != null) ? $$SPACE : $$LF));
      } else {
        OS.$out_char($$LF);
        PrintStmt(If.getThen());
        if ((If.getElse() != null)) {
          Indent();
        }
      }
    }
    {
      
      Stmt /*P*/ Else = If.getElse();
      if ((Else != null)) {
        OS.$out(/*KEEP_STR*/$else);
        {
          
          CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Else);
          if ((CS != null)) {
            OS.$out_char($$SPACE);
            PrintRawCompoundStmt(CS);
            OS.$out_char($$LF);
          } else {
            IfStmt /*P*/ ElseIf = dyn_cast_IfStmt(Else);
            if ((ElseIf != null)) {
              OS.$out_char($$SPACE);
              PrintRawIfStmt(ElseIf);
            } else {
              OS.$out_char($$LF);
              PrintStmt(If.getElse());
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 519,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawCXXCatchStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter20PrintRawCXXCatchStmtEPN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20PrintRawCXXCatchStmtEPN5clang12CXXCatchStmtE")
  //</editor-fold>
  public void PrintRawCXXCatchStmt(CXXCatchStmt /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"catch (");
    {
      Decl /*P*/ ExDecl = Node.getExceptionDecl();
      if ((ExDecl != null)) {
        PrintRawDecl(ExDecl);
      } else {
        OS.$out(/*KEEP_STR*/$ELLIPSIS);
      }
    }
    OS.$out(/*KEEP_STR*/") ");
    PrintRawCompoundStmt(cast_CompoundStmt(Node.getHandlerBlock()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintCallArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1527,
   FQN="(anonymous namespace)::StmtPrinter::PrintCallArgs", NM="_ZN12_GLOBAL__N_111StmtPrinter13PrintCallArgsEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13PrintCallArgsEPN5clang8CallExprE")
  //</editor-fold>
  public void PrintCallArgs(CallExpr /*P*/ Call) {
    for (/*uint*/int i = 0, e = Call.getNumArgs(); i != e; ++i) {
      if (isa_CXXDefaultArgExpr(Call.getArg(i))) {
        // Don't print any defaulted arguments
        break;
      }
      if ((i != 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      PrintExpr(Call.getArg(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawSEHExceptHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 565,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawSEHExceptHandler", NM="_ZN12_GLOBAL__N_111StmtPrinter24PrintRawSEHExceptHandlerEPN5clang13SEHExceptStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24PrintRawSEHExceptHandlerEPN5clang13SEHExceptStmtE")
  //</editor-fold>
  public void PrintRawSEHExceptHandler(SEHExceptStmt /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__except (");
    VisitExpr(Node.getFilterExpr());
    OS.$out(/*KEEP_STR*/")\n");
    PrintRawCompoundStmt(Node.getBlock());
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintRawSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 559,
   FQN="(anonymous namespace)::StmtPrinter::PrintRawSEHFinallyStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter22PrintRawSEHFinallyStmtEPN5clang14SEHFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22PrintRawSEHFinallyStmtEPN5clang14SEHFinallyStmtE")
  //</editor-fold>
  public void PrintRawSEHFinallyStmt(SEHFinallyStmt /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__finally ");
    PrintRawCompoundStmt(Node.getBlock());
    OS.$out(/*KEEP_STR*/$LF);
  }

  
  //===----------------------------------------------------------------------===//
  //  OpenMP directives printing methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 977,
   FQN="(anonymous namespace)::StmtPrinter::PrintOMPExecutableDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter27PrintOMPExecutableDirectiveEPN5clang22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27PrintOMPExecutableDirectiveEPN5clang22OMPExecutableDirectiveE")
  //</editor-fold>
  public void PrintOMPExecutableDirective(OMPExecutableDirective /*P*/ S) {
    OMPClausePrinter Printer/*J*/= new OMPClausePrinter(OS, Policy);
    ArrayRef<OMPClause /*P*/ > Clauses = S.clauses();
    for (type$ptr<OMPClause /*P*/ /*P*/> I = $tryClone(Clauses.begin()), /*P*/ E = $tryClone(Clauses.end());
         $noteq_ptr(I, E); I.$preInc())  {
      if ((I.$star() != null) && !(I.$star()).isImplicit()) {
        Printer.Visit(I.$star());
        OS.$out_char($$SPACE);
      }
    }
    OS.$out(/*KEEP_STR*/$LF);
    if (S.hasAssociatedStmt() && (S.getAssociatedStmt() != null)) {
      assert (isa_CapturedStmt(S.getAssociatedStmt())) : "Expected captured statement!";
      Stmt /*P*/ CS = cast_CapturedStmt(S.getAssociatedStmt()).getCapturedStmt();
      PrintStmt(CS);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::PrintExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 77,
   FQN="(anonymous namespace)::StmtPrinter::PrintExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter9PrintExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter9PrintExprEPN5clang4ExprE")
  //</editor-fold>
  public void PrintExpr(Expr /*P*/ E) {
    if ((E != null)) {
      Visit(E);
    } else {
      OS.$out(/*KEEP_STR*/"<null expr>");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::Indent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 84,
   FQN="(anonymous namespace)::StmtPrinter::Indent", NM="_ZN12_GLOBAL__N_111StmtPrinter6IndentEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter6IndentEi")
  //</editor-fold>
  public raw_ostream /*&*/ Indent() {
    return Indent(0);
  }
  public raw_ostream /*&*/ Indent(int Delta/*= 0*/) {
    for (int i = 0, e = IndentLevel + Delta; i < e; ++i)  {
      OS.$out(/*KEEP_STR*/"  ");
    }
    return OS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::Visit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 90,
   FQN="(anonymous namespace)::StmtPrinter::Visit", NM="_ZN12_GLOBAL__N_111StmtPrinter5VisitEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter5VisitEPN5clang4StmtE")
  //</editor-fold>
  public void Visit(Stmt /*P*/ S) {
    if ((Helper != null) && Helper.handledStmt(S, OS)) {
      return;
    } else {
      StmtVisitorVoid.super.Visit(S);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 96,
   FQN="(anonymous namespace)::StmtPrinter::VisitStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ Node)/* __attribute__((unused))*/ {
    Indent().$out(/*KEEP_STR*/"<<unknown stmt type>>\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 99,
   FQN="(anonymous namespace)::StmtPrinter::VisitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public void VisitExpr(Expr /*P*/ Node)/* __attribute__((unused))*/ {
    OS.$out(/*KEEP_STR*/"<<unknown expr type>>");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1870,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXNamedCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitCXXNamedCastExprEPN5clang16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitCXXNamedCastExprEPN5clang16CXXNamedCastExprE")
  //</editor-fold>
  public void VisitCXXNamedCastExpr(CXXNamedCastExpr /*P*/ Node) {
    OS.$out(Node.getCastName()).$out_char($$LT);
    Node.getTypeAsWritten().print(OS, Policy);
    OS.$out(/*KEEP_STR*/">(");
    PrintExpr(Node.getSubExpr());
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 376,
   FQN="(anonymous namespace)::StmtPrinter::VisitGCCAsmStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitGCCAsmStmtEPN5clang10GCCAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitGCCAsmStmtEPN5clang10GCCAsmStmtE")
  //</editor-fold>
  public void VisitGCCAsmStmt(GCCAsmStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"asm ");
    if (Node.isVolatile()) {
      OS.$out(/*KEEP_STR*/"volatile ");
    }
    
    OS.$out(/*KEEP_STR*/$LPAREN);
    VisitStringLiteral(Node.getAsmString());
    
    // Outputs
    if (Node.getNumOutputs() != 0 || Node.getNumInputs() != 0
       || Node.getNumClobbers() != 0) {
      OS.$out(/*KEEP_STR*/" : ");
    }
    
    for (/*uint*/int i = 0, e = Node.getNumOutputs(); i != e; ++i) {
      if (i != 0) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      if (!Node.getOutputName(i).empty()) {
        OS.$out_char($$LSQUARE);
        OS.$out(Node.getOutputName(i));
        OS.$out(/*KEEP_STR*/"] ");
      }
      
      VisitStringLiteral(Node.getOutputConstraintLiteral(i));
      OS.$out(/*KEEP_STR*/" (");
      Visit(Node.getOutputExpr(i));
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
    
    // Inputs
    if (Node.getNumInputs() != 0 || Node.getNumClobbers() != 0) {
      OS.$out(/*KEEP_STR*/" : ");
    }
    
    for (/*uint*/int i = 0, e = Node.getNumInputs(); i != e; ++i) {
      if (i != 0) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      if (!Node.getInputName(i).empty()) {
        OS.$out_char($$LSQUARE);
        OS.$out(Node.getInputName(i));
        OS.$out(/*KEEP_STR*/"] ");
      }
      
      VisitStringLiteral(Node.getInputConstraintLiteral(i));
      OS.$out(/*KEEP_STR*/" (");
      Visit(Node.getInputExpr(i));
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
    
    // Clobbers
    if (Node.getNumClobbers() != 0) {
      OS.$out(/*KEEP_STR*/" : ");
    }
    
    for (/*uint*/int i = 0, e = Node.getNumClobbers(); i != e; ++i) {
      if (i != 0) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      
      VisitStringLiteral(Node.getClobberStringLiteral(i));
    }
    
    OS.$out(/*KEEP_STR*/");");
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitMSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 441,
   FQN="(anonymous namespace)::StmtPrinter::VisitMSAsmStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitMSAsmStmtEPN5clang9MSAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitMSAsmStmtEPN5clang9MSAsmStmtE")
  //</editor-fold>
  public void VisitMSAsmStmt(MSAsmStmt /*P*/ Node) {
    // FIXME: Implement MS style inline asm statement printer.
    Indent().$out(/*KEEP_STR*/"__asm ");
    if (Node.hasBraces()) {
      OS.$out(/*KEEP_STR*/"{\n");
    }
    OS.$out(Node.getAsmString()).$out(/*KEEP_STR*/$LF);
    if (Node.hasBraces()) {
      Indent().$out(/*KEEP_STR*/"}\n");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 172,
   FQN="(anonymous namespace)::StmtPrinter::VisitAttributedStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitAttributedStmtEPN5clang14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitAttributedStmtEPN5clang14AttributedStmtE")
  //</editor-fold>
  public void VisitAttributedStmt(AttributedStmt /*P*/ Node) {
    for (/*const*/ Attr /*P*/ $Attr : Node.getAttrs()) {
      $Attr.printPretty(OS, Policy);
    }
    
    PrintStmt(Node.getSubStmt(), 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 359,
   FQN="(anonymous namespace)::StmtPrinter::VisitBreakStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitBreakStmtEPN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitBreakStmtEPN5clang9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(BreakStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"break;");
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 529,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXCatchStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitCXXCatchStmtEPN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitCXXCatchStmtEPN5clang12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(CXXCatchStmt /*P*/ Node) {
    Indent();
    PrintRawCXXCatchStmt(Node);
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 313,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXForRangeStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitCXXForRangeStmtEPN5clang15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitCXXForRangeStmtEPN5clang15CXXForRangeStmtE")
  //</editor-fold>
  public void VisitCXXForRangeStmt(CXXForRangeStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"for (");
    PrintingPolicy SubPolicy/*J*/= new PrintingPolicy(Policy);
    SubPolicy.SuppressInitializers = true;
    Node.getLoopVariable().print(OS, SubPolicy, IndentLevel);
    OS.$out(/*KEEP_STR*/" : ");
    PrintExpr(Node.getRangeInit());
    OS.$out(/*KEEP_STR*/") {\n");
    PrintStmt(Node.getBody());
    Indent().$out(/*KEEP_STR*/$RCURLY);
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 535,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXTryStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitCXXTryStmtEPN5clang10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitCXXTryStmtEPN5clang10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(CXXTryStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"try ");
    PrintRawCompoundStmt(Node.getTryBlock());
    for (/*uint*/int i = 0, e = Node.getNumHandlers(); $less_uint(i, e); ++i) {
      OS.$out(/*KEEP_STR*/$SPACE);
      PrintRawCXXCatchStmt(Node.getHandler(i));
    }
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 451,
   FQN="(anonymous namespace)::StmtPrinter::VisitCapturedStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitCapturedStmtEPN5clang12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitCapturedStmtEPN5clang12CapturedStmtE")
  //</editor-fold>
  public void VisitCapturedStmt(CapturedStmt /*P*/ Node) {
    PrintStmt(Node.getCapturedDecl().getBody());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 144,
   FQN="(anonymous namespace)::StmtPrinter::VisitCompoundStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitCompoundStmtEPN5clang12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitCompoundStmtEPN5clang12CompoundStmtE")
  //</editor-fold>
  public void VisitCompoundStmt(CompoundStmt /*P*/ Node) {
    Indent();
    PrintRawCompoundStmt(Node);
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 354,
   FQN="(anonymous namespace)::StmtPrinter::VisitContinueStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitContinueStmtEPN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitContinueStmtEPN5clang12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(ContinueStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"continue;");
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2394,
   FQN="(anonymous namespace)::StmtPrinter::VisitCoreturnStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitCoreturnStmtEPN5clang12CoreturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitCoreturnStmtEPN5clang12CoreturnStmtE")
  //</editor-fold>
  public void VisitCoreturnStmt(CoreturnStmt /*P*/ S) {
    OS.$out(/*KEEP_STR*/$co_return);
    if ((S.getOperand() != null)) {
      OS.$out(/*KEEP_STR*/$SPACE);
      Visit(S.getOperand());
    }
    OS.$out(/*KEEP_STR*/$SEMI);
  }

  
  // C++ Coroutines TS
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2390,
   FQN="(anonymous namespace)::StmtPrinter::VisitCoroutineBodyStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitCoroutineBodyStmtEPN5clang17CoroutineBodyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitCoroutineBodyStmtEPN5clang17CoroutineBodyStmtE")
  //</editor-fold>
  public void VisitCoroutineBodyStmt(CoroutineBodyStmt /*P*/ S) {
    Visit(S.getBody());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 138,
   FQN="(anonymous namespace)::StmtPrinter::VisitDeclStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ Node) {
    Indent();
    PrintRawDeclStmt(Node);
    OS.$out(/*KEEP_STR*/";\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 249,
   FQN="(anonymous namespace)::StmtPrinter::VisitDoStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter11VisitDoStmtEPN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter11VisitDoStmtEPN5clang6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(DoStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"do ");
    {
      CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Node.getBody());
      if ((CS != null)) {
        PrintRawCompoundStmt(CS);
        OS.$out(/*KEEP_STR*/$SPACE);
      } else {
        OS.$out(/*KEEP_STR*/$LF);
        PrintStmt(Node.getBody());
        Indent();
      }
    }
    
    OS.$out(/*KEEP_STR*/"while (");
    PrintExpr(Node.getCond());
    OS.$out(/*KEEP_STR*/");\n");
  }

  
  // GNU extensions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1615,
   FQN="(anonymous namespace)::StmtPrinter::VisitBinaryConditionalOperator", NM="_ZN12_GLOBAL__N_111StmtPrinter30VisitBinaryConditionalOperatorEPN5clang25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter30VisitBinaryConditionalOperatorEPN5clang25BinaryConditionalOperatorE")
  //</editor-fold>
  public void VisitBinaryConditionalOperator(BinaryConditionalOperator /*P*/ Node) {
    PrintExpr(Node.getCommon());
    OS.$out(/*KEEP_STR*/" ?: ");
    PrintExpr(Node.getFalseExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1605,
   FQN="(anonymous namespace)::StmtPrinter::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitConditionalOperatorEPN5clang19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitConditionalOperatorEPN5clang19ConditionalOperatorE")
  //</editor-fold>
  public void VisitConditionalOperator(ConditionalOperator /*P*/ Node) {
    PrintExpr(Node.getCond());
    OS.$out(/*KEEP_STR*/" ? ");
    PrintExpr(Node.getLHS());
    OS.$out(/*KEEP_STR*/" : ");
    PrintExpr(Node.getRHS());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1621,
   FQN="(anonymous namespace)::StmtPrinter::VisitAddrLabelExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitAddrLabelExprEPN5clang13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitAddrLabelExprEPN5clang13AddrLabelExprE")
  //</editor-fold>
  public void VisitAddrLabelExpr(AddrLabelExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$AMP_AMP).$out(Node.getLabel().getName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1507,
   FQN="(anonymous namespace)::StmtPrinter::VisitArraySubscriptExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitArraySubscriptExprEPN5clang18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitArraySubscriptExprEPN5clang18ArraySubscriptExprE")
  //</editor-fold>
  public void VisitArraySubscriptExpr(ArraySubscriptExpr /*P*/ Node) {
    PrintExpr(Node.getLHS());
    OS.$out(/*KEEP_STR*/$LSQUARE);
    PrintExpr(Node.getRHS());
    OS.$out(/*KEEP_STR*/$RSQUARE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2329,
   FQN="(anonymous namespace)::StmtPrinter::VisitArrayTypeTraitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitArrayTypeTraitExprEPN5clang18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitArrayTypeTraitExprEPN5clang18ArrayTypeTraitExprE")
  //</editor-fold>
  public void VisitArrayTypeTraitExpr(ArrayTypeTraitExpr /*P*/ E) {
    OS.$out(getTypeTraitName_ArrayTypeTrait(E.getTrait())).$out_char($$LPAREN);
    E.getQueriedType().print(OS, Policy);
    OS.$out_char($$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitAsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2559,
   FQN="(anonymous namespace)::StmtPrinter::VisitAsTypeExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitAsTypeExprEPN5clang10AsTypeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitAsTypeExprEPN5clang10AsTypeExprE")
  //</editor-fold>
  public void VisitAsTypeExpr(AsTypeExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__builtin_astype(");
    PrintExpr(Node.getSrcExpr());
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    Node.getType().print(OS, Policy);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1764,
   FQN="(anonymous namespace)::StmtPrinter::VisitAtomicExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitAtomicExprEPN5clang10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitAtomicExprEPN5clang10AtomicExprE")
  //</editor-fold>
  public void VisitAtomicExpr(AtomicExpr /*P*/ Node) {
    /*const*/char$ptr/*char P*/ Name = null;
    switch (Node.getOp()) {
     case AO__c11_atomic_init:
      
      // C11 _Atomic operations for <stdatomic.h>.
      Name = $tryClone($("__c11_atomic_init("));
      break;
     case AO__c11_atomic_load:
      Name = $tryClone($("__c11_atomic_load("));
      break;
     case AO__c11_atomic_store:
      Name = $tryClone($("__c11_atomic_store("));
      break;
     case AO__c11_atomic_exchange:
      Name = $tryClone($("__c11_atomic_exchange("));
      break;
     case AO__c11_atomic_compare_exchange_strong:
      Name = $tryClone($("__c11_atomic_compare_exchange_strong("));
      break;
     case AO__c11_atomic_compare_exchange_weak:
      Name = $tryClone($("__c11_atomic_compare_exchange_weak("));
      break;
     case AO__c11_atomic_fetch_add:
      Name = $tryClone($("__c11_atomic_fetch_add("));
      break;
     case AO__c11_atomic_fetch_sub:
      Name = $tryClone($("__c11_atomic_fetch_sub("));
      break;
     case AO__c11_atomic_fetch_and:
      Name = $tryClone($("__c11_atomic_fetch_and("));
      break;
     case AO__c11_atomic_fetch_or:
      Name = $tryClone($("__c11_atomic_fetch_or("));
      break;
     case AO__c11_atomic_fetch_xor:
      Name = $tryClone($("__c11_atomic_fetch_xor("));
      break;
     case AO__atomic_load:
      
      // GNU atomic builtins.
      Name = $tryClone($("__atomic_load("));
      break;
     case AO__atomic_load_n:
      Name = $tryClone($("__atomic_load_n("));
      break;
     case AO__atomic_store:
      Name = $tryClone($("__atomic_store("));
      break;
     case AO__atomic_store_n:
      Name = $tryClone($("__atomic_store_n("));
      break;
     case AO__atomic_exchange:
      Name = $tryClone($("__atomic_exchange("));
      break;
     case AO__atomic_exchange_n:
      Name = $tryClone($("__atomic_exchange_n("));
      break;
     case AO__atomic_compare_exchange:
      Name = $tryClone($("__atomic_compare_exchange("));
      break;
     case AO__atomic_compare_exchange_n:
      Name = $tryClone($("__atomic_compare_exchange_n("));
      break;
     case AO__atomic_fetch_add:
      Name = $tryClone($("__atomic_fetch_add("));
      break;
     case AO__atomic_fetch_sub:
      Name = $tryClone($("__atomic_fetch_sub("));
      break;
     case AO__atomic_fetch_and:
      Name = $tryClone($("__atomic_fetch_and("));
      break;
     case AO__atomic_fetch_or:
      Name = $tryClone($("__atomic_fetch_or("));
      break;
     case AO__atomic_fetch_xor:
      Name = $tryClone($("__atomic_fetch_xor("));
      break;
     case AO__atomic_fetch_nand:
      Name = $tryClone($("__atomic_fetch_nand("));
      break;
     case AO__atomic_add_fetch:
      Name = $tryClone($("__atomic_add_fetch("));
      break;
     case AO__atomic_sub_fetch:
      Name = $tryClone($("__atomic_sub_fetch("));
      break;
     case AO__atomic_and_fetch:
      Name = $tryClone($("__atomic_and_fetch("));
      break;
     case AO__atomic_or_fetch:
      Name = $tryClone($("__atomic_or_fetch("));
      break;
     case AO__atomic_xor_fetch:
      Name = $tryClone($("__atomic_xor_fetch("));
      break;
     case AO__atomic_nand_fetch:
      Name = $tryClone($("__atomic_nand_fetch("));
      break;
    }
    OS.$out(Name);
    
    // AtomicExpr stores its subexpressions in a permuted order.
    PrintExpr(Node.getPtr());
    if (Node.getOp() != AtomicExpr.AtomicOp.AO__c11_atomic_load
       && Node.getOp() != AtomicExpr.AtomicOp.AO__atomic_load_n) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      PrintExpr(Node.getVal1());
    }
    if (Node.getOp() == AtomicExpr.AtomicOp.AO__atomic_exchange
       || Node.isCmpXChg()) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      PrintExpr(Node.getVal2());
    }
    if (Node.getOp() == AtomicExpr.AtomicOp.AO__atomic_compare_exchange
       || Node.getOp() == AtomicExpr.AtomicOp.AO__atomic_compare_exchange_n) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      PrintExpr(Node.getWeak());
    }
    if (Node.getOp() != AtomicExpr.AtomicOp.AO__c11_atomic_init) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      PrintExpr(Node.getOrder());
    }
    if (Node.isCmpXChg()) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      PrintExpr(Node.getOrderFail());
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1595,
   FQN="(anonymous namespace)::StmtPrinter::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ Node) {
    PrintExpr(Node.getLHS());
    OS.$out(/*KEEP_STR*/$SPACE).$out(BinaryOperator.getOpcodeStr(Node.getOpcode())).$out(/*KEEP_STR*/$SPACE);
    PrintExpr(Node.getRHS());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1600,
   FQN="(anonymous namespace)::StmtPrinter::VisitCompoundAssignOperator", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitCompoundAssignOperatorEPN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitCompoundAssignOperatorEPN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public void VisitCompoundAssignOperator(CompoundAssignOperator /*P*/ Node) {
    PrintExpr(Node.getLHS());
    OS.$out(/*KEEP_STR*/$SPACE).$out(BinaryOperator.getOpcodeStr(Node.getOpcode())).$out(/*KEEP_STR*/$SPACE);
    PrintExpr(Node.getRHS());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2523,
   FQN="(anonymous namespace)::StmtPrinter::VisitBlockExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ Node) {
    BlockDecl /*P*/ BD = Node.getBlockDecl();
    OS.$out(/*KEEP_STR*/$CARET);
    
    /*const*/ FunctionType /*P*/ AFT = Node.getFunctionType();
    if (isa_FunctionNoProtoType(AFT)) {
      OS.$out(/*KEEP_STR*/$LPAREN_RPAREN);
    } else if (!BD.param_empty() || cast_FunctionProtoType(AFT).isVariadic()) {
      OS.$out_char($$LPAREN);
      for (type$ptr<ParmVarDecl /*P*/ /*P*/> AI = $tryClone(BD.param_begin()), 
          /*P*/ E = $tryClone(BD.param_end()); $noteq_ptr(AI, E); AI.$preInc()) {
        if ($noteq_ptr(AI, BD.param_begin())) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        std.string ParamStr = (AI.$star()).getNameAsString();
        (AI.$star()).getType().print(OS, Policy, new Twine(ParamStr));
      }
      
      /*const*/ FunctionProtoType /*P*/ FT = cast_FunctionProtoType(AFT);
      if (FT.isVariadic()) {
        if (!BD.param_empty()) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        OS.$out(/*KEEP_STR*/$ELLIPSIS);
      }
      OS.$out_char($$RPAREN);
    }
    OS.$out(/*KEEP_STR*/"{ }");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2019,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ Node) {
    PrintExpr(Node.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1979,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXBoolLiteralExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitCXXBoolLiteralExprEPN5clang18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitCXXBoolLiteralExprEPN5clang18CXXBoolLiteralExprE")
  //</editor-fold>
  public void VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr /*P*/ Node) {
    OS.$out((Node.getValue() ? $true : $false));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2212,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    if (E.isListInitialization() && !E.isStdInitListInitialization()) {
      OS.$out(/*KEEP_STR*/$LCURLY);
    }
    
    for (/*uint*/int i = 0, e = E.getNumArgs(); i != e; ++i) {
      if (isa_CXXDefaultArgExpr(E.getArg(i))) {
        // Don't print any defaulted arguments
        break;
      }
      if ((i != 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      PrintExpr(E.getArg(i));
    }
    if (E.isListInitialization() && !E.isStdInitListInitialization()) {
      OS.$out(/*KEEP_STR*/$RCURLY);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2023,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXTemporaryObjectExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitCXXTemporaryObjectExprEPN5clang22CXXTemporaryObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitCXXTemporaryObjectExprEPN5clang22CXXTemporaryObjectExprE")
  //</editor-fold>
  public void VisitCXXTemporaryObjectExpr(CXXTemporaryObjectExpr /*P*/ Node) {
    Node.getType().print(OS, Policy);
    if (Node.isStdInitListInitialization()) {
/* Nothing to do; braces are part of creating the std::initializer_list. */       ;
    } else if (Node.isListInitialization()) {
      OS.$out(/*KEEP_STR*/$LCURLY);
    } else {
      OS.$out(/*KEEP_STR*/$LPAREN);
    }
    for (ExprIterator Arg = Node.arg_begin(), 
        ArgEnd = Node.arg_end();
         Arg.$noteq(ArgEnd); Arg.$preInc()) {
      if ((Arg.$star()).isDefaultArgument()) {
        break;
      }
      if (Arg.$noteq(Node.arg_begin())) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      PrintExpr(Arg.$star());
    }
    if (Node.isStdInitListInitialization()) {
/* See above. */       ;
    } else if (Node.isListInitialization()) {
      OS.$out(/*KEEP_STR*/$RCURLY);
    } else {
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2000,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public void VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ Node) {
    // Nothing to print: we picked up the default argument.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2004,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public void VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ Node) {
    // Nothing to print: we picked up the default initializer.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2187,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitCXXDeleteExprEPN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitCXXDeleteExprEPN5clang13CXXDeleteExprE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(CXXDeleteExpr /*P*/ E) {
    if (E.isGlobalDelete()) {
      OS.$out(/*KEEP_STR*/$COLON_COLON);
    }
    OS.$out(/*KEEP_STR*/"delete ");
    if (E.isArrayForm()) {
      OS.$out(/*KEEP_STR*/"[] ");
    }
    PrintExpr(E.getArgument());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2259,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXDependentScopeMemberExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter32VisitCXXDependentScopeMemberExprEPN5clang27CXXDependentScopeMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter32VisitCXXDependentScopeMemberExprEPN5clang27CXXDependentScopeMemberExprE")
  //</editor-fold>
  public void VisitCXXDependentScopeMemberExpr(CXXDependentScopeMemberExpr /*P*/ Node) {
    if (!Node.isImplicitAccess()) {
      PrintExpr(Node.getBase());
      OS.$out((Node.isArrow() ? $ARROW : $DOT));
    }
    {
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    if (Node.hasTemplateKeyword()) {
      OS.$out(/*KEEP_STR*/"template ");
    }
    $out_raw_ostream_DeclarationNameInfo(OS, /*NO_COPY*/Node.getMemberNameInfo());
    if (Node.hasExplicitTemplateArgs()) {
      TemplateSpecializationType.PrintTemplateArgumentList2(OS, Node.template_arguments(), Policy);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2374,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXFoldExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitCXXFoldExprEPN5clang11CXXFoldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitCXXFoldExprEPN5clang11CXXFoldExprE")
  //</editor-fold>
  public void VisitCXXFoldExpr(CXXFoldExpr /*P*/ E) {
    OS.$out(/*KEEP_STR*/$LPAREN);
    if ((E.getLHS() != null)) {
      PrintExpr(E.getLHS());
      OS.$out(/*KEEP_STR*/$SPACE).$out(BinaryOperator.getOpcodeStr(E.getOperator())).$out(/*KEEP_STR*/$SPACE);
    }
    OS.$out(/*KEEP_STR*/$ELLIPSIS);
    if ((E.getRHS() != null)) {
      OS.$out(/*KEEP_STR*/$SPACE).$out(BinaryOperator.getOpcodeStr(E.getOperator())).$out(/*KEEP_STR*/$SPACE);
      PrintExpr(E.getRHS());
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2230,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXInheritedCtorInitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter29VisitCXXInheritedCtorInitExprEPN5clang24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter29VisitCXXInheritedCtorInitExprEPN5clang24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public void VisitCXXInheritedCtorInitExpr(CXXInheritedCtorInitExpr /*P*/ E) {
    // Parens are printed by the surrounding context.
    OS.$out(/*KEEP_STR*/"<forwarded>");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2148,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitCXXNewExprEPN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitCXXNewExprEPN5clang10CXXNewExprE")
  //</editor-fold>
  public void VisitCXXNewExpr(CXXNewExpr /*P*/ E) {
    if (E.isGlobalNew()) {
      OS.$out(/*KEEP_STR*/$COLON_COLON);
    }
    OS.$out(/*KEEP_STR*/"new ");
    /*uint*/int NumPlace = E.getNumPlacementArgs();
    if ($greater_uint(NumPlace, 0) && !isa_CXXDefaultArgExpr(E.getPlacementArg(0))) {
      OS.$out(/*KEEP_STR*/$LPAREN);
      PrintExpr(E.getPlacementArg(0));
      for (/*uint*/int i = 1; $less_uint(i, NumPlace); ++i) {
        if (isa_CXXDefaultArgExpr(E.getPlacementArg(i))) {
          break;
        }
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        PrintExpr(E.getPlacementArg(i));
      }
      OS.$out(/*KEEP_STR*/") ");
    }
    if (E.isParenTypeId()) {
      OS.$out(/*KEEP_STR*/$LPAREN);
    }
    std.string TypeS/*J*/= new std.string();
    {
      Expr /*P*/ Size = E.getArraySize();
      if ((Size != null)) {
        raw_string_ostream s = null;
        try {
          s/*J*/= new raw_string_ostream(TypeS);
          s.$out_char($$LSQUARE);
          Size.printPretty(s, Helper, Policy);
          s.$out_char($$RSQUARE);
        } finally {
          if (s != null) { s.$destroy(); }
        }
      }
    }
    E.getAllocatedType().print(OS, Policy, new Twine(TypeS));
    if (E.isParenTypeId()) {
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
    
    CXXNewExpr.InitializationStyle InitStyle = E.getInitializationStyle();
    if ((InitStyle.getValue() != 0)) {
      if (InitStyle == CXXNewExpr.InitializationStyle.CallInit) {
        OS.$out(/*KEEP_STR*/$LPAREN);
      }
      PrintExpr(E.getInitializer());
      if (InitStyle == CXXNewExpr.InitializationStyle.CallInit) {
        OS.$out(/*KEEP_STR*/$RPAREN);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2341,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXNoexceptExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitCXXNoexceptExprEPN5clang15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitCXXNoexceptExprEPN5clang15CXXNoexceptExprE")
  //</editor-fold>
  public void VisitCXXNoexceptExpr(CXXNoexceptExpr /*P*/ E) {
    OS.$out(/*KEEP_STR*/"noexcept(");
    PrintExpr(E.getOperand());
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1983,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXNullPtrLiteralExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitCXXNullPtrLiteralExprEPN5clang21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitCXXNullPtrLiteralExprEPN5clang21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public void VisitCXXNullPtrLiteralExpr(CXXNullPtrLiteralExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$nullptr);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2196,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXPseudoDestructorExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter28VisitCXXPseudoDestructorExprEPN5clang23CXXPseudoDestructorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter28VisitCXXPseudoDestructorExprEPN5clang23CXXPseudoDestructorExprE")
  //</editor-fold>
  public void VisitCXXPseudoDestructorExpr(CXXPseudoDestructorExpr /*P*/ E) {
    PrintExpr(E.getBase());
    if (E.isArrow()) {
      OS.$out(/*KEEP_STR*/$ARROW);
    } else {
      OS.$out_char($$DOT);
    }
    if ((E.getQualifier() != null)) {
      E.getQualifier().print(OS, Policy);
    }
    OS.$out(/*KEEP_STR*/$TILDE);
    {
      
      IdentifierInfo /*P*/ II = E.getDestroyedTypeIdentifier();
      if ((II != null)) {
        OS.$out(II.getName());
      } else {
        E.getDestroyedType().print(OS, Policy);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2140,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXScalarValueInitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitCXXScalarValueInitExprEPN5clang22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitCXXScalarValueInitExprEPN5clang22CXXScalarValueInitExprE")
  //</editor-fold>
  public void VisitCXXScalarValueInitExpr(CXXScalarValueInitExpr /*P*/ Node) {
    {
      TypeSourceInfo /*P*/ TSInfo = Node.getTypeSourceInfo();
      if ((TSInfo != null)) {
        TSInfo.getType().print(OS, Policy);
      } else {
        Node.getType().print(OS, Policy);
      }
    }
    OS.$out(/*KEEP_STR*/$LPAREN_RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2235,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXStdInitializerListExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter30VisitCXXStdInitializerListExprEPN5clang25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter30VisitCXXStdInitializerListExprEPN5clang25CXXStdInitializerListExprE")
  //</editor-fold>
  public void VisitCXXStdInitializerListExpr(CXXStdInitializerListExpr /*P*/ E) {
    PrintExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1987,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitCXXThisExprEPN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitCXXThisExprEPN5clang11CXXThisExprE")
  //</editor-fold>
  public void VisitCXXThisExpr(CXXThisExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$this);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1991,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitCXXThrowExprEPN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitCXXThrowExprEPN5clang12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(CXXThrowExpr /*P*/ Node) {
    if (!(Node.getSubExpr() != null)) {
      OS.$out(/*KEEP_STR*/$throw);
    } else {
      OS.$out(/*KEEP_STR*/"throw ");
      PrintExpr(Node.getSubExpr());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1894,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXTypeidExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitCXXTypeidExprEPN5clang13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitCXXTypeidExprEPN5clang13CXXTypeidExprE")
  //</editor-fold>
  public void VisitCXXTypeidExpr(CXXTypeidExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"typeid(");
    if (Node.isTypeOperand()) {
      Node.getTypeOperandSourceInfo().getType().print(OS, Policy);
    } else {
      PrintExpr(Node.getExprOperand());
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2244,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXUnresolvedConstructExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter31VisitCXXUnresolvedConstructExprEPN5clang26CXXUnresolvedConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter31VisitCXXUnresolvedConstructExprEPN5clang26CXXUnresolvedConstructExprE")
  //</editor-fold>
  public void VisitCXXUnresolvedConstructExpr(CXXUnresolvedConstructExpr /*P*/ Node) {
    Node.getTypeAsWritten().print(OS, Policy);
    OS.$out(/*KEEP_STR*/$LPAREN);
    for (type$ptr<Expr /*P*/ /*P*/> Arg = $tryClone(Node.arg_begin()), 
        /*P*/ /*P*/ ArgEnd = $tryClone(Node.arg_end());
         $noteq_ptr(Arg, ArgEnd); Arg.$preInc()) {
      if ($noteq_ptr(Arg, Node.arg_begin())) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      PrintExpr(Arg.$star());
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1904,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXUuidofExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitCXXUuidofExprEPN5clang13CXXUuidofExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitCXXUuidofExprEPN5clang13CXXUuidofExprE")
  //</editor-fold>
  public void VisitCXXUuidofExpr(CXXUuidofExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__uuidof(");
    if (Node.isTypeOperand()) {
      Node.getTypeOperandSourceInfo().getType().print(OS, Policy);
    } else {
      PrintExpr(Node.getExprOperand());
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1539,
   FQN="(anonymous namespace)::StmtPrinter::VisitCallExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ Call) {
    PrintExpr(Call.getCallee());
    OS.$out(/*KEEP_STR*/$LPAREN);
    PrintCallArgs(Call);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1861,
   FQN="(anonymous namespace)::StmtPrinter::VisitCUDAKernelCallExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitCUDAKernelCallExprEPN5clang18CUDAKernelCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitCUDAKernelCallExprEPN5clang18CUDAKernelCallExprE")
  //</editor-fold>
  public void VisitCUDAKernelCallExpr(CUDAKernelCallExpr /*P*/ Node) {
    PrintExpr(Node.getCallee());
    OS.$out(/*KEEP_STR*/$LT_LT_LT);
    PrintCallArgs(Node.getConfig());
    OS.$out(/*KEEP_STR*/">>>(");
    PrintCallArgs(Node);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1851,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXMemberCallExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitCXXMemberCallExprEPN5clang17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitCXXMemberCallExprEPN5clang17CXXMemberCallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(CXXMemberCallExpr /*P*/ Node) {
    // If we have a conversion operator call only print the argument.
    CXXMethodDecl /*P*/ MD = Node.getMethodDecl();
    if ((MD != null) && isa_CXXConversionDecl(MD)) {
      PrintExpr(Node.getImplicitObjectArgument());
      return;
    }
    VisitCallExpr(cast_CallExpr(Node));
  }

  
  // C++
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1805,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXOperatorCallExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitCXXOperatorCallExprEPN5clang19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitCXXOperatorCallExprEPN5clang19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(CXXOperatorCallExpr /*P*/ Node) {
    type$ptr</*const*/char$ptr/*char P*/ /*[45]*/> OpStrings = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*45*/] {
      $EMPTY, 
      $new, 
      $delete, 
      $new_LSQUARE_RSQUARE, 
      $delete_LSQUARE_RSQUARE, 
      $PLUS, 
      $MINUS, 
      $STAR, 
      $SLASH, 
      $PERCENT, 
      $CARET, 
      $AMP, 
      $PIPE, 
      $TILDE, 
      $EXCLAIM, 
      $EQ, 
      $LT, 
      $GT, 
      $PLUS_EQ, 
      $MINUS_EQ, 
      $STAR_EQ, 
      $SLASH_EQ, 
      $PERCENT_EQ, 
      $CARET_EQ, 
      $AMP_EQ, 
      $PIPE_EQ, 
      $LT_LT, 
      $GT_GT, 
      $LT_LT_EQ, 
      $GT_GT_EQ, 
      $EQ_EQ, 
      $EXCLAIM_EQ, 
      $LT_EQ, 
      $GT_EQ, 
      $AMP_AMP, 
      $PIPE_PIPE, 
      $PLUS_PLUS, 
      $MINUS_MINUS, 
      $COMMA, 
      $ARROW_STAR, 
      $ARROW, 
      $LPAREN_RPAREN, 
      $LSQUARE_RSQUARE, 
      // ?: can *not* be overloaded, but we need the overload
      // resolution machinery for it.
      $QMARK, 
      $co_await
    });
    
    OverloadedOperatorKind Kind = Node.getOperator();
    if (Kind == OverloadedOperatorKind.OO_PlusPlus || Kind == OverloadedOperatorKind.OO_MinusMinus) {
      if (Node.getNumArgs() == 1) {
        OS.$out(OpStrings.$at(Kind.getValue())).$out_char($$SPACE);
        PrintExpr(Node.getArg(0));
      } else {
        PrintExpr(Node.getArg(0));
        OS.$out_char($$SPACE).$out(OpStrings.$at(Kind.getValue()));
      }
    } else if (Kind == OverloadedOperatorKind.OO_Arrow) {
      PrintExpr(Node.getArg(0));
    } else if (Kind == OverloadedOperatorKind.OO_Call) {
      PrintExpr(Node.getArg(0));
      OS.$out_char($$LPAREN);
      for (/*uint*/int ArgIdx = 1; $less_uint(ArgIdx, Node.getNumArgs()); ++ArgIdx) {
        if ($greater_uint(ArgIdx, 1)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        if (!isa_CXXDefaultArgExpr(Node.getArg(ArgIdx))) {
          PrintExpr(Node.getArg(ArgIdx));
        }
      }
      OS.$out_char($$RPAREN);
    } else if (Kind == OverloadedOperatorKind.OO_Subscript) {
      PrintExpr(Node.getArg(0));
      OS.$out_char($$LSQUARE);
      PrintExpr(Node.getArg(1));
      OS.$out_char($$RSQUARE);
    } else if (Node.getNumArgs() == 1) {
      OS.$out(OpStrings.$at(Kind.getValue())).$out_char($$SPACE);
      PrintExpr(Node.getArg(0));
    } else if (Node.getNumArgs() == 2) {
      PrintExpr(Node.getArg(0));
      OS.$out_char($$SPACE).$out(OpStrings.$at(Kind.getValue())).$out_char($$SPACE);
      PrintExpr(Node.getArg(1));
    } else {
      throw new llvm_unreachable("unknown overloaded operator");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitUserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1933,
   FQN="(anonymous namespace)::StmtPrinter::VisitUserDefinedLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitUserDefinedLiteralEPN5clang18UserDefinedLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitUserDefinedLiteralEPN5clang18UserDefinedLiteralE")
  //</editor-fold>
  public void VisitUserDefinedLiteral(UserDefinedLiteral /*P*/ Node) {
    switch (Node.getLiteralOperatorKind()) {
     case LOK_Raw:
      OS.$out(cast_StringLiteral(Node.getArg(0).IgnoreImpCasts()).getString());
      break;
     case LOK_Template:
      {
        DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(Node.getCallee().IgnoreImpCasts());
        /*const*/ TemplateArgumentList /*P*/ Args = cast_FunctionDecl(DRE.getDecl()).getTemplateSpecializationArgs();
        assert Native.$bool(Args);
        if (Args.size() != 1) {
          OS.$out(/*KEEP_STR*/"operator\"\"").$out(Node.getUDSuffix().getName());
          TemplateSpecializationType.PrintTemplateArgumentList1(OS, Args.asArray(), Policy);
          OS.$out(/*KEEP_STR*/$LPAREN_RPAREN);
          return;
        }
        
        final /*const*/ TemplateArgument /*&*/ Pack = Args.get(0);
        for (final /*const*/ TemplateArgument /*&*/ P : Pack.pack_elements()) {
          /*char*/byte C = (/*char*/byte)$ulong2char(P.getAsIntegral().getZExtValue());
          OS.$out_char(C);
        }
        break;
      }
     case LOK_Integer:
      {
        // Print integer literal without suffix.
        IntegerLiteral /*P*/ Int = cast_IntegerLiteral(Node.getCookedLiteral());
        OS.$out(Int.getValue().__toString(10, /*isSigned*/ false));
        break;
      }
     case LOK_Floating:
      {
        // Print floating literal without suffix.
        FloatingLiteral /*P*/ Float = cast_FloatingLiteral(Node.getCookedLiteral());
        PrintFloatingLiteral(OS, Float, /*PrintSuffix=*/ false);
        break;
      }
     case LOK_String:
     case LOK_Character:
      PrintExpr(Node.getCookedLiteral());
      break;
    }
    OS.$out(Node.getUDSuffix().getName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1579,
   FQN="(anonymous namespace)::StmtPrinter::VisitCStyleCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitCStyleCastExprEPN5clang14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitCStyleCastExprEPN5clang14CStyleCastExprE")
  //</editor-fold>
  public void VisitCStyleCastExpr(CStyleCastExpr /*P*/ Node) {
    OS.$out_char($$LPAREN);
    Node.getTypeAsWritten().print(OS, Policy);
    OS.$out_char($$RPAREN);
    PrintExpr(Node.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2008,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXFunctionalCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitCXXFunctionalCastExprEPN5clang21CXXFunctionalCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitCXXFunctionalCastExprEPN5clang21CXXFunctionalCastExprE")
  //</editor-fold>
  public void VisitCXXFunctionalCastExpr(CXXFunctionalCastExpr /*P*/ Node) {
    Node.getType().print(OS, Policy);
    // If there are no parens, this is list-initialization, and the braces are
    // part of the syntax of the inner construct.
    if (Node.getLParenLoc().isValid()) {
      OS.$out(/*KEEP_STR*/$LPAREN);
    }
    PrintExpr(Node.getSubExpr());
    if (Node.getLParenLoc().isValid()) {
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXConstCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1890,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXConstCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitCXXConstCastExprEPN5clang16CXXConstCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitCXXConstCastExprEPN5clang16CXXConstCastExprE")
  //</editor-fold>
  public void VisitCXXConstCastExpr(CXXConstCastExpr /*P*/ Node) {
    VisitCXXNamedCastExpr(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1882,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXDynamicCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitCXXDynamicCastExprEPN5clang18CXXDynamicCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitCXXDynamicCastExprEPN5clang18CXXDynamicCastExprE")
  //</editor-fold>
  public void VisitCXXDynamicCastExpr(CXXDynamicCastExpr /*P*/ Node) {
    VisitCXXNamedCastExpr(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1886,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXReinterpretCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitCXXReinterpretCastExprEPN5clang22CXXReinterpretCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitCXXReinterpretCastExprEPN5clang22CXXReinterpretCastExprE")
  //</editor-fold>
  public void VisitCXXReinterpretCastExpr(CXXReinterpretCastExpr /*P*/ Node) {
    VisitCXXNamedCastExpr(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1878,
   FQN="(anonymous namespace)::StmtPrinter::VisitCXXStaticCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitCXXStaticCastExprEPN5clang17CXXStaticCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitCXXStaticCastExprEPN5clang17CXXStaticCastExprE")
  //</editor-fold>
  public void VisitCXXStaticCastExpr(CXXStaticCastExpr /*P*/ Node) {
    VisitCXXNamedCastExpr(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2515,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCBridgedCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitObjCBridgedCastExprEPN5clang19ObjCBridgedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitObjCBridgedCastExprEPN5clang19ObjCBridgedCastExprE")
  //</editor-fold>
  public void VisitObjCBridgedCastExpr(ObjCBridgedCastExpr /*P*/ E) {
    OS.$out_char($$LPAREN).$out(E.getBridgeKindName());
    E.getType().print(OS, Policy);
    OS.$out_char($$RPAREN);
    PrintExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1591,
   FQN="(anonymous namespace)::StmtPrinter::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitImplicitCastExprEPN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitImplicitCastExprEPN5clang16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(ImplicitCastExpr /*P*/ Node) {
    // No need to print anything, simply forward to the subexpression.
    PrintExpr(Node.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1279,
   FQN="(anonymous namespace)::StmtPrinter::VisitCharacterLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitCharacterLiteralEPN5clang16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitCharacterLiteralEPN5clang16CharacterLiteralE")
  //</editor-fold>
  public void VisitCharacterLiteral(CharacterLiteral /*P*/ Node) {
    /*uint*/int value = Node.getValue();
    switch (Node.getKind()) {
     case Ascii:
      break; // no prefix.
     case Wide:
      OS.$out_char($$L);
      break;
     case UTF8:
      OS.$out(/*KEEP_STR*/"u8");
      break;
     case UTF16:
      OS.$out_char($$u);
      break;
     case UTF32:
      OS.$out_char($$U);
      break;
    }
    switch (value) {
     case '\\':
      OS.$out(/*KEEP_STR*/"'\\\\'");
      break;
     case '\'':
      OS.$out(/*KEEP_STR*/"'\\''");
      break;
     case 7: /* JAVA: in C++ '\a' stands for "bell"; it is absent in Java*/
      // TODO: K&R: the meaning of '\\a' is different in traditional C
      OS.$out(/*KEEP_STR*/"'\\a'");
      break;
     case '\b':
      OS.$out(/*KEEP_STR*/"'\\b'");
      break;
     case '\f':
      // Nonstandard escape sequence.
      /*case '\e':
      OS << "'\\e'";
      break;*/
      OS.$out(/*KEEP_STR*/"'\\f'");
      break;
     case '\n':
      OS.$out(/*KEEP_STR*/"'\\n'");
      break;
     case '\r':
      OS.$out(/*KEEP_STR*/"'\\r'");
      break;
     case '\t':
      OS.$out(/*KEEP_STR*/"'\\t'");
      break;
     case '\013'/*\v*/:
      OS.$out(/*KEEP_STR*/"'\\v'");
      break;
     default:
      // A character literal might be sign-extended, which
      // would result in an invalid \U escape sequence.
      // FIXME: multicharacter literals such as '\xFF\xFF\xFF\xFF'
      // are not correctly handled.
      if ((value & ~0xFF/*U*/) == ~0xFF/*U*/ && Node.getKind() == CharacterLiteral.CharacterKind.Ascii) {
        value &= 0xFF/*U*/;
      }
      if ($less_uint(value, 256) && isPrintable((/*uchar*/byte)$uint2uchar(value))) {
        OS.$out(/*KEEP_STR*/$SGL_QUOTE).$out_char((/*char*/byte)$uint2char(value)).$out(/*KEEP_STR*/$SGL_QUOTE);
      } else if ($less_uint(value, 256)) {
        OS.$out(/*KEEP_STR*/"'\\x").$out(llvm.format($("%02x"), value)).$out(/*KEEP_STR*/$SGL_QUOTE);
      } else if ($lesseq_uint(value, 0xFFFF)) {
        OS.$out(/*KEEP_STR*/"'\\u").$out(llvm.format($("%04x"), value)).$out(/*KEEP_STR*/$SGL_QUOTE);
      } else {
        OS.$out(/*KEEP_STR*/"'\\U").$out(llvm.format($("%08x"), value)).$out(/*KEEP_STR*/$SGL_QUOTE);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1631,
   FQN="(anonymous namespace)::StmtPrinter::VisitChooseExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitChooseExprEPN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitChooseExprEPN5clang10ChooseExprE")
  //</editor-fold>
  public void VisitChooseExpr(ChooseExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__builtin_choose_expr(");
    PrintExpr(Node.getCond());
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    PrintExpr(Node.getLHS());
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    PrintExpr(Node.getRHS());
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1585,
   FQN="(anonymous namespace)::StmtPrinter::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public void VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ Node) {
    OS.$out_char($$LPAREN);
    Node.getType().print(OS, Policy);
    OS.$out_char($$RPAREN);
    PrintExpr(Node.getInitializer());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1654,
   FQN="(anonymous namespace)::StmtPrinter::VisitConvertVectorExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitConvertVectorExprEPN5clang17ConvertVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitConvertVectorExprEPN5clang17ConvertVectorExprE")
  //</editor-fold>
  public void VisitConvertVectorExpr(ConvertVectorExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__builtin_convertvector(");
    PrintExpr(Node.getSrcExpr());
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    Node.getType().print(OS, Policy);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2403,
   FQN="(anonymous namespace)::StmtPrinter::VisitCoawaitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitCoawaitExprEPN5clang11CoawaitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitCoawaitExprEPN5clang11CoawaitExprE")
  //</editor-fold>
  public void VisitCoawaitExpr(CoawaitExpr /*P*/ S) {
    OS.$out(/*KEEP_STR*/"co_await ");
    PrintExpr(S.getOperand());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2408,
   FQN="(anonymous namespace)::StmtPrinter::VisitCoyieldExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitCoyieldExprEPN5clang11CoyieldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitCoyieldExprEPN5clang11CoyieldExprE")
  //</editor-fold>
  public void VisitCoyieldExpr(CoyieldExpr /*P*/ S) {
    OS.$out(/*KEEP_STR*/"co_yield ");
    PrintExpr(S.getOperand());
  }

  
  //===----------------------------------------------------------------------===//
  //  Expr printing methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1205,
   FQN="(anonymous namespace)::StmtPrinter::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ Node) {
    {
      OMPCapturedExprDecl /*P*/ OCED = dyn_cast_OMPCapturedExprDecl(Node.getDecl());
      if ((OCED != null)) {
        OCED.getInit().IgnoreImpCasts().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        return;
      }
    }
    {
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    if (Node.hasTemplateKeyword()) {
      OS.$out(/*KEEP_STR*/"template ");
    }
    $out_raw_ostream_DeclarationNameInfo(OS, Node.getNameInfo());
    if (Node.hasExplicitTemplateArgs()) {
      TemplateSpecializationType.PrintTemplateArgumentList2(OS, Node.template_arguments(), Policy);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1220,
   FQN="(anonymous namespace)::StmtPrinter::VisitDependentScopeDeclRefExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter30VisitDependentScopeDeclRefExprEPN5clang25DependentScopeDeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter30VisitDependentScopeDeclRefExprEPN5clang25DependentScopeDeclRefExprE")
  //</editor-fold>
  public void VisitDependentScopeDeclRefExpr(DependentScopeDeclRefExpr /*P*/ Node) {
    {
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    if (Node.hasTemplateKeyword()) {
      OS.$out(/*KEEP_STR*/"template ");
    }
    $out_raw_ostream_DeclarationNameInfo(OS, /*NO_COPY*/Node.getNameInfo());
    if (Node.hasExplicitTemplateArgs()) {
      TemplateSpecializationType.PrintTemplateArgumentList2(OS, Node.template_arguments(), Policy);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1688,
   FQN="(anonymous namespace)::StmtPrinter::VisitDesignatedInitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitDesignatedInitExprEPN5clang18DesignatedInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitDesignatedInitExprEPN5clang18DesignatedInitExprE")
  //</editor-fold>
  public void VisitDesignatedInitExpr(DesignatedInitExpr /*P*/ Node) {
    boolean NeedsEquals = true;
    for (final /*const*/ DesignatedInitExpr.Designator /*&*/ D : Node.designators()) {
      if (D.isFieldDesignator()) {
        if (D.getDotLoc().isInvalid()) {
          {
            IdentifierInfo /*P*/ II = D.getFieldName();
            if ((II != null)) {
              OS.$out(II.getName()).$out(/*KEEP_STR*/$COLON);
              NeedsEquals = false;
            }
          }
        } else {
          OS.$out(/*KEEP_STR*/$DOT).$out(D.getFieldName().getName());
        }
      } else {
        OS.$out(/*KEEP_STR*/$LSQUARE);
        if (D.isArrayDesignator()) {
          PrintExpr(Node.getArrayIndex(D));
        } else {
          PrintExpr(Node.getArrayRangeStart(D));
          OS.$out(/*KEEP_STR*/" ... ");
          PrintExpr(Node.getArrayRangeEnd(D));
        }
        OS.$out(/*KEEP_STR*/$RSQUARE);
      }
    }
    if (NeedsEquals) {
      OS.$out(/*KEEP_STR*/" = ");
    } else {
      OS.$out(/*KEEP_STR*/$SPACE);
    }
    PrintExpr(Node.getInit());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1720,
   FQN="(anonymous namespace)::StmtPrinter::VisitDesignatedInitUpdateExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter29VisitDesignatedInitUpdateExprEPN5clang24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter29VisitDesignatedInitUpdateExprEPN5clang24DesignatedInitUpdateExprE")
  //</editor-fold>
  public void VisitDesignatedInitUpdateExpr(DesignatedInitUpdateExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$LCURLY);
    OS.$out(/*KEEP_STR*/"/*base*/");
    PrintExpr(Node.getBase());
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    
    OS.$out(/*KEEP_STR*/"/*updater*/");
    PrintExpr(Node.getUpdater());
    OS.$out(/*KEEP_STR*/$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2239,
   FQN="(anonymous namespace)::StmtPrinter::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public void VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    // Just forward to the subexpression.
    PrintExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2335,
   FQN="(anonymous namespace)::StmtPrinter::VisitExpressionTraitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitExpressionTraitExprEPN5clang19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitExpressionTraitExprEPN5clang19ExpressionTraitExprE")
  //</editor-fold>
  public void VisitExpressionTraitExpr(ExpressionTraitExpr /*P*/ E) {
    OS.$out(getExpressionTraitName(E.getTrait())).$out_char($$LPAREN);
    PrintExpr(E.getQueriedExpression());
    OS.$out_char($$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1574,
   FQN="(anonymous namespace)::StmtPrinter::VisitExtVectorElementExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitExtVectorElementExprEPN5clang20ExtVectorElementExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitExtVectorElementExprEPN5clang20ExtVectorElementExprE")
  //</editor-fold>
  public void VisitExtVectorElementExpr(ExtVectorElementExpr /*P*/ Node) {
    PrintExpr(Node.getBase());
    OS.$out(/*KEEP_STR*/$DOT);
    OS.$out(Node.getAccessor().getName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1384,
   FQN="(anonymous namespace)::StmtPrinter::VisitFloatingLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitFloatingLiteralEPN5clang15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitFloatingLiteralEPN5clang15FloatingLiteralE")
  //</editor-fold>
  public void VisitFloatingLiteral(FloatingLiteral /*P*/ Node) {
    PrintFloatingLiteral(OS, Node, /*PrintSuffix=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2366,
   FQN="(anonymous namespace)::StmtPrinter::VisitFunctionParmPackExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitFunctionParmPackExprEPN5clang20FunctionParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitFunctionParmPackExprEPN5clang20FunctionParmPackExprE")
  //</editor-fold>
  public void VisitFunctionParmPackExpr(FunctionParmPackExpr /*P*/ E) {
    $out_raw_ostream_NamedDecl$C(OS, $Deref(E.getParameterPack()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1641,
   FQN="(anonymous namespace)::StmtPrinter::VisitGNUNullExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitGNUNullExprEPN5clang11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitGNUNullExprEPN5clang11GNUNullExprE")
  //</editor-fold>
  public void VisitGNUNullExpr(GNUNullExpr /*P*/ $Prm0) {
    OS.$out(/*KEEP_STR*/$__null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1491,
   FQN="(anonymous namespace)::StmtPrinter::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE")
  //</editor-fold>
  public void VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"_Generic(");
    PrintExpr(Node.getControllingExpr());
    for (/*uint*/int i = 0; i != Node.getNumAssocs(); ++i) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      QualType T = Node.getAssocType(i);
      if (T.isNull()) {
        OS.$out(/*KEEP_STR*/$default);
      } else {
        T.print(OS, Policy);
      }
      OS.$out(/*KEEP_STR*/": ");
      PrintExpr(Node.getAssocExpr(i));
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1388,
   FQN="(anonymous namespace)::StmtPrinter::VisitImaginaryLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitImaginaryLiteralEPN5clang16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitImaginaryLiteralEPN5clang16ImaginaryLiteralE")
  //</editor-fold>
  public void VisitImaginaryLiteral(ImaginaryLiteral /*P*/ Node) {
    PrintExpr(Node.getSubExpr());
    OS.$out(/*KEEP_STR*/$i);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1736,
   FQN="(anonymous namespace)::StmtPrinter::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public void VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ Node) {
    if ((Node.getType().$arrow().getAsCXXRecordDecl() != null)) {
      OS.$out(/*KEEP_STR*/"/*implicit*/");
      Node.getType().print(OS, Policy);
      OS.$out(/*KEEP_STR*/$LPAREN_RPAREN);
    } else {
      OS.$out(/*KEEP_STR*/"/*implicit*/(");
      Node.getType().print(OS, Policy);
      OS.$out_char($$RPAREN);
      if (Node.getType().$arrow().isRecordType()) {
        OS.$out(/*KEEP_STR*/"{}");
      } else {
        OS.$out_int(0);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1662,
   FQN="(anonymous namespace)::StmtPrinter::VisitInitListExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(InitListExpr /*P*/ Node) {
    if ((Node.getSyntacticForm() != null)) {
      Visit(Node.getSyntacticForm());
      return;
    }
    
    OS.$out(/*KEEP_STR*/$LCURLY);
    for (/*uint*/int i = 0, e = Node.getNumInits(); i != e; ++i) {
      if ((i != 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      if ((Node.getInit(i) != null)) {
        PrintExpr(Node.getInit(i));
      } else {
        OS.$out(/*KEEP_STR*/"{}");
      }
    }
    OS.$out(/*KEEP_STR*/$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1341,
   FQN="(anonymous namespace)::StmtPrinter::VisitIntegerLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitIntegerLiteralEPN5clang14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitIntegerLiteralEPN5clang14IntegerLiteralE")
  //</editor-fold>
  public void VisitIntegerLiteral(IntegerLiteral /*P*/ Node) {
    boolean isSigned = Node.getType().$arrow().isSignedIntegerType();
    OS.$out(Node.getValue().__toString(10, isSigned));
    
    // Emit suffixes.  Integer literals are always a builtin integer type.
    switch (Node.getType().$arrow().getAs$BuiltinType().getKind()) {
     default:
      throw new llvm_unreachable("Unexpected type for integer literal!");
     case Char_S:
     case Char_U:
      OS.$out(/*KEEP_STR*/"i8");
      break;
     case UChar:
      OS.$out(/*KEEP_STR*/"Ui8");
      break;
     case Short:
      OS.$out(/*KEEP_STR*/"i16");
      break;
     case UShort:
      OS.$out(/*KEEP_STR*/"Ui16");
      break;
     case Int:
      break; // no suffix.
     case UInt:
      OS.$out_char($$U);
      break;
     case Long:
      OS.$out_char($$L);
      break;
     case ULong:
      OS.$out(/*KEEP_STR*/$UL);
      break;
     case LongLong:
      OS.$out(/*KEEP_STR*/$LL);
      break;
     case ULongLong:
      OS.$out(/*KEEP_STR*/$ULL);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2048,
   FQN="(anonymous namespace)::StmtPrinter::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(LambdaExpr /*P*/ Node) {
    OS.$out_char($$LSQUARE);
    boolean NeedComma = false;
    switch (Node.getCaptureDefault()) {
     case LCD_None:
      break;
     case LCD_ByCopy:
      OS.$out_char($$EQ);
      NeedComma = true;
      break;
     case LCD_ByRef:
      OS.$out_char($$AMP);
      NeedComma = true;
      break;
    }
    for (type$ptr<LambdaCapture> C = $tryClone(Node.explicit_capture_begin()), 
        /*P*/ CEnd = $tryClone(Node.explicit_capture_end());
         $noteq_ptr(C, CEnd);
         C.$preInc()) {
      if (NeedComma) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      NeedComma = true;
      switch (C./*->*/$star().getCaptureKind()) {
       case LCK_This:
        OS.$out(/*KEEP_STR*/$this);
        break;
       case LCK_StarThis:
        OS.$out(/*KEEP_STR*/"*this");
        break;
       case LCK_ByRef:
        if (Node.getCaptureDefault() != LambdaCaptureDefault.LCD_ByRef || Node.isInitCapture(C.$star())) {
          OS.$out_char($$AMP);
        }
        OS.$out(C./*->*/$star().getCapturedVar().getName());
        break;
       case LCK_ByCopy:
        OS.$out(C./*->*/$star().getCapturedVar().getName());
        break;
       case LCK_VLAType:
        throw new llvm_unreachable("VLA type in explicit captures.");
      }
      if (Node.isInitCapture(C.$star())) {
        PrintExpr(C./*->*/$star().getCapturedVar().getInit());
      }
    }
    OS.$out_char($$RSQUARE);
    if (Node.hasExplicitParameters()) {
      OS.$out(/*KEEP_STR*/" (");
      CXXMethodDecl /*P*/ Method = Node.getCallOperator();
      NeedComma = false;
      for (ParmVarDecl /*P*/ P : Method.parameters()) {
        if (NeedComma) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        } else {
          NeedComma = true;
        }
        std.string ParamStr = P.getNameAsString();
        P.getOriginalType().print(OS, Policy, new Twine(ParamStr));
      }
      if (Method.isVariadic()) {
        if (NeedComma) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        OS.$out(/*KEEP_STR*/$ELLIPSIS);
      }
      OS.$out_char($$RPAREN);
      if (Node.isMutable()) {
        OS.$out(/*KEEP_STR*/" mutable");
      }
      
      /*const*/ FunctionProtoType /*P*/ Proto = Method.getType().$arrow().getAs(FunctionProtoType.class);
      Proto.printExceptionSpecification(OS, Policy);
      
      // FIXME: Attributes
      
      // Print the trailing return type if it was specified in the source.
      if (Node.hasExplicitResultType()) {
        OS.$out(/*KEEP_STR*/" -> ");
        Proto.getReturnType().print(OS, Policy);
      }
    }
    
    // Print the body.
    CompoundStmt /*P*/ Body = Node.getBody();
    OS.$out_char($$SPACE);
    PrintStmt(Body);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1914,
   FQN="(anonymous namespace)::StmtPrinter::VisitMSPropertyRefExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitMSPropertyRefExprEPN5clang17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitMSPropertyRefExprEPN5clang17MSPropertyRefExprE")
  //</editor-fold>
  public void VisitMSPropertyRefExpr(MSPropertyRefExpr /*P*/ Node) {
    PrintExpr(Node.getBaseExpr());
    if (Node.isArrow()) {
      OS.$out(/*KEEP_STR*/$ARROW);
    } else {
      OS.$out(/*KEEP_STR*/$DOT);
    }
    {
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifierLoc().getNestedNameSpecifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    $out_raw_ostream_DeclarationName(OS, Node.getPropertyDecl().getDeclName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1926,
   FQN="(anonymous namespace)::StmtPrinter::VisitMSPropertySubscriptExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter28VisitMSPropertySubscriptExprEPN5clang23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter28VisitMSPropertySubscriptExprEPN5clang23MSPropertySubscriptExprE")
  //</editor-fold>
  public void VisitMSPropertySubscriptExpr(MSPropertySubscriptExpr /*P*/ Node) {
    PrintExpr(Node.getBase());
    OS.$out(/*KEEP_STR*/$LSQUARE);
    PrintExpr(Node.getIdx());
    OS.$out(/*KEEP_STR*/$RSQUARE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2370,
   FQN="(anonymous namespace)::StmtPrinter::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter29VisitMaterializeTemporaryExprEPN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter29VisitMaterializeTemporaryExprEPN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(MaterializeTemporaryExpr /*P*/ Node) {
    PrintExpr(Node.GetTemporaryExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1545,
   FQN="(anonymous namespace)::StmtPrinter::VisitMemberExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ Node) {
    // FIXME: Suppress printing implicit bases (like "this")
    PrintExpr(Node.getBase());
    
    MemberExpr /*P*/ ParentMember = dyn_cast_MemberExpr(Node.getBase());
    FieldDecl /*P*/ ParentDecl = (ParentMember != null) ? dyn_cast_FieldDecl(ParentMember.getMemberDecl()) : null;
    if (!(ParentDecl != null) || !ParentDecl.isAnonymousStructOrUnion()) {
      OS.$out((Node.isArrow() ? $ARROW : $DOT));
    }
    {
      
      FieldDecl /*P*/ FD = dyn_cast_FieldDecl(Node.getMemberDecl());
      if ((FD != null)) {
        if (FD.isAnonymousStructOrUnion()) {
          return;
        }
      }
    }
    {
      
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    if (Node.hasTemplateKeyword()) {
      OS.$out(/*KEEP_STR*/"template ");
    }
    $out_raw_ostream_DeclarationNameInfo(OS, Node.getMemberNameInfo());
    if (Node.hasExplicitTemplateArgs()) {
      TemplateSpecializationType.PrintTemplateArgumentList2(OS, Node.template_arguments(), Policy);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitNoInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1732,
   FQN="(anonymous namespace)::StmtPrinter::VisitNoInitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitNoInitExprEPN5clang10NoInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitNoInitExprEPN5clang10NoInitExprE")
  //</editor-fold>
  public void VisitNoInitExpr(NoInitExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"/*no init*/");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1514,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPArraySectionExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPArraySectionExprEPN5clang19OMPArraySectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPArraySectionExprEPN5clang19OMPArraySectionExprE")
  //</editor-fold>
  public void VisitOMPArraySectionExpr(OMPArraySectionExpr /*P*/ Node) {
    PrintExpr(Node.getBase());
    OS.$out(/*KEEP_STR*/$LSQUARE);
    if ((Node.getLowerBound() != null)) {
      PrintExpr(Node.getLowerBound());
    }
    if (Node.getColonLoc().isValid()) {
      OS.$out(/*KEEP_STR*/$COLON);
      if ((Node.getLength() != null)) {
        PrintExpr(Node.getLength());
      }
    }
    OS.$out(/*KEEP_STR*/$RSQUARE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2425,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCArrayLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitObjCArrayLiteralEPN5clang16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitObjCArrayLiteralEPN5clang16ObjCArrayLiteralE")
  //</editor-fold>
  public void VisitObjCArrayLiteral(ObjCArrayLiteral /*P*/ E) {
    OS.$out(/*KEEP_STR*/"@[ ");
    iterator_range<Stmt/*P*/> Ch = E.children();
    for (StmtIterator I = ((StmtIterator)Ch.begin()), E$1 = ((StmtIterator)Ch.end()); I.$noteq(E$1); I.$preInc()) {
      if (I.$noteq(((StmtIterator)Ch.begin()))) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      Visit(I.$star());
    }
    OS.$out(/*KEEP_STR*/" ]");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 500,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAvailabilityCheckExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter30VisitObjCAvailabilityCheckExprEPN5clang25ObjCAvailabilityCheckExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter30VisitObjCAvailabilityCheckExprEPN5clang25ObjCAvailabilityCheckExprE")
  //</editor-fold>
  public void VisitObjCAvailabilityCheckExpr(ObjCAvailabilityCheckExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"@available(...)");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2506,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCBoolLiteralExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitObjCBoolLiteralExprEPN5clang19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitObjCBoolLiteralExprEPN5clang19ObjCBoolLiteralExprE")
  //</editor-fold>
  public void VisitObjCBoolLiteralExpr(ObjCBoolLiteralExpr /*P*/ Node) {
    OS.$out((Node.getValue() ? $__objc_yes : $__objc_no));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2420,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCBoxedExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitObjCBoxedExprEPN5clang13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitObjCBoxedExprEPN5clang13ObjCBoxedExprE")
  //</editor-fold>
  public void VisitObjCBoxedExpr(ObjCBoxedExpr /*P*/ E) {
    OS.$out(/*KEEP_STR*/$AT);
    Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2436,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCDictionaryLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitObjCDictionaryLiteralEPN5clang21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitObjCDictionaryLiteralEPN5clang21ObjCDictionaryLiteralE")
  //</editor-fold>
  public void VisitObjCDictionaryLiteral(ObjCDictionaryLiteral /*P*/ E) {
    OS.$out(/*KEEP_STR*/"@{ ");
    for (/*uint*/int I = 0, N = E.getNumElements(); I != N; ++I) {
      ObjCDictionaryElement Element = null;
      try {
        if ($greater_uint(I, 0)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        
        Element = E.getKeyValueElement(I);
        Visit(Element.Key);
        OS.$out(/*KEEP_STR*/" : ");
        Visit(Element.Value);
        if (Element.isPackExpansion()) {
          OS.$out(/*KEEP_STR*/$ELLIPSIS);
        }
      } finally {
        if (Element != null) { Element.$destroy(); }
      }
    }
    OS.$out(/*KEEP_STR*/" }");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2452,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCEncodeExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitObjCEncodeExprEPN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitObjCEncodeExprEPN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public void VisitObjCEncodeExpr(ObjCEncodeExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"@encode(");
    Node.getEncodedType().print(OS, Policy);
    OS.$out_char($$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2510,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCIndirectCopyRestoreExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter32VisitObjCIndirectCopyRestoreExprEPN5clang27ObjCIndirectCopyRestoreExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter32VisitObjCIndirectCopyRestoreExprEPN5clang27ObjCIndirectCopyRestoreExprE")
  //</editor-fold>
  public void VisitObjCIndirectCopyRestoreExpr(ObjCIndirectCopyRestoreExpr /*P*/ E) {
    PrintExpr(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1569,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCIsaExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitObjCIsaExprEPN5clang11ObjCIsaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitObjCIsaExprEPN5clang11ObjCIsaExprE")
  //</editor-fold>
  public void VisitObjCIsaExpr(ObjCIsaExpr /*P*/ Node) {
    PrintExpr(Node.getBase());
    OS.$out((Node.isArrow() ? $("->isa") : $(".isa")));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1243,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ Node) {
    if ((Node.getBase() != null)) {
      PrintExpr(Node.getBase());
      OS.$out((Node.isArrow() ? $ARROW : $DOT));
    }
    $out_raw_ostream_NamedDecl$C(OS, $Deref(Node.getDecl()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2468,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ Mess) {
    OS.$out(/*KEEP_STR*/$LSQUARE);
    switch (Mess.getReceiverKind()) {
     case Instance:
      PrintExpr(Mess.getInstanceReceiver());
      break;
     case Class:
      Mess.getClassReceiver().print(OS, Policy);
      break;
     case SuperInstance:
     case SuperClass:
      OS.$out(/*KEEP_STR*/"Super");
      break;
    }
    
    OS.$out_char($$SPACE);
    Selector selector = Mess.getSelector();
    if (selector.isUnarySelector()) {
      OS.$out(selector.getNameForSlot(0));
    } else {
      for (/*uint*/int i = 0, e = Mess.getNumArgs(); i != e; ++i) {
        if ($less_uint(i, selector.getNumArgs())) {
          if ($greater_uint(i, 0)) {
            OS.$out_char($$SPACE);
          }
          if ((selector.getIdentifierInfoForSlot(i) != null)) {
            OS.$out(selector.getIdentifierInfoForSlot(i).getName()).$out_char($$COLON);
          } else {
            OS.$out(/*KEEP_STR*/$COLON);
          }
        } else {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE); // Handle variadic methods.
        }
        
        PrintExpr(Mess.getArg(i));
      }
    }
    OS.$out(/*KEEP_STR*/$RSQUARE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1251,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE")
  //</editor-fold>
  public void VisitObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ Node) {
    if (Node.isSuperReceiver()) {
      OS.$out(/*KEEP_STR*/"super.");
    } else if (Node.isObjectReceiver() && (Node.getBase() != null)) {
      PrintExpr(Node.getBase());
      OS.$out(/*KEEP_STR*/$DOT);
    } else if (Node.isClassReceiver() && (Node.getClassReceiver() != null)) {
      OS.$out(Node.getClassReceiver().getName()).$out(/*KEEP_STR*/$DOT);
    }
    if (Node.isImplicitProperty()) {
      Node.getImplicitPropertyGetter().getSelector().print(OS);
    } else {
      OS.$out(Node.getExplicitProperty().getName());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2464,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCProtocolExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitObjCProtocolExprEPN5clang16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitObjCProtocolExprEPN5clang16ObjCProtocolExprE")
  //</editor-fold>
  public void VisitObjCProtocolExpr(ObjCProtocolExpr /*P*/ Node) {
    $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"@protocol("), $Deref(Node.getProtocol())).$out_char($$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2458,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCSelectorExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitObjCSelectorExprEPN5clang16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitObjCSelectorExprEPN5clang16ObjCSelectorExprE")
  //</editor-fold>
  public void VisitObjCSelectorExpr(ObjCSelectorExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"@selector(");
    Node.getSelector().print(OS);
    OS.$out_char($$RPAREN);
  }

  
  // Obj-C
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2415,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCStringLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitObjCStringLiteralEPN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitObjCStringLiteralEPN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public void VisitObjCStringLiteral(ObjCStringLiteral /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$AT);
    VisitStringLiteral(Node.getString());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1267,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCSubscriptRefExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitObjCSubscriptRefExprEPN5clang20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitObjCSubscriptRefExprEPN5clang20ObjCSubscriptRefExprE")
  //</editor-fold>
  public void VisitObjCSubscriptRefExpr(ObjCSubscriptRefExpr /*P*/ Node) {
    
    PrintExpr(Node.getBaseExpr());
    OS.$out(/*KEEP_STR*/$LSQUARE);
    PrintExpr(Node.getKeyExpr());
    OS.$out(/*KEEP_STR*/$RSQUARE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1427,
   FQN="(anonymous namespace)::StmtPrinter::VisitOffsetOfExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitOffsetOfExprEPN5clang12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitOffsetOfExprEPN5clang12OffsetOfExprE")
  //</editor-fold>
  public void VisitOffsetOfExpr(OffsetOfExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__builtin_offsetof(");
    Node.getTypeSourceInfo().getType().print(OS, Policy);
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    boolean PrintedSomething = false;
    for (/*uint*/int i = 0, n = Node.getNumComponents(); $less_uint(i, n); ++i) {
      OffsetOfNode ON = new OffsetOfNode(Node.getComponent(i));
      if (ON.getKind() == OffsetOfNode.Kind.Array) {
        // Array node
        OS.$out(/*KEEP_STR*/$LSQUARE);
        PrintExpr(Node.getIndexExpr(ON.getArrayExprIndex()));
        OS.$out(/*KEEP_STR*/$RSQUARE);
        PrintedSomething = true;
        continue;
      }
      
      // Skip implicit base indirections.
      if (ON.getKind() == OffsetOfNode.Kind.Base) {
        continue;
      }
      
      // Field or identifier node.
      IdentifierInfo /*P*/ Id = ON.getFieldName();
      if (!(Id != null)) {
        continue;
      }
      if (PrintedSomething) {
        OS.$out(/*KEEP_STR*/$DOT);
      } else {
        PrintedSomething = true;
      }
      OS.$out(Id.getName());
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2550,
   FQN="(anonymous namespace)::StmtPrinter::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ Node) {
    PrintExpr(Node.getSourceExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1232,
   FQN="(anonymous namespace)::StmtPrinter::VisitUnresolvedLookupExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitUnresolvedLookupExprEPN5clang20UnresolvedLookupExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitUnresolvedLookupExprEPN5clang20UnresolvedLookupExprE")
  //</editor-fold>
  public void VisitUnresolvedLookupExpr(UnresolvedLookupExpr /*P*/ Node) {
    if ((Node.getQualifier() != null)) {
      Node.getQualifier().print(OS, Policy);
    }
    if (Node.hasTemplateKeyword()) {
      OS.$out(/*KEEP_STR*/"template ");
    }
    $out_raw_ostream_DeclarationNameInfo(OS, /*NO_COPY*/Node.getNameInfo());
    if (Node.hasExplicitTemplateArgs()) {
      TemplateSpecializationType.PrintTemplateArgumentList2(OS, Node.template_arguments(), Policy);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2275,
   FQN="(anonymous namespace)::StmtPrinter::VisitUnresolvedMemberExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitUnresolvedMemberExprEPN5clang20UnresolvedMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitUnresolvedMemberExprEPN5clang20UnresolvedMemberExprE")
  //</editor-fold>
  public void VisitUnresolvedMemberExpr(UnresolvedMemberExpr /*P*/ Node) {
    if (!Node.isImplicitAccess()) {
      PrintExpr(Node.getBase());
      OS.$out((Node.isArrow() ? $ARROW : $DOT));
    }
    {
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    if (Node.hasTemplateKeyword()) {
      OS.$out(/*KEEP_STR*/"template ");
    }
    $out_raw_ostream_DeclarationNameInfo(OS, /*NO_COPY*/Node.getMemberNameInfo());
    if (Node.hasExplicitTemplateArgs()) {
      TemplateSpecializationType.PrintTemplateArgumentList2(OS, Node.template_arguments(), Policy);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitPackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2347,
   FQN="(anonymous namespace)::StmtPrinter::VisitPackExpansionExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitPackExpansionExprEPN5clang17PackExpansionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitPackExpansionExprEPN5clang17PackExpansionExprE")
  //</editor-fold>
  public void VisitPackExpansionExpr(PackExpansionExpr /*P*/ E) {
    PrintExpr(E.getPattern());
    OS.$out(/*KEEP_STR*/$ELLIPSIS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1396,
   FQN="(anonymous namespace)::StmtPrinter::VisitParenExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(ParenExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$LPAREN);
    PrintExpr(Node.getSubExpr());
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1679,
   FQN="(anonymous namespace)::StmtPrinter::VisitParenListExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitParenListExprEPN5clang13ParenListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitParenListExprEPN5clang13ParenListExprE")
  //</editor-fold>
  public void VisitParenListExpr(ParenListExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/$LPAREN);
    for (/*uint*/int i = 0, e = Node.getNumExprs(); i != e; ++i) {
      if ((i != 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      PrintExpr(Node.getExpr(i));
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1275,
   FQN="(anonymous namespace)::StmtPrinter::VisitPredefinedExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitPredefinedExprEPN5clang14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitPredefinedExprEPN5clang14PredefinedExprE")
  //</editor-fold>
  public void VisitPredefinedExpr(PredefinedExpr /*P*/ Node) {
    OS.$out(PredefinedExpr.getIdentTypeName(Node.getIdentType()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1760,
   FQN="(anonymous namespace)::StmtPrinter::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ Node) {
    PrintExpr(Node.getSyntacticForm());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1645,
   FQN="(anonymous namespace)::StmtPrinter::VisitShuffleVectorExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitShuffleVectorExprEPN5clang17ShuffleVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitShuffleVectorExprEPN5clang17ShuffleVectorExprE")
  //</editor-fold>
  public void VisitShuffleVectorExpr(ShuffleVectorExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__builtin_shufflevector(");
    for (/*uint*/int i = 0, e = Node.getNumSubExprs(); i != e; ++i) {
      if ((i != 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      PrintExpr(Node.getExpr(i));
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2352,
   FQN="(anonymous namespace)::StmtPrinter::VisitSizeOfPackExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitSizeOfPackExprEPN5clang14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitSizeOfPackExprEPN5clang14SizeOfPackExprE")
  //</editor-fold>
  public void VisitSizeOfPackExpr(SizeOfPackExpr /*P*/ E) {
    $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"sizeof...("), $Deref(E.getPack())).$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1625,
   FQN="(anonymous namespace)::StmtPrinter::VisitStmtExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitStmtExprEPN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitStmtExprEPN5clang8StmtExprE")
  //</editor-fold>
  public void VisitStmtExpr(StmtExpr /*P*/ E) {
    OS.$out(/*KEEP_STR*/$LPAREN);
    PrintRawCompoundStmt(E.getSubStmt());
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1393,
   FQN="(anonymous namespace)::StmtPrinter::VisitStringLiteral", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitStringLiteralEPN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitStringLiteralEPN5clang13StringLiteralE")
  //</editor-fold>
  public void VisitStringLiteral(StringLiteral /*P*/ Str) {
    Str.outputString(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2361,
   FQN="(anonymous namespace)::StmtPrinter::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ Node) {
    Visit(Node.getReplacement());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2356,
   FQN="(anonymous namespace)::StmtPrinter::VisitSubstNonTypeTemplateParmPackExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter37VisitSubstNonTypeTemplateParmPackExprEPN5clang32SubstNonTypeTemplateParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter37VisitSubstNonTypeTemplateParmPackExprEPN5clang32SubstNonTypeTemplateParmPackExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmPackExpr(SubstNonTypeTemplateParmPackExpr /*P*/ Node) {
    $out_raw_ostream_NamedDecl$C(OS, $Deref(Node.getParameterPack()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2319,
   FQN="(anonymous namespace)::StmtPrinter::VisitTypeTraitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitTypeTraitExprEPN5clang13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitTypeTraitExprEPN5clang13TypeTraitExprE")
  //</editor-fold>
  public void VisitTypeTraitExpr(TypeTraitExpr /*P*/ E) {
    OS.$out(getTypeTraitName_TypeTrait(E.getTrait())).$out(/*KEEP_STR*/$LPAREN);
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I) {
      if ($greater_uint(I, 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      E.getArg(I).getType().print(OS, Policy);
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2554,
   FQN="(anonymous namespace)::StmtPrinter::VisitTypoExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitTypoExprEPN5clang8TypoExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitTypoExprEPN5clang8TypoExprE")
  //</editor-fold>
  public void VisitTypoExpr(TypoExpr /*P*/ Node) {
    // TODO: Print something reasonable for a TypoExpr, if necessary.
    throw new llvm_unreachable("Cannot print TypoExpr nodes");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1461,
   FQN="(anonymous namespace)::StmtPrinter::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ Node) {
    switch (Node.getKind()) {
     case UETT_SizeOf:
      OS.$out(/*KEEP_STR*/$sizeof);
      break;
     case UETT_AlignOf:
      if (Policy.Alignof) {
        OS.$out(/*KEEP_STR*/$alignof);
      } else if (Policy.UnderscoreAlignof) {
        OS.$out(/*KEEP_STR*/$_Alignof);
      } else {
        OS.$out(/*KEEP_STR*/$__alignof);
      }
      break;
     case UETT_VecStep:
      OS.$out(/*KEEP_STR*/$vec_step);
      break;
     case UETT_OpenMPRequiredSimdAlign:
      OS.$out(/*KEEP_STR*/$__builtin_omp_required_simd_align);
      break;
    }
    if (Node.isArgumentType()) {
      OS.$out_char($$LPAREN);
      Node.getArgumentType().print(OS, Policy);
      OS.$out_char($$RPAREN);
    } else {
      OS.$out(/*KEEP_STR*/$SPACE);
      PrintExpr(Node.getArgumentExpr());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1401,
   FQN="(anonymous namespace)::StmtPrinter::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ Node) {
    if (!Node.isPostfix()) {
      OS.$out(UnaryOperator.getOpcodeStr(Node.getOpcode()));
      
      // Print a space if this is an "identifier operator" like __real, or if
      // it might be concatenated incorrectly like '+'.
      switch (Node.getOpcode()) {
       default:
        break;
       case UO_Real:
       case UO_Imag:
       case UO_Extension:
        OS.$out_char($$SPACE);
        break;
       case UO_Plus:
       case UO_Minus:
        if (isa_UnaryOperator(Node.getSubExpr())) {
          OS.$out_char($$SPACE);
        }
        break;
      }
    }
    PrintExpr(Node.getSubExpr());
    if (Node.isPostfix()) {
      OS.$out(UnaryOperator.getOpcodeStr(Node.getOpcode()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1752,
   FQN="(anonymous namespace)::StmtPrinter::VisitVAArgExpr", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitVAArgExprEPN5clang9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitVAArgExprEPN5clang9VAArgExprE")
  //</editor-fold>
  public void VisitVAArgExpr(VAArgExpr /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"__builtin_va_arg(");
    PrintExpr(Node.getSubExpr());
    OS.$out(/*KEEP_STR*/$COMMA_SPACE);
    Node.getType().print(OS, Policy);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 265,
   FQN="(anonymous namespace)::StmtPrinter::VisitForStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter12VisitForStmtEPN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter12VisitForStmtEPN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(ForStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"for (");
    if ((Node.getInit() != null)) {
      {
        DeclStmt /*P*/ DS = dyn_cast_DeclStmt(Node.getInit());
        if ((DS != null)) {
          PrintRawDeclStmt(DS);
        } else {
          PrintExpr(cast_Expr(Node.getInit()));
        }
      }
    }
    OS.$out(/*KEEP_STR*/$SEMI);
    if ((Node.getCond() != null)) {
      OS.$out(/*KEEP_STR*/$SPACE);
      PrintExpr(Node.getCond());
    }
    OS.$out(/*KEEP_STR*/$SEMI);
    if ((Node.getInc() != null)) {
      OS.$out(/*KEEP_STR*/$SPACE);
      PrintExpr(Node.getInc());
    }
    OS.$out(/*KEEP_STR*/") ");
    {
      
      CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Node.getBody());
      if ((CS != null)) {
        PrintRawCompoundStmt(CS);
        OS.$out(/*KEEP_STR*/$LF);
      } else {
        OS.$out(/*KEEP_STR*/$LF);
        PrintStmt(Node.getBody());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 342,
   FQN="(anonymous namespace)::StmtPrinter::VisitGotoStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitGotoStmtEPN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitGotoStmtEPN5clang8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(GotoStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"goto ").$out(Node.getLabel().getName()).$out(/*KEEP_STR*/$SEMI);
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 215,
   FQN="(anonymous namespace)::StmtPrinter::VisitIfStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter11VisitIfStmtEPN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter11VisitIfStmtEPN5clang6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(IfStmt /*P*/ If) {
    Indent();
    PrintRawIfStmt(If);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 347,
   FQN="(anonymous namespace)::StmtPrinter::VisitIndirectGotoStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitIndirectGotoStmtEPN5clang16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitIndirectGotoStmtEPN5clang16IndirectGotoStmtE")
  //</editor-fold>
  public void VisitIndirectGotoStmt(IndirectGotoStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"goto *");
    PrintExpr(Node.getTarget());
    OS.$out(/*KEEP_STR*/$SEMI);
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 167,
   FQN="(anonymous namespace)::StmtPrinter::VisitLabelStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitLabelStmtEPN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitLabelStmtEPN5clang9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(LabelStmt /*P*/ Node) {
    Indent(-1).$out(Node.getName()).$out(/*KEEP_STR*/$COLON_LF);
    PrintStmt(Node.getSubStmt(), 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 326,
   FQN="(anonymous namespace)::StmtPrinter::VisitMSDependentExistsStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitMSDependentExistsStmtEPN5clang21MSDependentExistsStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitMSDependentExistsStmtEPN5clang21MSDependentExistsStmtE")
  //</editor-fold>
  public void VisitMSDependentExistsStmt(MSDependentExistsStmt /*P*/ Node) {
    Indent();
    if (Node.isIfExists()) {
      OS.$out(/*KEEP_STR*/"__if_exists (");
    } else {
      OS.$out(/*KEEP_STR*/"__if_not_exists (");
    }
    {
      
      NestedNameSpecifier /*P*/ Qualifier = Node.getQualifierLoc().getNestedNameSpecifier();
      if ((Qualifier != null)) {
        Qualifier.print(OS, Policy);
      }
    }
    
    $out_raw_ostream_DeclarationNameInfo(OS, Node.getNameInfo()).$out(/*KEEP_STR*/") ");
    
    PrintRawCompoundStmt(Node.getSubStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitNullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 134,
   FQN="(anonymous namespace)::StmtPrinter::VisitNullStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitNullStmtEPN5clang8NullStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitNullStmtEPN5clang8NullStmtE")
  //</editor-fold>
  public void VisitNullStmt(NullStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/";\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPAtomicDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1098,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPAtomicDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPAtomicDirectiveEPN5clang18OMPAtomicDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPAtomicDirectiveEPN5clang18OMPAtomicDirectiveE")
  //</editor-fold>
  public void VisitOMPAtomicDirective(OMPAtomicDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp atomic ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPBarrierDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1073,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPBarrierDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPBarrierDirectiveEPN5clang19OMPBarrierDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPBarrierDirectiveEPN5clang19OMPBarrierDirectiveE")
  //</editor-fold>
  public void VisitOMPBarrierDirective(OMPBarrierDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp barrier");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPCancelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1149,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPCancelDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPCancelDirectiveEPN5clang18OMPCancelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPCancelDirectiveEPN5clang18OMPCancelDirectiveE")
  //</editor-fold>
  public void VisitOMPCancelDirective(OMPCancelDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp cancel ").$out(
        getOpenMPDirectiveName(Node.getCancelRegion())
    ).$out(/*KEEP_STR*/$SPACE);
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1142,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPCancellationPointDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter34VisitOMPCancellationPointDirectiveEPN5clang29OMPCancellationPointDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter34VisitOMPCancellationPointDirectiveEPN5clang29OMPCancellationPointDirectiveE")
  //</editor-fold>
  public void VisitOMPCancellationPointDirective(OMPCancellationPointDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp cancellation point ").$out(
        getOpenMPDirectiveName(Node.getCancelRegion())
    );
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1035,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPCriticalDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPCriticalDirectiveEPN5clang20OMPCriticalDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPCriticalDirectiveEPN5clang20OMPCriticalDirectiveE")
  //</editor-fold>
  public void VisitOMPCriticalDirective(OMPCriticalDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp critical");
    if (Node.getDirectiveName().getName().$bool()) {
      OS.$out(/*KEEP_STR*/" (");
      Node.getDirectiveName().printName(OS);
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
    OS.$out(/*KEEP_STR*/$SPACE);
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPFlushDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1088,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPFlushDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitOMPFlushDirectiveEPN5clang17OMPFlushDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitOMPFlushDirectiveEPN5clang17OMPFlushDirectiveE")
  //</editor-fold>
  public void VisitOMPFlushDirective(OMPFlushDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp flush ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPDistributeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1166,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPDistributeDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitOMPDistributeDirectiveEPN5clang22OMPDistributeDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitOMPDistributeDirectiveEPN5clang22OMPDistributeDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeDirective(OMPDistributeDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp distribute ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1177,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPDistributeParallelForDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter38VisitOMPDistributeParallelForDirectiveEPN5clang33OMPDistributeParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter38VisitOMPDistributeParallelForDirectiveEPN5clang33OMPDistributeParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForDirective(OMPDistributeParallelForDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp distribute parallel for ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPDistributeParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1183,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPDistributeParallelForSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter42VisitOMPDistributeParallelForSimdDirectiveEPN5clang37OMPDistributeParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter42VisitOMPDistributeParallelForSimdDirectiveEPN5clang37OMPDistributeParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForSimdDirective(OMPDistributeParallelForSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp distribute parallel for simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPDistributeSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1189,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPDistributeSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter31VisitOMPDistributeSimdDirectiveEPN5clang26OMPDistributeSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter31VisitOMPDistributeSimdDirectiveEPN5clang26OMPDistributeSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeSimdDirective(OMPDistributeSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp distribute simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1005,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPForDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitOMPForDirectiveEPN5clang15OMPForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitOMPForDirectiveEPN5clang15OMPForDirectiveE")
  //</editor-fold>
  public void VisitOMPForDirective(OMPForDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp for ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1010,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPForSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPForSimdDirectiveEPN5clang19OMPForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPForSimdDirectiveEPN5clang19OMPForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPForSimdDirective(OMPForSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp for simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1046,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPParallelForDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter28VisitOMPParallelForDirectiveEPN5clang23OMPParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter28VisitOMPParallelForDirectiveEPN5clang23OMPParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForDirective(OMPParallelForDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp parallel for ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1051,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPParallelForSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter32VisitOMPParallelForSimdDirectiveEPN5clang27OMPParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter32VisitOMPParallelForSimdDirectiveEPN5clang27OMPParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForSimdDirective(OMPParallelForSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp parallel for simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1000,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitOMPSimdDirectiveEPN5clang16OMPSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitOMPSimdDirectiveEPN5clang16OMPSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPSimdDirective(OMPSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1195,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetParallelForSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter38VisitOMPTargetParallelForSimdDirectiveEPN5clang33OMPTargetParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter38VisitOMPTargetParallelForSimdDirectiveEPN5clang33OMPTargetParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForSimdDirective(OMPTargetParallelForSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target parallel for simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTaskLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1155,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTaskLoopDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPTaskLoopDirectiveEPN5clang20OMPTaskLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPTaskLoopDirectiveEPN5clang20OMPTaskLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopDirective(OMPTaskLoopDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp taskloop ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTaskLoopSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1160,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTaskLoopSimdDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter29VisitOMPTaskLoopSimdDirectiveEPN5clang24OMPTaskLoopSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter29VisitOMPTaskLoopSimdDirectiveEPN5clang24OMPTaskLoopSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopSimdDirective(OMPTaskLoopSimdDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp taskloop simd ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPMasterDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1030,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPMasterDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPMasterDirectiveEPN5clang18OMPMasterDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPMasterDirectiveEPN5clang18OMPMasterDirectiveE")
  //</editor-fold>
  public void VisitOMPMasterDirective(OMPMasterDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp master");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPOrderedDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1093,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPOrderedDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPOrderedDirectiveEPN5clang19OMPOrderedDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPOrderedDirectiveEPN5clang19OMPOrderedDirectiveE")
  //</editor-fold>
  public void VisitOMPOrderedDirective(OMPOrderedDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp ordered ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 995,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPParallelDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPParallelDirectiveEPN5clang20OMPParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPParallelDirectiveEPN5clang20OMPParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelDirective(OMPParallelDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp parallel ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPParallelSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1057,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPParallelSectionsDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter33VisitOMPParallelSectionsDirectiveEPN5clang28OMPParallelSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter33VisitOMPParallelSectionsDirectiveEPN5clang28OMPParallelSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelSectionsDirective(OMPParallelSectionsDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp parallel sections ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1020,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPSectionDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPSectionDirectiveEPN5clang19OMPSectionDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter24VisitOMPSectionDirectiveEPN5clang19OMPSectionDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionDirective(OMPSectionDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp section");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1015,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPSectionsDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPSectionsDirectiveEPN5clang20OMPSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPSectionsDirectiveEPN5clang20OMPSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionsDirective(OMPSectionsDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp sections ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPSingleDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1025,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPSingleDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPSingleDirectiveEPN5clang18OMPSingleDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPSingleDirectiveEPN5clang18OMPSingleDirectiveE")
  //</editor-fold>
  public void VisitOMPSingleDirective(OMPSingleDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp single ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1108,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetDataDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitOMPTargetDataDirectiveEPN5clang22OMPTargetDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitOMPTargetDataDirectiveEPN5clang22OMPTargetDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDataDirective(OMPTargetDataDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target data ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1103,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPTargetDirectiveEPN5clang18OMPTargetDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter23VisitOMPTargetDirectiveEPN5clang18OMPTargetDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDirective(OMPTargetDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetEnterDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1113,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetEnterDataDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter32VisitOMPTargetEnterDataDirectiveEPN5clang27OMPTargetEnterDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter32VisitOMPTargetEnterDataDirectiveEPN5clang27OMPTargetEnterDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetEnterDataDirective(OMPTargetEnterDataDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target enter data ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetExitDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1119,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetExitDataDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter31VisitOMPTargetExitDataDirectiveEPN5clang26OMPTargetExitDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter31VisitOMPTargetExitDataDirectiveEPN5clang26OMPTargetExitDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetExitDataDirective(OMPTargetExitDataDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target exit data ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1125,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetParallelDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter31VisitOMPTargetParallelDirectiveEPN5clang26OMPTargetParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter31VisitOMPTargetParallelDirectiveEPN5clang26OMPTargetParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelDirective(OMPTargetParallelDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target parallel ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1131,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetParallelForDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter34VisitOMPTargetParallelForDirectiveEPN5clang29OMPTargetParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter34VisitOMPTargetParallelForDirectiveEPN5clang29OMPTargetParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForDirective(OMPTargetParallelForDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target parallel for ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTargetUpdateDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1171,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTargetUpdateDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter29VisitOMPTargetUpdateDirectiveEPN5clang24OMPTargetUpdateDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter29VisitOMPTargetUpdateDirectiveEPN5clang24OMPTargetUpdateDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetUpdateDirective(OMPTargetUpdateDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp target update ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTaskDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1063,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTaskDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter21VisitOMPTaskDirectiveEPN5clang16OMPTaskDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter21VisitOMPTaskDirectiveEPN5clang16OMPTaskDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskDirective(OMPTaskDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp task ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTaskgroupDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1083,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTaskgroupDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitOMPTaskgroupDirectiveEPN5clang21OMPTaskgroupDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitOMPTaskgroupDirectiveEPN5clang21OMPTaskgroupDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskgroupDirective(OMPTaskgroupDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp taskgroup");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTaskwaitDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1078,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTaskwaitDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPTaskwaitDirectiveEPN5clang20OMPTaskwaitDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter25VisitOMPTaskwaitDirectiveEPN5clang20OMPTaskwaitDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskwaitDirective(OMPTaskwaitDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp taskwait");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTaskyieldDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1068,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTaskyieldDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitOMPTaskyieldDirectiveEPN5clang21OMPTaskyieldDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitOMPTaskyieldDirectiveEPN5clang21OMPTaskyieldDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskyieldDirective(OMPTaskyieldDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp taskyield");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitOMPTeamsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 1137,
   FQN="(anonymous namespace)::StmtPrinter::VisitOMPTeamsDirective", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitOMPTeamsDirectiveEPN5clang17OMPTeamsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitOMPTeamsDirectiveEPN5clang17OMPTeamsDirectiveE")
  //</editor-fold>
  public void VisitOMPTeamsDirective(OMPTeamsDirective /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"#pragma omp teams ");
    PrintOMPExecutableDirective(Node);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 487,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAtCatchStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCAtCatchStmtEPN5clang15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCAtCatchStmtEPN5clang15ObjCAtCatchStmtE")
  //</editor-fold>
  public void VisitObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"@catch (...) { /* todo */ } \n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 484,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAtFinallyStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter22VisitObjCAtFinallyStmtEPN5clang17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter22VisitObjCAtFinallyStmtEPN5clang17ObjCAtFinallyStmtE")
  //</editor-fold>
  public void VisitObjCAtFinallyStmt(ObjCAtFinallyStmt /*P*/ Node) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 505,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAtSynchronizedStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter27VisitObjCAtSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter27VisitObjCAtSynchronizedStmtEPN5clang22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public void VisitObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"@synchronized (");
    PrintExpr(Node.getSynchExpr());
    OS.$out(/*KEEP_STR*/$RPAREN);
    PrintRawCompoundStmt(Node.getSynchBody());
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 491,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAtThrowStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCAtThrowStmtEPN5clang15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter20VisitObjCAtThrowStmtEPN5clang15ObjCAtThrowStmtE")
  //</editor-fold>
  public void VisitObjCAtThrowStmt(ObjCAtThrowStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"@throw");
    if ((Node.getThrowExpr() != null)) {
      OS.$out(/*KEEP_STR*/$SPACE);
      PrintExpr(Node.getThrowExpr());
    }
    OS.$out(/*KEEP_STR*/";\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 455,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAtTryStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitObjCAtTryStmtEPN5clang13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitObjCAtTryStmtEPN5clang13ObjCAtTryStmtE")
  //</editor-fold>
  public void VisitObjCAtTryStmt(ObjCAtTryStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"@try");
    {
      CompoundStmt /*P*/ TS = dyn_cast_CompoundStmt(Node.getTryBody());
      if ((TS != null)) {
        PrintRawCompoundStmt(TS);
        OS.$out(/*KEEP_STR*/$LF);
      }
    }
    
    for (/*uint*/int I = 0, N = Node.getNumCatchStmts(); I != N; ++I) {
      ObjCAtCatchStmt /*P*/ catchStmt = Node.getCatchStmt(I);
      Indent().$out(/*KEEP_STR*/"@catch(");
      if ((catchStmt.getCatchParamDecl() != null)) {
        {
          Decl /*P*/ DS = catchStmt.getCatchParamDecl();
          if ((DS != null)) {
            PrintRawDecl(DS);
          }
        }
      }
      OS.$out(/*KEEP_STR*/$RPAREN);
      {
        CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(catchStmt.getCatchBody());
        if ((CS != null)) {
          PrintRawCompoundStmt(CS);
          OS.$out(/*KEEP_STR*/$LF);
        }
      }
    }
    {
      
      ObjCAtFinallyStmt /*P*/ FS = ((/*static_cast*/ObjCAtFinallyStmt /*P*/ )(Node.getFinallyStmt()));
      if ((FS != null)) {
        Indent().$out(/*KEEP_STR*/"@finally");
        PrintRawCompoundStmt(dyn_cast_CompoundStmt(FS.getFinallyBody()));
        OS.$out(/*KEEP_STR*/$LF);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 513,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCAutoreleasePoolStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter28VisitObjCAutoreleasePoolStmtEPN5clang23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter28VisitObjCAutoreleasePoolStmtEPN5clang23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public void VisitObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"@autoreleasepool");
    PrintRawCompoundStmt(dyn_cast_CompoundStmt(Node.getSubStmt()));
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 294,
   FQN="(anonymous namespace)::StmtPrinter::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter26VisitObjCForCollectionStmtEPN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"for (");
    {
      DeclStmt /*P*/ DS = dyn_cast_DeclStmt(Node.getElement());
      if ((DS != null)) {
        PrintRawDeclStmt(DS);
      } else {
        PrintExpr(cast_Expr(Node.getElement()));
      }
    }
    OS.$out(/*KEEP_STR*/" in ");
    PrintExpr(Node.getCollection());
    OS.$out(/*KEEP_STR*/") ");
    {
      
      CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Node.getBody());
      if ((CS != null)) {
        PrintRawCompoundStmt(CS);
        OS.$out(/*KEEP_STR*/$LF);
      } else {
        OS.$out(/*KEEP_STR*/$LF);
        PrintStmt(Node.getBody());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 365,
   FQN="(anonymous namespace)::StmtPrinter::VisitReturnStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitReturnStmtEPN5clang10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitReturnStmtEPN5clang10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(ReturnStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/$return);
    if ((Node.getRetValue() != null)) {
      OS.$out(/*KEEP_STR*/$SPACE);
      PrintExpr(Node.getRetValue());
    }
    OS.$out(/*KEEP_STR*/$SEMI);
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 573,
   FQN="(anonymous namespace)::StmtPrinter::VisitSEHExceptStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter18VisitSEHExceptStmtEPN5clang13SEHExceptStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter18VisitSEHExceptStmtEPN5clang13SEHExceptStmtE")
  //</editor-fold>
  public void VisitSEHExceptStmt(SEHExceptStmt /*P*/ Node) {
    Indent();
    PrintRawSEHExceptHandler(Node);
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 579,
   FQN="(anonymous namespace)::StmtPrinter::VisitSEHFinallyStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter19VisitSEHFinallyStmtEPN5clang14SEHFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter19VisitSEHFinallyStmtEPN5clang14SEHFinallyStmtE")
  //</editor-fold>
  public void VisitSEHFinallyStmt(SEHFinallyStmt /*P*/ Node) {
    Indent();
    PrintRawSEHFinallyStmt(Node);
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSEHLeaveStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 585,
   FQN="(anonymous namespace)::StmtPrinter::VisitSEHLeaveStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter17VisitSEHLeaveStmtEPN5clang12SEHLeaveStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter17VisitSEHLeaveStmtEPN5clang12SEHLeaveStmtE")
  //</editor-fold>
  public void VisitSEHLeaveStmt(SEHLeaveStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"__leave;");
    if (Policy.IncludeNewlines) {
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 545,
   FQN="(anonymous namespace)::StmtPrinter::VisitSEHTryStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitSEHTryStmtEPN5clang10SEHTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitSEHTryStmtEPN5clang10SEHTryStmtE")
  //</editor-fold>
  public void VisitSEHTryStmt(SEHTryStmt /*P*/ Node) {
    Indent().$out((Node.getIsCXXTry() ? $("try ") : $("__try ")));
    PrintRawCompoundStmt(Node.getTryBlock());
    SEHExceptStmt /*P*/ E = Node.getExceptHandler();
    SEHFinallyStmt /*P*/ F = Node.getFinallyHandler();
    if ((E != null)) {
      PrintRawSEHExceptHandler(E);
    } else {
      assert ((F != null)) : "Must have a finally block...";
      PrintRawSEHFinallyStmt(F);
    }
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 150,
   FQN="(anonymous namespace)::StmtPrinter::VisitCaseStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter13VisitCaseStmtEPN5clang8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter13VisitCaseStmtEPN5clang8CaseStmtE")
  //</editor-fold>
  public void VisitCaseStmt(CaseStmt /*P*/ Node) {
    Indent(-1).$out(/*KEEP_STR*/"case ");
    PrintExpr(Node.getLHS());
    if ((Node.getRHS() != null)) {
      OS.$out(/*KEEP_STR*/" ... ");
      PrintExpr(Node.getRHS());
    }
    OS.$out(/*KEEP_STR*/$COLON_LF);
    
    PrintStmt(Node.getSubStmt(), 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 162,
   FQN="(anonymous namespace)::StmtPrinter::VisitDefaultStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter16VisitDefaultStmtEPN5clang11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter16VisitDefaultStmtEPN5clang11DefaultStmtE")
  //</editor-fold>
  public void VisitDefaultStmt(DefaultStmt /*P*/ Node) {
    Indent(-1).$out(/*KEEP_STR*/"default:\n");
    PrintStmt(Node.getSubStmt(), 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 220,
   FQN="(anonymous namespace)::StmtPrinter::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter15VisitSwitchStmtEPN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter15VisitSwitchStmtEPN5clang10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(SwitchStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"switch (");
    {
      /*const*/ DeclStmt /*P*/ DS = Node.getConditionVariableDeclStmt();
      if ((DS != null)) {
        PrintRawDeclStmt(DS);
      } else {
        PrintExpr(Node.getCond());
      }
    }
    OS.$out(/*KEEP_STR*/$RPAREN);
    {
      
      // Pretty print compoundstmt bodies (very common).
      CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Node.getBody());
      if ((CS != null)) {
        OS.$out(/*KEEP_STR*/$SPACE);
        PrintRawCompoundStmt(CS);
        OS.$out(/*KEEP_STR*/$LF);
      } else {
        OS.$out(/*KEEP_STR*/$LF);
        PrintStmt(Node.getBody());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinter::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 239,
   FQN="(anonymous namespace)::StmtPrinter::VisitWhileStmt", NM="_ZN12_GLOBAL__N_111StmtPrinter14VisitWhileStmtEPN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN12_GLOBAL__N_111StmtPrinter14VisitWhileStmtEPN5clang9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(WhileStmt /*P*/ Node) {
    Indent().$out(/*KEEP_STR*/"while (");
    {
      /*const*/ DeclStmt /*P*/ DS = Node.getConditionVariableDeclStmt();
      if ((DS != null)) {
        PrintRawDeclStmt(DS);
      } else {
        PrintExpr(Node.getCond());
      }
    }
    OS.$out(/*KEEP_STR*/")\n");
    PrintStmt(Node.getBody());
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", IndentLevel=" + IndentLevel // NOI18N
              + ", Helper=" + Helper // NOI18N
              + ", Policy=" + Policy // NOI18N
              + super.toString(); // NOI18N
  }
}
