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


//<editor-fold defaultstate="collapsed" desc="static type InstructionSimplifyLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm12SimplifyCallEPNS_5ValueENS_8ArrayRefIS1_EERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm12SimplifyCallEPNS_5ValueEPNS_3UseES3_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm13SimplifyBinOpEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm14SimplifyOrInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyAddInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyAndInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyCmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyFPBinOpEjPNS_5ValueES1_RKNS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyGEPInstEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyMulInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyShlInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifySubInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyXorInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyAShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFAddInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFCmpInstEjPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFDivInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFMulInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFRemInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFSubInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyICmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyLShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifySDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifySRemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyUDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyURemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm17SimplifyTruncInstEPNS_5ValueEPNS_4TypeERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm18SimplifySelectInstEPNS_5ValueES1_S1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm19SimplifyInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE;_ZN4llvm23SimplifyInsertValueInstEPNS_5ValueES1_NS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm24SimplifyExtractValueInstEPNS_5ValueENS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm26SimplifyExtractElementInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm29replaceAndRecursivelySimplifyEPNS_11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE;_ZN4llvm30recursivelySimplifyInstructionEPNS_11InstructionEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE; -static-type=InstructionSimplifyLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class InstructionSimplifyLlvmGlobals {


/// Given operands for an Add, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyAddInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 582,
 FQN="llvm::SimplifyAddInst", NM="_ZN4llvm15SimplifyAddInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyAddInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyAddInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyAddInst(Op0, Op1, isNSW, isNUW, 
               DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyAddInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyAddInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyAddInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a Sub, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySubInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 777,
 FQN="llvm::SimplifySubInst", NM="_ZN4llvm15SimplifySubInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifySubInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySubInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySubInst(Op0, Op1, isNSW, isNUW, 
               DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySubInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySubInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySubInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FAdd, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFAddInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 945,
 FQN="llvm::SimplifyFAddInst", NM="_ZN4llvm16SimplifyFAddInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyFAddInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFAddInst(Op0, Op1, FMF, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFAddInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFAddInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFAddInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FSub, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFSubInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 954,
 FQN="llvm::SimplifyFSubInst", NM="_ZN4llvm16SimplifyFSubInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyFSubInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFSubInst(Op0, Op1, FMF, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFSubInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFSubInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFSubInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FMul, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFMulInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 963,
 FQN="llvm::SimplifyFMulInst", NM="_ZN4llvm16SimplifyFMulInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyFMulInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFMulInst(Op0, Op1, FMF, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFMulInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFMulInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFMulInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a Mul, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyMulInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 972,
 FQN="llvm::SimplifyMulInst", NM="_ZN4llvm15SimplifyMulInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyMulInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyMulInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyMulInst(Op0, Op1, DL, 
               (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyMulInst(Op0, Op1, DL, 
               TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyMulInst(Op0, Op1, DL, 
               TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyMulInst(Op0, Op1, DL, 
               TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an SDiv, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySDivInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1073,
 FQN="llvm::SimplifySDivInst", NM="_ZN4llvm16SimplifySDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifySDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySDivInst(Op0, Op1, DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySDivInst(Op0, Op1, DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySDivInst(Op0, Op1, DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySDivInst(Op0, Op1, DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a UDiv, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyUDivInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1091,
 FQN="llvm::SimplifyUDivInst", NM="_ZN4llvm16SimplifyUDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyUDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyUDivInst(Op0, Op1, DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyUDivInst(Op0, Op1, DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyUDivInst(Op0, Op1, DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyUDivInst(Op0, Op1, DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FDiv, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFDivInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1133,
 FQN="llvm::SimplifyFDivInst", NM="_ZN4llvm16SimplifyFDivInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyFDivInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFDivInst(Op0, Op1, FMF, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFDivInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFDivInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFDivInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an SRem, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySRemInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1210,
 FQN="llvm::SimplifySRemInst", NM="_ZN4llvm16SimplifySRemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifySRemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySRemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySRemInst(Op0, Op1, DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySRemInst(Op0, Op1, DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySRemInst(Op0, Op1, DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySRemInst(Op0, Op1, DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a URem, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyURemInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1228,
 FQN="llvm::SimplifyURemInst", NM="_ZN4llvm16SimplifyURemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyURemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyURemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyURemInst(Op0, Op1, DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyURemInst(Op0, Op1, DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyURemInst(Op0, Op1, DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyURemInst(Op0, Op1, DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FRem, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFRemInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1255,
 FQN="llvm::SimplifyFRemInst", NM="_ZN4llvm16SimplifyFRemInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyFRemInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFRemInst(Op0, Op1, FMF, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFRemInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFRemInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFRemInst(Op0, Op1, FMF, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a Shl, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyShlInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1392,
 FQN="llvm::SimplifyShlInst", NM="_ZN4llvm15SimplifyShlInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyShlInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW, 
               DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW, 
               DL, TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a LShr, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyLShrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1416,
 FQN="llvm::SimplifyLShrInst", NM="_ZN4llvm16SimplifyLShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyLShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyLShrInst(Op0, Op1, isExact, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyLShrInst(Op0, Op1, isExact, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyLShrInst(Op0, Op1, isExact, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyLShrInst(Op0, Op1, isExact, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a AShr, fold the result or return nulll.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyAShrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1450,
 FQN="llvm::SimplifyAShrInst", NM="_ZN4llvm16SimplifyAShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyAShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyAShrInst(Op0, Op1, isExact, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyAShrInst(Op0, Op1, isExact, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyAShrInst(Op0, Op1, isExact, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyAShrInst(Op0, Op1, isExact, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an And, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyAndInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1675,
 FQN="llvm::SimplifyAndInst", NM="_ZN4llvm15SimplifyAndInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyAndInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyAndInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyAndInst(Op0, Op1, DL, 
               (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyAndInst(Op0, Op1, DL, 
               TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyAndInst(Op0, Op1, DL, 
               TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyAndInst(Op0, Op1, DL, 
               TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an Or, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyOrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1860,
 FQN="llvm::SimplifyOrInst", NM="_ZN4llvm14SimplifyOrInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm14SimplifyOrInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyOrInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyOrInst(Op0, Op1, DL, 
              (/*const*/ TargetLibraryInfo /*P*/ )null, 
              (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyOrInst(Op0, Op1, DL, 
              TLI, 
              (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyOrInst(Op0, Op1, DL, 
              TLI, 
              DT, (AssumptionCache /*P*/ )null, 
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
              /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyOrInst(Op0, Op1, DL, 
              TLI, 
              DT, AC, 
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
              /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
              /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an Xor, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyXorInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1914,
 FQN="llvm::SimplifyXorInst", NM="_ZN4llvm15SimplifyXorInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyXorInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyXorInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyXorInst(Op0, Op1, DL, 
               (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyXorInst(Op0, Op1, DL, 
               TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyXorInst(Op0, Op1, DL, 
               TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyXorInst(Op0, Op1, DL, 
               TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an ICmpInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyICmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3151,
 FQN="llvm::SimplifyICmpInst", NM="_ZN4llvm16SimplifyICmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyICmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyICmpInst(Predicate, LHS, RHS, 
                DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyICmpInst(Predicate, LHS, RHS, 
                DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyICmpInst(Predicate, LHS, RHS, 
                DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyICmpInst(Predicate, LHS, RHS, 
                DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FCmpInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFCmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3283,
 FQN="llvm::SimplifyFCmpInst", NM="_ZN4llvm16SimplifyFCmpInstEjPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm16SimplifyFCmpInstEjPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFCmpInst(Predicate, LHS, RHS, 
                FMF, DL, 
                (/*const*/ TargetLibraryInfo /*P*/ )null, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFCmpInst(Predicate, LHS, RHS, 
                FMF, DL, 
                TLI, 
                (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFCmpInst(Predicate, LHS, RHS, 
                FMF, DL, 
                TLI, 
                DT, (AssumptionCache /*P*/ )null, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFCmpInst(Predicate, LHS, RHS, 
                FMF, DL, 
                TLI, 
                DT, AC, 
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a SelectInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySelectInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3506,
 FQN="llvm::SimplifySelectInst", NM="_ZN4llvm18SimplifySelectInstEPNS_5ValueES1_S1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm18SimplifySelectInstEPNS_5ValueES1_S1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal, 
                  final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal, 
                  DL, 
                  (/*const*/ TargetLibraryInfo /*P*/ )null, 
                  (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal, 
                  final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal, 
                  DL, 
                  TLI, 
                  (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal, 
                  final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal, 
                  DL, 
                  TLI, 
                  DT, (AssumptionCache /*P*/ )null, 
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal, 
                  final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                  /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal, 
                  DL, 
                  TLI, 
                  DT, AC, 
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal, 
                  final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                  /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a GetElementPtrInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyGEPInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3599,
 FQN="llvm::SimplifyGEPInst", NM="_ZN4llvm15SimplifyGEPInstEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyGEPInstEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops, 
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyGEPInst(SrcTy, Ops, 
               DL, 
               (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops, 
               final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyGEPInst(SrcTy, Ops, 
               DL, 
               TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops, 
               final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyGEPInst(SrcTy, Ops, 
               DL, 
               TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops, 
               final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyGEPInst(SrcTy, Ops, 
               DL, 
               TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops, 
               final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an InsertValueInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyInsertValueInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3637,
 FQN="llvm::SimplifyInsertValueInst", NM="_ZN4llvm23SimplifyInsertValueInstEPNS_5ValueES1_NS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm23SimplifyInsertValueInstEPNS_5ValueES1_NS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyInsertValueInst(Agg, Val, Idxs, DL, 
                       (/*const*/ TargetLibraryInfo /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyInsertValueInst(Agg, Val, Idxs, DL, 
                       TLI, (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyInsertValueInst(Agg, Val, Idxs, DL, 
                       TLI, DT, (AssumptionCache /*P*/ )null, 
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyInsertValueInst(Agg, Val, Idxs, DL, 
                       TLI, DT, AC, 
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                       /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an ExtractValueInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyExtractValueInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3670,
 FQN="llvm::SimplifyExtractValueInst", NM="_ZN4llvm24SimplifyExtractValueInstEPNS_5ValueENS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm24SimplifyExtractValueInstEPNS_5ValueENS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs, 
                        final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyExtractValueInst(Agg, Idxs, 
                        DL, 
                        (/*const*/ TargetLibraryInfo /*P*/ )null, 
                        (/*const*/ DominatorTree /*P*/ )null, 
                        (AssumptionCache /*P*/ )null, 
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs, 
                        final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyExtractValueInst(Agg, Idxs, 
                        DL, 
                        TLI, 
                        (/*const*/ DominatorTree /*P*/ )null, 
                        (AssumptionCache /*P*/ )null, 
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs, 
                        final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                        /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyExtractValueInst(Agg, Idxs, 
                        DL, 
                        TLI, 
                        DT, 
                        (AssumptionCache /*P*/ )null, 
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs, 
                        final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                        /*const*/ DominatorTree /*P*/ DT/*= null*/, 
                        AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyExtractValueInst(Agg, Idxs, 
                        DL, 
                        TLI, 
                        DT, 
                        AC, 
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs, 
                        final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                        /*const*/ DominatorTree /*P*/ DT/*= null*/, 
                        AssumptionCache /*P*/ AC/*= null*/, 
                        /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an ExtractElementInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyExtractElementInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3705,
 FQN="llvm::SimplifyExtractElementInst", NM="_ZN4llvm26SimplifyExtractElementInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm26SimplifyExtractElementInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyExtractElementInst(Vec, Idx, DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
                          (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx, final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyExtractElementInst(Vec, Idx, DL, TLI, 
                          (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx, final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                          /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyExtractElementInst(Vec, Idx, DL, TLI, 
                          DT, (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx, final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                          /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyExtractElementInst(Vec, Idx, DL, TLI, 
                          DT, AC, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx, final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                          /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an TruncInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyTruncInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3752,
 FQN="llvm::SimplifyTruncInst", NM="_ZN4llvm17SimplifyTruncInstEPNS_5ValueEPNS_4TypeERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm17SimplifyTruncInstEPNS_5ValueEPNS_4TypeERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyTruncInst(Op, Ty, DL, 
                 (/*const*/ TargetLibraryInfo /*P*/ )null, 
                 (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyTruncInst(Op, Ty, DL, 
                 TLI, 
                 (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                 /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyTruncInst(Op, Ty, DL, 
                 TLI, 
                 DT, (AssumptionCache /*P*/ )null, 
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                 /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyTruncInst(Op, Ty, DL, 
                 TLI, 
                 DT, AC, 
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                 /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
                 /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//=== Helper functions for higher up the class hierarchy.

/// Given operands for a CmpInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3870,
 FQN="llvm::SimplifyCmpInst", NM="_ZN4llvm15SimplifyCmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyCmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyCmpInst(Predicate, LHS, RHS, 
               DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyCmpInst(Predicate, LHS, RHS, 
               DL, TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyCmpInst(Predicate, LHS, RHS, 
               DL, TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyCmpInst(Predicate, LHS, RHS, 
               DL, TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a BinaryOperator, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3845,
 FQN="llvm::SimplifyBinOp", NM="_ZN4llvm13SimplifyBinOpEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm13SimplifyBinOpEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
             final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyBinOp(Opcode, LHS, RHS, 
             DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
             (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
             final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyBinOp(Opcode, LHS, RHS, 
             DL, TLI, 
             (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
             final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
             /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyBinOp(Opcode, LHS, RHS, 
             DL, TLI, 
             DT, (AssumptionCache /*P*/ )null, 
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
             final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
             /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyBinOp(Opcode, LHS, RHS, 
             DL, TLI, 
             DT, AC, 
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
             final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
             /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
             /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FP BinaryOperator, fold the result or return null.
/// In contrast to SimplifyBinOp, try to use FastMathFlag when folding the
/// result. In case we don't need FastMathFlags, simply fall to SimplifyBinOp.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFPBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3853,
 FQN="llvm::SimplifyFPBinOp", NM="_ZN4llvm15SimplifyFPBinOpEjPNS_5ValueES1_RKNS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm15SimplifyFPBinOpEjPNS_5ValueES1_RKNS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFPBinOp(Opcode, LHS, RHS, 
               FMF, DL, 
               (/*const*/ TargetLibraryInfo /*P*/ )null, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFPBinOp(Opcode, LHS, RHS, 
               FMF, DL, 
               TLI, 
               (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFPBinOp(Opcode, LHS, RHS, 
               FMF, DL, 
               TLI, 
               DT, (AssumptionCache /*P*/ )null, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFPBinOp(Opcode, LHS, RHS, 
               FMF, DL, 
               TLI, 
               DT, AC, 
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL, 
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
               /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given a function and iterators over arguments, fold the result or return
/// null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4071,
 FQN="llvm::SimplifyCall", NM="_ZN4llvm12SimplifyCallEPNS_5ValueEPNS_3UseES3_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm12SimplifyCallEPNS_5ValueEPNS_3UseES3_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin, 
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyCall(V, ArgBegin, 
            ArgEnd, DL, 
            (/*const*/ TargetLibraryInfo /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null, 
            (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin, 
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL, 
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyCall(V, ArgBegin, 
            ArgEnd, DL, 
            TLI, (/*const*/ DominatorTree /*P*/ )null, 
            (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin, 
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL, 
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyCall(V, ArgBegin, 
            ArgEnd, DL, 
            TLI, DT, 
            (AssumptionCache /*P*/ )null, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin, 
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL, 
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/, 
            AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyCall(V, ArgBegin, 
            ArgEnd, DL, 
            TLI, DT, 
            AC, (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin, 
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL, 
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/, 
            AssumptionCache /*P*/ AC/*= null*/, /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given a function and set of arguments, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4079,
 FQN="llvm::SimplifyCall", NM="_ZN4llvm12SimplifyCallEPNS_5ValueENS_8ArrayRefIS1_EERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm12SimplifyCallEPNS_5ValueENS_8ArrayRefIS1_EERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, 
            final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyCall(V, Args, 
            DL, (/*const*/ TargetLibraryInfo /*P*/ )null, 
            (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, 
            final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyCall(V, Args, 
            DL, TLI, 
            (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null, 
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, 
            final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
            /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyCall(V, Args, 
            DL, TLI, 
            DT, (AssumptionCache /*P*/ )null, 
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, 
            final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
            /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyCall(V, Args, 
            DL, TLI, 
            DT, AC, 
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, 
            final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
            /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/, 
            /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// See if we can compute a simplified version of this instruction. If not,
/// return null.

/// See if we can compute a simplified version of this instruction.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4089,
 FQN="llvm::SimplifyInstruction", NM="_ZN4llvm19SimplifyInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm19SimplifyInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyInstruction(I, DL, 
                   (/*const*/ TargetLibraryInfo /*P*/ )null, 
                   (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null);
}
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL, 
                   /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyInstruction(I, DL, 
                   TLI, 
                   (/*const*/ DominatorTree /*P*/ )null, (AssumptionCache /*P*/ )null);
}
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL, 
                   /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                   /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyInstruction(I, DL, 
                   TLI, 
                   DT, (AssumptionCache /*P*/ )null);
}
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL, 
                   /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                   /*const*/ DominatorTree /*P*/ DT/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replace all uses of 'I' with 'SimpleV' and simplify the uses recursively.
///
/// This first performs a normal RAUW of I with SimpleV. It then recursively
/// attempts to simplify those users updated by the operation. The 'I'
/// instruction must not be equal to the simplified value 'SimpleV'.
///
/// The function returns true if any simplifications were performed.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceAndRecursivelySimplify">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4323,
 FQN="llvm::replaceAndRecursivelySimplify", NM="_ZN4llvm29replaceAndRecursivelySimplifyEPNS_11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm29replaceAndRecursivelySimplifyEPNS_11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV) {
  return replaceAndRecursivelySimplify(I, SimpleV, 
                             (/*const*/ TargetLibraryInfo /*P*/ )null, 
                             (/*const*/ DominatorTree /*P*/ )null, 
                             (AssumptionCache /*P*/ )null);
}
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV, 
                             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return replaceAndRecursivelySimplify(I, SimpleV, 
                             TLI, 
                             (/*const*/ DominatorTree /*P*/ )null, 
                             (AssumptionCache /*P*/ )null);
}
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV, 
                             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                             /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return replaceAndRecursivelySimplify(I, SimpleV, 
                             TLI, 
                             DT, 
                             (AssumptionCache /*P*/ )null);
}
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV, 
                             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                             /*const*/ DominatorTree /*P*/ DT/*= null*/, 
                             AssumptionCache /*P*/ AC/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Recursively attempt to simplify an instruction.
///
/// This routine uses SimplifyInstruction to simplify 'I', and if successful
/// replaces uses of 'I' with the simplified value. It then recurses on each
/// of the users impacted. It returns true if any simplifications were
/// performed.
//<editor-fold defaultstate="collapsed" desc="llvm::recursivelySimplifyInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4316,
 FQN="llvm::recursivelySimplifyInstruction", NM="_ZN4llvm30recursivelySimplifyInstructionEPNS_11InstructionEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN4llvm30recursivelySimplifyInstructionEPNS_11InstructionEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I) {
  return recursivelySimplifyInstruction(I, 
                              (/*const*/ TargetLibraryInfo /*P*/ )null, 
                              (/*const*/ DominatorTree /*P*/ )null, 
                              (AssumptionCache /*P*/ )null);
}
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I, 
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return recursivelySimplifyInstruction(I, 
                              TLI, 
                              (/*const*/ DominatorTree /*P*/ )null, 
                              (AssumptionCache /*P*/ )null);
}
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I, 
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return recursivelySimplifyInstruction(I, 
                              TLI, 
                              DT, 
                              (AssumptionCache /*P*/ )null);
}
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I, 
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/, 
                              /*const*/ DominatorTree /*P*/ DT/*= null*/, 
                              AssumptionCache /*P*/ AC/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InstructionSimplifyLlvmGlobals
