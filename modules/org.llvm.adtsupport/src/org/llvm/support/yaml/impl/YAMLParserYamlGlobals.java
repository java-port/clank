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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.YAMLParserStatics.*;
import org.llvm.support.java.MappingSequenceInterface;
import org.llvm.support.yaml.Node;
import org.llvm.support.yaml.basic_collection_iterator;


//<editor-fold defaultstate="collapsed" desc="static type YAMLParserYamlGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.yaml.impl.YAMLParserYamlGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=Tpl__ZN4llvm4yaml4skipERT_;Tpl__ZN4llvm4yaml5beginERT_;_ZN4llvm4yaml10dumpTokensENS_9StringRefERNS_11raw_ostreamE;_ZN4llvm4yaml10scanTokensENS_9StringRefE;_ZN4llvm4yaml6escapeB5cxx11ENS_9StringRefE; -static-type=YAMLParserYamlGlobals -package=org.llvm.support.yaml.impl")
//</editor-fold>
public final class YAMLParserYamlGlobals {


/// \brief Dump all the tokens in this stream to OS.
/// \returns true if there was an error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::dumpTokens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 601,
 FQN="llvm::yaml::dumpTokens", NM="_ZN4llvm4yaml10dumpTokensENS_9StringRefERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10dumpTokensENS_9StringRefERNS_11raw_ostreamE")
//</editor-fold>
public static boolean dumpTokens(StringRef Input, final raw_ostream /*&*/ OS) {
  SourceMgr SM = null;
  Scanner scanner = null;
  try {
    SM/*J*/= new SourceMgr();
    scanner/*J*/= new Scanner(new StringRef(Input), SM);
    while (true) {
      Token T = null;
      try {
        T = scanner.getNext();
        switch (T.Kind) {
         case TK_StreamStart:
          OS.$out(/*KEEP_STR*/"Stream-Start: ");
          break;
         case TK_StreamEnd:
          OS.$out(/*KEEP_STR*/"Stream-End: ");
          break;
         case TK_VersionDirective:
          OS.$out(/*KEEP_STR*/"Version-Directive: ");
          break;
         case TK_TagDirective:
          OS.$out(/*KEEP_STR*/"Tag-Directive: ");
          break;
         case TK_DocumentStart:
          OS.$out(/*KEEP_STR*/"Document-Start: ");
          break;
         case TK_DocumentEnd:
          OS.$out(/*KEEP_STR*/"Document-End: ");
          break;
         case TK_BlockEntry:
          OS.$out(/*KEEP_STR*/"Block-Entry: ");
          break;
         case TK_BlockEnd:
          OS.$out(/*KEEP_STR*/"Block-End: ");
          break;
         case TK_BlockSequenceStart:
          OS.$out(/*KEEP_STR*/"Block-Sequence-Start: ");
          break;
         case TK_BlockMappingStart:
          OS.$out(/*KEEP_STR*/"Block-Mapping-Start: ");
          break;
         case TK_FlowEntry:
          OS.$out(/*KEEP_STR*/"Flow-Entry: ");
          break;
         case TK_FlowSequenceStart:
          OS.$out(/*KEEP_STR*/"Flow-Sequence-Start: ");
          break;
         case TK_FlowSequenceEnd:
          OS.$out(/*KEEP_STR*/"Flow-Sequence-End: ");
          break;
         case TK_FlowMappingStart:
          OS.$out(/*KEEP_STR*/"Flow-Mapping-Start: ");
          break;
         case TK_FlowMappingEnd:
          OS.$out(/*KEEP_STR*/"Flow-Mapping-End: ");
          break;
         case TK_Key:
          OS.$out(/*KEEP_STR*/"Key: ");
          break;
         case TK_Value:
          OS.$out(/*KEEP_STR*/"Value: ");
          break;
         case TK_Scalar:
          OS.$out(/*KEEP_STR*/"Scalar: ");
          break;
         case TK_BlockScalar:
          OS.$out(/*KEEP_STR*/"Block Scalar: ");
          break;
         case TK_Alias:
          OS.$out(/*KEEP_STR*/"Alias: ");
          break;
         case TK_Anchor:
          OS.$out(/*KEEP_STR*/"Anchor: ");
          break;
         case TK_Tag:
          OS.$out(/*KEEP_STR*/"Tag: ");
          break;
         case TK_Error:
          break;
        }
        OS.$out(/*NO_COPY*/T.Range).$out(/*KEEP_STR*/$LF);
        if (T.Kind == Token.TokenKind.TK_StreamEnd) {
          break;
        } else if (T.Kind == Token.TokenKind.TK_Error) {
          return false;
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    return true;
  } finally {
    if (scanner != null) { scanner.$destroy(); }
    if (SM != null) { SM.$destroy(); }
  }
}


/// \brief Scans all tokens in input without outputting anything. This is used
///        for benchmarking the tokenizer.
/// \returns true if there was an error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::scanTokens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 685,
 FQN="llvm::yaml::scanTokens", NM="_ZN4llvm4yaml10scanTokensENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10scanTokensENS_9StringRefE")
//</editor-fold>
public static boolean scanTokens(StringRef Input) {
  SourceMgr SM = null;
  Scanner scanner = null;
  try {
    SM/*J*/= new SourceMgr();
    scanner/*J*/= new Scanner(new StringRef(Input), SM);
    for (;;) {
      Token T = null;
      try {
        T = scanner.getNext();
        if (T.Kind == Token.TokenKind.TK_StreamEnd) {
          break;
        } else if (T.Kind == Token.TokenKind.TK_Error) {
          return false;
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    return true;
  } finally {
    if (scanner != null) { scanner.$destroy(); }
    if (SM != null) { SM.$destroy(); }
  }
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
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 363,
 FQN="llvm::yaml::begin", NM="Tpl__ZN4llvm4yaml5beginERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=Tpl__ZN4llvm4yaml5beginERT_")
//</editor-fold>
public static </*class*/ CollectionType extends MappingSequenceInterface>  basic_collection_iterator<CollectionType, ? extends Node> begin(final CollectionType /*&*/ C) {
  assert Native.$bool(C.isAtBeginning()) : "You may only iterate over a collection once!";
  C.setAtBeginning(false);
  basic_collection_iterator<CollectionType, ? extends Node> ret/*J*/= /*ParenList*/new  basic_collection_iterator(C);
  ret.$preInc();
  return ret;
}

/*template <class CollectionType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::skip">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 371,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 372,
 FQN="llvm::yaml::skip", NM="Tpl__ZN4llvm4yaml4skipERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=Tpl__ZN4llvm4yaml4skipERT_")
//</editor-fold>
public static </*class*/ CollectionType extends MappingSequenceInterface> void skip(final CollectionType /*&*/ C) {
  // TODO: support skipping from the middle of a parsed collection ;/
  assert Native.$bool((Native.$bool(C.isAtBeginning()) || Native.$bool(C.isAtEnd()))) : "Cannot skip mid parse!";
  if (C.isAtBeginning()) {
    for ( basic_collection_iterator i = begin(C), e = C.end(); Native.$noteq_ptr(i, e);
         i.$preInc())  {
      i.$star().skip();
    }
  }
}

} // END OF class YAMLParserYamlGlobals
