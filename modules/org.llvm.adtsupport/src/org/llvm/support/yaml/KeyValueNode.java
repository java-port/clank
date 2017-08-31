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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.support.yaml.impl.Token;


/// \brief A key and value pair. While not technically a Node under the YAML
///        representation graph, it is easier to treat them this way.
///
/// TODO: Consider making this not a child of Node.
///
/// Example:
///   Section: .text
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 263,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 264,
 FQN="llvm::yaml::KeyValueNode", NM="_ZN4llvm4yaml12KeyValueNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNodeE")
//</editor-fold>
public final class KeyValueNode extends /*public*/ Node {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 105,
   FQN="llvm::yaml::KeyValueNode::anchor", NM="_ZN4llvm4yaml12KeyValueNode6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNode6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode::KeyValueNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 268,
   FQN="llvm::yaml::KeyValueNode::KeyValueNode", NM="_ZN4llvm4yaml12KeyValueNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EE")
  //</editor-fold>
  public KeyValueNode(final std.unique_ptr<Document> /*&*/ D) {
    // : Node(NK_KeyValue, D, StringRef(), StringRef()), Key(null), Value(null) 
    //START JInit
    /*ExprWithCleanups*/super(NodeKind.NK_KeyValue.getValue(), D, new StringRef(), new StringRef());
    this.Key = null;
    this.Value = null;
    //END JInit
  }

  
  /// \brief Parse and return the key.
  ///
  /// This may be called multiple times.
  ///
  /// \returns The key, or nullptr if failed() == true.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode::getKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2060,
   FQN="llvm::yaml::KeyValueNode::getKey", NM="_ZN4llvm4yaml12KeyValueNode6getKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNode6getKeyEv")
  //</editor-fold>
  public Node /*P*/ getKey() {
    if ((Key != null)) {
      return Key;
    }
    {
      final Token /*&*/ t = peekNext();
      if (t.Kind == Token.TokenKind.TK_BlockEnd
         || t.Kind == Token.TokenKind.TK_Value
         || t.Kind == Token.TokenKind.TK_Error) {
        return Key = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
            return new NullNode(Doc);
         });
      }
      if (t.Kind == Token.TokenKind.TK_Key) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(getNext())); // skip TK_Key.
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Handle explicit null keys.
    final Token /*&*/ t = peekNext();
    if (t.Kind == Token.TokenKind.TK_BlockEnd || t.Kind == Token.TokenKind.TK_Value) {
      return Key = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
          return new NullNode(Doc);
       });
    }
    
    // We've got a normal key.
    return Key = parseBlockNode();
  }

  
  /// \brief Parse and return the value.
  ///
  /// This may be called multiple times.
  ///
  /// \returns The value, or nullptr if failed() == true.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 2085,
   FQN="llvm::yaml::KeyValueNode::getValue", NM="_ZN4llvm4yaml12KeyValueNode8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNode8getValueEv")
  //</editor-fold>
  public Node /*P*/ getValue() {
    if ((Value != null)) {
      return Value;
    }
    getKey().skip();
    if (failed()) {
      return Value = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
          return new NullNode(Doc);
       });
    }
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        final Token /*&*/ t = peekNext();
        if (t.Kind == Token.TokenKind.TK_BlockEnd
           || t.Kind == Token.TokenKind.TK_FlowMappingEnd
           || t.Kind == Token.TokenKind.TK_Key
           || t.Kind == Token.TokenKind.TK_FlowEntry
           || t.Kind == Token.TokenKind.TK_Error) {
          return Value = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
              return new NullNode(Doc);
           });
        }
        if (t.Kind != Token.TokenKind.TK_Value) {
          setError(new Twine(/*KEEP_STR*/"Unexpected token in Key Value."), t);
          return Value = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
              return new NullNode(Doc);
           });
        }
        $c$.clean($c$.track(getNext())); // skip TK_Value.
      } finally {
        $c$.$destroy();
      }
    }
    
    // Handle explicit null values.
    final Token /*&*/ t = peekNext();
    if (t.Kind == Token.TokenKind.TK_BlockEnd || t.Kind == Token.TokenKind.TK_Key) {
      return Value = /*NEW_EXPR [Node::new]*//*new (getAllocator())*/ Node.$new(getAllocator(), (type$ptr<?> New$Mem)->{
          return new NullNode(Doc);
       });
    }
    
    // We got a normal value.
    return Value = parseBlockNode();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode::skip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 285,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 286,
   FQN="llvm::yaml::KeyValueNode::skip", NM="_ZN4llvm4yaml12KeyValueNode4skipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNode4skipEv")
  //</editor-fold>
  @Override public void skip()/* override*/ {
    getKey().skip();
    {
      Node /*P*/ Val = getValue();
      if ((Val != null)) {
        Val.skip();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::KeyValueNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 291,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 292,
   FQN="llvm::yaml::KeyValueNode::classof", NM="_ZN4llvm4yaml12KeyValueNode7classofEPKNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml12KeyValueNode7classofEPKNS0_4NodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Node /*P*/ N) {
    return N.getType() == NodeKind.NK_KeyValue.getValue();
  }

/*private:*/
  private Node /*P*/ Key;
  private Node /*P*/ Value;
  
  @Override public String toString() {
    return "" + "Key=" + Key // NOI18N
              + ", Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
