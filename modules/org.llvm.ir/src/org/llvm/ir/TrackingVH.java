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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;


/// \brief Value handle that tracks a Value across RAUW.
///
/// TrackingVH is designed for situations where a client needs to hold a handle
/// to a Value (or subclass) across some operations which may move that value,
/// but should never destroy it or replace it with some unacceptable type.
///
/// It is an error to do anything with a TrackingVH whose value has been
/// destroyed, except to destruct it.
///
/// It is an error to attempt to replace a value with one of a type which is
/// incompatible with any of its outstanding TrackingVHs.
/*template <typename ValueTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 285,
 FQN="llvm::TrackingVH", NM="_ZN4llvm10TrackingVHE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVHE")
//</editor-fold>
public class TrackingVH</*typename*/ ValueTy extends Value>  extends /*public*/ ValueHandleBase implements Native.assignable<TrackingVH>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::CheckValidity">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 287,
   FQN="llvm::TrackingVH::CheckValidity", NM="_ZNK4llvm10TrackingVH13CheckValidityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm10TrackingVH13CheckValidityEv")
  //</editor-fold>
  private void CheckValidity() /*const*/ {
    Value /*P*/ VP = super.getValPtr();
    
    // Null is always ok.
    if (!(VP != null)) {
      return;
    }
    
    // Check that this value is valid (i.e., it hasn't been deleted). We
    // explicitly delay this check until access to avoid requiring clients to be
    // unnecessarily careful w.r.t. destruction.
    assert (ValueHandleBase.isValid(VP)) : "Tracked Value was deleted!";
    
    // Check that the value is a member of the correct subclass. We would like
    // to check this property on assignment for better debugging, but we don't
    // want to require a virtual interface on this VH. Instead we allow RAUW to
    // replace this value with a value of an invalid type, and check it here.
    assert Native.$bool(isa(Value$Class, VP)) : "Tracked Value was replaced by one with an invalid type!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::getValPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 306,
   FQN="llvm::TrackingVH::getValPtr", NM="_ZNK4llvm10TrackingVH9getValPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm10TrackingVH9getValPtrEv")
  //</editor-fold>
  /*friend*/protected/*private*/ ValueTy /*P*/ getValPtr() /*const*/ {
    CheckValidity();
    return (ValueTy /*P*/ )super.getValPtr();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::setValPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 310,
   FQN="llvm::TrackingVH::setValPtr", NM="_ZN4llvm10TrackingVH9setValPtrEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVH9setValPtrEPT_")
  //</editor-fold>
  private void setValPtr(ValueTy /*P*/ P) {
    CheckValidity();
    super.$assign(GetAsValue_Value$P(P));
  }

  
  // Convert a ValueTy*, which may be const, to the type the base
  // class expects.
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::GetAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 317,
   FQN="llvm::TrackingVH::GetAsValue", NM="_ZN4llvm10TrackingVH10GetAsValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVH10GetAsValueEPNS_5ValueE")
  //</editor-fold>
  private static </*typename*/ ValueTy> Value /*P*/ GetAsValue_Value$P(Value /*P*/ V) {
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::GetAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 318,
   FQN="llvm::TrackingVH::GetAsValue", NM="_ZN4llvm10TrackingVH10GetAsValueEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVH10GetAsValueEPKNS_5ValueE")
  //</editor-fold>
  private static </*typename*/ ValueTy> Value /*P*/ GetAsValue_Value$C$P(/*const*/ Value /*P*/ V) {
    return ((/*const_cast*/Value /*P*/ )(V));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::TrackingVH<ValueTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 321,
   FQN="llvm::TrackingVH::TrackingVH<ValueTy>", NM="_ZN4llvm10TrackingVHC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVHC1Ev")
  //</editor-fold>
  public TrackingVH(Class<ValueTy> ValueTy$Class) {
    // : ValueHandleBase(Tracking) 
    //START JInit
    /*ParenListExpr*/super(HandleBaseKind.Tracking);
    //END JInit
    this.Value$Class = ValueTy$Class;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::TrackingVH<ValueTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 322,
   FQN="llvm::TrackingVH::TrackingVH<ValueTy>", NM="_ZN4llvm10TrackingVHC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVHC1EPT_")
  //</editor-fold>
  public TrackingVH(Class<ValueTy> ValueTy$Class, ValueTy /*P*/ P) {
    // : ValueHandleBase(Tracking, GetAsValue(P)) 
    //START JInit
    /*ParenListExpr*/super(HandleBaseKind.Tracking, GetAsValue_Value$P(P));
    //END JInit
    this.Value$Class = ValueTy$Class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::operator type-parameter-0-0 * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 324,
   FQN="llvm::TrackingVH::operator type-parameter-0-0 * ", NM="_ZNK4llvm10TrackingVHcvPT_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm10TrackingVHcvPT_Ev")
  //</editor-fold>
  public ValueTy /*P*/ $T$P() /*const*/ {
    return getValPtr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 328,
   FQN="llvm::TrackingVH::operator=", NM="_ZN4llvm10TrackingVHaSEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10TrackingVHaSEPT_")
  //</editor-fold>
  public ValueTy /*P*/ $assign_TrackingVH(ValueTy /*P*/ RHS) {
    setValPtr(RHS);
    return getValPtr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 333,
   FQN="llvm::TrackingVH::operator->", NM="_ZNK4llvm10TrackingVHptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm10TrackingVHptEv")
  //</editor-fold>
  public ValueTy /*P*/ $arrow() /*const*/ {
    return getValPtr();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TrackingVH::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 334,
   FQN="llvm::TrackingVH::operator*", NM="_ZNK4llvm10TrackingVHdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm10TrackingVHdeEv")
  //</editor-fold>
  public ValueTy /*&*/ $star() /*const*/ {
    return /*Deref*/getValPtr();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public TrackingVH $assign(TrackingVH $Prm0) {
    super.$assign($Prm0.$T$P());
    return this;
  }

  @Override
  public TrackingVH clone() {
    return new TrackingVH(Value$Class, this.$T$P());
  }

  private final Class<ValueTy> Value$Class;
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
