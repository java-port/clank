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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.java.*;


// This CallbackVH updates its ValueMap when the contained Value changes,
// according to the user's preferences expressed through the Config object.
/*template <typename KeyT, typename ValueT, typename Config> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMapCallbackVH">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 236,
 FQN="llvm::ValueMapCallbackVH", NM="_ZN4llvm18ValueMapCallbackVHE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm18ValueMapCallbackVHE")
//</editor-fold>
public final class ValueMapCallbackVH</*typename*/ KeyT, /*typename*/ ValueT/*, typename Config*/>  extends /*public*/ CallbackVH implements Unwrap<KeyT>, Destructors.ClassWithDestructor {
  /*friend  class ValueMap<KeyT, ValueT, Config>*/
  /*friend  struct DenseMapInfo<ValueMapCallbackVH<KeyT, ValueT, Config> >*/
  // JAVA: typedef ValueMap<KeyT, ValueT, Config> ValueMapT
//  public final class ValueMapT extends ValueMap<KeyT, ValueT>{ };
  // JAVA: typedef typename std::remove_pointer<KeyT>::type KeySansPointerT
//  public final class KeySansPointerT extends  KeyT{ };
  
  private ValueMap<KeyT, ValueT>/*P*/ Map;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapCallbackVH::ValueMapCallbackVH<KeyT, ValueT, Config>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 245,
   FQN="llvm::ValueMapCallbackVH::ValueMapCallbackVH<KeyT, ValueT, Config>", NM="_ZN4llvm18ValueMapCallbackVHC1ET_PNS_8ValueMapIS1_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm18ValueMapCallbackVHC1ET_PNS_8ValueMapIS1_T0_T1_EE")
  //</editor-fold>
  /*friend*/public/*private*/ ValueMapCallbackVH(KeyT Key, ValueMap<KeyT, ValueT>/*P*/ Map) {
    // : CallbackVH(const_cast<Value * >(static_cast<const Value * >(Key))), Map(Map) 
    //START JInit
    /*ParenListExpr*/super(((/*const_cast*/Value /*P*/ )(((/*static_cast*//*const*/ Value /*P*/ )(Key)))));
    this.Map = /*ParenListExpr*/Map;
    //END JInit
  }

  
  // Private constructor used to create empty/tombstone DenseMap keys.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapCallbackVH::ValueMapCallbackVH<KeyT, ValueT, Config>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 250,
   FQN="llvm::ValueMapCallbackVH::ValueMapCallbackVH<KeyT, ValueT, Config>", NM="_ZN4llvm18ValueMapCallbackVHC1EPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm18ValueMapCallbackVHC1EPNS_5ValueE")
  //</editor-fold>
  /*friend*/public/*private*/ ValueMapCallbackVH(Value /*P*/ V) {
    // : CallbackVH(V), Map(null) 
    //START JInit
    /*ParenListExpr*/super(V);
    this.Map = /*ParenListExpr*/null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapCallbackVH::Unwrap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 253,
   FQN="llvm::ValueMapCallbackVH::Unwrap", NM="_ZNK4llvm18ValueMapCallbackVH6UnwrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm18ValueMapCallbackVH6UnwrapEv")
  //</editor-fold>
  public KeyT Unwrap() /*const*/ {
    return cast_or_null(Map.Config.cls, getValPtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapCallbackVH::deleted">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 255,
   FQN="llvm::ValueMapCallbackVH::deleted", NM="_ZN4llvm18ValueMapCallbackVH7deletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm18ValueMapCallbackVH7deletedEv")
  //</editor-fold>
  @Override public void deleted()/* override*/ {
    ValueMapCallbackVH<KeyT, ValueT> Copy = null;
    try {
      // Make a copy that won't get changed even when *this is destroyed.
      Copy/*J*/= /*ParenList*/new ValueMapCallbackVH<KeyT, ValueT>(/*Deref*/this);
      Object  /*P*/ M = Map.Config.getMutex(Copy.Map.Data);
      unique_lock<Object/*Config.mutex_type*/> Guard;
      if (M != null) {
        Guard = new unique_lock($Deref(M));
      }
      Map.Config.onDelete(Copy.Map.Data, Copy.Unwrap()); // May destroy *this.
      Copy.Map.Map.erase(Copy); // Definitely destroys *this.
    } finally {
      if (Copy != null) { Copy.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapCallbackVH::allUsesReplacedWith">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 265,
   FQN="llvm::ValueMapCallbackVH::allUsesReplacedWith", NM="_ZN4llvm18ValueMapCallbackVH19allUsesReplacedWithEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm18ValueMapCallbackVH19allUsesReplacedWithEPNS_5ValueE")
  //</editor-fold>
  @Override public void allUsesReplacedWith(Value /*P*/ new_key)/* override*/ {
    ValueMapCallbackVH<KeyT, ValueT> Copy = null;
    try {
      assert Native.$bool(isa(Map.Config.cls, new_key)) : "Invalid RAUW on key of ValueMap<>";
      // Make a copy that won't get changed even when *this is destroyed.
      Copy/*J*/= /*ParenList*/new ValueMapCallbackVH<KeyT, ValueT>(/*Deref*/this);
       Object/*Config.mutex_type*/ /*P*/ M = Map.Config.getMutex(Copy.Map.Data);
      unique_lock< Object/*Config.mutex_type*/> Guard;
      if (M != null) {
        Guard = new unique_lock($Deref(M));
      }
      
      KeyT typed_new_key = cast(Map.Config.cls, new_key);
      // Can destroy *this:
      Map.Config.onRAUW(Copy.Map.Data, Copy.Unwrap(), typed_new_key);
      if (Map.Config.FollowRAUW) {
         DenseMapIterator<ValueMapCallbackVH<KeyT, ValueT>, ValueT> I = Copy.Map.Map.find(Copy);
        // I could == Copy.Map->Map.end() if the onRAUW callback already
        // removed the old mapping.
        if (Native.$noteq(I, Copy.Map.Map.end())) {
          ValueT Target/*J*/= /*ParenList*/$tryMove(std.move(I.$arrow().second));
          Copy.Map.Map.erase(I); // Definitely destroys *this.
          Copy.Map.insert_pair$KeyT$ValueT(std.make_pair(typed_new_key, std.move(Target)));
        }
      }
    } finally {
      if (Copy != null) { Copy.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ValueMapCallbackVH(ValueMapCallbackVH</*typename*/ KeyT, /*typename*/ ValueT/*, typename Config*/>  Other) {
    this.Map = Other.Map;
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Map=" + Map // NOI18N
              + super.toString(); // NOI18N
  }
}
