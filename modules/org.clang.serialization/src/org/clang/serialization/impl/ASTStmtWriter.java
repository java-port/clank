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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.serialization.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 31,
 FQN="clang::ASTStmtWriter", NM="_ZN5clang13ASTStmtWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriterE")
//</editor-fold>
public class ASTStmtWriter implements /*public*/ StmtVisitorVoid<ASTStmtWriter>, Destructors.ClassWithDestructor {
  private final ASTWriter /*&*/ Writer;
  private ASTRecordWriter Record;
  
  private /*StmtCode*/int Code;
  private /*uint*/int AbbrevToUse;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::ASTStmtWriter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 39,
   FQN="clang::ASTStmtWriter::ASTStmtWriter", NM="_ZN5clang13ASTStmtWriterC1ERNS_9ASTWriterERN4llvm11SmallVectorIyLj64EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriterC1ERNS_9ASTWriterERN4llvm11SmallVectorIyLj64EEE")
  //</editor-fold>
  public ASTStmtWriter(final ASTWriter /*&*/ Writer, final SmallVectorULong /*&*/ Record) {
    // : StmtVisitor<ASTStmtWriter, void>(), Writer(Writer), Record(Writer, Record), Code(serialization::STMT_NULL_PTR), AbbrevToUse(0) 
    //START JInit
    $StmtVisitor();
    this./*&*/Writer=/*&*/Writer;
    this.Record = new ASTRecordWriter(Writer, Record);
    this.Code = StmtCode.STMT_NULL_PTR;
    this.AbbrevToUse = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::ASTStmtWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 43,
   FQN="clang::ASTStmtWriter::ASTStmtWriter", NM="_ZN5clang13ASTStmtWriterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriterC1ERKS0_")
  //</editor-fold>
  public ASTStmtWriter(final /*const*/ ASTStmtWriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::Emit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 45,
   FQN="clang::ASTStmtWriter::Emit", NM="_ZN5clang13ASTStmtWriter4EmitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter4EmitEv")
  //</editor-fold>
  public long/*uint64_t*/ Emit() {
    assert (Code != StmtCode.STMT_NULL_PTR) : "unhandled sub-statement writing AST file";
    return Record.EmitStmt(Code, AbbrevToUse);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::AddTemplateKWAndArgsInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 61,
   FQN="clang::ASTStmtWriter::AddTemplateKWAndArgsInfo", NM="_ZN5clang13ASTStmtWriter24AddTemplateKWAndArgsInfoERKNS_24ASTTemplateKWAndArgsInfoEPKNS_19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24AddTemplateKWAndArgsInfoERKNS_24ASTTemplateKWAndArgsInfoEPKNS_19TemplateArgumentLocE")
  //</editor-fold>
  public void AddTemplateKWAndArgsInfo(final /*const*/ ASTTemplateKWAndArgsInfo /*&*/ ArgInfo, /*const*/ type$ptr<TemplateArgumentLoc /*P*/> Args) {
    Record.AddSourceLocation(new SourceLocation(ArgInfo.TemplateKWLoc));
    Record.AddSourceLocation(new SourceLocation(ArgInfo.LAngleLoc));
    Record.AddSourceLocation(new SourceLocation(ArgInfo.RAngleLoc));
    for (/*uint*/int i = 0; i != ArgInfo.NumTemplateArgs; ++i)  {
      Record.AddTemplateArgumentLoc(Args.$at(i));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 70,
   FQN="clang::ASTStmtWriter::VisitStmt", NM="_ZN5clang13ASTStmtWriter9VisitStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter9VisitStmtEPNS_4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 234,
   FQN="clang::ASTStmtWriter::VisitAsmStmt", NM="_ZN5clang13ASTStmtWriter12VisitAsmStmtEPNS_7AsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter12VisitAsmStmtEPNS_7AsmStmtE")
  //</editor-fold>
  public void VisitAsmStmt(AsmStmt /*P*/ S) {
    VisitStmt(S);
    Record.push_back($uint2ulong(S.getNumOutputs()));
    Record.push_back($uint2ulong(S.getNumInputs()));
    Record.push_back($uint2ulong(S.getNumClobbers()));
    Record.AddSourceLocation(S.getAsmLoc());
    Record.push_back((S.isVolatile() ? 1 : 0));
    Record.push_back((S.isSimple() ? 1 : 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 244,
   FQN="clang::ASTStmtWriter::VisitGCCAsmStmt", NM="_ZN5clang13ASTStmtWriter15VisitGCCAsmStmtEPNS_10GCCAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitGCCAsmStmtEPNS_10GCCAsmStmtE")
  //</editor-fold>
  public void VisitGCCAsmStmt(GCCAsmStmt /*P*/ S) {
    VisitAsmStmt(S);
    Record.AddSourceLocation(S.getRParenLoc());
    Record.AddStmt(S.getAsmString());
    
    // Outputs
    for (/*uint*/int I = 0, N = S.getNumOutputs(); I != N; ++I) {
      Record.AddIdentifierRef(S.getOutputIdentifier(I));
      Record.AddStmt(S.getOutputConstraintLiteral(I));
      Record.AddStmt(S.getOutputExpr(I));
    }
    
    // Inputs
    for (/*uint*/int I = 0, N = S.getNumInputs(); I != N; ++I) {
      Record.AddIdentifierRef(S.getInputIdentifier(I));
      Record.AddStmt(S.getInputConstraintLiteral(I));
      Record.AddStmt(S.getInputExpr(I));
    }
    
    // Clobbers
    for (/*uint*/int I = 0, N = S.getNumClobbers(); I != N; ++I)  {
      Record.AddStmt(S.getClobberStringLiteral(I));
    }
    
    Code = StmtCode.STMT_GCCASM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitMSAsmStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 270,
   FQN="clang::ASTStmtWriter::VisitMSAsmStmt", NM="_ZN5clang13ASTStmtWriter14VisitMSAsmStmtEPNS_9MSAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitMSAsmStmtEPNS_9MSAsmStmtE")
  //</editor-fold>
  public void VisitMSAsmStmt(MSAsmStmt /*P*/ S) {
    VisitAsmStmt(S);
    Record.AddSourceLocation(S.getLBraceLoc());
    Record.AddSourceLocation(S.getEndLoc());
    Record.push_back($uint2ulong(S.getNumAsmToks()));
    Record.AddString(S.getAsmString());
    
    // Tokens
    for (/*uint*/int I = 0, N = S.getNumAsmToks(); I != N; ++I) {
      // FIXME: Move this to ASTRecordWriter?
      Writer.AddToken(S.getAsmToks().$at(I), Record.getRecordData());
    }
    
    // Clobbers
    for (/*uint*/int I = 0, N = S.getNumClobbers(); I != N; ++I) {
      Record.AddString(S.getClobber(I));
    }
    
    // Outputs
    for (/*uint*/int I = 0, N = S.getNumOutputs(); I != N; ++I) {
      Record.AddStmt(S.getOutputExpr(I));
      Record.AddString(S.getOutputConstraint(I));
    }
    
    // Inputs
    for (/*uint*/int I = 0, N = S.getNumInputs(); I != N; ++I) {
      Record.AddStmt(S.getInputExpr(I));
      Record.AddString(S.getInputConstraint(I));
    }
    
    Code = StmtCode.STMT_MSASM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 120,
   FQN="clang::ASTStmtWriter::VisitAttributedStmt", NM="_ZN5clang13ASTStmtWriter19VisitAttributedStmtEPNS_14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitAttributedStmtEPNS_14AttributedStmtE")
  //</editor-fold>
  public void VisitAttributedStmt(AttributedStmt /*P*/ S) {
    VisitStmt(S);
    Record.push_back($uint2ulong(S.getAttrs().size()));
    Record.AddAttributes(S.getAttrs());
    Record.AddStmt(S.getSubStmt());
    Record.AddSourceLocation(S.getAttrLoc());
    Code = StmtCode.STMT_ATTRIBUTED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitBreakStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 210,
   FQN="clang::ASTStmtWriter::VisitBreakStmt", NM="_ZN5clang13ASTStmtWriter14VisitBreakStmtEPNS_9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitBreakStmtEPNS_9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(BreakStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getBreakLoc());
    Code = StmtCode.STMT_BREAK;
  }

  
  //===----------------------------------------------------------------------===//
  // C++ Expressions and Statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1156,
   FQN="clang::ASTStmtWriter::VisitCXXCatchStmt", NM="_ZN5clang13ASTStmtWriter17VisitCXXCatchStmtEPNS_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitCXXCatchStmtEPNS_12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(CXXCatchStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getCatchLoc());
    Record.AddDeclRef(S.getExceptionDecl());
    Record.AddStmt(S.getHandlerBlock());
    Code = StmtCode.STMT_CXX_CATCH;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1174,
   FQN="clang::ASTStmtWriter::VisitCXXForRangeStmt", NM="_ZN5clang13ASTStmtWriter20VisitCXXForRangeStmtEPNS_15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitCXXForRangeStmtEPNS_15CXXForRangeStmtE")
  //</editor-fold>
  public void VisitCXXForRangeStmt(CXXForRangeStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getForLoc());
    Record.AddSourceLocation(S.getCoawaitLoc());
    Record.AddSourceLocation(S.getColonLoc());
    Record.AddSourceLocation(S.getRParenLoc());
    Record.AddStmt(S.getRangeStmt());
    Record.AddStmt(S.getBeginStmt());
    Record.AddStmt(S.getEndStmt());
    Record.AddStmt(S.getCond());
    Record.AddStmt(S.getInc());
    Record.AddStmt(S.getLoopVarStmt());
    Record.AddStmt(S.getBody());
    Code = StmtCode.STMT_CXX_FOR_RANGE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1164,
   FQN="clang::ASTStmtWriter::VisitCXXTryStmt", NM="_ZN5clang13ASTStmtWriter15VisitCXXTryStmtEPNS_10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitCXXTryStmtEPNS_10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(CXXTryStmt /*P*/ S) {
    VisitStmt(S);
    Record.push_back($uint2ulong(S.getNumHandlers()));
    Record.AddSourceLocation(S.getTryLoc());
    Record.AddStmt(S.getTryBlock());
    for (/*uint*/int i = 0, e = S.getNumHandlers(); i != e; ++i)  {
      Record.AddStmt(S.getHandler(i));
    }
    Code = StmtCode.STMT_CXX_TRY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCapturedStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 323,
   FQN="clang::ASTStmtWriter::VisitCapturedStmt", NM="_ZN5clang13ASTStmtWriter17VisitCapturedStmtEPNS_12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitCapturedStmtEPNS_12CapturedStmtE")
  //</editor-fold>
  public void VisitCapturedStmt(CapturedStmt /*P*/ S) {
    VisitStmt(S);
    // NumCaptures
    Record.push_back(/*$difference_type$Capture$P2ulong(*/std.distance(S.capture_begin(), S.capture_end())/*)*/);
    
    // CapturedDecl and captured region kind
    Record.AddDeclRef(S.getCapturedDecl());
    Record.push_back(S.getCapturedRegionKind().getValue());
    
    Record.AddDeclRef(S.getCapturedRecordDecl());
    
    // Capture inits
    for (Expr /*P*/ I : S.capture_inits())  {
      Record.AddStmt(I);
    }
    
    // Body
    Record.AddStmt(S.getCapturedStmt());
    
    // Captures
    for (final /*const*/ CapturedStmt.Capture /*&*/ I : S.captures()) {
      if (I.capturesThis() || I.capturesVariableArrayType()) {
        Record.AddDeclRef((/*const*/ Decl /*P*/ )null);
      } else {
        Record.AddDeclRef(I.getCapturedVar());
      }
      Record.push_back(I.getCaptureKind().getValue());
      Record.AddSourceLocation(I.getLocation());
    }
    
    Code = StmtCode.STMT_CAPTURED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 80,
   FQN="clang::ASTStmtWriter::VisitCompoundStmt", NM="_ZN5clang13ASTStmtWriter17VisitCompoundStmtEPNS_12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitCompoundStmtEPNS_12CompoundStmtE")
  //</editor-fold>
  public void VisitCompoundStmt(CompoundStmt /*P*/ S) {
    VisitStmt(S);
    Record.push_back($uint2ulong(S.size()));
    for (Stmt /*P*/ CS : S.body())  {
      Record.AddStmt(CS);
    }
    Record.AddSourceLocation(S.getLBracLoc());
    Record.AddSourceLocation(S.getRBracLoc());
    Code = StmtCode.STMT_COMPOUND;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitContinueStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 204,
   FQN="clang::ASTStmtWriter::VisitContinueStmt", NM="_ZN5clang13ASTStmtWriter17VisitContinueStmtEPNS_12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitContinueStmtEPNS_12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(ContinueStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getContinueLoc());
    Code = StmtCode.STMT_CONTINUE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 308,
   FQN="clang::ASTStmtWriter::VisitCoreturnStmt", NM="_ZN5clang13ASTStmtWriter17VisitCoreturnStmtEPNS_12CoreturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitCoreturnStmtEPNS_12CoreturnStmtE")
  //</editor-fold>
  public void VisitCoreturnStmt(CoreturnStmt /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 303,
   FQN="clang::ASTStmtWriter::VisitCoroutineBodyStmt", NM="_ZN5clang13ASTStmtWriter22VisitCoroutineBodyStmtEPNS_17CoroutineBodyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitCoroutineBodyStmtEPNS_17CoroutineBodyStmtE")
  //</editor-fold>
  public void VisitCoroutineBodyStmt(CoroutineBodyStmt /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDeclStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 224,
   FQN="clang::ASTStmtWriter::VisitDeclStmt", NM="_ZN5clang13ASTStmtWriter13VisitDeclStmtEPNS_8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitDeclStmtEPNS_8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getStartLoc());
    Record.AddSourceLocation(S.getEndLoc());
    DeclGroupRef DG = S.getDeclGroup();
    for (type$ptr<Decl/*P*/>/*iterator*/ D = $tryClone(DG.begin()), /*P*/ /*P*/ DEnd = $tryClone(DG.end()); $noteq_ptr(D, DEnd); D.$preInc())  {
      Record.AddDeclRef(D.$star());
    }
    Code = StmtCode.STMT_DECL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDoStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 165,
   FQN="clang::ASTStmtWriter::VisitDoStmt", NM="_ZN5clang13ASTStmtWriter11VisitDoStmtEPNS_6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter11VisitDoStmtEPNS_6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(DoStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddStmt(S.getCond());
    Record.AddStmt(S.getBody());
    Record.AddSourceLocation(S.getDoLoc());
    Record.AddSourceLocation(S.getWhileLoc());
    Record.AddSourceLocation(S.getRParenLoc());
    Code = StmtCode.STMT_DO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 354,
   FQN="clang::ASTStmtWriter::VisitExpr", NM="_ZN5clang13ASTStmtWriter9VisitExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter9VisitExprEPNS_4ExprE")
  //</editor-fold>
  public void VisitExpr(Expr /*P*/ E) {
    VisitStmt(E);
    Record.AddTypeRef(E.getType());
    Record.push_back((E.isTypeDependent() ? 1 : 0));
    Record.push_back((E.isValueDependent() ? 1 : 0));
    Record.push_back((E.isInstantiationDependent() ? 1 : 0));
    Record.push_back((E.containsUnexpandedParameterPack() ? 1 : 0));
    Record.push_back(E.getValueKind().getValue());
    Record.push_back(E.getObjectKind().getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 119,
   FQN="clang::ASTStmtWriter::VisitAbstractConditionalOperator", NM="_ZN5clang13ASTStmtWriter32VisitAbstractConditionalOperatorEPNS_27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter32VisitAbstractConditionalOperatorEPNS_27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(AbstractConditionalOperator /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 669,
   FQN="clang::ASTStmtWriter::VisitBinaryConditionalOperator", NM="_ZN5clang13ASTStmtWriter30VisitBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter30VisitBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE")
  //</editor-fold>
  public void VisitBinaryConditionalOperator(BinaryConditionalOperator /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getOpaqueValue());
    Record.AddStmt(E.getCommon());
    Record.AddStmt(E.getCond());
    Record.AddStmt(E.getTrueExpr());
    Record.AddStmt(E.getFalseExpr());
    Record.AddSourceLocation(E.getQuestionLoc());
    Record.AddSourceLocation(E.getColonLoc());
    Code = StmtCode.EXPR_BINARY_CONDITIONAL_OPERATOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 659,
   FQN="clang::ASTStmtWriter::VisitConditionalOperator", NM="_ZN5clang13ASTStmtWriter24VisitConditionalOperatorEPNS_19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitConditionalOperatorEPNS_19ConditionalOperatorE")
  //</editor-fold>
  public void VisitConditionalOperator(ConditionalOperator /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getCond());
    Record.AddStmt(E.getLHS());
    Record.AddStmt(E.getRHS());
    Record.AddSourceLocation(E.getQuestionLoc());
    Record.AddSourceLocation(E.getColonLoc());
    Code = StmtCode.EXPR_CONDITIONAL_OPERATOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 810,
   FQN="clang::ASTStmtWriter::VisitAddrLabelExpr", NM="_ZN5clang13ASTStmtWriter18VisitAddrLabelExprEPNS_13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitAddrLabelExprEPNS_13AddrLabelExprE")
  //</editor-fold>
  public void VisitAddrLabelExpr(AddrLabelExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getAmpAmpLoc());
    Record.AddSourceLocation(E.getLabelLoc());
    Record.AddDeclRef(E.getLabel());
    Code = StmtCode.EXPR_ADDR_LABEL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 540,
   FQN="clang::ASTStmtWriter::VisitArraySubscriptExpr", NM="_ZN5clang13ASTStmtWriter23VisitArraySubscriptExprEPNS_18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitArraySubscriptExprEPNS_18ArraySubscriptExprE")
  //</editor-fold>
  public void VisitArraySubscriptExpr(ArraySubscriptExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getLHS());
    Record.AddStmt(E.getRHS());
    Record.AddSourceLocation(E.getRBracketLoc());
    Code = StmtCode.EXPR_ARRAY_SUBSCRIPT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1573,
   FQN="clang::ASTStmtWriter::VisitArrayTypeTraitExpr", NM="_ZN5clang13ASTStmtWriter23VisitArrayTypeTraitExprEPNS_18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitArrayTypeTraitExprEPNS_18ArrayTypeTraitExprE")
  //</editor-fold>
  public void VisitArrayTypeTraitExpr(ArrayTypeTraitExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back(E.getTrait().getValue());
    Record.push_back(E.getValue());
    Record.AddSourceRange(E.getSourceRange());
    Record.AddTypeSourceInfo(E.getQueriedTypeSourceInfo());
    Code = StmtCode.EXPR_ARRAY_TYPE_TRAIT;
  }

  
  //===----------------------------------------------------------------------===//
  // OpenCL Expressions and Statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitAsTypeExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1698,
   FQN="clang::ASTStmtWriter::VisitAsTypeExpr", NM="_ZN5clang13ASTStmtWriter15VisitAsTypeExprEPNS_10AsTypeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitAsTypeExprEPNS_10AsTypeExprE")
  //</editor-fold>
  public void VisitAsTypeExpr(AsTypeExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getBuiltinLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Record.AddStmt(E.getSrcExpr());
    Code = StmtCode.EXPR_ASTYPE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 903,
   FQN="clang::ASTStmtWriter::VisitAtomicExpr", NM="_ZN5clang13ASTStmtWriter15VisitAtomicExprEPNS_10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitAtomicExprEPNS_10AtomicExprE")
  //</editor-fold>
  public void VisitAtomicExpr(AtomicExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back(E.getOp().getValue());
    for (/*uint*/int I = 0, N = E.getNumSubExprs(); I != N; ++I)  {
      Record.AddStmt(E.getSubExprs().$at(I));
    }
    Record.AddSourceLocation(E.getBuiltinLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_ATOMIC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 642,
   FQN="clang::ASTStmtWriter::VisitBinaryOperator", NM="_ZN5clang13ASTStmtWriter19VisitBinaryOperatorEPNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitBinaryOperatorEPNS_14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getLHS());
    Record.AddStmt(E.getRHS());
    Record.push_back(E.getOpcode().getValue()); // FIXME: stable encoding
    Record.AddSourceLocation(E.getOperatorLoc());
    Record.push_back((E.isFPContractable() ? 1 : 0));
    Code = StmtCode.EXPR_BINARY_OPERATOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 652,
   FQN="clang::ASTStmtWriter::VisitCompoundAssignOperator", NM="_ZN5clang13ASTStmtWriter27VisitCompoundAssignOperatorEPNS_22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitCompoundAssignOperatorEPNS_22CompoundAssignOperatorE")
  //</editor-fold>
  public void VisitCompoundAssignOperator(CompoundAssignOperator /*P*/ E) {
    VisitBinaryOperator(E);
    Record.AddTypeRef(E.getComputationLHSType());
    Record.AddTypeRef(E.getComputationResultType());
    Code = StmtCode.EXPR_COMPOUND_ASSIGN_OPERATOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitBlockExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 862,
   FQN="clang::ASTStmtWriter::VisitBlockExpr", NM="_ZN5clang13ASTStmtWriter14VisitBlockExprEPNS_9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitBlockExprEPNS_9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getBlockDecl());
    Code = StmtCode.EXPR_BLOCK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1377,
   FQN="clang::ASTStmtWriter::VisitCXXBindTemporaryExpr", NM="_ZN5clang13ASTStmtWriter25VisitCXXBindTemporaryExprEPNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitCXXBindTemporaryExprEPNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddCXXTemporary(E.getTemporary());
    Record.AddStmt(E.getSubExpr());
    Code = StmtCode.EXPR_CXX_BIND_TEMPORARY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1323,
   FQN="clang::ASTStmtWriter::VisitCXXBoolLiteralExpr", NM="_ZN5clang13ASTStmtWriter23VisitCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE")
  //</editor-fold>
  public void VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back((E.getValue() ? 1 : 0));
    Record.AddSourceLocation(E.getLocation());
    Code = StmtCode.EXPR_CXX_BOOL_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1213,
   FQN="clang::ASTStmtWriter::VisitCXXConstructExpr", NM="_ZN5clang13ASTStmtWriter21VisitCXXConstructExprEPNS_16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitCXXConstructExprEPNS_16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumArgs()));
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I)  {
      Record.AddStmt(E.getArg(I));
    }
    Record.AddDeclRef(E.getConstructor());
    Record.AddSourceLocation(E.getLocation());
    Record.push_back((E.isElidable() ? 1 : 0));
    Record.push_back((E.hadMultipleCandidates() ? 1 : 0));
    Record.push_back((E.isListInitialization() ? 1 : 0));
    Record.push_back((E.isStdInitListInitialization() ? 1 : 0));
    Record.push_back((E.requiresZeroInitialization() ? 1 : 0));
    Record.push_back(E.getConstructionKind().getValue()); // FIXME: stable encoding
    Record.AddSourceRange(E.getParenOrBraceRange());
    Code = StmtCode.EXPR_CXX_CONSTRUCT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1239,
   FQN="clang::ASTStmtWriter::VisitCXXTemporaryObjectExpr", NM="_ZN5clang13ASTStmtWriter27VisitCXXTemporaryObjectExprEPNS_22CXXTemporaryObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitCXXTemporaryObjectExprEPNS_22CXXTemporaryObjectExprE")
  //</editor-fold>
  public void VisitCXXTemporaryObjectExpr(CXXTemporaryObjectExpr /*P*/ E) {
    VisitCXXConstructExpr(E);
    Record.AddTypeSourceInfo(E.getTypeSourceInfo());
    Code = StmtCode.EXPR_CXX_TEMPORARY_OBJECT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1363,
   FQN="clang::ASTStmtWriter::VisitCXXDefaultArgExpr", NM="_ZN5clang13ASTStmtWriter22VisitCXXDefaultArgExprEPNS_17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitCXXDefaultArgExprEPNS_17CXXDefaultArgExprE")
  //</editor-fold>
  public void VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getParam());
    Record.AddSourceLocation(E.getUsedLocation());
    Code = StmtCode.EXPR_CXX_DEFAULT_ARG;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1370,
   FQN="clang::ASTStmtWriter::VisitCXXDefaultInitExpr", NM="_ZN5clang13ASTStmtWriter23VisitCXXDefaultInitExprEPNS_18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitCXXDefaultInitExprEPNS_18CXXDefaultInitExprE")
  //</editor-fold>
  public void VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getField());
    Record.AddSourceLocation(E.getExprLoc());
    Code = StmtCode.EXPR_CXX_DEFAULT_INIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1411,
   FQN="clang::ASTStmtWriter::VisitCXXDeleteExpr", NM="_ZN5clang13ASTStmtWriter18VisitCXXDeleteExprEPNS_13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitCXXDeleteExprEPNS_13CXXDeleteExprE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(CXXDeleteExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back((E.isGlobalDelete() ? 1 : 0));
    Record.push_back((E.isArrayForm() ? 1 : 0));
    Record.push_back((E.isArrayFormAsWritten() ? 1 : 0));
    Record.push_back((E.doesUsualArrayDeleteWantSize() ? 1 : 0));
    Record.AddDeclRef(E.getOperatorDelete());
    Record.AddStmt(E.getArgument());
    Record.AddSourceLocation(E.getSourceRange().getBegin());
    
    Code = StmtCode.EXPR_CXX_DELETE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1456,
   FQN="clang::ASTStmtWriter::VisitCXXDependentScopeMemberExpr", NM="_ZN5clang13ASTStmtWriter32VisitCXXDependentScopeMemberExprEPNS_27CXXDependentScopeMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter32VisitCXXDependentScopeMemberExprEPNS_27CXXDependentScopeMemberExprE")
  //</editor-fold>
  public void VisitCXXDependentScopeMemberExpr(CXXDependentScopeMemberExpr /*P*/ E) {
    VisitExpr(E);
    
    // Don't emit anything here, HasTemplateKWAndArgsInfo must be
    // emitted first.
    Record.push_back((E.HasTemplateKWAndArgsInfo ? 1 : 0));
    if (E.HasTemplateKWAndArgsInfo) {
      final /*const*/ ASTTemplateKWAndArgsInfo /*&*/ ArgInfo = $Deref(E.getTrailingObjects(ASTTemplateKWAndArgsInfo.class));
      Record.push_back($uint2ulong(ArgInfo.NumTemplateArgs));
      AddTemplateKWAndArgsInfo(ArgInfo, 
          E.getTrailingObjects(TemplateArgumentLoc.class));
    }
    if (!E.isImplicitAccess()) {
      Record.AddStmt(E.getBase());
    } else {
      Record.AddStmt((Stmt /*P*/ )null);
    }
    Record.AddTypeRef(E.getBaseType());
    Record.push_back((E.isArrow() ? 1 : 0));
    Record.AddSourceLocation(E.getOperatorLoc());
    Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
    Record.AddDeclRef(E.getFirstQualifierFoundInScope());
    Record.AddDeclarationNameInfo(E.MemberNameInfo);
    Code = StmtCode.EXPR_CXX_DEPENDENT_SCOPE_MEMBER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXFoldExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1661,
   FQN="clang::ASTStmtWriter::VisitCXXFoldExpr", NM="_ZN5clang13ASTStmtWriter16VisitCXXFoldExprEPNS_11CXXFoldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitCXXFoldExprEPNS_11CXXFoldExprE")
  //</editor-fold>
  public void VisitCXXFoldExpr(CXXFoldExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(new SourceLocation(E.LParenLoc));
    Record.AddSourceLocation(new SourceLocation(E.EllipsisLoc));
    Record.AddSourceLocation(new SourceLocation(E.RParenLoc));
    Record.AddStmt(E.SubExprs[0]);
    Record.AddStmt(E.SubExprs[1]);
    Record.push_back(E.Opcode.getValue());
    Code = StmtCode.EXPR_CXX_FOLD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1230,
   FQN="clang::ASTStmtWriter::VisitCXXInheritedCtorInitExpr", NM="_ZN5clang13ASTStmtWriter29VisitCXXInheritedCtorInitExprEPNS_24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter29VisitCXXInheritedCtorInitExprEPNS_24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public void VisitCXXInheritedCtorInitExpr(CXXInheritedCtorInitExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getConstructor());
    Record.AddSourceLocation(E.getLocation());
    Record.push_back((E.constructsVBase() ? 1 : 0));
    Record.push_back((E.inheritedFromVBase() ? 1 : 0));
    Code = StmtCode.EXPR_CXX_INHERITED_CTOR_INIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1391,
   FQN="clang::ASTStmtWriter::VisitCXXNewExpr", NM="_ZN5clang13ASTStmtWriter15VisitCXXNewExprEPNS_10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitCXXNewExprEPNS_10CXXNewExprE")
  //</editor-fold>
  public void VisitCXXNewExpr(CXXNewExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back((E.isGlobalNew() ? 1 : 0));
    Record.push_back((E.isArray() ? 1 : 0));
    Record.push_back((E.doesUsualArrayDeleteWantSize() ? 1 : 0));
    Record.push_back($uint2ulong(E.getNumPlacementArgs()));
    Record.push_back($uint2ulong($2bits_uint2uint(E.StoredInitializationStyle)));
    Record.AddDeclRef(E.getOperatorNew());
    Record.AddDeclRef(E.getOperatorDelete());
    Record.AddTypeSourceInfo(E.getAllocatedTypeSourceInfo());
    Record.AddSourceRange(E.getTypeIdParens());
    Record.AddSourceRange(E.getSourceRange());
    Record.AddSourceRange(E.getDirectInitRange());
    for (Stmt.ExprIterator I = new Stmt.ExprIterator(E.raw_arg_begin()), e = new Stmt.ExprIterator(E.raw_arg_end());
         I.$noteq(e); I.$preInc())  {
      Record.AddStmt(I.$star());
    }
    
    Code = StmtCode.EXPR_CXX_NEW;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1591,
   FQN="clang::ASTStmtWriter::VisitCXXNoexceptExpr", NM="_ZN5clang13ASTStmtWriter20VisitCXXNoexceptExprEPNS_15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitCXXNoexceptExprEPNS_15CXXNoexceptExprE")
  //</editor-fold>
  public void VisitCXXNoexceptExpr(CXXNoexceptExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back((E.getValue() ? 1 : 0));
    Record.AddSourceRange(E.getSourceRange());
    Record.AddStmt(E.getOperand());
    Code = StmtCode.EXPR_CXX_NOEXCEPT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1330,
   FQN="clang::ASTStmtWriter::VisitCXXNullPtrLiteralExpr", NM="_ZN5clang13ASTStmtWriter26VisitCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public void VisitCXXNullPtrLiteralExpr(CXXNullPtrLiteralExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getLocation());
    Code = StmtCode.EXPR_CXX_NULL_PTR_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1424,
   FQN="clang::ASTStmtWriter::VisitCXXPseudoDestructorExpr", NM="_ZN5clang13ASTStmtWriter28VisitCXXPseudoDestructorExprEPNS_23CXXPseudoDestructorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter28VisitCXXPseudoDestructorExprEPNS_23CXXPseudoDestructorExprE")
  //</editor-fold>
  public void VisitCXXPseudoDestructorExpr(CXXPseudoDestructorExpr /*P*/ E) {
    VisitExpr(E);
    
    Record.AddStmt(E.getBase());
    Record.push_back((E.isArrow() ? 1 : 0));
    Record.AddSourceLocation(E.getOperatorLoc());
    Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
    Record.AddTypeSourceInfo(E.getScopeTypeInfo());
    Record.AddSourceLocation(E.getColonColonLoc());
    Record.AddSourceLocation(E.getTildeLoc());
    
    // PseudoDestructorTypeStorage.
    Record.AddIdentifierRef(E.getDestroyedTypeIdentifier());
    if ((E.getDestroyedTypeIdentifier() != null)) {
      Record.AddSourceLocation(E.getDestroyedTypeLoc());
    } else {
      Record.AddTypeSourceInfo(E.getDestroyedTypeInfo());
    }
    
    Code = StmtCode.EXPR_CXX_PSEUDO_DESTRUCTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1384,
   FQN="clang::ASTStmtWriter::VisitCXXScalarValueInitExpr", NM="_ZN5clang13ASTStmtWriter27VisitCXXScalarValueInitExprEPNS_22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitCXXScalarValueInitExprEPNS_22CXXScalarValueInitExprE")
  //</editor-fold>
  public void VisitCXXScalarValueInitExpr(CXXScalarValueInitExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddTypeSourceInfo(E.getTypeSourceInfo());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_CXX_SCALAR_VALUE_INIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1278,
   FQN="clang::ASTStmtWriter::VisitCXXStdInitializerListExpr", NM="_ZN5clang13ASTStmtWriter30VisitCXXStdInitializerListExprEPNS_25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter30VisitCXXStdInitializerListExprEPNS_25CXXStdInitializerListExprE")
  //</editor-fold>
  public void VisitCXXStdInitializerListExpr(CXXStdInitializerListExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubExpr());
    Code = StmtCode.EXPR_CXX_STD_INITIALIZER_LIST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1348,
   FQN="clang::ASTStmtWriter::VisitCXXThisExpr", NM="_ZN5clang13ASTStmtWriter16VisitCXXThisExprEPNS_11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitCXXThisExprEPNS_11CXXThisExprE")
  //</editor-fold>
  public void VisitCXXThisExpr(CXXThisExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getLocation());
    Record.push_back((E.isImplicit() ? 1 : 0));
    Code = StmtCode.EXPR_CXX_THIS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1355,
   FQN="clang::ASTStmtWriter::VisitCXXThrowExpr", NM="_ZN5clang13ASTStmtWriter17VisitCXXThrowExprEPNS_12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitCXXThrowExprEPNS_12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(CXXThrowExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getThrowLoc());
    Record.AddStmt(E.getSubExpr());
    Record.push_back((E.isThrownVariableInScope() ? 1 : 0));
    Code = StmtCode.EXPR_CXX_THROW;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1336,
   FQN="clang::ASTStmtWriter::VisitCXXTypeidExpr", NM="_ZN5clang13ASTStmtWriter18VisitCXXTypeidExprEPNS_13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitCXXTypeidExprEPNS_13CXXTypeidExprE")
  //</editor-fold>
  public void VisitCXXTypeidExpr(CXXTypeidExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceRange(E.getSourceRange());
    if (E.isTypeOperand()) {
      Record.AddTypeSourceInfo(E.getTypeOperandSourceInfo());
      Code = StmtCode.EXPR_CXX_TYPEID_TYPE;
    } else {
      Record.AddStmt(E.getExprOperand());
      Code = StmtCode.EXPR_CXX_TYPEID_EXPR;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1506,
   FQN="clang::ASTStmtWriter::VisitCXXUnresolvedConstructExpr", NM="_ZN5clang13ASTStmtWriter31VisitCXXUnresolvedConstructExprEPNS_26CXXUnresolvedConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter31VisitCXXUnresolvedConstructExprEPNS_26CXXUnresolvedConstructExprE")
  //</editor-fold>
  public void VisitCXXUnresolvedConstructExpr(CXXUnresolvedConstructExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.arg_size()));
    for (type$ptr<Expr /*P*/ /*P*/> ArgI = $tryClone(E.arg_begin()), /*P*/ /*P*/ ArgE = $tryClone(E.arg_end()); $noteq_ptr(ArgI, ArgE); ArgI.$preInc())  {
      Record.AddStmt(ArgI.$star());
    }
    Record.AddTypeSourceInfo(E.getTypeSourceInfo());
    Record.AddSourceLocation(E.getLParenLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_CXX_UNRESOLVED_CONSTRUCT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1727,
   FQN="clang::ASTStmtWriter::VisitCXXUuidofExpr", NM="_ZN5clang13ASTStmtWriter18VisitCXXUuidofExprEPNS_13CXXUuidofExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitCXXUuidofExprEPNS_13CXXUuidofExprE")
  //</editor-fold>
  public void VisitCXXUuidofExpr(CXXUuidofExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceRange(E.getSourceRange());
    Record.AddString(E.getUuidStr());
    if (E.isTypeOperand()) {
      Record.AddTypeSourceInfo(E.getTypeOperandSourceInfo());
      Code = StmtCode.EXPR_CXX_UUIDOF_TYPE;
    } else {
      Record.AddStmt(E.getExprOperand());
      Code = StmtCode.EXPR_CXX_UUIDOF_EXPR;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 558,
   FQN="clang::ASTStmtWriter::VisitCallExpr", NM="_ZN5clang13ASTStmtWriter13VisitCallExprEPNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitCallExprEPNS_8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumArgs()));
    Record.AddSourceLocation(E.getRParenLoc());
    Record.AddStmt(E.getCallee());
    for (Stmt.ExprIterator Arg = E.arg_begin(), ArgEnd = E.arg_end();
         Arg.$noteq(ArgEnd); Arg.$preInc())  {
      Record.AddStmt(Arg.$star());
    }
    Code = StmtCode.EXPR_CALL;
  }

  
  //===----------------------------------------------------------------------===//
  // CUDA Expressions and Statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1689,
   FQN="clang::ASTStmtWriter::VisitCUDAKernelCallExpr", NM="_ZN5clang13ASTStmtWriter23VisitCUDAKernelCallExprEPNS_18CUDAKernelCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitCUDAKernelCallExprEPNS_18CUDAKernelCallExprE")
  //</editor-fold>
  public void VisitCUDAKernelCallExpr(CUDAKernelCallExpr /*P*/ E) {
    VisitCallExpr(E);
    Record.AddStmt(E.getConfig());
    Code = StmtCode.EXPR_CUDA_KERNEL_CALL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1208,
   FQN="clang::ASTStmtWriter::VisitCXXMemberCallExpr", NM="_ZN5clang13ASTStmtWriter22VisitCXXMemberCallExprEPNS_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitCXXMemberCallExprEPNS_17CXXMemberCallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(CXXMemberCallExpr /*P*/ E) {
    VisitCallExpr(E);
    Code = StmtCode.EXPR_CXX_MEMBER_CALL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1200,
   FQN="clang::ASTStmtWriter::VisitCXXOperatorCallExpr", NM="_ZN5clang13ASTStmtWriter24VisitCXXOperatorCallExprEPNS_19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitCXXOperatorCallExprEPNS_19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(CXXOperatorCallExpr /*P*/ E) {
    VisitCallExpr(E);
    Record.push_back(E.getOperator().getValue());
    Record.AddSourceRange(new SourceRange(E.Range));
    Record.push_back((E.isFPContractable() ? 1 : 0));
    Code = StmtCode.EXPR_CXX_OPERATOR_CALL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitUserDefinedLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1317,
   FQN="clang::ASTStmtWriter::VisitUserDefinedLiteral", NM="_ZN5clang13ASTStmtWriter23VisitUserDefinedLiteralEPNS_18UserDefinedLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitUserDefinedLiteralEPNS_18UserDefinedLiteralE")
  //</editor-fold>
  public void VisitUserDefinedLiteral(UserDefinedLiteral /*P*/ E) {
    VisitCallExpr(E);
    Record.AddSourceLocation(new SourceLocation(E.UDSuffixLoc));
    Code = StmtCode.EXPR_USER_DEFINED_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 631,
   FQN="clang::ASTStmtWriter::VisitCastExpr", NM="_ZN5clang13ASTStmtWriter13VisitCastExprEPNS_8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitCastExprEPNS_8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.path_size()));
    Record.AddStmt(E.getSubExpr());
    Record.push_back(E.getCastKind().getValue()); // FIXME: stable encoding
    
    for (type$ptr<CXXBaseSpecifier /*P*/ /*P*/> PI = $tryClone(E.path_begin()), /*P*/ /*P*/ PE = $tryClone(E.path_end()); $noteq_ptr(PI, PE); PI.$preInc())  {
      Record.AddCXXBaseSpecifier($Deref(PI.$star()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 691,
   FQN="clang::ASTStmtWriter::VisitExplicitCastExpr", NM="_ZN5clang13ASTStmtWriter21VisitExplicitCastExprEPNS_16ExplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitExplicitCastExprEPNS_16ExplicitCastExprE")
  //</editor-fold>
  public void VisitExplicitCastExpr(ExplicitCastExpr /*P*/ E) {
    VisitCastExpr(E);
    Record.AddTypeSourceInfo(E.getTypeInfoAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCStyleCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 696,
   FQN="clang::ASTStmtWriter::VisitCStyleCastExpr", NM="_ZN5clang13ASTStmtWriter19VisitCStyleCastExprEPNS_14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitCStyleCastExprEPNS_14CStyleCastExprE")
  //</editor-fold>
  public void VisitCStyleCastExpr(CStyleCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    Record.AddSourceLocation(E.getLParenLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_CSTYLE_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1310,
   FQN="clang::ASTStmtWriter::VisitCXXFunctionalCastExpr", NM="_ZN5clang13ASTStmtWriter26VisitCXXFunctionalCastExprEPNS_21CXXFunctionalCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitCXXFunctionalCastExprEPNS_21CXXFunctionalCastExprE")
  //</editor-fold>
  public void VisitCXXFunctionalCastExpr(CXXFunctionalCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    Record.AddSourceLocation(E.getLParenLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_CXX_FUNCTIONAL_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1284,
   FQN="clang::ASTStmtWriter::VisitCXXNamedCastExpr", NM="_ZN5clang13ASTStmtWriter21VisitCXXNamedCastExprEPNS_16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitCXXNamedCastExprEPNS_16CXXNamedCastExprE")
  //</editor-fold>
  public void VisitCXXNamedCastExpr(CXXNamedCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    Record.AddSourceRange(new SourceRange(E.getOperatorLoc(), E.getRParenLoc()));
    Record.AddSourceRange(E.getAngleBrackets());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXConstCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1305,
   FQN="clang::ASTStmtWriter::VisitCXXConstCastExpr", NM="_ZN5clang13ASTStmtWriter21VisitCXXConstCastExprEPNS_16CXXConstCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitCXXConstCastExprEPNS_16CXXConstCastExprE")
  //</editor-fold>
  public void VisitCXXConstCastExpr(CXXConstCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    Code = StmtCode.EXPR_CXX_CONST_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1295,
   FQN="clang::ASTStmtWriter::VisitCXXDynamicCastExpr", NM="_ZN5clang13ASTStmtWriter23VisitCXXDynamicCastExprEPNS_18CXXDynamicCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitCXXDynamicCastExprEPNS_18CXXDynamicCastExprE")
  //</editor-fold>
  public void VisitCXXDynamicCastExpr(CXXDynamicCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    Code = StmtCode.EXPR_CXX_DYNAMIC_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1300,
   FQN="clang::ASTStmtWriter::VisitCXXReinterpretCastExpr", NM="_ZN5clang13ASTStmtWriter27VisitCXXReinterpretCastExprEPNS_22CXXReinterpretCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitCXXReinterpretCastExprEPNS_22CXXReinterpretCastExprE")
  //</editor-fold>
  public void VisitCXXReinterpretCastExpr(CXXReinterpretCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    Code = StmtCode.EXPR_CXX_REINTERPRET_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1290,
   FQN="clang::ASTStmtWriter::VisitCXXStaticCastExpr", NM="_ZN5clang13ASTStmtWriter22VisitCXXStaticCastExprEPNS_17CXXStaticCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitCXXStaticCastExprEPNS_17CXXStaticCastExprE")
  //</editor-fold>
  public void VisitCXXStaticCastExpr(CXXStaticCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    Code = StmtCode.EXPR_CXX_STATIC_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 623,
   FQN="clang::ASTStmtWriter::VisitObjCBridgedCastExpr", NM="_ZN5clang13ASTStmtWriter24VisitObjCBridgedCastExprEPNS_19ObjCBridgedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitObjCBridgedCastExprEPNS_19ObjCBridgedCastExprE")
  //</editor-fold>
  public void VisitObjCBridgedCastExpr(ObjCBridgedCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    Record.AddSourceLocation(E.getLParenLoc());
    Record.AddSourceLocation(E.getBridgeKeywordLoc());
    Record.push_back(E.getBridgeKind().getValue()); // FIXME: Stable encoding
    Code = StmtCode.EXPR_OBJC_BRIDGED_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 682,
   FQN="clang::ASTStmtWriter::VisitImplicitCastExpr", NM="_ZN5clang13ASTStmtWriter21VisitImplicitCastExprEPNS_16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitImplicitCastExprEPNS_16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    VisitCastExpr(E);
    if (E.path_size() == 0) {
      AbbrevToUse = Writer.getExprImplicitCastAbbrev();
    }
    
    Code = StmtCode.EXPR_IMPLICIT_CAST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 454,
   FQN="clang::ASTStmtWriter::VisitCharacterLiteral", NM="_ZN5clang13ASTStmtWriter21VisitCharacterLiteralEPNS_16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitCharacterLiteralEPNS_16CharacterLiteralE")
  //</editor-fold>
  public void VisitCharacterLiteral(CharacterLiteral /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getValue()));
    Record.AddSourceLocation(E.getLocation());
    Record.push_back(E.getKind().getValue());
    
    AbbrevToUse = Writer.getCharacterLiteralAbbrev();
    
    Code = StmtCode.EXPR_CHARACTER_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitChooseExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 826,
   FQN="clang::ASTStmtWriter::VisitChooseExpr", NM="_ZN5clang13ASTStmtWriter15VisitChooseExprEPNS_10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitChooseExprEPNS_10ChooseExprE")
  //</editor-fold>
  public void VisitChooseExpr(ChooseExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getCond());
    Record.AddStmt(E.getLHS());
    Record.AddStmt(E.getRHS());
    Record.AddSourceLocation(E.getBuiltinLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Record.push_back(((E.isConditionDependent() ? false : E.isConditionTrue()) ? 1 : 0));
    Code = StmtCode.EXPR_CHOOSE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 703,
   FQN="clang::ASTStmtWriter::VisitCompoundLiteralExpr", NM="_ZN5clang13ASTStmtWriter24VisitCompoundLiteralExprEPNS_19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitCompoundLiteralExprEPNS_19CompoundLiteralExprE")
  //</editor-fold>
  public void VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getLParenLoc());
    Record.AddTypeSourceInfo(E.getTypeSourceInfo());
    Record.AddStmt(E.getInitializer());
    Record.push_back((E.isFileScope() ? 1 : 0));
    Code = StmtCode.EXPR_COMPOUND_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitConvertVectorExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 853,
   FQN="clang::ASTStmtWriter::VisitConvertVectorExpr", NM="_ZN5clang13ASTStmtWriter22VisitConvertVectorExprEPNS_17ConvertVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitConvertVectorExprEPNS_17ConvertVectorExprE")
  //</editor-fold>
  public void VisitConvertVectorExpr(ConvertVectorExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getBuiltinLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Record.AddTypeSourceInfo(E.getTypeSourceInfo());
    Record.AddStmt(E.getSrcExpr());
    Code = StmtCode.EXPR_CONVERT_VECTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCoroutineSuspendExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 445,
   FQN="clang::ASTStmtWriter::VisitCoroutineSuspendExpr", NM="_ZN5clang13ASTStmtWriter25VisitCoroutineSuspendExprEPNS_20CoroutineSuspendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitCoroutineSuspendExprEPNS_20CoroutineSuspendExprE")
  //</editor-fold>
  public void VisitCoroutineSuspendExpr(CoroutineSuspendExpr /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 313,
   FQN="clang::ASTStmtWriter::VisitCoawaitExpr", NM="_ZN5clang13ASTStmtWriter16VisitCoawaitExprEPNS_11CoawaitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitCoawaitExprEPNS_11CoawaitExprE")
  //</editor-fold>
  public void VisitCoawaitExpr(CoawaitExpr /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 318,
   FQN="clang::ASTStmtWriter::VisitCoyieldExpr", NM="_ZN5clang13ASTStmtWriter16VisitCoyieldExprEPNS_11CoyieldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitCoyieldExprEPNS_11CoyieldExprE")
  //</editor-fold>
  public void VisitCoyieldExpr(CoyieldExpr /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 373,
   FQN="clang::ASTStmtWriter::VisitDeclRefExpr", NM="_ZN5clang13ASTStmtWriter16VisitDeclRefExprEPNS_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitDeclRefExprEPNS_11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    VisitExpr(E);
    
    Record.push_back((E.hasQualifier() ? 1 : 0));
    Record.push_back(((E.getDecl() != E.getFoundDecl()) ? 1 : 0));
    Record.push_back((E.hasTemplateKWAndArgsInfo() ? 1 : 0));
    Record.push_back((E.hadMultipleCandidates() ? 1 : 0));
    Record.push_back((E.refersToEnclosingVariableOrCapture() ? 1 : 0));
    if (E.hasTemplateKWAndArgsInfo()) {
      /*uint*/int NumTemplateArgs = E.getNumTemplateArgs();
      Record.push_back($uint2ulong(NumTemplateArgs));
    }
    
    DeclarationName.NameKind nk = (E.getDecl().getDeclName().getNameKind());
    if ((!E.hasTemplateKWAndArgsInfo()) && (!E.hasQualifier())
       && (E.getDecl() == E.getFoundDecl())
       && nk == DeclarationName.NameKind.Identifier) {
      AbbrevToUse = Writer.getDeclRefExprAbbrev();
    }
    if (E.hasQualifier()) {
      Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
    }
    if (E.getDecl() != E.getFoundDecl()) {
      Record.AddDeclRef(E.getFoundDecl());
    }
    if (E.hasTemplateKWAndArgsInfo()) {
      AddTemplateKWAndArgsInfo($Deref(E.getTrailingObjects(ASTTemplateKWAndArgsInfo.class)), 
          E.getTrailingObjects(TemplateArgumentLoc.class));
    }
    
    Record.AddDeclRef(E.getDecl());
    Record.AddSourceLocation(E.getLocation());
    Record.AddDeclarationNameLoc(E.DNLoc, E.getDecl().getDeclName());
    Code = StmtCode.EXPR_DECL_REF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1485,
   FQN="clang::ASTStmtWriter::VisitDependentScopeDeclRefExpr", NM="_ZN5clang13ASTStmtWriter30VisitDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter30VisitDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprE")
  //</editor-fold>
  public void VisitDependentScopeDeclRefExpr(DependentScopeDeclRefExpr /*P*/ E) {
    VisitExpr(E);
    
    // Don't emit anything here, HasTemplateKWAndArgsInfo must be
    // emitted first.
    Record.push_back((E.HasTemplateKWAndArgsInfo ? 1 : 0));
    if (E.HasTemplateKWAndArgsInfo) {
      final /*const*/ ASTTemplateKWAndArgsInfo /*&*/ ArgInfo = $Deref(E.getTrailingObjects(ASTTemplateKWAndArgsInfo.class));
      Record.push_back($uint2ulong(ArgInfo.NumTemplateArgs));
      AddTemplateKWAndArgsInfo(ArgInfo, 
          E.getTrailingObjects(TemplateArgumentLoc.class));
    }
    
    Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
    Record.AddDeclarationNameInfo(E.NameInfo);
    Code = StmtCode.EXPR_CXX_DEPENDENT_SCOPE_DECL_REF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 748,
   FQN="clang::ASTStmtWriter::VisitDesignatedInitExpr", NM="_ZN5clang13ASTStmtWriter23VisitDesignatedInitExprEPNS_18DesignatedInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitDesignatedInitExprEPNS_18DesignatedInitExprE")
  //</editor-fold>
  public void VisitDesignatedInitExpr(DesignatedInitExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumSubExprs()));
    for (/*uint*/int I = 0, N = E.getNumSubExprs(); I != N; ++I)  {
      Record.AddStmt(E.getSubExpr(I));
    }
    Record.AddSourceLocation(E.getEqualOrColonLoc());
    Record.push_back((E.usesGNUSyntax() ? 1 : 0));
    for (final /*const*/ DesignatedInitExpr.Designator /*&*/ D : E.designators()) {
      if (D.isFieldDesignator()) {
        {
          FieldDecl /*P*/ Field = D.getField();
          if ((Field != null)) {
            Record.push_back(DesignatorTypes.DESIG_FIELD_DECL);
            Record.AddDeclRef(Field);
          } else {
            Record.push_back(DesignatorTypes.DESIG_FIELD_NAME);
            Record.AddIdentifierRef(D.getFieldName());
          }
        }
        Record.AddSourceLocation(D.getDotLoc());
        Record.AddSourceLocation(D.getFieldLoc());
      } else if (D.isArrayDesignator()) {
        Record.push_back(DesignatorTypes.DESIG_ARRAY);
        Record.push_back($uint2ulong(D.getFirstExprIndex()));
        Record.AddSourceLocation(D.getLBracketLoc());
        Record.AddSourceLocation(D.getRBracketLoc());
      } else {
        assert (D.isArrayRangeDesignator()) : "Unknown designator";
        Record.push_back(DesignatorTypes.DESIG_ARRAY_RANGE);
        Record.push_back($uint2ulong(D.getFirstExprIndex()));
        Record.AddSourceLocation(D.getLBracketLoc());
        Record.AddSourceLocation(D.getEllipsisLoc());
        Record.AddSourceLocation(D.getRBracketLoc());
      }
    }
    Code = StmtCode.EXPR_DESIGNATED_INIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 783,
   FQN="clang::ASTStmtWriter::VisitDesignatedInitUpdateExpr", NM="_ZN5clang13ASTStmtWriter29VisitDesignatedInitUpdateExprEPNS_24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter29VisitDesignatedInitUpdateExprEPNS_24DesignatedInitUpdateExprE")
  //</editor-fold>
  public void VisitDesignatedInitUpdateExpr(DesignatedInitUpdateExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getBase());
    Record.AddStmt(E.getUpdater());
    Code = StmtCode.EXPR_DESIGNATED_INIT_UPDATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1445,
   FQN="clang::ASTStmtWriter::VisitExprWithCleanups", NM="_ZN5clang13ASTStmtWriter21VisitExprWithCleanupsEPNS_16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitExprWithCleanupsEPNS_16ExprWithCleanupsE")
  //</editor-fold>
  public void VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumObjects()));
    for (/*uint*/int i = 0, e = E.getNumObjects(); i != e; ++i)  {
      Record.AddDeclRef(E.getObject(i));
    }
    
    Record.push_back((E.cleanupsHaveSideEffects() ? 1 : 0));
    Record.AddStmt(E.getSubExpr());
    Code = StmtCode.EXPR_EXPR_WITH_CLEANUPS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1582,
   FQN="clang::ASTStmtWriter::VisitExpressionTraitExpr", NM="_ZN5clang13ASTStmtWriter24VisitExpressionTraitExprEPNS_19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitExpressionTraitExprEPNS_19ExpressionTraitExprE")
  //</editor-fold>
  public void VisitExpressionTraitExpr(ExpressionTraitExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back(E.getTrait().getValue());
    Record.push_back((E.getValue() ? 1 : 0));
    Record.AddSourceRange(E.getSourceRange());
    Record.AddStmt(E.getQueriedExpression());
    Code = StmtCode.EXPR_CXX_EXPRESSION_TRAIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 712,
   FQN="clang::ASTStmtWriter::VisitExtVectorElementExpr", NM="_ZN5clang13ASTStmtWriter25VisitExtVectorElementExprEPNS_20ExtVectorElementExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitExtVectorElementExprEPNS_20ExtVectorElementExprE")
  //</editor-fold>
  public void VisitExtVectorElementExpr(ExtVectorElementExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getBase());
    Record.AddIdentifierRef($AddrOf(E.getAccessor()));
    Record.AddSourceLocation(E.getAccessorLoc());
    Code = StmtCode.EXPR_EXT_VECTOR_ELEMENT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 423,
   FQN="clang::ASTStmtWriter::VisitFloatingLiteral", NM="_ZN5clang13ASTStmtWriter20VisitFloatingLiteralEPNS_15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitFloatingLiteralEPNS_15FloatingLiteralE")
  //</editor-fold>
  public void VisitFloatingLiteral(FloatingLiteral /*P*/ E) {
    VisitExpr(E);
    Record.push_back(E.getRawSemantics().getValue());
    Record.push_back((E.isExact() ? 1 : 0));
    Record.AddAPFloat(E.getValue());
    Record.AddSourceLocation(E.getLocation());
    Code = StmtCode.EXPR_FLOATING_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1642,
   FQN="clang::ASTStmtWriter::VisitFunctionParmPackExpr", NM="_ZN5clang13ASTStmtWriter25VisitFunctionParmPackExprEPNS_20FunctionParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitFunctionParmPackExprEPNS_20FunctionParmPackExprE")
  //</editor-fold>
  public void VisitFunctionParmPackExpr(FunctionParmPackExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumExpansions()));
    Record.AddDeclRef(E.getParameterPack());
    Record.AddSourceLocation(E.getParameterPackLocation());
    for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> I = $tryClone(E.begin()), /*P*/ /*const*/ /*P*/ End = $tryClone(E.end());
         $noteq_ptr(I, End); I.$preInc())  {
      Record.AddDeclRef(I.$star());
    }
    Code = StmtCode.EXPR_FUNCTION_PARM_PACK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 837,
   FQN="clang::ASTStmtWriter::VisitGNUNullExpr", NM="_ZN5clang13ASTStmtWriter16VisitGNUNullExprEPNS_11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitGNUNullExprEPNS_11GNUNullExprE")
  //</editor-fold>
  public void VisitGNUNullExpr(GNUNullExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getTokenLocation());
    Code = StmtCode.EXPR_GNU_NULL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 868,
   FQN="clang::ASTStmtWriter::VisitGenericSelectionExpr", NM="_ZN5clang13ASTStmtWriter25VisitGenericSelectionExprEPNS_20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitGenericSelectionExprEPNS_20GenericSelectionExprE")
  //</editor-fold>
  public void VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumAssocs()));
    
    Record.AddStmt(E.getControllingExpr());
    for (/*uint*/int I = 0, N = E.getNumAssocs(); I != N; ++I) {
      Record.AddTypeSourceInfo(E.getAssocTypeSourceInfo(I));
      Record.AddStmt(E.getAssocExpr(I));
    }
    Record.push_back($uint2ulong(E.isResultDependent() ? -1/*U*/ : E.getResultIndex()));
    
    Record.AddSourceLocation(E.getGenericLoc());
    Record.AddSourceLocation(E.getDefaultLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_GENERIC_SELECTION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 432,
   FQN="clang::ASTStmtWriter::VisitImaginaryLiteral", NM="_ZN5clang13ASTStmtWriter21VisitImaginaryLiteralEPNS_16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitImaginaryLiteralEPNS_16ImaginaryLiteralE")
  //</editor-fold>
  public void VisitImaginaryLiteral(ImaginaryLiteral /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubExpr());
    Code = StmtCode.EXPR_IMAGINARY_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 795,
   FQN="clang::ASTStmtWriter::VisitImplicitValueInitExpr", NM="_ZN5clang13ASTStmtWriter26VisitImplicitValueInitExprEPNS_21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitImplicitValueInitExprEPNS_21ImplicitValueInitExprE")
  //</editor-fold>
  public void VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E) {
    VisitExpr(E);
    Code = StmtCode.EXPR_IMPLICIT_VALUE_INIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 720,
   FQN="clang::ASTStmtWriter::VisitInitListExpr", NM="_ZN5clang13ASTStmtWriter17VisitInitListExprEPNS_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitInitListExprEPNS_12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(InitListExpr /*P*/ E) {
    VisitExpr(E);
    // NOTE: only add the (possibly null) syntactic form.
    // No need to serialize the isSemanticForm flag and the semantic form.
    Record.AddStmt(E.getSyntacticForm());
    Record.AddSourceLocation(E.getLBraceLoc());
    Record.AddSourceLocation(E.getRBraceLoc());
    boolean isArrayFiller = (E.ArrayFillerOrUnionFieldInit.is(Expr /*P*/.class) != 0);
    Record.push_back((isArrayFiller ? 1 : 0));
    if (isArrayFiller) {
      Record.AddStmt(E.getArrayFiller());
    } else {
      Record.AddDeclRef(E.getInitializedFieldInUnion());
    }
    Record.push_back((E.hadArrayRangeDesignator() ? 1 : 0));
    Record.push_back($uint2ulong(E.getNumInits()));
    if (isArrayFiller) {
      // ArrayFiller may have filled "holes" due to designated initializer.
      // Replace them by 0 to indicate that the filler goes in that place.
      Expr /*P*/ filler = E.getArrayFiller();
      for (/*uint*/int I = 0, N = E.getNumInits(); I != N; ++I)  {
        Record.AddStmt(E.getInit(I) != filler ? E.getInit(I) : (Expr /*P*/ )null);
      }
    } else {
      for (/*uint*/int I = 0, N = E.getNumInits(); I != N; ++I)  {
        Record.AddStmt(E.getInit(I));
      }
    }
    Code = StmtCode.EXPR_INIT_LIST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 411,
   FQN="clang::ASTStmtWriter::VisitIntegerLiteral", NM="_ZN5clang13ASTStmtWriter19VisitIntegerLiteralEPNS_14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitIntegerLiteralEPNS_14IntegerLiteralE")
  //</editor-fold>
  public void VisitIntegerLiteral(IntegerLiteral /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getLocation());
    Record.AddAPInt(E.getValue());
    if (E.getValue().getBitWidth() == 32) {
      AbbrevToUse = Writer.getIntegerLiteralAbbrev();
    }
    
    Code = StmtCode.EXPR_INTEGER_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1245,
   FQN="clang::ASTStmtWriter::VisitLambdaExpr", NM="_ZN5clang13ASTStmtWriter15VisitLambdaExprEPNS_10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitLambdaExprEPNS_10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(LambdaExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong($16bits_uint2uint(E.NumCaptures)));
    /*uint*/int NumArrayIndexVars = 0;
    if (E.HasArrayIndexVars) {
      NumArrayIndexVars = E.getArrayIndexStarts().$at($16bits_uint2uint(E.NumCaptures));
    }
    Record.push_back($uint2ulong(NumArrayIndexVars));
    Record.AddSourceRange(new SourceRange(E.IntroducerRange));
    Record.push_back($uint2ulong($2bits_uint2uint(E.CaptureDefault))); // FIXME: stable encoding
    Record.AddSourceLocation(new SourceLocation(E.CaptureDefaultLoc));
    Record.push_back($uint2ulong(E.ExplicitParams));
    Record.push_back($uint2ulong(E.ExplicitResultType));
    Record.AddSourceLocation(new SourceLocation(E.ClosingBrace));
    
    // Add capture initializers.
    for (type$ptr<Expr /*P*/ /*P*/> C = $tryClone(E.capture_init_begin()), 
        /*P*/ /*P*/ CEnd = $tryClone(E.capture_init_end());
         $noteq_ptr(C, CEnd); C.$preInc()) {
      Record.AddStmt(C.$star());
    }
    
    // Add array index variables, if any.
    if ((NumArrayIndexVars != 0)) {
      Record.append(E.getArrayIndexStarts(), 
          E.getArrayIndexStarts().$add($16bits_uint2uint(E.NumCaptures)).$add(1));
      type$ptr<VarDecl /*P*/ /*P*/> ArrayIndexVars = $tryClone(E.getArrayIndexVars());
      for (/*uint*/int I = 0; I != NumArrayIndexVars; ++I)  {
        Record.AddDeclRef(ArrayIndexVars.$at(I));
      }
    }
    
    Code = StmtCode.EXPR_LAMBDA;
  }

  
  //===----------------------------------------------------------------------===//
  // Microsoft Expressions and Statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1709,
   FQN="clang::ASTStmtWriter::VisitMSPropertyRefExpr", NM="_ZN5clang13ASTStmtWriter22VisitMSPropertyRefExprEPNS_17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitMSPropertyRefExprEPNS_17MSPropertyRefExprE")
  //</editor-fold>
  public void VisitMSPropertyRefExpr(MSPropertyRefExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back((E.isArrow() ? 1 : 0));
    Record.AddStmt(E.getBaseExpr());
    Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
    Record.AddSourceLocation(E.getMemberLoc());
    Record.AddDeclRef(E.getPropertyDecl());
    Code = StmtCode.EXPR_CXX_PROPERTY_REF_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1719,
   FQN="clang::ASTStmtWriter::VisitMSPropertySubscriptExpr", NM="_ZN5clang13ASTStmtWriter28VisitMSPropertySubscriptExprEPNS_23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter28VisitMSPropertySubscriptExprEPNS_23MSPropertySubscriptExprE")
  //</editor-fold>
  public void VisitMSPropertySubscriptExpr(MSPropertySubscriptExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getBase());
    Record.AddStmt(E.getIdx());
    Record.AddSourceLocation(E.getRBracketLoc());
    Code = StmtCode.EXPR_CXX_PROPERTY_SUBSCRIPT_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1653,
   FQN="clang::ASTStmtWriter::VisitMaterializeTemporaryExpr", NM="_ZN5clang13ASTStmtWriter29VisitMaterializeTemporaryExprEPNS_24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter29VisitMaterializeTemporaryExprEPNS_24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(MaterializeTemporaryExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getTemporary());
    Record.AddDeclRef(E.getExtendingDecl());
    Record.push_back($uint2ulong(E.getManglingNumber()));
    Code = StmtCode.EXPR_MATERIALIZE_TEMPORARY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 569,
   FQN="clang::ASTStmtWriter::VisitMemberExpr", NM="_ZN5clang13ASTStmtWriter15VisitMemberExprEPNS_10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitMemberExprEPNS_10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ E) {
    // Don't call VisitExpr, we'll write everything here.
    Record.push_back((E.hasQualifier() ? 1 : 0));
    if (E.hasQualifier()) {
      Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
    }
    
    Record.push_back((E.HasTemplateKWAndArgsInfo ? 1 : 0));
    if (E.HasTemplateKWAndArgsInfo) {
      Record.AddSourceLocation(E.getTemplateKeywordLoc());
      /*uint*/int NumTemplateArgs = E.getNumTemplateArgs();
      Record.push_back($uint2ulong(NumTemplateArgs));
      Record.AddSourceLocation(E.getLAngleLoc());
      Record.AddSourceLocation(E.getRAngleLoc());
      for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
        Record.AddTemplateArgumentLoc(E.getTemplateArgs().$at(i));
      }
    }
    
    Record.push_back((E.hadMultipleCandidates() ? 1 : 0));
    
    DeclAccessPair FoundDecl = E.getFoundDecl();
    Record.AddDeclRef(FoundDecl.getDecl());
    Record.push_back(FoundDecl.getAccess().getValue());
    
    Record.AddTypeRef(E.getType());
    Record.push_back(E.getValueKind().getValue());
    Record.push_back(E.getObjectKind().getValue());
    Record.AddStmt(E.getBase());
    Record.AddDeclRef(E.getMemberDecl());
    Record.AddSourceLocation(E.getMemberLoc());
    Record.push_back((E.isArrow() ? 1 : 0));
    Record.AddSourceLocation(E.getOperatorLoc());
    Record.AddDeclarationNameLoc(E.MemberDNLoc, 
        E.getMemberDecl().getDeclName());
    Code = StmtCode.EXPR_MEMBER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitNoInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 790,
   FQN="clang::ASTStmtWriter::VisitNoInitExpr", NM="_ZN5clang13ASTStmtWriter15VisitNoInitExprEPNS_10NoInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitNoInitExprEPNS_10NoInitExprE")
  //</editor-fold>
  public void VisitNoInitExpr(NoInitExpr /*P*/ E) {
    VisitExpr(E);
    Code = StmtCode.EXPR_NO_INIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 548,
   FQN="clang::ASTStmtWriter::VisitOMPArraySectionExpr", NM="_ZN5clang13ASTStmtWriter24VisitOMPArraySectionExprEPNS_19OMPArraySectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitOMPArraySectionExprEPNS_19OMPArraySectionExprE")
  //</editor-fold>
  public void VisitOMPArraySectionExpr(OMPArraySectionExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getBase());
    Record.AddStmt(E.getLowerBound());
    Record.AddStmt(E.getLength());
    Record.AddSourceLocation(E.getColonLoc());
    Record.AddSourceLocation(E.getRBracketLoc());
    Code = StmtCode.EXPR_OMP_ARRAY_SECTION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCArrayLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 932,
   FQN="clang::ASTStmtWriter::VisitObjCArrayLiteral", NM="_ZN5clang13ASTStmtWriter21VisitObjCArrayLiteralEPNS_16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitObjCArrayLiteralEPNS_16ObjCArrayLiteralE")
  //</editor-fold>
  public void VisitObjCArrayLiteral(ObjCArrayLiteral /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumElements()));
    for (/*uint*/int i = 0; $less_uint(i, E.getNumElements()); i++)  {
      Record.AddStmt(E.getElement(i));
    }
    Record.AddDeclRef(E.getArrayWithObjectsMethod());
    Record.AddSourceRange(E.getSourceRange());
    Code = StmtCode.EXPR_OBJC_ARRAY_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1145,
   FQN="clang::ASTStmtWriter::VisitObjCAvailabilityCheckExpr", NM="_ZN5clang13ASTStmtWriter30VisitObjCAvailabilityCheckExprEPNS_25ObjCAvailabilityCheckExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter30VisitObjCAvailabilityCheckExprEPNS_25ObjCAvailabilityCheckExprE")
  //</editor-fold>
  public void VisitObjCAvailabilityCheckExpr(ObjCAvailabilityCheckExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceRange(E.getSourceRange());
    Record.AddVersionTuple(E.getVersion());
    Code = StmtCode.EXPR_OBJC_AVAILABILITY_CHECK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1138,
   FQN="clang::ASTStmtWriter::VisitObjCBoolLiteralExpr", NM="_ZN5clang13ASTStmtWriter24VisitObjCBoolLiteralExprEPNS_19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitObjCBoolLiteralExprEPNS_19ObjCBoolLiteralExprE")
  //</editor-fold>
  public void VisitObjCBoolLiteralExpr(ObjCBoolLiteralExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back((E.getValue() ? 1 : 0));
    Record.AddSourceLocation(E.getLocation());
    Code = StmtCode.EXPR_OBJC_BOOL_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 924,
   FQN="clang::ASTStmtWriter::VisitObjCBoxedExpr", NM="_ZN5clang13ASTStmtWriter18VisitObjCBoxedExprEPNS_13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitObjCBoxedExprEPNS_13ObjCBoxedExprE")
  //</editor-fold>
  public void VisitObjCBoxedExpr(ObjCBoxedExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubExpr());
    Record.AddDeclRef(E.getBoxingMethod());
    Record.AddSourceRange(E.getSourceRange());
    Code = StmtCode.EXPR_OBJC_BOXED_EXPRESSION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 942,
   FQN="clang::ASTStmtWriter::VisitObjCDictionaryLiteral", NM="_ZN5clang13ASTStmtWriter26VisitObjCDictionaryLiteralEPNS_21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitObjCDictionaryLiteralEPNS_21ObjCDictionaryLiteralE")
  //</editor-fold>
  public void VisitObjCDictionaryLiteral(ObjCDictionaryLiteral /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumElements()));
    Record.push_back($uint2ulong(E.HasPackExpansions));
    for (/*uint*/int i = 0; $less_uint(i, E.getNumElements()); i++) {
      ObjCDictionaryElement Element = null;
      try {
        Element = E.getKeyValueElement(i);
        Record.AddStmt(Element.Key);
        Record.AddStmt(Element.Value);
        if (E.HasPackExpansions) {
          Record.AddSourceLocation(new SourceLocation(Element.EllipsisLoc));
          /*uint*/int NumExpansions = 0;
          if (Element.NumExpansions.$bool()) {
            NumExpansions = Element.NumExpansions.$star() + 1;
          }
          Record.push_back($uint2ulong(NumExpansions));
        }
      } finally {
        if (Element != null) { Element.$destroy(); }
      }
    }
    
    Record.AddDeclRef(E.getDictWithObjectsMethod());
    Record.AddSourceRange(E.getSourceRange());
    Code = StmtCode.EXPR_OBJC_DICTIONARY_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 964,
   FQN="clang::ASTStmtWriter::VisitObjCEncodeExpr", NM="_ZN5clang13ASTStmtWriter19VisitObjCEncodeExprEPNS_14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitObjCEncodeExprEPNS_14ObjCEncodeExprE")
  //</editor-fold>
  public void VisitObjCEncodeExpr(ObjCEncodeExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddTypeSourceInfo(E.getEncodedTypeSourceInfo());
    Record.AddSourceLocation(E.getAtLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_OBJC_ENCODE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 615,
   FQN="clang::ASTStmtWriter::VisitObjCIndirectCopyRestoreExpr", NM="_ZN5clang13ASTStmtWriter32VisitObjCIndirectCopyRestoreExprEPNS_27ObjCIndirectCopyRestoreExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter32VisitObjCIndirectCopyRestoreExprEPNS_27ObjCIndirectCopyRestoreExprE")
  //</editor-fold>
  public void VisitObjCIndirectCopyRestoreExpr(ObjCIndirectCopyRestoreExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubExpr());
    Record.push_back((E.shouldCopy() ? 1 : 0));
    Code = StmtCode.EXPR_OBJC_INDIRECT_COPY_RESTORE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCIsaExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 606,
   FQN="clang::ASTStmtWriter::VisitObjCIsaExpr", NM="_ZN5clang13ASTStmtWriter16VisitObjCIsaExprEPNS_11ObjCIsaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitObjCIsaExprEPNS_11ObjCIsaExprE")
  //</editor-fold>
  public void VisitObjCIsaExpr(ObjCIsaExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getBase());
    Record.AddSourceLocation(E.getIsaMemberLoc());
    Record.AddSourceLocation(E.getOpLoc());
    Record.push_back((E.isArrow() ? 1 : 0));
    Code = StmtCode.EXPR_OBJC_ISA;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 989,
   FQN="clang::ASTStmtWriter::VisitObjCIvarRefExpr", NM="_ZN5clang13ASTStmtWriter20VisitObjCIvarRefExprEPNS_15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitObjCIvarRefExprEPNS_15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getDecl());
    Record.AddSourceLocation(E.getLocation());
    Record.AddSourceLocation(E.getOpLoc());
    Record.AddStmt(E.getBase());
    Record.push_back((E.isArrow() ? 1 : 0));
    Record.push_back((E.isFreeIvar() ? 1 : 0));
    Code = StmtCode.EXPR_OBJC_IVAR_REF_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1037,
   FQN="clang::ASTStmtWriter::VisitObjCMessageExpr", NM="_ZN5clang13ASTStmtWriter20VisitObjCMessageExprEPNS_15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitObjCMessageExprEPNS_15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumArgs()));
    Record.push_back($uint2ulong(E.getNumStoredSelLocs()));
    Record.push_back($uint2ulong($2bits_uint2uint(E.SelLocsKind)));
    Record.push_back((E.isDelegateInitCall() ? 1 : 0));
    Record.push_back($uint2ulong(E.IsImplicit));
    Record.push_back($uint2ulong((/*uint*/int)E.getReceiverKind().getValue())); // FIXME: stable encoding
    switch (E.getReceiverKind()) {
     case Instance:
      Record.AddStmt(E.getInstanceReceiver());
      break;
     case Class:
      Record.AddTypeSourceInfo(E.getClassReceiverTypeInfo());
      break;
     case SuperClass:
     case SuperInstance:
      Record.AddTypeRef(E.getSuperType());
      Record.AddSourceLocation(E.getSuperLoc());
      break;
    }
    if ((E.getMethodDecl() != null)) {
      Record.push_back($int2ulong(1));
      Record.AddDeclRef(E.getMethodDecl());
    } else {
      Record.push_back($int2ulong(0));
      Record.AddSelectorRef(E.getSelector());
    }
    
    Record.AddSourceLocation(E.getLeftLoc());
    Record.AddSourceLocation(E.getRightLoc());
    
    for (Stmt.ExprIterator Arg = E.arg_begin(), ArgEnd = E.arg_end();
         Arg.$noteq(ArgEnd); Arg.$preInc())  {
      Record.AddStmt(Arg.$star());
    }
    
    type$ptr<SourceLocation /*P*/> Locs = E.getStoredSelLocs();
    for (/*uint*/int i = 0, e = E.getNumStoredSelLocs(); i != e; ++i)  {
      Record.AddSourceLocation(new SourceLocation(Locs.$at(i)));
    }
    
    Code = StmtCode.EXPR_OBJC_MESSAGE_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1000,
   FQN="clang::ASTStmtWriter::VisitObjCPropertyRefExpr", NM="_ZN5clang13ASTStmtWriter24VisitObjCPropertyRefExprEPNS_19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitObjCPropertyRefExprEPNS_19ObjCPropertyRefExprE")
  //</editor-fold>
  public void VisitObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.SetterAndMethodRefFlags.getInt()));
    Record.push_back((E.isImplicitProperty() ? 1 : 0));
    if (E.isImplicitProperty()) {
      Record.AddDeclRef(E.getImplicitPropertyGetter());
      Record.AddDeclRef(E.getImplicitPropertySetter());
    } else {
      Record.AddDeclRef(E.getExplicitProperty());
    }
    Record.AddSourceLocation(E.getLocation());
    Record.AddSourceLocation(E.getReceiverLocation());
    if (E.isObjectReceiver()) {
      Record.push_back($int2ulong(0));
      Record.AddStmt(E.getBase());
    } else if (E.isSuperReceiver()) {
      Record.push_back($int2ulong(1));
      Record.AddTypeRef(E.getSuperReceiverType());
    } else {
      Record.push_back($int2ulong(2));
      Record.AddDeclRef(E.getClassReceiver());
    }
    
    Code = StmtCode.EXPR_OBJC_PROPERTY_REF_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 980,
   FQN="clang::ASTStmtWriter::VisitObjCProtocolExpr", NM="_ZN5clang13ASTStmtWriter21VisitObjCProtocolExprEPNS_16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitObjCProtocolExprEPNS_16ObjCProtocolExprE")
  //</editor-fold>
  public void VisitObjCProtocolExpr(ObjCProtocolExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getProtocol());
    Record.AddSourceLocation(E.getAtLoc());
    Record.AddSourceLocation(new SourceLocation(E.ProtoLoc));
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_OBJC_PROTOCOL_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 972,
   FQN="clang::ASTStmtWriter::VisitObjCSelectorExpr", NM="_ZN5clang13ASTStmtWriter21VisitObjCSelectorExprEPNS_16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitObjCSelectorExprEPNS_16ObjCSelectorExprE")
  //</editor-fold>
  public void VisitObjCSelectorExpr(ObjCSelectorExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSelectorRef(E.getSelector());
    Record.AddSourceLocation(E.getAtLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_OBJC_SELECTOR_EXPR;
  }

  
  //===----------------------------------------------------------------------===//
  // Objective-C Expressions and Statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 917,
   FQN="clang::ASTStmtWriter::VisitObjCStringLiteral", NM="_ZN5clang13ASTStmtWriter22VisitObjCStringLiteralEPNS_17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitObjCStringLiteralEPNS_17ObjCStringLiteralE")
  //</editor-fold>
  public void VisitObjCStringLiteral(ObjCStringLiteral /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getString());
    Record.AddSourceLocation(E.getAtLoc());
    Code = StmtCode.EXPR_OBJC_STRING_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1026,
   FQN="clang::ASTStmtWriter::VisitObjCSubscriptRefExpr", NM="_ZN5clang13ASTStmtWriter25VisitObjCSubscriptRefExprEPNS_20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitObjCSubscriptRefExprEPNS_20ObjCSubscriptRefExprE")
  //</editor-fold>
  public void VisitObjCSubscriptRefExpr(ObjCSubscriptRefExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getRBracket());
    Record.AddStmt(E.getBaseExpr());
    Record.AddStmt(E.getKeyExpr());
    Record.AddDeclRef(E.getAtIndexMethodDecl());
    Record.AddDeclRef(E.setAtIndexMethodDecl());
    
    Code = StmtCode.EXPR_OBJC_SUBSCRIPT_REF_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 491,
   FQN="clang::ASTStmtWriter::VisitOffsetOfExpr", NM="_ZN5clang13ASTStmtWriter17VisitOffsetOfExprEPNS_12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitOffsetOfExprEPNS_12OffsetOfExprE")
  //</editor-fold>
  public void VisitOffsetOfExpr(OffsetOfExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumComponents()));
    Record.push_back($uint2ulong(E.getNumExpressions()));
    Record.AddSourceLocation(E.getOperatorLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Record.AddTypeSourceInfo(E.getTypeSourceInfo());
    for (/*uint*/int I = 0, N = E.getNumComponents(); I != N; ++I) {
      final /*const*/ OffsetOfNode /*&*/ ON = E.getComponent(I);
      Record.push_back($uint2ulong(ON.getKind())); // FIXME: Stable encoding
      Record.AddSourceLocation(ON.getSourceRange().getBegin());
      Record.AddSourceLocation(ON.getSourceRange().getEnd());
      switch (ON.getKind()) {
       case OffsetOfNode.Kind.Array:
        Record.push_back($uint2ulong(ON.getArrayExprIndex()));
        break;
       case OffsetOfNode.Kind.Field:
        Record.AddDeclRef(ON.getField());
        break;
       case OffsetOfNode.Kind.Identifier:
        Record.AddIdentifierRef(ON.getFieldName());
        break;
       case OffsetOfNode.Kind.Base:
        Record.AddCXXBaseSpecifier($Deref(ON.getBase()));
        break;
      }
    }
    for (/*uint*/int I = 0, N = E.getNumExpressions(); I != N; ++I)  {
      Record.AddStmt(E.getIndexExpr(I));
    }
    Code = StmtCode.EXPR_OFFSETOF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1672,
   FQN="clang::ASTStmtWriter::VisitOpaqueValueExpr", NM="_ZN5clang13ASTStmtWriter20VisitOpaqueValueExprEPNS_15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitOpaqueValueExprEPNS_15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSourceExpr());
    Record.AddSourceLocation(E.getLocation());
    Code = StmtCode.EXPR_OPAQUE_VALUE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOverloadExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1519,
   FQN="clang::ASTStmtWriter::VisitOverloadExpr", NM="_ZN5clang13ASTStmtWriter17VisitOverloadExprEPNS_12OverloadExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitOverloadExprEPNS_12OverloadExprE")
  //</editor-fold>
  public void VisitOverloadExpr(OverloadExpr /*P*/ E) {
    VisitExpr(E);
    
    // Don't emit anything here, HasTemplateKWAndArgsInfo must be
    // emitted first.
    Record.push_back((E.HasTemplateKWAndArgsInfo ? 1 : 0));
    if (E.HasTemplateKWAndArgsInfo) {
      final /*const*/ ASTTemplateKWAndArgsInfo /*&*/ ArgInfo = $Deref(E.getTrailingASTTemplateKWAndArgsInfo());
      Record.push_back($uint2ulong(ArgInfo.NumTemplateArgs));
      AddTemplateKWAndArgsInfo(ArgInfo, E.getTrailingTemplateArgumentLoc());
    }
    
    Record.push_back($uint2ulong(E.getNumDecls()));
    for (UnresolvedSetIterator OvI = E.decls_begin(), OvE = E.decls_end(); OvI.$noteq(OvE); OvI.$preInc()) {
      Record.AddDeclRef(OvI.getDecl());
      Record.push_back(OvI.getAccess().getValue());
    }
    
    Record.AddDeclarationNameInfo(E.NameInfo);
    Record.AddNestedNameSpecifierLoc(E.getQualifierLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1554,
   FQN="clang::ASTStmtWriter::VisitUnresolvedLookupExpr", NM="_ZN5clang13ASTStmtWriter25VisitUnresolvedLookupExprEPNS_20UnresolvedLookupExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitUnresolvedLookupExprEPNS_20UnresolvedLookupExprE")
  //</editor-fold>
  public void VisitUnresolvedLookupExpr(UnresolvedLookupExpr /*P*/ E) {
    VisitOverloadExpr(E);
    Record.push_back((E.requiresADL() ? 1 : 0));
    Record.push_back((E.isOverloaded() ? 1 : 0));
    Record.AddDeclRef(E.getNamingClass());
    Code = StmtCode.EXPR_CXX_UNRESOLVED_LOOKUP;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1544,
   FQN="clang::ASTStmtWriter::VisitUnresolvedMemberExpr", NM="_ZN5clang13ASTStmtWriter25VisitUnresolvedMemberExprEPNS_20UnresolvedMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitUnresolvedMemberExprEPNS_20UnresolvedMemberExprE")
  //</editor-fold>
  public void VisitUnresolvedMemberExpr(UnresolvedMemberExpr /*P*/ E) {
    VisitOverloadExpr(E);
    Record.push_back((E.isArrow() ? 1 : 0));
    Record.push_back((E.hasUnresolvedUsing() ? 1 : 0));
    Record.AddStmt(!E.isImplicitAccess() ? E.getBase() : (Expr /*P*/ )null);
    Record.AddTypeRef(E.getBaseType());
    Record.AddSourceLocation(E.getOperatorLoc());
    Code = StmtCode.EXPR_CXX_UNRESOLVED_MEMBER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitPackExpansionExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1599,
   FQN="clang::ASTStmtWriter::VisitPackExpansionExpr", NM="_ZN5clang13ASTStmtWriter22VisitPackExpansionExprEPNS_17PackExpansionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitPackExpansionExprEPNS_17PackExpansionExprE")
  //</editor-fold>
  public void VisitPackExpansionExpr(PackExpansionExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getEllipsisLoc());
    Record.push_back($uint2ulong(E.NumExpansions));
    Record.AddStmt(E.getPattern());
    Code = StmtCode.EXPR_PACK_EXPANSION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitParenExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 465,
   FQN="clang::ASTStmtWriter::VisitParenExpr", NM="_ZN5clang13ASTStmtWriter14VisitParenExprEPNS_9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitParenExprEPNS_9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(ParenExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getLParen());
    Record.AddSourceLocation(E.getRParen());
    Record.AddStmt(E.getSubExpr());
    Code = StmtCode.EXPR_PAREN;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitParenListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 473,
   FQN="clang::ASTStmtWriter::VisitParenListExpr", NM="_ZN5clang13ASTStmtWriter18VisitParenListExprEPNS_13ParenListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitParenListExprEPNS_13ParenListExprE")
  //</editor-fold>
  public void VisitParenListExpr(ParenListExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.NumExprs));
    for (/*uint*/int i = 0; i != E.NumExprs; ++i)  {
      Record.AddStmt(E.Exprs.$at(i));
    }
    Record.AddSourceLocation(new SourceLocation(E.LParenLoc));
    Record.AddSourceLocation(new SourceLocation(E.RParenLoc));
    Code = StmtCode.EXPR_PAREN_LIST;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 365,
   FQN="clang::ASTStmtWriter::VisitPredefinedExpr", NM="_ZN5clang13ASTStmtWriter19VisitPredefinedExprEPNS_14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitPredefinedExprEPNS_14PredefinedExprE")
  //</editor-fold>
  public void VisitPredefinedExpr(PredefinedExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddSourceLocation(E.getLocation());
    Record.push_back(E.getIdentType().getValue()); // FIXME: stable encoding
    Record.AddStmt(E.getFunctionName());
    Code = StmtCode.EXPR_PREDEFINED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 885,
   FQN="clang::ASTStmtWriter::VisitPseudoObjectExpr", NM="_ZN5clang13ASTStmtWriter21VisitPseudoObjectExprEPNS_16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitPseudoObjectExprEPNS_16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumSemanticExprs()));
    
    // Push the result index.  Currently, this needs to exactly match
    // the encoding used internally for ResultIndex.
    /*uint*/int result = E.getResultExprIndex();
    result = (result == PseudoObjectExpr.NoResult ? 0 : result + 1);
    Record.push_back($uint2ulong(result));
    
    Record.AddStmt(E.getSyntacticForm());
    for (type$ptr<Expr /*P*/ /*const*/ /*P*/> i = $tryClone(E.semantics_begin()), /*P*/ /*const*/ /*P*/ e = $tryClone(E.semantics_end()); $noteq_ptr(i, e); i.$preInc()) {
      Record.AddStmt(i.$star());
    }
    Code = StmtCode.EXPR_PSEUDO_OBJECT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitShuffleVectorExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 843,
   FQN="clang::ASTStmtWriter::VisitShuffleVectorExpr", NM="_ZN5clang13ASTStmtWriter22VisitShuffleVectorExprEPNS_17ShuffleVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitShuffleVectorExprEPNS_17ShuffleVectorExprE")
  //</editor-fold>
  public void VisitShuffleVectorExpr(ShuffleVectorExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getNumSubExprs()));
    for (/*uint*/int I = 0, N = E.getNumSubExprs(); I != N; ++I)  {
      Record.AddStmt(E.getExpr(I));
    }
    Record.AddSourceLocation(E.getBuiltinLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_SHUFFLE_VECTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1607,
   FQN="clang::ASTStmtWriter::VisitSizeOfPackExpr", NM="_ZN5clang13ASTStmtWriter19VisitSizeOfPackExprEPNS_14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitSizeOfPackExprEPNS_14SizeOfPackExprE")
  //</editor-fold>
  public void VisitSizeOfPackExpr(SizeOfPackExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.isPartiallySubstituted() ? E.getPartialArguments().size() : 0));
    Record.AddSourceLocation(new SourceLocation(E.OperatorLoc));
    Record.AddSourceLocation(new SourceLocation(E.PackLoc));
    Record.AddSourceLocation(new SourceLocation(E.RParenLoc));
    Record.AddDeclRef(E.Pack);
    if (E.isPartiallySubstituted()) {
      for (final /*const*/ TemplateArgument /*&*/ TA : E.getPartialArguments())  {
        Record.AddTemplateArgument(TA);
      }
    } else if (!E.isValueDependent()) {
      Record.push_back($uint2ulong(E.getPackLength()));
    }
    Code = StmtCode.EXPR_SIZEOF_PACK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitStmtExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 818,
   FQN="clang::ASTStmtWriter::VisitStmtExpr", NM="_ZN5clang13ASTStmtWriter13VisitStmtExprEPNS_8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitStmtExprEPNS_8StmtExprE")
  //</editor-fold>
  public void VisitStmtExpr(StmtExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubStmt());
    Record.AddSourceLocation(E.getLParenLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_STMT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 438,
   FQN="clang::ASTStmtWriter::VisitStringLiteral", NM="_ZN5clang13ASTStmtWriter18VisitStringLiteralEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitStringLiteralEPNS_13StringLiteralE")
  //</editor-fold>
  public void VisitStringLiteral(StringLiteral /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong(E.getByteLength()));
    Record.push_back($uint2ulong(E.getNumConcatenated()));
    Record.push_back(E.getKind().getValue());
    Record.push_back((E.isPascal() ? 1 : 0));
    // FIXME: String data should be stored as a blob at the end of the
    // StringLiteral. However, we can't do so now because we have no
    // provision for coping with abbreviations when we're jumping around
    // the AST file during deserialization.
    Record.append(E.getBytes().begin(), E.getBytes().end());
    for (/*uint*/int I = 0, N = E.getNumConcatenated(); I != N; ++I)  {
      Record.AddSourceLocation(E.getStrTokenLoc(I));
    }
    Code = StmtCode.EXPR_STRING_LITERAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1624,
   FQN="clang::ASTStmtWriter::VisitSubstNonTypeTemplateParmExpr", NM="_ZN5clang13ASTStmtWriter33VisitSubstNonTypeTemplateParmExprEPNS_28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter33VisitSubstNonTypeTemplateParmExprEPNS_28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getParameter());
    Record.AddSourceLocation(E.getNameLoc());
    Record.AddStmt(E.getReplacement());
    Code = StmtCode.EXPR_SUBST_NON_TYPE_TEMPLATE_PARM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1633,
   FQN="clang::ASTStmtWriter::VisitSubstNonTypeTemplateParmPackExpr", NM="_ZN5clang13ASTStmtWriter37VisitSubstNonTypeTemplateParmPackExprEPNS_32SubstNonTypeTemplateParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter37VisitSubstNonTypeTemplateParmPackExprEPNS_32SubstNonTypeTemplateParmPackExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmPackExpr(SubstNonTypeTemplateParmPackExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddDeclRef(E.getParameterPack());
    Record.AddTemplateArgument(E.getArgumentPack());
    Record.AddSourceLocation(E.getParameterPackLocation());
    Code = StmtCode.EXPR_SUBST_NON_TYPE_TEMPLATE_PARM_PACK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1562,
   FQN="clang::ASTStmtWriter::VisitTypeTraitExpr", NM="_ZN5clang13ASTStmtWriter18VisitTypeTraitExprEPNS_13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitTypeTraitExprEPNS_13TypeTraitExprE")
  //</editor-fold>
  public void VisitTypeTraitExpr(TypeTraitExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back($uint2ulong($7bits_uint2uint(E.Unnamed_field.TypeTraitExprBits.NumArgs)));
    Record.push_back($uint2ulong($8bits_uint2uint(E.Unnamed_field.TypeTraitExprBits.Kind))); // FIXME: Stable encoding
    Record.push_back($uint2ulong(E.Unnamed_field.TypeTraitExprBits.Value));
    Record.AddSourceRange(E.getSourceRange());
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I)  {
      Record.AddTypeSourceInfo(E.getArg(I));
    }
    Code = StmtCode.EXPR_TYPE_TRAIT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1679,
   FQN="clang::ASTStmtWriter::VisitTypoExpr", NM="_ZN5clang13ASTStmtWriter13VisitTypoExprEPNS_8TypoExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitTypoExprEPNS_8TypoExprE")
  //</editor-fold>
  public void VisitTypoExpr(TypoExpr /*P*/ E) {
    VisitExpr(E);
    // TODO: Figure out sane writer behavior for a TypoExpr, if necessary
    throw new llvm_unreachable("Cannot write TypoExpr nodes");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 526,
   FQN="clang::ASTStmtWriter::VisitUnaryExprOrTypeTraitExpr", NM="_ZN5clang13ASTStmtWriter29VisitUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter29VisitUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ E) {
    VisitExpr(E);
    Record.push_back(E.getKind().getValue());
    if (E.isArgumentType()) {
      Record.AddTypeSourceInfo(E.getArgumentTypeInfo());
    } else {
      Record.push_back($int2ulong(0));
      Record.AddStmt(E.getArgumentExpr());
    }
    Record.AddSourceLocation(E.getOperatorLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Code = StmtCode.EXPR_SIZEOF_ALIGN_OF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 483,
   FQN="clang::ASTStmtWriter::VisitUnaryOperator", NM="_ZN5clang13ASTStmtWriter18VisitUnaryOperatorEPNS_13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitUnaryOperatorEPNS_13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubExpr());
    Record.push_back(E.getOpcode().getValue()); // FIXME: stable encoding
    Record.AddSourceLocation(E.getOperatorLoc());
    Code = StmtCode.EXPR_UNARY_OPERATOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 800,
   FQN="clang::ASTStmtWriter::VisitVAArgExpr", NM="_ZN5clang13ASTStmtWriter14VisitVAArgExprEPNS_9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitVAArgExprEPNS_9VAArgExprE")
  //</editor-fold>
  public void VisitVAArgExpr(VAArgExpr /*P*/ E) {
    VisitExpr(E);
    Record.AddStmt(E.getSubExpr());
    Record.AddTypeSourceInfo(E.getWrittenTypeInfo());
    Record.AddSourceLocation(E.getBuiltinLoc());
    Record.AddSourceLocation(E.getRParenLoc());
    Record.push_back((E.isMicrosoftABI() ? 1 : 0));
    Code = StmtCode.EXPR_VA_ARG;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitForStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 175,
   FQN="clang::ASTStmtWriter::VisitForStmt", NM="_ZN5clang13ASTStmtWriter12VisitForStmtEPNS_7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter12VisitForStmtEPNS_7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(ForStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddStmt(S.getInit());
    Record.AddStmt(S.getCond());
    Record.AddDeclRef(S.getConditionVariable());
    Record.AddStmt(S.getInc());
    Record.AddStmt(S.getBody());
    Record.AddSourceLocation(S.getForLoc());
    Record.AddSourceLocation(S.getLParenLoc());
    Record.AddSourceLocation(S.getRParenLoc());
    Code = StmtCode.STMT_FOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitGotoStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 188,
   FQN="clang::ASTStmtWriter::VisitGotoStmt", NM="_ZN5clang13ASTStmtWriter13VisitGotoStmtEPNS_8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitGotoStmtEPNS_8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(GotoStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddDeclRef(S.getLabel());
    Record.AddSourceLocation(S.getGotoLoc());
    Record.AddSourceLocation(S.getLabelLoc());
    Code = StmtCode.STMT_GOTO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitIfStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 129,
   FQN="clang::ASTStmtWriter::VisitIfStmt", NM="_ZN5clang13ASTStmtWriter11VisitIfStmtEPNS_6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter11VisitIfStmtEPNS_6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(IfStmt /*P*/ S) {
    VisitStmt(S);
    Record.push_back((S.isConstexpr() ? 1 : 0));
    Record.AddStmt(S.getInit());
    Record.AddDeclRef(S.getConditionVariable());
    Record.AddStmt(S.getCond());
    Record.AddStmt(S.getThen());
    Record.AddStmt(S.getElse());
    Record.AddSourceLocation(S.getIfLoc());
    Record.AddSourceLocation(S.getElseLoc());
    Code = StmtCode.STMT_IF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 196,
   FQN="clang::ASTStmtWriter::VisitIndirectGotoStmt", NM="_ZN5clang13ASTStmtWriter21VisitIndirectGotoStmtEPNS_16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitIndirectGotoStmtEPNS_16IndirectGotoStmtE")
  //</editor-fold>
  public void VisitIndirectGotoStmt(IndirectGotoStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getGotoLoc());
    Record.AddSourceLocation(S.getStarLoc());
    Record.AddStmt(S.getTarget());
    Code = StmtCode.STMT_INDIRECT_GOTO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitLabelStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 112,
   FQN="clang::ASTStmtWriter::VisitLabelStmt", NM="_ZN5clang13ASTStmtWriter14VisitLabelStmtEPNS_9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitLabelStmtEPNS_9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(LabelStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddDeclRef(S.getDecl());
    Record.AddStmt(S.getSubStmt());
    Record.AddSourceLocation(S.getIdentLoc());
    Code = StmtCode.STMT_LABEL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1190,
   FQN="clang::ASTStmtWriter::VisitMSDependentExistsStmt", NM="_ZN5clang13ASTStmtWriter26VisitMSDependentExistsStmtEPNS_21MSDependentExistsStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitMSDependentExistsStmtEPNS_21MSDependentExistsStmtE")
  //</editor-fold>
  public void VisitMSDependentExistsStmt(MSDependentExistsStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getKeywordLoc());
    Record.push_back((S.isIfExists() ? 1 : 0));
    Record.AddNestedNameSpecifierLoc(S.getQualifierLoc());
    Record.AddDeclarationNameInfo(S.getNameInfo());
    Record.AddStmt(S.getSubStmt());
    Code = StmtCode.STMT_MS_DEPENDENT_EXISTS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitNullStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 73,
   FQN="clang::ASTStmtWriter::VisitNullStmt", NM="_ZN5clang13ASTStmtWriter13VisitNullStmtEPNS_8NullStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitNullStmtEPNS_8NullStmtE")
  //</editor-fold>
  public void VisitNullStmt(NullStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getSemiLoc());
    Record.push_back((S.HasLeadingEmptyMacro ? 1 : 0));
    Code = StmtCode.STMT_NULL;
  }

  
  //===----------------------------------------------------------------------===//
  // OpenMP Directives.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2171,
   FQN="clang::ASTStmtWriter::VisitOMPExecutableDirective", NM="_ZN5clang13ASTStmtWriter27VisitOMPExecutableDirectiveEPNS_22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitOMPExecutableDirectiveEPNS_22OMPExecutableDirectiveE")
  //</editor-fold>
  public void VisitOMPExecutableDirective(OMPExecutableDirective /*P*/ E) {
    Record.AddSourceLocation(E.getLocStart());
    Record.AddSourceLocation(E.getLocEnd());
    OMPClauseWriter ClauseWriter/*J*/= new OMPClauseWriter(Record);
    for (/*uint*/int i = 0; $less_uint(i, E.getNumClauses()); ++i) {
      ClauseWriter.writeClause(E.getClause(i));
    }
    if (E.hasAssociatedStmt()) {
      Record.AddStmt(E.getAssociatedStmt());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPAtomicDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2317,
   FQN="clang::ASTStmtWriter::VisitOMPAtomicDirective", NM="_ZN5clang13ASTStmtWriter23VisitOMPAtomicDirectiveEPNS_18OMPAtomicDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitOMPAtomicDirectiveEPNS_18OMPAtomicDirectiveE")
  //</editor-fold>
  public void VisitOMPAtomicDirective(OMPAtomicDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.AddStmt(D.getX());
    Record.AddStmt(D.getV());
    Record.AddStmt(D.getExpr());
    Record.AddStmt(D.getUpdateExpr());
    Record.push_back($int2ulong(D.isXLHSInRHSPart() ? 1 : 0));
    Record.push_back($int2ulong(D.isPostfixUpdate() ? 1 : 0));
    Code = StmtCode.STMT_OMP_ATOMIC_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPBarrierDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2381,
   FQN="clang::ASTStmtWriter::VisitOMPBarrierDirective", NM="_ZN5clang13ASTStmtWriter24VisitOMPBarrierDirectiveEPNS_19OMPBarrierDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitOMPBarrierDirectiveEPNS_19OMPBarrierDirectiveE")
  //</editor-fold>
  public void VisitOMPBarrierDirective(OMPBarrierDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_BARRIER_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPCancelDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2428,
   FQN="clang::ASTStmtWriter::VisitOMPCancelDirective", NM="_ZN5clang13ASTStmtWriter23VisitOMPCancelDirectiveEPNS_18OMPCancelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitOMPCancelDirectiveEPNS_18OMPCancelDirectiveE")
  //</editor-fold>
  public void VisitOMPCancelDirective(OMPCancelDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.push_back(D.getCancelRegion().getValue());
    Code = StmtCode.STMT_OMP_CANCEL_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2420,
   FQN="clang::ASTStmtWriter::VisitOMPCancellationPointDirective", NM="_ZN5clang13ASTStmtWriter34VisitOMPCancellationPointDirectiveEPNS_29OMPCancellationPointDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter34VisitOMPCancellationPointDirectiveEPNS_29OMPCancellationPointDirectiveE")
  //</editor-fold>
  public void VisitOMPCancellationPointDirective(OMPCancellationPointDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Record.push_back(D.getCancelRegion().getValue());
    Code = StmtCode.STMT_OMP_CANCELLATION_POINT_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPCriticalDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2280,
   FQN="clang::ASTStmtWriter::VisitOMPCriticalDirective", NM="_ZN5clang13ASTStmtWriter25VisitOMPCriticalDirectiveEPNS_20OMPCriticalDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitOMPCriticalDirectiveEPNS_20OMPCriticalDirectiveE")
  //</editor-fold>
  public void VisitOMPCriticalDirective(OMPCriticalDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.AddDeclarationNameInfo(D.getDirectiveName());
    Code = StmtCode.STMT_OMP_CRITICAL_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPFlushDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2399,
   FQN="clang::ASTStmtWriter::VisitOMPFlushDirective", NM="_ZN5clang13ASTStmtWriter22VisitOMPFlushDirectiveEPNS_17OMPFlushDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitOMPFlushDirectiveEPNS_17OMPFlushDirectiveE")
  //</editor-fold>
  public void VisitOMPFlushDirective(OMPFlushDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_FLUSH_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2182,
   FQN="clang::ASTStmtWriter::VisitOMPLoopDirective", NM="_ZN5clang13ASTStmtWriter21VisitOMPLoopDirectiveEPNS_16OMPLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitOMPLoopDirectiveEPNS_16OMPLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPLoopDirective(OMPLoopDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    Record.push_back($uint2ulong(D.getCollapsedNumber()));
    VisitOMPExecutableDirective(D);
    Record.AddStmt(D.getIterationVariable());
    Record.AddStmt(D.getLastIteration());
    Record.AddStmt(D.getCalcLastIteration());
    Record.AddStmt(D.getPreCond());
    Record.AddStmt(D.getCond());
    Record.AddStmt(D.getInit());
    Record.AddStmt(D.getInc());
    Record.AddStmt(D.getPreInits());
    if (isOpenMPWorksharingDirective(D.getDirectiveKind())
       || isOpenMPTaskLoopDirective(D.getDirectiveKind())
       || isOpenMPDistributeDirective(D.getDirectiveKind())) {
      Record.AddStmt(D.getIsLastIterVariable());
      Record.AddStmt(D.getLowerBoundVariable());
      Record.AddStmt(D.getUpperBoundVariable());
      Record.AddStmt(D.getStrideVariable());
      Record.AddStmt(D.getEnsureUpperBound());
      Record.AddStmt(D.getNextLowerBound());
      Record.AddStmt(D.getNextUpperBound());
      Record.AddStmt(D.getNumIterations());
    }
    if (isOpenMPLoopBoundSharingDirective(D.getDirectiveKind())) {
      Record.AddStmt(D.getPrevLowerBoundVariable());
      Record.AddStmt(D.getPrevUpperBoundVariable());
    }
    for (Expr /*P*/ I : D.counters()) {
      Record.AddStmt(I);
    }
    for (Expr /*P*/ I : D.private_counters()) {
      Record.AddStmt(I);
    }
    for (Expr /*P*/ I : D.inits()) {
      Record.AddStmt(I);
    }
    for (Expr /*P*/ I : D.updates()) {
      Record.AddStmt(I);
    }
    for (Expr /*P*/ I : D.finals()) {
      Record.AddStmt(I);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPDistributeDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2446,
   FQN="clang::ASTStmtWriter::VisitOMPDistributeDirective", NM="_ZN5clang13ASTStmtWriter27VisitOMPDistributeDirectiveEPNS_22OMPDistributeDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitOMPDistributeDirectiveEPNS_22OMPDistributeDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeDirective(OMPDistributeDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_DISTRIBUTE_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2458,
   FQN="clang::ASTStmtWriter::VisitOMPDistributeParallelForDirective", NM="_ZN5clang13ASTStmtWriter38VisitOMPDistributeParallelForDirectiveEPNS_33OMPDistributeParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter38VisitOMPDistributeParallelForDirectiveEPNS_33OMPDistributeParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForDirective(OMPDistributeParallelForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_DISTRIBUTE_PARALLEL_FOR_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPDistributeParallelForSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2464,
   FQN="clang::ASTStmtWriter::VisitOMPDistributeParallelForSimdDirective", NM="_ZN5clang13ASTStmtWriter42VisitOMPDistributeParallelForSimdDirectiveEPNS_37OMPDistributeParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter42VisitOMPDistributeParallelForSimdDirectiveEPNS_37OMPDistributeParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForSimdDirective(OMPDistributeParallelForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_DISTRIBUTE_PARALLEL_FOR_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPDistributeSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2470,
   FQN="clang::ASTStmtWriter::VisitOMPDistributeSimdDirective", NM="_ZN5clang13ASTStmtWriter31VisitOMPDistributeSimdDirectiveEPNS_26OMPDistributeSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter31VisitOMPDistributeSimdDirectiveEPNS_26OMPDistributeSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeSimdDirective(OMPDistributeSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_DISTRIBUTE_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPForDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2241,
   FQN="clang::ASTStmtWriter::VisitOMPForDirective", NM="_ZN5clang13ASTStmtWriter20VisitOMPForDirectiveEPNS_15OMPForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitOMPForDirectiveEPNS_15OMPForDirectiveE")
  //</editor-fold>
  public void VisitOMPForDirective(OMPForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_FOR_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPForSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2247,
   FQN="clang::ASTStmtWriter::VisitOMPForSimdDirective", NM="_ZN5clang13ASTStmtWriter24VisitOMPForSimdDirectiveEPNS_19OMPForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitOMPForSimdDirectiveEPNS_19OMPForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPForSimdDirective(OMPForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_FOR_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPParallelForDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2288,
   FQN="clang::ASTStmtWriter::VisitOMPParallelForDirective", NM="_ZN5clang13ASTStmtWriter28VisitOMPParallelForDirectiveEPNS_23OMPParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter28VisitOMPParallelForDirectiveEPNS_23OMPParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForDirective(OMPParallelForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_PARALLEL_FOR_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPParallelForSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2294,
   FQN="clang::ASTStmtWriter::VisitOMPParallelForSimdDirective", NM="_ZN5clang13ASTStmtWriter32VisitOMPParallelForSimdDirectiveEPNS_27OMPParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter32VisitOMPParallelForSimdDirectiveEPNS_27OMPParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForSimdDirective(OMPParallelForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_PARALLEL_FOR_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2236,
   FQN="clang::ASTStmtWriter::VisitOMPSimdDirective", NM="_ZN5clang13ASTStmtWriter21VisitOMPSimdDirectiveEPNS_16OMPSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitOMPSimdDirectiveEPNS_16OMPSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPSimdDirective(OMPSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetParallelForSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2476,
   FQN="clang::ASTStmtWriter::VisitOMPTargetParallelForSimdDirective", NM="_ZN5clang13ASTStmtWriter38VisitOMPTargetParallelForSimdDirectiveEPNS_33OMPTargetParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter38VisitOMPTargetParallelForSimdDirectiveEPNS_33OMPTargetParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForSimdDirective(OMPTargetParallelForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_PARALLEL_FOR_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTaskLoopDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2436,
   FQN="clang::ASTStmtWriter::VisitOMPTaskLoopDirective", NM="_ZN5clang13ASTStmtWriter25VisitOMPTaskLoopDirectiveEPNS_20OMPTaskLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitOMPTaskLoopDirectiveEPNS_20OMPTaskLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopDirective(OMPTaskLoopDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_TASKLOOP_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTaskLoopSimdDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2441,
   FQN="clang::ASTStmtWriter::VisitOMPTaskLoopSimdDirective", NM="_ZN5clang13ASTStmtWriter29VisitOMPTaskLoopSimdDirectiveEPNS_24OMPTaskLoopSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter29VisitOMPTaskLoopSimdDirectiveEPNS_24OMPTaskLoopSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopSimdDirective(OMPTaskLoopSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Code = StmtCode.STMT_OMP_TASKLOOP_SIMD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPMasterDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2274,
   FQN="clang::ASTStmtWriter::VisitOMPMasterDirective", NM="_ZN5clang13ASTStmtWriter23VisitOMPMasterDirectiveEPNS_18OMPMasterDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitOMPMasterDirectiveEPNS_18OMPMasterDirectiveE")
  //</editor-fold>
  public void VisitOMPMasterDirective(OMPMasterDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_MASTER_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPOrderedDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2406,
   FQN="clang::ASTStmtWriter::VisitOMPOrderedDirective", NM="_ZN5clang13ASTStmtWriter24VisitOMPOrderedDirectiveEPNS_19OMPOrderedDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitOMPOrderedDirectiveEPNS_19OMPOrderedDirectiveE")
  //</editor-fold>
  public void VisitOMPOrderedDirective(OMPOrderedDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_ORDERED_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPParallelDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2228,
   FQN="clang::ASTStmtWriter::VisitOMPParallelDirective", NM="_ZN5clang13ASTStmtWriter25VisitOMPParallelDirectiveEPNS_20OMPParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitOMPParallelDirectiveEPNS_20OMPParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelDirective(OMPParallelDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_PARALLEL_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPParallelSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2300,
   FQN="clang::ASTStmtWriter::VisitOMPParallelSectionsDirective", NM="_ZN5clang13ASTStmtWriter33VisitOMPParallelSectionsDirectiveEPNS_28OMPParallelSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter33VisitOMPParallelSectionsDirectiveEPNS_28OMPParallelSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelSectionsDirective(OMPParallelSectionsDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_PARALLEL_SECTIONS_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPSectionDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2260,
   FQN="clang::ASTStmtWriter::VisitOMPSectionDirective", NM="_ZN5clang13ASTStmtWriter24VisitOMPSectionDirectiveEPNS_19OMPSectionDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter24VisitOMPSectionDirectiveEPNS_19OMPSectionDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionDirective(OMPSectionDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_SECTION_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPSectionsDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2252,
   FQN="clang::ASTStmtWriter::VisitOMPSectionsDirective", NM="_ZN5clang13ASTStmtWriter25VisitOMPSectionsDirectiveEPNS_20OMPSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitOMPSectionsDirectiveEPNS_20OMPSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionsDirective(OMPSectionsDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_SECTIONS_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPSingleDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2267,
   FQN="clang::ASTStmtWriter::VisitOMPSingleDirective", NM="_ZN5clang13ASTStmtWriter23VisitOMPSingleDirectiveEPNS_18OMPSingleDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitOMPSingleDirectiveEPNS_18OMPSingleDirectiveE")
  //</editor-fold>
  public void VisitOMPSingleDirective(OMPSingleDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_SINGLE_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetDataDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2337,
   FQN="clang::ASTStmtWriter::VisitOMPTargetDataDirective", NM="_ZN5clang13ASTStmtWriter27VisitOMPTargetDataDirectiveEPNS_22OMPTargetDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitOMPTargetDataDirectiveEPNS_22OMPTargetDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDataDirective(OMPTargetDataDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_DATA_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2330,
   FQN="clang::ASTStmtWriter::VisitOMPTargetDirective", NM="_ZN5clang13ASTStmtWriter23VisitOMPTargetDirectiveEPNS_18OMPTargetDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter23VisitOMPTargetDirectiveEPNS_18OMPTargetDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDirective(OMPTargetDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetEnterDataDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2344,
   FQN="clang::ASTStmtWriter::VisitOMPTargetEnterDataDirective", NM="_ZN5clang13ASTStmtWriter32VisitOMPTargetEnterDataDirectiveEPNS_27OMPTargetEnterDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter32VisitOMPTargetEnterDataDirectiveEPNS_27OMPTargetEnterDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetEnterDataDirective(OMPTargetEnterDataDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_ENTER_DATA_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetExitDataDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2352,
   FQN="clang::ASTStmtWriter::VisitOMPTargetExitDataDirective", NM="_ZN5clang13ASTStmtWriter31VisitOMPTargetExitDataDirectiveEPNS_26OMPTargetExitDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter31VisitOMPTargetExitDataDirectiveEPNS_26OMPTargetExitDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetExitDataDirective(OMPTargetExitDataDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_EXIT_DATA_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetParallelDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2360,
   FQN="clang::ASTStmtWriter::VisitOMPTargetParallelDirective", NM="_ZN5clang13ASTStmtWriter31VisitOMPTargetParallelDirectiveEPNS_26OMPTargetParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter31VisitOMPTargetParallelDirectiveEPNS_26OMPTargetParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelDirective(OMPTargetParallelDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_PARALLEL_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetParallelForDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2368,
   FQN="clang::ASTStmtWriter::VisitOMPTargetParallelForDirective", NM="_ZN5clang13ASTStmtWriter34VisitOMPTargetParallelForDirectiveEPNS_29OMPTargetParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter34VisitOMPTargetParallelForDirectiveEPNS_29OMPTargetParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForDirective(OMPTargetParallelForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_TARGET_PARALLEL_FOR_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTargetUpdateDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2451,
   FQN="clang::ASTStmtWriter::VisitOMPTargetUpdateDirective", NM="_ZN5clang13ASTStmtWriter29VisitOMPTargetUpdateDirectiveEPNS_24OMPTargetUpdateDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter29VisitOMPTargetUpdateDirectiveEPNS_24OMPTargetUpdateDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetUpdateDirective(OMPTargetUpdateDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TARGET_UPDATE_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTaskDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2309,
   FQN="clang::ASTStmtWriter::VisitOMPTaskDirective", NM="_ZN5clang13ASTStmtWriter21VisitOMPTaskDirectiveEPNS_16OMPTaskDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter21VisitOMPTaskDirectiveEPNS_16OMPTaskDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskDirective(OMPTaskDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Record.push_back($int2ulong(D.hasCancel() ? 1 : 0));
    Code = StmtCode.STMT_OMP_TASK_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTaskgroupDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2393,
   FQN="clang::ASTStmtWriter::VisitOMPTaskgroupDirective", NM="_ZN5clang13ASTStmtWriter26VisitOMPTaskgroupDirectiveEPNS_21OMPTaskgroupDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitOMPTaskgroupDirectiveEPNS_21OMPTaskgroupDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskgroupDirective(OMPTaskgroupDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TASKGROUP_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTaskwaitDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2387,
   FQN="clang::ASTStmtWriter::VisitOMPTaskwaitDirective", NM="_ZN5clang13ASTStmtWriter25VisitOMPTaskwaitDirectiveEPNS_20OMPTaskwaitDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter25VisitOMPTaskwaitDirectiveEPNS_20OMPTaskwaitDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskwaitDirective(OMPTaskwaitDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TASKWAIT_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTaskyieldDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2375,
   FQN="clang::ASTStmtWriter::VisitOMPTaskyieldDirective", NM="_ZN5clang13ASTStmtWriter26VisitOMPTaskyieldDirectiveEPNS_21OMPTaskyieldDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitOMPTaskyieldDirectiveEPNS_21OMPTaskyieldDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskyieldDirective(OMPTaskyieldDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TASKYIELD_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitOMPTeamsDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2413,
   FQN="clang::ASTStmtWriter::VisitOMPTeamsDirective", NM="_ZN5clang13ASTStmtWriter22VisitOMPTeamsDirectiveEPNS_17OMPTeamsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitOMPTeamsDirectiveEPNS_17OMPTeamsDirectiveE")
  //</editor-fold>
  public void VisitOMPTeamsDirective(OMPTeamsDirective /*P*/ D) {
    VisitStmt(D);
    Record.push_back($uint2ulong(D.getNumClauses()));
    VisitOMPExecutableDirective(D);
    Code = StmtCode.STMT_OMP_TEAMS_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1093,
   FQN="clang::ASTStmtWriter::VisitObjCAtCatchStmt", NM="_ZN5clang13ASTStmtWriter20VisitObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE")
  //</editor-fold>
  public void VisitObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ S) {
    Record.AddStmt(S.getCatchBody());
    Record.AddDeclRef(S.getCatchParamDecl());
    Record.AddSourceLocation(S.getAtCatchLoc());
    Record.AddSourceLocation(S.getRParenLoc());
    Code = StmtCode.STMT_OBJC_CATCH;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1101,
   FQN="clang::ASTStmtWriter::VisitObjCAtFinallyStmt", NM="_ZN5clang13ASTStmtWriter22VisitObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter22VisitObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE")
  //</editor-fold>
  public void VisitObjCAtFinallyStmt(ObjCAtFinallyStmt /*P*/ S) {
    Record.AddStmt(S.getFinallyBody());
    Record.AddSourceLocation(S.getAtFinallyLoc());
    Code = StmtCode.STMT_OBJC_FINALLY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1125,
   FQN="clang::ASTStmtWriter::VisitObjCAtSynchronizedStmt", NM="_ZN5clang13ASTStmtWriter27VisitObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter27VisitObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public void VisitObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S) {
    Record.AddStmt(S.getSynchExpr());
    Record.AddStmt(S.getSynchBody());
    Record.AddSourceLocation(S.getAtSynchronizedLoc());
    Code = StmtCode.STMT_OBJC_AT_SYNCHRONIZED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1132,
   FQN="clang::ASTStmtWriter::VisitObjCAtThrowStmt", NM="_ZN5clang13ASTStmtWriter20VisitObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter20VisitObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE")
  //</editor-fold>
  public void VisitObjCAtThrowStmt(ObjCAtThrowStmt /*P*/ S) {
    Record.AddStmt(S.getThrowExpr());
    Record.AddSourceLocation(S.getThrowLoc());
    Code = StmtCode.STMT_OBJC_AT_THROW;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1113,
   FQN="clang::ASTStmtWriter::VisitObjCAtTryStmt", NM="_ZN5clang13ASTStmtWriter18VisitObjCAtTryStmtEPNS_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitObjCAtTryStmtEPNS_13ObjCAtTryStmtE")
  //</editor-fold>
  public void VisitObjCAtTryStmt(ObjCAtTryStmt /*P*/ S) {
    Record.push_back($uint2ulong(S.getNumCatchStmts()));
    Record.push_back(((S.getFinallyStmt() != (ObjCAtFinallyStmt /*P*/ )null) ? 1 : 0));
    Record.AddStmt(S.getTryBody());
    for (/*uint*/int I = 0, N = S.getNumCatchStmts(); I != N; ++I)  {
      Record.AddStmt(S.getCatchStmt(I));
    }
    if ((S.getFinallyStmt() != null)) {
      Record.AddStmt(S.getFinallyStmt());
    }
    Record.AddSourceLocation(S.getAtTryLoc());
    Code = StmtCode.STMT_OBJC_AT_TRY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1107,
   FQN="clang::ASTStmtWriter::VisitObjCAutoreleasePoolStmt", NM="_ZN5clang13ASTStmtWriter28VisitObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter28VisitObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public void VisitObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ S) {
    Record.AddStmt(S.getSubStmt());
    Record.AddSourceLocation(S.getAtLoc());
    Code = StmtCode.STMT_OBJC_AUTORELEASE_POOL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1083,
   FQN="clang::ASTStmtWriter::VisitObjCForCollectionStmt", NM="_ZN5clang13ASTStmtWriter26VisitObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter26VisitObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddStmt(S.getElement());
    Record.AddStmt(S.getCollection());
    Record.AddStmt(S.getBody());
    Record.AddSourceLocation(S.getForLoc());
    Record.AddSourceLocation(S.getRParenLoc());
    Code = StmtCode.STMT_OBJC_FOR_COLLECTION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitReturnStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 216,
   FQN="clang::ASTStmtWriter::VisitReturnStmt", NM="_ZN5clang13ASTStmtWriter15VisitReturnStmtEPNS_10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitReturnStmtEPNS_10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(ReturnStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddStmt(S.getRetValue());
    Record.AddSourceLocation(S.getReturnLoc());
    Record.AddDeclRef(S.getNRVOCandidate());
    Code = StmtCode.STMT_RETURN;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSEHExceptStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1740,
   FQN="clang::ASTStmtWriter::VisitSEHExceptStmt", NM="_ZN5clang13ASTStmtWriter18VisitSEHExceptStmtEPNS_13SEHExceptStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter18VisitSEHExceptStmtEPNS_13SEHExceptStmtE")
  //</editor-fold>
  public void VisitSEHExceptStmt(SEHExceptStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getExceptLoc());
    Record.AddStmt(S.getFilterExpr());
    Record.AddStmt(S.getBlock());
    Code = StmtCode.STMT_SEH_EXCEPT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSEHFinallyStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1748,
   FQN="clang::ASTStmtWriter::VisitSEHFinallyStmt", NM="_ZN5clang13ASTStmtWriter19VisitSEHFinallyStmtEPNS_14SEHFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter19VisitSEHFinallyStmtEPNS_14SEHFinallyStmtE")
  //</editor-fold>
  public void VisitSEHFinallyStmt(SEHFinallyStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getFinallyLoc());
    Record.AddStmt(S.getBlock());
    Code = StmtCode.STMT_SEH_FINALLY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSEHLeaveStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1764,
   FQN="clang::ASTStmtWriter::VisitSEHLeaveStmt", NM="_ZN5clang13ASTStmtWriter17VisitSEHLeaveStmtEPNS_12SEHLeaveStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter17VisitSEHLeaveStmtEPNS_12SEHLeaveStmtE")
  //</editor-fold>
  public void VisitSEHLeaveStmt(SEHLeaveStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddSourceLocation(S.getLeaveLoc());
    Code = StmtCode.STMT_SEH_LEAVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSEHTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1755,
   FQN="clang::ASTStmtWriter::VisitSEHTryStmt", NM="_ZN5clang13ASTStmtWriter15VisitSEHTryStmtEPNS_10SEHTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitSEHTryStmtEPNS_10SEHTryStmtE")
  //</editor-fold>
  public void VisitSEHTryStmt(SEHTryStmt /*P*/ S) {
    VisitStmt(S);
    Record.push_back((S.getIsCXXTry() ? 1 : 0));
    Record.AddSourceLocation(S.getTryLoc());
    Record.AddStmt(S.getTryBlock());
    Record.AddStmt(S.getHandler());
    Code = StmtCode.STMT_SEH_TRY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 90,
   FQN="clang::ASTStmtWriter::VisitSwitchCase", NM="_ZN5clang13ASTStmtWriter15VisitSwitchCaseEPNS_10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitSwitchCaseEPNS_10SwitchCaseE")
  //</editor-fold>
  public void VisitSwitchCase(SwitchCase /*P*/ S) {
    VisitStmt(S);
    Record.push_back($uint2ulong(Writer.getSwitchCaseID(S)));
    Record.AddSourceLocation(S.getKeywordLoc());
    Record.AddSourceLocation(S.getColonLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitCaseStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 97,
   FQN="clang::ASTStmtWriter::VisitCaseStmt", NM="_ZN5clang13ASTStmtWriter13VisitCaseStmtEPNS_8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter13VisitCaseStmtEPNS_8CaseStmtE")
  //</editor-fold>
  public void VisitCaseStmt(CaseStmt /*P*/ S) {
    VisitSwitchCase(S);
    Record.AddStmt(S.getLHS());
    Record.AddStmt(S.getRHS());
    Record.AddStmt(S.getSubStmt());
    Record.AddSourceLocation(S.getEllipsisLoc());
    Code = StmtCode.STMT_CASE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 106,
   FQN="clang::ASTStmtWriter::VisitDefaultStmt", NM="_ZN5clang13ASTStmtWriter16VisitDefaultStmtEPNS_11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter16VisitDefaultStmtEPNS_11DefaultStmtE")
  //</editor-fold>
  public void VisitDefaultStmt(DefaultStmt /*P*/ S) {
    VisitSwitchCase(S);
    Record.AddStmt(S.getSubStmt());
    Code = StmtCode.STMT_DEFAULT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 142,
   FQN="clang::ASTStmtWriter::VisitSwitchStmt", NM="_ZN5clang13ASTStmtWriter15VisitSwitchStmtEPNS_10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter15VisitSwitchStmtEPNS_10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(SwitchStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddStmt(S.getInit());
    Record.AddDeclRef(S.getConditionVariable());
    Record.AddStmt(S.getCond());
    Record.AddStmt(S.getBody());
    Record.AddSourceLocation(S.getSwitchLoc());
    Record.push_back((S.isAllEnumCasesCovered() ? 1 : 0));
    for (SwitchCase /*P*/ SC = S.getSwitchCaseList(); (SC != null);
         SC = SC.getNextSwitchCase())  {
      Record.push_back($uint2ulong(Writer.RecordSwitchCaseID(SC)));
    }
    Code = StmtCode.STMT_SWITCH;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::VisitWhileStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 156,
   FQN="clang::ASTStmtWriter::VisitWhileStmt", NM="_ZN5clang13ASTStmtWriter14VisitWhileStmtEPNS_9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriter14VisitWhileStmtEPNS_9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(WhileStmt /*P*/ S) {
    VisitStmt(S);
    Record.AddDeclRef(S.getConditionVariable());
    Record.AddStmt(S.getCond());
    Record.AddStmt(S.getBody());
    Record.AddSourceLocation(S.getWhileLoc());
    Code = StmtCode.STMT_WHILE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtWriter::~ASTStmtWriter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 31,
   FQN="clang::ASTStmtWriter::~ASTStmtWriter", NM="_ZN5clang13ASTStmtWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang13ASTStmtWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Record.$destroy();
    StmtVisitorVoid.super.$destroy$StmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Code=" + Code // NOI18N
              + ", AbbrevToUse=" + AbbrevToUse // NOI18N
              + super.toString(); // NOI18N
  }
}
