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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.serialization.*;

//<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1775,
 FQN="clang::OMPClauseWriter", NM="_ZN5clang15OMPClauseWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriterE")
//</editor-fold>
public class OMPClauseWriter implements /*public*/ OMPClauseVisitorVoid<OMPClauseWriter> {
  private final ASTRecordWriter /*&*/ Record;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::OMPClauseWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1778,
   FQN="clang::OMPClauseWriter::OMPClauseWriter", NM="_ZN5clang15OMPClauseWriterC1ERNS_15ASTRecordWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriterC1ERNS_15ASTRecordWriterE")
  //</editor-fold>
  public OMPClauseWriter(final ASTRecordWriter /*&*/ Record) {
    // : OMPClauseVisitor<OMPClauseWriter>(), Record(Record) 
    //START JInit
    $OMPClauseVisitor();
    this./*&*/Record=/*&*/Record;
    //END JInit
  }

  
  // OpenMP clauses.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1804,
   FQN="clang::OMPClauseWriter::VisitOMPIfClause", NM="_ZN5clang15OMPClauseWriter16VisitOMPIfClauseEPNS_11OMPIfClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter16VisitOMPIfClauseEPNS_11OMPIfClauseE")
  //</editor-fold>
  public void VisitOMPIfClause(OMPIfClause /*P*/ C) {
    Record.push_back(C.getNameModifier().getValue());
    Record.AddSourceLocation(C.getNameModifierLoc());
    Record.AddSourceLocation(C.getColonLoc());
    Record.AddStmt(C.getCondition());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPFinalClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1812,
   FQN="clang::OMPClauseWriter::VisitOMPFinalClause", NM="_ZN5clang15OMPClauseWriter19VisitOMPFinalClauseEPNS_14OMPFinalClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter19VisitOMPFinalClauseEPNS_14OMPFinalClauseE")
  //</editor-fold>
  public void VisitOMPFinalClause(OMPFinalClause /*P*/ C) {
    Record.AddStmt(C.getCondition());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1817,
   FQN="clang::OMPClauseWriter::VisitOMPNumThreadsClause", NM="_ZN5clang15OMPClauseWriter24VisitOMPNumThreadsClauseEPNS_19OMPNumThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter24VisitOMPNumThreadsClauseEPNS_19OMPNumThreadsClauseE")
  //</editor-fold>
  public void VisitOMPNumThreadsClause(OMPNumThreadsClause /*P*/ C) {
    Record.AddStmt(C.getNumThreads());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPSafelenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1822,
   FQN="clang::OMPClauseWriter::VisitOMPSafelenClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPSafelenClauseEPNS_16OMPSafelenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPSafelenClauseEPNS_16OMPSafelenClauseE")
  //</editor-fold>
  public void VisitOMPSafelenClause(OMPSafelenClause /*P*/ C) {
    Record.AddStmt(C.getSafelen());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1827,
   FQN="clang::OMPClauseWriter::VisitOMPSimdlenClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPSimdlenClauseEPNS_16OMPSimdlenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPSimdlenClauseEPNS_16OMPSimdlenClauseE")
  //</editor-fold>
  public void VisitOMPSimdlenClause(OMPSimdlenClause /*P*/ C) {
    Record.AddStmt(C.getSimdlen());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPCollapseClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1832,
   FQN="clang::OMPClauseWriter::VisitOMPCollapseClause", NM="_ZN5clang15OMPClauseWriter22VisitOMPCollapseClauseEPNS_17OMPCollapseClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter22VisitOMPCollapseClauseEPNS_17OMPCollapseClauseE")
  //</editor-fold>
  public void VisitOMPCollapseClause(OMPCollapseClause /*P*/ C) {
    Record.AddStmt(C.getNumForLoops());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1837,
   FQN="clang::OMPClauseWriter::VisitOMPDefaultClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPDefaultClauseEPNS_16OMPDefaultClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPDefaultClauseEPNS_16OMPDefaultClauseE")
  //</editor-fold>
  public void VisitOMPDefaultClause(OMPDefaultClause /*P*/ C) {
    Record.push_back(C.getDefaultKind().getValue());
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getDefaultKindKwLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1889,
   FQN="clang::OMPClauseWriter::VisitOMPPrivateClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPPrivateClauseEPNS_16OMPPrivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPPrivateClauseEPNS_16OMPPrivateClauseE")
  //</editor-fold>
  public void VisitOMPPrivateClause(OMPPrivateClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.private_copies()) {
      Record.AddStmt(VE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1900,
   FQN="clang::OMPClauseWriter::VisitOMPFirstprivateClause", NM="_ZN5clang15OMPClauseWriter26VisitOMPFirstprivateClauseEPNS_21OMPFirstprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter26VisitOMPFirstprivateClauseEPNS_21OMPFirstprivateClauseE")
  //</editor-fold>
  public void VisitOMPFirstprivateClause(OMPFirstprivateClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    VisitOMPClauseWithPreInit(C);
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.private_copies()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.inits()) {
      Record.AddStmt(VE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1915,
   FQN="clang::OMPClauseWriter::VisitOMPLastprivateClause", NM="_ZN5clang15OMPClauseWriter25VisitOMPLastprivateClauseEPNS_20OMPLastprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter25VisitOMPLastprivateClauseEPNS_20OMPLastprivateClauseE")
  //</editor-fold>
  public void VisitOMPLastprivateClause(OMPLastprivateClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    VisitOMPClauseWithPostUpdate(C);
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ E : C.private_copies())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.source_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.destination_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.assignment_ops())  {
      Record.AddStmt(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPSharedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1931,
   FQN="clang::OMPClauseWriter::VisitOMPSharedClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPSharedClauseEPNS_15OMPSharedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPSharedClauseEPNS_15OMPSharedClauseE")
  //</editor-fold>
  public void VisitOMPSharedClause(OMPSharedClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1938,
   FQN="clang::OMPClauseWriter::VisitOMPReductionClause", NM="_ZN5clang15OMPClauseWriter23VisitOMPReductionClauseEPNS_18OMPReductionClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter23VisitOMPReductionClauseEPNS_18OMPReductionClauseE")
  //</editor-fold>
  public void VisitOMPReductionClause(OMPReductionClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    VisitOMPClauseWithPostUpdate(C);
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getColonLoc());
    Record.AddNestedNameSpecifierLoc(C.getQualifierLoc());
    Record.AddDeclarationNameInfo(C.getNameInfo());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.privates())  {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ E : C.lhs_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.rhs_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.reduction_ops())  {
      Record.AddStmt(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1957,
   FQN="clang::OMPClauseWriter::VisitOMPLinearClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPLinearClauseEPNS_15OMPLinearClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPLinearClauseEPNS_15OMPLinearClauseE")
  //</editor-fold>
  public void VisitOMPLinearClause(OMPLinearClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    VisitOMPClauseWithPostUpdate(C);
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getColonLoc());
    Record.push_back(C.getModifier().getValue());
    Record.AddSourceLocation(C.getModifierLoc());
    for (Expr /*P*/ VE : C.varlists()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.privates()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.inits()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.updates()) {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ VE : C.finals()) {
      Record.AddStmt(VE);
    }
    Record.AddStmt(C.getStep());
    Record.AddStmt(C.getCalcStep());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1983,
   FQN="clang::OMPClauseWriter::VisitOMPAlignedClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPAlignedClauseEPNS_16OMPAlignedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPAlignedClauseEPNS_16OMPAlignedClauseE")
  //</editor-fold>
  public void VisitOMPAlignedClause(OMPAlignedClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getColonLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
    Record.AddStmt(C.getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1992,
   FQN="clang::OMPClauseWriter::VisitOMPCopyinClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPCopyinClauseEPNS_15OMPCopyinClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPCopyinClauseEPNS_15OMPCopyinClauseE")
  //</editor-fold>
  public void VisitOMPCopyinClause(OMPCopyinClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ E : C.source_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.destination_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.assignment_ops())  {
      Record.AddStmt(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2005,
   FQN="clang::OMPClauseWriter::VisitOMPCopyprivateClause", NM="_ZN5clang15OMPClauseWriter25VisitOMPCopyprivateClauseEPNS_20OMPCopyprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter25VisitOMPCopyprivateClauseEPNS_20OMPCopyprivateClauseE")
  //</editor-fold>
  public void VisitOMPCopyprivateClause(OMPCopyprivateClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
    for (Expr /*P*/ E : C.source_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.destination_exprs())  {
      Record.AddStmt(E);
    }
    for (Expr /*P*/ E : C.assignment_ops())  {
      Record.AddStmt(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1843,
   FQN="clang::OMPClauseWriter::VisitOMPProcBindClause", NM="_ZN5clang15OMPClauseWriter22VisitOMPProcBindClauseEPNS_17OMPProcBindClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter22VisitOMPProcBindClauseEPNS_17OMPProcBindClauseE")
  //</editor-fold>
  public void VisitOMPProcBindClause(OMPProcBindClause /*P*/ C) {
    Record.push_back(C.getProcBindKind().getValue());
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getProcBindKindKwLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1849,
   FQN="clang::OMPClauseWriter::VisitOMPScheduleClause", NM="_ZN5clang15OMPClauseWriter22VisitOMPScheduleClauseEPNS_17OMPScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter22VisitOMPScheduleClauseEPNS_17OMPScheduleClauseE")
  //</editor-fold>
  public void VisitOMPScheduleClause(OMPScheduleClause /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    Record.push_back($uint2ulong(C.getScheduleKind()));
    Record.push_back($uint2ulong(C.getFirstScheduleModifier()));
    Record.push_back($uint2ulong(C.getSecondScheduleModifier()));
    Record.AddStmt(C.getChunkSize());
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getFirstScheduleModifierLoc());
    Record.AddSourceLocation(C.getSecondScheduleModifierLoc());
    Record.AddSourceLocation(C.getScheduleKindLoc());
    Record.AddSourceLocation(C.getCommaLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPOrderedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1862,
   FQN="clang::OMPClauseWriter::VisitOMPOrderedClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPOrderedClauseEPNS_16OMPOrderedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPOrderedClauseEPNS_16OMPOrderedClauseE")
  //</editor-fold>
  public void VisitOMPOrderedClause(OMPOrderedClause /*P*/ C) {
    Record.AddStmt(C.getNumForLoops());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPNowaitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1867,
   FQN="clang::OMPClauseWriter::VisitOMPNowaitClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPNowaitClauseEPNS_15OMPNowaitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPNowaitClauseEPNS_15OMPNowaitClauseE")
  //</editor-fold>
  public void VisitOMPNowaitClause(OMPNowaitClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPUntiedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1869,
   FQN="clang::OMPClauseWriter::VisitOMPUntiedClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPUntiedClauseEPNS_15OMPUntiedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPUntiedClauseEPNS_15OMPUntiedClauseE")
  //</editor-fold>
  public void VisitOMPUntiedClause(OMPUntiedClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPMergeableClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1871,
   FQN="clang::OMPClauseWriter::VisitOMPMergeableClause", NM="_ZN5clang15OMPClauseWriter23VisitOMPMergeableClauseEPNS_18OMPMergeableClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter23VisitOMPMergeableClauseEPNS_18OMPMergeableClauseE")
  //</editor-fold>
  public void VisitOMPMergeableClause(OMPMergeableClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPFlushClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2018,
   FQN="clang::OMPClauseWriter::VisitOMPFlushClause", NM="_ZN5clang15OMPClauseWriter19VisitOMPFlushClauseEPNS_14OMPFlushClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter19VisitOMPFlushClauseEPNS_14OMPFlushClauseE")
  //</editor-fold>
  public void VisitOMPFlushClause(OMPFlushClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPReadClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1873,
   FQN="clang::OMPClauseWriter::VisitOMPReadClause", NM="_ZN5clang15OMPClauseWriter18VisitOMPReadClauseEPNS_13OMPReadClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter18VisitOMPReadClauseEPNS_13OMPReadClauseE")
  //</editor-fold>
  public void VisitOMPReadClause(OMPReadClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPWriteClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1875,
   FQN="clang::OMPClauseWriter::VisitOMPWriteClause", NM="_ZN5clang15OMPClauseWriter19VisitOMPWriteClauseEPNS_14OMPWriteClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter19VisitOMPWriteClauseEPNS_14OMPWriteClauseE")
  //</editor-fold>
  public void VisitOMPWriteClause(OMPWriteClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPUpdateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1877,
   FQN="clang::OMPClauseWriter::VisitOMPUpdateClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPUpdateClauseEPNS_15OMPUpdateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPUpdateClauseEPNS_15OMPUpdateClauseE")
  //</editor-fold>
  public void VisitOMPUpdateClause(OMPUpdateClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPCaptureClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1879,
   FQN="clang::OMPClauseWriter::VisitOMPCaptureClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPCaptureClauseEPNS_16OMPCaptureClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPCaptureClauseEPNS_16OMPCaptureClauseE")
  //</editor-fold>
  public void VisitOMPCaptureClause(OMPCaptureClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPSeqCstClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1881,
   FQN="clang::OMPClauseWriter::VisitOMPSeqCstClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPSeqCstClauseEPNS_15OMPSeqCstClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPSeqCstClauseEPNS_15OMPSeqCstClauseE")
  //</editor-fold>
  public void VisitOMPSeqCstClause(OMPSeqCstClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2025,
   FQN="clang::OMPClauseWriter::VisitOMPDependClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPDependClauseEPNS_15OMPDependClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPDependClauseEPNS_15OMPDependClauseE")
  //</editor-fold>
  public void VisitOMPDependClause(OMPDependClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    Record.push_back(C.getDependencyKind().getValue());
    Record.AddSourceLocation(C.getDependencyLoc());
    Record.AddSourceLocation(C.getColonLoc());
    for (Expr /*P*/ VE : C.varlists())  {
      Record.AddStmt(VE);
    }
    Record.AddStmt(C.getCounterValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPDeviceClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2036,
   FQN="clang::OMPClauseWriter::VisitOMPDeviceClause", NM="_ZN5clang15OMPClauseWriter20VisitOMPDeviceClauseEPNS_15OMPDeviceClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter20VisitOMPDeviceClauseEPNS_15OMPDeviceClauseE")
  //</editor-fold>
  public void VisitOMPDeviceClause(OMPDeviceClause /*P*/ C) {
    Record.AddStmt(C.getDevice());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1883,
   FQN="clang::OMPClauseWriter::VisitOMPThreadsClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPThreadsClauseEPNS_16OMPThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPThreadsClauseEPNS_16OMPThreadsClauseE")
  //</editor-fold>
  public void VisitOMPThreadsClause(OMPThreadsClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPSIMDClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1885,
   FQN="clang::OMPClauseWriter::VisitOMPSIMDClause", NM="_ZN5clang15OMPClauseWriter18VisitOMPSIMDClauseEPNS_13OMPSIMDClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter18VisitOMPSIMDClauseEPNS_13OMPSIMDClauseE")
  //</editor-fold>
  public void VisitOMPSIMDClause(OMPSIMDClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2041,
   FQN="clang::OMPClauseWriter::VisitOMPMapClause", NM="_ZN5clang15OMPClauseWriter17VisitOMPMapClauseEPNS_12OMPMapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter17VisitOMPMapClauseEPNS_12OMPMapClauseE")
  //</editor-fold>
  public void VisitOMPMapClause(OMPMapClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.push_back($uint2ulong(C.getUniqueDeclarationsNum()));
    Record.push_back($uint2ulong(C.getTotalComponentListNum()));
    Record.push_back($uint2ulong(C.getTotalComponentsNum()));
    Record.AddSourceLocation(C.getLParenLoc());
    Record.push_back(C.getMapTypeModifier().getValue());
    Record.push_back(C.getMapType().getValue());
    Record.AddSourceLocation(C.getMapLoc());
    Record.AddSourceLocation(C.getColonLoc());
    for (Expr /*P*/ E : C.varlists())  {
      Record.AddStmt(E);
    }
    for (ValueDecl /*P*/ D : C.all_decls())  {
      Record.AddDeclRef(D);
    }
    for (/*uint*/int N : C.all_num_lists())  {
      Record.push_back($uint2ulong(N));
    }
    for (/*uint*/int N : C.all_lists_sizes())  {
      Record.push_back($uint2ulong(N));
    }
    for (final OMPClauseMappableExprCommon./*const*/ MappableComponent /*&*/ M : C.all_components()) {
      Record.AddStmt(M.getAssociatedExpression());
      Record.AddDeclRef(M.getAssociatedDeclaration());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2065,
   FQN="clang::OMPClauseWriter::VisitOMPNumTeamsClause", NM="_ZN5clang15OMPClauseWriter22VisitOMPNumTeamsClauseEPNS_17OMPNumTeamsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter22VisitOMPNumTeamsClauseEPNS_17OMPNumTeamsClauseE")
  //</editor-fold>
  public void VisitOMPNumTeamsClause(OMPNumTeamsClause /*P*/ C) {
    Record.AddStmt(C.getNumTeams());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2070,
   FQN="clang::OMPClauseWriter::VisitOMPThreadLimitClause", NM="_ZN5clang15OMPClauseWriter25VisitOMPThreadLimitClauseEPNS_20OMPThreadLimitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter25VisitOMPThreadLimitClauseEPNS_20OMPThreadLimitClauseE")
  //</editor-fold>
  public void VisitOMPThreadLimitClause(OMPThreadLimitClause /*P*/ C) {
    Record.AddStmt(C.getThreadLimit());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2075,
   FQN="clang::OMPClauseWriter::VisitOMPPriorityClause", NM="_ZN5clang15OMPClauseWriter22VisitOMPPriorityClauseEPNS_17OMPPriorityClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter22VisitOMPPriorityClauseEPNS_17OMPPriorityClauseE")
  //</editor-fold>
  public void VisitOMPPriorityClause(OMPPriorityClause /*P*/ C) {
    Record.AddStmt(C.getPriority());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2080,
   FQN="clang::OMPClauseWriter::VisitOMPGrainsizeClause", NM="_ZN5clang15OMPClauseWriter23VisitOMPGrainsizeClauseEPNS_18OMPGrainsizeClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter23VisitOMPGrainsizeClauseEPNS_18OMPGrainsizeClauseE")
  //</editor-fold>
  public void VisitOMPGrainsizeClause(OMPGrainsizeClause /*P*/ C) {
    Record.AddStmt(C.getGrainsize());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPNogroupClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1887,
   FQN="clang::OMPClauseWriter::VisitOMPNogroupClause", NM="_ZN5clang15OMPClauseWriter21VisitOMPNogroupClauseEPNS_16OMPNogroupClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter21VisitOMPNogroupClauseEPNS_16OMPNogroupClauseE")
  //</editor-fold>
  public void VisitOMPNogroupClause(OMPNogroupClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPNumTasksClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2085,
   FQN="clang::OMPClauseWriter::VisitOMPNumTasksClause", NM="_ZN5clang15OMPClauseWriter22VisitOMPNumTasksClauseEPNS_17OMPNumTasksClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter22VisitOMPNumTasksClauseEPNS_17OMPNumTasksClauseE")
  //</editor-fold>
  public void VisitOMPNumTasksClause(OMPNumTasksClause /*P*/ C) {
    Record.AddStmt(C.getNumTasks());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2090,
   FQN="clang::OMPClauseWriter::VisitOMPHintClause", NM="_ZN5clang15OMPClauseWriter18VisitOMPHintClauseEPNS_13OMPHintClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter18VisitOMPHintClauseEPNS_13OMPHintClauseE")
  //</editor-fold>
  public void VisitOMPHintClause(OMPHintClause /*P*/ C) {
    Record.AddStmt(C.getHint());
    Record.AddSourceLocation(C.getLParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2095,
   FQN="clang::OMPClauseWriter::VisitOMPDistScheduleClause", NM="_ZN5clang15OMPClauseWriter26VisitOMPDistScheduleClauseEPNS_21OMPDistScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter26VisitOMPDistScheduleClauseEPNS_21OMPDistScheduleClauseE")
  //</editor-fold>
  public void VisitOMPDistScheduleClause(OMPDistScheduleClause /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    Record.push_back($uint2ulong(C.getDistScheduleKind()));
    Record.AddStmt(C.getChunkSize());
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getDistScheduleKindLoc());
    Record.AddSourceLocation(C.getCommaLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2104,
   FQN="clang::OMPClauseWriter::VisitOMPDefaultmapClause", NM="_ZN5clang15OMPClauseWriter24VisitOMPDefaultmapClauseEPNS_19OMPDefaultmapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter24VisitOMPDefaultmapClauseEPNS_19OMPDefaultmapClauseE")
  //</editor-fold>
  public void VisitOMPDefaultmapClause(OMPDefaultmapClause /*P*/ C) {
    Record.push_back($uint2ulong(C.getDefaultmapKind()));
    Record.push_back($uint2ulong(C.getDefaultmapModifier()));
    Record.AddSourceLocation(C.getLParenLoc());
    Record.AddSourceLocation(C.getDefaultmapModifierLoc());
    Record.AddSourceLocation(C.getDefaultmapKindLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPToClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2112,
   FQN="clang::OMPClauseWriter::VisitOMPToClause", NM="_ZN5clang15OMPClauseWriter16VisitOMPToClauseEPNS_11OMPToClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter16VisitOMPToClauseEPNS_11OMPToClauseE")
  //</editor-fold>
  public void VisitOMPToClause(OMPToClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.push_back($uint2ulong(C.getUniqueDeclarationsNum()));
    Record.push_back($uint2ulong(C.getTotalComponentListNum()));
    Record.push_back($uint2ulong(C.getTotalComponentsNum()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ E : C.varlists())  {
      Record.AddStmt(E);
    }
    for (ValueDecl /*P*/ D : C.all_decls())  {
      Record.AddDeclRef(D);
    }
    for (/*uint*/int N : C.all_num_lists())  {
      Record.push_back($uint2ulong(N));
    }
    for (/*uint*/int N : C.all_lists_sizes())  {
      Record.push_back($uint2ulong(N));
    }
    for (final OMPClauseMappableExprCommon./*const*/ MappableComponent /*&*/ M : C.all_components()) {
      Record.AddStmt(M.getAssociatedExpression());
      Record.AddDeclRef(M.getAssociatedDeclaration());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2132,
   FQN="clang::OMPClauseWriter::VisitOMPFromClause", NM="_ZN5clang15OMPClauseWriter18VisitOMPFromClauseEPNS_13OMPFromClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter18VisitOMPFromClauseEPNS_13OMPFromClauseE")
  //</editor-fold>
  public void VisitOMPFromClause(OMPFromClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.push_back($uint2ulong(C.getUniqueDeclarationsNum()));
    Record.push_back($uint2ulong(C.getTotalComponentListNum()));
    Record.push_back($uint2ulong(C.getTotalComponentsNum()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ E : C.varlists())  {
      Record.AddStmt(E);
    }
    for (ValueDecl /*P*/ D : C.all_decls())  {
      Record.AddDeclRef(D);
    }
    for (/*uint*/int N : C.all_num_lists())  {
      Record.push_back($uint2ulong(N));
    }
    for (/*uint*/int N : C.all_lists_sizes())  {
      Record.push_back($uint2ulong(N));
    }
    for (final OMPClauseMappableExprCommon./*const*/ MappableComponent /*&*/ M : C.all_components()) {
      Record.AddStmt(M.getAssociatedExpression());
      Record.AddDeclRef(M.getAssociatedDeclaration());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2152,
   FQN="clang::OMPClauseWriter::VisitOMPUseDevicePtrClause", NM="_ZN5clang15OMPClauseWriter26VisitOMPUseDevicePtrClauseEPNS_21OMPUseDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter26VisitOMPUseDevicePtrClauseEPNS_21OMPUseDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPUseDevicePtrClause(OMPUseDevicePtrClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists()) {
      Record.AddStmt(VE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2160,
   FQN="clang::OMPClauseWriter::VisitOMPIsDevicePtrClause", NM="_ZN5clang15OMPClauseWriter25VisitOMPIsDevicePtrClauseEPNS_20OMPIsDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter25VisitOMPIsDevicePtrClauseEPNS_20OMPIsDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPIsDevicePtrClause(OMPIsDevicePtrClause /*P*/ C) {
    Record.push_back($uint2ulong(C.varlist_size()));
    Record.AddSourceLocation(C.getLParenLoc());
    for (Expr /*P*/ VE : C.varlists()) {
      Record.AddStmt(VE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::writeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1788,
   FQN="clang::OMPClauseWriter::writeClause", NM="_ZN5clang15OMPClauseWriter11writeClauseEPNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter11writeClauseEPNS_9OMPClauseE")
  //</editor-fold>
  public void writeClause(OMPClause /*P*/ C) {
    Record.push_back(C.getClauseKind().getValue());
    Visit(C);
    Record.AddSourceLocation(C.getLocStart());
    Record.AddSourceLocation(C.getLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPClauseWithPreInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1795,
   FQN="clang::OMPClauseWriter::VisitOMPClauseWithPreInit", NM="_ZN5clang15OMPClauseWriter25VisitOMPClauseWithPreInitEPNS_20OMPClauseWithPreInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter25VisitOMPClauseWithPreInitEPNS_20OMPClauseWithPreInitE")
  //</editor-fold>
  public void VisitOMPClauseWithPreInit(OMPClauseWithPreInit /*P*/ C) {
    Record.AddStmt(C.getPreInitStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseWriter::VisitOMPClauseWithPostUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 1799,
   FQN="clang::OMPClauseWriter::VisitOMPClauseWithPostUpdate", NM="_ZN5clang15OMPClauseWriter28VisitOMPClauseWithPostUpdateEPNS_23OMPClauseWithPostUpdateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15OMPClauseWriter28VisitOMPClauseWithPostUpdateEPNS_23OMPClauseWithPostUpdateE")
  //</editor-fold>
  public void VisitOMPClauseWithPostUpdate(OMPClauseWithPostUpdate /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    Record.AddStmt(C.getPostUpdateExpr());
  }

  
  @Override public String toString() {
    return "" + "Record=" + Record // NOI18N
              + super.toString(); // NOI18N
  }
}
