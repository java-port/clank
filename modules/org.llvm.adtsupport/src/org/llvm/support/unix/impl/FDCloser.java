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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FDCloser">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 192,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 184,
 FQN = "(anonymous namespace)::FDCloser", NM = "_ZN12_GLOBAL__N_18FDCloserE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN12_GLOBAL__N_18FDCloserE")
//</editor-fold>
public class FDCloser implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FDCloser::FDCloser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 194,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 186,
   FQN = "(anonymous namespace)::FDCloser::FDCloser", NM = "_ZN12_GLOBAL__N_18FDCloserC1ERi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN12_GLOBAL__N_18FDCloserC1ERi")
  //</editor-fold>
  public FDCloser(int$ref/*int &*/ FD) {
    /* : FD(FD), KeepOpen(false)*/ 
    //START JInit
    this.FD = FD;
    this.KeepOpen = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FDCloser::keepOpen">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 195,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 187,
   FQN = "(anonymous namespace)::FDCloser::keepOpen", NM = "_ZN12_GLOBAL__N_18FDCloser8keepOpenEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN12_GLOBAL__N_18FDCloser8keepOpenEv")
  //</editor-fold>
  public void keepOpen() {
    KeepOpen = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FDCloser::~FDCloser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 196,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 188,
   FQN = "(anonymous namespace)::FDCloser::~FDCloser", NM = "_ZN12_GLOBAL__N_18FDCloserD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN12_GLOBAL__N_18FDCloserD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!KeepOpen && FD.$deref() >= 0) {
      /*::*/close(FD.$deref());
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FDCloser::FDCloser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 202,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 194,
   FQN = "(anonymous namespace)::FDCloser::FDCloser", NM = "_ZN12_GLOBAL__N_18FDCloserC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN12_GLOBAL__N_18FDCloserC1ERKS0_")
  //</editor-fold>
  private FDCloser(/*const*/ FDCloser /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FDCloser::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", line = 203,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Process.inc", old_line = 195,
   FQN = "(anonymous namespace)::FDCloser::operator=", NM = "_ZN12_GLOBAL__N_18FDCloseraSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Process.cpp -nm=_ZN12_GLOBAL__N_18FDCloseraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ FDCloser /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private int$ref/*int &*/ FD;
  private boolean KeepOpen;
  
  public String toString() {
    return "" + "FD=" + FD // NOI18N
              + ", KeepOpen=" + KeepOpen; // NOI18N
  }
}
