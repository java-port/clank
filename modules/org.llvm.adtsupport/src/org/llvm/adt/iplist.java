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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.Native.NativeIterable;
import org.clank.support.aliases.JavaIterator;
import org.clank.support.aliases.type$iterator;
import org.clank.support.aliases.type$ref;


//===----------------------------------------------------------------------===//
//
/// iplist - The subset of list functionality that can safely be used on nodes
/// of polymorphic types, i.e. a heterogeneous list with a common base class that
/// holds the next/prev pointers.  The only state of the list itself is a single
/// pointer to the head of the list.
///
/// This list can be in one of three interesting states:
/// 1. The list may be completely unconstructed.  In this case, the head
///    pointer is null.  When in this form, any query for an iterator (e.g.
///    begin() or end()) causes the list to transparently change to state #2.
/// 2. The list may be empty, but contain a sentinel for the end iterator. This
///    sentinel is created by the Traits::createSentinel method and is a link
///    in the list.  When the list is empty, the pointer in the iplist points
///    to the sentinel.  Once the sentinel is constructed, it
///    is not destroyed until the list is.
/// 3. The list may contain actual objects in it, which are stored as a doubly
///    linked list of nodes.  One invariant of the list is that the predecessor
///    of the first node in the list always points to the last node in the list,
///    and the successor pointer for the sentinel (which always stays at the
///    end of the list) is always null.
///
/*template <typename NodeTy, typename Traits = ilist_traits<NodeTy>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::iplist">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 309,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 361,
 FQN="llvm::iplist", NM="_ZN4llvm6iplistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplistE")
//</editor-fold>
public abstract class iplist</*typename*/ NodeTy extends ilist_node<NodeTy>/*, typename Traits = ilist_traits<NodeTy>*/>  
        implements ilist_traits<NodeTy>, NativeIterable<ilist_iterator<? extends NodeTy>>, 
        Iterable<NodeTy>, Destructors.ClassWithDestructor {
  private /*mutable */NodeTy /*P*/ Head;
  
  // Use the prev node pointer of 'head' as the tail pointer.  This is really a
  // circularly linked list where we snip the 'next' link from the sentinel node
  // back to the first node in the list (to preserve assertions about going off
  // the end of the list).
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::getTail">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 369,
   FQN="llvm::iplist::getTail", NM="_ZN4llvm6iplist7getTailEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist7getTailEv")
  //</editor-fold>
  private NodeTy /*P*/ getTail() {
    return ensureHead(Head$ref);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::getTail">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 318,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 370,
   FQN="llvm::iplist::getTail", NM="_ZNK4llvm6iplist7getTailEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist7getTailEv")
  //</editor-fold>
  private /*const*/ NodeTy /*P*/ getTail$Const() /*const*/ {
    return ensureHead(Head$ref);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::setTail">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 371,
   FQN="llvm::iplist::setTail", NM="_ZNK4llvm6iplist7setTailEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist7setTailEPT_")
  //</editor-fold>
  private void setTail(NodeTy /*P*/ N) /*const*/ {
    noteHead(Head, N);
  }

  
  /// CreateLazySentinel - This method verifies whether the sentinel for the
  /// list has been created and lazily makes it if not.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::CreateLazySentinel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 375,
   FQN="llvm::iplist::CreateLazySentinel", NM="_ZNK4llvm6iplist18CreateLazySentinelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist18CreateLazySentinelEv")
  //</editor-fold>
  private void CreateLazySentinel() /*const*/ {
    ensureHead(Head$ref);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::op_less">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 327,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 379,
   FQN="llvm::iplist::op_less", NM="_ZN4llvm6iplist7op_lessERT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist7op_lessERT_S2_")
  //</editor-fold>
  private static </*typename*/ NodeTy, /*typename*/ Traits/* = ilist_traits<NodeTy>*/> boolean op_less(final NodeTy /*&*/ L, final NodeTy /*&*/ R) {
    return Native.$less(L, R);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::op_equal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 380,
   FQN="llvm::iplist::op_equal", NM="_ZN4llvm6iplist8op_equalERT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist8op_equalERT_S2_")
  //</editor-fold>
  private static </*typename*/ NodeTy, /*typename*/ Traits/* = ilist_traits<NodeTy>*/> boolean op_equal(final NodeTy /*&*/ L, final NodeTy /*&*/ R) {
    return Native.$eq(L, R);
  }

  
  // No fundamental reason why iplist can't be copyable, but the default
  // copy/copy-assign won't do.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::iplist<NodeTy, Traits>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 384,
   FQN="llvm::iplist::iplist<NodeTy, Traits>", NM="_ZN4llvm6iplistC1ERKNS_6iplistIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplistC1ERKNS_6iplistIT_T0_EE")
  //</editor-fold>
  protected/*private*/ iplist(final /*const*/ iplist<NodeTy> /*&*/ $Prm0) {throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 333,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 385,
   FQN="llvm::iplist::operator=", NM="_ZN4llvm6iplistaSERKNS_6iplistIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplistaSERKNS_6iplistIT_T0_EE")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ iplist<NodeTy> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  // JAVA: typedef NodeTy *pointer
//  public final class pointer extends NodeTy /*P*/ { };
  // JAVA: typedef const NodeTy *const_pointer
//  public final class const_pointer extends /*const*/ NodeTy /*P*/ { };
  // JAVA: typedef NodeTy &reference
//  public final class reference extends NodeTy /*&*/ { };
  // JAVA: typedef const NodeTy &const_reference
//  public final class const_reference extends /*const*/ NodeTy /*&*/ { };
  // JAVA: typedef NodeTy value_type
//  public final class value_type extends NodeTy{ };
  // JAVA: typedef ilist_iterator<NodeTy> iterator
//  public final class iterator extends ilist_iterator<NodeTy>{ };
  // JAVA: typedef ilist_iterator<const NodeTy> const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ NodeTy>{ };
  // JAVA: typedef size_t size_type;
  // JAVA: typedef ptrdiff_t difference_type;
  // JAVA: typedef std::reverse_iterator<const_iterator> const_reverse_iterator
//  public final class const_reverse_iterator extends std.reverse_iterator<ilist_iterator</*const*/ NodeTy> >{ };
  // JAVA: typedef std::reverse_iterator<iterator> reverse_iterator
//  public final class reverse_iterator extends std.reverse_iterator<ilist_iterator<NodeTy> >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::iplist<NodeTy, Traits>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 400,
   FQN="llvm::iplist::iplist<NodeTy, Traits>", NM="_ZN4llvm6iplistC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplistC1Ev")
  //</editor-fold>
  public iplist() {
    // : Head(this->provideInitialHead()) 
    //START JInit
    this.Head = /*ParenListExpr*/provideInitialHead();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::~iplist<NodeTy, Traits>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 349,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 401,
   FQN="llvm::iplist::~iplist<NodeTy, Traits>", NM="_ZN4llvm6iplistD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplistD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Native.$not(Head)) {
      return;
    }
    clear();
    destroySentinel(getTail());
    //super.$destroy();
  }

  
  // Iterator creation methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 356,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 408,
   FQN="llvm::iplist::begin", NM="_ZN4llvm6iplist5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5beginEv")
  //</editor-fold>
  public ilist_iterator<NodeTy> begin() {
    CreateLazySentinel();
    return new ilist_iterator<NodeTy>(Head, $traits());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 360,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 412,
   FQN="llvm::iplist::begin", NM="_ZNK4llvm6iplist5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist5beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ NodeTy> begin$Const() /*const*/ {
    CreateLazySentinel();
    return new ilist_iterator</*const*/ NodeTy>(Head, $traits());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 364,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 416,
   FQN="llvm::iplist::end", NM="_ZN4llvm6iplist3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist3endEv")
  //</editor-fold>
  public ilist_iterator<NodeTy> end() {
    CreateLazySentinel();
    return new ilist_iterator<NodeTy>(getTail(), $traits());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 368,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 420,
   FQN="llvm::iplist::end", NM="_ZNK4llvm6iplist3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist3endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ NodeTy> end$Const() /*const*/ {
    CreateLazySentinel();
    return new ilist_iterator</*const*/ NodeTy>(getTail(), $traits());
  }

  
  // reverse iterator creation methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 374,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 426,
   FQN="llvm::iplist::rbegin", NM="_ZN4llvm6iplist6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<NodeTy> rbegin() {
    return new std.reverse_iterator<NodeTy>(end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 375,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 427,
   FQN="llvm::iplist::rbegin", NM="_ZNK4llvm6iplist6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<NodeTy> rbegin$Const() /*const*/ {
    return new std.reverse_iterator<NodeTy>(end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 376,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 428,
   FQN="llvm::iplist::rend", NM="_ZN4llvm6iplist4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist4rendEv")
  //</editor-fold>
  public std.reverse_iterator<NodeTy> rend() {
    return new std.reverse_iterator<NodeTy>(begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 377,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 429,
   FQN="llvm::iplist::rend", NM="_ZNK4llvm6iplist4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist4rendEv")
  //</editor-fold>
  public std.reverse_iterator<NodeTy> rend$Const() /*const*/ {
    return new std.reverse_iterator<NodeTy>(begin());
  }

  
  // Miscellaneous inspection routines.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::max_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 433,
   FQN="llvm::iplist::max_size", NM="_ZNK4llvm6iplist8max_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist8max_sizeEv")
  //</editor-fold>
  public /*size_t*/int max_size() /*const*/ {
    return ((/*size_t*/int)(-1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 382,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 434,
   FQN="llvm::iplist::empty", NM="_ZNK4llvm6iplist5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*//* __attribute__((warn_unused_result))*/ {
    return Native.$not(Head) || Native.$bool(Native.$eq_ptr(Head, getTail()));
  }

  
  // Front and back accessor functions...
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 387,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 439,
   FQN="llvm::iplist::front", NM="_ZN4llvm6iplist5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5frontEv")
  //</editor-fold>
  public NodeTy /*&*/ front() {
    assert Native.$bool(Native.$not(empty())) : "Called front() on empty list!";
    return $Deref(Head);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 391,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 443,
   FQN="llvm::iplist::front", NM="_ZNK4llvm6iplist5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist5frontEv")
  //</editor-fold>
  public /*const*/ NodeTy /*&*/ front$Const() /*const*/ {
    assert Native.$bool(Native.$not(empty())) : "Called front() on empty list!";
    return $Deref(Head);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 395,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 447,
   FQN="llvm::iplist::back", NM="_ZN4llvm6iplist4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist4backEv")
  //</editor-fold>
  public NodeTy /*&*/ back() {
    assert Native.$bool(Native.$not(empty())) : "Called back() on empty list!";
    return $Deref(getPrev(getTail()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 399,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 451,
   FQN="llvm::iplist::back", NM="_ZNK4llvm6iplist4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist4backEv")
  //</editor-fold>
  public /*const*/ NodeTy /*&*/ back$Const() /*const*/ {
    assert Native.$bool(Native.$not(empty())) : "Called back() on empty list!";
    return $Deref(getPrev(getTail()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 456,
   FQN="llvm::iplist::swap", NM="_ZN4llvm6iplist4swapERNS_6iplistIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist4swapERNS_6iplistIT_T0_EE")
  //</editor-fold>
  public void swap(final iplist<NodeTy> /*&*/ RHS) {
    assert (false) : "Swap does not use list traits callback correctly yet!";
    //std.swap(Head, RHS.Head);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 409,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 461,
   FQN="llvm::iplist::insert", NM="_ZN4llvm6iplist6insertENS_14ilist_iteratorIT_EEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6insertENS_14ilist_iteratorIT_EEPS2_")
  //</editor-fold>
  public ilist_iterator<NodeTy> insert_ilist_iterator$NodeTy_T$P(ilist_iterator<NodeTy> where, NodeTy /*P*/ New) {
    NodeTy /*P*/ CurNode = where.getNodePtrUnchecked();
    NodeTy /*P*/ PrevNode = getPrev(CurNode);
    setNext(New, CurNode);
    setPrev(New, PrevNode);
    if (Native.$noteq_ptr(CurNode, Head)) { // Is PrevNode off the beginning of the list?
      setNext(PrevNode, New);
    } else {
      Head = New;
    }
    setPrev(CurNode, New);
    
    this.addNodeToList(this, New); // Notify traits that we added a node...
    return new ilist_iterator<NodeTy>(New, $traits());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 425,
   FQN="llvm::iplist::insert", NM="_ZN4llvm6iplist6insertENS_14ilist_iteratorIT_EERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6insertENS_14ilist_iteratorIT_EERKS2_")
  //</editor-fold>
  public ilist_iterator<NodeTy> insert_ilist_iterator$NodeTy_T$C$R(ilist_iterator<NodeTy> where, final /*const*/ NodeTy /*&*/ New) {
    return insert_ilist_iterator$NodeTy_T$P(where, New);//new NodeTy(( New )));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::insertAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 429,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 477,
   FQN="llvm::iplist::insertAfter", NM="_ZN4llvm6iplist11insertAfterENS_14ilist_iteratorIT_EEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist11insertAfterENS_14ilist_iteratorIT_EEPS2_")
  //</editor-fold>
  public ilist_iterator<NodeTy> insertAfter(ilist_iterator<NodeTy> where, NodeTy /*P*/ New) {
    if (empty()) {
      return  insert_ilist_iterator$NodeTy_T$C$R(begin(), New);
    } else {
      return  insert_ilist_iterator$NodeTy_T$C$R(where.$preInc(), New);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::remove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 484,
   FQN="llvm::iplist::remove", NM="_ZN4llvm6iplist6removeERNS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6removeERNS_14ilist_iteratorIT_EE")
  //</editor-fold>
  public NodeTy /*P*/ remove_ilist_iterator$NodeTy(final ilist_iterator<NodeTy> /*&*/ IT) {
    assert Native.$bool(Native.$noteq_iter(IT, end())) : "Cannot remove end of list!";
    NodeTy /*P*/ Node = $AddrOf($Deref(IT.$star()));
    NodeTy /*P*/ NextNode = getNext(Node);
    NodeTy /*P*/ PrevNode = getPrev(Node);
    if (Native.$noteq_ptr(Node, Head)) { // Is PrevNode off the beginning of the list?
      setNext(PrevNode, NextNode);
    } else {
      Head = NextNode;
    }
    setPrev(NextNode, PrevNode);
    IT.reset(NextNode);
    this.removeNodeFromList(this, Node); // Notify traits that we removed a node...
    
    // Set the next/prev pointers of the current node to null.  This isn't
    // strictly required, but this catches errors where a node is removed from
    // an ilist (and potentially deleted) with iterators still pointing at it.
    // When those iterators are incremented or decremented, they will assert on
    // the null next/prev pointer instead of "usually working".
    setNext(Node, null);
    setPrev(Node, null);
    return Node;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 460,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 508,
   FQN="llvm::iplist::remove", NM="_ZN4llvm6iplist6removeERKNS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6removeERKNS_14ilist_iteratorIT_EE")
  //</editor-fold>
  public NodeTy /*P*/ remove_ilist_iterator$NodeTy$C(final /*const*/ ilist_iterator<NodeTy> /*&*/ IT) {
    ilist_iterator<NodeTy> MutIt = IT;
    return remove_ilist_iterator$NodeTy(MutIt);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::remove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 465,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 513,
   FQN="llvm::iplist::remove", NM="_ZN4llvm6iplist6removeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6removeEPT_")
  //</editor-fold>
  public NodeTy /*P*/ remove_T$P(NodeTy /*P*/ IT) {
    return remove_ilist_iterator$NodeTy$C(new ilist_iterator<NodeTy>(IT, $traits()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::remove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 514,
   FQN="llvm::iplist::remove", NM="_ZN4llvm6iplist6removeERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6removeERT_")
  //</editor-fold>
  public NodeTy /*P*/ remove_T$R(final NodeTy /*&*/ IT) {
    return remove_ilist_iterator$NodeTy$C(new ilist_iterator<NodeTy>(IT, $traits()));
  }

  
  // erase - remove a node from the controlled sequence... and delete it.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 469,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 517,
   FQN="llvm::iplist::erase", NM="_ZN4llvm6iplist5eraseENS_14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5eraseENS_14ilist_iteratorIT_EE")
  //</editor-fold>
  public ilist_iterator<NodeTy> erase(ilist_iterator<NodeTy> where) {
    deleteNode(this, remove_ilist_iterator$NodeTy(where));
    return where;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 522,
   FQN="llvm::iplist::erase", NM="_ZN4llvm6iplist5eraseEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5eraseEPT_")
  //</editor-fold>
  public ilist_iterator<NodeTy> erase_T$P(NodeTy /*P*/ IT) {
    return erase(new ilist_iterator<NodeTy>(IT, $traits()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 475,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 523,
   FQN="llvm::iplist::erase", NM="_ZN4llvm6iplist5eraseERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5eraseERT_")
  //</editor-fold>
  public ilist_iterator<NodeTy> erase_T$R(final NodeTy /*&*/ IT) {
    return erase(new ilist_iterator<NodeTy>(IT, $traits()));
  }

  
  /// Remove all nodes from the list like clear(), but do not call
  /// removeNodeFromList() or deleteNode().
  ///
  /// This should only be used immediately before freeing nodes in bulk to
  /// avoid traversing the list and bringing all the nodes into cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::clearAndLeakNodesUnsafely">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 482,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 530,
   FQN="llvm::iplist::clearAndLeakNodesUnsafely", NM="_ZN4llvm6iplist25clearAndLeakNodesUnsafelyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist25clearAndLeakNodesUnsafelyEv")
  //</editor-fold>
  public void clearAndLeakNodesUnsafely() {
    if (Head != null) {
      Head = getTail();
      setPrev(Head, Head);
    }
  }

/*private:*/
  // transfer - The heart of the splice function.  Move linked list nodes from
  // [first, last) into position.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::transfer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 493,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 541,
   FQN="llvm::iplist::transfer", NM="_ZN4llvm6iplist8transferENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist8transferENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EES3_S3_")
  //</editor-fold>
  private void transfer(ilist_iterator<NodeTy> position, final iplist<NodeTy> /*&*/ L2, ilist_iterator<NodeTy> first, ilist_iterator<NodeTy> last) {
    assert Native.$bool(Native.$noteq_iter(first, last)) : "Should be checked by callers";
    // Position cannot be contained in the range to be transferred.
    // Check for the most common mistake.
    assert Native.$bool(Native.$noteq_iter(position, first)) : "Insertion point can't be one of the transferred nodes";
    if (Native.$noteq_iter(position, last)) {
      // Note: we have to be careful about the case when we move the first node
      // in the list.  This node is the list sentinel node and we can't move it.
      NodeTy /*P*/ ThisSentinel = getTail();
      setTail(null);
      NodeTy /*P*/ L2Sentinel = L2.getTail();
      L2.setTail(null);
      
      // Remove [first, last) from its old position.
      NodeTy /*P*/ First = $AddrOf($Deref(first.$star()));
      NodeTy /*P*/ Prev = getPrev(First);
      NodeTy /*P*/ Next = last.getNodePtrUnchecked();
      NodeTy /*P*/ Last = getPrev(Next);
      if (Prev != null) {
        setNext(Prev, Next);
      } else {
        L2.Head = Next;
      }
      setPrev(Next, Prev);
      
      // Splice [first, last) into its new position.
      NodeTy /*P*/ PosNext = position.getNodePtrUnchecked();
      NodeTy /*P*/ PosPrev = getPrev(PosNext);
      
      // Fix head of list...
      if (PosPrev != null) {
        setNext(PosPrev, First);
      } else {
        Head = First;
      }
      setPrev(First, PosPrev);
      
      // Fix end of list...
      setNext(Last, PosNext);
      setPrev(PosNext, Last);
      
      this.transferNodesFromList(L2, new ilist_iterator<NodeTy>(First, $traits()), new ilist_iterator<NodeTy>(PosNext, $traits()));
      
      // Now that everything is set, restore the pointers to the list sentinels.
      L2.setTail(L2Sentinel);
      setTail(ThisSentinel);
    }
  }

/*public:*/
  
  //===----------------------------------------------------------------------===
  // Functionality derived from other functions defined above...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 546,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 594,
   FQN="llvm::iplist::size", NM="_ZNK4llvm6iplist4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*//* __attribute__((warn_unused_result))*/ {
    if (Native.$not(Head)) {
      return 0; // Don't require construction of sentinel if empty.
    }
    return std.distance(begin(), end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 551,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 599,
   FQN="llvm::iplist::erase", NM="_ZN4llvm6iplist5eraseENS_14ilist_iteratorIT_EES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5eraseENS_14ilist_iteratorIT_EES3_")
  //</editor-fold>
  public ilist_iterator<NodeTy> erase(ilist_iterator<NodeTy> first, ilist_iterator<NodeTy> last) {
    while (Native.$noteq_iter(first, last)) {
      first = erase(first);
    }
    return last;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 557,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 605,
   FQN="llvm::iplist::clear", NM="_ZN4llvm6iplist5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5clearEv")
  //</editor-fold>
  public void clear() {
    if (Head != null) {
      erase(begin(), end());
    }
  }

  
  // Front and back inserters...
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::push_front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 560,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 608,
   FQN="llvm::iplist::push_front", NM="_ZN4llvm6iplist10push_frontEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist10push_frontEPT_")
  //</editor-fold>
  public void push_front(NodeTy /*P*/ val) {
    insert_ilist_iterator$NodeTy_T$C$R(begin(), val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 561,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 609,
   FQN="llvm::iplist::push_back", NM="_ZN4llvm6iplist9push_backEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist9push_backEPT_")
  //</editor-fold>
  public void push_back(NodeTy /*P*/ val) {
    insert_ilist_iterator$NodeTy_T$C$R(end(), val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::pop_front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 562,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 610,
   FQN="llvm::iplist::pop_front", NM="_ZN4llvm6iplist9pop_frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist9pop_frontEv")
  //</editor-fold>
  public void pop_front() {
    assert Native.$bool(Native.$not(empty())) : "pop_front() on empty list!";
    erase(begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::pop_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 566,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 614,
   FQN="llvm::iplist::pop_back", NM="_ZN4llvm6iplist8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    assert Native.$bool(Native.$not(empty())) : "pop_back() on empty list!";
    ilist_iterator<NodeTy> t = end();
    erase(t.$preDec());
  }

  
  // Special forms of insert...
  /*template <class InIt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 572,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 620,
   FQN="llvm::iplist::insert", NM="Tpl__ZN4llvm6iplist6insertENS_14ilist_iteratorIT_EET_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=Tpl__ZN4llvm6iplist6insertENS_14ilist_iteratorIT_EET_S4_")
  //</editor-fold>
  public </*class*/ InIt extends type$iterator<?, NodeTy>> void insert$T(ilist_iterator<NodeTy> where, InIt first, InIt last) {
    for (; Native.$noteq_iter(first, last); first.$preInc()) {
      insert_ilist_iterator$NodeTy_T$P(where, $Deref(first.$star()));
    }
  }
 
  
  // Splice members - defined in terms of transfer...
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::splice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 577,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 625,
   FQN="llvm::iplist::splice", NM="_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EE")
  //</editor-fold>
  public void splice(ilist_iterator<NodeTy> where, final iplist<NodeTy> /*&*/ L2) {
    if (Native.$not(L2.empty())) {
      transfer(where, L2, L2.begin(), L2.end());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::splice">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 581,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 629,
   FQN="llvm::iplist::splice", NM="_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EES3_")
  //</editor-fold>
  public void splice(ilist_iterator<NodeTy> where, final iplist<NodeTy> /*&*/ L2, ilist_iterator<NodeTy> first) {
    ilist_iterator<NodeTy> last = first;
    last.$preInc();
    if (Native.$bool(Native.$eq_iter(where, first)) || Native.$bool(Native.$eq_iter(where, last))) {
      return; // No change
    }
    transfer(where, L2, first, last);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::splice">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 586,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 634,
   FQN="llvm::iplist::splice", NM="_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EES3_S3_")
  //</editor-fold>
  public void splice(ilist_iterator<NodeTy> where, final iplist<NodeTy> /*&*/ L2, ilist_iterator<NodeTy> first, ilist_iterator<NodeTy> last) {
    if (Native.$noteq_iter(first, last)) {
      transfer(where, L2, first, last);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::splice">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 589,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 637,
   FQN="llvm::iplist::splice", NM="_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EERS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EERS2_")
  //</editor-fold>
  public void splice_ilist_iterator$NodeTy_iplist$NodeTy$Traits_T$R(ilist_iterator<NodeTy> where, final iplist<NodeTy> /*&*/ L2, final NodeTy /*&*/ N) {
    splice(where, L2, new ilist_iterator<NodeTy>(N, $traits()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::splice">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 592,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 640,
   FQN="llvm::iplist::splice", NM="_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist6spliceENS_14ilist_iteratorIT_EERNS_6iplistIS2_T0_EEPS2_")
  //</editor-fold>
  public void splice_ilist_iterator$NodeTy_iplist$NodeTy$Traits_T$P(ilist_iterator<NodeTy> where, final iplist<NodeTy> /*&*/ L2, NodeTy /*P*/ N) {
    splice(where, L2, new ilist_iterator<NodeTy>(N, $traits()));
  }

  
  /*template <class Compare> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::merge">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 597,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 644,
   FQN="llvm::iplist::merge", NM="Tpl__ZN4llvm6iplist5mergeERNS_6iplistIT_T0_EET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=Tpl__ZN4llvm6iplist5mergeERNS_6iplistIT_T0_EET_")
  //</editor-fold>
  public </*class*/ Compare> void merge$T(iplist<NodeTy/*, Traits*/> /*&*/ Right, Compare comp) {
    throw new UnsupportedOperationException("EmptyBody");
    }

  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::merge">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 614,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 662,
   FQN="llvm::iplist::merge", NM="_ZN4llvm6iplist5mergeERNS_6iplistIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist5mergeERNS_6iplistIT_T0_EE")
  //</editor-fold>
  public void merge(iplist<NodeTy/*, Traits*/> /*&*/ Right) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <class Compare> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::sort">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 617,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 664,
   FQN="llvm::iplist::sort", NM="Tpl__ZN4llvm6iplist4sortET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=Tpl__ZN4llvm6iplist4sortET_")
  //</editor-fold>
  public </*class*/ Compare> void sort$T(Compare comp) {
    throw new UnsupportedOperationException("EmptyBody");
  }
    
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::sort">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 641,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 689,
   FQN="llvm::iplist::sort", NM="_ZN4llvm6iplist4sortEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm6iplist4sortEv")
  //</editor-fold>
  public void sort() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the previous node, or \c nullptr for the list head.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::getPrevNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 644,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 692,
   FQN="llvm::iplist::getPrevNode", NM="_ZNK4llvm6iplist11getPrevNodeERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist11getPrevNodeERT_")
  //</editor-fold>
  public NodeTy /*P*/ getPrevNode_T$R(final NodeTy /*&*/ N) /*const*/ {
    ilist_iterator<NodeTy> I = N.getIterator();
    if (Native.$eq_iter(I, begin())) {
      return null;
    }
    return /*$AddrOf($Deref(*/ std.prev(I).$star();
  }

  /// \brief Get the previous node, or \c nullptr for the list head.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::getPrevNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 651,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 699,
   FQN="llvm::iplist::getPrevNode", NM="_ZNK4llvm6iplist11getPrevNodeERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist11getPrevNodeERKT_")
  //</editor-fold>
  public /*const*/ NodeTy /*P*/ getPrevNode_T$C$R(final /*const*/ NodeTy /*&*/ N) /*const*/ {
    return getPrevNode_T$R(((/*const_cast*/NodeTy /*&*/ )(N)));
  }

  
  /// \brief Get the next node, or \c nullptr for the list tail.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::getNextNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 656,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 704,
   FQN="llvm::iplist::getNextNode", NM="_ZNK4llvm6iplist11getNextNodeERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist11getNextNodeERT_")
  //</editor-fold>
  public NodeTy /*P*/ getNextNode_T$R(final NodeTy /*&*/ N) /*const*/ {
    /*<dependent type>*/ilist_iterator<NodeTy> Next = std.next(N.getIterator());
    if (Native.$eq_iter(Next, end())) {
      return null;
    }
    return /*$AddrOf($Deref(*/ Next.$star();
  }

  /// \brief Get the next node, or \c nullptr for the list tail.
  //<editor-fold defaultstate="collapsed" desc="llvm::iplist::getNextNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 663,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", old_line = 711,
   FQN="llvm::iplist::getNextNode", NM="_ZNK4llvm6iplist11getNextNodeERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm6iplist11getNextNodeERKT_")
  //</editor-fold>
  public /*const*/ NodeTy /*P*/ getNextNode_T$C$R(final /*const*/ NodeTy /*&*/ N) /*const*/ {
    return getNextNode_T$R(((/*const_cast*/NodeTy /*&*/ )(N)));
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<NodeTy> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  
  protected final ilist_traits<NodeTy> $traits() {
    return $traits;
  }
  
  protected abstract ilist_traits<NodeTy> $createTraits();
  
  private final ilist_traits<NodeTy> $traits;
  {
    ilist_traits<NodeTy> Traits = $createTraits();
    assert Traits != $createTraits() : "must return different instances, because requested Sentinels will be mutable object";
    $traits = Traits;
  }
  
  private final type$ref<NodeTy> Head$ref = new type$ref<NodeTy>() {
    public @Override NodeTy $deref() {
      return Head;
    }
    public @Override NodeTy $set(NodeTy value) {
      Head = value;
      return Head;
    }          
  };  

  @Override
  public NodeTy createNode(NodeTy V) {
    return $traits().createNode(V);
  }

  @Override
  public void deleteNode(iplist</*typename*/ NodeTy> list, NodeTy V) {
    assert list == this;
    $traits().deleteNode(list, V);
  }

  @Override
  public void addNodeToList(iplist</*typename*/ NodeTy> list, NodeTy $Prm0) {
    assert list == this;
    $traits().addNodeToList(list, $Prm0);
  }

  @Override
  public void removeNodeFromList(iplist</*typename*/ NodeTy> list, NodeTy $Prm0) {
    assert list == this;
    $traits().removeNodeFromList(list, $Prm0);
  }

  @Override
  public void transferNodesFromList(ilist_node_traits<NodeTy> $Prm0, ilist_iterator<NodeTy> $Prm1, ilist_iterator<NodeTy> $Prm2) {
    $traits().transferNodesFromList($Prm0, $Prm1, $Prm2);
  }

  @Override
  public NodeTy createSentinel() {
    return $traits().createSentinel();
  }

  @Override
  public void destroySentinel(NodeTy N) {
    $traits().destroySentinel(N);
  }

  @Override
  public NodeTy provideInitialHead() {
    return $traits().provideInitialHead();
  }

  @Override
  public NodeTy ensureHead(type$ref<NodeTy> Head) {
    return $traits().ensureHead(Head$ref);
  }

  @Override
  public void noteHead(NodeTy NewHead, NodeTy Sentinel) {
    $traits().noteHead(NewHead, Sentinel);
  }

  @Override
  public NodeTy getPrev(NodeTy N) {
    return $traits().getPrev(N);
  }

  @Override
  public NodeTy getNext(NodeTy N) {
    return $traits().getNext(N);
  }

  @Override
  public void setPrev(NodeTy N, NodeTy Prev) {
    $traits().setPrev(N, Prev);
  }

  @Override
  public void setNext(NodeTy N, NodeTy Next) {
    $traits().setNext(N, Next);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Head=" + NativeTrace.getIdentityStr(Head);
  }
}
