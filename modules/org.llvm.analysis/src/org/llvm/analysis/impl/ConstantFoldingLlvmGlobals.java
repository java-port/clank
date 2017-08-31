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


//<editor-fold defaultstate="collapsed" desc="static type ConstantFoldingLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.ConstantFoldingLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm16ConstantFoldCallEPNS_8FunctionENS_8ArrayRefIPNS_8ConstantEEEPKNS_17TargetLibraryInfoE;_ZN4llvm21canConstantFoldCallToEPKNS_8FunctionE;_ZN4llvm23ConstantFoldCastOperandEjPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE;_ZN4llvm23ConstantFoldInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm24ConstantFoldInstOperandsEPNS_11InstructionENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm24ConstantFoldInstOperandsEjPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm26IsConstantOffsetFromGlobalEPNS_8ConstantERPNS_11GlobalValueERNS_5APIntERKNS_10DataLayoutE;_ZN4llvm28ConstantFoldBinaryOpOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutE;_ZN4llvm28ConstantFoldLoadFromConstPtrEPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE;_ZN4llvm30ConstantFoldConstantExpressionEPKNS_12ConstantExprERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm31ConstantFoldCompareInstOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm33ConstantFoldLoadThroughGEPIndicesEPNS_8ConstantENS_8ArrayRefIS1_EE;_ZN4llvm38ConstantFoldLoadThroughGEPConstantExprEPNS_8ConstantEPNS_12ConstantExprE; -static-type=ConstantFoldingLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class ConstantFoldingLlvmGlobals {


/// If this constant is a constant offset from a global, return the global and
/// the constant. Because of constantexprs, this function is recursive.
// end anonymous namespace

/// If this constant is a constant offset from a global, return the global and
/// the constant. Because of constantexprs, this function is recursive.
//<editor-fold defaultstate="collapsed" desc="llvm::IsConstantOffsetFromGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 242,
 FQN="llvm::IsConstantOffsetFromGlobal", NM="_ZN4llvm26IsConstantOffsetFromGlobalEPNS_8ConstantERPNS_11GlobalValueERNS_5APIntERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm26IsConstantOffsetFromGlobalEPNS_8ConstantERPNS_11GlobalValueERNS_5APIntERKNS_10DataLayoutE")
//</editor-fold>
public static boolean IsConstantOffsetFromGlobal(Constant /*P*/ C, final type$ref<GlobalValue /*P*/ /*&*/> GV, 
                          final APInt /*&*/ Offset, final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldInstruction - Try to constant fold the specified instruction.
/// If successful, the constant result is returned, if not, null is returned.
/// Note that this fails if not all of the operands are constant.  Otherwise,
/// this function can only fail when attempting to fold instructions like loads
/// and stores, which have no constant expression form.
// end anonymous namespace

//===----------------------------------------------------------------------===//
// Constant Folding public APIs
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 969,
 FQN="llvm::ConstantFoldInstruction", NM="_ZN4llvm23ConstantFoldInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm23ConstantFoldInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldInstruction(I, DL, 
                       (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL, 
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldConstantExpression - Attempt to fold the constant expression
/// using the specified DataLayout.  If successful, the constant result is
/// result is returned, if not, null is returned.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldConstantExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1067,
 FQN="llvm::ConstantFoldConstantExpression", NM="_ZN4llvm30ConstantFoldConstantExpressionEPKNS_12ConstantExprERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm30ConstantFoldConstantExpressionEPKNS_12ConstantExprERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldConstantExpression(/*const*/ ConstantExpr /*P*/ CE, 
                              final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldConstantExpression(CE, 
                              DL, 
                              (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldConstantExpression(/*const*/ ConstantExpr /*P*/ CE, 
                              final /*const*/ DataLayout /*&*/ DL, 
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldInstOperands - Attempt to constant fold an instruction with the
/// specified operands.  If successful, the constant result is returned, if not,
/// null is returned.  Note that this function can fail when attempting to
/// fold instructions like loads and stores, which have no constant expression
/// form.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInstOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1074,
 FQN="llvm::ConstantFoldInstOperands", NM="_ZN4llvm24ConstantFoldInstOperandsEPNS_11InstructionENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm24ConstantFoldInstOperandsEPNS_11InstructionENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstOperands(Instruction /*P*/ I, 
                        ArrayRef<Constant /*P*/ > Ops, 
                        final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldInstOperands(I, 
                        Ops, 
                        DL, 
                        (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldInstOperands(Instruction /*P*/ I, 
                        ArrayRef<Constant /*P*/ > Ops, 
                        final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldInstOperands - Attempt to constant fold an instruction with the
/// specified operands.  If successful, the constant result is returned, if not,
/// null is returned.  Note that this function can fail when attempting to
/// fold instructions like loads and stores, which have no constant expression
/// form.
///
/// This function doesn't work for compares (use ConstantFoldCompareInstOperands
/// for this) and GEPs.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInstOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1082,
 FQN="llvm::ConstantFoldInstOperands", NM="_ZN4llvm24ConstantFoldInstOperandsEjPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm24ConstantFoldInstOperandsEjPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstOperands(/*uint*/int Opcode, Type /*P*/ DestTy, 
                        ArrayRef<Constant /*P*/ > Ops, 
                        final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldInstOperands(Opcode, DestTy, 
                        Ops, 
                        DL, 
                        (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldInstOperands(/*uint*/int Opcode, Type /*P*/ DestTy, 
                        ArrayRef<Constant /*P*/ > Ops, 
                        final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldCompareInstOperands - Attempt to constant fold a compare
/// instruction (icmp/fcmp) with the specified operands.  If it fails, it
/// returns a constant expression of the specified operands.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCompareInstOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1090,
 FQN="llvm::ConstantFoldCompareInstOperands", NM="_ZN4llvm31ConstantFoldCompareInstOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm31ConstantFoldCompareInstOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCompareInstOperands(/*uint*/int Predicate, 
                               Constant /*P*/ Ops0, Constant /*P*/ Ops1, 
                               final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldCompareInstOperands(Predicate, 
                               Ops0, Ops1, 
                               DL, 
                               (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldCompareInstOperands(/*uint*/int Predicate, 
                               Constant /*P*/ Ops0, Constant /*P*/ Ops1, 
                               final /*const*/ DataLayout /*&*/ DL, 
                               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Attempt to constant fold a binary operation with the specified
/// operands.  If it fails, it returns a constant expression of the specified
/// operands.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldBinaryOpOperands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1170,
 FQN="llvm::ConstantFoldBinaryOpOperands", NM="_ZN4llvm28ConstantFoldBinaryOpOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm28ConstantFoldBinaryOpOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldBinaryOpOperands(/*uint*/int Opcode, Constant /*P*/ LHS, 
                            Constant /*P*/ RHS, 
                            final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Attempt to constant fold a cast with the specified operand.  If it
/// fails, it returns a constant expression of the specified operand.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCastOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1181,
 FQN="llvm::ConstantFoldCastOperand", NM="_ZN4llvm23ConstantFoldCastOperandEjPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm23ConstantFoldCastOperandEjPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCastOperand(/*uint*/int Opcode, Constant /*P*/ C, 
                       Type /*P*/ DestTy, final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldLoadFromConstPtr - Return the value that a load from C would
/// produce if it is constant and determinable.  If this is not determinable,
/// return null.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldLoadFromConstPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 544,
 FQN="llvm::ConstantFoldLoadFromConstPtr", NM="_ZN4llvm28ConstantFoldLoadFromConstPtrEPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm28ConstantFoldLoadFromConstPtrEPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadFromConstPtr(Constant /*P*/ C, Type /*P*/ Ty, 
                            final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldLoadThroughGEPConstantExpr - Given a constant and a
/// getelementptr constantexpr, return the constant value being addressed by the
/// constant expression, or null if something is funny and we can't decide.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldLoadThroughGEPConstantExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1242,
 FQN="llvm::ConstantFoldLoadThroughGEPConstantExpr", NM="_ZN4llvm38ConstantFoldLoadThroughGEPConstantExprEPNS_8ConstantEPNS_12ConstantExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm38ConstantFoldLoadThroughGEPConstantExprEPNS_8ConstantEPNS_12ConstantExprE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadThroughGEPConstantExpr(Constant /*P*/ C, 
                                      ConstantExpr /*P*/ CE) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldLoadThroughGEPIndices - Given a constant and getelementptr
/// indices (with an *implied* zero pointer index that is not in the list),
/// return the constant value being addressed by a virtual load, or null if
/// something is funny and we can't decide.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldLoadThroughGEPIndices">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1257,
 FQN="llvm::ConstantFoldLoadThroughGEPIndices", NM="_ZN4llvm33ConstantFoldLoadThroughGEPIndicesEPNS_8ConstantENS_8ArrayRefIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm33ConstantFoldLoadThroughGEPIndicesEPNS_8ConstantENS_8ArrayRefIS1_EE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadThroughGEPIndices(Constant /*P*/ C, 
                                 ArrayRef<Constant /*P*/ > Indices) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// canConstantFoldCallTo - Return true if its even possible to fold a call to
/// the specified function.

//===----------------------------------------------------------------------===//
//  Constant Folding for Calls
//
//<editor-fold defaultstate="collapsed" desc="llvm::canConstantFoldCallTo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1274,
 FQN="llvm::canConstantFoldCallTo", NM="_ZN4llvm21canConstantFoldCallToEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm21canConstantFoldCallToEPKNS_8FunctionE")
//</editor-fold>
public static boolean canConstantFoldCallTo(/*const*/ Function /*P*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// ConstantFoldCall - Attempt to constant fold a call to the specified function
/// with the specified arguments, returning null if unsuccessful.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp", line = 1915,
 FQN="llvm::ConstantFoldCall", NM="_ZN4llvm16ConstantFoldCallEPNS_8FunctionENS_8ArrayRefIPNS_8ConstantEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ConstantFolding.cpp -nm=_ZN4llvm16ConstantFoldCallEPNS_8FunctionENS_8ArrayRefIPNS_8ConstantEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCall(Function /*P*/ F, ArrayRef<Constant /*P*/ > Operands) {
  return ConstantFoldCall(F, Operands, 
                (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldCall(Function /*P*/ F, ArrayRef<Constant /*P*/ > Operands, 
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ConstantFoldingLlvmGlobals
