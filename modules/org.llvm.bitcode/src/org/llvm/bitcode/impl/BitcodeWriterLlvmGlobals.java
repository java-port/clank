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
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.SmallString;
import org.llvm.adt.Triple;
import org.llvm.adt.Twine;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.bitcode.*;
import org.llvm.bitcode.writer.impl.BitcodeWriterStatics;
import org.llvm.bitcode.writer.impl.IndexBitcodeWriter;
import org.llvm.bitcode.writer.impl.ModuleBitcodeWriter;


//<editor-fold defaultstate="collapsed" desc="static type BitcodeWriterLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.bitcode.impl.BitcodeWriterLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm16WriteIndexToFileERKNS_18ModuleSummaryIndexERNS_11raw_ostreamEPSt3mapINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEES5_IyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKySD_EEESE_ISB_ESaISG_IKSB_SK_EEE;_ZN4llvm18WriteBitcodeToFileEPKNS_6ModuleERNS_11raw_ostreamEbPKNS_18ModuleSummaryIndexEb; -static-type=BitcodeWriterLlvmGlobals -package=org.llvm.bitcode.impl")
//</editor-fold>
public final class BitcodeWriterLlvmGlobals {


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

/// WriteBitcodeToFile - Write the specified module to the specified output
/// stream.
//<editor-fold defaultstate="collapsed" desc="llvm::WriteBitcodeToFile">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3784,
 FQN="llvm::WriteBitcodeToFile", NM="_ZN4llvm18WriteBitcodeToFileEPKNS_6ModuleERNS_11raw_ostreamEbPKNS_18ModuleSummaryIndexEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm18WriteBitcodeToFileEPKNS_6ModuleERNS_11raw_ostreamEbPKNS_18ModuleSummaryIndexEb")
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
  ModuleBitcodeWriter ModuleWriter = null;
  try {
    SmallString Buffer/*J*/= new SmallString(0);
    Buffer.reserve(256 * 1024);
    
    // If this is darwin or another generic macho target, reserve space for the
    // header.
    Triple TT/*J*/= new Triple(new Twine(M.getTargetTriple()));
    if (TT.isOSDarwin() || TT.isOSBinFormatMachO()) {
      Buffer.insert(Buffer.begin(), BitcodeLlvmGlobals.BWH_HeaderSize, $int2char(0));
    }
    
    // Emit the module into the buffer.
    ModuleWriter/*J*/= new ModuleBitcodeWriter(M, Buffer, ShouldPreserveUseListOrder, Index, 
        GenerateHash);
    ModuleWriter.write();
    if (TT.isOSDarwin() || TT.isOSBinFormatMachO()) {
      BitcodeWriterStatics.emitDarwinBCHeaderAndTrailer(Buffer, TT);
    }
    
    // Write the generated bitstream to "Out".
    Out.write(reinterpret_cast(char$ptr/*char P*/ .class, $AddrOf(Buffer.front())), Buffer.size());
  } finally {
    if (ModuleWriter != null) { ModuleWriter.$destroy(); }
  }
}


/// Write the specified module summary index to the given raw output stream,
/// where it will be written in a new bitcode block. This is used when
/// writing the combined index file for ThinLTO. When writing a subset of the
/// index for a distributed backend, provide the \p ModuleToSummariesForIndex
/// map.

// Write the specified module summary index to the given raw output stream,
// where it will be written in a new bitcode block. This is used when
// writing the combined index file for ThinLTO. When writing a subset of the
// index for a distributed backend, provide a \p ModuleToSummariesForIndex map.
//<editor-fold defaultstate="collapsed" desc="llvm::WriteIndexToFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3837,
 FQN="llvm::WriteIndexToFile", NM="_ZN4llvm16WriteIndexToFileERKNS_18ModuleSummaryIndexERNS_11raw_ostreamEPSt3mapISsS5_IyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS7_EEES8_ISsESaISA_IKSsSE_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm16WriteIndexToFileERKNS_18ModuleSummaryIndexERNS_11raw_ostreamEPSt3mapISsS5_IyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS7_EEES8_ISsESaISA_IKSsSE_EEE")
//</editor-fold>
public static void WriteIndexToFile(final /*const*/ ModuleSummaryIndex /*&*/ Index, final raw_ostream /*&*/ Out) {
  WriteIndexToFile(Index, Out, 
                (std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/)null);
}
public static void WriteIndexToFile(final /*const*/ ModuleSummaryIndex /*&*/ Index, final raw_ostream /*&*/ Out, 
                std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/ ModuleToSummariesForIndex/*= null*/) {
  IndexBitcodeWriter IndexWriter = null;
  try {
    SmallString Buffer/*J*/= new SmallString(0);
    Buffer.reserve(256 * 1024);
    
    IndexWriter/*J*/= new IndexBitcodeWriter(Buffer, Index, ModuleToSummariesForIndex);
    IndexWriter.write();
    
    Out.write(reinterpret_cast(char$ptr/*char P*/ .class, $AddrOf(Buffer.front())), Buffer.size());
  } finally {
    if (IndexWriter != null) { IndexWriter.$destroy(); }
  }
}

} // END OF class BitcodeWriterLlvmGlobals
