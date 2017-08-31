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
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1765,
 FQN="clang::OMPClauseReader", NM="_ZN5clang15OMPClauseReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReaderE")
//</editor-fold>
public class OMPClauseReader implements /*public*/ OMPClauseVisitorVoid<OMPClauseReader> {
  private ASTStmtReader /*P*/ Reader;
  private final ASTContext /*&*/ Context;
  private final /*const*/SmallVectorULong /*&*/ Record;
  private final uint$ref/*uint &*/ Idx;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::OMPClauseReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1771,
   FQN="clang::OMPClauseReader::OMPClauseReader", NM="_ZN5clang15OMPClauseReaderC1EPNS_13ASTStmtReaderERNS_10ASTContextERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReaderC1EPNS_13ASTStmtReaderERNS_10ASTContextERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public OMPClauseReader(ASTStmtReader /*P*/ R, final ASTContext /*&*/ C, 
      final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    // : OMPClauseVisitor<OMPClauseReader>(), Reader(R), Context(C), Record(Record), Idx(Idx) 
    //START JInit
    $OMPClauseVisitor();
    this.Reader = R;
    this./*&*/Context=/*&*/C;
    this./*&*/Record=/*&*/Record;
    this./*&*/Idx=/*&*/Idx;
    //END JInit
  }

  
  // OpenMP clauses.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPIfClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1958,
   FQN="clang::OMPClauseReader::VisitOMPIfClause", NM="_ZN5clang15OMPClauseReader16VisitOMPIfClauseEPNS_11OMPIfClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader16VisitOMPIfClauseEPNS_11OMPIfClauseE")
  //</editor-fold>
  public void VisitOMPIfClause(OMPIfClause /*P*/ C) {
    C.setNameModifier(/*static_cast*/OpenMPDirectiveKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setNameModifierLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setColonLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setCondition(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPFinalClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1966,
   FQN="clang::OMPClauseReader::VisitOMPFinalClause", NM="_ZN5clang15OMPClauseReader19VisitOMPFinalClauseEPNS_14OMPFinalClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader19VisitOMPFinalClauseEPNS_14OMPFinalClauseE")
  //</editor-fold>
  public void VisitOMPFinalClause(OMPFinalClause /*P*/ C) {
    C.setCondition(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1971,
   FQN="clang::OMPClauseReader::VisitOMPNumThreadsClause", NM="_ZN5clang15OMPClauseReader24VisitOMPNumThreadsClauseEPNS_19OMPNumThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader24VisitOMPNumThreadsClauseEPNS_19OMPNumThreadsClauseE")
  //</editor-fold>
  public void VisitOMPNumThreadsClause(OMPNumThreadsClause /*P*/ C) {
    C.setNumThreads(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPSafelenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1976,
   FQN="clang::OMPClauseReader::VisitOMPSafelenClause", NM="_ZN5clang15OMPClauseReader21VisitOMPSafelenClauseEPNS_16OMPSafelenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPSafelenClauseEPNS_16OMPSafelenClauseE")
  //</editor-fold>
  public void VisitOMPSafelenClause(OMPSafelenClause /*P*/ C) {
    C.setSafelen(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPSimdlenClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1981,
   FQN="clang::OMPClauseReader::VisitOMPSimdlenClause", NM="_ZN5clang15OMPClauseReader21VisitOMPSimdlenClauseEPNS_16OMPSimdlenClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPSimdlenClauseEPNS_16OMPSimdlenClauseE")
  //</editor-fold>
  public void VisitOMPSimdlenClause(OMPSimdlenClause /*P*/ C) {
    C.setSimdlen(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPCollapseClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1986,
   FQN="clang::OMPClauseReader::VisitOMPCollapseClause", NM="_ZN5clang15OMPClauseReader22VisitOMPCollapseClauseEPNS_17OMPCollapseClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader22VisitOMPCollapseClauseEPNS_17OMPCollapseClauseE")
  //</editor-fold>
  public void VisitOMPCollapseClause(OMPCollapseClause /*P*/ C) {
    C.setNumForLoops(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPDefaultClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1991,
   FQN="clang::OMPClauseReader::VisitOMPDefaultClause", NM="_ZN5clang15OMPClauseReader21VisitOMPDefaultClauseEPNS_16OMPDefaultClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPDefaultClauseEPNS_16OMPDefaultClauseE")
  //</editor-fold>
  public void VisitOMPDefaultClause(OMPDefaultClause /*P*/ C) {
    C.setDefaultKind(/*static_cast*/OpenMPDefaultClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setDefaultKindKwLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPPrivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2048,
   FQN="clang::OMPClauseReader::VisitOMPPrivateClause", NM="_ZN5clang15OMPClauseReader21VisitOMPPrivateClauseEPNS_16OMPPrivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPPrivateClauseEPNS_16OMPPrivateClauseE")
  //</editor-fold>
  public void VisitOMPPrivateClause(OMPPrivateClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setPrivateCopies(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2062,
   FQN="clang::OMPClauseReader::VisitOMPFirstprivateClause", NM="_ZN5clang15OMPClauseReader26VisitOMPFirstprivateClauseEPNS_21OMPFirstprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader26VisitOMPFirstprivateClauseEPNS_21OMPFirstprivateClauseE")
  //</editor-fold>
  public void VisitOMPFirstprivateClause(OMPFirstprivateClause /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setPrivateCopies(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setInits(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPLastprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2081,
   FQN="clang::OMPClauseReader::VisitOMPLastprivateClause", NM="_ZN5clang15OMPClauseReader25VisitOMPLastprivateClauseEPNS_20OMPLastprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader25VisitOMPLastprivateClauseEPNS_20OMPLastprivateClauseE")
  //</editor-fold>
  public void VisitOMPLastprivateClause(OMPLastprivateClause /*P*/ C) {
    VisitOMPClauseWithPostUpdate(C);
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setPrivateCopies(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setSourceExprs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setDestinationExprs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setAssignmentOps(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPSharedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2108,
   FQN="clang::OMPClauseReader::VisitOMPSharedClause", NM="_ZN5clang15OMPClauseReader20VisitOMPSharedClauseEPNS_15OMPSharedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPSharedClauseEPNS_15OMPSharedClauseE")
  //</editor-fold>
  public void VisitOMPSharedClause(OMPSharedClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPReductionClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2118,
   FQN="clang::OMPClauseReader::VisitOMPReductionClause", NM="_ZN5clang15OMPClauseReader23VisitOMPReductionClauseEPNS_18OMPReductionClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader23VisitOMPReductionClauseEPNS_18OMPReductionClauseE")
  //</editor-fold>
  public void VisitOMPReductionClause(OMPReductionClause /*P*/ C) {
    VisitOMPClauseWithPostUpdate(C);
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setColonLoc(Reader.ReadSourceLocation(Record, Idx));
    NestedNameSpecifierLoc NNSL = Reader.Reader.ReadNestedNameSpecifierLoc(Reader.F, Record, Idx);
    DeclarationNameInfo DNI/*J*/= new DeclarationNameInfo();
    Reader.ReadDeclarationNameInfo(DNI, Record, Idx);
    C.setQualifierLoc(new NestedNameSpecifierLoc(NNSL));
    C.setNameInfo(new DeclarationNameInfo(DNI));
    
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setPrivates(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setLHSExprs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setRHSExprs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setReductionOps(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPLinearClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2153,
   FQN="clang::OMPClauseReader::VisitOMPLinearClause", NM="_ZN5clang15OMPClauseReader20VisitOMPLinearClauseEPNS_15OMPLinearClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPLinearClauseEPNS_15OMPLinearClauseE")
  //</editor-fold>
  public void VisitOMPLinearClause(OMPLinearClause /*P*/ C) {
    VisitOMPClauseWithPostUpdate(C);
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setColonLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setModifier(/*static_cast*/OpenMPLinearClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setModifierLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setPrivates(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setInits(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setUpdates(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setFinals(new ArrayRef<Expr /*P*/ >(Vars, true));
    C.setStep(Reader.Reader.ReadSubExpr());
    C.setCalcStep(Reader.Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPAlignedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2185,
   FQN="clang::OMPClauseReader::VisitOMPAlignedClause", NM="_ZN5clang15OMPClauseReader21VisitOMPAlignedClauseEPNS_16OMPAlignedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPAlignedClauseEPNS_16OMPAlignedClauseE")
  //</editor-fold>
  public void VisitOMPAlignedClause(OMPAlignedClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setColonLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    C.setAlignment(Reader.Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPCopyinClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2197,
   FQN="clang::OMPClauseReader::VisitOMPCopyinClause", NM="_ZN5clang15OMPClauseReader20VisitOMPCopyinClauseEPNS_15OMPCopyinClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPCopyinClauseEPNS_15OMPCopyinClauseE")
  //</editor-fold>
  public void VisitOMPCopyinClause(OMPCopyinClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Exprs.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Exprs, true));
    Exprs.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setSourceExprs(new ArrayRef<Expr /*P*/ >(Exprs, true));
    Exprs.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setDestinationExprs(new ArrayRef<Expr /*P*/ >(Exprs, true));
    Exprs.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setAssignmentOps(new ArrayRef<Expr /*P*/ >(Exprs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2219,
   FQN="clang::OMPClauseReader::VisitOMPCopyprivateClause", NM="_ZN5clang15OMPClauseReader25VisitOMPCopyprivateClauseEPNS_20OMPCopyprivateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader25VisitOMPCopyprivateClauseEPNS_20OMPCopyprivateClauseE")
  //</editor-fold>
  public void VisitOMPCopyprivateClause(OMPCopyprivateClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Exprs.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Exprs, true));
    Exprs.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setSourceExprs(new ArrayRef<Expr /*P*/ >(Exprs, true));
    Exprs.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setDestinationExprs(new ArrayRef<Expr /*P*/ >(Exprs, true));
    Exprs.clear();
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Exprs.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setAssignmentOps(new ArrayRef<Expr /*P*/ >(Exprs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPProcBindClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1998,
   FQN="clang::OMPClauseReader::VisitOMPProcBindClause", NM="_ZN5clang15OMPClauseReader22VisitOMPProcBindClauseEPNS_17OMPProcBindClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader22VisitOMPProcBindClauseEPNS_17OMPProcBindClauseE")
  //</editor-fold>
  public void VisitOMPProcBindClause(OMPProcBindClause /*P*/ C) {
    C.setProcBindKind(/*static_cast*/OpenMPProcBindClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setProcBindKindKwLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2005,
   FQN="clang::OMPClauseReader::VisitOMPScheduleClause", NM="_ZN5clang15OMPClauseReader22VisitOMPScheduleClauseEPNS_17OMPScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader22VisitOMPScheduleClauseEPNS_17OMPScheduleClauseE")
  //</editor-fold>
  public void VisitOMPScheduleClause(OMPScheduleClause /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    C.setScheduleKind(((/*static_cast*//*OpenMPScheduleClauseKind*/int)(Record.$at$Const(Idx.$set$postInc()))));
    C.setFirstScheduleModifier(((/*static_cast*//*OpenMPScheduleClauseModifier*/int)(Record.$at$Const(Idx.$set$postInc()))));
    C.setSecondScheduleModifier(((/*static_cast*//*OpenMPScheduleClauseModifier*/int)(Record.$at$Const(Idx.$set$postInc()))));
    C.setChunkSize(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setFirstScheduleModifierLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setSecondScheduleModifierLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setScheduleKindLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setCommaLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPOrderedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2021,
   FQN="clang::OMPClauseReader::VisitOMPOrderedClause", NM="_ZN5clang15OMPClauseReader21VisitOMPOrderedClauseEPNS_16OMPOrderedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPOrderedClauseEPNS_16OMPOrderedClauseE")
  //</editor-fold>
  public void VisitOMPOrderedClause(OMPOrderedClause /*P*/ C) {
    C.setNumForLoops(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPNowaitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2026,
   FQN="clang::OMPClauseReader::VisitOMPNowaitClause", NM="_ZN5clang15OMPClauseReader20VisitOMPNowaitClauseEPNS_15OMPNowaitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPNowaitClauseEPNS_15OMPNowaitClauseE")
  //</editor-fold>
  public void VisitOMPNowaitClause(OMPNowaitClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPUntiedClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2028,
   FQN="clang::OMPClauseReader::VisitOMPUntiedClause", NM="_ZN5clang15OMPClauseReader20VisitOMPUntiedClauseEPNS_15OMPUntiedClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPUntiedClauseEPNS_15OMPUntiedClauseE")
  //</editor-fold>
  public void VisitOMPUntiedClause(OMPUntiedClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPMergeableClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2030,
   FQN="clang::OMPClauseReader::VisitOMPMergeableClause", NM="_ZN5clang15OMPClauseReader23VisitOMPMergeableClauseEPNS_18OMPMergeableClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader23VisitOMPMergeableClauseEPNS_18OMPMergeableClauseE")
  //</editor-fold>
  public void VisitOMPMergeableClause(OMPMergeableClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPFlushClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2241,
   FQN="clang::OMPClauseReader::VisitOMPFlushClause", NM="_ZN5clang15OMPClauseReader19VisitOMPFlushClauseEPNS_14OMPFlushClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader19VisitOMPFlushClauseEPNS_14OMPFlushClauseE")
  //</editor-fold>
  public void VisitOMPFlushClause(OMPFlushClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPReadClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2032,
   FQN="clang::OMPClauseReader::VisitOMPReadClause", NM="_ZN5clang15OMPClauseReader18VisitOMPReadClauseEPNS_13OMPReadClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader18VisitOMPReadClauseEPNS_13OMPReadClauseE")
  //</editor-fold>
  public void VisitOMPReadClause(OMPReadClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPWriteClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2034,
   FQN="clang::OMPClauseReader::VisitOMPWriteClause", NM="_ZN5clang15OMPClauseReader19VisitOMPWriteClauseEPNS_14OMPWriteClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader19VisitOMPWriteClauseEPNS_14OMPWriteClauseE")
  //</editor-fold>
  public void VisitOMPWriteClause(OMPWriteClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPUpdateClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2036,
   FQN="clang::OMPClauseReader::VisitOMPUpdateClause", NM="_ZN5clang15OMPClauseReader20VisitOMPUpdateClauseEPNS_15OMPUpdateClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPUpdateClauseEPNS_15OMPUpdateClauseE")
  //</editor-fold>
  public void VisitOMPUpdateClause(OMPUpdateClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPCaptureClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2038,
   FQN="clang::OMPClauseReader::VisitOMPCaptureClause", NM="_ZN5clang15OMPClauseReader21VisitOMPCaptureClauseEPNS_16OMPCaptureClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPCaptureClauseEPNS_16OMPCaptureClauseE")
  //</editor-fold>
  public void VisitOMPCaptureClause(OMPCaptureClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPSeqCstClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2040,
   FQN="clang::OMPClauseReader::VisitOMPSeqCstClause", NM="_ZN5clang15OMPClauseReader20VisitOMPSeqCstClauseEPNS_15OMPSeqCstClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPSeqCstClauseEPNS_15OMPSeqCstClauseE")
  //</editor-fold>
  public void VisitOMPSeqCstClause(OMPSeqCstClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2251,
   FQN="clang::OMPClauseReader::VisitOMPDependClause", NM="_ZN5clang15OMPClauseReader20VisitOMPDependClauseEPNS_15OMPDependClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPDependClauseEPNS_15OMPDependClauseE")
  //</editor-fold>
  public void VisitOMPDependClause(OMPDependClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setDependencyKind(/*static_cast*/OpenMPDependClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setDependencyLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setColonLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    C.setCounterValue(Reader.Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPDeviceClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2265,
   FQN="clang::OMPClauseReader::VisitOMPDeviceClause", NM="_ZN5clang15OMPClauseReader20VisitOMPDeviceClauseEPNS_15OMPDeviceClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader20VisitOMPDeviceClauseEPNS_15OMPDeviceClauseE")
  //</editor-fold>
  public void VisitOMPDeviceClause(OMPDeviceClause /*P*/ C) {
    C.setDevice(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2042,
   FQN="clang::OMPClauseReader::VisitOMPThreadsClause", NM="_ZN5clang15OMPClauseReader21VisitOMPThreadsClauseEPNS_16OMPThreadsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPThreadsClauseEPNS_16OMPThreadsClauseE")
  //</editor-fold>
  public void VisitOMPThreadsClause(OMPThreadsClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPSIMDClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2044,
   FQN="clang::OMPClauseReader::VisitOMPSIMDClause", NM="_ZN5clang15OMPClauseReader18VisitOMPSIMDClauseEPNS_13OMPSIMDClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader18VisitOMPSIMDClauseEPNS_13OMPSIMDClauseE")
  //</editor-fold>
  public void VisitOMPSIMDClause(OMPSIMDClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2270,
   FQN="clang::OMPClauseReader::VisitOMPMapClause", NM="_ZN5clang15OMPClauseReader17VisitOMPMapClauseEPNS_12OMPMapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader17VisitOMPMapClauseEPNS_12OMPMapClauseE")
  //</editor-fold>
  public void VisitOMPMapClause(OMPMapClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setMapTypeModifier(/*static_cast*/OpenMPMapClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setMapType(/*static_cast*/OpenMPMapClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    C.setMapLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setColonLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    /*uint*/int UniqueDecls = C.getUniqueDeclarationsNum();
    /*uint*/int TotalLists = C.getTotalComponentListNum();
    /*uint*/int TotalComponents = C.getTotalComponentsNum();
    
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    
    SmallVector<ValueDecl /*P*/ > Decls/*J*/= new SmallVector<ValueDecl /*P*/ >(16, (ValueDecl /*P*/ )null);
    Decls.reserve(UniqueDecls);
    for (/*uint*/int i = 0; $less_uint(i, UniqueDecls); ++i)  {
      Decls.push_back(Reader.Reader.<ValueDecl>ReadDeclAs(ValueDecl.class, Reader.F, Record, Idx));
    }
    C.setUniqueDecls(new ArrayRef<ValueDecl /*P*/ >(Decls, true));
    
    SmallVectorUInt ListsPerDecl/*J*/= new SmallVectorUInt(16, 0);
    ListsPerDecl.reserve(UniqueDecls);
    for (/*uint*/int i = 0; $less_uint(i, UniqueDecls); ++i)  {
      ListsPerDecl.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    C.setDeclNumLists(new ArrayRefUInt(ListsPerDecl));
    
    SmallVectorUInt ListSizes/*J*/= new SmallVectorUInt(32, 0);
    ListSizes.reserve(TotalLists);
    for (/*uint*/int i = 0; $less_uint(i, TotalLists); ++i)  {
      ListSizes.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    C.setComponentListSizes(new ArrayRefUInt(ListSizes));
    
    SmallVector<OMPClauseMappableExprCommon.MappableComponent> Components/*J*/= new SmallVector<OMPClauseMappableExprCommon.MappableComponent>(32, new OMPClauseMappableExprCommon.MappableComponent());
    Components.reserve(TotalComponents);
    for (/*uint*/int i = 0; $less_uint(i, TotalComponents); ++i) {
      Expr /*P*/ AssociatedExpr = Reader.Reader.ReadSubExpr();
      ValueDecl /*P*/ AssociatedDecl = Reader.Reader.<ValueDecl>ReadDeclAs(ValueDecl.class, Reader.F, Record, Idx);
      Components.push_back(new OMPClauseMappableExprCommon.MappableComponent(AssociatedExpr, AssociatedDecl));
    }
    C.setComponents(new ArrayRef<OMPClauseMappableExprCommon.MappableComponent>(Components, false), new ArrayRefUInt(ListSizes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2320,
   FQN="clang::OMPClauseReader::VisitOMPNumTeamsClause", NM="_ZN5clang15OMPClauseReader22VisitOMPNumTeamsClauseEPNS_17OMPNumTeamsClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader22VisitOMPNumTeamsClauseEPNS_17OMPNumTeamsClauseE")
  //</editor-fold>
  public void VisitOMPNumTeamsClause(OMPNumTeamsClause /*P*/ C) {
    C.setNumTeams(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2325,
   FQN="clang::OMPClauseReader::VisitOMPThreadLimitClause", NM="_ZN5clang15OMPClauseReader25VisitOMPThreadLimitClauseEPNS_20OMPThreadLimitClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader25VisitOMPThreadLimitClauseEPNS_20OMPThreadLimitClauseE")
  //</editor-fold>
  public void VisitOMPThreadLimitClause(OMPThreadLimitClause /*P*/ C) {
    C.setThreadLimit(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPPriorityClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2330,
   FQN="clang::OMPClauseReader::VisitOMPPriorityClause", NM="_ZN5clang15OMPClauseReader22VisitOMPPriorityClauseEPNS_17OMPPriorityClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader22VisitOMPPriorityClauseEPNS_17OMPPriorityClauseE")
  //</editor-fold>
  public void VisitOMPPriorityClause(OMPPriorityClause /*P*/ C) {
    C.setPriority(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2335,
   FQN="clang::OMPClauseReader::VisitOMPGrainsizeClause", NM="_ZN5clang15OMPClauseReader23VisitOMPGrainsizeClauseEPNS_18OMPGrainsizeClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader23VisitOMPGrainsizeClauseEPNS_18OMPGrainsizeClauseE")
  //</editor-fold>
  public void VisitOMPGrainsizeClause(OMPGrainsizeClause /*P*/ C) {
    C.setGrainsize(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPNogroupClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2046,
   FQN="clang::OMPClauseReader::VisitOMPNogroupClause", NM="_ZN5clang15OMPClauseReader21VisitOMPNogroupClauseEPNS_16OMPNogroupClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader21VisitOMPNogroupClauseEPNS_16OMPNogroupClauseE")
  //</editor-fold>
  public void VisitOMPNogroupClause(OMPNogroupClause /*P*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPNumTasksClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2340,
   FQN="clang::OMPClauseReader::VisitOMPNumTasksClause", NM="_ZN5clang15OMPClauseReader22VisitOMPNumTasksClauseEPNS_17OMPNumTasksClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader22VisitOMPNumTasksClauseEPNS_17OMPNumTasksClauseE")
  //</editor-fold>
  public void VisitOMPNumTasksClause(OMPNumTasksClause /*P*/ C) {
    C.setNumTasks(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPHintClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2345,
   FQN="clang::OMPClauseReader::VisitOMPHintClause", NM="_ZN5clang15OMPClauseReader18VisitOMPHintClauseEPNS_13OMPHintClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader18VisitOMPHintClauseEPNS_13OMPHintClauseE")
  //</editor-fold>
  public void VisitOMPHintClause(OMPHintClause /*P*/ C) {
    C.setHint(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2350,
   FQN="clang::OMPClauseReader::VisitOMPDistScheduleClause", NM="_ZN5clang15OMPClauseReader26VisitOMPDistScheduleClauseEPNS_21OMPDistScheduleClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader26VisitOMPDistScheduleClauseEPNS_21OMPDistScheduleClauseE")
  //</editor-fold>
  public void VisitOMPDistScheduleClause(OMPDistScheduleClause /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    C.setDistScheduleKind(((/*static_cast*//*OpenMPDistScheduleClauseKind*/int)(Record.$at$Const(Idx.$set$postInc()))));
    C.setChunkSize(Reader.Reader.ReadSubExpr());
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setDistScheduleKindLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setCommaLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPDefaultmapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2360,
   FQN="clang::OMPClauseReader::VisitOMPDefaultmapClause", NM="_ZN5clang15OMPClauseReader24VisitOMPDefaultmapClauseEPNS_19OMPDefaultmapClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader24VisitOMPDefaultmapClauseEPNS_19OMPDefaultmapClauseE")
  //</editor-fold>
  public void VisitOMPDefaultmapClause(OMPDefaultmapClause /*P*/ C) {
    C.setDefaultmapKind(((/*static_cast*//*OpenMPDefaultmapClauseKind*/int)(Record.$at$Const(Idx.$set$postInc()))));
    C.setDefaultmapModifier(((/*static_cast*//*OpenMPDefaultmapClauseModifier*/int)(Record.$at$Const(Idx.$set$postInc()))));
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setDefaultmapModifierLoc(Reader.ReadSourceLocation(Record, Idx));
    C.setDefaultmapKindLoc(Reader.ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPToClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2370,
   FQN="clang::OMPClauseReader::VisitOMPToClause", NM="_ZN5clang15OMPClauseReader16VisitOMPToClauseEPNS_11OMPToClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader16VisitOMPToClauseEPNS_11OMPToClauseE")
  //</editor-fold>
  public void VisitOMPToClause(OMPToClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    /*uint*/int UniqueDecls = C.getUniqueDeclarationsNum();
    /*uint*/int TotalLists = C.getTotalComponentListNum();
    /*uint*/int TotalComponents = C.getTotalComponentsNum();
    
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    
    SmallVector<ValueDecl /*P*/ > Decls/*J*/= new SmallVector<ValueDecl /*P*/ >(16, (ValueDecl /*P*/ )null);
    Decls.reserve(UniqueDecls);
    for (/*uint*/int i = 0; $less_uint(i, UniqueDecls); ++i)  {
      Decls.push_back(Reader.Reader.<ValueDecl>ReadDeclAs(ValueDecl.class, Reader.F, Record, Idx));
    }
    C.setUniqueDecls(new ArrayRef<ValueDecl /*P*/ >(Decls, true));
    
    SmallVectorUInt ListsPerDecl/*J*/= new SmallVectorUInt(16, 0);
    ListsPerDecl.reserve(UniqueDecls);
    for (/*uint*/int i = 0; $less_uint(i, UniqueDecls); ++i)  {
      ListsPerDecl.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    C.setDeclNumLists(new ArrayRefUInt(ListsPerDecl));
    
    SmallVectorUInt ListSizes/*J*/= new SmallVectorUInt(32, 0);
    ListSizes.reserve(TotalLists);
    for (/*uint*/int i = 0; $less_uint(i, TotalLists); ++i)  {
      ListSizes.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    C.setComponentListSizes(new ArrayRefUInt(ListSizes));
    
    SmallVector<OMPClauseMappableExprCommon.MappableComponent> Components/*J*/= new SmallVector<OMPClauseMappableExprCommon.MappableComponent>(32, new OMPClauseMappableExprCommon.MappableComponent());
    Components.reserve(TotalComponents);
    for (/*uint*/int i = 0; $less_uint(i, TotalComponents); ++i) {
      Expr /*P*/ AssociatedExpr = Reader.Reader.ReadSubExpr();
      ValueDecl /*P*/ AssociatedDecl = Reader.Reader.<ValueDecl>ReadDeclAs(ValueDecl.class, Reader.F, Record, Idx);
      Components.push_back(new OMPClauseMappableExprCommon.MappableComponent(AssociatedExpr, AssociatedDecl));
    }
    C.setComponents(new ArrayRef<OMPClauseMappableExprCommon.MappableComponent>(Components, false), new ArrayRefUInt(ListSizes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPFromClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2414,
   FQN="clang::OMPClauseReader::VisitOMPFromClause", NM="_ZN5clang15OMPClauseReader18VisitOMPFromClauseEPNS_13OMPFromClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader18VisitOMPFromClauseEPNS_13OMPFromClauseE")
  //</editor-fold>
  public void VisitOMPFromClause(OMPFromClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    /*uint*/int UniqueDecls = C.getUniqueDeclarationsNum();
    /*uint*/int TotalLists = C.getTotalComponentListNum();
    /*uint*/int TotalComponents = C.getTotalComponentsNum();
    
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    
    SmallVector<ValueDecl /*P*/ > Decls/*J*/= new SmallVector<ValueDecl /*P*/ >(16, (ValueDecl /*P*/ )null);
    Decls.reserve(UniqueDecls);
    for (/*uint*/int i = 0; $less_uint(i, UniqueDecls); ++i)  {
      Decls.push_back(Reader.Reader.<ValueDecl>ReadDeclAs(ValueDecl.class, Reader.F, Record, Idx));
    }
    C.setUniqueDecls(new ArrayRef<ValueDecl /*P*/ >(Decls, true));
    
    SmallVectorUInt ListsPerDecl/*J*/= new SmallVectorUInt(16, 0);
    ListsPerDecl.reserve(UniqueDecls);
    for (/*uint*/int i = 0; $less_uint(i, UniqueDecls); ++i)  {
      ListsPerDecl.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    C.setDeclNumLists(new ArrayRefUInt(ListsPerDecl));
    
    SmallVectorUInt ListSizes/*J*/= new SmallVectorUInt(32, 0);
    ListSizes.reserve(TotalLists);
    for (/*uint*/int i = 0; $less_uint(i, TotalLists); ++i)  {
      ListSizes.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    C.setComponentListSizes(new ArrayRefUInt(ListSizes));
    
    SmallVector<OMPClauseMappableExprCommon.MappableComponent> Components/*J*/= new SmallVector<OMPClauseMappableExprCommon.MappableComponent>(32, new OMPClauseMappableExprCommon.MappableComponent());
    Components.reserve(TotalComponents);
    for (/*uint*/int i = 0; $less_uint(i, TotalComponents); ++i) {
      Expr /*P*/ AssociatedExpr = Reader.Reader.ReadSubExpr();
      ValueDecl /*P*/ AssociatedDecl = Reader.Reader.<ValueDecl>ReadDeclAs(ValueDecl.class, Reader.F, Record, Idx);
      Components.push_back(new OMPClauseMappableExprCommon.MappableComponent(AssociatedExpr, AssociatedDecl));
    }
    C.setComponents(new ArrayRef<OMPClauseMappableExprCommon.MappableComponent>(Components, false), new ArrayRefUInt(ListSizes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2458,
   FQN="clang::OMPClauseReader::VisitOMPUseDevicePtrClause", NM="_ZN5clang15OMPClauseReader26VisitOMPUseDevicePtrClauseEPNS_21OMPUseDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader26VisitOMPUseDevicePtrClauseEPNS_21OMPUseDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPUseDevicePtrClause(OMPUseDevicePtrClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2469,
   FQN="clang::OMPClauseReader::VisitOMPIsDevicePtrClause", NM="_ZN5clang15OMPClauseReader25VisitOMPIsDevicePtrClauseEPNS_20OMPIsDevicePtrClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader25VisitOMPIsDevicePtrClauseEPNS_20OMPIsDevicePtrClauseE")
  //</editor-fold>
  public void VisitOMPIsDevicePtrClause(OMPIsDevicePtrClause /*P*/ C) {
    C.setLParenLoc(Reader.ReadSourceLocation(Record, Idx));
    /*uint*/int NumVars = C.varlist_size();
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    Vars.reserve(NumVars);
    for (/*uint*/int i = 0; i != NumVars; ++i)  {
      Vars.push_back(Reader.Reader.ReadSubExpr());
    }
    C.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars, true));
    Vars.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::readClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1782,
   FQN="clang::OMPClauseReader::readClause", NM="_ZN5clang15OMPClauseReader10readClauseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader10readClauseEv")
  //</editor-fold>
  public OMPClause /*P*/ readClause() {
    OMPClause /*P*/ C = null;
    switch (OpenMPClauseKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()))) {
     case OMPC_if:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPIfClause();
       });
      break;
     case OMPC_final:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPFinalClause();
       });
      break;
     case OMPC_num_threads:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPNumThreadsClause();
       });
      break;
     case OMPC_safelen:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPSafelenClause();
       });
      break;
     case OMPC_simdlen:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPSimdlenClause();
       });
      break;
     case OMPC_collapse:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPCollapseClause();
       });
      break;
     case OMPC_default:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPDefaultClause();
       });
      break;
     case OMPC_proc_bind:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPProcBindClause();
       });
      break;
     case OMPC_schedule:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPScheduleClause();
       });
      break;
     case OMPC_ordered:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPOrderedClause();
       });
      break;
     case OMPC_nowait:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPNowaitClause();
       });
      break;
     case OMPC_untied:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPUntiedClause();
       });
      break;
     case OMPC_mergeable:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPMergeableClause();
       });
      break;
     case OMPC_read:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPReadClause();
       });
      break;
     case OMPC_write:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPWriteClause();
       });
      break;
     case OMPC_update:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPUpdateClause();
       });
      break;
     case OMPC_capture:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPCaptureClause();
       });
      break;
     case OMPC_seq_cst:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPSeqCstClause();
       });
      break;
     case OMPC_threads:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPThreadsClause();
       });
      break;
     case OMPC_simd:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPSIMDClause();
       });
      break;
     case OMPC_nogroup:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPNogroupClause();
       });
      break;
     case OMPC_private:
      C = OMPPrivateClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_firstprivate:
      C = OMPFirstprivateClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_lastprivate:
      C = OMPLastprivateClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_shared:
      C = OMPSharedClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_reduction:
      C = OMPReductionClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_linear:
      C = OMPLinearClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_aligned:
      C = OMPAlignedClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_copyin:
      C = OMPCopyinClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_copyprivate:
      C = OMPCopyprivateClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_flush:
      C = OMPFlushClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_depend:
      C = OMPDependClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_device:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPDeviceClause();
       });
      break;
     case OMPC_map:
      {
        /*uint*/int NumVars = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumDeclarations = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumLists = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumComponents = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        C = OMPMapClause.CreateEmpty(Context, NumVars, NumDeclarations, NumLists, 
            NumComponents);
        break;
      }
     case OMPC_num_teams:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPNumTeamsClause();
       });
      break;
     case OMPC_thread_limit:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPThreadLimitClause();
       });
      break;
     case OMPC_priority:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPPriorityClause();
       });
      break;
     case OMPC_grainsize:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPGrainsizeClause();
       });
      break;
     case OMPC_num_tasks:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPNumTasksClause();
       });
      break;
     case OMPC_hint:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPHintClause();
       });
      break;
     case OMPC_dist_schedule:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPDistScheduleClause();
       });
      break;
     case OMPC_defaultmap:
      C = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
          return new OMPDefaultmapClause();
       });
      break;
     case OMPC_to:
      {
        /*uint*/int NumVars = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumDeclarations = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumLists = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumComponents = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        C = OMPToClause.CreateEmpty(Context, NumVars, NumDeclarations, NumLists, 
            NumComponents);
        break;
      }
     case OMPC_from:
      {
        /*uint*/int NumVars = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumDeclarations = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumLists = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        /*uint*/int NumComponents = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        C = OMPFromClause.CreateEmpty(Context, NumVars, NumDeclarations, NumLists, 
            NumComponents);
        break;
      }
     case OMPC_use_device_ptr:
      C = OMPUseDevicePtrClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
     case OMPC_is_device_ptr:
      C = OMPIsDevicePtrClause.CreateEmpty(Context, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      break;
    }
    Visit(C);
    C.setLocStart(Reader.ReadSourceLocation(Record, Idx));
    C.setLocEnd(Reader.ReadSourceLocation(Record, Idx));
    
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPClauseWithPreInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1949,
   FQN="clang::OMPClauseReader::VisitOMPClauseWithPreInit", NM="_ZN5clang15OMPClauseReader25VisitOMPClauseWithPreInitEPNS_20OMPClauseWithPreInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader25VisitOMPClauseWithPreInitEPNS_20OMPClauseWithPreInitE")
  //</editor-fold>
  public void VisitOMPClauseWithPreInit(OMPClauseWithPreInit /*P*/ C) {
    C.setPreInitStmt(Reader.Reader.ReadSubStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseReader::VisitOMPClauseWithPostUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1953,
   FQN="clang::OMPClauseReader::VisitOMPClauseWithPostUpdate", NM="_ZN5clang15OMPClauseReader28VisitOMPClauseWithPostUpdateEPNS_23OMPClauseWithPostUpdateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang15OMPClauseReader28VisitOMPClauseWithPostUpdateEPNS_23OMPClauseWithPostUpdateE")
  //</editor-fold>
  public void VisitOMPClauseWithPostUpdate(OMPClauseWithPostUpdate /*P*/ C) {
    VisitOMPClauseWithPreInit(C);
    C.setPostUpdateExpr(Reader.Reader.ReadSubExpr());
  }

  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Idx=" + Idx // NOI18N
              + super.toString(); // NOI18N
  }
}
