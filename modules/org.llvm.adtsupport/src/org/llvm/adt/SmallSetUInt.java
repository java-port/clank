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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/*template <typename T, unsigned int N, typename C = std::less<T>> TEMPLATE*/

/// SmallSet - This maintains a set of unique values, optimizing for the case
/// when the set is small (less than N).  In this case, the set can be
/// maintained with no mallocs.  If the set gets large, we expand to using an
/// std::set to maintain reasonable lookup times.
///
/// Note that this set does not provide a way to iterate over members in the
/// set.
//<editor-fold defaultstate="collapsed" desc="llvm::SmallSet">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 31,
 FQN = "llvm::SmallSet", NM = "_ZN4llvm8SmallSetE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN4llvm8SmallSetE")
//</editor-fold>
public class SmallSetUInt/*<typename T, uint N, typename C = std::less<T>>*/ implements Destructors.ClassWithDestructor, NativeCloneable<SmallSetUInt> {
  /// Use a SmallVector to hold the elements here (even though it will never
  /// reach its 'large' stage) to avoid calling the default ctors of elements
  /// we will never use.
  private final /*uint*/int N;
  private SmallVectorUInt Vector;
  private std.setUInt Set;
  /*typedef typename SmallVector<T, N>::const_iterator VIterator*/
//  public final class VIterator extends  SmallVector<T, N>.const_iterator{ };
  /*typedef typename SmallVector<T, N>::iterator mutable_iterator*/
//  public final class mutable_iterator extends  SmallVector<T, N>.iterator{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::SmallSet<T, N, C>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 42,
   FQN = "llvm::SmallSet::SmallSet<T, N, C>", NM = "_ZN4llvm8SmallSetC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN4llvm8SmallSetC1EvN, C>")
  //</editor-fold>

  public SmallSetUInt(/*uint*/int N) {
    this.N = N;
    this.Vector = new SmallVectorUInt((int) N, 0);
    this.Set = new std.setUInt();
  }
  
  public SmallSetUInt(JavaDifferentiators.JD$Move _dparam, SmallSetUInt other) {
    this.N = other.N;
    this.Vector = other.Vector;
    this.Set = other.Set;
    other.Vector = null;
    other.Set = null;
  }
  
  public SmallSetUInt(SmallSetUInt other) {
    this.N = other.N;
    this.Vector = new SmallVectorUInt(other.Vector);
    this.Set = new std.setUInt(other.Set);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 45,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 44,
   FQN = "llvm::SmallSet::empty", NM = "_ZNK4llvm8SmallSet5emptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK4llvm8SmallSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Vector.empty() && Set.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 48,
   FQN = "llvm::SmallSet::size", NM = "_ZNK4llvm8SmallSet4sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK4llvm8SmallSet4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return isSmall() ? Vector.size() : Set.size();
  }

  
  /// count - Return true if the element is in the set.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 53,
   FQN = "llvm::SmallSet::count", NM = "_ZNK4llvm8SmallSet5countERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK4llvm8SmallSet5countERKT_")
  //</editor-fold>
  public int count(/*const*/int /*&*/ V) /*const*/ {
    if (isSmall()) {
      // Since the collection is small, just do a linear search.
      return $noteq_iter(vfind(V), Vector.end()) ? 1 : 0;
    } else {
      return Set.count(V) ? 1 : 0;
    }
  }

  
  /// insert - Insert an element into the set if it isn't already there.
  /// Returns true if the element is inserted (it was not in the set before).
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 69,
   FQN = "llvm::SmallSet::insert", NM = "_ZN4llvm8SmallSet6insertERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN4llvm8SmallSet6insertERKT_")
  //</editor-fold>
  public boolean insert(/*const*/int /*&*/ V) {
    if (!isSmall()) {
      return Set.insert(V).second;
    }
    
    uint$ptr I = vfind(V);
    if ($noteq_iter(I, Vector.end())) {
      // Don't reinsert if it already exists.
      return false;
    }
    if (Vector.size() < N) {
      Vector.push_back(V);
      return true;
    }
    
    // Otherwise, grow from vector to set.
    while (!Vector.empty()) {
      Set.insert(Vector.back());
      Vector.pop_back();
    }
    Set.insert(V);
    return true;
  }

  /*template <typename IterT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 81,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -filter=llvm::SmallSet::insert")
  //</editor-fold>
  public </*typename*/ IterT extends type$iterator<?, Integer>> void insert(IterT I, IterT E) {
    for (; $noteq_iter(I, E); I.$preInc())  {
      insert($Deref(I.$star()));
    }
  }

  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 81)
  public void insert$T(uint$ptr I, uint$ptr E) {
    for (; $noteq_iter(I, E); I.$preInc())  {
      insert($Deref(I.$star()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::erase">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 96,
   FQN = "llvm::SmallSet::erase", NM = "_ZN4llvm8SmallSet5eraseERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN4llvm8SmallSet5eraseERKT_")
  //</editor-fold>
  public boolean erase(/*const*/int /*&*/ V) {
    if (!isSmall()) {
      return Set.erase(V);
    }
    for (uint$ptr I = Vector.begin(), E = Vector.end(); $noteq_iter(I, E); I.$preInc())  {
      if ($eq($Deref(I), V)) {
        Vector.erase(I);
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 107,
   FQN = "llvm::SmallSet::clear", NM = "_ZN4llvm8SmallSet5clearEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN4llvm8SmallSet5clearEv")
  //</editor-fold>
  public void clear() {
    Vector.clear();
    Set.clear();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::isSmall">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 112,
   FQN = "llvm::SmallSet::isSmall", NM = "_ZNK4llvm8SmallSet7isSmallEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK4llvm8SmallSet7isSmallEv")
  //</editor-fold>
  private boolean isSmall() /*const*/ {
    return Set.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallSet::vfind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallSet.h", old_line = 114,
   FQN = "llvm::SmallSet::vfind", NM = "_ZNK4llvm8SmallSet5vfindERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK4llvm8SmallSet5vfindERKT_")
  //</editor-fold>
  private uint$ptr vfind(/*const*/int /*&*/ V) /*const*/ {
    for (uint$ptr I = Vector.begin(), E = Vector.end(); $noteq_iter(I, E); I.$preInc())  {
      if ($eq(I.$star(), V)) {
        return I;
      }
    }
    return Vector.end();
  }

  @Override
  public void $destroy() {
    if (Vector != null) {
      Vector.$destroy();
    }
    if (Set != null) {
      Set.$destroy();
    }
  }
  
  @Override public SmallSetUInt clone() { return new SmallSetUInt(this); }
}
