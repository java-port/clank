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
package org.llvm.support.sys;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.std;
import static org.clank.java.std.getenv;
import static org.clank.java.std.strlen;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.JavaDifferentiators.*;
import org.clank.support.NativeTrace;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.aliases.SmallVectorImplChar;
import static org.llvm.support.impl.PathStatics.*;
import org.llvm.support.llvm;
import static org.llvm.support.llvm.*;
import org.llvm.support.sys.impl.PathAppendHelper;
import org.llvm.support.sys.impl.PathStatics;
import static org.llvm.support.sys.impl.PathStatics.getUserCacheDir;

//<editor-fold defaultstate="collapsed" desc="static type path">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body ${LLVM_SRC}/llvm/lib/Support/Path.cpp -namespace=llvm::sys::path")
//</editor-fold>
public final class path {
                    
                    /// @name Lexical Component Iterator
/// @{

/// @brief Path iterator.
///
/// This is an input iterator that iterates over the individual components in
/// \a path. The traversal order is as follows:
/// * The root-name element, if present.
/// * The root-directory element, if present.
/// * Each successive filename element, if present.
/// * Dot, if one or more trailing non-root slash characters are present.
/// Traversing backwards is possible with \a reverse_iterator
///
/// Iteration examples. Each component is separated by ',':
/// @code
///   /          => /
///   /foo       => /,foo
///   foo/       => foo,.
///   /foo/bar   => /,foo,bar
///   ../        => ..,.
///   C:\foo\bar => C:,/,foo,bar
/// @endcode
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 50,
 FQN="llvm::sys::path::const_iterator", NM="_ZN4llvm3sys4path14const_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14const_iteratorE")
//</editor-fold>
public static class const_iterator implements /*public*/ std.iterator<std.input_iterator_tag, /*const*/ StringRef>, type$iterator<const_iterator, StringRef> {
  private final StringRef Path; ///< The entire path.
  private StringRef Component; ///< The current component. Not necessarily in Path.
  private /*size_t*/int Position; ///< The iterators current position within Path.

  // #JAVA
  public const_iterator(StringRef Path, StringRef Component, int Position) {
    this.Path = Path;
    this.Component = Component;
    this.Position = Position;
  }
  
  // An end iterator has Position = Path.size() + 1.
  /*friend const_iterator begin(StringRef path)*/
  /*friend const_iterator end(StringRef path)*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 61,
   FQN = "llvm::sys::path::const_iterator::operator*", NM = "_ZNK4llvm3sys4path14const_iteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path14const_iteratordeEv")
  //</editor-fold>
  public /*const*/ StringRef $star() /*const*/ {
    return Component;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 62,
   FQN = "llvm::sys::path::const_iterator::operator->", NM = "_ZNK4llvm3sys4path14const_iteratorptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path14const_iteratorptEv")
  //</editor-fold>
  public /*const*/ StringRef $arrow() /*const*/ {
    return $AddrOf(Component);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 247,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 255,
   FQN = "llvm::sys::path::const_iterator::operator++", NM = "_ZN4llvm3sys4path14const_iteratorppEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14const_iteratorppEv")
  //</editor-fold>
  public const_iterator /*&*/ $preInc() {
    assert (Position < Path.size()) : "Tried to increment past end!";
    
    // Increment Position to past the current component
    Position += Component.size();
    
    // Check for end.
    if (Position == Path.size()) {
      Component = StringRef.R$EMPTY;
      return /*Deref*/this;
    }
    
    // Both POSIX and Windows treat paths that begin with exactly two separators
    // specially.
    boolean was_net = Component.size() > 2
       && is_separator(Component.$at(0))
       && Component.$at(1) == Component.$at(0)
       && !is_separator(Component.$at(2));
    
    // Handle separators.
    if (is_separator(Path.$at(Position))) {
      // Root dir.
      if (was_net
        //JAVA: #ifdef LLVM_ON_WIN32
        // c:/
        || (
              (llvm.LLVM_ON_WIN32 || NativeTrace.UNIT_TEST_MODE) &&
              Component.endswith(":")
           )
        //JAVA:#endif
        ) {
        Component = Path.substr(Position, 1);
        return /*Deref*/this;
      }
      
      // Skip extra separators.
      while (Position != Path.size()
         && is_separator(Path.$at(Position))) {
        ++Position;
      }
      
      // Treat trailing '/' as a '.'.
      if (Position == Path.size()) {
        --Position;
        Component = StringRef.R$DOT;
        return /*Deref*/this;
      }
    }
    
    // Find next component.
    /*size_t*/int end_pos = Path.find_first_of(separators, Position);
    Component = Path.slice(Position, end_pos);
    
    return /*Deref*/this;
  }
 // preincrement
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator++">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 64,
   FQN = "llvm::sys::path::const_iterator::operator++", NM = "_ZN4llvm3sys4path14const_iteratorppEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14const_iteratorppEi")
  //</editor-fold>
  @Override
  public const_iterator /*&*/ $postInc() {
    throw new UnsupportedOperationException("EmptyBody");
  } // postincrement

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL, 
   source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 300,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 308,
   FQN = "llvm::sys::path::const_iterator::operator==", NM = "_ZNK4llvm3sys4path14const_iteratoreqERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path14const_iteratoreqERKS2_")
  //</editor-fold>
  @Override
  public boolean $eq(/*const*/ Object /*&*/ RHS) /*const*/ {
    // JAVA: first check int-position
    return (Position == ((const_iterator) RHS).Position) && Native.$eq_ptr(Path.begin(), ((const_iterator) RHS).Path.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 66,
   FQN = "llvm::sys::path::const_iterator::operator!=", NM = "_ZNK4llvm3sys4path14const_iteratorneERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path14const_iteratorneERKS2_")
  //</editor-fold>
  @Override
  public boolean $noteq(/*const*/ Object /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  
  /// @brief Difference in bytes between this and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::operator-">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 304,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 312,
   FQN = "llvm::sys::path::const_iterator::operator-", NM = "_ZNK4llvm3sys4path14const_iteratormiERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path14const_iteratormiERKS2_")
  //</editor-fold>
  @Override
  public int $sub(/*const*/ const_iterator /*&*/ RHS) /*const*/ {
    return (int)(Position - RHS.Position);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::const_iterator">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 50,
   FQN = "llvm::sys::path::const_iterator::const_iterator", NM = "_ZN4llvm3sys4path14const_iteratorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14const_iteratorC1Ev")
  //</editor-fold>
  public /*inline*/ const_iterator() {
    /* : std::iterator<std::input_iterator_tag, const StringRef>(), Path(), Component()*/ 
    //START JInit
    super();
    this.Path = StringRef.R$EMPTY;
    this.Component = StringRef.R$EMPTY;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::const_iterator::const_iterator">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 50,
   FQN = "llvm::sys::path::const_iterator::const_iterator", NM = "_ZN4llvm3sys4path14const_iteratorC1ERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14const_iteratorC1ERKS2_")
  //</editor-fold>
  public /*inline*/ const_iterator(/*const*/ const_iterator /*&*/ $Prm0) {
    /* : std::iterator<std::input_iterator_tag, const StringRef>(), Path(.Path), Component(.Component), Position(.Position)*/ 
    //START JInit
    this.Path = $Prm0.Path;
    this.Component = $Prm0.Component;
    this.Position = $Prm0.Position;
    //END JInit
  }

  @Override
  public type$ref<StringRef> star$ref() {
    throw new UnsupportedOperationException("Not supported yet.");
  } 

  @Override
  public const_iterator $preDec() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public const_iterator $postDec() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public const_iterator $inc(int amount) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public const_iterator $dec(int amount) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public const_iterator $add(int amount) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public const_iterator $sub(int amount) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public const_iterator clone() {
    return new const_iterator(this);
  }

  @Override
  public const_iterator const_clone() {
    return clone();
  }
  
  public String toString() {
    return "" + "Path=" + Path // NOI18N
              + ", Component=" + Component // NOI18N
              + ", Position=" + Position // NOI18N
              + super.toString(); // NOI18N
  }
}

/// @brief Reverse path iterator.
///
/// This is an input iterator that iterates over the individual components in
/// \a path in reverse order. The traversal order is exactly reversed from that
/// of \a const_iterator
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 76,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 77,
 FQN = "llvm::sys::path::reverse_iterator", NM = "_ZN4llvm3sys4path16reverse_iteratorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path16reverse_iteratorE")
//</editor-fold>
public static class reverse_iterator implements /*public*/ std.iterator<std.input_iterator_tag, /*const*/ StringRef>, type$iterator<reverse_iterator, StringRef> {
  private final StringRef Path; ///< The entire path.
  private StringRef Component; ///< The current component. Not necessarily in Path.
  private /*size_t*/int Position; ///< The iterators current position within Path.
  
  /*friend reverse_iterator rbegin(StringRef path)*/
  /*friend reverse_iterator rend(StringRef path)*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 87,
   FQN = "llvm::sys::path::reverse_iterator::operator*", NM = "_ZNK4llvm3sys4path16reverse_iteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path16reverse_iteratordeEv")
  //</editor-fold>
  @Override
  public /*const*/ StringRef $star() /*const*/ {
    return Component;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 88,
   FQN = "llvm::sys::path::reverse_iterator::operator->", NM = "_ZNK4llvm3sys4path16reverse_iteratorptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path16reverse_iteratorptEv")
  //</editor-fold>
  public /*const*/ StringRef $arrow() /*const*/ {
    return $AddrOf(Component);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 323,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 331,
   FQN = "llvm::sys::path::reverse_iterator::operator++", NM = "_ZN4llvm3sys4path16reverse_iteratorppEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path16reverse_iteratorppEv")
  //</editor-fold>
  public reverse_iterator /*&*/ $preInc() {
    // If we're at the end and the previous char was a '/', return '.' unless
    // we are the root path.
    /*size_t*/int root_dir_pos = root_dir_start(Path);
    if (Position == Path.size()
       && $greater_uint(Path.size(), root_dir_pos + 1)
       && is_separator(Path.$at(Position - 1))) {
      --Position;
      Component = StringRef.R$DOT;
      return /*Deref*/this;
    }
    
    // Skip separators unless it's the root directory.
    /*size_t*/int end_pos = Position;
    while (end_pos > 0
       && (end_pos - 1) != root_dir_pos
       && is_separator(Path.$at(end_pos - 1))) {
      --end_pos;
    }
    
    // Find next separator.
    /*size_t*/int start_pos = filename_pos(Path.substr(0, end_pos));
    Component = Path.slice(start_pos, end_pos);
    Position = start_pos;
    return /*Deref*/this;
  }
 // preincrement
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::operator++">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 90,
   FQN = "llvm::sys::path::reverse_iterator::operator++", NM = "_ZN4llvm3sys4path16reverse_iteratorppEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path16reverse_iteratorppEi")
  //</editor-fold>
  @Override
  public reverse_iterator /*&*/ $postInc() {
    throw new UnsupportedOperationException("Not implemented yet.");
  } // postincrement

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 350,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 358,
   FQN = "llvm::sys::path::reverse_iterator::operator==", NM = "_ZNK4llvm3sys4path16reverse_iteratoreqERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path16reverse_iteratoreqERKS2_")
  //</editor-fold>
  public boolean $eq(/*const*/ Object /*&*/ _RHS) /*const*/ {
    reverse_iterator RHS = (reverse_iterator) _RHS;
    return Path.begin() == RHS.Path.begin() && $eq_StringRef(Component, RHS.Component)
       && Position == RHS.Position;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 92,
   FQN = "llvm::sys::path::reverse_iterator::operator!=", NM = "_ZNK4llvm3sys4path16reverse_iteratorneERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZNK4llvm3sys4path16reverse_iteratorneERKS2_")
  //</editor-fold>
  @Override
  public boolean $noteq(/*const*/ Object /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::reverse_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 77,
   FQN = "llvm::sys::path::reverse_iterator::reverse_iterator", NM = "_ZN4llvm3sys4path16reverse_iteratorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path16reverse_iteratorC1Ev")
  //</editor-fold>
  public /*inline*/ reverse_iterator(StringRef Path, StringRef Component, int Position) {
    /* : std::iterator<std::input_iterator_tag, const StringRef>(), Path(), Component()*/ 
    //START JInit
    super();
    this.Path = Path;
    this.Component = Component;
    this.Position = Position;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::reverse_iterator::reverse_iterator">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Path.h", old_line = 77,
   FQN = "llvm::sys::path::reverse_iterator::reverse_iterator", NM = "_ZN4llvm3sys4path16reverse_iteratorC1ERKS2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path16reverse_iteratorC1ERKS2_")
  //</editor-fold>
  public /*inline*/ reverse_iterator(/*const*/ reverse_iterator /*&*/ $Prm0) {
    /* : std::iterator<std::input_iterator_tag, const StringRef>(), Path(.Path), Component(.Component), Position(.Position)*/ 
    //START JInit
    this.Path = $Prm0.Path;
    this.Component = $Prm0.Component;
    this.Position = $Prm0.Position;
    //END JInit
  }

  @Override
  public type$ref<StringRef> star$ref() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int $sub(reverse_iterator iter) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public reverse_iterator $preDec() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public reverse_iterator $postDec() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public reverse_iterator $inc(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public reverse_iterator $dec(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  @Override
  public reverse_iterator $add(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public reverse_iterator $sub(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public reverse_iterator clone() {
    return new reverse_iterator(this);
  }

  @Override
  public reverse_iterator const_clone() {
    return clone();
  }
  
  public String toString() {
    return "" + "Path=" + Path // NOI18N
              + ", Component=" + Component // NOI18N
              + ", Position=" + Position // NOI18N
              + super.toString(); // NOI18N
  }
}


/// @brief Get begin iterator over \a path.
/// @param path Input path.
/// @returns Iterator initialized with the first component of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 232,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 240,
   FQN = "llvm::sys::path::begin", NM = "_ZN4llvm3sys4path5beginENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path5beginENS_9StringRefE")
//</editor-fold>
  public static const_iterator begin(StringRef path) {
    const_iterator i/*J*/= new const_iterator(path, find_first_component(path), 0);
//    i.Path.$assign(path);
//    i.Component.$assign(find_first_component(path));
//    i.Position = 0;
    return i;
  }

/// @brief Get end iterator over \a path.
/// @param path Input path.
/// @returns Iterator initialized to the end of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 240,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 248,
   FQN = "llvm::sys::path::end", NM = "_ZN4llvm3sys4path3endENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path3endENS_9StringRefE")
//</editor-fold>
public static const_iterator end(StringRef path) {
  const_iterator i/*J*/= new const_iterator(path, StringRef.R$EMPTY, path.size());
//  i.Path.$assign(path);
//  i.Position = path.size();
  return i;
}

/// @brief Get reverse begin iterator over \a path.
/// @param path Input path.
/// @returns Iterator initialized with the first reverse component of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::rbegin">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 308,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 316,
 FQN = "llvm::sys::path::rbegin", NM = "_ZN4llvm3sys4path6rbeginENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path6rbeginENS_9StringRefE")
//</editor-fold>
public static reverse_iterator rbegin(StringRef Path) {
  reverse_iterator I/*J*/= new reverse_iterator(Path, StringRef.R$EMPTY, Path.size());
//  I.Path.$assign(Path);
//  I.Position = Path.size();
  return I.$preInc();
}

/// @brief Get reverse end iterator over \a path.
/// @param path Input path.
/// @returns Iterator initialized to the reverse end of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::rend">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 315,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 323,
 FQN = "llvm::sys::path::rend", NM = "_ZN4llvm3sys4path4rendENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path4rendENS_9StringRefE")
//</editor-fold>
public static reverse_iterator rend(StringRef Path) {
  reverse_iterator I/*J*/= new reverse_iterator(Path, Path.substr(0, 0), 0);
//  I.Path.$assign(Path);
//  I.Component.$assign(Path.substr(0, 0));
//  I.Position = 0;
  return I;
}

/// @brief Remove the last component from \a path unless it is the root dir.
///
/// @code
///   directory/filename.cpp => directory/
///   directory/             => directory
///   filename.cpp           => <empty>
///   /                      => /
/// @endcode
///
/// @param path A path that is modified to not have a file component.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::remove_filename">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 496,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 506,
 FQN = "llvm::sys::path::remove_filename", NM = "_ZN4llvm3sys4path15remove_filenameERNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path15remove_filenameERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static void remove_filename(SmallString/*&*/ path) {
  /*size_t*/int end_pos = parent_path_end(path.$StringRef());
  if (end_pos != StringRef.npos) {
    path.set_size(end_pos);
  }
}

/// @brief Replace the file extension of \a path with \a extension.
///
/// @code
///   ./filename.cpp => ./filename.extension
///   ./filename     => ./filename.extension
///   ./             => ./.extension
/// @endcode
///
/// @param path A path that has its extension replaced with \a extension.
/// @param extension The extension to be added. It may be empty. It may also
///                  optionally start with a '.', if it does not, one will be
///                  prepended.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::replace_extension">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 502,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 512,
   FQN = "llvm::sys::path::replace_extension", NM = "_ZN4llvm3sys4path17replace_extensionERNS_15SmallVectorImplIcEERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path17replace_extensionERNS_15SmallVectorImplIcEERKNS_5TwineE")
//</editor-fold>
public static void replace_extension(SmallString/*&*/ path, /*const*/ Twine /*&*/ extension) {
  SmallString/*32*/ ext_storage = null;
  try {
    StringRef p/*J*/= new StringRef(path.$array(), path.size());
    ext_storage/*J*/= new SmallString/*32*/(32);
    StringRef ext = extension.toStringRef(ext_storage);
    
    // Erase existing extension.
    /*size_t*/int pos = p.find_last_of($('.'));
    if (pos != StringRef.npos && pos >= filename_pos(new StringRef(p))) {
      path.set_size(pos);
    }
    
    // Append '.' if needed.
    if (ext.size() > 0 && ext.$at(0) != $('.')) {
      path.push_back($('.'));
    }
    
    // Append extension.
    // JAVA: the originally converted line was: path.append(ext.begin(), ext.end()); The append method compla
    path.append(ext);
  } finally {
    if (ext_storage != null) { ext_storage.$destroy(); }
  }
}

/// @brief Append to path.
///
/// @code
///   /foo  + bar/f => /foo/bar/f
///   /foo/ + bar/f => /foo/bar/f
///   foo   + bar/f => foo/bar/f
/// @endcode
///
/// @param path Set to \a path + \a component.
/// @param a The component to be appended to \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::append">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 443,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 451,
   FQN = "llvm::sys::path::append", NM = "_ZN4llvm3sys4path6appendERNS_15SmallVectorImplIcEERKNS_5TwineES7_S7_S7_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path6appendERNS_15SmallVectorImplIcEERKNS_5TwineES7_S7_S7_")
//</editor-fold>
/// 1 parameter  
  public static void append(SmallString/*&*/ path, /*const*/ Twine /*&*/ a) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      if (!a.isTriviallyEmpty()) {
        SmallString/*32*/ a_storage/*J*/ = helper.$a_storage();
        components.push_back(a.toStringRef(a_storage));
      }
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ StringRef /*&*/ a) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(a);
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ char$ptr /*&*/ a) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(helper.$a_StringRef().$assign(a));
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ std.string /*&*/ a) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(helper.$a_StringRef().$assign(a.data(), a.length()));
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ SmallVectorImplChar /*&*/ a) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(helper.$a_StringRef().$assign(a.data(), a.size()));
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }

/// 2 parameters
  public static void append(SmallString/*&*/ path, /*const*/ Twine /*&*/ a, /*const*/ Twine /*&*/ b/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      if (!a.isTriviallyEmpty()) {
        SmallString/*32*/ a_storage/*J*/ = helper.$a_storage();
        components.push_back(a.toStringRef(a_storage));
      }
      if (!b.isTriviallyEmpty()) {
        SmallString/*32*/ b_storage/*J*/ = helper.$b_storage();
        components.push_back(b.toStringRef(b_storage));
      }
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ StringRef /*&*/ a, /*const*/ StringRef /*&*/ b/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(a);
      components.push_back(b);
      appendImpl(components, path);    
    } finally {
      PathAppendHelper.$release(helper);
    }
  }

/// 3 parameters  
  public static void append(SmallString/*&*/ path, /*const*/ Twine /*&*/ a, /*const*/ Twine /*&*/ b/*= ""*/, /*const*/ Twine /*&*/ c/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      if (!a.isTriviallyEmpty()) {
        SmallString/*32*/ a_storage/*J*/ = helper.$a_storage();
        components.push_back(a.toStringRef(a_storage));
      }
      if (!b.isTriviallyEmpty()) {
        SmallString/*32*/ b_storage/*J*/ = helper.$b_storage();
        components.push_back(b.toStringRef(b_storage));
      }
      if (!c.isTriviallyEmpty()) {
        SmallString/*32*/ c_storage/*J*/ = helper.$c_storage();
        components.push_back(c.toStringRef(c_storage));
      }
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ StringRef /*&*/ a, /*const*/ StringRef /*&*/ b/*= ""*/, /*const*/ StringRef /*&*/ c/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(a);
      components.push_back(b);
      components.push_back(c);
      appendImpl(components, path);    
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ char$ptr /*&*/ a, /*const*/ char$ptr /*&*/ b/*= ""*/, /*const*/ char$ptr /*&*/ c/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(helper.$a_StringRef().$assign(a));
      components.push_back(helper.$b_StringRef().$assign(b));
      components.push_back(helper.$c_StringRef().$assign(c));
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  
/// 4 parameters  
  public static void append(SmallString/*&*/ path, /*const*/ Twine /*&*/ a, /*const*/ Twine /*&*/ b/*= ""*/, /*const*/ Twine /*&*/ c/*= ""*/, /*const*/ Twine /*&*/ d/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();      
      if (!a.isTriviallyEmpty()) {
        SmallString/*32*/ a_storage/*J*/ = helper.$a_storage();
        components.push_back(a.toStringRef(a_storage));
      }
      if (!b.isTriviallyEmpty()) {
        SmallString/*32*/ b_storage/*J*/ = helper.$b_storage();
        components.push_back(b.toStringRef(b_storage));
      }
      if (!c.isTriviallyEmpty()) {
        SmallString/*32*/ c_storage/*J*/ = helper.$c_storage();
        components.push_back(c.toStringRef(c_storage));
      }
      if (!d.isTriviallyEmpty()) {
        SmallString/*32*/ d_storage/*J*/ = helper.$d_storage();
        components.push_back(d.toStringRef(d_storage));
      }    
      appendImpl(components, path);
    } finally {
      PathAppendHelper.$release(helper);
    }
  }
  public static void append(SmallString/*&*/ path, /*const*/ StringRef /*&*/ a, /*const*/ StringRef /*&*/ b/*= ""*/, /*const*/ StringRef /*&*/ c/*= ""*/, /*const*/ StringRef /*&*/ d/*= ""*/) {
    PathAppendHelper helper = PathAppendHelper.$get();
    try {
      SmallVector<StringRef> components = helper.$components();
      components.push_back(a);
      components.push_back(b);
      components.push_back(c);
      components.push_back(d);
      appendImpl(components, path);    
    } finally {
      PathAppendHelper.$release(helper);
    }
  }

  private static void appendImpl(SmallVector<StringRef> components, SmallString/*&*/ path) {
    Object[] $array = components.$array();
    for (int i = 0, e = components.size(); i != e; ++i) {
      StringRef i$star = (StringRef)$array[i];
      boolean path_has_sep = !path.empty() && is_separator(path.$at(path.size() - 1));
      boolean component_has_sep = !i$star.empty() && is_separator((i$star).$at(0));
      boolean is_root_name = has_root_name(i$star);
      if (path_has_sep) {
        // Strip separators from beginning of component.
        /*size_t*/int loc = i$star.find_first_not_of(separators);
        StringRef c_ = i$star.substr(loc);
        
        // Append it.
        path.append(c_, 0, c_.size());
        continue;
      }
      if (!component_has_sep && !(path.empty() || is_root_name)) {
        // Add a separator.
        path.push_back(preferred_separator);
      }
      
      path.append(i$star, 0, i$star.size());
    }
  }

/// @brief Append to path.
///
/// @code
///   /foo  + [bar,f] => /foo/bar/f
///   /foo/ + [bar,f] => /foo/bar/f
///   foo   + [bar,f] => foo/bar/f
/// @endcode
///
/// @param path Set to \a path + [\a begin, \a end).
/// @param begin Start of components to append.
/// @param end One past the end of components to append.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::append">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 482,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 492,
   FQN = "llvm::sys::path::append", NM = "_ZN4llvm3sys4path6appendERNS_15SmallVectorImplIcEENS1_14const_iteratorES5_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path6appendERNS_15SmallVectorImplIcEENS1_14const_iteratorES5_")
//</editor-fold>
  public static void append(SmallString/*&*/ path, const_iterator begin, const_iterator end) {
    begin = $tryClone(begin);
    for (; begin.$noteq(end); begin.$preInc())  {
      append(path, begin.$star());
    }
  }

/// Convert path to the native form. This is used to give paths to users and
/// operating system calls in the platform's normal way. For example, on Windows
/// all '/' are converted to '\'.
///
/// @param path A path that is transformed to native format.
/// @param result Holds the result of the transformation.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::native">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 520,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 530,
   FQN = "llvm::sys::path::native", NM = "_ZN4llvm3sys4path6nativeERKNS_5TwineERNS_15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path6nativeERKNS_5TwineERNS_15SmallVectorImplIcEE")
//</editor-fold>
  public static void __native(/*const*/Twine /*&*/ path, SmallString/*&*/ result) {
    assert ((!path.isSingleStringRef() || path.getSingleStringRef().data() != result.data())) : "path and result are not allowed to overlap!";
    // Clear result.
    result.clear();
    path.toVector(result);
    __native(result);
  }

  /// Convert path to the native form in place. This is used to give paths to
  /// users and operating system calls in the platform's normal way. For example,
  /// on Windows all '/' are converted to '\'.
  ///
  /// @param path A path that is transformed to native format.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::native">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 558,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 530,
   FQN="llvm::sys::path::native", NM="_ZN4llvm3sys4path6nativeERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path6nativeERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public static void __native(SmallString/*&*/ Path) {
//JAVA: #ifdef LLVM_ON_WIN32
    if (llvm.LLVM_ON_WIN32) { 
      std.replace(Path.begin(), Path.end(),  $$SLASH,  $$BACK_SLASH);
    }
//JAVA: #endif
    else {
      // JAVA: replace pointers by indices
      for (int PI = 0, PE = Path.size(); PI < PE; ++PI) {
        if (Path.$at(PI) == $$BACK_SLASH) {
          int PN = PI + 1;
          if (PN < PE && Path.$at(PN) == $$BACK_SLASH) {
            PI++;// increment once, the for loop will move over the escaped slash
          } else {
            Path.$set(PI, $$SLASH);
          }
        }
      }     
    }
  }

/// @brief Get root name.
///
/// @code
///   //net/hello => //net
///   c:/hello    => c: (on Windows, on other platforms nothing)
///   /hello      => <empty>
/// @endcode
///
/// @param path Input path.
/// @result The root name of \a path if it has one, otherwise "".
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::root_name">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 387,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 395,
   FQN = "llvm::sys::path::root_name", NM = "_ZN4llvm3sys4path9root_nameENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path9root_nameENS_9StringRefE")
//</editor-fold>
  public static /*const*/ StringRef root_name(StringRef path) {
    StringRef First = find_first_component(path);
    int size = First.size();
    if (size > 0) {
      int pathOffsetInURL = get_path_offset_in_url(path);
      assert pathOffsetInURL <= size : "[" + First +"] of [" + path + "] has offset at " + pathOffsetInURL + " vs length=" + size;
      if (pathOffsetInURL == size) {
        // No path or no name.
        return StringRef.R$EMPTY;
      }
      byte first_at_zero = (First).$at(pathOffsetInURL);
      boolean has_net = pathOffsetInURL == 0 && size > 2 && is_separator(first_at_zero) && (First).$at(1) == first_at_zero;
      boolean has_drive = false;
      if (llvm.LLVM_ON_WIN32 || true) { //JAVA:#ifdef LLVM_ON_WIN32
        has_drive = First.endswith(":");
      } //JAVA:#else
    
      if (has_net || has_drive) {
        // just {C:,//net}, return the first component.
        return First;
      }
    }

    // No path or no name.
    return StringRef.R$EMPTY;
  }

/// @brief Get root directory.
///
/// @code
///   /goo/hello => /
///   c:/hello   => /
///   d/file.txt => <empty>
/// @endcode
///
/// @param path Input path.
/// @result The root directory of \a path if it has one, otherwise
///               "".
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::root_directory">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 409,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 417,
   FQN = "llvm::sys::path::root_directory", NM = "_ZN4llvm3sys4path14root_directoryENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14root_directoryENS_9StringRefE")
//</editor-fold>
public static /*const*/StringRef root_directory(StringRef path) {
  StringRef First = find_first_component(path);
  int size = First.size();
  if (size > 0) {
    int pathOffsetInURL = get_path_offset_in_url(path);
    assert pathOffsetInURL <= size : "[" + First +"] of [" + path + "] has offset at " + pathOffsetInURL + " vs length=" + size;
    if (pathOffsetInURL == size) {
      return First;
    }
    byte first_at_zero = (First).$at(pathOffsetInURL);
    boolean first_at_zero_is_separator = is_separator(first_at_zero);
    boolean has_net = pathOffsetInURL == 0 && size > 2 && first_at_zero_is_separator && (First).$at(1) == first_at_zero;
    boolean has_drive = false;
    // if (llvm.LLVM_ON_WIN32) { //JAVA:#ifdef LLVM_ON_WIN32
    // unix pathwill never have a ':' in the 2-nd position,
    // so it;s OK to not check OS here
      has_drive = First.endswith(":");
    // } //JAVA:#else
    if ((has_net || has_drive)) {
      const_iterator pos = new const_iterator(path, First, 0);
      int EndPosition = path.size();
      // {C:,//net}, skip to the next component.
      pos.$preInc();
      if ((pos.Position != EndPosition) && is_separator((pos.$star()).$at(0))) {
        return pos.$star();
      }
    }
    
    // POSIX style root directory.
    if (!has_net && first_at_zero_is_separator) {
      return First;
    }
  }
  
  // No path or no root.
  return StringRef.R$EMPTY;
}

/// @brief Get root path.
///
/// Equivalent to root_name + root_directory.
///
/// @param path Input path.
/// @result The root path of \a path if it has one, otherwise "".
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::root_path">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 355,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 363,
   FQN = "llvm::sys::path::root_path", NM = "_ZN4llvm3sys4path9root_pathENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path9root_pathENS_9StringRefE")
//</editor-fold>
public static /*const*/StringRef root_path(StringRef path) {
  StringRef First = find_first_component(path);
  int size = First.size();
  if (size > 0) {
    int pathOffsetInURL = get_path_offset_in_url(path);
    assert pathOffsetInURL <= size : "[" + First +"] of [" + path + "] has offset at " + pathOffsetInURL + " vs length=" + size;
    if (pathOffsetInURL == size) {
      return First;
    }
    byte first_at_zero = (First).$at(pathOffsetInURL);
    boolean first_at_zero_is_separator = is_separator(first_at_zero);
    boolean has_net = pathOffsetInURL == 0 && size > 2 && first_at_zero_is_separator && (First).$at(1) == first_at_zero;
    boolean has_drive = false;
    if (llvm.LLVM_ON_WIN32 || NativeTrace.UNIT_TEST_MODE) { //JAVA:#ifdef LLVM_ON_WIN32
      has_drive = First.endswith(":");
    } //JAVA:#else
    if (has_net || has_drive) {
      const_iterator pos = new const_iterator(path, First, 0);
      int EndPosition = path.size();     
      pos.$preInc();
      if ((pos.Position != EndPosition) && is_separator((pos.$star()).$at(0))) {
        // {C:/,//net/}, so get the first two components.
        return path.substr(0, First.size() + pos.$arrow().size());
      } else {
        // just {C:,//net}, return the first component.
        return First;
      }
    }
    
    // POSIX style root directory.
    if (first_at_zero_is_separator) {
      return First;
    }
  }
  
  return StringRef.R$EMPTY;
}

  /// @brief Get relative path.
  ///
  /// @code
  ///   C:\hello\world => hello\world
  ///   foo/bar        => foo/bar
  ///   /foo/bar       => foo/bar
  /// @endcode
  ///
  /// @param path Input path.
  /// @result The path starting after root_path if one exists, otherwise "".
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::relative_path">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 443,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 438,
   FQN="llvm::sys::path::relative_path", NM="_ZN4llvm3sys4path13relative_pathENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path13relative_pathENS_9StringRefE")
  //</editor-fold>
  public static StringRef relative_path(StringRef _path) {
    StringRef root = root_path(/*NO_COPY*/_path);
    return _path.substr(root.size());
  }

/// @brief Get parent path.
///
/// @code
///   /          => <empty>
///   /foo       => /
///   foo/../bar => foo/..
/// @endcode
///
/// @param path Input path.
/// @result The parent path of \a path if one exists, otherwise "".
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::parent_path">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 488,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 498,
 FQN = "llvm::sys::path::parent_path", NM = "_ZN4llvm3sys4path11parent_pathENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path11parent_pathENS_9StringRefE")
//</editor-fold>
public static /*const*/StringRef parent_path(StringRef path) {
  /*size_t*/int end_pos = parent_path_end(path);
  if (end_pos == StringRef.npos) {
    return StringRef.R$EMPTY;
  } else {
    return path.substr(0, end_pos);
  }
}

/// @brief Get filename.
///
/// @code
///   /foo.txt    => foo.txt
///   .          => .
///   ..         => ..
///   /          => /
/// @endcode
///
/// @param path Input path.
/// @result The filename part of \a path. This is defined as the last component
///         of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::filename">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 546,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 556,
 FQN = "llvm::sys::path::filename", NM = "_ZN4llvm3sys4path8filenameENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path8filenameENS_9StringRefE")
//</editor-fold>
public static StringRef filename(StringRef path) {
  return rbegin(path).$star();
}

/// @brief Get stem.
///
/// If filename contains a dot but not solely one or two dots, result is the
/// substring of filename ending at (but not including) the last dot. Otherwise
/// it is filename.
///
/// @code
///   /foo/bar.txt => bar
///   /foo/bar     => bar
///   /foo/.txt    => <empty>
///   /foo/.       => .
///   /foo/..      => ..
/// @endcode
///
/// @param path Input path.
/// @result The stem of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::stem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 550,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 560,
   FQN = "llvm::sys::path::stem", NM = "_ZN4llvm3sys4path4stemENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path4stemENS_9StringRefE")
//</editor-fold>
  public static /*const*/ StringRef stem(StringRef path) {
    StringRef fname = filename(path);
    /*size_t*/int pos = fname.find_last_of($('.'));
    if (pos == StringRef.npos) {
      return fname;
    } else if ((fname.size() == 1 && $eq_StringRef(fname, "."))
       || (fname.size() == 2 && $eq_StringRef(fname, ".."))) {
      return fname;
    } else {
      return fname.substr(0, pos);
    }
  }

/// @brief Get extension.
///
/// If filename contains a dot but not solely one or two dots, result is the
/// substring of filename starting at (and including) the last dot, and ending
/// at the end of \a path. Otherwise "".
///
/// @code
///   /foo/bar.txt => .txt
///   /foo/bar     => <empty>
///   /foo/.txt    => .txt
/// @endcode
///
/// @param path Input path.
/// @result The extension of \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::extension">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 563,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 573,
 FQN = "llvm::sys::path::extension", NM = "_ZN4llvm3sys4path9extensionENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path9extensionENS_9StringRefE")
//</editor-fold>
  public static /*const*/StringRef extension(StringRef path) {
    StringRef fname = filename(path);
    /*size_t*/int pos = fname.find_last_of($('.'));
    if (pos == StringRef.npos) {
      return StringRef.R$EMPTY;
    } else if ((fname.size() == 1 && $eq_StringRef(fname, ".")) || (fname.size() == 2 && $eq_StringRef(fname, ".."))) {
      return StringRef.R$EMPTY;
    } else {
      return fname.substr(pos);
    }
  }


/// @brief Check whether the given char is a path separator on the host OS.
///
/// @param value a character
/// @result true if \a value is a path separator character on the host OS
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::is_separator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 576,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 586,
 FQN = "llvm::sys::path::is_separator", NM = "_ZN4llvm3sys4path12is_separatorEc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path12is_separatorEc")
//</editor-fold>
  public static boolean is_separator(/*char*/byte value) {
    switch (value) {
     case '\\': // fall through
     /* JAVA: assume both '\\' and '/' separators
     if (llvm.LLVM_ON_WIN32) { //JAVA:#ifdef LLVM_ON_WIN32
       // fall through
     } else {
       return false;
     }//JAVA:#endif
     */
     case '/':
      return true;
     default:
      return false;
    }
  }

  public static StringRef get_separator() {
    return new StringRef(PathStatics.preferred_separator_string);
  }

/// @brief Get the typical temporary directory for the system, e.g., 
/// "/var/tmp" or "C:/TEMP"
///
/// @param erasedOnReboot Whether to favor a path that is erased on reboot
/// rather than one that potentially persists longer. This parameter will be
/// ignored if the user or system has set the typical environment variable
/// (e.g., TEMP on Windows, TMPDIR on *nix) to specify a temporary directory.
///
/// @param result Holds the resulting path name.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::system_temp_directory">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 634,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 581,
 FQN = "llvm::sys::path::system_temp_directory", NM = "_ZN4llvm3sys4path21system_temp_directoryEbRNS_15SmallVectorImplIcEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path21system_temp_directoryEbRNS_15SmallVectorImplIcEE")
//</editor-fold>
public static void system_temp_directory(boolean ErasedOnReboot, SmallString/*&*/ Result) {
  Result.clear();
  if (ErasedOnReboot) {
    {
      // There is no env variable for the cache directory.
      /*const*/char$ptr/*char P*/ RequestedDir = getEnvTempDir();
      if ((RequestedDir != null)) {
        Result.append(RequestedDir, std.strlen(RequestedDir));
        return;
      }
    }
  }

  /*const*/char$ptr/*char P*/ RequestedDir = getDefaultTempDir(ErasedOnReboot);
  Result.append(RequestedDir, std.strlen(RequestedDir));
}

/// @brief Get the user's home directory.
///
/// @param result Holds the resulting path name.
/// @result True if a home directory is set, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::home_directory">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 553,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 548,
 FQN="llvm::sys::path::home_directory", NM="_ZN4llvm3sys4path14home_directoryERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path14home_directoryERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static boolean home_directory(SmallString/*&*/ result) {
  {
    char$ptr/*char P*/ RequestedDir = $tryClone(getenv("HOME"));
    if ((RequestedDir != null)) {
      result.clear();
      result.append(RequestedDir, /*RequestedDir.$add*/(strlen(RequestedDir))); // JAVA
      return true;
    }
  }
  
  return false;
}


/// @brief Get the user's cache directory.
///
/// Expect the resulting path to be a directory shared with other
/// applications/services used by the user. Params \p Path1 to \p Path3 can be
/// used to append additional directory names to the resulting path. Recommended
/// pattern is <user_cache_directory>/<vendor>/<application>.
///
/// @param Result Holds the resulting path.
/// @param Path1 Additional path to be appended to the user's cache directory
/// path. "" can be used to append nothing.
/// @param Path2 Second additional path to be appended.
/// @param Path3 Third additional path to be appended.
/// @result True if a cache directory path is set, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::user_cache_directory">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 1137,
 optimized = Converted.Optimization.VALUE_TYPE,
 FQN="llvm::sys::path::user_cache_directory", NM="_ZN4llvm3sys4path20user_cache_directoryERNS_15SmallVectorImplIcEERKNS_5TwineES7_S7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path20user_cache_directoryERNS_15SmallVectorImplIcEERKNS_5TwineES7_S7_")
//</editor-fold>
public static boolean user_cache_directory(SmallString/*&*/ Result, /*const*/ Twine /*&*/ Path1) {
  return user_cache_directory(Result, Path1, 
                    Twine.T$EMPTY, Twine.T$EMPTY);
}
public static boolean user_cache_directory(SmallString/*&*/ Result, /*const*/ Twine /*&*/ Path1, 
                    /*const*/ Twine /*&*/ Path2/*= ""*/) {
  return user_cache_directory(Result, Path1, 
                    Path2, Twine.T$EMPTY);
}
public static boolean user_cache_directory(SmallString/*&*/ Result, /*const*/ Twine /*&*/ Path1, 
                    /*const*/ Twine /*&*/ Path2/*= ""*/, /*const*/ Twine /*&*/ Path3/*= ""*/) {
  if (getUserCacheDir(Result)) {
    append(Result, Path1, Path2, Path3);
    return true;
  }
  return false;
}

/// @brief Has root name?
///
/// root_name != ""
///
/// @param path Input path.
/// @result True if the path has a root name, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_root_name">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 592,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 602,
   FQN = "llvm::sys::path::has_root_name", NM = "_ZN4llvm3sys4path13has_root_nameERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path13has_root_nameERKNS_5TwineE")
//</editor-fold>
  public static boolean has_root_name(/*const*/Twine /*&*/ path) {
    SmallString/*128*/ path_storage/*J*/ = new SmallString(128);
    StringRef p = path.toStringRef(path_storage);

    return has_root_name(p);
  }
  public static boolean has_root_name(StringRef /*&*/ p) {
    return !root_name(p).empty();
  }

/// @brief Has root directory?
///
/// root_directory != ""
///
/// @param path Input path.
/// @result True if the path has a root directory, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_root_directory">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 599,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 609,
   FQN = "llvm::sys::path::has_root_directory", NM = "_ZN4llvm3sys4path18has_root_directoryERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path18has_root_directoryERKNS_5TwineE")
//</editor-fold>
public static boolean has_root_directory(/*const*/Twine /*&*/ path) {
  SmallString/*128*/ path_storage/*J*/= new SmallString(128);
  StringRef p = path.toStringRef(path_storage);
  
  return has_root_directory(p);
}
public static boolean has_root_directory(/*const*/StringRef /*&*/ p) {
  return !root_directory(p).empty();
}

/// @brief Has root path?
///
/// root_path != ""
///
/// @param path Input path.
/// @result True if the path has a root path, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_root_path">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 606,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 616,
   FQN = "llvm::sys::path::has_root_path", NM = "_ZN4llvm3sys4path13has_root_pathERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path13has_root_pathERKNS_5TwineE")
//</editor-fold>
  public static boolean has_root_path(/*const*/Twine /*&*/ path) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/// @brief Has relative path?
///
/// relative_path != ""
///
/// @param path Input path.
/// @result True if the path has a relative path, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_relative_path">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 613,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 623,
   FQN = "llvm::sys::path::has_relative_path", NM = "_ZN4llvm3sys4path17has_relative_pathERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path17has_relative_pathERKNS_5TwineE")
//</editor-fold>
  public static boolean has_relative_path(/*const*/Twine /*&*/ path) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @brief Has parent path?
  ///
  /// parent_path != ""
  ///
  /// @param path Input path.
  /// @result True if the path has a parent path, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_parent_path">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 627,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 637,
   FQN = "llvm::sys::path::has_parent_path", NM = "_ZN4llvm3sys4path15has_parent_pathERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path15has_parent_pathERKNS_5TwineE")
  //</editor-fold>
  public static boolean has_parent_path(/*const*/ Twine /*&*/ path) {
    SmallString/*128*/ path_storage = null;
    try {
      path_storage/*J*/= new SmallString/*128*/(128);
      StringRef p = path.toStringRef(path_storage);

      return !parent_path(new StringRef(p)).empty();
    } finally {
      if (path_storage != null) { path_storage.$destroy(); }
    }
  }

/// @brief Has filename?
///
/// filename != ""
///
/// @param path Input path.
/// @result True if the path has a filename, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_filename">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 620,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 630,
   FQN = "llvm::sys::path::has_filename", NM = "_ZN4llvm3sys4path12has_filenameERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path12has_filenameERKNS_5TwineE")
//</editor-fold>
  public static boolean has_filename(/*const*/Twine /*&*/ path) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/// @brief Has stem?
///
/// stem != ""
///
/// @param path Input path.
/// @result True if the path has a stem, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_stem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 634,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 644,
   FQN = "llvm::sys::path::has_stem", NM = "_ZN4llvm3sys4path8has_stemERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path8has_stemERKNS_5TwineE")
//</editor-fold>
  public static boolean has_stem(/*const*/Twine /*&*/ path) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @brief Has extension?
  ///
  /// extension != ""
  ///
  /// @param path Input path.
  /// @result True if the path has a extension, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::has_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 669,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 641,
   FQN="llvm::sys::path::has_extension", NM="_ZN4llvm3sys4path13has_extensionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path13has_extensionERKNS_5TwineE")
  //</editor-fold>
  public static boolean has_extension(final /*const*/ Twine /*&*/ _path) {
    SmallString/*128*/ path_storage/*J*/= new SmallString/*128*/(128);
    StringRef p = _path.toStringRef(path_storage);
    
    return !extension(/*NO_COPY*/p).empty();
  }

/// @brief Is path absolute?
///
/// @param path Input path.
/// @result True if the path is absolute, false if it is not.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::is_absolute">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 648,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 658,
   FQN = "llvm::sys::path::is_absolute", NM = "_ZN4llvm3sys4path11is_absoluteERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path11is_absoluteERKNS_5TwineE")
//</editor-fold>
  public static boolean is_absolute(/*const*/Twine /*&*/ path) {
    if (path.isSingleStringRef()) {
      return is_absolute(path.getSingleStringRef());
    } else {
      SmallString/*128*/ path_storage/*J*/= new SmallString(128);
      path.toVector(path_storage);
      return is_absolute(path_storage.$StringRef());
    }
  }
  public static boolean is_absolute(/*const*/char$ptr /*&*/ path) {
    return is_absolute(new StringRef(path));
  }
  public static boolean is_absolute(/*const*/std.string /*&*/ path) {
    return is_absolute(new StringRef(path));
  }
  public static boolean is_absolute(/*const*/StringRef /*&*/ p) {
    // JAVA:
    int pathOffsetInURL = get_path_offset_in_url(p);
    assert pathOffsetInURL <= p.size() : "[" + p + "] has offset at " + pathOffsetInURL + " vs length=" + p.size();  
    if (pathOffsetInURL > 0) {
      assert  is_empty(p) || is_separator(p.$at(pathOffsetInURL));
      assert (p.size() == pathOffsetInURL) == is_empty(p) : "expected the same reply for " + p + "["+ is_empty(p) + "] vs. (" + p.size() + "==" + pathOffsetInURL + ")";
      return p.size() != pathOffsetInURL /*!is_empty(p)*/;
    }

    boolean rootDir = has_root_directory(p), rootName = true;
    if (llvm.LLVM_ON_WIN32) { //JAVA:#ifdef LLVM_ON_WIN32
       rootName = has_root_name(p);
    } else {//JAVA:#else
       rootName = true;
    } //JAVA: #endif
        
    return rootDir && rootName;
  }

  /// @brief Is path relative?
  ///
  /// @param path Input path.
  /// @result True if the path is relative, false if it is not.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::path::is_relative">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 662,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 672,
   FQN = "llvm::sys::path::is_relative", NM = "_ZN4llvm3sys4path11is_relativeERKNS_5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path11is_relativeERKNS_5TwineE")
  //</editor-fold>
  public static boolean is_relative(/*const*/ Twine /*&*/ path) {
    return !is_absolute(path);
  }

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::preferred_separator_string">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 586,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", old_line = 596,
 FQN = "llvm::sys::path::preferred_separator_string", NM = "_ZN4llvm3sys4pathL26preferred_separator_stringE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL26preferred_separator_stringE")
//</editor-fold>
public static final /*const*//*char*/byte preferred_separator_string[/*2*/] = new$char(2, preferred_separator, $$TERM);
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::getEnvTempDir">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 611,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 558,
 FQN = "llvm::sys::path::getEnvTempDir", NM = "_ZN4llvm3sys4pathL13getEnvTempDirEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL13getEnvTempDirEv")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getEnvTempDir() {
  // Check whether the temporary directory is specified by an environment
  // variable.
  
  for (/*const*/char$ptr/*char P*/ Env : EnvironmentVariables) {
    {
      /*const*/char$ptr/*char P*/ Dir = $tryClone(std.getenv(Env));
      if ((Dir != null)) {
        return Dir;
      }
    }
  }
  
  return null;
}
private static final /*const*/char$ptr/*char P*/ EnvironmentVariables[/*4*/] = (new /*const*/char$ptr/*char P*/ [/*4*/] {$("TMPDIR"), $("TMP"), $("TEMP"), $("TEMPDIR")});

//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::getDefaultTempDir">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", line = 623,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Unix/Path.inc", old_line = 570,
 FQN = "llvm::sys::path::getDefaultTempDir", NM = "_ZN4llvm3sys4pathL17getDefaultTempDirEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4pathL17getDefaultTempDirEb")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getDefaultTempDir(boolean ErasedOnReboot) {
  if (std.P_tmpdir != null) {
    return std.P_tmpdir;
  }
  if (ErasedOnReboot) {
    return $SLASH_TMP;
  }
  return $SLASH_VAR_SLASH_TMP;
}  
//  public static boolean is_empty(StringRef path) {
//    return isPathEmpty(path);
//  }

// JAVA:
private static final String RFS_PREFIX = "rfs:";

// JAVA:
public static boolean is_empty(StringRef path) {
    int pathOffsetInURL = get_path_offset_in_url(path);
    assert pathOffsetInURL <= path.size() : "[" + path + "] has offset at " + pathOffsetInURL + " vs length=" + path.size();  
    if (pathOffsetInURL > 0) {
      return path.size() == pathOffsetInURL;
    } else {
      return path.empty();
    }
}

/**
 * If the path is URL-like, e.g.: rfs://vk@myhost:/usr/include
 * returns offset of the path itself (i.e. offset of "/usr/include"),
 * otherwise 0
 *
 * I would never make it public, if it was not used in PathStatics
 */
// JAVA:
public static int get_path_offset_in_url(StringRef path) {
  if (path != null) {
    String prefix = RFS_PREFIX;
    if(path.startswith(prefix)) {
      // examples:
      // rfs://user@host:22/usr/include
      // rfs://user@host:22
      int colonPos = path.find_first_of((byte) ':', prefix.length()); //NOI18N
      if (colonPos != StringRef.npos) {
        int pos = colonPos + 1;
        while (pos < path.size() && std.isdigit(path.$at(pos)) != 0) {
          pos++;
        }
        return pos;
//        int slashPos = path.find_first_of((byte) '/', colonPos+1); //NOI18N
//        if (slashPos != StringRef.npos) {
//          return slashPos;
//        }
//        return colonPos + 1;
      } else {
        NativeTrace.printStackTraceOnce(new AssertionError("The path " + path + " starts with " + prefix + //NOI18N
                " but does not contain a colon after it")); //NOI18N
        return prefix.length();
      }
    }
  }
  return 0;
}

/// @brief Remove redundant leading "./" pieces and consecutive separators.
///
/// @param path Input path.
/// @result The cleaned-up \a path.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::remove_leading_dotslash">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 664,
 FQN="llvm::sys::path::remove_leading_dotslash", NM="_ZN4llvm3sys4path23remove_leading_dotslashENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path23remove_leading_dotslashENS_9StringRefE")
//</editor-fold>
public static StringRef remove_leading_dotslash(StringRef Path) {
  // Remove leading "./" (or ".//" or "././" etc.)
  while ($greater_uint(Path.size(), 2) && Path.$at(0) == $$DOT && is_separator(Path.$at(1))) {
    Path.$assignMove(Path.substr(2));
    while ($greater_uint(Path.size(), 0) && is_separator(Path.$at(0))) {
      Path.$assignMove(Path.substr(1));
    }
  }
  return new StringRef(JD$Move.INSTANCE, Path);
}

/// @brief In-place remove any './' and optionally '../' components from a path.
///
/// @param path processed path
/// @param remove_dot_dot specify if '../' should be removed
/// @result True if path was changed
//<editor-fold defaultstate="collapsed" desc="llvm::sys::path::remove_dots">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Path.cpp", line = 698,
 FQN="llvm::sys::path::remove_dots", NM="_ZN4llvm3sys4path11remove_dotsERNS_15SmallVectorImplIcEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm3sys4path11remove_dotsERNS_15SmallVectorImplIcEEb")
//</editor-fold>
public static boolean remove_dots(SmallString/*&*/ path) {
  return remove_dots(path, false);
}
public static boolean remove_dots(SmallString/*&*/ path, boolean remove_dot_dot/*= false*/) {
  StringRef p/*J*/= new StringRef(path.data(), path.size());
  
  SmallString/*256*/ result = org.llvm.support.sys.impl.PathStatics.remove_dots(new StringRef(p), remove_dot_dot);
  if (result.$eq(path)) {
    return false;
  }
  
  path.swap(result);
  return true;
}
} // END OF class path
