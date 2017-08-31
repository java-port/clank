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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.LlvmStatics.CreateInfoOutputFile;
import static org.llvm.support.impl.TimerStatics.*;
import org.llvm.support.sys.*;


/// The TimerGroup class is used to group together related timers into a single
/// report that is printed when the TimerGroup is destroyed.  It is illegal to
/// destroy a TimerGroup object before all of the Timers in it are gone.  A
/// TimerGroup can be specified for a newly created timer in its constructor.
///
//<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 169,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 166,
 FQN="llvm::TimerGroup", NM="_ZN4llvm10TimerGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroupE")
//</editor-fold>
public class TimerGroup implements Destructors.ClassWithDestructor {
  private std.string Name;
  private Timer /*P*/ FirstTimer; // First timer in the group.
  private std.vector<std.pairTypeType<TimeRecord, std.string>> TimersToPrint;
  
  private TimerGroup /*P*/ /*P*/ Prev;
  
  private TimerGroup /*P*/ Next; // Doubly linked list of TimerGroup's.
  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::TimerGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 172,
   FQN="llvm::TimerGroup::TimerGroup", NM="_ZN4llvm10TimerGroupC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroupC1ERKS0_")
  //</editor-fold>
  protected/*private*/ TimerGroup(final /*const*/ TimerGroup /*&*/ TG) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 173,
   FQN="llvm::TimerGroup::operator=", NM="_ZN4llvm10TimerGroupaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroupaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ TimerGroup /*&*/ TG) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::TimerGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*linked list*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 241,
   FQN="llvm::TimerGroup::TimerGroup", NM="_ZN4llvm10TimerGroupC1ENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroupC1ENS_9StringRefE")
  //</editor-fold>
  public TimerGroup(StringRef name) {
    // : Name(name.begin(), name.end()), FirstTimer(null), TimersToPrint() 
    //START JInit
    this.Name = new std.string(name.begin(), name.end());
    this.FirstTimer = null;
    this.TimersToPrint = new std.vector<std.pairTypeType<TimeRecord, std.string>>(new std.pairTypeType<TimeRecord, std.string>(new TimeRecord(), new std.string()));
    //END JInit
    SmartScopedLock/*true*/ L = null;
    try {
      
      // Add the group to TimerGroupList.
      L/*J*/= new SmartScopedLock/*true*/(true, TimerLock.$star());
      // JAVA: manually double-link
      if ((TimerGroupList != null)) {
        assert TimerGroupList.Prev == null;
        TimerGroupList.Prev = this;
      }
      this.Next = TimerGroupList;
      this.Prev = null;
      TimerGroupList = this;
    } finally {
      if (L != null) { L.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::~TimerGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*linked list*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 253,
   FQN="llvm::TimerGroup::~TimerGroup", NM="_ZN4llvm10TimerGroupD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroupD0Ev")
  //</editor-fold>
  public void $destroy() {
    SmartScopedLock/*true*/ L = null;
    try {
      // If the timer group is destroyed before the timers it owns, accumulate and
      // print the timing data.
      while ((FirstTimer != null)) {
        removeTimer($Deref(FirstTimer));
      }
      
      // Remove the group from the TimerGroupList.
      L/*J*/= new SmartScopedLock/*true*/(true, TimerLock.$star());
      // JAVA: manually support double-link
      if ((this.Next != null)) {
        assert this.Next.Prev == this;
        this.Next.Prev = this.Prev;
      }
      if (this.Prev != null) {
        assert this.Prev.Next == this;
        this.Prev.Next = this.Next;
      }
      if (TimerGroupList == this) {
        assert this.Prev == null;
        TimerGroupList = this.Next;
      }
      this.Next = null;
      this.Prev = null;
    } finally {
      if (L != null) { L.$destroy(); }
    }
    //START JDestroy
    TimersToPrint.$destroy();
    Name.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::setName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Timer.h", old_line = 179,
   FQN="llvm::TimerGroup::setName", NM="_ZN4llvm10TimerGroup7setNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroup7setNameENS_9StringRefE")
  //</editor-fold>
  public void setName(StringRef name) {
    Name.assign$T(name.begin(), name.end());
  }

  
  /// print - Print any started timers in this group and zero them.
  
  /// print - Print any started timers in this group and zero them.
  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::print">
  @Converted(kind = Converted.Kind.MANUAL/*emplace back Clone*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 351,
   FQN="llvm::TimerGroup::print", NM="_ZN4llvm10TimerGroup5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroup5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) {
    SmartScopedLock/*true*/ L = null;
    try {
      L/*J*/= new SmartScopedLock/*true*/(true, TimerLock.$star());
      
      // See if any of our timers were started, if so add them to TimersToPrint and
      // reset them.
      for (Timer /*P*/ T = FirstTimer; (T != null); T = T.Next) {
        if (!T.hasTriggered()) {
          continue;
        }
        TimersToPrint.emplace_back(new std.pairTypeType<TimeRecord, std.string>(Native.$Clone(T.Time), Native.$Clone(T.Name)));
        
        // Clear out the time.
        T.clear();
      }
      
      // If any timers were started, print the group.
      if (!TimersToPrint.empty()) {
        PrintQueuedTimers(OS);
      }
    } finally {
      if (L != null) { L.$destroy(); }
    }
  }

  
  /// printAll - This static method prints all timers and clears them all out.
  
  /// printAll - This static method prints all timers and clears them all out.
  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::printAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 370,
   FQN="llvm::TimerGroup::printAll", NM="_ZN4llvm10TimerGroup8printAllERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroup8printAllERNS_11raw_ostreamE")
  //</editor-fold>
  public static void printAll(final raw_ostream /*&*/ OS) {
    SmartScopedLock/*true*/ L = null;
    try {
      L/*J*/= new SmartScopedLock/*true*/(true, TimerLock.$star());
      
      for (TimerGroup /*P*/ TG = TimerGroupList; (TG != null); TG = TG.Next)  {
        TG.print(OS);
      }
    } finally {
      if (L != null) { L.$destroy(); }
    }
  }

/*private:*/
  /*friend  class Timer*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::addTimer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*double-link timers*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 290,
   FQN="llvm::TimerGroup::addTimer", NM="_ZN4llvm10TimerGroup8addTimerERNS_5TimerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroup8addTimerERNS_5TimerE")
  //</editor-fold>
  /*friend*//*private*/ void addTimer(final Timer /*&*/ T) {
    SmartScopedLock/*true*/ L = null;
    try {
      L/*J*/= new SmartScopedLock/*true*/(true, TimerLock.$star());
      
      // Add the timer to our list.
      // JAVA: Manually double link
      assert T.TG == this : T.TG + " vs. " + this;
      if ((FirstTimer != null)) {
        assert FirstTimer.Prev == null;
        FirstTimer.Prev = T;
      }
      T.Next = FirstTimer;
      assert T.Prev == null;
      FirstTimer = T;
    } finally {
      if (L != null) { L.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::removeTimer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*double-link timers, $Clone*/,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 267,
   FQN="llvm::TimerGroup::removeTimer", NM="_ZN4llvm10TimerGroup11removeTimerERNS_5TimerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroup11removeTimerERNS_5TimerE")
  //</editor-fold>
  /*friend*//*private*/ void removeTimer(final Timer /*&*/ T) {
    SmartScopedLock/*true*/ L = null;
    std.unique_ptr<raw_ostream> OutStream = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      L/*J*/= new SmartScopedLock/*true*/(true, TimerLock.$star());
      
      // If the timer was started, move its data to TimersToPrint.
      if (T.hasTriggered()) {
        TimersToPrint.emplace_back(new std.pairTypeType<TimeRecord, std.string>(Native.$Clone(T.Time), Native.$Clone(T.Name)));
      }
      assert T.TG == this : T.TG + " vs. " + this;
      T.TG = null;
      
      // Unlink the timer from our list.
      // JAVA: Manually unlink
      if ((T.Next != null)) {
        assert T.Next.Prev == T;
        T.Next.Prev = T.Prev;
      }
      if (T.Prev != null) {
        assert T.Prev.Next == T;
        T.Prev.Next = T.Next;
      }
      if (FirstTimer == T) {
        assert T.Prev == null;
        FirstTimer = T.Next;
      }
      T.Next = null;
      T.Prev = null;
      
      // Print the report when all timers in this group are destroyed if some of
      // them were started.
      if ((FirstTimer != null) || TimersToPrint.empty()) {
        return;
      }
      
      OutStream = $c$.clean(new std.unique_ptr<raw_ostream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(CreateInfoOutputFile())));
      PrintQueuedTimers(OutStream.$star());
    } finally {
      if (OutStream != null) { OutStream.$destroy(); }
      if (L != null) { L.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TimerGroup::PrintQueuedTimers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 301,
   FQN="llvm::TimerGroup::PrintQueuedTimers", NM="_ZN4llvm10TimerGroup17PrintQueuedTimersERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm10TimerGroup17PrintQueuedTimersERNS_11raw_ostreamE")
  //</editor-fold>
  private void PrintQueuedTimers(final raw_ostream /*&*/ OS) {
    // Sort the timers in descending order by amount of time taken.
    std.sort(TimersToPrint.begin(), TimersToPrint.end(), new Compare<std.pairTypeType<TimeRecord, std.string>>() {
      @Override
      public boolean compare(pairTypeType<TimeRecord, string> a, pairTypeType<TimeRecord, string> b) {
        if (a.first.$less(b.first)) {
          return true;
        } else if (b.first.$less(a.first)) {
          return false;
        } else if (a.second.$less(b.second)) {
          return true;
        }
        return false;
      }
    });
    
    TimeRecord Total/*J*/= new TimeRecord();
    for (final std.pairTypeType<TimeRecord, std.string> /*&*/ RecordNamePair : TimersToPrint)  {
      Total.$addassign(RecordNamePair.first);
    }
    
    // Print out timing header.
    OS.$out(/*KEEP_STR*/"===").$out(new std.string(73, $$MINUS)).$out(/*KEEP_STR*/"===\n");
    // Figure out how many spaces to indent TimerGroup name.
    /*uint*/int Padding = $div_uint((80 - Name.length()), 2);
    if ($greater_uint(Padding, 80)) {
      Padding = 0; // Don't allow "negative" numbers
    }
    OS.indent(Padding).$out(Name).$out_char($$LF);
    OS.$out(/*KEEP_STR*/"===").$out(new std.string(73, $$MINUS)).$out(/*KEEP_STR*/"===\n");
    
    // If this is not an collection of ungrouped times, print the total time.
    // Ungrouped timers don't really make sense to add up.  We still print the
    // TOTAL line to make the percentages make sense.
    if (this != DefaultTimerGroup) {
      OS.$out(format(/*KEEP_STR*/"  Total Execution Time: %5.4f seconds (%5.4f wall clock)\n", 
              Total.getProcessTime(), Total.getWallTime()));
    }
    OS.$out_char($$LF);
    if ((Total.getUserTime() != 0)) {
      OS.$out(/*KEEP_STR*/"   ---User Time---");
    }
    if ((Total.getSystemTime() != 0)) {
      OS.$out(/*KEEP_STR*/"   --System Time--");
    }
    if ((Total.getProcessTime() != 0)) {
      OS.$out(/*KEEP_STR*/"   --User+System--");
    }
    OS.$out(/*KEEP_STR*/"   ---Wall Time---");
    if ((Total.getMemUsed() != 0)) {
      OS.$out(/*KEEP_STR*/"  ---Mem---");
    }
    OS.$out(/*KEEP_STR*/"  --- Name ---\n");
    
    // Loop through all of the timing data, printing it out.
    for (/*uint*/int i = 0, e = TimersToPrint.size(); i != e; ++i) {
      final /*const*/std.pairTypeType<TimeRecord, std.string> /*&*/ Entry = TimersToPrint.$at(e - i - 1);
      Entry.first.print(Total, OS);
      OS.$out(Entry.second).$out_char($$LF);
    }
    
    Total.print(Total, OS);
    OS.$out(/*KEEP_STR*/"Total\n\n");
    OS.flush();
    
    TimersToPrint.clear();
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name.toJavaString() // NOI18N
              + ", FirstTimer=" + (FirstTimer != null ? FirstTimer.Name.toJavaString() : "<null>") // NOI18N
              + ", TimersToPrint=" + TimersToPrint.size() // NOI18N
              + ", Prev=" + (Prev == null ? "<null>" : Prev.Name.toJavaString()) // NOI18N
              + ", Next=" + (Next == null ? "<null>" : Next.Name.toJavaString()); // NOI18N
  }
}
