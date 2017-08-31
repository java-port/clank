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
package org.llvm.mc.stats.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type StatsStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.mc.stats.impl.StatsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN12_GLOBAL__N_15statsL11ObjectBytesE;_ZN12_GLOBAL__N_15statsL13evaluateFixupE;_ZN12_GLOBAL__N_15statsL14MCExprEvaluateE;_ZN12_GLOBAL__N_15statsL15FragmentLayoutsE;_ZN12_GLOBAL__N_15statsL15RelaxationStepsE;_ZN12_GLOBAL__N_15statsL16EmittedFragmentsE;_ZN12_GLOBAL__N_15statsL19EmittedOrgFragmentsE;_ZN12_GLOBAL__N_15statsL19RelaxedInstructionsE;_ZN12_GLOBAL__N_15statsL20EmittedDataFragmentsE;_ZN12_GLOBAL__N_15statsL20EmittedFillFragmentsE;_ZN12_GLOBAL__N_15statsL21EmittedAlignFragmentsE;_ZN12_GLOBAL__N_15statsL25EmittedRelaxableFragmentsE;_ZN12_GLOBAL__N_15statsL34EmittedCompactEncodedInstFragmentsE; -static-type=StatsStatics -package=org.llvm.mc.stats.impl")
//</editor-fold>
public final class StatsStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 40,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 39,
 FQN="(anonymous namespace)::stats::EmittedFragments", NM="_ZN12_GLOBAL__N_15statsL16EmittedFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL16EmittedFragmentsE")
//</editor-fold>
public static Statistic EmittedFragments = new Statistic($("assembler"), $("EmittedFragments"), $("Number of emitted assembler fragments - total"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedRelaxableFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 41,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 40,
 FQN="(anonymous namespace)::stats::EmittedRelaxableFragments", NM="_ZN12_GLOBAL__N_15statsL25EmittedRelaxableFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL25EmittedRelaxableFragmentsE")
//</editor-fold>
public static Statistic EmittedRelaxableFragments = new Statistic($("assembler"), $("EmittedRelaxableFragments"), $("Number of emitted assembler fragments - relaxable"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedDataFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 43,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 42,
 FQN="(anonymous namespace)::stats::EmittedDataFragments", NM="_ZN12_GLOBAL__N_15statsL20EmittedDataFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL20EmittedDataFragmentsE")
//</editor-fold>
public static Statistic EmittedDataFragments = new Statistic($("assembler"), $("EmittedDataFragments"), $("Number of emitted assembler fragments - data"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedCompactEncodedInstFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 45,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 44,
 FQN="(anonymous namespace)::stats::EmittedCompactEncodedInstFragments", NM="_ZN12_GLOBAL__N_15statsL34EmittedCompactEncodedInstFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL34EmittedCompactEncodedInstFragmentsE")
//</editor-fold>
public static Statistic EmittedCompactEncodedInstFragments = new Statistic($("assembler"), $("EmittedCompactEncodedInstFragments"), $("Number of emitted assembler fragments - compact encoded inst"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedAlignFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 47,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 46,
 FQN="(anonymous namespace)::stats::EmittedAlignFragments", NM="_ZN12_GLOBAL__N_15statsL21EmittedAlignFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL21EmittedAlignFragmentsE")
//</editor-fold>
public static Statistic EmittedAlignFragments = new Statistic($("assembler"), $("EmittedAlignFragments"), $("Number of emitted assembler fragments - align"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedFillFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 49,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 48,
 FQN="(anonymous namespace)::stats::EmittedFillFragments", NM="_ZN12_GLOBAL__N_15statsL20EmittedFillFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL20EmittedFillFragmentsE")
//</editor-fold>
public static Statistic EmittedFillFragments = new Statistic($("assembler"), $("EmittedFillFragments"), $("Number of emitted assembler fragments - fill"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::EmittedOrgFragments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 51,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 50,
 FQN="(anonymous namespace)::stats::EmittedOrgFragments", NM="_ZN12_GLOBAL__N_15statsL19EmittedOrgFragmentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL19EmittedOrgFragmentsE")
//</editor-fold>
public static Statistic EmittedOrgFragments = new Statistic($("assembler"), $("EmittedOrgFragments"), $("Number of emitted assembler fragments - org"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::evaluateFixup">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 53,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 52,
 FQN="(anonymous namespace)::stats::evaluateFixup", NM="_ZN12_GLOBAL__N_15statsL13evaluateFixupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL13evaluateFixupE")
//</editor-fold>
public static Statistic evaluateFixup = new Statistic($("assembler"), $("evaluateFixup"), $("Number of evaluated fixups"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::FragmentLayouts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 54,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 53,
 FQN="(anonymous namespace)::stats::FragmentLayouts", NM="_ZN12_GLOBAL__N_15statsL15FragmentLayoutsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL15FragmentLayoutsE")
//</editor-fold>
public static Statistic FragmentLayouts = new Statistic($("assembler"), $("FragmentLayouts"), $("Number of fragment layouts"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::ObjectBytes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 55,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 54,
 FQN="(anonymous namespace)::stats::ObjectBytes", NM="_ZN12_GLOBAL__N_15statsL11ObjectBytesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL11ObjectBytesE")
//</editor-fold>
public static Statistic ObjectBytes = new Statistic($("assembler"), $("ObjectBytes"), $("Number of emitted object file bytes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::RelaxationSteps">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 56,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 55,
 FQN="(anonymous namespace)::stats::RelaxationSteps", NM="_ZN12_GLOBAL__N_15statsL15RelaxationStepsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL15RelaxationStepsE")
//</editor-fold>
public static Statistic RelaxationSteps = new Statistic($("assembler"), $("RelaxationSteps"), $("Number of assembler layout and relaxation steps"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::RelaxedInstructions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 57,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 56,
 FQN="(anonymous namespace)::stats::RelaxedInstructions", NM="_ZN12_GLOBAL__N_15statsL19RelaxedInstructionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN12_GLOBAL__N_15statsL19RelaxedInstructionsE")
//</editor-fold>
public static Statistic RelaxedInstructions = new Statistic($("assembler"), $("RelaxedInstructions"), $("Number of relaxed instructions"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stats::MCExprEvaluate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 29,
 FQN="(anonymous namespace)::stats::MCExprEvaluate", NM="_ZN12_GLOBAL__N_15statsL14MCExprEvaluateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN12_GLOBAL__N_15statsL14MCExprEvaluateE")
//</editor-fold>
public static Statistic MCExprEvaluate = new Statistic($("mcexpr"), $("MCExprEvaluate"), $("Number of MCExpr evaluations"), 0, false);
} // END OF class StatsStatics
