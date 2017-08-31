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


//<editor-fold defaultstate="collapsed" desc="static type GlobalsModRefStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.GlobalsModRefStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL17NumNoMemFunctions;_ZL19NumReadMemFunctions;_ZL21NumIndirectGlobalVars;_ZL24NumNonAddrTakenFunctions;_ZL25NumNonAddrTakenGlobalVars;_ZL34isNonEscapingGlobalNoAliasWithLoadPKN4llvm11GlobalValueEPKNS_5ValueERiRKNS_10DataLayoutE;_ZL37EnableUnsafeGlobalsModRefAliasResults;_ZL38InitializeGlobalsAAWrapperPassPassFlag;_ZL38initializeGlobalsAAWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=GlobalsModRefStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class GlobalsModRefStatics {

//<editor-fold defaultstate="collapsed" desc="NumNonAddrTakenGlobalVars">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 35,
 FQN="NumNonAddrTakenGlobalVars", NM="_ZL25NumNonAddrTakenGlobalVars",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL25NumNonAddrTakenGlobalVars")
//</editor-fold>
public static Statistic NumNonAddrTakenGlobalVars = new Statistic($("globalsmodref-aa"), $("NumNonAddrTakenGlobalVars"), $("Number of global vars without address taken"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumNonAddrTakenFunctions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 37,
 FQN="NumNonAddrTakenFunctions", NM="_ZL24NumNonAddrTakenFunctions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL24NumNonAddrTakenFunctions")
//</editor-fold>
public static Statistic NumNonAddrTakenFunctions = new Statistic($("globalsmodref-aa"), $("NumNonAddrTakenFunctions"), $("Number of functions without address taken"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumNoMemFunctions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 38,
 FQN="NumNoMemFunctions", NM="_ZL17NumNoMemFunctions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL17NumNoMemFunctions")
//</editor-fold>
public static Statistic NumNoMemFunctions = new Statistic($("globalsmodref-aa"), $("NumNoMemFunctions"), $("Number of functions that do not access memory"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumReadMemFunctions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 39,
 FQN="NumReadMemFunctions", NM="_ZL19NumReadMemFunctions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL19NumReadMemFunctions")
//</editor-fold>
public static Statistic NumReadMemFunctions = new Statistic($("globalsmodref-aa"), $("NumReadMemFunctions"), $("Number of functions that only read memory"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumIndirectGlobalVars">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 40,
 FQN="NumIndirectGlobalVars", NM="_ZL21NumIndirectGlobalVars",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL21NumIndirectGlobalVars")
//</editor-fold>
public static Statistic NumIndirectGlobalVars = new Statistic($("globalsmodref-aa"), $("NumIndirectGlobalVars"), $("Number of indirect global objects"), 0, false);

// An option to enable unsafe alias results from the GlobalsModRef analysis.
// When enabled, GlobalsModRef will provide no-alias results which in extremely
// rare cases may not be conservatively correct. In particular, in the face of
// transforms which cause assymetry between how effective GetUnderlyingObject
// is for two pointers, it may produce incorrect results.
//
// These unsafe results have been returned by GMR for many years without
// causing significant issues in the wild and so we provide a mechanism to
// re-enable them for users of LLVM that have a particular performance
// sensitivity and no known issues. The option also makes it easy to evaluate
// the performance impact of these results.
//<editor-fold defaultstate="collapsed" desc="EnableUnsafeGlobalsModRefAliasResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 53,
 FQN="EnableUnsafeGlobalsModRefAliasResults", NM="_ZL37EnableUnsafeGlobalsModRefAliasResults",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL37EnableUnsafeGlobalsModRefAliasResults")
//</editor-fold>
public static optBool EnableUnsafeGlobalsModRefAliasResults/*J*/= new optBool($("enable-unsafe-globalsmodref-alias-results"), init(false), OptionHidden.Hidden);

// GV is a non-escaping global. V is a pointer address that has been loaded from.
// If we can prove that V must escape, we can conclude that a load from V cannot
// alias GV.
//<editor-fold defaultstate="collapsed" desc="isNonEscapingGlobalNoAliasWithLoad">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 593,
 FQN="isNonEscapingGlobalNoAliasWithLoad", NM="_ZL34isNonEscapingGlobalNoAliasWithLoadPKN4llvm11GlobalValueEPKNS_5ValueERiRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL34isNonEscapingGlobalNoAliasWithLoadPKN4llvm11GlobalValueEPKNS_5ValueERiRKNS_10DataLayoutE")
//</editor-fold>
public static boolean isNonEscapingGlobalNoAliasWithLoad(/*const*/ GlobalValue /*P*/ GV, 
                                  /*const*/ Value /*P*/ V, 
                                  final int$ref/*int &*/ Depth, 
                                  final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeGlobalsAAWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 949,
 FQN="initializeGlobalsAAWrapperPassPassOnce", NM="_ZL38initializeGlobalsAAWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL38initializeGlobalsAAWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeGlobalsAAWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeGlobalsAAWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 953,
 FQN="InitializeGlobalsAAWrapperPassPassFlag", NM="_ZL38InitializeGlobalsAAWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZL38InitializeGlobalsAAWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeGlobalsAAWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class GlobalsModRefStatics
