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
package org.llvm.bitcode.reader.impl;

import org.llvm.cl.aliases.optBool;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.bitcode.*;
import org.llvm.bitcode.java.impl.BitcodeErrorCategoryTypeInfo;
import org.llvm.cl.*;
import org.llvm.ir.java.IRFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type BitcodeReaderStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=Tpl__ZL15convertToStringN4llvm8ArrayRefIyEEjRT_;_BitcodeReader_cpp_Unnamed_enum;_ZL12unrotateSigny;_ZL13ErrorCategory;_ZL13readWideAPIntN4llvm8ArrayRefIyEEj;_ZL15getAttrFromCodey;_ZL17PrintSummaryGUIDs;_ZL17getDecodedLinkagej;_ZL17hasImplicitComdatj;_ZL18getDecodedOrderingj;_ZL20getBitcodeModuleImplSt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS1_EENS0_9StringRefEPN12_GLOBAL__N_113BitcodeReaderERNS0_11LLVMContextEbb;_ZL20getDecodedCastOpcodej;_ZL20getDecodedSynchScopej;_ZL20getDecodedVisibilityj;_ZL21hasValidBitcodeHeaderRN4llvm15BitstreamCursorE;_ZL22getDecodedBinaryOpcodejPN4llvm4TypeE;_ZL22getDecodedRMWOperationj;_ZL22jumpToValueSymbolTableyRN4llvm15BitstreamCursorE;_ZL22typeCheckLoadStoreInstPN4llvm4TypeES1_;_ZL23getDecodedFastMathFlagsj;_ZL24getDecodedGVSummaryFlagsyy;_ZL24getLazyBitcodeModuleImplOSt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS1_EERNS0_11LLVMContextEbb;_ZL25getDecodedDLLStorageClassj;_ZL25getDecodedThreadLocalModej;_ZL25getDecodedUnnamedAddrTypej;_ZL29getDecodedComdatSelectionKindj;_ZL29upgradeDLLImportExportLinkagePN4llvm11GlobalValueEj;_ZL30decodeLLVMAttributesForBitcodeRN4llvm11AttrBuilderEy;_ZL5errorRKSt8functionIFvRKN4llvm14DiagnosticInfoEEESt10error_codeRKNS0_5TwineE;_ZL5errorRN4llvm11LLVMContextERKNS_5TwineE;_ZL5errorRN4llvm11LLVMContextESt10error_codeRKNS_5TwineE; -static-type=BitcodeReaderStatics -package=org.llvm.bitcode.reader.impl")
//</editor-fold>
public final class BitcodeReaderStatics {

//<editor-fold defaultstate="collapsed" desc="PrintSummaryGUIDs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 45,
 FQN="PrintSummaryGUIDs", NM="_ZL17PrintSummaryGUIDs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL17PrintSummaryGUIDs")
//</editor-fold>
public static optBool PrintSummaryGUIDs/*J*/= new optBool($("print-summary-global-ids"), ClGlobals.init(false), OptionHidden.Hidden, 
    new desc($("Print the global id for each value when reading the module summary")));
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 51,
 FQN="(anonymous namespace)::(anonymous)", NM="_BitcodeReader_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_BitcodeReader_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int SWITCH_INST_MAGIC = 0x4B5; // May 2012 => 1205 => Hex
/*}*/
//<editor-fold defaultstate="collapsed" desc="error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 557,
 FQN="error", NM="_ZL5errorRKSt8functionIFvRKN4llvm14DiagnosticInfoEEESt10error_codeRKNS0_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL5errorRKSt8functionIFvRKN4llvm14DiagnosticInfoEEESt10error_codeRKNS0_5TwineE")
//</editor-fold>
public static std.error_code error(/*const*/DiagnosticHandlerFunction/*&*/ DiagnosticHandler, 
     std.error_code EC, /*const*/ Twine /*&*/ Message) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 564,
 FQN="error", NM="_ZL5errorRN4llvm11LLVMContextESt10error_codeRKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL5errorRN4llvm11LLVMContextESt10error_codeRKNS_5TwineE")
//</editor-fold>
public static std.error_code error(LLVMContext /*&*/ Context, std.error_code EC, 
     /*const*/ Twine /*&*/ Message) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="error">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 570,
 FQN="error", NM="_ZL5errorRN4llvm11LLVMContextERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL5errorRN4llvm11LLVMContextERKNS_5TwineE")
//</editor-fold>
public static std.error_code error(LLVMContext /*&*/ Context, /*const*/ Twine /*&*/ Message) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Helper functions to implement forward reference resolution, etc.
//===----------------------------------------------------------------------===//

/// Convert a string from a record into an std::string, return true on failure.
/*template <typename StrTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="convertToString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 659,
 FQN="convertToString", NM="Tpl__ZL15convertToStringN4llvm8ArrayRefIyEEjRT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=Tpl__ZL15convertToStringN4llvm8ArrayRefIyEEjRT_")
//</editor-fold>
public static </*typename*/ StrTy> boolean convertToString(ArrayRefUInt Record, /*uint*/int Idx, 
               StrTy /*&*/ Result) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="hasImplicitComdat">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 669,
 FQN="hasImplicitComdat", NM="_ZL17hasImplicitComdatj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL17hasImplicitComdatj")
//</editor-fold>
public static boolean hasImplicitComdat(/*size_t*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 681,
 FQN="getDecodedLinkage", NM="_ZL17getDecodedLinkagej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL17getDecodedLinkagej")
//</editor-fold>
public static GlobalValue.LinkageTypes getDecodedLinkage(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Decode the flags for GlobalValue in the summary
//<editor-fold defaultstate="collapsed" desc="getDecodedGVSummaryFlags">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 724,
 FQN="getDecodedGVSummaryFlags", NM="_ZL24getDecodedGVSummaryFlagsyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL24getDecodedGVSummaryFlagsyy")
//</editor-fold>
public static GlobalValueSummary.GVFlags getDecodedGVSummaryFlags(long/*uint64_t*/ RawFlags, 
                        long/*uint64_t*/ Version) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedVisibility">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 735,
 FQN="getDecodedVisibility", NM="_ZL20getDecodedVisibilityj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL20getDecodedVisibilityj")
//</editor-fold>
public static GlobalValue.VisibilityTypes getDecodedVisibility(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 744,
 FQN="getDecodedDLLStorageClass", NM="_ZL25getDecodedDLLStorageClassj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL25getDecodedDLLStorageClassj")
//</editor-fold>
public static GlobalValue.DLLStorageClassTypes getDecodedDLLStorageClass(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedThreadLocalMode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 754,
 FQN="getDecodedThreadLocalMode", NM="_ZL25getDecodedThreadLocalModej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL25getDecodedThreadLocalModej")
//</editor-fold>
public static GlobalVariable.ThreadLocalMode getDecodedThreadLocalMode(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedUnnamedAddrType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 765,
 FQN="getDecodedUnnamedAddrType", NM="_ZL25getDecodedUnnamedAddrTypej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL25getDecodedUnnamedAddrTypej")
//</editor-fold>
public static GlobalVariable.UnnamedAddr getDecodedUnnamedAddrType(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedCastOpcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 774,
 FQN="getDecodedCastOpcode", NM="_ZL20getDecodedCastOpcodej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL20getDecodedCastOpcodej")
//</editor-fold>
public static int getDecodedCastOpcode(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedBinaryOpcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 793,
 FQN="getDecodedBinaryOpcode", NM="_ZL22getDecodedBinaryOpcodejPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL22getDecodedBinaryOpcodejPN4llvm4TypeE")
//</editor-fold>
public static int getDecodedBinaryOpcode(/*uint*/int Val, Type /*P*/ Ty) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedRMWOperation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 831,
 FQN="getDecodedRMWOperation", NM="_ZL22getDecodedRMWOperationj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL22getDecodedRMWOperationj")
//</editor-fold>
public static AtomicRMWInst.BinOp getDecodedRMWOperation(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 848,
 FQN="getDecodedOrdering", NM="_ZL18getDecodedOrderingj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL18getDecodedOrderingj")
//</editor-fold>
public static AtomicOrdering getDecodedOrdering(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedSynchScope">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 861,
 FQN="getDecodedSynchScope", NM="_ZL20getDecodedSynchScopej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL20getDecodedSynchScopej")
//</editor-fold>
public static SynchronizationScope getDecodedSynchScope(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedComdatSelectionKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 869,
 FQN="getDecodedComdatSelectionKind", NM="_ZL29getDecodedComdatSelectionKindj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL29getDecodedComdatSelectionKindj")
//</editor-fold>
public static Comdat.SelectionKind getDecodedComdatSelectionKind(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getDecodedFastMathFlags">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 885,
 FQN="getDecodedFastMathFlags", NM="_ZL23getDecodedFastMathFlagsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL23getDecodedFastMathFlagsj")
//</editor-fold>
public static FastMathFlags getDecodedFastMathFlags(/*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="upgradeDLLImportExportLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 900,
 FQN="upgradeDLLImportExportLinkage", NM="_ZL29upgradeDLLImportExportLinkagePN4llvm11GlobalValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL29upgradeDLLImportExportLinkagePN4llvm11GlobalValueEj")
//</editor-fold>
public static void upgradeDLLImportExportLinkage(GlobalValue /*P*/ GV, /*uint*/int Val) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Functions for parsing blocks from the bitcode file
//===----------------------------------------------------------------------===//

/// \brief This fills an AttrBuilder object with the LLVM attributes that have
/// been decoded from the given integer. This function must stay in sync with
/// 'encodeLLVMAttributesForBitcode'.
//<editor-fold defaultstate="collapsed" desc="decodeLLVMAttributesForBitcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1293,
 FQN="decodeLLVMAttributesForBitcode", NM="_ZL30decodeLLVMAttributesForBitcodeRN4llvm11AttrBuilderEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL30decodeLLVMAttributesForBitcodeRN4llvm11AttrBuilderEy")
//</editor-fold>
public static void decodeLLVMAttributesForBitcode(AttrBuilder /*&*/ B, 
                              long/*uint64_t*/ EncodedAttrs) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Returns Attribute::None on unrecognized codes.
//<editor-fold defaultstate="collapsed" desc="getAttrFromCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1368,
 FQN="getAttrFromCode", NM="_ZL15getAttrFromCodey",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL15getAttrFromCodey")
//</editor-fold>
public static Attribute.AttrKind getAttrFromCode(long/*uint64_t*/ Code) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper to note and return the current location, and jump to the given
/// offset.
//<editor-fold defaultstate="collapsed" desc="jumpToValueSymbolTable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1894,
 FQN="jumpToValueSymbolTable", NM="_ZL22jumpToValueSymbolTableyRN4llvm15BitstreamCursorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL22jumpToValueSymbolTableyRN4llvm15BitstreamCursorE")
//</editor-fold>
public static long/*uint64_t*/ jumpToValueSymbolTable(long/*uint64_t*/ Offset, 
                      BitstreamCursor /*&*/ Stream) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="unrotateSign">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2033,
 FQN="unrotateSign", NM="_ZL12unrotateSigny",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL12unrotateSigny")
//</editor-fold>
public static long/*int64_t*/ unrotateSign(long/*uint64_t*/ U) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="readWideAPInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2858,
 FQN="readWideAPInt", NM="_ZL13readWideAPIntN4llvm8ArrayRefIyEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL13readWideAPIntN4llvm8ArrayRefIyEEj")
//</editor-fold>
public static APInt readWideAPInt(ArrayRefUInt Vals, /*uint*/int TypeBits) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper to read the header common to all bitcode files.
//<editor-fold defaultstate="collapsed" desc="hasValidBitcodeHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4029,
 FQN="hasValidBitcodeHeader", NM="_ZL21hasValidBitcodeHeaderRN4llvm15BitstreamCursorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL21hasValidBitcodeHeaderRN4llvm15BitstreamCursorE")
//</editor-fold>
public static boolean hasValidBitcodeHeader(BitstreamCursor /*&*/ Stream) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="typeCheckLoadStoreInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4346,
 FQN="typeCheckLoadStoreInst", NM="_ZL22typeCheckLoadStoreInstPN4llvm4TypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL22typeCheckLoadStoreInstPN4llvm4TypeES1_")
//</editor-fold>
public static std.error_code typeCheckLoadStoreInst(Type /*P*/ ValType, Type /*P*/ PtrType) {
  throw new UnsupportedOperationException("EmptyBody");
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="ErrorCategory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6532,
 FQN="ErrorCategory", NM="_ZL13ErrorCategory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL13ErrorCategory")
//</editor-fold>
public static ManagedStatic<BitcodeErrorCategoryType> ErrorCategory/*J*/= new ManagedStatic<BitcodeErrorCategoryType>(new BitcodeErrorCategoryTypeInfo());

//===----------------------------------------------------------------------===//
// External interface
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="getBitcodeModuleImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6542,
 FQN="getBitcodeModuleImpl", NM="_ZL20getBitcodeModuleImplSt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS1_EENS0_9StringRefEPN12_GLOBAL__N_113BitcodeReaderERNS0_11LLVMContextEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL20getBitcodeModuleImplSt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS1_EENS0_9StringRefEPN12_GLOBAL__N_113BitcodeReaderERNS0_11LLVMContextEbb")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > getBitcodeModuleImpl(std.unique_ptr<DataStreamer> Streamer, StringRef Name, 
                    BitcodeReader /*P*/ R, LLVMContext /*&*/ Context, 
                    boolean MaterializeAll, boolean ShouldLazyLoadMetadata) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Get a lazy one-at-time loading module from bitcode.
///
/// This isn't always used in a lazy context.  In particular, it's also used by
/// \a parseBitcodeFile().  If this is truly lazy, then we need to eagerly pull
/// in forward-referenced functions from block address references.
///
/// \param[in] MaterializeAll Set to \c true if we should materialize
/// everything.
//<editor-fold defaultstate="collapsed" desc="getLazyBitcodeModuleImpl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6579,
 FQN="getLazyBitcodeModuleImpl", NM="_ZL24getLazyBitcodeModuleImplOSt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS1_EERNS0_11LLVMContextEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZL24getLazyBitcodeModuleImplOSt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS1_EERNS0_11LLVMContextEbb")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > getLazyBitcodeModuleImpl(std.unique_ptr<MemoryBuffer> /*&&*/Buffer, 
                        LLVMContext /*&*/ Context, boolean MaterializeAll) {
  return getLazyBitcodeModuleImpl(Buffer, 
                        Context, MaterializeAll, 
                        false);
}
public static ErrorOr<std.unique_ptr<Module> > getLazyBitcodeModuleImpl(std.unique_ptr<MemoryBuffer> /*&&*/Buffer, 
                        LLVMContext /*&*/ Context, boolean MaterializeAll, 
                        boolean ShouldLazyLoadMetadata/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class BitcodeReaderStatics
