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
package org.llvm.transforms.ipo.impl;

import org.llvm.cl.aliases.optBool;
import org.llvm.cl.aliases.optUInt;
import org.llvm.cl.aliases.optFloat;
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
import org.llvm.cl.OptionHidden;
import org.llvm.cl.*;
import org.llvm.cl.desc;
import org.llvm.cl.value_desc;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.transforms.java.TransformDummies.*;


//<editor-fold defaultstate="collapsed" desc="static type FunctionImportStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.transforms.ipo.impl.FunctionImportStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL11NumImported;_ZL11SummaryFileB5cxx11;_ZL12PrintImports;_ZL16ImportInstrLimit;_ZL17ImportInstrFactor;_ZL17diagnosticHandlerRKN4llvm14DiagnosticInfoE;_ZL20EnableImportMetadata;_ZL28getModuleSummaryIndexForFileN4llvm9StringRefERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKSt8functionIFvRKNS_14DiagnosticInfoEEE;_ZL36InitializeFunctionImportPassPassFlag;_ZL36initializeFunctionImportPassPassOnceRN4llvm12PassRegistryE;_ZL43DontForceImportReferencedDiscardableSymbols;_ZL8loadFileRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERN4llvm11LLVMContextE;_ZN12_GLOBAL__N_1L12selectCalleeERKN4llvm18ModuleSummaryIndexERKSt6vectorISt10unique_ptrINS0_18GlobalValueSummaryESt14default_deleteIS6_EESaIS9_EEj;_ZN12_GLOBAL__N_1L12selectCalleeEyjRKN4llvm18ModuleSummaryIndexE;_ZN12_GLOBAL__N_1L17eligibleForImportERKN4llvm18ModuleSummaryIndexERKNS0_18GlobalValueSummaryE;_ZN12_GLOBAL__N_1L20exportGlobalInModuleERKN4llvm18ModuleSummaryIndexENS0_9StringRefEyRSt13unordered_setIySt4hashIyESt8equal_toIyESaIyEE;_ZN12_GLOBAL__N_1L22ComputeImportForModuleERKSt3mapIyPN4llvm18GlobalValueSummaryESt4lessIyESaISt4pairIKyS3_EEERKNS1_18ModuleSummaryIndexERNS1_9StringMapIS0_IyjS5_SaIS6_IS7_jEEENS1_15MallocAllocatorEEEPNSG_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESK_EE;_ZN12_GLOBAL__N_1L24computeImportForFunctionERKN4llvm15FunctionSummaryERKNS0_18ModuleSummaryIndexEjRKSt3mapIyPNS0_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS9_EEERNS0_15SmallVectorImplISC_IPS2_jEEERNS0_9StringMapIS7_IyjSB_SaISC_ISD_jEEENS0_15MallocAllocatorEEEPNSO_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESS_EE;_ZN12_GLOBAL__N_1L25canBeExternallyReferencedERKN4llvm18GlobalValueSummaryE;_ZN12_GLOBAL__N_1L25canBeExternallyReferencedERKN4llvm18ModuleSummaryIndexEy; -static-type=FunctionImportStatics -package=org.llvm.transforms.ipo.impl")
//</editor-fold>
public final class FunctionImportStatics {

//<editor-fold defaultstate="collapsed" desc="NumImported">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 38,
 FQN="NumImported", NM="_ZL11NumImported",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL11NumImported")
//</editor-fold>
public static Statistic NumImported = new Statistic($("function-import"), $("NumImported"), $("Number of functions imported"), 0, false);

/// Limit on instruction count of imported functions.
//<editor-fold defaultstate="collapsed" desc="ImportInstrLimit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 41,
 FQN="ImportInstrLimit", NM="_ZL16ImportInstrLimit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL16ImportInstrLimit")
//</editor-fold>
public static optUInt ImportInstrLimit/*J*/= new optUInt($("import-instr-limit"), ClGlobals.init(100), OptionHidden.Hidden, new value_desc($N), 
    new desc($("Only import functions with less than N instructions")));
//<editor-fold defaultstate="collapsed" desc="ImportInstrFactor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 45,
 FQN="ImportInstrFactor", NM="_ZL17ImportInstrFactor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL17ImportInstrFactor")
//</editor-fold>
public static optFloat ImportInstrFactor/*J*/= new optFloat($("import-instr-evolution-factor"), ClGlobals.init(0.69999999999999996), 
    OptionHidden.Hidden, new value_desc($x), 
    new desc($("As we import functions, multiply the `import-instr-limit` threshold by this factor before processing newly imported functions")));
//<editor-fold defaultstate="collapsed" desc="PrintImports">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 52,
 FQN="PrintImports", NM="_ZL12PrintImports",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL12PrintImports")
//</editor-fold>
public static optBool PrintImports/*J*/= new optBool($("print-imports"), ClGlobals.init(false), OptionHidden.Hidden, 
    new desc($("Print imported functions")));

// Temporary allows the function import pass to disable always linking
// referenced discardable symbols.
//<editor-fold defaultstate="collapsed" desc="DontForceImportReferencedDiscardableSymbols">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 57,
 FQN="DontForceImportReferencedDiscardableSymbols", NM="_ZL43DontForceImportReferencedDiscardableSymbols",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL43DontForceImportReferencedDiscardableSymbols")
//</editor-fold>
public static optBool DontForceImportReferencedDiscardableSymbols/*J*/= new optBool($("disable-force-link-odr"), 
    ClGlobals.init(false), OptionHidden.Hidden);
//<editor-fold defaultstate="collapsed" desc="EnableImportMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 61,
 FQN="EnableImportMetadata", NM="_ZL20EnableImportMetadata",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL20EnableImportMetadata")
//</editor-fold>
public static optBool EnableImportMetadata/*J*/= new optBool($("enable-import-metadata"), ClGlobals.init(true/*Enabled with asserts.*/), 
    OptionHidden.Hidden, new desc($("Enable import metadata like 'thinlto_src_module'")));

// Return true if the Summary describes a GlobalValue that can be externally
// referenced, i.e. it does not need renaming (linkage is not local) or renaming
// is possible (does not have a section for instance).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::canBeExternallyReferenced">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 94,
 FQN="(anonymous namespace)::canBeExternallyReferenced", NM="_ZN12_GLOBAL__N_1L25canBeExternallyReferencedERKN4llvm18GlobalValueSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L25canBeExternallyReferencedERKN4llvm18GlobalValueSummaryE")
//</editor-fold>
public static boolean canBeExternallyReferenced(final /*const*/ GlobalValueSummary /*&*/ Summary) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Return true if \p GUID describes a GlobalValue that can be externally
// referenced, i.e. it does not need renaming (linkage is not local) or
// renaming is possible (does not have a section for instance).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::canBeExternallyReferenced">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 108,
 FQN="(anonymous namespace)::canBeExternallyReferenced", NM="_ZN12_GLOBAL__N_1L25canBeExternallyReferencedERKN4llvm18ModuleSummaryIndexEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L25canBeExternallyReferencedERKN4llvm18ModuleSummaryIndexEy")
//</editor-fold>
public static boolean canBeExternallyReferenced(final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                         long/*uint64_t*/ GUID) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Return true if the global described by \p Summary can be imported in another
// module.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::eligibleForImport">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 126,
 FQN="(anonymous namespace)::eligibleForImport", NM="_ZN12_GLOBAL__N_1L17eligibleForImportERKN4llvm18ModuleSummaryIndexERKNS0_18GlobalValueSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L17eligibleForImportERKN4llvm18ModuleSummaryIndexERKNS0_18GlobalValueSummaryE")
//</editor-fold>
public static boolean eligibleForImport(final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                 final /*const*/ GlobalValueSummary /*&*/ Summary) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given a list of possible callee implementation for a call site, select one
/// that fits the \p Threshold.
///
/// FIXME: select "best" instead of first that fits. But what is "best"?
/// - The smallest: more likely to be inlined.
/// - The one with the least outgoing edges (already well optimized).
/// - One from a module already being imported from in order to reduce the
///   number of source modules parsed/linked.
/// - One that has PGO data attached.
/// - [insert you fancy metric here]
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::selectCallee">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 164,
 FQN="(anonymous namespace)::selectCallee", NM="_ZN12_GLOBAL__N_1L12selectCalleeERKN4llvm18ModuleSummaryIndexERKSt6vectorISt10unique_ptrINS0_18GlobalValueSummaryESt14default_deleteIS6_EESaIS9_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L12selectCalleeERKN4llvm18ModuleSummaryIndexERKSt6vectorISt10unique_ptrINS0_18GlobalValueSummaryESt14default_deleteIS6_EESaIS9_EEj")
//</editor-fold>
public static /*const*/ GlobalValueSummary /*P*/ selectCallee(final /*const*/ ModuleSummaryIndex /*&*/ Index, 
            final /*const*/std.vector<std.unique_ptr<GlobalValueSummary>> /*&*/ CalleeSummaryList, 
            /*uint*/int Threshold) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the summary for the function \p GUID that fits the \p Threshold, or
/// null if there's no match.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::selectCallee">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 204,
 FQN="(anonymous namespace)::selectCallee", NM="_ZN12_GLOBAL__N_1L12selectCalleeEyjRKN4llvm18ModuleSummaryIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L12selectCalleeEyjRKN4llvm18ModuleSummaryIndexE")
//</editor-fold>
public static /*const*/ GlobalValueSummary /*P*/ selectCallee(long/*uint64_t*/ GUID, 
            /*uint*/int Threshold, 
            final /*const*/ ModuleSummaryIndex /*&*/ Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Mark the global \p GUID as export by module \p ExportModulePath if found in
/// this module. If it is a GlobalVariable, we also mark any referenced global
/// in the current module as exported.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::exportGlobalInModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 216,
 FQN="(anonymous namespace)::exportGlobalInModule", NM="_ZN12_GLOBAL__N_1L20exportGlobalInModuleERKN4llvm18ModuleSummaryIndexENS0_9StringRefEyRSt13unordered_setIySt4hashIyESt8equal_toIyESaIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L20exportGlobalInModuleERKN4llvm18ModuleSummaryIndexENS0_9StringRefEyRSt13unordered_setIySt4hashIyESt8equal_toIyESaIyEE")
//</editor-fold>
public static void exportGlobalInModule(final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                    StringRef ExportModulePath, 
                    long/*uint64_t*/ GUID, 
                    final std.unordered_setULong/*uint64_t*/ /*&*/ ExportList) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Compute the list of functions to import for a given caller. Mark these
/// imported functions and the symbols they reference in their source module as
/// exported from their source module.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::computeImportForFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 265,
 FQN="(anonymous namespace)::computeImportForFunction", NM="_ZN12_GLOBAL__N_1L24computeImportForFunctionERKN4llvm15FunctionSummaryERKNS0_18ModuleSummaryIndexEjRKSt3mapIyPNS0_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS9_EEERNS0_15SmallVectorImplISC_IPS2_jEEERNS0_9StringMapIS7_IyjSB_SaISC_ISD_jEEENS0_15MallocAllocatorEEEPNSO_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESS_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L24computeImportForFunctionERKN4llvm15FunctionSummaryERKNS0_18ModuleSummaryIndexEjRKSt3mapIyPNS0_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS9_EEERNS0_15SmallVectorImplISC_IPS2_jEEERNS0_9StringMapIS7_IyjSB_SaISC_ISD_jEEENS0_15MallocAllocatorEEEPNSO_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESS_EE")
//</editor-fold>
public static void computeImportForFunction(final /*const*/ FunctionSummary /*&*/ Summary, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                        /*uint*/int Threshold, final /*const*/std.mapULongType<GlobalValueSummary /*P*/ /*P*/> /*&*/ DefinedGVSummaries, 
                        final SmallVectorImpl<std.pairTypeUInt</*const*/ FunctionSummary /*P*/ > > /*&*/ Worklist, 
                        final StringMap<std.mapULongUInt> /*&*/ ImportsForModule) {
  computeImportForFunction(Summary, Index, 
                        Threshold, DefinedGVSummaries, 
                        Worklist, 
                        ImportsForModule, 
                        (StringMap<std.unordered_setULong/*uint64_t*/> /*P*/)null);
}
public static void computeImportForFunction(final /*const*/ FunctionSummary /*&*/ Summary, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                        /*uint*/int Threshold, final /*const*/std.mapULongType<GlobalValueSummary /*P*/ /*P*/> /*&*/ DefinedGVSummaries, 
                        final SmallVectorImpl<std.pairTypeUInt</*const*/ FunctionSummary /*P*/ > > /*&*/ Worklist, 
                        final StringMap<std.mapULongUInt> /*&*/ ImportsForModule, 
                        StringMap<std.unordered_setULong/*uint64_t*/> /*P*/ ExportLists/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given the list of globals defined in a module, compute the list of imports
/// as well as the list of "exports", i.e. the list of symbols referenced from
/// another module (that may require promotion).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeImportForModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 336,
 FQN="(anonymous namespace)::ComputeImportForModule", NM="_ZN12_GLOBAL__N_1L22ComputeImportForModuleERKSt3mapIyPN4llvm18GlobalValueSummaryESt4lessIyESaISt4pairIKyS3_EEERKNS1_18ModuleSummaryIndexERNS1_9StringMapIS0_IyjS5_SaIS6_IS7_jEEENS1_15MallocAllocatorEEEPNSG_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESK_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN12_GLOBAL__N_1L22ComputeImportForModuleERKSt3mapIyPN4llvm18GlobalValueSummaryESt4lessIyESaISt4pairIKyS3_EEERKNS1_18ModuleSummaryIndexERNS1_9StringMapIS0_IyjS5_SaIS6_IS7_jEEENS1_15MallocAllocatorEEEPNSG_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESK_EE")
//</editor-fold>
public static void ComputeImportForModule(final /*const*/std.mapULongType<GlobalValueSummary /*P*/ /*P*/> /*&*/ DefinedGVSummaries, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                      final StringMap<std.mapULongUInt> /*&*/ ImportsForModule) {
  ComputeImportForModule(DefinedGVSummaries, Index, 
                      ImportsForModule, 
                      (StringMap<std.unordered_setULong/*uint64_t*/> /*P*/)null);
}
public static void ComputeImportForModule(final /*const*/std.mapULongType<GlobalValueSummary /*P*/ /*P*/> /*&*/ DefinedGVSummaries, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                      final StringMap<std.mapULongUInt> /*&*/ ImportsForModule, 
                      StringMap<std.unordered_setULong/*uint64_t*/> /*P*/ ExportLists/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="diagnosticHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 692,
 FQN="diagnosticHandler", NM="_ZL17diagnosticHandlerRKN4llvm14DiagnosticInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL17diagnosticHandlerRKN4llvm14DiagnosticInfoE")
//</editor-fold>
public static void diagnosticHandler(final /*const*/ DiagnosticInfo /*&*/ DI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeFunctionImportPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 785,
 FQN="initializeFunctionImportPassPassOnce", NM="_ZL36initializeFunctionImportPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL36initializeFunctionImportPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeFunctionImportPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeFunctionImportPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 787,
 FQN="InitializeFunctionImportPassPassFlag", NM="_ZL36InitializeFunctionImportPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZL36InitializeFunctionImportPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeFunctionImportPassPassFlag/*J*/= new std.once_flag();

public static Object SummaryFile(Object ... params){
  throw new UnsupportedOperationException(">>>>>>>>>>> Check Unused NM Filters >>>>>>>>>>>\n" +
"_ZL11SummaryFileB5cxx11\n" +
"_ZL28getModuleSummaryIndexForFileN4llvm9StringRefERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKSt8functionIFvRKNS_14DiagnosticInfoEEE\n" +
"_ZL8loadFileRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERN4llvm11LLVMContextE\n" +
"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
}

public static Object getModuleSummaryIndexForFile(Object ... params){
  throw new UnsupportedOperationException(">>>>>>>>>>> Check Unused NM Filters >>>>>>>>>>>\n" +
"_ZL11SummaryFileB5cxx11\n" +
"_ZL28getModuleSummaryIndexForFileN4llvm9StringRefERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKSt8functionIFvRKNS_14DiagnosticInfoEEE\n" +
"_ZL8loadFileRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERN4llvm11LLVMContextE\n" +
"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
}
public static Object loadFile(Object ... params){
  throw new UnsupportedOperationException(">>>>>>>>>>> Check Unused NM Filters >>>>>>>>>>>\n" +
"_ZL11SummaryFileB5cxx11\n" +
"_ZL28getModuleSummaryIndexForFileN4llvm9StringRefERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKSt8functionIFvRKNS_14DiagnosticInfoEEE\n" +
"_ZL8loadFileRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERN4llvm11LLVMContextE\n" +
"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
}

} // END OF class FunctionImportStatics
