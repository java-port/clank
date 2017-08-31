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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.support.yaml.impl.Token;


/// \brief Represents a YAML map created from either a block map for a flow map.
///
/// This parses the YAML stream as increment() is called.
///
/// Example:
///   Name: _main
///   Scope: Global
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 387,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 388,
 FQN="llvm::yaml::MappingNode", NM="_ZN4llvm4yaml11MappingNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNodeE")
//</editor-fold>
public final class MappingNode extends /*public*/ Node implements Iterable<KeyValueNode>, org.llvm.support.java.MappingSequenceInterface {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 106,
   FQN="llvm::yaml::MappingNode::anchor", NM="_ZN4llvm4yaml11MappingNode6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::MappingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 391,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 392,
   FQN="llvm::yaml::MappingNode::MappingType", NM="_ZN4llvm4yaml11MappingNode11MappingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode11MappingTypeE")
  //</editor-fold>
  public enum MappingType implements Native.NativeUIntEnum {
    MT_Block(0),
    MT_Flow(MT_Block.getValue() + 1),
    MT_Inline(MT_Flow.getValue() + 1); ///< An inline mapping node is used for "[key: value]".

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MappingType valueOf(int val) {
      MappingType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MappingType[] VALUES;
      private static final MappingType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MappingType kind : MappingType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MappingType[min < 0 ? (1-min) : 0];
        VALUES = new MappingType[max >= 0 ? (1+max) : 0];
        for (MappingType kind : MappingType.values()) {
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
    private MappingType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::MappingNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 397,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 398,
   FQN="llvm::yaml::MappingNode::MappingNode", NM="_ZN4llvm4yaml11MappingNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_NS1_11MappingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_NS1_11MappingTypeE")
  //</editor-fold>
  public MappingNode(final std.unique_ptr<Document> /*&*/ D, StringRef Anchor, StringRef Tag, 
      MappingType MT) {
    // : Node(NK_Mapping, D, Anchor, Tag), Type(MT), IsAtBeginning(true), IsAtEnd(false), CurrentEntry(null) 
    //START JInit
    super(NodeKind.NK_Mapping.getValue(), D, new StringRef(Anchor), new StringRef(Tag));
    this.Type = MT;
    this.IsAtBeginning = true;
    this.IsAtEnd = false;
    this.CurrentEntry = null;
    //END JInit
  }

  
  /*friend  class basic_collection_iterator<MappingNode, KeyValueNode>*/
  // JAVA: typedef basic_collection_iterator<MappingNode, KeyValueNode> iterator
//  public final class iterator extends basic_collection_iterator<MappingNode, KeyValueNode>{ };
  /*friend template <class T> typename T::iterator begin(T &)*/
  /*friend template <class T> void skip(T &)*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 407,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 408,
   FQN="llvm::yaml::MappingNode::begin", NM="_ZN4llvm4yaml11MappingNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode5beginEv")
  //</editor-fold>
  public basic_collection_iterator<MappingNode, KeyValueNode> begin() {
    return (basic_collection_iterator<MappingNode, KeyValueNode>)YamlGlobals.begin(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 409,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 410,
   FQN="llvm::yaml::MappingNode::end", NM="_ZN4llvm4yaml11MappingNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode3endEv")
  //</editor-fold>
  public basic_collection_iterator<MappingNode, KeyValueNode> end() {
    return new basic_collection_iterator<MappingNode, KeyValueNode>();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::skip">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 411,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 412,
   FQN="llvm::yaml::MappingNode::skip", NM="_ZN4llvm4yaml11MappingNode4skipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode4skipEv")
  //</editor-fold>
  @Override public void skip()/* override*/ {
    YamlGlobals.skip(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 413,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 414,
   FQN="llvm::yaml::MappingNode::classof", NM="_ZN4llvm4yaml11MappingNode7classofEPKNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode7classofEPKNS0_4NodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Node /*P*/ N) {
    return N.getType() == NodeKind.NK_Mapping.getValue();
  }

/*private:*/
  private MappingType Type;
  private boolean IsAtBeginning;
  private boolean IsAtEnd;
  private KeyValueNode /*P*/ CurrentEntry;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingNode::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2120,
   FQN="llvm::yaml::MappingNode::increment", NM="_ZN4llvm4yaml11MappingNode9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml11MappingNode9incrementEv")
  //</editor-fold>
  public void increment() {
    Token T = null;
    try {
      if (failed()) {
        IsAtEnd = true;
        CurrentEntry = null;
        return;
      }
      if ((CurrentEntry != null)) {
        CurrentEntry.skip();
        if (Type == MappingType.MT_Inline) {
          IsAtEnd = true;
          CurrentEntry = null;
          return;
        }
      }
      T = new Token(peekNext());
      if (T.Kind == Token.TokenKind.TK_Key || T.Kind == Token.TokenKind.TK_Scalar) {
        // KeyValueNode eats the TK_Key. That way it can detect null keys.
        CurrentEntry = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
            return new KeyValueNode(Doc);
         });
      } else if (Type == MappingType.MT_Block) {
        switch (T.Kind) {
         case TK_BlockEnd:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(getNext()));
              IsAtEnd = true;
              CurrentEntry = null;
              break;
            } finally {
              $c$.$destroy();
            }
          }
         default:
          setError(new Twine(/*KEEP_STR*/"Unexpected token. Expected Key or Block End"), T);
         case TK_Error:
          IsAtEnd = true;
          CurrentEntry = null;
        }
      } else {
        switch (T.Kind) {
         case TK_FlowEntry:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Eat the flow entry and recurse.
              $c$.clean($c$.track(getNext()));
              increment();
              /*JAVA:return*/return;
            } finally {
              $c$.$destroy();
            }
          }
         case TK_FlowMappingEnd:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(getNext()));
            } finally {
              $c$.$destroy();
            }
          }
         case TK_Error:
          // Set this to end iterator.
          IsAtEnd = true;
          CurrentEntry = null;
          break;
         default:
          setError(new Twine(/*KEEP_STR*/"Unexpected token. Expected Key, Flow Entry, or Flow Mapping End."), 
              T);
          IsAtEnd = true;
          CurrentEntry = null;
        }
      }
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<KeyValueNode> iterator() {
    return new JavaIterator<>(begin(), end());
  }

  @Override
  public boolean isAtBeginning() {
    return IsAtBeginning;
  }

  @Override
  public void setAtBeginning(boolean v) {
    IsAtBeginning = v;
  }

  @Override
  public boolean isAtEnd() {
    return IsAtEnd;
  }


  @Override
  public void setAtEnd(boolean v) {
    IsAtEnd = v;
  }

  @Override
  public KeyValueNode getCurrentEntry() {
    return CurrentEntry;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" 
              //+ "Type=" + Type // NOI18N
              + ", IsAtBeginning=" + IsAtBeginning // NOI18N
              + ", IsAtEnd=" + IsAtEnd // NOI18N
              //+ ", CurrentEntry=" + CurrentEntry // NOI18N
              + super.toString(); // NOI18N
  }
}
