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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clank.support.NativeMemory.Allocator;
import org.llvm.support.yaml.impl.Token;


/// \brief Abstract base class for all Nodes.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 102,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 103,
 FQN="llvm::yaml::Node", NM="_ZN4llvm4yaml4NodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4NodeE")
//</editor-fold>
public class Node implements Destructors.ClassWithDestructor {
  /// Pin the vtables to this file.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 101,
   FQN="llvm::yaml::Node::anchor", NM="_ZN4llvm4yaml4Node6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::NodeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 107,
   FQN="llvm::yaml::Node::NodeKind", NM="_ZN4llvm4yaml4Node8NodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node8NodeKindE")
  //</editor-fold>
  public enum NodeKind implements Native.NativeUIntEnum {
    NK_Null(0),
    NK_Scalar(NK_Null.getValue() + 1),
    NK_BlockScalar(NK_Scalar.getValue() + 1),
    NK_KeyValue(NK_BlockScalar.getValue() + 1),
    NK_Mapping(NK_KeyValue.getValue() + 1),
    NK_Sequence(NK_Mapping.getValue() + 1),
    NK_Alias(NK_Sequence.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NodeKind valueOf(int val) {
      NodeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NodeKind[] VALUES;
      private static final NodeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NodeKind kind : NodeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NodeKind[min < 0 ? (1-min) : 0];
        VALUES = new NodeKind[max >= 0 ? (1+max) : 0];
        for (NodeKind kind : NodeKind.values()) {
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
    private NodeKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::Node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1806,
   FQN="llvm::yaml::Node::Node", NM="_ZN4llvm4yaml4NodeC1EjRSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4NodeC1EjRSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_")
  //</editor-fold>
  public Node(/*uint*/int Type, final std.unique_ptr<Document> /*&*/ D, StringRef A, 
      StringRef T) {
    // : Doc(D), SourceRange(), TypeID(Type), Anchor(A), Tag(T) 
    //START JInit
    this./*&*/Doc=/*&*/D;
    this.SourceRange = new SMRange();
    this.TypeID = Type;
    this.Anchor = new StringRef(A);
    this.Tag = new StringRef(T);
    //END JInit
    SMLoc Start = SMLoc.getFromPointer(peekNext().Range.begin());
    SourceRange.$assignMove(new SMRange(new SMLoc(Start), new SMLoc(Start)));
  }

  
  /// \brief Get the value of the anchor attached to this node. If it does not
  ///        have one, getAnchor().size() will be 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getAnchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 122,
   FQN="llvm::yaml::Node::getAnchor", NM="_ZNK4llvm4yaml4Node9getAnchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node9getAnchorEv")
  //</editor-fold>
  public StringRef getAnchor() /*const*/ {
    return new StringRef(Anchor);
  }

  
  /// \brief Get the tag as it was written in the document. This does not
  ///   perform tag resolution.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getRawTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 125,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 126,
   FQN="llvm::yaml::Node::getRawTag", NM="_ZNK4llvm4yaml4Node9getRawTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node9getRawTagEv")
  //</editor-fold>
  public StringRef getRawTag() /*const*/ {
    return new StringRef(Tag);
  }

  
  /// \brief Get the verbatium tag for a given Node. This performs tag resoluton
  ///   and substitution.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getVerbatimTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1813,
   FQN="llvm::yaml::Node::getVerbatimTag", NM="_ZNK4llvm4yaml4Node14getVerbatimTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node14getVerbatimTagEv")
  //</editor-fold>
  public std.string getVerbatimTag() /*const*/ {
    StringRef Raw = getRawTag();
    if (!Raw.empty() && $noteq_StringRef(/*NO_COPY*/Raw, /*STRINGREF_STR*/"!")) {
      std.string Ret/*J*/= new std.string();
      if (Raw.find_last_of($$EXCLAMATION) == 0) {
        Ret.$assignMove(Doc.$arrow().getTagMap().find$Const(/*STRINGREF_STR*/new StringRef("!")).$arrow().second.$string());
        $addassign_string_StringRef(Ret, Raw.substr(1));
        return Ret;
      } else if (Raw.startswith(/*STRINGREF_STR*/"!!")) {
        Ret.$assignMove(Doc.$arrow().getTagMap().find$Const(/*STRINGREF_STR*/new StringRef("!!")).$arrow().second.$string());
        $addassign_string_StringRef(Ret, Raw.substr(2));
        return Ret;
      } else {
        StringRef TagHandle = Raw.substr(0, Raw.find_last_of($$EXCLAMATION) + 1);
        std.mapTypeType.iterator</*const*/ StringRef, StringRef> It = Doc.$arrow().getTagMap().find$Const(TagHandle);
        if (It.$noteq(Doc.$arrow().getTagMap().end$Const())) {
          Ret.$assignMove(It.$arrow().second.$string());
        } else {
          Token T = null;
          try {
            T/*J*/= new Token();
            T.Kind = Token.TokenKind.TK_Tag;
            T.Range.$assign(TagHandle);
            setError($add_Twine$C(new Twine(/*KEEP_STR*/"Unknown tag handle "), new Twine(TagHandle)), T);
          } finally {
            if (T != null) { T.$destroy(); }
          }
        }
        $addassign_string_StringRef(Ret, Raw.substr(Raw.find_last_of($$EXCLAMATION) + 1));
        return Ret;
      }
    }
    switch (Node.NodeKind.valueOf(getType())) {
     case NK_Null:
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"tag:yaml.org,2002:null");
     case NK_Scalar:
     case NK_BlockScalar:
      // TODO: Tag resolution.
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"tag:yaml.org,2002:str");
     case NK_Mapping:
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"tag:yaml.org,2002:map");
     case NK_Sequence:
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"tag:yaml.org,2002:seq");
    }
    
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 131,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 132,
   FQN="llvm::yaml::Node::getSourceRange", NM="_ZNK4llvm4yaml4Node14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node14getSourceRangeEv")
  //</editor-fold>
  public SMRange getSourceRange() /*const*/ {
    return new SMRange(SourceRange);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::setSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 133,
   FQN="llvm::yaml::Node::setSourceRange", NM="_ZN4llvm4yaml4Node14setSourceRangeENS_7SMRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node14setSourceRangeENS_7SMRangeE")
  //</editor-fold>
  public void setSourceRange(SMRange SR) {
    SourceRange.$assign(SR);
  }

  
  // These functions forward to Document and Scanner.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::peekNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1858,
   FQN="llvm::yaml::Node::peekNext", NM="_ZN4llvm4yaml4Node8peekNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node8peekNextEv")
  //</editor-fold>
  public Token /*&*/ peekNext() {
    return Doc.$arrow().peekNext();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1862,
   FQN="llvm::yaml::Node::getNext", NM="_ZN4llvm4yaml4Node7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node7getNextEv")
  //</editor-fold>
  public Token getNext() {
    return Doc.$arrow().getNext();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::parseBlockNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1866,
   FQN="llvm::yaml::Node::parseBlockNode", NM="_ZN4llvm4yaml4Node14parseBlockNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node14parseBlockNodeEv")
  //</editor-fold>
  public Node /*P*/ parseBlockNode() {
    return Doc.$arrow().parseBlockNode();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1870,
   FQN="llvm::yaml::Node::getAllocator", NM="_ZN4llvm4yaml4Node12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ getAllocator() {
    return Doc.$arrow().NodeAllocator;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1874,
   FQN="llvm::yaml::Node::setError", NM="_ZNK4llvm4yaml4Node8setErrorERKNS_5TwineERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node8setErrorERKNS_5TwineERNS0_5TokenE")
  //</editor-fold>
  public void setError(final /*const*/ Twine /*&*/ Msg, final Token /*&*/ Tok) /*const*/ {
    Doc.$arrow().setError(Msg, Tok);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1878,
   FQN="llvm::yaml::Node::failed", NM="_ZNK4llvm4yaml4Node6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node6failedEv")
  //</editor-fold>
  public boolean failed() /*const*/ {
    return Doc.$arrow().failed();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::skip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 142,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 143,
   FQN="llvm::yaml::Node::skip", NM="_ZN4llvm4yaml4Node4skipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4Node4skipEv")
  //</editor-fold>
  public /*virtual*/ void skip() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 145,
   FQN="llvm::yaml::Node::getType", NM="_ZNK4llvm4yaml4Node7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml4Node7getTypeEv")
  //</editor-fold>
  public /*uint*/int getType() /*const*/ {
    return TypeID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 147,
   FQN="llvm::yaml::Node::operator new", NM="_ZN4llvm4yaml4NodenwEjRNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4NodenwEjRNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEEj")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int Size, final BumpPtrAllocatorImpl /*&*/ Alloc) {
    return $new(Size, Alloc, 
      16);
  }
  public static Object/*void P*/ $new(/*size_t*/int Size, final BumpPtrAllocatorImpl /*&*/ Alloc, 
      /*size_t*/int Alignment/*= 16*/) {
    return Alloc.Allocate(Size, Alignment);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 152,
   FQN="llvm::yaml::Node::operator delete", NM="_ZN4llvm4yaml4NodedlEPvRNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4NodedlEPvRNS_20BumpPtrAllocatorImplINS_15MallocAllocatorELj4096ELj4096EEEj")
  //</editor-fold>
  public static void $delete(Object/*void P*/ Ptr, final BumpPtrAllocatorImpl /*&*/ Alloc, 
         /*size_t*/int Size) {
    Alloc.Deallocate(Ptr, Size);
  }

/*protected:*/
  protected final std.unique_ptr<Document> /*&*/ Doc;
  protected SMRange SourceRange;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 161,
   FQN="llvm::yaml::Node::operator delete", NM="_ZN4llvm4yaml4NodedlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4NodedlEPv")
  //</editor-fold>
  protected static void $delete(Object/*void P*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Node::~Node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 163,
   FQN="llvm::yaml::Node::~Node", NM="_ZN4llvm4yaml4NodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml4NodeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


/*private:*/
  private /*uint*/int TypeID;
  private StringRef Anchor;
  /// \brief The tag as typed in the document.
  private StringRef Tag;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static <T extends Node> T/*P*/ $new(final /*const*/ Allocator /*&*/ A, NativeCallback.New$ConstructorCallback<T/*P*/> New$StmtCtr) {
    // FIXME
    return New$StmtCtr.$call(null);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Doc=" + Doc // NOI18N
              + ", SourceRange=" + SourceRange // NOI18N
              + ", TypeID=" + TypeID // NOI18N
              + ", Anchor=" + Anchor // NOI18N
              + ", Tag=" + Tag; // NOI18N
  }
}
