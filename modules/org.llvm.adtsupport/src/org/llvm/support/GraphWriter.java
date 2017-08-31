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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;

/*template <typename GraphType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 55,
 FQN="llvm::GraphWriter", NM="_ZN4llvm11GraphWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriterE")
//</editor-fold>
public class GraphWriter</*typename*/ GraphType, NodeType, ChildIteratorType>  {
  private final raw_ostream /*&*/ O;
  private final /*const*/ GraphType /*&*/ G;
  
  // JAVA: typedef DOTGraphTraits<GraphType> DOTTraits
//  public final class DOTTraits extends DOTGraphTraits<GraphType>{ };
  // JAVA: typedef GraphTraits<GraphType> GTraits
//  public final class GTraits extends GraphTraits<GraphType>{ };
  // JAVA: typedef typename GTraits::NodeType NodeType
//  public final class NodeType extends  GraphTraits.NodeType<GraphType>{ };
  // JAVA: typedef typename GTraits::nodes_iterator node_iterator
//  public final class node_iterator extends  GraphTraits.nodes_iterator<GraphType>{ };
  // JAVA: typedef typename GTraits::ChildIteratorType child_iterator
//  public final class child_iterator extends  GraphTraits.ChildIteratorType<GraphType>{ };
  private DOTGraphTraits<GraphType> DTraits;
  
  // Writes the edge labels of the node to O and returns true if there are any
  // edge labels not equal to the empty string "".
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::getEdgeSourceLabels">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 69,
   FQN="llvm::GraphWriter::getEdgeSourceLabels", NM="_ZN4llvm11GraphWriter19getEdgeSourceLabelsERNS_11raw_ostreamEPNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter19getEdgeSourceLabelsERNS_11raw_ostreamEPNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  private boolean getEdgeSourceLabels(final raw_ostream /*&*/ O,  NodeType /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::GraphWriter<GraphType>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 95,
   FQN="llvm::GraphWriter::GraphWriter<GraphType>", NM="_ZN4llvm11GraphWriterC1ERNS_11raw_ostreamERKT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriterC1ERNS_11raw_ostreamERKT_b")
  //</editor-fold>
  public GraphWriter(final raw_ostream /*&*/ o, final /*const*/ GraphType /*&*/ g, boolean SN) {
    // : O(o), G(g) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 99,
   FQN="llvm::GraphWriter::writeGraph", NM="_ZN4llvm11GraphWriter10writeGraphERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter10writeGraphERKSs")
  //</editor-fold>
  public void writeGraph() {
    writeGraph(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY));
  }
  public void writeGraph(final /*const*/std.string/*&*/ Title/*= ""*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeHeader">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 113,
   FQN="llvm::GraphWriter::writeHeader", NM="_ZN4llvm11GraphWriter11writeHeaderERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter11writeHeaderERKSs")
  //</editor-fold>
  public void writeHeader(final /*const*/std.string/*&*/ Title) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeFooter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 134,
   FQN="llvm::GraphWriter::writeFooter", NM="_ZN4llvm11GraphWriter11writeFooterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter11writeFooterEv")
  //</editor-fold>
  public void writeFooter() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeNodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 139,
   FQN="llvm::GraphWriter::writeNodes", NM="_ZN4llvm11GraphWriter10writeNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter10writeNodesEv")
  //</editor-fold>
  public void writeNodes() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::isNodeHidden">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 147,
   FQN="llvm::GraphWriter::isNodeHidden", NM="_ZN4llvm11GraphWriter12isNodeHiddenERNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter12isNodeHiddenERNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  public boolean isNodeHidden_NodeType$GraphType(final  NodeType /*&*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::isNodeHidden">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 151,
   FQN="llvm::GraphWriter::isNodeHidden", NM="_ZN4llvm11GraphWriter12isNodeHiddenEPKPNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter12isNodeHiddenEPKPNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  public boolean isNodeHidden_NodeType$GraphType$P$C$P( NodeType /*P*/ /*const*/ /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::isNodeHidden">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 155,
   FQN="llvm::GraphWriter::isNodeHidden", NM="_ZN4llvm11GraphWriter12isNodeHiddenEPNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter12isNodeHiddenEPNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  public boolean isNodeHidden_NodeType$GraphType$P( NodeType /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 159,
   FQN="llvm::GraphWriter::writeNode", NM="_ZN4llvm11GraphWriter9writeNodeERNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter9writeNodeERNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  public void writeNode_NodeType$GraphType(final  NodeType /*&*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 163,
   FQN="llvm::GraphWriter::writeNode", NM="_ZN4llvm11GraphWriter9writeNodeEPKPNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter9writeNodeEPKPNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  public void writeNode_NodeType$GraphType$P$C$P( NodeType /*P*/ /*const*/ /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 167,
   FQN="llvm::GraphWriter::writeNode", NM="_ZN4llvm11GraphWriter9writeNodeEPNS_11GraphTraitsIT_E8NodeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter9writeNodeEPNS_11GraphTraitsIT_E8NodeTypeE")
  //</editor-fold>
  public void writeNode_NodeType$GraphType$P( NodeType /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::writeEdge">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 240,
   FQN="llvm::GraphWriter::writeEdge", NM="_ZN4llvm11GraphWriter9writeEdgeEPNS_11GraphTraitsIT_E8NodeTypeEjNS3_17ChildIteratorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter9writeEdgeEPNS_11GraphTraitsIT_E8NodeTypeEjNS3_17ChildIteratorTypeE")
  //</editor-fold>
  public void writeEdge( NodeType /*P*/ Node, /*uint*/int edgeidx,  ChildIteratorType EI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// emitSimpleNode - Outputs a simple (non-record) node
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::emitSimpleNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 262,
   FQN="llvm::GraphWriter::emitSimpleNode", NM="_ZN4llvm11GraphWriter14emitSimpleNodeEPKvRKSsS4_jPKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter14emitSimpleNodeEPKvRKSsS4_jPKSt6vectorISsSaISsEE")
  //</editor-fold>
  public void emitSimpleNode(/*const*/Object/*void P*/ ID, final /*const*/std.string/*&*/ Attr, 
                final /*const*/std.string/*&*/ Label) {
    emitSimpleNode(ID, Attr, 
                Label, 0, 
                (/*const*/std.vectorString/*P*/ )null);
  }
  public void emitSimpleNode(/*const*/Object/*void P*/ ID, final /*const*/std.string/*&*/ Attr, 
                final /*const*/std.string/*&*/ Label, /*uint*/int NumEdgeSources/*= 0*/) {
    emitSimpleNode(ID, Attr, 
                Label, NumEdgeSources, 
                (/*const*/std.vectorString/*P*/ )null);
  }
  public void emitSimpleNode(/*const*/Object/*void P*/ ID, final /*const*/std.string/*&*/ Attr, 
                final /*const*/std.string/*&*/ Label, /*uint*/int NumEdgeSources/*= 0*/, 
                /*const*/std.vectorString/*P*/ EdgeSourceLabels/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// emitEdge - Output an edge from a simple node into the graph...
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::emitEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 285,
   FQN="llvm::GraphWriter::emitEdge", NM="_ZN4llvm11GraphWriter8emitEdgeEPKviS2_iRKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter8emitEdgeEPKviS2_iRKSs")
  //</editor-fold>
  public void emitEdge(/*const*/Object/*void P*/ SrcNodeID, int SrcNodePort, 
          /*const*/Object/*void P*/ DestNodeID, int DestNodePort, 
          final /*const*/std.string/*&*/ Attrs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getOStream - Get the raw output stream into the graph file. Useful to
  /// write fancy things using addCustomGraphFeatures().
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphWriter::getOStream">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GraphWriter.h", line = 305,
   FQN="llvm::GraphWriter::getOStream", NM="_ZN4llvm11GraphWriter10getOStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm11GraphWriter10getOStreamEv")
  //</editor-fold>
  public raw_ostream /*&*/ getOStream() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "O=" + O // NOI18N
              + ", G=" + G // NOI18N
              + ", DTraits=" + DTraits; // NOI18N
  }
}
