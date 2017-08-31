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


//<editor-fold defaultstate="collapsed" desc="static type InstructionSimplifyStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.InstructionSimplifyStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=Tpl__ZL12SimplifyCallPN4llvm5ValueET_S2_RKN12_GLOBAL__N_15QueryEj;Tpl__ZL17SimplifyIntrinsicPN4llvm8FunctionET_S2_RKN12_GLOBAL__N_15QueryEj;_InstructionSimplify_cpp_Unnamed_enum;_ZL10NumReassoc;_ZL11ExpandBinOpjPN4llvm5ValueES1_jRKN12_GLOBAL__N_15QueryEj;_ZL11SimplifyDivN4llvm11Instruction9BinaryOpsEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj;_ZL11SimplifyRemN4llvm11Instruction9BinaryOpsEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj;_ZL12GetCompareTyPN4llvm5ValueE;_ZL12IsIdempotentN4llvm9Intrinsic2IDE;_ZL12isUndefShiftPN4llvm5ValueE;_ZL13SimplifyBinOpjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL13SimplifyShiftjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL13isSameComparePN4llvm5ValueENS_7CmpInst9PredicateES1_S1_;_ZL14SimplifyOrInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyAddInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyAndInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyCmpInstjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyFPBinOpjPN4llvm5ValueES1_RKNS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyGEPInstPN4llvm4TypeENS_8ArrayRefIPNS_5ValueEEERKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyMulInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyPHINodePN4llvm7PHINodeERKN12_GLOBAL__N_15QueryE;_ZL15SimplifyShlInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj;_ZL15SimplifySubInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj;_ZL15SimplifyXorInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyAShrInstPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyFAddInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyFCmpInstjPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyFDivInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyFMulInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyFRemInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyFSubInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyICmpInstjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyLShrInstPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj;_ZL16SimplifySDivInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL16SimplifySRemInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyUDivInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL16SimplifyURemInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL16ThreadCmpOverPHIN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj;_ZL17SimplifyOrOfICmpsPN4llvm8ICmpInstES1_;_ZL17SimplifyTruncInstPN4llvm5ValueEPNS_4TypeERKN12_GLOBAL__N_15QueryEj;_ZL17ValueDominatesPHIPN4llvm5ValueEPNS_7PHINodeEPKNS_13DominatorTreeE;_ZL18SimplifyAndOfICmpsPN4llvm8ICmpInstES1_;_ZL18SimplifyRightShiftjPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj;_ZL18SimplifySelectInstPN4llvm5ValueES1_S1_RKN12_GLOBAL__N_15QueryEj;_ZL18ThreadBinOpOverPHIjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL18computePointerICmpRKN4llvm10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeENS_7CmpInst9PredicateEPKNS_11InstructionEPNS_5ValueESF_;_ZL19ThreadCmpOverSelectN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj;_ZL20SimplifyRelativeLoadPN4llvm8ConstantES1_RKNS_10DataLayoutE;_ZL20maskIsAllZeroOrUndefPN4llvm5ValueE;_ZL21ThreadBinOpOverSelectjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL22SimplifyWithOpReplacedPN4llvm5ValueES1_S1_RKN12_GLOBAL__N_15QueryEj;_ZL23SimplifyInsertValueInstPN4llvm5ValueES1_NS_8ArrayRefIjEERKN12_GLOBAL__N_15QueryEj;_ZL24SimplifyAssociativeBinOpjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL24SimplifyExtractValueInstPN4llvm5ValueENS_8ArrayRefIjEERKN12_GLOBAL__N_15QueryEj;_ZL24computePointerDifferenceRKN4llvm10DataLayoutEPNS_5ValueES4_;_ZL26ExtractEquivalentConditionPN4llvm5ValueENS_7CmpInst9PredicateES1_S1_;_ZL26SimplifyExtractElementInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj;_ZL26simplifyUnsignedRangeCheckPN4llvm8ICmpInstES1_b;_ZL30stripAndComputeConstantOffsetsRKN4llvm10DataLayoutERPNS_5ValueEb;_ZL33replaceAndRecursivelySimplifyImplPN4llvm11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE;_ZL7getTruePN4llvm4TypeE;_ZL8getFalsePN4llvm4TypeE;_ZL9NumExpand;_ZN12_GLOBAL__N_15QueryE; -static-type=InstructionSimplifyStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class InstructionSimplifyStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 43,
 FQN="(anonymous)", NM="_InstructionSimplify_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_InstructionSimplify_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int RecursionLimit = 3;
/*}*/
//<editor-fold defaultstate="collapsed" desc="NumExpand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 45,
 FQN="NumExpand", NM="_ZL9NumExpand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL9NumExpand")
//</editor-fold>
public static Statistic NumExpand = new Statistic($("instsimplify"), $("NumExpand"), $("Number of expansions"), 0, false);
//<editor-fold defaultstate="collapsed" desc="NumReassoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 46,
 FQN="NumReassoc", NM="_ZL10NumReassoc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL10NumReassoc")
//</editor-fold>
public static Statistic NumReassoc = new Statistic($("instsimplify"), $("NumReassoc"), $("Number of reassociations"), 0, false);
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Query">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 49,
 FQN="(anonymous namespace)::Query", NM="_ZN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static class/*struct*/ Query {
  public final /*const*/ DataLayout /*&*/ DL;
  public /*const*/ TargetLibraryInfo /*P*/ TLI;
  public /*const*/ DominatorTree /*P*/ DT;
  public AssumptionCache /*P*/ AC;
  public /*const*/ Instruction /*P*/ CxtI;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Query::Query">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 56,
   FQN="(anonymous namespace)::Query::Query", NM="_ZN12_GLOBAL__N_15QueryC1ERKN4llvm10DataLayoutEPKNS1_17TargetLibraryInfoEPKNS1_13DominatorTreeEPNS1_15AssumptionCacheEPKNS1_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZN12_GLOBAL__N_15QueryC1ERKN4llvm10DataLayoutEPKNS1_17TargetLibraryInfoEPKNS1_13DominatorTreeEPNS1_15AssumptionCacheEPKNS1_11InstructionE")
  //</editor-fold>
  public Query(final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ tli, 
      /*const*/ DominatorTree /*P*/ dt) {
    this(DL, tli, 
      dt, (AssumptionCache /*P*/ )null, 
      (/*const*/ Instruction /*P*/ )null);
  }
  public Query(final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ tli, 
      /*const*/ DominatorTree /*P*/ dt, AssumptionCache /*P*/ ac/*= null*/) {
    this(DL, tli, 
      dt, ac, 
      (/*const*/ Instruction /*P*/ )null);
  }
  public Query(final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ tli, 
      /*const*/ DominatorTree /*P*/ dt, AssumptionCache /*P*/ ac/*= null*/, 
      /*const*/ Instruction /*P*/ cxti/*= null*/) {
    // : DL(DL), TLI(tli), DT(dt), AC(ac), CxtI(cxti) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DL=" + DL // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", DT=" + DT // NOI18N
              + ", AC=" + AC // NOI18N
              + ", CxtI=" + CxtI; // NOI18N
  }
}
// end anonymous namespace

/// Given operands for an And, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyAndInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1563,
 FQN="SimplifyAndInst", NM="_ZL15SimplifyAndInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyAndInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyAndInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
               /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


//=== Helper functions for higher up the class hierarchy.

/// Given operands for a BinaryOperator, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3764,
 FQN="SimplifyBinOp", NM="_ZL13SimplifyBinOpjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL13SimplifyBinOpjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
             final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a BinaryOperator, see if we can fold the result.
/// If not, this returns null.
/// In contrast to SimplifyBinOp, try to use FastMathFlag when folding the
/// result. In case we don't need FastMathFlags, simply fall to SimplifyBinOp.
//<editor-fold defaultstate="collapsed" desc="SimplifyFPBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3830,
 FQN="SimplifyFPBinOp", NM="_ZL15SimplifyFPBinOpjPN4llvm5ValueES1_RKNS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyFPBinOpjPN4llvm5ValueES1_RKNS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ Query /*&*/ Q, 
               /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a CmpInst, see if we can fold the result.
//<editor-fold defaultstate="collapsed" desc="SimplifyCmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3863,
 FQN="SimplifyCmpInst", NM="_ZL15SimplifyCmpInstjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyCmpInstjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
               final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an Or, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyOrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1737,
 FQN="SimplifyOrInst", NM="_ZL14SimplifyOrInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL14SimplifyOrInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyOrInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
              /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a Xor, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyXorInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1870,
 FQN="SimplifyXorInst", NM="_ZL15SimplifyXorInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyXorInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyXorInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
               /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="SimplifyTruncInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3745,
 FQN="SimplifyTruncInst", NM="_ZL17SimplifyTruncInstPN4llvm5ValueEPNS_4TypeERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL17SimplifyTruncInstPN4llvm5ValueEPNS_4TypeERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ Query /*&*/ Q, /*uint*/int $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// For a boolean type, or a vector of boolean type, return false, or
/// a vector with every element false, as appropriate for the type.
//<editor-fold defaultstate="collapsed" desc="getFalse">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 76,
 FQN="getFalse", NM="_ZL8getFalsePN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL8getFalsePN4llvm4TypeE")
//</editor-fold>
public static Constant /*P*/ getFalse(Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// For a boolean type, or a vector of boolean type, return true, or
/// a vector with every element true, as appropriate for the type.
//<editor-fold defaultstate="collapsed" desc="getTrue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 84,
 FQN="getTrue", NM="_ZL7getTruePN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL7getTruePN4llvm4TypeE")
//</editor-fold>
public static Constant /*P*/ getTrue(Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isSameCompare - Is V equivalent to the comparison "LHS Pred RHS"?
//<editor-fold defaultstate="collapsed" desc="isSameCompare">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 91,
 FQN="isSameCompare", NM="_ZL13isSameComparePN4llvm5ValueENS_7CmpInst9PredicateES1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL13isSameComparePN4llvm5ValueENS_7CmpInst9PredicateES1_S1_")
//</editor-fold>
public static boolean isSameCompare(Value /*P*/ V, CmpInst.Predicate Pred, Value /*P*/ LHS, 
             Value /*P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Does the given value dominate the specified phi node?
//<editor-fold defaultstate="collapsed" desc="ValueDominatesPHI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 105,
 FQN="ValueDominatesPHI", NM="_ZL17ValueDominatesPHIPN4llvm5ValueEPNS_7PHINodeEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL17ValueDominatesPHIPN4llvm5ValueEPNS_7PHINodeEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean ValueDominatesPHI(Value /*P*/ V, PHINode /*P*/ P, /*const*/ DominatorTree /*P*/ DT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Simplify "A op (B op' C)" by distributing op over op', turning it into
/// "(A op B) op' (A op C)".  Here "op" is given by Opcode and "op'" is
/// given by OpcodeToExpand, while "A" corresponds to LHS and "B op' C" to RHS.
/// Also performs the transform "(A op' B) op C" -> "(A op C) op' (B op C)".
/// Returns the simplified value, or null if no simplification was performed.
//<editor-fold defaultstate="collapsed" desc="ExpandBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 140,
 FQN="ExpandBinOp", NM="_ZL11ExpandBinOpjPN4llvm5ValueES1_jRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL11ExpandBinOpjPN4llvm5ValueES1_jRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ ExpandBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
           /*uint*/int OpcToExpand, final /*const*/ Query /*&*/ Q, 
           /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generic simplifications for associative binary operations.
/// Returns the simpler value, or null if none was found.
//<editor-fold defaultstate="collapsed" desc="SimplifyAssociativeBinOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 199,
 FQN="SimplifyAssociativeBinOp", NM="_ZL24SimplifyAssociativeBinOpjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL24SimplifyAssociativeBinOpjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyAssociativeBinOp(/*uint*/int Opc, Value /*P*/ LHS, Value /*P*/ RHS, 
                        final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// In the case of a binary operation with a select instruction as an operand,
/// try to simplify the binop by seeing whether evaluating it on both branches
/// of the select results in the same value. Returns the common value if so,
/// otherwise returns null.
//<editor-fold defaultstate="collapsed" desc="ThreadBinOpOverSelect">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 298,
 FQN="ThreadBinOpOverSelect", NM="_ZL21ThreadBinOpOverSelectjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL21ThreadBinOpOverSelectjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ ThreadBinOpOverSelect(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
                     final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// In the case of a comparison with a select instruction, try to simplify the
/// comparison by seeing whether both branches of the select result in the same
/// value. Returns the common value if so, otherwise returns null.
//<editor-fold defaultstate="collapsed" desc="ThreadCmpOverSelect">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 369,
 FQN="ThreadCmpOverSelect", NM="_ZL19ThreadCmpOverSelectN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL19ThreadCmpOverSelectN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ ThreadCmpOverSelect(CmpInst.Predicate Pred, Value /*P*/ LHS, 
                   Value /*P*/ RHS, final /*const*/ Query /*&*/ Q, 
                   /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// In the case of a binary operation with an operand that is a PHI instruction,
/// try to simplify the binop by seeing whether evaluating it on the incoming
/// phi values yields the same result for every value. If so returns the common
/// value, otherwise returns null.
//<editor-fold defaultstate="collapsed" desc="ThreadBinOpOverPHI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 451,
 FQN="ThreadBinOpOverPHI", NM="_ZL18ThreadBinOpOverPHIjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL18ThreadBinOpOverPHIjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ ThreadBinOpOverPHI(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, 
                  final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// In the case of a comparison with a PHI instruction, try to simplify the
/// comparison by seeing whether comparing with all of the incoming phi values
/// yields the same result every time. If so returns the common result,
/// otherwise returns null.
//<editor-fold defaultstate="collapsed" desc="ThreadCmpOverPHI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 493,
 FQN="ThreadCmpOverPHI", NM="_ZL16ThreadCmpOverPHIN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16ThreadCmpOverPHIN4llvm7CmpInst9PredicateEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ ThreadCmpOverPHI(CmpInst.Predicate Pred, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an Add, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyAddInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 529,
 FQN="SimplifyAddInst", NM="_ZL15SimplifyAddInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyAddInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyAddInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Compute the base pointer and cumulative constant offsets for V.
///
/// This strips all constant offsets off of V, leaving it the base pointer, and
/// accumulates the total constant offset applied in the returned constant. It
/// returns 0 if V is not a pointer, and returns the constant '0' if there are
/// no constant offsets applied.
///
/// This is very similar to GetPointerBaseWithConstantOffset except it doesn't
/// follow non-inbounds geps. This allows it to remain usable for icmp ult/etc.
/// folding.
//<editor-fold defaultstate="collapsed" desc="stripAndComputeConstantOffsets">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 600,
 FQN="stripAndComputeConstantOffsets", NM="_ZL30stripAndComputeConstantOffsetsRKN4llvm10DataLayoutERPNS_5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL30stripAndComputeConstantOffsetsRKN4llvm10DataLayoutERPNS_5ValueEb")
//</editor-fold>
public static Constant /*P*/ stripAndComputeConstantOffsets(final /*const*/ DataLayout /*&*/ DL, final type$ref<Value /*P*/ /*&*/> V) {
  return stripAndComputeConstantOffsets(DL, V, 
                              false);
}
public static Constant /*P*/ stripAndComputeConstantOffsets(final /*const*/ DataLayout /*&*/ DL, final type$ref<Value /*P*/ /*&*/> V, 
                              boolean AllowNonInbounds/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Compute the constant difference between two pointer values.
/// If the difference is not a constant, returns zero.
//<editor-fold defaultstate="collapsed" desc="computePointerDifference">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 644,
 FQN="computePointerDifference", NM="_ZL24computePointerDifferenceRKN4llvm10DataLayoutEPNS_5ValueES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL24computePointerDifferenceRKN4llvm10DataLayoutEPNS_5ValueES4_")
//</editor-fold>
public static Constant /*P*/ computePointerDifference(final /*const*/ DataLayout /*&*/ DL, Value /*P*/ LHS, 
                        Value /*P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a Sub, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifySubInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 663,
 FQN="SimplifySubInst", NM="_ZL15SimplifySubInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifySubInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifySubInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FAdd, see if we can fold the result.  If not, this
/// returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyFAddInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 787,
 FQN="SimplifyFAddInst", NM="_ZL16SimplifyFAddInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyFAddInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FSub, see if we can fold the result.  If not, this
/// returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyFSubInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 826,
 FQN="SimplifyFSubInst", NM="_ZL16SimplifyFSubInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyFSubInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given the operands for an FMul, see if we can fold the result
//<editor-fold defaultstate="collapsed" desc="SimplifyFMulInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 860,
 FQN="SimplifyFMulInst", NM="_ZL16SimplifyFMulInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyFMulInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ Op0, Value /*P*/ Op1, 
                FastMathFlags FMF, 
                final /*const*/ Query /*&*/ Q, 
                /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a Mul, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyMulInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 885,
 FQN="SimplifyMulInst", NM="_ZL15SimplifyMulInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyMulInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyMulInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
               /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an SDiv or UDiv, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyDiv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 982,
 FQN="SimplifyDiv", NM="_ZL11SimplifyDivN4llvm11Instruction9BinaryOpsEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL11SimplifyDivN4llvm11Instruction9BinaryOpsEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyDiv(Instruction.BinaryOps Opcode, Value /*P*/ Op0, Value /*P*/ Op1, 
           final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an SDiv, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifySDivInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1065,
 FQN="SimplifySDivInst", NM="_ZL16SimplifySDivInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifySDivInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifySDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
                /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a UDiv, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyUDivInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1083,
 FQN="SimplifyUDivInst", NM="_ZL16SimplifyUDivInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyUDivInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
                /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="SimplifyFDivInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1099,
 FQN="SimplifyFDivInst", NM="_ZL16SimplifyFDivInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyFDivInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ Query /*&*/ Q, /*uint*/int $Prm4) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an SRem or URem, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyRem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1144,
 FQN="SimplifyRem", NM="_ZL11SimplifyRemN4llvm11Instruction9BinaryOpsEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL11SimplifyRemN4llvm11Instruction9BinaryOpsEPNS_5ValueES3_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyRem(Instruction.BinaryOps Opcode, Value /*P*/ Op0, Value /*P*/ Op1, 
           final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an SRem, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifySRemInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1202,
 FQN="SimplifySRemInst", NM="_ZL16SimplifySRemInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifySRemInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifySRemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
                /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a URem, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyURemInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1220,
 FQN="SimplifyURemInst", NM="_ZL16SimplifyURemInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyURemInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyURemInst(Value /*P*/ Op0, Value /*P*/ Op1, final /*const*/ Query /*&*/ Q, 
                /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="SimplifyFRemInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1236,
 FQN="SimplifyFRemInst", NM="_ZL16SimplifyFRemInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyFRemInstPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ Op0, Value /*P*/ Op1, FastMathFlags FMF, 
                final /*const*/ Query /*&*/ $Prm3, /*uint*/int $Prm4) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if a shift by \c Amount always yields undef.
//<editor-fold defaultstate="collapsed" desc="isUndefShift">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1265,
 FQN="isUndefShift", NM="_ZL12isUndefShiftPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL12isUndefShiftPN4llvm5ValueE")
//</editor-fold>
public static boolean isUndefShift(Value /*P*/ Amount) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an Shl, LShr or AShr, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyShift">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1293,
 FQN="SimplifyShift", NM="_ZL13SimplifyShiftjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL13SimplifyShiftjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyShift(/*uint*/int Opcode, Value /*P*/ Op0, Value /*P*/ Op1, 
             final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Given operands for an Shl, LShr or AShr, see if we can
/// fold the result.  If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyRightShift">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1344,
 FQN="SimplifyRightShift", NM="_ZL18SimplifyRightShiftjPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL18SimplifyRightShiftjPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyRightShift(/*uint*/int Opcode, Value /*P*/ Op0, Value /*P*/ Op1, 
                  boolean isExact, final /*const*/ Query /*&*/ Q, 
                  /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an Shl, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyShlInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1375,
 FQN="SimplifyShlInst", NM="_ZL15SimplifyShlInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyShlInstPN4llvm5ValueES1_bbRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW, 
               final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an LShr, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyLShrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1402,
 FQN="SimplifyLShrInst", NM="_ZL16SimplifyLShrInstPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyLShrInstPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an AShr, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyAShrInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1427,
 FQN="SimplifyAShrInst", NM="_ZL16SimplifyAShrInstPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyAShrInstPN4llvm5ValueES1_bRKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact, 
                final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="simplifyUnsignedRangeCheck">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1459,
 FQN="simplifyUnsignedRangeCheck", NM="_ZL26simplifyUnsignedRangeCheckPN4llvm8ICmpInstES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL26simplifyUnsignedRangeCheckPN4llvm8ICmpInstES1_b")
//</editor-fold>
public static Value /*P*/ simplifyUnsignedRangeCheck(ICmpInst /*P*/ ZeroICmp, 
                          ICmpInst /*P*/ UnsignedICmp, boolean IsAnd) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="SimplifyAndOfICmps">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1500,
 FQN="SimplifyAndOfICmps", NM="_ZL18SimplifyAndOfICmpsPN4llvm8ICmpInstES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL18SimplifyAndOfICmpsPN4llvm8ICmpInstES1_")
//</editor-fold>
public static Value /*P*/ SimplifyAndOfICmps(ICmpInst /*P*/ Op0, ICmpInst /*P*/ Op1) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Simplify (or (icmp ...) (icmp ...)) to true when we can tell that the union
/// contains all possible values.
//<editor-fold defaultstate="collapsed" desc="SimplifyOrOfICmps">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1685,
 FQN="SimplifyOrOfICmps", NM="_ZL17SimplifyOrOfICmpsPN4llvm8ICmpInstES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL17SimplifyOrOfICmpsPN4llvm8ICmpInstES1_")
//</editor-fold>
public static Value /*P*/ SimplifyOrOfICmps(ICmpInst /*P*/ Op0, ICmpInst /*P*/ Op1) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="GetCompareTy">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1922,
 FQN="GetCompareTy", NM="_ZL12GetCompareTyPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL12GetCompareTyPN4llvm5ValueE")
//</editor-fold>
public static Type /*P*/ GetCompareTy(Value /*P*/ Op) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Rummage around inside V looking for something equivalent to the comparison
/// "LHS Pred RHS". Return such a value if found, otherwise return null.
/// Helper function for analyzing max/min idioms.
//<editor-fold defaultstate="collapsed" desc="ExtractEquivalentCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1929,
 FQN="ExtractEquivalentCondition", NM="_ZL26ExtractEquivalentConditionPN4llvm5ValueENS_7CmpInst9PredicateES1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL26ExtractEquivalentConditionPN4llvm5ValueENS_7CmpInst9PredicateES1_S1_")
//</editor-fold>
public static Value /*P*/ ExtractEquivalentCondition(Value /*P*/ V, CmpInst.Predicate Pred, 
                          Value /*P*/ LHS, Value /*P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


// A significant optimization not implemented here is assuming that alloca
// addresses are not equal to incoming argument values. They don't *alias*,
// as we say, but that doesn't mean they aren't equal, so we take a
// conservative approach.
//
// This is inspired in part by C++11 5.10p1:
//   "Two pointers of the same type compare equal if and only if they are both
//    null, both point to the same function, or both represent the same
//    address."
//
// This is pretty permissive.
//
// It's also partly due to C11 6.5.9p6:
//   "Two pointers compare equal if and only if both are null pointers, both are
//    pointers to the same object (including a pointer to an object and a
//    subobject at its beginning) or function, both are pointers to one past the
//    last element of the same array object, or one is a pointer to one past the
//    end of one array object and the other is a pointer to the start of a
//    different array object that happens to immediately follow the first array
//    object in the address space.)
//
// C11's version is more restrictive, however there's no reason why an argument
// couldn't be a one-past-the-end value for a stack object in the caller and be
// equal to the beginning of a stack object in the callee.
//
// If the C and C++ standards are ever made sufficiently restrictive in this
// area, it may be possible to update LLVM's semantics accordingly and reinstate
// this optimization.
//<editor-fold defaultstate="collapsed" desc="computePointerICmp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 1974,
 FQN="computePointerICmp", NM="_ZL18computePointerICmpRKN4llvm10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeENS_7CmpInst9PredicateEPKNS_11InstructionEPNS_5ValueESF_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL18computePointerICmpRKN4llvm10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeENS_7CmpInst9PredicateEPKNS_11InstructionEPNS_5ValueESF_")
//</editor-fold>
public static Constant /*P*/ computePointerICmp(final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI, 
                  /*const*/ DominatorTree /*P*/ DT, CmpInst.Predicate Pred, 
                  /*const*/ Instruction /*P*/ CxtI, Value /*P*/ LHS, Value /*P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an ICmpInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyICmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 2155,
 FQN="SimplifyICmpInst", NM="_ZL16SimplifyICmpInstjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyICmpInstjPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an FCmpInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyFCmpInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3162,
 FQN="SimplifyFCmpInst", NM="_ZL16SimplifyFCmpInstjPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL16SimplifyFCmpInstjPN4llvm5ValueES1_NS_13FastMathFlagsERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS, 
                FastMathFlags FMF, final /*const*/ Query /*&*/ Q, 
                /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// See if V simplifies when its operand Op is replaced with RepOp.
//<editor-fold defaultstate="collapsed" desc="SimplifyWithOpReplaced">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3293,
 FQN="SimplifyWithOpReplaced", NM="_ZL22SimplifyWithOpReplacedPN4llvm5ValueES1_S1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL22SimplifyWithOpReplacedPN4llvm5ValueES1_S1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static /*const*/ Value /*P*/ SimplifyWithOpReplaced(Value /*P*/ V, Value /*P*/ Op, Value /*P*/ RepOp, 
                      final /*const*/ Query /*&*/ Q, 
                      /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for a SelectInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifySelectInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3376,
 FQN="SimplifySelectInst", NM="_ZL18SimplifySelectInstPN4llvm5ValueES1_S1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL18SimplifySelectInstPN4llvm5ValueES1_S1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifySelectInst(Value /*P*/ CondVal, Value /*P*/ TrueVal, 
                  Value /*P*/ FalseVal, final /*const*/ Query /*&*/ Q, 
                  /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an GetElementPtrInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyGEPInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3517,
 FQN="SimplifyGEPInst", NM="_ZL15SimplifyGEPInstPN4llvm4TypeENS_8ArrayRefIPNS_5ValueEEERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyGEPInstPN4llvm4TypeENS_8ArrayRefIPNS_5ValueEEERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops, 
               final /*const*/ Query /*&*/ Q, /*uint*/int $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an InsertValueInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyInsertValueInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3610,
 FQN="SimplifyInsertValueInst", NM="_ZL23SimplifyInsertValueInstPN4llvm5ValueES1_NS_8ArrayRefIjEERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL23SimplifyInsertValueInstPN4llvm5ValueES1_NS_8ArrayRefIjEERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val, 
                       ArrayRefUInt Idxs, final /*const*/ Query /*&*/ Q, 
                       /*uint*/int $Prm4) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an ExtractValueInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyExtractValueInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3647,
 FQN="SimplifyExtractValueInst", NM="_ZL24SimplifyExtractValueInstPN4llvm5ValueENS_8ArrayRefIjEERKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL24SimplifyExtractValueInstPN4llvm5ValueENS_8ArrayRefIjEERKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs, 
                        final /*const*/ Query /*&*/ $Prm2, /*uint*/int $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given operands for an ExtractElementInst, see if we can fold the result.
/// If not, this returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyExtractElementInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3682,
 FQN="SimplifyExtractElementInst", NM="_ZL26SimplifyExtractElementInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL26SimplifyExtractElementInstPN4llvm5ValueES1_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx, final /*const*/ Query /*&*/ $Prm2, 
                          /*uint*/int $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// See if we can fold the given phi. If not, returns null.
//<editor-fold defaultstate="collapsed" desc="SimplifyPHINode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3713,
 FQN="SimplifyPHINode", NM="_ZL15SimplifyPHINodePN4llvm7PHINodeERKN12_GLOBAL__N_15QueryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL15SimplifyPHINodePN4llvm7PHINodeERKN12_GLOBAL__N_15QueryE")
//</editor-fold>
public static Value /*P*/ SimplifyPHINode(PHINode /*P*/ PN, final /*const*/ Query /*&*/ Q) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="IsIdempotent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3878,
 FQN="IsIdempotent", NM="_ZL12IsIdempotentN4llvm9Intrinsic2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL12IsIdempotentN4llvm9Intrinsic2IDE")
//</editor-fold>
public static boolean IsIdempotent(/*Intrinsic.ID*/int ID) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="SimplifyRelativeLoad">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3894,
 FQN="SimplifyRelativeLoad", NM="_ZL20SimplifyRelativeLoadPN4llvm8ConstantES1_RKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL20SimplifyRelativeLoadPN4llvm8ConstantES1_RKNS_10DataLayoutE")
//</editor-fold>
public static Value /*P*/ SimplifyRelativeLoad(Constant /*P*/ Ptr, Constant /*P*/ Offset, 
                    final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="maskIsAllZeroOrUndef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3950,
 FQN="maskIsAllZeroOrUndef", NM="_ZL20maskIsAllZeroOrUndefPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL20maskIsAllZeroOrUndefPN4llvm5ValueE")
//</editor-fold>
public static boolean maskIsAllZeroOrUndef(Value /*P*/ Mask) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename IterTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="SimplifyIntrinsic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 3967,
 FQN="SimplifyIntrinsic", NM="Tpl__ZL17SimplifyIntrinsicPN4llvm8FunctionET_S2_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=Tpl__ZL17SimplifyIntrinsicPN4llvm8FunctionET_S2_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static </*typename*/ IterTy> Value /*P*/ SimplifyIntrinsic(Function /*P*/ F, IterTy ArgBegin, IterTy ArgEnd, 
                 final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename IterTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="SimplifyCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4036,
 FQN="SimplifyCall", NM="Tpl__ZL12SimplifyCallPN4llvm5ValueET_S2_RKN12_GLOBAL__N_15QueryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=Tpl__ZL12SimplifyCallPN4llvm5ValueET_S2_RKN12_GLOBAL__N_15QueryEj")
//</editor-fold>
public static </*typename*/ IterTy> Value /*P*/ SimplifyCall$T(Value /*P*/ V, IterTy ArgBegin, IterTy ArgEnd, 
              final /*const*/ Query /*&*/ Q, /*uint*/int MaxRecurse) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Implementation of recursive simplification through an instruction's
/// uses.
///
/// This is the common implementation of the recursive simplification routines.
/// If we have a pre-simplified value in 'SimpleV', that is forcibly used to
/// replace the instruction 'I'. Otherwise, we simply add 'I' to the list of
/// instructions to process and attempt to simplify it using
/// InstructionSimplify.
///
/// This routine returns 'true' only when *it* simplifies something. The passed
/// in simplified value does not count toward this.
//<editor-fold defaultstate="collapsed" desc="replaceAndRecursivelySimplifyImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp", line = 4260,
 FQN="replaceAndRecursivelySimplifyImpl", NM="_ZL33replaceAndRecursivelySimplifyImplPN4llvm11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstructionSimplify.cpp -nm=_ZL33replaceAndRecursivelySimplifyImplPN4llvm11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static boolean replaceAndRecursivelySimplifyImpl(Instruction /*P*/ I, Value /*P*/ SimpleV, 
                                 /*const*/ TargetLibraryInfo /*P*/ TLI, 
                                 /*const*/ DominatorTree /*P*/ DT, 
                                 AssumptionCache /*P*/ AC) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InstructionSimplifyStatics
