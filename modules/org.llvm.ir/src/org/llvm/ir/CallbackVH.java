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
import org.llvm.ir.*;


/// \brief Value handle with callbacks on RAUW and destruction.
///
/// This is a value handle that allows subclasses to define callbacks that run
/// when the underlying Value has RAUW called on it or is destroyed.  This
/// class can be used as the key of a map, as long as the user takes it out of
/// the map before calling setValPtr() (since the map has to rearrange itself
/// when the pointer changes).  Unlike ValueHandleBase, this class has a vtable.
//<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 344,
 FQN="llvm::CallbackVH", NM="_ZN4llvm10CallbackVHE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVHE")
//</editor-fold>
public class CallbackVH extends /*public*/ ValueHandleBase implements Destructors.ClassWithDestructor {
  
  // Pin the vtable to this file.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 883,
   FQN="llvm::CallbackVH::anchor", NM="_ZN4llvm10CallbackVH6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVH6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::~CallbackVH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 347,
   FQN="llvm::CallbackVH::~CallbackVH", NM="_ZN4llvm10CallbackVHD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm10CallbackVHD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::CallbackVH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 348,
   FQN="llvm::CallbackVH::CallbackVH", NM="_ZN4llvm10CallbackVHC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm10CallbackVHC1ERKS0_")
  //</editor-fold>
  protected CallbackVH(final /*const*/ CallbackVH /*&*/ $Prm0) {
    // : ValueHandleBase()/* = default*/ 
    //START JInit
    super($Prm0);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 349,
   FQN="llvm::CallbackVH::operator=", NM="_ZN4llvm10CallbackVHaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm10CallbackVHaSERKS0_")
  //</editor-fold>
  protected CallbackVH /*&*/ $assign(final /*const*/ CallbackVH /*&*/ $Prm0)/* = default*/ {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::setValPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 351,
   FQN="llvm::CallbackVH::setValPtr", NM="_ZN4llvm10CallbackVH9setValPtrEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVH9setValPtrEPNS_5ValueE")
  //</editor-fold>
  protected void setValPtr(Value /*P*/ P) {
    super.$assign(P);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::CallbackVH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 356,
   FQN="llvm::CallbackVH::CallbackVH", NM="_ZN4llvm10CallbackVHC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVHC1Ev")
  //</editor-fold>
  public CallbackVH() {
    // : ValueHandleBase(Callback) 
    //START JInit
    super(HandleBaseKind.Callback);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::CallbackVH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 357,
   FQN="llvm::CallbackVH::CallbackVH", NM="_ZN4llvm10CallbackVHC1EPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVHC1EPNS_5ValueE")
  //</editor-fold>
  public CallbackVH(Value /*P*/ P) {
    // : ValueHandleBase(Callback, P) 
    //START JInit
    super(HandleBaseKind.Callback, P);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::operator Value * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 359,
   FQN="llvm::CallbackVH::operator Value * ", NM="_ZNK4llvm10CallbackVHcvPNS_5ValueEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZNK4llvm10CallbackVHcvPNS_5ValueEEv")
  //</editor-fold>
  public Value /*P*/ $Value$P() /*const*/ {
    return getValPtr();
  }

  
  /// \brief Callback for Value destruction.
  ///
  /// Called when this->getValPtr() is destroyed, inside ~Value(), so you
  /// may call any non-virtual Value method on getValPtr(), but no subclass
  /// methods.  If WeakVH were implemented as a CallbackVH, it would use this
  /// method to call setValPtr(NULL).  AssertingVH would use this method to
  /// cause an assertion failure.
  ///
  /// All implementations must remove the reference from this object to the
  /// Value that's being destroyed.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::deleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 373,
   FQN="llvm::CallbackVH::deleted", NM="_ZN4llvm10CallbackVH7deletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVH7deletedEv")
  //</editor-fold>
  public /*virtual*/ void deleted() {
    setValPtr((Value /*P*/ )null);
  }

  
  /// \brief Callback for Value RAUW.
  ///
  /// Called when this->getValPtr()->replaceAllUsesWith(new_value) is called,
  /// _before_ any of the uses have actually been replaced.  If WeakVH were
  /// implemented as a CallbackVH, it would use this method to call
  /// setValPtr(new_value).  AssertingVH would do nothing in this method.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallbackVH::allUsesReplacedWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueHandle.h", line = 381,
   FQN="llvm::CallbackVH::allUsesReplacedWith", NM="_ZN4llvm10CallbackVH19allUsesReplacedWithEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm10CallbackVH19allUsesReplacedWithEPNS_5ValueE")
  //</editor-fold>
  public /*virtual*/ void allUsesReplacedWith(Value /*P*/ $Prm0) {
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
