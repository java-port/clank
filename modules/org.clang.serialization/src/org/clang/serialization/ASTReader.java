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
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
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
import org.clang.serialization.aliases.*;
import org.clang.serialization.impl.*;
import org.clang.serialization.reader.impl.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.serialization.SerializationGlobals.*;
import static org.clang.serialization.impl.ASTReaderDeclStatics.*;
import static org.clang.serialization.impl.ASTReaderStatics.*;
import static org.clang.serialization.impl.SerializationStatics.*;
import org.llvm.support.sys.path;
import static org.clang.ast.java.AstFunctionPointers.*;
import org.clang.basic.StringMapIteratorIdentifierInfo;
import org.clang.serialization.spi.PCHContainerReaderImplementation;
import org.clank.java.stdimpl.aliases.StdVector;
import static org.clang.lex.java.LexRTTI.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.ast.llvm.DenseMapInfoDeclarationName;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import org.clang.lex.frontend.IncludeDirGroup;
import static org.clank.java.std_pair.$first_uint;
import static org.llvm.support.zlib.ZlibGlobals.uncompress;
import org.llvm.support.zlib.Status;

// end namespace serialization
        
/// \brief Reads an AST files chain containing the contents of a translation
/// unit.
///
/// The ASTReader class reads bitstreams (produced by the ASTWriter
/// class) containing the serialized representation of a given
/// abstract syntax tree and its supporting data structures. An
/// instance of the ASTReader can be attached to an ASTContext object,
/// which will provide access to the contents of the AST files.
///
/// The AST reader provides lazy de-serialization of declarations, as
/// required when traversing the AST. Only those AST nodes that are
/// actually required will be de-serialized.
//<editor-fold defaultstate="collapsed" desc="clang::ASTReader">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 312,
 FQN="clang::ASTReader", NM="_ZN5clang9ASTReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReaderE")
//</editor-fold>
public class ASTReader extends /*public*/ ExternalSemaSource implements /*public*/ ExternalPreprocessorSource, /*public*/ ExternalPreprocessingRecordSource, /*public*/ ExternalHeaderFileInfoSource, /*public*/ IdentifierInfoLookup, /*public*/ ExternalSLocEntrySource, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef SmallVector<uint64_t, 64> RecordData
//  public final class RecordData extends SmallVectorULong{ };
  // JAVA: typedef SmallVectorImpl<uint64_t> RecordDataImpl
//  public final class RecordDataImpl extends SmallVectorImplULong{ };
  
  /// \brief The result of reading the control block of an AST file, which
  /// can fail for various reasons.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ASTReadResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 326,
   FQN="clang::ASTReader::ASTReadResult", NM="_ZN5clang9ASTReader13ASTReadResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13ASTReadResultE")
  //</editor-fold>
  public enum ASTReadResult implements Native.NativeUIntEnum {
    /// \brief The control block was read successfully. Aside from failures,
    /// the AST file is safe to read into the current context.
    Success(0),
    /// \brief The AST file itself appears corrupted.
    Failure(Success.getValue() + 1),
    /// \brief The AST file was missing.
    Missing(Failure.getValue() + 1),
    /// \brief The AST file is out-of-date relative to its input files,
    /// and needs to be regenerated.
    OutOfDate(Missing.getValue() + 1),
    /// \brief The AST file was written by a different version of Clang.
    VersionMismatch(OutOfDate.getValue() + 1),
    /// \brief The AST file was writtten with a different language/target
    /// configuration.
    ConfigurationMismatch(VersionMismatch.getValue() + 1),
    /// \brief The AST file has errors.
    HadErrors(ConfigurationMismatch.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ASTReadResult valueOf(int val) {
      ASTReadResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ASTReadResult[] VALUES;
      private static final ASTReadResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ASTReadResult kind : ASTReadResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ASTReadResult[min < 0 ? (1-min) : 0];
        VALUES = new ASTReadResult[max >= 0 ? (1+max) : 0];
        for (ASTReadResult kind : ASTReadResult.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ASTReadResult(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Types of AST files.
  /*friend  class PCHValidator*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTIdentifierIterator*/
  /*friend  class serialization::reader::ASTIdentifierLookupTrait*/
  /*friend  class TypeLocReader*/
  /*friend  class ASTWriter*/
  /*friend  class ASTUnit*/ // ASTUnit needs to remap source locations.
  /*friend  class serialization::ReadMethodPoolVisitor*/
  
  // JAVA: typedef serialization::ModuleFile ModuleFile
//  public final class ModuleFile extends ModuleFile{ };
  // JAVA: typedef serialization::ModuleKind ModuleKind
//  public final class ModuleKind extends ModuleKind{ };
  // JAVA: typedef serialization::ModuleManager ModuleManager
//  public final class ModuleManager extends ModuleManager{ };
  
  // JAVA: typedef ModuleManager::ModuleIterator ModuleIterator
//  public final class ModuleIterator extends type$ptr<ModuleFile /*P*/ /*P*/>{ };
  // JAVA: typedef ModuleManager::ModuleConstIterator ModuleConstIterator
//  public final class ModuleConstIterator extends type$ptr<ModuleFile /*P*/ /*P*/>{ };
  // JAVA: typedef ModuleManager::ModuleReverseIterator ModuleReverseIterator
//  public final class ModuleReverseIterator extends std.reverse_iterator<ModuleFile /*P*/ >{ };
/*private:*/
  /// \brief The receiver of some callbacks invoked by ASTReader.
  private std.unique_ptr<ASTReaderListener> Listener;
  
  /// \brief The receiver of deserialization events.
  /*friend*/public ASTDeserializationListener /*P*/ DeserializationListener;
  private boolean OwnsDeserializationListener;
  
  private final SourceManager /*&*/ SourceMgr;
  private final FileManager /*&*/ FileMgr;
  private final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr;
  /*friend*/public final DiagnosticsEngine /*&*/ Diags;
  
  /// \brief The semantic analysis object that will be processing the
  /// AST files and the translation unit that uses it.
  private Sema /*P*/ SemaObj;
  
  /// \brief The preprocessor that will be loading the source file.
  private final Preprocessor /*&*/ PP;
  
  /// \brief The AST context into which we'll read the AST files.
  /*friend*/public final ASTContext /*&*/ Context;
  
  /// \brief The AST consumer.
  private ASTConsumer /*P*/ Consumer;
  
  /// \brief The module manager which manages modules and their dependencies
  /*friend*/public ModuleManager ModuleMgr;
  
  /// \brief A dummy identifier resolver used to merge TU-scope declarations in
  /// C, for the cases where we don't have a Sema object to provide a real
  /// identifier resolver.
  private IdentifierResolver DummyIdResolver;
  
  /// A mapping from extension block names to module file extensions.
  private StringMap<IntrusiveRefCntPtr<ModuleFileExtension>> ModuleFileExtensions;
  
  /// \brief A timer used to track the time spent deserializing.
  private std.unique_ptr<Timer> ReadTimer;
  
  /// \brief The location where the module file will be considered as
  /// imported from. For non-module AST types it should be invalid.
  private SourceLocation CurrentImportLoc;
  
  /// \brief The global module index, if loaded.
  private std.unique_ptr<GlobalModuleIndex> GlobalIndex;
  
  /// \brief A map of global bit offsets to the module that stores entities
  /// at those bit offsets.
  private ContinuousRangeMapULongPtr<ModuleFile /*P*/ > GlobalBitOffsetsMap;
  
  /// \brief A map of negated SLocEntryIDs to the modules containing them.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalSLocEntryMap;
  
  // JAVA: typedef ContinuousRangeMap<unsigned int, ModuleFile *, 64> GlobalSLocOffsetMapType
//  public final class GlobalSLocOffsetMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief A map of reversed (SourceManager::MaxLoadedOffset - SLocOffset)
  /// SourceLocation offsets to the modules containing them.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalSLocOffsetMap;
  
  /// \brief Types that have already been loaded from the chain.
  ///
  /// When the pointer at index I is non-NULL, the type with
  /// ID = (I + 1) << FastQual::Width has already been loaded
  private std.vector<QualType> TypesLoaded;
  
  // JAVA: typedef ContinuousRangeMap<serialization::TypeID, ModuleFile *, 4> GlobalTypeMapType
//  public final class GlobalTypeMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global type IDs to the module in which the
  /// type resides along with the offset that should be added to the
  /// global type ID to produce a local ID.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalTypeMap;
  
  /// \brief Declarations that have already been loaded from the chain.
  ///
  /// When the pointer at index I is non-NULL, the declaration with ID
  /// = I + 1 has already been loaded.
  private std.vector<Decl /*P*/ > DeclsLoaded;
  
  // JAVA: typedef ContinuousRangeMap<serialization::DeclID, ModuleFile *, 4> GlobalDeclMapType
//  public final class GlobalDeclMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global declaration IDs to the module in which the
  /// declaration resides.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalDeclMap;
  
  // JAVA: typedef std::pair<ModuleFile *, uint64_t> FileOffset
//  public final class FileOffset extends std.pairPtrULong<ModuleFile /*P*/ >{ };
  // JAVA: typedef SmallVector<FileOffset, 2> FileOffsetsTy
//  public final class FileOffsetsTy extends SmallVector<std.pairPtrULong<ModuleFile /*P*/ >>{ };
  // JAVA: typedef llvm::DenseMap<serialization::DeclID, FileOffsetsTy> DeclUpdateOffsetsMap
//  public final class DeclUpdateOffsetsMap extends DenseMapUIntType<SmallVector<std.pairPtrULong<ModuleFile /*P*/ >>>{ };
  
  /// \brief Declarations that have modifications residing in a later file
  /// in the chain.
  private DenseMapUIntType<SmallVector<std.pairPtrULong<ModuleFile /*P*/ >>> DeclUpdateOffsets;
  
  /// \brief Declaration updates for already-loaded declarations that we need
  /// to apply once we finish processing an import.
  private SmallVector<std.pairUIntPtr<Decl /*P*/ >> PendingUpdateRecords;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingFakeDefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 466,
   FQN="clang::ASTReader::PendingFakeDefinitionKind", NM="_ZN5clang9ASTReader25PendingFakeDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25PendingFakeDefinitionKindE")
  //</editor-fold>
  /*friend*/public enum /*class */PendingFakeDefinitionKind/* : int*/ implements Native.NativeIntEnum {
    NotFake(0),
    Fake(NotFake.getValue() + 1),
    FakeLoaded(Fake.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PendingFakeDefinitionKind valueOf(int val) {
      PendingFakeDefinitionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PendingFakeDefinitionKind[] VALUES;
      private static final PendingFakeDefinitionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PendingFakeDefinitionKind kind : PendingFakeDefinitionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PendingFakeDefinitionKind[min < 0 ? (1-min) : 0];
        VALUES = new PendingFakeDefinitionKind[max >= 0 ? (1+max) : 0];
        for (PendingFakeDefinitionKind kind : PendingFakeDefinitionKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final int value;
    private PendingFakeDefinitionKind(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The DefinitionData pointers that we faked up for class definitions
  /// that we needed but hadn't loaded yet.
  /*friend*/public DenseMap<Object/*void P*/ , PendingFakeDefinitionKind> PendingFakeDefinitionData;
  
  /// \brief Exception specification updates that have been loaded but not yet
  /// propagated across the relevant redeclaration chain. The map key is the
  /// canonical declaration (used only for deduplication) and the value is a
  /// declaration that has an exception specification.
  /*friend*/public SmallMapVectorPtrPtr<Decl /*P*/ , FunctionDecl /*P*/ > PendingExceptionSpecUpdates;
  
  /// \brief Declarations that have been imported and have typedef names for
  /// linkage purposes.
  /*friend*/public DenseMap<std.pairPtrPtr<DeclContext /*P*/ , IdentifierInfo /*P*/ >, NamedDecl /*P*/ > ImportedTypedefNamesForLinkage;
  
  /// \brief Mergeable declaration contexts that have anonymous declarations
  /// within them, and those anonymous declarations.
  /*friend*/public DenseMap<DeclContext /*P*/ , SmallVector<NamedDecl /*P*/ >> AnonymousDeclarationsForMerging;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FileDeclsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 488,
   FQN="clang::ASTReader::FileDeclsInfo", NM="_ZN5clang9ASTReader13FileDeclsInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13FileDeclsInfoE")
  //</editor-fold>
  private static class/*struct*/ FileDeclsInfo implements NativePOD<FileDeclsInfo> {
    public ModuleFile /*P*/ Mod;
    public ArrayRefUInt Decls;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FileDeclsInfo::FileDeclsInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 492,
     FQN="clang::ASTReader::FileDeclsInfo::FileDeclsInfo", NM="_ZN5clang9ASTReader13FileDeclsInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13FileDeclsInfoC1Ev")
    //</editor-fold>
    public FileDeclsInfo() {
      // : Mod(null), Decls() 
      //START JInit
      this.Mod = null;
      this.Decls = new ArrayRefUInt();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FileDeclsInfo::FileDeclsInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 493,
     FQN="clang::ASTReader::FileDeclsInfo::FileDeclsInfo", NM="_ZN5clang9ASTReader13FileDeclsInfoC1EPNS_13serialization10ModuleFileEN4llvm8ArrayRefIjEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13FileDeclsInfoC1EPNS_13serialization10ModuleFileEN4llvm8ArrayRefIjEE")
    //</editor-fold>
    public FileDeclsInfo(ModuleFile /*P*/ Mod, ArrayRefUInt Decls) {
      // : Mod(Mod), Decls(Decls) 
      //START JInit
      this.Mod = Mod;
      this.Decls = new ArrayRefUInt(Decls);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FileDeclsInfo::FileDeclsInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 488,
     FQN="clang::ASTReader::FileDeclsInfo::FileDeclsInfo", NM="_ZN5clang9ASTReader13FileDeclsInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13FileDeclsInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ FileDeclsInfo(final /*const*/ FileDeclsInfo /*&*/ $Prm0) {
      // : Mod(.Mod), Decls(.Decls) 
      //START JInit
      this.Mod = $Prm0.Mod;
      this.Decls = new ArrayRefUInt($Prm0.Decls);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FileDeclsInfo::FileDeclsInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 488,
     FQN="clang::ASTReader::FileDeclsInfo::FileDeclsInfo", NM="_ZN5clang9ASTReader13FileDeclsInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13FileDeclsInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ FileDeclsInfo(JD$Move _dparam, final FileDeclsInfo /*&&*/$Prm0) {
      // : Mod(static_cast<FileDeclsInfo &&>().Mod), Decls(static_cast<FileDeclsInfo &&>().Decls) 
      //START JInit
      this.Mod = $Prm0.Mod;
      this.Decls = new ArrayRefUInt(JD$Move.INSTANCE, $Prm0.Decls);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FileDeclsInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 488,
     FQN="clang::ASTReader::FileDeclsInfo::operator=", NM="_ZN5clang9ASTReader13FileDeclsInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13FileDeclsInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ FileDeclsInfo /*&*/ $assignMove(final FileDeclsInfo /*&&*/$Prm0) {
      this.Mod = $Prm0.Mod;
      this.Decls.$assignMove($Prm0.Decls);
      return /*Deref*/this;
    }

    @Override
    public FileDeclsInfo $assign(FileDeclsInfo $Prm0) {
      this.Mod = $Prm0.Mod;
      this.Decls.$assign($Prm0.Decls);
      return this;
    }

    @Override
    public FileDeclsInfo clone() {
      return new FileDeclsInfo(Mod, Decls);
    }
    
    @Override public String toString() {
      return "" + "Mod=" + Mod // NOI18N
                + ", Decls=" + Decls; // NOI18N
    }
  };
  
  /// \brief Map from a FileID to the file-level declarations that it contains.
  private DenseMap<FileID, FileDeclsInfo> FileDeclIDs;
  
  /// \brief An array of lexical contents of a declaration context, as a sequence of
  /// Decl::Kind, DeclID pairs.
  // JAVA: typedef ArrayRef<llvm::support::unaligned_uint32_t> LexicalContents
//  public final class LexicalContents extends ArrayRef<packed_endian_specific_integral</*uint32_t*/Integer>>{ };
  
  /// \brief Map from a DeclContext to its lexical contents.
  private DenseMap</*const*/ DeclContext /*P*/ , std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/>> LexicalDecls;
  
  /// \brief Map from the TU to its lexical contents from each module file.
  private std.vector<std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/>> TULexicalDecls;
  
  /// \brief Map from a DeclContext to its lookup tables.
  /*friend*/public DenseMap</*const*/ DeclContext /*P*/ , DeclContextLookupTable> Lookups;
  
  // Updates for visible decls can occur for other contexts than just the
  // TU, and when we read those update records, the actual context may not
  // be available yet, so have this pending map using the ID as a key. It
  // will be realized when the context is actually loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingVisibleUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 519,
   FQN="clang::ASTReader::PendingVisibleUpdate", NM="_ZN5clang9ASTReader20PendingVisibleUpdateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20PendingVisibleUpdateE")
  //</editor-fold>
  private static class/*struct*/ PendingVisibleUpdate {
    public ModuleFile /*P*/ Mod;
    public /*const*/char$ptr/*uchar P*/ Data;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

      public PendingVisibleUpdate(ModuleFile Mod, char$ptr Data) {
        this.Mod = Mod;
        this.Data = Data;
      }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Mod=" + Mod // NOI18N
                + ", Data=" + Data; // NOI18N
    }
  };
  // JAVA: typedef SmallVector<PendingVisibleUpdate, 1> DeclContextVisibleUpdates
//  public final class DeclContextVisibleUpdates extends SmallVector<PendingVisibleUpdate>{ };
  
  /// \brief Updates to the visible declarations of declaration contexts that
  /// haven't been loaded yet.
  private DenseMapUIntType<SmallVector<PendingVisibleUpdate>> PendingVisibleUpdates;
  
  /// \brief The set of C++ or Objective-C classes that have forward 
  /// declarations that have not yet been linked to their definitions.
  /*friend*/public SmallPtrSet<Decl /*P*/ > PendingDefinitions;
  
  // JAVA: typedef llvm::MapVector<Decl *, uint64_t, llvm::SmallDenseMap<Decl *, unsigned int, 4>, SmallVector<std::pair<Decl *, uint64_t>, 4> > PendingBodiesMap
//  public final class PendingBodiesMap extends MapVectorPtrULong<Decl /*P*/ >{ };
  
  /// \brief Functions or methods that have bodies that will be attached.
  /*friend*/public MapVectorPtrULong<Decl /*P*/ > PendingBodies;
  
  /// \brief Definitions for which we have added merged definitions but not yet
  /// performed deduplication.
  /*friend*/public SetVector<NamedDecl /*P*/ > PendingMergedDefinitionsToDeduplicate;
  
  /// \brief Read the record that describes the lexical contents of a DC.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadLexicalDeclContextStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 987,
   FQN="clang::ASTReader::ReadLexicalDeclContextStorage", NM="_ZN5clang9ASTReader29ReadLexicalDeclContextStorageERNS_13serialization10ModuleFileERN4llvm15BitstreamCursorEyPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader29ReadLexicalDeclContextStorageERNS_13serialization10ModuleFileERN4llvm15BitstreamCursorEyPNS_11DeclContextE")
  //</editor-fold>
  /*friend*/public boolean ReadLexicalDeclContextStorage(final ModuleFile /*&*/ M, 
                               final BitstreamCursor /*&*/ Cursor, 
                               long/*uint64_t*/ Offset, 
                               DeclContext /*P*/ DC) {
    SavedStreamPosition SavedPosition = null;
    try {
      assert (Offset != $int2ullong(0));
      
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(Offset);
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      StringRef Blob/*J*/= new StringRef();
      /*uint*/int Code = Cursor.ReadCode();
      /*uint*/int RecCode = Cursor.readRecord(Code, Record, $AddrOf(Blob));
      if (RecCode != DeclCode.DECL_CONTEXT_LEXICAL) {
        Error(new StringRef(/*KEEP_STR*/"Expected lexical block"));
        return true;
      }
      assert (!isa_TranslationUnitDecl(DC)) : "expected a TU_UPDATE_LEXICAL record for TU";
      // If we are handling a C++ class template instantiation, we can see multiple
      // lexical updates for the same record. It's important that we select only one
      // of them, so that field numbering works properly. Just pick the first one we
      // see.
      final type$ref<pairPtrType<ModuleFile, ArrayRefUInt/*<unaligned_uint32_t>*/>> /*&*/ Lex = LexicalDecls.ref$at(DC);
      if (!(Lex.$deref().first != null)) {
        pairPtrType<ModuleFile, ArrayRefUInt/*<unaligned_uint32_t>*/> make_pair_Ptr_T = 
                std.make_pair_Ptr_T($AddrOf(M), $Move(llvm.makeArrayRef(((/*const*/ /*unaligned_uint32_t*/uint$ptr /*P*/ )$toConst(reinterpret_cast(
                uint$ptr.class, Blob.data()))), $div_uint(Blob.size(), 4))));
        Lex.$set(make_pair_Ptr_T);
        //Lex.$assignMove(std.make_pair_Ptr_T($AddrOf(M), $Move(llvm.makeArrayRef(((/*const*/ type$ptr<unaligned_uint32_t> /*P*/ )reinterpret_cast(type$ptr.class, Blob.data())), $div_uint(Blob.size(), 4)))));
      }
      DC.setHasExternalLexicalStorage(true);
      return false;
    } finally {
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  /// \brief Read the record that describes the visible contents of a DC.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadVisibleDeclContextStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1023,
   FQN="clang::ASTReader::ReadVisibleDeclContextStorage", NM="_ZN5clang9ASTReader29ReadVisibleDeclContextStorageERNS_13serialization10ModuleFileERN4llvm15BitstreamCursorEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader29ReadVisibleDeclContextStorageERNS_13serialization10ModuleFileERN4llvm15BitstreamCursorEyj")
  //</editor-fold>
  private boolean ReadVisibleDeclContextStorage(final ModuleFile /*&*/ M, 
                               final BitstreamCursor /*&*/ Cursor, 
                               long/*uint64_t*/ Offset, 
                               /*uint32_t*/int ID) {
    SavedStreamPosition SavedPosition = null;
    try {
      assert (Offset != $int2ullong(0));
      
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(Offset);
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      StringRef Blob/*J*/= new StringRef();
      /*uint*/int Code = Cursor.ReadCode();
      /*uint*/int RecCode = Cursor.readRecord(Code, Record, $AddrOf(Blob));
      if (RecCode != DeclCode.DECL_CONTEXT_VISIBLE) {
        Error(new StringRef(/*KEEP_STR*/"Expected visible lookup table block"));
        return true;
      }
      
      // We can't safely determine the primary context yet, so delay attaching the
      // lookup table until we're done with recursive deserialization.
      /*const*/char$ptr/*uchar P*/ Data = $toConst($tryClone(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data())));
      PendingVisibleUpdates.$at_T1$C$R(ID).push_back(((PendingVisibleUpdate)(new PendingVisibleUpdate($AddrOf(M), Data))));
      return false;
    } finally {
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  
  /// \brief A vector containing identifiers that have already been
  /// loaded.
  ///
  /// If the pointer at index I is non-NULL, then it refers to the
  /// IdentifierInfo for the identifier with ID=I+1 that has already
  /// been loaded.
  private std.vector<IdentifierInfo /*P*/ > IdentifiersLoaded;
  
  // JAVA: typedef ContinuousRangeMap<serialization::IdentID, ModuleFile *, 4> GlobalIdentifierMapType
//  public final class GlobalIdentifierMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global identifier IDs to the module in which the
  /// identifier resides along with the offset that should be added to the
  /// global identifier ID to produce a local ID.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalIdentifierMap;
  
  /// \brief A vector containing macros that have already been
  /// loaded.
  ///
  /// If the pointer at index I is non-NULL, then it refers to the
  /// MacroInfo for the identifier with ID=I+1 that has already
  /// been loaded.
  private std.vector<MacroInfo /*P*/ > MacrosLoaded;
  
  // JAVA: typedef std::pair<IdentifierInfo *, serialization::SubmoduleID> LoadedMacroInfo
//  public final class LoadedMacroInfo extends std.pairPtrUInt<IdentifierInfo /*P*/ >{ };
  
  /// \brief A set of #undef directives that we have loaded; used to
  /// deduplicate the same #undef information coming from multiple module
  /// files.
  private DenseSet<std.pairPtrUInt<IdentifierInfo /*P*/ >> LoadedUndefs;
  
  // JAVA: typedef ContinuousRangeMap<serialization::MacroID, ModuleFile *, 4> GlobalMacroMapType
//  public final class GlobalMacroMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global macro IDs to the module in which the
  /// macro resides along with the offset that should be added to the
  /// global macro ID to produce a local ID.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalMacroMap;
  
  /// \brief A vector containing submodules that have already been loaded.
  ///
  /// This vector is indexed by the Submodule ID (-1). NULL submodule entries
  /// indicate that the particular submodule ID has not yet been loaded.
  private SmallVector<Module /*P*/> SubmodulesLoaded;
  
  // JAVA: typedef ContinuousRangeMap<serialization::SubmoduleID, ModuleFile *, 4> GlobalSubmoduleMapType
//  public final class GlobalSubmoduleMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global submodule IDs to the module file in which the
  /// submodule resides along with the offset that should be added to the
  /// global submodule ID to produce a local ID.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalSubmoduleMap;
  
  /// \brief A set of hidden declarations.
  // JAVA: typedef SmallVector<Decl *, 2> HiddenNames
//  public final class HiddenNames extends SmallVector<Decl /*P*/>{ };
  // JAVA: typedef llvm::DenseMap<Module *, HiddenNames> HiddenNamesMapType
//  public final class HiddenNamesMapType extends DenseMap<Module /*P*/ , SmallVector<Decl /*P*/>>{ };
  
  /// \brief A mapping from each of the hidden submodules to the deserialized
  /// declarations in that submodule that could be made visible.
  /*friend*/public DenseMapPtrType<Module /*P*/ , SmallVector<Decl /*P*/>> HiddenNamesMap;
  
  /// \brief A module import, export, or conflict that hasn't yet been resolved.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::UnresolvedModuleRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 619,
   FQN="clang::ASTReader::UnresolvedModuleRef", NM="_ZN5clang9ASTReader19UnresolvedModuleRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19UnresolvedModuleRefE")
  //</editor-fold>
  private static class/*struct*/ UnresolvedModuleRef implements NativeCloneable<UnresolvedModuleRef> {
    /// \brief The file in which this module resides.
    public ModuleFile /*P*/ File;
    
    /// \brief The module that is importing or exporting.
    public Module /*P*/ Mod;
    
    /// \brief The kind of module reference.
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::UnresolvedModuleRef::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 627,
     FQN="clang::ASTReader::UnresolvedModuleRef::(anonymous)", NM="_ZN5clang9ASTReader19UnresolvedModuleRefE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19UnresolvedModuleRefE_Unnamed_enum")
    //</editor-fold>
    public enum Unnamed_enum implements Native.NativeUIntEnum {
      Import(0),
      Export(Import.getValue() + 1),
      Conflict(Export.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Unnamed_enum valueOf(int val) {
        Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Unnamed_enum[] VALUES;
        private static final Unnamed_enum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
          VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    public Unnamed_enum Kind = Unnamed_enum.valueOf(0);
    
    /// \brief The local ID of the module that is being exported.
    public /*uint*/int ID;
    
    /// \brief Whether this is a wildcard export.
    public /*JBIT unsigned int*/ boolean IsWildcard /*: 1*/;
    
    /// \brief String data.
    public StringRef String;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::UnresolvedModuleRef::UnresolvedModuleRef">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 619,
     FQN="clang::ASTReader::UnresolvedModuleRef::UnresolvedModuleRef", NM="_ZN5clang9ASTReader19UnresolvedModuleRefC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19UnresolvedModuleRefC1Ev")
    //</editor-fold>
    public /*inline*/ UnresolvedModuleRef() {
      // : String() 
      //START JInit
      this.String = new StringRef();
      //END JInit
    }

    public UnresolvedModuleRef(UnresolvedModuleRef $Prm0) {
      this.File = $Prm0.File;
      this.Mod = $Prm0.Mod;
      this.Kind = $Prm0.Kind;
      this.ID = $Prm0.ID;
      this.IsWildcard = $Prm0.IsWildcard;
      this.String = new StringRef($Prm0.String);
    }

    @Override
    public UnresolvedModuleRef clone() {
      return new UnresolvedModuleRef(this);
    }

    
    @Override public String toString() {
      return "" + "File=" + File // NOI18N
                + ", Mod=" + Mod // NOI18N
                + ", Kind=" + Kind // NOI18N
                + ", ID=" + ID // NOI18N
                + ", IsWildcard=" + IsWildcard // NOI18N
                + ", String=" + String; // NOI18N
    }
  };
  
  /// \brief The set of module imports and exports that still need to be 
  /// resolved.
  private SmallVector<UnresolvedModuleRef> UnresolvedModuleRefs;
  
  /// \brief A vector containing selectors that have already been loaded.
  ///
  /// This vector is indexed by the Selector ID (-1). NULL selector
  /// entries indicate that the particular selector ID has not yet
  /// been loaded.
  private SmallVector<Selector> SelectorsLoaded;
  
  // JAVA: typedef ContinuousRangeMap<serialization::SelectorID, ModuleFile *, 4> GlobalSelectorMapType
//  public final class GlobalSelectorMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global selector IDs to the module in which the
  
  /// global selector ID to produce a local ID.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalSelectorMap;
  
  /// \brief The generation number of the last time we loaded data from the
  /// global method pool for this selector.
  private DenseMapTypeUInt<Selector> SelectorGeneration;
  
  /// Whether a selector is out of date. We mark a selector as out of date
  /// if we load another module after the method pool entry was pulled in.
  private DenseMapTypeBool<Selector> SelectorOutOfDate;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingMacroInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 666,
   FQN="clang::ASTReader::PendingMacroInfo", NM="_ZN5clang9ASTReader16PendingMacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16PendingMacroInfoE")
  //</editor-fold>
  private static class/*struct*/ PendingMacroInfo implements NativePOD<PendingMacroInfo> {
    public ModuleFile /*P*/ M;
    public long/*uint64_t*/ MacroDirectivesOffset;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingMacroInfo::PendingMacroInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 670,
     FQN="clang::ASTReader::PendingMacroInfo::PendingMacroInfo", NM="_ZN5clang9ASTReader16PendingMacroInfoC1EPNS_13serialization10ModuleFileEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16PendingMacroInfoC1EPNS_13serialization10ModuleFileEy")
    //</editor-fold>
    public PendingMacroInfo(ModuleFile /*P*/ M, long/*uint64_t*/ MacroDirectivesOffset) {
      // : M(M), MacroDirectivesOffset(MacroDirectivesOffset) 
      //START JInit
      this.M = M;
      this.MacroDirectivesOffset = MacroDirectivesOffset;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingMacroInfo::PendingMacroInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 666,
     FQN="clang::ASTReader::PendingMacroInfo::PendingMacroInfo", NM="_ZN5clang9ASTReader16PendingMacroInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16PendingMacroInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ PendingMacroInfo(JD$Move _dparam, final PendingMacroInfo /*&&*/$Prm0) {
      // : M(static_cast<PendingMacroInfo &&>().M), MacroDirectivesOffset(static_cast<PendingMacroInfo &&>().MacroDirectivesOffset) 
      //START JInit
      this.M = $Prm0.M;
      this.MacroDirectivesOffset = $Prm0.MacroDirectivesOffset;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingMacroInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 666,
     FQN="clang::ASTReader::PendingMacroInfo::operator=", NM="_ZN5clang9ASTReader16PendingMacroInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16PendingMacroInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ PendingMacroInfo /*&*/ $assign(final /*const*/ PendingMacroInfo /*&*/ $Prm0) {
      this.M = $Prm0.M;
      this.MacroDirectivesOffset = $Prm0.MacroDirectivesOffset;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingMacroInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 666,
     FQN="clang::ASTReader::PendingMacroInfo::operator=", NM="_ZN5clang9ASTReader16PendingMacroInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16PendingMacroInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ PendingMacroInfo /*&*/ $assignMove(final PendingMacroInfo /*&&*/$Prm0) {
      this.M = $Prm0.M;
      this.MacroDirectivesOffset = $Prm0.MacroDirectivesOffset;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public PendingMacroInfo() { 
    }

    @Override public PendingMacroInfo clone() {
      return new PendingMacroInfo().$assign(this);
    }
    
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "M=" + M // NOI18N
                + ", MacroDirectivesOffset=" + MacroDirectivesOffset; // NOI18N
    }
  };
  
  // JAVA: typedef llvm::MapVectorPtrType<IdentifierInfo *, SmallVector<PendingMacroInfo, 2> > PendingMacroIDsMap
//  public final class PendingMacroIDsMap extends MapVectorPtrType<IdentifierInfo /*P*/ , SmallVector<PendingMacroInfo> >{ };
  
  /// \brief Mapping from identifiers that have a macro history to the global
  /// IDs have not yet been deserialized to the global IDs of those macros.
  private MapVectorPtrType<IdentifierInfo /*P*/ , SmallVector<PendingMacroInfo> > PendingMacroIDs;
  
  // JAVA: typedef ContinuousRangeMap<unsigned int, ModuleFile *, 4> GlobalPreprocessedEntityMapType
//  public final class GlobalPreprocessedEntityMapType extends ContinuousRangeMapUInt<ModuleFile /*P*/ >{ };
  
  /// \brief Mapping from global preprocessing entity IDs to the module in
  /// which the preprocessed entity resides along with the offset that should be
  /// added to the global preprocessing entitiy ID to produce a local ID.
  private ContinuousRangeMapUIntPtr<ModuleFile /*P*/ > GlobalPreprocessedEntityMap;
  
  /// \name CodeGen-relevant special data
  /// \brief Fields containing data that is relevant to CodeGen.
  //@{
  
  /// \brief The IDs of all declarations that fulfill the criteria of
  /// "interesting" decls.
  ///
  /// This contains the data loaded from all EAGERLY_DESERIALIZED_DECLS blocks
  /// in the chain. The referenced declarations are deserialized and passed to
  /// the consumer eagerly.
  private SmallVectorULong EagerlyDeserializedDecls;
  
  /// \brief The IDs of all tentative definitions stored in the chain.
  ///
  /// Sema keeps track of all tentative definitions in a TU because it has to
  /// complete them and pass them on to CodeGen. Thus, tentative definitions in
  /// the PCH chain must be eagerly deserialized.
  private SmallVectorULong TentativeDefinitions;
  
  /// \brief The IDs of all CXXRecordDecls stored in the chain whose VTables are
  /// used.
  ///
  /// CodeGen has to emit VTables for these records, so they have to be eagerly
  /// deserialized.
  private SmallVectorULong VTableUses;
  
  /// \brief A snapshot of the pending instantiations in the chain.
  ///
  /// This record tracks the instantiations that Sema has to perform at the
  /// end of the TU. It consists of a pair of values for every pending
  /// instantiation where the first value is the ID of the decl and the second
  /// is the instantiation location.
  private SmallVectorULong PendingInstantiations;
  
  //@}
  
  /// \name DiagnosticsEngine-relevant special data
  /// \brief Fields containing data that is used for generating diagnostics
  //@{
  
  /// \brief A snapshot of Sema's unused file-scoped variable tracking, for
  /// generating warnings.
  private SmallVectorULong UnusedFileScopedDecls;
  
  /// \brief A list of all the delegating constructors we've seen, to diagnose
  /// cycles.
  private SmallVectorULong DelegatingCtorDecls;
  
  /// \brief Method selectors used in a @selector expression. Used for
  /// implementation of -Wselector.
  private SmallVectorULong ReferencedSelectorsData;
  
  /// \brief A snapshot of Sema's weak undeclared identifier tracking, for
  /// generating warnings.
  private SmallVectorULong WeakUndeclaredIdentifiers;
  
  /// \brief The IDs of type aliases for ext_vectors that exist in the chain.
  ///
  /// Used by Sema for finding sugared names for ext_vectors in diagnostics.
  private SmallVectorULong ExtVectorDecls;
  
  //@}
  
  /// \name Sema-relevant special data
  /// \brief Fields containing data that is used for semantic analysis
  //@{
  
  /// \brief The IDs of all potentially unused typedef names in the chain.
  ///
  /// Sema tracks these to emit warnings.
  private SmallVectorULong UnusedLocalTypedefNameCandidates;
  
  /// \brief The IDs of the declarations Sema stores directly.
  ///
  /// Sema tracks a few important decls, such as namespace std, directly.
  private SmallVectorULong SemaDeclRefs;
  
  /// \brief The IDs of the types ASTContext stores directly.
  ///
  /// The AST context tracks a few important types, such as va_list, directly.
  private SmallVectorULong SpecialTypes;
  
  /// \brief The IDs of CUDA-specific declarations ASTContext stores directly.
  ///
  /// The AST context tracks a few important decls, currently cudaConfigureCall,
  /// directly.
  private SmallVectorULong CUDASpecialDeclRefs;
  
  /// \brief The floating point pragma option settings.
  private SmallVectorULong FPPragmaOptions;
  
  /// \brief The pragma clang optimize location (if the pragma state is "off").
  private SourceLocation OptimizeOffPragmaLocation;
  
  /// \brief The PragmaMSStructKind pragma ms_struct state if set, or -1.
  private int PragmaMSStructState;
  
  /// \brief The PragmaMSPointersToMembersKind pragma pointers_to_members state.
  private int PragmaMSPointersToMembersState;
  private SourceLocation PointersToMembersPragmaLocation;
  
  /// \brief The OpenCL extension settings.
  private SmallVectorULong OpenCLExtensions;
  
  /// \brief A list of the namespaces we've seen.
  private SmallVectorULong KnownNamespaces;
  
  /// \brief A list of undefined decls with internal linkage followed by the
  /// SourceLocation of a matching ODR-use.
  private SmallVectorULong UndefinedButUsed;
  
  /// \brief Delete expressions to analyze at the end of translation unit.
  private SmallVectorULong DelayedDeleteExprs;
  
  // \brief A list of late parsed template function data.
  private SmallVectorULong LateParsedTemplates;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ImportedSubmodule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 806,
   FQN="clang::ASTReader::ImportedSubmodule", NM="_ZN5clang9ASTReader17ImportedSubmoduleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17ImportedSubmoduleE")
  //</editor-fold>
  private static class/*struct*/ ImportedSubmodule implements NativeCloneable<ImportedSubmodule> {
    public /*uint32_t*/int ID;
    public SourceLocation ImportLoc;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ImportedSubmodule::ImportedSubmodule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 810,
     FQN="clang::ASTReader::ImportedSubmodule::ImportedSubmodule", NM="_ZN5clang9ASTReader17ImportedSubmoduleC1EjNS_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17ImportedSubmoduleC1EjNS_14SourceLocationE")
    //</editor-fold>
    public ImportedSubmodule(/*uint32_t*/int ID, SourceLocation ImportLoc) {
      // : ID(ID), ImportLoc(ImportLoc) 
      //START JInit
      this.ID = ID;
      this.ImportLoc = new SourceLocation(ImportLoc);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ImportedSubmodule() {
      this.ID = 0;
      this.ImportLoc = new SourceLocation();
    }

    @Override
    public ImportedSubmodule clone() {
      return new ImportedSubmodule(this.ID, this.ImportLoc);
    }

    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "ID=" + ID // NOI18N
                + ", ImportLoc=" + ImportLoc; // NOI18N
    }
  };
  
  /// \brief A list of modules that were imported by precompiled headers or
  /// any other non-module AST file.
  private SmallVector<ImportedSubmodule> ImportedModules;
  //@}
  
  /// \brief The directory that the PCH we are reading is stored in.
  private std.string CurrentDir;
  
  /// \brief The system include root to be used when loading the
  /// precompiled header.
  private std.string isysroot;
  
  /// \brief Whether to disable the normal validation performed on precompiled
  /// headers when they are loaded.
  private boolean DisableValidation;
  
  /// \brief Whether to accept an AST file with compiler errors.
  private boolean AllowASTWithCompilerErrors;
  
  /// \brief Whether to accept an AST file that has a different configuration
  /// from the current compiler instance.
  private boolean AllowConfigurationMismatch;
  
  /// \brief Whether validate system input files.
  private boolean ValidateSystemInputs;
  
  /// \brief Whether we are allowed to use the global module index.
  private boolean UseGlobalIndex;
  
  /// \brief Whether we have tried loading the global module index yet.
  private boolean TriedLoadingGlobalIndex;
  
  ///\brief Whether we are currently processing update records.
  private boolean ProcessingUpdateRecords;
  
  // JAVA: typedef llvm::DenseMap<unsigned int, SwitchCase *> SwitchCaseMapTy
//  public final class SwitchCaseMapTy extends DenseMapUIntType<SwitchCase /*P*/ >{ };
  /// \brief Mapping from switch-case IDs in the chain to switch-case statements
  ///
  /// Statements usually don't have IDs, but switch cases need them, so that the
  /// switch statement can refer to them.
  private DenseMapUIntType<SwitchCase /*P*/ > SwitchCaseStmts;
  
  private DenseMapUIntType<SwitchCase /*P*/ > /*P*/ CurrSwitchCaseStmts;
  
  /// \brief The number of source location entries de-serialized from
  /// the PCH file.
  private /*uint*/int NumSLocEntriesRead;
  
  /// \brief The number of source location entries in the chain.
  private /*uint*/int TotalNumSLocEntries;
  
  /// \brief The number of statements (and expressions) de-serialized
  /// from the chain.
  private /*uint*/int NumStatementsRead;
  
  /// \brief The total number of statements (and expressions) stored
  /// in the chain.
  private /*uint*/int TotalNumStatements;
  
  /// \brief The number of macros de-serialized from the chain.
  private /*uint*/int NumMacrosRead;
  
  /// \brief The total number of macros stored in the chain.
  private /*uint*/int TotalNumMacros;
  
  /// \brief The number of lookups into identifier tables.
  private /*uint*/int NumIdentifierLookups;
  
  /// \brief The number of lookups into identifier tables that succeed.
  private /*uint*/int NumIdentifierLookupHits;

  /// \brief The number of selectors that have been read.
  /*friend*/public /*uint*/int NumSelectorsRead;
  
  /// \brief The number of method pool entries that have been read.
  /*friend*/public /*uint*/int NumMethodPoolEntriesRead;
  
  /// \brief The number of times we have looked up a selector in the method
  /// pool.
  private /*uint*/int NumMethodPoolLookups;
  
  /// \brief The number of times we have looked up a selector in the method
  /// pool and found something.
  private /*uint*/int NumMethodPoolHits;
  
  /// \brief The number of times we have looked up a selector in the method
  /// pool within a specific module.
  /*friend*/public /*uint*/int NumMethodPoolTableLookups;
  
  /// \brief The number of times we have looked up a selector in the method
  /// pool within a specific module and found something.
  /*friend*/public /*uint*/int NumMethodPoolTableHits;
  
  /// \brief The total number of method pool entries in the selector table.
  private /*uint*/int TotalNumMethodPoolEntries;
  
  /// Number of lexical decl contexts read/total.
  private /*uint*/int NumLexicalDeclContextsRead;
  private /*uint*/int TotalLexicalDeclContexts;
  
  /// Number of visible decl contexts read/total.
  private /*uint*/int NumVisibleDeclContextsRead;
  private /*uint*/int TotalVisibleDeclContexts;
  
  /// Total size of modules, in bits, currently loaded
  private long/*uint64_t*/ TotalModulesSizeInBits;
  
  /// \brief Number of Decl/types that are currently deserializing.
  private /*uint*/int NumCurrentElementsDeserializing;
  
  /// \brief Set true while we are in the process of passing deserialized
  /// "interesting" decls to consumer inside FinishedDeserializing().
  /// This is used as a guard to avoid recursively repeating the process of
  /// passing decls to consumer.
  private boolean PassingDeclsToConsumer;
  
  /// \brief The set of identifiers that were read while the AST reader was
  /// (recursively) loading declarations.
  ///
  /// The declarations on the identifier chain for these identifiers will be
  /// loaded once the recursive loading has completed.
  private MapVectorPtrType<IdentifierInfo /*P*/ , SmallVectorUInt> PendingIdentifierInfos;
  
  /// \brief The set of lookup results that we have faked in order to support
  /// merging of partially deserialized decls but that we have not yet removed.
  /*friend*/public SmallMapVectorPtrType<IdentifierInfo /*P*/ , SmallVector<NamedDecl /*P*/ >> PendingFakeLookupResults;
  
  /// \brief The generation number of each identifier, which keeps track of
  /// the last time we loaded information about this identifier.
  private DenseMapTypeUInt<IdentifierInfo /*P*/> IdentifierGeneration;
  
  /// \brief Contains declarations and definitions that will be
  /// "interesting" to the ASTConsumer, when we get that AST consumer.
  ///
  /// "Interesting" declarations are those that have data that may
  /// need to be emitted, such as inline function definitions or
  /// Objective-C protocols.
  private std.deque<Decl /*P*/ > InterestingDecls;
  
  /// \brief The list of redeclaration chains that still need to be 
  /// reconstructed, and the local offset to the corresponding list
  /// of redeclarations.
  /*friend*/public SmallVector<std.pairPtrULong<Decl /*P*/ >> PendingDeclChains;
  
  /// \brief The list of canonical declarations whose redeclaration chains
  /// need to be marked as incomplete once we're done deserializing things.
  private SmallVector<Decl /*P*/> PendingIncompleteDeclChains;
  
  /// \brief The Decl IDs for the Sema/Lexical DeclContext of a Decl that has
  /// been loaded but its DeclContext was not set yet.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingDeclContextInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 964,
   FQN="clang::ASTReader::PendingDeclContextInfo", NM="_ZN5clang9ASTReader22PendingDeclContextInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22PendingDeclContextInfoE")
  //</editor-fold>
  private static class/*struct*/ PendingDeclContextInfo {
    public Decl /*P*/ D;
    public /*uint32_t*/int SemaDC;
    public /*uint32_t*/int LexicalDC;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PendingDeclContextInfo::PendingDeclContextInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 964,
     FQN="clang::ASTReader::PendingDeclContextInfo::PendingDeclContextInfo", NM="_ZN5clang9ASTReader22PendingDeclContextInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22PendingDeclContextInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ PendingDeclContextInfo(final /*const*/ PendingDeclContextInfo /*&*/ $Prm0) {
      // : D(.D), SemaDC(.SemaDC), LexicalDC(.LexicalDC) 
      //START JInit
      this.D = $Prm0.D;
      this.SemaDC = $Prm0.SemaDC;
      this.LexicalDC = $Prm0.LexicalDC;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public PendingDeclContextInfo(Decl D, int SemaDC, int LexicalDC) {
      this.D = D;
      this.SemaDC = SemaDC;
      this.LexicalDC = LexicalDC;
    }

    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "D=" + "[Decl]" // NOI18N
                + ", SemaDC=" + SemaDC // NOI18N
                + ", LexicalDC=" + LexicalDC; // NOI18N
    }
  };
  
  /// \brief The set of Decls that have been loaded but their DeclContexts are
  /// not set yet.
  ///
  /// The DeclContexts for these Decls will be set once recursive loading has
  /// been completed.
  private std.deque<PendingDeclContextInfo> PendingDeclContextInfos;
  
  /// \brief The set of NamedDecls that have been loaded, but are members of a
  /// context that has been merged into another context where the corresponding
  /// declaration is either missing or has not yet been loaded.
  ///
  /// We will check whether the corresponding declaration is in fact missing
  /// once recursing loading has been completed.
  /*friend*/public SmallVector<NamedDecl /*P*/ > PendingOdrMergeChecks;
  
  /// \brief Record definitions in which we found an ODR violation.
  /*friend*/public SmallDenseMap<CXXRecordDecl /*P*/ , TinyPtrVector<CXXRecordDecl /*P*/ >> PendingOdrMergeFailures;
  
  /// \brief DeclContexts in which we have diagnosed an ODR violation.
  private SmallPtrSet<DeclContext /*P*/ > DiagnosedOdrMergeFailures;
  
  /// \brief The set of Objective-C categories that have been deserialized
  /// since the last time the declaration chains were linked.
  /*friend*/public SmallPtrSet<ObjCCategoryDecl /*P*/ > CategoriesDeserialized;
  
  /// \brief The set of Objective-C class definitions that have already been
  /// loaded, for which we will need to check for categories whenever a new
  /// module is loaded.
  /*friend*/public SmallVector<ObjCInterfaceDecl /*P*/ > ObjCClassesLoaded;
  
  // JAVA: typedef llvm::DenseMap<Decl *, SmallVector<serialization::DeclID, 2> > KeyDeclsMap
//  public final class KeyDeclsMap extends DenseMap<Decl /*P*/ , SmallVectorUInt>{ };
  
  /// \brief A mapping from canonical declarations to the set of global
  /// declaration IDs for key declaration that have been merged with that
  /// canonical declaration. A key declaration is a formerly-canonical
  /// declaration whose module did not import any other key declaration for that
  /// entity. These are the IDs that we use as keys when finding redecl chains.
  /*friend*/public DenseMap<Decl /*P*/ , SmallVectorUInt> KeyDecls;
  
  /// \brief A mapping from DeclContexts to the semantic DeclContext that we
  /// are treating as the definition of the entity. This is used, for instance,
  /// when merging implicit instantiations of class templates across modules.
  /*friend*/public DenseMap<DeclContext /*P*/ , DeclContext /*P*/ > MergedDeclContexts;
  
  /// \brief A mapping from canonical declarations of enums to their canonical
  /// definitions. Only populated when using modules in C++.
  /*friend*/public DenseMap<EnumDecl /*P*/ , EnumDecl /*P*/ > EnumDefinitions;
  
  /// \brief When reading a Stmt tree, Stmt operands are placed in this stack.
  private SmallVector<Stmt /*P*/ > StmtStack;
  
  /// \brief What kind of records we are reading.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadingKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1024,
   FQN="clang::ASTReader::ReadingKind", NM="_ZN5clang9ASTReader11ReadingKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader11ReadingKindE")
  //</editor-fold>
  private enum ReadingKind implements Native.NativeUIntEnum {
    Read_None(0),
    Read_Decl(Read_None.getValue() + 1),
    Read_Type(Read_Decl.getValue() + 1),
    Read_Stmt(Read_Type.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ReadingKind valueOf(int val) {
      ReadingKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ReadingKind[] VALUES;
      private static final ReadingKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ReadingKind kind : ReadingKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ReadingKind[min < 0 ? (1-min) : 0];
        VALUES = new ReadingKind[max >= 0 ? (1+max) : 0];
        for (ReadingKind kind : ReadingKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ReadingKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief What kind of records we are reading.
  private ReadingKind _ReadingKind;
  
  /// \brief RAII object to change the reading kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadingKindTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1032,
   FQN="clang::ASTReader::ReadingKindTracker", NM="_ZN5clang9ASTReader18ReadingKindTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadingKindTrackerE")
  //</editor-fold>
  private static class ReadingKindTracker implements Destructors.ClassWithDestructor {
    private final ASTReader /*&*/ Reader;
    private  ReadingKind PrevKind;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadingKindTracker::ReadingKindTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1036,
     FQN="clang::ASTReader::ReadingKindTracker::ReadingKindTracker", NM="_ZN5clang9ASTReader18ReadingKindTrackerC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadingKindTrackerC1ERKS1_")
    //</editor-fold>
    protected/*private*/ ReadingKindTracker(final /*const*/ ReadingKindTracker /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadingKindTracker::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1037,
     FQN="clang::ASTReader::ReadingKindTracker::operator=", NM="_ZN5clang9ASTReader18ReadingKindTrackeraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadingKindTrackeraSERKS1_")
    //</editor-fold>
    protected/*private*/ void $assign(final /*const*/ ReadingKindTracker /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadingKindTracker::ReadingKindTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1040,
     FQN="clang::ASTReader::ReadingKindTracker::ReadingKindTracker", NM="_ZN5clang9ASTReader18ReadingKindTrackerC1ENS0_11ReadingKindERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadingKindTrackerC1ENS0_11ReadingKindERS0_")
    //</editor-fold>
    public ReadingKindTracker( ReadingKind newKind, final ASTReader /*&*/ reader) {
      // : Reader(reader), PrevKind(Reader.ReadingKind) 
      //START JInit
      this./*&*/Reader=/*&*/reader;
      this.PrevKind = Reader._ReadingKind;
      //END JInit
      Reader._ReadingKind = newKind;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadingKindTracker::~ReadingKindTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1045,
     FQN="clang::ASTReader::ReadingKindTracker::~ReadingKindTracker", NM="_ZN5clang9ASTReader18ReadingKindTrackerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadingKindTrackerD0Ev")
    //</editor-fold>
    public void $destroy() {
      Reader._ReadingKind = PrevKind;
    }

    
    @Override public String toString() {
      return "" + "Reader=" + Reader // NOI18N
                + ", PrevKind=" + PrevKind; // NOI18N
    }
  };
  
  /// \brief RAII object to mark the start of processing updates.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ProcessingUpdatesRAIIObj">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1049,
   FQN="clang::ASTReader::ProcessingUpdatesRAIIObj", NM="_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjE")
  //</editor-fold>
  private static class ProcessingUpdatesRAIIObj implements Destructors.ClassWithDestructor {
    private final ASTReader /*&*/ Reader;
    private boolean PrevState;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ProcessingUpdatesRAIIObj::ProcessingUpdatesRAIIObj">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1053,
     FQN="clang::ASTReader::ProcessingUpdatesRAIIObj::ProcessingUpdatesRAIIObj", NM="_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjC1ERKS1_")
    //</editor-fold>
    protected/*private*/ ProcessingUpdatesRAIIObj(final /*const*/ ProcessingUpdatesRAIIObj /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ProcessingUpdatesRAIIObj::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1054,
     FQN="clang::ASTReader::ProcessingUpdatesRAIIObj::operator=", NM="_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjaSERKS1_")
    //</editor-fold>
    protected/*private*/ void $assign(final /*const*/ ProcessingUpdatesRAIIObj /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ProcessingUpdatesRAIIObj::ProcessingUpdatesRAIIObj">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1057,
     FQN="clang::ASTReader::ProcessingUpdatesRAIIObj::ProcessingUpdatesRAIIObj", NM="_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjC1ERS0_")
    //</editor-fold>
    public ProcessingUpdatesRAIIObj(final ASTReader /*&*/ reader) {
      // : Reader(reader), PrevState(Reader.ProcessingUpdateRecords) 
      //START JInit
      this./*&*/Reader=/*&*/reader;
      this.PrevState = Reader.ProcessingUpdateRecords;
      //END JInit
      Reader.ProcessingUpdateRecords = true;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ProcessingUpdatesRAIIObj::~ProcessingUpdatesRAIIObj">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1062,
     FQN="clang::ASTReader::ProcessingUpdatesRAIIObj::~ProcessingUpdatesRAIIObj", NM="_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ProcessingUpdatesRAIIObjD0Ev")
    //</editor-fold>
    public void $destroy() {
      Reader.ProcessingUpdateRecords = PrevState;
    }

    
    @Override public String toString() {
      return "" + "Reader=" + Reader // NOI18N
                + ", PrevState=" + PrevState; // NOI18N
    }
  };
  
  /// \brief Suggested contents of the predefines buffer, after this
  /// PCH file has been processed.
  ///
  /// In most cases, this string will be empty, because the predefines
  /// buffer computed to build the PCH file will be identical to the
  /// predefines buffer computed from the command line. However, when
  /// there are differences that the PCH reader can work around, this
  /// predefines buffer may contain additional definitions.
  private std.string SuggestedPredefines;
  
  /// \brief Reads a statement from the specified cursor.
  
  /// \brief Reads a statement from the specified cursor.
  
  // Within the bitstream, expressions are stored in Reverse Polish
  // Notation, with each of the subexpressions preceding the
  // expression they are stored in. Subexpressions are stored from last to first.
  // To evaluate expressions, we continue reading expressions and placing them on
  // the stack, with expressions having operands removing those operands from the
  // stack. Evaluation terminates when we see a STMT_STOP record, and
  // the single remaining expression on the stack is our result.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadStmtFromStream">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2809,
   FQN="clang::ASTReader::ReadStmtFromStream", NM="_ZN5clang9ASTReader18ReadStmtFromStreamERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang9ASTReader18ReadStmtFromStreamERNS_13serialization10ModuleFileE")
  //</editor-fold>
  private Stmt /*P*/ ReadStmtFromStream(final ModuleFile /*&*/ F) {
    ReadingKindTracker ReadingKind = null;
    try {
      
      ReadingKind/*J*/= new ReadingKindTracker(ASTReader.ReadingKind.Read_Stmt, /*Deref*/this);
      final BitstreamCursor /*&*/ Cursor = F.DeclsCursor;
      
      // Map of offset to previously deserialized stmt. The offset points
      /// just after the stmt record.
      DenseMapULongType<Stmt /*P*/ > StmtEntries/*J*/= new DenseMapULongType<Stmt /*P*/ >(DenseMapInfoULong.$Info(), (Stmt /*P*/ )null);
      /*uint*/int PrevNumStmts = StmtStack.size();
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      uint$ref Idx = create_uint$ref();
      ASTStmtReader Reader/*J*/= new ASTStmtReader(/*Deref*/this, F, Cursor, Record, Idx);
      Stmt.EmptyShell Empty/*J*/= new Stmt.EmptyShell();
      Done:while (true) {
        BitstreamEntry Entry = Cursor.advanceSkippingSubblocks();
        switch (Entry.Kind) {
         case SubBlock: // Handled for us already.
         case Error:
          Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
          return null;
         case EndBlock:
          break Done;
         case Record:
          // The interesting case.
          break;
        }
        
        Stmt /*P*/ S = null;
        Idx.$set(0);
        Record.clear();
        boolean Finished = false;
        boolean IsStmtReference = false;
        switch (Cursor.readRecord(Entry.ID, Record)) {
         case StmtCode.STMT_STOP:
          Finished = true;
          break;
         case StmtCode.STMT_REF_PTR:
          IsStmtReference = true;
          assert (StmtEntries.find(Record.$at(0)).$noteq(/*NO_ITER_COPY*/StmtEntries.end())) : "No stmt was recorded for this offset reference!";
          S = StmtEntries.$at_T1$C$R(Record.$at(Idx.$set$postInc()));
          break;
         case StmtCode.STMT_NULL_PTR:
          S = null;
          break;
         case StmtCode.STMT_NULL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new NullStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_COMPOUND:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CompoundStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_CASE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CaseStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_DEFAULT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new DefaultStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_LABEL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new LabelStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_ATTRIBUTED:
          S = AttributedStmt.CreateEmpty(Context, 
              /*NumAttrs*/ $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)));
          break;
         case StmtCode.STMT_IF:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new IfStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_SWITCH:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SwitchStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_WHILE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new WhileStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_DO:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new DoStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_FOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ForStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_GOTO:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new GotoStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_INDIRECT_GOTO:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new IndirectGotoStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_CONTINUE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ContinueStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_BREAK:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new BreakStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_RETURN:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ReturnStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_DECL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new DeclStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_GCCASM:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new GCCAsmStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_MSASM:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new MSAsmStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_CAPTURED:
          S = CapturedStmt.CreateDeserialized(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)));
          break;
         case StmtCode.EXPR_PREDEFINED:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new PredefinedExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_DECL_REF:
          S = DeclRefExpr.CreateEmpty(Context, 
              /*HasQualifier=*/ (Record.$at(ASTStmtReader.NumExprFields) != 0), 
              /*HasFoundDecl=*/ (Record.$at(ASTStmtReader.NumExprFields + 1) != 0), 
              /*HasTemplateKWAndArgsInfo=*/ (Record.$at(ASTStmtReader.NumExprFields + 2) != 0), 
              /*NumTemplateArgs=*/ $ullong2uint((Record.$at(ASTStmtReader.NumExprFields + 2) != 0) ? Record.$at(ASTStmtReader.NumExprFields + 5) : $int2ullong(0)));
          break;
         case StmtCode.EXPR_INTEGER_LITERAL:
          S = IntegerLiteral.Create(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.EXPR_FLOATING_LITERAL:
          S = FloatingLiteral.Create(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.EXPR_IMAGINARY_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ImaginaryLiteral(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_STRING_LITERAL:
          S = StringLiteral.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields + 1)));
          break;
         case StmtCode.EXPR_CHARACTER_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CharacterLiteral(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_PAREN:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ParenExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_PAREN_LIST:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ParenListExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_UNARY_OPERATOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new UnaryOperator(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OFFSETOF:
          S = OffsetOfExpr.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)), 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields + 1)));
          break;
         case StmtCode.EXPR_SIZEOF_ALIGN_OF:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new UnaryExprOrTypeTraitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_ARRAY_SUBSCRIPT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ArraySubscriptExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OMP_ARRAY_SECTION:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new OMPArraySectionExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CALL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CallExpr(Context, Stmt.StmtClass.CallExprClass, new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_MEMBER:
          {
            TemplateArgumentListInfo ArgInfo = null;
            try {
              // We load everything here and fully initialize it at creation.
              // That way we can use MemberExpr::Create and don't have to duplicate its
              // logic with a MemberExpr::CreateEmpty.
              assert (Idx.$deref() == 0);
              NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
              if ((Record.$at(Idx.$set$postInc()) != 0)) { // HasQualifier.
                QualifierLoc.$assignMove(ReadNestedNameSpecifierLoc(F, Record, Idx));
              }
              
              SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
              ArgInfo/*J*/= new TemplateArgumentListInfo();
              boolean HasTemplateKWAndArgsInfo = (Record.$at(Idx.$set$postInc()) != 0);
              if (HasTemplateKWAndArgsInfo) {
                TemplateKWLoc.$assignMove(ReadSourceLocation(F, Record, Idx));
                /*uint*/int NumTemplateArgs = $ullong2uint(Record.$at(Idx.$set$postInc()));
                ArgInfo.setLAngleLoc(ReadSourceLocation(F, Record, Idx));
                ArgInfo.setRAngleLoc(ReadSourceLocation(F, Record, Idx));
                for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
                  ArgInfo.addArgument(ReadTemplateArgumentLoc(F, Record, Idx));
                }
              }
              
              boolean HadMultipleCandidates = (Record.$at(Idx.$set$postInc()) != 0);
              
              NamedDecl /*P*/ FoundD = this.<NamedDecl>ReadDeclAs(NamedDecl.class, F, Record, Idx);
              AccessSpecifier AS = AccessSpecifier.valueOf((int)Record.$at(Idx.$set$postInc()));
              DeclAccessPair FoundDecl = DeclAccessPair.make(FoundD, AS);
              
              QualType T = readType(F, Record, Idx);
              ExprValueKind VK = /*static_cast*/ExprValueKind.valueOf((int)Record.$at(Idx.$set$postInc()));
              ExprObjectKind OK = /*static_cast*/ExprObjectKind.valueOf((int)Record.$at(Idx.$set$postInc()));
              Expr /*P*/ Base = ReadSubExpr();
              ValueDecl /*P*/ MemberD = this.<ValueDecl>ReadDeclAs(ValueDecl.class, F, Record, Idx);
              SourceLocation MemberLoc = ReadSourceLocation(F, Record, Idx);
              DeclarationNameInfo MemberNameInfo/*J*/= new DeclarationNameInfo(MemberD.getDeclName(), new SourceLocation(MemberLoc));
              boolean IsArrow = (Record.$at(Idx.$set$postInc()) != 0);
              SourceLocation OperatorLoc = ReadSourceLocation(F, Record, Idx);
              
              S = MemberExpr.Create(Context, Base, IsArrow, new SourceLocation(OperatorLoc), new NestedNameSpecifierLoc(QualifierLoc), 
                  new SourceLocation(TemplateKWLoc), MemberD, new DeclAccessPair(FoundDecl), new DeclarationNameInfo(MemberNameInfo), 
                  HasTemplateKWAndArgsInfo ? $AddrOf(ArgInfo) : (TemplateArgumentListInfo /*P*/ )null, new QualType(T), 
                  VK, OK);
              ReadDeclarationNameLoc(F, cast_MemberExpr(S).MemberDNLoc, 
                  MemberD.getDeclName(), Record, Idx);
              if (HadMultipleCandidates) {
                cast_MemberExpr(S).setHadMultipleCandidates(true);
              }
              break;
            } finally {
              if (ArgInfo != null) { ArgInfo.$destroy(); }
            }
          }
         case StmtCode.EXPR_BINARY_OPERATOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new BinaryOperator(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_COMPOUND_ASSIGN_OPERATOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CompoundAssignOperator(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CONDITIONAL_OPERATOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ConditionalOperator(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_BINARY_CONDITIONAL_OPERATOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new BinaryConditionalOperator(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_IMPLICIT_CAST:
          S = ImplicitCastExpr.CreateEmpty(Context, 
              /*PathSize*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_CSTYLE_CAST:
          S = CStyleCastExpr.CreateEmpty(Context, 
              /*PathSize*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_COMPOUND_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CompoundLiteralExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_EXT_VECTOR_ELEMENT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ExtVectorElementExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_INIT_LIST:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new InitListExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_DESIGNATED_INIT:
          S = DesignatedInitExpr.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields) - $int2ullong(1)));
          
          break;
         case StmtCode.EXPR_DESIGNATED_INIT_UPDATE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new DesignatedInitUpdateExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_IMPLICIT_VALUE_INIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ImplicitValueInitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_NO_INIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new NoInitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_VA_ARG:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new VAArgExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_ADDR_LABEL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new AddrLabelExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_STMT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new StmtExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CHOOSE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ChooseExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_GNU_NULL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new GNUNullExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_SHUFFLE_VECTOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ShuffleVectorExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CONVERT_VECTOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ConvertVectorExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_BLOCK:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new BlockExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_GENERIC_SELECTION:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new GenericSelectionExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_STRING_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCStringLiteral(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_BOXED_EXPRESSION:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBoxedExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_ARRAY_LITERAL:
          S = ObjCArrayLiteral.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_OBJC_DICTIONARY_LITERAL:
          S = ObjCDictionaryLiteral.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)), 
              (Record.$at(ASTStmtReader.NumExprFields + 1) != 0));
          break;
         case StmtCode.EXPR_OBJC_ENCODE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCEncodeExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_SELECTOR_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCSelectorExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_PROTOCOL_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCProtocolExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_IVAR_REF_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCIvarRefExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_PROPERTY_REF_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCPropertyRefExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_SUBSCRIPT_REF_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCSubscriptRefExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_KVC_REF_EXPR:
          throw new llvm_unreachable("mismatching AST file");
         case StmtCode.EXPR_OBJC_MESSAGE_EXPR:
          S = ObjCMessageExpr.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)), 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields + 1)));
          break;
         case StmtCode.EXPR_OBJC_ISA:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCIsaExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_INDIRECT_COPY_RESTORE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCIndirectCopyRestoreExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_BRIDGED_CAST:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBridgedCastExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_OBJC_FOR_COLLECTION:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCForCollectionStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_OBJC_CATCH:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCAtCatchStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_OBJC_FINALLY:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCAtFinallyStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_OBJC_AT_TRY:
          S = ObjCAtTryStmt.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), 
              (Record.$at(ASTStmtReader.NumStmtFields + 1) != 0));
          break;
         case StmtCode.STMT_OBJC_AT_SYNCHRONIZED:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCAtSynchronizedStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_OBJC_AT_THROW:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCAtThrowStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_OBJC_AUTORELEASE_POOL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCAutoreleasePoolStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_BOOL_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBoolLiteralExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OBJC_AVAILABILITY_CHECK:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ObjCAvailabilityCheckExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_SEH_LEAVE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SEHLeaveStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_SEH_EXCEPT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SEHExceptStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_SEH_FINALLY:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SEHFinallyStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_SEH_TRY:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SEHTryStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_CXX_CATCH:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXCatchStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_CXX_TRY:
          S = CXXTryStmt.Create(Context, new Stmt.EmptyShell(Empty), 
              /*NumHandlers=*/ $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)));
          break;
         case StmtCode.STMT_CXX_FOR_RANGE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXForRangeStmt(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.STMT_MS_DEPENDENT_EXISTS:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new MSDependentExistsStmt(new SourceLocation(), true, 
                      new NestedNameSpecifierLoc(), 
                      new DeclarationNameInfo(), 
                      (CompoundStmt /*P*/ )null);
           });
          break;
         case StmtCode.STMT_OMP_PARALLEL_DIRECTIVE:
          S
             = OMPParallelDirective.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), 
              new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPSimdDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_FOR_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPForDirective.CreateEmpty(Context, NumClauses, CollapsedNum, 
                new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_FOR_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPForSimdDirective.CreateEmpty(Context, NumClauses, CollapsedNum, 
                new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_SECTIONS_DIRECTIVE:
          S = OMPSectionsDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_SECTION_DIRECTIVE:
          S = OMPSectionDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_SINGLE_DIRECTIVE:
          S = OMPSingleDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_MASTER_DIRECTIVE:
          S = OMPMasterDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_CRITICAL_DIRECTIVE:
          S = OMPCriticalDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_PARALLEL_FOR_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPParallelForDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_PARALLEL_FOR_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPParallelForSimdDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_PARALLEL_SECTIONS_DIRECTIVE:
          S = OMPParallelSectionsDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TASK_DIRECTIVE:
          S = OMPTaskDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TASKYIELD_DIRECTIVE:
          S = OMPTaskyieldDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_BARRIER_DIRECTIVE:
          S = OMPBarrierDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TASKWAIT_DIRECTIVE:
          S = OMPTaskwaitDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TASKGROUP_DIRECTIVE:
          S = OMPTaskgroupDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_FLUSH_DIRECTIVE:
          S = OMPFlushDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_ORDERED_DIRECTIVE:
          S = OMPOrderedDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_ATOMIC_DIRECTIVE:
          S = OMPAtomicDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TARGET_DIRECTIVE:
          S = OMPTargetDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TARGET_DATA_DIRECTIVE:
          S = OMPTargetDataDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TARGET_ENTER_DATA_DIRECTIVE:
          S = OMPTargetEnterDataDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TARGET_EXIT_DATA_DIRECTIVE:
          S = OMPTargetExitDataDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TARGET_PARALLEL_DIRECTIVE:
          S = OMPTargetParallelDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TARGET_PARALLEL_FOR_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPTargetParallelForDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_TARGET_UPDATE_DIRECTIVE:
          S = OMPTargetUpdateDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TEAMS_DIRECTIVE:
          S = OMPTeamsDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_CANCELLATION_POINT_DIRECTIVE:
          S = OMPCancellationPointDirective.CreateEmpty(Context, new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_CANCEL_DIRECTIVE:
          S = OMPCancelDirective.CreateEmpty(Context, $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields)), new Stmt.EmptyShell(Empty));
          break;
         case StmtCode.STMT_OMP_TASKLOOP_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPTaskLoopDirective.CreateEmpty(Context, NumClauses, CollapsedNum, 
                new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_TASKLOOP_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPTaskLoopSimdDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_DISTRIBUTE_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPDistributeDirective.CreateEmpty(Context, NumClauses, CollapsedNum, 
                new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_DISTRIBUTE_PARALLEL_FOR_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPDistributeParallelForDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_DISTRIBUTE_PARALLEL_FOR_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPDistributeParallelForSimdDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, 
                new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_DISTRIBUTE_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPDistributeSimdDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.STMT_OMP_TARGET_PARALLEL_FOR_SIMD_DIRECTIVE:
          {
            /*uint*/int NumClauses = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields));
            /*uint*/int CollapsedNum = $ullong2uint(Record.$at(ASTStmtReader.NumStmtFields + 1));
            S = OMPTargetParallelForSimdDirective.CreateEmpty(Context, NumClauses, 
                CollapsedNum, new Stmt.EmptyShell(Empty));
            break;
          }
         case StmtCode.EXPR_CXX_OPERATOR_CALL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXOperatorCallExpr(Context, new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_MEMBER_CALL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXMemberCallExpr(Context, new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_CONSTRUCT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXConstructExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_INHERITED_CTOR_INIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXInheritedCtorInitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_TEMPORARY_OBJECT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXTemporaryObjectExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_STATIC_CAST:
          S = CXXStaticCastExpr.CreateEmpty(Context, 
              /*PathSize*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_CXX_DYNAMIC_CAST:
          S = CXXDynamicCastExpr.CreateEmpty(Context, 
              /*PathSize*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_CXX_REINTERPRET_CAST:
          S = CXXReinterpretCastExpr.CreateEmpty(Context, 
              /*PathSize*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_CXX_CONST_CAST:
          S = CXXConstCastExpr.CreateEmpty(Context);
          break;
         case StmtCode.EXPR_CXX_FUNCTIONAL_CAST:
          S = CXXFunctionalCastExpr.CreateEmpty(Context, 
              /*PathSize*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_USER_DEFINED_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new UserDefinedLiteral(Context, new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_STD_INITIALIZER_LIST:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXStdInitializerListExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_BOOL_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXBoolLiteralExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_NULL_PTR_LITERAL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXNullPtrLiteralExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_TYPEID_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXTypeidExpr(new Stmt.EmptyShell(Empty), true);
           });
          break;
         case StmtCode.EXPR_CXX_TYPEID_TYPE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXTypeidExpr(new Stmt.EmptyShell(Empty), false);
           });
          break;
         case StmtCode.EXPR_CXX_UUIDOF_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXUuidofExpr(new Stmt.EmptyShell(Empty), true);
           });
          break;
         case StmtCode.EXPR_CXX_PROPERTY_REF_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new MSPropertyRefExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_PROPERTY_SUBSCRIPT_EXPR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new MSPropertySubscriptExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_UUIDOF_TYPE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXUuidofExpr(new Stmt.EmptyShell(Empty), false);
           });
          break;
         case StmtCode.EXPR_CXX_THIS:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXThisExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_THROW:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXThrowExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_DEFAULT_ARG:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXDefaultArgExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_DEFAULT_INIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXDefaultInitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_BIND_TEMPORARY:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXBindTemporaryExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_SCALAR_VALUE_INIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXScalarValueInitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_NEW:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXNewExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_DELETE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXDeleteExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_PSEUDO_DESTRUCTOR:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXPseudoDestructorExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_EXPR_WITH_CLEANUPS:
          S = ExprWithCleanups.Create(Context, new Stmt.EmptyShell(Empty), 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_CXX_DEPENDENT_SCOPE_MEMBER:
          S = CXXDependentScopeMemberExpr.CreateEmpty(Context, 
              /*HasTemplateKWAndArgsInfo=*/ (Record.$at(ASTStmtReader.NumExprFields) != 0), 
              /*NumTemplateArgs=*/ $ullong2uint((Record.$at(ASTStmtReader.NumExprFields) != 0) ? Record.$at(ASTStmtReader.NumExprFields + 1) : $int2ullong(0)));
          break;
         case StmtCode.EXPR_CXX_DEPENDENT_SCOPE_DECL_REF:
          S = DependentScopeDeclRefExpr.CreateEmpty(Context, 
              /*HasTemplateKWAndArgsInfo=*/ (Record.$at(ASTStmtReader.NumExprFields) != 0), 
              /*NumTemplateArgs=*/ $ullong2uint((Record.$at(ASTStmtReader.NumExprFields) != 0) ? Record.$at(ASTStmtReader.NumExprFields + 1) : $int2ullong(0)));
          break;
         case StmtCode.EXPR_CXX_UNRESOLVED_CONSTRUCT:
          S = CXXUnresolvedConstructExpr.CreateEmpty(Context, 
              /*NumArgs=*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_CXX_UNRESOLVED_MEMBER:
          S = UnresolvedMemberExpr.CreateEmpty(Context, 
              /*HasTemplateKWAndArgsInfo=*/ (Record.$at(ASTStmtReader.NumExprFields) != 0), 
              /*NumTemplateArgs=*/ $ullong2uint((Record.$at(ASTStmtReader.NumExprFields) != 0) ? Record.$at(ASTStmtReader.NumExprFields + 1) : $int2ullong(0)));
          break;
         case StmtCode.EXPR_CXX_UNRESOLVED_LOOKUP:
          S = UnresolvedLookupExpr.CreateEmpty(Context, 
              /*HasTemplateKWAndArgsInfo=*/ (Record.$at(ASTStmtReader.NumExprFields) != 0), 
              /*NumTemplateArgs=*/ $ullong2uint((Record.$at(ASTStmtReader.NumExprFields) != 0) ? Record.$at(ASTStmtReader.NumExprFields + 1) : $int2ullong(0)));
          break;
         case StmtCode.EXPR_TYPE_TRAIT:
          S = TypeTraitExpr.CreateDeserialized(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_ARRAY_TYPE_TRAIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ArrayTypeTraitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_EXPRESSION_TRAIT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new ExpressionTraitExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_NOEXCEPT:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXNoexceptExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_PACK_EXPANSION:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new PackExpansionExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_SIZEOF_PACK:
          S = SizeOfPackExpr.CreateDeserialized(Context, 
              /*NumPartialArgs=*/ $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_SUBST_NON_TYPE_TEMPLATE_PARM:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SubstNonTypeTemplateParmExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_SUBST_NON_TYPE_TEMPLATE_PARM_PACK:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new SubstNonTypeTemplateParmPackExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_FUNCTION_PARM_PACK:
          S = FunctionParmPackExpr.CreateEmpty(Context, 
              $ullong2uint(Record.$at(ASTStmtReader.NumExprFields)));
          break;
         case StmtCode.EXPR_MATERIALIZE_TEMPORARY:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new MaterializeTemporaryExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CXX_FOLD:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXFoldExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_OPAQUE_VALUE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new OpaqueValueExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_CUDA_KERNEL_CALL:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CUDAKernelCallExpr(Context, new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_ASTYPE:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new AsTypeExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_PSEUDO_OBJECT:
          {
            /*uint*/int numSemanticExprs = $ullong2uint(Record.$at(ASTStmtReader.NumExprFields));
            S = PseudoObjectExpr.Create(Context, new Stmt.EmptyShell(Empty), numSemanticExprs);
            break;
          }
         case StmtCode.EXPR_ATOMIC:
          S = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new AtomicExpr(new Stmt.EmptyShell(Empty));
           });
          break;
         case StmtCode.EXPR_LAMBDA:
          {
            /*uint*/int NumCaptures = $ullong2uint(Record.$at(ASTStmtReader.NumExprFields));
            /*uint*/int NumArrayIndexVars = $ullong2uint(Record.$at(ASTStmtReader.NumExprFields + 1));
            S = LambdaExpr.CreateDeserialized(Context, NumCaptures, 
                NumArrayIndexVars);
            break;
          }
        }
        
        // We hit a STMT_STOP, so we're done with this expression.
        if (Finished) {
          break;
        }
        
        ++NumStatementsRead;
        if ((S != null) && !IsStmtReference) {
          Reader.Visit(S);
          StmtEntries.$set(Cursor.GetCurrentBitNo(), S);
        }
        assert (Idx.$deref() == Record.size()) : "Invalid deserialization of statement";
        StmtStack.push_back(S);
      }
     //Done:
      assert ($greater_uint(StmtStack.size(), PrevNumStmts)) : "Read too many sub-stmts!";
      assert (StmtStack.size() == PrevNumStmts + 1) : "Extra expressions on stack!";
      return StmtStack.pop_back_val();
    } finally {
      if (ReadingKind != null) { ReadingKind.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::InputFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1078,
   FQN="clang::ASTReader::InputFileInfo", NM="_ZN5clang9ASTReader13InputFileInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13InputFileInfoE")
  //</editor-fold>
  private static class/*struct*/ InputFileInfo implements Destructors.ClassWithDestructor {
    public std.string Filename;
    public long/*off_t*/ StoredSize;
    public long/*time_t*/ StoredTime;
    public boolean Overridden;
    public boolean Transient;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::InputFileInfo::InputFileInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1078,
     FQN="clang::ASTReader::InputFileInfo::InputFileInfo", NM="_ZN5clang9ASTReader13InputFileInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13InputFileInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ InputFileInfo(JD$Move _dparam, final InputFileInfo /*&&*/$Prm0) {
      // : Filename(static_cast<InputFileInfo &&>().Filename), StoredSize(static_cast<InputFileInfo &&>().StoredSize), StoredTime(static_cast<InputFileInfo &&>().StoredTime), Overridden(static_cast<InputFileInfo &&>().Overridden), Transient(static_cast<InputFileInfo &&>().Transient) 
      //START JInit
      this.Filename = new std.string(JD$Move.INSTANCE, $Prm0.Filename);
      this.StoredSize = $Prm0.StoredSize;
      this.StoredTime = $Prm0.StoredTime;
      this.Overridden = $Prm0.Overridden;
      this.Transient = $Prm0.Transient;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::InputFileInfo::~InputFileInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1078,
     FQN="clang::ASTReader::InputFileInfo::~InputFileInfo", NM="_ZN5clang9ASTReader13InputFileInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13InputFileInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Filename.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::InputFileInfo::InputFileInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1078,
     FQN="clang::ASTReader::InputFileInfo::InputFileInfo", NM="_ZN5clang9ASTReader13InputFileInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13InputFileInfoC1Ev")
    //</editor-fold>
    public /*inline*/ InputFileInfo() {
      // : Filename() 
      //START JInit
      this.Filename = new std.string();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Filename=" + Filename // NOI18N
                + ", StoredSize=" + StoredSize // NOI18N
                + ", StoredTime=" + StoredTime // NOI18N
                + ", Overridden=" + Overridden // NOI18N
                + ", Transient=" + Transient; // NOI18N
    }
  };
  
  /// \brief Reads the stored information about an input file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::readInputFileInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1901,
   FQN="clang::ASTReader::readInputFileInfo", NM="_ZN5clang9ASTReader17readInputFileInfoERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17readInputFileInfoERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  private ASTReader.InputFileInfo readInputFileInfo(final ModuleFile /*&*/ F, /*uint*/int ID) {
    SavedStreamPosition SavedPosition = null;
    InputFileInfo R = null;
    try {
      // Go find this input file.
      final BitstreamCursor /*&*/ Cursor = F.InputFilesCursor;
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(F.InputFileOffsets.$at(ID - 1)/*.$value()*/);
      
      /*uint*/int Code = Cursor.ReadCode();
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      StringRef Blob/*J*/= new StringRef();
      
      /*uint*/int Result = Cursor.readRecord(Code, Record, $AddrOf(Blob));
      assert (/*static_cast InputFileRecordTypes*/(Result) == InputFileRecordTypes.INPUT_FILE) : "invalid record type for input file";
      ///*J:(void)*/Result;
      assert (Record.$at(0) == $uint2ullong(ID)) : "Bogus stored ID or offset";
      R/*J*/= new InputFileInfo();
      R.StoredSize = ((/*static_cast*/long/*off_t*/)($ullong2long(Record.$at(1))));
      R.StoredTime = ((/*static_cast*/long/*time_t*/)($ullong2long(Record.$at(2))));
      R.Overridden = ((/*static_cast*/boolean)((Record.$at(3) != 0)));
      R.Transient = ((/*static_cast*/boolean)((Record.$at(4) != 0)));
      R.Filename.$assignMove(Blob.$string());
      ResolveImportedPath(F, R.Filename);
      return new ASTReader.InputFileInfo(JD$Move.INSTANCE, R);
    } finally {
      if (R != null) { R.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  
  /// \brief Retrieve the file entry and 'overridden' bit for an input
  /// file in the given module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getInputFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1928,
   FQN="clang::ASTReader::getInputFile", NM="_ZN5clang9ASTReader12getInputFileERNS_13serialization10ModuleFileEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12getInputFileERNS_13serialization10ModuleFileEjb")
  //</editor-fold>
  private InputFile getInputFile(final ModuleFile /*&*/ F, /*uint*/int ID) {
    return getInputFile(F, ID, true);
  }
  private InputFile getInputFile(final ModuleFile /*&*/ F, /*uint*/int ID, boolean Complain/*= true*/) {
    SavedStreamPosition SavedPosition = null;
    InputFileInfo FI = null;
    try {
      // If this ID is bogus, just return an empty input file.
      if (ID == 0 || $greater_uint(ID, F.InputFilesLoaded.size())) {
        return new InputFile();
      }
      
      // If we've already loaded this input file, return it.
      if ((F.InputFilesLoaded.$at(ID - 1).getFile() != null)) {
        return new InputFile(F.InputFilesLoaded.$at(ID - 1));
      }
      if (F.InputFilesLoaded.$at(ID - 1).isNotFound()) {
        return new InputFile();
      }
      
      // Go find this input file.
      final BitstreamCursor /*&*/ Cursor = F.InputFilesCursor;
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(F.InputFileOffsets.$at(ID - 1)/*.$value()*/);
      
      FI = readInputFileInfo(F, ID);
      long/*off_t*/ StoredSize = FI.StoredSize;
      long/*time_t*/ StoredTime = FI.StoredTime;
      boolean Overridden = FI.Overridden;
      boolean Transient = FI.Transient;
      StringRef Filename = new StringRef(FI.Filename);
      
      /*const*/ FileEntry /*P*/ File = FileMgr.getFile(/*NO_COPY*/Filename, /*OpenFile=*/ false);
      
      // If we didn't find the file, resolve it relative to the
      // original directory from which this AST file was created.
      if (File == null && !F.OriginalDir.empty() && !CurrentDir.empty()
         && $noteq_string$C(F.OriginalDir, CurrentDir)) {
        std.string Resolved = resolveFileRelativeToOriginalDir(Filename.$string(), 
            F.OriginalDir, 
            CurrentDir);
        if (!Resolved.empty()) {
          File = FileMgr.getFile(new StringRef(Resolved));
        }
      }
      
      // For an overridden file, create a virtual file with the stored
      // size/timestamp.
      if ((Overridden || Transient) && File == null) {
        File = FileMgr.getVirtualFile(new StringRef(Filename), StoredSize, StoredTime);
      }
      if (File == null) {
        if (Complain) {
          std.string ErrorStr = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"could not find file '");
          $addassign_string_StringRef(ErrorStr, /*NO_COPY*/Filename);
          ErrorStr.$addassign_T$C$P(/*KEEP_STR*/"' referenced by AST file '");
          ErrorStr.$addassign(F.FileName);
          ErrorStr.$addassign_T$C$P(/*KEEP_STR*/"'");
          Error(new StringRef(ErrorStr.c_str()));
        }
        // Record that we didn't find the file.
        F.InputFilesLoaded.$at(ID - 1).$assignMove(InputFile.getNotFound());
        return new InputFile();
      }
      
      // Check if there was a request to override the contents of the file
      // that was part of the precompiled header. Overridding such a file
      // can lead to problems when lexing using the source locations from the
      // PCH.
      final SourceManager /*&*/ SM = getSourceManager();
      // FIXME: Reject if the overrides are different.
      if ((!Overridden && !Transient) && SM.isFileOverridden(File)) {
        if (Complain) {
          Error(diag.err_fe_pch_file_overridden, new StringRef(Filename));
        }
        // After emitting the diagnostic, recover by disabling the override so
        // that the original file will be used.
        //
        // FIXME: This recovery is just as broken as the original state; there may
        // be another precompiled module that's using the overridden contents, or
        // we might be half way through parsing it. Instead, we should treat the
        // overridden contents as belonging to a separate FileEntry.
        SM.disableFileContentsOverride(File);
        // The FileEntry is a virtual file entry with the size of the contents
        // that would override the original contents. Set it to the original's
        // size/time.
        FileMgr.modifyFileEntry(((/*const_cast*/FileEntry /*P*/ )(File)), 
            StoredSize, StoredTime);
      }
      
      boolean IsOutOfDate = false;
      
      // For an overridden file, there is nothing to validate.
      if (!Overridden //
         && (StoredSize != File.getSize()
         || ((StoredTime != 0) && StoredTime != File.getModificationTime()
         && !DisableValidation))) {
        if (Complain) {
          // Build a list of the PCH imports that got us here (in reverse).
          SmallVector<ModuleFile /*P*/ > ImportStack/*J*/= new SmallVector<ModuleFile /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, 1, $AddrOf(F), (ModuleFile /*P*/ )null);
          while ($greater_uint(ImportStack.back().ImportedBy.size(), 0)) {
            ImportStack.push_back(ImportStack.back().ImportedBy.$at(0));
          }
          
          // The top-level PCH is stale.
          StringRef TopLevelPCHName/*J*/= new StringRef(ImportStack.back().FileName);
          Error(diag.err_fe_pch_file_modified, new StringRef(Filename), new StringRef(TopLevelPCHName));
          
          // Print the import stack.
          if ($greater_uint(ImportStack.size(), 1) && !Diags.isDiagnosticInFlight()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_pch_required_by)), 
                      /*NO_COPY*/Filename), new StringRef(ImportStack.$at(0).FileName)));
              for (/*uint*/int I = 1; $less_uint(I, ImportStack.size()); ++I)  {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_pch_required_by)), 
                        new StringRef(ImportStack.$at(I - 1).FileName)), new StringRef(ImportStack.$at(I).FileName)));
              }
            } finally {
              $c$.$destroy();
            }
          }
          if (!Diags.isDiagnosticInFlight()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_pch_rebuild_required)), /*NO_COPY*/TopLevelPCHName));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        IsOutOfDate = true;
      }
      // FIXME: If the file is overridden and we've already opened it,
      // issue an error (or split it into a separate FileEntry).
      InputFile IF = new InputFile(File, Overridden || Transient, IsOutOfDate);
      
      // Note that we've loaded this input file.
      F.InputFilesLoaded.$at(ID - 1).$assign(IF);
      return IF;
    } finally {
      if (FI != null) { FI.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

/*public:*/
  
  /// \brief If we are loading a relocatable PCH or module file, and the filename
  /// is not an absolute path, add the system or module root to the beginning of
  /// the file name.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ResolveImportedPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 2054,
   FQN="clang::ASTReader::ResolveImportedPath", NM="_ZN5clang9ASTReader19ResolveImportedPathERNS_13serialization10ModuleFileERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19ResolveImportedPathERNS_13serialization10ModuleFileERSs")
  //</editor-fold>
  public void ResolveImportedPath(final ModuleFile /*&*/ M, final std.string/*&*/ Filename) {
    // Resolve relative to the base directory, if we have one.
    if (!M.BaseDirectory.empty()) {
      ASTReader.ResolveImportedPath(Filename, new StringRef(M.BaseDirectory));
      /*JAVA:return*/return;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ResolveImportedPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 2060,
   FQN="clang::ASTReader::ResolveImportedPath", NM="_ZN5clang9ASTReader19ResolveImportedPathERSsN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19ResolveImportedPathERSsN4llvm9StringRefE")
  //</editor-fold>
  public static void ResolveImportedPath(final std.string/*&*/ Filename, StringRef Prefix) {
    if (Filename.empty() || path.is_absolute(new Twine(Filename))) {
      return;
    }
    
    SmallString/*128*/ Buffer/*J*/= new SmallString/*128*/(128);
    path.append(Buffer, new Twine(Prefix), new Twine(Filename));
    Filename.assign$T(Buffer.begin(), Buffer.end());
  }

  
  /// \brief Returns the first key declaration for the given declaration. This
  /// is one that is formerly-canonical (or still canonical) and whose module
  /// did not import any other key declaration of the entity.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getKeyDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1101,
   FQN="clang::ASTReader::getKeyDeclaration", NM="_ZN5clang9ASTReader17getKeyDeclarationEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17getKeyDeclarationEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ getKeyDeclaration_Decl$P(Decl /*P*/ D) {
    D = D.getCanonicalDecl();
    if (D.isFromASTFile()) {
      return D;
    }
    
    DenseMapIterator<Decl /*P*/ , SmallVectorUInt> I = KeyDecls.find(D);
    if (I.$eq(/*NO_ITER_COPY*/KeyDecls.end()) || I.$arrow().second.empty()) {
      return D;
    }
    return GetExistingDecl(I.$arrow().second.$at(0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getKeyDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1111,
   FQN="clang::ASTReader::getKeyDeclaration", NM="_ZN5clang9ASTReader17getKeyDeclarationEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17getKeyDeclarationEPKNS_4DeclE")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getKeyDeclaration_Decl$C$P(/*const*/ Decl /*P*/ D) {
    return getKeyDeclaration_Decl$P(((/*const_cast*/Decl /*P*/ )(D)));
  }

  
  /// \brief Run a callback on each imported key declaration of \p D.
  /*template <typename Fn> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::forEachImportedKeyDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1117,
   FQN="clang::ASTReader::forEachImportedKeyDecl", NM="Tpl__ZN5clang9ASTReader22forEachImportedKeyDeclEPKNS_4DeclET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang9ASTReader22forEachImportedKeyDeclEPKNS_4DeclET_")
  //</editor-fold>
  public </*typename*/ Fn extends Decl2Void> void forEachImportedKeyDecl(/*const*/ Decl /*P*/ D, Fn Visit) {
    D = D.getCanonicalDecl$Const();
    if (D.isFromASTFile()) {
      Visit.$call(D);
    }
    
    DenseMapIterator<Decl /*P*/ , SmallVectorUInt> It = KeyDecls.find(((/*const_cast*/Decl /*P*/ )(D)));
    if (It.$noteq(/*NO_ITER_COPY*/KeyDecls.end())) {
      for (/*uint*/int ID : It.$arrow().second)  {
        Visit.$call(GetExistingDecl(ID));
      }
    }
  }

  
  /// \brief Get the loaded lookup tables for \p Primary, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getLoadedLookupTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6689,
   FQN="clang::ASTReader::getLoadedLookupTables", NM="_ZNK5clang9ASTReader21getLoadedLookupTablesEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader21getLoadedLookupTablesEPNS_11DeclContextE")
  //</editor-fold>
  public /*const*/ DeclContextLookupTable /*P*/ getLoadedLookupTables(DeclContext /*P*/ Primary) /*const*/ {
    DenseMapIterator</*const*/ DeclContext /*P*/ , DeclContextLookupTable> I = Lookups.find$Const(Primary);
    return I.$eq(Lookups.end$Const()) ? null : $AddrOf(I.$arrow().second);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ImportedModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1133,
   FQN="clang::ASTReader::ImportedModule", NM="_ZN5clang9ASTReader14ImportedModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14ImportedModuleE")
  //</editor-fold>
  private static class/*struct*/ ImportedModule implements NativeCloneable<ImportedModule> {
    public ModuleFile /*P*/ Mod;
    public ModuleFile /*P*/ ImportedBy;
    public SourceLocation ImportLoc;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ImportedModule::ImportedModule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1138,
     FQN="clang::ASTReader::ImportedModule::ImportedModule", NM="_ZN5clang9ASTReader14ImportedModuleC1EPNS_13serialization10ModuleFileES4_NS_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14ImportedModuleC1EPNS_13serialization10ModuleFileES4_NS_14SourceLocationE")
    //</editor-fold>
    public ImportedModule(ModuleFile /*P*/ Mod, 
        ModuleFile /*P*/ ImportedBy, 
        SourceLocation ImportLoc) {
      // : Mod(Mod), ImportedBy(ImportedBy), ImportLoc(ImportLoc) 
      //START JInit
      this.Mod = Mod;
      this.ImportedBy = ImportedBy;
      this.ImportLoc = new SourceLocation(ImportLoc);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ImportedModule() {
      this.ImportLoc = new SourceLocation();
    }

    @Override
    public ImportedModule clone() {
      return new ImportedModule(this.Mod, this.ImportedBy, this.ImportLoc);
    }

    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Mod=" + Mod // NOI18N
                + ", ImportedBy=" + ImportedBy // NOI18N
                + ", ImportLoc=" + ImportLoc; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadASTCore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3720,
   FQN="clang::ASTReader::ReadASTCore", NM="_ZN5clang9ASTReader11ReadASTCoreEN4llvm9StringRefENS_13serialization10ModuleKindENS_14SourceLocationEPNS3_10ModuleFileERNS1_15SmallVectorImplINS0_14ImportedModuleEEElljj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader11ReadASTCoreEN4llvm9StringRefENS_13serialization10ModuleKindENS_14SourceLocationEPNS3_10ModuleFileERNS1_15SmallVectorImplINS0_14ImportedModuleEEElljj")
  //</editor-fold>
  private ASTReader.ASTReadResult ReadASTCore(StringRef FileName, 
             ModuleKind Type, 
             SourceLocation ImportLoc, 
             ModuleFile /*P*/ ImportedBy, 
             final SmallVectorImpl<ImportedModule> /*&*/ Loaded, 
             long/*off_t*/ ExpectedSize, long/*time_t*/ ExpectedModTime, 
             /*uint*/int ExpectedSignature, 
             /*uint*/int ClientLoadCapabilities) {
    type$ref<ModuleFile /*P*/ > M = create_type$ref();
    std.string ErrorStr/*J*/= new std.string();
    ModuleManager.AddModuleResult AddResult = ModuleMgr.addModule(new StringRef(FileName), Type, new SourceLocation(ImportLoc), ImportedBy, 
        getGeneration(), ExpectedSize, ExpectedModTime, 
        ExpectedSignature, /*FuncRef*/ASTReaderStatics::readASTFileSignature, 
        M, ErrorStr);
    switch (AddResult) {
     case AlreadyLoaded:
      return ASTReadResult.Success;
     case NewlyLoaded:
      // Load module file below.
      break;
     case Missing:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The module file was missing; if the client can handle that, return
          // it.
          if (((ClientLoadCapabilities & LoadFailureCapabilities.ARR_Missing) != 0)) {
            return ASTReadResult.Missing;
          }
          
          // Otherwise, return an error.
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_uint($c$.track(Diag(diag.err_module_file_not_found)), moduleKindForDiagnostic(Type)), 
                      /*NO_COPY*/FileName), ErrorStr.empty()), 
              new StringRef(ErrorStr)));
          return ASTReadResult.Failure;
        } finally {
          $c$.$destroy();
        }
      }
     case OutOfDate:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We couldn't load the module file because it is out-of-date. If the
          // client can handle out-of-date, return it.
          if (((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) != 0)) {
            return ASTReadResult.OutOfDate;
          }
          
          // Otherwise, return an error.
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_uint($c$.track(Diag(diag.err_module_file_out_of_date)), moduleKindForDiagnostic(Type)), 
                      /*NO_COPY*/FileName), ErrorStr.empty()), 
              new StringRef(ErrorStr)));
          return ASTReadResult.Failure;
        } finally {
          $c$.$destroy();
        }
      }
    }
    assert ((M.$deref() != null)) : "Missing module file";
    
    // FIXME: This seems rather a hack. Should CurrentDir be part of the
    // module?
    if ($noteq_StringRef(/*NO_COPY*/FileName, /*STRINGREF_STR*/"-")) {
      CurrentDir.$assignMove(path.parent_path(/*NO_COPY*/FileName).$string());
      if (CurrentDir.empty()) {
        CurrentDir.$assign_T$C$P(/*KEEP_STR*/".");
      }
    }
    
    final ModuleFile /*&*/ F = $Deref(M.$deref());
    final BitstreamCursor /*&*/ Stream = F.Stream;
    PCHContainerRdr.ExtractPCH(F.Buffer.$arrow().getMemBufferRef(), F.StreamFile);
    Stream.init($AddrOf(F.StreamFile));
    F.SizeInBits = $uint2ulong(F.Buffer.$arrow().getBufferSize() * 8);
    
    // Sniff for the signature.
    if (!startsWithASTFileMagic(Stream)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_uint($c$.track(Diag(diag.err_module_file_invalid)), moduleKindForDiagnostic(Type)), 
            /*NO_COPY*/FileName));
        return ASTReadResult.Failure;
      } finally {
        $c$.$destroy();
      }
    }
    
    // This is used for compatibility with older PCH formats.
    boolean HaveReadControlBlock = false;
    while (true) {
      BitstreamEntry Entry = Stream.advance();
      switch (Entry.Kind) {
       case Error:
       case Record:
       case EndBlock:
        Error(new StringRef(/*KEEP_STR*/"invalid record at top-level of AST file"));
        return ASTReadResult.Failure;
       case SubBlock:
        break;
      }
      switch (Entry.ID) {
       case BlockIDs.CONTROL_BLOCK_ID:
        HaveReadControlBlock = true;
        switch (ReadControlBlock(F, Loaded, ImportedBy, ClientLoadCapabilities)) {
         case Success:
          // Check that we didn't try to load a non-module AST file as a module.
          //
          // FIXME: Should we also perform the converse check? Loading a module as
          // a PCH file sort of works, but it's a bit wonky.
          if ((Type == ModuleKind.MK_ImplicitModule || Type == ModuleKind.MK_ExplicitModule)
             && F.ModuleName.empty()) {
            ASTReadResult Result = (Type == ModuleKind.MK_ImplicitModule) ? ASTReadResult.OutOfDate : ASTReadResult.Failure;
            if (Result != ASTReadResult.OutOfDate
               || (ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_module_file_not_module)), /*NO_COPY*/FileName));
              } finally {
                $c$.$destroy();
              }
            }
            return Result;
          }
          break;
         case Failure:
          return ASTReadResult.Failure;
         case Missing:
          return ASTReadResult.Missing;
         case OutOfDate:
          return ASTReadResult.OutOfDate;
         case VersionMismatch:
          return ASTReadResult.VersionMismatch;
         case ConfigurationMismatch:
          return ASTReadResult.ConfigurationMismatch;
         case HadErrors:
          return ASTReadResult.HadErrors;
        }
        break;
       case BlockIDs.AST_BLOCK_ID:
        if (!HaveReadControlBlock) {
          if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_VersionMismatch) == 0) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(Diag(diag.err_pch_version_too_old)));
            } finally {
              $c$.$destroy();
            }
          }
          return ASTReadResult.VersionMismatch;
        }
        
        // Record that we've loaded this module.
        Loaded.push_back(new ImportedModule(M.$deref(), ImportedBy, new SourceLocation(ImportLoc)));
        return ASTReadResult.Success;
       default:
        if (Stream.SkipBlock()) {
          Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
          return ASTReadResult.Failure;
        }
        break;
      }
    }
    
    //return ASTReadResult.Success;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadControlBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 2164,
   FQN="clang::ASTReader::ReadControlBlock", NM="_ZN5clang9ASTReader16ReadControlBlockERNS_13serialization10ModuleFileERN4llvm15SmallVectorImplINS0_14ImportedModuleEEEPKS2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16ReadControlBlockERNS_13serialization10ModuleFileERN4llvm15SmallVectorImplINS0_14ImportedModuleEEEPKS2_j")
  //</editor-fold>
  private ASTReader.ASTReadResult ReadControlBlock(final ModuleFile /*&*/ F, 
                  final SmallVectorImpl<ImportedModule> /*&*/ Loaded, 
                  /*const*/ ModuleFile /*P*/ ImportedBy, 
                  /*uint*/int ClientLoadCapabilities) {
    final BitstreamCursor /*&*/ Stream = F.Stream;
    ASTReadResult Result = ASTReadResult.Success;
    if (Stream.EnterSubBlock(BlockIDs.CONTROL_BLOCK_ID)) {
      Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
      return ASTReadResult.Failure;
    }
    
    // Read all of the records and blocks in the control block.
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    /*uint*/int NumInputs = 0;
    /*uint*/int NumUserInputs = 0;
    while (true) {
      BitstreamEntry Entry = Stream.advance();
      switch (Entry.Kind) {
       case Error:
        Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
        return ASTReadResult.Failure;
       case EndBlock:
        {
          // Validate input files.
          final /*const*/ HeaderSearchOptions /*&*/ HSOpts = PP.getHeaderSearchInfo().getHeaderSearchOpts();
          
          // All user input files reside at the index range [0, NumUserInputs), and
          // system input files reside at [NumUserInputs, NumInputs). For explicitly
          // loaded module files, ignore missing inputs.
          if (!DisableValidation && F.Kind != ModuleKind.MK_ExplicitModule) {
            boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0;
            
            // If we are reading a module, we will create a verification timestamp,
            // so we verify all input files.  Otherwise, verify only user input
            // files.
            /*uint*/int N = NumUserInputs;
            if (ValidateSystemInputs
               || (HSOpts.ModulesValidateOncePerBuildSession
               && $lesseq_ulong(F.InputFilesValidationTimestamp, HSOpts.BuildSessionTimestamp)
               && F.Kind == ModuleKind.MK_ImplicitModule)) {
              N = NumInputs;
            }
            
            for (/*uint*/int I = 0; $less_uint(I, N); ++I) {
              InputFile IF = getInputFile(F, I + 1, Complain);
              if (!(IF.getFile() != null) || IF.isOutOfDate()) {
                return ASTReadResult.OutOfDate;
              }
            }
          }
          if (Listener.$bool()) {
            Listener.$arrow().visitModuleFile(new StringRef(F.FileName), F.Kind);
          }
          if (Listener.$bool() && Listener.$arrow().needsInputFileVisitation()) {
            /*uint*/int N = Listener.$arrow().needsSystemInputFileVisitation() ? NumInputs : NumUserInputs;
            for (/*uint*/int I = 0; $less_uint(I, N); ++I) {
              InputFileInfo FI = null;
              try {
                boolean IsSystem = $greatereq_uint(I, NumUserInputs);
                FI = readInputFileInfo(F, I + 1);
                Listener.$arrow().visitInputFile(new StringRef(FI.Filename), IsSystem, FI.Overridden, 
                    F.Kind == ModuleKind.MK_ExplicitModule);
              } finally {
                if (FI != null) { FI.$destroy(); }
              }
            }
          }
          
          return Result;
        }
       case SubBlock:
        switch (Entry.ID) {
         case BlockIDs.INPUT_FILES_BLOCK_ID:
          F.InputFilesCursor.$assign(Stream);
          if (Stream.SkipBlock() // Skip with the main cursor
            // Read the abbreviations
             || ReadBlockAbbrevs(F.InputFilesCursor, BlockIDs.INPUT_FILES_BLOCK_ID)) {
            Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
            return ASTReadResult.Failure;
          }
          continue;
         case BlockIDs.OPTIONS_BLOCK_ID:
          // If we're reading the first module for this group, check its options
          // are compatible with ours. For modules it imports, no further checking
          // is required, because we checked them when we built it.
          if (Listener.$bool() && !(ImportedBy != null)) {
            // Should we allow the configuration of the module file to differ from
            // the configuration of the current translation unit in a compatible
            // way?
            //
            // FIXME: Allow this for files explicitly specified with -include-pch.
            boolean AllowCompatibleConfigurationMismatch = F.Kind == ModuleKind.MK_ExplicitModule;
            
            Result = ReadOptionsBlock(Stream, ClientLoadCapabilities, 
                AllowCompatibleConfigurationMismatch, 
                Listener.$star(), SuggestedPredefines);
            if (Result == ASTReadResult.Failure) {
              Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
              return Result;
            }
            if (DisableValidation
               || (AllowConfigurationMismatch && Result == ASTReadResult.ConfigurationMismatch)) {
              Result = ASTReadResult.Success;
            }
            
            // If we can't load the module, exit early since we likely
            // will rebuild the module anyway. The stream may be in the
            // middle of a block.
            if (Result != ASTReadResult.Success) {
              return Result;
            }
          } else if (Stream.SkipBlock()) {
            Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
            return ASTReadResult.Failure;
          }
          continue;
         default:
          if (Stream.SkipBlock()) {
            Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
            return ASTReadResult.Failure;
          }
          continue;
        }
       case Record:
        // The interesting case.
        break;
      }
      
      // Read and process a record.
      Record.clear();
      StringRef Blob/*J*/= new StringRef();
      switch (Stream.readRecord(Entry.ID, Record, $AddrOf(Blob))) {
       case ControlRecordTypes.METADATA:
        {
          if (Record.$at(0) != $uint2ullong(VERSION_MAJOR) && !DisableValidation) {
            if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_VersionMismatch) == 0) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(Diag($less_ullong_uint(Record.$at(0), VERSION_MAJOR) ? diag.err_pch_version_too_old : diag.err_pch_version_too_new)));
              } finally {
                $c$.$destroy();
              }
            }
            return ASTReadResult.VersionMismatch;
          }
          
          boolean hasErrors = (Record.$at(6) != 0);
          if (hasErrors && !DisableValidation && !AllowASTWithCompilerErrors) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(Diag(diag.err_pch_with_compiler_errors)));
              return ASTReadResult.HadErrors;
            } finally {
              $c$.$destroy();
            }
          }
          if (hasErrors) {
            Diags.ErrorOccurred = true;
            Diags.UncompilableErrorOccurred = true;
            Diags.UnrecoverableErrorOccurred = true;
          }
          
          F.RelocatablePCH = (Record.$at(4) != 0);
          // Relative paths in a relocatable PCH are relative to our sysroot.
          if (F.RelocatablePCH) {
            F.BaseDirectory.$assignMove(isysroot.empty() ? new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$SLASH) : new std.string(isysroot));
          }
          
          F.HasTimestamps = (Record.$at(5) != 0);
          
          final /*const*/std.string/*&*/ CurBranch = getClangFullRepositoryVersion();
          StringRef ASTBranch = new StringRef(Blob);
          if ($noteq_StringRef(new StringRef(CurBranch), /*NO_COPY*/ASTBranch) && !DisableValidation) {
            if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_VersionMismatch) == 0) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_pch_different_branch)), /*NO_COPY*/ASTBranch), new StringRef(CurBranch)));
              } finally {
                $c$.$destroy();
              }
            }
            return ASTReadResult.VersionMismatch;
          }
          break;
        }
       case ControlRecordTypes.SIGNATURE:
        assert ((!(F.Signature != 0) || $uint2ullong(F.Signature) == Record.$at(0))) : "signature changed";
        F.Signature = $ullong2uint(Record.$at(0));
        break;
       case ControlRecordTypes.IMPORTS:
        {
          // Load each of the imported PCH files. 
          uint$ref Idx = create_uint$ref(0);
          /*uint*/int N = Record.size();
          while ($less_uint(Idx.$deref(), N)) {
            // Read information about the AST file.
            ModuleKind ImportedKind = ModuleKind.valueOf((int)Record.$at(Idx.$set$postInc()));
            // The import location will be the local one for now; we will adjust
            // all import locations of module imports after the global source
            // location info are setup, in ReadAST.
            SourceLocation ImportLoc = ReadUntranslatedSourceLocation($ullong2uint(Record.$at(Idx.$set$postInc())));
            long/*off_t*/ StoredSize = (long/*off_t*/)$ullong2long(Record.$at(Idx.$set$postInc()));
            long/*time_t*/ StoredModTime = (long/*time_t*/)$ullong2long(Record.$at(Idx.$set$postInc()));
            /*uint*/int StoredSignature = $ullong2uint(Record.$at(Idx.$set$postInc()));
            std.string ImportedFile = ReadPath(F, Record, Idx);
            
            // If our client can't cope with us being out of date, we can't cope with
            // our dependency being missing.
            /*uint*/int Capabilities = ClientLoadCapabilities;
            if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
              Capabilities &= ~LoadFailureCapabilities.ARR_Missing;
            }
            
            // Load the AST file.
            ASTReadResult Result$1 = ReadASTCore(new StringRef(ImportedFile), ImportedKind, new SourceLocation(ImportLoc), $AddrOf(F), 
                Loaded, StoredSize, StoredModTime, 
                StoredSignature, Capabilities);
            
            // If we diagnosed a problem, produce a backtrace.
            if (isDiagnosedResult(Result$1, Capabilities)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_module_file_imported_by)), 
                            new StringRef(F.FileName)), !F.ModuleName.empty()), new StringRef(F.ModuleName)));
              } finally {
                $c$.$destroy();
              }
            }
            switch (Result$1) {
             case Failure:
              return ASTReadResult.Failure;
             case Missing:
             case OutOfDate:
              // If we have to ignore the dependency, we'll have to ignore this too.
              return ASTReadResult.OutOfDate;
             case VersionMismatch:
              return ASTReadResult.VersionMismatch;
             case ConfigurationMismatch:
              return ASTReadResult.ConfigurationMismatch;
             case HadErrors:
              return ASTReadResult.HadErrors;
             case Success:
              break;
            }
          }
          break;
        }
       case ControlRecordTypes.ORIGINAL_FILE:
        F.OriginalSourceFileID.$assignMove(FileID.get($ullong2int(Record.$at(0))));
        F.ActualOriginalSourceFileName.$assignMove(Blob.$string());
        F.OriginalSourceFileName.$assign(F.ActualOriginalSourceFileName);
        ResolveImportedPath(F, F.OriginalSourceFileName);
        break;
       case ControlRecordTypes.ORIGINAL_FILE_ID:
        F.OriginalSourceFileID.$assignMove(FileID.get($ullong2int(Record.$at(0))));
        break;
       case ControlRecordTypes.ORIGINAL_PCH_DIR:
        F.OriginalDir.$assignMove(Blob.$string());
        break;
       case ControlRecordTypes.MODULE_NAME:
        F.ModuleName.$assignMove(Blob.$string());
        if (Listener.$bool()) {
          Listener.$arrow().ReadModuleName(new StringRef(F.ModuleName));
        }
        break;
       case ControlRecordTypes.MODULE_DIRECTORY:
        {
          assert (!F.ModuleName.empty()) : "MODULE_DIRECTORY found before MODULE_NAME";
          // If we've already loaded a module map file covering this module, we may
          // have a better path for it (relative to the current build).
          Module /*P*/ M = PP.getHeaderSearchInfo().lookupModule(new StringRef(F.ModuleName));
          if ((M != null) && (M.Directory != null)) {
            // If we're implicitly loading a module, the base directory can't
            // change between the build and use.
            if (F.Kind != ModuleKind.MK_ExplicitModule) {
              /*const*/ DirectoryEntry /*P*/ BuildDir = PP.getFileManager().getDirectory(/*NO_COPY*/Blob);
              if (!(BuildDir != null) || BuildDir != M.Directory) {
                if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_imported_module_relocated)), 
                                new StringRef(F.ModuleName)), /*NO_COPY*/Blob), M.Directory.getName()));
                  } finally {
                    $c$.$destroy();
                  }
                }
                return ASTReadResult.OutOfDate;
              }
            }
            F.BaseDirectory.$assign_T$C$P(M.Directory.getName());
          } else {
            F.BaseDirectory.$assignMove(Blob.$string());
          }
          break;
        }
       case ControlRecordTypes.MODULE_MAP_FILE:
        {
          ASTReadResult Result$1 = ReadModuleMapFileBlock(Record, F, ImportedBy, ClientLoadCapabilities);
          if ((Result$1.getValue() != 0)) {
            return Result$1;
          }
        }
        break;
       case ControlRecordTypes.INPUT_FILE_OFFSETS:
        NumInputs = $ullong2uint(Record.$at(0));
        NumUserInputs = $ullong2uint(Record.$at(1));
        // JAVA use ulong$ptr vs unaligned_int64_t
        /*unaligned_uint64_t*/ulong$ptr tmp = reinterpret_cast(ulong$ptr.class, Blob.data());
//        for(int i = 0; i < NumInputs; i++) {
//          tmp[i] = new unaligned_uint64_t(Blob.data().$add(i*8));//new llvm.support.unaligned_uint64_t(Blob.data().$add(i*8));
//        }
        F.InputFileOffsets = $toConst(tmp);
           //= (/*const*/type$ptr<llvm.support.unaligned_int64_t /*P*/>)Blob.data();
        F.InputFilesLoaded.resize(NumInputs);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadOptionsBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 2084,
   FQN="clang::ASTReader::ReadOptionsBlock", NM="_ZN5clang9ASTReader16ReadOptionsBlockERN4llvm15BitstreamCursorEjbRNS_17ASTReaderListenerERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16ReadOptionsBlockERN4llvm15BitstreamCursorEjbRNS_17ASTReaderListenerERSs")
  //</editor-fold>
  private static ASTReader.ASTReadResult ReadOptionsBlock(final BitstreamCursor /*&*/ Stream, /*uint*/int ClientLoadCapabilities, 
                  boolean AllowCompatibleConfigurationMismatch, final ASTReaderListener /*&*/ Listener, 
                  final std.string/*&*/ SuggestedPredefines) {
    if (Stream.EnterSubBlock(BlockIDs.OPTIONS_BLOCK_ID)) {
      return ASTReadResult.Failure;
    }
    
    // Read all of the records in the options block.
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    ASTReadResult Result = ASTReadResult.Success;
    while (true) {
      BitstreamEntry Entry = Stream.advance();
      switch (Entry.Kind) {
       case Error:
       case SubBlock:
        return ASTReadResult.Failure;
       case EndBlock:
        return Result;
       case Record:
        // The interesting case.
        break;
      }
      
      // Read and process a record.
      Record.clear();
      switch (Stream.readRecord(Entry.ID, Record)) {
       case OptionsRecordTypes.LANGUAGE_OPTIONS:
        {
          boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_ConfigurationMismatch) == 0;
          if (ASTReader.ParseLanguageOptions(Record, Complain, Listener, 
              AllowCompatibleConfigurationMismatch)) {
            Result = ASTReadResult.ConfigurationMismatch;
          }
          break;
        }
       case OptionsRecordTypes.TARGET_OPTIONS:
        {
          boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_ConfigurationMismatch) == 0;
          if (ASTReader.ParseTargetOptions(Record, Complain, Listener, 
              AllowCompatibleConfigurationMismatch)) {
            Result = ASTReadResult.ConfigurationMismatch;
          }
          break;
        }
       case OptionsRecordTypes.DIAGNOSTIC_OPTIONS:
        {
          boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0;
          if (!AllowCompatibleConfigurationMismatch
             && ASTReader.ParseDiagnosticOptions(Record, Complain, Listener)) {
            return ASTReadResult.OutOfDate;
          }
          break;
        }
       case OptionsRecordTypes.FILE_SYSTEM_OPTIONS:
        {
          boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_ConfigurationMismatch) == 0;
          if (!AllowCompatibleConfigurationMismatch
             && ASTReader.ParseFileSystemOptions(Record, Complain, Listener)) {
            Result = ASTReadResult.ConfigurationMismatch;
          }
          break;
        }
       case OptionsRecordTypes.HEADER_SEARCH_OPTIONS:
        {
          boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_ConfigurationMismatch) == 0;
          if (!AllowCompatibleConfigurationMismatch
             && ASTReader.ParseHeaderSearchOptions(Record, Complain, Listener)) {
            Result = ASTReadResult.ConfigurationMismatch;
          }
          break;
        }
       case OptionsRecordTypes.PREPROCESSOR_OPTIONS:
        boolean Complain = (ClientLoadCapabilities & LoadFailureCapabilities.ARR_ConfigurationMismatch) == 0;
        if (!AllowCompatibleConfigurationMismatch
           && ASTReader.ParsePreprocessorOptions(Record, Complain, Listener, 
            SuggestedPredefines)) {
          Result = ASTReadResult.ConfigurationMismatch;
        }
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadASTBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 2450,
   FQN="clang::ASTReader::ReadASTBlock", NM="_ZN5clang9ASTReader12ReadASTBlockERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12ReadASTBlockERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  private ASTReader.ASTReadResult ReadASTBlock(final ModuleFile /*&*/ F, /*uint*/int ClientLoadCapabilities) {
    final BitstreamCursor /*&*/ Stream = F.Stream;
    if (Stream.EnterSubBlock(BlockIDs.AST_BLOCK_ID)) {
      Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
      return ASTReadResult.Failure;
    }
    
    // Read all of the records and blocks for the AST file.
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    while (true) {
      BitstreamEntry Entry = Stream.advance();
      switch (Entry.Kind) {
       case Error:
        Error(new StringRef(/*KEEP_STR*/"error at end of module block in AST file"));
        return ASTReadResult.Failure;
       case EndBlock:
        {
          // Outside of C++, we do not store a lookup map for the translation unit.
          // Instead, mark it as needing a lookup map to be built if this module
          // contains any declarations lexically within it (which it always does!).
          // This usually has no cost, since we very rarely need the lookup map for
          // the translation unit outside C++.
          DeclContext /*P*/ DC = Context.getTranslationUnitDecl();
          if (DC.hasExternalLexicalStorage()
             && !getContext().getLangOpts().CPlusPlus) {
            DC.setMustBuildLookupTable();
          }
          
          return ASTReadResult.Success;
        }
       case SubBlock:
        switch (Entry.ID) {
         case BlockIDs.DECLTYPES_BLOCK_ID:
          // We lazily load the decls block, but we want to set up the
          // DeclsCursor cursor to point into it.  Clone our current bitcode
          // cursor to it, enter the block and read the abbrevs in that block.
          // With the main cursor, we just skip over it.
          F.DeclsCursor.$assign(Stream);
          if (Stream.SkipBlock() // Skip with the main cursor.
            // Read the abbrevs.
             || ReadBlockAbbrevs(F.DeclsCursor, BlockIDs.DECLTYPES_BLOCK_ID)) {
            Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
            return ASTReadResult.Failure;
          }
          break;
         case BlockIDs.PREPROCESSOR_BLOCK_ID:
          F.MacroCursor.$assign(Stream);
          if (!(PP.getExternalSource() != null)) {
            PP.setExternalSource(this);
          }
          if (Stream.SkipBlock()
             || ReadBlockAbbrevs(F.MacroCursor, BlockIDs.PREPROCESSOR_BLOCK_ID)) {
            Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
            return ASTReadResult.Failure;
          }
          F.MacroStartOffset = F.MacroCursor.GetCurrentBitNo();
          break;
         case BlockIDs.PREPROCESSOR_DETAIL_BLOCK_ID:
          F.PreprocessorDetailCursor.$assign(Stream);
          if (Stream.SkipBlock()
             || ReadBlockAbbrevs(F.PreprocessorDetailCursor, 
              BlockIDs.PREPROCESSOR_DETAIL_BLOCK_ID)) {
            Error(new StringRef(/*KEEP_STR*/"malformed preprocessor detail record in AST file"));
            return ASTReadResult.Failure;
          }
          F.PreprocessorDetailStartOffset
             = F.PreprocessorDetailCursor.GetCurrentBitNo();
          if (!(PP.getPreprocessingRecord() != null)) {
            PP.createPreprocessingRecord();
          }
          if (!(PP.getPreprocessingRecord().getExternalSource() != null)) {
            PP.getPreprocessingRecord().SetExternalSource(/*Deref*/this);
          }
          break;
         case BlockIDs.SOURCE_MANAGER_BLOCK_ID:
          if (ReadSourceManagerBlock(F)) {
            return ASTReadResult.Failure;
          }
          break;
         case BlockIDs.SUBMODULE_BLOCK_ID:
          {
            ASTReadResult Result = ReadSubmoduleBlock(F, ClientLoadCapabilities);
            if ((Result.getValue() != 0)) {
              return Result;
            }
          }
          break;
         case BlockIDs.COMMENTS_BLOCK_ID:
          {
            BitstreamCursor C = null;
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              C = new BitstreamCursor(Stream);
              if (Stream.SkipBlock()
                 || ReadBlockAbbrevs(C, BlockIDs.COMMENTS_BLOCK_ID)) {
                Error(new StringRef(/*KEEP_STR*/"malformed comments block in AST file"));
                return ASTReadResult.Failure;
              }
              CommentsCursors.push_back_T$RR($c$.track(std.make_pair_T_Ptr($Clone(C), $AddrOf(F)))); $c$.clean();
              break;
            } finally {
              if (C != null) { C.$destroy(); }
              $c$.$destroy();
            }
          }
         default:
          if (Stream.SkipBlock()) {
            Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
            return ASTReadResult.Failure;
          }
          break;
        }
        continue;
       case Record:
        // The interesting case.
        break;
      }
      
      // Read and process a record.
      Record.clear();
      StringRef Blob/*J*/= new StringRef();
      switch (Stream.readRecord(Entry.ID, Record, $AddrOf(Blob))) {
       default: // Default behavior: ignore.
        break;
       case ASTRecordTypes.TYPE_OFFSET:
        {
          if (F.LocalNumTypes != 0) {
            Error(new StringRef(/*KEEP_STR*/"duplicate TYPE_OFFSET record in AST file"));
            return ASTReadResult.Failure;
          }
          F.TypeOffsets = $toConst($tryClone(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, Blob.data())));
          F.LocalNumTypes = $ullong2uint(Record.$at(0));
          /*uint*/int LocalBaseTypeIndex = $ullong2uint(Record.$at(1));
          F.BaseTypeIndex = getTotalNumTypes();
          if ($greater_uint(F.LocalNumTypes, 0)) {
            // Introduce the global -> local mapping for types within this module.
            GlobalTypeMap.insert(std.make_pair_uint_Ptr(getTotalNumTypes(), $AddrOf(F)));
            
            // Introduce the local -> global mapping for types within this module.
            F.TypeRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBaseTypeIndex, /*Fwd2*//*Fwd*/F.BaseTypeIndex - LocalBaseTypeIndex));
            
            TypesLoaded.resize(TypesLoaded.size() + F.LocalNumTypes);
          }
          break;
        }
       case ASTRecordTypes.DECL_OFFSET:
        {
          if (F.LocalNumDecls != 0) {
            Error(new StringRef(/*KEEP_STR*/"duplicate DECL_OFFSET record in AST file"));
            return ASTReadResult.Failure;
          }
          DeclOffset[] tmp = new DeclOffset[Blob.size()/8];
          char$ptr ptr = $Clone(Blob.data());
          for(int i = 0; i < tmp.length; i++) {
            tmp[i] = new DeclOffset(endian.readNext_uint32(endianness.little, support.unaligned, ptr), endian.readNext_uint32(endianness.little, support.unaligned, ptr));
          }
          F.DeclOffsets = create_type$ptr(tmp);//(/*const*/ DeclOffset /*P*/ )Blob.data();
          F.LocalNumDecls = $ullong2uint(Record.$at(0));
          /*uint*/int LocalBaseDeclID = $ullong2uint(Record.$at(1));
          F.BaseDeclID = getTotalNumDecls();
          if ($greater_uint(F.LocalNumDecls, 0)) {
            // Introduce the global -> local mapping for declarations within this 
            // module.
            GlobalDeclMap.insert(std.make_pair_uint_Ptr(getTotalNumDecls() + NUM_PREDEF_DECL_IDS, $AddrOf(F)));
            
            // Introduce the local -> global mapping for declarations within this
            // module.
            F.DeclRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBaseDeclID, /*Fwd2*//*Fwd*/F.BaseDeclID - LocalBaseDeclID));
            
            // Introduce the global -> local mapping for declarations within this
            // module.
            F.GlobalToLocalDeclIDs.$set($AddrOf(F), LocalBaseDeclID);
            
            DeclsLoaded.resize(DeclsLoaded.size() + F.LocalNumDecls);
          }
          break;
        }
       case ASTRecordTypes.TU_UPDATE_LEXICAL:
        {
          DeclContext /*P*/ TU = Context.getTranslationUnitDecl();
          ArrayRefUInt/*<unaligned_uint32_t>*/ Contents/*J*/= new ArrayRefUInt/*<unaligned_uint32_t>*/(
                  ((/*unaligned_uint32_t*/uint$ptr /*P*/ )
                          $toConst(reinterpret_cast(/*const*//*unaligned_uint32_t*/uint$ptr.class, Blob.data()))), 
              ((/*static_cast*//*uint*/int)($div_uint(Blob.size(), 4))), false);
          TULexicalDecls.push_back_T$RR(
                  std.make_pair_Ptr_T($AddrOf(F), $Clone(Contents)));
          TU.setHasExternalLexicalStorage(true);
          break;
        }
       case ASTRecordTypes.UPDATE_VISIBLE:
        {
          uint$ref Idx = create_uint$ref(0);
          /*uint32_t*/int ID = ReadDeclID(F, Record, Idx);
          /*const*/char$ptr/*uchar P*/ Data = $toConst($tryClone(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data())));
          PendingVisibleUpdates.$at_T1$C$R(ID).push_back(((PendingVisibleUpdate)(new PendingVisibleUpdate($AddrOf(F), Data))));
          {
            // If we've already loaded the decl, perform the updates when we finish
            // loading this block.
            Decl /*P*/ D = GetExistingDecl(ID);
            if ((D != null)) {
              PendingUpdateRecords.push_back(std.make_pair_uint_Ptr(ID, D));
            }
          }
          break;
        }
       case ASTRecordTypes.IDENTIFIER_TABLE:
        F.IdentifierTableData = $tryClone(Blob.data());
        if ((Record.$at(0) != 0)) {
          F.IdentifierLookupTable = OnDiskIterableChainedHashTable.Create(
                  reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, F.IdentifierTableData).$add((int)Record.$at(0)), 
              reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, F.IdentifierTableData).$add($sizeof_UInt()), 
              reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, F.IdentifierTableData), 
              new ASTIdentifierLookupTrait(/*Deref*/this, F));
          
          PP.getIdentifierTable().setExternalIdentifierLookup(this);
        }
        break;
       case ASTRecordTypes.IDENTIFIER_OFFSET:
        {
          if (F.LocalNumIdentifiers != 0) {
            Error(new StringRef(/*KEEP_STR*/"duplicate IDENTIFIER_OFFSET record in AST file"));
            return ASTReadResult.Failure;
          }
          F.IdentifierOffsets = $toConst($tryClone(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, Blob.data())));
          F.LocalNumIdentifiers = $ullong2uint(Record.$at(0));
          /*uint*/int LocalBaseIdentifierID = $ullong2uint(Record.$at(1));
          F.BaseIdentifierID = getTotalNumIdentifiers();
          if ($greater_uint(F.LocalNumIdentifiers, 0)) {
            // Introduce the global -> local mapping for identifiers within this
            // module.
            GlobalIdentifierMap.insert(std.make_pair_uint_Ptr(getTotalNumIdentifiers() + 1, $AddrOf(F)
                    ));
            
            // Introduce the local -> global mapping for identifiers within this
            // module.
            F.IdentifierRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBaseIdentifierID, /*Fwd2*//*Fwd*/F.BaseIdentifierID - LocalBaseIdentifierID));
            
            IdentifiersLoaded.resize(IdentifiersLoaded.size()
                   + F.LocalNumIdentifiers);
          }
          break;
        }
       case ASTRecordTypes.INTERESTING_IDENTIFIERS:
        F.PreloadIdentifierOffsets.assign$T(Record.begin(), Record.end());
        break;
       case ASTRecordTypes.EAGERLY_DESERIALIZED_DECLS:
        // FIXME: Skip reading this record if our ASTConsumer doesn't care
        // about "interesting" decls (for instance, if we're building a module).
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          EagerlyDeserializedDecls.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.SPECIAL_TYPES:
        if (SpecialTypes.empty()) {
          for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
            SpecialTypes.push_back($uint2ullong(getGlobalTypeID(F, $ullong2uint(Record.$at(I)))));
          }
          break;
        }
        if (SpecialTypes.size() != Record.size()) {
          Error(new StringRef(/*KEEP_STR*/"invalid special-types record"));
          return ASTReadResult.Failure;
        }
        
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I) {
          /*uint32_t*/int ID = getGlobalTypeID(F, $ullong2uint(Record.$at(I)));
          if (!(SpecialTypes.$at(I) != 0)) {
            SpecialTypes.$set(I, $uint2ullong(ID));
          }
          // FIXME: If ID && SpecialTypes[I] != ID, do we need a separate
          // merge step?
        }
        break;
       case ASTRecordTypes.STATISTICS:
        TotalNumStatements += Record.$at(0);
        TotalNumMacros += Record.$at(1);
        TotalLexicalDeclContexts += Record.$at(2);
        TotalVisibleDeclContexts += Record.$at(3);
        break;
       case ASTRecordTypes.UNUSED_FILESCOPED_DECLS:
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          UnusedFileScopedDecls.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.DELEGATING_CTORS:
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          DelegatingCtorDecls.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.WEAK_UNDECLARED_IDENTIFIERS:
        if ($rem_uint(Record.size(), 4) != 0) {
          Error(new StringRef(/*KEEP_STR*/"invalid weak identifiers record"));
          return ASTReadResult.Failure;
        }
        
        // FIXME: Ignore weak undeclared identifiers from non-original PCH 
        // files. This isn't the way to do it :)
        WeakUndeclaredIdentifiers.clear();
        
        // Translate the weak, undeclared identifiers into global IDs.
        int N_for = Record.size();
        for (uint$ref I = create_uint$ref(0); $less_uint(I.$deref(), N_for);) {
          WeakUndeclaredIdentifiers.push_back($uint2ullong(getGlobalIdentifierID(F, $ullong2uint(Record.$at(I.$set$postInc())))));
          WeakUndeclaredIdentifiers.push_back($uint2ullong(getGlobalIdentifierID(F, $ullong2uint(Record.$at(I.$set$postInc())))));
          WeakUndeclaredIdentifiers.push_back($uint2ullong(ReadSourceLocation(F, Record, I).getRawEncoding()));
          WeakUndeclaredIdentifiers.push_back(Record.$at(I.$set$postInc()));
        }
        break;
       case ASTRecordTypes.SELECTOR_OFFSETS:
        {
          F.SelectorOffsets = $toConst($tryClone(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, Blob.data())));
          F.LocalNumSelectors = $ullong2uint(Record.$at(0));
          /*uint*/int LocalBaseSelectorID = $ullong2uint(Record.$at(1));
          F.BaseSelectorID = getTotalNumSelectors();
          if ($greater_uint(F.LocalNumSelectors, 0)) {
            // Introduce the global -> local mapping for selectors within this 
            // module.
            GlobalSelectorMap.insert(std.make_pair_uint_Ptr(getTotalNumSelectors() + 1, $AddrOf(F)));
            
            // Introduce the local -> global mapping for selectors within this 
            // module.
            F.SelectorRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBaseSelectorID, /*Fwd2*//*Fwd*/F.BaseSelectorID - LocalBaseSelectorID));
            
            SelectorsLoaded.resize(SelectorsLoaded.size() + F.LocalNumSelectors);
          }
          break;
        }
       case ASTRecordTypes.METHOD_POOL:
        F.SelectorLookupTableData = $toConst($tryClone(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data())));
        if ((Record.$at(0) != 0)) {
          F.SelectorLookupTable
             = OnDiskChainedHashTable.Create(F.SelectorLookupTableData.$add((int)Record.$at(0)), 
              F.SelectorLookupTableData, 
              new ASTSelectorLookupTrait(/*Deref*/this, F));
        }
        TotalNumMethodPoolEntries += Record.$at(1);
        break;
       case ASTRecordTypes.REFERENCED_SELECTOR_POOL:
        if (!Record.empty()) {
          int N_tmp = Record.size() - 1;
          for (uint$ref Idx = create_uint$ref(0) ; $less_uint(Idx.$deref(), N_tmp);) {
            ReferencedSelectorsData.push_back($uint2ullong(getGlobalSelectorID(F, 
                    $ullong2uint(Record.$at(Idx.$set$postInc())))));
            ReferencedSelectorsData.push_back($uint2ullong(ReadSourceLocation(F, Record, Idx).
                    getRawEncoding()));
          }
        }
        break;
       case ASTRecordTypes.PP_COUNTER_VALUE:
        if (!Record.empty() && Listener.$bool()) {
          Listener.$arrow().ReadCounter(F, $ullong2uint(Record.$at(0)));
        }
        break;
       case ASTRecordTypes.FILE_SORTED_DECLS:
        F.FileSortedDecls = $toConst($tryClone(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, Blob.data())));
        F.NumFileSortedDecls = $ullong2uint(Record.$at(0));
        break;
       case ASTRecordTypes.SOURCE_LOCATION_OFFSETS:
        {
          F.SLocEntryOffsets = $toConst($tryClone(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, Blob.data())));
          F.LocalNumSLocEntries = $ullong2uint(Record.$at(0));
          /*uint*/int SLocSpaceSize = $ullong2uint(Record.$at(1));
          pairIntUInt tmp = SourceMgr.AllocateLoadedSLocEntries(F.LocalNumSLocEntries, SLocSpaceSize);
          F.SLocEntryBaseID = tmp.first;
          F.SLocEntryBaseOffset = tmp.second;
          //std.tie(F.SLocEntryBaseID, F.SLocEntryBaseOffset).$assign(
          //    SourceMgr.AllocateLoadedSLocEntries(F.LocalNumSLocEntries, 
          //        SLocSpaceSize)
          //);
          if (!(F.SLocEntryBaseID != 0)) {
            Error(new StringRef(/*KEEP_STR*/"ran out of source locations"));
            break;
          }
          // Make our entry in the range map. BaseID is negative and growing, so
          // we invert it. Because we invert it, though, we need the other end of
          // the range.
          /*uint*/int RangeStart = ((/*uint*/int)(-F.SLocEntryBaseID)) - F.LocalNumSLocEntries + 1;
          GlobalSLocEntryMap.insert(std.make_pair_uint_Ptr(RangeStart, $AddrOf(F)));
          F.FirstLoc.$assignMove(SourceLocation.getFromRawEncoding(F.SLocEntryBaseOffset));
          
          // SLocEntryBaseOffset is lower than MaxLoadedOffset and decreasing.
          assert ((F.SLocEntryBaseOffset & (1/*U*/ << 31/*U*/)) == 0);
          GlobalSLocOffsetMap.insert(std.make_pair_uint_Ptr(SourceManager.MaxLoadedOffset - F.SLocEntryBaseOffset
   - SLocSpaceSize, $AddrOf(F)));
          
          // Initialize the remapping table.
          // Invalid stays invalid.
          F.SLocRemap.insertOrReplace(std.make_pair_uint_int(0/*U*/, 0));
          // This module. Base was 2 when being compiled.
          F.SLocRemap.insertOrReplace(std.make_pair_uint_int(2/*U*/, ((/*static_cast*/int)(F.SLocEntryBaseOffset - 2))
                  ));
          
          TotalNumSLocEntries += F.LocalNumSLocEntries;
          break;
        }
       case ASTRecordTypes.MODULE_OFFSET_MAP:
        {
          ContinuousRangeMapUIntInt.Builder SLocRemap = null;
          ContinuousRangeMapUIntInt.Builder IdentifierRemap = null;
          ContinuousRangeMapUIntInt.Builder MacroRemap = null;
          ContinuousRangeMapUIntInt.Builder PreprocessedEntityRemap = null;
          ContinuousRangeMapUIntInt.Builder SubmoduleRemap = null;
          ContinuousRangeMapUIntInt.Builder SelectorRemap = null;
          ContinuousRangeMapUIntInt.Builder DeclRemap = null;
          ContinuousRangeMapUIntInt.Builder TypeRemap = null;
          try {
            // Additional remapping information.
            /*const*/char$ptr/*uchar P*/ Data = $tryClone(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()));
            /*const*/char$ptr/*uchar P*/ DataEnd = $tryClone(Data.$add(Blob.size()));
            
            // If we see this entry before SOURCE_LOCATION_OFFSETS, add placeholders.
            if ($eq_ptr(F.SLocRemap.find(0), F.SLocRemap.end())) {
              F.SLocRemap.insert(std.make_pair_uint_int(0/*U*/, 0));
              F.SLocRemap.insert(std.make_pair_uint_int(2/*U*/, 1));
            }
            
            // Continuous range maps we may be updating in our module.
            // JAVA: typedef ContinuousRangeMap<uint32_t, int, 2>::Builder RemapBuilder
//            final class RemapBuilder extends ContinuousRangeMap.Builder</*uint32_t*/int, int, 2>{ };
            SLocRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.SLocRemap);
            IdentifierRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.IdentifierRemap);
            MacroRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.MacroRemap);
            PreprocessedEntityRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.PreprocessedEntityRemap);
            SubmoduleRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.SubmoduleRemap);
            SelectorRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.SelectorRemap);
            DeclRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.DeclRemap);
            TypeRemap/*J*/= new ContinuousRangeMapUIntInt.Builder(2, F.TypeRemap);
            while (Data.$less(DataEnd)) {
              //JAVA: using namespace llvm::support;
              /*uint16_t*/char Len = endian.readNext_uint16(endianness.little, support.unaligned, Data);
              StringRef Name = new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Data), $ushort2uint(Len));
              Data.$inc($ushort2int(Len));
              ModuleFile /*P*/ OM = ModuleMgr.lookup(new StringRef(Name));
              if (!(OM != null)) {
                Error(new StringRef(/*KEEP_STR*/"SourceLocation remap refers to unknown module"));
                return ASTReadResult.Failure;
              }
              
              /*uint32_t*/int SLocOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int IdentifierIDOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int MacroIDOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int PreprocessedEntityIDOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int SubmoduleIDOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int SelectorIDOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int DeclIDOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              /*uint32_t*/int TypeIndexOffset = endian.readNext_uint32(endianness.little, support.unaligned, Data);
              
              /*uint32_t*/int None = std.numeric_limitsUInt.max();
              
              UIntUIntRemapBuilder2Void mapOffset = /*[&, &None]*/ (/*uint32_t*/int Offset, /*uint32_t*/int BaseOffset, final ContinuousRangeMapUIntInt.Builder/*&*/ Remap) -> {
                  if (Offset != None) {
                    Remap.insert(std.make_pair_uint_int(Offset, ((/*static_cast*/int)(BaseOffset - Offset))
                            ));
                  }
                };
              mapOffset.$call(SLocOffset, OM.SLocEntryBaseOffset, SLocRemap);
              mapOffset.$call(IdentifierIDOffset, OM.BaseIdentifierID, IdentifierRemap);
              mapOffset.$call(MacroIDOffset, OM.BaseMacroID, MacroRemap);
              mapOffset.$call(PreprocessedEntityIDOffset, OM.BasePreprocessedEntityID, 
                  PreprocessedEntityRemap
              );
              mapOffset.$call(SubmoduleIDOffset, OM.BaseSubmoduleID, SubmoduleRemap);
              mapOffset.$call(SelectorIDOffset, OM.BaseSelectorID, SelectorRemap);
              mapOffset.$call(DeclIDOffset, OM.BaseDeclID, DeclRemap);
              mapOffset.$call(TypeIndexOffset, OM.BaseTypeIndex, TypeRemap);
              
              // Global -> local mappings.
              F.GlobalToLocalDeclIDs.$set(OM, DeclIDOffset);
            }
            break;
          } finally {
            if (TypeRemap != null) { TypeRemap.$destroy(); }
            if (DeclRemap != null) { DeclRemap.$destroy(); }
            if (SelectorRemap != null) { SelectorRemap.$destroy(); }
            if (SubmoduleRemap != null) { SubmoduleRemap.$destroy(); }
            if (PreprocessedEntityRemap != null) { PreprocessedEntityRemap.$destroy(); }
            if (MacroRemap != null) { MacroRemap.$destroy(); }
            if (IdentifierRemap != null) { IdentifierRemap.$destroy(); }
            if (SLocRemap != null) { SLocRemap.$destroy(); }
          }
        }
       case ASTRecordTypes.SOURCE_MANAGER_LINE_TABLE:
        if (ParseLineTable(F, Record)) {
          return ASTReadResult.Failure;
        }
        break;
       case ASTRecordTypes.SOURCE_LOCATION_PRELOADS:
        {
          // Need to transform from the local view (1-based IDs) to the global view,
          // which is based off F.SLocEntryBaseID.
          if (!F.PreloadSLocEntries.empty()) {
            Error(new StringRef(/*KEEP_STR*/"Multiple SOURCE_LOCATION_PRELOADS records in AST file"));
            return ASTReadResult.Failure;
          }
          
          F.PreloadSLocEntries.swap(Record);
          break;
        }
       case ASTRecordTypes.EXT_VECTOR_DECLS:
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          ExtVectorDecls.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.VTABLE_USES:
        if ($rem_uint(Record.size(), 3) != 0) {
          Error(new StringRef(/*KEEP_STR*/"Invalid VTABLE_USES record"));
          return ASTReadResult.Failure;
        }
        
        // Later tables overwrite earlier ones.
        // FIXME: Modules will have some trouble with this. This is clearly not
        // the right way to do this.
        VTableUses.clear();
        int N_tmp1 = Record.size();
        for (uint$ref Idx = create_uint$ref(0); Idx.$deref() != N_tmp1;) {
          VTableUses.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(Idx.$set$postInc())))));
          VTableUses.push_back($uint2ullong(ReadSourceLocation(F, Record, Idx).getRawEncoding()));
          VTableUses.push_back(Record.$at(Idx.$set$postInc()));
        }
        break;
       case ASTRecordTypes.PENDING_IMPLICIT_INSTANTIATIONS:
        if ($rem_uint(PendingInstantiations.size(), 2) != 0) {
          Error(new StringRef(/*KEEP_STR*/"Invalid existing PendingInstantiations"));
          return ASTReadResult.Failure;
        }
        if ($rem_uint(Record.size(), 2) != 0) {
          Error(new StringRef(/*KEEP_STR*/"Invalid PENDING_IMPLICIT_INSTANTIATIONS block"));
          return ASTReadResult.Failure;
        }
        
        int N_tmp2 = Record.size();
        for (uint$ref I = create_uint$ref(0); I.$deref() != N_tmp2;) {
          PendingInstantiations.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I.$set$postInc())))));
          PendingInstantiations.push_back($uint2ullong(ReadSourceLocation(F, Record, I).getRawEncoding()));
        }
        break;
       case ASTRecordTypes.SEMA_DECL_REFS:
        if (Record.size() != 2) {
          Error(new StringRef(/*KEEP_STR*/"Invalid SEMA_DECL_REFS block"));
          return ASTReadResult.Failure;
        }
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          SemaDeclRefs.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.PPD_ENTITIES_OFFSETS:
        {
          assert ($rem_uint(Blob.size(), PPEntityOffset.$sizeof_PPEntityOffset()) == 0);
          F.NumPreprocessedEntities = $div_uint(Blob.size(), PPEntityOffset.$sizeof_PPEntityOffset());
          PPEntityOffset[] tmp = new PPEntityOffset[F.NumPreprocessedEntities];
          char$ptr ptr = $Clone(Blob.data());
          for(int i = 0; i < tmp.length; i++) {
            tmp[i] = new PPEntityOffset(endian.readNext_uint32(endianness.little, support.unaligned, ptr),
                                        endian.readNext_uint32(endianness.little, support.unaligned, ptr),
                                        endian.readNext_uint32(endianness.little, support.unaligned, ptr));
          }
          F.PreprocessedEntityOffsets = create_type$ptr(tmp);//(/*const*/ PPEntityOffset /*P*/ )Blob.data();
          
          /*uint*/int LocalBasePreprocessedEntityID = $ullong2uint(Record.$at(0));
          
          /*uint*/int StartingID;
          if (!(PP.getPreprocessingRecord() != null)) {
            PP.createPreprocessingRecord();
          }
          if (!(PP.getPreprocessingRecord().getExternalSource() != null)) {
            PP.getPreprocessingRecord().SetExternalSource(/*Deref*/this);
          }
          StartingID
             = PP.getPreprocessingRecord().
              allocateLoadedEntities(F.NumPreprocessedEntities);
          F.BasePreprocessedEntityID = StartingID;
          if ($greater_uint(F.NumPreprocessedEntities, 0)) {
            // Introduce the global -> local mapping for preprocessed entities in
            // this module.
            GlobalPreprocessedEntityMap.insert(std.make_pair_uint_Ptr(StartingID, $AddrOf(F)));
            
            // Introduce the local -> global mapping for preprocessed entities in
            // this module.
            F.PreprocessedEntityRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBasePreprocessedEntityID, /*Fwd2*//*Fwd*/F.BasePreprocessedEntityID - LocalBasePreprocessedEntityID));
          }
          
          break;
        }
       case ASTRecordTypes.DECL_UPDATE_OFFSETS:
        {
          if ($rem_uint(Record.size(), 2) != 0) {
            Error(new StringRef(/*KEEP_STR*/"invalid DECL_UPDATE_OFFSETS block in AST file"));
            return ASTReadResult.Failure;
          }
          for (/*uint*/int I = 0, N = Record.size(); I != N; I += 2) {
            /*uint32_t*/int ID = getGlobalDeclID(F, $ullong2uint(Record.$at(I)));
            DeclUpdateOffsets.$at_T1$C$R(ID).push_back(std.make_pair_Ptr_ulong($AddrOf(F), Record.$at(I + 1)));
            {
              
              // If we've already loaded the decl, perform the updates when we finish
              // loading this block.
              Decl /*P*/ D = GetExistingDecl(ID);
              if ((D != null)) {
                PendingUpdateRecords.push_back(std.make_pair_uint_Ptr(ID, D));
              }
            }
          }
          break;
        }
       case ASTRecordTypes.OBJC_CATEGORIES_MAP:
        {
          if (F.LocalNumObjCCategoriesInMap != 0) {
            Error(new StringRef(/*KEEP_STR*/"duplicate OBJC_CATEGORIES_MAP record in AST file"));
            return ASTReadResult.Failure;
          }
          
          F.LocalNumObjCCategoriesInMap = $ullong2uint(Record.$at(0));
          //(/*const*/ ObjCCategoriesInfo /*P*/ )Blob.data();
          F.ObjCCategoriesMap = ObjCCategoriesInfo.fromBytes(Blob.data(), F.LocalNumObjCCategoriesInMap);
          break;
        }
       case ASTRecordTypes.OBJC_CATEGORIES:
        F.ObjCCategories.swap(Record);
        break;
       case ASTRecordTypes.DIAG_PRAGMA_MAPPINGS:
        if (F.PragmaDiagMappings.empty()) {
          F.PragmaDiagMappings.swap(Record);
        } else {
          F.PragmaDiagMappings.insert_iterator$T$value_T(F.PragmaDiagMappings.end(), 
              Record.begin(), Record.end());
        }
        break;
       case ASTRecordTypes.CUDA_SPECIAL_DECL_REFS:
        // Later tables overwrite earlier ones.
        // FIXME: Modules will have trouble with this.
        CUDASpecialDeclRefs.clear();
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          CUDASpecialDeclRefs.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.HEADER_SEARCH_TABLE:
        {
          F.HeaderFileInfoTableData = $tryClone(Blob.data());
          F.LocalNumHeaderFileInfos = $ullong2uint(Record.$at(1));
          if ((Record.$at(0) != 0)) {
            F.HeaderFileInfoTable
               = OnDiskChainedHashTable.Create(
                       reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, F.HeaderFileInfoTableData).$add((int)Record.$at(0)), 
                reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, F.HeaderFileInfoTableData), 
                new org.clang.serialization.reader.impl.HeaderFileInfoTrait(/*Deref*/this, F, 
                    $AddrOf(PP.getHeaderSearchInfo()), 
                    Blob.data().$add((int)Record.$at(2))));
            
            PP.getHeaderSearchInfo().SetExternalSource(this);
            if (!(PP.getHeaderSearchInfo().getExternalLookup() != null)) {
              PP.getHeaderSearchInfo().SetExternalLookup(this);
            }
          }
          break;
        }
       case ASTRecordTypes.FP_PRAGMA_OPTIONS:
        // Later tables overwrite earlier ones.
        FPPragmaOptions.swap(Record);
        break;
       case ASTRecordTypes.OPENCL_EXTENSIONS:
        // Later tables overwrite earlier ones.
        OpenCLExtensions.swap(Record);
        break;
       case ASTRecordTypes.TENTATIVE_DEFINITIONS:
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          TentativeDefinitions.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.KNOWN_NAMESPACES:
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          KnownNamespaces.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
       case ASTRecordTypes.UNDEFINED_BUT_USED:
        if ($rem_uint(UndefinedButUsed.size(), 2) != 0) {
          Error(new StringRef(/*KEEP_STR*/"Invalid existing UndefinedButUsed"));
          return ASTReadResult.Failure;
        }
        if ($rem_uint(Record.size(), 2) != 0) {
          Error(new StringRef(/*KEEP_STR*/"invalid undefined-but-used record"));
          return ASTReadResult.Failure;
        }
        int N_tmp = Record.size();
        for (uint$ref I = create_uint$ref(0); I.$deref() != N_tmp;) {
          UndefinedButUsed.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I.$set$postInc())))));
          UndefinedButUsed.push_back($uint2ullong(ReadSourceLocation(F, Record, I).getRawEncoding()));
        }
        break;
       case ASTRecordTypes.DELETE_EXPRS_TO_ANALYZE:
        int N_tmp3 = Record.size();
        for (uint$ref I = create_uint$ref(0); I.$deref() != N_tmp3;) {
          DelayedDeleteExprs.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I.$set$postInc())))));
          /*const*/long/*uint64_t*/ Count = Record.$at(I.$set$postInc());
          DelayedDeleteExprs.push_back(Count);
          for (long/*uint64_t*/ C = $int2ulong(0); $less_ulong(C, Count); ++C) {
            DelayedDeleteExprs.push_back($uint2ullong(ReadSourceLocation(F, Record, I).getRawEncoding()));
            boolean IsArrayForm = Record.$at(I.$set$postInc()) == $int2ullong(1);
            DelayedDeleteExprs.push_back((IsArrayForm ? 1 : 0));
          }
        }
        break;
       case ASTRecordTypes.IMPORTED_MODULES:
        {
          if (F.Kind != ModuleKind.MK_ImplicitModule && F.Kind != ModuleKind.MK_ExplicitModule) {
            // If we aren't loading a module (which has its own exports), make
            // all of the imported modules visible.
            // FIXME: Deal with macros-only imports.
            int N_tmp7 = Record.size();
            for (uint$ref I = create_uint$ref(0); I.$deref() != N_tmp7;) {
              /*uint*/int GlobalID = getGlobalSubmoduleID(F, $ullong2uint(Record.$at(I.$set$postInc())));
              SourceLocation Loc = ReadSourceLocation(F, Record, I);
              if ((GlobalID != 0)) {
                ImportedModules.push_back(new ImportedSubmodule(GlobalID, new SourceLocation(Loc)));
              }
            }
          }
          break;
        }
       case ASTRecordTypes.MACRO_OFFSET:
        {
          if (F.LocalNumMacros != 0) {
            Error(new StringRef(/*KEEP_STR*/"duplicate MACRO_OFFSET record in AST file"));
            return ASTReadResult.Failure;
          }
          F.MacroOffsets = $toConst($tryClone(reinterpret_cast(/*const*//*uint32_t P*/uint$ptr .class, Blob.data())));
          F.LocalNumMacros = $ullong2uint(Record.$at(0));
          /*uint*/int LocalBaseMacroID = $ullong2uint(Record.$at(1));
          F.BaseMacroID = getTotalNumMacros();
          if ($greater_uint(F.LocalNumMacros, 0)) {
            // Introduce the global -> local mapping for macros within this module.
            GlobalMacroMap.insert(std.make_pair_uint_Ptr(getTotalNumMacros() + 1, $AddrOf(F)));
            
            // Introduce the local -> global mapping for macros within this module.
            F.MacroRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBaseMacroID, /*Fwd2*//*Fwd*/F.BaseMacroID - LocalBaseMacroID));
            
            MacrosLoaded.resize(MacrosLoaded.size() + F.LocalNumMacros);
          }
          break;
        }
       case ASTRecordTypes.LATE_PARSED_TEMPLATE:
        {
          LateParsedTemplates.append_T(Record.begin(), Record.end());
          break;
        }
       case ASTRecordTypes.OPTIMIZE_PRAGMA_OPTIONS:
        if (Record.size() != 1) {
          Error(new StringRef(/*KEEP_STR*/"invalid pragma optimize record"));
          return ASTReadResult.Failure;
        }
        OptimizeOffPragmaLocation.$assignMove(ReadSourceLocation(F, $ullong2uint(Record.$at(0))));
        break;
       case ASTRecordTypes.MSSTRUCT_PRAGMA_OPTIONS:
        if (Record.size() != 1) {
          Error(new StringRef(/*KEEP_STR*/"invalid pragma ms_struct record"));
          return ASTReadResult.Failure;
        }
        PragmaMSStructState = $ullong2int(Record.$at(0));
        break;
       case ASTRecordTypes.POINTERS_TO_MEMBERS_PRAGMA_OPTIONS:
        if (Record.size() != 2) {
          Error(new StringRef(/*KEEP_STR*/"invalid pragma ms_struct record"));
          return ASTReadResult.Failure;
        }
        PragmaMSPointersToMembersState = $ullong2int(Record.$at(0));
        PointersToMembersPragmaLocation.$assignMove(ReadSourceLocation(F, $ullong2uint(Record.$at(1))));
        break;
       case ASTRecordTypes.UNUSED_LOCAL_TYPEDEF_NAME_CANDIDATES:
        for (/*uint*/int I = 0, N = Record.size(); I != N; ++I)  {
          UnusedLocalTypedefNameCandidates.push_back($uint2ullong(getGlobalDeclID(F, $ullong2uint(Record.$at(I)))));
        }
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadExtensionBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3880,
   FQN="clang::ASTReader::ReadExtensionBlock", NM="_ZN5clang9ASTReader18ReadExtensionBlockERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadExtensionBlockERNS_13serialization10ModuleFileE")
  //</editor-fold>
  private ASTReader.ASTReadResult ReadExtensionBlock(final ModuleFile /*&*/ F) {
    final BitstreamCursor /*&*/ Stream = F.Stream;
    
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    while (true) {
      BitstreamEntry Entry = Stream.advance();
      switch (Entry.Kind) {
       case SubBlock:
        if (Stream.SkipBlock()) {
          return ASTReadResult.Failure;
        }
        
        continue;
       case EndBlock:
        return ASTReadResult.Success;
       case Error:
        return ASTReadResult.HadErrors;
       case Record:
        break;
      }
      
      Record.clear();
      StringRef Blob/*J*/= new StringRef();
      /*uint*/int RecCode = Stream.readRecord(Entry.ID, Record, $AddrOf(Blob));
      switch (RecCode) {
       case ExtensionBlockRecordTypes.EXTENSION_METADATA:
        {
          ModuleFileExtensionMetadata Metadata = null;
          try {
            Metadata/*J*/= new ModuleFileExtensionMetadata();
            if (parseModuleFileExtensionMetadata(Record, new StringRef(Blob), Metadata)) {
              return ASTReadResult.Failure;
            }
            
            // Find a module file extension with this block name.
            StringMapIterator<IntrusiveRefCntPtr<ModuleFileExtension> > Known = ModuleFileExtensions.find(new StringRef(Metadata.BlockName));
            if (Known.$eq(ModuleFileExtensions.end())) {
              break;
            }
            {
              unique_ptr<ModuleFileExtensionReader> Reader = null;
              try {
                
                // Form a reader.
                Reader = Known.$arrow().second.$arrow().createExtensionReader(Metadata, /*Deref*/this, 
                    F, Stream);
                if (Reader.$bool()) {
                  F.ExtensionReaders.push_back_T$RR(std.move(Reader));
                }
              } finally {
                if (Reader != null) { Reader.$destroy(); }
              }
            }
            
            break;
          } finally {
            if (Metadata != null) { Metadata.$destroy(); }
          }
        }
      }
    }
    
    //return ASTReadResult.Success;
  }

  
  //===----------------------------------------------------------------------===//
  // Source Manager Deserialization
  //===----------------------------------------------------------------------===//
  
  /// \brief Read the line table in the source manager block.
  /// \returns true if there was an error.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParseLineTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1071,
   FQN="clang::ASTReader::ParseLineTable", NM="_ZN5clang9ASTReader14ParseLineTableERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14ParseLineTableERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEE")
  //</editor-fold>
  private boolean ParseLineTable(final ModuleFile /*&*/ F, 
                final /*const*/SmallVectorULong /*&*/ Record) {
    std.mapIntInt FileIDs = null;
    std.vector<LineEntry> Entries = null;
    try {
      uint$ref Idx = create_uint$ref(0);
      final LineTableInfo /*&*/ LineTable = SourceMgr.getLineTable();
      
      // Parse the file names
      FileIDs/*J*/= new std.mapIntInt();
      for (/*uint*/int I = 0; (Record.$at$Const(Idx.$deref()) != 0); ++I) {
        // Extract the file name
        std.string Filename = ReadPath(F, Record, Idx);
        FileIDs.$set(I, LineTable.getLineTableFilenameID(new StringRef(Filename)));
      }
      Idx.$set$preInc();
      
      // Parse the line entries
      Entries/*J*/= new std.vector<LineEntry>(new LineEntry());
      while ($less_uint(Idx.$deref(), Record.size())) {
        int FID = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
        assert (FID >= 0) : "Serialized line entries for non-local file.";
        // Remap FileID from 1-based old view.
        FID += F.SLocEntryBaseID - 1;
        
        // Extract the line entries
        /*uint*/int NumEntries = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        assert ((NumEntries != 0)) : "no line entries for file ID";
        Entries.clear();
        Entries.reserve(NumEntries);
        for (/*uint*/int I = 0; I != NumEntries; ++I) {
          /*uint*/int FileOffset = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int LineNo = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          int FilenameID = FileIDs.$at_T$RR($ullong2int(Record.$at$Const(Idx.$set$postInc())));
          SrcMgr.CharacteristicKind FileKind = SrcMgr.CharacteristicKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int IncludeOffset = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Entries.push_back_T$RR(LineEntry.get(FileOffset, LineNo, FilenameID, 
                  FileKind, IncludeOffset));
        }
        LineTable.AddEntry(FileID.get(FID), Entries);
      }
      
      return false;
    } finally {
      if (Entries != null) { Entries.$destroy(); }
      if (FileIDs != null) { FileIDs.$destroy(); }
    }
  }

  
  /// \brief Read a source manager block
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSourceManagerBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1115,
   FQN="clang::ASTReader::ReadSourceManagerBlock", NM="_ZN5clang9ASTReader22ReadSourceManagerBlockERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22ReadSourceManagerBlockERNS_13serialization10ModuleFileE")
  //</editor-fold>
  private boolean ReadSourceManagerBlock(final ModuleFile /*&*/ F) {
    //JAVA: using namespace SrcMgr;
    
    final BitstreamCursor /*&*/ SLocEntryCursor = F.SLocEntryCursor;
    
    // Set the source-location entry cursor to the current position in
    // the stream. This cursor will be used to read the contents of the
    // source manager block initially, and then lazily read
    // source-location entries as needed.
    SLocEntryCursor.$assign(F.Stream);
    
    // The stream itself is going to skip over the source manager block.
    if (F.Stream.SkipBlock()) {
      Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
      return true;
    }
    
    // Enter the source manager block.
    if (SLocEntryCursor.EnterSubBlock(BlockIDs.SOURCE_MANAGER_BLOCK_ID)) {
      Error(new StringRef(/*KEEP_STR*/"malformed source manager block record in AST file"));
      return true;
    }
    
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    while (true) {
      BitstreamEntry E = SLocEntryCursor.advanceSkippingSubblocks();
      switch (E.Kind) {
       case SubBlock: // Handled for us already.
       case Error:
        Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
        return true;
       case EndBlock:
        return false;
       case Record:
        // The interesting case.
        break;
      }
      
      // Read a record.
      Record.clear();
      StringRef Blob/*J*/= new StringRef();
      switch (SLocEntryCursor.readRecord(E.ID, Record, $AddrOf(Blob))) {
       default: // Default behavior: ignore.
        break;
       case SourceManagerRecordTypes.SM_SLOC_FILE_ENTRY:
       case SourceManagerRecordTypes.SM_SLOC_BUFFER_ENTRY:
       case SourceManagerRecordTypes.SM_SLOC_EXPANSION_ENTRY:
        // Once we hit one of the source location entries, we're done.
        return false;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::SLocCursorForID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1162,
   FQN="clang::ASTReader::SLocCursorForID", NM="_ZN5clang9ASTReader15SLocCursorForIDEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15SLocCursorForIDEi")
  //</editor-fold>
  private BitstreamCursor /*&*/ SLocCursorForID(int ID) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /// \brief Find the location where the module F is imported.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getImportLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1363,
   FQN="clang::ASTReader::getImportLocation", NM="_ZN5clang9ASTReader17getImportLocationEPNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17getImportLocationEPNS_13serialization10ModuleFileE")
  //</editor-fold>
  private SourceLocation getImportLocation(ModuleFile /*P*/ F) {
    if (F.ImportLoc.isValid()) {
      return new SourceLocation(F.ImportLoc);
    }
    
    // Otherwise we have a PCH. It's considered to be "imported" at the first
    // location of its includer.
    if (F.ImportedBy.empty() || !(F.ImportedBy.$at(0) != null)) {
      // Main file is the importer.
      assert (SourceMgr.getMainFileID().isValid()) : "missing main file";
      return SourceMgr.getLocForStartOfFile(SourceMgr.getMainFileID());
    }
    return new SourceLocation(F.ImportedBy.$at(0).FirstLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadModuleMapFileBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3217,
   FQN="clang::ASTReader::ReadModuleMapFileBlock", NM="_ZN5clang9ASTReader22ReadModuleMapFileBlockERN4llvm11SmallVectorIyLj64EEERNS_13serialization10ModuleFileEPKS6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22ReadModuleMapFileBlockERN4llvm11SmallVectorIyLj64EEERNS_13serialization10ModuleFileEPKS6_j")
  //</editor-fold>
  private ASTReader.ASTReadResult ReadModuleMapFileBlock(final SmallVectorULong /*&*/ Record, final ModuleFile /*&*/ F, 
                        /*const*/ ModuleFile /*P*/ ImportedBy, 
                        /*uint*/int ClientLoadCapabilities) {
    uint$ref Idx = create_uint$ref(0);
    F.ModuleMapPath.$assignMove(ReadPath(F, Record, Idx));
    if (F.Kind == ModuleKind.MK_ExplicitModule) {
      // For an explicitly-loaded module, we don't care whether the original
      // module map file exists or matches.
      return ASTReadResult.Success;
    }
    
    // Try to resolve ModuleName in the current header search context and
    // verify that it is found in the same module map file as we saved. If the
    // top-level AST file is a main file, skip this check because there is no
    // usable header search context.
    assert (!F.ModuleName.empty()) : "MODULE_NAME should come before MODULE_MAP_FILE";
    if (F.Kind == ModuleKind.MK_ImplicitModule
       && (ModuleMgr.begin().$star()).Kind != ModuleKind.MK_MainFile) {
      // An implicitly-loaded module file should have its module listed in some
      // module map file that we've already loaded.
      Module /*P*/ M = PP.getHeaderSearchInfo().lookupModule(new StringRef(F.ModuleName));
      final ModuleMap /*&*/ Map = PP.getHeaderSearchInfo().getModuleMap();
      /*const*/ FileEntry /*P*/ ModMap = (M != null) ? Map.getModuleMapFileForUniquing(M) : null;
      if (!(ModMap != null)) {
        assert ((ImportedBy != null)) : "top-level import should be verified";
        if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
          {
            /*const*/ FileEntry /*P*/ ASTFE = (M != null) ? M.getASTFile() : null;
            if ((ASTFE != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // This module was defined by an imported (explicit) module.
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_module_file_conflict)), new StringRef(F.ModuleName)), new StringRef(F.FileName)), 
                    ASTFE.getName()));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // This module was built with a different module map.
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_imported_module_not_found)), 
                                new StringRef(F.ModuleName)), new StringRef(F.FileName)), new StringRef(ImportedBy.FileName)), 
                    new StringRef(F.ModuleMapPath)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        return ASTReadResult.OutOfDate;
      }
      assert ($eq_str$C(M.Name, F.ModuleName)) : "found module with different name";
      
      // Check the primary module map file.
      /*const*/ FileEntry /*P*/ StoredModMap = FileMgr.getFile(new StringRef(F.ModuleMapPath));
      if (StoredModMap == null || StoredModMap != ModMap) {
        assert ((ModMap != null)) : "found module is missing module map file";
        assert ((ImportedBy != null)) : "top-level import should be verified";
        if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_imported_module_modmap_changed)), 
                            new StringRef(F.ModuleName)), new StringRef(ImportedBy.FileName)), 
                    ModMap.getName()), new StringRef(F.ModuleMapPath)));
          } finally {
            $c$.$destroy();
          }
        }
        return ASTReadResult.OutOfDate;
      }
      
      SmallPtrSet</*const*/ FileEntry /*P*/> AdditionalStoredMaps/*J*/= new SmallPtrSet</*const*/ FileEntry /*P*/>(FileEntry.DMI$FileEntryPtr, 1);
      for (/*uint*/int I = 0, N = $ullong2uint(Record.$at(Idx.$set$postInc())); $less_uint(I, N); ++I) {
        // FIXME: we should use input files rather than storing names.
        std.string Filename = ReadPath(F, Record, Idx);
        /*const*/ FileEntry /*P*/ F$1 = FileMgr.getFile(new StringRef(Filename), false, false);
        if (F$1 == null) {
          if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
            Error(new StringRef($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"could not find file '", Filename), /*KEEP_STR*/"' referenced by AST file")));
          }
          return ASTReadResult.OutOfDate;
        }
        AdditionalStoredMaps.insert(F$1);
      }
      {
        
        // Check any additional module map files (e.g. module.private.modulemap)
        // that are not in the pcm.
        SmallPtrSet</*const*/ FileEntry /*P*/>/*P*/ AdditionalModuleMaps = Map.getAdditionalModuleMapFiles(M);
        if ((AdditionalModuleMaps != null)) {
          for (/*const*/ FileEntry /*P*/ ModMap$1 : /*$Deref(*/AdditionalModuleMaps/*)*/) {
            // Remove files that match
            // Note: SmallPtrSet::erase is really remove
            if (!AdditionalStoredMaps.erase(ModMap$1)) {
              if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_module_different_modmap)), 
                              new StringRef(F.ModuleName)), /*new*/ 0), ModMap$1.getName()));
                } finally {
                  $c$.$destroy();
                }
              }
              return ASTReadResult.OutOfDate;
            }
          }
        }
      }
      
      // Check any additional module map files that are in the pcm, but not
      // found in header search. Cases that match are already removed.
      for (/*const*/ FileEntry /*P*/ ModMap$1 : AdditionalStoredMaps) {
        if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_module_different_modmap)), 
                        new StringRef(F.ModuleName)), /*not new*/ 1), ModMap$1.getName()));
          } finally {
            $c$.$destroy();
          }
        }
        return ASTReadResult.OutOfDate;
      }
    }
    if (Listener.$bool()) {
      Listener.$arrow().ReadModuleMapFile(new StringRef(F.ModuleMapPath));
    }
    return ASTReadResult.Success;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSubmoduleBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4414,
   FQN="clang::ASTReader::ReadSubmoduleBlock", NM="_ZN5clang9ASTReader18ReadSubmoduleBlockERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadSubmoduleBlockERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  private ASTReader.ASTReadResult ReadSubmoduleBlock(final ModuleFile /*&*/ F, /*uint*/int ClientLoadCapabilities) {
    // Enter the submodule block.
    if (F.Stream.EnterSubBlock(BlockIDs.SUBMODULE_BLOCK_ID)) {
      Error(new StringRef(/*KEEP_STR*/"malformed submodule block record in AST file"));
      return ASTReadResult.Failure;
    }
    
    final ModuleMap /*&*/ ModMap = PP.getHeaderSearchInfo().getModuleMap();
    boolean First = true;
    Module /*P*/ CurrentModule = null;
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    while (true) {
      BitstreamEntry Entry = F.Stream.advanceSkippingSubblocks();
      switch (Entry.Kind) {
       case SubBlock: // Handled for us already.
       case Error:
        Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
        return ASTReadResult.Failure;
       case EndBlock:
        return ASTReadResult.Success;
       case Record:
        // The interesting case.
        break;
      }
      
      // Read a record.
      StringRef Blob/*J*/= new StringRef();
      Record.clear();
      /*uint*/int Kind = F.Stream.readRecord(Entry.ID, Record, $AddrOf(Blob));
      if ((Kind == SubmoduleRecordTypes.SUBMODULE_METADATA) != First) {
        Error(new StringRef(/*KEEP_STR*/"submodule metadata record should be at beginning of block"));
        return ASTReadResult.Failure;
      }
      First = false;
      
      // Submodule information is only valid if we have a current module.
      // FIXME: Should we error on these cases?
      if (!(CurrentModule != null) && Kind != SubmoduleRecordTypes.SUBMODULE_METADATA
         && Kind != SubmoduleRecordTypes.SUBMODULE_DEFINITION) {
        continue;
      }
      switch (Kind) {
       default: // Default behavior: ignore.
        break;
       case SubmoduleRecordTypes.SUBMODULE_DEFINITION:
        {
          if ($less_uint(Record.size(), 8)) {
            Error(new StringRef(/*KEEP_STR*/"malformed module definition"));
            return ASTReadResult.Failure;
          }
          
          StringRef Name = new StringRef(Blob);
          /*uint*/int Idx = 0;
          /*uint32_t*/int GlobalID = getGlobalSubmoduleID(F, $ullong2uint(Record.$at(Idx++)));
          /*uint32_t*/int Parent = getGlobalSubmoduleID(F, $ullong2uint(Record.$at(Idx++)));
          boolean IsFramework = (Record.$at(Idx++) != 0);
          boolean IsExplicit = (Record.$at(Idx++) != 0);
          boolean IsSystem = (Record.$at(Idx++) != 0);
          boolean IsExternC = (Record.$at(Idx++) != 0);
          boolean InferSubmodules = (Record.$at(Idx++) != 0);
          boolean InferExplicitSubmodules = (Record.$at(Idx++) != 0);
          boolean InferExportWildcard = (Record.$at(Idx++) != 0);
          boolean ConfigMacrosExhaustive = (Record.$at(Idx++) != 0);
          
          Module /*P*/ ParentModule = null;
          if ((Parent != 0)) {
            ParentModule = getSubmodule(Parent);
          }
          
          // Retrieve this (sub)module from the module map, creating it if
          // necessary.
          CurrentModule = ModMap.findOrCreateModule(/*NO_COPY*/Name, ParentModule, IsFramework, 
              IsExplicit).first;
          
          // FIXME: set the definition loc for CurrentModule, or call
          // ModMap.setInferredModuleAllowedBy()
          /*uint32_t*/int GlobalIndex = GlobalID - NUM_PREDEF_SUBMODULE_IDS;
          if ($greatereq_uint(GlobalIndex, SubmodulesLoaded.size())
             || (SubmodulesLoaded.$at(GlobalIndex) != null)) {
            Error(new StringRef(/*KEEP_STR*/"too many submodules"));
            return ASTReadResult.Failure;
          }
          if (!(ParentModule != null)) {
            {
              /*const*/ FileEntry /*P*/ CurFile = CurrentModule.getASTFile();
              if ((CurFile != null)) {
                if (CurFile != F.File) {
                  if (!Diags.isDiagnosticInFlight()) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.err_module_file_conflict)), 
                                  CurrentModule.getTopLevelModuleName()), 
                              CurFile.getName()), 
                          F.File.getName()));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                  return ASTReadResult.Failure;
                }
              }
            }
            
            CurrentModule.setASTFile(F.File);
          }
          
          CurrentModule.Signature = $uint2ulong(F.Signature);
          CurrentModule.IsFromModuleFile = true;
          CurrentModule.IsSystem = IsSystem || CurrentModule.IsSystem;
          CurrentModule.IsExternC = IsExternC;
          CurrentModule.InferSubmodules = InferSubmodules;
          CurrentModule.InferExplicitSubmodules = InferExplicitSubmodules;
          CurrentModule.InferExportWildcard = InferExportWildcard;
          CurrentModule.ConfigMacrosExhaustive = ConfigMacrosExhaustive;
          if ((DeserializationListener != null)) {
            DeserializationListener.ModuleRead(GlobalID, CurrentModule);
          }
          
          SubmodulesLoaded.$set(GlobalIndex, CurrentModule);
          
          // Clear out data that will be replaced by what is in the module file.
          CurrentModule.LinkLibraries.clear();
          CurrentModule.ConfigMacros.clear();
          CurrentModule.UnresolvedConflicts.clear();
          CurrentModule.Conflicts.clear();
          
          // The module is available unless it's missing a requirement; relevant
          // requirements will be (re-)added by SUBMODULE_REQUIRES records.
          // Missing headers that were present when the module was built do not
          // make it unavailable -- if we got this far, this must be an explicitly
          // imported module file.
          CurrentModule.Requirements.clear();
          CurrentModule.MissingHeaders.clear();
          CurrentModule.IsMissingRequirement
             = (ParentModule != null) && ParentModule.IsMissingRequirement;
          CurrentModule.IsAvailable = !CurrentModule.IsMissingRequirement;
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_UMBRELLA_HEADER:
        {
          std.string Filename = Blob.$string();
          ResolveImportedPath(F, Filename);
          {
            /*const*/ FileEntry /*P*/ Umbrella = PP.getFileManager().getFile(new StringRef(Filename));
            if ((Umbrella != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if ($c$.clean(!$c$.track(CurrentModule.getUmbrellaHeader()).$bool())) {
                  ModMap.setUmbrellaHeader(CurrentModule, Umbrella, new Twine(Blob));
                } else if ($c$.clean($c$.track(CurrentModule.getUmbrellaHeader()).Entry != Umbrella)) {
                  // This can be a spurious difference caused by changing the VFS to
                  // point to a different copy of the file, and it is too late to
                  // to rebuild safely.
                  // FIXME: If we wrote the virtual paths instead of the 'real' paths,
                  // after input file validation only real problems would remain and we
                  // could just error. For now, assume it's okay.
                  break;
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_HEADER:
       case SubmoduleRecordTypes.SUBMODULE_EXCLUDED_HEADER:
       case SubmoduleRecordTypes.SUBMODULE_PRIVATE_HEADER:
        // We lazily associate headers with their modules via the HeaderInfo table.
        // FIXME: Re-evaluate this section; maybe only store InputFile IDs instead
        // of complete filenames or remove it entirely.
        break;
       case SubmoduleRecordTypes.SUBMODULE_TEXTUAL_HEADER:
       case SubmoduleRecordTypes.SUBMODULE_PRIVATE_TEXTUAL_HEADER:
        // FIXME: Textual headers are not marked in the HeaderInfo table. Load
        // them here.
        break;
       case SubmoduleRecordTypes.SUBMODULE_TOPHEADER:
        {
          CurrentModule.addTopHeaderFilename(new StringRef(Blob));
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_UMBRELLA_DIR:
        {
          std.string Dirname = Blob.$string();
          ResolveImportedPath(F, Dirname);
          {
            /*const*/ DirectoryEntry /*P*/ Umbrella = PP.getFileManager().getDirectory(new StringRef(Dirname));
            if ((Umbrella != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if ($c$.clean(!$c$.track(CurrentModule.getUmbrellaDir()).$bool())) {
                  ModMap.setUmbrellaDir(CurrentModule, Umbrella, new Twine(Blob));
                } else if ($c$.clean($c$.track(CurrentModule.getUmbrellaDir()).Entry != Umbrella)) {
                  if ((ClientLoadCapabilities & LoadFailureCapabilities.ARR_OutOfDate) == 0) {
                    Error(new StringRef(/*KEEP_STR*/"mismatched umbrella directories in submodule"));
                  }
                  return ASTReadResult.OutOfDate;
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_METADATA:
        {
          F.BaseSubmoduleID = getTotalNumSubmodules();
          F.LocalNumSubmodules = $ullong2uint(Record.$at(0));
          /*uint*/int LocalBaseSubmoduleID = $ullong2uint(Record.$at(1));
          if ($greater_uint(F.LocalNumSubmodules, 0)) {
            // Introduce the global -> local mapping for submodules within this 
            // module.
            GlobalSubmoduleMap.insert(std.make_pair_uint_Ptr(getTotalNumSubmodules() + 1, $AddrOf(F)));
            
            // Introduce the local -> global mapping for submodules within this 
            // module.
            F.SubmoduleRemap.insertOrReplace(new std.pairUIntInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/LocalBaseSubmoduleID, /*Fwd2*//*Fwd*/F.BaseSubmoduleID - LocalBaseSubmoduleID));
            
            SubmodulesLoaded.resize(SubmodulesLoaded.size() + F.LocalNumSubmodules);
          }
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_IMPORTS:
        {
          for (/*uint*/int Idx = 0; Idx != Record.size(); ++Idx) {
            UnresolvedModuleRef Unresolved/*J*/= new UnresolvedModuleRef();
            Unresolved.File = $AddrOf(F);
            Unresolved.Mod = CurrentModule;
            Unresolved.ID = $ullong2uint(Record.$at(Idx));
            Unresolved.Kind = UnresolvedModuleRef.Unnamed_enum.Import;
            Unresolved.IsWildcard = false;
            UnresolvedModuleRefs.push_back(Unresolved);
          }
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_EXPORTS:
        {
          for (/*uint*/int Idx = 0; $less_uint(Idx + 1, Record.size()); Idx += 2) {
            UnresolvedModuleRef Unresolved/*J*/= new UnresolvedModuleRef();
            Unresolved.File = $AddrOf(F);
            Unresolved.Mod = CurrentModule;
            Unresolved.ID = $ullong2uint(Record.$at(Idx));
            Unresolved.Kind = UnresolvedModuleRef.Unnamed_enum.Export;
            Unresolved.IsWildcard = $uint2uint_1bit($ullong2uint(Record.$at(Idx + 1)));
            UnresolvedModuleRefs.push_back(Unresolved);
          }
          
          // Once we've loaded the set of exports, there's no reason to keep 
          // the parsed, unresolved exports around.
          CurrentModule.UnresolvedExports.clear();
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_REQUIRES:
        {
          CurrentModule.addRequirement(new StringRef(Blob), (Record.$at(0) != 0), Context.getLangOpts(), 
              Context.getTargetInfo());
          break;
        }
       case SubmoduleRecordTypes.SUBMODULE_LINK_LIBRARY:
        CurrentModule.LinkLibraries.push_back_T$RR(new Module.LinkLibrary(Blob.$string(), (Record.$at(0) != 0)));
        break;
       case SubmoduleRecordTypes.SUBMODULE_CONFIG_MACRO:
        CurrentModule.ConfigMacros.push_back_T$RR(Blob.str());
        break;
       case SubmoduleRecordTypes.SUBMODULE_CONFLICT:
        {
          UnresolvedModuleRef Unresolved/*J*/= new UnresolvedModuleRef();
          Unresolved.File = $AddrOf(F);
          Unresolved.Mod = CurrentModule;
          Unresolved.ID = $ullong2uint(Record.$at(0));
          Unresolved.Kind = UnresolvedModuleRef.Unnamed_enum.Conflict;
          Unresolved.IsWildcard = false;
          Unresolved.String.$assign(Blob);
          UnresolvedModuleRefs.push_back(Unresolved);
          break;
        }
      }
    }
  }

  
  /// \brief Parse the record that corresponds to a LangOptions data
  /// structure.
  ///
  /// This routine parses the language options from the AST file and then gives
  /// them to the AST listener if one is set.
  ///
  /// \returns true if the listener deems the file unacceptable, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParseLanguageOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4687,
   FQN="clang::ASTReader::ParseLanguageOptions", NM="_ZN5clang9ASTReader20ParseLanguageOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20ParseLanguageOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerEb")
  //</editor-fold>
  private static boolean ParseLanguageOptions(final /*const*/SmallVectorULong /*&*/ Record, 
                      boolean Complain, 
                      final ASTReaderListener /*&*/ Listener, 
                      boolean AllowCompatibleDifferences) {
    LangOptions LangOpts/*J*/= new LangOptions();
    uint$ref Idx = create_uint$ref(0);
    
    // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
    LangOpts.C99 = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.C11 = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.MSVCCompat = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.MicrosoftExt = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.AsmBlocks = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Borland = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CPlusPlus = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CPlusPlus11 = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CPlusPlus14 = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CPlusPlus1z = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjC1 = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjC2 = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCDefaultSynthProperties = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.EncodeExtendedBlockSig = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCInferRelatedResultType = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.AppExt = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Trigraphs = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.LineComment = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Bool = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Half = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.WChar = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DeclSpecKeyword = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DollarIdents = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.AsmPreprocessor = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.GNUMode = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.GNUKeywords = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ImplicitInt = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Digraphs = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.HexFloats = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CXXOperatorNames = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.AppleKext = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.PascalStrings = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.WritableStrings = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ConstStrings = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.LaxVectorConversions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.AltiVec = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ZVector = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Exceptions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCExceptions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CXXExceptions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.SjLjExceptions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ExternCNoUnwind = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.TraditionalCPP = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.RTTI = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.RTTIData = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.MSBitfields = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Freestanding = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.NoBuiltin = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.NoMathBuiltin = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.GNUAsm = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Coroutines = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ThreadsafeStatics = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.POSIXThreads = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Blocks = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.EmitAllDecls = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.MathErrno = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.HeinousExtensions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Modules = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CompilingModule = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ModulesDeclUse = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ModulesSearchAll = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ModulesStrictDeclUse = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ModulesErrorRecovery = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ImplicitModules = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ModulesLocalVisibility = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Optimize = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.OptimizeSize = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Static = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.PackStruct = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.MaxTypeAlign = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.AlignDouble = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.PICLevel = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.PIE = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.GNUInline = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.NoInlineDefine = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.Deprecated = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.FastMath = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.FiniteMathOnly = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.UnsafeFPMath = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCGCBitmapPrint = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.AccessControl = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CharIsSigned = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ShortWChar = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setMSPointerToMemberRepresentationMethod(/*static_cast*/LangOptions.PragmaMSPointersToMembersKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setDefaultCallingConv(/*static_cast*/LangOptions.DefaultCallingConvention.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ShortEnums = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.OpenCL = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.OpenCLVersion = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.NativeHalfType = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.NativeHalfArgsAndReturns = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.HalfArgsAndReturns = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CUDA = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.OpenMP = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.OpenMPUseTLS = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.OpenMPIsDevice = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.RenderScript = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CUDAIsDevice = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CUDAAllowVariadicFunctions = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CUDAHostDeviceConstexpr = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CUDADeviceFlushDenormalsToZero = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.CUDADeviceApproxTranscendentals = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.SizedDeallocation = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ConceptsTS = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ElideConstructors = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DumpRecordLayouts = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DumpRecordLayoutsSimple = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DumpVTableLayouts = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.NoConstantCFStrings = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.InlineVisibilityHidden = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ParseUnknownAnytype = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DebuggerSupport = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DebuggerCastResultToId = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DebuggerObjCLiteral = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.SpellChecking = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.SinglePrecisionConstants = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.FastRelaxedMath = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DefaultFPContract = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.NoBitFieldTypeAlign = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.HexagonQdsp6Compat = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCAutoRefCount = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCWeakRuntime = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCWeak = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ObjCSubscriptingLegacyRuntime = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.FakeAddressSpaceMap = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setAddressSpaceMapMangling(/*static_cast*/LangOptions.AddrSpaceMapMangling.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.IncludeDefaultHeader = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.DelayedTemplateParsing = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.BlocksRuntimeOptional = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setGC(/*static_cast*/LangOptions.GCMode.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setValueVisibilityMode(/*static_cast*/Visibility.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setTypeVisibilityMode(/*static_cast*/Visibility.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setStackProtector(/*static_cast*/LangOptions.StackProtectorMode.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.setSignedOverflowBehavior(/*static_cast*/LangOptions.SignedOverflowBehaviorTy.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ArrowDepth = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.InstantiationDepth = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.ConstexprCallDepth = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.ConstexprStepLimit = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.BracketDepth = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.NumLargeByValueCopy = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.MSCompatibilityVersion = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    LangOpts.VtorDispMode = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.ApplePragmaPack = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.RetainCommentsFromSystemHeaders = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    LangOpts.SanitizeAddressFieldPadding = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    
    // AddressSanitizer
    LangOpts.Sanitize.set(SanitizerKind.Address, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // Kernel AddressSanitizer (KASan)
    LangOpts.Sanitize.set(SanitizerKind.KernelAddress, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // MemorySanitizer
    LangOpts.Sanitize.set(SanitizerKind.Memory, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // ThreadSanitizer
    LangOpts.Sanitize.set(SanitizerKind.Thread, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // LeakSanitizer
    LangOpts.Sanitize.set(SanitizerKind.Leak, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // UndefinedBehaviorSanitizer
    LangOpts.Sanitize.set(SanitizerKind.Alignment, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.ArrayBounds, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Bool, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Enum, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.FloatCastOverflow, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.FloatDivideByZero, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Function, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.IntegerDivideByZero, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.NonnullAttribute, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Null, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.ObjectSize, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Return, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.ReturnsNonnullAttribute, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.ShiftBase, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.ShiftExponent, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.SignedIntegerOverflow, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Unreachable, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.VLABound, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.Vptr, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // IntegerSanitizer
    LangOpts.Sanitize.set(SanitizerKind.UnsignedIntegerOverflow, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // DataFlowSanitizer
    LangOpts.Sanitize.set(SanitizerKind.DataFlow, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // Control Flow Integrity
    LangOpts.Sanitize.set(SanitizerKind.CFICastStrict, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.CFIDerivedCast, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.CFIICall, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.CFIUnrelatedCast, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.CFINVCall, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.CFIVCall, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // Safe Stack
    LangOpts.Sanitize.set(SanitizerKind.SafeStack, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.LocalBounds, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    // EfficiencySanitizer
    LangOpts.Sanitize.set(SanitizerKind.EfficiencyCacheFrag, (Record.$at$Const(Idx.$set$postInc()) != 0));
    LangOpts.Sanitize.set(SanitizerKind.EfficiencyWorkingSet, (Record.$at$Const(Idx.$set$postInc()) != 0));
    
    for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N)  {
      LangOpts.ModuleFeatures.push_back_T$RR(ASTReader.ReadString(Record, Idx));
    }
    
    ObjCRuntime.Kind runtimeKind = ObjCRuntime.Kind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    VersionTuple runtimeVersion = ASTReader.ReadVersionTuple(Record, Idx);
    LangOpts.ObjCRuntime.$assignMove(new ObjCRuntime(runtimeKind, runtimeVersion));
    
    LangOpts.CurrentModule.$assignMove(ASTReader.ReadString(Record, Idx));
    
    // Comment options.
    for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
      LangOpts.CommentOpts.BlockCommandNames.push_back_T$RR(ASTReader.ReadString(Record, Idx));
    }
    LangOpts.CommentOpts.ParseAllComments = (Record.$at$Const(Idx.$set$postInc()) != 0);
    
    // OpenMP offloading options.
    for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
      LangOpts.OMPTargetTriples.push_back_T$RR(new Triple(new Twine(ASTReader.ReadString(Record, Idx))));
    }
    
    LangOpts.OMPHostIRFile.$assignMove(ASTReader.ReadString(Record, Idx));
    
    return Listener.ReadLanguageOptions(LangOpts, Complain, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParseTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4729,
   FQN="clang::ASTReader::ParseTargetOptions", NM="_ZN5clang9ASTReader18ParseTargetOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ParseTargetOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerEb")
  //</editor-fold>
  private static boolean ParseTargetOptions(final /*const*/SmallVectorULong /*&*/ Record, boolean Complain, 
                    final ASTReaderListener /*&*/ Listener, 
                    boolean AllowCompatibleDifferences) {
    TargetOptions TargetOpts = null;
    try {
      uint$ref Idx = create_uint$ref(0);
      TargetOpts/*J*/= new TargetOptions();
      TargetOpts.Triple.$assignMove(ASTReader.ReadString(Record, Idx));
      TargetOpts.CPU.$assignMove(ASTReader.ReadString(Record, Idx));
      TargetOpts.ABI.$assignMove(ASTReader.ReadString(Record, Idx));
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        TargetOpts.FeaturesAsWritten.push_back_T$RR(ASTReader.ReadString(Record, Idx));
      }
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        TargetOpts.Features.push_back_T$RR(ASTReader.ReadString(Record, Idx));
      }
      
      return Listener.ReadTargetOptions(TargetOpts, Complain, 
          AllowCompatibleDifferences);
    } finally {
      if (TargetOpts != null) { TargetOpts.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParseDiagnosticOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4748,
   FQN="clang::ASTReader::ParseDiagnosticOptions", NM="_ZN5clang9ASTReader22ParseDiagnosticOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22ParseDiagnosticOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerE")
  //</editor-fold>
  private static boolean ParseDiagnosticOptions(final /*const*/SmallVectorULong /*&*/ Record, boolean Complain, 
                        final ASTReaderListener /*&*/ Listener) {
    IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DiagOpts/*J*/= new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
      uint$ref Idx = create_uint$ref(0);
      DiagOpts.$arrow().IgnoreWarnings = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// -w
      DiagOpts.$arrow().NoRewriteMacros = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// -Wno-rewrite-macros
      DiagOpts.$arrow().Pedantic = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// -pedantic
      DiagOpts.$arrow().PedanticErrors = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// -pedantic-errors
      DiagOpts.$arrow().ShowColumn = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show column number on diagnostics.
      DiagOpts.$arrow().ShowLocation = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show source location information.
      DiagOpts.$arrow().ShowCarets = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show carets in diagnostics.
      DiagOpts.$arrow().ShowFixits = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show fixit information.
      DiagOpts.$arrow().ShowSourceRanges = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show source ranges in numeric form.
      DiagOpts.$arrow().ShowParseableFixits = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show machine parseable fix-its.
      DiagOpts.$arrow().ShowPresumedLoc = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show presumed location for diagnostics.
      DiagOpts.$arrow().ShowOptionNames = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show the option name for mappable
      /// diagnostics.
      DiagOpts.$arrow().ShowNoteIncludeStack = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show include stacks for notes.
      DiagOpts.$arrow().ShowCategories = $uint2uint_2bits($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show categories: 0 -> none, 1 -> Number,
      /// 2 -> Full Name.
      DiagOpts.$arrow().setFormat(/*static_cast*/DiagnosticOptions.TextDiagnosticFormat.valueOf((int)Record.$at$Const(Idx.$set$postInc()))); /// Format for diagnostics: 
      DiagOpts.$arrow().ShowColors = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Show diagnostics with ANSI color sequences.
      DiagOpts.$arrow().setShowOverloads(/*static_cast*/OverloadsShown.valueOf((int)Record.$at$Const(Idx.$set$postInc()))); /// Overload candidates to show.
      DiagOpts.$arrow().VerifyDiagnostics = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Check that diagnostics match the expected
      /// diagnostics, indicated by markers in the
      /// input source file.
      DiagOpts.$arrow().setVerifyIgnoreUnexpected(((/*static_cast*//*DiagnosticLevelMask*//*uint*/int)(Record.$at$Const(Idx.$set$postInc())))); /// Ignore unexpected diagnostics of
      /// the specified levels when using
      /// -verify.
      DiagOpts.$arrow().ElideType = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Elide identical types in template diffing
      DiagOpts.$arrow().ShowTemplateTree = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Print a template tree when diffing
      DiagOpts.$arrow().CLFallbackMode = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc()))); /// Format for clang-cl fallback mode
      DiagOpts.$arrow().ErrorLimit = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); /// Limit # errors emitted.
      /// Limit depth of macro expansion backtrace.
      DiagOpts.$arrow().MacroBacktraceLimit = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      /// Limit depth of instantiation backtrace.
      DiagOpts.$arrow().TemplateBacktraceLimit = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      /// Limit depth of constexpr backtrace.
      DiagOpts.$arrow().ConstexprBacktraceLimit = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      /// Limit number of times to perform spell checking.
      DiagOpts.$arrow().SpellCheckingLimit = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      DiagOpts.$arrow().TabStop = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); /// The distance between tab stops.
      /// Column limit for formatting message diagnostics, or 0 if unused.
      DiagOpts.$arrow().MessageLength = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N)  {
        DiagOpts.$arrow().Warnings.push_back_T$RR(ASTReader.ReadString(Record, Idx));
      }
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N)  {
        DiagOpts.$arrow().Remarks.push_back_T$RR(ASTReader.ReadString(Record, Idx));
      }
      
      return $c$.clean(Listener.ReadDiagnosticOptions($c$.track(new IntrusiveRefCntPtr<DiagnosticOptions>(DiagOpts)), Complain));
    } finally {
      if (DiagOpts != null) { DiagOpts.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParseFileSystemOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4765,
   FQN="clang::ASTReader::ParseFileSystemOptions", NM="_ZN5clang9ASTReader22ParseFileSystemOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22ParseFileSystemOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerE")
  //</editor-fold>
  private static boolean ParseFileSystemOptions(final /*const*/SmallVectorULong /*&*/ Record, boolean Complain, 
                        final ASTReaderListener /*&*/ Listener) {
    FileSystemOptions FSOpts/*J*/= new FileSystemOptions();
    uint$ref Idx = create_uint$ref(0);
    FSOpts.WorkingDir.$assignMove(ASTReader.ReadString(Record, Idx));
    return Listener.ReadFileSystemOptions(FSOpts, Complain);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParseHeaderSearchOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4773,
   FQN="clang::ASTReader::ParseHeaderSearchOptions", NM="_ZN5clang9ASTReader24ParseHeaderSearchOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ParseHeaderSearchOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerE")
  //</editor-fold>
  private static boolean ParseHeaderSearchOptions(final /*const*/SmallVectorULong /*&*/ Record, 
                          boolean Complain, 
                          final ASTReaderListener /*&*/ Listener) {
    HeaderSearchOptions HSOpts = null;
    try {
      HSOpts/*J*/= new HeaderSearchOptions();
      uint$ref Idx = create_uint$ref(0);
      HSOpts.Sysroot.$assignMove(ASTReader.ReadString(Record, Idx));
      
      // Include entries.
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        std.string Path = ASTReader.ReadString(Record, Idx);
        org.clang.lex.frontend.IncludeDirGroup Group = /*static_cast*/IncludeDirGroup.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        boolean IsFramework = (Record.$at$Const(Idx.$set$postInc()) != 0);
        boolean IgnoreSysRoot = (Record.$at$Const(Idx.$set$postInc()) != 0);
        HSOpts.UserEntries.emplace_back(new HeaderSearchOptions.Entry(std.move(new StringRef(Path)), Group, IsFramework, 
            IgnoreSysRoot));
      }
      
      // System header prefixes.
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        std.string Prefix = ASTReader.ReadString(Record, Idx);
        boolean IsSystemHeader = (Record.$at$Const(Idx.$set$postInc()) != 0);
        HSOpts.SystemHeaderPrefixes.emplace_back(new HeaderSearchOptions.SystemHeaderPrefix(std.move(new StringRef(Prefix)), IsSystemHeader));
      }
      
      HSOpts.ResourceDir.$assignMove(ASTReader.ReadString(Record, Idx));
      HSOpts.ModuleCachePath.$assignMove(ASTReader.ReadString(Record, Idx));
      HSOpts.ModuleUserBuildPath.$assignMove(ASTReader.ReadString(Record, Idx));
      HSOpts.DisableModuleHash = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      HSOpts.UseBuiltinIncludes = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      HSOpts.UseStandardSystemIncludes = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      HSOpts.UseStandardCXXIncludes = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      HSOpts.UseLibcxx = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      std.string SpecificModuleCachePath = ASTReader.ReadString(Record, Idx);
      
      return Listener.ReadHeaderSearchOptions(HSOpts, new StringRef(SpecificModuleCachePath), 
          Complain);
    } finally {
      if (HSOpts != null) { HSOpts.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ParsePreprocessorOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4812,
   FQN="clang::ASTReader::ParsePreprocessorOptions", NM="_ZN5clang9ASTReader24ParsePreprocessorOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ParsePreprocessorOptionsERKN4llvm11SmallVectorIyLj64EEEbRNS_17ASTReaderListenerERSs")
  //</editor-fold>
  private static boolean ParsePreprocessorOptions(final /*const*/SmallVectorULong /*&*/ Record, 
                          boolean Complain, 
                          final ASTReaderListener /*&*/ Listener, 
                          final std.string/*&*/ SuggestedPredefines) {
    PreprocessorOptions PPOpts = null;
    try {
      PPOpts/*J*/= new PreprocessorOptions();
      uint$ref Idx = create_uint$ref(0);
      
      // Macro definitions/undefs
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        std.string Macro = ASTReader.ReadString(Record, Idx);
        boolean IsUndef = (Record.$at$Const(Idx.$set$postInc()) != 0);
        PPOpts.Macros.push_back_T$RR(std.make_pair_T_bool($Clone(Macro), IsUndef));
      }
      
      // Includes
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        PPOpts.Includes.push_back_T$RR(ASTReader.ReadString(Record, Idx));
      }
      
      // Macro Includes
      for (/*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); (N != 0); --N) {
        PPOpts.MacroIncludes.push_back_T$RR(ASTReader.ReadString(Record, Idx));
      }
      
      PPOpts.UsePredefines = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      PPOpts.DetailedRecord = $uint2uint_1bit($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      PPOpts.ImplicitPCHInclude.$assignMove(ASTReader.ReadString(Record, Idx));
      PPOpts.ImplicitPTHInclude.$assignMove(ASTReader.ReadString(Record, Idx));
      PPOpts.ObjCXXARCStandardLibrary
         = /*static_cast*/ObjCXXARCStandardLibraryKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
      SuggestedPredefines.clear();
      return Listener.ReadPreprocessorOptions(PPOpts, Complain, 
          SuggestedPredefines);
    } finally {
      if (PPOpts != null) { PPOpts.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::RecordLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1185,
   FQN="clang::ASTReader::RecordLocation", NM="_ZN5clang9ASTReader14RecordLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14RecordLocationE")
  //</editor-fold>
  /*friend*/public/*private*/ static class/*struct*/ RecordLocation {
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::RecordLocation::RecordLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1186,
     FQN="clang::ASTReader::RecordLocation::RecordLocation", NM="_ZN5clang9ASTReader14RecordLocationC1EPNS_13serialization10ModuleFileEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14RecordLocationC1EPNS_13serialization10ModuleFileEy")
    //</editor-fold>
    public RecordLocation(ModuleFile /*P*/ M, long/*uint64_t*/ O) {
      // : F(M), Offset(O) 
      //START JInit
      this.F = M;
      this.Offset = O;
      //END JInit
    }

    public ModuleFile /*P*/ F;
    public long/*uint64_t*/ Offset;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::RecordLocation::RecordLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1185,
     FQN="clang::ASTReader::RecordLocation::RecordLocation", NM="_ZN5clang9ASTReader14RecordLocationC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14RecordLocationC1EOS1_")
    //</editor-fold>
    public /*inline*/ RecordLocation(JD$Move _dparam, final RecordLocation /*&&*/$Prm0) {
      // : F(static_cast<RecordLocation &&>().F), Offset(static_cast<RecordLocation &&>().Offset) 
      //START JInit
      this.F = $Prm0.F;
      this.Offset = $Prm0.Offset;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::RecordLocation::RecordLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1185,
     FQN="clang::ASTReader::RecordLocation::RecordLocation", NM="_ZN5clang9ASTReader14RecordLocationC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader14RecordLocationC1ERKS1_")
    //</editor-fold>
    public /*inline*/ RecordLocation(final /*const*/ RecordLocation /*&*/ $Prm0) {
      // : F(.F), Offset(.Offset) 
      //START JInit
      this.F = $Prm0.F;
      this.Offset = $Prm0.Offset;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "F=" + F // NOI18N
                + ", Offset=" + Offset; // NOI18N
    }
  };
  
  
  /// \brief Read and return the type with the given index..
  ///
  /// The index is the type ID, shifted and minus the number of predefs. This
  /// routine actually reads the record corresponding to the type at the given
  /// location. It is a helper routine for GetType, which deals with reading type
  /// IDs.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::readTypeRecord">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5197,
   FQN="clang::ASTReader::readTypeRecord", NM="_ZN5clang9ASTReader14readTypeRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14readTypeRecordEj")
  //</editor-fold>
  private QualType readTypeRecord(/*uint*/int Index) {
    SavedStreamPosition SavedPosition = null;
    ReadingKindTracker ReadingKind = null;
    ExternalASTSource.Deserializing AType = null;
    try {
      RecordLocation Loc = TypeCursorForIndex(Index);
      final BitstreamCursor /*&*/ DeclsCursor = Loc.F.DeclsCursor;
      
      // Keep track of where we are in the stream, then jump back there
      // after reading this type.
      SavedPosition/*J*/= new SavedStreamPosition(DeclsCursor);
      
      ReadingKind/*J*/= new ReadingKindTracker(ASTReader.ReadingKind.Read_Type, /*Deref*/this);
      
      // Note that we are loading a type record.
      AType/*J*/= new ExternalASTSource.Deserializing(this);
      
      uint$ref Idx = create_uint$ref(0);
      DeclsCursor.JumpToBit(Loc.Offset);
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      /*uint*/int Code = DeclsCursor.ReadCode();
      switch (DeclsCursor.readRecord(Code, Record)) {
       case TypeCode.TYPE_EXT_QUAL:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of extended qualifier type"));
            return new QualType();
          }
          QualType Base = readType($Deref(Loc.F), Record, Idx);
          Qualifiers Quals = Qualifiers.fromOpaqueValue($ullong2uint(Record.$at(Idx.$set$postInc())));
          return Context.getQualifiedType(new QualType(Base), new Qualifiers(Quals));
        }
       case TypeCode.TYPE_COMPLEX:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of complex type"));
            return new QualType();
          }
          QualType ElemType = readType($Deref(Loc.F), Record, Idx);
          return Context.getComplexType(/*NO_COPY*/ElemType);
        }
       case TypeCode.TYPE_POINTER:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of pointer type"));
            return new QualType();
          }
          QualType PointeeType = readType($Deref(Loc.F), Record, Idx);
          return Context.getPointerType(/*NO_COPY*/PointeeType);
        }
       case TypeCode.TYPE_DECAYED:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of decayed type"));
            return new QualType();
          }
          QualType OriginalType = readType($Deref(Loc.F), Record, Idx);
          QualType DT = Context.getAdjustedParameterType(new QualType(OriginalType));
          if (!isa_DecayedType(DT)) {
            Error(new StringRef(/*KEEP_STR*/"Decayed type does not decay"));
          }
          return DT;
        }
       case TypeCode.TYPE_ADJUSTED:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of adjusted type"));
            return new QualType();
          }
          QualType OriginalTy = readType($Deref(Loc.F), Record, Idx);
          QualType AdjustedTy = readType($Deref(Loc.F), Record, Idx);
          return Context.getAdjustedType(new QualType(OriginalTy), new QualType(AdjustedTy));
        }
       case TypeCode.TYPE_BLOCK_POINTER:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of block pointer type"));
            return new QualType();
          }
          QualType PointeeType = readType($Deref(Loc.F), Record, Idx);
          return Context.getBlockPointerType(new QualType(PointeeType));
        }
       case TypeCode.TYPE_LVALUE_REFERENCE:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of lvalue reference type"));
            return new QualType();
          }
          QualType PointeeType = readType($Deref(Loc.F), Record, Idx);
          return Context.getLValueReferenceType(new QualType(PointeeType), (Record.$at(1) != 0));
        }
       case TypeCode.TYPE_RVALUE_REFERENCE:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of rvalue reference type"));
            return new QualType();
          }
          QualType PointeeType = readType($Deref(Loc.F), Record, Idx);
          return Context.getRValueReferenceType(new QualType(PointeeType));
        }
       case TypeCode.TYPE_MEMBER_POINTER:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of member pointer type"));
            return new QualType();
          }
          QualType PointeeType = readType($Deref(Loc.F), Record, Idx);
          QualType ClassType = readType($Deref(Loc.F), Record, Idx);
          if (PointeeType.isNull() || ClassType.isNull()) {
            return new QualType();
          }
          
          return Context.getMemberPointerType(new QualType(PointeeType), ClassType.getTypePtr());
        }
       case TypeCode.TYPE_CONSTANT_ARRAY:
        {
          QualType ElementType = readType($Deref(Loc.F), Record, Idx);
          ArrayType.ArraySizeModifier ASM = ArrayType.ArraySizeModifier.valueOf((int)Record.$at(1));
          /*uint*/int IndexTypeQuals = $ullong2uint(Record.$at(2));
          uint$ref Idx$1 = create_uint$ref(3);
          APInt Size = ReadAPInt(Record, Idx$1);
          return Context.getConstantArrayType(new QualType(ElementType), Size, 
              ASM, IndexTypeQuals);
        }
       case TypeCode.TYPE_INCOMPLETE_ARRAY:
        {
          QualType ElementType = readType($Deref(Loc.F), Record, Idx);
          ArrayType.ArraySizeModifier ASM = ArrayType.ArraySizeModifier.valueOf((int)Record.$at(1));
          /*uint*/int IndexTypeQuals = $ullong2uint(Record.$at(2));
          return Context.getIncompleteArrayType(new QualType(ElementType), ASM, IndexTypeQuals);
        }
       case TypeCode.TYPE_VARIABLE_ARRAY:
        {
          QualType ElementType = readType($Deref(Loc.F), Record, Idx);
          ArrayType.ArraySizeModifier ASM = ArrayType.ArraySizeModifier.valueOf((int)Record.$at(1));
          /*uint*/int IndexTypeQuals = $ullong2uint(Record.$at(2));
          SourceLocation LBLoc = ReadSourceLocation($Deref(Loc.F), $ullong2uint(Record.$at(3)));
          SourceLocation RBLoc = ReadSourceLocation($Deref(Loc.F), $ullong2uint(Record.$at(4)));
          return Context.getVariableArrayType(new QualType(ElementType), ReadExpr($Deref(Loc.F)), 
              ASM, IndexTypeQuals, 
              new SourceRange(/*NO_COPY*/LBLoc, /*NO_COPY*/RBLoc));
        }
       case TypeCode.TYPE_VECTOR:
        {
          if (Record.size() != 3) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of vector type in AST file"));
            return new QualType();
          }
          
          QualType ElementType = readType($Deref(Loc.F), Record, Idx);
          /*uint*/int NumElements = $ullong2uint(Record.$at(1));
          /*uint*/int VecKind = $ullong2uint(Record.$at(2));
          return Context.getVectorType(new QualType(ElementType), NumElements, 
              VectorType.VectorKind.valueOf(VecKind));
        }
       case TypeCode.TYPE_EXT_VECTOR:
        {
          if (Record.size() != 3) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of extended vector type in AST file"));
            return new QualType();
          }
          
          QualType ElementType = readType($Deref(Loc.F), Record, Idx);
          /*uint*/int NumElements = $ullong2uint(Record.$at(1));
          return Context.getExtVectorType(new QualType(ElementType), NumElements);
        }
       case TypeCode.TYPE_FUNCTION_NO_PROTO:
        {
          if (Record.size() != 6) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of no-proto function type"));
            return new QualType();
          }
          QualType ResultType = readType($Deref(Loc.F), Record, Idx);
          FunctionType.ExtInfo Info/*J*/= new FunctionType.ExtInfo((Record.$at(1) != 0), (Record.$at(2) != 0), $ullong2uint(Record.$at(3)), 
              CallingConv.valueOf((int)Record.$at(4)), (Record.$at(5) != 0));
          return Context.getFunctionNoProtoType(new QualType(ResultType), Info);
        }
       case TypeCode.TYPE_FUNCTION_PROTO:
        {
          QualType ResultType = readType($Deref(Loc.F), Record, Idx);
          
          FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
          EPI.ExtInfo.$assignMove(new FunctionType.ExtInfo(/*noreturn*/ (Record.$at(1) != 0), 
                  /*hasregparm*/ (Record.$at(2) != 0), 
                  /*regparm*/ $ullong2uint(Record.$at(3)), 
                  /*static_cast*/CallingConv.valueOf((int)Record.$at(4)), 
                  /*produces*/ (Record.$at(5) != 0)));
          
          uint$ref Idx$1 = create_uint$ref(6);
          
          EPI.Variadic = Record.$at(Idx$1.$set$postInc()) != 0;
          EPI.HasTrailingReturn = Record.$at(Idx$1.$set$postInc()) != 0;
          EPI.TypeQuals = $ullong2uchar(Record.$at(Idx$1.$set$postInc()));
          EPI.RefQualifier = /*static_cast*/RefQualifierKind.valueOf((int)Record.$at(Idx$1.$set$postInc()));
          SmallVector<QualType> ExceptionStorage/*J*/= new SmallVector<QualType>(8, new QualType());
          readExceptionSpec($Deref(Loc.F), ExceptionStorage, EPI.ExceptionSpec, Record, Idx$1);
          
          /*uint*/int NumParams = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          SmallVector<QualType> ParamTypes/*J*/= new SmallVector<QualType>(16, new QualType());
          for (/*uint*/int I = 0; I != NumParams; ++I)  {
            ParamTypes.push_back(readType($Deref(Loc.F), Record, Idx$1));
          }
          
          SmallVector<FunctionProtoType.ExtParameterInfo> ExtParameterInfos/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(4, new FunctionProtoType.ExtParameterInfo());
          if (Idx$1.$deref() != Record.size()) {
            for (/*uint*/int I = 0; I != NumParams; ++I)  {
              ExtParameterInfos.push_back(FunctionProtoType.ExtParameterInfo.getFromOpaqueValue($ullong2uchar(Record.$at(Idx$1.$set$postInc()))));
            }
            EPI.ExtParameterInfos = ExtParameterInfos.data();
          }
          assert (Idx$1.$deref() == Record.size());
          
          return Context.getFunctionType(new QualType(ResultType), new ArrayRef<QualType>(ParamTypes, false), EPI);
        }
       case TypeCode.TYPE_UNRESOLVED_USING:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          return Context.getTypeDeclType(this.<UnresolvedUsingTypenameDecl>ReadDeclAs(UnresolvedUsingTypenameDecl.class, $Deref(Loc.F), Record, Idx$1));
        }
       case TypeCode.TYPE_TYPEDEF:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of typedef type"));
            return new QualType();
          }
          uint$ref Idx$1 = create_uint$ref(0);
          TypedefNameDecl /*P*/ Decl = this.<TypedefNameDecl>ReadDeclAs(TypedefNameDecl.class, $Deref(Loc.F), Record, Idx$1);
          QualType Canonical = readType($Deref(Loc.F), Record, Idx$1);
          if (!Canonical.isNull()) {
            Canonical.$assignMove(Context.getCanonicalType(/*NO_COPY*/Canonical).$QualType());
          }
          return Context.getTypedefType(Decl, new QualType(Canonical));
        }
       case TypeCode.TYPE_TYPEOF_EXPR:
        return Context.getTypeOfExprType(ReadExpr($Deref(Loc.F)));
       case TypeCode.TYPE_TYPEOF:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of typeof(type) in AST file"));
            return new QualType();
          }
          QualType UnderlyingType = readType($Deref(Loc.F), Record, Idx);
          return Context.getTypeOfType(new QualType(UnderlyingType));
        }
       case TypeCode.TYPE_DECLTYPE:
        {
          QualType UnderlyingType = readType($Deref(Loc.F), Record, Idx);
          return Context.getDecltypeType(ReadExpr($Deref(Loc.F)), new QualType(UnderlyingType));
        }
       case TypeCode.TYPE_UNARY_TRANSFORM:
        {
          QualType BaseType = readType($Deref(Loc.F), Record, Idx);
          QualType UnderlyingType = readType($Deref(Loc.F), Record, Idx);
          UnaryTransformType.UTTKind UKind = UnaryTransformType.UTTKind.valueOf((int)Record.$at(2));
          return Context.getUnaryTransformType(new QualType(BaseType), new QualType(UnderlyingType), UKind);
        }
       case TypeCode.TYPE_AUTO:
        {
          QualType Deduced = readType($Deref(Loc.F), Record, Idx);
          AutoTypeKeyword Keyword = AutoTypeKeyword.valueOf((int)Record.$at(Idx.$set$postInc()));
          boolean IsDependent = ((Deduced.isNull() ? Record.$at(Idx.$set$postInc()) : /*false*/0) != 0);
          return Context.getAutoType(new QualType(Deduced), Keyword, IsDependent);
        }
       case TypeCode.TYPE_RECORD:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of record type"));
            return new QualType();
          }
          uint$ref Idx$1 = create_uint$ref(0);
          boolean IsDependent = (Record.$at(Idx$1.$set$postInc()) != 0);
          RecordDecl /*P*/ RD = this.<RecordDecl>ReadDeclAs(RecordDecl.class, $Deref(Loc.F), Record, Idx$1);
          RD = cast_or_null_RecordDecl(RD.getCanonicalDecl());
          QualType T = Context.getRecordType(RD);
          ((/*const_cast*/Type /*P*/ )(T.getTypePtr())).setDependent(IsDependent);
          return T;
        }
       case TypeCode.TYPE_ENUM:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of enum type"));
            return new QualType();
          }
          uint$ref Idx$1 = create_uint$ref(0);
          boolean IsDependent = (Record.$at(Idx$1.$set$postInc()) != 0);
          QualType T = Context.getEnumType(this.<EnumDecl>ReadDeclAs(EnumDecl.class, $Deref(Loc.F), Record, Idx$1));
          ((/*const_cast*/Type /*P*/ )(T.getTypePtr())).setDependent(IsDependent);
          return T;
        }
       case TypeCode.TYPE_ATTRIBUTED:
        {
          if (Record.size() != 3) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of attributed type"));
            return new QualType();
          }
          QualType modifiedType = readType($Deref(Loc.F), Record, Idx);
          QualType equivalentType = readType($Deref(Loc.F), Record, Idx);
          AttributedType.Kind kind = /*static_cast*/AttributedType.Kind.valueOf((int)Record.$at(2));
          return Context.getAttributedType(kind, new QualType(modifiedType), new QualType(equivalentType));
        }
       case TypeCode.TYPE_PAREN:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of paren type"));
            return new QualType();
          }
          QualType InnerType = readType($Deref(Loc.F), Record, Idx);
          return Context.getParenType(new QualType(InnerType));
        }
       case TypeCode.TYPE_PACK_EXPANSION:
        {
          if (Record.size() != 2) {
            Error(new StringRef(/*KEEP_STR*/"incorrect encoding of pack expansion type"));
            return new QualType();
          }
          QualType Pattern = readType($Deref(Loc.F), Record, Idx);
          if (Pattern.isNull()) {
            return new QualType();
          }
          OptionalUInt NumExpansions/*J*/= new OptionalUInt();
          if ((Record.$at(1) != 0)) {
            NumExpansions.$assign_T$RR($ullong2uint(Record.$at(1) - $int2ullong(1)));
          }
          return Context.getPackExpansionType(new QualType(Pattern), new OptionalUInt(NumExpansions));
        }
       case TypeCode.TYPE_ELABORATED:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          ElaboratedTypeKeyword Keyword = ElaboratedTypeKeyword.valueOf((int)Record.$at(Idx$1.$set$postInc()));
          NestedNameSpecifier /*P*/ NNS = ReadNestedNameSpecifier($Deref(Loc.F), Record, Idx$1);
          QualType NamedType = readType($Deref(Loc.F), Record, Idx$1);
          return Context.getElaboratedType(Keyword, NNS, new QualType(NamedType));
        }
       case TypeCode.TYPE_OBJC_INTERFACE:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          ObjCInterfaceDecl /*P*/ ItfD = this.<ObjCInterfaceDecl>ReadDeclAs(ObjCInterfaceDecl.class, $Deref(Loc.F), Record, Idx$1);
          return Context.getObjCInterfaceType(ItfD.getCanonicalDecl());
        }
       case TypeCode.TYPE_OBJC_OBJECT:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          QualType Base = readType($Deref(Loc.F), Record, Idx$1);
          /*uint*/int NumTypeArgs = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          SmallVector<QualType> TypeArgs/*J*/= new SmallVector<QualType>(4, new QualType());
          for (/*uint*/int I = 0; I != NumTypeArgs; ++I)  {
            TypeArgs.push_back(readType($Deref(Loc.F), Record, Idx$1));
          }
          /*uint*/int NumProtos = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          SmallVector<ObjCProtocolDecl /*P*/ > Protos/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(4, (ObjCProtocolDecl /*P*/ )null);
          for (/*uint*/int I = 0; I != NumProtos; ++I)  {
            Protos.push_back(this.<ObjCProtocolDecl>ReadDeclAs(ObjCProtocolDecl.class, $Deref(Loc.F), Record, Idx$1));
          }
          boolean IsKindOf = (Record.$at(Idx$1.$set$postInc()) != 0);
          return Context.getObjCObjectType(new QualType(Base), new ArrayRef<QualType>(TypeArgs, false), new ArrayRef<ObjCProtocolDecl /*P*/ >(Protos, true), IsKindOf);
        }
       case TypeCode.TYPE_OBJC_OBJECT_POINTER:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          QualType Pointee = readType($Deref(Loc.F), Record, Idx$1);
          return Context.getObjCObjectPointerType(new QualType(Pointee));
        }
       case TypeCode.TYPE_SUBST_TEMPLATE_TYPE_PARM:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          QualType Parm = readType($Deref(Loc.F), Record, Idx$1);
          QualType Replacement = readType($Deref(Loc.F), Record, Idx$1);
          return Context.getSubstTemplateTypeParmType(cast_TemplateTypeParmType(Parm), 
              Context.getCanonicalType(/*NO_COPY*/Replacement).$QualType());
        }
       case TypeCode.TYPE_SUBST_TEMPLATE_TYPE_PARM_PACK:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          QualType Parm = readType($Deref(Loc.F), Record, Idx$1);
          TemplateArgument ArgPack = ReadTemplateArgument($Deref(Loc.F), Record, Idx$1);
          return Context.getSubstTemplateTypeParmPackType(cast_TemplateTypeParmType(Parm), 
              ArgPack);
        }
       case TypeCode.TYPE_INJECTED_CLASS_NAME:
        {
          CXXRecordDecl /*P*/ D = this.<CXXRecordDecl>ReadDeclAs(CXXRecordDecl.class, $Deref(Loc.F), Record, Idx);
          QualType TST = readType($Deref(Loc.F), Record, Idx); // probably derivable
          // FIXME: ASTContext::getInjectedClassNameType is not currently suitable
          // for AST reading, too much interdependencies.
          /*const*/ Type /*P*/ T = null;
          for (CXXRecordDecl /*P*/ DI = D; (DI != null); DI = DI.getPreviousDecl()) {
            {
              /*const*/ Type /*P*/ Existing = DI.getTypeForDecl();
              if ((Existing != null)) {
                T = Existing;
                break;
              }
            }
          }
          if (!(T != null)) {
            T = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (Context, TypeAlignment)*/ $new_uint_ASTContext$C_uint(Context, TypeAlignment, (type$ptr<?> New$Mem)->{
                return new InjectedClassNameType(D, new QualType(TST));
             });
            for (CXXRecordDecl /*P*/ DI = D; (DI != null); DI = DI.getPreviousDecl())  {
              DI.setTypeForDecl(T);
            }
          }
          return new QualType(T, 0);
        }
       case TypeCode.TYPE_TEMPLATE_TYPE_PARM:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          /*uint*/int Depth = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          /*uint*/int Index$1 = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          boolean Pack = (Record.$at(Idx$1.$set$postInc()) != 0);
          TemplateTypeParmDecl /*P*/ D = this.<TemplateTypeParmDecl>ReadDeclAs(TemplateTypeParmDecl.class, $Deref(Loc.F), Record, Idx$1);
          return Context.getTemplateTypeParmType(Depth, Index$1, Pack, D);
        }
       case TypeCode.TYPE_DEPENDENT_NAME:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          ElaboratedTypeKeyword Keyword = ElaboratedTypeKeyword.valueOf((int)Record.$at(Idx$1.$set$postInc()));
          NestedNameSpecifier /*P*/ NNS = ReadNestedNameSpecifier($Deref(Loc.F), Record, Idx$1);
          /*const*/ IdentifierInfo /*P*/ Name = GetIdentifierInfo($Deref(Loc.F), Record, Idx$1);
          QualType Canon = readType($Deref(Loc.F), Record, Idx$1);
          if (!Canon.isNull()) {
            Canon.$assignMove(Context.getCanonicalType(/*NO_COPY*/Canon).$QualType());
          }
          return Context.getDependentNameType(Keyword, NNS, Name, new QualType(Canon));
        }
       case TypeCode.TYPE_DEPENDENT_TEMPLATE_SPECIALIZATION:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          ElaboratedTypeKeyword Keyword = ElaboratedTypeKeyword.valueOf((int)Record.$at(Idx$1.$set$postInc()));
          NestedNameSpecifier /*P*/ NNS = ReadNestedNameSpecifier($Deref(Loc.F), Record, Idx$1);
          /*const*/ IdentifierInfo /*P*/ Name = GetIdentifierInfo($Deref(Loc.F), Record, Idx$1);
          /*uint*/int NumArgs = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          SmallVector<TemplateArgument> Args/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
          Args.reserve(NumArgs);
          while (((NumArgs--) != 0)) {
            Args.push_back(ReadTemplateArgument($Deref(Loc.F), Record, Idx$1));
          }
          return Context.getDependentTemplateSpecializationType(Keyword, NNS, Name, 
              new ArrayRef<TemplateArgument>(Args, false));
        }
       case TypeCode.TYPE_DEPENDENT_SIZED_ARRAY:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          
          // ArrayType
          QualType ElementType = readType($Deref(Loc.F), Record, Idx$1);
          ArrayType.ArraySizeModifier ASM = ArrayType.ArraySizeModifier.valueOf((int)Record.$at(Idx$1.$set$postInc()));
          /*uint*/int IndexTypeQuals = $ullong2uint(Record.$at(Idx$1.$set$postInc()));
          
          // DependentSizedArrayType
          Expr /*P*/ NumElts = ReadExpr($Deref(Loc.F));
          SourceRange Brackets = ReadSourceRange($Deref(Loc.F), Record, Idx$1);
          
          return Context.getDependentSizedArrayType(new QualType(ElementType), NumElts, ASM, 
              IndexTypeQuals, new SourceRange(Brackets));
        }
       case TypeCode.TYPE_TEMPLATE_SPECIALIZATION:
        {
          uint$ref Idx$1 = create_uint$ref(0);
          boolean IsDependent = (Record.$at(Idx$1.$set$postInc()) != 0);
          TemplateName Name = ReadTemplateName($Deref(Loc.F), Record, Idx$1);
          SmallVector<TemplateArgument> Args/*J*/= new SmallVector<TemplateArgument>(8, new TemplateArgument());
          ReadTemplateArgumentList(Args, $Deref(Loc.F), Record, Idx$1);
          QualType Underlying = readType($Deref(Loc.F), Record, Idx$1);
          QualType T/*J*/= new QualType();
          if (Underlying.isNull()) {
            T.$assignMove(Context.getCanonicalTemplateSpecializationType(new TemplateName(Name), new ArrayRef<TemplateArgument>(Args, false)));
          } else {
            T.$assignMove(Context.getTemplateSpecializationType(new TemplateName(Name), new ArrayRef<TemplateArgument>(Args, false), new QualType(Underlying)));
          }
          ((/*const_cast*/Type /*P*/ )(T.getTypePtr())).setDependent(IsDependent);
          return T;
        }
       case TypeCode.TYPE_ATOMIC:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of atomic type"));
            return new QualType();
          }
          QualType ValueType = readType($Deref(Loc.F), Record, Idx);
          return Context.getAtomicType(new QualType(ValueType));
        }
       case TypeCode.TYPE_PIPE:
        {
          if (Record.size() != 1) {
            Error(new StringRef(/*KEEP_STR*/"Incorrect encoding of pipe type"));
            return new QualType();
          }
          
          // Reading the pipe element type.
          QualType ElementType = readType($Deref(Loc.F), Record, Idx);
          return Context.getPipeType(new QualType(ElementType));
        }
      }
      throw new llvm_unreachable("Invalid TypeCode!");
    } finally {
      if (AType != null) { AType.$destroy(); }
      if (ReadingKind != null) { ReadingKind.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::readExceptionSpec">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5682,
   FQN="clang::ASTReader::readExceptionSpec", NM="_ZN5clang9ASTReader17readExceptionSpecERNS_13serialization10ModuleFileERN4llvm15SmallVectorImplINS_8QualTypeEEERNS_17FunctionProtoType17ExceptionSpecInfoERKNS4_11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17readExceptionSpecERNS_13serialization10ModuleFileERN4llvm15SmallVectorImplINS_8QualTypeEEERNS_17FunctionProtoType17ExceptionSpecInfoERKNS4_11SmallVectorIyLj64EEERj")
  //</editor-fold>
  /*friend*/public void readExceptionSpec(final ModuleFile /*&*/ $ModuleFile, 
                   final SmallVectorImpl<QualType> /*&*/ Exceptions, 
                   final FunctionProtoType.ExceptionSpecInfo /*&*/ ESI, 
                   final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    ExceptionSpecificationType EST = /*static_cast*/ExceptionSpecificationType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    ESI.Type = EST;
    if (EST == ExceptionSpecificationType.EST_Dynamic) {
      for (/*uint*/int I = 0, N = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); I != N; ++I)  {
        Exceptions.push_back(readType($ModuleFile, Record, Idx));
      }
      ESI.Exceptions.$assignMove(new ArrayRef<QualType>(Exceptions, false));
    } else if (EST == ExceptionSpecificationType.EST_ComputedNoexcept) {
      ESI.NoexceptExpr = ReadExpr($ModuleFile);
    } else if (EST == ExceptionSpecificationType.EST_Uninstantiated) {
      ESI.SourceDecl = this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, $ModuleFile, Record, Idx);
      ESI.SourceTemplate = this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, $ModuleFile, Record, Idx);
    } else if (EST == ExceptionSpecificationType.EST_Unevaluated) {
      ESI.SourceDecl = this.<FunctionDecl>ReadDeclAs(FunctionDecl.class, $ModuleFile, Record, Idx);
    }
  }

  
  /// \brief Get the correct cursor and offset for loading a type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::TypeCursorForIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5184,
   FQN="clang::ASTReader::TypeCursorForIndex", NM="_ZN5clang9ASTReader18TypeCursorForIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18TypeCursorForIndexEj")
  //</editor-fold>
  private ASTReader.RecordLocation TypeCursorForIndex(/*uint*/int Index) {
    type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalTypeMap.find(Index));
    assert ($noteq_ptr(I, GlobalTypeMap.end())) : "Corrupted global type map";
    ModuleFile /*P*/ M = I./*->*/$star().second;
    return new RecordLocation(M, $uint2ulong(M.TypeOffsets.$at(Index - M.BaseTypeIndex)));
  }

  
  //===----------------------------------------------------------------------===//
  // ASTReader Implementation
  //===----------------------------------------------------------------------===//
  
  /// \brief Note that we have loaded the declaration with the given
  /// Index.
  ///
  /// This routine notes that this declaration has already been loaded,
  /// so that future GetDecl calls will return this declaration rather
  /// than trying to load a new declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::LoadedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2485,
   FQN="clang::ASTReader::LoadedDecl", NM="_ZN5clang9ASTReader10LoadedDeclEjPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader10LoadedDeclEjPNS_4DeclE")
  //</editor-fold>
  private /*inline*/ void LoadedDecl(/*uint*/int Index, Decl /*P*/ D) {
    assert (!(DeclsLoaded.$at(Index) != null)) : "Decl loaded twice?";
    DeclsLoaded.$set(Index, D);
  }


  
  /// \brief Read the declaration at the given offset from the AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDeclRecord">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3203,
   FQN="clang::ASTReader::ReadDeclRecord", NM="_ZN5clang9ASTReader14ReadDeclRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader14ReadDeclRecordEj")
  //</editor-fold>
  private Decl /*P*/ ReadDeclRecord(/*uint32_t*/int ID) {
    SavedStreamPosition SavedPosition = null;
    ReadingKindTracker ReadingKind = null;
    ExternalASTSource.Deserializing ADecl = null;
    try {
      /*uint*/int Index = ID - NUM_PREDEF_DECL_IDS;
      SourceLocation DeclLoc/*J*/= new SourceLocation();
      RecordLocation Loc = DeclCursorForID(ID, DeclLoc);
      final BitstreamCursor /*&*/ DeclsCursor = Loc.F.DeclsCursor;
      // Keep track of where we are in the stream, then jump back there
      // after reading this declaration.
      SavedPosition/*J*/= new SavedStreamPosition(DeclsCursor);
      
      ReadingKind/*J*/= new ReadingKindTracker(ASTReader.ReadingKind.Read_Decl, /*Deref*/this);
      
      // Note that we are loading a declaration record.
      ADecl/*J*/= new ExternalASTSource.Deserializing(this);
      
      DeclsCursor.JumpToBit(Loc.Offset);
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      /*uint*/int Code = DeclsCursor.ReadCode();
      /*uint*/uint$ref Idx = create_uint$ref(0);
      ASTDeclReader Reader/*J*/= new ASTDeclReader(/*Deref*/this, new ASTReader.RecordLocation(Loc), ID, new SourceLocation(DeclLoc), Record, Idx);
      
      Decl /*P*/ D = null;
      switch (DeclsCursor.readRecord(Code, Record)) {
       case DeclCode.DECL_CONTEXT_LEXICAL:
       case DeclCode.DECL_CONTEXT_VISIBLE:
        throw new llvm_unreachable("Record cannot be de-serialized with ReadDeclRecord");
       case DeclCode.DECL_TYPEDEF:
        D = TypedefDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_TYPEALIAS:
        D = TypeAliasDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_ENUM:
        D = EnumDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_RECORD:
        D = RecordDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_ENUM_CONSTANT:
        D = EnumConstantDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_FUNCTION:
        D = FunctionDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_LINKAGE_SPEC:
        D = LinkageSpecDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_LABEL:
        D = LabelDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_NAMESPACE:
        D = NamespaceDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_NAMESPACE_ALIAS:
        D = NamespaceAliasDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_USING:
        D = UsingDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_USING_SHADOW:
        D = UsingShadowDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CONSTRUCTOR_USING_SHADOW:
        D = ConstructorUsingShadowDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_USING_DIRECTIVE:
        D = UsingDirectiveDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_UNRESOLVED_USING_VALUE:
        D = UnresolvedUsingValueDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_UNRESOLVED_USING_TYPENAME:
        D = UnresolvedUsingTypenameDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CXX_RECORD:
        D = CXXRecordDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CXX_METHOD:
        D = CXXMethodDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CXX_CONSTRUCTOR:
        D = CXXConstructorDecl.CreateDeserialized(Context, ID, false);
        break;
       case DeclCode.DECL_CXX_INHERITED_CONSTRUCTOR:
        D = CXXConstructorDecl.CreateDeserialized(Context, ID, true);
        break;
       case DeclCode.DECL_CXX_DESTRUCTOR:
        D = CXXDestructorDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CXX_CONVERSION:
        D = CXXConversionDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_ACCESS_SPEC:
        D = AccessSpecDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_FRIEND:
        D = FriendDecl.CreateDeserialized(Context, ID, $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_FRIEND_TEMPLATE:
        D = FriendTemplateDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CLASS_TEMPLATE:
        D = ClassTemplateDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CLASS_TEMPLATE_SPECIALIZATION:
        D = ClassTemplateSpecializationDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CLASS_TEMPLATE_PARTIAL_SPECIALIZATION:
        D = ClassTemplatePartialSpecializationDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_VAR_TEMPLATE:
        D = VarTemplateDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_VAR_TEMPLATE_SPECIALIZATION:
        D = VarTemplateSpecializationDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_VAR_TEMPLATE_PARTIAL_SPECIALIZATION:
        D = VarTemplatePartialSpecializationDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CLASS_SCOPE_FUNCTION_SPECIALIZATION:
        D = ClassScopeFunctionSpecializationDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_FUNCTION_TEMPLATE:
        D = FunctionTemplateDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_TEMPLATE_TYPE_PARM:
        D = TemplateTypeParmDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_NON_TYPE_TEMPLATE_PARM:
        D = NonTypeTemplateParmDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_EXPANDED_NON_TYPE_TEMPLATE_PARM_PACK:
        D = NonTypeTemplateParmDecl.CreateDeserialized(Context, ID, $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_TEMPLATE_TEMPLATE_PARM:
        D = TemplateTemplateParmDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_EXPANDED_TEMPLATE_TEMPLATE_PARM_PACK:
        D = TemplateTemplateParmDecl.CreateDeserialized(Context, ID, 
            $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_TYPE_ALIAS_TEMPLATE:
        D = TypeAliasTemplateDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_STATIC_ASSERT:
        D = StaticAssertDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_METHOD:
        D = ObjCMethodDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_INTERFACE:
        D = ObjCInterfaceDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_IVAR:
        D = ObjCIvarDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_PROTOCOL:
        D = ObjCProtocolDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_AT_DEFS_FIELD:
        D = ObjCAtDefsFieldDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_CATEGORY:
        D = ObjCCategoryDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_CATEGORY_IMPL:
        D = ObjCCategoryImplDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_IMPLEMENTATION:
        D = ObjCImplementationDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_COMPATIBLE_ALIAS:
        D = ObjCCompatibleAliasDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_PROPERTY:
        D = ObjCPropertyDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_PROPERTY_IMPL:
        D = ObjCPropertyImplDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_FIELD:
        D = FieldDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_INDIRECTFIELD:
        D = IndirectFieldDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_VAR:
        D = VarDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_IMPLICIT_PARAM:
        D = ImplicitParamDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_PARM_VAR:
        D = ParmVarDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_FILE_SCOPE_ASM:
        D = FileScopeAsmDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_BLOCK:
        D = BlockDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_MS_PROPERTY:
        D = MSPropertyDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_CAPTURED:
        D = CapturedDecl.CreateDeserialized(Context, ID, $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_CXX_BASE_SPECIFIERS:
        Error(new StringRef(/*KEEP_STR*/"attempt to read a C++ base-specifier record as a declaration"));
        return null;
       case DeclCode.DECL_CXX_CTOR_INITIALIZERS:
        Error(new StringRef(/*KEEP_STR*/"attempt to read a C++ ctor initializer record as a declaration"));
        return null;
       case DeclCode.DECL_IMPORT:
        // Note: last entry of the ImportDecl record is the number of stored source 
        // locations.
        D = ImportDecl.CreateDeserialized(Context, ID, $ullong2uint(Record.back()));
        break;
       case DeclCode.DECL_OMP_THREADPRIVATE:
        D = OMPThreadPrivateDecl.CreateDeserialized(Context, ID, $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_OMP_DECLARE_REDUCTION:
        D = OMPDeclareReductionDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OMP_CAPTUREDEXPR:
        D = OMPCapturedExprDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_PRAGMA_COMMENT:
        D = PragmaCommentDecl.CreateDeserialized(Context, ID, $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_PRAGMA_DETECT_MISMATCH:
        D = PragmaDetectMismatchDecl.CreateDeserialized(Context, ID, 
            $ullong2uint(Record.$at(Idx.$set$postInc())));
        break;
       case DeclCode.DECL_EMPTY:
        D = EmptyDecl.CreateDeserialized(Context, ID);
        break;
       case DeclCode.DECL_OBJC_TYPE_PARAM:
        D = ObjCTypeParamDecl.CreateDeserialized(Context, ID);
        break;
      }
      assert ((D != null)) : "Unknown declaration reading AST file";
      LoadedDecl(Index, D);
      // Set the DeclContext before doing any deserialization, to make sure internal
      // calls to Decl::getASTContext() by Decl's methods will find the
      // TranslationUnitDecl without crashing.
      D.setDeclContext(Context.getTranslationUnitDecl());
      Reader.Visit(D);
      {
        
        // If this declaration is also a declaration context, get the
        // offsets for its tables of lexical and visible declarations.
        DeclContext /*P*/ DC = dyn_cast_DeclContext(D);
        if ((DC != null)) {
          std.pairULongULong Offsets = Reader.VisitDeclContext(DC);
          if ((Offsets.first != 0)
             && ReadLexicalDeclContextStorage($Deref(Loc.F), DeclsCursor, Offsets.first, DC)) {
            return null;
          }
          if ((Offsets.second != 0)
             && ReadVisibleDeclContextStorage($Deref(Loc.F), DeclsCursor, Offsets.second, ID)) {
            return null;
          }
        }
      }
      assert (Idx.$deref() == Record.size());
      
      // Load any relevant update records.
      PendingUpdateRecords.push_back(std.make_pair_uint_Ptr(ID, D));
      {
        
        // Load the categories after recursive loading is finished.
        ObjCInterfaceDecl /*P*/ Class = dyn_cast_ObjCInterfaceDecl(D);
        if ((Class != null)) {
          if (Class.isThisDeclarationADefinition()) {
            loadObjCCategories(ID, Class);
          }
        }
      }
      
      // If we have deserialized a declaration that has a definition the
      // AST consumer might need to know about, queue it.
      // We don't pass it to the consumer immediately because we may be in recursive
      // loading, and some declarations may still be initializing.
      if (isConsumerInterestedIn(D, Reader.hasPendingBody())) {
        InterestingDecls.push_back_T$C$R(D);
      }
      
      return D;
    } finally {
      if (ADecl != null) { ADecl.$destroy(); }
      if (ReadingKind != null) { ReadingKind.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::markIncompleteDeclChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3191,
   FQN="clang::ASTReader::markIncompleteDeclChain", NM="_ZN5clang9ASTReader23markIncompleteDeclChainEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader23markIncompleteDeclChainEPNS_4DeclE")
  //</editor-fold>
  private void markIncompleteDeclChain(Decl /*P*/ D) {
    switch (D.getKind()) {
     case AccessSpec:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_AccessSpecDecl(D));
      break;
     case Block:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_BlockDecl(D));
      break;
     case Captured:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_CapturedDecl(D));
      break;
     case ClassScopeFunctionSpecialization:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ClassScopeFunctionSpecializationDecl(D));
      break;
     case Empty:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_EmptyDecl(D));
      break;
     case ExternCContext:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ExternCContextDecl(D));
      break;
     case FileScopeAsm:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_FileScopeAsmDecl(D));
      break;
     case Friend:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_FriendDecl(D));
      break;
     case FriendTemplate:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_FriendTemplateDecl(D));
      break;
     case Import:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ImportDecl(D));
      break;
     case LinkageSpec:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_LinkageSpecDecl(D));
      break;
     case Label:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_LabelDecl(D));
      break;
     case Namespace:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_NamespaceDecl(D));
      break;
     case NamespaceAlias:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_NamespaceAliasDecl(D));
      break;
     case ObjCCompatibleAlias:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCCompatibleAliasDecl(D));
      break;
     case ObjCCategory:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCCategoryDecl(D));
      break;
     case ObjCCategoryImpl:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCCategoryImplDecl(D));
      break;
     case ObjCImplementation:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCImplementationDecl(D));
      break;
     case ObjCInterface:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ObjCInterfaceDecl(D));
      break;
     case ObjCProtocol:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ObjCProtocolDecl(D));
      break;
     case ObjCMethod:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCMethodDecl(D));
      break;
     case ObjCProperty:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCPropertyDecl(D));
      break;
     case BuiltinTemplate:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_BuiltinTemplateDecl(D));
      break;
     case ClassTemplate:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ClassTemplateDecl(D));
      break;
     case FunctionTemplate:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_FunctionTemplateDecl(D));
      break;
     case TypeAliasTemplate:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_TypeAliasTemplateDecl(D));
      break;
     case VarTemplate:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_VarTemplateDecl(D));
      break;
     case TemplateTemplateParm:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_TemplateTemplateParmDecl(D));
      break;
     case Enum:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_EnumDecl(D));
      break;
     case Record:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_RecordDecl(D));
      break;
     case CXXRecord:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_CXXRecordDecl(D));
      break;
     case ClassTemplateSpecialization:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ClassTemplateSpecializationDecl(D));
      break;
     case ClassTemplatePartialSpecialization:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ClassTemplatePartialSpecializationDecl(D));
      break;
     case TemplateTypeParm:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_TemplateTypeParmDecl(D));
      break;
     case ObjCTypeParam:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ObjCTypeParamDecl(D));
      break;
     case TypeAlias:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_TypeAliasDecl(D));
      break;
     case Typedef:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_TypedefDecl(D));
      break;
     case UnresolvedUsingTypename:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_UnresolvedUsingTypenameDecl(D));
      break;
     case Using:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_UsingDecl(D));
      break;
     case UsingDirective:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_UsingDirectiveDecl(D));
      break;
     case UsingShadow:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_UsingShadowDecl(D));
      break;
     case ConstructorUsingShadow:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ConstructorUsingShadowDecl(D));
      break;
     case Field:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_FieldDecl(D));
      break;
     case ObjCAtDefsField:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCAtDefsFieldDecl(D));
      break;
     case ObjCIvar:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCIvarDecl(D));
      break;
     case Function:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_FunctionDecl(D));
      break;
     case CXXMethod:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_CXXMethodDecl(D));
      break;
     case CXXConstructor:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_CXXConstructorDecl(D));
      break;
     case CXXConversion:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_CXXConversionDecl(D));
      break;
     case CXXDestructor:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_CXXDestructorDecl(D));
      break;
     case MSProperty:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_MSPropertyDecl(D));
      break;
     case NonTypeTemplateParm:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_NonTypeTemplateParmDecl(D));
      break;
     case Var:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_VarDecl(D));
      break;
     case ImplicitParam:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ImplicitParamDecl(D));
      break;
     case OMPCapturedExpr:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_OMPCapturedExprDecl(D));
      break;
     case ParmVar:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_ParmVarDecl(D));
      break;
     case VarTemplateSpecialization:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_VarTemplateSpecializationDecl(D));
      break;
     case VarTemplatePartialSpecialization:
      ASTDeclReader.markIncompleteDeclChainImpl$T(cast_VarTemplatePartialSpecializationDecl(D));
      break;
     case EnumConstant:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_EnumConstantDecl(D));
      break;
     case IndirectField:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_IndirectFieldDecl(D));
      break;
     case OMPDeclareReduction:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_OMPDeclareReductionDecl(D));
      break;
     case UnresolvedUsingValue:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_UnresolvedUsingValueDecl(D));
      break;
     case OMPThreadPrivate:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_OMPThreadPrivateDecl(D));
      break;
     case ObjCPropertyImpl:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_ObjCPropertyImplDecl(D));
      break;
     case PragmaComment:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_PragmaCommentDecl(D));
      break;
     case PragmaDetectMismatch:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_PragmaDetectMismatchDecl(D));
      break;
     case StaticAssert:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_StaticAssertDecl(D));
      break;
     case TranslationUnit:
      ASTDeclReader.markIncompleteDeclChainImpl(cast_TranslationUnitDecl(D));
      break;
    }
  }


  
  /// \brief Returns the most recent declaration of a declaration (which must be
  /// of a redeclarable kind) that is either local or has already been loaded
  /// merged into its redecl chain.
  
  /// \brief Returns the most recent declaration of a declaration (which must be
  /// of a redeclarable kind) that is either local or has already been loaded
  /// merged into its redecl chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getMostRecentExistingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3031,
   FQN="clang::ASTReader::getMostRecentExistingDecl", NM="_ZN5clang9ASTReader25getMostRecentExistingDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader25getMostRecentExistingDeclEPNS_4DeclE")
  //</editor-fold>
  private Decl /*P*/ getMostRecentExistingDecl(Decl /*P*/ D) {
    return ASTDeclReader.getMostRecentDecl(D.getCanonicalDecl());
  }


  
  /// \brief Get the correct cursor and offset for loading a declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::DeclCursorForID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2520,
   FQN="clang::ASTReader::DeclCursorForID", NM="_ZN5clang9ASTReader15DeclCursorForIDEjRNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader15DeclCursorForIDEjRNS_14SourceLocationE")
  //</editor-fold>
  private ASTReader.RecordLocation DeclCursorForID(/*uint32_t*/int ID, final SourceLocation /*&*/ Loc) {
    type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalDeclMap.find(ID));
    assert ($noteq_ptr(I, GlobalDeclMap.end())) : "Corrupted global declaration map";
    ModuleFile /*P*/ M = I./*->*/$star().second;
    final /*const*/ DeclOffset /*&*/ DOffs = M.DeclOffsets.$at(ID - M.BaseDeclID - NUM_PREDEF_DECL_IDS);
    Loc.$assignMove(TranslateSourceLocation($Deref(M), DOffs.getLocation()));
    return new RecordLocation(M, $uint2ulong(DOffs.BitOffset));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::loadDeclUpdateRecords">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3483,
   FQN="clang::ASTReader::loadDeclUpdateRecords", NM="_ZN5clang9ASTReader21loadDeclUpdateRecordsEjPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader21loadDeclUpdateRecordsEjPNS_4DeclE")
  //</editor-fold>
  private void loadDeclUpdateRecords(/*uint32_t*/int ID, Decl /*P*/ D) {
    ProcessingUpdatesRAIIObj ProcessingUpdates = null;
    try {
      // The declaration may have been modified by files later in the chain.
      // If this is the case, read the record containing the updates from each file
      // and pass it to ASTDeclReader to make the modifications.
      ProcessingUpdates/*J*/= new ProcessingUpdatesRAIIObj(/*Deref*/this);
      DenseMapIteratorUIntType<SmallVector<pairPtrULong<ModuleFile>>> UpdI = DeclUpdateOffsets.find(ID);
      if (UpdI.$noteq(/*NO_ITER_COPY*/DeclUpdateOffsets.end())) {
        SmallVector<std.pairPtrULong<ModuleFile /*P*/ >> UpdateOffsets = new SmallVector<std.pairPtrULong<ModuleFile /*P*/ >>(
                JD$Move.INSTANCE, std.move(UpdI.$arrow().second));
        DeclUpdateOffsets.erase($Clone(UpdI));
      
        boolean WasInteresting = isConsumerInterestedIn(D, false);
        for (final std.pairPtrULong<ModuleFile /*P*/ > /*&*/ FileAndOffset : UpdateOffsets) {
          SavedStreamPosition SavedPosition = null;
          try {
            ModuleFile /*P*/ F = FileAndOffset.first;
            long/*uint64_t*/ Offset = FileAndOffset.second;
            final BitstreamCursor /*&*/ Cursor = F.DeclsCursor;
            SavedPosition/*J*/= new SavedStreamPosition(Cursor);
            Cursor.JumpToBit(Offset);
            SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
            /*uint*/int Code = Cursor.ReadCode();
            /*uint*/int RecCode = Cursor.readRecord(Code, Record);
            ///*J:(void)*/RecCode;
            assert (RecCode == DECL_UPDATES) : "Expected DECL_UPDATES record!";
            
            /*uint*/uint$ref Idx = create_uint$ref(0);
            ASTDeclReader Reader/*J*/= new ASTDeclReader(/*Deref*/this, new RecordLocation(F, Offset), ID, 
                new SourceLocation(), Record, Idx);
            Reader.UpdateDecl(D, $Deref(F), Record);
            
            // We might have made this declaration interesting. If so, remember that
            // we need to hand it off to the consumer.
            if (!WasInteresting
               && isConsumerInterestedIn(D, Reader.hasPendingBody())) {
              InterestingDecls.push_back_T$C$R(D);
              WasInteresting = true;
            }
          } finally {
            if (SavedPosition != null) { SavedPosition.$destroy(); }
          }
        }
      }
      
      // Load the pending visible updates for this decl context, if it has any.
      DenseMapIteratorUIntType<SmallVector<PendingVisibleUpdate>> I = PendingVisibleUpdates.find(ID);
      if (I.$noteq(/*NO_ITER_COPY*/PendingVisibleUpdates.end())) {
        SmallVector<PendingVisibleUpdate> VisibleUpdates = new SmallVector<PendingVisibleUpdate>(JD$Move.INSTANCE, std.move(I.$arrow().second));
        PendingVisibleUpdates.erase($Clone(I));
        
        DeclContext /*P*/ DC = cast_DeclContext(D).getPrimaryContext();
        for (final /*const*/ PendingVisibleUpdate /*&*/ Update : VisibleUpdates)  {
          Lookups.$at_T1$RR(DC).Table.add(Update.Mod, Update.Data, 
              new org.clang.serialization.reader.impl.ASTDeclContextNameLookupTrait(/*Deref*/this, $Deref(Update.Mod)));
        }
        DC.setHasExternalVisibleStorage(true);
      }
    } finally {
      if (ProcessingUpdates != null) { ProcessingUpdates.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::loadPendingDeclChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3536,
   FQN="clang::ASTReader::loadPendingDeclChain", NM="_ZN5clang9ASTReader20loadPendingDeclChainEPNS_4DeclEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader20loadPendingDeclChainEPNS_4DeclEy")
  //</editor-fold>
  private void loadPendingDeclChain(Decl /*P*/ FirstLocal, long/*uint64_t*/ LocalOffset) {
    SavedStreamPosition SavedPosition = null;
    try {
      // Attach FirstLocal to the end of the decl chain.
      Decl /*P*/ CanonDecl = FirstLocal.getCanonicalDecl();
      if (FirstLocal != CanonDecl) {
        Decl /*P*/ PrevMostRecent = ASTDeclReader.getMostRecentDecl(CanonDecl);
        ASTDeclReader.attachPreviousDecl(/*Deref*/this, FirstLocal, (PrevMostRecent != null) ? PrevMostRecent : CanonDecl, 
            CanonDecl);
      }
      if (!(LocalOffset != 0)) {
        ASTDeclReader.attachLatestDecl(CanonDecl, FirstLocal);
        return;
      }
      
      // Load the list of other redeclarations from this module file.
      ModuleFile /*P*/ M = getOwningModuleFile(FirstLocal);
      assert ((M != null)) : "imported decl from no module file";
      
      final BitstreamCursor /*&*/ Cursor = M.DeclsCursor;
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(LocalOffset);
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      /*uint*/int Code = Cursor.ReadCode();
      /*uint*/int RecCode = Cursor.readRecord(Code, Record);
      ///*J:(void)*/RecCode;
      assert (RecCode == LOCAL_REDECLARATIONS) : "expected LOCAL_REDECLARATIONS record!";
      
      // FIXME: We have several different dispatches on decl kind here; maybe
      // we should instead generate one loop per kind and dispatch up-front?
      Decl /*P*/ MostRecent = FirstLocal;
      for (/*uint*/int I = 0, N = Record.size(); I != N; ++I) {
        Decl /*P*/ D = GetLocalDecl($Deref(M), $ullong2uint(Record.$at(N - I - 1)));
        ASTDeclReader.attachPreviousDecl(/*Deref*/this, D, MostRecent, CanonDecl);
        MostRecent = D;
      }
      ASTDeclReader.attachLatestDecl(CanonDecl, MostRecent);
    } finally {
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }


  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::loadObjCCategories">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3687,
   FQN="clang::ASTReader::loadObjCCategories", NM="_ZN5clang9ASTReader18loadObjCCategoriesEjPNS_17ObjCInterfaceDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader18loadObjCCategoriesEjPNS_17ObjCInterfaceDeclEj")
  //</editor-fold>
  private void loadObjCCategories(/*uint32_t*/int ID, 
                    ObjCInterfaceDecl /*P*/ D) {
    loadObjCCategories(ID, 
                    D, 
                    0);
  }
  private void loadObjCCategories(/*uint32_t*/int ID, 
                    ObjCInterfaceDecl /*P*/ D, 
                    /*uint*/int PreviousGeneration/*= 0*/) {
    ObjCCategoriesVisitor Visitor = null;
    try {
      Visitor/*J*/= new ObjCCategoriesVisitor(/*Deref*/this, ID, D, CategoriesDeserialized, 
          PreviousGeneration);
      ModuleMgr.visit(/*FuncArg*/Visitor);
    } finally {
      if (Visitor != null) { Visitor.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getLocalBitOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2531,
   FQN="clang::ASTReader::getLocalBitOffset", NM="_ZN5clang9ASTReader17getLocalBitOffsetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader17getLocalBitOffsetEy")
  //</editor-fold>
  private ASTReader.RecordLocation getLocalBitOffset(long/*uint64_t*/ GlobalOffset) {
    type$ptr<std.pairULongPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalBitOffsetsMap.find(GlobalOffset));
    assert ($noteq_ptr(I, GlobalBitOffsetsMap.end())) : "Corrupted global bit offsets map";
    return new RecordLocation(I./*->*/$star().second, GlobalOffset - I./*->*/$star().second.GlobalBitOffset);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalBitOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2539,
   FQN="clang::ASTReader::getGlobalBitOffset", NM="_ZN5clang9ASTReader18getGlobalBitOffsetERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader18getGlobalBitOffsetERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  /*friend*/public long/*uint64_t*/ getGlobalBitOffset(final ModuleFile /*&*/ M, /*uint32_t*/int LocalOffset) {
    return $uint2ullong(LocalOffset) + M.GlobalBitOffset;
  }


  
  /// \brief Returns the first preprocessed entity ID that begins or ends after
  /// \arg Loc.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::findPreprocessedEntity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5011,
   FQN="clang::ASTReader::findPreprocessedEntity", NM="_ZNK5clang9ASTReader22findPreprocessedEntityENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader22findPreprocessedEntityENS_14SourceLocationEb")
  //</editor-fold>
  private /*uint32_t*/int findPreprocessedEntity(SourceLocation Loc, 
                        boolean EndsAfter) /*const*/ {
    if (SourceMgr.isLocalSourceLocation(/*NO_COPY*/Loc)) {
      return getTotalNumPreprocessedEntities();
    }

    type$ptr</*const*/std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> SLocMapI = $tryClone(GlobalSLocOffsetMap.find$Const(SourceManager.MaxLoadedOffset - Loc.getOffset() - 1));
    assert ($noteq_ptr(SLocMapI, GlobalSLocOffsetMap.end$Const())) : "Corrupted global sloc offset map";
    if (SLocMapI./*->*/$star().second.NumPreprocessedEntities == 0) {
      return findNextPreprocessedEntity(SLocMapI);
    }
    
    final ModuleFile /*&*/ M = $Deref(SLocMapI./*->*/$star().second);
    // JAVA: typedef const PPEntityOffset *pp_iterator
//    final class pp_iterator extends /*const*/ PPEntityOffset /*P*/ { };
    type$ptr</*const*/ PPEntityOffset /*P*/ > pp_begin = M.PreprocessedEntityOffsets;
    type$ptr</*const*/ PPEntityOffset /*P*/ > pp_end = $tryClone(pp_begin.$add(M.NumPreprocessedEntities));
    
    /*size_t*/int Count = M.NumPreprocessedEntities;
    /*size_t*/int Half;
    type$ptr</*const*/ PPEntityOffset /*P*/ > First = $tryClone(pp_begin);
    type$ptr</*const*/ PPEntityOffset /*P*/ > PPI = create_type$ptr();
    if (EndsAfter) {
      PPI = /*create_type$ptr(*/
              std.upper_bound(pp_begin, pp_end, Loc, 
          new PPEntityComp(/*Deref*/this, M))/*)*/;
    } else {
      // Do a binary search manually instead of using std::lower_bound because
      // The end locations of entities may be unordered (when a macro expansion
      // is inside another macro argument), but for this case it is not important
      // whether we get the first macro expansion or its containing macro.
      while ($greater_uint(Count, 0)) {
        Half = $div_uint(Count, 2);
        PPI = $tryClone(First);
        std.advance(PPI, Half);
        if (SourceMgr.isBeforeInTranslationUnit(TranslateSourceLocation(M, PPI./*->*/$star().getEnd()), /*NO_COPY*/Loc)) {
          First = $tryClone(PPI);
          First.$preInc();
          Count = Count - Half - 1;
        } else {
          Count = Half;
        }
      }
    }
    if ($eq_ptr(PPI, pp_end)) {
      return findNextPreprocessedEntity(SLocMapI);
    }
    
    return M.BasePreprocessedEntityID + (PPI.$sub(pp_begin));
  }

  
  /// \brief Find the next module that contains entities and return the ID
  /// of the first entry.
  ///
  /// \param SLocMapI points at a chunk of a module that contains no
  /// preprocessed entities or the entities it contains are not the
  /// ones we are looking for.
  
  /// \brief \arg SLocMapI points at a chunk of a module that contains no
  /// preprocessed entities or the entities it contains are not the ones we are
  /// looking for. Find the next module that contains entities and return the ID
  /// of the first entry.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::findNextPreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4967,
   FQN="clang::ASTReader::findNextPreprocessedEntity", NM="_ZNK5clang9ASTReader26findNextPreprocessedEntityEPKSt4pairIjPNS_13serialization10ModuleFileEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader26findNextPreprocessedEntityEPKSt4pairIjPNS_13serialization10ModuleFileEE")
  //</editor-fold>
  private /*uint32_t*/int findNextPreprocessedEntity(type$ptr</*const*/std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> SLocMapI) /*const*/ {
    SLocMapI.$preInc();
    for (type$ptr</*const*/std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> EndI = $tryClone(GlobalSLocOffsetMap.end$Const()); $noteq_ptr(SLocMapI, EndI); SLocMapI.$preInc()) {
      final ModuleFile /*&*/ M = $Deref(SLocMapI./*->*/$star().second);
      if ((M.NumPreprocessedEntities != 0)) {
        return M.BasePreprocessedEntityID;
      }
    }
    
    return getTotalNumPreprocessedEntities();
  }

  
  /// \brief Returns (ModuleFile, Local index) pair for \p GlobalIndex of a
  /// preprocessed entity.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModulePreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4847,
   FQN="clang::ASTReader::getModulePreprocessedEntity", NM="_ZN5clang9ASTReader27getModulePreprocessedEntityEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader27getModulePreprocessedEntityEj")
  //</editor-fold>
  private std.pairPtrUInt<ModuleFile /*P*/ > getModulePreprocessedEntity(/*uint*/int GlobalIndex) {
    type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalPreprocessedEntityMap.find(GlobalIndex));
    assert ($noteq_ptr(I, GlobalPreprocessedEntityMap.end())) : "Corrupted global preprocessed entity map";
    ModuleFile /*P*/ M = I./*->*/$star().second;
    /*uint*/int LocalIndex = GlobalIndex - M.BasePreprocessedEntityID;
    return std.make_pair_Ptr_uint(M, LocalIndex);
  }

  
  /// \brief Returns (begin, end) pair for the preprocessed entities of a
  /// particular module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModulePreprocessedEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4858,
   FQN="clang::ASTReader::getModulePreprocessedEntities", NM="_ZNK5clang9ASTReader29getModulePreprocessedEntitiesERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader29getModulePreprocessedEntitiesERNS_13serialization10ModuleFileE")
  //</editor-fold>
  /*friend*/public/*private*/ iterator_range<PreprocessedEntity /*P*/ > getModulePreprocessedEntities(final ModuleFile /*&*/ Mod) /*const*/ {
    {
      PreprocessingRecord /*P*/ PPRec = PP.getPreprocessingRecord();
      if ((PPRec != null)) {
        return PPRec.getIteratorsForLoadedRange(Mod.BasePreprocessedEntityID, 
            Mod.NumPreprocessedEntities);
      }
    }
    
    return llvm.make_range(new PreprocessingRecord.iterator(), 
        new PreprocessingRecord.iterator());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1242,
   FQN="clang::ASTReader::ModuleDeclIterator", NM="_ZN5clang9ASTReader18ModuleDeclIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ModuleDeclIteratorE")
  //</editor-fold>
  private static class ModuleDeclIterator extends /*public*/ iterator_adaptor_base<ModuleDeclIterator,
          /*const*//*uint32_t P*/uint$ptr ,
          std.random_access_iterator_tag,
          /*const*/ Decl /*P*/ ,
          /*const*/ Decl /*P*/ > implements Native.NativeComparable {
    private ASTReader /*P*/ Reader;
    private ModuleFile /*P*/ Mod;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1251,
     FQN="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator", NM="_ZN5clang9ASTReader18ModuleDeclIteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ModuleDeclIteratorC1Ev")
    //</editor-fold>
    public ModuleDeclIterator() {
      // : iterator_adaptor_base<ModuleDeclIterator, const unsigned int * , random_access_iterator_tag, const Decl * , int, const Decl * , const Decl * , iterator_traitsT$C$P<unsigned int> >(null), Reader(null), Mod(null) 
      //START JInit
      super((/*const*/uint$ptr/*uint P*/ )null);
      this.Reader = null;
      this.Mod = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1254,
     FQN="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator", NM="_ZN5clang9ASTReader18ModuleDeclIteratorC1EPS0_PNS_13serialization10ModuleFileEPKj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ModuleDeclIteratorC1EPS0_PNS_13serialization10ModuleFileEPKj")
    //</editor-fold>
    public ModuleDeclIterator(ASTReader /*P*/ Reader, ModuleFile /*P*/ Mod, 
        /*const*//*uint32_t P*/uint$ptr Pos) {
      // : iterator_adaptor_base<ModuleDeclIterator, const unsigned int * , random_access_iterator_tag, const Decl * , int, const Decl * , const Decl * , iterator_traitsT$C$P<unsigned int> >(Pos), Reader(Reader), Mod(Mod) 
      //START JInit
      super(Pos);
      this.Reader = Reader;
      this.Mod = Mod;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1258,
     FQN="clang::ASTReader::ModuleDeclIterator::operator*", NM="_ZNK5clang9ASTReader18ModuleDeclIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader18ModuleDeclIteratordeEv")
    //</editor-fold>
    public /*const*/ Decl $star() /*const*/ {
      return Reader.GetDecl(Reader.getGlobalDeclID($Deref(Mod), I.$star()));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1261,
     FQN="clang::ASTReader::ModuleDeclIterator::operator->", NM="_ZNK5clang9ASTReader18ModuleDeclIteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader18ModuleDeclIteratorptEv")
    //</editor-fold>
    public /*const*/ Decl $arrow() /*const*/ {
      return /*Deref*/this.$star();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1263,
     FQN="clang::ASTReader::ModuleDeclIterator::operator==", NM="_ZNK5clang9ASTReader18ModuleDeclIteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader18ModuleDeclIteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ ModuleDeclIterator /*&*/ RHS) /*const*/ {
      assert (Reader == RHS.Reader && Mod == RHS.Mod);
      return $eq_ptr(I, RHS.I);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1242,
     FQN="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator", NM="_ZN5clang9ASTReader18ModuleDeclIteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ModuleDeclIteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ ModuleDeclIterator(JD$Move _dparam, final ModuleDeclIterator /*&&*/$Prm0) {
      // : iterator_adaptor_base<ModuleDeclIterator, const LocalDeclID * , std::random_access_iterator_tag, const Decl * , ptrdiff_t, const Decl * , const Decl * >(static_cast<ModuleDeclIterator &&>()), Reader(static_cast<ModuleDeclIterator &&>().Reader), Mod(static_cast<ModuleDeclIterator &&>().Mod) 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      this.Reader = $Prm0.Reader;
      this.Mod = $Prm0.Mod;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1242,
     FQN="clang::ASTReader::ModuleDeclIterator::ModuleDeclIterator", NM="_ZN5clang9ASTReader18ModuleDeclIteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang9ASTReader18ModuleDeclIteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ModuleDeclIterator(final /*const*/ ModuleDeclIterator /*&*/ $Prm0) {
      // : iterator_adaptor_base<ModuleDeclIterator, const LocalDeclID * , std::random_access_iterator_tag, const Decl * , ptrdiff_t, const Decl * , const Decl * >(), Reader(.Reader), Mod(.Mod) 
      //START JInit
      super($Prm0);
      this.Reader = $Prm0.Reader;
      this.Mod = $Prm0.Mod;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public ModuleDeclIterator clone() { return new ModuleDeclIterator(this); }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Reader=" + Reader // NOI18N
                + ", Mod=" + Mod // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModuleFileLevelDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4868,
   FQN="clang::ASTReader::getModuleFileLevelDecls", NM="_ZN5clang9ASTReader23getModuleFileLevelDeclsERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23getModuleFileLevelDeclsERNS_13serialization10ModuleFileE")
  //</editor-fold>
  /*friend*/public/*private*/ iterator_range</*const*/ Decl> getModuleFileLevelDecls(final ModuleFile /*&*/ Mod) {
    return llvm.make_range(new ModuleDeclIterator(this, $AddrOf(Mod), Mod.FileSortedDecls), 
        new ModuleDeclIterator(this, $AddrOf(Mod), 
            Mod.FileSortedDecls.$add(Mod.NumFileSortedDecls)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PassInterestingDeclsToConsumer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6709,
   FQN="clang::ASTReader::PassInterestingDeclsToConsumer", NM="_ZN5clang9ASTReader30PassInterestingDeclsToConsumerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader30PassInterestingDeclsToConsumerEv")
  //</editor-fold>
  private void PassInterestingDeclsToConsumer() {
    SaveAndRestoreBool GuardPassingDeclsToConsumer = null;
    try {
      assert Native.$bool(Consumer);
      if (PassingDeclsToConsumer) {
        return;
      }
      
      // Guard variable to avoid recursively redoing the process of passing
      // decls to consumer.
      GuardPassingDeclsToConsumer/*J*/= new SaveAndRestoreBool(PassingDeclsToConsumer_ref, 
          true);
      
      // Ensure that we've loaded all potentially-interesting declarations
      // that need to be eagerly loaded.
      for (/*ullong*/long ID : EagerlyDeserializedDecls)  {
        GetDecl($ullong2uint(ID));
      }
      EagerlyDeserializedDecls.clear();
      while (!InterestingDecls.empty()) {
        Decl /*P*/ D = InterestingDecls.front();
        InterestingDecls.pop_front();
        
        PassInterestingDeclToConsumer(D);
      }
    } finally {
      if (GuardPassingDeclsToConsumer != null) { GuardPassingDeclsToConsumer.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PassInterestingDeclToConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6734,
   FQN="clang::ASTReader::PassInterestingDeclToConsumer", NM="_ZN5clang9ASTReader29PassInterestingDeclToConsumerEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader29PassInterestingDeclToConsumerEPNS_4DeclE")
  //</editor-fold>
  private void PassInterestingDeclToConsumer(Decl /*P*/ D) {
    {
      ObjCImplDecl /*P*/ ImplD = dyn_cast_ObjCImplDecl(D);
      if ((ImplD != null)) {
        PassObjCImplDeclToConsumer(ImplD, Consumer);
      } else {
        Consumer.HandleInterestingDecl(new DeclGroupRef(D));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::finishPendingActions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8303,
   FQN="clang::ASTReader::finishPendingActions", NM="_ZN5clang9ASTReader20finishPendingActionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20finishPendingActionsEv")
  //</editor-fold>
  private void finishPendingActions() {
    while (!PendingIdentifierInfos.empty()
       || !PendingIncompleteDeclChains.empty() || !PendingDeclChains.empty()
       || !PendingMacroIDs.empty() || !PendingDeclContextInfos.empty()
       || !PendingUpdateRecords.empty()) {
      DenseMap<IdentifierInfo /*P*/ , SmallVector<Decl /*P*/>> TopLevelDecls = null;
      try {
        // If any identifiers with corresponding top-level declarations have
        // been loaded, load those declarations now.
        // JAVA: typedef llvm::DenseMap<IdentifierInfo *, SmallVector<Decl *, 2> > TopLevelDeclsMap
//        final class TopLevelDeclsMap extends DenseMap<IdentifierInfo /*P*/ , SmallVector<Decl /*P*/>>{ };
        TopLevelDecls/*J*/= new DenseMap<IdentifierInfo /*P*/ , SmallVector<Decl /*P*/>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<Decl /*P*/>(2, (Decl/*P*/)null));
        while (!PendingIdentifierInfos.empty()) {
          IdentifierInfo /*P*/ II = PendingIdentifierInfos.back().first;
          SmallVectorUInt DeclIDs = new SmallVectorUInt(JD$Move.INSTANCE, std.move(PendingIdentifierInfos.back().second));
          PendingIdentifierInfos.pop_back();
          
          SetGloballyVisibleDecls(II, DeclIDs, $AddrOf(TopLevelDecls.$at_T1$C$R(II)));
        }
        
        // For each decl chain that we wanted to complete while deserializing, mark
        // it as "still needs to be completed".
        for (/*uint*/int I = 0; I != PendingIncompleteDeclChains.size(); ++I) {
          markIncompleteDeclChain(PendingIncompleteDeclChains.$at(I));
        }
        PendingIncompleteDeclChains.clear();
        
        // Load pending declaration chains.
        for (/*uint*/int I = 0; I != PendingDeclChains.size(); ++I)  {
          loadPendingDeclChain(PendingDeclChains.$at(I).first, PendingDeclChains.$at(I).second);
        }
        PendingDeclChains.clear();
        
        // Make the most recent of the top-level declarations visible.
        for (DenseMapIterator<IdentifierInfo /*P*/ , SmallVector<Decl /*P*/>> TLD = TopLevelDecls.begin(), 
            TLDEnd = TopLevelDecls.end(); TLD.$noteq(/*NO_ITER_COPY*/TLDEnd); TLD.$preInc()) {
          IdentifierInfo /*P*/ II = TLD.$arrow().first;
          for (/*uint*/int I = 0, N = TLD.$arrow().second.size(); I != N; ++I) {
            pushExternalDeclIntoScope(cast_NamedDecl(TLD.$arrow().second.$at(I)), new DeclarationName(II));
          }
        }
        
        // Load any pending macro definitions.
        for (/*uint*/int I = 0; I != PendingMacroIDs.size(); ++I) {
          IdentifierInfo /*P*/ II = PendingMacroIDs.begin().$at(I).first;
          SmallVector<PendingMacroInfo> GlobalIDs/*J*/= new SmallVector<PendingMacroInfo>(2, new PendingMacroInfo());
          GlobalIDs.swap(PendingMacroIDs.begin().$at(I).second);
          // Initialize the macro history from chained-PCHs ahead of module imports.
          for (/*uint*/int IDIdx = 0, NumIDs = GlobalIDs.size(); IDIdx != NumIDs;
               ++IDIdx) {
            final /*const*/ PendingMacroInfo /*&*/ Info = GlobalIDs.$at(IDIdx);
            if (Info.M.Kind != ModuleKind.MK_ImplicitModule
               && Info.M.Kind != ModuleKind.MK_ExplicitModule) {
              resolvePendingMacro(II, Info);
            }
          }
          // Handle module imports.
          for (/*uint*/int IDIdx = 0, NumIDs = GlobalIDs.size(); IDIdx != NumIDs;
               ++IDIdx) {
            final /*const*/ PendingMacroInfo /*&*/ Info = GlobalIDs.$at(IDIdx);
            if (Info.M.Kind == ModuleKind.MK_ImplicitModule
               || Info.M.Kind == ModuleKind.MK_ExplicitModule) {
              resolvePendingMacro(II, Info);
            }
          }
        }
        PendingMacroIDs.clear();
        
        // Wire up the DeclContexts for Decls that we delayed setting until
        // recursive loading is completed.
        while (!PendingDeclContextInfos.empty()) {
          PendingDeclContextInfo Info = new PendingDeclContextInfo(PendingDeclContextInfos.front());
          PendingDeclContextInfos.pop_front();
          DeclContext /*P*/ SemaDC = cast_DeclContext(GetDecl(Info.SemaDC));
          DeclContext /*P*/ LexicalDC = cast_DeclContext(GetDecl(Info.LexicalDC));
          Info.D.setDeclContextsImpl(SemaDC, LexicalDC, getContext());
        }
        
        // Perform any pending declaration updates.
        while (!PendingUpdateRecords.empty()) {
          ReadingKindTracker ReadingKind = null;
          try {
            std.pairUIntPtr<Decl /*P*/ > Update = PendingUpdateRecords.pop_back_val();
            ReadingKind/*J*/= new ReadingKindTracker(ASTReader.ReadingKind.Read_Decl, /*Deref*/this);
            loadDeclUpdateRecords(Update.first, Update.second);
          } finally {
            if (ReadingKind != null) { ReadingKind.$destroy(); }
          }
        }
      } finally {
        if (TopLevelDecls != null) { TopLevelDecls.$destroy(); }
      }
    }
    
    // At this point, all update records for loaded decls are in place, so any
    // fake class definitions should have become real.
    assert (PendingFakeDefinitionData.empty()) : "faked up a class definition but never saw the real one";
    
    // If we deserialized any C++ or Objective-C class definitions, any
    // Objective-C protocol definitions, or any redeclarable templates, make sure
    // that all redeclarations point to the definitions. Note that this can only 
    // happen now, after the redeclaration chains have been fully wired.
    for (Decl /*P*/ D : PendingDefinitions) {
      {
        TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
        if ((TD != null)) {
          {
            /*const*/ TagType /*P*/ TagT = dyn_cast_TagType(TD.getTypeForDecl());
            if ((TagT != null)) {
              // Make sure that the TagType points at the definition.
              ((/*const_cast*/TagType /*P*/ )(TagT)).decl = TD;
            }
          }
          {
            
            CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
            if ((RD != null)) {
              for (Decl /*P*/ R = getMostRecentExistingDecl(RD); (R != null);
                   R = R.getPreviousDecl$Decl()) {
                assert ((R == D) == cast_CXXRecordDecl(R).isThisDeclarationADefinition()) : "declaration thinks it's the definition but it isn't";
                cast_CXXRecordDecl(R).DefinitionData = RD.DefinitionData;
              }
            }
          }
          
          continue;
        }
      }
      {
        
        ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(D);
        if ((ID != null)) {
          // Make sure that the ObjCInterfaceType points at the definition.
          ((/*const_cast*/ObjCInterfaceType /*P*/ )(cast_ObjCInterfaceType(ID.TypeForDecl))).
              Decl = ID;
          
          for (Decl /*P*/ R = getMostRecentExistingDecl(ID); (R != null); R = R.getPreviousDecl$Decl())  {
            cast_ObjCInterfaceDecl(R).Data.$assign(ID.Data);
          }
          
          continue;
        }
      }
      {
        
        ObjCProtocolDecl /*P*/ PD = dyn_cast_ObjCProtocolDecl(D);
        if ((PD != null)) {
          for (Decl /*P*/ R = getMostRecentExistingDecl(PD); (R != null); R = R.getPreviousDecl$Decl())  {
            cast_ObjCProtocolDecl(R).Data.$assign(PD.Data);
          }
          
          continue;
        }
      }
      
      RedeclarableTemplateDecl /*P*/ RTD = cast_RedeclarableTemplateDecl(D).getCanonicalDecl();
      for (Decl /*P*/ R = getMostRecentExistingDecl(RTD); (R != null); R = R.getPreviousDecl$Decl())  {
        cast_RedeclarableTemplateDecl(R).Common = RTD.Common;
      }
    }
    PendingDefinitions.clear();
    
    // Load the bodies of any functions or methods we've encountered. We do
    // this now (delayed) so that we can be sure that the declaration chains
    // have been fully wired up (hasBody relies on this).
    // FIXME: We shouldn't require complete redeclaration chains here.
    for (StdVector.iterator<pairPtrULong<Decl>> PB = $tryClone(PendingBodies.begin()), 
        /*P*/ PBEnd = $tryClone(PendingBodies.end());
         $noteq_ptr(PB, PBEnd); PB.$preInc()) {
      {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(PB./*->*/$star().first);
        if ((FD != null)) {
          // FIXME: Check for =delete/=default?
          // FIXME: Complain about ODR violations here?
          if (!getContext().getLangOpts().Modules || !FD.hasBody()) {
            FD.setLazyBody(PB./*->*/$star().second);
          }
          continue;
        }
      }
      
      ObjCMethodDecl /*P*/ MD = cast_ObjCMethodDecl(PB./*->*/$star().first);
      if (!getContext().getLangOpts().Modules || !MD.hasBody()) {
        MD.setLazyBody(PB./*->*/$star().second);
      }
    }
    PendingBodies.clear();
    
    // Do some cleanup.
    for (NamedDecl /*P*/ ND : PendingMergedDefinitionsToDeduplicate)  {
      getContext().deduplicateMergedDefinitonsFor(ND);
    }
    PendingMergedDefinitionsToDeduplicate.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::diagnoseOdrViolations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8466,
   FQN="clang::ASTReader::diagnoseOdrViolations", NM="_ZN5clang9ASTReader21diagnoseOdrViolationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader21diagnoseOdrViolationsEv")
  //</editor-fold>
  private void diagnoseOdrViolations() {
    SmallDenseMap<CXXRecordDecl /*P*/  , TinyPtrVector<CXXRecordDecl /*P*/ >> OdrMergeFailures = null;
    ExternalASTSource.Deserializing RecursionGuard = null;
    try {
      if (PendingOdrMergeFailures.empty() && PendingOdrMergeChecks.empty()) {
        return;
      }
      
      // Trigger the import of the full definition of each class that had any
      // odr-merging problems, so we can produce better diagnostics for them.
      // These updates may in turn find and diagnose some ODR failures, so take
      // ownership of the set first.
      OdrMergeFailures = new SmallDenseMap<CXXRecordDecl /*P*/  , TinyPtrVector<CXXRecordDecl /*P*/ >>(JD$Move.INSTANCE, std.move(PendingOdrMergeFailures));
      PendingOdrMergeFailures.clear();
      for (final std.pair<CXXRecordDecl /*P*/ , TinyPtrVector<CXXRecordDecl /*P*/ >> /*&*/ Merge : OdrMergeFailures) {
        Merge.first.buildLookup();
        Merge.first.decls_begin();
        Merge.first.bases_begin();
        Merge.first.vbases_begin();
        for (CXXRecordDecl /*P*/ RD : Merge.second) {
          RD.decls_begin();
          RD.bases_begin();
          RD.vbases_begin();
        }
      }
      
      // For each declaration from a merged context, check that the canonical
      // definition of that context also contains a declaration of the same
      // entity.
      //
      // Caution: this loop does things that might invalidate iterators into
      // PendingOdrMergeChecks. Don't turn this into a range-based for loop!
      while (!PendingOdrMergeChecks.empty()) {
        NamedDecl /*P*/ D = PendingOdrMergeChecks.pop_back_val();
        
        // FIXME: Skip over implicit declarations for now. This matters for things
        // like implicitly-declared special member functions. This isn't entirely
        // correct; we can end up with multiple unmerged declarations of the same
        // implicit entity.
        if (D.isImplicit()) {
          continue;
        }
        
        DeclContext /*P*/ CanonDef = D.getDeclContext();
        
        boolean Found = false;
        /*const*/ Decl /*P*/ DCanon = D.getCanonicalDecl();
        
        for (Decl /*P*/ RI : D.decl_redecls()) {
          if (RI.getLexicalDeclContext() == CanonDef) {
            Found = true;
            break;
          }
        }
        if (Found) {
          continue;
        }
        
        // Quick check failed, time to do the slow thing. Note, we can't just
        // look up the name of D in CanonDef here, because the member that is
        // in CanonDef might not be found by name lookup (it might have been
        // replaced by a more recent declaration in the lookup table), and we
        // can't necessarily find it in the redeclaration chain because it might
        // be merely mergeable, not redeclarable.
        SmallVector</*const*/ NamedDecl /*P*/ > Candidates/*J*/= new SmallVector</*const*/ NamedDecl /*P*/ >(4, (/*const*/ NamedDecl /*P*/ )null);
        for (Decl /*P*/ CanonMember : CanonDef.decls()) {
          if (CanonMember.getCanonicalDecl() == DCanon) {
            // This can happen if the declaration is merely mergeable and not
            // actually redeclarable (we looked for redeclarations earlier).
            //
            // FIXME: We should be able to detect this more efficiently, without
            // pulling in all of the members of CanonDef.
            Found = true;
            break;
          }
          {
            NamedDecl /*P*/ ND = dyn_cast_NamedDecl(CanonMember);
            if ((ND != null)) {
              if (DeclarationName.$eq_DeclarationName(ND.getDeclName(), D.getDeclName())) {
                Candidates.push_back(ND);
              }
            }
          }
        }
        if (!Found) {
          ExternalASTSource.Deserializing RecursionGuard$1 = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The AST doesn't like TagDecls becoming invalid after they've been
            // completed. We only really need to mark FieldDecls as invalid here.
            if (!isa_TagDecl(D)) {
              D.setInvalidDecl();
            }
            
            // Ensure we don't accidentally recursively enter deserialization while
            // we're producing our diagnostic.
            RecursionGuard$1/*J*/= new ExternalASTSource.Deserializing(this);
            
            std.string CanonDefModule = getOwningModuleNameForDiagnostic(cast_Decl(CanonDef));
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out$Same2DeclContext($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diag(D.getLocation(), diag.err_module_odr_violation_missing_decl)), 
                                D), new StringRef(getOwningModuleNameForDiagnostic(D))), 
                        CanonDef), CanonDefModule.empty()), new StringRef(CanonDefModule)));
            if (Candidates.empty()) {
              $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diag(cast_Decl(CanonDef).getLocation(), 
                      diag.note_module_odr_violation_no_possible_decls)), D));
            } else {
              for (/*uint*/int I = 0, N = Candidates.size(); I != N; ++I)  {
                $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diag(Candidates.$at(I).getLocation(), 
                        diag.note_module_odr_violation_possible_decl)), 
                    Candidates.$at(I)));
              }
            }
            
            DiagnosedOdrMergeFailures.insert(CanonDef);
          } finally {
            if (RecursionGuard$1 != null) { RecursionGuard$1.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      if (OdrMergeFailures.empty()) {
        return;
      }
      
      // Ensure we don't accidentally recursively enter deserialization while
      // we're producing our diagnostics.
      RecursionGuard/*J*/= new ExternalASTSource.Deserializing(this);
      
      // Issue any pending ODR-failure diagnostics.
      for (final std.pair<CXXRecordDecl /*P*/ , TinyPtrVector<CXXRecordDecl /*P*/ >> /*&*/ Merge : OdrMergeFailures) {
        // If we've already pointed out a specific problem with this class, don't
        // bother issuing a general "something's different" diagnostic.
        if (!DiagnosedOdrMergeFailures.insert(Merge.first).second) {
          continue;
        }
        
        boolean Diagnosed = false;
        for (CXXRecordDecl /*P*/ RD : Merge.second) {
          // Multiple different declarations got merged together; tell the user
          // where they came from.
          if (Merge.first != RD) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // FIXME: Walk the definition, figure out what's different,
              // and diagnose that.
              if (!Diagnosed) {
                std.string Module = getOwningModuleNameForDiagnostic(Merge.first);
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diag(Merge.first.getLocation(), 
                                diag.err_module_odr_violation_different_definitions)), 
                            Merge.first), Module.empty()), new StringRef(Module)));
                Diagnosed = true;
              }
              
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(RD.getLocation(), 
                      diag.note_module_odr_violation_different_definitions)), 
                  new StringRef(getOwningModuleNameForDiagnostic(RD))));
            } finally {
              $c$.$destroy();
            }
          }
        }
        if (!Diagnosed) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // All definitions are updates to the same declaration. This happens if a
            // module instantiates the declaration of a class template specialization
            // and two or more other modules instantiate its definition.
            //
            // FIXME: Indicate which modules had instantiations of this definition.
            // FIXME: How can this even happen?
            $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diag(Merge.first.getLocation(), 
                    diag.err_module_odr_violation_different_instantiations)), 
                Merge.first));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } finally {
      if (RecursionGuard != null) { RecursionGuard.$destroy(); }
      if (OdrMergeFailures != null) { OdrMergeFailures.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::pushExternalDeclIntoScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8662,
   FQN="clang::ASTReader::pushExternalDeclIntoScope", NM="_ZN5clang9ASTReader25pushExternalDeclIntoScopeEPNS_9NamedDeclENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25pushExternalDeclIntoScopeEPNS_9NamedDeclENS_15DeclarationNameE")
  //</editor-fold>
  private void pushExternalDeclIntoScope(NamedDecl /*P*/ D, DeclarationName Name) {
    {
      IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
      if ((II != null)) {
        // Remove any fake results before adding any real ones.

        StdVector.iterator<pairPtrType<IdentifierInfo /*P*/, SmallVector<NamedDecl/*P*/>>> It = $tryClone(PendingFakeLookupResults.find(II));
        if ($noteq_ptr(It, PendingFakeLookupResults.end())) {
          for (NamedDecl /*P*/ ND : It./*->*/$star().second)  {
            SemaObj.IdResolver.RemoveDecl(ND);
          }
          // FIXME: this works around module+PCH performance issue.
          // Rather than erase the result from the map, which is O(n), just clear
          // the vector of NamedDecls.
          It./*->*/$star().second.clear();
        }
      }
    }
    if (SemaObj.IdResolver.tryAddTopLevelDecl(D, new DeclarationName(Name)) && (SemaObj.TUScope != null)) {
      SemaObj.TUScope.AddDecl(D);
    } else if ((SemaObj.TUScope != null)) {
      // Adding the decl to IdResolver may have failed because it was already in
      // (even though it was not added in scope). If it is already in, make sure
      // it gets in the scope as well.
      if (std.find((type$iterator<?, NamedDecl>)SemaObj.IdResolver.begin(/*NO_COPY*/Name), 
          (type$iterator<?, NamedDecl>)SemaObj.IdResolver.end(), D).$noteq(SemaObj.IdResolver.end())) {
        SemaObj.TUScope.AddDecl(D);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::addPendingDeclContextInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1280,
   FQN="clang::ASTReader::addPendingDeclContextInfo", NM="_ZN5clang9ASTReader25addPendingDeclContextInfoEPNS_4DeclEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25addPendingDeclContextInfoEPNS_4DeclEjj")
  //</editor-fold>
  /*friend*/public void addPendingDeclContextInfo(Decl /*P*/ D, 
                           /*uint32_t*/int SemaDC, 
                           /*uint32_t*/int LexicalDC) {
    assert Native.$bool(D);
    PendingDeclContextInfo Info = new PendingDeclContextInfo(D, SemaDC, LexicalDC);
    PendingDeclContextInfos.push_back_T$C$R(Info);
  }

  
  /// \brief Produce an error diagnostic and return true.
  ///
  /// This routine should only be used for fatal errors that have to
  /// do with non-routine failures (e.g., corrupted AST file).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1048,
   FQN="clang::ASTReader::Error", NM="_ZN5clang9ASTReader5ErrorEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader5ErrorEN4llvm9StringRefE")
  //</editor-fold>
  /*friend*/public void Error(StringRef Msg) {
    Error(diag.err_fe_pch_malformed, new StringRef(Msg));
    if (Context.getLangOpts().Modules && !Diags.isDiagnosticInFlight()
       && !PP.getHeaderSearchInfo().getModuleCachePath().empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(diag.note_module_cache_path)), 
            PP.getHeaderSearchInfo().getModuleCachePath()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1057,
   FQN="clang::ASTReader::Error", NM="_ZN5clang9ASTReader5ErrorEjN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader5ErrorEjN4llvm9StringRefES2_")
  //</editor-fold>
  private void Error(/*uint*/int DiagID) {
    Error(DiagID, 
       new StringRef(), new StringRef());
  }
  private void Error(/*uint*/int DiagID, 
       StringRef Arg1/*= StringRef()*/) {
    Error(DiagID, 
       Arg1, new StringRef());
  }
  private void Error(/*uint*/int DiagID, 
       StringRef Arg1/*= StringRef()*/, StringRef Arg2/*= StringRef()*/) {
    if (Diags.isDiagnosticInFlight()) {
      Diags.SetDelayedDiagnostic(DiagID, /*NO_COPY*/Arg1, /*NO_COPY*/Arg2);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(DiagID)), /*NO_COPY*/Arg1), /*NO_COPY*/Arg2));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ASTReader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1296,
   FQN="clang::ASTReader::ASTReader", NM="_ZN5clang9ASTReaderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReaderC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ASTReader(final /*const*/ ASTReader /*&*/ $Prm0) {  throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1297,
   FQN="clang::ASTReader::operator=", NM="_ZN5clang9ASTReaderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReaderaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ ASTReader /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief Load the AST file and validate its contents against the given
  /// Preprocessor.
  ///
  /// \param PP the preprocessor associated with the context in which this
  /// precompiled header will be loaded.
  ///
  /// \param Context the AST context that this precompiled header will be
  /// loaded into.
  ///
  /// \param PCHContainerRdr the PCHContainerOperations to use for loading and
  /// creating modules.
  ///
  /// \param Extensions the list of module file extensions that can be loaded
  /// from the AST files.
  ///
  /// \param isysroot If non-NULL, the system include path specified by the
  /// user. This is only used with relocatable PCH files. If non-NULL,
  /// a relocatable PCH file will use the default path "/".
  ///
  /// \param DisableValidation If true, the AST reader will suppress most
  /// of its regular consistency checking, allowing the use of precompiled
  /// headers that cannot be determined to be compatible.
  ///
  /// \param AllowASTWithCompilerErrors If true, the AST reader will accept an
  /// AST file the was created out of an AST with compiler errors,
  /// otherwise it will reject it.
  ///
  /// \param AllowConfigurationMismatch If true, the AST reader will not check
  /// for configuration differences between the AST file and the invocation.
  ///
  /// \param ValidateSystemInputs If true, the AST reader will validate
  /// system input files in addition to user input files. This is only
  /// meaningful if \p DisableValidation is false.
  ///
  /// \param UseGlobalIndex If true, the AST reader will try to load and use
  /// the global module index.
  ///
  /// \param ReadTimer If non-null, a timer used to track the time spent
  /// deserializing.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ASTReader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8688,
   FQN="clang::ASTReader::ASTReader", NM="_ZN5clang9ASTReaderC1ERNS_12PreprocessorERNS_10ASTContextERKNS_18PCHContainerReaderEN4llvm8ArrayRefINS8_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEENS8_9StringRefEbbbbbSt10unique_ptrINS8_5TimerESt14default_deleteISG_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReaderC1ERNS_12PreprocessorERNS_10ASTContextERKNS_18PCHContainerReaderEN4llvm8ArrayRefINS8_18IntrusiveRefCntPtrINS_19ModuleFileExtensionEEEEENS8_9StringRefEbbbbbSt10unique_ptrINS8_5TimerESt14default_deleteISG_EE")
  //</editor-fold>
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      new StringRef(/*KEEP_STR*/$EMPTY), false, 
      false, 
      false, false, 
      true, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      isysroot, false, 
      false, 
      false, false, 
      true, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/, boolean DisableValidation/*= false*/) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      isysroot, DisableValidation, 
      false, 
      false, false, 
      true, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/, boolean DisableValidation/*= false*/, 
      boolean AllowASTWithCompilerErrors/*= false*/) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      isysroot, DisableValidation, 
      AllowASTWithCompilerErrors, 
      false, false, 
      true, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/, boolean DisableValidation/*= false*/, 
      boolean AllowASTWithCompilerErrors/*= false*/, 
      boolean AllowConfigurationMismatch/*= false*/) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      isysroot, DisableValidation, 
      AllowASTWithCompilerErrors, 
      AllowConfigurationMismatch, false, 
      true, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/, boolean DisableValidation/*= false*/, 
      boolean AllowASTWithCompilerErrors/*= false*/, 
      boolean AllowConfigurationMismatch/*= false*/, boolean ValidateSystemInputs/*= false*/) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      isysroot, DisableValidation, 
      AllowASTWithCompilerErrors, 
      AllowConfigurationMismatch, ValidateSystemInputs, 
      true, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/, boolean DisableValidation/*= false*/, 
      boolean AllowASTWithCompilerErrors/*= false*/, 
      boolean AllowConfigurationMismatch/*= false*/, boolean ValidateSystemInputs/*= false*/, 
      boolean UseGlobalIndex/*= true*/) {
    this(PP, Context, 
      PCHContainerRdr, 
      Extensions, 
      isysroot, DisableValidation, 
      AllowASTWithCompilerErrors, 
      AllowConfigurationMismatch, ValidateSystemInputs, 
      UseGlobalIndex, 
      /*$c$.track(*//*{ */new std.unique_ptr<Timer>()/* }*//*)*/);
  }
  public ASTReader(final Preprocessor /*&*/ PP, final ASTContext /*&*/ Context, 
      final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
      ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension>> Extensions, 
      StringRef isysroot/*= ""*/, boolean DisableValidation/*= false*/, 
      boolean AllowASTWithCompilerErrors/*= false*/, 
      boolean AllowConfigurationMismatch/*= false*/, boolean ValidateSystemInputs/*= false*/, 
      boolean UseGlobalIndex/*= true*/, 
      std.unique_ptr<Timer> ReadTimer/*= $c$.track({  })*/) {
    // : ExternalPreprocessorSource(), ExternalPreprocessingRecordSource(), ExternalHeaderFileInfoSource(), ExternalSemaSource(), IdentifierInfoLookup(), ExternalSLocEntrySource(), Listener(new PCHValidator(PP, *this)), DeserializationListener(null), OwnsDeserializationListener(false), SourceMgr(PP.getSourceManager()), FileMgr(PP.getFileManager()), PCHContainerRdr(PCHContainerRdr), Diags(PP.getDiagnostics()), SemaObj(null), PP(PP), Context(Context), Consumer(null), ModuleMgr(PP.getFileManager(), PCHContainerRdr), DummyIdResolver(PP), ModuleFileExtensions(), ReadTimer(std::move(ReadTimer)), CurrentImportLoc(), GlobalIndex(), GlobalBitOffsetsMap(), GlobalSLocEntryMap(), GlobalSLocOffsetMap(), TypesLoaded(), GlobalTypeMap(), DeclsLoaded(), GlobalDeclMap(), DeclUpdateOffsets(), PendingUpdateRecords(), PendingFakeDefinitionData(), PendingExceptionSpecUpdates(), ImportedTypedefNamesForLinkage(), AnonymousDeclarationsForMerging(), FileDeclIDs(), LexicalDecls(), TULexicalDecls(), Lookups(), PendingVisibleUpdates(), PendingDefinitions(), PendingBodies(), PendingMergedDefinitionsToDeduplicate(), IdentifiersLoaded(), GlobalIdentifierMap(), MacrosLoaded(), LoadedUndefs(), GlobalMacroMap(), SubmodulesLoaded(), GlobalSubmoduleMap(), HiddenNamesMap(), UnresolvedModuleRefs(), SelectorsLoaded(), GlobalSelectorMap(), SelectorGeneration(), SelectorOutOfDate(), PendingMacroIDs(), GlobalPreprocessedEntityMap(), EagerlyDeserializedDecls(), TentativeDefinitions(), VTableUses(), PendingInstantiations(), UnusedFileScopedDecls(), DelegatingCtorDecls(), ReferencedSelectorsData(), WeakUndeclaredIdentifiers(), ExtVectorDecls(), UnusedLocalTypedefNameCandidates(), SemaDeclRefs(), SpecialTypes(), CUDASpecialDeclRefs(), FPPragmaOptions(), OptimizeOffPragmaLocation(), PragmaMSStructState(-1), PragmaMSPointersToMembersState(-1), PointersToMembersPragmaLocation(), OpenCLExtensions(), KnownNamespaces(), UndefinedButUsed(), DelayedDeleteExprs(), LateParsedTemplates(), ImportedModules(), CurrentDir(), isysroot(isysroot.operator basic_string()), DisableValidation(DisableValidation), AllowASTWithCompilerErrors(AllowASTWithCompilerErrors), AllowConfigurationMismatch(AllowConfigurationMismatch), ValidateSystemInputs(ValidateSystemInputs), UseGlobalIndex(UseGlobalIndex), TriedLoadingGlobalIndex(false), ProcessingUpdateRecords(false), SwitchCaseStmts(), CurrSwitchCaseStmts(&SwitchCaseStmts), NumSLocEntriesRead(0), TotalNumSLocEntries(0), NumStatementsRead(0), TotalNumStatements(0), NumMacrosRead(0), TotalNumMacros(0), NumIdentifierLookups(0), NumIdentifierLookupHits(0), NumSelectorsRead(0), NumMethodPoolEntriesRead(0), NumMethodPoolLookups(0), NumMethodPoolHits(0), NumMethodPoolTableLookups(0), NumMethodPoolTableHits(0), TotalNumMethodPoolEntries(0), NumLexicalDeclContextsRead(0), TotalLexicalDeclContexts(0), NumVisibleDeclContextsRead(0), TotalVisibleDeclContexts(0), TotalModulesSizeInBits(0), NumCurrentElementsDeserializing(0), PassingDeclsToConsumer(false), PendingIdentifierInfos(), PendingFakeLookupResults(), IdentifierGeneration(), InterestingDecls(), PendingDeclChains(), PendingIncompleteDeclChains(), PendingDeclContextInfos(), PendingOdrMergeChecks(), PendingOdrMergeFailures(), DiagnosedOdrMergeFailures(), CategoriesDeserialized(), ObjCClassesLoaded(), KeyDecls(), MergedDeclContexts(), EnumDefinitions(), StmtStack(), ReadingKind(Read_None), SuggestedPredefines(), PreloadedDeclIDs(), CommentsCursors() 
    //START JInit
    super();
    $ExternalPreprocessorSource();
    $ExternalPreprocessingRecordSource();
    $ExternalHeaderFileInfoSource();
    $IdentifierInfoLookup();
    $ExternalSLocEntrySource();
    this.Listener = new std.unique_ptr<ASTReaderListener>(new PCHValidator(PP, /*Deref*/this));
    this.DeserializationListener = null;
    this.OwnsDeserializationListener = false;
    this./*&*/SourceMgr=/*&*/PP.getSourceManager();
    this./*&*/FileMgr=/*&*/PP.getFileManager();
    this./*&*/PCHContainerRdr=/*&*/PCHContainerRdr;
    this./*&*/Diags=/*&*/PP.getDiagnostics();
    this.SemaObj = null;
    this./*&*/PP=/*&*/PP;
    this./*&*/Context=/*&*/Context;
    this.Consumer = null;
    this.ModuleMgr = new ModuleManager(PP.getFileManager(), PCHContainerRdr);
    this.DummyIdResolver = new IdentifierResolver(PP);
    this.ModuleFileExtensions = new StringMap<IntrusiveRefCntPtr<ModuleFileExtension>>(new IntrusiveRefCntPtr<ModuleFileExtension>());
    this.ReadTimer = new std.unique_ptr<Timer>(JD$Move.INSTANCE, std.move(ReadTimer));
    this.CurrentImportLoc = new SourceLocation();
    this.GlobalIndex = new std.unique_ptr<GlobalModuleIndex>();
    this.GlobalBitOffsetsMap = new ContinuousRangeMapULongPtr<ModuleFile /*P*/ >(4);
    this.GlobalSLocEntryMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(64);
    this.GlobalSLocOffsetMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(64);
    this.TypesLoaded = new std.vector<QualType>(new QualType());
    this.GlobalTypeMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.DeclsLoaded = new std.vector<Decl /*P*/ >((Decl /*P*/ )null);
    this.GlobalDeclMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.DeclUpdateOffsets = new DenseMapUIntType<SmallVector<std.pairPtrULong<ModuleFile /*P*/ >>>(
            DenseMapInfoUInt.$Info(),
            new SmallVector<std.pairPtrULong<ModuleFile /*P*/ >>(2));
    this.PendingUpdateRecords = new SmallVector<std.pairUIntPtr<Decl /*P*/ >>(16, new std.pairUIntPtr<Decl /*P*/ >());
    this.PendingFakeDefinitionData = new DenseMap<Object/*void P*/ , PendingFakeDefinitionKind>(DenseMapInfo$LikePtr.$Info(), PendingFakeDefinitionKind.valueOf(0));
    this.PendingExceptionSpecUpdates = new SmallMapVectorPtrPtr<Decl /*P*/ , FunctionDecl /*P*/ >(4, DenseMapInfo$LikePtr.$Info(), (FunctionDecl /*P*/)null);
    this.ImportedTypedefNamesForLinkage = new DenseMap<std.pairPtrPtr<DeclContext /*P*/ , IdentifierInfo /*P*/ >, NamedDecl /*P*/ >(
                    new DenseMapInfoPair(DenseMapInfo$LikePtr.$Info(), DenseMapInfo$LikePtr.$Info()),
    (NamedDecl /*P*/ )null);
    this.AnonymousDeclarationsForMerging = new DenseMap<DeclContext /*P*/ , SmallVector<NamedDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new SmallVector<NamedDecl /*P*/ >(2));
    this.FileDeclIDs = new DenseMap<FileID, FileDeclsInfo>(org.clang.basic.llvm.DenseMapInfoFileID.$Info(), new FileDeclsInfo());
    this.LexicalDecls = new DenseMap</*const*/ DeclContext /*P*/ , std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/>>(
            DenseMapInfo$LikePtr.$Info(), new std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/>());
    this.TULexicalDecls = new std.vector<std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/>>(
            new std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/>());
    this.Lookups = new DenseMap</*const*/ DeclContext /*P*/ , DeclContextLookupTable>(DenseMapInfo$LikePtr.$Info(), DeclContextLookupTable.EMPTY_VALUE);
    this.PendingVisibleUpdates = new DenseMapUIntType<SmallVector<PendingVisibleUpdate>>(DenseMapInfoUInt.$Info(), new SmallVector<PendingVisibleUpdate>(1));
    this.PendingDefinitions = new SmallPtrSet<Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.PendingBodies = new MapVectorPtrULong<Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0L);
    this.PendingMergedDefinitionsToDeduplicate = new SetVector<NamedDecl /*P*/ >((NamedDecl /*P*/ )null);
    this.IdentifiersLoaded = new std.vector<IdentifierInfo /*P*/ >((IdentifierInfo /*P*/ )null);
    this.GlobalIdentifierMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.MacrosLoaded = new std.vector<MacroInfo /*P*/ >((MacroInfo /*P*/ )null);
    this.LoadedUndefs = new DenseSet<std.pairPtrUInt<IdentifierInfo /*P*/ >>(DenseMapInfoPairPtrUInt.$Info());
    this.GlobalMacroMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.SubmodulesLoaded = new SmallVector<Module /*P*/>(2, (Module /*P*/)null);
    this.GlobalSubmoduleMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.HiddenNamesMap = new DenseMapPtrType<Module /*P*/ , SmallVector<Decl /*P*/>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<Decl /*P*/>(2));
    this.UnresolvedModuleRefs = new SmallVector<UnresolvedModuleRef>(2, new UnresolvedModuleRef());
    this.SelectorsLoaded = new SmallVector<Selector>(16, new Selector());
    this.GlobalSelectorMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.SelectorGeneration = new DenseMapTypeUInt<Selector>(org.clang.basic.llvm.DenseMapInfoSelector.$Info(), 0);
    this.SelectorOutOfDate = new DenseMapTypeBool<Selector>(org.clang.basic.llvm.DenseMapInfoSelector.$Info(), false);
    this.PendingMacroIDs = new MapVectorPtrType<IdentifierInfo /*P*/ , SmallVector<PendingMacroInfo> >(IdentifierInfo.DMI$IdentifierInfoPtr, new SmallVector<PendingMacroInfo>(2, new PendingMacroInfo()));
    this.GlobalPreprocessedEntityMap = new ContinuousRangeMapUIntPtr<ModuleFile /*P*/ >(4);
    this.EagerlyDeserializedDecls = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.TentativeDefinitions = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.VTableUses = new SmallVectorULong(64, (long/*uint64_t*/)0);
    this.PendingInstantiations = new SmallVectorULong(64, (long/*uint64_t*/)0);
    this.UnusedFileScopedDecls = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.DelegatingCtorDecls = new SmallVectorULong(4, (long/*uint64_t*/)0);
    this.ReferencedSelectorsData = new SmallVectorULong(64, (long/*uint64_t*/)0);
    this.WeakUndeclaredIdentifiers = new SmallVectorULong(64, (long/*uint64_t*/)0);
    this.ExtVectorDecls = new SmallVectorULong(4, (long/*uint64_t*/)0);
    this.UnusedLocalTypedefNameCandidates = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.SemaDeclRefs = new SmallVectorULong(4, (long/*uint64_t*/)0);
    this.SpecialTypes = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.CUDASpecialDeclRefs = new SmallVectorULong(2, (long/*uint64_t*/)0);
    this.FPPragmaOptions = new SmallVectorULong(1, (long/*uint64_t*/)0);
    this.OptimizeOffPragmaLocation = new SourceLocation();
    this.PragmaMSStructState = -1;
    this.PragmaMSPointersToMembersState = -1;
    this.PointersToMembersPragmaLocation = new SourceLocation();
    this.OpenCLExtensions = new SmallVectorULong(1, (long/*uint64_t*/)0);
    this.KnownNamespaces = new SmallVectorULong(4, (long/*uint64_t*/)0);
    this.UndefinedButUsed = new SmallVectorULong(8, (long/*uint64_t*/)0);
    this.DelayedDeleteExprs = new SmallVectorULong(8, (long/*uint64_t*/)0);
    this.LateParsedTemplates = new SmallVectorULong(1, (long/*uint64_t*/)0);
    this.ImportedModules = new SmallVector<ImportedSubmodule>(2, new ImportedSubmodule());
    this.CurrentDir = new std.string();
    this.isysroot = isysroot.$string();
    this.DisableValidation = DisableValidation;
    this.AllowASTWithCompilerErrors = AllowASTWithCompilerErrors;
    this.AllowConfigurationMismatch = AllowConfigurationMismatch;
    this.ValidateSystemInputs = ValidateSystemInputs;
    this.UseGlobalIndex = UseGlobalIndex;
    this.TriedLoadingGlobalIndex = false;
    this.ProcessingUpdateRecords = false;
    this.SwitchCaseStmts = new DenseMapUIntType<SwitchCase /*P*/ >(DenseMapInfoUInt.$Info(), (SwitchCase /*P*/ )null);
    this.CurrSwitchCaseStmts = $AddrOf(SwitchCaseStmts);
    this.NumSLocEntriesRead = 0;
    this.TotalNumSLocEntries = 0;
    this.NumStatementsRead = 0;
    this.TotalNumStatements = 0;
    this.NumMacrosRead = 0;
    this.TotalNumMacros = 0;
    this.NumIdentifierLookups = 0;
    this.NumIdentifierLookupHits = 0;
    this.NumSelectorsRead = 0;
    this.NumMethodPoolEntriesRead = 0;
    this.NumMethodPoolLookups = 0;
    this.NumMethodPoolHits = 0;
    this.NumMethodPoolTableLookups = 0;
    this.NumMethodPoolTableHits = 0;
    this.TotalNumMethodPoolEntries = 0;
    this.NumLexicalDeclContextsRead = 0;
    this.TotalLexicalDeclContexts = 0;
    this.NumVisibleDeclContextsRead = 0;
    this.TotalVisibleDeclContexts = 0;
    this.TotalModulesSizeInBits = $int2ulong(0);
    this.NumCurrentElementsDeserializing = 0;
    this.PassingDeclsToConsumer = false;
    this.PendingIdentifierInfos = new MapVectorPtrType<IdentifierInfo /*P*/ , SmallVectorUInt>(IdentifierInfo.DMI$IdentifierInfoPtr, new SmallVectorUInt(4));
    this.PendingFakeLookupResults = new SmallMapVectorPtrType<IdentifierInfo /*P*/ , SmallVector<NamedDecl /*P*/ >>(16, IdentifierInfo.DMI$IdentifierInfoPtr, new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/)null));
    this.IdentifierGeneration = new DenseMapTypeUInt<IdentifierInfo /*P*/>(IdentifierInfo.DMI$IdentifierInfoPtr, 0);
    this.InterestingDecls = new std.deque<Decl /*P*/ >(true);
    this.PendingDeclChains = new SmallVector<std.pairPtrULong<Decl /*P*/ >>(16, new std.pairPtrULong<Decl /*P*/ >());
    this.PendingIncompleteDeclChains = new SmallVector<Decl /*P*/>(16, null);
    this.PendingDeclContextInfos = new std.deque<PendingDeclContextInfo>(false);
    this.PendingOdrMergeChecks = new SmallVector<NamedDecl /*P*/ >(16, (NamedDecl /*P*/ )null);
    this.PendingOdrMergeFailures = new SmallDenseMap<CXXRecordDecl /*P*/ , TinyPtrVector<CXXRecordDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(), 2, new TinyPtrVector<CXXRecordDecl /*P*/ >());
    this.DiagnosedOdrMergeFailures = new SmallPtrSet<DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    this.CategoriesDeserialized = new SmallPtrSet<ObjCCategoryDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    this.ObjCClassesLoaded = new SmallVector<ObjCInterfaceDecl /*P*/ >(16, (ObjCInterfaceDecl /*P*/ )null);
    this.KeyDecls = new DenseMap<Decl /*P*/ , SmallVectorUInt>(DenseMapInfo$LikePtr.$Info(), new SmallVectorUInt(2,0));
    this.MergedDeclContexts = new DenseMap<DeclContext /*P*/ , DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), (DeclContext /*P*/ )null);
    this.EnumDefinitions = new DenseMap<EnumDecl /*P*/ , EnumDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (EnumDecl /*P*/ )null);
    this.StmtStack = new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    this._ReadingKind = ReadingKind.Read_None;
    this.SuggestedPredefines = new std.string();
    this.PreloadedDeclIDs = new SmallVectorULong(16, (long/*uint64_t*/)0);
    this.CommentsCursors = new SmallVector<std.pairTypePtr<BitstreamCursor, ModuleFile /*P*/ >>(8, new std.pairTypePtr<BitstreamCursor, ModuleFile /*P*/ >(new BitstreamCursor(), null));
    //END JInit
    SourceMgr.setExternalSLocEntrySource(this);
    
    for (final /*const*/ IntrusiveRefCntPtr<ModuleFileExtension> /*&*/ Ext : Extensions) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        std.string BlockName = $c$.clean(new std.string(JD$Move.INSTANCE, $c$.track(Ext.$arrow().getExtensionMetadata()).BlockName));
        StringMapIterator<IntrusiveRefCntPtr<ModuleFileExtension> > Known = ModuleFileExtensions.find(new StringRef(BlockName));
        if (Known.$noteq(ModuleFileExtensions.end())) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.warn_duplicate_module_file_extension)), 
              new StringRef(BlockName)));
          continue;
        }
        
        $c$.clean(ModuleFileExtensions.insert($c$.track(/*{ */new std.pairTypeType<StringRef, IntrusiveRefCntPtr<ModuleFileExtension>>(JD$T$RR_T1$C$R.INSTANCE, new StringRef(/*Fwd*/BlockName), new IntrusiveRefCntPtr<ModuleFileExtension>(Ext))/* }*/)));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::~ASTReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8738,
   FQN="clang::ASTReader::~ASTReader", NM="_ZN5clang9ASTReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReaderD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (OwnsDeserializationListener) {
      if (DeserializationListener != null) { DeserializationListener.$destroy();};
    }
    //START JDestroy
    CommentsCursors.$destroy();
    PreloadedDeclIDs.$destroy();
    SuggestedPredefines.$destroy();
    StmtStack.$destroy();
    EnumDefinitions.$destroy();
    MergedDeclContexts.$destroy();
    KeyDecls.$destroy();
    ObjCClassesLoaded.$destroy();
    CategoriesDeserialized.$destroy();
    DiagnosedOdrMergeFailures.$destroy();
    PendingOdrMergeFailures.$destroy();
    PendingOdrMergeChecks.$destroy();
    PendingDeclContextInfos.$destroy();
    PendingIncompleteDeclChains.$destroy();
    PendingDeclChains.$destroy();
    InterestingDecls.$destroy();
    IdentifierGeneration.$destroy();
    PendingFakeLookupResults.$destroy();
    PendingIdentifierInfos.$destroy();
    SwitchCaseStmts.$destroy();
    isysroot.$destroy();
    CurrentDir.$destroy();
    ImportedModules.$destroy();
    LateParsedTemplates.$destroy();
    DelayedDeleteExprs.$destroy();
    UndefinedButUsed.$destroy();
    KnownNamespaces.$destroy();
    OpenCLExtensions.$destroy();
    FPPragmaOptions.$destroy();
    CUDASpecialDeclRefs.$destroy();
    SpecialTypes.$destroy();
    SemaDeclRefs.$destroy();
    UnusedLocalTypedefNameCandidates.$destroy();
    ExtVectorDecls.$destroy();
    WeakUndeclaredIdentifiers.$destroy();
    ReferencedSelectorsData.$destroy();
    DelegatingCtorDecls.$destroy();
    UnusedFileScopedDecls.$destroy();
    PendingInstantiations.$destroy();
    VTableUses.$destroy();
    TentativeDefinitions.$destroy();
    EagerlyDeserializedDecls.$destroy();
    GlobalPreprocessedEntityMap.$destroy();
    PendingMacroIDs.$destroy();
    SelectorOutOfDate.$destroy();
    SelectorGeneration.$destroy();
    GlobalSelectorMap.$destroy();
    SelectorsLoaded.$destroy();
    UnresolvedModuleRefs.$destroy();
    HiddenNamesMap.$destroy();
    GlobalSubmoduleMap.$destroy();
    SubmodulesLoaded.$destroy();
    GlobalMacroMap.$destroy();
    LoadedUndefs.$destroy();
    MacrosLoaded.$destroy();
    GlobalIdentifierMap.$destroy();
    IdentifiersLoaded.$destroy();
    PendingMergedDefinitionsToDeduplicate.$destroy();
    PendingBodies.$destroy();
    PendingDefinitions.$destroy();
    PendingVisibleUpdates.$destroy();
    Lookups.$destroy();
    TULexicalDecls.$destroy();
    LexicalDecls.$destroy();
    FileDeclIDs.$destroy();
    AnonymousDeclarationsForMerging.$destroy();
    ImportedTypedefNamesForLinkage.$destroy();
    PendingExceptionSpecUpdates.$destroy();
    PendingFakeDefinitionData.$destroy();
    PendingUpdateRecords.$destroy();
    DeclUpdateOffsets.$destroy();
    GlobalDeclMap.$destroy();
    DeclsLoaded.$destroy();
    GlobalTypeMap.$destroy();
    TypesLoaded.$destroy();
    GlobalSLocOffsetMap.$destroy();
    GlobalSLocEntryMap.$destroy();
    GlobalBitOffsetsMap.$destroy();
    GlobalIndex.$destroy();
    ReadTimer.$destroy();
    ModuleFileExtensions.$destroy();
    DummyIdResolver.$destroy();
    ModuleMgr.$destroy();
    Listener.$destroy();
    ExternalPreprocessorSource.super.$destroy$ExternalPreprocessorSource();
    ExternalPreprocessingRecordSource.super.$destroy$ExternalPreprocessingRecordSource();
    ExternalHeaderFileInfoSource.super.$destroy$ExternalHeaderFileInfoSource();
    super.$destroy();
    IdentifierInfoLookup.super.$destroy$IdentifierInfoLookup();
    ExternalSLocEntrySource.super.$destroy$ExternalSLocEntrySource();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1349,
   FQN="clang::ASTReader::getSourceManager", NM="_ZNK5clang9ASTReader16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() /*const*/ {
    return SourceMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1350,
   FQN="clang::ASTReader::getFileManager", NM="_ZNK5clang9ASTReader14getFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader14getFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getFileManager() /*const*/ {
    return FileMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1351,
   FQN="clang::ASTReader::getDiags", NM="_ZNK5clang9ASTReader8getDiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader8getDiagsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiags() /*const*/ {
    return Diags;
  }

  
  /// \brief Flags that indicate what kind of AST loading failures the client
  /// of the AST reader can directly handle.
  ///
  /// When a client states that it can handle a particular kind of failure,
  /// the AST reader will not emit errors when producing that kind of failure.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::LoadFailureCapabilities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1358,
   FQN="clang::ASTReader::LoadFailureCapabilities", NM="_ZN5clang9ASTReader23LoadFailureCapabilitiesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23LoadFailureCapabilitiesE")
  //</editor-fold>
  public static final class/*enum*/ LoadFailureCapabilities {
    /// \brief The client can't handle any AST loading failures.
    public static final /*uint*/int ARR_None = 0;
    /// \brief The client can handle an AST file that cannot load because it
    /// is missing.
    public static final /*uint*/int ARR_Missing = 0x1;
    /// \brief The client can handle an AST file that cannot load because it
    /// is out-of-date relative to its input files.
    public static final /*uint*/int ARR_OutOfDate = 0x2;
    /// \brief The client can handle an AST file that cannot load because it
    /// was built with a different version of Clang.
    public static final /*uint*/int ARR_VersionMismatch = 0x4;
    /// \brief The client can handle an AST file that cannot load because it's
    /// compiled configuration doesn't match that of the context it was
    /// loaded into.
    public static final /*uint*/int ARR_ConfigurationMismatch = 0x8;
  };
  
  /// \brief Load the AST file designated by the given file name.
  ///
  /// \param FileName The name of the AST file to load.
  ///
  /// \param Type The kind of AST being loaded, e.g., PCH, module, main file,
  /// or preamble.
  ///
  /// \param ImportLoc the location where the module file will be considered as
  /// imported from. For non-module AST types it should be invalid.
  ///
  /// \param ClientLoadCapabilities The set of client load-failure
  /// capabilities, represented as a bitset of the enumerators of
  /// LoadFailureCapabilities.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadAST">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3474,
   FQN="clang::ASTReader::ReadAST", NM="_ZN5clang9ASTReader7ReadASTEN4llvm9StringRefENS_13serialization10ModuleKindENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader7ReadASTEN4llvm9StringRefENS_13serialization10ModuleKindENS_14SourceLocationEj")
  //</editor-fold>
  public ASTReader.ASTReadResult ReadAST(StringRef FileName, 
         ModuleKind Type, 
         SourceLocation ImportLoc, 
         /*uint*/int ClientLoadCapabilities) {
    SaveAndRestore<SourceLocation> SetCurImportLocRAII = null;
    ExternalASTSource.Deserializing AnASTFile = null;
    try {
      SetCurImportLocRAII/*J*/= new SaveAndRestore<SourceLocation>(CurrentImportLoc_ref, ImportLoc, false);
      
      // Defer any pending actions until we get to the end of reading the AST file.
      AnASTFile/*J*/= new ExternalASTSource.Deserializing(this);
      
      // Bump the generation number.
      /*uint*/int PreviousGeneration = incrementGeneration(Context);
      
      /*uint*/int NumModules = ModuleMgr.size();
      SmallVector<ImportedModule> Loaded/*J*/= new SmallVector<ImportedModule>(4, new ImportedModule());
      {
        ASTReadResult ReadResult = ReadASTCore(new StringRef(FileName), Type, new SourceLocation(ImportLoc), 
            /*ImportedBy=*/ (ModuleFile /*P*/ )null, Loaded, 
            0, 0, 0, 
            ClientLoadCapabilities);
        switch (ReadResult) {
         case Failure:
         case Missing:
         case OutOfDate:
         case VersionMismatch:
         case ConfigurationMismatch:
         case HadErrors:
          {
            SmallPtrSet<ModuleFile /*P*/> LoadedSet/*J*/= new SmallPtrSet<ModuleFile /*P*/>(DenseMapInfo$LikePtr.$Info(), 4);
            for (final /*const*/ ImportedModule /*&*/ IM : Loaded)  {
              LoadedSet.insert(IM.Mod);
            }
            
            ModuleMgr.removeModules(ModuleMgr.begin().$add(NumModules), ModuleMgr.end(), 
                LoadedSet, 
                Context.getLangOpts().Modules ? $AddrOf(PP.getHeaderSearchInfo().getModuleMap()) : (ModuleMap /*P*/ )null);
            
            // If we find that any modules are unusable, the global index is going
            // to be out-of-date. Just remove it.
            GlobalIndex.reset();
            ModuleMgr.setGlobalIndex((GlobalModuleIndex /*P*/ )null);
            return ReadResult;
          }
         case Success:
          break;
        }
      }
      
      // Here comes stuff that we only do once the entire chain is loaded.
      
      // Load the AST blocks of all of the modules that we loaded.
      for (type$ptr<ImportedModule> M = $tryClone(Loaded.begin()), 
          /*P*/ MEnd = $tryClone(Loaded.end());
           $noteq_ptr(M, MEnd); M.$preInc()) {
        final ModuleFile /*&*/ F = $Deref(M./*->*/$star().Mod);
        {
          
          // Read the AST block.
          ASTReadResult Result = ReadASTBlock(F, ClientLoadCapabilities);
          if ((Result.getValue() != 0)) {
            return Result;
          }
        }
        
        // Read the extension blocks.
        while (!SkipCursorToBlock(F.Stream, BlockIDs.EXTENSION_BLOCK_ID)) {
          {
            ASTReadResult Result = ReadExtensionBlock(F);
            if ((Result.getValue() != 0)) {
              return Result;
            }
          }
        }
        
        // Once read, set the ModuleFile bit base offset and update the size in 
        // bits of all files we've seen.
        F.GlobalBitOffset = TotalModulesSizeInBits;
        TotalModulesSizeInBits += F.SizeInBits;
        GlobalBitOffsetsMap.insert(std.make_pair_ullong_Ptr(F.GlobalBitOffset, $AddrOf(F)));
        
        // Preload SLocEntries.
        for (/*uint*/int I = 0, N = F.PreloadSLocEntries.size(); I != N; ++I) {
          int Index = ((int)($ullong2int(F.PreloadSLocEntries.$at(I) - $int2ullong(1)))) + F.SLocEntryBaseID;
          // Load it through the SourceManager and don't call ReadSLocEntry()
          // directly because the entry may have already been loaded in which case
          // calling ReadSLocEntry() directly would trigger an assertion in
          // SourceManager.
          SourceMgr.getLoadedSLocEntryByID(Index);
        }
        
        // Preload all the pending interesting identifiers by marking them out of
        // date.
        for (/*uint*/int Offset : F.PreloadIdentifierOffsets) {
          final /*const*/char$ptr/*uchar P*/ Data$Base = F.IdentifierTableData.$add(Offset);
          int Data = 0;
          ASTIdentifierLookupTrait Trait/*J*/= new ASTIdentifierLookupTrait(/*Deref*/this, F);
          /*std.pair<uint, uint>*/long KeyDataLen = Trait.ReadKeyDataLength(Data$Base, Data);
                                        /*shift index after read*/Data += Trait.getReadKeyDataLengthBytes();
          final int keyLen = $first_uint(KeyDataLen);
//          final int dataLen = $second_uint(KeyDataLen);
        
          StringRef Key = Trait.ReadKey(Data$Base, Data, keyLen);
                            // it looks ReadKey doesn't move input pointer! Data += keyLen
          final IdentifierInfo /*&*/ II = PP.getIdentifierTable().getOwn(/*NO_COPY*/Key);
          II.setOutOfDate(true);
          
          // Mark this identifier as being from an AST file so that we can track
          // whether we need to serialize it.
          markIdentifierFromAST(/*Deref*/this, II);
          
          // Associate the ID with the identifier so that the writer can reuse it.
          /*uint32_t*/int ID = Trait.ReadIdentifierID(Data$Base, (Data + keyLen));
          SetIdentifierInfo(ID, $AddrOf(II));
        }
      }
      
      // Setup the import locations and notify the module manager that we've
      // committed to these module files.
      for (type$ptr<ImportedModule> M = $tryClone(Loaded.begin()), 
          /*P*/ MEnd = $tryClone(Loaded.end());
           $noteq_ptr(M, MEnd); M.$preInc()) {
        final ModuleFile /*&*/ F = $Deref(M./*->*/$star().Mod);
        
        ModuleMgr.moduleFileAccepted($AddrOf(F));
        
        // Set the import location.
        F.DirectImportLoc.$assign(ImportLoc);
        // FIXME: We assume that locations from PCH / preamble do not need
        // any translation.
        if (!(M./*->*/$star().ImportedBy != null)) {
          F.ImportLoc.$assign(M./*->*/$star().ImportLoc);
        } else {
          F.ImportLoc.$assignMove(TranslateSourceLocation($Deref(M./*->*/$star().ImportedBy), new SourceLocation(M./*->*/$star().ImportLoc)));
        }
      }
      if (!Context.getLangOpts().CPlusPlus
         || (Type != ModuleKind.MK_ImplicitModule && Type != ModuleKind.MK_ExplicitModule)) {
        // Mark all of the identifiers in the identifier table as being out of date,
        // so that various accessors know to check the loaded modules when the
        // identifier is used.
        //
        // For C++ modules, we don't need information on many identifiers (just
        // those that provide macros or are poisoned), so we mark all of
        // the interesting ones via PreloadIdentifierOffsets.
        for (StringMapIteratorIdentifierInfo Id = PP.getIdentifierTable().begin(), 
            IdEnd = PP.getIdentifierTable().end();
             Id.$noteq(IdEnd); Id.$preInc())  {
          Id.$arrow().$second().setOutOfDate(true);
        }
      }
      // Mark selectors as out of date.
      DenseMapIteratorTypeUInt<Selector> begin = SelectorGeneration.begin();
      for (pairTypeUInt<Selector> Sel : SelectorGeneration)  {
        SelectorOutOfDate.$set(Sel.first, true);
      }
      
      // Resolve any unresolved module exports.
      for (/*uint*/int I = 0, N = UnresolvedModuleRefs.size(); I != N; ++I) {
        final UnresolvedModuleRef /*&*/ Unresolved = UnresolvedModuleRefs.$at(I);
        /*uint32_t*/int GlobalID = getGlobalSubmoduleID($Deref(Unresolved.File), Unresolved.ID);
        Module /*P*/ ResolvedMod = getSubmodule(GlobalID);
        switch (Unresolved.Kind) {
         case Conflict:
          if ((ResolvedMod != null)) {
            Module.Conflict Conflict/*J*/= new Module.Conflict();
            Conflict.Other = ResolvedMod;
            Conflict.Message.$assignMove(Unresolved.String.str());
            Unresolved.Mod.Conflicts.push_back_T$C$R(Conflict);
          }
          continue;
         case Import:
          if ((ResolvedMod != null)) {
            Unresolved.Mod.Imports.insert(ResolvedMod);
          }
          continue;
         case Export:
          if ((ResolvedMod != null) || Unresolved.IsWildcard) {
            Unresolved.Mod.Exports.push_back(new PointerInt2Pair</*const*/ Module/*P*/>(ResolvedMod, Unresolved.IsWildcard));
          }
          continue;
        }
      }
      UnresolvedModuleRefs.clear();
      
      // FIXME: How do we load the 'use'd modules? They may not be submodules.
      // Might be unnecessary as use declarations are only used to build the
      // module itself.
      InitializeContext();
      if ((SemaObj != null)) {
        UpdateSema();
      }
      if ((DeserializationListener != null)) {
        DeserializationListener.ReaderInitialized(this);
      }
      
      final ModuleFile /*&*/ PrimaryModule = ModuleMgr.getPrimaryModule();
      if (PrimaryModule.OriginalSourceFileID.isValid()) {
        PrimaryModule.OriginalSourceFileID.$assignMove(
            FileID.get(PrimaryModule.SLocEntryBaseID
                   + PrimaryModule.OriginalSourceFileID.getOpaqueValue() - 1)
        );
        
        // If this AST file is a precompiled preamble, then set the
        // preamble file ID of the source manager to the file source file
        // from which the preamble was built.
        if (Type == ModuleKind.MK_Preamble) {
          SourceMgr.setPreambleFileID(/*NO_COPY*/PrimaryModule.OriginalSourceFileID);
        } else if (Type == ModuleKind.MK_MainFile) {
          SourceMgr.setMainFileID(/*NO_COPY*/PrimaryModule.OriginalSourceFileID);
        }
      }
      
      // For any Objective-C class definitions we have already loaded, make sure
      // that we load any additional categories.
      for (/*uint*/int I = 0, N = ObjCClassesLoaded.size(); I != N; ++I) {
        loadObjCCategories(ObjCClassesLoaded.$at(I).getGlobalID(), 
            ObjCClassesLoaded.$at(I), 
            PreviousGeneration);
      }
      if (PP.getHeaderSearchInfo().
          getHeaderSearchOpts().
          ModulesValidateOncePerBuildSession) {
        // Now we are certain that the module and all modules it depends on are
        // up to date.  Create or update timestamp files for modules that are
        // located in the module cache (not for PCH files that could be anywhere
        // in the filesystem).
        for (/*uint*/int I = 0, N = Loaded.size(); I != N; ++I) {
          final ImportedModule /*&*/ M = Loaded.$at(I);
          if (M.Mod.Kind == ModuleKind.MK_ImplicitModule) {
            updateModuleTimestamp($Deref(M.Mod));
          }
        }
      }
      
      return ASTReadResult.Success;
    } finally {
      if (AnASTFile != null) { AnASTFile.$destroy(); }
      if (SetCurImportLocRAII != null) { SetCurImportLocRAII.$destroy(); }
    }
  }

  
  /// \brief Make the entities in the given module and any of its (non-explicit)
  /// submodules visible to name lookup.
  ///
  /// \param Mod The module whose names should be made visible.
  ///
  /// \param NameVisibility The level of visibility to give the names in the
  /// module.  Visibility can only be increased over time.
  ///
  /// \param ImportLoc The location at which the import occurs.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::makeModuleVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3361,
   FQN="clang::ASTReader::makeModuleVisible", NM="_ZN5clang9ASTReader17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE")
  //</editor-fold>
  public void makeModuleVisible(Module /*P*/ Mod, 
                   Module.NameVisibilityKind NameVisibility, 
                   SourceLocation ImportLoc) {
    SmallPtrSet<Module /*P*/ > Visited/*J*/= new SmallPtrSet<Module /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    SmallVector<Module /*P*/> Stack/*J*/= new SmallVector<Module /*P*/>(4, (Module /*P*/)null);
    Stack.push_back(Mod);
    while (!Stack.empty()) {
      Mod = Stack.pop_back_val();
      if (NameVisibility.getValue() <= Mod.NameVisibility.getValue()) {
        // This module already has this level of visibility (or greater), so
        // there is nothing more to do.
        continue;
      }
      if (!Mod.isAvailable()) {
        // Modules that aren't available cannot be made visible.
        continue;
      }
      
      // Update the module's name visibility.
      Mod.NameVisibility = NameVisibility;
      
      // If we've already deserialized any names from this module,
      // mark them as visible.
      DenseMapIteratorPtrType<Module /*P*/ , SmallVector<Decl /*P*/>> Hidden = HiddenNamesMap.find(Mod);
      if (Hidden.$noteq(/*NO_ITER_COPY*/HiddenNamesMap.end())) {
        std.pairPtrType<Module /*P*/ , SmallVector<Decl /*P*/>> HiddenNames = null;
        try {
          HiddenNames = new std.pairPtrType<Module /*P*/ , SmallVector<Decl /*P*/>>(JD$Move.INSTANCE, std.move(Hidden.$star()));
          HiddenNamesMap.erase(new DenseMapIteratorPtrType<Module /*P*/ , SmallVector<Decl /*P*/>>(Hidden));
          makeNamesVisible(HiddenNames.second, HiddenNames.first);
          assert (HiddenNamesMap.find(Mod).$eq(/*NO_ITER_COPY*/HiddenNamesMap.end())) : "making names visible added hidden names";
        } finally {
          if (HiddenNames != null) { HiddenNames.$destroy(); }
        }
      }
      
      // Push any exported modules onto the stack to be marked as visible.
      SmallVector<Module /*P*/> Exports/*J*/= new SmallVector<Module /*P*/>(16, (Module /*P*/)null);
      Mod.getExportedModules(Exports);
      for (type$ptr<Module /*P*/ /*P*/> I = $tryClone(Exports.begin()), /*P*/ E = $tryClone(Exports.end()); $noteq_ptr(I, E); I.$preInc()) {
        Module /*P*/ Exported = I.$star();
        if (Visited.insert(Exported).second) {
          Stack.push_back(Exported);
        }
      }
    }
  }

  
  /// \brief Make the names within this set of hidden names visible.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::makeNamesVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3347,
   FQN="clang::ASTReader::makeNamesVisible", NM="_ZN5clang9ASTReader16makeNamesVisibleERKN4llvm11SmallVectorIPNS_4DeclELj2EEEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16makeNamesVisibleERKN4llvm11SmallVectorIPNS_4DeclELj2EEEPNS_6ModuleE")
  //</editor-fold>
  public void makeNamesVisible(final /*const*/SmallVector<Decl /*P*/> /*&*/ Names, Module /*P*/ Owner) {
    assert (Owner.NameVisibility != Module.NameVisibilityKind.Hidden) : "nothing to make visible?";
    for (Decl /*P*/ D : Names) {
      boolean wasHidden = D.Hidden;
      D.Hidden = false;
      if (wasHidden && (SemaObj != null)) {
        {
          ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(D);
          if ((Method != null)) {
            moveMethodToBackOfGlobalList($Deref(SemaObj), Method);
          }
        }
      }
    }
  }

  
  /// \brief Take the AST callbacks listener.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::takeListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1410,
   FQN="clang::ASTReader::takeListener", NM="_ZN5clang9ASTReader12takeListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12takeListenerEv")
  //</editor-fold>
  public std.unique_ptr<ASTReaderListener> takeListener() {
    return new std.unique_ptr<ASTReaderListener>(JD$Move.INSTANCE, std.move(Listener));
  }

  
  /// \brief Set the AST callbacks listener.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::setListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1415,
   FQN="clang::ASTReader::setListener", NM="_ZN5clang9ASTReader11setListenerESt10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader11setListenerESt10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS2_EE")
  //</editor-fold>
  public void setListener(std.unique_ptr<ASTReaderListener> Listener) {
    this.Listener.$assignMove(std.move(Listener));
  }

  
  /// \brief Add an AST callback listener.
  ///
  /// Takes ownership of \p L.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::addListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1422,
   FQN="clang::ASTReader::addListener", NM="_ZN5clang9ASTReader11addListenerESt10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader11addListenerESt10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS2_EE")
  //</editor-fold>
  public void addListener(std.unique_ptr<ASTReaderListener> L) {
    if (Listener.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(L.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new ChainedASTReaderListener(std.move(L), 
                std.move(Listener))))));
      } finally {
        $c$.$destroy();
      }
    }
    Listener.$assignMove(std.move(L));
  }

  
  /// RAII object to temporarily add an AST callback listener.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ListenerScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1430,
   FQN="clang::ASTReader::ListenerScope", NM="_ZN5clang9ASTReader13ListenerScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13ListenerScopeE")
  //</editor-fold>
  public static class ListenerScope implements Destructors.ClassWithDestructor {
    private final ASTReader /*&*/ Reader;
    private boolean Chained;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ListenerScope::ListenerScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1435,
     FQN="clang::ASTReader::ListenerScope::ListenerScope", NM="_ZN5clang9ASTReader13ListenerScopeC1ERS0_St10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS4_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13ListenerScopeC1ERS0_St10unique_ptrINS_17ASTReaderListenerESt14default_deleteIS4_EE")
    //</editor-fold>
    public ListenerScope(final ASTReader /*&*/ Reader, std.unique_ptr<ASTReaderListener> L) {
      // : Reader(Reader), Chained(false) 
      //START JInit
      this./*&*/Reader=/*&*/Reader;
      this.Chained = false;
      //END JInit
      unique_ptr<ASTReaderListener> Old = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Old = Reader.takeListener();
        if (Old.$bool()) {
          Chained = true;
          $c$.clean(L.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new ChainedASTReaderListener(std.move(L), 
                  std.move(Old))))));
        }
        Reader.setListener($c$.track(new std.unique_ptr<ASTReaderListener>(JD$Move.INSTANCE, std.move(L)))); $c$.clean();
      } finally {
        if (Old != null) { Old.$destroy(); }
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ListenerScope::~ListenerScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1445,
     FQN="clang::ASTReader::ListenerScope::~ListenerScope", NM="_ZN5clang9ASTReader13ListenerScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13ListenerScopeD0Ev")
    //</editor-fold>
    public void $destroy() {
      unique_ptr<ASTReaderListener> New = null;
      try {
        New = Reader.takeListener();
        if (Chained) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Reader.setListener($c$.track(((/*static_cast*/ChainedASTReaderListener /*P*/ )(New.get())).
                    takeSecond())); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (New != null) { New.$destroy(); }
      }
    }

    
    @Override public String toString() {
      return "" + "Reader=" + Reader // NOI18N
                + ", Chained=" + Chained; // NOI18N
    }
  };
  
  /// \brief Set the AST deserialization listener.
  
  //===----------------------------------------------------------------------===//
  // AST reader implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::setDeserializationListener">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 659,
   FQN="clang::ASTReader::setDeserializationListener", NM="_ZN5clang9ASTReader26setDeserializationListenerEPNS_26ASTDeserializationListenerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader26setDeserializationListenerEPNS_26ASTDeserializationListenerEb")
  //</editor-fold>
  public void setDeserializationListener(ASTDeserializationListenerImplementation /*P*/ Listener) {
    setDeserializationListener(Listener, 
                            false);
  }
  public void setDeserializationListener(ASTDeserializationListenerImplementation /*P*/ Listener, 
                            boolean TakeOwnership/*= false*/) {
    DeserializationListener = (ASTDeserializationListener)Listener;
    OwnsDeserializationListener = TakeOwnership;
  }

  
  /// \brief Determine whether this AST reader has a global index.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::hasGlobalIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1458,
   FQN="clang::ASTReader::hasGlobalIndex", NM="_ZNK5clang9ASTReader14hasGlobalIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader14hasGlobalIndexEv")
  //</editor-fold>
  public boolean hasGlobalIndex() /*const*/ {
    return (boolean)GlobalIndex.$bool();
  }

  
  /// \brief Return global module index.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1461,
   FQN="clang::ASTReader::getGlobalIndex", NM="_ZN5clang9ASTReader14getGlobalIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14getGlobalIndexEv")
  //</editor-fold>
  public GlobalModuleIndex /*P*/ getGlobalIndex() {
    return GlobalIndex.get();
  }

  
  /// \brief Reset reader for a reload try.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::resetForReload">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1464,
   FQN="clang::ASTReader::resetForReload", NM="_ZN5clang9ASTReader14resetForReloadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14resetForReloadEv")
  //</editor-fold>
  public void resetForReload() {
    TriedLoadingGlobalIndex = false;
  }

  
  /// \brief Attempts to load the global index.
  ///
  /// \returns true if loading the global index has failed for any reason.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::loadGlobalIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3407,
   FQN="clang::ASTReader::loadGlobalIndex", NM="_ZN5clang9ASTReader15loadGlobalIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15loadGlobalIndexEv")
  //</editor-fold>
  public boolean loadGlobalIndex() {
    if (GlobalIndex.$bool()) {
      return false;
    }
    if (TriedLoadingGlobalIndex || !UseGlobalIndex
       || !Context.getLangOpts().Modules) {
      return true;
    }
    
    // Try to load the global index.
    TriedLoadingGlobalIndex = true;
    StringRef ModuleCachePath = getPreprocessor().getHeaderSearchInfo().getModuleCachePath();
    std.pairPtrType<GlobalModuleIndex /*P*/ , GlobalModuleIndex.ErrorCode> Result = GlobalModuleIndex.readIndex(new StringRef(ModuleCachePath));
    if (!(Result.first != null)) {
      return true;
    }
    
    GlobalIndex.reset(Result.first);
    ModuleMgr.setGlobalIndex(GlobalIndex.get());
    return false;
  }

  
  /// \brief Determine whether we tried to load the global index, but failed,
  /// e.g., because it is out-of-date or does not exist.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::isGlobalIndexUnavailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3429,
   FQN="clang::ASTReader::isGlobalIndexUnavailable", NM="_ZNK5clang9ASTReader24isGlobalIndexUnavailableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader24isGlobalIndexUnavailableEv")
  //</editor-fold>
  public boolean isGlobalIndexUnavailable() /*const*/ {
    return Context.getLangOpts().Modules && UseGlobalIndex
       && !hasGlobalIndex() && TriedLoadingGlobalIndex;
  }

  
  /// \brief Initializes the ASTContext
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::InitializeContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3930,
   FQN="clang::ASTReader::InitializeContext", NM="_ZN5clang9ASTReader17InitializeContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17InitializeContextEv")
  //</editor-fold>
  public void InitializeContext() {
    // If there's a listener, notify them that we "read" the translation unit.
    if ((DeserializationListener != null)) {
      DeserializationListener.DeclRead(PredefinedDeclIDs.PREDEF_DECL_TRANSLATION_UNIT_ID, 
          Context.getTranslationUnitDecl());
    }
    
    // FIXME: Find a better way to deal with collisions between these
    // built-in types. Right now, we just ignore the problem.
    
    // Load the special types.
    if ($greatereq_uint(SpecialTypes.size(), NumSpecialTypeIDs)) {
      {
        /*uint*/int String = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_CF_CONSTANT_STRING));
        if ((String != 0)) {
          if (!(Context.CFConstantStringTypeDecl != null)) {
            Context.setCFConstantStringType(GetType(String));
          }
        }
      }
      {
        
        /*uint*/int File = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_FILE));
        if ((File != 0)) {
          QualType FileType = GetType(File);
          if (FileType.isNull()) {
            Error(new StringRef(/*KEEP_STR*/"FILE type is NULL"));
            return;
          }
          if (!(Context.FILEDecl != null)) {
            {
              /*const*/ TypedefType /*P*/ Typedef = FileType.$arrow().getAs$TypedefType();
              if ((Typedef != null)) {
                Context.setFILEDecl(Typedef.getDecl());
              } else {
                /*const*/ TagType /*P*/ Tag = FileType.$arrow().getAs(TagType.class);
                if (!(Tag != null)) {
                  Error(new StringRef(/*KEEP_STR*/"Invalid FILE type in AST file"));
                  return;
                }
                Context.setFILEDecl(Tag.getDecl());
              }
            }
          }
        }
      }
      {
        
        /*uint*/int Jmp_buf = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_JMP_BUF));
        if ((Jmp_buf != 0)) {
          QualType Jmp_bufType = GetType(Jmp_buf);
          if (Jmp_bufType.isNull()) {
            Error(new StringRef(/*KEEP_STR*/"jmp_buf type is NULL"));
            return;
          }
          if (!(Context.jmp_bufDecl != null)) {
            {
              /*const*/ TypedefType /*P*/ Typedef = Jmp_bufType.$arrow().getAs$TypedefType();
              if ((Typedef != null)) {
                Context.setjmp_bufDecl(Typedef.getDecl());
              } else {
                /*const*/ TagType /*P*/ Tag = Jmp_bufType.$arrow().getAs(TagType.class);
                if (!(Tag != null)) {
                  Error(new StringRef(/*KEEP_STR*/"Invalid jmp_buf type in AST file"));
                  return;
                }
                Context.setjmp_bufDecl(Tag.getDecl());
              }
            }
          }
        }
      }
      {
        
        /*uint*/int Sigjmp_buf = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_SIGJMP_BUF));
        if ((Sigjmp_buf != 0)) {
          QualType Sigjmp_bufType = GetType(Sigjmp_buf);
          if (Sigjmp_bufType.isNull()) {
            Error(new StringRef(/*KEEP_STR*/"sigjmp_buf type is NULL"));
            return;
          }
          if (!(Context.sigjmp_bufDecl != null)) {
            {
              /*const*/ TypedefType /*P*/ Typedef = Sigjmp_bufType.$arrow().getAs$TypedefType();
              if ((Typedef != null)) {
                Context.setsigjmp_bufDecl(Typedef.getDecl());
              } else {
                /*const*/ TagType /*P*/ Tag = Sigjmp_bufType.$arrow().getAs(TagType.class);
                assert ((Tag != null)) : "Invalid sigjmp_buf type in AST file";
                Context.setsigjmp_bufDecl(Tag.getDecl());
              }
            }
          }
        }
      }
      {
        
        /*uint*/int ObjCIdRedef = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_OBJC_ID_REDEFINITION));
        if ((ObjCIdRedef != 0)) {
          if (Context.ObjCIdRedefinitionType.isNull()) {
            Context.ObjCIdRedefinitionType.$assignMove(GetType(ObjCIdRedef));
          }
        }
      }
      {
        
        /*uint*/int ObjCClassRedef = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_OBJC_CLASS_REDEFINITION));
        if ((ObjCClassRedef != 0)) {
          if (Context.ObjCClassRedefinitionType.isNull()) {
            Context.ObjCClassRedefinitionType.$assignMove(GetType(ObjCClassRedef));
          }
        }
      }
      {
        
        /*uint*/int ObjCSelRedef = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_OBJC_SEL_REDEFINITION));
        if ((ObjCSelRedef != 0)) {
          if (Context.ObjCSelRedefinitionType.isNull()) {
            Context.ObjCSelRedefinitionType.$assignMove(GetType(ObjCSelRedef));
          }
        }
      }
      {
        
        /*uint*/int Ucontext_t = $ullong2uint(SpecialTypes.$at(/*KEEP_ENUM*/SpecialTypeIDs.SPECIAL_TYPE_UCONTEXT_T));
        if ((Ucontext_t != 0)) {
          QualType Ucontext_tType = GetType(Ucontext_t);
          if (Ucontext_tType.isNull()) {
            Error(new StringRef(/*KEEP_STR*/"ucontext_t type is NULL"));
            return;
          }
          if (!(Context.ucontext_tDecl != null)) {
            {
              /*const*/ TypedefType /*P*/ Typedef = Ucontext_tType.$arrow().getAs$TypedefType();
              if ((Typedef != null)) {
                Context.setucontext_tDecl(Typedef.getDecl());
              } else {
                /*const*/ TagType /*P*/ Tag = Ucontext_tType.$arrow().getAs(TagType.class);
                assert ((Tag != null)) : "Invalid ucontext_t type in AST file";
                Context.setucontext_tDecl(Tag.getDecl());
              }
            }
          }
        }
      }
    }
    
    ReadPragmaDiagnosticMappings(Context.getDiagnostics());
    
    // If there were any CUDA special declarations, deserialize them.
    if (!CUDASpecialDeclRefs.empty()) {
      assert (CUDASpecialDeclRefs.size() == 1) : "More decl refs than expected!";
      Context.setcudaConfigureCallDecl(cast_FunctionDecl(GetDecl($ullong2uint(CUDASpecialDeclRefs.$at(0)))));
    }
    
    // Re-export any modules that were imported by a non-module AST file.
    // FIXME: This does not make macro-only imports visible again.
    for (final ImportedSubmodule /*&*/ Import : ImportedModules) {
      {
        Module /*P*/ Imported = getSubmodule(Import.ID);
        if ((Imported != null)) {
          makeModuleVisible(Imported, Module.NameVisibilityKind.AllVisible, 
              /*ImportLoc=*/ new SourceLocation(Import.ImportLoc));
          if (Import.ImportLoc.isValid()) {
            PP.makeModuleVisible(Imported, /*NO_COPY*/Import.ImportLoc);
          }
          // FIXME: should we tell Sema to make the module visible too?
        }
      }
    }
    ImportedModules.clear();
  }

  
  /// \brief Update the state of Sema after loading some additional modules.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::UpdateSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6936,
   FQN="clang::ASTReader::UpdateSema", NM="_ZN5clang9ASTReader10UpdateSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10UpdateSemaEv")
  //</editor-fold>
  public void UpdateSema() {
    assert ((SemaObj != null)) : "no Sema to update";
    
    // Load the offsets of the declarations that Sema references.
    // They will be lazily deserialized when needed.
    if (!SemaDeclRefs.empty()) {
      assert ($rem_uint(SemaDeclRefs.size(), 2) == 0);
      for (/*uint*/int I = 0; I != SemaDeclRefs.size(); I += 2) {
        if (!SemaObj.StdNamespace.$bool()) {
          SemaObj.StdNamespace.$assign(SemaDeclRefs.$at(I));
        }
        if (!SemaObj.StdBadAlloc.$bool()) {
          SemaObj.StdBadAlloc.$assign(SemaDeclRefs.$at(I + 1));
        }
      }
      SemaDeclRefs.clear();
    }
    
    // Update the state of pragmas. Use the same API as if we had encountered the
    // pragma in the source.
    if (OptimizeOffPragmaLocation.isValid()) {
      SemaObj.ActOnPragmaOptimize(/* IsOn = */ false, new SourceLocation(OptimizeOffPragmaLocation));
    }
    if (PragmaMSStructState != -1) {
      SemaObj.ActOnPragmaMSStruct(PragmaMSStructKind.valueOf(PragmaMSStructState));
    }
    if (PointersToMembersPragmaLocation.isValid()) {
      SemaObj.ActOnPragmaMSPointersToMembers(LangOptions.PragmaMSPointersToMembersKind.valueOf(PragmaMSPointersToMembersState), 
          new SourceLocation(PointersToMembersPragmaLocation));
    }
  }

  
  /// \brief Add in-memory (virtual file) buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::addInMemoryBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1482,
   FQN="clang::ASTReader::addInMemoryBuffer", NM="_ZN5clang9ASTReader17addInMemoryBufferERN4llvm9StringRefESt10unique_ptrINS1_12MemoryBufferESt14default_deleteIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17addInMemoryBufferERN4llvm9StringRefESt10unique_ptrINS1_12MemoryBufferESt14default_deleteIS5_EE")
  //</editor-fold>
  public void addInMemoryBuffer(final StringRef /*&*/ FileName, 
                   std.unique_ptr<MemoryBuffer> Buffer) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ModuleMgr.addInMemoryBuffer(new StringRef(FileName), $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Finalizes the AST reader's state before writing an AST file to
  /// disk.
  ///
  /// This operation may undo temporary state in the AST that should not be
  /// emitted.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::finalizeForWriting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4066,
   FQN="clang::ASTReader::finalizeForWriting", NM="_ZN5clang9ASTReader18finalizeForWritingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18finalizeForWritingEv")
  //</editor-fold>
  public void finalizeForWriting() {
    // Nothing to do for now.
  }

  
  /// \brief Retrieve the module manager.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModuleManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1495,
   FQN="clang::ASTReader::getModuleManager", NM="_ZN5clang9ASTReader16getModuleManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16getModuleManagerEv")
  //</editor-fold>
  public ModuleManager /*&*/ getModuleManager() {
    return ModuleMgr;
  }

  
  /// \brief Retrieve the preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1498,
   FQN="clang::ASTReader::getPreprocessor", NM="_ZNK5clang9ASTReader15getPreprocessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader15getPreprocessorEv")
  //</editor-fold>
  public Preprocessor /*&*/ getPreprocessor() /*const*/ {
    return PP;
  }

  
  /// \brief Retrieve the name of the original source file name for the primary
  /// module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getOriginalSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1502,
   FQN="clang::ASTReader::getOriginalSourceFile", NM="_ZN5clang9ASTReader21getOriginalSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader21getOriginalSourceFileEv")
  //</editor-fold>
  public StringRef getOriginalSourceFile() {
    return new StringRef(ModuleMgr.getPrimaryModule().OriginalSourceFileName);
  }

  
  /// \brief Retrieve the name of the original source file name directly from
  /// the AST file, without actually loading the AST file.
  
  /// \brief Retrieve the name of the original source file name
  /// directly from the AST file, without actually loading the AST
  /// file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getOriginalSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4099,
   FQN="clang::ASTReader::getOriginalSourceFile", NM="_ZN5clang9ASTReader21getOriginalSourceFileERKSsRNS_11FileManagerERKNS_18PCHContainerReaderERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader21getOriginalSourceFileERKSsRNS_11FileManagerERKNS_18PCHContainerReaderERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public static std.string getOriginalSourceFile(final /*const*/std.string/*&*/ ASTFileName, final FileManager /*&*/ FileMgr, 
                       final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, final DiagnosticsEngine /*&*/ Diags) {
    ErrorOr<unique_ptr<MemoryBuffer> > Buffer = null;
    BitstreamReader StreamFile = null;
    BitstreamCursor Stream = null;
    try {
      // Open the AST file.
      Buffer = FileMgr.getBufferForFile(new StringRef(ASTFileName));
      if (!Buffer.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_unable_to_read_pch_file)), 
                  new StringRef(ASTFileName)), new StringRef(Buffer.getError().message())));
          return new std.string();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Initialize the stream
      StreamFile/*J*/= new BitstreamReader();
      PCHContainerRdr.ExtractPCH((Buffer.$star()).$arrow().getMemBufferRef(), StreamFile);
      Stream/*J*/= new BitstreamCursor(StreamFile);
      
      // Sniff for the signature.
      if (!startsWithASTFileMagic(Stream)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_not_a_pch_file)), new StringRef(ASTFileName)));
          return new std.string();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Scan for the CONTROL_BLOCK_ID block.
      if (SkipCursorToBlock(Stream, BlockIDs.CONTROL_BLOCK_ID)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_pch_malformed_block)), new StringRef(ASTFileName)));
          return new std.string();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Scan for ORIGINAL_FILE inside the control block.
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      while (true) {
        BitstreamEntry Entry = Stream.advanceSkippingSubblocks();
        if (Entry.Kind == BitstreamEntry.Unnamed_enum.EndBlock) {
          return new std.string();
        }
        if (Entry.Kind != BitstreamEntry.Unnamed_enum.Record) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_pch_malformed_block)), new StringRef(ASTFileName)));
            return new std.string();
          } finally {
            $c$.$destroy();
          }
        }
        
        Record.clear();
        StringRef Blob/*J*/= new StringRef();
        if (Stream.readRecord(Entry.ID, Record, $AddrOf(Blob)) == ControlRecordTypes.ORIGINAL_FILE) {
          return Blob.str();
        }
      }
    } finally {
      if (Stream != null) { Stream.$destroy(); }
      if (StreamFile != null) { StreamFile.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }

  
  /// \brief Read the control block for the named AST file.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::readASTFileControlBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4194,
   FQN="clang::ASTReader::readASTFileControlBlock", NM="_ZN5clang9ASTReader23readASTFileControlBlockEN4llvm9StringRefERNS_11FileManagerERKNS_18PCHContainerReaderEbRNS_17ASTReaderListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23readASTFileControlBlockEN4llvm9StringRefERNS_11FileManagerERKNS_18PCHContainerReaderEbRNS_17ASTReaderListenerE")
  //</editor-fold>
  public static boolean readASTFileControlBlock(StringRef Filename, final FileManager /*&*/ FileMgr, 
                         final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
                         boolean FindModuleFileExtensions, 
                         final ASTReaderListener /*&*/ Listener) {
    ErrorOr<unique_ptr<MemoryBuffer> > Buffer = null;
    BitstreamReader StreamFile = null;
    BitstreamCursor Stream = null;
    BitstreamCursor InputFilesCursor = null;
    try {
      // Open the AST file.
      // FIXME: This allows use of the VFS; we do not allow use of the
      // VFS when actually loading a module.
      Buffer = FileMgr.getBufferForFile(new StringRef(Filename));
      if (!Buffer.$bool()) {
        return true;
      }
      
      // Initialize the stream
      StreamFile/*J*/= new BitstreamReader();
      PCHContainerRdr.ExtractPCH((Buffer.$star()).$arrow().getMemBufferRef(), StreamFile);
      Stream/*J*/= new BitstreamCursor(StreamFile);
      
      // Sniff for the signature.
      if (!startsWithASTFileMagic(Stream)) {
        return true;
      }
      
      // Scan for the CONTROL_BLOCK_ID block.
      if (SkipCursorToBlock(Stream, BlockIDs.CONTROL_BLOCK_ID)) {
        return true;
      }
      
      boolean NeedsInputFiles = Listener.needsInputFileVisitation();
      boolean NeedsSystemInputFiles = Listener.needsSystemInputFileVisitation();
      boolean NeedsImports = Listener.needsImportVisitation();
      InputFilesCursor/*J*/= new BitstreamCursor();
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      std.string ModuleDir/*J*/= new std.string();
      boolean DoneWithControlBlock = false;
      while (!DoneWithControlBlock) {
        BitstreamEntry Entry = Stream.advance();
        switch (Entry.Kind) {
         case SubBlock:
          {
            switch (Entry.ID) {
             case BlockIDs.OPTIONS_BLOCK_ID:
              {
                std.string IgnoredSuggestedPredefines/*J*/= new std.string();
                if (ReadOptionsBlock(Stream, LoadFailureCapabilities.ARR_ConfigurationMismatch | LoadFailureCapabilities.ARR_OutOfDate, 
                    /*AllowCompatibleConfigurationMismatch*/ false, 
                    Listener, IgnoredSuggestedPredefines) != ASTReadResult.Success) {
                  return true;
                }
                break;
              }
             case BlockIDs.INPUT_FILES_BLOCK_ID:
              InputFilesCursor.$assign(Stream);
              if (Stream.SkipBlock()
                 || (NeedsInputFiles
                 && ReadBlockAbbrevs(InputFilesCursor, BlockIDs.INPUT_FILES_BLOCK_ID))) {
                return true;
              }
              break;
             default:
              if (Stream.SkipBlock()) {
                return true;
              }
              break;
            }
            
            continue;
          }
         case EndBlock:
          DoneWithControlBlock = true;
          break;
         case Error:
          return true;
         case Record:
          break;
        }
        if (DoneWithControlBlock) {
          break;
        }
        
        Record.clear();
        StringRef Blob/*J*/= new StringRef();
        /*uint*/int RecCode = Stream.readRecord(Entry.ID, Record, $AddrOf(Blob));
        switch (RecCode) {
         case ControlRecordTypes.METADATA:
          {
            if (Record.$at(0) != $uint2ullong(VERSION_MAJOR)) {
              return true;
            }
            if (Listener.ReadFullVersionInformation(new StringRef(Blob))) {
              return true;
            }
            
            break;
          }
         case ControlRecordTypes.MODULE_NAME:
          Listener.ReadModuleName(new StringRef(Blob));
          break;
         case ControlRecordTypes.MODULE_DIRECTORY:
          ModuleDir.$assignMove(Blob.$string());
          break;
         case ControlRecordTypes.MODULE_MAP_FILE:
          {
            uint$ref Idx = create_uint$ref(0);
            std.string Path = ASTReader.ReadString(Record, Idx);
            ResolveImportedPath(Path, new StringRef(ModuleDir));
            Listener.ReadModuleMapFile(new StringRef(Path));
            break;
          }
         case ControlRecordTypes.INPUT_FILE_OFFSETS:
          {
            if (!NeedsInputFiles) {
              break;
            }
            
            /*uint*/int NumInputFiles = $ullong2uint(Record.$at(0));
            /*uint*/int NumUserFiles = $ullong2uint(Record.$at(1));
            /*const*/ulong$ptr/*uint64_t P*/ InputFileOffs = $tryClone(reinterpret_cast(/*const*/ulong$ptr/*uint64_t P*/ .class, Blob.data()));
            for (/*uint*/int I = 0; I != NumInputFiles; ++I) {
              SavedStreamPosition SavedPosition = null;
              try {
                // Go find this input file.
                boolean isSystemFile = $greatereq_uint(I, NumUserFiles);
                if (isSystemFile && !NeedsSystemInputFiles) {
                  break; // the rest are system input files
                }
                
                final BitstreamCursor /*&*/ Cursor = InputFilesCursor;
                SavedPosition/*J*/= new SavedStreamPosition(Cursor);
                Cursor.JumpToBit(InputFileOffs.$at(I));
                
                /*uint*/int Code = Cursor.ReadCode();
                SmallVectorULong Record$1/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
                StringRef Blob$1/*J*/= new StringRef();
                boolean shouldContinue = false;
                switch (Cursor.readRecord(Code, Record$1, $AddrOf(Blob$1))) {
                 case InputFileRecordTypes.INPUT_FILE:
                  boolean Overridden = ((/*static_cast*/boolean)((Record$1.$at(3) != 0)));
                  std.string Filename$1 = Blob$1.$string();
                  ResolveImportedPath(Filename$1, new StringRef(ModuleDir));
                  shouldContinue = Listener.visitInputFile(new StringRef(Filename$1), isSystemFile, Overridden, /*IsExplicitModule*/ false);
                  break;
                }
                if (!shouldContinue) {
                  break;
                }
              } finally {
                if (SavedPosition != null) { SavedPosition.$destroy(); }
              }
            }
            break;
          }
         case ControlRecordTypes.IMPORTS:
          {
            if (!NeedsImports) {
              break;
            }
            
            uint$ref Idx = create_uint$ref(0);
            /*uint*/int N = Record.size();
            while ($less_uint(Idx.$deref(), N)) {
              // Read information about the AST file.
              Idx.$set$addassign(5); // ImportLoc, Size, ModTime, Signature
              std.string Filename$1 = ASTReader.ReadString(Record, Idx);
              ResolveImportedPath(Filename$1, new StringRef(ModuleDir));
              Listener.visitImport(new StringRef(Filename$1));
            }
            break;
          }
         default:
          // No other validation to perform.
          break;
        }
      }
      
      // Look for module file extension blocks, if requested.
      if (FindModuleFileExtensions) {
        while (!SkipCursorToBlock(Stream, BlockIDs.EXTENSION_BLOCK_ID)) {
          boolean DoneWithExtensionBlock = false;
          while (!DoneWithExtensionBlock) {
            BitstreamEntry Entry = Stream.advance();
            switch (Entry.Kind) {
             case SubBlock:
              if (Stream.SkipBlock()) {
                return true;
              }
              
              continue;
             case EndBlock:
              DoneWithExtensionBlock = true;
              continue;
             case Error:
              return true;
             case Record:
              break;
            }
            
            Record.clear();
            StringRef Blob/*J*/= new StringRef();
            /*uint*/int RecCode = Stream.readRecord(Entry.ID, Record, $AddrOf(Blob));
            switch (RecCode) {
             case ExtensionBlockRecordTypes.EXTENSION_METADATA:
              {
                ModuleFileExtensionMetadata Metadata = null;
                try {
                  Metadata/*J*/= new ModuleFileExtensionMetadata();
                  if (parseModuleFileExtensionMetadata(Record, new StringRef(Blob), Metadata)) {
                    return true;
                  }
                  
                  Listener.readModuleFileExtension(Metadata);
                  break;
                } finally {
                  if (Metadata != null) { Metadata.$destroy(); }
                }
              }
            }
          }
        }
      }
      
      return false;
    } finally {
      if (InputFilesCursor != null) { InputFilesCursor.$destroy(); }
      if (Stream != null) { Stream.$destroy(); }
      if (StreamFile != null) { StreamFile.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }

  
  /// \brief Determine whether the given AST file is acceptable to load into a
  /// translation unit with the given language and target options.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::isAcceptableASTFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4402,
   FQN="clang::ASTReader::isAcceptableASTFile", NM="_ZN5clang9ASTReader19isAcceptableASTFileEN4llvm9StringRefERNS_11FileManagerERKNS_18PCHContainerReaderERKNS_11LangOptionsERKNS_13TargetOptionsERKNS_19PreprocessorOptionsESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19isAcceptableASTFileEN4llvm9StringRefERNS_11FileManagerERKNS_18PCHContainerReaderERKNS_11LangOptionsERKNS_13TargetOptionsERKNS_19PreprocessorOptionsESs")
  //</editor-fold>
  public static boolean isAcceptableASTFile(StringRef Filename, final FileManager /*&*/ FileMgr, 
                     final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, final /*const*/ LangOptions /*&*/ LangOpts, 
                     final /*const*/ TargetOptions /*&*/ TargetOpts, final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                     std.string ExistingModuleCachePath) {
    SimplePCHValidator validator = null;
    try {
      validator/*J*/= new SimplePCHValidator(LangOpts, TargetOpts, PPOpts, 
          new StringRef(ExistingModuleCachePath), FileMgr);
      return !readASTFileControlBlock(new StringRef(Filename), FileMgr, PCHContainerRdr, 
          /*FindModuleFileExtensions=*/ false, 
          validator);
    } finally {
      if (validator != null) { validator.$destroy(); }
    }
  }

  
  /// \brief Returns the suggested contents of the predefines buffer,
  /// which contains a (typically-empty) subset of the predefines
  /// build prior to including the precompiled header.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSuggestedPredefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1534,
   FQN="clang::ASTReader::getSuggestedPredefines", NM="_ZN5clang9ASTReader22getSuggestedPredefinesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22getSuggestedPredefinesEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getSuggestedPredefines() {
    return SuggestedPredefines;
  }

  
  /// \brief Read a preallocated preprocessed entity from the external source.
  ///
  /// \returns null if an error occurred that prevented the preprocessed
  /// entity from being loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadPreprocessedEntity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4876,
   FQN="clang::ASTReader::ReadPreprocessedEntity", NM="_ZN5clang9ASTReader22ReadPreprocessedEntityEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22ReadPreprocessedEntityEj")
  //</editor-fold>
  @Override public PreprocessedEntity /*P*/ ReadPreprocessedEntity(/*uint*/int Index)/* override*/ {
    SavedStreamPosition SavedPosition = null;
    try {
      /*uint32_t*/int PPID = Index + 1;
      std.pairPtrUInt<ModuleFile /*P*/ > PPInfo = getModulePreprocessedEntity(Index);
      final ModuleFile /*&*/ M = $Deref(PPInfo.first);
      /*uint*/int LocalIndex = PPInfo.second;
      final /*const*/ PPEntityOffset /*&*/ PPOffs = M.PreprocessedEntityOffsets.$at(LocalIndex);
      if (!(PP.getPreprocessingRecord() != null)) {
        Error(new StringRef(/*KEEP_STR*/"no preprocessing record"));
        return null;
      }
      
      SavedPosition/*J*/= new SavedStreamPosition(M.PreprocessorDetailCursor);
      M.PreprocessorDetailCursor.JumpToBit($uint2ulong(PPOffs.BitOffset));
      
      BitstreamEntry Entry = M.PreprocessorDetailCursor.advance(BitstreamCursor.Unnamed_enum.AF_DontPopBlockAtEnd.getValue());
      if (Entry.Kind != BitstreamEntry.Unnamed_enum.Record) {
        return null;
      }
      
      // Read the record.
      SourceRange Range/*J*/= new SourceRange(TranslateSourceLocation(M, PPOffs.getBegin()), 
          TranslateSourceLocation(M, PPOffs.getEnd()));
      final PreprocessingRecord /*&*/ PPRec = $Deref(PP.getPreprocessingRecord());
      StringRef Blob/*J*/= new StringRef();
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      /*PreprocessorDetailRecordTypes*/int RecType = M.PreprocessorDetailCursor.readRecord(Entry.ID, Record, $AddrOf(Blob));
      switch (RecType) {
       case PreprocessorDetailRecordTypes.PPD_MACRO_EXPANSION:
        {
          boolean isBuiltin = (Record.$at(0) != 0);
          IdentifierInfo /*P*/ Name = null;
          MacroDefinitionRecord /*P*/ Def = null;
          if (isBuiltin) {
            Name = getLocalIdentifier(M, $ullong2uint(Record.$at(1)));
          } else {
            /*uint32_t*/int GlobalID = getGlobalPreprocessedEntityID(M, $ullong2uint(Record.$at(1)));
            Def = cast_MacroDefinitionRecord(PPRec.getLoadedPreprocessedEntity(GlobalID - 1));
          }
          
          MacroExpansion /*P*/ ME;
          if (isBuiltin) {
            IdentifierInfo /*P*/ Name_final = Name;
            ME = /*NEW_EXPR [PreprocessedEntity::new]*//*new (PPRec)*/ PreprocessedEntity.$new(PPRec, (type$ptr<?> New$Mem)->{
                return new MacroExpansion(Name_final, /*NO_COPY*/Range);
             });
          } else {
            MacroDefinitionRecord /*P*/ Def_final = Def;
            ME = /*NEW_EXPR [PreprocessedEntity::new]*//*new (PPRec)*/ PreprocessedEntity.$new(PPRec, (type$ptr<?> New$Mem)->{
                return new MacroExpansion(Def_final, /*NO_COPY*/Range);
             });
          }
          
          return ME;
        }
       case PreprocessorDetailRecordTypes.PPD_MACRO_DEFINITION:
        {
          // Decode the identifier info and then check again; if the macro is
          // still defined and associated with the identifier,
          IdentifierInfo /*P*/ II = getLocalIdentifier(M, $ullong2uint(Record.$at(0)));
          MacroDefinitionRecord /*P*/ MD = /*NEW_EXPR [PreprocessedEntity::new]*//*new (PPRec)*/ PreprocessedEntity.$new(PPRec, (type$ptr<?> New$Mem)->{
              return new MacroDefinitionRecord(II, /*NO_COPY*/Range);
           });
          if ((DeserializationListener != null)) {
            DeserializationListener.MacroDefinitionRead(PPID, MD);
          }
          
          return MD;
        }
       case PreprocessorDetailRecordTypes.PPD_INCLUSION_DIRECTIVE:
        {
          /*const*/char$ptr/*char P*/ FullFileNameStart = $tryClone(Blob.data().$add((int)Record.$at(0)));
          StringRef FullFileName/*J*/= new StringRef(FullFileNameStart, $ullong2uint($uint2ullong(Blob.size()) - Record.$at(0)));
          /*const*/ FileEntry /*P*/ File = null;
          if (!FullFileName.empty()) {
            File = PP.getFileManager().getFile(/*NO_COPY*/FullFileName);
          }
          
          // FIXME: Stable encoding
          InclusionDirective.InclusionKind Kind = /*static_cast*/InclusionDirective.InclusionKind.valueOf((int)Record.$at(2));
          FileEntry /*P*/ File_final = File;
          InclusionDirective /*P*/ ID = /*NEW_EXPR [PreprocessedEntity::new]*//*new (PPRec)*/ PreprocessedEntity.$new(PPRec, (type$ptr<?> New$Mem)->{
              return new InclusionDirective(PPRec, Kind, 
                      new StringRef(Blob.data(), $ullong2uint(Record.$at(0))), 
                      (Record.$at(1) != 0), (Record.$at(3) != 0), 
                      File_final, 
                      /*NO_COPY*/Range);
           });
          return ID;
        }
      }
      throw new llvm_unreachable("Invalid PreprocessorDetailRecordTypes");
    } finally {
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  
  /// \brief Returns a pair of [Begin, End) indices of preallocated
  /// preprocessed entities that \p Range encompasses.
  
  /// \brief Returns a pair of [Begin, End) indices of preallocated
  /// preprocessed entities that \arg Range encompasses.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::findPreprocessedEntitiesInRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5064,
   FQN="clang::ASTReader::findPreprocessedEntitiesInRange", NM="_ZN5clang9ASTReader31findPreprocessedEntitiesInRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader31findPreprocessedEntitiesInRangeENS_11SourceRangeE")
  //</editor-fold>
  @Override public std.pairUIntUInt findPreprocessedEntitiesInRange(SourceRange Range)/* override*/ {
    if (Range.isInvalid()) {
      return new std.pairUIntUInt(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/0, /*Fwd2*//*Fwd*/0);
    }
    assert (!SourceMgr.isBeforeInTranslationUnit(Range.getEnd(), Range.getBegin()));
    
    /*uint32_t*/int BeginID = findPreprocessedEntity(Range.getBegin(), false);
    /*uint32_t*/int EndID = findPreprocessedEntity(Range.getEnd(), true);
    return std.make_pair_uint_uint(BeginID, EndID);
  }

  
  /// \brief Optionally returns true or false if the preallocated preprocessed
  /// entity with index \p Index came from file \p FID.
  
  /// \brief Optionally returns true or false if the preallocated preprocessed
  /// entity with index \arg Index came from file \arg FID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::isPreprocessedEntityInFileID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5078,
   FQN="clang::ASTReader::isPreprocessedEntityInFileID", NM="_ZN5clang9ASTReader28isPreprocessedEntityInFileIDEjNS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader28isPreprocessedEntityInFileIDEjNS_6FileIDE")
  //</editor-fold>
  @Override public OptionalBool isPreprocessedEntityInFileID(/*uint*/int Index, 
                              FileID FID)/* override*/ {
    if (FID.isInvalid()) {
      return new OptionalBool(JD$T$RR.INSTANCE, false);
    }
    
    std.pairPtrUInt<ModuleFile /*P*/ > PPInfo = getModulePreprocessedEntity(Index);
    final ModuleFile /*&*/ M = $Deref(PPInfo.first);
    /*uint*/int LocalIndex = PPInfo.second;
    final /*const*/ PPEntityOffset /*&*/ PPOffs = M.PreprocessedEntityOffsets.$at(LocalIndex);
    
    SourceLocation Loc = TranslateSourceLocation(M, PPOffs.getBegin());
    if (Loc.isInvalid()) {
      return new OptionalBool(JD$T$RR.INSTANCE, false);
    }
    if (SourceMgr.isInFileID(SourceMgr.getFileLoc(/*NO_COPY*/Loc), /*NO_COPY*/FID)) {
      return new OptionalBool(JD$T$RR.INSTANCE, true);
    } else {
      return new OptionalBool(JD$T$RR.INSTANCE, false);
    }
  }

  
  /// \brief Read the header file information for the given file entry.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetHeaderFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5128,
   FQN="clang::ASTReader::GetHeaderFileInfo", NM="_ZN5clang9ASTReader17GetHeaderFileInfoEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17GetHeaderFileInfoEPKNS_9FileEntryE")
  //</editor-fold>
  @Override public HeaderFileInfo GetHeaderFileInfo(/*const*/ FileEntry /*P*/ FE)/* override*/ {
    HeaderFileInfoVisitor Visitor = null;
    try {
      Visitor/*J*/= new HeaderFileInfoVisitor(FE);
      ModuleMgr.visit(/*FuncArg*/Visitor);
      {
        Optional<HeaderFileInfo> HFI = Visitor.getHeaderFileInfo();
        if (HFI.$bool()) {
          return new HeaderFileInfo(HFI.$star());
        }
      }
      
      return new HeaderFileInfo();
    } finally {
      if (Visitor != null) { Visitor.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadPragmaDiagnosticMappings">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5137,
   FQN="clang::ASTReader::ReadPragmaDiagnosticMappings", NM="_ZN5clang9ASTReader28ReadPragmaDiagnosticMappingsERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader28ReadPragmaDiagnosticMappingsERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public void ReadPragmaDiagnosticMappings(final DiagnosticsEngine /*&*/ Diag) {
    // FIXME: Make it work properly with modules.
    SmallVector<DiagnosticsEngine.DiagState /*P*/ > DiagStates/*J*/= new SmallVector<DiagnosticsEngine.DiagState /*P*/ >(32,
            (DiagnosticsEngine.DiagState /*P*/ )null);
    for (type$ptr<ModuleFile /*P*/ /*P*/> I = $tryClone(ModuleMgr.begin()), /*P*/ E = $tryClone(ModuleMgr.end()); $noteq_ptr(I, E); I.$preInc()) {
      final ModuleFile /*&*/ F = $Deref((I.$star()));
      /*uint*/int Idx = 0;
      DiagStates.clear();
      assert (!Diag.DiagStates.empty());
      DiagStates.push_back($AddrOf(Diag.DiagStates.front())); // the command-line one.
      while ($less_uint(Idx, F.PragmaDiagMappings.size())) {
        SourceLocation Loc = ReadSourceLocation(F, $ullong2uint(F.PragmaDiagMappings.$at(Idx++)));
        /*uint*/int DiagStateID = $ullong2uint(F.PragmaDiagMappings.$at(Idx++));
        if (DiagStateID != 0) {
          Diag.DiagStatePoints.push_back_T$RR(new DiagnosticsEngine.DiagStatePoint(DiagStates.$at(DiagStateID - 1), 
                  new FullSourceLoc(/*NO_COPY*/Loc, SourceMgr)));
          continue;
        }
        assert (DiagStateID == 0);
        // A new DiagState was created here.
        Diag.DiagStates.push_back_T$C$R($Deref(Diag.GetCurDiagState()));
        DiagnosticsEngine.DiagState /*P*/ NewState = $AddrOf(Diag.DiagStates.back());
        DiagStates.push_back(NewState);
        Diag.DiagStatePoints.push_back_T$RR(new DiagnosticsEngine.DiagStatePoint(NewState, 
                new FullSourceLoc(/*NO_COPY*/Loc, SourceMgr)));
        while (true) {
          assert ($less_uint(Idx, F.PragmaDiagMappings.size())) : "Invalid data, didn't find '-1' marking end of diag/map pairs";
          if ($greatereq_uint(Idx, F.PragmaDiagMappings.size())) {
            break; // Something is messed up but at least avoid infinite loop in
            // release build.
          }
          /*uint*/int DiagID = $ullong2uint(F.PragmaDiagMappings.$at(Idx++));
          if (DiagID == (/*uint*/int)-1) {
            break; // no more diag/map pairs for this location.
          }
          diag.Severity Map = diag.Severity.valueOf((int)F.PragmaDiagMappings.$at(Idx++));
          DiagnosticMapping Mapping = Diag.makeUserMapping(Map, /*NO_COPY*/Loc);
          Diag.GetCurDiagState().setMapping(DiagID, new DiagnosticMapping(Mapping));
        }
      }
    }
  }

  
  /// \brief Returns the number of source locations found in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumSLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1558,
   FQN="clang::ASTReader::getTotalNumSLocs", NM="_ZNK5clang9ASTReader16getTotalNumSLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader16getTotalNumSLocsEv")
  //</editor-fold>
  public /*uint*/int getTotalNumSLocs() /*const*/ {
    return TotalNumSLocEntries;
  }

  
  /// \brief Returns the number of identifiers found in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1563,
   FQN="clang::ASTReader::getTotalNumIdentifiers", NM="_ZNK5clang9ASTReader22getTotalNumIdentifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader22getTotalNumIdentifiersEv")
  //</editor-fold>
  public /*uint*/int getTotalNumIdentifiers() /*const*/ {
    return ((/*static_cast*//*uint*/int)(IdentifiersLoaded.size()));
  }

  
  /// \brief Returns the number of macros found in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1568,
   FQN="clang::ASTReader::getTotalNumMacros", NM="_ZNK5clang9ASTReader17getTotalNumMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader17getTotalNumMacrosEv")
  //</editor-fold>
  public /*uint*/int getTotalNumMacros() /*const*/ {
    return ((/*static_cast*//*uint*/int)(MacrosLoaded.size()));
  }

  
  /// \brief Returns the number of types found in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1573,
   FQN="clang::ASTReader::getTotalNumTypes", NM="_ZNK5clang9ASTReader16getTotalNumTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader16getTotalNumTypesEv")
  //</editor-fold>
  public /*uint*/int getTotalNumTypes() /*const*/ {
    return ((/*static_cast*//*uint*/int)(TypesLoaded.size()));
  }

  
  /// \brief Returns the number of declarations found in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1578,
   FQN="clang::ASTReader::getTotalNumDecls", NM="_ZNK5clang9ASTReader16getTotalNumDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader16getTotalNumDeclsEv")
  //</editor-fold>
  public /*uint*/int getTotalNumDecls() /*const*/ {
    return ((/*static_cast*//*uint*/int)(DeclsLoaded.size()));
  }

  
  /// \brief Returns the number of submodules known.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumSubmodules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1583,
   FQN="clang::ASTReader::getTotalNumSubmodules", NM="_ZNK5clang9ASTReader21getTotalNumSubmodulesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader21getTotalNumSubmodulesEv")
  //</editor-fold>
  public /*uint*/int getTotalNumSubmodules() /*const*/ {
    return ((/*static_cast*//*uint*/int)(SubmodulesLoaded.size()));
  }

  
  /// \brief Returns the number of selectors found in the chain.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1588,
   FQN="clang::ASTReader::getTotalNumSelectors", NM="_ZNK5clang9ASTReader20getTotalNumSelectorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader20getTotalNumSelectorsEv")
  //</editor-fold>
  public /*uint*/int getTotalNumSelectors() /*const*/ {
    return ((/*static_cast*//*uint*/int)(SelectorsLoaded.size()));
  }

  
  /// \brief Returns the number of preprocessed entities known to the AST
  /// reader.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getTotalNumPreprocessedEntities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1594,
   FQN="clang::ASTReader::getTotalNumPreprocessedEntities", NM="_ZNK5clang9ASTReader31getTotalNumPreprocessedEntitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader31getTotalNumPreprocessedEntitiesEv")
  //</editor-fold>
  public /*uint*/int getTotalNumPreprocessedEntities() /*const*/ {
    /*uint*/int Result = 0;
    for (type$ptr<ModuleFile /*P*/ /*P*/> I = $tryClone(ModuleMgr.begin$Const()), 
        /*P*/ E = $tryClone(ModuleMgr.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      Result += (I.$star()).NumPreprocessedEntities;
    }
    
    return Result;
  }

  
  /// \brief Reads a TemplateArgumentLocInfo appropriate for the
  /// given TemplateArgument kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetTemplateArgumentLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6160,
   FQN="clang::ASTReader::GetTemplateArgumentLocInfo", NM="_ZN5clang9ASTReader26GetTemplateArgumentLocInfoERNS_13serialization10ModuleFileENS_16TemplateArgument7ArgKindERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader26GetTemplateArgumentLocInfoERNS_13serialization10ModuleFileENS_16TemplateArgument7ArgKindERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public TemplateArgumentLocInfo GetTemplateArgumentLocInfo(final ModuleFile /*&*/ F, 
                            TemplateArgument.ArgKind Kind, 
                            final /*const*/SmallVectorULong /*&*/ Record, 
                            final uint$ref/*uint &*/ Index) {
    switch (Kind) {
     case Expression:
      return new TemplateArgumentLocInfo(ReadExpr(F));
     case Type:
      return new TemplateArgumentLocInfo(GetTypeSourceInfo(F, Record, Index));
     case Template:
      {
        NestedNameSpecifierLoc QualifierLoc = ReadNestedNameSpecifierLoc(F, Record, 
            Index);
        SourceLocation TemplateNameLoc = ReadSourceLocation(F, Record, Index);
        return new TemplateArgumentLocInfo(new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateNameLoc), 
            new SourceLocation());
      }
     case TemplateExpansion:
      {
        NestedNameSpecifierLoc QualifierLoc = ReadNestedNameSpecifierLoc(F, Record, 
            Index);
        SourceLocation TemplateNameLoc = ReadSourceLocation(F, Record, Index);
        SourceLocation EllipsisLoc = ReadSourceLocation(F, Record, Index);
        return new TemplateArgumentLocInfo(new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateNameLoc), 
            new SourceLocation(EllipsisLoc));
      }
     case Null:
     case Integral:
     case Declaration:
     case NullPtr:
     case Pack:
      // FIXME: Is this right?
      return new TemplateArgumentLocInfo();
    }
    throw new llvm_unreachable("unexpected template argument loc");
  }

  
  /// \brief Reads a TemplateArgumentLoc.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadTemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6196,
   FQN="clang::ASTReader::ReadTemplateArgumentLoc", NM="_ZN5clang9ASTReader23ReadTemplateArgumentLocERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23ReadTemplateArgumentLocERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public TemplateArgumentLoc ReadTemplateArgumentLoc(final ModuleFile /*&*/ F, 
                         final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Index) {
    TemplateArgument Arg = ReadTemplateArgument(F, Record, Index);
    if (Arg.getKind() == TemplateArgument.ArgKind.Expression) {
      if ((Record.$at$Const(Index.$set$postInc()) != 0)) { // bool InfoHasSameExpr.
        return new TemplateArgumentLoc(Arg, new TemplateArgumentLocInfo(Arg.getAsExpr()));
      }
    }
    return new TemplateArgumentLoc(Arg, GetTemplateArgumentLocInfo(F, Arg.getKind(), 
            Record, Index));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadASTTemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6209,
   FQN="clang::ASTReader::ReadASTTemplateArgumentListInfo", NM="_ZN5clang9ASTReader31ReadASTTemplateArgumentListInfoERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader31ReadASTTemplateArgumentListInfoERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public /*const*/ ASTTemplateArgumentListInfo /*P*/ ReadASTTemplateArgumentListInfo(final ModuleFile /*&*/ F, 
                                 final /*const*/SmallVectorULong /*&*/ Record, 
                                 final uint$ref/*uint &*/ Index) {
    TemplateArgumentListInfo TemplArgsInfo = null;
    try {
      SourceLocation LAngleLoc = ReadSourceLocation(F, Record, Index);
      SourceLocation RAngleLoc = ReadSourceLocation(F, Record, Index);
      /*uint*/int NumArgsAsWritten = $ullong2uint(Record.$at$Const(Index.$set$postInc()));
      TemplArgsInfo/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
      for (/*uint*/int i = 0; i != NumArgsAsWritten; ++i)  {
        TemplArgsInfo.addArgument(ReadTemplateArgumentLoc(F, Record, Index));
      }
      return ASTTemplateArgumentListInfo.Create(getContext(), TemplArgsInfo);
    } finally {
      if (TemplArgsInfo != null) { TemplArgsInfo.$destroy(); }
    }
  }

  
  /// \brief Reads a declarator info from the given record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5953,
   FQN="clang::ASTReader::GetTypeSourceInfo", NM="_ZN5clang9ASTReader17GetTypeSourceInfoERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17GetTypeSourceInfoERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public TypeSourceInfo /*P*/ GetTypeSourceInfo(final ModuleFile /*&*/ F, 
                   final /*const*/SmallVectorULong /*&*/ Record, 
                   final uint$ref/*uint &*/ Idx) {
    QualType InfoTy = readType(F, Record, Idx);
    if (InfoTy.isNull()) {
      return null;
    }
    
    TypeSourceInfo /*P*/ TInfo = getContext().CreateTypeSourceInfo(new QualType(InfoTy));
    TypeLocReader TLR/*J*/= new TypeLocReader(/*Deref*/this, F, Record, Idx);
    for (TypeLoc TL = TInfo.getTypeLoc(); !TL.isNull(); TL.$assignMove(TL.getNextTypeLoc()))  {
      TLR.Visit(/*NO_COPY*/TL);
    }
    return TInfo;
  }

  
  /// \brief Resolve a type ID into a type, potentially building a new
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 5967,
   FQN="clang::ASTReader::GetType", NM="_ZN5clang9ASTReader7GetTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader7GetTypeEj")
  //</editor-fold>
  public QualType GetType(/*uint32_t*/int ID) {
    /*uint*/int FastQuals = ID & Qualifiers.FastMask;
    /*uint*/int Index = ID >>> Qualifiers.FastWidth;
    if ($less_uint(Index, NUM_PREDEF_TYPE_IDS)) {
      QualType T/*J*/= new QualType();
      switch (Index) {
       case PredefinedTypeIDs.PREDEF_TYPE_NULL_ID:
        return new QualType();
       case PredefinedTypeIDs.PREDEF_TYPE_VOID_ID:
        T.$assignMove(Context.VoidTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_BOOL_ID:
        T.$assignMove(Context.BoolTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_CHAR_U_ID:
       case PredefinedTypeIDs.PREDEF_TYPE_CHAR_S_ID:
        // FIXME: Check that the signedness of CharTy is correct!
        T.$assignMove(Context.CharTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_UCHAR_ID:
        T.$assignMove(Context.UnsignedCharTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_USHORT_ID:
        T.$assignMove(Context.UnsignedShortTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_UINT_ID:
        T.$assignMove(Context.UnsignedIntTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_ULONG_ID:
        T.$assignMove(Context.UnsignedLongTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_ULONGLONG_ID:
        T.$assignMove(Context.UnsignedLongLongTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_UINT128_ID:
        T.$assignMove(Context.UnsignedInt128Ty.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_SCHAR_ID:
        T.$assignMove(Context.SignedCharTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_WCHAR_ID:
        T.$assignMove(Context.WCharTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_SHORT_ID:
        T.$assignMove(Context.ShortTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_INT_ID:
        T.$assignMove(Context.IntTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_LONG_ID:
        T.$assignMove(Context.LongTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_LONGLONG_ID:
        T.$assignMove(Context.LongLongTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_INT128_ID:
        T.$assignMove(Context.Int128Ty.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_HALF_ID:
        T.$assignMove(Context.HalfTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_FLOAT_ID:
        T.$assignMove(Context.FloatTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_DOUBLE_ID:
        T.$assignMove(Context.DoubleTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_LONGDOUBLE_ID:
        T.$assignMove(Context.LongDoubleTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_FLOAT128_ID:
        T.$assignMove(Context.Float128Ty.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OVERLOAD_ID:
        T.$assignMove(Context.OverloadTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_BOUND_MEMBER:
        T.$assignMove(Context.BoundMemberTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_PSEUDO_OBJECT:
        T.$assignMove(Context.PseudoObjectTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_DEPENDENT_ID:
        T.$assignMove(Context.DependentTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_UNKNOWN_ANY:
        T.$assignMove(Context.UnknownAnyTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_NULLPTR_ID:
        T.$assignMove(Context.NullPtrTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_CHAR16_ID:
        T.$assignMove(Context.Char16Ty.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_CHAR32_ID:
        T.$assignMove(Context.Char32Ty.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OBJC_ID:
        T.$assignMove(Context.ObjCBuiltinIdTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OBJC_CLASS:
        T.$assignMove(Context.ObjCBuiltinClassTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OBJC_SEL:
        T.$assignMove(Context.ObjCBuiltinSelTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dRO_ID:
        T.$assignMove(Context.OCLImage1dROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dArrayRO_ID:
        T.$assignMove(Context.OCLImage1dArrayROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dBufferRO_ID:
        T.$assignMove(Context.OCLImage1dBufferROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dRO_ID:
        T.$assignMove(Context.OCLImage2dROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayRO_ID:
        T.$assignMove(Context.OCLImage2dArrayROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dDepthRO_ID:
        T.$assignMove(Context.OCLImage2dDepthROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayDepthRO_ID:
        T.$assignMove(Context.OCLImage2dArrayDepthROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAARO_ID:
        T.$assignMove(Context.OCLImage2dMSAAROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAARO_ID:
        T.$assignMove(Context.OCLImage2dArrayMSAAROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAADepthRO_ID:
        T.$assignMove(Context.OCLImage2dMSAADepthROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAADepthRO_ID:
        T.$assignMove(Context.OCLImage2dArrayMSAADepthROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage3dRO_ID:
        T.$assignMove(Context.OCLImage3dROTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dWO_ID:
        T.$assignMove(Context.OCLImage1dWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dArrayWO_ID:
        T.$assignMove(Context.OCLImage1dArrayWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dBufferWO_ID:
        T.$assignMove(Context.OCLImage1dBufferWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dWO_ID:
        T.$assignMove(Context.OCLImage2dWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayWO_ID:
        T.$assignMove(Context.OCLImage2dArrayWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dDepthWO_ID:
        T.$assignMove(Context.OCLImage2dDepthWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayDepthWO_ID:
        T.$assignMove(Context.OCLImage2dArrayDepthWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAAWO_ID:
        T.$assignMove(Context.OCLImage2dMSAAWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAAWO_ID:
        T.$assignMove(Context.OCLImage2dArrayMSAAWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAADepthWO_ID:
        T.$assignMove(Context.OCLImage2dMSAADepthWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAADepthWO_ID:
        T.$assignMove(Context.OCLImage2dArrayMSAADepthWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage3dWO_ID:
        T.$assignMove(Context.OCLImage3dWOTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dRW_ID:
        T.$assignMove(Context.OCLImage1dRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dArrayRW_ID:
        T.$assignMove(Context.OCLImage1dArrayRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dBufferRW_ID:
        T.$assignMove(Context.OCLImage1dBufferRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dRW_ID:
        T.$assignMove(Context.OCLImage2dRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayRW_ID:
        T.$assignMove(Context.OCLImage2dArrayRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dDepthRW_ID:
        T.$assignMove(Context.OCLImage2dDepthRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayDepthRW_ID:
        T.$assignMove(Context.OCLImage2dArrayDepthRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAARW_ID:
        T.$assignMove(Context.OCLImage2dMSAARWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAARW_ID:
        T.$assignMove(Context.OCLImage2dArrayMSAARWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAADepthRW_ID:
        T.$assignMove(Context.OCLImage2dMSAADepthRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAADepthRW_ID:
        T.$assignMove(Context.OCLImage2dArrayMSAADepthRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OCLImage3dRW_ID:
        T.$assignMove(Context.OCLImage3dRWTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_SAMPLER_ID:
        T.$assignMove(Context.OCLSamplerTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_EVENT_ID:
        T.$assignMove(Context.OCLEventTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_CLK_EVENT_ID:
        T.$assignMove(Context.OCLClkEventTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_QUEUE_ID:
        T.$assignMove(Context.OCLQueueTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_NDRANGE_ID:
        T.$assignMove(Context.OCLNDRangeTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_RESERVE_ID_ID:
        T.$assignMove(Context.OCLReserveIDTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_AUTO_DEDUCT:
        T.$assignMove(Context.getAutoDeductType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_AUTO_RREF_DEDUCT:
        T.$assignMove(Context.getAutoRRefDeductType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_ARC_UNBRIDGED_CAST:
        T.$assignMove(Context.ARCUnbridgedCastTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_BUILTIN_FN:
        T.$assignMove(Context.BuiltinFnTy.$QualType());
        break;
       case PredefinedTypeIDs.PREDEF_TYPE_OMP_ARRAY_SECTION:
        T.$assignMove(Context.OMPArraySectionTy.$QualType());
        break;
      }
      assert (!T.isNull()) : "Unknown predefined type";
      return T.withFastQualifiers(FastQuals);
    }
    
    Index -= NUM_PREDEF_TYPE_IDS;
    assert ($less_uint(Index, TypesLoaded.size())) : "Type index out-of-range";
    if (TypesLoaded.$at(Index).isNull()) {
      TypesLoaded.$at(Index).$assignMove(readTypeRecord(Index));
      if (TypesLoaded.$at(Index).isNull()) {
        return new QualType();
      }
      
      TypesLoaded.$at(Index).$arrow().setFromAST();
      if ((DeserializationListener != null)) {
        DeserializationListener.TypeRead(TypeIdx.fromTypeID(ID), 
            new QualType(TypesLoaded.$at(Index)));
      }
    }
    
    return TypesLoaded.$at(Index).withFastQualifiers(FastQuals);
  }

  
  /// \brief Resolve a local type ID within a given AST file into a type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getLocalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6140,
   FQN="clang::ASTReader::getLocalType", NM="_ZN5clang9ASTReader12getLocalTypeERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12getLocalTypeERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public QualType getLocalType(final ModuleFile /*&*/ F, /*uint*/int LocalID) {
    return GetType(getGlobalTypeID(F, LocalID));
  }

  
  /// \brief Map a local type ID within a given AST file into a global type ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalTypeID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6144,
   FQN="clang::ASTReader::getGlobalTypeID", NM="_ZNK5clang9ASTReader15getGlobalTypeIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader15getGlobalTypeIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalTypeID(final ModuleFile /*&*/ F, /*uint*/int LocalID) /*const*/ {
    /*uint*/int FastQuals = LocalID & Qualifiers.FastMask;
    /*uint*/int LocalIndex = LocalID >>> Qualifiers.FastWidth;
    if ($less_uint(LocalIndex, NUM_PREDEF_TYPE_IDS)) {
      return LocalID;
    }
    
    type$ptr<std.pairUIntInt /*P*/> I = $tryClone(F.TypeRemap.find(LocalIndex - NUM_PREDEF_TYPE_IDS));
    assert ($noteq_ptr(I, F.TypeRemap.end())) : "Invalid index into type index remap";
    
    /*uint*/int GlobalIndex = LocalIndex + I./*->*/$star().second;
    return (GlobalIndex << Qualifiers.FastWidth) | FastQuals;
  }

  
  /// \brief Read a type from the current position in the given record, which
  /// was read from the given AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::readType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1635,
   FQN="clang::ASTReader::readType", NM="_ZN5clang9ASTReader8readTypeERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader8readTypeERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public QualType readType(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    if ($greatereq_uint(Idx.$deref(), Record.size())) {
      return new QualType();
    }
    
    return getLocalType(F, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  
  /// \brief Map from a local declaration ID within a given module to a
  /// global declaration ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalDeclID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6327,
   FQN="clang::ASTReader::getGlobalDeclID", NM="_ZNK5clang9ASTReader15getGlobalDeclIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader15getGlobalDeclIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalDeclID(final ModuleFile /*&*/ F, /*uint32_t*/int LocalID) /*const*/ {
    if ($less_uint(LocalID, NUM_PREDEF_DECL_IDS)) {
      return LocalID;
    }
    
    type$ptr<std.pairUIntInt /*P*/> I = $tryClone(F.DeclRemap.find(LocalID - NUM_PREDEF_DECL_IDS));
    assert ($noteq_ptr(I, F.DeclRemap.end())) : "Invalid index into decl index remap";
    
    return LocalID + I./*->*/$star().second;
  }

  
  /// \brief Returns true if global DeclID \p ID originated from module \p M.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::isDeclIDFromModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6339,
   FQN="clang::ASTReader::isDeclIDFromModule", NM="_ZNK5clang9ASTReader18isDeclIDFromModuleEjRNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader18isDeclIDFromModuleEjRNS_13serialization10ModuleFileE")
  //</editor-fold>
  public boolean isDeclIDFromModule(/*uint32_t*/int ID, 
                    final ModuleFile /*&*/ M) /*const*/ {
    // Predefined decls aren't from any module.
    if ($less_uint(ID, NUM_PREDEF_DECL_IDS)) {
      return false;
    }
    
    return $greatereq_uint(ID - NUM_PREDEF_DECL_IDS, M.BaseDeclID)
       && $less_uint(ID - NUM_PREDEF_DECL_IDS, M.BaseDeclID + M.LocalNumDecls);
  }

  
  /// \brief Retrieve the module file that owns the given declaration, or NULL
  /// if the declaration is not from a module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getOwningModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6349,
   FQN="clang::ASTReader::getOwningModuleFile", NM="_ZN5clang9ASTReader19getOwningModuleFileEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19getOwningModuleFileEPKNS_4DeclE")
  //</editor-fold>
  public ModuleFile /*P*/ getOwningModuleFile(/*const*/ Decl /*P*/ D) {
    if (!D.isFromASTFile()) {
      return null;
    }
    type$ptr</*const*/std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalDeclMap.find(D.getGlobalID()));
    assert ($noteq_ptr(I, GlobalDeclMap.end())) : "Corrupted global declaration map";
    return I./*->*/$star().second;
  }

  
  /// \brief Get the best name we know for the module that owns the given
  /// declaration, or an empty string if the declaration is not from a module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getOwningModuleNameForDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8290,
   FQN="clang::ASTReader::getOwningModuleNameForDiagnostic", NM="_ZN5clang9ASTReader32getOwningModuleNameForDiagnosticEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader32getOwningModuleNameForDiagnosticEPKNS_4DeclE")
  //</editor-fold>
  public std.string getOwningModuleNameForDiagnostic(/*const*/ Decl /*P*/ D) {
    {
      // If we know the owning module, use it.
      Module /*P*/ M = D.getImportedOwningModule();
      if ((M != null)) {
        return M.getFullModuleName();
      }
    }
    {
      
      // Otherwise, use the name of the top-level module the decl is within.
      ModuleFile /*P*/ M = getOwningModuleFile(D);
      if ((M != null)) {
        return new std.string(M.ModuleName);
      }
    }
    
    // Not from a module.
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  
  /// \brief Returns the source location for the decl \p ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSourceLocationForDeclID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6357,
   FQN="clang::ASTReader::getSourceLocationForDeclID", NM="_ZN5clang9ASTReader26getSourceLocationForDeclIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader26getSourceLocationForDeclIDEj")
  //</editor-fold>
  public SourceLocation getSourceLocationForDeclID(/*uint32_t*/int ID) {
    if ($less_uint(ID, NUM_PREDEF_DECL_IDS)) {
      return new SourceLocation();
    }
    
    /*uint*/int Index = ID - NUM_PREDEF_DECL_IDS;
    if ($greater_uint(Index, DeclsLoaded.size())) {
      Error(new StringRef(/*KEEP_STR*/"declaration ID out-of-range for AST file"));
      return new SourceLocation();
    }
    {
      
      Decl /*P*/ D = DeclsLoaded.$at(Index);
      if ((D != null)) {
        return D.getLocation();
      }
    }
    
    SourceLocation Loc/*J*/= new SourceLocation();
    DeclCursorForID(ID, Loc);
    return Loc;
  }

  
  /// \brief Resolve a declaration ID into a declaration, potentially
  /// building a new declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6456,
   FQN="clang::ASTReader::GetDecl", NM="_ZN5clang9ASTReader7GetDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader7GetDeclEj")
  //</editor-fold>
  public Decl /*P*/ GetDecl(/*uint32_t*/int ID) {
    if ($less_uint(ID, NUM_PREDEF_DECL_IDS)) {
      return GetExistingDecl(ID);
    }
    
    /*uint*/int Index = ID - NUM_PREDEF_DECL_IDS;
    if ($greatereq_uint(Index, DeclsLoaded.size())) {
      assert (false) : "declaration ID out-of-range for AST file";
      Error(new StringRef(/*KEEP_STR*/"declaration ID out-of-range for AST file"));
      return null;
    }
    if (!(DeclsLoaded.$at(Index) != null)) {
      ReadDeclRecord(ID);
      if ((DeserializationListener != null)) {
        DeserializationListener.DeclRead(ID, DeclsLoaded.$at(Index));
      }
    }
    
    return DeclsLoaded.$at(Index);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetExternalDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6222,
   FQN="clang::ASTReader::GetExternalDecl", NM="_ZN5clang9ASTReader15GetExternalDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15GetExternalDeclEj")
  //</editor-fold>
  @Override public Decl /*P*/ GetExternalDecl(/*uint32_t*/long ID)/* override*/ {
    return GetDecl((int)ID);
  }

  
  /// \brief Resolve a declaration ID into a declaration. Return 0 if it's not
  /// been loaded yet.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetExistingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6432,
   FQN="clang::ASTReader::GetExistingDecl", NM="_ZN5clang9ASTReader15GetExistingDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15GetExistingDeclEj")
  //</editor-fold>
  public Decl /*P*/ GetExistingDecl(/*uint32_t*/int ID) {
    if ($less_uint(ID, NUM_PREDEF_DECL_IDS)) {
      Decl /*P*/ D = getPredefinedDecl(Context, ID);
      if ((D != null)) {
        // Track that we have merged the declaration with ID \p ID into the
        // pre-existing predefined declaration \p D.
        final SmallVectorUInt /*&*/ Merged = KeyDecls.$at_T1$RR(D.getCanonicalDecl());
        if (Merged.empty()) {
          Merged.push_back(ID);
        }
      }
      return D;
    }
    
    /*uint*/int Index = ID - NUM_PREDEF_DECL_IDS;
    if ($greatereq_uint(Index, DeclsLoaded.size())) {
      assert (false) : "declaration ID out-of-range for AST file";
      Error(new StringRef(/*KEEP_STR*/"declaration ID out-of-range for AST file"));
      return null;
    }
    
    return DeclsLoaded.$at(Index);
  }

  
  /// \brief Reads a declaration with the given local ID in the given module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetLocalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1671,
   FQN="clang::ASTReader::GetLocalDecl", NM="_ZN5clang9ASTReader12GetLocalDeclERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12GetLocalDeclERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public Decl /*P*/ GetLocalDecl(final ModuleFile /*&*/ F, /*uint32_t*/int LocalID) {
    return GetDecl(getGlobalDeclID(F, LocalID));
  }

  
  /// \brief Reads a declaration with the given local ID in the given module.
  ///
  /// \returns The requested declaration, casted to the given return type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetLocalDeclAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1679,
   FQN="clang::ASTReader::GetLocalDeclAs", NM="Tpl__ZN5clang9ASTReader14GetLocalDeclAsERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang9ASTReader14GetLocalDeclAsERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ GetLocalDeclAs(Class<T> cls, final ModuleFile /*&*/ F, /*uint32_t*/int LocalID) {
    return cast_or_null(cls, GetLocalDecl(F, LocalID));
  }

  
  /// \brief Map a global declaration ID into the declaration ID used to 
  /// refer to this declaration within the given module fule.
  ///
  /// \returns the global ID of the given declaration as known in the given
  /// module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::mapGlobalIDToModuleFileGlobalID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6477,
   FQN="clang::ASTReader::mapGlobalIDToModuleFileGlobalID", NM="_ZN5clang9ASTReader31mapGlobalIDToModuleFileGlobalIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader31mapGlobalIDToModuleFileGlobalIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int mapGlobalIDToModuleFileGlobalID(final ModuleFile /*&*/ M, 
                                 /*uint32_t*/int GlobalID) {
    if ($less_uint(GlobalID, NUM_PREDEF_DECL_IDS)) {
      return GlobalID;
    }
    
    type$ptr</*const*/std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalDeclMap.find(GlobalID));
    assert ($noteq_ptr(I, GlobalDeclMap.end())) : "Corrupted global declaration map";
    ModuleFile /*P*/ Owner = I./*->*/$star().second;
    
    DenseMapIteratorTypeUInt<ModuleFile /*P*/ /*P*/> Pos = M.GlobalToLocalDeclIDs.find(Owner);
    if (Pos.$eq(/*NO_ITER_COPY*/M.GlobalToLocalDeclIDs.end())) {
      return 0;
    }
    
    return GlobalID - Owner.BaseDeclID + Pos.$arrow().second;
  }

  
  /// \brief Reads a declaration ID from the given position in a record in the
  /// given module.
  ///
  /// \returns The declaration ID read from the record, adjusted to a global ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDeclID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6494,
   FQN="clang::ASTReader::ReadDeclID", NM="_ZN5clang9ASTReader10ReadDeclIDERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10ReadDeclIDERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public /*uint32_t*/int ReadDeclID(final ModuleFile /*&*/ F, 
            final /*const*/SmallVectorULong /*&*/ Record, 
            final uint$ref/*uint &*/ Idx) {
    if ($greatereq_uint(Idx.$deref(), Record.size())) {
      Error(new StringRef(/*KEEP_STR*/"Corrupted AST file"));
      return 0;
    }
    
    return getGlobalDeclID(F, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  
  /// \brief Reads a declaration from the given position in a record in the
  /// given module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1701,
   FQN="clang::ASTReader::ReadDecl", NM="_ZN5clang9ASTReader8ReadDeclERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader8ReadDeclERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public Decl /*P*/ ReadDecl(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return GetDecl(ReadDeclID(F, R, I));
  }

  
  /// \brief Reads a declaration from the given position in a record in the
  /// given module.
  ///
  /// \returns The declaration read from this location, casted to the given
  /// result type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDeclAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1711,
   FQN="clang::ASTReader::ReadDeclAs", NM="Tpl__ZN5clang9ASTReader10ReadDeclAsERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang9ASTReader10ReadDeclAsERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ ReadDeclAs(Class<T> cls, final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ R, final uint$ref/*uint &*/ I) {
    return cast_or_null(cls, GetDecl(ReadDeclID(F, R, I)));
  }

  
  /// \brief If any redeclarations of \p D have been imported since it was
  /// last checked, this digs out those redeclarations and adds them to the
  /// redeclaration chain for \p D.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::CompleteRedeclChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6232,
   FQN="clang::ASTReader::CompleteRedeclChain", NM="_ZN5clang9ASTReader19CompleteRedeclChainEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19CompleteRedeclChainEPKNS_4DeclE")
  //</editor-fold>
  @Override public void CompleteRedeclChain(/*const*/ Decl /*P*/ D)/* override*/ {
    if ((NumCurrentElementsDeserializing != 0)) {
      // We arrange to not care about the complete redeclaration chain while we're
      // deserializing. Just remember that the AST has marked this one as complete
      // but that it's not actually complete yet, so we know we still need to
      // complete it later.
      PendingIncompleteDeclChains.push_back(((/*const_cast*/Decl /*P*/ )(D)));
      return;
    }
    
    /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const().getRedeclContext$Const();
    
    // If this is a named declaration, complete it by looking it up
    // within its context.
    //
    // FIXME: Merging a function definition should merge
    // all mergeable entities within it.
    if (isa_TranslationUnitDecl(DC) || isa_NamespaceDecl(DC)
       || isa_CXXRecordDecl(DC) || isa_EnumDecl(DC)) {
      {
        DeclarationName Name = cast_NamedDecl(D).getDeclName();
        if (Name.$bool()) {
          if (!getContext().getLangOpts().CPlusPlus
             && isa_TranslationUnitDecl(DC)) {
            // Outside of C++, we don't have a lookup table for the TU, so update
            // the identifier instead. (For C++ modules, we don't store decls
            // in the serialized identifier table, so we do the lookup in the TU.)
            IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
            assert ((II != null)) : "non-identifier name in C?";
            if (II.isOutOfDate()) {
              updateOutOfDateIdentifier($Deref(II));
            }
          } else {
            DC.lookup(new DeclarationName(Name));
          }
        } else if (needsAnonymousDeclarationNumber(cast_NamedDecl(D))) {
          // Find all declarations of this kind from the relevant context.
          for (Decl /*P*/ DCDecl : cast_Decl(D.getLexicalDeclContext$Const()).decl_redecls()) {
            DeclContext /*P*/ DC$1 = cast_DeclContext(DCDecl);
            SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(8, null);
            FindExternalLexicalDecls(DC$1, /*FuncArg*//*[&, &D]*/ (Decl.Kind K) -> {
                      return K == D.getKind();
                    }, Decls);
          }
        }
      }
    }
    {
      
      /*const*/ ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_ClassTemplateSpecializationDecl(D);
      if ((CTSD != null)) {
        CTSD.getSpecializedTemplate().LoadLazySpecializations();
      }
    }
    {
      /*const*/ VarTemplateSpecializationDecl /*P*/ VTSD = dyn_cast_VarTemplateSpecializationDecl(D);
      if ((VTSD != null)) {
        VTSD.getSpecializedTemplate().LoadLazySpecializations();
      }
    }
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        {
          FunctionTemplateDecl /*P*/ Template = FD.getPrimaryTemplate();
          if ((Template != null)) {
            Template.LoadLazySpecializations();
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetExternalCXXBaseSpecifiers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6304,
   FQN="clang::ASTReader::GetExternalCXXBaseSpecifiers", NM="_ZN5clang9ASTReader28GetExternalCXXBaseSpecifiersEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader28GetExternalCXXBaseSpecifiersEy")
  //</editor-fold>
  @Override public type$ptr<CXXBaseSpecifier /*P*/> GetExternalCXXBaseSpecifiers(long/*uint64_t*/ Offset)/* override*/ {
    SavedStreamPosition SavedPosition = null;
    ReadingKindTracker ReadingKind = null;
    try {
      RecordLocation Loc = getLocalBitOffset(Offset);
      final BitstreamCursor /*&*/ Cursor = Loc.F.DeclsCursor;
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(Loc.Offset);
      ReadingKind/*J*/= new ReadingKindTracker(ASTReader.ReadingKind.Read_Decl, /*Deref*/this);
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      /*uint*/int Code = Cursor.ReadCode();
      /*uint*/int RecCode = Cursor.readRecord(Code, Record);
      if (RecCode != DeclCode.DECL_CXX_BASE_SPECIFIERS) {
        Error(new StringRef(/*KEEP_STR*/"malformed AST file: missing C++ base specifiers"));
        return null;
      }
      
      uint$ref Idx = create_uint$ref(0);
      /*uint*/int NumBases = $ullong2uint(Record.$at(Idx.$set$postInc()));
      //Object/*void P*/ Mem = Context.Allocate($sizeof_CXXBaseSpecifier() * NumBases);
      type$ptr<CXXBaseSpecifier /*P*/> Bases = /*((JCast CXXBaseSpecifier P )(NEW_EXPR [System] Mem = new (Mem)*/ /*FIXME 2: $array_new_uint_voidPtr*/create_type$ptr(new CXXBaseSpecifier [NumBases]);
      for (/*uint*/int I = 0; I != NumBases; ++I)  {
        Bases.$set(I, new CXXBaseSpecifier());
        Bases.$at(I).$assignMove(ReadCXXBaseSpecifier($Deref(Loc.F), Record, Idx));
      }
      return Bases;
    } finally {
      if (ReadingKind != null) { ReadingKind.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  
  /// \brief Resolve the offset of a statement into a statement.
  ///
  /// This operation will read a new statement from the external
  /// source each time it is called, and is meant to be used via a
  /// LazyOffsetPtr (which is used by Decls for the body of functions, etc).
  
  /// \brief Resolve the offset of a statement into a statement.
  ///
  /// This operation will read a new statement from the external
  /// source each time it is called, and is meant to be used via a
  /// LazyOffsetPtr (which is used by Decls for the body of functions, etc).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetExternalDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6510,
   FQN="clang::ASTReader::GetExternalDeclStmt", NM="_ZN5clang9ASTReader19GetExternalDeclStmtEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19GetExternalDeclStmtEy")
  //</editor-fold>
  @Override public Stmt /*P*/ GetExternalDeclStmt(long/*uint64_t*/ Offset)/* override*/ {
    // Switch case IDs are per Decl.
    ClearSwitchCaseIDs();
    
    // Offset here is a global offset across the entire chain.
    RecordLocation Loc = getLocalBitOffset(Offset);
    Loc.F.DeclsCursor.JumpToBit(Loc.Offset);
    return ReadStmtFromStream($Deref(Loc.F));
  }

  
  /// ReadBlockAbbrevs - Enter a subblock of the specified BlockID with the
  /// specified cursor.  Read the abbreviations that are at the top of the block
  /// and then leave the cursor pointing into the block.
  
  /// ReadBlockAbbrevs - Enter a subblock of the specified BlockID with the
  /// specified cursor.  Read the abbreviations that are at the top of the block
  /// and then leave the cursor pointing into the block.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadBlockAbbrevs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1380,
   FQN="clang::ASTReader::ReadBlockAbbrevs", NM="_ZN5clang9ASTReader16ReadBlockAbbrevsERN4llvm15BitstreamCursorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16ReadBlockAbbrevsERN4llvm15BitstreamCursorEj")
  //</editor-fold>
  public static boolean ReadBlockAbbrevs(final BitstreamCursor /*&*/ Cursor, /*uint*/int BlockID) {
    if (Cursor.EnterSubBlock(BlockID)) {
      return true;
    }
    while (true) {
      long/*uint64_t*/ Offset = Cursor.GetCurrentBitNo();
      /*uint*/int Code = Cursor.ReadCode();
      
      // We expect all abbrevs to be at the start of the block.
      if (Code != FixedAbbrevIDs.DEFINE_ABBREV) {
        Cursor.JumpToBit(Offset);
        return false;
      }
      Cursor.ReadAbbrevRecord();
    }
  }

  
  /// \brief Finds all the visible declarations with a given name.
  /// The current implementation of this method just loads the entire
  /// lookup table as unmaterialized references.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FindExternalVisibleDeclsByName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6639,
   FQN="clang::ASTReader::FindExternalVisibleDeclsByName", NM="_ZN5clang9ASTReader30FindExternalVisibleDeclsByNameEPKNS_11DeclContextENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader30FindExternalVisibleDeclsByNameEPKNS_11DeclContextENS_15DeclarationNameE")
  //</editor-fold>
  @Override public boolean FindExternalVisibleDeclsByName(/*const*/ DeclContext /*P*/ DC, 
                                DeclarationName Name)/* override*/ {
    ExternalASTSource.Deserializing LookupResults = null;
    try {
      assert (DC.hasExternalVisibleStorage() && DC == DC.getPrimaryContext$Const()) : "DeclContext has no visible decls in storage";
      if (!Name.$bool()) {
        return false;
      }
      
      DenseMapIterator</*const*/ DeclContext /*P*/ , DeclContextLookupTable> It = Lookups.find(DC);
      if (It.$eq(/*NO_ITER_COPY*/Lookups.end())) {
        return false;
      }
      
      LookupResults/*J*/= new ExternalASTSource.Deserializing(this);
      
      // Load the list of declarations.
      SmallVector<NamedDecl /*P*/ > Decls/*J*/= new SmallVector<NamedDecl /*P*/ >(64, (NamedDecl /*P*/ )null);
      for (/*uint32_t*/int ID : It.$arrow().second.Table.find(Name)) {
        NamedDecl /*P*/ ND = cast_NamedDecl(GetDecl(ID));
        if (DeclarationName.$eq_DeclarationName(ND.getDeclName(), /*NO_COPY*/Name)) {
          Decls.push_back(ND);
        }
      }
      
      ++NumVisibleDeclContextsRead;
      ExternalASTSource.SetExternalVisibleDeclsForName(DC, new DeclarationName(Name), new ArrayRef<NamedDecl /*P*/ >(Decls, true));
      return !Decls.empty();
    } finally {
      if (LookupResults != null) { LookupResults.$destroy(); }
    }
  }

  
  /// \brief Read all of the declarations lexically stored in a
  /// declaration context.
  ///
  /// \param DC The declaration context whose declarations will be
  /// read.
  ///
  /// \param IsKindWeWant A predicate indicating which declaration kinds
  /// we are interested in.
  ///
  /// \param Decls Vector that will contain the declarations loaded
  /// from the external source. The caller is responsible for merging
  /// these declarations with any declarations already stored in the
  /// declaration context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FindExternalLexicalDecls">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6520,
   FQN="clang::ASTReader::FindExternalLexicalDecls", NM="_ZN5clang9ASTReader24FindExternalLexicalDeclsEPKNS_11DeclContextEN4llvm12function_refIFbNS_4Decl4KindEEEERNS4_15SmallVectorImplIPS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24FindExternalLexicalDeclsEPKNS_11DeclContextEN4llvm12function_refIFbNS_4Decl4KindEEEERNS4_15SmallVectorImplIPS6_EE")
  //</editor-fold>
  @Override public void FindExternalLexicalDecls(/*const*/ DeclContext /*P*/ DC, DeclKind2Bool IsKindWeWant, 
                          final SmallVectorImpl<Decl /*P*/ > /*&*/ Decls)/* override*/ {
    boolean PredefsVisited[/*17*/] = new boolean[17];//new$bool(17, /*zero-init*/0);
    
    ModuleFileLexicalContents2Void Visit = /*[&, &IsKindWeWant, &PredefsVisited, this, &DC, &Decls]*/ (ModuleFile /*P*/ M, ArrayRefUInt/*<unaligned_uint32_t>*/ LexicalDecls) -> {
          assert ($rem_uint(LexicalDecls.size(), 2) == 0) : "expected an even number of entries";
          for (int I = 0, N = LexicalDecls.size(); I != N; I += 2) {
            Decl.Kind K = Decl.Kind.valueOf((int)LexicalDecls.$at(I)/*.$value()*/);
            if (!IsKindWeWant.$call(/*KEEP_ENUM*/K)) {
              continue;
            }
            
            /*uint32_t*/int ID = (/*uint32_t*/int)+LexicalDecls.$at(I + 1)/*.$value()*/;
            
            // Don't add predefined declarations to the lexical context more
            // than once.
            if ($less_uint(ID, NUM_PREDEF_DECL_IDS)) {
              if (PredefsVisited[ID]) {
                continue;
              }
              
              PredefsVisited[ID] = true;
            }
            {
              
              Decl /*P*/ D = GetLocalDecl($Deref(M), ID);
              if ((D != null)) {
                assert (D.getKind() == K) : "wrong kind for lexical decl";
                if (!DC.isDeclInLexicalTraversal(D)) {
                  Decls.push_back(D);
                }
              }
            }
          }
        };
    if (isa_TranslationUnitDecl(DC)) {
      for (std.pairPtrType<ModuleFile /*P*/ , ArrayRefUInt/*<unaligned_uint32_t>*/> Lexical : TULexicalDecls)  {
        Visit.$call(Lexical.first, /*NO_COPY*/Lexical.second);
      }
    } else {
      DenseMapIterator<DeclContext, pairPtrType<ModuleFile, ArrayRefUInt/*<unaligned_uint32_t>*/>> I = LexicalDecls.find(DC);
      if (I.$noteq(/*NO_ITER_COPY*/LexicalDecls.end())) {
        Visit.$call(I.$arrow().second.first, /*NO_COPY*/I.$arrow().second.second);
      }
    }
    
    ++NumLexicalDeclContextsRead;
  }

  
  /// \brief Get the decls that are contained in a file in the Offset/Length
  /// range. \p Length can be 0 to indicate a point at \p Offset instead of
  /// a range.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FindFileRegionDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6596,
   FQN="clang::ASTReader::FindFileRegionDecls", NM="_ZN5clang9ASTReader19FindFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19FindFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE")
  //</editor-fold>
  @Override public void FindFileRegionDecls(FileID File, 
                     /*uint*/int Offset, /*uint*/int Length, 
                     final SmallVectorImpl<Decl /*P*/ > /*&*/ Decls)/* override*/ {
    final SourceManager /*&*/ SM = getSourceManager();
    
    DenseMapIterator<FileID, FileDeclsInfo> I = FileDeclIDs.find(File);
    if (I.$eq(/*NO_ITER_COPY*/FileDeclIDs.end())) {
      return;
    }
    
    final FileDeclsInfo /*&*/ DInfo = I.$arrow().second;
    if (DInfo.Decls.empty()) {
      return;
    }
    
    SourceLocation BeginLoc = SM.getLocForStartOfFile(/*NO_COPY*/File).getLocWithOffset(Offset);
    SourceLocation EndLoc = BeginLoc.getLocWithOffset(Length);
    
    DeclIDComp DIDComp/*J*/= new DeclIDComp(/*Deref*/this, $Deref(DInfo.Mod));
    /*const*/uint$ptr/*uint P*/ BeginIt = $tryClone(std.lower_bound(DInfo.Decls.begin(), DInfo.Decls.end(), 
        BeginLoc, new DeclIDComp(DIDComp)));
    if ($noteq_ptr(BeginIt, DInfo.Decls.begin())) {
      BeginIt.$preDec();
    }
    
    // If we are pointing at a top-level decl inside an objc container, we need
    // to backtrack until we find it otherwise we will fail to report that the
    // region overlaps with an objc container.
    while ($noteq_ptr(BeginIt, DInfo.Decls.begin())
       && GetDecl(getGlobalDeclID($Deref(DInfo.Mod), BeginIt.$star())).
        isTopLevelDeclInObjCContainer()) {
      BeginIt.$preDec();
    }
    
    /*const*/uint$ptr/*uint P*/ EndIt = $tryClone(std.upper_bound(DInfo.Decls.begin(), DInfo.Decls.end(), 
        EndLoc, new DeclIDComp(DIDComp)));
    if ($noteq_ptr(EndIt, DInfo.Decls.end())) {
      EndIt.$preInc();
    }
    
    for (/*const*/uint$ptr/*uint P*/ DIt = $tryClone(BeginIt); $noteq_ptr(DIt, EndIt); DIt.$preInc())  {
      Decls.push_back(GetDecl(getGlobalDeclID($Deref(DInfo.Mod), DIt.$star())));
    }
  }

  
  /// \brief Notify ASTReader that we started deserialization of
  /// a decl or type so until FinishedDeserializing is called there may be
  /// decls that are initializing. Must be paired with FinishedDeserializing.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::StartedDeserializing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8619,
   FQN="clang::ASTReader::StartedDeserializing", NM="_ZN5clang9ASTReader20StartedDeserializingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20StartedDeserializingEv")
  //</editor-fold>
  @Override public void StartedDeserializing()/* override*/ {
    if (++NumCurrentElementsDeserializing == 1 && (ReadTimer.get() != null)) {
      ReadTimer.$arrow().startTimer();
    }
  }

  
  /// \brief Notify ASTReader that we finished the deserialization of
  /// a decl or type. Must be paired with StartedDeserializing.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::FinishedDeserializing">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8624,
   FQN="clang::ASTReader::FinishedDeserializing", NM="_ZN5clang9ASTReader21FinishedDeserializingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader21FinishedDeserializingEv")
  //</editor-fold>
  @Override public void FinishedDeserializing()/* override*/ {
    assert ((NumCurrentElementsDeserializing != 0)) : "FinishedDeserializing not paired with StartedDeserializing";
    if (NumCurrentElementsDeserializing == 1) {
      // We decrease NumCurrentElementsDeserializing only after pending actions
      // are finished, to avoid recursively re-calling finishPendingActions().
      finishPendingActions();
    }
    --NumCurrentElementsDeserializing;
    if (NumCurrentElementsDeserializing == 0) {
      // Propagate exception specification updates along redeclaration chains.
      while (!PendingExceptionSpecUpdates.empty()) {
        SmallMapVectorPtrPtr<Decl /*P*/ , FunctionDecl /*P*/ > Updates = null;
        try {
          Updates = new SmallMapVectorPtrPtr<Decl /*P*/ , FunctionDecl /*P*/ >(JD$Move.INSTANCE, std.move(PendingExceptionSpecUpdates));
          PendingExceptionSpecUpdates.clear();
          for (pair<Decl,FunctionDecl> Update : Updates) {
            ProcessingUpdatesRAIIObj ProcessingUpdates = null;
            try {
              ProcessingUpdates/*J*/= new ProcessingUpdatesRAIIObj(/*Deref*/this);
              /*const*/ FunctionProtoType /*P*/ FPT = Update.second.getType().$arrow().castAs(FunctionProtoType.class);
              FunctionProtoType.ExceptionSpecInfo ESI = new FunctionProtoType.ExceptionSpecInfo(JD$Move.INSTANCE, FPT.getExtProtoInfo().ExceptionSpec);
              {
                ASTMutationListener /*P*/ Listener = Context.getASTMutationListener();
                if ((Listener != null)) {
                  Listener.ResolvedExceptionSpec(cast_FunctionDecl(Update.second));
                }
              }
              for (FunctionDecl /*P*/ Redecl : Update.second.redeclarable_redecls())  {
                Context.adjustExceptionSpec(cast_FunctionDecl(Redecl), ESI);
              }
            } finally {
              if (ProcessingUpdates != null) { ProcessingUpdates.$destroy(); }
            }
          }
        } finally {
          if (Updates != null) { Updates.$destroy(); }
        }
      }
      if (ReadTimer.$bool()) {
        ReadTimer.$arrow().stopTimer();
      }
      
      diagnoseOdrViolations();
      
      // We are not in recursive loading, so it's safe to pass the "interesting"
      // decls to the consumer.
      if ((Consumer != null)) {
        PassInterestingDeclsToConsumer();
      }
    }
  }

  
  /// \brief Function that will be invoked when we begin parsing a new
  /// translation unit involving this external AST source.
  ///
  /// This function will provide all of the external definitions to
  /// the ASTConsumer.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::StartTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6741,
   FQN="clang::ASTReader::StartTranslationUnit", NM="_ZN5clang9ASTReader20StartTranslationUnitEPNS_11ASTConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20StartTranslationUnitEPNS_11ASTConsumerE")
  //</editor-fold>
  @Override public void StartTranslationUnit(ASTConsumer /*P*/ Consumer)/* override*/ {
    this.Consumer = Consumer;
    if ((Consumer != null)) {
      PassInterestingDeclsToConsumer();
    }
    if ((DeserializationListener != null)) {
      DeserializationListener.ReaderInitialized(this);
    }
  }

  
  /// \brief Print some statistics about AST usage.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6751,
   FQN="clang::ASTReader::PrintStats", NM="_ZN5clang9ASTReader10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10PrintStatsEv")
  //</editor-fold>
  @Override public void PrintStats()/* override*/ {
    std.fprintf(stderr, /*KEEP_STR*/"*** AST File Statistics:\n");
    
    /*uint*/int NumTypesLoaded = TypesLoaded.size() - std.count(TypesLoaded.begin(), TypesLoaded.end(), 
        new QualType());
    /*uint*/int NumDeclsLoaded = DeclsLoaded.size() - std.count(DeclsLoaded.begin(), DeclsLoaded.end(), 
        (Decl /*P*/ )(Decl /*P*/ )null);
    /*uint*/int NumIdentifiersLoaded = IdentifiersLoaded.size() - std.count(IdentifiersLoaded.begin(), 
        IdentifiersLoaded.end(), 
        (IdentifierInfo /*P*/ )(IdentifierInfo /*P*/ )null);
    /*uint*/int NumMacrosLoaded = MacrosLoaded.size() - std.count(MacrosLoaded.begin(), 
        MacrosLoaded.end(), 
        (MacroInfo /*P*/ )(MacroInfo /*P*/ )null);
    /*uint*/int NumSelectorsLoaded = SelectorsLoaded.size() - std.count(SelectorsLoaded.begin(), 
        SelectorsLoaded.end(), 
        new Selector());
    {
      
      /*uint*/int TotalNumSLocEntries = getTotalNumSLocs();
      if ((TotalNumSLocEntries != 0)) {
        std.fprintf(stderr, /*KEEP_STR*/"  %u/%u source location entries read (%f%%)\n", 
            NumSLocEntriesRead, TotalNumSLocEntries, 
            ((float)NumSLocEntriesRead / TotalNumSLocEntries * 100));
      }
    }
    if (!TypesLoaded.empty()) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u types read (%f%%)\n", 
          NumTypesLoaded, (/*uint*/int)TypesLoaded.size(), 
          ((float)NumTypesLoaded / TypesLoaded.size() * 100));
    }
    if (!DeclsLoaded.empty()) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u declarations read (%f%%)\n", 
          NumDeclsLoaded, (/*uint*/int)DeclsLoaded.size(), 
          ((float)NumDeclsLoaded / DeclsLoaded.size() * 100));
    }
    if (!IdentifiersLoaded.empty()) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u identifiers read (%f%%)\n", 
          NumIdentifiersLoaded, (/*uint*/int)IdentifiersLoaded.size(), 
          ((float)NumIdentifiersLoaded / IdentifiersLoaded.size() * 100));
    }
    if (!MacrosLoaded.empty()) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u macros read (%f%%)\n", 
          NumMacrosLoaded, (/*uint*/int)MacrosLoaded.size(), 
          ((float)NumMacrosLoaded / MacrosLoaded.size() * 100));
    }
    if (!SelectorsLoaded.empty()) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u selectors read (%f%%)\n", 
          NumSelectorsLoaded, (/*uint*/int)SelectorsLoaded.size(), 
          ((float)NumSelectorsLoaded / SelectorsLoaded.size() * 100));
    }
    if ((TotalNumStatements != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u statements read (%f%%)\n", 
          NumStatementsRead, TotalNumStatements, 
          ((float)NumStatementsRead / TotalNumStatements * 100));
    }
    if ((TotalNumMacros != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u macros read (%f%%)\n", 
          NumMacrosRead, TotalNumMacros, 
          ((float)NumMacrosRead / TotalNumMacros * 100));
    }
    if ((TotalLexicalDeclContexts != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u lexical declcontexts read (%f%%)\n", 
          NumLexicalDeclContextsRead, TotalLexicalDeclContexts, 
          ((float)NumLexicalDeclContextsRead / TotalLexicalDeclContexts
             * 100));
    }
    if ((TotalVisibleDeclContexts != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u visible declcontexts read (%f%%)\n", 
          NumVisibleDeclContextsRead, TotalVisibleDeclContexts, 
          ((float)NumVisibleDeclContextsRead / TotalVisibleDeclContexts
             * 100));
    }
    if ((TotalNumMethodPoolEntries != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u method pool entries read (%f%%)\n", 
          NumMethodPoolEntriesRead, TotalNumMethodPoolEntries, 
          ((float)NumMethodPoolEntriesRead / TotalNumMethodPoolEntries
             * 100));
    }
    if ((NumMethodPoolLookups != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u method pool lookups succeeded (%f%%)\n", 
          NumMethodPoolHits, NumMethodPoolLookups, 
          ((float)NumMethodPoolHits / NumMethodPoolLookups * 100.));
    }
    if ((NumMethodPoolTableLookups != 0)) {
      std.fprintf(stderr, /*KEEP_STR*/"  %u/%u method pool table lookups succeeded (%f%%)\n", 
          NumMethodPoolTableHits, NumMethodPoolTableLookups, 
          ((float)NumMethodPoolTableHits / NumMethodPoolTableLookups
             * 100.));
    }
    if ((NumIdentifierLookupHits != 0)) {
      std.fprintf(stderr, 
          /*KEEP_STR*/"  %u / %u identifier table lookups succeeded (%f%%)\n", 
          NumIdentifierLookupHits, NumIdentifierLookups, 
          (double)NumIdentifierLookupHits * 100. / NumIdentifierLookups);
    }
    if (GlobalIndex.$bool()) {
      std.fprintf(stderr, /*KEEP_STR*/"\n");
      GlobalIndex.$arrow().printStats();
    }
    
    std.fprintf(stderr, /*KEEP_STR*/"\n");
    dump();
    std.fprintf(stderr, /*KEEP_STR*/"\n");
  }

  
  /// \brief Dump information about the AST reader to standard error.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6867,
   FQN="clang::ASTReader::dump", NM="_ZN5clang9ASTReader4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    llvm.errs().$out(/*KEEP_STR*/"*** PCH/ModuleFile Remappings:\n");
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global bit offset map"), GlobalBitOffsetsMap);
    dumpModuleIDMap(64, new StringRef(/*KEEP_STR*/"Global source location entry map"), GlobalSLocEntryMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global type map"), GlobalTypeMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global declaration map"), GlobalDeclMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global identifier map"), GlobalIdentifierMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global macro map"), GlobalMacroMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global submodule map"), GlobalSubmoduleMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global selector map"), GlobalSelectorMap);
    dumpModuleIDMap(4, new StringRef(/*KEEP_STR*/"Global preprocessed entity map"), 
        GlobalPreprocessedEntityMap);
    
    llvm.errs().$out(/*KEEP_STR*/"\n*** PCH/Modules Loaded:");
    for (type$ptr<ModuleFile /*P*/ /*P*/> M = $tryClone(ModuleMgr.begin()), 
        /*P*/ MEnd = $tryClone(ModuleMgr.end());
         $noteq_ptr(M, MEnd); M.$preInc())  {
      (M.$star()).dump();
    }
  }

  
  /// Return the amount of memory used by memory buffers, breaking down
  /// by heap-backed versus mmap'ed memory.
  
  /// Return the amount of memory used by memory buffers, breaking down
  /// by heap-backed versus mmap'ed memory.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getMemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6889,
   FQN="clang::ASTReader::getMemoryBufferSizes", NM="_ZNK5clang9ASTReader20getMemoryBufferSizesERNS_17ExternalASTSource17MemoryBufferSizesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader20getMemoryBufferSizesERNS_17ExternalASTSource17MemoryBufferSizesE")
  //</editor-fold>
  @Override public void getMemoryBufferSizes(final ExternalASTSource.MemoryBufferSizes /*&*/ sizes) /*const*//* override*/ {
    for (type$ptr<ModuleFile /*P*/ /*P*/> I = $tryClone(ModuleMgr.begin$Const()), 
        /*P*/ E = $tryClone(ModuleMgr.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      {
        MemoryBuffer /*P*/ buf = (I.$star()).Buffer.get();
        if ((buf != null)) {
          /*size_t*/int bytes = buf.getBufferSize();
          switch (buf.getBufferKind()) {
           case MemoryBuffer_Malloc:
            sizes.malloc_bytes += bytes;
            break;
           case MemoryBuffer_MMap:
            sizes.mmap_bytes += bytes;
            break;
          }
        }
      }
    }
  }

  
  /// \brief Initialize the semantic source with the Sema instance
  /// being used to perform semantic analysis on the abstract syntax
  /// tree.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::InitializeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6906,
   FQN="clang::ASTReader::InitializeSema", NM="_ZN5clang9ASTReader14InitializeSemaERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14InitializeSemaERNS_4SemaE")
  //</editor-fold>
  @Override public void InitializeSema(final Sema /*&*/ S)/* override*/ {
    SemaObj = $AddrOf(S);
    S.addExternalSource(this);
    
    // Makes sure any declarations that were deserialized "too early"
    // still get added to the identifier's declaration chains.
    for (long/*uint64_t*/ ID : PreloadedDeclIDs) {
      NamedDecl /*P*/ D = cast_NamedDecl(GetDecl($ulong2uint(ID)));
      pushExternalDeclIntoScope(D, D.getDeclName());
    }
    PreloadedDeclIDs.clear();
    
    // FIXME: What happens if these are changed by a module import?
    if (!FPPragmaOptions.empty()) {
      assert (FPPragmaOptions.size() == 1) : "Wrong number of FP_PRAGMA_OPTIONS";
      SemaObj.FPFeatures.fp_contract = $uint2uint_1bit($ullong2uint(FPPragmaOptions.$at(0)));
    }
    
    // FIXME: What happens if these are changed by a module import?
    if (!OpenCLExtensions.empty()) {
      /*uint*/int I = 0;
      // OPENCLEXT_INTERNAL
      
      // OpenCL 1.0.
      SemaObj.OpenCLFeatures.cl_khr_3d_image_writes = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      // fprounding mode is special since it is not mentioned beyond 1.0
      SemaObj.OpenCLFeatures.cl_khr_select_fprounding_mode = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_byte_addressable_store = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_fp16 = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_fp64 = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_global_int32_base_atomics = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_global_int32_extended_atomics = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_local_int32_base_atomics = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_local_int32_extended_atomics = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_int64_base_atomics = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_int64_extended_atomics = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_gl_sharing = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_icd = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      
      // OpenCL 1.1.
      SemaObj.OpenCLFeatures.cl_khr_gl_event = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_d3d10_sharing = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      
      // OpenCL 1.2.
      SemaObj.OpenCLFeatures.cl_khr_context_abort = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_d3d11_sharing = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_depth_images = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_dx9_media_sharing = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_image2d_from_buffer = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_initialize_memory = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_gl_depth_images = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_gl_msaa_sharing = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_spir = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      
      // OpenCL 2.0.
      SemaObj.OpenCLFeatures.cl_khr_egl_event = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_egl_image = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_srgb_image_writes = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_subgroups = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      SemaObj.OpenCLFeatures.cl_khr_terminate_context = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      
      // Clang Extensions.
      SemaObj.OpenCLFeatures.cl_clang_storage_class_specifiers = $uint2uint_1bit($ullong2uint(OpenCLExtensions.$at(I++)));
      assert (OpenCLExtensions.size() == I) : "Wrong number of OPENCL_EXTENSIONS";
    }
    
    UpdateSema();
  }

  
  /// \brief Inform the semantic consumer that Sema is no longer available.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ForgetSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1796,
   FQN="clang::ASTReader::ForgetSema", NM="_ZN5clang9ASTReader10ForgetSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10ForgetSemaEv")
  //</editor-fold>
  @Override public void ForgetSema()/* override*/ {
    SemaObj = null;
  }

  
  /// \brief Retrieve the IdentifierInfo for the named identifier.
  ///
  /// This routine builds a new IdentifierInfo for the given identifier. If any
  /// declarations with this name are visible from translation unit scope, their
  /// declarations will be deserialized and introduced into the declaration
  /// chain of the identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6966,
   FQN="clang::ASTReader::get", NM="_ZN5clang9ASTReader3getEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader3getEN4llvm9StringRefE")
  //</editor-fold>
  @Override public IdentifierInfo /*P*/ get(StringRef Name)/* override*/ {
    ExternalASTSource.Deserializing AnIdentifier = null;
    try {
      // Note that we are loading an identifier.
      AnIdentifier/*J*/= new ExternalASTSource.Deserializing(this);
      
      IdentifierLookupVisitor Visitor/*J*/= new IdentifierLookupVisitor(new StringRef(Name), /*PriorGeneration=*/ 0, 
          NumIdentifierLookups_ref, 
          NumIdentifierLookupHits_ref);
      
      // We don't need to do identifier table lookups in C++ modules (we preload
      // all interesting declarations, and don't need to use the scope for name
      // lookups). Perform the lookup in PCH files, though, since we don't build
      // a complete initial identifier table if we're carrying on from a PCH.
      if (Context.getLangOpts().CPlusPlus) {
        for (ModuleFile /*P*/ F : ModuleMgr.pch_modules())  {
          if (Visitor.$call($Deref(F))) {
            break;
          }
        }
      } else {
        // If there is a global index, look there first to determine which modules
        // provably do not have any results for this identifier.
        SmallPtrSet<ModuleFile /*P*/> Hits/*J*/= new SmallPtrSet<ModuleFile /*P*/>(DenseMapInfo$LikePtr.$Info(), 4);
        SmallPtrSet<ModuleFile /*P*/> /*P*/ HitsPtr = null;
        if (!loadGlobalIndex()) {
          if (GlobalIndex.$arrow().lookupIdentifier(new StringRef(Name), Hits)) {
            HitsPtr = $AddrOf(Hits);
          }
        }
        
        ModuleMgr.visit(/*FuncArg*/Visitor, HitsPtr);
      }
      
      IdentifierInfo /*P*/ II = Visitor.getIdentifierInfo();
      markIdentifierUpToDate(II);
      return II;
    } finally {
      if (AnIdentifier != null) { AnIdentifier.$destroy(); }
    }
  }

  
  /// \brief Retrieve an iterator into the set of all identifiers
  /// in all loaded AST files.
  // end anonymous namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7087,
   FQN="clang::ASTReader::getIdentifiers", NM="_ZN5clang9ASTReader14getIdentifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14getIdentifiersEv")
  //</editor-fold>
  @Override public IdentifierIterator /*P*/ getIdentifiers()/* override*/ {
    if (!loadGlobalIndex()) {
      std.unique_ptr<IdentifierIterator> ReaderIter = null;
      std.unique_ptr<IdentifierIterator> ModulesIter = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ReaderIter/*J*/= new std.unique_ptr<IdentifierIterator>(new ASTIdentifierIterator(/*Deref*/this, /*SkipModules=*/ true));
        ModulesIter/*J*/= new std.unique_ptr<IdentifierIterator>(GlobalIndex.$arrow().createIdentifierIterator());
        return $c$.clean(new ChainedIdentifierIterator($c$.track(new std.unique_ptr<IdentifierIterator>(JD$Move.INSTANCE, std.move(ReaderIter))), 
            $c$.track(new std.unique_ptr<IdentifierIterator>(JD$Move.INSTANCE, std.move(ModulesIter)))));
      } finally {
        if (ModulesIter != null) { ModulesIter.$destroy(); }
        if (ReaderIter != null) { ReaderIter.$destroy(); }
        $c$.$destroy();
      }
    }
    
    return new ASTIdentifierIterator(/*Deref*/this);
  }

  
  /// \brief Load the contents of the global method pool for a given
  /// selector.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadMethodPool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7180,
   FQN="clang::ASTReader::ReadMethodPool", NM="_ZN5clang9ASTReader14ReadMethodPoolENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14ReadMethodPoolENS_8SelectorE")
  //</editor-fold>
  @Override public void ReadMethodPool(Selector Sel)/* override*/ {
    ReadMethodPoolVisitor Visitor = null;
    try {
      // Get the selector generation and update it to the current generation.
      final uint$ref/*uint &*/ Generation = SelectorGeneration.ref$at(Sel);
      /*uint*/int PriorGeneration = Generation.$deref();
      Generation.$set(getGeneration());
      SelectorOutOfDate.$set(Sel, false);
      
      // Search for methods defined with this selector.
      ++NumMethodPoolLookups;
      Visitor/*J*/= new ReadMethodPoolVisitor(/*Deref*/this, new Selector(Sel), PriorGeneration);
      ModuleMgr.visit(/*FuncArg*/Visitor);
      if (Visitor.getInstanceMethods().empty()
         && Visitor.getFactoryMethods().empty()) {
        return;
      }
      
      ++NumMethodPoolHits;
      if (!(getSema() != null)) {
        return;
      }
      
      final Sema /*&*/ S = $Deref(getSema());
      DenseMapIterator<Selector,std.pair<ObjCMethodList,ObjCMethodList>> Pos = new DenseMapIterator<Selector, std.pair<ObjCMethodList, ObjCMethodList>>(
              JD$Move.INSTANCE, S.MethodPool.insert_pair$KeyT$ValueT(
                      std.make_pair($Clone(Sel), 
                              $Move(new std.pairTypeType<ObjCMethodList, ObjCMethodList>()))).first);
      
      Pos.$arrow().second.first.setBits(Visitor.getInstanceBits());
      Pos.$arrow().second.first.setHasMoreThanOneDecl(Visitor.instanceHasMoreThanOneDecl());
      Pos.$arrow().second.second.setBits(Visitor.getFactoryBits());
      Pos.$arrow().second.second.setHasMoreThanOneDecl(Visitor.factoryHasMoreThanOneDecl());
      
      // Add methods to the global pool *after* setting hasMoreThanOneDecl, since
      // when building a module we keep every method individually and may need to
      // update hasMoreThanOneDecl as we add the methods.
      addMethodsToPool(S, Visitor.getInstanceMethods(), Pos.$arrow().second.first);
      addMethodsToPool(S, Visitor.getFactoryMethods(), Pos.$arrow().second.second);
    } finally {
      if (Visitor != null) { Visitor.$destroy(); }
    }
  }

  
  /// Load the contents of the global method pool for a given
  /// selector if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::updateOutOfDateSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7217,
   FQN="clang::ASTReader::updateOutOfDateSelector", NM="_ZN5clang9ASTReader23updateOutOfDateSelectorENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23updateOutOfDateSelectorENS_8SelectorE")
  //</editor-fold>
  @Override public void updateOutOfDateSelector(Selector Sel)/* override*/ {
    if (SelectorOutOfDate.$at_T1$C$R(Sel)) {
      ReadMethodPool(new Selector(Sel));
    }
  }

  
  /// \brief Load the set of namespaces that are known to the external source,
  /// which will be used during typo correction.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadKnownNamespaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7222,
   FQN="clang::ASTReader::ReadKnownNamespaces", NM="_ZN5clang9ASTReader19ReadKnownNamespacesERN4llvm15SmallVectorImplIPNS_13NamespaceDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19ReadKnownNamespacesERN4llvm15SmallVectorImplIPNS_13NamespaceDeclEEE")
  //</editor-fold>
  @Override public void ReadKnownNamespaces(final SmallVectorImpl<NamespaceDecl /*P*/ > /*&*/ Namespaces)/* override*/ {
    Namespaces.clear();
    
    for (/*uint*/int I = 0, N = KnownNamespaces.size(); I != N; ++I) {
      {
        NamespaceDecl /*P*/ Namespace = dyn_cast_or_null_NamespaceDecl(GetDecl($ullong2uint(KnownNamespaces.$at(I))));
        if ((Namespace != null)) {
          Namespaces.push_back(Namespace);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadUndefinedButUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7233,
   FQN="clang::ASTReader::ReadUndefinedButUsed", NM="_ZN5clang9ASTReader20ReadUndefinedButUsedERN4llvm9MapVectorIPNS_9NamedDeclENS_14SourceLocationENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S5_ESaISF_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20ReadUndefinedButUsedERN4llvm9MapVectorIPNS_9NamedDeclENS_14SourceLocationENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S5_ESaISF_EEEE")
  //</editor-fold>
  @Override public void ReadUndefinedButUsed(final MapVectorPtrType<NamedDecl /*P*/ , SourceLocation> /*&*/ Undefined)/* override*/ {
    for (/*uint*/int Idx = 0, N = UndefinedButUsed.size(); Idx != N;) {
      NamedDecl /*P*/ D = cast_NamedDecl(GetDecl($ullong2uint(UndefinedButUsed.$at(Idx++))));
      SourceLocation Loc = SourceLocation.getFromRawEncoding($ullong2uint(UndefinedButUsed.$at(Idx++)));
      Undefined.insert(std.make_pair_Ptr_T(D, $Clone(Loc)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadMismatchingDeleteExpressions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7243,
   FQN="clang::ASTReader::ReadMismatchingDeleteExpressions", NM="_ZN5clang9ASTReader32ReadMismatchingDeleteExpressionsERN4llvm9MapVectorIPNS_9FieldDeclENS1_11SmallVectorISt4pairINS_14SourceLocationEbELj4EEENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorIS6_IS4_S9_ESaISI_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader32ReadMismatchingDeleteExpressionsERN4llvm9MapVectorIPNS_9FieldDeclENS1_11SmallVectorISt4pairINS_14SourceLocationEbELj4EEENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorIS6_IS4_S9_ESaISI_EEEE")
  //</editor-fold>
  @Override public void ReadMismatchingDeleteExpressions(final MapVectorPtrType<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> > /*&*/ Exprs)/* override*/ {
    for (/*uint*/int Idx = 0, N = DelayedDeleteExprs.size(); Idx != N;) {
      FieldDecl /*P*/ FD = cast_FieldDecl(GetDecl($ullong2uint(DelayedDeleteExprs.$at(Idx++))));
      long/*uint64_t*/ Count = DelayedDeleteExprs.$at(Idx++);
      for (long/*uint64_t*/ C = $int2ulong(0); $less_ulong(C, Count); ++C) {
        SourceLocation DeleteLoc = SourceLocation.getFromRawEncoding($ullong2uint(DelayedDeleteExprs.$at(Idx++)));
        /*const*/boolean IsArrayForm = (DelayedDeleteExprs.$at(Idx++) != 0);
        Exprs.$at(FD).push_back(std.make_pair_T_bool($Clone(DeleteLoc), IsArrayForm));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadTentativeDefinitions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7258,
   FQN="clang::ASTReader::ReadTentativeDefinitions", NM="_ZN5clang9ASTReader24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIPNS_7VarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIPNS_7VarDeclEEE")
  //</editor-fold>
  @Override public void ReadTentativeDefinitions(final SmallVectorImpl<VarDecl /*P*/ > /*&*/ TentativeDefs)/* override*/ {
    for (/*uint*/int I = 0, N = TentativeDefinitions.size(); I != N; ++I) {
      VarDecl /*P*/ Var = dyn_cast_or_null_VarDecl(GetDecl($ullong2uint(TentativeDefinitions.$at(I))));
      if ((Var != null)) {
        TentativeDefs.push_back(Var);
      }
    }
    TentativeDefinitions.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadUnusedFileScopedDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7268,
   FQN="clang::ASTReader::ReadUnusedFileScopedDecls", NM="_ZN5clang9ASTReader25ReadUnusedFileScopedDeclsERN4llvm15SmallVectorImplIPKNS_14DeclaratorDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25ReadUnusedFileScopedDeclsERN4llvm15SmallVectorImplIPKNS_14DeclaratorDeclEEE")
  //</editor-fold>
  @Override public void ReadUnusedFileScopedDecls(final SmallVectorImpl</*const*/ DeclaratorDecl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*uint*/int I = 0, N = UnusedFileScopedDecls.size(); I != N; ++I) {
      DeclaratorDecl /*P*/ D = dyn_cast_or_null_DeclaratorDecl(GetDecl($ullong2uint(UnusedFileScopedDecls.$at(I))));
      if ((D != null)) {
        Decls.push_back(D);
      }
    }
    UnusedFileScopedDecls.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDelegatingConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7279,
   FQN="clang::ASTReader::ReadDelegatingConstructors", NM="_ZN5clang9ASTReader26ReadDelegatingConstructorsERN4llvm15SmallVectorImplIPNS_18CXXConstructorDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader26ReadDelegatingConstructorsERN4llvm15SmallVectorImplIPNS_18CXXConstructorDeclEEE")
  //</editor-fold>
  @Override public void ReadDelegatingConstructors(final SmallVectorImpl<CXXConstructorDecl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*uint*/int I = 0, N = DelegatingCtorDecls.size(); I != N; ++I) {
      CXXConstructorDecl /*P*/ D = dyn_cast_or_null_CXXConstructorDecl(GetDecl($ullong2uint(DelegatingCtorDecls.$at(I))));
      if ((D != null)) {
        Decls.push_back(D);
      }
    }
    DelegatingCtorDecls.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadExtVectorDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7290,
   FQN="clang::ASTReader::ReadExtVectorDecls", NM="_ZN5clang9ASTReader18ReadExtVectorDeclsERN4llvm15SmallVectorImplIPNS_15TypedefNameDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadExtVectorDeclsERN4llvm15SmallVectorImplIPNS_15TypedefNameDeclEEE")
  //</editor-fold>
  @Override public void ReadExtVectorDecls(final SmallVectorImpl<TypedefNameDecl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*uint*/int I = 0, N = ExtVectorDecls.size(); I != N; ++I) {
      TypedefNameDecl /*P*/ D = dyn_cast_or_null_TypedefNameDecl(GetDecl($ullong2uint(ExtVectorDecls.$at(I))));
      if ((D != null)) {
        Decls.push_back(D);
      }
    }
    ExtVectorDecls.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadUnusedLocalTypedefNameCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7300,
   FQN="clang::ASTReader::ReadUnusedLocalTypedefNameCandidates", NM="_ZN5clang9ASTReader36ReadUnusedLocalTypedefNameCandidatesERN4llvm14SmallSetVectorIPKNS_15TypedefNameDeclELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader36ReadUnusedLocalTypedefNameCandidatesERN4llvm14SmallSetVectorIPKNS_15TypedefNameDeclELj4EEE")
  //</editor-fold>
  @Override public void ReadUnusedLocalTypedefNameCandidates(final SmallSetVector</*const*/ TypedefNameDecl /*P*/> /*&*/ Decls)/* override*/ {
    for (/*uint*/int I = 0, N = UnusedLocalTypedefNameCandidates.size(); I != N;
         ++I) {
      TypedefNameDecl /*P*/ D = dyn_cast_or_null_TypedefNameDecl(GetDecl($ullong2uint(UnusedLocalTypedefNameCandidates.$at(I))));
      if ((D != null)) {
        Decls.insert(D);
      }
    }
    UnusedLocalTypedefNameCandidates.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadReferencedSelectors">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7312,
   FQN="clang::ASTReader::ReadReferencedSelectors", NM="_ZN5clang9ASTReader23ReadReferencedSelectorsERN4llvm15SmallVectorImplISt4pairINS_8SelectorENS_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23ReadReferencedSelectorsERN4llvm15SmallVectorImplISt4pairINS_8SelectorENS_14SourceLocationEEEE")
  //</editor-fold>
  @Override public void ReadReferencedSelectors(final SmallVectorImpl<std.pairTypeType<Selector, SourceLocation> > /*&*/ Sels)/* override*/ {
    if (ReferencedSelectorsData.empty()) {
      return;
    }
    
    // If there are @selector references added them to its pool. This is for
    // implementation of -Wselector.
    /*uint*/int DataSize = ReferencedSelectorsData.size() - 1;
    /*uint*/int I = 0;
    while ($less_uint(I, DataSize)) {
      Selector Sel = DecodeSelector($ullong2uint(ReferencedSelectorsData.$at(I++)));
      SourceLocation SelLoc = SourceLocation.getFromRawEncoding($ullong2uint(ReferencedSelectorsData.$at(I++)));
      Sels.push_back(std.make_pair($Clone(Sel), $Clone(SelLoc)));
    }
    ReferencedSelectorsData.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadWeakUndeclaredIdentifiers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7330,
   FQN="clang::ASTReader::ReadWeakUndeclaredIdentifiers", NM="_ZN5clang9ASTReader29ReadWeakUndeclaredIdentifiersERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoENS_8WeakInfoEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader29ReadWeakUndeclaredIdentifiersERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoENS_8WeakInfoEEEE")
  //</editor-fold>
  @Override public void ReadWeakUndeclaredIdentifiers(final SmallVectorImpl<std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo> > /*&*/ WeakIDs)/* override*/ {
    if (WeakUndeclaredIdentifiers.empty()) {
      return;
    }
    
    for (/*uint*/int I = 0, N = WeakUndeclaredIdentifiers.size(); $less_uint(I, N);) {
      IdentifierInfo /*P*/ WeakId = DecodeIdentifierInfo($ullong2uint(WeakUndeclaredIdentifiers.$at(I++)));
      IdentifierInfo /*P*/ AliasId = DecodeIdentifierInfo($ullong2uint(WeakUndeclaredIdentifiers.$at(I++)));
      SourceLocation Loc = SourceLocation.getFromRawEncoding($ullong2uint(WeakUndeclaredIdentifiers.$at(I++)));
      boolean Used = (WeakUndeclaredIdentifiers.$at(I++) != 0);
      WeakInfo WI/*J*/= new WeakInfo(AliasId, new SourceLocation(Loc));
      WI.setUsed(Used);
      WeakIDs.push_back(std.make_pair_Ptr_T(WeakId, $Clone(WI)));
    }
    WeakUndeclaredIdentifiers.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadUsedVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7350,
   FQN="clang::ASTReader::ReadUsedVTables", NM="_ZN5clang9ASTReader15ReadUsedVTablesERN4llvm15SmallVectorImplINS_17ExternalVTableUseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15ReadUsedVTablesERN4llvm15SmallVectorImplINS_17ExternalVTableUseEEE")
  //</editor-fold>
  @Override public void ReadUsedVTables(final SmallVectorImpl<ExternalVTableUse> /*&*/ VTables)/* override*/ {
    for (/*uint*/int Idx = 0, N = VTableUses.size(); $less_uint(Idx, N);) {
      ExternalVTableUse VT/*J*/= new ExternalVTableUse();
      VT.Record = dyn_cast_or_null_CXXRecordDecl(GetDecl($ullong2uint(VTableUses.$at(Idx++))));
      VT.Location.$assignMove(SourceLocation.getFromRawEncoding($ullong2uint(VTableUses.$at(Idx++))));
      VT.DefinitionRequired = (VTableUses.$at(Idx++) != 0);
      VTables.push_back(VT);
    }
    
    VTableUses.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadPendingInstantiations">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7362,
   FQN="clang::ASTReader::ReadPendingInstantiations", NM="_ZN5clang9ASTReader25ReadPendingInstantiationsERN4llvm15SmallVectorImplISt4pairIPNS_9ValueDeclENS_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25ReadPendingInstantiationsERN4llvm15SmallVectorImplISt4pairIPNS_9ValueDeclENS_14SourceLocationEEEE")
  //</editor-fold>
  @Override public void ReadPendingInstantiations(final SmallVectorImpl<std.pair<ValueDecl /*P*/ , SourceLocation> > /*&*/ Pending)/* override*/ {
    for (/*uint*/int Idx = 0, N = PendingInstantiations.size(); $less_uint(Idx, N);) {
      ValueDecl /*P*/ D = cast_ValueDecl(GetDecl($ullong2uint(PendingInstantiations.$at(Idx++))));
      SourceLocation Loc = SourceLocation.getFromRawEncoding($ullong2uint(PendingInstantiations.$at(Idx++)));
      
      Pending.push_back(std.make_pair_Ptr_T(D, $Clone(Loc)));
    }
    PendingInstantiations.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadLateParsedTemplates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7374,
   FQN="clang::ASTReader::ReadLateParsedTemplates", NM="_ZN5clang9ASTReader23ReadLateParsedTemplatesERN4llvm9MapVectorIPKNS_12FunctionDeclEPNS_18LateParsedTemplateENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23ReadLateParsedTemplatesERN4llvm9MapVectorIPKNS_12FunctionDeclEPNS_18LateParsedTemplateENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE")
  //</editor-fold>
  @Override public void ReadLateParsedTemplates(final MapVectorPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ > /*&*/ LPTMap)/* override*/ {
    int N = LateParsedTemplates.size();
    for (uint$ref Idx = create_uint$ref(0); $less_uint(Idx.$deref(), N);) {
      FunctionDecl /*P*/ FD = cast_FunctionDecl(GetDecl($ullong2uint(LateParsedTemplates.$at(Idx.$set$postInc()))));
      
      LateParsedTemplate /*P*/ LT = new LateParsedTemplate();
      LT.D = GetDecl($ullong2uint(LateParsedTemplates.$at(Idx.$set$postInc())));
      
      ModuleFile /*P*/ F = getOwningModuleFile(LT.D);
      assert ((F != null)) : "No module";
      
      /*uint*/int TokN = $ullong2uint(LateParsedTemplates.$at(Idx.$set$postInc()));
      LT.Toks.reserve(TokN);
      for (/*uint*/int T = 0; $less_uint(T, TokN); ++T)  {
        LT.Toks.push_back(ReadToken($Deref(F), LateParsedTemplates, Idx));
      }
      
      LPTMap.insert(new std.pairPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/FD, /*Fwd2*//*Fwd*/LT));
    }
    
    LateParsedTemplates.clear();
  }

  
  /// \brief Load a selector from disk, registering its ID if it exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::LoadSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7397,
   FQN="clang::ASTReader::LoadSelector", NM="_ZN5clang9ASTReader12LoadSelectorENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12LoadSelectorENS_8SelectorE")
  //</editor-fold>
  public void LoadSelector(Selector Sel) {
    // It would be complicated to avoid reading the methods anyway. So don't.
    ReadMethodPool(new Selector(Sel));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::SetIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7402,
   FQN="clang::ASTReader::SetIdentifierInfo", NM="_ZN5clang9ASTReader17SetIdentifierInfoEjPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17SetIdentifierInfoEjPNS_14IdentifierInfoE")
  //</editor-fold>
  public void SetIdentifierInfo(/*uint32_t*/int ID, IdentifierInfo /*P*/ II) {
    assert ((ID != 0)) : "Non-zero identifier ID required";
    assert ($lesseq_uint(ID, IdentifiersLoaded.size())) : "identifier ID out of range";
    IdentifiersLoaded.$set(ID - 1, II);
    if ((DeserializationListener != null)) {
      DeserializationListener.IdentifierRead(ID, II);
    }
  }

  
  /// \brief Set the globally-visible declarations associated with the given
  /// identifier.
  ///
  /// If the AST reader is currently in a state where the given declaration IDs
  /// cannot safely be resolved, they are queued until it is safe to resolve
  /// them.
  ///
  /// \param II an IdentifierInfo that refers to one or more globally-visible
  /// declarations.
  ///
  /// \param DeclIDs the set of declaration IDs with the name @p II that are
  /// visible at global scope.
  ///
  /// \param Decls if non-null, this vector will be populated with the set of
  /// deserialized declarations. These declarations will not be pushed into
  /// scope.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::SetGloballyVisibleDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7426,
   FQN="clang::ASTReader::SetGloballyVisibleDecls", NM="_ZN5clang9ASTReader23SetGloballyVisibleDeclsEPNS_14IdentifierInfoERKN4llvm15SmallVectorImplIjEEPNS4_IPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23SetGloballyVisibleDeclsEPNS_14IdentifierInfoERKN4llvm15SmallVectorImplIjEEPNS4_IPNS_4DeclEEE")
  //</editor-fold>
  public void SetGloballyVisibleDecls(IdentifierInfo /*P*/ II, 
                         final /*const*/SmallVectorImplUInt /*&*/ DeclIDs) {
    SetGloballyVisibleDecls(II, 
                         DeclIDs, 
                         (SmallVectorImpl<Decl /*P*/ > /*P*/ )null);
  }
  public void SetGloballyVisibleDecls(IdentifierInfo /*P*/ II, 
                         final /*const*/SmallVectorImplUInt /*&*/ DeclIDs, 
                         SmallVectorImpl<Decl /*P*/ > /*P*/ Decls/*= null*/) {
    if ((NumCurrentElementsDeserializing != 0) && !(Decls != null)) {
      PendingIdentifierInfos.$at(II).append_T(DeclIDs.begin$Const(), DeclIDs.end$Const());
      return;
    }
    
    for (/*uint*/int I = 0, N = DeclIDs.size(); I != N; ++I) {
      if (!(SemaObj != null)) {
        // Queue this declaration so that it will be added to the
        // translation unit scope and identifier's declaration chain
        // once a Sema object is known.
        PreloadedDeclIDs.push_back($uint2ullong(DeclIDs.$at$Const(I)));
        continue;
      }
      
      NamedDecl /*P*/ D = cast_NamedDecl(GetDecl(DeclIDs.$at$Const(I)));
      
      // If we're simply supposed to record the declarations, do so now.
      if ((Decls != null)) {
        Decls.push_back(D);
        continue;
      }
      
      // Introduce this declaration into the translation-unit scope
      // and add it to the declaration chain for this identifier, so
      // that (unqualified) name lookup will find it.
      pushExternalDeclIntoScope(D, new DeclarationName(II));
    }
  }

  
  /// \brief Report a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8207,
   FQN="clang::ASTReader::Diag", NM="_ZN5clang9ASTReader4DiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader4DiagEj")
  //</editor-fold>
  public DiagnosticBuilder Diag(/*uint*/int DiagID) {
    return Diag(new SourceLocation(CurrentImportLoc), DiagID);
  }

  
  /// \brief Report a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8211,
   FQN="clang::ASTReader::Diag", NM="_ZN5clang9ASTReader4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader4DiagENS_14SourceLocationEj")
  //</editor-fold>
  public DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) {
    return Diags.Report(/*NO_COPY*/Loc, DiagID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::DecodeIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7459,
   FQN="clang::ASTReader::DecodeIdentifierInfo", NM="_ZN5clang9ASTReader20DecodeIdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20DecodeIdentifierInfoEj")
  //</editor-fold>
  public IdentifierInfo /*P*/ DecodeIdentifierInfo(/*uint32_t*/int ID) {
    if (ID == 0) {
      return null;
    }
    if (IdentifiersLoaded.empty()) {
      Error(new StringRef(/*KEEP_STR*/"no identifier table in AST file"));
      return null;
    }
    
    ID -= 1;
    if (!(IdentifiersLoaded.$at(ID) != null)) {
      type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalIdentifierMap.find(ID + 1));
      assert ($noteq_ptr(I, GlobalIdentifierMap.end())) : "Corrupted global identifier map";
      ModuleFile /*P*/ M = I./*->*/$star().second;
      /*uint*/int Index = ID - M.BaseIdentifierID;
      /*const*/char$ptr/*char P*/ Str = $toConst(M.IdentifierTableData.$add(M.IdentifierOffsets.$at(Index)));
      
      // All of the strings in the AST file are preceded by a 16-bit length.
      // Extract that 16-bit length to avoid having to execute strlen().
      // NOTE: 'StrLenPtr' is an 'unsigned char*' so that we load bytes as
      //  unsigned integers.  This is important to avoid integer overflow when
      //  we cast them to 'unsigned'.
      // JAVA PERF: array-based get
      /*const*/int/*uchar P*/ StrLenPtr = (-2);
      /*uint*/int StrLen = (((/*uint*/int)$uchar2uint(Str.$at(StrLenPtr)))
         | (((/*uint*/int)$uchar2uint(Str.$at(StrLenPtr+1))) << 8)) - 1;
      final IdentifierInfo /*&*/ II = PP.getIdentifierTable().get(Str.$array(), Str.$index(), StrLen);
      IdentifiersLoaded.$set(ID, $AddrOf(II));
      markIdentifierFromAST(/*Deref*/this, II);
      if ((DeserializationListener != null)) {
        DeserializationListener.IdentifierRead(ID + 1, $AddrOf(II));
      }
    }
    
    return IdentifiersLoaded.$at(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1876,
   FQN="clang::ASTReader::GetIdentifierInfo", NM="_ZN5clang9ASTReader17GetIdentifierInfoERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17GetIdentifierInfoERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public IdentifierInfo /*P*/ GetIdentifierInfo(final ModuleFile /*&*/ M, final /*const*/SmallVectorULong /*&*/ Record, 
                   final uint$ref/*uint &*/ Idx) {
    return DecodeIdentifierInfo(getGlobalIdentifierID(M, $ullong2uint(Record.$at$Const(Idx.$set$postInc()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1881,
   FQN="clang::ASTReader::GetIdentifier", NM="_ZN5clang9ASTReader13GetIdentifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13GetIdentifierEj")
  //</editor-fold>
  @Override public IdentifierInfo /*P*/ GetIdentifier(/*uint32_t*/int ID)/* override*/ {
    ExternalASTSource.Deserializing AnIdentifier = null;
    try {
      // Note that we are loading an identifier.
      AnIdentifier/*J*/= new ExternalASTSource.Deserializing(this);
      
      return DecodeIdentifierInfo(ID);
    } finally {
      if (AnIdentifier != null) { AnIdentifier.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getLocalIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7494,
   FQN="clang::ASTReader::getLocalIdentifier", NM="_ZN5clang9ASTReader18getLocalIdentifierERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18getLocalIdentifierERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public IdentifierInfo /*P*/ getLocalIdentifier(final ModuleFile /*&*/ M, /*uint*/int LocalID) {
    return DecodeIdentifierInfo(getGlobalIdentifierID(M, LocalID));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalIdentifierID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7498,
   FQN="clang::ASTReader::getGlobalIdentifierID", NM="_ZN5clang9ASTReader21getGlobalIdentifierIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader21getGlobalIdentifierIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalIdentifierID(final ModuleFile /*&*/ M, /*uint*/int LocalID) {
    if ($less_uint(LocalID, NUM_PREDEF_IDENT_IDS)) {
      return LocalID;
    }
    
    type$ptr<std.pairUIntInt /*P*/> I = $tryClone(M.IdentifierRemap.find(LocalID - NUM_PREDEF_IDENT_IDS));
    assert ($noteq_ptr(I, M.IdentifierRemap.end())) : "Invalid index into identifier index remap";
    
    return LocalID + I./*->*/$star().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::resolvePendingMacro">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1791,
   FQN="clang::ASTReader::resolvePendingMacro", NM="_ZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoE")
  //</editor-fold>
  public void resolvePendingMacro(IdentifierInfo /*P*/ II, 
                     final /*const*/ PendingMacroInfo /*&*/ PMInfo) {
    SavedStreamPosition SavedPosition = null;
    SmallVector<resolvePendingMacro$$.ModuleMacroRecord> ModuleMacros = null;
    try {
      final ModuleFile /*&*/ M = $Deref(PMInfo.M);
      
      final BitstreamCursor /*&*/ Cursor = M.MacroCursor;
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(PMInfo.MacroDirectivesOffset);
      
      ;
      ModuleMacros/*J*/= new SmallVector<resolvePendingMacro$$.ModuleMacroRecord>(8, new resolvePendingMacro$$.ModuleMacroRecord());
      
      // We expect to see a sequence of PP_MODULE_MACRO records listing exported
      // macros, followed by a PP_MACRO_DIRECTIVE_HISTORY record with the complete
      // macro histroy.
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      while (true) {
        BitstreamEntry Entry = Cursor.advance(BitstreamCursor.Unnamed_enum.AF_DontPopBlockAtEnd.getValue());
        if (Entry.Kind != BitstreamEntry.Unnamed_enum.Record) {
          Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
          return;
        }
        
        Record.clear();
        switch (Cursor.readRecord(Entry.ID, Record)) {
         case PreprocessorRecordTypes.PP_MACRO_DIRECTIVE_HISTORY:
          break;
         case PreprocessorRecordTypes.PP_MODULE_MACRO:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              ModuleMacros.push_back_T$RR($c$.track(new resolvePendingMacro$$.ModuleMacroRecord())); $c$.clean();
              final resolvePendingMacro$$.ModuleMacroRecord /*&*/ Info = ModuleMacros.back();
              Info.SubModID = getGlobalSubmoduleID(M, $ullong2uint(Record.$at(0)));
              Info.MI = getMacro(getGlobalMacroID(M, $ullong2uint(Record.$at(1))));
              for (int I = 2, N = Record.size(); I != N; ++I)  {
                Info.Overrides.push_back(getGlobalSubmoduleID(M, $ullong2uint(Record.$at(I))));
              }
              continue;
            } finally {
              $c$.$destroy();
            }
          }
         default:
          Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
          return;
        }
        
        // We found the macro directive history; that's the last record
        // for this macro.
        break;
      }
      {
        std.reverse(ModuleMacros.begin(), ModuleMacros.end());
        SmallVector<ModuleMacro /*P*/ > Overrides/*J*/= new SmallVector<ModuleMacro /*P*/ >(8, (ModuleMacro /*P*/ )null);
        for (final resolvePendingMacro$$.ModuleMacroRecord /*&*/ MMR : ModuleMacros) {
          Overrides.clear();
          for (/*uint*/int ModID : MMR.Overrides) {
            Module /*P*/ Mod = getSubmodule(ModID);
            ModuleMacro /*P*/ Macro = PP.getModuleMacro(Mod, II);
            assert ((Macro != null)) : "missing definition for overridden macro";
            Overrides.push_back(Macro);
          }
          
          bool$ref Inserted = create_bool$ref(false);
          Module /*P*/ Owner = getSubmodule(MMR.SubModID);
          PP.addModuleMacro(Owner, II, MMR.MI, new ArrayRef<ModuleMacro /*P*/ >(Overrides, true), Inserted);
        }
      }
      
      // Don't read the directive history for a module; we don't have anywhere
      // to put it.
      if (M.Kind == ModuleKind.MK_ImplicitModule || M.Kind == ModuleKind.MK_ExplicitModule) {
        return;
      }
      
      // Deserialize the macro directives history in reverse source-order.
      MacroDirective /*P*/ Latest = null;
      MacroDirective /*P*/ Earliest = null;
      uint$ref Idx = create_uint$ref(0);
      /*uint*/int N = Record.size();
      while ($less_uint(Idx.$deref(), N)) {
        MacroDirective /*P*/ MD = null;
        SourceLocation Loc = ReadSourceLocation(M, Record, Idx);
        MacroDirective.Kind K = MacroDirective.Kind.valueOf((int)Record.$at(Idx.$set$postInc()));
        switch (K) {
         case MD_Define:
          {
            MacroInfo /*P*/ MI = getMacro(getGlobalMacroID(M, $ullong2uint(Record.$at(Idx.$set$postInc()))));
            MD = PP.AllocateDefMacroDirective(MI, /*NO_COPY*/Loc);
            break;
          }
         case MD_Undefine:
          {
            MD = PP.AllocateUndefMacroDirective(/*NO_COPY*/Loc);
            break;
          }
         case MD_Visibility:
          boolean isPublic = (Record.$at(Idx.$set$postInc()) != 0);
          MD = PP.AllocateVisibilityMacroDirective(/*NO_COPY*/Loc, isPublic);
          break;
        }
        if (!(Latest != null)) {
          Latest = MD;
        }
        if ((Earliest != null)) {
          Earliest.setPrevious(MD);
        }
        Earliest = MD;
      }
      if ((Latest != null)) {
        PP.setLoadedMacroDirective(II, Latest);
      }
    } finally {
      if (ModuleMacros != null) { ModuleMacros.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }
  private static final class resolvePendingMacro$$ {
    static //<editor-fold defaultstate="collapsed" desc="ModuleMacroRecord">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1799,
     FQN="ModuleMacroRecord", NM="_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEE17ModuleMacroRecord",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEE17ModuleMacroRecord")
    //</editor-fold>
     class/*struct*/ ModuleMacroRecord implements Destructors.ClassWithDestructor, NativePOD<ModuleMacroRecord>, NativeMoveable<ModuleMacroRecord> {
      public /*uint32_t*/int SubModID;
      public MacroInfo /*P*/ MI;
      public SmallVectorUInt Overrides;
      //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::ModuleMacroRecord">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1799,
       FQN="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::ModuleMacroRecord", NM="_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordC1EOS6_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordC1EOS6_")
      //</editor-fold>
      public /*inline*/ ModuleMacroRecord(JD$Move _dparam, final ModuleMacroRecord /*&&*/$Prm0) {
        // : SubModID(static_cast<ModuleMacroRecord &&>().SubModID), MI(static_cast<ModuleMacroRecord &&>().MI), Overrides(static_cast<ModuleMacroRecord &&>().Overrides) 
        //START JInit
        this.SubModID = $Prm0.SubModID;
        this.MI = $Prm0.MI;
        this.Overrides = new SmallVectorUInt(JD$Move.INSTANCE, $Prm0.Overrides);
        //END JInit
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1799,
       FQN="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::operator=", NM="_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordaSEOS6_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordaSEOS6_")
      //</editor-fold>
      public /*inline*/ ModuleMacroRecord /*&*/ $assignMove(final ModuleMacroRecord /*&&*/$Prm0) {
        this.SubModID = $Prm0.SubModID;
        this.MI = $Prm0.MI;
        this.Overrides.$assignMove($Prm0.Overrides);
        return /*Deref*/this;
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::ModuleMacroRecord">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1799,
       FQN="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::ModuleMacroRecord", NM="_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordC1Ev")
      //</editor-fold>
      public /*inline*/ ModuleMacroRecord() {
        // : Overrides() 
        //START JInit
        this.Overrides = new SmallVectorUInt(8, (/*uint32_t*/int)0);
        //END JInit
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::~ModuleMacroRecord">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1799,
       FQN="clang::ASTReader::resolvePendingMacro(IdentifierInfo * , const PendingMacroInfo & )::ModuleMacroRecord::~ModuleMacroRecord", NM="_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZZN5clang9ASTReader19resolvePendingMacroEPNS_14IdentifierInfoERKNS0_16PendingMacroInfoEEN17ModuleMacroRecordD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        //START JDestroy
        Overrides.$destroy();
        //END JDestroy
      }
    
      public /*inline*/ ModuleMacroRecord /*&*/ $assign(final ModuleMacroRecord /*&&*/$Prm0) {
        this.SubModID = $Prm0.SubModID;
        this.MI = $Prm0.MI;
        this.Overrides.$assign($Prm0.Overrides);
        return /*Deref*/this;
      }
      
      @Override public ModuleMacroRecord clone() {
        return new ModuleMacroRecord().$assign(this);
      }
    
      @Override public ModuleMacroRecord move() {
        return new ModuleMacroRecord(JD$Move.INSTANCE, this);
      }
      
      @Override public String toString() {
        return "" + "SubModID=" + SubModID // NOI18N
                  + ", MI=" + MI // NOI18N
                  + ", Overrides=" + Overrides; // NOI18N
      }
    };
  }

  
  /// \brief Retrieve the macro with the given ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7510,
   FQN="clang::ASTReader::getMacro", NM="_ZN5clang9ASTReader8getMacroEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader8getMacroEj")
  //</editor-fold>
  public MacroInfo /*P*/ getMacro(/*uint32_t*/int ID) {
    if (ID == 0) {
      return null;
    }
    if (MacrosLoaded.empty()) {
      Error(new StringRef(/*KEEP_STR*/"no macro table in AST file"));
      return null;
    }
    
    ID -= NUM_PREDEF_MACRO_IDS;
    if (!(MacrosLoaded.$at(ID) != null)) {
      type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalMacroMap.find(ID + NUM_PREDEF_MACRO_IDS));
      assert ($noteq_ptr(I, GlobalMacroMap.end())) : "Corrupted global macro map";
      ModuleFile /*P*/ M = I./*->*/$star().second;
      /*uint*/int Index = ID - M.BaseMacroID;
      MacrosLoaded.$set(ID, ReadMacroRecord($Deref(M), $uint2ulong(M.MacroOffsets.$at(Index))));
      if ((DeserializationListener != null)) {
        DeserializationListener.MacroRead(ID + NUM_PREDEF_MACRO_IDS, 
            MacrosLoaded.$at(ID));
      }
    }
    
    return MacrosLoaded.$at(ID);
  }

  
  /// \brief Retrieve the global macro ID corresponding to the given local
  /// ID within the given module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalMacroID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7536,
   FQN="clang::ASTReader::getGlobalMacroID", NM="_ZN5clang9ASTReader16getGlobalMacroIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16getGlobalMacroIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalMacroID(final ModuleFile /*&*/ M, /*uint*/int LocalID) {
    if ($less_uint(LocalID, NUM_PREDEF_MACRO_IDS)) {
      return LocalID;
    }
    
    type$ptr<std.pairUIntInt /*P*/> I = $tryClone(M.MacroRemap.find(LocalID - NUM_PREDEF_MACRO_IDS));
    assert ($noteq_ptr(I, M.MacroRemap.end())) : "Invalid index into macro index remap";
    
    return LocalID + I./*->*/$star().second;
  }

  
  /// \brief Read the source location entry with index ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSLocEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1203,
   FQN="clang::ASTReader::ReadSLocEntry", NM="_ZN5clang9ASTReader13ReadSLocEntryEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13ReadSLocEntryEi")
  //</editor-fold>
  @Override public boolean ReadSLocEntry(int ID)/* override*/ {
    if (ID == 0) {
      return false;
    }
    if ($greatereq_uint(((/*uint*/int)(-ID)) - 2, getTotalNumSLocs()) || ID > 0) {
      Error(new StringRef(/*KEEP_STR*/"source location entry ID out-of-range for AST file"));
      return true;
    }
    
    // Local helper to read the (possibly-compressed) buffer data following the
    // entry record.
    BitstreamCursorStringRef2unique_ptr ReadBuffer = /*[this]*/ (final BitstreamCursor /*&*/ SLocEntryCursor, StringRef Name) -> {
          SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          StringRef Blob/*J*/= new StringRef();
          /*uint*/int Code = SLocEntryCursor.ReadCode();
          /*uint*/int RecCode = SLocEntryCursor.readRecord(Code, Record, $AddrOf(Blob));
          if (RecCode == SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB_COMPRESSED) {
            SmallString/*0*/ Uncompressed/*J*/= new SmallString/*0*/(0);
            if (uncompress(new StringRef(Blob), Uncompressed, $ullong2uint(Record.$at(0)))
               != Status.StatusOK) {
              Error(new StringRef(/*KEEP_STR*/"could not decompress embedded file contents"));
              return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
            }
            return MemoryBuffer.getMemBufferCopy(Uncompressed.$StringRef(), new Twine(Name));
          } else if (RecCode == SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB) {
            return MemoryBuffer.getMemBuffer(Blob.drop_back(1), new StringRef(Name), true);
          } else {
            Error(new StringRef(/*KEEP_STR*/"AST record has invalid code"));
            return new std.unique_ptr<MemoryBuffer>(JD$NullPtr.INSTANCE, null);
          }
        };
    
    ModuleFile /*P*/ F = GlobalSLocEntryMap.find(-ID).$star().second;
    F.SLocEntryCursor.JumpToBit($uint2ulong(F.SLocEntryOffsets.$at(ID - F.SLocEntryBaseID)));
    final BitstreamCursor /*&*/ SLocEntryCursor = F.SLocEntryCursor;
    /*uint*/int BaseOffset = F.SLocEntryBaseOffset;
    
    ++NumSLocEntriesRead;
    BitstreamEntry Entry = SLocEntryCursor.advance();
    if (Entry.Kind != BitstreamEntry.Unnamed_enum.Record) {
      Error(new StringRef(/*KEEP_STR*/"incorrectly-formatted source location entry in AST file"));
      return true;
    }
    
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    StringRef Blob/*J*/= new StringRef();
    switch (SLocEntryCursor.readRecord(Entry.ID, Record, $AddrOf(Blob))) {
     default:
      Error(new StringRef(/*KEEP_STR*/"incorrectly-formatted source location entry in AST file"));
      return true;
     case SourceManagerRecordTypes.SM_SLOC_FILE_ENTRY:
      {
        // We will detect whether a file changed and return 'Failure' for it, but
        // we will also try to fail gracefully by setting up the SLocEntry.
        /*uint*/int InputID = $ullong2uint(Record.$at(4));
        InputFile IF = getInputFile($Deref(F), InputID);
        /*const*/ FileEntry /*P*/ File = IF.getFile();
        boolean OverriddenBuffer = IF.isOverridden();
        
        // Note that we only check if a File was returned. If it was out-of-date
        // we have complained but we will continue creating a FileID to recover
        // gracefully.
        if (!(File != null)) {
          return true;
        }
        
        SourceLocation IncludeLoc = ReadSourceLocation($Deref(F), $ullong2uint(Record.$at(1)));
        if (IncludeLoc.isInvalid() && F.Kind != ModuleKind.MK_MainFile) {
          // This is the module's main file.
          IncludeLoc.$assignMove(getImportLocation(F));
        }
        SrcMgr.CharacteristicKind FileCharacter = SrcMgr.CharacteristicKind.valueOf((int)Record.$at(2));
        FileID FID = SourceMgr.createFileID(File, /*NO_COPY*/IncludeLoc, FileCharacter, 
            ID, $ullong2uint($uint2ullong(BaseOffset) + Record.$at(0)));
        // JAVA SEMANTIC
//        final SrcMgr.FileInfo /*&*/ aFileInfo = ((/*const_cast*/SrcMgr.FileInfo /*&*/ )(SourceMgr.getSLocEntry(/*NO_COPY*/FID).getFile()));
        int FileInfo_SLocEntryIndex = SourceMgr.getFileSLocEntryByID_LoadEntryIfAbsent(/*FileID*/FID.$ID());
        /*JAVA*/assert FileInfo_SLocEntryIndex != SourceMgr.INVALID_SLOC_ENTRY_INDEX : "SourceMgr keeps decomposed SLocEntries and we created one for FID just above";
//        aFileInfo.NumCreatedFIDs = $ullong2uint(Record.$at(5));
        SourceMgr.$setFileSLocEntry_NumCreatedFIDs(FileInfo_SLocEntryIndex, $ullong2uint(Record.$at(5)));
        if ((Record.$at(3) != 0)) {
//          aFileInfo.setHasLineDirectives();
            SourceMgr.$setFileSLocEntry_HasLineDirective(FileInfo_SLocEntryIndex);
        }
        
        /*const*//*uint32_t P*/uint$ptr FirstDecl = $tryClone(F.FileSortedDecls.$add((int)Record.$at(6)));
        /*uint*/int NumFileDecls = $ullong2uint(Record.$at(7));
        if ((NumFileDecls != 0)) {
          assert (Native.$bool(F.FileSortedDecls)) : "FILE_SORTED_DECLS not encountered yet ?";
          FileDeclIDs.$at_T1$C$R(FID).$assignMove(new FileDeclsInfo(F, llvm.makeArrayRef(FirstDecl, 
                      NumFileDecls)));
        }
        
        /*const*/ SrcMgr.ContentCache /*P*/ ContentCache = SourceMgr.getOrCreateContentCache(File, 
            /*isSystemFile=*/ FileCharacter != SrcMgr.CharacteristicKind.C_User);
        if (OverriddenBuffer && !ContentCache.BufferOverridden
           && ContentCache.ContentsEntry == ContentCache.OrigEntry
           && !(ContentCache.getRawBuffer() != null)) {
          unique_ptr<MemoryBuffer> Buffer = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Buffer = ReadBuffer.$call(SLocEntryCursor, /*STRINGREF_STR*/new StringRef(File.getName()));
            if (!Buffer.$bool()) {
              return true;
            }
            SourceMgr.overrideFileContents(File, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer)))); $c$.clean();
          } finally {
            if (Buffer != null) { Buffer.$destroy(); }
            $c$.$destroy();
          }
        }
        
        break;
      }
     case SourceManagerRecordTypes.SM_SLOC_BUFFER_ENTRY:
      {
        unique_ptr<MemoryBuffer> Buffer = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/char$ptr/*char P*/ Name = $tryClone(Blob.data());
          /*uint*/int Offset = $ullong2uint(Record.$at(0));
          SrcMgr.CharacteristicKind FileCharacter = SrcMgr.CharacteristicKind.valueOf((int)Record.$at(2));
          SourceLocation IncludeLoc = ReadSourceLocation($Deref(F), $ullong2uint(Record.$at(1)));
          if (IncludeLoc.isInvalid()
             && (F.Kind == ModuleKind.MK_ImplicitModule || F.Kind == ModuleKind.MK_ExplicitModule)) {
            IncludeLoc.$assignMove(getImportLocation(F));
          }
          
          Buffer = ReadBuffer.$call(SLocEntryCursor, /*STRINGREF_STR*/new StringRef(Name));
          if (!Buffer.$bool()) {
            return true;
          }
          $c$.clean(SourceMgr.createFileID($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer))), FileCharacter, ID, 
              BaseOffset + Offset, /*NO_COPY*/IncludeLoc));
          break;
        } finally {
          if (Buffer != null) { Buffer.$destroy(); }
          $c$.$destroy();
        }
      }
     case SourceManagerRecordTypes.SM_SLOC_EXPANSION_ENTRY:
      {
        SourceLocation SpellingLoc = ReadSourceLocation($Deref(F), $ullong2uint(Record.$at(1)));
        SourceMgr.createExpansionLoc(/*NO_COPY*/SpellingLoc, 
            ReadSourceLocation($Deref(F), $ullong2uint(Record.$at(2))), 
            ReadSourceLocation($Deref(F), $ullong2uint(Record.$at(3))), 
            $ullong2uint(Record.$at(4)), 
            ID, 
            $ullong2uint($uint2ullong(BaseOffset) + Record.$at(0)));
        break;
      }
    }
    
    return false;
  }

  
  /// \brief Retrieve the module import location and module name for the
  /// given source manager entry ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModuleImportLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1343,
   FQN="clang::ASTReader::getModuleImportLoc", NM="_ZN5clang9ASTReader18getModuleImportLocEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18getModuleImportLocEi")
  //</editor-fold>
  @Override public std.pairTypeType<SourceLocation, StringRef> getModuleImportLoc(int ID)/* override*/ {
    if (ID == 0) {
      return new std.pairTypeType<SourceLocation, StringRef>(JD$Pair$_U1$_U2.INSTANCE, std.make_pair(/*$Move(*/new SourceLocation()/*)*/, ""));
    }
    if ($greatereq_uint(((/*uint*/int)(-ID)) - 2, getTotalNumSLocs()) || ID > 0) {
      Error(new StringRef(/*KEEP_STR*/"source location entry ID out-of-range for AST file"));
      return new std.pairTypeType<SourceLocation, StringRef>(JD$Pair$_U1$_U2.INSTANCE, std.make_pair(/*$Move(*/new SourceLocation()/*)*/, ""));
    }
    
    // Find which module file this entry lands in.
    ModuleFile /*P*/ M = GlobalSLocEntryMap.find(-ID).$star().second;
    if (M.Kind != ModuleKind.MK_ImplicitModule && M.Kind != ModuleKind.MK_ExplicitModule) {
      return new std.pairTypeType<SourceLocation, StringRef>(JD$Pair$_U1$_U2.INSTANCE, std.make_pair(/*$Move(*/new SourceLocation()/*)*/, ""));
    }
    
    // FIXME: Can we map this down to a particular submodule? That would be
    // ideal.
    return std.make_pair($Clone(M.ImportLoc), /*$Move(*/new StringRef(M.ModuleName)/*)*/);
  }

  
  /// \brief Retrieve the global submodule ID given a module and its local ID
  /// number.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalSubmoduleID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7547,
   FQN="clang::ASTReader::getGlobalSubmoduleID", NM="_ZN5clang9ASTReader20getGlobalSubmoduleIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20getGlobalSubmoduleIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalSubmoduleID(final ModuleFile /*&*/ M, /*uint*/int LocalID) {
    if ($less_uint(LocalID, NUM_PREDEF_SUBMODULE_IDS)) {
      return LocalID;
    }
    
    type$ptr<std.pairUIntInt /*P*/> I = $tryClone(M.SubmoduleRemap.find(LocalID - NUM_PREDEF_SUBMODULE_IDS));
    assert ($noteq_ptr(I, M.SubmoduleRemap.end())) : "Invalid index into submodule index remap";
    
    return LocalID + I./*->*/$star().second;
  }

  
  /// \brief Retrieve the submodule that corresponds to a global submodule ID.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSubmodule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7560,
   FQN="clang::ASTReader::getSubmodule", NM="_ZN5clang9ASTReader12getSubmoduleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12getSubmoduleEj")
  //</editor-fold>
  public Module /*P*/ getSubmodule(/*uint32_t*/int GlobalID) {
    if ($less_uint(GlobalID, NUM_PREDEF_SUBMODULE_IDS)) {
      assert (GlobalID == 0) : "Unhandled global submodule ID";
      return null;
    }
    if ($greater_uint(GlobalID, SubmodulesLoaded.size())) {
      Error(new StringRef(/*KEEP_STR*/"submodule ID out of range in AST file"));
      return null;
    }
    
    return SubmodulesLoaded.$at(GlobalID - NUM_PREDEF_SUBMODULE_IDS);
  }

  
  /// \brief Retrieve the module that corresponds to the given module ID.
  ///
  /// Note: overrides method in ExternalASTSource
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7574,
   FQN="clang::ASTReader::getModule", NM="_ZN5clang9ASTReader9getModuleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader9getModuleEj")
  //</editor-fold>
  @Override public Module /*P*/ getModule(/*uint*/int ID)/* override*/ {
    return getSubmodule(ID);
  }

  
  /// \brief Retrieve the module file with a given local ID within the specified
  /// ModuleFile.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getLocalModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7578,
   FQN="clang::ASTReader::getLocalModuleFile", NM="_ZN5clang9ASTReader18getLocalModuleFileERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18getLocalModuleFileERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public ModuleFile /*P*/ getLocalModuleFile(final ModuleFile /*&*/ F, /*uint*/int ID) {
    if (((ID & 1) != 0)) {
      // It's a module, look it up by submodule ID.
      type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalSubmoduleMap.find(getGlobalSubmoduleID(F, ID >>> 1)));
      return $eq_ptr(I, GlobalSubmoduleMap.end()) ? null : I./*->*/$star().second;
    } else {
      // It's a prefix (preamble, PCH, ...). Look it up by index.
      /*uint*/int IndexFromEnd = ID >>> 1;
      assert ((IndexFromEnd != 0)) : "got reference to unknown module file";
      return ((type$ptr<ModuleFile /*P*/ /*const*/ /*P*/>)getModuleManager().pch_modules().end()).$at(-IndexFromEnd);
    }
  }

  
  /// \brief Get an ID for the given module file.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getModuleFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7591,
   FQN="clang::ASTReader::getModuleFileID", NM="_ZN5clang9ASTReader15getModuleFileIDEPNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15getModuleFileIDEPNS_13serialization10ModuleFileE")
  //</editor-fold>
  public /*uint*/int getModuleFileID(ModuleFile /*P*/ F) {
    if (!(F != null)) {
      return 1;
    }
    
    // For a file representing a module, use the submodule ID of the top-level
    // module as the file ID. For any other kind of file, the number of such
    // files loaded beforehand will be the same on reload.
    // FIXME: Is this true even if we have an explicit module file and a PCH?
    if (F.isModule()) {
      return ((F.BaseSubmoduleID + NUM_PREDEF_SUBMODULE_IDS) << 1) | 1;
    }
    
    iterator_range<ModuleFile /*P*/ /*const*/> PCHModules = getModuleManager().pch_modules();
    type$ptr<ModuleFile /*P*/ /*const*/ /*P*/> I = $tryClone(std.find(((type$ptr<ModuleFile /*P*/ /*const*/ /*P*/>)PCHModules.begin()), ((type$ptr<ModuleFile /*P*/ /*const*/ /*P*/>)PCHModules.end()), F));
    assert ($noteq_ptr(I, ((type$ptr<ModuleFile /*P*/ /*const*/ /*P*/>)PCHModules.end()))) : "emitting reference to unknown file";
    return (I.$sub(((type$ptr<ModuleFile /*P*/ /*const*/ /*P*/>)PCHModules.end()))) << 1;
  }

  
  /// \brief Return a descriptor for the corresponding module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSourceDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7608,
   FQN="clang::ASTReader::getSourceDescriptor", NM="_ZN5clang9ASTReader19getSourceDescriptorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19getSourceDescriptorEj")
  //</editor-fold>
  @Override public Optional<ExternalASTSource.ASTSourceDescriptor> getSourceDescriptor(/*uint*/int ID)/* override*/ {
    {
      /*const*/ Module /*P*/ M = getSubmodule(ID);
      if ((M != null)) {
        return new Optional<ExternalASTSource.ASTSourceDescriptor>(JD$T$RR.INSTANCE, new ExternalASTSource.ASTSourceDescriptor($Deref(M)));
      }
    }
    
    // If there is only a single PCH, return it instead.
    // Chained PCH are not suported.
    if (ModuleMgr.size() == 1) {
      final ModuleFile /*&*/ MF = ModuleMgr.getPrimaryModule();
      StringRef ModuleName = path.filename(new StringRef(MF.OriginalSourceFileName));
      StringRef FileName = path.filename(new StringRef(MF.FileName));
      return new Optional<ExternalASTSource.ASTSourceDescriptor>(JD$T$RR.INSTANCE, new ASTReader.ASTSourceDescriptor(new StringRef(ModuleName), new StringRef(MF.OriginalDir), new StringRef(FileName), 
              $uint2ulong(MF.Signature)));
    }
    return new Optional<ExternalASTSource.ASTSourceDescriptor>(None);
  }

  
  /// \brief Retrieve a selector from the given module with its local ID
  /// number.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getLocalSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7625,
   FQN="clang::ASTReader::getLocalSelector", NM="_ZN5clang9ASTReader16getLocalSelectorERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16getLocalSelectorERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public Selector getLocalSelector(final ModuleFile /*&*/ M, /*uint*/int LocalID) {
    return DecodeSelector(getGlobalSelectorID(M, LocalID));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::DecodeSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7629,
   FQN="clang::ASTReader::DecodeSelector", NM="_ZN5clang9ASTReader14DecodeSelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader14DecodeSelectorEj")
  //</editor-fold>
  public Selector DecodeSelector(/*uint32_t*/int ID) {
    if (ID == 0) {
      return new Selector();
    }
    if ($greater_uint(ID, SelectorsLoaded.size())) {
      Error(new StringRef(/*KEEP_STR*/"selector ID out of range in AST file"));
      return new Selector();
    }
    if (SelectorsLoaded.$at(ID - 1).getAsOpaquePtr() == null) {
      // Load this selector from the selector table.
      type$ptr<std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(GlobalSelectorMap.find(ID));
      assert ($noteq_ptr(I, GlobalSelectorMap.end())) : "Corrupted global selector map";
      final ModuleFile /*&*/ M = $Deref(I./*->*/$star().second);
      ASTSelectorLookupTrait Trait/*J*/= new ASTSelectorLookupTrait(/*Deref*/this, M);
      /*uint*/int Idx = ID - M.BaseSelectorID - NUM_PREDEF_SELECTOR_IDS;
      SelectorsLoaded.$at(ID - 1).$assignMove(
          Trait.ReadKey($toConst(M.SelectorLookupTableData.$add(M.SelectorOffsets.$at(Idx))), 0, 0)
      );
      if ((DeserializationListener != null)) {
        DeserializationListener.SelectorRead(ID, new Selector(SelectorsLoaded.$at(ID - 1)));
      }
    }
    
    return new Selector(SelectorsLoaded.$at(ID - 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetExternalSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7654,
   FQN="clang::ASTReader::GetExternalSelector", NM="_ZN5clang9ASTReader19GetExternalSelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19GetExternalSelectorEj")
  //</editor-fold>
  @Override public Selector GetExternalSelector(/*uint32_t*/int ID)/* override*/ {
    return DecodeSelector(ID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetNumExternalSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7658,
   FQN="clang::ASTReader::GetNumExternalSelectors", NM="_ZN5clang9ASTReader23GetNumExternalSelectorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23GetNumExternalSelectorsEv")
  //</editor-fold>
  @Override public /*uint32_t*/int GetNumExternalSelectors()/* override*/ {
    // ID 0 (the null selector) is considered an external selector.
    return getTotalNumSelectors() + 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 1942,
   FQN="clang::ASTReader::ReadSelector", NM="_ZN5clang9ASTReader12ReadSelectorERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12ReadSelectorERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public Selector ReadSelector(final ModuleFile /*&*/ M, final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    return getLocalSelector(M, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  
  /// \brief Retrieve the global selector ID that corresponds to this
  /// the local selector ID in a given module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalSelectorID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7663,
   FQN="clang::ASTReader::getGlobalSelectorID", NM="_ZNK5clang9ASTReader19getGlobalSelectorIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader19getGlobalSelectorIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalSelectorID(final ModuleFile /*&*/ M, /*uint*/int LocalID) /*const*/ {
    if ($less_uint(LocalID, NUM_PREDEF_SELECTOR_IDS)) {
      return LocalID;
    }
    
    type$ptr<std.pairUIntInt /*P*/> I = $tryClone(M.SelectorRemap.find(LocalID - NUM_PREDEF_SELECTOR_IDS));
    assert ($noteq_ptr(I, M.SelectorRemap.end())) : "Invalid index into selector index remap";
    
    return LocalID + I./*->*/$star().second;
  }

  
  /// \brief Read a declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7676,
   FQN="clang::ASTReader::ReadDeclarationName", NM="_ZN5clang9ASTReader19ReadDeclarationNameERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19ReadDeclarationNameERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public DeclarationName ReadDeclarationName(final ModuleFile /*&*/ F, 
                     final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    DeclarationName.NameKind Kind = DeclarationName.NameKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    switch (Kind) {
     case Identifier:
      return new DeclarationName(GetIdentifierInfo(F, Record, Idx));
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      return new DeclarationName(ReadSelector(F, Record, Idx));
     case CXXConstructorName:
      return Context.DeclarationNames.getCXXConstructorName(Context.getCanonicalType(readType(F, Record, Idx)));
     case CXXDestructorName:
      return Context.DeclarationNames.getCXXDestructorName(Context.getCanonicalType(readType(F, Record, Idx)));
     case CXXConversionFunctionName:
      return Context.DeclarationNames.getCXXConversionFunctionName(Context.getCanonicalType(readType(F, Record, Idx)));
     case CXXOperatorName:
      return Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.valueOf($ulong2uint(Record.$at$Const(Idx.$set$postInc()))));
     case CXXLiteralOperatorName:
      return Context.DeclarationNames.getCXXLiteralOperatorName(GetIdentifierInfo(F, Record, Idx));
     case CXXUsingDirective:
      return DeclarationName.getUsingDirectiveName();
    }
    throw new llvm_unreachable("Invalid NameKind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7716,
   FQN="clang::ASTReader::ReadDeclarationNameLoc", NM="_ZN5clang9ASTReader22ReadDeclarationNameLocERNS_13serialization10ModuleFileERNS_18DeclarationNameLocENS_15DeclarationNameERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22ReadDeclarationNameLocERNS_13serialization10ModuleFileERNS_18DeclarationNameLocENS_15DeclarationNameERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public void ReadDeclarationNameLoc(final ModuleFile /*&*/ F, 
                        final DeclarationNameLoc /*&*/ DNLoc, 
                        DeclarationName Name, 
                        final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    switch (Name.getNameKind()) {
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      DNLoc.Unnamed_field.NamedType.TInfo = GetTypeSourceInfo(F, Record, Idx);
      break;
     case CXXOperatorName:
      DNLoc.Unnamed_field.CXXOperatorName.BeginOpNameLoc
         = ReadSourceLocation(F, Record, Idx).getRawEncoding();
      DNLoc.Unnamed_field.CXXOperatorName.EndOpNameLoc
         = ReadSourceLocation(F, Record, Idx).getRawEncoding();
      break;
     case CXXLiteralOperatorName:
      DNLoc.Unnamed_field.CXXLiteralOperatorName.OpNameLoc
         = ReadSourceLocation(F, Record, Idx).getRawEncoding();
      break;
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXUsingDirective:
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDeclarationNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7748,
   FQN="clang::ASTReader::ReadDeclarationNameInfo", NM="_ZN5clang9ASTReader23ReadDeclarationNameInfoERNS_13serialization10ModuleFileERNS_19DeclarationNameInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23ReadDeclarationNameInfoERNS_13serialization10ModuleFileERNS_19DeclarationNameInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public void ReadDeclarationNameInfo(final ModuleFile /*&*/ F, 
                         final DeclarationNameInfo /*&*/ NameInfo, 
                         final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    NameInfo.setName(ReadDeclarationName(F, Record, Idx));
    NameInfo.setLoc(ReadSourceLocation(F, Record, Idx));
    DeclarationNameLoc DNLoc/*J*/= new DeclarationNameLoc();
    ReadDeclarationNameLoc(F, DNLoc, NameInfo.getName(), Record, Idx);
    NameInfo.setInfo(DNLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadQualifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7758,
   FQN="clang::ASTReader::ReadQualifierInfo", NM="_ZN5clang9ASTReader17ReadQualifierInfoERNS_13serialization10ModuleFileERNS_13QualifierInfoERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17ReadQualifierInfoERNS_13serialization10ModuleFileERNS_13QualifierInfoERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public void ReadQualifierInfo(final ModuleFile /*&*/ F, final QualifierInfo /*&*/ Info, 
                   final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    Info.QualifierLoc.$assignMove(ReadNestedNameSpecifierLoc(F, Record, Idx));
    /*uint*/int NumTPLists = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    Info.NumTemplParamLists = NumTPLists;
    if ((NumTPLists != 0)) {
      Info.TemplParamLists = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (Context)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new TemplateParameterList /*P*/ [NumTPLists]);
      for (/*uint*/int i = 0; i != NumTPLists; ++i)  {
        Info.TemplParamLists.$set(i, ReadTemplateParameterList(F, Record, Idx));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadNestedNameSpecifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8025,
   FQN="clang::ASTReader::ReadNestedNameSpecifier", NM="_ZN5clang9ASTReader23ReadNestedNameSpecifierERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23ReadNestedNameSpecifierERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ ReadNestedNameSpecifier(final ModuleFile /*&*/ F, 
                         final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    /*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    NestedNameSpecifier /*P*/ NNS = null;
    NestedNameSpecifier /*P*/ Prev = null;
    for (/*uint*/int I = 0; I != N; ++I) {
      NestedNameSpecifier.SpecifierKind Kind = NestedNameSpecifier.SpecifierKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
      switch (Kind) {
       case Identifier:
        {
          IdentifierInfo /*P*/ II = GetIdentifierInfo(F, Record, Idx);
          NNS = NestedNameSpecifier.Create(Context, Prev, II);
          break;
        }
       case Namespace:
        {
          NamespaceDecl /*P*/ NS = this.<NamespaceDecl>ReadDeclAs(NamespaceDecl.class, F, Record, Idx);
          NNS = NestedNameSpecifier.Create(Context, Prev, NS);
          break;
        }
       case NamespaceAlias:
        {
          NamespaceAliasDecl /*P*/ Alias = this.<NamespaceAliasDecl>ReadDeclAs(NamespaceAliasDecl.class, F, Record, Idx);
          NNS = NestedNameSpecifier.Create(Context, Prev, Alias);
          break;
        }
       case TypeSpec:
       case TypeSpecWithTemplate:
        {
          /*const*/ Type /*P*/ T = readType(F, Record, Idx).getTypePtrOrNull();
          if (!(T != null)) {
            return null;
          }
          
          boolean Template = (Record.$at$Const(Idx.$set$postInc()) != 0);
          NNS = NestedNameSpecifier.Create(Context, Prev, Template, T);
          break;
        }
       case Global:
        {
          NNS = NestedNameSpecifier.GlobalSpecifier(Context);
          // No associated value, and there can't be a prefix.
          break;
        }
       case Super:
        {
          CXXRecordDecl /*P*/ RD = this.<CXXRecordDecl>ReadDeclAs(CXXRecordDecl.class, F, Record, Idx);
          NNS = NestedNameSpecifier.SuperSpecifier(Context, RD);
          break;
        }
      }
      Prev = NNS;
    }
    return NNS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadNestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8080,
   FQN="clang::ASTReader::ReadNestedNameSpecifierLoc", NM="_ZN5clang9ASTReader26ReadNestedNameSpecifierLocERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader26ReadNestedNameSpecifierLocERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public NestedNameSpecifierLoc ReadNestedNameSpecifierLoc(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
                            final uint$ref/*uint &*/ Idx) {
    NestedNameSpecifierLocBuilder Builder = null;
    try {
      /*uint*/int N = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      Builder/*J*/= new NestedNameSpecifierLocBuilder();
      for (/*uint*/int I = 0; I != N; ++I) {
        NestedNameSpecifier.SpecifierKind Kind = NestedNameSpecifier.SpecifierKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
        switch (Kind) {
         case Identifier:
          {
            IdentifierInfo /*P*/ II = GetIdentifierInfo(F, Record, Idx);
            SourceRange Range = ReadSourceRange(F, Record, Idx);
            Builder.Extend(Context, II, Range.getBegin(), Range.getEnd());
            break;
          }
         case Namespace:
          {
            NamespaceDecl /*P*/ NS = this.<NamespaceDecl>ReadDeclAs(NamespaceDecl.class, F, Record, Idx);
            SourceRange Range = ReadSourceRange(F, Record, Idx);
            Builder.Extend(Context, NS, Range.getBegin(), Range.getEnd());
            break;
          }
         case NamespaceAlias:
          {
            NamespaceAliasDecl /*P*/ Alias = this.<NamespaceAliasDecl>ReadDeclAs(NamespaceAliasDecl.class, F, Record, Idx);
            SourceRange Range = ReadSourceRange(F, Record, Idx);
            Builder.Extend(Context, Alias, Range.getBegin(), Range.getEnd());
            break;
          }
         case TypeSpec:
         case TypeSpecWithTemplate:
          {
            boolean Template = (Record.$at$Const(Idx.$set$postInc()) != 0);
            TypeSourceInfo /*P*/ T = GetTypeSourceInfo(F, Record, Idx);
            if (!(T != null)) {
              return new NestedNameSpecifierLoc();
            }
            SourceLocation ColonColonLoc = ReadSourceLocation(F, Record, Idx);
            
            // FIXME: 'template' keyword location not saved anywhere, so we fake it.
            Builder.Extend(Context, 
                Template ? T.getTypeLoc().getBeginLoc() : new SourceLocation(), 
                T.getTypeLoc(), new SourceLocation(ColonColonLoc));
            break;
          }
         case Global:
          {
            SourceLocation ColonColonLoc = ReadSourceLocation(F, Record, Idx);
            Builder.MakeGlobal(Context, new SourceLocation(ColonColonLoc));
            break;
          }
         case Super:
          {
            CXXRecordDecl /*P*/ RD = this.<CXXRecordDecl>ReadDeclAs(CXXRecordDecl.class, F, Record, Idx);
            SourceRange Range = ReadSourceRange(F, Record, Idx);
            Builder.MakeSuper(Context, RD, Range.getBegin(), Range.getEnd());
            break;
          }
        }
      }
      
      return Builder.getWithLocInContext(Context);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// \brief Read a template name.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadTemplateName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7770,
   FQN="clang::ASTReader::ReadTemplateName", NM="_ZN5clang9ASTReader16ReadTemplateNameERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16ReadTemplateNameERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public TemplateName ReadTemplateName(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
                  final uint$ref/*uint &*/ Idx) {
    TemplateName.NameKind Kind = TemplateName.NameKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    switch (Kind) {
     case Template:
      return new TemplateName(this.<TemplateDecl>ReadDeclAs(TemplateDecl.class, F, Record, Idx));
     case OverloadedTemplate:
      {
        /*uint*/int size = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        UnresolvedSet Decls/*J*/= new UnresolvedSet(8);
        while (((size--) != 0)) {
          Decls.addDecl(this.<NamedDecl>ReadDeclAs(NamedDecl.class, F, Record, Idx));
        }
        
        return Context.getOverloadedTemplateName(Decls.begin(), Decls.end());
      }
     case QualifiedTemplate:
      {
        NestedNameSpecifier /*P*/ NNS = ReadNestedNameSpecifier(F, Record, Idx);
        boolean hasTemplKeyword = (Record.$at$Const(Idx.$set$postInc()) != 0);
        TemplateDecl /*P*/ Template = this.<TemplateDecl>ReadDeclAs(TemplateDecl.class, F, Record, Idx);
        return Context.getQualifiedTemplateName(NNS, hasTemplKeyword, Template);
      }
     case DependentTemplate:
      {
        NestedNameSpecifier /*P*/ NNS = ReadNestedNameSpecifier(F, Record, Idx);
        if ((Record.$at$Const(Idx.$set$postInc()) != 0)) { // isIdentifier
          return Context.getDependentTemplateName(NNS, 
              GetIdentifierInfo(F, Record, 
                  Idx));
        }
        return Context.getDependentTemplateName(NNS, 
            OverloadedOperatorKind.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
      }
     case SubstTemplateTemplateParm:
      {
        TemplateTemplateParmDecl /*P*/ param = this.<TemplateTemplateParmDecl>ReadDeclAs(TemplateTemplateParmDecl.class, F, Record, Idx);
        if (!(param != null)) {
          return new TemplateName();
        }
        TemplateName replacement = ReadTemplateName(F, Record, Idx);
        return Context.getSubstTemplateTemplateParm(param, new TemplateName(replacement));
      }
     case SubstTemplateTemplateParmPack:
      {
        TemplateTemplateParmDecl /*P*/ Param = this.<TemplateTemplateParmDecl>ReadDeclAs(TemplateTemplateParmDecl.class, F, Record, Idx);
        if (!(Param != null)) {
          return new TemplateName();
        }
        
        TemplateArgument ArgPack = ReadTemplateArgument(F, Record, Idx);
        if (ArgPack.getKind() != TemplateArgument.ArgKind.Pack) {
          return new TemplateName();
        }
        
        return Context.getSubstTemplateTemplateParmPack(Param, ArgPack);
      }
    }
    throw new llvm_unreachable("Unhandled template name kind!");
  }

  
  /// \brief Read a template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadTemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7829,
   FQN="clang::ASTReader::ReadTemplateArgument", NM="_ZN5clang9ASTReader20ReadTemplateArgumentERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20ReadTemplateArgumentERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERjb")
  //</editor-fold>
  public TemplateArgument ReadTemplateArgument(final ModuleFile /*&*/ F, 
                      final /*const*/SmallVectorULong /*&*/ Record, 
                      final uint$ref/*uint &*/ Idx) {
    return ReadTemplateArgument(F, 
                      Record, 
                      Idx, 
                      false);
  }
  public TemplateArgument ReadTemplateArgument(final ModuleFile /*&*/ F, 
                      final /*const*/SmallVectorULong /*&*/ Record, 
                      final uint$ref/*uint &*/ Idx, 
                      boolean Canonicalize/*= false*/) {
    if (Canonicalize) {
      // The caller wants a canonical template argument. Sometimes the AST only
      // wants template arguments in canonical form (particularly as the template
      // argument lists of template specializations) so ensure we preserve that
      // canonical form across serialization.
      TemplateArgument Arg = ReadTemplateArgument(F, Record, Idx, false);
      return Context.getCanonicalTemplateArgument(Arg);
    }
    
    TemplateArgument.ArgKind Kind = TemplateArgument.ArgKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    switch (Kind) {
     case Null:
      return new TemplateArgument();
     case Type:
      return new TemplateArgument(readType(F, Record, Idx));
     case Declaration:
      {
        ValueDecl /*P*/ D = this.<ValueDecl>ReadDeclAs(ValueDecl.class, F, Record, Idx);
        return new TemplateArgument(D, readType(F, Record, Idx));
      }
     case NullPtr:
      return new TemplateArgument(readType(F, Record, Idx), /*isNullPtr*/ true);
     case Integral:
      {
        APSInt Value = ReadAPSInt(Record, Idx);
        QualType T = readType(F, Record, Idx);
        return new TemplateArgument(Context, Value, new QualType(T));
      }
     case Template:
      return new TemplateArgument(ReadTemplateName(F, Record, Idx));
     case TemplateExpansion:
      {
        TemplateName Name = ReadTemplateName(F, Record, Idx);
        OptionalUInt NumTemplateExpansions/*J*/= new OptionalUInt();
        {
          /*uint*/int NumExpansions = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          if ((NumExpansions != 0)) {
            NumTemplateExpansions.$assign_T$RR(NumExpansions - 1);
          }
        }
        return new TemplateArgument(new TemplateName(Name), new OptionalUInt(NumTemplateExpansions));
      }
     case Expression:
      return new TemplateArgument(ReadExpr(F));
     case Pack:
      {
        /*uint*/int NumArgs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        TemplateArgument /*P*/ Args[] = /*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
        /*new (Context)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new TemplateArgument [NumArgs];
        for (/*uint*/int I = 0; I != NumArgs; ++I)  {
          Args[I] = new TemplateArgument();
          Args[I].$assignMove(ReadTemplateArgument(F, Record, Idx));
        }
        return new TemplateArgument(llvm.makeArrayRef(Args, NumArgs));
      }
    }
    throw new llvm_unreachable("Unhandled template argument kind!");
  }

  
  /// \brief Read a template parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7882,
   FQN="clang::ASTReader::ReadTemplateParameterList", NM="_ZN5clang9ASTReader25ReadTemplateParameterListERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25ReadTemplateParameterListERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public TemplateParameterList /*P*/ ReadTemplateParameterList(final ModuleFile /*&*/ F, 
                           final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    SourceLocation TemplateLoc = ReadSourceLocation(F, Record, Idx);
    SourceLocation LAngleLoc = ReadSourceLocation(F, Record, Idx);
    SourceLocation RAngleLoc = ReadSourceLocation(F, Record, Idx);
    
    /*uint*/int NumParams = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    SmallVector<NamedDecl /*P*/ > Params/*J*/= new SmallVector<NamedDecl /*P*/ >(16, (NamedDecl /*P*/ )null);
    Params.reserve(NumParams);
    while (((NumParams--) != 0)) {
      Params.push_back(this.<NamedDecl>ReadDeclAs(NamedDecl.class, F, Record, Idx));
    }
    
    TemplateParameterList /*P*/ TemplateParams = TemplateParameterList.Create(Context, new SourceLocation(TemplateLoc), new SourceLocation(LAngleLoc), 
        new ArrayRef<NamedDecl /*P*/ >(Params, true), new SourceLocation(RAngleLoc));
    return TemplateParams;
  }

  
  /// \brief Read a template argument array.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7901,
   FQN="clang::ASTReader::ReadTemplateArgumentList", NM="_ZN5clang9ASTReader24ReadTemplateArgumentListERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERNS_13serialization10ModuleFileERKNS1_11SmallVectorIyLj64EEERjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader24ReadTemplateArgumentListERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERNS_13serialization10ModuleFileERKNS1_11SmallVectorIyLj64EEERjb")
  //</editor-fold>
  public void ReadTemplateArgumentList(final SmallVectorImpl<TemplateArgument> /*&*/ TemplArgs, 
                          final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
                          final uint$ref/*uint &*/ Idx) {
    ReadTemplateArgumentList(TemplArgs, 
                          F, Record, 
                          Idx, false);
  }
  public void ReadTemplateArgumentList(final SmallVectorImpl<TemplateArgument> /*&*/ TemplArgs, 
                          final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
                          final uint$ref/*uint &*/ Idx, boolean Canonicalize/*= false*/) {
    /*uint*/int NumTemplateArgs = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    TemplArgs.reserve(NumTemplateArgs);
    while (((NumTemplateArgs--) != 0)) {
      TemplArgs.push_back(ReadTemplateArgument(F, Record, Idx, Canonicalize));
    }
  }

  
  /// \brief Read a UnresolvedSet structure.
  
  /// \brief Read a UnresolvedSet structure.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadUnresolvedSet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7913,
   FQN="clang::ASTReader::ReadUnresolvedSet", NM="_ZN5clang9ASTReader17ReadUnresolvedSetERNS_13serialization10ModuleFileERNS_20LazyASTUnresolvedSetERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17ReadUnresolvedSetERNS_13serialization10ModuleFileERNS_20LazyASTUnresolvedSetERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public void ReadUnresolvedSet(final ModuleFile /*&*/ F, final LazyASTUnresolvedSet /*&*/ Set, 
                   final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    /*uint*/int NumDecls = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    Set.reserve(Context, NumDecls);
    while (((NumDecls--) != 0)) {
      /*uint32_t*/int ID = ReadDeclID(F, Record, Idx);
      AccessSpecifier AS = AccessSpecifier.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
      Set.addLazyDecl(Context, ID, AS);
    }
  }

  
  /// \brief Read a C++ base specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadCXXBaseSpecifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7924,
   FQN="clang::ASTReader::ReadCXXBaseSpecifier", NM="_ZN5clang9ASTReader20ReadCXXBaseSpecifierERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader20ReadCXXBaseSpecifierERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public CXXBaseSpecifier ReadCXXBaseSpecifier(final ModuleFile /*&*/ F, 
                      final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    boolean isVirtual = ((/*static_cast*/boolean)((Record.$at$Const(Idx.$set$postInc()) != 0)));
    boolean isBaseOfClass = ((/*static_cast*/boolean)((Record.$at$Const(Idx.$set$postInc()) != 0)));
    AccessSpecifier AS = /*static_cast*/AccessSpecifier.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
    boolean inheritConstructors = ((/*static_cast*/boolean)((Record.$at$Const(Idx.$set$postInc()) != 0)));
    TypeSourceInfo /*P*/ TInfo = GetTypeSourceInfo(F, Record, Idx);
    SourceRange Range = ReadSourceRange(F, Record, Idx);
    SourceLocation EllipsisLoc = ReadSourceLocation(F, Record, Idx);
    CXXBaseSpecifier Result/*J*/= new CXXBaseSpecifier(new SourceRange(Range), isVirtual, isBaseOfClass, AS, TInfo, 
        new SourceLocation(EllipsisLoc));
    Result.setInheritConstructors(inheritConstructors);
    return Result;
  }

  
  /// \brief Read a CXXCtorInitializer array.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadCXXCtorInitializers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7940,
   FQN="clang::ASTReader::ReadCXXCtorInitializers", NM="_ZN5clang9ASTReader23ReadCXXCtorInitializersERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23ReadCXXCtorInitializersERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public type$ptr<CXXCtorInitializer /*P*/ /*P*/> ReadCXXCtorInitializers(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
                         final uint$ref/*uint &*/ Idx) {
    /*uint*/int NumInitializers = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    assert ((NumInitializers != 0)) : "wrote ctor initializers but have no inits";
    type$ptr<CXXCtorInitializer /*P*/ /*P*/> CtorInitializers = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Context)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new CXXCtorInitializer /*P*/ [NumInitializers]);
    for (/*uint*/int i = 0; i != NumInitializers; ++i) {
      TypeSourceInfo /*P*/ TInfo = null;
      boolean IsBaseVirtual = false;
      FieldDecl /*P*/ Member = null;
      IndirectFieldDecl /*P*/ IndirectMember = null;
      
      /*CtorInitializerType*/int Type = (int)Record.$at$Const(Idx.$set$postInc());
      switch (Type) {
       case CtorInitializerType.CTOR_INITIALIZER_BASE:
        TInfo = GetTypeSourceInfo(F, Record, Idx);
        IsBaseVirtual = (Record.$at$Const(Idx.$set$postInc()) != 0);
        break;
       case CtorInitializerType.CTOR_INITIALIZER_DELEGATING:
        TInfo = GetTypeSourceInfo(F, Record, Idx);
        break;
       case CtorInitializerType.CTOR_INITIALIZER_MEMBER:
        Member = this.<FieldDecl>ReadDeclAs(FieldDecl.class, F, Record, Idx);
        break;
       case CtorInitializerType.CTOR_INITIALIZER_INDIRECT_MEMBER:
        IndirectMember = this.<IndirectFieldDecl>ReadDeclAs(IndirectFieldDecl.class, F, Record, Idx);
        break;
      }
      
      SourceLocation MemberOrEllipsisLoc = ReadSourceLocation(F, Record, Idx);
      Expr /*P*/ Init = ReadExpr(F);
      SourceLocation LParenLoc = ReadSourceLocation(F, Record, Idx);
      SourceLocation RParenLoc = ReadSourceLocation(F, Record, Idx);
      boolean IsWritten = (Record.$at$Const(Idx.$set$postInc()) != 0);
      /*uint*/int SourceOrderOrNumArrayIndices;
      SmallVector<VarDecl /*P*/ > Indices/*J*/= new SmallVector<VarDecl /*P*/ >(8, (VarDecl /*P*/ )null);
      if (IsWritten) {
        SourceOrderOrNumArrayIndices = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
      } else {
        SourceOrderOrNumArrayIndices = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
        Indices.reserve(SourceOrderOrNumArrayIndices);
        for (/*uint*/int i$1 = 0; i$1 != SourceOrderOrNumArrayIndices; ++i$1)  {
          Indices.push_back(this.<VarDecl>ReadDeclAs(VarDecl.class, F, Record, Idx));
        }
      }
      
      CXXCtorInitializer /*P*/ BOMInit;
      TypeSourceInfo /*P*/ TInfo_final = TInfo;
      if (Type == CtorInitializerType.CTOR_INITIALIZER_BASE) {
        boolean IsBaseVirtual_final = IsBaseVirtual;
        BOMInit = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
            return new CXXCtorInitializer(Context, TInfo_final, IsBaseVirtual_final, new SourceLocation(LParenLoc), Init, 
                    new SourceLocation(RParenLoc), new SourceLocation(MemberOrEllipsisLoc));
         });
      } else if (Type == CtorInitializerType.CTOR_INITIALIZER_DELEGATING) {
        BOMInit = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
            return new CXXCtorInitializer(Context, TInfo_final, new SourceLocation(LParenLoc), Init, new SourceLocation(RParenLoc));
         });
      } else if (IsWritten) {
        if ((Member != null)) {
          FieldDecl /*P*/ Member_final = Member;
          BOMInit = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXCtorInitializer(Context, Member_final, new SourceLocation(MemberOrEllipsisLoc), new SourceLocation(LParenLoc), Init, new SourceLocation(RParenLoc));
           });
        } else {
          IndirectFieldDecl /*P*/ IndirectMember_final = IndirectMember;
          BOMInit = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXCtorInitializer(Context, IndirectMember_final, new SourceLocation(MemberOrEllipsisLoc), 
                      new SourceLocation(LParenLoc), Init, new SourceLocation(RParenLoc));
           });
        }
      } else {
        if ((IndirectMember != null)) {
          IndirectFieldDecl /*P*/ IndirectMember_final = IndirectMember;
          assert (Indices.empty()) : "Indirect field improperly initialized";
          BOMInit = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
              return new CXXCtorInitializer(Context, IndirectMember_final, new SourceLocation(MemberOrEllipsisLoc), 
                      new SourceLocation(LParenLoc), Init, new SourceLocation(RParenLoc));
           });
        } else {
          BOMInit = CXXCtorInitializer.Create(Context, Member, new SourceLocation(MemberOrEllipsisLoc), new SourceLocation(LParenLoc), Init, new SourceLocation(RParenLoc), 
              Indices.data(), Indices.size());
        }
      }
      if (IsWritten) {
        BOMInit.setSourceOrder(SourceOrderOrNumArrayIndices);
      }
      CtorInitializers.$set(i, BOMInit);
    }
    
    return CtorInitializers;
  }

  
  /// \brief Read the contents of a CXXCtorInitializer array.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::GetExternalCXXCtorInitializers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6284,
   FQN="clang::ASTReader::GetExternalCXXCtorInitializers", NM="_ZN5clang9ASTReader30GetExternalCXXCtorInitializersEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader30GetExternalCXXCtorInitializersEy")
  //</editor-fold>
  @Override public type$ptr<CXXCtorInitializer /*P*/ /*P*/> GetExternalCXXCtorInitializers(long/*uint64_t*/ Offset)/* override*/ {
    SavedStreamPosition SavedPosition = null;
    ReadingKindTracker ReadingKind = null;
    try {
      RecordLocation Loc = getLocalBitOffset(Offset);
      final BitstreamCursor /*&*/ Cursor = Loc.F.DeclsCursor;
      SavedPosition/*J*/= new SavedStreamPosition(Cursor);
      Cursor.JumpToBit(Loc.Offset);
      ReadingKind/*J*/= new ReadingKindTracker(ASTReader.ReadingKind.Read_Decl, /*Deref*/this);
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      /*uint*/int Code = Cursor.ReadCode();
      /*uint*/int RecCode = Cursor.readRecord(Code, Record);
      if (RecCode != DeclCode.DECL_CXX_CTOR_INITIALIZERS) {
        Error(new StringRef(/*KEEP_STR*/"malformed AST file: missing C++ ctor initializers"));
        return null;
      }
      
      uint$ref Idx = create_uint$ref(0);
      return ReadCXXCtorInitializers($Deref(Loc.F), Record, Idx);
    } finally {
      if (ReadingKind != null) { ReadingKind.$destroy(); }
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  
  /// \brief Read a source location from raw form and return it in its
  /// originating module file's source location space.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadUntranslatedSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2008,
   FQN="clang::ASTReader::ReadUntranslatedSourceLocation", NM="_ZNK5clang9ASTReader30ReadUntranslatedSourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader30ReadUntranslatedSourceLocationEj")
  //</editor-fold>
  public SourceLocation ReadUntranslatedSourceLocation(/*uint32_t*/int Raw) /*const*/ {
    return SourceLocation.getFromRawEncoding((Raw >>> 1) | (Raw << 31));
  }

  
  /// \brief Read a source location from raw form.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2013,
   FQN="clang::ASTReader::ReadSourceLocation", NM="_ZNK5clang9ASTReader18ReadSourceLocationERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader18ReadSourceLocationERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public SourceLocation ReadSourceLocation(final ModuleFile /*&*/ $ModuleFile, /*uint32_t*/int Raw) /*const*/ {
    SourceLocation Loc = ReadUntranslatedSourceLocation(Raw);
    return TranslateSourceLocation($ModuleFile, new SourceLocation(Loc));
  }

  
  /// \brief Translate a source location from another module file's source
  /// location space into ours.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::TranslateSourceLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2020,
   FQN="clang::ASTReader::TranslateSourceLocation", NM="_ZNK5clang9ASTReader23TranslateSourceLocationERNS_13serialization10ModuleFileENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader23TranslateSourceLocationERNS_13serialization10ModuleFileENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation TranslateSourceLocation(final ModuleFile /*&*/ $ModuleFile, 
                         SourceLocation Loc) /*const*/ {
    assert ($noteq_ptr($ModuleFile.SLocRemap.find(Loc.getOffset()), $ModuleFile.SLocRemap.end())) : "Cannot find offset to remap.";
    int Remap = $ModuleFile.SLocRemap.find(Loc.getOffset()).$star().second;
    return Loc.getLocWithOffset(Remap);
  }

  
  /// \brief Read a source location.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2030,
   FQN="clang::ASTReader::ReadSourceLocation", NM="_ZN5clang9ASTReader18ReadSourceLocationERNS_13serialization10ModuleFileERKN4llvm15SmallVectorImplIyEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ReadSourceLocationERNS_13serialization10ModuleFileERKN4llvm15SmallVectorImplIyEERj")
  //</editor-fold>
  public SourceLocation ReadSourceLocation(final ModuleFile /*&*/ $ModuleFile, 
                    final /*const*/SmallVectorImplULong /*&*/ Record, 
                    final uint$ref/*uint &*/ Idx) {
    return ReadSourceLocation($ModuleFile, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
  }

  
  /// \brief Read a source range.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8143,
   FQN="clang::ASTReader::ReadSourceRange", NM="_ZN5clang9ASTReader15ReadSourceRangeERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15ReadSourceRangeERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public SourceRange ReadSourceRange(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
                 final uint$ref/*uint &*/ Idx) {
    SourceLocation beg = ReadSourceLocation(F, Record, Idx);
    SourceLocation end = ReadSourceLocation(F, Record, Idx);
    return new SourceRange(/*NO_COPY*/beg, /*NO_COPY*/end);
  }

  
  /// \brief Read an integral value
  
  /// \brief Read an integral value
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadAPInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8152,
   FQN="clang::ASTReader::ReadAPInt", NM="_ZN5clang9ASTReader9ReadAPIntERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader9ReadAPIntERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public APInt ReadAPInt(final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    /*uint*/int BitWidth = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    /*uint*/int NumWords = APInt.getNumWords(BitWidth);
    APInt Result/*J*/= new APInt(BitWidth, NumWords, $AddrOf(Record.ptr$at(Idx.$deref())));
    Idx.$set$addassign(NumWords);
    return Result;
  }

  
  /// \brief Read a signed integral value
  
  /// \brief Read a signed integral value
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadAPSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8161,
   FQN="clang::ASTReader::ReadAPSInt", NM="_ZN5clang9ASTReader10ReadAPSIntERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10ReadAPSIntERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public APSInt ReadAPSInt(final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    boolean isUnsigned = (Record.$at$Const(Idx.$set$postInc()) != 0);
    return new APSInt(ReadAPInt(Record, Idx), isUnsigned);
  }

  
  /// \brief Read a floating-point value
  
  /// \brief Read a floating-point value
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadAPFloat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8167,
   FQN="clang::ASTReader::ReadAPFloat", NM="_ZN5clang9ASTReader11ReadAPFloatERKN4llvm11SmallVectorIyLj64EEERKNS1_12fltSemanticsERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader11ReadAPFloatERKN4llvm11SmallVectorIyLj64EEERKNS1_12fltSemanticsERj")
  //</editor-fold>
  public APFloat ReadAPFloat(final /*const*/SmallVectorULong /*&*/ Record, 
             final /*const*/ fltSemantics /*&*/ Sem, 
             final uint$ref/*uint &*/ Idx) {
    return new APFloat(Sem, ReadAPInt(Record, Idx));
  }

  
  // \brief Read a string
  
  // \brief Read a string
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8174,
   FQN="clang::ASTReader::ReadString", NM="_ZN5clang9ASTReader10ReadStringERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10ReadStringERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public static std.string ReadString(final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    /*uint*/int Len = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    std.string Result/*J*/= new std.string(Record.data$Const().$add(Idx.$deref()), Record.data$Const().$add(Idx.$deref()).$add(Len));
    Idx.$set$addassign(Len);
    return Result;
  }

  
  // \brief Read a path
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8181,
   FQN="clang::ASTReader::ReadPath", NM="_ZN5clang9ASTReader8ReadPathERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader8ReadPathERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public std.string ReadPath(final ModuleFile /*&*/ F, final /*const*/SmallVectorULong /*&*/ Record, 
          final uint$ref/*uint &*/ Idx) {
    std.string Filename = ReadString(Record, Idx);
    ResolveImportedPath(F, Filename);
    return Filename;
  }

  
  /// \brief Read a version tuple.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadVersionTuple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8188,
   FQN="clang::ASTReader::ReadVersionTuple", NM="_ZN5clang9ASTReader16ReadVersionTupleERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16ReadVersionTupleERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public static VersionTuple ReadVersionTuple(final /*const*/SmallVectorULong /*&*/ Record, 
                  final uint$ref/*uint &*/ Idx) {
    /*uint*/int Major = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    /*uint*/int Minor = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    /*uint*/int Subminor = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
    if (Minor == 0) {
      return new VersionTuple(Major);
    }
    if (Subminor == 0) {
      return new VersionTuple(Major, Minor - 1);
    }
    return new VersionTuple(Major, Minor - 1, Subminor - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadCXXTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8200,
   FQN="clang::ASTReader::ReadCXXTemporary", NM="_ZN5clang9ASTReader16ReadCXXTemporaryERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader16ReadCXXTemporaryERNS_13serialization10ModuleFileERKN4llvm11SmallVectorIyLj64EEERj")
  //</editor-fold>
  public CXXTemporary /*P*/ ReadCXXTemporary(final ModuleFile /*&*/ F, 
                  final /*const*/SmallVectorULong /*&*/ Record, 
                  final uint$ref/*uint &*/ Idx) {
    CXXDestructorDecl /*P*/ Decl = this.<CXXDestructorDecl>ReadDeclAs(CXXDestructorDecl.class, F, Record, Idx);
    return CXXTemporary.Create(Context, Decl);
  }

  
  /// \brief Reads attributes from the current stream position.
  
  /// \brief Reads attributes from the current stream position.
  
  //===----------------------------------------------------------------------===//
  // Attribute Reading
  //===----------------------------------------------------------------------===//
  
  /// \brief Reads attributes from the current stream position.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadAttributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2461,
   FQN="clang::ASTReader::ReadAttributes", NM="_ZN5clang9ASTReader14ReadAttributesERNS_13serialization10ModuleFileERN4llvm11SmallVectorIPNS_4AttrELj2EEERKNS5_IyLj64EEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang9ASTReader14ReadAttributesERNS_13serialization10ModuleFileERN4llvm11SmallVectorIPNS_4AttrELj2EEERKNS5_IyLj64EEERj")
  //</editor-fold>
  public void ReadAttributes(final ModuleFile /*&*/ F, final SmallVector<Attr /*P*/>/*&*/ Attrs, 
                final /*const*/SmallVectorULong /*&*/ Record, final uint$ref/*uint &*/ Idx) {
    for (/*uint*/int i = 0, e = $ullong2uint(Record.$at$Const(Idx.$set$postInc())); i != e; ++i) {
      Attr /*P*/ New = null;
      attr.Kind Kind = attr.Kind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
      SourceRange Range = ReadSourceRange(F, Record, Idx);
      /*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
      |*                                                                            *|
      |* Attribute deserialization code                                             *|
      |*                                                                            *|
      |* Automatically generated file, do not edit!                                 *|
      |*                                                                            *|
      \*===----------------------------------------------------------------------===*/
      switch (Kind) {
       case AMDGPUNumSGPR:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int numSGPR = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AMDGPUNumSGPRAttr(new SourceRange(Range), Context, numSGPR, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AMDGPUNumVGPR:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int numVGPR = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AMDGPUNumVGPRAttr(new SourceRange(Range), Context, numVGPR, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ARMInterrupt:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          ARMInterruptAttr.InterruptType interrupt/*J*/= /*static_cast*/ARMInterruptAttr.InterruptType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ARMInterruptAttr(new SourceRange(Range), Context, interrupt, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AbiTag:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int tagsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<StringRef> tags/*J*/= new SmallVector<StringRef>(4, new StringRef());
          tags.reserve(tagsSize);
          SmallVector<std.string> tagsStorage/*J*/= new SmallVector<std.string>(4, new std.string());
          tagsStorage.reserve(tagsSize);
          for (/*uint*/int i$1 = 0; i$1 != tagsSize; ++i$1)  {
            tagsStorage.push_back_T$RR(ASTReader.ReadString(Record, Idx));
          }
          for (/*uint*/int i$1 = 0; i$1 != tagsSize; ++i$1)  {
            tags.push_back(new StringRef(tagsStorage.$at(i$1)));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AbiTagAttr(new SourceRange(Range), Context, tags.data(), tagsSize, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case AcquireCapability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AcquireCapabilityAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AcquiredAfter:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AcquiredAfterAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AcquiredBefore:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AcquiredBeforeAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Alias:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string aliasee = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AliasAttr(new SourceRange(Range), Context, new StringRef(aliasee), Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case AlignMac68k:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AlignMac68kAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AlignValue:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ alignment = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AlignValueAttr(new SourceRange(Range), Context, alignment, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case Aligned:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          boolean isalignmentExpr = (Record.$at$Const(Idx.$set$postInc()) != 0);
          Object/*void P*/ alignmentPtr;
          if (isalignmentExpr) {
            alignmentPtr = ReadExpr(F);
          } else {
            alignmentPtr = GetTypeSourceInfo(F, Record, Idx);
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AlignedAttr(new SourceRange(Range), Context, isalignmentExpr, alignmentPtr, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AlwaysInline:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AlwaysInlineAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AnalyzerNoReturn:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AnalyzerNoReturnAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Annotate:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string annotation = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AnnotateAttr(new SourceRange(Range), Context, new StringRef(annotation), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AnyX86Interrupt:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AnyX86InterruptAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ArcWeakrefUnavailable:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ArcWeakrefUnavailableAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ArgumentWithTypeTag:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ argumentKind = GetIdentifierInfo(F, Record, Idx);
          /*uint*/int argumentIdx = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int typeTagIdx = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          boolean isPointer = (Record.$at$Const(Idx.$set$postInc()) != 0);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ArgumentWithTypeTagAttr(new SourceRange(Range), Context, argumentKind, argumentIdx, typeTagIdx, isPointer, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AsmLabel:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string label = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AsmLabelAttr(new SourceRange(Range), Context, new StringRef(label), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AssertCapability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ expr = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AssertCapabilityAttr(new SourceRange(Range), Context, expr, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AssertExclusiveLock:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AssertExclusiveLockAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AssertSharedLock:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AssertSharedLockAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case AssumeAligned:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ alignment = ReadExpr(F);
          Expr /*P*/ offset = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AssumeAlignedAttr(new SourceRange(Range), Context, alignment, offset, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Availability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ platform = GetIdentifierInfo(F, Record, Idx);
          VersionTuple introduced = ASTReader.ReadVersionTuple(Record, Idx);
          VersionTuple deprecated = ASTReader.ReadVersionTuple(Record, Idx);
          VersionTuple obsoleted = ASTReader.ReadVersionTuple(Record, Idx);
          boolean unavailable = (Record.$at$Const(Idx.$set$postInc()) != 0);
          std.string message = ASTReader.ReadString(Record, Idx);
          boolean strict = (Record.$at$Const(Idx.$set$postInc()) != 0);
          std.string replacement = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new AvailabilityAttr(new SourceRange(Range), Context, platform, new VersionTuple(introduced), new VersionTuple(deprecated), new VersionTuple(obsoleted), unavailable, new StringRef(message), strict, new StringRef(replacement), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Blocks:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          BlocksAttr.BlockType type/*J*/= /*static_cast*/BlocksAttr.BlockType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new BlocksAttr(new SourceRange(Range), Context, type, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case C11NoReturn:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new C11NoReturnAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CDecl:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CDeclAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CFAuditedTransfer:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CFAuditedTransferAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CFConsumed:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CFConsumedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CFReturnsNotRetained:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CFReturnsNotRetainedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CFReturnsRetained:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CFReturnsRetainedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CFUnknownTransfer:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CFUnknownTransferAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDAConstant:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDAConstantAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDADevice:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDADeviceAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDAGlobal:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDAGlobalAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDAHost:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDAHostAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDAInvalidTarget:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDAInvalidTargetAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDALaunchBounds:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ maxThreads = ReadExpr(F);
          Expr /*P*/ minBlocks = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDALaunchBoundsAttr(new SourceRange(Range), Context, maxThreads, minBlocks, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CUDAShared:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CUDASharedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CXX11NoReturn:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CXX11NoReturnAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CallableWhen:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int callableStatesSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<CallableWhenAttr.ConsumedState> callableStates/*J*/= new SmallVector<CallableWhenAttr.ConsumedState>(4, CallableWhenAttr.ConsumedState.valueOf(0));
          callableStates.reserve(callableStatesSize);
          for (/*uint*/int i$1 = callableStatesSize; (i$1 != 0); --i$1)  {
            callableStates.push_back(/*static_cast*/CallableWhenAttr.ConsumedState.valueOf((int)Record.$at$Const(Idx.$set$postInc())));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CallableWhenAttr(new SourceRange(Range), Context, callableStates.data(), callableStatesSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Capability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string name = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CapabilityAttr(new SourceRange(Range), Context, new StringRef(name), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CapturedRecord:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CapturedRecordAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case CarriesDependency:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CarriesDependencyAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Cleanup:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          FunctionDecl /*P*/ functionDecl = this.<FunctionDecl>GetLocalDeclAs(FunctionDecl.class, F, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CleanupAttr(new SourceRange(Range), Context, functionDecl, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Cold:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ColdAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Common:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new CommonAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Const:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ConstAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Constructor:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          int priority = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ConstructorAttr(new SourceRange(Range), Context, priority, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Consumable:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          ConsumableAttr.ConsumedState defaultState/*J*/= /*static_cast*/ConsumableAttr.ConsumedState.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ConsumableAttr(new SourceRange(Range), Context, defaultState, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ConsumableAutoCast:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ConsumableAutoCastAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ConsumableSetOnRead:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ConsumableSetOnReadAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case DLLExport:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new DLLExportAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case DLLImport:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new DLLImportAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Deprecated:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string message = ASTReader.ReadString(Record, Idx);
          std.string replacement = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new DeprecatedAttr(new SourceRange(Range), Context, new StringRef(message), new StringRef(replacement), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Destructor:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          int priority = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new DestructorAttr(new SourceRange(Range), Context, priority, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case DisableTailCalls:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new DisableTailCallsAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case EmptyBases:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new EmptyBasesAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case EnableIf:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ cond = ReadExpr(F);
          std.string message = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new EnableIfAttr(new SourceRange(Range), Context, cond, new StringRef(message), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ExclusiveTrylockFunction:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ successValue = ReadExpr(F);
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ExclusiveTrylockFunctionAttr(new SourceRange(Range), Context, successValue, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case FallThrough:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FallThroughAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case FastCall:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FastCallAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Final:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FinalAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case FlagEnum:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FlagEnumAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Flatten:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FlattenAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Format:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ type = GetIdentifierInfo(F, Record, Idx);
          int formatIdx = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          int firstArg = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FormatAttr(new SourceRange(Range), Context, type, formatIdx, firstArg, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case FormatArg:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          int formatIdx = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new FormatArgAttr(new SourceRange(Range), Context, formatIdx, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case GNUInline:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new GNUInlineAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case GuardedBy:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ arg = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new GuardedByAttr(new SourceRange(Range), Context, arg, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case GuardedVar:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new GuardedVarAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Hot:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new HotAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case IBAction:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new IBActionAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case IBOutlet:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new IBOutletAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case IBOutletCollection:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          TypeSourceInfo /*P*/ interface_ = GetTypeSourceInfo(F, Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new IBOutletCollectionAttr(new SourceRange(Range), Context, interface_, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case IFunc:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string resolver = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new IFuncAttr(new SourceRange(Range), Context, new StringRef(resolver), Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case InitPriority:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int priority = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new InitPriorityAttr(new SourceRange(Range), Context, priority, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case InitSeg:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string section = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new InitSegAttr(new SourceRange(Range), Context, new StringRef(section), Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case IntelOclBicc:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new IntelOclBiccAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case InternalLinkage:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new InternalLinkageAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case LTOVisibilityPublic:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new LTOVisibilityPublicAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case LayoutVersion:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int version = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new LayoutVersionAttr(new SourceRange(Range), Context, version, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case LockReturned:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ arg = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new LockReturnedAttr(new SourceRange(Range), Context, arg, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case LocksExcluded:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new LocksExcludedAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case LoopHint:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          LoopHintAttr.OptionType option/*J*/= /*static_cast*/LoopHintAttr.OptionType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          LoopHintAttr.LoopHintState state/*J*/= /*static_cast*/LoopHintAttr.LoopHintState.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ value = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new LoopHintAttr(new SourceRange(Range), Context, option, state, value, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case MSABI:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MSABIAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MSInheritance:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          boolean bestCase = (Record.$at$Const(Idx.$set$postInc()) != 0);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MSInheritanceAttr(new SourceRange(Range), Context, bestCase, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MSNoVTable:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MSNoVTableAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MSP430Interrupt:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int number = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MSP430InterruptAttr(new SourceRange(Range), Context, number, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MSStruct:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MSStructAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MSVtorDisp:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int vdm = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MSVtorDispAttr(new SourceRange(Range), Context, vdm, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MaxFieldAlignment:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int alignment = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MaxFieldAlignmentAttr(new SourceRange(Range), Context, alignment, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MayAlias:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MayAliasAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MinSize:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MinSizeAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Mips16:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new Mips16Attr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case MipsInterrupt:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          MipsInterruptAttr.InterruptType interrupt/*J*/= /*static_cast*/MipsInterruptAttr.InterruptType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new MipsInterruptAttr(new SourceRange(Range), Context, interrupt, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Mode:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ mode = GetIdentifierInfo(F, Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ModeAttr(new SourceRange(Range), Context, mode, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case NSConsumed:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NSConsumedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NSConsumesSelf:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NSConsumesSelfAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NSReturnsAutoreleased:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NSReturnsAutoreleasedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NSReturnsNotRetained:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NSReturnsNotRetainedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NSReturnsRetained:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NSReturnsRetainedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Naked:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NakedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoAlias:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoAliasAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoCommon:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoCommonAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoDebug:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoDebugAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoDuplicate:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoDuplicateAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoInline:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoInlineAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoInstrumentFunction:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoInstrumentFunctionAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoMips16:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoMips16Attr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoReturn:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoReturnAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoSanitize:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int sanitizersSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<StringRef> sanitizers/*J*/= new SmallVector<StringRef>(4, new StringRef());
          sanitizers.reserve(sanitizersSize);
          SmallVector<std.string> sanitizersStorage/*J*/= new SmallVector<std.string>(4, new std.string());
          sanitizersStorage.reserve(sanitizersSize);
          for (/*uint*/int i$1 = 0; i$1 != sanitizersSize; ++i$1)  {
            sanitizersStorage.push_back_T$RR(ASTReader.ReadString(Record, Idx));
          }
          for (/*uint*/int i$1 = 0; i$1 != sanitizersSize; ++i$1)  {
            sanitizers.push_back(new StringRef(sanitizersStorage.$at(i$1)));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoSanitizeAttr(new SourceRange(Range), Context, sanitizers.data(), sanitizersSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoSplitStack:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoSplitStackAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoThreadSafetyAnalysis:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoThreadSafetyAnalysisAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NoThrow:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NoThrowAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NonNull:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVectorUInt args/*J*/= new SmallVectorUInt(4, 0);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NonNullAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case NotTailCalled:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new NotTailCalledAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case OMPCaptureNoInit:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OMPCaptureNoInitAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case OMPDeclareSimdDecl:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          OMPDeclareSimdDeclAttr.BranchStateTy branchState/*J*/= /*static_cast*/OMPDeclareSimdDeclAttr.BranchStateTy.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ simdlen = ReadExpr(F);
          /*uint*/int uniformsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > uniforms/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          uniforms.reserve(uniformsSize);
          for (/*uint*/int i$1 = 0; i$1 != uniformsSize; ++i$1)  {
            uniforms.push_back(ReadExpr(F));
          }
          /*uint*/int alignedsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > aligneds/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          aligneds.reserve(alignedsSize);
          for (/*uint*/int i$1 = 0; i$1 != alignedsSize; ++i$1)  {
            aligneds.push_back(ReadExpr(F));
          }
          /*uint*/int alignmentsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > alignments/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          alignments.reserve(alignmentsSize);
          for (/*uint*/int i$1 = 0; i$1 != alignmentsSize; ++i$1)  {
            alignments.push_back(ReadExpr(F));
          }
          /*uint*/int linearsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > linears/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          linears.reserve(linearsSize);
          for (/*uint*/int i$1 = 0; i$1 != linearsSize; ++i$1)  {
            linears.push_back(ReadExpr(F));
          }
          /*uint*/int modifiersSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVectorUInt modifiers/*J*/= new SmallVectorUInt(4, 0);
          modifiers.reserve(modifiersSize);
          for (/*uint*/int i$1 = 0; i$1 != modifiersSize; ++i$1)  {
            modifiers.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
          }
          /*uint*/int stepsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > steps/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          steps.reserve(stepsSize);
          for (/*uint*/int i$1 = 0; i$1 != stepsSize; ++i$1)  {
            steps.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OMPDeclareSimdDeclAttr(new SourceRange(Range), Context, branchState, simdlen, uniforms.data(), uniformsSize, aligneds.data(), alignedsSize, alignments.data(), alignmentsSize, linears.data(), linearsSize, modifiers.data(), modifiersSize, steps.data(), stepsSize, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case OMPDeclareTargetDecl:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          OMPDeclareTargetDeclAttr.MapTypeTy mapType/*J*/= /*static_cast*/OMPDeclareTargetDeclAttr.MapTypeTy.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OMPDeclareTargetDeclAttr(new SourceRange(Range), Context, mapType, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case OMPThreadPrivateDecl:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OMPThreadPrivateDeclAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCBoxable:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBoxableAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCBridge:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ bridgedType = GetIdentifierInfo(F, Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBridgeAttr(new SourceRange(Range), Context, bridgedType, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCBridgeMutable:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ bridgedType = GetIdentifierInfo(F, Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBridgeMutableAttr(new SourceRange(Range), Context, bridgedType, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCBridgeRelated:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ relatedClass = GetIdentifierInfo(F, Record, Idx);
          IdentifierInfo /*P*/ classMethod = GetIdentifierInfo(F, Record, Idx);
          IdentifierInfo /*P*/ instanceMethod = GetIdentifierInfo(F, Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCBridgeRelatedAttr(new SourceRange(Range), Context, relatedClass, classMethod, instanceMethod, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCDesignatedInitializer:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCDesignatedInitializerAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCException:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCExceptionAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCExplicitProtocolImpl:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCExplicitProtocolImplAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCIndependentClass:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCIndependentClassAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCMethodFamily:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          ObjCMethodFamilyAttr.FamilyKind family/*J*/= /*static_cast*/ObjCMethodFamilyAttr.FamilyKind.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCMethodFamilyAttr(new SourceRange(Range), Context, family, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCNSObject:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCNSObjectAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCPreciseLifetime:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCPreciseLifetimeAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCRequiresPropertyDefs:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCRequiresPropertyDefsAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCRequiresSuper:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCRequiresSuperAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCReturnsInnerPointer:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCReturnsInnerPointerAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCRootClass:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCRootClassAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCRuntimeName:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string metadataName = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCRuntimeNameAttr(new SourceRange(Range), Context, new StringRef(metadataName), Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case ObjCRuntimeVisible:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ObjCRuntimeVisibleAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case OpenCLAccess:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OpenCLAccessAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case OpenCLKernel:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OpenCLKernelAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case OpenCLUnrollHint:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int unrollHint = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OpenCLUnrollHintAttr(new SourceRange(Range), Context, unrollHint, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case OptimizeNone:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OptimizeNoneAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Overloadable:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OverloadableAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case Override:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OverrideAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Ownership:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ module = GetIdentifierInfo(F, Record, Idx);
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVectorUInt args/*J*/= new SmallVectorUInt(4, 0);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new OwnershipAttr(new SourceRange(Range), Context, module, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Packed:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PackedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ParamTypestate:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          ParamTypestateAttr.ConsumedState paramState/*J*/= /*static_cast*/ParamTypestateAttr.ConsumedState.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ParamTypestateAttr(new SourceRange(Range), Context, paramState, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Pascal:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PascalAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case PassObjectSize:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          int type = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PassObjectSizeAttr(new SourceRange(Range), Context, type, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Pcs:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          PcsAttr.PCSType pCS/*J*/= /*static_cast*/PcsAttr.PCSType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PcsAttr(new SourceRange(Range), Context, pCS, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case PreserveAll:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PreserveAllAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case PreserveMost:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PreserveMostAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case PtGuardedBy:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ arg = ReadExpr(F);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PtGuardedByAttr(new SourceRange(Range), Context, arg, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case PtGuardedVar:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PtGuardedVarAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Pure:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new PureAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ReleaseCapability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ReleaseCapabilityAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case RenderScriptKernel:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new RenderScriptKernelAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case ReqdWorkGroupSize:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int xDim = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int yDim = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int zDim = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ReqdWorkGroupSizeAttr(new SourceRange(Range), Context, xDim, yDim, zDim, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case RequiresCapability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new RequiresCapabilityAttr(new SourceRange(Range), Context, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Restrict:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new RestrictAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ReturnTypestate:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          ReturnTypestateAttr.ConsumedState state/*J*/= /*static_cast*/ReturnTypestateAttr.ConsumedState.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ReturnTypestateAttr(new SourceRange(Range), Context, state, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ReturnsNonNull:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ReturnsNonNullAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ReturnsTwice:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ReturnsTwiceAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ScopedLockable:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ScopedLockableAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Section:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string name = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SectionAttr(new SourceRange(Range), Context, new StringRef(name), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SelectAny:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SelectAnyAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Sentinel:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          int sentinel = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          int nullPos = $ullong2int(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SentinelAttr(new SourceRange(Range), Context, sentinel, nullPos, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SetTypestate:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SetTypestateAttr.ConsumedState newState/*J*/= /*static_cast*/SetTypestateAttr.ConsumedState.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SetTypestateAttr(new SourceRange(Range), Context, newState, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SharedTrylockFunction:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ successValue = ReadExpr(F);
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SharedTrylockFunctionAttr(new SourceRange(Range), Context, successValue, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case StdCall:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new StdCallAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SwiftCall:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SwiftCallAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SwiftContext:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SwiftContextAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SwiftErrorResult:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SwiftErrorResultAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SwiftIndirectResult:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SwiftIndirectResultAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case SysVABI:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new SysVABIAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case TLSModel:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string model = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TLSModelAttr(new SourceRange(Range), Context, new StringRef(model), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Target:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string featuresStr = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TargetAttr(new SourceRange(Range), Context, new StringRef(featuresStr), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case TestTypestate:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          TestTypestateAttr.ConsumedState testState/*J*/= /*static_cast*/TestTypestateAttr.ConsumedState.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TestTypestateAttr(new SourceRange(Range), Context, testState, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case ThisCall:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ThisCallAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Thread:
        {
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new ThreadAttr(new SourceRange(Range), Context, Spelling);
           });
          New.setImplicit(isImplicit);
          break;
        }
       case TransparentUnion:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TransparentUnionAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case TryAcquireCapability:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          Expr /*P*/ successValue = ReadExpr(F);
          /*uint*/int argsSize = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          SmallVector<Expr /*P*/ > args/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
          args.reserve(argsSize);
          for (/*uint*/int i$1 = 0; i$1 != argsSize; ++i$1)  {
            args.push_back(ReadExpr(F));
          }
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TryAcquireCapabilityAttr(new SourceRange(Range), Context, successValue, args.data(), argsSize, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case TypeTagForDatatype:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          IdentifierInfo /*P*/ argumentKind = GetIdentifierInfo(F, Record, Idx);
          TypeSourceInfo /*P*/ matchingCType = GetTypeSourceInfo(F, Record, Idx);
          boolean layoutCompatible = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean mustBeNull = (Record.$at$Const(Idx.$set$postInc()) != 0);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TypeTagForDatatypeAttr(new SourceRange(Range), Context, argumentKind, matchingCType, layoutCompatible, mustBeNull, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case TypeVisibility:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          TypeVisibilityAttr.VisibilityType visibility/*J*/= /*static_cast*/TypeVisibilityAttr.VisibilityType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new TypeVisibilityAttr(new SourceRange(Range), Context, visibility, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Unavailable:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string message = ASTReader.ReadString(Record, Idx);
          UnavailableAttr.ImplicitReason implicitReason/*J*/= /*static_cast*/UnavailableAttr.ImplicitReason.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new UnavailableAttr(new SourceRange(Range), Context, new StringRef(message), implicitReason, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Unused:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new UnusedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Used:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new UsedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Uuid:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string guid = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new UuidAttr(new SourceRange(Range), Context, new StringRef(guid), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case VecReturn:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new VecReturnAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case VecTypeHint:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          TypeSourceInfo /*P*/ typeHint = GetTypeSourceInfo(F, Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new VecTypeHintAttr(new SourceRange(Range), Context, typeHint, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case VectorCall:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new VectorCallAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Visibility:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          VisibilityAttr.VisibilityType visibility/*J*/= /*static_cast*/VisibilityAttr.VisibilityType.valueOf((int)Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new VisibilityAttr(new SourceRange(Range), Context, visibility, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case WarnUnused:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new WarnUnusedAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case WarnUnusedResult:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new WarnUnusedResultAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case Weak:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new WeakAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case WeakImport:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new WeakImportAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case WeakRef:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          std.string aliasee = ASTReader.ReadString(Record, Idx);
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new WeakRefAttr(new SourceRange(Range), Context, new StringRef(aliasee), Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case WorkGroupSizeHint:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int xDim = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int yDim = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          /*uint*/int zDim = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new WorkGroupSizeHintAttr(new SourceRange(Range), Context, xDim, yDim, zDim, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case X86ForceAlignArgPointer:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new X86ForceAlignArgPointerAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
       case XRayInstrument:
        {
          boolean isInherited = (Record.$at$Const(Idx.$set$postInc()) != 0);
          boolean isImplicit = (Record.$at$Const(Idx.$set$postInc()) != 0);
          /*uint*/int Spelling = $ullong2uint(Record.$at$Const(Idx.$set$postInc()));
          New = /*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new(Context, (type$ptr<?> New$Mem)->{
              return new XRayInstrumentAttr(new SourceRange(Range), Context, Spelling);
           });
          cast_InheritableAttr(New).setInherited(isInherited);
          New.setImplicit(isImplicit);
          break;
        }
      }
      assert ((New != null)) : "Unable to decode attribute?";
      Attrs.push_back(New);
    }
  }


  
  /// \brief Reads a statement.
  
  /// \brief Reads a statement.
  
  //===----------------------------------------------------------------------===//
  // ASTReader Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2780,
   FQN="clang::ASTReader::ReadStmt", NM="_ZN5clang9ASTReader8ReadStmtERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang9ASTReader8ReadStmtERNS_13serialization10ModuleFileE")
  //</editor-fold>
  public Stmt /*P*/ ReadStmt(final ModuleFile /*&*/ F) {
    switch (_ReadingKind) {
     case Read_None:
      throw new llvm_unreachable("should not call this when not reading anything");
     case Read_Decl:
     case Read_Type:
      return ReadStmtFromStream(F);
     case Read_Stmt:
      return ReadSubStmt();
    }
    throw new llvm_unreachable("ReadingKind not set ?");
  }


  
  /// \brief Reads an expression.
  
  /// \brief Reads an expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2794,
   FQN="clang::ASTReader::ReadExpr", NM="_ZN5clang9ASTReader8ReadExprERNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang9ASTReader8ReadExprERNS_13serialization10ModuleFileE")
  //</editor-fold>
  public Expr /*P*/ ReadExpr(final ModuleFile /*&*/ F) {
    return cast_or_null_Expr(ReadStmt(F));
  }


  
  /// \brief Reads a sub-statement operand during statement reading.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2073,
   FQN="clang::ASTReader::ReadSubStmt", NM="_ZN5clang9ASTReader11ReadSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader11ReadSubStmtEv")
  //</editor-fold>
  public Stmt /*P*/ ReadSubStmt() {
    assert (_ReadingKind == ReadingKind.Read_Stmt) : "Should be called only during statement reading!";
    // Subexpressions are stored from last to first, so the next Stmt we need
    // is at the back of the stack.
    assert (!StmtStack.empty()) : "Read too many sub-statements!";
    return StmtStack.pop_back_val();
  }

  
  /// \brief Reads a sub-expression operand during statement reading.
  
  /// \brief Reads a sub-expression operand during statement reading.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadSubExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp", line = 2798,
   FQN="clang::ASTReader::ReadSubExpr", NM="_ZN5clang9ASTReader11ReadSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang9ASTReader11ReadSubExprEv")
  //</editor-fold>
  public Expr /*P*/ ReadSubExpr() {
    return cast_or_null_Expr(ReadSubStmt());
  }


  
  /// \brief Reads a token out of a record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1397,
   FQN="clang::ASTReader::ReadToken", NM="_ZN5clang9ASTReader9ReadTokenERNS_13serialization10ModuleFileERKN4llvm15SmallVectorImplIyEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader9ReadTokenERNS_13serialization10ModuleFileERKN4llvm15SmallVectorImplIyEERj")
  //</editor-fold>
  public Token ReadToken(final ModuleFile /*&*/ F, final /*const*/SmallVectorImplULong /*&*/ Record, 
           final uint$ref/*uint &*/ Idx) {
    Token Tok/*J*/= new Token();
    Tok.startToken();
    Tok.setLocation(ReadSourceLocation(F, Record, Idx));
    Tok.setLength($ullong2uint(Record.$at$Const(Idx.$set$postInc())));
    {
      IdentifierInfo /*P*/ II = getLocalIdentifier(F, $ullong2uint(Record.$at$Const(Idx.$set$postInc())));
      if ((II != null)) {
        Tok.setIdentifierInfo(II);
      }
    }
    Tok.setKind((/*tok.TokenKind*/char)Record.$at$Const(Idx.$set$postInc()));
    Tok.setFlag((/*Token.TokenFlags*/char)Record.$at$Const(Idx.$set$postInc()));
    return Tok;
  }

  
  /// \brief Reads the macro record located at the given offset.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadMacroRecord">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1410,
   FQN="clang::ASTReader::ReadMacroRecord", NM="_ZN5clang9ASTReader15ReadMacroRecordERNS_13serialization10ModuleFileEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15ReadMacroRecordERNS_13serialization10ModuleFileEy")
  //</editor-fold>
  public MacroInfo /*P*/ ReadMacroRecord(final ModuleFile /*&*/ F, long/*uint64_t*/ Offset) {
    SavedStreamPosition SavedPosition = null;
    try {
      final BitstreamCursor /*&*/ Stream = F.MacroCursor;
      
      // Keep track of where we are in the stream, then jump back there
      // after reading this macro.
      SavedPosition/*J*/= new SavedStreamPosition(Stream);
      
      Stream.JumpToBit(Offset);
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      SmallVector<IdentifierInfo /*P*/> MacroArgs/*J*/= new SmallVector<IdentifierInfo /*P*/>(16, (IdentifierInfo /*P*/)null);
      MacroInfo /*P*/ Macro = null;
      while (true) {
        // Advance to the next record, but if we get to the end of the block, don't
        // pop it (removing all the abbreviations from the cursor) since we want to
        // be able to reseek within the block and read entries.
        /*uint*/int Flags = BitstreamCursor.Unnamed_enum.AF_DontPopBlockAtEnd.getValue();
        BitstreamEntry Entry = Stream.advanceSkippingSubblocks(Flags);
        switch (Entry.Kind) {
         case SubBlock: // Handled for us already.
         case Error:
          Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
          return Macro;
         case EndBlock:
          return Macro;
         case Record:
          // The interesting case.
          break;
        }
        
        // Read a record.
        Record.clear();
        /*PreprocessorRecordTypes*/int RecType = Stream.readRecord(Entry.ID, Record);
        switch (RecType) {
         case PreprocessorRecordTypes.PP_MODULE_MACRO:
         case PreprocessorRecordTypes.PP_MACRO_DIRECTIVE_HISTORY:
          return Macro;
         case PreprocessorRecordTypes.PP_MACRO_OBJECT_LIKE:
         case PreprocessorRecordTypes.PP_MACRO_FUNCTION_LIKE:
          {
            // If we already have a macro, that means that we've hit the end
            // of the definition of the macro we were looking for. We're
            // done.
            if ((Macro != null)) {
              return Macro;
            }
            
            uint$ref NextIndex = create_uint$ref(1); // Skip identifier ID.
            /*uint32_t*/int SubModID = getGlobalSubmoduleID(F, $ullong2uint(Record.$at(NextIndex.$set$postInc())));
            SourceLocation Loc = ReadSourceLocation(F, Record, NextIndex);
            MacroInfo /*P*/ MI = PP.AllocateDeserializedMacroInfo(new SourceLocation(Loc), SubModID);
            MI.setDefinitionEndLoc(ReadSourceLocation(F, Record, NextIndex));
            MI.setIsUsed((Record.$at(NextIndex.$set$postInc()) != 0));
            MI.setUsedForHeaderGuard((Record.$at(NextIndex.$set$postInc()) != 0));
            if (RecType == PreprocessorRecordTypes.PP_MACRO_FUNCTION_LIKE) {
              // Decode function-like macro info.
              boolean isC99VarArgs = (Record.$at(NextIndex.$set$postInc()) != 0);
              boolean isGNUVarArgs = (Record.$at(NextIndex.$set$postInc()) != 0);
              boolean hasCommaPasting = (Record.$at(NextIndex.$set$postInc()) != 0);
              MacroArgs.clear();
              /*uint*/int NumArgs = $ullong2uint(Record.$at(NextIndex.$set$postInc()));
              for (/*uint*/int i = 0; i != NumArgs; ++i)  {
                MacroArgs.push_back(getLocalIdentifier(F, $ullong2uint(Record.$at(NextIndex.$set$postInc()))));
              }
              
              // Install function-like macro info.
              MI.setIsFunctionLike();
              if (isC99VarArgs) {
                MI.setIsC99Varargs();
              }
              if (isGNUVarArgs) {
                MI.setIsGNUVarargs();
              }
              if (hasCommaPasting) {
                MI.setHasCommaPasting();
              }
              MI.setArgumentList(/*PERF: new ArrayRef<IdentifierInfo P >(MacroArgs, true)*/MacroArgs, PP.getPreprocessorAllocator());
            }
            
            // Remember that we saw this macro last so that we add the tokens that
            // form its body to it.
            Macro = MI;
            if (NextIndex.$deref() + 1 == Record.size() && (PP.getPreprocessingRecord() != null)
               && (Record.$at(NextIndex.$deref()) != 0)) {
              // We have a macro definition. Register the association
              /*uint32_t*/int GlobalID = getGlobalPreprocessedEntityID(F, $ullong2uint(Record.$at(NextIndex.$deref())));
              final PreprocessingRecord /*&*/ PPRec = $Deref(PP.getPreprocessingRecord());
              PreprocessingRecord.PPEntityID PPID = PPRec.getPPEntityID(GlobalID - 1, /*isLoaded=*/ true);
              MacroDefinitionRecord /*P*/ PPDef = cast_or_null_MacroDefinitionRecord(PPRec.getPreprocessedEntity(/*NO_COPY*/PPID));
              if ((PPDef != null)) {
                PPRec.RegisterMacroDefinition(Macro, PPDef);
              }
            }
            
            ++NumMacrosRead;
            break;
          }
         case PreprocessorRecordTypes.PP_TOKEN:
          {
            // If we see a TOKEN before a PP_MACRO_*, then the file is
            // erroneous, just pretend we didn't see this.
            if (!(Macro != null)) {
              break;
            }
            
            uint$ref Idx = create_uint$ref(0);
            Token Tok = ReadToken(F, Record, Idx);
//            Macro.AddTokenToBody(Tok);
            /*JAVA friend*/Macro.AddDeserializedTokenToBody(Tok);
            break;
          }
        }
      }
    } finally {
      if (SavedPosition != null) { SavedPosition.$destroy(); }
    }
  }

  
  /// \brief Determine the global preprocessed entity ID that corresponds to
  /// the given local ID within the given module.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getGlobalPreprocessedEntityID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1520,
   FQN="clang::ASTReader::getGlobalPreprocessedEntityID", NM="_ZNK5clang9ASTReader29getGlobalPreprocessedEntityIDERNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTReader29getGlobalPreprocessedEntityIDERNS_13serialization10ModuleFileEj")
  //</editor-fold>
  public /*uint32_t*/int getGlobalPreprocessedEntityID(final ModuleFile /*&*/ M, /*uint*/int LocalID) /*const*/ {
    type$ptr</*const*/std.pairUIntInt /*P*/> I = $tryClone(M.PreprocessedEntityRemap.find(LocalID - NUM_PREDEF_PP_ENTITY_IDS));
    assert ($noteq_ptr(I, M.PreprocessedEntityRemap.end())) : "Invalid index into preprocessed entity index remap";
    
    return LocalID + I./*->*/$star().second;
  }

  
  /// \brief Add a macro to deserialize its macro directive history.
  ///
  /// \param II The name of the macro.
  /// \param M The module file.
  /// \param MacroDirectivesOffset Offset of the serialized macro directive
  /// history.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::addPendingMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1643,
   FQN="clang::ASTReader::addPendingMacro", NM="_ZN5clang9ASTReader15addPendingMacroEPNS_14IdentifierInfoEPNS_13serialization10ModuleFileEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader15addPendingMacroEPNS_14IdentifierInfoEPNS_13serialization10ModuleFileEy")
  //</editor-fold>
  public void addPendingMacro(IdentifierInfo /*P*/ II, 
                 ModuleFile /*P*/ M, 
                 long/*uint64_t*/ MacroDirectivesOffset) {
    assert ($greater_uint(NumCurrentElementsDeserializing, 0)) : "Missing deserialization guard";
    PendingMacroIDs.$at(II).push_back(new PendingMacroInfo(M, MacroDirectivesOffset));
  }

  
  /// \brief Read the set of macros defined by this external macro source.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadDefinedMacros">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1650,
   FQN="clang::ASTReader::ReadDefinedMacros", NM="_ZN5clang9ASTReader17ReadDefinedMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader17ReadDefinedMacrosEv")
  //</editor-fold>
  @Override public void ReadDefinedMacros()/* override*/ {
    ExternalASTSource.Deserializing Macros = null;
    try {
      // Note that we are loading defined macros.
      Macros/*J*/= new ExternalASTSource.Deserializing(this);
      
      for (ModuleFile /*P*/ /*&*/ I : llvm.reverse$HasRBegin(ModuleMgr)) {
        BitstreamCursor Cursor = null;
        try {
          final BitstreamCursor /*&*/ MacroCursor = I.MacroCursor;
          
          // If there was no preprocessor block, skip this file.
          if (!(MacroCursor.getBitStreamReader() != null)) {
            continue;
          }
          
          Cursor = new BitstreamCursor(MacroCursor);
          Cursor.JumpToBit(I.MacroStartOffset);
          
          SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          NextCursor: while (true) {
            BitstreamEntry E = Cursor.advanceSkippingSubblocks();
            switch (E.Kind) {
             case SubBlock: // Handled for us already.
             case Error:
              Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
              return;
             case EndBlock:
              break NextCursor;
             case Record:
              Record.clear();
              switch (Cursor.readRecord(E.ID, Record)) {
               default: // Default behavior: ignore.
                break;
               case PreprocessorRecordTypes.PP_MACRO_OBJECT_LIKE:
               case PreprocessorRecordTypes.PP_MACRO_FUNCTION_LIKE:
                {
                  IdentifierInfo /*P*/ II = getLocalIdentifier($Deref(I), $ullong2uint(Record.$at(0)));
                  if (II.isOutOfDate()) {
                    updateOutOfDateIdentifier($Deref(II));
                  }
                  break;
                }
               case PreprocessorRecordTypes.PP_TOKEN:
                // Ignore tokens.
                break;
              }
              break;
            }
          }
         //NextCursor:
          ;
        } finally {
          if (Cursor != null) { Cursor.$destroy(); }
        }
      }
    } finally {
      if (Macros != null) { Macros.$destroy(); }
    }
  }

  
  /// \brief Update an out-of-date identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::updateOutOfDateIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1755,
   FQN="clang::ASTReader::updateOutOfDateIdentifier", NM="_ZN5clang9ASTReader25updateOutOfDateIdentifierERNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25updateOutOfDateIdentifierERNS_14IdentifierInfoE")
  //</editor-fold>
  @Override public void updateOutOfDateIdentifier(final IdentifierInfo /*&*/ II)/* override*/ {
    ExternalASTSource.Deserializing AnIdentifier = null;
    try {
      // Note that we are loading an identifier.
      AnIdentifier/*J*/= new ExternalASTSource.Deserializing(this);
      
      /*uint*/int PriorGeneration = 0;
      if (getContext().getLangOpts().Modules) {
        PriorGeneration = IdentifierGeneration.$at_T1$RR($AddrOf(II));
      }
      
      // If there is a global index, look there first to determine which modules
      // provably do not have any results for this identifier.
      SmallPtrSet<ModuleFile /*P*/> Hits/*J*/= new SmallPtrSet<ModuleFile /*P*/>(DenseMapInfo$LikePtr.$Info(), 4);
      SmallPtrSet<ModuleFile /*P*/> /*P*/ HitsPtr = null;
      if (!loadGlobalIndex()) {
        if (GlobalIndex.$arrow().lookupIdentifier(II.getName(), Hits)) {
          HitsPtr = $AddrOf(Hits);
        }
      }
      
      IdentifierLookupVisitor Visitor/*J*/= new IdentifierLookupVisitor(II.getName(), PriorGeneration, 
          NumIdentifierLookups_ref, 
          NumIdentifierLookupHits_ref);
      ModuleMgr.visit(/*FuncArg*/Visitor, HitsPtr);
      markIdentifierUpToDate($AddrOf(II));
    } finally {
      if (AnIdentifier != null) { AnIdentifier.$destroy(); }
    }
  }

  
  /// \brief Note that this identifier is up-to-date.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::markIdentifierUpToDate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1780,
   FQN="clang::ASTReader::markIdentifierUpToDate", NM="_ZN5clang9ASTReader22markIdentifierUpToDateEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader22markIdentifierUpToDateEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void markIdentifierUpToDate(IdentifierInfo /*P*/ II) {
    if (!(II != null)) {
      return;
    }
    
    II.setOutOfDate(false);
    
    // Update the generation for this identifier.
    if (getContext().getLangOpts().Modules) {
      IdentifierGeneration.$set(II, getGeneration());
    }
  }

  
  /// \brief Load all external visible decls in the given DeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::completeVisibleDeclsMap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6666,
   FQN="clang::ASTReader::completeVisibleDeclsMap", NM="_ZN5clang9ASTReader23completeVisibleDeclsMapEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader23completeVisibleDeclsMapEPKNS_11DeclContextE")
  //</editor-fold>
  @Override public void completeVisibleDeclsMap(/*const*/ DeclContext /*P*/ DC)/* override*/ {
    DenseMap<DeclarationName, SmallVector<NamedDecl /*P*/ >> Decls = null;
    try {
      if (!DC.hasExternalVisibleStorage()) {
        return;
      }
      
      DenseMapIterator</*const*/ DeclContext /*P*/ , DeclContextLookupTable> It = Lookups.find(DC);
      assert (It.$noteq(/*NO_ITER_COPY*/Lookups.end())) : "have external visible storage but no lookup tables";
      
      Decls/*J*/= new DenseMap<DeclarationName, SmallVector<NamedDecl /*P*/ >>(DenseMapInfoDeclarationName.$Info(), new SmallVector<NamedDecl /*P*/ >(1));
      
      for (/*uint32_t*/int ID : It.$arrow().second.Table.findAll()) {
        NamedDecl /*P*/ ND = cast_NamedDecl(GetDecl(ID));
        Decls.$at_T1$RR(ND.getDeclName()).push_back(ND);
      }
      
      ++NumVisibleDeclContextsRead;
      
      for (DenseMapIterator<DeclarationName, SmallVector<NamedDecl /*P*/ >> I = Decls.begin(), E = Decls.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
        ExternalASTSource.SetExternalVisibleDeclsForName(DC, new DeclarationName(I.$arrow().first), new ArrayRef<NamedDecl /*P*/ >(I.$arrow().second, true));
      }
      ((/*const_cast*/DeclContext /*P*/ )(DC)).setHasExternalVisibleStorage(false);
    } finally {
      if (Decls != null) { Decls.$destroy(); }
    }
  }

  
  /// \brief Retrieve the AST context that this AST reader supplements.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2118,
   FQN="clang::ASTReader::getContext", NM="_ZN5clang9ASTReader10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() {
    return Context;
  }

  
  // \brief Contains the IDs for declarations that were requested before we have
  // access to a Sema object.
  public SmallVectorULong PreloadedDeclIDs;
  
  /// \brief Retrieve the semantic analysis object used to analyze the
  /// translation unit in which the precompiled header is being
  /// imported.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2127,
   FQN="clang::ASTReader::getSema", NM="_ZN5clang9ASTReader7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader7getSemaEv")
  //</editor-fold>
  public Sema /*P*/ getSema() {
    return SemaObj;
  }

  
  /// \brief Get the identifier resolver used for name lookup / updates
  /// in the translation unit scope. We have one of these even if we don't
  /// have a Sema object.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getIdResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8743,
   FQN="clang::ASTReader::getIdResolver", NM="_ZN5clang9ASTReader13getIdResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader13getIdResolverEv")
  //</editor-fold>
  public IdentifierResolver /*&*/ getIdResolver() {
    return (SemaObj != null) ? SemaObj.IdResolver : DummyIdResolver;
  }

  
  /// \brief Retrieve the identifier table associated with the
  /// preprocessor.
  
  /// \brief Retrieve the identifier table associated with the
  /// preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getIdentifierTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8217,
   FQN="clang::ASTReader::getIdentifierTable", NM="_ZN5clang9ASTReader18getIdentifierTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18getIdentifierTableEv")
  //</editor-fold>
  public IdentifierTable /*&*/ getIdentifierTable() {
    return PP.getIdentifierTable();
  }

  
  /// \brief Record that the given ID maps to the given switch-case
  /// statement.
  
  /// \brief Record that the given ID maps to the given switch-case
  /// statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::RecordSwitchCaseID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8223,
   FQN="clang::ASTReader::RecordSwitchCaseID", NM="_ZN5clang9ASTReader18RecordSwitchCaseIDEPNS_10SwitchCaseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18RecordSwitchCaseIDEPNS_10SwitchCaseEj")
  //</editor-fold>
  public void RecordSwitchCaseID(SwitchCase /*P*/ SC, /*uint*/int ID) {
    assert (($Deref(CurrSwitchCaseStmts)).$at_T1$C$R(ID) == null) : "Already have a SwitchCase with this ID";
    ($Deref(CurrSwitchCaseStmts)).$set(ID, SC);
  }

  
  /// \brief Retrieve the switch-case statement with the given ID.
  
  /// \brief Retrieve the switch-case statement with the given ID.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::getSwitchCaseWithID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8230,
   FQN="clang::ASTReader::getSwitchCaseWithID", NM="_ZN5clang9ASTReader19getSwitchCaseWithIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader19getSwitchCaseWithIDEj")
  //</editor-fold>
  public SwitchCase /*P*/ getSwitchCaseWithID(/*uint*/int ID) {
    assert (($Deref(CurrSwitchCaseStmts)).$at_T1$C$R(ID) != null) : "No SwitchCase with this ID";
    return ($Deref(CurrSwitchCaseStmts)).$at_T1$C$R(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ClearSwitchCaseIDs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8235,
   FQN="clang::ASTReader::ClearSwitchCaseIDs", NM="_ZN5clang9ASTReader18ClearSwitchCaseIDsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader18ClearSwitchCaseIDsEv")
  //</editor-fold>
  public void ClearSwitchCaseIDs() {
    CurrSwitchCaseStmts.clear();
  }

  
  /// \brief Cursors for comments blocks.
  public SmallVector<std.pairTypePtr<BitstreamCursor, ModuleFile /*P*/ >> CommentsCursors;
  
  /// \brief Loads comments ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::ReadComments">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 8239,
   FQN="clang::ASTReader::ReadComments", NM="_ZN5clang9ASTReader12ReadCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader12ReadCommentsEv")
  //</editor-fold>
  @Override public void ReadComments()/* override*/ {
    std.vector<RawComment /*P*/ > Comments = null;
    try {
      Comments/*J*/= new std.vector<RawComment /*P*/ >((RawComment /*P*/ )null);
      for (type$ptr<std.pairTypePtr<BitstreamCursor, ModuleFile /*P*/ >> I = $tryClone(CommentsCursors.begin()), 
          /*P*/ E = $tryClone(CommentsCursors.end());
           $noteq_ptr(I, E); I.$preInc()) {
        SavedStreamPosition SavedPosition = null;
        try {
          Comments.clear();
          final BitstreamCursor /*&*/ Cursor = I./*->*/$star().first;
          final ModuleFile /*&*/ F = $Deref(I./*->*/$star().second);
          SavedPosition/*J*/= new SavedStreamPosition(Cursor);
          
          SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          NextCursor: while (true) {
            BitstreamEntry Entry = Cursor.advanceSkippingSubblocks(BitstreamCursor.Unnamed_enum.AF_DontPopBlockAtEnd.getValue());
            switch (Entry.Kind) {
             case SubBlock: // Handled for us already.
             case Error:
              Error(new StringRef(/*KEEP_STR*/"malformed block record in AST file"));
              return;
             case EndBlock:
              break NextCursor;
             case Record:
              // The interesting case.
              break;
            }
            
            // Read a record.
            Record.clear();
            switch (Cursor.readRecord(Entry.ID, Record)) {
             case CommentRecordTypes.COMMENTS_RAW_COMMENT:
              {
                uint$ref Idx = create_uint$ref(0);
                SourceRange SR = ReadSourceRange(F, Record, Idx);
                RawComment.CommentKind Kind = RawComment.CommentKind.valueOf((int)Record.$at(Idx.$set$postInc()));
                boolean IsTrailingComment = (Record.$at(Idx.$set$postInc()) != 0);
                boolean IsAlmostTrailingComment = (Record.$at(Idx.$set$postInc()) != 0);
                Comments.push_back_T$RR(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
                    /*new (Context)*/ $new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->{
                        return new RawComment(new SourceRange(SR), Kind, IsTrailingComment, IsAlmostTrailingComment, 
                                Context.getLangOpts().CommentOpts.ParseAllComments);
                     }));
                break;
              }
            }
          }
         //NextCursor:
          Context.Comments.addDeserializedComments(new ArrayRef<RawComment /*P*/ >(Comments, true));
        } finally {
          if (SavedPosition != null) { SavedPosition.$destroy(); }
        }
      }
    } finally {
      if (Comments != null) { Comments.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTReader::isProcessingUpdateRecords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2154,
   FQN="clang::ASTReader::isProcessingUpdateRecords", NM="_ZN5clang9ASTReader25isProcessingUpdateRecordsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTReader25isProcessingUpdateRecordsEv")
  //</editor-fold>
  public boolean isProcessingUpdateRecords() {
    return ProcessingUpdateRecords;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private bool$ref PassingDeclsToConsumer_ref = new bool$ref() {
    @Override
    public boolean $deref() {
      return PassingDeclsToConsumer;
    }
  
    @Override
    public boolean $set(boolean value) {
      PassingDeclsToConsumer = value;
      return PassingDeclsToConsumer;
    }
    
    @Override
    public String toString() {
      return "" + $deref();
    }
    
  };
  
  private type$ref<SourceLocation> CurrentImportLoc_ref = new type$ref<SourceLocation>(){
    @Override
    public SourceLocation $deref() {
      return CurrentImportLoc;
    }
  
    @Override
    public SourceLocation $set(SourceLocation value) {
      CurrentImportLoc = value;
      return CurrentImportLoc;
    }
  };
  
  private uint$ref NumIdentifierLookupHits_ref = new uint$ref(){
    @Override
    public int $deref() {
      return NumIdentifierLookupHits;
    }
  
    @Override
    public int $set(int value) {
      NumIdentifierLookupHits = value;
      return NumIdentifierLookupHits;
    }
    
    @Override
    public String toString() {
      return "" + $deref();
    }
    
  };
  
  private uint$ref NumIdentifierLookups_ref = new uint$ref(){
    @Override
    public int $deref() {
      return NumIdentifierLookups;
    }
  
    @Override
    public int $set(int value) {
      NumIdentifierLookups = value;
      return NumIdentifierLookups;
    }

    @Override
    public String toString() {
      return "" + $deref();
    }
    
  };


  @Override
  public IdentifierInfo get(char$ptr Name, int Len) {
    // TODO: optimize
    return get(new StringRef(Name, Len));
  }

  @Override
  public IdentifierInfo get(byte[] Name, int NameStIndex, int Len) {
    // TODO: optimize
    return get(new StringRef(Name, NameStIndex, Len));
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (true) {
      return "_ReadingKind=" + _ReadingKind; // NOI18N;
    }
    
    return "" + "Listener=" + NativeTrace.getIdentityStr(Listener.get()) // NOI18N
              + ", DeserializationListener=" + NativeTrace.getIdentityStr(DeserializationListener) // NOI18N
              + ", OwnsDeserializationListener=" + OwnsDeserializationListener // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", FileMgr=" + "[FileManager]" // NOI18N
              + ", PCHContainerRdr=" + PCHContainerRdr // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", SemaObj=" + "[Sema]" // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Consumer=" + "[ASTConsumer]" // NOI18N
              + ", ModuleMgr=" + "[ModuleManager]" // NOI18N
              + ", DummyIdResolver=" + DummyIdResolver // NOI18N
              + ", ModuleFileExtensions=" + ModuleFileExtensions // NOI18N
              + ", ReadTimer=" + ReadTimer // NOI18N
              + ", CurrentImportLoc=" + CurrentImportLoc // NOI18N
              + ", GlobalIndex=" + NativeTrace.getIdentityStr(GlobalIndex.get()) // NOI18N
              + ", GlobalBitOffsetsMap=" + GlobalBitOffsetsMap // NOI18N
              + ", GlobalSLocEntryMap=" + GlobalSLocEntryMap // NOI18N
              + ", GlobalSLocOffsetMap=" + GlobalSLocOffsetMap // NOI18N
              + ", TypesLoaded=" + TypesLoaded // NOI18N
              + ", GlobalTypeMap=" + GlobalTypeMap // NOI18N
              + ", DeclsLoaded=" + "[Vector$Decl]" // NOI18N
              + ", GlobalDeclMap=" + GlobalDeclMap // NOI18N
              + ", DeclUpdateOffsets=" + DeclUpdateOffsets // NOI18N
              + ", PendingUpdateRecords=" + PendingUpdateRecords // NOI18N
              + ", PendingFakeDefinitionData=" + PendingFakeDefinitionData // NOI18N
              + ", PendingExceptionSpecUpdates=" + "[SmallMapVector$Decl$FunctionDecl]" // NOI18N
              + ", ImportedTypedefNamesForLinkage=" + "[DenseMap$pairPtrPtr$NamedDecl]" // NOI18N
              + ", AnonymousDeclarationsForMerging=" + AnonymousDeclarationsForMerging // NOI18N
              + ", FileDeclIDs=" + FileDeclIDs // NOI18N
              + ", LexicalDecls=" + LexicalDecls // NOI18N
              + ", TULexicalDecls=" + TULexicalDecls // NOI18N
              + ", Lookups=" + Lookups // NOI18N
              + ", PendingVisibleUpdates=" + PendingVisibleUpdates // NOI18N
              + ", PendingDefinitions=" + "[SmallPtrSet$Decl]" // NOI18N
              + ", PendingBodies=" + "[MapVectorTypeULong$Decl]" // NOI18N
              + ", PendingMergedDefinitionsToDeduplicate=" + "[SetVector$NamedDecl]" // NOI18N
              + ", IdentifiersLoaded=" + IdentifiersLoaded // NOI18N
              + ", GlobalIdentifierMap=" + GlobalIdentifierMap // NOI18N
              + ", MacrosLoaded=" + MacrosLoaded // NOI18N
              + ", LoadedUndefs=" + LoadedUndefs // NOI18N
              + ", GlobalMacroMap=" + GlobalMacroMap // NOI18N
              + ", SubmodulesLoaded=" + SubmodulesLoaded // NOI18N
              + ", GlobalSubmoduleMap=" + GlobalSubmoduleMap // NOI18N
              + ", HiddenNamesMap=" + HiddenNamesMap // NOI18N
              + ", UnresolvedModuleRefs=" + UnresolvedModuleRefs // NOI18N
              + ", SelectorsLoaded=" + SelectorsLoaded // NOI18N
              + ", GlobalSelectorMap=" + GlobalSelectorMap // NOI18N
              + ", SelectorGeneration=" + SelectorGeneration // NOI18N
              + ", SelectorOutOfDate=" + SelectorOutOfDate // NOI18N
              + ", PendingMacroIDs=" + PendingMacroIDs // NOI18N
              + ", GlobalPreprocessedEntityMap=" + GlobalPreprocessedEntityMap // NOI18N
              + ", EagerlyDeserializedDecls=" + EagerlyDeserializedDecls // NOI18N
              + ", TentativeDefinitions=" + TentativeDefinitions // NOI18N
              + ", VTableUses=" + VTableUses // NOI18N
              + ", PendingInstantiations=" + PendingInstantiations // NOI18N
              + ", UnusedFileScopedDecls=" + UnusedFileScopedDecls // NOI18N
              + ", DelegatingCtorDecls=" + DelegatingCtorDecls // NOI18N
              + ", ReferencedSelectorsData=" + ReferencedSelectorsData // NOI18N
              + ", WeakUndeclaredIdentifiers=" + WeakUndeclaredIdentifiers // NOI18N
              + ", ExtVectorDecls=" + ExtVectorDecls // NOI18N
              + ", UnusedLocalTypedefNameCandidates=" + UnusedLocalTypedefNameCandidates // NOI18N
              + ", SemaDeclRefs=" + SemaDeclRefs // NOI18N
              + ", SpecialTypes=" + SpecialTypes // NOI18N
              + ", CUDASpecialDeclRefs=" + CUDASpecialDeclRefs // NOI18N
              + ", FPPragmaOptions=" + FPPragmaOptions // NOI18N
              + ", OptimizeOffPragmaLocation=" + OptimizeOffPragmaLocation // NOI18N
              + ", PragmaMSStructState=" + PragmaMSStructState // NOI18N
              + ", PragmaMSPointersToMembersState=" + PragmaMSPointersToMembersState // NOI18N
              + ", PointersToMembersPragmaLocation=" + PointersToMembersPragmaLocation // NOI18N
              + ", OpenCLExtensions=" + OpenCLExtensions // NOI18N
              + ", KnownNamespaces=" + KnownNamespaces // NOI18N
              + ", UndefinedButUsed=" + UndefinedButUsed // NOI18N
              + ", DelayedDeleteExprs=" + DelayedDeleteExprs // NOI18N
              + ", LateParsedTemplates=" + LateParsedTemplates // NOI18N
              + ", ImportedModules=" + ImportedModules // NOI18N
              + ", CurrentDir=" + CurrentDir // NOI18N
              + ", isysroot=" + isysroot // NOI18N
              + ", DisableValidation=" + DisableValidation // NOI18N
              + ", AllowASTWithCompilerErrors=" + AllowASTWithCompilerErrors // NOI18N
              + ", AllowConfigurationMismatch=" + AllowConfigurationMismatch // NOI18N
              + ", ValidateSystemInputs=" + ValidateSystemInputs // NOI18N
              + ", UseGlobalIndex=" + UseGlobalIndex // NOI18N
              + ", TriedLoadingGlobalIndex=" + TriedLoadingGlobalIndex // NOI18N
              + ", ProcessingUpdateRecords=" + ProcessingUpdateRecords // NOI18N
              + ", SwitchCaseStmts=" + SwitchCaseStmts // NOI18N
              + ", CurrSwitchCaseStmts=" + CurrSwitchCaseStmts // NOI18N
              + ", NumSLocEntriesRead=" + NumSLocEntriesRead // NOI18N
              + ", TotalNumSLocEntries=" + TotalNumSLocEntries // NOI18N
              + ", NumStatementsRead=" + NumStatementsRead // NOI18N
              + ", TotalNumStatements=" + TotalNumStatements // NOI18N
              + ", NumMacrosRead=" + NumMacrosRead // NOI18N
              + ", TotalNumMacros=" + TotalNumMacros // NOI18N
              + ", NumIdentifierLookups=" + NumIdentifierLookups // NOI18N
              + ", NumIdentifierLookupHits=" + NumIdentifierLookupHits // NOI18N
              + ", NumSelectorsRead=" + NumSelectorsRead // NOI18N
              + ", NumMethodPoolEntriesRead=" + NumMethodPoolEntriesRead // NOI18N
              + ", NumMethodPoolLookups=" + NumMethodPoolLookups // NOI18N
              + ", NumMethodPoolHits=" + NumMethodPoolHits // NOI18N
              + ", NumMethodPoolTableLookups=" + NumMethodPoolTableLookups // NOI18N
              + ", NumMethodPoolTableHits=" + NumMethodPoolTableHits // NOI18N
              + ", TotalNumMethodPoolEntries=" + TotalNumMethodPoolEntries // NOI18N
              + ", NumLexicalDeclContextsRead=" + NumLexicalDeclContextsRead // NOI18N
              + ", TotalLexicalDeclContexts=" + TotalLexicalDeclContexts // NOI18N
              + ", NumVisibleDeclContextsRead=" + NumVisibleDeclContextsRead // NOI18N
              + ", TotalVisibleDeclContexts=" + TotalVisibleDeclContexts // NOI18N
              + ", TotalModulesSizeInBits=" + TotalModulesSizeInBits // NOI18N
              + ", NumCurrentElementsDeserializing=" + NumCurrentElementsDeserializing // NOI18N
              + ", PassingDeclsToConsumer=" + PassingDeclsToConsumer // NOI18N
              + ", PendingIdentifierInfos=" + PendingIdentifierInfos // NOI18N
              + ", PendingFakeLookupResults=" + PendingFakeLookupResults // NOI18N
              + ", IdentifierGeneration=" + IdentifierGeneration // NOI18N
              + ", InterestingDecls=" + "[Deque$Decl]" // NOI18N
              + ", PendingDeclChains=" + PendingDeclChains // NOI18N
              + ", PendingIncompleteDeclChains=" + "[SmallVector$Decl]" // NOI18N
              + ", PendingDeclContextInfos=" + PendingDeclContextInfos // NOI18N
              + ", PendingOdrMergeChecks=" + "[SmallVector$NamedDecl]" // NOI18N
              + ", PendingOdrMergeFailures=" + PendingOdrMergeFailures // NOI18N
              + ", DiagnosedOdrMergeFailures=" + "[SmallPtrSet$DeclContext]" // NOI18N
              + ", CategoriesDeserialized=" + "[SmallPtrSet$ObjCCategoryDecl]" // NOI18N
              + ", ObjCClassesLoaded=" + "[SmallVector$ObjCInterfaceDecl]" // NOI18N
              + ", KeyDecls=" + KeyDecls // NOI18N
              + ", MergedDeclContexts=" + "[DenseMap$DeclContext$DeclContext]" // NOI18N
              + ", EnumDefinitions=" + "[DenseMap$EnumDecl$EnumDecl]" // NOI18N
              + ", StmtStack=" + "[SmallVector$Stmt]" // NOI18N
              + ", _ReadingKind=" + _ReadingKind // NOI18N
              + ", SuggestedPredefines=" + SuggestedPredefines // NOI18N
              + ", PreloadedDeclIDs=" + PreloadedDeclIDs // NOI18N
              + ", CommentsCursors=" + CommentsCursors // NOI18N
              + super.toString(); // NOI18N
  }
}
