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

package org.clang.basic;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;

// JAVA MANUAL_SEMANTIC: changed FileIDs to ints

/// \brief Holds the cache used by isBeforeInTranslationUnit.
///
/// The cache structure is complex enough to be worth breaking out of
/// SourceManager.
//<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 461,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 462,
 FQN="clang::InBeforeInTUCacheEntry", NM="_ZN5clang22InBeforeInTUCacheEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntryE")
//</editor-fold>
public class InBeforeInTUCacheEntry implements Native.NativePOD<InBeforeInTUCacheEntry> {
  /// \brief The FileID's of the cached query.
  ///
  /// If these match up with a subsequent query, the result can be reused.
  private /*FileID*/int LQueryFID;
  private /*FileID*/int RQueryFID;
  
  /// \brief True if LQueryFID was created before RQueryFID.
  ///
  /// This is used to compare macro expansion locations.
  private boolean IsLQFIDBeforeRQFID;
  
  /// \brief The file found in common between the two \#include traces, i.e.,
  /// the nearest common ancestor of the \#include tree.
  private /*FileID*/int CommonFID;
  
  /// \brief The offset of the previous query in CommonFID.
  ///
  /// Usually, this represents the location of the \#include for QueryFID, but
  /// if LQueryFID is a parent of RQueryFID (or vice versa) then these can be a
  /// random token in the parent.
  private /*uint*/int LCommonOffset;
  private /*uint*/int RCommonOffset;
/*public:*/
  /// \brief Return true if the currently cached values match up with
  /// the specified LHS/RHS query.
  ///
  /// If not, we can't use the cache.
  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::isCacheValid">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 487,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 488,
   FQN="clang::InBeforeInTUCacheEntry::isCacheValid", NM="_ZNK5clang22InBeforeInTUCacheEntry12isCacheValidENS_6FileIDES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang22InBeforeInTUCacheEntry12isCacheValidENS_6FileIDES1_")
  //</editor-fold>
  public boolean isCacheValid(/*FileID*/int LHS, /*FileID*/int RHS) /*const*/ {
    return (LQueryFID == LHS) && (RQueryFID == RHS);
  }

  
  /// \brief If the cache is valid, compute the result given the
  /// specified offsets in the LHS/RHS FileID's.
  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::getCachedResult">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 493,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 494,
   FQN="clang::InBeforeInTUCacheEntry::getCachedResult", NM="_ZNK5clang22InBeforeInTUCacheEntry15getCachedResultEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang22InBeforeInTUCacheEntry15getCachedResultEjj")
  //</editor-fold>
  public boolean getCachedResult(/*uint*/int LOffset, /*uint*/int ROffset) /*const*/ {
    // If one of the query files is the common file, use the offset.  Otherwise,
    // use the #include loc in the common file.
    if ((LQueryFID != CommonFID)) {
      LOffset = LCommonOffset;
    }
    if ((RQueryFID != CommonFID)) {
      ROffset = RCommonOffset;
    }
    
    // It is common for multiple macro expansions to be "included" from the same
    // location (expansion location), in which case use the order of the FileIDs
    // to determine which came first. This will also take care the case where
    // one of the locations points at the inclusion/expansion point of the other
    // in which case its FileID will come before the other.
    if (LOffset == ROffset) {
      return IsLQFIDBeforeRQFID;
    }
    
    return $less_uint(LOffset, ROffset);
  }

  
  /// \brief Set up a new query.
  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::setQueryFIDs">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 511,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 512,
   FQN="clang::InBeforeInTUCacheEntry::setQueryFIDs", NM="_ZN5clang22InBeforeInTUCacheEntry12setQueryFIDsENS_6FileIDES1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntry12setQueryFIDsENS_6FileIDES1_b")
  //</editor-fold>
  public void setQueryFIDs(/*FileID*/int LHS, /*FileID*/int RHS, boolean isLFIDBeforeRFID) {
    assert (LHS != RHS);
    LQueryFID = LHS;
    RQueryFID = RHS;
    IsLQFIDBeforeRQFID = isLFIDBeforeRFID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::clear">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 518,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 519,
   FQN="clang::InBeforeInTUCacheEntry::clear", NM="_ZN5clang22InBeforeInTUCacheEntry5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntry5clearEv")
  //</editor-fold>
  public void clear() {
    LQueryFID = RQueryFID = FileID.getInvalidID();
    IsLQFIDBeforeRQFID = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::setCommonLoc">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 523,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 524,
   FQN="clang::InBeforeInTUCacheEntry::setCommonLoc", NM="_ZN5clang22InBeforeInTUCacheEntry12setCommonLocENS_6FileIDEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntry12setCommonLocENS_6FileIDEjj")
  //</editor-fold>
  public void setCommonLoc(/*FileID*/int commonFID, /*uint*/int lCommonOffset, 
          /*uint*/int rCommonOffset) {
    CommonFID = commonFID;
    LCommonOffset = lCommonOffset;
    RCommonOffset = rCommonOffset;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::InBeforeInTUCacheEntry">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 462,
   FQN="clang::InBeforeInTUCacheEntry::InBeforeInTUCacheEntry", NM="_ZN5clang22InBeforeInTUCacheEntryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntryC1Ev")
  //</editor-fold>
  public /*inline*/ InBeforeInTUCacheEntry() {
    /* : LQueryFID(), RQueryFID(), CommonFID()*/ 
    //START JInit
    this.LQueryFID = FileID.getInvalidID();
    this.RQueryFID = FileID.getInvalidID();
    this.CommonFID = FileID.getInvalidID();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::InBeforeInTUCacheEntry">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 462,
   FQN="clang::InBeforeInTUCacheEntry::InBeforeInTUCacheEntry", NM="_ZN5clang22InBeforeInTUCacheEntryC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InBeforeInTUCacheEntry(/*const*/ InBeforeInTUCacheEntry /*&*/ $Prm0) {
    /* : LQueryFID(.LQueryFID), RQueryFID(.RQueryFID), IsLQFIDBeforeRQFID(.IsLQFIDBeforeRQFID), CommonFID(.CommonFID), LCommonOffset(.LCommonOffset), RCommonOffset(.RCommonOffset)*/ 
    //START JInit
    this.LQueryFID = $Prm0.LQueryFID;
    this.RQueryFID = $Prm0.RQueryFID;
    this.IsLQFIDBeforeRQFID = $Prm0.IsLQFIDBeforeRQFID;
    this.CommonFID = $Prm0.CommonFID;
    this.LCommonOffset = $Prm0.LCommonOffset;
    this.RCommonOffset = $Prm0.RCommonOffset;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InBeforeInTUCacheEntry::InBeforeInTUCacheEntry">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManager.h", old_line = 462,
   FQN="clang::InBeforeInTUCacheEntry::InBeforeInTUCacheEntry", NM="_ZN5clang22InBeforeInTUCacheEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang22InBeforeInTUCacheEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ InBeforeInTUCacheEntry(JD$Move _dparam, InBeforeInTUCacheEntry /*&&*/$Prm0) {
    /* : LQueryFID(static_cast<InBeforeInTUCacheEntry &&>().LQueryFID), RQueryFID(static_cast<InBeforeInTUCacheEntry &&>().RQueryFID), IsLQFIDBeforeRQFID(static_cast<InBeforeInTUCacheEntry &&>().IsLQFIDBeforeRQFID), CommonFID(static_cast<InBeforeInTUCacheEntry &&>().CommonFID), LCommonOffset(static_cast<InBeforeInTUCacheEntry &&>().LCommonOffset), RCommonOffset(static_cast<InBeforeInTUCacheEntry &&>().RCommonOffset)*/ 
    //START JInit
    this.LQueryFID = $Prm0.LQueryFID;
    this.RQueryFID = $Prm0.RQueryFID;
    this.IsLQFIDBeforeRQFID = $Prm0.IsLQFIDBeforeRQFID;
    this.CommonFID = $Prm0.CommonFID;
    this.LCommonOffset = $Prm0.LCommonOffset;
    this.RCommonOffset = $Prm0.RCommonOffset;
    //END JInit
  }

  
  @Override
  public String toString() {
    return "InBeforeInTUCacheEntry{" + "LQueryFID=" + FileID.get(LQueryFID) + 
            ", RQueryFID=" + FileID.get(RQueryFID) + 
            "\n, IsLQFIDBeforeRQFID=" + IsLQFIDBeforeRQFID + 
            "\n, CommonFID=" + FileID.get(CommonFID) + 
            "\n, LCommonOffset=" + LCommonOffset + ", RCommonOffset=" + RCommonOffset + '}';
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public InBeforeInTUCacheEntry $assign(InBeforeInTUCacheEntry $Prm0) {
    this.LQueryFID = $Prm0.LQueryFID;
    this.RQueryFID = $Prm0.RQueryFID;
    this.IsLQFIDBeforeRQFID = $Prm0.IsLQFIDBeforeRQFID;
    this.CommonFID = $Prm0.CommonFID;
    this.LCommonOffset = $Prm0.LCommonOffset;
    this.RCommonOffset = $Prm0.RCommonOffset;
    return this;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public InBeforeInTUCacheEntry $assignMove(InBeforeInTUCacheEntry $Prm0) {
    this.LQueryFID = $Prm0.LQueryFID;
    this.RQueryFID = $Prm0.RQueryFID;
    this.IsLQFIDBeforeRQFID = $Prm0.IsLQFIDBeforeRQFID;
    this.CommonFID = $Prm0.CommonFID;
    this.LCommonOffset = $Prm0.LCommonOffset;
    this.RCommonOffset = $Prm0.RCommonOffset;
    return this;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public InBeforeInTUCacheEntry clone() {
    return new InBeforeInTUCacheEntry(this);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override
  public boolean $eq(InBeforeInTUCacheEntry other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.LQueryFID != other.LQueryFID) {
      return false;
    }
    if (this.RQueryFID != other.RQueryFID) {
      return false;
    }
    if (this.IsLQFIDBeforeRQFID != other.IsLQFIDBeforeRQFID) {
      return false;
    }
    if (this.CommonFID != other.CommonFID) {
      return false;
    }
    if (this.LCommonOffset != other.LCommonOffset) {
      return false;
    }
    if (this.RCommonOffset != other.RCommonOffset) {
      return false;
    }
    return true;
  }

}
