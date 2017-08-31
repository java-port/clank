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

import org.llvm.cl.aliases.optBool;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;


//<editor-fold defaultstate="collapsed" desc="static type DependenceAnalysisStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.DependenceAnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL11Delinearize;_ZL12GCDsuccesses;_ZL13isLoadOrStorePKN4llvm11InstructionE;_ZL14DeltaSuccesses;_ZL15GCDapplications;_ZL15GCDindependence;_ZL15TotalArrayPairs;_ZL15ZIVapplications;_ZL15ZIVindependence;_ZL15floorOfQuotientRKN4llvm5APIntES2_;_ZL15getConstantPartPKN4llvm4SCEVE;_ZL15isRemainderZeroPKN4llvm12SCEVConstantES2_;_ZL17BanerjeeSuccesses;_ZL17DeltaApplications;_ZL17DeltaIndependence;_ZL17DeltaPropagations;_ZL17ExactSIVsuccesses;_ZL17ceilingOfQuotientRKN4llvm5APIntES2_;_ZL17getPointerOperandPN4llvm11InstructionE;_ZL18StrongSIVsuccesses;_ZL18dumpSmallBitVectorRN4llvm14SmallBitVectorE;_ZL20BanerjeeApplications;_ZL20BanerjeeIndependence;_ZL20ExactSIVapplications;_ZL20ExactSIVindependence;_ZL20WeakZeroSIVsuccesses;_ZL21CoupledSubscriptPairs;_ZL21ExactRDIVapplications;_ZL21ExactRDIVindependence;_ZL21StrongSIVapplications;_ZL21StrongSIVindependence;_ZL21dumpExampleDependenceRN4llvm11raw_ostreamEPNS_14DependenceInfoE;_ZL22underlyingObjectsAliasPN4llvm9AAResultsERKNS_10DataLayoutEPKNS_5ValueES7_;_ZL23NonlinearSubscriptPairs;_ZL23SeparableSubscriptPairs;_ZL23WeakZeroSIVapplications;_ZL23WeakZeroSIVindependence;_ZL24SymbolicRDIVapplications;_ZL24SymbolicRDIVindependence;_ZL24WeakCrossingSIVsuccesses;_ZL27WeakCrossingSIVapplications;_ZL27WeakCrossingSIVindependence;_ZL47InitializeDependenceAnalysisWrapperPassPassFlag;_ZL47initializeDependenceAnalysisWrapperPassPassOnceRN4llvm12PassRegistryE;_ZL7findGCDjRKN4llvm5APIntES2_S2_RS0_S3_S3_;_ZL8maxAPIntN4llvm5APIntES0_;_ZL8minAPIntN4llvm5APIntES0_; -static-type=DependenceAnalysisStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class DependenceAnalysisStatics {


//===----------------------------------------------------------------------===//
// statistics
//<editor-fold defaultstate="collapsed" desc="TotalArrayPairs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 77,
 FQN="TotalArrayPairs", NM="_ZL15TotalArrayPairs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15TotalArrayPairs")
//</editor-fold>
public static Statistic TotalArrayPairs = new Statistic($("da"), $("TotalArrayPairs"), $("Array pairs tested"), 0, false);
//<editor-fold defaultstate="collapsed" desc="SeparableSubscriptPairs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 78,
 FQN="SeparableSubscriptPairs", NM="_ZL23SeparableSubscriptPairs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL23SeparableSubscriptPairs")
//</editor-fold>
public static Statistic SeparableSubscriptPairs = new Statistic($("da"), $("SeparableSubscriptPairs"), $("Separable subscript pairs"), 0, false);
//<editor-fold defaultstate="collapsed" desc="CoupledSubscriptPairs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 79,
 FQN="CoupledSubscriptPairs", NM="_ZL21CoupledSubscriptPairs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL21CoupledSubscriptPairs")
//</editor-fold>
public static Statistic CoupledSubscriptPairs = new Statistic($("da"), $("CoupledSubscriptPairs"), $("Coupled subscript pairs"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NonlinearSubscriptPairs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 80,
 FQN="NonlinearSubscriptPairs", NM="_ZL23NonlinearSubscriptPairs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL23NonlinearSubscriptPairs")
//</editor-fold>
public static Statistic NonlinearSubscriptPairs = new Statistic($("da"), $("NonlinearSubscriptPairs"), $("Nonlinear subscript pairs"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ZIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 81,
 FQN="ZIVapplications", NM="_ZL15ZIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15ZIVapplications")
//</editor-fold>
public static Statistic ZIVapplications = new Statistic($("da"), $("ZIVapplications"), $("ZIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ZIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 82,
 FQN="ZIVindependence", NM="_ZL15ZIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15ZIVindependence")
//</editor-fold>
public static Statistic ZIVindependence = new Statistic($("da"), $("ZIVindependence"), $("ZIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="StrongSIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 83,
 FQN="StrongSIVapplications", NM="_ZL21StrongSIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL21StrongSIVapplications")
//</editor-fold>
public static Statistic StrongSIVapplications = new Statistic($("da"), $("StrongSIVapplications"), $("Strong SIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="StrongSIVsuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 84,
 FQN="StrongSIVsuccesses", NM="_ZL18StrongSIVsuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL18StrongSIVsuccesses")
//</editor-fold>
public static Statistic StrongSIVsuccesses = new Statistic($("da"), $("StrongSIVsuccesses"), $("Strong SIV successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="StrongSIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 85,
 FQN="StrongSIVindependence", NM="_ZL21StrongSIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL21StrongSIVindependence")
//</editor-fold>
public static Statistic StrongSIVindependence = new Statistic($("da"), $("StrongSIVindependence"), $("Strong SIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="WeakCrossingSIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 86,
 FQN="WeakCrossingSIVapplications", NM="_ZL27WeakCrossingSIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL27WeakCrossingSIVapplications")
//</editor-fold>
public static Statistic WeakCrossingSIVapplications = new Statistic($("da"), $("WeakCrossingSIVapplications"), $("Weak-Crossing SIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="WeakCrossingSIVsuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 87,
 FQN="WeakCrossingSIVsuccesses", NM="_ZL24WeakCrossingSIVsuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL24WeakCrossingSIVsuccesses")
//</editor-fold>
public static Statistic WeakCrossingSIVsuccesses = new Statistic($("da"), $("WeakCrossingSIVsuccesses"), $("Weak-Crossing SIV successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="WeakCrossingSIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 88,
 FQN="WeakCrossingSIVindependence", NM="_ZL27WeakCrossingSIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL27WeakCrossingSIVindependence")
//</editor-fold>
public static Statistic WeakCrossingSIVindependence = new Statistic($("da"), $("WeakCrossingSIVindependence"), $("Weak-Crossing SIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ExactSIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 89,
 FQN="ExactSIVapplications", NM="_ZL20ExactSIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL20ExactSIVapplications")
//</editor-fold>
public static Statistic ExactSIVapplications = new Statistic($("da"), $("ExactSIVapplications"), $("Exact SIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ExactSIVsuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 90,
 FQN="ExactSIVsuccesses", NM="_ZL17ExactSIVsuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17ExactSIVsuccesses")
//</editor-fold>
public static Statistic ExactSIVsuccesses = new Statistic($("da"), $("ExactSIVsuccesses"), $("Exact SIV successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ExactSIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 91,
 FQN="ExactSIVindependence", NM="_ZL20ExactSIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL20ExactSIVindependence")
//</editor-fold>
public static Statistic ExactSIVindependence = new Statistic($("da"), $("ExactSIVindependence"), $("Exact SIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="WeakZeroSIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 92,
 FQN="WeakZeroSIVapplications", NM="_ZL23WeakZeroSIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL23WeakZeroSIVapplications")
//</editor-fold>
public static Statistic WeakZeroSIVapplications = new Statistic($("da"), $("WeakZeroSIVapplications"), $("Weak-Zero SIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="WeakZeroSIVsuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 93,
 FQN="WeakZeroSIVsuccesses", NM="_ZL20WeakZeroSIVsuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL20WeakZeroSIVsuccesses")
//</editor-fold>
public static Statistic WeakZeroSIVsuccesses = new Statistic($("da"), $("WeakZeroSIVsuccesses"), $("Weak-Zero SIV successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="WeakZeroSIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 94,
 FQN="WeakZeroSIVindependence", NM="_ZL23WeakZeroSIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL23WeakZeroSIVindependence")
//</editor-fold>
public static Statistic WeakZeroSIVindependence = new Statistic($("da"), $("WeakZeroSIVindependence"), $("Weak-Zero SIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ExactRDIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 95,
 FQN="ExactRDIVapplications", NM="_ZL21ExactRDIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL21ExactRDIVapplications")
//</editor-fold>
public static Statistic ExactRDIVapplications = new Statistic($("da"), $("ExactRDIVapplications"), $("Exact RDIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ExactRDIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 96,
 FQN="ExactRDIVindependence", NM="_ZL21ExactRDIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL21ExactRDIVindependence")
//</editor-fold>
public static Statistic ExactRDIVindependence = new Statistic($("da"), $("ExactRDIVindependence"), $("Exact RDIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="SymbolicRDIVapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 97,
 FQN="SymbolicRDIVapplications", NM="_ZL24SymbolicRDIVapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL24SymbolicRDIVapplications")
//</editor-fold>
public static Statistic SymbolicRDIVapplications = new Statistic($("da"), $("SymbolicRDIVapplications"), $("Symbolic RDIV applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="SymbolicRDIVindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 98,
 FQN="SymbolicRDIVindependence", NM="_ZL24SymbolicRDIVindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL24SymbolicRDIVindependence")
//</editor-fold>
public static Statistic SymbolicRDIVindependence = new Statistic($("da"), $("SymbolicRDIVindependence"), $("Symbolic RDIV independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="DeltaApplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 99,
 FQN="DeltaApplications", NM="_ZL17DeltaApplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17DeltaApplications")
//</editor-fold>
public static Statistic DeltaApplications = new Statistic($("da"), $("DeltaApplications"), $("Delta applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="DeltaSuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 100,
 FQN="DeltaSuccesses", NM="_ZL14DeltaSuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL14DeltaSuccesses")
//</editor-fold>
public static Statistic DeltaSuccesses = new Statistic($("da"), $("DeltaSuccesses"), $("Delta successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="DeltaIndependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 101,
 FQN="DeltaIndependence", NM="_ZL17DeltaIndependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17DeltaIndependence")
//</editor-fold>
public static Statistic DeltaIndependence = new Statistic($("da"), $("DeltaIndependence"), $("Delta independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="DeltaPropagations">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 102,
 FQN="DeltaPropagations", NM="_ZL17DeltaPropagations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17DeltaPropagations")
//</editor-fold>
public static Statistic DeltaPropagations = new Statistic($("da"), $("DeltaPropagations"), $("Delta propagations"), 0, false);
//<editor-fold defaultstate="collapsed" desc="GCDapplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 103,
 FQN="GCDapplications", NM="_ZL15GCDapplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15GCDapplications")
//</editor-fold>
public static Statistic GCDapplications = new Statistic($("da"), $("GCDapplications"), $("GCD applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="GCDsuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 104,
 FQN="GCDsuccesses", NM="_ZL12GCDsuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL12GCDsuccesses")
//</editor-fold>
public static Statistic GCDsuccesses = new Statistic($("da"), $("GCDsuccesses"), $("GCD successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="GCDindependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 105,
 FQN="GCDindependence", NM="_ZL15GCDindependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15GCDindependence")
//</editor-fold>
public static Statistic GCDindependence = new Statistic($("da"), $("GCDindependence"), $("GCD independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="BanerjeeApplications">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 106,
 FQN="BanerjeeApplications", NM="_ZL20BanerjeeApplications",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL20BanerjeeApplications")
//</editor-fold>
public static Statistic BanerjeeApplications = new Statistic($("da"), $("BanerjeeApplications"), $("Banerjee applications"), 0, false);
//<editor-fold defaultstate="collapsed" desc="BanerjeeIndependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 107,
 FQN="BanerjeeIndependence", NM="_ZL20BanerjeeIndependence",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL20BanerjeeIndependence")
//</editor-fold>
public static Statistic BanerjeeIndependence = new Statistic($("da"), $("BanerjeeIndependence"), $("Banerjee independence"), 0, false);
//<editor-fold defaultstate="collapsed" desc="BanerjeeSuccesses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 108,
 FQN="BanerjeeSuccesses", NM="_ZL17BanerjeeSuccesses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17BanerjeeSuccesses")
//</editor-fold>
public static Statistic BanerjeeSuccesses = new Statistic($("da"), $("BanerjeeSuccesses"), $("Banerjee successes"), 0, false);
//<editor-fold defaultstate="collapsed" desc="Delinearize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 110,
 FQN="Delinearize", NM="_ZL11Delinearize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL11Delinearize")
//</editor-fold>
public static optBool Delinearize/*J*/= new optBool($("da-delinearize"), ClGlobals.init(false), OptionHidden.Hidden, NumOccurrencesFlag.ZeroOrMore, 
    new desc($("Try to delinearize array references.")));
//<editor-fold defaultstate="collapsed" desc="initializeDependenceAnalysisWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 127,
 FQN="initializeDependenceAnalysisWrapperPassPassOnce", NM="_ZL47initializeDependenceAnalysisWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL47initializeDependenceAnalysisWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeDependenceAnalysisWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeDependenceAnalysisWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 132,
 FQN="InitializeDependenceAnalysisWrapperPassPassFlag", NM="_ZL47InitializeDependenceAnalysisWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL47InitializeDependenceAnalysisWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeDependenceAnalysisWrapperPassPassFlag/*J*/= new std.once_flag();

// Used to test the dependence analyzer.
// Looks through the function, noting loads and stores.
// Calls depends() on every possible pair and prints out the result.
// Ignores all other instructions.
//<editor-fold defaultstate="collapsed" desc="dumpExampleDependence">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 165,
 FQN="dumpExampleDependence", NM="_ZL21dumpExampleDependenceRN4llvm11raw_ostreamEPNS_14DependenceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL21dumpExampleDependenceRN4llvm11raw_ostreamEPNS_14DependenceInfoE")
//</editor-fold>
public static void dumpExampleDependence(final raw_ostream /*&*/ OS, DependenceInfo /*P*/ DA) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="underlyingObjectsAlias">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 624,
 FQN="underlyingObjectsAlias", NM="_ZL22underlyingObjectsAliasPN4llvm9AAResultsERKNS_10DataLayoutEPKNS_5ValueES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL22underlyingObjectsAliasPN4llvm9AAResultsERKNS_10DataLayoutEPKNS_5ValueES7_")
//</editor-fold>
public static AliasResult underlyingObjectsAlias(AAResults /*P*/ AA, 
                      final /*const*/ DataLayout /*&*/ DL, /*const*/ Value /*P*/ A, 
                      /*const*/ Value /*P*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Returns true if the load or store can be analyzed. Atomic and volatile
// operations have properties which this analysis does not understand.
//<editor-fold defaultstate="collapsed" desc="isLoadOrStore">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 636,
 FQN="isLoadOrStore", NM="_ZL13isLoadOrStorePKN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL13isLoadOrStorePKN4llvm11InstructionE")
//</editor-fold>
public static boolean isLoadOrStore(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getPointerOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 646,
 FQN="getPointerOperand", NM="_ZL17getPointerOperandPN4llvm11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17getPointerOperandPN4llvm11InstructionE")
//</editor-fold>
public static Value /*P*/ getPointerOperand(Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Kirch's algorithm, from
//
//        Optimizing Supercompilers for Supercomputers
//        Michael Wolfe
//        MIT Press, 1989
//
// Program 2.1, page 29.
// Computes the GCD of AM and BM.
// Also finds a solution to the equation ax - by = gcd(a, b).
// Returns true if dependence disproved; i.e., gcd does not divide Delta.
//<editor-fold defaultstate="collapsed" desc="findGCD">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1329,
 FQN="findGCD", NM="_ZL7findGCDjRKN4llvm5APIntES2_S2_RS0_S3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL7findGCDjRKN4llvm5APIntES2_S2_RS0_S3_S3_")
//</editor-fold>
public static boolean findGCD(/*uint*/int Bits, final /*const*/ APInt /*&*/ AM, final /*const*/ APInt /*&*/ BM, 
       final /*const*/ APInt /*&*/ Delta, final APInt /*&*/ G, final APInt /*&*/ X, final APInt /*&*/ Y) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="floorOfQuotient">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1359,
 FQN="floorOfQuotient", NM="_ZL15floorOfQuotientRKN4llvm5APIntES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15floorOfQuotientRKN4llvm5APIntES2_")
//</editor-fold>
public static APInt floorOfQuotient(final /*const*/ APInt /*&*/ A, final /*const*/ APInt /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="ceilingOfQuotient">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1372,
 FQN="ceilingOfQuotient", NM="_ZL17ceilingOfQuotientRKN4llvm5APIntES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL17ceilingOfQuotientRKN4llvm5APIntES2_")
//</editor-fold>
public static APInt ceilingOfQuotient(final /*const*/ APInt /*&*/ A, final /*const*/ APInt /*&*/ B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="maxAPInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1386,
 FQN="maxAPInt", NM="_ZL8maxAPIntN4llvm5APIntES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL8maxAPIntN4llvm5APIntES0_")
//</editor-fold>
public static APInt maxAPInt(APInt A, APInt B) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="minAPInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1392,
 FQN="minAPInt", NM="_ZL8minAPIntN4llvm5APIntES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL8minAPIntN4llvm5APIntES0_")
//</editor-fold>
public static APInt minAPInt(APInt A, APInt B) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Return true if the divisor evenly divides the dividend.
//<editor-fold defaultstate="collapsed" desc="isRemainderZero">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 1582,
 FQN="isRemainderZero", NM="_ZL15isRemainderZeroPKN4llvm12SCEVConstantES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15isRemainderZeroPKN4llvm12SCEVConstantES2_")
//</editor-fold>
public static boolean isRemainderZero(/*const*/ SCEVConstant /*P*/ Dividend, 
               /*const*/ SCEVConstant /*P*/ Divisor) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Given a product, e.g., 10*X*Y, returns the first constant operand,
// in this case 10. If there is no constant part, returns NULL.
//<editor-fold defaultstate="collapsed" desc="getConstantPart">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 2220,
 FQN="getConstantPart", NM="_ZL15getConstantPartPKN4llvm4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL15getConstantPartPKN4llvm4SCEVE")
//</editor-fold>
public static /*const*/ SCEVConstant /*P*/ getConstantPart(/*const*/ SCEV /*P*/ Expr) {
  throw new UnsupportedOperationException("EmptyBody");
}

// For debugging purposes, dump a small bit vector to dbgs().
//<editor-fold defaultstate="collapsed" desc="dumpSmallBitVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 3266,
 FQN="dumpSmallBitVector", NM="_ZL18dumpSmallBitVectorRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZL18dumpSmallBitVectorRN4llvm14SmallBitVectorE")
//</editor-fold>
public static void dumpSmallBitVector(final SmallBitVector /*&*/ BV) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class DependenceAnalysisStatics
