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

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.bitcode.*;
import org.llvm.ir.java.IRFunctionPointers.*;


/// Class to manage reading and parsing function summary index bitcode
/// files/sections.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 469,
 FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReaderE")
//</editor-fold>
public class ModuleSummaryIndexBitcodeReader implements Destructors.ClassWithDestructor {
  private DiagnosticHandlerFunction DiagnosticHandler;
  
  /// Eventually points to the module index built during parsing.
  private ModuleSummaryIndex /*P*/ TheIndex/* = null*/;
  
  private std.unique_ptr<MemoryBuffer> Buffer;
  private std.unique_ptr<BitstreamReader> StreamFile;
  private BitstreamCursor Stream;
  
  /// Used to indicate whether caller only wants to check for the presence
  /// of the global value summary bitcode section. All blocks are skipped,
  /// but the SeenGlobalValSummary boolean is set.
  private boolean CheckGlobalValSummaryPresenceOnly/* = false*/;
  
  /// Indicates whether we have encountered a global value summary section
  /// yet during parsing, used when checking if file contains global value
  /// summary section.
  private boolean SeenGlobalValSummary/* = false*/;
  
  /// Indicates whether we have already parsed the VST, used for error checking.
  private boolean SeenValueSymbolTable/* = false*/;
  
  /// Set to the offset of the VST recorded in the MODULE_CODE_VSTOFFSET record.
  /// Used to enable on-demand parsing of the VST.
  private long/*uint64_t*/ VSTOffset/* = 0*/;
  
  // Map to save ValueId to GUID association that was recorded in the
  // ValueSymbolTable. It is used after the VST is parsed to convert
  // call graph edges read from the function summary from referencing
  // callees by their ValueId to using the GUID instead, which is how
  // they are recorded in the summary index being built.
  // We save a second GUID which is the same as the first one, but ignoring the
  // linkage, i.e. for value other than local linkage they are identical.
  private DenseMapUIntType<std.pairULongULong> ValueIdToCallGraphGUIDMap;
  
  /// Map populated during module path string table parsing, from the
  /// module ID to a string reference owned by the index's module
  /// path string table, used to correlate with combined index
  /// summary records.
  private DenseMapULongType<StringRef> ModuleIdMap;
  
  /// Original source file name recorded in a bitcode record.
  private std.string SourceFileName;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::error">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5839,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::error", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader5errorERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader5errorERKN4llvm5TwineE")
  //</editor-fold>
  public std.error_code error(/*const*/ Twine /*&*/ Message) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::ModuleSummaryIndexBitcodeReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5844,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::ModuleSummaryIndexBitcodeReader", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReaderC1EPN4llvm12MemoryBufferESt8functionIFvRKNS1_14DiagnosticInfoEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReaderC1EPN4llvm12MemoryBufferESt8functionIFvRKNS1_14DiagnosticInfoEEEb")
  //</editor-fold>
  public ModuleSummaryIndexBitcodeReader(MemoryBuffer /*P*/ Buffer, DiagnosticHandlerFunction DiagnosticHandler) {
    this(Buffer, DiagnosticHandler, 
      false);
  }
  public ModuleSummaryIndexBitcodeReader(MemoryBuffer /*P*/ Buffer, DiagnosticHandlerFunction DiagnosticHandler, 
      boolean CheckGlobalValSummaryPresenceOnly/*= false*/) {
    // : DiagnosticHandler(std::move(DiagnosticHandler)), TheIndex(null), Buffer(Buffer), StreamFile(), Stream(), CheckGlobalValSummaryPresenceOnly(CheckGlobalValSummaryPresenceOnly), SeenGlobalValSummary(false), SeenValueSymbolTable(false), VSTOffset(0), ValueIdToCallGraphGUIDMap(), ModuleIdMap(), SourceFileName() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::~ModuleSummaryIndexBitcodeReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 521,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::~ModuleSummaryIndexBitcodeReader", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReaderD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::freeState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5850,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::freeState", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader9freeStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader9freeStateEv")
  //</editor-fold>
  public void freeState() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::releaseBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5852,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::releaseBuffer", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader13releaseBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader13releaseBufferEv")
  //</editor-fold>
  public void releaseBuffer() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Check if the parser has encountered a summary section.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::foundGlobalValSummary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 528,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::foundGlobalValSummary", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader21foundGlobalValSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader21foundGlobalValSummaryEv")
  //</editor-fold>
  public boolean foundGlobalValSummary() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Main interface to parsing a bitcode buffer.
  /// \returns true if an error occurred.
  
  // Parse the function info index from the bitcode streamer into the given index.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseSummaryIndexInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6423,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseSummaryIndexInto", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader21parseSummaryIndexIntoESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EEPNS2_18ModuleSummaryIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader21parseSummaryIndexIntoESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EEPNS2_18ModuleSummaryIndexE")
  //</editor-fold>
  public std.error_code parseSummaryIndexInto(std.unique_ptr<DataStreamer> Streamer, ModuleSummaryIndex /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  
  // Parse just the blocks needed for building the index out of the module.
  // At the end of this routine the module Index is populated with a map
  // from global value id to GlobalValueSummary objects.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5962,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseModule", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader11parseModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader11parseModuleEv")
  //</editor-fold>
  private std.error_code parseModule() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Specialized value symbol table parser used when reading module index
  // blocks where we don't actually create global values. The parsed information
  // is saved in the bitcode reader for use when later parsing summaries.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5864,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseValueSymbolTable", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader21parseValueSymbolTableEyRN4llvm8DenseMapIjNS1_11GlobalValue12LinkageTypesENS1_12DenseMapInfoIjEENS1_6detail12DenseMapPairIjS4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader21parseValueSymbolTableEyRN4llvm8DenseMapIjNS1_11GlobalValue12LinkageTypesENS1_12DenseMapInfoIjEENS1_6detail12DenseMapPairIjS4_EEEE")
  //</editor-fold>
  private std.error_code parseValueSymbolTable(long/*uint64_t*/ Offset, 
                       DenseMapUIntType<GlobalValue.LinkageTypes>/*&*/ ValueIdToLinkageMap) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Eagerly parse the entire summary block. This populates the GlobalValueSummary
  // objects in the index.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseEntireSummary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6110,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseEntireSummary", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader18parseEntireSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader18parseEntireSummaryEv")
  //</editor-fold>
  private std.error_code parseEntireSummary() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Parse the  module string table block into the Index.
  // This populates the ModulePathStringTable map in the index.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseModuleStringTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6363,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::parseModuleStringTable", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader22parseModuleStringTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader22parseModuleStringTableEv")
  //</editor-fold>
  private std.error_code parseModuleStringTable() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::initStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6458,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::initStream", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader10initStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader10initStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE")
  //</editor-fold>
  private std.error_code initStream(std.unique_ptr<DataStreamer> Streamer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::initStreamFromBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6465,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::initStreamFromBuffer", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader20initStreamFromBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader20initStreamFromBufferEv")
  //</editor-fold>
  private std.error_code initStreamFromBuffer() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::initLazyStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 6484,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::initLazyStream", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader14initLazyStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader14initLazyStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE")
  //</editor-fold>
  private std.error_code initLazyStream(std.unique_ptr<DataStreamer> Streamer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::getGUIDFromValueId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5854,
   FQN="(anonymous namespace)::ModuleSummaryIndexBitcodeReader::getGUIDFromValueId", NM="_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader18getGUIDFromValueIdEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_131ModuleSummaryIndexBitcodeReader18getGUIDFromValueIdEj")
  //</editor-fold>
  private std.pairULongULong getGUIDFromValueId(/*uint*/int ValueId) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DiagnosticHandler=" + DiagnosticHandler // NOI18N
              + ", TheIndex=" + TheIndex // NOI18N
              + ", Buffer=" + Buffer // NOI18N
              + ", StreamFile=" + StreamFile // NOI18N
              + ", Stream=" + Stream // NOI18N
              + ", CheckGlobalValSummaryPresenceOnly=" + CheckGlobalValSummaryPresenceOnly // NOI18N
              + ", SeenGlobalValSummary=" + SeenGlobalValSummary // NOI18N
              + ", SeenValueSymbolTable=" + SeenValueSymbolTable // NOI18N
              + ", VSTOffset=" + VSTOffset // NOI18N
              + ", ValueIdToCallGraphGUIDMap=" + ValueIdToCallGraphGUIDMap // NOI18N
              + ", ModuleIdMap=" + ModuleIdMap // NOI18N
              + ", SourceFileName=" + SourceFileName; // NOI18N
  }
}
