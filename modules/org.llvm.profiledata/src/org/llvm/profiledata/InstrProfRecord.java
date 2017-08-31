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
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.support.Error;


/// Profiling information for a single function.
//<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 572,
 FQN="llvm::InstrProfRecord", NM="_ZN4llvm15InstrProfRecordE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecordE")
//</editor-fold>
public class/*struct*/ InstrProfRecord implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::InstrProfRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 573,
   FQN="llvm::InstrProfRecord::InstrProfRecord", NM="_ZN4llvm15InstrProfRecordC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecordC1Ev")
  //</editor-fold>
  public InstrProfRecord() {
    // : Name(), Counts(), SIPE(), IndirectCallSites() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::InstrProfRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 574,
   FQN="llvm::InstrProfRecord::InstrProfRecord", NM="_ZN4llvm15InstrProfRecordC1ENS_9StringRefEySt6vectorIySaIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecordC1ENS_9StringRefEySt6vectorIySaIyEE")
  //</editor-fold>
  public InstrProfRecord(StringRef Name, long/*uint64_t*/ Hash, std.vectorULong Counts) {
    // : Name(Name), Hash(Hash), Counts(std::move(Counts)), SIPE(), IndirectCallSites() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  public StringRef Name;
  public long/*uint64_t*/ Hash;
  public std.vectorULong Counts;
  public SoftInstrProfErrors SIPE;
  
  // JAVA: typedef std::vector<std::pair<uint64_t, uint64_t> > ValueMapType
//  public final class ValueMapType extends std.vector<std.pairULongULong>{ };
  
  /// Return the number of value profile kinds with non-zero number
  /// of profile sites.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getNumValueKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 670,
   FQN="llvm::InstrProfRecord::getNumValueKinds", NM="_ZNK4llvm15InstrProfRecord16getNumValueKindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord16getNumValueKindsEv")
  //</editor-fold>
  public /*uint32_t*/int getNumValueKinds() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return the number of instrumented sites for ValueKind.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getNumValueSites">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 687,
   FQN="llvm::InstrProfRecord::getNumValueSites", NM="_ZNK4llvm15InstrProfRecord16getNumValueSitesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord16getNumValueSitesEj")
  //</editor-fold>
  public /*uint32_t*/int getNumValueSites(/*uint32_t*/int ValueKind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return the total number of ValueData for ValueKind.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getNumValueData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 677,
   FQN="llvm::InstrProfRecord::getNumValueData", NM="_ZNK4llvm15InstrProfRecord15getNumValueDataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord15getNumValueDataEj")
  //</editor-fold>
  public /*uint32_t*/int getNumValueData(/*uint32_t*/int ValueKind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return the number of value data collected for ValueKind at profiling
  /// site: Site.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getNumValueDataForSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 691,
   FQN="llvm::InstrProfRecord::getNumValueDataForSite", NM="_ZNK4llvm15InstrProfRecord22getNumValueDataForSiteEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord22getNumValueDataForSiteEjj")
  //</editor-fold>
  public /*uint32_t*/int getNumValueDataForSite(/*uint32_t*/int ValueKind, 
                        /*uint32_t*/int Site) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Return the array of profiled values at \p Site. If \p TotalC
  /// is not null, the total count of all target values at this site
  /// will be stored in \c *TotalC.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getValueForSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 696,
   FQN="llvm::InstrProfRecord::getValueForSite", NM="_ZNK4llvm15InstrProfRecord15getValueForSiteEjjPy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord15getValueForSiteEjjPy")
  //</editor-fold>
  public unique_ptr_array<InstrProfValueData []> getValueForSite(/*uint32_t*/int ValueKind, /*uint32_t*/int Site) /*const*/ {
    return getValueForSite(ValueKind, Site, 
                 (ulong$ptr/*uint64_t P*/ )null);
  }
  public unique_ptr_array<InstrProfValueData []> getValueForSite(/*uint32_t*/int ValueKind, /*uint32_t*/int Site, 
                 ulong$ptr/*uint64_t P*/ TotalC/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Get the target value/counts of kind \p ValueKind collected at site
  /// \p Site and store the result in array \p Dest. Return the total
  /// counts of all target values at this site.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getValueForSite">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 713,
   FQN="llvm::InstrProfRecord::getValueForSite", NM="_ZNK4llvm15InstrProfRecord15getValueForSiteEP18InstrProfValueDatajj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord15getValueForSiteEP18InstrProfValueDatajj")
  //</editor-fold>
  public long/*uint64_t*/ getValueForSite(InstrProfValueData Dest[], 
                 /*uint32_t*/int ValueKind, 
                 /*uint32_t*/int Site) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Reserve space for NumValueSites sites.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::reserveSites">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 727,
   FQN="llvm::InstrProfRecord::reserveSites", NM="_ZN4llvm15InstrProfRecord12reserveSitesEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord12reserveSitesEjj")
  //</editor-fold>
  public void reserveSites(/*uint32_t*/int ValueKind, /*uint32_t*/int NumValueSites) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Add ValueData for ValueKind at value Site.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::addValueData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 452,
   FQN="llvm::InstrProfRecord::addValueData", NM="_ZN4llvm15InstrProfRecord12addValueDataEjjP18InstrProfValueDatajPSt6vectorISt4pairIyyESaIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord12addValueDataEjjP18InstrProfValueDatajPSt6vectorISt4pairIyyESaIS5_EE")
  //</editor-fold>
  public void addValueData(/*uint32_t*/int ValueKind, /*uint32_t*/int Site, 
               InstrProfValueData /*P*/ VData, /*uint32_t*/int N, 
              std.vector<std.pairULongULong> /*P*/ ValueMap) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Merge the counts in \p Other into this one.
  /// Optionally scale merged counts by \p Weight.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::merge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 388,
   FQN="llvm::InstrProfRecord::merge", NM="_ZN4llvm15InstrProfRecord5mergeERS0_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord5mergeERS0_y")
  //</editor-fold>
  public void merge(final InstrProfRecord /*&*/ Other) {
    merge(Other, $int2ulong(1));
  }
  public void merge(final InstrProfRecord /*&*/ Other, long/*uint64_t*/ Weight/*= 1*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Scale up profile counts (including value profile data) by
  /// \p Weight.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::scale">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 416,
   FQN="llvm::InstrProfRecord::scale", NM="_ZN4llvm15InstrProfRecord5scaleEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord5scaleEy")
  //</editor-fold>
  public void scale(long/*uint64_t*/ Weight) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Sort value profile data (per site) by count.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::sortValueData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 621,
   FQN="llvm::InstrProfRecord::sortValueData", NM="_ZN4llvm15InstrProfRecord13sortValueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord13sortValueDataEv")
  //</editor-fold>
  public void sortValueData() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Clear value data entries
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::clearValueData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 630,
   FQN="llvm::InstrProfRecord::clearValueData", NM="_ZN4llvm15InstrProfRecord14clearValueDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord14clearValueDataEv")
  //</editor-fold>
  public void clearValueData() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the error contained within the record's soft error counter.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::takeError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 636,
   FQN="llvm::InstrProfRecord::takeError", NM="_ZN4llvm15InstrProfRecord9takeErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord9takeErrorEv")
  //</editor-fold>
  public Error takeError() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private std.vector<InstrProfValueSiteRecord> IndirectCallSites;
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getValueSitesForKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 640,
   FQN="llvm::InstrProfRecord::getValueSitesForKind", NM="_ZNK4llvm15InstrProfRecord20getValueSitesForKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm15InstrProfRecord20getValueSitesForKindEj")
  //</editor-fold>
  private /*const*/std.vector<InstrProfValueSiteRecord> /*&*/ getValueSitesForKind$Const(/*uint32_t*/int ValueKind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::getValueSitesForKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 651,
   FQN="llvm::InstrProfRecord::getValueSitesForKind", NM="_ZN4llvm15InstrProfRecord20getValueSitesForKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord20getValueSitesForKindEj")
  //</editor-fold>
  private std.vector<InstrProfValueSiteRecord> /*&*/ getValueSitesForKind(/*uint32_t*/int ValueKind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Map indirect call target name hash to name string.
  
  // Map indirect call target name hash to name string.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::remapValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 428,
   FQN="llvm::InstrProfRecord::remapValue", NM="_ZN4llvm15InstrProfRecord10remapValueEyjPSt6vectorISt4pairIyyESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord10remapValueEyjPSt6vectorISt4pairIyyESaIS3_EE")
  //</editor-fold>
  private long/*uint64_t*/ remapValue(long/*uint64_t*/ Value, /*uint32_t*/int ValueKind, 
            std.vector<std.pairULongULong> /*P*/ ValueMap) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Merge Value Profile data from Src record to this record for ValueKind.
  // Scale merged value counts by \p Weight.
  
  // Merge Value Profile data from Src record to this record for ValueKind.
  // Scale merged value counts by \p Weight.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::mergeValueProfData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 371,
   FQN="llvm::InstrProfRecord::mergeValueProfData", NM="_ZN4llvm15InstrProfRecord18mergeValueProfDataEjRS0_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord18mergeValueProfDataEjRS0_y")
  //</editor-fold>
  private void mergeValueProfData(/*uint32_t*/int ValueKind, 
                    final InstrProfRecord /*&*/ Src, 
                    long/*uint64_t*/ Weight) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Scale up value profile data count.
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::scaleValueProfData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 408,
   FQN="llvm::InstrProfRecord::scaleValueProfData", NM="_ZN4llvm15InstrProfRecord18scaleValueProfDataEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15InstrProfRecord18scaleValueProfDataEjy")
  //</editor-fold>
  private void scaleValueProfData(/*uint32_t*/int ValueKind, long/*uint64_t*/ Weight) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::~InstrProfRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 572,
   FQN="llvm::InstrProfRecord::~InstrProfRecord", NM="_ZN4llvm15InstrProfRecordD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfRecordD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::InstrProfRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 572,
   FQN="llvm::InstrProfRecord::InstrProfRecord", NM="_ZN4llvm15InstrProfRecordC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfRecordC1EOS0_")
  //</editor-fold>
  public /*inline*/ InstrProfRecord(JD$Move _dparam, final InstrProfRecord /*&&*/$Prm0) {
    // : Name(static_cast<InstrProfRecord &&>().Name), Hash(static_cast<InstrProfRecord &&>().Hash), Counts(static_cast<InstrProfRecord &&>().Counts), SIPE(static_cast<InstrProfRecord &&>().SIPE), IndirectCallSites(static_cast<InstrProfRecord &&>().IndirectCallSites) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 572,
   FQN="llvm::InstrProfRecord::operator=", NM="_ZN4llvm15InstrProfRecordaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfRecordaSEOS0_")
  //</editor-fold>
  public /*inline*/ InstrProfRecord /*&*/ $assignMove(final InstrProfRecord /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::InstrProfRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 572,
   FQN="llvm::InstrProfRecord::InstrProfRecord", NM="_ZN4llvm15InstrProfRecordC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfRecordC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InstrProfRecord(final /*const*/ InstrProfRecord /*&*/ $Prm0) {
    // : Name(.Name), Hash(.Hash), Counts(.Counts), SIPE(.SIPE), IndirectCallSites(.IndirectCallSites) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InstrProfRecord::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 572,
   FQN="llvm::InstrProfRecord::operator=", NM="_ZN4llvm15InstrProfRecordaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm15InstrProfRecordaSERKS0_")
  //</editor-fold>
  public /*inline*/ InstrProfRecord /*&*/ $assign(final /*const*/ InstrProfRecord /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Hash=" + Hash // NOI18N
              + ", Counts=" + Counts // NOI18N
              + ", SIPE=" + SIPE // NOI18N
              + ", IndirectCallSites=" + IndirectCallSites; // NOI18N
  }
}
