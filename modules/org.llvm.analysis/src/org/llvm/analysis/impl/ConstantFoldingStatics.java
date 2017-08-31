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
import org.llvm.analysis.bfi_detail.*;


//<editor-fold defaultstate="collapsed" desc="static type ConstantFoldingStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.ConstantFoldingStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_111FoldBitCastEPN4llvm8ConstantEPNS0_4TypeERKNS0_10DataLayoutE;_ZN12_GLOBAL__N_114CastGEPIndicesEPN4llvm4TypeENS0_8ArrayRefIPNS0_8ConstantEEES2_RKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE;_ZN12_GLOBAL__N_114ConstantFoldFPEPFddEdPN4llvm4TypeE;_ZN12_GLOBAL__N_116getValueAsDoubleEPN4llvm10ConstantFPE;_ZN12_GLOBAL__N_118ReadDataFromGlobalEPN4llvm8ConstantEyPhjRKNS0_10DataLayoutE;_ZN12_GLOBAL__N_118StripPtrCastKeepASEPN4llvm8ConstantERPNS0_4TypeE;_ZN12_GLOBAL__N_120ConstantFoldBinaryFPEPFdddEddPN4llvm4TypeE;_ZN12_GLOBAL__N_120ConstantFoldLoadInstEPKN4llvm8LoadInstERKNS0_10DataLayoutE;_ZN12_GLOBAL__N_120llvm_fenv_testexceptEv;_ZN12_GLOBAL__N_121llvm_fenv_clearexceptEv;_ZN12_GLOBAL__N_122ConstantFoldScalarCallEN4llvm9StringRefEjPNS0_4TypeENS0_8ArrayRefIPNS0_8ConstantEEEPKNS0_17TargetLibraryInfoE;_ZN12_GLOBAL__N_122ConstantFoldVectorCallEN4llvm9StringRefEjPNS0_10VectorTypeENS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE;_ZN12_GLOBAL__N_122GetConstantFoldFPValueEdPN4llvm4TypeE;_ZN12_GLOBAL__N_123SymbolicallyEvaluateGEPEPKN4llvm11GEPOperatorENS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE;_ZN12_GLOBAL__N_125SymbolicallyEvaluateBinopEjPN4llvm8ConstantES2_RKNS0_10DataLayoutE;_ZN12_GLOBAL__N_127ConstantFoldSSEConvertToIntERKN4llvm7APFloatEbPNS0_4TypeE;_ZN12_GLOBAL__N_128ConstantFoldInstOperandsImplEPKN4llvm5ValueEPNS0_4TypeEjNS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE;_ZN12_GLOBAL__N_130ConstantFoldLoadThroughBitcastEPN4llvm12ConstantExprEPNS0_4TypeERKNS0_10DataLayoutE;_ZN12_GLOBAL__N_131FoldReinterpretLoadFromConstPtrEPN4llvm8ConstantEPNS0_4TypeERKNS0_10DataLayoutE;_ZN12_GLOBAL__N_134ConstantFoldConstantExpressionImplEPKN4llvm12ConstantExprERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoERNS0_15SmallPtrSetImplIPS1_EE; -static-type=ConstantFoldingStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ConstantFoldingStatics {


//===----------------------------------------------------------------------===//
// Constant Folding internal helper functions
//===----------------------------------------------------------------------===//

/// Constant fold bitcast, symbolically evaluating it with DataLayout.
/// This always returns a non-null constant, but it may be a
/// ConstantExpr if unfoldable.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FoldBitCast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 55,
 FQN="(anonymous namespace)::FoldBitCast", NM="_ZN12_GLOBAL__N_111FoldBitCastEPN4llvm8ConstantEPNS0_4TypeERKNS0_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_111FoldBitCastEPN4llvm8ConstantEPNS0_4TypeERKNS0_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ FoldBitCast(Constant /*P*/ C, Type /*P*/ DestTy, final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Recursive helper to read bits out of global. C is the constant being copied
/// out of. ByteOffset is an offset into C. CurPtr is the pointer to copy
/// results into and BytesLeft is the number of bytes left in
/// the CurPtr buffer. DL is the DataLayout.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReadDataFromGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 286,
 FQN="(anonymous namespace)::ReadDataFromGlobal", NM="_ZN12_GLOBAL__N_118ReadDataFromGlobalEPN4llvm8ConstantEyPhjRKNS0_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_118ReadDataFromGlobalEPN4llvm8ConstantEyPhjRKNS0_10DataLayoutE")
//</editor-fold>
public static boolean ReadDataFromGlobal(Constant /*P*/ C, long/*uint64_t*/ ByteOffset, char$ptr/*uchar P*/ CurPtr, 
                  /*uint*/int BytesLeft, final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FoldReinterpretLoadFromConstPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 408,
 FQN="(anonymous namespace)::FoldReinterpretLoadFromConstPtr", NM="_ZN12_GLOBAL__N_131FoldReinterpretLoadFromConstPtrEPN4llvm8ConstantEPNS0_4TypeERKNS0_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_131FoldReinterpretLoadFromConstPtrEPN4llvm8ConstantEPNS0_4TypeERKNS0_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ FoldReinterpretLoadFromConstPtr(Constant /*P*/ C, Type /*P*/ LoadTy, 
                               final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldLoadThroughBitcast">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 497,
 FQN="(anonymous namespace)::ConstantFoldLoadThroughBitcast", NM="_ZN12_GLOBAL__N_130ConstantFoldLoadThroughBitcastEPN4llvm12ConstantExprEPNS0_4TypeERKNS0_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_130ConstantFoldLoadThroughBitcastEPN4llvm12ConstantExprEPNS0_4TypeERKNS0_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadThroughBitcast(ConstantExpr /*P*/ CE, Type /*P*/ DestTy, 
                              final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldLoadInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 625,
 FQN="(anonymous namespace)::ConstantFoldLoadInst", NM="_ZN12_GLOBAL__N_120ConstantFoldLoadInstEPKN4llvm8LoadInstERKNS0_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_120ConstantFoldLoadInstEPKN4llvm8LoadInstERKNS0_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadInst(/*const*/ LoadInst /*P*/ LI, final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// One of Op0/Op1 is a constant expression.
/// Attempt to symbolically evaluate the result of a binary operator merging
/// these together.  If target data info is available, it is provided as DL,
/// otherwise DL is null.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SymbolicallyEvaluateBinop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 638,
 FQN="(anonymous namespace)::SymbolicallyEvaluateBinop", NM="_ZN12_GLOBAL__N_125SymbolicallyEvaluateBinopEjPN4llvm8ConstantES2_RKNS0_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_125SymbolicallyEvaluateBinopEjPN4llvm8ConstantES2_RKNS0_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ SymbolicallyEvaluateBinop(/*uint*/int Opc, Constant /*P*/ Op0, Constant /*P*/ Op1, 
                         final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If array indices are not pointer-sized integers, explicitly cast them so
/// that they aren't implicitly casted by the getelementptr.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastGEPIndices">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 691,
 FQN="(anonymous namespace)::CastGEPIndices", NM="_ZN12_GLOBAL__N_114CastGEPIndicesEPN4llvm4TypeENS0_8ArrayRefIPNS0_8ConstantEEES2_RKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_114CastGEPIndicesEPN4llvm4TypeENS0_8ArrayRefIPNS0_8ConstantEEES2_RKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ CastGEPIndices(Type /*P*/ SrcElemTy, ArrayRef<Constant /*P*/ > Ops, 
              Type /*P*/ ResultTy, final /*const*/ DataLayout /*&*/ DL, 
              /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Strip the pointer casts, but preserve the address space information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StripPtrCastKeepAS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 726,
 FQN="(anonymous namespace)::StripPtrCastKeepAS", NM="_ZN12_GLOBAL__N_118StripPtrCastKeepASEPN4llvm8ConstantERPNS0_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_118StripPtrCastKeepASEPN4llvm8ConstantERPNS0_4TypeE")
//</editor-fold>
public static Constant /*P*/ StripPtrCastKeepAS(Constant /*P*/ Ptr, final type$ref<Type /*P*/ /*&*/> ElemTy) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If we can symbolically evaluate the GEP constant expression, do so.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SymbolicallyEvaluateGEP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 743,
 FQN="(anonymous namespace)::SymbolicallyEvaluateGEP", NM="_ZN12_GLOBAL__N_123SymbolicallyEvaluateGEPEPKN4llvm11GEPOperatorENS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_123SymbolicallyEvaluateGEPEPKN4llvm11GEPOperatorENS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ SymbolicallyEvaluateGEP(/*const*/ GEPOperator /*P*/ GEP, 
                       ArrayRef<Constant /*P*/ > Ops, 
                       final /*const*/ DataLayout /*&*/ DL, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Attempt to constant fold an instruction with the
/// specified opcode and operands.  If successful, the constant result is
/// returned, if not, null is returned.  Note that this function can fail when
/// attempting to fold instructions like loads and stores, which have no
/// constant expression form.
///
/// TODO: This function neither utilizes nor preserves nsw/nuw/inbounds/etc
/// information, due to only being passed an opcode and operands. Constant
/// folding using this function strips this information.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldInstOperandsImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 923,
 FQN="(anonymous namespace)::ConstantFoldInstOperandsImpl", NM="_ZN12_GLOBAL__N_128ConstantFoldInstOperandsImplEPKN4llvm5ValueEPNS0_4TypeEjNS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_128ConstantFoldInstOperandsImplEPKN4llvm5ValueEPNS0_4TypeEjNS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstOperandsImpl(/*const*/ Value /*P*/ InstOrCE, Type /*P*/ DestTy, 
                            /*uint*/int Opcode, 
                            ArrayRef<Constant /*P*/ > Ops, 
                            final /*const*/ DataLayout /*&*/ DL, 
                            /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldConstantExpressionImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1041,
 FQN="(anonymous namespace)::ConstantFoldConstantExpressionImpl", NM="_ZN12_GLOBAL__N_134ConstantFoldConstantExpressionImplEPKN4llvm12ConstantExprERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoERNS0_15SmallPtrSetImplIPS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_134ConstantFoldConstantExpressionImplEPKN4llvm12ConstantExprERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoERNS0_15SmallPtrSetImplIPS1_EE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldConstantExpressionImpl(/*const*/ ConstantExpr /*P*/ CE, final /*const*/ DataLayout /*&*/ DL, 
                                  /*const*/ TargetLibraryInfo /*P*/ TLI, 
                                  final SmallPtrSetImpl<ConstantExpr /*P*/ > /*&*/ FoldedOps) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetConstantFoldFPValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1363,
 FQN="(anonymous namespace)::GetConstantFoldFPValue", NM="_ZN12_GLOBAL__N_122GetConstantFoldFPValueEdPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_122GetConstantFoldFPValueEdPN4llvm4TypeE")
//</editor-fold>
public static Constant /*P*/ GetConstantFoldFPValue(double V, Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Clear the floating-point exception state.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::llvm_fenv_clearexcept">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1378,
 FQN="(anonymous namespace)::llvm_fenv_clearexcept", NM="_ZN12_GLOBAL__N_121llvm_fenv_clearexceptEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_121llvm_fenv_clearexceptEv")
//</editor-fold>
public static /*inline*/ void llvm_fenv_clearexcept() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Test if a floating-point exception was raised.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::llvm_fenv_testexcept">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1386,
 FQN="(anonymous namespace)::llvm_fenv_testexcept", NM="_ZN12_GLOBAL__N_120llvm_fenv_testexceptEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_120llvm_fenv_testexceptEv")
//</editor-fold>
public static /*inline*/ boolean llvm_fenv_testexcept() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1397,
 FQN="(anonymous namespace)::ConstantFoldFP", NM="_ZN12_GLOBAL__N_114ConstantFoldFPEPFddEdPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_114ConstantFoldFPEPFddEdPN4llvm4TypeE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldFP(Double2Double NativeFP, double V, Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldBinaryFP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1408,
 FQN="(anonymous namespace)::ConstantFoldBinaryFP", NM="_ZN12_GLOBAL__N_120ConstantFoldBinaryFPEPFdddEddPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_120ConstantFoldBinaryFPEPFdddEddPN4llvm4TypeE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldBinaryFP(DoubleDouble2Double NativeFP, double V, 
                    double W, Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Attempt to fold an SSE floating point to integer conversion of a constant
/// floating point. If roundTowardZero is false, the default IEEE rounding is
/// used (toward nearest, ties to even). This matches the behavior of the
/// non-truncating SSE instructions in the default rounding mode. The desired
/// integer type Ty is used to select how many bits are available for the
/// result. Returns null if the conversion cannot be performed, otherwise
/// returns the Constant value resulting from the conversion.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldSSEConvertToInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1427,
 FQN="(anonymous namespace)::ConstantFoldSSEConvertToInt", NM="_ZN12_GLOBAL__N_127ConstantFoldSSEConvertToIntERKN4llvm7APFloatEbPNS0_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_127ConstantFoldSSEConvertToIntERKN4llvm7APFloatEbPNS0_4TypeE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldSSEConvertToInt(final /*const*/ APFloat /*&*/ Val, boolean roundTowardZero, 
                           Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getValueAsDouble">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1447,
 FQN="(anonymous namespace)::getValueAsDouble", NM="_ZN12_GLOBAL__N_116getValueAsDoubleEPN4llvm10ConstantFPE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_116getValueAsDoubleEPN4llvm10ConstantFPE")
//</editor-fold>
public static double getValueAsDouble(ConstantFP /*P*/ Op) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldScalarCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1462,
 FQN="(anonymous namespace)::ConstantFoldScalarCall", NM="_ZN12_GLOBAL__N_122ConstantFoldScalarCallEN4llvm9StringRefEjPNS0_4TypeENS0_8ArrayRefIPNS0_8ConstantEEEPKNS0_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_122ConstantFoldScalarCallEN4llvm9StringRefEjPNS0_4TypeENS0_8ArrayRefIPNS0_8ConstantEEEPKNS0_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldScalarCall(StringRef Name, /*uint*/int IntrinsicID, Type /*P*/ Ty, 
                      ArrayRef<Constant /*P*/ > Operands, 
                      /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstantFoldVectorCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1846,
 FQN="(anonymous namespace)::ConstantFoldVectorCall", NM="_ZN12_GLOBAL__N_122ConstantFoldVectorCallEN4llvm9StringRefEjPNS0_10VectorTypeENS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN12_GLOBAL__N_122ConstantFoldVectorCallEN4llvm9StringRefEjPNS0_10VectorTypeENS0_8ArrayRefIPNS0_8ConstantEEERKNS0_10DataLayoutEPKNS0_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldVectorCall(StringRef Name, /*uint*/int IntrinsicID, 
                      VectorType /*P*/ VTy, ArrayRef<Constant /*P*/ > Operands, 
                      final /*const*/ DataLayout /*&*/ DL, 
                      /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ConstantFoldingStatics
