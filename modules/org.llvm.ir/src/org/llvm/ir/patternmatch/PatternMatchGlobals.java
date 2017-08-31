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
package org.llvm.ir.patternmatch;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import org.llvm.ir.java.*;


//<editor-fold defaultstate="collapsed" desc="static type PatternMatchGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.patternmatch.PatternMatchGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch10m_ArgumentERKT0_;Tpl__ZN4llvm12PatternMatch10m_PtrToIntERKT_;Tpl__ZN4llvm12PatternMatch11m_CombineOrERKT_RKT0_;Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_;Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_;Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_RKT2_;Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_RKT2_RKT3_;Tpl__ZN4llvm12PatternMatch11m_IntrinsicEv;Tpl__ZN4llvm12PatternMatch11m_SelectCstERKT1_;Tpl__ZN4llvm12PatternMatch11m_UnordFMaxERKT_RKT0_;Tpl__ZN4llvm12PatternMatch11m_UnordFMinERKT_RKT0_;Tpl__ZN4llvm12PatternMatch12m_CombineAndERKT_RKT0_;Tpl__ZN4llvm12PatternMatch13m_ConstantIntEv;Tpl__ZN4llvm12PatternMatch14m_LogicalShiftERKT_RKT0_;Tpl__ZN4llvm12PatternMatch18m_UAddWithOverflowERKT_RKT0_RKT1_;Tpl__ZN4llvm12PatternMatch4m_BrERKT_RPNS_10BasicBlockES6_;Tpl__ZN4llvm12PatternMatch4m_OrERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_AddERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_AndERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_CmpERNS_7CmpInst9PredicateERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_MulERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_NegERKT_;Tpl__ZN4llvm12PatternMatch5m_NotERKT_;Tpl__ZN4llvm12PatternMatch5m_ShlERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_ShrERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_SubERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5m_XorERKT_RKT0_;Tpl__ZN4llvm12PatternMatch5matchEPT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_AShrERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FAddERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FCmpERNS_7CmpInst9PredicateERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FDivERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FMaxERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FMinERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FMulERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FNegERKT_;Tpl__ZN4llvm12PatternMatch6m_FRemERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_FSubERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_ICmpERNS_7CmpInst9PredicateERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_IDivERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_LShrERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_SDivERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_SExtERKT_;Tpl__ZN4llvm12PatternMatch6m_SMaxERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_SMinERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_SRemERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_UDivERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_UMaxERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_UMinERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_URemERKT_RKT0_;Tpl__ZN4llvm12PatternMatch6m_ZExtERKT_;Tpl__ZN4llvm12PatternMatch6m_c_OrERKT_RKT0_;Tpl__ZN4llvm12PatternMatch7m_BSwapERKT_;Tpl__ZN4llvm12PatternMatch7m_BinOpERKT_RKT0_;Tpl__ZN4llvm12PatternMatch7m_ExactERKT_;Tpl__ZN4llvm12PatternMatch7m_TruncERKT_;Tpl__ZN4llvm12PatternMatch7m_c_AndERKT_RKT0_;Tpl__ZN4llvm12PatternMatch7m_c_XorERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NSWAddERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NSWMulERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NSWShlERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NSWSubERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NUWAddERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NUWMulERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NUWShlERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_NUWSubERKT_RKT0_;Tpl__ZN4llvm12PatternMatch8m_OneUseERKT_;Tpl__ZN4llvm12PatternMatch8m_SIToFPERKT_;Tpl__ZN4llvm12PatternMatch8m_SelectERKT_RKT0_RKT1_;Tpl__ZN4llvm12PatternMatch8m_SignumERKT_;Tpl__ZN4llvm12PatternMatch8m_UIToFPERKT_;Tpl__ZN4llvm12PatternMatch8m_c_ICmpERNS_7CmpInst9PredicateERKT_RKT0_;Tpl__ZN4llvm12PatternMatch9m_BitCastERKT_;Tpl__ZN4llvm12PatternMatch9m_OrdFMaxERKT_RKT0_;Tpl__ZN4llvm12PatternMatch9m_OrdFMinERKT_RKT0_;_ZN4llvm12PatternMatch10m_ConstantERPNS_8ConstantE;_ZN4llvm12PatternMatch10m_ConstantEv;_ZN4llvm12PatternMatch10m_SpecificEPKNS_5ValueE;_ZN4llvm12PatternMatch12m_ConstantFPERPNS_10ConstantFPE;_ZN4llvm12PatternMatch12m_SpecificFPEd;_ZN4llvm12PatternMatch13m_ConstantIntERPNS_11ConstantIntE;_ZN4llvm12PatternMatch13m_ConstantIntERy;_ZN4llvm12PatternMatch13m_ConstantIntEv;_ZN4llvm12PatternMatch13m_InstructionERPNS_11InstructionE;_ZN4llvm12PatternMatch13m_SpecificIntEy;_ZN4llvm12PatternMatch16m_MaxSignedValueERPKNS_5APIntE;_ZN4llvm12PatternMatch16m_MaxSignedValueEv;_ZN4llvm12PatternMatch17m_UnconditionalBrERPNS_10BasicBlockE;_ZN4llvm12PatternMatch5m_CmpEv;_ZN4llvm12PatternMatch5m_OneERPKNS_5APIntE;_ZN4llvm12PatternMatch5m_OneEv;_ZN4llvm12PatternMatch6m_ZeroEv;_ZN4llvm12PatternMatch7m_APIntERPKNS_5APIntE;_ZN4llvm12PatternMatch7m_BinOpERPNS_14BinaryOperatorE;_ZN4llvm12PatternMatch7m_BinOpEv;_ZN4llvm12PatternMatch7m_FPOneEv;_ZN4llvm12PatternMatch7m_UndefEv;_ZN4llvm12PatternMatch7m_ValueERPNS_5ValueE;_ZN4llvm12PatternMatch7m_ValueEv;_ZN4llvm12PatternMatch8m_Power2ERPKNS_5APIntE;_ZN4llvm12PatternMatch8m_Power2Ev;_ZN4llvm12PatternMatch9m_AllOnesERPKNS_5APIntE;_ZN4llvm12PatternMatch9m_AllOnesEv;_ZN4llvm12PatternMatch9m_AnyZeroEv;_ZN4llvm12PatternMatch9m_NegZeroEv;_ZN4llvm12PatternMatch9m_SignBitERPKNS_5APIntE;_ZN4llvm12PatternMatch9m_SignBitEv; -static-type=PatternMatchGlobals -package=org.llvm.ir.patternmatch")
//</editor-fold>
public final class PatternMatchGlobals {

/*template <typename Val, typename Pattern> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::match">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 41,
 FQN="llvm::PatternMatch::match", NM="Tpl__ZN4llvm12PatternMatch5matchEPT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5matchEPT_RKT0_")
//</editor-fold>
public static </*typename*/ Val extends Value, /*typename*/ Pattern extends match> boolean match(Val /*P*/ V, final /*const*/ Pattern /*&*/ P) {
  return ((/*const_cast*/Pattern /*&*/ )(P)).match(V);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_OneUse">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 55,
 FQN="llvm::PatternMatch::m_OneUse", NM="Tpl__ZN4llvm12PatternMatch8m_OneUseERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_OneUseERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T extends match<T>> OneUse_match<T> m_OneUse(final /*const*/ T /*&*/ SubPattern) {
  return new OneUse_match<T>(SubPattern);
}


/// \brief Match an arbitrary value and ignore it.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Value">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 64,
 FQN="llvm::PatternMatch::m_Value", NM="_ZN4llvm12PatternMatch7m_ValueEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_ValueEv")
//</editor-fold>
public static /*inline*/ class_match<Value> m_Value() {
  return new class_match<Value>(Value.class);
}


/// \brief Match an arbitrary binary operation and ignore it.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_BinOp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 67,
 FQN="llvm::PatternMatch::m_BinOp", NM="_ZN4llvm12PatternMatch7m_BinOpEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_BinOpEv")
//</editor-fold>
public static /*inline*/ class_match<BinaryOperator> m_BinOp() {
  return new class_match<BinaryOperator>(BinaryOperator.class);
}


/// \brief Matches any compare instruction and ignore it.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Cmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 72,
 FQN="llvm::PatternMatch::m_Cmp", NM="_ZN4llvm12PatternMatch5m_CmpEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch5m_CmpEv")
//</editor-fold>
public static /*inline*/ class_match<CmpInst> m_Cmp() {
  return new class_match<CmpInst>(CmpInst.class);
}


/// \brief Match an arbitrary ConstantInt and ignore it.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ConstantInt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 75,
 FQN="llvm::PatternMatch::m_ConstantInt", NM="_ZN4llvm12PatternMatch13m_ConstantIntEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch13m_ConstantIntEv")
//</editor-fold>
public static /*inline*/ class_match<ConstantInt> m_ConstantInt_class_match() {
  return new class_match<ConstantInt>(ConstantInt.class);
}


/// \brief Match an arbitrary undef constant.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Undef">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 80,
 FQN="llvm::PatternMatch::m_Undef", NM="_ZN4llvm12PatternMatch7m_UndefEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_UndefEv")
//</editor-fold>
public static /*inline*/ class_match<UndefValue> m_Undef() {
  return new class_match<UndefValue>(UndefValue.class);
}


/// \brief Match an arbitrary Constant and ignore it.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Constant">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 83,
 FQN="llvm::PatternMatch::m_Constant", NM="_ZN4llvm12PatternMatch10m_ConstantEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch10m_ConstantEv")
//</editor-fold>
public static /*inline*/ class_match<Constant> m_Constant() {
  return new class_match<Constant>(Constant.class);
}


/// Combine two pattern matchers matching L || R
/*template <typename LTy, typename RTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_CombineOr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 117,
 FQN="llvm::PatternMatch::m_CombineOr", NM="Tpl__ZN4llvm12PatternMatch11m_CombineOrERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_CombineOrERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LTy extends match<LTy>, /*typename*/ RTy extends match<RTy>> match_combine_or<LTy, RTy> m_CombineOr(final /*const*/ LTy /*&*/ L, final /*const*/ RTy /*&*/ R) {
  return new match_combine_or<LTy, RTy>(L, R);
}


/// Combine two pattern matchers matching L && R
/*template <typename LTy, typename RTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_CombineAnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 123,
 FQN="llvm::PatternMatch::m_CombineAnd", NM="Tpl__ZN4llvm12PatternMatch12m_CombineAndERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch12m_CombineAndERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LTy extends match<LTy>, /*typename*/ RTy extends match<RTy>> match_combine_and<LTy, RTy> m_CombineAnd(final /*const*/ LTy /*&*/ L, final /*const*/ RTy /*&*/ R) {
  return new match_combine_and<LTy, RTy>(L, R);
}


/// \brief Match an arbitrary zero/null constant.  This includes
/// zero_initializer for vectors and ConstantPointerNull for pointers.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Zero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 137,
 FQN="llvm::PatternMatch::m_Zero", NM="_ZN4llvm12PatternMatch6m_ZeroEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch6m_ZeroEv")
//</editor-fold>
public static /*inline*/ match_zero m_Zero() {
  return new match_zero();
}


/// \brief Match an arbitrary zero/null constant.  This includes
/// zero_initializer for vectors and ConstantPointerNull for pointers. For
/// floating point constants, this will match negative zero but not positive
/// zero
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NegZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 151,
 FQN="llvm::PatternMatch::m_NegZero", NM="_ZN4llvm12PatternMatch9m_NegZeroEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9m_NegZeroEv")
//</editor-fold>
public static /*inline*/ match_neg_zero m_NegZero() {
  return new match_neg_zero();
}


/// \brief - Match an arbitrary zero/null constant.  This includes
/// zero_initializer for vectors and ConstantPointerNull for pointers. For
/// floating point constants, this will match negative zero and positive zero
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_AnyZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 156,
 FQN="llvm::PatternMatch::m_AnyZero", NM="_ZN4llvm12PatternMatch9m_AnyZeroEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9m_AnyZeroEv")
//</editor-fold>
public static /*inline*/ match_combine_or<match_zero, match_neg_zero> m_AnyZero() {
  return m_CombineOr(m_Zero(), m_NegZero());
}


/// \brief Match a ConstantInt or splatted ConstantVector, binding the
/// specified pointer to the contained APInt.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_APInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 180,
 FQN="llvm::PatternMatch::m_APInt", NM="_ZN4llvm12PatternMatch7m_APIntERPKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_APIntERPKNS_5APIntE")
//</editor-fold>
public static /*inline*/ apint_match m_APInt(final type$ref</*const*/ APInt /*P*/ /*&*/> Res) {
  return new apint_match(Res);
}


/// \brief Match a ConstantInt with a specific value.
/*template <int64_t Val> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ConstantInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 198,
 FQN="llvm::PatternMatch::m_ConstantInt", NM="Tpl__ZN4llvm12PatternMatch13m_ConstantIntEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch13m_ConstantIntEv")
//</editor-fold>
public static /*inline*/ constantint_match m_ConstantInt_ci_match(long/*int64_t*/ Val) {
  return new constantint_match(Val);
}


/// \brief Match an integer 1 or a vector with all elements equal to 1.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_One">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 244,
 FQN="llvm::PatternMatch::m_One", NM="_ZN4llvm12PatternMatch5m_OneEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch5m_OneEv")
//</editor-fold>
public static /*inline*/ cst_pred_ty<is_one> m_One() {
  return new cst_pred_ty<is_one>(new is_one());
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_One">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 245,
 FQN="llvm::PatternMatch::m_One", NM="_ZN4llvm12PatternMatch5m_OneERPKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch5m_OneERPKNS_5APIntE")
//</editor-fold>
public static /*inline*/ api_pred_ty<is_one> m_One(final type$ref</*const*/ APInt /*P*/ /*&*/> V) {
  return new api_pred_ty<is_one>(new is_one(), V);
}


/// \brief Match an integer or vector with all bits set to true.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_AllOnes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 252,
 FQN="llvm::PatternMatch::m_AllOnes", NM="_ZN4llvm12PatternMatch9m_AllOnesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9m_AllOnesEv")
//</editor-fold>
public static /*inline*/ cst_pred_ty<is_all_ones> m_AllOnes() {
  return new cst_pred_ty<is_all_ones>(new is_all_ones());
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_AllOnes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 255,
 FQN="llvm::PatternMatch::m_AllOnes", NM="_ZN4llvm12PatternMatch9m_AllOnesERPKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9m_AllOnesERPKNS_5APIntE")
//</editor-fold>
public static /*inline*/ api_pred_ty<is_all_ones> m_AllOnes(final type$ref</*const*/ APInt /*P*/ /*&*/> V) {
  return new api_pred_ty<is_all_ones>(new is_all_ones(), V);
}


/// \brief Match an integer or vector with only the sign bit(s) set.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SignBit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 262,
 FQN="llvm::PatternMatch::m_SignBit", NM="_ZN4llvm12PatternMatch9m_SignBitEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9m_SignBitEv")
//</editor-fold>
public static /*inline*/ cst_pred_ty<is_sign_bit> m_SignBit() {
  return new cst_pred_ty<is_sign_bit>(new is_sign_bit());
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SignBit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 265,
 FQN="llvm::PatternMatch::m_SignBit", NM="_ZN4llvm12PatternMatch9m_SignBitERPKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9m_SignBitERPKNS_5APIntE")
//</editor-fold>
public static /*inline*/ api_pred_ty<is_sign_bit> m_SignBit(final type$ref</*const*/ APInt /*P*/ /*&*/> V) {
  return new api_pred_ty<is_sign_bit>(new is_sign_bit(), V);
}


/// \brief Match an integer or vector power of 2.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Power2">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 272,
 FQN="llvm::PatternMatch::m_Power2", NM="_ZN4llvm12PatternMatch8m_Power2Ev",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch8m_Power2Ev")
//</editor-fold>
public static /*inline*/ cst_pred_ty<is_power2> m_Power2() {
  return new cst_pred_ty<is_power2>(new is_power2());
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Power2">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 273,
 FQN="llvm::PatternMatch::m_Power2", NM="_ZN4llvm12PatternMatch8m_Power2ERPKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch8m_Power2ERPKNS_5APIntE")
//</editor-fold>
public static /*inline*/ api_pred_ty<is_power2> m_Power2(final type$ref</*const*/ APInt /*P*/ /*&*/> V) {
  return new api_pred_ty<is_power2>(new is_power2(), V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_MaxSignedValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 279,
 FQN="llvm::PatternMatch::m_MaxSignedValue", NM="_ZN4llvm12PatternMatch16m_MaxSignedValueEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch16m_MaxSignedValueEv")
//</editor-fold>
public static /*inline*/ cst_pred_ty<is_maxsignedvalue> m_MaxSignedValue() {
  return new cst_pred_ty<is_maxsignedvalue>(new is_maxsignedvalue());
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_MaxSignedValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 280,
 FQN="llvm::PatternMatch::m_MaxSignedValue", NM="_ZN4llvm12PatternMatch16m_MaxSignedValueERPKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch16m_MaxSignedValueERPKNS_5APIntE")
//</editor-fold>
public static /*inline*/ api_pred_ty<is_maxsignedvalue> m_MaxSignedValue(final type$ref</*const*/ APInt /*P*/ /*&*/> V) {
  return new api_pred_ty<is_maxsignedvalue>(new is_maxsignedvalue(), V);
}


/// \brief Match a value, capturing it if we match.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Value">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 296,
 FQN="llvm::PatternMatch::m_Value", NM="_ZN4llvm12PatternMatch7m_ValueERPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_ValueERPNS_5ValueE")
//</editor-fold>
public static /*inline*/ bind_ty<Value> m_Value(final type$ref<Value /*P*/ /*&*/> V) {
  return new bind_ty<Value>(Value.class, V);
}


/// \brief Match an instruction, capturing it if we match.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Instruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 299,
 FQN="llvm::PatternMatch::m_Instruction", NM="_ZN4llvm12PatternMatch13m_InstructionERPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch13m_InstructionERPNS_11InstructionE")
//</editor-fold>
public static /*inline*/ bind_ty<Instruction> m_Instruction(final type$ref<Instruction /*P*/ /*&*/> I) {
  return new bind_ty<Instruction>(Instruction.class, I);
}


/// \brief Match a binary operator, capturing it if we match.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_BinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 302,
 FQN="llvm::PatternMatch::m_BinOp", NM="_ZN4llvm12PatternMatch7m_BinOpERPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_BinOpERPNS_14BinaryOperatorE")
//</editor-fold>
public static /*inline*/ bind_ty<BinaryOperator> m_BinOp(final type$ref<BinaryOperator /*P*/ /*&*/> I) {
  return new bind_ty<BinaryOperator>(BinaryOperator.class, I);
}


/// \brief Match a ConstantInt, capturing the value if we match.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ConstantInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 305,
 FQN="llvm::PatternMatch::m_ConstantInt", NM="_ZN4llvm12PatternMatch13m_ConstantIntERPNS_11ConstantIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch13m_ConstantIntERPNS_11ConstantIntE")
//</editor-fold>
public static /*inline*/ bind_ty<ConstantInt> m_ConstantInt_bind_ty(final type$ref<ConstantInt /*P*/ /*&*/> CI) {
  return new bind_ty<ConstantInt>(ConstantInt.class, CI);
}


/// \brief Match a Constant, capturing the value if we match.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Constant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 308,
 FQN="llvm::PatternMatch::m_Constant", NM="_ZN4llvm12PatternMatch10m_ConstantERPNS_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch10m_ConstantERPNS_8ConstantE")
//</editor-fold>
public static /*inline*/ bind_ty<Constant> m_Constant(final type$ref<Constant /*P*/ /*&*/> C) {
  return new bind_ty<Constant>(Constant.class, C);
}


/// \brief Match a ConstantFP, capturing the value if we match.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ConstantFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 311,
 FQN="llvm::PatternMatch::m_ConstantFP", NM="_ZN4llvm12PatternMatch12m_ConstantFPERPNS_10ConstantFPE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch12m_ConstantFPERPNS_10ConstantFPE")
//</editor-fold>
public static /*inline*/ bind_ty<ConstantFP> m_ConstantFP(final type$ref<ConstantFP /*P*/ /*&*/> C) {
  return new bind_ty<ConstantFP>(ConstantFP.class, C);
}


/// \brief Match if we have a specific specified value.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Specific">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 322,
 FQN="llvm::PatternMatch::m_Specific", NM="_ZN4llvm12PatternMatch10m_SpecificEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch10m_SpecificEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ specificval_ty m_Specific(/*const*/ Value /*P*/ V) {
  return new specificval_ty(V);
}


/// \brief Match a specific floating point value or vector with all elements
/// equal to the value.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SpecificFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 343,
 FQN="llvm::PatternMatch::m_SpecificFP", NM="_ZN4llvm12PatternMatch12m_SpecificFPEd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch12m_SpecificFPEd")
//</editor-fold>
public static /*inline*/ specific_fpval m_SpecificFP(double V) {
  return new specific_fpval(V);
}


/// \brief Match a float 1.0 or vector with all elements equal to 1.0.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FPOne">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 346,
 FQN="llvm::PatternMatch::m_FPOne", NM="_ZN4llvm12PatternMatch7m_FPOneEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch7m_FPOneEv")
//</editor-fold>
public static /*inline*/ specific_fpval m_FPOne() {
  return m_SpecificFP(1.);
}


/// \brief Match a specific integer value or vector with all elements equal to
/// the value.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SpecificInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 383,
 FQN="llvm::PatternMatch::m_SpecificInt", NM="_ZN4llvm12PatternMatch13m_SpecificIntEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch13m_SpecificIntEy")
//</editor-fold>
public static /*inline*/ specific_intval m_SpecificInt(long/*uint64_t*/ V) {
  return new specific_intval(V);
}


/// \brief Match a ConstantInt and bind to its value.  This does not match
/// ConstantInts wider than 64-bits.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ConstantInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 387,
 FQN="llvm::PatternMatch::m_ConstantInt", NM="_ZN4llvm12PatternMatch13m_ConstantIntERy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch13m_ConstantIntERy")
//</editor-fold>
public static /*inline*/ bind_const_intval_ty m_ConstantInt_bind_ci_ty(final ulong$ref/*uint64_t &*/ V) {
  return new bind_const_intval_ty(V);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_BinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 406,
 FQN="llvm::PatternMatch::m_BinOp", NM="Tpl__ZN4llvm12PatternMatch7m_BinOpERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch7m_BinOpERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> AnyBinaryOp_match<LHS, RHS> m_BinOp$T(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new AnyBinaryOp_match<LHS, RHS>(L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Add">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 434,
 FQN="llvm::PatternMatch::m_Add", NM="Tpl__ZN4llvm12PatternMatch5m_AddERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_AddERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_Add(final /*const*/ LHS /*&*/ L, 
     final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Add, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 440,
 FQN="llvm::PatternMatch::m_FAdd", NM="Tpl__ZN4llvm12PatternMatch6m_FAddERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FAddERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_FAdd(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.FAdd, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Sub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 446,
 FQN="llvm::PatternMatch::m_Sub", NM="Tpl__ZN4llvm12PatternMatch5m_SubERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_SubERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_Sub(final /*const*/ LHS /*&*/ L, 
     final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Sub, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 452,
 FQN="llvm::PatternMatch::m_FSub", NM="Tpl__ZN4llvm12PatternMatch6m_FSubERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FSubERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_FSub(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.FSub, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Mul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 458,
 FQN="llvm::PatternMatch::m_Mul", NM="Tpl__ZN4llvm12PatternMatch5m_MulERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_MulERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_Mul(final /*const*/ LHS /*&*/ L, 
     final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Mul, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 464,
 FQN="llvm::PatternMatch::m_FMul", NM="Tpl__ZN4llvm12PatternMatch6m_FMulERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FMulERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_FMul(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.FMul, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 470,
 FQN="llvm::PatternMatch::m_UDiv", NM="Tpl__ZN4llvm12PatternMatch6m_UDivERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_UDivERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_UDiv(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.UDiv, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 476,
 FQN="llvm::PatternMatch::m_SDiv", NM="Tpl__ZN4llvm12PatternMatch6m_SDivERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_SDivERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_SDiv(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.SDiv, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 482,
 FQN="llvm::PatternMatch::m_FDiv", NM="Tpl__ZN4llvm12PatternMatch6m_FDivERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FDivERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_FDiv(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.FDiv, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_URem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 488,
 FQN="llvm::PatternMatch::m_URem", NM="Tpl__ZN4llvm12PatternMatch6m_URemERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_URemERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_URem(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.URem, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SRem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 494,
 FQN="llvm::PatternMatch::m_SRem", NM="Tpl__ZN4llvm12PatternMatch6m_SRemERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_SRemERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_SRem(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.SRem, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FRem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 500,
 FQN="llvm::PatternMatch::m_FRem", NM="Tpl__ZN4llvm12PatternMatch6m_FRemERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FRemERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_FRem(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.FRem, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_And">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 506,
 FQN="llvm::PatternMatch::m_And", NM="Tpl__ZN4llvm12PatternMatch5m_AndERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_AndERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_And(final /*const*/ LHS /*&*/ L, 
     final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.And, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Or">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 512,
 FQN="llvm::PatternMatch::m_Or", NM="Tpl__ZN4llvm12PatternMatch4m_OrERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch4m_OrERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_Or(final /*const*/ LHS /*&*/ L, 
    final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Or, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Xor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 518,
 FQN="llvm::PatternMatch::m_Xor", NM="Tpl__ZN4llvm12PatternMatch5m_XorERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_XorERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_Xor(final /*const*/ LHS /*&*/ L, 
     final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Xor, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Shl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 524,
 FQN="llvm::PatternMatch::m_Shl", NM="Tpl__ZN4llvm12PatternMatch5m_ShlERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_ShlERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_Shl(final /*const*/ LHS /*&*/ L, 
     final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Shl, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_LShr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 530,
 FQN="llvm::PatternMatch::m_LShr", NM="Tpl__ZN4llvm12PatternMatch6m_LShrERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_LShrERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_LShr(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.LShr, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_AShr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 536,
 FQN="llvm::PatternMatch::m_AShr", NM="Tpl__ZN4llvm12PatternMatch6m_AShrERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_AShrERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinaryOp_match<LHS, RHS> m_AShr(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new BinaryOp_match<LHS, RHS>(Instruction.BinaryOps.AShr, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NSWAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 567,
 FQN="llvm::PatternMatch::m_NSWAdd", NM="Tpl__ZN4llvm12PatternMatch8m_NSWAddERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NSWAddERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NSWAdd(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Add, OverflowingBinaryOperator.NoSignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NSWSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 575,
 FQN="llvm::PatternMatch::m_NSWSub", NM="Tpl__ZN4llvm12PatternMatch8m_NSWSubERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NSWSubERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NSWSub(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Sub, OverflowingBinaryOperator.NoSignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NSWMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 583,
 FQN="llvm::PatternMatch::m_NSWMul", NM="Tpl__ZN4llvm12PatternMatch8m_NSWMulERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NSWMulERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NSWMul(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Mul, OverflowingBinaryOperator.NoSignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NSWShl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 591,
 FQN="llvm::PatternMatch::m_NSWShl", NM="Tpl__ZN4llvm12PatternMatch8m_NSWShlERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NSWShlERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NSWShl(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Shl, OverflowingBinaryOperator.NoSignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NUWAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 600,
 FQN="llvm::PatternMatch::m_NUWAdd", NM="Tpl__ZN4llvm12PatternMatch8m_NUWAddERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NUWAddERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NUWAdd(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Add, OverflowingBinaryOperator.NoUnsignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NUWSub">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 608,
 FQN="llvm::PatternMatch::m_NUWSub", NM="Tpl__ZN4llvm12PatternMatch8m_NUWSubERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NUWSubERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NUWSub(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Sub, OverflowingBinaryOperator.NoUnsignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NUWMul">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 616,
 FQN="llvm::PatternMatch::m_NUWMul", NM="Tpl__ZN4llvm12PatternMatch8m_NUWMulERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NUWMulERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NUWMul(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Mul, OverflowingBinaryOperator.NoUnsignedWrap, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_NUWShl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 624,
 FQN="llvm::PatternMatch::m_NUWShl", NM="Tpl__ZN4llvm12PatternMatch8m_NUWShlERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_NUWShlERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> OverflowingBinaryOp_match<LHS, RHS> m_NUWShl(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new OverflowingBinaryOp_match<LHS, RHS>(Instruction.BinaryOps.Shl, OverflowingBinaryOperator.NoUnsignedWrap, L, R);
}


/// \brief Matches LShr or AShr.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Shr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 657,
 FQN="llvm::PatternMatch::m_Shr", NM="Tpl__ZN4llvm12PatternMatch5m_ShrERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_ShrERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinOp2_match<LHS, RHS> m_Shr(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new BinOp2_match<LHS, RHS>(Instruction.BinaryOps.LShr, Instruction.BinaryOps.AShr, L, R);
}


/// \brief Matches LShr or Shl.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_LogicalShift">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 664,
 FQN="llvm::PatternMatch::m_LogicalShift", NM="Tpl__ZN4llvm12PatternMatch14m_LogicalShiftERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch14m_LogicalShiftERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinOp2_match<LHS, RHS> m_LogicalShift(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new BinOp2_match<LHS, RHS>(Instruction.BinaryOps.LShr, Instruction.BinaryOps.Shl, L, R);
}


/// \brief Matches UDiv and SDiv.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_IDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 671,
 FQN="llvm::PatternMatch::m_IDiv", NM="Tpl__ZN4llvm12PatternMatch6m_IDivERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_IDivERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> BinOp2_match<LHS, RHS> m_IDiv(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new BinOp2_match<LHS, RHS>(Instruction.BinaryOps.SDiv, Instruction.BinaryOps.UDiv, L, R);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Exact">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 691,
 FQN="llvm::PatternMatch::m_Exact", NM="Tpl__ZN4llvm12PatternMatch7m_ExactERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch7m_ExactERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T extends match<T>> Exact_match<T> m_Exact(final /*const*/ T /*&*/ SubPattern) {
  return new Exact_match<T>(SubPattern);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Cmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 719,
 FQN="llvm::PatternMatch::m_Cmp", NM="Tpl__ZN4llvm12PatternMatch5m_CmpERNS_7CmpInst9PredicateERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_CmpERNS_7CmpInst9PredicateERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> CmpClass_match<LHS, RHS, CmpInst, CmpInst.Predicate> m_Cmp$T(final type$ref<CmpInst.Predicate /*&*/> Pred, final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new CmpClass_match<LHS, RHS, CmpInst, CmpInst.Predicate>(CmpInst.class, Pred, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ICmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 725,
 FQN="llvm::PatternMatch::m_ICmp", NM="Tpl__ZN4llvm12PatternMatch6m_ICmpERNS_7CmpInst9PredicateERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_ICmpERNS_7CmpInst9PredicateERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> CmpClass_match<LHS, RHS, ICmpInst, ICmpInst.Predicate> m_ICmp(final type$ref<ICmpInst.Predicate /*&*/> Pred, final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new CmpClass_match<LHS, RHS, ICmpInst, ICmpInst.Predicate>(ICmpInst.class, Pred, L, R);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FCmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 731,
 FQN="llvm::PatternMatch::m_FCmp", NM="Tpl__ZN4llvm12PatternMatch6m_FCmpERNS_7CmpInst9PredicateERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FCmpERNS_7CmpInst9PredicateERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> CmpClass_match<LHS, RHS, FCmpInst, FCmpInst.Predicate> m_FCmp(final type$ref<FCmpInst.Predicate /*&*/> Pred, final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new CmpClass_match<LHS, RHS, FCmpInst, FCmpInst.Predicate>(FCmpInst.class, Pred, L, R);
}

/*template <typename Cond, typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Select">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 758,
 FQN="llvm::PatternMatch::m_Select", NM="Tpl__ZN4llvm12PatternMatch8m_SelectERKT_RKT0_RKT1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_SelectERKT_RKT0_RKT1_")
//</editor-fold>
public static /*inline*/ </*typename*/ Cond extends match<Cond>, /*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> SelectClass_match<Cond, LHS, RHS> m_Select(final /*const*/ Cond /*&*/ C, final /*const*/ LHS /*&*/ L, 
        final /*const*/ RHS /*&*/ R) {
  return new SelectClass_match<Cond, LHS, RHS>(C, L, R);
}


/// \brief This matches a select of two constants, e.g.:
/// m_SelectCst<-1, 0>(m_Value(V))
/*template <int64_t L, int64_t R, typename Cond> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SelectCst">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 766,
 FQN="llvm::PatternMatch::m_SelectCst", NM="Tpl__ZN4llvm12PatternMatch11m_SelectCstERKT1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_SelectCstERKT1_")
//</editor-fold>
public static /*inline*/ </*typename*/ Cond extends match<Cond>> SelectClass_match<Cond, constantint_match, constantint_match> m_SelectCst(long/*int64_t*/ L, long/*int64_t*/ R, final /*const*/ Cond /*&*/ C) {
  return m_Select(C, m_ConstantInt_ci_match/*<L>*/(L), m_ConstantInt_ci_match/*<R>*/(R));
}


/// \brief Matches BitCast.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_BitCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 789,
 FQN="llvm::PatternMatch::m_BitCast", NM="Tpl__ZN4llvm12PatternMatch9m_BitCastERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch9m_BitCastERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_BitCast(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.BitCast, Op);
}


/// \brief Matches PtrToInt.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_PtrToInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 795,
 FQN="llvm::PatternMatch::m_PtrToInt", NM="Tpl__ZN4llvm12PatternMatch10m_PtrToIntERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch10m_PtrToIntERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_PtrToInt(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.PtrToInt, Op);
}


/// \brief Matches Trunc.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Trunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 801,
 FQN="llvm::PatternMatch::m_Trunc", NM="Tpl__ZN4llvm12PatternMatch7m_TruncERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch7m_TruncERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_Trunc(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.Trunc, Op);
}


/// \brief Matches SExt.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 807,
 FQN="llvm::PatternMatch::m_SExt", NM="Tpl__ZN4llvm12PatternMatch6m_SExtERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_SExtERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_SExt(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.SExt, Op);
}


/// \brief Matches ZExt.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_ZExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 813,
 FQN="llvm::PatternMatch::m_ZExt", NM="Tpl__ZN4llvm12PatternMatch6m_ZExtERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_ZExtERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_ZExt(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.ZExt, Op);
}


/// \brief Matches UIToFP.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UIToFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 819,
 FQN="llvm::PatternMatch::m_UIToFP", NM="Tpl__ZN4llvm12PatternMatch8m_UIToFPERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_UIToFPERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_UIToFP(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.UIToFP, Op);
}


/// \brief Matches SIToFP.
/*template <typename OpTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SIToFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 825,
 FQN="llvm::PatternMatch::m_SIToFP", NM="Tpl__ZN4llvm12PatternMatch8m_SIToFPERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_SIToFPERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ OpTy extends match<OpTy>> CastClass_match<OpTy> m_SIToFP(final /*const*/ OpTy /*&*/ Op) {
  return new CastClass_match<OpTy>(Instruction.CastOps.SIToFP, Op);
}

/*template <typename LHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Not">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 854,
 FQN="llvm::PatternMatch::m_Not", NM="Tpl__ZN4llvm12PatternMatch5m_NotERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_NotERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>> not_match<LHS> m_Not(final /*const*/ LHS /*&*/ L) {
  return new not_match<LHS>(L);
}


/// \brief Match an integer negate.
/*template <typename LHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Neg">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 877,
 FQN="llvm::PatternMatch::m_Neg", NM="Tpl__ZN4llvm12PatternMatch5m_NegERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch5m_NegERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>> neg_match<LHS> m_Neg(final /*const*/ LHS /*&*/ L) {
  return new neg_match<LHS>(L);
}


/// \brief Match a floating point negate.
/*template <typename LHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FNeg">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 900,
 FQN="llvm::PatternMatch::m_FNeg", NM="Tpl__ZN4llvm12PatternMatch6m_FNegERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FNegERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>> fneg_match<LHS> m_FNeg(final /*const*/ LHS /*&*/ L) {
  return new fneg_match<LHS>(L);
}

//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UnconditionalBr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 922,
 FQN="llvm::PatternMatch::m_UnconditionalBr", NM="_ZN4llvm12PatternMatch17m_UnconditionalBrERPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch17m_UnconditionalBrERPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ br_match m_UnconditionalBr(final type$ref<BasicBlock /*P*/ /*&*/> Succ) {
  return new br_match(Succ);
}

/*template <typename Cond_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Br">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 942,
 FQN="llvm::PatternMatch::m_Br", NM="Tpl__ZN4llvm12PatternMatch4m_BrERKT_RPNS_10BasicBlockES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch4m_BrERKT_RPNS_10BasicBlockES6_")
//</editor-fold>
public static /*inline*/ </*typename*/ Cond_t extends match<Cond_t>> brc_match<Cond_t> m_Br(final /*const*/ Cond_t /*&*/ C, final type$ref<BasicBlock /*P*/ /*&*/> T, final type$ref<BasicBlock /*P*/ /*&*/> F) {
  return new brc_match<Cond_t>(C, T, F);
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SMax">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1041,
 FQN="llvm::PatternMatch::m_SMax", NM="Tpl__ZN4llvm12PatternMatch6m_SMaxERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_SMaxERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<ICmpInst, LHS, RHS, smax_pred_ty> m_SMax(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<ICmpInst, LHS, RHS, smax_pred_ty>(ICmpInst.class, L, R, new smax_pred_ty());
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_SMin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1047,
 FQN="llvm::PatternMatch::m_SMin", NM="Tpl__ZN4llvm12PatternMatch6m_SMinERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_SMinERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<ICmpInst, LHS, RHS, smin_pred_ty> m_SMin(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<ICmpInst, LHS, RHS, smin_pred_ty>(ICmpInst.class, L, R, new smin_pred_ty());
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UMax">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1053,
 FQN="llvm::PatternMatch::m_UMax", NM="Tpl__ZN4llvm12PatternMatch6m_UMaxERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_UMaxERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<ICmpInst, LHS, RHS, umax_pred_ty> m_UMax(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<ICmpInst, LHS, RHS, umax_pred_ty>(ICmpInst.class, L, R, new umax_pred_ty());
}

/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UMin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1059,
 FQN="llvm::PatternMatch::m_UMin", NM="Tpl__ZN4llvm12PatternMatch6m_UMinERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_UMinERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<ICmpInst, LHS, RHS, umin_pred_ty> m_UMin(final /*const*/ LHS /*&*/ L, 
      final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<ICmpInst, LHS, RHS, umin_pred_ty>(ICmpInst.class, L, R, new umin_pred_ty());
}


/// \brief Match an 'ordered' floating point maximum function.
/// Floating point has one special value 'NaN'. Therefore, there is no total
/// order. However, if we can ignore the 'NaN' value (for example, because of a
/// 'no-nans-float-math' flag) a combination of a fcmp and select has 'maximum'
/// semantics. In the presence of 'NaN' we have to preserve the original
/// select(fcmp(ogt/ge, L, R), L, R) semantics matched by this predicate.
///
///                         max(L, R)  iff L and R are not NaN
///  m_OrdFMax(L, R) =      R          iff L or R are NaN
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_OrdFMax">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1074,
 FQN="llvm::PatternMatch::m_OrdFMax", NM="Tpl__ZN4llvm12PatternMatch9m_OrdFMaxERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch9m_OrdFMaxERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<FCmpInst, LHS, RHS, ofmax_pred_ty> m_OrdFMax(final /*const*/ LHS /*&*/ L, 
         final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<FCmpInst, LHS, RHS, ofmax_pred_ty>(FCmpInst.class, L, R, new ofmax_pred_ty());
}


/// \brief Match an 'ordered' floating point minimum function.
/// Floating point has one special value 'NaN'. Therefore, there is no total
/// order. However, if we can ignore the 'NaN' value (for example, because of a
/// 'no-nans-float-math' flag) a combination of a fcmp and select has 'minimum'
/// semantics. In the presence of 'NaN' we have to preserve the original
/// select(fcmp(olt/le, L, R), L, R) semantics matched by this predicate.
///
///                         max(L, R)  iff L and R are not NaN
///  m_OrdFMin(L, R) =      R          iff L or R are NaN
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_OrdFMin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1089,
 FQN="llvm::PatternMatch::m_OrdFMin", NM="Tpl__ZN4llvm12PatternMatch9m_OrdFMinERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch9m_OrdFMinERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<FCmpInst, LHS, RHS, ofmin_pred_ty> m_OrdFMin(final /*const*/ LHS /*&*/ L, 
         final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<FCmpInst, LHS, RHS, ofmin_pred_ty>(FCmpInst.class, L, R, new ofmin_pred_ty());
}


/// \brief Match an 'unordered' floating point maximum function.
/// Floating point has one special value 'NaN'. Therefore, there is no total
/// order. However, if we can ignore the 'NaN' value (for example, because of a
/// 'no-nans-float-math' flag) a combination of a fcmp and select has 'maximum'
/// semantics. In the presence of 'NaN' we have to preserve the original
/// select(fcmp(ugt/ge, L, R), L, R) semantics matched by this predicate.
///
///                         max(L, R)  iff L and R are not NaN
///  m_UnordFMin(L, R) =    L          iff L or R are NaN
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UnordFMax">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1104,
 FQN="llvm::PatternMatch::m_UnordFMax", NM="Tpl__ZN4llvm12PatternMatch11m_UnordFMaxERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_UnordFMaxERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<FCmpInst, LHS, RHS, ufmax_pred_ty> m_UnordFMax(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<FCmpInst, LHS, RHS, ufmax_pred_ty>(FCmpInst.class, L, R, new ufmax_pred_ty());
}


/// \brief Match an icmp instruction checking for unsigned overflow on addition.
///
/// S is matched to the addition whose result is being checked for overflow, and
/// L and R are matched to the LHS and RHS of S.
/*template <typename LHS_t, typename RHS_t, typename Sum_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UAddWithOverflow">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1150,
 FQN="llvm::PatternMatch::m_UAddWithOverflow", NM="Tpl__ZN4llvm12PatternMatch18m_UAddWithOverflowERKT_RKT0_RKT1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch18m_UAddWithOverflowERKT_RKT0_RKT1_")
//</editor-fold>
public static </*typename*/ LHS_t extends match<LHS_t>, /*typename*/ RHS_t extends match<RHS_t>, /*typename*/ Sum_t extends match<Sum_t>> UAddWithOverflow_match<LHS_t, RHS_t, Sum_t> m_UAddWithOverflow(final /*const*/ LHS_t /*&*/ L, final /*const*/ RHS_t /*&*/ R, final /*const*/ Sum_t /*&*/ S) {
  return new UAddWithOverflow_match<LHS_t, RHS_t, Sum_t>(L, R, S);
}


/// \brief Match an 'unordered' floating point minimum function.
/// Floating point has one special value 'NaN'. Therefore, there is no total
/// order. However, if we can ignore the 'NaN' value (for example, because of a
/// 'no-nans-float-math' flag) a combination of a fcmp and select has 'minimum'
/// semantics. In the presence of 'NaN' we have to preserve the original
/// select(fcmp(ult/le, L, R), L, R) semantics matched by this predicate.
///
///                          max(L, R)  iff L and R are not NaN
///  m_UnordFMin(L, R) =     L          iff L or R are NaN
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_UnordFMin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1165,
 FQN="llvm::PatternMatch::m_UnordFMin", NM="Tpl__ZN4llvm12PatternMatch11m_UnordFMinERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_UnordFMinERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> MaxMin_match<FCmpInst, LHS, RHS, ufmin_pred_ty> m_UnordFMin(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return new MaxMin_match<FCmpInst, LHS, RHS, ufmin_pred_ty>(FCmpInst.class, L, R, new ufmin_pred_ty());
}


/// \brief Match an argument.
/*template <unsigned int OpI, typename Opnd_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Argument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1183,
 FQN="llvm::PatternMatch::m_Argument", NM="Tpl__ZN4llvm12PatternMatch10m_ArgumentERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch10m_ArgumentERKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ Opnd_t extends match<Opnd_t>> Argument_match<Opnd_t> m_Argument(/*uint*/int OpI, final /*const*/ Opnd_t /*&*/ Op) {
  return new Argument_match<Opnd_t>(OpI, Op);
}


/// \brief Match intrinsic calls like this:
/// m_Intrinsic<Intrinsic::fabs>(m_Value(X))
/*template <Intrinsic::ID IntrID> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Intrinsic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1229,
 FQN="llvm::PatternMatch::m_Intrinsic", NM="Tpl__ZN4llvm12PatternMatch11m_IntrinsicEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_IntrinsicEv")
//</editor-fold>
public static /*inline*/ IntrinsicID_match m_Intrinsic(/*Intrinsic.ID*/int IntrID) {
  return new IntrinsicID_match(IntrID);
}

/*template <Intrinsic::ID IntrID, typename T0> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Intrinsic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1234,
 FQN="llvm::PatternMatch::m_Intrinsic", NM="Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ T0 extends match>  match m_Intrinsic(/*Intrinsic.ID*/int IntrID, final /*const*/ T0 /*&*/ Op0) {
  return m_CombineAnd(m_Intrinsic/*<IntrID>*/(IntrID), m_Argument/*<0>*/(0, Op0));
}

/*template <Intrinsic::ID IntrID, typename T0, typename T1> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Intrinsic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1239,
 FQN="llvm::PatternMatch::m_Intrinsic", NM="Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_")
//</editor-fold>
public static /*inline*/ </*typename*/ T0 extends match, /*typename*/ T1 extends match>  match m_Intrinsic(/*Intrinsic.ID*/int IntrID, final /*const*/ T0 /*&*/ Op0, 
           final /*const*/ T1 /*&*/ Op1) {
  return m_CombineAnd(m_Intrinsic/*<IntrID>*/(IntrID, Op0), m_Argument/*<1>*/(1, Op1));
}

/*template <Intrinsic::ID IntrID, typename T0, typename T1, typename T2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Intrinsic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1245,
 FQN="llvm::PatternMatch::m_Intrinsic", NM="Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_RKT2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_RKT2_")
//</editor-fold>
public static /*inline*/ </*typename*/ T0 extends match, /*typename*/ T1 extends match, /*typename*/ T2 extends match>  match m_Intrinsic(/*Intrinsic.ID*/int IntrID, final /*const*/ T0 /*&*/ Op0, final /*const*/ T1 /*&*/ Op1, final /*const*/ T2 /*&*/ Op2) {
  return m_CombineAnd(m_Intrinsic/*<IntrID>*/(IntrID, Op0, Op1), m_Argument/*<2>*/(2, Op2));
}

/*template <Intrinsic::ID IntrID, typename T0, typename T1, typename T2, typename T3> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Intrinsic">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1252,
 FQN="llvm::PatternMatch::m_Intrinsic", NM="Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_RKT2_RKT3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch11m_IntrinsicERKT0_RKT1_RKT2_RKT3_")
//</editor-fold>
public static /*inline*/ </*typename*/ T0 extends match, /*typename*/ T1 extends match, /*typename*/ T2 extends match, /*typename*/ T3 extends match>  match m_Intrinsic(/*Intrinsic.ID*/int IntrID, final /*const*/ T0 /*&*/ Op0, final /*const*/ T1 /*&*/ Op1, final /*const*/ T2 /*&*/ Op2, final /*const*/ T3 /*&*/ Op3) {
  return m_CombineAnd(m_Intrinsic/*<IntrID>*/(IntrID, Op0, Op1, Op2), m_Argument/*<3>*/(3, Op3));
}


// Helper intrinsic matching specializations.
/*template <typename Opnd0> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_BSwap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1259,
 FQN="llvm::PatternMatch::m_BSwap", NM="Tpl__ZN4llvm12PatternMatch7m_BSwapERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch7m_BSwapERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ Opnd0 extends match>  match m_BSwap(final /*const*/ Opnd0 /*&*/ Op0) {
  return m_Intrinsic/*<Intrinsic.ID.bswap>*/(ID.bswap, Op0);
}

/*template <typename Opnd0, typename Opnd1> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FMin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1264,
 FQN="llvm::PatternMatch::m_FMin", NM="Tpl__ZN4llvm12PatternMatch6m_FMinERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FMinERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ Opnd0 extends match, /*typename*/ Opnd1 extends match>  match m_FMin(final /*const*/ Opnd0 /*&*/ Op0, 
      final /*const*/ Opnd1 /*&*/ Op1) {
  return m_Intrinsic/*<Intrinsic.ID.minnum>*/(ID.minnum, Op0, Op1);
}

/*template <typename Opnd0, typename Opnd1> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_FMax">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1270,
 FQN="llvm::PatternMatch::m_FMax", NM="Tpl__ZN4llvm12PatternMatch6m_FMaxERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_FMaxERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ Opnd0 extends match, /*typename*/ Opnd1 extends match>  match m_FMax(final /*const*/ Opnd0 /*&*/ Op0, 
      final /*const*/ Opnd1 /*&*/ Op1) {
  return m_Intrinsic/*<Intrinsic.ID.maxnum>*/(ID.maxnum, Op0, Op1);
}


/// \brief Matches a signum pattern.
///
/// signum(x) =
///      x >  0  ->  1
///      x == 0  ->  0
///      x <  0  -> -1
/*template <typename Val_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_Signum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1311,
 FQN="llvm::PatternMatch::m_Signum", NM="Tpl__ZN4llvm12PatternMatch8m_SignumERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_SignumERKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ Val_t extends match<Val_t>> Signum_match<Val_t> m_Signum(final /*const*/ Val_t /*&*/ V) {
  return new Signum_match<Val_t>(V);
}


//===----------------------------------------------------------------------===//
// Matchers for two-operands operators with the operators in either order
//

/// \brief Matches an ICmp with a predicate over LHS and RHS in either order.
/// Does not swap the predicate.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_c_ICmp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1322,
 FQN="llvm::PatternMatch::m_c_ICmp", NM="Tpl__ZN4llvm12PatternMatch8m_c_ICmpERNS_7CmpInst9PredicateERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch8m_c_ICmpERNS_7CmpInst9PredicateERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> match_combine_or m_c_ICmp(final type$ref<ICmpInst.Predicate /*&*/> Pred, final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return m_CombineOr(m_ICmp(Pred, L, R), m_ICmp(Pred, R, L));
}


/// \brief Matches an And with LHS and RHS in either order.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_c_And">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1330,
 FQN="llvm::PatternMatch::m_c_And", NM="Tpl__ZN4llvm12PatternMatch7m_c_AndERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch7m_c_AndERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> match_combine_or m_c_And(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return m_CombineOr(m_And(L, R), m_And(R, L));
}


/// \brief Matches an Or with LHS and RHS in either order.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_c_Or">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1338,
 FQN="llvm::PatternMatch::m_c_Or", NM="Tpl__ZN4llvm12PatternMatch6m_c_OrERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch6m_c_OrERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> match_combine_or m_c_Or(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return m_CombineOr(m_Or(L, R), m_Or(R, L));
}


/// \brief Matches an Xor with LHS and RHS in either order.
/*template <typename LHS, typename RHS> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::m_c_Xor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1346,
 FQN="llvm::PatternMatch::m_c_Xor", NM="Tpl__ZN4llvm12PatternMatch7m_c_XorERKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch7m_c_XorERKT_RKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ LHS extends match<LHS>, /*typename*/ RHS extends match<RHS>> match_combine_or m_c_Xor(final /*const*/ LHS /*&*/ L, final /*const*/ RHS /*&*/ R) {
  return m_CombineOr(m_Xor(L, R), m_Xor(R, L));
}

} // END OF class PatternMatchGlobals
