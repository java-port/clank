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
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.java.GraphTraits;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraph * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 478,
 FQN="llvm::GraphTraits<const CallGraph * >", NM="_ZN4llvm11GraphTraitsIPKNS_9CallGraphEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_9CallGraphEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsCallGraph$C$P /*extends public GraphTraitsCallGraphNode$C$P*/ implements GraphTraits<CallGraph, CallGraphNode, CallGraphNode> {
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraph * >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 481,
   FQN="llvm::GraphTraits<const CallGraph * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE12getEntryNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE12getEntryNodeES3_")
  //</editor-fold>
  @Override
  public /*const*/ CallGraphNode /*P*/ getEntryNode(/*const*/ CallGraph /*P*/ CGN) {
    return CGN.getExternalCallingNode(); // Start at the external node!
  }

  // JAVA: typedef std::pair<const Function *const, std::unique_ptr<CallGraphNode> > PairTy
//  public final class PairTy extends std.pairPtrType</*const*/ Function /*P*/ /*const*/, std.unique_ptr<CallGraphNode>>{ };
  // JAVA: typedef std::pointer_to_unary_function<const PairTy &, const CallGraphNode &> DerefFun
//  public final class DerefFun extends std.pointer_to_unary_function</*const*/std.pairPtrType</*const*/ Function /*P*/ /*const*/, std.unique_ptr<CallGraphNode>> /*&*/, /*const*/ CallGraphNode /*&*/ >{ };

  // nodes_iterator/begin/end - Allow iteration over all nodes in the graph
  // JAVA: typedef mapped_iterator<CallGraph::const_iterator, DerefFun> nodes_iterator
//  public final class nodes_iterator extends mapped_iterator<std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>>, std.pointer_to_unary_function</*const*/std.pairPtrType</*const*/ Function /*P*/ /*const*/, std.unique_ptr<CallGraphNode>> /*&*/, /*const*/ CallGraphNode /*&*/ > >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraph * >::nodes_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 491,
   FQN="llvm::GraphTraits<const CallGraph * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE11nodes_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE11nodes_beginES3_")
  //</editor-fold>
  @Override
  public type$iterator<?, CallGraphNode> nodes_begin(CallGraph CG) {
    return map_iterator(CG.begin$Const(), /*FuncRef*/GraphTraitsCallGraph$C$P::CGdereference);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraph * >::nodes_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 494,
   FQN="llvm::GraphTraits<const CallGraph * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE9nodes_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE9nodes_endES3_")
  //</editor-fold>
  @Override
  public type$iterator<?, CallGraphNode> nodes_end(/*const*/ CallGraph /*P*/ CG) {
    return map_iterator(CG.end$Const(), /*FuncRef*/GraphTraitsCallGraph$C$P::CGdereference);
  }


  // JAVA: copied from GraphTraitsCallGraphNode$C$P as in Java we can't extend it here (implement GraphTraits with different templat parameters)
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraphNode * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 446,
   FQN="llvm::GraphTraits<const CallGraphNode * >::child_begin", NM="_ZN4llvm11GraphTraitsIPKNS_13CallGraphNodeEE11child_beginES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_13CallGraphNodeEE11child_beginES3_")
  //</editor-fold>
  @Override
  public /*inline*/ type$iterator<?, CallGraphNode> child_begin(/*const*/ CallGraphNode /*P*/ N) {
    return map_iterator(N.begin$Const(), /*FuncRef*/GraphTraitsCallGraphNode$C$P::CGNDeref);
  }

  // JAVA: copied from GraphTraitsCallGraphNode$C$P as in Java we can't extend it here (implement GraphTraits with different templat parameters)
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraphNode * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 449,
   FQN="llvm::GraphTraits<const CallGraphNode * >::child_end", NM="_ZN4llvm11GraphTraitsIPKNS_13CallGraphNodeEE9child_endES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_13CallGraphNodeEE9child_endES3_")
  //</editor-fold>
  @Override
  public /*inline*/ type$iterator<?, CallGraphNode> child_end(/*const*/ CallGraphNode /*P*/ N) {
    return map_iterator(N.end$Const(), /*FuncRef*/GraphTraitsCallGraphNode$C$P::CGNDeref);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const CallGraph * >::CGdereference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 498,
   FQN="llvm::GraphTraits<const CallGraph * >::CGdereference", NM="_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE13CGdereferenceERKSt4pairIKPKNS_8FunctionESt10unique_ptrINS_13CallGraphNodeESt14default_deleteISB_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm11GraphTraitsIPKNS_9CallGraphEE13CGdereferenceERKSt4pairIKPKNS_8FunctionESt10unique_ptrINS_13CallGraphNodeESt14default_deleteISB_EEE")
  //</editor-fold>
  public static /*const*/ CallGraphNode /*&*/ CGdereference(final /*const*/std.pairPtrType</*const*/ Function /*P*/ /*const*/, std.unique_ptr<CallGraphNode>> /*&*/ P) {
    return P.second.$star();
  }

  private static final GraphTraitsCallGraph$C$P INSTANCE = new GraphTraitsCallGraph$C$P();

  public static GraphTraitsCallGraph$C$P $GTraits() {
    return INSTANCE;
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
