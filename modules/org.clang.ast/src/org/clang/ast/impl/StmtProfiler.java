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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.impl.StmtProfileStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 27,
 FQN="(anonymous namespace)::StmtProfiler", NM="_ZN12_GLOBAL__N_112StmtProfilerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfilerE")
//</editor-fold>
public class StmtProfiler implements /*public*/ ConstStmtVisitorVoid<StmtProfiler> {
  private final FoldingSetNodeID /*&*/ ID;
  private final /*const*/ ASTContext /*&*/ Context;
  private boolean Canonical;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::StmtProfiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 33,
   FQN="(anonymous namespace)::StmtProfiler::StmtProfiler", NM="_ZN12_GLOBAL__N_112StmtProfilerC1ERN4llvm16FoldingSetNodeIDERKN5clang10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfilerC1ERN4llvm16FoldingSetNodeIDERKN5clang10ASTContextEb")
  //</editor-fold>
  public StmtProfiler(final FoldingSetNodeID /*&*/ ID, final /*const*/ ASTContext /*&*/ Context, 
      boolean Canonical) {
    // : ConstStmtVisitor<StmtProfiler>(), ID(ID), Context(Context), Canonical(Canonical) 
    //START JInit
    $ConstStmtVisitor();
    this./*&*/ID=/*&*/ID;
    this./*&*/Context=/*&*/Context;
    this.Canonical = Canonical;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 71,
   FQN="(anonymous namespace)::StmtProfiler::VisitStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(/*const*/ Stmt /*P*/ S) {
    assert ((S != null)) : "Requires non-null Stmt pointer";
    ID.AddInteger_int(S.getStmtClass().getValue());
    for (/*const*/ Stmt /*P*/ SubStmt : S.children$Const()) {
      if ((SubStmt != null)) {
        Visit(SubStmt);
      } else {
        ID.AddInteger_int(0);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 23,
   FQN="(anonymous namespace)::StmtProfiler::VisitAsmStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler12VisitAsmStmtEPKN5clang7AsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler12VisitAsmStmtEPKN5clang7AsmStmtE")
  //</editor-fold>
  public void VisitAsmStmt(/*const*/ AsmStmt /*P*/ S) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 162,
   FQN="(anonymous namespace)::StmtProfiler::VisitGCCAsmStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitGCCAsmStmtEPKN5clang10GCCAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitGCCAsmStmtEPKN5clang10GCCAsmStmtE")
  //</editor-fold>
  public void VisitGCCAsmStmt(/*const*/ GCCAsmStmt /*P*/ S) {
    VisitStmt(S);
    ID.AddBoolean(S.isVolatile());
    ID.AddBoolean(S.isSimple());
    VisitStringLiteral(S.getAsmString$Const());
    ID.AddInteger_uint(S.getNumOutputs());
    for (/*uint*/int I = 0, N = S.getNumOutputs(); I != N; ++I) {
      ID.AddString(S.getOutputName(I));
      VisitStringLiteral(S.getOutputConstraintLiteral$Const(I));
    }
    ID.AddInteger_uint(S.getNumInputs());
    for (/*uint*/int I = 0, N = S.getNumInputs(); I != N; ++I) {
      ID.AddString(S.getInputName(I));
      VisitStringLiteral(S.getInputConstraintLiteral$Const(I));
    }
    ID.AddInteger_uint(S.getNumClobbers());
    for (/*uint*/int I = 0, N = S.getNumClobbers(); I != N; ++I)  {
      VisitStringLiteral(S.getClobberStringLiteral$Const(I));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitMSAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 182,
   FQN="(anonymous namespace)::StmtProfiler::VisitMSAsmStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitMSAsmStmtEPKN5clang9MSAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitMSAsmStmtEPKN5clang9MSAsmStmtE")
  //</editor-fold>
  public void VisitMSAsmStmt(/*const*/ MSAsmStmt /*P*/ S) {
    // FIXME: Implement MS style inline asm statement profiler.
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 113,
   FQN="(anonymous namespace)::StmtProfiler::VisitAttributedStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitAttributedStmtEPKN5clang14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitAttributedStmtEPKN5clang14AttributedStmtE")
  //</editor-fold>
  public void VisitAttributedStmt(/*const*/ AttributedStmt /*P*/ S) {
    VisitStmt(S);
    // TODO: maybe visit attributes?
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 154,
   FQN="(anonymous namespace)::StmtProfiler::VisitBreakStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitBreakStmtEPKN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitBreakStmtEPKN5clang9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(/*const*/ BreakStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 187,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXCatchStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(/*const*/ CXXCatchStmt /*P*/ S) {
    VisitStmt(S);
    VisitType(S.getCaughtType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 196,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXForRangeStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitCXXForRangeStmtEPKN5clang15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitCXXForRangeStmtEPKN5clang15CXXForRangeStmtE")
  //</editor-fold>
  public void VisitCXXForRangeStmt(/*const*/ CXXForRangeStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 192,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXTryStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitCXXTryStmtEPKN5clang10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitCXXTryStmtEPKN5clang10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(/*const*/ CXXTryStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 223,
   FQN="(anonymous namespace)::StmtProfiler::VisitCapturedStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitCapturedStmtEPKN5clang12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitCapturedStmtEPKN5clang12CapturedStmtE")
  //</editor-fold>
  public void VisitCapturedStmt(/*const*/ CapturedStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 92,
   FQN="(anonymous namespace)::StmtProfiler::VisitCompoundStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitCompoundStmtEPKN5clang12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitCompoundStmtEPKN5clang12CompoundStmtE")
  //</editor-fold>
  public void VisitCompoundStmt(/*const*/ CompoundStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 150,
   FQN="(anonymous namespace)::StmtProfiler::VisitContinueStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitContinueStmtEPKN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitContinueStmtEPKN5clang12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(/*const*/ ContinueStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1530,
   FQN="(anonymous namespace)::StmtProfiler::VisitCoreturnStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitCoreturnStmtEPKN5clang12CoreturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitCoreturnStmtEPKN5clang12CoreturnStmtE")
  //</editor-fold>
  public void VisitCoreturnStmt(/*const*/ CoreturnStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1526,
   FQN="(anonymous namespace)::StmtProfiler::VisitCoroutineBodyStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitCoroutineBodyStmtEPKN5clang17CoroutineBodyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitCoroutineBodyStmtEPKN5clang17CoroutineBodyStmtE")
  //</editor-fold>
  public void VisitCoroutineBodyStmt(/*const*/ CoroutineBodyStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 82,
   FQN="(anonymous namespace)::StmtProfiler::VisitDeclStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitDeclStmtEPKN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitDeclStmtEPKN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(/*const*/ DeclStmt /*P*/ S) {
    VisitStmt(S);
    for (/*const*/ Decl /*P*/ D : S.decls$Const())  {
      VisitDecl(D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 133,
   FQN="(anonymous namespace)::StmtProfiler::VisitDoStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler11VisitDoStmtEPKN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler11VisitDoStmtEPKN5clang6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(/*const*/ DoStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 730,
   FQN="(anonymous namespace)::StmtProfiler::VisitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler9VisitExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler9VisitExprEPKN5clang4ExprE")
  //</editor-fold>
  public void VisitExpr(/*const*/ Expr /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 119,
   FQN="(anonymous namespace)::StmtProfiler::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_112StmtProfiler32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ S) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 883,
   FQN="(anonymous namespace)::StmtProfiler::VisitBinaryConditionalOperator", NM="_ZN12_GLOBAL__N_112StmtProfiler30VisitBinaryConditionalOperatorEPKN5clang25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler30VisitBinaryConditionalOperatorEPKN5clang25BinaryConditionalOperatorE")
  //</editor-fold>
  public void VisitBinaryConditionalOperator(/*const*/ BinaryConditionalOperator /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 879,
   FQN="(anonymous namespace)::StmtProfiler::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE")
  //</editor-fold>
  public void VisitConditionalOperator(/*const*/ ConditionalOperator /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 888,
   FQN="(anonymous namespace)::StmtProfiler::VisitAddrLabelExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitAddrLabelExprEPKN5clang13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitAddrLabelExprEPKN5clang13AddrLabelExprE")
  //</editor-fold>
  public void VisitAddrLabelExpr(/*const*/ AddrLabelExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getLabel());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 826,
   FQN="(anonymous namespace)::StmtProfiler::VisitArraySubscriptExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitArraySubscriptExprEPKN5clang18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitArraySubscriptExprEPKN5clang18ArraySubscriptExprE")
  //</editor-fold>
  public void VisitArraySubscriptExpr(/*const*/ ArraySubscriptExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1415,
   FQN="(anonymous namespace)::StmtProfiler::VisitArrayTypeTraitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitArrayTypeTraitExprEPKN5clang18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitArrayTypeTraitExprEPKN5clang18ArrayTypeTraitExprE")
  //</editor-fold>
  public void VisitArrayTypeTraitExpr(/*const*/ ArrayTypeTraitExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getTrait().getValue());
    VisitType(S.getQueriedType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitAsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1217,
   FQN="(anonymous namespace)::StmtProfiler::VisitAsTypeExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitAsTypeExprEPKN5clang10AsTypeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitAsTypeExprEPKN5clang10AsTypeExprE")
  //</editor-fold>
  public void VisitAsTypeExpr(/*const*/ AsTypeExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 993,
   FQN="(anonymous namespace)::StmtProfiler::VisitAtomicExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitAtomicExprEPKN5clang10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitAtomicExprEPKN5clang10AtomicExprE")
  //</editor-fold>
  public void VisitAtomicExpr(/*const*/ AtomicExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getOp().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 869,
   FQN="(anonymous namespace)::StmtProfiler::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getOpcode().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 874,
   FQN="(anonymous namespace)::StmtProfiler::VisitCompoundAssignOperator", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitCompoundAssignOperatorEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitCompoundAssignOperatorEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public void VisitCompoundAssignOperator(/*const*/ CompoundAssignOperator /*P*/ S) {
    VisitBinaryOperator(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 967,
   FQN="(anonymous namespace)::StmtProfiler::VisitBlockExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitBlockExprEPKN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitBlockExprEPKN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(/*const*/ BlockExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getBlockDecl$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1301,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitCXXBindTemporaryExprEPKN5clang20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitCXXBindTemporaryExprEPKN5clang20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(/*const*/ CXXBindTemporaryExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(((/*const_cast*/CXXDestructorDecl /*P*/ )(S.getTemporary$Const().getDestructor())));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1246,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXBoolLiteralExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE")
  //</editor-fold>
  public void VisitCXXBoolLiteralExpr(/*const*/ CXXBoolLiteralExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1307,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getConstructor());
    ID.AddBoolean(S.isElidable());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1323,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXTemporaryObjectExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitCXXTemporaryObjectExprEPKN5clang22CXXTemporaryObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitCXXTemporaryObjectExprEPKN5clang22CXXTemporaryObjectExprE")
  //</editor-fold>
  public void VisitCXXTemporaryObjectExpr(/*const*/ CXXTemporaryObjectExpr /*P*/ S) {
    VisitCXXConstructExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1291,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitCXXDefaultArgExprEPKN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitCXXDefaultArgExprEPKN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public void VisitCXXDefaultArgExpr(/*const*/ CXXDefaultArgExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getParam$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1296,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitCXXDefaultInitExprEPKN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitCXXDefaultInitExprEPKN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public void VisitCXXDefaultInitExpr(/*const*/ CXXDefaultInitExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getField$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1359,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitCXXDeleteExprEPKN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitCXXDeleteExprEPKN5clang13CXXDeleteExprE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(/*const*/ CXXDeleteExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.isGlobalDelete());
    ID.AddBoolean(S.isArrayForm());
    VisitDecl(S.getOperatorDelete());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1447,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXDependentScopeMemberExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler32VisitCXXDependentScopeMemberExprEPKN5clang27CXXDependentScopeMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler32VisitCXXDependentScopeMemberExprEPKN5clang27CXXDependentScopeMemberExprE")
  //</editor-fold>
  public void VisitCXXDependentScopeMemberExpr(/*const*/ CXXDependentScopeMemberExpr /*P*/ S) {
    ID.AddBoolean(S.isImplicitAccess());
    if (!S.isImplicitAccess()) {
      VisitExpr(S);
      ID.AddBoolean(S.isArrow());
    }
    VisitNestedNameSpecifier(S.getQualifier());
    VisitName(S.getMember());
    ID.AddBoolean(S.hasExplicitTemplateArgs());
    if (S.hasExplicitTemplateArgs()) {
      VisitTemplateArguments(S.getTemplateArgs(), S.getNumTemplateArgs());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXFoldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1521,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXFoldExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitCXXFoldExprEPKN5clang11CXXFoldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitCXXFoldExprEPKN5clang11CXXFoldExprE")
  //</editor-fold>
  public void VisitCXXFoldExpr(/*const*/ CXXFoldExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getOperator().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1313,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXInheritedCtorInitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler29VisitCXXInheritedCtorInitExprEPKN5clang24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler29VisitCXXInheritedCtorInitExprEPKN5clang24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public void VisitCXXInheritedCtorInitExpr(/*const*/ CXXInheritedCtorInitExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getConstructor());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1366,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitCXXNewExprEPKN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitCXXNewExprEPKN5clang10CXXNewExprE")
  //</editor-fold>
  public void VisitCXXNewExpr(/*const*/ CXXNewExpr /*P*/ S) {
    VisitExpr(S);
    VisitType(S.getAllocatedType());
    VisitDecl(S.getOperatorNew());
    VisitDecl(S.getOperatorDelete());
    ID.AddBoolean(S.isArray());
    ID.AddInteger_uint(S.getNumPlacementArgs());
    ID.AddBoolean(S.isGlobalNew());
    ID.AddBoolean(S.isParenTypeId());
    ID.AddInteger_int(S.getInitializationStyle().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1474,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXNoexceptExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitCXXNoexceptExprEPKN5clang15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitCXXNoexceptExprEPKN5clang15CXXNoexceptExprE")
  //</editor-fold>
  public void VisitCXXNoexceptExpr(/*const*/ CXXNoexceptExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1251,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXNullPtrLiteralExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitCXXNullPtrLiteralExprEPKN5clang21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitCXXNullPtrLiteralExprEPKN5clang21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public void VisitCXXNullPtrLiteralExpr(/*const*/ CXXNullPtrLiteralExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1378,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXPseudoDestructorExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler28VisitCXXPseudoDestructorExprEPKN5clang23CXXPseudoDestructorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler28VisitCXXPseudoDestructorExprEPKN5clang23CXXPseudoDestructorExprE")
  //</editor-fold>
  public void VisitCXXPseudoDestructorExpr(/*const*/ CXXPseudoDestructorExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.isArrow());
    VisitNestedNameSpecifier(S.getQualifier());
    ID.AddBoolean(S.getScopeTypeInfo() != (TypeSourceInfo /*P*/ )null);
    if ((S.getScopeTypeInfo() != null)) {
      VisitType(S.getScopeTypeInfo().getType());
    }
    ID.AddBoolean(S.getDestroyedTypeInfo() != (TypeSourceInfo /*P*/ )null);
    if ((S.getDestroyedTypeInfo() != null)) {
      VisitType(S.getDestroyedType());
    } else {
      ID.AddPointer(S.getDestroyedTypeIdentifier());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1354,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXScalarValueInitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitCXXScalarValueInitExprEPKN5clang22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitCXXScalarValueInitExprEPKN5clang22CXXScalarValueInitExprE")
  //</editor-fold>
  public void VisitCXXScalarValueInitExpr(/*const*/ CXXScalarValueInitExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1255,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXStdInitializerListExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler30VisitCXXStdInitializerListExprEPKN5clang25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler30VisitCXXStdInitializerListExprEPKN5clang25CXXStdInitializerListExprE")
  //</editor-fold>
  public void VisitCXXStdInitializerListExpr(/*const*/ CXXStdInitializerListExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1282,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitCXXThisExprEPKN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitCXXThisExprEPKN5clang11CXXThisExprE")
  //</editor-fold>
  public void VisitCXXThisExpr(/*const*/ CXXThisExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.isImplicit());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1287,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitCXXThrowExprEPKN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitCXXThrowExprEPKN5clang12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1260,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXTypeidExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitCXXTypeidExprEPKN5clang13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitCXXTypeidExprEPKN5clang13CXXTypeidExprE")
  //</editor-fold>
  public void VisitCXXTypeidExpr(/*const*/ CXXTypeidExpr /*P*/ S) {
    VisitExpr(S);
    if (S.isTypeOperand()) {
      VisitType(S.getTypeOperandSourceInfo().getType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1441,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXUnresolvedConstructExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler31VisitCXXUnresolvedConstructExprEPKN5clang26CXXUnresolvedConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler31VisitCXXUnresolvedConstructExprEPKN5clang26CXXUnresolvedConstructExprE")
  //</editor-fold>
  public void VisitCXXUnresolvedConstructExpr(/*const*/ CXXUnresolvedConstructExpr /*P*/ S) {
    VisitExpr(S);
    VisitType(S.getTypeAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1266,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXUuidofExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitCXXUuidofExprEPKN5clang13CXXUuidofExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitCXXUuidofExprEPKN5clang13CXXUuidofExprE")
  //</editor-fold>
  public void VisitCXXUuidofExpr(/*const*/ CXXUuidofExpr /*P*/ S) {
    VisitExpr(S);
    if (S.isTypeOperand()) {
      VisitType(S.getTypeOperandSourceInfo().getType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 834,
   FQN="(anonymous namespace)::StmtProfiler::VisitCallExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(/*const*/ CallExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1213,
   FQN="(anonymous namespace)::StmtProfiler::VisitCUDAKernelCallExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitCUDAKernelCallExprEPKN5clang18CUDAKernelCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitCUDAKernelCallExprEPKN5clang18CUDAKernelCallExprE")
  //</editor-fold>
  public void VisitCUDAKernelCallExpr(/*const*/ CUDAKernelCallExpr /*P*/ S) {
    VisitCallExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1209,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXMemberCallExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitCXXMemberCallExprEPKN5clang17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitCXXMemberCallExprEPKN5clang17CXXMemberCallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(/*const*/ CXXMemberCallExpr /*P*/ S) {
    VisitCallExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1183,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXOperatorCallExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitCXXOperatorCallExprEPKN5clang19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitCXXOperatorCallExprEPKN5clang19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(/*const*/ CXXOperatorCallExpr /*P*/ S) {
    if (S.isTypeDependent()) {
      // Type-dependent operator calls are profiled like their underlying
      // syntactic operator.
      type$ref<UnaryOperatorKind> UnaryOp = create_type$ref(UnaryOperatorKind.UO_Extension);
      type$ref<BinaryOperatorKind> BinaryOp = create_type$ref(BinaryOperatorKind.BO_Comma);
      Stmt.StmtClass SC = DecodeOperatorCall(S, UnaryOp, BinaryOp);
      
      ID.AddInteger_int(SC.getValue());
      for (/*uint*/int I = 0, N = S.getNumArgs(); I != N; ++I)  {
        Visit(S.getArg$Const(I));
      }
      if (SC == Stmt.StmtClass.UnaryOperatorClass) {
        ID.AddInteger_int(UnaryOp.$deref().getValue());
      } else if (SC == Stmt.StmtClass.BinaryOperatorClass
         || SC == Stmt.StmtClass.CompoundAssignOperatorClass) {
        ID.AddInteger_int(BinaryOp.$deref().getValue());
      } else {
        assert (SC == Stmt.StmtClass.ArraySubscriptExprClass);
      }
      
      return;
    }
    
    VisitCallExpr(S);
    ID.AddInteger_int(S.getOperator().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitUserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1242,
   FQN="(anonymous namespace)::StmtProfiler::VisitUserDefinedLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitUserDefinedLiteralEPKN5clang18UserDefinedLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitUserDefinedLiteralEPKN5clang18UserDefinedLiteralE")
  //</editor-fold>
  public void VisitUserDefinedLiteral(/*const*/ UserDefinedLiteral /*P*/ S) {
    VisitCallExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 851,
   FQN="(anonymous namespace)::StmtProfiler::VisitCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(/*const*/ CastExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 860,
   FQN="(anonymous namespace)::StmtProfiler::VisitExplicitCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitExplicitCastExprEPKN5clang16ExplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitExplicitCastExprEPKN5clang16ExplicitCastExprE")
  //</editor-fold>
  public void VisitExplicitCastExpr(/*const*/ ExplicitCastExpr /*P*/ S) {
    VisitCastExpr(S);
    VisitType(S.getTypeAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 865,
   FQN="(anonymous namespace)::StmtProfiler::VisitCStyleCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitCStyleCastExprEPKN5clang14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitCStyleCastExprEPKN5clang14CStyleCastExprE")
  //</editor-fold>
  public void VisitCStyleCastExpr(/*const*/ CStyleCastExpr /*P*/ S) {
    VisitExplicitCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1319,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXFunctionalCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitCXXFunctionalCastExprEPKN5clang21CXXFunctionalCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitCXXFunctionalCastExprEPKN5clang21CXXFunctionalCastExprE")
  //</editor-fold>
  public void VisitCXXFunctionalCastExpr(/*const*/ CXXFunctionalCastExpr /*P*/ S) {
    VisitExplicitCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1221,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXNamedCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitCXXNamedCastExprEPKN5clang16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitCXXNamedCastExprEPKN5clang16CXXNamedCastExprE")
  //</editor-fold>
  public void VisitCXXNamedCastExpr(/*const*/ CXXNamedCastExpr /*P*/ S) {
    VisitExplicitCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXConstCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1238,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXConstCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitCXXConstCastExprEPKN5clang16CXXConstCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitCXXConstCastExprEPKN5clang16CXXConstCastExprE")
  //</editor-fold>
  public void VisitCXXConstCastExpr(/*const*/ CXXConstCastExpr /*P*/ S) {
    VisitCXXNamedCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1229,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXDynamicCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitCXXDynamicCastExprEPKN5clang18CXXDynamicCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitCXXDynamicCastExprEPKN5clang18CXXDynamicCastExprE")
  //</editor-fold>
  public void VisitCXXDynamicCastExpr(/*const*/ CXXDynamicCastExpr /*P*/ S) {
    VisitCXXNamedCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1233,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXReinterpretCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitCXXReinterpretCastExprEPKN5clang22CXXReinterpretCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitCXXReinterpretCastExprEPKN5clang22CXXReinterpretCastExprE")
  //</editor-fold>
  public void VisitCXXReinterpretCastExpr(/*const*/ CXXReinterpretCastExpr /*P*/ S) {
    VisitCXXNamedCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1225,
   FQN="(anonymous namespace)::StmtProfiler::VisitCXXStaticCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitCXXStaticCastExprEPKN5clang17CXXStaticCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitCXXStaticCastExprEPKN5clang17CXXStaticCastExprE")
  //</editor-fold>
  public void VisitCXXStaticCastExpr(/*const*/ CXXStaticCastExpr /*P*/ S) {
    VisitCXXNamedCastExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1630,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCBridgedCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitObjCBridgedCastExprEPKN5clang19ObjCBridgedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitObjCBridgedCastExprEPKN5clang19ObjCBridgedCastExprE")
  //</editor-fold>
  public void VisitObjCBridgedCastExpr(/*const*/ ObjCBridgedCastExpr /*P*/ S) {
    VisitExplicitCastExpr(S);
    ID.AddBoolean((S.getBridgeKind().getValue() != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 855,
   FQN="(anonymous namespace)::StmtProfiler::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitImplicitCastExprEPKN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitImplicitCastExprEPKN5clang16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(/*const*/ ImplicitCastExpr /*P*/ S) {
    VisitCastExpr(S);
    ID.AddInteger_int(S.getValueKind().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 754,
   FQN="(anonymous namespace)::StmtProfiler::VisitCharacterLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitCharacterLiteralEPKN5clang16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitCharacterLiteralEPKN5clang16CharacterLiteralE")
  //</editor-fold>
  public void VisitCharacterLiteral(/*const*/ CharacterLiteral /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getKind().getValue());
    ID.AddInteger_uint(S.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 905,
   FQN="(anonymous namespace)::StmtProfiler::VisitChooseExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitChooseExprEPKN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitChooseExprEPKN5clang10ChooseExprE")
  //</editor-fold>
  public void VisitChooseExpr(/*const*/ ChooseExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 846,
   FQN="(anonymous namespace)::StmtProfiler::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitCompoundLiteralExprEPKN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitCompoundLiteralExprEPKN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public void VisitCompoundLiteralExpr(/*const*/ CompoundLiteralExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.isFileScope());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 901,
   FQN="(anonymous namespace)::StmtProfiler::VisitConvertVectorExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitConvertVectorExprEPKN5clang17ConvertVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitConvertVectorExprEPKN5clang17ConvertVectorExprE")
  //</editor-fold>
  public void VisitConvertVectorExpr(/*const*/ ConvertVectorExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCoroutineSuspendExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 445,
   FQN="(anonymous namespace)::StmtProfiler::VisitCoroutineSuspendExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitCoroutineSuspendExprEPKN5clang20CoroutineSuspendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitCoroutineSuspendExprEPKN5clang20CoroutineSuspendExprE")
  //</editor-fold>
  public void VisitCoroutineSuspendExpr(/*const*/ CoroutineSuspendExpr /*P*/ S) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1534,
   FQN="(anonymous namespace)::StmtProfiler::VisitCoawaitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitCoawaitExprEPKN5clang11CoawaitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitCoawaitExprEPKN5clang11CoawaitExprE")
  //</editor-fold>
  public void VisitCoawaitExpr(/*const*/ CoawaitExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1538,
   FQN="(anonymous namespace)::StmtProfiler::VisitCoyieldExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitCoyieldExprEPKN5clang11CoyieldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitCoyieldExprEPKN5clang11CoyieldExprE")
  //</editor-fold>
  public void VisitCoyieldExpr(/*const*/ CoyieldExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 734,
   FQN="(anonymous namespace)::StmtProfiler::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitDeclRefExprEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitDeclRefExprEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ S) {
    VisitExpr(S);
    if (!Canonical) {
      VisitNestedNameSpecifier(S.getQualifier());
    }
    VisitDecl(S.getDecl$Const());
    if (!Canonical) {
      VisitTemplateArguments(S.getTemplateArgs(), S.getNumTemplateArgs());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1427,
   FQN="(anonymous namespace)::StmtProfiler::VisitDependentScopeDeclRefExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler30VisitDependentScopeDeclRefExprEPKN5clang25DependentScopeDeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler30VisitDependentScopeDeclRefExprEPKN5clang25DependentScopeDeclRefExprE")
  //</editor-fold>
  public void VisitDependentScopeDeclRefExpr(/*const*/ DependentScopeDeclRefExpr /*P*/ S) {
    VisitExpr(S);
    VisitName(S.getDeclName());
    VisitNestedNameSpecifier(S.getQualifier());
    ID.AddBoolean(S.hasExplicitTemplateArgs());
    if (S.hasExplicitTemplateArgs()) {
      VisitTemplateArguments(S.getTemplateArgs(), S.getNumTemplateArgs());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 926,
   FQN="(anonymous namespace)::StmtProfiler::VisitDesignatedInitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitDesignatedInitExprEPKN5clang18DesignatedInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitDesignatedInitExprEPKN5clang18DesignatedInitExprE")
  //</editor-fold>
  public void VisitDesignatedInitExpr(/*const*/ DesignatedInitExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.usesGNUSyntax());
    for (final /*const*/ DesignatedInitExpr.Designator /*&*/ D : S.designators$Const()) {
      if (D.isFieldDesignator()) {
        ID.AddInteger_int(0);
        VisitName(new DeclarationName(D.getFieldName()));
        continue;
      }
      if (D.isArrayDesignator()) {
        ID.AddInteger_int(1);
      } else {
        assert (D.isArrayRangeDesignator());
        ID.AddInteger_int(2);
      }
      ID.AddInteger_uint(D.getFirstExprIndex());
    }
  }

  
  // Seems that if VisitInitListExpr() only works on the syntactic form of an
  // InitListExpr, then a DesignatedInitUpdateExpr is not encountered.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 948,
   FQN="(anonymous namespace)::StmtProfiler::VisitDesignatedInitUpdateExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler29VisitDesignatedInitUpdateExprEPKN5clang24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler29VisitDesignatedInitUpdateExprEPKN5clang24DesignatedInitUpdateExprE")
  //</editor-fold>
  public void VisitDesignatedInitUpdateExpr(/*const*/ DesignatedInitUpdateExpr /*P*/ S) {
    throw new llvm_unreachable("Unexpected DesignatedInitUpdateExpr in syntactic form of initializer");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1437,
   FQN="(anonymous namespace)::StmtProfiler::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitExprWithCleanupsEPKN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitExprWithCleanupsEPKN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public void VisitExprWithCleanups(/*const*/ ExprWithCleanups /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1421,
   FQN="(anonymous namespace)::StmtProfiler::VisitExpressionTraitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitExpressionTraitExprEPKN5clang19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitExpressionTraitExprEPKN5clang19ExpressionTraitExprE")
  //</editor-fold>
  public void VisitExpressionTraitExpr(/*const*/ ExpressionTraitExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getTrait().getValue());
    VisitExpr(S.getQueriedExpression());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 962,
   FQN="(anonymous namespace)::StmtProfiler::VisitExtVectorElementExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitExtVectorElementExprEPKN5clang20ExtVectorElementExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitExtVectorElementExprEPKN5clang20ExtVectorElementExprE")
  //</editor-fold>
  public void VisitExtVectorElementExpr(/*const*/ ExtVectorElementExpr /*P*/ S) {
    VisitExpr(S);
    VisitName(new DeclarationName($AddrOf(S.getAccessor())));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 760,
   FQN="(anonymous namespace)::StmtProfiler::VisitFloatingLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitFloatingLiteralEPKN5clang15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitFloatingLiteralEPKN5clang15FloatingLiteralE")
  //</editor-fold>
  public void VisitFloatingLiteral(/*const*/ FloatingLiteral /*P*/ S) {
    VisitExpr(S);
    S.getValue().Profile(ID);
    ID.AddBoolean(S.isExact());
    ID.AddInteger_int(S.getType().$arrow().castAs$BuiltinType().getKind().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1508,
   FQN="(anonymous namespace)::StmtProfiler::VisitFunctionParmPackExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitFunctionParmPackExprEPKN5clang20FunctionParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitFunctionParmPackExprEPKN5clang20FunctionParmPackExprE")
  //</editor-fold>
  public void VisitFunctionParmPackExpr(/*const*/ FunctionParmPackExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getParameterPack());
    ID.AddInteger_uint(S.getNumExpansions());
    for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> I = $tryClone(S.begin()), /*P*/ /*const*/ /*P*/ E = $tryClone(S.end()); $noteq_ptr(I, E); I.$preInc())  {
      VisitDecl(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 909,
   FQN="(anonymous namespace)::StmtProfiler::VisitGNUNullExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitGNUNullExprEPKN5clang11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitGNUNullExprEPKN5clang11GNUNullExprE")
  //</editor-fold>
  public void VisitGNUNullExpr(/*const*/ GNUNullExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 972,
   FQN="(anonymous namespace)::StmtProfiler::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitGenericSelectionExprEPKN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitGenericSelectionExprEPKN5clang20GenericSelectionExprE")
  //</editor-fold>
  public void VisitGenericSelectionExpr(/*const*/ GenericSelectionExpr /*P*/ S) {
    VisitExpr(S);
    for (/*uint*/int i = 0; i != S.getNumAssocs(); ++i) {
      QualType T = S.getAssocType(i);
      if (T.isNull()) {
        ID.AddPointer((/*const*/Object/*void P*/ )null);
      } else {
        VisitType(new QualType(T));
      }
      VisitExpr(S.getAssocExpr$Const(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 767,
   FQN="(anonymous namespace)::StmtProfiler::VisitImaginaryLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitImaginaryLiteralEPKN5clang16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitImaginaryLiteralEPKN5clang16ImaginaryLiteralE")
  //</editor-fold>
  public void VisitImaginaryLiteral(/*const*/ ImaginaryLiteral /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 958,
   FQN="(anonymous namespace)::StmtProfiler::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitImplicitValueInitExprEPKN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitImplicitValueInitExprEPKN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public void VisitImplicitValueInitExpr(/*const*/ ImplicitValueInitExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 917,
   FQN="(anonymous namespace)::StmtProfiler::VisitInitListExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(/*const*/ InitListExpr /*P*/ S) {
    if ((S.getSyntacticForm() != null)) {
      VisitInitListExpr(S.getSyntacticForm());
      return;
    }
    
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 748,
   FQN="(anonymous namespace)::StmtProfiler::VisitIntegerLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitIntegerLiteralEPKN5clang14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitIntegerLiteralEPKN5clang14IntegerLiteralE")
  //</editor-fold>
  public void VisitIntegerLiteral(/*const*/ IntegerLiteral /*P*/ S) {
    VisitExpr(S);
    S.getValue().Profile(ID);
    ID.AddInteger_int(S.getType().$arrow().castAs$BuiltinType().getKind().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1328,
   FQN="(anonymous namespace)::StmtProfiler::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitLambdaExprEPKN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitLambdaExprEPKN5clang10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(/*const*/ LambdaExpr /*P*/ S) {
    VisitExpr(S);
    for (type$ptr<LambdaCapture> C = $tryClone(S.explicit_capture_begin()), 
        /*P*/ CEnd = $tryClone(S.explicit_capture_end());
         $noteq_ptr(C, CEnd); C.$preInc()) {
      ID.AddInteger_int(C./*->*/$star().getCaptureKind().getValue());
      switch (C./*->*/$star().getCaptureKind()) {
       case LCK_StarThis:
       case LCK_This:
        break;
       case LCK_ByRef:
       case LCK_ByCopy:
        VisitDecl(C./*->*/$star().getCapturedVar());
        ID.AddBoolean(C./*->*/$star().isPackExpansion());
        break;
       case LCK_VLAType:
        throw new llvm_unreachable("VLA type in explicit captures.");
      }
    }
    // Note: If we actually needed to be able to match lambda
    // expressions, we would have to consider parameters and return type
    // here, among other things.
    VisitStmt(S.getBody());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1272,
   FQN="(anonymous namespace)::StmtProfiler::VisitMSPropertyRefExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitMSPropertyRefExprEPKN5clang17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitMSPropertyRefExprEPKN5clang17MSPropertyRefExprE")
  //</editor-fold>
  public void VisitMSPropertyRefExpr(/*const*/ MSPropertyRefExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getPropertyDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1277,
   FQN="(anonymous namespace)::StmtProfiler::VisitMSPropertySubscriptExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler28VisitMSPropertySubscriptExprEPKN5clang23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler28VisitMSPropertySubscriptExprEPKN5clang23MSPropertySubscriptExprE")
  //</editor-fold>
  public void VisitMSPropertySubscriptExpr(/*const*/ MSPropertySubscriptExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1516,
   FQN="(anonymous namespace)::StmtProfiler::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(/*const*/ MaterializeTemporaryExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 838,
   FQN="(anonymous namespace)::StmtProfiler::VisitMemberExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(/*const*/ MemberExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getMemberDecl());
    if (!Canonical) {
      VisitNestedNameSpecifier(S.getQualifier());
    }
    ID.AddBoolean(S.isArrow());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitNoInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 954,
   FQN="(anonymous namespace)::StmtProfiler::VisitNoInitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitNoInitExprEPKN5clang10NoInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitNoInitExprEPKN5clang10NoInitExprE")
  //</editor-fold>
  public void VisitNoInitExpr(/*const*/ NoInitExpr /*P*/ S) {
    throw new llvm_unreachable("Unexpected NoInitExpr in syntactic form of initializer");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 830,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPArraySectionExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPArraySectionExprEPKN5clang19OMPArraySectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPArraySectionExprEPKN5clang19OMPArraySectionExprE")
  //</editor-fold>
  public void VisitOMPArraySectionExpr(/*const*/ OMPArraySectionExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1558,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCArrayLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitObjCArrayLiteralEPKN5clang16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitObjCArrayLiteralEPKN5clang16ObjCArrayLiteralE")
  //</editor-fold>
  public void VisitObjCArrayLiteral(/*const*/ ObjCArrayLiteral /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1635,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAvailabilityCheckExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler30VisitObjCAvailabilityCheckExprEPKN5clang25ObjCAvailabilityCheckExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler30VisitObjCAvailabilityCheckExprEPKN5clang25ObjCAvailabilityCheckExprE")
  //</editor-fold>
  public void VisitObjCAvailabilityCheckExpr(/*const*/ ObjCAvailabilityCheckExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1619,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCBoolLiteralExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE")
  //</editor-fold>
  public void VisitObjCBoolLiteralExpr(/*const*/ ObjCBoolLiteralExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1554,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCBoxedExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitObjCBoxedExprEPKN5clang13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitObjCBoxedExprEPKN5clang13ObjCBoxedExprE")
  //</editor-fold>
  public void VisitObjCBoxedExpr(/*const*/ ObjCBoxedExpr /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1562,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCDictionaryLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitObjCDictionaryLiteralEPKN5clang21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitObjCDictionaryLiteralEPKN5clang21ObjCDictionaryLiteralE")
  //</editor-fold>
  public void VisitObjCDictionaryLiteral(/*const*/ ObjCDictionaryLiteral /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1566,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCEncodeExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitObjCEncodeExprEPKN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitObjCEncodeExprEPKN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public void VisitObjCEncodeExpr(/*const*/ ObjCEncodeExpr /*P*/ S) {
    VisitExpr(S);
    VisitType(S.getEncodedType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1624,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCIndirectCopyRestoreExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler32VisitObjCIndirectCopyRestoreExprEPKN5clang27ObjCIndirectCopyRestoreExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler32VisitObjCIndirectCopyRestoreExprEPKN5clang27ObjCIndirectCopyRestoreExprE")
  //</editor-fold>
  public void VisitObjCIndirectCopyRestoreExpr(/*const*/ ObjCIndirectCopyRestoreExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.shouldCopy());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1614,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCIsaExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitObjCIsaExprEPKN5clang11ObjCIsaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitObjCIsaExprEPKN5clang11ObjCIsaExprE")
  //</editor-fold>
  public void VisitObjCIsaExpr(/*const*/ ObjCIsaExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddBoolean(S.isArrow());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1581,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCIvarRefExprEPKN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCIvarRefExprEPKN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(/*const*/ ObjCIvarRefExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getDecl$Const());
    ID.AddBoolean(S.isArrow());
    ID.AddBoolean(S.isFreeIvar());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1608,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ S) {
    VisitExpr(S);
    VisitName(new DeclarationName(S.getSelector()));
    VisitDecl(S.getMethodDecl$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1588,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitObjCPropertyRefExprEPKN5clang19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitObjCPropertyRefExprEPKN5clang19ObjCPropertyRefExprE")
  //</editor-fold>
  public void VisitObjCPropertyRefExpr(/*const*/ ObjCPropertyRefExpr /*P*/ S) {
    VisitExpr(S);
    if (S.isImplicitProperty()) {
      VisitDecl(S.getImplicitPropertyGetter());
      VisitDecl(S.getImplicitPropertySetter());
    } else {
      VisitDecl(S.getExplicitProperty());
    }
    if (S.isSuperReceiver()) {
      ID.AddBoolean(S.isSuperReceiver());
      VisitType(S.getSuperReceiverType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1576,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCProtocolExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitObjCProtocolExprEPKN5clang16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitObjCProtocolExprEPKN5clang16ObjCProtocolExprE")
  //</editor-fold>
  public void VisitObjCProtocolExpr(/*const*/ ObjCProtocolExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getProtocol());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1571,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCSelectorExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitObjCSelectorExprEPKN5clang16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitObjCSelectorExprEPKN5clang16ObjCSelectorExprE")
  //</editor-fold>
  public void VisitObjCSelectorExpr(/*const*/ ObjCSelectorExpr /*P*/ S) {
    VisitExpr(S);
    VisitName(new DeclarationName(S.getSelector()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1550,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCStringLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitObjCStringLiteralEPKN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitObjCStringLiteralEPKN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public void VisitObjCStringLiteral(/*const*/ ObjCStringLiteral /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1602,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCSubscriptRefExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitObjCSubscriptRefExprEPKN5clang20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitObjCSubscriptRefExprEPKN5clang20ObjCSubscriptRefExprE")
  //</editor-fold>
  public void VisitObjCSubscriptRefExpr(/*const*/ ObjCSubscriptRefExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getAtIndexMethodDecl());
    VisitDecl(S.setAtIndexMethodDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 790,
   FQN="(anonymous namespace)::StmtProfiler::VisitOffsetOfExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitOffsetOfExprEPKN5clang12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitOffsetOfExprEPKN5clang12OffsetOfExprE")
  //</editor-fold>
  public void VisitOffsetOfExpr(/*const*/ OffsetOfExpr /*P*/ S) {
    VisitType(S.getTypeSourceInfo().getType());
    /*uint*/int n = S.getNumComponents();
    for (/*uint*/int i = 0; $less_uint(i, n); ++i) {
      final /*const*/ OffsetOfNode /*&*/ ON = S.getComponent(i);
      ID.AddInteger_int(ON.getKind());
      switch (ON.getKind()) {
       case OffsetOfNode.Kind.Array:
        // Expressions handled below.
        break;
       case OffsetOfNode.Kind.Field:
        VisitDecl(ON.getField());
        break;
       case OffsetOfNode.Kind.Identifier:
        ID.AddPointer(ON.getFieldName());
        break;
       case OffsetOfNode.Kind.Base:
        // These nodes are implicit, and therefore don't need profiling.
        break;
      }
    }
    
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1542,
   FQN="(anonymous namespace)::StmtProfiler::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitOpaqueValueExprEPKN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitOpaqueValueExprEPKN5clang15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(/*const*/ OpaqueValueExpr /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOverloadExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1393,
   FQN="(anonymous namespace)::StmtProfiler::VisitOverloadExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitOverloadExprEPKN5clang12OverloadExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitOverloadExprEPKN5clang12OverloadExprE")
  //</editor-fold>
  public void VisitOverloadExpr(/*const*/ OverloadExpr /*P*/ S) {
    VisitExpr(S);
    VisitNestedNameSpecifier(S.getQualifier());
    VisitName(S.getName());
    ID.AddBoolean(S.hasExplicitTemplateArgs());
    if (S.hasExplicitTemplateArgs()) {
      VisitTemplateArguments(S.getTemplateArgs(), S.getNumTemplateArgs());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1402,
   FQN="(anonymous namespace)::StmtProfiler::VisitUnresolvedLookupExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitUnresolvedLookupExprEPKN5clang20UnresolvedLookupExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitUnresolvedLookupExprEPKN5clang20UnresolvedLookupExprE")
  //</editor-fold>
  public void VisitUnresolvedLookupExpr(/*const*/ UnresolvedLookupExpr /*P*/ S) {
    VisitOverloadExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1461,
   FQN="(anonymous namespace)::StmtProfiler::VisitUnresolvedMemberExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitUnresolvedMemberExprEPKN5clang20UnresolvedMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitUnresolvedMemberExprEPKN5clang20UnresolvedMemberExprE")
  //</editor-fold>
  public void VisitUnresolvedMemberExpr(/*const*/ UnresolvedMemberExpr /*P*/ S) {
    ID.AddBoolean(S.isImplicitAccess());
    if (!S.isImplicitAccess()) {
      VisitExpr(S);
      ID.AddBoolean(S.isArrow());
    }
    VisitNestedNameSpecifier(S.getQualifier());
    VisitName(S.getMemberName());
    ID.AddBoolean(S.hasExplicitTemplateArgs());
    if (S.hasExplicitTemplateArgs()) {
      VisitTemplateArguments(S.getTemplateArgs(), S.getNumTemplateArgs());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitPackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1478,
   FQN="(anonymous namespace)::StmtProfiler::VisitPackExpansionExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitPackExpansionExprEPKN5clang17PackExpansionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitPackExpansionExprEPKN5clang17PackExpansionExprE")
  //</editor-fold>
  public void VisitPackExpansionExpr(/*const*/ PackExpansionExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 777,
   FQN="(anonymous namespace)::StmtProfiler::VisitParenExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitParenExprEPKN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitParenExprEPKN5clang9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(/*const*/ ParenExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 781,
   FQN="(anonymous namespace)::StmtProfiler::VisitParenListExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitParenListExprEPKN5clang13ParenListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitParenListExprEPKN5clang13ParenListExprE")
  //</editor-fold>
  public void VisitParenListExpr(/*const*/ ParenListExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 743,
   FQN="(anonymous namespace)::StmtProfiler::VisitPredefinedExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitPredefinedExprEPKN5clang14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitPredefinedExprEPKN5clang14PredefinedExprE")
  //</editor-fold>
  public void VisitPredefinedExpr(/*const*/ PredefinedExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getIdentType().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 984,
   FQN="(anonymous namespace)::StmtProfiler::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitPseudoObjectExprEPKN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitPseudoObjectExprEPKN5clang16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(/*const*/ PseudoObjectExpr /*P*/ S) {
    VisitExpr(S);
    for (type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> i = $tryClone(S.semantics_begin$Const()), /*P*/ /*const*/ /*P*/ e = $tryClone(S.semantics_end$Const()); $noteq_ptr(i, e); i.$preInc())  {
      {
        // Normally, we would not profile the source expressions of OVEs.
        /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(i.$star());
        if ((OVE != null)) {
          Visit(OVE.getSourceExpr());
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 897,
   FQN="(anonymous namespace)::StmtProfiler::VisitShuffleVectorExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitShuffleVectorExprEPKN5clang17ShuffleVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitShuffleVectorExprEPKN5clang17ShuffleVectorExprE")
  //</editor-fold>
  public void VisitShuffleVectorExpr(/*const*/ ShuffleVectorExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1482,
   FQN="(anonymous namespace)::StmtProfiler::VisitSizeOfPackExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitSizeOfPackExprEPKN5clang14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitSizeOfPackExprEPKN5clang14SizeOfPackExprE")
  //</editor-fold>
  public void VisitSizeOfPackExpr(/*const*/ SizeOfPackExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getPack());
    if (S.isPartiallySubstituted()) {
      ArrayRef<TemplateArgument> Args = S.getPartialArguments();
      ID.AddInteger_uint(Args.size());
      for (final /*const*/ TemplateArgument /*&*/ TA : Args)  {
        VisitTemplateArgument(TA);
      }
    } else {
      ID.AddInteger_int(0);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 893,
   FQN="(anonymous namespace)::StmtProfiler::VisitStmtExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitStmtExprEPKN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitStmtExprEPKN5clang8StmtExprE")
  //</editor-fold>
  public void VisitStmtExpr(/*const*/ StmtExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 771,
   FQN="(anonymous namespace)::StmtProfiler::VisitStringLiteral", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitStringLiteralEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitStringLiteralEPKN5clang13StringLiteralE")
  //</editor-fold>
  public void VisitStringLiteral(/*const*/ StringLiteral /*P*/ S) {
    VisitExpr(S);
    ID.AddString(S.getBytes());
    ID.AddInteger_int(S.getKind().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1502,
   FQN="(anonymous namespace)::StmtProfiler::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler33VisitSubstNonTypeTemplateParmExprEPKN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler33VisitSubstNonTypeTemplateParmExprEPKN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmExpr(/*const*/ SubstNonTypeTemplateParmExpr /*P*/ E) {
    // Profile exactly as the replacement expression.
    Visit(E.getReplacement());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1495,
   FQN="(anonymous namespace)::StmtProfiler::VisitSubstNonTypeTemplateParmPackExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler37VisitSubstNonTypeTemplateParmPackExprEPKN5clang32SubstNonTypeTemplateParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler37VisitSubstNonTypeTemplateParmPackExprEPKN5clang32SubstNonTypeTemplateParmPackExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmPackExpr(/*const*/ SubstNonTypeTemplateParmPackExpr /*P*/ S) {
    VisitExpr(S);
    VisitDecl(S.getParameterPack());
    VisitTemplateArgument(S.getArgumentPack());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1407,
   FQN="(anonymous namespace)::StmtProfiler::VisitTypeTraitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitTypeTraitExprEPKN5clang13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitTypeTraitExprEPKN5clang13TypeTraitExprE")
  //</editor-fold>
  public void VisitTypeTraitExpr(/*const*/ TypeTraitExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getTrait().getValue());
    ID.AddInteger_uint(S.getNumArgs());
    for (/*uint*/int I = 0, N = S.getNumArgs(); I != N; ++I)  {
      VisitType(S.getArg(I).getType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1546,
   FQN="(anonymous namespace)::StmtProfiler::VisitTypoExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitTypoExprEPKN5clang8TypoExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitTypoExprEPKN5clang8TypoExprE")
  //</editor-fold>
  public void VisitTypoExpr(/*const*/ TypoExpr /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 818,
   FQN="(anonymous namespace)::StmtProfiler::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(/*const*/ UnaryExprOrTypeTraitExpr /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getKind().getValue());
    if (S.isArgumentType()) {
      VisitType(S.getArgumentType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 785,
   FQN="(anonymous namespace)::StmtProfiler::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitUnaryOperatorEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitUnaryOperatorEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ S) {
    VisitExpr(S);
    ID.AddInteger_int(S.getOpcode().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 913,
   FQN="(anonymous namespace)::StmtProfiler::VisitVAArgExpr", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitVAArgExprEPKN5clang9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitVAArgExprEPKN5clang9VAArgExprE")
  //</editor-fold>
  public void VisitVAArgExpr(/*const*/ VAArgExpr /*P*/ S) {
    VisitExpr(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 137,
   FQN="(anonymous namespace)::StmtProfiler::VisitForStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler12VisitForStmtEPKN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler12VisitForStmtEPKN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(/*const*/ ForStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 141,
   FQN="(anonymous namespace)::StmtProfiler::VisitGotoStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitGotoStmtEPKN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitGotoStmtEPKN5clang8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(/*const*/ GotoStmt /*P*/ S) {
    VisitStmt(S);
    VisitDecl(S.getLabel());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 118,
   FQN="(anonymous namespace)::StmtProfiler::VisitIfStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler11VisitIfStmtEPKN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler11VisitIfStmtEPKN5clang6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(/*const*/ IfStmt /*P*/ S) {
    VisitStmt(S);
    VisitDecl(S.getConditionVariable());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 146,
   FQN="(anonymous namespace)::StmtProfiler::VisitIndirectGotoStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitIndirectGotoStmtEPKN5clang16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitIndirectGotoStmtEPKN5clang16IndirectGotoStmtE")
  //</editor-fold>
  public void VisitIndirectGotoStmt(/*const*/ IndirectGotoStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 108,
   FQN="(anonymous namespace)::StmtProfiler::VisitLabelStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitLabelStmtEPKN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitLabelStmtEPKN5clang9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(/*const*/ LabelStmt /*P*/ S) {
    VisitStmt(S);
    VisitDecl(S.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 200,
   FQN="(anonymous namespace)::StmtProfiler::VisitMSDependentExistsStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitMSDependentExistsStmtEPKN5clang21MSDependentExistsStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitMSDependentExistsStmtEPKN5clang21MSDependentExistsStmtE")
  //</editor-fold>
  public void VisitMSDependentExistsStmt(/*const*/ MSDependentExistsStmt /*P*/ S) {
    VisitStmt(S);
    ID.AddBoolean(S.isIfExists());
    VisitNestedNameSpecifier(S.getQualifierLoc().getNestedNameSpecifier());
    VisitName(S.getNameInfo().getName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitNullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 88,
   FQN="(anonymous namespace)::StmtProfiler::VisitNullStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitNullStmtEPKN5clang8NullStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitNullStmtEPKN5clang8NullStmtE")
  //</editor-fold>
  public void VisitNullStmt(/*const*/ NullStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 542,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPExecutableDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitOMPExecutableDirectiveEPKN5clang22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitOMPExecutableDirectiveEPKN5clang22OMPExecutableDirectiveE")
  //</editor-fold>
  public void VisitOMPExecutableDirective(/*const*/ OMPExecutableDirective /*P*/ S) {
    VisitStmt(S);
    OMPClauseProfiler P/*J*/= new OMPClauseProfiler(this);
    ArrayRef<OMPClause /*P*/ > Clauses = S.clauses$Const();
    for (type$ptr<OMPClause /*P*/ /*P*/> I = $tryClone(Clauses.begin()), /*P*/ E = $tryClone(Clauses.end());
         $noteq_ptr(I, E); I.$preInc())  {
      if ((I.$star() != null)) {
        P.Visit(I.$star());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPAtomicDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 637,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPAtomicDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPAtomicDirectiveEPKN5clang18OMPAtomicDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPAtomicDirectiveEPKN5clang18OMPAtomicDirectiveE")
  //</editor-fold>
  public void VisitOMPAtomicDirective(/*const*/ OMPAtomicDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPBarrierDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 617,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPBarrierDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPBarrierDirectiveEPKN5clang19OMPBarrierDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPBarrierDirectiveEPKN5clang19OMPBarrierDirectiveE")
  //</editor-fold>
  public void VisitOMPBarrierDirective(/*const*/ OMPBarrierDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPCancelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 678,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPCancelDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPCancelDirectiveEPKN5clang18OMPCancelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPCancelDirectiveEPKN5clang18OMPCancelDirectiveE")
  //</editor-fold>
  public void VisitOMPCancelDirective(/*const*/ OMPCancelDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 673,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPCancellationPointDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler34VisitOMPCancellationPointDirectiveEPKN5clang29OMPCancellationPointDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler34VisitOMPCancellationPointDirectiveEPKN5clang29OMPCancellationPointDirectiveE")
  //</editor-fold>
  public void VisitOMPCancellationPointDirective(/*const*/ OMPCancellationPointDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 589,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPCriticalDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPCriticalDirectiveEPKN5clang20OMPCriticalDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPCriticalDirectiveEPKN5clang20OMPCriticalDirectiveE")
  //</editor-fold>
  public void VisitOMPCriticalDirective(/*const*/ OMPCriticalDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
    VisitName(S.getDirectiveName().getName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPFlushDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 629,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPFlushDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitOMPFlushDirectiveEPKN5clang17OMPFlushDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitOMPFlushDirectiveEPKN5clang17OMPFlushDirectiveE")
  //</editor-fold>
  public void VisitOMPFlushDirective(/*const*/ OMPFlushDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 553,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPLoopDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitOMPLoopDirectiveEPKN5clang16OMPLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitOMPLoopDirectiveEPKN5clang16OMPLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPLoopDirective(/*const*/ OMPLoopDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPDistributeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 691,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPDistributeDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitOMPDistributeDirectiveEPKN5clang22OMPDistributeDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitOMPDistributeDirectiveEPKN5clang22OMPDistributeDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeDirective(/*const*/ OMPDistributeDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 710,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPDistributeParallelForDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler38VisitOMPDistributeParallelForDirectiveEPKN5clang33OMPDistributeParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler38VisitOMPDistributeParallelForDirectiveEPKN5clang33OMPDistributeParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForDirective(/*const*/ OMPDistributeParallelForDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPDistributeParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 715,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPDistributeParallelForSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler42VisitOMPDistributeParallelForSimdDirectiveEPKN5clang37OMPDistributeParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler42VisitOMPDistributeParallelForSimdDirectiveEPKN5clang37OMPDistributeParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForSimdDirective(/*const*/ OMPDistributeParallelForSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPDistributeSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 720,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPDistributeSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler31VisitOMPDistributeSimdDirectiveEPKN5clang26OMPDistributeSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler31VisitOMPDistributeSimdDirectiveEPKN5clang26OMPDistributeSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeSimdDirective(/*const*/ OMPDistributeSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 565,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPForDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitOMPForDirectiveEPKN5clang15OMPForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitOMPForDirectiveEPKN5clang15OMPForDirectiveE")
  //</editor-fold>
  public void VisitOMPForDirective(/*const*/ OMPForDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 569,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPForSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPForSimdDirectiveEPKN5clang19OMPForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPForSimdDirectiveEPKN5clang19OMPForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPForSimdDirective(/*const*/ OMPForSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 594,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPParallelForDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler28VisitOMPParallelForDirectiveEPKN5clang23OMPParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler28VisitOMPParallelForDirectiveEPKN5clang23OMPParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForDirective(/*const*/ OMPParallelForDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 599,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPParallelForSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler32VisitOMPParallelForSimdDirectiveEPKN5clang27OMPParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler32VisitOMPParallelForSimdDirectiveEPKN5clang27OMPParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForSimdDirective(/*const*/ OMPParallelForSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 561,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitOMPSimdDirectiveEPKN5clang16OMPSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitOMPSimdDirectiveEPKN5clang16OMPSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPSimdDirective(/*const*/ OMPSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 725,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetParallelForSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler38VisitOMPTargetParallelForSimdDirectiveEPKN5clang33OMPTargetParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler38VisitOMPTargetParallelForSimdDirectiveEPKN5clang33OMPTargetParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForSimdDirective(/*const*/ OMPTargetParallelForSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTaskLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 682,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTaskLoopDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPTaskLoopDirectiveEPKN5clang20OMPTaskLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPTaskLoopDirectiveEPKN5clang20OMPTaskLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopDirective(/*const*/ OMPTaskLoopDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTaskLoopSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 686,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTaskLoopSimdDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler29VisitOMPTaskLoopSimdDirectiveEPKN5clang24OMPTaskLoopSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler29VisitOMPTaskLoopSimdDirectiveEPKN5clang24OMPTaskLoopSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopSimdDirective(/*const*/ OMPTaskLoopSimdDirective /*P*/ S) {
    VisitOMPLoopDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPMasterDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 585,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPMasterDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPMasterDirectiveEPKN5clang18OMPMasterDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPMasterDirectiveEPKN5clang18OMPMasterDirectiveE")
  //</editor-fold>
  public void VisitOMPMasterDirective(/*const*/ OMPMasterDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPOrderedDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 633,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPOrderedDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPOrderedDirectiveEPKN5clang19OMPOrderedDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPOrderedDirectiveEPKN5clang19OMPOrderedDirectiveE")
  //</editor-fold>
  public void VisitOMPOrderedDirective(/*const*/ OMPOrderedDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 557,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPParallelDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPParallelDirectiveEPKN5clang20OMPParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPParallelDirectiveEPKN5clang20OMPParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelDirective(/*const*/ OMPParallelDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPParallelSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 604,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPParallelSectionsDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler33VisitOMPParallelSectionsDirectiveEPKN5clang28OMPParallelSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler33VisitOMPParallelSectionsDirectiveEPKN5clang28OMPParallelSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelSectionsDirective(/*const*/ OMPParallelSectionsDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 577,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPSectionDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPSectionDirectiveEPKN5clang19OMPSectionDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitOMPSectionDirectiveEPKN5clang19OMPSectionDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionDirective(/*const*/ OMPSectionDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 573,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPSectionsDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPSectionsDirectiveEPKN5clang20OMPSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPSectionsDirectiveEPKN5clang20OMPSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionsDirective(/*const*/ OMPSectionsDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPSingleDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 581,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPSingleDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPSingleDirectiveEPKN5clang18OMPSingleDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPSingleDirectiveEPKN5clang18OMPSingleDirectiveE")
  //</editor-fold>
  public void VisitOMPSingleDirective(/*const*/ OMPSingleDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 645,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetDataDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitOMPTargetDataDirectiveEPKN5clang22OMPTargetDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitOMPTargetDataDirectiveEPKN5clang22OMPTargetDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDataDirective(/*const*/ OMPTargetDataDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 641,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPTargetDirectiveEPKN5clang18OMPTargetDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler23VisitOMPTargetDirectiveEPKN5clang18OMPTargetDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDirective(/*const*/ OMPTargetDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetEnterDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 649,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetEnterDataDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler32VisitOMPTargetEnterDataDirectiveEPKN5clang27OMPTargetEnterDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler32VisitOMPTargetEnterDataDirectiveEPKN5clang27OMPTargetEnterDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetEnterDataDirective(/*const*/ OMPTargetEnterDataDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetExitDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 654,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetExitDataDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler31VisitOMPTargetExitDataDirectiveEPKN5clang26OMPTargetExitDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler31VisitOMPTargetExitDataDirectiveEPKN5clang26OMPTargetExitDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetExitDataDirective(/*const*/ OMPTargetExitDataDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 659,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetParallelDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler31VisitOMPTargetParallelDirectiveEPKN5clang26OMPTargetParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler31VisitOMPTargetParallelDirectiveEPKN5clang26OMPTargetParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelDirective(/*const*/ OMPTargetParallelDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 664,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetParallelForDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler34VisitOMPTargetParallelForDirectiveEPKN5clang29OMPTargetParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler34VisitOMPTargetParallelForDirectiveEPKN5clang29OMPTargetParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForDirective(/*const*/ OMPTargetParallelForDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTargetUpdateDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 705,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTargetUpdateDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler29VisitOMPTargetUpdateDirectiveEPKN5clang24OMPTargetUpdateDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler29VisitOMPTargetUpdateDirectiveEPKN5clang24OMPTargetUpdateDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetUpdateDirective(/*const*/ OMPTargetUpdateDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTaskDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 609,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTaskDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitOMPTaskDirectiveEPKN5clang16OMPTaskDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitOMPTaskDirectiveEPKN5clang16OMPTaskDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskDirective(/*const*/ OMPTaskDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTaskgroupDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 625,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTaskgroupDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitOMPTaskgroupDirectiveEPKN5clang21OMPTaskgroupDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitOMPTaskgroupDirectiveEPKN5clang21OMPTaskgroupDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskgroupDirective(/*const*/ OMPTaskgroupDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTaskwaitDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 621,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTaskwaitDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPTaskwaitDirectiveEPKN5clang20OMPTaskwaitDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler25VisitOMPTaskwaitDirectiveEPKN5clang20OMPTaskwaitDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskwaitDirective(/*const*/ OMPTaskwaitDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTaskyieldDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 613,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTaskyieldDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitOMPTaskyieldDirectiveEPKN5clang21OMPTaskyieldDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitOMPTaskyieldDirectiveEPKN5clang21OMPTaskyieldDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskyieldDirective(/*const*/ OMPTaskyieldDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitOMPTeamsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 669,
   FQN="(anonymous namespace)::StmtProfiler::VisitOMPTeamsDirective", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitOMPTeamsDirectiveEPKN5clang17OMPTeamsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitOMPTeamsDirectiveEPKN5clang17OMPTeamsDirectiveE")
  //</editor-fold>
  public void VisitOMPTeamsDirective(/*const*/ OMPTeamsDirective /*P*/ S) {
    VisitOMPExecutableDirective(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 231,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAtCatchStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCAtCatchStmtEPKN5clang15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCAtCatchStmtEPKN5clang15ObjCAtCatchStmtE")
  //</editor-fold>
  public void VisitObjCAtCatchStmt(/*const*/ ObjCAtCatchStmt /*P*/ S) {
    VisitStmt(S);
    ID.AddBoolean(S.hasEllipsis());
    if ((S.getCatchParamDecl$Const() != null)) {
      VisitType(S.getCatchParamDecl$Const().getType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 238,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAtFinallyStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitObjCAtFinallyStmtEPKN5clang17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitObjCAtFinallyStmtEPKN5clang17ObjCAtFinallyStmtE")
  //</editor-fold>
  public void VisitObjCAtFinallyStmt(/*const*/ ObjCAtFinallyStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 246,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAtSynchronizedStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler27VisitObjCAtSynchronizedStmtEPKN5clang22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler27VisitObjCAtSynchronizedStmtEPKN5clang22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public void VisitObjCAtSynchronizedStmt(/*const*/ ObjCAtSynchronizedStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 251,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAtThrowStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCAtThrowStmtEPKN5clang15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler20VisitObjCAtThrowStmtEPKN5clang15ObjCAtThrowStmtE")
  //</editor-fold>
  public void VisitObjCAtThrowStmt(/*const*/ ObjCAtThrowStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 242,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAtTryStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitObjCAtTryStmtEPKN5clang13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitObjCAtTryStmtEPKN5clang13ObjCAtTryStmtE")
  //</editor-fold>
  public void VisitObjCAtTryStmt(/*const*/ ObjCAtTryStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 255,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCAutoreleasePoolStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler28VisitObjCAutoreleasePoolStmtEPKN5clang23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler28VisitObjCAutoreleasePoolStmtEPKN5clang23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public void VisitObjCAutoreleasePoolStmt(/*const*/ ObjCAutoreleasePoolStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 227,
   FQN="(anonymous namespace)::StmtProfiler::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler26VisitObjCForCollectionStmtEPKN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler26VisitObjCForCollectionStmtEPKN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(/*const*/ ObjCForCollectionStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 158,
   FQN="(anonymous namespace)::StmtProfiler::VisitReturnStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitReturnStmtEPKN5clang10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitReturnStmtEPKN5clang10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(/*const*/ ReturnStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 215,
   FQN="(anonymous namespace)::StmtProfiler::VisitSEHExceptStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler18VisitSEHExceptStmtEPKN5clang13SEHExceptStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler18VisitSEHExceptStmtEPKN5clang13SEHExceptStmtE")
  //</editor-fold>
  public void VisitSEHExceptStmt(/*const*/ SEHExceptStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 211,
   FQN="(anonymous namespace)::StmtProfiler::VisitSEHFinallyStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler19VisitSEHFinallyStmtEPKN5clang14SEHFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler19VisitSEHFinallyStmtEPKN5clang14SEHFinallyStmtE")
  //</editor-fold>
  public void VisitSEHFinallyStmt(/*const*/ SEHFinallyStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSEHLeaveStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 219,
   FQN="(anonymous namespace)::StmtProfiler::VisitSEHLeaveStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitSEHLeaveStmtEPKN5clang12SEHLeaveStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitSEHLeaveStmtEPKN5clang12SEHLeaveStmtE")
  //</editor-fold>
  public void VisitSEHLeaveStmt(/*const*/ SEHLeaveStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 207,
   FQN="(anonymous namespace)::StmtProfiler::VisitSEHTryStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitSEHTryStmtEPKN5clang10SEHTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitSEHTryStmtEPKN5clang10SEHTryStmtE")
  //</editor-fold>
  public void VisitSEHTryStmt(/*const*/ SEHTryStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 96,
   FQN="(anonymous namespace)::StmtProfiler::VisitSwitchCase", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitSwitchCaseEPKN5clang10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitSwitchCaseEPKN5clang10SwitchCaseE")
  //</editor-fold>
  public void VisitSwitchCase(/*const*/ SwitchCase /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 100,
   FQN="(anonymous namespace)::StmtProfiler::VisitCaseStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler13VisitCaseStmtEPKN5clang8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler13VisitCaseStmtEPKN5clang8CaseStmtE")
  //</editor-fold>
  public void VisitCaseStmt(/*const*/ CaseStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 104,
   FQN="(anonymous namespace)::StmtProfiler::VisitDefaultStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler16VisitDefaultStmtEPKN5clang11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler16VisitDefaultStmtEPKN5clang11DefaultStmtE")
  //</editor-fold>
  public void VisitDefaultStmt(/*const*/ DefaultStmt /*P*/ S) {
    VisitStmt(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 123,
   FQN="(anonymous namespace)::StmtProfiler::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler15VisitSwitchStmtEPKN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler15VisitSwitchStmtEPKN5clang10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(/*const*/ SwitchStmt /*P*/ S) {
    VisitStmt(S);
    VisitDecl(S.getConditionVariable());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 128,
   FQN="(anonymous namespace)::StmtProfiler::VisitWhileStmt", NM="_ZN12_GLOBAL__N_112StmtProfiler14VisitWhileStmtEPKN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler14VisitWhileStmtEPKN5clang9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(/*const*/ WhileStmt /*P*/ S) {
    VisitStmt(S);
    VisitDecl(S.getConditionVariable());
  }

  
  /// \brief Visit a declaration that is referenced within an expression
  /// or statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1640,
   FQN="(anonymous namespace)::StmtProfiler::VisitDecl", NM="_ZN12_GLOBAL__N_112StmtProfiler9VisitDeclEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler9VisitDeclEPKN5clang4DeclE")
  //</editor-fold>
  public void VisitDecl(/*const*/ Decl /*P*/ D) {
    ID.AddInteger_int((D != null) ? D.getKind().getValue() : 0);
    if (Canonical && (D != null)) {
      {
        /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(D);
        if ((NTTP != null)) {
          ID.AddInteger_uint(NTTP.getDepth());
          ID.AddInteger_uint(NTTP.getIndex());
          ID.AddBoolean(NTTP.isParameterPack());
          VisitType(NTTP.getType());
          return;
        }
      }
      {
        
        /*const*/ ParmVarDecl /*P*/ Parm = dyn_cast_ParmVarDecl(D);
        if ((Parm != null)) {
          // The Itanium C++ ABI uses the type, scope depth, and scope
          // index of a parameter when mangling expressions that involve
          // function parameters, so we will use the parameter's type for
          // establishing function parameter identity. That way, our
          // definition of "equivalent" (per C++ [temp.over.link]) is at
          // least as strong as the definition of "equivalent" used for
          // name mangling.
          VisitType(Parm.getType());
          ID.AddInteger_uint(Parm.getFunctionScopeDepth());
          ID.AddInteger_uint(Parm.getFunctionScopeIndex());
          return;
        }
      }
      {
        
        /*const*/ TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(D);
        if ((TTP != null)) {
          ID.AddInteger_uint(TTP.getDepth());
          ID.AddInteger_uint(TTP.getIndex());
          ID.AddBoolean(TTP.isParameterPack());
          return;
        }
      }
      {
        
        /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(D);
        if ((TTP != null)) {
          ID.AddInteger_uint(TTP.getDepth());
          ID.AddInteger_uint(TTP.getIndex());
          ID.AddBoolean(TTP.isParameterPack());
          return;
        }
      }
    }
    
    ID.AddPointer((D != null) ? D.getCanonicalDecl$Const() : (/*const*/ Decl /*P*/ )null);
  }

  
  /// \brief Visit a type that is referenced within an expression or
  /// statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1687,
   FQN="(anonymous namespace)::StmtProfiler::VisitType", NM="_ZN12_GLOBAL__N_112StmtProfiler9VisitTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler9VisitTypeEN5clang8QualTypeE")
  //</editor-fold>
  public void VisitType(QualType T) {
    if (Canonical) {
      T.$assignMove(Context.getCanonicalType(/*NO_COPY*/T).$QualType());
    }
    
    ID.AddPointer(T.getAsOpaquePtr());
  }

  
  /// \brief Visit a name that occurs within an expression or statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1694,
   FQN="(anonymous namespace)::StmtProfiler::VisitName", NM="_ZN12_GLOBAL__N_112StmtProfiler9VisitNameEN5clang15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler9VisitNameEN5clang15DeclarationNameE")
  //</editor-fold>
  public void VisitName(DeclarationName Name) {
    ID.AddPointer(Name.getAsOpaquePtr());
  }

  
  /// \brief Visit a nested-name-specifier that occurs within an expression
  /// or statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1698,
   FQN="(anonymous namespace)::StmtProfiler::VisitNestedNameSpecifier", NM="_ZN12_GLOBAL__N_112StmtProfiler24VisitNestedNameSpecifierEPN5clang19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler24VisitNestedNameSpecifierEPN5clang19NestedNameSpecifierE")
  //</editor-fold>
  public void VisitNestedNameSpecifier(NestedNameSpecifier /*P*/ NNS) {
    if (Canonical) {
      NNS = Context.getCanonicalNestedNameSpecifier(NNS);
    }
    ID.AddPointer(NNS);
  }

  
  /// \brief Visit a template name that occurs within an expression or
  /// statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1704,
   FQN="(anonymous namespace)::StmtProfiler::VisitTemplateName", NM="_ZN12_GLOBAL__N_112StmtProfiler17VisitTemplateNameEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler17VisitTemplateNameEN5clang12TemplateNameE")
  //</editor-fold>
  public void VisitTemplateName(TemplateName Name) {
    if (Canonical) {
      Name.$assignMove(Context.getCanonicalTemplateName(new TemplateName(Name)));
    }
    
    Name.Profile(ID);
  }

  
  /// \brief Visit template arguments that occur within an expression or
  /// statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1711,
   FQN="(anonymous namespace)::StmtProfiler::VisitTemplateArguments", NM="_ZN12_GLOBAL__N_112StmtProfiler22VisitTemplateArgumentsEPKN5clang19TemplateArgumentLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler22VisitTemplateArgumentsEPKN5clang19TemplateArgumentLocEj")
  //</editor-fold>
  public void VisitTemplateArguments(/*const*/type$ptr<TemplateArgumentLoc/*P*/> Args, 
                        /*uint*/int NumArgs) {
    ID.AddInteger_uint(NumArgs);
    for (/*uint*/int I = 0; I != NumArgs; ++I)  {
      VisitTemplateArgument(Args.$at(I).getArgument());
    }
  }

  
  /// \brief Visit a single template argument.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtProfiler::VisitTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1718,
   FQN="(anonymous namespace)::StmtProfiler::VisitTemplateArgument", NM="_ZN12_GLOBAL__N_112StmtProfiler21VisitTemplateArgumentERKN5clang16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZN12_GLOBAL__N_112StmtProfiler21VisitTemplateArgumentERKN5clang16TemplateArgumentE")
  //</editor-fold>
  public void VisitTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg) {
    // Mostly repetitive with TemplateArgument::Profile!
    ID.AddInteger_int(Arg.getKind().getValue());
    switch (Arg.getKind()) {
     case Null:
      break;
     case Type:
      VisitType(Arg.getAsType());
      break;
     case Template:
     case TemplateExpansion:
      VisitTemplateName(Arg.getAsTemplateOrTemplatePattern());
      break;
     case Declaration:
      VisitDecl(Arg.getAsDecl());
      break;
     case NullPtr:
      VisitType(Arg.getNullPtrType());
      break;
     case Integral:
      Arg.getAsIntegral().Profile(ID);
      VisitType(Arg.getIntegralType());
      break;
     case Expression:
      Visit(Arg.getAsExpr());
      break;
     case Pack:
      for (final /*const*/ TemplateArgument /*&*/ P : Arg.pack_elements())  {
        VisitTemplateArgument(P);
      }
      break;
    }
  }

  
  @Override public String toString() {
    return "" + "ID=" + ID // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Canonical=" + Canonical // NOI18N
              + super.toString(); // NOI18N
  }
}
