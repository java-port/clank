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
import org.llvm.cl.OptionHidden;


//<editor-fold defaultstate="collapsed" desc="static type AliasAnalysisEvaluatorStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.AliasAnalysisEvaluatorStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL11PrintModRef;_ZL12PrintNoAlias;_ZL12PrintPercentxx;_ZL12PrintResultsPKcbPKN4llvm5ValueES4_PKNS1_6ModuleE;_ZL13PrintMayAlias;_ZL13PrintNoModRef;_ZL14PrintMustAlias;_ZL17PrintPartialAlias;_ZL18PrintModRefResultsPKcbN4llvm8CallSiteES2_PNS1_6ModuleE;_ZL18PrintModRefResultsPKcbPN4llvm11InstructionEPNS1_5ValueEPNS1_6ModuleE;_ZL20isInterestingPointerPN4llvm5ValueE;_ZL21PrintLoadStoreResultsPKcbPKN4llvm5ValueES4_PKNS1_6ModuleE;_ZL34InitializeAAEvalLegacyPassPassFlag;_ZL34initializeAAEvalLegacyPassPassOnceRN4llvm12PassRegistryE;_ZL8EvalAAMD;_ZL8PrintAll;_ZL8PrintMod;_ZL8PrintRef; -static-type=AliasAnalysisEvaluatorStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class AliasAnalysisEvaluatorStatics {

//<editor-fold defaultstate="collapsed" desc="PrintAll">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 26,
 FQN="PrintAll", NM="_ZL8PrintAll",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL8PrintAll")
//</editor-fold>
public static optBool PrintAll/*J*/= new optBool($("print-all-alias-modref-info"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintNoAlias">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 28,
 FQN="PrintNoAlias", NM="_ZL12PrintNoAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL12PrintNoAlias")
//</editor-fold>
public static optBool PrintNoAlias/*J*/= new optBool($("print-no-aliases"),OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintMayAlias">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 29,
 FQN="PrintMayAlias", NM="_ZL13PrintMayAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL13PrintMayAlias")
//</editor-fold>
public static optBool PrintMayAlias/*J*/= new optBool($("print-may-aliases"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintPartialAlias">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 30,
 FQN="PrintPartialAlias", NM="_ZL17PrintPartialAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL17PrintPartialAlias")
//</editor-fold>
public static optBool PrintPartialAlias/*J*/= new optBool($("print-partial-aliases"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintMustAlias">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 31,
 FQN="PrintMustAlias", NM="_ZL14PrintMustAlias",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL14PrintMustAlias")
//</editor-fold>
public static optBool PrintMustAlias/*J*/= new optBool($("print-must-aliases"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintNoModRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 33,
 FQN="PrintNoModRef", NM="_ZL13PrintNoModRef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL13PrintNoModRef")
//</editor-fold>
public static optBool PrintNoModRef/*J*/= new optBool($("print-no-modref"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintMod">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 34,
 FQN="PrintMod", NM="_ZL8PrintMod",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL8PrintMod")
//</editor-fold>
public static optBool PrintMod/*J*/= new optBool($("print-mod"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 35,
 FQN="PrintRef", NM="_ZL8PrintRef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL8PrintRef")
//</editor-fold>
public static optBool PrintRef/*J*/= new optBool($("print-ref"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintModRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 36,
 FQN="PrintModRef", NM="_ZL11PrintModRef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL11PrintModRef")
//</editor-fold>
public static optBool PrintModRef/*J*/= new optBool($("print-modref"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="EvalAAMD">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 38,
 FQN="EvalAAMD", NM="_ZL8EvalAAMD",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL8EvalAAMD")
//</editor-fold>
public static optBool EvalAAMD/*J*/= new optBool($("evaluate-aa-metadata"), OptionHidden.ReallyHidden);
//<editor-fold defaultstate="collapsed" desc="PrintResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 40,
 FQN="PrintResults", NM="_ZL12PrintResultsPKcbPKN4llvm5ValueES4_PKNS1_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL12PrintResultsPKcbPKN4llvm5ValueES4_PKNS1_6ModuleE")
//</editor-fold>
public static void PrintResults(/*const*/char$ptr/*char P*/ Msg, boolean P, /*const*/ Value /*P*/ V1, 
            /*const*/ Value /*P*/ V2, /*const*/ Module /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="PrintModRefResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 58,
 FQN="PrintModRefResults", NM="_ZL18PrintModRefResultsPKcbPN4llvm11InstructionEPNS1_5ValueEPNS1_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL18PrintModRefResultsPKcbPN4llvm11InstructionEPNS1_5ValueEPNS1_6ModuleE")
//</editor-fold>
public static /*inline*/ void PrintModRefResults(/*const*/char$ptr/*char P*/ Msg, boolean P, Instruction /*P*/ I, Value /*P*/ Ptr, 
                  Module /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="PrintModRefResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 68,
 FQN="PrintModRefResults", NM="_ZL18PrintModRefResultsPKcbN4llvm8CallSiteES2_PNS1_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL18PrintModRefResultsPKcbN4llvm8CallSiteES2_PNS1_6ModuleE")
//</editor-fold>
public static /*inline*/ void PrintModRefResults(/*const*/char$ptr/*char P*/ Msg, boolean P, CallSite CSA, CallSite CSB, 
                  Module /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="PrintLoadStoreResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 77,
 FQN="PrintLoadStoreResults", NM="_ZL21PrintLoadStoreResultsPKcbPKN4llvm5ValueES4_PKNS1_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL21PrintLoadStoreResultsPKcbPKN4llvm5ValueES4_PKNS1_6ModuleE")
//</editor-fold>
public static /*inline*/ void PrintLoadStoreResults(/*const*/char$ptr/*char P*/ Msg, boolean P, /*const*/ Value /*P*/ V1, 
                     /*const*/ Value /*P*/ V2, /*const*/ Module /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="isInterestingPointer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 86,
 FQN="isInterestingPointer", NM="_ZL20isInterestingPointerPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL20isInterestingPointerPN4llvm5ValueE")
//</editor-fold>
public static /*inline*/ boolean isInterestingPointer(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="PrintPercent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 296,
 FQN="PrintPercent", NM="_ZL12PrintPercentxx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL12PrintPercentxx")
//</editor-fold>
public static void PrintPercent(long/*int64_t*/ Num, long/*int64_t*/ Sum) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeAAEvalLegacyPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 381,
 FQN="initializeAAEvalLegacyPassPassOnce", NM="_ZL34initializeAAEvalLegacyPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL34initializeAAEvalLegacyPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeAAEvalLegacyPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeAAEvalLegacyPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 385,
 FQN="InitializeAAEvalLegacyPassPassFlag", NM="_ZL34InitializeAAEvalLegacyPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZL34InitializeAAEvalLegacyPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeAAEvalLegacyPassPassFlag/*J*/= new std.once_flag();
} // END OF class AliasAnalysisEvaluatorStatics
