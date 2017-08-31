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

package org.llvm.adt.aliases;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
// Immutable AVL-Tree Iterators.
//===----------------------------------------------------------------------===//
/*template <typename ImutInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 647,
 FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorE")
//</editor-fold>
public class ImutAVLTreeGenericIteratorPtrBoolType</*typename ImutInfo*/ KeyT, ValT>  implements type$iterator<ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT>, ImutAVLTreePtrBoolType<KeyT, ValT>>,
        /*public*/ std.iterator<std.bidirectional_iterator_tag, ImutAVLTreePtrBoolType<KeyT, ValT> >, Destructors.ClassWithDestructor {
  private final SmallVector<PointerIntPair<Object>> stack;
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::VisitFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 653,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::VisitFlag", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIterator9VisitFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIterator9VisitFlagE")
  //</editor-fold>
  public static final class/*enum*/ VisitFlag {
    public static final /*<dependent type>*/int VisitedNone = 0x0;
    public static final /*<dependent type>*/int VisitedLeft = 0x1;
    public static final /*<dependent type>*/int VisitedRight = 0x3;
    public static final /*<dependent type>*/int Flags = 0x3;
  };
  
  /*typedef ImutAVLTreePtrBoolType<ImutInfo> TreeTy*/
//  public final class TreeTy extends ImutAVLTreePtrBoolType<KeyT, ValT>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::ImutAVLTreePtrBoolTypeGenericIterator<ImutInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 658,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::ImutAVLTreePtrBoolTypeGenericIterator<ImutInfo>", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorC1Ev")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorPtrBoolType() {
    stack = new SmallVector<>(20, new PointerIntPair<Object>()); // must copy stored obj/int pairs
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::ImutAVLTreePtrBoolTypeGenericIterator<ImutInfo>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 659,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::ImutAVLTreePtrBoolTypeGenericIterator<ImutInfo>", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorC1EPKNS_11ImutAVLTreePtrBoolTypeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorC1EPKNS_11ImutAVLTreePtrBoolTypeIT_EE")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorPtrBoolType(/*const*/ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ Root) {
    stack = new SmallVector<>(20, new PointerIntPair<Object>()); // must copy stored obj/int pairs
    if (Root != null) {
      stack.push_back(new PointerIntPair<>(reinterpret_cast_Object/*uintptr_t*/(Root), VisitFlag.VisitedNone));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 663,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator*", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratordeEv")
  //</editor-fold>
  public ImutAVLTreePtrBoolType<KeyT, ValT>/*&*/ $star() /*const*/ {
    assert Native.$bool(Native.$not(stack.empty()));
    return Native.$star(((ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ )reinterpret_cast(ImutAVLTreePtrBoolType.class, stack.back().getPointer() /*& ~VisitFlag.Flags*/)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 667,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator->", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratorptEv")
  //</editor-fold>
  public ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ $arrow() /*const*/ {
    return /*AddrOf*/this.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::getVisitState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 669,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::getVisitState", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIterator13getVisitStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIterator13getVisitStateEv")
  //</editor-fold>
  public int/*uintptr_t*/ getVisitState() /*const*/ {
    assert Native.$bool(Native.$not(stack.empty()));
    return stack.back().getInt(); // stack.back() & VisitFlag.Flags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::atEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 675,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::atEnd", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIterator5atEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIterator5atEndEv")
  //</editor-fold>
  public boolean atEnd() /*const*/ {
    return stack.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::atBeginning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 677,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::atBeginning", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIterator11atBeginningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIterator11atBeginningEv")
  //</editor-fold>
  public boolean atBeginning() /*const*/ {
    return Native.$bool(Native.$eq(stack.size(), 1)) && Native.$bool(Native.$eq(getVisitState(), VisitFlag.VisitedNone));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::skipToParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 681,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::skipToParent", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIterator12skipToParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIterator12skipToParentEv")
  //</editor-fold>
  public void skipToParent() {
    assert Native.$bool(Native.$not(stack.empty()));
    stack.pop_back();
    if (stack.empty()) {
      return;
    }
    switch (getVisitState()) {
     case VisitFlag.VisitedNone:
      stack.back().setInt(stack.back().getInt() | VisitFlag.VisitedLeft);
      break;
     case VisitFlag.VisitedLeft:
      stack.back().setInt(stack.back().getInt() | VisitFlag.VisitedRight);
      break;
     default:
      throw new llvm_unreachable("Unreachable.");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 698,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator==", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratoreqERKNS_26ImutAVLTreePtrBoolTypeGenericIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratoreqERKNS_26ImutAVLTreePtrBoolTypeGenericIteratorIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/Object/*&*/ x) /*const*/ {
    return Native.$eq(stack, ((ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT>) x).stack);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 702,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator!=", NM="_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratorneERKNS_26ImutAVLTreePtrBoolTypeGenericIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreePtrBoolTypeGenericIteratorneERKNS_26ImutAVLTreePtrBoolTypeGenericIteratorIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/Object/*&*/ x) /*const*/ {
    return Native.$not(this.$eq(x));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 706,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator++", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratorppEv")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT>/*&*/ $preInc() {
    assert Native.$bool(Native.$not(stack.empty()));
    ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ Current = ((ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ )reinterpret_cast(ImutAVLTreePtrBoolType.class, stack.back().getPointer() /*& ~VisitFlag.Flags*/));
    assert Native.$bool(Current);
    switch (getVisitState()) {
     case VisitFlag.VisitedNone:
      {
        ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ L = Current.getLeft();
        if (L != null) {
          stack.push_back(new PointerIntPair<Object>(reinterpret_cast_Object/*uintptr_t*/(L), VisitFlag.VisitedNone));
        } else {
          stack.back().setInt(stack.back().getInt() | VisitFlag.VisitedLeft);
        }
      }
      break;
     case VisitFlag.VisitedLeft:
      {
        ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ R = Current.getRight();
        if (R != null) {
          stack.push_back(new PointerIntPair<Object>(reinterpret_cast_Object/*uintptr_t*/(R), VisitFlag.VisitedNone));
        } else {
          stack.back().setInt(stack.back().getInt() | VisitFlag.VisitedRight);
        }
      }
      break;
     case VisitFlag.VisitedRight:
      skipToParent();
      break;
     default:
      throw new llvm_unreachable("Unreachable.");
    }
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 732,
   FQN="llvm::ImutAVLTreePtrBoolTypeGenericIterator::operator--", NM="_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratormmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreePtrBoolTypeGenericIteratormmEv")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT>/*&*/ $preDec() {
    assert Native.$bool(Native.$not(stack.empty()));
    ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ Current = ((ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ )reinterpret_cast(ImutAVLTreePtrBoolType.class, stack.back().getPointer() /*& ~VisitFlag.Flags*/));
    assert Native.$bool(Current);
    switch (getVisitState()) {
     case VisitFlag.VisitedNone:
      stack.pop_back();
      break;
     case VisitFlag.VisitedLeft:
      stack.back().setInt(VisitFlag.VisitedNone); // &= ~VisitFlag.Flags; // Set state to "VisitedNone."
      {
        ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ L = Current.getLeft();
        if (L != null) {
          stack.push_back(new PointerIntPair<Object>(reinterpret_cast_Object/*uintptr_t*/(L), VisitFlag.VisitedRight));
        }
      }
      break;
     case VisitFlag.VisitedRight:
      //stack.back() &= ~VisitFlag.Flags;
      //stack.back() |= VisitFlag.VisitedLeft;
      // JAVA: one operation instead of two above
      stack.back().setInt(VisitFlag.VisitedLeft);
      {
        ImutAVLTreePtrBoolType<KeyT, ValT>/*P*/ R = Current.getRight();
        if (R != null) {
          stack.push_back(new PointerIntPair<Object>(reinterpret_cast_Object/*uintptr_t*/(R), VisitFlag.VisitedRight));
        }
      }
      break;
     default:
      throw new llvm_unreachable("Unreachable.");
    }
    return this;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutAVLTreeGenericIteratorPtrBoolType(ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT> Other) {
    this.stack = new SmallVector<>(Other.stack);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT> clone() {
    return new ImutAVLTreeGenericIteratorPtrBoolType<KeyT, ValT>(this);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public void $destroy() {
    // Do nothing
  }
  
  @Override public String toString() {
    return "" + "stack=" + stack.size() // NOI18N
              + super.toString(); // NOI18N
  }
}
