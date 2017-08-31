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

package org.llvm.adt;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.support.sys.*;
import static org.llvm.support.ValgrindGlobals.*;
import static org.llvm.support.impl.StatisticStatics.*;

//<editor-fold defaultstate="collapsed" desc="llvm::Statistic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 38,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 37,
 FQN="llvm::Statistic", NM="_ZN4llvm9StatisticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticE")
//</editor-fold>
public class Statistic {
/*public:*/
  public /*const*/char$ptr/*char P*/ DebugType;
  public /*const*/char$ptr/*char P*/ Name;
  public /*const*/char$ptr/*char P*/ Desc;
  public std.atomicUInt Value;
  public boolean Initialized;

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Statistic(char$ptr DebugType, char$ptr Name, char$ptr Desc, /*uint*/int Value, boolean Initialized) {
    this.DebugType = DebugType;
    this.Name = Name;
    this.Desc = Desc;
    this.Value = new std.atomicUInt(Value);
    this.Initialized = Initialized;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 44,
   FQN="llvm::Statistic::getValue", NM="_ZNK4llvm9Statistic8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZNK4llvm9Statistic8getValueEv")
  //</editor-fold>
  public /*uint*/int getValue() /*const*/ {
    return Value.load(std.memory_order.memory_order_relaxed);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::getDebugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 47,
   FQN="llvm::Statistic::getDebugType", NM="_ZNK4llvm9Statistic12getDebugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZNK4llvm9Statistic12getDebugTypeEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getDebugType() /*const*/ {
    return DebugType;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 45,
   FQN="llvm::Statistic::getName", NM="_ZNK4llvm9Statistic7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZNK4llvm9Statistic7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    return Name;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::getDesc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 46,
   FQN="llvm::Statistic::getDesc", NM="_ZNK4llvm9Statistic7getDescEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZNK4llvm9Statistic7getDescEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getDesc() /*const*/ {
    return Desc;
  }

  
  /// construct - This should only be called for non-global statistics.
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::construct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 52,
   FQN="llvm::Statistic::construct", NM="_ZN4llvm9Statistic9constructEPKcS2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9Statistic9constructEPKcS2_S2_")
  //</editor-fold>
  public void construct(/*const*/char$ptr/*char P*/ debugtype, /*const*/char$ptr/*char P*/ name, /*const*/char$ptr/*char P*/ desc) {
    DebugType = $tryClone(debugtype);
    Name = $tryClone(name);
    Desc = $tryClone(desc);
    Value.$assign(0);
    Initialized = false;
  }

  
  // Allow use of this class as the value itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator unsigned int">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 55,
   FQN="llvm::Statistic::operator unsigned int", NM="_ZNK4llvm9StatisticcvjEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZNK4llvm9StatisticcvjEv")
  //</editor-fold>
  public /*uint*/int $uint() /*const*/ {
    return getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 58,
   FQN="llvm::Statistic::operator=", NM="_ZN4llvm9StatisticaSEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticaSEj")
  //</editor-fold>
  public /*const*/ Statistic /*&*/ $assign(/*uint*/int Val) {
    Value.store(Val, std.memory_order.memory_order_relaxed);
    return init();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 63,
   FQN="llvm::Statistic::operator++", NM="_ZN4llvm9StatisticppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticppEv")
  //</editor-fold>
  public /*const*/ Statistic /*&*/ $preInc() {
    Value.fetch_add(1, std.memory_order.memory_order_relaxed);
    return init();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 72,
   FQN="llvm::Statistic::operator++", NM="_ZN4llvm9StatisticppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticppEi")
  //</editor-fold>
  public /*uint*/int $postInc(int $Prm0) {
    init();
    return Value.fetch_add(1, std.memory_order.memory_order_relaxed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 79,
   FQN="llvm::Statistic::operator--", NM="_ZN4llvm9StatisticmmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticmmEv")
  //</editor-fold>
  public /*const*/ Statistic /*&*/ $preDec() {
    Value.fetch_sub(1, std.memory_order.memory_order_relaxed);
    return init();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator--">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 84,
   FQN="llvm::Statistic::operator--", NM="_ZN4llvm9StatisticmmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticmmEi")
  //</editor-fold>
  public /*uint*/int $postDec(int $Prm0) {
    init();
    return Value.fetch_sub(1, std.memory_order.memory_order_relaxed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator+=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 89,
   FQN="llvm::Statistic::operator+=", NM="_ZN4llvm9StatisticpLEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticpLEj")
  //</editor-fold>
  public /*const*/ Statistic /*&*/ $addassign(/*uint*/int V) {
    if (V == 0) {
      return /*Deref*/this;
    }
    Value.fetch_add(V, std.memory_order.memory_order_relaxed);
    return init();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::operator-=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 96,
   FQN="llvm::Statistic::operator-=", NM="_ZN4llvm9StatisticmIEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9StatisticmIEj")
  //</editor-fold>
  public /*const*/ Statistic /*&*/ $minusassign(/*uint*/int V) {
    if (V == 0) {
      return /*Deref*/this;
    }
    Value.fetch_sub(V, std.memory_order.memory_order_relaxed);
    return init();
  }

// !defined(NDEBUG) || defined(LLVM_ENABLE_STATS)
  /*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", old_line = 154,
   FQN="llvm::Statistic::init", NM="_ZN4llvm9Statistic4initEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9Statistic4initEv")
  //</editor-fold>
  protected Statistic /*&*/ init() {
    boolean tmp = Initialized;
    sys.MemoryFence();
    if (!tmp) {
      RegisterStatistic();
    }
    AnnotateHappensAfter("${LLVM_SRC}/llvm/include/llvm/ADT/Statistic.h", 156, this);
    return /*Deref*/this;
  }

  
  /// RegisterStatistic - The first time a statistic is bumped, this method is
  /// called.
  //<editor-fold defaultstate="collapsed" desc="llvm::Statistic::RegisterStatistic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 75,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 68,
   FQN="llvm::Statistic::RegisterStatistic", NM="_ZN4llvm9Statistic17RegisterStatisticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm9Statistic17RegisterStatisticEv")
  //</editor-fold>
  protected void RegisterStatistic() {
    SmartScopedLock/*true*/ Writer = null;
    try {
      // If stats are enabled, inform StatInfo that this statistic should be
      // printed.
      Writer/*J*/= new SmartScopedLock/*true*/(true, StatLock.$star());
      if (!Initialized) {
        if (Enabled.$T()) {
          StatInfo.$arrow().addStatistic(this);
        }
        AnnotateHappensBefore("${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", 78, this);
        sys.MemoryFence();
        // Remember we have been registered.
        AnnotateIgnoreWritesBegin("${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", 81);
        Initialized = true;
        AnnotateIgnoreWritesEnd("${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", 83);
      }
    } finally {
      if (Writer != null) { Writer.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "DebugType=" + DebugType // NOI18N
              + ", Name=" + Name // NOI18N
              + ", Desc=" + Desc // NOI18N
              + ", Value=" + Value // NOI18N
              + ", Initialized=" + Initialized; // NOI18N
  }
}
