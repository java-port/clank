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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 86,
 FQN="llvm::DITypeRefArray", NM="_ZN4llvm14DITypeRefArrayE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArrayE")
//</editor-fold>
public class DITypeRefArray implements Native.Native$Bool, Iterable<TypedDINodeRef<DIType>> {
  private /*const*/ MDTuple /*P*/ N/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::DITypeRefArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 90,
   FQN="llvm::DITypeRefArray::DITypeRefArray", NM="_ZN4llvm14DITypeRefArrayC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArrayC1Ev")
  //</editor-fold>
  public DITypeRefArray()/* = default*/ {
    /*<<<defaulted constructor: may be there is another TU where objects are created?>>>*/
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::DITypeRefArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 91,
   FQN="llvm::DITypeRefArray::DITypeRefArray", NM="_ZN4llvm14DITypeRefArrayC1EPKNS_7MDTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArrayC1EPKNS_7MDTupleE")
  //</editor-fold>
  public DITypeRefArray(/*const*/ MDTuple /*P*/ N) {
    // : N(N)
    //START JInit
    this.N = N;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 93,
   FQN="llvm::DITypeRefArray::operator bool", NM="_ZNK4llvm14DITypeRefArraycvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArraycvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (get() != null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::operator MDTuple * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 94,
   FQN="llvm::DITypeRefArray::operator MDTuple * ", NM="_ZNK4llvm14DITypeRefArraycvPNS_7MDTupleEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArraycvPNS_7MDTupleEEv")
  //</editor-fold>
  public MDTuple /*P*/ $MDTuple$P() /*const*/ {
    return get();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 96,
   FQN="llvm::DITypeRefArray::get", NM="_ZNK4llvm14DITypeRefArray3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray3getEv")
  //</editor-fold>
  public MDTuple /*P*/ get() /*const*/ {
    return ((/*const_cast*/MDTuple /*P*/ )(N));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 97,
   FQN="llvm::DITypeRefArray::operator->", NM="_ZNK4llvm14DITypeRefArrayptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArrayptEv")
  //</editor-fold>
  public MDTuple /*P*/ $arrow() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 98,
   FQN="llvm::DITypeRefArray::operator*", NM="_ZNK4llvm14DITypeRefArraydeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArraydeEv")
  //</editor-fold>
  public MDTuple /*&*/ $star() /*const*/ {
    return $Deref(get());
  }


  // FIXME: Fix callers and remove condition on N.
  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 101,
   FQN="llvm::DITypeRefArray::size", NM="_ZNK4llvm14DITypeRefArray4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return (N != null) ? N.getNumOperands() : 0/*U*/;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 102,
   FQN="llvm::DITypeRefArray::operator[]", NM="_ZNK4llvm14DITypeRefArrayixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArrayixEj")
  //</editor-fold>
  public TypedDINodeRef<DIType> $at(/*uint*/int I) /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, N.getOperand(I).$Metadata$P());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 104,
   FQN="llvm::DITypeRefArray::iterator", NM="_ZN4llvm14DITypeRefArray8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorE")
  //</editor-fold>
  public static class iterator implements type$iterator<type$iterator, TypedDINodeRef<DIType>>, std.iterator<std.input_iterator_tag, TypedDINodeRef<DIType>> {
    private type$ptr<MDOperand/*P*/> I/* = null*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 109,
     FQN="llvm::DITypeRefArray::iterator::iterator", NM="_ZN4llvm14DITypeRefArray8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : std::iterator<std::input_iterator_tag, DITypeRef, std::ptrdiff_t, void, DITypeRef>(), I(null)/* = default*/
      //START JInit
      $iterator();
      /*InClass*/this.I = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 110,
     FQN="llvm::DITypeRefArray::iterator::iterator", NM="_ZN4llvm14DITypeRefArray8iteratorC1EPKNS_9MDOperandE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorC1EPKNS_9MDOperandE")
    //</editor-fold>
    public /*explicit*/ iterator(type$ptr<MDOperand/*P*/> I) {
      // : std::iterator<std::input_iterator_tag, DITypeRef, std::ptrdiff_t, void, DITypeRef>(), I(I)
      //START JInit
      $iterator();
      this.I = $tryClone(I);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 111,
     FQN="llvm::DITypeRefArray::iterator::operator*", NM="_ZNK4llvm14DITypeRefArray8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray8iteratordeEv")
    //</editor-fold>
    public TypedDINodeRef<DIType> $star() /*const*/ {
      return new TypedDINodeRef<DIType>(DIType.class, I.$star().$Metadata$P());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 112,
     FQN="llvm::DITypeRefArray::iterator::operator++", NM="_ZN4llvm14DITypeRefArray8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      I.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 116,
     FQN="llvm::DITypeRefArray::iterator::operator++", NM="_ZN4llvm14DITypeRefArray8iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorppEi")
    //</editor-fold>
    public iterator $postInc(int $Prm0) {
      iterator Temp/*J*/= new iterator(/*Deref*/this);
      I.$preInc();
      return Temp;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 121,
     FQN="llvm::DITypeRefArray::iterator::operator==", NM="_ZNK4llvm14DITypeRefArray8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return $eq_ptr(I, X.I);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 122,
     FQN="llvm::DITypeRefArray::iterator::operator!=", NM="_ZNK4llvm14DITypeRefArray8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ X) /*const*/ {
      return $noteq_ptr(I, X.I);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 104,
     FQN="llvm::DITypeRefArray::iterator::iterator", NM="_ZN4llvm14DITypeRefArray8iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ iterator(final /*const*/ iterator /*&*/ $Prm0) {
      // : std::iterator<std::input_iterator_tag, DITypeRef, std::ptrdiff_t, void, DITypeRef>(), I(.I)
      //START JInit
      $iterator($Prm0);
      this.I = $tryClone($Prm0.I);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 104,
     FQN="llvm::DITypeRefArray::iterator::iterator", NM="_ZN4llvm14DITypeRefArray8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArray8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : std::iterator<std::input_iterator_tag, DITypeRef, std::ptrdiff_t, void, DITypeRef>(static_cast<iterator &&>()), I(static_cast<iterator &&>().I)
      //START JInit
      $iterator(JD$Move.INSTANCE, $Prm0);
      this.I = $tryClone($Prm0.I);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public iterator clone() {
      return new iterator(this);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "I=" + I // NOI18N
                + super.toString(); // NOI18N
    }
  };

  // FIXME: Fix callers and remove condition on N.
  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 126,
   FQN="llvm::DITypeRefArray::begin", NM="_ZNK4llvm14DITypeRefArray5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray5beginEv")
  //</editor-fold>
  public iterator begin() /*const*/ {
    return (N != null) ? new iterator(N.op_begin()) : new iterator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 127,
   FQN="llvm::DITypeRefArray::end", NM="_ZNK4llvm14DITypeRefArray3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DITypeRefArray3endEv")
  //</editor-fold>
  public iterator end() /*const*/ {
    return (N != null) ? new iterator(N.op_end()) : new iterator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::DITypeRefArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 86,
   FQN="llvm::DITypeRefArray::DITypeRefArray", NM="_ZN4llvm14DITypeRefArrayC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArrayC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DITypeRefArray(final /*const*/ DITypeRefArray /*&*/ $Prm0) {
    // : N(.N)
    //START JInit
    this.N = $Prm0.N;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DITypeRefArray::DITypeRefArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 86,
   FQN="llvm::DITypeRefArray::DITypeRefArray", NM="_ZN4llvm14DITypeRefArrayC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DITypeRefArrayC1EOS0_")
  //</editor-fold>
  public /*inline*/ DITypeRefArray(JD$Move _dparam, final DITypeRefArray /*&&*/$Prm0) {
    // : N(static_cast<DITypeRefArray &&>().N)
    //START JInit
    this.N = $Prm0.N;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<TypedDINodeRef<DIType>> iterator() {
    return new JavaIterator<>(begin(), end());
  }

   // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "N=" + N; // NOI18N
  }
}
