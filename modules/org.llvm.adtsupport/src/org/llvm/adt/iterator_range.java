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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.ArrayRef;

/*template <typename IteratorT> TEMPLATE*/
/// \brief A range adaptor for a pair of iterators.
///
/// This just wraps two iterators into a range-compatible interface. Nothing
/// fancy at all.
//<editor-fold defaultstate="collapsed" desc="llvm::iterator_range">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 31,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 30,
 FQN = "llvm::iterator_range", NM = "_ZN4llvm14iterator_rangeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN4llvm14iterator_rangeE")
//</editor-fold>
public class iterator_range<Type> implements Iterable<Type>, NativeIterable<type$iterator<?, Type>>, NativeCloneable<iterator_range<Type>> {
  private static final type$iterator NULL = Native.$toConst(create_type$ptr());
  
  private type$iterator<?, Type> begin_iterator;
  private type$iterator<?, Type> end_iterator;
  /*public:*/

  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_range::iterator_range<IteratorT>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 35,
   FQN = "llvm::iterator_range::iterator_range<IteratorT>", NM = "_ZN4llvm14iterator_rangeC1ET_S1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZN4llvm14iterator_rangeC1ET_S1_")
  //</editor-fold>
  public iterator_range(type$iterator<?, Type> begin_iterator, type$iterator<?, Type> end_iterator) {
    /* : begin_iterator(std::move(begin_iterator)), end_iterator(std::move(end_iterator))*/
    //START JInit
    this.begin_iterator = (begin_iterator == null || begin_iterator == NULL) ? NULL : $tryClone(std.move(begin_iterator));
    this.end_iterator = (end_iterator == null || end_iterator == NULL) ? NULL : $tryClone(std.move(end_iterator));
    //END JInit
  }
  
  public iterator_range(iterator_range<Type> other) {
    this.begin_iterator = (other.begin_iterator == NULL) ? NULL : $tryClone(other.begin_iterator);
    this.end_iterator = (other.end_iterator == NULL) ? NULL : $tryClone(other.end_iterator);
  }

  public iterator_range(JavaDifferentiators.JD$Move _dparam, iterator_range<Type> other) {
    this.begin_iterator = other.begin_iterator;
    other.begin_iterator = NULL;
    this.end_iterator = other.end_iterator;
    other.end_iterator = NULL;
  }
  
  public iterator_range(ArrayRef<Type> other) {
    this(other.begin(), other.end());
  }

  public iterator_range<Type> $assignMove(iterator_range<Type> other) {
    if (this == other) {
      return this;
    }
    this.begin_iterator = other.begin_iterator;
    other.begin_iterator = NULL;
    this.end_iterator = other.end_iterator;
    other.end_iterator = NULL;
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_range::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 39,
   FQN = "llvm::iterator_range::begin", NM = "_ZNK4llvm14iterator_range5beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZNK4llvm14iterator_range5beginEv")
  //</editor-fold>
  public type$iterator<?, Type> begin() /*const*/ {
    return begin_iterator;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_range::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", line = 47,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator_range.h", old_line = 40,
   FQN = "llvm::iterator_range::end", NM = "_ZNK4llvm14iterator_range3endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Program.cpp -nm=_ZNK4llvm14iterator_range3endEv")
  //</editor-fold>
  public type$iterator<?, Type> end() /*const*/ {
    return end_iterator;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public iterator_range() { this(NULL, NULL); }

  @Override
  public iterator_range<Type> clone() {
    return new iterator_range<>(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  public String toString() {
    return "" + "begin_iterator=" + (begin_iterator == NULL ? "<NULL> " : begin_iterator) // NOI18N
            + ", end_iterator=" + (end_iterator == NULL ? "<NULL>" : end_iterator); // NOI18N
  }

  @Override
  public Iterator<Type> iterator() {
    return new Iterator<Type>() {

      final type$iterator<?, Type> delegate = begin_iterator == NULL ? NULL : $tryClone(begin_iterator);

      @Override
      public boolean hasNext() {
        return $noteq_iter(delegate, end_iterator);
      }

      @Override
      public Type next() {
        Type result = delegate.$star();
        delegate.$preInc();
        return result;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException("Not supported.");
      }
    };
  }
}
