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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


/// Class to manage the bitcode writing for a module.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 106,
 FQN="(anonymous namespace)::ModuleBitcodeWriter", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriterE")
//</editor-fold>
public class ModuleBitcodeWriter extends /*public*/ BitcodeWriter implements Destructors.ClassWithDestructor {
  /// The Module to write to bitcode.
  private /*const*/ Module /*&*/ M;
  
  /// Enumerates ids for all values in the module.
  private ValueEnumerator VE;
  
  /// Optional per-module index to write for ThinLTO.
  private /*const*/ ModuleSummaryIndex /*P*/ Index;
  
  /// True if a module hash record should be written.
  private boolean GenerateHash;
  
  /// The start bit of the module block, for use in generating a module hash
  private long/*uint64_t*/ BitcodeStartBit/* = 0*/;
  
  /// Map that holds the correspondence between GUIDs in the summary index,
  /// that came from indirect call profiles, and a value id generated by this
  /// class to use in the VST and summary block records.
  private std.mapULongUInt GUIDToValueIdMap;
  
  /// Tracks the last value id recorded in the GUIDToValueMap.
  private /*uint*/int GlobalValueId;
/*public:*/
  /// Constructs a ModuleBitcodeWriter object for the given Module,
  /// writing to the provided \p Buffer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::ModuleBitcodeWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 133,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::ModuleBitcodeWriter", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriterC1EPKN4llvm6ModuleERNS1_15SmallVectorImplIcEEbPKNS1_18ModuleSummaryIndexEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriterC1EPKN4llvm6ModuleERNS1_15SmallVectorImplIcEEbPKNS1_18ModuleSummaryIndexEb")
  //</editor-fold>
  public ModuleBitcodeWriter(/*const*/ Module /*P*/ M, SmallString/*&*/ Buffer, 
      boolean ShouldPreserveUseListOrder, 
      /*const*/ ModuleSummaryIndex /*P*/ Index, boolean GenerateHash) {
    // : BitcodeWriter(Buffer), M(*M), VE(*M, ShouldPreserveUseListOrder), Index(Index), GenerateHash(GenerateHash), BitcodeStartBit(0), GUIDToValueIdMap() 
    super(Buffer);
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Main entry point for writing a module to bitcode, invoked by
  /// BitcodeWriter::write() after it writes the header.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3633,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeBlocks", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter11writeBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter11writeBlocksEv")
  //</editor-fold>
  @Override protected/*private*/ void writeBlocks()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Create the "IDENTIFICATION_BLOCK_ID" containing a single string with the
  /// current llvm version, and a record for the epoch number.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeIdentificationBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3583,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeIdentificationBlock", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter24writeIdentificationBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter24writeIdentificationBlockEv")
  //</editor-fold>
  private void writeIdentificationBlock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit the current module to the bitstream.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3643,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModule", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter11writeModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter11writeModuleEv")
  //</editor-fold>
  private void writeModule() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::bitcodeStartBit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 176,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::bitcodeStartBit", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter15bitcodeStartBitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter15bitcodeStartBitEv")
  //</editor-fold>
  private long/*uint64_t*/ bitcodeStartBit() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeStringRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 596,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeStringRecord", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeStringRecordEjN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeStringRecordEjN4llvm9StringRefEj")
  //</editor-fold>
  private void writeStringRecord(/*uint*/int Code, StringRef Str, 
                   /*uint*/int AbbrevToUse) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeAttributeGroupTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 726,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeAttributeGroupTable", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter24writeAttributeGroupTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter24writeAttributeGroupTableEv")
  //</editor-fold>
  private void writeAttributeGroupTable() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeAttributeTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 773,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeAttributeTable", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeAttributeTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeAttributeTableEv")
  //</editor-fold>
  private void writeAttributeTable() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// WriteTypeTable - Write out the type table for a module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeTypeTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 793,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeTypeTable", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter14writeTypeTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter14writeTypeTableEv")
  //</editor-fold>
  private void writeTypeTable() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeComdats">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1053,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeComdats", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeComdatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeComdatsEv")
  //</editor-fold>
  private void writeComdats() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit top-level description of module, including target triple, inline asm,
  /// descriptors for global variables, and function prototype info.
  /// Returns the bit offset to backpatch with the location of the real VST.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModuleInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1115,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModuleInfo", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeModuleInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeModuleInfoEv")
  //</editor-fold>
  private void writeModuleInfo() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeValueAsMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1348,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeValueAsMetadata", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeValueAsMetadataEPKN4llvm15ValueAsMetadataERNS1_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeValueAsMetadataEPKN4llvm15ValueAsMetadataERNS1_15SmallVectorImplIyEE")
  //</editor-fold>
  private void writeValueAsMetadata(/*const*/ ValueAsMetadata /*P*/ MD, SmallVectorImplULong /*&*/ Record) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeMDTuple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1358,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeMDTuple", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeMDTupleEPKN4llvm7MDTupleERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeMDTupleEPKN4llvm7MDTupleERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeMDTuple(/*const*/ MDTuple /*P*/ N, 
              SmallVectorImplULong /*&*/ Record, 
              /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::createDILocationAbbrev">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1373,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::createDILocationAbbrev", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter22createDILocationAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter22createDILocationAbbrevEv")
  //</editor-fold>
  private /*uint*/int createDILocationAbbrev() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDILocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1386,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDILocation", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeDILocationEPKN4llvm10DILocationERNS1_15SmallVectorImplIyEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeDILocationEPKN4llvm10DILocationERNS1_15SmallVectorImplIyEERj")
  //</editor-fold>
  private void writeDILocation(/*const*/ DILocation /*P*/ N, 
                 SmallVectorImplULong /*&*/ Record, 
                 uint$ref/*uint &*/ Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::createGenericDINodeAbbrev">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1402,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::createGenericDINodeAbbrev", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter25createGenericDINodeAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter25createGenericDINodeAbbrevEv")
  //</editor-fold>
  private /*uint*/int createGenericDINodeAbbrev() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeGenericDINode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1416,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeGenericDINode", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeGenericDINodeEPKN4llvm13GenericDINodeERNS1_15SmallVectorImplIyEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeGenericDINodeEPKN4llvm13GenericDINodeERNS1_15SmallVectorImplIyEERj")
  //</editor-fold>
  private void writeGenericDINode(/*const*/ GenericDINode /*P*/ N, 
                    SmallVectorImplULong /*&*/ Record, 
                    uint$ref/*uint &*/ Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDISubrange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1438,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDISubrange", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeDISubrangeEPKN4llvm10DISubrangeERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeDISubrangeEPKN4llvm10DISubrangeERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDISubrange(/*const*/ DISubrange /*P*/ N, 
                 SmallVectorImplULong /*&*/ Record, 
                 /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIEnumerator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1449,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIEnumerator", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeDIEnumeratorEPKN4llvm12DIEnumeratorERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeDIEnumeratorEPKN4llvm12DIEnumeratorERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIEnumerator(/*const*/ DIEnumerator /*P*/ N, 
                   SmallVectorImplULong /*&*/ Record, 
                   /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIBasicType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1460,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIBasicType", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeDIBasicTypeEPKN4llvm11DIBasicTypeERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeDIBasicTypeEPKN4llvm11DIBasicTypeERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIBasicType(/*const*/ DIBasicType /*P*/ N, 
                  SmallVectorImplULong /*&*/ Record, 
                  /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIDerivedType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1474,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIDerivedType", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeDIDerivedTypeEPKN4llvm13DIDerivedTypeERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeDIDerivedTypeEPKN4llvm13DIDerivedTypeERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIDerivedType(/*const*/ DIDerivedType /*P*/ N, 
                    SmallVectorImplULong /*&*/ Record, 
                    /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDICompositeType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1494,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDICompositeType", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeDICompositeTypeEPKN4llvm15DICompositeTypeERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeDICompositeTypeEPKN4llvm15DICompositeTypeERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDICompositeType(/*const*/ DICompositeType /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                      /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDISubroutineType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1519,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDISubroutineType", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeDISubroutineTypeEPKN4llvm16DISubroutineTypeERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeDISubroutineTypeEPKN4llvm16DISubroutineTypeERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDISubroutineType(/*const*/ DISubroutineType /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                       /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1532,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIFile", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter11writeDIFileEPKN4llvm6DIFileERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter11writeDIFileEPKN4llvm6DIFileERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIFile(/*const*/ DIFile /*P*/ N, 
             SmallVectorImplULong /*&*/ Record, 
             /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDICompileUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1543,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDICompileUnit", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeDICompileUnitEPKN4llvm13DICompileUnitERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeDICompileUnitEPKN4llvm13DICompileUnitERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDICompileUnit(/*const*/ DICompileUnit /*P*/ N, 
                    SmallVectorImplULong /*&*/ Record, 
                    /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDISubprogram">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1568,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDISubprogram", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeDISubprogramEPKN4llvm12DISubprogramERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeDISubprogramEPKN4llvm12DISubprogramERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDISubprogram(/*const*/ DISubprogram /*P*/ N, 
                   SmallVectorImplULong /*&*/ Record, 
                   /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDILexicalBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1597,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDILexicalBlock", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeDILexicalBlockEPKN4llvm14DILexicalBlockERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeDILexicalBlockEPKN4llvm14DILexicalBlockERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDILexicalBlock(/*const*/ DILexicalBlock /*P*/ N, 
                     SmallVectorImplULong /*&*/ Record, 
                     /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDILexicalBlockFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1610,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDILexicalBlockFile", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter23writeDILexicalBlockFileEPKN4llvm18DILexicalBlockFileERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter23writeDILexicalBlockFileEPKN4llvm18DILexicalBlockFileERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDILexicalBlockFile(/*const*/ DILexicalBlockFile /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                         /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDINamespace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1622,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDINamespace", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeDINamespaceEPKN4llvm11DINamespaceERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeDINamespaceEPKN4llvm11DINamespaceERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDINamespace(/*const*/ DINamespace /*P*/ N, 
                  SmallVectorImplULong /*&*/ Record, 
                  /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIMacro">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1635,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIMacro", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeDIMacroEPKN4llvm7DIMacroERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeDIMacroEPKN4llvm7DIMacroERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIMacro(/*const*/ DIMacro /*P*/ N, 
              SmallVectorImplULong /*&*/ Record, 
              /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIMacroFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1648,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIMacroFile", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeDIMacroFileEPKN4llvm11DIMacroFileERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeDIMacroFileEPKN4llvm11DIMacroFileERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIMacroFile(/*const*/ DIMacroFile /*P*/ N, 
                  SmallVectorImplULong /*&*/ Record, 
                  /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1661,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIModule", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter13writeDIModuleEPKN4llvm8DIModuleERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter13writeDIModuleEPKN4llvm8DIModuleERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIModule(/*const*/ DIModule /*P*/ N, 
               SmallVectorImplULong /*&*/ Record, 
               /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDITemplateTypeParameter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1672,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDITemplateTypeParameter", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter28writeDITemplateTypeParameterEPKN4llvm23DITemplateTypeParameterERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter28writeDITemplateTypeParameterEPKN4llvm23DITemplateTypeParameterERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDITemplateTypeParameter(/*const*/ DITemplateTypeParameter /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                              /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDITemplateValueParameter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1683,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDITemplateValueParameter", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter29writeDITemplateValueParameterEPKN4llvm24DITemplateValueParameterERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter29writeDITemplateValueParameterEPKN4llvm24DITemplateValueParameterERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDITemplateValueParameter(/*const*/ DITemplateValueParameter /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                               /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1696,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIGlobalVariable", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeDIGlobalVariableEPKN4llvm16DIGlobalVariableERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeDIGlobalVariableEPKN4llvm16DIGlobalVariableERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIGlobalVariable(/*const*/ DIGlobalVariable /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                       /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDILocalVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1715,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDILocalVariable", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeDILocalVariableEPKN4llvm15DILocalVariableERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeDILocalVariableEPKN4llvm15DILocalVariableERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDILocalVariable(/*const*/ DILocalVariable /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                      /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1731,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIExpression", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeDIExpressionEPKN4llvm12DIExpressionERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeDIExpressionEPKN4llvm12DIExpressionERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIExpression(/*const*/ DIExpression /*P*/ N, 
                   SmallVectorImplULong /*&*/ Record, 
                   /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIObjCProperty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1743,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIObjCProperty", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeDIObjCPropertyEPKN4llvm14DIObjCPropertyERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeDIObjCPropertyEPKN4llvm14DIObjCPropertyERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIObjCProperty(/*const*/ DIObjCProperty /*P*/ N, 
                     SmallVectorImplULong /*&*/ Record, 
                     /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeDIImportedEntity">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1759,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeDIImportedEntity", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeDIImportedEntityEPKN4llvm16DIImportedEntityERNS1_15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeDIImportedEntityEPKN4llvm16DIImportedEntityERNS1_15SmallVectorImplIyEEj")
  //</editor-fold>
  private void writeDIImportedEntity(/*const*/ DIImportedEntity /*P*/ N, SmallVectorImplULong /*&*/ Record, 
                       /*uint*/int Abbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::createNamedMetadataAbbrev">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1773,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::createNamedMetadataAbbrev", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter25createNamedMetadataAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter25createNamedMetadataAbbrevEv")
  //</editor-fold>
  private /*uint*/int createNamedMetadataAbbrev() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeNamedMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1781,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeNamedMetadata", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeNamedMetadataERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter18writeNamedMetadataERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  private void writeNamedMetadata(SmallVectorImplULong /*&*/ Record) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::createMetadataStringsAbbrev">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1802,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::createMetadataStringsAbbrev", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter27createMetadataStringsAbbrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter27createMetadataStringsAbbrevEv")
  //</editor-fold>
  private /*uint*/int createMetadataStringsAbbrev() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Write out a record for MDString.
  ///
  /// All the metadata strings in a metadata block are emitted in a single
  /// record.  The sizes and strings themselves are shoved into a blob.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeMetadataStrings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1815,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeMetadataStrings", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeMetadataStringsEN4llvm8ArrayRefIPKNS1_8MetadataEEERNS1_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeMetadataStringsEN4llvm8ArrayRefIPKNS1_8MetadataEEERNS1_15SmallVectorImplIyEE")
  //</editor-fold>
  private void writeMetadataStrings(ArrayRef</*const*/ Metadata /*P*/ > Strings, SmallVectorImplULong /*&*/ Record) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeMetadataRecords">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1845,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeMetadataRecords", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeMetadataRecordsEN4llvm8ArrayRefIPKNS1_8MetadataEEERNS1_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeMetadataRecordsEN4llvm8ArrayRefIPKNS1_8MetadataEEERNS1_15SmallVectorImplIyEE")
  //</editor-fold>
  private void writeMetadataRecords(ArrayRef</*const*/ Metadata /*P*/ > MDs, SmallVectorImplULong /*&*/ Record) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModuleMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1872,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModuleMetadata", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeModuleMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeModuleMetadataEv")
  //</editor-fold>
  private void writeModuleMetadata() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeFunctionMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1900,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeFunctionMetadata", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeFunctionMetadataERKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeFunctionMetadataERKN4llvm8FunctionE")
  //</editor-fold>
  private void writeFunctionMetadata(/*const*/ Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeFunctionMetadataAttachment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1922,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeFunctionMetadataAttachment", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter31writeFunctionMetadataAttachmentERKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter31writeFunctionMetadataAttachmentERKN4llvm8FunctionE")
  //</editor-fold>
  private void writeFunctionMetadataAttachment(/*const*/ Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeGlobalVariableMetadataAttachment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 254,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeGlobalVariableMetadataAttachment", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter37writeGlobalVariableMetadataAttachmentERKN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter37writeGlobalVariableMetadataAttachmentERKN4llvm14GlobalVariableE")
  //</editor-fold>
  private void writeGlobalVariableMetadataAttachment(/*const*/ GlobalVariable /*&*/ GV) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::pushGlobalMetadataAttachment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1911,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::pushGlobalMetadataAttachment", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter28pushGlobalMetadataAttachmentERN4llvm15SmallVectorImplIyEERKNS1_12GlobalObjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter28pushGlobalMetadataAttachmentERN4llvm15SmallVectorImplIyEERKNS1_12GlobalObjectE")
  //</editor-fold>
  private void pushGlobalMetadataAttachment(SmallVectorImplULong /*&*/ Record, /*const*/ GlobalObject /*&*/ GO) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModuleMetadataKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1957,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModuleMetadataKinds", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter24writeModuleMetadataKindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter24writeModuleMetadataKindsEv")
  //</editor-fold>
  private void writeModuleMetadataKinds() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeOperandBundleTags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 1981,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeOperandBundleTags", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter22writeOperandBundleTagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter22writeOperandBundleTagsEv")
  //</editor-fold>
  private void writeOperandBundleTags() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeConstants">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2015,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeConstants", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter14writeConstantsEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter14writeConstantsEjjb")
  //</editor-fold>
  private void writeConstants(/*uint*/int FirstVal, /*uint*/int LastVal, 
                boolean isGlobal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModuleConstants">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2270,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModuleConstants", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeModuleConstantsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter20writeModuleConstantsEv")
  //</editor-fold>
  private void writeModuleConstants() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// pushValueAndType - The file has to encode both the value and type id for
  /// many values, because we need to know what type to create for forward
  /// references.  However, most operands are not forward references, so this type
  /// field is not needed.
  ///
  /// This function adds V's value ID to Vals.  If the value ID is higher than the
  /// instruction ID, then it is a forward reference, and it also includes the
  /// type ID.  The value ID that is written is encoded relative to the InstID.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::pushValueAndType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2291,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::pushValueAndType", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter16pushValueAndTypeEPKN4llvm5ValueEjRNS1_15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter16pushValueAndTypeEPKN4llvm5ValueEjRNS1_15SmallVectorImplIjEE")
  //</editor-fold>
  private boolean pushValueAndType(/*const*/ Value /*P*/ V, /*uint*/int InstID, 
                  SmallVectorImplUInt/*&*/ Vals) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeOperandBundles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2303,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeOperandBundles", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeOperandBundlesEN4llvm17ImmutableCallSiteEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter19writeOperandBundlesEN4llvm17ImmutableCallSiteEj")
  //</editor-fold>
  private void writeOperandBundles(ImmutableCallSite CS, 
                     /*uint*/int InstID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// pushValue - Like pushValueAndType, but where the type of the value is
  /// omitted (perhaps it was already encoded in an earlier operand).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::pushValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2322,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::pushValue", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter9pushValueEPKN4llvm5ValueEjRNS1_15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter9pushValueEPKN4llvm5ValueEjRNS1_15SmallVectorImplIjEE")
  //</editor-fold>
  private void pushValue(/*const*/ Value /*P*/ V, /*uint*/int InstID, 
           SmallVectorImplUInt/*&*/ Vals) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::pushValueSigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2328,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::pushValueSigned", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter15pushValueSignedEPKN4llvm5ValueEjRNS1_15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter15pushValueSignedEPKN4llvm5ValueEjRNS1_15SmallVectorImplIyEE")
  //</editor-fold>
  private void pushValueSigned(/*const*/ Value /*P*/ V, /*uint*/int InstID, 
                 SmallVectorImplULong /*&*/ Vals) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// WriteInstruction - Emit an instruction to the specified stream.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2336,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeInstruction", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeInstructionERKN4llvm11InstructionEjRNS1_15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter16writeInstructionERKN4llvm11InstructionEjRNS1_15SmallVectorImplIjEE")
  //</editor-fold>
  private void writeInstruction(/*const*/ Instruction /*&*/ I, 
                  /*uint*/int InstID, 
                  SmallVectorImplUInt/*&*/ Vals) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit names for globals/functions etc. \p IsModuleLevel is true when
  /// we are writing the module-level VST, where we are including a function
  /// bitcode index and need to backpatch the VST forward declaration record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2724,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeValueSymbolTable", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeValueSymbolTableERKN4llvm16ValueSymbolTableEbPNS1_8DenseMapIPKNS1_8FunctionEyNS1_12DenseMapInfoIS8_EENS1_6detail12DenseMapPairIS8_yEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter21writeValueSymbolTableERKN4llvm16ValueSymbolTableEbPNS1_8DenseMapIPKNS1_8FunctionEyNS1_12DenseMapInfoIS8_EENS1_6detail12DenseMapPairIS8_yEEEE")
  //</editor-fold>
  private void writeValueSymbolTable(/*const*/ ValueSymbolTable /*&*/ VST) {
    writeValueSymbolTable(VST, false, 
                       (DenseMapTypeULong</*const*/ Function /*P*/ > /*P*/)null);
  }
  private void writeValueSymbolTable(/*const*/ ValueSymbolTable /*&*/ VST, boolean IsModuleLevel/*= false*/) {
    writeValueSymbolTable(VST, IsModuleLevel, 
                       (DenseMapTypeULong</*const*/ Function /*P*/ > /*P*/)null);
  }
  private void writeValueSymbolTable(/*const*/ ValueSymbolTable /*&*/ VST, boolean IsModuleLevel/*= false*/, 
                       DenseMapTypeULong</*const*/ Function /*P*/ > /*P*/ FunctionToBitcodeIndex/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeUseList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2898,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeUseList", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeUseListEON4llvm12UseListOrderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter12writeUseListEON4llvm12UseListOrderE")
  //</editor-fold>
  private void writeUseList(UseListOrder /*&&*/Order) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeUseListBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2911,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeUseListBlock", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeUseListBlockEPKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter17writeUseListBlockEPKN4llvm8FunctionE")
  //</editor-fold>
  private void writeUseListBlock(/*const*/ Function /*P*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit a function body to the module stream.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2931,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeFunction", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter13writeFunctionERKN4llvm8FunctionERNS1_8DenseMapIPS3_yNS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_yEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter13writeFunctionERKN4llvm8FunctionERNS1_8DenseMapIPS3_yNS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_yEEEE")
  //</editor-fold>
  private void writeFunction(/*const*/ Function /*&*/ F, 
               DenseMapTypeULong</*const*/ Function /*P*/ > /*&*/ FunctionToBitcodeIndex) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Emit blockinfo, which defines the standard abbreviations etc.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeBlockInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3008,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeBlockInfo", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter14writeBlockInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter14writeBlockInfoEv")
  //</editor-fold>
  private void writeBlockInfo() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Helper to emit a single function summary record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writePerModuleFunctionSummaryRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3263,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writePerModuleFunctionSummaryRecord", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter35writePerModuleFunctionSummaryRecordERN4llvm11SmallVectorIyLj64EEEPNS1_18GlobalValueSummaryEjjjRKNS1_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter35writePerModuleFunctionSummaryRecordERN4llvm11SmallVectorIyLj64EEEPNS1_18GlobalValueSummaryEjjjRKNS1_8FunctionE")
  //</editor-fold>
  private void writePerModuleFunctionSummaryRecord(SmallVectorULong /*&*/ NameVals, GlobalValueSummary /*P*/ Summary, 
                                     /*uint*/int ValueID, /*uint*/int FSCallsAbbrev, /*uint*/int FSCallsProfileAbbrev, 
                                     /*const*/ Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Collect the global value references in the given variable's initializer,
  // and emit them in a summary record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModuleLevelReferences">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3307,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModuleLevelReferences", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter26writeModuleLevelReferencesERKN4llvm14GlobalVariableERNS1_11SmallVectorIyLj64EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter26writeModuleLevelReferencesERKN4llvm14GlobalVariableERNS1_11SmallVectorIyLj64EEEj")
  //</editor-fold>
  private void writeModuleLevelReferences(/*const*/ GlobalVariable /*&*/ V, SmallVectorULong /*&*/ NameVals, 
                            /*uint*/int FSModRefsAbbrev) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit the per-module summary section alongside the rest of
  /// the module's bitcode.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writePerModuleGlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3337,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writePerModuleGlobalValueSummary", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter32writePerModuleGlobalValueSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter32writePerModuleGlobalValueSummaryEv")
  //</editor-fold>
  private void writePerModuleGlobalValueSummary() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::writeModuleHash">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3605,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::writeModuleHash", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeModuleHashEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter15writeModuleHashEj")
  //</editor-fold>
  private void writeModuleHash(/*size_t*/int BlockStartPos) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::assignValueId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 291,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::assignValueId", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter13assignValueIdEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter13assignValueIdEy")
  //</editor-fold>
  private void assignValueId(long/*uint64_t*/ ValGUID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::getValueId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 294,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::getValueId", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter10getValueIdEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter10getValueIdEy")
  //</editor-fold>
  private /*uint*/int getValueId(long/*uint64_t*/ ValGUID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Helper to get the valueId for the type of value recorded in VI.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::getValueId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 300,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::getValueId", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter10getValueIdEN4llvm9ValueInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter10getValueIdEN4llvm9ValueInfoE")
  //</editor-fold>
  private /*uint*/int getValueId(ValueInfo VI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::valueIds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 305,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::valueIds", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriter8valueIdsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriter8valueIdsEv")
  //</editor-fold>
  private std.mapULongUInt /*&*/ valueIds() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ModuleBitcodeWriter::~ModuleBitcodeWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 106,
   FQN="(anonymous namespace)::ModuleBitcodeWriter::~ModuleBitcodeWriter", NM="_ZN12_GLOBAL__N_119ModuleBitcodeWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_119ModuleBitcodeWriterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", VE=" + VE // NOI18N
              + ", Index=" + Index // NOI18N
              + ", GenerateHash=" + GenerateHash // NOI18N
              + ", BitcodeStartBit=" + BitcodeStartBit // NOI18N
              + ", GUIDToValueIdMap=" + GUIDToValueIdMap // NOI18N
              + ", GlobalValueId=" + GlobalValueId // NOI18N
              + super.toString(); // NOI18N
  }
}
