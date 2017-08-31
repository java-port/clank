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

package org.llvm.support.spi;

import java.io.FileInputStream;
import java.io.InputStream;
import org.clank.support.aliases.*;
import org.clank.java.std;
import org.clank.support.Converted;
import static org.clank.support.Native.$tryClone;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.support.sys.ProcessInfo;
import org.llvm.support.sys.WindowsEncodingMethod;

/**
 * 
 * @author vv159170
 */
public interface ExecuteProgramProvider {
  /// check if program can be executed by this provider
  public boolean canExecute(StringRef Program);
  
  //<editor-fold defaultstate="collapsed" desc="Execute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 181,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 168,
   FQN = "Execute", NM = "_ZL7ExecuteRN4llvm3sys11ProcessInfoENS_9StringRefEPPKcS6_PPKS3_jPSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZL7ExecuteRN4llvm3sys11ProcessInfoENS_9StringRefEPPKcS6_PPKS3_jPSs")
  //</editor-fold>
  public default boolean Execute(ProcessInfo /*&*/ PI, StringRef Program, /*const*/type$ptr<char$ptr>/*char PP*/ args, 
         /*const*/type$ptr<char$ptr>/*char PP*/ envp, /*const*/ type$ptr<StringRef> /*P*/ /*P*/ redirects, 
         /*uint*/int memoryLimit, std.string/*P*/ ErrMsg) throws Throwable {
    int argc = 0;
    type$ptr<char$ptr> argIter = $tryClone(args);
    while (argIter.$star() != null) {
      ++argc;
      argIter.$preInc();
    }
    assert canExecute(Program) : "not supported " + Program;
    assert argc > 1: "must be name of the program and null";
    assert args.$at(argc) == null : "must have null as the last element in arguments";
    // prepare possible redirect of input stream
    InputStream prevIn = null;
    String filePath = null;
    if (redirects != null && redirects.$at(0) != null) {
      filePath = redirects.$at(0).toJavaString();
    }
    try (InputStream newIn = (filePath == null) ? null : new FileInputStream(filePath)) {
      assert filePath == null || newIn != null;
      if (newIn != null) {
        prevIn = System.in;
        System.setIn(newIn);
      }        
      return ExecuteMain(argc, args);
    } finally {
      if (prevIn != null) {
        System.setIn(prevIn);
      }
    }    
  }
  
  public boolean ExecuteMain(int argc, /*const*/type$ptr<char$ptr>/*char PP*/ argv) throws Throwable;
  
  /// Return true if the given arguments fit within system-specific
  /// argument length limits.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::argumentsFitWithinSystemLimits">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 443,
   FQN = "llvm::sys::argumentsFitWithinSystemLimits", NM = "_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys30argumentsFitWithinSystemLimitsENS_8ArrayRefIPKcEE")
  //</editor-fold>
  public boolean argumentsFitWithinSystemLimits(ArrayRef</*const*/char$ptr/*char P*/ > Args);
  
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
  public std.error_code writeFileWithEncoding(StringRef FileName, StringRef Contents, 
                       WindowsEncodingMethod Encoding/*= WEM_UTF8*/);


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
  public ProcessInfo Wait(/*const*/ ProcessInfo /*&*/ PI, /*uint*/int SecondsToWait, 
      boolean WaitUntilTerminates, std.string/*P*/ ErrMsg/*= null*/);
}
