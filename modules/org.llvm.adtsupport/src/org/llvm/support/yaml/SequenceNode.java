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
import static org.clank.support.Native.*;
import org.clank.support.aliases.JavaIterator;
import org.llvm.adt.*;
import org.llvm.support.yaml.impl.Token;


/// \brief Represents a YAML sequence created from either a block sequence for a
///        flow sequence.
///
/// This parses the YAML stream as increment() is called.
///
/// Example:
///   - Hello
///   - World
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 434,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 435,
 FQN="llvm::yaml::SequenceNode", NM="_ZN4llvm4yaml12SequenceNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNodeE")
//</editor-fold>
public final class SequenceNode extends /*public*/ Node implements Iterable<Node>, org.llvm.support.java.MappingSequenceInterface {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 107,
   FQN="llvm::yaml::SequenceNode::anchor", NM="_ZN4llvm4yaml12SequenceNode6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::SequenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 438,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 439,
   FQN="llvm::yaml::SequenceNode::SequenceType", NM="_ZN4llvm4yaml12SequenceNode12SequenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode12SequenceTypeE")
  //</editor-fold>
  public enum SequenceType implements Native.NativeUIntEnum {
    ST_Block(0),
    ST_Flow(ST_Block.getValue() + 1),
    // Use for:
    //
    // key:
    // - val1
    // - val2
    //
    // As a BlockMappingEntry and BlockEnd are not created in this case.
    ST_Indentless(ST_Flow.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SequenceType valueOf(int val) {
      SequenceType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SequenceType[] VALUES;
      private static final SequenceType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SequenceType kind : SequenceType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SequenceType[min < 0 ? (1-min) : 0];
        VALUES = new SequenceType[max >= 0 ? (1+max) : 0];
        for (SequenceType kind : SequenceType.values()) {
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
    private SequenceType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::SequenceNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 451,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 452,
   FQN="llvm::yaml::SequenceNode::SequenceNode", NM="_ZN4llvm4yaml12SequenceNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_NS1_12SequenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_NS1_12SequenceTypeE")
  //</editor-fold>
  public SequenceNode(final std.unique_ptr<Document> /*&*/ D, StringRef Anchor, StringRef Tag, 
      SequenceType ST) {
    // : Node(NK_Sequence, D, Anchor, Tag), SeqType(ST), IsAtBeginning(true), IsAtEnd(false), WasPreviousTokenFlowEntry(true), CurrentEntry(null) 
    //START JInit
    super(NodeKind.NK_Sequence.getValue(), D, new StringRef(Anchor), new StringRef(Tag));
    this.SeqType = ST;
    this.IsAtBeginning = true;
    this.IsAtEnd = false;
    this.WasPreviousTokenFlowEntry = true;
    this.CurrentEntry = null;
    //END JInit
  }

  
  /*friend  class basic_collection_iterator<SequenceNode, Node>*/
  // JAVA: typedef basic_collection_iterator<SequenceNode, Node> iterator
//  public final class iterator extends basic_collection_iterator<SequenceNode, Node>{ };
  /*friend template <class T> typename T::iterator begin(T &)*/
  /*friend template <class T> void skip(T &)*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2174,
   FQN="llvm::yaml::SequenceNode::increment", NM="_ZN4llvm4yaml12SequenceNode9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode9incrementEv")
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
      }
      T = new Token(peekNext());
      if (SeqType == SequenceType.ST_Block) {
        switch (T.Kind) {
         case TK_BlockEntry:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(getNext()));
              CurrentEntry = parseBlockNode();
              if (!(CurrentEntry != null)) { // An error occurred.
                IsAtEnd = true;
                CurrentEntry = null;
              }
              break;
            } finally {
              $c$.$destroy();
            }
          }
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
          setError(new Twine(/*KEEP_STR*/"Unexpected token. Expected Block Entry or Block End."), 
              T);
         case TK_Error:
          IsAtEnd = true;
          CurrentEntry = null;
        }
      } else if (SeqType == SequenceType.ST_Indentless) {
        switch (T.Kind) {
         case TK_BlockEntry:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(getNext()));
              CurrentEntry = parseBlockNode();
              if (!(CurrentEntry != null)) { // An error occurred.
                IsAtEnd = true;
                CurrentEntry = null;
              }
              break;
            } finally {
              $c$.$destroy();
            }
          }
         default:
         case TK_Error:
          IsAtEnd = true;
          CurrentEntry = null;
        }
      } else if (SeqType == SequenceType.ST_Flow) {
        switch (T.Kind) {
         case TK_FlowEntry:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Eat the flow entry and recurse.
              $c$.clean($c$.track(getNext()));
              WasPreviousTokenFlowEntry = true;
              increment();
              /*JAVA:return*/return;
            } finally {
              $c$.$destroy();
            }
          }
         case TK_FlowSequenceEnd:
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
         case TK_StreamEnd:
         case TK_DocumentEnd:
         case TK_DocumentStart:
          setError(new Twine(/*KEEP_STR*/"Could not find closing ]!"), T);
          // Set this to end iterator.
          IsAtEnd = true;
          CurrentEntry = null;
          break;
         default:
          if (!WasPreviousTokenFlowEntry) {
            setError(new Twine(/*KEEP_STR*/"Expected , between entries!"), T);
            IsAtEnd = true;
            CurrentEntry = null;
            break;
          }
          // Otherwise it must be a flow entry.
          CurrentEntry = parseBlockNode();
          if (!(CurrentEntry != null)) {
            IsAtEnd = true;
          }
          WasPreviousTokenFlowEntry = false;
          break;
        }
      }
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 465,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 466,
   FQN="llvm::yaml::SequenceNode::begin", NM="_ZN4llvm4yaml12SequenceNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode5beginEv")
  //</editor-fold>
  public basic_collection_iterator<SequenceNode, Node> begin() {
    return (basic_collection_iterator<SequenceNode, Node>)YamlGlobals.begin(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 467,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 468,
   FQN="llvm::yaml::SequenceNode::end", NM="_ZN4llvm4yaml12SequenceNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode3endEv")
  //</editor-fold>
  public basic_collection_iterator<SequenceNode, Node> end() {
    return new basic_collection_iterator<SequenceNode, Node>();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::skip">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 469,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 470,
   FQN="llvm::yaml::SequenceNode::skip", NM="_ZN4llvm4yaml12SequenceNode4skipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode4skipEv")
  //</editor-fold>
  @Override public void skip()/* override*/ {
    YamlGlobals.skip(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::SequenceNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 471,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 472,
   FQN="llvm::yaml::SequenceNode::classof", NM="_ZN4llvm4yaml12SequenceNode7classofEPKNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12SequenceNode7classofEPKNS0_4NodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Node /*P*/ N) {
    return N.getType() == NodeKind.NK_Sequence.getValue();
  }

/*private:*/
  private SequenceType SeqType;
  private boolean IsAtBeginning;
  private boolean IsAtEnd;
  private boolean WasPreviousTokenFlowEntry;
  private Node /*P*/ CurrentEntry;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<Node> iterator() {
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
  public Node getCurrentEntry() {
    return CurrentEntry;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SeqType=" + SeqType // NOI18N
              + ", IsAtBeginning=" + IsAtBeginning // NOI18N
              + ", IsAtEnd=" + IsAtEnd // NOI18N
              + ", WasPreviousTokenFlowEntry=" + WasPreviousTokenFlowEntry // NOI18N
              + ", CurrentEntry=" + CurrentEntry // NOI18N
              + super.toString(); // NOI18N
  }
}
