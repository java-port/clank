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

import org.llvm.support.sys.Process;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native.ComparableLower;
import org.clank.support.Native.NativePOD;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.support.sys.TimeValue;
import static org.llvm.support.impl.TimerStatics.*;

//<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 26,
 FQN="llvm::TimeRecord", NM="_ZN4llvm10TimeRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordE")
//</editor-fold>
public class TimeRecord implements NativePOD<TimeRecord>, ComparableLower {
  private double WallTime; // Wall clock time elapsed in seconds
  private double UserTime; // User time elapsed
  private double SystemTime; // System time elapsed
  private int MemUsed; // Memory allocated (in bytes)
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::TimeRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 32,
   FQN="llvm::TimeRecord::TimeRecord", NM="_ZN4llvm10TimeRecordC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordC1Ev")
  //</editor-fold>
  public TimeRecord() {
    // : WallTime(0), UserTime(0), SystemTime(0), MemUsed(0) 
    //START JInit
    this.WallTime = 0;
    this.UserTime = 0;
    this.SystemTime = 0;
    this.MemUsed = 0;
    //END JInit
  }

  
  /// getCurrentTime - Get the current time and memory usage.  If Start is true
  /// we get the memory usage before the time, otherwise we get time before
  /// memory usage.  This matters if the time to get the memory usage is
  /// significant and shouldn't be counted as part of a duration.
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::getCurrentTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 120,
   FQN="llvm::TimeRecord::getCurrentTime", NM="_ZN4llvm10TimeRecord14getCurrentTimeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecord14getCurrentTimeEb")
  //</editor-fold>
  public static TimeRecord getCurrentTime() {
    return getCurrentTime(true);
  }
  public static TimeRecord getCurrentTime(boolean Start/*= true*/) {
    TimeRecord Result/*J*/= new TimeRecord();
    TimeValue now/*J*/= new TimeValue(0, 0), user/*J*/= new TimeValue(0, 0), sys/*J*/= new TimeValue(0, 0);
    if (Start) {
      Result.MemUsed = getMemUsage();
      Process.GetTimeUsage(now, user, sys);
    } else {
      Process.GetTimeUsage(now, user, sys);
      Result.MemUsed = getMemUsage();
    }
    
    Result.WallTime = now.seconds() + now.microseconds() / 1.0E+6;
    Result.UserTime = user.seconds() + user.microseconds() / 1.0E+6;
    Result.SystemTime = sys.seconds() + sys.microseconds() / 1.0E+6;
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::getProcessTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 40,
   FQN="llvm::TimeRecord::getProcessTime", NM="_ZNK4llvm10TimeRecord14getProcessTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecord14getProcessTimeEv")
  //</editor-fold>
  public double getProcessTime() /*const*/ {
    return UserTime + SystemTime;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::getUserTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 41,
   FQN="llvm::TimeRecord::getUserTime", NM="_ZNK4llvm10TimeRecord11getUserTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecord11getUserTimeEv")
  //</editor-fold>
  public double getUserTime() /*const*/ {
    return UserTime;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::getSystemTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 42,
   FQN="llvm::TimeRecord::getSystemTime", NM="_ZNK4llvm10TimeRecord13getSystemTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecord13getSystemTimeEv")
  //</editor-fold>
  public double getSystemTime() /*const*/ {
    return SystemTime;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::getWallTime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 43,
   FQN="llvm::TimeRecord::getWallTime", NM="_ZNK4llvm10TimeRecord11getWallTimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecord11getWallTimeEv")
  //</editor-fold>
  public double getWallTime() /*const*/ {
    return WallTime;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::getMemUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 44,
   FQN="llvm::TimeRecord::getMemUsed", NM="_ZNK4llvm10TimeRecord10getMemUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecord10getMemUsedEv")
  //</editor-fold>
  public int getMemUsed() /*const*/ {
    return MemUsed;
  }

  
  // operator< - Allow sorting.
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 47,
   FQN="llvm::TimeRecord::operator<", NM="_ZNK4llvm10TimeRecordltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecordltERKS0_")
  //</editor-fold>
  public boolean $less(/*const*/ TimeRecord /*&*/ T) /*const*/ {
    // Sort by Wall Time elapsed, as it is the only thing really accurate
    return WallTime < T.WallTime;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::operator+=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 52,
   FQN="llvm::TimeRecord::operator+=", NM="_ZN4llvm10TimeRecordpLERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordpLERKS0_")
  //</editor-fold>
  public void $addassign(/*const*/ TimeRecord /*&*/ RHS) {
    WallTime += RHS.WallTime;
    UserTime += RHS.UserTime;
    SystemTime += RHS.SystemTime;
    MemUsed += RHS.MemUsed;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 58,
   FQN="llvm::TimeRecord::operator-=", NM="_ZN4llvm10TimeRecordmIERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordmIERKS0_")
  //</editor-fold>
  public void $minusassign(/*const*/ TimeRecord /*&*/ RHS) {
    WallTime -= RHS.WallTime;
    UserTime -= RHS.UserTime;
    SystemTime -= RHS.SystemTime;
    MemUsed -= RHS.MemUsed;
  }

  
  /// Print the current time record to \p OS, with a breakdown showing
  /// contributions to the \p Total time record.
  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 163,
   FQN="llvm::TimeRecord::print", NM="_ZNK4llvm10TimeRecord5printERKS0_RNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZNK4llvm10TimeRecord5printERKS0_RNS_11raw_ostreamE")
  //</editor-fold>
  public void print(/*const*/ TimeRecord /*&*/ Total, raw_ostream /*&*/ OS) /*const*/ {
    if ((Total.getUserTime() != 0)) {
      printVal(getUserTime(), Total.getUserTime(), OS);
    }
    if ((Total.getSystemTime() != 0)) {
      printVal(getSystemTime(), Total.getSystemTime(), OS);
    }
    if ((Total.getProcessTime() != 0)) {
      printVal(getProcessTime(), Total.getProcessTime(), OS);
    }
    printVal(getWallTime(), Total.getWallTime(), OS);
    
    OS.$out(/*KEEP_STR*/"  ");
    if ((Total.getMemUsed() != 0)) {
      OS.$out(format($("%9lld  "), (long/*int64_t*/)getMemUsed()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::TimeRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 26,
   FQN="llvm::TimeRecord::TimeRecord", NM="_ZN4llvm10TimeRecordC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TimeRecord(/*const*/ TimeRecord /*&*/ $Prm0) {
    // : WallTime(.WallTime), UserTime(.UserTime), SystemTime(.SystemTime), MemUsed(.MemUsed) 
    //START JInit
    this.WallTime = $Prm0.WallTime;
    this.UserTime = $Prm0.UserTime;
    this.SystemTime = $Prm0.SystemTime;
    this.MemUsed = $Prm0.MemUsed;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::TimeRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 26,
   FQN="llvm::TimeRecord::TimeRecord", NM="_ZN4llvm10TimeRecordC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordC1EOS0_")
  //</editor-fold>
  public /*inline*/ TimeRecord(JD$Move _dparam, TimeRecord /*&&*/$Prm0) {
    // : WallTime(static_cast<TimeRecord &&>().WallTime), UserTime(static_cast<TimeRecord &&>().UserTime), SystemTime(static_cast<TimeRecord &&>().SystemTime), MemUsed(static_cast<TimeRecord &&>().MemUsed) 
    //START JInit
    this.WallTime = $Prm0.WallTime;
    this.UserTime = $Prm0.UserTime;
    this.SystemTime = $Prm0.SystemTime;
    this.MemUsed = $Prm0.MemUsed;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 26,
   FQN="llvm::TimeRecord::operator=", NM="_ZN4llvm10TimeRecordaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordaSERKS0_")
  //</editor-fold>
  public /*inline*/ TimeRecord /*&*/ $assign(/*const*/ TimeRecord /*&*/ $Prm0) {
    this.WallTime = $Prm0.WallTime;
    this.UserTime = $Prm0.UserTime;
    this.SystemTime = $Prm0.SystemTime;
    this.MemUsed = $Prm0.MemUsed;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimeRecord::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 26,
   FQN="llvm::TimeRecord::operator=", NM="_ZN4llvm10TimeRecordaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimeRecordaSEOS0_")
  //</editor-fold>
  public /*inline*/ TimeRecord /*&*/ $assignMove(TimeRecord /*&&*/$Prm0) {
    this.WallTime = $Prm0.WallTime;
    this.UserTime = $Prm0.UserTime;
    this.SystemTime = $Prm0.SystemTime;
    this.MemUsed = $Prm0.MemUsed;
    return /*Deref*/this;
  }

  @Override public TimeRecord clone() {
    return new TimeRecord(this);
  }

  @Override public boolean $less(Object obj) {
    return this.$less((TimeRecord)obj);
  }
  
  @Override public String toString() {
    return "" + "WallTime=" + WallTime // NOI18N
              + ", UserTime=" + UserTime // NOI18N
              + ", SystemTime=" + SystemTime // NOI18N
              + ", MemUsed=" + MemUsed; // NOI18N
  }
}
