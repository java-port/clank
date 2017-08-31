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
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.llvm.bitcode.*;
import org.clang.serialization.impl.*;
import org.llvm.support.sys.path;
import org.clang.serialization.spi.PCHContainerReaderImplementation;
import static org.clang.serialization.impl.GlobalModuleIndexStatics.CurrentVersion;
import static org.clang.serialization.impl.GlobalModuleIndexStatics.GLOBAL_INDEX_BLOCK_ID;
import static org.clang.serialization.impl.GlobalModuleIndexStatics.IndexFileName;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.sys.fs;


/// \brief A global index for a set of module files, providing information about
/// the identifiers within those module files.
///
/// The global index is an aid for name lookup into modules, offering a central
/// place where one can look for identifiers determine which
/// module files contain any information about that identifier. This
/// allows the client to restrict the search to only those module files known
/// to have a information about that identifier, improving performance. Moreover,
/// the global module index may know about module files that have not been
/// imported, and can be queried to determine which modules the current
/// translation could or should load to fix a problem.
//<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 61,
 FQN="clang::GlobalModuleIndex", NM="_ZN5clang17GlobalModuleIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndexE")
//</editor-fold>
public class GlobalModuleIndex implements org.clang.lex.spi.GlobalModuleIndexImplementation, Destructors.ClassWithDestructor {
  /// \brief Buffer containing the index file, which is lazily accessed so long
  /// as the global module index is live.
  private std.unique_ptr<MemoryBuffer> Buffer;
  
  /// \brief The hash table.
  ///
  /// This pointer actually points to a IdentifierIndexTable object,
  /// but that type is only accessible within the implementation of
  /// GlobalModuleIndex.
  private Object/*void P*/ IdentifierIndex;
  
  /// \brief Information about a given module file.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::ModuleInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 74,
   FQN="clang::GlobalModuleIndex::ModuleInfo", NM="_ZN5clang17GlobalModuleIndex10ModuleInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex10ModuleInfoE")
  //</editor-fold>
  private static class/*struct*/ ModuleInfo implements Destructors.ClassWithDestructor, NativeCloneable<ModuleInfo>, NativeMoveable<ModuleInfo> {
    //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::ModuleInfo::ModuleInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 75,
     FQN="clang::GlobalModuleIndex::ModuleInfo::ModuleInfo", NM="_ZN5clang17GlobalModuleIndex10ModuleInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex10ModuleInfoC1Ev")
    //</editor-fold>
    public ModuleInfo() {
      // : File(implicit ModuleFile * ()), FileName(), Size(implicit off_t()), ModTime(implicit time_t()), Dependencies() 
      //START JInit
      this.File = /*implicit-init*/((ModuleFile /*P*/ )/*zero-init*/null);
      this.FileName = new std.string();
      this.Size = /*implicit-init*/((long/*off_t*/)/*zero-init*/0);
      this.ModTime = /*implicit-init*/((long/*time_t*/)/*zero-init*/0);
      this.Dependencies = new SmallVectorUInt(4, 0);
      //END JInit
    }

    
    /// \brief The module file, once it has been resolved.
    public ModuleFile /*P*/ File;
    
    /// \brief The module file name.
    public std.string FileName;
    
    /// \brief Size of the module file at the time the global index was built.
    public long/*off_t*/ Size;
    
    /// \brief Modification time of the module file at the time the global
    /// index was built.
    public long/*time_t*/ ModTime;
    
    /// \brief The module IDs on which this module directly depends.
    /// FIXME: We don't really need a vector here.
    public SmallVectorUInt Dependencies;
    //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::ModuleInfo::ModuleInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 74,
     FQN="clang::GlobalModuleIndex::ModuleInfo::ModuleInfo", NM="_ZN5clang17GlobalModuleIndex10ModuleInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex10ModuleInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ModuleInfo(JD$Move _dparam, final ModuleInfo /*&&*/$Prm0) {
      // : File(static_cast<ModuleInfo &&>().File), FileName(static_cast<ModuleInfo &&>().FileName), Size(static_cast<ModuleInfo &&>().Size), ModTime(static_cast<ModuleInfo &&>().ModTime), Dependencies(static_cast<ModuleInfo &&>().Dependencies) 
      //START JInit
      this.File = $Prm0.File;
      this.FileName = new std.string(JD$Move.INSTANCE, $Prm0.FileName);
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      this.Dependencies = new SmallVectorUInt(JD$Move.INSTANCE, $Prm0.Dependencies);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::ModuleInfo::~ModuleInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 74,
     FQN="clang::GlobalModuleIndex::ModuleInfo::~ModuleInfo", NM="_ZN5clang17GlobalModuleIndex10ModuleInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex10ModuleInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Dependencies.$destroy();
      FileName.$destroy();
      //END JDestroy
    }

    public /*inline*/ ModuleInfo(final ModuleInfo /*&&*/$Prm0) {
      // : File(static_cast<ModuleInfo &&>().File), FileName(static_cast<ModuleInfo &&>().FileName), Size(static_cast<ModuleInfo &&>().Size), ModTime(static_cast<ModuleInfo &&>().ModTime), Dependencies(static_cast<ModuleInfo &&>().Dependencies) 
      //START JInit
      this.File = $Prm0.File;
      this.FileName = new std.string($Prm0.FileName);
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      this.Dependencies = new SmallVectorUInt($Prm0.Dependencies);
      //END JInit
    }
    
    @Override public ModuleInfo clone() {
      return new ModuleInfo(this);
    }
    
    @Override public ModuleInfo move() {
      return new ModuleInfo(JD$Move.INSTANCE, this);
    }
    
    
    @Override public String toString() {
      return "" + "File=" + File // NOI18N
                + ", FileName=" + FileName // NOI18N
                + ", Size=" + Size // NOI18N
                + ", ModTime=" + ModTime // NOI18N
                + ", Dependencies=" + Dependencies; // NOI18N
    }
  };
  
  /// \brief A mapping from module IDs to information about each module.
  ///
  /// This vector may have gaps, if module files have been removed or have
  /// been updated since the index was built. A gap is indicated by an empty
  /// file name.
  private SmallVector<ModuleInfo> Modules;
  
  /// \brief Lazily-populated mapping from module files to their
  /// corresponding index into the \c Modules vector.
  private DenseMapTypeUInt<ModuleFile /*P*/> ModulesByFile;
  
  /// \brief The set of modules that have not yet been resolved.
  ///
  /// The string is just the name of the module itself, which maps to the
  /// module ID.
  private StringMapUInt UnresolvedModules;
  
  /// \brief The number of identifier lookups we performed.
  private /*uint*/int NumIdentifierLookups;
  
  /// \brief The number of identifier lookup hits, where we recognize the
  /// identifier.
  private /*uint*/int NumIdentifierLookupHits;
  
  /// \brief Internal constructor. Use \c readIndex() to read an index.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::GlobalModuleIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 126,
   FQN="clang::GlobalModuleIndex::GlobalModuleIndex", NM="_ZN5clang17GlobalModuleIndexC1ESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EENS2_15BitstreamCursorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndexC1ESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EENS2_15BitstreamCursorE")
  //</editor-fold>
  private GlobalModuleIndex(std.unique_ptr<MemoryBuffer> Buffer, 
      BitstreamCursor Cursor) {
    // : Buffer(std::move(Buffer)), IdentifierIndex(implicit void * ()), Modules(), ModulesByFile(), UnresolvedModules(), NumIdentifierLookups(implicit unsigned int()), NumIdentifierLookupHits(implicit unsigned int()) 
    //START JInit
    this.Buffer = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer));
    this.IdentifierIndex = /*implicit-init*/((Object/*void P*/ )/*zero-init*/null);
    this.Modules = new SmallVector<ModuleInfo>(16, new ModuleInfo());
    this.ModulesByFile = new DenseMapTypeUInt<ModuleFile /*P*/>(DenseMapInfo$LikePtr.$Info(), 0);
    this.UnresolvedModules = new StringMapUInt((/*uint*/int)0);
    this.NumIdentifierLookups = /*implicit-init*/((/*uint*/int)/*zero-init*/0);
    this.NumIdentifierLookupHits = /*implicit-init*/((/*uint*/int)/*zero-init*/0);
    //END JInit
    // Read the global index.
    boolean InGlobalIndexBlock = false;
    boolean Done = false;
    while (!Done) {
      BitstreamEntry Entry = Cursor.advance();
      switch (Entry.Kind) {
       case Error:
        return;
       case EndBlock:
        if (InGlobalIndexBlock) {
          InGlobalIndexBlock = false;
          Done = true;
          continue;
        }
        return;
       case Record:
        // Entries in the global index block are handled below.
        if (InGlobalIndexBlock) {
          break;
        }
        
        return;
       case SubBlock:
        if (!InGlobalIndexBlock && Entry.ID == GLOBAL_INDEX_BLOCK_ID) {
          if (Cursor.EnterSubBlock(GLOBAL_INDEX_BLOCK_ID)) {
            return;
          }
          
          InGlobalIndexBlock = true;
        } else if (Cursor.SkipBlock()) {
          return;
        }
        continue;
      }
      
      SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
      StringRef Blob/*J*/= new StringRef();
      switch (Cursor.readRecord(Entry.ID, Record, $AddrOf(Blob))) {
       case IndexRecordTypes.INDEX_METADATA:
        // Make sure that the version matches.
        if ($less_uint(Record.size(), 1) || Record.$at(0) != $uint2ullong(CurrentVersion)) {
          return;
        }
        break;
       case IndexRecordTypes.MODULE:
        {
          /*uint*/int Idx = 0;
          /*uint*/int ID = $ullong2uint(Record.$at(Idx++));
          
          // Make room for this module's information.
          if (ID == Modules.size()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              Modules.push_back_T$RR($c$.track(new ModuleInfo())); $c$.clean();
            } finally {
              $c$.$destroy();
            }
          } else {
            Modules.resize(ID + 1);
          }
          
          // Size/modification time for this module file at the time the
          // global index was built.
          Modules.$at(ID).Size = $ullong2long(Record.$at(Idx++));
          Modules.$at(ID).ModTime = $ullong2long(Record.$at(Idx++));
          
          // File name.
          /*uint*/int NameLen = $ullong2uint(Record.$at(Idx++));
          Modules.$at(ID).FileName.assign$T(Record.begin().$add(Idx), 
              Record.begin().$add(Idx).$add(NameLen));
          Idx += NameLen;
          
          // Dependencies
          /*uint*/int NumDeps = $ullong2uint(Record.$at(Idx++));
          Modules.$at(ID).Dependencies.insert_iterator$T_T(Modules.$at(ID).Dependencies.end(), 
              Record.begin().$add(Idx), 
              Record.begin().$add(Idx).$add(NumDeps));
          Idx += NumDeps;
          
          // Make sure we're at the end of the record.
          assert (Idx == Record.size()) : "More module info?";
          
          // Record this module as an unresolved module.
          // FIXME: this doesn't work correctly for module names containing path
          // separators.
          StringRef ModuleName = path.stem(new StringRef(Modules.$at(ID).FileName));
          // Remove the -<hash of ModuleMapPath>
          ModuleName.$assignMove(ModuleName.rsplit($$MINUS).first);
          UnresolvedModules.$set(/*NO_COPY*/ModuleName, ID);
          break;
        }
       case IndexRecordTypes.IDENTIFIER_INDEX:
        // Wire up the identifier index.
        if ((Record.$at(0) != 0)) {
          IdentifierIndex = OnDiskIterableChainedHashTable.Create(
                  reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()).$add((int)Record.$at(0)), 
                  reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()).$add($sizeof_UInt()), 
                  reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Blob.data()), IdentifierIndexReaderTrait.$Trait());
        }
        break;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::GlobalModuleIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 123,
   FQN="clang::GlobalModuleIndex::GlobalModuleIndex", NM="_ZN5clang17GlobalModuleIndexC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndexC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalModuleIndex(final /*const*/ GlobalModuleIndex /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 124,
   FQN="clang::GlobalModuleIndex::operator=", NM="_ZN5clang17GlobalModuleIndexaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndexaSERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalModuleIndex /*&*/ $assign(final /*const*/ GlobalModuleIndex /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::~GlobalModuleIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 231,
   FQN="clang::GlobalModuleIndex::~GlobalModuleIndex", NM="_ZN5clang17GlobalModuleIndexD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndexD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete*/Destructors.$destroy(((/*static_cast*/OnDiskIterableChainedHashTable<StringRef, StringRef, SmallVectorUInt> /*P*/ )(IdentifierIndex)));
    //START JDestroy
    UnresolvedModules.$destroy();
    ModulesByFile.$destroy();
    Modules.$destroy();
    Buffer.$destroy();
    //END JDestroy
  }

  
  /// \brief An error code returned when trying to read an index.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::ErrorCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/GlobalModuleIndex.h", line = 130,
   FQN="clang::GlobalModuleIndex::ErrorCode", NM="_ZN5clang17GlobalModuleIndex9ErrorCodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex9ErrorCodeE")
  //</editor-fold>
  public enum ErrorCode implements Native.NativeUIntEnum {
    /// \brief No error occurred.
    EC_None(0),
    /// \brief No index was found.
    EC_NotFound(EC_None.getValue() + 1),
    /// \brief Some other process is currently building the index; it is not
    /// available yet.
    EC_Building(EC_NotFound.getValue() + 1),
    /// \brief There was an unspecified I/O error reading or writing the index.
    EC_IOError(EC_Building.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ErrorCode valueOf(int val) {
      ErrorCode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ErrorCode[] VALUES;
      private static final ErrorCode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ErrorCode kind : ErrorCode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ErrorCode[min < 0 ? (1-min) : 0];
        VALUES = new ErrorCode[max >= 0 ? (1+max) : 0];
        for (ErrorCode kind : ErrorCode.values()) {
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
    private ErrorCode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Read a global index file for the given directory.
  ///
  /// \param Path The path to the specific module cache where the module files
  /// for the intended configuration reside.
  ///
  /// \returns A pair containing the global module index (if it exists) and
  /// the error code.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::readIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 235,
   FQN="clang::GlobalModuleIndex::readIndex", NM="_ZN5clang17GlobalModuleIndex9readIndexEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex9readIndexEN4llvm9StringRefE")
  //</editor-fold>
  public static std.pairPtrType<GlobalModuleIndex /*P*/ , GlobalModuleIndex.ErrorCode> readIndex(StringRef Path) {
    ErrorOr<std.unique_ptr<MemoryBuffer> > BufferOrErr = null;
    std.unique_ptr<MemoryBuffer> Buffer = null;
    BitstreamReader Reader = null;
    BitstreamCursor Cursor = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Load the index file, if it's there.
      SmallString/*<128>*/ IndexPath/*J*/= new SmallString/*<128>*/(128);
      IndexPath.$addassign(/*NO_COPY*/Path);
      path.append(IndexPath, new Twine(IndexFileName));
      
      BufferOrErr = MemoryBuffer.getFile(new Twine(IndexPath.c_str()));
      if (!BufferOrErr.$bool()) {
        return new std.pairPtrType<GlobalModuleIndex /*P*/ , GlobalModuleIndex.ErrorCode>(JD$Pair$_U1$_U2.INSTANCE, (GlobalModuleIndex /*P*/ )null, /*Fwd2*//*Fwd*/ErrorCode.EC_NotFound);
      }
      Buffer = new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(BufferOrErr.get()));
      
      /// \brief The bitstream reader from which we'll read the AST file.
      Reader/*J*/= new BitstreamReader(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buffer.$arrow().getBufferStart()), 
          reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buffer.$arrow().getBufferEnd()));
      
      /// \brief The main bitstream cursor for the main block.
      Cursor/*J*/= new BitstreamCursor(Reader);
      
      // Sniff for the signature.
      if (Cursor.Read(8) != $char2uint($$B)
         || Cursor.Read(8) != $char2uint($$C)
         || Cursor.Read(8) != $char2uint($$G)
         || Cursor.Read(8) != $char2uint($$I)) {
        return new std.pairPtrType<GlobalModuleIndex /*P*/ , GlobalModuleIndex.ErrorCode>(JD$Pair$_U1$_U2.INSTANCE, (GlobalModuleIndex /*P*/ )null, /*Fwd2*//*Fwd*/ErrorCode.EC_IOError);
      }
      
      return $c$.clean(std.make_pair_Ptr_T(new GlobalModuleIndex($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer))), $c$.track(new BitstreamCursor(Cursor))), ErrorCode.EC_None
          ));
    } finally {
      if (Cursor != null) { Cursor.$destroy(); }
      if (Reader != null) { Reader.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
      if (BufferOrErr != null) { BufferOrErr.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Returns an iterator for identifiers stored in the index table.
  ///
  /// The caller accepts ownership of the returned object.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::createIdentifierIterator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 885,
   FQN="clang::GlobalModuleIndex::createIdentifierIterator", NM="_ZNK5clang17GlobalModuleIndex24createIdentifierIteratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZNK5clang17GlobalModuleIndex24createIdentifierIteratorEv")
  //</editor-fold>
  public IdentifierIterator /*P*/ createIdentifierIterator() /*const*/ {
    final OnDiskIterableChainedHashTable<StringRef, StringRef, SmallVectorUInt> /*&*/ Table = $Deref(((/*static_cast*/OnDiskIterableChainedHashTable<StringRef, StringRef, SmallVectorUInt> /*P*/ )(IdentifierIndex)));
    return new GlobalIndexIdentifierIterator(Table);
  }

  
  /// \brief Retrieve the set of modules that have up-to-date indexes.
  ///
  /// \param ModuleFiles Will be populated with the set of module files that
  /// have been indexed.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::getKnownModules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 267,
   FQN="clang::GlobalModuleIndex::getKnownModules", NM="_ZN5clang17GlobalModuleIndex15getKnownModulesERN4llvm15SmallVectorImplIPNS_13serialization10ModuleFileEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex15getKnownModulesERN4llvm15SmallVectorImplIPNS_13serialization10ModuleFileEEE")
  //</editor-fold>
  public void getKnownModules(final SmallVectorImpl<ModuleFile /*P*/ > /*&*/ ModuleFiles) {
    ModuleFiles.clear();
    for (/*uint*/int I = 0, N = Modules.size(); I != N; ++I) {
      {
        ModuleFile /*P*/ MF = Modules.$at(I).File;
        if ((MF != null)) {
          ModuleFiles.push_back(MF);
        }
      }
    }
  }

  
  /// \brief Retrieve the set of module files on which the given module file
  /// directly depends.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::getModuleDependencies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 276,
   FQN="clang::GlobalModuleIndex::getModuleDependencies", NM="_ZN5clang17GlobalModuleIndex21getModuleDependenciesEPNS_13serialization10ModuleFileERN4llvm15SmallVectorImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex21getModuleDependenciesEPNS_13serialization10ModuleFileERN4llvm15SmallVectorImplIS3_EE")
  //</editor-fold>
  public void getModuleDependencies(ModuleFile /*P*/ File, 
                       final SmallVectorImpl<ModuleFile /*P*/ > /*&*/ Dependencies) {
    // Look for information about this module file.
    DenseMapIteratorTypeUInt<ModuleFile /*P*/ /*P*/> Known = ModulesByFile.find(File);
    if (Known.$eq(/*NO_ITER_COPY*/ModulesByFile.end())) {
      return;
    }
    
    // Record dependencies.
    Dependencies.clear();
    ArrayRefUInt StoredDependencies = new ArrayRefUInt(Modules.$at(Known.$arrow().second).Dependencies);
    for (/*uint*/int I = 0, N = StoredDependencies.size(); I != N; ++I) {
      {
        ModuleFile /*P*/ MF = Modules.$at(I).File;
        if ((MF != null)) {
          Dependencies.push_back(MF);
        }
      }
    }
  }

  
  /// \brief A set of module files in which we found a result.
  // JAVA: typedef llvm::SmallPtrSet<ModuleFile *, 4> HitSet
//  public final class HitSet extends SmallPtrSet<ModuleFile /*P*/>{ };
  
  /// \brief Look for all of the module files with information about the given
  /// identifier, e.g., a global function, variable, or type with that name.
  ///
  /// \param Name The identifier to look for.
  ///
  /// \param Hits Will be populated with the set of module files that have
  /// information about this name.
  ///
  /// \returns true if the identifier is known to the index, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::lookupIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 294,
   FQN="clang::GlobalModuleIndex::lookupIdentifier", NM="_ZN5clang17GlobalModuleIndex16lookupIdentifierEN4llvm9StringRefERNS1_11SmallPtrSetIPNS_13serialization10ModuleFileELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex16lookupIdentifierEN4llvm9StringRefERNS1_11SmallPtrSetIPNS_13serialization10ModuleFileELj4EEE")
  //</editor-fold>
  public boolean lookupIdentifier(StringRef Name, final SmallPtrSet<ModuleFile /*P*/> /*&*/ Hits) {
    Hits.clear();
    
    // If there's no identifier index, there is nothing we can do.
    if (!(IdentifierIndex != null)) {
      return false;
    }
    
    // Look into the identifier index.
    ++NumIdentifierLookups;
    final OnDiskIterableChainedHashTable<StringRef, StringRef, SmallVectorUInt> /*&*/ Table = $Deref(((/*static_cast*/OnDiskIterableChainedHashTable /*P*/ )(IdentifierIndex)));
//    OnDiskIterableChainedHashTable.iterator<StringRef, StringRef, SmallVectorUInt> Known = Table.find(Name);
//    if (Known.$eq(Table.end())) {
//      return true;
//    }
    SmallVectorUInt Known = Table.$get(Name);
    if (Known == null) {
      return true;
    }
    
    SmallVectorUInt ModuleIDs = Known/*.$star()*/;
    for (/*uint*/int I = 0, N = ModuleIDs.size(); I != N; ++I) {
      {
        ModuleFile /*P*/ MF = Modules.$at(ModuleIDs.$at(I)).File;
        if ((MF != null)) {
          Hits.insert(MF);
        }
      }
    }
    
    ++NumIdentifierLookupHits;
    return true;
  }

  
  /// \brief Note that the given module file has been loaded.
  ///
  /// \returns false if the global module index has information about this
  /// module file, and true otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::loadedModuleFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 320,
   FQN="clang::GlobalModuleIndex::loadedModuleFile", NM="_ZN5clang17GlobalModuleIndex16loadedModuleFileEPNS_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex16loadedModuleFileEPNS_13serialization10ModuleFileE")
  //</editor-fold>
  public boolean loadedModuleFile(ModuleFile /*P*/ File) {
    // Look for the module in the global module index based on the module name.
    StringRef Name = new StringRef(File.ModuleName);
    StringMapIteratorUInt Known = UnresolvedModules.find(/*NO_COPY*/Name);
    if (Known.$eq(UnresolvedModules.end())) {
      return true;
    }
    
    // Rectify this module with the global module index.
    final ModuleInfo /*&*/ Info = Modules.$at(Known.$arrow().second);
    
    //  If the size and modification time match what we expected, record this
    // module file.
    boolean Failed = true;
    if (File.File.getSize() == Info.Size
       && File.File.getModificationTime() == Info.ModTime) {
      Info.File = File;
      ModulesByFile.$set(File, Known.$arrow().second);
      
      Failed = false;
    }
    
    // One way or another, we have resolved this module file.
    UnresolvedModules.erase(/*NO_COPY*/Known);
    return Failed;
  }

  
  /// \brief Print statistics to standard error.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::printStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 347,
   FQN="clang::GlobalModuleIndex::printStats", NM="_ZN5clang17GlobalModuleIndex10printStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex10printStatsEv")
  //</editor-fold>
  public void printStats() {
    std.fprintf(stderr, /*KEEP_STR*/"*** Global Module Index Statistics:\n");
    if ((NumIdentifierLookups != 0)) {
      fprintf(stderr, /*KEEP_STR*/"  %u / %u identifier lookups succeeded (%f%%)\n", 
          NumIdentifierLookupHits, NumIdentifierLookups, 
          (double)NumIdentifierLookupHits * 100. / NumIdentifierLookups);
    }
    std.fprintf(stderr, /*KEEP_STR*/"\n");
  }

  
  /// \brief Print debugging view to standard error.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 357,
   FQN="clang::GlobalModuleIndex::dump", NM="_ZN5clang17GlobalModuleIndex4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    llvm.errs().$out(/*KEEP_STR*/"*** Global Module Index Dump:\n");
    llvm.errs().$out(/*KEEP_STR*/"Module files:\n");
    for (final ModuleInfo /*&*/ MI : Modules) {
      llvm.errs().$out(/*KEEP_STR*/"** ").$out(MI.FileName).$out(/*KEEP_STR*/$LF);
      if ((MI.File != null)) {
        MI.File.dump();
      } else {
        llvm.errs().$out(/*KEEP_STR*/$LF);
      }
    }
    llvm.errs().$out(/*KEEP_STR*/$LF);
  }

  
  /// \brief Write a global index into the given
  ///
  /// \param FileMgr The file manager to use to load module files.
  /// \param PCHContainerRdr - The PCHContainerOperations to use for loading and
  /// creating modules.
  /// \param Path The path to the directory containing module files, into
  /// which the global index will be written.
  //<editor-fold defaultstate="collapsed" desc="clang::GlobalModuleIndex::writeIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp", line = 767,
   FQN="clang::GlobalModuleIndex::writeIndex", NM="_ZN5clang17GlobalModuleIndex10writeIndexERNS_11FileManagerERKNS_18PCHContainerReaderEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp -nm=_ZN5clang17GlobalModuleIndex10writeIndexERNS_11FileManagerERKNS_18PCHContainerReaderEN4llvm9StringRefE")
  //</editor-fold>
  public static GlobalModuleIndex.ErrorCode writeIndex(final FileManager /*&*/ FileMgr, 
            final /*const*/PCHContainerReaderImplementation/*&*/ PCHContainerRdr, 
            StringRef Path) {
    LockFileManager Locked = null;
    GlobalModuleIndexBuilder Builder = null;
    raw_fd_ostream Out = null;
    try {
      SmallString/*<128>*/ IndexPath/*J*/= new SmallString/*<128>*/(128);
      IndexPath.$addassign(/*NO_COPY*/Path);
      path.append(IndexPath, new Twine(IndexFileName));
      
      // Coordinate building the global index file with other processes that might
      // try to do the same.
      Locked/*J*/= new LockFileManager(IndexPath.$StringRef());
      switch (Locked.$LockFileState()) {
       case LFS_Error:
        return ErrorCode.EC_IOError;
       case LFS_Owned:
        // We're responsible for building the index ourselves. Do so below.
        break;
       case LFS_Shared:
        // Someone else is responsible for building the index. We don't care
        // when they finish, so we're done.
        return ErrorCode.EC_Building;
      }
      
      // The module index builder.
      Builder/*J*/= new GlobalModuleIndexBuilder(FileMgr, PCHContainerRdr);
      
      // Load each of the module files.
      std.error_code EC/*J*/= new std.error_code();
      fs.directory_iterator D = null;
      fs.directory_iterator DEnd = null;
      try {
        for (D/*J*/= new fs.directory_iterator(new Twine(Path), EC), DEnd/*J*/= new fs.directory_iterator();
             D.$noteq(DEnd) && !EC.$bool();
             D.increment(EC)) {
          // If this isn't a module file, we don't care.
          if ($noteq_StringRef(path.extension(new StringRef(D.$arrow().getPath())), /*STRINGREF_STR*/".pcm")) {
            // ... unless it's a .pcm.lock file, which indicates that someone is
            // in the process of rebuilding a module. They'll rebuild the index
            // at the end of that translation unit, so we don't have to.
            if ($eq_StringRef(path.extension(new StringRef(D.$arrow().getPath())), /*STRINGREF_STR*/".pcm.lock")) {
              return ErrorCode.EC_Building;
            }
            
            continue;
          }
          
          // If we can't find the module file, skip it.
          /*const*/ FileEntry /*P*/ ModuleFile = FileMgr.getFile(new StringRef(D.$arrow().getPath()));
          if (!(ModuleFile != null)) {
            continue;
          }
          
          // Load this module file.
          if (Builder.loadModuleFile(ModuleFile)) {
            return ErrorCode.EC_IOError;
          }
        }
      } finally {
        if (DEnd != null) { DEnd.$destroy(); }
        if (D != null) { D.$destroy(); }
      }
      
      // The output buffer, into which the global index will be written.
      SmallString OutputBuffer/*J*/= new SmallString(16);
      {
        BitstreamWriter OutputStream = null;
        try {
          OutputStream/*J*/= new BitstreamWriter(OutputBuffer);
          Builder.writeIndex(OutputStream);
        } finally {
          if (OutputStream != null) { OutputStream.$destroy(); }
        }
      }
      
      // Write the global index file to a temporary file.
      SmallString/*<128>*/ IndexTmpPath/*J*/= new SmallString/*<128>*/(128);
      int$ref TmpFD = create_int$ref();
      if (fs.createUniqueFile($add_StringRef$C_char$ptr$C(IndexPath.$StringRef(), /*KEEP_STR*/"-%%%%%%%%"), TmpFD, 
          IndexTmpPath).$bool()) {
        return ErrorCode.EC_IOError;
      }
      
      // Open the temporary global index file for output.
      Out/*J*/= new raw_fd_ostream(TmpFD.$deref(), true);
      if (Out.has_error()) {
        return ErrorCode.EC_IOError;
      }
      
      // Write the index.
      Out.write(OutputBuffer.data(), OutputBuffer.size());
      Out.close();
      if (Out.has_error()) {
        return ErrorCode.EC_IOError;
      }
      
      // Remove the old index file. It isn't relevant any more.
      fs.remove(new Twine(IndexPath));
      
      // Rename the newly-written index file to the proper name.
      if (fs.rename(new Twine(IndexTmpPath), new Twine(IndexPath)).$bool()) {
        // Rename failed; just remove the 
        fs.remove(new Twine(IndexTmpPath));
        return ErrorCode.EC_IOError;
      }
      
      // We're done.
      return ErrorCode.EC_None;
    } finally {
      if (Out != null) { Out.$destroy(); }
      if (Builder != null) { Builder.$destroy(); }
      if (Locked != null) { Locked.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "Buffer=" + Buffer // NOI18N
              + ", IdentifierIndex=" + NativeTrace.getIdentityStr(IdentifierIndex) // NOI18N
              + ", Modules=" + Modules // NOI18N
              + ", ModulesByFile=" + ModulesByFile // NOI18N
              + ", UnresolvedModules=" + UnresolvedModules // NOI18N
              + ", NumIdentifierLookups=" + NumIdentifierLookups // NOI18N
              + ", NumIdentifierLookupHits=" + NumIdentifierLookupHits; // NOI18N
  }
}
