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
package org.llvm.bitcode.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.StringRef;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.bitcode.reader.impl.BitcodeReader;
import org.llvm.bitcode.reader.impl.BitcodeReaderStatics;
import org.llvm.bitcode.reader.impl.ModuleSummaryIndexBitcodeReader;
import org.llvm.ir.java.IRFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type BitcodeReaderLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.bitcode.impl.BitcodeReaderLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm16parseBitcodeFileENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm20BitcodeErrorCategoryEv;_ZN4llvm20getLazyBitcodeModuleEOSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS1_EERNS_11LLVMContextEb;_ZN4llvm21getModuleSummaryIndexENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE;_ZN4llvm21hasGlobalValueSummaryENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE;_ZN4llvm22getBitcodeTargetTripleB5cxx11ENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm24getBitcodeProducerStringB5cxx11ENS_15MemoryBufferRefERNS_11LLVMContextE;_ZN4llvm24getStreamedBitcodeModuleENS_9StringRefESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EERNS_11LLVMContextE;_ZN4llvm31isBitcodeContainingObjCCategoryENS_15MemoryBufferRefERNS_11LLVMContextE; -static-type=BitcodeReaderLlvmGlobals -package=org.llvm.bitcode.impl")
//</editor-fold>
public final class BitcodeReaderLlvmGlobals {


/// Read the header of the specified bitcode buffer and prepare for lazy
/// deserialization of function bodies. If ShouldLazyLoadMetadata is true,
/// lazily load metadata as well. If successful, this moves Buffer. On
/// error, this *does not* move Buffer.
//<editor-fold defaultstate="collapsed" desc="llvm::getLazyBitcodeModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6595,
 FQN="llvm::getLazyBitcodeModule", NM="_ZN4llvm20getLazyBitcodeModuleEOSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS1_EERNS_11LLVMContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm20getLazyBitcodeModuleEOSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS1_EERNS_11LLVMContextEb")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > getLazyBitcodeModule(final std.unique_ptr<MemoryBuffer> /*&&*/Buffer, 
                    final LLVMContext /*&*/ Context) {
  return getLazyBitcodeModule(Buffer, 
                    Context, false);
}
public static ErrorOr<std.unique_ptr<Module> > getLazyBitcodeModule(final std.unique_ptr<MemoryBuffer> /*&&*/Buffer, 
                    final LLVMContext /*&*/ Context, boolean ShouldLazyLoadMetadata/*= false*/) {
  return BitcodeReaderStatics.getLazyBitcodeModuleImpl(std.move(Buffer), Context, false, 
      ShouldLazyLoadMetadata);
}


/// Read the header of the specified stream and prepare for lazy
/// deserialization and streaming of function bodies.
//<editor-fold defaultstate="collapsed" desc="llvm::getStreamedBitcodeModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6602,
 FQN="llvm::getStreamedBitcodeModule", NM="_ZN4llvm24getStreamedBitcodeModuleENS_9StringRefESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm24getStreamedBitcodeModuleENS_9StringRefESt10unique_ptrINS_12DataStreamerESt14default_deleteIS2_EERNS_11LLVMContextE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > getStreamedBitcodeModule(StringRef Name, 
                        std.unique_ptr<DataStreamer> Streamer, 
                        final LLVMContext /*&*/ Context) {
  std.unique_ptr<Module> M = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    M = llvm.make_unique(new Module(Name, Context));
    BitcodeReader /*P*/ R = new BitcodeReader(Context);
    
    return $c$.clean(BitcodeReaderStatics.getBitcodeModuleImpl($c$.track(new std.unique_ptr<DataStreamer>(JD$Move.INSTANCE, std.move(Streamer))), new StringRef(Name), R, Context, false, 
        false));
  } finally {
    if (M != null) { M.$destroy(); }
    $c$.$destroy();
  }
}


/// Read the header of the specified bitcode buffer and extract just the
/// triple information. If successful, this returns a string. On error, this
/// returns "".
//<editor-fold defaultstate="collapsed" desc="llvm::getBitcodeTargetTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6621,
 FQN="llvm::getBitcodeTargetTriple", NM="_ZN4llvm22getBitcodeTargetTripleENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm22getBitcodeTargetTripleENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static std.string getBitcodeTargetTriple(MemoryBufferRef Buffer, 
                      final LLVMContext /*&*/ Context) {
  std.unique_ptr<MemoryBuffer> Buf = null;
  unique_ptr<BitcodeReader> R = null;
  try {
    Buf = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer), false);
    R = llvm.make_unique(new BitcodeReader(Buf.release(), Context));
    ErrorOr<std.string> Triple = R.$arrow().parseTriple();
    if (Triple.getError().$bool()) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    return new std.string(Triple.get());
  } finally {
    if (R != null) { R.$destroy(); }
    if (Buf != null) { Buf.$destroy(); }
  }
}


/// Return true if \p Buffer contains a bitcode file with ObjC code (category
/// or class) in it.
//<editor-fold defaultstate="collapsed" desc="llvm::isBitcodeContainingObjCCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6631,
 FQN="llvm::isBitcodeContainingObjCCategory", NM="_ZN4llvm31isBitcodeContainingObjCCategoryENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm31isBitcodeContainingObjCCategoryENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static boolean isBitcodeContainingObjCCategory(MemoryBufferRef Buffer, 
                               final LLVMContext /*&*/ Context) {
  std.unique_ptr<MemoryBuffer> Buf = null;
  unique_ptr<BitcodeReader> R = null;
  try {
    Buf = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer), false);
    R = llvm.make_unique(new BitcodeReader(Buf.release(), Context));
    ErrorOrBool hasObjCCategory = R.$arrow().hasObjCCategory();
    if (hasObjCCategory.getError().$bool()) {
      return false;
    }
    return hasObjCCategory.get();
  } finally {
    if (R != null) { R.$destroy(); }
    if (Buf != null) { Buf.$destroy(); }
  }
}


/// Read the header of the specified bitcode buffer and extract just the
/// producer string information. If successful, this returns a string. On
/// error, this returns "".
//<editor-fold defaultstate="collapsed" desc="llvm::getBitcodeProducerString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6641,
 FQN="llvm::getBitcodeProducerString", NM="_ZN4llvm24getBitcodeProducerStringENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm24getBitcodeProducerStringENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static std.string getBitcodeProducerString(MemoryBufferRef Buffer, 
                        final LLVMContext /*&*/ Context) {
  std.unique_ptr<MemoryBuffer> Buf = null;
  BitcodeReader R = null;
  try {
    Buf = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer), false);
    R/*J*/= new BitcodeReader(Buf.release(), Context);
    ErrorOr<std.string> ProducerString = R.parseIdentificationBlock();
    if (ProducerString.getError().$bool()) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    return new std.string(ProducerString.get());
  } finally {
    if (R != null) { R.$destroy(); }
    if (Buf != null) { Buf.$destroy(); }
  }
}


/// Read the specified bitcode file, returning the module.
//<editor-fold defaultstate="collapsed" desc="llvm::parseBitcodeFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6613,
 FQN="llvm::parseBitcodeFile", NM="_ZN4llvm16parseBitcodeFileENS_15MemoryBufferRefERNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm16parseBitcodeFileENS_15MemoryBufferRefERNS_11LLVMContextE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<Module> > parseBitcodeFile(MemoryBufferRef Buffer, 
                final LLVMContext /*&*/ Context) {
  std.unique_ptr<MemoryBuffer> Buf = null;
  try {
    Buf = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer), false);
    return BitcodeReaderStatics.getLazyBitcodeModuleImpl(std.move(Buf), Context, true);
  } finally {
    if (Buf != null) { Buf.$destroy(); }
  }
  // TODO: Restore the use-lists to the in-memory state when the bitcode was
  // written.  We must defer until the Module has been fully materialized.
}


/// Check if the given bitcode buffer contains a summary block.

// Check if the given bitcode buffer contains a global value summary block.
//<editor-fold defaultstate="collapsed" desc="llvm::hasGlobalValueSummary">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6673,
 FQN="llvm::hasGlobalValueSummary", NM="_ZN4llvm21hasGlobalValueSummaryENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm21hasGlobalValueSummaryENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE")
//</editor-fold>
public static boolean hasGlobalValueSummary(MemoryBufferRef Buffer, 
                     final /*const*/DiagnosticHandlerFunction /*&*/ DiagnosticHandler) {
  std.unique_ptr<MemoryBuffer> Buf = null;
  ModuleSummaryIndexBitcodeReader R = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Buf = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer), false);
    R/*J*/= new ModuleSummaryIndexBitcodeReader(Buf.get(), /*FuncArg*/DiagnosticHandler, true);
    final ModuleSummaryIndexBitcodeReader L$R = R;
    BoolPredicate<std.error_code>/*const*/ cleanupOnError = /*[&, &R]*/ (std.error_code EC) -> {
          L$R.releaseBuffer(); // Never take ownership on error.
          return false;
        };
    {
      
      std.error_code EC = $c$.clean(R.parseSummaryIndexInto($c$.track(new std.unique_ptr<DataStreamer>(JD$NullPtr.INSTANCE, null)), (ModuleSummaryIndex /*P*/ )null));
      if (EC.$bool()) {
        return cleanupOnError.$call(new std.error_code(EC));
      }
    }
    
    Buf.release(); // The ModuleSummaryIndexBitcodeReader owns it now.
    return R.foundGlobalValSummary();
  } finally {
    if (R != null) { R.$destroy(); }
    if (Buf != null) { Buf.$destroy(); }
    $c$.$destroy();
  }
}


/// Parse the specified bitcode buffer, returning the module summary index.

// Parse the specified bitcode buffer, returning the function info index.
//<editor-fold defaultstate="collapsed" desc="llvm::getModuleSummaryIndex">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6652,
 FQN="llvm::getModuleSummaryIndex", NM="_ZN4llvm21getModuleSummaryIndexENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm21getModuleSummaryIndexENS_15MemoryBufferRefERKSt8functionIFvRKNS_14DiagnosticInfoEEE")
//</editor-fold>
public static ErrorOr<std.unique_ptr<ModuleSummaryIndex> > getModuleSummaryIndex(MemoryBufferRef Buffer, 
                     final /*const*/DiagnosticHandlerFunction /*&*/ DiagnosticHandler) {
  std.unique_ptr<MemoryBuffer> Buf = null;
  ModuleSummaryIndexBitcodeReader R = null;
  unique_ptr<ModuleSummaryIndex> Index = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Buf = MemoryBuffer.getMemBuffer(new MemoryBufferRef(Buffer), false);
    R/*J*/= new ModuleSummaryIndexBitcodeReader(Buf.get(), /*FuncArg*/DiagnosticHandler);
    
    Index = llvm.make_unique(new ModuleSummaryIndex());
    final ModuleSummaryIndexBitcodeReader L$R = R;
    Type2Type<std.error_code>/*const*/ cleanupOnError = /*[&, &R]*/ (std.error_code EC) -> {
          L$R.releaseBuffer(); // Never take ownership on error.
          return new std.error_code(JD$Move.INSTANCE, EC);
        };
    {
      
      std.error_code EC = $c$.clean(R.parseSummaryIndexInto($c$.track(new std.unique_ptr<DataStreamer>(JD$NullPtr.INSTANCE, null)), Index.get()));
      if (EC.$bool()) {
        return new ErrorOr<std.unique_ptr<ModuleSummaryIndex> >(cleanupOnError.$call(new std.error_code(EC)));
      }
    }
    
    Buf.release(); // The ModuleSummaryIndexBitcodeReader owns it now.
    return new ErrorOr<std.unique_ptr<ModuleSummaryIndex> >(JD$Convertible.INSTANCE, std.move(Index));
  } finally {
    if (Index != null) { Index.$destroy(); }
    if (R != null) { R.$destroy(); }
    if (Buf != null) { Buf.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::BitcodeErrorCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6534,
 FQN="llvm::BitcodeErrorCategory", NM="_ZN4llvm20BitcodeErrorCategoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm20BitcodeErrorCategoryEv")
//</editor-fold>
public static /*const*/ std.error_category /*&*/ BitcodeErrorCategory() {
  return BitcodeReaderStatics.ErrorCategory.$star();
}

} // END OF class BitcodeReaderLlvmGlobals
