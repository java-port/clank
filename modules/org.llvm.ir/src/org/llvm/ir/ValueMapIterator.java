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
import org.llvm.adt.aliases.*;
import org.llvm.ir.java.Unwrap;

/*template <typename DenseMapT, typename KeyT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 316,
 FQN="llvm::ValueMapIterator", NM="_ZN4llvm16ValueMapIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIteratorE")
//</editor-fold>
public class ValueMapIterator</*typename*/ DenseMapT extends DenseMap<?,?>, /*typename*/ KeyT>  implements /*public*/ std.iterator/*<std.forward_iterator_tag, std.pair<KeyT,  DenseMapT.mapped_type>, int>*/, Native.NativeComparable<ValueMapIterator> {
  // JAVA: typedef typename DenseMapT::iterator BaseT
//  public final class BaseT extends  DenseMapT.iterator{ };
  // JAVA: typedef typename DenseMapT::mapped_type ValueT
//  public final class ValueT extends  DenseMapT.mapped_type{ };
  private  DenseMapIterator<KeyT, ?> I;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::ValueMapIterator<DenseMapT, KeyT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 325,
   FQN="llvm::ValueMapIterator::ValueMapIterator<DenseMapT, KeyT>", NM="_ZN4llvm16ValueMapIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIteratorC1Ev")
  //</editor-fold>
  public ValueMapIterator() {
    // : I() 
    //START JInit
    this.I = /*ParenListExpr*/new  DenseMapIterator();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::ValueMapIterator<DenseMapT, KeyT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 327,
   FQN="llvm::ValueMapIterator::ValueMapIterator<DenseMapT, KeyT>", NM="_ZN4llvm16ValueMapIteratorC1ENT_8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIteratorC1ENT_8iteratorE")
  //</editor-fold>
  public ValueMapIterator( DenseMapIterator I) {
    // : I(I) 
    //START JInit
    this.I = /*ParenListExpr*/new  DenseMapIterator(I);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::base">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 329,
   FQN="llvm::ValueMapIterator::base", NM="_ZNK4llvm16ValueMapIterator4baseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm16ValueMapIterator4baseEv")
  //</editor-fold>
  public  DenseMapIterator base() /*const*/ {
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::ValueTypeProxy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 331,
   FQN="llvm::ValueMapIterator::ValueTypeProxy", NM="_ZN4llvm16ValueMapIterator14ValueTypeProxyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIterator14ValueTypeProxyE")
  //</editor-fold>
  public static class/*struct*/ ValueTypeProxy<KeyT, ValueT> {
    public /*const*/ KeyT first;
    public final  ValueT /*&*/ second;
    //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::ValueTypeProxy::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 334,
     FQN="llvm::ValueMapIterator::ValueTypeProxy::operator->", NM="_ZN4llvm16ValueMapIterator14ValueTypeProxyptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIterator14ValueTypeProxyptEv")
    //</editor-fold>
    public ValueTypeProxy /*P*/ $arrow() {
      return this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::ValueTypeProxy::operator pair<type-parameter-0-1,  type-parameter-0-0::mapped_type>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 335,
     FQN="llvm::ValueMapIterator::ValueTypeProxy::operator pair<type-parameter-0-1,  type-parameter-0-0::mapped_type>", NM="_ZNK4llvm16ValueMapIterator14ValueTypeProxycvSt4pairIT0_NT_11mapped_typeEEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm16ValueMapIterator14ValueTypeProxycvSt4pairIT0_NT_11mapped_typeEEEv")
    //</editor-fold>
    public std.pair<KeyT,  ValueT> $pair$KeyT$mapped_type() /*const*/ {
      return std.make_pair(first, second);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ValueTypeProxy() {
      this.first = null;
      this.second = null;
    }

    public ValueTypeProxy(KeyT first, ValueT second) {
      this.first = first;
      this.second = second;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "first=" + first // NOI18N
                + ", second=" + second; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 340,
   FQN="llvm::ValueMapIterator::operator*", NM="_ZNK4llvm16ValueMapIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm16ValueMapIteratordeEv")
  //</editor-fold>
  public ValueTypeProxy $star() /*const*/ {
    Unwrap<KeyT> first = (Unwrap<KeyT>)I.$star().first;
    ValueTypeProxy Result = new ValueTypeProxy(first.Unwrap(), I.$star().second);//((void)I.first.Unwrap(), I.second);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 345,
   FQN="llvm::ValueMapIterator::operator->", NM="_ZNK4llvm16ValueMapIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm16ValueMapIteratorptEv")
  //</editor-fold>
  public ValueTypeProxy $arrow() /*const*/ {
    return $star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 349,
   FQN="llvm::ValueMapIterator::operator==", NM="_ZNK4llvm16ValueMapIteratoreqERKNS_16ValueMapIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm16ValueMapIteratoreqERKNS_16ValueMapIteratorIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ValueMapIterator<DenseMapT, KeyT> /*&*/ RHS) /*const*/ {
    return Native.$eq(I, RHS.I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 352,
   FQN="llvm::ValueMapIterator::operator!=", NM="_ZNK4llvm16ValueMapIteratorneERKNS_16ValueMapIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm16ValueMapIteratorneERKNS_16ValueMapIteratorIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ValueMapIterator<DenseMapT, KeyT> /*&*/ RHS) /*const*/ {
    return Native.$noteq(I, RHS.I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 356,
   FQN="llvm::ValueMapIterator::operator++", NM="_ZN4llvm16ValueMapIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIteratorppEv")
  //</editor-fold>
  public /*inline*/ ValueMapIterator<DenseMapT, KeyT> /*&*/ $preInc() {
    // Preincrement
    I.$preInc();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 360,
   FQN="llvm::ValueMapIterator::operator++", NM="_ZN4llvm16ValueMapIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm16ValueMapIteratorppEi")
  //</editor-fold>
  public ValueMapIterator<DenseMapT, KeyT> $postInc(int $Prm0) {
    // Postincrement
    ValueMapIterator<DenseMapT, KeyT> tmp = new ValueMapIterator<DenseMapT, KeyT>(/*Deref*/I);
    I.$preInc();//++/*Deref*/this;
    return tmp;
  }

  
  @Override public String toString() {
    return "" + "I=" + I // NOI18N
              + super.toString(); // NOI18N
  }
}
