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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;


/// DefaultDOTGraphTraits - This class provides the default implementations of
/// all of the DOTGraphTraits methods.  If a specialization does not need to
/// override all methods here it should inherit so that it can get the default
/// implementations.
///
//<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 29,
 FQN="llvm::DefaultDOTGraphTraits", NM="_ZN4llvm21DefaultDOTGraphTraitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraitsE")
//</editor-fold>
public class/*struct*/ DefaultDOTGraphTraits {
/*private:*/
  private boolean IsSimple;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 34,
   FQN="llvm::DefaultDOTGraphTraits::isSimple", NM="_ZN4llvm21DefaultDOTGraphTraits8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraits8isSimpleEv")
  //</editor-fold>
  protected boolean isSimple() {
    return IsSimple;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::DefaultDOTGraphTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 39,
   FQN="llvm::DefaultDOTGraphTraits::DefaultDOTGraphTraits", NM="_ZN4llvm21DefaultDOTGraphTraitsC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraitsC1Eb")
  //</editor-fold>
  public /*explicit*/ DefaultDOTGraphTraits() {
    this(false);
  }
  public /*explicit*/ DefaultDOTGraphTraits(boolean simple/*= false*/) {
    // : IsSimple(simple) 
    //START JInit
    this.IsSimple = simple;
    //END JInit
  }

  
  /// getGraphName - Return the label for the graph as a whole.  Printed at the
  /// top of the graph.
  ///
  /*template <typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getGraphName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 45,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 44,
   FQN="llvm::DefaultDOTGraphTraits::getGraphName", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits12getGraphNameERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits12getGraphNameERKT_")
  //</editor-fold>
  public static </*typename*/ GraphType> std.string getGraphName(final /*const*/ GraphType /*&*/ $Prm0) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// getGraphProperties - Return any custom properties that should be included
  /// in the top level graph structure for dot.
  ///
  /*template <typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getGraphProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 51,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 50,
   FQN="llvm::DefaultDOTGraphTraits::getGraphProperties", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits18getGraphPropertiesERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits18getGraphPropertiesERKT_")
  //</editor-fold>
  public static </*typename*/ GraphType> std.string getGraphProperties(final /*const*/ GraphType /*&*/ $Prm0) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// renderGraphFromBottomUp - If this function returns true, the graph is
  /// emitted bottom-up instead of top-down.  This requires graphviz 2.0 to work
  /// though.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::renderGraphFromBottomUp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 58,
   FQN="llvm::DefaultDOTGraphTraits::renderGraphFromBottomUp", NM="_ZN4llvm21DefaultDOTGraphTraits23renderGraphFromBottomUpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraits23renderGraphFromBottomUpEv")
  //</editor-fold>
  public static boolean renderGraphFromBottomUp() {
    return false;
  }

  
  /// isNodeHidden - If the function returns true, the given node is not
  /// displayed in the graph.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::isNodeHidden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 64,
   FQN="llvm::DefaultDOTGraphTraits::isNodeHidden", NM="_ZN4llvm21DefaultDOTGraphTraits12isNodeHiddenEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraits12isNodeHiddenEPKv")
  //</editor-fold>
  public static boolean isNodeHidden(/*const*/Object/*void P*/ $Prm0) {
    return false;
  }

  
  /// getNodeLabel - Given a node and a pointer to the top level graph, return
  /// the label to print in the node.
  /*template <typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 71,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 70,
   FQN="llvm::DefaultDOTGraphTraits::getNodeLabel", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits12getNodeLabelEPKvRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits12getNodeLabelEPKvRKT_")
  //</editor-fold>
  public </*typename*/ GraphType> std.string getNodeLabel(/*const*/Object/*void P*/ $Prm0, final /*const*/ GraphType /*&*/ $Prm1) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  // getNodeIdentifierLabel - Returns a string representing the
  // address or other unique identifier of the node. (Only used if
  // non-empty.)
  /*template <typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getNodeIdentifierLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 78,
   FQN="llvm::DefaultDOTGraphTraits::getNodeIdentifierLabel", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits22getNodeIdentifierLabelEPKvRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits22getNodeIdentifierLabelEPKvRKT_")
  //</editor-fold>
  public static </*typename*/ GraphType> std.string getNodeIdentifierLabel(/*const*/Object/*void P*/ $Prm0, final /*const*/ GraphType /*&*/ $Prm1) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /*template <typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getNodeDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 83,
   FQN="llvm::DefaultDOTGraphTraits::getNodeDescription", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits18getNodeDescriptionEPKvRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits18getNodeDescriptionEPKvRKT_")
  //</editor-fold>
  public static </*typename*/ GraphType> std.string getNodeDescription(/*const*/Object/*void P*/ $Prm0, final /*const*/ GraphType /*&*/ $Prm1) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// If you want to specify custom node attributes, this is the place to do so
  ///
  /*template <typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getNodeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 90,
   FQN="llvm::DefaultDOTGraphTraits::getNodeAttributes", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits17getNodeAttributesEPKvRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits17getNodeAttributesEPKvRKT_")
  //</editor-fold>
  public static </*typename*/ GraphType> std.string getNodeAttributes(/*const*/Object/*void P*/ $Prm0, 
                   final /*const*/ GraphType /*&*/ $Prm1) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// If you want to override the dot attributes printed for a particular edge,
  /// override this method.
  /*template <typename EdgeIter, typename GraphType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getEdgeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 98,
   FQN="llvm::DefaultDOTGraphTraits::getEdgeAttributes", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits17getEdgeAttributesEPKvT_RKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits17getEdgeAttributesEPKvT_RKT0_")
  //</editor-fold>
  public static </*typename*/ EdgeIter, /*typename*/ GraphType> std.string getEdgeAttributes(/*const*/Object/*void P*/ $Prm0, EdgeIter $Prm1, 
                   final /*const*/ GraphType /*&*/ $Prm2) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// getEdgeSourceLabel - If you want to label the edge source itself,
  /// implement this method.
  /*template <typename EdgeIter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getEdgeSourceLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 106,
   FQN="llvm::DefaultDOTGraphTraits::getEdgeSourceLabel", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits18getEdgeSourceLabelEPKvT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits18getEdgeSourceLabelEPKvT_")
  //</editor-fold>
  public static </*typename*/ EdgeIter> std.string getEdgeSourceLabel(/*const*/Object/*void P*/ $Prm0, EdgeIter $Prm1) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// edgeTargetsEdgeSource - This method returns true if this outgoing edge
  /// should actually target another edge source, not a node.  If this method is
  /// implemented, getEdgeTarget should be implemented.
  /*template <typename EdgeIter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::edgeTargetsEdgeSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 114,
   FQN="llvm::DefaultDOTGraphTraits::edgeTargetsEdgeSource", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits21edgeTargetsEdgeSourceEPKvT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits21edgeTargetsEdgeSourceEPKvT_")
  //</editor-fold>
  public static </*typename*/ EdgeIter> boolean edgeTargetsEdgeSource(/*const*/Object/*void P*/ $Prm0, EdgeIter $Prm1) {
    return false;
  }

  
  /// getEdgeTarget - If edgeTargetsEdgeSource returns true, this method is
  /// called to determine which outgoing edge of Node is the target of this
  /// edge.
  /*template <typename EdgeIter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getEdgeTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 122,
   FQN="llvm::DefaultDOTGraphTraits::getEdgeTarget", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits13getEdgeTargetEPKvT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits13getEdgeTargetEPKvT_")
  //</editor-fold>
  public static </*typename*/ EdgeIter> EdgeIter getEdgeTarget(/*const*/Object/*void P*/ $Prm0, EdgeIter I) {
    return I;
  }

  
  /// hasEdgeDestLabels - If this function returns true, the graph is able
  /// to provide labels for edge destinations.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::hasEdgeDestLabels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 129,
   FQN="llvm::DefaultDOTGraphTraits::hasEdgeDestLabels", NM="_ZN4llvm21DefaultDOTGraphTraits17hasEdgeDestLabelsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraits17hasEdgeDestLabelsEv")
  //</editor-fold>
  public static boolean hasEdgeDestLabels() {
    return false;
  }

  
  /// numEdgeDestLabels - If hasEdgeDestLabels, this function returns the
  /// number of incoming edge labels the given node has.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::numEdgeDestLabels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 135,
   FQN="llvm::DefaultDOTGraphTraits::numEdgeDestLabels", NM="_ZN4llvm21DefaultDOTGraphTraits17numEdgeDestLabelsEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraits17numEdgeDestLabelsEPKv")
  //</editor-fold>
  public static /*uint*/int numEdgeDestLabels(/*const*/Object/*void P*/ $Prm0) {
    return 0;
  }

  
  /// getEdgeDestLabel - If hasEdgeDestLabels, this function returns the
  /// incoming edge label with the given index in the given node.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::getEdgeDestLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 141,
   FQN="llvm::DefaultDOTGraphTraits::getEdgeDestLabel", NM="_ZN4llvm21DefaultDOTGraphTraits16getEdgeDestLabelEPKvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraits16getEdgeDestLabelEPKvj")
  //</editor-fold>
  public static std.string getEdgeDestLabel(/*const*/Object/*void P*/ $Prm0, /*uint*/int $Prm1) {
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  
  /// addCustomGraphFeatures - If a graph is made up of more than just
  /// straight-forward nodes and edges, this is the place to put all of the
  /// custom stuff necessary.  The GraphWriter object, instantiated with your
  /// GraphType is passed in as an argument.  You may call arbitrary methods on
  /// it to add things to the output graph.
  ///
  /*template <typename GraphType, typename GraphWriter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::addCustomGraphFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", old_line = 151,
   FQN="llvm::DefaultDOTGraphTraits::addCustomGraphFeatures", NM="Tpl__ZN4llvm21DefaultDOTGraphTraits22addCustomGraphFeaturesERKT_RT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=Tpl__ZN4llvm21DefaultDOTGraphTraits22addCustomGraphFeaturesERKT_RT0_")
  //</editor-fold>
  public static </*typename*/ GraphType, /*typename*/ GraphWriter> void addCustomGraphFeatures(final /*const*/ GraphType /*&*/ $Prm0, final GraphWriter /*&*/ $Prm1) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultDOTGraphTraits::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/DOTGraphTraits.h", line = 29,
   FQN="llvm::DefaultDOTGraphTraits::operator=", NM="_ZN4llvm21DefaultDOTGraphTraitsaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm21DefaultDOTGraphTraitsaSEOS0_")
  //</editor-fold>
  public /*inline*/ DefaultDOTGraphTraits /*&*/ $assignMove(final DefaultDOTGraphTraits /*&&*/$Prm0) {
    this.IsSimple = $Prm0.IsSimple;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "IsSimple=" + IsSimple; // NOI18N
  }
}
