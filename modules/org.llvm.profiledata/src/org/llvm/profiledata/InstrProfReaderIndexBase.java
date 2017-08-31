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

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.support.llvm.support.endianness;

//<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 306,
 FQN="llvm::InstrProfReaderIndexBase", NM="_ZN4llvm24InstrProfReaderIndexBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBaseE")
//</editor-fold>
public abstract class/*struct*/ InstrProfReaderIndexBase implements Destructors.ClassWithDestructor {
  // Read all the profile records with the same key pointed to the current
  // iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::getRecords">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 309,
   FQN="llvm::InstrProfReaderIndexBase::getRecords", NM="_ZN4llvm24InstrProfReaderIndexBase10getRecordsERNS_8ArrayRefINS_15InstrProfRecordEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBase10getRecordsERNS_8ArrayRefINS_15InstrProfRecordEEE")
  //</editor-fold>
  public abstract /*virtual*/ Error getRecords(final ArrayRef<InstrProfRecord> /*&*/ Data)/* = 0*/;

  // Read all the profile records with the key equal to FuncName
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::getRecords">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 311,
   FQN="llvm::InstrProfReaderIndexBase::getRecords", NM="_ZN4llvm24InstrProfReaderIndexBase10getRecordsENS_9StringRefERNS_8ArrayRefINS_15InstrProfRecordEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBase10getRecordsENS_9StringRefERNS_8ArrayRefINS_15InstrProfRecordEEE")
  //</editor-fold>
  public abstract /*virtual*/ Error getRecords(StringRef FuncName, 
            final ArrayRef<InstrProfRecord> /*&*/ Data)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::advanceToNextKey">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 313,
   FQN="llvm::InstrProfReaderIndexBase::advanceToNextKey", NM="_ZN4llvm24InstrProfReaderIndexBase16advanceToNextKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBase16advanceToNextKeyEv")
  //</editor-fold>
  public abstract /*virtual*/ void advanceToNextKey()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::atEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 314,
   FQN="llvm::InstrProfReaderIndexBase::atEnd", NM="_ZNK4llvm24InstrProfReaderIndexBase5atEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZNK4llvm24InstrProfReaderIndexBase5atEndEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean atEnd() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::setValueProfDataEndianness">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 315,
   FQN="llvm::InstrProfReaderIndexBase::setValueProfDataEndianness", NM="_ZN4llvm24InstrProfReaderIndexBase26setValueProfDataEndiannessENS_7support10endiannessE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBase26setValueProfDataEndiannessENS_7support10endiannessE")
  //</editor-fold>
  public abstract /*virtual*/ void setValueProfDataEndianness(endianness Endianness)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::~InstrProfReaderIndexBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 316,
   FQN="llvm::InstrProfReaderIndexBase::~InstrProfReaderIndexBase", NM="_ZN4llvm24InstrProfReaderIndexBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBaseD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::getVersion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 317,
   FQN="llvm::InstrProfReaderIndexBase::getVersion", NM="_ZNK4llvm24InstrProfReaderIndexBase10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZNK4llvm24InstrProfReaderIndexBase10getVersionEv")
  //</editor-fold>
  public abstract /*virtual*/ long/*uint64_t*/ getVersion() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::isIRLevelProfile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 318,
   FQN="llvm::InstrProfReaderIndexBase::isIRLevelProfile", NM="_ZNK4llvm24InstrProfReaderIndexBase16isIRLevelProfileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZNK4llvm24InstrProfReaderIndexBase16isIRLevelProfileEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isIRLevelProfile() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::populateSymtab">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 319,
   FQN="llvm::InstrProfReaderIndexBase::populateSymtab", NM="_ZN4llvm24InstrProfReaderIndexBase14populateSymtabERNS_15InstrProfSymtabE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBase14populateSymtabERNS_15InstrProfSymtabE")
  //</editor-fold>
  public abstract /*virtual*/ void populateSymtab(final InstrProfSymtab /*&*/ $Prm0)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfReaderIndexBase::InstrProfReaderIndexBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProfReader.h", line = 306,
   FQN="llvm::InstrProfReaderIndexBase::InstrProfReaderIndexBase", NM="_ZN4llvm24InstrProfReaderIndexBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfReaderIndexBaseC1Ev")
  //</editor-fold>
  public /*inline*/ InstrProfReaderIndexBase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
