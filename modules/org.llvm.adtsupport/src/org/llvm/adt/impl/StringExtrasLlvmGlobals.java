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
package org.llvm.adt.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.type$iterator;
import static org.clank.support.literal_constants.$$0;
import static org.clank.support.NativePointer.new$char;
import static org.clank.support.literal_constants.$$MINUS;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.llvm.$addassign_string_StringRef;


//<editor-fold defaultstate="collapsed" desc="static type StringExtrasLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.adt.impl.StringExtrasLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=Tpl__ZN4llvm4joinB5cxx11ET_S0_NS_9StringRefE;Tpl__ZN4llvm9join_implB5cxx11ET_S0_NS_9StringRefESt18input_iterator_tag;Tpl__ZN4llvm9join_implB5cxx11ET_S0_NS_9StringRefESt20forward_iterator_tag;_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_;_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_;_ZN4llvm8getTokenENS_9StringRefES0_;_ZN4llvmL10HashStringENS_9StringRefEj;_ZN4llvmL11toStringRefEb;_ZN4llvmL13hexDigitValueEc;_ZN4llvmL16getOrdinalSuffixEj;_ZN4llvmL5toHexB5cxx11ENS_9StringRefE;_ZN4llvmL6itostrB5cxx11Ex;_ZN4llvmL6utostrB5cxx11Eyb;_ZN4llvmL8hexdigitEjb;_ZN4llvmL9utohexstrB5cxx11Eyb; -static-type=StringExtrasLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class StringExtrasLlvmGlobals {


/// hexdigit - Return the hexadecimal character for the
/// given number \p X (which should be less than 16).
//<editor-fold defaultstate="collapsed" desc="llvm::hexdigit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 26,
 FQN="llvm::hexdigit", NM="_ZN4llvmL8hexdigitEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL8hexdigitEjb")
//</editor-fold>
public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X) {
  return hexdigit(X, false);
}
public static /*inline*/ /*char*/byte hexdigit(/*uint*/int X, boolean LowerCase/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Construct a string ref from a boolean.
//<editor-fold defaultstate="collapsed" desc="llvm::toStringRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 32,
 FQN="llvm::toStringRef", NM="_ZN4llvmL11toStringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL11toStringRefEb")
//</editor-fold>
public static /*inline*/ StringRef toStringRef(boolean B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Interpret the given character \p C as a hexadecimal digit and return its
/// value.
///
/// If \p C is not a valid hex digit, -1U is returned.
//<editor-fold defaultstate="collapsed" desc="llvm::hexDigitValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 40,
 FQN="llvm::hexDigitValue", NM="_ZN4llvmL13hexDigitValueEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL13hexDigitValueEc")
//</editor-fold>
public static /*inline*/ /*uint*/int hexDigitValue(/*char*/byte C) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::utohexstr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 47,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 72,
 FQN="llvm::utohexstr", NM="_ZN4llvmL9utohexstrEyb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL9utohexstrEyb")
//</editor-fold>
public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X) {
  return utohexstr(X, false);
}
public static /*inline*/ std.string utohexstr(long/*uint64_t*/ X, boolean LowerCase/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Convert buffer \p Input to its hexadecimal representation.
/// The returned string is double the size of \p Input.
//<editor-fold defaultstate="collapsed" desc="llvm::toHex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 64,
 FQN="llvm::toHex", NM="_ZN4llvmL5toHexENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL5toHexENS_9StringRefE")
//</editor-fold>
public static /*inline*/ std.string toHex(StringRef Input) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::utostr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 78,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 93,
 FQN="llvm::utostr", NM="_ZN4llvmL6utostrEyb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL6utostrEyb")
//</editor-fold>
public static /*inline*/ std.string utostr(long/*uint64_t*/ X) {
  return utostr(X, false);
}
public static /*inline*/ std.string utostr(long/*uint64_t*/ X, boolean isNeg/*= false*/) {
  /*char*/byte Buffer[/*21*/] = new$char(21);
  char$ptr/*char P*/ BufPtr = $tryClone(std.end(Buffer));
  if (X == $int2ullong(0)) {
    BufPtr.$preDec().$set($$0); // Handle special case...
  }
  while ((X != 0)) {
    BufPtr.$preDec().$set($int2char($$0 + ((/*char*/byte)($ullong2char($rem_ulong_ullong(X, $int2ullong(10)))))));
    X = $div_ulong_ullong(X, $int2ullong(10));
  }
  if (isNeg) {
    BufPtr.$preDec().$set($$MINUS); // Add negative sign...
  }
  return new std.string(BufPtr, std.end(Buffer));
}

//<editor-fold defaultstate="collapsed" desc="llvm::itostr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 94,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 109,
 FQN="llvm::itostr", NM="_ZN4llvmL6itostrEx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL6itostrEx")
//</editor-fold>
public static /*inline*/ std.string itostr(long/*int64_t*/ X) {
  if (X < 0) {
    return utostr(((/*static_cast*/long/*uint64_t*/)(-X)), true);
  } else {
    return utostr(((/*static_cast*/long/*uint64_t*/)(X)));
  }
}


/// StrInStrNoCase - Portable version of strcasestr.  Locates the first
/// occurrence of string 's1' in string 's2', ignoring case.  Returns
/// the offset of s2 in s1 or npos if s2 cannot be found.

/// StrInStrNoCase - Portable version of strcasestr.  Locates the first
/// occurrence of string 's1' in string 's2', ignoring case.  Returns
/// the offset of s2 in s1 or npos if s2 cannot be found.
//<editor-fold defaultstate="collapsed" desc="llvm::StrInStrNoCase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 21,
 FQN="llvm::StrInStrNoCase", NM="_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm14StrInStrNoCaseENS_9StringRefES0_")
//</editor-fold>
public static /*size_t*/int StrInStrNoCase(StringRef s1, StringRef s2) {
  /*size_t*/int N = s2.size();
  /*size_t*/int M = s1.size();
  if ($greater_uint(N, M)) {
    return StringRef.npos;
  }
  for (/*size_t*/int i = 0, e = M - N + 1; i != e; ++i)  {
    if (s1.substr(i, N).equals_lower(/*NO_COPY*/s2)) {
      return i;
    }
  }
  return StringRef.npos;
}


/// getToken - This function extracts one token from source, ignoring any
/// leading characters that appear in the Delimiters string, and ending the
/// token at any of the characters that appear in the Delimiters string.  If
/// there are no tokens in the source string, an empty string is returned.
/// The function returns a pair containing the extracted token and the
/// remaining tail string.

/// getToken - This function extracts one token from source, ignoring any
/// leading characters that appear in the Delimiters string, and ending the
/// token at any of the characters that appear in the Delimiters string.  If
/// there are no tokens in the source string, an empty string is returned.
/// The function returns a pair containing the extracted token and the
/// remaining tail string.
//<editor-fold defaultstate="collapsed" desc="llvm::getToken">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 37,
 FQN="llvm::getToken", NM="_ZN4llvm8getTokenENS_9StringRefES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm8getTokenENS_9StringRefES0_")
//</editor-fold>
public static std.pairTypeType<StringRef, StringRef> getToken(StringRef Source) {
  return getToken(Source, 
        new StringRef(/*KEEP_STR*/" \t\n\013\014\015"));
}
public static std.pairTypeType<StringRef, StringRef> getToken(StringRef Source, 
        StringRef Delimiters/*= " \t\n\013\014\015"*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// SplitString - Split up the specified string according to the specified
/// delimiters, appending the result fragments to the output list.

/// SplitString - Split up the specified string according to the specified
/// delimiters, appending the result fragments to the output list.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp", line = 50,
 FQN="llvm::SplitString", NM="_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvm11SplitStringENS_9StringRefERNS_15SmallVectorImplIS0_EES0_")
//</editor-fold>
public static void SplitString(StringRef Source, 
           final SmallVectorImpl<StringRef> /*&*/ OutFragments) {
  SplitString(Source, 
           OutFragments, 
           new StringRef(/*KEEP_STR*/" \t\n\013\014\015"));
}
public static void SplitString(StringRef Source, 
           final SmallVectorImpl<StringRef> /*&*/ OutFragments, 
           StringRef Delimiters/*= " \t\n\013\014\015"*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// HashString - Hash function for strings.
///
/// This is the Bernstein hash function.
//
// FIXME: Investigate whether a modified bernstein hash function performs
// better: http://eternallyconfuzzled.com/tuts/algorithms/jsw_tut_hashing.aspx
//   X*33+c -> X*33^c
//<editor-fold defaultstate="collapsed" desc="llvm::HashString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 128,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 143,
 FQN="llvm::HashString", NM="_ZN4llvmL10HashStringENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL10HashStringENS_9StringRefEj")
//</editor-fold>
public static /*inline*/ /*uint*/int HashString(StringRef Str) {
  return HashString(Str, 0);
}
public static /*inline*/ /*uint*/int HashString(StringRef Str, /*uint*/int Result/*= 0*/) {
  for (int i = 0, e = Str.size(); i != e; ++i)
    Result = Result * 33 + Str.$at(i);
  return Result;
}
public static /*inline*/ /*uint*/int HashString(char$ptr Str, int KeyLen) {
  return HashString(Str, KeyLen, 0);
}
public static /*inline*/ /*uint*/int HashString(char$ptr Str, int KeyLen, /*uint*/int Result/*= 0*/) {
  for (int i = 0, e = KeyLen; i != e; ++i)
    Result = Result * 33 + Str.$at(i);
  return Result;
}
public static /*inline*/ /*uint*/int HashString(byte Str[], int fromIdx, int KeyLen) {
  /*uint*/int Result = 0;
  for (int i = fromIdx, e = fromIdx + KeyLen; i != e; ++i)
    Result = Result * 33 + Str[i];
  return Result;
}

/// Returns the English suffix for an ordinal integer (-st, -nd, -rd, -th).
//<editor-fold defaultstate="collapsed" desc="llvm::getOrdinalSuffix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 135,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 150,
 FQN="llvm::getOrdinalSuffix", NM="_ZN4llvmL16getOrdinalSuffixEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringExtras.cpp -nm=_ZN4llvmL16getOrdinalSuffixEj")
//</editor-fold>
public static /*inline*/ StringRef getOrdinalSuffix(/*uint*/int Val) {
  // It is critically important that we do this perfectly for
  // user-written sequences with over 100 elements.
  switch ($rem_uint(Val, 100)) {
   case 11:
   case 12:
   case 13:
    return new StringRef(/*KEEP_STR*/"th");
   default:
    switch ($rem_uint(Val, 10)) {
     case 1:
      return new StringRef(/*KEEP_STR*/"st");
     case 2:
      return new StringRef(/*KEEP_STR*/"nd");
     case 3:
      return new StringRef(/*KEEP_STR*/"rd");
     default:
      return new StringRef(/*KEEP_STR*/"th");
    }
  }
}

/*template <typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 154,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 168,
 FQN="llvm::join_impl", NM="Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt18input_iterator_tag")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT> std.string join_impl_T_StringRef_input_iterator_tag(IteratorT Begin, IteratorT End, 
                                        StringRef Separator, std.input_iterator_tag $Prm3) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 169,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 183,
 FQN="llvm::join_impl", NM="Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=Tpl__ZN4llvm9join_implET_S0_NS_9StringRefESt20forward_iterator_tag")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT extends type$iterator<?, std.string>> std.string join_impl_T_StringRef_forward_iterator_tag(IteratorT Begin, IteratorT End, 
                                          StringRef Separator, std.forward_iterator_tag $Prm3) {
  std.string S/*J*/= new std.string();
  if (Native.$eq_iter(Begin, End)) {
    return S;
  }
  
  /*size_t*/int Len = (std.distance(Begin, End) - (1)) * Separator.size();
  for (type$iterator<?, std.string/*P*/> I = $tryClone(Begin); I.$noteq(End); I.$preInc())  {
    Len += (I.$star()).size();
  }
  S.reserve(Len);
  S.$addassign(($Deref(Begin)));
  while (Begin.$preInc().$noteq(End)) {
    $addassign_string_StringRef(S, /*NO_COPY*/Separator);
    S.$addassign(($Deref(Begin)));
  }
  return S;
}
////template <typename IteratorT = basic_string<char> *> 
////<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 169,
// FQN="llvm::join_impl", NM="_ZN4llvm9join_implIPSsEESsT_S2_NS_9StringRefESt20forward_iterator_tag",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm9join_implIPSsEESsT_S2_NS_9StringRefESt20forward_iterator_tag")
////</editor-fold>
//public static /*inline*/ std.string join_impl_T_StringRef_forward_iterator_tag(type$ptr<std.string/*P*/> Begin, type$ptr<std.string/*P*/> End, 
//                                          StringRef Separator, std.forward_iterator_tag $Prm3) {
//  std.string S/*J*/= new std.string();
//  if (Native.$eq_iter(Begin, End)) {
//    return S;
//  }
//  
//  /*size_t*/int Len = (std.distance(Begin, End) - (1)) * Separator.size();
//  for (type$ptr<std.string/*P*/> I = $tryClone(Begin); I.$noteq(End); I.$preInc())  {
//    Len += (I.$star()).size();
//  }
//  S.reserve(Len);
//  S.$addassign(Begin.$star());
//  while (Begin.$preInc().$noteq(End)) {
//    $addassign_string_StringRef(S, /*NO_COPY*/Separator);
//    S.$addassign(Begin.$star());
//  }
//  return S;
//}
////template <typename IteratorT = __normal_iterator<basic_string<char> *, vector<basic_string<char>, allocator<basic_string<char> > > >> 
////<editor-fold defaultstate="collapsed" desc="llvm::join_impl">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 169,
// FQN="llvm::join_impl", NM="_ZN4llvm9join_implIN9__gnu_cxx17__normal_iteratorIPSsSt6vectorISsSaISsEEEEEESsT_S8_NS_9StringRefESt20forward_iterator_tag",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm9join_implIN9__gnu_cxx17__normal_iteratorIPSsSt6vectorISsSaISsEEEEEESsT_S8_NS_9StringRefESt20forward_iterator_tag")
////</editor-fold>
//public static /*inline*/ std.string join_impl_T_StringRef_forward_iterator_tag(std.vector.iterator<std.string/*P*/ > Begin, std.vector.iterator<std.string/*P*/ > End, 
//                                          StringRef Separator, std.forward_iterator_tag $Prm3) {
//  std.string S/*J*/= new std.string();
//  if ($eq___normal_iterator$C(Begin, End)) {
//    return S;
//  }
//  
//  /*size_t*/int Len = (std.distance((Begin), (End)) - (1)) * Separator.size();
//  for (std.vector.iterator<std.string/*P*/ > I = new std.vector.iterator<std.string/*P*/ >(Begin); $noteq___normal_iterator$C(I, End); I.$preInc())  {
//    Len += (I.$star()).size();
//  }
//  S.reserve(Len);
//  S.$addassign((Begin.$star()));
//  while ($noteq___normal_iterator$C(Begin.$preInc(), End)) {
//    $addassign_string_StringRef(S, /*NO_COPY*/Separator);
//    S.$addassign((Begin.$star()));
//  }
//  return S;
//}

/// Joins the strings in the range [Begin, End), adding Separator between
/// the elements.
/*template <typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::join">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 190,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", old_line = 204,
 FQN="llvm::join", NM="Tpl__ZN4llvm4joinET_S0_NS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=Tpl__ZN4llvm4joinET_S0_NS_9StringRefE")
//</editor-fold>
public static /*inline*/ </*typename*/ IteratorT extends type$iterator<?, std.string>> std.string join(IteratorT Begin, IteratorT End, StringRef Separator) {
  // JAVA: typedef typename std::iterator_traits<IteratorT>::iterator_category tag
//  final class tag extends  std.iterator_traits.iterator_category<IteratorT>{ };
  return join_impl_T_StringRef_forward_iterator_tag(Begin, End, new StringRef(Separator), new std.forward_iterator_tag(JD$Move.INSTANCE, new std.random_access_iterator_tag()));
}
///// Joins the strings in the range [Begin, End), adding Separator between
///// the elements.
////template <typename IteratorT = basic_string<char> *> 
////<editor-fold defaultstate="collapsed" desc="llvm::join">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 190,
// FQN="llvm::join", NM="_ZN4llvm4joinIPSsEESsT_S2_NS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm4joinIPSsEESsT_S2_NS_9StringRefE")
////</editor-fold>
//public static /*inline*/ std.string join(type$ptr<std.string/*P*/> Begin, type$ptr<std.string/*P*/> End, StringRef Separator) {
//  // JAVA: typedef typename std::iterator_traits<basic_string<char> *>::iterator_category tag
////  final class tag extends std.random_access_iterator_tag{ };
//  return join_impl_T_StringRef_forward_iterator_tag(Begin, End, new StringRef(Separator), new std.forward_iterator_tag(JD$Move.INSTANCE, new std.random_access_iterator_tag()));
//}
////template <typename IteratorT = __normal_iterator<basic_string<char> *, vector<basic_string<char>, allocator<basic_string<char> > > >> 
////<editor-fold defaultstate="collapsed" desc="llvm::join">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringExtras.h", line = 190,
// FQN="llvm::join", NM="_ZN4llvm4joinIN9__gnu_cxx17__normal_iteratorIPSsSt6vectorISsSaISsEEEEEESsT_S8_NS_9StringRefE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm4joinIN9__gnu_cxx17__normal_iteratorIPSsSt6vectorISsSaISsEEEEEESsT_S8_NS_9StringRefE")
////</editor-fold>
//public static /*inline*/ std.string join(std.vector.iterator<std.string/*P*/ > Begin, std.vector.iterator<std.string/*P*/ > End, StringRef Separator) {
//  // JAVA: typedef typename std::iterator_traits<__normal_iterator<basic_string<char> *, vector<basic_string<char>, allocator<basic_string<char> > > > >::iterator_category tag
////  final class tag extends std.random_access_iterator_tag{ };
//  return join_impl_T_StringRef_forward_iterator_tag((Begin), (End), new StringRef(Separator), new std.forward_iterator_tag(JD$Move.INSTANCE, new std.random_access_iterator_tag()));
//}
} // END OF class StringExtrasLlvmGlobals
