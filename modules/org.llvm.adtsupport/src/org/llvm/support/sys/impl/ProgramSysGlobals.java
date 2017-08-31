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

import java.util.logging.Level;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.impl.ProgramStatics.Execute;
import org.llvm.support.spi.ExecuteProgramProvider;
import org.llvm.support.sys.*;
import org.openide.util.Lookup;


//<editor-fold defaultstate="collapsed" desc="static type ProgramSysGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sysL16EnvPathSeparatorE;_ZN4llvm3sys17findProgramByNameENS_9StringRefENS_8ArrayRefIS1_EE;_ZN4llvm3sys19ChangeStdinToBinaryEv;_ZN4llvm3sys20ChangeStdoutToBinaryEv;_ZN4llvm3sys14ExecuteAndWaitENS_9StringRefEPPKcS4_PPKS1_jjPSsPb;_ZN4llvm3sys13ExecuteNoWaitENS_9StringRefEPPKcS4_PPKS1_jPSsPb;_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE;_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE;_ZN4llvm3sys4WaitERKNS0_11ProcessInfoEjbPSs; -static-type=ProgramSysGlobals")
//</editor-fold>
public final class ProgramSysGlobals {

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::EnvPathSeparator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", line = 29,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", old_line = 28,
   FQN = "llvm::sys::EnvPathSeparator", NM = "_ZN4llvm3sysL16EnvPathSeparatorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sysL16EnvPathSeparatorE")
  //</editor-fold>
  public static /*const*//*char*/byte EnvPathSeparator = $(':');

  /// \brief Find the first executable file \p Name in \p Paths.
  ///
  /// This does not perform hashing as a shell would but instead stats each PATH
  /// entry individually so should generally be avoided. Core LLVM library
  /// functions and options should instead require fully specified paths.
  ///
  /// \param Name name of the executable to find. If it contains any system
  ///   slashes, it will be returned as is.
  /// \param Paths optional list of paths to search for \p Name. If empty it
  ///   will use the system PATH environment instead.
  ///
  /// \returns The fully qualified path to the first \p Name in \p Paths if it
  ///   exists. \p Name if \p Name has slashes in it. Otherwise an error.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::findProgramByName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 71,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 58,
   FQN = "llvm::sys::findProgramByName", NM = "_ZN4llvm3sys17findProgramByNameENS_9StringRefENS_8ArrayRefIS1_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys17findProgramByNameENS_9StringRefENS_8ArrayRefIS1_EE")
  //</editor-fold>
  public static ErrorOr<std.string> findProgramByName(StringRef Name) {
    return findProgramByName(Name, 
                   new ArrayRef<StringRef>());
  }
  public static ErrorOr<std.string> findProgramByName(StringRef Name, 
                   ArrayRef<StringRef> Paths/*= ArrayRef<StringRef>()*/) {
    SmallVector<StringRef> EnvironmentPaths = null;
    try {
      assert (!Name.empty()) : "Must have a name!";
      // Use the given path verbatim if it contains any slashes; this matches
      // the behavior of sh(1) and friends.
      if (Name.find($('/')) != StringRef.npos) {
        return new ErrorOr<std.string>(new std.string(Name.$string()));
      }

      EnvironmentPaths/*J*/= new SmallVector<StringRef>(16, new StringRef());
      if (Paths.empty()) {
        {
          /*const*/char$ptr/*char P*/ PathEnv = $tryClone(std.getenv($("PATH")));
          if ((PathEnv != null)) {
            SplitString(new StringRef(PathEnv), EnvironmentPaths, new StringRef($(":")));
            Paths.$assign(new ArrayRef<StringRef>(EnvironmentPaths));
          }
        }
      }

      for (StringRef Path : Paths) {
        SmallString/*128*/ FilePath = null;
        try {
          if (Path.empty()) {
            continue;
          }

          // Check to see if this first directory contains the executable...
          FilePath/*J*/= new SmallString/*128*/(Path, 128);
          path.append(FilePath, Name);
          if (fs.can_execute(new Twine(FilePath.c_str()))) {
            return new ErrorOr<std.string>(new std.string(FilePath.str().$string())); // Found the executable!
          }
        } finally {
          if (FilePath != null) { FilePath.$destroy(); }
        }
      }
      return new ErrorOr<std.string>(std.errc.no_such_file_or_directory);
    } finally {
      if (EnvironmentPaths != null) { EnvironmentPaths.$destroy(); }
    }
  }


  // These functions change the specified standard stream (stdin or stdout) to
  // binary mode. They return errc::success if the specified stream
  // was changed. Otherwise a platform dependent error is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ChangeStdinToBinary">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 422,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 416,
   FQN = "llvm::sys::ChangeStdinToBinary", NM = "_ZN4llvm3sys19ChangeStdinToBinaryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys19ChangeStdinToBinaryEv")
  //</editor-fold>
  public static std.error_code ChangeStdinToBinary() {
    // Do nothing, as Unix doesn't differentiate between text and binary.
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ChangeStdoutToBinary">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 427,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 421,
   FQN = "llvm::sys::ChangeStdoutToBinary", NM = "_ZN4llvm3sys20ChangeStdoutToBinaryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys20ChangeStdoutToBinaryEv")
  //</editor-fold>
  public static std.error_code ChangeStdoutToBinary() {
    // Do nothing, as Unix doesn't differentiate between text and binary.
    return new std.error_code();
  }


  /// This function executes the program using the arguments provided.  The
  /// invoked program will inherit the stdin, stdout, and stderr file
  /// descriptors, the environment and other configuration settings of the
  /// invoking program.
  /// This function waits for the program to finish, so should be avoided in
  /// library functions that aren't expected to block. Consider using
  /// ExecuteNoWait() instead.
  /// @returns an integer result code indicating the status of the program.
  /// A zero or positive value indicates the result code of the program.
  /// -1 indicates failure to execute
  /// -2 indicates a crash during execution or timeout
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ExecuteAndWait">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Program.cpp", line = 30,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Program.cpp", old_line = 29,
   FQN = "llvm::sys::ExecuteAndWait", NM = "_ZN4llvm3sys14ExecuteAndWaitENS_9StringRefEPPKcS4_PPKS1_jjPSsPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys14ExecuteAndWaitENS_9StringRefEPPKcS4_PPKS1_jjPSsPb")
  //</editor-fold>
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args) {
    return ExecuteAndWait(Program, args, (/*const*/type$ptr<char$ptr>/*char PP*/ )null, 
                (/*const*/ type$ptr<StringRef> /*P*/ /*P*/ )null, 0, 
                0, (std.string/*P*/ )null, 
                (bool$ptr/*bool P*/ )null);
  }
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/) {
    return ExecuteAndWait(Program, args, envp, 
                (/*const*/ type$ptr<StringRef> /*P*/ /*P*/ )null, 0, 
                0, (std.string/*P*/ )null, 
                (bool$ptr/*bool P*/ )null);
  }
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
                /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/) {
    return ExecuteAndWait(Program, args, envp, 
                redirects, 0, 
                0, (std.string/*P*/ )null, 
                (bool$ptr/*bool P*/ )null);
  }
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
                /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/) {
    return ExecuteAndWait(Program, args, envp, 
                redirects, secondsToWait, 
                0, (std.string/*P*/ )null, 
                (bool$ptr/*bool P*/ )null);
  }
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
                /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/, 
                /*uint*/int memoryLimit/*= 0*/) {
    return ExecuteAndWait(Program, args, envp, 
                redirects, secondsToWait, 
                memoryLimit, (std.string/*P*/ )null, 
                (bool$ptr/*bool P*/ )null);
  }
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
                /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/, 
                /*uint*/int memoryLimit/*= 0*/, std.string/*P*/ ErrMsg/*= null*/) {
    return ExecuteAndWait(Program, args, envp, 
                redirects, secondsToWait, 
                memoryLimit, ErrMsg, 
                (bool$ptr/*bool P*/ )null);
  }
  public static int ExecuteAndWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, 
                /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, /*uint*/int secondsToWait/*= 0*/, 
                /*uint*/int memoryLimit/*= 0*/, std.string/*P*/ ErrMsg/*= null*/, 
                bool$ptr/*bool P*/ ExecutionFailed/*= null*/) {
    try {
      ProcessInfo PI/*J*/= new ProcessInfo();
      if (Execute(PI, Program, args, envp, redirects, memoryLimit, ErrMsg)) {
        if ((ExecutionFailed != null)) {
          ExecutionFailed.$set(false);
        }
        ProcessInfo Result = Wait(PI, secondsToWait, secondsToWait == 0, ErrMsg);
        return Result.ReturnCode;
      }
      if ((ExecutionFailed != null)) {
        ExecutionFailed.$set(true);
      }
    } catch (Throwable thr) {
      // report once and register reason
      NativeTrace.printStackTraceOnce(thr, Level.SEVERE, true);
    }
    return -1;
  }


  /// Similar to ExecuteAndWait, but returns immediately.
  /// @returns The \see ProcessInfo of the newly launced process.
  /// \note On Microsoft Windows systems, users will need to either call \see
  /// Wait until the process finished execution or win32 CloseHandle() API on
  /// ProcessInfo.ProcessHandle to avoid memory leaks.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ExecuteNoWait">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Program.cpp", line = 49,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Program.cpp", old_line = 48,
   FQN = "llvm::sys::ExecuteNoWait", NM = "_ZN4llvm3sys13ExecuteNoWaitENS_9StringRefEPPKcS4_PPKS1_jPSsPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys13ExecuteNoWaitENS_9StringRefEPPKcS4_PPKS1_jPSsPb")
  //</editor-fold>
  public static ProcessInfo ExecuteNoWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args) throws Throwable {
    return ExecuteNoWait(Program, args, 
               (/*const*/type$ptr<char$ptr>/*char PP*/ )null, (/*const*/ type$ptr<StringRef> /*P*/ /*P*/ )null, 
               0, (std.string/*P*/ )null, 
               (bool$ptr/*bool P*/ )null);
  }
  public static ProcessInfo ExecuteNoWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
               /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/) throws Throwable {
    return ExecuteNoWait(Program, args, 
               envp, (/*const*/ type$ptr<StringRef> /*P*/ /*P*/ )null, 
               0, (std.string/*P*/ )null, 
               (bool$ptr/*bool P*/ )null);
  }
  public static ProcessInfo ExecuteNoWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
               /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/) throws Throwable {
    return ExecuteNoWait(Program, args, 
               envp, redirects, 
               0, (std.string/*P*/ )null, 
               (bool$ptr/*bool P*/ )null);
  }
  public static ProcessInfo ExecuteNoWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
               /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, 
               /*uint*/int memoryLimit/*= 0*/) throws Throwable {
    return ExecuteNoWait(Program, args, 
               envp, redirects, 
               memoryLimit, (std.string/*P*/ )null, 
               (bool$ptr/*bool P*/ )null);
  }
  public static ProcessInfo ExecuteNoWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
               /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, 
               /*uint*/int memoryLimit/*= 0*/, std.string/*P*/ ErrMsg/*= null*/) throws Throwable {
    return ExecuteNoWait(Program, args, 
               envp, redirects, 
               memoryLimit, ErrMsg, 
               (bool$ptr/*bool P*/ )null);
  }
  public static ProcessInfo ExecuteNoWait(StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
               /*const*/type$ptr<char$ptr>/*char PP*/ envp/*= null*/, /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects/*= null*/, 
               /*uint*/int memoryLimit/*= 0*/, std.string/*P*/ ErrMsg/*= null*/, 
               bool$ptr/*bool P*/ ExecutionFailed/*= null*/) throws Throwable {
    ProcessInfo PI/*J*/= new ProcessInfo();
    if ((ExecutionFailed != null)) {
      ExecutionFailed.$set(false);
    }
    if (!Execute(PI, Program, args, envp, redirects, memoryLimit, ErrMsg)) {
      if ((ExecutionFailed != null)) {
        ExecutionFailed.$set(true);
      }
    }
    return PI;
  }


  /// Return true if the given arguments fit within system-specific
  /// argument length limits.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::argumentsFitWithinSystemLimits">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 443,
   FQN = "llvm::sys::argumentsFitWithinSystemLimits", NM = "_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE")
  //</editor-fold>
  public static boolean argumentsFitWithinSystemLimits(ArrayRef</*const*/char$ptr/*char P*/ > Args) {
    ExecuteProgramProvider provider = findProvider();
    return provider.argumentsFitWithinSystemLimits(Args);
  }


  /// Saves the UTF8-encoded \p contents string into the file \p FileName
  /// using a specific encoding.
  ///
  /// This write file function adds the possibility to choose which encoding
  /// to use when writing a text file. On Windows, this is important when
  /// writing files with internationalization support with an encoding that is
  /// different from the one used in LLVM (UTF-8). We use this when writing
  /// response files, since GCC tools on MinGW only understand legacy code
  /// pages, and VisualStudio tools only understand UTF-16.
  /// For UNIX, using different encodings is silently ignored, since all tools
  /// work well with UTF-8.
  /// This function assumes that you only use UTF-8 *text* data and will convert
  /// it to your desired encoding before writing to the file.
  ///
  /// FIXME: We use EM_CurrentCodePage to write response files for GNU tools in
  /// a MinGW/MinGW-w64 environment, which has serious flaws but currently is
  /// our best shot to make gcc/ld understand international characters. This
  /// should be changed as soon as binutils fix this to support UTF16 on mingw.
  ///
  /// \returns non-zero error_code if failed
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::writeFileWithEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 432,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 426,
   FQN = "llvm::sys::writeFileWithEncoding", NM = "_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys21writeFileWithEncodingENS_9StringRefES1_NS0_21WindowsEncodingMethodE")
  //</editor-fold>
  public static std.error_code writeFileWithEncoding(StringRef FileName, StringRef Contents) {
    return writeFileWithEncoding(FileName, Contents, 
                       WindowsEncodingMethod.WEM_UTF8);
  }
  public static std.error_code writeFileWithEncoding(StringRef FileName, StringRef Contents, 
                       WindowsEncodingMethod Encoding/*= WEM_UTF8*/) {
    ExecuteProgramProvider provider = findProvider();
    return provider.writeFileWithEncoding(FileName, Contents, Encoding);
  }


  /// This function waits for the process specified by \p PI to finish.
  /// \returns A \see ProcessInfo struct with Pid set to:
  /// \li The process id of the child process if the child process has changed
  /// state.
  /// \li 0 if the child process has not changed state.
  /// \note Users of this function should always check the ReturnCode member of
  /// the \see ProcessInfo returned from this function.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::Wait">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 324,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 311,
   FQN = "llvm::sys::Wait", NM = "_ZN4llvm3sys4WaitERKNS0_11ProcessInfoEjbPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys4WaitERKNS0_11ProcessInfoEjbPSs")
  //</editor-fold>
  public static ProcessInfo Wait(/*const*/ ProcessInfo /*&*/ PI, /*uint*/int SecondsToWait, 
      boolean WaitUntilTerminates) {
    return Wait(PI, SecondsToWait, 
      WaitUntilTerminates, (std.string/*P*/ )null);
  }
  public static ProcessInfo Wait(/*const*/ ProcessInfo /*&*/ PI, /*uint*/int SecondsToWait, 
      boolean WaitUntilTerminates, std.string/*P*/ ErrMsg/*= null*/) {
    ExecuteProgramProvider provider = findProvider();
    return provider.Wait(PI, SecondsToWait, WaitUntilTerminates, ErrMsg);
  }

  private static ExecuteProgramProvider findProvider() {
    for (ExecuteProgramProvider p : Lookup.getDefault().lookupAll(ExecuteProgramProvider.class)) {
      return p;
    }
    return null;
  }

} // END OF class ProgramSysGlobals
