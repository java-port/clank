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
package org.llvm.bitcode;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.StringRef;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IRFunctionPointers.*;
import org.llvm.pass.ModulePass;


//<editor-fold defaultstate="collapsed" desc="static type BitcodeLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.bitcode.BitcodeLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm12isRawBitcodeEPKhS1_;_ZN4llvm15make_error_codeENS_12BitcodeErrorE;_ZN4llvm16WriteIndexToFileERKNS_18ModuleSummaryIndexERNS_11raw_ostreamEPSt3mapINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEES5_IyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKySD_EEESE_ISB_ESaISG_IKSB_SK_EEE;_ZN4llvm16isBitcodeWrapperEPKhS1_;_ZN4llvm16parseBitcodeFileENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm18WriteBitcodeToFileEPKNS_6ModuleERNS_11raw_ostreamEbPKNS_18ModuleSummaryIndexEb;_ZN4llvm20BitcodeErrorCategoryEv;_ZN4llvm20getLazyBitcodeModuleEOSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS1_EERNS_11LLVMContextEb;_ZN4llvm21getModuleSummaryIndexENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE;_ZN4llvm21hasGlobalValueSummaryENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE;_ZN4llvm22getBitcodeTargetTripleB5cxx11ENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm23createBitcodeWriterPassERNS_11raw_ostreamEbbb;_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b;_ZN4llvm24getBitcodeProducerStringB5cxx11ENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm24getStreamedBitcodeModuleENS_9StringRefESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EERNS_11LLVMContextE;_ZN4llvm31isBitcodeContainingObjCCategoryENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm9isBitcodeEPKhS1_;_ZN4llvmL13BWH_SizeFieldE;_ZN4llvmL14BWH_HeaderSizeE;_ZN4llvmL14BWH_MagicFieldE;_ZN4llvmL15BWH_OffsetFieldE;_ZN4llvmL16BWH_CPUTypeFieldE;_ZN4llvmL16BWH_VersionFieldE; -static-type=BitcodeLlvmGlobals -package=org.llvm.bitcode")
//</editor-fold>
public final class BitcodeLlvmGlobals {


/// \brief Create and return a pass that writes the module to the specified
/// ostream. Note that this pass is designed for use with the legacy pass
/// manager.
///
/// If \c ShouldPreserveUseListOrder, encode use-list order so it can be
/// reproduced when deserialized.
///
/// If \c EmitSummaryIndex, emit the summary index (currently for use in ThinLTO
/// optimization).
///
/// If \c EmitModuleHash, compute and emit the module hash in the bitcode
/// (currently for use in ThinLTO incremental build).
//<editor-fold defaultstate="collapsed" desc="llvm::createBitcodeWriterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 78,
 FQN="llvm::createBitcodeWriterPass", NM="_ZN4llvm23createBitcodeWriterPassERNS_11raw_ostreamEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm23createBitcodeWriterPassERNS_11raw_ostreamEbbb")
//</editor-fold>
public static ModulePass /*P*/ createBitcodeWriterPass(final raw_ostream /*&*/ Str) {
  return createBitcodeWriterPass(Str, 
                       false, 
                       false, false);
}
public static ModulePass /*P*/ createBitcodeWriterPass(final raw_ostream /*&*/ Str, 
                       boolean ShouldPreserveUseListOrder/*= false*/) {
  return createBitcodeWriterPass(Str, 
                       ShouldPreserveUseListOrder, 
                       false, false);
}
public static ModulePass /*P*/ createBitcodeWriterPass(final raw_ostream /*&*/ Str, 
                       boolean ShouldPreserveUseListOrder/*= false*/, 
                       boolean EmitSummaryIndex/*= false*/) {
  return createBitcodeWriterPass(Str, 
                       ShouldPreserveUseListOrder, 
                       EmitSummaryIndex, false);
}
public static ModulePass /*P*/ createBitcodeWriterPass(final raw_ostream /*&*/ Str, 
                       boolean ShouldPreserveUseListOrder/*= false*/, 
                       boolean EmitSummaryIndex/*= false*/, boolean EmitModuleHash/*= false*/) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeWriterPassLlvmGlobals.
    createBitcodeWriterPass(Str, 
                       ShouldPreserveUseListOrder, 
                       EmitSummaryIndex, EmitModuleHash);
}


/// Offsets of the 32-bit fields of bitcode wrapper header.
//<editor-fold defaultstate="collapsed" desc="llvm::BWH_MagicField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 34,
 FQN="llvm::BWH_MagicField", NM="_ZN4llvmL14BWH_MagicFieldE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvmL14BWH_MagicFieldE")
//</editor-fold>
public static /*const*//*uint*/int BWH_MagicField = 0 * 4;
//<editor-fold defaultstate="collapsed" desc="llvm::BWH_VersionField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 35,
 FQN="llvm::BWH_VersionField", NM="_ZN4llvmL16BWH_VersionFieldE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvmL16BWH_VersionFieldE")
//</editor-fold>
public static /*const*//*uint*/int BWH_VersionField = 1 * 4;
//<editor-fold defaultstate="collapsed" desc="llvm::BWH_OffsetField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 36,
 FQN="llvm::BWH_OffsetField", NM="_ZN4llvmL15BWH_OffsetFieldE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvmL15BWH_OffsetFieldE")
//</editor-fold>
public static /*const*//*uint*/int BWH_OffsetField = 2 * 4;
//<editor-fold defaultstate="collapsed" desc="llvm::BWH_SizeField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 37,
 FQN="llvm::BWH_SizeField", NM="_ZN4llvmL13BWH_SizeFieldE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvmL13BWH_SizeFieldE")
//</editor-fold>
public static /*const*//*uint*/int BWH_SizeField = 3 * 4;
//<editor-fold defaultstate="collapsed" desc="llvm::BWH_CPUTypeField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 38,
 FQN="llvm::BWH_CPUTypeField", NM="_ZN4llvmL16BWH_CPUTypeFieldE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvmL16BWH_CPUTypeFieldE")
//</editor-fold>
public static /*const*//*uint*/int BWH_CPUTypeField = 4 * 4;
//<editor-fold defaultstate="collapsed" desc="llvm::BWH_HeaderSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 39,
 FQN="llvm::BWH_HeaderSize", NM="_ZN4llvmL14BWH_HeaderSizeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvmL14BWH_HeaderSizeE")
//</editor-fold>
public static /*const*//*uint*/int BWH_HeaderSize = 5 * 4;

/// Read the header of the specified bitcode buffer and prepare for lazy
/// deserialization of function bodies. If ShouldLazyLoadMetadata is true,
/// lazily load metadata as well. If successful, this moves Buffer. On
/// error, this *does not* move Buffer.
//<editor-fold defaultstate="collapsed" desc="llvm::getLazyBitcodeModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 45,
 FQN="llvm::getLazyBitcodeModule", NM="_ZN4llvm20getLazyBitcodeModuleEOSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS1_EERNS_11LLVMContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm20getLazyBitcodeModuleEOSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS1_EERNS_11LLVMContextEb")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > getLazyBitcodeModule(final std.unique_ptr<MemoryBuffer> /*&&*/Buffer, 
                    final LLVMContext /*&*/ Context) {
  return getLazyBitcodeModule(Buffer, 
                    Context, 
                    false);
}
public static ErrorOr<std.unique_ptr<Module> > getLazyBitcodeModule(final std.unique_ptr<MemoryBuffer> /*&&*/Buffer, 
                    final LLVMContext /*&*/ Context, 
                    boolean ShouldLazyLoadMetadata/*= false*/) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    getLazyBitcodeModule(Buffer, 
                    Context, 
                    ShouldLazyLoadMetadata);
}


/// Read the header of the specified stream and prepare for lazy
/// deserialization and streaming of function bodies.
//<editor-fold defaultstate="collapsed" desc="llvm::getStreamedBitcodeModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 52,
 FQN="llvm::getStreamedBitcodeModule", NM="_ZN4llvm24getStreamedBitcodeModuleENS_9StringRefESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm24getStreamedBitcodeModuleENS_9StringRefESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EERNS_11LLVMContextE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > getStreamedBitcodeModule(StringRef Name, 
                        std.unique_ptr<DataStreamer> Streamer, 
                        final LLVMContext /*&*/ Context) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    getStreamedBitcodeModule(Name, 
                        Streamer, 
                        Context);
}


/// Read the header of the specified bitcode buffer and extract just the
/// triple information. If successful, this returns a string. On error, this
/// returns "".
//<editor-fold defaultstate="collapsed" desc="llvm::getBitcodeTargetTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 60,
 FQN="llvm::getBitcodeTargetTriple", NM="_ZN4llvm22getBitcodeTargetTripleENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm22getBitcodeTargetTripleENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static std.string getBitcodeTargetTriple(MemoryBufferRef Buffer, 
                      final LLVMContext /*&*/ Context) {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}


/// Return true if \p Buffer contains a bitcode file with ObjC code (category
/// or class) in it.
//<editor-fold defaultstate="collapsed" desc="llvm::isBitcodeContainingObjCCategory">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 65,
 FQN="llvm::isBitcodeContainingObjCCategory", NM="_ZN4llvm31isBitcodeContainingObjCCategoryENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm31isBitcodeContainingObjCCategoryENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static boolean isBitcodeContainingObjCCategory(MemoryBufferRef Buffer, 
                               final LLVMContext /*&*/ Context) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    isBitcodeContainingObjCCategory(Buffer, 
                               Context);
}


/// Read the header of the specified bitcode buffer and extract just the
/// producer string information. If successful, this returns a string. On
/// error, this returns "".
//<editor-fold defaultstate="collapsed" desc="llvm::getBitcodeProducerString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 71,
 FQN="llvm::getBitcodeProducerString", NM="_ZN4llvm24getBitcodeProducerStringENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm24getBitcodeProducerStringENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static std.string getBitcodeProducerString(MemoryBufferRef Buffer, 
                        final LLVMContext /*&*/ Context) {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}


/// Read the specified bitcode file, returning the module.
//<editor-fold defaultstate="collapsed" desc="llvm::parseBitcodeFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 75,
 FQN="llvm::parseBitcodeFile", NM="_ZN4llvm16parseBitcodeFileENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm16parseBitcodeFileENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > parseBitcodeFile(MemoryBufferRef Buffer, 
                final LLVMContext /*&*/ Context) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    parseBitcodeFile(Buffer, 
                Context);
}


/// Check if the given bitcode buffer contains a summary block.
//<editor-fold defaultstate="collapsed" desc="llvm::hasGlobalValueSummary">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 79,
 FQN="llvm::hasGlobalValueSummary", NM="_ZN4llvm21hasGlobalValueSummaryENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm21hasGlobalValueSummaryENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE")
//</editor-fold>
public static boolean hasGlobalValueSummary(MemoryBufferRef Buffer, 
                     final /*const*/DiagnosticHandlerFunction /*&*/ DiagnosticHandler) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    hasGlobalValueSummary(Buffer, 
                     DiagnosticHandler);
}


/// Parse the specified bitcode buffer, returning the module summary index.
//<editor-fold defaultstate="collapsed" desc="llvm::getModuleSummaryIndex">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 84,
 FQN="llvm::getModuleSummaryIndex", NM="_ZN4llvm21getModuleSummaryIndexENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm21getModuleSummaryIndexENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<ModuleSummaryIndex> > getModuleSummaryIndex(MemoryBufferRef Buffer, 
                     final /*const*/DiagnosticHandlerFunction /*&*/ DiagnosticHandler) {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    getModuleSummaryIndex(Buffer, 
                     DiagnosticHandler);
}


/// \brief Write the specified module to the specified raw output stream.
///
/// For streams where it matters, the given stream should be in "binary"
/// mode.
///
/// If \c ShouldPreserveUseListOrder, encode the use-list order for each \a
/// Value in \c M.  These will be reconstructed exactly when \a M is
/// deserialized.
///
/// If \c EmitSummaryIndex, emit the module's summary index (currently
/// for use in ThinLTO optimization).
//<editor-fold defaultstate="collapsed" desc="llvm::WriteBitcodeToFile">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 99,
 FQN="llvm::WriteBitcodeToFile", NM="_ZN4llvm18WriteBitcodeToFileEPKNS_6ModuleERNS_11raw_ostreamEbPKNS_18ModuleSummaryIndexEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm18WriteBitcodeToFileEPKNS_6ModuleERNS_11raw_ostreamEbPKNS_18ModuleSummaryIndexEb")
//</editor-fold>
public static void WriteBitcodeToFile(/*const*/ Module /*P*/ M, final raw_ostream /*&*/ Out) {
  WriteBitcodeToFile(M, Out, 
                  false, 
                  (/*const*/ ModuleSummaryIndex /*P*/ )null, 
                  false);
}
public static void WriteBitcodeToFile(/*const*/ Module /*P*/ M, final raw_ostream /*&*/ Out, 
                  boolean ShouldPreserveUseListOrder/*= false*/) {
  WriteBitcodeToFile(M, Out, 
                  ShouldPreserveUseListOrder, 
                  (/*const*/ ModuleSummaryIndex /*P*/ )null, 
                  false);
}
public static void WriteBitcodeToFile(/*const*/ Module /*P*/ M, final raw_ostream /*&*/ Out, 
                  boolean ShouldPreserveUseListOrder/*= false*/, 
                  /*const*/ ModuleSummaryIndex /*P*/ Index/*= null*/) {
  WriteBitcodeToFile(M, Out, 
                  ShouldPreserveUseListOrder, 
                  Index, 
                  false);
}
public static void WriteBitcodeToFile(/*const*/ Module /*P*/ M, final raw_ostream /*&*/ Out, 
                  boolean ShouldPreserveUseListOrder/*= false*/, 
                  /*const*/ ModuleSummaryIndex /*P*/ Index/*= null*/, 
                  boolean GenerateHash/*= false*/) {
  /*delegate*/org.llvm.bitcode.impl.BitcodeWriterLlvmGlobals.
    WriteBitcodeToFile(M, Out, 
                  ShouldPreserveUseListOrder, 
                  Index, 
                  GenerateHash);
}


/// Write the specified module summary index to the given raw output stream,
/// where it will be written in a new bitcode block. This is used when
/// writing the combined index file for ThinLTO. When writing a subset of the
/// index for a distributed backend, provide the \p ModuleToSummariesForIndex
/// map.
//<editor-fold defaultstate="collapsed" desc="llvm::WriteIndexToFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 109,
 FQN="llvm::WriteIndexToFile", NM="_ZN4llvm16WriteIndexToFileERKNS_18ModuleSummaryIndexERNS_11raw_ostreamEPSt3mapISsS5_IyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS7_EEES8_ISsESaISA_IKSsSE_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm16WriteIndexToFileERKNS_18ModuleSummaryIndexERNS_11raw_ostreamEPSt3mapISsS5_IyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS7_EEES8_ISsESaISA_IKSsSE_EEE")
//</editor-fold>
public static void WriteIndexToFile(final /*const*/ ModuleSummaryIndex /*&*/ Index, final raw_ostream /*&*/ Out) {
  WriteIndexToFile(Index, Out, 
                (std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/)null);
}
public static void WriteIndexToFile(final /*const*/ ModuleSummaryIndex /*&*/ Index, final raw_ostream /*&*/ Out, 
                std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/ ModuleToSummariesForIndex/*= null*/) {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}


/// isBitcodeWrapper - Return true if the given bytes are the magic bytes
/// for an LLVM IR bitcode wrapper.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isBitcodeWrapper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 116,
 FQN="llvm::isBitcodeWrapper", NM="_ZN4llvm16isBitcodeWrapperEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm16isBitcodeWrapperEPKhS1_")
//</editor-fold>
public static /*inline*/ boolean isBitcodeWrapper(/*const*/char$ptr/*uchar P*/ BufPtr, 
                /*const*/char$ptr/*uchar P*/ BufEnd) {
  return /*delegate*/org.llvm.bitcode.impl.ReaderWriterLlvmGlobals.
    isBitcodeWrapper(BufPtr, 
                BufEnd);
}


/// isRawBitcode - Return true if the given bytes are the magic bytes for
/// raw LLVM IR bitcode (without a wrapper).
///
//<editor-fold defaultstate="collapsed" desc="llvm::isRawBitcode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 130,
 FQN="llvm::isRawBitcode", NM="_ZN4llvm12isRawBitcodeEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm12isRawBitcodeEPKhS1_")
//</editor-fold>
public static /*inline*/ boolean isRawBitcode(/*const*/char$ptr/*uchar P*/ BufPtr, 
            /*const*/char$ptr/*uchar P*/ BufEnd) {
  return /*delegate*/org.llvm.bitcode.impl.ReaderWriterLlvmGlobals.
    isRawBitcode(BufPtr, 
            BufEnd);
}


/// isBitcode - Return true if the given bytes are the magic bytes for
/// LLVM IR bitcode, either with or without a wrapper.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isBitcode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 144,
 FQN="llvm::isBitcode", NM="_ZN4llvm9isBitcodeEPKhS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm9isBitcodeEPKhS1_")
//</editor-fold>
public static /*inline*/ boolean isBitcode(/*const*/char$ptr/*uchar P*/ BufPtr, 
         /*const*/char$ptr/*uchar P*/ BufEnd) {
  return /*delegate*/org.llvm.bitcode.impl.ReaderWriterLlvmGlobals.
    isBitcode(BufPtr, 
         BufEnd);
}


/// SkipBitcodeWrapperHeader - Some systems wrap bc files with a special
/// header for padding or other reasons.  The format of this header is:
///
/// struct bc_header {
///   uint32_t Magic;         // 0x0B17C0DE
///   uint32_t Version;       // Version, currently always 0.
///   uint32_t BitcodeOffset; // Offset to traditional bitcode file.
///   uint32_t BitcodeSize;   // Size of traditional bitcode file.
///   ... potentially other gunk ...
/// };
///
/// This function is called when we find a file with a matching magic number.
/// In this case, skip down to the subsection of the file that is actually a
/// BC file.
/// If 'VerifyBufferSize' is true, check that the buffer is large enough to
/// contain the whole bitcode file.
//<editor-fold defaultstate="collapsed" desc="llvm::SkipBitcodeWrapperHeader">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 166,
 FQN="llvm::SkipBitcodeWrapperHeader", NM="_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b")
//</editor-fold>
public static /*inline*/ boolean SkipBitcodeWrapperHeader(final char$ptr/*const uchar P&*/ BufPtr, 
                        final char$ptr/*const uchar P&*/ BufEnd, 
                        boolean VerifyBufferSize) {
  return /*delegate*/org.llvm.bitcode.impl.ReaderWriterLlvmGlobals.
    SkipBitcodeWrapperHeader(BufPtr, 
                        BufEnd, 
                        VerifyBufferSize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::BitcodeErrorCategory">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 185,
 FQN="llvm::BitcodeErrorCategory", NM="_ZN4llvm20BitcodeErrorCategoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm20BitcodeErrorCategoryEv")
//</editor-fold>
public static /*const*/ std.error_category /*&*/ BitcodeErrorCategory() {
  return /*delegate*/org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals.
    BitcodeErrorCategory();
}

//<editor-fold defaultstate="collapsed" desc="llvm::make_error_code">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/ReaderWriter.h", line = 187,
 FQN="llvm::make_error_code", NM="_ZN4llvm15make_error_codeENS_12BitcodeErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm15make_error_codeENS_12BitcodeErrorE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(BitcodeError E) {
  return /*delegate*/org.llvm.bitcode.impl.ReaderWriterLlvmGlobals.
    make_error_code(E);
}

} // END OF class BitcodeLlvmGlobals
