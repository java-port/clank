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
package org.clang.basic.vfs;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;

import org.clang.basic.impl.RealFileSystem;
import org.clang.basic.impl.RedirectingFileSystem;
import org.llvm.adt.ADTFunctionPointers.DiagHandlerTy;
import org.llvm.support.sys.fs.UniqueID;


//<editor-fold defaultstate="collapsed" desc="static type VfsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs14getVFSFromYAMLESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EEPFvRKNS2_12SMDiagnosticEPvESA_NS2_18IntrusiveRefCntPtrINS0_10FileSystemEEE;_ZN5clang3vfs17getRealFileSystemEv;_ZN5clang3vfs22getNextVirtualUniqueIDEv; -static-type=VfsGlobals -package=org.clang.basic.vfs ")
//</editor-fold>
public final class VfsGlobals {


/// \brief Gets an \p vfs::FileSystem for the 'real' file system, as seen by
/// the operating system.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::getRealFileSystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 245,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 228,
 FQN="clang::vfs::getRealFileSystem", NM="_ZN5clang3vfs17getRealFileSystemEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17getRealFileSystemEv")
//</editor-fold>
public static IntrusiveRefCntPtr<FileSystem> getRealFileSystem() {
  final/*static*/ IntrusiveRefCntPtr<FileSystem> FS = getRealFileSystem$$.FS;
  return new IntrusiveRefCntPtr<FileSystem>(FS);
}
private static final class getRealFileSystem$$ {
  static final/*static*/ IntrusiveRefCntPtr<FileSystem> FS = new IntrusiveRefCntPtr<FileSystem>(new RealFileSystem());
}


/// \brief Get a globally unique ID for a virtual file or directory.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::getNextVirtualUniqueID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1591,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1371,
 FQN="clang::vfs::getNextVirtualUniqueID", NM="_ZN5clang3vfs22getNextVirtualUniqueIDEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs22getNextVirtualUniqueIDEv")
//</editor-fold>
public static UniqueID getNextVirtualUniqueID() {
  final/*static*/ std.atomicUInt UID = getNextVirtualUniqueID$$.UID;
  /*uint*/int ID = UID.$preInc();
  // The following assumes that uint64_t max will never collide with a real
  // dev_t value from the OS.
  return new UniqueID(std.numeric_limitsULLong.max(), $uint2ulong(ID));
}
private static final class getNextVirtualUniqueID$$ {
  static final/*static*/ std.atomicUInt UID/*J*/= new std.atomicUInt();
}


/// \brief Gets a \p FileSystem for a virtual file system described in YAML
/// format.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::getVFSFromYAML">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1580,
 FQN="clang::vfs::getVFSFromYAML", NM="_ZN5clang3vfs14getVFSFromYAMLESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EEPFvRKNS2_12SMDiagnosticEPvENS2_9StringRefESA_NS2_18IntrusiveRefCntPtrINS0_10FileSystemEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs14getVFSFromYAMLESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EEPFvRKNS2_12SMDiagnosticEPvENS2_9StringRefESA_NS2_18IntrusiveRefCntPtrINS0_10FileSystemEEE")
//</editor-fold>
public static IntrusiveRefCntPtr<FileSystem> getVFSFromYAML(std.unique_ptr<MemoryBuffer> Buffer, 
              DiagHandlerTy DiagHandler, 
              StringRef YAMLFilePath) {
  return getVFSFromYAML(Buffer, 
              DiagHandler, 
              YAMLFilePath, 
              (Object/*void P*/ )null, 
              getRealFileSystem());
}

public static IntrusiveRefCntPtr<FileSystem> getVFSFromYAML(std.unique_ptr<MemoryBuffer> Buffer, 
              DiagHandlerTy DiagHandler, 
              StringRef YAMLFilePath, 
              Object/*void P*/ DiagContext/*= null*/) {
  return getVFSFromYAML(Buffer, 
              DiagHandler, 
              YAMLFilePath, 
              DiagContext, 
              getRealFileSystem());
}
public static IntrusiveRefCntPtr<FileSystem> getVFSFromYAML(std.unique_ptr<MemoryBuffer> Buffer, 
              DiagHandlerTy DiagHandler, 
              StringRef YAMLFilePath, 
              Object/*void P*/ DiagContext/*= null*/, 
              IntrusiveRefCntPtr<FileSystem> ExternalFS/*= getRealFileSystem()*/) {
  return new IntrusiveRefCntPtr<FileSystem>(RedirectingFileSystem.create(Buffer, DiagHandler, 
          YAMLFilePath, DiagContext, 
          new IntrusiveRefCntPtr<FileSystem>(ExternalFS)));
}

} // END OF class VfsGlobals
