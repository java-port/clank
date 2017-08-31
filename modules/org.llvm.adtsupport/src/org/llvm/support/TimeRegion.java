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

package org.llvm.support;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.llvm.adt.java.ADTJavaDifferentiators.*;
import org.llvm.support.*;


/// The TimeRegion class is used as a helper class to call the startTimer() and
/// stopTimer() methods of the Timer class.  When the object is constructed, it
/// starts the timer specified as its argument.  When it is destroyed, it stops
/// the relevant timer.  This makes it easy to time a region of code.
///
//<editor-fold defaultstate="collapsed" desc="llvm::TimeRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 136,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 133,
 FQN="llvm::TimeRegion", NM="_ZN4llvm10TimeRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRegionE")
//</editor-fold>
public class TimeRegion implements Destructors.ClassWithDestructor {
  private Timer /*P*/ T;
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRegion::TimeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 138,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 135,
   FQN="llvm::TimeRegion::TimeRegion", NM="_ZN4llvm10TimeRegionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRegionC1ERKS0_")
  //</editor-fold>
  private TimeRegion(/*const*/ TimeRegion /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRegion::TimeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 138,
   FQN="llvm::TimeRegion::TimeRegion", NM="_ZN4llvm10TimeRegionC1ERNS_5TimerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRegionC1ERNS_5TimerE")
  //</editor-fold>
  public /*explicit*/ TimeRegion(JD$Timer _dparam, Timer /*&*/ t) {
    // : T(&t) 
    //START JInit
    this.T = $AddrOf(t);
    //END JInit
    T.startTimer();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRegion::TimeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 141,
   FQN="llvm::TimeRegion::TimeRegion", NM="_ZN4llvm10TimeRegionC1EPNS_5TimerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRegionC1EPNS_5TimerE")
  //</editor-fold>
  public /*explicit*/ TimeRegion(JD$Timer$P _dparam, Timer /*P*/ t) {
    // : T(t) 
    //START JInit
    this.T = t;
    //END JInit
    if ((T != null)) {
      T.startTimer();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRegion::~TimeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 144,
   FQN="llvm::TimeRegion::~TimeRegion", NM="_ZN4llvm10TimeRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRegionD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((T != null)) {
      T.stopTimer();
    }
  }

  
  @Override public String toString() {
    return "" + "T=" + T; // NOI18N
  }
}
