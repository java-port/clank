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
package org.clang.driver.impl;

import org.clang.driver.toolchains.impl.Generic_GCC;
import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.support.sys.*;;


//<editor-fold defaultstate="collapsed" desc="static type MinGWToolChainStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZN12_GLOBAL__N_114findGccVersionEN4llvm9StringRefERSsS2_; -static-type=MinGWToolChainStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class MinGWToolChainStatics {

// Simplified from Generic_GCC::GCCInstallationDetector::ScanLibDirForGCCTriple.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::findGccVersion">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 25,
 FQN="(anonymous namespace)::findGccVersion", NM="_ZN12_GLOBAL__N_114findGccVersionEN4llvm9StringRefERSsS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZN12_GLOBAL__N_114findGccVersionEN4llvm9StringRefERSsS2_")
//</editor-fold>
public static boolean findGccVersion(StringRef LibDir, std.string/*&*/ GccLibDir, 
              std.string/*&*/ Ver) {
  Generic_GCC.GCCVersion Version = null;
  try {
    Version = Generic_GCC.GCCVersion.Parse(new StringRef(/*KEEP_STR*/"0.0.0"));
    std.error_code EC/*J*/= new std.error_code();
    fs.directory_iterator LI = null;
    fs.directory_iterator LE = null;
    try {
      for (LI/*J*/= new fs.directory_iterator(new Twine(LibDir), EC), LE/*J*/= new fs.directory_iterator(); !EC.$bool() && LI.$noteq(LE);
           LI.$assign(LI.increment(EC))) {
        Generic_GCC.GCCVersion CandidateVersion = null;
        try {
          StringRef VersionText = path.filename(new StringRef(LI.$arrow().getPath()));
          CandidateVersion = Generic_GCC.GCCVersion.Parse(new StringRef(VersionText));
          if (CandidateVersion.Major == -1) {
            continue;
          }
          if (CandidateVersion.$lesseq(Version)) {
            continue;
          }
          Ver.$assignMove(VersionText.$string());
          GccLibDir.$assign(LI.$arrow().getPath());
        } finally {
          if (CandidateVersion != null) { CandidateVersion.$destroy(); }
        }
      }
    } finally {
      if (LE != null) { LE.$destroy(); }
      if (LI != null) { LI.$destroy(); }
    }
    return (Ver.size() != 0);
  } finally {
    if (Version != null) { Version.$destroy(); }
  }
}

} // END OF class MinGWToolChainStatics
