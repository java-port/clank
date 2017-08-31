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
import org.clank.support.JavaDifferentiators.*;


/// \brief A Counter mapping region associates a source range with
/// a specific counter.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 190,
 FQN="llvm::coverage::CounterMappingRegion", NM="_ZN4llvm8coverage20CounterMappingRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegionE")
//</editor-fold>
public class/*struct*/ CounterMappingRegion {
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::RegionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 191,
   FQN="llvm::coverage::CounterMappingRegion::RegionKind", NM="_ZN4llvm8coverage20CounterMappingRegion10RegionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegion10RegionKindE")
  //</editor-fold>
  public enum RegionKind implements Native.NativeUIntEnum {
    /// \brief A CodeRegion associates some code with a counter
    CodeRegion(0),
    
    /// \brief An ExpansionRegion represents a file expansion region that
    /// associates a source range with the expansion of a virtual source file,
    /// such as for a macro instantiation or #include file.
    ExpansionRegion(CodeRegion.getValue() + 1),
    
    /// \brief A SkippedRegion represents a source range with code that
    /// was skipped by a preprocessor or similar means.
    SkippedRegion(ExpansionRegion.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RegionKind valueOf(int val) {
      RegionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RegionKind[] VALUES;
      private static final RegionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RegionKind kind : RegionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RegionKind[min < 0 ? (1-min) : 0];
        VALUES = new RegionKind[max >= 0 ? (1+max) : 0];
        for (RegionKind kind : RegionKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private RegionKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  public Counter Count;
  public /*uint*/int FileID;
  public /*uint*/int ExpandedFileID;
  public /*uint*/int LineStart;
  public /*uint*/int ColumnStart;
  public /*uint*/int LineEnd;
  public /*uint*/int ColumnEnd;
  public RegionKind Kind;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::CounterMappingRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 210,
   FQN="llvm::coverage::CounterMappingRegion::CounterMappingRegion", NM="_ZN4llvm8coverage20CounterMappingRegionC1ENS0_7CounterEjjjjjjNS1_10RegionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegionC1ENS0_7CounterEjjjjjjNS1_10RegionKindE")
  //</editor-fold>
  public CounterMappingRegion(Counter Count, /*uint*/int FileID, /*uint*/int ExpandedFileID, 
      /*uint*/int LineStart, /*uint*/int ColumnStart, 
      /*uint*/int LineEnd, /*uint*/int ColumnEnd, RegionKind Kind) {
    // : Count(Count), FileID(FileID), ExpandedFileID(ExpandedFileID), LineStart(LineStart), ColumnStart(ColumnStart), LineEnd(LineEnd), ColumnEnd(ColumnEnd), Kind(Kind) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::makeRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 217,
   FQN="llvm::coverage::CounterMappingRegion::makeRegion", NM="_ZN4llvm8coverage20CounterMappingRegion10makeRegionENS0_7CounterEjjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegion10makeRegionENS0_7CounterEjjjjj")
  //</editor-fold>
  public static CounterMappingRegion makeRegion(Counter Count, /*uint*/int FileID, /*uint*/int LineStart, 
            /*uint*/int ColumnStart, /*uint*/int LineEnd, /*uint*/int ColumnEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::makeExpansion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 224,
   FQN="llvm::coverage::CounterMappingRegion::makeExpansion", NM="_ZN4llvm8coverage20CounterMappingRegion13makeExpansionEjjjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegion13makeExpansionEjjjjjj")
  //</editor-fold>
  public static CounterMappingRegion makeExpansion(/*uint*/int FileID, /*uint*/int ExpandedFileID, /*uint*/int LineStart, 
               /*uint*/int ColumnStart, /*uint*/int LineEnd, /*uint*/int ColumnEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::makeSkipped">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 232,
   FQN="llvm::coverage::CounterMappingRegion::makeSkipped", NM="_ZN4llvm8coverage20CounterMappingRegion11makeSkippedEjjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegion11makeSkippedEjjjjj")
  //</editor-fold>
  public static CounterMappingRegion makeSkipped(/*uint*/int FileID, /*uint*/int LineStart, /*uint*/int ColumnStart, 
             /*uint*/int LineEnd, /*uint*/int ColumnEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::startLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 240,
   FQN="llvm::coverage::CounterMappingRegion::startLoc", NM="_ZNK4llvm8coverage20CounterMappingRegion8startLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage20CounterMappingRegion8startLocEv")
  //</editor-fold>
  public /*inline*/ std.pairUIntUInt startLoc() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::endLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 244,
   FQN="llvm::coverage::CounterMappingRegion::endLoc", NM="_ZNK4llvm8coverage20CounterMappingRegion6endLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage20CounterMappingRegion6endLocEv")
  //</editor-fold>
  public /*inline*/ std.pairUIntUInt endLoc() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 248,
   FQN="llvm::coverage::CounterMappingRegion::operator<", NM="_ZNK4llvm8coverage20CounterMappingRegionltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage20CounterMappingRegionltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ CounterMappingRegion /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 254,
   FQN="llvm::coverage::CounterMappingRegion::contains", NM="_ZNK4llvm8coverage20CounterMappingRegion8containsERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage20CounterMappingRegion8containsERKS1_")
  //</editor-fold>
  public boolean contains(final /*const*/ CounterMappingRegion /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::CounterMappingRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 190,
   FQN="llvm::coverage::CounterMappingRegion::CounterMappingRegion", NM="_ZN4llvm8coverage20CounterMappingRegionC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegionC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CounterMappingRegion(final /*const*/ CounterMappingRegion /*&*/ $Prm0) {
    // : Count(.Count), FileID(.FileID), ExpandedFileID(.ExpandedFileID), LineStart(.LineStart), ColumnStart(.ColumnStart), LineEnd(.LineEnd), ColumnEnd(.ColumnEnd), Kind(.Kind) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::CounterMappingRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 190,
   FQN="llvm::coverage::CounterMappingRegion::CounterMappingRegion", NM="_ZN4llvm8coverage20CounterMappingRegionC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegionC1EOS1_")
  //</editor-fold>
  public /*inline*/ CounterMappingRegion(JD$Move _dparam, final CounterMappingRegion /*&&*/$Prm0) {
    // : Count(static_cast<CounterMappingRegion &&>().Count), FileID(static_cast<CounterMappingRegion &&>().FileID), ExpandedFileID(static_cast<CounterMappingRegion &&>().ExpandedFileID), LineStart(static_cast<CounterMappingRegion &&>().LineStart), ColumnStart(static_cast<CounterMappingRegion &&>().ColumnStart), LineEnd(static_cast<CounterMappingRegion &&>().LineEnd), ColumnEnd(static_cast<CounterMappingRegion &&>().ColumnEnd), Kind(static_cast<CounterMappingRegion &&>().Kind) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 190,
   FQN="llvm::coverage::CounterMappingRegion::operator=", NM="_ZN4llvm8coverage20CounterMappingRegionaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegionaSERKS1_")
  //</editor-fold>
  public /*inline*/ CounterMappingRegion /*&*/ $assign(final /*const*/ CounterMappingRegion /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingRegion::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 190,
   FQN="llvm::coverage::CounterMappingRegion::operator=", NM="_ZN4llvm8coverage20CounterMappingRegionaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage20CounterMappingRegionaSEOS1_")
  //</editor-fold>
  public /*inline*/ CounterMappingRegion /*&*/ $assignMove(final CounterMappingRegion /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CounterMappingRegion() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Count=" + Count // NOI18N
              + ", FileID=" + FileID // NOI18N
              + ", ExpandedFileID=" + ExpandedFileID // NOI18N
              + ", LineStart=" + LineStart // NOI18N
              + ", ColumnStart=" + ColumnStart // NOI18N
              + ", LineEnd=" + LineEnd // NOI18N
              + ", ColumnEnd=" + ColumnEnd // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
