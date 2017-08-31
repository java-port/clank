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
package org.llvm.adt.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.impl.*;
import static org.llvm.support.impl.LlvmStatics.CreateInfoOutputFile;


//<editor-fold defaultstate="collapsed" desc="static type StatisticLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.adt.impl.StatisticLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE;_ZN4llvm15PrintStatisticsEv;_ZN4llvm16EnableStatisticsEv;_ZN4llvm19PrintStatisticsJSONERNS_11raw_ostreamE;_ZN4llvm20AreStatisticsEnabledEv; -static-type=StatisticLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class StatisticLlvmGlobals {


/// \brief Enable the collection and printing of statistics.
//<editor-fold defaultstate="collapsed" desc="llvm::EnableStatistics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 97,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 90,
 FQN="llvm::EnableStatistics", NM="_ZN4llvm16EnableStatisticsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm16EnableStatisticsEv")
//</editor-fold>
public static void EnableStatistics() {
  StatisticStatics.Enabled.setValue(true);
}


/// \brief Check if statistics are enabled.
//<editor-fold defaultstate="collapsed" desc="llvm::AreStatisticsEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 101,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 94,
 FQN="llvm::AreStatisticsEnabled", NM="_ZN4llvm20AreStatisticsEnabledEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm20AreStatisticsEnabledEv")
//</editor-fold>
public static boolean AreStatisticsEnabled() {
  return StatisticStatics.Enabled.$T();
}


/// \brief Print statistics to the file returned by CreateInfoOutputFile().
//<editor-fold defaultstate="collapsed" desc="llvm::PrintStatistics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 180,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 137,
 FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsEv")
//</editor-fold>
public static void PrintStatistics() {
  std.unique_ptr<raw_ostream> OutStream = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final StatisticInfo /*&*/ Stats = StatisticStatics.StatInfo.$star();
    
    // Statistics not enabled?
    if (Stats.Stats.empty()) {
      return;
    }
    
    // Get the stream to write to.
    OutStream = $c$.clean(new std.unique_ptr<raw_ostream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(CreateInfoOutputFile())));
    if (StatisticStatics.StatsAsJSON.$T()) {
      PrintStatisticsJSON(OutStream.$star());
    } else {
      PrintStatistics(OutStream.$star());
    }
  } finally {
    if (OutStream != null) { OutStream.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Print statistics to the given output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::PrintStatistics">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 118,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 98,
 FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE")
//</editor-fold>
public static void PrintStatistics(final raw_ostream /*&*/ OS) {
  final StatisticInfo /*&*/ Stats = StatisticStatics.StatInfo.$star();
  
  // Figure out how long the biggest Value and Name fields are.
  /*uint*/int MaxDebugTypeLen = 0;
  /*uint*/int MaxValLen = 0;
  for (/*size_t*/int i = 0, e = Stats.Stats.size(); i != e; ++i) {
    MaxValLen = std.max(MaxValLen, 
        (/*uint*/int)utostr($uint2ulong(Stats.Stats.$at(i).getValue())).size());
    MaxDebugTypeLen = std.max(MaxDebugTypeLen, 
        (/*uint*/int)std.strlen(Stats.Stats.$at(i).getDebugType()));
  }
  
  Stats.sort();
  
  // Print out the statistics header...
  OS.$out(/*KEEP_STR*/"===").$out(new std.string(73, $$MINUS)).$out(/*KEEP_STR*/"===\n").$out(
      /*KEEP_STR*/"                          ... Statistics Collected ...\n"
  ).$out(
      /*KEEP_STR*/"==="
  ).$out(new std.string(73, $$MINUS)).$out(/*KEEP_STR*/"===\n\n");
  
  // Print all of the statistics.
  for (/*size_t*/int i = 0, e = Stats.Stats.size(); i != e; ++i)  {
    // JAVA: magic with starts and unsigned integers
    OS.$out(format(/*KEEP_STR*/"%"+/*STAR*/MaxValLen+/*u=>d*/"d %-"+/*STAR*/MaxDebugTypeLen + "s - %s\n", 
            /*MaxValLen,*/ $uint2ulong(Stats.Stats.$at(i).getValue()), 
            /*MaxDebugTypeLen, */Stats.Stats.$at(i).getDebugType(), 
            Stats.Stats.$at(i).getDesc()));
  }
  
  OS.$out_char($$LF); // Flush the output stream.
  OS.flush();
}


/// Print statistics in JSON format.
//<editor-fold defaultstate="collapsed" desc="llvm::PrintStatisticsJSON">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 159,
 FQN="llvm::PrintStatisticsJSON", NM="_ZN4llvm19PrintStatisticsJSONERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm19PrintStatisticsJSONERNS_11raw_ostreamE")
//</editor-fold>
public static void PrintStatisticsJSON(final raw_ostream /*&*/ OS) {
  final StatisticInfo /*&*/ Stats = StatisticStatics.StatInfo.$star();
  
  Stats.sort();
  
  // Print all of the statistics.
  OS.$out(/*KEEP_STR*/"{\n");
  /*const*/char$ptr/*char P*/ delim = $EMPTY;
  for (/*const*/ Statistic /*P*/ Stat : Stats.Stats) {
    OS.$out(delim);
    OS.$out(/*KEEP_STR*/"\t\"");
    StatisticStatics.write_json_string_escaped(OS, Stat.getDebugType());
    OS.$out_char($$DOT);
    StatisticStatics.write_json_string_escaped(OS, Stat.getName());
    OS.$out(/*KEEP_STR*/"\": ").$out_uint(Stat.getValue());
    delim = $tryClone($(",\n"));
  }
  OS.$out(/*KEEP_STR*/"\n}\n");
  OS.flush();
}

//////////////////////////// EXTRA MEMBERS /////////////////////////////////////

public static void java$shutdown() {
  StatisticStatics.java$shutdown();
}

} // END OF class StatisticLlvmGlobals
