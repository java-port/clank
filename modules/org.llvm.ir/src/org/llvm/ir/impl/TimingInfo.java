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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;
import org.llvm.support.sys.ManagedStaticInfoImpl;
import org.llvm.support.sys.SmartScopedLock;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TimingInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 452,
 FQN="(anonymous namespace)::TimingInfo", NM="_ZN12_GLOBAL__N_110TimingInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_110TimingInfoE")
//</editor-fold>
public class TimingInfo implements Destructors.ClassWithDestructor {
  private DenseMap<Pass /*P*/ , Timer /*P*/ > TimingData;
  private TimerGroup TG;
/*public:*/
  // Use 'create' member to get this.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TimingInfo::TimingInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 457,
   FQN="(anonymous namespace)::TimingInfo::TimingInfo", NM="_ZN12_GLOBAL__N_110TimingInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_110TimingInfoC1Ev")
  //</editor-fold>
  public TimingInfo() {
    // : TimingData(), TG("... Pass execution timing report ...")
    //START JInit
    this.TimingData = new DenseMap<Pass /*P*/ , Timer /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Timer /*P*/ )null);
    this.TG = new TimerGroup(new StringRef(/*KEEP_STR*/"... Pass execution timing report ..."));
    //END JInit
  }


  // TimingDtor - Print out information about timing information
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TimingInfo::~TimingInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 460,
   FQN="(anonymous namespace)::TimingInfo::~TimingInfo", NM="_ZN12_GLOBAL__N_110TimingInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_110TimingInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Delete all of the timers, which accumulate their info into the
    // TimerGroup.
    for (final std.pair<Pass /*P*/ , Timer /*P*/ > /*&*/ I : TimingData)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I.second);
    }
    // TimerGroup is deleted next, printing the report.
    //START JDestroy
    TG.$destroy();
    TimingData.$destroy();
    //END JDestroy
  }


  // createTheTimeInfo - This method either initializes the TheTimeInfo pointer
  // to a non-null value (if the -time-passes option is enabled) or it leaves it
  // null.  It may be called multiple times.

  // createTheTimeInfo - This method either initializes the TheTimeInfo pointer to
  // a non-null value (if the -time-passes option is enabled) or it leaves it
  // null.  It may be called multiple times.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TimingInfo::createTheTimeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1751,
   FQN="(anonymous namespace)::TimingInfo::createTheTimeInfo", NM="_ZN12_GLOBAL__N_110TimingInfo17createTheTimeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_110TimingInfo17createTheTimeInfoEv")
  //</editor-fold>
  public static void createTheTimeInfo() {
    if (!IrLlvmGlobals.TimePassesIsEnabled || (LegacyPassManagerStatics.TheTimeInfo != null)) {
      return;
    }

    // Constructed the first time this is called, iff -time-passes is enabled.
    // This guarantees that the object will be constructed before static globals,
    // thus it will be destroyed before them.
    final/*static*/ ManagedStatic<TimingInfo> TTI = createTheTimeInfo$$.TTI;
    LegacyPassManagerStatics.TheTimeInfo = $AddrOf(TTI.$star());
  }
  private static final class createTheTimeInfo$$ {
    static final/*static*/ ManagedStatic<TimingInfo> TTI/*J*/= new ManagedStatic<TimingInfo>(new TimingInfoInfo());
  }


  /// getPassTimer - Return the timer for the specified pass if it exists.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TimingInfo::getPassTimer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 474,
   FQN="(anonymous namespace)::TimingInfo::getPassTimer", NM="_ZN12_GLOBAL__N_110TimingInfo12getPassTimerEPN4llvm4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_110TimingInfo12getPassTimerEPN4llvm4PassE")
  //</editor-fold>
  public Timer /*P*/ getPassTimer(Pass /*P*/ P) {
    SmartScopedLock/*true*/ Lock = null;
    try {
      if ((P.getAsPMDataManager() != null)) {
        return null;
      }

      Lock/*J*/= new SmartScopedLock/*true*/(true, LegacyPassManagerStatics.TimingInfoMutex.$star());
      final type$ref<Timer /*P*/ /*&*/> T = TimingData.ref$at(P);
      if (!(T.$deref() != null)) {
        T.$set(new Timer(new StringRef(P.getPassName()), TG));
      }
      return T.$deref();
    } finally {
      if (Lock != null) { Lock.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final class TimingInfoInfo extends ManagedStaticInfoImpl<TimingInfo> {
    @Override
    protected TimingInfo create() {
      return new TimingInfo();
    }
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "TimingData=" + TimingData // NOI18N
              + ", TG=" + TG; // NOI18N
  }
}
