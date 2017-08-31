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
import org.llvm.support.Error;

//<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 336,
 FQN="llvm::SoftInstrProfErrors", NM="_ZN4llvm19SoftInstrProfErrorsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm19SoftInstrProfErrorsE")
//</editor-fold>
public class SoftInstrProfErrors implements Destructors.ClassWithDestructor {
  /// Count the number of soft instrprof_errors encountered and keep track of
  /// the first such error for reporting purposes.
  
  /// The first soft error encountered.
  private instrprof_error FirstError;
  
  /// The number of hash mismatches.
  private /*uint*/int NumHashMismatches;
  
  /// The number of count mismatches.
  private /*uint*/int NumCountMismatches;
  
  /// The number of counter overflows.
  private /*uint*/int NumCounterOverflows;
  
  /// The number of value site count mismatches.
  private /*uint*/int NumValueSiteCountMismatches;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::SoftInstrProfErrors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 356,
   FQN="llvm::SoftInstrProfErrors::SoftInstrProfErrors", NM="_ZN4llvm19SoftInstrProfErrorsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm19SoftInstrProfErrorsC1Ev")
  //</editor-fold>
  public SoftInstrProfErrors() {
    // : FirstError(instrprof_error::success), NumHashMismatches(0), NumCountMismatches(0), NumCounterOverflows(0), NumValueSiteCountMismatches(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::~SoftInstrProfErrors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 361,
   FQN="llvm::SoftInstrProfErrors::~SoftInstrProfErrors", NM="_ZN4llvm19SoftInstrProfErrorsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm19SoftInstrProfErrorsD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Track a soft error (\p IE) and increment its associated counter.
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::addError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 95,
   FQN="llvm::SoftInstrProfErrors::addError", NM="_ZN4llvm19SoftInstrProfErrors8addErrorENS_15instrprof_errorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm19SoftInstrProfErrors8addErrorENS_15instrprof_errorE")
  //</editor-fold>
  public void addError(instrprof_error IE) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of hash mismatches.
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::getNumHashMismatches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 370,
   FQN="llvm::SoftInstrProfErrors::getNumHashMismatches", NM="_ZNK4llvm19SoftInstrProfErrors20getNumHashMismatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm19SoftInstrProfErrors20getNumHashMismatchesEv")
  //</editor-fold>
  public /*uint*/int getNumHashMismatches() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of count mismatches.
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::getNumCountMismatches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 373,
   FQN="llvm::SoftInstrProfErrors::getNumCountMismatches", NM="_ZNK4llvm19SoftInstrProfErrors21getNumCountMismatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm19SoftInstrProfErrors21getNumCountMismatchesEv")
  //</editor-fold>
  public /*uint*/int getNumCountMismatches() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of counter overflows.
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::getNumCounterOverflows">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 376,
   FQN="llvm::SoftInstrProfErrors::getNumCounterOverflows", NM="_ZNK4llvm19SoftInstrProfErrors22getNumCounterOverflowsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm19SoftInstrProfErrors22getNumCounterOverflowsEv")
  //</editor-fold>
  public /*uint*/int getNumCounterOverflows() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the number of value site count mismatches.
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::getNumValueSiteCountMismatches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 379,
   FQN="llvm::SoftInstrProfErrors::getNumValueSiteCountMismatches", NM="_ZNK4llvm19SoftInstrProfErrors30getNumValueSiteCountMismatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZNK4llvm19SoftInstrProfErrors30getNumValueSiteCountMismatchesEv")
  //</editor-fold>
  public /*uint*/int getNumValueSiteCountMismatches() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the first encountered error and reset FirstError to a success
  /// value.
  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::takeError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 385,
   FQN="llvm::SoftInstrProfErrors::takeError", NM="_ZN4llvm19SoftInstrProfErrors9takeErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm19SoftInstrProfErrors9takeErrorEv")
  //</editor-fold>
  public Error takeError() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::SoftInstrProfErrors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 336,
   FQN="llvm::SoftInstrProfErrors::SoftInstrProfErrors", NM="_ZN4llvm19SoftInstrProfErrorsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm19SoftInstrProfErrorsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SoftInstrProfErrors(final /*const*/ SoftInstrProfErrors /*&*/ $Prm0) {
    // : FirstError(.FirstError), NumHashMismatches(.NumHashMismatches), NumCountMismatches(.NumCountMismatches), NumCounterOverflows(.NumCounterOverflows), NumValueSiteCountMismatches(.NumValueSiteCountMismatches) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SoftInstrProfErrors::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 336,
   FQN="llvm::SoftInstrProfErrors::operator=", NM="_ZN4llvm19SoftInstrProfErrorsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProfReader.cpp -nm=_ZN4llvm19SoftInstrProfErrorsaSERKS0_")
  //</editor-fold>
  public /*inline*/ SoftInstrProfErrors /*&*/ $assign(final /*const*/ SoftInstrProfErrors /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "FirstError=" + FirstError // NOI18N
              + ", NumHashMismatches=" + NumHashMismatches // NOI18N
              + ", NumCountMismatches=" + NumCountMismatches // NOI18N
              + ", NumCounterOverflows=" + NumCounterOverflows // NOI18N
              + ", NumValueSiteCountMismatches=" + NumValueSiteCountMismatches; // NOI18N
  }
}
