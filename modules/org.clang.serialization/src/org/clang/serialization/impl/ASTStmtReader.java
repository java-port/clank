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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.llvm.bitcode.*;
import org.clang.serialization.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.lex.llvm.ArrayRefToken;
import org.clang.lex.llvm.SmallVectorToken;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 27,
 FQN="clang::ASTStmtReader", NM="_ZN5clang13ASTStmtReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReaderE")
//</editor-fold>
public class ASTStmtReader implements /*public*/ StmtVisitorVoid<ASTStmtReader> {
  /*friend  class OMPClauseReader*/
  // JAVA: typedef ASTReader::RecordData RecordData
//  public final class RecordData extends SmallVectorULong{ };
  
  /*friend*/public final ASTReader /*&*/ Reader;
  /*friend*/public final ModuleFile /*&*/ F;
  private final BitstreamCursor /*&*/ DeclsCursor;
  private final /*const*/SmallVectorULong /*&*/ Record;
  private final uint$ref/*uint &*/ Idx;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 37,
   FQN="clang::ASTStmtReader::ReadToken", NM="_ZN5clang13ASTStmtReader9ReadTokenERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader9ReadTokenERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private Token ReadToken(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadToken(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 41,
   FQN="clang::ASTStmtReader::ReadSourceLocation", NM="_ZN5clang13ASTStmtReader18ReadSourceLocationERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18ReadSourceLocationERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  /*friend*/public SourceLocation ReadSourceLocation(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadSourceLocation(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 45,
   FQN="clang::ASTStmtReader::ReadSourceRange", NM="_ZN5clang13ASTStmtReader15ReadSourceRangeERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15ReadSourceRangeERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private SourceRange ReadSourceRange(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadSourceRange(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 49,
   FQN="clang::ASTStmtReader::ReadString", NM="_ZN5clang13ASTStmtReader10ReadStringERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader10ReadStringERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private std.string ReadString(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadString(R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::GetTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 53,
   FQN="clang::ASTStmtReader::GetTypeSourceInfo", NM="_ZN5clang13ASTStmtReader17GetTypeSourceInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17GetTypeSourceInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private TypeSourceInfo /*P*/ GetTypeSourceInfo(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.GetTypeSourceInfo(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadDeclID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 57,
   FQN="clang::ASTStmtReader::ReadDeclID", NM="_ZN5clang13ASTStmtReader10ReadDeclIDERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader10ReadDeclIDERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private /*uint32_t*/int ReadDeclID(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadDeclID(F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 61,
   FQN="clang::ASTStmtReader::ReadDecl", NM="_ZN5clang13ASTStmtReader8ReadDeclERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader8ReadDeclERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private Decl /*P*/ ReadDecl(final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.ReadDecl(F, R, I);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadDeclAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 66,
   FQN="clang::ASTStmtReader::ReadDeclAs", NM="Tpl__ZN5clang13ASTStmtReader10ReadDeclAsERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=Tpl__ZN5clang13ASTStmtReader10ReadDeclAsERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private </*typename*/ T> T /*P*/ ReadDeclAs(Class<T> cls, final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return Reader.<T>ReadDeclAs(cls, F, R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadDeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 70,
   FQN="clang::ASTStmtReader::ReadDeclarationNameLoc", NM="_ZN5clang13ASTStmtReader22ReadDeclarationNameLocERNS_18DeclarationNameLocENS_15DeclarationNameERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22ReadDeclarationNameLocERNS_18DeclarationNameLocENS_15DeclarationNameERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  private void ReadDeclarationNameLoc(final DeclarationNameLoc /*&*/ DNLoc, DeclarationName Name, 
                        final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    Reader.ReadDeclarationNameLoc(F, DNLoc, new DeclarationName(Name), R, I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadDeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 75,
   FQN="clang::ASTStmtReader::ReadDeclarationNameInfo", NM="_ZN5clang13ASTStmtReader23ReadDeclarationNameInfoERNS_19DeclarationNameInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23ReadDeclarationNameInfoERNS_19DeclarationNameInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  /*friend*/public void ReadDeclarationNameInfo(final DeclarationNameInfo /*&*/ NameInfo, 
                         final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    Reader.ReadDeclarationNameInfo(F, NameInfo, R, I);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ASTStmtReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 81,
   FQN="clang::ASTStmtReader::ASTStmtReader", NM="_ZN5clang13ASTStmtReaderC1ERNS_9ASTReaderERNS_13serialization10ModuleFileERN4llvm15BitstreamCursorERKNS6_11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReaderC1ERNS_9ASTReaderERNS_13serialization10ModuleFileERN4llvm15BitstreamCursorERKNS6_11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public ASTStmtReader(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ F, 
      final BitstreamCursor /*&*/ Cursor, 
      final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    // : StmtVisitor<ASTStmtReader>(), Reader(Reader), F(F), DeclsCursor(Cursor), Record(Record), Idx(Idx) 
    //START JInit
    $StmtVisitor();
    this./*&*/Reader=/*&*/Reader;
    this./*&*/F=/*&*/F;
    this./*&*/DeclsCursor=/*&*/Cursor;
    this./*&*/Record=/*&*/Record;
    this./*&*/Idx=/*&*/Idx;
    //END JInit
  }

  
  /// \brief The number of record fields required for the Stmt class
  /// itself.
  public static /*const*//*uint*/int NumStmtFields = 0;
  
  /// \brief The number of record fields required for the Expr class
  /// itself.
  public static /*const*//*uint*/int NumExprFields = NumStmtFields + 7;
  
  /// \brief Read and initialize a ExplicitTemplateArgumentList structure.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadTemplateKWAndArgsInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 109,
   FQN="clang::ASTStmtReader::ReadTemplateKWAndArgsInfo", NM="_ZN5clang13ASTStmtReader25ReadTemplateKWAndArgsInfoERNS_24ASTTemplateKWAndArgsInfoEPNS_19TemplateArgumentLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25ReadTemplateKWAndArgsInfoERNS_24ASTTemplateKWAndArgsInfoEPNS_19TemplateArgumentLocEj")
  //</editor-fold>
  public void ReadTemplateKWAndArgsInfo(final ASTTemplateKWAndArgsInfo /*&*/ Args, 
                           type$ptr<TemplateArgumentLoc /*P*/> ArgsLocArray, 
                           /*uint*/int NumTemplateArgs) {
    TemplateArgumentListInfo ArgInfo = null;
    try {
      SourceLocation TemplateKWLoc = ReadSourceLocation(Record, Idx);
      ArgInfo/*J*/= new TemplateArgumentListInfo();
      ArgInfo.setLAngleLoc(ReadSourceLocation(Record, Idx));
      ArgInfo.setRAngleLoc(ReadSourceLocation(Record, Idx));
      for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
        ArgInfo.addArgument(Reader.ReadTemplateArgumentLoc(F, Record, Idx));
      }
      Args.initializeFrom(new SourceLocation(TemplateKWLoc), ArgInfo, ArgsLocArray);
    } finally {
      if (ArgInfo != null) { ArgInfo.$destroy(); }
    }
  }

  /// \brief Read and initialize a ExplicitTemplateArgumentList structure.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::ReadExplicitTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 99,
   FQN="clang::ASTStmtReader::ReadExplicitTemplateArgumentList", NM="_ZN5clang13ASTStmtReader32ReadExplicitTemplateArgumentListERNS_27ASTTemplateArgumentListInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader32ReadExplicitTemplateArgumentListERNS_27ASTTemplateArgumentListInfoEj")
  //</editor-fold>
  public void ReadExplicitTemplateArgumentList(final ASTTemplateArgumentListInfo /*&*/ ArgList, 
                                  /*uint*/int NumTemplateArgs) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 122,
   FQN="clang::ASTStmtReader::VisitStmt", NM="_ZN5clang13ASTStmtReader9VisitStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader9VisitStmtEPNS_4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    assert (Idx.$deref() == NumStmtFields) : "Incorrect statement field count";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 303,
   FQN="clang::ASTStmtReader::VisitAsmStmt", NM="_ZN5clang13ASTStmtReader12VisitAsmStmtEPNS_7AsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader12VisitAsmStmtEPNS_7AsmStmtE")
  //</editor-fold>
  public void VisitAsmStmt(AsmStmt /*P*/ S) {
    VisitStmt(S);
    S.NumOutputs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    S.NumInputs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    S.NumClobbers = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    S.setAsmLoc(ReadSourceLocation(Record, Idx));
    S.setVolatile((Record.$at$Const(Idx.$set$postInc()) != 0));
    S.setSimple((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 313,
   FQN="clang::ASTStmtReader::VisitGCCAsmStmt", NM="_ZN5clang13ASTStmtReader15VisitGCCAsmStmtEPNS_10GCCAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitGCCAsmStmtEPNS_10GCCAsmStmtE")
  //</editor-fold>
  public void VisitGCCAsmStmt(GCCAsmStmt /*P*/ S) {
    VisitAsmStmt(S);
    S.setRParenLoc(ReadSourceLocation(Record, Idx));
    S.setAsmString(cast_or_null_StringLiteral(Reader.ReadSubStmt()));
    
    /*uint*/int NumOutputs = S.getNumOutputs();
    /*uint*/int NumInputs = S.getNumInputs();
    /*uint*/int NumClobbers = S.getNumClobbers();
    
    // Outputs and inputs
    SmallVector<IdentifierInfo /*P*/> Names/*J*/= new SmallVector<IdentifierInfo /*P*/>(16, (IdentifierInfo /*P*/)null);
    SmallVector<StringLiteral /*P*/ > Constraints/*J*/= new SmallVector<StringLiteral /*P*/ >(16, (StringLiteral /*P*/ )null);
    SmallVector<Stmt /*P*/ > Exprs/*J*/= new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    for (/*uint*/int I = 0, N = NumOutputs + NumInputs; I != N; ++I) {
      Names.push_back(Reader.GetIdentifierInfo(F, Record, Idx));
      Constraints.push_back(cast_or_null_StringLiteral(Reader.ReadSubStmt()));
      Exprs.push_back(Reader.ReadSubStmt());
    }
    
    // Constraints
    SmallVector<StringLiteral /*P*/ > Clobbers/*J*/= new SmallVector<StringLiteral /*P*/ >(16, (StringLiteral /*P*/ )null);
    for (/*uint*/int I = 0; I != NumClobbers; ++I)  {
      Clobbers.push_back(cast_or_null_StringLiteral(Reader.ReadSubStmt()));
    }
    
    S.setOutputsAndInputsAndClobbers(Reader.getContext(), 
        Names.data(), Constraints.data(), 
        Exprs.data(), NumOutputs, NumInputs, 
        Clobbers.data(), NumClobbers);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitMSAsmStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 343,
   FQN="clang::ASTStmtReader::VisitMSAsmStmt", NM="_ZN5clang13ASTStmtReader14VisitMSAsmStmtEPNS_9MSAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitMSAsmStmtEPNS_9MSAsmStmtE")
  //</editor-fold>
  public void VisitMSAsmStmt(MSAsmStmt /*P*/ S) {
    VisitAsmStmt(S);
    S.LBraceLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.EndLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.NumAsmToks = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    std.string AsmStr = ReadString(Record, Idx);
    
    // Read the tokens.
    SmallVectorToken AsmToks/*J*/= new SmallVectorToken(16, /*new Token()*/(Token)null);
    AsmToks.reserve(S.NumAsmToks);
    for (/*uint*/int i = 0, e = S.NumAsmToks; i != e; ++i) {
      AsmToks.push_back(ReadToken(Record, Idx));
    }
    
    // The calls to reserve() for the FooData vectors are mandatory to
    // prevent dead StringRefs in the Foo vectors.
    
    // Read the clobbers.
    SmallVector<std.string> ClobbersData/*J*/= new SmallVector<std.string>(16, new std.string());
    SmallVector<StringRef> Clobbers/*J*/= new SmallVector<StringRef>(16, new StringRef());
    ClobbersData.reserve(S.NumClobbers);
    Clobbers.reserve(S.NumClobbers);
    for (/*uint*/int i = 0, e = S.NumClobbers; i != e; ++i) {
      ClobbersData.push_back_T$RR(ReadString(Record, Idx));
      Clobbers.push_back(new StringRef(ClobbersData.back()));
    }
    
    // Read the operands.
    /*uint*/int NumOperands = S.NumOutputs + S.NumInputs;
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    SmallVector<std.string> ConstraintsData/*J*/= new SmallVector<std.string>(16, new std.string());
    SmallVector<StringRef> Constraints/*J*/= new SmallVector<StringRef>(16, new StringRef());
    Exprs.reserve(NumOperands);
    ConstraintsData.reserve(NumOperands);
    Constraints.reserve(NumOperands);
    for (/*uint*/int i = 0; i != NumOperands; ++i) {
      Exprs.push_back(cast_Expr(Reader.ReadSubStmt()));
      ConstraintsData.push_back_T$RR(ReadString(Record, Idx));
      Constraints.push_back(new StringRef(ConstraintsData.back()));
    }
    
    S.initialize(Reader.getContext(), new StringRef(AsmStr), new ArrayRefToken(AsmToks, false), 
        new ArrayRef<StringRef>(Constraints, false), new ArrayRef<Expr /*P*/ >(Exprs, true), new ArrayRef<StringRef>(Clobbers, false));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 172,
   FQN="clang::ASTStmtReader::VisitAttributedStmt", NM="_ZN5clang13ASTStmtReader19VisitAttributedStmtEPNS_14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitAttributedStmtEPNS_14AttributedStmtE")
  //</editor-fold>
  public void VisitAttributedStmt(AttributedStmt /*P*/ S) {
    VisitStmt(S);
    long/*uint64_t*/ NumAttrs = Record.$at$Const(Idx.$set$postInc());
    SmallVector<Attr /*P*/> Attrs/*J*/= new SmallVector<Attr /*P*/>(4, null);
    Reader.ReadAttributes(F, Attrs, Record, Idx);
    ///*J:(void)*/NumAttrs;
    assert (NumAttrs == $uint2ullong(S.NumAttrs));
    assert (NumAttrs == $uint2ullong(Attrs.size()));
    std.copy(Attrs.begin(), Attrs.end(), S.getAttrArrayPtr());
    S.SubStmt = Reader.ReadSubStmt();
    S.AttrLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 272,
   FQN="clang::ASTStmtReader::VisitBreakStmt", NM="_ZN5clang13ASTStmtReader14VisitBreakStmtEPNS_9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitBreakStmtEPNS_9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(BreakStmt /*P*/ S) {
    VisitStmt(S);
    S.setBreakLoc(ReadSourceLocation(Record, Idx));
  }

  
  //===----------------------------------------------------------------------===//
  // C++ Expressions and Statements
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1197,
   FQN="clang::ASTStmtReader::VisitCXXCatchStmt", NM="_ZN5clang13ASTStmtReader17VisitCXXCatchStmtEPNS_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitCXXCatchStmtEPNS_12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(CXXCatchStmt /*P*/ S) {
    VisitStmt(S);
    S.CatchLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.ExceptionDecl = this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx);
    S.HandlerBlock = Reader.ReadSubStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1214,
   FQN="clang::ASTStmtReader::VisitCXXForRangeStmt", NM="_ZN5clang13ASTStmtReader20VisitCXXForRangeStmtEPNS_15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitCXXForRangeStmtEPNS_15CXXForRangeStmtE")
  //</editor-fold>
  public void VisitCXXForRangeStmt(CXXForRangeStmt /*P*/ S) {
    VisitStmt(S);
    S.ForLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.CoawaitLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.ColonLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.setRangeStmt(Reader.ReadSubStmt());
    S.setBeginStmt(Reader.ReadSubStmt());
    S.setEndStmt(Reader.ReadSubStmt());
    S.setCond(Reader.ReadSubExpr());
    S.setInc(Reader.ReadSubExpr());
    S.setLoopVarStmt(Reader.ReadSubStmt());
    S.setBody(Reader.ReadSubStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1204,
   FQN="clang::ASTStmtReader::VisitCXXTryStmt", NM="_ZN5clang13ASTStmtReader15VisitCXXTryStmtEPNS_10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitCXXTryStmtEPNS_10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(CXXTryStmt /*P*/ S) {
    VisitStmt(S);
    assert (Record.$at$Const(Idx.$deref()) == $uint2ullong(S.getNumHandlers())) : "NumStmtFields is wrong ?";
    Idx.$set$preInc();
    S.TryLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.getStmts().$set(0, Reader.ReadSubStmt());
    for (/*uint*/int i = 0, e = S.getNumHandlers(); i != e; ++i)  {
      S.getStmts().$set(i + 1, Reader.ReadSubStmt());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCapturedStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 408,
   FQN="clang::ASTStmtReader::VisitCapturedStmt", NM="_ZN5clang13ASTStmtReader17VisitCapturedStmtEPNS_12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitCapturedStmtEPNS_12CapturedStmtE")
  //</editor-fold>
  public void VisitCapturedStmt(CapturedStmt /*P*/ S) {
    VisitStmt(S);
    Idx.$set$preInc();
    S.setCapturedDecl(this.<CapturedDecl>ReadDeclAs(CapturedDecl.class, Record, Idx));
    S.setCapturedRegionKind(/*static_cast*/CapturedRegionKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    S.setCapturedRecordDecl(this.<RecordDecl>ReadDeclAs(RecordDecl.class, Record, Idx));
    
    // Capture inits
    for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(S.capture_init_begin()), 
        /*P*/ /*P*/ E = $tryClone(S.capture_init_end());
         $noteq_ptr(I, E); I.$preInc())  {
      I.$set(Reader.ReadSubExpr());
    }
    
    // Body
    S.setCapturedStmt(Reader.ReadSubStmt());
    S.getCapturedDecl().setBody(S.getCapturedStmt());
    
    // Captures
    for (final CapturedStmt.Capture /*&*/ I : S.captures()) {
      I.VarAndKind.setPointer(this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
      I.VarAndKind.
          setInt(/*static_cast*/CapturedStmt.VariableCaptureKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
      I.Loc.$assignMove(ReadSourceLocation(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 132,
   FQN="clang::ASTStmtReader::VisitCompoundStmt", NM="_ZN5clang13ASTStmtReader17VisitCompoundStmtEPNS_12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitCompoundStmtEPNS_12CompoundStmtE")
  //</editor-fold>
  public void VisitCompoundStmt(CompoundStmt /*P*/ S) {
    VisitStmt(S);
    SmallVector<Stmt /*P*/ > Stmts/*J*/= new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    /*uint*/int NumStmts = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    while (((NumStmts--) != 0)) {
      Stmts.push_back(Reader.ReadSubStmt());
    }
    S.setStmts(Reader.getContext(), new ArrayRef<Stmt /*P*/ >(Stmts, true));
    S.LBraceLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.RBraceLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 267,
   FQN="clang::ASTStmtReader::VisitContinueStmt", NM="_ZN5clang13ASTStmtReader17VisitContinueStmtEPNS_12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitContinueStmtEPNS_12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(ContinueStmt /*P*/ S) {
    VisitStmt(S);
    S.setContinueLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCoreturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 393,
   FQN="clang::ASTStmtReader::VisitCoreturnStmt", NM="_ZN5clang13ASTStmtReader17VisitCoreturnStmtEPNS_12CoreturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitCoreturnStmtEPNS_12CoreturnStmtE")
  //</editor-fold>
  public void VisitCoreturnStmt(CoreturnStmt /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCoroutineBodyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 388,
   FQN="clang::ASTStmtReader::VisitCoroutineBodyStmt", NM="_ZN5clang13ASTStmtReader22VisitCoroutineBodyStmtEPNS_17CoroutineBodyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitCoroutineBodyStmtEPNS_17CoroutineBodyStmtE")
  //</editor-fold>
  public void VisitCoroutineBodyStmt(CoroutineBodyStmt /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 284,
   FQN="clang::ASTStmtReader::VisitDeclStmt", NM="_ZN5clang13ASTStmtReader13VisitDeclStmtEPNS_8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitDeclStmtEPNS_8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ S) {
    VisitStmt(S);
    S.setStartLoc(ReadSourceLocation(Record, Idx));
    S.setEndLoc(ReadSourceLocation(Record, Idx));
    if (Idx.$deref() + 1 == Record.size()) {
      // Single declaration
      S.setDeclGroup(new DeclGroupRef(ReadDecl(Record, Idx)));
    } else {
      SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(16, null);
      Decls.reserve(Record.size() - Idx.$deref());
      for (/*uint*/int N = Record.size(); Idx.$deref() != N;)  {
        Decls.push_back(ReadDecl(Record, Idx));
      }
      S.setDeclGroup(new DeclGroupRef(DeclGroup.Create(Reader.getContext(), 
                  Decls.data(), 
                  Decls.size())));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 231,
   FQN="clang::ASTStmtReader::VisitDoStmt", NM="_ZN5clang13ASTStmtReader11VisitDoStmtEPNS_6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader11VisitDoStmtEPNS_6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(DoStmt /*P*/ S) {
    VisitStmt(S);
    S.setCond(Reader.ReadSubExpr());
    S.setBody(Reader.ReadSubStmt());
    S.setDoLoc(ReadSourceLocation(Record, Idx));
    S.setWhileLoc(ReadSourceLocation(Record, Idx));
    S.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 434,
   FQN="clang::ASTStmtReader::VisitExpr", NM="_ZN5clang13ASTStmtReader9VisitExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader9VisitExprEPNS_4ExprE")
  //</editor-fold>
  public void VisitExpr(Expr /*P*/ E) {
    VisitStmt(E);
    E.setType(Reader.readType(F, Record, Idx));
    E.setTypeDependent((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setValueDependent((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setInstantiationDependent((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.setValueKind(/*static_cast*/ExprValueKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    E.setObjectKind(/*static_cast*/ExprObjectKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    assert (Idx.$deref() == NumExprFields) : "Incorrect expression field count";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 119,
   FQN="clang::ASTStmtReader::VisitAbstractConditionalOperator", NM="_ZN5clang13ASTStmtReader32VisitAbstractConditionalOperatorEPNS_27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader32VisitAbstractConditionalOperatorEPNS_27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(AbstractConditionalOperator /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 705,
   FQN="clang::ASTStmtReader::VisitBinaryConditionalOperator", NM="_ZN5clang13ASTStmtReader30VisitBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader30VisitBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE")
  //</editor-fold>
  public void VisitBinaryConditionalOperator(BinaryConditionalOperator /*P*/ E) {
    VisitExpr(E);
    E.OpaqueValue = cast_OpaqueValueExpr(Reader.ReadSubExpr());
    E.SubExprs[BinaryConditionalOperator.Unnamed_enum.COMMON.getValue()] = Reader.ReadSubExpr();
    E.SubExprs[BinaryConditionalOperator.Unnamed_enum.COND.getValue()] = Reader.ReadSubExpr();
    E.SubExprs[BinaryConditionalOperator.Unnamed_enum.LHS.getValue()] = Reader.ReadSubExpr();
    E.SubExprs[BinaryConditionalOperator.Unnamed_enum.RHS.getValue()] = Reader.ReadSubExpr();
    E.QuestionLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.ColonLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 696,
   FQN="clang::ASTStmtReader::VisitConditionalOperator", NM="_ZN5clang13ASTStmtReader24VisitConditionalOperatorEPNS_19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitConditionalOperatorEPNS_19ConditionalOperatorE")
  //</editor-fold>
  public void VisitConditionalOperator(ConditionalOperator /*P*/ E) {
    VisitExpr(E);
    E.SubExprs[ConditionalOperator.Unnamed_enum.COND.getValue()] = Reader.ReadSubExpr();
    E.SubExprs[ConditionalOperator.Unnamed_enum.LHS.getValue()] = Reader.ReadSubExpr();
    E.SubExprs[ConditionalOperator.Unnamed_enum.RHS.getValue()] = Reader.ReadSubExpr();
    E.QuestionLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.ColonLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 861,
   FQN="clang::ASTStmtReader::VisitAddrLabelExpr", NM="_ZN5clang13ASTStmtReader18VisitAddrLabelExprEPNS_13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitAddrLabelExprEPNS_13AddrLabelExprE")
  //</editor-fold>
  public void VisitAddrLabelExpr(AddrLabelExpr /*P*/ E) {
    VisitExpr(E);
    E.setAmpAmpLoc(ReadSourceLocation(Record, Idx));
    E.setLabelLoc(ReadSourceLocation(Record, Idx));
    E.setLabel(this.<LabelDecl>ReadDeclAs(LabelDecl.class, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 610,
   FQN="clang::ASTStmtReader::VisitArraySubscriptExpr", NM="_ZN5clang13ASTStmtReader23VisitArraySubscriptExprEPNS_18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitArraySubscriptExprEPNS_18ArraySubscriptExprE")
  //</editor-fold>
  public void VisitArraySubscriptExpr(ArraySubscriptExpr /*P*/ E) {
    VisitExpr(E);
    E.setLHS(Reader.ReadSubExpr());
    E.setRHS(Reader.ReadSubExpr());
    E.setRBracketLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1570,
   FQN="clang::ASTStmtReader::VisitArrayTypeTraitExpr", NM="_ZN5clang13ASTStmtReader23VisitArrayTypeTraitExprEPNS_18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitArrayTypeTraitExprEPNS_18ArrayTypeTraitExprE")
  //</editor-fold>
  public void VisitArrayTypeTraitExpr(ArrayTypeTraitExpr /*P*/ E) {
    VisitExpr(E);
    E.ATT = $uint2uint_2bits(ArrayTypeTrait.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue());
    E.Value = $uint2ulong((/*uint*/int)$ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    SourceRange Range = ReadSourceRange(Record, Idx);
    E.Loc.$assignMove(Range.getBegin());
    E.RParen.$assignMove(Range.getEnd());
    E.QueriedType = GetTypeSourceInfo(Record, Idx);
  }

  
  //===----------------------------------------------------------------------===//
  // OpenCL Expressions and Statements.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitAsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1753,
   FQN="clang::ASTStmtReader::VisitAsTypeExpr", NM="_ZN5clang13ASTStmtReader15VisitAsTypeExprEPNS_10AsTypeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitAsTypeExprEPNS_10AsTypeExprE")
  //</editor-fold>
  public void VisitAsTypeExpr(AsTypeExpr /*P*/ E) {
    VisitExpr(E);
    E.BuiltinLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.SrcExpr = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 949,
   FQN="clang::ASTStmtReader::VisitAtomicExpr", NM="_ZN5clang13ASTStmtReader15VisitAtomicExprEPNS_10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitAtomicExprEPNS_10AtomicExprE")
  //</editor-fold>
  public void VisitAtomicExpr(AtomicExpr /*P*/ E) {
    VisitExpr(E);
    E.Op = AtomicExpr.AtomicOp.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    E.NumSubExprs = AtomicExpr.getNumSubExprs(E.Op);
    for (/*uint*/int I = 0; I != E.NumSubExprs; ++I)  {
      E.SubExprs[I] = Reader.ReadSubExpr();
    }
    E.BuiltinLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 681,
   FQN="clang::ASTStmtReader::VisitBinaryOperator", NM="_ZN5clang13ASTStmtReader19VisitBinaryOperatorEPNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitBinaryOperatorEPNS_14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ E) {
    VisitExpr(E);
    E.setLHS(Reader.ReadSubExpr());
    E.setRHS(Reader.ReadSubExpr());
    E.setOpcode(BinaryOperatorKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    E.setOperatorLoc(ReadSourceLocation(Record, Idx));
    E.setFPContractable((boolean)(Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 690,
   FQN="clang::ASTStmtReader::VisitCompoundAssignOperator", NM="_ZN5clang13ASTStmtReader27VisitCompoundAssignOperatorEPNS_22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitCompoundAssignOperatorEPNS_22CompoundAssignOperatorE")
  //</editor-fold>
  public void VisitCompoundAssignOperator(CompoundAssignOperator /*P*/ E) {
    VisitBinaryOperator(E);
    E.setComputationLHSType(Reader.readType(F, Record, Idx));
    E.setComputationResultType(Reader.readType(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 909,
   FQN="clang::ASTStmtReader::VisitBlockExpr", NM="_ZN5clang13ASTStmtReader14VisitBlockExprEPNS_9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitBlockExprEPNS_9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ E) {
    VisitExpr(E);
    E.setBlockDecl(this.<BlockDecl>ReadDeclAs(BlockDecl.class, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1397,
   FQN="clang::ASTStmtReader::VisitCXXBindTemporaryExpr", NM="_ZN5clang13ASTStmtReader25VisitCXXBindTemporaryExprEPNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitCXXBindTemporaryExprEPNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ E) {
    VisitExpr(E);
    E.setTemporary(Reader.ReadCXXTemporary(F, Record, Idx));
    E.setSubExpr(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1348,
   FQN="clang::ASTStmtReader::VisitCXXBoolLiteralExpr", NM="_ZN5clang13ASTStmtReader23VisitCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE")
  //</editor-fold>
  public void VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr /*P*/ E) {
    VisitExpr(E);
    E.setValue((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setLocation(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1245,
   FQN="clang::ASTStmtReader::VisitCXXConstructExpr", NM="_ZN5clang13ASTStmtReader21VisitCXXConstructExprEPNS_16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitCXXConstructExprEPNS_16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    VisitExpr(E);
    E.NumArgs = $uint2uint_16bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    if (($16bits_uint2uint(E.NumArgs) != 0)) {
      E.Args = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (Reader.getContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Stmt /*P*/ [$16bits_uint2uint(E.NumArgs)]);
    }
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I)  {
      E.setArg(I, Reader.ReadSubExpr());
    }
    E.setConstructor(this.<CXXConstructorDecl>ReadDeclAs(CXXConstructorDecl.class, Record, Idx));
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.setElidable((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setHadMultipleCandidates((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setListInitialization((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setStdInitListInitialization((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setRequiresZeroInitialization((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setConstructionKind(CXXConstructExpr.ConstructionKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    E.ParenOrBraceRange.$assignMove(ReadSourceRange(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXTemporaryObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1271,
   FQN="clang::ASTStmtReader::VisitCXXTemporaryObjectExpr", NM="_ZN5clang13ASTStmtReader27VisitCXXTemporaryObjectExprEPNS_22CXXTemporaryObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitCXXTemporaryObjectExprEPNS_22CXXTemporaryObjectExprE")
  //</editor-fold>
  public void VisitCXXTemporaryObjectExpr(CXXTemporaryObjectExpr /*P*/ E) {
    VisitCXXConstructExpr(E);
    E.Type = GetTypeSourceInfo(Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1385,
   FQN="clang::ASTStmtReader::VisitCXXDefaultArgExpr", NM="_ZN5clang13ASTStmtReader22VisitCXXDefaultArgExprEPNS_17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitCXXDefaultArgExprEPNS_17CXXDefaultArgExprE")
  //</editor-fold>
  public void VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ E) {
    VisitExpr(E);
    E.Param = this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx);
    E.Loc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1391,
   FQN="clang::ASTStmtReader::VisitCXXDefaultInitExpr", NM="_ZN5clang13ASTStmtReader23VisitCXXDefaultInitExprEPNS_18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitCXXDefaultInitExprEPNS_18CXXDefaultInitExprE")
  //</editor-fold>
  public void VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ E) {
    VisitExpr(E);
    E.Field = this.<FieldDecl>ReadDeclAs(FieldDecl.class, Record, Idx);
    E.Loc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1432,
   FQN="clang::ASTStmtReader::VisitCXXDeleteExpr", NM="_ZN5clang13ASTStmtReader18VisitCXXDeleteExprEPNS_13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitCXXDeleteExprEPNS_13CXXDeleteExprE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(CXXDeleteExpr /*P*/ E) {
    VisitExpr(E);
    E.GlobalDelete = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
    E.ArrayForm = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
    E.ArrayFormAsWritten = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
    E.UsualArrayDeleteWantsSize = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
    E.OperatorDelete = this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, Record, Idx);
    E.Argument = Reader.ReadSubExpr();
    E.Loc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1474,
   FQN="clang::ASTStmtReader::VisitCXXDependentScopeMemberExpr", NM="_ZN5clang13ASTStmtReader32VisitCXXDependentScopeMemberExprEPNS_27CXXDependentScopeMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader32VisitCXXDependentScopeMemberExprEPNS_27CXXDependentScopeMemberExprE")
  //</editor-fold>
  public void VisitCXXDependentScopeMemberExpr(CXXDependentScopeMemberExpr /*P*/ E) {
    VisitExpr(E);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // HasTemplateKWAndArgsInfo
      ReadTemplateKWAndArgsInfo($Deref(E.getTrailingObjects(ASTTemplateKWAndArgsInfo.class)), 
          E.getTrailingObjects(TemplateArgumentLoc.class), 
          /*NumTemplateArgs=*/ $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    
    E.Base = Reader.ReadSubExpr();
    E.BaseType.$assignMove(Reader.readType(F, Record, Idx));
    E.IsArrow = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
    E.OperatorLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    E.FirstQualifierFoundInScope = this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx);
    ReadDeclarationNameInfo(E.MemberNameInfo, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXFoldExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1661,
   FQN="clang::ASTStmtReader::VisitCXXFoldExpr", NM="_ZN5clang13ASTStmtReader16VisitCXXFoldExprEPNS_11CXXFoldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitCXXFoldExprEPNS_11CXXFoldExprE")
  //</editor-fold>
  public void VisitCXXFoldExpr(CXXFoldExpr /*P*/ E) {
    VisitExpr(E);
    E.LParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.EllipsisLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.SubExprs[0] = Reader.ReadSubExpr();
    E.SubExprs[1] = Reader.ReadSubExpr();
    E.Opcode = BinaryOperatorKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXInheritedCtorInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1263,
   FQN="clang::ASTStmtReader::VisitCXXInheritedCtorInitExpr", NM="_ZN5clang13ASTStmtReader29VisitCXXInheritedCtorInitExprEPNS_24CXXInheritedCtorInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader29VisitCXXInheritedCtorInitExprEPNS_24CXXInheritedCtorInitExprE")
  //</editor-fold>
  public void VisitCXXInheritedCtorInitExpr(CXXInheritedCtorInitExpr /*P*/ E) {
    VisitExpr(E);
    E.Constructor = this.<CXXConstructorDecl>ReadDeclAs(CXXConstructorDecl.class, Record, Idx);
    E.Loc.$assignMove(ReadSourceLocation(Record, Idx));
    E.ConstructsVirtualBase = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.InheritedFromVirtualBase = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1409,
   FQN="clang::ASTStmtReader::VisitCXXNewExpr", NM="_ZN5clang13ASTStmtReader15VisitCXXNewExprEPNS_10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitCXXNewExprEPNS_10CXXNewExprE")
  //</editor-fold>
  public void VisitCXXNewExpr(CXXNewExpr /*P*/ E) {
    VisitExpr(E);
    E.GlobalNew = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    boolean isArray = (Record.$at$Const(Idx.$set$postInc()) != 0);
    E.UsualArrayDeleteWantsSize = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    /*uint*/int NumPlacementArgs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.StoredInitializationStyle = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.setOperatorNew(this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, Record, Idx));
    E.setOperatorDelete(this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, Record, Idx));
    E.AllocatedTypeInfo = GetTypeSourceInfo(Record, Idx);
    E.TypeIdParens.$assignMove(ReadSourceRange(Record, Idx));
    E.Range.$assignMove(ReadSourceRange(Record, Idx));
    E.DirectInitRange.$assignMove(ReadSourceRange(Record, Idx));
    
    E.AllocateArgsArray(Reader.getContext(), isArray, NumPlacementArgs, 
        $2bits_uint2uint(E.StoredInitializationStyle) != 0);
    
    // Install all the subexpressions.
    for (type$ptr<Stmt /*P*/ /*P*/> I = $tryClone(E.raw_arg_begin()), /*P*/ /*P*/ e = $tryClone(E.raw_arg_end());
         $noteq_ptr(I, e); I.$preInc())  {
      I.$set(Reader.ReadSubStmt());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1590,
   FQN="clang::ASTStmtReader::VisitCXXNoexceptExpr", NM="_ZN5clang13ASTStmtReader20VisitCXXNoexceptExprEPNS_15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitCXXNoexceptExprEPNS_15CXXNoexceptExprE")
  //</editor-fold>
  public void VisitCXXNoexceptExpr(CXXNoexceptExpr /*P*/ E) {
    VisitExpr(E);
    E.Value = (boolean)(Record.$at$Const(Idx.$set$postInc()) != 0);
    E.Range.$assignMove(ReadSourceRange(Record, Idx));
    E.Operand = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1354,
   FQN="clang::ASTStmtReader::VisitCXXNullPtrLiteralExpr", NM="_ZN5clang13ASTStmtReader26VisitCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public void VisitCXXNullPtrLiteralExpr(CXXNullPtrLiteralExpr /*P*/ E) {
    VisitExpr(E);
    E.setLocation(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1443,
   FQN="clang::ASTStmtReader::VisitCXXPseudoDestructorExpr", NM="_ZN5clang13ASTStmtReader28VisitCXXPseudoDestructorExprEPNS_23CXXPseudoDestructorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader28VisitCXXPseudoDestructorExprEPNS_23CXXPseudoDestructorExprE")
  //</editor-fold>
  public void VisitCXXPseudoDestructorExpr(CXXPseudoDestructorExpr /*P*/ E) {
    VisitExpr(E);
    
    E.Base = Reader.ReadSubExpr();
    E.IsArrow = /*$bool2bool_1bit(*/(Record.$at$Const(Idx.$set$postInc()) != 0)/*)*/;
    E.OperatorLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    E.ScopeType = GetTypeSourceInfo(Record, Idx);
    E.ColonColonLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.TildeLoc.$assignMove(ReadSourceLocation(Record, Idx));
    
    IdentifierInfo /*P*/ II = Reader.GetIdentifierInfo(F, Record, Idx);
    if ((II != null)) {
      E.setDestroyedType(II, ReadSourceLocation(Record, Idx));
    } else {
      E.setDestroyedType(GetTypeSourceInfo(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1403,
   FQN="clang::ASTStmtReader::VisitCXXScalarValueInitExpr", NM="_ZN5clang13ASTStmtReader27VisitCXXScalarValueInitExprEPNS_22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitCXXScalarValueInitExprEPNS_22CXXScalarValueInitExprE")
  //</editor-fold>
  public void VisitCXXScalarValueInitExpr(CXXScalarValueInitExpr /*P*/ E) {
    VisitExpr(E);
    E.TypeInfo = GetTypeSourceInfo(Record, Idx);
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1306,
   FQN="clang::ASTStmtReader::VisitCXXStdInitializerListExpr", NM="_ZN5clang13ASTStmtReader30VisitCXXStdInitializerListExprEPNS_25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader30VisitCXXStdInitializerListExprEPNS_25CXXStdInitializerListExprE")
  //</editor-fold>
  public void VisitCXXStdInitializerListExpr(CXXStdInitializerListExpr /*P*/ E) {
    VisitExpr(E);
    E.SubExpr = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1372,
   FQN="clang::ASTStmtReader::VisitCXXThisExpr", NM="_ZN5clang13ASTStmtReader16VisitCXXThisExprEPNS_11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitCXXThisExprEPNS_11CXXThisExprE")
  //</editor-fold>
  public void VisitCXXThisExpr(CXXThisExpr /*P*/ E) {
    VisitExpr(E);
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.setImplicit((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1378,
   FQN="clang::ASTStmtReader::VisitCXXThrowExpr", NM="_ZN5clang13ASTStmtReader17VisitCXXThrowExprEPNS_12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitCXXThrowExprEPNS_12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(CXXThrowExpr /*P*/ E) {
    VisitExpr(E);
    E.ThrowLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.Op = Reader.ReadSubExpr();
    E.IsThrownVariableInScope = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1359,
   FQN="clang::ASTStmtReader::VisitCXXTypeidExpr", NM="_ZN5clang13ASTStmtReader18VisitCXXTypeidExprEPNS_13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitCXXTypeidExprEPNS_13CXXTypeidExprE")
  //</editor-fold>
  public void VisitCXXTypeidExpr(CXXTypeidExpr /*P*/ E) {
    VisitExpr(E);
    E.setSourceRange(ReadSourceRange(Record, Idx));
    if (E.isTypeOperand()) { // typeid(int)
      E.setTypeOperandSourceInfo(GetTypeSourceInfo(Record, Idx));
      return;
    }
    
    // typeid(42+2)
    E.setExprOperand(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXUnresolvedConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1507,
   FQN="clang::ASTStmtReader::VisitCXXUnresolvedConstructExpr", NM="_ZN5clang13ASTStmtReader31VisitCXXUnresolvedConstructExprEPNS_26CXXUnresolvedConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader31VisitCXXUnresolvedConstructExprEPNS_26CXXUnresolvedConstructExprE")
  //</editor-fold>
  public void VisitCXXUnresolvedConstructExpr(CXXUnresolvedConstructExpr /*P*/ E) {
    VisitExpr(E);
    assert (Record.$at$Const(Idx.$deref()) == $uint2ullong(E.arg_size())) : "Read wrong record during creation ?";
    Idx.$set$preInc(); // NumArgs;
    for (/*uint*/int I = 0, N = E.arg_size(); I != N; ++I)  {
      E.setArg(I, Reader.ReadSubExpr());
    }
    E.Type = GetTypeSourceInfo(Record, Idx);
    E.setLParenLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1700,
   FQN="clang::ASTStmtReader::VisitCXXUuidofExpr", NM="_ZN5clang13ASTStmtReader18VisitCXXUuidofExprEPNS_13CXXUuidofExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitCXXUuidofExprEPNS_13CXXUuidofExprE")
  //</editor-fold>
  public void VisitCXXUuidofExpr(CXXUuidofExpr /*P*/ E) {
    VisitExpr(E);
    E.setSourceRange(ReadSourceRange(Record, Idx));
    std.string UuidStr = ReadString(Record, Idx);
    E.setUuidStr(new StringRef(UuidStr).copy(Reader.getContext()));
    if (E.isTypeOperand()) { // __uuidof(ComType)
      E.setTypeOperandSourceInfo(GetTypeSourceInfo(Record, Idx));
      return;
    }
    
    // __uuidof(expr)
    E.setExprOperand(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 626,
   FQN="clang::ASTStmtReader::VisitCallExpr", NM="_ZN5clang13ASTStmtReader13VisitCallExprEPNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitCallExprEPNS_8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ E) {
    VisitExpr(E);
    E.setNumArgs(Reader.getContext(), $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
    E.setCallee(Reader.ReadSubExpr());
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I)  {
      E.setArg(I, Reader.ReadSubExpr());
    }
  }

  
  //===----------------------------------------------------------------------===//
  // CUDA Expressions and Statements
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1745,
   FQN="clang::ASTStmtReader::VisitCUDAKernelCallExpr", NM="_ZN5clang13ASTStmtReader23VisitCUDAKernelCallExprEPNS_18CUDAKernelCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitCUDAKernelCallExprEPNS_18CUDAKernelCallExprE")
  //</editor-fold>
  public void VisitCUDAKernelCallExpr(CUDAKernelCallExpr /*P*/ E) {
    VisitCallExpr(E);
    E.setConfig(cast_CallExpr(Reader.ReadSubExpr()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 635,
   FQN="clang::ASTStmtReader::VisitCXXMemberCallExpr", NM="_ZN5clang13ASTStmtReader22VisitCXXMemberCallExprEPNS_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitCXXMemberCallExprEPNS_17CXXMemberCallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(CXXMemberCallExpr /*P*/ E) {
    VisitCallExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1238,
   FQN="clang::ASTStmtReader::VisitCXXOperatorCallExpr", NM="_ZN5clang13ASTStmtReader24VisitCXXOperatorCallExprEPNS_19CXXOperatorCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitCXXOperatorCallExprEPNS_19CXXOperatorCallExprE")
  //</editor-fold>
  public void VisitCXXOperatorCallExpr(CXXOperatorCallExpr /*P*/ E) {
    VisitCallExpr(E);
    E.Operator = OverloadedOperatorKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    E.Range.$assignMove(Reader.ReadSourceRange(F, Record, Idx));
    E.setFPContractable((boolean)(Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitUserDefinedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1343,
   FQN="clang::ASTStmtReader::VisitUserDefinedLiteral", NM="_ZN5clang13ASTStmtReader23VisitUserDefinedLiteralEPNS_18UserDefinedLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitUserDefinedLiteralEPNS_18UserDefinedLiteralE")
  //</editor-fold>
  public void VisitUserDefinedLiteral(UserDefinedLiteral /*P*/ E) {
    VisitCallExpr(E);
    E.UDSuffixLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 667,
   FQN="clang::ASTStmtReader::VisitCastExpr", NM="_ZN5clang13ASTStmtReader13VisitCastExprEPNS_8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitCastExprEPNS_8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ E) {
    VisitExpr(E);
    /*uint*/int NumBaseSpecs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (NumBaseSpecs == E.path_size());
    E.setSubExpr(Reader.ReadSubExpr());
    E.setCastKind(CastKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    type$ptr<CXXBaseSpecifier /*P*/ /*P*/> BaseI = $tryClone(E.path_begin());
    while (((NumBaseSpecs--) != 0)) {
      CXXBaseSpecifier /*P*/ BaseSpec = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (Reader.getContext())*/ $new_uint_ASTContext$C_uint(Reader.getContext(), (type$ptr<?> New$Mem)->{
          return new CXXBaseSpecifier();
       });
      $Deref(BaseSpec).$assignMove(Reader.ReadCXXBaseSpecifier(F, Record, Idx));
      BaseI.$postInc().$set(BaseSpec);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 721,
   FQN="clang::ASTStmtReader::VisitExplicitCastExpr", NM="_ZN5clang13ASTStmtReader21VisitExplicitCastExprEPNS_16ExplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitExplicitCastExprEPNS_16ExplicitCastExprE")
  //</editor-fold>
  public void VisitExplicitCastExpr(ExplicitCastExpr /*P*/ E) {
    VisitCastExpr(E);
    E.setTypeInfoAsWritten(GetTypeSourceInfo(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 726,
   FQN="clang::ASTStmtReader::VisitCStyleCastExpr", NM="_ZN5clang13ASTStmtReader19VisitCStyleCastExprEPNS_14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitCStyleCastExprEPNS_14CStyleCastExprE")
  //</editor-fold>
  public void VisitCStyleCastExpr(CStyleCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    E.setLParenLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1337,
   FQN="clang::ASTStmtReader::VisitCXXFunctionalCastExpr", NM="_ZN5clang13ASTStmtReader26VisitCXXFunctionalCastExprEPNS_21CXXFunctionalCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitCXXFunctionalCastExprEPNS_21CXXFunctionalCastExprE")
  //</editor-fold>
  public void VisitCXXFunctionalCastExpr(CXXFunctionalCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    E.setLParenLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1312,
   FQN="clang::ASTStmtReader::VisitCXXNamedCastExpr", NM="_ZN5clang13ASTStmtReader21VisitCXXNamedCastExprEPNS_16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitCXXNamedCastExprEPNS_16CXXNamedCastExprE")
  //</editor-fold>
  public void VisitCXXNamedCastExpr(CXXNamedCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    SourceRange R = ReadSourceRange(Record, Idx);
    E.Loc.$assignMove(R.getBegin());
    E.RParenLoc.$assignMove(R.getEnd());
    R.$assignMove(ReadSourceRange(Record, Idx));
    E.AngleBrackets.$assign(R);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXConstCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1333,
   FQN="clang::ASTStmtReader::VisitCXXConstCastExpr", NM="_ZN5clang13ASTStmtReader21VisitCXXConstCastExprEPNS_16CXXConstCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitCXXConstCastExprEPNS_16CXXConstCastExprE")
  //</editor-fold>
  public void VisitCXXConstCastExpr(CXXConstCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1325,
   FQN="clang::ASTStmtReader::VisitCXXDynamicCastExpr", NM="_ZN5clang13ASTStmtReader23VisitCXXDynamicCastExprEPNS_18CXXDynamicCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitCXXDynamicCastExprEPNS_18CXXDynamicCastExprE")
  //</editor-fold>
  public void VisitCXXDynamicCastExpr(CXXDynamicCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1329,
   FQN="clang::ASTStmtReader::VisitCXXReinterpretCastExpr", NM="_ZN5clang13ASTStmtReader27VisitCXXReinterpretCastExprEPNS_22CXXReinterpretCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitCXXReinterpretCastExprEPNS_22CXXReinterpretCastExprE")
  //</editor-fold>
  public void VisitCXXReinterpretCastExpr(CXXReinterpretCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCXXStaticCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1321,
   FQN="clang::ASTStmtReader::VisitCXXStaticCastExpr", NM="_ZN5clang13ASTStmtReader22VisitCXXStaticCastExprEPNS_17CXXStaticCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitCXXStaticCastExprEPNS_17CXXStaticCastExprE")
  //</editor-fold>
  public void VisitCXXStaticCastExpr(CXXStaticCastExpr /*P*/ E) {
    VisitCXXNamedCastExpr(E);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCBridgedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 660,
   FQN="clang::ASTStmtReader::VisitObjCBridgedCastExpr", NM="_ZN5clang13ASTStmtReader24VisitObjCBridgedCastExprEPNS_19ObjCBridgedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitObjCBridgedCastExprEPNS_19ObjCBridgedCastExprE")
  //</editor-fold>
  public void VisitObjCBridgedCastExpr(ObjCBridgedCastExpr /*P*/ E) {
    VisitExplicitCastExpr(E);
    E.LParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.BridgeKeywordLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.Kind = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 717,
   FQN="clang::ASTStmtReader::VisitImplicitCastExpr", NM="_ZN5clang13ASTStmtReader21VisitImplicitCastExprEPNS_16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitImplicitCastExprEPNS_16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    VisitCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 523,
   FQN="clang::ASTStmtReader::VisitCharacterLiteral", NM="_ZN5clang13ASTStmtReader21VisitCharacterLiteralEPNS_16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitCharacterLiteralEPNS_16CharacterLiteralE")
  //</editor-fold>
  public void VisitCharacterLiteral(CharacterLiteral /*P*/ E) {
    VisitExpr(E);
    E.setValue($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.setKind(/*static_cast*/CharacterLiteral.CharacterKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 875,
   FQN="clang::ASTStmtReader::VisitChooseExpr", NM="_ZN5clang13ASTStmtReader15VisitChooseExprEPNS_10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitChooseExprEPNS_10ChooseExprE")
  //</editor-fold>
  public void VisitChooseExpr(ChooseExpr /*P*/ E) {
    VisitExpr(E);
    E.setCond(Reader.ReadSubExpr());
    E.setLHS(Reader.ReadSubExpr());
    E.setRHS(Reader.ReadSubExpr());
    E.setBuiltinLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
    E.setIsConditionTrue((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 732,
   FQN="clang::ASTStmtReader::VisitCompoundLiteralExpr", NM="_ZN5clang13ASTStmtReader24VisitCompoundLiteralExprEPNS_19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitCompoundLiteralExprEPNS_19CompoundLiteralExprE")
  //</editor-fold>
  public void VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    VisitExpr(E);
    E.setLParenLoc(ReadSourceLocation(Record, Idx));
    E.setTypeSourceInfo(GetTypeSourceInfo(Record, Idx));
    E.setInitializer(Reader.ReadSubExpr());
    E.setFileScope((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 901,
   FQN="clang::ASTStmtReader::VisitConvertVectorExpr", NM="_ZN5clang13ASTStmtReader22VisitConvertVectorExprEPNS_17ConvertVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitConvertVectorExprEPNS_17ConvertVectorExprE")
  //</editor-fold>
  public void VisitConvertVectorExpr(ConvertVectorExpr /*P*/ E) {
    VisitExpr(E);
    E.BuiltinLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.TInfo = GetTypeSourceInfo(Record, Idx);
    E.SrcExpr = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCoroutineSuspendExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/StmtNodes.inc", line = 445,
   FQN="clang::ASTStmtReader::VisitCoroutineSuspendExpr", NM="_ZN5clang13ASTStmtReader25VisitCoroutineSuspendExprEPNS_20CoroutineSuspendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitCoroutineSuspendExprEPNS_20CoroutineSuspendExprE")
  //</editor-fold>
  public void VisitCoroutineSuspendExpr(CoroutineSuspendExpr /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCoawaitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 398,
   FQN="clang::ASTStmtReader::VisitCoawaitExpr", NM="_ZN5clang13ASTStmtReader16VisitCoawaitExprEPNS_11CoawaitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitCoawaitExprEPNS_11CoawaitExprE")
  //</editor-fold>
  public void VisitCoawaitExpr(CoawaitExpr /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCoyieldExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 403,
   FQN="clang::ASTStmtReader::VisitCoyieldExpr", NM="_ZN5clang13ASTStmtReader16VisitCoyieldExprEPNS_11CoyieldExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitCoyieldExprEPNS_11CoyieldExprE")
  //</editor-fold>
  public void VisitCoyieldExpr(CoyieldExpr /*P*/ S) {
    // FIXME: Implement coroutine serialization.
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 453,
   FQN="clang::ASTStmtReader::VisitDeclRefExpr", NM="_ZN5clang13ASTStmtReader16VisitDeclRefExprEPNS_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitDeclRefExprEPNS_11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    VisitExpr(E);
    
    E.Unnamed_field.DeclRefExprBits.HasQualifier = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.Unnamed_field.DeclRefExprBits.HasFoundDecl = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.Unnamed_field.DeclRefExprBits.HadMultipleCandidates = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    /*uint*/int NumTemplateArgs = 0;
    if (E.hasTemplateKWAndArgsInfo()) {
      NumTemplateArgs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    }
    if (E.hasQualifier()) {
      /*NEW_EXPR [System]*/E.getTrailingObjects(NestedNameSpecifierLoc.class).$set(/*= new (E->getTrailingObjects<NestedNameSpecifierLoc>())*/ $new_uint_voidPtr(E.getTrailingObjects(NestedNameSpecifierLoc.class), (type$ptr<?> New$Mem)->{
          return new NestedNameSpecifierLoc(New$Mem, Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
       }));
    }
    if (E.hasFoundDecl()) {
      E.getTrailingObjects(NamedDecl /*P*/.class).$set(this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx));
    }
    if (E.hasTemplateKWAndArgsInfo()) {
      ReadTemplateKWAndArgsInfo($Deref(E.getTrailingObjects(ASTTemplateKWAndArgsInfo.class)), 
          E.getTrailingObjects(TemplateArgumentLoc.class), NumTemplateArgs);
    }
    
    E.setDecl(this.<ValueDecl>ReadDeclAs(ValueDecl.class, Record, Idx));
    E.setLocation(ReadSourceLocation(Record, Idx));
    ReadDeclarationNameLoc(E.DNLoc, E.getDecl().getDeclName(), Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDependentScopeDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1493,
   FQN="clang::ASTStmtReader::VisitDependentScopeDeclRefExpr", NM="_ZN5clang13ASTStmtReader30VisitDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader30VisitDependentScopeDeclRefExprEPNS_25DependentScopeDeclRefExprE")
  //</editor-fold>
  public void VisitDependentScopeDeclRefExpr(DependentScopeDeclRefExpr /*P*/ E) {
    VisitExpr(E);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // HasTemplateKWAndArgsInfo
      ReadTemplateKWAndArgsInfo($Deref(E.getTrailingObjects(ASTTemplateKWAndArgsInfo.class)), 
          E.getTrailingObjects(TemplateArgumentLoc.class), 
          /*NumTemplateArgs=*/ $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    
    E.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    ReadDeclarationNameInfo(E.NameInfo, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 774,
   FQN="clang::ASTStmtReader::VisitDesignatedInitExpr", NM="_ZN5clang13ASTStmtReader23VisitDesignatedInitExprEPNS_18DesignatedInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitDesignatedInitExprEPNS_18DesignatedInitExprE")
  //</editor-fold>
  public void VisitDesignatedInitExpr(DesignatedInitExpr /*P*/ E) {
    // JAVA: typedef DesignatedInitExpr::Designator Designator
//    final class Designator extends DesignatedInitExpr.Designator{ };
    
    VisitExpr(E);
    /*uint*/int NumSubExprs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (NumSubExprs == E.getNumSubExprs()) : "Wrong number of subexprs";
    for (/*uint*/int I = 0; I != NumSubExprs; ++I)  {
      E.setSubExpr(I, Reader.ReadSubExpr());
    }
    E.setEqualOrColonLoc(ReadSourceLocation(Record, Idx));
    E.setGNUSyntax((Record.$at$Const(Idx.$set$postInc()) != 0));
    
    SmallVector<DesignatedInitExpr.Designator> Designators/*J*/= new SmallVector<DesignatedInitExpr.Designator>(4, new DesignatedInitExpr.Designator());
    while ($less_uint(Idx.$deref(), Record.size())) {
      switch ((int)Record.$at$Const(Idx.$set$postInc())) {
       case DesignatorTypes.DESIG_FIELD_DECL:
        {
          FieldDecl /*P*/ Field = this.<FieldDecl>ReadDeclAs(FieldDecl.class, Record, Idx);
          SourceLocation DotLoc = ReadSourceLocation(Record, Idx);
          SourceLocation FieldLoc = ReadSourceLocation(Record, Idx);
          Designators.push_back(new DesignatedInitExpr.Designator(Field.getIdentifier(), new SourceLocation(DotLoc), 
                  new SourceLocation(FieldLoc)));
          Designators.back().setField(Field);
          break;
        }
       case DesignatorTypes.DESIG_FIELD_NAME:
        {
          /*const*/ IdentifierInfo /*P*/ Name = Reader.GetIdentifierInfo(F, Record, Idx);
          SourceLocation DotLoc = ReadSourceLocation(Record, Idx);
          SourceLocation FieldLoc = ReadSourceLocation(Record, Idx);
          Designators.push_back(new DesignatedInitExpr.Designator(Name, new SourceLocation(DotLoc), new SourceLocation(FieldLoc)));
          break;
        }
       case DesignatorTypes.DESIG_ARRAY:
        {
          /*uint*/int Index = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SourceLocation LBracketLoc = ReadSourceLocation(Record, Idx);
          SourceLocation RBracketLoc = ReadSourceLocation(Record, Idx);
          Designators.push_back(new DesignatedInitExpr.Designator(Index, new SourceLocation(LBracketLoc), new SourceLocation(RBracketLoc)));
          break;
        }
       case DesignatorTypes.DESIG_ARRAY_RANGE:
        {
          /*uint*/int Index = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SourceLocation LBracketLoc = ReadSourceLocation(Record, Idx);
          SourceLocation EllipsisLoc = ReadSourceLocation(Record, Idx);
          SourceLocation RBracketLoc = ReadSourceLocation(Record, Idx);
          Designators.push_back(new DesignatedInitExpr.Designator(Index, new SourceLocation(LBracketLoc), new SourceLocation(EllipsisLoc), 
                  new SourceLocation(RBracketLoc)));
          break;
        }
      }
    }
    E.setDesignators(Reader.getContext(), 
        Designators.data(), Designators.size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 838,
   FQN="clang::ASTStmtReader::VisitDesignatedInitUpdateExpr", NM="_ZN5clang13ASTStmtReader29VisitDesignatedInitUpdateExprEPNS_24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader29VisitDesignatedInitUpdateExprEPNS_24DesignatedInitUpdateExprE")
  //</editor-fold>
  public void VisitDesignatedInitUpdateExpr(DesignatedInitUpdateExpr /*P*/ E) {
    VisitExpr(E);
    E.setBase(Reader.ReadSubExpr());
    E.setUpdater(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1461,
   FQN="clang::ASTStmtReader::VisitExprWithCleanups", NM="_ZN5clang13ASTStmtReader21VisitExprWithCleanupsEPNS_16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitExprWithCleanupsEPNS_16ExprWithCleanupsE")
  //</editor-fold>
  public void VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    VisitExpr(E);
    
    /*uint*/int NumObjects = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (NumObjects == E.getNumObjects());
    for (/*uint*/int i = 0; i != NumObjects; ++i)  {
      E.getTrailingObjects(BlockDecl /*P*/.class).$set(i, 
        this.<BlockDecl>ReadDeclAs(BlockDecl.class, Record, Idx));
    }
    
    E.Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.SubExpr = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1580,
   FQN="clang::ASTStmtReader::VisitExpressionTraitExpr", NM="_ZN5clang13ASTStmtReader24VisitExpressionTraitExprEPNS_19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitExpressionTraitExprEPNS_19ExpressionTraitExprE")
  //</editor-fold>
  public void VisitExpressionTraitExpr(ExpressionTraitExpr /*P*/ E) {
    VisitExpr(E);
    E.ET = ExpressionTrait.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue();
    E.Value = (boolean)(Record.$at$Const(Idx.$set$postInc()) != 0);
    SourceRange Range = ReadSourceRange(Record, Idx);
    E.QueriedExpression = Reader.ReadSubExpr();
    E.Loc.$assignMove(Range.getBegin());
    E.RParen.$assignMove(Range.getEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 740,
   FQN="clang::ASTStmtReader::VisitExtVectorElementExpr", NM="_ZN5clang13ASTStmtReader25VisitExtVectorElementExprEPNS_20ExtVectorElementExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitExtVectorElementExprEPNS_20ExtVectorElementExprE")
  //</editor-fold>
  public void VisitExtVectorElementExpr(ExtVectorElementExpr /*P*/ E) {
    VisitExpr(E);
    E.setBase(Reader.ReadSubExpr());
    E.setAccessor(Reader.GetIdentifierInfo(F, Record, Idx));
    E.setAccessorLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 489,
   FQN="clang::ASTStmtReader::VisitFloatingLiteral", NM="_ZN5clang13ASTStmtReader20VisitFloatingLiteralEPNS_15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitFloatingLiteralEPNS_15FloatingLiteralE")
  //</editor-fold>
  public void VisitFloatingLiteral(FloatingLiteral /*P*/ E) {
    VisitExpr(E);
    E.setRawSemantics(/*static_cast*/Stmt.APFloatSemantics.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    E.setExact((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setValue(Reader.getContext(), 
        Reader.ReadAPFloat(Record, E.getSemantics(), Idx));
    E.setLocation(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitFunctionParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1643,
   FQN="clang::ASTStmtReader::VisitFunctionParmPackExpr", NM="_ZN5clang13ASTStmtReader25VisitFunctionParmPackExprEPNS_20FunctionParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitFunctionParmPackExprEPNS_20FunctionParmPackExprE")
  //</editor-fold>
  public void VisitFunctionParmPackExpr(FunctionParmPackExpr /*P*/ E) {
    VisitExpr(E);
    E.NumParameters = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.ParamPack = this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx);
    E.NameLoc.$assignMove(ReadSourceLocation(Record, Idx));
    type$ptr<ParmVarDecl /*P*/ /*P*/> Parms = $tryClone(E.getTrailingObjects(ParmVarDecl /*P*/.class));
    for (/*uint*/int i = 0, n = E.NumParameters; i != n; ++i)  {
      Parms.$set(i, this.<ParmVarDecl>ReadDeclAs(ParmVarDecl.class, Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 885,
   FQN="clang::ASTStmtReader::VisitGNUNullExpr", NM="_ZN5clang13ASTStmtReader16VisitGNUNullExprEPNS_11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitGNUNullExprEPNS_11GNUNullExprE")
  //</editor-fold>
  public void VisitGNUNullExpr(GNUNullExpr /*P*/ E) {
    VisitExpr(E);
    E.setTokenLocation(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 914,
   FQN="clang::ASTStmtReader::VisitGenericSelectionExpr", NM="_ZN5clang13ASTStmtReader25VisitGenericSelectionExprEPNS_20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitGenericSelectionExprEPNS_20GenericSelectionExprE")
  //</editor-fold>
  public void VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ E) {
    VisitExpr(E);
    E.NumAssocs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.AssocTypes = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Reader.getContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new TypeSourceInfo /*P*/ [E.NumAssocs]);
    E.SubExprs = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Reader.getContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Stmt /*P*/ [GenericSelectionExpr.Unnamed_enum.END_EXPR.getValue() + E.NumAssocs]);
    
    E.SubExprs.$set(GenericSelectionExpr.Unnamed_enum.CONTROLLING.getValue(), Reader.ReadSubExpr());
    for (/*uint*/int I = 0, N = E.getNumAssocs(); I != N; ++I) {
      E.AssocTypes.$set(I, GetTypeSourceInfo(Record, Idx));
      E.SubExprs.$set(GenericSelectionExpr.Unnamed_enum.END_EXPR.getValue() + I, Reader.ReadSubExpr());
    }
    E.ResultIndex = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    
    E.GenericLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.DefaultLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitImaginaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 498,
   FQN="clang::ASTStmtReader::VisitImaginaryLiteral", NM="_ZN5clang13ASTStmtReader21VisitImaginaryLiteralEPNS_16ImaginaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitImaginaryLiteralEPNS_16ImaginaryLiteralE")
  //</editor-fold>
  public void VisitImaginaryLiteral(ImaginaryLiteral /*P*/ E) {
    VisitExpr(E);
    E.setSubExpr(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 848,
   FQN="clang::ASTStmtReader::VisitImplicitValueInitExpr", NM="_ZN5clang13ASTStmtReader26VisitImplicitValueInitExprEPNS_21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitImplicitValueInitExprEPNS_21ImplicitValueInitExprE")
  //</editor-fold>
  public void VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 747,
   FQN="clang::ASTStmtReader::VisitInitListExpr", NM="_ZN5clang13ASTStmtReader17VisitInitListExprEPNS_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitInitListExprEPNS_12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(InitListExpr /*P*/ E) {
    VisitExpr(E);
    {
      InitListExpr /*P*/ SyntForm = cast_or_null_InitListExpr(Reader.ReadSubStmt());
      if ((SyntForm != null)) {
        E.setSyntacticForm(SyntForm);
      }
    }
    E.setLBraceLoc(ReadSourceLocation(Record, Idx));
    E.setRBraceLoc(ReadSourceLocation(Record, Idx));
    boolean isArrayFiller = (Record.$at$Const(Idx.$set$postInc()) != 0);
    Expr /*P*/ filler = null;
    if (isArrayFiller) {
      filler = Reader.ReadSubExpr();
      E.ArrayFillerOrUnionFieldInit.$assign_T$C$R(Expr /*P*/ /*const*/ /*&*/.class, filler);
    } else {
      E.ArrayFillerOrUnionFieldInit.$assign_T1$C$R(FieldDecl /*P*/ /*const*/ /*&*/.class, this.<FieldDecl>ReadDeclAs(FieldDecl.class, Record, Idx));
    }
    E.sawArrayRangeDesignator((Record.$at$Const(Idx.$set$postInc()) != 0));
    /*uint*/int NumInits = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.reserveInits(Reader.getContext(), NumInits);
    if (isArrayFiller) {
      for (/*uint*/int I = 0; I != NumInits; ++I) {
        Expr /*P*/ init = Reader.ReadSubExpr();
        E.updateInit(Reader.getContext(), I, (init != null) ? init : filler);
      }
    } else {
      for (/*uint*/int I = 0; I != NumInits; ++I)  {
        E.updateInit(Reader.getContext(), I, Reader.ReadSubExpr());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 483,
   FQN="clang::ASTStmtReader::VisitIntegerLiteral", NM="_ZN5clang13ASTStmtReader19VisitIntegerLiteralEPNS_14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitIntegerLiteralEPNS_14IntegerLiteralE")
  //</editor-fold>
  public void VisitIntegerLiteral(IntegerLiteral /*P*/ E) {
    VisitExpr(E);
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.setValue(Reader.getContext(), Reader.ReadAPInt(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1276,
   FQN="clang::ASTStmtReader::VisitLambdaExpr", NM="_ZN5clang13ASTStmtReader15VisitLambdaExprEPNS_10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitLambdaExprEPNS_10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(LambdaExpr /*P*/ E) {
    VisitExpr(E);
    /*uint*/int NumCaptures = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (NumCaptures == $16bits_uint2uint(E.NumCaptures));
    ///*J:(void)*/NumCaptures;
    /*uint*/int NumArrayIndexVars = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.IntroducerRange.$assignMove(ReadSourceRange(Record, Idx));
    E.CaptureDefault = $uint2uint_2bits(/*static_cast*/LambdaCaptureDefault.valueOf((int)Record.$at$Const(Idx.$set$postInc())).getValue());
    E.CaptureDefaultLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.ExplicitParams = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.ExplicitResultType = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.ClosingBrace.$assignMove(ReadSourceLocation(Record, Idx));
    
    // Read capture initializers.
    for (type$ptr<Expr /*P*/ /*P*/> C = $tryClone(E.capture_init_begin()), 
        /*P*/ /*P*/ CEnd = $tryClone(E.capture_init_end());
         $noteq_ptr(C, CEnd); C.$preInc())  {
      C.$set(Reader.ReadSubExpr());
    }
    
    // Read array capture index variables.
    if ($greater_uint(NumArrayIndexVars, 0)) {
      uint$ptr/*uint P*/ ArrayIndexStarts = $tryClone(E.getArrayIndexStarts());
      for (/*uint*/int I = 0; I != NumCaptures + 1; ++I)  {
        ArrayIndexStarts.$set(I, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      }
      
      type$ptr<VarDecl /*P*/ /*P*/> ArrayIndexVars = $tryClone(E.getArrayIndexVars());
      for (/*uint*/int I = 0; I != NumArrayIndexVars; ++I)  {
        ArrayIndexVars.$set(I, this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
      }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Microsoft Expressions and Statements
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1684,
   FQN="clang::ASTStmtReader::VisitMSPropertyRefExpr", NM="_ZN5clang13ASTStmtReader22VisitMSPropertyRefExprEPNS_17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitMSPropertyRefExprEPNS_17MSPropertyRefExprE")
  //</editor-fold>
  public void VisitMSPropertyRefExpr(MSPropertyRefExpr /*P*/ E) {
    VisitExpr(E);
    E.IsArrow = (Record.$at$Const(Idx.$set$postInc()) != $int2ullong(0));
    E.BaseExpr = Reader.ReadSubExpr();
    E.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    E.MemberLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.TheDecl = this.<MSPropertyDecl>ReadDeclAs(MSPropertyDecl.class, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1693,
   FQN="clang::ASTStmtReader::VisitMSPropertySubscriptExpr", NM="_ZN5clang13ASTStmtReader28VisitMSPropertySubscriptExprEPNS_23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader28VisitMSPropertySubscriptExprEPNS_23MSPropertySubscriptExprE")
  //</editor-fold>
  public void VisitMSPropertySubscriptExpr(MSPropertySubscriptExpr /*P*/ E) {
    VisitExpr(E);
    E.setBase(Reader.ReadSubExpr());
    E.setIdx(Reader.ReadSubExpr());
    E.setRBracketLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1653,
   FQN="clang::ASTStmtReader::VisitMaterializeTemporaryExpr", NM="_ZN5clang13ASTStmtReader29VisitMaterializeTemporaryExprEPNS_24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader29VisitMaterializeTemporaryExprEPNS_24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(MaterializeTemporaryExpr /*P*/ E) {
    VisitExpr(E);
    E.State.$assign_T$C$R(Stmt /*P*/ /*const*/ /*&*/.class, Reader.ReadSubExpr());
    ValueDecl /*P*/ VD = this.<ValueDecl>ReadDeclAs(ValueDecl.class, Record, Idx);
    /*uint*/int ManglingNumber = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.setExtendingDecl(VD, ManglingNumber);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 639,
   FQN="clang::ASTStmtReader::VisitMemberExpr", NM="_ZN5clang13ASTStmtReader15VisitMemberExprEPNS_10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitMemberExprEPNS_10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ E) {
    // Don't call VisitExpr, this is fully initialized at creation.
    assert (E.getStmtClass() == Stmt.StmtClass.MemberExprClass) : "It's a subclass, we must advance Idx!";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitNoInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 844,
   FQN="clang::ASTStmtReader::VisitNoInitExpr", NM="_ZN5clang13ASTStmtReader15VisitNoInitExprEPNS_10NoInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitNoInitExprEPNS_10NoInitExprE")
  //</editor-fold>
  public void VisitNoInitExpr(NoInitExpr /*P*/ E) {
    VisitExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPArraySectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 617,
   FQN="clang::ASTStmtReader::VisitOMPArraySectionExpr", NM="_ZN5clang13ASTStmtReader24VisitOMPArraySectionExprEPNS_19OMPArraySectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitOMPArraySectionExprEPNS_19OMPArraySectionExprE")
  //</editor-fold>
  public void VisitOMPArraySectionExpr(OMPArraySectionExpr /*P*/ E) {
    VisitExpr(E);
    E.setBase(Reader.ReadSubExpr());
    E.setLowerBound(Reader.ReadSubExpr());
    E.setLength(Reader.ReadSubExpr());
    E.setColonLoc(ReadSourceLocation(Record, Idx));
    E.setRBracketLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 976,
   FQN="clang::ASTStmtReader::VisitObjCArrayLiteral", NM="_ZN5clang13ASTStmtReader21VisitObjCArrayLiteralEPNS_16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitObjCArrayLiteralEPNS_16ObjCArrayLiteralE")
  //</editor-fold>
  public void VisitObjCArrayLiteral(ObjCArrayLiteral /*P*/ E) {
    VisitExpr(E);
    /*uint*/int NumElements = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (NumElements == E.getNumElements()) : "Wrong number of elements";
    type$ptr<Expr /*P*/ /*P*/> Elements = $tryClone(E.getElements());
    for (/*uint*/int I = 0, N = NumElements; I != N; ++I)  {
      Elements.$set(I, Reader.ReadSubExpr());
    }
    E.ArrayWithObjectsMethod = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
    E.Range.$assignMove(ReadSourceRange(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAvailabilityCheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1185,
   FQN="clang::ASTStmtReader::VisitObjCAvailabilityCheckExpr", NM="_ZN5clang13ASTStmtReader30VisitObjCAvailabilityCheckExprEPNS_25ObjCAvailabilityCheckExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader30VisitObjCAvailabilityCheckExprEPNS_25ObjCAvailabilityCheckExprE")
  //</editor-fold>
  public void VisitObjCAvailabilityCheckExpr(ObjCAvailabilityCheckExpr /*P*/ E) {
    VisitExpr(E);
    SourceRange R = Reader.ReadSourceRange(F, Record, Idx);
    E.AtLoc.$assignMove(R.getBegin());
    E.RParen.$assignMove(R.getEnd());
    E.VersionToCheck.$assignMove(Reader.ReadVersionTuple(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1179,
   FQN="clang::ASTStmtReader::VisitObjCBoolLiteralExpr", NM="_ZN5clang13ASTStmtReader24VisitObjCBoolLiteralExprEPNS_19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitObjCBoolLiteralExprEPNS_19ObjCBoolLiteralExprE")
  //</editor-fold>
  public void VisitObjCBoolLiteralExpr(ObjCBoolLiteralExpr /*P*/ E) {
    VisitExpr(E);
    E.setValue((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setLocation(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 968,
   FQN="clang::ASTStmtReader::VisitObjCBoxedExpr", NM="_ZN5clang13ASTStmtReader18VisitObjCBoxedExprEPNS_13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitObjCBoxedExprEPNS_13ObjCBoxedExprE")
  //</editor-fold>
  public void VisitObjCBoxedExpr(ObjCBoxedExpr /*P*/ E) {
    VisitExpr(E);
    // could be one of several IntegerLiteral, FloatLiteral, etc.
    E.SubExpr = Reader.ReadSubStmt();
    E.BoxingMethod = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
    E.Range.$assignMove(ReadSourceRange(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 987,
   FQN="clang::ASTStmtReader::VisitObjCDictionaryLiteral", NM="_ZN5clang13ASTStmtReader26VisitObjCDictionaryLiteralEPNS_21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitObjCDictionaryLiteralEPNS_21ObjCDictionaryLiteralE")
  //</editor-fold>
  public void VisitObjCDictionaryLiteral(ObjCDictionaryLiteral /*P*/ E) {
    VisitExpr(E);
    /*uint*/int NumElements = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (NumElements == E.getNumElements()) : "Wrong number of elements";
    boolean HasPackExpansions = (Record.$at$Const(Idx.$set$postInc()) != 0);
    assert (HasPackExpansions == E.HasPackExpansions) : "Pack expansion mismatch";
    type$ptr<ObjCDictionaryLiteral_KeyValuePair /*P*/> KeyValues = E.getTrailingObjects(ObjCDictionaryLiteral_KeyValuePair.class);
    type$ptr<ObjCDictionaryLiteral_ExpansionData /*P*/> Expansions = E.getTrailingObjects(ObjCDictionaryLiteral_ExpansionData.class);
    for (/*uint*/int I = 0; I != NumElements; ++I) {
      KeyValues.$at(I).Key = Reader.ReadSubExpr();
      KeyValues.$at(I).Value = Reader.ReadSubExpr();
      if (HasPackExpansions) {
        Expansions.$at(I).EllipsisLoc.$assignMove(ReadSourceLocation(Record, Idx));
        Expansions.$at(I).NumExpansionsPlusOne = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      }
    }
    E.DictWithObjectsMethod = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
    E.Range.$assignMove(ReadSourceRange(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1009,
   FQN="clang::ASTStmtReader::VisitObjCEncodeExpr", NM="_ZN5clang13ASTStmtReader19VisitObjCEncodeExprEPNS_14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitObjCEncodeExprEPNS_14ObjCEncodeExprE")
  //</editor-fold>
  public void VisitObjCEncodeExpr(ObjCEncodeExpr /*P*/ E) {
    VisitExpr(E);
    E.setEncodedTypeSourceInfo(GetTypeSourceInfo(Record, Idx));
    E.setAtLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCIndirectCopyRestoreExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 653,
   FQN="clang::ASTStmtReader::VisitObjCIndirectCopyRestoreExpr", NM="_ZN5clang13ASTStmtReader32VisitObjCIndirectCopyRestoreExprEPNS_27ObjCIndirectCopyRestoreExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader32VisitObjCIndirectCopyRestoreExprEPNS_27ObjCIndirectCopyRestoreExprE")
  //</editor-fold>
  public void VisitObjCIndirectCopyRestoreExpr(ObjCIndirectCopyRestoreExpr /*P*/ E) {
    VisitExpr(E);
    E.Operand = Reader.ReadSubExpr();
    E.setShouldCopy((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 645,
   FQN="clang::ASTStmtReader::VisitObjCIsaExpr", NM="_ZN5clang13ASTStmtReader16VisitObjCIsaExprEPNS_11ObjCIsaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitObjCIsaExprEPNS_11ObjCIsaExprE")
  //</editor-fold>
  public void VisitObjCIsaExpr(ObjCIsaExpr /*P*/ E) {
    VisitExpr(E);
    E.setBase(Reader.ReadSubExpr());
    E.setIsaMemberLoc(ReadSourceLocation(Record, Idx));
    E.setOpLoc(ReadSourceLocation(Record, Idx));
    E.setArrow((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1031,
   FQN="clang::ASTStmtReader::VisitObjCIvarRefExpr", NM="_ZN5clang13ASTStmtReader20VisitObjCIvarRefExprEPNS_15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitObjCIvarRefExprEPNS_15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    VisitExpr(E);
    E.setDecl(this.<ObjCIvarDecl>ReadDeclAs(ObjCIvarDecl.class, Record, Idx));
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.setOpLoc(ReadSourceLocation(Record, Idx));
    E.setBase(Reader.ReadSubExpr());
    E.setIsArrow((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.setIsFreeIvar((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1077,
   FQN="clang::ASTStmtReader::VisitObjCMessageExpr", NM="_ZN5clang13ASTStmtReader20VisitObjCMessageExprEPNS_15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitObjCMessageExprEPNS_15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    VisitExpr(E);
    assert (Record.$at$Const(Idx.$deref()) == $uint2ullong(E.getNumArgs()));
    Idx.$set$preInc();
    /*uint*/int NumStoredSelLocs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.SelLocsKind = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.setDelegateInitCall((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.IsImplicit = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    ObjCMessageExpr.ReceiverKind Kind = /*static_cast*/ObjCMessageExpr.ReceiverKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    switch (Kind) {
     case Instance:
      E.setInstanceReceiver(Reader.ReadSubExpr());
      break;
     case Class:
      E.setClassReceiver(GetTypeSourceInfo(Record, Idx));
      break;
     case SuperClass:
     case SuperInstance:
      {
        QualType T = Reader.readType(F, Record, Idx);
        SourceLocation SuperLoc = ReadSourceLocation(Record, Idx);
        E.setSuper(new SourceLocation(SuperLoc), new QualType(T), Kind == ObjCMessageExpr.ReceiverKind.SuperInstance);
        break;
      }
    }
    assert (Kind == E.getReceiverKind());
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      E.setMethodDecl(this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx));
    } else {
      E.setSelector(Reader.ReadSelector(F, Record, Idx));
    }
    
    E.LBracLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RBracLoc.$assignMove(ReadSourceLocation(Record, Idx));
    
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I)  {
      E.setArg(I, Reader.ReadSubExpr());
    }
    
    type$ptr<SourceLocation /*P*/> Locs = E.getStoredSelLocs();
    for (/*uint*/int I = 0; I != NumStoredSelLocs; ++I)  {
      Locs.$at(I).$assignMove(ReadSourceLocation(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1041,
   FQN="clang::ASTStmtReader::VisitObjCPropertyRefExpr", NM="_ZN5clang13ASTStmtReader24VisitObjCPropertyRefExprEPNS_19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitObjCPropertyRefExprEPNS_19ObjCPropertyRefExprE")
  //</editor-fold>
  public void VisitObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ E) {
    VisitExpr(E);
    /*uint*/int MethodRefFlags = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    boolean Implicit = Record.$at$Const(Idx.$set$postInc()) != $int2ullong(0);
    if (Implicit) {
      ObjCMethodDecl /*P*/ Getter = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
      ObjCMethodDecl /*P*/ Setter = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
      E.setImplicitProperty(Getter, Setter, MethodRefFlags);
    } else {
      E.setExplicitProperty(this.<ObjCPropertyDecl>ReadDeclAs(ObjCPropertyDecl.class, Record, Idx), 
          MethodRefFlags);
    }
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.setReceiverLocation(ReadSourceLocation(Record, Idx));
    switch ((int)Record.$at$Const(Idx.$set$postInc())) {
     case 0:
      E.setBase(Reader.ReadSubExpr());
      break;
     case 1:
      E.setSuperReceiver(Reader.readType(F, Record, Idx));
      break;
     case 2:
      E.setClassReceiver(this.<ObjCInterfaceDecl>ReadDeclAs(ObjCInterfaceDecl.class, Record, Idx));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1023,
   FQN="clang::ASTStmtReader::VisitObjCProtocolExpr", NM="_ZN5clang13ASTStmtReader21VisitObjCProtocolExprEPNS_16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitObjCProtocolExprEPNS_16ObjCProtocolExprE")
  //</editor-fold>
  public void VisitObjCProtocolExpr(ObjCProtocolExpr /*P*/ E) {
    VisitExpr(E);
    E.setProtocol(this.<ObjCProtocolDecl>ReadDeclAs(ObjCProtocolDecl.class, Record, Idx));
    E.setAtLoc(ReadSourceLocation(Record, Idx));
    E.ProtoLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1016,
   FQN="clang::ASTStmtReader::VisitObjCSelectorExpr", NM="_ZN5clang13ASTStmtReader21VisitObjCSelectorExprEPNS_16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitObjCSelectorExprEPNS_16ObjCSelectorExprE")
  //</editor-fold>
  public void VisitObjCSelectorExpr(ObjCSelectorExpr /*P*/ E) {
    VisitExpr(E);
    E.setSelector(Reader.ReadSelector(F, Record, Idx));
    E.setAtLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  
  //===----------------------------------------------------------------------===//
  // Objective-C Expressions and Statements
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 962,
   FQN="clang::ASTStmtReader::VisitObjCStringLiteral", NM="_ZN5clang13ASTStmtReader22VisitObjCStringLiteralEPNS_17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitObjCStringLiteralEPNS_17ObjCStringLiteralE")
  //</editor-fold>
  public void VisitObjCStringLiteral(ObjCStringLiteral /*P*/ E) {
    VisitExpr(E);
    E.setString(cast_StringLiteral(Reader.ReadSubStmt()));
    E.setAtLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1068,
   FQN="clang::ASTStmtReader::VisitObjCSubscriptRefExpr", NM="_ZN5clang13ASTStmtReader25VisitObjCSubscriptRefExprEPNS_20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitObjCSubscriptRefExprEPNS_20ObjCSubscriptRefExprE")
  //</editor-fold>
  public void VisitObjCSubscriptRefExpr(ObjCSubscriptRefExpr /*P*/ E) {
    VisitExpr(E);
    E.setRBracket(ReadSourceLocation(Record, Idx));
    E.setBaseExpr(Reader.ReadSubExpr());
    E.setKeyExpr(Reader.ReadSubExpr());
    E.GetAtIndexMethodDecl = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
    E.SetAtIndexMethodDecl = this.<ObjCMethodDecl>ReadDeclAs(ObjCMethodDecl.class, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 555,
   FQN="clang::ASTStmtReader::VisitOffsetOfExpr", NM="_ZN5clang13ASTStmtReader17VisitOffsetOfExprEPNS_12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitOffsetOfExprEPNS_12OffsetOfExprE")
  //</editor-fold>
  public void VisitOffsetOfExpr(OffsetOfExpr /*P*/ E) {
    VisitExpr(E);
    assert ($uint2ullong(E.getNumComponents()) == Record.$at$Const(Idx.$deref()));
    Idx.$set$preInc();
    assert ($uint2ullong(E.getNumExpressions()) == Record.$at$Const(Idx.$deref()));
    Idx.$set$preInc();
    E.setOperatorLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
    E.setTypeSourceInfo(GetTypeSourceInfo(Record, Idx));
    for (/*uint*/int I = 0, N = E.getNumComponents(); I != N; ++I) {
      /*OffsetOfNode::Kind*//*uint*/int Kind = ((/*static_cast*//*OffsetOfNode::Kind*//*uint*/int)(Record.$at$Const(Idx.$set$postInc())));
      SourceLocation Start = ReadSourceLocation(Record, Idx);
      SourceLocation End = ReadSourceLocation(Record, Idx);
      switch (Kind) {
       case OffsetOfNode.Kind.Array:
        E.setComponent(I, new OffsetOfNode(new SourceLocation(Start), $ullong2uint(Record.$at$Const(Idx.$set$postInc())), new SourceLocation(End)));
        break;
       case OffsetOfNode.Kind.Field:
        E.setComponent(I, new OffsetOfNode(new SourceLocation(Start), this.<FieldDecl>ReadDeclAs(FieldDecl.class, Record, Idx), new SourceLocation(End)));
        break;
       case OffsetOfNode.Kind.Identifier:
        E.setComponent(I, 
            new OffsetOfNode(new SourceLocation(Start), Reader.GetIdentifierInfo(F, Record, Idx), new SourceLocation(End)));
        break;
       case OffsetOfNode.Kind.Base:
        {
          CXXBaseSpecifier /*P*/ Base = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Reader.getContext())*/ $new_uint_ASTContext$C_uint(Reader.getContext(), (type$ptr<?> New$Mem)->{
              return new CXXBaseSpecifier();
           });
          $Deref(Base).$assignMove(Reader.ReadCXXBaseSpecifier(F, Record, Idx));
          E.setComponent(I, new OffsetOfNode(Base));
          break;
        }
      }
    }
    
    for (/*uint*/int I = 0, N = E.getNumExpressions(); I != N; ++I)  {
      E.setIndexExpr(I, Reader.ReadSubExpr());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1671,
   FQN="clang::ASTStmtReader::VisitOpaqueValueExpr", NM="_ZN5clang13ASTStmtReader20VisitOpaqueValueExprEPNS_15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitOpaqueValueExprEPNS_15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ E) {
    VisitExpr(E);
    E.SourceExpr = Reader.ReadSubExpr();
    E.Loc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOverloadExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1519,
   FQN="clang::ASTStmtReader::VisitOverloadExpr", NM="_ZN5clang13ASTStmtReader17VisitOverloadExprEPNS_12OverloadExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitOverloadExprEPNS_12OverloadExprE")
  //</editor-fold>
  public void VisitOverloadExpr(OverloadExpr /*P*/ E) {
    VisitExpr(E);
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // HasTemplateKWAndArgsInfo
      ReadTemplateKWAndArgsInfo($Deref(E.getTrailingASTTemplateKWAndArgsInfo()), 
          E.getTrailingTemplateArgumentLoc(), 
          /*NumTemplateArgs=*/ $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    }
    
    /*uint*/int NumDecls = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    UnresolvedSet Decls/*J*/= new UnresolvedSet(8);
    for (/*uint*/int i = 0; i != NumDecls; ++i) {
      NamedDecl /*P*/ D = this.<NamedDecl>ReadDeclAs(NamedDecl.class, Record, Idx);
      AccessSpecifier AS = AccessSpecifier.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
      Decls.addDecl(D, AS);
    }
    E.initializeResults(Reader.getContext(), Decls.begin(), Decls.end());
    
    ReadDeclarationNameInfo(E.NameInfo, Record, Idx);
    E.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1549,
   FQN="clang::ASTStmtReader::VisitUnresolvedLookupExpr", NM="_ZN5clang13ASTStmtReader25VisitUnresolvedLookupExprEPNS_20UnresolvedLookupExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitUnresolvedLookupExprEPNS_20UnresolvedLookupExprE")
  //</editor-fold>
  public void VisitUnresolvedLookupExpr(UnresolvedLookupExpr /*P*/ E) {
    VisitOverloadExpr(E);
    E.RequiresADL = (Record.$at$Const(Idx.$set$postInc()) != 0);
    E.Overloaded = (Record.$at$Const(Idx.$set$postInc()) != 0);
    E.NamingClass = this.<CXXRecordDecl>ReadDeclAs(CXXRecordDecl.class, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitUnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1540,
   FQN="clang::ASTStmtReader::VisitUnresolvedMemberExpr", NM="_ZN5clang13ASTStmtReader25VisitUnresolvedMemberExprEPNS_20UnresolvedMemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitUnresolvedMemberExprEPNS_20UnresolvedMemberExprE")
  //</editor-fold>
  public void VisitUnresolvedMemberExpr(UnresolvedMemberExpr /*P*/ E) {
    VisitOverloadExpr(E);
    E.IsArrow = $bool2bool_1bit((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.HasUnresolvedUsing = $bool2bool_1bit((Record.$at$Const(Idx.$set$postInc()) != 0));
    E.Base = Reader.ReadSubExpr();
    E.BaseType.$assignMove(Reader.readType(F, Record, Idx));
    E.OperatorLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitPackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1597,
   FQN="clang::ASTStmtReader::VisitPackExpansionExpr", NM="_ZN5clang13ASTStmtReader22VisitPackExpansionExprEPNS_17PackExpansionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitPackExpansionExprEPNS_17PackExpansionExprE")
  //</editor-fold>
  public void VisitPackExpansionExpr(PackExpansionExpr /*P*/ E) {
    VisitExpr(E);
    E.EllipsisLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.NumExpansions = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.Pattern = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 530,
   FQN="clang::ASTStmtReader::VisitParenExpr", NM="_ZN5clang13ASTStmtReader14VisitParenExprEPNS_9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitParenExprEPNS_9ParenExprE")
  //</editor-fold>
  public void VisitParenExpr(ParenExpr /*P*/ E) {
    VisitExpr(E);
    E.setLParen(ReadSourceLocation(Record, Idx));
    E.setRParen(ReadSourceLocation(Record, Idx));
    E.setSubExpr(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 537,
   FQN="clang::ASTStmtReader::VisitParenListExpr", NM="_ZN5clang13ASTStmtReader18VisitParenListExprEPNS_13ParenListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitParenListExprEPNS_13ParenListExprE")
  //</editor-fold>
  public void VisitParenListExpr(ParenListExpr /*P*/ E) {
    VisitExpr(E);
    /*uint*/int NumExprs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.Exprs = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Reader.getContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Stmt /*P*/ [NumExprs]);
    for (/*uint*/int i = 0; i != NumExprs; ++i)  {
      E.Exprs.$set(i, Reader.ReadSubStmt());
    }
    E.NumExprs = NumExprs;
    E.LParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 446,
   FQN="clang::ASTStmtReader::VisitPredefinedExpr", NM="_ZN5clang13ASTStmtReader19VisitPredefinedExprEPNS_14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitPredefinedExprEPNS_14PredefinedExprE")
  //</editor-fold>
  public void VisitPredefinedExpr(PredefinedExpr /*P*/ E) {
    VisitExpr(E);
    E.setLocation(ReadSourceLocation(Record, Idx));
    E.Type = PredefinedExpr.IdentType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    E.FnName = cast_or_null_StringLiteral(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 933,
   FQN="clang::ASTStmtReader::VisitPseudoObjectExpr", NM="_ZN5clang13ASTStmtReader21VisitPseudoObjectExprEPNS_16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitPseudoObjectExprEPNS_16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ E) {
    VisitExpr(E);
    /*uint*/int numSemanticExprs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (numSemanticExprs + 1 == $8bits_uint2uint(E.Unnamed_field.PseudoObjectExprBits.NumSubExprs));
    E.Unnamed_field.PseudoObjectExprBits.ResultIndex = $uint2uint_8bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    // Read the syntactic expression.
    E.getSubExprsBuffer().$set(0, Reader.ReadSubExpr());
    
    // Read all the semantic expressions.
    for (/*uint*/int i = 0; i != numSemanticExprs; ++i) {
      Expr /*P*/ subExpr = Reader.ReadSubExpr();
      E.getSubExprsBuffer().$set(i + 1, subExpr);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 890,
   FQN="clang::ASTStmtReader::VisitShuffleVectorExpr", NM="_ZN5clang13ASTStmtReader22VisitShuffleVectorExprEPNS_17ShuffleVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitShuffleVectorExprEPNS_17ShuffleVectorExprE")
  //</editor-fold>
  public void VisitShuffleVectorExpr(ShuffleVectorExpr /*P*/ E) {
    VisitExpr(E);
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    /*uint*/int NumExprs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    while (((NumExprs--) != 0)) {
      Exprs.push_back(Reader.ReadSubExpr());
    }
    E.setExprs(Reader.getContext(), new ArrayRef<Expr /*P*/ >(Exprs, true));
    E.setBuiltinLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1604,
   FQN="clang::ASTStmtReader::VisitSizeOfPackExpr", NM="_ZN5clang13ASTStmtReader19VisitSizeOfPackExprEPNS_14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitSizeOfPackExprEPNS_14SizeOfPackExprE")
  //</editor-fold>
  public void VisitSizeOfPackExpr(SizeOfPackExpr /*P*/ E) {
    VisitExpr(E);
    /*uint*/int NumPartialArgs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    E.OperatorLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.PackLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.RParenLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.Pack = Reader.<NamedDecl>ReadDeclAs(NamedDecl.class, F, Record, Idx);
    if (E.isPartiallySubstituted()) {
      assert (E.Length == NumPartialArgs);
      for (type$ptr<TemplateArgument /*P*/> I = E.getTrailingObjects(TemplateArgument.class), 
          /*P*/ E$1 = I.$add(NumPartialArgs);
              $noteq_ptr(I, E$1); I.$preInc())  {
        /*NEW_EXPR [System]*/I.$set(/*new (I)*/ $new_uint_voidPtr(I, (type$ptr<?> New$Mem)->{
            return new TemplateArgument(New$Mem, Reader.ReadTemplateArgument(F, Record, Idx));
         }));
      }
    } else if (!E.isValueDependent()) {
      E.Length = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 868,
   FQN="clang::ASTStmtReader::VisitStmtExpr", NM="_ZN5clang13ASTStmtReader13VisitStmtExprEPNS_8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitStmtExprEPNS_8StmtExprE")
  //</editor-fold>
  public void VisitStmtExpr(StmtExpr /*P*/ E) {
    VisitExpr(E);
    E.setLParenLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
    E.setSubStmt(cast_or_null_CompoundStmt(Reader.ReadSubStmt()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 503,
   FQN="clang::ASTStmtReader::VisitStringLiteral", NM="_ZN5clang13ASTStmtReader18VisitStringLiteralEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitStringLiteralEPNS_13StringLiteralE")
  //</editor-fold>
  public void VisitStringLiteral(StringLiteral /*P*/ E) {
    VisitExpr(E);
    /*uint*/int Len = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert (Record.$at$Const(Idx.$deref()) == $uint2ullong(E.getNumConcatenated())) : "Wrong number of concatenated tokens!";
    Idx.$set$preInc();
    StringLiteral.StringKind kind = /*static_cast*/StringLiteral.StringKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    boolean isPascal = (Record.$at$Const(Idx.$set$postInc()) != 0);
    
    // Read string data
    SmallString/*<16>*/ Str/*J*/= new SmallString/*<16>*/(16, $AddrOf(Record.ptr$at(Idx.$deref())), $AddrOf(Record.ptr$at(Idx.$deref())).$add(Len));
    E.setString(Reader.getContext(), Str.$StringRef(), kind, isPascal);
    Idx.$set$addassign(Len);
    
    // Read source locations
    for (/*uint*/int I = 0, N = E.getNumConcatenated(); I != N; ++I)  {
      E.setStrTokenLoc(I, ReadSourceLocation(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1622,
   FQN="clang::ASTStmtReader::VisitSubstNonTypeTemplateParmExpr", NM="_ZN5clang13ASTStmtReader33VisitSubstNonTypeTemplateParmExprEPNS_28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader33VisitSubstNonTypeTemplateParmExprEPNS_28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ E) {
    VisitExpr(E);
    E.Param = this.<NonTypeTemplateParmDecl>ReadDeclAs(NonTypeTemplateParmDecl.class, Record, Idx);
    E.NameLoc.$assignMove(ReadSourceLocation(Record, Idx));
    E.Replacement = Reader.ReadSubExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1630,
   FQN="clang::ASTStmtReader::VisitSubstNonTypeTemplateParmPackExpr", NM="_ZN5clang13ASTStmtReader37VisitSubstNonTypeTemplateParmPackExprEPNS_32SubstNonTypeTemplateParmPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader37VisitSubstNonTypeTemplateParmPackExprEPNS_32SubstNonTypeTemplateParmPackExprE")
  //</editor-fold>
  public void VisitSubstNonTypeTemplateParmPackExpr(SubstNonTypeTemplateParmPackExpr /*P*/ E) {
    VisitExpr(E);
    E.Param = this.<NonTypeTemplateParmDecl>ReadDeclAs(NonTypeTemplateParmDecl.class, Record, Idx);
    TemplateArgument ArgPack = Reader.ReadTemplateArgument(F, Record, Idx);
    if (ArgPack.getKind() != TemplateArgument.ArgKind.Pack) {
      return;
    }
    
    E.Arguments = ArgPack.pack_begin();
    E.NumArguments = ArgPack.pack_size();
    E.NameLoc.$assignMove(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1556,
   FQN="clang::ASTStmtReader::VisitTypeTraitExpr", NM="_ZN5clang13ASTStmtReader18VisitTypeTraitExprEPNS_13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitTypeTraitExprEPNS_13TypeTraitExprE")
  //</editor-fold>
  public void VisitTypeTraitExpr(TypeTraitExpr /*P*/ E) {
    VisitExpr(E);
    E.Unnamed_field.TypeTraitExprBits.NumArgs = $uint2uint_7bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.Unnamed_field.TypeTraitExprBits.Kind = $uint2uint_8bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    E.Unnamed_field.TypeTraitExprBits.Value = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    SourceRange Range = ReadSourceRange(Record, Idx);
    E.Loc.$assignMove(Range.getBegin());
    E.RParenLoc.$assignMove(Range.getEnd());
    
    type$ptr<TypeSourceInfo /*P*/ /*P*/> Args = $tryClone(E.getTrailingObjects(TypeSourceInfo /*P*/.class));
    for (/*uint*/int I = 0, N = E.getNumArgs(); I != N; ++I)  {
      Args.$set(I, GetTypeSourceInfo(Record, Idx));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1677,
   FQN="clang::ASTStmtReader::VisitTypoExpr", NM="_ZN5clang13ASTStmtReader13VisitTypoExprEPNS_8TypoExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitTypoExprEPNS_8TypoExprE")
  //</editor-fold>
  public void VisitTypoExpr(TypoExpr /*P*/ E) {
    throw new llvm_unreachable("Cannot read TypoExpr nodes");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 597,
   FQN="clang::ASTStmtReader::VisitUnaryExprOrTypeTraitExpr", NM="_ZN5clang13ASTStmtReader29VisitUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader29VisitUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ E) {
    VisitExpr(E);
    E.setKind(/*static_cast*/UnaryExprOrTypeTrait.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    if (Record.$at$Const(Idx.$deref()) == $int2ullong(0)) {
      E.setArgument(Reader.ReadSubExpr());
      Idx.$set$preInc();
    } else {
      E.setArgument(GetTypeSourceInfo(Record, Idx));
    }
    E.setOperatorLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 548,
   FQN="clang::ASTStmtReader::VisitUnaryOperator", NM="_ZN5clang13ASTStmtReader18VisitUnaryOperatorEPNS_13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitUnaryOperatorEPNS_13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ E) {
    VisitExpr(E);
    E.setSubExpr(Reader.ReadSubExpr());
    E.setOpcode(UnaryOperatorKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    E.setOperatorLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 852,
   FQN="clang::ASTStmtReader::VisitVAArgExpr", NM="_ZN5clang13ASTStmtReader14VisitVAArgExprEPNS_9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitVAArgExprEPNS_9VAArgExprE")
  //</editor-fold>
  public void VisitVAArgExpr(VAArgExpr /*P*/ E) {
    VisitExpr(E);
    E.setSubExpr(Reader.ReadSubExpr());
    E.setWrittenTypeInfo(GetTypeSourceInfo(Record, Idx));
    E.setBuiltinLoc(ReadSourceLocation(Record, Idx));
    E.setRParenLoc(ReadSourceLocation(Record, Idx));
    E.setIsMicrosoftABI((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 240,
   FQN="clang::ASTStmtReader::VisitForStmt", NM="_ZN5clang13ASTStmtReader12VisitForStmtEPNS_7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader12VisitForStmtEPNS_7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(ForStmt /*P*/ S) {
    VisitStmt(S);
    S.setInit(Reader.ReadSubStmt());
    S.setCond(Reader.ReadSubExpr());
    S.setConditionVariable(Reader.getContext(), 
        this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
    S.setInc(Reader.ReadSubExpr());
    S.setBody(Reader.ReadSubStmt());
    S.setForLoc(ReadSourceLocation(Record, Idx));
    S.setLParenLoc(ReadSourceLocation(Record, Idx));
    S.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 253,
   FQN="clang::ASTStmtReader::VisitGotoStmt", NM="_ZN5clang13ASTStmtReader13VisitGotoStmtEPNS_8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitGotoStmtEPNS_8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(GotoStmt /*P*/ S) {
    VisitStmt(S);
    S.setLabel(this.<LabelDecl>ReadDeclAs(LabelDecl.class, Record, Idx));
    S.setGotoLoc(ReadSourceLocation(Record, Idx));
    S.setLabelLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 185,
   FQN="clang::ASTStmtReader::VisitIfStmt", NM="_ZN5clang13ASTStmtReader11VisitIfStmtEPNS_6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader11VisitIfStmtEPNS_6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(IfStmt /*P*/ S) {
    VisitStmt(S);
    S.setConstexpr((Record.$at$Const(Idx.$set$postInc()) != 0));
    S.setInit(Reader.ReadSubStmt());
    S.setConditionVariable(Reader.getContext(), 
        this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
    S.setCond(Reader.ReadSubExpr());
    S.setThen(Reader.ReadSubStmt());
    S.setElse(Reader.ReadSubStmt());
    S.setIfLoc(ReadSourceLocation(Record, Idx));
    S.setElseLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 260,
   FQN="clang::ASTStmtReader::VisitIndirectGotoStmt", NM="_ZN5clang13ASTStmtReader21VisitIndirectGotoStmtEPNS_16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitIndirectGotoStmtEPNS_16IndirectGotoStmtE")
  //</editor-fold>
  public void VisitIndirectGotoStmt(IndirectGotoStmt /*P*/ S) {
    VisitStmt(S);
    S.setGotoLoc(ReadSourceLocation(Record, Idx));
    S.setStarLoc(ReadSourceLocation(Record, Idx));
    S.setTarget(Reader.ReadSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 163,
   FQN="clang::ASTStmtReader::VisitLabelStmt", NM="_ZN5clang13ASTStmtReader14VisitLabelStmtEPNS_9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitLabelStmtEPNS_9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(LabelStmt /*P*/ S) {
    VisitStmt(S);
    LabelDecl /*P*/ LD = this.<LabelDecl>ReadDeclAs(LabelDecl.class, Record, Idx);
    LD.setStmt(S);
    S.setDecl(LD);
    S.setSubStmt(Reader.ReadSubStmt());
    S.setIdentLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitMSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1229,
   FQN="clang::ASTStmtReader::VisitMSDependentExistsStmt", NM="_ZN5clang13ASTStmtReader26VisitMSDependentExistsStmtEPNS_21MSDependentExistsStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitMSDependentExistsStmtEPNS_21MSDependentExistsStmtE")
  //</editor-fold>
  public void VisitMSDependentExistsStmt(MSDependentExistsStmt /*P*/ S) {
    VisitStmt(S);
    S.KeywordLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.IsIfExists = (Record.$at$Const(Idx.$set$postInc()) != 0);
    S.QualifierLoc.$assignMove(Reader.ReadNestedNameSpecifierLoc(F, Record, Idx));
    ReadDeclarationNameInfo(S.NameInfo, Record, Idx);
    S.SubStmt = Reader.ReadSubStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitNullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 126,
   FQN="clang::ASTStmtReader::VisitNullStmt", NM="_ZN5clang13ASTStmtReader13VisitNullStmtEPNS_8NullStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitNullStmtEPNS_8NullStmtE")
  //</editor-fold>
  public void VisitNullStmt(NullStmt /*P*/ S) {
    VisitStmt(S);
    S.setSemiLoc(ReadSourceLocation(Record, Idx));
    S.HasLeadingEmptyMacro = (Record.$at$Const(Idx.$set$postInc()) != 0);
  }

  
  //===----------------------------------------------------------------------===//
  // OpenMP Directives.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2483,
   FQN="clang::ASTStmtReader::VisitOMPExecutableDirective", NM="_ZN5clang13ASTStmtReader27VisitOMPExecutableDirectiveEPNS_22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitOMPExecutableDirectiveEPNS_22OMPExecutableDirectiveE")
  //</editor-fold>
  public void VisitOMPExecutableDirective(OMPExecutableDirective /*P*/ E) {
    E.setLocStart(ReadSourceLocation(Record, Idx));
    E.setLocEnd(ReadSourceLocation(Record, Idx));
    OMPClauseReader ClauseReader/*J*/= new OMPClauseReader(this, Reader.getContext(), Record, Idx);
    SmallVector<OMPClause /*P*/ > Clauses/*J*/= new SmallVector<OMPClause /*P*/ >(5, (OMPClause /*P*/ )null);
    for (/*uint*/int i = 0; $less_uint(i, E.getNumClauses()); ++i)  {
      Clauses.push_back(ClauseReader.readClause());
    }
    E.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses, true));
    if (E.hasAssociatedStmt()) {
      E.setAssociatedStmt(Reader.ReadSubStmt());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPAtomicDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2664,
   FQN="clang::ASTStmtReader::VisitOMPAtomicDirective", NM="_ZN5clang13ASTStmtReader23VisitOMPAtomicDirectiveEPNS_18OMPAtomicDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitOMPAtomicDirectiveEPNS_18OMPAtomicDirectiveE")
  //</editor-fold>
  public void VisitOMPAtomicDirective(OMPAtomicDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    D.setX(Reader.ReadSubExpr());
    D.setV(Reader.ReadSubExpr());
    D.setExpr(Reader.ReadSubExpr());
    D.setUpdateExpr(Reader.ReadSubExpr());
    D.IsXLHSInRHSPart = Record.$at$Const(Idx.$set$postInc()) != $int2ullong(0);
    D.IsPostfixUpdate = Record.$at$Const(Idx.$set$postInc()) != $int2ullong(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPBarrierDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2635,
   FQN="clang::ASTStmtReader::VisitOMPBarrierDirective", NM="_ZN5clang13ASTStmtReader24VisitOMPBarrierDirectiveEPNS_19OMPBarrierDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitOMPBarrierDirectiveEPNS_19OMPBarrierDirectiveE")
  //</editor-fold>
  public void VisitOMPBarrierDirective(OMPBarrierDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPCancelDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2731,
   FQN="clang::ASTStmtReader::VisitOMPCancelDirective", NM="_ZN5clang13ASTStmtReader23VisitOMPCancelDirectiveEPNS_18OMPCancelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitOMPCancelDirectiveEPNS_18OMPCancelDirectiveE")
  //</editor-fold>
  public void VisitOMPCancelDirective(OMPCancelDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    D.setCancelRegion(/*static_cast*/OpenMPDirectiveKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPCancellationPointDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2724,
   FQN="clang::ASTStmtReader::VisitOMPCancellationPointDirective", NM="_ZN5clang13ASTStmtReader34VisitOMPCancellationPointDirectiveEPNS_29OMPCancellationPointDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader34VisitOMPCancellationPointDirectiveEPNS_29OMPCancellationPointDirectiveE")
  //</editor-fold>
  public void VisitOMPCancellationPointDirective(OMPCancellationPointDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    D.setCancelRegion(/*static_cast*/OpenMPDirectiveKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPCriticalDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2595,
   FQN="clang::ASTStmtReader::VisitOMPCriticalDirective", NM="_ZN5clang13ASTStmtReader25VisitOMPCriticalDirectiveEPNS_20OMPCriticalDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitOMPCriticalDirectiveEPNS_20OMPCriticalDirectiveE")
  //</editor-fold>
  public void VisitOMPCriticalDirective(OMPCriticalDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    ReadDeclarationNameInfo(D.DirName, Record, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPFlushDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2650,
   FQN="clang::ASTStmtReader::VisitOMPFlushDirective", NM="_ZN5clang13ASTStmtReader22VisitOMPFlushDirectiveEPNS_17OMPFlushDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitOMPFlushDirectiveEPNS_17OMPFlushDirectiveE")
  //</editor-fold>
  public void VisitOMPFlushDirective(OMPFlushDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2495,
   FQN="clang::ASTStmtReader::VisitOMPLoopDirective", NM="_ZN5clang13ASTStmtReader21VisitOMPLoopDirectiveEPNS_16OMPLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitOMPLoopDirectiveEPNS_16OMPLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPLoopDirective(OMPLoopDirective /*P*/ D) {
    VisitStmt(D);
    // Two fields (NumClauses and CollapsedNum) were read in ReadStmtFromStream.
    Idx.$set$addassign(2);
    VisitOMPExecutableDirective(D);
    D.setIterationVariable(Reader.ReadSubExpr());
    D.setLastIteration(Reader.ReadSubExpr());
    D.setCalcLastIteration(Reader.ReadSubExpr());
    D.setPreCond(Reader.ReadSubExpr());
    D.setCond(Reader.ReadSubExpr());
    D.setInit(Reader.ReadSubExpr());
    D.setInc(Reader.ReadSubExpr());
    D.setPreInits(Reader.ReadSubStmt());
    if (isOpenMPWorksharingDirective(D.getDirectiveKind())
       || isOpenMPTaskLoopDirective(D.getDirectiveKind())
       || isOpenMPDistributeDirective(D.getDirectiveKind())) {
      D.setIsLastIterVariable(Reader.ReadSubExpr());
      D.setLowerBoundVariable(Reader.ReadSubExpr());
      D.setUpperBoundVariable(Reader.ReadSubExpr());
      D.setStrideVariable(Reader.ReadSubExpr());
      D.setEnsureUpperBound(Reader.ReadSubExpr());
      D.setNextLowerBound(Reader.ReadSubExpr());
      D.setNextUpperBound(Reader.ReadSubExpr());
      D.setNumIterations(Reader.ReadSubExpr());
    }
    if (isOpenMPLoopBoundSharingDirective(D.getDirectiveKind())) {
      D.setPrevLowerBoundVariable(Reader.ReadSubExpr());
      D.setPrevUpperBoundVariable(Reader.ReadSubExpr());
    }
    SmallVector<Expr /*P*/ > Sub/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    /*uint*/int CollapsedNum = D.getCollapsedNumber();
    Sub.reserve(CollapsedNum);
    for (/*uint*/int i = 0; $less_uint(i, CollapsedNum); ++i)  {
      Sub.push_back(Reader.ReadSubExpr());
    }
    D.setCounters(new ArrayRef<Expr /*P*/ >(Sub, true));
    Sub.clear();
    for (/*uint*/int i = 0; $less_uint(i, CollapsedNum); ++i)  {
      Sub.push_back(Reader.ReadSubExpr());
    }
    D.setPrivateCounters(new ArrayRef<Expr /*P*/ >(Sub, true));
    Sub.clear();
    for (/*uint*/int i = 0; $less_uint(i, CollapsedNum); ++i)  {
      Sub.push_back(Reader.ReadSubExpr());
    }
    D.setInits(new ArrayRef<Expr /*P*/ >(Sub, true));
    Sub.clear();
    for (/*uint*/int i = 0; $less_uint(i, CollapsedNum); ++i)  {
      Sub.push_back(Reader.ReadSubExpr());
    }
    D.setUpdates(new ArrayRef<Expr /*P*/ >(Sub, true));
    Sub.clear();
    for (/*uint*/int i = 0; $less_uint(i, CollapsedNum); ++i)  {
      Sub.push_back(Reader.ReadSubExpr());
    }
    D.setFinals(new ArrayRef<Expr /*P*/ >(Sub, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPDistributeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2747,
   FQN="clang::ASTStmtReader::VisitOMPDistributeDirective", NM="_ZN5clang13ASTStmtReader27VisitOMPDistributeDirectiveEPNS_22OMPDistributeDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitOMPDistributeDirectiveEPNS_22OMPDistributeDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeDirective(OMPDistributeDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2756,
   FQN="clang::ASTStmtReader::VisitOMPDistributeParallelForDirective", NM="_ZN5clang13ASTStmtReader38VisitOMPDistributeParallelForDirectiveEPNS_33OMPDistributeParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader38VisitOMPDistributeParallelForDirectiveEPNS_33OMPDistributeParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForDirective(OMPDistributeParallelForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPDistributeParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2761,
   FQN="clang::ASTStmtReader::VisitOMPDistributeParallelForSimdDirective", NM="_ZN5clang13ASTStmtReader42VisitOMPDistributeParallelForSimdDirectiveEPNS_37OMPDistributeParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader42VisitOMPDistributeParallelForSimdDirectiveEPNS_37OMPDistributeParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeParallelForSimdDirective(OMPDistributeParallelForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPDistributeSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2766,
   FQN="clang::ASTStmtReader::VisitOMPDistributeSimdDirective", NM="_ZN5clang13ASTStmtReader31VisitOMPDistributeSimdDirectiveEPNS_26OMPDistributeSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader31VisitOMPDistributeSimdDirectiveEPNS_26OMPDistributeSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPDistributeSimdDirective(OMPDistributeSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2560,
   FQN="clang::ASTStmtReader::VisitOMPForDirective", NM="_ZN5clang13ASTStmtReader20VisitOMPForDirectiveEPNS_15OMPForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitOMPForDirectiveEPNS_15OMPForDirectiveE")
  //</editor-fold>
  public void VisitOMPForDirective(OMPForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2565,
   FQN="clang::ASTStmtReader::VisitOMPForSimdDirective", NM="_ZN5clang13ASTStmtReader24VisitOMPForSimdDirectiveEPNS_19OMPForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitOMPForSimdDirectiveEPNS_19OMPForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPForSimdDirective(OMPForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2603,
   FQN="clang::ASTStmtReader::VisitOMPParallelForDirective", NM="_ZN5clang13ASTStmtReader28VisitOMPParallelForDirectiveEPNS_23OMPParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader28VisitOMPParallelForDirectiveEPNS_23OMPParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForDirective(OMPParallelForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2608,
   FQN="clang::ASTStmtReader::VisitOMPParallelForSimdDirective", NM="_ZN5clang13ASTStmtReader32VisitOMPParallelForSimdDirectiveEPNS_27OMPParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader32VisitOMPParallelForSimdDirectiveEPNS_27OMPParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelForSimdDirective(OMPParallelForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2556,
   FQN="clang::ASTStmtReader::VisitOMPSimdDirective", NM="_ZN5clang13ASTStmtReader21VisitOMPSimdDirectiveEPNS_16OMPSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitOMPSimdDirectiveEPNS_16OMPSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPSimdDirective(OMPSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetParallelForSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2771,
   FQN="clang::ASTStmtReader::VisitOMPTargetParallelForSimdDirective", NM="_ZN5clang13ASTStmtReader38VisitOMPTargetParallelForSimdDirectiveEPNS_33OMPTargetParallelForSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader38VisitOMPTargetParallelForSimdDirectiveEPNS_33OMPTargetParallelForSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForSimdDirective(OMPTargetParallelForSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTaskLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2739,
   FQN="clang::ASTStmtReader::VisitOMPTaskLoopDirective", NM="_ZN5clang13ASTStmtReader25VisitOMPTaskLoopDirectiveEPNS_20OMPTaskLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitOMPTaskLoopDirectiveEPNS_20OMPTaskLoopDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopDirective(OMPTaskLoopDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTaskLoopSimdDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2743,
   FQN="clang::ASTStmtReader::VisitOMPTaskLoopSimdDirective", NM="_ZN5clang13ASTStmtReader29VisitOMPTaskLoopSimdDirectiveEPNS_24OMPTaskLoopSimdDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader29VisitOMPTaskLoopSimdDirectiveEPNS_24OMPTaskLoopSimdDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskLoopSimdDirective(OMPTaskLoopSimdDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPMasterDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2590,
   FQN="clang::ASTStmtReader::VisitOMPMasterDirective", NM="_ZN5clang13ASTStmtReader23VisitOMPMasterDirectiveEPNS_18OMPMasterDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitOMPMasterDirectiveEPNS_18OMPMasterDirectiveE")
  //</editor-fold>
  public void VisitOMPMasterDirective(OMPMasterDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPOrderedDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2657,
   FQN="clang::ASTStmtReader::VisitOMPOrderedDirective", NM="_ZN5clang13ASTStmtReader24VisitOMPOrderedDirectiveEPNS_19OMPOrderedDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitOMPOrderedDirectiveEPNS_19OMPOrderedDirectiveE")
  //</editor-fold>
  public void VisitOMPOrderedDirective(OMPOrderedDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2548,
   FQN="clang::ASTStmtReader::VisitOMPParallelDirective", NM="_ZN5clang13ASTStmtReader25VisitOMPParallelDirectiveEPNS_20OMPParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitOMPParallelDirectiveEPNS_20OMPParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelDirective(OMPParallelDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPParallelSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2613,
   FQN="clang::ASTStmtReader::VisitOMPParallelSectionsDirective", NM="_ZN5clang13ASTStmtReader33VisitOMPParallelSectionsDirectiveEPNS_28OMPParallelSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader33VisitOMPParallelSectionsDirectiveEPNS_28OMPParallelSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPParallelSectionsDirective(OMPParallelSectionsDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPSectionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2577,
   FQN="clang::ASTStmtReader::VisitOMPSectionDirective", NM="_ZN5clang13ASTStmtReader24VisitOMPSectionDirectiveEPNS_19OMPSectionDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader24VisitOMPSectionDirectiveEPNS_19OMPSectionDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionDirective(OMPSectionDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPSectionsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2569,
   FQN="clang::ASTStmtReader::VisitOMPSectionsDirective", NM="_ZN5clang13ASTStmtReader25VisitOMPSectionsDirectiveEPNS_20OMPSectionsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitOMPSectionsDirectiveEPNS_20OMPSectionsDirectiveE")
  //</editor-fold>
  public void VisitOMPSectionsDirective(OMPSectionsDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPSingleDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2583,
   FQN="clang::ASTStmtReader::VisitOMPSingleDirective", NM="_ZN5clang13ASTStmtReader23VisitOMPSingleDirectiveEPNS_18OMPSingleDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitOMPSingleDirectiveEPNS_18OMPSingleDirectiveE")
  //</editor-fold>
  public void VisitOMPSingleDirective(OMPSingleDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2684,
   FQN="clang::ASTStmtReader::VisitOMPTargetDataDirective", NM="_ZN5clang13ASTStmtReader27VisitOMPTargetDataDirectiveEPNS_22OMPTargetDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitOMPTargetDataDirectiveEPNS_22OMPTargetDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDataDirective(OMPTargetDataDirective /*P*/ D) {
    VisitStmt(D);
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2677,
   FQN="clang::ASTStmtReader::VisitOMPTargetDirective", NM="_ZN5clang13ASTStmtReader23VisitOMPTargetDirectiveEPNS_18OMPTargetDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader23VisitOMPTargetDirectiveEPNS_18OMPTargetDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetDirective(OMPTargetDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetEnterDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2690,
   FQN="clang::ASTStmtReader::VisitOMPTargetEnterDataDirective", NM="_ZN5clang13ASTStmtReader32VisitOMPTargetEnterDataDirectiveEPNS_27OMPTargetEnterDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader32VisitOMPTargetEnterDataDirectiveEPNS_27OMPTargetEnterDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetEnterDataDirective(OMPTargetEnterDataDirective /*P*/ D) {
    VisitStmt(D);
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetExitDataDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2697,
   FQN="clang::ASTStmtReader::VisitOMPTargetExitDataDirective", NM="_ZN5clang13ASTStmtReader31VisitOMPTargetExitDataDirectiveEPNS_26OMPTargetExitDataDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader31VisitOMPTargetExitDataDirectiveEPNS_26OMPTargetExitDataDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetExitDataDirective(OMPTargetExitDataDirective /*P*/ D) {
    VisitStmt(D);
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetParallelDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2704,
   FQN="clang::ASTStmtReader::VisitOMPTargetParallelDirective", NM="_ZN5clang13ASTStmtReader31VisitOMPTargetParallelDirectiveEPNS_26OMPTargetParallelDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader31VisitOMPTargetParallelDirectiveEPNS_26OMPTargetParallelDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelDirective(OMPTargetParallelDirective /*P*/ D) {
    VisitStmt(D);
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetParallelForDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2711,
   FQN="clang::ASTStmtReader::VisitOMPTargetParallelForDirective", NM="_ZN5clang13ASTStmtReader34VisitOMPTargetParallelForDirectiveEPNS_29OMPTargetParallelForDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader34VisitOMPTargetParallelForDirectiveEPNS_29OMPTargetParallelForDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetParallelForDirective(OMPTargetParallelForDirective /*P*/ D) {
    VisitOMPLoopDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTargetUpdateDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2751,
   FQN="clang::ASTStmtReader::VisitOMPTargetUpdateDirective", NM="_ZN5clang13ASTStmtReader29VisitOMPTargetUpdateDirectiveEPNS_24OMPTargetUpdateDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader29VisitOMPTargetUpdateDirectiveEPNS_24OMPTargetUpdateDirectiveE")
  //</editor-fold>
  public void VisitOMPTargetUpdateDirective(OMPTargetUpdateDirective /*P*/ D) {
    VisitStmt(D);
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTaskDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2622,
   FQN="clang::ASTStmtReader::VisitOMPTaskDirective", NM="_ZN5clang13ASTStmtReader21VisitOMPTaskDirectiveEPNS_16OMPTaskDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader21VisitOMPTaskDirectiveEPNS_16OMPTaskDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskDirective(OMPTaskDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
    D.setHasCancel((Record.$at$Const(Idx.$set$postInc()) != 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTaskgroupDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2645,
   FQN="clang::ASTStmtReader::VisitOMPTaskgroupDirective", NM="_ZN5clang13ASTStmtReader26VisitOMPTaskgroupDirectiveEPNS_21OMPTaskgroupDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitOMPTaskgroupDirectiveEPNS_21OMPTaskgroupDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskgroupDirective(OMPTaskgroupDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTaskwaitDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2640,
   FQN="clang::ASTStmtReader::VisitOMPTaskwaitDirective", NM="_ZN5clang13ASTStmtReader25VisitOMPTaskwaitDirectiveEPNS_20OMPTaskwaitDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader25VisitOMPTaskwaitDirectiveEPNS_20OMPTaskwaitDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskwaitDirective(OMPTaskwaitDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTaskyieldDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2630,
   FQN="clang::ASTStmtReader::VisitOMPTaskyieldDirective", NM="_ZN5clang13ASTStmtReader26VisitOMPTaskyieldDirectiveEPNS_21OMPTaskyieldDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitOMPTaskyieldDirectiveEPNS_21OMPTaskyieldDirectiveE")
  //</editor-fold>
  public void VisitOMPTaskyieldDirective(OMPTaskyieldDirective /*P*/ D) {
    VisitStmt(D);
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitOMPTeamsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2717,
   FQN="clang::ASTStmtReader::VisitOMPTeamsDirective", NM="_ZN5clang13ASTStmtReader22VisitOMPTeamsDirectiveEPNS_17OMPTeamsDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitOMPTeamsDirectiveEPNS_17OMPTeamsDirectiveE")
  //</editor-fold>
  public void VisitOMPTeamsDirective(OMPTeamsDirective /*P*/ D) {
    VisitStmt(D);
    // The NumClauses field was read in ReadStmtFromStream.
    Idx.$set$preInc();
    VisitOMPExecutableDirective(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1132,
   FQN="clang::ASTStmtReader::VisitObjCAtCatchStmt", NM="_ZN5clang13ASTStmtReader20VisitObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE")
  //</editor-fold>
  public void VisitObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ S) {
    VisitStmt(S);
    S.setCatchBody(Reader.ReadSubStmt());
    S.setCatchParamDecl(this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
    S.setAtCatchLoc(ReadSourceLocation(Record, Idx));
    S.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1140,
   FQN="clang::ASTStmtReader::VisitObjCAtFinallyStmt", NM="_ZN5clang13ASTStmtReader22VisitObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader22VisitObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE")
  //</editor-fold>
  public void VisitObjCAtFinallyStmt(ObjCAtFinallyStmt /*P*/ S) {
    VisitStmt(S);
    S.setFinallyBody(Reader.ReadSubStmt());
    S.setAtFinallyLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1166,
   FQN="clang::ASTStmtReader::VisitObjCAtSynchronizedStmt", NM="_ZN5clang13ASTStmtReader27VisitObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader27VisitObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public void VisitObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S) {
    VisitStmt(S);
    S.setSynchExpr(Reader.ReadSubStmt());
    S.setSynchBody(Reader.ReadSubStmt());
    S.setAtSynchronizedLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1173,
   FQN="clang::ASTStmtReader::VisitObjCAtThrowStmt", NM="_ZN5clang13ASTStmtReader20VisitObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader20VisitObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE")
  //</editor-fold>
  public void VisitObjCAtThrowStmt(ObjCAtThrowStmt /*P*/ S) {
    VisitStmt(S);
    S.setThrowExpr(Reader.ReadSubStmt());
    S.setThrowLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1152,
   FQN="clang::ASTStmtReader::VisitObjCAtTryStmt", NM="_ZN5clang13ASTStmtReader18VisitObjCAtTryStmtEPNS_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitObjCAtTryStmtEPNS_13ObjCAtTryStmtE")
  //</editor-fold>
  public void VisitObjCAtTryStmt(ObjCAtTryStmt /*P*/ S) {
    VisitStmt(S);
    assert (Record.$at$Const(Idx.$deref()) == $uint2ullong(S.getNumCatchStmts()));
    Idx.$set$preInc();
    boolean HasFinally = (Record.$at$Const(Idx.$set$postInc()) != 0);
    S.setTryBody(Reader.ReadSubStmt());
    for (/*uint*/int I = 0, N = S.getNumCatchStmts(); I != N; ++I)  {
      S.setCatchStmt(I, cast_or_null_ObjCAtCatchStmt(Reader.ReadSubStmt()));
    }
    if (HasFinally) {
      S.setFinallyStmt(Reader.ReadSubStmt());
    }
    S.setAtTryLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1146,
   FQN="clang::ASTStmtReader::VisitObjCAutoreleasePoolStmt", NM="_ZN5clang13ASTStmtReader28VisitObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader28VisitObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public void VisitObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ S) {
    VisitStmt(S);
    S.setSubStmt(Reader.ReadSubStmt());
    S.setAtLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1123,
   FQN="clang::ASTStmtReader::VisitObjCForCollectionStmt", NM="_ZN5clang13ASTStmtReader26VisitObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader26VisitObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S) {
    VisitStmt(S);
    S.setElement(Reader.ReadSubStmt());
    S.setCollection(Reader.ReadSubExpr());
    S.setBody(Reader.ReadSubStmt());
    S.setForLoc(ReadSourceLocation(Record, Idx));
    S.setRParenLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 277,
   FQN="clang::ASTStmtReader::VisitReturnStmt", NM="_ZN5clang13ASTStmtReader15VisitReturnStmtEPNS_10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitReturnStmtEPNS_10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(ReturnStmt /*P*/ S) {
    VisitStmt(S);
    S.setRetValue(Reader.ReadSubExpr());
    S.setReturnLoc(ReadSourceLocation(Record, Idx));
    S.setNRVOCandidate(this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSEHExceptStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1720,
   FQN="clang::ASTStmtReader::VisitSEHExceptStmt", NM="_ZN5clang13ASTStmtReader18VisitSEHExceptStmtEPNS_13SEHExceptStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader18VisitSEHExceptStmtEPNS_13SEHExceptStmtE")
  //</editor-fold>
  public void VisitSEHExceptStmt(SEHExceptStmt /*P*/ S) {
    VisitStmt(S);
    S.Loc.$assignMove(ReadSourceLocation(Record, Idx));
    S.Children[SEHExceptStmt.Unnamed_enum.FILTER_EXPR.getValue()] = Reader.ReadSubStmt();
    S.Children[SEHExceptStmt.Unnamed_enum.BLOCK.getValue()] = Reader.ReadSubStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSEHFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1727,
   FQN="clang::ASTStmtReader::VisitSEHFinallyStmt", NM="_ZN5clang13ASTStmtReader19VisitSEHFinallyStmtEPNS_14SEHFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader19VisitSEHFinallyStmtEPNS_14SEHFinallyStmtE")
  //</editor-fold>
  public void VisitSEHFinallyStmt(SEHFinallyStmt /*P*/ S) {
    VisitStmt(S);
    S.Loc.$assignMove(ReadSourceLocation(Record, Idx));
    S.Block = Reader.ReadSubStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSEHLeaveStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1715,
   FQN="clang::ASTStmtReader::VisitSEHLeaveStmt", NM="_ZN5clang13ASTStmtReader17VisitSEHLeaveStmtEPNS_12SEHLeaveStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader17VisitSEHLeaveStmtEPNS_12SEHLeaveStmtE")
  //</editor-fold>
  public void VisitSEHLeaveStmt(SEHLeaveStmt /*P*/ S) {
    VisitStmt(S);
    S.setLeaveLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSEHTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 1733,
   FQN="clang::ASTStmtReader::VisitSEHTryStmt", NM="_ZN5clang13ASTStmtReader15VisitSEHTryStmtEPNS_10SEHTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitSEHTryStmtEPNS_10SEHTryStmtE")
  //</editor-fold>
  public void VisitSEHTryStmt(SEHTryStmt /*P*/ S) {
    VisitStmt(S);
    S.IsCXXTry = (Record.$at$Const(Idx.$set$postInc()) != 0);
    S.TryLoc.$assignMove(ReadSourceLocation(Record, Idx));
    S.Children[SEHTryStmt.Unnamed_enum.TRY.getValue()] = Reader.ReadSubStmt();
    S.Children[SEHTryStmt.Unnamed_enum.HANDLER.getValue()] = Reader.ReadSubStmt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 143,
   FQN="clang::ASTStmtReader::VisitSwitchCase", NM="_ZN5clang13ASTStmtReader15VisitSwitchCaseEPNS_10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitSwitchCaseEPNS_10SwitchCaseE")
  //</editor-fold>
  public void VisitSwitchCase(SwitchCase /*P*/ S) {
    VisitStmt(S);
    Reader.RecordSwitchCaseID(S, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    S.setKeywordLoc(ReadSourceLocation(Record, Idx));
    S.setColonLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 150,
   FQN="clang::ASTStmtReader::VisitCaseStmt", NM="_ZN5clang13ASTStmtReader13VisitCaseStmtEPNS_8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader13VisitCaseStmtEPNS_8CaseStmtE")
  //</editor-fold>
  public void VisitCaseStmt(CaseStmt /*P*/ S) {
    VisitSwitchCase(S);
    S.setLHS(Reader.ReadSubExpr());
    S.setRHS(Reader.ReadSubExpr());
    S.setSubStmt(Reader.ReadSubStmt());
    S.setEllipsisLoc(ReadSourceLocation(Record, Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 158,
   FQN="clang::ASTStmtReader::VisitDefaultStmt", NM="_ZN5clang13ASTStmtReader16VisitDefaultStmtEPNS_11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader16VisitDefaultStmtEPNS_11DefaultStmtE")
  //</editor-fold>
  public void VisitDefaultStmt(DefaultStmt /*P*/ S) {
    VisitSwitchCase(S);
    S.setSubStmt(Reader.ReadSubStmt());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 198,
   FQN="clang::ASTStmtReader::VisitSwitchStmt", NM="_ZN5clang13ASTStmtReader15VisitSwitchStmtEPNS_10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader15VisitSwitchStmtEPNS_10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(SwitchStmt /*P*/ S) {
    VisitStmt(S);
    S.setInit(Reader.ReadSubStmt());
    S.setConditionVariable(Reader.getContext(), 
        this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
    S.setCond(Reader.ReadSubExpr());
    S.setBody(Reader.ReadSubStmt());
    S.setSwitchLoc(ReadSourceLocation(Record, Idx));
    if ((Record.$at$Const(Idx.$set$postInc()) != 0)) {
      S.setAllEnumCasesCovered();
    }
    
    SwitchCase /*P*/ PrevSC = null;
    for (/*uint*/int N = Record.size(); Idx.$deref() != N; Idx.$set$preInc()) {
      SwitchCase /*P*/ SC = Reader.getSwitchCaseWithID($ullong2uint(Record.$at$Const(Idx.$deref())));
      if ((PrevSC != null)) {
        PrevSC.setNextSwitchCase(SC);
      } else {
        S.setSwitchCaseList(SC);
      }
      
      PrevSC = SC;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTStmtReader::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 221,
   FQN="clang::ASTStmtReader::VisitWhileStmt", NM="_ZN5clang13ASTStmtReader14VisitWhileStmtEPNS_9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang13ASTStmtReader14VisitWhileStmtEPNS_9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(WhileStmt /*P*/ S) {
    VisitStmt(S);
    S.setConditionVariable(Reader.getContext(), 
        this.<VarDecl>ReadDeclAs(VarDecl.class, Record, Idx));
    
    S.setCond(Reader.ReadSubExpr());
    S.setBody(Reader.ReadSubStmt());
    S.setWhileLoc(ReadSourceLocation(Record, Idx));
  }

  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", F=" + F // NOI18N
              + ", DeclsCursor=" + DeclsCursor // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Idx=" + Idx // NOI18N
              + super.toString(); // NOI18N
  }
}
