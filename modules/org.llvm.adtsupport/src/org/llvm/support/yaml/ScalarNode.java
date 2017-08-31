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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.YAMLParserStatics.*;
import org.llvm.support.yaml.impl.Token;


/// \brief A scalar node is an opaque datum that can be presented as a
///        series of zero or more Unicode scalar values.
///
/// Example:
///   Adena
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 190,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 191,
 FQN="llvm::yaml::ScalarNode", NM="_ZN4llvm4yaml10ScalarNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10ScalarNodeE")
//</editor-fold>
public final class ScalarNode extends /*public*/ Node {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 103,
   FQN="llvm::yaml::ScalarNode::anchor", NM="_ZN4llvm4yaml10ScalarNode6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10ScalarNode6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode::ScalarNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 194,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 195,
   FQN="llvm::yaml::ScalarNode::ScalarNode", NM="_ZN4llvm4yaml10ScalarNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10ScalarNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_S8_")
  //</editor-fold>
  public ScalarNode(final std.unique_ptr<Document> /*&*/ D, StringRef Anchor, StringRef Tag, 
      StringRef Val) {
    // : Node(NK_Scalar, D, Anchor, Tag), Value(Val) 
    //START JInit
    super(NodeKind.NK_Scalar.getValue(), D, new StringRef(Anchor), new StringRef(Tag));
    this.Value = new StringRef(Val);
    //END JInit
    SMLoc Start = SMLoc.getFromPointer(Val.begin());
    SMLoc End = SMLoc.getFromPointer(Val.end());
    SourceRange.$assignMove(new SMRange(new SMLoc(Start), new SMLoc(End)));
  }

  
  // Return Value without any escaping or folding or other fun YAML stuff. This
  // is the exact bytes that are contained in the file (after conversion to
  // utf8).
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode::getRawValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 205,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 206,
   FQN="llvm::yaml::ScalarNode::getRawValue", NM="_ZNK4llvm4yaml10ScalarNode11getRawValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml10ScalarNode11getRawValueEv")
  //</editor-fold>
  public StringRef getRawValue() /*const*/ {
    return new StringRef(Value);
  }

  
  /// \brief Gets the value of this node as a StringRef.
  ///
  /// \param Storage is used to store the content of the returned StringRef iff
  ///        it requires any modification from how it appeared in the source.
  ///        This happens with escaped characters and multi-line literals.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1884,
   FQN="llvm::yaml::ScalarNode::getValue", NM="_ZNK4llvm4yaml10ScalarNode8getValueERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml10ScalarNode8getValueERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public StringRef getValue(final SmallString/*&*/ Storage) /*const*/ {
    // TODO: Handle newlines properly. We need to remove leading whitespace.
    if (Value.$at(0) == $$DBL_QUOTE) { // Double quoted.
      // Pull off the leading and trailing "s.
      StringRef UnquotedValue = Value.substr(1, Value.size() - 2);
      // Search for characters that would require unescaping the value.
      /*size_t*/int i = UnquotedValue.find_first_of(/*STRINGREF_STR*/"\\\015\n");
      if (i != StringRef.npos) {
        return unescapeDoubleQuoted(new StringRef(UnquotedValue), i, Storage);
      }
      return UnquotedValue;
    } else if (Value.$at(0) == $$SGL_QUOTE) { // Single quoted.
      // Pull off the leading and trailing 's.
      StringRef UnquotedValue = Value.substr(1, Value.size() - 2);
      /*size_t*/int i = UnquotedValue.find($$SGL_QUOTE);
      if (i != StringRef.npos) {
        // We're going to need Storage.
        Storage.clear();
        Storage.reserve(UnquotedValue.size());
        for (; i != StringRef.npos; i = UnquotedValue.find($$SGL_QUOTE)) {
          StringRef Valid/*J*/= new StringRef(UnquotedValue.begin(), i);
          Storage.insert_iterator$T$value_T(Storage.end(), Valid.begin(), Valid.end());
          Storage.push_back($$SGL_QUOTE);
          UnquotedValue.$assignMove(UnquotedValue.substr(i + 2));
        }
        Storage.insert_iterator$T$value_T(Storage.end(), UnquotedValue.begin(), UnquotedValue.end());
        return new StringRef(Storage.begin(), Storage.size());
      }
      return UnquotedValue;
    }
    // Plain or block.
    return Value.rtrim($$SPACE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 215,
   FQN="llvm::yaml::ScalarNode::classof", NM="_ZN4llvm4yaml10ScalarNode7classofEPKNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml10ScalarNode7classofEPKNS0_4NodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Node /*P*/ N) {
    return N.getType() == NodeKind.NK_Scalar.getValue();
  }

/*private:*/
  private StringRef Value;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarNode::unescapeDoubleQuoted">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1917,
   FQN="llvm::yaml::ScalarNode::unescapeDoubleQuoted", NM="_ZNK4llvm4yaml10ScalarNode20unescapeDoubleQuotedENS_9StringRefEjRNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml10ScalarNode20unescapeDoubleQuotedENS_9StringRefEjRNS_15SmallVectorImplIcEE")
  //</editor-fold>
  private StringRef unescapeDoubleQuoted(StringRef UnquotedValue, 
                      /*size_t*/int i, 
                      final SmallString/*&*/ Storage) /*const*/ {
    // Use Storage to build proper value.
    Storage.clear();
    Storage.reserve(UnquotedValue.size());
    for (; i != StringRef.npos; i = UnquotedValue.find_first_of(/*STRINGREF_STR*/"\\\015\n")) {
      // Insert all previous chars into Storage.
      StringRef Valid/*J*/= new StringRef(UnquotedValue.begin(), i);
      Storage.insert_iterator$T$value_T(Storage.end(), Valid.begin(), Valid.end());
      // Chop off inserted chars.
      UnquotedValue.$assignMove(UnquotedValue.substr(i));
      assert (!UnquotedValue.empty()) : "Can't be empty!";
      
      // Parse escape or line break.
      switch (UnquotedValue.$at(0)) {
       case '\r':
       case '\n':
        Storage.push_back($$LF);
        if ($greater_uint(UnquotedValue.size(), 1)
           && (UnquotedValue.$at(1) == $$CR || UnquotedValue.$at(1) == $$LF)) {
          UnquotedValue.$assignMove(UnquotedValue.substr(1));
        }
        UnquotedValue.$assignMove(UnquotedValue.substr(1));
        break;
       default:
        if (UnquotedValue.size() == 1) {
          // TODO: Report error.
          break;
        }
        UnquotedValue.$assignMove(UnquotedValue.substr(1));
        switch (UnquotedValue.$at(0)) {
         default:
          {
            Token T = null;
            try {
              T/*J*/= new Token();
              T.Range.$assignMove(new StringRef(UnquotedValue.begin(), 1));
              setError(new Twine(/*KEEP_STR*/"Unrecognized escape code!"), T);
              return new StringRef(/*KEEP_STR*/$EMPTY);
            } finally {
              if (T != null) { T.$destroy(); }
            }
          }
         case '\r':
         case '\n':
          // Remove the new line.
          if ($greater_uint(UnquotedValue.size(), 1)
             && (UnquotedValue.$at(1) == $$CR || UnquotedValue.$at(1) == $$LF)) {
            UnquotedValue.$assignMove(UnquotedValue.substr(1));
          }
          // If this was just a single byte newline, it will get skipped
          // below.
          break;
         case '0':
          Storage.push_back((byte)0x00);
          break;
         case 'a':
          Storage.push_back((byte)0x07);
          break;
         case 'b':
          Storage.push_back((byte)0x08);
          break;
         case 't':
         case 0x09:
          Storage.push_back((byte)0x09);
          break;
         case 'n':
          Storage.push_back((byte)0x0A);
          break;
         case 'v':
          Storage.push_back((byte)0x0B);
          break;
         case 'f':
          Storage.push_back((byte)0x0C);
          break;
         case 'r':
          Storage.push_back((byte)0x0D);
          break;
         case 'e':
          Storage.push_back((byte)0x1B);
          break;
         case ' ':
          Storage.push_back((byte)0x20);
          break;
         case '"':
          Storage.push_back((byte)0x22);
          break;
         case '/':
          Storage.push_back((byte)0x2F);
          break;
         case '\\':
          Storage.push_back((byte)0x5C);
          break;
         case 'N':
          encodeUTF8(0x85, Storage);
          break;
         case '_':
          encodeUTF8(0xA0, Storage);
          break;
         case 'L':
          encodeUTF8(0x2028, Storage);
          break;
         case 'P':
          encodeUTF8(0x2029, Storage);
          break;
         case 'x':
          {
            if ($less_uint(UnquotedValue.size(), 3)) {
              // TODO: Report error.
              break;
            }
            uint$ref UnicodeScalarValue = create_uint$ref();
            if (UnquotedValue.substr(1, 2).getAsInteger$NotSigned(16, UnicodeScalarValue)) {
              // TODO: Report error.
              UnicodeScalarValue.$set(0xFFFD);
            }
            encodeUTF8(UnicodeScalarValue.$deref(), Storage);
            UnquotedValue.$assignMove(UnquotedValue.substr(2));
            break;
          }
         case 'u':
          {
            if ($less_uint(UnquotedValue.size(), 5)) {
              // TODO: Report error.
              break;
            }
            uint$ref UnicodeScalarValue = create_uint$ref();
            if (UnquotedValue.substr(1, 4).getAsInteger$NotSigned(16, UnicodeScalarValue)) {
              // TODO: Report error.
              UnicodeScalarValue.$set(0xFFFD);
            }
            encodeUTF8(UnicodeScalarValue.$deref(), Storage);
            UnquotedValue.$assignMove(UnquotedValue.substr(4));
            break;
          }
         case 'U':
          {
            if ($less_uint(UnquotedValue.size(), 9)) {
              // TODO: Report error.
              break;
            }
            uint$ref UnicodeScalarValue = create_uint$ref();
            if (UnquotedValue.substr(1, 8).getAsInteger$NotSigned(16, UnicodeScalarValue)) {
              // TODO: Report error.
              UnicodeScalarValue.$set(0xFFFD);
            }
            encodeUTF8(UnicodeScalarValue.$deref(), Storage);
            UnquotedValue.$assignMove(UnquotedValue.substr(8));
            break;
          }
        }
        UnquotedValue.$assignMove(UnquotedValue.substr(1));
      }
    }
    Storage.insert_iterator$T$value_T(Storage.end(), UnquotedValue.begin(), UnquotedValue.end());
    return new StringRef(Storage.begin(), Storage.size());
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
