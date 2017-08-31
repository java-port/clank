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
package org.llvm.support.sys.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import org.clank.java.std_time.timespec;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.impl.FSEntity;
import static org.llvm.support.impl.PathStatics.createUniqueEntity;
import org.llvm.support.llvm.support.ulittle32_t;
import org.llvm.support.sys.*;
import org.llvm.support.sys.fs.*;
import static org.llvm.support.sys.fs.*;
import static org.llvm.support.sys.impl.PathFsStatics.hasProcSelfFD;
import static org.llvm.support.sys.path.*;


//<editor-fold defaultstate="collapsed" desc="static type PathFsGlobals">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs13make_absoluteERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs18create_directoriesERKNS_5TwineEb;_ZN4llvm3sys2fs16create_directoryERKNS_5TwineEb;_ZN4llvm3sys2fs11create_linkERKNS_5TwineES4_;_ZN4llvm3sys2fs12current_pathERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs6removeERKNS_5TwineEb;_ZN4llvm3sys2fs6renameERKNS_5TwineES4_;_ZN4llvm3sys2fs9copy_fileERKNS_5TwineES4_;_ZN4llvm3sys2fs11resize_fileEim;_ZN4llvm3sys2fs6existsENS1_11file_statusE;_ZN4llvm3sys2fs6accessERKNS_5TwineENS1_10AccessModeE;_ZN4llvm3sys2fs10equivalentENS1_11file_statusES2_;_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_Rb;_ZN4llvm3sys2fs12is_directoryENS1_11file_statusE;_ZN4llvm3sys2fs12is_directoryERKNS_5TwineERb;_ZN4llvm3sys2fs15is_regular_fileENS1_11file_statusE;_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineERb;_ZN4llvm3sys2fs8is_otherENS1_11file_statusE;_ZN4llvm3sys2fs8is_otherERKNS_5TwineERb;_ZN4llvm3sys2fs6statusERKNS_5TwineERNS1_11file_statusE;_ZN4llvm3sys2fs6statusEiRNS1_11file_statusE;_ZN4llvm3sys2fs32setLastModificationAndAccessTimeEiNS0_9TimeValueE;_ZN4llvm3sys2fs12status_knownENS1_11file_statusE;_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERiRNS_15SmallVectorImplIcEEj;_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs21createUniqueDirectoryERKNS_5TwineERNS_15SmallVectorImplIcEE;_ZN4llvm3sys2fs16openFileForWriteERKNS_5TwineERiNS1_9OpenFlagsEj;_ZN4llvm3sys2fs15openFileForReadERKNS_5TwineERi;_ZN4llvm3sys2fs14identify_magicENS_9StringRefE;_ZN4llvm3sys2fs14identify_magicERKNS_5TwineERNS1_10file_magicE;_ZN4llvm3sys2fs11getUniqueIDENS_5TwineERNS1_8UniqueIDE;_ZN4llvm3sys2fs17getMainExecutableEPKcPv; -static-type=PathFsGlobals -package=org.llvm.support.sys.impl")
//</editor-fold>
public final class PathFsGlobals {


/// @brief Make \a path an absolute path.
///
/// Makes \a path absolute using the current directory if it is not already. An
/// empty \a path will result in the current directory.
///
/// /absolute/path   => /absolute/path
/// relative/../path => <current-directory>/relative/../path
///
/// @param path A path that is modified to be an absolute path.
/// @returns errc::success if \a path has been made absolute, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::make_absolute">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 776,
 optimized = Converted.Optimization.VALUE_TYPE,
 FQN="llvm::sys::fs::make_absolute", NM="_ZN4llvm3sys2fsL13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEEb")
//</editor-fold>
public static std.error_code make_absolute(/*const*/ Twine /*&*/ current_directory, 
             SmallString/*&*/ _path, 
             boolean use_current_directory) {
  StringRef p/*J*/= new StringRef(_path.data(), _path.size());
  
  boolean rootDirectory = path.has_root_directory(p), 
      rootName = true;
  
  if (llvm.LLVM_ON_WIN32 || true) { //JAVA:#ifdef LLVM_ON_WIN32
     rootName = has_root_name(p);
  } else {//JAVA:#else
     rootName = true;
  } //JAVA: #endif  
  
  // Already absolute.
  if (rootName && rootDirectory) {
    return error_code.success();
  }
  
  // All of the following conditions will need the current directory.
  SmallString/*128*/ current_dir/*J*/= new SmallString/*128*/(128);
  if (use_current_directory) {
    current_directory.toVector(current_dir);
  } else {
    std.error_code ec = current_path(current_dir);
    if (ec.$bool()) {
      return ec;
    }
  }
  
  // Relative path. Prepend the current directory.
  if (!rootName && !rootDirectory) {
    // Append path to the current directory.
    path.append(current_dir, p);
    // Set path to the result.
    _path.swap(current_dir);
    return error_code.success();
  }
  if (!rootName && rootDirectory) {
    StringRef cdrn = path.root_name(current_dir.$StringRef());
    SmallString/*128*/ curDirRootName/*J*/= new SmallString/*128*/(cdrn.begin(), cdrn.end(), 128);
    path.append(curDirRootName, p);
    // Set path to the result.
    _path.swap(curDirRootName);
    return error_code.success();
  }
  if (rootName && !rootDirectory) {
    StringRef pRootName = path.root_name(p);
    StringRef bRootDirectory = path.root_directory(current_dir.$StringRef());
    StringRef bRelativePath = path.relative_path(current_dir.$StringRef());
    StringRef pRelativePath = path.relative_path(p);
    
    SmallString/*128*/ res/*J*/= new SmallString/*128*/(128);
    path.append(res, pRootName, bRootDirectory, bRelativePath, pRelativePath);
    _path.swap(res);
    return error_code.success();
  }
  throw new llvm_unreachable("All rootName and rootDirectory combinations should have occurred above!");
}


/// @brief Create all the non-existent directories in path.
///
/// @param path Directories to create.
/// @returns errc::success if is_directory(path), otherwise a platform
///          specific error_code. If IgnoreExisting is false, also returns
///          error if the directory already existed.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::create_directories">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 796,
 FQN = "llvm::sys::fs::create_directories", NM = "_ZN4llvm3sys2fs18create_directoriesERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs18create_directoriesERKNS_5TwineEb")
//</editor-fold>
public static std.error_code create_directories(/*const*/ Twine /*&*/ Path) {
  return create_directories(Path, true);
}
public static std.error_code create_directories(/*const*/ Twine /*&*/ Path, boolean IgnoreExisting/*= true*/) {
  SmallString/*128*/ PathStorage = null;
  try {
    PathStorage/*J*/= new SmallString/*128*/(128);
    StringRef P = Path.toStringRef(PathStorage);
    
    // Be optimistic and try to create the directory
    std.error_code EC = create_directory(new Twine(P), IgnoreExisting);
    // If we succeeded, or had any error other than the parent not existing, just
    // return it.
    if ($noteq_error_code(EC, errc.no_such_file_or_directory.make_error_code())) {
      return EC;
    }
    
    // We failed because of a no_such_file_or_directory, try to create the
    // parent.
    StringRef Parent = path.parent_path(new StringRef(P));
    if (Parent.empty()) {
      return EC;
    }
    if ((EC.$assign(create_directories(new Twine(Parent)))).$bool()) {
      return EC;
    }
    
    return create_directory(new Twine(P), IgnoreExisting);
  } finally {
    if (PathStorage != null) { PathStorage.$destroy(); }
  }
}


/// @brief Create the directory in path.
///
/// @param path Directory to create.
/// @returns errc::success if is_directory(path), otherwise a platform
///          specific error_code. If IgnoreExisting is false, also returns
///          error if the directory already existed.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::create_directory">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 222,
 FQN = "llvm::sys::fs::create_directory", NM = "_ZN4llvm3sys2fs16create_directoryERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16create_directoryERKNS_5TwineEb")
//</editor-fold>
public static std.error_code create_directory(/*const*/ Twine /*&*/ path) {
  return create_directory(path, true);
}
public static std.error_code create_directory(/*const*/ Twine /*&*/ path, boolean IgnoreExisting/*= true*/) {
  SmallString/*128*/ path_storage = null;
  try {
    path_storage/*J*/= new SmallString/*128*/(128);
    StringRef p = path.toNullTerminatedStringRef(path_storage);
    if (/*::*/mkdir(p.begin(), S_IRWXU | S_IRWXG) == -1) {
      if (errno() != EEXIST || !IgnoreExisting) {
        return new std.error_code(errno(), std.generic_category());
      }
    }
    
    return new std.error_code();
  } finally {
    if (path_storage != null) { path_storage.$destroy(); }
  }
}

/// @brief Create a link from \a from to \a to.
///
/// The link may be a soft or a hard link, depending on the platform. The caller
/// may not assume which one. Currently on windows it creates a hard link since
/// soft links require extra privileges. On unix, it creates a soft link since
/// hard links don't work on SMB file systems.
///
/// @param to The path to hard link to.
/// @param from The path to hard link from. This is created.
/// @returns errc::success if the link was created, otherwise a platform
/// specific error_code.

// Note that we are using symbolic link because hard links are not supported by
// all filesystems (SMB doesn't).
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::create_link">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 278,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 237,
 FQN="llvm::sys::fs::create_link", NM="_ZN4llvm3sys2fs11create_linkERKNS_5TwineES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11create_linkERKNS_5TwineES4_")
//</editor-fold>
public static std.error_code create_link(final /*const*/ Twine /*&*/ to, final /*const*/ Twine /*&*/ from) {
  // Get arguments.
  SmallString/*<128>*/ from_storage/*J*/= new SmallString/*<128>*/(128);
  SmallString/*<128>*/ to_storage/*J*/= new SmallString/*<128>*/(128);
  StringRef f = from.toNullTerminatedStringRef(from_storage);
  StringRef t = to.toNullTerminatedStringRef(to_storage);
  if (/*::*/symlink(t.begin(), f.begin()) == -1) {
    return new std.error_code(errno(), std.generic_category());
  }
  
  return new std.error_code();
}

/// @brief Get the current path.
///
/// @param result Holds the current path on return.
/// @returns errc::success if the current path has been stored in result,
///          otherwise a platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::current_path">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 187,
 FQN="llvm::sys::fs::current_path", NM="_ZN4llvm3sys2fs12current_pathERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12current_pathERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code current_path(SmallString/*&*/ result) {
  result.clear();
  
  /*const*/char$ptr/*char P*/ pwd = /*::*/getenv($("PWD"));
  fs.file_status PWDStatus/*J*/= new fs.file_status(), DotStatus/*J*/= new fs.file_status();
  if ((pwd != null) && path.is_absolute(new Twine(pwd))
     && !fs.status(new Twine(pwd), PWDStatus).$bool()
     && !fs.status(new Twine(/*KEEP_STR*/$DOT), DotStatus).$bool()
     && PWDStatus.getUniqueID().$eq(DotStatus.getUniqueID())) {
    result.append(pwd, strlen(pwd));
    return std.error_code.success();
  }
  result.reserve(MAXPATHLEN);
  while (true) {
    if ($eq_ptr(/*::*/getcwd(result.data(), result.capacity()), null)) {
      // See if there was a real error.
      if (errno() != ENOMEM) {
        return new std.error_code(errno(), std.generic_category());
      }
      // Otherwise there just wasn't enough space.
      result.reserve(result.capacity() * 2);
    } else {
      break;
    }
  }
  
  result.set_size(strlen(result.data()));
  return std.error_code.success();
}

/// @brief Remove path. Equivalent to POSIX remove().
///
/// @param path Input path.
/// @returns errc::success if path has been removed or didn't exist, otherwise a
///          platform-specific error code. If IgnoreNonExisting is false, also
///          returns error if the file didn't exist.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::remove">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 250,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 249,
 FQN = "llvm::sys::fs::remove", NM = "_ZN4llvm3sys2fs6removeERKNS_5TwineEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6removeERKNS_5TwineEb")
//</editor-fold>
public static std.error_code remove(/*const*/ Twine /*&*/ path) {
  return remove(path, true);
}
public static std.error_code remove(/*const*/ Twine /*&*/ path, boolean IgnoreNonExisting/*= true*/) {
  SmallString/*128*/ path_storage = null;
  try {
    path_storage/*J*/= new SmallString/*128*/(128);
    StringRef p = path.toNullTerminatedStringRef(path_storage);
    
     stat buf/*J*/= new  stat();
    if (io.lstat(p.begin(), $AddrOf(buf)) != 0) {
      if (errno() != ENOENT || !IgnoreNonExisting) {
        return new std.error_code(errno(), std.generic_category());
      }
      return new std.error_code();
    }
    
    // Note: this check catches strange situations. In all cases, LLVM should
    // only be involved in the creation and deletion of regular files.  This
    // check ensures that what we're trying to erase is a regular file. It
    // effectively prevents LLVM from erasing things like /dev/null, any block
    // special file, or other things that aren't "regular" files.
    if (!S_ISREG(buf.st_mode) && !S_ISDIR(buf.st_mode) && !S_ISLNK(buf.st_mode)) {
      return make_error_code(errc.operation_not_permitted);
    }
    if (/*::*/io.remove(p.begin()) == -1) {
      if (errno() != ENOENT || !IgnoreNonExisting) {
        return new std.error_code(errno(), std.generic_category());
      }
    }
    
    return new std.error_code();
  } finally {
    if (path_storage != null) { path_storage.$destroy(); }
  }
}

/// @brief Rename \a from to \a to. Files are renamed as if by POSIX rename().
///
/// @param from The path to rename from.
/// @param to The path to rename to. This is created.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::rename">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 277,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 276,
 FQN = "llvm::sys::fs::rename", NM = "_ZN4llvm3sys2fs6renameERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6renameERKNS_5TwineES4_")
//</editor-fold>
public static std.error_code rename(/*const*/ Twine /*&*/ from, /*const*/ Twine /*&*/ to) {
  // Get arguments.
  SmallString/*128*/ from_storage/*J*/= new SmallString(128);
  SmallString/*128*/ to_storage/*J*/= new SmallString(128);
  StringRef f = from.toNullTerminatedStringRef(from_storage);
  StringRef t = to.toNullTerminatedStringRef(to_storage);
  if (/*::*/io.rename(f.begin(), t.begin()) == -1) {
    return new error_code(errno(), system_category());
  }
  
  return error_code.success();
}

/// @brief Copy the contents of \a From to \a To.
///
/// @param From The path to copy from.
/// @param To The path to copy to. This is created.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::copy_file">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 866,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 819,
 FQN = "llvm::sys::fs::copy_file", NM = "_ZN4llvm3sys2fs9copy_fileERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs9copy_fileERKNS_5TwineES4_")
//</editor-fold>
public static std.error_code copy_file(/*const*/ Twine /*&*/ From, /*const*/ Twine /*&*/ To) {
  int$ref ReadFD = create_int$ref(), WriteFD = create_int$ref();
  {
    std.error_code EC = openFileForRead(From, ReadFD);
    if (EC.$bool()) {
      return EC;
    }
  }
  {
    std.error_code EC = openFileForWrite(To, WriteFD, OpenFlags.F_None);
    if (EC.$bool()) {
      close(ReadFD.$deref());
      return EC;
    }
  }
  
  /*const*//*size_t*/int BufSize = 4096;
  char$ptr/*char P*/ Buf = create_char$ptr(new$char(BufSize));
  int BytesRead = 0, BytesWritten = 0;
  for (;;) {
    BytesRead = (int) read((int)ReadFD.$deref(), Buf, BufSize);
    if (BytesRead <= 0) {
      break;
    }
    while ((BytesRead != 0)) {
      BytesWritten = (int) write((int)WriteFD.$deref(), Buf, BytesRead);
      if (BytesWritten < 0) {
        break;
      }
      BytesRead -= BytesWritten;
    }
    if (BytesWritten < 0) {
      break;
    }
  }
  close(ReadFD.$deref());
  close(WriteFD.$deref());
  /*delete[]*/Destructors.$destroyArray(Buf);
  if (BytesRead < 0 || BytesWritten < 0) {
    return new std.error_code(errno(), std.generic_category());
  }
  return new std.error_code();
}

/// @brief Resize path to size. File is resized as if by POSIX truncate().
///
/// @param FD Input file descriptor.
/// @param Size Size to resize to.
/// @returns errc::success if \a path has been resized to \a size, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::resize_file">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 290,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 289,
 FQN = "llvm::sys::fs::resize_file", NM = "_ZN4llvm3sys2fs11resize_fileEiy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11resize_fileEiy")
//</editor-fold>
public static std.error_code resize_file(int FD, long/*uint64_t*/ Size) {
  if (/*::*/ftruncate(FD, Size) == -1) {
    return new std.error_code(errno(), std.generic_category());
  }
  
  return new std.error_code();
}

/// @brief Does file exist?
///
/// @param status A file_status previously returned from stat.
/// @returns True if the file represented by status exists, false if it does
///          not.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::exists">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 900,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 853,
 FQN = "llvm::sys::fs::exists", NM = "_ZN4llvm3sys2fs6existsENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6existsENS1_11file_statusE")
//</editor-fold>
public static boolean exists(file_status status) {
  return status_known(new file_status(status)) && status.type() != file_type.file_not_found;
}

/// @brief Can the file be accessed?
///
/// @param Path Input path.
/// @returns errc::success if the path can be accessed, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::access">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 309,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 308,
 FQN = "llvm::sys::fs::access", NM = "_ZN4llvm3sys2fs6accessERKNS_5TwineENS1_10AccessModeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6accessERKNS_5TwineENS1_10AccessModeE")
//</editor-fold>
public static std.error_code access(/*const*/ Twine /*&*/ Path, AccessMode Mode) {
  SmallString/*128*/ PathStorage/*J*/= new SmallString/*128*/(128);
  StringRef P = Path.toNullTerminatedStringRef(PathStorage);
  if (/*::*/io.access(P.begin(), convertAccessMode(Mode)) == -1) {
    return new std.error_code(errno(), std.generic_category());
  }
  if (Mode == AccessMode.Execute) {
    // Don't say that directories are executable.
     stat buf/*J*/= new  stat();
    if (0 != stat(P.begin(), $AddrOf(buf))) {
      return new std.error_code(errc.permission_denied);
    }
    if (!S_ISREG(buf.st_mode)) {
      return new std.error_code(errc.permission_denied);
    }
  }
  
  return new std.error_code();
}

/// @brief Do file_status's represent the same thing?
///
/// @param A Input file_status.
/// @param B Input file_status.
///
/// assert(status_known(A) || status_known(B));
///
/// @returns True if A and B both represent the same file system entity, false
///          otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::equivalent">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 332,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 327,
 FQN = "llvm::sys::fs::equivalent", NM = "_ZN4llvm3sys2fs10equivalentENS1_11file_statusES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10equivalentENS1_11file_statusES2_")
//</editor-fold>
public static boolean equivalent(file_status A, file_status B) {
  assert (status_known(A) && status_known(B));
  return A.fs_st_dev == B.fs_st_dev && A.fs_st_ino == B.fs_st_ino;
}


/// @brief Do paths represent the same thing?
///
/// assert(status_known(A) || status_known(B));
///
/// @param A Input path A.
/// @param B Input path B.
/// @param result Set to true if stat(A) and stat(B) have the same device and
///               inode (or equivalent).
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::equivalent">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 338,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 333,
 FQN = "llvm::sys::fs::equivalent", NM = "_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_Rb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_Rb")
//</editor-fold>
public static std.error_code equivalent(/*const*/ Twine /*&*/ A, /*const*/ Twine /*&*/ B, bool$ref/*bool &*/ result) {
  file_status fsA/*J*/= new file_status(), fsB/*J*/= new file_status();
  {
    error_code ec = status(A, fsA);
    if (((ec.$Void2Void()) != null)) {
      return ec;
    }
  }
  {
    error_code ec = status(B, fsB);
    if (((ec.$Void2Void()) != null)) {
      return ec;
    }
  }
  result.$set(equivalent(fsA, fsB));
  return error_code.success();
}


/// @brief Does status represent a directory?
///
/// @param status A file_status previously returned from status.
/// @returns status.type() == file_type::directory_file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_directory">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 908,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 861,
 FQN = "llvm::sys::fs::is_directory", NM = "_ZN4llvm3sys2fs12is_directoryENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12is_directoryENS1_11file_statusE")
//</editor-fold>
public static boolean is_directory(file_status status) {
  return status.type().getValue() == file_type.directory_file.getValue();
}


/// @brief Is path a directory?
///
/// @param path Input path.
/// @param result Set to true if \a path is a directory, false if it is not.
///               Undefined otherwise.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_directory">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 912,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 865,
 FQN = "llvm::sys::fs::is_directory", NM = "_ZN4llvm3sys2fs12is_directoryERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12is_directoryERKNS_5TwineERb")
//</editor-fold>
public static std.error_code is_directory(/*const*/ Twine /*&*/ path, bool$ref/*bool &*/ result) {
  file_status st/*J*/= new file_status();
  {
    error_code ec = status(path, st);
    if (((ec.$Void2Void()) != null)) {
      return ec;
    }
  }
  result.$set(is_directory(st));
  return error_code.success();
}


/// @brief Does status represent a regular file?
///
/// @param status A file_status previously returned from status.
/// @returns status_known(status) && status.type() == file_type::regular_file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_regular_file">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 920,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 873,
 FQN = "llvm::sys::fs::is_regular_file", NM = "_ZN4llvm3sys2fs15is_regular_fileENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15is_regular_fileENS1_11file_statusE")
//</editor-fold>
public static boolean is_regular_file(file_status status) {
  return status.type().getValue() == file_type.regular_file.getValue();
}


/// @brief Is path a regular file?
///
/// @param path Input path.
/// @param result Set to true if \a path is a regular file, false if it is not.
///               Undefined otherwise.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_regular_file">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 924,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 877,
 FQN = "llvm::sys::fs::is_regular_file", NM = "_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineERb")
//</editor-fold>
public static std.error_code is_regular_file(/*const*/ Twine /*&*/ path, bool$ref/*bool &*/ result) {
  file_status st/*J*/= new file_status();
  {
    error_code ec = status(path, st);
    if (((ec.$Void2Void()) != null)) {
      return ec;
    }
  }
  result.$set(is_regular_file(st));
  return error_code.success();
}


/// @brief Does this status represent something that exists but is not a
///        directory, regular file, or symlink?
///
/// @param status A file_status previously returned from status.
/// @returns exists(s) && !is_regular_file(s) && !is_directory(s)
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_other">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 932,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 885,
 FQN = "llvm::sys::fs::is_other", NM = "_ZN4llvm3sys2fs8is_otherENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs8is_otherENS1_11file_statusE")
//</editor-fold>
public static boolean is_other(file_status status) {
  return exists(new file_status(status))
     && !is_regular_file(new file_status(status))
     && !is_directory(new file_status(status));
}


/// @brief Is path something that exists but is not a directory,
///        regular file, or symlink?
///
/// @param path Input path.
/// @param result Set to true if \a path exists, but is not a directory, regular
///               file, or a symlink, false if it does not. Undefined otherwise.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_other">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 938,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 891,
 FQN = "llvm::sys::fs::is_other", NM = "_ZN4llvm3sys2fs8is_otherERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs8is_otherERKNS_5TwineERb")
//</editor-fold>
public static std.error_code is_other(/*const*/ Twine /*&*/ Path, bool$ref/*bool &*/ Result) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// @brief Get file status as if by POSIX stat().
///
/// @param path Input path.
/// @param result Set to the file status.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 382,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 377,
 FQN = "llvm::sys::fs::status", NM = "_ZN4llvm3sys2fs6statusERKNS_5TwineERNS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6statusERKNS_5TwineERNS1_11file_statusE")
//</editor-fold>
public static std.error_code status(/*const*/ Twine /*&*/ Path, file_status /*&*/ Result) {
  SmallString/*128*/ PathStorage/*J*/= new SmallString(128);
  StringRef P = Path.toNullTerminatedStringRef(PathStorage);
  
   stat Status/*J*/= new  stat();
  int StatRet = /*::*/stat(P.begin(), $AddrOf(Status));
  return fillStatus(StatRet, Status, Result);
}


/// @brief A version for when a file descriptor is already available.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 391,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 386,
 FQN = "llvm::sys::fs::status", NM = "_ZN4llvm3sys2fs6statusEiRNS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6statusEiRNS1_11file_statusE")
//</editor-fold>
public static std.error_code status(int FD, file_status /*&*/ Result) {
   stat Status/*J*/= new  stat();
  int StatRet = /*::*/fstat(FD, $AddrOf(Status));
  return fillStatus(StatRet, Status, Result);
}


/// @brief Set the file modification and access time.
///
/// @returns errc::success if the file times were successfully set, otherwise a
///          platform-specific error_code or errc::function_not_supported on
///          platforms where the functionality isn't available.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::setLastModificationAndAccessTime">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 397,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 392,
 FQN = "llvm::sys::fs::setLastModificationAndAccessTime", NM = "_ZN4llvm3sys2fs32setLastModificationAndAccessTimeEiNS0_9TimeValueE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs32setLastModificationAndAccessTimeEiNS0_9TimeValueE")
//</editor-fold>
public static std.error_code setLastModificationAndAccessTime(int FD, TimeValue Time) {
  timespec Times[/*2*/]/*J*/= new timespec [2];
  Times[0].tv_sec = Time.toEpochTime();
  Times[0].tv_nsec = 0;
  Times[1].$assign(Times[0]);
  if ((/*::*/futimens(FD, Times) != 0)) {
    return new error_code(errno(), system_category());
  }
  return error_code.success();
}


/// @brief Is status available?
///
/// @param s Input file status.
/// @returns True if status() != status_error.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status_known">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 904,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 857,
 FQN = "llvm::sys::fs::status_known", NM = "_ZN4llvm3sys2fs12status_knownENS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs12status_knownENS1_11file_statusE")
//</editor-fold>
public static boolean status_known(file_status s) {
  return s.type().getValue() != file_type.status_error.getValue();
}


/// @brief Create a uniquely named file.
///
/// Generates a unique path suitable for a temporary file and then opens it as a
/// file. The name is based on \a model with '%' replaced by a random char in
/// [0-9a-f]. If \a model is not an absolute path, a suitable temporary
/// directory will be prepended.
///
/// Example: clang-%%-%%-%%-%%-%%.s => clang-a0-b1-c2-d3-e4.s
///
/// This is an atomic operation. Either the file is created and opened, or the
/// file system is left untouched.
///
/// The intendend use is for files that are to be kept, possibly after
/// renaming them. For example, when running 'clang -c foo.o', the file can
/// be first created as foo-abc123.o and then renamed.
///
/// @param Model Name to base unique path off of.
/// @param ResultFD Set to the opened file's file descriptor.
/// @param ResultPath Set to the opened file's absolute path.
/// @returns errc::success if Result{FD,Path} have been successfully set,
///          otherwise a platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createUniqueFile">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 722,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 689,
 FQN = "llvm::sys::fs::createUniqueFile", NM = "_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERiRNS_15SmallVectorImplIcEEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERiRNS_15SmallVectorImplIcEEj")
//</editor-fold>
public static std.error_code createUniqueFile(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFd, 
                SmallString/*&*/ ResultPath) {
  return createUniqueFile(Model, ResultFd, 
                ResultPath, 
                $bitor_perms(perms.all_read, perms.all_write));
}
public static std.error_code createUniqueFile(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFd, 
                SmallString/*&*/ ResultPath, 
                /*uint*/int Mode/*= all_read | all_write*/) {
  return createUniqueEntity(Model, ResultFd, ResultPath, false, Mode, FSEntity.FS_File);
}


/// @brief Simpler version for clients that don't want an open file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createUniqueFile">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 728,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 695,
 FQN = "llvm::sys::fs::createUniqueFile", NM = "_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16createUniqueFileERKNS_5TwineERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createUniqueFile(/*const*/ Twine /*&*/ Model, 
                SmallString/*&*/ ResultPath) {
  int$ref Dummy = create_int$ref();
  return createUniqueEntity(Model, Dummy, ResultPath, false, 0, FSEntity.FS_Name);
}


/// @brief Create a file in the system temporary directory.
///
/// The filename is of the form prefix-random_chars.suffix. Since the directory
/// is not know to the caller, Prefix and Suffix cannot have path separators.
/// The files are created with mode 0600.
///
/// This should be used for things like a temporary .s that is removed after
/// running the assembler.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 754,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 721,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Prefix, StringRef Suffix, 
                   int$ref/*int &*/ ResultFD, 
                   SmallString/*&*/ ResultPath) {
  return PathFsStatics.createTemporaryFile(Prefix, Suffix, ResultFD, ResultPath, FSEntity.FS_File);
}


/// @brief Simpler version for clients that don't want an open file.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 760,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 727,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs19createTemporaryFileERKNS_5TwineENS_9StringRefERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Prefix, StringRef Suffix, 
                   SmallString/*&*/ ResultPath) {
  int$ref Dummy = create_int$ref();
  return PathFsStatics.createTemporaryFile(Prefix, Suffix, Dummy, ResultPath, FSEntity.FS_Name);
}


// This is a mkdtemp with a different pattern. We use createUniqueEntity mostly
// for consistency. We should try using mkdtemp.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createUniqueDirectory">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 769,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 736,
 FQN = "llvm::sys::fs::createUniqueDirectory", NM = "_ZN4llvm3sys2fs21createUniqueDirectoryERKNS_5TwineERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs21createUniqueDirectoryERKNS_5TwineERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code createUniqueDirectory(/*const*/ Twine /*&*/ Prefix, 
                     SmallString/*&*/ ResultPath) {
  int$ref Dummy = create_int$ref();
  return createUniqueEntity($add_Twine(Prefix, new Twine("-%%%%%%")), Dummy, ResultPath, true, 0, FSEntity.FS_Dir);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::openFileForWrite">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 519,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 514,
 FQN = "llvm::sys::fs::openFileForWrite", NM = "_ZN4llvm3sys2fs16openFileForWriteERKNS_5TwineERiNS1_9OpenFlagsEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs16openFileForWriteERKNS_5TwineERiNS1_9OpenFlagsEj")
//</editor-fold>
public static std.error_code openFileForWrite(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD, 
                /*fs.OpenFlags*/int Flags) {
  return openFileForWrite(Name, ResultFD, 
                Flags, 0666);
}
public static std.error_code openFileForWrite(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD, 
                /*fs.OpenFlags*/int Flags, /*uint*/int Mode/*= 0666*/) {
  // Verify that we don't have both "append" and "excl".
  assert ((!((Flags & fs.OpenFlags.F_Excl) != 0) || !((Flags & fs.OpenFlags.F_Append) != 0))) : "Cannot specify both 'excl' and 'append' file creation flags!";
  
  int OpenFlags = O_CREAT;
  if (((Flags & fs.OpenFlags.F_RW) != 0)) {
    OpenFlags |= O_RDWR;
  } else {
    OpenFlags |= O_WRONLY;
  }
  if (((Flags & fs.OpenFlags.F_Append) != 0)) {
    OpenFlags |= O_APPEND;
  } else {
    OpenFlags |= O_TRUNC;
  }
  if (((Flags & fs.OpenFlags.F_Excl) != 0)) {
    OpenFlags |= O_EXCL;
  }
  
  SmallString/*128*/ Storage/*J*/= new SmallString/*128*/(128);
  StringRef P = Name.toNullTerminatedStringRef(Storage);
  while ((ResultFD.$set(open(P.begin(), OpenFlags, Mode))) < 0) {
    if (errno() != EINTR) {
      return new std.error_code(errno(), std.generic_category());
    }
  }
  return new std.error_code();
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::openFileForRead">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*disabled hasProcSelfFD branch*/,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 560,
 FQN="llvm::sys::fs::openFileForRead", NM="_ZN4llvm3sys2fs15openFileForReadERKNS_5TwineERiPNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs15openFileForReadERKNS_5TwineERiPNS_15SmallVectorImplIcEE")
//</editor-fold>
public static std.error_code openFileForRead(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD) {
  return openFileForRead(Name, ResultFD, 
               (SmallString/*P*/ )null);
}
public static std.error_code openFileForRead(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ ResultFD, 
               SmallString/*P*/ RealPath/*= null*/) {
  SmallString/*128*/ Storage/*J*/= new SmallString/*128*/(128);
  StringRef P = Name.toNullTerminatedStringRef(Storage);
  while ((ResultFD.$set(open(P.begin(), O_RDONLY))) < 0) {
    if (errno() != EINTR) {
      return new std.error_code(errno(), std.generic_category());
    }
  }
  // Attempt to get the real name of the file, if the user asked
  if (!(RealPath != null)) {
    return new std.error_code();
  }
  RealPath.clear();
  /*char*/byte Buffer[/*4096*/] = new$char(4096);
  if (/*JAVA readlink is not implemented*/false && hasProcSelfFD()) {
    /*char*/byte ProcPath[/*64*/] = new$char(64);
    snprintf(create_char$ptr(ProcPath), sizeof (ProcPath), $("/proc/self/fd/%d"), ResultFD.$deref());
    int CharCount = /*::*/readlink(create_char$ptr(ProcPath), Buffer);
    if (CharCount > 0) {
      RealPath.append(Buffer, 0, CharCount);
    }
  } else {
    // Use ::realpath to get the real path name
    if ($noteq_ptr(/*::*/realpath(P.begin(), Buffer), null)) {
      RealPath.append(Buffer, 0, strlen(Buffer));
    }
  }
  return new std.error_code();
}


/// @brief Identify the type of a binary file based on how magical it is.

/// @brief Identify the magic in magic.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::identify_magic">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 954,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 908,
 FQN = "llvm::sys::fs::identify_magic", NM = "_ZN4llvm3sys2fs14identify_magicENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs14identify_magicENS_9StringRefE")
//</editor-fold>
public static file_magic identify_magic(StringRef Magic) {
  if (Magic.size() < 4) {
    return new file_magic(file_magic.Impl.unknown);
  }
  switch ($char(Magic.$at(0))) {
   case 0x00:
    {
      // COFF short import library file
      if (Magic.$at(1) == (/*char*/byte)0x00 && Magic.$at(2) == (/*char*/byte)0xff && Magic.$at(3) == (/*char*/byte)0xff) {
        return new file_magic(file_magic.Impl.coff_import_library);
      }
      // Windows resource file
      /*const*//*char*/byte Expected[/*9*/] = new /*const*//*char*/byte [/*9*/] {0, 0, 0, 0, (byte)0x20, 0, 0, 0, (byte)0xff};
      if (Magic.size() >= sizeof (Expected) && memcmp(Magic.data(), create_char$ptr(Expected), sizeof (Expected)) == 0) {
        return new file_magic(file_magic.Impl.windows_resource);
      }
      // 0x0000 = COFF unknown machine type
      if (Magic.$at(1) == 0) {
        return new file_magic(file_magic.Impl.coff_object);
      }
      break;
    }
   case 0xDE: // 0x0B17C0DE = BC wraper
    if (Magic.$at(1) == (/*char*/byte)0xC0 && Magic.$at(2) == (/*char*/byte)0x17 && Magic.$at(3) == (/*char*/byte)0x0B) {
      return new file_magic(file_magic.Impl.bitcode);
    }
    break;
   case 'B':
    if (Magic.$at(1) == $('C') && Magic.$at(2) == (/*char*/byte)0xC0 && Magic.$at(3) == (/*char*/byte)0xDE) {
      return new file_magic(file_magic.Impl.bitcode);
    }
    break;
   case '!':
    if (Magic.size() >= 8) {
      if (memcmp(Magic.data(), "!<arch>\n", 8) == 0) {
        return new file_magic(file_magic.Impl.archive);
      }
    }
    break;
   case 0x7f:
    if (Magic.size() >= 18 && Magic.$at(1) == $('E') && Magic.$at(2) == $('L') && Magic.$at(3) == $('F')) {
      boolean Data2MSB = Magic.$at(5) == 2;
      /*uint*/int high = Data2MSB ? 16 : 17;
      /*uint*/int low = Data2MSB ? 17 : 16;
      if (Magic.$at(high) == 0) {
        switch (Magic.$at(low)) {
         default:
          break;
         case 1:
          return new file_magic(file_magic.Impl.elf_relocatable);
         case 2:
          return new file_magic(file_magic.Impl.elf_executable);
         case 3:
          return new file_magic(file_magic.Impl.elf_shared_object);
         case 4:
          return new file_magic(file_magic.Impl.elf_core);
        }
      }
    }
    break;
   case 0xCA:
    if (Magic.$at(1) == ((/*char*/byte)(0xFE)) && Magic.$at(2) == ((/*char*/byte)(0xBA)) && Magic.$at(3) == ((/*char*/byte)(0xBE))) {
      // This is complicated by an overlap with Java class files.
      // See the Mach-O section in /usr/share/file/magic for details.
      if (Magic.size() >= 8 && Magic.$at(7) < 43) {
        return new file_magic(file_magic.Impl.macho_universal_binary);
      }
    }
    break;
   case 0xFE:
   case 0xCE:
   case 0xCF:
    {
      char/*uint16_t*/ type = 0;
      if (Magic.$at(0) == ((/*char*/byte)(0xFE)) && Magic.$at(1) == ((/*char*/byte)(0xED)) && Magic.$at(2) == ((/*char*/byte)(0xFA)) && (Magic.$at(3) == ((/*char*/byte)(0xCE)) || Magic.$at(3) == ((/*char*/byte)(0xCF)))) {
        /* Native endian */
        if (Magic.size() >= 16) {
          type = (char) (Magic.$at(14) << 8 | Magic.$at(15));
        }
      } else if ((Magic.$at(0) == ((/*char*/byte)(0xCE)) || Magic.$at(0) == ((/*char*/byte)(0xCF))) && Magic.$at(1) == ((/*char*/byte)(0xFA)) && Magic.$at(2) == ((/*char*/byte)(0xED)) && Magic.$at(3) == ((/*char*/byte)(0xFE))) {
        /* Reverse endian */
        if (Magic.size() >= 14) {
          type = (char) (Magic.$at(13) << 8 | Magic.$at(12));
        }
      }
      switch (type) {
       default:
        break;
       case 1:
        return new file_magic(file_magic.Impl.macho_object);
       case 2:
        return new file_magic(file_magic.Impl.macho_executable);
       case 3:
        return new file_magic(file_magic.Impl.macho_fixed_virtual_memory_shared_lib);
       case 4:
        return new file_magic(file_magic.Impl.macho_core);
       case 5:
        return new file_magic(file_magic.Impl.macho_preload_executable);
       case 6:
        return new file_magic(file_magic.Impl.macho_dynamically_linked_shared_lib);
       case 7:
        return new file_magic(file_magic.Impl.macho_dynamic_linker);
       case 8:
        return new file_magic(file_magic.Impl.macho_bundle);
       case 9:
        return new file_magic(file_magic.Impl.macho_dynamic_linker);
       case 10:
        return new file_magic(file_magic.Impl.macho_dsym_companion);
      }
      break;
    }
   case 0xF0: // PowerPC Windows
   case 0x83: // Alpha 32-bit
   case 0x84: // Alpha 64-bit
   case 0x66: // MPS R4000 Windows
   case 0x50: // mc68K
   case 0x4c: // 80386 Windows
    if (Magic.$at(1) == 0x01) {
      return new file_magic(file_magic.Impl.coff_object);
    }
   case 0x90: // PA-RISC Windows
   case 0x68: // mc68K Windows
    if (Magic.$at(1) == 0x02) {
      return new file_magic(file_magic.Impl.coff_object);
    }
    break;
   case 'M': // Possible MS-DOS stub on Windows PE file
    if (Magic.$at(1) == 'Z') {
      /*uint*/int off = new ulittle32_t(Magic.data().$add(0x3c)).$value();
//      int/*uint32_t*/ off = /*Deref*/reinterpret_cast(/*const*/ulittle32_t /*P*/ .class, Magic.data().$add(0x3c)).$/*uint*/int();
      // PE/COFF file, either EXE or DLL.
      if (off < Magic.size() && memcmp(Magic.data().$add(off), "PE\000\000", 4) == 0) {
        return new file_magic(file_magic.Impl.pecoff_executable);
      }
    }
    break;
   case 0x64: // x86-64 Windows.
    if (Magic.$at(1) == ((/*char*/byte)(0x86))) {
      return new file_magic(file_magic.Impl.coff_object);
    }
    break;
   default:
    break;
  }
  return new file_magic(file_magic.Impl.unknown);
}


/// @brief Get and identify \a path's type based on its content.
///
/// @param path Input path.
/// @param result Set to the type of file, or file_magic::unknown.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::identify_magic">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 1103,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 1056,
 FQN = "llvm::sys::fs::identify_magic", NM = "_ZN4llvm3sys2fs14identify_magicERKNS_5TwineERNS1_10file_magicE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs14identify_magicERKNS_5TwineERNS1_10file_magicE")
//</editor-fold>
public static std.error_code identify_magic(/*const*/ Twine /*&*/ Path, file_magic /*&*/ Result) {
  int$ref FD = create_int$ref();
  {
    std.error_code EC = openFileForRead(Path, FD);
    if (EC.$bool()) {
      return EC;
    }
  }
  
  /*const*//*size_t*/int BufSize = 32;
  char$ptr/*char P*/ Buffer = create_char$ptr(new$char(BufSize));  
  long Length = read(FD.$deref(), Buffer, BufSize);
  if (close(FD.$deref()) != 0 || Length < 0) {
    return new std.error_code(errno(), std.generic_category());
  }
  
  Result.$assignMove(identify_magic(new StringRef(Buffer, $long2uint(Length))));
  return new std.error_code();
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::getUniqueID">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 713,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 680,
 FQN = "llvm::sys::fs::getUniqueID", NM = "_ZN4llvm3sys2fs11getUniqueIDENS_5TwineERNS1_8UniqueIDE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11getUniqueIDENS_5TwineERNS1_8UniqueIDE")
//</editor-fold>
public static std.error_code getUniqueID(/*const*/ Twine Path, UniqueID /*&*/ Result) {
  file_status Status/*J*/= new file_status();
  error_code EC = status(Path, Status);
  if (((EC.$Void2Void()) != null)) {
    return EC;
  }
  Result.$assign(Status.getUniqueID());
  return error_code.success();
}


/// Return the path to the main executable, given the value of argv[0] from
/// program startup and the address of main itself. In extremis, this function
/// may fail and return an empty path.
// __FreeBSD__ || __NetBSD__ || __FreeBSD_kernel__

/// GetMainExecutable - Return the path to the main executable, given the
/// value of argv[0] from program startup.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::getMainExecutable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 127,
 FQN="llvm::sys::fs::getMainExecutable", NM="_ZN4llvm3sys2fs17getMainExecutableEPKcPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs17getMainExecutableEPKcPv")
//</editor-fold>
public static std.string getMainExecutable(/*const*/char$ptr/*char P*/ argv0, Object/*void P*/ MainAddr) {
  // VV: check it
  if (argv0 != null) {
    return new std.string(argv0);
  }
  // Use dladdr to get executable path if available.
  Dl_info DLInfo/*J*/= new Dl_info();
  int err = io.dladdr(MainAddr, $AddrOf(DLInfo));
  if (err == 0) {
    return new std.string("");
  }
  
  // If the filename is a symlink, we need to resolve and return the location of
  // the actual executable.
  /*char*/byte link_path[/*1024*/] = new$char(1024);
  if ((realpath(DLInfo.dli_fname, link_path) != null)) {
    return new std.string(link_path);
  }
  return new std.string("");
}

} // END OF class PathFsGlobals
