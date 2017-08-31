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

package org.clang.sema.impl;

import org.clang.ast.BinaryConditionalOperator;
import org.clang.ast.BinaryOperator;
import org.clang.ast.CXXBoolLiteralExpr;
import org.clang.ast.CastExpr;
import org.clang.ast.CharacterLiteral;
import org.clang.ast.ConditionalOperator;
import org.clang.ast.DeclRefExpr;
import org.clang.ast.EvaluatedExprVisitor;
import org.clang.ast.FloatingLiteral;
import org.clang.ast.GNUNullExpr;
import org.clang.ast.ImaginaryLiteral;
import org.clang.ast.IntegerLiteral;
import org.clang.ast.MemberExpr;
import org.clang.ast.ParenExpr;
import org.clang.ast.Stmt;
import org.clang.ast.UnaryOperator;
import org.clang.ast.UnaryOperatorKind;
import org.clank.support.Converted;
import org.clang.ast.VarDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_VarDecl;
import org.clang.basic.SourceRange;
import org.clang.sema.Sema;
import org.llvm.adt.SmallPtrSetImpl;
import org.llvm.adt.aliases.SmallVectorImpl;

// This visitor will traverse a conditional statement and store all
// the evaluated decls into a vector.  Simple is set to true if none
// of the excluded constructs are used.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1282,
 FQN="(anonymous namespace)::DeclExtractor", NM="_ZN12_GLOBAL__N_113DeclExtractorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractorE")
//</editor-fold>
public class DeclExtractor implements /*public*/ EvaluatedExprVisitor<DeclExtractor> {
  private final SmallPtrSetImpl<VarDecl /*P*/ > /*&*/ Decls;
  private final SmallVectorImpl<SourceRange> /*&*/ Ranges;
  private boolean Simple;
/*public:*/
  // JAVA: typedef EvaluatedExprVisitor<DeclExtractor> Inherited
//  public final class Inherited extends EvaluatedExprVisitor<DeclExtractor>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::DeclExtractor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1289,
   FQN="(anonymous namespace)::DeclExtractor::DeclExtractor", NM="_ZN12_GLOBAL__N_113DeclExtractorC1ERN5clang4SemaERN4llvm15SmallPtrSetImplIPNS1_7VarDeclEEERNS4_15SmallVectorImplINS1_11SourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractorC1ERN5clang4SemaERN4llvm15SmallPtrSetImplIPNS1_7VarDeclEEERNS4_15SmallVectorImplINS1_11SourceRangeEEE")
  //</editor-fold>
  public DeclExtractor(final Sema /*&*/ S, final SmallPtrSetImpl<VarDecl /*P*/ > /*&*/ Decls, 
      final SmallVectorImpl<SourceRange> /*&*/ Ranges) {
    // : Inherited(S.Context), Decls(Decls), Ranges(Ranges), Simple(true) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this./*&*/Decls=/*&*/Decls;
    this./*&*/Ranges=/*&*/Ranges;
    this.Simple = true;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1296,
   FQN="(anonymous namespace)::DeclExtractor::isSimple", NM="_ZN12_GLOBAL__N_113DeclExtractor8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() {
    return Simple;
  }

  
  // Replaces the method in EvaluatedExprVisitor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1299,
   FQN="(anonymous namespace)::DeclExtractor::VisitMemberExpr", NM="_ZN12_GLOBAL__N_113DeclExtractor15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ E) {
    Simple = false;
  }

  
  // Any Stmt not whitelisted will cause the condition to be marked complex.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1304,
   FQN="(anonymous namespace)::DeclExtractor::VisitStmt", NM="_ZN12_GLOBAL__N_113DeclExtractor9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    Simple = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1308,
   FQN="(anonymous namespace)::DeclExtractor::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_113DeclExtractor19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ E) {
    Visit(E.getLHS());
    Visit(E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1313,
   FQN="(anonymous namespace)::DeclExtractor::VisitCastExpr", NM="_ZN12_GLOBAL__N_113DeclExtractor13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ E) {
    Visit(E.getSubExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1317,
   FQN="(anonymous namespace)::DeclExtractor::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_113DeclExtractor18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ E) {
    // Skip checking conditionals with derefernces.
    if (E.getOpcode() == UnaryOperatorKind.UO_Deref) {
      Simple = false;
    } else {
      Visit(E.getSubExpr());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1325,
   FQN="(anonymous namespace)::DeclExtractor::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_113DeclExtractor24VisitConditionalOperatorEPN5clang19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor24VisitConditionalOperatorEPN5clang19ConditionalOperatorE")
  //</editor-fold>
  public void VisitConditionalOperator(ConditionalOperator /*P*/ E) {
    Visit(E.getCond());
    Visit(E.getTrueExpr());
    Visit(E.getFalseExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1331,
   FQN="(anonymous namespace)::DeclExtractor::VisitParenExpr", NM="_ZN12_GLOBAL__N_113DeclExtractor14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(ParenExpr /*P*/ E) {
    Visit(E.getSubExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1335,
   FQN="(anonymous namespace)::DeclExtractor::VisitBinaryConditionalOperator", NM="_ZN12_GLOBAL__N_113DeclExtractor30VisitBinaryConditionalOperatorEPN5clang25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor30VisitBinaryConditionalOperatorEPN5clang25BinaryConditionalOperatorE")
  //</editor-fold>
  public void VisitBinaryConditionalOperator(BinaryConditionalOperator /*P*/ E) {
    Visit(E.getOpaqueValue().getSourceExpr());
    Visit(E.getFalseExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1340,
   FQN="(anonymous namespace)::DeclExtractor::VisitIntegerLiteral", NM="_ZN12_GLOBAL__N_113DeclExtractor19VisitIntegerLiteralEPN5clang14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor19VisitIntegerLiteralEPN5clang14IntegerLiteralE")
  //</editor-fold>
  public void VisitIntegerLiteral(IntegerLiteral /*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1341,
   FQN="(anonymous namespace)::DeclExtractor::VisitFloatingLiteral", NM="_ZN12_GLOBAL__N_113DeclExtractor20VisitFloatingLiteralEPN5clang15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor20VisitFloatingLiteralEPN5clang15FloatingLiteralE")
  //</editor-fold>
  public void VisitFloatingLiteral(FloatingLiteral /*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1342,
   FQN="(anonymous namespace)::DeclExtractor::VisitCXXBoolLiteralExpr", NM="_ZN12_GLOBAL__N_113DeclExtractor23VisitCXXBoolLiteralExprEPN5clang18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor23VisitCXXBoolLiteralExprEPN5clang18CXXBoolLiteralExprE")
  //</editor-fold>
  public void VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr /*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1343,
   FQN="(anonymous namespace)::DeclExtractor::VisitCharacterLiteral", NM="_ZN12_GLOBAL__N_113DeclExtractor21VisitCharacterLiteralEPN5clang16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor21VisitCharacterLiteralEPN5clang16CharacterLiteralE")
  //</editor-fold>
  public void VisitCharacterLiteral(CharacterLiteral /*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1344,
   FQN="(anonymous namespace)::DeclExtractor::VisitGNUNullExpr", NM="_ZN12_GLOBAL__N_113DeclExtractor16VisitGNUNullExprEPN5clang11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor16VisitGNUNullExprEPN5clang11GNUNullExprE")
  //</editor-fold>
  public void VisitGNUNullExpr(GNUNullExpr /*P*/ E) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1345,
   FQN="(anonymous namespace)::DeclExtractor::VisitImaginaryLiteral", NM="_ZN12_GLOBAL__N_113DeclExtractor21VisitImaginaryLiteralEPN5clang16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor21VisitImaginaryLiteralEPN5clang16ImaginaryLiteralE")
  //</editor-fold>
  public void VisitImaginaryLiteral(ImaginaryLiteral /*P*/ E) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclExtractor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1347,
   FQN="(anonymous namespace)::DeclExtractor::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_113DeclExtractor16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_113DeclExtractor16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(E.getDecl());
    if (!(VD != null)) {
      return;
    }
    
    Ranges.push_back(E.getSourceRange());
    
    Decls.insert(VD);
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "Decls=" + "[SmallPtrSetImpl$VarDecl]" // NOI18N
              + ", Ranges=" + Ranges // NOI18N
              + ", Simple=" + Simple // NOI18N
              + super.toString(); // NOI18N
  }
}
