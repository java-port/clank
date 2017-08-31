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
package org.llvm.support;

import org.clank.java.std;
import org.clank.java.std_errors.errc;
import org.clank.java.std_errors.error_code;
import org.clank.support.*;
import org.clank.support.Native.NativeIterable;
import org.clank.support.NativeCallback.BoolPredicate;
import org.clank.support.NativeCallback.Type2VoidPtr;
import org.clank.support.NativeCallback.Void2Void;
import org.clank.support.NativeCallback.VoidPtr2Void;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.$EMPTY;
import org.llvm.adt.*;
import org.llvm.adt.HashingGlobals.hash_code;
import org.llvm.adt.java.*;
import org.llvm.mc.*;


//<editor-fold defaultstate="collapsed" desc="static type AdtsupportLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp ${LLVM_SRC}/llvm/lib/Support/APInt.cpp ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXString.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp ${LLVM_SRC}/llvm/lib/IR/Core.cpp ${LLVM_SRC}/llvm/lib/Support/DataStream.cpp ${LLVM_SRC}/llvm/lib/Support/Debug.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp ${LLVM_SRC}/llvm/lib/Support/Error.cpp ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp ${LLVM_SRC}/llvm/lib/Support/FileUtilities.cpp ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp ${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCELFStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/MCExternalSymbolizer.cpp ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/MCRelocationInfo.cpp ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp ${LLVM_SRC}/llvm/lib/MC/MCParser/MCTargetAsmParser.cpp ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp ${LLVM_SRC}/llvm/lib/Support/MD5.cpp ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp ${LLVM_SRC}/llvm/lib/IR/Operator.cpp ${LLVM_SRC}/llvm/lib/Support/Path.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/PtrState.cpp ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp ${LLVM_SRC}/llvm/lib/Support/ScopedPrinter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp ${LLVM_SRC}/llvm/lib/Support/SmallVector.cpp ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp ${LLVM_SRC}/llvm/lib/MC/SubtargetFeature.cpp ${LLVM_SRC}/llvm/lib/Support/SystemUtils.cpp ${LLVM_SRC}/llvm/lib/Support/Threading.cpp ${LLVM_SRC}/llvm/lib/Support/Timer.cpp ${LLVM_SRC}/llvm/lib/Support/Twine.cpp ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=Tpl__ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_;Tpl__ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE;Tpl__ZN4llvm10df_ext_endERKT_RT0_;Tpl__ZN4llvm10drop_beginEOT_i;Tpl__ZN4llvm10hash_valueENS_8ArrayRefIT_EE;Tpl__ZN4llvm10hash_valueEPKT_;Tpl__ZN4llvm10hash_valueERKSbIT_St11char_traitsIS0_ESaIS0_EE;Tpl__ZN4llvm10hash_valueERKSt4pairIT_T0_E;Tpl__ZN4llvm10hash_valueET_R_ZTSNSt9enable_ifIXsr19is_integral_or_enumIT_EE5valueEN4llvm9hash_codeEE4typeE;Tpl__ZN4llvm10make_errorEDpOT0_;Tpl__ZN4llvm10make_rangeESt4pairIT_S1_E;Tpl__ZN4llvm10make_rangeET_S0_;Tpl__ZN4llvm10po_ext_endET_RT0_;Tpl__ZN4llvm10post_orderERKT_;Tpl__ZN4llvm11depth_firstERKT_;Tpl__ZN4llvm11findLastSetET_NS_12ZeroBehaviorE;Tpl__ZN4llvm11getTypeNameEv;Tpl__ZN4llvm11idf_ext_endERKT_RT0_;Tpl__ZN4llvm11ipo_ext_endERKT_RT0_;Tpl__ZN4llvm11make_uniqueEDpOT0_R_ZTSNSt9enable_ifIXntsr3std8is_arrayIT_EE5valueESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE;Tpl__ZN4llvm11make_uniqueEjR_ZTSNSt9enable_ifIXaasr3std8is_arrayIT_EE5valueeqsr3std6extentIS0_EE5valueLi0EESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE;Tpl__ZN4llvm11reverseBitsET_;Tpl__ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj;Tpl__ZN4llvm12SignExtend32Ej;Tpl__ZN4llvm12SignExtend64Ey;Tpl__ZN4llvm12cast_or_nullEPT0_;Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE;Tpl__ZN4llvm12df_ext_beginERKT_RT0_;Tpl__ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE;Tpl__ZN4llvm12handleErrorsENS_5ErrorEDpOT_;Tpl__ZN4llvm12hash_combineEDpRKT_;Tpl__ZN4llvm12isShiftedIntEx;Tpl__ZN4llvm12is_containedEOT_RKT0_;Tpl__ZN4llvm12makeArrayRefEPKT_S2_;Tpl__ZN4llvm12makeArrayRefEPKT_j;Tpl__ZN4llvm12makeArrayRefERAT0__KT_;Tpl__ZN4llvm12makeArrayRefERKNS_11SmallVectorIT_XT0_EEE;Tpl__ZN4llvm12makeArrayRefERKNS_15SmallVectorImplIT_EE;Tpl__ZN4llvm12makeArrayRefERKNS_8ArrayRefIT_EE;Tpl__ZN4llvm12makeArrayRefERKSt6vectorIT_SaIS1_EE;Tpl__ZN4llvm12makeArrayRefERKT_;Tpl__ZN4llvm12makeArrayRefERNS_8ArrayRefIT_EE;Tpl__ZN4llvm12map_iteratorERKT_T0_;Tpl__ZN4llvm12po_ext_beginET_RT0_;Tpl__ZN4llvm12set_subtractERT_RKT0_;Tpl__ZN4llvm13SaturatingAddET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm13idf_ext_beginERKT_RT0_;Tpl__ZN4llvm13ipo_ext_beginERKT_RT0_;Tpl__ZN4llvm13isShiftedUIntEy;Tpl__ZN4llvm13set_intersectERT_RKT0_;Tpl__ZN4llvm14array_lengthofERAT0__T_;Tpl__ZN4llvm14array_pod_sortET_S0_;Tpl__ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E;Tpl__ZN4llvm14object_creatorEv;Tpl__ZN4llvm14post_order_extERKT_RT0_;Tpl__ZN4llvm14set_differenceERKT_RKT0_;Tpl__ZN4llvm15countPopulationET_;Tpl__ZN4llvm15depth_first_extERKT_RT0_;Tpl__ZN4llvm15handleAllErrorsENS_5ErrorEDpOT_;Tpl__ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EEOT_DpOT0_;Tpl__ZN4llvm16countLeadingOnesET_NS_12ZeroBehaviorE;Tpl__ZN4llvm16dyn_cast_or_nullEPT0_;Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm16dyn_cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE;Tpl__ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE;Tpl__ZN4llvm17countTrailingOnesET_NS_12ZeroBehaviorE;Tpl__ZN4llvm17errorOrToExpectedEONS_7ErrorOrIT_EE;Tpl__ZN4llvm17expectedToErrorOrEONS_8ExpectedIT_EE;Tpl__ZN4llvm17make_filter_rangeEOT_T0_;Tpl__ZN4llvm18AbsoluteDifferenceET_S0_R_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm18SaturatingMultiplyET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE;Tpl__ZN4llvm18hash_combine_rangeET_S0_;Tpl__ZN4llvm18inverse_post_orderERKT_;Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj;Tpl__ZN4llvm19inverse_depth_firstERKT_;Tpl__ZN4llvm21SaturatingMultiplyAddET_S0_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE;Tpl__ZN4llvm21make_reverse_iteratorET_;Tpl__ZN4llvm22DeleteContainerSecondsERT_;Tpl__ZN4llvm22inverse_post_order_extERKT_RT0_;Tpl__ZN4llvm23DeleteContainerPointersERT_;Tpl__ZN4llvm23inverse_depth_first_extERKT_RT0_;Tpl__ZN4llvm25array_pod_sort_comparatorEPKvS1_;Tpl__ZN4llvm29get_array_pod_sort_comparatorERKT_;Tpl__ZN4llvm3isaERKT0_;Tpl__ZN4llvm4EvalERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j;Tpl__ZN4llvm4castEPT0_;Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm4castERT0_;Tpl__ZN4llvm4findEOT_RKT0_;Tpl__ZN4llvm4joinET_S0_NS_9StringRefE;Tpl__ZN4llvm5isIntEx;Tpl__ZN4llvm6all_ofEOT_OT0_;Tpl__ZN4llvm6any_ofEOT_OT0_;Tpl__ZN4llvm6df_endERKT_;Tpl__ZN4llvm6formatEPKcDpRKT_;Tpl__ZN4llvm6isUIntEy;Tpl__ZN4llvm6po_endERKT_;Tpl__ZN4llvm7DFSPassERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j;Tpl__ZN4llvm7alignOfEv;Tpl__ZN4llvm7deleterEPT_;Tpl__ZN4llvm7find_ifEOT_RKT0_;Tpl__ZN4llvm7idf_endERKT_;Tpl__ZN4llvm7ipo_endERKT_;Tpl__ZN4llvm7none_ofEOT_OT0_;Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXntsr10has_rbeginIS0_EE5valueEvE4typeE;Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXsr10has_rbeginIS0_EE5valueEvE4typeE;Tpl__ZN4llvm7scc_endERKNS_7InverseIT_EE;Tpl__ZN4llvm7scc_endERKT_;Tpl__ZN4llvm8count_ifEOT_OT0_;Tpl__ZN4llvm8df_beginERKT_;Tpl__ZN4llvm8dyn_castEPT0_;Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE;Tpl__ZN4llvm8dyn_castERT0_;Tpl__ZN4llvm8po_beginERKT_;Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_;Tpl__ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE;Tpl__ZN4llvm9call_onceERSt9once_flagOT_DpOT0_;Tpl__ZN4llvm9idf_beginERKT_;Tpl__ZN4llvm9ipo_beginERKT_;Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag;Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag;Tpl__ZN4llvm9remove_ifEOT_OT0_;Tpl__ZN4llvm9scc_beginERKNS_7InverseIT_EE;Tpl__ZN4llvm9scc_beginERKT_;Tpl__ZN4llvm9set_unionERT_RKT0_;Tpl__ZN4llvm9to_stringERKT_;Tpl__ZN4llvm9transformEOT_T0_OT1_;Tpl__ZN4llvmL17capacity_in_bytesERKNS_11SmallVectorIT_XT0_EEE;Tpl__ZN4llvmL17capacity_in_bytesERKNS_8DenseMapIT_T0_T1_NS_6detail12DenseMapPairIS1_S2_EEEE;Tpl__ZN4llvmL17capacity_in_bytesERKT_;Tpl__ZN4llvmL21isValidAtomicOrderingET_;Tpl__ZN4llvmL25isValidAtomicOrderingCABIET_;Tpl__ZN4llvmdvERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmeqEDnRKNS_18IntrusiveRefCntPtrIT_EE;Tpl__ZN4llvmeqENS_12PointerUnionIT_T0_EES3_;Tpl__ZN4llvmeqENS_8ArrayRefIT_EES2_;Tpl__ZN4llvmeqENS_8NoneTypeERKNS_8OptionalIT_EE;Tpl__ZN4llvmeqEPT_RKNS_18IntrusiveRefCntPtrIT0_EE;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEDn;Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEPT0_;Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE;Tpl__ZN4llvmeqERKNS_7ErrorOrIT_EET0_R_ZTSNSt9enable_ifIXoosr3std18is_error_code_enumIT0_EE5valuesr3std23is_error_condition_enumIS0_EE5valueEbE4typeE;Tpl__ZN4llvmeqERKNS_8OptionalIT_EENS_8NoneTypeE;Tpl__ZN4llvmeqEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmeqEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmeqExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmeqEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmgeEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgeEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmgtEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmgtEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmleEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmleEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmlsERKNS_12ScaledNumberIT_EEs;Tpl__ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE;Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltENS_12PointerUnionIT_T0_EES3_;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmltEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmltEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmmiERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmmlERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmneEDnRKNS_18IntrusiveRefCntPtrIT_EE;Tpl__ZN4llvmneENS_12PointerUnionIT_T0_EES3_;Tpl__ZN4llvmneENS_8ArrayRefIT_EES2_;Tpl__ZN4llvmneENS_8NoneTypeERKNS_8OptionalIT_EE;Tpl__ZN4llvmneEPT_RKNS_18IntrusiveRefCntPtrIT0_EE;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEi;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEj;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEx;Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEy;Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEDn;Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEPT0_;Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE;Tpl__ZN4llvmneERKNS_8OptionalIT_EENS_8NoneTypeE;Tpl__ZN4llvmneEiRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmneEjRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmneExRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmneEyRKNS_12ScaledNumberIT_EE;Tpl__ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_;Tpl__ZN4llvmplERKNS_12ScaledNumberIT_EES4_;Tpl__ZN4llvmrsERKNS_12ScaledNumberIT_EEs;_ZN4llvm10format_hexEyjb;_ZN4llvm10hash_valueENS_9StringRefE;_ZN4llvm10hash_valueERKNS_5APIntE;_ZN4llvm10hash_valueERKNS_7APFloatE;_ZN4llvm10joinErrorsENS_5ErrorES0_;_ZN4llvm11BitsToFloatEj;_ZN4llvm11ByteSwap_16Et;_ZN4llvm11ByteSwap_32Ej;_ZN4llvm11ByteSwap_64Ey;_ZN4llvm11FloatToBitsEf;_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_;_ZN4llvm12BitsToDoubleEy;_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE;_ZN4llvm12DoubleToBitsEd;_ZN4llvm12Log2_32_CeilEj;_ZN4llvm12Log2_64_CeilEy;_ZN4llvm12NextPowerOf2Ey;_ZN4llvm12SignExtend32Ejj;_ZN4llvm12SignExtend64Eyj;_ZN4llvm12consumeErrorENS_5ErrorE;_ZN4llvm12left_justifyENS_9StringRefEj;_ZN4llvm12to_hexStringEyb;_ZN4llvm13PowerOf2FloorEy;_ZN4llvm13decodeSLEB128EPKhPj;_ZN4llvm13decodeULEB128EPKhPj;_ZN4llvm13encodeSLEB128ExRNS_11raw_ostreamE;_ZN4llvm13encodeULEB128EyPhj;_ZN4llvm13encodeULEB128EyRNS_11raw_ostreamEj;_ZN4llvm13isPowerOf2_32Ej;_ZN4llvm13isPowerOf2_64Ey;_ZN4llvm13llvm_shutdownEv;_ZN4llvm13right_justifyENS_9StringRefEj;_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_;_ZN4llvm14format_decimalExj;_ZN4llvm14getSLEB128SizeEx;_ZN4llvm14getULEB128SizeEy;_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE;_ZN4llvm15PrintStatisticsEv;_ZN4llvm15handleAllErrorsENS_5ErrorE;_ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EE;_ZN4llvm15make_error_codeENS_4errcE;_ZN4llvm16EnableStatisticsEv;_ZN4llvm16errorCodeToErrorESt10error_code;_ZN4llvm16errorToErrorCodeENS_5ErrorE;_ZN4llvm16isShiftedMask_32Ej;_ZN4llvm16isShiftedMask_64Ey;_ZN4llvm17ConvertUTF8toWideENS_9StringRefERSbIwSt11char_traitsIwESaIwEE;_ZN4llvm17ConvertUTF8toWideEPKcRSbIwSt11char_traitsIwESaIwEE;_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh;_ZN4llvm17OffsetToAlignmentEyy;_ZN4llvm17convertWideToUTF8ERKSbIwSt11char_traitsIwESaIwEERSs;_ZN4llvm17createAsmStreamerERNS_9MCContextESt10unique_ptrINS_21formatted_raw_ostreamESt14default_deleteIS3_EEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb;_ZN4llvm17createELFStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEb;_ZN4llvm17createMCAsmParserERNS_9SourceMgrERNS_9MCContextERNS_10MCStreamerERKNS_9MCAsmInfoE;_ZN4llvm18createMCSymbolizerERKNS_6TripleEPFiPvyyyiS3_EPFPKcS3_yPyyPS7_ES3_PNS_9MCContextEOSt10unique_ptrINS_16MCRelocationInfoESt14default_deleteISF_EE;_ZN4llvm18createNullStreamerERNS_9MCContextE;_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx;_ZN4llvm18isCurrentDebugTypeEPKc;_ZN4llvm18report_fatal_errorENS_5ErrorEb;_ZN4llvm18report_fatal_errorENS_9StringRefEb;_ZN4llvm18report_fatal_errorEPKcb;_ZN4llvm18report_fatal_errorERKNS_5TwineEb;_ZN4llvm18report_fatal_errorERKSsb;_ZN4llvm19PrintStatisticsJSONERNS_11raw_ostreamE;_ZN4llvm19alignmentAdjustmentEPKvj;_ZN4llvm19createGraphFilenameERKNS_5TwineERi;_ZN4llvm19createMachOStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbb;_ZN4llvm19getDataFileStreamerERKSsPSs;_ZN4llvm19setCurrentDebugTypeEPKc;_ZN4llvm20AreStatisticsEnabledEv;_ZN4llvm20CreateInfoOutputFileEv;_ZN4llvm20EnableDebugBufferingE;_ZN4llvm20InitializeAllTargetsEv;_ZN4llvm20SavePrettyStackStateEv;_ZN4llvm20computeBundlePaddingERKNS_11MCAssemblerEPKNS_10MCFragmentEyy;_ZN4llvm20format_hex_no_prefixEyjb;_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy;_ZN4llvm21createELFObjectWriterEPNS_23MCELFObjectTargetWriterERNS_17raw_pwrite_streamEb;_ZN4llvm21hasUTF16ByteOrderMarkENS_8ArrayRefIcEE;_ZN4llvm21llvm_is_multithreadedEv;_ZN4llvm21logAllUnhandledErrorsENS_5ErrorERNS_11raw_ostreamENS_5TwineE;_ZN4llvm22ConvertCodePointToUTF8EjRPc;_ZN4llvm22DiffFilesWithToleranceENS_9StringRefES0_ddPSs;_ZN4llvm22EnablePrettyStackTraceEv;_ZN4llvm22InitializeAllTargetMCsEv;_ZN4llvm22InitializeNativeTargetEv;_ZN4llvm22createMCRelocationInfoERKNS_6TripleERNS_9MCContextE;_ZN4llvm22createMachObjectWriterEPNS_24MCMachObjectTargetWriterERNS_17raw_pwrite_streamEb;_ZN4llvm22inconvertibleErrorCodeEv;_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j;_ZN4llvm23GreatestCommonDivisor64Eyy;_ZN4llvm23InitializeAllAsmParsersEv;_ZN4llvm23RestorePrettyStackStateEPKv;_ZN4llvm24InitializeAllAsmPrintersEv;_ZN4llvm24InitializeAllTargetInfosEv;_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs;_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefItEERSs;_ZN4llvm24convertUTF8ToUTF16StringENS_9StringRefERNS_15SmallVectorImplItEE;_ZN4llvm25createWinCOFFObjectWriterEPNS_27MCWinCOFFObjectTargetWriterERNS_17raw_pwrite_streamE;_ZN4llvm25llvm_unreachable_internalEPKcS1_j;_ZN4llvm26InitializeAllDisassemblersEv;_ZN4llvm26getNonStreamedMemoryObjectEPKhS1_;_ZN4llvm26remove_fatal_error_handlerEv;_ZN4llvm27CheckBitcodeOutputToConsoleERNS_11raw_ostreamEb;_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_;_ZN4llvm29set_fixed_execution_hash_seedEj;_ZN4llvm31InitializeNativeTargetAsmParserEv;_ZN4llvm32InitializeNativeTargetAsmPrinterEv;_ZN4llvm34InitializeNativeTargetDisassemblerEv;_ZN4llvm3absENS_7APFloatE;_ZN4llvm4Log2Ed;_ZN4llvm4dbgsEv;_ZN4llvm4errsEv;_ZN4llvm4outsEv;_ZN4llvm4wrapEPKNS_12MemoryBufferE;_ZN4llvm5Hi_32Ey;_ZN4llvm5Lo_32Ey;_ZN4llvm5fdbgsEv;_ZN4llvm5ferrsEv;_ZN4llvm5foutsEv;_ZN4llvm5frexpERKNS_7APFloatERiNS0_12roundingModeE;_ZN4llvm5ilogbERKNS_7APFloatE;_ZN4llvm5isIntILj16EEEbx;_ZN4llvm5isIntILj32EEEbx;_ZN4llvm5isIntILj8EEEbx;_ZN4llvm5nullsEv;_ZN4llvm6isIntNEjx;_ZN4llvm6isUIntILj16EEEby;_ZN4llvm6isUIntILj32EEEby;_ZN4llvm6isUIntILj8EEEby;_ZN4llvm6maxnumERKNS_7APFloatES2_;_ZN4llvm6minnumERKNS_7APFloatES2_;_ZN4llvm6scalbnENS_7APFloatEiNS0_12roundingModeE;_ZN4llvm6unwrapEP22LLVMOpaqueMemoryBuffer;_ZN4llvm7Log2_32Ej;_ZN4llvm7Log2_64Ey;_ZN4llvm7MD5HashENS_9StringRefE;_ZN4llvm7Make_64Ejj;_ZN4llvm7alignToEyyy;_ZN4llvm7isUIntNEjy;_ZN4llvm7maxIntNEx;_ZN4llvm7minIntNEx;_ZN4llvm8MinAlignEyy;_ZN4llvm8getTokenENS_9StringRefES0_;_ZN4llvm8maxUIntNEy;_ZN4llvm8toStringENS_5ErrorE;_ZN4llvm9DebugFlagE;_ZN4llvm9alignAddrEPKvj;_ZN4llvm9alignDownEyyy;_ZN4llvm9dumpBytesENS_8ArrayRefIhEERNS_11raw_ostreamE;_ZN4llvm9huge_valfE;_ZN4llvm9isMask_32Ej;_ZN4llvm9isMask_64Ey;_ZN4llvmL10HashStringENS_9StringRefEj;_ZN4llvmL10toIRStringENS_14AtomicOrderingE;_ZN4llvmL11toStringRefEb;_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE;_ZN4llvmL13MCLOHNameToIdENS_9StringRefE;_ZN4llvmL13hexDigitValueEc;_ZN4llvmL13host_char_bitE;_ZN4llvmL14isStrongerThanENS_14AtomicOrderingES0_;_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE;_ZN4llvmL16getOrdinalSuffixEj;_ZN4llvmL16integerPartWidthE;_ZN4llvmL16isValidMCLOHTypeEj;_ZN4llvmL17capacity_in_bytesERKNS_9BitVectorE;_ZN4llvmL18BitReverseTable256E;_ZN4llvmL18MCLOHDirectiveNameEv;_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags;_ZN4llvmL19isAcquireOrStrongerENS_14AtomicOrderingE;_ZN4llvmL19isReleaseOrStrongerENS_14AtomicOrderingE;_ZN4llvmL20AsmRewritePrecedenceE;_ZN4llvmL22MAX_SUBTARGET_FEATURESE;_ZN4llvmL23isAtLeastOrStrongerThanENS_14AtomicOrderingES0_;_ZN4llvmL23isStrongerThanMonotonicENS_14AtomicOrderingE;_ZN4llvmL23isStrongerThanUnorderedENS_14AtomicOrderingE;_ZN4llvmL4NoneE;_ZN4llvmL5toHexENS_9StringRefE;_ZN4llvmL6itostrEx;_ZN4llvmL6toCABIENS_14AtomicOrderingE;_ZN4llvmL6utostrEyb;_ZN4llvmL8hexdigitEjb;_ZN4llvmL9utohexstrEyb;_ZN4llvmanERKNS_14SmallBitVectorES2_;_ZN4llvmeoERKNS_14SmallBitVectorES2_;_ZN4llvmeqENS_9StringRefES0_;_ZN4llvmeqERKNS_15MCTargetOptionsES2_;_ZN4llvmeqExRKNS_6APSIntE;_ZN4llvmeqEyRKNS_5APIntE;_ZN4llvmgeENS_9StringRefES0_;_ZN4llvmgeExRKNS_6APSIntE;_ZN4llvmgtENS_9StringRefES0_;_ZN4llvmgtExRKNS_6APSIntE;_ZN4llvmleENS_9StringRefES0_;_ZN4llvmleExRKNS_6APSIntE;_ZN4llvmlsERNS_11raw_ostreamENS_17BranchProbabilityE;_ZN4llvmlsERNS_11raw_ostreamERKNS_18MCParsedAsmOperandE;_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE;_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6APSIntE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCExprE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCInstE;_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCLabelE;_ZN4llvmlsERNS_11raw_ostreamERKNS_8MCSymbolE;_ZN4llvmlsERNS_11raw_ostreamERKNS_9HexNumberE;_ZN4llvmlsERNS_11raw_ostreamERKNS_9MCOperandE;_ZN4llvmltENS_9StringRefES0_;_ZN4llvmltExRKNS_6APSIntE;_ZN4llvmneENS_9StringRefES0_;_ZN4llvmneERKNS_15MCTargetOptionsES2_;_ZN4llvmneExRKNS_6APSIntE;_ZN4llvmneEyRKNS_5APIntE;_ZN4llvmorERKNS_14SmallBitVectorES2_;_ZN4llvmpLERSsNS_9StringRefE;_ZN4llvmplEPKcRKNS_9StringRefE;_ZN4llvmplERKNS_5TwineES2_;_ZN4llvmplERKNS_9StringRefEPKc; -static-type=AdtsupportLlvmGlobals -package=org.llvm.support")
//</editor-fold>
public final class AdtsupportLlvmGlobals {
//
//// namespace detail
//
///// \brief Count number of 0's from the least significant bit to the most
/////   stopping at the first 1.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Width and ZB_Undefined are
/////   valid arguments.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 111,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 108,
// FQN="llvm::countTrailingZeros", NM="Tpl__ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T> /*uint*/int countTrailingZeros(T Val) {
//  return countTrailingZeros(Val, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T> /*uint*/int countTrailingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    countTrailingZeros(Val, ZB);
//}
//
//// namespace detail
//
///// \brief Count number of 0's from the most significant bit to the least
/////   stopping at the first 1.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Width and ZB_Undefined are
/////   valid arguments.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 180,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 177,
// FQN="llvm::countLeadingZeros", NM="Tpl__ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T> /*uint*/int countLeadingZeros(T Val) {
//  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T> /*uint*/int countLeadingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    countLeadingZeros(Val, ZB);
//}
//
//
///// \brief Get the index of the first set bit starting from the least
/////   significant bit.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
/////   valid arguments.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 194,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 192,
// FQN="llvm::findFirstSet", NM="Tpl__ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T> T findFirstSet(T Val) {
//  return findFirstSet(Val, ZeroBehavior.ZB_Max);
//}
//public static </*typename*/ T> T findFirstSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    findFirstSet(Val, ZB);
//}
//
//
///// \brief Get the index of the last set bit starting from the least
/////   significant bit.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
/////   valid arguments.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 208,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 206,
// FQN="llvm::findLastSet", NM="Tpl__ZN4llvm11findLastSetET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm11findLastSetET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T> T findLastSet(T Val) {
//  return findLastSet(Val, ZeroBehavior.ZB_Max);
//}
//public static </*typename*/ T> T findLastSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    findLastSet(Val, ZB);
//}
//
//
///// \brief Macro compressed bit reversal table for 256 bits.
/////
///// http://graphics.stanford.edu/~seander/bithacks.html#BitReverseTable
////<editor-fold defaultstate="collapsed" desc="llvm::BitReverseTable256">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 221,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 219,
// FQN="llvm::BitReverseTable256", NM="_ZN4llvmL18BitReverseTable256E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL18BitReverseTable256E")
////</editor-fold>
//public static /*const*//*uchar*/byte BitReverseTable256[/*256*/] = new /*const*//*uchar*/byte [/*256*/] {
//  0, $int2uchar(0 + 2 * 64), 0 + 1 * 64, $int2uchar(0 + 3 * 64), 0 + 2 * 16, $int2uchar(0 + 2 * 16 + 2 * 64), 0 + 2 * 16 + 1 * 64, $int2uchar(0 + 2 * 16 + 3 * 64), 0 + 1 * 16, $int2uchar(0 + 1 * 16 + 2 * 64), 0 + 1 * 16 + 1 * 64, $int2uchar(0 + 1 * 16 + 3 * 64), 0 + 3 * 16, $int2uchar(0 + 3 * 16 + 2 * 64), 0 + 3 * 16 + 1 * 64, $int2uchar(0 + 3 * 16 + 3 * 64), 0 + 2 * 4, $int2uchar(0 + 2 * 4 + 2 * 64), 0 + 2 * 4 + 1 * 64, $int2uchar(0 + 2 * 4 + 3 * 64), 0 + 2 * 4 + 2 * 16, $int2uchar(0 + 2 * 4 + 2 * 16 + 2 * 64), 0 + 2 * 4 + 2 * 16 + 1 * 64, $int2uchar(0 + 2 * 4 + 2 * 16 + 3 * 64), 0 + 2 * 4 + 1 * 16, $int2uchar(0 + 2 * 4 + 1 * 16 + 2 * 64), 0 + 2 * 4 + 1 * 16 + 1 * 64, $int2uchar(0 + 2 * 4 + 1 * 16 + 3 * 64), 0 + 2 * 4 + 3 * 16, $int2uchar(0 + 2 * 4 + 3 * 16 + 2 * 64), 0 + 2 * 4 + 3 * 16 + 1 * 64, $int2uchar(0 + 2 * 4 + 3 * 16 + 3 * 64), 0 + 1 * 4, $int2uchar(0 + 1 * 4 + 2 * 64), 0 + 1 * 4 + 1 * 64, $int2uchar(0 + 1 * 4 + 3 * 64), 0 + 1 * 4 + 2 * 16, $int2uchar(0 + 1 * 4 + 2 * 16 + 2 * 64), 0 + 1 * 4 + 2 * 16 + 1 * 64, $int2uchar(0 + 1 * 4 + 2 * 16 + 3 * 64), 0 + 1 * 4 + 1 * 16, $int2uchar(0 + 1 * 4 + 1 * 16 + 2 * 64), 0 + 1 * 4 + 1 * 16 + 1 * 64, $int2uchar(0 + 1 * 4 + 1 * 16 + 3 * 64), 0 + 1 * 4 + 3 * 16, $int2uchar(0 + 1 * 4 + 3 * 16 + 2 * 64), 0 + 1 * 4 + 3 * 16 + 1 * 64, $int2uchar(0 + 1 * 4 + 3 * 16 + 3 * 64), 0 + 3 * 4, $int2uchar(0 + 3 * 4 + 2 * 64), 0 + 3 * 4 + 1 * 64, $int2uchar(0 + 3 * 4 + 3 * 64), 0 + 3 * 4 + 2 * 16, $int2uchar(0 + 3 * 4 + 2 * 16 + 2 * 64), 0 + 3 * 4 + 2 * 16 + 1 * 64, $int2uchar(0 + 3 * 4 + 2 * 16 + 3 * 64), 0 + 3 * 4 + 1 * 16, $int2uchar(0 + 3 * 4 + 1 * 16 + 2 * 64), 0 + 3 * 4 + 1 * 16 + 1 * 64, $int2uchar(0 + 3 * 4 + 1 * 16 + 3 * 64), 0 + 3 * 4 + 3 * 16, $int2uchar(0 + 3 * 4 + 3 * 16 + 2 * 64), 0 + 3 * 4 + 3 * 16 + 1 * 64, $int2uchar(0 + 3 * 4 + 3 * 16 + 3 * 64), 2, $int2uchar(2 + 2 * 64), 2 + 1 * 64, $int2uchar(2 + 3 * 64), 2 + 2 * 16, $int2uchar(2 + 2 * 16 + 2 * 64), 2 + 2 * 16 + 1 * 64, $int2uchar(2 + 2 * 16 + 3 * 64), 2 + 1 * 16, $int2uchar(2 + 1 * 16 + 2 * 64), 2 + 1 * 16 + 1 * 64, $int2uchar(2 + 1 * 16 + 3 * 64), 2 + 3 * 16, $int2uchar(2 + 3 * 16 + 2 * 64), 2 + 3 * 16 + 1 * 64, $int2uchar(2 + 3 * 16 + 3 * 64), 2 + 2 * 4, $int2uchar(2 + 2 * 4 + 2 * 64), 2 + 2 * 4 + 1 * 64, $int2uchar(2 + 2 * 4 + 3 * 64), 2 + 2 * 4 + 2 * 16, $int2uchar(2 + 2 * 4 + 2 * 16 + 2 * 64), 2 + 2 * 4 + 2 * 16 + 1 * 64, $int2uchar(2 + 2 * 4 + 2 * 16 + 3 * 64), 2 + 2 * 4 + 1 * 16, $int2uchar(2 + 2 * 4 + 1 * 16 + 2 * 64), 2 + 2 * 4 + 1 * 16 + 1 * 64, $int2uchar(2 + 2 * 4 + 1 * 16 + 3 * 64), 2 + 2 * 4 + 3 * 16, $int2uchar(2 + 2 * 4 + 3 * 16 + 2 * 64), 2 + 2 * 4 + 3 * 16 + 1 * 64, $int2uchar(2 + 2 * 4 + 3 * 16 + 3 * 64), 2 + 1 * 4, $int2uchar(2 + 1 * 4 + 2 * 64), 2 + 1 * 4 + 1 * 64, $int2uchar(2 + 1 * 4 + 3 * 64), 2 + 1 * 4 + 2 * 16, $int2uchar(2 + 1 * 4 + 2 * 16 + 2 * 64), 2 + 1 * 4 + 2 * 16 + 1 * 64, $int2uchar(2 + 1 * 4 + 2 * 16 + 3 * 64), 2 + 1 * 4 + 1 * 16, $int2uchar(2 + 1 * 4 + 1 * 16 + 2 * 64), 2 + 1 * 4 + 1 * 16 + 1 * 64, $int2uchar(2 + 1 * 4 + 1 * 16 + 3 * 64), 2 + 1 * 4 + 3 * 16, $int2uchar(2 + 1 * 4 + 3 * 16 + 2 * 64), 2 + 1 * 4 + 3 * 16 + 1 * 64, $int2uchar(2 + 1 * 4 + 3 * 16 + 3 * 64), 2 + 3 * 4, $int2uchar(2 + 3 * 4 + 2 * 64), 2 + 3 * 4 + 1 * 64, $int2uchar(2 + 3 * 4 + 3 * 64), 2 + 3 * 4 + 2 * 16, $int2uchar(2 + 3 * 4 + 2 * 16 + 2 * 64), 2 + 3 * 4 + 2 * 16 + 1 * 64, $int2uchar(2 + 3 * 4 + 2 * 16 + 3 * 64), 2 + 3 * 4 + 1 * 16, $int2uchar(2 + 3 * 4 + 1 * 16 + 2 * 64), 2 + 3 * 4 + 1 * 16 + 1 * 64, $int2uchar(2 + 3 * 4 + 1 * 16 + 3 * 64), 2 + 3 * 4 + 3 * 16, $int2uchar(2 + 3 * 4 + 3 * 16 + 2 * 64), 2 + 3 * 4 + 3 * 16 + 1 * 64, $int2uchar(2 + 3 * 4 + 3 * 16 + 3 * 64), 1, $int2uchar(1 + 2 * 64), 1 + 1 * 64, $int2uchar(1 + 3 * 64), 1 + 2 * 16, $int2uchar(1 + 2 * 16 + 2 * 64), 1 + 2 * 16 + 1 * 64, $int2uchar(1 + 2 * 16 + 3 * 64), 1 + 1 * 16, $int2uchar(1 + 1 * 16 + 2 * 64), 1 + 1 * 16 + 1 * 64, $int2uchar(1 + 1 * 16 + 3 * 64), 1 + 3 * 16, $int2uchar(1 + 3 * 16 + 2 * 64), 1 + 3 * 16 + 1 * 64, $int2uchar(1 + 3 * 16 + 3 * 64), 1 + 2 * 4, $int2uchar(1 + 2 * 4 + 2 * 64), 1 + 2 * 4 + 1 * 64, $int2uchar(1 + 2 * 4 + 3 * 64), 1 + 2 * 4 + 2 * 16, $int2uchar(1 + 2 * 4 + 2 * 16 + 2 * 64), 1 + 2 * 4 + 2 * 16 + 1 * 64, $int2uchar(1 + 2 * 4 + 2 * 16 + 3 * 64), 1 + 2 * 4 + 1 * 16, $int2uchar(1 + 2 * 4 + 1 * 16 + 2 * 64), 1 + 2 * 4 + 1 * 16 + 1 * 64, $int2uchar(1 + 2 * 4 + 1 * 16 + 3 * 64), 1 + 2 * 4 + 3 * 16, $int2uchar(1 + 2 * 4 + 3 * 16 + 2 * 64), 1 + 2 * 4 + 3 * 16 + 1 * 64, $int2uchar(1 + 2 * 4 + 3 * 16 + 3 * 64), 1 + 1 * 4, $int2uchar(1 + 1 * 4 + 2 * 64), 1 + 1 * 4 + 1 * 64, $int2uchar(1 + 1 * 4 + 3 * 64), 1 + 1 * 4 + 2 * 16, $int2uchar(1 + 1 * 4 + 2 * 16 + 2 * 64), 1 + 1 * 4 + 2 * 16 + 1 * 64, $int2uchar(1 + 1 * 4 + 2 * 16 + 3 * 64), 1 + 1 * 4 + 1 * 16, $int2uchar(1 + 1 * 4 + 1 * 16 + 2 * 64), 1 + 1 * 4 + 1 * 16 + 1 * 64, $int2uchar(1 + 1 * 4 + 1 * 16 + 3 * 64), 1 + 1 * 4 + 3 * 16, $int2uchar(1 + 1 * 4 + 3 * 16 + 2 * 64), 1 + 1 * 4 + 3 * 16 + 1 * 64, $int2uchar(1 + 1 * 4 + 3 * 16 + 3 * 64), 1 + 3 * 4, $int2uchar(1 + 3 * 4 + 2 * 64), 1 + 3 * 4 + 1 * 64, $int2uchar(1 + 3 * 4 + 3 * 64), 1 + 3 * 4 + 2 * 16, $int2uchar(1 + 3 * 4 + 2 * 16 + 2 * 64), 1 + 3 * 4 + 2 * 16 + 1 * 64, $int2uchar(1 + 3 * 4 + 2 * 16 + 3 * 64), 1 + 3 * 4 + 1 * 16, $int2uchar(1 + 3 * 4 + 1 * 16 + 2 * 64), 1 + 3 * 4 + 1 * 16 + 1 * 64, $int2uchar(1 + 3 * 4 + 1 * 16 + 3 * 64), 1 + 3 * 4 + 3 * 16, $int2uchar(1 + 3 * 4 + 3 * 16 + 2 * 64), 1 + 3 * 4 + 3 * 16 + 1 * 64, $int2uchar(1 + 3 * 4 + 3 * 16 + 3 * 64), 3, $int2uchar(3 + 2 * 64), 3 + 1 * 64, $int2uchar(3 + 3 * 64), 3 + 2 * 16, $int2uchar(3 + 2 * 16 + 2 * 64), 3 + 2 * 16 + 1 * 64, $int2uchar(3 + 2 * 16 + 3 * 64), 3 + 1 * 16, $int2uchar(3 + 1 * 16 + 2 * 64), 3 + 1 * 16 + 1 * 64, $int2uchar(3 + 1 * 16 + 3 * 64), 3 + 3 * 16, $int2uchar(3 + 3 * 16 + 2 * 64), 3 + 3 * 16 + 1 * 64, $int2uchar(3 + 3 * 16 + 3 * 64), 3 + 2 * 4, $int2uchar(3 + 2 * 4 + 2 * 64), 3 + 2 * 4 + 1 * 64, $int2uchar(3 + 2 * 4 + 3 * 64), 3 + 2 * 4 + 2 * 16, $int2uchar(3 + 2 * 4 + 2 * 16 + 2 * 64), 3 + 2 * 4 + 2 * 16 + 1 * 64, $int2uchar(3 + 2 * 4 + 2 * 16 + 3 * 64), 3 + 2 * 4 + 1 * 16, $int2uchar(3 + 2 * 4 + 1 * 16 + 2 * 64), 3 + 2 * 4 + 1 * 16 + 1 * 64, $int2uchar(3 + 2 * 4 + 1 * 16 + 3 * 64), 3 + 2 * 4 + 3 * 16, $int2uchar(3 + 2 * 4 + 3 * 16 + 2 * 64), 3 + 2 * 4 + 3 * 16 + 1 * 64, $int2uchar(3 + 2 * 4 + 3 * 16 + 3 * 64), 3 + 1 * 4, $int2uchar(3 + 1 * 4 + 2 * 64), 3 + 1 * 4 + 1 * 64, $int2uchar(3 + 1 * 4 + 3 * 64), 3 + 1 * 4 + 2 * 16, $int2uchar(3 + 1 * 4 + 2 * 16 + 2 * 64), 3 + 1 * 4 + 2 * 16 + 1 * 64, $int2uchar(3 + 1 * 4 + 2 * 16 + 3 * 64), 3 + 1 * 4 + 1 * 16, $int2uchar(3 + 1 * 4 + 1 * 16 + 2 * 64), 3 + 1 * 4 + 1 * 16 + 1 * 64, $int2uchar(3 + 1 * 4 + 1 * 16 + 3 * 64), 3 + 1 * 4 + 3 * 16, $int2uchar(3 + 1 * 4 + 3 * 16 + 2 * 64), 3 + 1 * 4 + 3 * 16 + 1 * 64, $int2uchar(3 + 1 * 4 + 3 * 16 + 3 * 64), 3 + 3 * 4, $int2uchar(3 + 3 * 4 + 2 * 64), 3 + 3 * 4 + 1 * 64, $int2uchar(3 + 3 * 4 + 3 * 64), 3 + 3 * 4 + 2 * 16, $int2uchar(3 + 3 * 4 + 2 * 16 + 2 * 64), 3 + 3 * 4 + 2 * 16 + 1 * 64, $int2uchar(3 + 3 * 4 + 2 * 16 + 3 * 64), 3 + 3 * 4 + 1 * 16, $int2uchar(3 + 3 * 4 + 1 * 16 + 2 * 64), 3 + 3 * 4 + 1 * 16 + 1 * 64, $int2uchar(3 + 3 * 4 + 1 * 16 + 3 * 64), 3 + 3 * 4 + 3 * 16, $int2uchar(3 + 3 * 4 + 3 * 16 + 2 * 64), 3 + 3 * 4 + 3 * 16 + 1 * 64, $int2uchar(3 + 3 * 4 + 3 * 16 + 3 * 64)
//};
//
///// \brief Reverse the bits in \p Val.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::reverseBits">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 233,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 230,
// FQN="llvm::reverseBits", NM="Tpl__ZN4llvm11reverseBitsET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm11reverseBitsET_")
////</editor-fold>
//public static </*typename*/ T> T reverseBits(T Val) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    reverseBits(Val);
//}
//
//
//// NOTE: The following support functions use the _32/_64 extensions instead of
//// type overloading so that signed and unsigned integers can be used without
//// ambiguity.
//
///// Hi_32 - This function returns the high 32 bits of a 64 bit value.
////<editor-fold defaultstate="collapsed" desc="llvm::Hi_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 248,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 246,
// FQN="llvm::Hi_32", NM="_ZN4llvm5Hi_32Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5Hi_32Ey")
////</editor-fold>
//public static /*inline*/ /*uint32_t*/int Hi_32(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Hi_32(Value);
//}
//
//
///// Lo_32 - This function returns the low 32 bits of a 64 bit value.
////<editor-fold defaultstate="collapsed" desc="llvm::Lo_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 253,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 251,
// FQN="llvm::Lo_32", NM="_ZN4llvm5Lo_32Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5Lo_32Ey")
////</editor-fold>
//public static /*inline*/ /*uint32_t*/int Lo_32(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Lo_32(Value);
//}
//
//
///// Make_64 - This functions makes a 64-bit integer from a high / low pair of
/////           32-bit integers.
////<editor-fold defaultstate="collapsed" desc="llvm::Make_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 259,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 257,
// FQN="llvm::Make_64", NM="_ZN4llvm7Make_64Ejj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7Make_64Ejj")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ Make_64(/*uint32_t*/int High, /*uint32_t*/int Low) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Make_64(High, Low);
//}


/// isInt - Checks if an integer fits into the given bit width.
/*template <unsigned int N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isInt">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 265,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 262,
 FQN="llvm::isInt", NM="Tpl__ZN4llvm5isIntEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm5isIntEx")
//</editor-fold>
public static /*inline*/ boolean isInt(/*uint*/int N, long/*int64_t*/ x) {
  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
    isInt(N, x);
}

// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isInt">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 269,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 267,
 FQN="llvm::isInt", NM="_ZN4llvm5isIntILj8EEEbx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5isIntILj8EEEbx")
//</editor-fold>
public static /*inline*/ boolean isInt(long/*int64_t*/ x) {
  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
    isInt(x);
}


///// isShiftedInt<N,S> - Checks if a signed integer is an N bit number shifted
/////                     left by S.
///*template <unsigned int N, unsigned int S> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 285,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 282,
// FQN="llvm::isShiftedInt", NM="Tpl__ZN4llvm12isShiftedIntEx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12isShiftedIntEx")
////</editor-fold>
//public static /*inline*/ </*uint*/int N, /*uint*/int S> boolean isShiftedInt(long/*int64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isShiftedInt(x);
//}


/// isUInt - Checks if an unsigned integer fits into the given bit width.
/*template <unsigned int N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 294,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 288,
 FQN="llvm::isUInt", NM="Tpl__ZN4llvm6isUIntEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm6isUIntEy")
//</editor-fold>
public static /*inline*/ boolean isUInt(/*uint*/int N, long/*uint64_t*/ x) {
  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
    isUInt(N, x);
}


// Template specializations to get better code for common cases.
//<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 300,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 293,
 FQN="llvm::isUInt", NM="_ZN4llvm6isUIntILj8EEEby",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6isUIntILj8EEEby")
//</editor-fold>
public static /*inline*/ boolean isUInt(long/*uint64_t*/ x) {
  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
    isUInt(x);
}


///// Checks if a unsigned integer is an N bit number shifted left by S.
///*template <unsigned int N, unsigned int S> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedUInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 315,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 308,
// FQN="llvm::isShiftedUInt", NM="Tpl__ZN4llvm13isShiftedUIntEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm13isShiftedUIntEy")
////</editor-fold>
//public static /*inline*/ </*uint*/int N, /*uint*/int S> boolean isShiftedUInt(long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isShiftedUInt(x);
//}
//
//
///// Gets the maximum value for a N-bit unsigned integer.
////<editor-fold defaultstate="collapsed" desc="llvm::maxUIntN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 326,
// FQN="llvm::maxUIntN", NM="_ZN4llvm8maxUIntNEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm8maxUIntNEy")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ maxUIntN(long/*uint64_t*/ N) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    maxUIntN(N);
//}
//
//
///// Gets the minimum value for a N-bit signed integer.
////<editor-fold defaultstate="collapsed" desc="llvm::minIntN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 337,
// FQN="llvm::minIntN", NM="_ZN4llvm7minIntNEx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7minIntNEx")
////</editor-fold>
//public static /*inline*/ long/*int64_t*/ minIntN(long/*int64_t*/ N) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    minIntN(N);
//}
//
//
///// Gets the maximum value for a N-bit signed integer.
////<editor-fold defaultstate="collapsed" desc="llvm::maxIntN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 344,
// FQN="llvm::maxIntN", NM="_ZN4llvm7maxIntNEx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7maxIntNEx")
////</editor-fold>
//public static /*inline*/ long/*int64_t*/ maxIntN(long/*int64_t*/ N) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    maxIntN(N);
//}
//
//
///// isUIntN - Checks if an unsigned integer fits into the given (dynamic)
///// bit width.
////<editor-fold defaultstate="collapsed" desc="llvm::isUIntN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 354,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 315,
// FQN="llvm::isUIntN", NM="_ZN4llvm7isUIntNEjy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7isUIntNEjy")
////</editor-fold>
//public static /*inline*/ boolean isUIntN(/*uint*/int N, long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isUIntN(N, x);
//}
//
//
///// isIntN - Checks if an signed integer fits into the given (dynamic)
///// bit width.
////<editor-fold defaultstate="collapsed" desc="llvm::isIntN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 360,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 321,
// FQN="llvm::isIntN", NM="_ZN4llvm6isIntNEjx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6isIntNEjx")
////</editor-fold>
//public static /*inline*/ boolean isIntN(/*uint*/int N, long/*int64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isIntN(N, x);
//}
//
//
///// isMask_32 - This function returns true if the argument is a non-empty
///// sequence of ones starting at the least significant bit with the remainder
///// zero (32 bit version).  Ex. isMask_32(0x0000FFFFU) == true.
////<editor-fold defaultstate="collapsed" desc="llvm::isMask_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 367,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 328,
// FQN="llvm::isMask_32", NM="_ZN4llvm9isMask_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9isMask_32Ej")
////</editor-fold>
//public static /*inline*/ boolean isMask_32(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isMask_32(Value);
//}
//
//
///// isMask_64 - This function returns true if the argument is a non-empty
///// sequence of ones starting at the least significant bit with the remainder
///// zero (64 bit version).
////<editor-fold defaultstate="collapsed" desc="llvm::isMask_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 374,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 335,
// FQN="llvm::isMask_64", NM="_ZN4llvm9isMask_64Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9isMask_64Ey")
////</editor-fold>
//public static /*inline*/ boolean isMask_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isMask_64(Value);
//}
//
//
///// isShiftedMask_32 - This function returns true if the argument contains a
///// non-empty sequence of ones with the remainder zero (32 bit version.)
///// Ex. isShiftedMask_32(0x0000FF00U) == true.
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 381,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 342,
// FQN="llvm::isShiftedMask_32", NM="_ZN4llvm16isShiftedMask_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm16isShiftedMask_32Ej")
////</editor-fold>
//public static /*inline*/ boolean isShiftedMask_32(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isShiftedMask_32(Value);
//}
//
//
///// isShiftedMask_64 - This function returns true if the argument contains a
///// non-empty sequence of ones with the remainder zero (64 bit version.)
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 387,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 348,
// FQN="llvm::isShiftedMask_64", NM="_ZN4llvm16isShiftedMask_64Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm16isShiftedMask_64Ey")
////</editor-fold>
//public static /*inline*/ boolean isShiftedMask_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isShiftedMask_64(Value);
//}
//
//
///// isPowerOf2_32 - This function returns true if the argument is a power of
///// two > 0. Ex. isPowerOf2_32(0x00100000U) == true (32 bit edition.)
////<editor-fold defaultstate="collapsed" desc="llvm::isPowerOf2_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 393,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 354,
// FQN="llvm::isPowerOf2_32", NM="_ZN4llvm13isPowerOf2_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm13isPowerOf2_32Ej")
////</editor-fold>
//public static /*inline*/ boolean isPowerOf2_32(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isPowerOf2_32(Value);
//}
//
//
///// isPowerOf2_64 - This function returns true if the argument is a power of two
///// > 0 (64 bit edition.)
////<editor-fold defaultstate="collapsed" desc="llvm::isPowerOf2_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 399,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 360,
// FQN="llvm::isPowerOf2_64", NM="_ZN4llvm13isPowerOf2_64Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm13isPowerOf2_64Ey")
////</editor-fold>
//public static /*inline*/ boolean isPowerOf2_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isPowerOf2_64(Value);
//}
//
//
///// ByteSwap_16 - This function returns a byte-swapped representation of the
///// 16-bit argument, Value.
////<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_16">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 405,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 366,
// FQN="llvm::ByteSwap_16", NM="_ZN4llvm11ByteSwap_16Et",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11ByteSwap_16Et")
////</editor-fold>
//public static /*inline*/ /*uint16_t*/char ByteSwap_16(/*uint16_t*/char Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    ByteSwap_16(Value);
//}
//
//
///// ByteSwap_32 - This function returns a byte-swapped representation of the
///// 32-bit argument, Value.
////<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 411,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 372,
// FQN="llvm::ByteSwap_32", NM="_ZN4llvm11ByteSwap_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11ByteSwap_32Ej")
////</editor-fold>
//public static /*inline*/ /*uint32_t*/int ByteSwap_32(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    ByteSwap_32(Value);
//}
//
//
///// ByteSwap_64 - This function returns a byte-swapped representation of the
///// 64-bit argument, Value.
////<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 417,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 378,
// FQN="llvm::ByteSwap_64", NM="_ZN4llvm11ByteSwap_64Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11ByteSwap_64Ey")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ ByteSwap_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    ByteSwap_64(Value);
//}
//
//
///// \brief Count the number of ones from the most significant bit to the first
///// zero bit.
/////
///// Ex. CountLeadingOnes(0xFF0FFF00) == 8.
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of all ones. Only ZB_Width and
///// ZB_Undefined are valid arguments.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingOnes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 430,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 390,
// FQN="llvm::countLeadingOnes", NM="Tpl__ZN4llvm16countLeadingOnesET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm16countLeadingOnesET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T> /*uint*/int countLeadingOnes(T Value) {
//  return countLeadingOnes(Value, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T> /*uint*/int countLeadingOnes(T Value, ZeroBehavior ZB/*= ZB_Width*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    countLeadingOnes(Value, ZB);
//}
//
//
///// \brief Count the number of ones from the least significant bit to the first
///// zero bit.
/////
///// Ex. countTrailingOnes(0x00FF00FF) == 8.
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of all ones. Only ZB_Width and
///// ZB_Undefined are valid arguments.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::countTrailingOnes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 446,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 406,
// FQN="llvm::countTrailingOnes", NM="Tpl__ZN4llvm17countTrailingOnesET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm17countTrailingOnesET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T> /*uint*/int countTrailingOnes(T Value) {
//  return countTrailingOnes(Value, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T> /*uint*/int countTrailingOnes(T Value, ZeroBehavior ZB/*= ZB_Width*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    countTrailingOnes(Value, ZB);
//}
//
// namespace detail
//
/// \brief Count the number of set bits in a value.
/// Ex. countPopulation(0xF000F000) = 8
/// Returns 0 if the word is zero.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::countPopulation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 488,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 448,
 FQN="llvm::countPopulation", NM="Tpl__ZN4llvm15countPopulationET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm15countPopulationET_")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*uint*/int countPopulation(T Value) {
  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
    countPopulation(Value);
}
//
//
///// Log2 - This function returns the log base 2 of the specified value
////<editor-fold defaultstate="collapsed" desc="llvm::Log2">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 496,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 457,
// FQN="llvm::Log2", NM="_ZN4llvm4Log2Ed",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm4Log2Ed")
////</editor-fold>
//public static /*inline*/ double Log2(double Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Log2(Value);
//}
//
//
///// Log2_32 - This function returns the floor log base 2 of the specified value,
///// -1 if the value is zero. (32 bit edition.)
///// Ex. Log2_32(32) == 5, Log2_32(1) == 0, Log2_32(0) == -1, Log2_32(6) == 2
////<editor-fold defaultstate="collapsed" desc="llvm::Log2_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 507,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 468,
// FQN="llvm::Log2_32", NM="_ZN4llvm7Log2_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7Log2_32Ej")
////</editor-fold>
//public static /*inline*/ /*uint*/int Log2_32(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Log2_32(Value);
//}
//
//
///// Log2_64 - This function returns the floor log base 2 of the specified value,
///// -1 if the value is zero. (64 bit edition.)
////<editor-fold defaultstate="collapsed" desc="llvm::Log2_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 513,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 474,
// FQN="llvm::Log2_64", NM="_ZN4llvm7Log2_64Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7Log2_64Ey")
////</editor-fold>
//public static /*inline*/ /*uint*/int Log2_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Log2_64(Value);
//}
//
//
///// Log2_32_Ceil - This function returns the ceil log base 2 of the specified
///// value, 32 if the value is zero. (32 bit edition).
///// Ex. Log2_32_Ceil(32) == 5, Log2_32_Ceil(1) == 0, Log2_32_Ceil(6) == 3
////<editor-fold defaultstate="collapsed" desc="llvm::Log2_32_Ceil">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 520,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 481,
// FQN="llvm::Log2_32_Ceil", NM="_ZN4llvm12Log2_32_CeilEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12Log2_32_CeilEj")
////</editor-fold>
//public static /*inline*/ /*uint*/int Log2_32_Ceil(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Log2_32_Ceil(Value);
//}
//
//
///// Log2_64_Ceil - This function returns the ceil log base 2 of the specified
///// value, 64 if the value is zero. (64 bit edition.)
////<editor-fold defaultstate="collapsed" desc="llvm::Log2_64_Ceil">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 526,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 487,
// FQN="llvm::Log2_64_Ceil", NM="_ZN4llvm12Log2_64_CeilEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12Log2_64_CeilEy")
////</editor-fold>
//public static /*inline*/ /*uint*/int Log2_64_Ceil(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Log2_64_Ceil(Value);
//}
//
//
///// GreatestCommonDivisor64 - Return the greatest common divisor of the two
///// values using Euclid's algorithm.
////<editor-fold defaultstate="collapsed" desc="llvm::GreatestCommonDivisor64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 532,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 493,
// FQN="llvm::GreatestCommonDivisor64", NM="_ZN4llvm23GreatestCommonDivisor64Eyy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm23GreatestCommonDivisor64Eyy")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ GreatestCommonDivisor64(long/*uint64_t*/ A, long/*uint64_t*/ B) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    GreatestCommonDivisor64(A, B);
//}
//
//
///// BitsToDouble - This function takes a 64-bit integer and returns the bit
///// equivalent double.
////<editor-fold defaultstate="collapsed" desc="llvm::BitsToDouble">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 543,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 504,
// FQN="llvm::BitsToDouble", NM="_ZN4llvm12BitsToDoubleEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12BitsToDoubleEy")
////</editor-fold>
//public static /*inline*/ double BitsToDouble(long/*uint64_t*/ Bits) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    BitsToDouble(Bits);
//}
//
//
///// BitsToFloat - This function takes a 32-bit integer and returns the bit
///// equivalent float.
////<editor-fold defaultstate="collapsed" desc="llvm::BitsToFloat">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 554,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 515,
// FQN="llvm::BitsToFloat", NM="_ZN4llvm11BitsToFloatEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11BitsToFloatEj")
////</editor-fold>
//public static /*inline*/ float BitsToFloat(/*uint32_t*/int Bits) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    BitsToFloat(Bits);
//}
//
//
///// DoubleToBits - This function takes a double and returns the bit
///// equivalent 64-bit integer.  Note that copying doubles around
///// changes the bits of NaNs on some hosts, notably x86, so this
///// routine cannot be used if these bits are needed.
////<editor-fold defaultstate="collapsed" desc="llvm::DoubleToBits">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 567,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 528,
// FQN="llvm::DoubleToBits", NM="_ZN4llvm12DoubleToBitsEd",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12DoubleToBitsEd")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ DoubleToBits(double Double) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    DoubleToBits(Double);
//}
//
//
///// FloatToBits - This function takes a float and returns the bit
///// equivalent 32-bit integer.  Note that copying floats around
///// changes the bits of NaNs on some hosts, notably x86, so this
///// routine cannot be used if these bits are needed.
////<editor-fold defaultstate="collapsed" desc="llvm::FloatToBits">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 580,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 541,
// FQN="llvm::FloatToBits", NM="_ZN4llvm11FloatToBitsEf",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11FloatToBitsEf")
////</editor-fold>
//public static /*inline*/ /*uint32_t*/int FloatToBits(float Float) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    FloatToBits(Float);
//}
//
//
///// MinAlign - A and B are either alignments or offsets.  Return the minimum
///// alignment that may be assumed after adding the two together.
////<editor-fold defaultstate="collapsed" desc="llvm::MinAlign">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 591,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 552,
// FQN="llvm::MinAlign", NM="_ZN4llvm8MinAlignEyy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm8MinAlignEyy")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ MinAlign(long/*uint64_t*/ A, long/*uint64_t*/ B) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    MinAlign(A, B);
//}
//
//
///// \brief Aligns \c Addr to \c Alignment bytes, rounding up.
/////
///// Alignment should be a power of two.  This method rounds up, so
///// alignAddr(7, 4) == 8 and alignAddr(8, 4) == 8.
////<editor-fold defaultstate="collapsed" desc="llvm::alignAddr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 604,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 565,
// FQN="llvm::alignAddr", NM="_ZN4llvm9alignAddrEPKvj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9alignAddrEPKvj")
////</editor-fold>
//public static /*inline*/ Object/*uintptr_t*/ alignAddr(/*const*/Object/*void P*/ Addr, /*size_t*/int Alignment) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    alignAddr(Addr, Alignment);
//}
//
//
///// \brief Returns the necessary adjustment for aligning \c Ptr to \c Alignment
///// bytes, rounding up.
////<editor-fold defaultstate="collapsed" desc="llvm::alignmentAdjustment">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 615,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 576,
// FQN="llvm::alignmentAdjustment", NM="_ZN4llvm19alignmentAdjustmentEPKvj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm19alignmentAdjustmentEPKvj")
////</editor-fold>
//public static /*inline*/ /*size_t*/int alignmentAdjustment(/*const*/Object/*void P*/ Ptr, /*size_t*/int Alignment) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    alignmentAdjustment(Ptr, Alignment);
//}
//
//
///// NextPowerOf2 - Returns the next power of two (in 64-bits)
///// that is strictly greater than A.  Returns zero on overflow.
////<editor-fold defaultstate="collapsed" desc="llvm::NextPowerOf2">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 621,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 582,
// FQN="llvm::NextPowerOf2", NM="_ZN4llvm12NextPowerOf2Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12NextPowerOf2Ey")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ NextPowerOf2(long/*uint64_t*/ A) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    NextPowerOf2(A);
//}
//
//
/// Returns the power of two which is less than or equal to the given value.
/// Essentially, it is a floor operation across the domain of powers of two.
//<editor-fold defaultstate="collapsed" desc="llvm::PowerOf2Floor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 633,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 594,
 FQN="llvm::PowerOf2Floor", NM="_ZN4llvm13PowerOf2FloorEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm13PowerOf2FloorEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ PowerOf2Floor(long/*uint64_t*/ A) {
  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
    PowerOf2Floor(A);
}

//
///// Returns the next integer (mod 2**64) that is greater than or equal to
///// \p Value and is a multiple of \p Align. \p Align must be non-zero.
/////
///// If non-zero \p Skew is specified, the return value will be a minimal
///// integer that is greater than or equal to \p Value and equal to
///// \p Align * N + \p Skew for some integer N. If \p Skew is larger than
///// \p Align, its value is adjusted to '\p Skew mod \p Align'.
/////
///// Examples:
///// \code
/////   alignTo(5, 8) = 8
/////   alignTo(17, 8) = 24
/////   alignTo(~0LL, 8) = 0
/////   alignTo(321, 255) = 510
/////
/////   alignTo(5, 8, 7) = 7
/////   alignTo(17, 8, 1) = 17
/////   alignTo(~0LL, 8, 3) = 3
/////   alignTo(321, 255, 42) = 552
///// \endcode
////<editor-fold defaultstate="collapsed" desc="llvm::alignTo">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 658,
// FQN="llvm::alignTo", NM="_ZN4llvm7alignToEyyy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7alignToEyyy")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ alignTo(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
//  return alignTo(Value, Align, 0);
//}
//public static /*inline*/ long/*uint64_t*/ alignTo(long/*uint64_t*/ Value, long/*uint64_t*/ Align, long/*uint64_t*/ Skew/*= 0*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    alignTo(Value, Align, Skew);
//}
//
//
///// Returns the largest uint64_t less than or equal to \p Value and is
///// \p Skew mod \p Align. \p Align must be non-zero
////<editor-fold defaultstate="collapsed" desc="llvm::alignDown">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 665,
// FQN="llvm::alignDown", NM="_ZN4llvm9alignDownEyyy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9alignDownEyyy")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ alignDown(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
//  return alignDown(Value, Align, 0);
//}
//public static /*inline*/ long/*uint64_t*/ alignDown(long/*uint64_t*/ Value, long/*uint64_t*/ Align, long/*uint64_t*/ Skew/*= 0*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    alignDown(Value, Align, Skew);
//}
//
//
///// Returns the offset to the next integer (mod 2**64) that is greater than
///// or equal to \p Value and is a multiple of \p Align. \p Align must be
///// non-zero.
////<editor-fold defaultstate="collapsed" desc="llvm::OffsetToAlignment">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 673,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 628,
// FQN="llvm::OffsetToAlignment", NM="_ZN4llvm17OffsetToAlignmentEyy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm17OffsetToAlignmentEyy")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ OffsetToAlignment(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    OffsetToAlignment(Value, Align);
//}
//
//
///// Sign-extend the number in the bottom B bits of X to a 32-bit integer.
///// Requires 0 < B <= 32.
///*template <unsigned int B> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 679,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 634,
// FQN="llvm::SignExtend32", NM="Tpl__ZN4llvm12SignExtend32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12SignExtend32Ej")
////</editor-fold>
//public static /*inline*/ </*uint*/int B> int/*int32_t*/ SignExtend32$T(/*uint32_t*/int X) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend32$T(X);
//}
//
//
///// Sign-extend the number in the bottom B bits of X to a 32-bit integer.
///// Requires 0 < B < 32.
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 687,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 640,
// FQN="llvm::SignExtend32", NM="_ZN4llvm12SignExtend32Ejj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12SignExtend32Ejj")
////</editor-fold>
//public static /*inline*/ int/*int32_t*/ SignExtend32(/*uint32_t*/int X, /*uint*/int B) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend32(X, B);
//}
//
//
///// Sign-extend the number in the bottom B bits of X to a 64-bit integer.
///// Requires 0 < B < 64.
///*template <unsigned int B> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 695,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 646,
// FQN="llvm::SignExtend64", NM="Tpl__ZN4llvm12SignExtend64Ey",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12SignExtend64Ey")
////</editor-fold>
//public static /*inline*/ </*uint*/int B> long/*int64_t*/ SignExtend64$T(long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend64$T(x);
//}
//
//
///// Sign-extend the number in the bottom B bits of X to a 64-bit integer.
///// Requires 0 < B < 64.
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 703,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 652,
// FQN="llvm::SignExtend64", NM="_ZN4llvm12SignExtend64Eyj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12SignExtend64Eyj")
////</editor-fold>
//public static /*inline*/ long/*int64_t*/ SignExtend64(long/*uint64_t*/ X, /*uint*/int B) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend64(X, B);
//}
//
//
///// Subtract two unsigned integers, X and Y, of type T and return the absolute
///// value of the result.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::AbsoluteDifference">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 712,
// FQN="llvm::AbsoluteDifference", NM="Tpl__ZN4llvm18AbsoluteDifferenceET_S0_R_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm18AbsoluteDifferenceET_S0_R_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
////</editor-fold>
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T AbsoluteDifference$Unsigned(T X, T Y) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    AbsoluteDifference$Unsigned(X, Y);
//}
//
//
///// Add two unsigned integers, X and Y, of type T.  Clamp the result to the
///// maximum representable value of T on overflow.  ResultOverflowed indicates if
///// the result is larger than the maximum representable value of type T.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::SaturatingAdd">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 721,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 660,
// FQN="llvm::SaturatingAdd", NM="Tpl__ZN4llvm13SaturatingAddET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm13SaturatingAddET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
////</editor-fold>
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingAdd$Unsigned(T X, T Y) {
//  return SaturatingAdd$Unsigned(X, Y, (bool$ptr/*bool P*/ )null);
//}
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingAdd$Unsigned(T X, T Y, bool$ptr/*bool P*/ ResultOverflowed/*= null*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SaturatingAdd$Unsigned(X, Y, ResultOverflowed);
//}
//
//
///// Multiply two unsigned integers, X and Y, of type T.  Clamp the result to the
///// maximum representable value of T on overflow.  ResultOverflowed indicates if
///// the result is larger than the maximum representable value of type T.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::SaturatingMultiply">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 738,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 678,
// FQN="llvm::SaturatingMultiply", NM="Tpl__ZN4llvm18SaturatingMultiplyET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm18SaturatingMultiplyET_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
////</editor-fold>
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiply$Unsigned(T X, T Y) {
//  return SaturatingMultiply$Unsigned(X, Y, (bool$ptr/*bool P*/ )null);
//}
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiply$Unsigned(T X, T Y, bool$ptr/*bool P*/ ResultOverflowed/*= null*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SaturatingMultiply$Unsigned(X, Y, ResultOverflowed);
//}
//
//
///// Multiply two unsigned integers, X and Y, and add the unsigned integer, A to
///// the product. Clamp the result to the maximum representable value of T on
///// overflow. ResultOverflowed indicates if the result is larger than the
///// maximum representable value of type T.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::SaturatingMultiplyAdd">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 784,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", old_line = 726,
// FQN="llvm::SaturatingMultiplyAdd", NM="Tpl__ZN4llvm21SaturatingMultiplyAddET_S0_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm21SaturatingMultiplyAddET_S0_S0_PbR_ZTSNSt9enable_ifIXsr3std11is_unsignedIT_EE5valueES0_E4typeE")
////</editor-fold>
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiplyAdd$Unsigned(T X, T Y, T A) {
//  return SaturatingMultiplyAdd$Unsigned(X, Y, A, (bool$ptr/*bool P*/ )null);
//}
//public static </*typename*/ T> /*std::enable_if<std::is_unsigned<T>::value, T>::type*/T SaturatingMultiplyAdd$Unsigned(T X, T Y, T A, bool$ptr/*bool P*/ ResultOverflowed/*= null*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SaturatingMultiplyAdd$Unsigned(X, Y, A, ResultOverflowed);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::host_char_bit">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 39,
// FQN="llvm::host_char_bit", NM="_ZN4llvmL13host_char_bitE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL13host_char_bitE")
////</editor-fold>
//public static /*const*//*uint*/int host_char_bit = 8;
////<editor-fold defaultstate="collapsed" desc="llvm::integerPartWidth">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 40,
// FQN="llvm::integerPartWidth", NM="_ZN4llvmL16integerPartWidthE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL16integerPartWidthE")
////</editor-fold>
//public static /*const*//*uint*/int integerPartWidth = host_char_bit * $sizeof_ULong();
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1744,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1735,
 FQN="llvm::operator==", NM="_ZN4llvmeqEyRKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqEyRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean $eq_ulong_APInt$C(long/*uint64_t*/ V1, final /*const*/ APInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
    $eq_ulong_APInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1746,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1737,
 FQN="llvm::operator!=", NM="_ZN4llvmneEyRKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneEyRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean $noteq_ulong_APInt$C(long/*uint64_t*/ V1, final /*const*/ APInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
    $noteq_ulong_APInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1748,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1739,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_APInt$C(final raw_ostream /*&*/ OS, final /*const*/ APInt /*&*/ I) {
  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
    $out_raw_ostream_APInt$C(OS, I);
}


/// See friend declarations above.
///
/// These additional declarations are required in order to compile LLVM with IBM
/// xlC compiler.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2869,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", old_line = 2866,
 FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueERKNS_7APFloatE")
//</editor-fold>
public static hash_code hash_value(final /*const*/ APFloat /*&*/ Arg) {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    hash_value(Arg);
}

//<editor-fold defaultstate="collapsed" desc="llvm::ilogb">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3954,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 514,
 FQN="llvm::ilogb", NM="_ZN4llvm5ilogbERKNS_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5ilogbERKNS_7APFloatE")
//</editor-fold>
public static int ilogb(final /*const*/ APFloat /*&*/ Arg) {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    ilogb(Arg);
}

//<editor-fold defaultstate="collapsed" desc="llvm::scalbn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3972,
 FQN="llvm::scalbn", NM="_ZN4llvm6scalbnENS_7APFloatEiNS0_12roundingModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6scalbnENS_7APFloatEiNS0_12roundingModeE")
//</editor-fold>
public static APFloat scalbn(APFloat X, int Exp, APFloat.roundingMode RoundingMode) {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    scalbn(X, Exp, RoundingMode);
}


/// \brief Equivalent of C standard library function.
///
/// While the C standard says Exp is an unspecified value for infinity and nan,
/// this returns INT_MAX for infinities, and INT_MIN for NaNs.
//<editor-fold defaultstate="collapsed" desc="llvm::frexp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3993,
 FQN="llvm::frexp", NM="_ZN4llvm5frexpERKNS_7APFloatERiNS0_12roundingModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5frexpERKNS_7APFloatERiNS0_12roundingModeE")
//</editor-fold>
public static APFloat frexp(final /*const*/ APFloat /*&*/ Val, final int$ref/*int &*/ Exp, APFloat.roundingMode RM) {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    frexp(Val, Exp, RM);
}


/// \brief Returns the absolute value of the argument.
//<editor-fold defaultstate="collapsed" desc="llvm::abs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 660,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 657,
 FQN="llvm::abs", NM="_ZN4llvm3absENS_7APFloatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm3absENS_7APFloatE")
//</editor-fold>
public static /*inline*/ APFloat abs(APFloat X) {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    abs(X);
}


/// Implements IEEE minNum semantics. Returns the smaller of the 2 arguments if
/// both are not NaN. If either argument is a NaN, returns the other argument.
//<editor-fold defaultstate="collapsed" desc="llvm::minnum">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 667,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 664,
 FQN="llvm::minnum", NM="_ZN4llvm6minnumERKNS_7APFloatES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6minnumERKNS_7APFloatES2_")
//</editor-fold>
public static /*inline*/ APFloat minnum(final /*const*/ APFloat /*&*/ A, final /*const*/ APFloat /*&*/ B)/* __attribute__((pure))*/ {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    minnum(A, B);
}


/// Implements IEEE maxNum semantics. Returns the larger of the 2 arguments if
/// both are not NaN. If either argument is a NaN, returns the other argument.
//<editor-fold defaultstate="collapsed" desc="llvm::maxnum">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 678,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", old_line = 675,
 FQN="llvm::maxnum", NM="_ZN4llvm6maxnumERKNS_7APFloatES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6maxnumERKNS_7APFloatES2_")
//</editor-fold>
public static /*inline*/ APFloat maxnum(final /*const*/ APFloat /*&*/ A, final /*const*/ APFloat /*&*/ B)/* __attribute__((pure))*/ {
  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
    maxnum(A, B);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 328,
 FQN="llvm::operator==", NM="_ZN4llvmeqExRKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $eq_long_APSInt$C(long/*int64_t*/ V1, final /*const*/ APSInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $eq_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 329,
 FQN="llvm::operator!=", NM="_ZN4llvmneExRKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $noteq_long_APSInt$C(long/*int64_t*/ V1, final /*const*/ APSInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $noteq_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 330,
 FQN="llvm::operator<=", NM="_ZN4llvmleExRKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmleExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $lesseq_long_APSInt$C(long/*int64_t*/ V1, final /*const*/ APSInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $lesseq_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 331,
 FQN="llvm::operator>=", NM="_ZN4llvmgeExRKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmgeExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $greatereq_long_APSInt$C(long/*int64_t*/ V1, final /*const*/ APSInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $greatereq_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 332,
 FQN="llvm::operator<", NM="_ZN4llvmltExRKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmltExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $less_long_APSInt$C(long/*int64_t*/ V1, final /*const*/ APSInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $less_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 333,
 FQN="llvm::operator>", NM="_ZN4llvmgtExRKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmgtExRKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ boolean $greater_long_APSInt$C(long/*int64_t*/ V1, final /*const*/ APSInt /*&*/ V2) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $greater_long_APSInt$C(V1, V2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 335,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6APSIntE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_APSInt$C(final raw_ostream /*&*/ OS, final /*const*/ APSInt /*&*/ I) {
  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
    $out_raw_ostream_APSInt$C(OS, I);
}


///// \brief Convenience function for iterating over sub-ranges.
/////
///// This provides a bit of syntactic sugar to make using sub-ranges
///// in for loops a bit easier. Analogous to std::make_pair().
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 54,
// FQN="llvm::make_range", NM="Tpl__ZN4llvm10make_rangeET_S0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10make_rangeET_S0_")
////</editor-fold>
//public static </*class*/ T> iterator_range<T> make_range(T x, T y) {
//  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
//    make_range(x, y);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 58,
// FQN="llvm::make_range", NM="Tpl__ZN4llvm10make_rangeESt4pairIT_S1_E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10make_rangeESt4pairIT_S1_E")
////</editor-fold>
//public static </*typename*/ T> iterator_range<T> make_range(std.pair<T, T> p) {
//  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
//    make_range(p);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::drop_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 63,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 62,
// FQN="llvm::drop_begin", NM="Tpl__ZN4llvm10drop_beginEOT_i",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10drop_beginEOT_i")
////</editor-fold>
//public static </*typename*/ T> iterator_range<decltype(begin(std.<T>declval()))> drop_begin(final T /*&&*/t, int n) {
//  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
//    drop_begin(t, n);
//}
//
//
///// @name StringRef Comparison Operators
///// @{
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 592,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 566,
// FQN="llvm::operator==", NM="_ZN4llvmeqENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $eq_StringRef(StringRef LHS, StringRef RHS)/* __attribute__((always_inline))*/ {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $eq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 597,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 571,
// FQN="llvm::operator!=", NM="_ZN4llvmneENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $noteq_StringRef(StringRef LHS, StringRef RHS)/* __attribute__((always_inline))*/ {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $noteq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 602,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 576,
// FQN="llvm::operator<", NM="_ZN4llvmltENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmltENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $less_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $less_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 606,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 580,
// FQN="llvm::operator<=", NM="_ZN4llvmleENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmleENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $lesseq_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $lesseq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator>">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 610,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 584,
// FQN="llvm::operator>", NM="_ZN4llvmgtENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmgtENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $greater_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $greater_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 614,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 588,
// FQN="llvm::operator>=", NM="_ZN4llvmgeENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmgeENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $greatereq_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $greatereq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator+=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 618,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", old_line = 592,
// FQN="llvm::operator+=", NM="_ZN4llvmpLERSsNS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmpLERSsNS_9StringRefE")
////</editor-fold>
//public static /*inline*/ std.string/*&*/ $addassign_string_StringRef(final std.string/*&*/ buffer, StringRef string) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $addassign_string_StringRef(buffer, string);
//}
//
//
///// alignOf - A templated function that returns the minimum alignment of
/////  of a type.  This provides no extra functionality beyond the AlignOf
/////  class besides some cosmetic cleanliness.  Example usage:
/////  alignOf<int>() returns the alignment of an int.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::alignOf">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 106,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", old_line = 105,
// FQN="llvm::alignOf", NM="Tpl__ZN4llvm7alignOfEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm7alignOfEv")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> /*uint*/int alignOf() {
//  return /*delegate*/org.llvm.support.impl.AlignOfLlvmGlobals.
//    alignOf();
//}
//
///*template <typename T, unsigned int N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 905,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", old_line = 931,
// FQN="llvm::capacity_in_bytes", NM="Tpl__ZN4llvmL17capacity_in_bytesERKNS_11SmallVectorIT_XT0_EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvmL17capacity_in_bytesERKNS_11SmallVectorIT_XT0_EEE")
////</editor-fold>
//public static /*inline*/ </*typename*/ T, /*uint*/int N> /*size_t*/int capacity_in_bytes(final /*const*/ SmallVector<T, N> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.SmallVectorLlvmGlobals.
//    capacity_in_bytes(X);
//}
//
//
///// \brief Compute a hash_code for any integer value.
/////
///// Note that this function is intended to compute the same hash_code for
///// a particular value without regard to the pre-promotion type. This is in
///// contrast to hash_combine which may produce different hash_codes for
///// differing argument types even if they would implicit promote to a common
///// type without changing the value.
///*template <typename T> TEMPLATE*/
//// namespace hashing
//
//// Declared and documented above, but defined here so that any of the hashing
//// infrastructure is available.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 632,
// FQN="llvm::hash_value", NM="Tpl__ZN4llvm10hash_valueET_R_ZTSNSt9enable_ifIXsr19is_integral_or_enumIT_EE5valueEN4llvm9hash_codeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10hash_valueET_R_ZTSNSt9enable_ifIXsr19is_integral_or_enumIT_EE5valueEN4llvm9hash_codeEE4typeE")
////</editor-fold>
//public static </*typename*/ T> /*std::enable_if<is_integral_or_enum<T>::value, hash_code>::type*/hash_code hash_value$IntegralOrEnum(T value) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value$IntegralOrEnum(value);
//}
//
//
///// \brief Compute a hash_code for a pointer's address.
/////
///// N.B.: This hashes the *address*. Not the value and not the type.
///*template <typename T> TEMPLATE*/
//
//// Declared and documented above, but defined here so that any of the hashing
//// infrastructure is available.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 640,
// FQN="llvm::hash_value", NM="Tpl__ZN4llvm10hash_valueEPKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10hash_valueEPKT_")
////</editor-fold>
//public static </*typename*/ T> hash_code hash_value_T$C$P(/*const*/ T /*P*/ ptr) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value_T$C$P(ptr);
//}
//
//
///// \brief Compute a hash_code for a pair of objects.
///*template <typename T, typename U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 648,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 647,
// FQN="llvm::hash_value", NM="Tpl__ZN4llvm10hash_valueERKSt4pairIT_T0_E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10hash_valueERKSt4pairIT_T0_E")
////</editor-fold>
//public static </*typename*/ T, /*typename*/ U> hash_code hash_value(final /*const*/ std.pair<T, U> /*&*/ arg) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value(arg);
//}
//
//
///// \brief Compute a hash_code for a standard string.
///*template <typename T> TEMPLATE*/
//
//// Declared and documented above, but defined here so that any of the hashing
//// infrastructure is available.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 655,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 654,
// FQN="llvm::hash_value", NM="Tpl__ZN4llvm10hash_valueERKSbIT_St11char_traitsIS0_ESaIS0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10hash_valueERKSbIT_St11char_traitsIS0_ESaIS0_EE")
////</editor-fold>
//public static </*typename*/ T> hash_code hash_value(final /*const*/ std.basic_string<T> /*&*/ arg) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value(arg);
//}
//
//// namespace hashing
//
///// \brief Compute a hash_code for a sequence of values.
/////
///// This hashes a sequence of values. It produces the same hash_code as
///// 'hash_combine(a, b, c, ...)', but can run over arbitrary sized sequences
///// and is significantly faster given pointers and types which can be hashed as
///// a sequence of bytes.
///*template <typename InputIteratorT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::hash_combine_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 480,
// FQN="llvm::hash_combine_range", NM="Tpl__ZN4llvm18hash_combine_rangeET_S0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm18hash_combine_rangeET_S0_")
////</editor-fold>
//public static </*typename*/ InputIteratorT> hash_code hash_combine_range(InputIteratorT first, InputIteratorT last) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_combine_range(first, last);
//}
//
//// namespace hashing
//
///// \brief Combine values into a single hash_code.
/////
///// This routine accepts a varying number of arguments of any type. It will
///// attempt to combine them into a single hash_code. For user-defined types it
///// attempts to call a \see hash_value overload (via ADL) for the type. For
///// integer and pointer types it directly combines their data into the
///// resulting hash_code.
/////
///// The result is suitable for returning from a user's hash_value
///// *implementation* for their user-defined type. Consumers of a type should
///// *not* call this routine, they should instead call 'hash_value'.
///*template <typename ... Ts> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 602,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", old_line = 603,
// FQN="llvm::hash_combine", NM="Tpl__ZN4llvm12hash_combineEDpRKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12hash_combineEDpRKT_")
////</editor-fold>
//public static </*typename*/ /*...*/ Ts> hash_code hash_combine(/*const*/ Ts /*&*/ args...) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_combine(args);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::None">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/None.h", line = 23,
// FQN="llvm::None", NM="_ZN4llvmL4NoneE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL4NoneE")
////</editor-fold>
//public static /*const*/ NoneType None = None;
//
///// @name ArrayRef Convenience constructors
///// @{
//
///// Construct an ArrayRef from a single element.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 319,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 306,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERKT_")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(final /*const*/ T /*&*/ OneElt) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(OneElt);
//}
//
//
///// Construct an ArrayRef from a pointer and length.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 325,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 312,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefEPKT_j",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefEPKT_j")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ T /*P*/ data, /*size_t*/int length) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(data, length);
//}
//
//
///// Construct an ArrayRef from a range.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 331,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 318,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefEPKT_S2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefEPKT_S2_")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ T /*P*/ begin, /*const*/ T /*P*/ end) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(begin, end);
//}
//
//
///// Construct an ArrayRef from a SmallVector.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 337,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 324,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERKNS_15SmallVectorImplIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERKNS_15SmallVectorImplIT_EE")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(final /*const*/ SmallVectorImpl<T> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Vec);
//}
//
//
///// Construct an ArrayRef from a SmallVector.
///*template <typename T, unsigned int N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 343,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 330,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERKNS_11SmallVectorIT_XT0_EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERKNS_11SmallVectorIT_XT0_EEE")
////</editor-fold>
//public static </*typename*/ T, /*uint*/int N> ArrayRef<T> makeArrayRef(final /*const*/ SmallVector<T, N> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Vec);
//}
//
//
///// Construct an ArrayRef from a std::vector.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 349,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 336,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERKSt6vectorIT_SaIS1_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERKSt6vectorIT_SaIS1_EE")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(final /*const*/ std.vector<T> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Vec);
//}
//
//
///// Construct an ArrayRef from an ArrayRef (no-op) (const)
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 354,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 342,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERKNS_8ArrayRefIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERKNS_8ArrayRefIT_EE")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef_ArrayRef$T$C(final /*const*/ ArrayRef<T> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef_ArrayRef$T$C(Vec);
//}
//
//
///// Construct an ArrayRef from an ArrayRef (no-op)
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 359,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 347,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERNS_8ArrayRefIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERNS_8ArrayRefIT_EE")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> /*&*/ makeArrayRef_ArrayRef$T(final ArrayRef<T> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef_ArrayRef$T(Vec);
//}
//
//
///// Construct an ArrayRef from a C array.
///*template <typename T, size_t N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 365,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 352,
// FQN="llvm::makeArrayRef", NM="Tpl__ZN4llvm12makeArrayRefERAT0__KT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm12makeArrayRefERAT0__KT_")
////</editor-fold>
//public static </*typename*/ T, /*size_t*/int N> ArrayRef<T> makeArrayRef(final /*ADD MAPPING FOR FUN PTR[const T (& )[N]]*//*const*/ T (/*&*/ Arr)[N]) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Arr);
//}
//
//
///// @}
///// @name ArrayRef Comparison Operators
///// @{
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 374,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 361,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqENS_8ArrayRefIT_EES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvmeqENS_8ArrayRefIT_EES2_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> boolean $eq_ArrayRef$T(ArrayRef<T> LHS, ArrayRef<T> RHS) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    $eq_ArrayRef$T(LHS, RHS);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 379,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 366,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneENS_8ArrayRefIT_EES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvmneENS_8ArrayRefIT_EES2_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> boolean $noteq_ArrayRef$T(ArrayRef<T> LHS, ArrayRef<T> RHS) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    $noteq_ArrayRef$T(LHS, RHS);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 391,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", old_line = 379,
// FQN="llvm::hash_value", NM="Tpl__ZN4llvm10hash_valueENS_8ArrayRefIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm10hash_valueENS_8ArrayRefIT_EE")
////</editor-fold>
//public static </*typename*/ T> hash_code hash_value(ArrayRef<T> S) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    hash_value(S);
//}


/// hexdigit - Return the hexadecimal character for the
/// given number \p X (which should be less than 16).
//<editor-fold defaultstate="collapsed" desc="llvm::hexdigit">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 26,
 FQN="llvm::hexdigit", NM="_ZN4llvmL8hexdigitEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL8hexdigitEjb")
//</editor-fold>
public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X) {
  return hexdigit(X, false);
}
public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X, boolean LowerCase/*= false*/) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    hexdigit(X, LowerCase);
}


///// Construct a string ref from a boolean.
////<editor-fold defaultstate="collapsed" desc="llvm::toStringRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 32,
// FQN="llvm::toStringRef", NM="_ZN4llvmL11toStringRefEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL11toStringRefEb")
////</editor-fold>
//public static /*inline*/ StringRef toStringRef(boolean B) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    toStringRef(B);
//}
//
//
///// Interpret the given character \p C as a hexadecimal digit and return its
///// value.
/////
///// If \p C is not a valid hex digit, -1U is returned.
////<editor-fold defaultstate="collapsed" desc="llvm::hexDigitValue">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 40,
// FQN="llvm::hexDigitValue", NM="_ZN4llvmL13hexDigitValueEc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL13hexDigitValueEc")
////</editor-fold>
//public static /*inline*/ /*uint*/int hexDigitValue(/*char*/byte C) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    hexDigitValue(C);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::utohexstr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 47,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 72,
// FQN="llvm::utohexstr", NM="_ZN4llvmL9utohexstrEyb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL9utohexstrEyb")
////</editor-fold>
//public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X) {
//  return utohexstr(X, false);
//}
//public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X, boolean LowerCase/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    utohexstr(X, LowerCase);
//}
//
//
///// Convert buffer \p Input to its hexadecimal representation.
///// The returned string is double the size of \p Input.
////<editor-fold defaultstate="collapsed" desc="llvm::toHex">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 64,
// FQN="llvm::toHex", NM="_ZN4llvmL5toHexENS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL5toHexENS_9StringRefE")
////</editor-fold>
//public static /*inline*/ std.string toHex(StringRef Input) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    toHex(Input);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::utostr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 78,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 93,
// FQN="llvm::utostr", NM="_ZN4llvmL6utostrEyb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL6utostrEyb")
////</editor-fold>
//public static /*inline*/ std.string utostr(long/*uint64_t*/ X) {
//  return utostr(X, false);
//}
//public static /*inline*/ std.string utostr(long/*uint64_t*/ X, boolean isNeg/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    utostr(X, isNeg);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::itostr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 94,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 109,
 FQN="llvm::itostr", NM="_ZN4llvmL6itostrEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL6itostrEx")
//</editor-fold>
public static /*inline*/ std.string itostr(long/*int64_t*/ X) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    itostr(X);
}


///// HashString - Hash function for strings.
/////
///// This is the Bernstein hash function.
////
//// FIXME: Investigate whether a modified bernstein hash function performs
//// better: http://eternallyconfuzzled.com/tuts/algorithms/jsw_tut_hashing.aspx
////   X*33+c -> X*33^c
////<editor-fold defaultstate="collapsed" desc="llvm::HashString">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 128,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 143,
// FQN="llvm::HashString", NM="_ZN4llvmL10HashStringENS_9StringRefEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL10HashStringENS_9StringRefEj")
////</editor-fold>
//public static /*inline*/ /*uint*/int HashString(StringRef Str) {
//  return HashString(Str, 0);
//}
//public static /*inline*/ /*uint*/int HashString(StringRef Str, /*uint*/int Result/*= 0*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    HashString(Str, Result);
//}
//
//
///// Returns the English suffix for an ordinal integer (-st, -nd, -rd, -th).
////<editor-fold defaultstate="collapsed" desc="llvm::getOrdinalSuffix">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 135,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 150,
// FQN="llvm::getOrdinalSuffix", NM="_ZN4llvmL16getOrdinalSuffixEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL16getOrdinalSuffixEj")
////</editor-fold>
//public static /*inline*/ StringRef getOrdinalSuffix(/*uint*/int Val) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    getOrdinalSuffix(Val);
//}
//
///*template <typename IteratorT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 154,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 168,
// FQN="llvm::join_impl", NM="Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag")
////</editor-fold>
//public static /*inline*/ </*typename*/ IteratorT> std.string join_impl_T_StringRef_input_iterator_tag(IteratorT Begin, IteratorT End, 
//                                        StringRef Separator, std.input_iterator_tag $Prm3) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    join_impl_T_StringRef_input_iterator_tag(Begin, End, 
//                                        Separator, $Prm3);
//}
//
///*template <typename IteratorT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 169,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 183,
// FQN="llvm::join_impl", NM="Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag")
////</editor-fold>
//public static /*inline*/ </*typename*/ IteratorT> std.string join_impl_T_StringRef_forward_iterator_tag(IteratorT Begin, IteratorT End, 
//                                          StringRef Separator, std.forward_iterator_tag $Prm3) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    join_impl_T_StringRef_forward_iterator_tag(Begin, End, 
//                                          Separator, $Prm3);
//}
//

/// Joins the strings in the range [Begin, End), adding Separator between
/// the elements.
/*template <typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::join">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 190,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 204,
 FQN="llvm::join", NM="Tpl__ZN4llvm4joinET_S0_NS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=Tpl__ZN4llvm4joinET_S0_NS_9StringRefE")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT extends type$iterator<?, std.string>> std.string join(IteratorT Begin, IteratorT End, StringRef Separator) {
  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
    join(Begin, End, Separator);
}

//// End of APIntOps namespace
//
// See friend declaration above. This additional declaration is required in
// order to compile LLVM with IBM xlC compiler.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 655,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 668,
 FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm10hash_valueERKNS_5APIntE")
//</editor-fold>
public static hash_code hash_value(final /*const*/ APInt /*&*/ Arg) {
  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
    hash_value(Arg);
}


//// isa<X> - Return true if the parameter to the template is an instance of the
//// template type argument.  Used like this:
////
////  if (isa<Type>(myVal)) { ... }
////
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isa">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 132,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 131,
// FQN="llvm::isa", NM="Tpl__ZN4llvm3isaERKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm3isaERKT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> boolean isa(final /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    isa(Val);
//}
//
//
//// cast<X> - Return the argument parameter cast to the specified type.  This
//// casting operator asserts that the type is correct, so it does not return null
//// on failure.  It does not allow a null argument (use cast_or_null for that).
//// It is typically used like this:
////
////  cast<Instruction>(myVal)->getParent()
////
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 220,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 219,
// FQN="llvm::cast", NM="Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm4castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ cast_retty<X, /*const*/ Y>.ret_type cast$NotSimpleType(final /*const*/ Y /*&*/ Val) {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast$NotSimpleType(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 229,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 228,
// FQN="llvm::cast", NM="Tpl__ZN4llvm4castERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm4castERT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y>.ret_type cast_T1$R(final Y /*&*/ Val) {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_T1$R(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 236,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 235,
// FQN="llvm::cast", NM="Tpl__ZN4llvm4castEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm4castEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type cast_T1$P(Y /*P*/ Val) {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_T1$P(Val);
//}
//
//
//// cast_or_null<X> - Functionally identical to cast, except that a null value is
//// accepted.
////
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 246,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 245,
// FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm12cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ cast_retty<X, /*const*/ Y>.ret_type cast_or_null$NotSimpleType(final /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_or_null$NotSimpleType(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 256,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 255,
// FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm12cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X, Y>.ret_type>::type*/ cast_retty<X, Y>.ret_type cast_or_null$NotSimpleType(final Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_or_null$NotSimpleType(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 266,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 265,
// FQN="llvm::cast_or_null", NM="Tpl__ZN4llvm12cast_or_nullEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm12cast_or_nullEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type cast_or_null_T1$P(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_or_null_T1$P(Val);
//}
//
//
//// dyn_cast<X> - Return the argument parameter cast to the specified type.  This
//// casting operator returns null if the argument is of the wrong type, so it can
//// be used to test for a type as well as cast if successful.  This should be
//// used in the context of an if statement like this:
////
////  if (const Instruction *I = dyn_cast<Instruction>(myVal)) { ... }
////
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 283,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 282,
// FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm8dyn_castERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ cast_retty<X, /*const*/ Y>.ret_type dyn_cast$NotSimpleType(final /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast$NotSimpleType(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 290,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 289,
// FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm8dyn_castERT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y>.ret_type dyn_cast_T1$R(final Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_T1$R(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 296,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 295,
// FQN="llvm::dyn_cast", NM="Tpl__ZN4llvm8dyn_castEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm8dyn_castEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type dyn_cast_T1$P(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_T1$P(Val);
//}
//
//
//// dyn_cast_or_null<X> - Functionally identical to dyn_cast, except that a null
//// value is accepted.
////
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 305,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 304,
// FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullERKT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_KS0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X,  Y>.ret_type>::type*/ cast_retty<X, /*const*/ Y>.ret_type dyn_cast_or_null$NotSimpleType(final /*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_or_null$NotSimpleType(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 312,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 311,
// FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullERT0_R_ZTSNSt9enable_ifIXntsr14is_simple_typeIT0_EE5valueEN4llvm10cast_rettyIT_S0_E8ret_typeEE4typeE")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> /*std::enable_if<!is_simple_type<Y>::value,  cast_retty<X, Y>.ret_type>::type*/ cast_retty<X, Y>.ret_type dyn_cast_or_null$NotSimpleType(final Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_or_null$NotSimpleType(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 319,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", old_line = 318,
// FQN="llvm::dyn_cast_or_null", NM="Tpl__ZN4llvm16dyn_cast_or_nullEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm16dyn_cast_or_nullEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type dyn_cast_or_null_T1$P(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_or_null_T1$P(Val);
//}
//
/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 189,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", old_line = 188,
 FQN="llvm::operator==", NM="Tpl__ZN4llvmeqENS_12PointerUnionIT_T0_EES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqENS_12PointerUnionIT_T0_EES3_")
//</editor-fold>
public static </*typename*/ PT1, /*typename*/ PT2> boolean $eq_PointerUnion$PT1$PT2(PointerUnion<PT1, PT2> lhs, PointerUnion<PT1, PT2> rhs) {
  return /*delegate*/org.llvm.adt.impl.PointerUnionLlvmGlobals.
    $eq_PointerUnion$PT1$PT2(lhs, rhs);
}

/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 194,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", old_line = 193,
 FQN="llvm::operator!=", NM="Tpl__ZN4llvmneENS_12PointerUnionIT_T0_EES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneENS_12PointerUnionIT_T0_EES3_")
//</editor-fold>
public static </*typename*/ PT1, /*typename*/ PT2> boolean $noteq_PointerUnion$PT1$PT2(PointerUnion<PT1, PT2> lhs, PointerUnion<PT1, PT2> rhs) {
  return /*delegate*/org.llvm.adt.impl.PointerUnionLlvmGlobals.
    $noteq_PointerUnion$PT1$PT2(lhs, rhs);
}

/*template <typename PT1, typename PT2> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 199,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", old_line = 198,
 FQN="llvm::operator<", NM="Tpl__ZN4llvmltENS_12PointerUnionIT_T0_EES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmltENS_12PointerUnionIT_T0_EES3_")
//</editor-fold>
public static </*typename*/ PT1, /*typename*/ PT2> boolean $less_PointerUnion$PT1$PT2(PointerUnion<PT1, PT2> lhs, PointerUnion<PT1, PT2> rhs) {
  return /*delegate*/org.llvm.adt.impl.PointerUnionLlvmGlobals.
    $less_PointerUnion$PT1$PT2(lhs, rhs);
}

///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 205,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 204,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr$T$C_IntrusiveRefCntPtr$U$C(final /*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                                                 final /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_IntrusiveRefCntPtr$T$C_IntrusiveRefCntPtr$U$C(A, 
//                                                 B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 212,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 211,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_IntrusiveRefCntPtr$T$C_IntrusiveRefCntPtr$U$C(final /*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                                                    final /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_IntrusiveRefCntPtr$T$C_IntrusiveRefCntPtr$U$C(A, 
//                                                    B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 219,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 218,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr$T$C_T1$P(final /*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                               U /*P*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_IntrusiveRefCntPtr$T$C_T1$P(A, 
//                               B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 226,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 225,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_IntrusiveRefCntPtr$T$C_T1$P(final /*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                                  U /*P*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_IntrusiveRefCntPtr$T$C_T1$P(A, 
//                                  B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 233,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 232,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqEPT_RKNS_18IntrusiveRefCntPtrIT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqEPT_RKNS_18IntrusiveRefCntPtrIT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_T$P_IntrusiveRefCntPtr$U$C(T /*P*/ A, 
//                              final /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_T$P_IntrusiveRefCntPtr$U$C(A, 
//                              B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 240,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 239,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneEPT_RKNS_18IntrusiveRefCntPtrIT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneEPT_RKNS_18IntrusiveRefCntPtrIT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_T$P_IntrusiveRefCntPtr$U$C(T /*P*/ A, 
//                                 final /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_T$P_IntrusiveRefCntPtr$U$C(A, 
//                                 B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 247,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 246,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqEDnRKNS_18IntrusiveRefCntPtrIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqEDnRKNS_18IntrusiveRefCntPtrIT_EE")
////</editor-fold>
//public static </*class*/ T> boolean $eq_nullptr_t_IntrusiveRefCntPtr$T$C(/*nullptr_t*/Object A, final /*const*/ IntrusiveRefCntPtr<T> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_nullptr_t_IntrusiveRefCntPtr$T$C(A, B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 252,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 251,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEDn",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEDn")
////</editor-fold>
//public static </*class*/ T> boolean $eq_IntrusiveRefCntPtr$T$C_nullptr_t(final /*const*/ IntrusiveRefCntPtr<T> /*&*/ A, /*nullptr_t*/Object B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_IntrusiveRefCntPtr$T$C_nullptr_t(A, B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 257,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 256,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneEDnRKNS_18IntrusiveRefCntPtrIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneEDnRKNS_18IntrusiveRefCntPtrIT_EE")
////</editor-fold>
//public static </*class*/ T> boolean $noteq_nullptr_t_IntrusiveRefCntPtr$T$C(/*nullptr_t*/Object A, final /*const*/ IntrusiveRefCntPtr<T> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_nullptr_t_IntrusiveRefCntPtr$T$C(A, B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 262,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 261,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEDn",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEDn")
////</editor-fold>
//public static </*class*/ T> boolean $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(final /*const*/ IntrusiveRefCntPtr<T> /*&*/ A, /*nullptr_t*/Object B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_IntrusiveRefCntPtr$T$C_nullptr_t(A, B);
//}
//
///*template <typename KeyT, typename ValueT, typename KeyInfoT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1113,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", old_line = 1066,
// FQN="llvm::capacity_in_bytes", NM="Tpl__ZN4llvmL17capacity_in_bytesERKNS_8DenseMapIT_T0_T1_NS_6detail12DenseMapPairIS1_S2_EEEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmL17capacity_in_bytesERKNS_8DenseMapIT_T0_T1_NS_6detail12DenseMapPairIS1_S2_EEEE")
////</editor-fold>
//public static /*inline*/ </*typename*/ KeyT, /*typename*/ ValueT, /*typename*/ KeyInfoT> /*size_t*/int capacity_in_bytes(final /*const*/ DenseMap<KeyT, ValueT, KeyInfoT> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.DenseMapLlvmGlobals.
//    capacity_in_bytes(X);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 163,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 162,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_8OptionalIT_EENS_8NoneTypeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqERKNS_8OptionalIT_EENS_8NoneTypeE")
////</editor-fold>
//public static </*typename*/ T> boolean $eq_Optional$T$C_NoneType(final /*const*/ Optional<T> /*&*/ X, NoneType $Prm1) {
//  return /*delegate*/org.llvm.adt.impl.OptionalLlvmGlobals.
//    $eq_Optional$T$C_NoneType(X, $Prm1);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 168,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 167,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqENS_8NoneTypeERKNS_8OptionalIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqENS_8NoneTypeERKNS_8OptionalIT_EE")
////</editor-fold>
//public static </*typename*/ T> boolean $eq_NoneType_Optional$T$C(NoneType $Prm0, final /*const*/ Optional<T> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.OptionalLlvmGlobals.
//    $eq_NoneType_Optional$T$C($Prm0, X);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 173,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 172,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_8OptionalIT_EENS_8NoneTypeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneERKNS_8OptionalIT_EENS_8NoneTypeE")
////</editor-fold>
//public static </*typename*/ T> boolean $noteq_Optional$T$C_NoneType(final /*const*/ Optional<T> /*&*/ X, NoneType $Prm1) {
//  return /*delegate*/org.llvm.adt.impl.OptionalLlvmGlobals.
//    $noteq_Optional$T$C_NoneType(X, $Prm1);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 178,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 177,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneENS_8NoneTypeERKNS_8OptionalIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmneENS_8NoneTypeERKNS_8OptionalIT_EE")
////</editor-fold>
//public static </*typename*/ T> boolean $noteq_NoneType_Optional$T$C(NoneType $Prm0, final /*const*/ Optional<T> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.OptionalLlvmGlobals.
//    $noteq_NoneType_Optional$T$C($Prm0, X);
//}
//
//
//// deleter - Very very very simple method that is used to invoke operator
//// delete on something.  It is used like this:
////
////   for_each(V.begin(), B.end(), deleter<Interval>);
////
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::deleter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 108,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 97,
// FQN="llvm::deleter", NM="Tpl__ZN4llvm7deleterEPT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm7deleterEPT_")
////</editor-fold>
//public static /*inline*/ </*class*/ T> void deleter(T /*P*/ Ptr) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    deleter(Ptr);
//}
//
///*template <class Iterator, class Func> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 196,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 183,
// FQN="llvm::operator+", NM="Tpl__ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_")
////</editor-fold>
//public static /*inline*/ </*class*/ Iterator, /*class*/ Func> mapped_iterator<Iterator, Func> $add_mapped_iterator$Iterator$Func_mapped_iterator$Iterator$Func$C( mapped_iterator<Iterator, Func>.difference_type N, 
//                                                                  final /*const*/ mapped_iterator<Iterator, Func> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    $add_mapped_iterator$Iterator$Func_mapped_iterator$Iterator$Func$C(N, 
//                                                                  X);
//}
//
//
// map_iterator - Provide a convenient way to create mapped_iterators, just like
// make_pair is useful for creating pairs...
//
///*template <class ItTy, class FuncTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::map_iterator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 207,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 194,
// FQN="llvm::map_iterator", NM="Tpl__ZN4llvm12map_iteratorERKT_T0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm12map_iteratorERKT_T0_")
////</editor-fold>
//public static /*inline*/ </*class*/ FromType, /*class*/ ToType> 
//        mapped_iterator<FromType, ToType> 
//        map_iterator(/*const*/type$iterator<?, FromType> /*&*/ I, Converter<FromType, ToType> F) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    map_iterator(I, F);
//}
//
//
//// Returns an iterator_range over the given container which iterates in reverse.
//// Note that the container must have rbegin()/rend() methods for this to work.
///*template <typename ContainerTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::reverse">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 221,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 208,
// FQN="llvm::reverse", NM="Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXsr10has_rbeginIS0_EE5valueEvE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXsr10has_rbeginIS0_EE5valueEvE4typeE")
////</editor-fold>
//public static </*typename*/ ContainerTy> auto reverse$HasRBegin(final ContainerTy /*&&*/C) -> decltype(make_range(C.rbegin(), C.rend())) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    reverse$HasRBegin(C);
//}
//
//
//// Returns a std::reverse_iterator wrapped around the given iterator.
///*template <typename IteratorTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_reverse_iterator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 229,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 216,
// FQN="llvm::make_reverse_iterator", NM="Tpl__ZN4llvm21make_reverse_iteratorET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm21make_reverse_iteratorET_")
////</editor-fold>
//public static </*typename*/ IteratorTy> std.reverse_iterator<IteratorTy> make_reverse_iterator(IteratorTy It) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    make_reverse_iterator(It);
//}
//
//
//// Returns an iterator_range over the given container which iterates in reverse.
//// Note that the container must have begin()/end() methods which return
//// bidirectional iterators for this to work.
///*template <typename ContainerTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::reverse">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 237,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 224,
// FQN="llvm::reverse", NM="Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXntsr10has_rbeginIS0_EE5valueEvE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm7reverseEOT_PNSt9enable_ifIXntsr10has_rbeginIS0_EE5valueEvE4typeE")
////</editor-fold>
//public static </*typename*/ ContainerTy> auto reverse$NotHasRBegin(final ContainerTy /*&&*/C) -> decltype(make_range(llvm.make_reverse_iterator(std.end(C)), 
//    llvm.make_reverse_iterator(std.begin(C)))) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    reverse$NotHasRBegin(C);
//}
//
///*template <typename RT, typename PT> TEMPLATE*/
//
//
///// Convenience function that takes a range of elements and a predicate,
///// and return a new filter_iterator range.
/////
///// FIXME: Currently if RangeT && is a rvalue reference to a temporary, the
///// lifetime of that temporary is not kept by the returned range object, and the
///// temporary is going to be dropped on the floor after the make_iterator_range
///// full expression that contains this function call.
///*template <typename RangeT, typename PredicateT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_filter_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 320,
// FQN="llvm::make_filter_range", NM="Tpl__ZN4llvm17make_filter_rangeEOT_T0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm17make_filter_rangeEOT_T0_")
////</editor-fold>
//public static </*typename*/ RangeT, /*typename*/ PredicateT> iterator_range<filter_iterator<detail.IterOfRange<RangeT>, PredicateT> > make_filter_range(final RangeT /*&&*/Range, PredicateT Pred) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    make_filter_range(Range, Pred);
//}
//
//
////===----------------------------------------------------------------------===//
////     Extra additions for arrays
////===----------------------------------------------------------------------===//
//
///// Find the length of an array.
///*template <class T, std::size_t N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::array_lengthof">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 378,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 281,
// FQN="llvm::array_lengthof", NM="Tpl__ZN4llvm14array_lengthofERAT0__T_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm14array_lengthofERAT0__T_")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*uint*/int N> /*size_t*/int array_lengthof(final /*ADD MAPPING FOR FUN PTR[T (& )[N]]*/T (/*&*/ $Prm0)[N]) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_lengthof($Prm0);
//}
//
//
///// Adapt std::less<T> for array_pod_sort.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort_comparator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 384,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 287,
// FQN="llvm::array_pod_sort_comparator", NM="Tpl__ZN4llvm25array_pod_sort_comparatorEPKvS1_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm25array_pod_sort_comparatorEPKvS1_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> int array_pod_sort_comparator(/*const*/Object/*void P*/ P1, /*const*/Object/*void P*/ P2) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_pod_sort_comparator(P1, P2);
//}
//
//
///// get_array_pod_sort_comparator - This is an internal helper function used to
///// get type deduction of T right.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::get_array_pod_sort_comparator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 397,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 300,
// FQN="llvm::get_array_pod_sort_comparator", NM="Tpl__ZN4llvm29get_array_pod_sort_comparatorERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm29get_array_pod_sort_comparatorERKT_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> /*ADD MAPPING FOR FUN PTR[int (* )(const void * , const void * )]*/int (/*P*/ get_array_pod_sort_comparator(final /*const*/ T /*&*/ $Prm0))(/*const*/Object/*void P*/ , /*const*/Object/*void P*/ ) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    get_array_pod_sort_comparator($Prm0);
//}
//
//
///// array_pod_sort - This sorts an array with the specified start and end
///// extent.  This is just like std::sort, except that it calls qsort instead of
///// using an inlined template.  qsort is slightly slower than std::sort, but
///// most sorts are not performance critical in LLVM and std::sort has to be
///// template instantiated for each type, leading to significant measured code
///// bloat.  This function should generally be used instead of std::sort where
///// possible.
/////
///// This function assumes that you have simple POD-like types that can be
///// compared with std::less and can be moved with memcpy.  If this isn't true,
///// you should use std::sort.
/////
///// NOTE: If qsort_r were portable, we could allow a custom comparator and
///// default to std::less.
///*template <class IteratorTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 418,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 321,
// FQN="llvm::array_pod_sort", NM="Tpl__ZN4llvm14array_pod_sortET_S0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm14array_pod_sortET_S0_")
////</editor-fold>
//public static /*inline*/ </*class*/ IteratorTy> void array_pod_sort(IteratorTy Start, IteratorTy End) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_pod_sort(Start, End);
//}
//
///*template <class IteratorTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 427,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 330,
// FQN="llvm::array_pod_sort", NM="Tpl__ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E")
////</editor-fold>
//public static /*inline*/ </*class*/ IteratorTy> void array_pod_sort(IteratorTy Start, IteratorTy End, 
//              Comparator<?> Compare) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_pod_sort(Start, End, 
//              Compare);
//}
//
//
////===----------------------------------------------------------------------===//
////     Extra additions to <algorithm>
////===----------------------------------------------------------------------===//
//
///// For a container of pointers, deletes the pointers and then clears the
///// container.
///*template <typename Container> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerPointers">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 447,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 350,
// FQN="llvm::DeleteContainerPointers", NM="Tpl__ZN4llvm23DeleteContainerPointersERT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm23DeleteContainerPointersERT_")
////</editor-fold>
//public static </*typename*/ Container> void DeleteContainerPointers(final Container /*&*/ C) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    DeleteContainerPointers(C);
//}
//
//
///// In a container of pairs (usually a map) whose second element is a pointer,
///// deletes the second elements and then clears the container.
///*template <typename Container> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerSeconds">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 456,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 359,
// FQN="llvm::DeleteContainerSeconds", NM="Tpl__ZN4llvm22DeleteContainerSecondsERT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm22DeleteContainerSecondsERT_")
////</editor-fold>
//public static </*typename*/ Container> void DeleteContainerSeconds(final Container /*&*/ C) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    DeleteContainerSeconds(C);
//}
//
//
///// Provide wrappers to std::all_of which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::all_of">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 465,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 368,
// FQN="llvm::all_of", NM="Tpl__ZN4llvm6all_ofEOT_OT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm6all_ofEOT_OT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ UnaryPredicate> boolean all_of(final R /*&&*/Range, final UnaryPredicate /*&&*/P) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    all_of(Range, P);
//}
//
//
///// Provide wrappers to std::any_of which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::any_of">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 473,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 376,
// FQN="llvm::any_of", NM="Tpl__ZN4llvm6any_ofEOT_OT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm6any_ofEOT_OT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ UnaryPredicate> boolean any_of(final R /*&&*/Range, final UnaryPredicate /*&&*/P) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    any_of(Range, P);
//}
//
//
///// Provide wrappers to std::none_of which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::none_of">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 481,
// FQN="llvm::none_of", NM="Tpl__ZN4llvm7none_ofEOT_OT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm7none_ofEOT_OT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ UnaryPredicate> boolean none_of(final R /*&&*/Range, final UnaryPredicate /*&&*/P) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    none_of(Range, P);
//}
//
//
///// Provide wrappers to std::find which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::find">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 489,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 384,
// FQN="llvm::find", NM="Tpl__ZN4llvm4findEOT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm4findEOT_RKT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ T> auto find(final R /*&&*/Range, final /*const*/ T /*&*/ val) -> decltype(Range.begin()) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    find(Range, val);
//}
//
//
///// Provide wrappers to std::find_if which take ranges instead of having to pass
///// begin/end explicitly.
///*template <typename R, class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::find_if">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 496,
// FQN="llvm::find_if", NM="Tpl__ZN4llvm7find_ifEOT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm7find_ifEOT_RKT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ T> auto find_if(final R /*&&*/Range, final /*const*/ T /*&*/ Pred) -> decltype(Range.begin()) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    find_if(Range, Pred);
//}
//
//
///// Provide wrappers to std::remove_if which take ranges instead of having to
///// pass begin/end explicitly.
///*template <typename R, class UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::remove_if">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 503,
// FQN="llvm::remove_if", NM="Tpl__ZN4llvm9remove_ifEOT_OT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm9remove_ifEOT_OT0_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ UnaryPredicate> auto remove_if(final R /*&&*/Range, final UnaryPredicate /*&&*/P) -> decltype(Range.begin()) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    remove_if(Range, P);
//}
//
//
/// Wrapper function around std::find to detect if an element exists
/// in a container.
/*template <typename R, typename E> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::is_contained">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 510,
 FQN="llvm::is_contained", NM="Tpl__ZN4llvm12is_containedEOT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm12is_containedEOT_RKT0_")
//</editor-fold>
public static </*typename*/ R extends NativeIterable<type$ptr<E>>, /*typename*/ E> boolean is_contained(final R /*&&*/Range, final /*const*/ E /*&*/ Element) {
  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
    is_contained(Range, Element);
}


/// Wrapper function around std::count_if to count the number of times an
/// element satisfying a given predicate occurs in a range.
/*template <typename R, typename UnaryPredicate> TEMPLATE*/
/// Wrapper function around std::count_if to count the number of times an
/// element satisfying a given predicate occurs in a range.
/*template <typename R, typename UnaryPredicate> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::count_if">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 517,
 FQN="llvm::count_if", NM="Tpl__ZN4llvm8count_ifEOT_OT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm8count_ifEOT_OT0_")
//</editor-fold>
public static </*typename*/ R extends NativeIterable<type$iterator<?, T>>, /*typename*/ T> int count_if(final R /*&&*/Range, final BoolPredicate<T> /*&&*/P){
  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
    count_if(Range, P);
}


///// Wrapper function around std::transform to apply a function to a range and
///// store the result elsewhere.
///*template <typename R, class OutputIt, typename UnaryPredicate> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::transform">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 525,
// FQN="llvm::transform", NM="Tpl__ZN4llvm9transformEOT_T0_OT1_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm9transformEOT_T0_OT1_")
////</editor-fold>
//public static </*typename*/ R, /*class*/ OutputIt, /*typename*/ UnaryPredicate> OutputIt transform(final R /*&&*/Range, OutputIt d_first, final UnaryPredicate /*&&*/P) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    transform(Range, d_first, P);
//}
//
//
////===----------------------------------------------------------------------===//
////     Extra additions to <memory>
////===----------------------------------------------------------------------===//
//
//// Implement make_unique according to N3656.
//
///// \brief Constructs a `new T()` with the given args and returns a
/////        `unique_ptr<T>` which owns the object.
/////
///// Example:
/////
/////     auto p = make_unique<int>();
/////     auto p = make_unique<std::tuple<int, int>>(0, 1);
///*template <class T, class ... Args> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 544,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 402,
// FQN="llvm::make_unique", NM="Tpl__ZN4llvm11make_uniqueEDpOT0_R_ZTSNSt9enable_ifIXntsr3std8is_arrayIT_EE5valueESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm11make_uniqueEDpOT0_R_ZTSNSt9enable_ifIXntsr3std8is_arrayIT_EE5valueESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE")
////</editor-fold>
//public static </*class*/ T, /*class*/ /*...*/ Args> /*std::enable_if<!std::is_array<T>::value, std.unique_ptr<T> >::type*/std.unique_ptr<T> make_unique$NotArray(Args /*&&*/args...) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    make_unique$NotArray(args);
//}
//
//
///// \brief Constructs a `new T[n]` with the given args and returns a
/////        `unique_ptr<T[]>` which owns the object.
/////
///// \param n size of the new array.
/////
///// Example:
/////
/////     auto p = make_unique<int[]>(2); // value-initializes the array with 0's.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 558,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 416,
// FQN="llvm::make_unique", NM="Tpl__ZN4llvm11make_uniqueEjR_ZTSNSt9enable_ifIXaasr3std8is_arrayIT_EE5valueeqsr3std6extentIS0_EE5valueLi0EESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvm11make_uniqueEjR_ZTSNSt9enable_ifIXaasr3std8is_arrayIT_EE5valueeqsr3std6extentIS0_EE5valueLi0EESt10unique_ptrIS0_St14default_deleteIS0_EEE4typeE")
////</editor-fold>
//public static </*class*/ T> /*std::enable_if<Native.$bool(std::is_array<T>::value) && Native.$bool(std::extent<T>::value == 0), std.unique_ptr<T> >::type*/std.unique_ptr<T> make_unique(/*size_t*/int n) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    make_unique(n);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 514,
// FQN="llvm::operator+", NM="_ZN4llvmplERKNS_5TwineES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmplERKNS_5TwineES2_")
////</editor-fold>
//public static /*inline*/ Twine $add_Twine$C(final /*const*/ Twine /*&*/ LHS, final /*const*/ Twine /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $add_Twine$C(LHS, RHS);
//}
//
//
///// Additional overload to guarantee simplified codegen; this is equivalent to
///// concat().
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 521,
// FQN="llvm::operator+", NM="_ZN4llvmplEPKcRKNS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmplEPKcRKNS_9StringRefE")
////</editor-fold>
//public static /*inline*/ Twine $add_char$ptr$C_StringRef$C(/*const*/char$ptr/*char P*/ LHS, final /*const*/ StringRef /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $add_char$ptr$C_StringRef$C(LHS, RHS);
//}
//
//
///// Additional overload to guarantee simplified codegen; this is equivalent to
///// concat().
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 528,
// FQN="llvm::operator+", NM="_ZN4llvmplERKNS_9StringRefEPKc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmplERKNS_9StringRefEPKc")
////</editor-fold>
//public static /*inline*/ Twine $add_StringRef$C_char$ptr$C(final /*const*/ StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $add_StringRef$C_char$ptr$C(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 532,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Twine$C(final raw_ostream /*&*/ OS, final /*const*/ Twine /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $out_raw_ostream_Twine$C(OS, RHS);
//}
//
///*template <class T, class E> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 279,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", old_line = 289,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_7ErrorOrIT_EET0_R_ZTSNSt9enable_ifIXoosr3std18is_error_code_enumIT0_EE5valuesr3std23is_error_condition_enumIS0_EE5valueEbE4typeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmeqERKNS_7ErrorOrIT_EET0_R_ZTSNSt9enable_ifIXoosr3std18is_error_code_enumIT0_EE5valuesr3std23is_error_condition_enumIS0_EE5valueEbE4typeE")
////</editor-fold>
//public static </*class*/ T, /*class*/ E> /*std::enable_if<Native.$bool(std::is_error_code_enum<E>::value) || Native.$bool(std::is_error_condition_enum<E>::value), boolean>::type*/boolean $eq_ErrorOr$T$C_T1(final /*const*/ ErrorOr<T> /*&*/ Err, E Code) {
//  return /*delegate*/org.llvm.support.impl.ErrorOrLlvmGlobals.
//    $eq_ErrorOr$T$C_T1(Err, Code);
//}
//
//
//// Create wrappers for C Binding types (see CBindingWrapping.h).
////<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 169,
// FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP22LLVMOpaqueMemoryBuffer",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvm6unwrapEP22LLVMOpaqueMemoryBuffer")
////</editor-fold>
//public static /*inline*/ MemoryBuffer /*P*/ unwrap( LLVMOpaqueMemoryBuffer /*P*/ P) {
//  return /*delegate*/org.llvm.support.impl.MemoryBufferLlvmGlobals.
//    unwrap(P);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::wrap">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 169,
// FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_12MemoryBufferE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvm4wrapEPKNS_12MemoryBufferE")
////</editor-fold>
//public static /*inline*/  LLVMOpaqueMemoryBuffer /*P*/ wrap(/*const*/ MemoryBuffer /*P*/ P) {
//  return /*delegate*/org.llvm.support.impl.MemoryBufferLlvmGlobals.
//    wrap(P);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", line = 577,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/BitVector.h", old_line = 575,
// FQN="llvm::capacity_in_bytes", NM="_ZN4llvmL17capacity_in_bytesERKNS_9BitVectorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL17capacity_in_bytesERKNS_9BitVectorE")
////</editor-fold>
//public static /*inline*/ /*size_t*/int capacity_in_bytes(final /*const*/ BitVector /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.BitVectorLlvmGlobals.
//    capacity_in_bytes(X);
//}
//
//
//// Validate an integral value which isn't known to fit within the enum's range
//// is a valid AtomicOrderingCABI.
///*template <typename Int> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isValidAtomicOrderingCABI">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 45,
// FQN="llvm::isValidAtomicOrderingCABI", NM="Tpl__ZN4llvmL25isValidAtomicOrderingCABIET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmL25isValidAtomicOrderingCABIET_")
////</editor-fold>
//public static /*inline*/ </*typename*/ Int> boolean isValidAtomicOrderingCABI(Int I) {
//  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
//    isValidAtomicOrderingCABI(I);
//}
//
//
//// Validate an integral value which isn't known to fit within the enum's range
//// is a valid AtomicOrdering.
///*template <typename Int> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isValidAtomicOrdering">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 75,
// FQN="llvm::isValidAtomicOrdering", NM="Tpl__ZN4llvmL21isValidAtomicOrderingET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=Tpl__ZN4llvmL21isValidAtomicOrderingET_")
////</editor-fold>
//public static /*inline*/ </*typename*/ Int> boolean isValidAtomicOrdering(Int I) {
//  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
//    isValidAtomicOrdering(I);
//}


/// String used by LLVM IR to represent atomic ordering.
//<editor-fold defaultstate="collapsed" desc="llvm::toIRString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 81,
 FQN="llvm::toIRString", NM="_ZN4llvmL10toIRStringENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL10toIRStringENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ /*const*/char$ptr/*char P*/ toIRString(AtomicOrdering ao) {
  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
    toIRString(ao);
}


///// Returns true if ao is stronger than other as defined by the AtomicOrdering
///// lattice, which is based on C++'s definition.
////<editor-fold defaultstate="collapsed" desc="llvm::isStrongerThan">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 90,
 FQN="llvm::isStrongerThan", NM="_ZN4llvmL14isStrongerThanENS_14AtomicOrderingES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL14isStrongerThanENS_14AtomicOrderingES0_")
//</editor-fold>
public static /*inline*/ boolean isStrongerThan(AtomicOrdering ao, AtomicOrdering other) {
  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
    isStrongerThan(ao, other);
}
//
////<editor-fold defaultstate="collapsed" desc="llvm::isAtLeastOrStrongerThan">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 105,
// FQN="llvm::isAtLeastOrStrongerThan", NM="_ZN4llvmL23isAtLeastOrStrongerThanENS_14AtomicOrderingES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL23isAtLeastOrStrongerThanENS_14AtomicOrderingES0_")
////</editor-fold>
//public static /*inline*/ boolean isAtLeastOrStrongerThan(AtomicOrdering ao, 
//                       AtomicOrdering other) {
//  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
//    isAtLeastOrStrongerThan(ao, 
//                       other);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::isStrongerThanUnordered">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 121,
// FQN="llvm::isStrongerThanUnordered", NM="_ZN4llvmL23isStrongerThanUnorderedENS_14AtomicOrderingE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL23isStrongerThanUnorderedENS_14AtomicOrderingE")
////</editor-fold>
//public static /*inline*/ boolean isStrongerThanUnordered(AtomicOrdering ao) {
//  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
//    isStrongerThanUnordered(ao);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::isStrongerThanMonotonic">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 125,
 FQN="llvm::isStrongerThanMonotonic", NM="_ZN4llvmL23isStrongerThanMonotonicENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL23isStrongerThanMonotonicENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ boolean isStrongerThanMonotonic(AtomicOrdering ao) {
  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
    isStrongerThanMonotonic(ao);
}

////<editor-fold defaultstate="collapsed" desc="llvm::isAcquireOrStronger">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 129,
// FQN="llvm::isAcquireOrStronger", NM="_ZN4llvmL19isAcquireOrStrongerENS_14AtomicOrderingE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL19isAcquireOrStrongerENS_14AtomicOrderingE")
////</editor-fold>
//public static /*inline*/ boolean isAcquireOrStronger(AtomicOrdering ao) {
//  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
//    isAcquireOrStronger(ao);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::isReleaseOrStronger">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 133,
// FQN="llvm::isReleaseOrStronger", NM="_ZN4llvmL19isReleaseOrStrongerENS_14AtomicOrderingE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL19isReleaseOrStrongerENS_14AtomicOrderingE")
////</editor-fold>
//public static /*inline*/ boolean isReleaseOrStronger(AtomicOrdering ao) {
//  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
//    isReleaseOrStronger(ao);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::toCABI">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 137,
 FQN="llvm::toCABI", NM="_ZN4llvmL6toCABIENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/APValue.cpp -nm=_ZN4llvmL6toCABIENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ AtomicOrderingCABI toCABI(AtomicOrdering ao) {
  return /*delegate*/org.llvm.support.impl.AtomicOrderingLlvmGlobals.
    toCABI(ao);
}


/// \brief Execute the function specified as a parameter once.
///
/// Typical usage:
/// \code
///   void foo() {...};
///   ...
///   LLVM_DEFINE_ONCE_FLAG(flag);
///   call_once(flag, foo);
/// \endcode
///
/// \param flag Flag used for tracking whether or not this has run.
/// \param F Function to call once.
/*template <typename Function, typename ... Args> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::call_once">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Threading.h", line = 91,
 FQN="llvm::call_once", NM="Tpl__ZN4llvm9call_onceERSt9once_flagOT_DpOT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN4llvm9call_onceERSt9once_flagOT_DpOT0_")
//</editor-fold>
public static <Function> void call_once(final std.once_flag /*&*/ flag, final Function /*&&*/F, Object /*&&*/...$ArgList) {
  /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
    call_once(flag, F, $ArgList);
}
public static void call_once(final std.once_flag /*&*/ flag, final Void2Void /*&&*/F) {
  /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
    call_once_Void2Void(flag, F);
}
public static <T> void call_once(final std.once_flag /*&*/ flag, final Type2VoidPtr<T> /*&&*/F, T/*void P*/Prm) {
  /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
    call_once_Type2VoidPtr(flag, F, Prm);
}

///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Capacity.h", line = 23,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Capacity.h", old_line = 22,
// FQN="llvm::capacity_in_bytes", NM="Tpl__ZN4llvmL17capacity_in_bytesERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN4llvmL17capacity_in_bytesERKT_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> /*size_t*/int capacity_in_bytes(final /*const*/ T /*&*/ x) {
//  return /*delegate*/org.llvm.support.impl.CapacityLlvmGlobals.
//    capacity_in_bytes(x);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 52,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", old_line = 48,
 FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_15MCTargetOptionsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN4llvmeqERKNS_15MCTargetOptionsES2_")
//</editor-fold>
public static /*inline*/ boolean $eq_MCTargetOptions$C(final /*const*/ MCTargetOptions /*&*/ LHS, final /*const*/ MCTargetOptions /*&*/ RHS) {
  return /*delegate*/org.llvm.mc.impl.MCTargetOptionsLlvmGlobals.
    $eq_MCTargetOptions$C(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 70,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", old_line = 66,
 FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_15MCTargetOptionsES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN4llvmneERKNS_15MCTargetOptionsES2_")
//</editor-fold>
public static /*inline*/ boolean $noteq_MCTargetOptions$C(final /*const*/ MCTargetOptions /*&*/ LHS, final /*const*/ MCTargetOptions /*&*/ RHS) {
  return /*delegate*/org.llvm.mc.impl.MCTargetOptionsLlvmGlobals.
    $noteq_MCTargetOptions$C(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 125,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 124,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCExprE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCExpr$C(final raw_ostream /*&*/ OS, final /*const*/ MCExpr /*&*/ E) {
  return /*delegate*/org.llvm.mc.impl.MCExprLlvmGlobals.
    $out_raw_ostream_MCExpr$C(OS, E);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 193,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_9MCOperandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_9MCOperandE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCOperand$C(final raw_ostream /*&*/ OS, final /*const*/ MCOperand /*&*/ MO) {
  return /*delegate*/org.llvm.mc.impl.MCInstLlvmGlobals.
    $out_raw_ostream_MCOperand$C(OS, MO);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 198,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCInstE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCInst$C(final raw_ostream /*&*/ OS, final /*const*/ MCInst /*&*/ MI) {
  return /*delegate*/org.llvm.mc.impl.MCInstLlvmGlobals.
    $out_raw_ostream_MCInst$C(OS, MI);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirectiveName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 44,
 FQN="llvm::MCLOHDirectiveName", NM="_ZN4llvmL18MCLOHDirectiveNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL18MCLOHDirectiveNameEv")
//</editor-fold>
public static /*inline*/ StringRef MCLOHDirectiveName() {
  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
    MCLOHDirectiveName();
}

//<editor-fold defaultstate="collapsed" desc="llvm::isValidMCLOHType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 48,
 FQN="llvm::isValidMCLOHType", NM="_ZN4llvmL16isValidMCLOHTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL16isValidMCLOHTypeEj")
//</editor-fold>
public static /*inline*/ boolean isValidMCLOHType(/*uint*/int Kind) {
  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
    isValidMCLOHType(Kind);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHNameToId">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 52,
 FQN="llvm::MCLOHNameToId", NM="_ZN4llvmL13MCLOHNameToIdENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL13MCLOHNameToIdENS_9StringRefE")
//</editor-fold>
public static /*inline*/ int MCLOHNameToId(StringRef Name) {
  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
    MCLOHNameToId(Name);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHIdToName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 66,
 FQN="llvm::MCLOHIdToName", NM="_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE")
//</editor-fold>
public static /*inline*/ StringRef MCLOHIdToName(/*MCLOHType*//*uint*/int Kind) {
  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
    MCLOHIdToName(Kind);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHIdToNbArgs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 81,
 FQN="llvm::MCLOHIdToNbArgs", NM="_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE")
//</editor-fold>
public static /*inline*/ int MCLOHIdToNbArgs(/*MCLOHType*//*uint*/int Kind) {
  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
    MCLOHIdToNbArgs(Kind);
}


// A container class for subtarget features.
// This is convenient because std::bitset does not have a constructor
// with an initializer list of set bits.
//<editor-fold defaultstate="collapsed" desc="llvm::MAX_SUBTARGET_FEATURES">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/SubtargetFeature.h", line = 34,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SubtargetFeature.h", old_line = 33,
 FQN="llvm::MAX_SUBTARGET_FEATURES", NM="_ZN4llvmL22MAX_SUBTARGET_FEATURESE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL22MAX_SUBTARGET_FEATURESE")
//</editor-fold>
public static /*const*//*uint*/int MAX_SUBTARGET_FEATURES = 128;
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 415,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_8MCSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_8MCSymbolE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCSymbol$C(final raw_ostream /*&*/ OS, final /*const*/ MCSymbol /*&*/ Sym) {
  return /*delegate*/org.llvm.mc.impl.MCSymbolLlvmGlobals.
    $out_raw_ostream_MCSymbol$C(OS, Sym);
}


  /// These are helper functions used to produce formatted output.  They use
  /// template type deduction to construct the appropriate instance of the
  /// format_object class to simplify their construction.
  ///
  /// This is typically used like:
  /// \code
  ///   OS << format("%0.4f", myfloat) << '\n';
  /// \endcode
  /*template <typename ... Ts> TEMPLATE*/
  /// These are helper functions used to produce formatted output.  They use
  /// template type deduction to construct the appropriate instance of the
  /// format_object class to simplify their construction.
  ///
  /// This is typically used like:
  /// \code
  ///   OS << format("%0.4f", myfloat) << '\n';
  /// \endcode
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::format">
  @Converted(kind = Converted.Kind.BODY_DELEGATE,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 111,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", old_line = 110,
   FQN="llvm::format", NM="Tpl__ZN4llvm6formatEPKcDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=Tpl__ZN4llvm6formatEPKcDpRKT_")
  //</editor-fold>
  public static /*inline*/ format_object format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ Object /*&*/ ... Vals) {
    return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
      format(Fmt, Vals);
  }


/// left_justify - append spaces after string so total output is
/// \p Width characters.  If \p Str is larger that \p Width, full string
/// is written with no padding.
//<editor-fold defaultstate="collapsed" desc="llvm::left_justify">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 130,
 FQN="llvm::left_justify", NM="_ZN4llvm12left_justifyENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvm12left_justifyENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ FormattedString left_justify(StringRef Str, /*uint*/int Width) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    left_justify(Str, Width);
}


/// right_justify - add spaces before string so total output is
/// \p Width characters.  If \p Str is larger that \p Width, full string
/// is written with no padding.
//<editor-fold defaultstate="collapsed" desc="llvm::right_justify">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 137,
 FQN="llvm::right_justify", NM="_ZN4llvm13right_justifyENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvm13right_justifyENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ FormattedString right_justify(StringRef Str, /*uint*/int Width) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    right_justify(Str, Width);
}


/// format_hex - Output \p N as a fixed width hexadecimal. If number will not
/// fit in width, full number is still printed.  Examples:
///   OS << format_hex(255, 4)              => 0xff
///   OS << format_hex(255, 4, true)        => 0xFF
///   OS << format_hex(255, 6)              => 0x00ff
///   OS << format_hex(255, 2)              => 0xff
//<editor-fold defaultstate="collapsed" desc="llvm::format_hex">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 164,
 FQN="llvm::format_hex", NM="_ZN4llvm10format_hexEyjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvm10format_hexEyjb")
//</editor-fold>
public static /*inline*/ FormattedNumber format_hex(long/*uint64_t*/ N, /*uint*/int Width) {
  return format_hex(N, Width, 
          false);
}
public static /*inline*/ FormattedNumber format_hex(long/*uint64_t*/ N, /*uint*/int Width, 
          boolean Upper/*= false*/) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    format_hex(N, Width, 
          Upper);
}


/// format_hex_no_prefix - Output \p N as a fixed width hexadecimal. Does not
/// prepend '0x' to the outputted string.  If number will not fit in width,
/// full number is still printed.  Examples:
///   OS << format_hex_no_prefix(255, 2)              => ff
///   OS << format_hex_no_prefix(255, 2, true)        => FF
///   OS << format_hex_no_prefix(255, 4)              => 00ff
///   OS << format_hex_no_prefix(255, 1)              => ff
//<editor-fold defaultstate="collapsed" desc="llvm::format_hex_no_prefix">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 177,
 FQN="llvm::format_hex_no_prefix", NM="_ZN4llvm20format_hex_no_prefixEyjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvm20format_hex_no_prefixEyjb")
//</editor-fold>
public static /*inline*/ FormattedNumber format_hex_no_prefix(long/*uint64_t*/ N, /*uint*/int Width) {
  return format_hex_no_prefix(N, Width, 
                    false);
}
public static /*inline*/ FormattedNumber format_hex_no_prefix(long/*uint64_t*/ N, /*uint*/int Width, 
                    boolean Upper/*= false*/) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    format_hex_no_prefix(N, Width, 
                    Upper);
}


/// format_decimal - Output \p N as a right justified, fixed-width decimal. If
/// number will not fit in width, full number is still printed.  Examples:
///   OS << format_decimal(0, 5)     => "    0"
///   OS << format_decimal(255, 5)   => "  255"
///   OS << format_decimal(-1, 3)    => " -1"
///   OS << format_decimal(12345, 3) => "12345"
//<editor-fold defaultstate="collapsed" desc="llvm::format_decimal">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 189,
 FQN="llvm::format_decimal", NM="_ZN4llvm14format_decimalExj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvm14format_decimalExj")
//</editor-fold>
public static /*inline*/ FormattedNumber format_decimal(long/*int64_t*/ N, /*uint*/int Width) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    format_decimal(N, Width);
}


///// \brief Create an MCAsmParser instance.
//// namespace llvm
//
///// \brief Create an MCAsmParser instance.
////<editor-fold defaultstate="collapsed" desc="llvm::createMCAsmParser">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp", line = 5214,
// old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", old_line = 214,
// FQN="llvm::createMCAsmParser", NM="_ZN4llvm17createMCAsmParserERNS_9SourceMgrERNS_9MCContextERNS_10MCStreamerERKNS_9MCAsmInfoE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvm17createMCAsmParserERNS_9SourceMgrERNS_9MCContextERNS_10MCStreamerERKNS_9MCAsmInfoE")
////</editor-fold>
//public static MCAsmParser /*P*/ createMCAsmParser(final SourceMgr /*&*/ SM, final MCContext /*&*/ C, 
//                 final MCStreamer /*&*/ Out, final /*const*/ MCAsmInfo /*&*/ MAI) {
//  return /*delegate*/org.llvm.mc.mcparser.impl.AsmParserLlvmGlobals.
//    createMCAsmParser(SM, C, 
//                 Out, MAI);
//}
//
//
////===----------------------------------------------------------------------===//
//// Debugging Support
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCParsedAsmOperand.h", line = 91,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_18MCParsedAsmOperandE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_18MCParsedAsmOperandE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCParsedAsmOperand$C(final raw_ostream /*&*/ OS, final /*const*/ MCParsedAsmOperand /*&*/ MO) {
//  return /*delegate*/org.llvm.mc.mcparser.impl.MCParsedAsmOperandLlvmGlobals.
//    $out_raw_ostream_MCParsedAsmOperand$C(OS, MO);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::AsmRewritePrecedence">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCTargetAsmParser.h", line = 47,
// old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetAsmParser.h", old_line = 46,
// FQN="llvm::AsmRewritePrecedence", NM="_ZN4llvmL20AsmRewritePrecedenceE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/AsmParser.cpp -nm=_ZN4llvmL20AsmRewritePrecedenceE")
////</editor-fold>
//public static /*const*//*char*/byte AsmRewritePrecedence[/*13*/] = new$char(13, 
//  0,  // AOK_Delete
//  2,  // AOK_Align
//  2,  // AOK_EVEN
//  2,  // AOK_DotOperator
//  2,  // AOK_Emit
//  4,  // AOK_Imm
//  4,  // AOK_ImmPrefix
//  3,  // AOK_Input
//  3,  // AOK_Output
//  5,  // AOK_SizeDirective
//  1,  // AOK_Label
//  5,  // AOK_EndOfStatement
//  2 // AOK_Skip
//);
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 171,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamENS_17BranchProbabilityE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamENS_17BranchProbabilityE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_BranchProbability(final raw_ostream /*&*/ OS, BranchProbability Prob) {
//  return /*delegate*/org.llvm.support.impl.BranchProbabilityLlvmGlobals.
//    $out_raw_ostream_BranchProbability(OS, Prob);
//}

/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::WriteGraph">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 311,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", old_line = 310,
 FQN="llvm::WriteGraph", NM="Tpl__ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE")
//</editor-fold>
public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(final raw_ostream /*&*/ O, final /*const*/ GraphType /*&*/ G) {
  return WriteGraph(O, G, 
          false, 
          new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(final raw_ostream /*&*/ O, final /*const*/ GraphType /*&*/ G, 
          boolean ShortNames/*= false*/) {
  return WriteGraph(O, G, 
          ShortNames, 
          new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(final raw_ostream /*&*/ O, final /*const*/ GraphType /*&*/ G, 
          boolean ShortNames/*= false*/, 
          final /*const*/ Twine /*&*/ Title/*= ""*/) {
  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
    WriteGraph(O, G, 
          ShortNames, 
          Title);
}

/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::WriteGraph">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 326,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", old_line = 325,
 FQN="llvm::WriteGraph", NM="Tpl__ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_")
//</editor-fold>
public static </*typename*/ GraphType> std.string WriteGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name) {
  return WriteGraph(G, Name, 
          false, new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> std.string WriteGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
          boolean ShortNames/*= false*/) {
  return WriteGraph(G, Name, 
          ShortNames, new Twine(/*KEEP_STR*/$EMPTY));
}
public static </*typename*/ GraphType> std.string WriteGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
          boolean ShortNames/*= false*/, final /*const*/ Twine /*&*/ Title/*= ""*/) {
  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
    WriteGraph(G, Name, 
          ShortNames, Title);
}


/// ViewGraph - Emit a dot graph, run 'dot', run gv on the postscript file,
/// then cleanup.  For use from the debugger.
///
/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ViewGraph">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 350,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", old_line = 349,
 FQN="llvm::ViewGraph", NM="Tpl__ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE")
//</editor-fold>
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name) {
  ViewGraph(G, Name, 
         false, new Twine(/*KEEP_STR*/$EMPTY), 
         GraphProgram.Name.DOT);
}
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
         boolean ShortNames/*= false*/) {
  ViewGraph(G, Name, 
         ShortNames, new Twine(/*KEEP_STR*/$EMPTY), 
         GraphProgram.Name.DOT);
}
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
         boolean ShortNames/*= false*/, final /*const*/ Twine /*&*/ Title/*= ""*/) {
  ViewGraph(G, Name, 
         ShortNames, Title, 
         GraphProgram.Name.DOT);
}
public static </*typename*/ GraphType> void ViewGraph(final /*const*/ GraphType /*&*/ G, final /*const*/ Twine /*&*/ Name, 
         boolean ShortNames/*= false*/, final /*const*/ Twine /*&*/ Title/*= ""*/, 
         GraphProgram.Name Program/*= GraphProgram::DOT*/) {
  /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
    ViewGraph(G, Name, 
         ShortNames, Title, 
         Program);
}


///// object_creator - Helper method for ManagedStatic.
///*template <class C> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::object_creator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 25,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", old_line = 24,
// FQN="llvm::object_creator", NM="Tpl__ZN4llvm14object_creatorEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm14object_creatorEv")
////</editor-fold>
//public static </*class*/ C> Object/*void P*/ object_creator()/* __attribute__((visibility("hidden")))*/ {
//  return /*delegate*/org.llvm.support.impl.ManagedStaticLlvmGlobals.
//    object_creator();
//}
//

/// Helper to compute and return lower 64 bits of the given string's MD5 hash.
//<editor-fold defaultstate="collapsed" desc="llvm::MD5Hash">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MD5.h", line = 70,
 FQN="llvm::MD5Hash", NM="_ZN4llvm7MD5HashENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm7MD5HashENS_9StringRefE")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ MD5Hash(StringRef Str) {
  return /*delegate*/org.llvm.support.impl.MD5LlvmGlobals.
    MD5Hash(Str);
}


//// handleErrors needs to be able to set the Checked flag.
///*template <typename ... HandlerTs> TEMPLATE*/


/// Make a Error instance representing failure using the given error info
/// type.
/*template <typename ErrT, typename ... ArgTs> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::make_error">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 282,
 FQN="llvm::make_error", NM="Tpl__ZN4llvm10make_errorEDpOT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm10make_errorEDpOT0_")
//</editor-fold>
public static </*typename*/ ErrT, /*typename*/ /*...*/ ArgTs> Error make_error(ArgTs .../*&&*/Args) {
  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
    make_error(Args);
}


///// Concatenate errors. The resulting Error is unchecked, and contains the
///// ErrorInfo(s), if any, contained in E1, followed by the
///// ErrorInfo(s), if any, contained in E2.
////<editor-fold defaultstate="collapsed" desc="llvm::joinErrors">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 372,
// FQN="llvm::joinErrors", NM="_ZN4llvm10joinErrorsENS_5ErrorES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm10joinErrorsENS_5ErrorES0_")
////</editor-fold>
//public static /*inline*/ Error joinErrors(Error E1, Error E2) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    joinErrors(E1, E2);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::handleErrorImpl">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 477,
// FQN="llvm::handleErrorImpl", NM="_ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EE")
////</editor-fold>
//public static /*inline*/ Error handleErrorImpl(std.unique_ptr<ErrorInfoBase> Payload) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    handleErrorImpl(Payload);
//}
//
///*template <typename HandlerT, typename ... HandlerTs> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::handleErrorImpl">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 482,
// FQN="llvm::handleErrorImpl", NM="Tpl__ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EEOT_DpOT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm15handleErrorImplESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS1_EEOT_DpOT0_")
////</editor-fold>
//public static </*typename*/ HandlerT, /*typename*/ /*...*/ HandlerTs> Error handleErrorImpl$T(std.unique_ptr<ErrorInfoBase> Payload, 
//                 final HandlerT /*&&*/Handler, HandlerTs /*&&*/Handlers...) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    handleErrorImpl$T(Payload, 
//                 Handler, Handlers);
//}


/// Behaves the same as handleErrors, except that it requires that all
/// errors be handled by the given handlers. If any unhandled error remains
/// after the handlers have run, abort() will be called.
/*template <typename ... HandlerTs> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::handleAllErrors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 521,
 FQN="llvm::handleAllErrors", NM="Tpl__ZN4llvm15handleAllErrorsENS_5ErrorEDpOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm15handleAllErrorsENS_5ErrorEDpOT_")
//</editor-fold>
public static </*typename*/ /*...*/ HandlerTs> void handleAllErrors$T(Error E, HandlerTs /*&&*/...Handlers) {
  throw new UnsupportedOperationException("EmptyBody");
  ///*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.handleAllErrors$T(E, Handlers);
}

///// Check that E is a non-error, then drop it.
////<editor-fold defaultstate="collapsed" desc="llvm::handleAllErrors">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 528,
// FQN="llvm::handleAllErrors", NM="_ZN4llvm15handleAllErrorsENS_5ErrorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm15handleAllErrorsENS_5ErrorE")
////</editor-fold>
//public static /*inline*/ void handleAllErrors(Error E) {
//  /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    handleAllErrors(E);
//}
//
//
///// Write all error messages (if any) in E to a string. The newline character
///// is used to separate error messages.
////<editor-fold defaultstate="collapsed" desc="llvm::toString">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 544,
// FQN="llvm::toString", NM="_ZN4llvm8toStringENS_5ErrorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm8toStringENS_5ErrorE")
////</editor-fold>
//public static /*inline*/ std.string __toString(Error E) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    __toString(E);
//}
//
//
///// Consume a Error without doing anything. This method should be used
///// only where an error can be considered a reasonable and expected return
///// value.
/////
///// Uses of this method are potentially indicative of design problems: If it's
///// legitimate to do nothing while processing an "error", the error-producer
///// might be more clearly refactored to return an Optional<T>.
////<editor-fold defaultstate="collapsed" desc="llvm::consumeError">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 559,
// FQN="llvm::consumeError", NM="_ZN4llvm12consumeErrorENS_5ErrorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN4llvm12consumeErrorENS_5ErrorE")
////</editor-fold>
//public static /*inline*/ void consumeError(Error Err) {
//  /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    consumeError(Err);
//}
//
//
///// Convert an ErrorOr<T> to an Expected<T>.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::errorOrToExpected">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 865,
// FQN="llvm::errorOrToExpected", NM="Tpl__ZN4llvm17errorOrToExpectedEONS_7ErrorOrIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm17errorOrToExpectedEONS_7ErrorOrIT_EE")
////</editor-fold>
//public static </*typename*/ T> Expected<T> errorOrToExpected(final ErrorOr<T> /*&&*/EO) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    errorOrToExpected(EO);
//}
//
//
///// Convert an Expected<T> to an ErrorOr<T>.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::expectedToErrorOr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 872,
// FQN="llvm::expectedToErrorOr", NM="Tpl__ZN4llvm17expectedToErrorOrEONS_8ExpectedIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=Tpl__ZN4llvm17expectedToErrorOrEONS_8ExpectedIT_EE")
////</editor-fold>
//public static </*typename*/ T> ErrorOr<T> expectedToErrorOr(final Expected<T> /*&&*/E) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    expectedToErrorOr(E);
//}
//
//
///**
//* Convert the first UTF8 sequence in the given source buffer to a UTF32
//* code point.
//*
//* \param [in,out] source A pointer to the source buffer. If the conversion
//* succeeds, this pointer will be updated to point to the byte just past the
//* end of the converted sequence.
//* \param sourceEnd A pointer just past the end of the source buffer.
//* \param [out] target The converted code
//* \param flags Whether the conversion is strict or lenient.
//*
//* \returns conversionOK on success
//*
//* \sa ConvertUTF8toUTF32
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::convertUTF8Sequence">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", line = 249,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", old_line = 227,
// FQN="llvm::convertUTF8Sequence", NM="_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags")
////</editor-fold>
//public static /*inline*/ ConversionResult convertUTF8Sequence(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ source, 
//                   /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
//                   uint$ptr/*UTF32 P*/ target, 
//                   ConversionFlags flags) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFLlvmGlobals.
//    convertUTF8Sequence(source, 
//                   sourceEnd, 
//                   target, 
//                   flags);
//}
//
//
//// Provide global constructors that automatically figure out correct types...
////
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 201,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 200,
// FQN="llvm::df_begin", NM="Tpl__ZN4llvm8df_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm8df_beginERKT_")
////</editor-fold>
//public static </*class*/ T> df_iterator<T> df_begin(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_begin(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 206,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 205,
// FQN="llvm::df_end", NM="Tpl__ZN4llvm6df_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm6df_endERKT_")
////</editor-fold>
//public static </*class*/ T> df_iterator<T> df_end(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_end(G);
//}
//
//
//// Provide an accessor method to use them in range-based patterns.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::depth_first">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 212,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 211,
// FQN="llvm::depth_first", NM="Tpl__ZN4llvm11depth_firstERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm11depth_firstERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range< std.iterator<std.forward_iterator_tag,  GT.NodeType, int>.pointer> depth_first(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    depth_first(G);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 224,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 223,
// FQN="llvm::df_ext_begin", NM="Tpl__ZN4llvm12df_ext_beginERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm12df_ext_beginERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> df_ext_iterator<T, SetTy> df_ext_begin(final /*const*/ T /*&*/ G, final SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_ext_begin(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 229,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 228,
// FQN="llvm::df_ext_end", NM="Tpl__ZN4llvm10df_ext_endERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm10df_ext_endERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> df_ext_iterator<T, SetTy> df_ext_end(final /*const*/ T /*&*/ G, final SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_ext_end(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::depth_first_ext">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 234,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 233,
// FQN="llvm::depth_first_ext", NM="Tpl__ZN4llvm15depth_first_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm15depth_first_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> iterator_range<df_ext_iterator<T, SetTy> > depth_first_ext(final /*const*/ T /*&*/ G, 
//               final SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    depth_first_ext(G, 
//               S);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 249,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 248,
// FQN="llvm::idf_begin", NM="Tpl__ZN4llvm9idf_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm9idf_beginERKT_")
////</editor-fold>
//public static </*class*/ T> idf_iterator<T> idf_begin(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_begin(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 254,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 253,
// FQN="llvm::idf_end", NM="Tpl__ZN4llvm7idf_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm7idf_endERKT_")
////</editor-fold>
//public static </*class*/ T> idf_iterator<T> idf_end(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_end(G);
//}
//
//
//// Provide an accessor method to use them in range-based patterns.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_depth_first">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 260,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 259,
// FQN="llvm::inverse_depth_first", NM="Tpl__ZN4llvm19inverse_depth_firstERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm19inverse_depth_firstERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range<idf_iterator<T> > inverse_depth_first(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    inverse_depth_first(G);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 274,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 273,
// FQN="llvm::idf_ext_begin", NM="Tpl__ZN4llvm13idf_ext_beginERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm13idf_ext_beginERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> idf_ext_iterator<T, SetTy> idf_ext_begin(final /*const*/ T /*&*/ G, final SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_ext_begin(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 279,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 278,
// FQN="llvm::idf_ext_end", NM="Tpl__ZN4llvm11idf_ext_endERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm11idf_ext_endERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> idf_ext_iterator<T, SetTy> idf_ext_end(final /*const*/ T /*&*/ G, final SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_ext_end(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_depth_first_ext">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 284,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", old_line = 283,
// FQN="llvm::inverse_depth_first_ext", NM="Tpl__ZN4llvm23inverse_depth_first_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN4llvm23inverse_depth_first_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> iterator_range<idf_ext_iterator<T, SetTy> > inverse_depth_first_ext(final /*const*/ T /*&*/ G, 
//                       final SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    inverse_depth_first_ext(G, 
//                       S);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator&">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 564,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 569,
// FQN="llvm::operator&", NM="_ZN4llvmanERKNS_14SmallBitVectorES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvmanERKNS_14SmallBitVectorES2_")
////</editor-fold>
//public static /*inline*/ SmallBitVector $bitand_SmallBitVector$C(final /*const*/ SmallBitVector /*&*/ LHS, final /*const*/ SmallBitVector /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.SmallBitVectorLlvmGlobals.
//    $bitand_SmallBitVector$C(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator|">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 571,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 576,
// FQN="llvm::operator|", NM="_ZN4llvmorERKNS_14SmallBitVectorES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvmorERKNS_14SmallBitVectorES2_")
////</editor-fold>
//public static /*inline*/ SmallBitVector $bitor_SmallBitVector$C(final /*const*/ SmallBitVector /*&*/ LHS, final /*const*/ SmallBitVector /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.SmallBitVectorLlvmGlobals.
//    $bitor_SmallBitVector$C(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator^">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 578,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", old_line = 583,
// FQN="llvm::operator^", NM="_ZN4llvmeoERKNS_14SmallBitVectorES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvmeoERKNS_14SmallBitVectorES2_")
////</editor-fold>
//public static /*inline*/ SmallBitVector $bitxor_SmallBitVector$C(final /*const*/ SmallBitVector /*&*/ LHS, final /*const*/ SmallBitVector /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.SmallBitVectorLlvmGlobals.
//    $bitxor_SmallBitVector$C(LHS, RHS);
//}
//
//
///**
//* Convert an UTF8 StringRef to UTF8, UTF16, or UTF32 depending on
//* WideCharWidth. The converted data is written to ResultPtr, which needs to
//* point to at least WideCharWidth * (Source.Size() + 1) bytes. On success,
//* ResultPtr will point one after the end of the copied string. On failure,
//* ResultPtr will not be changed, and ErrorPtr will be set to the location of
//* the first character which could not be converted.
//* \return true on success.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::ConvertUTF8toWide">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 20,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", old_line = 17,
// FQN="llvm::ConvertUTF8toWide", NM="_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh")
////</editor-fold>
//public static boolean ConvertUTF8toWide(/*uint*/int WideCharWidth, StringRef Source, 
//                 final type$ref<char$ptr>/*char P&*/ ResultPtr, final /*const*/type$ref<char$ptr>/*UTF8 P&*/ ErrorPtr) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    ConvertUTF8toWide(WideCharWidth, Source, 
//                 ResultPtr, ErrorPtr);
//}
//
//
///**
//* Converts a UTF-8 StringRef to a std::wstring.
//* \return true on success.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::ConvertUTF8toWide">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 202,
// FQN="llvm::ConvertUTF8toWide", NM="_ZN4llvm17ConvertUTF8toWideENS_9StringRefERSbIwSt11char_traitsIwESaIwEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm17ConvertUTF8toWideENS_9StringRefERSbIwSt11char_traitsIwESaIwEE")
////</editor-fold>
//public static boolean ConvertUTF8toWide(StringRef Source, final basic_string</*wchar_t*/char> /*&*/ Result) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    ConvertUTF8toWide(Source, Result);
//}
//
//
///**
//* Converts a UTF-8 C-string to a std::wstring.
//* \return true on success.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::ConvertUTF8toWide">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 206,
// FQN="llvm::ConvertUTF8toWide", NM="_ZN4llvm17ConvertUTF8toWideEPKcRSbIwSt11char_traitsIwESaIwEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm17ConvertUTF8toWideEPKcRSbIwSt11char_traitsIwESaIwEE")
////</editor-fold>
//public static boolean ConvertUTF8toWide(/*const*/char$ptr/*char P*/ Source, final basic_string</*wchar_t*/char> /*&*/ Result) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    ConvertUTF8toWide(Source, Result);
//}
//
//
///**
//* Converts a std::wstring to a UTF-8 encoded std::string.
//* \return true on success.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::convertWideToUTF8">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 214,
// FQN="llvm::convertWideToUTF8", NM="_ZN4llvm17convertWideToUTF8ERKSbIwSt11char_traitsIwESaIwEERSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm17convertWideToUTF8ERKSbIwSt11char_traitsIwESaIwEERSs")
////</editor-fold>
//public static boolean convertWideToUTF8(final /*const*/ basic_string</*wchar_t*/char> /*&*/ Source, final std.string/*&*/ Result) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    convertWideToUTF8(Source, Result);
//}
//
//
///**
//* Convert an Unicode code point to UTF8 sequence.
//*
//* \param Source a Unicode code point.
//* \param [in,out] ResultPtr pointer to the output buffer, needs to be at least
//* \c UNI_MAX_UTF8_BYTES_PER_CODE_POINT bytes.  On success \c ResultPtr is
//* updated one past end of the converted sequence.
//*
//* \returns true on success.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::ConvertCodePointToUTF8">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 66,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", old_line = 63,
// FQN="llvm::ConvertCodePointToUTF8", NM="_ZN4llvm22ConvertCodePointToUTF8EjRPc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm22ConvertCodePointToUTF8EjRPc")
////</editor-fold>
//public static boolean ConvertCodePointToUTF8(/*uint*/int Source, final type$ref<char$ptr>/*char P&*/ ResultPtr) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    ConvertCodePointToUTF8(Source, ResultPtr);
//}
//
//
///**
//* Returns true if a blob of text starts with a UTF-16 big or little endian byte
//* order mark.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::hasUTF16ByteOrderMark">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 81,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", old_line = 78,
// FQN="llvm::hasUTF16ByteOrderMark", NM="_ZN4llvm21hasUTF16ByteOrderMarkENS_8ArrayRefIcEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm21hasUTF16ByteOrderMarkENS_8ArrayRefIcEE")
////</editor-fold>
//public static boolean hasUTF16ByteOrderMark(ArrayRefChar S) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    hasUTF16ByteOrderMark(S);
//}
//
//
///**
//* Converts a stream of raw bytes assumed to be UTF16 into a UTF8 std::string.
//*
//* \param [in] SrcBytes A buffer of what is assumed to be UTF-16 encoded text.
//* \param [out] Out Converted UTF-8 is stored here on success.
//* \returns true on success
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::convertUTF16ToUTF8String">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 87,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", old_line = 84,
// FQN="llvm::convertUTF16ToUTF8String", NM="_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs")
////</editor-fold>
//public static boolean convertUTF16ToUTF8String_ArrayRefChar_string(ArrayRefChar SrcBytes, final std.string/*&*/ Out) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    convertUTF16ToUTF8String_ArrayRefChar_string(SrcBytes, Out);
//}
//
//
///**
//* Converts a UTF16 string into a UTF8 std::string.
//*
//* \param [in] Src A buffer of UTF-16 encoded text.
//* \param [out] Out Converted UTF-8 is stored here on success.
//* \returns true on success
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::convertUTF16ToUTF8String">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 136,
// FQN="llvm::convertUTF16ToUTF8String", NM="_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefItEERSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefItEERSs")
////</editor-fold>
//public static boolean convertUTF16ToUTF8String_ArrayRefChar_string(ArrayRefChar Src, final std.string/*&*/ Out) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    convertUTF16ToUTF8String_ArrayRefChar_string(Src, Out);
//}
//
//
///**
//* Converts a UTF-8 string into a UTF-16 string with native endianness.
//*
//* \returns true on success
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::convertUTF8ToUTF16String">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 143,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", old_line = 133,
// FQN="llvm::convertUTF8ToUTF16String", NM="_ZN4llvm24convertUTF8ToUTF16StringENS_9StringRefERNS_15SmallVectorImplItEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm24convertUTF8ToUTF16StringENS_9StringRefERNS_15SmallVectorImplItEE")
////</editor-fold>
//public static boolean convertUTF8ToUTF16String(StringRef SrcUTF8, 
//                        final SmallVectorImplChar /*&*/ DstUTF16) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    convertUTF8ToUTF16String(SrcUTF8, 
//                        DstUTF16);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::getDataFileStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/DataStream.cpp", line = 77,
// FQN="llvm::getDataFileStreamer", NM="_ZN4llvm19getDataFileStreamerERKSsPSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/DataStream.cpp -nm=_ZN4llvm19getDataFileStreamerERKSsPSs")
////</editor-fold>
//public static std.unique_ptr<DataStreamer> getDataFileStreamer(final /*const*/std.string/*&*/ Filename, std.string/*P*/ StrError) {
//  return /*delegate*/org.llvm.support.impl.DataStreamLlvmGlobals.
//    getDataFileStreamer(Filename, StrError);
//}
//
//
///// isCurrentDebugType - Return true if the specified string is the debug type
///// specified on the command line, or if none was specified on the command line
///// with the -debug-only=X option.
/////
//
///// Return true if the specified string is the debug type
///// specified on the command line, or if none was specified on the command line
///// with the -debug-only=X option.
////<editor-fold defaultstate="collapsed" desc="llvm::isCurrentDebugType">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 49,
// FQN="llvm::isCurrentDebugType", NM="_ZN4llvm18isCurrentDebugTypeEPKc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm18isCurrentDebugTypeEPKc")
////</editor-fold>
//public static boolean isCurrentDebugType(/*const*/char$ptr/*char P*/ DebugType) {
//  return /*delegate*/org.llvm.support.impl.DebugLlvmGlobals.
//    isCurrentDebugType(DebugType);
//}
//
//
///// setCurrentDebugType - Set the current debug type, as if the -debug-only=X
///// option were specified.  Note that DebugFlag also needs to be set to true for
///// debug output to be produced.
/////
//
///// Set the current debug type, as if the -debug-only=X
///// option were specified.  Note that DebugFlag also needs to be set to true for
///// debug output to be produced.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::setCurrentDebugType">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 65,
// FQN="llvm::setCurrentDebugType", NM="_ZN4llvm19setCurrentDebugTypeEPKc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm19setCurrentDebugTypeEPKc")
////</editor-fold>
//public static void setCurrentDebugType(/*const*/char$ptr/*char P*/ Type) {
//  /*delegate*/org.llvm.support.impl.DebugLlvmGlobals.
//    setCurrentDebugType(Type);
//}


/// dbgs() - This returns a reference to a raw_ostream for debugging
/// messages.  If debugging is disabled it returns errs().  Use it
/// like: dbgs() << "foo" << "bar";

/// dbgs - Return a circular-buffered debug stream.
//<editor-fold defaultstate="collapsed" desc="llvm::dbgs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 125,
 FQN="llvm::dbgs", NM="_ZN4llvm4dbgsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm4dbgsEv")
//</editor-fold>
public static raw_ostream /*&*/ dbgs() {
  return /*delegate*/org.llvm.support.impl.DebugLlvmGlobals.
    dbgs();
}

///// Exported boolean set by the -debug option.
////<editor-fold defaultstate="collapsed" desc="llvm::DebugFlag">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 42,
// FQN="llvm::DebugFlag", NM="_ZN4llvm9DebugFlagE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm9DebugFlagE")
////</editor-fold>
//public static boolean DebugFlag = false;
//
///// EnableDebugBuffering - Turn on signal handler installation.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::EnableDebugBuffering">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 158,
// FQN="llvm::EnableDebugBuffering", NM="_ZN4llvm20EnableDebugBufferingE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm20EnableDebugBufferingE")
////</editor-fold>
//public static boolean EnableDebugBuffering = false;
//
///// We provide a function which tries to compute the (demangled) name of a type
///// statically.
/////
///// This routine may fail on some platforms or for particularly unusual types.
///// Do not use it for anything other than logging and debugging aids. It isn't
///// portable or dependendable in any real sense.
/////
///// The returned StringRef will point into a static storage duration string.
///// However, it may not be null terminated and may be some strangely aligned
///// inner substring of a larger string.
///*template <typename DesiredTypeName> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::getTypeName">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TypeName.h", line = 28,
// FQN="llvm::getTypeName", NM="Tpl__ZN4llvm11getTypeNameEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm11getTypeNameEv")
////</editor-fold>
//public static /*inline*/ </*typename*/ DesiredTypeName> StringRef getTypeName() {
//  return /*delegate*/org.llvm.support.impl.TypeNameLlvmGlobals.
//    getTypeName();
//}

/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 157,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 155,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE")
//</editor-fold>
public static </*class*/ NodeT> raw_ostream /*&*/ $out_raw_ostream_DomTreeNodeBase$NodeT$C$P(final raw_ostream /*&*/ o, /*const*/ DomTreeNodeBase<NodeT> /*P*/ Node) {
  return /*delegate*/org.llvm.support.impl.GenericDomTreeLlvmGlobals.
    $out_raw_ostream_DomTreeNodeBase$NodeT$C$P(o, Node);
}

/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PrintDomTree">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 169,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 167,
 FQN="llvm::PrintDomTree", NM="Tpl__ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj")
//</editor-fold>
public static </*class*/ NodeT> void PrintDomTree(/*const*/ DomTreeNodeBase<NodeT> /*P*/ N, final raw_ostream /*&*/ o, 
            /*uint*/int Lev) {
  /*delegate*/org.llvm.support.impl.GenericDomTreeLlvmGlobals.
    PrintDomTree(N, o, 
            Lev);
}


// The calculate routine is provided in a separate header but referenced here.
/*template <class FuncT, class N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Calculate">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", line = 150,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 149,
 FQN="llvm::Calculate", NM="Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm9CalculateERNS_17DominatorTreeBaseINS_11GraphTraitsIT0_E8NodeTypeEEERT_")
//</editor-fold>
public static </*class*/ FuncT, /*class*/ NodeT> void Calculate(GraphTraits<FuncT, ?, ?> GTraits$FuncT, GraphTraits GraphTraits_NodeT, GraphTraits GraphTraits_InverseNodeT,
        final DominatorTreeBase<NodeT> /*&*/ DT, 
         final FuncT /*&*/ F) {
  /*delegate*/org.llvm.support.impl.GenericDomTreeConstructionLlvmGlobals.
    Calculate(GTraits$FuncT, GraphTraits_NodeT, GraphTraits_InverseNodeT, DT, 
         F);
}

/*template <class GraphT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Eval">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 630,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 105,
 FQN="llvm::Eval", NM="Tpl__ZN4llvm4EvalERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm4EvalERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeT>  NodeT /*P*/ Eval(GraphTraits GraphTraits_NodeT, final DominatorTreeBase< NodeT> /*&*/ DT, 
     NodeT /*P*/ V, /*uint*/int LastLinked) {
  return /*delegate*/org.llvm.support.impl.GenericDomTreeConstructionLlvmGlobals.
                  Eval(GraphTraits_NodeT, DT, V, LastLinked);
}

/*template <class GraphT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DFSPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 635,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTreeConstruction.h", old_line = 32,
 FQN="llvm::DFSPass", NM="Tpl__ZN4llvm7DFSPassERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=Tpl__ZN4llvm7DFSPassERNS_17DominatorTreeBaseINT_8NodeTypeEEEPS2_j")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeT> /*uint*/int DFSPass(GraphTraits<?, NodeT, ? extends NodeT> GraphTraits_NodeT, final DominatorTreeBase< NodeT> /*&*/ DT, 
        NodeT /*P*/ V, /*uint*/int N) {
  return /*delegate*/org.llvm.support.impl.GenericDomTreeConstructionLlvmGlobals.
                  DFSPass(GraphTraits_NodeT, DT, V, N);
}

//
///*template <class GraphT> TEMPLATE*/
//
///*template <class GraphT> TEMPLATE*/
//
///*template <class FuncT, class N> TEMPLATE*/
//
//
///// \brief Construct a new ELF writer instance.
/////
///// \param MOTW - The target specific ELF writer subclass.
///// \param OS - The stream to write to.
///// \returns The constructed object writer.
////<editor-fold defaultstate="collapsed" desc="llvm::createELFObjectWriter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp", line = 1380,
// old_source = "${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp", old_line = 1347,
// FQN="llvm::createELFObjectWriter", NM="_ZN4llvm21createELFObjectWriterEPNS_23MCELFObjectTargetWriterERNS_17raw_pwrite_streamEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm21createELFObjectWriterEPNS_23MCELFObjectTargetWriterERNS_17raw_pwrite_streamEb")
////</editor-fold>
//public static MCObjectWriter /*P*/ createELFObjectWriter(MCELFObjectTargetWriter /*P*/ MOTW, 
//                     final raw_pwrite_stream /*&*/ OS, 
//                     boolean IsLittleEndian) {
//  return /*delegate*/org.llvm.mc.impl.ELFObjectWriterLlvmGlobals.
//    createELFObjectWriter(MOTW, 
//                     OS, 
//                     IsLittleEndian);
//}
//
//
///// Log all errors (if any) in E to OS. If there are any errors, ErrorBanner
///// will be printed before the first one is logged. A newline will be printed
///// after each error.
/////
///// This is useful in the base level of your program to allow clean termination
///// (allowing clean deallocation of resources, etc.), while reporting error
///// information to the user.
////<editor-fold defaultstate="collapsed" desc="llvm::logAllUnhandledErrors">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 57,
// FQN="llvm::logAllUnhandledErrors", NM="_ZN4llvm21logAllUnhandledErrorsENS_5ErrorERNS_11raw_ostreamENS_5TwineE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm21logAllUnhandledErrorsENS_5ErrorERNS_11raw_ostreamENS_5TwineE")
////</editor-fold>
//public static void logAllUnhandledErrors(Error E, final raw_ostream /*&*/ OS, Twine ErrorBanner) {
//  /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    logAllUnhandledErrors(E, OS, ErrorBanner);
//}


/// The value returned by this function can be returned from convertToErrorCode
/// for Error values where no sensible translation to std::error_code exists.
/// It should only be used in this situation, and should never be used where a
/// sensible conversion to std::error_code is available, as attempts to convert
/// to/from this error will result in a fatal error. (i.e. it is a programmatic
///error to try to convert such a value).
//<editor-fold defaultstate="collapsed" desc="llvm::inconvertibleErrorCode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 73,
 FQN="llvm::inconvertibleErrorCode", NM="_ZN4llvm22inconvertibleErrorCodeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm22inconvertibleErrorCodeEv")
//</editor-fold>
public static error_code inconvertibleErrorCode() {
  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
    inconvertibleErrorCode();
}


///// Helper for converting an std::error_code to a Error.
////<editor-fold defaultstate="collapsed" desc="llvm::errorCodeToError">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 78,
// FQN="llvm::errorCodeToError", NM="_ZN4llvm16errorCodeToErrorESt10error_code",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm16errorCodeToErrorESt10error_code")
////</editor-fold>
//public static Error errorCodeToError(std.error_code EC) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    errorCodeToError(EC);
//}
//
//
///// Helper for converting an ECError to a std::error_code.
/////
///// This method requires that Err be Error() or an ECError, otherwise it
///// will trigger a call to abort().
////<editor-fold defaultstate="collapsed" desc="llvm::errorToErrorCode">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 84,
// FQN="llvm::errorToErrorCode", NM="_ZN4llvm16errorToErrorCodeENS_5ErrorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm16errorToErrorCodeENS_5ErrorE")
////</editor-fold>
//public static std.error_code errorToErrorCode(Error Err) {
//  return /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    errorToErrorCode(Err);
//}
//
//
///// Report a serious error, calling any installed error handler. See
///// ErrorHandling.h.
////<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 103,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorENS_5ErrorEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm18report_fatal_errorENS_5ErrorEb")
////</editor-fold>
//public static void report_fatal_error(Error Err) {
//  report_fatal_error(Err, true);
//}
//public static void report_fatal_error(Error Err, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorLlvmGlobals.
//    report_fatal_error(Err, GenCrashDiag);
//}
//
//
///// install_fatal_error_handler - Installs a new error handler to be used
///// whenever a serious (non-recoverable) error is encountered by LLVM.
/////
///// If no error handler is installed the default is to print the error message
///// to stderr, and call exit(1).  If an error handler is installed then it is
///// the handler's responsibility to log the message, it will no longer be
///// printed to stderr.  If the error handler returns, then exit(1) will be
///// called.
/////
///// It is dangerous to naively use an error handler which throws an exception.
///// Even though some applications desire to gracefully recover from arbitrary
///// faults, blindly throwing exceptions through unfamiliar code isn't a way to
///// achieve this.
/////
///// \param user_data - An argument which will be passed to the install error
///// handler.
////<editor-fold defaultstate="collapsed" desc="llvm::install_fatal_error_handler">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 48,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 47,
// FQN="llvm::install_fatal_error_handler", NM="_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_")
////</editor-fold>
//public static void install_fatal_error_handler(fatal_error_handler_t handler) {
//  install_fatal_error_handler(handler, 
//                           (Object/*void P*/ )null);
//}
//public static void install_fatal_error_handler(fatal_error_handler_t handler, 
//                           Object/*void P*/ user_data/*= null*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    install_fatal_error_handler(handler, 
//                           user_data);
//}
//
//
///// Restores default error handling behaviour.
////<editor-fold defaultstate="collapsed" desc="llvm::remove_fatal_error_handler">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 56,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 55,
// FQN="llvm::remove_fatal_error_handler", NM="_ZN4llvm26remove_fatal_error_handlerEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm26remove_fatal_error_handlerEv")
////</editor-fold>
//public static void remove_fatal_error_handler() {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    remove_fatal_error_handler();
//}
//
//
///// Reports a serious error, calling any installed error handler. These
///// functions are intended to be used for error conditions which are outside
///// the control of the compiler (I/O errors, invalid user input, etc.)
/////
///// If no error handler is installed the default is to print the message to
///// standard error, followed by a newline.
///// After the error handler is called this function will call exit(1), it
///// does not return.
////<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 62,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 61,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorEPKcb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorEPKcb")
////</editor-fold>
//public static void report_fatal_error(/*const*/char$ptr/*char P*/ Reason) {
//  report_fatal_error(Reason, true);
//}
//public static void report_fatal_error(/*const*/char$ptr/*char P*/ Reason, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    report_fatal_error(Reason, GenCrashDiag);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 66,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 65,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorERKSsb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKSsb")
////</editor-fold>
//public static void report_fatal_error(final /*const*/std.string/*&*/ Reason) {
//  report_fatal_error(Reason, true);
//}
//public static void report_fatal_error(final /*const*/std.string/*&*/ Reason, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    report_fatal_error(Reason, GenCrashDiag);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 70,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 69,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorENS_9StringRefEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorENS_9StringRefEb")
////</editor-fold>
//public static void report_fatal_error(StringRef Reason) {
//  report_fatal_error(Reason, true);
//}
//public static void report_fatal_error(StringRef Reason, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    report_fatal_error(Reason, GenCrashDiag);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 74,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 73,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorERKNS_5TwineEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKNS_5TwineEb")
////</editor-fold>
//public static void report_fatal_error(final /*const*/ Twine /*&*/ Reason) {
//  report_fatal_error(Reason, true);
//}
//public static void report_fatal_error(final /*const*/ Twine /*&*/ Reason, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    report_fatal_error(Reason, GenCrashDiag);
//}
//
//
///// This function calls abort(), and prints the optional message to stderr.
///// Use the llvm_unreachable macro (that adds location info), instead of
///// calling this function directly.
////<editor-fold defaultstate="collapsed" desc="llvm::llvm_unreachable_internal">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 107,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", old_line = 106,
// FQN="llvm::llvm_unreachable_internal", NM="_ZN4llvm25llvm_unreachable_internalEPKcS1_j",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm25llvm_unreachable_internalEPKcS1_j")
////</editor-fold>
//public static void llvm_unreachable_internal() {
//  llvm_unreachable_internal((/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null, 
//                         0);
//}
//public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/) {
//  llvm_unreachable_internal(msg, (/*const*/char$ptr/*char P*/ )null, 
//                         0);
//}
//public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/, /*const*/char$ptr/*char P*/ file/*= null*/) {
//  llvm_unreachable_internal(msg, file, 
//                         0);
//}
//public static void llvm_unreachable_internal(/*const*/char$ptr/*char P*/ msg/*= null*/, /*const*/char$ptr/*char P*/ file/*= null*/, 
//                         /*uint*/int line/*= 0*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    llvm_unreachable_internal(msg, file, 
//                         line);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::make_error_code">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Errc.h", line = 78,
 FQN="llvm::make_error_code", NM="_ZN4llvm15make_error_codeENS_4errcE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm15make_error_codeENS_4errcE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(errc E) {
  return /*delegate*/org.llvm.support.impl.ErrcLlvmGlobals.
    make_error_code(E);
}


///// DiffFilesWithTolerance - Compare the two files specified, returning 0 if
///// the files match, 1 if they are different, and 2 if there is a file error.
///// This function allows you to specify an absolute and relative FP error that
///// is allowed to exist.  If you specify a string to fill in for the error
///// option, it will set the string to an error message if an error occurs, or
///// if the files are different.
/////
//
///// DiffFilesWithTolerance - Compare the two files specified, returning 0 if the
///// files match, 1 if they are different, and 2 if there is a file error.  This
///// function differs from DiffFiles in that you can specify an absolete and
///// relative FP error that is allowed to exist.  If you specify a string to fill
///// in for the error option, it will set the string to an error message if an
///// error occurs, allowing the caller to distinguish between a failed diff and a
///// file system error.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::DiffFilesWithTolerance">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/FileUtilities.cpp", line = 173,
// FQN="llvm::DiffFilesWithTolerance", NM="_ZN4llvm22DiffFilesWithToleranceENS_9StringRefES0_ddPSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/FileUtilities.cpp -nm=_ZN4llvm22DiffFilesWithToleranceENS_9StringRefES0_ddPSs")
////</editor-fold>
//public static int DiffFilesWithTolerance(StringRef NameA, 
//                      StringRef NameB, 
//                      double AbsTol, double RelTol) {
//  return DiffFilesWithTolerance(NameA, 
//                      NameB, 
//                      AbsTol, RelTol, 
//                      (std.string/*P*/ )null);
//}
//public static int DiffFilesWithTolerance(StringRef NameA, 
//                      StringRef NameB, 
//                      double AbsTol, double RelTol, 
//                      std.string/*P*/ Error/*= null*/) {
//  return /*delegate*/org.llvm.support.impl.FileUtilitiesLlvmGlobals.
//    DiffFilesWithTolerance(NameA, 
//                      NameB, 
//                      AbsTol, RelTol, 
//                      Error);
//}
//
//
///// fouts() - This returns a reference to a formatted_raw_ostream for
///// standard output.  Use it like: fouts() << "foo" << "bar";
//
///// fouts() - This returns a reference to a formatted_raw_ostream for
///// standard output.  Use it like: fouts() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::fouts">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 90,
// FQN="llvm::fouts", NM="_ZN4llvm5foutsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm5foutsEv")
////</editor-fold>
//public static formatted_raw_ostream /*&*/ fouts() {
//  return /*delegate*/org.llvm.support.impl.FormattedStreamLlvmGlobals.
//    fouts();
//}
//
//
///// ferrs() - This returns a reference to a formatted_raw_ostream for
///// standard error.  Use it like: ferrs() << "foo" << "bar";
//
///// ferrs() - This returns a reference to a formatted_raw_ostream for
///// standard error.  Use it like: ferrs() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::ferrs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 97,
// FQN="llvm::ferrs", NM="_ZN4llvm5ferrsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm5ferrsEv")
////</editor-fold>
//public static formatted_raw_ostream /*&*/ ferrs() {
//  return /*delegate*/org.llvm.support.impl.FormattedStreamLlvmGlobals.
//    ferrs();
//}
//
//
///// fdbgs() - This returns a reference to a formatted_raw_ostream for
///// debug output.  Use it like: fdbgs() << "foo" << "bar";
//
///// fdbgs() - This returns a reference to a formatted_raw_ostream for
///// the debug stream.  Use it like: fdbgs() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::fdbgs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 104,
// FQN="llvm::fdbgs", NM="_ZN4llvm5fdbgsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm5fdbgsEv")
////</editor-fold>
//public static formatted_raw_ostream /*&*/ fdbgs() {
//  return /*delegate*/org.llvm.support.impl.FormattedStreamLlvmGlobals.
//    fdbgs();
//}
//
//
///// \brief Construct the begin iterator for a deduced graph type T.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::scc_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 223,
// FQN="llvm::scc_begin", NM="Tpl__ZN4llvm9scc_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=Tpl__ZN4llvm9scc_beginERKT_")
////</editor-fold>
//public static </*class*/ T> scc_iterator<T> scc_begin(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.SCCIteratorLlvmGlobals.
//    scc_begin(G);
//}
//
//
///// \brief Construct the end iterator for a deduced graph type T.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::scc_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 228,
// FQN="llvm::scc_end", NM="Tpl__ZN4llvm7scc_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=Tpl__ZN4llvm7scc_endERKT_")
////</editor-fold>
//public static </*class*/ T> scc_iterator<T> scc_end(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.SCCIteratorLlvmGlobals.
//    scc_end(G);
//}
//
//
///// \brief Construct the begin iterator for a deduced graph type T's Inverse<T>.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::scc_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 233,
// FQN="llvm::scc_begin", NM="Tpl__ZN4llvm9scc_beginERKNS_7InverseIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=Tpl__ZN4llvm9scc_beginERKNS_7InverseIT_EE")
////</editor-fold>
//public static </*class*/ T> scc_iterator<Inverse<T> > scc_begin(final /*const*/ Inverse<T> /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.SCCIteratorLlvmGlobals.
//    scc_begin(G);
//}
//
//
///// \brief Construct the end iterator for a deduced graph type T's Inverse<T>.
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::scc_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SCCIterator.h", line = 238,
// FQN="llvm::scc_end", NM="Tpl__ZN4llvm7scc_endERKNS_7InverseIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=Tpl__ZN4llvm7scc_endERKNS_7InverseIT_EE")
////</editor-fold>
//public static </*class*/ T> scc_iterator<Inverse<T> > scc_end(final /*const*/ Inverse<T> /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.SCCIteratorLlvmGlobals.
//    scc_end(G);
//}
//
//
// Provide global constructors that automatically figure out correct types...
//
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 178,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 177,
 FQN="llvm::po_begin", NM="Tpl__ZN4llvm8po_beginERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm8po_beginERKT_")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
                po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_begin(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
    po_begin(GT, G);
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::po_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 180,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 179,
 FQN="llvm::po_end", NM="Tpl__ZN4llvm6po_endERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm6po_endERKT_")
//</editor-fold>
public static </*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
                po_iterator</*class*/ GraphT, /*class*/ NodeType, ChildNodeType> 
        po_end(GraphTraits<GraphT, NodeType, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
    po_end(GT, G);
}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::post_order">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 182,
// FQN="llvm::post_order", NM="Tpl__ZN4llvm10post_orderERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm10post_orderERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range< std.iterator<std.forward_iterator_tag,  GT.NodeType, int>.pointer> post_order(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    post_order(G);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 194,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 193,
// FQN="llvm::po_ext_begin", NM="Tpl__ZN4llvm12po_ext_beginET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm12po_ext_beginET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> po_ext_iterator<T, SetType> po_ext_begin(T G, final SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    po_ext_begin(G, S);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 199,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 198,
// FQN="llvm::po_ext_end", NM="Tpl__ZN4llvm10po_ext_endET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm10po_ext_endET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> po_ext_iterator<T, SetType> po_ext_end(T G, final SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    po_ext_end(G, S);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::post_order_ext">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 204,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 203,
// FQN="llvm::post_order_ext", NM="Tpl__ZN4llvm14post_order_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm14post_order_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> iterator_range<po_ext_iterator<T, SetType> > post_order_ext(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    post_order_ext(G, S);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 218,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 217,
// FQN="llvm::ipo_begin", NM="Tpl__ZN4llvm9ipo_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm9ipo_beginERKT_")
////</editor-fold>
//public static </*class*/ T> ipo_iterator<T> ipo_begin(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    ipo_begin(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 223,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 222,
// FQN="llvm::ipo_end", NM="Tpl__ZN4llvm7ipo_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm7ipo_endERKT_")
////</editor-fold>
//public static </*class*/ T> ipo_iterator<T> ipo_end(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    ipo_end(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_post_order">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 228,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 227,
// FQN="llvm::inverse_post_order", NM="Tpl__ZN4llvm18inverse_post_orderERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm18inverse_post_orderERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range<ipo_iterator<T> > inverse_post_order(final /*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    inverse_post_order(G);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 243,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 242,
// FQN="llvm::ipo_ext_begin", NM="Tpl__ZN4llvm13ipo_ext_beginERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm13ipo_ext_beginERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> ipo_ext_iterator<T, SetType> ipo_ext_begin(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    ipo_ext_begin(G, S);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 248,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 247,
// FQN="llvm::ipo_ext_end", NM="Tpl__ZN4llvm11ipo_ext_endERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm11ipo_ext_endERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> ipo_ext_iterator<T, SetType> ipo_ext_end(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    ipo_ext_end(G, S);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_post_order_ext">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 253,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", old_line = 252,
// FQN="llvm::inverse_post_order_ext", NM="Tpl__ZN4llvm22inverse_post_order_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=Tpl__ZN4llvm22inverse_post_order_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> iterator_range<ipo_ext_iterator<T, SetType> > inverse_post_order_ext(final /*const*/ T /*&*/ G, final SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    inverse_post_order_ext(G, S);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::DisplayGraph">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 135,
 FQN="llvm::DisplayGraph", NM="_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE")
//</editor-fold>
public static boolean DisplayGraph(StringRef FilenameRef) {
  return DisplayGraph(FilenameRef, true, 
            GraphProgram.Name.DOT);
}
public static boolean DisplayGraph(StringRef FilenameRef, boolean wait/*= true*/) {
  return DisplayGraph(FilenameRef, wait, 
            GraphProgram.Name.DOT);
}
public static boolean DisplayGraph(StringRef FilenameRef, boolean wait/*= true*/, 
            GraphProgram.Name program/*= GraphProgram::DOT*/) {
  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
    DisplayGraph(FilenameRef, wait, 
            program);
}

////<editor-fold defaultstate="collapsed" desc="llvm::createGraphFilename">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 67,
// FQN="llvm::createGraphFilename", NM="_ZN4llvm19createGraphFilenameERKNS_5TwineERi",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm19createGraphFilenameERKNS_5TwineERi")
////</editor-fold>
//public static std.string createGraphFilename(final /*const*/ Twine /*&*/ Name, final int$ref/*int &*/ FD) {
//  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
//    createGraphFilename(Name, FD);
//}
//
//
///// \brief Override the execution seed with a fixed value.
/////
///// This hashing library uses a per-execution seed designed to change on each
///// run with high probability in order to ensure that the hash codes are not
///// attackable and to ensure that output which is intended to be stable does
///// not rely on the particulars of the hash codes produced.
/////
///// That said, there are use cases where it is important to be able to
///// reproduce *exactly* a specific behavior. To that end, we provide a function
///// which will forcibly set the seed to a fixed value. This must be done at the
///// start of the program, before any hashes are computed. Also, it cannot be
///// undone. This makes it thread-hostile and very hard to use outside of
///// immediately on start of a simple program designed for reproducible
///// behavior.
//
//// Implement the function for forced setting of the fixed seed.
//// FIXME: Use atomic operations here so that there is no data race.
////<editor-fold defaultstate="collapsed" desc="llvm::set_fixed_execution_hash_seed">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Hashing.cpp", line = 27,
// FQN="llvm::set_fixed_execution_hash_seed", NM="_ZN4llvm29set_fixed_execution_hash_seedEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm29set_fixed_execution_hash_seedEj")
////</editor-fold>
//public static void set_fixed_execution_hash_seed(/*size_t*/int fixed_value) {
//  /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    set_fixed_execution_hash_seed(fixed_value);
//}


/// Utility function to encode a SLEB128 value to an output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::encodeSLEB128">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 23,
 FQN="llvm::encodeSLEB128", NM="_ZN4llvm13encodeSLEB128ExRNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeSLEB128ExRNS_11raw_ostreamE")
//</editor-fold>
public static /*inline*/ void encodeSLEB128(long/*int64_t*/ Value, final raw_ostream /*&*/ OS) {
  /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
    encodeSLEB128(Value, OS);
}


/// Utility function to encode a ULEB128 value to an output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::encodeULEB128">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 38,
 FQN="llvm::encodeULEB128", NM="_ZN4llvm13encodeULEB128EyRNS_11raw_ostreamEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeULEB128EyRNS_11raw_ostreamEj")
//</editor-fold>
public static /*inline*/ void encodeULEB128(long/*uint64_t*/ Value, final raw_ostream /*&*/ OS) {
  encodeULEB128(Value, OS, 
             0);
}
public static /*inline*/ void encodeULEB128(long/*uint64_t*/ Value, final raw_ostream /*&*/ OS, 
             /*uint*/int Padding/*= 0*/) {
  /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
    encodeULEB128(Value, OS, 
             Padding);
}


///// Utility function to encode a ULEB128 value to a buffer. Returns
///// the length in bytes of the encoded value.
////<editor-fold defaultstate="collapsed" desc="llvm::encodeULEB128">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 58,
// FQN="llvm::encodeULEB128", NM="_ZN4llvm13encodeULEB128EyPhj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeULEB128EyPhj")
////</editor-fold>
//public static /*inline*/ /*uint*/int encodeULEB128(long/*uint64_t*/ Value, byte/*uint8_t*//*P*/ p) {
//  return encodeULEB128(Value, p, 
//             0);
//}
//public static /*inline*/ /*uint*/int encodeULEB128(long/*uint64_t*/ Value, byte/*uint8_t*//*P*/ p, 
//             /*uint*/int Padding/*= 0*/) {
//  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    encodeULEB128(Value, p, 
//             Padding);
//}
//
//
///// Utility function to decode a ULEB128 value.
////<editor-fold defaultstate="collapsed" desc="llvm::decodeULEB128">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 80,
// FQN="llvm::decodeULEB128", NM="_ZN4llvm13decodeULEB128EPKhPj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13decodeULEB128EPKhPj")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ decodeULEB128(/*const*/byte/*uint8_t*//*P*/ p) {
//  return decodeULEB128(p, (uint$ptr/*uint P*/ )null);
//}
//public static /*inline*/ long/*uint64_t*/ decodeULEB128(/*const*/byte/*uint8_t*//*P*/ p, uint$ptr/*uint P*/ n/*= null*/) {
//  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    decodeULEB128(p, n);
//}
//
//
///// Utility function to decode a SLEB128 value.
////<editor-fold defaultstate="collapsed" desc="llvm::decodeSLEB128">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 94,
// FQN="llvm::decodeSLEB128", NM="_ZN4llvm13decodeSLEB128EPKhPj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13decodeSLEB128EPKhPj")
////</editor-fold>
//public static /*inline*/ long/*int64_t*/ decodeSLEB128(/*const*/byte/*uint8_t*//*P*/ p) {
//  return decodeSLEB128(p, (uint$ptr/*uint P*/ )null);
//}
//public static /*inline*/ long/*int64_t*/ decodeSLEB128(/*const*/byte/*uint8_t*//*P*/ p, uint$ptr/*uint P*/ n/*= null*/) {
//  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    decodeSLEB128(p, n);
//}


/// Utility function to get the size of the ULEB128-encoded value.

/// Utility function to get the size of the ULEB128-encoded value.
//<editor-fold defaultstate="collapsed" desc="llvm::getULEB128Size">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/LEB128.cpp", line = 20,
 FQN="llvm::getULEB128Size", NM="_ZN4llvm14getULEB128SizeEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm14getULEB128SizeEy")
//</editor-fold>
public static /*uint*/int getULEB128Size(long/*uint64_t*/ Value) {
  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
    getULEB128Size(Value);
}


///// Utility function to get the size of the SLEB128-encoded value.
//
///// Utility function to get the size of the SLEB128-encoded value.
////<editor-fold defaultstate="collapsed" desc="llvm::getSLEB128Size">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/LEB128.cpp", line = 30,
// FQN="llvm::getSLEB128Size", NM="_ZN4llvm14getSLEB128SizeEx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm14getSLEB128SizeEx")
////</editor-fold>
//public static /*uint*/int getSLEB128Size(long/*int64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    getSLEB128Size(Value);
//}
//
//
///// Create a machine code streamer which will print out assembly for the native
///// target, suitable for compiling with a native assembler.
/////
///// \param InstPrint - If given, the instruction printer to use. If not given
///// the MCInst representation will be printed.  This method takes ownership of
///// InstPrint.
/////
///// \param CE - If given, a code emitter to use to show the instruction
///// encoding inline with the assembly. This method takes ownership of \p CE.
/////
///// \param TAB - If given, a target asm backend to use to show the fixup
///// information in conjunction with encoding information. This method takes
///// ownership of \p TAB.
/////
///// \param ShowInst - Whether to show the MCInst representation inline with
///// the assembly.
////<editor-fold defaultstate="collapsed" desc="llvm::createAsmStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp", line = 1614,
// old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp", old_line = 1404,
// FQN="llvm::createAsmStreamer", NM="_ZN4llvm17createAsmStreamerERNS_9MCContextESt10unique_ptrINS_21formatted_raw_ostreamESt14default_deleteIS3_EEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp -nm=_ZN4llvm17createAsmStreamerERNS_9MCContextESt10unique_ptrINS_21formatted_raw_ostreamESt14default_deleteIS3_EEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb")
////</editor-fold>
//public static MCStreamer /*P*/ createAsmStreamer(final MCContext /*&*/ Context, 
//                 std.unique_ptr<formatted_raw_ostream> OS, 
//                 boolean isVerboseAsm, boolean useDwarfDirectory, 
//                 MCInstPrinter /*P*/ IP, MCCodeEmitter /*P*/ CE, 
//                 MCAsmBackend /*P*/ MAB, boolean ShowInst) {
//  return /*delegate*/org.llvm.support.target.impl.MCAsmStreamerLlvmGlobals.
//    createAsmStreamer(Context, 
//                 OS, 
//                 isVerboseAsm, useDwarfDirectory, 
//                 IP, CE, 
//                 MAB, ShowInst);
//}
//
//
///// Takes ownership of \p TAB and \p CE.
////<editor-fold defaultstate="collapsed" desc="llvm::createELFStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCELFStreamer.cpp", line = 633,
// FQN="llvm::createELFStreamer", NM="_ZN4llvm17createELFStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCELFStreamer.cpp -nm=_ZN4llvm17createELFStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEb")
////</editor-fold>
//public static MCStreamer /*P*/ createELFStreamer(final MCContext /*&*/ Context, final MCAsmBackend /*&*/ MAB, 
//                 final raw_pwrite_stream /*&*/ OS, MCCodeEmitter /*P*/ CE, 
//                 boolean RelaxAll) {
//  return /*delegate*/org.llvm.support.target.impl.MCELFStreamerLlvmGlobals.
//    createELFStreamer(Context, MAB, 
//                 OS, CE, 
//                 RelaxAll);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::createMCSymbolizer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/MCExternalSymbolizer.cpp", line = 191,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 74,
// FQN="llvm::createMCSymbolizer", NM="_ZN4llvm18createMCSymbolizerERKNS_6TripleEPFiPvyyyiS3_EPFPKcS3_yPyyPS7_ES3_PNS_9MCContextEOSt10unique_ptrINS_16MCRelocationInfoESt14default_deleteISF_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/MCExternalSymbolizer.cpp -nm=_ZN4llvm18createMCSymbolizerERKNS_6TripleEPFiPvyyyiS3_EPFPKcS3_yPyyPS7_ES3_PNS_9MCContextEOSt10unique_ptrINS_16MCRelocationInfoESt14default_deleteISF_EE")
////</editor-fold>
//public static MCSymbolizer /*P*/ createMCSymbolizer(final /*const*/ Triple /*&*/ TT, /*ADD MAPPING FOR FUN PTR[int (* )(void * , uint64_t, uint64_t, uint64_t, int, void * )]*/int (/*P*/ GetOpInfo)(Object/*void P*/ , long/*uint64_t*/, long/*uint64_t*/, long/*uint64_t*/, int, Object/*void P*/ ), 
//                  /*ADD MAPPING FOR FUN PTR[const char * (* )(void * , uint64_t, uint64_t * , uint64_t, const char * * )]*//*const*/ /*char*/byte /*P*/ (/*P*/ SymbolLookUp)(Object/*void P*/ , long/*uint64_t*/, ulong$ptr/*uint64_t P*/ , long/*uint64_t*/, /*const*/type$ptr<char$ptr>/*char PP*/ ), 
//                  Object/*void P*/ DisInfo, MCContext /*P*/ Ctx, 
//                  final std.unique_ptr<MCRelocationInfo> /*&&*/RelInfo) {
//  return /*delegate*/org.llvm.support.target.impl.MCExternalSymbolizerLlvmGlobals.
//    createMCSymbolizer(TT, GetOpInfo, 
//                  SymbolLookUp, 
//                  DisInfo, Ctx, 
//                  RelInfo);
//}
//
//
///// \brief Compute the amount of padding required before the fragment \p F to
///// obey bundling restrictions, where \p FOffset is the fragment's offset in
///// its section and \p FSize is the fragment's size.
////<editor-fold defaultstate="collapsed" desc="llvm::computeBundlePadding">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 191,
// old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 192,
// FQN="llvm::computeBundlePadding", NM="_ZN4llvm20computeBundlePaddingERKNS_11MCAssemblerEPKNS_10MCFragmentEyy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm20computeBundlePaddingERKNS_11MCAssemblerEPKNS_10MCFragmentEyy")
////</editor-fold>
//public static long/*uint64_t*/ computeBundlePadding(final /*const*/ MCAssembler /*&*/ Assembler, 
//                    /*const*/ MCFragment /*P*/ F, 
//                    long/*uint64_t*/ FOffset, long/*uint64_t*/ FSize) {
//  return /*delegate*/org.llvm.mc.impl.MCFragmentLlvmGlobals.
//    computeBundlePadding(Assembler, 
//                    F, 
//                    FOffset, FSize);
//}
//
//
///// Convert `Bytes' to a hex string and output to `OS'
////<editor-fold defaultstate="collapsed" desc="llvm::dumpBytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 19,
// FQN="llvm::dumpBytes", NM="_ZN4llvm9dumpBytesENS_8ArrayRefIhEERNS_11raw_ostreamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm9dumpBytesENS_8ArrayRefIhEERNS_11raw_ostreamE")
////</editor-fold>
//public static void dumpBytes(ArrayRefUChar bytes, final raw_ostream /*&*/ OS) {
//  /*delegate*/org.llvm.mc.impl.MCInstPrinterLlvmGlobals.
//    dumpBytes(bytes, OS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 51,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCLabelE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCLabelE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCLabel$C(final raw_ostream /*&*/ OS, final /*const*/ MCLabel /*&*/ Label) {
//  return /*delegate*/org.llvm.mc.impl.MCLabelLlvmGlobals.
//    $out_raw_ostream_MCLabel$C(OS, Label);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::createMachOStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp", line = 497,
// old_source = "${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp", old_line = 483,
// FQN="llvm::createMachOStreamer", NM="_ZN4llvm19createMachOStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp -nm=_ZN4llvm19createMachOStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterEbbb")
////</editor-fold>
//public static MCStreamer /*P*/ createMachOStreamer(final MCContext /*&*/ Context, final MCAsmBackend /*&*/ MAB, 
//                   final raw_pwrite_stream /*&*/ OS, MCCodeEmitter /*P*/ CE, 
//                   boolean RelaxAll, boolean DWARFMustBeAtTheEnd) {
//  return createMachOStreamer(Context, MAB, 
//                   OS, CE, 
//                   RelaxAll, DWARFMustBeAtTheEnd, 
//                   false);
//}
//public static MCStreamer /*P*/ createMachOStreamer(final MCContext /*&*/ Context, final MCAsmBackend /*&*/ MAB, 
//                   final raw_pwrite_stream /*&*/ OS, MCCodeEmitter /*P*/ CE, 
//                   boolean RelaxAll, boolean DWARFMustBeAtTheEnd, 
//                   boolean LabelSections/*= false*/) {
//  return /*delegate*/org.llvm.support.target.impl.MCMachOStreamerLlvmGlobals.
//    createMachOStreamer(Context, MAB, 
//                   OS, CE, 
//                   RelaxAll, DWARFMustBeAtTheEnd, 
//                   LabelSections);
//}
//
//
///// Create a dummy machine code streamer, which does nothing. This is useful for
///// timing the assembler front end.
////<editor-fold defaultstate="collapsed" desc="llvm::createNullStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp", line = 41,
// FQN="llvm::createNullStreamer", NM="_ZN4llvm18createNullStreamerERNS_9MCContextE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp -nm=_ZN4llvm18createNullStreamerERNS_9MCContextE")
////</editor-fold>
//public static MCStreamer /*P*/ createNullStreamer(final MCContext /*&*/ Context) {
//  return /*delegate*/org.llvm.support.target.impl.MCNullStreamerLlvmGlobals.
//    createNullStreamer(Context);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::createMCRelocationInfo">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/MCRelocationInfo.cpp", line = 31,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetRegistry.h", old_line = 72,
// FQN="llvm::createMCRelocationInfo", NM="_ZN4llvm22createMCRelocationInfoERKNS_6TripleERNS_9MCContextE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/MCRelocationInfo.cpp -nm=_ZN4llvm22createMCRelocationInfoERKNS_6TripleERNS_9MCContextE")
////</editor-fold>
//public static MCRelocationInfo /*P*/ createMCRelocationInfo(final /*const*/ Triple /*&*/ TT, 
//                      final MCContext /*&*/ Ctx) {
//  return /*delegate*/org.llvm.support.target.impl.MCRelocationInfoLlvmGlobals.
//    createMCRelocationInfo(TT, 
//                      Ctx);
//}
//
//
///// Construct a new Mach-O writer instance.
/////
///// This routine takes ownership of the target writer subclass.
/////
///// \param MOTW - The target specific Mach-O writer subclass.
///// \param OS - The stream to write to.
///// \returns The constructed object writer.
////<editor-fold defaultstate="collapsed" desc="llvm::createMachObjectWriter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 984,
// old_source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", old_line = 980,
// FQN="llvm::createMachObjectWriter", NM="_ZN4llvm22createMachObjectWriterEPNS_24MCMachObjectTargetWriterERNS_17raw_pwrite_streamEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm22createMachObjectWriterEPNS_24MCMachObjectTargetWriterERNS_17raw_pwrite_streamEb")
////</editor-fold>
//public static MCObjectWriter /*P*/ createMachObjectWriter(MCMachObjectTargetWriter /*P*/ MOTW, 
//                      final raw_pwrite_stream /*&*/ OS, 
//                      boolean IsLittleEndian) {
//  return /*delegate*/org.llvm.mc.impl.MachObjectWriterLlvmGlobals.
//    createMachObjectWriter(MOTW, 
//                      OS, 
//                      IsLittleEndian);
//}
//
//
///// llvm_shutdown - Deallocate and destroy all ManagedStatic variables.
//
///// llvm_shutdown - Deallocate and destroy all ManagedStatic variables.
////<editor-fold defaultstate="collapsed" desc="llvm::llvm_shutdown">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", line = 83,
// old_source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", old_line = 86,
// FQN="llvm::llvm_shutdown", NM="_ZN4llvm13llvm_shutdownEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm13llvm_shutdownEv")
////</editor-fold>
//public static void llvm_shutdown() {
//  /*delegate*/org.llvm.support.impl.ManagedStaticLlvmGlobals.
//    llvm_shutdown();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::huge_valf">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp", line = 29,
// FQN="llvm::huge_valf", NM="_ZN4llvm9huge_valfE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm9huge_valfE")
////</editor-fold>
//public static /*const*/float huge_valf = (__builtin_huge_valf());
////<editor-fold defaultstate="collapsed" desc="llvm::EnablePrettyStackTrace">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 163,
// old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 149,
// FQN="llvm::EnablePrettyStackTrace", NM="_ZN4llvm22EnablePrettyStackTraceEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm22EnablePrettyStackTraceEv")
////</editor-fold>
//public static void EnablePrettyStackTrace() {
//  /*delegate*/org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
//    EnablePrettyStackTrace();
//}
//
//
///// Returns the topmost element of the "pretty" stack state.
////<editor-fold defaultstate="collapsed" desc="llvm::SavePrettyStackState">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 171,
// old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 157,
// FQN="llvm::SavePrettyStackState", NM="_ZN4llvm20SavePrettyStackStateEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm20SavePrettyStackStateEv")
////</editor-fold>
//public static /*const*/Object/*void P*/ SavePrettyStackState() {
//  return /*delegate*/org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
//    SavePrettyStackState();
//}
//
//
///// Restores the topmost element of the "pretty" stack state to State, which
///// should come from a previous call to SavePrettyStackState().  This is
///// useful when using a CrashRecoveryContext in code that also uses
///// PrettyStackTraceEntries, to make sure the stack that's printed if a crash
///// happens after a crash that's been recovered by CrashRecoveryContext
///// doesn't have frames on it that were added in code unwound by the
///// CrashRecoveryContext.
////<editor-fold defaultstate="collapsed" desc="llvm::RestorePrettyStackState">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 179,
// old_source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", old_line = 165,
// FQN="llvm::RestorePrettyStackState", NM="_ZN4llvm23RestorePrettyStackStateEPKv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm23RestorePrettyStackStateEPKv")
////</editor-fold>
//public static void RestorePrettyStackState(/*const*/Object/*void P*/ Top) {
//  /*delegate*/org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
//    RestorePrettyStackState(Top);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 724,
// FQN="llvm::operator+", NM="Tpl__ZN4llvmplERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmplERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $add_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $add_ScaledNumber$DigitsT$C(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator-">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 725,
// FQN="llvm::operator-", NM="Tpl__ZN4llvmmiERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmmiERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $sub_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $sub_ScaledNumber$DigitsT$C(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator*">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 726,
// FQN="llvm::operator*", NM="Tpl__ZN4llvmmlERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmmlERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $star_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $star_ScaledNumber$DigitsT$C(L, R);
//}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator/">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 727,
 FQN="llvm::operator/", NM="Tpl__ZN4llvmdvERKNS_12ScaledNumberIT_EES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmdvERKNS_12ScaledNumberIT_EES4_")
//</editor-fold>
public static </*class*/ DigitsT> ScaledNumber<DigitsT> $slash_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, final /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
    $slash_ScaledNumber$DigitsT$C(L, R);
}
public static ScaledNumberULLong $slash_ScaledNumber$DigitsT$C(final /*const*/ ScaledNumberULLong /*&*/ L, final /*const*/ ScaledNumberULLong /*&*/ R) {
  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
    $slash_ScaledNumber$DigitsT$C(L, R);
}

///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 731,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 730,
// FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERKNS_12ScaledNumberIT_EEs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmlsERKNS_12ScaledNumberIT_EEs")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $out_ScaledNumber$DigitsT$C_short(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, 
//                                 short/*int16_t*/ Shift) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $out_ScaledNumber$DigitsT$C_short(L, 
//                                 Shift);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator>>">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 737,
// old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 736,
// FQN="llvm::operator>>", NM="Tpl__ZN4llvmrsERKNS_12ScaledNumberIT_EEs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmrsERKNS_12ScaledNumberIT_EEs")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $in_ScaledNumber$DigitsT$C_short(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, 
//                                short/*int16_t*/ Shift) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $in_ScaledNumber$DigitsT$C_short(L, 
//                                Shift);
//}

/*template <class DigitsT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 743,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", old_line = 742,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE")
//</editor-fold>
public static </*class*/ DigitsT> raw_ostream /*&*/ $out_raw_ostream_ScaledNumber$DigitsT$C(final raw_ostream /*&*/ OS, final /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
    $out_raw_ostream_ScaledNumber$DigitsT$C(OS, X);
}
public static raw_ostream /*&*/ $out_raw_ostream_ScaledNumber$DigitsT$C(final raw_ostream /*&*/ OS, final /*const*/ ScaledNumberULLong /*&*/ X) {
  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
    $out_raw_ostream_ScaledNumber$DigitsT$C(OS, X);
}

///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
// FQN="llvm::operator<", NM="Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmltERKNS_12ScaledNumberIT_EEy")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $less_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $less_ScaledNumber$DigitsT$C_ulong(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator>">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
// FQN="llvm::operator>", NM="Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgtERKNS_12ScaledNumberIT_EEy")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $greater_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $greater_ScaledNumber$DigitsT$C_ulong(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
// FQN="llvm::operator==", NM="Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmeqERKNS_12ScaledNumberIT_EEy")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $eq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $eq_ScaledNumber$DigitsT$C_ulong(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 764,
// FQN="llvm::operator!=", NM="Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmneERKNS_12ScaledNumberIT_EEy")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $noteq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $noteq_ScaledNumber$DigitsT$C_ulong(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 765,
// FQN="llvm::operator<=", NM="Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmleERKNS_12ScaledNumberIT_EEy")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $lesseq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $lesseq_ScaledNumber$DigitsT$C_ulong(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 766,
// FQN="llvm::operator>=", NM="Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=Tpl__ZN4llvmgeERKNS_12ScaledNumberIT_EEy")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $greatereq_ScaledNumber$DigitsT$C_ulong(final /*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $greatereq_ScaledNumber$DigitsT$C_ulong(L, R);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ScopedPrinter.cpp", line = 11,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_9HexNumberE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScopedPrinter.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_9HexNumberE")
////</editor-fold>
//public static raw_ostream /*&*/ $out_raw_ostream_HexNumber$C(final raw_ostream /*&*/ OS, final /*const*/ HexNumber /*&*/ Value) {
//  return /*delegate*/org.llvm.support.impl.ScopedPrinterLlvmGlobals.
//    $out_raw_ostream_HexNumber$C(OS, Value);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::to_hexString">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/ScopedPrinter.cpp", line = 16,
// FQN="llvm::to_hexString", NM="_ZN4llvm12to_hexStringEyb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScopedPrinter.cpp -nm=_ZN4llvm12to_hexStringEyb")
////</editor-fold>
//public static /*const*/std.string to_hexString(long/*uint64_t*/ Value) {
//  return to_hexString(Value, true);
//}
//public static /*const*/std.string to_hexString(long/*uint64_t*/ Value, boolean UpperCase/*= true*/) {
//  return /*delegate*/org.llvm.support.impl.ScopedPrinterLlvmGlobals.
//    to_hexString(Value, UpperCase);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::to_string">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/ScopedPrinter.h", line = 62,
// FQN="llvm::to_string", NM="Tpl__ZN4llvm9to_stringERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScopedPrinter.cpp -nm=Tpl__ZN4llvm9to_stringERKT_")
////</editor-fold>
//public static </*class*/ T> /*const*/std.string to_string(final /*const*/ T /*&*/ Value) {
//  return /*delegate*/org.llvm.support.impl.ScopedPrinterLlvmGlobals.
//    to_string(Value);
//}
//
//
///// \brief Determine the edit distance between two sequences.
/////
///// \param FromArray the first sequence to compare.
/////
///// \param ToArray the second sequence to compare.
/////
///// \param AllowReplacements whether to allow element replacements (change one
///// element into another) as a single operation, rather than as two operations
///// (an insertion and a removal).
/////
///// \param MaxEditDistance If non-zero, the maximum edit distance that this
///// routine is allowed to compute. If the edit distance will exceed that
///// maximum, returns \c MaxEditDistance+1.
/////
///// \returns the minimum number of element insertions, removals, or (if
///// \p AllowReplacements is \c true) replacements needed to transform one of
///// the given sequences into the other. If zero, the sequences are identical.
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ComputeEditDistance">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/edit_distance.h", line = 43,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/edit_distance.h", old_line = 42,
// FQN="llvm::ComputeEditDistance", NM="Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj")
////</editor-fold>
//public static </*typename*/ T> /*uint*/int ComputeEditDistance(ArrayRef<T> FromArray, ArrayRef<T> ToArray) {
//  return ComputeEditDistance(FromArray, ToArray, 
//                   true, 
//                   0);
//}
//public static </*typename*/ T> /*uint*/int ComputeEditDistance(ArrayRef<T> FromArray, ArrayRef<T> ToArray, 
//                   boolean AllowReplacements/*= true*/) {
//  return ComputeEditDistance(FromArray, ToArray, 
//                   AllowReplacements, 
//                   0);
//}
//public static </*typename*/ T> /*uint*/int ComputeEditDistance(ArrayRef<T> FromArray, ArrayRef<T> ToArray, 
//                   boolean AllowReplacements/*= true*/, 
//                   /*uint*/int MaxEditDistance/*= 0*/) {
//  return /*delegate*/org.llvm.adt.impl.Edit_distanceLlvmGlobals.
//    ComputeEditDistance(FromArray, ToArray, 
//                   AllowReplacements, 
//                   MaxEditDistance);
//}
//
//
///// set_union(A, B) - Compute A := A u B, return whether A changed.
/////
///*template <class S1Ty, class S2Ty> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::set_union">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", line = 23,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", old_line = 22,
// FQN="llvm::set_union", NM="Tpl__ZN4llvm9set_unionERT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp -nm=Tpl__ZN4llvm9set_unionERT_RKT0_")
////</editor-fold>
//public static </*class*/ S1Ty, /*class*/ S2Ty> boolean set_union(final S1Ty /*&*/ S1, final /*const*/ S2Ty /*&*/ S2) {
//  return /*delegate*/org.llvm.adt.impl.SetOperationsLlvmGlobals.
//    set_union(S1, S2);
//}
//
//
///// set_intersect(A, B) - Compute A := A ^ B
///// Identical to set_intersection, except that it works on set<>'s and
///// is nicer to use.  Functionally, this iterates through S1, removing
///// elements that are not contained in S2.
/////
///*template <class S1Ty, class S2Ty> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::set_intersect">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", line = 40,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", old_line = 39,
// FQN="llvm::set_intersect", NM="Tpl__ZN4llvm13set_intersectERT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp -nm=Tpl__ZN4llvm13set_intersectERT_RKT0_")
////</editor-fold>
//public static </*class*/ S1Ty, /*class*/ S2Ty> void set_intersect(final S1Ty /*&*/ S1, final /*const*/ S2Ty /*&*/ S2) {
//  /*delegate*/org.llvm.adt.impl.SetOperationsLlvmGlobals.
//    set_intersect(S1, S2);
//}
//
//
///// set_difference(A, B) - Return A - B
/////
///*template <class S1Ty, class S2Ty> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::set_difference">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", line = 51,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", old_line = 50,
// FQN="llvm::set_difference", NM="Tpl__ZN4llvm14set_differenceERKT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp -nm=Tpl__ZN4llvm14set_differenceERKT_RKT0_")
////</editor-fold>
//public static </*class*/ S1Ty, /*class*/ S2Ty> S1Ty set_difference(final /*const*/ S1Ty /*&*/ S1, final /*const*/ S2Ty /*&*/ S2) {
//  return /*delegate*/org.llvm.adt.impl.SetOperationsLlvmGlobals.
//    set_difference(S1, S2);
//}
//
//
///// set_subtract(A, B) - Compute A := A - B
/////
///*template <class S1Ty, class S2Ty> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::set_subtract">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", line = 63,
// old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetOperations.h", old_line = 62,
// FQN="llvm::set_subtract", NM="Tpl__ZN4llvm12set_subtractERT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp -nm=Tpl__ZN4llvm12set_subtractERT_RKT0_")
////</editor-fold>
//public static </*class*/ S1Ty, /*class*/ S2Ty> void set_subtract(final S1Ty /*&*/ S1, final /*const*/ S2Ty /*&*/ S2) {
//  /*delegate*/org.llvm.adt.impl.SetOperationsLlvmGlobals.
//    set_subtract(S1, S2);
//}
//
//
///// \brief Enable the collection and printing of statistics.
////<editor-fold defaultstate="collapsed" desc="llvm::EnableStatistics">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 97,
// old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 90,
// FQN="llvm::EnableStatistics", NM="_ZN4llvm16EnableStatisticsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm16EnableStatisticsEv")
////</editor-fold>
//public static void EnableStatistics() {
//  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
//    EnableStatistics();
//}
//
//
///// \brief Check if statistics are enabled.
////<editor-fold defaultstate="collapsed" desc="llvm::AreStatisticsEnabled">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 101,
// old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 94,
// FQN="llvm::AreStatisticsEnabled", NM="_ZN4llvm20AreStatisticsEnabledEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm20AreStatisticsEnabledEv")
////</editor-fold>
//public static boolean AreStatisticsEnabled() {
//  return /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
//    AreStatisticsEnabled();
//}
//
//
///// \brief Print statistics to the file returned by CreateInfoOutputFile().
////<editor-fold defaultstate="collapsed" desc="llvm::PrintStatistics">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 180,
// old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 137,
// FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsEv")
////</editor-fold>
//public static void PrintStatistics() {
//  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
//    PrintStatistics();
//}
//
//
///// \brief Print statistics to the given output stream.
////<editor-fold defaultstate="collapsed" desc="llvm::PrintStatistics">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 118,
// old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 98,
// FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE")
////</editor-fold>
//public static void PrintStatistics(final raw_ostream /*&*/ OS) {
//  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
//    PrintStatistics(OS);
//}
//
//
///// Print statistics in JSON format.
////<editor-fold defaultstate="collapsed" desc="llvm::PrintStatisticsJSON">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 159,
// FQN="llvm::PrintStatisticsJSON", NM="_ZN4llvm19PrintStatisticsJSONERNS_11raw_ostreamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm19PrintStatisticsJSONERNS_11raw_ostreamE")
////</editor-fold>
//public static void PrintStatisticsJSON(final raw_ostream /*&*/ OS) {
//  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
//    PrintStatisticsJSON(OS);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::getNonStreamedMemoryObject">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 127,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", old_line = 121,
 FQN="llvm::getNonStreamedMemoryObject", NM="_ZN4llvm26getNonStreamedMemoryObjectEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm26getNonStreamedMemoryObjectEPKhS1_")
//</editor-fold>
public static MemoryObject /*P*/ getNonStreamedMemoryObject(/*const*/char$ptr/*uchar P*/ Start, 
                          /*const*/char$ptr/*uchar P*/ End) {
  return /*delegate*/org.llvm.support.impl.StreamingMemoryObjectLlvmGlobals.
    getNonStreamedMemoryObject(Start, 
                          End);
}


///// StrInStrNoCase - Portable version of strcasestr.  Locates the first
///// occurrence of string 's1' in string 's2', ignoring case.  Returns
///// the offset of s2 in s1 or npos if s2 cannot be found.
//
///// StrInStrNoCase - Portable version of strcasestr.  Locates the first
///// occurrence of string 's1' in string 's2', ignoring case.  Returns
///// the offset of s2 in s1 or npos if s2 cannot be found.
////<editor-fold defaultstate="collapsed" desc="llvm::StrInStrNoCase">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 21,
// FQN="llvm::StrInStrNoCase", NM="_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_")
////</editor-fold>
//public static /*size_t*/int StrInStrNoCase(StringRef s1, StringRef s2) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    StrInStrNoCase(s1, s2);
//}
//
//
///// getToken - This function extracts one token from source, ignoring any
///// leading characters that appear in the Delimiters string, and ending the
///// token at any of the characters that appear in the Delimiters string.  If
///// there are no tokens in the source string, an empty string is returned.
///// The function returns a pair containing the extracted token and the
///// remaining tail string.
//
///// getToken - This function extracts one token from source, ignoring any
///// leading characters that appear in the Delimiters string, and ending the
///// token at any of the characters that appear in the Delimiters string.  If
///// there are no tokens in the source string, an empty string is returned.
///// The function returns a pair containing the extracted token and the
///// remaining tail string.
////<editor-fold defaultstate="collapsed" desc="llvm::getToken">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 37,
// FQN="llvm::getToken", NM="_ZN4llvm8getTokenENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm8getTokenENS_9StringRefES0_")
////</editor-fold>
//public static std.pair<StringRef, StringRef> getToken(StringRef Source) {
//  return getToken(Source, 
//        new StringRef(/*KEEP_STR*/" \t\n\013\014\015"));
//}
//public static std.pair<StringRef, StringRef> getToken(StringRef Source, 
//        StringRef Delimiters/*= " \t\n\013\014\015"*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    getToken(Source, 
//        Delimiters);
//}
//
//
///// SplitString - Split up the specified string according to the specified
///// delimiters, appending the result fragments to the output list.
//
///// SplitString - Split up the specified string according to the specified
///// delimiters, appending the result fragments to the output list.
////<editor-fold defaultstate="collapsed" desc="llvm::SplitString">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 50,
// FQN="llvm::SplitString", NM="_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_")
////</editor-fold>
//public static void SplitString(StringRef Source, 
//           final SmallVectorImpl<StringRef> /*&*/ OutFragments) {
//  SplitString(Source, 
//           OutFragments, 
//           new StringRef(/*KEEP_STR*/" \t\n\013\014\015"));
//}
//public static void SplitString(StringRef Source, 
//           final SmallVectorImpl<StringRef> /*&*/ OutFragments, 
//           StringRef Delimiters/*= " \t\n\013\014\015"*/) {
//  /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    SplitString(Source, 
//           OutFragments, 
//           Delimiters);
//}
//
//
///// Helper functions for StringRef::getAsInteger.
//
///// GetAsUnsignedInteger - Workhorse method that converts a integer character
///// sequence of radix up to 36 to an unsigned long long value.
////<editor-fold defaultstate="collapsed" desc="llvm::getAsUnsignedInteger">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 378,
// FQN="llvm::getAsUnsignedInteger", NM="_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy")
////</editor-fold>
//public static boolean getAsUnsignedInteger(StringRef Str, /*uint*/int Radix, 
//                    final ullong$ref/*ullong &*/ Result) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    getAsUnsignedInteger(Str, Radix, 
//                    Result);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::getAsSignedInteger">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 419,
// FQN="llvm::getAsSignedInteger", NM="_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx")
////</editor-fold>
//public static boolean getAsSignedInteger(StringRef Str, /*uint*/int Radix, 
//                  final llong$ref/*llong &*/ Result) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    getAsSignedInteger(Str, Radix, 
//                  Result);
//}
//
//
///// @}
//
///// \brief Compute a hash_code for a StringRef.
//
//// Implementation of StringRef hashing.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 522,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueENS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm10hash_valueENS_9StringRefE")
////</editor-fold>
//public static hash_code hash_value(StringRef S) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    hash_value(S);
//}
//
//
///// Determine if the raw_ostream provided is connected to a terminal. If so,
///// generate a warning message to errs() advising against display of bitcode
///// and return true. Otherwise just return false.
///// @brief Check for output written to a console
////<editor-fold defaultstate="collapsed" desc="llvm::CheckBitcodeOutputToConsole">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/SystemUtils.cpp", line = 19,
// FQN="llvm::CheckBitcodeOutputToConsole", NM="_ZN4llvm27CheckBitcodeOutputToConsoleERNS_11raw_ostreamEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/SystemUtils.cpp -nm=_ZN4llvm27CheckBitcodeOutputToConsoleERNS_11raw_ostreamEb")
////</editor-fold>
//public static boolean CheckBitcodeOutputToConsole(final raw_ostream /*&*/ stream_to_check) {
//  return CheckBitcodeOutputToConsole(stream_to_check, 
//                           true);
//}
//public static boolean CheckBitcodeOutputToConsole(final raw_ostream /*&*/ stream_to_check, 
//                           boolean print_warning/*= true*/) {
//  return /*delegate*/org.llvm.support.impl.SystemUtilsLlvmGlobals.
//    CheckBitcodeOutputToConsole(stream_to_check, 
//                           print_warning);
//}

/// Returns true if LLVM is compiled with support for multi-threading, and
/// false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_is_multithreaded">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", line = 24,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", old_line = 23,
 FQN="llvm::llvm_is_multithreaded", NM="_ZN4llvm21llvm_is_multithreadedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=_ZN4llvm21llvm_is_multithreadedEv")
//</editor-fold>
public static boolean llvm_is_multithreaded() {
  return /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
    llvm_is_multithreaded();
}


/// llvm_execute_on_thread - Execute the given \p UserFn on a separate
/// thread, passing it the provided \p UserData and waits for thread
/// completion.
///
/// This function does not guarantee that the code will actually be executed
/// on a separate thread or honoring the requested stack size, but tries to do
/// so where system support is available.
///
/// \param UserFn - The callback to execute.
/// \param UserData - An argument to pass to the callback function.
/// \param RequestedStackSize - If non-zero, a requested size (in bytes) for
/// the thread stack.
//<editor-fold defaultstate="collapsed" desc="llvm::llvm_execute_on_thread">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", line = 45,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", old_line = 44,
 FQN="llvm::llvm_execute_on_thread", NM="_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j")
//</editor-fold>
public static void llvm_execute_on_thread(VoidPtr2Void Fn, Object/*void P*/ UserData) {
  llvm_execute_on_thread(Fn, UserData, 
                      0);
}
public static void llvm_execute_on_thread(VoidPtr2Void Fn, Object/*void P*/ UserData, 
                      /*uint*/int RequestedStackSize/*= 0*/) {
  /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
    llvm_execute_on_thread(Fn, UserData, 
                      RequestedStackSize);
}
//
//
///// \brief Return a file stream to print our output on.
//
//// Return a file stream to print our output on.
////<editor-fold defaultstate="collapsed" desc="llvm::CreateInfoOutputFile">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/Timer.cpp", line = 54,
// FQN="llvm::CreateInfoOutputFile", NM="_ZN4llvm20CreateInfoOutputFileEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Timer.cpp -nm=_ZN4llvm20CreateInfoOutputFileEv")
////</editor-fold>
//public static std.unique_ptr<raw_fd_ostream> CreateInfoOutputFile() {
//  return /*delegate*/org.llvm.adt.impl.TimerLlvmGlobals.
//    CreateInfoOutputFile();
//}
//
//
///// \brief Construct a new Win COFF writer instance.
/////
///// \param MOTW - The target specific WinCOFF writer subclass.
///// \param OS - The stream to write to.
///// \returns The constructed object writer.
//
////------------------------------------------------------------------------------
//// WinCOFFObjectWriter factory function
////<editor-fold defaultstate="collapsed" desc="llvm::createWinCOFFObjectWriter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp", line = 1097,
// old_source = "${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp", old_line = 1088,
// FQN="llvm::createWinCOFFObjectWriter", NM="_ZN4llvm25createWinCOFFObjectWriterEPNS_27MCWinCOFFObjectTargetWriterERNS_17raw_pwrite_streamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm25createWinCOFFObjectWriterEPNS_27MCWinCOFFObjectTargetWriterERNS_17raw_pwrite_streamE")
////</editor-fold>
//public static MCObjectWriter /*P*/ createWinCOFFObjectWriter(MCWinCOFFObjectTargetWriter /*P*/ MOTW, 
//                         final raw_pwrite_stream /*&*/ OS) {
//  return /*delegate*/org.llvm.mc.impl.WinCOFFObjectWriterLlvmGlobals.
//    createWinCOFFObjectWriter(MOTW, 
//                         OS);
//}

/// InitializeAllTargetInfos - The main program should call this function if
/// it wants access to all available targets that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetInfos">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 53,
 FQN="llvm::InitializeAllTargetInfos", NM="_ZN4llvm24InitializeAllTargetInfosEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm24InitializeAllTargetInfosEv")
//</editor-fold>
public static /*inline*/ void InitializeAllTargetInfos() {
  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
    InitializeAllTargetInfos();
}


/// InitializeAllTargets - The main program should call this function if it
/// wants access to all available target machines that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargets">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 63,
 FQN="llvm::InitializeAllTargets", NM="_ZN4llvm20InitializeAllTargetsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm20InitializeAllTargetsEv")
//</editor-fold>
public static /*inline*/ void InitializeAllTargets() {
  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
    InitializeAllTargets();
}


///// InitializeAllTargetMCs - The main program should call this function if it
///// wants access to all available target MC that LLVM is configured to
///// support, to make them available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetMCs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 76,
// FQN="llvm::InitializeAllTargetMCs", NM="_ZN4llvm22InitializeAllTargetMCsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm22InitializeAllTargetMCsEv")
////</editor-fold>
//public static /*inline*/ void InitializeAllTargetMCs() {
//  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeAllTargetMCs();
//}
//
//
///// InitializeAllAsmPrinters - The main program should call this function if
///// it wants all asm printers that LLVM is configured to support, to make them
///// available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllAsmPrinters">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 86,
// FQN="llvm::InitializeAllAsmPrinters", NM="_ZN4llvm24InitializeAllAsmPrintersEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm24InitializeAllAsmPrintersEv")
////</editor-fold>
//public static /*inline*/ void InitializeAllAsmPrinters() {
//  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeAllAsmPrinters();
//}
//
//
///// InitializeAllAsmParsers - The main program should call this function if it
///// wants all asm parsers that LLVM is configured to support, to make them
///// available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllAsmParsers">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 96,
// FQN="llvm::InitializeAllAsmParsers", NM="_ZN4llvm23InitializeAllAsmParsersEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm23InitializeAllAsmParsersEv")
////</editor-fold>
//public static /*inline*/ void InitializeAllAsmParsers() {
//  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeAllAsmParsers();
//}
//
//
///// InitializeAllDisassemblers - The main program should call this function if
///// it wants all disassemblers that LLVM is configured to support, to make
///// them available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllDisassemblers">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 106,
// FQN="llvm::InitializeAllDisassemblers", NM="_ZN4llvm26InitializeAllDisassemblersEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm26InitializeAllDisassemblersEv")
////</editor-fold>
//public static /*inline*/ void InitializeAllDisassemblers() {
//  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeAllDisassemblers();
//}
//
//
///// InitializeNativeTarget - The main program should call this function to
///// initialize the native target corresponding to the host.  This is useful
///// for JIT applications to ensure that the target gets linked in correctly.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTarget">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 116,
// FQN="llvm::InitializeNativeTarget", NM="_ZN4llvm22InitializeNativeTargetEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm22InitializeNativeTargetEv")
////</editor-fold>
//public static /*inline*/ boolean InitializeNativeTarget() {
//  return /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeNativeTarget();
//}
//
//
///// InitializeNativeTargetAsmPrinter - The main program should call
///// this function to initialize the native target asm printer.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTargetAsmPrinter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 130,
// FQN="llvm::InitializeNativeTargetAsmPrinter", NM="_ZN4llvm32InitializeNativeTargetAsmPrinterEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm32InitializeNativeTargetAsmPrinterEv")
////</editor-fold>
//public static /*inline*/ boolean InitializeNativeTargetAsmPrinter() {
//  return /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeNativeTargetAsmPrinter();
//}
//
//
///// InitializeNativeTargetAsmParser - The main program should call
///// this function to initialize the native target asm parser.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTargetAsmParser">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 142,
// FQN="llvm::InitializeNativeTargetAsmParser", NM="_ZN4llvm31InitializeNativeTargetAsmParserEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm31InitializeNativeTargetAsmParserEv")
////</editor-fold>
//public static /*inline*/ boolean InitializeNativeTargetAsmParser() {
//  return /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeNativeTargetAsmParser();
//}
//
//
///// InitializeNativeTargetDisassembler - The main program should call
///// this function to initialize the native target disassembler.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTargetDisassembler">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 154,
// FQN="llvm::InitializeNativeTargetDisassembler", NM="_ZN4llvm34InitializeNativeTargetDisassemblerEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm34InitializeNativeTargetDisassemblerEv")
////</editor-fold>
//public static /*inline*/ boolean InitializeNativeTargetDisassembler() {
//  return /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeNativeTargetDisassembler();
//}
//
//
/// This returns a reference to a raw_ostream for standard output. Use it like:
/// outs() << "foo" << "bar";

////===----------------------------------------------------------------------===//
////  outs(), errs(), nulls()
////===----------------------------------------------------------------------===//
//
///// outs() - This returns a reference to a raw_ostream for standard output.
///// Use it like: outs() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::outs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 718,
// old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 720,
// FQN="llvm::outs", NM="_ZN4llvm4outsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4outsEv")
////</editor-fold>
//public static raw_ostream /*&*/ outs() {
//  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
//    outs();
//}
//
//
///// This returns a reference to a raw_ostream for standard error. Use it like:
///// errs() << "foo" << "bar";
//
///// errs() - This returns a reference to a raw_ostream for standard error.
///// Use it like: errs() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::errs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 731,
// old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 732,
// FQN="llvm::errs", NM="_ZN4llvm4errsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4errsEv")
////</editor-fold>
//public static raw_ostream /*&*/ errs() {
//  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
//    errs();
//}
//
//
///// This returns a reference to a raw_ostream which simply discards output.
//
///// nulls() - This returns a reference to a raw_ostream which discards output.
////<editor-fold defaultstate="collapsed" desc="llvm::nulls">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 738,
// old_source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", old_line = 739,
// FQN="llvm::nulls", NM="_ZN4llvm5nullsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm5nullsEv")
////</editor-fold>
//public static raw_ostream /*&*/ nulls() {
//  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
//    nulls();
//}

} // END OF class AdtsupportLlvmGlobals
