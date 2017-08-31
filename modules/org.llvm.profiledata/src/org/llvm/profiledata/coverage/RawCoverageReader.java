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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.support.Error;


/// \brief Base class for the raw coverage mapping and filenames data readers.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageReader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMappingReader.h", line = 79,
 FQN="llvm::coverage::RawCoverageReader", NM="_ZN4llvm8coverage17RawCoverageReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage17RawCoverageReaderE")
//</editor-fold>
public class RawCoverageReader {
/*protected:*/
  protected StringRef Data;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageReader::RawCoverageReader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMappingReader.h", line = 83,
   FQN="llvm::coverage::RawCoverageReader::RawCoverageReader", NM="_ZN4llvm8coverage17RawCoverageReaderC1ENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage17RawCoverageReaderC1ENS_9StringRefE")
  //</editor-fold>
  protected RawCoverageReader(StringRef Data) {
    // : Data(Data) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageReader::readULEB128">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 44,
   FQN="llvm::coverage::RawCoverageReader::readULEB128", NM="_ZN4llvm8coverage17RawCoverageReader11readULEB128ERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage17RawCoverageReader11readULEB128ERy")
  //</editor-fold>
  protected Error readULEB128(final ulong$ref/*uint64_t &*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageReader::readIntMax">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 55,
   FQN="llvm::coverage::RawCoverageReader::readIntMax", NM="_ZN4llvm8coverage17RawCoverageReader10readIntMaxERyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage17RawCoverageReader10readIntMaxERyy")
  //</editor-fold>
  protected Error readIntMax(final ulong$ref/*uint64_t &*/ Result, long/*uint64_t*/ MaxPlus1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageReader::readSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 63,
   FQN="llvm::coverage::RawCoverageReader::readSize", NM="_ZN4llvm8coverage17RawCoverageReader8readSizeERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage17RawCoverageReader8readSizeERy")
  //</editor-fold>
  protected Error readSize(final ulong$ref/*uint64_t &*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::RawCoverageReader::readString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp", line = 72,
   FQN="llvm::coverage::RawCoverageReader::readString", NM="_ZN4llvm8coverage17RawCoverageReader10readStringERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm8coverage17RawCoverageReader10readStringERNS_9StringRefE")
  //</editor-fold>
  protected Error readString(final StringRef /*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Data=" + Data; // NOI18N
  }
}
