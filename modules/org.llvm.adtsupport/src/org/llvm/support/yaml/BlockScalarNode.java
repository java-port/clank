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
import org.llvm.support.*;
import org.llvm.adt.*;


/// \brief A block scalar node is an opaque datum that can be presented as a
///        series of zero or more Unicode scalar values.
///
/// Example:
///   |
///     Hello
///     World
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::BlockScalarNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 233,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 234,
 FQN="llvm::yaml::BlockScalarNode", NM="_ZN4llvm4yaml15BlockScalarNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml15BlockScalarNodeE")
//</editor-fold>
public final class BlockScalarNode extends /*public*/ Node {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BlockScalarNode::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 104,
   FQN="llvm::yaml::BlockScalarNode::anchor", NM="_ZN4llvm4yaml15BlockScalarNode6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml15BlockScalarNode6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BlockScalarNode::BlockScalarNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 237,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 238,
   FQN="llvm::yaml::BlockScalarNode::BlockScalarNode", NM="_ZN4llvm4yaml15BlockScalarNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_S8_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml15BlockScalarNodeC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EENS_9StringRefES8_S8_S8_")
  //</editor-fold>
  public BlockScalarNode(final std.unique_ptr<Document> /*&*/ D, StringRef Anchor, StringRef Tag, 
      StringRef Value, StringRef RawVal) {
    // : Node(NK_BlockScalar, D, Anchor, Tag), Value(Value) 
    //START JInit
    super(NodeKind.NK_BlockScalar.getValue(), D, new StringRef(Anchor), new StringRef(Tag));
    this.Value = new StringRef(Value);
    //END JInit
    SMLoc Start = SMLoc.getFromPointer(RawVal.begin());
    SMLoc End = SMLoc.getFromPointer(RawVal.end());
    SourceRange.$assignMove(new SMRange(new SMLoc(Start), new SMLoc(End)));
  }

  
  /// \brief Gets the value of this node as a StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BlockScalarNode::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 247,
   FQN="llvm::yaml::BlockScalarNode::getValue", NM="_ZNK4llvm4yaml15BlockScalarNode8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml15BlockScalarNode8getValueEv")
  //</editor-fold>
  public StringRef getValue() /*const*/ {
    return new StringRef(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BlockScalarNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 248,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 249,
   FQN="llvm::yaml::BlockScalarNode::classof", NM="_ZN4llvm4yaml15BlockScalarNode7classofEPKNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml15BlockScalarNode7classofEPKNS0_4NodeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Node /*P*/ N) {
    return N.getType() == NodeKind.NK_BlockScalar.getValue();
  }

/*private:*/
  private StringRef Value;
  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
