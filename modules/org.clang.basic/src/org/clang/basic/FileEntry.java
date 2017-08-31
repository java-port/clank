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

import org.clang.basic.llvm.DenseMapInfoFileEntry$Ptr;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.fs;

/// \brief Cached information about one file (either on disk
/// or in the virtual file system).
///
/// If the 'File' member is valid, then this FileEntry has an open file
/// descriptor for the file.
//<editor-fold defaultstate="collapsed" desc="clang::FileEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 53,
 FQN="clang::FileEntry", NM="_ZN5clang9FileEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang9FileEntryE")
//</editor-fold>
public class FileEntry implements Destructors.ClassWithDestructor, Native.NativePOD<FileEntry>, Native.ComparableLower {  
  public static final DenseMapInfo<FileEntry> DMI$FileEntryPtr;
  /*JAVA*/
  static {
    FileEntry emptyKey = new FileEntry();
    assert emptyKey.UID == FileManager.INVALID_UID : "UID must be assigned only once " + emptyKey;
    emptyKey.UID = -1;
    FileEntry tombstoneKey = new FileEntry();
    assert tombstoneKey.UID == FileManager.INVALID_UID : "UID must be assigned only once " + tombstoneKey;
    tombstoneKey.UID = -2;
    if (NativeTrace.OPTIMIZE_DENSE_MAP_INFO) {
      DMI$FileEntryPtr = new DenseMapInfoFileEntry$Ptr(emptyKey, tombstoneKey);
    } else {
      DMI$FileEntryPtr = new DenseMapInfo$LikePtr<FileEntry>(emptyKey, tombstoneKey);
    }
  }
  /*friend*/ /*const*/char$ptr/*char P*/ Name; // Name of the file.
  /*friend*/ /*const*/int NameLen; // Name Lenght.
  /*friend*/ std.string RealPathName; // Real path to the file; could be empty.
  /*friend*/ long/*off_t*/ Size; // File size in bytes.
  /*friend*/ long/*time_t*/ ModTime; // Modification time of file.
  /*friend*/ /*const*/ DirectoryEntry /*P*/ Dir; // Directory file lives in.
  /*friend*/ public /*uint*/int UID = /*JAVA*/FileManager.INVALID_UID; // A unique (small positive) ID for the file. -1 for emptyKey, -2 for tombstoneKey
  /*friend*/ fs.UniqueID UniqueID;
  /*friend*/ boolean IsNamedPipe;
  /*friend*/ boolean InPCH;
  /*friend*/ boolean IsValid; // Is this \c FileEntry initialized and valid?
  
  /// \brief The open file, if it is owned by the \p FileEntry.
  /*friend*/ /*mutable */std.unique_ptr<File> File;
  /*friend  class FileManager*/
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public FileEntry(fs.UniqueID UniqueID) {
    this.UniqueID = UniqueID;
    this.IsNamedPipe = false;
    this.InPCH = false;
    this.IsValid = false;
    this.File = new std.unique_ptr<File>();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 68,
   FQN="clang::FileEntry::operator=", NM="_ZN5clang9FileEntryaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang9FileEntryaSERKS0_")
  //</editor-fold>
  public FileEntry $assign(/*const*/ FileEntry /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::FileEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 72,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 71,
   FQN="clang::FileEntry::FileEntry", NM="_ZN5clang9FileEntryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang9FileEntryC1Ev")
  //</editor-fold>
  public FileEntry() {
    /* : RealPathName(), UniqueID(0, 0), IsNamedPipe(false), InPCH(false), IsValid(false), File()*/ 
    //START JInit
    this.RealPathName = new std.string();
    this.UniqueID = new fs.UniqueID(0, 0);
    this.IsNamedPipe = false;
    this.InPCH = false;
    this.IsValid = false;
    this.File = new std.unique_ptr<File>();
    //END JInit
  }

  
  // FIXME: this is here to allow putting FileEntry in std::map.  Once we have
  // emplace, we shouldn't need a copy constructor anymore.
  /// Intentionally does not copy fields that are not set in an uninitialized
  /// \c FileEntry.
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::FileEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 79,
   FQN="clang::FileEntry::FileEntry", NM="_ZN5clang9FileEntryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang9FileEntryC1ERKS0_")
  //</editor-fold>
  public FileEntry(/*const*/ FileEntry /*&*/ FE) {
    /* : RealPathName(), UniqueID(FE.UniqueID), IsNamedPipe(FE.IsNamedPipe), InPCH(FE.InPCH), IsValid(FE.IsValid), File()*/ 
    //START JInit
    this.RealPathName = new std.string();
    this.UniqueID = new fs.UniqueID(FE.UniqueID);
    this.IsNamedPipe = FE.IsNamedPipe;
    this.InPCH = FE.InPCH;
    this.IsValid = FE.IsValid;
    this.File = new std.unique_ptr<File>();
    //END JInit
    assert (!isValid()) : "Cannot copy an initialized FileEntry";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 85,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 84,
   FQN="clang::FileEntry::getName", NM="_ZNK5clang9FileEntry7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return Name;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::tryGetRealPathName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 86,
   FQN="clang::FileEntry::tryGetRealPathName", NM="_ZNK5clang9FileEntry18tryGetRealPathNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry18tryGetRealPathNameEv")
  //</editor-fold>
  public StringRef tryGetRealPathName() /*const*/ {
    return new StringRef(RealPathName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 85,
   FQN="clang::FileEntry::isValid", NM="_ZNK5clang9FileEntry7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return IsValid;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 86,
   FQN="clang::FileEntry::getSize", NM="_ZNK5clang9FileEntry7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry7getSizeEv")
  //</editor-fold>
  public long/*off_t*/ getSize() /*const*/ {
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::getUID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 87,
   FQN="clang::FileEntry::getUID", NM="_ZNK5clang9FileEntry6getUIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry6getUIDEv")
  //</editor-fold>
  public /*uint*/int getUID() /*const*/ {
    return UID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::getUniqueID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 88,
   FQN="clang::FileEntry::getUniqueID", NM="_ZNK5clang9FileEntry11getUniqueIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry11getUniqueIDEv")
  //</editor-fold>
  public /*const*/ fs.UniqueID /*&*/ getUniqueID() /*const*/ {
    return UniqueID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::isInPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 89,
   FQN="clang::FileEntry::isInPCH", NM="_ZNK5clang9FileEntry7isInPCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry7isInPCHEv")
  //</editor-fold>
  public boolean isInPCH() /*const*/ {
    return InPCH;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::getModificationTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 90,
   FQN="clang::FileEntry::getModificationTime", NM="_ZNK5clang9FileEntry19getModificationTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry19getModificationTimeEv")
  //</editor-fold>
  public long/*time_t*/ getModificationTime() /*const*/ {
    return ModTime;
  }

  
  /// \brief Return the directory the file lives in.
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::getDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 93,
   FQN="clang::FileEntry::getDir", NM="_ZNK5clang9FileEntry6getDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry6getDirEv")
  //</editor-fold>
  public /*const*/ DirectoryEntry /*P*/ getDir() /*const*/ {
    return Dir;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 95,
   FQN="clang::FileEntry::operator<", NM="_ZNK5clang9FileEntryltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntryltERKS0_")
  //</editor-fold>
  @Override
  public boolean $less(/*const*/Object /*&*/ RHS) /*const*/ {
    return UniqueID.$less(((FileEntry) RHS).UniqueID);
  }

  @Override
  public boolean $lesseq(Object RHS) {
    return UniqueID.$less(((FileEntry) RHS).UniqueID) || (!((FileEntry) RHS).UniqueID.$less(UniqueID));
  }
  
  /// \brief Check whether the file is a named pipe (and thus can't be opened by
  /// the native FileManager methods).
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::isNamedPipe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 99,
   FQN="clang::FileEntry::isNamedPipe", NM="_ZNK5clang9FileEntry11isNamedPipeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry11isNamedPipeEv")
  //</editor-fold>
  public boolean isNamedPipe() /*const*/ {
    return IsNamedPipe;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::closeFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", old_line = 101,
   FQN="clang::FileEntry::closeFile", NM="_ZNK5clang9FileEntry9closeFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZNK5clang9FileEntry9closeFileEv")
  //</editor-fold>
  public void closeFile() /*const*/ {
    File.reset(); // rely on destructor to close File
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileEntry::~FileEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/FileManager.h", line = 53,
   FQN="clang::FileEntry::~FileEntry", NM="_ZN5clang9FileEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN5clang9FileEntryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    File.$destroy();
    RealPathName.$destroy();
    //END JDestroy
  }

  @Override
  public FileEntry clone() {
    return new FileEntry(this);
  }
  
  @Override
  public boolean $noteq(FileEntry other) {
    return !$eq(other);
  }
  
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + this.UniqueID.hashCode();
    hash = 67 * hash + (this.IsNamedPipe ? 1 : 0);
    hash = 67 * hash + (this.InPCH ? 1 : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final FileEntry other = (FileEntry) obj;
    return $eq(other);
  }
  
  @Override
  public boolean $eq(FileEntry other) {
    // JAVA: check for null
    if (other == null) {
      return false;
    }
//    if (this.Size != other.Size) {
//      return false;
//    }
//    if (this.ModTime != other.ModTime) {
//      return false;
//    }
//    if (!this.Dir.equals(other.Dir)) {
//      return false;
//    }
//    if (this.UID != other.UID) {
//      return false;
//    }
    if (!this.UniqueID.equals(other.UniqueID)) {
      return false;
    }
//    if (!this.Name.equals(other.Name)) {
//      return false;
//    }
    if (this.IsNamedPipe != other.IsNamedPipe) {
      return false;
    }
    if (this.InPCH != other.InPCH) {
      return false;
    }
//    if (this.FD != other.FD) {
//      return false;
//    }
    return true;
  }

  @Override
  public String toString() {
    if (UID == -1) {
      assert this == FileEntry.DMI$FileEntryPtr.getEmptyKey();
      return "EMPTY_FILE_PTR_ENTRY";
    }
    if (UID == -2) {
      assert this == FileEntry.DMI$FileEntryPtr.getTombstoneKey();
      return "TOMBSTONE_FILE_PTR_ENTRY";
    }
    return "FileEntry{\n" + "Name=[" + toCharSequence(Name) // NOI18N
              + "], RealPathName=[" + RealPathName.toJavaString() // NOI18N
              + "], Size=" + Size // NOI18N
              + ", ModTime=" + ModTime // NOI18N
              + ",\nDir=" + Dir // NOI18N
              + ",\nUID=" + UID // NOI18N
              + ", UniqueID=" + UniqueID // NOI18N
              + ", IsNamedPipe=" + IsNamedPipe // NOI18N
              + ", InPCH=" + InPCH // NOI18N
              + ", IsValid=" + IsValid // NOI18N
              + ", File=" + File +"\n}"; // NOI18N
  }
}
