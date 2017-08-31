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

package org.llvm.adt;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.support.FormattedNumber;
import org.llvm.support.FormattedString;


//<editor-fold defaultstate="collapsed" desc="static type LlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp ${LLVM_SRC}/llvm/lib/Support/APInt.cpp ${LLVM_SRC}/llvm/lib/Support/APSInt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp ${LLVM_SRC}/llvm/lib/Support/DataStream.cpp ${LLVM_SRC}/llvm/lib/Support/Debug.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp ${LLVM_SRC}/llvm/lib/Support/FileUtilities.cpp ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp ${LLVM_SRC}/llvm/lib/Support/Host.cpp ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp ${LLVM_SRC}/llvm/lib/Support/IsInf.cpp ${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp ${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCCodeGenInfo.cpp ${LLVM_SRC}/llvm/lib/MC/MCELF.cpp ${LLVM_SRC}/llvm/lib/MC/MCELFStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCSection.cpp ${LLVM_SRC}/llvm/lib/MC/MCSymbol.cpp ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp ${LLVM_SRC}/llvm/lib/Support/MD5.cpp ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp ${LLVM_SRC}/llvm/lib/Support/MemoryBuffer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp ${LLVM_SRC}/llvm/lib/Support/Path.cpp ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp ${LLVM_SRC}/llvm/lib/Support/Program.cpp ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp ${LLVM_SRC}/llvm/lib/Support/SmallVector.cpp ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp ${LLVM_SRC}/llvm/lib/Support/SystemUtils.cpp ${LLVM_SRC}/llvm/lib/Support/Threading.cpp ${LLVM_SRC}/llvm/lib/Support/Twine.cpp ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm10hash_valueERKNS_7APFloatE;_ZN4llvm6scalbnENS_7APFloatEi;_ZN4llvm3absENS_7APFloatE;_ZN4llvm6minnumERKNS_7APFloatES2_;_ZN4llvm6maxnumERKNS_7APFloatES2_;_ZN4llvmL13host_char_bitE;_ZN4llvmL16integerPartWidthE;_ZN4llvmeqEmRKNS_5APIntE;_ZN4llvmneEmRKNS_5APIntE;_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE;_ZN4llvm10hash_valueERKNS_5APIntE;_ZN4llvmeqElRKNS_6APSIntE;_ZN4llvmneElRKNS_6APSIntE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6APSIntE;_ZN4llvm12makeArrayRefERKT_;_ZN4llvm12makeArrayRefEPKT_m;_ZN4llvm12makeArrayRefEPKT_S2_;_ZN4llvm12makeArrayRefERKNS_15SmallVectorImplIT_EE;_ZN4llvm12makeArrayRefERKNS_11SmallVectorIT_XT0_EEE;_ZN4llvm12makeArrayRefERKSt6vectorIT_SaIS1_EE;_ZN4llvm12makeArrayRefERAT0__KT_;_ZN4llvmeqENS_8ArrayRefIT_EES2_;_ZN4llvmneENS_8ArrayRefIT_EES2_;_ZN4llvmL17capacity_in_bytesERKNS_8DenseMapIT_T0_T1_NS_6detail12DenseMapPairIS1_S2_EEEE;_ZN4llvm8df_beginERKT_;_ZN4llvm6df_endERKT_;_ZN4llvm11depth_firstERKT_;_ZN4llvm12df_ext_beginERKT_RT0_;_ZN4llvm10df_ext_endERKT_RT0_;_ZN4llvm15depth_first_extERKT_RT0_;_ZN4llvm9idf_beginERKT_;_ZN4llvm7idf_endERKT_;_ZN4llvm19inverse_depth_firstERKT_;_ZN4llvm13idf_ext_beginERKT_RT0_;_ZN4llvm11idf_ext_endERKT_RT0_;_ZN4llvm23inverse_depth_first_extERKT_RT0_;_ZN4llvm10hash_valueET_;_ZN4llvm10hash_valueEPKT_;_ZN4llvm10hash_valueERKSt4pairIT_T0_E;_ZN4llvm10hash_valueERKSbIT_St11char_traitsIS0_ESaIS0_EE;_ZN4llvm29set_fixed_execution_hash_seedEm;_ZN4llvm18hash_combine_rangeET_S0_;_ZN4llvm12hash_combineEDpRKT_;_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE;_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE;_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEPT0_;_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEPT0_;_ZN4llvmeqEPT_RKNS_18IntrusiveRefCntPtrIT0_EE;_ZN4llvmneEPT_RKNS_18IntrusiveRefCntPtrIT0_EE;_ZN4llvmeqEDnRKNS_18IntrusiveRefCntPtrIT_EE;_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEDn;_ZN4llvmneEDnRKNS_18IntrusiveRefCntPtrIT_EE;_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEDn;_ZN4llvmeqENS_12PointerUnionIT_T0_EES3_;_ZN4llvmneENS_12PointerUnionIT_T0_EES3_;_ZN4llvm8po_beginET_;_ZN4llvm6po_endET_;_ZN4llvm12po_ext_beginET_RT0_;_ZN4llvm10po_ext_endET_RT0_;_ZN4llvm9ipo_beginET_b;_ZN4llvm7ipo_endET_;_ZN4llvm13ipo_ext_beginET_RT0_;_ZN4llvm11ipo_ext_endET_RT0_;_ZN4llvm7deleterEPT_;_ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_;_ZN4llvm12map_iteratorERKT_T0_;_ZN4llvm14array_lengthofERAT0__T_;_ZN4llvm25array_pod_sort_comparatorEPKvS1_;_ZN4llvm29get_array_pod_sort_comparatorERKT_;_ZN4llvm14array_pod_sortET_S0_;_ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E;_ZN4llvm23DeleteContainerPointersERT_;_ZN4llvm22DeleteContainerSecondsERT_;_ZN4llvm11make_uniqueEDpOT0_;_ZN4llvm11make_uniqueEm;_ZN4llvmanERKNS_14SmallBitVectorES2_;_ZN4llvmorERKNS_14SmallBitVectorES2_;_ZN4llvmeoERKNS_14SmallBitVectorES2_;_ZN4llvmL17capacity_in_bytesERKNS_11SmallVectorIT_XT0_EEE;_ZN4llvm16EnableStatisticsEv;_ZN4llvm20AreStatisticsEnabledEv;_ZN4llvm15PrintStatisticsEv;_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE;_ZN4llvmL8hexdigitEjb;_ZN4llvmL11toStringRefEb;_ZN4llvmL13hexDigitValueEc;_ZN4llvmL13utohex_bufferET_Pcb;_ZN4llvmL9utohexstrEmb;_ZN4llvmL9utostr_32Ejb;_ZN4llvmL6utostrEmb;_ZN4llvmL6itostrEl;_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_;_ZN4llvm8getTokenENS_9StringRefES0_;_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_;_ZN4llvmL10HashStringENS_9StringRefEj;_ZN4llvmL16getOrdinalSuffixEj;_ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag;_ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag;_ZN4llvm4joinET_S0_NS_9StringRefE;_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy;_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx;_ZN4llvmeqENS_9StringRefES0_;_ZN4llvmneENS_9StringRefES0_;_ZN4llvmltENS_9StringRefES0_;_ZN4llvmleENS_9StringRefES0_;_ZN4llvmgtENS_9StringRefES0_;_ZN4llvmgeENS_9StringRefES0_;_ZN4llvmpLERSsNS_9StringRefE;_ZN4llvm10hash_valueENS_9StringRefE;_ZN4llvmplERKNS_5TwineES2_;_ZN4llvmplEPKcRKNS_9StringRefE;_ZN4llvmplERKNS_9StringRefEPKc;_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE;_ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj;_ZN4llvmneEPKT_RKNS_14ilist_iteratorIS1_EE;_ZN4llvmeqEPKT_RKNS_14ilist_iteratorIS1_EE;_ZN4llvmneEPT_RKNS_14ilist_iteratorIS0_EE;_ZN4llvmeqEPT_RKNS_14ilist_iteratorIS0_EE;_ZN4llvm10make_rangeET_S0_;_ZN4llvm10make_rangeESt4pairIT_S1_E;_ZN4llvm21createELFObjectWriterEPNS_23MCELFObjectTargetWriterERNS_11raw_ostreamEb;_Z4llvm_MCELFSymbolFlags_h_Unnamed_enum;_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCExprE;_ZN4llvmlsERNS_11raw_ostreamERKNS_9MCOperandE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCInstE;_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCLabelE;_ZN4llvmL18MCLOHDirectiveNameEv;_ZN4llvmL16isValidMCLOHTypeEj;_ZN4llvmL13MCLOHNameToIdENS_9StringRefE;_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE;_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE;_ZN4llvm22createMachObjectWriterEPNS_24MCMachObjectTargetWriterERNS_11raw_ostreamEb;_ZN4llvm19createMachOStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_11raw_ostreamEPNS_13MCCodeEmitterEbb;_ZN4llvm17createELFStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_11raw_ostreamEPNS_13MCCodeEmitterEb;_ZN4llvmlsERNS_11raw_ostreamERKNS_8MCSymbolE;_ZN4llvmL20AsmRewritePrecedenceE;_ZN4llvmeqERKNS_15MCTargetOptionsES2_;_ZN4llvmneERKNS_15MCTargetOptionsES2_;_ZN4llvm25createWinCOFFObjectWriterEPNS_27MCWinCOFFObjectTargetWriterERNS_11raw_ostreamE;_ZN4llvmneERKNS_15MachineLocationES2_;_ZN4llvm7alignOfEv;_ZN4llvmlsERNS_11raw_ostreamERKNS_17BranchProbabilityE;_ZN4llvmL17capacity_in_bytesERKT_;_ZN4llvm3isaERKT0_;_ZN4llvm4castERKT0_;_ZN4llvm4castERT0_;_ZN4llvm4castEPT0_;_ZN4llvm12cast_or_nullERKT0_;_ZN4llvm12cast_or_nullERT0_;_ZN4llvm12cast_or_nullEPT0_;_ZN4llvm8dyn_castERKT0_;_ZN4llvm8dyn_castERT0_;_ZN4llvm8dyn_castEPT0_;_ZN4llvm16dyn_cast_or_nullERKT0_;_ZN4llvm16dyn_cast_or_nullERT0_;_ZN4llvm16dyn_cast_or_nullEPT0_;_ZN4llvm6unwrapE13LLVMCodeModel;_ZN4llvm4wrapENS_9CodeModel5ModelE;_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh;_ZN4llvm22ConvertCodePointToUTF8EjRPc;_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags;_ZN4llvm21hasUTF16ByteOrderMarkENS_8ArrayRefIcEE;_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs;_ZN4llvm19getDataFileStreamerERKSsPSs;_ZN4llvm9DebugFlagE;_ZN4llvm18isCurrentDebugTypeEPKc;_ZN4llvm19setCurrentDebugTypeEPKc;_ZN4llvm20EnableDebugBufferingE;_ZN4llvm4dbgsEv;_ZN4llvm15make_error_codeENS_4errcE;_ZN4llvm27install_fatal_error_handlerEPFvPvRKSsbES0_;_ZN4llvm26remove_fatal_error_handlerEv;_ZN4llvm18report_fatal_errorEPKcb;_ZN4llvm18report_fatal_errorERKSsb;_ZN4llvm18report_fatal_errorENS_9StringRefEb;_ZN4llvm18report_fatal_errorERKNS_5TwineEb;_ZN4llvm25llvm_unreachable_internalEPKcS1_j;_ZN4llvm23moveIfMoveConstructibleERT0_;_ZN4llvmeqERNS_7ErrorOrIT_EET0_;_ZN4llvm22DiffFilesWithToleranceENS_9StringRefES0_ddPSs;_ZN4llvm6formatEPKcRKT_;_ZN4llvm6formatEPKcRKT_RKT0_;_ZN4llvm6formatEPKcRKT_RKT0_RKT1_;_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_;_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_RKT3_;_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_RKT3_RKT4_;_ZN4llvm12left_justifyENS_9StringRefEj;_ZN4llvm13right_justifyENS_9StringRefEj;_ZN4llvm10format_hexEmjb;_ZN4llvm14format_decimalElj;_ZN4llvm5foutsEv;_ZN4llvm5ferrsEv;_ZN4llvm5fdbgsEv;_ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE;_ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj;_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE;_ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE;_ZN4llvm19createGraphFilenameERKNS_5TwineERi;_ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_;_ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE;_ZN4llvm13encodeSLEB128ElRNS_11raw_ostreamE;_ZN4llvm13encodeULEB128EmRNS_11raw_ostreamEj;_ZN4llvm13encodeULEB128EmPhj;_ZN4llvm13decodeULEB128EPKhPj;_ZN4llvm13decodeSLEB128EPKhPj;_ZN4llvm14getULEB128SizeEm;_ZN4llvm14getSLEB128SizeEl;_ZN4llvm14object_creatorEv;_ZN4llvm13llvm_shutdownEv;_ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE;_ZN4llvm18countTrailingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE;_ZN4llvm18countTrailingZerosImEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE;_ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE;_ZN4llvm17countLeadingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE;_ZN4llvm17countLeadingZerosImEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE;_ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE;_ZN4llvm11findLastSetET_NS_12ZeroBehaviorE;_ZN4llvmL18BitReverseTable256E;_ZN4llvm11reverseBitsET_;_ZN4llvm5Hi_32Em;_ZN4llvm5Lo_32Em;_ZN4llvm7Make_64Ejj;_ZN4llvm5isIntEl;_ZN4llvm5isIntILj8EEEbl;_ZN4llvm5isIntILj16EEEbl;_ZN4llvm5isIntILj32EEEbl;_ZN4llvm12isShiftedIntEl;_ZN4llvm6isUIntEm;_ZN4llvm6isUIntILj8EEEbm;_ZN4llvm6isUIntILj16EEEbm;_ZN4llvm6isUIntILj32EEEbm;_ZN4llvm13isShiftedUIntEm;_ZN4llvm7isUIntNEjm;_ZN4llvm6isIntNEjl;_ZN4llvm9isMask_32Ej;_ZN4llvm9isMask_64Em;_ZN4llvm16isShiftedMask_32Ej;_ZN4llvm16isShiftedMask_64Em;_ZN4llvm13isPowerOf2_32Ej;_ZN4llvm13isPowerOf2_64Em;_ZN4llvm11ByteSwap_16Et;_ZN4llvm11ByteSwap_32Ej;_ZN4llvm11ByteSwap_64Em;_ZN4llvm19CountLeadingOnes_32Ej;_ZN4llvm19CountLeadingOnes_64Em;_ZN4llvm20CountTrailingOnes_32Ej;_ZN4llvm20CountTrailingOnes_64Em;_ZN4llvm18CountPopulation_32Ej;_ZN4llvm18CountPopulation_64Em;_ZN4llvm7Log2_32Ej;_ZN4llvm7Log2_64Em;_ZN4llvm12Log2_32_CeilEj;_ZN4llvm12Log2_64_CeilEm;_ZN4llvm23GreatestCommonDivisor64Emm;_ZN4llvm12BitsToDoubleEm;_ZN4llvm11BitsToFloatEj;_ZN4llvm12DoubleToBitsEd;_ZN4llvm11FloatToBitsEf;_ZN4llvm5IsNANEf;_ZN4llvm5IsNANEd;_ZN4llvm5IsInfEf;_ZN4llvm5IsInfEd;_ZN4llvm8MinAlignEmm;_ZN4llvm9alignAddrEPvm;_ZN4llvm19alignmentAdjustmentEPvm;_ZN4llvm12NextPowerOf2Em;_ZN4llvm13PowerOf2FloorEm;_ZN4llvm18RoundUpToAlignmentEmm;_ZN4llvm17OffsetToAlignmentEmm;_ZN4llvm5abs64El;_ZN4llvm12SignExtend32Ej;_ZN4llvm12SignExtend32Ejj;_ZN4llvm12SignExtend64Em;_ZN4llvm12SignExtend64Emj;_ZN4llvm9huge_valfE;_ZN4llvm6unwrapEP22LLVMOpaqueMemoryBuffer;_ZN4llvm4wrapEPKNS_12MemoryBufferE;_ZN4llvm22EnablePrettyStackTraceEv;_ZN4llvm18PrintRecyclerStatsEmmm;_ZN4llvmplERKNS_12ScaledNumberIT_EES4_;_ZN4llvmmiERKNS_12ScaledNumberIT_EES4_;_ZN4llvmmlERKNS_12ScaledNumberIT_EES4_;_ZN4llvmdvERKNS_12ScaledNumberIT_EES4_;_ZN4llvmlsERKNS_12ScaledNumberIT_EES4_;_ZN4llvmrsERKNS_12ScaledNumberIT_EES4_;_ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE;_ZN4llvmltERKNS_12ScaledNumberIT_EEm;_ZN4llvmltEmRKNS_12ScaledNumberIT_EE;_ZN4llvmltERKNS_12ScaledNumberIT_EEj;_ZN4llvmltEjRKNS_12ScaledNumberIT_EE;_ZN4llvmltERKNS_12ScaledNumberIT_EEl;_ZN4llvmltElRKNS_12ScaledNumberIT_EE;_ZN4llvmltERKNS_12ScaledNumberIT_EEi;_ZN4llvmltEiRKNS_12ScaledNumberIT_EE;_ZN4llvmgtERKNS_12ScaledNumberIT_EEm;_ZN4llvmgtEmRKNS_12ScaledNumberIT_EE;_ZN4llvmgtERKNS_12ScaledNumberIT_EEj;_ZN4llvmgtEjRKNS_12ScaledNumberIT_EE;_ZN4llvmgtERKNS_12ScaledNumberIT_EEl;_ZN4llvmgtElRKNS_12ScaledNumberIT_EE;_ZN4llvmgtERKNS_12ScaledNumberIT_EEi;_ZN4llvmgtEiRKNS_12ScaledNumberIT_EE;_ZN4llvmeqERKNS_12ScaledNumberIT_EEm;_ZN4llvmeqEmRKNS_12ScaledNumberIT_EE;_ZN4llvmeqERKNS_12ScaledNumberIT_EEj;_ZN4llvmeqEjRKNS_12ScaledNumberIT_EE;_ZN4llvmeqERKNS_12ScaledNumberIT_EEl;_ZN4llvmeqElRKNS_12ScaledNumberIT_EE;_ZN4llvmeqERKNS_12ScaledNumberIT_EEi;_ZN4llvmeqEiRKNS_12ScaledNumberIT_EE;_ZN4llvmneERKNS_12ScaledNumberIT_EEm;_ZN4llvmneEmRKNS_12ScaledNumberIT_EE;_ZN4llvmneERKNS_12ScaledNumberIT_EEj;_ZN4llvmneEjRKNS_12ScaledNumberIT_EE;_ZN4llvmneERKNS_12ScaledNumberIT_EEl;_ZN4llvmneElRKNS_12ScaledNumberIT_EE;_ZN4llvmneERKNS_12ScaledNumberIT_EEi;_ZN4llvmneEiRKNS_12ScaledNumberIT_EE;_ZN4llvmleERKNS_12ScaledNumberIT_EEm;_ZN4llvmleEmRKNS_12ScaledNumberIT_EE;_ZN4llvmleERKNS_12ScaledNumberIT_EEj;_ZN4llvmleEjRKNS_12ScaledNumberIT_EE;_ZN4llvmleERKNS_12ScaledNumberIT_EEl;_ZN4llvmleElRKNS_12ScaledNumberIT_EE;_ZN4llvmleERKNS_12ScaledNumberIT_EEi;_ZN4llvmleEiRKNS_12ScaledNumberIT_EE;_ZN4llvmgeERKNS_12ScaledNumberIT_EEm;_ZN4llvmgeEmRKNS_12ScaledNumberIT_EE;_ZN4llvmgeERKNS_12ScaledNumberIT_EEj;_ZN4llvmgeEjRKNS_12ScaledNumberIT_EE;_ZN4llvmgeERKNS_12ScaledNumberIT_EEl;_ZN4llvmgeElRKNS_12ScaledNumberIT_EE;_ZN4llvmgeERKNS_12ScaledNumberIT_EEi;_ZN4llvmgeEiRKNS_12ScaledNumberIT_EE;_ZN4llvm26getNonStreamedMemoryObjectEPKhS1_;_ZN4llvm27CheckBitcodeOutputToConsoleERNS_11raw_ostreamEb;_ZN4llvm18createNullStreamerERNS_9MCContextE;_ZN4llvm17createAsmStreamerERNS_9MCContextERNS_21formatted_raw_ostreamEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb;_ZN4llvm24InitializeAllTargetInfosEv;_ZN4llvm20InitializeAllTargetsEv;_ZN4llvm22InitializeAllTargetMCsEv;_ZN4llvm24InitializeAllAsmPrintersEv;_ZN4llvm23InitializeAllAsmParsersEv;_ZN4llvm26InitializeAllDisassemblersEv;_ZN4llvm22InitializeNativeTargetEv;_ZN4llvm32InitializeNativeTargetAsmPrinterEv;_ZN4llvm31InitializeNativeTargetAsmParserEv;_ZN4llvm34InitializeNativeTargetDisassemblerEv;_ZN4llvm21llvm_is_multithreadedEv;_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j;_ZN4llvm4outsEv;_ZN4llvm4errsEv;_ZN4llvm5nullsEv; -static-type=LlvmGlobals")
//</editor-fold>
public final class LlvmGlobals {

/// Provide wrappers to std::find which take ranges instead of having to pass
/// begin/end explicitly.
/*template <typename R, class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::find">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 385,
 FQN="llvm::find", NM="Tpl__ZN4llvm4findEOT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=Tpl__ZN4llvm4findEOT_RKT0_")
//</editor-fold>
public static <Iter extends type$iterator<?, _Tp>, _Tp> Iter find(NativeIterable<Iter>/*&&*/ Range, /*const*/ _Tp /*&*/ val) {
  return std.find(Range.begin(), Range.end(), val);
}
public static  <_Tp> type$iterator<?, _Tp> find(iterator_range<_Tp> /*&&*/ Range, /*const*/ _Tp /*&*/ val) {
  return std.find(Range.begin(), Range.end(), val);
}

//
///*template <class T> TEMPLATE*/
//
//// deleter - Very very very simple method that is used to invoke operator
//// delete on something.  It is used like this:
////
////   for_each(V.begin(), B.end(), deleter<Interval>);
////
////<editor-fold defaultstate="collapsed" desc="llvm::deleter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 204,
// FQN="llvm::deleter", NM="_ZN4llvm7deleterEPT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7deleterEPT_")
////</editor-fold>
//public static /*inline*/ </*class*/ T> void deleter(T /*P*/ Ptr) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    deleter(Ptr);
//}
//
///*template <class _Iterator, class Func> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 269,
// FQN="llvm::operator+", NM="_ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmplENS_15mapped_iteratorIT_T0_E15difference_typeERKS3_")
////</editor-fold>
//public static /*inline*/ </*class*/ _Iterator, /*class*/ Func> mapped_iterator<_Iterator, Func> $add_mapped_iterator<_Iterator, Func>.difference_type_mapped_iterator<_Iterator, Func>( mapped_iterator<_Iterator, Func>.difference_type N, 
//                                                                                       /*const*/ mapped_iterator<_Iterator, Func> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    $add_mapped_iterator<_Iterator, Func>.difference_type_mapped_iterator<_Iterator, Func>(N, 
//                                                                                       X);
//}
//
///*template <class ItTy, class FuncTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::map_iterator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 280,
// FQN="llvm::map_iterator", NM="_ZN4llvm12map_iteratorERKT_T0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12map_iteratorERKT_T0_")
////</editor-fold>
//public static /*inline*/ </*class*/ ItTy, /*class*/ FuncTy> mapped_iterator<ItTy, FuncTy> map_iterator(/*const*/ ItTy /*&*/ I, FuncTy F) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    map_iterator(I, F);
//}
//
///*template <class T, std::size_t N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::array_lengthof">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 310,
// FQN="llvm::array_lengthof", NM="_ZN4llvm14array_lengthofERAT0__T_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm14array_lengthofERAT0__T_")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*ulong*/long N> /*size_t*/int array_lengthof(T (/*&*/ $Prm0)[N]) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_lengthof($Prm0);
//}
//
///*template <typename T> TEMPLATE*/
//
///// Adapt std::less<T> for array_pod_sort.
////<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort_comparator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 316,
// FQN="llvm::array_pod_sort_comparator", NM="_ZN4llvm25array_pod_sort_comparatorEPKvS1_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm25array_pod_sort_comparatorEPKvS1_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> int array_pod_sort_comparator(/*const*/Object/*void P*/ P1, /*const*/Object/*void P*/ P2) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_pod_sort_comparator(P1, P2);
//}
//
///*template <typename T> TEMPLATE*/
//
///// get_array_pod_sort_comparator - This is an internal helper function used to
///// get type deduction of T right.
////<editor-fold defaultstate="collapsed" desc="llvm::get_array_pod_sort_comparator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 329,
// FQN="llvm::get_array_pod_sort_comparator", NM="_ZN4llvm29get_array_pod_sort_comparatorERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm29get_array_pod_sort_comparatorERKT_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> /*ADD MAPPING FOR[int (* )(const void * , const void * )]*/int (/*P*/ get_array_pod_sort_comparator(/*const*/ T /*&*/ $Prm0))(/*const*/Object/*void P*/ , /*const*/Object/*void P*/ ) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    get_array_pod_sort_comparator($Prm0);
//}
//
///*template <class IteratorTy> TEMPLATE*/
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
////<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 350,
// FQN="llvm::array_pod_sort", NM="_ZN4llvm14array_pod_sortET_S0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm14array_pod_sortET_S0_")
////</editor-fold>
//public static /*inline*/ </*class*/ IteratorTy> void array_pod_sort(IteratorTy Start, IteratorTy End) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_pod_sort(Start, End);
//}
//
///*template <class IteratorTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::array_pod_sort">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 358,
// FQN="llvm::array_pod_sort", NM="_ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm14array_pod_sortET_S0_PFiPKNSt15iterator_traitsIS0_E10value_typeES5_E")
////</editor-fold>
//public static /*inline*/ </*class*/ IteratorTy> void array_pod_sort(IteratorTy Start, IteratorTy End, 
//              Comparator<?> Compare) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    array_pod_sort(Start, End, 
//              Compare);
//}
//
///*template <typename Container> TEMPLATE*/
//
///// For a container of pointers, deletes the pointers and then clears the
///// container.
////<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerPointers">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 376,
// FQN="llvm::DeleteContainerPointers", NM="_ZN4llvm23DeleteContainerPointersERT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm23DeleteContainerPointersERT_")
////</editor-fold>
//public static </*typename*/ Container> void DeleteContainerPointers(Container /*&*/ C) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    DeleteContainerPointers(C);
//}
//
///*template <typename Container> TEMPLATE*/
//
///// In a container of pairs (usually a map) whose second element is a pointer,
///// deletes the second elements and then clears the container.
////<editor-fold defaultstate="collapsed" desc="llvm::DeleteContainerSeconds">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 385,
// FQN="llvm::DeleteContainerSeconds", NM="_ZN4llvm22DeleteContainerSecondsERT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm22DeleteContainerSecondsERT_")
////</editor-fold>
//public static </*typename*/ Container> void DeleteContainerSeconds(Container /*&*/ C) {
//  /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    DeleteContainerSeconds(C);
//}
//
///*template <class T, class ... Args> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 407,
// FQN="llvm::make_unique", NM="_ZN4llvm11make_uniqueEDpOT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11make_uniqueEDpOT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ /*...*/ Args>  std.enable_if<!std.is_array<T>.value, std.unique_ptr<T> >.type make_unique(Args /*&&*/args...) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    make_unique(args);
//}
//
///*template <class T> TEMPLATE*/
//
///// \brief Constructs a `new T[n]` with the given args and returns a
/////        `unique_ptr<T[]>` which owns the object.
/////
///// \param n size of the new array.
/////
///// Example:
/////
/////     auto p = make_unique<int[]>(2); // value-initializes the array with 0's.
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 421,
// FQN="llvm::make_unique", NM="_ZN4llvm11make_uniqueEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11make_uniqueEm")
////</editor-fold>
//public static </*class*/ T>  std.enable_if<std.is_array<T>.value && std.extent<T>.value == 0, std.unique_ptr<T> >.type make_unique(/*size_t*/int n) {
//  return /*delegate*/org.llvm.adt.impl.STLExtrasLlvmGlobals.
//    make_unique(n);
//}
//
///*template <class T, class ... Args> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_unique">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 429,
// FQN="llvm::make_unique", NM="_ZN4llvm11make_uniqueEDpOT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11make_uniqueEDpOT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ /*...*/ Args>  std.enable_if<std.extent<T>.value != 0>.type make_unique(Args /*&&*/$Prm0...) { throw new UnsupportedOperationException("Deleted");}
///*template <class T> TEMPLATE*/
//
///// \brief Convenience function for iterating over sub-ranges.
/////
///// This provides a bit of syntactic sugar to make using sub-ranges
///// in for loops a bit easier. Analogous to std::make_pair().
////<editor-fold defaultstate="collapsed" desc="llvm::make_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 47,
// FQN="llvm::make_range", NM="_ZN4llvm10make_rangeET_S0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10make_rangeET_S0_")
////</editor-fold>
//public static </*class*/ T> iterator_range<T> make_range(T x, T y) {
//  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
//    make_range(x, y);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::make_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 51,
// FQN="llvm::make_range", NM="_ZN4llvm10make_rangeESt4pairIT_S1_E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10make_rangeESt4pairIT_S1_E")
////</editor-fold>
//public static </*typename*/ T> iterator_range<T> make_range(std.pair<T, T> p) {
//  return /*delegate*/org.llvm.adt.impl.Iterator_rangeLlvmGlobals.
//    make_range(p);
//}
//
///*template <typename T> TEMPLATE*/
//
///// alignOf - A templated function that returns the minimum alignment of
/////  of a type.  This provides no extra functionality beyond the AlignOf
/////  class besides some cosmetic cleanliness.  Example usage:
/////  alignOf<int>() returns the alignment of an int.
////<editor-fold defaultstate="collapsed" desc="llvm::alignOf">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/AlignOf.h", line = 58,
// FQN="llvm::alignOf", NM="_ZN4llvm7alignOfEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7alignOfEv")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> /*uint*/int alignOf() {
//  return /*delegate*/org.llvm.support.impl.AlignOfLlvmGlobals.
//    alignOf();
//}
//
///*template <typename T> TEMPLATE*/
//
///// \brief Count number of 0's from the least significant bit to the most
/////   stopping at the first 1.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Width and ZB_Undefined are
/////   valid arguments.
////<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 46,
// FQN="llvm::countTrailingZeros", NM="_ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, std.size_t>.type countTrailingZeros(T Val) {
//  return countTrailingZeros(Val, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, std.size_t>.type countTrailingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    countTrailingZeros(Val, ZB);
//}
//
///*template <typename T> TEMPLATE*/
//
//// Disable signed.
////<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 73,
// FQN="llvm::countTrailingZeros", NM="_ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18countTrailingZerosET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && std.numeric_limits<T>.is_signed, std.size_t>.type countTrailingZeros(T $Prm0, ZeroBehavior $Prm1/*= ZB_Width*/) { throw new UnsupportedOperationException("Deleted");}
////<editor-fold defaultstate="collapsed" desc="llvm::countTrailingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 78,
// FQN="llvm::countTrailingZeros", NM="_ZN4llvm18countTrailingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18countTrailingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE")
////</editor-fold>
//public static /*inline*/ /*ulong*/long countTrailingZeros_uint32_t_ZeroBehavior(/*uint32_t*/int Val, ZeroBehavior ZB) {
//  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0) {
//    return 32;
//  }
//  return __builtin_ctz(Val);
//}
//
///*template <typename T> TEMPLATE*/
//
///// \brief Count number of 0's from the most significant bit to the least
/////   stopping at the first 1.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Width and ZB_Undefined are
/////   valid arguments.
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 117,
// FQN="llvm::countLeadingZeros", NM="_ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, std.size_t>.type countLeadingZeros(T Val) {
//  return countLeadingZeros(Val, ZeroBehavior.ZB_Width);
//}
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, std.size_t>.type countLeadingZeros(T Val, ZeroBehavior ZB/*= ZB_Width*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    countLeadingZeros(Val, ZB);
//}
//
///*template <typename T> TEMPLATE*/
//
//// Disable signed.
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 139,
// FQN="llvm::countLeadingZeros", NM="_ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm17countLeadingZerosET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && std.numeric_limits<T>.is_signed, std.size_t>.type countLeadingZeros(T $Prm0, ZeroBehavior $Prm1/*= ZB_Width*/) { throw new UnsupportedOperationException("Deleted");}
////<editor-fold defaultstate="collapsed" desc="llvm::countLeadingZeros">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 144,
// FQN="llvm::countLeadingZeros", NM="_ZN4llvm17countLeadingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm17countLeadingZerosIjEENSt9enable_ifIXaasr3std14numeric_limitsIT_EE10is_integerntsr3std14numeric_limitsIS2_EE9is_signedEmE4typeES2_NS_12ZeroBehaviorE")
////</editor-fold>
//public static /*inline*/ /*ulong*/long countLeadingZeros_uint32_t_ZeroBehavior(/*uint32_t*/int Val, ZeroBehavior ZB) {
//  if (ZB != ZeroBehavior.ZB_Undefined && Val == 0) {
//    return 32;
//  }
//  return __builtin_clz(Val);
//}
//
///*template <typename T> TEMPLATE*/
//
///// \brief Get the index of the first set bit starting from the least
/////   significant bit.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
/////   valid arguments.
////<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 183,
// FQN="llvm::findFirstSet", NM="_ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, T>.type findFirstSet(T Val) {
//  return findFirstSet(Val, ZeroBehavior.ZB_Max);
//}
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, T>.type findFirstSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    findFirstSet(Val, ZB);
//}
//
///*template <typename T> TEMPLATE*/
//
//// Disable signed.
////<editor-fold defaultstate="collapsed" desc="llvm::findFirstSet">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 194,
// FQN="llvm::findFirstSet", NM="_ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12findFirstSetET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && std.numeric_limits<T>.is_signed, T>.type findFirstSet(T $Prm0, ZeroBehavior $Prm1/*= ZB_Max*/) { throw new UnsupportedOperationException("Deleted");}
///*template <typename T> TEMPLATE*/
//
///// \brief Get the index of the last set bit starting from the least
/////   significant bit.
/////
///// Only unsigned integral types are allowed.
/////
///// \param ZB the behavior on an input of 0. Only ZB_Max and ZB_Undefined are
/////   valid arguments.
////<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 206,
// FQN="llvm::findLastSet", NM="_ZN4llvm11findLastSetET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11findLastSetET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, T>.type findLastSet(T Val) {
//  return findLastSet(Val, ZeroBehavior.ZB_Max);
//}
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && !std.numeric_limits<T>.is_signed, T>.type findLastSet(T Val, ZeroBehavior ZB/*= ZB_Max*/) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    findLastSet(Val, ZB);
//}
//
///*template <typename T> TEMPLATE*/
//
//// Disable signed.
////<editor-fold defaultstate="collapsed" desc="llvm::findLastSet">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 220,
// FQN="llvm::findLastSet", NM="_ZN4llvm11findLastSetET_NS_12ZeroBehaviorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11findLastSetET_NS_12ZeroBehaviorE")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<std.numeric_limits<T>.is_integer
//   && std.numeric_limits<T>.is_signed, T>.type findLastSet(T $Prm0, ZeroBehavior $Prm1/*= ZB_Max*/) { throw new UnsupportedOperationException("Deleted");}
//
///// \brief Macro compressed bit reversal table for 256 bits.
/////
///// http://graphics.stanford.edu/~seander/bithacks.html#BitReverseTable
////<editor-fold defaultstate="collapsed" desc="llvm::BitReverseTable256">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 227,
// FQN="llvm::BitReverseTable256", NM="_ZN4llvmL18BitReverseTable256E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL18BitReverseTable256E")
////</editor-fold>
//public static /*const*//*uchar*/byte BitReverseTable256[/*256*/] = /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.BitReverseTable256;
///*template <typename T> TEMPLATE*/
//
///// \brief Reverse the bits in \p Val.
////<editor-fold defaultstate="collapsed" desc="llvm::reverseBits">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 239,
// FQN="llvm::reverseBits", NM="_ZN4llvm11reverseBitsET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11reverseBitsET_")
////</editor-fold>
//public static </*typename*/ T> T reverseBits(T Val) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    reverseBits(Val);
//}
//
//
///// Hi_32 - This function returns the high 32 bits of a 64 bit value.
////<editor-fold defaultstate="collapsed" desc="llvm::Hi_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 254,
// FQN="llvm::Hi_32", NM="_ZN4llvm5Hi_32Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5Hi_32Em")
////</editor-fold>
//public static /*inline*/ /*uint32_t*/int Hi_32(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Hi_32(Value);
//}
//
//
///// Lo_32 - This function returns the low 32 bits of a 64 bit value.
////<editor-fold defaultstate="collapsed" desc="llvm::Lo_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 259,
// FQN="llvm::Lo_32", NM="_ZN4llvm5Lo_32Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5Lo_32Em")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 265,
// FQN="llvm::Make_64", NM="_ZN4llvm7Make_64Ejj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7Make_64Ejj")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ Make_64(/*uint32_t*/int High, /*uint32_t*/int Low) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    Make_64(High, Low);
//}
//
///*template <unsigned int N> TEMPLATE*/
//
///// isInt - Checks if an integer fits into the given bit width.
////<editor-fold defaultstate="collapsed" desc="llvm::isInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 271,
// FQN="llvm::isInt", NM="_ZN4llvm5isIntEl",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5isIntEl")
////</editor-fold>
//public static /*inline*/ </*uint*/int N> boolean isInt(long/*int64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isInt(x);
//}
//
//// Template specializations to get better code for common cases.
////<editor-fold defaultstate="collapsed" desc="llvm::isInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 275,
// FQN="llvm::isInt", NM="_ZN4llvm5isIntILj8EEEbl",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5isIntILj8EEEbl")
////</editor-fold>
//public static /*inline*/ boolean isInt(long/*int64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isInt(x);
//}
//
///*template <unsigned int N, unsigned int S> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 291,
// FQN="llvm::isShiftedInt", NM="_ZN4llvm12isShiftedIntEl",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12isShiftedIntEl")
////</editor-fold>
//public static /*inline*/ </*uint*/int N, /*uint*/int S> boolean isShiftedInt(long/*int64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isShiftedInt(x);
//}
//
///*template <unsigned int N> TEMPLATE*/
//
///// isUInt - Checks if an unsigned integer fits into the given bit width.
////<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 297,
// FQN="llvm::isUInt", NM="_ZN4llvm6isUIntEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6isUIntEm")
////</editor-fold>
//public static /*inline*/ </*uint*/int N> boolean isUInt(long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isUInt(x);
//}
//
//// Template specializations to get better code for common cases.
////<editor-fold defaultstate="collapsed" desc="llvm::isUInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 301,
// FQN="llvm::isUInt", NM="_ZN4llvm6isUIntILj8EEEbm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6isUIntILj8EEEbm")
////</editor-fold>
//public static /*inline*/ boolean isUInt(long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isUInt(x);
//}
//
///*template <unsigned int N, unsigned int S> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedUInt">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 317,
// FQN="llvm::isShiftedUInt", NM="_ZN4llvm13isShiftedUIntEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm13isShiftedUIntEm")
////</editor-fold>
//public static /*inline*/ </*uint*/int N, /*uint*/int S> boolean isShiftedUInt(long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isShiftedUInt(x);
//}
//
//
///// isUIntN - Checks if an unsigned integer fits into the given (dynamic)
///// bit width.
////<editor-fold defaultstate="collapsed" desc="llvm::isUIntN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 323,
// FQN="llvm::isUIntN", NM="_ZN4llvm7isUIntNEjm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7isUIntNEjm")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 329,
// FQN="llvm::isIntN", NM="_ZN4llvm6isIntNEjl",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6isIntNEjl")
////</editor-fold>
//public static /*inline*/ boolean isIntN(/*uint*/int N, long/*int64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isIntN(N, x);
//}
//
//
///// isMask_32 - This function returns true if the argument is a sequence of ones
///// starting at the least significant bit with the remainder zero (32 bit
///// version).   Ex. isMask_32(0x0000FFFFU) == true.
////<editor-fold defaultstate="collapsed" desc="llvm::isMask_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 336,
// FQN="llvm::isMask_32", NM="_ZN4llvm9isMask_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9isMask_32Ej")
////</editor-fold>
//public static /*inline*/ boolean isMask_32(/*uint32_t*/int Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isMask_32(Value);
//}
//
//
///// isMask_64 - This function returns true if the argument is a sequence of ones
///// starting at the least significant bit with the remainder zero (64 bit
///// version).
////<editor-fold defaultstate="collapsed" desc="llvm::isMask_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 343,
// FQN="llvm::isMask_64", NM="_ZN4llvm9isMask_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9isMask_64Em")
////</editor-fold>
//public static /*inline*/ boolean isMask_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    isMask_64(Value);
//}
//
//
///// isShiftedMask_32 - This function returns true if the argument contains a
///// sequence of ones with the remainder zero (32 bit version.)
///// Ex. isShiftedMask_32(0x0000FF00U) == true.
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 350,
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
///// sequence of ones with the remainder zero (64 bit version.)
////<editor-fold defaultstate="collapsed" desc="llvm::isShiftedMask_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 356,
// FQN="llvm::isShiftedMask_64", NM="_ZN4llvm16isShiftedMask_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm16isShiftedMask_64Em")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 362,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 368,
// FQN="llvm::isPowerOf2_64", NM="_ZN4llvm13isPowerOf2_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm13isPowerOf2_64Em")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 374,
// FQN="llvm::ByteSwap_16", NM="_ZN4llvm11ByteSwap_16Et",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11ByteSwap_16Et")
////</editor-fold>
//public static /*inline*/ char/*uint16_t*/ ByteSwap_16(char/*uint16_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    ByteSwap_16(Value);
//}
//
//
///// ByteSwap_32 - This function returns a byte-swapped representation of the
///// 32-bit argument, Value.
////<editor-fold defaultstate="collapsed" desc="llvm::ByteSwap_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 380,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 386,
// FQN="llvm::ByteSwap_64", NM="_ZN4llvm11ByteSwap_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm11ByteSwap_64Em")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ ByteSwap_64(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    ByteSwap_64(Value);
//}
//
//
///// CountLeadingOnes_32 - this function performs the operation of
///// counting the number of ones from the most significant bit to the first zero
///// bit.  Ex. CountLeadingOnes_32(0xFF0FFF00) == 8.
///// Returns 32 if the word is all ones.
////<editor-fold defaultstate="collapsed" desc="llvm::CountLeadingOnes_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 394,
// FQN="llvm::CountLeadingOnes_32", NM="_ZN4llvm19CountLeadingOnes_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm19CountLeadingOnes_32Ej")
////</editor-fold>
//public static /*inline*/ /*uint*/int CountLeadingOnes_32(/*uint32_t*/int Value) {
//  return countLeadingZeros_uint32_t_ZeroBehavior(~Value);
//}
//
//
///// CountLeadingOnes_64 - This function performs the operation
///// of counting the number of ones from the most significant bit to the first
///// zero bit (64 bit edition.)
///// Returns 64 if the word is all ones.
////<editor-fold defaultstate="collapsed" desc="llvm::CountLeadingOnes_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 402,
// FQN="llvm::CountLeadingOnes_64", NM="_ZN4llvm19CountLeadingOnes_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm19CountLeadingOnes_64Em")
////</editor-fold>
//public static /*inline*/ /*uint*/int CountLeadingOnes_64(long/*uint64_t*/ Value) {
//  return countLeadingZeros_uint64_t_ZeroBehavior(~Value);
//}
//
//
///// CountTrailingOnes_32 - this function performs the operation of
///// counting the number of ones from the least significant bit to the first zero
///// bit.  Ex. CountTrailingOnes_32(0x00FF00FF) == 8.
///// Returns 32 if the word is all ones.
////<editor-fold defaultstate="collapsed" desc="llvm::CountTrailingOnes_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 410,
// FQN="llvm::CountTrailingOnes_32", NM="_ZN4llvm20CountTrailingOnes_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm20CountTrailingOnes_32Ej")
////</editor-fold>
//public static /*inline*/ /*uint*/int CountTrailingOnes_32(/*uint32_t*/int Value) {
//  return countTrailingZeros_uint32_t_ZeroBehavior(~Value);
//}
//
//
///// CountTrailingOnes_64 - This function performs the operation
///// of counting the number of ones from the least significant bit to the first
///// zero bit (64 bit edition.)
///// Returns 64 if the word is all ones.
////<editor-fold defaultstate="collapsed" desc="llvm::CountTrailingOnes_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 418,
// FQN="llvm::CountTrailingOnes_64", NM="_ZN4llvm20CountTrailingOnes_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm20CountTrailingOnes_64Em")
////</editor-fold>
//public static /*inline*/ /*uint*/int CountTrailingOnes_64(long/*uint64_t*/ Value) {
//  return countTrailingZeros_uint64_t_ZeroBehavior(~Value);
//}
//
//
///// CountPopulation_32 - this function counts the number of set bits in a value.
///// Ex. CountPopulation(0xF000F000) = 8
///// Returns 0 if the word is zero.
////<editor-fold defaultstate="collapsed" desc="llvm::CountPopulation_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 425,
// FQN="llvm::CountPopulation_32", NM="_ZN4llvm18CountPopulation_32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18CountPopulation_32Ej")
////</editor-fold>
//public static /*inline*/ /*uint*/int CountPopulation_32(/*uint32_t*/int Value) {
//  return __builtin_popcount(Value);
//}
//
//
///// CountPopulation_64 - this function counts the number of set bits in a value,
///// (64 bit edition.)
////<editor-fold defaultstate="collapsed" desc="llvm::CountPopulation_64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 437,
// FQN="llvm::CountPopulation_64", NM="_ZN4llvm18CountPopulation_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18CountPopulation_64Em")
////</editor-fold>
//public static /*inline*/ /*uint*/int CountPopulation_64(long/*uint64_t*/ Value) {
//  return __builtin_popcountll(Value);
//}
//
//
///// Log2_32 - This function returns the floor log base 2 of the specified value,
///// -1 if the value is zero. (32 bit edition.)
///// Ex. Log2_32(32) == 5, Log2_32(1) == 0, Log2_32(0) == -1, Log2_32(6) == 2
////<editor-fold defaultstate="collapsed" desc="llvm::Log2_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 451,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 457,
// FQN="llvm::Log2_64", NM="_ZN4llvm7Log2_64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm7Log2_64Em")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 464,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 470,
// FQN="llvm::Log2_64_Ceil", NM="_ZN4llvm12Log2_64_CeilEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12Log2_64_CeilEm")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 476,
// FQN="llvm::GreatestCommonDivisor64", NM="_ZN4llvm23GreatestCommonDivisor64Emm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm23GreatestCommonDivisor64Emm")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 487,
// FQN="llvm::BitsToDouble", NM="_ZN4llvm12BitsToDoubleEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12BitsToDoubleEm")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 498,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 511,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 524,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 543,
// FQN="llvm::MinAlign", NM="_ZN4llvm8MinAlignEmm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm8MinAlignEmm")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 556,
// FQN="llvm::alignAddr", NM="_ZN4llvm9alignAddrEPvm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9alignAddrEPvm")
////</editor-fold>
//public static /*inline*/ Object/*uintptr_t*/ alignAddr(Object/*void P*/ Addr, /*size_t*/int Alignment) {
//  assert ((Alignment != 0) && isPowerOf2_64((long/*uint64_t*/)Alignment)) : "Alignment is not a power of two!";
//  assert ((Object/*uintptr_t*/)Addr + Alignment - 1 >= (Object/*uintptr_t*/)Addr);
//  
//  return (((Object/*uintptr_t*/)Addr + Alignment - 1) & ~(Object/*uintptr_t*/)(Alignment - 1));
//}
//
//
///// \brief Returns the necessary adjustment for aligning \c Ptr to \c Alignment
///// bytes, rounding up.
////<editor-fold defaultstate="collapsed" desc="llvm::alignmentAdjustment">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 567,
// FQN="llvm::alignmentAdjustment", NM="_ZN4llvm19alignmentAdjustmentEPvm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm19alignmentAdjustmentEPvm")
////</editor-fold>
//public static /*inline*/ /*size_t*/int alignmentAdjustment(Object/*void P*/ Ptr, /*size_t*/int Alignment) {
//  return alignAddr(Ptr, Alignment) - (Object/*uintptr_t*/)Ptr;
//}
//
//
///// NextPowerOf2 - Returns the next power of two (in 64-bits)
///// that is strictly greater than A.  Returns zero on overflow.
////<editor-fold defaultstate="collapsed" desc="llvm::NextPowerOf2">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 573,
// FQN="llvm::NextPowerOf2", NM="_ZN4llvm12NextPowerOf2Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12NextPowerOf2Em")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ NextPowerOf2(long/*uint64_t*/ A) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    NextPowerOf2(A);
//}
//
//
///// Returns the power of two which is less than or equal to the given value.
///// Essentially, it is a floor operation across the domain of powers of two.
////<editor-fold defaultstate="collapsed" desc="llvm::PowerOf2Floor">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 585,
// FQN="llvm::PowerOf2Floor", NM="_ZN4llvm13PowerOf2FloorEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm13PowerOf2FloorEm")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ PowerOf2Floor(long/*uint64_t*/ A) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    PowerOf2Floor(A);
//}
//
//
///// Returns the next integer (mod 2**64) that is greater than or equal to
///// \p Value and is a multiple of \p Align. \p Align must be non-zero.
/////
///// Examples:
///// \code
/////   RoundUpToAlignment(5, 8) = 8
/////   RoundUpToAlignment(17, 8) = 24
/////   RoundUpToAlignment(~0LL, 8) = 0
/////   RoundUpToAlignment(321, 255) = 510
///// \endcode
////<editor-fold defaultstate="collapsed" desc="llvm::RoundUpToAlignment">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 600,
// FQN="llvm::RoundUpToAlignment", NM="_ZN4llvm18RoundUpToAlignmentEmm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18RoundUpToAlignmentEmm")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ RoundUpToAlignment(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
//  return (Value + Align - 1) / Align * Align;
//}
//
//
///// Returns the offset to the next integer (mod 2**64) that is greater than
///// or equal to \p Value and is a multiple of \p Align. \p Align must be
///// non-zero.
////<editor-fold defaultstate="collapsed" desc="llvm::OffsetToAlignment">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 607,
// FQN="llvm::OffsetToAlignment", NM="_ZN4llvm17OffsetToAlignmentEmm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm17OffsetToAlignmentEmm")
////</editor-fold>
//public static /*inline*/ long/*uint64_t*/ OffsetToAlignment(long/*uint64_t*/ Value, long/*uint64_t*/ Align) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    OffsetToAlignment(Value, Align);
//}
//
//
///// abs64 - absolute value of a 64-bit int.  Not all environments support
///// "abs" on whatever their name for the 64-bit int type is.  The absolute
///// value of the largest negative number is undefined, as with "abs".
////<editor-fold defaultstate="collapsed" desc="llvm::abs64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 614,
// FQN="llvm::abs64", NM="_ZN4llvm5abs64El",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm5abs64El")
////</editor-fold>
//public static /*inline*/ long/*int64_t*/ abs64(long/*int64_t*/ x) {
//  return (x < 0) ? -x : x;
//}
//
///*template <unsigned int B> TEMPLATE*/
//
///// SignExtend32 - Sign extend B-bit number x to 32-bit int.
///// Usage int32_t r = SignExtend32<5>(x);
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 620,
// FQN="llvm::SignExtend32", NM="_ZN4llvm12SignExtend32Ej",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12SignExtend32Ej")
////</editor-fold>
//public static /*inline*/ </*uint*/int B> int/*int32_t*/ SignExtend32(/*uint32_t*/int x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend32(x);
//}
//
//
///// \brief Sign extend number in the bottom B bits of X to a 32-bit int.
///// Requires 0 < B <= 32.
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 626,
// FQN="llvm::SignExtend32", NM="_ZN4llvm12SignExtend32Ejj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12SignExtend32Ejj")
////</editor-fold>
//public static /*inline*/ int/*int32_t*/ SignExtend32(/*uint32_t*/int X, /*uint*/int B) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend32(X, B);
//}
//
///*template <unsigned int B> TEMPLATE*/
//
///// SignExtend64 - Sign extend B-bit number x to 64-bit int.
///// Usage int64_t r = SignExtend64<5>(x);
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 632,
// FQN="llvm::SignExtend64", NM="_ZN4llvm12SignExtend64Em",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12SignExtend64Em")
////</editor-fold>
//public static /*inline*/ </*uint*/int B> long/*int64_t*/ SignExtend64(long/*uint64_t*/ x) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend64(x);
//}
//
//
///// \brief Sign extend number in the bottom B bits of X to a 64-bit int.
///// Requires 0 < B <= 64.
////<editor-fold defaultstate="collapsed" desc="llvm::SignExtend64">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MathExtras.h", line = 638,
// FQN="llvm::SignExtend64", NM="_ZN4llvm12SignExtend64Emj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12SignExtend64Emj")
////</editor-fold>
//public static /*inline*/ long/*int64_t*/ SignExtend64(long/*uint64_t*/ X, /*uint*/int B) {
//  return /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.
//    SignExtend64(X, B);
//}
//
///*template <typename T, unsigned int N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 927,
// FQN="llvm::capacity_in_bytes", NM="_ZN4llvmL17capacity_in_bytesERKNS_11SmallVectorIT_XT0_EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL17capacity_in_bytesERKNS_11SmallVectorIT_XT0_EEE")
////</editor-fold>
//public static /*inline*/ </*typename*/ T, /*uint*/int N> /*size_t*/int capacity_in_bytes(/*const*/ SmallVector<T, N> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.SmallVectorLlvmGlobals.
//    capacity_in_bytes(X);
//}
//
///*template <typename T> TEMPLATE*/
//
///// Construct an ArrayRef from a single element.
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 345,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefERKT_")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ T /*&*/ OneElt) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(OneElt);
//}
//
///*template <typename T> TEMPLATE*/
//
///// Construct an ArrayRef from a pointer and length.
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 351,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefEPKT_m",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefEPKT_m")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ T /*P*/ data, /*size_t*/int length) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(data, length);
//}
//
///*template <typename T> TEMPLATE*/
//
///// Construct an ArrayRef from a range.
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 357,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefEPKT_S2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefEPKT_S2_")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ T /*P*/ begin, /*const*/ T /*P*/ end) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(begin, end);
//}
//
///*template <typename T> TEMPLATE*/
//
///// Construct an ArrayRef from a SmallVector.
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 363,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefERKNS_15SmallVectorImplIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefERKNS_15SmallVectorImplIT_EE")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ SmallVectorImpl<T> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Vec);
//}
//
///*template <typename T, unsigned int N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 369,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefERKNS_11SmallVectorIT_XT0_EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefERKNS_11SmallVectorIT_XT0_EEE")
////</editor-fold>
//public static </*typename*/ T, /*uint*/int N> ArrayRef<T> makeArrayRef(/*const*/ SmallVector<T, N> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Vec);
//}
//
///*template <typename T> TEMPLATE*/
//
///// Construct an ArrayRef from a std::vector.
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 375,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefERKSt6vectorIT_SaIS1_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefERKSt6vectorIT_SaIS1_EE")
////</editor-fold>
//public static </*typename*/ T> ArrayRef<T> makeArrayRef(/*const*/ std.vector<T> /*&*/ Vec) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Vec);
//}
//
///*template <typename T, size_t N> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::makeArrayRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 381,
// FQN="llvm::makeArrayRef", NM="_ZN4llvm12makeArrayRefERAT0__KT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12makeArrayRefERAT0__KT_")
////</editor-fold>
//public static </*typename*/ T, /*size_t*/int N> ArrayRef<T> makeArrayRef(/*const*/ T (/*&*/ Arr)[N]) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    makeArrayRef(Arr);
//}
//
///*template <typename T> TEMPLATE*/
//
///// @}
///// @name ArrayRef Comparison Operators
///// @{
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 390,
// FQN="llvm::operator==", NM="_ZN4llvmeqENS_8ArrayRefIT_EES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqENS_8ArrayRefIT_EES2_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> boolean $eq_ArrayRef<T>(ArrayRef<T> LHS, ArrayRef<T> RHS) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    $eq_ArrayRef<T>(LHS, RHS);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ArrayRef.h", line = 395,
// FQN="llvm::operator!=", NM="_ZN4llvmneENS_8ArrayRefIT_EES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneENS_8ArrayRefIT_EES2_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> boolean $noteq_ArrayRef<T>(ArrayRef<T> LHS, ArrayRef<T> RHS) {
//  return /*delegate*/org.llvm.adt.impl.ArrayRefLlvmGlobals.
//    $noteq_ArrayRef<T>(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::host_char_bit">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 41,
// FQN="llvm::host_char_bit", NM="_ZN4llvmL13host_char_bitE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL13host_char_bitE")
////</editor-fold>
//public static /*const*//*uint*/int host_char_bit = /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.host_char_bit;
////<editor-fold defaultstate="collapsed" desc="llvm::integerPartWidth">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 42,
// FQN="llvm::integerPartWidth", NM="_ZN4llvmL16integerPartWidthE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL16integerPartWidthE")
////</editor-fold>
//public static /*const*//*uint*/int integerPartWidth = /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.integerPartWidth;
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1722,
// FQN="llvm::operator==", NM="_ZN4llvmeqEmRKNS_5APIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqEmRKNS_5APIntE")
////</editor-fold>
//public static /*inline*/ boolean $eq_uint64_t_APInt(long/*uint64_t*/ V1, /*const*/ APInt /*&*/ V2) {
//  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
//    $eq_uint64_t_APInt(V1, V2);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1724,
// FQN="llvm::operator!=", NM="_ZN4llvmneEmRKNS_5APIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneEmRKNS_5APIntE")
////</editor-fold>
//public static /*inline*/ boolean $noteq_uint64_t_APInt(long/*uint64_t*/ V1, /*const*/ APInt /*&*/ V2) {
//  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
//    $noteq_uint64_t_APInt(V1, V2);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1726,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_APInt(raw_ostream /*&*/ OS, /*const*/ APInt /*&*/ I) {
//  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
//    $out_raw_ostream_APInt(OS, I);
//}
//
//
///// See friend declarations above.
/////
///// These additional declarations are required in order to compile LLVM with IBM
///// xlC compiler.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 2845,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_7APFloatE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueERKNS_7APFloatE")
////</editor-fold>
//public static hash_code hash_value(/*const*/ APFloat /*&*/ Arg) {
//  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
//    hash_value(Arg);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::scalbn">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/APFloat.cpp", line = 3921,
// FQN="llvm::scalbn", NM="_ZN4llvm6scalbnENS_7APFloatEi",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6scalbnENS_7APFloatEi")
////</editor-fold>
//public static APFloat scalbn(APFloat X, int Exp) {
//  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
//    scalbn(X, Exp);
//}
//
//
///// \brief Returns the absolute value of the argument.
////<editor-fold defaultstate="collapsed" desc="llvm::abs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 653,
// FQN="llvm::abs", NM="_ZN4llvm3absENS_7APFloatE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm3absENS_7APFloatE")
////</editor-fold>
//public static /*inline*/ APFloat abs(APFloat X) {
//  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
//    abs(X);
//}
//
//
///// Implements IEEE minNum semantics. Returns the smaller of the 2 arguments if
///// both are not NaN. If either argument is a NaN, returns the other argument.
////<editor-fold defaultstate="collapsed" desc="llvm::minnum">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 660,
// FQN="llvm::minnum", NM="_ZN4llvm6minnumERKNS_7APFloatES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6minnumERKNS_7APFloatES2_")
////</editor-fold>
//public static /*inline*/ APFloat minnum(/*const*/ APFloat /*&*/ A, /*const*/ APFloat /*&*/ B)/* __attribute__((pure))*/ {
//  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
//    minnum(A, B);
//}
//
//
///// Implements IEEE maxNum semantics. Returns the larger of the 2 arguments if
///// both are not NaN. If either argument is a NaN, returns the other argument.
////<editor-fold defaultstate="collapsed" desc="llvm::maxnum">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APFloat.h", line = 671,
// FQN="llvm::maxnum", NM="_ZN4llvm6maxnumERKNS_7APFloatES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm6maxnumERKNS_7APFloatES2_")
////</editor-fold>
//public static /*inline*/ APFloat maxnum(/*const*/ APFloat /*&*/ A, /*const*/ APFloat /*&*/ B)/* __attribute__((pure))*/ {
//  return /*delegate*/org.llvm.adt.impl.APFloatLlvmGlobals.
//    maxnum(A, B);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 288,
// FQN="llvm::operator==", NM="_ZN4llvmeqElRKNS_6APSIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqElRKNS_6APSIntE")
////</editor-fold>
//public static /*inline*/ boolean $eq_int64_t_APSInt(long/*int64_t*/ V1, /*const*/ APSInt /*&*/ V2) {
//  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
//    $eq_int64_t_APSInt(V1, V2);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 291,
// FQN="llvm::operator!=", NM="_ZN4llvmneElRKNS_6APSIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneElRKNS_6APSIntE")
////</editor-fold>
//public static /*inline*/ boolean $noteq_int64_t_APSInt(long/*int64_t*/ V1, /*const*/ APSInt /*&*/ V2) {
//  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
//    $noteq_int64_t_APSInt(V1, V2);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/APSInt.h", line = 295,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6APSIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6APSIntE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_APSInt$C(raw_ostream /*&*/ OS, /*const*/ APSInt /*&*/ I) {
//  return /*delegate*/org.llvm.adt.impl.APSIntLlvmGlobals.
//    $out_raw_ostream_APSInt$C(OS, I);
//}
//
//
///// @name StringRef Comparison Operators
///// @{
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 530,
// FQN="llvm::operator==", NM="_ZN4llvmeqENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmeqENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $eq_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $eq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 534,
// FQN="llvm::operator!=", NM="_ZN4llvmneENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmneENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $noteq_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $noteq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 538,
// FQN="llvm::operator<", NM="_ZN4llvmltENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmltENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $less_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $less_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 542,
// FQN="llvm::operator<=", NM="_ZN4llvmleENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmleENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $lesseq_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $lesseq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator>">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 546,
// FQN="llvm::operator>", NM="_ZN4llvmgtENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmgtENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $greater_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $greater_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 550,
// FQN="llvm::operator>=", NM="_ZN4llvmgeENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmgeENS_9StringRefES0_")
////</editor-fold>
//public static /*inline*/ boolean $greatereq_StringRef(StringRef LHS, StringRef RHS) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $greatereq_StringRef(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator+=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringRef.h", line = 554,
// FQN="llvm::operator+=", NM="_ZN4llvmpLERSsNS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmpLERSsNS_9StringRefE")
////</editor-fold>
//public static /*inline*/ std.string/*&*/ $addassign_str_StringRef(std.string/*&*/ buffer, StringRef string) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    $addassign_str_StringRef(buffer, string);
//}
//
///*template <typename T> TEMPLATE*/
//
///// \brief Compute a hash_code for any integer value.
/////
///// Note that this function is intended to compute the same hash_code for
///// a particular value without regard to the pre-promotion type. This is in
///// contrast to hash_combine which may produce different hash_codes for
///// differing argument types even if they would implicit promote to a common
///// type without changing the value.
//// namespace hashing
//
//// Declared and documented above, but defined here so that any of the hashing
//// infrastructure is available.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 736,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueET_")
////</editor-fold>
//public static </*typename*/ T>  std.enable_if<is_integral_or_enum<T>.value, hash_code>.type hash_value(T value) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value(value);
//}
//
///*template <typename T> TEMPLATE*/
//
///// \brief Compute a hash_code for a pointer's address.
/////
///// N.B.: This hashes the *address*. Not the value and not the type.
//
//// Declared and documented above, but defined here so that any of the hashing
//// infrastructure is available.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 743,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueEPKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueEPKT_")
////</editor-fold>
//public static </*typename*/ T> hash_code hash_value(/*const*/ T /*P*/ ptr) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value(ptr);
//}
//
///*template <typename T, typename U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 751,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKSt4pairIT_T0_E",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueERKSt4pairIT_T0_E")
////</editor-fold>
//public static </*typename*/ T, /*typename*/ U> hash_code hash_value(/*const*/ std.pair<T, U> /*&*/ arg) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value(arg);
//}
//
///*template <typename T> TEMPLATE*/
//
///// \brief Compute a hash_code for a standard string.
//
//// Declared and documented above, but defined here so that any of the hashing
//// infrastructure is available.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 758,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKSbIT_St11char_traitsIS0_ESaIS0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm10hash_valueERKSbIT_St11char_traitsIS0_ESaIS0_EE")
////</editor-fold>
//public static </*typename*/ T> hash_code hash_value(/*const*/ std.basic_string<T> /*&*/ arg) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_value(arg);
//}
//
///*template <typename InputIteratorT> TEMPLATE*/
//
///// \brief Compute a hash_code for a sequence of values.
/////
///// This hashes a sequence of values. It produces the same hash_code as
///// 'hash_combine(a, b, c, ...)', but can run over arbitrary sized sequences
///// and is significantly faster given pointers and types which can be hashed as
///// a sequence of bytes.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_combine_range">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 486,
// FQN="llvm::hash_combine_range", NM="_ZN4llvm18hash_combine_rangeET_S0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm18hash_combine_rangeET_S0_")
////</editor-fold>
//public static </*typename*/ InputIteratorT> hash_code hash_combine_range(InputIteratorT first, InputIteratorT last) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_combine_range(first, last);
//}
//
///*template <typename ... Ts> TEMPLATE*/
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
////<editor-fold defaultstate="collapsed" desc="llvm::hash_combine">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Hashing.h", line = 660,
// FQN="llvm::hash_combine", NM="_ZN4llvm12hash_combineEDpRKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm12hash_combineEDpRKT_")
////</editor-fold>
//public static </*typename*/ /*...*/ Ts> hash_code hash_combine(/*const*/ Ts /*&*/ args...) {
//  return /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    hash_combine(args);
//}
//
//
///// hexdigit - Return the hexadecimal character for the
///// given number \p X (which should be less than 16).
////<editor-fold defaultstate="collapsed" desc="llvm::hexdigit">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 26,
// FQN="llvm::hexdigit", NM="_ZN4llvmL8hexdigitEjb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL8hexdigitEjb")
////</editor-fold>
//public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X) {
//  return hexdigit(X, false);
//}
//public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X, boolean LowerCase/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    hexdigit(X, LowerCase);
//}
//
//
///// Construct a string ref from a boolean.
////<editor-fold defaultstate="collapsed" desc="llvm::toStringRef">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 32,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 40,
// FQN="llvm::hexDigitValue", NM="_ZN4llvmL13hexDigitValueEc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL13hexDigitValueEc")
////</editor-fold>
//public static /*inline*/ /*uint*/int hexDigitValue(/*char*/byte C) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    hexDigitValue(C);
//}
//
///*template <typename IntTy> TEMPLATE*/
//
///// utohex_buffer - Emit the specified number into the buffer specified by
///// BufferEnd, returning a pointer to the start of the string.  This can be used
///// like this: (note that the buffer must be large enough to handle any number):
/////    char Buffer[40];
/////    printf("0x%s", utohex_buffer(X, Buffer+40));
/////
///// This should only be used with unsigned types.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::utohex_buffer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 56,
// FQN="llvm::utohex_buffer", NM="_ZN4llvmL13utohex_bufferET_Pcb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL13utohex_bufferET_Pcb")
////</editor-fold>
//public static /*inline*/ </*typename*/ IntTy> char$ptr/*char P*/ utohex_buffer(IntTy X, char$ptr/*char P*/ BufferEnd) {
//  return utohex_buffer(X, BufferEnd, false);
//}
//public static /*inline*/ </*typename*/ IntTy> char$ptr/*char P*/ utohex_buffer(IntTy X, char$ptr/*char P*/ BufferEnd, boolean LowerCase/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    utohex_buffer(X, BufferEnd, LowerCase);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::utohexstr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 72,
// FQN="llvm::utohexstr", NM="_ZN4llvmL9utohexstrEmb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL9utohexstrEmb")
////</editor-fold>
//public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X) {
//  return utohexstr(X, false);
//}
//public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X, boolean LowerCase/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    utohexstr(X, LowerCase);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::utostr_32">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 77,
// FQN="llvm::utostr_32", NM="_ZN4llvmL9utostr_32Ejb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL9utostr_32Ejb")
////</editor-fold>
//public static /*inline*/ std.string utostr_32(/*uint32_t*/int X) {
//  return utostr_32(X, false);
//}
//public static /*inline*/ std.string utostr_32(/*uint32_t*/int X, boolean isNeg/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    utostr_32(X, isNeg);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::utostr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 93,
// FQN="llvm::utostr", NM="_ZN4llvmL6utostrEmb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL6utostrEmb")
////</editor-fold>
//public static /*inline*/ std.string utostr(long/*uint64_t*/ X) {
//  return utostr(X, false);
//}
//public static /*inline*/ std.string utostr(long/*uint64_t*/ X, boolean isNeg/*= false*/) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    utostr(X, isNeg);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::itostr">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 109,
// FQN="llvm::itostr", NM="_ZN4llvmL6itostrEl",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvmL6itostrEl")
////</editor-fold>
//public static /*inline*/ std.string itostr(long/*int64_t*/ X) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    itostr(X);
//}
//
//
///// HashString - Hash function for strings.
/////
///// This is the Bernstein hash function.
////
//// FIXME: Investigate whether a modified bernstein hash function performs
//// better: http://eternallyconfuzzled.com/tuts/algorithms/jsw_tut_hashing.aspx
////   X*33+c -> X*33^c
////<editor-fold defaultstate="collapsed" desc="llvm::HashString">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 143,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 150,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 169,
// FQN="llvm::join_impl", NM="_ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag")
////</editor-fold>
//public static /*inline*/ </*typename*/ IteratorT> std.string join_impl(IteratorT Begin, IteratorT End, 
//         StringRef Separator, std.input_iterator_tag $Prm3) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    join_impl(Begin, End, 
//         Separator, $Prm3);
//}
//
///*template <typename IteratorT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 184,
// FQN="llvm::join_impl", NM="_ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag")
////</editor-fold>
//public static /*inline*/ </*typename*/ IteratorT> std.string join_impl(IteratorT Begin, IteratorT End, 
//         StringRef Separator, std.forward_iterator_tag $Prm3) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    join_impl(Begin, End, 
//         Separator, $Prm3);
//}
//
///*template <typename IteratorT> TEMPLATE*/
//
///// Joins the strings in the range [Begin, End), adding Separator between
///// the elements.
////<editor-fold defaultstate="collapsed" desc="llvm::join">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 205,
// FQN="llvm::join", NM="_ZN4llvm4joinET_S0_NS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APFloat.cpp -nm=_ZN4llvm4joinET_S0_NS_9StringRefE")
////</editor-fold>
//public static /*inline*/ </*typename*/ IteratorT> std.string join(IteratorT Begin, IteratorT End, StringRef Separator) {
//  return /*delegate*/org.llvm.adt.impl.StringExtrasLlvmGlobals.
//    join(Begin, End, Separator);
//}
//
//
//// See friend declaration above. This additional declaration is required in
//// order to compile LLVM with IBM xlC compiler.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 668,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_5APIntE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm10hash_valueERKNS_5APIntE")
////</editor-fold>
//public static hash_code hash_value(/*const*/ APInt /*&*/ Arg) {
//  return /*delegate*/org.llvm.adt.impl.APIntLlvmGlobals.
//    hash_value(Arg);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::isa">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 132,
// FQN="llvm::isa", NM="_ZN4llvm3isaERKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm3isaERKT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y> boolean isa(/*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    isa(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 220,
// FQN="llvm::cast", NM="_ZN4llvm4castERKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm4castERKT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  std.enable_if<!is_simple_type<Y>.value,  cast_retty<X, /*const*/ Y>.ret_type>.type cast(/*const*/ Y /*&*/ Val) {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 229,
// FQN="llvm::cast", NM="_ZN4llvm4castERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm4castERT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y>.ret_type cast(Y /*&*/ Val) {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 236,
// FQN="llvm::cast", NM="_ZN4llvm4castEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm4castEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type cast(Y /*P*/ Val) {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 246,
// FQN="llvm::cast_or_null", NM="_ZN4llvm12cast_or_nullERKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm12cast_or_nullERKT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  std.enable_if<!is_simple_type<Y>.value,  cast_retty<X, /*const*/ Y>.ret_type>.type cast_or_null(/*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_or_null(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 256,
// FQN="llvm::cast_or_null", NM="_ZN4llvm12cast_or_nullERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm12cast_or_nullERT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  std.enable_if<!is_simple_type<Y>.value,  cast_retty<X, Y>.ret_type>.type cast_or_null(Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_or_null(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 266,
// FQN="llvm::cast_or_null", NM="_ZN4llvm12cast_or_nullEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm12cast_or_nullEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type cast_or_null(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    cast_or_null(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 283,
// FQN="llvm::dyn_cast", NM="_ZN4llvm8dyn_castERKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm8dyn_castERKT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  std.enable_if<!is_simple_type<Y>.value,  cast_retty<X, /*const*/ Y>.ret_type>.type dyn_cast(/*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 290,
// FQN="llvm::dyn_cast", NM="_ZN4llvm8dyn_castERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm8dyn_castERT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y>.ret_type dyn_cast(Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 296,
// FQN="llvm::dyn_cast", NM="_ZN4llvm8dyn_castEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm8dyn_castEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type dyn_cast(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 305,
// FQN="llvm::dyn_cast_or_null", NM="_ZN4llvm16dyn_cast_or_nullERKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm16dyn_cast_or_nullERKT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  std.enable_if<!is_simple_type<Y>.value,  cast_retty<X, /*const*/ Y>.ret_type>.type dyn_cast_or_null(/*const*/ Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_or_null(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 312,
// FQN="llvm::dyn_cast_or_null", NM="_ZN4llvm16dyn_cast_or_nullERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm16dyn_cast_or_nullERT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  std.enable_if<!is_simple_type<Y>.value,  cast_retty<X, Y>.ret_type>.type dyn_cast_or_null(Y /*&*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_or_null(Val);
//}
//
///*template <class X, class Y> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::dyn_cast_or_null">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Casting.h", line = 319,
// FQN="llvm::dyn_cast_or_null", NM="_ZN4llvm16dyn_cast_or_nullEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm16dyn_cast_or_nullEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ X, /*class*/ Y>  cast_retty<X, Y /*P*/ >.ret_type dyn_cast_or_null(Y /*P*/ Val)/* __attribute__((warn_unused_result))*/ {
//  return /*delegate*/org.llvm.support.impl.CastingLlvmGlobals.
//    dyn_cast_or_null(Val);
//}
//
///*template <typename PT1, typename PT2> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 187,
// FQN="llvm::operator==", NM="_ZN4llvmeqENS_12PointerUnionIT_T0_EES3_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqENS_12PointerUnionIT_T0_EES3_")
////</editor-fold>
//public static </*typename*/ PT1, /*typename*/ PT2> boolean $eq_PointerUnion<PT1, PT2>(PointerUnion<PT1, PT2> lhs, 
//                          PointerUnion<PT1, PT2> rhs) {
//  return /*delegate*/org.llvm.adt.impl.PointerUnionLlvmGlobals.
//    $eq_PointerUnion<PT1, PT2>(lhs, 
//                          rhs);
//}
//
///*template <typename PT1, typename PT2> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 193,
// FQN="llvm::operator!=", NM="_ZN4llvmneENS_12PointerUnionIT_T0_EES3_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmneENS_12PointerUnionIT_T0_EES3_")
////</editor-fold>
//public static </*typename*/ PT1, /*typename*/ PT2> boolean $noteq_PointerUnion<PT1, PT2>(PointerUnion<PT1, PT2> lhs, 
//                             PointerUnion<PT1, PT2> rhs) {
//  return /*delegate*/org.llvm.adt.impl.PointerUnionLlvmGlobals.
//    $noteq_PointerUnion<PT1, PT2>(lhs, 
//                             rhs);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 206,
// FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr<T>_IntrusiveRefCntPtr<U>(/*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                                               /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_IntrusiveRefCntPtr<T>_IntrusiveRefCntPtr<U>(A, 
//                                               B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 213,
// FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EERKNS0_IT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_IntrusiveRefCntPtr<T>_IntrusiveRefCntPtr<U>(/*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                                                  /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_IntrusiveRefCntPtr<T>_IntrusiveRefCntPtr<U>(A, 
//                                                  B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 220,
// FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_IntrusiveRefCntPtr<T>_T(/*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                           U /*P*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_IntrusiveRefCntPtr<T>_T(A, 
//                           B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 227,
// FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEPT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEPT0_")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_IntrusiveRefCntPtr<T>_T(/*const*/ IntrusiveRefCntPtr<T> /*&*/ A, 
//                              U /*P*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_IntrusiveRefCntPtr<T>_T(A, 
//                              B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 234,
// FQN="llvm::operator==", NM="_ZN4llvmeqEPT_RKNS_18IntrusiveRefCntPtrIT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqEPT_RKNS_18IntrusiveRefCntPtrIT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $eq_T_IntrusiveRefCntPtr<U>(T /*P*/ A, 
//                           /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_T_IntrusiveRefCntPtr<U>(A, 
//                           B);
//}
//
///*template <class T, class U> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 241,
// FQN="llvm::operator!=", NM="_ZN4llvmneEPT_RKNS_18IntrusiveRefCntPtrIT0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmneEPT_RKNS_18IntrusiveRefCntPtrIT0_EE")
////</editor-fold>
//public static /*inline*/ </*class*/ T, /*class*/ U> boolean $noteq_T_IntrusiveRefCntPtr<U>(T /*P*/ A, 
//                              /*const*/ IntrusiveRefCntPtr<U> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_T_IntrusiveRefCntPtr<U>(A, 
//                              B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 248,
// FQN="llvm::operator==", NM="_ZN4llvmeqEDnRKNS_18IntrusiveRefCntPtrIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqEDnRKNS_18IntrusiveRefCntPtrIT_EE")
////</editor-fold>
//public static </*class*/ T> boolean $eq_std.nullptr_t_IntrusiveRefCntPtr<T>(decltype(null) A, /*const*/ IntrusiveRefCntPtr<T> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_std.nullptr_t_IntrusiveRefCntPtr<T>(A, B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 253,
// FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEDn",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqERKNS_18IntrusiveRefCntPtrIT_EEDn")
////</editor-fold>
//public static </*class*/ T> boolean $eq_IntrusiveRefCntPtr<T>_std.nullptr_t(/*const*/ IntrusiveRefCntPtr<T> /*&*/ A, decltype(null) B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $eq_IntrusiveRefCntPtr<T>_std.nullptr_t(A, B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 258,
// FQN="llvm::operator!=", NM="_ZN4llvmneEDnRKNS_18IntrusiveRefCntPtrIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmneEDnRKNS_18IntrusiveRefCntPtrIT_EE")
////</editor-fold>
//public static </*class*/ T> boolean $noteq_std.nullptr_t_IntrusiveRefCntPtr<T>(decltype(null) A, /*const*/ IntrusiveRefCntPtr<T> /*&*/ B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_std.nullptr_t_IntrusiveRefCntPtr<T>(A, B);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 263,
// FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEDn",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmneERKNS_18IntrusiveRefCntPtrIT_EEDn")
////</editor-fold>
//public static </*class*/ T> boolean $noteq_IntrusiveRefCntPtr<T>_std.nullptr_t(/*const*/ IntrusiveRefCntPtr<T> /*&*/ A, decltype(null) B) {
//  return /*delegate*/org.llvm.adt.impl.IntrusiveRefCntPtrLlvmGlobals.
//    $noteq_IntrusiveRefCntPtr<T>_std.nullptr_t(A, B);
//}
//
///*template <typename KeyT, typename ValueT, typename KeyInfoT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMap.h", line = 1052,
// FQN="llvm::capacity_in_bytes", NM="_ZN4llvmL17capacity_in_bytesERKNS_8DenseMapIT_T0_T1_NS_6detail12DenseMapPairIS1_S2_EEEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmL17capacity_in_bytesERKNS_8DenseMapIT_T0_T1_NS_6detail12DenseMapPairIS1_S2_EEEE")
////</editor-fold>
//public static /*inline*/ </*typename*/ KeyT, /*typename*/ ValueT, /*typename*/ KeyInfoT> /*size_t*/int capacity_in_bytes(/*const*/ DenseMap<KeyT, ValueT, KeyInfoT> /*&*/ X) {
//  return /*delegate*/org.llvm.adt.impl.DenseMapLlvmGlobals.
//    capacity_in_bytes(X);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 500,
// FQN="llvm::operator+", NM="_ZN4llvmplERKNS_5TwineES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmplERKNS_5TwineES2_")
////</editor-fold>
//public static /*inline*/ Twine $add_Twine(/*const*/ Twine /*&*/ LHS, /*const*/ Twine /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $add_Twine(LHS, RHS);
//}
//
//
///// Additional overload to guarantee simplified codegen; this is equivalent to
///// concat().
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 507,
// FQN="llvm::operator+", NM="_ZN4llvmplEPKcRKNS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmplEPKcRKNS_9StringRefE")
////</editor-fold>
//public static /*inline*/ Twine $add_char$ptr_StringRef(/*const*/char$ptr/*char P*/ LHS, /*const*/ StringRef /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $add_char$ptr_StringRef(LHS, RHS);
//}
//
//
///// Additional overload to guarantee simplified codegen; this is equivalent to
///// concat().
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 514,
// FQN="llvm::operator+", NM="_ZN4llvmplERKNS_9StringRefEPKc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmplERKNS_9StringRefEPKc")
////</editor-fold>
//public static /*inline*/ Twine $add_StringRef_char$ptr(/*const*/ StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $add_StringRef_char$ptr(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 518,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Twine(raw_ostream /*&*/ OS, /*const*/ Twine /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.TwineLlvmGlobals.
//    $out_raw_ostream_Twine(OS, RHS);
//}
//
///*template <class T, class V> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::moveIfMoveConstructible">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 27,
// FQN="llvm::moveIfMoveConstructible", NM="_ZN4llvm23moveIfMoveConstructibleERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm23moveIfMoveConstructibleERT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ V>  std.enable_if<std.is_constructible<T, V>.value,  std.remove_reference<V>.type>.type /*&&*/moveIfMoveConstructible(V /*&*/ Val) {
//  return /*delegate*/org.llvm.support.impl.ErrorOrLlvmGlobals.
//    moveIfMoveConstructible(Val);
//}
//
///*template <class T, class V> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::moveIfMoveConstructible">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 34,
// FQN="llvm::moveIfMoveConstructible", NM="_ZN4llvm23moveIfMoveConstructibleERT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm23moveIfMoveConstructibleERT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ V>  std.enable_if<!std.is_constructible<T, V>.value,  std.remove_reference<V>.type>.type /*&*/ moveIfMoveConstructible(V /*&*/ Val) {
//  return /*delegate*/org.llvm.support.impl.ErrorOrLlvmGlobals.
//    moveIfMoveConstructible(Val);
//}
//
///*template <class T, class E> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ErrorOr.h", line = 281,
// FQN="llvm::operator==", NM="_ZN4llvmeqERNS_7ErrorOrIT_EET0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmeqERNS_7ErrorOrIT_EET0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ E>  std.enable_if<std.is_error_code_enum<E>.value
//   || std.is_error_condition_enum<E>.value, boolean>.type $eq_ErrorOr<T>_T(ErrorOr<T> /*&*/ Err, E Code) {
//  return Native.$eq(std.error_code(Err), Code);
//}
//
//
//// Create wrappers for C Binding types (see CBindingWrapping.h).
////<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 169,
// FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP22LLVMOpaqueMemoryBuffer",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm6unwrapEP22LLVMOpaqueMemoryBuffer")
////</editor-fold>
//public static /*inline*/ MemoryBuffer /*P*/ unwrap( LLVMOpaqueMemoryBuffer /*P*/ P) {
//  return /*delegate*/org.llvm.support.impl.MemoryBufferLlvmGlobals.
//    unwrap(P);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::wrap">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/MemoryBuffer.h", line = 169,
// FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_12MemoryBufferE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvm4wrapEPKNS_12MemoryBufferE")
////</editor-fold>
//public static /*inline*/  LLVMOpaqueMemoryBuffer /*P*/ wrap(/*const*/ MemoryBuffer /*P*/ P) {
//  return /*delegate*/org.llvm.support.impl.MemoryBufferLlvmGlobals.
//    wrap(P);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::capacity_in_bytes">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Capacity.h", line = 23,
// FQN="llvm::capacity_in_bytes", NM="_ZN4llvmL17capacity_in_bytesERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN4llvmL17capacity_in_bytesERKT_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> /*size_t*/int capacity_in_bytes(/*const*/ T /*&*/ x) {
//  return /*delegate*/org.llvm.support.impl.CapacityLlvmGlobals.
//    capacity_in_bytes(x);
//}
//
///*template <typename T> TEMPLATE*/
//
//// operator!=/operator== - Allow mixed comparisons without dereferencing
//// the iterator, which could very likely be pointing to end().
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 252,
// FQN="llvm::operator!=", NM="_ZN4llvmneEPKT_RKNS_14ilist_iteratorIS1_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvmneEPKT_RKNS_14ilist_iteratorIS1_EE")
////</editor-fold>
//public static </*typename*/ T> boolean $noteq_T_ilist_iterator< T>(/*const*/ T /*P*/ LHS, /*const*/ ilist_iterator</*const*/ T> /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.IlistLlvmGlobals.
//    $noteq_T_ilist_iterator< T>(LHS, RHS);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 256,
// FQN="llvm::operator==", NM="_ZN4llvmeqEPKT_RKNS_14ilist_iteratorIS1_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvmeqEPKT_RKNS_14ilist_iteratorIS1_EE")
////</editor-fold>
//public static </*typename*/ T> boolean $eq_T_ilist_iterator< T>(/*const*/ T /*P*/ LHS, /*const*/ ilist_iterator</*const*/ T> /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.IlistLlvmGlobals.
//    $eq_T_ilist_iterator< T>(LHS, RHS);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 260,
// FQN="llvm::operator!=", NM="_ZN4llvmneEPT_RKNS_14ilist_iteratorIS0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvmneEPT_RKNS_14ilist_iteratorIS0_EE")
////</editor-fold>
//public static </*typename*/ T> boolean $noteq_T_ilist_iterator<T>(T /*P*/ LHS, /*const*/ ilist_iterator<T> /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.IlistLlvmGlobals.
//    $noteq_T_ilist_iterator<T>(LHS, RHS);
//}
//
///*template <typename T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 264,
// FQN="llvm::operator==", NM="_ZN4llvmeqEPT_RKNS_14ilist_iteratorIS0_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvmeqEPT_RKNS_14ilist_iteratorIS0_EE")
////</editor-fold>
//public static </*typename*/ T> boolean $eq_T_ilist_iterator<T>(T /*P*/ LHS, /*const*/ ilist_iterator<T> /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.IlistLlvmGlobals.
//    $eq_T_ilist_iterator<T>(LHS, RHS);
//}
//
//
///// PrintRecyclingAllocatorStats - Helper for RecyclingAllocator for
///// printing statistics.
/////
//// End namespace detail.
////<editor-fold defaultstate="collapsed" desc="llvm::PrintRecyclerStats">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Allocator.cpp", line = 37,
// FQN="llvm::PrintRecyclerStats", NM="_ZN4llvm18PrintRecyclerStatsEmmm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Allocator.cpp -nm=_ZN4llvm18PrintRecyclerStatsEmmm")
////</editor-fold>
//public static void PrintRecyclerStats(/*size_t*/int Size, 
//                  /*size_t*/int Align, 
//                  /*size_t*/int FreeListSize) {
//  /*delegate*/org.llvm.support.impl.AllocatorLlvmStatics.
//    PrintRecyclerStats(Size, 
//                  Align, 
//                  FreeListSize);
//}
//
///*template <class T> TEMPLATE*/
//
//// Provide global constructors that automatically figure out correct types...
////
////<editor-fold defaultstate="collapsed" desc="llvm::po_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 176,
// FQN="llvm::po_begin", NM="_ZN4llvm8po_beginET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm8po_beginET_")
////</editor-fold>
//public static </*class*/ T> po_iterator<T> po_begin(T G) {
//  return po_iterator<T>.begin(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 178,
// FQN="llvm::po_end", NM="_ZN4llvm6po_endET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm6po_endET_")
////</editor-fold>
//public static </*class*/ T> po_iterator<T> po_end(T G) {
//  return po_iterator<T>.end(G);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 188,
// FQN="llvm::po_ext_begin", NM="_ZN4llvm12po_ext_beginET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm12po_ext_beginET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> po_ext_iterator<T, SetType> po_ext_begin(T G, SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    po_ext_begin(G, S);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::po_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 193,
// FQN="llvm::po_ext_end", NM="_ZN4llvm10po_ext_endET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm10po_ext_endET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> po_ext_iterator<T, SetType> po_ext_end(T G, SetType /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.PostOrderIteratorLlvmGlobals.
//    po_ext_end(G, S);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 207,
// FQN="llvm::ipo_begin", NM="_ZN4llvm9ipo_beginET_b",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm9ipo_beginET_b")
////</editor-fold>
//public static </*class*/ T> ipo_iterator<T> ipo_begin(T G) {
//  return ipo_begin(G, false);
//}
//public static </*class*/ T> ipo_iterator<T> ipo_begin(T G, boolean Reverse/*= false*/) {
//  return ipo_iterator<T>.begin(G, Reverse);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 212,
// FQN="llvm::ipo_end", NM="_ZN4llvm7ipo_endET_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm7ipo_endET_")
////</editor-fold>
//public static </*class*/ T> ipo_iterator<T> ipo_end(T G) {
//  return ipo_iterator<T>.end(G);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 227,
// FQN="llvm::ipo_ext_begin", NM="_ZN4llvm13ipo_ext_beginET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm13ipo_ext_beginET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> ipo_ext_iterator<T, SetType> ipo_ext_begin(T G, SetType /*&*/ S) {
//  return ipo_ext_iterator<T, SetType>.begin(G, S);
//}
//
///*template <class T, class SetType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::ipo_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/PostOrderIterator.h", line = 232,
// FQN="llvm::ipo_ext_end", NM="_ZN4llvm11ipo_ext_endET_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN4llvm11ipo_ext_endET_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetType> ipo_ext_iterator<T, SetType> ipo_ext_end(T G, SetType /*&*/ S) {
//  return ipo_ext_iterator<T, SetType>.end(G, S);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/BranchProbability.h", line = 83,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_17BranchProbabilityE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_17BranchProbabilityE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_BranchProbability(raw_ostream /*&*/ OS, /*const*/ BranchProbability /*&*/ Prob) {
//  return Prob.print(OS);
//}
//
///*template <typename T> TEMPLATE*/
//
///// These are helper functions used to produce formatted output.  They use
///// template type deduction to construct the appropriate instance of the
///// format_object class to simplify their construction.
/////
///// This is typically used like:
///// \code
/////   OS << format("%0.4f", myfloat) << '\n';
///// \endcode
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 191,
// FQN="llvm::format", NM="_ZN4llvm6formatEPKcRKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm6formatEPKcRKT_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T> format_object1<T> format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ T /*&*/ Val) {
//  return format_object1<T>(Fmt, Val);
//}
//
///*template <typename T1, typename T2> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 196,
// FQN="llvm::format", NM="_ZN4llvm6formatEPKcRKT_RKT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm6formatEPKcRKT_RKT0_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2> format_object2<T1, T2> format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ T1 /*&*/ Val1, 
//      /*const*/ T2 /*&*/ Val2) {
//  return format_object2<T1, T2>(Fmt, Val1, Val2);
//}
//
///*template <typename T1, typename T2, typename T3> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 202,
// FQN="llvm::format", NM="_ZN4llvm6formatEPKcRKT_RKT0_RKT1_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm6formatEPKcRKT_RKT0_RKT1_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3> format_object3<T1, T2, T3> format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ T1 /*&*/ Val1, 
//      /*const*/ T2 /*&*/ Val2, /*const*/ T3 /*&*/ Val3) {
//  return format_object3<T1, T2, T3>(Fmt, Val1, Val2, Val3);
//}
//
///*template <typename T1, typename T2, typename T3, typename T4> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 208,
// FQN="llvm::format", NM="_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4> format_object4<T1, T2, T3, T4> format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ T1 /*&*/ Val1, 
//      /*const*/ T2 /*&*/ Val2, /*const*/ T3 /*&*/ Val3, 
//      /*const*/ T4 /*&*/ Val4) {
//  return format_object4<T1, T2, T3, T4>(Fmt, Val1, Val2, Val3, Val4);
//}
//
///*template <typename T1, typename T2, typename T3, typename T4, typename T5> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 215,
// FQN="llvm::format", NM="_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_RKT3_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_RKT3_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5> format_object5<T1, T2, T3, T4, T5> format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ T1 /*&*/ Val1, 
//      /*const*/ T2 /*&*/ Val2, /*const*/ T3 /*&*/ Val3, 
//      /*const*/ T4 /*&*/ Val4, /*const*/ T5 /*&*/ Val5) {
//  return format_object5<T1, T2, T3, T4, T5>(Fmt, Val1, Val2, Val3, Val4, Val5);
//}
//
///*template <typename T1, typename T2, typename T3, typename T4, typename T5, typename T6> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::format">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 223,
// FQN="llvm::format", NM="_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_RKT3_RKT4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm6formatEPKcRKT_RKT0_RKT1_RKT2_RKT3_RKT4_")
////</editor-fold>
//public static /*inline*/ </*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5, /*typename*/ T6> format_object6<T1, T2, T3, T4, T5, T6> format(/*const*/char$ptr/*char P*/ Fmt, /*const*/ T1 /*&*/ Val1, /*const*/ T2 /*&*/ Val2, /*const*/ T3 /*&*/ Val3, 
//      /*const*/ T4 /*&*/ Val4, /*const*/ T5 /*&*/ Val5, /*const*/ T6 /*&*/ Val6) {
//  return format_object6<T1, T2, T3, T4, T5, T6>(Fmt, Val1, Val2, Val3, Val4, Val5, Val6);
//}


/// left_justify - append spaces after string so total output is
/// \p Width characters.  If \p Str is larger that \p Width, full string
/// is written with no padding.
//<editor-fold defaultstate="collapsed" desc="llvm::left_justify">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 244,
 FQN="llvm::left_justify", NM="_ZN4llvm12left_justifyENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm12left_justifyENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ FormattedString left_justify(StringRef Str, /*uint*/int Width) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    left_justify(Str, Width);
}


/// right_justify - add spaces before string so total output is
/// \p Width characters.  If \p Str is larger that \p Width, full string
/// is written with no padding.
//<editor-fold defaultstate="collapsed" desc="llvm::right_justify">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 251,
 FQN="llvm::right_justify", NM="_ZN4llvm13right_justifyENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm13right_justifyENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ FormattedString right_justify(StringRef Str, /*uint*/int Width) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    right_justify(Str, Width);
}


/// format_hex - Output \p N as a fixed width hexadecimal. If number will not
/// fit in width, full number is still printed.  Examples:
///   OS << format_hex(255, 4)        => 0xff
///   OS << format_hex(255, 4, true)  => 0xFF
///   OS << format_hex(255, 6)        => 0x00ff
///   OS << format_hex(255, 2)        => 0xff
//<editor-fold defaultstate="collapsed" desc="llvm::format_hex">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 274,
 FQN="llvm::format_hex", NM="_ZN4llvm10format_hexEmjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm10format_hexEmjb")
//</editor-fold>
public static /*inline*/ FormattedNumber format_hex(long/*uint64_t*/ N, /*uint*/int Width) {
  return format_hex(N, Width, false);
}
public static /*inline*/ FormattedNumber format_hex(long/*uint64_t*/ N, /*uint*/int Width, boolean Upper/*= false*/) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    format_hex(N, Width, Upper);
}


/// format_decimal - Output \p N as a right justified, fixed-width decimal. If 
/// number will not fit in width, full number is still printed.  Examples:
///   OS << format_decimal(0, 5)     => "    0"
///   OS << format_decimal(255, 5)   => "  255"
///   OS << format_decimal(-1, 3)    => " -1"
///   OS << format_decimal(12345, 3) => "12345"
//<editor-fold defaultstate="collapsed" desc="llvm::format_decimal">
@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 285,
 FQN="llvm::format_decimal", NM="_ZN4llvm14format_decimalElj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/BranchProbability.cpp -nm=_ZN4llvm14format_decimalElj")
//</editor-fold>
public static /*inline*/ FormattedNumber format_decimal(long/*int64_t*/ N, /*uint*/int Width) {
  return /*delegate*/org.llvm.support.impl.FormatLlvmGlobals.
    format_decimal(N, Width);
}


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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 17,
// FQN="llvm::ConvertUTF8toWide", NM="_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm17ConvertUTF8toWideEjNS_9StringRefERPcRPKh")
////</editor-fold>
//public static boolean ConvertUTF8toWide(/*uint*/int WideCharWidth, StringRef Source, 
//                 type$ref<char$ptr>/*char P&*/ ResultPtr, /*const*/type$ref<char$ptr>/*UTF8 P&*/ ErrorPtr) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    ConvertUTF8toWide(WideCharWidth, Source, 
//                 ResultPtr, ErrorPtr);
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 63,
// FQN="llvm::ConvertCodePointToUTF8", NM="_ZN4llvm22ConvertCodePointToUTF8EjRPc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm22ConvertCodePointToUTF8EjRPc")
////</editor-fold>
//public static boolean ConvertCodePointToUTF8(/*uint*/int Source, type$ref<char$ptr>/*char P&*/ ResultPtr) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    ConvertCodePointToUTF8(Source, ResultPtr);
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ConvertUTF.h", line = 227,
// FQN="llvm::convertUTF8Sequence", NM="_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvmL19convertUTF8SequenceEPPKhS1_Pj15ConversionFlags")
////</editor-fold>
//public static /*inline*/  ConversionResult convertUTF8Sequence(/*const*/type$ptr<char$ptr>/*UTF8 P P*/ source, 
//                   /*const*/char$ptr/*UTF8 P*/ sourceEnd, 
//                   uint$ptr/*UTF32 P*/ target, 
//                    ConversionFlags flags) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFLlvmGlobals.
//    convertUTF8Sequence(source, 
//                   sourceEnd, 
//                   target, 
//                   flags);
//}
//
//
///**
//* Returns true if a blob of text starts with a UTF-16 big or little endian byte
//* order mark.
//*/
////<editor-fold defaultstate="collapsed" desc="llvm::hasUTF16ByteOrderMark">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 78,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp", line = 84,
// FQN="llvm::convertUTF16ToUTF8String", NM="_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ConvertUTFWrapper.cpp -nm=_ZN4llvm24convertUTF16ToUTF8StringENS_8ArrayRefIcEERSs")
////</editor-fold>
//public static boolean convertUTF16ToUTF8String(ArrayRefChar SrcBytes, std.string/*&*/ Out) {
//  return /*delegate*/org.llvm.support.impl.ConvertUTFWrapperLlvmGlobals.
//    convertUTF16ToUTF8String(SrcBytes, Out);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::getDataFileStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/DataStream.cpp", line = 81,
// FQN="llvm::getDataFileStreamer", NM="_ZN4llvm19getDataFileStreamerERKSsPSs",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/DataStream.cpp -nm=_ZN4llvm19getDataFileStreamerERKSsPSs")
////</editor-fold>
//public static DataStreamer /*P*/ getDataFileStreamer(/*const*/std.string/*&*/ Filename, 
//                   std.string/*P*/ StrError) {
//  return /*delegate*/org.llvm.support.impl.DataStreamLlvmGlobals.
//    getDataFileStreamer(Filename, 
//                   StrError);
//}
//
//
///// isCurrentDebugType - Return true if the specified string is the debug type
///// specified on the command line, or if none was specified on the command line
///// with the -debug-only=X option.
/////
//
//// isCurrentDebugType - Return true if the specified string is the debug type
//// specified on the command line, or if none was specified on the command line
//// with the -debug-only=X option.
////
////<editor-fold defaultstate="collapsed" desc="llvm::isCurrentDebugType">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 91,
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
///// setCurrentDebugType - Set the current debug type, as if the -debug-only=X
///// option were specified.  Note that DebugFlag also needs to be set to true for
///// debug output to be produced.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::setCurrentDebugType">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 107,
// FQN="llvm::setCurrentDebugType", NM="_ZN4llvm19setCurrentDebugTypeEPKc",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm19setCurrentDebugTypeEPKc")
////</editor-fold>
//public static void setCurrentDebugType(/*const*/char$ptr/*char P*/ Type) {
//  /*delegate*/org.llvm.support.impl.DebugLlvmGlobals.
//    setCurrentDebugType(Type);
//}
//
//
///// dbgs() - This returns a reference to a raw_ostream for debugging
///// messages.  If debugging is disabled it returns errs().  Use it
///// like: dbgs() << "foo" << "bar";
//
///// dbgs - Return a circular-buffered debug stream.
////<editor-fold defaultstate="collapsed" desc="llvm::dbgs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 113,
// FQN="llvm::dbgs", NM="_ZN4llvm4dbgsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm4dbgsEv")
////</editor-fold>
//public static raw_ostream /*&*/ dbgs() {
//  return /*delegate*/org.llvm.support.impl.DebugLlvmGlobals.
//    dbgs();
//}
//
///*template <class C> TEMPLATE*/
//
///// object_creator - Helper method for ManagedStatic.
////<editor-fold defaultstate="collapsed" desc="llvm::object_creator">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 25,
// FQN="llvm::object_creator", NM="_ZN4llvm14object_creatorEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm14object_creatorEv")
////</editor-fold>
//public static </*class*/ C> Object/*void P*/ object_creator() {
//  return /*delegate*/org.llvm.support.impl.ManagedStaticLlvmGlobals.
//    object_creator();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::DebugFlag">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 36,
// FQN="llvm::DebugFlag", NM="_ZN4llvm9DebugFlagE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm9DebugFlagE")
////</editor-fold>
//public static boolean DebugFlag;
//
///// EnableDebugBuffering - Turn on signal handler installation.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::EnableDebugBuffering">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Debug.cpp", line = 146,
// FQN="llvm::EnableDebugBuffering", NM="_ZN4llvm20EnableDebugBufferingE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Debug.cpp -nm=_ZN4llvm20EnableDebugBufferingE")
////</editor-fold>
//public static boolean EnableDebugBuffering = /*delegate*/org.llvm.support.impl.DebugLlvmGlobals.EnableDebugBuffering;
//
///// \brief Construct a new ELF writer instance.
/////
///// \param MOTW - The target specific ELF writer subclass.
///// \param OS - The stream to write to.
///// \returns The constructed object writer.
////<editor-fold defaultstate="collapsed" desc="llvm::createELFObjectWriter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp", line = 1806,
// FQN="llvm::createELFObjectWriter", NM="_ZN4llvm21createELFObjectWriterEPNS_23MCELFObjectTargetWriterERNS_11raw_ostreamEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm21createELFObjectWriterEPNS_23MCELFObjectTargetWriterERNS_11raw_ostreamEb")
////</editor-fold>
//public static MCObjectWriter /*P*/ createELFObjectWriter(MCELFObjectTargetWriter /*P*/ MOTW, 
//                     raw_ostream /*&*/ OS, 
//                     boolean IsLittleEndian) {
//  return new ELFObjectWriter(MOTW, OS, IsLittleEndian);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 127,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCExprE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCExprE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCExpr(raw_ostream /*&*/ OS, /*const*/ MCExpr /*&*/ E) {
//  return /*delegate*/org.llvm.mc.impl.MCExprLlvmGlobals.
//    $out_raw_ostream_MCExpr(OS, E);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MachineLocation.h", line = 77,
// FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_15MachineLocationES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmneERKNS_15MachineLocationES2_")
////</editor-fold>
//public static /*inline*/ boolean $noteq_MachineLocation(/*const*/ MachineLocation /*&*/ LHS, /*const*/ MachineLocation /*&*/ RHS) {
//  return !(LHS.$eq(RHS));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 195,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_9MCOperandE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_9MCOperandE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCOperand(raw_ostream /*&*/ OS, /*const*/ MCOperand /*&*/ MO) {
//  return /*delegate*/org.llvm.mc.impl.MCInstLlvmGlobals.
//    $out_raw_ostream_MCOperand(OS, MO);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 200,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCInstE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6MCInstE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCInst(raw_ostream /*&*/ OS, /*const*/ MCInst /*&*/ MI) {
//  return /*delegate*/org.llvm.mc.impl.MCInstLlvmGlobals.
//    $out_raw_ostream_MCInst(OS, MI);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirectiveName">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 44,
// FQN="llvm::MCLOHDirectiveName", NM="_ZN4llvmL18MCLOHDirectiveNameEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmL18MCLOHDirectiveNameEv")
////</editor-fold>
//public static /*inline*/ StringRef MCLOHDirectiveName() {
//  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
//    MCLOHDirectiveName();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::isValidMCLOHType">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 48,
// FQN="llvm::isValidMCLOHType", NM="_ZN4llvmL16isValidMCLOHTypeEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmL16isValidMCLOHTypeEj")
////</editor-fold>
//public static /*inline*/ boolean isValidMCLOHType(/*uint*/int Kind) {
//  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
//    isValidMCLOHType(Kind);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::MCLOHNameToId">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 52,
// FQN="llvm::MCLOHNameToId", NM="_ZN4llvmL13MCLOHNameToIdENS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmL13MCLOHNameToIdENS_9StringRefE")
////</editor-fold>
//public static /*inline*/ int MCLOHNameToId(StringRef Name) {
//  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
//    MCLOHNameToId(Name);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::MCLOHIdToName">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 66,
// FQN="llvm::MCLOHIdToName", NM="_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmL13MCLOHIdToNameENS_9MCLOHTypeE")
////</editor-fold>
//public static /*inline*/ StringRef MCLOHIdToName(MCLOHType Kind) {
//  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
//    MCLOHIdToName(Kind);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::MCLOHIdToNbArgs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 81,
// FQN="llvm::MCLOHIdToNbArgs", NM="_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmL15MCLOHIdToNbArgsENS_9MCLOHTypeE")
////</editor-fold>
//public static /*inline*/ int MCLOHIdToNbArgs(MCLOHType Kind) {
//  return /*delegate*/org.llvm.mc.impl.MCLinkerOptimizationHintLlvmGlobals.
//    MCLOHIdToNbArgs(Kind);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::(anonymous)">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCELFSymbolFlags.h", line = 23,
// FQN="llvm::(anonymous)", NM="_Z4llvm_MCELFSymbolFlags_h_Unnamed_enum",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_Z4llvm_MCELFSymbolFlags_h_Unnamed_enum")
////</editor-fold>
///*enum ANONYMOUS_HEX_CONSTANTS {*/
//  public static final int ELF_STT_Shift = 0; // Shift value for STT_* flags.
//  public static final int ELF_STB_Shift = 4; // Shift value for STB_* flags.
//  public static final int ELF_STV_Shift = 8; // Shift value for STV_* flags.
//  public static final int ELF_STO_Shift = 10; // Shift value for STO_* flags.
///*}*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbol.h", line = 175,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_8MCSymbolE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_8MCSymbolE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCSymbol(raw_ostream /*&*/ OS, /*const*/ MCSymbol /*&*/ Sym) {
//  return /*delegate*/org.llvm.mc.impl.MCSymbolLlvmGlobals.
//    $out_raw_ostream_MCSymbol(OS, Sym);
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 47,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 55,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 61,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 65,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorERKSsb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKSsb")
////</editor-fold>
//public static void report_fatal_error(/*const*/std.string/*&*/ Reason) {
//  report_fatal_error(Reason, true);
//}
//public static void report_fatal_error(/*const*/std.string/*&*/ Reason, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    report_fatal_error(Reason, GenCrashDiag);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::report_fatal_error">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 69,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 73,
// FQN="llvm::report_fatal_error", NM="_ZN4llvm18report_fatal_errorERKNS_5TwineEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm18report_fatal_errorERKNS_5TwineEb")
////</editor-fold>
//public static void report_fatal_error(/*const*/ Twine /*&*/ Reason) {
//  report_fatal_error(Reason, true);
//}
//public static void report_fatal_error(/*const*/ Twine /*&*/ Reason, boolean GenCrashDiag/*= true*/) {
//  /*delegate*/org.llvm.support.impl.ErrorHandlingLlvmGlobals.
//    report_fatal_error(Reason, GenCrashDiag);
//}
//
//
///// This function calls abort(), and prints the optional message to stderr.
///// Use the llvm_unreachable macro (that adds location info), instead of
///// calling this function directly.
////<editor-fold defaultstate="collapsed" desc="llvm::llvm_unreachable_internal">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp", line = 106,
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
//
////<editor-fold defaultstate="collapsed" desc="llvm::make_error_code">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/Errc.h", line = 78,
// FQN="llvm::make_error_code", NM="_ZN4llvm15make_error_codeENS_4errcE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ErrorHandling.cpp -nm=_ZN4llvm15make_error_codeENS_4errcE")
////</editor-fold>
//public static /*inline*/ std.error_code make_error_code(errc E) {
//  return /*delegate*/org.llvm.support.impl.ErrcLlvmGlobals.
//    make_error_code(E);
//}
//
//
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/FileUtilities.cpp", line = 173,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 89,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 96,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp", line = 103,
// FQN="llvm::fdbgs", NM="_ZN4llvm5fdbgsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/FormattedStream.cpp -nm=_ZN4llvm5fdbgsEv")
////</editor-fold>
//public static formatted_raw_ostream /*&*/ fdbgs() {
//  return /*delegate*/org.llvm.support.impl.FormattedStreamLlvmGlobals.
//    fdbgs();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::DisplayGraph">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 134,
// FQN="llvm::DisplayGraph", NM="_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm12DisplayGraphENS_9StringRefEbNS_12GraphProgram4NameE")
////</editor-fold>
//public static boolean DisplayGraph(StringRef FilenameRef) {
//  return DisplayGraph(FilenameRef, true, 
//            GraphProgram.Name.DOT);
//}
//public static boolean DisplayGraph(StringRef FilenameRef, boolean wait/*= true*/) {
//  return DisplayGraph(FilenameRef, wait, 
//            GraphProgram.Name.DOT);
//}
//public static boolean DisplayGraph(StringRef FilenameRef, boolean wait/*= true*/, 
//            GraphProgram.Name program/*= GraphProgram::DOT*/) {
//  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
//    DisplayGraph(FilenameRef, wait, 
//            program);
//}
//
///*template <typename GraphType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::WriteGraph">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 310,
// FQN="llvm::WriteGraph", NM="_ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm10WriteGraphERNS_11raw_ostreamERKT_bRKNS_5TwineE")
////</editor-fold>
//public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(raw_ostream /*&*/ O, /*const*/ GraphType /*&*/ G) {
//  return WriteGraph(O, G, 
//          false, 
//          new Twine(EMPTY));
//}
//public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(raw_ostream /*&*/ O, /*const*/ GraphType /*&*/ G, 
//          boolean ShortNames/*= false*/) {
//  return WriteGraph(O, G, 
//          ShortNames, 
//          new Twine(EMPTY));
//}
//public static </*typename*/ GraphType> raw_ostream /*&*/ WriteGraph(raw_ostream /*&*/ O, /*const*/ GraphType /*&*/ G, 
//          boolean ShortNames/*= false*/, 
//          /*const*/ Twine /*&*/ Title/*= ""*/) {
//  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
//    WriteGraph(O, G, 
//          ShortNames, 
//          Title);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::createGraphFilename">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 68,
// FQN="llvm::createGraphFilename", NM="_ZN4llvm19createGraphFilenameERKNS_5TwineERi",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm19createGraphFilenameERKNS_5TwineERi")
////</editor-fold>
//public static std.string createGraphFilename(/*const*/ Twine /*&*/ Name, int$ref/*int &*/ FD) {
//  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
//    createGraphFilename(Name, FD);
//}
//
///*template <typename GraphType> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::WriteGraph">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 325,
// FQN="llvm::WriteGraph", NM="_ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm10WriteGraphERKT_RKNS_5TwineEbS5_")
////</editor-fold>
//public static </*typename*/ GraphType> std.string WriteGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name) {
//  return WriteGraph(G, Name, 
//          false, new Twine(EMPTY));
//}
//public static </*typename*/ GraphType> std.string WriteGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name, 
//          boolean ShortNames/*= false*/) {
//  return WriteGraph(G, Name, 
//          ShortNames, new Twine(EMPTY));
//}
//public static </*typename*/ GraphType> std.string WriteGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name, 
//          boolean ShortNames/*= false*/, /*const*/ Twine /*&*/ Title/*= ""*/) {
//  return /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
//    WriteGraph(G, Name, 
//          ShortNames, Title);
//}
//
///*template <typename GraphType> TEMPLATE*/
//
///// ViewGraph - Emit a dot graph, run 'dot', run gv on the postscript file,
///// then cleanup.  For use from the debugger.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::ViewGraph">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 349,
// FQN="llvm::ViewGraph", NM="_ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm9ViewGraphERKT_RKNS_5TwineEbS5_NS_12GraphProgram4NameE")
////</editor-fold>
//public static </*typename*/ GraphType> void ViewGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name) {
//  ViewGraph(G, Name, 
//         false, new Twine(EMPTY), 
//         GraphProgram.Name.DOT);
//}
//public static </*typename*/ GraphType> void ViewGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name, 
//         boolean ShortNames/*= false*/) {
//  ViewGraph(G, Name, 
//         ShortNames, new Twine(EMPTY), 
//         GraphProgram.Name.DOT);
//}
//public static </*typename*/ GraphType> void ViewGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name, 
//         boolean ShortNames/*= false*/, /*const*/ Twine /*&*/ Title/*= ""*/) {
//  ViewGraph(G, Name, 
//         ShortNames, Title, 
//         GraphProgram.Name.DOT);
//}
//public static </*typename*/ GraphType> void ViewGraph(/*const*/ GraphType /*&*/ G, /*const*/ Twine /*&*/ Name, 
//         boolean ShortNames/*= false*/, /*const*/ Twine /*&*/ Title/*= ""*/, 
//         GraphProgram.Name Program/*= GraphProgram::DOT*/) {
//  /*delegate*/org.llvm.support.impl.GraphWriterLlvmGlobals.
//    ViewGraph(G, Name, 
//         ShortNames, Title, 
//         Program);
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Hashing.cpp", line = 27,
// FQN="llvm::set_fixed_execution_hash_seed", NM="_ZN4llvm29set_fixed_execution_hash_seedEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Hashing.cpp -nm=_ZN4llvm29set_fixed_execution_hash_seedEm")
////</editor-fold>
//public static void set_fixed_execution_hash_seed(/*size_t*/int fixed_value) {
//  /*delegate*/org.llvm.adt.impl.HashingLlvmGlobals.
//    set_fixed_execution_hash_seed(fixed_value);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsInf">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsInf.cpp", line = 46,
// FQN="llvm::IsInf", NM="_ZN4llvm5IsInfEf",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsInf.cpp -nm=_ZN4llvm5IsInfEf")
////</editor-fold>
//public static int IsInf_float(float f) {
//  return (sizeof (f) == sizeof(float.class) ? __isinff(f) : sizeof (f) == sizeof(double.class) ? __isinf(f) : __isinfl(f));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsInf">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsInf.cpp", line = 47,
// FQN="llvm::IsInf", NM="_ZN4llvm5IsInfEd",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsInf.cpp -nm=_ZN4llvm5IsInfEd")
////</editor-fold>
//public static int IsInf_double(double d) {
//  return (sizeof (d) == sizeof(float.class) ? __isinff(d) : sizeof (d) == sizeof(double.class) ? __isinf(d) : __isinfl(d));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsNAN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp", line = 31,
// FQN="llvm::IsNAN", NM="_ZN4llvm5IsNANEf",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp -nm=_ZN4llvm5IsNANEf")
////</editor-fold>
//public static int IsNAN_float(float f) {
//  return (sizeof (f) == sizeof(float.class) ? __isnanf(f) : sizeof (f) == sizeof(double.class) ? __isnan(f) : __isnanl(f));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsNAN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp", line = 32,
// FQN="llvm::IsNAN", NM="_ZN4llvm5IsNANEd",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp -nm=_ZN4llvm5IsNANEd")
////</editor-fold>
//public static int IsNAN_double(double d) {
//  return (sizeof (d) == sizeof(float.class) ? __isnanf(d) : sizeof (d) == sizeof(double.class) ? __isnan(d) : __isnanl(d));
//}
//
//
///// Utility function to encode a SLEB128 value to an output stream.
////<editor-fold defaultstate="collapsed" desc="llvm::encodeSLEB128">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 23,
// FQN="llvm::encodeSLEB128", NM="_ZN4llvm13encodeSLEB128ElRNS_11raw_ostreamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeSLEB128ElRNS_11raw_ostreamE")
////</editor-fold>
//public static /*inline*/ void encodeSLEB128(long/*int64_t*/ Value, raw_ostream /*&*/ OS) {
//  /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    encodeSLEB128(Value, OS);
//}
//
//
///// Utility function to encode a ULEB128 value to an output stream.
////<editor-fold defaultstate="collapsed" desc="llvm::encodeULEB128">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 38,
// FQN="llvm::encodeULEB128", NM="_ZN4llvm13encodeULEB128EmRNS_11raw_ostreamEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeULEB128EmRNS_11raw_ostreamEj")
////</editor-fold>
//public static /*inline*/ void encodeULEB128(long/*uint64_t*/ Value, raw_ostream /*&*/ OS) {
//  encodeULEB128(Value, OS, 
//             0);
//}
//public static /*inline*/ void encodeULEB128(long/*uint64_t*/ Value, raw_ostream /*&*/ OS, 
//             /*uint*/int Padding/*= 0*/) {
//  /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    encodeULEB128(Value, OS, 
//             Padding);
//}
//
//
///// Utility function to encode a ULEB128 value to a buffer. Returns
///// the length in bytes of the encoded value.
////<editor-fold defaultstate="collapsed" desc="llvm::encodeULEB128">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 58,
// FQN="llvm::encodeULEB128", NM="_ZN4llvm13encodeULEB128EmPhj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm13encodeULEB128EmPhj")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 80,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/LEB128.h", line = 94,
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
//
//
///// Utility function to get the size of the ULEB128-encoded value.
//
///// Utility function to get the size of the ULEB128-encoded value.
////<editor-fold defaultstate="collapsed" desc="llvm::getULEB128Size">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/LEB128.cpp", line = 20,
// FQN="llvm::getULEB128Size", NM="_ZN4llvm14getULEB128SizeEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm14getULEB128SizeEm")
////</editor-fold>
//public static /*uint*/int getULEB128Size(long/*uint64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    getULEB128Size(Value);
//}
//
//
///// Utility function to get the size of the SLEB128-encoded value.
//
///// Utility function to get the size of the SLEB128-encoded value.
////<editor-fold defaultstate="collapsed" desc="llvm::getSLEB128Size">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/LEB128.cpp", line = 30,
// FQN="llvm::getSLEB128Size", NM="_ZN4llvm14getSLEB128SizeEl",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/LEB128.cpp -nm=_ZN4llvm14getSLEB128SizeEl")
////</editor-fold>
//public static /*uint*/int getSLEB128Size(long/*int64_t*/ Value) {
//  return /*delegate*/org.llvm.support.impl.LEB128LlvmGlobals.
//    getSLEB128Size(Value);
//}
//
//
///// createAsmStreamer - Create a machine code streamer which will print out
///// assembly for the native target, suitable for compiling with a native
///// assembler.
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp", line = 1316,
// FQN="llvm::createAsmStreamer", NM="_ZN4llvm17createAsmStreamerERNS_9MCContextERNS_21formatted_raw_ostreamEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp -nm=_ZN4llvm17createAsmStreamerERNS_9MCContextERNS_21formatted_raw_ostreamEbbPNS_13MCInstPrinterEPNS_13MCCodeEmitterEPNS_12MCAsmBackendEb")
////</editor-fold>
//public static MCStreamer /*P*/ createAsmStreamer(MCContext /*&*/ Context, 
//                 formatted_raw_ostream /*&*/ OS, 
//                 boolean isVerboseAsm, boolean useDwarfDirectory, 
//                 MCInstPrinter /*P*/ IP, MCCodeEmitter /*P*/ CE, 
//                 MCAsmBackend /*P*/ MAB, boolean ShowInst) {
//  return new MCAsmStreamer(Context, OS, isVerboseAsm, useDwarfDirectory, IP, CE, 
//      MAB, ShowInst);
//}
//
//
//// Create wrappers for C Binding types (see CBindingWrapping.h).
////<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/CodeGen.h", line = 58,
// FQN="llvm::unwrap", NM="_ZN4llvm6unwrapE13LLVMCodeModel",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp -nm=_ZN4llvm6unwrapE13LLVMCodeModel")
////</editor-fold>
//public static /*inline*/ CodeModel.Model unwrap( LLVMCodeModel Model) {
//  return /*delegate*/org.llvm.support.impl.CodeGenLlvmGlobals.
//    unwrap(Model);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::wrap">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/CodeGen.h", line = 76,
// FQN="llvm::wrap", NM="_ZN4llvm4wrapENS_9CodeModel5ModelE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCAsmStreamer.cpp -nm=_ZN4llvm4wrapENS_9CodeModel5ModelE")
////</editor-fold>
//public static /*inline*/  LLVMCodeModel wrap(CodeModel.Model Model) {
//  return /*delegate*/org.llvm.support.impl.CodeGenLlvmGlobals.
//    wrap(Model);
//}
//
//
///// createELFStreamer - Create a machine code streamer which will generate
///// ELF format object files.
////<editor-fold defaultstate="collapsed" desc="llvm::createELFStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/MCELFStreamer.cpp", line = 561,
// FQN="llvm::createELFStreamer", NM="_ZN4llvm17createELFStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_11raw_ostreamEPNS_13MCCodeEmitterEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCELFStreamer.cpp -nm=_ZN4llvm17createELFStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_11raw_ostreamEPNS_13MCCodeEmitterEb")
////</editor-fold>
//public static MCStreamer /*P*/ createELFStreamer(MCContext /*&*/ Context, MCAsmBackend /*&*/ MAB, 
//                 raw_ostream /*&*/ OS, MCCodeEmitter /*P*/ CE, 
//                 boolean RelaxAll) {
//  MCELFStreamer /*P*/ S = new MCELFStreamer(Context, MAB, OS, CE);
//  if (RelaxAll) {
//    S.getAssembler().setRelaxAll(true);
//  }
//  return S;
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLabel.h", line = 52,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCLabelE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCLabel.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_7MCLabelE")
////</editor-fold>
//public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MCLabel(raw_ostream /*&*/ OS, /*const*/ MCLabel /*&*/ Label) {
//  return /*delegate*/org.llvm.mc.impl.MCLabelLlvmGlobals.
//    $out_raw_ostream_MCLabel(OS, Label);
//}
//
//
///// createMachOStreamer - Create a machine code streamer which will generate
///// Mach-O format object files.
/////
///// Takes ownership of \p TAB and \p CE.
////<editor-fold defaultstate="collapsed" desc="llvm::createMachOStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp", line = 456,
// FQN="llvm::createMachOStreamer", NM="_ZN4llvm19createMachOStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_11raw_ostreamEPNS_13MCCodeEmitterEbb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp -nm=_ZN4llvm19createMachOStreamerERNS_9MCContextERNS_12MCAsmBackendERNS_11raw_ostreamEPNS_13MCCodeEmitterEbb")
////</editor-fold>
//public static MCStreamer /*P*/ createMachOStreamer(MCContext /*&*/ Context, MCAsmBackend /*&*/ MAB, 
//                   raw_ostream /*&*/ OS, MCCodeEmitter /*P*/ CE) {
//  return createMachOStreamer(Context, MAB, 
//                   OS, CE, 
//                   false, 
//                   false);
//}
//public static MCStreamer /*P*/ createMachOStreamer(MCContext /*&*/ Context, MCAsmBackend /*&*/ MAB, 
//                   raw_ostream /*&*/ OS, MCCodeEmitter /*P*/ CE, 
//                   boolean RelaxAll/*= false*/) {
//  return createMachOStreamer(Context, MAB, 
//                   OS, CE, 
//                   RelaxAll, 
//                   false);
//}
//public static MCStreamer /*P*/ createMachOStreamer(MCContext /*&*/ Context, MCAsmBackend /*&*/ MAB, 
//                   raw_ostream /*&*/ OS, MCCodeEmitter /*P*/ CE, 
//                   boolean RelaxAll/*= false*/, 
//                   boolean LabelSections/*= false*/) {
//  MCMachOStreamer /*P*/ S = new MCMachOStreamer(Context, MAB, OS, CE, LabelSections);
//  if (RelaxAll) {
//    S.getAssembler().setRelaxAll(true);
//  }
//  return S;
//}
//
//
///// createNullStreamer - Create a dummy machine code streamer, which does
///// nothing. This is useful for timing the assembler front end.
////<editor-fold defaultstate="collapsed" desc="llvm::createNullStreamer">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp", line = 41,
// FQN="llvm::createNullStreamer", NM="_ZN4llvm18createNullStreamerERNS_9MCContextE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCNullStreamer.cpp -nm=_ZN4llvm18createNullStreamerERNS_9MCContextE")
////</editor-fold>
//public static MCStreamer /*P*/ createNullStreamer(MCContext /*&*/ Context) {
//  return /*delegate*/org.llvm.support.target.impl.MCNullStreamerLlvmGlobals.
//    createNullStreamer(Context);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 46,
// FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_15MCTargetOptionsES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZN4llvmeqERKNS_15MCTargetOptionsES2_")
////</editor-fold>
//public static /*inline*/ boolean $eq_MCTargetOptions(/*const*/ MCTargetOptions /*&*/ LHS, /*const*/ MCTargetOptions /*&*/ RHS) {
//  return /*delegate*/org.llvm.mc.impl.MCTargetOptionsLlvmGlobals.
//    $eq_MCTargetOptions(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 62,
// FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_15MCTargetOptionsES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZN4llvmneERKNS_15MCTargetOptionsES2_")
////</editor-fold>
//public static /*inline*/ boolean $noteq_MCTargetOptions(/*const*/ MCTargetOptions /*&*/ LHS, /*const*/ MCTargetOptions /*&*/ RHS) {
//  return /*delegate*/org.llvm.mc.impl.MCTargetOptionsLlvmGlobals.
//    $noteq_MCTargetOptions(LHS, RHS);
//}
//
//
///// \brief Construct a new Mach-O writer instance.
/////
///// This routine takes ownership of the target writer subclass.
/////
///// \param MOTW - The target specific Mach-O writer subclass.
///// \param OS - The stream to write to.
///// \returns The constructed object writer.
////<editor-fold defaultstate="collapsed" desc="llvm::createMachObjectWriter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp", line = 1015,
// FQN="llvm::createMachObjectWriter", NM="_ZN4llvm22createMachObjectWriterEPNS_24MCMachObjectTargetWriterERNS_11raw_ostreamEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm22createMachObjectWriterEPNS_24MCMachObjectTargetWriterERNS_11raw_ostreamEb")
////</editor-fold>
//public static MCObjectWriter /*P*/ createMachObjectWriter(MCMachObjectTargetWriter /*P*/ MOTW, 
//                      raw_ostream /*&*/ OS, 
//                      boolean IsLittleEndian) {
//  return new MachObjectWriter(MOTW, OS, IsLittleEndian);
//}
//
//
///// llvm_shutdown - Deallocate and destroy all ManagedStatic variables.
//
///// llvm_shutdown - Deallocate and destroy all ManagedStatic variables.
////<editor-fold defaultstate="collapsed" desc="llvm::llvm_shutdown">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", line = 85,
// FQN="llvm::llvm_shutdown", NM="_ZN4llvm13llvm_shutdownEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm13llvm_shutdownEv")
////</editor-fold>
//public static void llvm_shutdown() {
//  /*delegate*/org.llvm.support.impl.ManagedStaticLlvmGlobals.
//    llvm_shutdown();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::huge_valf">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp", line = 29,
// FQN="llvm::huge_valf", NM="_ZN4llvm9huge_valfE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MathExtras.cpp -nm=_ZN4llvm9huge_valfE")
////</editor-fold>
//public static /*const*/float huge_valf = /*delegate*/org.llvm.support.impl.MathExtrasLlvmGlobals.huge_valf;
////<editor-fold defaultstate="collapsed" desc="llvm::AsmRewritePrecedence">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetAsmParser.h", line = 44,
// FQN="llvm::AsmRewritePrecedence", NM="_ZN4llvmL20AsmRewritePrecedenceE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvmL20AsmRewritePrecedenceE")
////</editor-fold>
//public static /*const*//*char*/byte AsmRewritePrecedence[/*11*/] = /*delegate*/org.llvm.mc.impl.MCTargetAsmParserLlvmGlobals.AsmRewritePrecedence;
///// InitializeAllTargetInfos - The main program should call this function if
///// it wants access to all available targets that LLVM is configured to
///// support, to make them available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetInfos">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 53,
// FQN="llvm::InitializeAllTargetInfos", NM="_ZN4llvm24InitializeAllTargetInfosEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm24InitializeAllTargetInfosEv")
////</editor-fold>
//public static /*inline*/ void InitializeAllTargetInfos() {
//  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeAllTargetInfos();
//}
//
//
///// InitializeAllTargets - The main program should call this function if it
///// wants access to all available target machines that LLVM is configured to
///// support, to make them available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargets">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 63,
// FQN="llvm::InitializeAllTargets", NM="_ZN4llvm20InitializeAllTargetsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm20InitializeAllTargetsEv")
////</editor-fold>
//public static /*inline*/ void InitializeAllTargets() {
//  /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeAllTargets();
//}
//
//
///// InitializeAllTargetMCs - The main program should call this function if it
///// wants access to all available target MC that LLVM is configured to
///// support, to make them available via the TargetRegistry.
/////
///// It is legal for a client to make multiple calls to this function.
////<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetMCs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 76,
// FQN="llvm::InitializeAllTargetMCs", NM="_ZN4llvm22InitializeAllTargetMCsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm22InitializeAllTargetMCsEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 86,
// FQN="llvm::InitializeAllAsmPrinters", NM="_ZN4llvm24InitializeAllAsmPrintersEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm24InitializeAllAsmPrintersEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 96,
// FQN="llvm::InitializeAllAsmParsers", NM="_ZN4llvm23InitializeAllAsmParsersEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23InitializeAllAsmParsersEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 106,
// FQN="llvm::InitializeAllDisassemblers", NM="_ZN4llvm26InitializeAllDisassemblersEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm26InitializeAllDisassemblersEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 116,
// FQN="llvm::InitializeNativeTarget", NM="_ZN4llvm22InitializeNativeTargetEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm22InitializeNativeTargetEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 130,
// FQN="llvm::InitializeNativeTargetAsmPrinter", NM="_ZN4llvm32InitializeNativeTargetAsmPrinterEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm32InitializeNativeTargetAsmPrinterEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 142,
// FQN="llvm::InitializeNativeTargetAsmParser", NM="_ZN4llvm31InitializeNativeTargetAsmParserEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm31InitializeNativeTargetAsmParserEv")
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 154,
// FQN="llvm::InitializeNativeTargetDisassembler", NM="_ZN4llvm34InitializeNativeTargetDisassemblerEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm34InitializeNativeTargetDisassemblerEv")
////</editor-fold>
//public static /*inline*/ boolean InitializeNativeTargetDisassembler() {
//  return /*delegate*/org.llvm.support.target.impl.TargetSelectLlvmGlobals.
//    InitializeNativeTargetDisassembler();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::EnablePrettyStackTrace">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp", line = 143,
// FQN="llvm::EnablePrettyStackTrace", NM="_ZN4llvm22EnablePrettyStackTraceEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/PrettyStackTrace.cpp -nm=_ZN4llvm22EnablePrettyStackTraceEv")
////</editor-fold>
//public static void EnablePrettyStackTrace() {
//  /*delegate*/org.llvm.support.impl.PrettyStackTraceLlvmGlobals.
//    EnablePrettyStackTrace();
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator+">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 731,
// FQN="llvm::operator+", NM="_ZN4llvmplERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmplERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $add_ScaledNumber<DigitsT>(/*const*/ ScaledNumber<DigitsT> /*&*/ L, /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $add_ScaledNumber<DigitsT>(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator-">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 732,
// FQN="llvm::operator-", NM="_ZN4llvmmiERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmmiERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $sub_ScaledNumber<DigitsT>(/*const*/ ScaledNumber<DigitsT> /*&*/ L, /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $sub_ScaledNumber<DigitsT>(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator*">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 733,
// FQN="llvm::operator*", NM="_ZN4llvmmlERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmmlERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $star_ScaledNumber<DigitsT>(/*const*/ ScaledNumber<DigitsT> /*&*/ L, /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $star_ScaledNumber<DigitsT>(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator/">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 734,
// FQN="llvm::operator/", NM="_ZN4llvmdvERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmdvERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $slash_ScaledNumber<DigitsT>(/*const*/ ScaledNumber<DigitsT> /*&*/ L, /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $slash_ScaledNumber<DigitsT>(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 735,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmlsERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $out_ScaledNumber<DigitsT>(/*const*/ ScaledNumber<DigitsT> /*&*/ L, /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return ScaledNumber<DigitsT>(L) <<= R;
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator>>">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 736,
// FQN="llvm::operator>>", NM="_ZN4llvmrsERKNS_12ScaledNumberIT_EES4_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmrsERKNS_12ScaledNumberIT_EES4_")
////</editor-fold>
//public static </*class*/ DigitsT> ScaledNumber<DigitsT> $in_ScaledNumber<DigitsT>(/*const*/ ScaledNumber<DigitsT> /*&*/ L, /*const*/ ScaledNumber<DigitsT> /*&*/ R) {
//  return ScaledNumber<DigitsT>(L) >>= R;
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 740,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_12ScaledNumberIT_EE")
////</editor-fold>
//public static </*class*/ DigitsT> raw_ostream /*&*/ $out_raw_ostream_ScaledNumber<DigitsT>(raw_ostream /*&*/ OS, /*const*/ ScaledNumber<DigitsT> /*&*/ X) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $out_raw_ostream_ScaledNumber<DigitsT>(OS, X);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 758,
// FQN="llvm::operator<", NM="_ZN4llvmltERKNS_12ScaledNumberIT_EEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmltERKNS_12ScaledNumberIT_EEm")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $less_ScaledNumber<DigitsT>_uint64_t(/*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $less_ScaledNumber<DigitsT>_uint64_t(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator>">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 759,
// FQN="llvm::operator>", NM="_ZN4llvmgtERKNS_12ScaledNumberIT_EEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmgtERKNS_12ScaledNumberIT_EEm")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $greater_ScaledNumber<DigitsT>_uint64_t(/*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $greater_ScaledNumber<DigitsT>_uint64_t(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator==">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 760,
// FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_12ScaledNumberIT_EEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmeqERKNS_12ScaledNumberIT_EEm")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $eq_ScaledNumber<DigitsT>_uint64_t(/*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $eq_ScaledNumber<DigitsT>_uint64_t(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 761,
// FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_12ScaledNumberIT_EEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmneERKNS_12ScaledNumberIT_EEm")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $noteq_ScaledNumber<DigitsT>_uint64_t(/*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $noteq_ScaledNumber<DigitsT>_uint64_t(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 762,
// FQN="llvm::operator<=", NM="_ZN4llvmleERKNS_12ScaledNumberIT_EEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmleERKNS_12ScaledNumberIT_EEm")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $lesseq_ScaledNumber<DigitsT>_uint64_t(/*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $lesseq_ScaledNumber<DigitsT>_uint64_t(L, R);
//}
//
///*template <class DigitsT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator>=">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/ScaledNumber.h", line = 763,
// FQN="llvm::operator>=", NM="_ZN4llvmgeERKNS_12ScaledNumberIT_EEm",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/ScaledNumber.cpp -nm=_ZN4llvmgeERKNS_12ScaledNumberIT_EEm")
////</editor-fold>
//public static </*class*/ DigitsT> boolean $greatereq_ScaledNumber<DigitsT>_uint64_t(/*const*/ ScaledNumber<DigitsT> /*&*/ L, long/*uint64_t*/ R) {
//  return /*delegate*/org.llvm.support.impl.ScaledNumberLlvmGlobals.
//    $greatereq_ScaledNumber<DigitsT>_uint64_t(L, R);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator&">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 578,
// FQN="llvm::operator&", NM="_ZN4llvmanERKNS_14SmallBitVectorES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN4llvmanERKNS_14SmallBitVectorES2_")
////</editor-fold>
//public static /*inline*/ SmallBitVector $bitand_SmallBitVector(/*const*/ SmallBitVector /*&*/ LHS, /*const*/ SmallBitVector /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.SmallBitVectorLlvmGlobals.
//    $bitand_SmallBitVector(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator|">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 585,
// FQN="llvm::operator|", NM="_ZN4llvmorERKNS_14SmallBitVectorES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN4llvmorERKNS_14SmallBitVectorES2_")
////</editor-fold>
//public static /*inline*/ SmallBitVector $bitor_SmallBitVector(/*const*/ SmallBitVector /*&*/ LHS, /*const*/ SmallBitVector /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.SmallBitVectorLlvmGlobals.
//    $bitor_SmallBitVector(LHS, RHS);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator^">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallBitVector.h", line = 592,
// FQN="llvm::operator^", NM="_ZN4llvmeoERKNS_14SmallBitVectorES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN4llvmeoERKNS_14SmallBitVectorES2_")
////</editor-fold>
//public static /*inline*/ SmallBitVector $bitxor_SmallBitVector(/*const*/ SmallBitVector /*&*/ LHS, /*const*/ SmallBitVector /*&*/ RHS) {
//  return /*delegate*/org.llvm.adt.impl.SmallBitVectorLlvmGlobals.
//    $bitxor_SmallBitVector(LHS, RHS);
//}
//
//
///// \brief Enable the collection and printing of statistics.
////<editor-fold defaultstate="collapsed" desc="llvm::EnableStatistics">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 92,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 96,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 139,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 100,
// FQN="llvm::PrintStatistics", NM="_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN4llvm15PrintStatisticsERNS_11raw_ostreamE")
////</editor-fold>
//public static void PrintStatistics(raw_ostream /*&*/ OS) {
//  /*delegate*/org.llvm.adt.impl.StatisticLlvmGlobals.
//    PrintStatistics(OS);
//}
//
///*template <class T> TEMPLATE*/
//
//// Provide global constructors that automatically figure out correct types...
////
////<editor-fold defaultstate="collapsed" desc="llvm::df_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 202,
// FQN="llvm::df_begin", NM="_ZN4llvm8df_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm8df_beginERKT_")
////</editor-fold>
//public static </*class*/ T> df_iterator<T> df_begin(/*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_begin(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 207,
// FQN="llvm::df_end", NM="_ZN4llvm6df_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm6df_endERKT_")
////</editor-fold>
//public static </*class*/ T> df_iterator<T> df_end(/*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_end(G);
//}
//
///*template <class T> TEMPLATE*/
//
//// Provide an accessor method to use them in range-based patterns.
////<editor-fold defaultstate="collapsed" desc="llvm::depth_first">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 213,
// FQN="llvm::depth_first", NM="_ZN4llvm11depth_firstERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11depth_firstERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range<df_iterator<T> > depth_first(/*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    depth_first(G);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 225,
// FQN="llvm::df_ext_begin", NM="_ZN4llvm12df_ext_beginERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm12df_ext_beginERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> df_ext_iterator<T, SetTy> df_ext_begin(/*const*/ T /*&*/ G, SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_ext_begin(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::df_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 230,
// FQN="llvm::df_ext_end", NM="_ZN4llvm10df_ext_endERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm10df_ext_endERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> df_ext_iterator<T, SetTy> df_ext_end(/*const*/ T /*&*/ G, SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    df_ext_end(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::depth_first_ext">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 235,
// FQN="llvm::depth_first_ext", NM="_ZN4llvm15depth_first_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm15depth_first_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> iterator_range<df_ext_iterator<T, SetTy> > depth_first_ext(/*const*/ T /*&*/ G, 
//               SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    depth_first_ext(G, 
//               S);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 252,
// FQN="llvm::idf_begin", NM="_ZN4llvm9idf_beginERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm9idf_beginERKT_")
////</editor-fold>
//public static </*class*/ T> idf_iterator<T> idf_begin(/*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_begin(G);
//}
//
///*template <class T> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 257,
// FQN="llvm::idf_end", NM="_ZN4llvm7idf_endERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm7idf_endERKT_")
////</editor-fold>
//public static </*class*/ T> idf_iterator<T> idf_end(/*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_end(G);
//}
//
///*template <class T> TEMPLATE*/
//
//// Provide an accessor method to use them in range-based patterns.
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_depth_first">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 263,
// FQN="llvm::inverse_depth_first", NM="_ZN4llvm19inverse_depth_firstERKT_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm19inverse_depth_firstERKT_")
////</editor-fold>
//public static </*class*/ T> iterator_range<idf_iterator<T> > inverse_depth_first(/*const*/ T /*&*/ G) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    inverse_depth_first(G);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_ext_begin">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 277,
// FQN="llvm::idf_ext_begin", NM="_ZN4llvm13idf_ext_beginERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm13idf_ext_beginERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> idf_ext_iterator<T, SetTy> idf_ext_begin(/*const*/ T /*&*/ G, SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_ext_begin(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::idf_ext_end">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 282,
// FQN="llvm::idf_ext_end", NM="_ZN4llvm11idf_ext_endERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11idf_ext_endERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> idf_ext_iterator<T, SetTy> idf_ext_end(/*const*/ T /*&*/ G, SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    idf_ext_end(G, S);
//}
//
///*template <class T, class SetTy> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::inverse_depth_first_ext">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DepthFirstIterator.h", line = 287,
// FQN="llvm::inverse_depth_first_ext", NM="_ZN4llvm23inverse_depth_first_extERKT_RT0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm23inverse_depth_first_extERKT_RT0_")
////</editor-fold>
//public static </*class*/ T, /*class*/ SetTy> iterator_range<idf_ext_iterator<T, SetTy> > inverse_depth_first_ext(/*const*/ T /*&*/ G, 
//                       SetTy /*&*/ S) {
//  return /*delegate*/org.llvm.adt.impl.DepthFirstIteratorLlvmGlobals.
//    inverse_depth_first_ext(G, 
//                       S);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::getNonStreamedMemoryObject">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp", line = 117,
// FQN="llvm::getNonStreamedMemoryObject", NM="_ZN4llvm26getNonStreamedMemoryObjectEPKhS1_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StreamingMemoryObject.cpp -nm=_ZN4llvm26getNonStreamedMemoryObjectEPKhS1_")
////</editor-fold>
//public static MemoryObject /*P*/ getNonStreamedMemoryObject(/*const*/char$ptr/*uchar P*/ Start, 
//                          /*const*/char$ptr/*uchar P*/ End) {
//  return /*delegate*/org.llvm.support.impl.StreamingMemoryObjectLlvmGlobals.
//    getNonStreamedMemoryObject(Start, 
//                          End);
//}
//
//
///// StrInStrNoCase - Portable version of strcasestr.  Locates the first
///// occurrence of string 's1' in string 's2', ignoring case.  Returns
///// the offset of s2 in s1 or npos if s2 cannot be found.
//
///// StrInStrNoCase - Portable version of strcasestr.  Locates the first
///// occurrence of string 's1' in string 's2', ignoring case.  Returns
///// the offset of s2 in s1 or npos if s2 cannot be found.
////<editor-fold defaultstate="collapsed" desc="llvm::StrInStrNoCase">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 22,
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 38,
// FQN="llvm::getToken", NM="_ZN4llvm8getTokenENS_9StringRefES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm8getTokenENS_9StringRefES0_")
////</editor-fold>
//public static std.pair<StringRef, StringRef> getToken(StringRef Source) {
//  return getToken(Source, 
//        new StringRef($(" \t\n\013\014\015")));
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 51,
// FQN="llvm::SplitString", NM="_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_")
////</editor-fold>
//public static void SplitString(StringRef Source, 
//           SmallVectorImpl<StringRef> /*&*/ OutFragments) {
//  SplitString(Source, 
//           OutFragments, 
//           new StringRef($(" \t\n\013\014\015")));
//}
//public static void SplitString(StringRef Source, 
//           SmallVectorImpl<StringRef> /*&*/ OutFragments, 
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
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 339,
// FQN="llvm::getAsUnsignedInteger", NM="_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm20getAsUnsignedIntegerENS_9StringRefEjRy")
////</editor-fold>
//public static boolean getAsUnsignedInteger(StringRef Str, /*uint*/int Radix, 
//                    ullong$ref/*ullong &*/ Result) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    getAsUnsignedInteger(Str, Radix, 
//                    Result);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::getAsSignedInteger">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 380,
// FQN="llvm::getAsSignedInteger", NM="_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm18getAsSignedIntegerENS_9StringRefEjRx")
////</editor-fold>
//public static boolean getAsSignedInteger(StringRef Str, /*uint*/int Radix, 
//                  llong$ref/*llong &*/ Result) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    getAsSignedInteger(Str, Radix, 
//                  Result);
//}
//
//
///// \brief Compute a hash_code for a StringRef.
//
//// Implementation of StringRef hashing.
////<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 483,
// FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueENS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm10hash_valueENS_9StringRefE")
////</editor-fold>
//public static hash_code hash_value(StringRef S) {
//  return /*delegate*/org.llvm.adt.impl.StringRefLlvmGlobals.
//    hash_value(S);
//}
//
///*template <typename T> TEMPLATE*/
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
////<editor-fold defaultstate="collapsed" desc="llvm::ComputeEditDistance">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/ADT/edit_distance.h", line = 43,
// FQN="llvm::ComputeEditDistance", NM="_ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZN4llvm19ComputeEditDistanceENS_8ArrayRefIT_EES2_bj")
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
///// Determine if the raw_ostream provided is connected to a terminal. If so,
///// generate a warning message to errs() advising against display of bitcode
///// and return true. Otherwise just return false.
///// @brief Check for output written to a console
////<editor-fold defaultstate="collapsed" desc="llvm::CheckBitcodeOutputToConsole">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/SystemUtils.cpp", line = 21,
// FQN="llvm::CheckBitcodeOutputToConsole", NM="_ZN4llvm27CheckBitcodeOutputToConsoleERNS_11raw_ostreamEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/SystemUtils.cpp -nm=_ZN4llvm27CheckBitcodeOutputToConsoleERNS_11raw_ostreamEb")
////</editor-fold>
//public static boolean CheckBitcodeOutputToConsole(raw_ostream /*&*/ stream_to_check) {
//  return CheckBitcodeOutputToConsole(stream_to_check, 
//                           true);
//}
//public static boolean CheckBitcodeOutputToConsole(raw_ostream /*&*/ stream_to_check, 
//                           boolean print_warning/*= true*/) {
//  return /*delegate*/org.llvm.support.impl.SystemUtilsLlvmGlobals.
//    CheckBitcodeOutputToConsole(stream_to_check, 
//                           print_warning);
//}
//
///// Returns true if LLVM is compiled with support for multi-threading, and
///// false otherwise.
////<editor-fold defaultstate="collapsed" desc="llvm::llvm_is_multithreaded">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", line = 23,
// FQN="llvm::llvm_is_multithreaded", NM="_ZN4llvm21llvm_is_multithreadedEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=_ZN4llvm21llvm_is_multithreadedEv")
////</editor-fold>
//public static boolean llvm_is_multithreaded() {
//  return /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
//    llvm_is_multithreaded();
//}
//
//
///// llvm_execute_on_thread - Execute the given \p UserFn on a separate
///// thread, passing it the provided \p UserData and waits for thread 
///// completion.
/////
///// This function does not guarantee that the code will actually be executed
///// on a separate thread or honoring the requested stack size, but tries to do
///// so where system support is available.
/////
///// \param UserFn - The callback to execute.
///// \param UserData - An argument to pass to the callback function.
///// \param RequestedStackSize - If non-zero, a requested size (in bytes) for
///// the thread stack.
////<editor-fold defaultstate="collapsed" desc="llvm::llvm_execute_on_thread">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/Threading.cpp", line = 44,
// FQN="llvm::llvm_execute_on_thread", NM="_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/Threading.cpp -nm=_ZN4llvm22llvm_execute_on_threadEPFvPvES0_j")
////</editor-fold>
//public static void llvm_execute_on_thread(/*ADD MAPPING FOR[void (* )(void * )]*/void (/*P*/ Fn)(Object/*void P*/ ), Object/*void P*/ UserData) {
//  llvm_execute_on_thread(Fn, UserData, 
//                      0);
//}
//public static void llvm_execute_on_thread(/*ADD MAPPING FOR[void (* )(void * )]*/void (/*P*/ Fn)(Object/*void P*/ ), Object/*void P*/ UserData, 
//                      /*uint*/int RequestedStackSize/*= 0*/) {
//  /*delegate*/org.llvm.support.impl.ThreadingLlvmGlobals.
//    llvm_execute_on_thread(Fn, UserData, 
//                      RequestedStackSize);
//}
//
//
///// \brief Construct a new Win COFF writer instance.
/////
///// \param MOTW - The target specific WinCOFF writer subclass.
///// \param OS - The stream to write to.
///// \returns The constructed object writer.
////<editor-fold defaultstate="collapsed" desc="llvm::createWinCOFFObjectWriter">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp", line = 1059,
// FQN="llvm::createWinCOFFObjectWriter", NM="_ZN4llvm25createWinCOFFObjectWriterEPNS_27MCWinCOFFObjectTargetWriterERNS_11raw_ostreamE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/MC/WinCOFFObjectWriter.cpp -nm=_ZN4llvm25createWinCOFFObjectWriterEPNS_27MCWinCOFFObjectTargetWriterERNS_11raw_ostreamE")
////</editor-fold>
//public static MCObjectWriter /*P*/ createWinCOFFObjectWriter(MCWinCOFFObjectTargetWriter /*P*/ MOTW, 
//                         raw_ostream /*&*/ OS) {
//  return new WinCOFFObjectWriter(MOTW, OS);
//}
//
///*template <class NodeT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 154,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE")
////</editor-fold>
//public static </*class*/ NodeT> raw_ostream /*&*/ $out_raw_ostream_DomTreeNodeBase<NodeT>(raw_ostream /*&*/ o, /*const*/ DomTreeNodeBase<NodeT> /*P*/ Node) {
//  return /*delegate*/org.llvm.support.impl.GenericDomTreeLlvmGlobals.
//    $out_raw_ostream_DomTreeNodeBase<NodeT>(o, Node);
//}
//
///*template <class NodeT> TEMPLATE*/
////<editor-fold defaultstate="collapsed" desc="llvm::PrintDomTree">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 166,
// FQN="llvm::PrintDomTree", NM="_ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj")
////</editor-fold>
//public static </*class*/ NodeT> void PrintDomTree(/*const*/ DomTreeNodeBase<NodeT> /*P*/ N, raw_ostream /*&*/ o, 
//            /*uint*/int Lev) {
//  /*delegate*/org.llvm.support.impl.GenericDomTreeLlvmGlobals.
//    PrintDomTree(N, o, 
//            Lev);
//}
//
//
///// outs() - This returns a reference to a raw_ostream for standard output.
///// Use it like: outs() << "foo" << "bar";
//
////===----------------------------------------------------------------------===//
////  outs(), errs(), nulls()
////===----------------------------------------------------------------------===//
//
///// outs() - This returns a reference to a raw_ostream for standard output.
///// Use it like: outs() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::outs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 704,
// FQN="llvm::outs", NM="_ZN4llvm4outsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4outsEv")
////</editor-fold>
//public static raw_ostream /*&*/ outs() {
//  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
//    outs();
//}
//
//
///// errs() - This returns a reference to a raw_ostream for standard error.
///// Use it like: errs() << "foo" << "bar";
//
///// errs() - This returns a reference to a raw_ostream for standard error.
///// Use it like: errs() << "foo" << "bar";
////<editor-fold defaultstate="collapsed" desc="llvm::errs">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 714,
// FQN="llvm::errs", NM="_ZN4llvm4errsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm4errsEv")
////</editor-fold>
//public static raw_ostream /*&*/ errs() {
//  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
//    errs();
//}
//
//
///// nulls() - This returns a reference to a raw_ostream which simply discards
///// output.
//
///// nulls() - This returns a reference to a raw_ostream which discards output.
////<editor-fold defaultstate="collapsed" desc="llvm::nulls">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp", line = 721,
// FQN="llvm::nulls", NM="_ZN4llvm5nullsEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/raw_ostream.cpp -nm=_ZN4llvm5nullsEv")
////</editor-fold>
//public static raw_ostream /*&*/ nulls() {
//  return /*delegate*/org.llvm.support.impl.Raw_ostreamLlvmGlobals.
//    nulls();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsNAN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp", line = 31,
// FQN="llvm::IsNAN", NM="_ZN4llvm5IsNANEf",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp -nm=_ZN4llvm5IsNANEf")
////</editor-fold>
//public static int IsNAN_float(float f) {
//  return (sizeof (f) == sizeof(float.class) ? __isnanf(f) : sizeof (f) == sizeof(double.class) ? __isnan(f) : __isnanl(f));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsNAN">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp", line = 32,
// FQN="llvm::IsNAN", NM="_ZN4llvm5IsNANEd",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsNAN.cpp -nm=_ZN4llvm5IsNANEd")
////</editor-fold>
//public static int IsNAN_double(double d) {
//  return (sizeof (d) == sizeof(float.class) ? __isnanf(d) : sizeof (d) == sizeof(double.class) ? __isnan(d) : __isnanl(d));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsInf">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsInf.cpp", line = 46,
// FQN="llvm::IsInf", NM="_ZN4llvm5IsInfEf",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsInf.cpp -nm=_ZN4llvm5IsInfEf")
////</editor-fold>
//public static int IsInf_float(float f) {
//  return (sizeof (f) == sizeof(float.class) ? __isinff(f) : sizeof (f) == sizeof(double.class) ? __isinf(f) : __isinfl(f));
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::IsInf">
//@Converted(kind = Converted.Kind.BODY_DELEGATE, source = "${LLVM_SRC}/llvm/lib/Support/IsInf.cpp", line = 47,
// FQN="llvm::IsInf", NM="_ZN4llvm5IsInfEd",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/IsInf.cpp -nm=_ZN4llvm5IsInfEd")
////</editor-fold>
//public static int IsInf_double(double d) {
//  return (sizeof (d) == sizeof(float.class) ? __isinff(d) : sizeof (d) == sizeof(double.class) ? __isinf(d) : __isinfl(d));
//}
//
} // END OF class LlvmGlobals
