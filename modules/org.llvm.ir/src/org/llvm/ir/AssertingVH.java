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
import static org.clank.support.Native.*;
import org.llvm.ir.*;


/// \brief Value handle that asserts if the Value is deleted.
///
/// This is a Value Handle that points to a value and asserts out if the value
/// is destroyed while the handle is still live.  This is very useful for
/// catching dangling pointer bugs and other things which can be non-obvious.
/// One particularly useful place to use this is as the Key of a map.  Dangling
/// pointer bugs often lead to really subtle bugs that only occur if another
/// object happens to get allocated to the same address as the old one.  Using
/// an AssertingVH ensures that an assert is triggered as soon as the bad
/// delete occurs.
///
/// Note that an AssertingVH handle does *not* follow values across RAUW
/// operations.  This means that RAUW's need to explicitly update the
/// AssertingVH's as it moves.  This is required because in non-assert mode this
/// class turns into a trivial wrapper around a pointer.
/*template <typename ValueTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 192,
 FQN="llvm::AssertingVH", NM="_ZN4llvm11AssertingVHE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVHE")
//</editor-fold>
public class AssertingVH</*typename*/ ValueTy extends Value>  extends /*public*/ ValueHandleBase implements Destructors.ClassWithDestructor {
  /*friend  struct DenseMapInfo<AssertingVH<ValueTy> >*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::getRawValPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 201,
   FQN="llvm::AssertingVH::getRawValPtr", NM="_ZNK4llvm11AssertingVH12getRawValPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm11AssertingVH12getRawValPtrEv")
  //</editor-fold>
  /*private*//*friend*//*private*/ Value /*P*/ getRawValPtr() /*const*/ {
    return super.getValPtr();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::setRawValPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 202,
   FQN="llvm::AssertingVH::setRawValPtr", NM="_ZN4llvm11AssertingVH12setRawValPtrEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVH12setRawValPtrEPNS_5ValueE")
  //</editor-fold>
  private void setRawValPtr(Value /*P*/ P) {
    super.$assign(P);
  }

  // Convert a ValueTy*, which may be const, to the raw Value*.
  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::GetAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 209,
   FQN="llvm::AssertingVH::GetAsValue", NM="_ZN4llvm11AssertingVH10GetAsValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVH10GetAsValueEPNS_5ValueE")
  //</editor-fold>
  private static </*typename*/ ValueTy> Value /*P*/ GetAsValue_Value$P(Value /*P*/ V) {
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::GetAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 210,
   FQN="llvm::AssertingVH::GetAsValue", NM="_ZN4llvm11AssertingVH10GetAsValueEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVH10GetAsValueEPKNS_5ValueE")
  //</editor-fold>
  private static </*typename*/ ValueTy> Value /*P*/ GetAsValue_Value$C$P(/*const*/ Value /*P*/ V) {
    return ((/*const_cast*/Value /*P*/ )(V));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::getValPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 212,
   FQN="llvm::AssertingVH::getValPtr", NM="_ZNK4llvm11AssertingVH9getValPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm11AssertingVH9getValPtrEv")
  //</editor-fold>
  private ValueTy /*P*/ getValPtr_AssertingVH() /*const*/ {
    return ((/*static_cast*/ValueTy /*P*/ )(getRawValPtr()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::setValPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 213,
   FQN="llvm::AssertingVH::setValPtr", NM="_ZN4llvm11AssertingVH9setValPtrEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVH9setValPtrEPT_")
  //</editor-fold>
  private void setValPtr(Value /*P*/ P) {
    setRawValPtr(GetAsValue_Value$C$P(P));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::AssertingVH<ValueTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 217,
   FQN="llvm::AssertingVH::AssertingVH<ValueTy>", NM="_ZN4llvm11AssertingVHC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVHC1Ev")
  //</editor-fold>
  public AssertingVH() {
    // : ValueHandleBase(Assert)
    //START JInit
    /*ParenListExpr*/super(HandleBaseKind.Assert);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::AssertingVH<ValueTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 218,
   FQN="llvm::AssertingVH::AssertingVH<ValueTy>", NM="_ZN4llvm11AssertingVHC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVHC1EPT_")
  //</editor-fold>
  public AssertingVH(ValueTy /*P*/ P) {
    // : ValueHandleBase(Assert, GetAsValue(P))
    //START JInit
    /*ParenListExpr*/super(HandleBaseKind.Assert, GetAsValue_Value$C$P(P));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::AssertingVH<ValueTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 219,
   FQN="llvm::AssertingVH::AssertingVH<ValueTy>", NM="_ZN4llvm11AssertingVHC1ERKNS_11AssertingVHIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVHC1ERKNS_11AssertingVHIT_EE")
  //</editor-fold>
  public AssertingVH(final /*const*/ AssertingVH<ValueTy> /*&*/ RHS) {
    // : ValueHandleBase(Assert, RHS)
    //START JInit
    /*ParenListExpr*/super(HandleBaseKind.Assert, RHS);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::operator type-parameter-0-0 * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 225,
   FQN="llvm::AssertingVH::operator type-parameter-0-0 * ", NM="_ZNK4llvm11AssertingVHcvPT_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm11AssertingVHcvPT_Ev")
  //</editor-fold>
  public ValueTy /*P*/ $T$P() /*const*/ {
    return getValPtr_AssertingVH();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 229,
   FQN="llvm::AssertingVH::operator=", NM="_ZN4llvm11AssertingVHaSEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVHaSEPT_")
  //</editor-fold>
  public ValueTy /*P*/ $assign_ValueTy(ValueTy /*P*/ RHS) {
    setValPtr(RHS);
    return getValPtr_AssertingVH();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 233,
   FQN="llvm::AssertingVH::operator=", NM="_ZN4llvm11AssertingVHaSERKNS_11AssertingVHIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm11AssertingVHaSERKNS_11AssertingVHIT_EE")
  //</editor-fold>
  public ValueTy /*P*/ $assign_AssertingVH(final /*const*/ AssertingVH<ValueTy> /*&*/ RHS) {
    setValPtr(RHS.getValPtr());
    return getValPtr_AssertingVH();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 238,
   FQN="llvm::AssertingVH::operator->", NM="_ZNK4llvm11AssertingVHptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm11AssertingVHptEv")
  //</editor-fold>
  public ValueTy /*P*/ $arrow_AssertingVH() /*const*/ {
    return getValPtr_AssertingVH();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssertingVH::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 239,
   FQN="llvm::AssertingVH::operator*", NM="_ZNK4llvm11AssertingVHdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm11AssertingVHdeEv")
  //</editor-fold>
  public ValueTy /*&*/ $star_AssertingVH() /*const*/ {
    return $Deref(getValPtr_AssertingVH());
  }

  @Override
  public AssertingVH<ValueTy> clone() {
    return new AssertingVH<>(this);
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
