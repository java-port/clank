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

package org.llvm.profiledata;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.ProfileSummary;
import org.llvm.profiledata.IndexedInstrProf.ProfVersion;
import org.llvm.support.Error;
import org.llvm.support.llvm.support.endianness;


/// Reader for the indexed binary instrprof format.
//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 360,
 FQN="llvm::IndexedInstrProfReader", NM="_ZN4llvm22IndexedInstrProfReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReaderE")
//</editor-fold>
public class IndexedInstrProfReader extends /*public*/ InstrProfReader implements Destructors.ClassWithDestructor {
/*private:*/
  /// The profile data file contents.
  private std.unique_ptr<MemoryBuffer> DataBuffer;
  /// The index into the profile data.
  private std.unique_ptr<InstrProfReaderIndexBase> Index;
  /// Profile summary data.
  private std.unique_ptr<ProfileSummary> Summary;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::IndexedInstrProfReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 369,
   FQN="llvm::IndexedInstrProfReader::IndexedInstrProfReader", NM="_ZN4llvm22IndexedInstrProfReaderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReaderC1ERKS0_")
  //</editor-fold>
  protected/*private*/ IndexedInstrProfReader(final /*const*/ IndexedInstrProfReader /*&*/ $Prm0) {  throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 370,
   FQN="llvm::IndexedInstrProfReader::operator=", NM="_ZN4llvm22IndexedInstrProfReaderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReaderaSERKS0_")
  //</editor-fold>
  protected/*private*/ IndexedInstrProfReader /*&*/ $assign(final /*const*/ IndexedInstrProfReader /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  // Read the profile summary. Return a pointer pointing to one byte past the
  // end of the summary data if it exists or the input \c Cur.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::readSummary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 576,
   FQN="llvm::IndexedInstrProfReader::readSummary", NM="_ZN4llvm22IndexedInstrProfReader11readSummaryENS_16IndexedInstrProf11ProfVersionEPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader11readSummaryENS_16IndexedInstrProf11ProfVersionEPKh")
  //</editor-fold>
  private /*const*/char$ptr/*uchar P*/ readSummary(ProfVersion Version, 
             /*const*/char$ptr/*uchar P*/ Cur) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// Return the profile version.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::getVersion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 379,
   FQN="llvm::IndexedInstrProfReader::getVersion", NM="_ZNK4llvm22IndexedInstrProfReader10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZNK4llvm22IndexedInstrProfReader10getVersionEv")
  //</editor-fold>
  public long/*uint64_t*/ getVersion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::isIRLevelProfile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 380,
   FQN="llvm::IndexedInstrProfReader::isIRLevelProfile", NM="_ZNK4llvm22IndexedInstrProfReader16isIRLevelProfileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZNK4llvm22IndexedInstrProfReader16isIRLevelProfileEv")
  //</editor-fold>
  @Override public boolean isIRLevelProfile() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::IndexedInstrProfReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 381,
   FQN="llvm::IndexedInstrProfReader::IndexedInstrProfReader", NM="_ZN4llvm22IndexedInstrProfReaderC1ESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReaderC1ESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EE")
  //</editor-fold>
  public IndexedInstrProfReader(std.unique_ptr<MemoryBuffer> DataBuffer) {
    // : InstrProfReader(), DataBuffer(std::move(DataBuffer)), Index(null), Summary() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the given buffer is in an indexed instrprof format.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::hasFormat">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 566,
   FQN="llvm::IndexedInstrProfReader::hasFormat", NM="_ZN4llvm22IndexedInstrProfReader9hasFormatERKNS_12MemoryBufferE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader9hasFormatERKNS_12MemoryBufferE")
  //</editor-fold>
  public static boolean hasFormat(final /*const*/ MemoryBuffer /*&*/ DataBuffer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Read the file header.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::readHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 625,
   FQN="llvm::IndexedInstrProfReader::readHeader", NM="_ZN4llvm22IndexedInstrProfReader10readHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader10readHeaderEv")
  //</editor-fold>
  @Override public Error readHeader()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Read a single record.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::readNextRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 705,
   FQN="llvm::IndexedInstrProfReader::readNextRecord", NM="_ZN4llvm22IndexedInstrProfReader14readNextRecordERNS_15InstrProfRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader14readNextRecordERNS_15InstrProfRecordE")
  //</editor-fold>
  @Override public Error readNextRecord(final InstrProfRecord /*&*/ Record)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the pointer to InstrProfRecord associated with FuncName
  /// and FuncHash
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::getInstrProfRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 677,
   FQN="llvm::IndexedInstrProfReader::getInstrProfRecord", NM="_ZN4llvm22IndexedInstrProfReader18getInstrProfRecordENS_9StringRefEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader18getInstrProfRecordENS_9StringRefEy")
  //</editor-fold>
  public Expected<InstrProfRecord> getInstrProfRecord(StringRef FuncName, 
                    long/*uint64_t*/ FuncHash) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Fill Counts with the profile data for the given function name.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::getFunctionCounts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 694,
   FQN="llvm::IndexedInstrProfReader::getFunctionCounts", NM="_ZN4llvm22IndexedInstrProfReader17getFunctionCountsENS_9StringRefEyRSt6vectorIySaIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader17getFunctionCountsENS_9StringRefEyRSt6vectorIySaIyEE")
  //</editor-fold>
  public Error getFunctionCounts(StringRef FuncName, 
                   long/*uint64_t*/ FuncHash, 
                   final std.vectorULong/*&*/ Counts) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the maximum of all known function counts.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::getMaximumFunctionCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 402,
   FQN="llvm::IndexedInstrProfReader::getMaximumFunctionCount", NM="_ZN4llvm22IndexedInstrProfReader23getMaximumFunctionCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader23getMaximumFunctionCountEv")
  //</editor-fold>
  public long/*uint64_t*/ getMaximumFunctionCount() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Factory method to create an indexed reader.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 69,
   FQN="llvm::IndexedInstrProfReader::create", NM="_ZN4llvm22IndexedInstrProfReader6createERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader6createERKNS_5TwineE")
  //</editor-fold>
  public static Expected<std.unique_ptr<IndexedInstrProfReader> > create_IndexedInstrProfReader(final /*const*/ Twine /*&*/ Path) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 79,
   FQN="llvm::IndexedInstrProfReader::create", NM="_ZN4llvm22IndexedInstrProfReader6createESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader6createESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EE")
  //</editor-fold>
  public static Expected<std.unique_ptr<IndexedInstrProfReader> > create_IndexedInstrProfReader(std.unique_ptr<MemoryBuffer> Buffer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Used for testing purpose only.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::setValueProfDataEndianness">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 412,
   FQN="llvm::IndexedInstrProfReader::setValueProfDataEndianness", NM="_ZN4llvm22IndexedInstrProfReader26setValueProfDataEndiannessENS_7support10endiannessE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader26setValueProfDataEndiannessENS_7support10endiannessE")
  //</editor-fold>
  public void setValueProfDataEndianness(endianness Endianness) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // See description in the base class. This interface is designed
  // to be used by llvm-profdata (for dumping). Avoid using this when
  // the client is the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::getSymtab">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 666,
   FQN="llvm::IndexedInstrProfReader::getSymtab", NM="_ZN4llvm22IndexedInstrProfReader9getSymtabEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader9getSymtabEv")
  //</editor-fold>
  @Override public InstrProfSymtab /*&*/ getSymtab()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::getSummary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 420,
   FQN="llvm::IndexedInstrProfReader::getSummary", NM="_ZN4llvm22IndexedInstrProfReader10getSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReader10getSummaryEv")
  //</editor-fold>
  public ProfileSummary /*&*/ getSummary() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProfReader::~IndexedInstrProfReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 360,
   FQN="llvm::IndexedInstrProfReader::~IndexedInstrProfReader", NM="_ZN4llvm22IndexedInstrProfReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm22IndexedInstrProfReaderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DataBuffer=" + DataBuffer // NOI18N
              + ", Index=" + Index // NOI18N
              + ", Summary=" + Summary // NOI18N
              + super.toString(); // NOI18N
  }
}
