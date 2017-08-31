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
package org.llvm.support.yaml;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.YAMLParserStatics.*;
import org.llvm.support.java.MappingSequenceInterface;


//<editor-fold defaultstate="collapsed" desc="static type YamlGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.yaml.YamlGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml4skipERT_;Tpl__ZN4llvm4yaml5beginERT_;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr16has_ScalarTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22has_ScalarBitSetTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22validatedMappingTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr24unvalidatedMappingTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr27has_ScalarEnumerationTraitsIT_EE5valueEvE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE;_ZN4llvm4yaml10dumpTokensENS_9StringRefERNS_11raw_ostreamE;_ZN4llvm4yaml10scanTokensENS_9StringRefE;_ZN4llvm4yaml11needsQuotesENS_9StringRefE;_ZN4llvm4yaml6escapeB5cxx11ENS_9StringRefE;_ZN4llvm4yaml6isBoolENS_9StringRefE;_ZN4llvm4yaml6isNullENS_9StringRefE;_ZN4llvm4yaml8isNumberENS_9StringRefE;_ZN4llvm4yaml9isNumericENS_9StringRefE; -static-type=YamlGlobals -package=org.llvm.support.yaml")
//</editor-fold>
public final class YamlGlobals {


/// \brief Dump all the tokens in this stream to OS.
/// \returns true if there was an error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::dumpTokens">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 601,
 FQN="llvm::yaml::dumpTokens", NM="_ZN4llvm4yaml10dumpTokensENS_9StringRefERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10dumpTokensENS_9StringRefERNS_11raw_ostreamE")
//</editor-fold>
public static boolean dumpTokens(StringRef Input, final raw_ostream /*&*/ OS) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLParserYamlGlobals.
    dumpTokens(Input, OS);
}


/// \brief Scans all tokens in input without outputting anything. This is used
///        for benchmarking the tokenizer.
/// \returns true if there was an error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::scanTokens">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 685,
 FQN="llvm::yaml::scanTokens", NM="_ZN4llvm4yaml10scanTokensENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10scanTokensENS_9StringRefE")
//</editor-fold>
public static boolean scanTokens(StringRef Input) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLParserYamlGlobals.
    scanTokens(Input);
}


/// \brief Escape \a Input for a double quoted scalar.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::escape">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 698,
 FQN="llvm::yaml::escape", NM="_ZN4llvm4yaml6escapeENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6escapeENS_9StringRefE")
//</editor-fold>
public static std.string escape(StringRef Input) {
  std.string EscapedInput/*J*/= new std.string();
  for (char$ptr i = $tryClone(Input.begin()), /*P*/ e = $tryClone(Input.end()); $noteq_ptr(i, e); i.$preInc()) {
    if (i.$star() == $$BACK_SLASH) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\\\");
    } else if (i.$star() == $$DBL_QUOTE) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\\"");
    } else if (i.$star() == 0) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\0");
    } else if (i.$star() == 0x07) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\a");
    } else if (i.$star() == 0x08) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\b");
    } else if (i.$star() == 0x09) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\t");
    } else if (i.$star() == 0x0A) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\n");
    } else if (i.$star() == 0x0B) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\v");
    } else if (i.$star() == 0x0C) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\f");
    } else if (i.$star() == 0x0D) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\r");
    } else if (i.$star() == 0x1B) {
      EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\e");
    } else if ($uchar2int((/*uchar*/byte)i.$star()) < 0x20) { // Control characters not handled above.
      std.string HexStr = utohexstr($char2ulong(i.$star()));
      EscapedInput.$addassign($add_string_string$C($add_T$C$P_string(/*KEEP_STR*/"\\x", new std.string(2 - HexStr.size(), $$0)), HexStr));
    } else if (((i.$star() & 0x80) != 0)) { // UTF-8 multiple code unit subsequence.
      std.pairUIntUInt UnicodeScalarValue = decodeUTF8(new StringRef(i, Input.end().$sub(i)));
      if (UnicodeScalarValue.second == 0) {
        // Found invalid char.
        SmallString/*4*/ Val/*J*/= new SmallString/*4*/(4);
        encodeUTF8(0xFFFD, Val);
        EscapedInput.insert$T(EscapedInput.end(), Val.begin(), Val.end());
        // FIXME: Error reporting.
        return EscapedInput;
      }
      if (UnicodeScalarValue.first == 0x85) {
        EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\N");
      } else if (UnicodeScalarValue.first == 0xA0) {
        EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\_");
      } else if (UnicodeScalarValue.first == 0x2028) {
        EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\L");
      } else if (UnicodeScalarValue.first == 0x2029) {
        EscapedInput.$addassign_T$C$P(/*KEEP_STR*/"\\P");
      } else {
        std.string HexStr = utohexstr($uint2ulong(UnicodeScalarValue.first));
        if ($lesseq_uint(HexStr.size(), 2)) {
          EscapedInput.$addassign($add_string_string$C($add_T$C$P_string(/*KEEP_STR*/"\\x", new std.string(2 - HexStr.size(), $$0)), HexStr));
        } else if ($lesseq_uint(HexStr.size(), 4)) {
          EscapedInput.$addassign($add_string_string$C($add_T$C$P_string(/*KEEP_STR*/"\\u", new std.string(4 - HexStr.size(), $$0)), HexStr));
        } else if ($lesseq_uint(HexStr.size(), 8)) {
          EscapedInput.$addassign($add_string_string$C($add_T$C$P_string(/*KEEP_STR*/"\\U", new std.string(8 - HexStr.size(), $$0)), HexStr));
        }
      }
      i.$inc(UnicodeScalarValue.second - 1);
    } else {
      EscapedInput.push_back(i.$star());
    }
  }
  return EscapedInput;
}


// The following two templates are used for both MappingNode and Sequence Node.
/*template <class CollectionType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 363,
 FQN="llvm::yaml::begin", NM="Tpl__ZN4llvm4yaml5beginERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=Tpl__ZN4llvm4yaml5beginERT_")
//</editor-fold>
public static </*class*/ CollectionType extends MappingSequenceInterface> basic_collection_iterator<CollectionType, ? extends Node> begin(final CollectionType /*&*/ C) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLParserYamlGlobals.
    begin(C);
}

/*template <class CollectionType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::skip">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 371,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 372,
 FQN="llvm::yaml::skip", NM="Tpl__ZN4llvm4yaml4skipERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=Tpl__ZN4llvm4yaml4skipERT_")
//</editor-fold>
public static </*class*/ CollectionType extends MappingSequenceInterface> void skip(final CollectionType /*&*/ C) {
  /*delegate*/org.llvm.support.yaml.impl.YAMLParserYamlGlobals.
    skip(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isNumber">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 359,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 360,
 FQN="llvm::yaml::isNumber", NM="_ZN4llvm4yaml8isNumberENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml8isNumberENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isNumber(StringRef S) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    isNumber(S);
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isNumeric">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 388,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 389,
 FQN="llvm::yaml::isNumeric", NM="_ZN4llvm4yaml9isNumericENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml9isNumericENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isNumeric(StringRef S) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    isNumeric(S);
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isNull">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 401,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 402,
 FQN="llvm::yaml::isNull", NM="_ZN4llvm4yaml6isNullENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6isNullENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isNull(StringRef S) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    isNull(S);
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::isBool">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 406,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 407,
 FQN="llvm::yaml::isBool", NM="_ZN4llvm4yaml6isBoolENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6isBoolENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isBool(StringRef S) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    isBool(S);
}

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::needsQuotes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 411,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 412,
 FQN="llvm::yaml::needsQuotes", NM="_ZN4llvm4yaml11needsQuotesENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml11needsQuotesENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean needsQuotes(StringRef S) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    needsQuotes(S);
}

/*template <typename T> TEMPLATE*/
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 636,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr27has_ScalarEnumerationTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr27has_ScalarEnumerationTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<has_ScalarEnumerationTraits<T>::value, void>::type*/
        void yamlize$HasScalarEnumerationTraits(final IO /*&*/ io, ScalarEnumerationTraits<T> traits, final type$ref<T> /*&*/ Val, boolean $Prm2) {
  /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    yamlize$HasScalarEnumerationTraits(io, traits, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 644,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22has_ScalarBitSetTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22has_ScalarBitSetTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<has_ScalarBitSetTraits<T>::value, void>::type*/void yamlize$HasScalarBitSetTraits(final IO /*&*/ io, final T /*&*/ Val, boolean $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
  //return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
  //  yamlize$HasScalarBitSetTraits(io, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 656,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr16has_ScalarTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr16has_ScalarTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends ScalarTraits<X>> /*std::enable_if<has_ScalarTraits<T>::value, void>::type*/void yamlize$HasScalarTraits(final IO /*&*/ io, T traits, final X /*&*/ Val, boolean $Prm2) {
  /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    yamlize$HasScalarTraits(io, traits, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 676,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<has_BlockScalarTraits<T>::value, void>::type*/void yamlize$HasBlockScalarTraits(final IO /*&*/ YamlIO, final T /*&*/ Val, boolean $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
  //return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
  //  yamlize$HasBlockScalarTraits(YamlIO, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 695,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22validatedMappingTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr22validatedMappingTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends MappingTraits<X>> /*std::enable_if<validatedMappingTraits<T>::value, void>::type*/
        void yamlize$ValidatedMappingTraits(final IO /*&*/ io, T map, final X /*&*/ Val, boolean $Prm2) {
  /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
  yamlize$ValidatedMappingTraits(io, map, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 721,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr24unvalidatedMappingTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr24unvalidatedMappingTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends MappingTraits<X>> /*std::enable_if<unvalidatedMappingTraits<T>::value, void>::type*/
        void yamlize$NotValidatedMappingTraits(final IO /*&*/ io, T map, final X /*&*/ Val, boolean $Prm2) {
  /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    yamlize$NotValidatedMappingTraits(io, map, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 735,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static </*typename*/ T> /*std::enable_if<missingTraits<T>::value, void>::type*/void yamlize$MissingTraits(final IO /*&*/ io, final T /*&*/ Val, boolean $Prm2) {
  throw new UnsupportedOperationException("EmptyBody");
  //return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
  //  yamlize$MissingTraits(io, Val, $Prm2);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::yamlize">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 741,
 FQN="llvm::yaml::yamlize", NM="Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yaml7yamlizeERNS0_2IOERT_bR_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueEvE4typeE")
//</editor-fold>
public static <X, /*typename*/ T extends Sequence<type$ref<X>>> /*std::enable_if<has_SequenceTraits<T>::value, void>::type*/
        void yamlize$YamlConvertible(final IO /*&*/ io, SequenceTraits<X,T> traits, final T /*&*/ Seq, boolean $Prm2) {
  /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    yamlize$YamlConvertible(io, traits,  Seq, $Prm2);
}


// Define non-member operator>> so that Input can stream in a document list.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1240,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1209,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ <X, /*typename*/ T extends Sequence<type$ref<X>>> /*std::enable_if<has_DocumentListTraits<T>::value, Input  >::type*/
        Input /*&*/ $in$HasDocumentListTraits(final Input /*&*/ yin, DocumentListTraits<X,T> traits, final T /*&*/ docList) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $in$HasDocumentListTraits(yin, traits, docList);
}


// Define non-member operator>> so that Input can stream in a map as a document.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1256,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1225,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_MappingTraits<T>::value, Input  >::type*/Input /*&*/ $in$HasMappingTraits(final Input /*&*/ yin, final T /*&*/ docMap) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $in$HasMappingTraits(yin, docMap);
}


// Define non-member operator>> so that Input can stream in a sequence as
// a document.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1267,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1236,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_SequenceTraits<T>::value, Input  >::type*/Input /*&*/ $in$YamlConvertible(final Input /*&*/ yin, final T /*&*/ docSeq) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $in$YamlConvertible(yin, docSeq);
}


// Define non-member operator>> so that Input can stream in a block scalar.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1277,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1246,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_BlockScalarTraits<T>::value, Input  >::type*/Input /*&*/ $in$HasBlockScalarTraits(final Input /*&*/ In, final T /*&*/ Val) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $in$HasBlockScalarTraits(In, Val);
}


// Provide better error message about types missing a trait specialization
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator>>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1287,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1256,
 FQN="llvm::yaml::operator>>", NM="Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamlrsERNS0_5InputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml5InputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<missingTraits<T>::value, Input  >::type*/Input /*&*/ $in$MissingTraits(final Input /*&*/ yin, final T /*&*/ docSeq) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $in$MissingTraits(yin, docSeq);
}


// Define non-member operator<< so that Output can stream out document list.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1296,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1265,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr22has_DocumentListTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_DocumentListTraits<T>::value, Output  >::type*/Output /*&*/ $out$HasDocumentListTraits(final Output /*&*/ yout, final T /*&*/ docList) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $out$HasDocumentListTraits(yout, docList);
}


// Define non-member operator<< so that Output can stream out a map.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1313,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1282,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr17has_MappingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ <X, /*typename*/ T extends MappingTraits<X>> /*std::enable_if<has_MappingTraits<T>::value, Output  >::type*/
        Output /*&*/ $out$HasMappingTraits(final Output /*&*/ yout, final T /*&*/ map, final X object) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $out$HasMappingTraits(yout, map, object);
}


// Define non-member operator<< so that Output can stream out a sequence.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1327,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1296,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr18has_SequenceTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_SequenceTraits<T>::value, Output  >::type*/Output /*&*/ $out$YamlConvertible(final Output /*&*/ yout, final T /*&*/ seq) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $out$YamlConvertible(yout, seq);
}


// Define non-member operator<< so that Output can stream out a block scalar.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1341,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1310,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr21has_BlockScalarTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<has_BlockScalarTraits<T>::value, Output  >::type*/Output /*&*/ $out$HasBlockScalarTraits(final Output /*&*/ Out, final T /*&*/ Val) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $out$HasBlockScalarTraits(Out, Val);
}


// Provide better error message about types missing a trait specialization
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1355,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1324,
 FQN="llvm::yaml::operator<<", NM="Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=Tpl__ZN4llvm4yamllsERNS0_6OutputERT_R_ZTSNSt9enable_ifIXsr13missingTraitsIT_EE5valueERN4llvm4yaml6OutputEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<missingTraits<T>::value, Output  >::type*/Output /*&*/ $out$MissingTraits(final Output /*&*/ yout, final T /*&*/ seq) {
  return /*delegate*/org.llvm.support.yaml.impl.YAMLTraitsYamlGlobals.
    $out$MissingTraits(yout, seq);
}

} // END OF class YamlGlobals
