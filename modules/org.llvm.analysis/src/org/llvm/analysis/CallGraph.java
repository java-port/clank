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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.SmallVector;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.IntrinsicGlobals;


/// \brief The basic data container for the call graph of a \c Module of IR.
///
/// This class exposes both the interface to the call graph for a module of IR.
///
/// The core call graph itself can also be updated to reflect changes to the IR.
//<editor-fold defaultstate="collapsed" desc="llvm::CallGraph">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 76,
 FQN="llvm::CallGraph", NM="_ZN4llvm9CallGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraphE")
//</editor-fold>
public class CallGraph implements Iterable<std.pairPtrType<Function,unique_ptr<CallGraphNode>>>, Destructors.ClassWithDestructor {
  private final Module /*&*/ M;

  // JAVA: typedef std::map<const Function *, std::unique_ptr<CallGraphNode> > FunctionMapTy
//  public final class FunctionMapTy extends std.mapPtrType</*const*/ Function /*P*/ , std.unique_ptr<CallGraphNode>>{ };

  /// \brief A map from \c Function* to \c CallGraphNode*.
  private std.mapPtrType</*const*/ Function /*P*/ , std.unique_ptr<CallGraphNode>> FunctionMap;

  /// \brief Root is root of the call graph, or the external node if a 'main'
  /// function couldn't be found.
  private CallGraphNode /*P*/ Root;

  /// \brief This node has edges to all external functions and those internal
  /// functions that have their address taken.
  private CallGraphNode /*P*/ ExternalCallingNode;

  /// \brief This node has edges to it from all functions making indirect calls
  /// or calling an external function.
  private std.unique_ptr<CallGraphNode> CallsExternalNode;

  /// \brief Replace the function represented by this node by another.
  ///
  /// This does not rescan the body of the function, so it is suitable when
  /// splicing the body of one function to another while also updating all
  /// callers from the old function to the new.

  /// spliceFunction - Replace the function represented by this node by another.
  /// This does not rescan the body of the function, so it is suitable when
  /// splicing the body of the old function to the new while also updating all
  /// callers from old to new.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::spliceFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 152,
   FQN="llvm::CallGraph::spliceFunction", NM="_ZN4llvm9CallGraph14spliceFunctionEPKNS_8FunctionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraph14spliceFunctionEPKNS_8FunctionES3_")
  //</editor-fold>
  private void spliceFunction(/*const*/ Function /*P*/ From, /*const*/ Function /*P*/ To) {
    assert ((FunctionMap.count(From))) : "No CallGraphNode for function!";
    assert (!(FunctionMap.count(To))) : "Pointing CallGraphNode at a function that already exists";
    std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>> I = FunctionMap.find(From);
    I.$arrow().second.$arrow().F.$assign_ValueTy(((/*const_cast*/Function /*P*/ )(To)));
    FunctionMap.$at_T$C$R(To).$assignMove(std.move(I.$arrow().second));
    FunctionMap.erase($Clone(I));
  }


  /// \brief Add a function to the call graph, and link the node to all of the
  /// functions that it calls.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::addToCallGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 57,
   FQN="llvm::CallGraph::addToCallGraph", NM="_ZN4llvm9CallGraph14addToCallGraphEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraph14addToCallGraphEPNS_8FunctionE")
  //</editor-fold>
  private void addToCallGraph(Function /*P*/ F) {
    CallGraphNode /*P*/ Node = getOrInsertFunction(F);

    // If this function has external linkage, anything could call it.
    if (!F.hasLocalLinkage()) {
      ExternalCallingNode.addCalledFunction(new CallSite(), Node);

      // Found the entry point?
      if ($eq_StringRef(F.getName(), /*STRINGREF_STR*/"main")) {
        if ((Root != null)) { // Found multiple external mains?  Don't pick one.
          Root = ExternalCallingNode;
        } else {
          Root = Node; // Found a main, keep track of it!
        }
      }
    }

    // If this function has its address taken, anything could call it.
    if (F.hasAddressTaken()) {
      ExternalCallingNode.addCalledFunction(new CallSite(), Node);
    }

    // If this function is not defined in this translation unit, it could call
    // anything.
    if (F.isDeclaration() && !F.isIntrinsic()) {
      Node.addCalledFunction(new CallSite(), CallsExternalNode.get());
    }

    // Look for calls by this function.
    for (final BasicBlock /*&*/ BB : $Deref(F))  {
      for (final Instruction /*&*/ I : BB) {
        {
          CallSite CS = new CallSite($AddrOf(I));
          if (CS.$bool()) {
            /*const*/ Function /*P*/ Callee = CS.getCalledFunction();
            if (!(Callee != null) || !IntrinsicGlobals.isLeaf(Callee.getIntrinsicID())) {
              // Indirect calls of intrinsics are not allowed so no need to check.
              // We can be more precise here by using TargetArg returned by
              // Intrinsic::isLeaf.
              Node.addCalledFunction(new CallSite(CS), CallsExternalNode.get());
            } else if (!Callee.isIntrinsic()) {
              Node.addCalledFunction(new CallSite(CS), getOrInsertFunction(Callee));
            }
          }
        }
      }
    }
  }

/*public:*/

  //===----------------------------------------------------------------------===//
  // Implementations of the CallGraph class methods.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::CallGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 23,
   FQN="llvm::CallGraph::CallGraph", NM="_ZN4llvm9CallGraphC1ERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraphC1ERNS_6ModuleE")
  //</editor-fold>
  public CallGraph(final Module /*&*/ M) {
    // : M(M), FunctionMap(), Root(null), ExternalCallingNode(getOrInsertFunction(null)), CallsExternalNode($c$.track(llvm::make_unique<CallGraphNode>(null)))
    //START JInit
    this./*&*/M=/*&*/M;
    this.FunctionMap = new std.mapPtrType</*const*/ Function /*P*/ , std.unique_ptr<CallGraphNode>>(new std.unique_ptr<CallGraphNode>());
    this.Root = null;
    this.ExternalCallingNode = getOrInsertFunction((/*const*/ Function /*P*/ )null);
    this.CallsExternalNode = llvm.make_unique(new CallGraphNode((Function)null));
    //END JInit
    // Add every function to the call graph.
    for (final Function /*&*/ F : M)  {
      addToCallGraph($AddrOf(F));
    }

    // If we didn't find a main function, use the external call graph node
    if (!(Root != null)) {
      Root = ExternalCallingNode;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::CallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 35,
   FQN="llvm::CallGraph::CallGraph", NM="_ZN4llvm9CallGraphC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraphC1EOS0_")
  //</editor-fold>
  public CallGraph(JD$Move _dparam, final CallGraph /*&&*/Arg) {
    // : M(Arg.M), FunctionMap(std::move(Arg.FunctionMap)), Root(Arg.Root), ExternalCallingNode(Arg.ExternalCallingNode), CallsExternalNode(std::move(Arg.CallsExternalNode))
    //START JInit
    this./*&*/M=/*&*/Arg.M;
    this.FunctionMap = new std.mapPtrType</*const*/ Function /*P*/ , std.unique_ptr<CallGraphNode>>(JD$Move.INSTANCE, std.move(Arg.FunctionMap));
    this.Root = Arg.Root;
    this.ExternalCallingNode = Arg.ExternalCallingNode;
    this.CallsExternalNode = new std.unique_ptr<CallGraphNode>(JD$Move.INSTANCE, std.move(Arg.CallsExternalNode));
    //END JInit
    Arg.FunctionMap.clear();
    Arg.Root = null;
    Arg.ExternalCallingNode = null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::~CallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 44,
   FQN="llvm::CallGraph::~CallGraph", NM="_ZN4llvm9CallGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraphD0Ev")
  //</editor-fold>
  public void $destroy() {
    // CallsExternalNode is not in the function map, delete it explicitly.
    if (CallsExternalNode.$bool()) {
      CallsExternalNode.$arrow().allReferencesDropped();
    }
    for (final std.pairPtrType</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> /*&*/ I : FunctionMap)  {
      I.second.$arrow().allReferencesDropped();
    }
    //START JDestroy
    CallsExternalNode.$destroy();
    FunctionMap.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 98,
   FQN="llvm::CallGraph::print", NM="_ZNK4llvm9CallGraph5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"CallGraph Root is: ");
    {
      Function /*P*/ F = Root.getFunction();
      if ((F != null)) {
        OS.$out(F.getName()).$out(/*KEEP_STR*/$LF);
      } else {
        OS.$out(/*KEEP_STR*/"<<null function: 0x").$out(Root).$out(/*KEEP_STR*/">>\n");
      }
    }

    // Print in a deterministic order by sorting CallGraphNodes by name.  We do
    // this here to avoid slowing down the non-printing fast path.
    SmallVector<CallGraphNode /*P*/ > Nodes/*J*/= new SmallVector<CallGraphNode /*P*/ >(16, (CallGraphNode /*P*/ )null);
    Nodes.reserve(FunctionMap.size());

    for (final /*const*/std.pairPtrType</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> /*&*/ I : /*Deref*/this)  {
      Nodes.push_back(I.second.get());
    }

    std.sort(Nodes.begin(), Nodes.end(),
        /*[]*/ (CallGraphNode /*P*/ LHS, CallGraphNode /*P*/ RHS) -> {
              {
                Function /*P*/ LF = LHS.getFunction();
                if ((LF != null)) {
                  {
                    Function /*P*/ RF = RHS.getFunction();
                    if ((RF != null)) {
                      return $less_StringRef(LF.getName(), RF.getName());
                    }
                  }
                }
              }

              return RHS.getFunction() != (Function /*P*/ )null;
            });

    for (CallGraphNode /*P*/ CN : Nodes)  {
      CN.print(OS);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 128,
   FQN="llvm::CallGraph::dump", NM="_ZNK4llvm9CallGraph4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }


  // JAVA: typedef FunctionMapTy::iterator iterator
//  public final class iterator extends std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>>{ };
  // JAVA: typedef FunctionMapTy::const_iterator const_iterator
//  public final class const_iterator extends std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>>{ };

  /// \brief Returns the module the call graph corresponds to.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 120,
   FQN="llvm::CallGraph::getModule", NM="_ZNK4llvm9CallGraph9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph9getModuleEv")
  //</editor-fold>
  public Module /*&*/ getModule() /*const*/ {
    return M;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 122,
   FQN="llvm::CallGraph::begin", NM="_ZN4llvm9CallGraph5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraph5beginEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>> begin() {
    return FunctionMap.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 123,
   FQN="llvm::CallGraph::end", NM="_ZN4llvm9CallGraph3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraph3endEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator<Function,unique_ptr<CallGraphNode>> end() {
    return FunctionMap.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 124,
   FQN="llvm::CallGraph::begin", NM="_ZNK4llvm9CallGraph5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph5beginEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> begin$Const() /*const*/ {
    return FunctionMap.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 125,
   FQN="llvm::CallGraph::end", NM="_ZNK4llvm9CallGraph3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph3endEv")
  //</editor-fold>
  public /*inline*/ std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> end$Const() /*const*/ {
    return FunctionMap.end$Const();
  }


  /// \brief Returns the call graph node for the provided function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 128,
   FQN="llvm::CallGraph::operator[]", NM="_ZNK4llvm9CallGraphixEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraphixEPKNS_8FunctionE")
  //</editor-fold>
  public /*inline*/ /*const*/ CallGraphNode /*P*/ $at$Const(/*const*/ Function /*P*/ F) /*const*/ {
    std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> I = FunctionMap.find$Const(F);
    assert (I.$noteq(FunctionMap.end$Const())) : "Function not in callgraph!";
    return I.$arrow().second.get();
  }


  /// \brief Returns the call graph node for the provided function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 135,
   FQN="llvm::CallGraph::operator[]", NM="_ZN4llvm9CallGraphixEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraphixEPKNS_8FunctionE")
  //</editor-fold>
  public /*inline*/ CallGraphNode /*P*/ $at(/*const*/ Function /*P*/ F) {
    std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>> I = new std.mapPtrType.iterator</*const*/ Function /*P*/ /*const*/, unique_ptr<CallGraphNode>>(FunctionMap.find(F));
    assert (I.$noteq(/*NO_ITER_COPY*/FunctionMap.end())) : "Function not in callgraph!";
    return I.$arrow().second.get();
  }


  /// \brief Returns the \c CallGraphNode which is used to represent
  /// undetermined calls into the callgraph.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::getExternalCallingNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 143,
   FQN="llvm::CallGraph::getExternalCallingNode", NM="_ZNK4llvm9CallGraph22getExternalCallingNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph22getExternalCallingNodeEv")
  //</editor-fold>
  public CallGraphNode /*P*/ getExternalCallingNode() /*const*/ {
    return ExternalCallingNode;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::getCallsExternalNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 145,
   FQN="llvm::CallGraph::getCallsExternalNode", NM="_ZNK4llvm9CallGraph20getCallsExternalNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm9CallGraph20getCallsExternalNodeEv")
  //</editor-fold>
  public CallGraphNode /*P*/ getCallsExternalNode() /*const*/ {
    return CallsExternalNode.get();
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

  // removeFunctionFromModule - Unlink the function from this module, returning
  // it.  Because this removes the function from the module, the call graph node
  // is destroyed.  This is only valid if the function does not call any other
  // functions (ie, there are no edges in it's CGN).  The easiest way to do this
  // is to dropAllReferences before calling this.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::removeFunctionFromModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 137,
   FQN="llvm::CallGraph::removeFunctionFromModule", NM="_ZN4llvm9CallGraph24removeFunctionFromModuleEPNS_13CallGraphNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraph24removeFunctionFromModuleEPNS_13CallGraphNodeE")
  //</editor-fold>
  public Function /*P*/ removeFunctionFromModule(CallGraphNode /*P*/ CGN) {
    assert (CGN.empty()) : "Cannot remove function from call graph if it references other functions!";
    Function /*P*/ F = CGN.getFunction(); // Get the function for the call graph node
    FunctionMap.erase(F); // Remove the call graph node from the map

    M.getFunctionList().remove_T$P(F);
    return F;
  }


  /// \brief Similar to operator[], but this will insert a new CallGraphNode for
  /// \c F if one does not already exist.

  // getOrInsertFunction - This method is identical to calling operator[], but
  // it will insert a new CallGraphNode for the specified function if one does
  // not already exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraph::getOrInsertFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 165,
   FQN="llvm::CallGraph::getOrInsertFunction", NM="_ZN4llvm9CallGraph19getOrInsertFunctionEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm9CallGraph19getOrInsertFunctionEPKNS_8FunctionE")
  //</editor-fold>
  public CallGraphNode /*P*/ getOrInsertFunction(/*const*/ Function /*P*/ F) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final unique_ptr<CallGraphNode> /*&*/ CGN = FunctionMap.$at_T$C$R(F);
      if (CGN.$bool()) {
        return CGN.get();
      }
      assert ((!(F != null) || F.getParent$Const() == $AddrOf(M))) : "Function not in current module!";
      $c$.clean(CGN.$assignMove($c$.track(llvm.make_unique(new CallGraphNode(((/*const_cast*/Function /*P*/ )(F)))))));
      return CGN.get();
    } finally {
      $c$.$destroy();
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override Iterator<std.pairPtrType<Function,unique_ptr<CallGraphNode>>> iterator() { return new JavaIterator<>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", FunctionMap=" + FunctionMap // NOI18N
              + ", Root=" + Root // NOI18N
              + ", ExternalCallingNode=" + ExternalCallingNode // NOI18N
              + ", CallsExternalNode=" + CallsExternalNode; // NOI18N
  }
}
