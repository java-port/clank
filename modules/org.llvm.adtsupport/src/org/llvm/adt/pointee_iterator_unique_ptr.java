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

import org.clank.java.std;
import org.clank.support.Converted;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.type$iterator;
import org.clank.support.aliases.type$ref;

/**
 *
 * @author petrk
 */

//<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 228,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 226,
 FQN = "llvm::pointee_iterator", NM = "_ZN4llvm16pointee_iteratorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN4llvm16pointee_iteratorE")
//</editor-fold>
public class pointee_iterator_unique_ptr<T> implements type$iterator<pointee_iterator_unique_ptr<T>, T> {
  
  private type$iterator<?, std.unique_ptr<T>> delegate;
  
  // Copy constructor
  private pointee_iterator_unique_ptr(pointee_iterator_unique_ptr<T> iter) {
    this.delegate = $tryClone(iter.delegate);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 236,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 234,
   FQN = "llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>", NM = "_ZN4llvm16pointee_iteratorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN4llvm16pointee_iteratorC1Ev")
  //</editor-fold>
  public pointee_iterator_unique_ptr() {
  }

  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 236,
   FQN = "llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>", NM = "_ZN4llvm16pointee_iteratorC1EOT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN4llvm16pointee_iteratorC1EOT_")
  //</editor-fold>
  public pointee_iterator_unique_ptr(type$iterator<?, std.unique_ptr<T>> /*&&*/u) {
    /* : pointee_iterator<WrappedIteratorT, T>::iterator_adaptor_base(std::forward<U &&>(u))*/ 
    this.delegate = $tryClone(u);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 241,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 239,
   FQN = "llvm::pointee_iterator::operator*", NM = "_ZNK4llvm16pointee_iteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK4llvm16pointee_iteratordeEv")
  //</editor-fold>
  @Override
  public T /*&*/ $star() /*const*/ {
    return delegate.$star().$star();
  }

  @Override
  public type$ref<T> star$ref() {
    return delegate.$star().star$ref();
  }
  
  @Override
  public pointee_iterator_unique_ptr<T> $preInc() {
    delegate.$preInc();
    return this;
  }
  
  @Override
  public pointee_iterator_unique_ptr<T> $preDec() {
    delegate.$preDec();
    return this;
  }
  
  @Override
  public pointee_iterator_unique_ptr<T> $inc(int amount) {
    delegate.$inc(amount);
    return this;
  }

  @Override
  public int $sub(pointee_iterator_unique_ptr<T> iter) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public pointee_iterator_unique_ptr<T> $postInc() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public pointee_iterator_unique_ptr<T> $postDec() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public pointee_iterator_unique_ptr<T> $dec(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public pointee_iterator_unique_ptr<T> $add(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public pointee_iterator_unique_ptr<T> $sub(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public pointee_iterator_unique_ptr<T> clone() {
    return new pointee_iterator_unique_ptr<>(this);
  }

  @Override
  public pointee_iterator_unique_ptr<T> const_clone() {
    return new pointee_iterator_unique_ptr<>(this);
  }

  @Override
  public boolean $noteq(Object other) {
    if (other instanceof pointee_iterator_unique_ptr) {
      return this.delegate.$noteq(((pointee_iterator_unique_ptr) other).delegate);
    }
    return true;
  }

  @Override
  public boolean $eq(Object other) {
    if (other instanceof pointee_iterator_unique_ptr) {
      return this.delegate.$eq(((pointee_iterator_unique_ptr) other).delegate);
    }
    return false;
  }
  
  public String toString() {
    return delegate.toString();
  }
}
