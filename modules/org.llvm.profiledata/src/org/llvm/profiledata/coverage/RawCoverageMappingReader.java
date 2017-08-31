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

package org.llvm.profiledata.coverage;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;


/// \brief Reader for the raw coverage mapping data.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMappingReader.h", line = 117,
 FQN="llvm::coverage::RawCoverageMappingReader", NM="_ZN4llvm8coverage24RawCoverageMappingReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReaderE")
//</editor-fold>
public class RawCoverageMappingReader extends /*public*/ RawCoverageReader {
  private ArrayRef<StringRef> TranslationUnitFilenames;
  private final std.vector<StringRef> /*&*/ Filenames;
  private final std.vector<CounterExpression> /*&*/ Expressions;
  private final std.vector<CounterMappingRegion> /*&*/ MappingRegions;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::RawCoverageMappingReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMappingReader.h", line = 123,
   FQN="llvm::coverage::RawCoverageMappingReader::RawCoverageMappingReader", NM="_ZN4llvm8coverage24RawCoverageMappingReaderC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReaderC1ERKS1_")
  //</editor-fold>
  protected/*private*/ RawCoverageMappingReader(final /*const*/ RawCoverageMappingReader /*&*/ $Prm0) {  super(null); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMappingReader.h", line = 124,
   FQN="llvm::coverage::RawCoverageMappingReader::operator=", NM="_ZN4llvm8coverage24RawCoverageMappingReaderaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReaderaSERKS1_")
  //</editor-fold>
  protected/*private*/ RawCoverageMappingReader /*&*/ $assign(final /*const*/ RawCoverageMappingReader /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::RawCoverageMappingReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMappingReader.h", line = 128,
   FQN="llvm::coverage::RawCoverageMappingReader::RawCoverageMappingReader", NM="_ZN4llvm8coverage24RawCoverageMappingReaderC1ENS_9StringRefENS_8ArrayRefIS2_EERSt6vectorIS2_SaIS2_EERS5_INS0_17CounterExpressionESaIS9_EERS5_INS0_20CounterMappingRegionESaISD_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReaderC1ENS_9StringRefENS_8ArrayRefIS2_EERSt6vectorIS2_SaIS2_EERS5_INS0_17CounterExpressionESaIS9_EERS5_INS0_20CounterMappingRegionESaISD_EE")
  //</editor-fold>
  public RawCoverageMappingReader(StringRef MappingData, 
      ArrayRef<StringRef> TranslationUnitFilenames, 
      final std.vector<StringRef> /*&*/ Filenames, 
      final std.vector<CounterExpression> /*&*/ Expressions, 
      final std.vector<CounterMappingRegion> /*&*/ MappingRegions) {
    // : RawCoverageReader(MappingData), TranslationUnitFilenames(TranslationUnitFilenames), Filenames(Filenames), Expressions(Expressions), MappingRegions(MappingRegions) 
    super(new StringRef(MappingData));
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::read">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 228,
   FQN="llvm::coverage::RawCoverageMappingReader::read", NM="_ZN4llvm8coverage24RawCoverageMappingReader4readEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReader4readEv")
  //</editor-fold>
  public Error read() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::decodeCounter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 94,
   FQN="llvm::coverage::RawCoverageMappingReader::decodeCounter", NM="_ZN4llvm8coverage24RawCoverageMappingReader13decodeCounterEjRNS0_7CounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReader13decodeCounterEjRNS0_7CounterE")
  //</editor-fold>
  private Error decodeCounter(/*uint*/int Value, final Counter /*&*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::readCounter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 123,
   FQN="llvm::coverage::RawCoverageMappingReader::readCounter", NM="_ZN4llvm8coverage24RawCoverageMappingReader11readCounterERNS0_7CounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReader11readCounterERNS0_7CounterE")
  //</editor-fold>
  private Error readCounter(final Counter /*&*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Read the sub-array of regions for the given inferred file id.
  /// \param NumFileIDs the number of file ids that are defined for this
  /// function.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageMappingReader::readMappingRegionsSubArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 139,
   FQN="llvm::coverage::RawCoverageMappingReader::readMappingRegionsSubArray", NM="_ZN4llvm8coverage24RawCoverageMappingReader26readMappingRegionsSubArrayERSt6vectorINS0_20CounterMappingRegionESaIS3_EEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage24RawCoverageMappingReader26readMappingRegionsSubArrayERSt6vectorINS0_20CounterMappingRegionESaIS3_EEjj")
  //</editor-fold>
  private Error readMappingRegionsSubArray(final std.vector<CounterMappingRegion> /*&*/ MappingRegions, /*uint*/int InferredFileID, 
                            /*size_t*/int NumFileIDs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "TranslationUnitFilenames=" + TranslationUnitFilenames // NOI18N
              + ", Filenames=" + Filenames // NOI18N
              + ", Expressions=" + Expressions // NOI18N
              + ", MappingRegions=" + MappingRegions // NOI18N
              + super.toString(); // NOI18N
  }
}
