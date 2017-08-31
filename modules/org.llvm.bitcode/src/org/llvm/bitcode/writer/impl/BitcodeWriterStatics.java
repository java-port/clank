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
package org.llvm.bitcode.writer.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.bitcode.bitc.*;


//<editor-fold defaultstate="collapsed" desc="static type BitcodeWriterStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_BitcodeWriter_cpp_Unnamed_enum;_ZL10rotateSignx;_ZL13INDEX_VERSION;_ZL15emitSignedInt64RN4llvm15SmallVectorImplIyEEy;_ZL17getEncodedLinkageN4llvm11GlobalValue12LinkageTypesE;_ZL17getEncodedLinkageRKN4llvm11GlobalValueE;_ZL17getStringEncodingPKcj;_ZL18getEncodedOrderingN4llvm14AtomicOrderingE;_ZL18writeInt32ToBufferjRN4llvm15SmallVectorImplIcEERj;_ZL19getAttrKindEncodingN4llvm9Attribute8AttrKindE;_ZL20getEncodedCastOpcodej;_ZL20getEncodedSynchScopeN4llvm20SynchronizationScopeE;_ZL20getEncodedVisibilityRKN4llvm11GlobalValueE;_ZL20getOptimizationFlagsPKN4llvm5ValueE;_ZL21getEncodedUnnamedAddrRKN4llvm11GlobalValueE;_ZL22getEncodedBinaryOpcodej;_ZL22getEncodedRMWOperationN4llvm13AtomicRMWInst5BinOpE;_ZL24getEncodedGVSummaryFlagsN4llvm18GlobalValueSummary7GVFlagsE;_ZL25getEncodedDLLStorageClassRKN4llvm11GlobalValueE;_ZL25getEncodedThreadLocalModeRKN4llvm11GlobalValueE;_ZL28emitDarwinBCHeaderAndTrailerRN4llvm15SmallVectorImplIcEERKNS_6TripleE;_ZL29getEncodedComdatSelectionKindRKN4llvm6ComdatE; -static-type=BitcodeWriterStatics -package=org.llvm.bitcode.writer.impl")
//</editor-fold>
public final class BitcodeWriterStatics {

/// These are manifest constants used by the bitcode writer. They do not need to
/// be kept in sync with the reader, but need to be consistent within this file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 43,
 FQN="(anonymous namespace)::(anonymous)", NM="_BitcodeWriter_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_BitcodeWriter_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // VALUE_SYMTAB_BLOCK abbrev id's.
  public static final /*uint*/int VST_ENTRY_8_ABBREV = FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
  public static final /*uint*/int VST_ENTRY_7_ABBREV = VST_ENTRY_8_ABBREV + 1;
  public static final /*uint*/int VST_ENTRY_6_ABBREV = VST_ENTRY_7_ABBREV + 1;
  public static final /*uint*/int VST_BBENTRY_6_ABBREV = VST_ENTRY_6_ABBREV + 1;
  
  // CONSTANTS_BLOCK abbrev id's.
  public static final /*uint*/int CONSTANTS_SETTYPE_ABBREV = FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
  public static final /*uint*/int CONSTANTS_INTEGER_ABBREV = CONSTANTS_SETTYPE_ABBREV + 1;
  public static final /*uint*/int CONSTANTS_CE_CAST_Abbrev = CONSTANTS_INTEGER_ABBREV + 1;
  public static final /*uint*/int CONSTANTS_NULL_Abbrev = CONSTANTS_CE_CAST_Abbrev + 1;
  
  // FUNCTION_BLOCK abbrev id's.
  public static final /*uint*/int FUNCTION_INST_LOAD_ABBREV = FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
  public static final /*uint*/int FUNCTION_INST_BINOP_ABBREV = FUNCTION_INST_LOAD_ABBREV + 1;
  public static final /*uint*/int FUNCTION_INST_BINOP_FLAGS_ABBREV = FUNCTION_INST_BINOP_ABBREV + 1;
  public static final /*uint*/int FUNCTION_INST_CAST_ABBREV = FUNCTION_INST_BINOP_FLAGS_ABBREV + 1;
  public static final /*uint*/int FUNCTION_INST_RET_VOID_ABBREV = FUNCTION_INST_CAST_ABBREV + 1;
  public static final /*uint*/int FUNCTION_INST_RET_VAL_ABBREV = FUNCTION_INST_RET_VOID_ABBREV + 1;
  public static final /*uint*/int FUNCTION_INST_UNREACHABLE_ABBREV = FUNCTION_INST_RET_VAL_ABBREV + 1;
  public static final /*uint*/int FUNCTION_INST_GEP_ABBREV = FUNCTION_INST_UNREACHABLE_ABBREV + 1;
/*}*/
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="getEncodedCastOpcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 515,
 FQN="getEncodedCastOpcode", NM="_ZL20getEncodedCastOpcodej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL20getEncodedCastOpcodej")
//</editor-fold>
public static /*uint*/int getEncodedCastOpcode(/*uint*/int Opcode) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedBinaryOpcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 534,
 FQN="getEncodedBinaryOpcode", NM="_ZL22getEncodedBinaryOpcodej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL22getEncodedBinaryOpcodej")
//</editor-fold>
public static /*uint*/int getEncodedBinaryOpcode(/*uint*/int Opcode) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedRMWOperation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 558,
 FQN="getEncodedRMWOperation", NM="_ZL22getEncodedRMWOperationN4llvm13AtomicRMWInst5BinOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL22getEncodedRMWOperationN4llvm13AtomicRMWInst5BinOpE")
//</editor-fold>
public static /*uint*/int getEncodedRMWOperation(AtomicRMWInst.BinOp Op) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedOrdering">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 575,
 FQN="getEncodedOrdering", NM="_ZL18getEncodedOrderingN4llvm14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL18getEncodedOrderingN4llvm14AtomicOrderingE")
//</editor-fold>
public static /*uint*/int getEncodedOrdering(AtomicOrdering Ordering) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedSynchScope">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 588,
 FQN="getEncodedSynchScope", NM="_ZL20getEncodedSynchScopeN4llvm20SynchronizationScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL20getEncodedSynchScopeN4llvm20SynchronizationScopeE")
//</editor-fold>
public static /*uint*/int getEncodedSynchScope(SynchronizationScope SynchScope) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getAttrKindEncoding">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 611,
 FQN="getAttrKindEncoding", NM="_ZL19getAttrKindEncodingN4llvm9Attribute8AttrKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL19getAttrKindEncodingN4llvm9Attribute8AttrKindE")
//</editor-fold>
public static long/*uint64_t*/ getAttrKindEncoding(Attribute.AttrKind Kind) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 953,
 FQN="getEncodedLinkage", NM="_ZL17getEncodedLinkageN4llvm11GlobalValue12LinkageTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL17getEncodedLinkageN4llvm11GlobalValue12LinkageTypesE")
//</editor-fold>
public static /*uint*/int getEncodedLinkage(/*const*/ GlobalValue.LinkageTypes Linkage) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 981,
 FQN="getEncodedLinkage", NM="_ZL17getEncodedLinkageRKN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL17getEncodedLinkageRKN4llvm11GlobalValueE")
//</editor-fold>
public static /*uint*/int getEncodedLinkage(/*const*/ GlobalValue /*&*/ GV) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Decode the flags for GlobalValue in the summary
//<editor-fold defaultstate="collapsed" desc="getEncodedGVSummaryFlags">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 986,
 FQN="getEncodedGVSummaryFlags", NM="_ZL24getEncodedGVSummaryFlagsN4llvm18GlobalValueSummary7GVFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL24getEncodedGVSummaryFlagsN4llvm18GlobalValueSummary7GVFlagsE")
//</editor-fold>
public static long/*uint64_t*/ getEncodedGVSummaryFlags(GlobalValueSummary.GVFlags Flags) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedVisibility">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 999,
 FQN="getEncodedVisibility", NM="_ZL20getEncodedVisibilityRKN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL20getEncodedVisibilityRKN4llvm11GlobalValueE")
//</editor-fold>
public static /*uint*/int getEncodedVisibility(/*const*/ GlobalValue /*&*/ GV) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedDLLStorageClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1008,
 FQN="getEncodedDLLStorageClass", NM="_ZL25getEncodedDLLStorageClassRKN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL25getEncodedDLLStorageClassRKN4llvm11GlobalValueE")
//</editor-fold>
public static /*uint*/int getEncodedDLLStorageClass(/*const*/ GlobalValue /*&*/ GV) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedThreadLocalMode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1017,
 FQN="getEncodedThreadLocalMode", NM="_ZL25getEncodedThreadLocalModeRKN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL25getEncodedThreadLocalModeRKN4llvm11GlobalValueE")
//</editor-fold>
public static /*uint*/int getEncodedThreadLocalMode(/*const*/ GlobalValue /*&*/ GV) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedComdatSelectionKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1028,
 FQN="getEncodedComdatSelectionKind", NM="_ZL29getEncodedComdatSelectionKindRKN4llvm6ComdatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL29getEncodedComdatSelectionKindRKN4llvm6ComdatE")
//</editor-fold>
public static /*uint*/int getEncodedComdatSelectionKind(/*const*/ Comdat /*&*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getEncodedUnnamedAddr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1044,
 FQN="getEncodedUnnamedAddr", NM="_ZL21getEncodedUnnamedAddrRKN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL21getEncodedUnnamedAddrRKN4llvm11GlobalValueE")
//</editor-fold>
public static /*uint*/int getEncodedUnnamedAddr(/*const*/ GlobalValue /*&*/ GV) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Determine the encoding to use for the given string name and length.
//<editor-fold defaultstate="collapsed" desc="getStringEncoding">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1097,
 FQN="getStringEncoding", NM="_ZL17getStringEncodingPKcj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL17getStringEncodingPKcj")
//</editor-fold>
public static StringEncoding getStringEncoding(/*const*/char$ptr/*char P*/ Str, /*uint*/int StrLen) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getOptimizationFlags">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1321,
 FQN="getOptimizationFlags", NM="_ZL20getOptimizationFlagsPKN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL20getOptimizationFlagsPKN4llvm5ValueE")
//</editor-fold>
public static long/*uint64_t*/ getOptimizationFlags(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="rotateSign">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1433,
 FQN="rotateSign", NM="_ZL10rotateSignx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL10rotateSignx")
//</editor-fold>
public static long/*uint64_t*/ rotateSign(long/*int64_t*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="emitSignedInt64">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2008,
 FQN="emitSignedInt64", NM="_ZL15emitSignedInt64RN4llvm15SmallVectorImplIyEEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL15emitSignedInt64RN4llvm15SmallVectorImplIyEEy")
//</editor-fold>
public static void emitSignedInt64(SmallVectorImplULong /*&*/ Vals, long/*uint64_t*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Current version for the summary.
// This is bumped whenever we introduce changes in the way some record are
// interpreted, like flags for instance.
//<editor-fold defaultstate="collapsed" desc="INDEX_VERSION">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3333,
 FQN="INDEX_VERSION", NM="_ZL13INDEX_VERSION",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL13INDEX_VERSION")
//</editor-fold>
public static /*const*/long/*uint64_t*/ INDEX_VERSION = 1;
//<editor-fold defaultstate="collapsed" desc="writeInt32ToBuffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3706,
 FQN="writeInt32ToBuffer", NM="_ZL18writeInt32ToBufferjRN4llvm15SmallVectorImplIcEERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL18writeInt32ToBufferjRN4llvm15SmallVectorImplIcEERj")
//</editor-fold>
public static void writeInt32ToBuffer(/*uint32_t*/int Value, SmallString/*&*/ Buffer, 
                  /*uint32_t &*/uint$ref Position) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If generating a bc file on darwin, we have to emit a
/// header and trailer to make it compatible with the system archiver.  To do
/// this we emit the following header, and then emit a trailer that pads the
/// file out to be a multiple of 16 bytes.
///
/// struct bc_header {
///   uint32_t Magic;         // 0x0B17C0DE
///   uint32_t Version;       // Version, currently always 0.
///   uint32_t BitcodeOffset; // Offset to traditional bitcode file.
///   uint32_t BitcodeSize;   // Size of traditional bitcode file.
///   uint32_t CPUType;       // CPU specifier.
///   ... potentially more later ...
/// };
//<editor-fold defaultstate="collapsed" desc="emitDarwinBCHeaderAndTrailer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3725,
 FQN="emitDarwinBCHeaderAndTrailer", NM="_ZL28emitDarwinBCHeaderAndTrailerRN4llvm15SmallVectorImplIcEERKNS_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZL28emitDarwinBCHeaderAndTrailerRN4llvm15SmallVectorImplIcEERKNS_6TripleE")
//</editor-fold>
public static void emitDarwinBCHeaderAndTrailer(SmallString/*&*/ Buffer, 
                            /*const*/ Triple /*&*/ TT) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class BitcodeWriterStatics
