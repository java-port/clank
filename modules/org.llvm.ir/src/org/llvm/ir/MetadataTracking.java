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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief API for tracking metadata references through RAUW and deletion.
///
/// Shared API for updating \a Metadata pointers in subclasses that support
/// RAUW.
///
/// This API is not meant to be used directly.  See \a TrackingMDRef for a
/// user-friendly tracking reference.
//<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 183,
 FQN="llvm::MetadataTracking", NM="_ZN4llvm16MetadataTrackingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTrackingE")
//</editor-fold>
public class MetadataTracking {
/*public:*/
  /// \brief Track the reference to metadata.
  ///
  /// Register \c MD with \c *MD, if the subclass supports tracking.  If \c *MD
  /// gets RAUW'ed, \c MD will be updated to the new address.  If \c *MD gets
  /// deleted, \c MD will be set to \c nullptr.
  ///
  /// If tracking isn't supported, \c *MD will not change.
  ///
  /// \return true iff tracking is supported by \c MD.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::track">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 194,
   FQN="llvm::MetadataTracking::track", NM="_ZN4llvm16MetadataTracking5trackERPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking5trackERPNS_8MetadataE")
  //</editor-fold>
  public static boolean track(final type$ptr<Metadata /*P*/ /*&*/> MD) {
    return track(MD, $Deref(MD), new PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >(JD$T1.INSTANCE, Metadata /*P*/.class, ((/*static_cast*/Metadata /*P*/ )((Metadata /*P*/ )null))));
  }


  /// \brief Track the reference to metadata for \a Metadata.
  ///
  /// As \a track(Metadata*&), but with support for calling back to \c Owner to
  /// tell it that its operand changed.  This could trigger \c Owner being
  /// re-uniqued.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::track">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 203,
   FQN="llvm::MetadataTracking::track", NM="_ZN4llvm16MetadataTracking5trackEPvRNS_8MetadataES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking5trackEPvRNS_8MetadataES3_")
  //</editor-fold>
  public static boolean track(final type$ptr<Metadata /*void P &*/> Ref, final Metadata /*&*/ MD, final Metadata /*&*/ Owner) {
    return track(Ref, MD, new PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >(JD$T1.INSTANCE, Metadata /*P*/.class, $AddrOf(Owner)));
  }


  /// \brief Track the reference to metadata for \a MetadataAsValue.
  ///
  /// As \a track(Metadata*&), but with support for calling back to \c Owner to
  /// tell it that its operand changed.  This could trigger \c Owner being
  /// re-uniqued.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::track">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 212,
   FQN="llvm::MetadataTracking::track", NM="_ZN4llvm16MetadataTracking5trackEPvRNS_8MetadataERNS_15MetadataAsValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking5trackEPvRNS_8MetadataERNS_15MetadataAsValueE")
  //</editor-fold>
  public static boolean track(final type$ptr<Metadata /*void P &*/> Ref, final Metadata /*&*/ MD, final MetadataAsValue /*&*/ Owner) {
    return track(Ref, MD, new PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >(JD$T.INSTANCE, MetadataAsValue /*P*/.class, $AddrOf(Owner)));
  }


  /// \brief Stop tracking a reference to metadata.
  ///
  /// Stops \c *MD from tracking \c MD.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::untrack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 219,
   FQN="llvm::MetadataTracking::untrack", NM="_ZN4llvm16MetadataTracking7untrackERPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking7untrackERPNS_8MetadataE")
  //</editor-fold>
  public static void untrack(final type$ptr<Metadata/*P*/ /*&*/> MD) {
    untrack(MD, $Deref(MD));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::untrack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 138,
   FQN="llvm::MetadataTracking::untrack", NM="_ZN4llvm16MetadataTracking7untrackEPvRNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking7untrackEPvRNS_8MetadataE")
  //</editor-fold>
  public static void untrack(final type$ptr<Metadata/*P*/ /*&*/>/*void P*/ Ref, final Metadata /*&*/ MD) {
    assert ((Ref != null)) : "Expected live reference";
    {
      ReplaceableMetadataImpl /*P*/ R = ReplaceableMetadataImpl.getIfExists(MD);
      if ((R != null)) {
        R.dropRef(Ref);
      } else {
        DistinctMDOperandPlaceholder /*P*/ PH = dyn_cast_DistinctMDOperandPlaceholder($AddrOf(MD));
        if ((PH != null)) {
          PH.Use = null;
        }
      }
    }
  }


  /// \brief Move tracking from one reference to another.
  ///
  /// Semantically equivalent to \c untrack(MD) followed by \c track(New),
  /// except that ownership callbacks are maintained.
  ///
  /// Note: it is an error if \c *MD does not equal \c New.
  ///
  /// \return true iff tracking is supported by \c MD.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::retrack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 230,
   FQN="llvm::MetadataTracking::retrack", NM="_ZN4llvm16MetadataTracking7retrackERPNS_8MetadataES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking7retrackERPNS_8MetadataES3_")
  //</editor-fold>
  public static boolean retrack(final type$ptr<Metadata /*P*/ /*&*/> MD, final type$ptr<Metadata /*P*/ /*&*/> New) {
    return retrack(MD, $Deref(MD), New);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::retrack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 146,
   FQN="llvm::MetadataTracking::retrack", NM="_ZN4llvm16MetadataTracking7retrackEPvRNS_8MetadataES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking7retrackEPvRNS_8MetadataES1_")
  //</editor-fold>
  public static boolean retrack(final type$ptr<Metadata /*P*/ /*&*/>/*void P*/ Ref, final Metadata /*&*/ MD, final type$ptr<Metadata /*P*/ /*&*/>/*void P*/ New) {
    assert ((Ref != null)) : "Expected live reference";
    assert ((New != null)) : "Expected live reference";
    assert (Ref != New) : "Expected change";
    {
      ReplaceableMetadataImpl /*P*/ R = ReplaceableMetadataImpl.getIfExists(MD);
      if ((R != null)) {
        R.moveRef(Ref, New, MD);
        return true;
      }
    }
    assert (!isa_DistinctMDOperandPlaceholder(MD)) : "Unexpected move of an MDOperand";
    assert (!isReplaceable(MD)) : "Expected un-replaceable metadata, since we didn't move a reference";
    return false;
  }


  /// \brief Check whether metadata is replaceable.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::isReplaceable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 161,
   FQN="llvm::MetadataTracking::isReplaceable", NM="_ZN4llvm16MetadataTracking13isReplaceableERKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking13isReplaceableERKNS_8MetadataE")
  //</editor-fold>
  public static boolean isReplaceable(final /*const*/ Metadata /*&*/ MD) {
    return ReplaceableMetadataImpl.isReplaceable(MD);
  }


  // JAVA: typedef PointerUnion<MetadataAsValue *, Metadata *> OwnerTy
//  public final class OwnerTy extends PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >{ };
/*private:*/
  /// \brief Track a reference to metadata for an owner.
  ///
  /// Generalized version of tracking.
  //<editor-fold defaultstate="collapsed" desc="llvm::MetadataTracking::track">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 121,
   FQN="llvm::MetadataTracking::track", NM="_ZN4llvm16MetadataTracking5trackEPvRNS_8MetadataENS_12PointerUnionIPNS_15MetadataAsValueEPS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm16MetadataTracking5trackEPvRNS_8MetadataENS_12PointerUnionIPNS_15MetadataAsValueEPS2_EE")
  //</editor-fold>
  private static boolean track(final type$ptr<Metadata /*P*/ /*&*/>/*void P*/ Ref, final Metadata /*&*/ MD, PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ > Owner) {
    assert ((Ref != null)) : "Expected live reference";
    assert Ref.$star() == MD : "Expected address of MD";
    assert ((Owner.$bool() || ((/*static_cast*/type$ptr<Metadata /*P*/ /*P*/>)(Ref)).$star() == $AddrOf(MD))) : "Reference without owner must be direct";
    {
      ReplaceableMetadataImpl /*P*/ R = ReplaceableMetadataImpl.getOrCreate(MD);
      if ((R != null)) {
        R.addRef(Ref, new PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >(Owner));
        return true;
      }
    }
    {
      DistinctMDOperandPlaceholder /*P*/ PH = dyn_cast_DistinctMDOperandPlaceholder($AddrOf(MD));
      if ((PH != null)) {
        assert (!(PH.Use != null)) : "Placeholders can only be used once";
        assert (!Owner.$bool()) : "Unexpected callback to owner";
        PH.Use = $noClone(((/*static_cast*/type$ptr<Metadata /*P*/ /*P*/>)(Ref)));
        return true;
      }
    }
    return false;
  }

  @Override public String toString() {
    return ""; // NOI18N
  }
}
