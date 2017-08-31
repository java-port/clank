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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;


/// \brief Typed, array-like tuple of metadata.
///
/// This is a wrapper for \a MDTuple that makes it act like an array holding a
/// particular type of metadata.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1154,
 FQN="llvm::MDTupleTypedArrayWrapper", NM="_ZN4llvm24MDTupleTypedArrayWrapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm24MDTupleTypedArrayWrapperE")
//</editor-fold>
public class MDTupleTypedArrayWrapper</*class*/ T>  implements Iterable<T>, Native.Native$Bool {
  private /*const*/ MDTuple /*P*/ N/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1158,
   FQN="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>", NM="_ZN4llvm24MDTupleTypedArrayWrapperC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm24MDTupleTypedArrayWrapperC1Ev")
  //</editor-fold>
  public MDTupleTypedArrayWrapper(Class<T> clazz)/* = default*/ {
    /*<<<defaulted constructor: may be there is another TU where objects are created?>>>*/
    this.clazz = clazz;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1159,
   FQN="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>", NM="_ZN4llvm24MDTupleTypedArrayWrapperC1EPKNS_7MDTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm24MDTupleTypedArrayWrapperC1EPKNS_7MDTupleE")
  //</editor-fold>
  public MDTupleTypedArrayWrapper(Class<T> clazz, /*const*/ MDTuple /*P*/ N) {
    // : N(N)
    //START JInit
    this.N = N;
    this.clazz = clazz;
    //END JInit
  }


  /*template <class U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1162,
   FQN="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>", NM="Tpl__ZN4llvm24MDTupleTypedArrayWrapperC1ERKNS_24MDTupleTypedArrayWrapperIT_EEPNSt9enable_ifIXsr14is_convertibleIPS2_PT_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm24MDTupleTypedArrayWrapperC1ERKNS_24MDTupleTypedArrayWrapperIT_EEPNSt9enable_ifIXsr14is_convertibleIPS2_PT_EE5valueEvE4typeE")
  //</editor-fold>
  public </*class*/ U extends T> MDTupleTypedArrayWrapper(JD$Convertible _dparam, Class<T> clazz, final /*const*/ MDTupleTypedArrayWrapper<U> /*&*/ Other) {
    // : N(Other.get())
    //START JInit
    this.N = /*ParenListExpr*/Other.get();
    this.clazz = clazz;
    //END JInit
  }


  /*template <class U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1169,
   FQN="llvm::MDTupleTypedArrayWrapper::MDTupleTypedArrayWrapper<T>", NM="Tpl__ZN4llvm24MDTupleTypedArrayWrapperC1ERKNS_24MDTupleTypedArrayWrapperIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIPS2_PT_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm24MDTupleTypedArrayWrapperC1ERKNS_24MDTupleTypedArrayWrapperIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIPS2_PT_EE5valueEvE4typeE")
  //</editor-fold>
  public /*explicit*/ </*class*/ U> MDTupleTypedArrayWrapper(JD$NotConvertible _dparam, Class<T> clazz, final /*const*/ MDTupleTypedArrayWrapper<U> /*&*/ Other) {
    // : N(Other.get())
    //START JInit
    this.N = /*ParenListExpr*/Other.get();
    this.clazz = clazz;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1175,
   FQN="llvm::MDTupleTypedArrayWrapper::operator bool", NM="_ZNK4llvm24MDTupleTypedArrayWrappercvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrappercvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return get() != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::operator MDTuple * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1176,
   FQN="llvm::MDTupleTypedArrayWrapper::operator MDTuple * ", NM="_ZNK4llvm24MDTupleTypedArrayWrappercvPNS_7MDTupleEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrappercvPNS_7MDTupleEEv")
  //</editor-fold>
  public MDTuple /*P*/ $MDTuple$P() /*const*/ {
    return get();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1178,
   FQN="llvm::MDTupleTypedArrayWrapper::get", NM="_ZNK4llvm24MDTupleTypedArrayWrapper3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapper3getEv")
  //</editor-fold>
  public MDTuple /*P*/ get() /*const*/ {
    return ((/*const_cast*/MDTuple /*P*/ )(N));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1179,
   FQN="llvm::MDTupleTypedArrayWrapper::operator->", NM="_ZNK4llvm24MDTupleTypedArrayWrapperptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapperptEv")
  //</editor-fold>
  public MDTuple /*P*/ $arrow() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1180,
   FQN="llvm::MDTupleTypedArrayWrapper::operator*", NM="_ZNK4llvm24MDTupleTypedArrayWrapperdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapperdeEv")
  //</editor-fold>
  public MDTuple /*&*/ $star() /*const*/ {
    return $Deref(get());
  }


  // FIXME: Fix callers and remove condition on N.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::size">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1183,
   FQN="llvm::MDTupleTypedArrayWrapper::size", NM="_ZNK4llvm24MDTupleTypedArrayWrapper4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapper4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return (N != null) ? N.getNumOperands() : 0/*U*/;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1184,
   FQN="llvm::MDTupleTypedArrayWrapper::operator[]", NM="_ZNK4llvm24MDTupleTypedArrayWrapperixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapperixEj")
  //</editor-fold>
  public T /*P*/ $at(/*uint*/int I) /*const*/ {
    return cast_or_null(clazz, N.getOperand(I));
  }


  // FIXME: Fix callers and remove condition on N.
  // JAVA: typedef TypedMDOperandIterator<T> iterator
//  public final class iterator extends TypedMDOperandIterator<T>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1188,
   FQN="llvm::MDTupleTypedArrayWrapper::begin", NM="_ZNK4llvm24MDTupleTypedArrayWrapper5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapper5beginEv")
  //</editor-fold>
  public TypedMDOperandIterator/*<T>*/ begin() /*const*/ {
    return (N != null) ? new TypedMDOperandIterator(clazz, N.op_begin()) : new TypedMDOperandIterator(clazz);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDTupleTypedArrayWrapper::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1189,
   FQN="llvm::MDTupleTypedArrayWrapper::end", NM="_ZNK4llvm24MDTupleTypedArrayWrapper3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm24MDTupleTypedArrayWrapper3endEv")
  //</editor-fold>
  public TypedMDOperandIterator end() /*const*/ {
    return (N != null) ? new TypedMDOperandIterator(clazz, N.op_end()) : new TypedMDOperandIterator(clazz);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public MDTupleTypedArrayWrapper $assignMove(final /*const*/ MDTupleTypedArrayWrapper<T> /*&*/ Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public MDTupleTypedArrayWrapper(MDTupleTypedArrayWrapper<T> Other) {
    this.N = new MDTuple(Other.N);
    this.clazz = Other.clazz;
  }

  public @Override Iterator<T> iterator() {
   return new JavaIterator<T>(begin(), end());
  }

  private final Class<T> clazz;


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "N=" + N; // NOI18N
  }
}
