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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.support.sys.*;
import org.llvm.support.sys.fs.*;
import static org.llvm.support.sys.fs.*;


//<editor-fold defaultstate="collapsed" desc="static type FileSystemFsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsorENS1_5permsES2_;_ZN4llvm3sys2fsanENS1_5permsES2_;_ZN4llvm3sys2fsoRERNS1_5permsES2_;_ZN4llvm3sys2fsaNERNS1_5permsES2_;_ZN4llvm3sys2fscoENS1_5permsE;_ZN4llvm3sys2fs6existsERKNS_5TwineE;_ZN4llvm3sys2fs11can_executeERKNS_5TwineE;_ZN4llvm3sys2fs9can_writeERKNS_5TwineE;_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_;_ZN4llvm3sys2fs12is_directoryERKNS_5TwineE;_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineE;_ZN4llvm3sys2fs9file_sizeERKNS_5TwineERm;_ZN4llvm3sys2fs12status_knownERKNS_5TwineERb;_ZN4llvm3sys2fsorENS1_9OpenFlagsES2_;_ZN4llvm3sys2fsoRERNS1_9OpenFlagsES2_; -static-type=FileSystemFsGlobals -package=org.llvm.support.sys.impl")
//</editor-fold>
public final class FileSystemFsGlobals {


// Helper functions so that you can use & and | to manipulate perms bits:
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 98,
 FQN="llvm::sys::fs::operator|", NM="_ZN4llvm3sys2fsorENS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsorENS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int $bitor_perms(/*fs.prems*/int l, /*fs.prems*/int r) {
  return ((/*static_cast*//*fs.prems*/int)(((/*static_cast*//*ushort*/char)(l)) | ((/*static_cast*//*ushort*/char)(r))));
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator&">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 102,
 FQN="llvm::sys::fs::operator&", NM="_ZN4llvm3sys2fsanENS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsanENS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int $bitand_perms(/*fs.prems*/int l, /*fs.prems*/int r) {
  return ((/*static_cast*//*fs.prems*/int)(((/*static_cast*//*ushort*/char)(l)) & ((/*static_cast*//*ushort*/char)(r))));
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|=">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 106,
 FQN="llvm::sys::fs::operator|=", NM="_ZN4llvm3sys2fsoRERNS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsoRERNS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int/*&*/ $orassign_perms(/*fs.prems*/int/*&*/ l, /*fs.prems*/int r) {
  l = $bitor_perms(l, r);
  return l;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator&=">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 110,
 FQN="llvm::sys::fs::operator&=", NM="_ZN4llvm3sys2fsaNERNS1_5permsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsaNERNS1_5permsES2_")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int/*&*/ $andassign_perms(/*fs.prems*/int/*&*/ l, /*fs.prems*/int r) {
  l = $bitand_perms(l, r);
  return l;
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator~">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 114,
 FQN="llvm::sys::fs::operator~", NM="_ZN4llvm3sys2fscoENS1_5permsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fscoENS1_5permsE")
//</editor-fold>
public static /*inline*/ /*fs.prems*/int $bitnot_perms(/*fs.prems*/int x) {
  return ((/*static_cast*//*fs.prems*/int)(~((/*static_cast*//*ushort*/char)(x))));
}


/// @brief Does file exist?
///
/// @param Path Input path.
/// @returns True if it exists, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::exists">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 387,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 369,
 FQN = "llvm::sys::fs::exists", NM = "_ZN4llvm3sys2fs6existsERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs6existsERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean exists(/*const*/ Twine /*&*/ Path) {
  return !access(Path, AccessMode.Exist).$bool();
}

/// @brief Can we execute this file?
///
/// @param Path Input path.
/// @returns True if we can execute it, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::can_execute">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 328,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 377,
 FQN = "llvm::sys::fs::can_execute", NM = "_ZN4llvm3sys2fs11can_executeERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs11can_executeERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean can_execute(/*const*/ Twine /*&*/ Path) {
  return !access(Path, AccessMode.Execute).$bool();
}

/// @brief Can we write this file?
///
/// @param Path Input path.
/// @returns True if we can write to it, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::can_write">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 401,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 385,
 FQN = "llvm::sys::fs::can_write", NM = "_ZN4llvm3sys2fs9can_writeERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys2fs9can_writeERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean can_write(/*const*/ Twine /*&*/ Path) {
  return !access(Path, AccessMode.Write).$bool();
}

/// @brief Simpler version of equivalent for clients that don't need to
///        differentiate between an error and false.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::equivalent">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 430,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 414,
 FQN = "llvm::sys::fs::equivalent", NM = "_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs10equivalentERKNS_5TwineES4_")
//</editor-fold>
public static /*inline*/ boolean equivalent(/*const*/ Twine /*&*/ A, /*const*/ Twine /*&*/ B) {
  bool$ref result = create_bool$ref();
  return !fs.equivalent(A, B, result).$bool() && result.$deref();
}


/// @brief Simpler version of is_directory for clients that don't need to
///        differentiate between an error and false.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_directory">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 452,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 436,
 FQN = "llvm::sys::fs::is_directory", NM = "_ZN4llvm3sys2fs12is_directoryERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs12is_directoryERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean is_directory(/*const*/ Twine /*&*/ Path) {
  bool$ref Result = create_bool$ref();
  return !fs.is_directory(Path, Result).$bool() && Result.$deref();
}


/// @brief Simpler version of is_regular_file for clients that don't need to
///        differentiate between an error and false.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::is_regular_file">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 474,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 458,
 FQN = "llvm::sys::fs::is_regular_file", NM = "_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs15is_regular_fileERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ boolean is_regular_file(/*const*/ Twine /*&*/ Path) {
  bool$ref Result = create_bool$ref();
  if (fs.is_regular_file(Path, Result).$bool()) {
    return false;
  }
  return Result.$deref();
}


/// @brief Get file size.
///
/// @param Path Input path.
/// @param Result Set to the size of the file in \a Path.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::file_size">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 515,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 499,
 FQN = "llvm::sys::fs::file_size", NM = "_ZN4llvm3sys2fs9file_sizeERKNS_5TwineERy",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs9file_sizeERKNS_5TwineERy")
//</editor-fold>
public static /*inline*/ std.error_code file_size(/*const*/ Twine /*&*/ Path, ulong$ref/*uint64_t &*/ Result) {
  file_status Status/*J*/= new file_status();
  std.error_code EC = status(Path, Status);
  if (EC.$bool()) {
    return EC;
  }
  Result.$set(Status.getSize());
  return new std.error_code();
}


/// @brief Is status available?
///
/// @param path Input path.
/// @param result Set to true if status() != status_error.
/// @returns errc::success if result has been successfully set, otherwise a
///          platform-specific error_code.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::status_known">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 543,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 527,
 FQN = "llvm::sys::fs::status_known", NM = "_ZN4llvm3sys2fs12status_knownERKNS_5TwineERb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fs12status_knownERKNS_5TwineERb")
//</editor-fold>
public static std.error_code status_known(/*const*/ Twine /*&*/ path, bool$ref/*bool &*/ result) {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 613,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 597,
 FQN = "llvm::sys::fs::operator|", NM = "_ZN4llvm3sys2fsorENS1_9OpenFlagsES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsorENS1_9OpenFlagsES2_")
//</editor-fold>
public static /*inline*/ /*fs.OpenFlags*/int $bitor_OpenFlags(/*fs.OpenFlags*/int A, /*fs.OpenFlags*/int B) {
  return ((/*fs.OpenFlags*/int)(((/*uint*/int)(A)) | ((/*uint*/int)(B))));
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::fs::operator|=">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", line = 617,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/FileSystem.h", old_line = 601,
 FQN = "llvm::sys::fs::operator|=", NM = "_ZN4llvm3sys2fsoRERNS1_9OpenFlagsES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/FileManager.cpp -nm=_ZN4llvm3sys2fsoRERNS1_9OpenFlagsES2_")
//</editor-fold>
public static /*inline*/ /*fs.OpenFlags*/int/*&*/ $orassign_OpenFlags(/*fs.OpenFlags*/int/*&*/ A, /*fs.OpenFlags*/int B) {
  A = $bitor_OpenFlags(A, B);
  return A;
}

} // END OF class FileSystemFsGlobals
