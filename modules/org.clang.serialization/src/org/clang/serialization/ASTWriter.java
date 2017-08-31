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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.llvm.bitcode.*;
import org.llvm.bitcode.bitc.*;
import org.clang.serialization.impl.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.serialization.SerializationGlobals.*;
import static org.clang.serialization.impl.SerializationStatics.*;
import org.llvm.support.sys.path;
import static org.clang.lex.java.LexRTTI.*;
import org.clang.basic.llvm.DenseMapInfoFileID;
import org.clang.basic.llvm.DenseMapInfoSelector;
import static org.clang.serialization.impl.ASTWriterStatics.*;
import static org.clang.config.config.*;
import static org.clang.serialization.impl.ASTWriterDeclStatics.*;
import static org.llvm.support.zlib.ZlibGlobals.compress;
import org.llvm.support.zlib.*;
import org.clang.serialization.impl.HeaderFileInfoTrait;
import org.clang.serialization.reader.impl.DeclContextLookupTable;
import static org.clank.support.Casts.reinterpret_cast;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;


/// \brief Writes an AST file containing the contents of a translation unit.
///
/// The ASTWriter class produces a bitstream containing the serialized
/// representation of a given abstract syntax tree and its supporting
/// data structures. This bitstream can be de-serialized via an
/// instance of the ASTReader class.
//<editor-fold defaultstate="collapsed" desc="clang::ASTWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 84,
 FQN="clang::ASTWriter", NM="_ZN5clang9ASTWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriterE")
//</editor-fold>
public class ASTWriter implements /*public*/ ASTDeserializationListener, /*public*/ ASTMutationListener, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef SmallVector<uint64_t, 64> RecordData
//  public final class RecordData extends SmallVectorULong{ };
  // JAVA: typedef SmallVectorImpl<uint64_t> RecordDataImpl
//  public final class RecordDataImpl extends SmallVectorImplULong{ };
  // JAVA: typedef ArrayRef<uint64_t> RecordDataRef
//  public final class RecordDataRef extends ArrayRefULong{ };
  
  /*friend  class ASTDeclWriter*/
  /*friend  class ASTStmtWriter*/
  /*friend  class ASTTypeWriter*/
  /*friend  class ASTRecordWriter*/
/*private:*/
  /// \brief Map that provides the ID numbers of each type within the
  /// output stream, plus those deserialized from a chained PCH.
  ///
  /// The ID numbers of types are consecutive (in order of discovery)
  /// and start at 1. 0 is reserved for NULL. When types are actually
  /// stored in the stream, the ID number is shifted by 2 bits to
  /// allow for the const/volatile qualifiers.
  ///
  /// Keys in the map never have const/volatile qualifiers.
  // JAVA: typedef llvm::DenseMap<QualType, serialization::TypeIdx, serialization::UnsafeQualTypeDenseMapInfo> TypeIdxMap
//  public final class TypeIdxMap extends DenseMap<QualType, TypeIdx>{ };
  
  /// \brief The bitstream writer used to emit this precompiled header.
  /*friend*/public/*private*/ final BitstreamWriter /*&*/ Stream;
  
  /// \brief The ASTContext we're writing.
  /*friend*/public/*private*/ ASTContext /*P*/ Context;
  
  /// \brief The preprocessor we're writing.
  private Preprocessor /*P*/ PP;
  
  /// \brief The reader of existing AST files, if we're chaining.
  /*friend*/public ASTReader /*P*/ Chain;
  
  /// \brief The module we're currently writing, if any.
  private Module /*P*/ WritingModule;
  
  /// \brief The base directory for any relative paths we emit.
  private std.string BaseDirectory;
  
  /// \brief Indicates whether timestamps should be written to the produced
  /// module file. This is the case for files implicitly written to the
  /// module cache, where we need the timestamps to determine if the module
  /// file is up to date, but not otherwise.
  private boolean IncludeTimestamps;
  
  /// \brief Indicates when the AST writing is actively performing
  /// serialization, rather than just queueing updates.
  private boolean WritingAST;
  
  /// \brief Indicates that we are done serializing the collection of decls
  /// and types to emit.
  private boolean DoneWritingDeclsAndTypes;
  
  /// \brief Indicates that the AST contained compiler errors.
  private boolean ASTHasCompilerErrors;
  
  /// \brief Mapping from input file entries to the index into the
  /// offset table where information about that input file is stored.
  private DenseMapTypeUInt</*const*/ FileEntry /*P*/ > InputFileIDs;
  
  /// \brief Stores a declaration or a type to be written to the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 149,
   FQN="clang::ASTWriter::DeclOrType", NM="_ZN5clang9ASTWriter10DeclOrTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclOrTypeE")
  //</editor-fold>
  private static class DeclOrType {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::DeclOrType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 151,
     FQN="clang::ASTWriter::DeclOrType::DeclOrType", NM="_ZN5clang9ASTWriter10DeclOrTypeC1EPNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclOrTypeC1EPNS_4DeclE")
    //</editor-fold>
    public DeclOrType(Decl /*P*/ D) {
      // : Stored(D), IsType(false) 
      //START JInit
      this.Stored = D;
      this.IsType = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::DeclOrType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 152,
     FQN="clang::ASTWriter::DeclOrType::DeclOrType", NM="_ZN5clang9ASTWriter10DeclOrTypeC1ENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclOrTypeC1ENS_8QualTypeE")
    //</editor-fold>
    public DeclOrType(QualType T) {
      // : Stored(T.getAsOpaquePtr()), IsType(true) 
      //START JInit
      this.Stored = T.getAsOpaquePtr();
      this.IsType = true;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::isType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 154,
     FQN="clang::ASTWriter::DeclOrType::isType", NM="_ZNK5clang9ASTWriter10DeclOrType6isTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclOrType6isTypeEv")
    //</editor-fold>
    public boolean isType() /*const*/ {
      return IsType;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::isDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 155,
     FQN="clang::ASTWriter::DeclOrType::isDecl", NM="_ZNK5clang9ASTWriter10DeclOrType6isDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclOrType6isDeclEv")
    //</editor-fold>
    public boolean isDecl() /*const*/ {
      return !IsType;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::getType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 157,
     FQN="clang::ASTWriter::DeclOrType::getType", NM="_ZNK5clang9ASTWriter10DeclOrType7getTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclOrType7getTypeEv")
    //</editor-fold>
    public QualType getType() /*const*/ {
      assert (isType()) : "Not a type!";
      return QualType.getFromOpaquePtr(Stored);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::getDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 162,
     FQN="clang::ASTWriter::DeclOrType::getDecl", NM="_ZNK5clang9ASTWriter10DeclOrType7getDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclOrType7getDeclEv")
    //</editor-fold>
    public Decl /*P*/ getDecl() /*const*/ {
      assert (isDecl()) : "Not a decl!";
      return ((/*static_cast*/Decl /*P*/ )(Stored));
    }

  /*private:*/
    private Object/*void P*/ Stored;
    private boolean IsType;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::DeclOrType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 149,
     FQN="clang::ASTWriter::DeclOrType::DeclOrType", NM="_ZN5clang9ASTWriter10DeclOrTypeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclOrTypeC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DeclOrType(final /*const*/ DeclOrType /*&*/ $Prm0) {
      // : Stored(.Stored), IsType(.IsType) 
      //START JInit
      this.Stored = $Prm0.Stored;
      this.IsType = $Prm0.IsType;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclOrType::DeclOrType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 149,
     FQN="clang::ASTWriter::DeclOrType::DeclOrType", NM="_ZN5clang9ASTWriter10DeclOrTypeC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclOrTypeC1EOS1_")
    //</editor-fold>
    public /*inline*/ DeclOrType(JD$Move _dparam, final DeclOrType /*&&*/$Prm0) {
      // : Stored(static_cast<DeclOrType &&>().Stored), IsType(static_cast<DeclOrType &&>().IsType) 
      //START JInit
      this.Stored = $Prm0.Stored;
      this.IsType = $Prm0.IsType;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Stored=" + NativeTrace.getIdentityStr(Stored) // NOI18N
                + ", IsType=" + IsType; // NOI18N
    }
  };
  
  /// \brief The declarations and types to emit.
  private std.queue<DeclOrType> DeclTypesToEmit;
  
  /// \brief The first ID number we can use for our own declarations.
  private /*uint32_t*/int FirstDeclID;
  
  /// \brief The decl ID that will be assigned to the next new decl.
  private /*uint32_t*/int NextDeclID;
  
  /// \brief Map that provides the ID numbers of each declaration within
  /// the output stream, as well as those deserialized from a chained PCH.
  ///
  /// The ID numbers of declarations are consecutive (in order of
  /// discovery) and start at 2. 1 is reserved for the translation
  /// unit, while 0 is reserved for NULL.
  private DenseMapTypeUInt</*const*/ Decl /*P*/ > DeclIDs;
  
  /// \brief Offset of each declaration in the bitstream, indexed by
  /// the declaration's ID.
  private std.vector<DeclOffset> DeclOffsets;
  
  /// \brief Sorted (by file offset) vector of pairs of file offset/DeclID.
  // JAVA: typedef SmallVector<std::pair<unsigned int, serialization::DeclID>, 64> LocDeclIDsTy
//  public final class LocDeclIDsTy extends SmallVector<std.pairUIntUInt>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclIDInFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 196,
   FQN="clang::ASTWriter::DeclIDInFileInfo", NM="_ZN5clang9ASTWriter16DeclIDInFileInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16DeclIDInFileInfoE")
  //</editor-fold>
  private static class/*struct*/ DeclIDInFileInfo implements Destructors.ClassWithDestructor {
    public SmallVector<std.pairUIntUInt> DeclIDs;
    /// \brief Set when the DeclIDs vectors from all files are joined, this
    /// indicates the index that this particular vector has in the global one.
    public /*uint*/int FirstDeclIndex;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclIDInFileInfo::DeclIDInFileInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 196,
     FQN="clang::ASTWriter::DeclIDInFileInfo::DeclIDInFileInfo", NM="_ZN5clang9ASTWriter16DeclIDInFileInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16DeclIDInFileInfoC1Ev")
    //</editor-fold>
    public /*inline*/ DeclIDInFileInfo() {
      // : DeclIDs() 
      //START JInit
      this.DeclIDs = new SmallVector<std.pairUIntUInt>(64, new std.pairUIntUInt());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclIDInFileInfo::~DeclIDInFileInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 196,
     FQN="clang::ASTWriter::DeclIDInFileInfo::~DeclIDInFileInfo", NM="_ZN5clang9ASTWriter16DeclIDInFileInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16DeclIDInFileInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      DeclIDs.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "DeclIDs=" + DeclIDs // NOI18N
                + ", FirstDeclIndex=" + FirstDeclIndex; // NOI18N
    }
  };
  // JAVA: typedef llvm::DenseMap<FileID, DeclIDInFileInfo *> FileDeclIDsTy
//  public final class FileDeclIDsTy extends DenseMap<FileID, DeclIDInFileInfo /*P*/ >{ };
  
  /// \brief Map from file SLocEntries to info about the file-level declarations
  /// that it contains.
  private DenseMap<FileID, DeclIDInFileInfo /*P*/ > FileDeclIDs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::associateDeclWithFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5023,
   FQN="clang::ASTWriter::associateDeclWithFile", NM="_ZN5clang9ASTWriter21associateDeclWithFileEPKNS_4DeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter21associateDeclWithFileEPKNS_4DeclEj")
  //</editor-fold>
  private void associateDeclWithFile(/*const*/ Decl /*P*/ D, /*uint32_t*/int ID) {
    assert Native.$bool(ID);
    assert Native.$bool(D);
    
    SourceLocation Loc = D.getLocation();
    if (Loc.isInvalid()) {
      return;
    }
    
    // We only keep track of the file-level declarations of each file.
    if (!D.getLexicalDeclContext$Const().isFileContext()) {
      return;
    }
    // FIXME: ParmVarDecls that are part of a function type of a parameter of
    // a function/objc method, should not have TU as lexical context.
    if (isa_ParmVarDecl(D)) {
      return;
    }
    
    final SourceManager /*&*/ SM = Context.getSourceManager();
    SourceLocation FileLoc = SM.getFileLoc(/*NO_COPY*/Loc);
    assert (SM.isLocalSourceLocation(/*NO_COPY*/FileLoc));
    FileID FID/*J*/= new FileID();
    /*uint*/int Offset;
    pairTypeUInt<FileID> tmp = SM.getDecomposedLoc(/*NO_COPY*/FileLoc);
    Offset = tmp.second;
    FID.$assign(tmp.first);
    //std.tie(FID, Offset).$assign(SM.getDecomposedLoc(/*NO_COPY*/FileLoc));
    if (FID.isInvalid()) {
      return;
    }
    assert (SM.getSLocEntry(/*NO_COPY*/FID).isFile());
    
    final type$ref<DeclIDInFileInfo /*P*/ /*&*/> Info = FileDeclIDs.ref$at(FID);
    if (!(Info.$deref() != null)) {
      Info.$set(new DeclIDInFileInfo());
    }
    
    std.pairUIntUInt LocDecl/*J*/= new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, Offset, ID);
    final SmallVector<std.pairUIntUInt> /*&*/ Decls = Info.$deref().DeclIDs;
    if (Decls.empty() || $lesseq_uint(Decls.back().first, Offset)) {
      Decls.push_back(LocDecl);
      return;
    }
    
    type$ptr<std.pairUIntUInt/*P*/ > I = std.upper_bound(Decls.begin(), Decls.end(), LocDecl, less_first::$call);
    
    Decls.insert_iterator$T_T$C$R(I, LocDecl);
  }

  
  /// \brief The first ID number we can use for our own types.
  private /*uint32_t*/int FirstTypeID;
  
  /// \brief The type ID that will be assigned to the next new type.
  private /*uint32_t*/int NextTypeID;
  
  /// \brief Map that provides the ID numbers of each type within the
  /// output stream, plus those deserialized from a chained PCH.
  ///
  /// The ID numbers of types are consecutive (in order of discovery)
  /// and start at 1. 0 is reserved for NULL. When types are actually
  /// stored in the stream, the ID number is shifted by 2 bits to
  /// allow for the const/volatile qualifiers.
  ///
  /// Keys in the map never have const/volatile qualifiers.
  private DenseMap<QualType, TypeIdx> TypeIdxs;
  
  /// \brief Offset of each type in the bitstream, indexed by
  /// the type's ID.
  private std.vectorUInt TypeOffsets;
  
  /// \brief The first ID number we can use for our own identifiers.
  private /*uint32_t*/int FirstIdentID;
  
  /// \brief The identifier ID that will be assigned to the next new identifier.
  private /*uint32_t*/int NextIdentID;
  
  /// \brief Map that provides the ID numbers of each identifier in
  /// the output stream.
  ///
  /// The ID numbers for identifiers are consecutive (in order of
  /// discovery), starting at 1. An ID of zero refers to a NULL
  /// IdentifierInfo.
  private MapVectorPtrUInt</*const*/ IdentifierInfo /*P*/ > IdentifierIDs;
  
  /// \brief The first ID number we can use for our own macros.
  private /*uint32_t*/int FirstMacroID;
  
  /// \brief The identifier ID that will be assigned to the next new identifier.
  private /*uint32_t*/int NextMacroID;
  
  /// \brief Map that provides the ID numbers of each macro.
  private DenseMapTypeUInt<MacroInfo /*P*/ > MacroIDs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::MacroInfoToEmitData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 254,
   FQN="clang::ASTWriter::MacroInfoToEmitData", NM="_ZN5clang9ASTWriter19MacroInfoToEmitDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19MacroInfoToEmitDataE")
  //</editor-fold>
  private static class/*struct*/ MacroInfoToEmitData implements NativePOD<MacroInfoToEmitData> {
    public /*const*/ IdentifierInfo /*P*/ Name;
    public MacroInfo /*P*/ MI;
    public /*uint32_t*/int ID;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::MacroInfoToEmitData::MacroInfoToEmitData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 254,
     FQN="clang::ASTWriter::MacroInfoToEmitData::MacroInfoToEmitData", NM="_ZN5clang9ASTWriter19MacroInfoToEmitDataC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19MacroInfoToEmitDataC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MacroInfoToEmitData(final /*const*/ MacroInfoToEmitData /*&*/ $Prm0) {
      // : Name(.Name), MI(.MI), ID(.ID) 
      //START JInit
      this.Name = $Prm0.Name;
      this.MI = $Prm0.MI;
      this.ID = $Prm0.ID;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::MacroInfoToEmitData::MacroInfoToEmitData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 254,
     FQN="clang::ASTWriter::MacroInfoToEmitData::MacroInfoToEmitData", NM="_ZN5clang9ASTWriter19MacroInfoToEmitDataC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19MacroInfoToEmitDataC1EOS1_")
    //</editor-fold>
    public /*inline*/ MacroInfoToEmitData(JD$Move _dparam, final MacroInfoToEmitData /*&&*/$Prm0) {
      // : Name(static_cast<MacroInfoToEmitData &&>().Name), MI(static_cast<MacroInfoToEmitData &&>().MI), ID(static_cast<MacroInfoToEmitData &&>().ID) 
      //START JInit
      this.Name = $Prm0.Name;
      this.MI = $Prm0.MI;
      this.ID = $Prm0.ID;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public MacroInfoToEmitData() {
    }
    
    public MacroInfoToEmitData(IdentifierInfo Name, MacroInfo MI, int ID) {
      this.Name = Name;
      this.MI = MI;
      this.ID = ID;
    }

    @Override
    public MacroInfoToEmitData $assign(MacroInfoToEmitData $Prm0) {
      this.Name = $Prm0.Name;
      this.MI = $Prm0.MI;
      this.ID = $Prm0.ID;
      return this;
    }

    @Override
    public MacroInfoToEmitData clone() {
      return new MacroInfoToEmitData(Name, MI, ID);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Name=" + Name // NOI18N
                + ", MI=" + MI // NOI18N
                + ", ID=" + ID; // NOI18N
    }
  };
  /// \brief The macro infos to emit.
  private std.vector<MacroInfoToEmitData> MacroInfosToEmit;
  
  private DenseMapTypeULong</*const*/ IdentifierInfo /*P*/ > IdentMacroDirectivesOffsetMap;
  
  /// @name FlushStmt Caches
  /// @{
  
  /// \brief Set of parent Stmts for the currently serializing sub-stmt.
  /*friend*/public/*private*/ DenseSet<Stmt /*P*/ > ParentStmts;
  
  /// \brief Offsets of sub-stmts already serialized. The offset points
  /// just after the stmt record.
  /*friend*/public/*private*/ DenseMapTypeULong<Stmt /*P*/ > SubStmtEntries;
  
  /// @}
  
  /// \brief Offsets of each of the identifier IDs into the identifier
  /// table.
  private std.vectorUInt IdentifierOffsets;
  
  /// \brief The first ID number we can use for our own submodules.
  private /*uint32_t*/int FirstSubmoduleID;
  
  /// \brief The submodule ID that will be assigned to the next new submodule.
  private /*uint32_t*/int NextSubmoduleID;
  
  /// \brief The first ID number we can use for our own selectors.
  private /*uint32_t*/int FirstSelectorID;
  
  /// \brief The selector ID that will be assigned to the next new selector.
  private /*uint32_t*/int NextSelectorID;
  
  /// \brief Map that provides the ID numbers of each Selector.
  private MapVectorTypeUInt<Selector> SelectorIDs;
  
  /// \brief Offset of each selector within the method pool/selector
  /// table, indexed by the Selector ID (-1).
  private std.vectorUInt SelectorOffsets;
  
  /// \brief Mapping from macro definitions (as they occur in the preprocessing
  /// record) to the macro IDs.
  private DenseMapTypeUInt</*const*/ MacroDefinitionRecord /*P*/ > MacroDefinitions;
  
  /// \brief Cache of indices of anonymous declarations within their lexical
  /// contexts.
  private DenseMapTypeUInt</*const*/ Decl /*P*/ > AnonymousDeclarationNumbers;
  
  /// An update to a Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 309,
   FQN="clang::ASTWriter::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateE")
  //</editor-fold>
  /*friend*/public static class DeclUpdate implements NativePOD<DeclUpdate> {
    /// A DeclUpdateKind.
    private /*uint*/int Kind;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 312,
     FQN="clang::ASTWriter::DeclUpdate::(anonymous)", NM="_ZN5clang9ASTWriter10DeclUpdateE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateE_Unnamed_union1")
    //</editor-fold>
    private static class/*union*/ Unnamed_union1 {
      public /*const*/ Decl /*P*/ Dcl;
      public Object/*void P*/ Type;
      public /*uint*/int Loc;
      public /*uint*/int Val;
      public Module /*P*/ Mod;
      public /*const*/ Attr /*P*/ Attribute;
      //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 312,
       FQN="clang::ASTWriter::DeclUpdate::(anonymous union)::operator=", NM="_ZN5clang9ASTWriter10DeclUpdateUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
        this.Dcl = $Prm0.Dcl;
        this.Type = $Prm0.Type;
        this.Loc = $Prm0.Loc;
        this.Val = $Prm0.Val;
        this.Mod = $Prm0.Mod;
        this.Attribute = $Prm0.Attribute;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 312,
       FQN="clang::ASTWriter::DeclUpdate::(anonymous union)::operator=", NM="_ZN5clang9ASTWriter10DeclUpdateUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
        this.Dcl = $Prm0.Dcl;
        this.Type = $Prm0.Type;
        this.Loc = $Prm0.Loc;
        this.Val = $Prm0.Val;
        this.Mod = $Prm0.Mod;
        this.Attribute = $Prm0.Attribute;        
        return /*Deref*/this;
      }

      
      @Override public String toString() {
        return "" + "Dcl=" + "[Decl]" // NOI18N
                  + ", Type=" + NativeTrace.getIdentityStr(Type) // NOI18N
                  + ", Loc=" + Loc // NOI18N
                  + ", Val=" + Val // NOI18N
                  + ", Mod=" + Mod // NOI18N
                  + ", Attribute=" + Attribute; // NOI18N
      }
    };
    private final Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 322,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1Ej")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind) {
      // : Kind(Kind), Dcl(null) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Dcl = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 323,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1EjPKNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1EjPKNS_4DeclE")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind, /*const*/ Decl /*P*/ Dcl) {
      // : Kind(Kind), Dcl(Dcl) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Dcl = Dcl;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 324,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1EjNS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1EjNS_8QualTypeE")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind, QualType Type) {
      // : Kind(Kind), Type(Type.getAsOpaquePtr()) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Type = Type.getAsOpaquePtr();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 326,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1EjNS_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1EjNS_14SourceLocationE")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind, SourceLocation Loc) {
      // : Kind(Kind), Loc(Loc.getRawEncoding()) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Loc = Loc.getRawEncoding();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 328,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1Ejj")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind, /*uint*/int Val) {
      // : Kind(Kind), Val(Val) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Val = Val;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 330,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1EjPNS_6ModuleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1EjPNS_6ModuleE")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind, Module /*P*/ M) {
      // : Kind(Kind), Mod(M) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Mod = M;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::DeclUpdate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 332,
     FQN="clang::ASTWriter::DeclUpdate::DeclUpdate", NM="_ZN5clang9ASTWriter10DeclUpdateC1EjPKNS_4AttrE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateC1EjPKNS_4AttrE")
    //</editor-fold>
    public DeclUpdate(/*uint*/int Kind, /*const*/ Attr /*P*/ Attribute) {
      // : Kind(Kind), Attribute(Attribute) 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Attribute = Attribute;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 335,
     FQN="clang::ASTWriter::DeclUpdate::getKind", NM="_ZNK5clang9ASTWriter10DeclUpdate7getKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate7getKindEv")
    //</editor-fold>
    public /*uint*/int getKind() /*const*/ {
      return Kind;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 336,
     FQN="clang::ASTWriter::DeclUpdate::getDecl", NM="_ZNK5clang9ASTWriter10DeclUpdate7getDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate7getDeclEv")
    //</editor-fold>
    public /*const*/ Decl /*P*/ getDecl() /*const*/ {
      return Unnamed_field1.Dcl;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 337,
     FQN="clang::ASTWriter::DeclUpdate::getType", NM="_ZNK5clang9ASTWriter10DeclUpdate7getTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate7getTypeEv")
    //</editor-fold>
    public QualType getType() /*const*/ {
      return QualType.getFromOpaquePtr(Unnamed_field1.Type);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 338,
     FQN="clang::ASTWriter::DeclUpdate::getLoc", NM="_ZNK5clang9ASTWriter10DeclUpdate6getLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate6getLocEv")
    //</editor-fold>
    public SourceLocation getLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(Unnamed_field1.Loc);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getNumber">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 341,
     FQN="clang::ASTWriter::DeclUpdate::getNumber", NM="_ZNK5clang9ASTWriter10DeclUpdate9getNumberEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate9getNumberEv")
    //</editor-fold>
    public /*uint*/int getNumber() /*const*/ {
      return Unnamed_field1.Val;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getModule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 342,
     FQN="clang::ASTWriter::DeclUpdate::getModule", NM="_ZNK5clang9ASTWriter10DeclUpdate9getModuleEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate9getModuleEv")
    //</editor-fold>
    public Module /*P*/ getModule() /*const*/ {
      return Unnamed_field1.Mod;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::getAttr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 343,
     FQN="clang::ASTWriter::DeclUpdate::getAttr", NM="_ZNK5clang9ASTWriter10DeclUpdate7getAttrEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter10DeclUpdate7getAttrEv")
    //</editor-fold>
    public /*const*/ Attr /*P*/ getAttr() /*const*/ {
      return Unnamed_field1.Attribute;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 309,
     FQN="clang::ASTWriter::DeclUpdate::operator=", NM="_ZN5clang9ASTWriter10DeclUpdateaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateaSERKS1_")
    //</editor-fold>
    public /*inline*/ DeclUpdate /*&*/ $assign(final /*const*/ DeclUpdate /*&*/ $Prm0) {
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1.$assign($Prm0.Unnamed_field1);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclUpdate::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 309,
     FQN="clang::ASTWriter::DeclUpdate::operator=", NM="_ZN5clang9ASTWriter10DeclUpdateaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10DeclUpdateaSEOS1_")
    //</editor-fold>
    public /*inline*/ DeclUpdate /*&*/ $assignMove(final DeclUpdate /*&&*/$Prm0) {
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1.$assignMove($Prm0.Unnamed_field1);
      return /*Deref*/this;
    }

    DeclUpdate() {
      this.Kind = -1;
    }
    
    @Override public DeclUpdate clone() {
      return new DeclUpdate().$assign(this);
    }
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
    }
  };
  
  // JAVA: typedef SmallVector<DeclUpdate, 1> UpdateRecord
//  public final class UpdateRecord extends SmallVector<DeclUpdate>{ };
  // JAVA: typedef llvm::MapVector<const Decl *, UpdateRecord> DeclUpdateMap
//  public final class DeclUpdateMap extends MapVector</*const*/ Decl /*P*/ , SmallVector<DeclUpdate> >{ };
  /// \brief Mapping from declarations that came from a chained PCH to the
  /// record containing modifications to them.
  /*friend*/public MapVectorPtrType</*const*/ Decl /*P*/ , SmallVector<DeclUpdate> > DeclUpdates;
  
  // JAVA: typedef llvm::DenseMap<Decl *, Decl *> FirstLatestDeclMap
//  public final class FirstLatestDeclMap extends DenseMap<Decl /*P*/ , Decl /*P*/ >{ };
  /// \brief Map of first declarations from a chained PCH that point to the
  /// most recent declarations in another PCH.
  private DenseMap<Decl /*P*/ , Decl /*P*/ > FirstLatestDecls;
  
  /// \brief Declarations encountered that might be external
  /// definitions.
  ///
  /// We keep track of external definitions and other 'interesting' declarations
  /// as we are emitting declarations to the AST file. The AST file contains a
  /// separate record for these declarations, which are provided to the AST
  /// consumer by the AST reader. This is behavior is required to properly cope with,
  /// e.g., tentative variable definitions that occur within
  /// headers. The declarations themselves are stored as declaration
  /// IDs, since they will be written out to an EAGERLY_DESERIALIZED_DECLS
  /// record.
  private SmallVectorULong EagerlyDeserializedDecls;
  
  /// \brief DeclContexts that have received extensions since their serialized
  /// form.
  ///
  /// For namespaces, when we're chaining and encountering a namespace, we check
  /// if its primary namespace comes from the chain. If it does, we add the
  /// primary to this set, so that we can write out lexical content updates for
  /// it.
  /*friend*/public SmallSetVector</*const*/ DeclContext /*P*/ > UpdatedDeclContexts;
  
  /// \brief Keeps track of visible decls that were added in DeclContexts
  /// coming from another AST file.
  private SmallVector</*const*/ Decl /*P*/ > UpdatingVisibleDecls;
  
  /// \brief The set of Objective-C class that have categories we
  /// should serialize.
  /*friend*/public SetVector<ObjCInterfaceDecl /*P*/ > ObjCClassesWithCategories;
  
  /// \brief The set of declarations that may have redeclaration chains that
  /// need to be serialized.
  private SmallVector</*const*/ Decl /*P*/ > Redeclarations;
  
  /// \brief A cache of the first local declaration for "interesting"
  /// redeclaration chains.
  private DenseMap</*const*/ Decl /*P*/ , /*const*/ Decl /*P*/ > FirstLocalDeclCache;
  
  /// \brief Mapping from SwitchCase statements to IDs.
  private DenseMapTypeUInt<SwitchCase /*P*/ > SwitchCaseIDs;
  
  /// \brief The number of statements written to the AST file.
  private /*uint*/int NumStatements;
  
  /// \brief The number of macros written to the AST file.
  private /*uint*/int NumMacros;
  
  /// \brief The number of lexical declcontexts written to the AST
  /// file.
  private /*uint*/int NumLexicalDeclContexts;
  
  /// \brief The number of visible declcontexts written to the AST
  /// file.
  private /*uint*/int NumVisibleDeclContexts;
  
  /// \brief A mapping from each known submodule to its ID number, which will
  /// be a positive integer.
  private DenseMapTypeUInt<Module /*P*/ > SubmoduleIDs;
  
  /// \brief A list of the module file extension writers.
  private std.vector<std.unique_ptr<ModuleFileExtensionWriter>> ModuleFileExtensionWriters;
  
  /// \brief Retrieve or create a submodule ID for this module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getSubmoduleID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2427,
   FQN="clang::ASTWriter::getSubmoduleID", NM="_ZN5clang9ASTWriter14getSubmoduleIDEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter14getSubmoduleIDEPNS_6ModuleE")
  //</editor-fold>
  /*friend*/public /*uint*/int getSubmoduleID(Module /*P*/ Mod) {
    // FIXME: This can easily happen, if we have a reference to a submodule that
    // did not result in us loading a module file for that submodule. For
    // instance, a cross-top-level-module 'conflict' declaration will hit this.
    /*uint*/int ID = getLocalOrImportedSubmoduleID(Mod);
    assert (((ID != 0) || !(Mod != null))) : "asked for module ID for non-local, non-imported module";
    return ID;
  }

  
  /// \brief Write the given subexpression to the bitstream.
  
  /// \brief Write the given subexpression to the bitstream.
  
  /// \brief Write the given substatement or subexpression to the
  /// bitstream.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteSubStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2506,
   FQN="clang::ASTWriter::WriteSubStmt", NM="_ZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtE")
  //</editor-fold>
  /*friend*/public/*private*/ void WriteSubStmt(Stmt /*P*/ S) {
    ASTStmtWriter Writer = null;
    WriteSubStmt$$.ParentStmtInserterRAII ParentStmtInserter = null;
    try {
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      Writer/*J*/= new ASTStmtWriter(/*Deref*/this, Record);
      ++NumStatements;
      if (!(S != null)) {
        Stream.EmitRecord(StmtCode.STMT_NULL_PTR, Record);
        return;
      }
      DenseMapIteratorTypeULong<Stmt /*P*/ /*P*/> I = SubStmtEntries.find(S);
      if (I.$noteq(/*NO_ITER_COPY*/SubStmtEntries.end())) {
        Record.push_back(I.$arrow().second);
        Stream.EmitRecord(StmtCode.STMT_REF_PTR, Record);
        return;
      }
      assert (!(ParentStmts.count(S) != 0)) : "There is a Stmt cycle!";
      
      ;
      
      ParentStmtInserter/*J*/= new WriteSubStmt$$.ParentStmtInserterRAII(S, ParentStmts);
      
      Writer.Visit(S);
      
      long/*uint64_t*/ Offset = Writer.Emit();
      SubStmtEntries.$set(S, Offset);
    } finally {
      if (ParentStmtInserter != null) { ParentStmtInserter.$destroy(); }
      if (Writer != null) { Writer.$destroy(); }
    }
  }
  private static final class WriteSubStmt$$ {
    static //<editor-fold defaultstate="collapsed" desc="ParentStmtInserterRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2526,
     FQN="ParentStmtInserterRAII", NM="_ZZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtEE22ParentStmtInserterRAII",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtEE22ParentStmtInserterRAII")
    //</editor-fold>
     class/*struct*/ ParentStmtInserterRAII implements Destructors.ClassWithDestructor {
      public Stmt /*P*/ S;
      public final DenseSet<Stmt /*P*/ > /*&*/ ParentStmts;
      
      //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteSubStmt(Stmt * )::ParentStmtInserterRAII::ParentStmtInserterRAII">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2530,
       FQN="clang::ASTWriter::WriteSubStmt(Stmt * )::ParentStmtInserterRAII::ParentStmtInserterRAII", NM="_ZZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtEEN22ParentStmtInserterRAIIC1ES2_RN4llvm8DenseSetIS2_NS4_12DenseMapInfoIS2_EEEE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtEEN22ParentStmtInserterRAIIC1ES2_RN4llvm8DenseSetIS2_NS4_12DenseMapInfoIS2_EEEE")
      //</editor-fold>
      public ParentStmtInserterRAII(Stmt /*P*/ S, final DenseSet<Stmt /*P*/ > /*&*/ ParentStmts) {
        // : S(S), ParentStmts(ParentStmts) 
        //START JInit
        this.S = S;
        this./*&*/ParentStmts=/*&*/ParentStmts;
        //END JInit
        ParentStmts.insert(S);
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteSubStmt(Stmt * )::ParentStmtInserterRAII::~ParentStmtInserterRAII">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2534,
       FQN="clang::ASTWriter::WriteSubStmt(Stmt * )::ParentStmtInserterRAII::~ParentStmtInserterRAII", NM="_ZZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtEEN22ParentStmtInserterRAIID0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZZN5clang9ASTWriter12WriteSubStmtEPNS_4StmtEEN22ParentStmtInserterRAIID0Ev")
      //</editor-fold>
      public void $destroy() {
        ParentStmts.erase(S);
      }
    
      
      @Override public String toString() {
        return "" + "S=" + "[Stmt]" // NOI18N
                  + ", ParentStmts=" + "[DenseSet$Stmt]"; // NOI18N
      }
    };
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteBlockInfoBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 906,
   FQN="clang::ASTWriter::WriteBlockInfoBlock", NM="_ZN5clang9ASTWriter19WriteBlockInfoBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19WriteBlockInfoBlockEv")
  //</editor-fold>
  private void WriteBlockInfoBlock() {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    Stream.EnterSubblock(StandardBlockIDs.BLOCKINFO_BLOCK_ID, 3);
    
    // Control Block.
    EmitBlockID(BlockIDs.CONTROL_BLOCK_ID, $("CONTROL_BLOCK"), Stream, Record);
    EmitRecordID(ControlRecordTypes.METADATA, $("METADATA"), Stream, Record);
    EmitRecordID(ControlRecordTypes.SIGNATURE, $("SIGNATURE"), Stream, Record);
    EmitRecordID(ControlRecordTypes.MODULE_NAME, $("MODULE_NAME"), Stream, Record);
    EmitRecordID(ControlRecordTypes.MODULE_DIRECTORY, $("MODULE_DIRECTORY"), Stream, Record);
    EmitRecordID(ControlRecordTypes.MODULE_MAP_FILE, $("MODULE_MAP_FILE"), Stream, Record);
    EmitRecordID(ControlRecordTypes.IMPORTS, $("IMPORTS"), Stream, Record);
    EmitRecordID(ControlRecordTypes.ORIGINAL_FILE, $("ORIGINAL_FILE"), Stream, Record);
    EmitRecordID(ControlRecordTypes.ORIGINAL_PCH_DIR, $("ORIGINAL_PCH_DIR"), Stream, Record);
    EmitRecordID(ControlRecordTypes.ORIGINAL_FILE_ID, $("ORIGINAL_FILE_ID"), Stream, Record);
    EmitRecordID(ControlRecordTypes.INPUT_FILE_OFFSETS, $("INPUT_FILE_OFFSETS"), Stream, Record);
    EmitBlockID(BlockIDs.OPTIONS_BLOCK_ID, $("OPTIONS_BLOCK"), Stream, Record);
    EmitRecordID(OptionsRecordTypes.LANGUAGE_OPTIONS, $("LANGUAGE_OPTIONS"), Stream, Record);
    EmitRecordID(OptionsRecordTypes.TARGET_OPTIONS, $("TARGET_OPTIONS"), Stream, Record);
    EmitRecordID(OptionsRecordTypes.DIAGNOSTIC_OPTIONS, $("DIAGNOSTIC_OPTIONS"), Stream, Record);
    EmitRecordID(OptionsRecordTypes.FILE_SYSTEM_OPTIONS, $("FILE_SYSTEM_OPTIONS"), Stream, Record);
    EmitRecordID(OptionsRecordTypes.HEADER_SEARCH_OPTIONS, $("HEADER_SEARCH_OPTIONS"), Stream, Record);
    EmitRecordID(OptionsRecordTypes.PREPROCESSOR_OPTIONS, $("PREPROCESSOR_OPTIONS"), Stream, Record);
    EmitBlockID(BlockIDs.INPUT_FILES_BLOCK_ID, $("INPUT_FILES_BLOCK"), Stream, Record);
    EmitRecordID(InputFileRecordTypes.INPUT_FILE, $("INPUT_FILE"), Stream, Record);
    
    // AST Top-Level Block.
    EmitBlockID(BlockIDs.AST_BLOCK_ID, $("AST_BLOCK"), Stream, Record);
    EmitRecordID(ASTRecordTypes.TYPE_OFFSET, $("TYPE_OFFSET"), Stream, Record);
    EmitRecordID(ASTRecordTypes.DECL_OFFSET, $("DECL_OFFSET"), Stream, Record);
    EmitRecordID(ASTRecordTypes.IDENTIFIER_OFFSET, $("IDENTIFIER_OFFSET"), Stream, Record);
    EmitRecordID(ASTRecordTypes.IDENTIFIER_TABLE, $("IDENTIFIER_TABLE"), Stream, Record);
    EmitRecordID(ASTRecordTypes.EAGERLY_DESERIALIZED_DECLS, $("EAGERLY_DESERIALIZED_DECLS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.SPECIAL_TYPES, $("SPECIAL_TYPES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.STATISTICS, $("STATISTICS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.TENTATIVE_DEFINITIONS, $("TENTATIVE_DEFINITIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.SELECTOR_OFFSETS, $("SELECTOR_OFFSETS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.METHOD_POOL, $("METHOD_POOL"), Stream, Record);
    EmitRecordID(ASTRecordTypes.PP_COUNTER_VALUE, $("PP_COUNTER_VALUE"), Stream, Record);
    EmitRecordID(ASTRecordTypes.SOURCE_LOCATION_OFFSETS, $("SOURCE_LOCATION_OFFSETS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.SOURCE_LOCATION_PRELOADS, $("SOURCE_LOCATION_PRELOADS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.EXT_VECTOR_DECLS, $("EXT_VECTOR_DECLS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.UNUSED_FILESCOPED_DECLS, $("UNUSED_FILESCOPED_DECLS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.PPD_ENTITIES_OFFSETS, $("PPD_ENTITIES_OFFSETS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.VTABLE_USES, $("VTABLE_USES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.REFERENCED_SELECTOR_POOL, $("REFERENCED_SELECTOR_POOL"), Stream, Record);
    EmitRecordID(ASTRecordTypes.TU_UPDATE_LEXICAL, $("TU_UPDATE_LEXICAL"), Stream, Record);
    EmitRecordID(ASTRecordTypes.SEMA_DECL_REFS, $("SEMA_DECL_REFS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.WEAK_UNDECLARED_IDENTIFIERS, $("WEAK_UNDECLARED_IDENTIFIERS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.PENDING_IMPLICIT_INSTANTIATIONS, $("PENDING_IMPLICIT_INSTANTIATIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.UPDATE_VISIBLE, $("UPDATE_VISIBLE"), Stream, Record);
    EmitRecordID(ASTRecordTypes.DECL_UPDATE_OFFSETS, $("DECL_UPDATE_OFFSETS"), Stream, Record);
    EmitRecordID(DECL_UPDATES, $("DECL_UPDATES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.DIAG_PRAGMA_MAPPINGS, $("DIAG_PRAGMA_MAPPINGS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.CUDA_SPECIAL_DECL_REFS, $("CUDA_SPECIAL_DECL_REFS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.HEADER_SEARCH_TABLE, $("HEADER_SEARCH_TABLE"), Stream, Record);
    EmitRecordID(ASTRecordTypes.FP_PRAGMA_OPTIONS, $("FP_PRAGMA_OPTIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.OPENCL_EXTENSIONS, $("OPENCL_EXTENSIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.DELEGATING_CTORS, $("DELEGATING_CTORS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.KNOWN_NAMESPACES, $("KNOWN_NAMESPACES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.MODULE_OFFSET_MAP, $("MODULE_OFFSET_MAP"), Stream, Record);
    EmitRecordID(ASTRecordTypes.SOURCE_MANAGER_LINE_TABLE, $("SOURCE_MANAGER_LINE_TABLE"), Stream, Record);
    EmitRecordID(ASTRecordTypes.OBJC_CATEGORIES_MAP, $("OBJC_CATEGORIES_MAP"), Stream, Record);
    EmitRecordID(ASTRecordTypes.FILE_SORTED_DECLS, $("FILE_SORTED_DECLS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.IMPORTED_MODULES, $("IMPORTED_MODULES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.OBJC_CATEGORIES, $("OBJC_CATEGORIES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.MACRO_OFFSET, $("MACRO_OFFSET"), Stream, Record);
    EmitRecordID(ASTRecordTypes.INTERESTING_IDENTIFIERS, $("INTERESTING_IDENTIFIERS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.UNDEFINED_BUT_USED, $("UNDEFINED_BUT_USED"), Stream, Record);
    EmitRecordID(ASTRecordTypes.LATE_PARSED_TEMPLATE, $("LATE_PARSED_TEMPLATE"), Stream, Record);
    EmitRecordID(ASTRecordTypes.OPTIMIZE_PRAGMA_OPTIONS, $("OPTIMIZE_PRAGMA_OPTIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.MSSTRUCT_PRAGMA_OPTIONS, $("MSSTRUCT_PRAGMA_OPTIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.POINTERS_TO_MEMBERS_PRAGMA_OPTIONS, $("POINTERS_TO_MEMBERS_PRAGMA_OPTIONS"), Stream, Record);
    EmitRecordID(ASTRecordTypes.UNUSED_LOCAL_TYPEDEF_NAME_CANDIDATES, $("UNUSED_LOCAL_TYPEDEF_NAME_CANDIDATES"), Stream, Record);
    EmitRecordID(ASTRecordTypes.DELETE_EXPRS_TO_ANALYZE, $("DELETE_EXPRS_TO_ANALYZE"), Stream, Record);
    
    // SourceManager Block.
    EmitBlockID(BlockIDs.SOURCE_MANAGER_BLOCK_ID, $("SOURCE_MANAGER_BLOCK"), Stream, Record);
    EmitRecordID(SourceManagerRecordTypes.SM_SLOC_FILE_ENTRY, $("SM_SLOC_FILE_ENTRY"), Stream, Record);
    EmitRecordID(SourceManagerRecordTypes.SM_SLOC_BUFFER_ENTRY, $("SM_SLOC_BUFFER_ENTRY"), Stream, Record);
    EmitRecordID(SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB, $("SM_SLOC_BUFFER_BLOB"), Stream, Record);
    EmitRecordID(SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB_COMPRESSED, $("SM_SLOC_BUFFER_BLOB_COMPRESSED"), Stream, Record);
    EmitRecordID(SourceManagerRecordTypes.SM_SLOC_EXPANSION_ENTRY, $("SM_SLOC_EXPANSION_ENTRY"), Stream, Record);
    
    // Preprocessor Block.
    EmitBlockID(BlockIDs.PREPROCESSOR_BLOCK_ID, $("PREPROCESSOR_BLOCK"), Stream, Record);
    EmitRecordID(PreprocessorRecordTypes.PP_MACRO_DIRECTIVE_HISTORY, $("PP_MACRO_DIRECTIVE_HISTORY"), Stream, Record);
    EmitRecordID(PreprocessorRecordTypes.PP_MACRO_FUNCTION_LIKE, $("PP_MACRO_FUNCTION_LIKE"), Stream, Record);
    EmitRecordID(PreprocessorRecordTypes.PP_MACRO_OBJECT_LIKE, $("PP_MACRO_OBJECT_LIKE"), Stream, Record);
    EmitRecordID(PreprocessorRecordTypes.PP_MODULE_MACRO, $("PP_MODULE_MACRO"), Stream, Record);
    EmitRecordID(PreprocessorRecordTypes.PP_TOKEN, $("PP_TOKEN"), Stream, Record);
    
    // Submodule Block.
    EmitBlockID(BlockIDs.SUBMODULE_BLOCK_ID, $("SUBMODULE_BLOCK"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_METADATA, $("SUBMODULE_METADATA"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_DEFINITION, $("SUBMODULE_DEFINITION"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_UMBRELLA_HEADER, $("SUBMODULE_UMBRELLA_HEADER"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_HEADER, $("SUBMODULE_HEADER"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_TOPHEADER, $("SUBMODULE_TOPHEADER"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_UMBRELLA_DIR, $("SUBMODULE_UMBRELLA_DIR"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_IMPORTS, $("SUBMODULE_IMPORTS"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_EXPORTS, $("SUBMODULE_EXPORTS"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_REQUIRES, $("SUBMODULE_REQUIRES"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_EXCLUDED_HEADER, $("SUBMODULE_EXCLUDED_HEADER"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_LINK_LIBRARY, $("SUBMODULE_LINK_LIBRARY"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_CONFIG_MACRO, $("SUBMODULE_CONFIG_MACRO"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_CONFLICT, $("SUBMODULE_CONFLICT"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_PRIVATE_HEADER, $("SUBMODULE_PRIVATE_HEADER"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_TEXTUAL_HEADER, $("SUBMODULE_TEXTUAL_HEADER"), Stream, Record);
    EmitRecordID(SubmoduleRecordTypes.SUBMODULE_PRIVATE_TEXTUAL_HEADER, $("SUBMODULE_PRIVATE_TEXTUAL_HEADER"), Stream, Record);
    
    // Comments Block.
    EmitBlockID(BlockIDs.COMMENTS_BLOCK_ID, $("COMMENTS_BLOCK"), Stream, Record);
    EmitRecordID(CommentRecordTypes.COMMENTS_RAW_COMMENT, $("COMMENTS_RAW_COMMENT"), Stream, Record);
    
    // Decls and Types block.
    EmitBlockID(BlockIDs.DECLTYPES_BLOCK_ID, $("DECLTYPES_BLOCK"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_EXT_QUAL, $("TYPE_EXT_QUAL"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_COMPLEX, $("TYPE_COMPLEX"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_POINTER, $("TYPE_POINTER"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_BLOCK_POINTER, $("TYPE_BLOCK_POINTER"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_LVALUE_REFERENCE, $("TYPE_LVALUE_REFERENCE"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_RVALUE_REFERENCE, $("TYPE_RVALUE_REFERENCE"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_MEMBER_POINTER, $("TYPE_MEMBER_POINTER"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_CONSTANT_ARRAY, $("TYPE_CONSTANT_ARRAY"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_INCOMPLETE_ARRAY, $("TYPE_INCOMPLETE_ARRAY"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_VARIABLE_ARRAY, $("TYPE_VARIABLE_ARRAY"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_VECTOR, $("TYPE_VECTOR"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_EXT_VECTOR, $("TYPE_EXT_VECTOR"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_FUNCTION_NO_PROTO, $("TYPE_FUNCTION_NO_PROTO"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_FUNCTION_PROTO, $("TYPE_FUNCTION_PROTO"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_TYPEDEF, $("TYPE_TYPEDEF"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_TYPEOF_EXPR, $("TYPE_TYPEOF_EXPR"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_TYPEOF, $("TYPE_TYPEOF"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_RECORD, $("TYPE_RECORD"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_ENUM, $("TYPE_ENUM"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_OBJC_INTERFACE, $("TYPE_OBJC_INTERFACE"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_OBJC_OBJECT_POINTER, $("TYPE_OBJC_OBJECT_POINTER"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_DECLTYPE, $("TYPE_DECLTYPE"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_ELABORATED, $("TYPE_ELABORATED"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_SUBST_TEMPLATE_TYPE_PARM, $("TYPE_SUBST_TEMPLATE_TYPE_PARM"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_UNRESOLVED_USING, $("TYPE_UNRESOLVED_USING"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_INJECTED_CLASS_NAME, $("TYPE_INJECTED_CLASS_NAME"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_OBJC_OBJECT, $("TYPE_OBJC_OBJECT"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_TEMPLATE_TYPE_PARM, $("TYPE_TEMPLATE_TYPE_PARM"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_TEMPLATE_SPECIALIZATION, $("TYPE_TEMPLATE_SPECIALIZATION"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_DEPENDENT_NAME, $("TYPE_DEPENDENT_NAME"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_DEPENDENT_TEMPLATE_SPECIALIZATION, $("TYPE_DEPENDENT_TEMPLATE_SPECIALIZATION"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_DEPENDENT_SIZED_ARRAY, $("TYPE_DEPENDENT_SIZED_ARRAY"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_PAREN, $("TYPE_PAREN"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_PACK_EXPANSION, $("TYPE_PACK_EXPANSION"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_ATTRIBUTED, $("TYPE_ATTRIBUTED"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_SUBST_TEMPLATE_TYPE_PARM_PACK, $("TYPE_SUBST_TEMPLATE_TYPE_PARM_PACK"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_AUTO, $("TYPE_AUTO"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_UNARY_TRANSFORM, $("TYPE_UNARY_TRANSFORM"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_ATOMIC, $("TYPE_ATOMIC"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_DECAYED, $("TYPE_DECAYED"), Stream, Record);
    EmitRecordID(TypeCode.TYPE_ADJUSTED, $("TYPE_ADJUSTED"), Stream, Record);
    EmitRecordID(LOCAL_REDECLARATIONS, $("LOCAL_REDECLARATIONS"), Stream, Record);
    EmitRecordID(DeclCode.DECL_TYPEDEF, $("DECL_TYPEDEF"), Stream, Record);
    EmitRecordID(DeclCode.DECL_TYPEALIAS, $("DECL_TYPEALIAS"), Stream, Record);
    EmitRecordID(DeclCode.DECL_ENUM, $("DECL_ENUM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_RECORD, $("DECL_RECORD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_ENUM_CONSTANT, $("DECL_ENUM_CONSTANT"), Stream, Record);
    EmitRecordID(DeclCode.DECL_FUNCTION, $("DECL_FUNCTION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_METHOD, $("DECL_OBJC_METHOD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_INTERFACE, $("DECL_OBJC_INTERFACE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_PROTOCOL, $("DECL_OBJC_PROTOCOL"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_IVAR, $("DECL_OBJC_IVAR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_AT_DEFS_FIELD, $("DECL_OBJC_AT_DEFS_FIELD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_CATEGORY, $("DECL_OBJC_CATEGORY"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_CATEGORY_IMPL, $("DECL_OBJC_CATEGORY_IMPL"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_IMPLEMENTATION, $("DECL_OBJC_IMPLEMENTATION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_COMPATIBLE_ALIAS, $("DECL_OBJC_COMPATIBLE_ALIAS"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_PROPERTY, $("DECL_OBJC_PROPERTY"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_PROPERTY_IMPL, $("DECL_OBJC_PROPERTY_IMPL"), Stream, Record);
    EmitRecordID(DeclCode.DECL_FIELD, $("DECL_FIELD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_MS_PROPERTY, $("DECL_MS_PROPERTY"), Stream, Record);
    EmitRecordID(DeclCode.DECL_VAR, $("DECL_VAR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_IMPLICIT_PARAM, $("DECL_IMPLICIT_PARAM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_PARM_VAR, $("DECL_PARM_VAR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_FILE_SCOPE_ASM, $("DECL_FILE_SCOPE_ASM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_BLOCK, $("DECL_BLOCK"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CONTEXT_LEXICAL, $("DECL_CONTEXT_LEXICAL"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CONTEXT_VISIBLE, $("DECL_CONTEXT_VISIBLE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_NAMESPACE, $("DECL_NAMESPACE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_NAMESPACE_ALIAS, $("DECL_NAMESPACE_ALIAS"), Stream, Record);
    EmitRecordID(DeclCode.DECL_USING, $("DECL_USING"), Stream, Record);
    EmitRecordID(DeclCode.DECL_USING_SHADOW, $("DECL_USING_SHADOW"), Stream, Record);
    EmitRecordID(DeclCode.DECL_USING_DIRECTIVE, $("DECL_USING_DIRECTIVE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_UNRESOLVED_USING_VALUE, $("DECL_UNRESOLVED_USING_VALUE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_UNRESOLVED_USING_TYPENAME, $("DECL_UNRESOLVED_USING_TYPENAME"), Stream, Record);
    EmitRecordID(DeclCode.DECL_LINKAGE_SPEC, $("DECL_LINKAGE_SPEC"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_RECORD, $("DECL_CXX_RECORD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_METHOD, $("DECL_CXX_METHOD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_CONSTRUCTOR, $("DECL_CXX_CONSTRUCTOR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_INHERITED_CONSTRUCTOR, $("DECL_CXX_INHERITED_CONSTRUCTOR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_DESTRUCTOR, $("DECL_CXX_DESTRUCTOR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_CONVERSION, $("DECL_CXX_CONVERSION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_ACCESS_SPEC, $("DECL_ACCESS_SPEC"), Stream, Record);
    EmitRecordID(DeclCode.DECL_FRIEND, $("DECL_FRIEND"), Stream, Record);
    EmitRecordID(DeclCode.DECL_FRIEND_TEMPLATE, $("DECL_FRIEND_TEMPLATE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CLASS_TEMPLATE, $("DECL_CLASS_TEMPLATE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CLASS_TEMPLATE_SPECIALIZATION, $("DECL_CLASS_TEMPLATE_SPECIALIZATION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CLASS_TEMPLATE_PARTIAL_SPECIALIZATION, $("DECL_CLASS_TEMPLATE_PARTIAL_SPECIALIZATION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_VAR_TEMPLATE, $("DECL_VAR_TEMPLATE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_VAR_TEMPLATE_SPECIALIZATION, $("DECL_VAR_TEMPLATE_SPECIALIZATION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_VAR_TEMPLATE_PARTIAL_SPECIALIZATION, $("DECL_VAR_TEMPLATE_PARTIAL_SPECIALIZATION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_FUNCTION_TEMPLATE, $("DECL_FUNCTION_TEMPLATE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_TEMPLATE_TYPE_PARM, $("DECL_TEMPLATE_TYPE_PARM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_NON_TYPE_TEMPLATE_PARM, $("DECL_NON_TYPE_TEMPLATE_PARM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_TEMPLATE_TEMPLATE_PARM, $("DECL_TEMPLATE_TEMPLATE_PARM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_TYPE_ALIAS_TEMPLATE, $("DECL_TYPE_ALIAS_TEMPLATE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_STATIC_ASSERT, $("DECL_STATIC_ASSERT"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_BASE_SPECIFIERS, $("DECL_CXX_BASE_SPECIFIERS"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CXX_CTOR_INITIALIZERS, $("DECL_CXX_CTOR_INITIALIZERS"), Stream, Record);
    EmitRecordID(DeclCode.DECL_INDIRECTFIELD, $("DECL_INDIRECTFIELD"), Stream, Record);
    EmitRecordID(DeclCode.DECL_EXPANDED_NON_TYPE_TEMPLATE_PARM_PACK, $("DECL_EXPANDED_NON_TYPE_TEMPLATE_PARM_PACK"), Stream, Record);
    EmitRecordID(DeclCode.DECL_EXPANDED_TEMPLATE_TEMPLATE_PARM_PACK, $("DECL_EXPANDED_TEMPLATE_TEMPLATE_PARM_PACK"), Stream, Record);
    EmitRecordID(DeclCode.DECL_CLASS_SCOPE_FUNCTION_SPECIALIZATION, $("DECL_CLASS_SCOPE_FUNCTION_SPECIALIZATION"), Stream, Record);
    EmitRecordID(DeclCode.DECL_IMPORT, $("DECL_IMPORT"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OMP_THREADPRIVATE, $("DECL_OMP_THREADPRIVATE"), Stream, Record);
    EmitRecordID(DeclCode.DECL_EMPTY, $("DECL_EMPTY"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OBJC_TYPE_PARAM, $("DECL_OBJC_TYPE_PARAM"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OMP_CAPTUREDEXPR, $("DECL_OMP_CAPTUREDEXPR"), Stream, Record);
    EmitRecordID(DeclCode.DECL_PRAGMA_COMMENT, $("DECL_PRAGMA_COMMENT"), Stream, Record);
    EmitRecordID(DeclCode.DECL_PRAGMA_DETECT_MISMATCH, $("DECL_PRAGMA_DETECT_MISMATCH"), Stream, Record);
    EmitRecordID(DeclCode.DECL_OMP_DECLARE_REDUCTION, $("DECL_OMP_DECLARE_REDUCTION"), Stream, Record);
    
    // Statements and Exprs can occur in the Decls and Types block.
    AddStmtsExprs(Stream, Record);
    EmitBlockID(BlockIDs.PREPROCESSOR_DETAIL_BLOCK_ID, $("PREPROCESSOR_DETAIL_BLOCK"), Stream, Record);
    EmitRecordID(PreprocessorDetailRecordTypes.PPD_MACRO_EXPANSION, $("PPD_MACRO_EXPANSION"), Stream, Record);
    EmitRecordID(PreprocessorDetailRecordTypes.PPD_MACRO_DEFINITION, $("PPD_MACRO_DEFINITION"), Stream, Record);
    EmitRecordID(PreprocessorDetailRecordTypes.PPD_INCLUSION_DIRECTIVE, $("PPD_INCLUSION_DIRECTIVE"), Stream, Record);
    
    // Decls and Types block.
    EmitBlockID(BlockIDs.EXTENSION_BLOCK_ID, $("EXTENSION_BLOCK"), Stream, Record);
    EmitRecordID(ExtensionBlockRecordTypes.EXTENSION_METADATA, $("EXTENSION_METADATA"), Stream, Record);
    Stream.ExitBlock();
  }

  
  /// \brief Write the control block.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteControlBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1223,
   FQN="clang::ASTWriter::WriteControlBlock", NM="_ZN5clang9ASTWriter17WriteControlBlockERNS_12PreprocessorERNS_10ASTContextEN4llvm9StringRefERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17WriteControlBlockERNS_12PreprocessorERNS_10ASTContextEN4llvm9StringRefERKSs")
  //</editor-fold>
  private long/*uint64_t*/ WriteControlBlock(final Preprocessor /*&*/ PP, 
                   final ASTContext /*&*/ Context, 
                   StringRef isysroot, 
                   final /*const*/std.string/*&*/ OutputFile) {
    /*uint*/int Signature = 0;
    
    //JAVA: using namespace llvm;
    Stream.EnterSubblock(BlockIDs.CONTROL_BLOCK_ID, 5);
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    
    // Metadata
    BitCodeAbbrev /*P*/ MetadataAbbrev = new BitCodeAbbrev();
    MetadataAbbrev.Add(new BitCodeAbbrevOp(ControlRecordTypes.METADATA));
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(16))); // Major
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(16))); // Minor
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(16))); // Clang maj.
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(16))); // Clang min.
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Relocatable
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Timestamps
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Errors
    MetadataAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // SVN branch/tag
    /*uint*/int MetadataAbbrevCode = Stream.EmitAbbrev(MetadataAbbrev);
    assert ((!(WritingModule != null) || isysroot.empty())) : "writing module as a relocatable PCH?";
    {
      long Record$1[/*8*/] = new /*ullong*/long [/*8*/] {
        ControlRecordTypes.METADATA, VERSION_MAJOR, VERSION_MINOR, 
        atol(CLANG_VERSION_MAJOR), atol(CLANG_VERSION_MINOR), 
        $uint2ullong(!isysroot.empty()), $uint2ullong(IncludeTimestamps), 
        $uint2ullong(ASTHasCompilerErrors)};
      Stream.EmitRecordWithBlob(MetadataAbbrevCode, Record$1, 
          new StringRef(getClangFullRepositoryVersion()));
    }
    if ((WritingModule != null)) {
      // For implicit modules we output a signature that we can use to ensure
      // duplicate module builds don't collide in the cache as their output order
      // is non-deterministic.
      // FIXME: Remove this when output is deterministic.
      if (Context.getLangOpts().ImplicitModules) {
        Signature = getSignature();
        long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {Signature};
        Stream.EmitRecord(ControlRecordTypes.SIGNATURE, new ArrayRefULong(Record$1));
      }
      
      // Module name
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ControlRecordTypes.MODULE_NAME));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int AbbrevCode = Stream.EmitAbbrev(Abbrev);
      long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {ControlRecordTypes.MODULE_NAME};
      Stream.EmitRecordWithBlob(AbbrevCode, Record$1, new StringRef(WritingModule.Name));
    }
    if ((WritingModule != null) && (WritingModule.Directory != null)) {
      SmallString/*<128>*/ BaseDir/*J*/= new SmallString/*<128>*/(128, new StringRef(WritingModule.Directory.getName()));
      cleanPathForOutput(Context.getSourceManager().getFileManager(), BaseDir);
      
      // If the home of the module is the current working directory, then we
      // want to pick up the cwd of the build process loading the module, not
      // our cwd, when we load this module.
      if (!PP.getHeaderSearchInfo().
          getHeaderSearchOpts().
          ModuleMapFileHomeIsCwd
         || $noteq_StringRef(/*STRINGREF_STR*/WritingModule.Directory.getName(), /*STRINGREF_STR*/".")) {
        // Module directory.
        BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
        Abbrev.Add(new BitCodeAbbrevOp(ControlRecordTypes.MODULE_DIRECTORY));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Directory
        /*uint*/int AbbrevCode = Stream.EmitAbbrev(Abbrev);
        
        long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {ControlRecordTypes.MODULE_DIRECTORY};
        Stream.EmitRecordWithBlob(AbbrevCode, Record$1, BaseDir.$StringRef());
      }
      
      // Write out all other paths relative to the base directory if possible.
      BaseDirectory.assign$T(BaseDir.begin(), BaseDir.end());
    } else if (!isysroot.empty()) {
      // Write out paths relative to the sysroot if possible.
      BaseDirectory.$assignMove(isysroot.$string());
    }
    
    // Module map file
    if ((WritingModule != null)) {
      Record.clear();
      
      final ModuleMap /*&*/ Map = PP.getHeaderSearchInfo().getModuleMap();
      
      // Primary module map file.
      AddPath(new StringRef(Map.getModuleMapFileForUniquing(WritingModule).getName()), Record);
      {
        
        // Additional module map files.
        SmallPtrSet</*const*/ FileEntry /*P*/>/*P*/ AdditionalModMaps = Map.getAdditionalModuleMapFiles(WritingModule);
        if ((AdditionalModMaps != null)) {
          Record.push_back($uint2ullong(AdditionalModMaps.size()));
          for (/*const*/ FileEntry /*P*/ F : $Deref(AdditionalModMaps))  {
            AddPath(new StringRef(F.getName()), Record);
          }
        } else {
          Record.push_back($int2ullong(0));
        }
      }
      
      Stream.EmitRecord(ControlRecordTypes.MODULE_MAP_FILE, Record);
    }
    
    // Imports
    if ((Chain != null)) {
      final ModuleManager /*&*/ Mgr = Chain.getModuleManager();
      Record.clear();
      
      for (ModuleFile /*P*/ M : Mgr) {
        // Skip modules that weren't directly imported.
        if (!M.isDirectlyImported()) {
          continue;
        }
        
        Record.push_back($uint2ullong((/*uint*/int)M.Kind.getValue())); // FIXME: Stable encoding
        AddSourceLocation(new SourceLocation(M.ImportLoc), Record);
        Record.push_back($long2ullong(M.File.getSize()));
        Record.push_back($long2ullong(getTimestampForOutput(M.File)));
        Record.push_back($uint2ullong(M.Signature));
        AddPath(new StringRef(M.FileName), Record);
      }
      Stream.EmitRecord(ControlRecordTypes.IMPORTS, Record);
    }
    
    // Write the options block.
    Stream.EnterSubblock(BlockIDs.OPTIONS_BLOCK_ID, 4);
    
    // Language options.
    Record.clear();
    final /*const*/ LangOptions /*&*/ LangOpts = Context.getLangOpts();
    
    // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
    Record.push_back($uint2ullong(LangOpts.C99));
    Record.push_back($uint2ullong(LangOpts.C11));
    Record.push_back($uint2ullong(LangOpts.MSVCCompat));
    Record.push_back($uint2ullong(LangOpts.MicrosoftExt));
    Record.push_back($uint2ullong(LangOpts.AsmBlocks));
    Record.push_back($uint2ullong(LangOpts.Borland));
    Record.push_back($uint2ullong(LangOpts.CPlusPlus));
    Record.push_back($uint2ullong(LangOpts.CPlusPlus11));
    Record.push_back($uint2ullong(LangOpts.CPlusPlus14));
    Record.push_back($uint2ullong(LangOpts.CPlusPlus1z));
    Record.push_back($uint2ullong(LangOpts.ObjC1));
    Record.push_back($uint2ullong(LangOpts.ObjC2));
    Record.push_back($uint2ullong(LangOpts.ObjCDefaultSynthProperties));
    Record.push_back($uint2ullong(LangOpts.EncodeExtendedBlockSig));
    Record.push_back($uint2ullong(LangOpts.ObjCInferRelatedResultType));
    Record.push_back($uint2ullong(LangOpts.AppExt));
    Record.push_back($uint2ullong(LangOpts.Trigraphs));
    Record.push_back($uint2ullong(LangOpts.LineComment));
    Record.push_back($uint2ullong(LangOpts.Bool));
    Record.push_back($uint2ullong(LangOpts.Half));
    Record.push_back($uint2ullong(LangOpts.WChar));
    Record.push_back($uint2ullong(LangOpts.DeclSpecKeyword));
    Record.push_back($uint2ullong(LangOpts.DollarIdents));
    Record.push_back($uint2ullong(LangOpts.AsmPreprocessor));
    Record.push_back($uint2ullong(LangOpts.GNUMode));
    Record.push_back($uint2ullong(LangOpts.GNUKeywords));
    Record.push_back($uint2ullong(LangOpts.ImplicitInt));
    Record.push_back($uint2ullong(LangOpts.Digraphs));
    Record.push_back($uint2ullong(LangOpts.HexFloats));
    Record.push_back($uint2ullong(LangOpts.CXXOperatorNames));
    Record.push_back($uint2ullong(LangOpts.AppleKext));
    Record.push_back($uint2ullong(LangOpts.PascalStrings));
    Record.push_back($uint2ullong(LangOpts.WritableStrings));
    Record.push_back($uint2ullong(LangOpts.ConstStrings));
    Record.push_back($uint2ullong(LangOpts.LaxVectorConversions));
    Record.push_back($uint2ullong(LangOpts.AltiVec));
    Record.push_back($uint2ullong(LangOpts.ZVector));
    Record.push_back($uint2ullong(LangOpts.Exceptions));
    Record.push_back($uint2ullong(LangOpts.ObjCExceptions));
    Record.push_back($uint2ullong(LangOpts.CXXExceptions));
    Record.push_back($uint2ullong(LangOpts.SjLjExceptions));
    Record.push_back($uint2ullong(LangOpts.ExternCNoUnwind));
    Record.push_back($uint2ullong(LangOpts.TraditionalCPP));
    Record.push_back($uint2ullong(LangOpts.RTTI));
    Record.push_back($uint2ullong(LangOpts.RTTIData));
    Record.push_back($uint2ullong(LangOpts.MSBitfields));
    Record.push_back($uint2ullong(LangOpts.Freestanding));
    Record.push_back($uint2ullong(LangOpts.NoBuiltin));
    Record.push_back($uint2ullong(LangOpts.NoMathBuiltin));
    Record.push_back($uint2ullong(LangOpts.GNUAsm));
    Record.push_back($uint2ullong(LangOpts.Coroutines));
    Record.push_back($uint2ullong(LangOpts.ThreadsafeStatics));
    Record.push_back($uint2ullong(LangOpts.POSIXThreads));
    Record.push_back($uint2ullong(LangOpts.Blocks));
    Record.push_back($uint2ullong(LangOpts.EmitAllDecls));
    Record.push_back($uint2ullong(LangOpts.MathErrno));
    Record.push_back($uint2ullong(LangOpts.HeinousExtensions));
    Record.push_back($uint2ullong(LangOpts.Modules));
    Record.push_back($uint2ullong(LangOpts.CompilingModule));
    Record.push_back($uint2ullong(LangOpts.ModulesDeclUse));
    Record.push_back($uint2ullong(LangOpts.ModulesSearchAll));
    Record.push_back($uint2ullong(LangOpts.ModulesStrictDeclUse));
    Record.push_back($uint2ullong(LangOpts.ModulesErrorRecovery));
    Record.push_back($uint2ullong(LangOpts.ImplicitModules));
    Record.push_back($uint2ullong(LangOpts.ModulesLocalVisibility));
    Record.push_back($uint2ullong(LangOpts.Optimize));
    Record.push_back($uint2ullong(LangOpts.OptimizeSize));
    Record.push_back($uint2ullong(LangOpts.Static));
    Record.push_back($uint2ullong(LangOpts.PackStruct));
    Record.push_back($uint2ullong(LangOpts.MaxTypeAlign));
    Record.push_back($uint2ullong(LangOpts.AlignDouble));
    Record.push_back($uint2ullong($2bits_uint2uint(LangOpts.PICLevel)));
    Record.push_back($uint2ullong(LangOpts.PIE));
    Record.push_back($uint2ullong(LangOpts.GNUInline));
    Record.push_back($uint2ullong(LangOpts.NoInlineDefine));
    Record.push_back($uint2ullong(LangOpts.Deprecated));
    Record.push_back($uint2ullong(LangOpts.FastMath));
    Record.push_back($uint2ullong(LangOpts.FiniteMathOnly));
    Record.push_back($uint2ullong(LangOpts.UnsafeFPMath));
    Record.push_back($uint2ullong(LangOpts.ObjCGCBitmapPrint));
    Record.push_back($uint2ullong(LangOpts.AccessControl));
    Record.push_back($uint2ullong(LangOpts.CharIsSigned));
    Record.push_back($uint2ullong(LangOpts.ShortWChar));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getMSPointerToMemberRepresentationMethod().getValue()))));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getDefaultCallingConv().getValue()))));
    Record.push_back($uint2ullong(LangOpts.ShortEnums));
    Record.push_back($uint2ullong(LangOpts.OpenCL));
    Record.push_back($uint2ullong(LangOpts.OpenCLVersion));
    Record.push_back($uint2ullong(LangOpts.NativeHalfType));
    Record.push_back($uint2ullong(LangOpts.NativeHalfArgsAndReturns));
    Record.push_back($uint2ullong(LangOpts.HalfArgsAndReturns));
    Record.push_back($uint2ullong(LangOpts.CUDA));
    Record.push_back($uint2ullong(LangOpts.OpenMP));
    Record.push_back($uint2ullong(LangOpts.OpenMPUseTLS));
    Record.push_back($uint2ullong(LangOpts.OpenMPIsDevice));
    Record.push_back($uint2ullong(LangOpts.RenderScript));
    Record.push_back($uint2ullong(LangOpts.CUDAIsDevice));
    Record.push_back($uint2ullong(LangOpts.CUDAAllowVariadicFunctions));
    Record.push_back($uint2ullong(LangOpts.CUDAHostDeviceConstexpr));
    Record.push_back($uint2ullong(LangOpts.CUDADeviceFlushDenormalsToZero));
    Record.push_back($uint2ullong(LangOpts.CUDADeviceApproxTranscendentals));
    Record.push_back($uint2ullong(LangOpts.SizedDeallocation));
    Record.push_back($uint2ullong(LangOpts.ConceptsTS));
    Record.push_back($uint2ullong(LangOpts.ElideConstructors));
    Record.push_back($uint2ullong(LangOpts.DumpRecordLayouts));
    Record.push_back($uint2ullong(LangOpts.DumpRecordLayoutsSimple));
    Record.push_back($uint2ullong(LangOpts.DumpVTableLayouts));
    Record.push_back($uint2ullong(LangOpts.NoConstantCFStrings));
    Record.push_back($uint2ullong(LangOpts.InlineVisibilityHidden));
    Record.push_back($uint2ullong(LangOpts.ParseUnknownAnytype));
    Record.push_back($uint2ullong(LangOpts.DebuggerSupport));
    Record.push_back($uint2ullong(LangOpts.DebuggerCastResultToId));
    Record.push_back($uint2ullong(LangOpts.DebuggerObjCLiteral));
    Record.push_back($uint2ullong(LangOpts.SpellChecking));
    Record.push_back($uint2ullong(LangOpts.SinglePrecisionConstants));
    Record.push_back($uint2ullong(LangOpts.FastRelaxedMath));
    Record.push_back($uint2ullong(LangOpts.DefaultFPContract));
    Record.push_back($uint2ullong(LangOpts.NoBitFieldTypeAlign));
    Record.push_back($uint2ullong(LangOpts.HexagonQdsp6Compat));
    Record.push_back($uint2ullong(LangOpts.ObjCAutoRefCount));
    Record.push_back($uint2ullong(LangOpts.ObjCWeakRuntime));
    Record.push_back($uint2ullong(LangOpts.ObjCWeak));
    Record.push_back($uint2ullong(LangOpts.ObjCSubscriptingLegacyRuntime));
    Record.push_back($uint2ullong(LangOpts.FakeAddressSpaceMap));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getAddressSpaceMapMangling().getValue()))));
    Record.push_back($uint2ullong(LangOpts.IncludeDefaultHeader));
    Record.push_back($uint2ullong(LangOpts.DelayedTemplateParsing));
    Record.push_back($uint2ullong(LangOpts.BlocksRuntimeOptional));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getGC().getValue()))));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getValueVisibilityMode().getValue()))));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getTypeVisibilityMode().getValue()))));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getStackProtector().getValue()))));
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(LangOpts.getSignedOverflowBehavior().getValue()))));
    Record.push_back($uint2ullong(LangOpts.ArrowDepth));
    Record.push_back($uint2ullong(LangOpts.InstantiationDepth));
    Record.push_back($uint2ullong(LangOpts.ConstexprCallDepth));
    Record.push_back($uint2ullong(LangOpts.ConstexprStepLimit));
    Record.push_back($uint2ullong(LangOpts.BracketDepth));
    Record.push_back($uint2ullong(LangOpts.NumLargeByValueCopy));
    Record.push_back($uint2ullong(LangOpts.MSCompatibilityVersion));
    Record.push_back($uint2ullong($2bits_uint2uint(LangOpts.VtorDispMode)));
    Record.push_back($uint2ullong(LangOpts.ApplePragmaPack));
    Record.push_back($uint2ullong(LangOpts.RetainCommentsFromSystemHeaders));
    Record.push_back($uint2ullong($2bits_uint2uint(LangOpts.SanitizeAddressFieldPadding)));
    
    // AddressSanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Address) ? 1 : 0));
    
    // Kernel AddressSanitizer (KASan)
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.KernelAddress) ? 1 : 0));
    
    // MemorySanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Memory) ? 1 : 0));
    
    // ThreadSanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Thread) ? 1 : 0));
    
    // LeakSanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Leak) ? 1 : 0));
    
    // UndefinedBehaviorSanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Alignment) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.ArrayBounds) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Bool) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Enum) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.FloatCastOverflow) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.FloatDivideByZero) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Function) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.IntegerDivideByZero) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.NonnullAttribute) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Null) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.ObjectSize) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Return) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.ReturnsNonnullAttribute) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.ShiftBase) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.ShiftExponent) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.SignedIntegerOverflow) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Unreachable) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.VLABound) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.Vptr) ? 1 : 0));
    
    // IntegerSanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.UnsignedIntegerOverflow) ? 1 : 0));
    
    // DataFlowSanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.DataFlow) ? 1 : 0));
    
    // Control Flow Integrity
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.CFICastStrict) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.CFIDerivedCast) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.CFIICall) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.CFIUnrelatedCast) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.CFINVCall) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.CFIVCall) ? 1 : 0));
    
    // Safe Stack
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.SafeStack) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.LocalBounds) ? 1 : 0));
    
    // EfficiencySanitizer
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.EfficiencyCacheFrag) ? 1 : 0));
    Record.push_back((LangOpts.Sanitize.has(SanitizerKind.EfficiencyWorkingSet) ? 1 : 0));
    
    Record.push_back($uint2ullong(LangOpts.ModuleFeatures.size()));
    for (std.string Feature : LangOpts.ModuleFeatures)  {
      AddString(new StringRef(Feature), Record);
    }
    
    Record.push_back($uint2ullong((/*uint*/int)LangOpts.ObjCRuntime.getKind().getValue()));
    AddVersionTuple(LangOpts.ObjCRuntime.getVersion(), Record);
    
    AddString(new StringRef(LangOpts.CurrentModule), Record);
    
    // Comment options.
    Record.push_back($uint2ullong(LangOpts.CommentOpts.BlockCommandNames.size()));
    for (final /*const*/std.string/*&*/ I : LangOpts.CommentOpts.BlockCommandNames) {
      AddString(new StringRef(I), Record);
    }
    Record.push_back((LangOpts.CommentOpts.ParseAllComments ? 1 : 0));
    
    // OpenMP offloading options.
    Record.push_back($uint2ullong(LangOpts.OMPTargetTriples.size()));
    for (final /*const*/ Triple /*&*/ T : LangOpts.OMPTargetTriples)  {
      AddString(new StringRef(T.getTriple()), Record);
    }
    
    AddString(new StringRef(LangOpts.OMPHostIRFile), Record);
    
    Stream.EmitRecord(OptionsRecordTypes.LANGUAGE_OPTIONS, Record);
    
    // Target options.
    Record.clear();
    final /*const*/ TargetInfo /*&*/ Target = Context.getTargetInfo();
    final /*const*/ TargetOptions /*&*/ TargetOpts = Target.getTargetOpts();
    AddString(new StringRef(TargetOpts.Triple), Record);
    AddString(new StringRef(TargetOpts.CPU), Record);
    AddString(new StringRef(TargetOpts.ABI), Record);
    Record.push_back($uint2ullong(TargetOpts.FeaturesAsWritten.size()));
    for (/*uint*/int I = 0, N = TargetOpts.FeaturesAsWritten.size(); I != N; ++I) {
      AddString(new StringRef(TargetOpts.FeaturesAsWritten.$at$Const(I)), Record);
    }
    Record.push_back($uint2ullong(TargetOpts.Features.size()));
    for (/*uint*/int I = 0, N = TargetOpts.Features.size(); I != N; ++I) {
      AddString(new StringRef(TargetOpts.Features.$at$Const(I)), Record);
    }
    Stream.EmitRecord(OptionsRecordTypes.TARGET_OPTIONS, Record);
    
    // Diagnostic options.
    Record.clear();
    final /*const*/ DiagnosticOptions /*&*/ DiagOpts = Context.getDiagnostics().getDiagnosticOptions();
    Record.push_back($uint2ullong(DiagOpts.IgnoreWarnings)); /// -w
    Record.push_back($uint2ullong(DiagOpts.NoRewriteMacros)); /// -Wno-rewrite-macros
    Record.push_back($uint2ullong(DiagOpts.Pedantic)); /// -pedantic
    Record.push_back($uint2ullong(DiagOpts.PedanticErrors)); /// -pedantic-errors
    Record.push_back($uint2ullong(DiagOpts.ShowColumn)); /// Show column number on diagnostics.
    Record.push_back($uint2ullong(DiagOpts.ShowLocation)); /// Show source location information.
    Record.push_back($uint2ullong(DiagOpts.ShowCarets)); /// Show carets in diagnostics.
    Record.push_back($uint2ullong(DiagOpts.ShowFixits)); /// Show fixit information.
    Record.push_back($uint2ullong(DiagOpts.ShowSourceRanges)); /// Show source ranges in numeric form.
    Record.push_back($uint2ullong(DiagOpts.ShowParseableFixits)); /// Show machine parseable fix-its.
    Record.push_back($uint2ullong(DiagOpts.ShowPresumedLoc)); /// Show presumed location for diagnostics.
    Record.push_back($uint2ullong(DiagOpts.ShowOptionNames)); /// Show the option name for mappable
    /// diagnostics.
    Record.push_back($uint2ullong(DiagOpts.ShowNoteIncludeStack)); /// Show include stacks for notes.
    Record.push_back($uint2ullong($2bits_uint2uint(DiagOpts.ShowCategories))); /// Show categories: 0 -> none, 1 -> Number,
    /// 2 -> Full Name.
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(DiagOpts.getFormat().getValue())))); /// Format for diagnostics: 
    Record.push_back($uint2ullong(DiagOpts.ShowColors)); /// Show diagnostics with ANSI color sequences.
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(DiagOpts.getShowOverloads().getValue())))); /// Overload candidates to show.
    Record.push_back($uint2ullong(DiagOpts.VerifyDiagnostics)); /// Check that diagnostics match the expected
    /// diagnostics, indicated by markers in the
    /// input source file.
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(DiagOpts.getVerifyIgnoreUnexpected())))); /// Ignore unexpected diagnostics of
    /// the specified levels when using
    /// -verify.
    Record.push_back($uint2ullong(DiagOpts.ElideType)); /// Elide identical types in template diffing
    Record.push_back($uint2ullong(DiagOpts.ShowTemplateTree)); /// Print a template tree when diffing
    Record.push_back($uint2ullong(DiagOpts.CLFallbackMode)); /// Format for clang-cl fallback mode
    Record.push_back($uint2ullong(DiagOpts.ErrorLimit)); /// Limit # errors emitted.
    /// Limit depth of macro expansion backtrace.
    Record.push_back($uint2ullong(DiagOpts.MacroBacktraceLimit));
    /// Limit depth of instantiation backtrace.
    Record.push_back($uint2ullong(DiagOpts.TemplateBacktraceLimit));
    /// Limit depth of constexpr backtrace.
    Record.push_back($uint2ullong(DiagOpts.ConstexprBacktraceLimit));
    /// Limit number of times to perform spell checking.
    Record.push_back($uint2ullong(DiagOpts.SpellCheckingLimit));
    Record.push_back($uint2ullong(DiagOpts.TabStop)); /// The distance between tab stops.
    /// Column limit for formatting message diagnostics, or 0 if unused.
    Record.push_back($uint2ullong(DiagOpts.MessageLength));
    Record.push_back($uint2ullong(DiagOpts.Warnings.size()));
    for (/*uint*/int I = 0, N = DiagOpts.Warnings.size(); I != N; ++I)  {
      AddString(new StringRef(DiagOpts.Warnings.$at$Const(I)), Record);
    }
    Record.push_back($uint2ullong(DiagOpts.Remarks.size()));
    for (/*uint*/int I = 0, N = DiagOpts.Remarks.size(); I != N; ++I)  {
      AddString(new StringRef(DiagOpts.Remarks.$at$Const(I)), Record);
    }
    // Note: we don't serialize the log or serialization file names, because they
    // are generally transient files and will almost always be overridden.
    Stream.EmitRecord(OptionsRecordTypes.DIAGNOSTIC_OPTIONS, Record);
    
    // File system options.
    Record.clear();
    final /*const*/ FileSystemOptions /*&*/ FSOpts = Context.getSourceManager().getFileManager().getFileSystemOpts();
    AddString(new StringRef(FSOpts.WorkingDir), Record);
    Stream.EmitRecord(OptionsRecordTypes.FILE_SYSTEM_OPTIONS, Record);
    
    // Header search options.
    Record.clear();
    final /*const*/ HeaderSearchOptions /*&*/ HSOpts = PP.getHeaderSearchInfo().getHeaderSearchOpts();
    AddString(new StringRef(HSOpts.Sysroot), Record);
    
    // Include entries.
    Record.push_back($uint2ullong(HSOpts.UserEntries.size()));
    for (/*uint*/int I = 0, N = HSOpts.UserEntries.size(); I != N; ++I) {
      final /*const*/ HeaderSearchOptions.Entry /*&*/ Entry = HSOpts.UserEntries.$at$Const(I);
      AddString(new StringRef(Entry.Path), Record);
      Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(Entry.Group.getValue()))));
      Record.push_back($uint2ullong(Entry.IsFramework));
      Record.push_back($uint2ullong(Entry.IgnoreSysRoot));
    }
    
    // System header prefixes.
    Record.push_back($uint2ullong(HSOpts.SystemHeaderPrefixes.size()));
    for (/*uint*/int I = 0, N = HSOpts.SystemHeaderPrefixes.size(); I != N; ++I) {
      AddString(new StringRef(HSOpts.SystemHeaderPrefixes.$at$Const(I).Prefix), Record);
      Record.push_back((HSOpts.SystemHeaderPrefixes.$at$Const(I).IsSystemHeader ? 1 : 0));
    }
    
    AddString(new StringRef(HSOpts.ResourceDir), Record);
    AddString(new StringRef(HSOpts.ModuleCachePath), Record);
    AddString(new StringRef(HSOpts.ModuleUserBuildPath), Record);
    Record.push_back($uint2ullong(HSOpts.DisableModuleHash));
    Record.push_back($uint2ullong(HSOpts.UseBuiltinIncludes));
    Record.push_back($uint2ullong(HSOpts.UseStandardSystemIncludes));
    Record.push_back($uint2ullong(HSOpts.UseStandardCXXIncludes));
    Record.push_back($uint2ullong(HSOpts.UseLibcxx));
    // Write out the specific module cache path that contains the module files.
    AddString(PP.getHeaderSearchInfo().getModuleCachePath(), Record);
    Stream.EmitRecord(OptionsRecordTypes.HEADER_SEARCH_OPTIONS, Record);
    
    // Preprocessor options.
    Record.clear();
    final /*const*/ PreprocessorOptions /*&*/ PPOpts = PP.getPreprocessorOpts();
    
    // Macro definitions.
    Record.push_back($uint2ullong(PPOpts.Macros.size()));
    for (/*uint*/int I = 0, N = PPOpts.Macros.size(); I != N; ++I) {
      AddString(new StringRef(PPOpts.Macros.$at$Const(I).first), Record);
      Record.push_back((PPOpts.Macros.$at$Const(I).second ? 1 : 0));
    }
    
    // Includes
    Record.push_back($uint2ullong(PPOpts.Includes.size()));
    for (/*uint*/int I = 0, N = PPOpts.Includes.size(); I != N; ++I)  {
      AddString(new StringRef(PPOpts.Includes.$at$Const(I)), Record);
    }
    
    // Macro includes
    Record.push_back($uint2ullong(PPOpts.MacroIncludes.size()));
    for (/*uint*/int I = 0, N = PPOpts.MacroIncludes.size(); I != N; ++I)  {
      AddString(new StringRef(PPOpts.MacroIncludes.$at$Const(I)), Record);
    }
    
    Record.push_back($uint2ullong(PPOpts.UsePredefines));
    // Detailed record is important since it is used for the module cache hash.
    Record.push_back($uint2ullong(PPOpts.DetailedRecord));
    AddString(new StringRef(PPOpts.ImplicitPCHInclude), Record);
    AddString(new StringRef(PPOpts.ImplicitPTHInclude), Record);
    Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(PPOpts.ObjCXXARCStandardLibrary.getValue()))));
    Stream.EmitRecord(OptionsRecordTypes.PREPROCESSOR_OPTIONS, Record);
    
    // Leave the options block.
    Stream.ExitBlock();
    
    // Original file name and file ID
    final SourceManager /*&*/ SM = Context.getSourceManager();
    {
      /*const*/ FileEntry /*P*/ MainFile = SM.getFileEntryForID(SM.getMainFileID());
      if ((MainFile != null)) {
        BitCodeAbbrev /*P*/ FileAbbrev = new BitCodeAbbrev();
        FileAbbrev.Add(new BitCodeAbbrevOp(ControlRecordTypes.ORIGINAL_FILE));
        FileAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // File ID
        FileAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // File name
        /*uint*/int FileAbbrevCode = Stream.EmitAbbrev(FileAbbrev);
        
        Record.clear();
        Record.push_back(ControlRecordTypes.ORIGINAL_FILE);
        Record.push_back($int2ullong(SM.getMainFileID().getOpaqueValue()));
        EmitRecordWithPath(FileAbbrevCode, new ArrayRefULong(Record), new StringRef(MainFile.getName()));
      }
    }
    
    Record.clear();
    Record.push_back($int2ullong(SM.getMainFileID().getOpaqueValue()));
    Stream.EmitRecord(ControlRecordTypes.ORIGINAL_FILE_ID, Record);
    
    // Original PCH directory
    if (!OutputFile.empty() && $noteq_string$C_T$C$P(OutputFile, /*KEEP_STR*/"-")) {
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ControlRecordTypes.ORIGINAL_PCH_DIR));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // File name
      /*uint*/int AbbrevCode = Stream.EmitAbbrev(Abbrev);
      
      SmallString/*<128>*/ OutputPath/*J*/= new SmallString/*<128>*/(128, new StringRef(OutputFile));
      
      SM.getFileManager().makeAbsolutePath(OutputPath);
      StringRef origDir = path.parent_path(OutputPath.$StringRef());
      
      long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {ControlRecordTypes.ORIGINAL_PCH_DIR};
      Stream.EmitRecordWithBlob(AbbrevCode, Record$1, new StringRef(origDir));
    }
    
    WriteInputFiles(Context.SourceMgr, 
        PP.getHeaderSearchInfo().getHeaderSearchOpts(), 
        PP.getLangOpts().Modules);
    Stream.ExitBlock();
    return $uint2ulong(Signature);
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteInputFiles">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1546,
   FQN="clang::ASTWriter::WriteInputFiles", NM="_ZN5clang9ASTWriter15WriteInputFilesERNS_13SourceManagerERNS_19HeaderSearchOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter15WriteInputFilesERNS_13SourceManagerERNS_19HeaderSearchOptionsEb")
  //</editor-fold>
  private void WriteInputFiles(final SourceManager /*&*/ SourceMgr, 
                 final HeaderSearchOptions /*&*/ HSOpts, 
                 boolean Modules) {
    std.deque<InputFileEntry> SortedFiles = null;
    std.vectorULong InputFileOffsets = null;
    try {
      //JAVA: using namespace llvm;
      Stream.EnterSubblock(BlockIDs.INPUT_FILES_BLOCK_ID, 4);
      
      // Create input-file abbreviation.
      BitCodeAbbrev /*P*/ IFAbbrev = new BitCodeAbbrev();
      IFAbbrev.Add(new BitCodeAbbrevOp(InputFileRecordTypes.INPUT_FILE));
      IFAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // ID
      IFAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(12))); // Size
      IFAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(32))); // Modification time
      IFAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Overridden
      IFAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Transient
      IFAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // File name
      /*uint*/int IFAbbrevCode = Stream.EmitAbbrev(IFAbbrev);
      
      // Get all ContentCache objects for files, sorted by whether the file is a
      // system one or not. System files go at the back, users files at the front.
      SortedFiles/*J*/= new std.deque<InputFileEntry>(false);
      for (/*uint*/int I = 1, N = SourceMgr.local_sloc_entry_size(); I != N; ++I) {
        // Get this source location entry.
        /*const*/ SrcMgr.SLocEntry /*P*/ SLoc = $AddrOf(SourceMgr.getLocalSLocEntry(I));
        // JAVA: we don't have SLocEntry instances in memory, so compare indices, not addresses
        //assert ($AddrOf(SourceMgr.getSLocEntry(FileID.get(I))) == SLoc);        
        assert ($AddrOf(SourceMgr.getSLocEntryByID_LoadEntryIfAbsent(FileID.get(I).$ID())) == SourceMgr.getLocalSLocEntry_performance(I));
        
        // We only care about file entries that were not overridden.
        if (!SLoc.isFile()) {
          continue;
        }
//        /*const*/ SrcMgr.ContentCache /*P*/ Cache = SLoc.getFile().getContentCache();
        /*const*/ SrcMgr.ContentCache /*P*/ Cache = SourceMgr.getContentCache(SLoc.getFile());
        if (!(Cache.OrigEntry != null)) {
          continue;
        }
        
        InputFileEntry Entry/*J*/= new InputFileEntry();
        Entry.File = Cache.OrigEntry;
        Entry.IsSystemFile = Cache.IsSystemFile;
        Entry.IsTransient = Cache.IsTransient;
        Entry.BufferOverridden = Cache.BufferOverridden;
        if (Cache.IsSystemFile) {
          SortedFiles.push_back_T$C$R(Entry);
        } else {
          SortedFiles.push_front_T$C$R(Entry);
        }
      }
      
      /*uint*/int UserFilesNum = 0;
      // Write out all of the input files.
      InputFileOffsets/*J*/= new std.vectorULong();
      for (final /*const*/ InputFileEntry /*&*/ Entry : SortedFiles) {
        final /*uint32_t &*/uint$ref InputFileID = InputFileIDs.ref$at(Entry.File);
        if (InputFileID.$deref() != 0) {
          continue; // already recorded this file.
        }
        
        // Record this entry's offset.
        InputFileOffsets.push_back_T$RR(Stream.GetCurrentBitNo());
        
        InputFileID.$set(InputFileOffsets.size());
        if (!Entry.IsSystemFile) {
          ++UserFilesNum;
        }
        
        // Emit size/modification time for this file.
        // And whether this file was overridden.
        long Record[/*6*/] = new /*ullong*/long [/*6*/] {
          InputFileRecordTypes.INPUT_FILE, 
          InputFileOffsets.size(), 
          (long/*uint64_t*/)$long2ulong(Entry.File.getSize()), 
          (long/*uint64_t*/)$long2ulong(getTimestampForOutput(Entry.File)), 
          $uint2ullong(Entry.BufferOverridden), 
          $uint2ullong(Entry.IsTransient)};
        
        EmitRecordWithPath(IFAbbrevCode, new ArrayRefULong(/*6,*/ Record), new StringRef(Entry.File.getName()));
      }
      
      Stream.ExitBlock();
      
      // Create input file offsets abbreviation.
      BitCodeAbbrev /*P*/ OffsetsAbbrev = new BitCodeAbbrev();
      OffsetsAbbrev.Add(new BitCodeAbbrevOp(ControlRecordTypes.INPUT_FILE_OFFSETS));
      OffsetsAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // # input files
      OffsetsAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // # non-system
      //   input files
      OffsetsAbbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Array
      /*uint*/int OffsetsAbbrevCode = Stream.EmitAbbrev(OffsetsAbbrev);
      
      // Write input file offsets.
      long Record[/*3*/] = new /*ullong*/long [/*3*/] {
        ControlRecordTypes.INPUT_FILE_OFFSETS, 
        InputFileOffsets.size(), UserFilesNum};
      Stream.EmitRecordWithBlob(OffsetsAbbrevCode,  new ArrayRefULong(Record), bytes(InputFileOffsets));
    } finally {
      if (InputFileOffsets != null) { InputFileOffsets.$destroy(); }
      if (SortedFiles != null) { SortedFiles.$destroy(); }
    }
  }

  
  /// \brief Writes the block containing the serialized form of the
  /// source manager.
  ///
  /// TODO: We should probably use an on-disk hash table (stored in a
  /// blob), indexed based on the file name, so that we only create
  /// entries for files that we actually need. In the common case (no
  /// errors), we probably won't have to create file entries for any of
  /// the files in the AST.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteSourceManagerBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1900,
   FQN="clang::ASTWriter::WriteSourceManagerBlock", NM="_ZN5clang9ASTWriter23WriteSourceManagerBlockERNS_13SourceManagerERKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter23WriteSourceManagerBlockERNS_13SourceManagerERKNS_12PreprocessorE")
  //</editor-fold>
  private void WriteSourceManagerBlock(final SourceManager /*&*/ SourceMgr, 
                         final /*const*/ Preprocessor /*&*/ PP) {
    std.vectorUInt SLocEntryOffsets = null;
    try {
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      
      // Enter the source manager block.
      Stream.EnterSubblock(BlockIDs.SOURCE_MANAGER_BLOCK_ID, 4);
      
      // Abbreviations for the various kinds of source-location entries.
      /*uint*/int SLocFileAbbrv = CreateSLocFileAbbrev(Stream);
      /*uint*/int SLocBufferAbbrv = CreateSLocBufferAbbrev(Stream);
      /*uint*/int SLocBufferBlobAbbrv = CreateSLocBufferBlobAbbrev(Stream, false);
      /*uint*/int SLocBufferBlobCompressedAbbrv = CreateSLocBufferBlobAbbrev(Stream, true);
      /*uint*/int SLocExpansionAbbrv = CreateSLocExpansionAbbrev(Stream);
      
      // Write out the source location entry table. We skip the first
      // entry, which is always the same dummy entry.
      SLocEntryOffsets/*J*/= new std.vectorUInt();
      SmallVectorULong PreloadSLocs/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      SLocEntryOffsets.reserve(SourceMgr.local_sloc_entry_size() - 1);
      for (/*uint*/int I = 1, N = SourceMgr.local_sloc_entry_size();
           I != N; ++I) {
        // Get this source location entry.
        /*const*/ SrcMgr.SLocEntry /*P*/ SLoc = $AddrOf(SourceMgr.getLocalSLocEntry(I));
        FileID FID = FileID.get(I);
        // JAVA: we don't have SLocEntry instances in memory, so compare indices, not addresses
//        assert ($AddrOf(SourceMgr.getSLocEntry(/*NO_COPY*/FID)) == SLoc);
        assert ($AddrOf(SourceMgr.getSLocEntryByID_LoadEntryIfAbsent(FID.$ID())) == $AddrOf(SourceMgr.getLocalSLocEntry_performance(I)));
        
        // Record the offset of this source-location entry.
        SLocEntryOffsets.push_back_T$RR($ulong2uint(Stream.GetCurrentBitNo()));
        
        // Figure out which record code to use.
        /*uint*/int Code;
        if (SLoc.isFile()) {
//          /*const*/ SrcMgr.ContentCache /*P*/ Cache = SLoc.getFile().getContentCache();
          /*const*/ SrcMgr.ContentCache /*P*/ Cache = SourceMgr.getContentCache(SLoc.getFile());
          if ((Cache.OrigEntry != null)) {
            Code = SourceManagerRecordTypes.SM_SLOC_FILE_ENTRY;
          } else {
            Code = SourceManagerRecordTypes.SM_SLOC_BUFFER_ENTRY;
          }
        } else {
          Code = SourceManagerRecordTypes.SM_SLOC_EXPANSION_ENTRY;
        }
        Record.clear();
        Record.push_back($uint2ullong(Code));
        
        // Starting offset of this entry within this module, so skip the dummy.
        Record.push_back($uint2ullong(SLoc.getOffset() - 2));
        if (SLoc.isFile()) {
          final /*const*/ SrcMgr.FileInfo /*&*/ File = SLoc.getFile();
          AddSourceLocation(File.getIncludeLoc(), Record);
          Record.push_back(File.getFileCharacteristic().getValue()); // FIXME: stable encoding
          Record.push_back((File.hasLineDirectives() ? 1 : 0));
          
//          /*const*/ SrcMgr.ContentCache /*P*/ Content = File.getContentCache();
          /*const*/ SrcMgr.ContentCache /*P*/ Content = SourceMgr.getContentCache(File);
          boolean EmitBlob = false;
          if ((Content.OrigEntry != null)) {
            assert (Content.OrigEntry == Content.ContentsEntry) : "Writing to AST an overridden file is not supported";
            
            // The source location entry is a file. Emit input file ID.
            assert (InputFileIDs.$at_T1$C$R(Content.OrigEntry) != 0) : "Missed file entry";
            Record.push_back($uint2ullong(InputFileIDs.$at_T1$C$R(Content.OrigEntry)));
            
            Record.push_back($uint2ullong(File.getNumCreatedFIDs()));
            
            DenseMapIterator<FileID, DeclIDInFileInfo /*P*/ > FDI = FileDeclIDs.find(FID);
            if (FDI.$noteq(/*NO_ITER_COPY*/FileDeclIDs.end())) {
              Record.push_back($uint2ullong(FDI.$arrow().second.FirstDeclIndex));
              Record.push_back($uint2ullong(FDI.$arrow().second.DeclIDs.size()));
            } else {
              Record.push_back($int2ullong(0));
              Record.push_back($int2ullong(0));
            }
            
            Stream.EmitRecordWithAbbrev(SLocFileAbbrv, Record);
            if (Content.BufferOverridden || Content.IsTransient) {
              EmitBlob = true;
            }
          } else {
            // The source location entry is a buffer. The blob associated
            // with this entry contains the contents of the buffer.
            
            // We add one to the size so that we capture the trailing NULL
            // that is required by llvm::MemoryBuffer::getMemBuffer (on
            // the reader side).
            /*const*/ MemoryBuffer /*P*/ Buffer = Content.getBuffer(PP.getDiagnostics(), PP.getSourceManager());
            /*const*/char$ptr/*char P*/ Name = $tryClone(Buffer.getBufferIdentifier());
            Stream.EmitRecordWithBlob(SLocBufferAbbrv, Record, 
                new StringRef(Name, strlen(Name) + 1));
            EmitBlob = true;
            if (strcmp(Name, /*KEEP_STR*/"<built-in>") == 0) {
              PreloadSLocs.push_back($uint2ullong(SLocEntryOffsets.size()));
            }
          }
          if (EmitBlob) {
            // Include the implicit terminating null character in the on-disk buffer
            // if we're writing it uncompressed.
            /*const*/ MemoryBuffer /*P*/ Buffer = Content.getBuffer(PP.getDiagnostics(), PP.getSourceManager());
            StringRef Blob/*J*/= new StringRef(Buffer.getBufferStart(), Buffer.getBufferSize() + 1);
            
            // Compress the buffer if possible. We expect that almost all PCM
            // consumers will not want its contents.
            SmallString/*<0>*/ CompressedBuffer/*J*/= new SmallString/*<0>*/(0);
            if (compress(Blob.drop_back(1), CompressedBuffer)
               == Status.StatusOK) {
              long Record$1[/*2*/] = new /*ullong*/long [/*2*/] {
                SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB_COMPRESSED, 
                Blob.size() - 1};
              Stream.EmitRecordWithBlob(SLocBufferBlobCompressedAbbrv, Record$1, 
                  CompressedBuffer.$StringRef());
            } else {
              long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB};
              Stream.EmitRecordWithBlob(SLocBufferBlobAbbrv, Record$1, new StringRef(Blob));
            }
          }
        } else {
          // The source location entry is a macro expansion.
          final /*const*/ SrcMgr.ExpansionInfo /*&*/ Expansion = SLoc.getExpansion();
          AddSourceLocation(Expansion.getSpellingLoc(), Record);
          AddSourceLocation(Expansion.getExpansionLocStart(), Record);
          AddSourceLocation(Expansion.isMacroArgExpansion() ? new SourceLocation() : Expansion.getExpansionLocEnd(), 
              Record);
          
          // Compute the token length for this macro expansion.
          /*uint*/int NextOffset = SourceMgr.getNextLocalOffset();
          if (I + 1 != N) {
            NextOffset = SourceMgr.getLocalSLocEntry(I + 1).getOffset();
          }
          Record.push_back($uint2ullong(NextOffset - SLoc.getOffset() - 1));
          Stream.EmitRecordWithAbbrev(SLocExpansionAbbrv, Record);
        }
      }
      
      Stream.ExitBlock();
      if (SLocEntryOffsets.empty()) {
        return;
      }
      
      // Write the source-location offsets table into the AST block. This
      // table is used for lazily loading source-location information.
      //JAVA: using namespace llvm;
      
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.SOURCE_LOCATION_OFFSETS));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(16))); // # of slocs
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(16))); // total size
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // offsets
      /*uint*/int SLocOffsetsAbbrev = Stream.EmitAbbrev(Abbrev);
      {
        long Record$1[/*3*/] = new /*ullong*/long [/*3*/] {
          ASTRecordTypes.SOURCE_LOCATION_OFFSETS, SLocEntryOffsets.size(), 
          SourceMgr.getNextLocalOffset() - 1/* skip dummy */};
        Stream.EmitRecordWithBlob(SLocOffsetsAbbrev, Record$1, 
            bytes(SLocEntryOffsets));
      }
      // Write the source location entry preloads array, telling the AST
      // reader which source locations entries it should load eagerly.
      Stream.EmitRecord(ASTRecordTypes.SOURCE_LOCATION_PRELOADS, PreloadSLocs);
      
      // Write the line table. It depends on remapping working, so it must come
      // after the source location offsets.
      if (SourceMgr.hasLineTable()) {
        final LineTableInfo /*&*/ LineTable = SourceMgr.getLineTable();
        
        Record.clear();
        
        // Emit the needed file names.
        DenseMapIntInt FilenameMap/*J*/= new DenseMapIntInt(DenseMapInfoInt.$Info(),0);
        for (final /*const*/std.pairIntType</*const*//*FileID,*/std.vector<LineEntry/*,default_cls_allocator*/>> /*&*/ L : LineTable) {
          if (L.first/*.ID*/ < 0) {
            continue;
          }
          for (final /*const*/ LineEntry /*&*/ LE : L.second) {
            if (FilenameMap.insert_pair$KeyT$ValueT(new std.pairIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*/LE.FilenameID, /*Fwd2*//*Fwd*/FilenameMap.size())).second) {
              AddPath(new StringRef(LineTable.getFilename(LE.FilenameID)), Record);
            }
          }
        }
        Record.push_back($int2ullong(0));
        
        // Emit the line entries
        for (final /*const*/std.pairIntType</*const FileID, */std.vector<LineEntry/*,default_cls_allocator*/>> /*&*/ L : LineTable) {
          // Only emit entries for local files.
          if (L.first/*.ID*/ < 0) {
            continue;
          }
          
          // Emit the file ID
          Record.push_back($int2ullong(L.first/*.ID*/));
          
          // Emit the line entries
          Record.push_back($uint2ullong(L.second.size()));
          for (final /*const*/ LineEntry /*&*/ LE : L.second) {
            Record.push_back($uint2ullong(LE.FileOffset));
            Record.push_back($uint2ullong(LE.LineNo));
            Record.push_back($int2ullong(FilenameMap.$at_T1$C$R(LE.FilenameID)));
            Record.push_back($uint2ullong((/*uint*/int)LE.FileKind.getValue()));
            Record.push_back($uint2ullong(LE.IncludeOffset));
          }
        }
        
        Stream.EmitRecord(ASTRecordTypes.SOURCE_MANAGER_LINE_TABLE, Record);
      }
    } finally {
      if (SLocEntryOffsets != null) { SLocEntryOffsets.$destroy(); }
    }
  }

  
  /// \brief Writes the block containing the serialized form of the
  /// preprocessor.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WritePreprocessor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2129,
   FQN="clang::ASTWriter::WritePreprocessor", NM="_ZN5clang9ASTWriter17WritePreprocessorERKNS_12PreprocessorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17WritePreprocessorERKNS_12PreprocessorEb")
  //</editor-fold>
  private void WritePreprocessor(final /*const*/ Preprocessor /*&*/ PP, boolean IsModule) {
    std.vectorUInt MacroOffsets = null;
    try {
      PreprocessingRecord /*P*/ PPRec = PP.getPreprocessingRecord();
      if ((PPRec != null)) {
        WritePreprocessorDetail($Deref(PPRec));
      }
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      SmallVectorULong ModuleMacroRecord/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      
      // If the preprocessor __COUNTER__ value has been bumped, remember it.
      if (PP.getCounterValue() != 0) {
        long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {PP.getCounterValue()};
        Stream.EmitRecord(ASTRecordTypes.PP_COUNTER_VALUE, new ArrayRefULong(Record$1));
      }
      
      // Enter the preprocessor block.
      Stream.EnterSubblock(BlockIDs.PREPROCESSOR_BLOCK_ID, 3);
      
      // If the AST file contains __DATE__ or __TIME__ emit a warning about this.
      // FIXME: Include a location for the use, and say which one was used.
      if (PP.SawDateOrTime()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out$Same2Bool($c$.track(PP.Diag(new SourceLocation(), diag.warn_module_uses_date_time)), IsModule));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Loop over all the macro directives that are live at the end of the file,
      // emitting each to the PP section.
      
      // Construct the list of identifiers with macro directives that need to be
      // serialized.
      SmallVector</*const*/ IdentifierInfo /*P*/ > MacroIdentifiers/*J*/= new SmallVector</*const*/ IdentifierInfo /*P*/ >(128, (/*const*/ IdentifierInfo /*P*/ )null);
      for (final /*const*/IdentifierInfoStringMapEntry/*&*/ Id : PP.getIdentifierTable$Const())  {
        if (Id.$second().hadMacroDefinition()
           && (!Id.$second().isFromAST()
           || Id.$second().hasChangedSinceDeserialization())) {
          MacroIdentifiers.push_back(Id.$second());
        }
      }
      // Sort the set of macro definitions that need to be serialized by the
      // name of the macro, to provide a stable ordering.
      std.sort(MacroIdentifiers.begin(), MacroIdentifiers.end(), 
          new less_ptr<IdentifierInfo>());
      
      // Emit the macro directives as a list and associate the offset with the
      // identifier they belong to.
      for (/*const*/ IdentifierInfo /*P*/ Name : MacroIdentifiers) {
        MacroDirective /*P*/ MD = PP.getLocalMacroDirectiveHistory(Name);
        long/*uint64_t*/ StartOffset = Stream.GetCurrentBitNo();
        
        // Emit the macro directives in reverse source order.
        for (; (MD != null); MD = MD.getPrevious()) {
          // Once we hit an ignored macro, we're done: the rest of the chain
          // will all be ignored macros.
          if (shouldIgnoreMacro(MD, IsModule, PP)) {
            break;
          }
          
          AddSourceLocation(MD.getLocation(), Record);
          Record.push_back(MD.getKind().getValue());
          {
            DefMacroDirective /*P*/ DefMD = dyn_cast_DefMacroDirective(MD);
            if ((DefMD != null)) {
              Record.push_back($uint2ullong(getMacroRef(DefMD.getInfo(), Name)));
            } else {
              VisibilityMacroDirective /*P*/ VisMD = dyn_cast_VisibilityMacroDirective(MD);
              if ((VisMD != null)) {
                Record.push_back((VisMD.isPublic() ? 1 : 0));
              }
            }
          }
        }
        
        // Write out any exported module macros.
        boolean EmittedModuleMacros = false;
        // We write out exported module macros for PCH as well.
        ArrayRef<ModuleMacro /*P*/ > Leafs = PP.getLeafModuleMacros(Name);
        SmallVector<ModuleMacro /*P*/ > Worklist/*J*/= new SmallVector<ModuleMacro /*P*/ >(JD$T.INSTANCE, 8, Leafs.begin(), Leafs.end(), (ModuleMacro /*P*/ )null);
        DenseMapTypeUInt<ModuleMacro /*P*/ > Visits/*J*/= new DenseMapTypeUInt<ModuleMacro /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
        while (!Worklist.empty()) {
          ModuleMacro /*P*/ Macro = Worklist.pop_back_val();
          
          // Emit a record indicating this submodule exports this macro.
          ModuleMacroRecord.push_back($uint2ullong(getSubmoduleID(Macro.getOwningModule())));
          ModuleMacroRecord.push_back($uint2ullong(getMacroRef(Macro.getMacroInfo(), Name)));
          for (ModuleMacro /*P*/ M : Macro.overrides())  {
            ModuleMacroRecord.push_back($uint2ullong(getSubmoduleID(M.getOwningModule())));
          }
          
          Stream.EmitRecord(PreprocessorRecordTypes.PP_MODULE_MACRO, ModuleMacroRecord);
          ModuleMacroRecord.clear();
          
          // Enqueue overridden macros once we've visited all their ancestors.
          for (ModuleMacro /*P*/ M : Macro.overrides())  {
            if (Visits.ref$at(M).$set$preInc() == M.getNumOverridingMacros()) {
              Worklist.push_back(M);
            }
          }
          
          EmittedModuleMacros = true;
        }
        if (Record.empty() && !EmittedModuleMacros) {
          continue;
        }
        
        IdentMacroDirectivesOffsetMap.$set(Name, StartOffset);
        Stream.EmitRecord(PreprocessorRecordTypes.PP_MACRO_DIRECTIVE_HISTORY, Record);
        Record.clear();
      }
      
      /// \brief Offsets of each of the macros into the bitstream, indexed by
      /// the local macro ID
      ///
      /// For each identifier that is associated with a macro, this map
      /// provides the offset into the bitstream where that macro is
      /// defined.
      MacroOffsets/*J*/= new std.vectorUInt();
      
      for (/*uint*/int I = 0, N = MacroInfosToEmit.size(); I != N; ++I) {
        /*const*/ IdentifierInfo /*P*/ Name = MacroInfosToEmit.$at(I).Name;
        MacroInfo /*P*/ MI = MacroInfosToEmit.$at(I).MI;
        /*uint32_t*/int ID = MacroInfosToEmit.$at(I).ID;
        if ($less_uint(ID, FirstMacroID)) {
          assert (false) : "Loaded MacroInfo entered MacroInfosToEmit ?";
          continue;
        }
        
        // Record the local offset of this macro.
        /*uint*/int Index = ID - FirstMacroID;
        if (Index == MacroOffsets.size()) {
          MacroOffsets.push_back_T$RR($ulong2uint(Stream.GetCurrentBitNo()));
        } else {
          if ($greater_uint(Index, MacroOffsets.size())) {
            MacroOffsets.resize(Index + 1);
          }
          
          MacroOffsets.$set(Index, $ulong2uint(Stream.GetCurrentBitNo()));
        }
        
        AddIdentifierRef(Name, Record);
        Record.push_back($uint2ullong(inferSubmoduleIDFromLocation(MI.getDefinitionLoc())));
        AddSourceLocation(MI.getDefinitionLoc(), Record);
        AddSourceLocation(MI.getDefinitionEndLoc(), Record);
        Record.push_back((MI.isUsed() ? 1 : 0));
        Record.push_back((MI.isUsedForHeaderGuard() ? 1 : 0));
        /*uint*/int Code;
        if (MI.isObjectLike()) {
          Code = PreprocessorRecordTypes.PP_MACRO_OBJECT_LIKE;
        } else {
          Code = PreprocessorRecordTypes.PP_MACRO_FUNCTION_LIKE;
          
          Record.push_back((MI.isC99Varargs() ? 1 : 0));
          Record.push_back((MI.isGNUVarargs() ? 1 : 0));
          Record.push_back((MI.hasCommaPasting() ? 1 : 0));
          Record.push_back($uint2ullong(MI.getNumArgs()));
          for (/*const*/ IdentifierInfo /*P*/ Arg : MI.args())  {
            AddIdentifierRef(Arg, Record);
          }
        }
        
        // If we have a detailed preprocessing record, record the macro definition
        // ID that corresponds to this macro.
        if ((PPRec != null)) {
          Record.push_back($uint2ullong(MacroDefinitions.$at_T1$RR(PPRec.findMacroDefinition(MI))));
        }
        
        Stream.EmitRecord(Code, Record);
        Record.clear();
        
        // Emit the tokens array.
        for (/*uint*/int TokNo = 0, e = MI.getNumTokens(); TokNo != e; ++TokNo) {
          // Note that we know that the preprocessor does not have any annotation
          // tokens in it because they are created by the parser, and thus can't
          // be in a macro definition.
          final /*const*/ Token /*&*/ Tok = MI.getReplacementToken(TokNo);
          AddToken(Tok, Record);
          Stream.EmitRecord(PreprocessorRecordTypes.PP_TOKEN, Record);
          Record.clear();
        }
        ++NumMacros;
      }
      
      Stream.ExitBlock();
      
      // Write the offsets table for macro IDs.
      //JAVA: using namespace llvm;
      
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.MACRO_OFFSET));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // # of macros
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // first ID
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
      
      /*uint*/int MacroOffsetAbbrev = Stream.EmitAbbrev(Abbrev);
      {
        long Record$1[/*3*/] = new /*ullong*/long [/*3*/] {
          ASTRecordTypes.MACRO_OFFSET, MacroOffsets.size(), 
          FirstMacroID - NUM_PREDEF_MACRO_IDS};
        Stream.EmitRecordWithBlob(MacroOffsetAbbrev, Record$1, bytes(MacroOffsets));
      }
    } finally {
      if (MacroOffsets != null) { MacroOffsets.$destroy(); }
    }
  }

  // end anonymous namespace
  
  /// \brief Write the header search block for the list of files that 
  ///
  /// \param HS The header search structure to save.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteHeaderSearch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1817,
   FQN="clang::ASTWriter::WriteHeaderSearch", NM="_ZN5clang9ASTWriter17WriteHeaderSearchERKNS_12HeaderSearchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17WriteHeaderSearchERKNS_12HeaderSearchE")
  //</editor-fold>
  private void WriteHeaderSearch(final /*const*/ HeaderSearch /*&*/ HS) {
    OnDiskChainedHashTableGenerator.EmitInfoInterface GeneratorTrait = null;
    OnDiskChainedHashTableGenerator<OnDiskChainedHashTableGenerator.EmitInfoInterface, HeaderFileInfoTrait.key_type, HeaderFileInfo> Generator = null;
    try {
      SmallVector</*const*/ FileEntry /*P*/> FilesByUID/*J*/= new SmallVector</*const*/ FileEntry /*P*/>(16, (FileEntry /*P*/)null);
      HS.getFileMgr().GetUniqueIDMapping(FilesByUID);
      if ($greater_uint(FilesByUID.size(), HS.header_file_size())) {
        FilesByUID.resize(HS.header_file_size());
      }
      
      GeneratorTrait/*J*/= new HeaderFileInfoTrait(/*Deref*/this, HS);
      Generator/*J*/= new OnDiskChainedHashTableGenerator<OnDiskChainedHashTableGenerator.EmitInfoInterface, HeaderFileInfoTrait.key_type, HeaderFileInfo>(GeneratorTrait);
      SmallVector</*const*/char$ptr/*char P*//*,  4*/> SavedStrings/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  4*/>(4, null);
      /*uint*/int NumHeaderSearchEntries = 0;
      for (/*uint*/int UID = 0, LastUID = FilesByUID.size(); UID != LastUID; ++UID) {
        /*const*/ FileEntry /*P*/ File = FilesByUID.$at(UID);
        if (!(File != null)) {
          continue;
        }
        
        // Get the file info. This will load info from the external source if
        // necessary. Skip emitting this file if we have no information on it
        // as a header file (in which case HFI will be null) or if it hasn't
        // changed since it was loaded. Also skip it if it's for a modular header
        // from a different module; in that case, we rely on the module(s)
        // containing the header to provide this information.
        /*const*/ HeaderFileInfo /*P*/ HFI = HS.getExistingFileInfo(File, /*WantExternal*/ !(Chain != null));
        if (!(HFI != null) || (HFI.isModuleHeader && !HFI.isCompilingModuleHeader)) {
          continue;
        }
        
        // Massage the file path into an appropriate form.
        /*const*/char$ptr/*char P*/ Filename = $tryClone(File.getName());
        SmallString/*<128>*/ FilenameTmp/*J*/= new SmallString/*<128>*/(128, new StringRef(Filename));
        if (PreparePathForOutput(FilenameTmp)) {
          // If we performed any translation on the file name at all, we need to
          // save this string, since the generator will refer to it later.
          Filename = $tryClone(/*strdup(*/FilenameTmp.c_str()/*)*/);
          SavedStrings.push_back(Filename);
        }
        
        HeaderFileInfoTrait.key_type key = new HeaderFileInfoTrait.key_type(File, Filename);
        Generator.insert(key, $Deref(HFI), GeneratorTrait);
        ++NumHeaderSearchEntries;
      }
      
      // Create the on-disk hash table in a buffer.
      SmallString/*<4096>*/ TableData/*J*/= new SmallString/*<4096>*/(4096);
      /*uint32_t*/int BucketOffset;
      {
        raw_svector_ostream Out = null;
        try {
          //JAVA: using namespace llvm::support;
          Out/*J*/= new raw_svector_ostream(TableData);
          // Make sure that no bucket is at offset 0
          new Writer(little, Out).write_uint32(0);
          BucketOffset = Generator.Emit(Out, GeneratorTrait);
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
      
      // Create a blob abbreviation
      //JAVA: using namespace llvm;
      
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.HEADER_SEARCH_TABLE));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
      /*uint*/int TableAbbrev = Stream.EmitAbbrev(Abbrev);
      
      // Write the header search table
      long Record[/*4*/] = new /*ullong*/long [/*4*/] {
        ASTRecordTypes.HEADER_SEARCH_TABLE, BucketOffset, 
        NumHeaderSearchEntries, TableData.size()};
      final char$ptr strings_begin = GeneratorTrait.strings_begin();
      final char$ptr strings_end = GeneratorTrait.strings_end();
      TableData.append$T(strings_begin, strings_end.$sub(strings_begin)); // JAVA
      Stream.EmitRecordWithBlob(TableAbbrev, Record, TableData.$StringRef());
      
      // Free all of the strings we had to duplicate.
      for (/*uint*/int I = 0, N = SavedStrings.size(); I != N; ++I)  {
        free(((/*const_cast*/char$ptr/*char P*/ )(SavedStrings.$at(I))));
      }
    } finally {
      if (Generator != null) { Generator.$destroy(); }
      if (GeneratorTrait != null) { GeneratorTrait.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WritePreprocessorDetail">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2313,
   FQN="clang::ASTWriter::WritePreprocessorDetail", NM="_ZN5clang9ASTWriter23WritePreprocessorDetailERNS_19PreprocessingRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter23WritePreprocessorDetailERNS_19PreprocessingRecordE")
  //</editor-fold>
  private void WritePreprocessorDetail(final PreprocessingRecord /*&*/ PPRec) {
    if (PPRec.local_begin().$eq(PPRec.local_end())) {
      return;
    }
    
    SmallVector<PPEntityOffset> PreprocessedEntityOffsets/*J*/= new SmallVector<PPEntityOffset>(64, new PPEntityOffset());
    
    // Enter the preprocessor block.
    Stream.EnterSubblock(BlockIDs.PREPROCESSOR_DETAIL_BLOCK_ID, 3);
    
    // If the preprocessor has a preprocessing record, emit it.
    /*uint*/int NumPreprocessingRecords = 0;
    //JAVA: using namespace llvm;
    
    // Set up the abbreviation for 
    /*uint*/int InclusionAbbrev = 0;
    {
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(PreprocessorDetailRecordTypes.PPD_INCLUSION_DIRECTIVE));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // filename length
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // in quotes
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // kind
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // imported module
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
      InclusionAbbrev = Stream.EmitAbbrev(Abbrev);
    }
    
    /*uint*/int FirstPreprocessorEntityID = ((Chain != null) ? PPRec.getNumLoadedPreprocessedEntities() : 0)
       + NUM_PREDEF_PP_ENTITY_IDS;
    /*uint*/int NextPreprocessorEntityID = FirstPreprocessorEntityID;
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (PreprocessingRecord.iterator E = PPRec.local_begin(), 
        EEnd = PPRec.local_end();
         E.$noteq(EEnd);
         /*J:(void)*/E.$preInc() , ++NumPreprocessingRecords , ++NextPreprocessorEntityID) {
      Record.clear();
      
      PreprocessedEntityOffsets.push_back(new PPEntityOffset((E.$star()).getSourceRange(), $ulong2uint(Stream.GetCurrentBitNo())));
      {
        
        MacroDefinitionRecord /*P*/ MD = dyn_cast_MacroDefinitionRecord(E.$star());
        if ((MD != null)) {
          // Record this macro definition's ID.
          MacroDefinitions.$set(MD, NextPreprocessorEntityID);
          
          AddIdentifierRef(MD.getName(), Record);
          Stream.EmitRecord(PreprocessorDetailRecordTypes.PPD_MACRO_DEFINITION, Record);
          continue;
        }
      }
      {
        
        MacroExpansion /*P*/ ME = dyn_cast_MacroExpansion(E.$star());
        if ((ME != null)) {
          Record.push_back((ME.isBuiltinMacro() ? 1 : 0));
          if (ME.isBuiltinMacro()) {
            AddIdentifierRef(ME.getName(), Record);
          } else {
            Record.push_back($uint2ullong(MacroDefinitions.$at_T1$RR(ME.getDefinition())));
          }
          Stream.EmitRecord(PreprocessorDetailRecordTypes.PPD_MACRO_EXPANSION, Record);
          continue;
        }
      }
      {
        
        InclusionDirective /*P*/ ID = dyn_cast_InclusionDirective(E.$star());
        if ((ID != null)) {
          Record.push_back(PreprocessorDetailRecordTypes.PPD_INCLUSION_DIRECTIVE);
          Record.push_back($uint2ullong(ID.getFileName().size()));
          Record.push_back((ID.wasInQuotes() ? 1 : 0));
          Record.push_back($uint2ullong(((/*static_cast*//*uint*/int)(ID.getInclusionKind().getValue()))));
          Record.push_back((ID.importedModule() ? 1 : 0));
          SmallString/*<64>*/ Buffer/*J*/= new SmallString/*<64>*/(64);
          Buffer.$addassign(ID.getFileName());
          // Check that the FileEntry is not null because it was not resolved and
          // we create a PCH even with compiler errors.
          if ((ID.getFile() != null)) {
            Buffer.$addassign(/*STRINGREF_STR*/ID.getFile().getName());
          }
          Stream.EmitRecordWithBlob(InclusionAbbrev, Record, Buffer.$StringRef());
          continue;
        }
      }
      throw new llvm_unreachable("Unhandled PreprocessedEntity in ASTWriter");
    }
    Stream.ExitBlock();
    
    // Write the offsets table for the preprocessing record.
    if ($greater_uint(NumPreprocessingRecords, 0)) {
      assert (PreprocessedEntityOffsets.size() == NumPreprocessingRecords);
      
      // Write the offsets table for identifier IDs.
      //JAVA: using namespace llvm;
      
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.PPD_ENTITIES_OFFSETS));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // first pp entity
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
      /*uint*/int PPEOffsetAbbrev = Stream.EmitAbbrev(Abbrev);
      
      long Record$1[/*2*/] = new /*ullong*/long [/*2*/] {
        ASTRecordTypes.PPD_ENTITIES_OFFSETS, 
        FirstPreprocessorEntityID
           - NUM_PREDEF_PP_ENTITY_IDS
      };
      Stream.EmitRecordWithBlob(PPEOffsetAbbrev, Record$1, 
          bytes(PreprocessedEntityOffsets));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteSubmodules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2448,
   FQN="clang::ASTWriter::WriteSubmodules", NM="_ZN5clang9ASTWriter15WriteSubmodulesEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter15WriteSubmodulesEPNS_6ModuleE")
  //</editor-fold>
  private void WriteSubmodules(Module /*P*/ WritingModule) {
    std.queue<Module /*P*/ > Q = null;
    try {
      // Enter the submodule description block.
      Stream.EnterSubblock(BlockIDs.SUBMODULE_BLOCK_ID, /*bits for abbreviations*/ 5);
      
      // Write the abbreviations needed for the submodules block.
      //JAVA: using namespace llvm;
      
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_DEFINITION));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // ID
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Parent
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsFramework
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsExplicit
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsSystem
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsExternC
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // InferSubmodules...
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // InferExplicit...
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // InferExportWild...
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // ConfigMacrosExh...
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int DefinitionAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_UMBRELLA_HEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int UmbrellaAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_HEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int HeaderAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_TOPHEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int TopHeaderAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_UMBRELLA_DIR));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int UmbrellaDirAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_REQUIRES));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // State
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Feature
      /*uint*/int RequiresAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_EXCLUDED_HEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int ExcludedHeaderAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_TEXTUAL_HEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int TextualHeaderAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_PRIVATE_HEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int PrivateHeaderAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_PRIVATE_TEXTUAL_HEADER));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int PrivateTextualHeaderAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_LINK_LIBRARY));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsFramework
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Name
      /*uint*/int LinkLibraryAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_CONFIG_MACRO));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Macro name
      /*uint*/int ConfigMacroAbbrev = Stream.EmitAbbrev(Abbrev);
      
      Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(SubmoduleRecordTypes.SUBMODULE_CONFLICT));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Other module
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Message
      /*uint*/int ConflictAbbrev = Stream.EmitAbbrev(Abbrev);
      
      // Write the submodule metadata block.
      long Record[/*2*/] = new /*ullong*/long [/*2*/] {
        getNumberOfModules(WritingModule), 
        FirstSubmoduleID
           - NUM_PREDEF_SUBMODULE_IDS
      };
      Stream.EmitRecord(SubmoduleRecordTypes.SUBMODULE_METADATA, new ArrayRefULong(Record));
      
      // Write all of the submodules.
      Q/*J*/= new std.queue<Module /*P*/ >(true);
      Q.push_value_type$C(WritingModule);
      while (!Q.empty()) {
        Module /*P*/ Mod = Q.front();
        Q.pop();
        /*uint*/int ID = getSubmoduleID(Mod);
        
        long/*uint64_t*/ ParentID = $int2ulong(0);
        if ((Mod.Parent != null)) {
          assert ((SubmoduleIDs.$at_T1$C$R(Mod.Parent) != 0)) : "Submodule parent not written?";
          ParentID = $uint2ulong(SubmoduleIDs.$at_T1$C$R(Mod.Parent));
        }
        {
          long Record$1[/*11*/] = new /*ullong*/long [/*11*/] {
            SubmoduleRecordTypes.SUBMODULE_DEFINITION, ID, ParentID, $uint2ullong(Mod.IsFramework),  $uint2ullong(Mod.IsExplicit), 
             $uint2ullong(Mod.IsSystem),  $uint2ullong(Mod.IsExternC),  $uint2ullong(Mod.InferSubmodules), 
             $uint2ullong(Mod.InferExplicitSubmodules),  $uint2ullong(Mod.InferExportWildcard), 
             $uint2ullong(Mod.ConfigMacrosExhaustive)};
          Stream.EmitRecordWithBlob(DefinitionAbbrev, Record$1, new StringRef(Mod.Name));
        }
        
        // Emit the requirements.
        for (final /*const*/std.pairTypeBool<std.string>/*&*/ R : Mod.Requirements) {
          long Record$1[/*2*/] = new /*ullong*/long [/*2*/] {SubmoduleRecordTypes.SUBMODULE_REQUIRES, $uint2ullong(R.second)};
          Stream.EmitRecordWithBlob(RequiresAbbrev, Record$1, new StringRef(R.first));
        }
        {
          Module.Header UmbrellaHeader = null;
          try {
            
            // Emit the umbrella header, if there is one.
            UmbrellaHeader = Mod.getUmbrellaHeader();
            if (UmbrellaHeader.$bool()) {
              long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {SubmoduleRecordTypes.SUBMODULE_UMBRELLA_HEADER};
              Stream.EmitRecordWithBlob(UmbrellaAbbrev, Record$1, 
                  new StringRef(UmbrellaHeader.NameAsWritten));
            } else {
              Module.DirectoryName UmbrellaDir = null;
              try {
                UmbrellaDir = Mod.getUmbrellaDir();
                if (UmbrellaDir.$bool()) {
                  long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {SubmoduleRecordTypes.SUBMODULE_UMBRELLA_DIR};
                  Stream.EmitRecordWithBlob(UmbrellaDirAbbrev, Record$1, 
                      new StringRef(UmbrellaDir.NameAsWritten));
                }
              } finally {
                if (UmbrellaDir != null) { UmbrellaDir.$destroy(); }
              }
            }
          } finally {
            if (UmbrellaHeader != null) { UmbrellaHeader.$destroy(); }
          }
        }
        
        // Emit the headers.
        //<editor-fold defaultstate="collapsed" desc="">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2581,
         FQN="", NM="_ZN5clang9ASTWriter15WriteSubmodulesEPNS_6ModuleE_Unnamed_struct",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter15WriteSubmodulesEPNS_6ModuleE_Unnamed_struct")
        //</editor-fold>
         class/*struct*/ Unnamed_struct {
          public /*uint*/int RecordKind;
          public /*uint*/int Abbrev;
          public Module.HeaderKind HeaderKind;

          public Unnamed_struct(int RecordKind, int Abbrev, Module.HeaderKind HeaderKind) {
            this.RecordKind = RecordKind;
            this.Abbrev = Abbrev;
            this.HeaderKind = HeaderKind;
          }
          
          @Override public String toString() {
            return "" + "RecordKind=" + RecordKind // NOI18N
                      + ", Abbrev=" + Abbrev // NOI18N
                      + ", HeaderKind=" + HeaderKind; // NOI18N
          }
        }
;
        Unnamed_struct HeaderLists[/*5*/] = new Unnamed_struct [/*5*/] {
          new Unnamed_struct(SubmoduleRecordTypes.SUBMODULE_HEADER, HeaderAbbrev, Module.HeaderKind.HK_Normal), 
          new Unnamed_struct(SubmoduleRecordTypes.SUBMODULE_TEXTUAL_HEADER, TextualHeaderAbbrev, Module.HeaderKind.HK_Textual), 
          new Unnamed_struct(SubmoduleRecordTypes.SUBMODULE_PRIVATE_HEADER, PrivateHeaderAbbrev, Module.HeaderKind.HK_Private), 
          new Unnamed_struct(
            SubmoduleRecordTypes.SUBMODULE_PRIVATE_TEXTUAL_HEADER, PrivateTextualHeaderAbbrev, 
            Module.HeaderKind.HK_PrivateTextual), 
          new Unnamed_struct(SubmoduleRecordTypes.SUBMODULE_EXCLUDED_HEADER, ExcludedHeaderAbbrev, Module.HeaderKind.HK_Excluded)
        };
        for (final Unnamed_struct HL : HeaderLists) {
          long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {HL.RecordKind};
          for (final Module.Header /*&*/ H : Mod.Headers[HL.HeaderKind.getValue()])  {
            Stream.EmitRecordWithBlob(HL.Abbrev, Record$1, new StringRef(H.NameAsWritten));
          }
        }
        {
          ArrayRef</*const*/ FileEntry /*P*/ > TopHeaders = Mod.getTopHeaders(PP.getFileManager());
          long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {SubmoduleRecordTypes.SUBMODULE_TOPHEADER};
          for (/*const*/ FileEntry /*P*/ H : TopHeaders)  {
            Stream.EmitRecordWithBlob(TopHeaderAbbrev, Record$1, new StringRef(H.getName()));
          }
        }
        
        // Emit the imports. 
        if (!Mod.Imports.empty()) {
          SmallVectorULong Record$1/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          for (Module /*P*/ I : Mod.Imports)  {
            Record$1.push_back($uint2ullong(getSubmoduleID(I)));
          }
          Stream.EmitRecord(SubmoduleRecordTypes.SUBMODULE_IMPORTS, Record$1);
        }
        
        // Emit the exports. 
        if (!Mod.Exports.empty()) {
          SmallVectorULong Record$1/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          for (final /*const*/PointerInt2Pair</*const*/ Module/*P*/> /*&*/ E : Mod.Exports) {
            // FIXME: This may fail; we don't require that all exported modules
            // are local or imported.
            Record$1.push_back($uint2ullong(getSubmoduleID(E.getPointer())));
            Record$1.push_back(E.getInt());
          }
          Stream.EmitRecord(SubmoduleRecordTypes.SUBMODULE_EXPORTS, Record$1);
        }
        
        //FIXME: How do we emit the 'use'd modules?  They may not be submodules.
        // Might be unnecessary as use declarations are only used to build the
        // module itself.
        
        // Emit the link libraries.
        for (final /*const*/ Module.LinkLibrary /*&*/ LL : Mod.LinkLibraries) {
          long Record$1[/*2*/] = new /*ullong*/long [/*2*/] {
            SubmoduleRecordTypes.SUBMODULE_LINK_LIBRARY, 
            $uint2ullong(LL.IsFramework)};
          Stream.EmitRecordWithBlob(LinkLibraryAbbrev, Record$1, new StringRef(LL.Library));
        }
        
        // Emit the conflicts.
        for (final /*const*/ Module.Conflict /*&*/ C : Mod.Conflicts) {
          // FIXME: This may fail; we don't require that all conflicting modules
          // are local or imported.
          long Record$1[/*2*/] = new /*ullong*/long [/*2*/] {
            SubmoduleRecordTypes.SUBMODULE_CONFLICT, 
            getSubmoduleID(C.Other)};
          Stream.EmitRecordWithBlob(ConflictAbbrev, Record$1, new StringRef(C.Message));
        }
        
        // Emit the configuration macros.
        for (final /*const*/std.string/*&*/ CM : Mod.ConfigMacros) {
          long Record$1[/*1*/] = new /*ullong*/long [/*1*/] {SubmoduleRecordTypes.SUBMODULE_CONFIG_MACRO};
          Stream.EmitRecordWithBlob(ConfigMacroAbbrev, Record$1, new StringRef(CM));
        }
        
        // Queue up the submodules of this module.
        for (Module /*P*/ M : Mod.submodules())  {
          Q.push_value_type$C(M);
        }
      }
      
      Stream.ExitBlock();
      assert ((NextSubmoduleID - FirstSubmoduleID == getNumberOfModules(WritingModule))) : "Wrong # of submodules; found a reference to a non-local, non-imported submodule?";
    } finally {
      if (Q != null) { Q.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WritePragmaDiagnosticMappings">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2685,
   FQN="clang::ASTWriter::WritePragmaDiagnosticMappings", NM="_ZN5clang9ASTWriter29WritePragmaDiagnosticMappingsERKNS_17DiagnosticsEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter29WritePragmaDiagnosticMappingsERKNS_17DiagnosticsEngineEb")
  //</editor-fold>
  private void WritePragmaDiagnosticMappings(final /*const*/ DiagnosticsEngine /*&*/ Diag, 
                               boolean isModule) {
    // Make sure set diagnostic pragmas don't affect the translation unit that
    // imports the module.
    // FIXME: Make diagnostic pragma sections work properly with modules.
    if (isModule) {
      return;
    }
    
    SmallDenseMapTypeUInt</*const*/ DiagnosticsEngine.DiagState /*P*/ > DiagStateIDMap/*J*/= new SmallDenseMapTypeUInt</*const*/ DiagnosticsEngine.DiagState /*P*/ >(DenseMapInfo$LikePtr.$Info(), 64, (/*uint*/int)0);
    /*uint*/int CurrID = 0;
    DiagStateIDMap.$set($AddrOf(Diag.DiagStates.front$Const()), ++CurrID); // the command-line one.
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (std.vector.iterator</*const*/ DiagnosticsEngine.DiagStatePoint /*P*/ > I = new std.vector.iterator</*const*/ DiagnosticsEngine.DiagStatePoint /*P*/ >(Diag.DiagStatePoints.begin()), E = new std.vector.iterator</*const*/ DiagnosticsEngine.DiagStatePoint /*P*/ >(Diag.DiagStatePoints.end());
         $noteq___normal_iterator$C(I, E); I.$preInc()) {
      final /*const*/ DiagnosticsEngine.DiagStatePoint /*&*/ point = I.$star();
      if (point.Loc.isInvalid()) {
        continue;
      }
      
      AddSourceLocation(new SourceLocation(point.Loc), Record);
      final uint$ref/*uint &*/ DiagStateID = DiagStateIDMap.ref$at(point.State);
      Record.push_back($uint2ullong(DiagStateID.$deref()));
      if (DiagStateID.$deref() == 0) {
        DiagStateID.$set(++CurrID);
        for (final /*const*/ std.pairUIntType<DiagnosticMapping> /*&*/ I$1 : $Deref((point.State))) {
          if (I$1.second.isPragma()) {
            Record.push_back($uint2ullong(I$1.first));
            Record.push_back($uint2ullong(((/*uint*/int)I$1.second.getSeverity().getValue())));
          }
        }
        Record.push_back($int2ullong(-1)); // mark the end of the diag/map pairs for this
        // location.
      }
    }
    if (!Record.empty()) {
      Stream.EmitRecord(ASTRecordTypes.DIAG_PRAGMA_MAPPINGS, Record);
    }
  }

  
  /*friend*/public /*uint*/int TypeExtQualAbbrev;
  private /*uint*/int TypeFunctionProtoAbbrev;
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteTypeAbbrevs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 713,
   FQN="clang::ASTWriter::WriteTypeAbbrevs", NM="_ZN5clang9ASTWriter16WriteTypeAbbrevsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16WriteTypeAbbrevsEv")
  //</editor-fold>
  private void WriteTypeAbbrevs() {
    //JAVA: using namespace llvm;
    
    BitCodeAbbrev /*P*/ Abv;
    
    // Abbreviation for TYPE_EXT_QUAL
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(TypeCode.TYPE_EXT_QUAL));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(3))); // Quals
    TypeExtQualAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for TYPE_FUNCTION_PROTO
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(TypeCode.TYPE_FUNCTION_PROTO));
    // FunctionType
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // ReturnType
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // NoReturn
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasRegParm
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // RegParm
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(4))); // CC
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ProducesResult
    // FunctionProtoType
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // IsVariadic
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasTrailingReturn
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TypeQuals
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // RefQualifier
    Abv.Add(new BitCodeAbbrevOp(ExceptionSpecificationType.EST_None.getValue())); // ExceptionSpec
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // NumParams
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Params
    TypeFunctionProtoAbbrev = Stream.EmitAbbrev(Abv);
  }

  
  //===----------------------------------------------------------------------===//
  // Type Serialization
  //===----------------------------------------------------------------------===//
  
  /// \brief Write the representation of a type to the AST stream.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2731,
   FQN="clang::ASTWriter::WriteType", NM="_ZN5clang9ASTWriter9WriteTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter9WriteTypeENS_8QualTypeE")
  //</editor-fold>
  private void WriteType(QualType T) {
    ASTTypeWriter W = null;
    try {
      final TypeIdx /*&*/ IdxRef = TypeIdxs.$at_T1$C$R(T);
      if (IdxRef.getIndex() == 0) { // we haven't seen this type before.
        IdxRef.$assignMove(new TypeIdx(NextTypeID++));
      }
      TypeIdx Idx = new TypeIdx(IdxRef);
      assert ($greatereq_uint(Idx.getIndex(), FirstTypeID)) : "Re-writing a type from a prior AST";
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      
      // Emit the type's representation.
      W/*J*/= new ASTTypeWriter(/*Deref*/this, Record);
      W.Visit(new QualType(T));
      long/*uint64_t*/ Offset = W.Emit();
      
      // Record the offset for this type.
      /*uint*/int Index = Idx.getIndex() - FirstTypeID;
      if (TypeOffsets.size() == Index) {
        TypeOffsets.push_back_T$RR($ulong2uint(Offset));
      } else if ($less_uint(TypeOffsets.size(), Index)) {
        TypeOffsets.resize(Index + 1);
        TypeOffsets.$set(Index, $ulong2uint(Offset));
      } else {
        throw new llvm_unreachable("Types emitted in wrong order");
      }
    } finally {
      if (W != null) { W.$destroy(); }
    }
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::isLookupResultExternal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3514,
   FQN="clang::ASTWriter::isLookupResultExternal", NM="_ZN5clang9ASTWriter22isLookupResultExternalERNS_15StoredDeclsListEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter22isLookupResultExternalERNS_15StoredDeclsListEPNS_11DeclContextE")
  //</editor-fold>
  private boolean isLookupResultExternal(final StoredDeclsList /*&*/ Result, 
                        DeclContext /*P*/ DC) {
    return Result.hasExternalDecls() && DC.$DeclContext$Fields().NeedToReconcileExternalVisibleStorage;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::isLookupResultEntirelyExternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3519,
   FQN="clang::ASTWriter::isLookupResultEntirelyExternal", NM="_ZN5clang9ASTWriter30isLookupResultEntirelyExternalERNS_15StoredDeclsListEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter30isLookupResultEntirelyExternalERNS_15StoredDeclsListEPNS_11DeclContextE")
  //</editor-fold>
  private boolean isLookupResultEntirelyExternal(final StoredDeclsList /*&*/ Result, 
                                DeclContext /*P*/ DC) {
    for (NamedDecl /*P*/ D : Result.getLookupResult())  {
      if (!getDeclForLocalLookup(getLangOpts(), D).isFromASTFile()) {
        return false;
      }
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::GenerateNameLookupTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3528,
   FQN="clang::ASTWriter::GenerateNameLookupTable", NM="_ZN5clang9ASTWriter23GenerateNameLookupTableEPKNS_11DeclContextERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter23GenerateNameLookupTableEPKNS_11DeclContextERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  private void GenerateNameLookupTable(/*const*/ DeclContext /*P*/ ConstDC, 
                         final SmallString/*&*/ LookupTable) {
    MultiOnDiskHashTableGenerator Generator = null;
    ASTDeclContextNameLookupTrait Trait = null;
    SmallSet<DeclarationName> ConstructorNameSet = null;
    SmallSet<DeclarationName> ConversionNameSet = null;
    try {
      assert (!ConstDC.$DeclContext$Fields().HasLazyLocalLexicalLookups && !ConstDC.$DeclContext$Fields().HasLazyExternalLexicalLookups) : "must call buildLookups first";
      
      // FIXME: We need to build the lookups table, which is logically const.
      DeclContext /*P*/ DC = ((/*const_cast*/DeclContext /*P*/ )(ConstDC));
      assert (DC == DC.getPrimaryContext()) : "only primary DC has lookup table";
      
      // Create the on-disk hash table representation.
      // JAVA: use the same trait objects
      Trait/*J*/= new ASTDeclContextNameLookupTrait(/*Deref*/this);
      Generator/*J*/= new MultiOnDiskHashTableGenerator(Trait);
      
      // The first step is to collect the declaration names which we need to
      // serialize into the name lookup table, and to collect them in a stable
      // order.
      SmallVector<DeclarationName> Names/*J*/= new SmallVector<DeclarationName>(16, new DeclarationName());
      
      // We also build up small sets of the constructor and conversion function
      // names which are visible.
      ConstructorNameSet/*J*/= new SmallSet<DeclarationName>(8, DeclarationName.DEFAULT, DeclarationName.COMPARATOR);
      ConversionNameSet/*J*/= new SmallSet<DeclarationName>(8, DeclarationName.DEFAULT, DeclarationName.COMPARATOR);
      
      for (final std.pair<DeclarationName, StoredDeclsList> /*&*/ Lookup : $Deref(DC.buildLookup())) {
        final DeclarationName /*&*/ Name = Lookup.first;
        final StoredDeclsList /*&*/ Result = Lookup.second;
        
        // If there are no local declarations in our lookup result, we
        // don't need to write an entry for the name at all. If we can't
        // write out a lookup set without performing more deserialization,
        // just skip this entry.
        if (isLookupResultExternal(Result, DC)
           && isLookupResultEntirelyExternal(Result, DC)) {
          continue;
        }
        
        // We also skip empty results. If any of the results could be external and
        // the currently available results are empty, then all of the results are
        // external and we skip it above. So the only way we get here with an empty
        // results is when no results could have been external *and* we have
        // external results.
        //
        // FIXME: While we might want to start emitting on-disk entries for negative
        // lookups into a decl context as an optimization, today we *have* to skip
        // them because there are names with empty lookup results in decl contexts
        // which we can't emit in any stable ordering: we lookup constructors and
        // conversion functions in the enclosing namespace scope creating empty
        // results for them. This in almost certainly a bug in Clang's name lookup,
        // but that is likely to be hard or impossible to fix and so we tolerate it
        // here by omitting lookups with empty results.
        if (Lookup.second.getLookupResult().empty()) {
          continue;
        }
        switch (Lookup.first.getNameKind()) {
         default:
          Names.push_back(Lookup.first);
          break;
         case CXXConstructorName:
          assert (isa_CXXRecordDecl(DC)) : "Cannot have a constructor name outside of a class!";
          ConstructorNameSet.insert(Name);
          break;
         case CXXConversionFunctionName:
          assert (isa_CXXRecordDecl(DC)) : "Cannot have a conversion function name outside of a class!";
          ConversionNameSet.insert(Name);
          break;
        }
      }
      
      // Sort the names into a stable order.
      std.sort(Names.begin(), Names.end());
      {
        
        CXXRecordDecl /*P*/ D = dyn_cast_CXXRecordDecl(DC);
        if ((D != null)) {
          // We need to establish an ordering of constructor and conversion function
          // names, and they don't have an intrinsic ordering.
          
          // First we try the easy case by forming the current context's constructor
          // name and adding that name first. This is a very useful optimization to
          // avoid walking the lexical declarations in many cases, and it also
          // handles the only case where a constructor name can come from some other
          // lexical context -- when that name is an implicit constructor merged from
          // another declaration in the redecl chain. Any non-implicit constructor or
          // conversion function which doesn't occur in all the lexical contexts
          // would be an ODR violation.
          DeclarationName ImplicitCtorName = Context.DeclarationNames.getCXXConstructorName(Context.getCanonicalType(Context.getRecordType(D)));
          if (ConstructorNameSet.erase(ImplicitCtorName)) {
            Names.push_back(ImplicitCtorName);
          }
          
          // If we still have constructors or conversion functions, we walk all the
          // names in the decl and add the constructors and conversion functions
          // which are visible in the order they lexically occur within the context.
          if (!ConstructorNameSet.empty() || !ConversionNameSet.empty()) {
            for (Decl /*P*/ ChildD : cast_CXXRecordDecl(DC).decls())  {
              {
                NamedDecl /*P*/ ChildND = dyn_cast_NamedDecl(ChildD);
                if ((ChildND != null)) {
                  DeclarationName Name = ChildND.getDeclName();
                  switch (Name.getNameKind()) {
                   default:
                    continue;
                   case CXXConstructorName:
                    if (ConstructorNameSet.erase(Name)) {
                      Names.push_back(Name);
                    }
                    break;
                   case CXXConversionFunctionName:
                    if (ConversionNameSet.erase(Name)) {
                      Names.push_back(Name);
                    }
                    break;
                  }
                  if (ConstructorNameSet.empty() && ConversionNameSet.empty()) {
                    break;
                  }
                }
              }
            }
          }
          assert (ConstructorNameSet.empty()) : "Failed to find all of the visible constructors by walking all the lexical members of the context.";
          assert (ConversionNameSet.empty()) : "Failed to find all of the visible conversion functions by walking all the lexical members of the context.";
        }
      }
      
      // Next we need to do a lookup with each name into this decl context to fully
      // populate any results from external sources. We don't actually use the
      // results of these lookups because we only want to use the results after all
      // results have been loaded and the pointers into them will be stable.
      for (final DeclarationName /*&*/ Name : Names)  {
        DC.lookup(new DeclarationName(Name));
      }
      
      // Now we need to insert the results for each name into the hash table. For
      // constructor names and conversion function names, we actually need to merge
      // all of the results for them into one list of results each and insert
      // those.
      SmallVector<NamedDecl /*P*/ > ConstructorDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(8, (NamedDecl /*P*/ )null);
      SmallVector<NamedDecl /*P*/ > ConversionDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(8, (NamedDecl /*P*/ )null);
      
      // Now loop over the names, either inserting them or appending for the two
      // special cases.
      for (final DeclarationName /*&*/ Name : Names) {
        DeclContextLookupResult Result = DC.noload_lookup(new DeclarationName(Name));
        switch (Name.getNameKind()) {
         default:
          Generator.insert(new DeclarationNameKey(new DeclarationName(Name)), Trait.getData(Result), Trait);
          break;
         case CXXConstructorName:
          ConstructorDecls.append_T(Result.begin(), Result.end());
          break;
         case CXXConversionFunctionName:
          ConversionDecls.append_T(Result.begin(), Result.end());
          break;
        }
      }
      
      // Handle our two special cases if we ended up having any. We arbitrarily use
      // the first declaration's name here because the name itself isn't part of
      // the key, only the kind of name is used.
      if (!ConstructorDecls.empty()) {
        Generator.insert(new DeclarationNameKey(ConstructorDecls.front().getDeclName()), 
            Trait.getData(ConstructorDecls), Trait);
      }
      if (!ConversionDecls.empty()) {
        Generator.insert(new DeclarationNameKey(ConversionDecls.front().getDeclName()), 
            Trait.getData(ConversionDecls), Trait);
      }
      
      // Create the on-disk hash table. Also emit the existing imported and
      // merged table if there is one.
      /*const*/ DeclContextLookupTable /*P*/ Lookups = (Chain != null) ? Chain.getLoadedLookupTables(DC) : null;
      Generator.emit(LookupTable, Trait, (Lookups != null) ? $AddrOf(Lookups.Table) : (/*const*/ MultiOnDiskHashTable/*<ASTDeclContextNameLookupTrait>*/ /*P*/ )null);
    } finally {
      if (ConversionNameSet != null) { ConversionNameSet.$destroy(); }
      if (ConstructorNameSet != null) { ConstructorNameSet.$destroy(); }
      if (Trait != null) { Trait.$destroy(); }
      if (Generator != null) { Generator.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Declaration Serialization
  //===----------------------------------------------------------------------===//
  
  /// \brief Write the block containing all of the declaration IDs
  /// lexically declared within the given DeclContext.
  ///
  /// \returns the offset of the DECL_CONTEXT_LEXICAL block within the
  /// bistream, or 0 if no block was written.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteDeclContextLexicalBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2767,
   FQN="clang::ASTWriter::WriteDeclContextLexicalBlock", NM="_ZN5clang9ASTWriter28WriteDeclContextLexicalBlockERNS_10ASTContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter28WriteDeclContextLexicalBlockERNS_10ASTContextEPNS_11DeclContextE")
  //</editor-fold>
  /*friend*/public long/*uint64_t*/ WriteDeclContextLexicalBlock(final ASTContext /*&*/ Context, 
                              DeclContext /*P*/ DC) {
    if (DC.decls_empty()) {
      return $int2ulong(0);
    }
    
    long/*uint64_t*/ Offset = Stream.GetCurrentBitNo();
    SmallVectorUInt KindDeclPairs/*J*/= new SmallVectorUInt(128, (/*uint32_t*/int)0);
    for (/*const*/ Decl /*P*/ D : DC.decls()) {
      KindDeclPairs.push_back(D.getKind().getValue());
      KindDeclPairs.push_back(GetDeclRef(D));
    }
    
    ++NumLexicalDeclContexts;
    long Record[/*1*/] = new /*ullong*/long [/*1*/] {DeclCode.DECL_CONTEXT_LEXICAL};
    Stream.EmitRecordWithBlob(DeclContextLexicalAbbrev, Record, 
        bytes(KindDeclPairs));
    return Offset;
  }

  
  /// \brief Write the block containing all of the declaration IDs
  /// visible from the given DeclContext.
  ///
  /// \returns the offset of the DECL_CONTEXT_VISIBLE block within the
  /// bitstream, or 0 if no block was written.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteDeclContextVisibleBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3710,
   FQN="clang::ASTWriter::WriteDeclContextVisibleBlock", NM="_ZN5clang9ASTWriter28WriteDeclContextVisibleBlockERNS_10ASTContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter28WriteDeclContextVisibleBlockERNS_10ASTContextEPNS_11DeclContextE")
  //</editor-fold>
  /*friend*/public long/*uint64_t*/ WriteDeclContextVisibleBlock(final ASTContext /*&*/ Context, 
                              DeclContext /*P*/ DC) {
    // If we imported a key declaration of this namespace, write the visible
    // lookup results as an update record for it rather than including them
    // on this declaration. We will only look at key declarations on reload.
    if (isa_NamespaceDecl(DC) && (Chain != null)
       && Chain.getKeyDeclaration_Decl$P(cast_Decl(DC)).isFromASTFile()) {
      // Only do this once, for the first local declaration of the namespace.
      for (NamespaceDecl /*P*/ Prev = cast_NamespaceDecl(DC).getPreviousDecl$Redeclarable(); (Prev != null);
           Prev = Prev.getPreviousDecl$Redeclarable())  {
        if (!Prev.isFromASTFile()) {
          return $int2ulong(0);
        }
      }
      
      // Note that we need to emit an update record for the primary context.
      UpdatedDeclContexts.insert(DC.getPrimaryContext());
      
      // Make sure all visible decls are written. They will be recorded later. We
      // do this using a side data structure so we can sort the names into
      // a deterministic order.
      StoredDeclsMap /*P*/ Map = DC.getPrimaryContext().buildLookup();
      SmallVector<std.pairTypeType<DeclarationName, DeclContextLookupResult>> LookupResults/*J*/= new SmallVector<std.pairTypeType<DeclarationName, DeclContextLookupResult>>(16, new std.pairTypeType<DeclarationName, DeclContextLookupResult>());
      if ((Map != null)) {
        LookupResults.reserve(Map.size());
        for (final std.pair<DeclarationName, StoredDeclsList> /*&*/ Entry : $Deref(Map))  {
          LookupResults.push_back(std.make_pair($Clone(Entry.first), $Move(Entry.second.getLookupResult())));
        }
      }
      
      std.sort(LookupResults.begin(), LookupResults.end(), less_first::$call);
      for (final std.pairTypeType<DeclarationName, DeclContextLookupResult> /*&*/ NameAndResult : LookupResults) {
        DeclarationName Name = new DeclarationName(NameAndResult.first);
        DeclContextLookupResult Result = new DeclContextLookupResult(NameAndResult.second);
        if (Name.getNameKind() == DeclarationName.NameKind.CXXConstructorName
           || Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName) {
          // We have to work around a name lookup bug here where negative lookup
          // results for these names get cached in namespace lookup tables (these
          // names should never be looked up in a namespace).
          assert (Result.empty()) : "Cannot have a constructor or conversion function name in a namespace!";
          continue;
        }
        
        for (NamedDecl /*P*/ ND : Result)  {
          if (!ND.isFromASTFile()) {
            GetDeclRef(ND);
          }
        }
      }
      
      return $int2ulong(0);
    }
    if (DC.getPrimaryContext() != DC) {
      return $int2ulong(0);
    }
    
    // Skip contexts which don't support name lookup.
    if (!DC.isLookupContext()) {
      return $int2ulong(0);
    }
    
    // If not in C++, we perform name lookup for the translation unit via the
    // IdentifierInfo chains, don't bother to build a visible-declarations table.
    if (DC.isTranslationUnit() && !Context.getLangOpts().CPlusPlus) {
      return $int2ulong(0);
    }
    
    // Serialize the contents of the mapping used for lookup. Note that,
    // although we have two very different code paths, the serialized
    // representation is the same for both cases: a declaration name,
    // followed by a size, followed by references to the visible
    // declarations that have that name.
    long/*uint64_t*/ Offset = Stream.GetCurrentBitNo();
    StoredDeclsMap /*P*/ Map = DC.buildLookup();
    if (!(Map != null) || Map.empty()) {
      return $int2ulong(0);
    }
    
    // Create the on-disk hash table in a buffer.
    SmallString/*<4096>*/ LookupTable/*J*/= new SmallString/*<4096>*/(4096);
    GenerateNameLookupTable(DC, LookupTable);
    
    // Write the lookup table
    long Record[/*1*/] = new /*ullong*/long [/*1*/] {DeclCode.DECL_CONTEXT_VISIBLE};
    Stream.EmitRecordWithBlob(DeclContextVisibleLookupAbbrev, Record, 
        LookupTable.$StringRef());
    ++NumVisibleDeclContexts;
    return Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteTypeDeclOffsets">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2786,
   FQN="clang::ASTWriter::WriteTypeDeclOffsets", NM="_ZN5clang9ASTWriter20WriteTypeDeclOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter20WriteTypeDeclOffsetsEv")
  //</editor-fold>
  private void WriteTypeDeclOffsets() {
    //JAVA: using namespace llvm;
    
    // Write the type offsets array
    BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.TYPE_OFFSET));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // # of types
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // base type index
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // types block
    /*uint*/int TypeOffsetAbbrev = Stream.EmitAbbrev(Abbrev);
    {
      long Record[/*3*/] = new /*ullong*/long [/*3*/] {
        ASTRecordTypes.TYPE_OFFSET, TypeOffsets.size(), 
        FirstTypeID - NUM_PREDEF_TYPE_IDS};
      Stream.EmitRecordWithBlob(TypeOffsetAbbrev, Record, bytes(TypeOffsets));
    }
    
    // Write the declaration offsets array
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.DECL_OFFSET));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // # of declarations
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // base decl ID
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // declarations block
    /*uint*/int DeclOffsetAbbrev = Stream.EmitAbbrev(Abbrev);
    {
      long Record[/*3*/] = new /*ullong*/long [/*3*/] {
        ASTRecordTypes.DECL_OFFSET, DeclOffsets.size(), 
        FirstDeclID - NUM_PREDEF_DECL_IDS};
      Stream.EmitRecordWithBlob(DeclOffsetAbbrev, Record, bytes(DeclOffsets));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteFileDeclIDsMap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2816,
   FQN="clang::ASTWriter::WriteFileDeclIDsMap", NM="_ZN5clang9ASTWriter19WriteFileDeclIDsMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19WriteFileDeclIDsMapEv")
  //</editor-fold>
  private void WriteFileDeclIDsMap() {
    //JAVA: using namespace llvm;
    
    SmallVector<std.pair<FileID, DeclIDInFileInfo /*P*/ >> SortedFileDeclIDs/*J*/= 
            new SmallVector<std.pair<FileID, DeclIDInFileInfo /*P*/ >>(
                    JD$T.INSTANCE, 64, (type$iterator)FileDeclIDs.begin(), (type$iterator)FileDeclIDs.end(), new std.pairTypePtr<FileID, DeclIDInFileInfo /*P*/ >(new FileID(), null));
    std.sort(SortedFileDeclIDs.begin(), SortedFileDeclIDs.end(), 
            less_first::$call);
    
    // Join the vectors of DeclIDs from all files.
    SmallVectorUInt FileGroupedDeclIDs/*J*/= new SmallVectorUInt(256, (/*uint32_t*/int)0);
    for (final std.pair<FileID, DeclIDInFileInfo /*P*/ > /*&*/ FileDeclEntry : SortedFileDeclIDs) {
      final DeclIDInFileInfo /*&*/ Info = $Deref(FileDeclEntry.second);
      Info.FirstDeclIndex = FileGroupedDeclIDs.size();
      for (final std.pairUIntUInt/*&*/ LocDeclEntry : Info.DeclIDs)  {
        FileGroupedDeclIDs.push_back(LocDeclEntry.second);
      }
    }
    
    BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.FILE_SORTED_DECLS));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    /*uint*/int AbbrevCode = Stream.EmitAbbrev(Abbrev);
    long Record[/*2*/] = new /*ullong*/long [/*2*/] {
      ASTRecordTypes.FILE_SORTED_DECLS, 
      FileGroupedDeclIDs.size()};
    Stream.EmitRecordWithBlob(AbbrevCode, Record, bytes(FileGroupedDeclIDs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2843,
   FQN="clang::ASTWriter::WriteComments", NM="_ZN5clang9ASTWriter13WriteCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter13WriteCommentsEv")
  //</editor-fold>
  private void WriteComments() {
    Stream.EnterSubblock(BlockIDs.COMMENTS_BLOCK_ID, 3);
    ArrayRef<RawComment /*P*/ > RawComments = Context.Comments.getComments();
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (/*const*/ RawComment /*P*/ I : RawComments) {
      Record.clear();
      AddSourceRange(I.getSourceRange(), Record);
      Record.push_back(I.getKind().getValue());
      Record.push_back((I.isTrailingComment() ? 1 : 0));
      Record.push_back((I.isAlmostTrailingComment() ? 1 : 0));
      Stream.EmitRecord(CommentRecordTypes.COMMENTS_RAW_COMMENT, Record);
    }
    Stream.ExitBlock();
  }

  // end anonymous namespace
  
  /// \brief Write ObjC data: selectors and the method pool.
  ///
  /// The method pool contains both instance and factory methods, stored
  /// in an on-disk hash table indexed by the selector. The hash table also
  /// contains an empty entry for every other selector known to Sema.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteSelectors">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2974,
   FQN="clang::ASTWriter::WriteSelectors", NM="_ZN5clang9ASTWriter14WriteSelectorsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter14WriteSelectorsERNS_4SemaE")
  //</editor-fold>
  private void WriteSelectors(final Sema /*&*/ SemaRef) {
    //JAVA: using namespace llvm;
    
    // Do we have to do anything at all?
    if (SemaRef.MethodPool.empty() && SelectorIDs.empty()) {
      return;
    }
    /*uint*/int NumTableEntries = 0;
    {
      OnDiskChainedHashTableGenerator<Selector, Selector, ASTMethodPoolTrait.data_type> Generator = null;
      try {
        ASTMethodPoolTrait Trait/*J*/= new ASTMethodPoolTrait(/*Deref*/this);
        Generator/*J*/= new OnDiskChainedHashTableGenerator<Selector, Selector, ASTMethodPoolTrait.data_type>(Trait);
        
        // Create the on-disk hash table representation. We walk through every
        // selector we've seen and look it up in the method pool.
        SelectorOffsets.resize(NextSelectorID - FirstSelectorID);
        for (final std.pairTypeUInt<Selector> /*&*/ SelectorAndID : SelectorIDs) {
          Selector S = new Selector(SelectorAndID.first);
          /*uint32_t*/int ID = SelectorAndID.second;
          DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> F = SemaRef.MethodPool.find(S);
          ASTMethodPoolTrait.data_type Data = new ASTMethodPoolTrait.data_type(
            ID, 
            new ObjCMethodList(), 
            new ObjCMethodList()
          );
          if (F.$noteq(/*NO_ITER_COPY*/SemaRef.MethodPool.end())) {
            Data.Instance.$assign(F.$arrow().second.first);
            Data.Factory.$assign(F.$arrow().second.second);
          }
          // Only write this selector if it's not in an existing AST or something
          // changed.
          if ((Chain != null) && $less_uint(ID, FirstSelectorID)) {
            // Selector already exists. Did it change?
            boolean changed = false;
            for (ObjCMethodList /*P*/ M = $AddrOf(Data.Instance);
                 !changed && (M != null) && (M.getMethod() != null); M = M.getNext()) {
              if (!M.getMethod().isFromASTFile()) {
                changed = true;
              }
            }
            for (ObjCMethodList /*P*/ M = $AddrOf(Data.Factory); !changed && (M != null) && (M.getMethod() != null);
                 M = M.getNext()) {
              if (!M.getMethod().isFromASTFile()) {
                changed = true;
              }
            }
            if (!changed) {
              continue;
            }
          } else if ((Data.Instance.getMethod() != null) || (Data.Factory.getMethod() != null)) {
            // A new method pool entry.
            ++NumTableEntries;
          }
          Generator.insert(new Selector(S), Data, Trait);
        }
        
        // Create the on-disk hash table in a buffer.
        SmallString/*<4096>*/ MethodPool/*J*/= new SmallString/*<4096>*/(4096);
        /*uint32_t*/int BucketOffset;
        {
          raw_svector_ostream Out = null;
          try {
            //JAVA: using namespace llvm::support;
            ASTMethodPoolTrait Trait$1/*J*/= new ASTMethodPoolTrait(/*Deref*/this);
            Out/*J*/= new raw_svector_ostream(MethodPool);
            // Make sure that no bucket is at offset 0
            new Writer(little, Out).write_uint32(0);
            BucketOffset = Generator.Emit(Out, Trait$1);
          } finally {
            if (Out != null) { Out.$destroy(); }
          }
        }
        
        // Create a blob abbreviation
        BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
        Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.METHOD_POOL));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
        /*uint*/int MethodPoolAbbrev = Stream.EmitAbbrev(Abbrev);
        {
          long Record[/*3*/] = new /*ullong*/long [/*3*/] {
            ASTRecordTypes.METHOD_POOL, BucketOffset, 
            NumTableEntries};
          Stream.EmitRecordWithBlob(MethodPoolAbbrev, Record, MethodPool.$StringRef());
        }
        
        // Create a blob abbreviation for the selector table offsets.
        Abbrev = new BitCodeAbbrev();
        Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.SELECTOR_OFFSETS));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // size
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // first ID
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
        /*uint*/int SelectorOffsetAbbrev = Stream.EmitAbbrev(Abbrev);
        {
          long Record[/*3*/] = new /*ullong*/long [/*3*/] {
            ASTRecordTypes.SELECTOR_OFFSETS, SelectorOffsets.size(), 
            FirstSelectorID - NUM_PREDEF_SELECTOR_IDS};
          Stream.EmitRecordWithBlob(SelectorOffsetAbbrev, Record, 
              bytes(SelectorOffsets));
        }
      } finally {
        if (Generator != null) { Generator.$destroy(); }
      }
    }
  }

  
  /// \brief Write the selectors referenced in @selector expression into AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteReferencedSelectorsPool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3073,
   FQN="clang::ASTWriter::WriteReferencedSelectorsPool", NM="_ZN5clang9ASTWriter28WriteReferencedSelectorsPoolERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter28WriteReferencedSelectorsPoolERNS_4SemaE")
  //</editor-fold>
  private void WriteReferencedSelectorsPool(final Sema /*&*/ SemaRef) {
    ASTRecordWriter Writer = null;
    try {
      //JAVA: using namespace llvm;
      if (SemaRef.ReferencedSelectors.empty()) {
        return;
      }
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      Writer/*J*/= new ASTRecordWriter(/*Deref*/this, Record);
      
      // Note: this writes out all references even for a dependent AST. But it is
      // very tricky to fix, and given that @selector shouldn't really appear in
      // headers, probably not worth it. It's not a correctness issue.
      for (final std.pair<Selector, SourceLocation> /*&*/ SelectorAndLocation : SemaRef.ReferencedSelectors) {
        Selector Sel = new Selector(SelectorAndLocation.first);
        SourceLocation Loc = new SourceLocation(SelectorAndLocation.second);
        Writer.AddSelectorRef(new Selector(Sel));
        Writer.AddSourceLocation(new SourceLocation(Loc));
      }
      Writer.Emit(ASTRecordTypes.REFERENCED_SELECTOR_POOL);
    } finally {
      if (Writer != null) { Writer.$destroy(); }
    }
  }

  // end anonymous namespace
  
  /// \brief Write the identifier table into the AST file.
  ///
  /// The identifier table consists of a blob containing string data
  /// (the actual identifiers themselves) and a separate "offsets" index
  /// that maps identifier IDs to locations within the blob.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteIdentifierTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3288,
   FQN="clang::ASTWriter::WriteIdentifierTable", NM="_ZN5clang9ASTWriter20WriteIdentifierTableERNS_12PreprocessorERNS_18IdentifierResolverEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter20WriteIdentifierTableERNS_12PreprocessorERNS_18IdentifierResolverEb")
  //</editor-fold>
  private void WriteIdentifierTable(final Preprocessor /*&*/ PP, 
                      final IdentifierResolver /*&*/ IdResolver, 
                      boolean IsModule) {
    //JAVA: using namespace llvm;
    
    SmallVectorULong InterestingIdents/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    {
      OnDiskChainedHashTableGenerator<IdentifierInfo, IdentifierInfo, Integer> Generator = null;
      try {
        ASTIdentifierTableTrait Trait/*J*/= new ASTIdentifierTableTrait(/*Deref*/this, PP, IdResolver, IsModule, 
            (getLangOpts().CPlusPlus && IsModule) ? $AddrOf(InterestingIdents) : (SmallVectorULong /*P*/)null);
        Generator/*J*/= new OnDiskChainedHashTableGenerator<IdentifierInfo, IdentifierInfo, Integer>(Trait);
        
        // Look for any identifiers that were named while processing the
        // headers, but are otherwise not needed. We add these to the hash
        // table to enable checking of the predefines buffer in the case
        // where the user adds new macro definitions when building the AST
        // file.
        SmallVector</*const*/ IdentifierInfo /*P*/ > IIs/*J*/= new SmallVector</*const*/ IdentifierInfo /*P*/ >(128, (/*const*/ IdentifierInfo /*P*/ )null);
        for (final /*const*/IdentifierInfoStringMapEntry/*&*/ ID : PP.getIdentifierTable())  {
          IIs.push_back(ID.$second());
        }
        // Sort the identifiers lexicographically before getting them references so
        // that their order is stable.
        std.sort(IIs.begin(), IIs.end(), new less_ptr<IdentifierInfo>());
        for (/*const*/ IdentifierInfo /*P*/ II : IIs)  {
          if (Trait.isInterestingNonMacroIdentifier(II)) {
            getIdentifierRef(II);
          }
        }
        
        // Create the on-disk hash table representation. We only store offsets
        // for identifiers that appear here for the first time.
        IdentifierOffsets.resize(NextIdentID - FirstIdentID);
        for (std.pairTypeUInt</*const*/ IdentifierInfo /*P*/ > IdentIDPair : IdentifierIDs) {
          IdentifierInfo /*P*/ II = ((/*const_cast*/IdentifierInfo /*P*/ )(IdentIDPair.first));
          /*uint32_t*/int ID = IdentIDPair.second;
          assert ((II != null)) : "NULL identifier in identifier table";
          // Write out identifiers if either the ID is local or the identifier has
          // changed since it was loaded.
          if ($greatereq_uint(ID, FirstIdentID) || !(Chain != null) || !II.isFromAST()
             || II.hasChangedSinceDeserialization()
             || (Trait.needDecls()
             && II.hasFETokenInfoChangedSinceDeserialization())) {
            Generator.insert(II, ID, Trait);
          }
        }
        
        // Create the on-disk hash table in a buffer.
        SmallString/*<4096>*/ IdentifierTable/*J*/= new SmallString/*<4096>*/(4096);
        /*uint32_t*/int BucketOffset;
        {
          raw_svector_ostream Out = null;
          try {
            //JAVA: using namespace llvm::support;
            Out/*J*/= new raw_svector_ostream(IdentifierTable);
            // Make sure that no bucket is at offset 0
            new Writer(little, Out).write_uint32(0);
            BucketOffset = Generator.Emit(Out, Trait);
          } finally {
            if (Out != null) { Out.$destroy(); }
          }
        }
        
        // Create a blob abbreviation
        BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
        Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.IDENTIFIER_TABLE));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
        /*uint*/int IDTableAbbrev = Stream.EmitAbbrev(Abbrev);
        
        // Write the identifier table
        long Record[/*2*/] = new /*ullong*/long [/*2*/] {ASTRecordTypes.IDENTIFIER_TABLE, BucketOffset};
        Stream.EmitRecordWithBlob(IDTableAbbrev, Record, IdentifierTable.$StringRef());
      } finally {
        if (Generator != null) { Generator.$destroy(); }
      }
    }
    
    // Write the offsets table for identifier IDs.
    BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.IDENTIFIER_OFFSET));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // # of identifiers
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32))); // first ID
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    /*uint*/int IdentifierOffsetAbbrev = Stream.EmitAbbrev(Abbrev);
    for (/*uint*/int I = 0, N = IdentifierOffsets.size(); I != N; ++I)  {
      assert ((IdentifierOffsets.$at(I) != 0)) : "Missing identifier offset?";
    }
    
    long Record[/*3*/] = new /*ullong*/long [/*3*/] {
      ASTRecordTypes.IDENTIFIER_OFFSET, 
      IdentifierOffsets.size(), 
      FirstIdentID - NUM_PREDEF_IDENT_IDS};
    Stream.EmitRecordWithBlob(IdentifierOffsetAbbrev, Record, 
        bytes(IdentifierOffsets));
    
    // In C++, write the list of interesting identifiers (those that are
    // defined as macros, poisoned, or similar unusual things).
    if (!InterestingIdents.empty()) {
      Stream.EmitRecord(ASTRecordTypes.INTERESTING_IDENTIFIERS, InterestingIdents);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteDeclUpdatesBlocks">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4642,
   FQN="clang::ASTWriter::WriteDeclUpdatesBlocks", NM="_ZN5clang9ASTWriter22WriteDeclUpdatesBlocksERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter22WriteDeclUpdatesBlocksERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  private void WriteDeclUpdatesBlocks(final SmallVectorImplULong /*&*/ OffsetsRecord) {
    MapVectorPtrType</*const*/ Decl /*P*/ , SmallVector<DeclUpdate> > LocalUpdates = null;
    try {
      if (DeclUpdates.empty()) {
        return;
      }
      
      LocalUpdates/*J*/= new MapVectorPtrType</*const*/ Decl /*P*/ , SmallVector<DeclUpdate> >(DenseMapInfo$LikePtr.$Info(), new SmallVector<DeclUpdate>(1, new DeclUpdate()));
      LocalUpdates.swap(DeclUpdates);
      
      for (final std.pair</*const*/ Decl /*P*/ , SmallVector<DeclUpdate>> /*&*/ DeclUpdate : LocalUpdates) {
        ASTRecordWriter Record = null;
        try {
          /*const*/ Decl /*P*/ D = DeclUpdate.first;
          
          boolean HasUpdatedBody = false;
          SmallVectorULong RecordData/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          Record/*J*/= new ASTRecordWriter(/*Deref*/this, RecordData);
          for (final DeclUpdate /*&*/ Update : DeclUpdate.second) {
            /*DeclUpdateKind*/int Kind = Update.getKind();
            
            // An updated body is emitted last, so that the reader doesn't need
            // to skip over the lazy body to reach statements for other records.
            if (Kind == DeclUpdateKind.UPD_CXX_ADDED_FUNCTION_DEFINITION) {
              HasUpdatedBody = true;
            } else {
              Record.push_back(Kind);
            }
            switch (Kind) {
             case DeclUpdateKind.UPD_CXX_ADDED_IMPLICIT_MEMBER:
             case DeclUpdateKind.UPD_CXX_ADDED_TEMPLATE_SPECIALIZATION:
             case DeclUpdateKind.UPD_CXX_ADDED_ANONYMOUS_NAMESPACE:
              assert ((Update.getDecl() != null)) : "no decl to add?";
              Record.push_back($uint2ulong(GetDeclRef(Update.getDecl())));
              break;
             case DeclUpdateKind.UPD_CXX_ADDED_FUNCTION_DEFINITION:
              break;
             case DeclUpdateKind.UPD_CXX_INSTANTIATED_STATIC_DATA_MEMBER:
              Record.AddSourceLocation(Update.getLoc());
              break;
             case DeclUpdateKind.UPD_CXX_INSTANTIATED_DEFAULT_ARGUMENT:
              Record.AddStmt(((/*const_cast*/Expr /*P*/ )(cast_ParmVarDecl(Update.getDecl()).getDefaultArg$Const())));
              break;
             case DeclUpdateKind.UPD_CXX_INSTANTIATED_CLASS_DEFINITION:
              {
                /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(D);
                UpdatedDeclContexts.insert(RD.getPrimaryContext$Const());
                Record.AddCXXDefinitionData(RD);
                Record.AddOffset(WriteDeclContextLexicalBlock($Deref(Context), ((/*const_cast*/CXXRecordDecl /*P*/ )(RD))));
                {
                  
                  // This state is sometimes updated by template instantiation, when we
                  // switch from the specialization referring to the template declaration
                  // to it referring to the template definition.
                  MemberSpecializationInfo /*P*/ MSInfo = RD.getMemberSpecializationInfo();
                  if ((MSInfo != null)) {
                    Record.push_back(MSInfo.getTemplateSpecializationKind().getValue());
                    Record.AddSourceLocation(MSInfo.getPointOfInstantiation());
                  } else {
                    /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = cast_ClassTemplateSpecializationDecl(RD);
                    Record.push_back(Spec.getTemplateSpecializationKind().getValue());
                    Record.AddSourceLocation(Spec.getPointOfInstantiation());
                    
                    // The instantiation might have been resolved to a partial
                    // specialization. If so, record which one.
                    PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > From = Spec.getInstantiatedFrom();
                    {
                      ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec = From.dyn_cast(ClassTemplatePartialSpecializationDecl /*P*/.class);
                      if ((PartialSpec != null)) {
                        Record.push_back(/*true*/1);
                        Record.AddDeclRef(PartialSpec);
                        Record.AddTemplateArgumentList($AddrOf(Spec.getTemplateInstantiationArgs()));
                      } else {
                        Record.push_back(/*false*/0);
                      }
                    }
                  }
                }
                Record.push_back(RD.getTagKind().getValue());
                Record.AddSourceLocation(RD.getLocation());
                Record.AddSourceLocation(RD.getLocStart());
                Record.AddSourceRange(RD.getBraceRange());
                
                // Instantiation may change attributes; write them all out afresh.
                Record.push_back((D.hasAttrs() ? 1 : 0));
                if (D.hasAttrs()) {
                  Record.AddAttributes(new ArrayRef</*const*/ Attr /*P*/ >(JD$Convertible.INSTANCE, D.getAttrs$Const(), true));
                }
                
                // FIXME: Ensure we don't get here for explicit instantiations.
                break;
              }
             case DeclUpdateKind.UPD_CXX_RESOLVED_DTOR_DELETE:
              Record.AddDeclRef(Update.getDecl());
              break;
             case DeclUpdateKind.UPD_CXX_RESOLVED_EXCEPTION_SPEC:
              addExceptionSpec(cast_FunctionDecl(D).getType().$arrow().castAs(FunctionProtoType.class), 
                  Record);
              break;
             case DeclUpdateKind.UPD_CXX_DEDUCED_RETURN_TYPE:
              Record.push_back($uint2ulong(GetOrCreateTypeID(Update.getType())));
              break;
             case DeclUpdateKind.UPD_DECL_MARKED_USED:
              break;
             case DeclUpdateKind.UPD_MANGLING_NUMBER:
             case DeclUpdateKind.UPD_STATIC_LOCAL_NUMBER:
              Record.push_back($uint2ulong(Update.getNumber()));
              break;
             case DeclUpdateKind.UPD_DECL_MARKED_OPENMP_THREADPRIVATE:
              Record.AddSourceRange(D.getAttr(OMPThreadPrivateDeclAttr.class).getRange());
              break;
             case DeclUpdateKind.UPD_DECL_MARKED_OPENMP_DECLARETARGET:
              Record.AddSourceRange(D.getAttr(OMPDeclareTargetDeclAttr.class).getRange());
              break;
             case DeclUpdateKind.UPD_DECL_EXPORTED:
              Record.push_back($uint2ulong(getSubmoduleID(Update.getModule())));
              break;
             case DeclUpdateKind.UPD_ADDED_ATTR_TO_RECORD:
              Record.AddAttributes(llvm.makeArrayRef(Update.getAttr()));
              break;
            }
          }
          if (HasUpdatedBody) {
            /*const*/ FunctionDecl /*P*/ Def = cast_FunctionDecl(D);
            Record.push_back(DeclUpdateKind.UPD_CXX_ADDED_FUNCTION_DEFINITION);
            Record.push_back((Def.isInlined() ? 1 : 0));
            Record.AddSourceLocation(Def.getInnerLocStart());
            Record.AddFunctionDefinition(Def);
          }
          
          OffsetsRecord.push_back($uint2ullong(GetDeclRef(D)));
          OffsetsRecord.push_back(Record.Emit(DECL_UPDATES));
        } finally {
          if (Record != null) { Record.$destroy(); }
        }
      }
    } finally {
      if (LocalUpdates != null) { LocalUpdates.$destroy(); }
    }
  }

  
  /// \brief Write an UPDATE_VISIBLE block for the given context.
  ///
  /// UPDATE_VISIBLE blocks contain the declarations that are added to an existing
  /// DeclContext in a dependent AST file. As such, they only exist for the TU
  /// (in C++), for namespaces, and for classes with forward-declared unscoped
  /// enumeration members (in C++11).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteDeclContextVisibleUpdate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3801,
   FQN="clang::ASTWriter::WriteDeclContextVisibleUpdate", NM="_ZN5clang9ASTWriter29WriteDeclContextVisibleUpdateEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter29WriteDeclContextVisibleUpdateEPKNS_11DeclContextE")
  //</editor-fold>
  private void WriteDeclContextVisibleUpdate(/*const*/ DeclContext /*P*/ DC) {
    StoredDeclsMap /*P*/ Map = DC.getLookupPtr();
    if (!(Map != null) || Map.empty()) {
      return;
    }
    
    // Create the on-disk hash table in a buffer.
    SmallString/*<4096>*/ LookupTable/*J*/= new SmallString/*<4096>*/(4096);
    GenerateNameLookupTable(DC, LookupTable);
    
    // If we're updating a namespace, select a key declaration as the key for the
    // update record; those are the only ones that will be checked on reload.
    if (isa_NamespaceDecl(DC)) {
      DC = cast_DeclContext(Chain.getKeyDeclaration_Decl$C$P(cast_Decl(DC)));
    }
    
    // Write the lookup table
    long Record[/*2*/] = new /*ullong*/long [/*2*/] {ASTRecordTypes.UPDATE_VISIBLE, getDeclID(cast_Decl(DC))};
    Stream.EmitRecordWithBlob(UpdateVisibleAbbrev, Record, LookupTable.$StringRef());
  }

  
  /// \brief Write an FP_PRAGMA_OPTIONS block for the given FPOptions.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteFPPragmaOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3821,
   FQN="clang::ASTWriter::WriteFPPragmaOptions", NM="_ZN5clang9ASTWriter20WriteFPPragmaOptionsERKNS_9FPOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter20WriteFPPragmaOptionsERKNS_9FPOptionsE")
  //</editor-fold>
  private void WriteFPPragmaOptions(final /*const*/ FPOptions /*&*/ Opts) {
    long Record[/*1*/] = new /*ullong*/long [/*1*/] {$uint2ullong(Opts.fp_contract)};
    Stream.EmitRecord(ASTRecordTypes.FP_PRAGMA_OPTIONS, new ArrayRefULong(Record));
  }

  
  /// \brief Write an OPENCL_EXTENSIONS block for the given OpenCLOptions.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteOpenCLExtensions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3827,
   FQN="clang::ASTWriter::WriteOpenCLExtensions", NM="_ZN5clang9ASTWriter21WriteOpenCLExtensionsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter21WriteOpenCLExtensionsERNS_4SemaE")
  //</editor-fold>
  private void WriteOpenCLExtensions(final Sema /*&*/ SemaRef) {
    if (!SemaRef.Context.getLangOpts().OpenCL) {
      return;
    }
    
    final /*const*/ OpenCLOptions /*&*/ Opts = SemaRef.getOpenCLOptions();
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    // OPENCLEXT_INTERNAL
    
    // OpenCL 1.0.
    Record.push_back($uint2ullong(Opts.cl_khr_3d_image_writes));
    // fprounding mode is special since it is not mentioned beyond 1.0
    Record.push_back($uint2ullong(Opts.cl_khr_select_fprounding_mode));
    Record.push_back($uint2ullong(Opts.cl_khr_byte_addressable_store));
    Record.push_back($uint2ullong(Opts.cl_khr_fp16));
    Record.push_back($uint2ullong(Opts.cl_khr_fp64));
    Record.push_back($uint2ullong(Opts.cl_khr_global_int32_base_atomics));
    Record.push_back($uint2ullong(Opts.cl_khr_global_int32_extended_atomics));
    Record.push_back($uint2ullong(Opts.cl_khr_local_int32_base_atomics));
    Record.push_back($uint2ullong(Opts.cl_khr_local_int32_extended_atomics));
    Record.push_back($uint2ullong(Opts.cl_khr_int64_base_atomics));
    Record.push_back($uint2ullong(Opts.cl_khr_int64_extended_atomics));
    Record.push_back($uint2ullong(Opts.cl_khr_gl_sharing));
    Record.push_back($uint2ullong(Opts.cl_khr_icd));
    
    // OpenCL 1.1.
    Record.push_back($uint2ullong(Opts.cl_khr_gl_event));
    Record.push_back($uint2ullong(Opts.cl_khr_d3d10_sharing));
    
    // OpenCL 1.2.
    Record.push_back($uint2ullong(Opts.cl_khr_context_abort));
    Record.push_back($uint2ullong(Opts.cl_khr_d3d11_sharing));
    Record.push_back($uint2ullong(Opts.cl_khr_depth_images));
    Record.push_back($uint2ullong(Opts.cl_khr_dx9_media_sharing));
    Record.push_back($uint2ullong(Opts.cl_khr_image2d_from_buffer));
    Record.push_back($uint2ullong(Opts.cl_khr_initialize_memory));
    Record.push_back($uint2ullong(Opts.cl_khr_gl_depth_images));
    Record.push_back($uint2ullong(Opts.cl_khr_gl_msaa_sharing));
    Record.push_back($uint2ullong(Opts.cl_khr_spir));
    
    // OpenCL 2.0.
    Record.push_back($uint2ullong(Opts.cl_khr_egl_event));
    Record.push_back($uint2ullong(Opts.cl_khr_egl_image));
    Record.push_back($uint2ullong(Opts.cl_khr_srgb_image_writes));
    Record.push_back($uint2ullong(Opts.cl_khr_subgroups));
    Record.push_back($uint2ullong(Opts.cl_khr_terminate_context));
    
    // Clang Extensions.
    Record.push_back($uint2ullong(Opts.cl_clang_storage_class_specifiers));
    Stream.EmitRecord(ASTRecordTypes.OPENCL_EXTENSIONS, Record);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteObjCCategories">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3838,
   FQN="clang::ASTWriter::WriteObjCCategories", NM="_ZN5clang9ASTWriter19WriteObjCCategoriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19WriteObjCCategoriesEv")
  //</editor-fold>
  private void WriteObjCCategories() {
    SmallVector<ObjCCategoriesInfo> CategoriesMap/*J*/= new SmallVector<ObjCCategoriesInfo>(2, new ObjCCategoriesInfo());
    SmallVectorULong Categories/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    
    for (/*uint*/int I = 0, N = ObjCClassesWithCategories.size(); I != N; ++I) {
      /*uint*/int Size = 0;
      /*uint*/int StartIndex = Categories.size();
      
      ObjCInterfaceDecl /*P*/ Class = ObjCClassesWithCategories.$at(I);
      
      // Allocate space for the size.
      Categories.push_back($int2ullong(0));
      
      // Add the categories.
      for (ObjCInterfaceDecl.filtered_category_iterator Cat = Class.known_categories_begin(), 
          CatEnd = Class.known_categories_end();
           ObjCInterfaceDecl.filtered_category_iterator.$noteq_filtered_category_iterator$Filter(/*NO_COPY*/Cat, /*NO_COPY*/CatEnd); Cat.$preInc() , ++Size) {
        assert (getDeclID(Cat.$star()) != 0) : "Bogus category";
        AddDeclRef(Cat.$star(), Categories);
      }
      
      // Update the size.
      Categories.$set(StartIndex, $uint2ullong(Size));
      
      // Record this interface -> category map.
      ObjCCategoriesInfo CatInfo = new ObjCCategoriesInfo(getDeclID(Class), StartIndex);
      CategoriesMap.push_back(CatInfo);
    }
    
    // Sort the categories map by the definition ID, since the reader will be
    // performing binary searches on this information.
    llvm.array_pod_sort(CategoriesMap.begin(), CategoriesMap.end());
    
    // Emit the categories map.
    //JAVA: using namespace llvm;
    
    BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.OBJC_CATEGORIES_MAP));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // # of entries
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    /*uint*/int AbbrevID = Stream.EmitAbbrev(Abbrev);
    
    long Record[/*2*/] = new /*ullong*/long [/*2*/] {ASTRecordTypes.OBJC_CATEGORIES_MAP, CategoriesMap.size()};
    Stream.EmitRecordWithBlob(AbbrevID, Record, 
        reinterpret_cast(char$ptr/*char P*/ .class, CategoriesMap.data(), ObjCCategoriesInfo.$sizeof_ObjCCategoriesInfo(), ObjCCategoriesInfo::get$Char$At$Index), 
        CategoriesMap.size() * ObjCCategoriesInfo.$sizeof_ObjCCategoriesInfo());
    
    // Emit the category lists.
    Stream.EmitRecord(ASTRecordTypes.OBJC_CATEGORIES, Categories);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteLateParsedTemplates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3890,
   FQN="clang::ASTWriter::WriteLateParsedTemplates", NM="_ZN5clang9ASTWriter24WriteLateParsedTemplatesERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter24WriteLateParsedTemplatesERNS_4SemaE")
  //</editor-fold>
  private void WriteLateParsedTemplates(final Sema /*&*/ SemaRef) {
    final MapVectorPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ > /*&*/ LPTMap = SemaRef.LateParsedTemplateMap;
    if (LPTMap.empty()) {
      return;
    }
    
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (std.pair</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ > LPTMapEntry : LPTMap) {
      /*const*/ FunctionDecl /*P*/ FD = LPTMapEntry.first;
      LateParsedTemplate /*P*/ LPT = LPTMapEntry.second;
      AddDeclRef(FD, Record);
      AddDeclRef(LPT.D, Record);
      Record.push_back($uint2ullong(LPT.Toks.size()));
      
      for (final /*const*/ Token /*&*/ Tok : LPT.Toks) {
        AddToken(Tok, Record);
      }
    }
    Stream.EmitRecord(ASTRecordTypes.LATE_PARSED_TEMPLATE, Record);
  }

  
  /// \brief Write the state of 'pragma clang optimize' at the end of the module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteOptimizePragmaOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3912,
   FQN="clang::ASTWriter::WriteOptimizePragmaOptions", NM="_ZN5clang9ASTWriter26WriteOptimizePragmaOptionsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter26WriteOptimizePragmaOptionsERNS_4SemaE")
  //</editor-fold>
  private void WriteOptimizePragmaOptions(final Sema /*&*/ SemaRef) {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    SourceLocation PragmaLoc = SemaRef.getOptimizeOffPragmaLocation();
    AddSourceLocation(new SourceLocation(PragmaLoc), Record);
    Stream.EmitRecord(ASTRecordTypes.OPTIMIZE_PRAGMA_OPTIONS, Record);
  }

  
  /// \brief Write the state of 'pragma ms_struct' at the end of the module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteMSStructPragmaOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3920,
   FQN="clang::ASTWriter::WriteMSStructPragmaOptions", NM="_ZN5clang9ASTWriter26WriteMSStructPragmaOptionsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter26WriteMSStructPragmaOptionsERNS_4SemaE")
  //</editor-fold>
  private void WriteMSStructPragmaOptions(final Sema /*&*/ SemaRef) {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    Record.push_back((SemaRef.MSStructPragmaOn ? PragmaMSStructKind.PMSST_ON : PragmaMSStructKind.PMSST_OFF).getValue());
    Stream.EmitRecord(ASTRecordTypes.MSSTRUCT_PRAGMA_OPTIONS, Record);
  }

  
  /// \brief Write the state of 'pragma pointers_to_members' at the end of the
  //module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteMSPointersToMembersPragmaOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3928,
   FQN="clang::ASTWriter::WriteMSPointersToMembersPragmaOptions", NM="_ZN5clang9ASTWriter37WriteMSPointersToMembersPragmaOptionsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter37WriteMSPointersToMembersPragmaOptionsERNS_4SemaE")
  //</editor-fold>
  private void WriteMSPointersToMembersPragmaOptions(final Sema /*&*/ SemaRef) {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    Record.push_back(SemaRef.MSPointerToMemberRepresentationMethod.getValue());
    AddSourceLocation(new SourceLocation(SemaRef.ImplicitMSInheritanceAttrLoc), Record);
    Stream.EmitRecord(ASTRecordTypes.POINTERS_TO_MEMBERS_PRAGMA_OPTIONS, Record);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3935,
   FQN="clang::ASTWriter::WriteModuleFileExtension", NM="_ZN5clang9ASTWriter24WriteModuleFileExtensionERNS_4SemaERNS_25ModuleFileExtensionWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter24WriteModuleFileExtensionERNS_4SemaERNS_25ModuleFileExtensionWriterE")
  //</editor-fold>
  private void WriteModuleFileExtension(final Sema /*&*/ SemaRef, 
                          final ModuleFileExtensionWriter /*&*/ Writer) {
    ModuleFileExtensionMetadata Metadata = null;
    try {
      // Enter the extension block.
      Stream.EnterSubblock(BlockIDs.EXTENSION_BLOCK_ID, 4);
      
      // Emit the metadata record abbreviation.
      BitCodeAbbrev /*P*/ Abv = new BitCodeAbbrev();
      Abv.Add(new BitCodeAbbrevOp(ExtensionBlockRecordTypes.EXTENSION_METADATA));
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
      /*uint*/int Abbrev = Stream.EmitAbbrev(Abv);
      
      // Emit the metadata record.
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      Metadata = Writer.getExtension().getExtensionMetadata();
      Record.push_back(ExtensionBlockRecordTypes.EXTENSION_METADATA);
      Record.push_back($uint2ullong(Metadata.MajorVersion));
      Record.push_back($uint2ullong(Metadata.MinorVersion));
      Record.push_back($uint2ullong(Metadata.BlockName.size()));
      Record.push_back($uint2ullong(Metadata.UserInfo.size()));
      SmallString/*<64>*/ Buffer/*J*/= new SmallString/*<64>*/(64);
      Buffer.$addassign(new StringRef(Metadata.BlockName));
      Buffer.$addassign(new StringRef(Metadata.UserInfo));
      Stream.EmitRecordWithBlob(Abbrev, Record, Buffer.$StringRef());
      
      // Emit the contents of the extension block.
      Writer.writeExtensionContents(SemaRef, Stream);
      
      // Exit the extension block.
      Stream.ExitBlock();
    } finally {
      if (Metadata != null) { Metadata.$destroy(); }
    }
  }

  
  private /*uint*/int DeclParmVarAbbrev;
  private /*uint*/int DeclContextLexicalAbbrev;
  private /*uint*/int DeclContextVisibleLookupAbbrev;
  private /*uint*/int UpdateVisibleAbbrev;
  private /*uint*/int DeclRecordAbbrev;
  private /*uint*/int DeclTypedefAbbrev;
  private /*uint*/int DeclVarAbbrev;
  private /*uint*/int DeclFieldAbbrev;
  private /*uint*/int DeclEnumAbbrev;
  private /*uint*/int DeclObjCIvarAbbrev;
  private /*uint*/int DeclCXXMethodAbbrev;
  
  private /*uint*/int DeclRefExprAbbrev;
  private /*uint*/int CharacterLiteralAbbrev;
  private /*uint*/int IntegerLiteralAbbrev;
  private /*uint*/int ExprImplicitCastAbbrev;
  
  //===----------------------------------------------------------------------===//
  // ASTWriter Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteDeclAbbrevs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1666,
   FQN="clang::ASTWriter::WriteDeclAbbrevs", NM="_ZN5clang9ASTWriter16WriteDeclAbbrevsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang9ASTWriter16WriteDeclAbbrevsEv")
  //</editor-fold>
  private void WriteDeclAbbrevs() {
    //JAVA: using namespace llvm;
    
    BitCodeAbbrev /*P*/ Abv;
    
    // Abbreviation for DECL_FIELD
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_FIELD));
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isUsed
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // ValueDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    // DeclaratorDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // InnerStartLoc
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // hasExtInfo
    // FieldDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isMutable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); //getBitWidth
    // Type Source Info
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // TypeLoc
    DeclFieldAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_OBJC_IVAR
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_OBJC_IVAR));
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isUsed
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // ValueDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    // DeclaratorDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // InnerStartLoc
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // hasExtInfo
    // FieldDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isMutable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); //getBitWidth
    // ObjC Ivar
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getAccessControl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getSynthesize
    // Type Source Info
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // TypeLoc
    DeclObjCIvarAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_ENUM
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_ENUM));
    // Redeclarable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // No redeclaration
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isUsed
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(AccessSpecifier.AS_none.getValue())); // C++ AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // TypeDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Source Location
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type Ref
    // TagDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // IdentifierNamespace
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getTagKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isCompleteDefinition
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // EmbeddedInDeclarator
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsFreeStanding
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsCompleteDefinitionRequired
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SourceLocation
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SourceLocation
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ExtInfoKind
    // EnumDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // AddTypeRef
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // IntegerType
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getPromotionType
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getNumPositiveBits
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getNumNegativeBits
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isScoped
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isScopedUsingClassTag
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isFixed
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // InstantiatedMembEnum
    // DC
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // LexicalOffset
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // VisibleOffset
    DeclEnumAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_RECORD
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_RECORD));
    // Redeclarable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // No redeclaration
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isUsed
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(AccessSpecifier.AS_none.getValue())); // C++ AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // TypeDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Source Location
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type Ref
    // TagDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // IdentifierNamespace
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getTagKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isCompleteDefinition
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // EmbeddedInDeclarator
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsFreeStanding
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsCompleteDefinitionRequired
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SourceLocation
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SourceLocation
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ExtInfoKind
    // RecordDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // FlexibleArrayMember
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // AnonymousStructUnion
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // hasObjectMember
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // hasVolatileMember
    // DC
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // LexicalOffset
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // VisibleOffset
    DeclRecordAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_PARM_VAR
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_PARM_VAR));
    // Redeclarable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // No redeclaration
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isUsed
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(AccessSpecifier.AS_none.getValue())); // C++ AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // ValueDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    // DeclaratorDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // InnerStartLoc
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // hasExtInfo
    // VarDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // StorageClass
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // getTSCSpec
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // hasCXXDirectInitializer
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // Linkage
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasInit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasMemberSpecializationInfo
    // ParmVarDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // IsObjCMethodParameter
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ScopeDepth
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // ScopeIndex
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ObjCDeclQualifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // KNRPromoted
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasInheritedDefaultArg
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasUninstantiatedDefaultArg
    // Type Source Info
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // TypeLoc
    DeclParmVarAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_TYPEDEF
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_TYPEDEF));
    // Redeclarable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // No redeclaration
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isUsed
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // C++ AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // TypeDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Source Location
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type Ref
    // TypedefDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // TypeLoc
    DeclTypedefAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_VAR
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_VAR));
    // Redeclarable
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // No redeclaration
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInvalidDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isImplicit
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isUsed
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isReferenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // TopLevelDeclInObjCContainer
    Abv.Add(new BitCodeAbbrevOp(AccessSpecifier.AS_none.getValue())); // C++ AccessSpecifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // NameKind = Identifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Name
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // ValueDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    // DeclaratorDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // InnerStartLoc
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // hasExtInfo
    // VarDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // StorageClass
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // getTSCSpec
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // CXXDirectInitializer
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isExceptionVariable
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isNRVOVariable
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isCXXForRangeDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // isARCPseudoStrong
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInline
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInlineSpecified
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isConstexpr
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isInitCapture
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // isPrevDeclInSameScope
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); // Linkage
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // HasInit
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // HasMemberSpecInfo
    // Type Source Info
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // TypeLoc
    DeclVarAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for DECL_CXX_METHOD
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_CXX_METHOD));
    // RedeclarableDecl
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // CanonicalDecl
    // Decl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // LexicalDeclContext
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // Invalid
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasAttrs
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Implicit
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Used
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Referenced
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // InObjCContainer
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // Access
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // ModulePrivate
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // SubmoduleID
    // NamedDecl
    Abv.Add(new BitCodeAbbrevOp(DeclarationName.NameKind.Identifier.getValue())); // NameKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Identifier
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // AnonDeclNumber
    // ValueDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    // DeclaratorDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // InnerLocStart
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasExtInfo
    // FunctionDecl
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(11))); // IDNS
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); // StorageClass
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Inline
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // InlineSpecified
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // VirtualAsWritten
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Pure
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // HasInheritedProto
    Abv.Add(new BitCodeAbbrevOp($int2ulong(1))); // HasWrittenProto
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Deleted
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Trivial
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Defaulted
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // ExplicitlyDefaulted
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // ImplicitReturnZero
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Constexpr
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // SkippedBody
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // LateParsed
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); // Linkage
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // LocEnd
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); // TemplateKind
    // This Array slurps the rest of the record. Fortunately we want to encode
    // (nearly) all the remaining (variable number of) fields in the same way.
    //
    // This is the function template information if any, then
    //         NumParams and Params[] from FunctionDecl, and
    //         NumOverriddenMethods, OverriddenMethods[] from CXXMethodDecl.
    //
    //  Add an AbbrevOp for 'size then elements' and use it here.
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Array));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
    DeclCXXMethodAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for EXPR_DECL_REF
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(StmtCode.EXPR_DECL_REF));
    //Stmt
    //Expr
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //TypeDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //ValueDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //InstantiationDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //UnexpandedParamPack
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetValueKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetObjectKind
    //DeclRefExpr
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //HasQualifier
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //GetDeclFound
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //ExplicitTemplateArgs
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //HadMultipleCandidates
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 
            $int2ulong(1))); // RefersToEnclosingVariableOrCapture
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // DeclRef
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Location
    DeclRefExprAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for EXPR_INTEGER_LITERAL
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(StmtCode.EXPR_INTEGER_LITERAL));
    //Stmt
    //Expr
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //TypeDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //ValueDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //InstantiationDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //UnexpandedParamPack
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetValueKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetObjectKind
    //Integer Literal
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Location
    Abv.Add(new BitCodeAbbrevOp($int2ulong(32))); // Bit Width
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Value
    IntegerLiteralAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for EXPR_CHARACTER_LITERAL
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(StmtCode.EXPR_CHARACTER_LITERAL));
    //Stmt
    //Expr
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //TypeDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //ValueDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //InstantiationDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //UnexpandedParamPack
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetValueKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetObjectKind
    //Character Literal
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // getValue
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Location
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); // getKind
    CharacterLiteralAbbrev = Stream.EmitAbbrev(Abv);
    
    // Abbreviation for EXPR_IMPLICIT_CAST
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(StmtCode.EXPR_IMPLICIT_CAST));
    // Stmt
    // Expr
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Type
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //TypeDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //ValueDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //InstantiationDependent
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); //UnexpandedParamPack
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetValueKind
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(3))); //GetObjectKind
    // CastExpr
    Abv.Add(new BitCodeAbbrevOp($int2ulong(0))); // PathSize
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(6))); // CastKind
    // ImplicitCastExpr
    ExprImplicitCastAbbrev = Stream.EmitAbbrev(Abv);
    
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_CONTEXT_LEXICAL));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    DeclContextLexicalAbbrev = Stream.EmitAbbrev(Abv);
    
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(DeclCode.DECL_CONTEXT_VISIBLE));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    DeclContextVisibleLookupAbbrev = Stream.EmitAbbrev(Abv);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 2135,
   FQN="clang::ASTWriter::WriteDecl", NM="_ZN5clang9ASTWriter9WriteDeclERNS_10ASTContextEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang9ASTWriter9WriteDeclERNS_10ASTContextEPNS_4DeclE")
  //</editor-fold>
  private void WriteDecl(final ASTContext /*&*/ Context, Decl /*P*/ D) {
    ASTDeclWriter W = null;
    try {
      // Determine the ID for this declaration.
      /*uint32_t*/int ID;
      assert (!D.isFromASTFile()) : "should not be emitting imported decl";
      final /*uint32_t &*/uint$ref IDR = DeclIDs.ref$at(D);
      if (IDR.$deref() == 0) {
        IDR.$set(NextDeclID++);
      }
      
      ID = IDR.$deref();
      assert ($greatereq_uint(ID, FirstDeclID)) : "invalid decl ID";
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      W/*J*/= new ASTDeclWriter(/*Deref*/this, Context, Record);
      
      // Build a record for this declaration
      W.Visit(D);
      
      // Emit this declaration to the bitstream.
      long/*uint64_t*/ Offset = W.Emit(D);
      
      // Record the offset for this declaration
      SourceLocation Loc = D.getLocation();
      /*uint*/int Index = ID - FirstDeclID;
      if (DeclOffsets.size() == Index) {
        DeclOffsets.push_back_T$RR(new DeclOffset(new SourceLocation(Loc), $ulong2uint(Offset)));
      } else if ($less_uint(DeclOffsets.size(), Index)) {
        // FIXME: Can/should this happen?
        DeclOffsets.resize(Index + 1);
        DeclOffsets.$at(Index).setLocation(new SourceLocation(Loc));
        DeclOffsets.$at(Index).BitOffset = $ulong2uint(Offset);
      } else {
        throw new llvm_unreachable("declarations should be emitted in ID order");
      }
      
      final SourceManager /*&*/ SM = Context.getSourceManager();
      if (Loc.isValid() && SM.isLocalSourceLocation(/*NO_COPY*/Loc)) {
        associateDeclWithFile(D, ID);
      }
      
      // Note declarations that should be deserialized eagerly so that we can add
      // them to a record in the AST file later.
      if (isRequiredDecl(D, Context, (WritingModule != null))) {
        EagerlyDeserializedDecls.push_back($uint2ullong(ID));
      }
    } finally {
      if (W != null) { W.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteASTCore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4151,
   FQN="clang::ASTWriter::WriteASTCore", NM="_ZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleE")
  //</editor-fold>
  private long/*uint64_t*/ WriteASTCore(final Sema /*&*/ SemaRef, StringRef isysroot, 
              final /*const*/std.string/*&*/ OutputFile, 
              Module /*P*/ WritingModule) {
    //JAVA: using namespace llvm;
    
    boolean isModule = WritingModule != null;
    
    // Make sure that the AST reader knows to finalize itself.
    if ((Chain != null)) {
      Chain.finalizeForWriting();
    }
    
    final ASTContext /*&*/ Context = SemaRef.Context;
    final Preprocessor /*&*/ PP = SemaRef.PP;
    
    // Set up predefined declaration IDs.
    DeclPredefinedDeclIDs2Void RegisterPredefDecl = /*[&, this]*/ (Decl /*P*/ D, /*PredefinedDeclIDs*/int ID) -> {
          if ((D != null)) {
            assert (D.isCanonicalDecl()) : "predefined decl is not canonical";
            DeclIDs.$set(D, ID);
          }
        };
    RegisterPredefDecl.$call(Context.getTranslationUnitDecl(), 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_TRANSLATION_UNIT_ID
    );
    RegisterPredefDecl.$call(Context.ObjCIdDecl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_OBJC_ID_ID);
    RegisterPredefDecl.$call(Context.ObjCSelDecl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_OBJC_SEL_ID);
    RegisterPredefDecl.$call(Context.ObjCClassDecl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_OBJC_CLASS_ID);
    RegisterPredefDecl.$call(Context.ObjCProtocolClassDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_OBJC_PROTOCOL_ID
    );
    RegisterPredefDecl.$call(Context.Int128Decl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_INT_128_ID);
    RegisterPredefDecl.$call(Context.UInt128Decl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_UNSIGNED_INT_128_ID);
    RegisterPredefDecl.$call(Context.ObjCInstanceTypeDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_OBJC_INSTANCETYPE_ID
    );
    RegisterPredefDecl.$call(Context.BuiltinVaListDecl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_BUILTIN_VA_LIST_ID);
    RegisterPredefDecl.$call(Context.VaListTagDecl, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_VA_LIST_TAG);
    RegisterPredefDecl.$call(Context.BuiltinMSVaListDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_BUILTIN_MS_VA_LIST_ID
    );
    RegisterPredefDecl.$call(Context.ExternCContext, /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_EXTERN_C_CONTEXT_ID);
    RegisterPredefDecl.$call(Context.MakeIntegerSeqDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_MAKE_INTEGER_SEQ_ID
    );
    RegisterPredefDecl.$call(Context.CFConstantStringTypeDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_CF_CONSTANT_STRING_ID
    );
    RegisterPredefDecl.$call(Context.CFConstantStringTagDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_CF_CONSTANT_STRING_TAG_ID
    );
    RegisterPredefDecl.$call(Context.TypePackElementDecl, 
        /*KEEP_ENUM*/PredefinedDeclIDs.PREDEF_DECL_TYPE_PACK_ELEMENT_ID
    );
    
    // Build a record containing all of the tentative definitions in this file, in
    // TentativeDefinitions order.  Generally, this record will be empty for
    // headers.
    SmallVectorULong TentativeDefinitions/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    AddLazyVectorDecls(/*Deref*/this, SemaRef.TentativeDefinitions, TentativeDefinitions);
    
    // Build a record containing all of the file scoped decls in this file.
    SmallVectorULong UnusedFileScopedDecls/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    if (!isModule) {
      AddLazyVectorDecls(/*Deref*/this, SemaRef.UnusedFileScopedDecls, 
          UnusedFileScopedDecls);
    }
    
    // Build a record containing all of the delegating constructors we still need
    // to resolve.
    SmallVectorULong DelegatingCtorDecls/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    if (!isModule) {
      AddLazyVectorDecls(/*Deref*/this, SemaRef.DelegatingCtorDecls, DelegatingCtorDecls);
    }
    
    // Write the set of weak, undeclared identifiers. We always write the
    // entire table, since later PCH files in a PCH chain are only interested in
    // the results at the end of the chain.
    SmallVectorULong WeakUndeclaredIdentifiers/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (final std.pair<IdentifierInfo /*P*/ , WeakInfo> /*&*/ WeakUndeclaredIdentifier : SemaRef.WeakUndeclaredIdentifiers) {
      IdentifierInfo /*P*/ II = WeakUndeclaredIdentifier.first;
      final WeakInfo /*&*/ WI = WeakUndeclaredIdentifier.second;
      AddIdentifierRef(II, WeakUndeclaredIdentifiers);
      AddIdentifierRef(WI.getAlias(), WeakUndeclaredIdentifiers);
      AddSourceLocation(WI.getLocation(), WeakUndeclaredIdentifiers);
      WeakUndeclaredIdentifiers.push_back((WI.getUsed() ? 1 : 0));
    }
    
    // Build a record containing all of the ext_vector declarations.
    SmallVectorULong ExtVectorDecls/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    AddLazyVectorDecls(/*Deref*/this, SemaRef.ExtVectorDecls, ExtVectorDecls);
    
    // Build a record containing all of the VTable uses information.
    SmallVectorULong VTableUses/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    if (!SemaRef.VTableUses.empty()) {
      for (/*uint*/int I = 0, N = SemaRef.VTableUses.size(); I != N; ++I) {
        AddDeclRef(SemaRef.VTableUses.$at(I).first, VTableUses);
        AddSourceLocation(new SourceLocation(SemaRef.VTableUses.$at(I).second), VTableUses);
        VTableUses.push_back((SemaRef.VTablesUsed.$at_T1$C$R(SemaRef.VTableUses.$at(I).first) ? 1 : 0));
      }
    }
    
    // Build a record containing all of the UnusedLocalTypedefNameCandidates.
    SmallVectorULong UnusedLocalTypedefNameCandidates/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (/*const*/ TypedefNameDecl /*P*/ TD : SemaRef.UnusedLocalTypedefNameCandidates)  {
      AddDeclRef(TD, UnusedLocalTypedefNameCandidates);
    }
    
    // Build a record containing all of pending implicit instantiations.
    SmallVectorULong PendingInstantiations/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (final /*const*/std.pair<ValueDecl /*P*/ , SourceLocation> /*&*/ I : SemaRef.PendingInstantiations) {
      AddDeclRef(I.first, PendingInstantiations);
      AddSourceLocation(new SourceLocation(I.second), PendingInstantiations);
    }
    assert (SemaRef.PendingLocalImplicitInstantiations.empty()) : "There are local ones at end of translation unit!";
    
    // Build a record containing some declaration references.
    SmallVectorULong SemaDeclRefs/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    if (SemaRef.StdNamespace.$bool() || SemaRef.StdBadAlloc.$bool()) {
      AddDeclRef(SemaRef.getStdNamespace(), SemaDeclRefs);
      AddDeclRef(SemaRef.getStdBadAlloc(), SemaDeclRefs);
    }
    
    SmallVectorULong CUDASpecialDeclRefs/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    if ((Context.getcudaConfigureCallDecl() != null)) {
      AddDeclRef(Context.getcudaConfigureCallDecl(), CUDASpecialDeclRefs);
    }
    
    // Build a record containing all of the known namespaces.
    SmallVectorULong KnownNamespaces/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    for (final /*const*/pairTypeBool<NamespaceDecl> /*&*/ I : SemaRef.KnownNamespaces) {
      if (!I.second) {
        AddDeclRef(I.first, KnownNamespaces);
      }
    }
    
    // Build a record of all used, undefined objects that require definitions.
    SmallVectorULong UndefinedButUsed/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    
    SmallVector<std.pairPtrType<NamedDecl /*P*/ , SourceLocation>> Undefined/*J*/= new SmallVector<std.pairPtrType<NamedDecl /*P*/ , SourceLocation>>(16, new std.pairPtrType<NamedDecl /*P*/ , SourceLocation>());
    SemaRef.getUndefinedButUsed((SmallVectorImpl)Undefined);
    for (final /*const*/std.pairPtrType<NamedDecl /*P*/ , SourceLocation> /*&*/ I : Undefined) {
      AddDeclRef(I.first, UndefinedButUsed);
      AddSourceLocation(new SourceLocation(I.second), UndefinedButUsed);
    }
    
    // Build a record containing all delete-expressions that we would like to
    // analyze later in AST.
    SmallVectorULong DeleteExprsToAnalyze/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    
    for (final /*const*/std.pair<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>>> /*&*/ DeleteExprsInfo : SemaRef.getMismatchingDeleteExpressions()) {
      AddDeclRef(DeleteExprsInfo.first, DeleteExprsToAnalyze);
      DeleteExprsToAnalyze.push_back($uint2ullong(DeleteExprsInfo.second.size()));
      for (final /*const*/std.pairTypeBool<SourceLocation> /*&*/ DeleteLoc : DeleteExprsInfo.second) {
        AddSourceLocation(new SourceLocation(DeleteLoc.first), DeleteExprsToAnalyze);
        DeleteExprsToAnalyze.push_back((DeleteLoc.second ? 1 : 0));
      }
    }
    
    // Write the control block
    long/*uint64_t*/ Signature = WriteControlBlock(PP, Context, new StringRef(isysroot), OutputFile);
    
    // Write the remaining AST contents.
    Stream.EnterSubblock(BlockIDs.AST_BLOCK_ID, 5);
    {
      SmallVectorULong Record = /*{ */new SmallVectorULong(64, new /*const*//*ullong*/long [/*1*/] {VERSION_MAJOR}, (long/*uint64_t*/)0)/* }*/;
      Stream.EmitRecord(ASTRecordTypes.METADATA_OLD_FORMAT, Record);
    }
    
    // Create a lexical update block containing all of the declarations in the
    // translation unit that do not come from other AST files.
    /*const*/ TranslationUnitDecl /*P*/ TU = Context.getTranslationUnitDecl();
    SmallVectorUInt NewGlobalKindDeclPairs/*J*/= new SmallVectorUInt(128, (/*uint32_t*/int)0);
    for (/*const*/ Decl /*P*/ D : TU.noload_decls()) {
      if (!D.isFromASTFile()) {
        NewGlobalKindDeclPairs.push_back(D.getKind().getValue());
        NewGlobalKindDeclPairs.push_back(GetDeclRef(D));
      }
    }
    
    BitCodeAbbrev /*P*/ Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(ASTRecordTypes.TU_UPDATE_LEXICAL));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    /*uint*/int TuUpdateLexicalAbbrev = Stream.EmitAbbrev(Abv);
    {
      long Record[/*1*/] = new /*ullong*/long [/*1*/] {ASTRecordTypes.TU_UPDATE_LEXICAL};
      Stream.EmitRecordWithBlob(TuUpdateLexicalAbbrev, Record, 
          bytes(NewGlobalKindDeclPairs));
    }
    
    // And a visible updates block for the translation unit.
    Abv = new BitCodeAbbrev();
    Abv.Add(new BitCodeAbbrevOp(ASTRecordTypes.UPDATE_VISIBLE));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6)));
    Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
    UpdateVisibleAbbrev = Stream.EmitAbbrev(Abv);
    WriteDeclContextVisibleUpdate(TU);
    
    // If we have any extern "C" names, write out a visible update for them.
    if ((Context.ExternCContext != null)) {
      WriteDeclContextVisibleUpdate(Context.ExternCContext);
    }
    {
      
      // If the translation unit has an anonymous namespace, and we don't already
      // have an update block for it, write it as an update block.
      // FIXME: Why do we not do this if there's already an update block?
      NamespaceDecl /*P*/ NS = TU.getAnonymousNamespace();
      if ((NS != null)) {
        final SmallVector<DeclUpdate> /*&*/ Record = DeclUpdates.$at(TU);
        if (Record.empty()) {
          Record.push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_ADDED_ANONYMOUS_NAMESPACE, NS));
        }
      }
    }
    
    // Add update records for all mangling numbers and static local numbers.
    // These aren't really update records, but this is a convenient way of
    // tagging this rare extra data onto the declarations.
    for (final /*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*&*/ Number : Context.MangleNumbers)  {
      if (!Number.first.isFromASTFile()) {
        DeclUpdates.$at(Number.first).push_back(new DeclUpdate(DeclUpdateKind.UPD_MANGLING_NUMBER, 
                Number.second));
      }
    }
    for (final /*const*/std.pairTypeUInt</*const*/ VarDecl /*P*/ > /*&*/ Number : Context.StaticLocalNumbers)  {
      if (!Number.first.isFromASTFile()) {
        DeclUpdates.$at(Number.first).push_back(new DeclUpdate(DeclUpdateKind.UPD_STATIC_LOCAL_NUMBER, 
                Number.second));
      }
    }
    
    // Make sure visible decls, added to DeclContexts previously loaded from
    // an AST file, are registered for serialization.
    for (/*const*/ Decl /*P*/ I : UpdatingVisibleDecls) {
      GetDeclRef(I);
    }
    
    // Make sure all decls associated with an identifier are registered for
    // serialization, if we're storing decls with identifiers.
    if (!(WritingModule != null) || !getLangOpts().CPlusPlus) {
      SmallVector</*const*/ IdentifierInfo /*P*/ > IIs/*J*/= new SmallVector</*const*/ IdentifierInfo /*P*/ >(256, (/*const*/ IdentifierInfo /*P*/ )null);
      for (final /*const*/IdentifierInfoStringMapEntry/*&*/ ID : PP.getIdentifierTable()) {
        /*const*/ IdentifierInfo /*P*/ II = ID.$second();
        if (!(Chain != null) || !II.isFromAST() || II.hasChangedSinceDeserialization()) {
          IIs.push_back(II);
        }
      }
      // Sort the identifiers to visit based on their name.
      std.sort(IIs.begin(), IIs.end(), IdentifierInfo.COMPARATOR/*new less_ptr<IdentifierInfo>()*/);
      for (/*const*/ IdentifierInfo /*P*/ II : IIs) {
        for (IdentifierResolver.iterator D = SemaRef.IdResolver.begin(new DeclarationName(II)), 
            DEnd = SemaRef.IdResolver.end();
             D.$noteq(DEnd); D.$preInc()) {
          GetDeclRef(D.$star());
        }
      }
    }
    
    // For method pool in the module, if it contains an entry for a selector,
    // the entry should be complete, containing everything introduced by that
    // module and all modules it imports. It's possible that the entry is out of
    // date, so we need to pull in the new content here.
    
    // It's possible that updateOutOfDateSelector can update SelectorIDs. To be
    // safe, we copy all selectors out.
    SmallVector<Selector> AllSelectors/*J*/= new SmallVector<Selector>(256, new Selector());
    for (final std.pairTypeUInt<Selector> /*&*/ SelectorAndID : SelectorIDs)  {
      AllSelectors.push_back(SelectorAndID.first);
    }
    for (final Selector /*&*/ $Selector : AllSelectors)  {
      SemaRef.updateOutOfDateSelector(new Selector($Selector));
    }
    
    // Form the record of special types.
    SmallVectorULong SpecialTypes/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    AddTypeRef(Context.getRawCFConstantStringType(), SpecialTypes);
    AddTypeRef(Context.getFILEType(), SpecialTypes);
    AddTypeRef(Context.getjmp_bufType(), SpecialTypes);
    AddTypeRef(Context.getsigjmp_bufType(), SpecialTypes);
    AddTypeRef(new QualType(Context.ObjCIdRedefinitionType), SpecialTypes);
    AddTypeRef(new QualType(Context.ObjCClassRedefinitionType), SpecialTypes);
    AddTypeRef(new QualType(Context.ObjCSelRedefinitionType), SpecialTypes);
    AddTypeRef(Context.getucontext_tType(), SpecialTypes);
    if ((Chain != null)) {
      // Write the mapping information describing our module dependencies and how
      // each of those modules were mapped into our own offset/ID space, so that
      // the reader can build the appropriate mapping to its own offset/ID space.
      // The map consists solely of a blob with the following format:
      // *(module-name-len:i16 module-name:len*i8
      //   source-location-offset:i32
      //   identifier-id:i32
      //   preprocessed-entity-id:i32
      //   macro-definition-id:i32
      //   submodule-id:i32
      //   selector-id:i32
      //   declaration-id:i32
      //   c++-base-specifiers-id:i32
      //   type-id:i32)
      // 
      BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
      Abbrev.Add(new BitCodeAbbrevOp(ASTRecordTypes.MODULE_OFFSET_MAP));
      Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
      /*uint*/int ModuleOffsetMapAbbrev = Stream.EmitAbbrev(Abbrev);
      SmallString/*<2048>*/ Buffer/*J*/= new SmallString/*<2048>*/(2048);
      {
        raw_svector_ostream Out = null;
        try {
          Out/*J*/= new raw_svector_ostream(Buffer);
          for (ModuleFile /*P*/ M : Chain.ModuleMgr) {
            //JAVA: using namespace llvm::support;
            Writer LE/*J*/= new Writer(little, Out);
            StringRef FileName = new StringRef(M.FileName);
            LE.write_uint16($uint2ushort(FileName.size()));
            Out.write(FileName.data(), FileName.size());
            
            // Note: if a base ID was uint max, it would not be possible to load
            // another module after it or have more than one entity inside it.
            /*uint32_t*/int None = std.numeric_limitsUInt.max();
            
            UIntBool2Void writeBaseIDOrNone = /*[&, &LE, &None]*/ (/*uint32_t*/int BaseID, boolean ShouldWrite) -> {
                  assert ($less_uint(BaseID, std.numeric_limitsUInt.max())) : "base id too high";
                  if (ShouldWrite) {
                    LE.write_uint32(BaseID);
                  } else {
                    LE.write_uint32(None);
                  }
                };
            
            // These values should be unique within a chain, since they will be read
            // as keys into ContinuousRangeMaps.
            writeBaseIDOrNone.$call(M.SLocEntryBaseOffset, /*KEEP_BOOL*/M.LocalNumSLocEntries !=0);
            writeBaseIDOrNone.$call(M.BaseIdentifierID, /*KEEP_BOOL*/M.LocalNumIdentifiers !=0);
            writeBaseIDOrNone.$call(M.BaseMacroID, /*KEEP_BOOL*/M.LocalNumMacros !=0);
            writeBaseIDOrNone.$call(M.BasePreprocessedEntityID, 
                /*KEEP_BOOL*/M.NumPreprocessedEntities !=0
            );
            writeBaseIDOrNone.$call(M.BaseSubmoduleID, /*KEEP_BOOL*/M.LocalNumSubmodules !=0);
            writeBaseIDOrNone.$call(M.BaseSelectorID, /*KEEP_BOOL*/M.LocalNumSelectors !=0);
            writeBaseIDOrNone.$call(M.BaseDeclID, /*KEEP_BOOL*/M.LocalNumDecls !=0);
            writeBaseIDOrNone.$call(M.BaseTypeIndex, /*KEEP_BOOL*/M.LocalNumTypes !=0);
          }
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
      long Record[/*1*/] = new /*ullong*/long [/*1*/] {ASTRecordTypes.MODULE_OFFSET_MAP};
      Stream.EmitRecordWithBlob(ModuleOffsetMapAbbrev, Record, 
          Buffer.data(), Buffer.size());
    }
    
    SmallVectorULong DeclUpdatesOffsetsRecord/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    
    // Keep writing types, declarations, and declaration update records
    // until we've emitted all of them.
    Stream.EnterSubblock(BlockIDs.DECLTYPES_BLOCK_ID, /*bits for abbreviations*/ 5);
    WriteTypeAbbrevs();
    WriteDeclAbbrevs();
    do {
      WriteDeclUpdatesBlocks(DeclUpdatesOffsetsRecord);
      while (!DeclTypesToEmit.empty()) {
        DeclOrType DOT = new DeclOrType(DeclTypesToEmit.front());
        DeclTypesToEmit.pop();
        if (DOT.isType()) {
          WriteType(DOT.getType());
        } else {
          WriteDecl(Context, DOT.getDecl());
        }
      }
    } while (!DeclUpdates.empty());
    Stream.ExitBlock();
    
    DoneWritingDeclsAndTypes = true;
    
    // These things can only be done once we've written out decls and types.
    WriteTypeDeclOffsets();
    if (!DeclUpdatesOffsetsRecord.empty()) {
      Stream.EmitRecord(ASTRecordTypes.DECL_UPDATE_OFFSETS, DeclUpdatesOffsetsRecord);
    }
    WriteFileDeclIDsMap();
    WriteSourceManagerBlock(Context.getSourceManager(), PP);
    WriteComments();
    WritePreprocessor(PP, isModule);
    WriteHeaderSearch(PP.getHeaderSearchInfo());
    WriteSelectors(SemaRef);
    WriteReferencedSelectorsPool(SemaRef);
    WriteLateParsedTemplates(SemaRef);
    WriteIdentifierTable(PP, SemaRef.IdResolver, isModule);
    WriteFPPragmaOptions(SemaRef.getFPOptions());
    WriteOpenCLExtensions(SemaRef);
    WritePragmaDiagnosticMappings(Context.getDiagnostics(), isModule);
    
    // If we're emitting a module, write out the submodule information.  
    if ((WritingModule != null)) {
      WriteSubmodules(WritingModule);
    }
    
    Stream.EmitRecord(ASTRecordTypes.SPECIAL_TYPES, SpecialTypes);
    
    // Write the record containing external, unnamed definitions.
    if (!EagerlyDeserializedDecls.empty()) {
      Stream.EmitRecord(ASTRecordTypes.EAGERLY_DESERIALIZED_DECLS, EagerlyDeserializedDecls);
    }
    
    // Write the record containing tentative definitions.
    if (!TentativeDefinitions.empty()) {
      Stream.EmitRecord(ASTRecordTypes.TENTATIVE_DEFINITIONS, TentativeDefinitions);
    }
    
    // Write the record containing unused file scoped decls.
    if (!UnusedFileScopedDecls.empty()) {
      Stream.EmitRecord(ASTRecordTypes.UNUSED_FILESCOPED_DECLS, UnusedFileScopedDecls);
    }
    
    // Write the record containing weak undeclared identifiers.
    if (!WeakUndeclaredIdentifiers.empty()) {
      Stream.EmitRecord(ASTRecordTypes.WEAK_UNDECLARED_IDENTIFIERS, 
          WeakUndeclaredIdentifiers);
    }
    
    // Write the record containing ext_vector type names.
    if (!ExtVectorDecls.empty()) {
      Stream.EmitRecord(ASTRecordTypes.EXT_VECTOR_DECLS, ExtVectorDecls);
    }
    
    // Write the record containing VTable uses information.
    if (!VTableUses.empty()) {
      Stream.EmitRecord(ASTRecordTypes.VTABLE_USES, VTableUses);
    }
    
    // Write the record containing potentially unused local typedefs.
    if (!UnusedLocalTypedefNameCandidates.empty()) {
      Stream.EmitRecord(ASTRecordTypes.UNUSED_LOCAL_TYPEDEF_NAME_CANDIDATES, 
          UnusedLocalTypedefNameCandidates);
    }
    
    // Write the record containing pending implicit instantiations.
    if (!PendingInstantiations.empty()) {
      Stream.EmitRecord(ASTRecordTypes.PENDING_IMPLICIT_INSTANTIATIONS, PendingInstantiations);
    }
    
    // Write the record containing declaration references of Sema.
    if (!SemaDeclRefs.empty()) {
      Stream.EmitRecord(ASTRecordTypes.SEMA_DECL_REFS, SemaDeclRefs);
    }
    
    // Write the record containing CUDA-specific declaration references.
    if (!CUDASpecialDeclRefs.empty()) {
      Stream.EmitRecord(ASTRecordTypes.CUDA_SPECIAL_DECL_REFS, CUDASpecialDeclRefs);
    }
    
    // Write the delegating constructors.
    if (!DelegatingCtorDecls.empty()) {
      Stream.EmitRecord(ASTRecordTypes.DELEGATING_CTORS, DelegatingCtorDecls);
    }
    
    // Write the known namespaces.
    if (!KnownNamespaces.empty()) {
      Stream.EmitRecord(ASTRecordTypes.KNOWN_NAMESPACES, KnownNamespaces);
    }
    
    // Write the undefined internal functions and variables, and inline functions.
    if (!UndefinedButUsed.empty()) {
      Stream.EmitRecord(ASTRecordTypes.UNDEFINED_BUT_USED, UndefinedButUsed);
    }
    if (!DeleteExprsToAnalyze.empty()) {
      Stream.EmitRecord(ASTRecordTypes.DELETE_EXPRS_TO_ANALYZE, DeleteExprsToAnalyze);
    }
    
    // Write the visible updates to DeclContexts.
    for (/*const*/ DeclContext /*P*/ DC : UpdatedDeclContexts)  {
      WriteDeclContextVisibleUpdate(DC);
    }
    if (!(WritingModule != null)) {
      // Write the submodules that were imported, if any.
      //<editor-fold defaultstate="collapsed" desc="ModuleInfo">
      SmallVector<WriteASTCore$$.ModuleInfo> Imports/*J*/= new SmallVector<WriteASTCore$$.ModuleInfo>(64, new WriteASTCore$$.ModuleInfo());
      for (/*const*/ ImportDecl /*P*/ I : Context.local_imports()) {
        assert (SubmoduleIDs.find(I.getImportedModule()).$noteq(/*NO_ITER_COPY*/SubmoduleIDs.end()));
        Imports.push_back(new WriteASTCore$$.ModuleInfo($uint2ulong(SubmoduleIDs.$at_T1$RR(I.getImportedModule())), 
                I.getImportedModule()));
      }
      if (!Imports.empty()) {
        ModuleInfoModuleInfo2Bool Cmp = /*[]*/ (final /*const*/ WriteASTCore$$.ModuleInfo /*&*/ A, final /*const*/ WriteASTCore$$.ModuleInfo /*&*/ B) -> {
              return $less_ulong(A.ID, B.ID);
            };
        ModuleInfoModuleInfo2Bool Eq = /*[]*/ (final /*const*/ WriteASTCore$$.ModuleInfo /*&*/ A, final /*const*/ WriteASTCore$$.ModuleInfo /*&*/ B) -> {
              return A.ID == B.ID;
            };
        
        // Sort and deduplicate module IDs.
        std.sort(Imports.begin(), Imports.end(), (WriteASTCore$$.ModuleInfo a, WriteASTCore$$.ModuleInfo b) -> Cmp.$call(a, b));
        Imports.erase(std.unique(Imports.begin(), Imports.end(),
                (TypeType2Bool) (Object a, Object b) -> Eq.$call((WriteASTCore$$.ModuleInfo)a, (WriteASTCore$$.ModuleInfo)b),
                false), 
            Imports.end());
        
        SmallVectorULong ImportedModules/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
        for (final /*const*/ WriteASTCore$$.ModuleInfo /*&*/ Import : Imports) {
          ImportedModules.push_back(Import.ID);
          // FIXME: If the module has macros imported then later has declarations
          // imported, this location won't be the right one as a location for the
          // declaration imports.
          AddSourceLocation(PP.getModuleImportLoc(Import.M), ImportedModules);
        }
        
        Stream.EmitRecord(ASTRecordTypes.IMPORTED_MODULES, ImportedModules);
      }
    }
    
    WriteObjCCategories();
    if (!(WritingModule != null)) {
      WriteOptimizePragmaOptions(SemaRef);
      WriteMSStructPragmaOptions(SemaRef);
      WriteMSPointersToMembersPragmaOptions(SemaRef);
    }
    
    // Some simple statistics
    long Record[/*4*/] = new /*ullong*/long [/*4*/] {NumStatements, NumMacros, NumLexicalDeclContexts, NumVisibleDeclContexts};
    Stream.EmitRecord(ASTRecordTypes.STATISTICS, new ArrayRefULong(Record));
    Stream.ExitBlock();
    
    // Write the module file extension blocks.
    for (final /*const*/unique_ptr<ModuleFileExtensionWriter> /*&*/ ExtWriter : ModuleFileExtensionWriters)  {
      WriteModuleFileExtension(SemaRef, ExtWriter.$star());
    }
    
    return Signature;
  }
  public static final class WriteASTCore$$ {
    @Converted(kind = Converted.Kind.AUTO,
    source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4584,
    FQN="ModuleInfo", NM="_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEE10ModuleInfo",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEE10ModuleInfo")
   //</editor-fold>
    public static class/*struct*/ ModuleInfo implements NativePOD<ModuleInfo>, NativeMoveable<ModuleInfo> {
     public long/*uint64_t*/ ID;
     public Module /*P*/ M;
     //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteASTCore(Sema & , StringRef, const std::string & , Module * )::ModuleInfo::ModuleInfo">
     @Converted(kind = Converted.Kind.AUTO,
      source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4587,
      FQN="clang::ASTWriter::WriteASTCore(Sema & , StringRef, const std::string & , Module * )::ModuleInfo::ModuleInfo", NM="_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEEN10ModuleInfoC1EyS8_",
      cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEEN10ModuleInfoC1EyS8_")
     //</editor-fold>
     public ModuleInfo(long/*uint64_t*/ ID, Module /*P*/ M) {
       // : ID(ID), M(M) 
       //START JInit
       this.ID = ID;
       this.M = M;
       //END JInit
     }

     //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteASTCore(Sema & , StringRef, const std::string & , Module * )::ModuleInfo::ModuleInfo">
     @Converted(kind = Converted.Kind.AUTO,
      source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4584,
      FQN="clang::ASTWriter::WriteASTCore(Sema & , StringRef, const std::string & , Module * )::ModuleInfo::ModuleInfo", NM="_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEEN10ModuleInfoC1EOS9_",
      cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEEN10ModuleInfoC1EOS9_")
     //</editor-fold>
     public /*inline*/ ModuleInfo(JD$Move _dparam, final ModuleInfo /*&&*/$Prm0) {
       // : ID(static_cast<ModuleInfo &&>().ID), M(static_cast<ModuleInfo &&>().M) 
       //START JInit
       this.ID = $Prm0.ID;
       this.M = $Prm0.M;
       //END JInit
     }

     //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteASTCore(Sema & , StringRef, const std::string & , Module * )::ModuleInfo::operator=">
     @Converted(kind = Converted.Kind.AUTO,
      source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4584,
      FQN="clang::ASTWriter::WriteASTCore(Sema & , StringRef, const std::string & , Module * )::ModuleInfo::operator=", NM="_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEEN10ModuleInfoaSEOS9_",
      cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZZN5clang9ASTWriter12WriteASTCoreERNS_4SemaEN4llvm9StringRefERKSsPNS_6ModuleEEN10ModuleInfoaSEOS9_")
     //</editor-fold>
     public /*inline*/ ModuleInfo /*&*/ $assignMove(final ModuleInfo /*&&*/$Prm0) {
       this.ID = $Prm0.ID;
       this.M = $Prm0.M;
       return /*Deref*/this;
     }

     //////////////////////////////////////////////////////////////
     // EXTRA MEMBERS: BEGIN
     
     public ModuleInfo() {
     }

     @Override
     public ModuleInfo $assign(ModuleInfo $Prm0) {
       this.ID = $Prm0.ID;
       this.M = $Prm0.M;
       return /*Deref*/this;
     }

     @Override
     public ModuleInfo clone() {
       return new ModuleInfo(this.ID, this.M);
     }

     @Override
     public ModuleInfo move() {
       return new ModuleInfo(JD$Move.INSTANCE, this);
     }

     
     // EXTRA MEMBERS: END
     //////////////////////////////////////////////////////////////
        
     @Override public String toString() {
       return "" + "ID=" + ID // NOI18N
                 + ", M=" + M; // NOI18N
     }
   }
  }

/*public:*/
  /// \brief Create a new precompiled header writer that outputs to
  /// the given bitstream.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::ASTWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4071,
   FQN="clang::ASTWriter::ASTWriter", NM="_ZN5clang9ASTWriterC1ERN4llvm15BitstreamWriterENS1_8ArrayRefINS1_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriterC1ERN4llvm15BitstreamWriterENS1_8ArrayRefINS1_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEEb")
  //</editor-fold>
  public ASTWriter(final BitstreamWriter /*&*/ Stream, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions) {
    this(Stream, 
      Extensions, 
      true);
  }
  public ASTWriter(final BitstreamWriter /*&*/ Stream, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      boolean IncludeTimestamps/*= true*/) {
    // : ASTDeserializationListener(), ASTMutationListener(), Stream(Stream), Context(null), PP(null), Chain(null), WritingModule(null), BaseDirectory(), IncludeTimestamps(IncludeTimestamps), WritingAST(false), DoneWritingDeclsAndTypes(false), ASTHasCompilerErrors(false), InputFileIDs(), DeclTypesToEmit(), FirstDeclID(NUM_PREDEF_DECL_IDS), NextDeclID(FirstDeclID), DeclIDs(), DeclOffsets(), FileDeclIDs(), FirstTypeID(NUM_PREDEF_TYPE_IDS), NextTypeID(FirstTypeID), TypeIdxs(), TypeOffsets(), FirstIdentID(NUM_PREDEF_IDENT_IDS), NextIdentID(FirstIdentID), IdentifierIDs(), FirstMacroID(NUM_PREDEF_MACRO_IDS), NextMacroID(FirstMacroID), MacroIDs(), MacroInfosToEmit(), IdentMacroDirectivesOffsetMap(), ParentStmts(), SubStmtEntries(), IdentifierOffsets(), FirstSubmoduleID(NUM_PREDEF_SUBMODULE_IDS), NextSubmoduleID(FirstSubmoduleID), FirstSelectorID(NUM_PREDEF_SELECTOR_IDS), NextSelectorID(FirstSelectorID), SelectorIDs(), SelectorOffsets(), MacroDefinitions(), AnonymousDeclarationNumbers(), DeclUpdates(), FirstLatestDecls(), EagerlyDeserializedDecls(), UpdatedDeclContexts(), UpdatingVisibleDecls(), ObjCClassesWithCategories(), Redeclarations(), FirstLocalDeclCache(), SwitchCaseIDs(), NumStatements(0), NumMacros(0), NumLexicalDeclContexts(0), NumVisibleDeclContexts(0), SubmoduleIDs(), ModuleFileExtensionWriters(), TypeExtQualAbbrev(0), TypeFunctionProtoAbbrev(0), DeclParmVarAbbrev(0), DeclContextLexicalAbbrev(0), DeclContextVisibleLookupAbbrev(0), UpdateVisibleAbbrev(0), DeclRecordAbbrev(0), DeclTypedefAbbrev(0), DeclVarAbbrev(0), DeclFieldAbbrev(0), DeclEnumAbbrev(0), DeclObjCIvarAbbrev(0), DeclCXXMethodAbbrev(0), DeclRefExprAbbrev(0), CharacterLiteralAbbrev(0), IntegerLiteralAbbrev(0), ExprImplicitCastAbbrev(0) 
    //START JInit
    $ASTDeserializationListener();
    $ASTMutationListener();
    this./*&*/Stream=/*&*/Stream;
    this.Context = null;
    this.PP = null;
    this.Chain = null;
    this.WritingModule = null;
    this.BaseDirectory = new std.string();
    this.IncludeTimestamps = IncludeTimestamps;
    this.WritingAST = false;
    this.DoneWritingDeclsAndTypes = false;
    this.ASTHasCompilerErrors = false;
    this.InputFileIDs = new DenseMapTypeUInt</*const*/ FileEntry /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.DeclTypesToEmit = new std.queue<DeclOrType>(false);
    this.FirstDeclID = NUM_PREDEF_DECL_IDS;
    this.NextDeclID = FirstDeclID;
    this.DeclIDs = new DenseMapTypeUInt</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.DeclOffsets = new std.vector<DeclOffset>(new DeclOffset());
    this.FileDeclIDs = new DenseMap<FileID, DeclIDInFileInfo /*P*/ >(DenseMapInfoFileID.$Info(), (DeclIDInFileInfo /*P*/ )null);
    this.FirstTypeID = NUM_PREDEF_TYPE_IDS;
    this.NextTypeID = FirstTypeID;
    this.TypeIdxs = new DenseMap<QualType, TypeIdx>(UnsafeQualTypeDenseMapInfo.$Info(), new TypeIdx());
    this.TypeOffsets = new std.vectorUInt();
    this.FirstIdentID = NUM_PREDEF_IDENT_IDS;
    this.NextIdentID = FirstIdentID;
    this.IdentifierIDs = new MapVectorPtrUInt</*const*/ IdentifierInfo /*P*/>(IdentifierInfo.DMI$IdentifierInfoPtr, (/*uint32_t*/int)0);
    this.FirstMacroID = NUM_PREDEF_MACRO_IDS;
    this.NextMacroID = FirstMacroID;
    this.MacroIDs = new DenseMapTypeUInt<MacroInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.MacroInfosToEmit = new std.vector<MacroInfoToEmitData>(new MacroInfoToEmitData());
    this.IdentMacroDirectivesOffsetMap = new DenseMapTypeULong</*const*/ IdentifierInfo /*P*/ >(IdentifierInfo.DMI$IdentifierInfoPtr, (long/*uint64_t*/)0);
    this.ParentStmts = new DenseSet<Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.SubStmtEntries = new DenseMapTypeULong<Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.IdentifierOffsets = new std.vectorUInt();
    this.FirstSubmoduleID = NUM_PREDEF_SUBMODULE_IDS;
    this.NextSubmoduleID = FirstSubmoduleID;
    this.FirstSelectorID = NUM_PREDEF_SELECTOR_IDS;
    this.NextSelectorID = FirstSelectorID;
    this.SelectorIDs = new MapVectorTypeUInt<Selector>(DenseMapInfoSelector.$Info(), (/*uint32_t*/int)0);
    this.SelectorOffsets = new std.vectorUInt();
    this.MacroDefinitions = new DenseMapTypeUInt</*const*/ MacroDefinitionRecord /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.AnonymousDeclarationNumbers = new DenseMapTypeUInt</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.DeclUpdates = new MapVectorPtrType</*const*/ Decl /*P*/ , SmallVector<DeclUpdate> >(DenseMapInfo$LikePtr.$Info(), new SmallVector<DeclUpdate>(1, new DeclUpdate()));
    this.FirstLatestDecls = new DenseMap<Decl /*P*/ , Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Decl /*P*/ )null);
    this.EagerlyDeserializedDecls = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.UpdatedDeclContexts = new SmallSetVector</*const*/ DeclContext /*P*/ >(16, (/*const*/ DeclContext /*P*/ ) null);
    this.UpdatingVisibleDecls = new SmallVector</*const*/ Decl /*P*/ >(16, (/*const*/ Decl /*P*/ )null);
    this.ObjCClassesWithCategories = new SetVector<ObjCInterfaceDecl /*P*/ >((ObjCInterfaceDecl /*P*/ )null);
    this.Redeclarations = new SmallVector</*const*/ Decl /*P*/ >(16, (/*const*/ Decl /*P*/ )null);
    this.FirstLocalDeclCache = new DenseMap</*const*/ Decl /*P*/ , /*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ Decl /*P*/ )null);
    this.SwitchCaseIDs = new DenseMapTypeUInt<SwitchCase /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.NumStatements = 0;
    this.NumMacros = 0;
    this.NumLexicalDeclContexts = 0;
    this.NumVisibleDeclContexts = 0;
    this.SubmoduleIDs = new DenseMapTypeUInt<Module /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.ModuleFileExtensionWriters = new std.vector<std.unique_ptr<ModuleFileExtensionWriter>>(new std.unique_ptr<ModuleFileExtensionWriter>());
    this.TypeExtQualAbbrev = 0;
    this.TypeFunctionProtoAbbrev = 0;
    this.DeclParmVarAbbrev = 0;
    this.DeclContextLexicalAbbrev = 0;
    this.DeclContextVisibleLookupAbbrev = 0;
    this.UpdateVisibleAbbrev = 0;
    this.DeclRecordAbbrev = 0;
    this.DeclTypedefAbbrev = 0;
    this.DeclVarAbbrev = 0;
    this.DeclFieldAbbrev = 0;
    this.DeclEnumAbbrev = 0;
    this.DeclObjCIvarAbbrev = 0;
    this.DeclCXXMethodAbbrev = 0;
    this.DeclRefExprAbbrev = 0;
    this.CharacterLiteralAbbrev = 0;
    this.IntegerLiteralAbbrev = 0;
    this.ExprImplicitCastAbbrev = 0;
    //END JInit
    for (final /*const*/ IntrusiveRefCntPtr<ModuleFileExtension> /*&*/ Ext : Extensions) {
      {
        unique_ptr<ModuleFileExtensionWriter> Writer = null;
        try {
          Writer = Ext.$arrow().createExtensionWriter(/*Deref*/this);
          if (Writer.$bool()) {
            ModuleFileExtensionWriters.push_back_T$RR(std.move(Writer));
          }
        } finally {
          if (Writer != null) { Writer.$destroy(); }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::~ASTWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4100,
   FQN="clang::ASTWriter::~ASTWriter", NM="_ZN5clang9ASTWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriterD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    llvm.DeleteContainerSeconds(FileDeclIDs);
    //START JDestroy
    ModuleFileExtensionWriters.$destroy();
    SubmoduleIDs.$destroy();
    SwitchCaseIDs.$destroy();
    FirstLocalDeclCache.$destroy();
    Redeclarations.$destroy();
    ObjCClassesWithCategories.$destroy();
    UpdatingVisibleDecls.$destroy();
    UpdatedDeclContexts.$destroy();
    EagerlyDeserializedDecls.$destroy();
    FirstLatestDecls.$destroy();
    DeclUpdates.$destroy();
    AnonymousDeclarationNumbers.$destroy();
    MacroDefinitions.$destroy();
    SelectorOffsets.$destroy();
    SelectorIDs.$destroy();
    IdentifierOffsets.$destroy();
    SubStmtEntries.$destroy();
    ParentStmts.$destroy();
    IdentMacroDirectivesOffsetMap.$destroy();
    MacroInfosToEmit.$destroy();
    MacroIDs.$destroy();
    IdentifierIDs.$destroy();
    TypeOffsets.$destroy();
    TypeIdxs.$destroy();
    FileDeclIDs.$destroy();
    DeclOffsets.$destroy();
    DeclIDs.$destroy();
    DeclTypesToEmit.$destroy();
    InputFileIDs.$destroy();
    BaseDirectory.$destroy();
    ASTDeserializationListener.super.$destroy$ASTDeserializationListener();
    ASTMutationListener.super.$destroy$ASTMutationListener();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4104,
   FQN="clang::ASTWriter::getLangOpts", NM="_ZNK5clang9ASTWriter11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    assert (WritingAST) : "can't determine lang opts when not writing AST";
    return Context.getLangOpts();
  }

  
  /// \brief Get a timestamp for output into the AST file. The actual timestamp
  /// of the specified file may be ignored if we have been instructed to not
  /// include timestamps in the output file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getTimestampForOutput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4109,
   FQN="clang::ASTWriter::getTimestampForOutput", NM="_ZNK5clang9ASTWriter21getTimestampForOutputEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter21getTimestampForOutputEPKNS_9FileEntryE")
  //</editor-fold>
  public long/*time_t*/ getTimestampForOutput(/*const*/ FileEntry /*P*/ E) /*const*/ {
    return IncludeTimestamps ? E.getModificationTime() : 0;
  }

  
  /// \brief Write a precompiled header for the given semantic analysis.
  ///
  /// \param SemaRef a reference to the semantic analysis object that processed
  /// the AST to be written into the precompiled header.
  ///
  /// \param WritingModule The module that we are writing. If null, we are
  /// writing a precompiled header.
  ///
  /// \param isysroot if non-empty, write a relocatable file whose headers
  /// are relative to the given system root. If we're writing a module, its
  /// build directory will be used in preference to this if both are available.
  ///
  /// \return the module signature, which eventually will be a hash of
  /// the module but currently is merely a random 32-bit number.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::WriteAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4113,
   FQN="clang::ASTWriter::WriteAST", NM="_ZN5clang9ASTWriter8WriteASTERNS_4SemaERKSsPNS_6ModuleEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter8WriteASTERNS_4SemaERKSsPNS_6ModuleEN4llvm9StringRefEb")
  //</editor-fold>
  public long/*uint64_t*/ WriteAST(final Sema /*&*/ SemaRef, final /*const*/std.string/*&*/ OutputFile, 
          Module /*P*/ WritingModule, StringRef isysroot) {
    return WriteAST(SemaRef, OutputFile, 
          WritingModule, isysroot, 
          false);
  }
  public long/*uint64_t*/ WriteAST(final Sema /*&*/ SemaRef, final /*const*/std.string/*&*/ OutputFile, 
          Module /*P*/ WritingModule, StringRef isysroot, 
          boolean hasErrors/*= false*/) {
    WritingAST = true;
    
    ASTHasCompilerErrors = hasErrors;
    
    // Emit the file header.
    Stream.Emit((/*uint*/int)$char2uint($$C), 8);
    Stream.Emit((/*uint*/int)$char2uint($$P), 8);
    Stream.Emit((/*uint*/int)$char2uint($$C), 8);
    Stream.Emit((/*uint*/int)$char2uint($$H), 8);
    
    WriteBlockInfoBlock();
    
    Context = $AddrOf(SemaRef.Context);
    PP = $AddrOf(SemaRef.PP);
    this.WritingModule = WritingModule;
    /*uint*/int Signature = $ulong2uint(WriteASTCore(SemaRef, new StringRef(isysroot), OutputFile, WritingModule));
    Context = null;
    PP = null;
    this.WritingModule = null;
    this.BaseDirectory.clear();
    
    WritingAST = false;
    return $uint2ulong(Signature);
  }

  
  /// \brief Emit a token.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3987,
   FQN="clang::ASTWriter::AddToken", NM="_ZN5clang9ASTWriter8AddTokenERKNS_5TokenERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter8AddTokenERKNS_5TokenERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddToken(final /*const*/ Token /*&*/ Tok, final SmallVectorImplULong /*&*/ Record) {
    AddSourceLocation(Tok.getLocation(), Record);
    Record.push_back($uint2ullong(Tok.getLength()));
    
    // FIXME: When reading literal tokens, reconstruct the literal pointer
    // if it is needed.
    AddIdentifierRef(Tok.getIdentifierInfo(), Record);
    // FIXME: Should translate token kind to a stable encoding.
    Record.push_back($ushort2ulong(Tok.getKind()));
    // FIXME: Should translate token flags to a stable encoding.
    Record.push_back($uint2ullong(Tok.getFlags()));
  }

  
  /// \brief Emit a source location.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4785,
   FQN="clang::ASTWriter::AddSourceLocation", NM="_ZN5clang9ASTWriter17AddSourceLocationENS_14SourceLocationERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17AddSourceLocationENS_14SourceLocationERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddSourceLocation(SourceLocation Loc, final SmallVectorImplULong /*&*/ Record) {
    /*uint32_t*/int Raw = Loc.getRawEncoding();
    Record.push_back($uint2ullong((Raw << 1) | (Raw >>> 31)));
  }

  
  /// \brief Emit a source range.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4790,
   FQN="clang::ASTWriter::AddSourceRange", NM="_ZN5clang9ASTWriter14AddSourceRangeENS_11SourceRangeERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter14AddSourceRangeENS_11SourceRangeERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddSourceRange(SourceRange Range, final SmallVectorImplULong /*&*/ Record) {
    AddSourceLocation(Range.getBegin(), Record);
    AddSourceLocation(Range.getEnd(), Record);
  }

  
  /// \brief Emit a reference to an identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddIdentifierRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4810,
   FQN="clang::ASTWriter::AddIdentifierRef", NM="_ZN5clang9ASTWriter16AddIdentifierRefEPKNS_14IdentifierInfoERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16AddIdentifierRefEPKNS_14IdentifierInfoERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddIdentifierRef(/*const*/ IdentifierInfo /*P*/ II, final SmallVectorImplULong /*&*/ Record) {
    Record.push_back($uint2ullong(getIdentifierRef(II)));
  }

  
  /// \brief Get the unique number used to refer to the given selector.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getSelectorRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4856,
   FQN="clang::ASTWriter::getSelectorRef", NM="_ZN5clang9ASTWriter14getSelectorRefENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter14getSelectorRefENS_8SelectorE")
  //</editor-fold>
  public /*uint32_t*/int getSelectorRef(Selector Sel) {
    if (Sel.getAsOpaquePtr() == null) {
      return 0;
    }
    
    /*uint32_t*/int SID = SelectorIDs.$at(Sel);
    if (SID == 0 && (Chain != null)) {
      // This might trigger a ReadSelector callback, which will set the ID for
      // this selector.
      Chain.LoadSelector(new Selector(Sel));
      SID = SelectorIDs.$at(Sel);
    }
    if (SID == 0) {
      SID = NextSelectorID++;
      SelectorIDs.$set(Sel, SID);
    }
    return SID;
  }

  
  /// \brief Get the unique number used to refer to the given identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getIdentifierRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4814,
   FQN="clang::ASTWriter::getIdentifierRef", NM="_ZN5clang9ASTWriter16getIdentifierRefEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16getIdentifierRefEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public /*uint32_t*/int getIdentifierRef(/*const*/ IdentifierInfo /*P*/ II) {
    if (!(II != null)) {
      return 0;
    }
    
    final /*uint32_t &*/uint$ref ID = IdentifierIDs.ref$at(II);
    if (ID.$deref() == 0) {
      ID.$set(NextIdentID++);
    }
    return ID.$deref();
  }

  
  /// \brief Get the unique number used to refer to the given macro.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getMacroRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4824,
   FQN="clang::ASTWriter::getMacroRef", NM="_ZN5clang9ASTWriter11getMacroRefEPNS_9MacroInfoEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter11getMacroRefEPNS_9MacroInfoEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public /*uint32_t*/int getMacroRef(MacroInfo /*P*/ MI, /*const*/ IdentifierInfo /*P*/ Name) {
    // Don't emit builtin macros like __LINE__ to the AST file unless they
    // have been redefined by the header (in which case they are not
    // isBuiltinMacro).
    if (!(MI != null) || MI.isBuiltinMacro()) {
      return 0;
    }
    
    final /*uint32_t &*/uint$ref ID = MacroIDs.ref$at(MI);
    if (ID.$deref() == 0) {
      ID.$set(NextMacroID++);
      MacroInfoToEmitData Info = new MacroInfoToEmitData(Name, MI, ID.$deref());
      MacroInfosToEmit.push_back_T$C$R(Info);
    }
    return ID.$deref();
  }

  
  /// \brief Determine the ID of an already-emitted macro.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getMacroID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4840,
   FQN="clang::ASTWriter::getMacroID", NM="_ZN5clang9ASTWriter10getMacroIDEPNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10getMacroIDEPNS_9MacroInfoE")
  //</editor-fold>
  public /*uint32_t*/int getMacroID(MacroInfo /*P*/ MI) {
    if (!(MI != null) || MI.isBuiltinMacro()) {
      return 0;
    }
    assert (MacroIDs.find(MI).$noteq(/*NO_ITER_COPY*/MacroIDs.end())) : "Macro not emitted!";
    return MacroIDs.$at_T1$C$R(MI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getMacroDirectivesOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4848,
   FQN="clang::ASTWriter::getMacroDirectivesOffset", NM="_ZN5clang9ASTWriter24getMacroDirectivesOffsetEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter24getMacroDirectivesOffsetEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public long/*uint64_t*/ getMacroDirectivesOffset(/*const*/ IdentifierInfo /*P*/ Name) {
    return IdentMacroDirectivesOffsetMap.lookup(Name);
  }

  
  /// \brief Emit a reference to a type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddTypeRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4937,
   FQN="clang::ASTWriter::AddTypeRef", NM="_ZN5clang9ASTWriter10AddTypeRefENS_8QualTypeERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10AddTypeRefENS_8QualTypeERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddTypeRef(QualType T, final SmallVectorImplULong /*&*/ Record) {
    Record.push_back($uint2ullong(GetOrCreateTypeID(new QualType(T))));
  }

  
  /// \brief Force a type to be emitted and get its ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::GetOrCreateTypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4941,
   FQN="clang::ASTWriter::GetOrCreateTypeID", NM="_ZN5clang9ASTWriter17GetOrCreateTypeIDENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17GetOrCreateTypeIDENS_8QualTypeE")
  //</editor-fold>
  public /*uint32_t*/int GetOrCreateTypeID(QualType T) {
    assert Native.$bool(Context);
    return MakeTypeID($Deref(Context), new QualType(T), /*[&, this]*/ (QualType T$1) -> {
              if (T$1.isNull()) {
                return new TypeIdx();
              }
              assert (!(T$1.getLocalFastQualifiers() != 0));
              
              final TypeIdx /*&*/ Idx = TypeIdxs.$at_T1$C$R(T$1);
              if (Idx.getIndex() == 0) {
                if (DoneWritingDeclsAndTypes) {
                  assert (false) : "New type seen after serializing all the types to emit!";
                  return new TypeIdx();
                }
                
                // We haven't seen this type before. Assign it a new ID and put it
                // into the queue of types to emit.
                Idx.$assignMove(new TypeIdx(NextTypeID++));
                DeclTypesToEmit.push_value_type(new DeclOrType(new QualType(T$1)));
              }
              return new TypeIdx(Idx);
            });
  }

  
  /// \brief Determine the type ID of an already-emitted type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getTypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4964,
   FQN="clang::ASTWriter::getTypeID", NM="_ZNK5clang9ASTWriter9getTypeIDENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter9getTypeIDENS_8QualTypeE")
  //</editor-fold>
  public /*uint32_t*/int getTypeID(QualType T) /*const*/ {
    assert Native.$bool(Context);
    return MakeTypeID($Deref(Context), new QualType(T), /*[&, this]*/ (QualType T$1) -> {
              if (T$1.isNull()) {
                return new TypeIdx();
              }
              assert (!(T$1.getLocalFastQualifiers() != 0));
              
              DenseMapIterator<QualType, TypeIdx> I = TypeIdxs.find$Const(T$1);
              assert (I.$noteq(TypeIdxs.end$Const())) : "Type not emitted!";
              return new TypeIdx(I.$arrow().second);
            });
  }

  
  /// \brief Find the first local declaration of a given local redeclarable
  /// decl.
  
  /// \brief Find the first local declaration of a given local redeclarable
  /// decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getFirstLocalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1564,
   FQN="clang::ASTWriter::getFirstLocalDecl", NM="_ZN5clang9ASTWriter17getFirstLocalDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang9ASTWriter17getFirstLocalDeclEPKNS_4DeclE")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getFirstLocalDecl(/*const*/ Decl /*P*/ D) {
    assert (IsLocalDecl(D)) : "expected a local declaration";
    
    /*const*/ Decl /*P*/ Canon = D.getCanonicalDecl$Const();
    if (IsLocalDecl(Canon)) {
      return Canon;
    }
    
    final type$ref</*const*/ Decl /*P*/ /*&*/> CacheEntry = FirstLocalDeclCache.ref$at(Canon);
    if ((CacheEntry.$deref() != null)) {
      return CacheEntry.$deref();
    }
    
    for (/*const*/ Decl /*P*/ Redecl = D; (Redecl != null); Redecl = Redecl.getPreviousDecl$Decl$Const())  {
      if (IsLocalDecl(Redecl)) {
        D = Redecl;
      }
    }
    return CacheEntry.$set(D);
  }


  
  /// \brief Is this a local declaration (that is, one that will be written to
  /// our AST file)? This is the case for declarations that are neither imported
  /// from another AST file nor predefined.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::IsLocalDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 571,
   FQN="clang::ASTWriter::IsLocalDecl", NM="_ZN5clang9ASTWriter11IsLocalDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter11IsLocalDeclEPKNS_4DeclE")
  //</editor-fold>
  public boolean IsLocalDecl(/*const*/ Decl /*P*/ D) {
    if (D.isFromASTFile()) {
      return false;
    }
    DenseMapIteratorTypeUInt</*const*/ Decl /*P*/ /*P*/> I = DeclIDs.find(D);
    return (I.$eq(/*NO_ITER_COPY*/DeclIDs.end())
       || $greatereq_uint(I.$arrow().second, NUM_PREDEF_DECL_IDS));
  }

  
  /// \brief Emit a reference to a declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddDeclRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4977,
   FQN="clang::ASTWriter::AddDeclRef", NM="_ZN5clang9ASTWriter10AddDeclRefEPKNS_4DeclERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10AddDeclRefEPKNS_4DeclERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddDeclRef(/*const*/ Decl /*P*/ D, final SmallVectorImplULong /*&*/ Record) {
    Record.push_back($uint2ullong(GetDeclRef(D)));
  }

  
  /// \brief Force a declaration to be emitted and get its ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::GetDeclRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4981,
   FQN="clang::ASTWriter::GetDeclRef", NM="_ZN5clang9ASTWriter10GetDeclRefEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10GetDeclRefEPKNS_4DeclE")
  //</editor-fold>
  public /*uint32_t*/int GetDeclRef(/*const*/ Decl /*P*/ D) {
    assert (WritingAST) : "Cannot request a declaration ID before AST writing";
    if (!(D != null)) {
      return 0;
    }
    
    // If D comes from an AST file, its declaration ID is already known and
    // fixed.
    if (D.isFromASTFile()) {
      return D.getGlobalID();
    }
    //assert (!((reinterpret_cast_Object/*uintptr_t*/(D) & 0x1) != 0)) : "Invalid decl pointer";
    final /*uint32_t &*/uint$ref ID = DeclIDs.ref$at(D);
    if (ID.$deref() == 0) {
      if (DoneWritingDeclsAndTypes) {
        assert (false) : "New decl seen after serializing all the decls to emit!";
        return 0;
      }
      
      // We haven't seen this declaration before. Give it a new ID and
      // enqueue it in the list of declarations to emit.
      ID.$set(NextDeclID++);
      DeclTypesToEmit.push_value_type(new DeclOrType(((/*const_cast*/Decl /*P*/ )(D))));
    }
    
    return ID.$deref();
  }

  
  /// \brief Determine the declaration ID of an already-emitted
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5010,
   FQN="clang::ASTWriter::getDeclID", NM="_ZN5clang9ASTWriter9getDeclIDEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter9getDeclIDEPKNS_4DeclE")
  //</editor-fold>
  public /*uint32_t*/int getDeclID(/*const*/ Decl /*P*/ D) {
    if (!(D != null)) {
      return 0;
    }
    
    // If D comes from an AST file, its declaration ID is already known and
    // fixed.
    if (D.isFromASTFile()) {
      return D.getGlobalID();
    }
    assert (DeclIDs.find(D).$noteq(/*NO_ITER_COPY*/DeclIDs.end())) : "Declaration not emitted!";
    return DeclIDs.$at_T1$C$R(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getAnonymousDeclarationNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5101,
   FQN="clang::ASTWriter::getAnonymousDeclarationNumber", NM="_ZN5clang9ASTWriter29getAnonymousDeclarationNumberEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter29getAnonymousDeclarationNumberEPKNS_9NamedDeclE")
  //</editor-fold>
  public /*uint*/int getAnonymousDeclarationNumber(/*const*/ NamedDecl /*P*/ D) {
    assert (needsAnonymousDeclarationNumber(D)) : "expected an anonymous declaration";
    
    // Number the anonymous declarations within this context, if we've not
    // already done so.
    DenseMapIteratorTypeUInt</*const*/ Decl /*P*/ /*P*/> It = AnonymousDeclarationNumbers.find(D);
    if (It.$eq(/*NO_ITER_COPY*/AnonymousDeclarationNumbers.end())) {
      /*const*/ DeclContext /*P*/ DC = D.getLexicalDeclContext$Const();
      numberAnonymousDeclsWithin(DC, /*[&, this]*/ (/*const*/ NamedDecl /*P*/ ND, /*uint*/int Number) -> {
                AnonymousDeclarationNumbers.$set(ND, Number);
              });
      
      It.$assignMove(AnonymousDeclarationNumbers.find(D));
      assert (It.$noteq(/*NO_ITER_COPY*/AnonymousDeclarationNumbers.end())) : "declaration not found within its lexical context";
    }
    
    return It.$arrow().second;
  }

  
  /// \brief Add a string to the given record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4000,
   FQN="clang::ASTWriter::AddString", NM="_ZN5clang9ASTWriter9AddStringEN4llvm9StringRefERNS1_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter9AddStringEN4llvm9StringRefERNS1_15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddString(StringRef Str, final SmallVectorImplULong /*&*/ Record) {
    Record.push_back($uint2ullong(Str.size()));
    Record.insert_iterator$T_T(Record.end(), Str.begin(), Str.end());
  }

  
  /// \brief Convert a path from this build process into one that is appropriate
  /// for emission in the module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::PreparePathForOutput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4005,
   FQN="clang::ASTWriter::PreparePathForOutput", NM="_ZN5clang9ASTWriter20PreparePathForOutputERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter20PreparePathForOutputERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public boolean PreparePathForOutput(final SmallString/*&*/ Path) {
    assert ((Context != null)) : "should have context when outputting path";
    
    boolean Changed = cleanPathForOutput(Context.getSourceManager().getFileManager(), Path);
    
    // Remove a prefix to make the path relative, if relevant.
    /*const*/char$ptr/*char P*/ PathBegin = $tryClone(Path.data());
    /*const*/char$ptr/*char P*/ PathPtr = $tryClone(adjustFilenameForRelocatableAST(PathBegin, new StringRef(BaseDirectory)));
    if ($noteq_ptr(PathPtr, PathBegin)) {
      Path.erase(Path.begin(), Path.begin().$add((PathPtr.$sub(PathBegin))));
      Changed = true;
    }
    
    return Changed;
  }

  
  /// \brief Add a path to the given record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4023,
   FQN="clang::ASTWriter::AddPath", NM="_ZN5clang9ASTWriter7AddPathEN4llvm9StringRefERNS1_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter7AddPathEN4llvm9StringRefERNS1_15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddPath(StringRef Path, final SmallVectorImplULong /*&*/ Record) {
    SmallString/*<128>*/ FilePath/*J*/= new SmallString/*<128>*/(128, new StringRef(Path));
    PreparePathForOutput(FilePath);
    AddString(FilePath.$StringRef(), Record);
  }

  
  /// \brief Emit the current record with the given path as a blob.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::EmitRecordWithPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4029,
   FQN="clang::ASTWriter::EmitRecordWithPath", NM="_ZN5clang9ASTWriter18EmitRecordWithPathEjN4llvm8ArrayRefIyEENS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter18EmitRecordWithPathEjN4llvm8ArrayRefIyEENS1_9StringRefE")
  //</editor-fold>
  public void EmitRecordWithPath(/*uint*/int Abbrev, ArrayRefULong Record, 
                    StringRef Path) {
    SmallString/*<128>*/ FilePath/*J*/= new SmallString/*<128>*/(128, new StringRef(Path));
    PreparePathForOutput(FilePath);
    Stream.EmitRecordWithBlob(Abbrev, Record, FilePath.$StringRef());
  }

  
  /// \brief Add a version tuple to the given record
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddVersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4036,
   FQN="clang::ASTWriter::AddVersionTuple", NM="_ZN5clang9ASTWriter15AddVersionTupleERKNS_12VersionTupleERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter15AddVersionTupleERKNS_12VersionTupleERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public void AddVersionTuple(final /*const*/ VersionTuple /*&*/ Version, 
                 final SmallVectorImplULong /*&*/ Record) {
    Record.push_back($uint2ullong(Version.getMajor()));
    {
      OptionalUInt Minor = Version.getMinor();
      if (Minor.$bool()) {
        Record.push_back($uint2ullong(Minor.$star() + 1));
      } else {
        Record.push_back($int2ullong(0));
      }
    }
    {
      OptionalUInt Subminor = Version.getSubminor();
      if (Subminor.$bool()) {
        Record.push_back($uint2ullong(Subminor.$star() + 1));
      } else {
        Record.push_back($int2ullong(0));
      }
    }
  }

  
  /// \brief Infer the submodule ID that contains an entity at the given
  /// source location.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::inferSubmoduleIDFromLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2666,
   FQN="clang::ASTWriter::inferSubmoduleIDFromLocation", NM="_ZN5clang9ASTWriter28inferSubmoduleIDFromLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter28inferSubmoduleIDFromLocationENS_14SourceLocationE")
  //</editor-fold>
  public /*uint32_t*/int inferSubmoduleIDFromLocation(SourceLocation Loc) {
    if (Loc.isInvalid() || !(WritingModule != null)) {
      return 0; // No submodule
    }
    
    // Find the module that owns this location.
    final ModuleMap /*&*/ ModMap = PP.getHeaderSearchInfo().getModuleMap();
    Module /*P*/ OwningMod = ModMap.inferModuleFromLocation(new FullSourceLoc(/*NO_COPY*/Loc, PP.getSourceManager()));
    if (!(OwningMod != null)) {
      return 0;
    }
    
    // Check whether this submodule is part of our own module.
    if (WritingModule != OwningMod && !OwningMod.isSubModuleOf(WritingModule)) {
      return 0;
    }
    
    return getSubmoduleID(OwningMod);
  }

  
  /// \brief Retrieve or create a submodule ID for this module, or return 0 if
  /// the submodule is neither local (a submodle of the currently-written module)
  /// nor from an imported module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getLocalOrImportedSubmoduleID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2413,
   FQN="clang::ASTWriter::getLocalOrImportedSubmoduleID", NM="_ZN5clang9ASTWriter29getLocalOrImportedSubmoduleIDEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter29getLocalOrImportedSubmoduleIDEPNS_6ModuleE")
  //</editor-fold>
  public /*uint*/int getLocalOrImportedSubmoduleID(Module /*P*/ Mod) {
    if (!(Mod != null)) {
      return 0;
    }
    
    DenseMapIteratorTypeUInt<Module /*P*/ /*P*/> Known = SubmoduleIDs.find(Mod);
    if (Known.$noteq(/*NO_ITER_COPY*/SubmoduleIDs.end())) {
      return Known.$arrow().second;
    }
    if (Mod.getTopLevelModule() != WritingModule) {
      return 0;
    }
    
    return SubmoduleIDs.$set(Mod, NextSubmoduleID++);
  }

  
  /// \brief Note that the identifier II occurs at the given offset
  /// within the identifier table.
  
  /// \brief Note that the identifier II occurs at the given offset
  /// within the identifier table.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::SetIdentifierOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4051,
   FQN="clang::ASTWriter::SetIdentifierOffset", NM="_ZN5clang9ASTWriter19SetIdentifierOffsetEPKNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19SetIdentifierOffsetEPKNS_14IdentifierInfoEj")
  //</editor-fold>
  public void SetIdentifierOffset(/*const*/ IdentifierInfo /*P*/ II, /*uint32_t*/int Offset) {
    /*uint32_t*/int ID = IdentifierIDs.$at(II);
    // Only store offsets new to this AST file. Other identifier names are looked
    // up earlier in the chain and thus don't need an offset.
    if ($greatereq_uint(ID, FirstIdentID)) {
      IdentifierOffsets.$set(ID - FirstIdentID, Offset);
    }
  }

  
  /// \brief Note that the selector Sel occurs at the given offset
  /// within the method pool/selector table.
  
  /// \brief Note that the selector Sel occurs at the given offset
  /// within the method pool/selector table.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::SetSelectorOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4061,
   FQN="clang::ASTWriter::SetSelectorOffset", NM="_ZN5clang9ASTWriter17SetSelectorOffsetENS_8SelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17SetSelectorOffsetENS_8SelectorEj")
  //</editor-fold>
  public void SetSelectorOffset(Selector Sel, /*uint32_t*/int Offset) {
    /*uint*/int ID = SelectorIDs.$at(Sel);
    assert ((ID != 0)) : "Unknown selector";
    // Don't record offsets for selectors that are also available in a different
    // file.
    if ($less_uint(ID, FirstSelectorID)) {
      return;
    }
    SelectorOffsets.$set(ID - FirstSelectorID, Offset);
  }

  
  /// \brief Record an ID for the given switch-case statement.
  
  /// \brief Record an ID for the given switch-case statement.
  
  //===----------------------------------------------------------------------===//
  // ASTWriter Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::RecordSwitchCaseID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2486,
   FQN="clang::ASTWriter::RecordSwitchCaseID", NM="_ZN5clang9ASTWriter18RecordSwitchCaseIDEPNS_10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang9ASTWriter18RecordSwitchCaseIDEPNS_10SwitchCaseE")
  //</editor-fold>
  public /*uint*/int RecordSwitchCaseID(SwitchCase /*P*/ S) {
    assert (SwitchCaseIDs.find(S).$eq(/*NO_ITER_COPY*/SwitchCaseIDs.end())) : "SwitchCase recorded twice";
    /*uint*/int NextID = SwitchCaseIDs.size();
    SwitchCaseIDs.$set(S, NextID);
    return NextID;
  }


  
  /// \brief Retrieve the ID for the given switch-case statement.
  
  /// \brief Retrieve the ID for the given switch-case statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getSwitchCaseID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2494,
   FQN="clang::ASTWriter::getSwitchCaseID", NM="_ZN5clang9ASTWriter15getSwitchCaseIDEPNS_10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang9ASTWriter15getSwitchCaseIDEPNS_10SwitchCaseE")
  //</editor-fold>
  public /*uint*/int getSwitchCaseID(SwitchCase /*P*/ S) {
    assert (SwitchCaseIDs.find(S).$noteq(/*NO_ITER_COPY*/SwitchCaseIDs.end())) : "SwitchCase hasn't been seen yet";
    return SwitchCaseIDs.$at_T1$C$R(S);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::ClearSwitchCaseIDs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp", line = 2500,
   FQN="clang::ASTWriter::ClearSwitchCaseIDs", NM="_ZN5clang9ASTWriter18ClearSwitchCaseIDsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp -nm=_ZN5clang9ASTWriter18ClearSwitchCaseIDsEv")
  //</editor-fold>
  public void ClearSwitchCaseIDs() {
    SwitchCaseIDs.clear();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getTypeExtQualAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 634,
   FQN="clang::ASTWriter::getTypeExtQualAbbrev", NM="_ZNK5clang9ASTWriter20getTypeExtQualAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter20getTypeExtQualAbbrevEv")
  //</editor-fold>
  public /*uint*/int getTypeExtQualAbbrev() /*const*/ {
    return TypeExtQualAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getTypeFunctionProtoAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 637,
   FQN="clang::ASTWriter::getTypeFunctionProtoAbbrev", NM="_ZNK5clang9ASTWriter26getTypeFunctionProtoAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter26getTypeFunctionProtoAbbrevEv")
  //</editor-fold>
  public /*uint*/int getTypeFunctionProtoAbbrev() /*const*/ {
    return TypeFunctionProtoAbbrev;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclParmVarAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 641,
   FQN="clang::ASTWriter::getDeclParmVarAbbrev", NM="_ZNK5clang9ASTWriter20getDeclParmVarAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter20getDeclParmVarAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclParmVarAbbrev() /*const*/ {
    return DeclParmVarAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclRecordAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 642,
   FQN="clang::ASTWriter::getDeclRecordAbbrev", NM="_ZNK5clang9ASTWriter19getDeclRecordAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter19getDeclRecordAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclRecordAbbrev() /*const*/ {
    return DeclRecordAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclTypedefAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 643,
   FQN="clang::ASTWriter::getDeclTypedefAbbrev", NM="_ZNK5clang9ASTWriter20getDeclTypedefAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter20getDeclTypedefAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclTypedefAbbrev() /*const*/ {
    return DeclTypedefAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclVarAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 644,
   FQN="clang::ASTWriter::getDeclVarAbbrev", NM="_ZNK5clang9ASTWriter16getDeclVarAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter16getDeclVarAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclVarAbbrev() /*const*/ {
    return DeclVarAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclFieldAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 645,
   FQN="clang::ASTWriter::getDeclFieldAbbrev", NM="_ZNK5clang9ASTWriter18getDeclFieldAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter18getDeclFieldAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclFieldAbbrev() /*const*/ {
    return DeclFieldAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclEnumAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 646,
   FQN="clang::ASTWriter::getDeclEnumAbbrev", NM="_ZNK5clang9ASTWriter17getDeclEnumAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter17getDeclEnumAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclEnumAbbrev() /*const*/ {
    return DeclEnumAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclObjCIvarAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 647,
   FQN="clang::ASTWriter::getDeclObjCIvarAbbrev", NM="_ZNK5clang9ASTWriter21getDeclObjCIvarAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter21getDeclObjCIvarAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclObjCIvarAbbrev() /*const*/ {
    return DeclObjCIvarAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclCXXMethodAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 648,
   FQN="clang::ASTWriter::getDeclCXXMethodAbbrev", NM="_ZNK5clang9ASTWriter22getDeclCXXMethodAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter22getDeclCXXMethodAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclCXXMethodAbbrev() /*const*/ {
    return DeclCXXMethodAbbrev;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getDeclRefExprAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 650,
   FQN="clang::ASTWriter::getDeclRefExprAbbrev", NM="_ZNK5clang9ASTWriter20getDeclRefExprAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter20getDeclRefExprAbbrevEv")
  //</editor-fold>
  public /*uint*/int getDeclRefExprAbbrev() /*const*/ {
    return DeclRefExprAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getCharacterLiteralAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 651,
   FQN="clang::ASTWriter::getCharacterLiteralAbbrev", NM="_ZNK5clang9ASTWriter25getCharacterLiteralAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter25getCharacterLiteralAbbrevEv")
  //</editor-fold>
  public /*uint*/int getCharacterLiteralAbbrev() /*const*/ {
    return CharacterLiteralAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getIntegerLiteralAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 652,
   FQN="clang::ASTWriter::getIntegerLiteralAbbrev", NM="_ZNK5clang9ASTWriter23getIntegerLiteralAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter23getIntegerLiteralAbbrevEv")
  //</editor-fold>
  public /*uint*/int getIntegerLiteralAbbrev() /*const*/ {
    return IntegerLiteralAbbrev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getExprImplicitCastAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 653,
   FQN="clang::ASTWriter::getExprImplicitCastAbbrev", NM="_ZNK5clang9ASTWriter25getExprImplicitCastAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter25getExprImplicitCastAbbrevEv")
  //</editor-fold>
  public /*uint*/int getExprImplicitCastAbbrev() /*const*/ {
    return ExprImplicitCastAbbrev;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::hasChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 655,
   FQN="clang::ASTWriter::hasChain", NM="_ZNK5clang9ASTWriter8hasChainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter8hasChainEv")
  //</editor-fold>
  public boolean hasChain() /*const*/ {
    return (Chain != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::getChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTWriter.h", line = 656,
   FQN="clang::ASTWriter::getChain", NM="_ZNK5clang9ASTWriter8getChainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang9ASTWriter8getChainEv")
  //</editor-fold>
  public ASTReader /*P*/ getChain() /*const*/ {
    return Chain;
  }

/*private:*/
  // ASTDeserializationListener implementation
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::ReaderInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5567,
   FQN="clang::ASTWriter::ReaderInitialized", NM="_ZN5clang9ASTWriter17ReaderInitializedEPNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17ReaderInitializedEPNS_9ASTReaderE")
  //</editor-fold>
  @Override public/*private*/ void ReaderInitialized(ASTReader /*P*/ Reader)/* override*/ {
    assert ((Reader != null)) : "Cannot remove chain";
    assert ((!(Chain != null) || Chain == Reader)) : "Cannot replace chain";
    assert (FirstDeclID == NextDeclID && FirstTypeID == NextTypeID && FirstIdentID == NextIdentID && FirstMacroID == NextMacroID && FirstSubmoduleID == NextSubmoduleID && FirstSelectorID == NextSelectorID) : "Setting chain after writing has started.";
    
    Chain = Reader;
    
    // Note, this will get called multiple times, once one the reader starts up
    // and again each time it's done reading a PCH or module.
    FirstDeclID = NUM_PREDEF_DECL_IDS + Chain.getTotalNumDecls();
    FirstTypeID = NUM_PREDEF_TYPE_IDS + Chain.getTotalNumTypes();
    FirstIdentID = NUM_PREDEF_IDENT_IDS + Chain.getTotalNumIdentifiers();
    FirstMacroID = NUM_PREDEF_MACRO_IDS + Chain.getTotalNumMacros();
    FirstSubmoduleID = NUM_PREDEF_SUBMODULE_IDS + Chain.getTotalNumSubmodules();
    FirstSelectorID = NUM_PREDEF_SELECTOR_IDS + Chain.getTotalNumSelectors();
    NextDeclID = FirstDeclID;
    NextTypeID = FirstTypeID;
    NextIdentID = FirstIdentID;
    NextMacroID = FirstMacroID;
    NextSelectorID = FirstSelectorID;
    NextSubmoduleID = FirstSubmoduleID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::IdentifierRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5596,
   FQN="clang::ASTWriter::IdentifierRead", NM="_ZN5clang9ASTWriter14IdentifierReadEjPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter14IdentifierReadEjPNS_14IdentifierInfoE")
  //</editor-fold>
  @Override public/*private*/ void IdentifierRead(/*uint32_t*/int ID, IdentifierInfo /*P*/ II)/* override*/ {
    // Always keep the highest ID. See \p TypeRead() for more information.
    final /*uint32_t &*/uint$ref StoredID = IdentifierIDs.ref$at(II);
    if ($greater_uint(ID, StoredID.$deref())) {
      StoredID.$set(ID);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::MacroRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5603,
   FQN="clang::ASTWriter::MacroRead", NM="_ZN5clang9ASTWriter9MacroReadEjPNS_9MacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter9MacroReadEjPNS_9MacroInfoE")
  //</editor-fold>
  @Override public/*private*/ void MacroRead(/*uint32_t*/int ID, MacroInfo /*P*/ MI)/* override*/ {
    // Always keep the highest ID. See \p TypeRead() for more information.
    final /*uint32_t &*/uint$ref StoredID = MacroIDs.ref$at(MI);
    if ($greater_uint(ID, StoredID.$deref())) {
      StoredID.$set(ID);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::TypeRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5610,
   FQN="clang::ASTWriter::TypeRead", NM="_ZN5clang9ASTWriter8TypeReadENS_13serialization7TypeIdxENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter8TypeReadENS_13serialization7TypeIdxENS_8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ void TypeRead(TypeIdx Idx, QualType T)/* override*/ {
    // Always take the highest-numbered type index. This copes with an interesting
    // case for chained AST writing where we schedule writing the type and then,
    // later, deserialize the type from another AST. In this case, we want to
    // keep the higher-numbered entry so that we can properly write it out to
    // the AST file.
    final TypeIdx /*&*/ StoredIdx = TypeIdxs.$at_T1$C$R(T);
    if ($greatereq_uint(Idx.getIndex(), StoredIdx.getIndex())) {
      StoredIdx.$assign(Idx);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::SelectorRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5621,
   FQN="clang::ASTWriter::SelectorRead", NM="_ZN5clang9ASTWriter12SelectorReadEjNS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter12SelectorReadEjNS_8SelectorE")
  //</editor-fold>
  @Override public/*private*/ void SelectorRead(/*uint32_t*/int ID, Selector S)/* override*/ {
    // Always keep the highest ID. See \p TypeRead() for more information.
    final /*uint32_t &*/uint$ref StoredID = SelectorIDs.ref$at(S);
    if ($greater_uint(ID, StoredID.$deref())) {
      StoredID.$set(ID);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::MacroDefinitionRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5628,
   FQN="clang::ASTWriter::MacroDefinitionRead", NM="_ZN5clang9ASTWriter19MacroDefinitionReadEjPNS_21MacroDefinitionRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter19MacroDefinitionReadEjPNS_21MacroDefinitionRecordE")
  //</editor-fold>
  @Override public/*private*/ void MacroDefinitionRead(/*uint32_t*/int ID, 
                     MacroDefinitionRecord /*P*/ MD)/* override*/ {
    assert (MacroDefinitions.find(MD).$eq(/*NO_ITER_COPY*/MacroDefinitions.end()));
    MacroDefinitions.$set(MD, ID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::ModuleRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5634,
   FQN="clang::ASTWriter::ModuleRead", NM="_ZN5clang9ASTWriter10ModuleReadEjPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter10ModuleReadEjPNS_6ModuleE")
  //</editor-fold>
  @Override public/*private*/ void ModuleRead(/*uint32_t*/int ID, Module /*P*/ Mod)/* override*/ {
    assert (SubmoduleIDs.find(Mod).$eq(/*NO_ITER_COPY*/SubmoduleIDs.end()));
    SubmoduleIDs.$set(Mod, ID);
  }

  
  // ASTMutationListener implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::CompletedTagDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5639,
   FQN="clang::ASTWriter::CompletedTagDefinition", NM="_ZN5clang9ASTWriter22CompletedTagDefinitionEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter22CompletedTagDefinitionEPKNS_7TagDeclE")
  //</editor-fold>
  @Override public/*private*/ void CompletedTagDefinition(/*const*/ TagDecl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (D.isCompleteDefinition());
    assert (!WritingAST) : "Already writing the AST!";
    {
      /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
      if ((RD != null)) {
        // We are interested when a PCH decl is modified.
        if (RD.isFromASTFile()) {
          // A forward reference was mutated into a definition. Rewrite it.
          // FIXME: This happens during template instantiation, should we
          // have created a new definition decl instead ?
          assert (isTemplateInstantiation(RD.getTemplateSpecializationKind())) : "completed a tag from another module but not by instantiation?";
          DeclUpdates.$at(RD).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_INSTANTIATED_CLASS_DEFINITION));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddedVisibleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5666,
   FQN="clang::ASTWriter::AddedVisibleDecl", NM="_ZN5clang9ASTWriter16AddedVisibleDeclEPKNS_11DeclContextEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter16AddedVisibleDeclEPKNS_11DeclContextEPKNS_4DeclE")
  //</editor-fold>
  @Override public/*private*/ void AddedVisibleDecl(/*const*/ DeclContext /*P*/ DC, /*const*/ Decl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (DC.isLookupContext()) : "Should not add lookup results to non-lookup contexts!";
    
    // TU is handled elsewhere.
    if (isa_TranslationUnitDecl(DC)) {
      return;
    }
    
    // Namespaces are handled elsewhere, except for template instantiations of
    // FunctionTemplateDecls in namespaces. We are interested in cases where the
    // local instantiations are added to an imported context. Only happens when
    // adding ADL lookup candidates, for example templated friends.
    if (isa_NamespaceDecl(DC) && D.getFriendObjectKind() == Decl.FriendObjectKind.FOK_None
       && !isa_FunctionTemplateDecl(D)) {
      return;
    }
    
    // We're only interested in cases where a local declaration is added to an
    // imported context.
    if (D.isFromASTFile() || !isImportedDeclContext(Chain, cast_Decl(DC))) {
      return;
    }
    assert (DC == DC.getPrimaryContext$Const()) : "added to non-primary context";
    assert (!(getDefinitiveDeclContext(DC) != null)) : "DeclContext not definitive!";
    assert (!WritingAST) : "Already writing the AST!";
    if (UpdatedDeclContexts.insert(DC) && !cast_Decl(DC).isFromASTFile()) {
      // We're adding a visible declaration to a predefined decl context. Ensure
      // that we write out all of its lookup results so we don't get a nasty
      // surprise when we try to emit its lookup table.
      for (Decl /*P*/ Child : DC.decls())  {
        UpdatingVisibleDecls.push_back(Child);
      }
    }
    UpdatingVisibleDecls.push_back(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddedCXXImplicitMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5701,
   FQN="clang::ASTWriter::AddedCXXImplicitMember", NM="_ZN5clang9ASTWriter22AddedCXXImplicitMemberEPKNS_13CXXRecordDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter22AddedCXXImplicitMemberEPKNS_13CXXRecordDeclEPKNS_4DeclE")
  //</editor-fold>
  @Override public/*private*/ void AddedCXXImplicitMember(/*const*/ CXXRecordDecl /*P*/ RD, /*const*/ Decl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (D.isImplicit());
    
    // We're only interested in cases where a local declaration is added to an
    // imported context.
    if (D.isFromASTFile() || !isImportedDeclContext(Chain, RD)) {
      return;
    }
    if (!isa_CXXMethodDecl(D)) {
      return;
    }
    
    // A decl coming from PCH was modified.
    assert (RD.isCompleteDefinition());
    assert (!WritingAST) : "Already writing the AST!";
    DeclUpdates.$at(RD).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_ADDED_IMPLICIT_MEMBER, D));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::ResolvedExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5719,
   FQN="clang::ASTWriter::ResolvedExceptionSpec", NM="_ZN5clang9ASTWriter21ResolvedExceptionSpecEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter21ResolvedExceptionSpecEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public/*private*/ void ResolvedExceptionSpec(/*const*/ FunctionDecl /*P*/ FD)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!DoneWritingDeclsAndTypes) : "Already done writing updates!";
    if (!(Chain != null)) {
      return;
    }
    Chain.forEachImportedKeyDecl(FD, /*[&, this]*/ (/*const*/ Decl /*P*/ D) -> {
              // If we don't already know the exception specification for this redecl
              // chain, add an update record for it.
              if (isUnresolvedExceptionSpec(cast_FunctionDecl(D).
    getType().$arrow().castAs(FunctionProtoType.class).
                      getExceptionSpecType())) {
                DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_RESOLVED_EXCEPTION_SPEC));
              }
            });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeducedReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5734,
   FQN="clang::ASTWriter::DeducedReturnType", NM="_ZN5clang9ASTWriter17DeducedReturnTypeEPKNS_12FunctionDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter17DeducedReturnTypeEPKNS_12FunctionDeclENS_8QualTypeE")
  //</editor-fold>
  @Override public/*private*/ void DeducedReturnType(/*const*/ FunctionDecl /*P*/ FD, QualType ReturnType)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!(Chain != null)) {
      return;
    }
    Chain.forEachImportedKeyDecl(FD, /*[&, this, &ReturnType]*/ (/*const*/ Decl /*P*/ D) -> {
              DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_DEDUCED_RETURN_TYPE, new QualType(ReturnType)));
            });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::ResolvedOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5744,
   FQN="clang::ASTWriter::ResolvedOperatorDelete", NM="_ZN5clang9ASTWriter22ResolvedOperatorDeleteEPKNS_17CXXDestructorDeclEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter22ResolvedOperatorDeleteEPKNS_17CXXDestructorDeclEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public/*private*/ void ResolvedOperatorDelete(/*const*/ CXXDestructorDecl /*P*/ DD, 
                        /*const*/ FunctionDecl /*P*/ Delete)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    assert ((Delete != null)) : "Not given an operator delete";
    if (!(Chain != null)) {
      return;
    }
    Chain.forEachImportedKeyDecl(DD, /*[&, this, &Delete]*/ (/*const*/ Decl /*P*/ D) -> {
              DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_RESOLVED_DTOR_DELETE, Delete));
            });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::CompletedImplicitDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5755,
   FQN="clang::ASTWriter::CompletedImplicitDefinition", NM="_ZN5clang9ASTWriter27CompletedImplicitDefinitionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter27CompletedImplicitDefinitionEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public/*private*/ void CompletedImplicitDefinition(/*const*/ FunctionDecl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!D.isFromASTFile()) {
      return; // Declaration not imported from PCH.
    }
    
    // Implicit function decl from a PCH was defined.
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_ADDED_FUNCTION_DEFINITION));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::StaticDataMemberInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5774,
   FQN="clang::ASTWriter::StaticDataMemberInstantiated", NM="_ZN5clang9ASTWriter28StaticDataMemberInstantiatedEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter28StaticDataMemberInstantiatedEPKNS_7VarDeclE")
  //</editor-fold>
  @Override public/*private*/ void StaticDataMemberInstantiated(/*const*/ VarDecl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!D.isFromASTFile()) {
      return;
    }
    
    // Since the actual instantiation is delayed, this really means that we need
    // to update the instantiation location.
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_INSTANTIATED_STATIC_DATA_MEMBER, 
            D.getMemberSpecializationInfo().getPointOfInstantiation()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DefaultArgumentInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5787,
   FQN="clang::ASTWriter::DefaultArgumentInstantiated", NM="_ZN5clang9ASTWriter27DefaultArgumentInstantiatedEPKNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter27DefaultArgumentInstantiatedEPKNS_11ParmVarDeclE")
  //</editor-fold>
  @Override public/*private*/ void DefaultArgumentInstantiated(/*const*/ ParmVarDecl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!D.isFromASTFile()) {
      return;
    }
    
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_INSTANTIATED_DEFAULT_ARGUMENT, D));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::FunctionDefinitionInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5765,
   FQN="clang::ASTWriter::FunctionDefinitionInstantiated", NM="_ZN5clang9ASTWriter30FunctionDefinitionInstantiatedEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter30FunctionDefinitionInstantiatedEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public/*private*/ void FunctionDefinitionInstantiated(/*const*/ FunctionDecl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!D.isFromASTFile()) {
      return;
    }
    
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_CXX_ADDED_FUNCTION_DEFINITION));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddedObjCCategoryToInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5797,
   FQN="clang::ASTWriter::AddedObjCCategoryToInterface", NM="_ZN5clang9ASTWriter28AddedObjCCategoryToInterfaceEPKNS_16ObjCCategoryDeclEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter28AddedObjCCategoryToInterfaceEPKNS_16ObjCCategoryDeclEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  @Override public/*private*/ void AddedObjCCategoryToInterface(/*const*/ ObjCCategoryDecl /*P*/ CatD, 
                              /*const*/ ObjCInterfaceDecl /*P*/ IFD)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!IFD.isFromASTFile()) {
      return; // Declaration not imported from PCH.
    }
    assert ((IFD.getDefinition$Const() != null)) : "Category on a class without a definition?";
    ObjCClassesWithCategories.insert(((/*const_cast*/ObjCInterfaceDecl /*P*/ )(IFD.getDefinition$Const())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclarationMarkedUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5809,
   FQN="clang::ASTWriter::DeclarationMarkedUsed", NM="_ZN5clang9ASTWriter21DeclarationMarkedUsedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter21DeclarationMarkedUsedEPKNS_4DeclE")
  //</editor-fold>
  @Override public/*private*/ void DeclarationMarkedUsed(/*const*/ Decl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    
    // If there is *any* declaration of the entity that's not from an AST file,
    // we can skip writing the update record. We make sure that isUsed() triggers
    // completion of the redeclaration chain of the entity.
    for (/*const*/ Decl /*P*/ Prev = D.getMostRecentDecl$Decl$Const(); (Prev != null); Prev = Prev.getPreviousDecl$Decl$Const())  {
      if (IsLocalDecl(Prev)) {
        return;
      }
    }
    
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_DECL_MARKED_USED));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclarationMarkedOpenMPThreadPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5823,
   FQN="clang::ASTWriter::DeclarationMarkedOpenMPThreadPrivate", NM="_ZN5clang9ASTWriter36DeclarationMarkedOpenMPThreadPrivateEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter36DeclarationMarkedOpenMPThreadPrivateEPKNS_4DeclE")
  //</editor-fold>
  @Override public/*private*/ void DeclarationMarkedOpenMPThreadPrivate(/*const*/ Decl /*P*/ D)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!D.isFromASTFile()) {
      return;
    }
    
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_DECL_MARKED_OPENMP_THREADPRIVATE));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::DeclarationMarkedOpenMPDeclareTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5832,
   FQN="clang::ASTWriter::DeclarationMarkedOpenMPDeclareTarget", NM="_ZN5clang9ASTWriter36DeclarationMarkedOpenMPDeclareTargetEPKNS_4DeclEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter36DeclarationMarkedOpenMPDeclareTargetEPKNS_4DeclEPKNS_4AttrE")
  //</editor-fold>
  @Override public/*private*/ void DeclarationMarkedOpenMPDeclareTarget(/*const*/ Decl /*P*/ D, 
                                      /*const*/ Attr /*P*/ $Attr)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!D.isFromASTFile()) {
      return;
    }
    
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_DECL_MARKED_OPENMP_DECLARETARGET, $Attr));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::RedefinedHiddenDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5843,
   FQN="clang::ASTWriter::RedefinedHiddenDefinition", NM="_ZN5clang9ASTWriter25RedefinedHiddenDefinitionEPKNS_9NamedDeclEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter25RedefinedHiddenDefinitionEPKNS_9NamedDeclEPNS_6ModuleE")
  //</editor-fold>
  @Override public/*private*/ void RedefinedHiddenDefinition(/*const*/ NamedDecl /*P*/ D, Module /*P*/ M)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    assert (D.isHidden()) : "expected a hidden declaration";
    DeclUpdates.$at(D).push_back(new DeclUpdate(DeclUpdateKind.UPD_DECL_EXPORTED, M));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTWriter::AddedAttributeToRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5850,
   FQN="clang::ASTWriter::AddedAttributeToRecord", NM="_ZN5clang9ASTWriter22AddedAttributeToRecordEPKNS_4AttrEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang9ASTWriter22AddedAttributeToRecordEPKNS_4AttrEPKNS_10RecordDeclE")
  //</editor-fold>
  @Override public/*private*/ void AddedAttributeToRecord(/*const*/ Attr /*P*/ $Attr, 
                        /*const*/ RecordDecl /*P*/ Record)/* override*/ {
    if ((Chain != null) && Chain.isProcessingUpdateRecords()) {
      return;
    }
    assert (!WritingAST) : "Already writing the AST!";
    if (!Record.isFromASTFile()) {
      return;
    }
    DeclUpdates.$at(Record).push_back(new DeclUpdate(DeclUpdateKind.UPD_ADDED_ATTR_TO_RECORD, $Attr));
  }

  
  @Override public String toString() {
    return "" + "Stream=" + Stream // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", Chain=" + Chain // NOI18N
              + ", WritingModule=" + WritingModule // NOI18N
              + ", BaseDirectory=" + BaseDirectory // NOI18N
              + ", IncludeTimestamps=" + IncludeTimestamps // NOI18N
              + ", WritingAST=" + WritingAST // NOI18N
              + ", DoneWritingDeclsAndTypes=" + DoneWritingDeclsAndTypes // NOI18N
              + ", ASTHasCompilerErrors=" + ASTHasCompilerErrors // NOI18N
              + ", InputFileIDs=" + InputFileIDs // NOI18N
              + ", DeclTypesToEmit=" + DeclTypesToEmit // NOI18N
              + ", FirstDeclID=" + FirstDeclID // NOI18N
              + ", NextDeclID=" + NextDeclID // NOI18N
              + ", DeclIDs=" + "[DenseMapTypeUInt$Decl]" // NOI18N
              + ", DeclOffsets=" + DeclOffsets // NOI18N
              + ", FileDeclIDs=" + FileDeclIDs // NOI18N
              + ", FirstTypeID=" + FirstTypeID // NOI18N
              + ", NextTypeID=" + NextTypeID // NOI18N
              + ", TypeIdxs=" + TypeIdxs // NOI18N
              + ", TypeOffsets=" + TypeOffsets // NOI18N
              + ", FirstIdentID=" + FirstIdentID // NOI18N
              + ", NextIdentID=" + NextIdentID // NOI18N
              + ", IdentifierIDs=" + IdentifierIDs // NOI18N
              + ", FirstMacroID=" + FirstMacroID // NOI18N
              + ", NextMacroID=" + NextMacroID // NOI18N
              + ", MacroIDs=" + MacroIDs // NOI18N
              + ", MacroInfosToEmit=" + MacroInfosToEmit // NOI18N
              + ", IdentMacroDirectivesOffsetMap=" + IdentMacroDirectivesOffsetMap // NOI18N
              + ", ParentStmts=" + "[DenseSet$Stmt]" // NOI18N
              + ", SubStmtEntries=" + "[DenseMapTypeULong$Stmt]" // NOI18N
              + ", IdentifierOffsets=" + IdentifierOffsets // NOI18N
              + ", FirstSubmoduleID=" + FirstSubmoduleID // NOI18N
              + ", NextSubmoduleID=" + NextSubmoduleID // NOI18N
              + ", FirstSelectorID=" + FirstSelectorID // NOI18N
              + ", NextSelectorID=" + NextSelectorID // NOI18N
              + ", SelectorIDs=" + SelectorIDs // NOI18N
              + ", SelectorOffsets=" + SelectorOffsets // NOI18N
              + ", MacroDefinitions=" + MacroDefinitions // NOI18N
              + ", AnonymousDeclarationNumbers=" + "[DenseMapTypeUInt$Decl]" // NOI18N
              + ", DeclUpdates=" + DeclUpdates // NOI18N
              + ", FirstLatestDecls=" + "[DenseMap$Decl$Decl]" // NOI18N
              + ", EagerlyDeserializedDecls=" + EagerlyDeserializedDecls // NOI18N
              + ", UpdatedDeclContexts=" + "[SmallSetVector$DeclContext]" // NOI18N
              + ", UpdatingVisibleDecls=" + "[SmallVector$Decl]" // NOI18N
              + ", ObjCClassesWithCategories=" + "[SetVector$ObjCInterfaceDecl]" // NOI18N
              + ", Redeclarations=" + "[SmallVector$Decl]" // NOI18N
              + ", FirstLocalDeclCache=" + "[DenseMap$Decl$Decl]" // NOI18N
              + ", SwitchCaseIDs=" + SwitchCaseIDs // NOI18N
              + ", NumStatements=" + NumStatements // NOI18N
              + ", NumMacros=" + NumMacros // NOI18N
              + ", NumLexicalDeclContexts=" + NumLexicalDeclContexts // NOI18N
              + ", NumVisibleDeclContexts=" + NumVisibleDeclContexts // NOI18N
              + ", SubmoduleIDs=" + SubmoduleIDs // NOI18N
              + ", ModuleFileExtensionWriters=" + ModuleFileExtensionWriters // NOI18N
              + ", TypeExtQualAbbrev=" + TypeExtQualAbbrev // NOI18N
              + ", TypeFunctionProtoAbbrev=" + TypeFunctionProtoAbbrev // NOI18N
              + ", DeclParmVarAbbrev=" + DeclParmVarAbbrev // NOI18N
              + ", DeclContextLexicalAbbrev=" + DeclContextLexicalAbbrev // NOI18N
              + ", DeclContextVisibleLookupAbbrev=" + DeclContextVisibleLookupAbbrev // NOI18N
              + ", UpdateVisibleAbbrev=" + UpdateVisibleAbbrev // NOI18N
              + ", DeclRecordAbbrev=" + DeclRecordAbbrev // NOI18N
              + ", DeclTypedefAbbrev=" + DeclTypedefAbbrev // NOI18N
              + ", DeclVarAbbrev=" + DeclVarAbbrev // NOI18N
              + ", DeclFieldAbbrev=" + DeclFieldAbbrev // NOI18N
              + ", DeclEnumAbbrev=" + DeclEnumAbbrev // NOI18N
              + ", DeclObjCIvarAbbrev=" + DeclObjCIvarAbbrev // NOI18N
              + ", DeclCXXMethodAbbrev=" + DeclCXXMethodAbbrev // NOI18N
              + ", DeclRefExprAbbrev=" + DeclRefExprAbbrev // NOI18N
              + ", CharacterLiteralAbbrev=" + CharacterLiteralAbbrev // NOI18N
              + ", IntegerLiteralAbbrev=" + IntegerLiteralAbbrev // NOI18N
              + ", ExprImplicitCastAbbrev=" + ExprImplicitCastAbbrev // NOI18N
              + super.toString(); // NOI18N
  }
}
