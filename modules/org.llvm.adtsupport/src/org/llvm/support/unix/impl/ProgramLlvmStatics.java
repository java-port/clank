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
package org.llvm.support.unix.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import org.clank.java.spawn.posix_spawn_file_actions_t;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.llvm.support.unix.impl.UnixStatics.MakeErrMsg;


//<editor-fold defaultstate="collapsed" desc="static type ProgramLlvmStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.unix.impl.ProgramLlvmStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL10RedirectIOEPKNS_9StringRefEiPNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvmL13RedirectIO_PSEPKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEiPS5_P26posix_spawn_file_actions_t;_ZN4llvmL14TimeOutHandlerEi;_ZN4llvmL15SetMemoryLimitsEj; -static-type=ProgramLlvmStatics -package=org.llvm.support.unix.impl")
//</editor-fold>
public final class ProgramLlvmStatics {

//<editor-fold defaultstate="collapsed" desc="llvm::RedirectIO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 99,
 FQN="llvm::RedirectIO", NM="_ZN4llvmL10RedirectIOEPKNS_9StringRefEiPSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL10RedirectIOEPKNS_9StringRefEiPSs")
//</editor-fold>
public static boolean RedirectIO(/*const*/ StringRef /*P*/ Path, int FD, std.string/*P*/ ErrMsg) {
  if (!(Path != null)) { // Noop
    return false;
  }
  std.string File/*J*/= new std.string();
  if (Path.empty()) {
    // Redirect empty paths to /dev/null
    File.$assign_T$C$P(/*KEEP_STR*/"/dev/null");
  } else {
    File.$assignMove($Deref(Path).$string());
  }
  
  // Open the file
  int InFD = open(File.c_str(), FD == 0 ? O_RDONLY : O_WRONLY|O_CREAT, 0666);
  if (InFD == -1) {
    MakeErrMsg(ErrMsg, $add_string_T$C$P($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"Cannot open file '", File), /*KEEP_STR*/"' for "), 
            (FD == 0 ? $("input") : $("output"))));
    return true;
  }
  
  // Install it as the requested FD
  if (dup2(InFD, FD) == -1) {
    MakeErrMsg(ErrMsg, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Cannot dup2"));
    close(InFD);
    return true;
  }
  close(InFD); // Close the original FD
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::RedirectIO_PS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 128,
 FQN="llvm::RedirectIO_PS", NM="_ZN4llvmL13RedirectIO_PSEPKSsiPSsP26posix_spawn_file_actions_t",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL13RedirectIO_PSEPKSsiPSsP26posix_spawn_file_actions_t")
//</editor-fold>
public static boolean RedirectIO_PS(/*const*/std.string/*P*/ Path, int FD, std.string/*P*/ ErrMsg, 
              posix_spawn_file_actions_t /*P*/ FileActions) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::TimeOutHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 147,
 FQN="llvm::TimeOutHandler", NM="_ZN4llvmL14TimeOutHandlerEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL14TimeOutHandlerEi")
//</editor-fold>
public static void TimeOutHandler(int Sig) {
}

//<editor-fold defaultstate="collapsed" desc="llvm::SetMemoryLimits">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 150,
 FQN="llvm::SetMemoryLimits", NM="_ZN4llvmL15SetMemoryLimitsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvmL15SetMemoryLimitsEj")
//</editor-fold>
public static void SetMemoryLimits(/*uint*/int size) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ProgramLlvmStatics
