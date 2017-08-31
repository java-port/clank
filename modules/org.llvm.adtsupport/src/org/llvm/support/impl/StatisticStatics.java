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

import org.llvm.cl.aliases.optBool;
import org.llvm.support.sys.sys;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.*;
import org.llvm.support.*;
import org.llvm.cl.*;
import org.llvm.support.sys.ManagedStaticInfoImpl;
import org.llvm.support.sys.SmartMutex;


//<editor-fold defaultstate="collapsed" desc="static type StatisticStatics">
@Converted(kind = Converted.Kind.MANUAL,
 NM="org.llvm.support.impl.StatisticStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZL11StatsAsJSON;_ZL25write_json_string_escapedRN4llvm11raw_ostreamEPKc;_ZL7Enabled;_ZL8StatInfo;_ZL8StatLock; -static-type=StatisticStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class StatisticStatics {
// JAVA: put t here, because forward referencing is not allowed in Java  
private static final ManagedStaticInfo<StatisticInfo> StaticStatisticInfo = new ManagedStaticInfoImpl<StatisticInfo>() {

  @Override
  protected StatisticInfo create() {
    return new StatisticInfo();
  }
};

/// -stats - Command line option to cause transformations to emit stats about
/// what they did.
///
//<editor-fold defaultstate="collapsed" desc="Enabled">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 40,
 FQN="Enabled", NM="_ZL7Enabled",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZL7Enabled")
//</editor-fold>
public static final optBool Enabled/*J*/= new optBool($("stats"), 
    new desc($("Enable statistics output from program (available with Asserts)")));
//<editor-fold defaultstate="collapsed" desc="StatsAsJSON">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 46,
 FQN="StatsAsJSON", NM="_ZL11StatsAsJSON",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZL11StatsAsJSON")
//</editor-fold>
public static final optBool StatsAsJSON/*J*/= new optBool($("stats-json"), 
    new desc($("Display statistics as json data")));

//<editor-fold defaultstate="collapsed" desc="StatInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 70,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 63,
 FQN="StatInfo", NM="_ZL8StatInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZL8StatInfo")
//</editor-fold>
public static final ManagedStatic<StatisticInfo> StatInfo/*J*/= new ManagedStatic<StatisticInfo>(StaticStatisticInfo);
//<editor-fold defaultstate="collapsed" desc="StatLock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 71,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 64,
 FQN="StatLock", NM="_ZL8StatLock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZL8StatLock")
//</editor-fold>
public static final ManagedStatic<SmartMutex/*<true>*/> StatLock/*J*/= new ManagedStatic<SmartMutex/*<true>*/>(sys.StaticSmartMutexTrue);
//<editor-fold defaultstate="collapsed" desc="write_json_string_escaped">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 148,
 FQN="write_json_string_escaped", NM="_ZL25write_json_string_escapedRN4llvm11raw_ostreamEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZL25write_json_string_escapedRN4llvm11raw_ostreamEPKc")
//</editor-fold>
public static void write_json_string_escaped(final raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ string) {
  for (/*const*/char$ptr/*uchar P*/ c = $tryClone(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, string)); $uchar2int(c.$star()) != $$TERM; c.$preInc()) {
    assert ($uchar2int(c.$star()) != $$BACK_SLASH && $uchar2int(c.$star()) != $$DBL_QUOTE && $uchar2int(c.$star()) >= 0x20 && $uchar2int(c.$star()) < 0x80);
  }
  OS.$out(string);
}

//////////////////////////// EXTRA MEMBERS /////////////////////////////////////

public static void java$shutdown() {
  // reset options
  Enabled.reset();
  assert Enabled.$T() == false : "expected default as false when generated";
  StatsAsJSON.reset();
  assert StatsAsJSON.$DataType() == false : "expected default as false when generated";
}

} // END OF class StatisticStatics
