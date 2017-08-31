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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;


/// \brief Typed iterator through MDNode operands.
///
/// An iterator that transforms an \a MDNode::iterator into an iterator over a
/// particular Metadata subclass.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1128,
 FQN="llvm::TypedMDOperandIterator", NM="_ZN4llvm22TypedMDOperandIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm22TypedMDOperandIteratorE")
//</editor-fold>
public class TypedMDOperandIterator</*class*/ T extends MDNode>  implements std.iterator<std.input_iterator_tag, T /*P*/>, type$iterator<TypedMDOperandIterator<T>, T>/*, Native.NativeComparable<TypedMDOperandIterator>*/ {
  private type$ptr<MDOperand/*P*/> I/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::TypedMDOperandIterator<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1134,
   FQN="llvm::TypedMDOperandIterator::TypedMDOperandIterator<T>", NM="_ZN4llvm22TypedMDOperandIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm22TypedMDOperandIteratorC1Ev")
  //</editor-fold>
  public TypedMDOperandIterator(Class<T> clazz)/* = default*/ {
    /*<<<defaulted constructor: may be there is another TU where objects are created?>>>*/
    this.clazz = clazz;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::TypedMDOperandIterator<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1135,
   FQN="llvm::TypedMDOperandIterator::TypedMDOperandIterator<T>", NM="_ZN4llvm22TypedMDOperandIteratorC1EPKNS_9MDOperandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm22TypedMDOperandIteratorC1EPKNS_9MDOperandE")
  //</editor-fold>
  public /*explicit*/ TypedMDOperandIterator(Class<T> clazz, type$ptr<MDOperand/*P*/> I) {
    // : I(I)
    //START JInit
    this.I = $tryClone(I);
    this.clazz = clazz;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1136,
   FQN="llvm::TypedMDOperandIterator::operator*", NM="_ZNK4llvm22TypedMDOperandIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm22TypedMDOperandIteratordeEv")
  //</editor-fold>
  public T /*P*/ $star() /*const*/ {
    return cast_or_null(clazz, I.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1137,
   FQN="llvm::TypedMDOperandIterator::operator++", NM="_ZN4llvm22TypedMDOperandIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm22TypedMDOperandIteratorppEv")
  //</editor-fold>
  public TypedMDOperandIterator<T> /*&*/ $preInc() {
    I.$preInc();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1141,
   FQN="llvm::TypedMDOperandIterator::operator++", NM="_ZN4llvm22TypedMDOperandIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm22TypedMDOperandIteratorppEi")
  //</editor-fold>
  public TypedMDOperandIterator<T> $postInc(int $Prm0) {
    TypedMDOperandIterator<T> Temp/*J*/= /*ParenList*/new TypedMDOperandIterator<T>(/*Deref*/this);
    I.$preInc();
    return Temp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1146,
   FQN="llvm::TypedMDOperandIterator::operator==", NM="_ZNK4llvm22TypedMDOperandIteratoreqERKNS_22TypedMDOperandIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm22TypedMDOperandIteratoreqERKNS_22TypedMDOperandIteratorIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ TypedMDOperandIterator<T> /*&*/ X) /*const*/ {
    return Native.$eq((abstract_iterator)I, X.I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedMDOperandIterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1147,
   FQN="llvm::TypedMDOperandIterator::operator!=", NM="_ZNK4llvm22TypedMDOperandIteratorneERKNS_22TypedMDOperandIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm22TypedMDOperandIteratorneERKNS_22TypedMDOperandIteratorIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ TypedMDOperandIterator<T> /*&*/ X) /*const*/ {
    return Native.$noteq((abstract_iterator)I, X.I);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public TypedMDOperandIterator<T> clone() {
    return new TypedMDOperandIterator<T>(clazz, I.clone());
  }

  public TypedMDOperandIterator(TypedMDOperandIterator<T> Other) {
    I = Other.I.clone();
    clazz = Other.clazz;
  }

  private final Class<T> clazz;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "I=" + I // NOI18N
              + super.toString(); // NOI18N
  }
}
