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
//<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 647,
 FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorE")
//</editor-fold>
public class ImutAVLTreeGenericIteratorUIntBoolUInt  implements type$iterator<ImutAVLTreeGenericIteratorUIntBoolUInt, ImutAVLTreeUIntBoolUInt>,
        /*public*/ std.iterator<std.bidirectional_iterator_tag, ImutAVLTreeUIntBoolUInt >, Destructors.ClassWithDestructor {
  private final SmallVector<PointerIntPair<Object>> stack;
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::VisitFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 653,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::VisitFlag", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIterator9VisitFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIterator9VisitFlagE")
  //</editor-fold>
  public static final class/*enum*/ VisitFlag {
    public static final /*<dependent type>*/int VisitedNone = 0x0;
    public static final /*<dependent type>*/int VisitedLeft = 0x1;
    public static final /*<dependent type>*/int VisitedRight = 0x3;
    public static final /*<dependent type>*/int Flags = 0x3;
  };
  
  /*typedef ImutAVLTreeUIntBoolUInt<ImutInfo> TreeTy*/
//  public final class TreeTy extends ImutAVLTreeUIntBoolUInt{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::ImutAVLTreeUIntBoolUIntGenericIterator<ImutInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 658,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::ImutAVLTreeUIntBoolUIntGenericIterator<ImutInfo>", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorC1Ev")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorUIntBoolUInt() {
    stack = new SmallVector<>(20, new PointerIntPair<Object>()); // must copy stored obj/int pairs
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::ImutAVLTreeUIntBoolUIntGenericIterator<ImutInfo>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 659,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::ImutAVLTreeUIntBoolUIntGenericIterator<ImutInfo>", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorC1EPKNS_11ImutAVLTreeUIntBoolUIntIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorC1EPKNS_11ImutAVLTreeUIntBoolUIntIT_EE")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorUIntBoolUInt(/*const*/ImutAVLTreeUIntBoolUInt/*P*/ Root) {
    stack = new SmallVector<>(20, new PointerIntPair<Object>()); // must copy stored obj/int pairs
    if (Root != null) {
      stack.push_back(new PointerIntPair<>(reinterpret_cast_Object/*uintptr_t*/(Root), VisitFlag.VisitedNone));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 663,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator*", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratordeEv")
  //</editor-fold>
  public ImutAVLTreeUIntBoolUInt/*&*/ $star() /*const*/ {
    assert Native.$bool(Native.$not(stack.empty()));
    return Native.$star(((ImutAVLTreeUIntBoolUInt/*P*/ )reinterpret_cast(ImutAVLTreeUIntBoolUInt.class, stack.back().getPointer() /*& ~VisitFlag.Flags*/)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 667,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator->", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorptEv")
  //</editor-fold>
  public ImutAVLTreeUIntBoolUInt/*P*/ $arrow() /*const*/ {
    return /*AddrOf*/this.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::getVisitState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 669,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::getVisitState", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIterator13getVisitStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIterator13getVisitStateEv")
  //</editor-fold>
  public int/*uintptr_t*/ getVisitState() /*const*/ {
    assert Native.$bool(Native.$not(stack.empty()));
    return stack.back().getInt(); // stack.back() & VisitFlag.Flags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::atEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 675,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::atEnd", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIterator5atEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIterator5atEndEv")
  //</editor-fold>
  public boolean atEnd() /*const*/ {
    return stack.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::atBeginning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 677,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::atBeginning", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIterator11atBeginningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIterator11atBeginningEv")
  //</editor-fold>
  public boolean atBeginning() /*const*/ {
    return Native.$bool(Native.$eq(stack.size(), 1)) && Native.$bool(Native.$eq(getVisitState(), VisitFlag.VisitedNone));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::skipToParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 681,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::skipToParent", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIterator12skipToParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIterator12skipToParentEv")
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

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 698,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator==", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratoreqERKNS_26ImutAVLTreeUIntBoolUIntGenericIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratoreqERKNS_26ImutAVLTreeUIntBoolUIntGenericIteratorIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/Object/*&*/ x) /*const*/ {
    return Native.$eq(stack, ((ImutAVLTreeGenericIteratorUIntBoolUInt) x).stack);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 702,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator!=", NM="_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorneERKNS_26ImutAVLTreeUIntBoolUIntGenericIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorneERKNS_26ImutAVLTreeUIntBoolUIntGenericIteratorIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/Object/*&*/ x) /*const*/ {
    return Native.$not(this.$eq(x));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 706,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator++", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratorppEv")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorUIntBoolUInt/*&*/ $preInc() {
    assert Native.$bool(Native.$not(stack.empty()));
    ImutAVLTreeUIntBoolUInt/*P*/ Current = ((ImutAVLTreeUIntBoolUInt/*P*/ )reinterpret_cast(ImutAVLTreeUIntBoolUInt.class, stack.back().getPointer() /*& ~VisitFlag.Flags*/));
    assert Native.$bool(Current);
    switch (getVisitState()) {
     case VisitFlag.VisitedNone:
      {
        ImutAVLTreeUIntBoolUInt/*P*/ L = Current.getLeft();
        if (L != null) {
          stack.push_back(new PointerIntPair<Object>(reinterpret_cast_Object/*uintptr_t*/(L), VisitFlag.VisitedNone));
        } else {
          stack.back().setInt(stack.back().getInt() | VisitFlag.VisitedLeft);
        }
      }
      break;
     case VisitFlag.VisitedLeft:
      {
        ImutAVLTreeUIntBoolUInt/*P*/ R = Current.getRight();
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

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 732,
   FQN="llvm::ImutAVLTreeUIntBoolUIntGenericIterator::operator--", NM="_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratormmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeUIntBoolUIntGenericIteratormmEv")
  //</editor-fold>
  public ImutAVLTreeGenericIteratorUIntBoolUInt/*&*/ $preDec() {
    assert Native.$bool(Native.$not(stack.empty()));
    ImutAVLTreeUIntBoolUInt/*P*/ Current = ((ImutAVLTreeUIntBoolUInt/*P*/ )reinterpret_cast(ImutAVLTreeUIntBoolUInt.class, stack.back().getPointer() /*& ~VisitFlag.Flags*/));
    assert Native.$bool(Current);
    switch (getVisitState()) {
     case VisitFlag.VisitedNone:
      stack.pop_back();
      break;
     case VisitFlag.VisitedLeft:
      stack.back().setInt(VisitFlag.VisitedNone); // &= ~VisitFlag.Flags; // Set state to "VisitedNone."
      {
        ImutAVLTreeUIntBoolUInt/*P*/ L = Current.getLeft();
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
        ImutAVLTreeUIntBoolUInt/*P*/ R = Current.getRight();
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
  public ImutAVLTreeGenericIteratorUIntBoolUInt(ImutAVLTreeGenericIteratorUIntBoolUInt Other) {
    this.stack = new SmallVector<>(Other.stack);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutAVLTreeGenericIteratorUIntBoolUInt clone() {
    return new ImutAVLTreeGenericIteratorUIntBoolUInt(this);
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
