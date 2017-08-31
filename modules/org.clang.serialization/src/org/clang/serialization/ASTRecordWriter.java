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

package org.clang.serialization;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.serialization.impl.ASTWriterStatics.*;


/// \brief An object for streaming information to a record.
//<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 693,
 FQN="clang::ASTRecordWriter", NM="_ZN5clang15ASTRecordWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriterE")
//</editor-fold>
public class ASTRecordWriter implements Destructors.ClassWithDestructor {
  private ASTWriter /*P*/ Writer;
  private SmallVectorImplULong /*P*/ Record;
  
  /// \brief Statements that we've encountered while serializing a
  /// declaration or type.
  private SmallVector<Stmt /*P*/ > StmtsToEmit;
  
  /// \brief Indices of record elements that describe offsets within the
  /// bitcode. These will be converted to offsets relative to the current
  /// record when emitted.
  private SmallVectorUInt OffsetIndices;
  
  /// \brief Flush all of the statements and expressions that have
  /// been added to the queue via AddStmt().
  
  /// \brief Flush all of the statements and expressions that have
  /// been added to the queue via AddStmt().
  
  /// \brief Flush all of the statements that have been added to the
  /// queue via AddStmt().
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::FlushStmts">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2550,
   FQN="clang::ASTRecordWriter::FlushStmts", NM="_ZN5clang15ASTRecordWriter10FlushStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15ASTRecordWriter10FlushStmtsEv")
  //</editor-fold>
  private void FlushStmts() {
    // We expect to be the only consumer of the two temporary statement maps,
    // assert that they are empty.
    assert (Writer.SubStmtEntries.empty()) : "unexpected entries in sub-stmt map";
    assert (Writer.ParentStmts.empty()) : "unexpected entries in parent stmt map";
    
    for (/*uint*/int I = 0, N = StmtsToEmit.size(); I != N; ++I) {
      Writer.WriteSubStmt(StmtsToEmit.$at(I));
      assert (N == StmtsToEmit.size()) : "record modified while being written!";
      
      // Note that we are at the end of a full expression. Any
      // expression records that follow this one are part of a different
      // expression.
      Writer.Stream.EmitRecord(StmtCode.STMT_STOP, new ArrayRefUInt());
      
      Writer.SubStmtEntries.clear();
      Writer.ParentStmts.clear();
    }
    
    StmtsToEmit.clear();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::FlushSubStmts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2573,
   FQN="clang::ASTRecordWriter::FlushSubStmts", NM="_ZN5clang15ASTRecordWriter13FlushSubStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15ASTRecordWriter13FlushSubStmtsEv")
  //</editor-fold>
  private void FlushSubStmts() {
    // For a nested statement, write out the substatements in reverse order (so
    // that a simple stack machine can be used when loading), and don't emit a
    // STMT_STOP after each one.
    for (/*uint*/int I = 0, N = StmtsToEmit.size(); I != N; ++I) {
      Writer.WriteSubStmt(StmtsToEmit.$at(N - I - 1));
      assert (N == StmtsToEmit.size()) : "record modified while being written!";
    }
    
    StmtsToEmit.clear();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::PrepareToEmit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 711,
   FQN="clang::ASTRecordWriter::PrepareToEmit", NM="_ZN5clang15ASTRecordWriter13PrepareToEmitEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter13PrepareToEmitEy")
  //</editor-fold>
  private void PrepareToEmit(long/*uint64_t*/ MyOffset) {
    // Convert offsets into relative form.
    for (/*uint*/int I : OffsetIndices) {
      final ulong$ref/*ullong &*/ StoredOffset = ($Deref(Record)).ref$at(I);
      assert ($less_ullong_ulong(StoredOffset.$deref(), MyOffset)) : "invalid offset";
      if ((StoredOffset.$deref() != 0)) {
        StoredOffset.$set(MyOffset - StoredOffset.$deref());
      }
    }
    OffsetIndices.clear();
  }

/*public:*/
  /// Construct a ASTRecordWriter that uses the default encoding scheme.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::ASTRecordWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 724,
   FQN="clang::ASTRecordWriter::ASTRecordWriter", NM="_ZN5clang15ASTRecordWriterC1ERNS_9ASTWriterERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriterC1ERNS_9ASTWriterERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public ASTRecordWriter(final ASTWriter /*&*/ Writer, final SmallVectorImplULong /*&*/ Record) {
    // : Writer(&Writer), Record(&Record), StmtsToEmit(), OffsetIndices() 
    //START JInit
    this.Writer = $AddrOf(Writer);
    this.Record = $AddrOf(Record);
    this.StmtsToEmit = new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    this.OffsetIndices = new SmallVectorUInt(8, 0);
    //END JInit
  }

  
  /// Construct a ASTRecordWriter that uses the same encoding scheme as another
  /// ASTRecordWriter.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::ASTRecordWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 729,
   FQN="clang::ASTRecordWriter::ASTRecordWriter", NM="_ZN5clang15ASTRecordWriterC1ERS0_RN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriterC1ERS0_RN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public ASTRecordWriter(final ASTRecordWriter /*&*/ Parent, final SmallVectorImplULong /*&*/ Record) {
    // : Writer(Parent.Writer), Record(&Record), StmtsToEmit(), OffsetIndices() 
    //START JInit
    this.Writer = Parent.Writer;
    this.Record = $AddrOf(Record);
    this.StmtsToEmit = new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    this.OffsetIndices = new SmallVectorUInt(8, 0);
    //END JInit
  }

  
  /// Copying an ASTRecordWriter is almost certainly a bug.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::ASTRecordWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 733,
   FQN="clang::ASTRecordWriter::ASTRecordWriter", NM="_ZN5clang15ASTRecordWriterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriterC1ERKS0_")
  //</editor-fold>
  public ASTRecordWriter(final /*const*/ ASTRecordWriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 734,
   FQN="clang::ASTRecordWriter::operator=", NM="_ZN5clang15ASTRecordWriteraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriteraSERKS0_")
  //</editor-fold>
  public void $assign(final /*const*/ ASTRecordWriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// \brief Extract the underlying record storage.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::getRecordData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 737,
   FQN="clang::ASTRecordWriter::getRecordData", NM="_ZNK5clang15ASTRecordWriter13getRecordDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang15ASTRecordWriter13getRecordDataEv")
  //</editor-fold>
  public SmallVectorImplULong /*&*/ getRecordData() /*const*/ {
    return $Deref(Record);
  }

  
  /// \brief Minimal vector-like interface.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 741,
   FQN="clang::ASTRecordWriter::push_back", NM="_ZN5clang15ASTRecordWriter9push_backEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter9push_backEy")
  //</editor-fold>
  public void push_back(long/*uint64_t*/ N) {
    Record.push_back(N);
  }

  /*template <typename InputIterator> TEMPLATE*/
  //template <typename InputIterator = const unsigned int *> 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::append">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 743,
   FQN="clang::ASTRecordWriter::append", NM="_ZN5clang15ASTRecordWriter6appendIPKjEEvT_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang15ASTRecordWriter6appendIPKjEEvT_S4_")
  //</editor-fold>
  public void append(/*const*/uint$ptr/*uint P*/ begin, /*const*/uint$ptr/*uint P*/ end) {
    Record.append_T(begin, end);
  }
  public void append(/*const*/char$ptr/*uint P*/ begin, /*const*/char$ptr/*uint P*/ end) {
    Record.append_T(begin, end);
  }
//  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::append">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 743,
//   FQN="clang::ASTRecordWriter::append", NM="Tpl__ZN5clang15ASTRecordWriter6appendET_S1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=Tpl__ZN5clang15ASTRecordWriter6appendET_S1_")
//  //</editor-fold>
//  public </*typename*/ InputIterator> void append(InputIterator begin, InputIterator end) {
//    Record.append(begin, end);
//  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 746,
   FQN="clang::ASTRecordWriter::empty", NM="_ZNK5clang15ASTRecordWriter5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang15ASTRecordWriter5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Record.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 747,
   FQN="clang::ASTRecordWriter::size", NM="_ZNK5clang15ASTRecordWriter4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang15ASTRecordWriter4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Record.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 748,
   FQN="clang::ASTRecordWriter::operator[]", NM="_ZN5clang15ASTRecordWriterixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriterixEj")
  //</editor-fold>
  public ulong$ref/*uint64_t &*/ $at(/*size_t*/int N) {
    return Record.ref$at(N);
  }

  /// @}
  
  /// \brief Emit the record to the stream, followed by its substatements, and
  /// return its offset.
  // FIXME: Allow record producers to suggest Abbrevs.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 754,
   FQN="clang::ASTRecordWriter::Emit", NM="_ZN5clang15ASTRecordWriter4EmitEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter4EmitEjj")
  //</editor-fold>
  public long/*uint64_t*/ Emit(/*uint*/int Code) {
    return Emit(Code, 0);
  }
  public long/*uint64_t*/ Emit(/*uint*/int Code, /*uint*/int Abbrev/*= 0*/) {
    long/*uint64_t*/ Offset = Writer.Stream.GetCurrentBitNo();
    PrepareToEmit(Offset);
    Writer.Stream.EmitRecord(Code, $Deref(Record), Abbrev);
    FlushStmts();
    return Offset;
  }

  
  /// \brief Emit the record to the stream, preceded by its substatements.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::EmitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 763,
   FQN="clang::ASTRecordWriter::EmitStmt", NM="_ZN5clang15ASTRecordWriter8EmitStmtEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter8EmitStmtEjj")
  //</editor-fold>
  public long/*uint64_t*/ EmitStmt(/*uint*/int Code) {
    return EmitStmt(Code, 0);
  }
  public long/*uint64_t*/ EmitStmt(/*uint*/int Code, /*uint*/int Abbrev/*= 0*/) {
    FlushSubStmts();
    PrepareToEmit(Writer.Stream.GetCurrentBitNo());
    Writer.Stream.EmitRecord(Code, $Deref(Record), Abbrev);
    return Writer.Stream.GetCurrentBitNo();
  }

  
  /// \brief Add a bit offset into the record. This will be converted into an
  /// offset relative to the current record when emitted.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 772,
   FQN="clang::ASTRecordWriter::AddOffset", NM="_ZN5clang15ASTRecordWriter9AddOffsetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter9AddOffsetEy")
  //</editor-fold>
  public void AddOffset(long/*uint64_t*/ BitOffset) {
    OffsetIndices.push_back(Record.size());
    Record.push_back(BitOffset);
  }

  
  /// \brief Add the given statement or expression to the queue of
  /// statements to emit.
  ///
  /// This routine should be used when emitting types and declarations
  /// that have expressions as part of their formulation. Once the
  /// type or declaration has been written, Emit() will write
  /// the corresponding statements just after the record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 784,
   FQN="clang::ASTRecordWriter::AddStmt", NM="_ZN5clang15ASTRecordWriter7AddStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter7AddStmtEPNS_4StmtE")
  //</editor-fold>
  public void AddStmt(Stmt /*P*/ S) {
    StmtsToEmit.push_back(S);
  }

  
  /// \brief Add a definition for the given function to the queue of statements
  /// to emit.
  
  /// \brief Add a definition for the given function to the queue of statements
  /// to emit.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 2180,
   FQN="clang::ASTRecordWriter::AddFunctionDefinition", NM="_ZN5clang15ASTRecordWriter21AddFunctionDefinitionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang15ASTRecordWriter21AddFunctionDefinitionEPKNS_12FunctionDeclE")
  //</editor-fold>
  public void AddFunctionDefinition(/*const*/ FunctionDecl /*P*/ FD) {
    // Switch case IDs are per function body.
    Writer.ClearSwitchCaseIDs();
    assert (FD.doesThisDeclarationHaveABody());
    {
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(FD);
      if ((CD != null)) {
        Record.push_back($uint2ullong(CD.getNumCtorInitializers()));
        if ((CD.getNumCtorInitializers() != 0)) {
          AddCXXCtorInitializers(llvm.makeArrayRef(CD.init_begin$Const(), CD.init_end$Const()));
        }
      }
    }
    AddStmt(FD.getBody());
  }


  
  /// \brief Emit a source location.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 793,
   FQN="clang::ASTRecordWriter::AddSourceLocation", NM="_ZN5clang15ASTRecordWriter17AddSourceLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter17AddSourceLocationENS_14SourceLocationE")
  //</editor-fold>
  public void AddSourceLocation(SourceLocation Loc) {
    Writer.AddSourceLocation(new SourceLocation(Loc), $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit a source range.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 798,
   FQN="clang::ASTRecordWriter::AddSourceRange", NM="_ZN5clang15ASTRecordWriter14AddSourceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter14AddSourceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void AddSourceRange(SourceRange Range) {
    Writer.AddSourceRange(new SourceRange(Range), $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit an integral value.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4795,
   FQN="clang::ASTRecordWriter::AddAPInt", NM="_ZN5clang15ASTRecordWriter8AddAPIntERKN4llvm5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter8AddAPIntERKN4llvm5APIntE")
  //</editor-fold>
  public void AddAPInt(final /*const*/ APInt /*&*/ Value) {
    Record.push_back($uint2ullong(Value.getBitWidth()));
    /*const*/ulong$ptr/*uint64_t P*/ Words = $tryClone(Value.getRawData());
    Record.append_T(Words, Words.$add(Value.getNumWords()));
  }

  
  /// \brief Emit a signed integral value.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddAPSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4801,
   FQN="clang::ASTRecordWriter::AddAPSInt", NM="_ZN5clang15ASTRecordWriter9AddAPSIntERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter9AddAPSIntERKN4llvm6APSIntE")
  //</editor-fold>
  public void AddAPSInt(final /*const*/ APSInt /*&*/ Value) {
    Record.push_back((Value.isUnsigned() ? 1 : 0));
    AddAPInt(Value);
  }

  
  /// \brief Emit a floating-point value.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddAPFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4806,
   FQN="clang::ASTRecordWriter::AddAPFloat", NM="_ZN5clang15ASTRecordWriter10AddAPFloatERKN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter10AddAPFloatERKN4llvm7APFloatE")
  //</editor-fold>
  public void AddAPFloat(final /*const*/ APFloat /*&*/ Value) {
    AddAPInt(Value.bitcastToAPInt());
  }

  
  /// \brief Emit a reference to an identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddIdentifierRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 812,
   FQN="clang::ASTRecordWriter::AddIdentifierRef", NM="_ZN5clang15ASTRecordWriter16AddIdentifierRefEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter16AddIdentifierRefEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public void AddIdentifierRef(/*const*/ IdentifierInfo /*P*/ II) {
    Writer.AddIdentifierRef(II, $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit a Selector (which is a smart pointer reference).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddSelectorRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4852,
   FQN="clang::ASTRecordWriter::AddSelectorRef", NM="_ZN5clang15ASTRecordWriter14AddSelectorRefENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter14AddSelectorRefENS_8SelectorE")
  //</editor-fold>
  public void AddSelectorRef(/*const*/ Selector SelRef) {
    Record.push_back($uint2ullong(Writer.getSelectorRef(new Selector(SelRef))));
  }

  
  /// \brief Emit a CXXTemporary.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddCXXTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4875,
   FQN="clang::ASTRecordWriter::AddCXXTemporary", NM="_ZN5clang15ASTRecordWriter15AddCXXTemporaryEPKNS_12CXXTemporaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter15AddCXXTemporaryEPKNS_12CXXTemporaryE")
  //</editor-fold>
  public void AddCXXTemporary(/*const*/ CXXTemporary /*P*/ Temp) {
    AddDeclRef(Temp.getDestructor());
  }

  
  /// \brief Emit a C++ base specifier.
  
  // FIXME: Move this out of the main ASTRecordWriter interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddCXXBaseSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5399,
   FQN="clang::ASTRecordWriter::AddCXXBaseSpecifier", NM="_ZN5clang15ASTRecordWriter19AddCXXBaseSpecifierERKNS_16CXXBaseSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter19AddCXXBaseSpecifierERKNS_16CXXBaseSpecifierE")
  //</editor-fold>
  public void AddCXXBaseSpecifier(final /*const*/ CXXBaseSpecifier /*&*/ Base) {
    Record.push_back((Base.isVirtual() ? 1 : 0));
    Record.push_back((Base.isBaseOfClass() ? 1 : 0));
    Record.push_back(Base.getAccessSpecifierAsWritten().getValue());
    Record.push_back((Base.getInheritConstructors() ? 1 : 0));
    AddTypeSourceInfo(Base.getTypeSourceInfo());
    AddSourceRange(Base.getSourceRange());
    AddSourceLocation(Base.isPackExpansion() ? Base.getEllipsisLoc() : new SourceLocation());
  }

  
  /// \brief Emit a set of C++ base specifiers.
  
  // FIXME: Move this out of the main ASTRecordWriter interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddCXXBaseSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5423,
   FQN="clang::ASTRecordWriter::AddCXXBaseSpecifiers", NM="_ZN5clang15ASTRecordWriter20AddCXXBaseSpecifiersEN4llvm8ArrayRefINS_16CXXBaseSpecifierEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter20AddCXXBaseSpecifiersEN4llvm8ArrayRefINS_16CXXBaseSpecifierEEE")
  //</editor-fold>
  public void AddCXXBaseSpecifiers(ArrayRef<CXXBaseSpecifier> Bases) {
    AddOffset(EmitCXXBaseSpecifiers($Deref(Writer), new ArrayRef<CXXBaseSpecifier>(Bases)));
  }

  
  /// \brief Emit a reference to a type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTypeRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 829,
   FQN="clang::ASTRecordWriter::AddTypeRef", NM="_ZN5clang15ASTRecordWriter10AddTypeRefENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter10AddTypeRefENS_8QualTypeE")
  //</editor-fold>
  public void AddTypeRef(QualType T) {
    Writer.AddTypeRef(new QualType(T), $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emits a reference to a declarator info.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4920,
   FQN="clang::ASTRecordWriter::AddTypeSourceInfo", NM="_ZN5clang15ASTRecordWriter17AddTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter17AddTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void AddTypeSourceInfo(TypeSourceInfo /*P*/ TInfo) {
    if (!(TInfo != null)) {
      AddTypeRef(new QualType());
      return;
    }
    
    AddTypeLoc(TInfo.getTypeLoc());
  }

  
  /// \brief Emits a type with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4929,
   FQN="clang::ASTRecordWriter::AddTypeLoc", NM="_ZN5clang15ASTRecordWriter10AddTypeLocENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter10AddTypeLocENS_7TypeLocE")
  //</editor-fold>
  public void AddTypeLoc(TypeLoc TL) {
    AddTypeRef(TL.getType());
    
    TypeLocWriter TLW/*J*/= new TypeLocWriter(/*Deref*/this);
    for (; !TL.isNull(); TL.$assignMove(TL.getNextTypeLoc()))  {
      TLW.Visit(/*NO_COPY*/TL);
    }
  }

  
  /// \brief Emits a template argument location info.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4879,
   FQN="clang::ASTRecordWriter::AddTemplateArgumentLocInfo", NM="_ZN5clang15ASTRecordWriter26AddTemplateArgumentLocInfoENS_16TemplateArgument7ArgKindERKNS_23TemplateArgumentLocInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter26AddTemplateArgumentLocInfoENS_16TemplateArgument7ArgKindERKNS_23TemplateArgumentLocInfoE")
  //</editor-fold>
  public void AddTemplateArgumentLocInfo(TemplateArgument.ArgKind Kind, final /*const*/ TemplateArgumentLocInfo /*&*/ Arg) {
    switch (Kind) {
     case Expression:
      AddStmt(Arg.getAsExpr());
      break;
     case Type:
      AddTypeSourceInfo(Arg.getAsTypeSourceInfo());
      break;
     case Template:
      AddNestedNameSpecifierLoc(Arg.getTemplateQualifierLoc());
      AddSourceLocation(Arg.getTemplateNameLoc());
      break;
     case TemplateExpansion:
      AddNestedNameSpecifierLoc(Arg.getTemplateQualifierLoc());
      AddSourceLocation(Arg.getTemplateNameLoc());
      AddSourceLocation(Arg.getTemplateEllipsisLoc());
      break;
     case Null:
     case Integral:
     case Declaration:
     case NullPtr:
     case Pack:
      // FIXME: Is this right?
      break;
    }
  }

  
  /// \brief Emits a template argument location.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4907,
   FQN="clang::ASTRecordWriter::AddTemplateArgumentLoc", NM="_ZN5clang15ASTRecordWriter22AddTemplateArgumentLocERKNS_19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter22AddTemplateArgumentLocERKNS_19TemplateArgumentLocE")
  //</editor-fold>
  public void AddTemplateArgumentLoc(final /*const*/ TemplateArgumentLoc /*&*/ Arg) {
    AddTemplateArgument(Arg.getArgument());
    if (Arg.getArgument().getKind() == TemplateArgument.ArgKind.Expression) {
      boolean InfoHasSameExpr = Arg.getArgument().getAsExpr() == Arg.getLocInfo().getAsExpr();
      Record.push_back((InfoHasSameExpr ? 1 : 0));
      if (InfoHasSameExpr) {
        return; // Avoid storing the same expr twice.
      }
    }
    AddTemplateArgumentLocInfo(Arg.getArgument().getKind(), Arg.getLocInfo());
  }

  
  /// \brief Emits an AST template argument list info.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddASTTemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5378,
   FQN="clang::ASTRecordWriter::AddASTTemplateArgumentListInfo", NM="_ZN5clang15ASTRecordWriter30AddASTTemplateArgumentListInfoEPKNS_27ASTTemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter30AddASTTemplateArgumentListInfoEPKNS_27ASTTemplateArgumentListInfoE")
  //</editor-fold>
  public void AddASTTemplateArgumentListInfo(/*const*/ ASTTemplateArgumentListInfo /*P*/ ASTTemplArgList) {
    assert ((ASTTemplArgList != null)) : "No ASTTemplArgList!";
    AddSourceLocation(new SourceLocation(ASTTemplArgList.LAngleLoc));
    AddSourceLocation(new SourceLocation(ASTTemplArgList.RAngleLoc));
    Record.push_back($uint2ullong(ASTTemplArgList.NumTemplateArgs));
    /*const*/ type$ptr<TemplateArgumentLoc/*P*/> TemplArgs = ASTTemplArgList.getTemplateArgs();
    for (int i = 0, e = ASTTemplArgList.NumTemplateArgs; i != e; ++i)  {
      AddTemplateArgumentLoc(TemplArgs.$at(i));
    }
  }

  
  /// \brief Emit a reference to a declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddDeclRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 851,
   FQN="clang::ASTRecordWriter::AddDeclRef", NM="_ZN5clang15ASTRecordWriter10AddDeclRefEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter10AddDeclRefEPKNS_4DeclE")
  //</editor-fold>
  public void AddDeclRef(/*const*/ Decl /*P*/ D) {
    Writer.AddDeclRef(D, $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit a declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddDeclarationName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5067,
   FQN="clang::ASTRecordWriter::AddDeclarationName", NM="_ZN5clang15ASTRecordWriter18AddDeclarationNameENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter18AddDeclarationNameENS_15DeclarationNameE")
  //</editor-fold>
  public void AddDeclarationName(DeclarationName Name) {
    // FIXME: Emit a stable enum for NameKind.  0 = Identifier etc.
    Record.push_back(Name.getNameKind().getValue());
    switch (Name.getNameKind()) {
     case Identifier:
      AddIdentifierRef(Name.getAsIdentifierInfo());
      break;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      AddSelectorRef(Name.getObjCSelector());
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      AddTypeRef(Name.getCXXNameType());
      break;
     case CXXOperatorName:
      Record.push_back($uint2ulong(Name.getCXXOverloadedOperator().getValue()));
      break;
     case CXXLiteralOperatorName:
      AddIdentifierRef(Name.getCXXLiteralIdentifier());
      break;
     case CXXUsingDirective:
      // No extra data to emit
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddDeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5122,
   FQN="clang::ASTRecordWriter::AddDeclarationNameLoc", NM="_ZN5clang15ASTRecordWriter21AddDeclarationNameLocERKNS_18DeclarationNameLocENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter21AddDeclarationNameLocERKNS_18DeclarationNameLocENS_15DeclarationNameE")
  //</editor-fold>
  public void AddDeclarationNameLoc(final /*const*/ DeclarationNameLoc /*&*/ DNLoc, 
                       DeclarationName Name) {
    switch (Name.getNameKind()) {
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      AddTypeSourceInfo(DNLoc.Unnamed_field.NamedType.TInfo);
      break;
     case CXXOperatorName:
      AddSourceLocation(SourceLocation.getFromRawEncoding(DNLoc.Unnamed_field.CXXOperatorName.BeginOpNameLoc));
      AddSourceLocation(SourceLocation.getFromRawEncoding(DNLoc.Unnamed_field.CXXOperatorName.EndOpNameLoc));
      break;
     case CXXLiteralOperatorName:
      AddSourceLocation(SourceLocation.getFromRawEncoding(DNLoc.Unnamed_field.CXXLiteralOperatorName.OpNameLoc));
      break;
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXUsingDirective:
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddDeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5152,
   FQN="clang::ASTRecordWriter::AddDeclarationNameInfo", NM="_ZN5clang15ASTRecordWriter22AddDeclarationNameInfoERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter22AddDeclarationNameInfoERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  public void AddDeclarationNameInfo(final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
    AddDeclarationName(NameInfo.getName());
    AddSourceLocation(NameInfo.getLoc());
    AddDeclarationNameLoc(NameInfo.getInfo$Const(), NameInfo.getName());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddQualifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5159,
   FQN="clang::ASTRecordWriter::AddQualifierInfo", NM="_ZN5clang15ASTRecordWriter16AddQualifierInfoERKNS_13QualifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter16AddQualifierInfoERKNS_13QualifierInfoE")
  //</editor-fold>
  public void AddQualifierInfo(final /*const*/ QualifierInfo /*&*/ Info) {
    AddNestedNameSpecifierLoc(new NestedNameSpecifierLoc(Info.QualifierLoc));
    Record.push_back($uint2ullong(Info.NumTemplParamLists));
    for (/*uint*/int i = 0, e = Info.NumTemplParamLists; i != e; ++i)  {
      AddTemplateParameterList(Info.TemplParamLists.$at(i));
    }
  }

  
  /// \brief Emit a nested name specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5166,
   FQN="clang::ASTRecordWriter::AddNestedNameSpecifier", NM="_ZN5clang15ASTRecordWriter22AddNestedNameSpecifierEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter22AddNestedNameSpecifierEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public void AddNestedNameSpecifier(NestedNameSpecifier /*P*/ NNS) {
    // Nested name specifiers usually aren't too long. I think that 8 would
    // typically accommodate the vast majority.
    SmallVector<NestedNameSpecifier /*P*/ > NestedNames/*J*/= new SmallVector<NestedNameSpecifier /*P*/ >(8, (NestedNameSpecifier /*P*/ )null);
    
    // Push each of the NNS's onto a stack for serialization in reverse order.
    while ((NNS != null)) {
      NestedNames.push_back(NNS);
      NNS = NNS.getPrefix();
    }
    
    Record.push_back($uint2ullong(NestedNames.size()));
    while (!NestedNames.empty()) {
      NNS = NestedNames.pop_back_val();
      NestedNameSpecifier.SpecifierKind Kind = NNS.getKind();
      Record.push_back(Kind.getValue());
      switch (Kind) {
       case Identifier:
        AddIdentifierRef(NNS.getAsIdentifier());
        break;
       case Namespace:
        AddDeclRef(NNS.getAsNamespace());
        break;
       case NamespaceAlias:
        AddDeclRef(NNS.getAsNamespaceAlias());
        break;
       case TypeSpec:
       case TypeSpecWithTemplate:
        AddTypeRef(new QualType(NNS.getAsType(), 0));
        Record.push_back(((Kind == NestedNameSpecifier.SpecifierKind.TypeSpecWithTemplate) ? 1 : 0));
        break;
       case Global:
        // Don't need to write an associated value.
        break;
       case Super:
        AddDeclRef(NNS.getAsRecordDecl());
        break;
      }
    }
  }

  
  /// \brief Emit a nested name specifier with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddNestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5212,
   FQN="clang::ASTRecordWriter::AddNestedNameSpecifierLoc", NM="_ZN5clang15ASTRecordWriter25AddNestedNameSpecifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter25AddNestedNameSpecifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void AddNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS) {
    // Nested name specifiers usually aren't too long. I think that 8 would
    // typically accommodate the vast majority.
    SmallVector<NestedNameSpecifierLoc> NestedNames/*J*/= new SmallVector<NestedNameSpecifierLoc>(8, new NestedNameSpecifierLoc());
    
    // Push each of the nested-name-specifiers's onto a stack for
    // serialization in reverse order.
    while (NNS.$bool()) {
      NestedNames.push_back(NNS);
      NNS.$assignMove(NNS.getPrefix());
    }
    
    Record.push_back($uint2ullong(NestedNames.size()));
    while (!NestedNames.empty()) {
      NNS.$assignMove(NestedNames.pop_back_val());
      NestedNameSpecifier.SpecifierKind Kind = NNS.getNestedNameSpecifier().getKind();
      Record.push_back(Kind.getValue());
      switch (Kind) {
       case Identifier:
        AddIdentifierRef(NNS.getNestedNameSpecifier().getAsIdentifier());
        AddSourceRange(NNS.getLocalSourceRange());
        break;
       case Namespace:
        AddDeclRef(NNS.getNestedNameSpecifier().getAsNamespace());
        AddSourceRange(NNS.getLocalSourceRange());
        break;
       case NamespaceAlias:
        AddDeclRef(NNS.getNestedNameSpecifier().getAsNamespaceAlias());
        AddSourceRange(NNS.getLocalSourceRange());
        break;
       case TypeSpec:
       case TypeSpecWithTemplate:
        Record.push_back(((Kind == NestedNameSpecifier.SpecifierKind.TypeSpecWithTemplate) ? 1 : 0));
        AddTypeLoc(NNS.getTypeLoc());
        AddSourceLocation(NNS.getLocalSourceRange().getEnd());
        break;
       case Global:
        AddSourceLocation(NNS.getLocalSourceRange().getEnd());
        break;
       case Super:
        AddDeclRef(NNS.getNestedNameSpecifier().getAsRecordDecl());
        AddSourceRange(NNS.getLocalSourceRange());
        break;
      }
    }
  }

  
  /// \brief Emit a template name.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5265,
   FQN="clang::ASTRecordWriter::AddTemplateName", NM="_ZN5clang15ASTRecordWriter15AddTemplateNameENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter15AddTemplateNameENS_12TemplateNameE")
  //</editor-fold>
  public void AddTemplateName(TemplateName Name) {
    TemplateName.NameKind Kind = Name.getKind();
    Record.push_back(Kind.getValue());
    switch (Kind) {
     case Template:
      AddDeclRef(Name.getAsTemplateDecl());
      break;
     case OverloadedTemplate:
      {
        OverloadedTemplateStorage /*P*/ OvT = Name.getAsOverloadedTemplate();
        Record.push_back($uint2ullong(OvT.size()));
        for (final NamedDecl /*P*/ /*const*/ /*&*/ I : $Deref(OvT))  {
          AddDeclRef(I);
        }
        break;
      }
     case QualifiedTemplate:
      {
        QualifiedTemplateName /*P*/ QualT = Name.getAsQualifiedTemplateName();
        AddNestedNameSpecifier(QualT.getQualifier());
        Record.push_back((QualT.hasTemplateKeyword() ? 1 : 0));
        AddDeclRef(QualT.getTemplateDecl());
        break;
      }
     case DependentTemplate:
      {
        DependentTemplateName /*P*/ DepT = Name.getAsDependentTemplateName();
        AddNestedNameSpecifier(DepT.getQualifier());
        Record.push_back((DepT.isIdentifier() ? 1 : 0));
        if (DepT.isIdentifier()) {
          AddIdentifierRef(DepT.getIdentifier());
        } else {
          Record.push_back(DepT.getOperator().getValue());
        }
        break;
      }
     case SubstTemplateTemplateParm:
      {
        SubstTemplateTemplateParmStorage /*P*/ subst = Name.getAsSubstTemplateTemplateParm();
        AddDeclRef(subst.getParameter());
        AddTemplateName(subst.getReplacement());
        break;
      }
     case SubstTemplateTemplateParmPack:
      {
        SubstTemplateTemplateParmPackStorage /*P*/ SubstPack = Name.getAsSubstTemplateTemplateParmPack();
        AddDeclRef(SubstPack.getParameterPack());
        AddTemplateArgument(SubstPack.getArgumentPack());
        break;
      }
    }
  }

  
  /// \brief Emit a template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5318,
   FQN="clang::ASTRecordWriter::AddTemplateArgument", NM="_ZN5clang15ASTRecordWriter19AddTemplateArgumentERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter19AddTemplateArgumentERKNS_16TemplateArgumentE")
  //</editor-fold>
  public void AddTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg) {
    Record.push_back(Arg.getKind().getValue());
    switch (Arg.getKind()) {
     case Null:
      break;
     case Type:
      AddTypeRef(Arg.getAsType());
      break;
     case Declaration:
      AddDeclRef(Arg.getAsDecl());
      AddTypeRef(Arg.getParamTypeForDecl());
      break;
     case NullPtr:
      AddTypeRef(Arg.getNullPtrType());
      break;
     case Integral:
      AddAPSInt(Arg.getAsIntegral());
      AddTypeRef(Arg.getIntegralType());
      break;
     case Template:
      AddTemplateName(Arg.getAsTemplateOrTemplatePattern());
      break;
     case TemplateExpansion:
      AddTemplateName(Arg.getAsTemplateOrTemplatePattern());
      {
        OptionalUInt NumExpansions = Arg.getNumTemplateExpansions();
        if (NumExpansions.$bool()) {
          Record.push_back($uint2ullong(NumExpansions.$star() + 1));
        } else {
          Record.push_back($int2ullong(0));
        }
      }
      break;
     case Expression:
      AddStmt(Arg.getAsExpr());
      break;
     case Pack:
      Record.push_back($uint2ullong(Arg.pack_size()));
      for (final /*const*/ TemplateArgument /*&*/ P : Arg.pack_elements())  {
        AddTemplateArgument(P);
      }
      break;
    }
  }

  
  /// \brief Emit a template parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5358,
   FQN="clang::ASTRecordWriter::AddTemplateParameterList", NM="_ZN5clang15ASTRecordWriter24AddTemplateParameterListEPKNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter24AddTemplateParameterListEPKNS_21TemplateParameterListE")
  //</editor-fold>
  public void AddTemplateParameterList(/*const*/ TemplateParameterList /*P*/ TemplateParams) {
    assert ((TemplateParams != null)) : "No TemplateParams!";
    AddSourceLocation(TemplateParams.getTemplateLoc());
    AddSourceLocation(TemplateParams.getLAngleLoc());
    AddSourceLocation(TemplateParams.getRAngleLoc());
    Record.push_back($uint2ullong(TemplateParams.size()));
    for (final NamedDecl /*P*/ /*const*/ /*&*/ P : $Deref(TemplateParams))  {
      AddDeclRef(P);
    }
  }

  
  /// \brief Emit a template argument list.
  
  /// \brief Emit a template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5370,
   FQN="clang::ASTRecordWriter::AddTemplateArgumentList", NM="_ZN5clang15ASTRecordWriter23AddTemplateArgumentListEPKNS_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter23AddTemplateArgumentListEPKNS_20TemplateArgumentListE")
  //</editor-fold>
  public void AddTemplateArgumentList(/*const*/ TemplateArgumentList /*P*/ TemplateArgs) {
    assert ((TemplateArgs != null)) : "No TemplateArgs!";
    Record.push_back($uint2ullong(TemplateArgs.size()));
    for (int i = 0, e = TemplateArgs.size(); i != e; ++i)  {
      AddTemplateArgument(TemplateArgs.get(i));
    }
  }

  
  /// \brief Emit a UnresolvedSet structure.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5389,
   FQN="clang::ASTRecordWriter::AddUnresolvedSet", NM="_ZN5clang15ASTRecordWriter16AddUnresolvedSetERKNS_16ASTUnresolvedSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter16AddUnresolvedSetERKNS_16ASTUnresolvedSetE")
  //</editor-fold>
  public void AddUnresolvedSet(final /*const*/ ASTUnresolvedSet /*&*/ Set) {
    Record.push_back($uint2ullong(Set.size()));
    for (UnresolvedSetIterator I = Set.begin$Const(), E = Set.end$Const(); I.$noteq(E); I.$preInc()) {
      AddDeclRef(I.getDecl());
      Record.push_back(I.getAccess().getValue());
    }
  }

  
  /// \brief Emit a CXXCtorInitializer array.
  
  // FIXME: Move this out of the main ASTRecordWriter interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddCXXCtorInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5468,
   FQN="clang::ASTRecordWriter::AddCXXCtorInitializers", NM="_ZN5clang15ASTRecordWriter22AddCXXCtorInitializersEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter22AddCXXCtorInitializersEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE")
  //</editor-fold>
  public void AddCXXCtorInitializers(ArrayRef<CXXCtorInitializer /*P*/ > CtorInits) {
    AddOffset(EmitCXXCtorInitializers($Deref(Writer), new ArrayRef<CXXCtorInitializer /*P*/ >(CtorInits)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddCXXDefinitionData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5473,
   FQN="clang::ASTRecordWriter::AddCXXDefinitionData", NM="_ZN5clang15ASTRecordWriter20AddCXXDefinitionDataEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter20AddCXXDefinitionDataEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public void AddCXXDefinitionData(/*const*/ CXXRecordDecl /*P*/ D) {
    final CXXRecordDecl.DefinitionData /*&*/ Data = D.data();
    Record.push_back($uint2ullong(Data.IsLambda));
    Record.push_back($uint2ullong(Data.UserDeclaredConstructor));
    Record.push_back($uint2ullong($6bits_uint2uint(Data.UserDeclaredSpecialMembers)));
    Record.push_back($uint2ullong(Data.Aggregate));
    Record.push_back($uint2ullong(Data.PlainOldData));
    Record.push_back($uint2ullong(Data.Empty));
    Record.push_back($uint2ullong(Data.Polymorphic));
    Record.push_back($uint2ullong(Data.Abstract));
    Record.push_back($uint2ullong(Data.IsStandardLayout));
    Record.push_back($uint2ullong(Data.HasNoNonEmptyBases));
    Record.push_back($uint2ullong(Data.HasPrivateFields));
    Record.push_back($uint2ullong(Data.HasProtectedFields));
    Record.push_back($uint2ullong(Data.HasPublicFields));
    Record.push_back($uint2ullong(Data.HasMutableFields));
    Record.push_back($uint2ullong(Data.HasVariantMembers));
    Record.push_back($uint2ullong(Data.HasOnlyCMembers));
    Record.push_back($uint2ullong(Data.HasInClassInitializer));
    Record.push_back($uint2ullong(Data.HasUninitializedReferenceMember));
    Record.push_back($uint2ullong(Data.HasUninitializedFields));
    Record.push_back($uint2ullong(Data.HasInheritedConstructor));
    Record.push_back($uint2ullong(Data.HasInheritedAssignment));
    Record.push_back($uint2ullong(Data.NeedOverloadResolutionForMoveConstructor));
    Record.push_back($uint2ullong(Data.NeedOverloadResolutionForMoveAssignment));
    Record.push_back($uint2ullong(Data.NeedOverloadResolutionForDestructor));
    Record.push_back($uint2ullong(Data.DefaultedMoveConstructorIsDeleted));
    Record.push_back($uint2ullong(Data.DefaultedMoveAssignmentIsDeleted));
    Record.push_back($uint2ullong(Data.DefaultedDestructorIsDeleted));
    Record.push_back($uint2ullong($6bits_uint2uint(Data.HasTrivialSpecialMembers)));
    Record.push_back($uint2ullong($6bits_uint2uint(Data.DeclaredNonTrivialSpecialMembers)));
    Record.push_back($uint2ullong(Data.HasIrrelevantDestructor));
    Record.push_back($uint2ullong(Data.HasConstexprNonCopyMoveConstructor));
    Record.push_back($uint2ullong(Data.HasDefaultedDefaultConstructor));
    Record.push_back($uint2ullong(Data.DefaultedDefaultConstructorIsConstexpr));
    Record.push_back($uint2ullong(Data.HasConstexprDefaultConstructor));
    Record.push_back($uint2ullong(Data.HasNonLiteralTypeFieldsOrBases));
    Record.push_back($uint2ullong(Data.ComputedVisibleConversions));
    Record.push_back($uint2ullong(Data.UserProvidedDefaultConstructor));
    Record.push_back($uint2ullong($6bits_uint2uint(Data.DeclaredSpecialMembers)));
    Record.push_back($uint2ullong(Data.ImplicitCopyConstructorHasConstParam));
    Record.push_back($uint2ullong(Data.ImplicitCopyAssignmentHasConstParam));
    Record.push_back($uint2ullong(Data.HasDeclaredCopyConstructorWithConstParam));
    Record.push_back($uint2ullong(Data.HasDeclaredCopyAssignmentWithConstParam));
    // IsLambda bit is already saved.
    Record.push_back($uint2ullong(Data.NumBases));
    if ($greater_uint(Data.NumBases, 0)) {
      AddCXXBaseSpecifiers(Data.bases());
    }
    
    // FIXME: Make VBases lazily computed when needed to avoid storing them.
    Record.push_back($uint2ullong(Data.NumVBases));
    if ($greater_uint(Data.NumVBases, 0)) {
      AddCXXBaseSpecifiers(Data.vbases());
    }
    
    AddUnresolvedSet(Data.Conversions.get($Deref(Writer.Context)));
    AddUnresolvedSet(Data.VisibleConversions.get($Deref(Writer.Context)));
    // Data.Definition is the owning decl, no need to write it. 
    AddDeclRef(D.getFirstFriend());
    
    // Add lambda-specific data.
    if (Data.IsLambda) {
      final CXXRecordDecl.LambdaDefinitionData /*&*/ Lambda = D.getLambdaData();
      Record.push_back($uint2ullong(Lambda.Dependent));
      Record.push_back($uint2ullong(Lambda.IsGenericLambda));
      Record.push_back($uint2ullong($2bits_uint2uint(Lambda.CaptureDefault)));
      Record.push_back($uint2ullong($15bits_uint2uint(Lambda.NumCaptures)));
      Record.push_back($uint2ullong($13bits_uint2uint(Lambda.NumExplicitCaptures)));
      Record.push_back($uint2ullong(Lambda.ManglingNumber));
      AddDeclRef(Lambda.ContextDecl);
      AddTypeSourceInfo(Lambda.MethodTyInfo);
      for (/*uint*/int I = 0, N = $15bits_uint2uint(Lambda.NumCaptures); I != N; ++I) {
        final /*const*/ LambdaCapture /*&*/ Capture = Lambda.Captures.$at(I);
        AddSourceLocation(Capture.getLocation());
        Record.push_back((Capture.isImplicit() ? 1 : 0));
        Record.push_back(Capture.getCaptureKind().getValue());
        switch (Capture.getCaptureKind()) {
         case LCK_StarThis:
         case LCK_This:
         case LCK_VLAType:
          break;
         case LCK_ByCopy:
         case LCK_ByRef:
          VarDecl /*P*/ Var = Capture.capturesVariable() ? Capture.getCapturedVar() : null;
          AddDeclRef(Var);
          AddSourceLocation(Capture.isPackExpansion() ? Capture.getEllipsisLoc() : new SourceLocation());
          break;
        }
      }
    }
  }

  
  /// \brief Emit a string.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 891,
   FQN="clang::ASTRecordWriter::AddString", NM="_ZN5clang15ASTRecordWriter9AddStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter9AddStringEN4llvm9StringRefE")
  //</editor-fold>
  public void AddString(StringRef Str) {
    Writer.AddString(new StringRef(Str), $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit a path.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 896,
   FQN="clang::ASTRecordWriter::AddPath", NM="_ZN5clang15ASTRecordWriter7AddPathEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter7AddPathEN4llvm9StringRefE")
  //</editor-fold>
  public void AddPath(StringRef Path) {
    Writer.AddPath(new StringRef(Path), $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit a version tuple.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddVersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 901,
   FQN="clang::ASTRecordWriter::AddVersionTuple", NM="_ZN5clang15ASTRecordWriter15AddVersionTupleERKNS_12VersionTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter15AddVersionTupleERKNS_12VersionTupleE")
  //</editor-fold>
  public void AddVersionTuple(final /*const*/ VersionTuple /*&*/ Version) {
    Writer.AddVersionTuple(Version, $Deref(Record));
    /*JAVA:return*/return;
  }

  
  /// \brief Emit a list of attributes.
  
  //===----------------------------------------------------------------------===//
  // General Serialization Routines
  //===----------------------------------------------------------------------===//
  
  /// \brief Emit the list of attributes to the specified record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::AddAttributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3975,
   FQN="clang::ASTRecordWriter::AddAttributes", NM="_ZN5clang15ASTRecordWriter13AddAttributesEN4llvm8ArrayRefIPKNS_4AttrEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriter13AddAttributesEN4llvm8ArrayRefIPKNS_4AttrEEE")
  //</editor-fold>
  public void AddAttributes(ArrayRef</*const*/ Attr /*P*/ > Attrs) {
    final ASTRecordWriter /*&*/ Record = /*Deref*/this;
    Record.push_back($uint2ulong(Attrs.size()));
    for (/*const*/ Attr /*P*/ A : Attrs) {
      Record.push_back(A.getKind().getValue()); // FIXME: stable encoding, target attrs
      Record.AddSourceRange(A.getRange());
      /*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
      |*                                                                            *|
      |* Attribute serialization code                                               *|
      |*                                                                            *|
      |* Automatically generated file, do not edit!                                 *|
      |*                                                                            *|
      \*===----------------------------------------------------------------------===*/
      switch (A.getKind()) {
       case AMDGPUNumSGPR:
        {
          /*const*/ AMDGPUNumSGPRAttr /*P*/ SA = cast_AMDGPUNumSGPRAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getNumSGPR()));
          break;
        }
       case AMDGPUNumVGPR:
        {
          /*const*/ AMDGPUNumVGPRAttr /*P*/ SA = cast_AMDGPUNumVGPRAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getNumVGPR()));
          break;
        }
       case ARMInterrupt:
        {
          /*const*/ ARMInterruptAttr /*P*/ SA = cast_ARMInterruptAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getInterrupt().getValue());
          break;
        }
       case AbiTag:
        {
          /*const*/ AbiTagAttr /*P*/ SA = cast_AbiTagAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.tags_size()));
          for (final StringRef /*&*/ Val : SA.tags())  {
            Record.AddString(new StringRef(Val));
          }
          break;
        }
       case AcquireCapability:
        {
          /*const*/ AcquireCapabilityAttr /*P*/ SA = cast_AcquireCapabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case AcquiredAfter:
        {
          /*const*/ AcquiredAfterAttr /*P*/ SA = cast_AcquiredAfterAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case AcquiredBefore:
        {
          /*const*/ AcquiredBeforeAttr /*P*/ SA = cast_AcquiredBeforeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case Alias:
        {
          /*const*/ AliasAttr /*P*/ SA = cast_AliasAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getAliasee());
          break;
        }
       case AlignMac68k:
        {
          /*const*/ AlignMac68kAttr /*P*/ SA = cast_AlignMac68kAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case AlignValue:
        {
          /*const*/ AlignValueAttr /*P*/ SA = cast_AlignValueAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getAlignment());
          break;
        }
       case Aligned:
        {
          /*const*/ AlignedAttr /*P*/ SA = cast_AlignedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back((SA.isAlignmentExpr() ? 1 : 0));
          if (SA.isAlignmentExpr()) {
            Record.AddStmt(SA.getAlignmentExpr());
          } else {
            Record.AddTypeSourceInfo(SA.getAlignmentType());
          }
          break;
        }
       case AlwaysInline:
        {
          /*const*/ AlwaysInlineAttr /*P*/ SA = cast_AlwaysInlineAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case AnalyzerNoReturn:
        {
          /*const*/ AnalyzerNoReturnAttr /*P*/ SA = cast_AnalyzerNoReturnAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Annotate:
        {
          /*const*/ AnnotateAttr /*P*/ SA = cast_AnnotateAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getAnnotation());
          break;
        }
       case AnyX86Interrupt:
        {
          /*const*/ AnyX86InterruptAttr /*P*/ SA = cast_AnyX86InterruptAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ArcWeakrefUnavailable:
        {
          /*const*/ ArcWeakrefUnavailableAttr /*P*/ SA = cast_ArcWeakrefUnavailableAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ArgumentWithTypeTag:
        {
          /*const*/ ArgumentWithTypeTagAttr /*P*/ SA = cast_ArgumentWithTypeTagAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getArgumentKind());
          Record.push_back($uint2ulong(SA.getArgumentIdx()));
          Record.push_back($uint2ulong(SA.getTypeTagIdx()));
          Record.push_back((SA.getIsPointer() ? 1 : 0));
          break;
        }
       case AsmLabel:
        {
          /*const*/ AsmLabelAttr /*P*/ SA = cast_AsmLabelAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getLabel());
          break;
        }
       case AssertCapability:
        {
          /*const*/ AssertCapabilityAttr /*P*/ SA = cast_AssertCapabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getExpr());
          break;
        }
       case AssertExclusiveLock:
        {
          /*const*/ AssertExclusiveLockAttr /*P*/ SA = cast_AssertExclusiveLockAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case AssertSharedLock:
        {
          /*const*/ AssertSharedLockAttr /*P*/ SA = cast_AssertSharedLockAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case AssumeAligned:
        {
          /*const*/ AssumeAlignedAttr /*P*/ SA = cast_AssumeAlignedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getAlignment());
          Record.AddStmt(SA.getOffset());
          break;
        }
       case Availability:
        {
          /*const*/ AvailabilityAttr /*P*/ SA = cast_AvailabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getPlatform());
          Record.AddVersionTuple(SA.getIntroduced());
          Record.AddVersionTuple(SA.getDeprecated());
          Record.AddVersionTuple(SA.getObsoleted());
          Record.push_back((SA.getUnavailable() ? 1 : 0));
          Record.AddString(SA.getMessage());
          Record.push_back((SA.getStrict() ? 1 : 0));
          Record.AddString(SA.getReplacement());
          break;
        }
       case Blocks:
        {
          /*const*/ BlocksAttr /*P*/ SA = cast_BlocksAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getType().getValue());
          break;
        }
       case C11NoReturn:
        {
          /*const*/ C11NoReturnAttr /*P*/ SA = cast_C11NoReturnAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CDecl:
        {
          /*const*/ CDeclAttr /*P*/ SA = cast_CDeclAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CFAuditedTransfer:
        {
          /*const*/ CFAuditedTransferAttr /*P*/ SA = cast_CFAuditedTransferAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CFConsumed:
        {
          /*const*/ CFConsumedAttr /*P*/ SA = cast_CFConsumedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CFReturnsNotRetained:
        {
          /*const*/ CFReturnsNotRetainedAttr /*P*/ SA = cast_CFReturnsNotRetainedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CFReturnsRetained:
        {
          /*const*/ CFReturnsRetainedAttr /*P*/ SA = cast_CFReturnsRetainedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CFUnknownTransfer:
        {
          /*const*/ CFUnknownTransferAttr /*P*/ SA = cast_CFUnknownTransferAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CUDAConstant:
        {
          /*const*/ CUDAConstantAttr /*P*/ SA = cast_CUDAConstantAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CUDADevice:
        {
          /*const*/ CUDADeviceAttr /*P*/ SA = cast_CUDADeviceAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CUDAGlobal:
        {
          /*const*/ CUDAGlobalAttr /*P*/ SA = cast_CUDAGlobalAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CUDAHost:
        {
          /*const*/ CUDAHostAttr /*P*/ SA = cast_CUDAHostAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CUDAInvalidTarget:
        {
          /*const*/ CUDAInvalidTargetAttr /*P*/ SA = cast_CUDAInvalidTargetAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CUDALaunchBounds:
        {
          /*const*/ CUDALaunchBoundsAttr /*P*/ SA = cast_CUDALaunchBoundsAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getMaxThreads());
          Record.AddStmt(SA.getMinBlocks());
          break;
        }
       case CUDAShared:
        {
          /*const*/ CUDASharedAttr /*P*/ SA = cast_CUDASharedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CXX11NoReturn:
        {
          /*const*/ CXX11NoReturnAttr /*P*/ SA = cast_CXX11NoReturnAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CallableWhen:
        {
          /*const*/ CallableWhenAttr /*P*/ SA = cast_CallableWhenAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.callableStates_size()));
          for (type$ptr<CallableWhenAttr.ConsumedState /*P*/ > i = $tryClone(SA.callableStates_begin()), /*P*/ e = $tryClone(SA.callableStates_end()); $noteq_ptr(i, e); i.$preInc())  {
            Record.push_back((i.$star()).getValue());
          }
          break;
        }
       case Capability:
        {
          /*const*/ CapabilityAttr /*P*/ SA = cast_CapabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getName());
          break;
        }
       case CapturedRecord:
        {
          /*const*/ CapturedRecordAttr /*P*/ SA = cast_CapturedRecordAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case CarriesDependency:
        {
          /*const*/ CarriesDependencyAttr /*P*/ SA = cast_CarriesDependencyAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Cleanup:
        {
          /*const*/ CleanupAttr /*P*/ SA = cast_CleanupAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddDeclRef(SA.getFunctionDecl());
          break;
        }
       case Cold:
        {
          /*const*/ ColdAttr /*P*/ SA = cast_ColdAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Common:
        {
          /*const*/ CommonAttr /*P*/ SA = cast_CommonAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Const:
        {
          /*const*/ ConstAttr /*P*/ SA = cast_ConstAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Constructor:
        {
          /*const*/ ConstructorAttr /*P*/ SA = cast_ConstructorAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($int2ulong(SA.getPriority()));
          break;
        }
       case Consumable:
        {
          /*const*/ ConsumableAttr /*P*/ SA = cast_ConsumableAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getDefaultState().getValue());
          break;
        }
       case ConsumableAutoCast:
        {
          /*const*/ ConsumableAutoCastAttr /*P*/ SA = cast_ConsumableAutoCastAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ConsumableSetOnRead:
        {
          /*const*/ ConsumableSetOnReadAttr /*P*/ SA = cast_ConsumableSetOnReadAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case DLLExport:
        {
          /*const*/ DLLExportAttr /*P*/ SA = cast_DLLExportAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case DLLImport:
        {
          /*const*/ DLLImportAttr /*P*/ SA = cast_DLLImportAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Deprecated:
        {
          /*const*/ DeprecatedAttr /*P*/ SA = cast_DeprecatedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getMessage());
          Record.AddString(SA.getReplacement());
          break;
        }
       case Destructor:
        {
          /*const*/ DestructorAttr /*P*/ SA = cast_DestructorAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($int2ulong(SA.getPriority()));
          break;
        }
       case DisableTailCalls:
        {
          /*const*/ DisableTailCallsAttr /*P*/ SA = cast_DisableTailCallsAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case EmptyBases:
        {
          /*const*/ EmptyBasesAttr /*P*/ SA = cast_EmptyBasesAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case EnableIf:
        {
          /*const*/ EnableIfAttr /*P*/ SA = cast_EnableIfAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getCond());
          Record.AddString(SA.getMessage());
          break;
        }
       case ExclusiveTrylockFunction:
        {
          /*const*/ ExclusiveTrylockFunctionAttr /*P*/ SA = cast_ExclusiveTrylockFunctionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getSuccessValue());
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case FallThrough:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case FastCall:
        {
          /*const*/ FastCallAttr /*P*/ SA = cast_FastCallAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Final:
        {
          /*const*/ FinalAttr /*P*/ SA = cast_FinalAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case FlagEnum:
        {
          /*const*/ FlagEnumAttr /*P*/ SA = cast_FlagEnumAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Flatten:
        {
          /*const*/ FlattenAttr /*P*/ SA = cast_FlattenAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Format:
        {
          /*const*/ FormatAttr /*P*/ SA = cast_FormatAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getType());
          Record.push_back($int2ulong(SA.getFormatIdx()));
          Record.push_back($int2ulong(SA.getFirstArg()));
          break;
        }
       case FormatArg:
        {
          /*const*/ FormatArgAttr /*P*/ SA = cast_FormatArgAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($int2ulong(SA.getFormatIdx()));
          break;
        }
       case GNUInline:
        {
          /*const*/ GNUInlineAttr /*P*/ SA = cast_GNUInlineAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case GuardedBy:
        {
          /*const*/ GuardedByAttr /*P*/ SA = cast_GuardedByAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getArg());
          break;
        }
       case GuardedVar:
        {
          /*const*/ GuardedVarAttr /*P*/ SA = cast_GuardedVarAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Hot:
        {
          /*const*/ HotAttr /*P*/ SA = cast_HotAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case IBAction:
        {
          /*const*/ IBActionAttr /*P*/ SA = cast_IBActionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case IBOutlet:
        {
          /*const*/ IBOutletAttr /*P*/ SA = cast_IBOutletAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case IBOutletCollection:
        {
          /*const*/ IBOutletCollectionAttr /*P*/ SA = cast_IBOutletCollectionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddTypeSourceInfo(SA.getInterfaceLoc());
          break;
        }
       case IFunc:
        {
          /*const*/ IFuncAttr /*P*/ SA = cast_IFuncAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getResolver());
          break;
        }
       case InitPriority:
        {
          /*const*/ InitPriorityAttr /*P*/ SA = cast_InitPriorityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getPriority()));
          break;
        }
       case InitSeg:
        {
          /*const*/ InitSegAttr /*P*/ SA = cast_InitSegAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getSection());
          break;
        }
       case IntelOclBicc:
        {
          /*const*/ IntelOclBiccAttr /*P*/ SA = cast_IntelOclBiccAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case InternalLinkage:
        {
          /*const*/ InternalLinkageAttr /*P*/ SA = cast_InternalLinkageAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case LTOVisibilityPublic:
        {
          /*const*/ LTOVisibilityPublicAttr /*P*/ SA = cast_LTOVisibilityPublicAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case LayoutVersion:
        {
          /*const*/ LayoutVersionAttr /*P*/ SA = cast_LayoutVersionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getVersion()));
          break;
        }
       case LockReturned:
        {
          /*const*/ LockReturnedAttr /*P*/ SA = cast_LockReturnedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getArg());
          break;
        }
       case LocksExcluded:
        {
          /*const*/ LocksExcludedAttr /*P*/ SA = cast_LocksExcludedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case LoopHint:
        {
          /*const*/ LoopHintAttr /*P*/ SA = cast_LoopHintAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getOption().getValue());
          Record.push_back(SA.getState().getValue());
          Record.AddStmt(SA.getValue());
          break;
        }
       case MSABI:
        {
          /*const*/ MSABIAttr /*P*/ SA = cast_MSABIAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case MSInheritance:
        {
          /*const*/ MSInheritanceAttr /*P*/ SA = cast_MSInheritanceAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back((SA.getBestCase() ? 1 : 0));
          break;
        }
       case MSNoVTable:
        {
          /*const*/ MSNoVTableAttr /*P*/ SA = cast_MSNoVTableAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case MSP430Interrupt:
        {
          /*const*/ MSP430InterruptAttr /*P*/ SA = cast_MSP430InterruptAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getNumber()));
          break;
        }
       case MSStruct:
        {
          /*const*/ MSStructAttr /*P*/ SA = cast_MSStructAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case MSVtorDisp:
        {
          /*const*/ MSVtorDispAttr /*P*/ SA = cast_MSVtorDispAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getVdm()));
          break;
        }
       case MaxFieldAlignment:
        {
          /*const*/ MaxFieldAlignmentAttr /*P*/ SA = cast_MaxFieldAlignmentAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getAlignment()));
          break;
        }
       case MayAlias:
        {
          /*const*/ MayAliasAttr /*P*/ SA = cast_MayAliasAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case MinSize:
        {
          /*const*/ MinSizeAttr /*P*/ SA = cast_MinSizeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Mips16:
        {
          /*const*/ Mips16Attr /*P*/ SA = cast_Mips16Attr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case MipsInterrupt:
        {
          /*const*/ MipsInterruptAttr /*P*/ SA = cast_MipsInterruptAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getInterrupt().getValue());
          break;
        }
       case Mode:
        {
          /*const*/ ModeAttr /*P*/ SA = cast_ModeAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getMode());
          break;
        }
       case NSConsumed:
        {
          /*const*/ NSConsumedAttr /*P*/ SA = cast_NSConsumedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NSConsumesSelf:
        {
          /*const*/ NSConsumesSelfAttr /*P*/ SA = cast_NSConsumesSelfAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NSReturnsAutoreleased:
        {
          /*const*/ NSReturnsAutoreleasedAttr /*P*/ SA = cast_NSReturnsAutoreleasedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NSReturnsNotRetained:
        {
          /*const*/ NSReturnsNotRetainedAttr /*P*/ SA = cast_NSReturnsNotRetainedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NSReturnsRetained:
        {
          /*const*/ NSReturnsRetainedAttr /*P*/ SA = cast_NSReturnsRetainedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Naked:
        {
          /*const*/ NakedAttr /*P*/ SA = cast_NakedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoAlias:
        {
          /*const*/ NoAliasAttr /*P*/ SA = cast_NoAliasAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoCommon:
        {
          /*const*/ NoCommonAttr /*P*/ SA = cast_NoCommonAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoDebug:
        {
          /*const*/ NoDebugAttr /*P*/ SA = cast_NoDebugAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoDuplicate:
        {
          /*const*/ NoDuplicateAttr /*P*/ SA = cast_NoDuplicateAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoInline:
        {
          /*const*/ NoInlineAttr /*P*/ SA = cast_NoInlineAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoInstrumentFunction:
        {
          /*const*/ NoInstrumentFunctionAttr /*P*/ SA = cast_NoInstrumentFunctionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoMips16:
        {
          /*const*/ NoMips16Attr /*P*/ SA = cast_NoMips16Attr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoReturn:
        {
          /*const*/ NoReturnAttr /*P*/ SA = cast_NoReturnAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoSanitize:
        {
          /*const*/ NoSanitizeAttr /*P*/ SA = cast_NoSanitizeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.sanitizers_size()));
          for (final StringRef /*&*/ Val : SA.sanitizers())  {
            Record.AddString(new StringRef(Val));
          }
          break;
        }
       case NoSplitStack:
        {
          /*const*/ NoSplitStackAttr /*P*/ SA = cast_NoSplitStackAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoThreadSafetyAnalysis:
        {
          /*const*/ NoThreadSafetyAnalysisAttr /*P*/ SA = cast_NoThreadSafetyAnalysisAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NoThrow:
        {
          /*const*/ NoThrowAttr /*P*/ SA = cast_NoThrowAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case NonNull:
        {
          /*const*/ NonNullAttr /*P*/ SA = cast_NonNullAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final int/*uint &*/ Val : SA.args())  {
            Record.push_back($uint2ulong(Val));
          }
          break;
        }
       case NotTailCalled:
        {
          /*const*/ NotTailCalledAttr /*P*/ SA = cast_NotTailCalledAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case OMPCaptureNoInit:
        {
          /*const*/ OMPCaptureNoInitAttr /*P*/ SA = cast_OMPCaptureNoInitAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case OMPDeclareSimdDecl:
        {
          /*const*/ OMPDeclareSimdDeclAttr /*P*/ SA = cast_OMPDeclareSimdDeclAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getBranchState().getValue());
          Record.AddStmt(SA.getSimdlen());
          Record.push_back($uint2ulong(SA.uniforms_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.uniforms())  {
            Record.AddStmt(Val);
          }
          Record.push_back($uint2ulong(SA.aligneds_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.aligneds())  {
            Record.AddStmt(Val);
          }
          Record.push_back($uint2ulong(SA.alignments_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.alignments())  {
            Record.AddStmt(Val);
          }
          Record.push_back($uint2ulong(SA.linears_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.linears())  {
            Record.AddStmt(Val);
          }
          Record.push_back($uint2ulong(SA.modifiers_size()));
          for (final int/*uint &*/ Val : SA.modifiers())  {
            Record.push_back($uint2ulong(Val));
          }
          Record.push_back($uint2ulong(SA.steps_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.steps())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case OMPDeclareTargetDecl:
        {
          /*const*/ OMPDeclareTargetDeclAttr /*P*/ SA = cast_OMPDeclareTargetDeclAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getMapType().getValue());
          break;
        }
       case OMPThreadPrivateDecl:
        {
          /*const*/ OMPThreadPrivateDeclAttr /*P*/ SA = cast_OMPThreadPrivateDeclAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCBoxable:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCBridge:
        {
          /*const*/ ObjCBridgeAttr /*P*/ SA = cast_ObjCBridgeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getBridgedType());
          break;
        }
       case ObjCBridgeMutable:
        {
          /*const*/ ObjCBridgeMutableAttr /*P*/ SA = cast_ObjCBridgeMutableAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getBridgedType());
          break;
        }
       case ObjCBridgeRelated:
        {
          /*const*/ ObjCBridgeRelatedAttr /*P*/ SA = cast_ObjCBridgeRelatedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getRelatedClass());
          Record.AddIdentifierRef(SA.getClassMethod());
          Record.AddIdentifierRef(SA.getInstanceMethod());
          break;
        }
       case ObjCDesignatedInitializer:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCException:
        {
          /*const*/ ObjCExceptionAttr /*P*/ SA = cast_ObjCExceptionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCExplicitProtocolImpl:
        {
          /*const*/ ObjCExplicitProtocolImplAttr /*P*/ SA = cast_ObjCExplicitProtocolImplAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCIndependentClass:
        {
          /*const*/ ObjCIndependentClassAttr /*P*/ SA = cast_ObjCIndependentClassAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCMethodFamily:
        {
          /*const*/ ObjCMethodFamilyAttr /*P*/ SA = cast_ObjCMethodFamilyAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getFamily().getValue());
          break;
        }
       case ObjCNSObject:
        {
          /*const*/ ObjCNSObjectAttr /*P*/ SA = cast_ObjCNSObjectAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCPreciseLifetime:
        {
          /*const*/ ObjCPreciseLifetimeAttr /*P*/ SA = cast_ObjCPreciseLifetimeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCRequiresPropertyDefs:
        {
          /*const*/ ObjCRequiresPropertyDefsAttr /*P*/ SA = cast_ObjCRequiresPropertyDefsAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCRequiresSuper:
        {
          /*const*/ ObjCRequiresSuperAttr /*P*/ SA = cast_ObjCRequiresSuperAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCReturnsInnerPointer:
        {
          /*const*/ ObjCReturnsInnerPointerAttr /*P*/ SA = cast_ObjCReturnsInnerPointerAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCRootClass:
        {
          /*const*/ ObjCRootClassAttr /*P*/ SA = cast_ObjCRootClassAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ObjCRuntimeName:
        {
          /*const*/ ObjCRuntimeNameAttr /*P*/ SA = cast_ObjCRuntimeNameAttr(A);
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getMetadataName());
          break;
        }
       case ObjCRuntimeVisible:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case OpenCLAccess:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case OpenCLKernel:
        {
          /*const*/ OpenCLKernelAttr /*P*/ SA = cast_OpenCLKernelAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case OpenCLUnrollHint:
        {
          /*const*/ OpenCLUnrollHintAttr /*P*/ SA = cast_OpenCLUnrollHintAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getUnrollHint()));
          break;
        }
       case OptimizeNone:
        {
          /*const*/ OptimizeNoneAttr /*P*/ SA = cast_OptimizeNoneAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Overloadable:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Override:
        {
          /*const*/ OverrideAttr /*P*/ SA = cast_OverrideAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Ownership:
        {
          /*const*/ OwnershipAttr /*P*/ SA = cast_OwnershipAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getModule());
          Record.push_back($uint2ulong(SA.args_size()));
          for (final int/*uint &*/ Val : SA.args())  {
            Record.push_back($uint2ulong(Val));
          }
          break;
        }
       case Packed:
        {
          /*const*/ PackedAttr /*P*/ SA = cast_PackedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ParamTypestate:
        {
          /*const*/ ParamTypestateAttr /*P*/ SA = cast_ParamTypestateAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getParamState().getValue());
          break;
        }
       case Pascal:
        {
          /*const*/ PascalAttr /*P*/ SA = cast_PascalAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case PassObjectSize:
        {
          /*const*/ PassObjectSizeAttr /*P*/ SA = cast_PassObjectSizeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($int2ulong(SA.getType()));
          break;
        }
       case Pcs:
        {
          /*const*/ PcsAttr /*P*/ SA = cast_PcsAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getPCS().getValue());
          break;
        }
       case PreserveAll:
        {
          /*const*/ PreserveAllAttr /*P*/ SA = cast_PreserveAllAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case PreserveMost:
        {
          /*const*/ PreserveMostAttr /*P*/ SA = cast_PreserveMostAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case PtGuardedBy:
        {
          /*const*/ PtGuardedByAttr /*P*/ SA = cast_PtGuardedByAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getArg());
          break;
        }
       case PtGuardedVar:
        {
          /*const*/ PtGuardedVarAttr /*P*/ SA = cast_PtGuardedVarAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Pure:
        {
          /*const*/ PureAttr /*P*/ SA = cast_PureAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ReleaseCapability:
        {
          /*const*/ ReleaseCapabilityAttr /*P*/ SA = cast_ReleaseCapabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case RenderScriptKernel:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ReqdWorkGroupSize:
        {
          /*const*/ ReqdWorkGroupSizeAttr /*P*/ SA = cast_ReqdWorkGroupSizeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getXDim()));
          Record.push_back($uint2ulong(SA.getYDim()));
          Record.push_back($uint2ulong(SA.getZDim()));
          break;
        }
       case RequiresCapability:
        {
          /*const*/ RequiresCapabilityAttr /*P*/ SA = cast_RequiresCapabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case Restrict:
        {
          /*const*/ RestrictAttr /*P*/ SA = cast_RestrictAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ReturnTypestate:
        {
          /*const*/ ReturnTypestateAttr /*P*/ SA = cast_ReturnTypestateAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getState().getValue());
          break;
        }
       case ReturnsNonNull:
        {
          /*const*/ ReturnsNonNullAttr /*P*/ SA = cast_ReturnsNonNullAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ReturnsTwice:
        {
          /*const*/ ReturnsTwiceAttr /*P*/ SA = cast_ReturnsTwiceAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case ScopedLockable:
        {
          /*const*/ ScopedLockableAttr /*P*/ SA = cast_ScopedLockableAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Section:
        {
          /*const*/ SectionAttr /*P*/ SA = cast_SectionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getName());
          break;
        }
       case SelectAny:
        {
          /*const*/ SelectAnyAttr /*P*/ SA = cast_SelectAnyAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Sentinel:
        {
          /*const*/ SentinelAttr /*P*/ SA = cast_SentinelAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($int2ulong(SA.getSentinel()));
          Record.push_back($int2ulong(SA.getNullPos()));
          break;
        }
       case SetTypestate:
        {
          /*const*/ SetTypestateAttr /*P*/ SA = cast_SetTypestateAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getNewState().getValue());
          break;
        }
       case SharedTrylockFunction:
        {
          /*const*/ SharedTrylockFunctionAttr /*P*/ SA = cast_SharedTrylockFunctionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getSuccessValue());
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case StdCall:
        {
          /*const*/ StdCallAttr /*P*/ SA = cast_StdCallAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case SwiftCall:
        {
          /*const*/ SwiftCallAttr /*P*/ SA = cast_SwiftCallAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case SwiftContext:
        {
          /*const*/ SwiftContextAttr /*P*/ SA = cast_SwiftContextAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case SwiftErrorResult:
        {
          /*const*/ SwiftErrorResultAttr /*P*/ SA = cast_SwiftErrorResultAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case SwiftIndirectResult:
        {
          /*const*/ SwiftIndirectResultAttr /*P*/ SA = cast_SwiftIndirectResultAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case SysVABI:
        {
          /*const*/ SysVABIAttr /*P*/ SA = cast_SysVABIAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case TLSModel:
        {
          /*const*/ TLSModelAttr /*P*/ SA = cast_TLSModelAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getModel());
          break;
        }
       case Target:
        {
          /*const*/ TargetAttr /*P*/ SA = cast_TargetAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getFeaturesStr());
          break;
        }
       case TestTypestate:
        {
          /*const*/ TestTypestateAttr /*P*/ SA = cast_TestTypestateAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getTestState().getValue());
          break;
        }
       case ThisCall:
        {
          /*const*/ ThisCallAttr /*P*/ SA = cast_ThisCallAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Thread:
        {
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case TransparentUnion:
        {
          /*const*/ TransparentUnionAttr /*P*/ SA = cast_TransparentUnionAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case TryAcquireCapability:
        {
          /*const*/ TryAcquireCapabilityAttr /*P*/ SA = cast_TryAcquireCapabilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddStmt(SA.getSuccessValue());
          Record.push_back($uint2ulong(SA.args_size()));
          for (final Expr /*P*/ /*&*/ Val : SA.args())  {
            Record.AddStmt(Val);
          }
          break;
        }
       case TypeTagForDatatype:
        {
          /*const*/ TypeTagForDatatypeAttr /*P*/ SA = cast_TypeTagForDatatypeAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddIdentifierRef(SA.getArgumentKind());
          Record.AddTypeSourceInfo(SA.getMatchingCTypeLoc());
          Record.push_back((SA.getLayoutCompatible() ? 1 : 0));
          Record.push_back((SA.getMustBeNull() ? 1 : 0));
          break;
        }
       case TypeVisibility:
        {
          /*const*/ TypeVisibilityAttr /*P*/ SA = cast_TypeVisibilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getVisibility().getValue());
          break;
        }
       case Unavailable:
        {
          /*const*/ UnavailableAttr /*P*/ SA = cast_UnavailableAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getMessage());
          Record.push_back(SA.getImplicitReason().getValue());
          break;
        }
       case Unused:
        {
          /*const*/ UnusedAttr /*P*/ SA = cast_UnusedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Used:
        {
          /*const*/ UsedAttr /*P*/ SA = cast_UsedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Uuid:
        {
          /*const*/ UuidAttr /*P*/ SA = cast_UuidAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getGuid());
          break;
        }
       case VecReturn:
        {
          /*const*/ VecReturnAttr /*P*/ SA = cast_VecReturnAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case VecTypeHint:
        {
          /*const*/ VecTypeHintAttr /*P*/ SA = cast_VecTypeHintAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddTypeSourceInfo(SA.getTypeHintLoc());
          break;
        }
       case VectorCall:
        {
          /*const*/ VectorCallAttr /*P*/ SA = cast_VectorCallAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Visibility:
        {
          /*const*/ VisibilityAttr /*P*/ SA = cast_VisibilityAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back(SA.getVisibility().getValue());
          break;
        }
       case WarnUnused:
        {
          /*const*/ WarnUnusedAttr /*P*/ SA = cast_WarnUnusedAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case WarnUnusedResult:
        {
          /*const*/ WarnUnusedResultAttr /*P*/ SA = cast_WarnUnusedResultAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case Weak:
        {
          /*const*/ WeakAttr /*P*/ SA = cast_WeakAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case WeakImport:
        {
          /*const*/ WeakImportAttr /*P*/ SA = cast_WeakImportAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case WeakRef:
        {
          /*const*/ WeakRefAttr /*P*/ SA = cast_WeakRefAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.AddString(SA.getAliasee());
          break;
        }
       case WorkGroupSizeHint:
        {
          /*const*/ WorkGroupSizeHintAttr /*P*/ SA = cast_WorkGroupSizeHintAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          Record.push_back($uint2ulong(SA.getXDim()));
          Record.push_back($uint2ulong(SA.getYDim()));
          Record.push_back($uint2ulong(SA.getZDim()));
          break;
        }
       case X86ForceAlignArgPointer:
        {
          /*const*/ X86ForceAlignArgPointerAttr /*P*/ SA = cast_X86ForceAlignArgPointerAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
       case XRayInstrument:
        {
          /*const*/ XRayInstrumentAttr /*P*/ SA = cast_XRayInstrumentAttr(A);
          Record.push_back((SA.isInherited() ? 1 : 0));
          Record.push_back((A.isImplicit() ? 1 : 0));
          Record.push_back($uint2ulong(A.getSpellingListIndex()));
          break;
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordWriter::~ASTRecordWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 693,
   FQN="clang::ASTRecordWriter::~ASTRecordWriter", NM="_ZN5clang15ASTRecordWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang15ASTRecordWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OffsetIndices.$destroy();
    StmtsToEmit.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", Record=" + Record // NOI18N
              + ", StmtsToEmit=" + "[SmallVector$Stmt]" // NOI18N
              + ", OffsetIndices=" + OffsetIndices; // NOI18N
  }
}
