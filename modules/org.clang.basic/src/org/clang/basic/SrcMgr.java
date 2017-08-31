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

package org.clang.basic;

import static org.clank.support.Native.$Deref;
import java.util.logging.Level;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.impl.SourceManagerStatics;
import org.clank.java.std_ptr.unique_ptr;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type SrcMgr">
@Converted(kind = Converted.Kind.MANUAL, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -namespace=clang::SrcMgr")
//</editor-fold>
public final class SrcMgr {

/// \brief Indicates whether a file or directory holds normal user code,
/// system code, or system code which is implicitly 'extern "C"' in C++ mode.
///
/// Entire directories can be tagged with this (this is maintained by
/// DirectoryLookup and friends) as can specific FileInfos when a \#pragma
/// system_header is seen or in various other cases.
///
//<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::CharacteristicKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 78,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 79,
 FQN="clang::SrcMgr::CharacteristicKind", NM="_ZN5clang6SrcMgr18CharacteristicKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr18CharacteristicKindE")
//</editor-fold>
public enum CharacteristicKind {
  C_User(0),
  C_System(1),
  C_ExternCSystem(2);
  public static final byte C_User_Raw = 0;
  public static final byte C_System_Raw = 1;
  public static final byte C_ExternCSystem_Raw = 2;
  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CharacteristicKind valueOf(int val) {
    CharacteristicKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final CharacteristicKind[] VALUES;
    private static final CharacteristicKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CharacteristicKind kind : CharacteristicKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CharacteristicKind[min < 0 ? (1-min) : 0];
      VALUES = new CharacteristicKind[max >= 0 ? (1+max) : 0];
      for (CharacteristicKind kind : CharacteristicKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/byte value;
  private CharacteristicKind(int val) { this.value = (/*uint*/byte)val;}
  public byte getValue() { return value;}
  //</editor-fold>
}

/// \brief One instance of this struct is kept for every file loaded or used.
///
/// This object owns the MemoryBuffer object.
//<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 85,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 86,
 FQN="clang::SrcMgr::ContentCache", NM="_ZN5clang6SrcMgr12ContentCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCacheE")
//</editor-fold>
public static class ContentCache implements Destructors.ClassWithDestructor {

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::CCFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 87,
   FQN="clang::SrcMgr::ContentCache::CCFlags", NM="_ZN5clang6SrcMgr12ContentCache7CCFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCache7CCFlagsE")
  //</editor-fold>
  private static final class/*enum*/ CCFlags {
    /// \brief Whether the buffer is invalid.
    public static final int InvalidFlag = 0x01;
    /// \brief Whether the buffer should not be freed on destruction.
    public static final int DoNotFreeFlag = 0x02;
  };
      
  // JAVA: Index in the context of SourceManager to prevent Object->long->Object
  // reinterpret casts
  private final int Index;
  
  /// \brief The actual buffer containing the characters from the input
  /// file.
  ///
  /// This is owned by the ContentCache object.  The bits indicate
  /// whether the buffer is invalid.
  private final/*mutable */PointerInt2Pair<MemoryBuffer/*P*/> Buffer;
/*public:*/
  /// \brief Reference to the file entry representing this ContentCache.
  ///
  /// This reference does not own the FileEntry object.
  ///
  /// It is possible for this to be NULL if the ContentCache encapsulates
  /// an imaginary text buffer.
  public final /*const*/FileEntry /*P*/ OrigEntry;
  
  /// \brief References the file which the contents were actually loaded from.
  ///
  /// Can be different from 'Entry' if we overridden the contents of one file
  /// with the contents of another file.
  public /*const*/FileEntry /*P*/ ContentsEntry;
  
  /// \brief A bump pointer allocated array of offsets for each source line.
  ///
  /// This is lazily computed.  This is owned by the SourceManager
  /// BumpPointerAllocator object.
  public int[]/*uint P*/ SourceLineCache;
  
  /// \brief The number of lines in this ContentCache.
  ///
  /// This is only valid if SourceLineCache is non-null.
  public /*uint*/int NumLines;
  
  /// \brief Indicates whether the buffer itself was provided to override
  /// the actual file contents.
  ///
  /// When true, the original entry may be a virtual file that does not
  /// exist.
  public /*JBIT unsigned int*/ boolean BufferOverridden /*: 1*/;
  
  /// \brief True if this content cache was initially created for a source
  /// file considered as a system one.
  public /*JBIT unsigned int*/ boolean IsSystemFile /*: 1*/;
  
  /// \brief True if this file may be transient, that is, if it might not
  /// exist at some later point in time when this content entry is used,
  /// after serialization and deserialization.
  public /*JBIT unsigned int*/ boolean IsTransient /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::ContentCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 142,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 143,
   FQN="clang::SrcMgr::ContentCache::ContentCache", NM="_ZN5clang6SrcMgr12ContentCacheC1EPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCacheC1EPKNS_9FileEntryE")
  //</editor-fold>
  public ContentCache(int index) {
    this(index, (/*const*/FileEntry /*P*/ )null, (/*const*/FileEntry /*P*/ )null);
  }
  public ContentCache(int index, /*const*/FileEntry /*P*/ Ent/*= 0*/) {
    this(index, Ent, Ent);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::ContentCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 145,
   FQN="clang::SrcMgr::ContentCache::ContentCache", NM="_ZN5clang6SrcMgr12ContentCacheC1EPKNS_9FileEntryES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCacheC1EPKNS_9FileEntryES4_")
  //</editor-fold>
  public ContentCache(int index, /*const*/FileEntry /*P*/ Ent, /*const*/FileEntry /*P*/ contentEnt) {
    /* : Buffer(0, false), OrigEntry(Ent), ContentsEntry(contentEnt), SourceLineCache(0), NumLines(0), BufferOverridden(false), IsSystemFile(false), IsTransient(false)*/ 
    //START JInit
    this.Buffer = new PointerInt2Pair<MemoryBuffer/*P*/>(null, /*false*/0);
    this.OrigEntry = Ent;
    this.ContentsEntry = contentEnt;
    this.SourceLineCache = null;
    this.NumLines = 0;
    this.BufferOverridden = false;
    this.IsSystemFile = false;
    this.IsTransient = false;
    //END JInit
    this.Index = index;
    trackInstance();
  }

  
  /// The copy ctor does not allow copies where source object has either
  /// a non-NULL Buffer or SourceLineCache.  Ownership of allocated memory
  /// is not transferred, so this is a logical error.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::ContentCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 155,
   FQN="clang::SrcMgr::ContentCache::ContentCache", NM="_ZN5clang6SrcMgr12ContentCacheC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCacheC1ERKS1_")
  //</editor-fold>
  public ContentCache(/*const*/SrcMgr.ContentCache/*&*/ RHS) {
    /* : NonceAligner(), Buffer(null, false), SourceLineCache(null), BufferOverridden(false), IsSystemFile(false), IsTransient(false)*/ 
    //START JInit
    this.Buffer = new PointerInt2Pair<MemoryBuffer/*P*/>(null, /*false*/0);
    this.SourceLineCache = (null);
    this.BufferOverridden = false;
    this.IsSystemFile = false;
    this.IsTransient = false;
    //END JInit
    OrigEntry = RHS.OrigEntry;
    ContentsEntry = RHS.ContentsEntry;
    assert (RHS.Buffer.getPointer() == null && RHS.SourceLineCache == null) : "Passed ContentCache object cannot own a buffer.";

    NumLines = RHS.NumLines;
    
    this.Index = RHS.Index;
  }
  
  //===----------------------------------------------------------------------===//
  // SourceManager Helper Classes
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::~ContentCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 38,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 38,
   FQN = "clang::SrcMgr::ContentCache::~ContentCache", NM = "_ZN5clang6SrcMgr12ContentCacheD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCacheD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (SourceManagerStatics.CACHE_LINES_OFFSETS) {
      // do not delete SourceLineCache memory, it's shared by others
    }
    if (shouldFreeBuffer()) {
      if (Buffer.getPointer() != null) { Buffer.getPointer().$destroy();};
    }
  }
  
  /// \brief Returns the memory buffer for the associated content.
  ///
  /// \param Diag Object through which diagnostics will be emitted if the
  ///   buffer cannot be retrieved.
  ///
  /// \param Loc If specified, is the location that invalid file diagnostics
  ///   will be emitted at.
  ///
  /// \param Invalid If non-NULL, will be set \c true if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::getBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 84,
   FQN = "clang::SrcMgr::ContentCache::getBuffer", NM = "_ZNK5clang6SrcMgr12ContentCache9getBufferERNS_17DiagnosticsEngineERKNS_13SourceManagerENS_14SourceLocationEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache9getBufferERNS_17DiagnosticsEngineERKNS_13SourceManagerENS_14SourceLocationEPb")
  //</editor-fold>
  public MemoryBuffer /*P*/ getBuffer(DiagnosticsEngine /*&*/ Diag, 
           /*const*/ SourceManager /*&*/ SM) /*const*/ {
    return getBuffer(Diag, 
           SM, 
           SourceLocation.getInvalid(), 
           (bool$ptr/*bool P*/ )null);
  }
  public MemoryBuffer /*P*/ getBuffer(DiagnosticsEngine /*&*/ Diag, 
           /*const*/ SourceManager /*&*/ SM, 
           int Loc/*= SourceLocation()*/) /*const*/ {
    return getBuffer(Diag, 
           SM, 
           Loc, 
           (bool$ptr/*bool P*/ )null);
  }
  public MemoryBuffer /*P*/ getBuffer(DiagnosticsEngine /*&*/ Diag, 
           /*const*/ SourceManager /*&*/ SM, 
           int Loc/*= SourceLocation()*/, 
           bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    // Lazily create the Buffer for ContentCaches that wrap files.  If we already
    // computed it, just return what we have.
    if ((Buffer.getPointer() != null) || !(ContentsEntry != null)) {
      if ((Invalid != null)) {
        Invalid.$set(isBufferInvalid());
      }

      return Buffer.getPointer();
    }

    boolean isVolatile = SM.userFilesAreVolatile() && !IsSystemFile;
    ErrorOr<unique_ptr<MemoryBuffer>> BufferOrError = SM.getFileManager().getBufferForFile(ContentsEntry, isVolatile);

    // If we were unable to open the file, then we are in an inconsistent
    // situation where the content cache referenced a file which no longer
    // exists. Most likely, we were using a stat cache with an invalid entry but
    // the file could also have been removed during processing. Since we can't
    // really deal with this situation, just create an empty buffer.
    //
    // FIXME: This is definitely not ideal, but our immediate clients can't
    // currently handle returning a null entry here. Ideally we should detect
    // that we are in an inconsistent situation and error out as quickly as
    // possible.
    if (!BufferOrError.$bool()) {
      StringRef FillStr/*J*/= getBuffer$FillStr;
      Buffer.setPointer(MemoryBuffer.getNewUninitMemBuffer($long2uint(ContentsEntry.getSize()), 
              Twine.T$invalid_marker).release());
      char$ptr/*char P*/ Ptr = $tryClone(((/*const_cast*/char$ptr/*char P*/ )(Buffer.getPointer().getBufferStart())));
      for (/*off_t*/long i = 0, e = ContentsEntry.getSize(); i != e; ++i)  {
        Ptr.$set($long2uint(i), FillStr.$at($long2uint(i % FillStr.size())));
      }
      if (Diag.isDiagnosticInFlight()) {
        Diag.SetDelayedDiagnostic(diag.err_cannot_open_file, 
            new StringRef(ContentsEntry.getName()), 
            new StringRef(BufferOrError.getError().message()));
      } else {
        $out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C(Diag.Report(new SourceLocation(Loc), diag.err_cannot_open_file), 
                ContentsEntry.getName()), new StringRef(BufferOrError.getError().message())).$destroy();
      }

      // JAVA: mark invalid
      setInvalidBufferFlag(Buffer);
      if ((Invalid != null)) {
        Invalid.$set(true);
      }
      return Buffer.getPointer();
    }
    
    Buffer.setPointer(BufferOrError.$arrow().release());

    // Check that the file's size is the same as in the file entry (which may
    // have come from a stat cache).
    if (getRawBuffer().getBufferSize() != ContentsEntry.getSize()) {
      // JAVA: 
      // try to repair when file size is smaller than buffer size
      // because SourceManager already allocated needed space based on file size
      // and buffer will not fit into this source locations range
      
      boolean repaired = false;
      int BufferSize = getRawBuffer().getBufferSize();
      long FileSize = ContentsEntry.getSize();
      NativeTrace.getLogger().log(Level.FINE, "Found inconsistence for {0}:\n\tBufSize={1} vs. FileEntry.Size={2} {3}", 
              new Object[]{Casts.toJavaString(ContentsEntry.Name), BufferSize, FileSize, (BufferSize > FileSize ? "- need to repair" : "")});
      if (true) {
        repaired = SM.repairVolatileContentCache(this);
      }
      if (!repaired) {
        if (false) {
          SM.repairVolatileContentCache(this);
        }
        NativeTrace.assertTrueInConsole(false, "Couldn't repair " + Casts.toJavaString(ContentsEntry.Name) + " SM.getBuffer: BufSize=" + BufferSize + " vs. FileEntry.Size=" + FileSize);
        if (Diag.isDiagnosticInFlight()) {
          Diag.SetDelayedDiagnostic(diag.err_file_modified, 
              new StringRef(ContentsEntry.getName()));
        } else {
          $out_DiagnosticBuilder$C_char$ptr$C(Diag.Report(new SourceLocation(Loc), diag.err_file_modified), 
              ContentsEntry.getName()).$destroy();
        }
        
        // JAVA: mark invalid
        setInvalidBufferFlag(Buffer);
        if ((Invalid != null)) {
          Invalid.$set(true);
        }
        return Buffer.getPointer();
      }
    }

    // If the buffer is valid, check to see if it has a UTF Byte Order Mark
    // (BOM).  We only support UTF-8 with and without a BOM right now.  See
    // http://en.wikipedia.org/wiki/Byte_order_mark for more information.
    StringRef BufStr = Buffer.getPointer().getBuffer();
    /*const*/char$ptr/*char P*/ InvalidBOM = new StringSwitchCharPtr(BufStr).
        StartsWith("\376\377", $UTF_16__BE_).
        StartsWith("\377\376", $UTF_16__LE_).
        StartsWith("\000\000\376\377", $UTF_32__BE_).
        StartsWith("\377\376\000\000", $UTF_32__LE_).
        StartsWith("+/v", $UTF_7).
        StartsWith("\367dL", $UTF_1).
        StartsWith("\335sfs", $UTF_EBCDIC).
        StartsWith("\016\376\377", $SDSU).
        StartsWith("\373\356(", $BOCU_1).
        StartsWith("\2041\2253", $GB_18030).
        Default(/*NULL*/(/*const*/char$ptr/*char P*//*const*/)null);
    if ((InvalidBOM != null)) {
      $out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C(Diag.Report(new SourceLocation(Loc), diag.err_unsupported_bom), 
              InvalidBOM), ContentsEntry.getName()).$destroy();
      // JAVA: mark invalid
      setInvalidBufferFlag(Buffer);
    }
    if ((Invalid != null)) {
      Invalid.$set(isBufferInvalid());
    }

    return Buffer.getPointer();
  }
  private static final /*const*/StringRef getBuffer$FillStr/*J*/= new StringRef("<<<MISSING SOURCE FILE>>>\n");

    public void setInvalidBufferFlag() {
      setInvalidBufferFlag(Buffer);
    }
    private void setInvalidBufferFlag(PointerInt2Pair<MemoryBuffer/*P*/> Buffer) {
      Buffer.setInt(Buffer.getInt() | CCFlags.InvalidFlag);
      assert Buffer.getPointer() != null;
      Buffer.getPointer().setInvalid();
    }

  
  /// \brief Returns the size of the content encapsulated by this
  /// ContentCache.
  ///
  /// This can be the size of the source file or the size of an
  /// arbitrary scratch buffer.  If the ContentCache encapsulates a source
  /// file this size is retrieved from the file's FileEntry.
  
  /// getSize - Returns the size of the content encapsulated by this ContentCache.
  ///  This can be the size of the source file or the size of an arbitrary
  ///  scratch buffer.  If the ContentCache encapsulates a source file, that
  ///  file is not lazily brought in from disk to satisfy this query.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::getSize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 66,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 66,
   FQN = "clang::SrcMgr::ContentCache::getSize", NM = "_ZNK5clang6SrcMgr12ContentCache7getSizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache7getSizeEv")
  //</editor-fold>
  public /*uint*/int getSize() /*const*/ {
    return (Buffer.getPointer() != null) ? Buffer.getPointer().getBufferSize() : $long2uint(ContentsEntry.getSize());
  }

  int $index() {
    return Index;
  }
  
  /// \brief Returns the number of bytes actually mapped for this
  /// ContentCache.
  ///
  /// This can be 0 if the MemBuffer was not actually expanded.
  
  /// getSizeBytesMapped - Returns the number of bytes actually mapped for this
  /// ContentCache. This can be 0 if the MemBuffer was not actually expanded.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::getSizeBytesMapped">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 45,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 45,
   FQN = "clang::SrcMgr::ContentCache::getSizeBytesMapped", NM = "_ZNK5clang6SrcMgr12ContentCache18getSizeBytesMappedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache18getSizeBytesMappedEv")
  //</editor-fold>
  public /*uint*/int getSizeBytesMapped() /*const*/ {
    return (Buffer.getPointer() != null) ? Buffer.getPointer().getBufferSize() : 0;
  }

  
  /// Returns the kind of memory used to back the memory buffer for
  /// this content cache.  This is used for performance analysis.
  
  /// Returns the kind of memory used to back the memory buffer for
  /// this content cache.  This is used for performance analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::getMemoryBufferKind">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 51,
   FQN = "clang::SrcMgr::ContentCache::getMemoryBufferKind", NM = "_ZNK5clang6SrcMgr12ContentCache19getMemoryBufferKindEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache19getMemoryBufferKindEv")
  //</editor-fold>
  public MemoryBuffer.BufferKind getMemoryBufferKind() /*const*/ {
    assert (Buffer.getPointer() != null);
    
    // Should be unreachable, but keep for sanity.
    if (!(Buffer.getPointer() != null)) {
      return MemoryBuffer.BufferKind.MemoryBuffer_Malloc;
    }
    
    /*const*/MemoryBuffer /*P*/ buf = Buffer.getPointer();
    return buf.getBufferKind();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::setBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 200,
   FQN="clang::SrcMgr::ContentCache::setBuffer", NM="_ZN5clang6SrcMgr12ContentCache9setBufferESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCache9setBufferESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS4_EE")
  //</editor-fold>
  public void setBuffer(std.unique_ptr<MemoryBuffer> B) {
    assert (!(Buffer.getPointer() != null)) : "MemoryBuffer already set.";
    Buffer.setPointer(B.release());
    Buffer.setInt(0);
  }

  
  /// \brief Get the underlying buffer, returning NULL if the buffer is not
  /// yet available.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::getRawBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 207,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 208,
   FQN="clang::SrcMgr::ContentCache::getRawBuffer", NM="_ZNK5clang6SrcMgr12ContentCache12getRawBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache12getRawBufferEv")
  //</editor-fold>
  public /*const*/MemoryBuffer /*P*/ getRawBuffer() /*const*/ {
    return Buffer.getPointer();
  }

  
  /// \brief Replace the existing buffer (which will be deleted)
  /// with the given buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::replaceBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 71,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 71,
   FQN = "clang::SrcMgr::ContentCache::replaceBuffer", NM = "_ZN5clang6SrcMgr12ContentCache13replaceBufferEPN4llvm12MemoryBufferEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr12ContentCache13replaceBufferEPN4llvm12MemoryBufferEb")
  //</editor-fold>
  public void replaceBuffer(MemoryBuffer /*P*/ B) {
    replaceBuffer(B, false);
  }
  public void replaceBuffer(MemoryBuffer /*P*/ B, boolean DoNotFree/*= false*/) {
    if ((B != null) && B == Buffer.getPointer()) {
      assert (false) : "Replacing with the same buffer";
      Buffer.setInt(DoNotFree ? CCFlags.DoNotFreeFlag : 0);
      return;
    }
    if (shouldFreeBuffer()) {
      if (Buffer.getPointer() != null) { Buffer.getPointer().$destroy();};
    }
    Buffer.setPointer(B);
    Buffer.setInt(DoNotFree ? CCFlags.DoNotFreeFlag : 0);
  }

  
  /// \brief Determine whether the buffer itself is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::isBufferInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 215,
   FQN="clang::SrcMgr::ContentCache::isBufferInvalid", NM="_ZNK5clang6SrcMgr12ContentCache15isBufferInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache15isBufferInvalidEv")
  //</editor-fold>
  public boolean isBufferInvalid() /*const*/ {
    return ((Buffer.getInt() & CCFlags.InvalidFlag) != 0);
  }

  
  /// \brief Determine whether the buffer should be freed.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ContentCache::shouldFreeBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 220,
   FQN="clang::SrcMgr::ContentCache::shouldFreeBuffer", NM="_ZNK5clang6SrcMgr12ContentCache16shouldFreeBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr12ContentCache16shouldFreeBufferEv")
  //</editor-fold>
  public boolean shouldFreeBuffer() /*const*/ {
    return (Buffer.getInt() & CCFlags.DoNotFreeFlag) == 0;
  }

  
/*private:*/

  @Override
  public String toString() {
    return "ContentCache{Index=" + Index + ";Buffer=" + Buffer + "\n, OrigEntry=" + OrigEntry + 
            (ContentsEntry == OrigEntry ? "" : "\n, ContentsEntry=" + ContentsEntry) + 
            "\n, SourceLineCache=" + SourceLineCache + 
            "\n, NumLines=" + NumLines + ", BufferOverridden=" + BufferOverridden + ", IsSystemFile=" + IsSystemFile + ", IsTransient=" + IsTransient + '}';
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", ContentCache.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(ContentCache.class.getSimpleName(), instances);
    return instances;    
  }  
  
}

// Assert that the \c ContentCache objects will always be 8-byte aligned so
// that we can pack 3 bits of integer into pointers to such objects.
static {
//  static_assert(llvm::AlignOf<ContentCache>::Alignment >= 8,
//                "ContentCache must be 8-byte aligned.");
}

/// \brief Information about a FileID, basically just the logical file
/// that it represents and include stack information.
///
/// Each FileInfo has include stack information, indicating where it came
/// from. This information encodes the \#include chain that a token was
/// expanded from. The main include file has an invalid IncludeLoc.
///
/// FileInfos contain a "ContentCache *", with the contents of the file.
///
//<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 242,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 243,
 FQN="clang::SrcMgr::FileInfo", NM="_ZN5clang6SrcMgr8FileInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfoE")
//</editor-fold>
public static final class FileInfo extends SLocEntry {
  /// \brief The location of the \#include that brought in this file.
  ///
  /// This is an invalid SLOC for the main file (top of the \#include chain).
//FIELD FROM BASE CLASS  private /*uint*/int IncludeLoc; // Really a SourceLocation
  
  /// \brief Number of FileIDs (files and macros) that were created during
  /// preprocessing of this \#include, including this SLocEntry.
  ///
  /// Zero means the preprocessor didn't provide such info for this SLocEntry.
//FIELD FROM BASE CLASS  private /*uint*/int NumCreatedFIDs;
  
  /// \brief Contains the ContentCache* and the bits indicating the
  /// characteristic of the file and whether it has \#line info, all
  /// bitmangled together.
//FIELD FROM BASE CLASS  private int/*uintptr_t*/ Data;
  static final int LineDirectivesBit = 1 << 31;
  static final int CharacteristicKindShift = 29;
  private static final int CharacteristicKindUser = 0 << CharacteristicKindShift;
  private static final int CharacteristicKindSystem = 1 << CharacteristicKindShift;
  private static final int CharacteristicKindExtSystem = 2 << CharacteristicKindShift;
  private static final int CharacteristicKindMask = 3 << CharacteristicKindShift;
  private static final int ContentCacheMask = ~(7 << CharacteristicKindShift);
  
  /*friend  class clang::SourceManager*/;
  /*friend  class clang::ASTWriter*/;
  /*friend  class clang::ASTReader*/;
/*public:*/
  /// \brief Return a FileInfo object.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::get">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 265,
   FQN="clang::SrcMgr::FileInfo::get", NM="_ZN5clang6SrcMgr8FileInfo3getENS_14SourceLocationEPKNS0_12ContentCacheENS0_18CharacteristicKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfo3getENS_14SourceLocationEPKNS0_12ContentCacheENS0_18CharacteristicKindE")
  //</editor-fold>
  public static FileInfo get(/*SourceLocation*/int IL, /*const*/SrcMgr.ContentCache/*P*/ Con, CharacteristicKind FileCharacter) {
    int Data = Con.$index();
    Data |= FileCharacter.getValue() << CharacteristicKindShift;
    assert ((/*uint*/int)FileCharacter.getValue() < 4) : "invalid file character";
    FileInfo X/*J*/= new FileInfo(0, IL, 0, Data);
    assert FileCharacter == X.getFileCharacteristic();
    assert (X.getContentCacheIndex() == Con.$index()) : "ContentCache pointer insufficiently aligned: " + X.getContentCacheIndex() + " vs " + Con.$index();
    return X;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::getIncludeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 276,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 277,
   FQN="clang::SrcMgr::FileInfo::getIncludeLoc", NM="_ZNK5clang6SrcMgr8FileInfo13getIncludeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr8FileInfo13getIncludeLocEv")
  //</editor-fold>
  public SourceLocation getIncludeLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(super.Union_IncludeLoc_or_SpellingLoc);
  }
  public /*SourceLocation*/int $getIncludeLoc() /*const*/ {
    return super.Union_IncludeLoc_or_SpellingLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::getContentCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 279,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 280,
   FQN="clang::SrcMgr::FileInfo::getContentCache", NM="_ZNK5clang6SrcMgr8FileInfo15getContentCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr8FileInfo15getContentCacheEv")
  //</editor-fold>
  public /*const*/SrcMgr.ContentCache/*P*/ getContentCache() /*const*/ {
    throw new UnsupportedOperationException("Use SourceManager.getContentCache instead");
  }
  
  public /*uint*/int getContentCacheIndex() {
    return getContentCacheIndex(super.Union_Data_or_ExpansionLocEnd);
  }
  
  public static int getContentCacheIndex(int Data) {
    trackGetContentCache();
    return Data & ContentCacheMask;
  }
  
  
  /// \brief Return whether this is a system header or not.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::getFileCharacteristic">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 284,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 285,
   FQN="clang::SrcMgr::FileInfo::getFileCharacteristic", NM="_ZNK5clang6SrcMgr8FileInfo21getFileCharacteristicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr8FileInfo21getFileCharacteristicEv")
  //</editor-fold>
  public CharacteristicKind getFileCharacteristic() /*const*/ {
    return getFileCharacteristic(super.Union_Data_or_ExpansionLocEnd);
  }

  public static CharacteristicKind getFileCharacteristic(int Data) /*const*/ {
    trackGetFileCharacteristic();
    int val = Data & CharacteristicKindMask;
    if(val == CharacteristicKindUser) {
        return CharacteristicKind.C_User;
    } else if (val == CharacteristicKindSystem) {
        return CharacteristicKind.C_System;
    } else {
        assert val == CharacteristicKindExtSystem;
        return CharacteristicKind.C_ExternCSystem;
    }
  }

  public /*uint*/int getNumCreatedFIDs() {
    return super.Union_NumCreatedFIDs_or_ExpansionLocStart;
  }

  /// \brief Return true if this FileID has \#line directives in it.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::hasLineDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 290,
   FQN="clang::SrcMgr::FileInfo::hasLineDirectives", NM="_ZNK5clang6SrcMgr8FileInfo17hasLineDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr8FileInfo17hasLineDirectivesEv")
  //</editor-fold>
  public boolean hasLineDirectives() /*const*/ {
    return (super.Union_Data_or_ExpansionLocEnd & LineDirectivesBit) != 0;
  }

  
  /// \brief Set the flag that indicates that this FileID has
  /// line table entries associated with it.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::setHasLineDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 294,
   FQN="clang::SrcMgr::FileInfo::setHasLineDirectives", NM="_ZN5clang6SrcMgr8FileInfo20setHasLineDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfo20setHasLineDirectivesEv")
  //</editor-fold>
  public static int setHasLineDirectives(int Data) {
    return Data | LineDirectivesBit;
  }
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::FileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 243,
   FQN="clang::SrcMgr::FileInfo::FileInfo", NM="_ZN5clang6SrcMgr8FileInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfoC1Ev")
  //</editor-fold>
  public /*inline*/ FileInfo() {
    throw new UnsupportedOperationException("Java Deleted");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::FileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 243,
   FQN="clang::SrcMgr::FileInfo::FileInfo", NM="_ZN5clang6SrcMgr8FileInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ FileInfo(JD$Move _dparam, FileInfo /*&&*/$Prm0) {
    /* : IncludeLoc(static_cast<FileInfo &&>().IncludeLoc), NumCreatedFIDs(static_cast<FileInfo &&>().NumCreatedFIDs), Data(static_cast<FileInfo &&>().Data)*/ 
    throw new UnsupportedOperationException("Java Deleted");
  }

  private FileInfo(/*uint*/int RawOffset, /*uint*/int IncludeLoc, /*uint*/int NumCreatedFIDs, /*uint*/int Data) {
    super(RawOffset, IncludeLoc, NumCreatedFIDs, Data);
    trackInstance();
  }

  @Override
  public FileInfo clone() {
    throw new UnsupportedOperationException("We don't have real instances of this, they are decomposed in collection");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 243,
   FQN="clang::SrcMgr::FileInfo::operator=", NM="_ZN5clang6SrcMgr8FileInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfoaSERKS1_")
  //</editor-fold>
  public /*inline*/ FileInfo /*&*/ $assign(/*const*/ FileInfo /*&*/ $Prm0) {
    throw new UnsupportedOperationException("We don't have real instances of this, they are decomposed in collection");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::FileInfo::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 243,
   FQN="clang::SrcMgr::FileInfo::operator=", NM="_ZN5clang6SrcMgr8FileInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr8FileInfoaSEOS1_")
  //</editor-fold>
  public /*inline*/ FileInfo /*&*/ $assignMove(FileInfo /*&&*/$Prm0) {
    throw new UnsupportedOperationException("We don't have real instances of this, they are decomposed in collection");
  }
  
  @Override
  public String toString() {
    return "FileInfo{" + "IncludeLoc=" + getIncludeLoc() + ", FileCharacteristic=" + getFileCharacteristic() + ", hasLineDirectives=" + hasLineDirectives() + ", NumCreatedFIDs=" + getNumCreatedFIDs() + ", Data=" + getContentCacheIndex() + '}';
  }

  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static long callGetContentCache = 0;
  private static long callGetFileCharacteristic = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }

  private static void trackGetContentCache() {
    if (NativeTrace.STATISTICS) callGetContentCache++;
  }

  private static void trackGetFileCharacteristic() {
    if (NativeTrace.STATISTICS) callGetFileCharacteristic++;
  }

  public static void clearStatistics() {
    instances = 0;
    callGetContentCache = 0;
    callGetFileCharacteristic = 0;
  }

  public static long PrintStats(raw_ostream out) {
    if (!NativeTrace.STATISTICS) return instances;
    out.$out(String.format("%22s created:\t", FileInfo.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    out.$out(String.format("%22s  called:\t", "GetContentCache")).$out(NativeTrace.formatNumber(callGetContentCache)).$out(".\n");
    out.$out(String.format("%22s  called:\t", "GetFileCharacteristic")).$out(NativeTrace.formatNumber(callGetFileCharacteristic)).$out(".\n");
    NativeTrace.dumpStatisticValue(FileInfo.class.getSimpleName(), instances);
    return instances;
  }

}

/// \brief Each ExpansionInfo encodes the expansion location - where
/// the token was ultimately expanded, and the SpellingLoc - where the actual
/// character data for the token came from.
//<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 301,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 302,
 FQN="clang::SrcMgr::ExpansionInfo", NM="_ZN5clang6SrcMgr13ExpansionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfoE")
//</editor-fold>
public static final class ExpansionInfo extends SLocEntry {
  
  /// \brief Where the spelling for the token can be found.
//FIELD FROM BASE CLASS  private /*uint*/int SpellingLoc;
  
  /// In a macro expansion, ExpansionLocStart and ExpansionLocEnd
  /// indicate the start and end of the expansion. In object-like macros,
  /// they will be the same. In a function-like macro expansion, the start
  /// will be the identifier and the end will be the ')'. Finally, in
  /// macro-argument instantiations, the end will be 'SourceLocation()', an
  /// invalid location.
//FIELD FROM BASE CLASS  private /*uint*/int ExpansionLocStart;
//FIELD FROM BASE CLASS  private /*uint*/int ExpansionLocEnd;

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::ExpansionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 302,
   FQN="clang::SrcMgr::ExpansionInfo::ExpansionInfo", NM="_ZN5clang6SrcMgr13ExpansionInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfoC1Ev")
  //</editor-fold>
  private /*inline*/ ExpansionInfo() {
    throw new UnsupportedOperationException("Java Deleted");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::ExpansionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 302,
   FQN="clang::SrcMgr::ExpansionInfo::ExpansionInfo", NM="_ZN5clang6SrcMgr13ExpansionInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ ExpansionInfo(JD$Move _dparam, SrcMgr.ExpansionInfo/*&&*/ $Prm0) {
    /* : SpellingLoc(static_cast<ExpansionInfo &&>().SpellingLoc), ExpansionLocStart(static_cast<ExpansionInfo &&>().ExpansionLocStart), ExpansionLocEnd(static_cast<ExpansionInfo &&>().ExpansionLocEnd)*/ 
    throw new UnsupportedOperationException("Java Deleted");
  }

  private ExpansionInfo(/*uint*/int RawOffset, /*uint*/int SpellingLoc, /*uint*/int ExpansionLocStart, /*uint*/int ExpansionLocEnd) {
    super(RawOffset, SpellingLoc, ExpansionLocStart, ExpansionLocEnd);
    trackInstance();
  }
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::getSpellingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 316,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 317,
   FQN="clang::SrcMgr::ExpansionInfo::getSpellingLoc", NM="_ZNK5clang6SrcMgr13ExpansionInfo14getSpellingLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo14getSpellingLocEv")
  //</editor-fold>
  public SourceLocation getSpellingLoc() /*const*/ {
    return SourceLocation.getFromRawEncoding(super.Union_IncludeLoc_or_SpellingLoc);
  }
  public /*SourceLocation*/int $getSpellingLoc() /*const*/ {
    return super.Union_IncludeLoc_or_SpellingLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::getExpansionLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 320,
   FQN="clang::SrcMgr::ExpansionInfo::getExpansionLocStart", NM="_ZNK5clang6SrcMgr13ExpansionInfo20getExpansionLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo20getExpansionLocStartEv")
  //</editor-fold>
  public SourceLocation getExpansionLocStart() /*const*/ {
    return SourceLocation.getFromRawEncoding(super.Union_NumCreatedFIDs_or_ExpansionLocStart);
  }
  public /*SourceLocation*/int $getExpansionLocStart() /*const*/ {
    return super.Union_NumCreatedFIDs_or_ExpansionLocStart;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::getExpansionLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 322,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 323,
   FQN="clang::SrcMgr::ExpansionInfo::getExpansionLocEnd", NM="_ZNK5clang6SrcMgr13ExpansionInfo18getExpansionLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo18getExpansionLocEndEv")
  //</editor-fold>
  public SourceLocation getExpansionLocEnd() /*const*/ {
    SourceLocation EndLoc = SourceLocation.getFromRawEncoding(super.Union_Data_or_ExpansionLocEnd);
    return EndLoc.isInvalid() ? getExpansionLocStart() : EndLoc;
  }
  public /*SourceLocation*/int $getExpansionLocEnd() /*const*/ {
    return SourceLocation.isInvalid(super.Union_Data_or_ExpansionLocEnd) ? $getExpansionLocStart() : super.Union_Data_or_ExpansionLocEnd;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::getExpansionLocRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 329,
   FQN="clang::SrcMgr::ExpansionInfo::getExpansionLocRange", NM="_ZNK5clang6SrcMgr13ExpansionInfo20getExpansionLocRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo20getExpansionLocRangeEv")
  //</editor-fold>
  public std.pair<SourceLocation, SourceLocation> getExpansionLocRange() /*const*/ {
    return std.make_pair(getExpansionLocStart(), getExpansionLocEnd());
  }
  public /*<SourceLocation, SourceLocation>*/long $getExpansionLocRange() /*const*/ {
    return wrap_SourceLocation_SourceLocation($getExpansionLocStart(), $getExpansionLocEnd());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::isMacroArgExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 333,
   FQN="clang::SrcMgr::ExpansionInfo::isMacroArgExpansion", NM="_ZNK5clang6SrcMgr13ExpansionInfo19isMacroArgExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo19isMacroArgExpansionEv")
  //</editor-fold>
  public boolean isMacroArgExpansion() /*const*/ {
    // Note that this needs to return false for default constructed objects.
    return SourceLocation.isValid($getExpansionLocStart()) && SourceLocation.isInvalid(super.Union_Data_or_ExpansionLocEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::isMacroBodyExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 339,
   FQN="clang::SrcMgr::ExpansionInfo::isMacroBodyExpansion", NM="_ZNK5clang6SrcMgr13ExpansionInfo20isMacroBodyExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo20isMacroBodyExpansionEv")
  //</editor-fold>
  public boolean isMacroBodyExpansion() /*const*/ {
    return SourceLocation.isValid($getExpansionLocStart()) && SourceLocation.isValid(super.Union_Data_or_ExpansionLocEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::isFunctionMacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 344,
   FQN="clang::SrcMgr::ExpansionInfo::isFunctionMacroExpansion", NM="_ZNK5clang6SrcMgr13ExpansionInfo24isFunctionMacroExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr13ExpansionInfo24isFunctionMacroExpansionEv")
  //</editor-fold>
  public boolean isFunctionMacroExpansion() /*const*/ {
    return SourceLocation.isValid($getExpansionLocStart()) && ($getExpansionLocStart() != $getExpansionLocEnd());
  }

  
  /// \brief Return a ExpansionInfo for an expansion.
  ///
  /// Start and End specify the expansion range (where the macro is
  /// expanded), and SpellingLoc specifies the spelling location (where
  /// the characters from the token come from). All three can refer to
  /// normal File SLocs or expansion locations.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 354,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 355,
   FQN="clang::SrcMgr::ExpansionInfo::create", NM="_ZN5clang6SrcMgr13ExpansionInfo6createENS_14SourceLocationES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfo6createENS_14SourceLocationES2_S2_")
  //</editor-fold>
  public static SrcMgr.ExpansionInfo create(SourceLocation SpellingLoc, SourceLocation Start, SourceLocation End) {
    return create(SpellingLoc.getRawEncoding(), Start.getRawEncoding(), End.getRawEncoding());
  }
  static SrcMgr.ExpansionInfo create(/*SourceLocation*/int Raw_SpellingLoc, /*SourceLocation*/int Raw_Start, /*SourceLocation*/int Raw_End) {
    SrcMgr.ExpansionInfo X/*J*/= new SrcMgr.ExpansionInfo(0, Raw_SpellingLoc, Raw_Start, Raw_End);
    return X;
  }

  
  /// \brief Return a special ExpansionInfo for the expansion of
  /// a macro argument into a function-like macro's body.
  ///
  /// ExpansionLoc specifies the expansion location (where the macro is
  /// expanded). This doesn't need to be a range because a macro is always
  /// expanded at a macro parameter reference, and macro parameters are
  /// always exactly one token. SpellingLoc specifies the spelling location
  /// (where the characters from the token come from). ExpansionLoc and
  /// SpellingLoc can both refer to normal File SLocs or expansion locations.
  ///
  /// Given the code:
  /// \code
  ///   #define F(x) f(x)
  ///   F(42);
  /// \endcode
  ///
  /// When expanding '\c F(42)', the '\c x' would call this with an
  /// SpellingLoc pointing at '\c 42' and an ExpansionLoc pointing at its
  /// location in the definition of '\c F'.
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::createForMacroArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 382,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 383,
   FQN="clang::SrcMgr::ExpansionInfo::createForMacroArg", NM="_ZN5clang6SrcMgr13ExpansionInfo17createForMacroArgENS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfo17createForMacroArgENS_14SourceLocationES2_")
  //</editor-fold>
  public static SrcMgr.ExpansionInfo createForMacroArg(/*SourceLocation*/int SpellingLoc, /*SourceLocation*/int ExpansionLoc) {
    // We store an intentionally invalid source location for the end of the
    // expansion range to mark that this is a macro argument ion rather than
    // a normal one.
    return create(SpellingLoc, ExpansionLoc, SourceLocation.getInvalid());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 302,
   FQN="clang::SrcMgr::ExpansionInfo::operator=", NM="_ZN5clang6SrcMgr13ExpansionInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfoaSERKS1_")
  //</editor-fold>
  public /*inline*/ SrcMgr.ExpansionInfo/*&*/ $assign(/*const*/SrcMgr.ExpansionInfo/*&*/ $Prm0) {
    throw new UnsupportedOperationException("We don't have real instances of this, they are decomposed in collection");
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::ExpansionInfo::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 302,
   FQN="clang::SrcMgr::ExpansionInfo::operator=", NM="_ZN5clang6SrcMgr13ExpansionInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr13ExpansionInfoaSEOS1_")
  //</editor-fold>  
  public /*inline*/ SrcMgr.ExpansionInfo/*&*/ $assignMove(/*const*/SrcMgr.ExpansionInfo/*&&*/ $Prm0) {
    throw new UnsupportedOperationException("We don't have real instances of this, they are decomposed in collection");
  }

  @Override
  public String toString() {
    return "EInfo{" + "SLoc=" + getSpellingLoc() + ", "
            + "Exp=[" + SourceLocation.getFromRawEncoding(super.Union_NumCreatedFIDs_or_ExpansionLocStart) + 
            "-" + SourceLocation.getFromRawEncoding(super.Union_Data_or_ExpansionLocEnd) + ")}";
  }

  @Override
  public ExpansionInfo clone() {
    throw new UnsupportedOperationException("We don't have real instances of this, they are decomposed in collection");
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", ExpansionInfo.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(ExpansionInfo.class.getSimpleName(), instances);
    return instances;
  }    
}

/// \brief This is a discriminated union of FileInfo and ExpansionInfo.
///
/// SourceManager keeps an array of these objects, and they are uniquely
/// identified by the FileID datatype.
//<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 395,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 396,
 FQN="clang::SrcMgr::SLocEntry", NM="_ZN5clang6SrcMgr9SLocEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntryE")
//</editor-fold>
//<editor-fold defaultstate="" desc="clang::SrcMgr::SLocEntry with uint fields">
public /*abstract*/ static class SLocEntry implements Native.NativePOD<SLocEntry>, NativeType.SizeofCapable {

  static void copyTo(int[] arrayUIntFields, int i, SLocEntry value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
//  private /*uint*/int Offset /*: 31*/;
//  private /*JBIT unsigned int*/ boolean IsExpansion /*: 1*/;
  protected /*uint*/int Offset; // JAVA: high bit is set for expansion info.
  static final int ExpansionBit = 1 << 31;
  private static final int ExpansionBitMask = ~ExpansionBit;

  static int toOffset(/*uint*/int rawOffset) {
    return rawOffset & ExpansionBitMask;
  }
  
  static boolean isExpansion(/*uint*/int rawOffset) {
    return (rawOffset & ExpansionBit) != 0;
  }
    
  static boolean isNotExpansion(/*uint*/int rawOffset) {
    return (rawOffset & ExpansionBit) == 0;
  }
    
  @Override
  public final int $sizeof() {
    return $sizeof_SLocEntry();
  }
  
  static int $sizeof_SLocEntry() {    
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER + 
           NativeType.BYTES_IN_INT + 
           NativeType.BYTES_IN_INT +
           NativeType.BYTES_IN_INT +
           NativeType.BYTES_IN_INT;
  }

  // JAVA: decompose union as 3 uint
  protected /*uint*/int Union_IncludeLoc_or_SpellingLoc;
  protected /*uint*/int Union_NumCreatedFIDs_or_ExpansionLocStart;
  protected /*uint*/int Union_Data_or_ExpansionLocEnd;

  final void setFile_NumCreatedFIDs(/*uint*/int NumFIDs) {
    if (true) throw new IllegalStateException("Entry is not updated this way, use SourceManager methods instead");
    assert (isFile()) : "Not a file SLocEntry!";
    this.Union_NumCreatedFIDs_or_ExpansionLocStart = NumFIDs;
  }

  final void setFile_HasLineDirectives() {
    if (true) throw new IllegalStateException("Entry is not updated this way, use SourceManager methods instead");
    assert (isFile()) : "Not a file SLocEntry!";
    this.Union_Data_or_ExpansionLocEnd = FileInfo.setHasLineDirectives(this.Union_Data_or_ExpansionLocEnd);
  }
      
  final /*const*//*SrcMgr.ContentCache P*/int getFile_ContentCacheIndex() {
    assert (isFile()) : "Not a file SLocEntry!";
    return FileInfo.getContentCacheIndex(this.Union_Data_or_ExpansionLocEnd);
  }
  
  final /*uint*/int getRawOffset() {
    return Offset;
  }
  
  SLocEntry(/*uint*/int rawOffset) {
    this.Offset = rawOffset;
    trackInstance();
  }
  
  SLocEntry(/*uint*/int RawOffset, /*uint*/int Union_IncludeLoc_or_SpellingLoc, /*uint*/int Union_NumCreatedFIDs_or_ExpansionLocStart, /*uint*/int Union_Data_or_ExpansionLocEnd) {
    this.Offset = RawOffset;
    this.Union_IncludeLoc_or_SpellingLoc = Union_IncludeLoc_or_SpellingLoc;
    this.Union_NumCreatedFIDs_or_ExpansionLocStart = Union_NumCreatedFIDs_or_ExpansionLocStart;
    this.Union_Data_or_ExpansionLocEnd = Union_Data_or_ExpansionLocEnd;
    trackInstance();
  }
  
  SLocEntry(int array[], int index) {
    trackInstance();
    throw new UnsupportedOperationException();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::getOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 403,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 404,
   FQN="clang::SrcMgr::SLocEntry::getOffset", NM="_ZNK5clang6SrcMgr9SLocEntry9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr9SLocEntry9getOffsetEv")
  //</editor-fold>
  public final /*uint*/int getOffset() /*const*/ {
    return toOffset(Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::isExpansion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 406,
   FQN="clang::SrcMgr::SLocEntry::isExpansion", NM="_ZNK5clang6SrcMgr9SLocEntry11isExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr9SLocEntry11isExpansionEv")
  //</editor-fold>
  public final boolean isExpansion() /*const*/ {
    return isExpansion(Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::isFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 406,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 407,
   FQN="clang::SrcMgr::SLocEntry::isFile", NM="_ZNK5clang6SrcMgr9SLocEntry6isFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr9SLocEntry6isFileEv")
  //</editor-fold>
  public final boolean isFile() /*const*/ {
    return !isExpansion();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::getFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 408,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 409,
   FQN="clang::SrcMgr::SLocEntry::getFile", NM="_ZNK5clang6SrcMgr9SLocEntry7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr9SLocEntry7getFileEv")
  //</editor-fold>
  public final /*const*/FileInfo /*&*/ getFile() /*const*/ {
    assert (isFile()) : "Not a file SLocEntry!";
    return (FileInfo)this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::getExpansion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 413,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 414,
   FQN="clang::SrcMgr::SLocEntry::getExpansion", NM="_ZNK5clang6SrcMgr9SLocEntry12getExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang6SrcMgr9SLocEntry12getExpansionEv")
  //</editor-fold>
  public final /*const*/SrcMgr.ExpansionInfo/*&*/ getExpansion() /*const*/ {
    assert (isExpansion()) : "Not a macro expansion SLocEntry!";
    return (SrcMgr.ExpansionInfo)this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 418,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 419,
   FQN="clang::SrcMgr::SLocEntry::get", NM="_ZN5clang6SrcMgr9SLocEntry3getEjRKNS0_8FileInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntry3getEjRKNS0_8FileInfoE")
  //</editor-fold>
  public static SLocEntry get(/*uint*/int Offset, /*const*/FileInfo /*&*/ FI) {
    assert (!((Offset & (1 << 31)) != 0)) : "Offset is too large";
    FI.Offset = Offset;
    assert FI.isFile();
    return FI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 427,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 428,
   FQN="clang::SrcMgr::SLocEntry::get", NM="_ZN5clang6SrcMgr9SLocEntry3getEjRKNS0_13ExpansionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntry3getEjRKNS0_13ExpansionInfoE")
  //</editor-fold>
  public static SLocEntry get(/*uint*/int Offset, /*const*/SrcMgr.ExpansionInfo/*&*/ Expansion) {
    assert (!((Offset & (1 << 31)) != 0)) : "Offset is too large";
    Expansion.Offset = Offset | ExpansionBit;
    assert Expansion.isExpansion();
    return Expansion;
  }

  public static SLocEntry get(/*uint*/int RawOffset, int Union_IncludeLoc_or_SpellingLoc, 
          int Union_NumCreatedFIDs_or_ExpansionLocStart, int Union_Data_or_ExpansionLocEnd) {
    SLocEntry out;
    if (isExpansion(RawOffset)) {
      out = new ExpansionInfo(RawOffset, Union_IncludeLoc_or_SpellingLoc, Union_NumCreatedFIDs_or_ExpansionLocStart, Union_Data_or_ExpansionLocEnd);
    } else {
      out = new FileInfo(RawOffset, Union_IncludeLoc_or_SpellingLoc, Union_NumCreatedFIDs_or_ExpansionLocStart, Union_Data_or_ExpansionLocEnd);
    }
    return out;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::SLocEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 396,
   FQN="clang::SrcMgr::SLocEntry::SLocEntry", NM="_ZN5clang6SrcMgr9SLocEntryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntryC1Ev")
  //</editor-fold>
  private /*inline*/ SLocEntry() {
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::SLocEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 396,
   FQN="clang::SrcMgr::SLocEntry::SLocEntry", NM="_ZN5clang6SrcMgr9SLocEntryC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntryC1ERKS1_")
  //</editor-fold>
  public /*inline*/ SLocEntry(/*const*/SLocEntry /*&*/ $Prm0)/* throw()*/ {
    if (true) throw new UnsupportedOperationException("no-copy or get must be used");
    /* : Offset(.Offset), Unnamed_field1(.)*/ 
    //START JInit
    this.Offset = $Prm0.Offset;
    this.Union_IncludeLoc_or_SpellingLoc = $Prm0.Union_IncludeLoc_or_SpellingLoc;
    this.Union_NumCreatedFIDs_or_ExpansionLocStart = $Prm0.Union_NumCreatedFIDs_or_ExpansionLocStart;
    this.Union_Data_or_ExpansionLocEnd = $Prm0.Union_Data_or_ExpansionLocEnd;
    //END JInit
    assert this.$eq($Prm0);
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::SLocEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 396,
   FQN="clang::SrcMgr::SLocEntry::SLocEntry", NM="_ZN5clang6SrcMgr9SLocEntryC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntryC1EOS1_")
  //</editor-fold>
  public /*inline*/ SLocEntry(JD$Move _dparam, SLocEntry /*&&*/$Prm0) {
    if (true) throw new UnsupportedOperationException("no-move or get must be used");
    /* : Offset(static_cast<SLocEntry &&>().Offset), IsExpansion(static_cast<SLocEntry &&>().IsExpansion), Unnamed_field2(static_cast<SLocEntry &&>().)*/ 
    //START JInit
    this.Offset = $Prm0.Offset;
    this.Union_IncludeLoc_or_SpellingLoc = $Prm0.Union_IncludeLoc_or_SpellingLoc;
    this.Union_NumCreatedFIDs_or_ExpansionLocStart = $Prm0.Union_NumCreatedFIDs_or_ExpansionLocStart;
    this.Union_Data_or_ExpansionLocEnd = $Prm0.Union_Data_or_ExpansionLocEnd;
    //END JInit
    assert this.$eq($Prm0);
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 396,
   FQN="clang::SrcMgr::SLocEntry::operator=", NM="_ZN5clang6SrcMgr9SLocEntryaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntryaSERKS1_")
  //</editor-fold>
  public final /*inline*/ SLocEntry /*&*/ $assign(/*const*/SLocEntry /*&*/ $Prm0)/* throw()*/ {
    if (true) throw new IllegalStateException("Entry is not updated this way, use SourceManager methods instead");
    this.Offset = $Prm0.Offset;
    this.Union_IncludeLoc_or_SpellingLoc = $Prm0.Union_IncludeLoc_or_SpellingLoc;
    this.Union_NumCreatedFIDs_or_ExpansionLocStart = $Prm0.Union_NumCreatedFIDs_or_ExpansionLocStart;
    this.Union_Data_or_ExpansionLocEnd = $Prm0.Union_Data_or_ExpansionLocEnd;
    assert this.$eq($Prm0);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SrcMgr::SLocEntry::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 396,
   FQN="clang::SrcMgr::SLocEntry::operator=", NM="_ZN5clang6SrcMgr9SLocEntryaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang6SrcMgr9SLocEntryaSEOS1_")
  //</editor-fold>
  public final /*inline*/ SLocEntry /*&*/ $assignMove(/*const*/SLocEntry /*&*/ $Prm0)/* throw()*/ {
    return $Deref($assign($Prm0));
  }

  @Override
  public String toString() {
    return "SLocEntry{" + (isExpansion() ? "M:" : "F:") + getOffset() + "[" + (isExpansion() ? getExpansion() : getFile()) + "]}";
  }
  
  @Override
  public SLocEntry clone() {
    throw new UnsupportedOperationException("Why is it used?");
  }

  @Override
  public final boolean $noteq(SLocEntry other) {
    return !$eq(other);
  }

  @Override
  public final boolean $eq(SLocEntry other) {
    return this.Offset == other.Offset && 
            this.Union_IncludeLoc_or_SpellingLoc == other.Union_IncludeLoc_or_SpellingLoc &&
            this.Union_NumCreatedFIDs_or_ExpansionLocStart == other.Union_NumCreatedFIDs_or_ExpansionLocStart && 
            this.Union_Data_or_ExpansionLocEnd == other.Union_Data_or_ExpansionLocEnd;
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", SLocEntry.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(SLocEntry.class.getSimpleName(), instances);
    return instances;    
  }    
}
//</editor-fold>

} // END OF class SrcMgr
