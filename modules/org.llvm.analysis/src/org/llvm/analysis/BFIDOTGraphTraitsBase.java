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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;

/*template <class BlockFrequencyInfoT, class BranchProbabilityInfoT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::BFIDOTGraphTraitsBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1242,
 FQN="llvm::BFIDOTGraphTraitsBase", NM="_ZN4llvm21BFIDOTGraphTraitsBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm21BFIDOTGraphTraitsBaseE")
//</editor-fold>
public class/*struct*/ BFIDOTGraphTraitsBase</*class*/ BlockFrequencyInfoT, /*class*/ BranchProbabilityInfoT>  extends /*public*/ DefaultDOTGraphTraits {
  //<editor-fold defaultstate="collapsed" desc="llvm::BFIDOTGraphTraitsBase::BFIDOTGraphTraitsBase<BlockFrequencyInfoT, BranchProbabilityInfoT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1244,
   FQN="llvm::BFIDOTGraphTraitsBase::BFIDOTGraphTraitsBase<BlockFrequencyInfoT, BranchProbabilityInfoT>", NM="_ZN4llvm21BFIDOTGraphTraitsBaseC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm21BFIDOTGraphTraitsBaseC1Eb")
  //</editor-fold>
  public /*explicit*/ BFIDOTGraphTraitsBase() {
    this(false);
  }
  public /*explicit*/ BFIDOTGraphTraitsBase(boolean isSimple/*= false*/) {
    // : DefaultDOTGraphTraits(isSimple) 
    /*ParenListExpr*/super(isSimple);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // JAVA: typedef GraphTraits<BlockFrequencyInfoT *> GTraits
//  public final class GTraits extends GraphTraits<BlockFrequencyInfoT /*P*/ >{ };
  // JAVA: typedef typename GTraits::NodeType NodeType
//  public final class NodeType extends  GraphTraits.NodeType<BlockFrequencyInfoT /*P*/ >{ };
  // JAVA: typedef typename GTraits::ChildIteratorType EdgeIter
//  public final class EdgeIter extends  GraphTraits.ChildIteratorType<BlockFrequencyInfoT /*P*/ >{ };
  // JAVA: typedef typename GTraits::nodes_iterator NodeIter
//  public final class NodeIter extends  GraphTraits.nodes_iterator<BlockFrequencyInfoT /*P*/ >{ };
  
  public long/*uint64_t*/ MaxFrequency/* = 0*/;
//  //<editor-fold defaultstate="collapsed" desc="llvm::BFIDOTGraphTraitsBase::getGraphName">
//  @Converted(kind = Converted.Kind.DUMMY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1253,
//   FQN="llvm::BFIDOTGraphTraitsBase::getGraphName", NM="_ZN4llvm21BFIDOTGraphTraitsBase12getGraphNameEPKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm21BFIDOTGraphTraitsBase12getGraphNameEPKT_")
//  //</editor-fold>
//  public static </*class*/ BlockFrequencyInfoT, /*class*/ BranchProbabilityInfoT> std.string getGraphName(/*const*/ BlockFrequencyInfoT /*P*/ G) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::BFIDOTGraphTraitsBase::getNodeAttributes">
//  @Converted(kind = Converted.Kind.DUMMY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1257,
//   FQN="llvm::BFIDOTGraphTraitsBase::getNodeAttributes", NM="_ZN4llvm21BFIDOTGraphTraitsBase17getNodeAttributesEPKNS_11GraphTraitsIPT_E8NodeTypeEPKS2_j",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm21BFIDOTGraphTraitsBase17getNodeAttributesEPKNS_11GraphTraitsIPT_E8NodeTypeEPKS2_j")
//  //</editor-fold>
//  public std.string getNodeAttributes(/*const*/  GraphTraits.NodeType<BlockFrequencyInfoT /*P*/ > /*P*/ Node, 
//                   /*const*/ BlockFrequencyInfoT /*P*/ Graph) {
//    return getNodeAttributes(Node, 
//                   Graph, 
//                   0);
//  }
//  public std.string getNodeAttributes(/*const*/  GraphTraits.NodeType<BlockFrequencyInfoT /*P*/ > /*P*/ Node, 
//                   /*const*/ BlockFrequencyInfoT /*P*/ Graph, 
//                   /*uint*/int HotPercentThreshold/*= 0*/) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
//  //<editor-fold defaultstate="collapsed" desc="llvm::BFIDOTGraphTraitsBase::getNodeLabel">
//  @Converted(kind = Converted.Kind.DUMMY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1288,
//   FQN="llvm::BFIDOTGraphTraitsBase::getNodeLabel", NM="_ZN4llvm21BFIDOTGraphTraitsBase12getNodeLabelEPKNS_11GraphTraitsIPT_E8NodeTypeEPKS2_NS_9GVDAGTypeE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm21BFIDOTGraphTraitsBase12getNodeLabelEPKNS_11GraphTraitsIPT_E8NodeTypeEPKS2_NS_9GVDAGTypeE")
//  //</editor-fold>
//  public std.string getNodeLabel(/*const*/  GraphTraits.NodeType<BlockFrequencyInfoT /*P*/ > /*P*/ Node, 
//              /*const*/ BlockFrequencyInfoT /*P*/ Graph, GVDAGType GType) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::BFIDOTGraphTraitsBase::getEdgeAttributes">
//  @Converted(kind = Converted.Kind.DUMMY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1316,
//   FQN="llvm::BFIDOTGraphTraitsBase::getEdgeAttributes", NM="_ZN4llvm21BFIDOTGraphTraitsBase17getEdgeAttributesEPKNS_11GraphTraitsIPT_E8NodeTypeENS4_17ChildIteratorTypeEPKS2_PKT0_j",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm21BFIDOTGraphTraitsBase17getEdgeAttributesEPKNS_11GraphTraitsIPT_E8NodeTypeENS4_17ChildIteratorTypeEPKS2_PKT0_j")
//  //</editor-fold>
//  public std.string getEdgeAttributes(/*const*/  GraphTraits.NodeType<BlockFrequencyInfoT /*P*/ > /*P*/ Node,  GraphTraits.ChildIteratorType<BlockFrequencyInfoT /*P*/ > EI, 
//                   /*const*/ BlockFrequencyInfoT /*P*/ BFI, 
//                   /*const*/ BranchProbabilityInfoT /*P*/ BPI) {
//    return getEdgeAttributes(Node, EI, 
//                   BFI, 
//                   BPI, 
//                   0);
//  }
//  public std.string getEdgeAttributes(/*const*/  GraphTraits.NodeType<BlockFrequencyInfoT /*P*/ > /*P*/ Node,  GraphTraits.ChildIteratorType<BlockFrequencyInfoT /*P*/ > EI, 
//                   /*const*/ BlockFrequencyInfoT /*P*/ BFI, 
//                   /*const*/ BranchProbabilityInfoT /*P*/ BPI, 
//                   /*uint*/int HotPercentThreshold/*= 0*/) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  @Override public String toString() {
    return "" + "MaxFrequency=" + MaxFrequency // NOI18N
              + super.toString(); // NOI18N
  }
}
