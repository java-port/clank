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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.aliases.*;

/*template <unsigned int InternalLen> TEMPLATE*/

/// SmallString - A SmallString is just a SmallVector with methods and accessors
/// that make it work better as a string (e.g. operator+ etc).
//<editor-fold defaultstate="collapsed" desc="llvm::SmallString">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 24,
 FQN = "llvm::SmallString", NM = "_ZN4llvm11SmallStringE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallStringE")
//</editor-fold>
public class SmallString  extends /*public*/ SmallVectorChar implements ConvertableToStdString {
/*public:*/
  /// Default ctor - Initialize to empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::SmallString<InternalLen>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 28,
   FQN = "llvm::SmallString::SmallString<InternalLen>", NM = "_ZN4llvm11SmallStringC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallStringC1Ev")
  //</editor-fold>
  public SmallString(int InternalLen) {
    super(InternalLen);
  }
  
  /// Initialize from a StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::SmallString<InternalLen>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 31,
   FQN = "llvm::SmallString::SmallString<InternalLen>", NM = "_ZN4llvm11SmallStringC1ENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallStringC1ENS_9StringRefE")
  //</editor-fold>
  public SmallString(int InternalLen, StringRef S) {
    /* : SmallVector<char, InternalLen>(S.begin(), S.end())*/ 
    super(InternalLen, S.begin(), S.end());
  }
  @Deprecated
  public SmallString(StringRef S, int InternalLen) {
    /* : SmallVector<char, InternalLen>(S.begin(), S.end())*/ 
    super(InternalLen, S.begin(), S.end());
  }

  public SmallString(std.string S) {
    // TODO: this should be probably optimized
    this(S.length(), new StringRef(S));
  }

  public SmallString(String S) {
    // TODO: this should be probably optimized
    this(S.length(), new StringRef(S));
  }

  // there is no such ctor in native; but we need it since we often use SmallString instead of SmallVectorChar
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public SmallString(int capacity, int initialSize) {
    super(capacity, initialSize, (byte) '0');
  }    

  // there is no such ctor in native; but we need it since we often use SmallString instead of SmallVectorChar
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public SmallString(int capacity, int initialSize, byte defaultValue) {
    super(capacity, initialSize, defaultValue);
  }    

  /// Initialize with a range.
  /*template <typename ItTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::SmallString<InternalLen>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 35,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::SmallString<InternalLen>")
  //</editor-fold>
  public </*typename*/ ItTy extends char$iterator> SmallString(ItTy S, ItTy E, int InternalLen) {
    /* : SmallVector<char, InternalLen>(S, E)*/ 
    super(InternalLen, S, E);
  }

  
  /// Copy ctor.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::SmallString<InternalLen>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 38,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::SmallString<InternalLen>")
  //</editor-fold>
  public SmallString(/*const*/SmallString /*&*/ RHS) {
    /* : SmallVector<char, InternalLen>(RHS)*/ 
    super(RHS);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public SmallString(int capacity, ulong$ptr begin, ulong$ptr end) {
    /* : SmallVector<char, InternalLen>(RHS)*/ 
    super(capacity, CollectionUtils.transform_ulong2char$ptr(begin), std.distance(begin, end));
  }
  
  /// Assign from a repeated element.
//  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::assign">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 48,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::assign")
//  //</editor-fold>
//  public void assign(/*size_t*/int NumElts, /*char*/byte Elt) {
//    super.assign(NumElts, Elt);
//  }

  /// Assign from a repeated element.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::assign">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 45,
   FQN = "llvm::SmallString::assign", NM = "_ZN4llvm11SmallString6assignEjc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallString6assignEjc")
  //</editor-fold>
  public void assign(/*size_t*/int NumElts, /*char*/char Elt) {
    super.assign(NumElts, (byte)Elt);
  }

  
  /// Assign from an iterator pair.
//  /*template <typename in_iter> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::assign">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 54,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::assign")
//  //</editor-fold>
//  public void assign(char$iterator<?> S, char$iterator<?> E) {
//    this.clear();
//    super.append(S, E);
//  }

  
  /// Assign from a StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::assign">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 57,
   FQN = "llvm::SmallString::assign", NM = "_ZN4llvm11SmallString6assignENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallString6assignENS_9StringRefE")
  //</editor-fold>
  public void assign(StringRef RHS) {
    this.clear();
    append(RHS);
  }

  
  /// Assign from a SmallVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::assign">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 63,
   FQN = "llvm::SmallString::assign", NM = "_ZN4llvm11SmallString6assignERKNS_15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallString6assignERKNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public void assign(/*const*/SmallVectorImplChar/*&*/ RHS) {
    this.clear();
    append(RHS);
  }

  
  /// Append from an iterator pair.
  /*template <typename in_iter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::append">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 77,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::append")
//  //</editor-fold>
//  public </*typename*/ in_iter extends char$iterator> void append(in_iter S, in_iter E) {
//    super.append(S, E);
//  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::append">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 81,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::append")
//  //</editor-fold>
//  public void append(/*size_t*/int NumInputs, /*char*/byte Elt) {
//    super.append(NumInputs, Elt);
//  }

  
  /// Append from a StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::append">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 84,
   FQN = "llvm::SmallString::append", NM = "_ZN4llvm11SmallString6appendENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallString6appendENS_9StringRefE")
  //</editor-fold>
  public void append(StringRef RHS) {
    append(RHS, 0, RHS.size());
  }
  
  public void append(StringRef RHS, int fromIndex, int toIndexExclusive) {
    int count = (toIndexExclusive - fromIndex);
    // Grow allocated space if needed.
    int end = size();
    this.reserve(end+count);
    for (; fromIndex < toIndexExclusive; ++fromIndex) {
      $set(end, RHS.$at(fromIndex));
      ++end;
    }
    set_size(end);
  }

  public void append(std.string RHS) {
    append(RHS, 0, RHS.size());
  }
  
  public void append(std.string RHS, int fromIndex, int toIndexExclusive) {
    int count = (toIndexExclusive - fromIndex);
    // Grow allocated space if needed.
    int end = size();
    this.reserve(end+count);
    for (; fromIndex < toIndexExclusive; ++fromIndex) {
      $set(end, RHS.$at(fromIndex));
      ++end;
    }
    set_size(end);
  }
  
  public void append(String RHS) {
    append(RHS, 0, RHS.length());
  }
  
  public void append(String RHS, int fromIndex, int toIndexExclusive) {
    int count = (toIndexExclusive - fromIndex);
    // Grow allocated space if needed.
    int end = size();
    this.reserve(end+count);
    for (; fromIndex < toIndexExclusive; ++fromIndex) {
      $set(end, $(RHS.charAt(fromIndex)));
      ++end;
    }
    set_size(end);
  }
  
  public final void append$T(char$ptr in_start, char$ptr in_end) {
    append(in_start, in_end);
  }
  public final void append(char$ptr in_start, char$ptr in_end) {
    if (NativeTrace.isDebugMode()) {
      NativeTrace.printStackTraceOnce(new Exception("Try to use other varians to prevent creation of second param char$ptr "
              + "(i.e. append(str, str.$add(strlen(str))) can be replaced by append(str, strlen(str)) "));
    }
    append(in_start, in_end.$index() - in_start.$index());
  }
  
  public final void append(char$ptr in_start) {
    append(in_start, strlen(in_start));
  }
  
  public final void append$T(char$ptr in_start, int count) {
    append(in_start, count);
  }  
  public final void append(char$ptr in_start, int count) {
    // Grow allocated space if needed.
    int end = size();
    this.reserve(end+count);
    for (int i = 0; i < count; i++) {
      $set(end, in_start.$at(i));
      ++end;
    }
    set_size(end);
  }
  
  /// Append from a SmallVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::append">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 89,
   FQN = "llvm::SmallString::append", NM = "_ZN4llvm11SmallString6appendERKNS_15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallString6appendERKNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public void append(/*const*/SmallVectorImplChar/*&*/ RHS) {
    this.append(RHS, 0, RHS.size());
  }
  public void append(/*const*/SmallVectorImplChar/*&*/ RHS, int fromIdx, int toIdxExclusive) {
    int count = (toIdxExclusive - fromIdx);
    super.append(RHS.$array(), fromIdx, count);
  }

  
  /// Check for string equality.  This is more efficient than compare() when
  /// the relative ordering of inequal strings isn't needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::equals">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 99,
   FQN = "llvm::SmallString::equals", NM = "_ZNK4llvm11SmallString6equalsENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString6equalsENS_9StringRefE")
  //</editor-fold>
  public boolean equals(StringRef RHS) /*const*/ {
    int Len = RHS.size();
    return (this.size() == Len) && (memcmp(RHS.data(), 0, this.$array(), 0, Len) == 0);
  }
  public boolean equals(String RHS) /*const*/ {
    int Len = RHS.length();
    return (this.size() == Len) && (memcmp(this.$array(), 0, RHS, Len) == 0);
  }
  
  /// Check for string equality, ignoring case.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::equals_lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 104,
   FQN = "llvm::SmallString::equals_lower", NM = "_ZNK4llvm11SmallString12equals_lowerENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString12equals_lowerENS_9StringRefE")
  //</editor-fold>
  public boolean equals_lower(StringRef RHS) /*const*/ {
    return str().equals_lower(RHS);
  }

  
  /// Compare two strings; the result is -1, 0, or 1 if this string is
  /// lexicographically less than, equal to, or greater than the \p RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::compare">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 110,
   FQN = "llvm::SmallString::compare", NM = "_ZNK4llvm11SmallString7compareENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString7compareENS_9StringRefE")
  //</editor-fold>
  public int compare(StringRef RHS) /*const*/ {
    return str().compare(RHS);
  }

  
  /// compare_lower - Compare two strings, ignoring case.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::compare_lower">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 115,
   FQN = "llvm::SmallString::compare_lower", NM = "_ZNK4llvm11SmallString13compare_lowerENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString13compare_lowerENS_9StringRefE")
  //</editor-fold>
  public int compare_lower(StringRef RHS) /*const*/ {
    return str().compare_lower(RHS);
  }

  
  /// compare_numeric - Compare two strings, treating sequences of digits as
  /// numbers.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::compare_numeric">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 121,
   FQN = "llvm::SmallString::compare_numeric", NM = "_ZNK4llvm11SmallString15compare_numericENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString15compare_numericENS_9StringRefE")
  //</editor-fold>
  public int compare_numeric(StringRef RHS) /*const*/ {
    return str().compare_numeric(RHS);
  }

  
  /// startswith - Check if this string starts with the given \p Prefix.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::startswith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 130,
   FQN = "llvm::SmallString::startswith", NM = "_ZNK4llvm11SmallString10startswithENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString10startswithENS_9StringRefE")
  //</editor-fold>
  public boolean startswith(StringRef Prefix) /*const*/ {
    return str().startswith(Prefix);
  }

  
  /// endswith - Check if this string ends with the given \p Suffix.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::endswith">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 135,
   FQN = "llvm::SmallString::endswith", NM = "_ZNK4llvm11SmallString8endswithENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString8endswithENS_9StringRefE")
  //</editor-fold>
  public boolean endswith(StringRef Suffix) /*const*/ {
    return str().endswith(Suffix);
  }

  // JAVA: moved to superclass
  /// find - Search for the first character \p C in the string.
  ///
  /// \return - The index of the first occurrence of \p C, or npos if not
  /// found.
//  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 147,
//   FQN = "llvm::SmallString::find", NM = "_ZNK4llvm11SmallString4findEcj",
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::find")
//  //</editor-fold>
//  public /*size_t*/int find(/*char*/byte C) /*const*/ {
//    return find(C, 0);
//  }
//  public /*size_t*/int find(/*char*/byte C, /*size_t*/int From/*= 0*/) /*const*/ {
//    return (int)str().find(C, From);
//  }

  
  /// Search for the first string \p Str in the string.
  ///
  /// \returns The index of the first occurrence of \p Str, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 155,
   FQN = "llvm::SmallString::find", NM = "_ZNK4llvm11SmallString4findENS_9StringRefEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString4findENS_9StringRefEj")
  //</editor-fold>
  public /*size_t*/int find(StringRef Str) /*const*/ {
    return find(Str, 0);
  }
  public /*size_t*/int find(StringRef Str, /*size_t*/int From/*= 0*/) /*const*/ {
    return str().find(Str, From);
  }

  
  /// Search for the last character \p C in the string.
  ///
  /// \returns The index of the last occurrence of \p C, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::rfind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 163,
   FQN = "llvm::SmallString::rfind", NM = "_ZNK4llvm11SmallString5rfindEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString5rfindEcj")
  //</editor-fold>
  public /*size_t*/int rfind(/*char*/byte C) /*const*/ {
    return rfind(C, StringRef.npos);
  }
  public /*size_t*/int rfind(/*char*/byte C, /*size_t*/int From/*= StringRef::npos*/) /*const*/ {
    return str().rfind(C, From);
  }

  
  /// Search for the last string \p Str in the string.
  ///
  /// \returns The index of the last occurrence of \p Str, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::rfind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 171,
   FQN = "llvm::SmallString::rfind", NM = "_ZNK4llvm11SmallString5rfindENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString5rfindENS_9StringRefE")
  //</editor-fold>
  public /*size_t*/int rfind(StringRef Str) /*const*/ {
    return str().rfind(Str);
  }

  
  /// Find the first character in the string that is \p C, or npos if not
  /// found. Same as find.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find_first_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 177,
   FQN = "llvm::SmallString::find_first_of", NM = "_ZNK4llvm11SmallString13find_first_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString13find_first_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_first_of(/*char*/byte C) /*const*/ {
    return find_first_of(C, 0);
  }
  public /*size_t*/int find_first_of(/*char*/byte C, /*size_t*/int From/*= 0*/) /*const*/ {
    return str().find_first_of(C, From);
  }

  
  /// Find the first character in the string that is in \p Chars, or npos if
  /// not found.
  ///
  /// Complexity: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find_first_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 185,
   FQN = "llvm::SmallString::find_first_of", NM = "_ZNK4llvm11SmallString13find_first_ofENS_9StringRefEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString13find_first_ofENS_9StringRefEj")
  //</editor-fold>
  public /*size_t*/int find_first_of(StringRef Chars) /*const*/ {
    return find_first_of(Chars, 0);
  }
  public /*size_t*/int find_first_of(StringRef Chars, /*size_t*/int From/*= 0*/) /*const*/ {
    return str().find_first_of(Chars, From);
  }

  
  /// Find the first character in the string that is not \p C or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find_first_not_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 191,
   FQN = "llvm::SmallString::find_first_not_of", NM = "_ZNK4llvm11SmallString17find_first_not_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString17find_first_not_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_first_not_of(/*char*/byte C) /*const*/ {
    return find_first_not_of(C, 0);
  }
  public /*size_t*/int find_first_not_of(/*char*/byte C, /*size_t*/int From/*= 0*/) /*const*/ {
    return str().find_first_not_of(C, From);
  }

  
  /// Find the first character in the string that is not in the string
  /// \p Chars, or npos if not found.
  ///
  /// Complexity: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find_first_not_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 199,
   FQN = "llvm::SmallString::find_first_not_of", NM = "_ZNK4llvm11SmallString17find_first_not_ofENS_9StringRefEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString17find_first_not_ofENS_9StringRefEj")
  //</editor-fold>
  public /*size_t*/int find_first_not_of(StringRef Chars) /*const*/ {
    return find_first_not_of(Chars, 0);
  }
  public /*size_t*/int find_first_not_of(StringRef Chars, /*size_t*/int From/*= 0*/) /*const*/ {
    return str().find_first_not_of(Chars, From);
  }

  
  /// Find the last character in the string that is \p C, or npos if not
  /// found.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find_last_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 205,
   FQN = "llvm::SmallString::find_last_of", NM = "_ZNK4llvm11SmallString12find_last_ofEcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString12find_last_ofEcj")
  //</editor-fold>
  public /*size_t*/int find_last_of(/*char*/byte C) /*const*/ {
    return find_last_of(C, StringRef.npos);
  }
  public /*size_t*/int find_last_of(/*char*/byte C, /*size_t*/int From/*= StringRef::npos*/) /*const*/ {
    return str().find_last_of(C, From);
  }

  
  /// Find the last character in the string that is in \p C, or npos if not
  /// found.
  ///
  /// Complexity: O(size() + Chars.size())
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::find_last_of">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 213,
   FQN = "llvm::SmallString::find_last_of", NM = "_ZNK4llvm11SmallString12find_last_ofENS_9StringRefEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString12find_last_ofENS_9StringRefEj")
  //</editor-fold>
  public /*size_t*/int find_last_of(StringRef Chars) /*const*/ {
    return find_last_of(Chars, StringRef.npos);
  }
  public /*size_t*/int find_last_of(StringRef Chars, /*size_t*/int From/*= StringRef::npos*/) /*const*/ {
    return str().find_last_of(Chars, From);
  }

  
  /// Return the number of occurrences of \p C in the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 223,
   FQN = "llvm::SmallString::count", NM = "_ZNK4llvm11SmallString5countEc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString5countEc")
  //</editor-fold>
  public /*size_t*/int count(/*char*/byte C) /*const*/ {
    return str().count(C);
  }

  
  /// Return the number of non-overlapped occurrences of \p Str in the
  /// string.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 229,
   FQN = "llvm::SmallString::count", NM = "_ZNK4llvm11SmallString5countENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString5countENS_9StringRefE")
  //</editor-fold>
  public /*size_t*/int count(StringRef Str) /*const*/ {
    return str().count(Str);
  }

  
  /// Return a reference to the substring from [Start, Start + N).
  ///
  /// \param Start The index of the starting character in the substring; if
  /// the index is npos or greater than the length of the string then the
  /// empty substring will be returned.
  ///
  /// \param N The number of characters to included in the substring. If \p N
  /// exceeds the number of characters remaining in the string, the string
  /// suffix (starting with \p Start) will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::substr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 246,
   FQN = "llvm::SmallString::substr", NM = "_ZNK4llvm11SmallString6substrEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString6substrEjj")
  //</editor-fold>
  public StringRef substr(/*size_t*/int Start) /*const*/ {
    return substr(Start, StringRef.npos);
  }
  public StringRef substr(/*size_t*/int Start, /*size_t*/int N/*= StringRef::npos*/) /*const*/ {
    return str().substr(Start, N);
  }

  
  /// Return a reference to the substring from [Start, End).
  ///
  /// \param Start The index of the starting character in the substring; if
  /// the index is npos or greater than the length of the string then the
  /// empty substring will be returned.
  ///
  /// \param End The index following the last character to include in the
  /// substring. If this is npos, or less than \p Start, or exceeds the
  /// number of characters remaining in the string, the string suffix
  /// (starting with \p Start) will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::slice">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 260,
   FQN = "llvm::SmallString::slice", NM = "_ZNK4llvm11SmallString5sliceEjj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString5sliceEjj")
  //</editor-fold>
  public StringRef slice(/*size_t*/int Start, /*size_t*/int End) /*const*/ {
    return str().slice(Start, End);
  }

  
  /// Explicit conversion to StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::str">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 267,
   FQN = "llvm::SmallString::str", NM = "_ZNK4llvm11SmallString3strEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZNK4llvm11SmallString3strEv")
  //</editor-fold>
  public StringRef str() /*const*/ {
    return new StringRef(this.$array(), this.size());
  }

  
  // TODO: Make this const, if it's safe...
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::c_str">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 270,
   FQN = "llvm::SmallString::c_str", NM = "_ZN4llvm11SmallString5c_strEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallString5c_strEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ c_str() {
    this.push_back((byte) 0);
    this.pop_back();
    return this.data();
  }

  
  /// Implicit conversion to StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::operator StringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 277,
   FQN = "llvm::SmallString::operator StringRef", NM = "_ZNK4llvm11SmallStringcvNS_9StringRefEEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -filter=llvm::SmallString::operator StringRef")
  //</editor-fold>
  public StringRef $StringRef() /*const*/ {
    return str();
  }

  
  // Extra operators.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 280,
   FQN = "llvm::SmallString::operator=", NM = "_ZN4llvm11SmallStringaSENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallStringaSENS_9StringRefE")
  //</editor-fold>
  public /*const*/SmallString/*&*/ $assign(StringRef RHS) {
    return $assign(RHS, 0, RHS.size());
  }
  public /*const*/SmallString/*&*/ $assign(StringRef RHS, int fromIndex, int toIndexExclusive) {
    this.clear();
    return $addassign(RHS, fromIndex, toIndexExclusive);
  }

  public /*const*/SmallString/*&*/ $assign(char$ptr RHS) {
    return this.$assign(RHS, strlen(RHS));
  }
  public /*const*/SmallString/*&*/ $assign(char$ptr RHS, int Len) {
    this.clear();
    return $addassign(RHS, Len);
  }

  public /*const*/SmallString/*&*/ $assign(/*const*/std.string /*&*/ RHS) {
    this.clear();
    return $addassign(RHS);
  }

  public /*const*/SmallString/*&*/ $assign(String RHS) {
    this.clear();
    return $addassign(RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::operator+=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 285,
   FQN = "llvm::SmallString::operator+=", NM = "_ZN4llvm11SmallStringpLENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallStringpLENS_9StringRefE")
  //</editor-fold>
  public SmallString /*&*/ $addassign(StringRef RHS) {
    return $addassign(RHS, 0, RHS.size());
  }
  public SmallString /*&*/ $addassign(StringRef RHS, int fromIndex, int toIndexExclusive) {
    this.append(RHS, fromIndex, toIndexExclusive);
    return /*Deref*/this;
  }

  public SmallString /*&*/ $addassign(/*const*/std.string /*&*/ RHS) {
    this.append(RHS);
    return /*Deref*/this;
  }

  public SmallString /*&*/ $addassign(/*const*/SmallVectorImplChar /*&*/ RHS) {
    this.append(RHS);
    return /*Deref*/this;
  }

  public SmallString /*&*/ $addassign(String RHS) {
    this.append(RHS);
    return /*Deref*/this;
  }

  public SmallString /*&*/ $addassign(char$ptr RHS) {
    return this.$addassign(RHS, strlen(RHS));
  }
  public SmallString /*&*/ $addassign(char$ptr RHS, int Len) {
    this.append(RHS, Len);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallString::operator+=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallString.h", line = 289,
   FQN = "llvm::SmallString::operator+=", NM = "_ZN4llvm11SmallStringpLEc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Builtins.cpp -nm=_ZN4llvm11SmallStringpLEc")
  //</editor-fold>
  public SmallString /*&*/ $addassign(/*char*/byte C) {
    this.push_back(C);
    return /*Deref*/this;
  }

  @Override
  public SmallString clone() {
    return new SmallString(this);
  }  
  
  public String toJavaString() {
    return Casts.toJavaString(this.$array(), 0, this.size());
  }

  public void toStringBuilder(StringBuilder out) {
    Casts.toStringBuilder(out, this.$array(), 0, this.size());
  }
    
  @Override
  public String toString() {
    return "SmallString{" + toJavaString() +"}";
  }

  @Override
  public std.string std$string() {
    return new std.string(this.$array(), 0, this.size());
  }
}
