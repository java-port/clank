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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.bitcode.*;
import org.clang.serialization.aliases.*;
import org.clang.serialization.impl.*;


/// \brief Information about a module that has been loaded by the ASTReader.
///
/// Each instance of the Module class corresponds to a single AST file, which
/// may be a precompiled header, precompiled preamble, a module, or an AST file
/// of some sort loaded as the main file, all of which are specific formulations
/// of the general notion of a "module". A module may depend on any number of
/// other modules.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 100,
 FQN="clang::serialization::ModuleFile", NM="_ZN5clang13serialization10ModuleFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization10ModuleFileE")
//</editor-fold>
public class ModuleFile implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile::ModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp", line = 23,
   FQN="clang::serialization::ModuleFile::ModuleFile", NM="_ZN5clang13serialization10ModuleFileC1ENS0_10ModuleKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization10ModuleFileC1ENS0_10ModuleKindEj")
  //</editor-fold>
  public ModuleFile(ModuleKind Kind, /*uint*/int Generation) {
    // : Kind(Kind), FileName(), ModuleName(), BaseDirectory(), OriginalSourceFileName(), ActualOriginalSourceFileName(), OriginalSourceFileID(), OriginalDir(), ModuleMapPath(), File(null), Signature(0), DirectlyImported(false), Generation(Generation), Buffer(), SizeInBits(0), StreamFile(), Stream(), DirectImportLoc(), ImportLoc(), FirstLoc(), ExtensionReaders(), InputFilesCursor(), InputFilesLoaded(), SLocEntryCursor(), LocalNumSLocEntries(0), SLocEntryBaseID(0), SLocEntryBaseOffset(0), SLocEntryOffsets(null), PreloadSLocEntries(), SLocRemap(), LocalNumIdentifiers(0), IdentifierOffsets(null), BaseIdentifierID(0), IdentifierRemap(), IdentifierTableData(null), IdentifierLookupTable(null), PreloadIdentifierOffsets(), MacroCursor(), LocalNumMacros(0), MacroOffsets(null), MacroRemap(), PreprocessorDetailCursor(), BasePreprocessedEntityID(0), PreprocessedEntityRemap(), PreprocessedEntityOffsets(null), NumPreprocessedEntities(0), LocalNumHeaderFileInfos(0), HeaderFileInfoTableData(null), HeaderFileInfoTable(null), LocalNumSubmodules(0), BaseSubmoduleID(0), SubmoduleRemap(), LocalNumSelectors(0), SelectorOffsets(null), BaseSelectorID(0), SelectorRemap(), SelectorLookupTableData(null), SelectorLookupTable(null), DeclsCursor(), LocalNumDecls(0), DeclOffsets(null), BaseDeclID(0), DeclRemap(), GlobalToLocalDeclIDs(), FileSortedDecls(null), NumFileSortedDecls(0), ObjCCategoriesMap(null), LocalNumObjCCategoriesInMap(0), ObjCCategories(), LocalNumTypes(0), TypeOffsets(null), BaseTypeIndex(0), TypeRemap(), PragmaDiagMappings(), ImportedBy(), Imports() 
    //START JInit
    this.Kind = Kind;
    this.FileName = new std.string();
    this.ModuleName = new std.string();
    this.BaseDirectory = new std.string();
    this.OriginalSourceFileName = new std.string();
    this.ActualOriginalSourceFileName = new std.string();
    this.OriginalSourceFileID = new FileID();
    this.OriginalDir = new std.string();
    this.ModuleMapPath = new std.string();
    this.File = null;
    this.Signature = 0;
    this.DirectlyImported = false;
    this.Generation = Generation;
    this.Buffer = new std.unique_ptr<MemoryBuffer>();
    this.SizeInBits = $int2ulong(0);
    this.StreamFile = new BitstreamReader();
    this.Stream = new BitstreamCursor();
    this.DirectImportLoc = new SourceLocation();
    this.ImportLoc = new SourceLocation();
    this.FirstLoc = new SourceLocation();
    this.ExtensionReaders = new std.vector<std.unique_ptr<ModuleFileExtensionReader>>(new std.unique_ptr<ModuleFileExtensionReader>());
    this.InputFilesCursor = new BitstreamCursor();
    this.InputFilesLoaded = new std.vector<InputFile>(new InputFile());
    this.SLocEntryCursor = new BitstreamCursor();
    this.LocalNumSLocEntries = 0;
    this.SLocEntryBaseID = 0;
    this.SLocEntryBaseOffset = 0;
    this.SLocEntryOffsets = null;
    this.PreloadSLocEntries = new SmallVectorULong(4, (long/*uint64_t*/)0);
    this.SLocRemap = new ContinuousRangeMapUIntInt(2);
    this.LocalNumIdentifiers = 0;
    this.IdentifierOffsets = null;
    this.BaseIdentifierID = 0;
    this.IdentifierRemap = new ContinuousRangeMapUIntInt(2);
    this.IdentifierTableData = null;
    this.IdentifierLookupTable = null;
    this.PreloadIdentifierOffsets = new std.vectorUInt/*uint*/();
    this.MacroCursor = new BitstreamCursor();
    this.LocalNumMacros = 0;
    this.MacroOffsets = null;
    this.MacroRemap = new ContinuousRangeMapUIntInt(2);
    this.PreprocessorDetailCursor = new BitstreamCursor();
    this.BasePreprocessedEntityID = 0;
    this.PreprocessedEntityRemap = new ContinuousRangeMapUIntInt(2);
    this.PreprocessedEntityOffsets = null;
    this.NumPreprocessedEntities = 0;
    this.LocalNumHeaderFileInfos = 0;
    this.HeaderFileInfoTableData = null;
    this.HeaderFileInfoTable = null;
    this.LocalNumSubmodules = 0;
    this.BaseSubmoduleID = 0;
    this.SubmoduleRemap = new ContinuousRangeMapUIntInt(2);
    this.LocalNumSelectors = 0;
    this.SelectorOffsets = null;
    this.BaseSelectorID = 0;
    this.SelectorRemap = new ContinuousRangeMapUIntInt(2);
    this.SelectorLookupTableData = null;
    this.SelectorLookupTable = null;
    this.DeclsCursor = new BitstreamCursor();
    this.LocalNumDecls = 0;
    this.DeclOffsets = null;
    this.BaseDeclID = 0;
    this.DeclRemap = new ContinuousRangeMapUIntInt(2);
    this.GlobalToLocalDeclIDs = new DenseMapTypeUInt<ModuleFile /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.FileSortedDecls = null;
    this.NumFileSortedDecls = 0;
    this.ObjCCategoriesMap = null;
    this.LocalNumObjCCategoriesInMap = 0;
    this.ObjCCategories = new SmallVectorULong(1, (long/*uint64_t*/)0);
    this.LocalNumTypes = 0;
    this.TypeOffsets = null;
    this.BaseTypeIndex = 0;
    this.TypeRemap = new ContinuousRangeMapUIntInt(2);
    this.PragmaDiagMappings = new SmallVectorULong(8, (long/*uint64_t*/)0);
    this.ImportedBy = new SetVector<ModuleFile /*P*/ >((ModuleFile /*P*/ )null);
    this.Imports = new SetVector<ModuleFile /*P*/ >((ModuleFile /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile::~ModuleFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp", line = 45,
   FQN="clang::serialization::ModuleFile::~ModuleFile", NM="_ZN5clang13serialization10ModuleFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization10ModuleFileD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete*/Destructors.$destroy(((/*static_cast*/OnDiskIterableChainedHashTable/*<ASTIdentifierLookupTrait> P*/ )(IdentifierLookupTable)));
    /*delete*/Destructors.$destroy(((/*static_cast*/OnDiskChainedHashTable/*<HeaderFileInfoTrait> P*/ )(HeaderFileInfoTable)));
    /*delete*/Destructors.$destroy(((/*static_cast*/OnDiskChainedHashTable/*<ASTSelectorLookupTrait> P*/ )(SelectorLookupTable)));
    //START JDestroy
    Imports.$destroy();
    ImportedBy.$destroy();
    PragmaDiagMappings.$destroy();
    TypeRemap.$destroy();
    ObjCCategories.$destroy();
    GlobalToLocalDeclIDs.$destroy();
    DeclRemap.$destroy();
    DeclsCursor.$destroy();
    SelectorRemap.$destroy();
    SubmoduleRemap.$destroy();
    PreprocessedEntityRemap.$destroy();
    PreprocessorDetailCursor.$destroy();
    MacroRemap.$destroy();
    MacroCursor.$destroy();
    PreloadIdentifierOffsets.$destroy();
    IdentifierRemap.$destroy();
    SLocRemap.$destroy();
    PreloadSLocEntries.$destroy();
    SLocEntryCursor.$destroy();
    InputFilesLoaded.$destroy();
    InputFilesCursor.$destroy();
    ExtensionReaders.$destroy();
    Stream.$destroy();
    StreamFile.$destroy();
    Buffer.$destroy();
    ModuleMapPath.$destroy();
    OriginalDir.$destroy();
    ActualOriginalSourceFileName.$destroy();
    OriginalSourceFileName.$destroy();
    BaseDirectory.$destroy();
    ModuleName.$destroy();
    FileName.$destroy();
    //END JDestroy
  }

  
  // === General information ===
  
  /// \brief The index of this module in the list of modules.
  public /*uint*/int Index;
  
  /// \brief The type of this module.
  public ModuleKind Kind;
  
  /// \brief The file name of the module file.
  public std.string FileName;
  
  /// \brief The name of the module.
  public std.string ModuleName;
  
  /// \brief The base directory of the module.
  public std.string BaseDirectory;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile::getTimestampFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 122,
   FQN="clang::serialization::ModuleFile::getTimestampFilename", NM="_ZNK5clang13serialization10ModuleFile20getTimestampFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZNK5clang13serialization10ModuleFile20getTimestampFilenameEv")
  //</editor-fold>
  public std.string getTimestampFilename() /*const*/ {
    return $add_string$C_T$C$P(FileName, /*KEEP_STR*/".timestamp");
  }

  
  /// \brief The original source file name that was used to build the
  /// primary AST file, which may have been modified for
  /// relocatable-pch support.
  public std.string OriginalSourceFileName;
  
  /// \brief The actual original source file name that was used to
  /// build this AST file.
  public std.string ActualOriginalSourceFileName;
  
  /// \brief The file ID for the original source file that was used to
  /// build this AST file.
  public FileID OriginalSourceFileID;
  
  /// \brief The directory that the PCH was originally created in. Used to
  /// allow resolving headers even after headers+PCH was moved to a new path.
  public std.string OriginalDir;
  
  public std.string ModuleMapPath;
  
  /// \brief Whether this precompiled header is a relocatable PCH file.
  public boolean RelocatablePCH;
  
  /// \brief Whether timestamps are included in this module file.
  public boolean HasTimestamps;
  
  /// \brief The file entry for the module file.
  public /*const*/ FileEntry /*P*/ File;
  
  /// \brief The signature of the module file, which may be used along with size
  /// and modification time to identify this particular file.
  public /*uint*/int Signature;
  
  /// \brief Whether this module has been directly imported by the
  /// user.
  public boolean DirectlyImported;
  
  /// \brief The generation of which this module file is a part.
  public /*uint*/int Generation;
  
  /// \brief The memory buffer that stores the data associated with
  /// this AST file.
  public std.unique_ptr<MemoryBuffer> Buffer;
  
  /// \brief The size of this file, in bits.
  public long/*uint64_t*/ SizeInBits;
  
  /// \brief The global bit offset (or base) of this module
  public long/*uint64_t*/ GlobalBitOffset;
  
  /// \brief The bitstream reader from which we'll read the AST file.
  public BitstreamReader StreamFile;
  
  /// \brief The main bitstream cursor for the main block.
  public BitstreamCursor Stream;
  
  /// \brief The source location where the module was explicitly or implicitly
  /// imported in the local translation unit.
  ///
  /// If module A depends on and imports module B, both modules will have the
  /// same DirectImportLoc, but different ImportLoc (B's ImportLoc will be a
  /// source location inside module A).
  ///
  /// WARNING: This is largely useless. It doesn't tell you when a module was
  /// made visible, just when the first submodule of that module was imported.
  public SourceLocation DirectImportLoc;
  
  /// \brief The source location where this module was first imported.
  public SourceLocation ImportLoc;
  
  /// \brief The first source location in this module.
  public SourceLocation FirstLoc;
  
  /// The list of extension readers that are attached to this module
  /// file.
  public std.vector<std.unique_ptr<ModuleFileExtensionReader>> ExtensionReaders;
  
  // === Input Files ===
  /// \brief The cursor to the start of the input-files block.
  public BitstreamCursor InputFilesCursor;
  
  /// \brief Offsets for all of the input file entries in the AST file.
  public /*const*//*unaligned_uint64_t*/ulong$ptr /*P*/ InputFileOffsets;
  
  /// \brief The input files that have been loaded from this AST file.
  public std.vector<InputFile> InputFilesLoaded;
  
  /// \brief If non-zero, specifies the time when we last validated input
  /// files.  Zero means we never validated them.
  ///
  /// The time is specified in seconds since the start of the Epoch.
  public long/*uint64_t*/ InputFilesValidationTimestamp;
  
  // === Source Locations ===
  
  /// \brief Cursor used to read source location entries.
  public BitstreamCursor SLocEntryCursor;
  
  /// \brief The number of source location entries in this AST file.
  public /*uint*/int LocalNumSLocEntries;
  
  /// \brief The base ID in the source manager's view of this module.
  public int SLocEntryBaseID;
  
  /// \brief The base offset in the source manager's view of this module.
  public /*uint*/int SLocEntryBaseOffset;
  
  /// \brief Offsets for all of the source location entries in the
  /// AST file.
  public /*const*//*uint32_t P*/uint$ptr SLocEntryOffsets;
  
  /// \brief SLocEntries that we're going to preload.
  public SmallVectorULong PreloadSLocEntries;
  
  /// \brief Remapping table for source locations in this module.
  public ContinuousRangeMapUIntInt SLocRemap;
  
  // === Identifiers ===
  
  /// \brief The number of identifiers in this AST file.
  public /*uint*/int LocalNumIdentifiers;
  
  /// \brief Offsets into the identifier table data.
  ///
  /// This array is indexed by the identifier ID (-1), and provides
  /// the offset into IdentifierTableData where the string data is
  /// stored.
  public /*const*//*uint32_t P*/uint$ptr IdentifierOffsets;
  
  /// \brief Base identifier ID for identifiers local to this module.
  public /*uint32_t*/int BaseIdentifierID;
  
  /// \brief Remapping table for identifier IDs in this module.
  public ContinuousRangeMapUIntInt IdentifierRemap;
  
  /// \brief Actual data for the on-disk hash table of identifiers.
  ///
  /// This pointer points into a memory buffer, where the on-disk hash
  /// table for identifiers actually lives.
  public /*const*/char$ptr/*char P*/ IdentifierTableData;
  
  /// \brief A pointer to an on-disk hash table of opaque type
  /// IdentifierHashTable.
  public Object/*void P*/ IdentifierLookupTable;
  
  /// \brief Offsets of identifiers that we're going to preload within
  /// IdentifierTableData.
  public std.vectorUInt/*uint*/ PreloadIdentifierOffsets;
  
  // === Macros ===
  
  /// \brief The cursor to the start of the preprocessor block, which stores
  /// all of the macro definitions.
  public BitstreamCursor MacroCursor;
  
  /// \brief The number of macros in this AST file.
  public /*uint*/int LocalNumMacros;
  
  /// \brief Offsets of macros in the preprocessor block.
  ///
  /// This array is indexed by the macro ID (-1), and provides
  /// the offset into the preprocessor block where macro definitions are
  /// stored.
  public /*const*//*uint32_t P*/uint$ptr MacroOffsets;
  
  /// \brief Base macro ID for macros local to this module.
  public /*uint32_t*/int BaseMacroID;
  
  /// \brief Remapping table for macro IDs in this module.
  public ContinuousRangeMapUIntInt MacroRemap;
  
  /// \brief The offset of the start of the set of defined macros.
  public long/*uint64_t*/ MacroStartOffset;
  
  // === Detailed PreprocessingRecord ===
  
  /// \brief The cursor to the start of the (optional) detailed preprocessing
  /// record block.
  public BitstreamCursor PreprocessorDetailCursor;
  
  /// \brief The offset of the start of the preprocessor detail cursor.
  public long/*uint64_t*/ PreprocessorDetailStartOffset;
  
  /// \brief Base preprocessed entity ID for preprocessed entities local to
  /// this module.
  public /*uint32_t*/int BasePreprocessedEntityID;
  
  /// \brief Remapping table for preprocessed entity IDs in this module.
  public ContinuousRangeMapUIntInt PreprocessedEntityRemap;
  
  public /*const*/ type$ptr<PPEntityOffset /*P*/> PreprocessedEntityOffsets;
  public /*uint*/int NumPreprocessedEntities;
  
  // === Header search information ===
  
  /// \brief The number of local HeaderFileInfo structures.
  public /*uint*/int LocalNumHeaderFileInfos;
  
  /// \brief Actual data for the on-disk hash table of header file
  /// information.
  ///
  /// This pointer points into a memory buffer, where the on-disk hash
  /// table for header file information actually lives.
  public /*const*/char$ptr/*char P*/ HeaderFileInfoTableData;
  
  /// \brief The on-disk hash table that contains information about each of
  /// the header files.
  public Object/*void P*/ HeaderFileInfoTable;
  
  // === Submodule information ===  
  /// \brief The number of submodules in this module.
  public /*uint*/int LocalNumSubmodules;
  
  /// \brief Base submodule ID for submodules local to this module.
  public /*uint32_t*/int BaseSubmoduleID;
  
  /// \brief Remapping table for submodule IDs in this module.
  public ContinuousRangeMapUIntInt SubmoduleRemap;
  
  // === Selectors ===
  
  /// \brief The number of selectors new to this file.
  ///
  /// This is the number of entries in SelectorOffsets.
  public /*uint*/int LocalNumSelectors;
  
  /// \brief Offsets into the selector lookup table's data array
  /// where each selector resides.
  public /*const*//*uint32_t P*/uint$ptr SelectorOffsets;
  
  /// \brief Base selector ID for selectors local to this module.
  public /*uint32_t*/int BaseSelectorID;
  
  /// \brief Remapping table for selector IDs in this module.
  public ContinuousRangeMapUIntInt SelectorRemap;
  
  /// \brief A pointer to the character data that comprises the selector table
  ///
  /// The SelectorOffsets table refers into this memory.
  public /*const*/char$ptr/*uchar P*/ SelectorLookupTableData;
  
  /// \brief A pointer to an on-disk hash table of opaque type
  /// ASTSelectorLookupTable.
  ///
  /// This hash table provides the IDs of all selectors, and the associated
  /// instance and factory methods.
  public Object/*void P*/ SelectorLookupTable;
  
  // === Declarations ===
  
  /// DeclsCursor - This is a cursor to the start of the DECLS_BLOCK block. It
  /// has read all the abbreviations at the start of the block and is ready to
  /// jump around with these in context.
  public BitstreamCursor DeclsCursor;
  
  /// \brief The number of declarations in this AST file.
  public /*uint*/int LocalNumDecls;
  
  /// \brief Offset of each declaration within the bitstream, indexed
  /// by the declaration ID (-1).
  public /*const*/ type$ptr<DeclOffset> /*P*/ DeclOffsets;
  
  /// \brief Base declaration ID for declarations local to this module.
  public /*uint32_t*/int BaseDeclID;
  
  /// \brief Remapping table for declaration IDs in this module.
  public ContinuousRangeMapUIntInt DeclRemap;
  
  /// \brief Mapping from the module files that this module file depends on
  /// to the base declaration ID for that module as it is understood within this
  /// module.
  ///
  /// This is effectively a reverse global-to-local mapping for declaration
  /// IDs, so that we can interpret a true global ID (for this translation unit)
  /// as a local ID (for this module file).
  public DenseMapTypeUInt<ModuleFile /*P*/ > GlobalToLocalDeclIDs;
  
  /// \brief Array of file-level DeclIDs sorted by file.
  public /*const*//*uint32_t P*/uint$ptr FileSortedDecls;
  public /*uint*/int NumFileSortedDecls;
  
  /// \brief Array of category list location information within this 
  /// module file, sorted by the definition ID.
  public /*const*/ type$ptr<ObjCCategoriesInfo /*P*/> ObjCCategoriesMap;
  
  /// \brief The number of redeclaration info entries in ObjCCategoriesMap.
  public /*uint*/int LocalNumObjCCategoriesInMap;
  
  /// \brief The Objective-C category lists for categories known to this
  /// module.
  public SmallVectorULong ObjCCategories;
  
  // === Types ===
  
  /// \brief The number of types in this AST file.
  public /*uint*/int LocalNumTypes;
  
  /// \brief Offset of each type within the bitstream, indexed by the
  /// type ID, or the representation of a Type*.
  public /*const*//*uint32_t P*/uint$ptr TypeOffsets;
  
  /// \brief Base type ID for types local to this module as represented in
  /// the global type ID space.
  public /*uint32_t*/int BaseTypeIndex;
  
  /// \brief Remapping table for type IDs in this module.
  public ContinuousRangeMapUIntInt TypeRemap;
  
  // === Miscellaneous ===
  
  /// \brief Diagnostic IDs and their mappings that the user changed.
  public SmallVectorULong PragmaDiagMappings;
  
  /// \brief List of modules which depend on this module
  public SetVector<ModuleFile /*P*/ > ImportedBy;
  
  /// \brief List of modules which this module depends on
  public SetVector<ModuleFile /*P*/ > Imports;
  
  /// \brief Determine whether this module was directly imported at
  /// any point during translation.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile::isDirectlyImported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 446,
   FQN="clang::serialization::ModuleFile::isDirectlyImported", NM="_ZNK5clang13serialization10ModuleFile18isDirectlyImportedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZNK5clang13serialization10ModuleFile18isDirectlyImportedEv")
  //</editor-fold>
  public boolean isDirectlyImported() /*const*/ {
    return DirectlyImported;
  }

  
  /// \brief Is this a module file for a module (rather than a PCH or similar).
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile::isModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 449,
   FQN="clang::serialization::ModuleFile::isModule", NM="_ZNK5clang13serialization10ModuleFile8isModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZNK5clang13serialization10ModuleFile8isModuleEv")
  //</editor-fold>
  public boolean isModule() /*const*/ {
    return Kind == ModuleKind.MK_ImplicitModule || Kind == ModuleKind.MK_ExplicitModule;
  }

  
  /// \brief Dump debugging output for this module.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::ModuleFile::dump">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp", line = 66,
   FQN="clang::serialization::ModuleFile::dump", NM="_ZN5clang13serialization10ModuleFile4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp -nm=_ZN5clang13serialization10ModuleFile4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    llvm.errs().$out(/*KEEP_STR*/"\nModule: ").$out(FileName).$out(/*KEEP_STR*/$LF);
    if (!Imports.empty()) {
      llvm.errs().$out(/*KEEP_STR*/"  Imports: ");
      for (/*uint*/int I = 0, N = Imports.size(); I != N; ++I) {
        if ((I != 0)) {
          llvm.errs().$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        llvm.errs().$out(Imports.$at(I).FileName);
      }
      llvm.errs().$out(/*KEEP_STR*/$LF);
    }
    
    // Remapping tables.
    llvm.errs().$out(/*KEEP_STR*/"  Base source location offset: ").$out_uint(SLocEntryBaseOffset).$out_char(
        $$LF
    );
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Source location offset local -> global map"), SLocRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base identifier ID: ").$out_uint(BaseIdentifierID).$out_char($$LF).$out(
        /*KEEP_STR*/"  Number of identifiers: "
    ).$out_uint(LocalNumIdentifiers).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Identifier ID local -> global map"), IdentifierRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base macro ID: ").$out_uint(BaseMacroID).$out_char($$LF).$out(
        /*KEEP_STR*/"  Number of macros: "
    ).$out_uint(LocalNumMacros).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Macro ID local -> global map"), MacroRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base submodule ID: ").$out_uint(BaseSubmoduleID).$out_char($$LF).$out(
        /*KEEP_STR*/"  Number of submodules: "
    ).$out_uint(LocalNumSubmodules).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Submodule ID local -> global map"), SubmoduleRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base selector ID: ").$out_uint(BaseSelectorID).$out_char($$LF).$out(
        /*KEEP_STR*/"  Number of selectors: "
    ).$out_uint(LocalNumSelectors).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Selector ID local -> global map"), SelectorRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base preprocessed entity ID: ").$out_uint(BasePreprocessedEntityID).$out_char(
        $$LF
    ).$out(
        /*KEEP_STR*/"  Number of preprocessed entities: "
    ).$out_uint(
        NumPreprocessedEntities
    ).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Preprocessed entity ID local -> global map"), 
        PreprocessedEntityRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base type index: ").$out_uint(BaseTypeIndex).$out_char($$LF).$out(
        /*KEEP_STR*/"  Number of types: "
    ).$out_uint(LocalNumTypes).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Type index local -> global map"), TypeRemap);
    
    llvm.errs().$out(/*KEEP_STR*/"  Base decl ID: ").$out_uint(BaseDeclID).$out_char($$LF).$out(
        /*KEEP_STR*/"  Number of decls: "
    ).$out_uint(LocalNumDecls).$out_char($$LF);
    ModuleStatics.dumpLocalRemap(new StringRef(/*KEEP_STR*/"Decl ID local -> global map"), DeclRemap);
  }

  
  @Override public String toString() {
    String out = "Index=" + Index // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", FileName=" + FileName // NOI18N
              + ", ModuleName=" + ModuleName // NOI18N
              + ", BaseDirectory=" + BaseDirectory // NOI18N
              + ", OriginalSourceFileName=" + OriginalSourceFileName // NOI18N
              + ", ActualOriginalSourceFileName=" + ActualOriginalSourceFileName; // NOI18N
    if (false) {
         out += ", OriginalSourceFileID=" + OriginalSourceFileID // NOI18N
              + ", OriginalDir=" + OriginalDir // NOI18N
              + ", ModuleMapPath=" + ModuleMapPath // NOI18N
              + ", RelocatablePCH=" + RelocatablePCH // NOI18N
              + ", HasTimestamps=" + HasTimestamps // NOI18N
              + ", File=" + File // NOI18N
              + ", Signature=" + Signature // NOI18N
              + ", DirectlyImported=" + DirectlyImported // NOI18N
              + ", Generation=" + Generation // NOI18N
              + ", Buffer=" + NativeTrace.getIdentityStr(Buffer.get()) // NOI18N
              + ", SizeInBits=" + SizeInBits // NOI18N
              + ", GlobalBitOffset=" + GlobalBitOffset // NOI18N
              + ", StreamFile={" + StreamFile // NOI18N
              + "}, Stream={" + Stream // NOI18N
              + "}, DirectImportLoc=" + DirectImportLoc // NOI18N
              + ", ImportLoc=" + ImportLoc // NOI18N
              + ", FirstLoc=" + FirstLoc // NOI18N
              + ", ExtensionReaders=" + ExtensionReaders.size() // NOI18N
              + ", InputFilesCursor=" + InputFilesCursor // NOI18N
              + ", InputFileOffsets=" + InputFileOffsets // NOI18N
              + ", InputFilesLoaded=" + InputFilesLoaded // NOI18N
              + ", InputFilesValidationTimestamp=" + InputFilesValidationTimestamp // NOI18N
              + ", SLocEntryCursor=" + SLocEntryCursor // NOI18N
              + ", LocalNumSLocEntries=" + LocalNumSLocEntries // NOI18N
              + ", SLocEntryBaseID=" + SLocEntryBaseID // NOI18N
              + ", SLocEntryBaseOffset=" + SLocEntryBaseOffset // NOI18N
              + ", SLocEntryOffsets=" + SLocEntryOffsets // NOI18N
              + ", PreloadSLocEntries=" + PreloadSLocEntries // NOI18N
              + ", SLocRemap=" + SLocRemap // NOI18N
              + ", LocalNumIdentifiers=" + LocalNumIdentifiers // NOI18N
              + ", IdentifierOffsets=" + IdentifierOffsets // NOI18N
              + ", BaseIdentifierID=" + BaseIdentifierID // NOI18N
              + ", IdentifierRemap=" + IdentifierRemap // NOI18N
              + ", IdentifierTableData=" + IdentifierTableData // NOI18N
              + ", IdentifierLookupTable=" + NativeTrace.getIdentityStr(IdentifierLookupTable) // NOI18N
              + ", PreloadIdentifierOffsets=" + PreloadIdentifierOffsets // NOI18N
              + ", MacroCursor=" + MacroCursor // NOI18N
              + ", LocalNumMacros=" + LocalNumMacros // NOI18N
              + ", MacroOffsets=" + MacroOffsets // NOI18N
              + ", BaseMacroID=" + BaseMacroID // NOI18N
              + ", MacroRemap=" + MacroRemap // NOI18N
              + ", MacroStartOffset=" + MacroStartOffset // NOI18N
              + ", PreprocessorDetailCursor=" + PreprocessorDetailCursor // NOI18N
              + ", PreprocessorDetailStartOffset=" + PreprocessorDetailStartOffset // NOI18N
              + ", BasePreprocessedEntityID=" + BasePreprocessedEntityID // NOI18N
              + ", PreprocessedEntityRemap=" + PreprocessedEntityRemap // NOI18N
              + ", PreprocessedEntityOffsets=" + PreprocessedEntityOffsets // NOI18N
              + ", NumPreprocessedEntities=" + NumPreprocessedEntities // NOI18N
              + ", LocalNumHeaderFileInfos=" + LocalNumHeaderFileInfos // NOI18N
              + ", HeaderFileInfoTableData=" + HeaderFileInfoTableData // NOI18N
              + ", HeaderFileInfoTable=" + NativeTrace.getIdentityStr(HeaderFileInfoTable) // NOI18N
              + ", LocalNumSubmodules=" + LocalNumSubmodules // NOI18N
              + ", BaseSubmoduleID=" + BaseSubmoduleID // NOI18N
              + ", SubmoduleRemap=" + SubmoduleRemap // NOI18N
              + ", LocalNumSelectors=" + LocalNumSelectors // NOI18N
              + ", SelectorOffsets=" + SelectorOffsets // NOI18N
              + ", BaseSelectorID=" + BaseSelectorID // NOI18N
              + ", SelectorRemap=" + SelectorRemap // NOI18N
              + ", SelectorLookupTableData=" + SelectorLookupTableData // NOI18N
              + ", SelectorLookupTable=" + NativeTrace.getIdentityStr(SelectorLookupTable) // NOI18N
              + ", DeclsCursor=" + DeclsCursor // NOI18N
              + ", LocalNumDecls=" + LocalNumDecls // NOI18N
              + ", DeclOffsets=" + DeclOffsets // NOI18N
              + ", BaseDeclID=" + BaseDeclID // NOI18N
              + ", DeclRemap=" + DeclRemap // NOI18N
              + ", GlobalToLocalDeclIDs=" + GlobalToLocalDeclIDs // NOI18N
              + ", FileSortedDecls=" + FileSortedDecls // NOI18N
              + ", NumFileSortedDecls=" + NumFileSortedDecls // NOI18N
              + ", ObjCCategoriesMap=" + ObjCCategoriesMap // NOI18N
              + ", LocalNumObjCCategoriesInMap=" + LocalNumObjCCategoriesInMap // NOI18N
              + ", ObjCCategories=" + ObjCCategories // NOI18N
              + ", LocalNumTypes=" + LocalNumTypes // NOI18N
              + ", TypeOffsets=" + TypeOffsets // NOI18N
              + ", BaseTypeIndex=" + BaseTypeIndex // NOI18N
              + ", TypeRemap=" + TypeRemap // NOI18N
              + ", PragmaDiagMappings=" + PragmaDiagMappings // NOI18N
              + ", ImportedBy=" + ImportedBy // NOI18N
              + ", Imports=" + Imports; // NOI18N
    }
    return out;
  }
}
