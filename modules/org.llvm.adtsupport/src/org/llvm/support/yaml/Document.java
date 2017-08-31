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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.yaml.impl.Token;


/// \brief A YAML Stream is a sequence of Documents. A document contains a root
///        node.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 505,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 506,
 FQN="llvm::yaml::Document", NM="_ZN4llvm4yaml8DocumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8DocumentE")
//</editor-fold>
public class Document implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Root for parsing a node. Returns a single node.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::parseBlockNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2304,
   FQN="llvm::yaml::Document::parseBlockNode", NM="_ZN4llvm4yaml8Document14parseBlockNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document14parseBlockNodeEv")
  //</editor-fold>
  public Node /*P*/ parseBlockNode() {
    Token T = null;
    Token AnchorInfo = null;
    Token TagInfo = null;
    try {
      T = new Token(peekNext());
      // Handle properties.
      AnchorInfo/*J*/= new Token();
      TagInfo/*J*/= new Token();
     parse_property:
     while(true) {
      switch (T.Kind) {
       case TK_Alias:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            final Token L$T = T;
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new AliasNode(stream.CurrentDoc, L$T.Range.substr(1));
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_Anchor:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (AnchorInfo.Kind == Token.TokenKind.TK_Anchor) {
              setError(new Twine(/*KEEP_STR*/"Already encountered an anchor for this node!"), T);
              return null;
            }
            $c$.clean(AnchorInfo.$assignMove($c$.track(getNext()))); // Consume TK_Anchor.
            T.$assign(peekNext());
            continue parse_property;
          } finally {
            $c$.$destroy();
          }
        }
       case TK_Tag:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (TagInfo.Kind == Token.TokenKind.TK_Tag) {
              setError(new Twine(/*KEEP_STR*/"Already encountered a tag for this node!"), T);
              return null;
            }
            $c$.clean(TagInfo.$assignMove($c$.track(getNext()))); // Consume TK_Tag.
            T.$assign(peekNext());
            continue parse_property;
          } finally {
            $c$.$destroy();
          }
        }
       default:
        break;
      }
      Token $AnchorInfo = AnchorInfo;
      Token $TagInfo = TagInfo;
      Token $T = T;
      switch (T.Kind) {
       case TK_BlockEntry:
        // We got an unindented BlockEntry sequence. This is not terminated with
        // a BlockEnd.
        // Don't eat the TK_BlockEntry, SequenceNode needs it.
        return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
            return new SequenceNode(stream.CurrentDoc, 
                    $AnchorInfo.Range.substr(1), 
                    new StringRef($TagInfo.Range), 
                    SequenceNode.SequenceType.ST_Indentless);
         });
       case TK_BlockSequenceStart:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new SequenceNode(stream.CurrentDoc, 
                        $AnchorInfo.Range.substr(1), 
                        new StringRef($TagInfo.Range), 
                        SequenceNode.SequenceType.ST_Block);
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_BlockMappingStart:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new MappingNode(stream.CurrentDoc, 
                        $AnchorInfo.Range.substr(1), 
                        new StringRef($TagInfo.Range), 
                        MappingNode.MappingType.MT_Block);
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_FlowSequenceStart:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new SequenceNode(stream.CurrentDoc, 
                        $AnchorInfo.Range.substr(1), 
                        new StringRef($TagInfo.Range), 
                        SequenceNode.SequenceType.ST_Flow);
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_FlowMappingStart:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new MappingNode(stream.CurrentDoc, 
                        $AnchorInfo.Range.substr(1), 
                        new StringRef($TagInfo.Range), 
                        MappingNode.MappingType.MT_Flow);
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_Scalar:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new ScalarNode(stream.CurrentDoc, 
                        $AnchorInfo.Range.substr(1), 
                        new StringRef($TagInfo.Range), 
                        new StringRef($T.Range));
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_BlockScalar:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(getNext()));
            StringRef NullTerminatedStr/*J*/= new StringRef(T.Value.c_str(), T.Value.length() + 1);
            StringRef StrCopy = NullTerminatedStr.copy(NodeAllocator).drop_back();
            return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
                return new BlockScalarNode(stream.CurrentDoc, $AnchorInfo.Range.substr(1), 
                        new StringRef($TagInfo.Range), new StringRef(StrCopy), new StringRef($T.Range));
             });
          } finally {
            $c$.$destroy();
          }
        }
       case TK_Key:
        // Don't eat the TK_Key, KeyValueNode expects it.
        return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
            return new MappingNode(stream.CurrentDoc, 
                    $AnchorInfo.Range.substr(1), 
                    new StringRef($TagInfo.Range), 
                    MappingNode.MappingType.MT_Inline);
         });
       case TK_DocumentStart:
       case TK_DocumentEnd:
       case TK_StreamEnd:
       default:
        // TODO: Properly handle tags. "[!!str ]" should resolve to !!str "", not
        //       !!null null.
        return /*NEW_EXPR [Node::new]*//*new (NodeAllocator)*/ Node.$new(NodeAllocator, (type$ptr<?> New$Mem)->{
            return new NullNode(stream.CurrentDoc);
         });
       case TK_Error:
        return null;
      }
     }
      //throw new llvm_unreachable("Control flow shouldn't reach here.");
//      return null;
    } finally {
      if (TagInfo != null) { TagInfo.$destroy(); }
      if (AnchorInfo != null) { AnchorInfo.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::Document">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2260,
   FQN="llvm::yaml::Document::Document", NM="_ZN4llvm4yaml8DocumentC1ERNS0_6StreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8DocumentC1ERNS0_6StreamE")
  //</editor-fold>
  public Document(final Stream /*&*/ S) {
    // : stream(S), NodeAllocator(), Root(null), TagMap() 
    //START JInit
    this./*&*/stream=/*&*/S;
    this.NodeAllocator = new BumpPtrAllocatorImpl();
    this.Root = null;
    this.TagMap = new std.mapTypeType<StringRef, StringRef>(StringRef.COMPARATOR, new StringRef());
    //END JInit
    // Tag maps starts with two default mappings.
    TagMap.$at_T$RR(/*STRINGREF_STR*/new StringRef("!")).$assignMove(/*STRINGREF_STR*/$EXCLAIM);
    TagMap.$at_T$RR(/*STRINGREF_STR*/new StringRef("!!")).$assignMove(/*STRINGREF_STR*/"tag:yaml.org,2002:");
    if (parseDirectives()) {
      expectToken(Token.TokenKind.TK_DocumentStart.getValue());
    }
    final Token /*&*/ T = peekNext();
    if (T.Kind == Token.TokenKind.TK_DocumentStart) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(getNext()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// \brief Finish parsing the current document and return true if there are
  ///        more. Return false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::skip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2272,
   FQN="llvm::yaml::Document::skip", NM="_ZN4llvm4yaml8Document4skipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document4skipEv")
  //</editor-fold>
  public boolean skip() {
    if (stream.scanner.$arrow().failed()) {
      return false;
    }
    if (!(Root != null)) {
      getRoot();
    }
    Root.skip();
    final Token /*&*/ T = peekNext();
    if (T.Kind == Token.TokenKind.TK_StreamEnd) {
      return false;
    }
    if (T.Kind == Token.TokenKind.TK_DocumentEnd) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(getNext()));
        return skip();
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }

  
  /// \brief Parse and return the root level node.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::getRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 517,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 518,
   FQN="llvm::yaml::Document::getRoot", NM="_ZN4llvm4yaml8Document7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document7getRootEv")
  //</editor-fold>
  public Node /*P*/ getRoot() {
    if ((Root != null)) {
      return Root;
    }
    return Root = parseBlockNode();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::getTagMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 523,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 524,
   FQN="llvm::yaml::Document::getTagMap", NM="_ZNK4llvm4yaml8Document9getTagMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml8Document9getTagMapEv")
  //</editor-fold>
  public /*const*/std.mapTypeType<StringRef, StringRef> /*&*/ getTagMap() /*const*/ {
    return TagMap;
  }

/*private:*/
  /*friend  class Node*/
  /*friend  class document_iterator*/
  
  /// \brief Stream to read tokens from.
  /*friend*/public/*private*/ final Stream /*&*/ stream;
  
  /// \brief Used to allocate nodes to. All are destroyed without calling their
  ///        destructor when the document is destroyed.
  /*friend*/public/*private*/ BumpPtrAllocatorImpl NodeAllocator;
  
  /// \brief The root node. Used to support skipping a partially parsed
  ///        document.
  private Node /*P*/ Root;
  
  /// \brief Maps tag prefixes to their expansion.
  private std.mapTypeType<StringRef, StringRef> TagMap;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::peekNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2288,
   FQN="llvm::yaml::Document::peekNext", NM="_ZN4llvm4yaml8Document8peekNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document8peekNextEv")
  //</editor-fold>
  /*friend*/public/*private*/ Token /*&*/ peekNext() {
    return stream.scanner.$arrow().peekNext();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2292,
   FQN="llvm::yaml::Document::getNext", NM="_ZN4llvm4yaml8Document7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document7getNextEv")
  //</editor-fold>
  /*friend*/public/*private*/ Token getNext() {
    return stream.scanner.$arrow().getNext();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2296,
   FQN="llvm::yaml::Document::setError", NM="_ZNK4llvm4yaml8Document8setErrorERKNS_5TwineERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml8Document8setErrorERKNS_5TwineERNS0_5TokenE")
  //</editor-fold>
  /*friend*/public/*private*/ void setError(final /*const*/ Twine /*&*/ Message, final Token /*&*/ Location) /*const*/ {
    stream.scanner.$arrow().setError(Message, Location.Range.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2300,
   FQN="llvm::yaml::Document::failed", NM="_ZNK4llvm4yaml8Document6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml8Document6failedEv")
  //</editor-fold>
  /*friend*/public/*private*/ boolean failed() /*const*/ {
    return stream.scanner.$arrow().failed();
  }

  
  /// \brief Parse %BLAH directives and return true if any were encountered.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::parseDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2407,
   FQN="llvm::yaml::Document::parseDirectives", NM="_ZN4llvm4yaml8Document15parseDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document15parseDirectivesEv")
  //</editor-fold>
  private boolean parseDirectives() {
    boolean isDirective = false;
    while (true) {
      Token T = null;
      try {
        T = new Token(peekNext());
        if (T.Kind == Token.TokenKind.TK_TagDirective) {
          parseTAGDirective();
          isDirective = true;
        } else if (T.Kind == Token.TokenKind.TK_VersionDirective) {
          parseYAMLDirective();
          isDirective = true;
        } else {
          break;
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    return isDirective;
  }

  
  /// \brief Parse %YAML
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::parseYAMLDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2423,
   FQN="llvm::yaml::Document::parseYAMLDirective", NM="_ZN4llvm4yaml8Document18parseYAMLDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document18parseYAMLDirectiveEv")
  //</editor-fold>
  private void parseYAMLDirective() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(getNext())); // Eat %YAML <version>
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Parse %TAG
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::parseTAGDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2427,
   FQN="llvm::yaml::Document::parseTAGDirective", NM="_ZN4llvm4yaml8Document17parseTAGDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document17parseTAGDirectiveEv")
  //</editor-fold>
  private void parseTAGDirective() {
    Token Tag = null;
    try {
      Tag = getNext(); // %TAG <handle> <prefix>
      StringRef T = new StringRef(Tag.Range);
      // Strip %TAG
      T.$assignMove(T.substr(T.find_first_of(/*STRINGREF_STR*/" \t")).ltrim(/*STRINGREF_STR*/new StringRef(" \t")));
      /*uint*/int HandleEnd = T.find_first_of(/*STRINGREF_STR*/" \t");
      StringRef TagHandle = T.substr(0, HandleEnd);
      StringRef TagPrefix = T.substr(HandleEnd).ltrim(/*STRINGREF_STR*/new StringRef(" \t"));
      TagMap.$at_T$C$R(TagHandle).$assign(TagPrefix);
    } finally {
      if (Tag != null) { Tag.$destroy(); }
    }
  }

  
  /// \brief Consume the next token and error if it is not \a TK.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::expectToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2438,
   FQN="llvm::yaml::Document::expectToken", NM="_ZN4llvm4yaml8Document11expectTokenEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8Document11expectTokenEi")
  //</editor-fold>
  private boolean expectToken(int TK) {
    Token T = null;
    try {
      T = getNext();
      if (T.Kind.getValue() != TK) {
        setError(new Twine(/*KEEP_STR*/"Unexpected token"), T);
        return false;
      }
      return true;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Document::~Document">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 505,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 506,
   FQN="llvm::yaml::Document::~Document", NM="_ZN4llvm4yaml8DocumentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml8DocumentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TagMap.$destroy();
    NodeAllocator.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" 
              //+ "stream=" + stream // NOI18N
              + ", NodeAllocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              //+ ", Root=" + Root // NOI18N
              + ", TagMap=" + TagMap; // NOI18N
  }
}
