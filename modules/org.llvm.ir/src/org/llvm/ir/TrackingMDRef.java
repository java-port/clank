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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clank.support.aliases.type$ptr;


/// \brief Tracking metadata reference.
///
/// This class behaves like \a TrackingVH, but for metadata.
//<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 24,
 FQN="llvm::TrackingMDRef", NM="_ZN4llvm13TrackingMDRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefE")
//</editor-fold>
public class TrackingMDRef implements Destructors.ClassWithDestructor, Native.NativeComparable<TrackingMDRef>, NativePOD<TrackingMDRef> {
  private Metadata /*P*/ MD;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::TrackingMDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 28,
   FQN="llvm::TrackingMDRef::TrackingMDRef", NM="_ZN4llvm13TrackingMDRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefC1Ev")
  //</editor-fold>
  public TrackingMDRef() {
    // : MD(null) 
    //START JInit
    this.MD = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::TrackingMDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 29,
   FQN="llvm::TrackingMDRef::TrackingMDRef", NM="_ZN4llvm13TrackingMDRefC1EPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefC1EPNS_8MetadataE")
  //</editor-fold>
  public /*explicit*/ TrackingMDRef(Metadata /*P*/ MD) {
    // : MD(MD) 
    //START JInit
    this.MD = MD;
    //END JInit
    track();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::TrackingMDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 31,
   FQN="llvm::TrackingMDRef::TrackingMDRef", NM="_ZN4llvm13TrackingMDRefC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefC1EOS0_")
  //</editor-fold>
  public TrackingMDRef(JD$Move _dparam, final TrackingMDRef /*&&*/X) {
    // : MD(X.MD) 
    //START JInit
    this.MD = X.MD;
    //END JInit
    retrack(X);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::TrackingMDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 32,
   FQN="llvm::TrackingMDRef::TrackingMDRef", NM="_ZN4llvm13TrackingMDRefC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefC1ERKS0_")
  //</editor-fold>
  public TrackingMDRef(final /*const*/ TrackingMDRef /*&*/ X) {
    // : MD(X.MD) 
    //START JInit
    this.MD = X.MD;
    //END JInit
    track();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 33,
   FQN="llvm::TrackingMDRef::operator=", NM="_ZN4llvm13TrackingMDRefaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefaSEOS0_")
  //</editor-fold>
  public TrackingMDRef /*&*/ $assignMove(final TrackingMDRef /*&&*/X) {
    if (/*AddrOf*/X == this) {
      return /*Deref*/this;
    }
    
    untrack();
    MD = X.MD;
    retrack(X);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 42,
   FQN="llvm::TrackingMDRef::operator=", NM="_ZN4llvm13TrackingMDRefaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefaSERKS0_")
  //</editor-fold>
  public TrackingMDRef /*&*/ $assign(final /*const*/ TrackingMDRef /*&*/ X) {
    if (/*AddrOf*/X == this) {
      return /*Deref*/this;
    }
    
    untrack();
    MD = X.MD;
    track();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::~TrackingMDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 51,
   FQN="llvm::TrackingMDRef::~TrackingMDRef", NM="_ZN4llvm13TrackingMDRefD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRefD0Ev")
  //</editor-fold>
  public void $destroy() {
    untrack();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 53,
   FQN="llvm::TrackingMDRef::get", NM="_ZNK4llvm13TrackingMDRef3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRef3getEv")
  //</editor-fold>
  public Metadata /*P*/ get() /*const*/ {
    return MD;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator Metadata * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 54,
   FQN="llvm::TrackingMDRef::operator Metadata * ", NM="_ZNK4llvm13TrackingMDRefcvPNS_8MetadataEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRefcvPNS_8MetadataEEv")
  //</editor-fold>
  public Metadata /*P*/ $Metadata$P() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 55,
   FQN="llvm::TrackingMDRef::operator->", NM="_ZNK4llvm13TrackingMDRefptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRefptEv")
  //</editor-fold>
  public Metadata /*P*/ $arrow() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 56,
   FQN="llvm::TrackingMDRef::operator*", NM="_ZNK4llvm13TrackingMDRefdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRefdeEv")
  //</editor-fold>
  public Metadata /*&*/ $star() /*const*/ {
    return /*Deref*/get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 58,
   FQN="llvm::TrackingMDRef::reset", NM="_ZN4llvm13TrackingMDRef5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRef5resetEv")
  //</editor-fold>
  public void reset() {
    untrack();
    MD = null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 62,
   FQN="llvm::TrackingMDRef::reset", NM="_ZN4llvm13TrackingMDRef5resetEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRef5resetEPNS_8MetadataE")
  //</editor-fold>
  public void reset(Metadata /*P*/ MD) {
    untrack();
    this.MD = MD;
    track();
  }

  
  /// \brief Check whether this has a trivial destructor.
  ///
  /// If \c MD isn't replaceable, the destructor will be a no-op.
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::hasTrivialDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 71,
   FQN="llvm::TrackingMDRef::hasTrivialDestructor", NM="_ZNK4llvm13TrackingMDRef20hasTrivialDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRef20hasTrivialDestructorEv")
  //</editor-fold>
  public boolean hasTrivialDestructor() /*const*/ {
    return !(MD != null) || !MetadataTracking.isReplaceable(/*Deref*/MD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 75,
   FQN="llvm::TrackingMDRef::operator==", NM="_ZNK4llvm13TrackingMDRefeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRefeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ TrackingMDRef /*&*/ X) /*const*/ {
    return MD == X.MD;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 76,
   FQN="llvm::TrackingMDRef::operator!=", NM="_ZNK4llvm13TrackingMDRefneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TrackingMDRefneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ TrackingMDRef /*&*/ X) /*const*/ {
    return MD != X.MD;
  }

/*private:*/
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::track">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 79,
   FQN="llvm::TrackingMDRef::track", NM="_ZN4llvm13TrackingMDRef5trackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRef5trackEv")
  //</editor-fold>
  private void track() {
    if ((MD != null)) {
      MetadataTracking.track(MD$Ptr);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::untrack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 83,
   FQN="llvm::TrackingMDRef::untrack", NM="_ZN4llvm13TrackingMDRef7untrackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRef7untrackEv")
  //</editor-fold>
  private void untrack() {
    if ((MD != null)) {
      MetadataTracking.untrack(MD$Ptr);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingMDRef::retrack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 87,
   FQN="llvm::TrackingMDRef::retrack", NM="_ZN4llvm13TrackingMDRef7retrackERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TrackingMDRef7retrackERS0_")
  //</editor-fold>
  private void retrack(final TrackingMDRef /*&*/ X) {
    assert (MD == X.MD) : "Expected values to match";
    if ((X.MD != null)) {
      MetadataTracking.retrack(X.MD$Ptr, MD$Ptr);
      X.MD = (null);
    }
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public TrackingMDRef clone() {
      return new TrackingMDRef(this);
  }
  
  private final type$ptr<Metadata/*P*/> /*P*/ MD$Ptr = new type$ptr$inout<Metadata/*P*/>() {
    @Override
    protected Metadata/*P*/ $star$impl() {
      return MD;
    }

    @Override
    protected Metadata/*P*/ $set$impl(Metadata/*P*/ value) {
      return MD = value;
    }
    
    @Override
    public type$ptr$inout<Metadata> clone() {
      assert false : "why was cloned?";
      return this;
    }    
  };
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "MD=" + MD; // NOI18N
  }
}
