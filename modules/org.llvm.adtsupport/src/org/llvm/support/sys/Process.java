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

import static org.clank.support.Native.$AddrOf;
import java.util.Random;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.impl.ProcessStatics.*;
import org.llvm.support.sys.*;
import org.llvm.support.unix.impl.FDCloser;


/// \brief A collection of legacy interfaces for querying information about the
/// current executing process.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::Process">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Process.h", line = 44,
 FQN="llvm::sys::Process", NM="_ZN4llvm3sys7ProcessE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7ProcessE")
//</editor-fold>
public class Process {
/*public:*/
  
  // On Cygwin, getpagesize() returns 64k(AllocationGranularity) and
  // offset in mmap(3) should be aligned to the AllocationGranularity.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::getPageSize">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 84,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 81,
   FQN = "llvm::sys::Process::getPageSize", NM = "_ZN4llvm3sys7Process11getPageSizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process11getPageSizeEv")
  //</editor-fold>
  public static /*uint*/int getPageSize() {
    final/*static*/ /*const*/int page_size = /*::*/getpagesize();
    return ((/*static_cast*//*uint*/int)(page_size));
  }

  
  /// \brief Return process memory usage.
  /// This static function will return the total amount of memory allocated
  /// by the process. This only counts the memory allocated via the malloc,
  /// calloc and realloc functions and includes any "free" holes in the
  /// allocated space.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::GetMallocUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 95,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 92,
   FQN = "llvm::sys::Process::GetMallocUsage", NM = "_ZN4llvm3sys7Process14GetMallocUsageEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process14GetMallocUsageEv")
  //</editor-fold>
  public static /*size_t*/int GetMallocUsage() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This static function will set \p user_time to the amount of CPU time
  /// spent in user (non-kernel) mode and \p sys_time to the amount of CPU
  /// time spent in system (kernel) mode.  If the operating system does not
  /// support collection of these metrics, a zero TimeValue will be for both
  /// values.
  /// \param elapsed Returns the TimeValue::now() giving current time
  /// \param user_time Returns the current amount of user time for the process
  /// \param sys_time Returns the current amount of system time for the process
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::GetTimeUsage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std.tie*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 124,
   FQN="llvm::sys::Process::GetTimeUsage", NM="_ZN4llvm3sys7Process12GetTimeUsageERNS0_9TimeValueES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process12GetTimeUsageERNS0_9TimeValueES3_S3_")
  //</editor-fold>
  public static void GetTimeUsage(final TimeValue /*&*/ elapsed, final TimeValue /*&*/ user_time, 
              final TimeValue /*&*/ sys_time) {
    elapsed.$assignMove(TimeValue.now());
//    std.tie(user_time, sys_time).$assign(getRUsageTimes());
    std_pair.pair<TimeValue, TimeValue> $pair = getRUsageTimes();
    user_time.$assign($pair.first);
    sys_time.$assign($pair.second);
  }

  
  /// This function makes the necessary calls to the operating system to
  /// prevent core files or any other kind of large memory dumps that can
  /// occur when a program fails.
  /// @brief Prevent core file generation.
  
  // Some LLVM programs such as bugpoint produce core files as a normal part of
  // their operation. To prevent the disk from filling up, this function
  // does what's necessary to prevent their generation.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::PreventCoreFiles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 137,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 129,
   FQN = "llvm::sys::Process::PreventCoreFiles", NM = "_ZN4llvm3sys7Process16PreventCoreFilesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process16PreventCoreFilesEv")
  //</editor-fold>
  public static void PreventCoreFiles() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // This function returns the environment variable \arg name's value as a UTF-8
  // string. \arg Name is assumed to be in UTF-8 encoding too.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::GetEnv">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 174,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 166,
   FQN = "llvm::sys::Process::GetEnv", NM = "_ZN4llvm3sys7Process6GetEnvENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process6GetEnvENS_9StringRefE")
  //</editor-fold>
  public static Optional<std.string> GetEnv(StringRef Name) {
    std.string NameStr = Name.str();
    /*const*/char$ptr/*char P*/ Val = $tryClone(/*::*/getenv(NameStr.c_str()));
    if (!(Val != null)) {
      return new Optional<std.string>(NoneType.None);
    }
    return new Optional<std.string>(JD$T$RR.INSTANCE, new std.string(Val));
  }

  
  /// This function searches for an existing file in the list of directories
  /// in a PATH like environment variable, and returns the first file found,
  /// according to the order of the entries in the PATH like environment
  /// variable.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::FindInEnvPath">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Process.cpp", line = 29,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Process.cpp", old_line = 47,
   FQN = "llvm::sys::Process::FindInEnvPath", NM = "_ZN4llvm3sys7Process13FindInEnvPathERKSsS3_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process13FindInEnvPathERKSsS3_")
  //</editor-fold>
  public static Optional<std.string> FindInEnvPath(/*const*/std.string/*&*/ EnvName, 
               /*const*/std.string/*&*/ FileName) {
    Optional<std.string> FoundPath = null;
    SmallVector<StringRef> Dirs = null;
    try {
      FoundPath/*J*/= new Optional<std.string>();
      Optional<std.string> OptPath = Process.GetEnv(new StringRef(EnvName));
      if (!OptPath.hasValue()) {
        return new Optional<std.string>(FoundPath);
      }

      /*const*//*char*/byte EnvPathSeparatorStr[/*2*/] = new$char(2, sys.EnvPathSeparator, $$TERM);
      Dirs/*J*/= new SmallVector<StringRef>(8, new StringRef());
      SplitString(new StringRef(OptPath.getValue()), Dirs, new StringRef(EnvPathSeparatorStr));

      for (/*const*/ StringRef /*&*/ Dir : Dirs) {
        SmallString/*128*/ FilePath = null;
        try {
          if (Dir.empty()) {
            continue;
          }

          FilePath/*J*/= new SmallString/*128*/(new StringRef(Dir), 128);
          path.append(FilePath, FileName);
          if (fs.exists(new Twine(FilePath.$StringRef()))) {
            FoundPath.$assign(FilePath.str().$string());
            break;
          }
        } finally {
          if (FilePath != null) { FilePath.$destroy(); }
        }
      }

      return new Optional<std.string>(FoundPath);
    } finally {
      if (Dirs != null) { Dirs.$destroy(); }
      if (FoundPath != null) { FoundPath.$destroy(); }
    }
  }

  
  /// This function returns a SmallVector containing the arguments passed from
  /// the operating system to the program.  This function expects to be handed
  /// the vector passed in from main.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::GetArgumentVector">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 182,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 174,
   FQN = "llvm::sys::Process::GetArgumentVector", NM = "_ZN4llvm3sys7Process17GetArgumentVectorERNS_15SmallVectorImplIPKcEENS_8ArrayRefIS4_EERNS_24SpecificBumpPtrAllocatorIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process17GetArgumentVectorERNS_15SmallVectorImplIPKcEENS_8ArrayRefIS4_EERNS_24SpecificBumpPtrAllocatorIcEE")
  //</editor-fold>
  public static std.error_code GetArgumentVector(SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ ArgsOut, 
                   ArrayRef</*const*/char$ptr/*char P*/ > ArgsIn, 
                   SpecificBumpPtrAllocator/*<byte>*//*&*/ $Prm2) {
    ArgsOut.append_T(ArgsIn.begin(), ArgsIn.end());

    return new std.error_code();
  }

  
  // This functions ensures that the standard file descriptors (input, output,
  // and error) are properly mapped to a file descriptor before we use any of
  // them.  This should only be called by standalone programs, library
  // components should not call this.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::FixupStandardFileDescriptors">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 210,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 202,
   FQN = "llvm::sys::Process::FixupStandardFileDescriptors", NM = "_ZN4llvm3sys7Process28FixupStandardFileDescriptorsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process28FixupStandardFileDescriptorsEv")
  //</editor-fold>
  public static std.error_code FixupStandardFileDescriptors() {
    FDCloser FDC = null;
    try {
      int$ref NullFD = create_int$ref(-1);
      FDC/*J*/= new FDCloser(NullFD);
      /*const*/int StandardFDs[/*3*/] = new /*const*/int [/*3*/] {STDIN_FILENO, STDOUT_FILENO, STDERR_FILENO};
      for (int StandardFD : StandardFDs) {
         stat st/*J*/= new  stat();
        setErrno(0);
        while (fstat(StandardFD, $AddrOf(st)) < 0) {
          assert ((errno() != 0)) : "expected errno to be set if fstat failed!";
          // fstat should return EBADF if the file descriptor is closed.
          if (errno() == EBADF) {
            break;
          }
          // retry fstat if we got EINTR, otherwise bubble up the failure.
          if (errno() != EINTR) {
            return new std.error_code(errno(), std.generic_category());
          }
        }
        // if fstat succeeds, move on to the next FD.
        if (!(errno() != 0)) {
          continue;
        }
        assert (errno() == 9) : "expected errno to have EBADF at this point!";
        if (NullFD.$deref() < 0) {
          while ((NullFD.$set(open($("/dev/null"), O_RDWR)) < 0)) {
            if (errno() == EINTR) {
              continue;
            }
            return new std.error_code(errno(), std.generic_category());
          }
        }
        if (NullFD.$deref() == StandardFD) {
          FDC.keepOpen();
        } else if (dup2(NullFD.$deref(), StandardFD) < 0) {
          return new std.error_code(errno(), std.generic_category());
        }
      }
      return new std.error_code();
    } finally {
      if (FDC != null) { FDC.$destroy(); }
    }
  }

  
  // This function safely closes a file descriptor.  It is not safe to retry
  // close(2) when it returns with errno equivalent to EINTR; this is because
  // *nixen cannot agree if the file descriptor is, in fact, closed when this
  // occurs.
  //
  // N.B. Some operating systems, due to thread cancellation, cannot properly
  // guarantee that it will or will not be closed one way or the other!
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::SafelyCloseFileDescriptor">
  @Converted(kind = Converted.Kind.DUMMY/*signals are not considered*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 249,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 247,
   FQN="llvm::sys::Process::SafelyCloseFileDescriptor", NM="_ZN4llvm3sys7Process25SafelyCloseFileDescriptorEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process25SafelyCloseFileDescriptorEi")
  //</editor-fold>
  public static std.error_code SafelyCloseFileDescriptor(int FD) {
//    // Create a signal set filled with *all* signals.
//     sigset_t FullSet/*J*/= new  sigset_t();
//    if (sigfillset(/*AddrOf*/FullSet) < 0) {
//      return new std.error_code(errno(), std.generic_category());
//    }
//    // Atomically swap our current signal mask with a full mask.
//     sigset_t SavedSet/*J*/= new  sigset_t();
//    {
//      int EC = pthread_sigmask(SIG_SETMASK, /*AddrOf*/FullSet, /*AddrOf*/SavedSet);
//      if ((EC != 0)) {
//        return new std.error_code(EC, std.generic_category());
//      }
//    }
    // Attempt to close the file descriptor.
    // We need to save the error, if one occurs, because our subsequent call to
    // pthread_sigmask might tamper with errno.
    int ErrnoFromClose = 0;
    if (/*::*/close(FD) < 0) {
      ErrnoFromClose = errno();
    }
    // Restore the signal mask back to what we saved earlier.
    int EC = 0;
//    EC = pthread_sigmask(SIG_SETMASK, /*AddrOf*/SavedSet, ( sigset_t /*P*/ )null);
//    // The error code from close takes precedence over the one from
//    // pthread_sigmask.
    if ((ErrnoFromClose != 0)) {
      return new std.error_code(ErrnoFromClose, std.generic_category());
    }
    return new std.error_code(EC, std.generic_category());
  }

  
  /// This function determines if the standard input is connected directly
  /// to a user's input (keyboard probably), rather than coming from a file
  /// or pipe.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardInIsUserInput">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 282,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 274,
   FQN = "llvm::sys::Process::StandardInIsUserInput", NM = "_ZN4llvm3sys7Process21StandardInIsUserInputEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process21StandardInIsUserInputEv")
  //</editor-fold>
  public static boolean StandardInIsUserInput() {
    return FileDescriptorIsDisplayed(STDIN_FILENO);
  }

  
  /// This function determines if the standard output is connected to a
  /// "tty" or "console" window. That is, the output would be displayed to
  /// the user rather than being put on a pipe or stored in a file.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardOutIsDisplayed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 286,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 278,
   FQN = "llvm::sys::Process::StandardOutIsDisplayed", NM = "_ZN4llvm3sys7Process22StandardOutIsDisplayedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process22StandardOutIsDisplayedEv")
  //</editor-fold>
  public static boolean StandardOutIsDisplayed() {
    return FileDescriptorIsDisplayed(STDOUT_FILENO);
  }

  
  /// This function determines if the standard error is connected to a
  /// "tty" or "console" window. That is, the output would be displayed to
  /// the user rather than being put on a pipe or stored in a file.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardErrIsDisplayed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 290,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 282,
   FQN = "llvm::sys::Process::StandardErrIsDisplayed", NM = "_ZN4llvm3sys7Process22StandardErrIsDisplayedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process22StandardErrIsDisplayedEv")
  //</editor-fold>
  public static boolean StandardErrIsDisplayed() {
    return FileDescriptorIsDisplayed(STDERR_FILENO);
  }

  
  /// This function determines if the given file descriptor is connected to
  /// a "tty" or "console" window. That is, the output would be displayed to
  /// the user rather than being put on a pipe or stored in a file.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::FileDescriptorIsDisplayed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 294,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 286,
   FQN = "llvm::sys::Process::FileDescriptorIsDisplayed", NM = "_ZN4llvm3sys7Process25FileDescriptorIsDisplayedEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process25FileDescriptorIsDisplayedEi")
  //</editor-fold>
  public static boolean FileDescriptorIsDisplayed(int fd) {
    return (isatty(fd) != 0);
  }

  
  /// This function determines if the given file descriptor is displayd and
  /// supports colors.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::FileDescriptorHasColors">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 391,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 383,
   FQN = "llvm::sys::Process::FileDescriptorHasColors", NM = "_ZN4llvm3sys7Process23FileDescriptorHasColorsEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process23FileDescriptorHasColorsEi")
  //</editor-fold>
  public static boolean FileDescriptorHasColors(int fd) {
    // A file descriptor has colors if it is displayed and the terminal has
    // colors.
    return FileDescriptorIsDisplayed(fd) && terminalHasColors(fd);
  }

  
  /// This function determines the number of columns in the window
  /// if standard output is connected to a "tty" or "console"
  /// window. If standard output is not connected to a tty or
  /// console, or if the number of columns cannot be determined,
  /// this routine returns zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardOutColumns">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 323,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 315,
   FQN = "llvm::sys::Process::StandardOutColumns", NM = "_ZN4llvm3sys7Process18StandardOutColumnsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process18StandardOutColumnsEv")
  //</editor-fold>
  public static /*uint*/int StandardOutColumns() {
    if (!StandardOutIsDisplayed()) {
      return 0;
    }

    return getColumns(1);
  }

  
  /// This function determines the number of columns in the window
  /// if standard error is connected to a "tty" or "console"
  /// window. If standard error is not connected to a tty or
  /// console, or if the number of columns cannot be determined,
  /// this routine returns zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardErrColumns">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 330,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 322,
   FQN = "llvm::sys::Process::StandardErrColumns", NM = "_ZN4llvm3sys7Process18StandardErrColumnsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process18StandardErrColumnsEv")
  //</editor-fold>
  public static /*uint*/int StandardErrColumns() {
    if (!StandardErrIsDisplayed()) {
      return 0;
    }

    return getColumns(2);
  }

  
  /// This function determines whether the terminal connected to standard
  /// output supports colors. If standard output is not connected to a
  /// terminal, this function returns false.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardOutHasColors">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 397,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 389,
   FQN = "llvm::sys::Process::StandardOutHasColors", NM = "_ZN4llvm3sys7Process20StandardOutHasColorsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process20StandardOutHasColorsEv")
  //</editor-fold>
  public static boolean StandardOutHasColors() {
    return FileDescriptorHasColors(STDOUT_FILENO);
  }

  
  /// This function determines whether the terminal connected to standard
  /// error supports colors. If standard error is not connected to a
  /// terminal, this function returns false.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::StandardErrHasColors">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 401,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 393,
   FQN = "llvm::sys::Process::StandardErrHasColors", NM = "_ZN4llvm3sys7Process20StandardErrHasColorsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process20StandardErrHasColorsEv")
  //</editor-fold>
  public static boolean StandardErrHasColors() {
    return FileDescriptorHasColors(STDERR_FILENO);
  }

  
  /// Enables or disables whether ANSI escape sequences are used to output
  /// colors. This only has an effect on Windows.
  /// Note: Setting this option is not thread-safe and should only be done
  /// during initialization.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::UseANSIEscapeCodes">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 405,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 397,
   FQN = "llvm::sys::Process::UseANSIEscapeCodes", NM = "_ZN4llvm3sys7Process18UseANSIEscapeCodesEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process18UseANSIEscapeCodesEb")
  //</editor-fold>
  public static void UseANSIEscapeCodes(boolean $Prm0) {
    // No effect.
  }

  
  /// Whether changing colors requires the output to be flushed.
  /// This is needed on systems that don't support escape sequences for
  /// changing colors.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::ColorNeedsFlush">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 409,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 401,
   FQN = "llvm::sys::Process::ColorNeedsFlush", NM = "_ZN4llvm3sys7Process15ColorNeedsFlushEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process15ColorNeedsFlushEv")
  //</editor-fold>
  public static boolean ColorNeedsFlush() {
    // No, we use ANSI escape sequences.
    return false;
  }

  
  /// This function returns the colorcode escape sequences.
  /// If ColorNeedsFlush() is true then this function will change the colors
  /// and return an empty escape sequence. In that case it is the
  /// responsibility of the client to flush the output stream prior to
  /// calling this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::OutputColor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 414,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 406,
   FQN = "llvm::sys::Process::OutputColor", NM = "_ZN4llvm3sys7Process11OutputColorEcbb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process11OutputColorEcbb")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ OutputColor(/*char*/int code, boolean bold, boolean bg) {
    return colorcodes[bg ? 1 : 0][bold ? 1 : 0][code & 7];
  }

  
  /// Same as OutputColor, but only enables the bold attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::OutputBold">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 418,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 410,
   FQN = "llvm::sys::Process::OutputBold", NM = "_ZN4llvm3sys7Process10OutputBoldEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process10OutputBoldEb")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ OutputBold(boolean bg) {
    return $("\033[1m");
  }

  
  /// This function returns the escape sequence to reverse forground and
  /// background colors.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::OutputReverse">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 422,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 414,
   FQN = "llvm::sys::Process::OutputReverse", NM = "_ZN4llvm3sys7Process13OutputReverseEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process13OutputReverseEv")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ OutputReverse() {
    return $("\033[7m");
  }

  
  /// Resets the terminals colors, or returns an escape sequence to do so.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::ResetColor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 426,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 418,
   FQN = "llvm::sys::Process::ResetColor", NM = "_ZN4llvm3sys7Process10ResetColorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process10ResetColorEv")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ResetColor() {
    return $("\033[0m");
  }

  
  // JAVA: hide this inside srand/rand functions in std.
  private static final Random randomGenerator = new Random();
  
  /// Get the result of a process wide random number generator. The
  /// generator will be automatically seeded in non-deterministic fashion.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Process::GetRandomNumber">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 455,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 442,
   FQN = "llvm::sys::Process::GetRandomNumber", NM = "_ZN4llvm3sys7Process15GetRandomNumberEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN4llvm3sys7Process15GetRandomNumberEv")
  //</editor-fold>
  public static /*uint*/int GetRandomNumber() {
    return randomGenerator.nextInt(RAND_MAX);
  }

  
  public String toString() {
    return ""; // NOI18N
  }
}
