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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.ast.java.AstMemberPointers.*;

/// \brief Represents a lazily-loaded vector of data.
///
/// The lazily-loaded vector of data contains data that is partially loaded
/// from an external source and partially added by local translation. The 
/// items loaded from the external source are loaded lazily, when needed for
/// iteration over the complete vector.
/*template <typename T, typename Source, void (Source::*)(SmallVectorImpl<T> &) Loader, unsigned int LoadedStorage = 2, unsigned int LocalStorage = 4> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::LazyVector">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 482,
 FQN="clang::LazyVector", NM="_ZN5clang10LazyVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVectorE")
//</editor-fold>
public class LazyVector</*typename*/ T, /*typename*/ Source/*, Loader extends Source$SmallVector2Void<Source, T>, uint LoadedStorage = 2, uint LocalStorage = 4*/> implements Destructors.ClassWithDestructor {  
  private SmallVector<T> Loaded;
  private SmallVector<T> Local;  
/*public:*/
  /// Iteration over the elements in the vector.
  ///
  /// In a complete iteration, the iterator walks the range [-M, N),
  /// where negative values are used to indicate elements
  /// loaded from the external source while non-negative values are used to
  /// indicate elements added via \c push_back().
  /// However, to provide iteration in source order (for, e.g., chained
  /// precompiled headers), dereferencing the iterator flips the negative
  /// values (corresponding to loaded entities), so that position -M
  /// corresponds to element 0 in the loaded entities vector, position -M+1
  /// corresponds to element 1 in the loaded entities vector, etc. This
  /// gives us a reasonably efficient, source-order walk.
  ///
  /// We define this as a wrapping iterator around an int. The
  /// iterator_adaptor_base class forwards the iterator methods to basic integer
  /// arithmetic.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::iterator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 506,
   FQN="clang::LazyVector::iterator", NM="_ZN5clang10LazyVector8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector8iteratorE")
  //</editor-fold>
  public static class iterator<T, Source/*, Loader extends Source$SmallVector2Void<Source, T>*/> extends /*public*/ iterator_adaptor$Int_base<iterator<T, Source>, /*int, */ std.random_access_iterator_tag, T/*, int, T * , T &*/ > {
    private LazyVector<T, Source> /*P*/ Self;
    
    //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 511,
     FQN="clang::LazyVector::iterator::iterator", NM="_ZN5clang10LazyVector8iteratorC1EPNS_10LazyVectorIT_T0_XT1_EXT2_EXT3_EEEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector8iteratorC1EPNS_10LazyVectorIT_T0_XT1_EXT2_EXT3_EEEi")
    //</editor-fold>
    private iterator(LazyVector<T, Source>/*P*/ Self, int Position) {
      // : iterator::iterator_adaptor_base(Position), Self(Self) 
      //START JInit
      /*ParenListExpr*/super(Position);
      this.Self = /*ParenListExpr*/Self;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::iterator::isLoaded">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 514,
     FQN="clang::LazyVector::iterator::isLoaded", NM="_ZNK5clang10LazyVector8iterator8isLoadedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang10LazyVector8iterator8isLoadedEv")
    //</editor-fold>
    private boolean isLoaded() /*const*/ {
      return Native.$less(this.I.$deref(), 0);
    }

    /*friend  class LazyVector<T, Source, Loader, LoadedStorage, LocalStorage>*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 518,
     FQN="clang::LazyVector::iterator::iterator", NM="_ZN5clang10LazyVector8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : iterator(null, 0) 
      //START JInit
      /*ParenListExpr*/super(null, 0);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 520,
     FQN="clang::LazyVector::iterator::operator*", NM="_ZNK5clang10LazyVector8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang10LazyVector8iteratordeEv")
    //</editor-fold>
    public  T /*&*/ $star() /*const*/ {
      if (isLoaded()) {
        return Self.Loaded.end().$at(this.I);
      }
      return Self.Local.begin().$at(this.I);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private type$ptr<T> $addr() {      
      if (isLoaded()) {
        return Self.Loaded.end().$add(this.I.$deref());
      }
      return Self.Local.begin().$add(this.I.$deref());
    }

    @Override public iterator<T, Source> clone() {
      return new iterator(this.Self, this.I.$deref());
    }
    
    @Override public boolean $eq(Object other) {
      if (other instanceof LazyVector.iterator) {
        LazyVector.iterator otherIt = (LazyVector.iterator) other;
        if (Self == otherIt.Self) {
          return this.I.$deref() == otherIt.I.$deref();
        }
      }
      return false;
    }

    @Override public type$ref<T> star$ref() {
      return $addr().star$ref();
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Self=" + "[LazyVector$T$Source]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 527,
   FQN="clang::LazyVector::begin", NM="_ZN5clang10LazyVector5beginEPT0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector5beginEPT0_b")
  //</editor-fold>
  public iterator<T, Source> begin(Source /*P*/ source) {
    return begin(source, false);
  }
  public iterator<T, Source> begin(Source /*P*/ source, boolean LocalOnly/*= false*/) {
    if (LocalOnly) {
      return new iterator(this, 0);
    }
    if ($bool(source)) {
      Loader.$call(source, Loaded);
    }
    return new iterator(this, -(int)Loaded.size());    
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 536,
   FQN="clang::LazyVector::end", NM="_ZN5clang10LazyVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector3endEv")
  //</editor-fold>
  public iterator end() {
    return new iterator(this, Local.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 540,
   FQN="clang::LazyVector::push_back", NM="_ZN5clang10LazyVector9push_backERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector9push_backERKT_")
  //</editor-fold>
  public void push_back(final /*const*/ T /*&*/ LocalValue) {
    Local.push_back(LocalValue);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyVector::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 544,
   FQN="clang::LazyVector::erase", NM="_ZN5clang10LazyVector5eraseENS0_8iteratorES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang10LazyVector5eraseENS0_8iteratorES1_")
  //</editor-fold>
  public void erase(iterator From, iterator To) {
    if (Native.$bool(From.isLoaded()) && Native.$bool(To.isLoaded())) {
      Loaded.erase(From.$addr(), To.$addr());
      return;
    }
    if (From.isLoaded()) {
      Loaded.erase(From.$addr(), Loaded.end());
      From = begin(null, true);
    }
    
    Local.erase(From.$addr(), To.$addr());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final Source$SmallVector2Void<Source, T> Loader;

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public LazyVector(Source$SmallVector2Void<Source, T> Loader, /*uint*/int LoadedStorage/* = 2*/, /*uint*/int LocalStorage /* = 4*/) {
    assert Loader != null;
    this.Loader = Loader;
    this.Loaded = new SmallVector<>(LoadedStorage, (T)null);
    this.Local = new SmallVector<>(LocalStorage, (T)null);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void $destroy() {
    this.Local.$destroy();
    this.Loaded.$destroy();
    Destructors.$destroy(this.Loader);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Loaded=" + Loaded // NOI18N
              + ", Local=" + Local; // NOI18N
  }
}
