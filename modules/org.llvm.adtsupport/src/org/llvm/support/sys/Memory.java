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

package org.llvm.support.sys;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.sys.*;


/// This class provides various memory handling functions that manipulate
/// MemoryBlock instances.
/// @since 1.4
/// @brief An abstraction for memory operations.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 46,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", old_line = 45,
 FQN = "llvm::sys::Memory", NM = "_ZN4llvm3sys6MemoryE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6MemoryE")
//</editor-fold>
public class Memory {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::ProtectionFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Memory.h", old_line = 47,
   FQN = "llvm::sys::Memory::ProtectionFlags", NM = "_ZN4llvm3sys6Memory15ProtectionFlagsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory15ProtectionFlagsE")
  //</editor-fold>
  public static final class/*enum*/ ProtectionFlags {
    public static final int MF_READ = 0x1000000;
    public static final int MF_WRITE = 0x2000000;
    public static final int MF_EXEC = 0x4000000;
  };
  
  /// This method allocates a block of memory that is suitable for loading
  /// dynamically generated code (e.g. JIT). An attempt to allocate
  /// \p NumBytes bytes of virtual memory is made.
  /// \p NearBlock may point to an existing allocation in which case
  /// an attempt is made to allocate more memory near the existing block.
  /// The actual allocated address is not guaranteed to be near the requested
  /// address.
  /// \p Flags is used to set the initial protection flags for the block
  /// of the memory.
  /// \p EC [out] returns an object describing any error that occurs.
  ///
  /// This method may allocate more than the number of bytes requested.  The
  /// actual number of bytes allocated is indicated in the returned
  /// MemoryBlock.
  ///
  /// The start of the allocated block must be aligned with the
  /// system allocation granularity (64K on Windows, page size on Linux).
  /// If the address following \p NearBlock is not so aligned, it will be
  /// rounded up to the next allocation granularity boundary.
  ///
  /// \r a non-null MemoryBlock if the function was successful, 
  /// otherwise a null MemoryBlock is with \p EC describing the error.
  ///
  /// @brief Allocate mapped memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::allocateMappedMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 81,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", old_line = 82,
   FQN = "llvm::sys::Memory::allocateMappedMemory", NM = "_ZN4llvm3sys6Memory20allocateMappedMemoryEjPKNS0_11MemoryBlockEjRSt10error_code",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory20allocateMappedMemoryEjPKNS0_11MemoryBlockEjRSt10error_code")
  //</editor-fold>
  public static MemoryBlock allocateMappedMemory(/*size_t*/int NumBytes, 
                      /*const*/ MemoryBlock /*P*/ /*const*/ NearBlock, 
                      /*uint*/int PFlags, 
                      std.error_code /*&*/ EC) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method releases a block of memory that was allocated with the
  /// allocateMappedMemory method. It should not be used to release any
  /// memory block allocated any other way.
  /// \p Block describes the memory to be released.
  ///
  /// \r error_success if the function was successful, or an error_code
  /// describing the failure if an error occurred.
  /// 
  /// @brief Release mapped memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::releaseMappedMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 139,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", old_line = 140,
   FQN = "llvm::sys::Memory::releaseMappedMemory", NM = "_ZN4llvm3sys6Memory19releaseMappedMemoryERNS0_11MemoryBlockE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory19releaseMappedMemoryERNS0_11MemoryBlockE")
  //</editor-fold>
  public static std.error_code releaseMappedMemory(MemoryBlock /*&*/ M) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method sets the protection flags for a block of memory to the
  /// state specified by /p Flags.  The behavior is not specified if the
  /// memory was not allocated using the allocateMappedMemory method.
  /// \p Block describes the memory block to be protected.
  /// \p Flags specifies the new protection state to be assigned to the block.
  /// \p ErrMsg [out] returns a string describing any error that occurred.
  ///
  /// If \p Flags is MF_WRITE, the actual behavior varies
  /// with the operating system (i.e. MF_READ | MF_WRITE on Windows) and the
  /// target architecture (i.e. MF_WRITE -> MF_READ | MF_WRITE on i386).
  ///
  /// \r error_success if the function was successful, or an error_code
  /// describing the failure if an error occurred.
  ///
  /// @brief Set memory protection state.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::protectMappedMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 153,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", old_line = 154,
   FQN = "llvm::sys::Memory::protectMappedMemory", NM = "_ZN4llvm3sys6Memory19protectMappedMemoryERKNS0_11MemoryBlockEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory19protectMappedMemoryERKNS0_11MemoryBlockEj")
  //</editor-fold>
  public static std.error_code protectMappedMemory(/*const*/ MemoryBlock /*&*/ M, /*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method allocates a block of Read/Write/Execute memory that is
  /// suitable for executing dynamically generated code (e.g. JIT). An
  /// attempt to allocate \p NumBytes bytes of virtual memory is made.
  /// \p NearBlock may point to an existing allocation in which case
  /// an attempt is made to allocate more memory near the existing block.
  ///
  /// On success, this returns a non-null memory block, otherwise it returns
  /// a null memory block and fills in *ErrMsg.
  ///
  /// @brief Allocate Read/Write/Execute memory.
  
  /// AllocateRWX - Allocate a slab of memory with read/write/execute
  /// permissions.  This is typically used for JIT applications where we want
  /// to emit code to the memory then jump to it.  Getting this type of memory
  /// is very OS specific.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::AllocateRWX">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 179,
   FQN = "llvm::sys::Memory::AllocateRWX", NM = "_ZN4llvm3sys6Memory11AllocateRWXEjPKNS0_11MemoryBlockEPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory11AllocateRWXEjPKNS0_11MemoryBlockEPSs")
  //</editor-fold>
  public static MemoryBlock AllocateRWX(/*size_t*/int NumBytes, /*const*/ MemoryBlock /*P*/ NearBlock) {
    return AllocateRWX(NumBytes, NearBlock, 
             (std.string/*P*/ )null);
  }
  public static MemoryBlock AllocateRWX(/*size_t*/int NumBytes, /*const*/ MemoryBlock /*P*/ NearBlock, 
             std.string/*P*/ ErrMsg/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This method releases a block of Read/Write/Execute memory that was
  /// allocated with the AllocateRWX method. It should not be used to
  /// release any memory block allocated any other way.
  ///
  /// On success, this returns false, otherwise it returns true and fills
  /// in *ErrMsg.
  /// @brief Release Read/Write/Execute memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::ReleaseRWX">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 248,
   FQN = "llvm::sys::Memory::ReleaseRWX", NM = "_ZN4llvm3sys6Memory10ReleaseRWXERNS0_11MemoryBlockEPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory10ReleaseRWXERNS0_11MemoryBlockEPSs")
  //</editor-fold>
  public static boolean ReleaseRWX(MemoryBlock /*&*/ M) {
    return ReleaseRWX(M, (std.string/*P*/ )null);
  }
  public static boolean ReleaseRWX(MemoryBlock /*&*/ M, std.string/*P*/ ErrMsg/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// InvalidateInstructionCache - Before the JIT can run a block of code
  /// that has been emitted it must invalidate the instruction cache on some
  /// platforms.
  
  /// InvalidateInstructionCache - Before the JIT can run a block of code
  /// that has been emitted it must invalidate the instruction cache on some
  /// platforms.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::InvalidateInstructionCache">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 304,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", old_line = 307,
   FQN = "llvm::sys::Memory::InvalidateInstructionCache", NM = "_ZN4llvm3sys6Memory26InvalidateInstructionCacheEPKvj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory26InvalidateInstructionCacheEPKvj")
  //</editor-fold>
  public static void InvalidateInstructionCache(/*const*/void$ptr/*void P*/ Addr, 
                            /*size_t*/int Len) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// setExecutable - Before the JIT can run a block of code, it has to be
  /// given read and executable privilege. Return true if it is already r-x
  /// or the system is able to change its previlege.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::setExecutable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 267,
   FQN = "llvm::sys::Memory::setExecutable", NM = "_ZN4llvm3sys6Memory13setExecutableERNS0_11MemoryBlockEPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory13setExecutableERNS0_11MemoryBlockEPSs")
  //</editor-fold>
  public static boolean setExecutable(MemoryBlock /*&*/ M) {
    return setExecutable(M, (std.string/*P*/ )null);
  }
  public static boolean setExecutable(MemoryBlock /*&*/ M, std.string/*P*/ ErrMsg/*= null*/) {
    return true;
  }

  
  /// setWritable - When adding to a block of code, the JIT may need
  /// to mark a block of code as RW since the protections are on page
  /// boundaries, and the JIT internal allocations are not page aligned.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::setWritable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 255,
   FQN = "llvm::sys::Memory::setWritable", NM = "_ZN4llvm3sys6Memory11setWritableERNS0_11MemoryBlockEPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory11setWritableERNS0_11MemoryBlockEPSs")
  //</editor-fold>
  public static boolean setWritable(MemoryBlock /*&*/ M) {
    return setWritable(M, (std.string/*P*/ )null);
  }
  public static boolean setWritable(MemoryBlock /*&*/ M, std.string/*P*/ ErrMsg/*= null*/) {
    return true;
  }

  
  /// setRangeExecutable - Mark the page containing a range of addresses
  /// as executable.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::setRangeExecutable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 290,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", old_line = 293,
   FQN = "llvm::sys::Memory::setRangeExecutable", NM = "_ZN4llvm3sys6Memory18setRangeExecutableEPKvj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory18setRangeExecutableEPKvj")
  //</editor-fold>
  public static boolean setRangeExecutable(/*const*/void$ptr/*void P*/ Addr, /*size_t*/int Size) {
    return true;
  }

  
  /// setRangeWritable - Mark the page containing a range of addresses
  /// as writable.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Memory::setRangeWritable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", line = 279,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Memory.inc", old_line = 282,
   FQN = "llvm::sys::Memory::setRangeWritable", NM = "_ZN4llvm3sys6Memory16setRangeWritableEPKvj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Memory.cpp -nm=_ZN4llvm3sys6Memory16setRangeWritableEPKvj")
  //</editor-fold>
  public static boolean setRangeWritable(/*const*/void$ptr/*void P*/ Addr, /*size_t*/int Size) {
    return true;
  }

  
  public String toString() {
    return ""; // NOI18N
  }
}
