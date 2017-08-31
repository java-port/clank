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

package org.llvm.analysis;

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
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// Representation for a specific memory location.
///
/// This abstraction can be used to represent a specific location in memory.
/// The goal of the location is to represent enough information to describe
/// abstract aliasing, modification, and reference behaviors of whatever
/// value(s) are stored in memory at the particular location.
///
/// The primary user of this interface is LLVM's Alias Analysis, but other
/// memory analyses such as MemoryDependence can use it as well.
//<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 40,
 FQN="llvm::MemoryLocation", NM="_ZN4llvm14MemoryLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocationE")
//</editor-fold>
public class MemoryLocation implements Native.NativeComparable<MemoryLocation> {
/*public:*/
  /// UnknownSize - This is a special value which can be used with the
  /// size arguments in alias queries to indicate that the caller does not
  /// know the sizes of the potential memory references.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 45,
   FQN="llvm::MemoryLocation::(anonymous)", NM="_ZN4llvm14MemoryLocationE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocationE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : uint64_t {*/
    public static final long/*uint64_t*/ UnknownSize = ~0L/*ULL*/;
  /*}*/;
  
  /// The address of the start of the location.
  public /*const*/ Value /*P*/ Ptr;
  
  /// The maximum size of the location, in address-units, or
  /// UnknownSize if the size is not known.
  ///
  /// Note that an unknown size does not mean the pointer aliases the entire
  /// virtual address space, because there are restrictions on stepping out of
  /// one object and into another. See
  /// http://llvm.org/docs/LangRef.html#pointeraliasing
  public long/*uint64_t*/ Size;
  
  /// The metadata nodes which describes the aliasing of the location (each
  /// member is null if that kind of information is unavailable).
  public AAMDNodes AATags;
  
  /// Return a location with information about the memory reference by the given
  /// instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 21,
   FQN="llvm::MemoryLocation::get", NM="_ZN4llvm14MemoryLocation3getEPKNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation3getEPKNS_8LoadInstE")
  //</editor-fold>
  public static MemoryLocation get(/*const*/ LoadInst /*P*/ LI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 30,
   FQN="llvm::MemoryLocation::get", NM="_ZN4llvm14MemoryLocation3getEPKNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation3getEPKNS_9StoreInstE")
  //</editor-fold>
  public static MemoryLocation get(/*const*/ StoreInst /*P*/ SI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 40,
   FQN="llvm::MemoryLocation::get", NM="_ZN4llvm14MemoryLocation3getEPKNS_9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation3getEPKNS_9VAArgInstE")
  //</editor-fold>
  public static MemoryLocation get(/*const*/ VAArgInst /*P*/ VI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 47,
   FQN="llvm::MemoryLocation::get", NM="_ZN4llvm14MemoryLocation3getEPKNS_17AtomicCmpXchgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation3getEPKNS_17AtomicCmpXchgInstE")
  //</editor-fold>
  public static MemoryLocation get(/*const*/ AtomicCmpXchgInst /*P*/ CXI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 57,
   FQN="llvm::MemoryLocation::get", NM="_ZN4llvm14MemoryLocation3getEPKNS_13AtomicRMWInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation3getEPKNS_13AtomicRMWInstE")
  //</editor-fold>
  public static MemoryLocation get(/*const*/ AtomicRMWInst /*P*/ RMWI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 70,
   FQN="llvm::MemoryLocation::get", NM="_ZN4llvm14MemoryLocation3getEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation3getEPKNS_11InstructionE")
  //</editor-fold>
  public static MemoryLocation get(/*const*/ Instruction /*P*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a location representing the source of a memory transfer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::getForSource">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 67,
   FQN="llvm::MemoryLocation::getForSource", NM="_ZN4llvm14MemoryLocation12getForSourceEPKNS_15MemTransferInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation12getForSourceEPKNS_15MemTransferInstE")
  //</editor-fold>
  public static MemoryLocation getForSource(/*const*/ MemTransferInst /*P*/ MTI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a location representing the destination of a memory set or
  /// transfer.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::getForDest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 80,
   FQN="llvm::MemoryLocation::getForDest", NM="_ZN4llvm14MemoryLocation10getForDestEPKNS_12MemIntrinsicE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation10getForDestEPKNS_12MemIntrinsicE")
  //</editor-fold>
  public static MemoryLocation getForDest(/*const*/ MemIntrinsic /*P*/ MTI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return a location representing a particular argument of a call.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::getForArgument">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp", line = 93,
   FQN="llvm::MemoryLocation::getForArgument", NM="_ZN4llvm14MemoryLocation14getForArgumentENS_17ImmutableCallSiteEjRKNS_17TargetLibraryInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocation14getForArgumentENS_17ImmutableCallSiteEjRKNS_17TargetLibraryInfoE")
  //</editor-fold>
  public static MemoryLocation getForArgument(ImmutableCallSite CS, 
                /*uint*/int ArgIdx, 
                final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::MemoryLocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 95,
   FQN="llvm::MemoryLocation::MemoryLocation", NM="_ZN4llvm14MemoryLocationC1EPKNS_5ValueEyRKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocationC1EPKNS_5ValueEyRKNS_9AAMDNodesE")
  //</editor-fold>
  public /*explicit*/ MemoryLocation() {
    this((/*const*/ Value /*P*/ )null, 
      UnknownSize, 
      new AAMDNodes());
  }
  public /*explicit*/ MemoryLocation(/*const*/ Value /*P*/ Ptr/*= null*/) {
    this(Ptr, 
      UnknownSize, 
      new AAMDNodes());
  }
  public /*explicit*/ MemoryLocation(/*const*/ Value /*P*/ Ptr/*= null*/, 
      long/*uint64_t*/ Size/*= UnknownSize*/) {
    this(Ptr, 
      Size, 
      new AAMDNodes());
  }
  public /*explicit*/ MemoryLocation(/*const*/ Value /*P*/ Ptr/*= null*/, 
      long/*uint64_t*/ Size/*= UnknownSize*/, 
      final /*const*/ AAMDNodes /*&*/ AATags/*= AAMDNodes()*/) {
    // : Ptr(Ptr), Size(Size), AATags(AATags) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::getWithNewPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 100,
   FQN="llvm::MemoryLocation::getWithNewPtr", NM="_ZNK4llvm14MemoryLocation13getWithNewPtrEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZNK4llvm14MemoryLocation13getWithNewPtrEPKNS_5ValueE")
  //</editor-fold>
  public MemoryLocation getWithNewPtr(/*const*/ Value /*P*/ NewPtr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::getWithNewSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 106,
   FQN="llvm::MemoryLocation::getWithNewSize", NM="_ZNK4llvm14MemoryLocation14getWithNewSizeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZNK4llvm14MemoryLocation14getWithNewSizeEy")
  //</editor-fold>
  public MemoryLocation getWithNewSize(long/*uint64_t*/ NewSize) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::getWithoutAATags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 112,
   FQN="llvm::MemoryLocation::getWithoutAATags", NM="_ZNK4llvm14MemoryLocation16getWithoutAATagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZNK4llvm14MemoryLocation16getWithoutAATagsEv")
  //</editor-fold>
  public MemoryLocation getWithoutAATags() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 118,
   FQN="llvm::MemoryLocation::operator==", NM="_ZNK4llvm14MemoryLocationeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZNK4llvm14MemoryLocationeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ MemoryLocation /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::MemoryLocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 40,
   FQN="llvm::MemoryLocation::MemoryLocation", NM="_ZN4llvm14MemoryLocationC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocationC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MemoryLocation(final /*const*/ MemoryLocation /*&*/ $Prm0) {
    // : Ptr(.Ptr), Size(.Size), AATags(.AATags) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::MemoryLocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 40,
   FQN="llvm::MemoryLocation::MemoryLocation", NM="_ZN4llvm14MemoryLocationC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryLocation.cpp -nm=_ZN4llvm14MemoryLocationC1EOS0_")
  //</editor-fold>
  public /*inline*/ MemoryLocation(JD$Move _dparam, final MemoryLocation /*&&*/$Prm0) {
    // : Ptr(static_cast<MemoryLocation &&>().Ptr), Size(static_cast<MemoryLocation &&>().Size), AATags(static_cast<MemoryLocation &&>().AATags) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 40,
   FQN="llvm::MemoryLocation::operator=", NM="_ZN4llvm14MemoryLocationaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm14MemoryLocationaSERKS0_")
  //</editor-fold>
  public /*inline*/ MemoryLocation /*&*/ $assign(final /*const*/ MemoryLocation /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryLocation::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryLocation.h", line = 40,
   FQN="llvm::MemoryLocation::operator=", NM="_ZN4llvm14MemoryLocationaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm14MemoryLocationaSEOS0_")
  //</editor-fold>
  public /*inline*/ MemoryLocation /*&*/ $assignMove(final MemoryLocation /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr // NOI18N
              + ", Size=" + Size // NOI18N
              + ", AATags=" + AATags; // NOI18N
  }
}
