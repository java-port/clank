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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import org.llvm.adt.iterator_facade_base;
import org.llvm.ir.*;


/// Class to manage the bitcode writing for a combined index.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 309,
 FQN="(anonymous namespace)::IndexBitcodeWriter", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriterE")
//</editor-fold>
public class IndexBitcodeWriter extends /*public*/ BitcodeWriter implements Destructors.ClassWithDestructor {
  /// The combined index to write to bitcode.
  private final /*const*/ ModuleSummaryIndex /*&*/ Index;
  
  /// When writing a subset of the index for distributed backends, client
  /// provides a map of modules to the corresponding GUIDs/summaries to write.
  private std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/ ModuleToSummariesForIndex;
  
  /// Map that holds the correspondence between the GUID used in the combined
  /// index and a value id generated by this class to use in references.
  private std.mapULongUInt GUIDToValueIdMap;
  
  /// Tracks the last value id recorded in the GUIDToValueMap.
  private /*uint*/int GlobalValueId/* = 0*/;
/*public:*/
  /// Constructs a IndexBitcodeWriter object for the given combined index,
  /// writing to the provided \p Buffer. When writing a subset of the index
  /// for a distributed backend, provide a \p ModuleToSummariesForIndex map.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::IndexBitcodeWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 328,
   FQN="(anonymous namespace)::IndexBitcodeWriter::IndexBitcodeWriter", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriterC1ERN4llvm15SmallVectorImplIcEERKNS1_18ModuleSummaryIndexEPSt3mapISsS8_IyPNS1_18GlobalValueSummaryESt4lessIyESaISt4pairIKySA_EEESB_ISsESaISD_IKSsSH_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriterC1ERN4llvm15SmallVectorImplIcEERKNS1_18ModuleSummaryIndexEPSt3mapISsS8_IyPNS1_18GlobalValueSummaryESt4lessIyESaISt4pairIKySA_EEESB_ISsESaISD_IKSsSH_EEE")
  //</editor-fold>
  public IndexBitcodeWriter(final SmallString/*&*/ Buffer, 
      final /*const*/ ModuleSummaryIndex /*&*/ Index) {
    this(Buffer, 
      Index, 
      (std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/)null);
  }
  public IndexBitcodeWriter(final SmallString/*&*/ Buffer, 
      final /*const*/ ModuleSummaryIndex /*&*/ Index, 
      std.mapTypeType<std.string, std.mapULongPtr<GlobalValueSummary /*P*/ /*P*/>> /*P*/ ModuleToSummariesForIndex/*= null*/) {
    // : BitcodeWriter(Buffer), Index(Index), ModuleToSummariesForIndex(ModuleToSummariesForIndex), GUIDToValueIdMap(), GlobalValueId(0) 
    super(Buffer);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// The below iterator returns the GUID and associated summary.
  // JAVA: typedef std::pair<GlobalValue::GUID, GlobalValueSummary *> GVInfo
//  public final class GVInfo extends std.pairULongPtr<GlobalValueSummary /*P*/ >{ };
  
  /// Iterator over the value GUID and summaries to be written to bitcode,
  /// hides the details of whether they are being pulled from the entire
  /// index or just those in a provided ModuleToSummariesForIndex map.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::iterator">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 348,
   FQN="(anonymous namespace)::IndexBitcodeWriter::iterator", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorE")
  //</editor-fold>
  public static class iterator extends /*public*/ iterator_facade_base<iterator, std.forward_iterator_tag, std.pairULongPtr<GlobalValueSummary /*P*/ >, std.pairULongPtr<GlobalValueSummary /*P*/ > > implements Native.NativeComparable {
    /// Enables access to parent class.
    private final /*const*/ IndexBitcodeWriter /*&*/ Writer;
    
    // Iterators used when writing only those summaries in a provided
    // ModuleToSummariesForIndex map:
    
    /// Points to the last element in outer ModuleToSummariesForIndex map.
    private std.mapTypeType.iterator</*const*/std.string, std.mapULongPtr<GlobalValueSummary /*P*/>> ModuleSummariesBack;
    /// Iterator on outer ModuleToSummariesForIndex map.
    private std.mapTypeType.iterator</*const*/std.string, std.mapULongPtr<GlobalValueSummary /*P*/>> ModuleSummariesIter;
    /// Iterator on an inner global variable summary map.
    private std.mapULongPtr.iterator<GlobalValueSummary /*P*/> ModuleGVSummariesIter;
    
    // Iterators used when writing all summaries in the index:
    
    /// Points to the last element in the Index outer GlobalValueMap.
    private std.mapULLongType<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> IndexSummariesBack;
    /// Iterator on outer GlobalValueMap.
    private std.mapULLongType<std.vector<unique_ptr<GlobalValueSummary>/*,default_cls_allocator*/>> IndexSummariesIter;
    /// Iterator on an inner GlobalValueSummaryList.
    private std.vector.iterator</*const*/unique_ptr<GlobalValueSummary> /*P*/> IndexGVSummariesIter;
  /*public:*/
    /// Construct iterator from parent \p Writer and indicate if we are
    /// constructing the end iterator.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 376,
     FQN="(anonymous namespace)::IndexBitcodeWriter::iterator::iterator", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorC1ERKS0_b",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorC1ERKS0_b")
    //</editor-fold>
    public iterator(final /*const*/ IndexBitcodeWriter /*&*/ Writer, boolean IsAtEnd) {
      // : iterator_facade_base<iterator, std::forward_iterator_tag, GVInfo>(), Writer(Writer), ModuleSummariesBack(), ModuleSummariesIter(), ModuleGVSummariesIter(), IndexSummariesBack(), IndexSummariesIter(), IndexGVSummariesIter() 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Increment the appropriate set of iterators.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 407,
     FQN="(anonymous namespace)::IndexBitcodeWriter::iterator::operator++", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Access the <GUID,GlobalValueSummary*> pair corresponding to the current
    /// outer and inner iterator positions.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 431,
     FQN="(anonymous namespace)::IndexBitcodeWriter::iterator::operator*", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratordeEv")
    //</editor-fold>
    public std.pairULongPtr<GlobalValueSummary /*P*/ > $star() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Checks if the iterators are equal, with special handling for empty
    /// indexes.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 441,
     FQN="(anonymous namespace)::IndexBitcodeWriter::iterator::operator==", NM="_ZNK12_GLOBAL__N_118IndexBitcodeWriter8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK12_GLOBAL__N_118IndexBitcodeWriter8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ RHS) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 348,
     FQN="(anonymous namespace)::IndexBitcodeWriter::iterator::iterator", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : iterator_facade_base<iterator, std::forward_iterator_tag, GVInfo>(static_cast<iterator &&>()), Writer(static_cast<iterator &&>().Writer), ModuleSummariesBack(static_cast<iterator &&>().ModuleSummariesBack), ModuleSummariesIter(static_cast<iterator &&>().ModuleSummariesIter), ModuleGVSummariesIter(static_cast<iterator &&>().ModuleGVSummariesIter), IndexSummariesBack(static_cast<iterator &&>().IndexSummariesBack), IndexSummariesIter(static_cast<iterator &&>().IndexSummariesIter), IndexGVSummariesIter(static_cast<iterator &&>().IndexGVSummariesIter) 
      super(JD$Move.INSTANCE, $Prm0);
      throw new UnsupportedOperationException("EmptyBody");
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    protected /*inline*/ iterator(iterator /*&&*/$Prm0) {
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }
    
    @Override public boolean $eq(Object RHS) { return this.$eq((iterator)RHS); }
    @Override public iterator clone() { return new iterator(this); }
    
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Writer=" + Writer // NOI18N
                + ", ModuleSummariesBack=" + ModuleSummariesBack // NOI18N
                + ", ModuleSummariesIter=" + ModuleSummariesIter // NOI18N
                + ", ModuleGVSummariesIter=" + ModuleGVSummariesIter // NOI18N
                + ", IndexSummariesBack=" + IndexSummariesBack // NOI18N
                + ", IndexSummariesIter=" + IndexSummariesIter // NOI18N
                + ", IndexGVSummariesIter=" + IndexGVSummariesIter // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// Obtain the start iterator over the summaries to be written.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 475,
   FQN="(anonymous namespace)::IndexBitcodeWriter::begin", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter5beginEv")
  //</editor-fold>
  public iterator begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Obtain the end iterator over the summaries to be written.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 477,
   FQN="(anonymous namespace)::IndexBitcodeWriter::end", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter3endEv")
  //</editor-fold>
  public iterator end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Main entry point for writing a combined index to bitcode, invoked by
  /// BitcodeWriter::write() after it writes the header.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::writeBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3638,
   FQN="(anonymous namespace)::IndexBitcodeWriter::writeBlocks", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter11writeBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter11writeBlocksEv")
  //</editor-fold>
  @Override protected/*private*/ void writeBlocks()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::writeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3809,
   FQN="(anonymous namespace)::IndexBitcodeWriter::writeIndex", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter10writeIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter10writeIndexEv")
  //</editor-fold>
  private void writeIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Write the module path strings, currently only used when generating
  /// a combined index file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::writeModStrings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3184,
   FQN="(anonymous namespace)::IndexBitcodeWriter::writeModStrings", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter15writeModStringsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter15writeModStringsEv")
  //</editor-fold>
  private void writeModStrings() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit function names and summary offsets for the combined index
  /// used by ThinLTO.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::writeCombinedValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 2869,
   FQN="(anonymous namespace)::IndexBitcodeWriter::writeCombinedValueSymbolTable", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter29writeCombinedValueSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter29writeCombinedValueSymbolTableEv")
  //</editor-fold>
  private void writeCombinedValueSymbolTable() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit the combined summary section into the combined index file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::writeCombinedGlobalValueSummary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 3425,
   FQN="(anonymous namespace)::IndexBitcodeWriter::writeCombinedGlobalValueSummary", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter31writeCombinedGlobalValueSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter31writeCombinedGlobalValueSummaryEv")
  //</editor-fold>
  private void writeCombinedGlobalValueSummary() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Indicates whether the provided \p ModulePath should be written into
  /// the module string table, e.g. if full index written or if it is in
  /// the provided subset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::doIncludeModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 492,
   FQN="(anonymous namespace)::IndexBitcodeWriter::doIncludeModule", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter15doIncludeModuleEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter15doIncludeModuleEN4llvm9StringRefE")
  //</editor-fold>
  private boolean doIncludeModule(StringRef ModulePath) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::hasValueId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 497,
   FQN="(anonymous namespace)::IndexBitcodeWriter::hasValueId", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter10hasValueIdEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter10hasValueIdEy")
  //</editor-fold>
  private boolean hasValueId(long/*uint64_t*/ ValGUID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::getValueId">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 501,
   FQN="(anonymous namespace)::IndexBitcodeWriter::getValueId", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter10getValueIdEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter10getValueIdEy")
  //</editor-fold>
  private /*uint*/int getValueId(long/*uint64_t*/ ValGUID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::valueIds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 511,
   FQN="(anonymous namespace)::IndexBitcodeWriter::valueIds", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriter8valueIdsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriter8valueIdsEv")
  //</editor-fold>
  private std.mapULongUInt /*&*/ valueIds() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndexBitcodeWriter::~IndexBitcodeWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp", line = 309,
   FQN="(anonymous namespace)::IndexBitcodeWriter::~IndexBitcodeWriter", NM="_ZN12_GLOBAL__N_118IndexBitcodeWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN12_GLOBAL__N_118IndexBitcodeWriterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Index=" + Index // NOI18N
              + ", ModuleToSummariesForIndex=" + ModuleToSummariesForIndex // NOI18N
              + ", GUIDToValueIdMap=" + GUIDToValueIdMap // NOI18N
              + ", GlobalValueId=" + GlobalValueId // NOI18N
              + super.toString(); // NOI18N
  }
}
