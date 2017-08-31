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
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.llvm.bitcode.*;
import org.llvm.bitcode.bitc.*;
import org.clang.serialization.*;
import org.clang.serialization.spi.PCHContainerReaderImplementation;
import org.clank.java.stdimpl.aliases.StdVector;
import static org.clang.serialization.impl.GlobalModuleIndexStatics.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.clang.serialization.BlockIDs;
import org.llvm.support.OnDiskIterableChainedHashTable.iterator_base;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;


/// \brief Builder that generates the global module index file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 386,
 FQN="(anonymous namespace)::GlobalModuleIndexBuilder", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderE")
//</editor-fold>
public class GlobalModuleIndexBuilder implements Destructors.ClassWithDestructor {
  private final FileManager /*&*/ FileMgr;
  private final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr;
  
  /// \brief Mapping from files to module file information.
  // JAVA: typedef llvm::MapVector<const FileEntry *, ModuleFileInfo> ModuleFilesMap
//  public final class ModuleFilesMap extends MapVector</*const*/ FileEntry /*P*/ , ModuleFileInfo>{ };
  
  /// \brief Information about each of the known module files.
  private MapVectorPtrType</*const*/ FileEntry /*P*/ , ModuleFileInfo> ModuleFiles;
  
  /// \brief Mapping from identifiers to the list of module file IDs that
  /// consider this identifier to be interesting.
  // JAVA: typedef llvm::StringMap<SmallVector<unsigned int, 2> > InterestingIdentifierMap
//  public final class InterestingIdentifierMap extends StringMap<SmallVectorUInt>{ };
  
  /// \brief A mapping from all interesting identifiers to the set of module
  /// files in which those identifiers are considered interesting.
  private StringMap<SmallVectorUInt> InterestingIdentifiers;
  
  /// \brief Write the block-info block for the global module index file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder::emitBlockInfoBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 460,
   FQN="(anonymous namespace)::GlobalModuleIndexBuilder::emitBlockInfoBlock", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder18emitBlockInfoBlockERN4llvm15BitstreamWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder18emitBlockInfoBlockERN4llvm15BitstreamWriterE")
  //</editor-fold>
  private void emitBlockInfoBlock(final BitstreamWriter /*&*/ Stream) {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    Stream.EnterSubblock(StandardBlockIDs.BLOCKINFO_BLOCK_ID, 3);
    emitBlockID(GLOBAL_INDEX_BLOCK_ID, $("GLOBAL_INDEX_BLOCK"), Stream, Record);
    emitRecordID(IndexRecordTypes.INDEX_METADATA, $("INDEX_METADATA"), Stream, Record);
    emitRecordID(IndexRecordTypes.MODULE, $("MODULE"), Stream, Record);
    emitRecordID(IndexRecordTypes.IDENTIFIER_INDEX, $("IDENTIFIER_INDEX"), Stream, Record);
    
    Stream.ExitBlock();
  }

  
  /// \brief Retrieve the module file information for the given file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder::getModuleFileInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 408,
   FQN="(anonymous namespace)::GlobalModuleIndexBuilder::getModuleFileInfo", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder17getModuleFileInfoEPKN5clang9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder17getModuleFileInfoEPKN5clang9FileEntryE")
  //</editor-fold>
  private ModuleFileInfo /*&*/ getModuleFileInfo(/*const*/ FileEntry /*P*/ File) {
    StdVector.iterator<pairPtrType<FileEntry/*P*/, ModuleFileInfo>> Known = ModuleFiles.find(File);
    if ($noteq___normal_iterator$C(Known, ModuleFiles.end())) {
      return Known.$arrow().second;
    }
    
    /*uint*/int NewID = ModuleFiles.size();
    final ModuleFileInfo /*&*/ Info = ModuleFiles.$at(File);
    Info.ID = NewID;
    return Info;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder::GlobalModuleIndexBuilder">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 421,
   FQN="(anonymous namespace)::GlobalModuleIndexBuilder::GlobalModuleIndexBuilder", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderC1ERN5clang11FileManagerERKNS1_18PCHContainerReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderC1ERN5clang11FileManagerERKNS1_18PCHContainerReaderE")
  //</editor-fold>
  public /*explicit*/ GlobalModuleIndexBuilder(final FileManager /*&*/ FileMgr, final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr) {
    // : FileMgr(FileMgr), PCHContainerRdr(PCHContainerRdr), ModuleFiles(), InterestingIdentifiers() 
    //START JInit
    this./*&*/FileMgr=/*&*/FileMgr;
    this./*&*/PCHContainerRdr=/*&*/PCHContainerRdr;
    this.ModuleFiles = new MapVectorPtrType</*const*/ FileEntry /*P*/ , ModuleFileInfo>(DenseMapInfo$LikePtr.$Info(), new ModuleFileInfo());
    this.InterestingIdentifiers = new StringMap<SmallVectorUInt>(new SmallVectorUInt(2));
    //END JInit
  }

  
  /// \brief Load the contents of the given module file into the builder.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder::loadModuleFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 498,
   FQN="(anonymous namespace)::GlobalModuleIndexBuilder::loadModuleFile", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder14loadModuleFileEPKN5clang9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder14loadModuleFileEPKN5clang9FileEntryE")
  //</editor-fold>
  public boolean loadModuleFile(/*const*/ FileEntry /*P*/ File) {
    ErrorOr<unique_ptr<MemoryBuffer> > Buffer = null;
    BitstreamReader InStreamFile = null;
    BitstreamCursor InStream = null;
    try {
      // Open the module file.
      Buffer = FileMgr.getBufferForFile(File, /*isVolatile=*/ true);
      if (!Buffer.$bool()) {
        return true;
      }
      
      // Initialize the input stream
      InStreamFile/*J*/= new BitstreamReader();
      PCHContainerRdr.ExtractPCH((Buffer.$star()).$arrow().getMemBufferRef(), InStreamFile);
      InStream/*J*/= new BitstreamCursor(InStreamFile);
      
      // Sniff for the signature.
      if (InStream.Read(8) != $char2uint($$C)
         || InStream.Read(8) != $char2uint($$P)
         || InStream.Read(8) != $char2uint($$C)
         || InStream.Read(8) != $char2uint($$H)) {
        return true;
      }
      
      // Record this module file and assign it a unique ID (if it doesn't have
      // one already).
      /*uint*/int ID = getModuleFileInfo(File).ID;
      
      // Search for the blocks and records we care about.
      /*enum ANONYMOUS_INT_CONSTANTS {*/
        final /*uint*/int Other = 0;
        final /*uint*/int ControlBlock = Other + 1;
        final /*uint*/int ASTBlock = ControlBlock + 1;
      /*}*//*Unnamed enum*//*uint*/int State = Other;
      boolean Done = false;
      while (!Done) {
        BitstreamEntry Entry = InStream.advance();
        switch (Entry.Kind) {
         case Error:
          Done = true;
          continue;
         case Record:
          // In the 'other' state, just skip the record. We don't care.
          if (State == Other) {
            InStream.skipRecord(Entry.ID);
            continue;
          }
          
          // Handle potentially-interesting records below.
          break;
         case SubBlock:
          if (Entry.ID == BlockIDs.CONTROL_BLOCK_ID) {
            if (InStream.EnterSubBlock(BlockIDs.CONTROL_BLOCK_ID)) {
              return true;
            }
            
            // Found the control block.
            State = ControlBlock;
            continue;
          }
          if (Entry.ID == BlockIDs.AST_BLOCK_ID) {
            if (InStream.EnterSubBlock(BlockIDs.AST_BLOCK_ID)) {
              return true;
            }
            
            // Found the AST block.
            State = ASTBlock;
            continue;
          }
          if (InStream.SkipBlock()) {
            return true;
          }
          
          continue;
         case EndBlock:
          State = Other;
          continue;
        }
        
        // Read the given record.
        SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
        StringRef Blob/*J*/= new StringRef();
        /*uint*/int Code = InStream.readRecord(Entry.ID, Record, $AddrOf(Blob));
        
        // Handle module dependencies.
        if (State == ControlBlock && Code == ControlRecordTypes.IMPORTS) {
          // Load each of the imported PCH files.
          /*uint*/int Idx = 0;
          /*uint*/int N = Record.size();
          while ($less_uint(Idx, N)) {
            // Read information about the AST file.
            
            // Skip the imported kind
            ++Idx;
            
            // Skip the import location
            ++Idx;
            
            // Load stored size/modification time. 
            long/*off_t*/ StoredSize = (long/*off_t*/)$ullong2long(Record.$at(Idx++));
            long/*time_t*/ StoredModTime = (long/*time_t*/)$ullong2long(Record.$at(Idx++));
            
            // Skip the stored signature.
            // FIXME: we could read the signature out of the import and validate it.
            Idx++;
            
            // Retrieve the imported file name.
            /*uint*/int Length = $ullong2uint(Record.$at(Idx++));
            SmallString/*<128>*/ ImportedFile/*J*/= new SmallString/*<128>*/(128, Record.begin().$add(Idx), 
                Record.begin().$add(Idx).$add(Length));
            Idx += Length;
            
            // Find the imported module file.
            /*const*/ FileEntry /*P*/ DependsOnFile = FileMgr.getFile(ImportedFile.$StringRef(), /*openFile=*/ false, 
                /*cacheFailure=*/ false);
            if (!(DependsOnFile != null)
               || (StoredSize != DependsOnFile.getSize())
               || (StoredModTime != DependsOnFile.getModificationTime())) {
              return true;
            }
            
            // Record the dependency.
            /*uint*/int DependsOnID = getModuleFileInfo(DependsOnFile).ID;
            getModuleFileInfo(File).Dependencies.push_back(DependsOnID);
          }
          
          continue;
        }
        
        // Handle the identifier table
        if (State == ASTBlock && Code == ASTRecordTypes.IDENTIFIER_TABLE && $greater_ullong(Record.$at(0), $int2ullong(0))) {
          std.unique_ptr<OnDiskIterableChainedHashTable<StringRef, StringRef, std.pairTypeBool<StringRef>> > Table = null;
          try {
            // JAVA: typedef llvm::OnDiskIterableChainedHashTable<InterestingASTIdentifierLookupTrait> InterestingIdentifierTable
//            final class InterestingIdentifierTable extends OnDiskIterableChainedHashTable<InterestingASTIdentifierLookupTrait>{ };
            Table/*J*/= new std.unique_ptr<OnDiskIterableChainedHashTable<StringRef, StringRef, std.pairTypeBool<StringRef>> >(
                    OnDiskIterableChainedHashTable.Create(
                            reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()).$add((int)Record.$at(0)), 
                            reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()).$add($sizeof_UInt()), 
                            reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()),
                            new InterestingASTIdentifierLookupTrait()
                    ));
            for (OnDiskIterableChainedHashTable.data_iterator<StringRef, std.pairTypeBool<StringRef>> D = Table.$arrow().data_begin(), 
                DEnd = Table.$arrow().data_end();
                 iterator_base.$noteq_iterator_base$C(D, DEnd); D.$preInc()) {
              std.pairTypeBool<StringRef> Ident = D.$star();
              if (Ident.second) {
                InterestingIdentifiers.$at(/*NO_COPY*/Ident.first).push_back(ID);
              } else {
                /*J:(void)*/InterestingIdentifiers.$at(/*NO_COPY*/Ident.first);
              }
            }
          } finally {
            if (Table != null) { Table.$destroy(); }
          }
        }
        // We don't care about this record.
      }
      
      return false;
    } finally {
      if (InStream != null) { InStream.$destroy(); }
      if (InStreamFile != null) { InStreamFile.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }

  
  /// \brief Write the index to the given bitstream.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder::writeIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 689,
   FQN="(anonymous namespace)::GlobalModuleIndexBuilder::writeIndex", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder10writeIndexERN4llvm15BitstreamWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilder10writeIndexERN4llvm15BitstreamWriterE")
  //</editor-fold>
  public void writeIndex(final BitstreamWriter /*&*/ Stream) {
    //JAVA: using namespace llvm;
    
    // Emit the file header.
    Stream.Emit((/*uint*/int)$char2uint($$B), 8);
    Stream.Emit((/*uint*/int)$char2uint($$C), 8);
    Stream.Emit((/*uint*/int)$char2uint($$G), 8);
    Stream.Emit((/*uint*/int)$char2uint($$I), 8);
    
    // Write the block-info block, which describes the records in this bitcode
    // file.
    emitBlockInfoBlock(Stream);
    
    Stream.EnterSubblock(GLOBAL_INDEX_BLOCK_ID, 3);
    
    // Write the metadata.
    SmallVectorULong Record/*J*/= new SmallVectorULong(2, (long/*uint64_t*/)0);
    Record.push_back($uint2ullong(CurrentVersion));
    Stream.EmitRecord(IndexRecordTypes.INDEX_METADATA, Record);
    
    // Write the set of known module files.
    for (std.vector.iterator<std.pairPtrType</*const*/ FileEntry /*P*/ , ModuleFileInfo> /*P*/> M = ModuleFiles.begin(), 
        MEnd = ModuleFiles.end();
         $noteq___normal_iterator$C(M, MEnd); M.$preInc()) {
      Record.clear();
      Record.push_back($uint2ullong(M.$arrow().second.ID));
      Record.push_back($long2ullong(M.$arrow().first.getSize()));
      Record.push_back($long2ullong(M.$arrow().first.getModificationTime()));
      
      // File name
      StringRef Name/*J*/= new StringRef(M.$arrow().first.getName());
      Record.push_back($uint2ullong(Name.size()));
      Record.append_T(Name.begin(), Name.end());
      
      // Dependencies
      Record.push_back($uint2ullong(M.$arrow().second.Dependencies.size()));
      Record.append_T(M.$arrow().second.Dependencies.begin(), M.$arrow().second.Dependencies.end());
      Stream.EmitRecord(IndexRecordTypes.MODULE, Record);
    }
    {
      OnDiskChainedHashTableGenerator<StringRef, StringRef, SmallVectorUInt> Generator = null;
      try {
        IdentifierIndexWriterTrait Trait/*J*/= new IdentifierIndexWriterTrait();
        Generator/*J*/= new OnDiskChainedHashTableGenerator<StringRef, StringRef, SmallVectorUInt>(Trait);
        
        // Populate the hash table.
        for (StringMapIterator<SmallVectorUInt> I = InterestingIdentifiers.begin(), 
            IEnd = InterestingIdentifiers.end();
             I.$noteq(IEnd); I.$preInc()) {
          Generator.insert(I.$arrow().first(), I.$arrow().second, Trait);
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
        Abbrev.Add(new BitCodeAbbrevOp(IndexRecordTypes.IDENTIFIER_INDEX));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(32)));
        Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob));
        /*uint*/int IDTableAbbrev = Stream.EmitAbbrev(Abbrev);
        
        // Write the identifier table
        long/*uint64_t*/ Record$1[/*2*/] = new$ulong(2, IndexRecordTypes.IDENTIFIER_INDEX, BucketOffset);
        Stream.EmitRecordWithBlob(IDTableAbbrev, Record$1, IdentifierTable.$StringRef());
      } finally {
        if (Generator != null) { Generator.$destroy(); }
      }
    }
    
    Stream.ExitBlock();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GlobalModuleIndexBuilder::~GlobalModuleIndexBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 386,
   FQN="(anonymous namespace)::GlobalModuleIndexBuilder::~GlobalModuleIndexBuilder", NM="_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    InterestingIdentifiers.$destroy();
    ModuleFiles.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "FileMgr=" + "[FileManager]" // NOI18N
              + ", PCHContainerRdr=" + PCHContainerRdr // NOI18N
              + ", ModuleFiles=" + ModuleFiles // NOI18N
              + ", InterestingIdentifiers=" + InterestingIdentifiers; // NOI18N
  }
}
