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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;


/// Token - A single YAML token.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 111,
 FQN="llvm::yaml::Token", NM="_ZN4llvm4yaml5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenE")
//</editor-fold>
public class/*struct*/ Token implements ilist_node<Token>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::TokenKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 112,
   FQN="llvm::yaml::Token::TokenKind", NM="_ZN4llvm4yaml5Token9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5Token9TokenKindE")
  //</editor-fold>
  public enum TokenKind implements Native.NativeUIntEnum {
    TK_Error(0), // Uninitialized token.
    TK_StreamStart(TK_Error.getValue() + 1),
    TK_StreamEnd(TK_StreamStart.getValue() + 1),
    TK_VersionDirective(TK_StreamEnd.getValue() + 1),
    TK_TagDirective(TK_VersionDirective.getValue() + 1),
    TK_DocumentStart(TK_TagDirective.getValue() + 1),
    TK_DocumentEnd(TK_DocumentStart.getValue() + 1),
    TK_BlockEntry(TK_DocumentEnd.getValue() + 1),
    TK_BlockEnd(TK_BlockEntry.getValue() + 1),
    TK_BlockSequenceStart(TK_BlockEnd.getValue() + 1),
    TK_BlockMappingStart(TK_BlockSequenceStart.getValue() + 1),
    TK_FlowEntry(TK_BlockMappingStart.getValue() + 1),
    TK_FlowSequenceStart(TK_FlowEntry.getValue() + 1),
    TK_FlowSequenceEnd(TK_FlowSequenceStart.getValue() + 1),
    TK_FlowMappingStart(TK_FlowSequenceEnd.getValue() + 1),
    TK_FlowMappingEnd(TK_FlowMappingStart.getValue() + 1),
    TK_Key(TK_FlowMappingEnd.getValue() + 1),
    TK_Value(TK_Key.getValue() + 1),
    TK_Scalar(TK_Value.getValue() + 1),
    TK_BlockScalar(TK_Scalar.getValue() + 1),
    TK_Alias(TK_BlockScalar.getValue() + 1),
    TK_Anchor(TK_Alias.getValue() + 1),
    TK_Tag(TK_Anchor.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TokenKind valueOf(int val) {
      TokenKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TokenKind[] VALUES;
      private static final TokenKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TokenKind kind : TokenKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TokenKind[min < 0 ? (1-min) : 0];
        VALUES = new TokenKind[max >= 0 ? (1+max) : 0];
        for (TokenKind kind : TokenKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private TokenKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  public  TokenKind Kind;
  
  /// A string of length 0 or more whose begin() points to the logical location
  /// of the token in the input.
  public StringRef Range;
  
  /// The value of a block scalar node.
  public std.string Value;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 145,
   FQN="llvm::yaml::Token::Token", NM="_ZN4llvm4yaml5TokenC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenC1Ev")
  //</editor-fold>
  public Token() {
    // : ilist_node<Token>(), Kind(TK_Error), Range(), Value() 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this.Kind = TokenKind.TK_Error;
    this.Range = new StringRef();
    this.Value = new std.string();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 111,
   FQN="llvm::yaml::Token::Token", NM="_ZN4llvm4yaml5TokenC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Token(final /*const*/ Token /*&*/ $Prm0) {
    // : ilist_node<Token>(), Kind(.Kind), Range(.Range), Value(.Value) 
    //START JInit
    this.ilist_node$Flds = $ilist_node($Prm0);
    this.Kind = $Prm0.Kind;
    this.Range = new StringRef($Prm0.Range);
    this.Value = new std.string($Prm0.Value);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 111,
   FQN="llvm::yaml::Token::Token", NM="_ZN4llvm4yaml5TokenC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenC1EOS1_")
  //</editor-fold>
  public /*inline*/ Token(JD$Move _dparam, final Token /*&&*/$Prm0) {
    // : ilist_node<Token>(static_cast<Token &&>()), Kind(static_cast<Token &&>().Kind), Range(static_cast<Token &&>().Range), Value(static_cast<Token &&>().Value) 
    //START JInit
    this.ilist_node$Flds = $ilist_node(JD$Move.INSTANCE, $Prm0);
    this.Kind = $Prm0.Kind;
    this.Range = new StringRef(JD$Move.INSTANCE, $Prm0.Range);
    this.Value = new std.string(JD$Move.INSTANCE, $Prm0.Value);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 111,
   FQN="llvm::yaml::Token::operator=", NM="_ZN4llvm4yaml5TokenaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenaSERKS1_")
  //</editor-fold>
  public /*inline*/ Token /*&*/ $assign(final /*const*/ Token /*&*/ $Prm0) {
    /*J:ToBase*/ilist_node.super.$assign$ilist_node($Prm0);
    this.Kind = $Prm0.Kind;
    this.Range.$assign($Prm0.Range);
    this.Value.$assign($Prm0.Value);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 111,
   FQN="llvm::yaml::Token::operator=", NM="_ZN4llvm4yaml5TokenaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenaSEOS1_")
  //</editor-fold>
  public /*inline*/ Token /*&*/ $assignMove(final Token /*&&*/$Prm0) {
    /*J:ToBase*/ilist_node.super.$assignMove$ilist_node($Prm0);
    this.Kind = $Prm0.Kind;
    this.Range.$assignMove($Prm0.Range);
    this.Value.$assignMove($Prm0.Value);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Token::~Token">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 111,
   FQN="llvm::yaml::Token::~Token", NM="_ZN4llvm4yaml5TokenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml5TokenD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Value.$destroy();
    ilist_node.super.$destroy$ilist_node();
    //END JDestroy
  }

  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }

  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Range=" + Range // NOI18N
              + ", Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
