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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.impl.*;
import static org.llvm.support.impl.PathStatics.*;
import org.llvm.support.sys.fs.*;
import static org.llvm.support.sys.fs.*;


//<editor-fold defaultstate="collapsed" desc="static type PathFsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineERiRNS_15SmallVectorImplIcEE8FSEntity;_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE8FSEntity;_ZN4llvm3sys2fsL13make_absoluteERKNS_5TwineERNS_15SmallVectorImplIcEEb;_ZN4llvm3sys2fsL8test_dirEPcPKcS4_;_ZN4llvm3sys2fsL11getprogpathEPcPKc;_ZN4llvm3sys2fsL17convertAccessModeENS1_10AccessModeE;_ZN4llvm3sys2fsL10fillStatusEiRK4statRNS1_11file_statusE; -static-type=PathFsStatics ")
//</editor-fold>
public final class PathFsStatics {

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 734,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 701,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineERiRNS_15SmallVectorImplIcEE8FSEntity",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineERiRNS_15SmallVectorImplIcEE8FSEntity")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Model, int$ref/*int &*/ ResultFD, 
                   SmallString/*&*/ ResultPath, FSEntity Type) {
  SmallString/*128*/ Storage/*J*/= new SmallString/*128*/(128);
  StringRef P = Model.toNullTerminatedStringRef(Storage);
  assert (P.find_first_of(separators) == StringRef.npos) : "Model must be a simple filename.";
  // Use P.begin() so that createUniqueEntity doesn't need to recreate Storage.
  return createUniqueEntity(new Twine(P.begin()), ResultFD, ResultPath, 
      true, $bitor_perms(perms.owner_read, perms.owner_write), Type);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::createTemporaryFile">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 746,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 713,
 FQN = "llvm::sys::fs::createTemporaryFile", NM = "_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE8FSEntity",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL19createTemporaryFileERKNS_5TwineENS_9StringRefERiRNS_15SmallVectorImplIcEE8FSEntity")
//</editor-fold>
public static std.error_code createTemporaryFile(/*const*/ Twine /*&*/ Prefix, StringRef Suffix, int$ref/*int &*/ ResultFD, 
                   SmallString/*&*/ ResultPath, FSEntity Type) {
  /*const*/char$ptr/*char P*/ Middle = $tryClone(Suffix.empty() ? $("-%%%%%%") : $("-%%%%%%."));
  return createTemporaryFile($add_Twine($add_Twine(Prefix, new Twine(Middle)), new Twine(Suffix)), ResultFD, ResultPath, 
      Type);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::test_dir">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 71,
 FQN="llvm::sys::fs::test_dir", NM="_ZN4llvm3sys2fsL8test_dirEPcPKcS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL8test_dirEPcPKcS4_")
//</editor-fold>
public static int test_dir(/*char*/byte ret[/*4096*/], /*const*/char$ptr/*char P*/ dir, /*const*/char$ptr/*char P*/ bin) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::getprogpath">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 86,
 FQN="llvm::sys::fs::getprogpath", NM="_ZN4llvm3sys2fsL11getprogpathEPcPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL11getprogpathEPcPKc")
//</editor-fold>
public static char$ptr/*char P*/ getprogpath(/*char*/byte ret[/*4096*/], /*const*/char$ptr/*char P*/ bin) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::convertAccessMode">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 297,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 296,
 FQN = "llvm::sys::fs::convertAccessMode", NM = "_ZN4llvm3sys2fsL17convertAccessModeENS1_10AccessModeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL17convertAccessModeENS1_10AccessModeE")
//</editor-fold>
public static int convertAccessMode(AccessMode Mode) {
  switch (Mode) {
   case Exist:
    return F_OK;
   case Write:
    return W_OK;
   case Execute:
    return R_OK | X_OK; // scripts also need R_OK.
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::fillStatus">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 348,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 343,
 FQN = "llvm::sys::fs::fillStatus", NM = "_ZN4llvm3sys2fsL10fillStatusEiRK4statRNS1_11file_statusE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL10fillStatusEiRK4statRNS1_11file_statusE")
//</editor-fold>
public static std.error_code fillStatus(int StatRet, /*const*/  stat /*&*/ Status, 
          file_status /*&*/ Result) {
  if (StatRet != 0) {
    std.error_code ec/*J*/= new std.error_code(errno(), std.generic_category());
    if ($eq_error_code(ec, new error_code(errc.no_such_file_or_directory))) {
      Result.$assignMove(new file_status(file_type.file_not_found));
    } else {
      Result.$assignMove(new file_status(file_type.status_error));
    }
    return ec;
  }
  
  file_type Type = file_type.type_unknown;
  if (S_ISDIR(Status.st_mode)) {
    Type = file_type.directory_file;
  } else if (S_ISREG(Status.st_mode)) {
    Type = file_type.regular_file;
  } else if (S_ISBLK(Status.st_mode)) {
    Type = file_type.block_file;
  } else if (S_ISCHR(Status.st_mode)) {
    Type = file_type.character_file;
  } else if (S_ISFIFO(Status.st_mode)) {
    Type = file_type.fifo_file;
  } else if (S_ISSOCK(Status.st_mode)) {
    Type = file_type.socket_file;
  }
  
  /*fs.prems*/int Perms = ((/*static_cast*//*fs.prems*/int)(Status.st_mode));
  Result.$assignMove(new file_status(Type, Perms, Status.st_dev, Status.st_ino, Status.st_mtim.tv_sec, Status.st_uid, Status.st_gid, Status.st_size));
  
  return new std.error_code();
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::hasProcSelfFD">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 552,
 FQN="llvm::sys::fs::hasProcSelfFD", NM="_ZN4llvm3sys2fsL13hasProcSelfFDEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fsL13hasProcSelfFDEv")
//</editor-fold>
public static boolean hasProcSelfFD() {
  // If we have a /proc filesystem mounted, we can quickly establish the
  // real name of the file with readlink
  final/*static*/ /*const*/boolean Result = hasProcSelfFD$$.Result;
  return Result;
}
private static final class hasProcSelfFD$$ {
  static final/*static*/ /*const*/boolean Result = (/*::*/access($("/proc/self/fd"), R_OK) == 0);
}

} // END OF class PathFsStatics
