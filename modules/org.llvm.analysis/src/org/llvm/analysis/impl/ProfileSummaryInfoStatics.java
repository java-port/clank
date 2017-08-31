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
package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.$less_uint_ulong;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;
import org.llvm.cl.*;
import org.llvm.cl.aliases.optInt;
import org.llvm.ir.java.IRFunctionPointers.ProfileSummaryEntryULong2Bool;


//<editor-fold defaultstate="collapsed" desc="static type ProfileSummaryInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.impl.ProfileSummaryInfoStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZL23ProfileSummaryCutoffHot;_ZL24ProfileSummaryCutoffCold;_ZL24getMinCountForPercentileRSt6vectorIN4llvm19ProfileSummaryEntryESaIS1_EEy;_ZL47InitializeProfileSummaryInfoWrapperPassPassFlag;_ZL47initializeProfileSummaryInfoWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=ProfileSummaryInfoStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ProfileSummaryInfoStatics {


// The following two parameters determine the threshold for a count to be
// considered hot/cold. These two parameters are percentile values (multiplied
// by 10000). If the counts are sorted in descending order, the minimum count to
// reach ProfileSummaryCutoffHot gives the threshold to determine a hot count.
// Similarly, the minimum count to reach ProfileSummaryCutoffCold gives the
// threshold for determining cold count (everything <= this threshold is
// considered cold).
//<editor-fold defaultstate="collapsed" desc="ProfileSummaryCutoffHot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 29,
 FQN="ProfileSummaryCutoffHot", NM="_ZL23ProfileSummaryCutoffHot",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZL23ProfileSummaryCutoffHot")
//</editor-fold>
public static optInt ProfileSummaryCutoffHot/*J*/= new optInt(opt.StorageKind.Internal, $("profile-summary-cutoff-hot"), OptionHidden.Hidden, ClGlobals.init$Int(999000), NumOccurrencesFlag.ZeroOrMore, 
    new desc($("A count is hot if it exceeds the minimum count to reach this percentile of total counts.")));
//<editor-fold defaultstate="collapsed" desc="ProfileSummaryCutoffCold">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 34,
 FQN="ProfileSummaryCutoffCold", NM="_ZL24ProfileSummaryCutoffCold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZL24ProfileSummaryCutoffCold")
//</editor-fold>
public static optInt ProfileSummaryCutoffCold/*J*/= new optInt(opt.StorageKind.Internal, $("profile-summary-cutoff-cold"), OptionHidden.Hidden, ClGlobals.init$Int(999999), NumOccurrencesFlag.ZeroOrMore, 
    new desc($("A count is cold if it is below the minimum count to reach this percentile of total counts.")));

// Find the minimum count to reach a desired percentile of counts.
//<editor-fold defaultstate="collapsed" desc="getMinCountForPercentile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 40,
 FQN="getMinCountForPercentile", NM="_ZL24getMinCountForPercentileRSt6vectorIN4llvm19ProfileSummaryEntryESaIS1_EEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZL24getMinCountForPercentileRSt6vectorIN4llvm19ProfileSummaryEntryESaIS1_EEy")
//</editor-fold>
public static long/*uint64_t*/ getMinCountForPercentile(final std.vector<ProfileSummaryEntry> /*&*/ DS, 
                        final long/*uint64_t*/ Percentile) {
  ProfileSummaryEntryULong2Bool /*const*/ Compare = /*[]*/ (final /*const*/ ProfileSummaryEntry /*&*/ Entry, Long/*uint64_t*/ Percentile$1) -> {
        return $less_uint_ulong(Entry.Cutoff, Percentile$1);
      };
  std.vector.iterator<ProfileSummaryEntry /*P*/ > It = std.lower_bound(DS.begin(), DS.end(), (Long)Percentile, Compare);
  // The required percentile has to be <= one of the percentiles in the
  // detailed summary.
  if ($eq___normal_iterator$C(It, DS.end())) {
    report_fatal_error($("Desired percentile exceeds the maximum cutoff"));
  }
  return It.$arrow().MinCount;
}

//<editor-fold defaultstate="collapsed" desc="initializeProfileSummaryInfoWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 134,
 FQN="initializeProfileSummaryInfoWrapperPassPassOnce", NM="_ZL47initializeProfileSummaryInfoWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZL47initializeProfileSummaryInfoWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeProfileSummaryInfoWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Profile summary info"), $("profile-summary-info"), $AddrOf(ProfileSummaryInfoWrapperPass.ID), 
          () -> new ProfileSummaryInfoWrapperPass(),
//          ((NormalCtor_t)(/*FuncRef*/<ProfileSummaryInfoWrapperPass>callDefaultCtor)), 
          false, true);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeProfileSummaryInfoWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 134,
 FQN="InitializeProfileSummaryInfoWrapperPassPassFlag", NM="_ZL47InitializeProfileSummaryInfoWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZL47InitializeProfileSummaryInfoWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeProfileSummaryInfoWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class ProfileSummaryInfoStatics
