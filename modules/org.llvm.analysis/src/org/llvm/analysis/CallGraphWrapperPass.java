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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;


/// \brief The \c ModulePass which wraps up a \c CallGraph and the logic to
/// build it.
///
/// This class exposes both the interface to the call graph container and the
/// module pass which runs over a module of IR and produces the call graph. The
/// call graph interface is entirelly a wrapper around a \c CallGraph object
/// which is stored internally for each module.
//<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 328,
 FQN="llvm::CallGraphWrapperPass", NM="_ZN4llvm20CallGraphWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPassE")
//</editor-fold>
public class CallGraphWrapperPass extends /*public*/ ModulePass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<CallGraph> G;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0); // Class identification, replacement for typeinfo


  //===----------------------------------------------------------------------===//
  // Out-of-line definitions of CallGraphAnalysis class members.
  //

  //===----------------------------------------------------------------------===//
  // Implementations of the CallGraphWrapperPass class methods.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::CallGraphWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 277,
   FQN="llvm::CallGraphWrapperPass::CallGraphWrapperPass", NM="_ZN4llvm20CallGraphWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPassC1Ev")
  //</editor-fold>
  public CallGraphWrapperPass() {
    // : ModulePass(ID), G()
    //START JInit
    super(ID);
    this.G = new std.unique_ptr<CallGraph>();
    //END JInit
    CallGraphLlvmStatics.initializeCallGraphWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::~CallGraphWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 281,
   FQN="llvm::CallGraphWrapperPass::~CallGraphWrapperPass", NM="_ZN4llvm20CallGraphWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPassD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    G.$destroy();
    super.$destroy();
    //END JDestroy
  }


  /// \brief The internal \c CallGraph around which the rest of this interface
  /// is wrapped.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getCallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 339,
   FQN="llvm::CallGraphWrapperPass::getCallGraph", NM="_ZNK4llvm20CallGraphWrapperPass12getCallGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass12getCallGraphEv")
  //</editor-fold>
  public /*const*/ CallGraph /*&*/ getCallGraph$Const() /*const*/ {
    return G.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getCallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 340,
   FQN="llvm::CallGraphWrapperPass::getCallGraph", NM="_ZN4llvm20CallGraphWrapperPass12getCallGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass12getCallGraphEv")
  //</editor-fold>
  public CallGraph /*&*/ getCallGraph() {
    return G.$star();
  }


  // JAVA: typedef CallGraph::iterator iterator
//  public final class iterator extends std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>>{ };
  // JAVA: typedef CallGraph::const_iterator const_iterator
//  public final class const_iterator extends std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>>{ };

  /// \brief Returns the module the call graph corresponds to.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 346,
   FQN="llvm::CallGraphWrapperPass::getModule", NM="_ZNK4llvm20CallGraphWrapperPass9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass9getModuleEv")
  //</editor-fold>
  public Module /*&*/ getModule() /*const*/ {
    return G.$arrow().getModule();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 348,
   FQN="llvm::CallGraphWrapperPass::begin", NM="_ZN4llvm20CallGraphWrapperPass5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass5beginEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>> begin() {
    return G.$arrow().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 349,
   FQN="llvm::CallGraphWrapperPass::end", NM="_ZN4llvm20CallGraphWrapperPass3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass3endEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>> end() {
    return G.$arrow().end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 350,
   FQN="llvm::CallGraphWrapperPass::begin", NM="_ZNK4llvm20CallGraphWrapperPass5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass5beginEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> begin$Const() /*const*/ {
    return new std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>>(G.$arrow().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 351,
   FQN="llvm::CallGraphWrapperPass::end", NM="_ZNK4llvm20CallGraphWrapperPass3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass3endEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> end$Const() /*const*/ {
    return new std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>>(G.$arrow().end());
  }


  /// \brief Returns the call graph node for the provided function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 354,
   FQN="llvm::CallGraphWrapperPass::operator[]", NM="_ZNK4llvm20CallGraphWrapperPassixEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPassixEPKNS_8FunctionE")
  //</editor-fold>
  public /*inline*/ /*const*/ CallGraphNode /*P*/ $at$Const(/*const*/ Function /*P*/ F) /*const*/ {
    return (G.$star()).$at(F);
  }


  /// \brief Returns the call graph node for the provided function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 359,
   FQN="llvm::CallGraphWrapperPass::operator[]", NM="_ZN4llvm20CallGraphWrapperPassixEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPassixEPKNS_8FunctionE")
  //</editor-fold>
  public /*inline*/ CallGraphNode /*P*/ $at(/*const*/ Function /*P*/ F) {
    return (G.$star()).$at(F);
  }


  /// \brief Returns the \c CallGraphNode which is used to represent
  /// undetermined calls into the callgraph.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getExternalCallingNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 363,
   FQN="llvm::CallGraphWrapperPass::getExternalCallingNode", NM="_ZNK4llvm20CallGraphWrapperPass22getExternalCallingNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass22getExternalCallingNodeEv")
  //</editor-fold>
  public CallGraphNode /*P*/ getExternalCallingNode() /*const*/ {
    return G.$arrow().getExternalCallingNode();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getCallsExternalNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 367,
   FQN="llvm::CallGraphWrapperPass::getCallsExternalNode", NM="_ZNK4llvm20CallGraphWrapperPass20getCallsExternalNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass20getCallsExternalNodeEv")
  //</editor-fold>
  public CallGraphNode /*P*/ getCallsExternalNode() /*const*/ {
    return G.$arrow().getCallsExternalNode();
  }


  //===---------------------------------------------------------------------
  // Functions to keep a call graph up to date with a function that has been
  // modified.
  //

  /// \brief Unlink the function from this module, returning it.
  ///
  /// Because this removes the function from the module, the call graph node is
  /// destroyed.  This is only valid if the function does not call any other
  /// functions (ie, there are no edges in it's CGN).  The easiest way to do
  /// this is to dropAllReferences before calling this.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::removeFunctionFromModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 382,
   FQN="llvm::CallGraphWrapperPass::removeFunctionFromModule", NM="_ZN4llvm20CallGraphWrapperPass24removeFunctionFromModuleEPNS_13CallGraphNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass24removeFunctionFromModuleEPNS_13CallGraphNodeE")
  //</editor-fold>
  public Function /*P*/ removeFunctionFromModule(CallGraphNode /*P*/ CGN) {
    return G.$arrow().removeFunctionFromModule(CGN);
  }


  /// \brief Similar to operator[], but this will insert a new CallGraphNode for
  /// \c F if one does not already exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getOrInsertFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 388,
   FQN="llvm::CallGraphWrapperPass::getOrInsertFunction", NM="_ZN4llvm20CallGraphWrapperPass19getOrInsertFunctionEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass19getOrInsertFunctionEPKNS_8FunctionE")
  //</editor-fold>
  public CallGraphNode /*P*/ getOrInsertFunction(/*const*/ Function /*P*/ F) {
    return G.$arrow().getOrInsertFunction(F);
  }


  //===---------------------------------------------------------------------
  // Implementation of the ModulePass interface needed here.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 283,
   FQN="llvm::CallGraphWrapperPass::getAnalysisUsage", NM="_ZNK4llvm20CallGraphWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 287,
   FQN="llvm::CallGraphWrapperPass::runOnModule", NM="_ZN4llvm20CallGraphWrapperPass11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module /*&*/ M)/* override*/ {
    // All the real work is done in the constructor for the CallGraph.
    G.reset(new CallGraph(M));
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 298,
   FQN="llvm::CallGraphWrapperPass::releaseMemory", NM="_ZN4llvm20CallGraphWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    G.reset();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 300,
   FQN="llvm::CallGraphWrapperPass::print", NM="_ZNK4llvm20CallGraphWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ $Prm1) /*const*//* override*/ {
    if (!G.$bool()) {
      OS.$out(/*KEEP_STR*/"No call graph has been built!\n");
      return;
    }

    // Just delegate.
    G.$arrow().print(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphWrapperPass::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 310,
   FQN="llvm::CallGraphWrapperPass::dump", NM="_ZNK4llvm20CallGraphWrapperPass4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm20CallGraphWrapperPass4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), (/*const*/ Module /*P*/ )null);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<CallGraphWrapperPass> ID = CallGraphWrapperPass.class; // Class identification, replacement for typeinfo

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "G=" + G // NOI18N
              + super.toString(); // NOI18N
  }
}
