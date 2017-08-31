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


/// \brief The execution count information starting at a point in a file.
///
/// A sequence of CoverageSegments gives execution counts for a file in format
/// that's simple to iterate through for processing.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::CoverageSegment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 371,
 FQN="llvm::coverage::CoverageSegment", NM="_ZN4llvm8coverage15CoverageSegmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage15CoverageSegmentE")
//</editor-fold>
public class/*struct*/ CoverageSegment {
  /// \brief The line where this segment begins.
  public /*uint*/int Line;
  /// \brief The column where this segment begins.
  public /*uint*/int Col;
  /// \brief The execution count, or zero if no count was recorded.
  public long/*uint64_t*/ Count;
  /// \brief When false, the segment was uninstrumented or skipped.
  public boolean HasCount;
  /// \brief Whether this enters a new region or returns to a previous count.
  public boolean IsRegionEntry;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CoverageSegment::CoverageSegment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 383,
   FQN="llvm::coverage::CoverageSegment::CoverageSegment", NM="_ZN4llvm8coverage15CoverageSegmentC1Ejjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage15CoverageSegmentC1Ejjb")
  //</editor-fold>
  public CoverageSegment(/*uint*/int Line, /*uint*/int Col, boolean IsRegionEntry) {
    // : Line(Line), Col(Col), Count(0), HasCount(false), IsRegionEntry(IsRegionEntry) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CoverageSegment::CoverageSegment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 387,
   FQN="llvm::coverage::CoverageSegment::CoverageSegment", NM="_ZN4llvm8coverage15CoverageSegmentC1Ejjyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage15CoverageSegmentC1Ejjyb")
  //</editor-fold>
  public CoverageSegment(/*uint*/int Line, /*uint*/int Col, long/*uint64_t*/ Count, 
      boolean IsRegionEntry) {
    // : Line(Line), Col(Col), Count(Count), HasCount(true), IsRegionEntry(IsRegionEntry) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::coverage::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 392,
   FQN="llvm::coverage::operator==", NM="_ZN4llvm8coverageeqERKNS0_15CoverageSegmentES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverageeqERKNS0_15CoverageSegmentES3_")
  //</editor-fold>
  public static boolean $eq_CoverageSegment$C(final /*const*/ CoverageSegment /*&*/ L, final /*const*/ CoverageSegment /*&*/ R) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CoverageSegment::CoverageSegment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 371,
   FQN="llvm::coverage::CoverageSegment::CoverageSegment", NM="_ZN4llvm8coverage15CoverageSegmentC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage15CoverageSegmentC1EOS1_")
  //</editor-fold>
  public /*inline*/ CoverageSegment(JD$Move _dparam, final CoverageSegment /*&&*/$Prm0) {
    // : Line(static_cast<CoverageSegment &&>().Line), Col(static_cast<CoverageSegment &&>().Col), Count(static_cast<CoverageSegment &&>().Count), HasCount(static_cast<CoverageSegment &&>().HasCount), IsRegionEntry(static_cast<CoverageSegment &&>().IsRegionEntry) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", Col=" + Col // NOI18N
              + ", Count=" + Count // NOI18N
              + ", HasCount=" + HasCount // NOI18N
              + ", IsRegionEntry=" + IsRegionEntry; // NOI18N
  }
}
