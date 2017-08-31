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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.config.llvm_config;


//<editor-fold defaultstate="collapsed" desc="static type HostStatics">
@Converted(kind = Converted.Kind.AUTO, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL12getOSVersionv; -static-type=HostStatics")
//</editor-fold>
public final class HostStatics {

//<editor-fold defaultstate="collapsed" desc="getOSVersion">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Host.inc", line = 28,
 FQN = "getOSVersion", NM = "_ZL12getOSVersionv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL12getOSVersionv")
//</editor-fold>
public static std.string getOSVersion() {
   utsname info/*J*/= new  utsname();
  if ((uname($AddrOf(info)) != 0)) {
    return new std.string("");
  }
  
  return new std.string(info.release);
}

//<editor-fold defaultstate="collapsed" desc="llvm::sys::getDefaultTargetTriple">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Host.inc", line = 37,
 FQN = "llvm::sys::getDefaultTargetTriple", NM = "_ZN4llvm3sys22getDefaultTargetTripleEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys22getDefaultTargetTripleEv")
//</editor-fold>
public static std.string getDefaultTargetTriple() {
  std.string Triple = null;
  try {
    StringRef TargetTripleString/*J*/= new StringRef(llvm_config.LLVM_HOST_TRIPLE());
    std.pair<StringRef, StringRef> ArchSplit = TargetTripleString.split('-');
    
    // Normalize the arch, since the target triple may not actually match the target.
    std.string Arch = ArchSplit.first.$string();
    
    Triple/*J*/= new std.string(Arch);
    Triple.$addassign('-');
    $addassign_str_StringRef(Triple, ArchSplit.second);
    
    // Force i<N>86 to i386.
    if (Triple.$at(0) == $('i') && (isdigit(Triple.$at(1)) != 0)
       && Triple.$at(2) == $('8') && Triple.$at(3) == $('6')) {
      Triple.$set(1, $('3'));
    }
    
    // On darwin, we want to update the version to match that of the
    // target.
    /*size_t*/int DarwinDashIdx = Triple.find("-darwin");
    if (DarwinDashIdx != std.string.npos) {
      Triple.resize(DarwinDashIdx + strlen("-darwin"));
      Triple.$addassign(getOSVersion());
    }
    
    return Triple;
  } finally {
    if (Triple != null) { Triple.$destroy(); }
  }
}
} // END OF class HostStatics
