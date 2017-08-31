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

/// @brief This struct encapsulates information about a process.

import org.clank.support.Converted;

//<editor-fold defaultstate="collapsed" desc="llvm::sys::ProcessInfo">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", line = 35,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", old_line = 34,
 FQN = "llvm::sys::ProcessInfo", NM = "_ZN4llvm3sys11ProcessInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys11ProcessInfoE")
//</editor-fold>
public class/*struct*/ ProcessInfo {
  /*typedef pid_t ProcessId*/;
  
  /// The process identifier.
  public long/*pid_t*/ Pid;
  
  /// The return code, set after execution.
  public int ReturnCode;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ProcessInfo::ProcessInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", line = 69,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Program.inc", old_line = 56,
   FQN = "llvm::sys::ProcessInfo::ProcessInfo", NM = "_ZN4llvm3sys11ProcessInfoC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys11ProcessInfoC1Ev")
  //</editor-fold>
  public ProcessInfo() {
    /* : Pid(0), ReturnCode(0)*/ 
    //START JInit
    this.Pid = 0;
    this.ReturnCode = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::ProcessInfo::ProcessInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", line = 35,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Program.h", old_line = 34,
   FQN = "llvm::sys::ProcessInfo::ProcessInfo", NM = "_ZN4llvm3sys11ProcessInfoC1EOS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm3sys11ProcessInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ ProcessInfo(/*const*/ProcessInfo /*&*/ $Prm0)/* throw()*/ {
    /* : Pid(.Pid), ReturnCode(.ReturnCode)*/ 
    //START JInit
    this.Pid = $Prm0.Pid;
    this.ReturnCode = $Prm0.ReturnCode;
    //END JInit
  }

}
