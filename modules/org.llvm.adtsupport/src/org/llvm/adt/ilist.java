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

import java.util.function.Supplier;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;

/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 669,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 717,
 FQN="llvm::ilist", NM="_ZN4llvm5ilistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilistE")
//</editor-fold>
public abstract class/*struct*/ ilist</*typename*/ NodeTy extends ilist_node<NodeTy>>  extends /*public*/ iplist<NodeTy> {
  // JAVA: typedef typename iplist<NodeTy>::size_type size_type
//  public final class size_type extends /*uint*/int{ };
  // JAVA: typedef typename iplist<NodeTy>::iterator iterator
//  public final class iterator extends ilist_iterator<NodeTy>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::ilist<NodeTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 674,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 722,
   FQN="llvm::ilist::ilist<NodeTy>", NM="_ZN4llvm5ilistC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilistC1Ev")
  //</editor-fold>
  public ilist() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::ilist<NodeTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 675,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 723,
   FQN="llvm::ilist::ilist<NodeTy>", NM="_ZN4llvm5ilistC1ERKNS_5ilistIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilistC1ERKNS_5ilistIT_EE")
  //</editor-fold>
  public ilist(final /*const*/ ilist<NodeTy> /*&*/ right) {
    // : iplist<NodeTy>() 
    //START JInit
    /*ParenListExpr*/super();
    //END JInit
    insert$T(this.begin(), right.begin(), right.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::ilist<NodeTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 678,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 726,
   FQN="llvm::ilist::ilist<NodeTy>", NM="_ZN4llvm5ilistC1ENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilistC1ENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeE")
  //</editor-fold>
  public /*explicit*/ ilist( /*uint*/int count, Supplier<NodeTy> NodeTySupplier) {
    insert(this.begin(), count, NodeTySupplier.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::ilist<NodeTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 681,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 729,
   FQN="llvm::ilist::ilist<NodeTy>", NM="_ZN4llvm5ilistC1ENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilistC1ENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeERKS2_")
  //</editor-fold>
  public ilist(JD$UInt_T$C$R _dparam, /*uint*/int count, final /*const*/ NodeTy /*&*/ val) {
    insert(this.begin(), count, val);
  }

  /*template <class InIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::ilist<NodeTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 684,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 732,
   FQN="llvm::ilist::ilist<NodeTy>", NM="Tpl__ZN4llvm5ilistC1ET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=Tpl__ZN4llvm5ilistC1ET_S1_")
  //</editor-fold>
  public </*class*/ InIt extends type$iterator<?, NodeTy>> ilist(JD$T _dparam, InIt first, InIt last) {
    insert$T(this.begin(), first, last);
  }

  
  // bring hidden functions into scope
  //JAVA: using iplist<NodeTy>::insert;
  //JAVA: using iplist<NodeTy>::push_front;
  //JAVA: using iplist<NodeTy>::push_back;
  
  // Main implementation here - Insert for a node passed by value...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 694,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 742,
   FQN="llvm::ilist::insert", NM="_ZN4llvm5ilist6insertENS_6iplistIT_NS_12ilist_traitsIS2_EEE8iteratorERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist6insertENS_6iplistIT_NS_12ilist_traitsIS2_EEE8iteratorERKS2_")
  //</editor-fold>
  public ilist_iterator<NodeTy> insert(ilist_iterator<NodeTy> where, final /*const*/ NodeTy /*&*/ val) {
    return insert_ilist_iterator$NodeTy_T$P(where, this.createNode(val));
  }

  
  // Front and back inserters...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::push_front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 700,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 748,
   FQN="llvm::ilist::push_front", NM="_ZN4llvm5ilist10push_frontERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist10push_frontERKT_")
  //</editor-fold>
  public void push_front(final /*const*/ NodeTy /*&*/ val) {
    insert(this.begin(), val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 701,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 749,
   FQN="llvm::ilist::push_back", NM="_ZN4llvm5ilist9push_backERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist9push_backERKT_")
  //</editor-fold>
  public void push_back(final /*const*/ NodeTy /*&*/ val) {
    insert(this.end(), val);
  }
  // JAVA: for pointers.
  public void push_back$P(final /*const*/ NodeTy /*&*/ val) {
    insert_ilist_iterator$NodeTy_T$P(this.end(), val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 703,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 751,
   FQN="llvm::ilist::insert", NM="_ZN4llvm5ilist6insertENS_6iplistIT_NS_12ilist_traitsIS2_EEE8iteratorENS5_9size_typeERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist6insertENS_6iplistIT_NS_12ilist_traitsIS2_EEE8iteratorENS5_9size_typeERKS2_")
  //</editor-fold>
  public void insert(ilist_iterator<NodeTy> where, /*uint*/int count, final /*const*/ NodeTy /*&*/ val) {
    for (; Native.$noteq(count, 0); --count)  {
      insert(where, val);
    }
  }

  
  // Assign special forms...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::assign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 708,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 756,
   FQN="llvm::ilist::assign", NM="_ZN4llvm5ilist6assignENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist6assignENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeERKS2_")
  //</editor-fold>
  public void assign_uint_T$C$R(/*uint*/int count, final /*const*/ NodeTy /*&*/ val) {
    ilist_iterator<NodeTy> I = this.begin();
    for (; Native.$bool(Native.$noteq(I, this.end())) && Native.$bool(Native.$noteq(count, 0)); I.$preInc() , --count)  {
      I.star$ref().$set(val);
    }
    if (Native.$noteq(count, 0)) {
      type$ptr $val = create_type$ptr(val); // JAVA: not sure it should be that way...
      insert$T(this.end(), $val, $val);
    } else {
      erase(I, this.end());
    }
  }

  /*template <class InIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::assign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 717,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 765,
   FQN="llvm::ilist::assign", NM="Tpl__ZN4llvm5ilist6assignET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=Tpl__ZN4llvm5ilist6assignET_S1_")
  //</editor-fold>
  //public </*class*/ InIt extends type$iterator<?, NodeTy>> void assign_T(InIt first1, InIt last1) {
  public void assign_T(ilist_iterator<NodeTy> first1, ilist_iterator<NodeTy> last1) {
    ilist_iterator<NodeTy> first2 = this.begin();
    ilist_iterator<NodeTy> last2 = this.end();
    for (; Native.$bool(Native.$noteq(first1, last1)) && Native.$bool(Native.$noteq(first2, last2)); first1.$preInc() , first2.$preInc())  {
      first1.star$ref().$set($Deref(first2.$star()));
    }
    if (Native.$eq(first2, last2)) {
      erase(first1, last1);
    } else {
      insert$T(last1, first2, last2);
    }
  }

  
  // Resize members...
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::resize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 729,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 777,
   FQN="llvm::ilist::resize", NM="_ZN4llvm5ilist6resizeENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist6resizeENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeES2_")
  //</editor-fold>
  public void resize(/*uint*/int newsize, NodeTy val) {
    ilist_iterator<NodeTy> i = this.begin();
    /*uint*/int len = 0;
    for (; Native.$bool(Native.$noteq(i, this.end())) && Native.$bool(Native.$less(len, newsize)); i.$preInc() , ++len)  { /* empty*/
      ;
    }
    if (Native.$eq(len, newsize)) {
      erase(i, this.end());
    } else { // i == end()
      insert(this.end(), newsize - len, val);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist::resize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 739,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 787,
   FQN="llvm::ilist::resize", NM="_ZN4llvm5ilist6resizeENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm5ilist6resizeENS_6iplistIT_NS_12ilist_traitsIS2_EEE9size_typeE")
  //</editor-fold>
  public void resize(/*uint*/int newsize, Supplier<NodeTy> NodeTySupplier) {
    resize(newsize, NodeTySupplier.get());
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
