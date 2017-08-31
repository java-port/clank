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
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.bitcode.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 186,
 FQN="(anonymous namespace)::BitcodeReader", NM="_ZN12_GLOBAL__N_113BitcodeReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReaderE")
//</editor-fold>
public class BitcodeReader extends /*public*/ GVMaterializer implements Destructors.ClassWithDestructor {
  private LLVMContext /*&*/ Context;
  private Module /*P*/ TheModule/* = null*/;
  private std.unique_ptr<MemoryBuffer> Buffer;
  private std.unique_ptr<BitstreamReader> StreamFile;
  private BitstreamCursor Stream;
  // Next offset to start scanning for lazy parsing of function bodies.
  private long/*uint64_t*/ NextUnreadBit/* = 0*/;
  // Last function offset found in the VST.
  private long/*uint64_t*/ LastFunctionBlockBit/* = 0*/;
  private boolean SeenValueSymbolTable/* = false*/;
  private long/*uint64_t*/ VSTOffset/* = 0*/;
  // Contains an arbitrary and optional string identifying the bitcode producer
  private std.string ProducerIdentification;
  
  private std.vector<Type /*P*/ > TypeList;
  private BitcodeReaderValueList ValueList;
  private BitcodeReaderMetadataList MetadataList;
  private std.vector<Comdat /*P*/ > ComdatList;
  private SmallVector<Instruction /*P*/ > InstructionList;
  
  private std.vector<std.pairTypeUInt<GlobalVariable /*P*/ >> GlobalInits;
  private std.vector<std.pairTypeUInt<GlobalIndirectSymbol /*P*/ >> IndirectSymbolInits;
  private std.vector<std.pairTypeUInt<Function /*P*/ >> FunctionPrefixes;
  private std.vector<std.pairTypeUInt<Function /*P*/ >> FunctionPrologues;
  private std.vector<std.pairTypeUInt<Function /*P*/ >> FunctionPersonalityFns;
  
  private SmallVector<Instruction /*P*/ > InstsWithTBAATag;
  
  private boolean HasSeenOldLoopTags/* = false*/;
  
  /// The set of attributes by index.  Index zero in the file is for null, and
  /// is thus not represented here.  As such all indices are off by one.
  private std.vector<AttributeSet> MAttributes;
  
  /// The set of attribute groups.
  private std.mapUIntType<AttributeSet> MAttributeGroups;
  
  /// While parsing a function body, this is a list of the basic blocks for the
  /// function.
  private std.vector<BasicBlock /*P*/ > FunctionBBs;
  
  // When reading the module header, this list is populated with functions that
  // have bodies later in the file.
  private std.vector<Function /*P*/ > FunctionsWithBodies;
  
  // When intrinsic functions are encountered which require upgrading they are
  // stored here with their replacement function.
  /*typedef DenseMap<Function *, Function *> UpdatedIntrinsicMap*/
//  public final class UpdatedIntrinsicMap extends DenseMap<Function /*P*/ , Function /*P*/ >{ };
  private DenseMap<Function /*P*/ , Function /*P*/ > UpgradedIntrinsics;
  // Intrinsics which were remangled because of types rename
  private DenseMap<Function /*P*/ , Function /*P*/ > RemangledIntrinsics;
  
  // Map the bitcode's custom MDKind ID to the Module's MDKind ID.
  private DenseMapUIntUInt MDKindMap;
  
  // Several operations happen after the module header has been read, but
  // before function bodies are processed. This keeps track of whether
  // we've done this yet.
  private boolean SeenFirstFunctionBody/* = false*/;
  
  /// When function bodies are initially scanned, this map contains info about
  /// where to find deferred function body in the stream.
  private DenseMapTypeULong<Function /*P*/ > DeferredFunctionInfo;
  
  /// When Metadata block is initially scanned when parsing the module, we may
  /// choose to defer parsing of the metadata. This vector contains info about
  /// which Metadata blocks are deferred.
  private std.vectorULong DeferredMetadataInfo;
  
  /// These are basic blocks forward-referenced by block addresses.  They are
  /// inserted lazily into functions when they're loaded.  The basic block ID is
  /// its index into the vector.
  private DenseMap<Function /*P*/ , std.vector<BasicBlock /*P*/ > > BasicBlockFwdRefs;
  private std.deque<Function /*P*/ > BasicBlockFwdRefQueue;
  
  /// Indicates that we are using a new encoding for instruction operands where
  /// most operands in the current FUNCTION_BLOCK are encoded relative to the
  /// instruction number, for a more compact encoding.  Some instruction
  /// operands are not relative to the instruction ID: basic block numbers, and
  /// types. Once the old style function blocks have been phased out, we would
  /// not need this flag.
  private boolean UseRelativeIDs/* = false*/;
  
  /// True if all functions will be materialized, negating the need to process
  /// (e.g.) blockaddress forward references.
  private boolean WillMaterializeAllForwardRefs/* = false*/;
  
  /// True if any Metadata block has been materialized.
  private boolean IsMetadataMaterialized/* = false*/;
  
  private boolean StripDebugInfo/* = false*/;
  
  /// Functions that need to be matched with subprograms when upgrading old
  /// metadata.
  private SmallDenseMap<Function /*P*/ , DISubprogram /*P*/ > FunctionsWithSPs;
  
  private std.vectorString BundleTags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::error">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 575,
   FQN="(anonymous namespace)::BitcodeReader::error", NM="_ZN12_GLOBAL__N_113BitcodeReader5errorEN4llvm12BitcodeErrorERKNS1_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader5errorEN4llvm12BitcodeErrorERKNS1_5TwineE")
  //</editor-fold>
  public std.error_code error(BitcodeError E, /*const*/ Twine /*&*/ Message) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::error">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 584,
   FQN="(anonymous namespace)::BitcodeReader::error", NM="_ZN12_GLOBAL__N_113BitcodeReader5errorERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader5errorERKN4llvm5TwineE")
  //</editor-fold>
  public std.error_code error(/*const*/ Twine /*&*/ Message) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::BitcodeReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 594,
   FQN="(anonymous namespace)::BitcodeReader::BitcodeReader", NM="_ZN12_GLOBAL__N_113BitcodeReaderC1EPN4llvm12MemoryBufferERNS1_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReaderC1EPN4llvm12MemoryBufferERNS1_11LLVMContextE")
  //</editor-fold>
  public BitcodeReader(MemoryBuffer /*P*/ Buffer, LLVMContext /*&*/ Context) {
    // : GVMaterializer(), Context(Context), TheModule(null), Buffer(Buffer), StreamFile(), Stream(), NextUnreadBit(0), LastFunctionBlockBit(0), SeenValueSymbolTable(false), VSTOffset(0), ProducerIdentification(), TypeList(), ValueList(Context), MetadataList(Context), ComdatList(), InstructionList(), GlobalInits(), IndirectSymbolInits(), FunctionPrefixes(), FunctionPrologues(), FunctionPersonalityFns(), InstsWithTBAATag(), HasSeenOldLoopTags(false), MAttributes(), MAttributeGroups(), FunctionBBs(), FunctionsWithBodies(), UpgradedIntrinsics(), RemangledIntrinsics(), MDKindMap(), SeenFirstFunctionBody(false), DeferredFunctionInfo(), DeferredMetadataInfo(), BasicBlockFwdRefs(), BasicBlockFwdRefQueue(), UseRelativeIDs(false), WillMaterializeAllForwardRefs(false), IsMetadataMaterialized(false), StripDebugInfo(false), FunctionsWithSPs(), BundleTags(), IdentifiedStructTypes() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::BitcodeReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 598,
   FQN="(anonymous namespace)::BitcodeReader::BitcodeReader", NM="_ZN12_GLOBAL__N_113BitcodeReaderC1ERN4llvm11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReaderC1ERN4llvm11LLVMContextE")
  //</editor-fold>
  public BitcodeReader(LLVMContext /*&*/ Context) {
    // : GVMaterializer(), Context(Context), TheModule(null), Buffer(null), StreamFile(), Stream(), NextUnreadBit(0), LastFunctionBlockBit(0), SeenValueSymbolTable(false), VSTOffset(0), ProducerIdentification(), TypeList(), ValueList(Context), MetadataList(Context), ComdatList(), InstructionList(), GlobalInits(), IndirectSymbolInits(), FunctionPrefixes(), FunctionPrologues(), FunctionPersonalityFns(), InstsWithTBAATag(), HasSeenOldLoopTags(false), MAttributes(), MAttributeGroups(), FunctionBBs(), FunctionsWithBodies(), UpgradedIntrinsics(), RemangledIntrinsics(), MDKindMap(), SeenFirstFunctionBody(false), DeferredFunctionInfo(), DeferredMetadataInfo(), BasicBlockFwdRefs(), BasicBlockFwdRefQueue(), UseRelativeIDs(false), WillMaterializeAllForwardRefs(false), IsMetadataMaterialized(false), StripDebugInfo(false), FunctionsWithSPs(), BundleTags(), IdentifiedStructTypes() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::~BitcodeReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 291,
   FQN="(anonymous namespace)::BitcodeReader::~BitcodeReader", NM="_ZN12_GLOBAL__N_113BitcodeReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReaderD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::materializeForwardReferencedFunctions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 602,
   FQN="(anonymous namespace)::BitcodeReader::materializeForwardReferencedFunctions", NM="_ZN12_GLOBAL__N_113BitcodeReader37materializeForwardReferencedFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader37materializeForwardReferencedFunctionsEv")
  //</editor-fold>
  public std.error_code materializeForwardReferencedFunctions() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::freeState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 635,
   FQN="(anonymous namespace)::BitcodeReader::freeState", NM="_ZN12_GLOBAL__N_113BitcodeReader9freeStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader9freeStateEv")
  //</editor-fold>
  public void freeState() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  //===----------------------------------------------------------------------===//
  // GVMaterializer implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::releaseBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5668,
   FQN="(anonymous namespace)::BitcodeReader::releaseBuffer", NM="_ZN12_GLOBAL__N_113BitcodeReader13releaseBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader13releaseBufferEv")
  //</editor-fold>
  public void releaseBuffer() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::materialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5670,
   FQN="(anonymous namespace)::BitcodeReader::materialize", NM="_ZN12_GLOBAL__N_113BitcodeReader11materializeEPN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader11materializeEPN4llvm11GlobalValueE")
  //</editor-fold>
  @Override public std.error_code materialize(GlobalValue /*P*/ GV)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::materializeModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5725,
   FQN="(anonymous namespace)::BitcodeReader::materializeModule", NM="_ZN12_GLOBAL__N_113BitcodeReader17materializeModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader17materializeModuleEv")
  //</editor-fold>
  @Override public std.error_code materializeModule()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getIdentifiedStructTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5782,
   FQN="(anonymous namespace)::BitcodeReader::getIdentifiedStructTypes", NM="_ZNK12_GLOBAL__N_113BitcodeReader24getIdentifiedStructTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_113BitcodeReader24getIdentifiedStructTypesEv")
  //</editor-fold>
  @Override public std.vector<StructType /*P*/ > getIdentifiedStructTypes() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Main interface to parsing a bitcode buffer.
  /// \returns true if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseBitcodeInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4041,
   FQN="(anonymous namespace)::BitcodeReader::parseBitcodeInto", NM="_ZN12_GLOBAL__N_113BitcodeReader16parseBitcodeIntoESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EEPNS2_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader16parseBitcodeIntoESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EEPNS2_6ModuleEb")
  //</editor-fold>
  public std.error_code parseBitcodeInto(std.unique_ptr<DataStreamer> Streamer, 
                  Module /*P*/ M) {
    return parseBitcodeInto(Streamer, 
                  M, false);
  }
  public std.error_code parseBitcodeInto(std.unique_ptr<DataStreamer> Streamer, 
                  Module /*P*/ M, boolean ShouldLazyLoadMetadata/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Cheap mechanism to just extract module triple
  /// \returns true if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseTriple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4118,
   FQN="(anonymous namespace)::BitcodeReader::parseTriple", NM="_ZN12_GLOBAL__N_113BitcodeReader11parseTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader11parseTripleEv")
  //</editor-fold>
  public ErrorOr<std.string> parseTriple() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Cheap mechanism to just extract the identification block out of bitcode.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseIdentificationBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4153,
   FQN="(anonymous namespace)::BitcodeReader::parseIdentificationBlock", NM="_ZN12_GLOBAL__N_113BitcodeReader24parseIdentificationBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader24parseIdentificationBlockEv")
  //</editor-fold>
  public ErrorOr<std.string> parseIdentificationBlock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Peak at the module content and return true if any ObjC category or class
  /// is found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::hasObjCCategory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4203,
   FQN="(anonymous namespace)::BitcodeReader::hasObjCCategory", NM="_ZN12_GLOBAL__N_113BitcodeReader15hasObjCCategoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader15hasObjCCategoryEv")
  //</editor-fold>
  public ErrorOrBool hasObjCCategory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Decode a signed value stored with the sign bit in the LSB for dense VBR
  /// encoding.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::decodeSignRotatedValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2762,
   FQN="(anonymous namespace)::BitcodeReader::decodeSignRotatedValue", NM="_ZN12_GLOBAL__N_113BitcodeReader22decodeSignRotatedValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader22decodeSignRotatedValueEy")
  //</editor-fold>
  public static long/*uint64_t*/ decodeSignRotatedValue(long/*uint64_t*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Materialize any deferred Metadata block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::materializeMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3406,
   FQN="(anonymous namespace)::BitcodeReader::materializeMetadata", NM="_ZN12_GLOBAL__N_113BitcodeReader19materializeMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader19materializeMetadataEv")
  //</editor-fold>
  @Override public std.error_code materializeMetadata()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::setStripDebugInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3417,
   FQN="(anonymous namespace)::BitcodeReader::setStripDebugInfo", NM="_ZN12_GLOBAL__N_113BitcodeReader17setStripDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader17setStripDebugInfoEv")
  //</editor-fold>
  @Override public void setStripDebugInfo()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Parse the "IDENTIFICATION_BLOCK_ID" block, populate the
  // ProducerIdentification data member, and do some basic enforcement on the
  // "epoch" encoded in the bitcode.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseBitcodeVersion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3510,
   FQN="(anonymous namespace)::BitcodeReader::parseBitcodeVersion", NM="_ZN12_GLOBAL__N_113BitcodeReader19parseBitcodeVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader19parseBitcodeVersionEv")
  //</editor-fold>
  private std.error_code parseBitcodeVersion() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private std.vector<StructType /*P*/ > IdentifiedStructTypes;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::createIdentifiedStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1272,
   FQN="(anonymous namespace)::BitcodeReader::createIdentifiedStructType", NM="_ZN12_GLOBAL__N_113BitcodeReader26createIdentifiedStructTypeERN4llvm11LLVMContextENS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader26createIdentifiedStructTypeERN4llvm11LLVMContextENS1_9StringRefE")
  //</editor-fold>
  private StructType /*P*/ createIdentifiedStructType(LLVMContext /*&*/ Context, 
                            StringRef Name) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::createIdentifiedStructType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1279,
   FQN="(anonymous namespace)::BitcodeReader::createIdentifiedStructType", NM="_ZN12_GLOBAL__N_113BitcodeReader26createIdentifiedStructTypeERN4llvm11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader26createIdentifiedStructTypeERN4llvm11LLVMContextE")
  //</editor-fold>
  private StructType /*P*/ createIdentifiedStructType(LLVMContext /*&*/ Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getTypeByID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1259,
   FQN="(anonymous namespace)::BitcodeReader::getTypeByID", NM="_ZN12_GLOBAL__N_113BitcodeReader11getTypeByIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader11getTypeByIDEj")
  //</editor-fold>
  private Type /*P*/ getTypeByID(/*uint*/int ID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getFnValueByID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 338,
   FQN="(anonymous namespace)::BitcodeReader::getFnValueByID", NM="_ZN12_GLOBAL__N_113BitcodeReader14getFnValueByIDEjPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader14getFnValueByIDEjPN4llvm4TypeE")
  //</editor-fold>
  private Value /*P*/ getFnValueByID(/*uint*/int ID, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getFnMetadataByID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 343,
   FQN="(anonymous namespace)::BitcodeReader::getFnMetadataByID", NM="_ZN12_GLOBAL__N_113BitcodeReader17getFnMetadataByIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader17getFnMetadataByIDEj")
  //</editor-fold>
  private Metadata /*P*/ getFnMetadataByID(/*uint*/int ID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getBasicBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 346,
   FQN="(anonymous namespace)::BitcodeReader::getBasicBlock", NM="_ZNK12_GLOBAL__N_113BitcodeReader13getBasicBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_113BitcodeReader13getBasicBlockEj")
  //</editor-fold>
  private BasicBlock /*P*/ getBasicBlock(/*uint*/int ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getAttributes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 350,
   FQN="(anonymous namespace)::BitcodeReader::getAttributes", NM="_ZNK12_GLOBAL__N_113BitcodeReader13getAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_113BitcodeReader13getAttributesEj")
  //</editor-fold>
  private AttributeSet getAttributes(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Read a value/type pair out of the specified record from slot 'Slot'.
  /// Increment Slot past the number of slots used in the record. Return true on
  /// failure.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getValueTypePair">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 359,
   FQN="(anonymous namespace)::BitcodeReader::getValueTypePair", NM="_ZN12_GLOBAL__N_113BitcodeReader16getValueTypePairERN4llvm15SmallVectorImplIyEERjjRPNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader16getValueTypePairERN4llvm15SmallVectorImplIyEERjjRPNS1_5ValueE")
  //</editor-fold>
  private boolean getValueTypePair(SmallVectorImplULong /*&*/ Record, uint$ref/*uint &*/ Slot, 
                  /*uint*/int InstNum, Value /*P*/ /*&*/ ResVal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Read a value out of the specified record from slot 'Slot'. Increment Slot
  /// past the number of slots used by the value in the record. Return true if
  /// there is an error.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::popValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 383,
   FQN="(anonymous namespace)::BitcodeReader::popValue", NM="_ZN12_GLOBAL__N_113BitcodeReader8popValueERN4llvm15SmallVectorImplIyEERjjPNS1_4TypeERPNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader8popValueERN4llvm15SmallVectorImplIyEERjjPNS1_4TypeERPNS1_5ValueE")
  //</editor-fold>
  private boolean popValue(SmallVectorImplULong /*&*/ Record, uint$ref/*uint &*/ Slot, 
          /*uint*/int InstNum, Type /*P*/ Ty, Value /*P*/ /*&*/ ResVal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Like popValue, but does not increment the Slot number.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 393,
   FQN="(anonymous namespace)::BitcodeReader::getValue", NM="_ZN12_GLOBAL__N_113BitcodeReader8getValueERN4llvm15SmallVectorImplIyEEjjPNS1_4TypeERPNS1_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader8getValueERN4llvm15SmallVectorImplIyEEjjPNS1_4TypeERPNS1_5ValueE")
  //</editor-fold>
  private boolean getValue(SmallVectorImplULong /*&*/ Record, /*uint*/int Slot, 
          /*uint*/int InstNum, Type /*P*/ Ty, Value /*P*/ /*&*/ ResVal) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Version of getValue that returns ResVal directly, or 0 if there is an
  /// error.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 401,
   FQN="(anonymous namespace)::BitcodeReader::getValue", NM="_ZN12_GLOBAL__N_113BitcodeReader8getValueERN4llvm15SmallVectorImplIyEEjjPNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader8getValueERN4llvm15SmallVectorImplIyEEjjPNS1_4TypeE")
  //</editor-fold>
  private Value /*P*/ getValue(SmallVectorImplULong /*&*/ Record, /*uint*/int Slot, 
          /*uint*/int InstNum, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Like getValue, but decodes signed VBRs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::getValueSigned">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 412,
   FQN="(anonymous namespace)::BitcodeReader::getValueSigned", NM="_ZN12_GLOBAL__N_113BitcodeReader14getValueSignedERN4llvm15SmallVectorImplIyEEjjPNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader14getValueSignedERN4llvm15SmallVectorImplIyEEjjPNS1_4TypeE")
  //</editor-fold>
  private Value /*P*/ getValueSigned(SmallVectorImplULong /*&*/ Record, /*uint*/int Slot, 
                /*uint*/int InstNum, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Converts alignment exponent (i.e. power of two (or zero)) to the
  /// corresponding alignment to use. If alignment is too large, returns
  /// a corresponding error code.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseAlignmentValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1479,
   FQN="(anonymous namespace)::BitcodeReader::parseAlignmentValue", NM="_ZN12_GLOBAL__N_113BitcodeReader19parseAlignmentValueEyRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader19parseAlignmentValueEyRj")
  //</editor-fold>
  private std.error_code parseAlignmentValue(long/*uint64_t*/ Exponent, 
                     uint$ref/*uint &*/ Alignment) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseAttrKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1489,
   FQN="(anonymous namespace)::BitcodeReader::parseAttrKind", NM="_ZN12_GLOBAL__N_113BitcodeReader13parseAttrKindEyPN4llvm9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader13parseAttrKindEyPN4llvm9Attribute8AttrKindE")
  //</editor-fold>
  private std.error_code parseAttrKind(long/*uint64_t*/ Code, 
               Attribute.AttrKind /*P*/ Kind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3553,
   FQN="(anonymous namespace)::BitcodeReader::parseModule", NM="_ZN12_GLOBAL__N_113BitcodeReader11parseModuleEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader11parseModuleEyb")
  //</editor-fold>
  private std.error_code parseModule(long/*uint64_t*/ ResumeBit) {
    return parseModule(ResumeBit, 
             false);
  }
  private std.error_code parseModule(long/*uint64_t*/ ResumeBit, 
             boolean ShouldLazyLoadMetadata/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseAttributeBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1309,
   FQN="(anonymous namespace)::BitcodeReader::parseAttributeBlock", NM="_ZN12_GLOBAL__N_113BitcodeReader19parseAttributeBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader19parseAttributeBlockEv")
  //</editor-fold>
  private std.error_code parseAttributeBlock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseAttributeGroupBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1498,
   FQN="(anonymous namespace)::BitcodeReader::parseAttributeGroupBlock", NM="_ZN12_GLOBAL__N_113BitcodeReader24parseAttributeGroupBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader24parseAttributeGroupBlockEv")
  //</editor-fold>
  private std.error_code parseAttributeGroupBlock() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseTypeTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1586,
   FQN="(anonymous namespace)::BitcodeReader::parseTypeTable", NM="_ZN12_GLOBAL__N_113BitcodeReader14parseTypeTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader14parseTypeTableEv")
  //</editor-fold>
  private std.error_code parseTypeTable() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseTypeTableBody">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1593,
   FQN="(anonymous namespace)::BitcodeReader::parseTypeTableBody", NM="_ZN12_GLOBAL__N_113BitcodeReader18parseTypeTableBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader18parseTypeTableBodyEv")
  //</editor-fold>
  private std.error_code parseTypeTableBody() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseOperandBundleTags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1829,
   FQN="(anonymous namespace)::BitcodeReader::parseOperandBundleTags", NM="_ZN12_GLOBAL__N_113BitcodeReader22parseOperandBundleTagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader22parseOperandBundleTagsEv")
  //</editor-fold>
  private std.error_code parseOperandBundleTags() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Associate a value with its name from the given index in the provided record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::recordValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1866,
   FQN="(anonymous namespace)::BitcodeReader::recordValue", NM="_ZN12_GLOBAL__N_113BitcodeReader11recordValueERN4llvm15SmallVectorImplIyEEjRNS1_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader11recordValueERN4llvm15SmallVectorImplIyEEjRNS1_6TripleE")
  //</editor-fold>
  private ErrorOr<Value /*P*/ > recordValue(SmallVectorImplULong /*&*/ Record, 
             /*uint*/int NameIndex, Triple /*&*/ TT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Parse the value symbol table at either the current parsing location or
  /// at the given bit offset if provided.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1915,
   FQN="(anonymous namespace)::BitcodeReader::parseValueSymbolTable", NM="_ZN12_GLOBAL__N_113BitcodeReader21parseValueSymbolTableEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader21parseValueSymbolTableEy")
  //</editor-fold>
  private std.error_code parseValueSymbolTable() {
    return parseValueSymbolTable(0);
  }
  private std.error_code parseValueSymbolTable(long/*uint64_t*/ Offset/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseConstants">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2866,
   FQN="(anonymous namespace)::BitcodeReader::parseConstants", NM="_ZN12_GLOBAL__N_113BitcodeReader14parseConstantsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader14parseConstantsEv")
  //</editor-fold>
  private std.error_code parseConstants() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Support for lazy parsing of function bodies. This is required if we
  /// either have an old bitcode file without a VST forward declaration record,
  /// or if we have an anonymous function being materialized, since anonymous
  /// functions do not have a name and are therefore not in the VST.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::rememberAndSkipFunctionBodies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3476,
   FQN="(anonymous namespace)::BitcodeReader::rememberAndSkipFunctionBodies", NM="_ZN12_GLOBAL__N_113BitcodeReader29rememberAndSkipFunctionBodiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader29rememberAndSkipFunctionBodiesEv")
  //</editor-fold>
  private std.error_code rememberAndSkipFunctionBodies() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// When we see the block for a function body, remember where it is and then
  /// skip it.  This lets us lazily deserialize the functions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::rememberAndSkipFunctionBody">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3421,
   FQN="(anonymous namespace)::BitcodeReader::rememberAndSkipFunctionBody", NM="_ZN12_GLOBAL__N_113BitcodeReader27rememberAndSkipFunctionBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader27rememberAndSkipFunctionBodyEv")
  //</editor-fold>
  private std.error_code rememberAndSkipFunctionBody() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Save the positions of the Metadata blocks and skip parsing the blocks.
  
  /// When we see the block for metadata, remember where it is and then skip it.
  /// This lets us lazily deserialize the metadata.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::rememberAndSkipMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3395,
   FQN="(anonymous namespace)::BitcodeReader::rememberAndSkipMetadata", NM="_ZN12_GLOBAL__N_113BitcodeReader23rememberAndSkipMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader23rememberAndSkipMetadataEv")
  //</editor-fold>
  private std.error_code rememberAndSkipMetadata() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Lazily parse the specified function body block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseFunctionBody">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4361,
   FQN="(anonymous namespace)::BitcodeReader::parseFunctionBody", NM="_ZN12_GLOBAL__N_113BitcodeReader17parseFunctionBodyEPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader17parseFunctionBodyEPN4llvm8FunctionE")
  //</editor-fold>
  private std.error_code parseFunctionBody(Function /*P*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::globalCleanup">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3442,
   FQN="(anonymous namespace)::BitcodeReader::globalCleanup", NM="_ZN12_GLOBAL__N_113BitcodeReader13globalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader13globalCleanupEv")
  //</editor-fold>
  private std.error_code globalCleanup() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Resolve all of the initializers for global values and aliases that we can.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::resolveGlobalAndIndirectSymbolInits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2772,
   FQN="(anonymous namespace)::BitcodeReader::resolveGlobalAndIndirectSymbolInits", NM="_ZN12_GLOBAL__N_113BitcodeReader35resolveGlobalAndIndirectSymbolInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader35resolveGlobalAndIndirectSymbolInitsEv")
  //</editor-fold>
  private std.error_code resolveGlobalAndIndirectSymbolInits() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Parse a METADATA_BLOCK. If ModuleLevel is true then we are parsing
  /// module level metadata.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2103,
   FQN="(anonymous namespace)::BitcodeReader::parseMetadata", NM="_ZN12_GLOBAL__N_113BitcodeReader13parseMetadataEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader13parseMetadataEb")
  //</editor-fold>
  private std.error_code parseMetadata() {
    return parseMetadata(false);
  }
  private std.error_code parseMetadata(boolean ModuleLevel/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseMetadataStrings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2035,
   FQN="(anonymous namespace)::BitcodeReader::parseMetadataStrings", NM="_ZN12_GLOBAL__N_113BitcodeReader20parseMetadataStringsEN4llvm8ArrayRefIyEENS1_9StringRefERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader20parseMetadataStringsEN4llvm8ArrayRefIyEENS1_9StringRefERj")
  //</editor-fold>
  private std.error_code parseMetadataStrings(ArrayRefUInt Record, 
                      StringRef Blob, 
                      uint$ref/*uint &*/ NextMetadataNo) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Parse the metadata kinds out of the METADATA_KIND_BLOCK.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseMetadataKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2724,
   FQN="(anonymous namespace)::BitcodeReader::parseMetadataKinds", NM="_ZN12_GLOBAL__N_113BitcodeReader18parseMetadataKindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader18parseMetadataKindsEv")
  //</editor-fold>
  private std.error_code parseMetadataKinds() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Parse a single METADATA_KIND record, inserting result in MDKindMap.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseMetadataKindRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2019,
   FQN="(anonymous namespace)::BitcodeReader::parseMetadataKindRecord", NM="_ZN12_GLOBAL__N_113BitcodeReader23parseMetadataKindRecordERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader23parseMetadataKindRecordERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  private std.error_code parseMetadataKindRecord(SmallVectorImplULong /*&*/ Record) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseGlobalObjectAttachment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4188,
   FQN="(anonymous namespace)::BitcodeReader::parseGlobalObjectAttachment", NM="_ZN12_GLOBAL__N_113BitcodeReader27parseGlobalObjectAttachmentERN4llvm12GlobalObjectENS1_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader27parseGlobalObjectAttachmentERN4llvm12GlobalObjectENS1_8ArrayRefIyEE")
  //</editor-fold>
  private std.error_code parseGlobalObjectAttachment(GlobalObject /*&*/ GO, ArrayRefUInt Record) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Parse metadata attachments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseMetadataAttachment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4279,
   FQN="(anonymous namespace)::BitcodeReader::parseMetadataAttachment", NM="_ZN12_GLOBAL__N_113BitcodeReader23parseMetadataAttachmentERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader23parseMetadataAttachmentERN4llvm8FunctionE")
  //</editor-fold>
  private std.error_code parseMetadataAttachment(Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseModuleTriple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4080,
   FQN="(anonymous namespace)::BitcodeReader::parseModuleTriple", NM="_ZN12_GLOBAL__N_113BitcodeReader17parseModuleTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader17parseModuleTripleEv")
  //</editor-fold>
  private ErrorOr<std.string> parseModuleTriple() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::hasObjCCategoryInModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 4238,
   FQN="(anonymous namespace)::BitcodeReader::hasObjCCategoryInModule", NM="_ZN12_GLOBAL__N_113BitcodeReader23hasObjCCategoryInModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader23hasObjCCategoryInModuleEv")
  //</editor-fold>
  private ErrorOrBool hasObjCCategoryInModule() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::parseUseLists">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 3329,
   FQN="(anonymous namespace)::BitcodeReader::parseUseLists", NM="_ZN12_GLOBAL__N_113BitcodeReader13parseUseListsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader13parseUseListsEv")
  //</editor-fold>
  private std.error_code parseUseLists() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::initStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5786,
   FQN="(anonymous namespace)::BitcodeReader::initStream", NM="_ZN12_GLOBAL__N_113BitcodeReader10initStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader10initStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE")
  //</editor-fold>
  private std.error_code initStream(std.unique_ptr<DataStreamer> Streamer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::initStreamFromBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5793,
   FQN="(anonymous namespace)::BitcodeReader::initStreamFromBuffer", NM="_ZN12_GLOBAL__N_113BitcodeReader20initStreamFromBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader20initStreamFromBufferEv")
  //</editor-fold>
  private std.error_code initStreamFromBuffer() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::initLazyStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5812,
   FQN="(anonymous namespace)::BitcodeReader::initLazyStream", NM="_ZN12_GLOBAL__N_113BitcodeReader14initLazyStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader14initLazyStreamESt10unique_ptrIN4llvm12DataStreamerESt14default_deleteIS3_EE")
  //</editor-fold>
  private std.error_code initLazyStream(std.unique_ptr<DataStreamer> Streamer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Find the function body in the bitcode stream
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReader::findFunctionInStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 5647,
   FQN="(anonymous namespace)::BitcodeReader::findFunctionInStream", NM="_ZN12_GLOBAL__N_113BitcodeReader20findFunctionInStreamEPN4llvm8FunctionENS1_16DenseMapIteratorIS3_yNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_yEELb0EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_113BitcodeReader20findFunctionInStreamEPN4llvm8FunctionENS1_16DenseMapIteratorIS3_yNS1_12DenseMapInfoIS3_EENS1_6detail12DenseMapPairIS3_yEELb0EEE")
  //</editor-fold>
  private std.error_code findFunctionInStream(Function /*P*/ F, 
                      DenseMapIteratorTypeULong<Function /*P*/> DeferredFunctionInfoIterator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Context=" + Context // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", Buffer=" + Buffer // NOI18N
              + ", StreamFile=" + StreamFile // NOI18N
              + ", Stream=" + Stream // NOI18N
              + ", NextUnreadBit=" + NextUnreadBit // NOI18N
              + ", LastFunctionBlockBit=" + LastFunctionBlockBit // NOI18N
              + ", SeenValueSymbolTable=" + SeenValueSymbolTable // NOI18N
              + ", VSTOffset=" + VSTOffset // NOI18N
              + ", ProducerIdentification=" + ProducerIdentification // NOI18N
              + ", TypeList=" + TypeList // NOI18N
              + ", ValueList=" + ValueList // NOI18N
              + ", MetadataList=" + MetadataList // NOI18N
              + ", ComdatList=" + ComdatList // NOI18N
              + ", InstructionList=" + InstructionList // NOI18N
              + ", GlobalInits=" + GlobalInits // NOI18N
              + ", IndirectSymbolInits=" + IndirectSymbolInits // NOI18N
              + ", FunctionPrefixes=" + FunctionPrefixes // NOI18N
              + ", FunctionPrologues=" + FunctionPrologues // NOI18N
              + ", FunctionPersonalityFns=" + FunctionPersonalityFns // NOI18N
              + ", InstsWithTBAATag=" + InstsWithTBAATag // NOI18N
              + ", HasSeenOldLoopTags=" + HasSeenOldLoopTags // NOI18N
              + ", MAttributes=" + MAttributes // NOI18N
              + ", MAttributeGroups=" + MAttributeGroups // NOI18N
              + ", FunctionBBs=" + FunctionBBs // NOI18N
              + ", FunctionsWithBodies=" + FunctionsWithBodies // NOI18N
              + ", UpgradedIntrinsics=" + UpgradedIntrinsics // NOI18N
              + ", RemangledIntrinsics=" + RemangledIntrinsics // NOI18N
              + ", MDKindMap=" + MDKindMap // NOI18N
              + ", SeenFirstFunctionBody=" + SeenFirstFunctionBody // NOI18N
              + ", DeferredFunctionInfo=" + DeferredFunctionInfo // NOI18N
              + ", DeferredMetadataInfo=" + DeferredMetadataInfo // NOI18N
              + ", BasicBlockFwdRefs=" + BasicBlockFwdRefs // NOI18N
              + ", BasicBlockFwdRefQueue=" + BasicBlockFwdRefQueue // NOI18N
              + ", UseRelativeIDs=" + UseRelativeIDs // NOI18N
              + ", WillMaterializeAllForwardRefs=" + WillMaterializeAllForwardRefs // NOI18N
              + ", IsMetadataMaterialized=" + IsMetadataMaterialized // NOI18N
              + ", StripDebugInfo=" + StripDebugInfo // NOI18N
              + ", FunctionsWithSPs=" + FunctionsWithSPs // NOI18N
              + ", BundleTags=" + BundleTags // NOI18N
              + ", IdentifiedStructTypes=" + IdentifiedStructTypes // NOI18N
              + super.toString(); // NOI18N
  }
}
