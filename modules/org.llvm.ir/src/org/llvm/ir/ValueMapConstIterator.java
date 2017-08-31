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
import org.llvm.ir.java.*;

/*template <typename DenseMapT, typename KeyT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 365,
 FQN="llvm::ValueMapConstIterator", NM="_ZN4llvm21ValueMapConstIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIteratorE")
//</editor-fold>
public class ValueMapConstIterator</*typename*/ DenseMapT extends DenseMap<?, ?>, /*typename*/ KeyT>  implements /*public*/ std.iterator/*<std.forward_iterator_tag, std.pair<KeyT,  DenseMapT.mapped_type>, int>*/, Native.NativeComparable<ValueMapConstIterator> {
  // JAVA: typedef typename DenseMapT::const_iterator BaseT
//  public final class BaseT extends  DenseMapT.const_iterator{ };
  // JAVA: typedef typename DenseMapT::mapped_type ValueT
//  public final class ValueT extends  DenseMapT.mapped_type{ };
  private  DenseMapIterator<KeyT, ?> I;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::ValueMapConstIterator<DenseMapT, KeyT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 374,
   FQN="llvm::ValueMapConstIterator::ValueMapConstIterator<DenseMapT, KeyT>", NM="_ZN4llvm21ValueMapConstIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIteratorC1Ev")
  //</editor-fold>
  public ValueMapConstIterator() {
    // : I() 
    //START JInit
    this.I = /*ParenListExpr*/new  DenseMapIterator();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::ValueMapConstIterator<DenseMapT, KeyT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 375,
   FQN="llvm::ValueMapConstIterator::ValueMapConstIterator<DenseMapT, KeyT>", NM="_ZN4llvm21ValueMapConstIteratorC1ENT_14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIteratorC1ENT_14const_iteratorE")
  //</editor-fold>
  public ValueMapConstIterator( DenseMapIterator I) {
    // : I(I) 
    //START JInit
    this.I = /*ParenListExpr*/new  DenseMapIterator(I);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::ValueMapConstIterator<DenseMapT, KeyT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 376,
   FQN="llvm::ValueMapConstIterator::ValueMapConstIterator<DenseMapT, KeyT>", NM="_ZN4llvm21ValueMapConstIteratorC1ENS_16ValueMapIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIteratorC1ENS_16ValueMapIteratorIT_T0_EE")
  //</editor-fold>
  public ValueMapConstIterator(ValueMapIterator<DenseMapT, KeyT> Other) {
    // : I(Other.base()) 
    //START JInit
    this.I = /*ParenListExpr*/new  DenseMapIterator(Other.base());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::base">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 379,
   FQN="llvm::ValueMapConstIterator::base", NM="_ZNK4llvm21ValueMapConstIterator4baseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm21ValueMapConstIterator4baseEv")
  //</editor-fold>
  public  DenseMapIterator base() /*const*/ {
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::ValueTypeProxy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 381,
   FQN="llvm::ValueMapConstIterator::ValueTypeProxy", NM="_ZN4llvm21ValueMapConstIterator14ValueTypeProxyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIterator14ValueTypeProxyE")
  //</editor-fold>
  public static class/*struct*/ ValueTypeProxy<KeyT, ValueT> {
    public /*const*/ KeyT first;
    public final /*const*/  ValueT /*&*/ second;

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::ValueTypeProxy::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 384,
     FQN="llvm::ValueMapConstIterator::ValueTypeProxy::operator->", NM="_ZN4llvm21ValueMapConstIterator14ValueTypeProxyptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIterator14ValueTypeProxyptEv")
    //</editor-fold>
    public ValueTypeProxy /*P*/ $arrow() {
      return this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::ValueTypeProxy::operator pair<type-parameter-0-1,  type-parameter-0-0::mapped_type>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 385,
     FQN="llvm::ValueMapConstIterator::ValueTypeProxy::operator pair<type-parameter-0-1,  type-parameter-0-0::mapped_type>", NM="_ZNK4llvm21ValueMapConstIterator14ValueTypeProxycvSt4pairIT0_NT_11mapped_typeEEEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm21ValueMapConstIterator14ValueTypeProxycvSt4pairIT0_NT_11mapped_typeEEEv")
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
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 390,
   FQN="llvm::ValueMapConstIterator::operator*", NM="_ZNK4llvm21ValueMapConstIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm21ValueMapConstIteratordeEv")
  //</editor-fold>
  public ValueTypeProxy $star() /*const*/ {
    Unwrap<KeyT> first = (Unwrap<KeyT>)I.$star().first;
    ValueTypeProxy Result = new ValueTypeProxy(first.Unwrap(), I.$star().second);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 395,
   FQN="llvm::ValueMapConstIterator::operator->", NM="_ZNK4llvm21ValueMapConstIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm21ValueMapConstIteratorptEv")
  //</editor-fold>
  public ValueTypeProxy $arrow() /*const*/ {
    return $star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 399,
   FQN="llvm::ValueMapConstIterator::operator==", NM="_ZNK4llvm21ValueMapConstIteratoreqERKNS_21ValueMapConstIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm21ValueMapConstIteratoreqERKNS_21ValueMapConstIteratorIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ValueMapConstIterator<DenseMapT, KeyT> /*&*/ RHS) /*const*/ {
    return Native.$eq(I, RHS.I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 402,
   FQN="llvm::ValueMapConstIterator::operator!=", NM="_ZNK4llvm21ValueMapConstIteratorneERKNS_21ValueMapConstIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZNK4llvm21ValueMapConstIteratorneERKNS_21ValueMapConstIteratorIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ ValueMapConstIterator<DenseMapT, KeyT> /*&*/ RHS) /*const*/ {
    return Native.$noteq(I, RHS.I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 406,
   FQN="llvm::ValueMapConstIterator::operator++", NM="_ZN4llvm21ValueMapConstIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIteratorppEv")
  //</editor-fold>
  public /*inline*/ ValueMapConstIterator<DenseMapT, KeyT> /*&*/ $preInc() {
    // Preincrement
    I.$preInc();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConstIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 410,
   FQN="llvm::ValueMapConstIterator::operator++", NM="_ZN4llvm21ValueMapConstIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm21ValueMapConstIteratorppEi")
  //</editor-fold>
  public ValueMapConstIterator<DenseMapT, KeyT> $postInc(int $Prm0) {
    // Postincrement
    ValueMapConstIterator<DenseMapT, KeyT> tmp = new ValueMapConstIterator<DenseMapT, KeyT>(/*Deref*/I);
    I.$preInc();//++/*Deref*/this;
    return tmp;
  }

  
  @Override public String toString() {
    return "" + "I=" + I // NOI18N
              + super.toString(); // NOI18N
  }
}
