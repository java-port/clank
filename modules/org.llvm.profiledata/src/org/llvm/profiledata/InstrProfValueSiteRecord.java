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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;

//<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 544,
 FQN="llvm::InstrProfValueSiteRecord", NM="_ZN4llvm24InstrProfValueSiteRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecordE")
//</editor-fold>
public class/*struct*/ InstrProfValueSiteRecord implements Destructors.ClassWithDestructor {
  /// Value profiling data pairs at a given value site.
  public std.list< InstrProfValueData> ValueData;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 548,
   FQN="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord", NM="_ZN4llvm24InstrProfValueSiteRecordC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecordC1Ev")
  //</editor-fold>
  public InstrProfValueSiteRecord() {
    // : ValueData() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*template <class InputIterator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 550,
   FQN="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord", NM="Tpl__ZN4llvm24InstrProfValueSiteRecordC1ET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=Tpl__ZN4llvm24InstrProfValueSiteRecordC1ET_S1_")
  //</editor-fold>
  public </*class*/ InputIterator> InstrProfValueSiteRecord(InputIterator F, InputIterator L) {
    // : ValueData(F, L) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Sort ValueData ascending by Value
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::sortByTargetValues">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 554,
   FQN="llvm::InstrProfValueSiteRecord::sortByTargetValues", NM="_ZN4llvm24InstrProfValueSiteRecord18sortByTargetValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecord18sortByTargetValuesEv")
  //</editor-fold>
  public void sortByTargetValues() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Sort ValueData Descending by Count
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::sortByCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 741,
   FQN="llvm::InstrProfValueSiteRecord::sortByCount", NM="_ZN4llvm24InstrProfValueSiteRecord11sortByCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecord11sortByCountEv")
  //</editor-fold>
  public void sortByCount() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Merge data from another InstrProfValueSiteRecord
  /// Optionally scale merged counts by \p Weight.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::merge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 336,
   FQN="llvm::InstrProfValueSiteRecord::merge", NM="_ZN4llvm24InstrProfValueSiteRecord5mergeERNS_19SoftInstrProfErrorsERS0_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecord5mergeERNS_19SoftInstrProfErrorsERS0_y")
  //</editor-fold>
  public void merge(final SoftInstrProfErrors /*&*/ SIPE, 
       final InstrProfValueSiteRecord /*&*/ Input) {
    merge(SIPE, 
       Input, 
       $int2ulong(1));
  }
  public void merge(final SoftInstrProfErrors /*&*/ SIPE, 
       final InstrProfValueSiteRecord /*&*/ Input, 
       long/*uint64_t*/ Weight/*= 1*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Scale up value profile data counts.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::scale">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 359,
   FQN="llvm::InstrProfValueSiteRecord::scale", NM="_ZN4llvm24InstrProfValueSiteRecord5scaleERNS_19SoftInstrProfErrorsEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecord5scaleERNS_19SoftInstrProfErrorsEy")
  //</editor-fold>
  public void scale(final SoftInstrProfErrors /*&*/ SIPE, 
       long/*uint64_t*/ Weight) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 544,
   FQN="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord", NM="_ZN4llvm24InstrProfValueSiteRecordC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecordC1EOS0_")
  //</editor-fold>
  public /*inline*/ InstrProfValueSiteRecord(JD$Move _dparam, final InstrProfValueSiteRecord /*&&*/$Prm0) {
    // : ValueData(static_cast<InstrProfValueSiteRecord &&>().ValueData) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::~InstrProfValueSiteRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 544,
   FQN="llvm::InstrProfValueSiteRecord::~InstrProfValueSiteRecord", NM="_ZN4llvm24InstrProfValueSiteRecordD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24InstrProfValueSiteRecordD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 544,
   FQN="llvm::InstrProfValueSiteRecord::InstrProfValueSiteRecord", NM="_ZN4llvm24InstrProfValueSiteRecordC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfValueSiteRecordC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InstrProfValueSiteRecord(final /*const*/ InstrProfValueSiteRecord /*&*/ $Prm0) {
    // : ValueData(.ValueData) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfValueSiteRecord::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 544,
   FQN="llvm::InstrProfValueSiteRecord::operator=", NM="_ZN4llvm24InstrProfValueSiteRecordaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm24InstrProfValueSiteRecordaSERKS0_")
  //</editor-fold>
  public /*inline*/ InstrProfValueSiteRecord /*&*/ $assign(final /*const*/ InstrProfValueSiteRecord /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ValueData=" + ValueData; // NOI18N
  }
}
