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

package org.llvm.adt;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;


/// SmallPtrSet - This class implements a set which is optimized for holding
/// SmallSize or less elements.  This internally rounds up SmallSize to the next
/// power of two if it is not already a power of two.  See the comments above
/// SmallPtrSetImplBase for details of the algorithm.
/*template <class PtrType, unsigned int SmallSize> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 301,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 298,
 FQN="llvm::SmallPtrSet", NM="_ZN4llvm11SmallPtrSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetE")
//</editor-fold>
public class SmallPtrSet</*class*/ PtrType/*, uint SmallSize*/>  extends /*public*/ SmallPtrSetImpl<PtrType>
implements Destructors.ClassWithDestructor, assignable<SmallPtrSet<PtrType>>, 
        NativeCloneable<SmallPtrSet<PtrType>> {
  /*typedef SmallPtrSetImpl<PtrType> BaseT*/
//  public final class BaseT extends SmallPtrSetImpl<PtrType>{ };
  
  private final /*size_t*/int SmallSize;
  
//  // Make sure that SmallSize is a power of two, round up if not.
//  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::(anonymous)">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 306,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 303,
//   FQN="llvm::SmallPtrSet::(anonymous)", NM="_ZN4llvm11SmallPtrSetE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetE_Unnamed_enum")
//  //</editor-fold>
//  /*enum ANONYMOUS_INT_CONSTANTS {*/
//    public static final /*<dependent type>*/void SmallSizePowTwo = RoundUpToPowerOfTwo<SmallSize>.Val;
//  /*}*/;
//  /// SmallStorage - Fixed size storage used in 'small mode'.
//  private /*const*/Object/*void P*/ SmallStorage[SmallSizePowTwo] = new /*const*/Object/*void P*/ [SmallSizePowTwo];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 311,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 307,
   FQN="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>", NM="_ZN4llvm11SmallPtrSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetC1Ev")
  //</editor-fold>
  public SmallPtrSet(DenseMapInfo<PtrType> KeyInfo, /*size_t*/int SmallSize) {
    /* : BaseT(SmallStorage, SmallSizePowTwo)*/ 
    //START JInit
    /*ParenListExpr*/super(KeyInfo, create_type$ptr((PtrType[])new Object[(int) llvm.NextPowerOf2(SmallSize)]), llvm.NextPowerOf2(SmallSize));
    //END JInit
    this.SmallSize = SmallSize;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 312,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 308,
   FQN="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>", NM="_ZN4llvm11SmallPtrSetC1ERKNS_11SmallPtrSetIT_XT0_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetC1ERKNS_11SmallPtrSetIT_XT0_EEE")
  //</editor-fold>
  public SmallPtrSet(/*const*/ SmallPtrSet<PtrType> /*&*/ that) {
    /* : BaseT(SmallStorage, that)*/ 
    //START JInit
    super(create_type$ptr((PtrType[])new Object[(int) llvm.NextPowerOf2(that.SmallSize)]), that);
    //END JInit
    this.SmallSize = that.SmallSize;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 313,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 309,
   FQN="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>", NM="_ZN4llvm11SmallPtrSetC1EONS_11SmallPtrSetIT_XT0_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetC1EONS_11SmallPtrSetIT_XT0_EEE")
  //</editor-fold>
  public SmallPtrSet(JD$Move _dparam, SmallPtrSet<PtrType> /*&&*/that) {
    /* : BaseT(SmallStorage, SmallSizePowTwo, std::move(that))*/ 
    //START JInit
    /*ParenListExpr*/super(create_type$ptr((PtrType[])new Object[(int) llvm.NextPowerOf2(that.SmallSize)]), std.move(that));
    //END JInit
    this.SmallSize = that.SmallSize;
  }

  
  /*template <typename It> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 312,
   FQN="llvm::SmallPtrSet::SmallPtrSet<PtrType, SmallSize>", NM="Tpl__ZN4llvm11SmallPtrSetC1ET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=Tpl__ZN4llvm11SmallPtrSetC1ET_S1_")
  //</editor-fold>
  public </*typename*/ It> SmallPtrSet(DenseMapInfo<PtrType> KeyInfo, type$iterator<?, PtrType> I, type$iterator<?, PtrType> E, /*size_t*/int SmallSize) {
    /* : BaseT(SmallStorage, SmallSizePowTwo)*/ 
    //START JInit
    super(KeyInfo, create_type$ptr((PtrType[])new Object[(int) llvm.NextPowerOf2(SmallSize)]), SmallSize);
    //END JInit
    this.SmallSize = SmallSize;
    insert(I, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 321,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 317,
   FQN="llvm::SmallPtrSet::operator=", NM="_ZN4llvm11SmallPtrSetaSERKNS_11SmallPtrSetIT_XT0_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetaSERKNS_11SmallPtrSetIT_XT0_EEE")
  //</editor-fold>
  public SmallPtrSet<PtrType> /*&*/ $assign(/*const*/ SmallPtrSet<PtrType> /*&*/ RHS) {
    if ($AddrOf(RHS) != this) {
      this.CopyFrom(RHS);
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 324,
   FQN="llvm::SmallPtrSet::operator=", NM="_ZN4llvm11SmallPtrSetaSEONS_11SmallPtrSetIT_XT0_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSetaSEONS_11SmallPtrSetIT_XT0_EEE")
  //</editor-fold>
  public SmallPtrSet<PtrType> /*&*/ $assignMove(SmallPtrSet<PtrType> /*&&*/RHS) {
    if ($AddrOf(RHS) != this) {
      this.MoveFrom(llvm.NextPowerOf2(SmallSize), std.move(RHS));
    }
    return /*Deref*/this;
  }

  
  /// swap - Swaps the elements of two sets.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSet::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 332,
   FQN="llvm::SmallPtrSet::swap", NM="_ZN4llvm11SmallPtrSet4swapERNS_11SmallPtrSetIT_XT0_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm11SmallPtrSet4swapERNS_11SmallPtrSetIT_XT0_EEE")
  //</editor-fold>
  public void swap(SmallPtrSet<PtrType> /*&*/ RHS) {
    super.swap(RHS);
  }

  @Override
  public SmallPtrSet<PtrType> clone() {
    return new SmallPtrSet<>(this);
  }
  
  public String toString() {
    return "" + "SmallSize=" + SmallSize // NOI18N
              + super.toString(); // NOI18N
  }
}
