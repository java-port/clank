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
package org.llvm.support.yaml.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.yaml.*;


//<editor-fold defaultstate="collapsed" desc="static type YAMLTraitsYamlGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr16has_ScalarTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22has_ScalarBitSetTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22validatedMappingTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr24unvalidatedMappingTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr27has_ScalarEnumerationTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;_ZN4llvm4yaml11needsQuotesENS_9StringRefE;_ZN4llvm4yaml6isBoolENS_9StringRefE;_ZN4llvm4yaml6isNullENS_9StringRefE;_ZN4llvm4yaml8isNumberENS_9StringRefE;_ZN4llvm4yaml9isNumericENS_9StringRefE; -static-type=YAMLTraitsYamlGlobals -package=org.llvm.support.yaml.impl")
//</editor-fold>
public final class YAMLTraitsYamlGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 359,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 360,
 FQN="llvm::yaml::isNumber", NM="_ZN4llvm4yaml8isNumberENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml8isNumberENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isNumber(StringRef S) {
  Regex FloatMatcher = null;
  try {
    final/*static*/ /*const*//*char*/char$ptr/*byte*/ OctalChars/*[9]*/ = isNumber$$.OctalChars;
    if (S.startswith(/*STRINGREF_STR*/"0")
       && S.drop_front().find_first_not_of(/*STRINGREF_STR*/OctalChars) == StringRef.npos) {
      return true;
    }
    if (S.startswith(/*STRINGREF_STR*/"0o")
       && S.drop_front(2).find_first_not_of(/*STRINGREF_STR*/OctalChars) == StringRef.npos) {
      return true;
    }
    
    final/*static*/ /*const*//*char*/char$ptr/*byte*/ HexChars/*[23]*/ = isNumber$$.HexChars;
    if (S.startswith(/*STRINGREF_STR*/"0x")
       && S.drop_front(2).find_first_not_of(/*STRINGREF_STR*/HexChars) == StringRef.npos) {
      return true;
    }
    
    final/*static*/ /*const*//*char*/char$ptr/*byte*/ DecChars/*[11]*/ = isNumber$$.DecChars;
    if (S.find_first_not_of(/*STRINGREF_STR*/DecChars) == StringRef.npos) {
      return true;
    }
    if (S.equals(/*STRINGREF_STR*/".inf") || S.equals(/*STRINGREF_STR*/".Inf") || S.equals(/*STRINGREF_STR*/".INF")) {
      return true;
    }
    
    FloatMatcher/*J*/= new Regex(new StringRef(/*KEEP_STR*/"^(\\.[0-9]+|[0-9]+(\\.[0-9]*)?)([eE][-+]?[0-9]+)?$"));
    if (FloatMatcher.match(/*NO_COPY*/S)) {
      return true;
    }
    
    return false;
  } finally {
    if (FloatMatcher != null) { FloatMatcher.$destroy(); }
  }
}
private static final class isNumber$$ {
  static final/*static*/ /*const*//*char*/char$ptr/*byte*/ OctalChars/*[9]*/ = $("01234567");
  static final/*static*/ /*const*//*char*/char$ptr/*byte*/ HexChars/*[23]*/ = $("0123456789abcdefABCDEF");
  static final/*static*/ /*const*//*char*/char$ptr/*byte*/ DecChars/*[11]*/ = $("0123456789");
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isNumeric">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 388,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 389,
 FQN="llvm::yaml::isNumeric", NM="_ZN4llvm4yaml9isNumericENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml9isNumericENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isNumeric(StringRef S) {
  if ((S.front() == $$MINUS || S.front() == $$PLUS) && isNumber(S.drop_front())) {
    return true;
  }
  if (isNumber(new StringRef(S))) {
    return true;
  }
  if (S.equals(/*STRINGREF_STR*/".nan") || S.equals(/*STRINGREF_STR*/".NaN") || S.equals(/*STRINGREF_STR*/".NAN")) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 401,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 402,
 FQN="llvm::yaml::isNull", NM="_ZN4llvm4yaml6isNullENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6isNullENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isNull(StringRef S) {
  return S.equals(/*STRINGREF_STR*/"null") || S.equals(/*STRINGREF_STR*/"Null") || S.equals(/*STRINGREF_STR*/"NULL")
     || S.equals(/*STRINGREF_STR*/$TILDE);
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isBool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 406,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 407,
 FQN="llvm::yaml::isBool", NM="_ZN4llvm4yaml6isBoolENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6isBoolENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isBool(StringRef S) {
  return S.equals(/*STRINGREF_STR*/$true) || S.equals(/*STRINGREF_STR*/"True") || S.equals(/*STRINGREF_STR*/"TRUE")
     || S.equals(/*STRINGREF_STR*/$false) || S.equals(/*STRINGREF_STR*/"False") || S.equals(/*STRINGREF_STR*/"FALSE");
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::needsQuotes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 411,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 412,
 FQN="llvm::yaml::needsQuotes", NM="_ZN4llvm4yaml11needsQuotesENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml11needsQuotesENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean needsQuotes(StringRef S) {
  if (S.empty()) {
    return true;
  }
  if ((isspace(S.front()) != 0) || (isspace(S.back()) != 0)) {
    return true;
  }
  if (S.front() == $$COMMA) {
    return true;
  }
  
  final/*static*/ /*const*//*char*/char$ptr/*byte*/ ScalarSafeChars/*[71]*/ = needsQuotes$$.ScalarSafeChars;
  if (S.find_first_not_of(/*STRINGREF_STR*/ScalarSafeChars) != StringRef.npos) {
    return true;
  }
  if (isNull(new StringRef(S))) {
    return true;
  }
  if (isBool(new StringRef(S))) {
    return true;
  }
  if (isNumeric(new StringRef(S))) {
    return true;
  }
  
  return false;
}
private static final class needsQuotes$$ {
  static final/*static*/ /*const*//*char*/char$ptr/*byte*/ ScalarSafeChars/*[71]*/ = $("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-/^., \t");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 636,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr27has_ScalarEnumerationTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr27has_ScalarEnumerationTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<has_ScalarEnumerationTraits<T>::value, void>::type*/
        void yamlize$HasScalarEnumerationTraits(final IO /*&*/ io, ScalarEnumerationTraits<T> traits, final type$ref<T> /*&*/ Val, boolean $Prm2) {
  io.beginEnumScalar();
  traits.enumeration(io, Val);
  io.endEnumScalar();
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 644,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22has_ScalarBitSetTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22has_ScalarBitSetTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<has_ScalarBitSetTraits<T>::value, void>::type*/void yamlize$HasScalarBitSetTraits(final IO /*&*/ io, final T /*&*/ Val, boolean $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
//  bool$ref DoClear = create_bool$ref();
//  if (io.beginBitSetScalar(DoClear)) {
//    if (DoClear.$deref()) {
//      Val.$assign(((/*static_cast*/T)(0)));
//    }
//    ScalarBitSetTraits.<T>bitset(io, Val);
//    io.endBitSetScalar();
//  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 656,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr16has_ScalarTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr16has_ScalarTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends ScalarTraits<X>> /*std::enable_if<has_ScalarTraits<T>::value, void>::type*/void yamlize$HasScalarTraits(final IO /*&*/ io, T traits, final X /*&*/ Val, boolean $Prm2) {
  if (io.outputting()) {
    raw_string_ostream Buffer = null;
    try {
      std.string Storage/*J*/= new std.string();
      Buffer/*J*/= new raw_string_ostream(Storage);
      traits.output(Val, io.getContext(), Buffer);
      StringRef Str = new StringRef(Buffer.str());
      io.scalarString(Str, traits.mustQuote(Str));
    } finally {
      if (Buffer != null) { Buffer.$destroy(); }
    }
  } else {
    StringRef Str/*J*/= new StringRef();
    io.scalarString(Str, traits.mustQuote(Str));
    StringRef Result = traits.input(Str, io.getContext(), Val);
    if (!Result.empty()) {
      io.setError(new Twine(Result));
    }
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 676,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<has_BlockScalarTraits<T>::value, void>::type*/void yamlize$HasBlockScalarTraits(final IO /*&*/ YamlIO, final T /*&*/ Val, boolean $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
//  if (YamlIO.outputting()) {
//    raw_string_ostream Buffer = null;
//    try {
//      std.string Storage/*J*/= new std.string();
//      Buffer/*J*/= new raw_string_ostream(Storage);
//      BlockScalarTraits.<T>output(Val, YamlIO.getContext(), Buffer);
//      StringRef Str = new StringRef(Buffer.str());
//      YamlIO.blockScalarString(Str);
//    } finally {
//      if (Buffer != null) { Buffer.$destroy(); }
//    }
//  } else {
//    StringRef Str/*J*/= new StringRef();
//    YamlIO.blockScalarString(Str);
//    StringRef Result = BlockScalarTraits.<T>input(Str, YamlIO.getContext(), Val);
//    if (!Result.empty()) {
//      YamlIO.setError(new Twine(Result));
//    }
//  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 695,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22validatedMappingTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22validatedMappingTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends MappingTraits<X>> /*std::enable_if<validatedMappingTraits<T>::value, void>::type*/
        void yamlize$ValidatedMappingTraits(final IO /*&*/ io, T map,  final X /*&*/ Val, boolean $Prm2) {
  if (map.$hasFlow()) {
    io.beginFlowMapping();
  } else {
    io.beginMapping();
  }
  if (io.outputting()) {
    StringRef Err = map.validate(io, Val);
    if (!Err.empty()) {
      llvm.errs().$out(/*NO_COPY*/Err).$out(/*KEEP_STR*/$LF);
      assert (Err.empty()) : "invalid struct trying to be written as yaml";
    }
  }
  map.mapping(io, Val);
  if (!io.outputting()) {
    StringRef Err = map.validate(io, Val);
    if (!Err.empty()) {
      io.setError(new Twine(Err));
    }
  }
  if (map.$hasFlow()) {
    io.endFlowMapping();
  } else {
    io.endMapping();
  }
}

/*template <typename T> TEMPLATE*/
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 721,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr24unvalidatedMappingTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr24unvalidatedMappingTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends MappingTraits<X>> /*std::enable_if<unvalidatedMappingTraits<T>::value, void>::type*/
void yamlize$NotValidatedMappingTraits(final IO /*&*/ io, T map, final X /*&*/ Val, boolean $Prm2) {
  if (map.$hasFlow()) {
    io.beginFlowMapping();
    map.mapping(io, Val);
    io.endFlowMapping();
  } else {
    io.beginMapping();
    map.mapping(io, Val);
    io.endMapping();
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 735,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<missingTraits<T>::value, void>::type*/void yamlize$MissingTraits(final IO /*&*/ io, final T /*&*/ Val, boolean $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
  ///*char*/byte missing_yaml_trait_for_type[$sizeof_MissingTrait$T()] = new$char($sizeof_MissingTrait$T());
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 741,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends Sequence<type$ref<X>>> /*std::enable_if<has_SequenceTraits<T>::value, void>::type*/
        void yamlize$YamlConvertible(final IO /*&*/ io,SequenceTraits<X,T> traits, final T /*&*/ Seq, boolean $Prm2) {
  if (traits.$hasFlow()) {
    /*uint*/int incnt = io.beginFlowSequence();
    /*uint*/int count = io.outputting() ? traits.size(io, Seq) : incnt;
    for (/*uint*/int i = 0; $less_uint(i, count); ++i) {
      type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
      if (io.preflightFlowElement(i, SaveInfo)) {
        MappingTraits<X> elementMappingTrait = traits.elementMappingTrait();
        if (elementMappingTrait != null){
          if (elementMappingTrait.$hasValidate()) {
            YamlGlobals.yamlize$ValidatedMappingTraits(io, elementMappingTrait, traits.element(io, Seq, i), true);
          } else {
            YamlGlobals.yamlize$NotValidatedMappingTraits(io, elementMappingTrait, traits.element(io, Seq, i), true);
          }
        } else {
          YamlGlobals.yamlize$HasScalarTraits(io, traits.elementScalarTrait(), traits.element(io, Seq, i), true);
        }
        io.postflightFlowElement(SaveInfo.$deref());
      }
    }
    io.endFlowSequence();
  } else {
    /*uint*/int incnt = io.beginSequence();
    /*uint*/int count = io.outputting() ? traits.size(io, Seq) : incnt;
    for (/*uint*/int i = 0; $less_uint(i, count); ++i) {
      type$ref<Object/*void P*/ > SaveInfo = create_type$ref();
      if (io.preflightElement(i, SaveInfo)) {
        MappingTraits<X> elementMappingTrait = traits.elementMappingTrait();
        if (elementMappingTrait != null){
          if (elementMappingTrait.$hasValidate()) {
            YamlGlobals.yamlize$ValidatedMappingTraits(io, elementMappingTrait, traits.element(io, Seq, i), true);
          } else {
            YamlGlobals.yamlize$NotValidatedMappingTraits(io, elementMappingTrait, traits.element(io, Seq, i), true);
          }
        } else {
          YamlGlobals.yamlize$HasScalarTraits(io, traits.elementScalarTrait(), traits.element(io, Seq, i), true);
        }
        io.postflightElement(SaveInfo.$deref());
      }
    }
    io.endSequence();
  }
}


// Define non-member operator>> so that Input can stream in a document list.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1240,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1209,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ <X, /*typename*/ T extends Sequence<type$ref<X>>> /*std::enable_if<has_DocumentListTraits<T>::value, Input  >::type*/
        Input /*&*/ $in$HasDocumentListTraits(final Input /*&*/ yin, DocumentListTraits<X,T> traits, final T /*&*/ docList) {
  int i = 0;
  while (yin.setCurrentDocument()) {
    yamlize$NotValidatedMappingTraits(yin, traits.elementMappingTrait(), traits.element(yin, docList, i), true);
    if (yin.error().$bool()) {
      return yin;
    }
    yin.nextDocument();
    ++i;
  }
  return yin;
}


// Define non-member operator>> so that Input can stream in a map as a document.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1256,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1225,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_MappingTraits<T>::value, Input  >::type*/Input /*&*/ $in$HasMappingTraits(final Input /*&*/ yin, final T /*&*/ docMap) {
  throw new UnsupportedOperationException("EmptyBody");
//  yin.setCurrentDocument();
//  yamlize(yin, docMap, true);
//  return yin;
}


// Define non-member operator>> so that Input can stream in a sequence as
// a document.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1267,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1236,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_SequenceTraits<T>::value, Input  >::type*/Input /*&*/ $in$YamlConvertible(final Input /*&*/ yin, final T /*&*/ docSeq) {
  throw new UnsupportedOperationException("EmptyBody");
//  if (yin.setCurrentDocument()) {
//    yamlize(yin, docSeq, true);
//  }
//  return yin;
}


// Define non-member operator>> so that Input can stream in a block scalar.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1277,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1246,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_BlockScalarTraits<T>::value, Input  >::type*/Input /*&*/ $in$HasBlockScalarTraits(final Input /*&*/ In, final T /*&*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
//  if (In.setCurrentDocument()) {
//    yamlize(In, Val, true);
//  }
//  return In;
}


// Provide better error message about types missing a trait specialization
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1287,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1256,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<missingTraits<T>::value, Input  >::type*/Input /*&*/ $in$MissingTraits(final Input /*&*/ yin, final T /*&*/ docSeq) {
  throw new UnsupportedOperationException("EmptyBody");
//  /*char*/byte missing_yaml_trait_for_type[$sizeof_MissingTrait$T()] = new$char($sizeof_MissingTrait$T());
//  return yin;
}


// Define non-member operator<< so that Output can stream out document list.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1296,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1265,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_DocumentListTraits<T>::value, Output  >::type*/Output /*&*/ $out$HasDocumentListTraits(final Output /*&*/ yout, final T /*&*/ docList) {
  throw new UnsupportedOperationException("EmptyBody");
//  yout.beginDocuments();
//  /*const*//*size_t*/int count = DocumentListTraits.<T>size(yout, docList);
//  for (/*size_t*/int i = 0; $less_uint(i, count); ++i) {
//    if (yout.preflightDocument(i)) {
//      yamlize(yout, DocumentListTraits.<T>element(yout, docList, i), true);
//      yout.postflightDocument();
//    }
//  }
//  yout.endDocuments();
//  return yout;
}


// Define non-member operator<< so that Output can stream out a map.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1313,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1282,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ <X, /*typename*/ T extends MappingTraits<X>> /*std::enable_if<has_MappingTraits<T>::value, Output  >::type*/
        Output /*&*/ $out$HasMappingTraits(final Output /*&*/ yout, final T /*&*/ map, final X object) {
  yout.beginDocuments();
  if (yout.preflightDocument(0)) {
    if (map.$hasValidate()) {
      YamlGlobals.yamlize$ValidatedMappingTraits(yout, map, object, true);
    } else {
      YamlGlobals.yamlize$NotValidatedMappingTraits(yout, map, object, true);
    }
    yout.postflightDocument();
  }
  yout.endDocuments();
  return yout;
}


// Define non-member operator<< so that Output can stream out a sequence.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1327,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1296,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_SequenceTraits<T>::value, Output  >::type*/Output /*&*/ $out$YamlConvertible(final Output /*&*/ yout, final T /*&*/ seq) {
  throw new UnsupportedOperationException("EmptyBody");
//  yout.beginDocuments();
//  if (yout.preflightDocument(0)) {
//    yamlize(yout, seq, true);
//    yout.postflightDocument();
//  }
//  yout.endDocuments();
//  return yout;
}


// Define non-member operator<< so that Output can stream out a block scalar.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1341,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1310,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_BlockScalarTraits<T>::value, Output  >::type*/Output /*&*/ $out$HasBlockScalarTraits(final Output /*&*/ Out, final T /*&*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
//  Out.beginDocuments();
//  if (Out.preflightDocument(0)) {
//    yamlize(Out, Val, true);
//    Out.postflightDocument();
//  }
//  Out.endDocuments();
//  return Out;
}


// Provide better error message about types missing a trait specialization
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1355,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1324,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<missingTraits<T>::value, Output  >::type*/Output /*&*/ $out$MissingTraits(final Output /*&*/ yout, final T /*&*/ seq) {
  throw new UnsupportedOperationException("EmptyBody");
//  /*char*/byte missing_yaml_trait_for_type[$sizeof_MissingTrait$T()] = new$char($sizeof_MissingTrait$T());
//  return yout;
}

} // END OF class YAMLTraitsYamlGlobals
