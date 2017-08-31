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

package org.llvm.support.impl;

import org.llvm.cl.aliases.optString;
import org.llvm.cl.aliases.optBool;
import org.llvm.support.sys.sys;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.literal_constants.$;
import org.llvm.support.*;
import org.llvm.support.sys.Process;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.cl.*;
import org.llvm.support.sys.ManagedStaticInfoImpl;
import org.llvm.support.sys.SmartMutex;

//<editor-fold defaultstate="collapsed" desc="static type TimerStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL31getLibSupportInfoOutputFilenamev;_ZN12_GLOBAL__N_112Name2PairMapC1ERKS0_;_ZL18NamedGroupedTimers;_ZL20getDefaultTimerGroupv;_ZN12_GLOBAL__N_1L10TrackSpaceE;_ZL11getMemUsagev;_ZL14TimerGroupList;_ZL17DefaultTimerGroup;_ZN12_GLOBAL__N_1L18InfoOutputFilenameE;_ZL19getNamedRegionTimerN4llvm9StringRefE;_ZL8printValddRN4llvm11raw_ostreamE;_ZL12ActiveTimers;_ZL11NamedTimers;_ZL28LibSupportInfoOutputFilename;_ZL9TimerLock; -static-type=TimerStatics")
//</editor-fold>
public final class TimerStatics {
public static final ManagedStaticInfo<std.vector<Timer/*P*/>> StaticStdVectorTimer = new ManagedStaticInfoImpl<std.vector<Timer/*P*/>>() {

  @Override
  protected std.vector<Timer/*P*/> create() {
    return new std.vector<Timer/*P*/>((Timer)null);
  }
};

public static final ManagedStaticInfo<StringMap<Timer/*, MallocAllocator*/> > StaticStringMapTimer = new ManagedStaticInfoImpl<StringMap<Timer/*, MallocAllocator*/> >() {

  @Override
  protected StringMap<Timer/*, MallocAllocator*/> create() {
    return new StringMap<Timer/*, MallocAllocator*/>(/*FIXME*/ null);
  }
};

// getLibSupportInfoOutputFilename - This ugly hack is brought to you courtesy
// of constructor/destructor ordering being unspecified by C++.  Basically the
// problem is that a Statistic object gets destroyed, which ends up calling
// 'GetLibSupportInfoOutputFile()' (below), which calls this function.
// LibSupportInfoOutputFilename used to be a global variable, but sometimes it
// would get destroyed before the Statistic, causing havoc to ensue.  We "fix"
// this by creating the string the first time it is needed and never destroying
// it.
//<editor-fold defaultstate="collapsed" desc="LibSupportInfoOutputFilename">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 34,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 38,
 FQN = "LibSupportInfoOutputFilename", NM = "_ZL28LibSupportInfoOutputFilename",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL28LibSupportInfoOutputFilename")
//</editor-fold>
public static ManagedStatic<std.string> LibSupportInfoOutputFilename/*J*/= new ManagedStatic<std.string>(sys.StaticStdString);
//<editor-fold defaultstate="collapsed" desc="getLibSupportInfoOutputFilename">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 35,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 39,
 FQN = "getLibSupportInfoOutputFilename", NM = "_ZL31getLibSupportInfoOutputFilenamev",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL31getLibSupportInfoOutputFilenamev")
//</editor-fold>
public static std.string/*&*/ getLibSupportInfoOutputFilename() {
  return LibSupportInfoOutputFilename.$star();
}

//<editor-fold defaultstate="collapsed" desc="TimerLock">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 39,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 43,
 FQN = "TimerLock", NM = "_ZL9TimerLock",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL9TimerLock")
//</editor-fold>
public static ManagedStatic<SmartMutex/*<true>*/> TimerLock/*J*/= new ManagedStatic<SmartMutex/*<true>*/>(sys.StaticSmartMutexTrue);
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::TrackSpace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 42,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 46,
 FQN = "(anonymous namespace)::TrackSpace", NM = "_ZN12_GLOBAL__N_1L10TrackSpaceE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN12_GLOBAL__N_1L10TrackSpaceE")
//</editor-fold>
public static opt<Boolean> TrackSpace/*J*/= new optBool("track-memory", new desc("Enable -time-passes memory tracking (this may be slow)"), OptionHidden.Hidden);
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InfoOutputFilename">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 47,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 51,
 FQN = "(anonymous namespace)::InfoOutputFilename", NM = "_ZN12_GLOBAL__N_1L18InfoOutputFilenameE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN12_GLOBAL__N_1L18InfoOutputFilenameE")
//</editor-fold>
public static opt<std.string> /*true*/ InfoOutputFilename/*J*/= new optString/*true*/(opt.StorageKind.External/*ExternalStorage*/, $("info-output-file"), new value_desc("filename"), 
          new desc("File to append -stats and -timer output to"), 
          OptionHidden.Hidden, ClGlobals.location(getLibSupportInfoOutputFilename()));
//<editor-fold defaultstate="collapsed" desc="DefaultTimerGroup">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 77,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 82,
 FQN = "DefaultTimerGroup", NM = "_ZL17DefaultTimerGroup",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL17DefaultTimerGroup")
//</editor-fold>
public static TimerGroup /*P*/ DefaultTimerGroup = null;
//<editor-fold defaultstate="collapsed" desc="getDefaultTimerGroup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 78,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 83,
 FQN = "getDefaultTimerGroup", NM = "_ZL20getDefaultTimerGroupv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL20getDefaultTimerGroupv")
//</editor-fold>
public static TimerGroup /*P*/ getDefaultTimerGroup() {
  synchronized (TimerStatics.class) {
    if (DefaultTimerGroup == null) {
      DefaultTimerGroup = new TimerGroup(new StringRef(/*KEEP_STR*/"Miscellaneous Ungrouped Timers"));
    }
    return DefaultTimerGroup;
  }
}

//<editor-fold defaultstate="collapsed" desc="getMemUsage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 115,
 FQN="getMemUsage", NM="_ZL11getMemUsagev",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL11getMemUsagev")
//</editor-fold>
public static /*inline*/ /*size_t*/int getMemUsage() {
  if (!TrackSpace.$T()) {
    return 0;
  }
  return Process.GetMallocUsage();
}

//<editor-fold defaultstate="collapsed" desc="ActiveTimers">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 147,
 FQN = "ActiveTimers", NM = "_ZL12ActiveTimers",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -filter=ActiveTimers")
//</editor-fold>
public static ManagedStatic<std.vector<Timer /*P*/ > > ActiveTimers/*J*/= new ManagedStatic<std.vector<Timer /*P*/ > >(StaticStdVectorTimer);
//<editor-fold defaultstate="collapsed" desc="printVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 156,
 FQN="printVal", NM="_ZL8printValddRN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL8printValddRN4llvm11raw_ostreamE")
//</editor-fold>
public static void printVal(double Val, double Total, final raw_ostream /*&*/ OS) {
  if (Total < 9.9999999999999995E-8) { // Avoid dividing by zero.
    OS.$out(/*KEEP_STR*/"        -----     ");
  } else {
    OS.$out(llvm.format(/*KEEP_STR*/"  %7.4f (%5.1f%%)", Val, Val * 100 / Total));
  }
}

//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Name2PairMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 187,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 199,
 FQN = "(anonymous namespace)::Name2PairMap", NM = "_ZN12_GLOBAL__N_112Name2PairMapE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN12_GLOBAL__N_112Name2PairMapE")
//</editor-fold>
public static class Name2PairMap implements Destructors.ClassWithDestructor {
  private StringMap<std.pair<TimerGroup /*P*/ , StringMap<Timer/*, MallocAllocator*/> >/*, MallocAllocator*/> Map;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Name2PairMap::~Name2PairMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 190,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 202,
   FQN = "(anonymous namespace)::Name2PairMap::~Name2PairMap", NM = "_ZN12_GLOBAL__N_112Name2PairMapD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN12_GLOBAL__N_112Name2PairMapD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Name2PairMap::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 196,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 208,
   FQN = "(anonymous namespace)::Name2PairMap::get", NM = "_ZN12_GLOBAL__N_112Name2PairMap3getEN4llvm9StringRefES2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN12_GLOBAL__N_112Name2PairMap3getEN4llvm9StringRefES2_")
  //</editor-fold>
  public Timer /*&*/ get(StringRef Name, StringRef GroupName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::Name2PairMap::Name2PairMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 187,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 199,
   FQN = "(anonymous namespace)::Name2PairMap::Name2PairMap", NM = "_ZN12_GLOBAL__N_112Name2PairMapC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN12_GLOBAL__N_112Name2PairMapC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Name2PairMap() {
    /* : Map()*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

}

public static final ManagedStaticInfo<Name2PairMap> StaticName2PairMap = new ManagedStaticInfoImpl<Name2PairMap>() {

  @Override
  protected Name2PairMap create() {
    return new Name2PairMap();
  }
};

//<editor-fold defaultstate="collapsed" desc="NamedTimers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 213,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 225,
 FQN = "NamedTimers", NM = "_ZL11NamedTimers",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL11NamedTimers")
//</editor-fold>
public static ManagedStatic<StringMap<Timer/*, MallocAllocator*/> > NamedTimers/*J*/= new ManagedStatic<StringMap<Timer/*, MallocAllocator*/> >(StaticStringMapTimer);
//<editor-fold defaultstate="collapsed" desc="NamedGroupedTimers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 214,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 226,
 FQN = "NamedGroupedTimers", NM = "_ZL18NamedGroupedTimers",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL18NamedGroupedTimers")
//</editor-fold>
public static ManagedStatic<Name2PairMap> NamedGroupedTimers/*J*/= new ManagedStatic<Name2PairMap>(StaticName2PairMap);
//<editor-fold defaultstate="collapsed" desc="getNamedRegionTimer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 216,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 228,
 FQN = "getNamedRegionTimer", NM = "_ZL19getNamedRegionTimerN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL19getNamedRegionTimerN4llvm9StringRefE")
//</editor-fold>
public static Timer /*&*/ getNamedRegionTimer(StringRef Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//   TimerGroup Implementation
//===----------------------------------------------------------------------===//

/// TimerGroupList - This is the global list of TimerGroups, maintained by the
/// TimerGroup ctor/dtor and is protected by the TimerLock lock.
//<editor-fold defaultstate="collapsed" desc="TimerGroupList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 239,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", old_line = 251,
 FQN = "TimerGroupList", NM = "_ZL14TimerGroupList",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZL14TimerGroupList")
//</editor-fold>
public static TimerGroup /*P*/ TimerGroupList = null;


//////////////////////////// EXTRA MEMBERS /////////////////////////////////////

public static void java$shutdown() {
  while ((TimerStatics.TimerGroupList != null)) {
    TimerStatics.TimerGroupList.$destroy();
  }
  assert TimerStatics.TimerGroupList == null;
  // resest options
  InfoOutputFilename.reset();
  assert InfoOutputFilename.$T().$eq(new std.string(""));
  TrackSpace.reset();
  assert TrackSpace.$T() == false;
  // reset default group as well
  DefaultTimerGroup = null;
}

} // END OF class TimerStatics
