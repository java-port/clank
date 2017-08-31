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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;


/// Base class and interface for reading profiling data of any known instrprof
/// format. Provides an iterator over InstrProfRecords.
//<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 52,
 FQN="llvm::InstrProfReader", NM="_ZN4llvm15InstrProfReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReaderE")
//</editor-fold>
public abstract class InstrProfReader implements Destructors.ClassWithDestructor {
  private instrprof_error LastError;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::InstrProfReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 56,
   FQN="llvm::InstrProfReader::InstrProfReader", NM="_ZN4llvm15InstrProfReaderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReaderC1Ev")
  //</editor-fold>
  public InstrProfReader() {
    // : LastError(instrprof_error::success), Symtab() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::~InstrProfReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 57,
   FQN="llvm::InstrProfReader::~InstrProfReader", NM="_ZN4llvm15InstrProfReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReaderD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Read the header.  Required before reading first record.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::readHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 60,
   FQN="llvm::InstrProfReader::readHeader", NM="_ZN4llvm15InstrProfReader10readHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader10readHeaderEv")
  //</editor-fold>
  public abstract /*virtual*/ Error readHeader()/* = 0*/;

  /// Read a single record.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::readNextRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 62,
   FQN="llvm::InstrProfReader::readNextRecord", NM="_ZN4llvm15InstrProfReader14readNextRecordERNS_15InstrProfRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader14readNextRecordERNS_15InstrProfRecordE")
  //</editor-fold>
  public abstract /*virtual*/ Error readNextRecord(final InstrProfRecord /*&*/ Record)/* = 0*/;

  /// Iterator over profile data.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 64,
   FQN="llvm::InstrProfReader::begin", NM="_ZN4llvm15InstrProfReader5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader5beginEv")
  //</editor-fold>
  public InstrProfIterator begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 65,
   FQN="llvm::InstrProfReader::end", NM="_ZN4llvm15InstrProfReader3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader3endEv")
  //</editor-fold>
  public InstrProfIterator end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::isIRLevelProfile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 66,
   FQN="llvm::InstrProfReader::isIRLevelProfile", NM="_ZNK4llvm15InstrProfReader16isIRLevelProfileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZNK4llvm15InstrProfReader16isIRLevelProfileEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isIRLevelProfile() /*const*//* = 0*/;

  
  /// Return the PGO symtab. There are three different readers:
  /// Raw, Text, and Indexed profile readers. The first two types
  /// of readers are used only by llvm-profdata tool, while the indexed
  /// profile reader is also used by llvm-cov tool and the compiler (
  /// backend or frontend). Since creating PGO symtab can create
  /// significant runtime and memory overhead (as it touches data
  /// for the whole program), InstrProfSymtab for the indexed profile
  /// reader should be created on demand and it is recommended to be
  /// only used for dumping purpose with llvm-proftool, not with the
  /// compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::getSymtab">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 78,
   FQN="llvm::InstrProfReader::getSymtab", NM="_ZN4llvm15InstrProfReader9getSymtabEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader9getSymtabEv")
  //</editor-fold>
  public abstract /*virtual*/ InstrProfSymtab /*&*/ getSymtab()/* = 0*/;

/*protected:*/
  protected std.unique_ptr<InstrProfSymtab> Symtab;
  /// Set the current error and return same.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::error">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 83,
   FQN="llvm::InstrProfReader::error", NM="_ZN4llvm15InstrProfReader5errorENS_15instrprof_errorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader5errorENS_15instrprof_errorE")
  //</editor-fold>
  protected Error error(instrprof_error Err) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::error">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 89,
   FQN="llvm::InstrProfReader::error", NM="_ZN4llvm15InstrProfReader5errorENS_5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader5errorENS_5ErrorE")
  //</editor-fold>
  protected Error error(Error E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Clear the current error and return a successful one.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::success">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 92,
   FQN="llvm::InstrProfReader::success", NM="_ZN4llvm15InstrProfReader7successEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader7successEv")
  //</editor-fold>
  protected Error success() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// Return true if the reader has finished reading the profile data.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::isEOF">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 96,
   FQN="llvm::InstrProfReader::isEOF", NM="_ZN4llvm15InstrProfReader5isEOFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader5isEOFEv")
  //</editor-fold>
  public boolean isEOF() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return true if the reader encountered an error reading profiling data.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::hasError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 98,
   FQN="llvm::InstrProfReader::hasError", NM="_ZN4llvm15InstrProfReader8hasErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader8hasErrorEv")
  //</editor-fold>
  public boolean hasError() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Get the current error.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::getError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 100,
   FQN="llvm::InstrProfReader::getError", NM="_ZN4llvm15InstrProfReader8getErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader8getErrorEv")
  //</editor-fold>
  public Error getError() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Factory method to create an appropriately typed reader for the given
  /// instrprof file.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 34,
   FQN="llvm::InstrProfReader::create", NM="_ZN4llvm15InstrProfReader6createERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader6createERKNS_5TwineE")
  //</editor-fold>
  public static Expected<std.unique_ptr<InstrProfReader> > create(final /*const*/ Twine /*&*/ Path) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReader::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp", line = 43,
   FQN="llvm::InstrProfReader::create", NM="_ZN4llvm15InstrProfReader6createESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfReader6createESt10unique_ptrINS_12MemoryBufferESt14default_deleteIS2_EE")
  //</editor-fold>
  public static Expected<std.unique_ptr<InstrProfReader> > create(std.unique_ptr<MemoryBuffer> Buffer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LastError=" + LastError // NOI18N
              + ", Symtab=" + Symtab; // NOI18N
  }
}
