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
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.IntrinsicGlobals;
import org.llvm.ir.java.CallGraphNodeBase;


/// \brief A node in the call graph for a module.
///
/// Typically represents a function in the call graph. There are also special
/// "null" nodes used to represent theoretical entries in the call graph.
//<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 171,
 FQN="llvm::CallGraphNode", NM="_ZN4llvm13CallGraphNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNodeE")
//</editor-fold>
public class CallGraphNode implements CallGraphNodeBase, Iterable<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >>, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief A pair of the calling instruction (a call or invoke)
  /// and the call graph node being called.
  // JAVA: typedef std::pair<WeakVH, CallGraphNode *> CallRecord
//  public final class CallRecord extends std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >{ };
/*public:*/
  // JAVA: typedef std::vector<CallRecord> CalledFunctionsVector
//  public final class CalledFunctionsVector extends std.vector<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >>{ };

  /// \brief Creates a node for the specified function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::CallGraphNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 181,
   FQN="llvm::CallGraphNode::CallGraphNode", NM="_ZN4llvm13CallGraphNodeC1EPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNodeC1EPNS_8FunctionE")
  //</editor-fold>
  public /*inline*/ CallGraphNode(Function /*P*/ F) {
    // : F(F), CalledFunctions(), NumReferences(0)
    //START JInit
    this.F = new AssertingVH<Function>(F);
    this.CalledFunctions = new std.vector<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >>(new std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >());
    this.NumReferences = 0;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::~CallGraphNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 183,
   FQN="llvm::CallGraphNode::~CallGraphNode", NM="_ZN4llvm13CallGraphNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNodeD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (NumReferences == 0) : "Node deleted while references remain";
    //START JDestroy
    CalledFunctions.$destroy();
    F.$destroy();
    //END JDestroy
  }


  // JAVA: typedef std::vector<CallRecord>::iterator iterator
//  public final class iterator extends std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/>{ };
  // JAVA: typedef std::vector<CallRecord>::const_iterator const_iterator
//  public final class const_iterator extends std.vector.iterator</*const*/std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/>{ };

  /// \brief Returns the function that this call graph node represents.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 191,
   FQN="llvm::CallGraphNode::getFunction", NM="_ZNK4llvm13CallGraphNode11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode11getFunctionEv")
  //</editor-fold>
  public Function /*P*/ getFunction() /*const*/ {
    return F.$T$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 193,
   FQN="llvm::CallGraphNode::begin", NM="_ZN4llvm13CallGraphNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode5beginEv")
  //</editor-fold>
  public /*inline*/ std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> begin() {
    return CalledFunctions.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 194,
   FQN="llvm::CallGraphNode::end", NM="_ZN4llvm13CallGraphNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode3endEv")
  //</editor-fold>
  public /*inline*/ std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> end() {
    return CalledFunctions.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 195,
   FQN="llvm::CallGraphNode::begin", NM="_ZNK4llvm13CallGraphNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode5beginEv")
  //</editor-fold>
  public /*inline*/ std.vector.iterator</*const*/std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> begin$Const() /*const*/ {
    return CalledFunctions.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 196,
   FQN="llvm::CallGraphNode::end", NM="_ZNK4llvm13CallGraphNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode3endEv")
  //</editor-fold>
  public /*inline*/ std.vector.iterator</*const*/std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> end$Const() /*const*/ {
    return CalledFunctions.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 197,
   FQN="llvm::CallGraphNode::empty", NM="_ZNK4llvm13CallGraphNode5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode5emptyEv")
  //</editor-fold>
  public /*inline*/ boolean empty() /*const*/ {
    return CalledFunctions.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 198,
   FQN="llvm::CallGraphNode::size", NM="_ZNK4llvm13CallGraphNode4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode4sizeEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int size() /*const*/ {
    return (/*uint*/int)CalledFunctions.size();
  }


  /// \brief Returns the number of other CallGraphNodes in this CallGraph that
  /// reference this node in their callee list.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::getNumReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 202,
   FQN="llvm::CallGraphNode::getNumReferences", NM="_ZNK4llvm13CallGraphNode16getNumReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode16getNumReferencesEv")
  //</editor-fold>
  public /*uint*/int getNumReferences() /*const*/ {
    return NumReferences;
  }


  /// \brief Returns the i'th called function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 205,
   FQN="llvm::CallGraphNode::operator[]", NM="_ZNK4llvm13CallGraphNodeixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNodeixEj")
  //</editor-fold>
  public CallGraphNode /*P*/ $at(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, CalledFunctions.size())) : "Invalid index";
    return CalledFunctions.$at$Const(i).second;
  }


  /// \brief Print out this call graph node.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 197,
   FQN="llvm::CallGraphNode::dump", NM="_ZNK4llvm13CallGraphNode4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }


  //===----------------------------------------------------------------------===//
  // Implementations of the CallGraphNode class methods.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 179,
   FQN="llvm::CallGraphNode::print", NM="_ZNK4llvm13CallGraphNode5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZNK4llvm13CallGraphNode5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    {
      Function /*P*/ F = getFunction();
      if ((F != null)) {
        OS.$out(/*KEEP_STR*/"Call graph node for function: '").$out(F.getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
      } else {
        OS.$out(/*KEEP_STR*/"Call graph node <<null function>>");
      }
    }

    OS.$out(/*KEEP_STR*/$LT_LT).$out(this).$out(/*KEEP_STR*/">>  #uses=").$out_uint(getNumReferences()).$out_char($$LF);

    for (final /*const*/std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*&*/ I : /*Deref*/this) {
      OS.$out(/*KEEP_STR*/"  CS<").$out(I.first.$Value$P()).$out(/*KEEP_STR*/"> calls ");
      {
        Function /*P*/ FI = I.second.getFunction();
        if ((FI != null)) {
          OS.$out(/*KEEP_STR*/"function '").$out(FI.getName()).$out(/*KEEP_STR*/"'\n");
        } else {
          OS.$out(/*KEEP_STR*/"external node\n");
        }
      }
    }
    OS.$out_char($$LF);
  }


  //===---------------------------------------------------------------------
  // Methods to keep a call graph up to date with a function that has been
  // modified
  //

  /// \brief Removes all edges from this CallGraphNode to any functions it
  /// calls.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::removeAllCalledFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 221,
   FQN="llvm::CallGraphNode::removeAllCalledFunctions", NM="_ZN4llvm13CallGraphNode24removeAllCalledFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode24removeAllCalledFunctionsEv")
  //</editor-fold>
  public void removeAllCalledFunctions() {
    while (!CalledFunctions.empty()) {
      CalledFunctions.back().second.DropRef();
      CalledFunctions.pop_back();
    }
  }


  /// \brief Moves all the callee information from N to this node.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::stealCalledFunctionsFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 229,
   FQN="llvm::CallGraphNode::stealCalledFunctionsFrom", NM="_ZN4llvm13CallGraphNode24stealCalledFunctionsFromEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode24stealCalledFunctionsFromEPS0_")
  //</editor-fold>
  public void stealCalledFunctionsFrom(CallGraphNode /*P*/ N) {
    assert (CalledFunctions.empty()) : "Cannot steal callsite information if I already have some";
    std.swap(CalledFunctions, N.CalledFunctions);
  }


  /// \brief Adds a function to the list of functions called by this one.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::addCalledFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 236,
   FQN="llvm::CallGraphNode::addCalledFunction", NM="_ZN4llvm13CallGraphNode17addCalledFunctionENS_8CallSiteEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode17addCalledFunctionENS_8CallSiteEPS0_")
  //</editor-fold>
  public void addCalledFunction(CallSite CS, CallGraphNode /*P*/ M) {
    assert (!(CS.getInstruction() != null) || !(CS.getCalledFunction() != null) || !CS.getCalledFunction().isIntrinsic() || !IntrinsicGlobals.isLeaf(CS.getCalledFunction().getIntrinsicID()));
    CalledFunctions.emplace_back(new std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, CS.getInstruction(), M));
    M.AddRef();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::removeCallEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 244,
   FQN="llvm::CallGraphNode::removeCallEdge", NM="_ZN4llvm13CallGraphNode14removeCallEdgeEN9__gnu_cxx17__normal_iteratorIPSt4pairINS_6WeakVHEPS0_ESt6vectorIS6_SaIS6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode14removeCallEdgeEN9__gnu_cxx17__normal_iteratorIPSt4pairINS_6WeakVHEPS0_ESt6vectorIS6_SaIS6_EEEE")
  //</editor-fold>
  public void removeCallEdge(std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> I) {
    I.$arrow().second.DropRef();
    I.$star().$assign(CalledFunctions.back());
    CalledFunctions.pop_back();
  }


  /// \brief Removes the edge in the node for the specified call site.
  ///
  /// Note that this method takes linear time, so it should be used sparingly.

  /// removeCallEdgeFor - This method removes the edge in the node for the
  /// specified call site.  Note that this method takes linear time, so it
  /// should be used sparingly.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::removeCallEdgeFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 203,
   FQN="llvm::CallGraphNode::removeCallEdgeFor", NM="_ZN4llvm13CallGraphNode17removeCallEdgeForENS_8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode17removeCallEdgeForENS_8CallSiteE")
  //</editor-fold>
  public void removeCallEdgeFor(CallSite CS) {
    for (std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> I = CalledFunctions.begin();; I.$preInc()) {
      assert ($noteq___normal_iterator$C(I, CalledFunctions.end())) : "Cannot find callsite to remove!";
      if (I.$arrow().first.$Value$P() == CS.getInstruction()) {
        I.$arrow().second.DropRef();
        I.$star().$assign(CalledFunctions.back());
        CalledFunctions.pop_back();
        return;
      }
    }
  }


  /// \brief Removes all call edges from this node to the specified callee
  /// function.
  ///
  /// This takes more time to execute than removeCallEdgeTo, so it should not
  /// be used unless necessary.

  // removeAnyCallEdgeTo - This method removes any call edges from this node to
  // the specified callee function.  This takes more time to execute than
  // removeCallEdgeTo, so it should not be used unless necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::removeAnyCallEdgeTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 218,
   FQN="llvm::CallGraphNode::removeAnyCallEdgeTo", NM="_ZN4llvm13CallGraphNode19removeAnyCallEdgeToEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode19removeAnyCallEdgeToEPS0_")
  //</editor-fold>
  public void removeAnyCallEdgeTo(CallGraphNode /*P*/ Callee) {
    for (/*uint*/int i = 0, e = CalledFunctions.size(); i != e; ++i)  {
      if (CalledFunctions.$at(i).second == Callee) {
        Callee.DropRef();
        CalledFunctions.$at(i).$assign(CalledFunctions.back());
        CalledFunctions.pop_back();
        --i;
        --e;
      }
    }
  }


  /// \brief Removes one edge associated with a null callsite from this node to
  /// the specified callee function.

  /// removeOneAbstractEdgeTo - Remove one edge associated with a null callsite
  /// from this node to the specified callee function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::removeOneAbstractEdgeTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 230,
   FQN="llvm::CallGraphNode::removeOneAbstractEdgeTo", NM="_ZN4llvm13CallGraphNode23removeOneAbstractEdgeToEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode23removeOneAbstractEdgeToEPS0_")
  //</editor-fold>
  public void removeOneAbstractEdgeTo(CallGraphNode /*P*/ Callee) {
    for (std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> I = CalledFunctions.begin();; I.$preInc()) {
      assert ($noteq___normal_iterator$C(I, CalledFunctions.end())) : "Cannot find callee to remove!";
      final std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*&*/ CR = I.$star();
      if (CR.second == Callee && CR.first.$Value$P() == null) {
        Callee.DropRef();
        I.$star().$assign(CalledFunctions.back());
        CalledFunctions.pop_back();
        return;
      }
    }
  }


  /// \brief Replaces the edge in the node for the specified call site with a
  /// new one.
  ///
  /// Note that this method takes linear time, so it should be used sparingly.

  /// replaceCallEdge - This method replaces the edge in the node for the
  /// specified call site with a new one.  Note that this method takes linear
  /// time, so it should be used sparingly.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::replaceCallEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 246,
   FQN="llvm::CallGraphNode::replaceCallEdge", NM="_ZN4llvm13CallGraphNode15replaceCallEdgeENS_8CallSiteES1_PS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode15replaceCallEdgeENS_8CallSiteES1_PS0_")
  //</editor-fold>
  public void replaceCallEdge(CallSite CS,
                 CallSite NewCS, CallGraphNode /*P*/ NewNode) {
    for (std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> I = CalledFunctions.begin();; I.$preInc()) {
      assert ($noteq___normal_iterator$C(I, CalledFunctions.end())) : "Cannot find callsite to remove!";
      if (I.$arrow().first.$Value$P() == CS.getInstruction()) {
        I.$arrow().second.DropRef();
        I.$arrow().first.$assign(NewCS.getInstruction());
        I.$arrow().second = NewNode;
        NewNode.AddRef();
        return;
      }
    }
  }

/*private:*/
  /*friend  class CallGraph*/

  /*friend*/public/*private*/ AssertingVH<Function> F;

  private std.vector<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ >> CalledFunctions;

  /// \brief The number of times that this CallGraphNode occurs in the
  /// CalledFunctions array of this or other CallGraphNodes.
  private /*uint*/int NumReferences;

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::CallGraphNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 283,
   FQN="llvm::CallGraphNode::CallGraphNode", NM="_ZN4llvm13CallGraphNodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNodeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ CallGraphNode(final /*const*/ CallGraphNode /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 284,
   FQN="llvm::CallGraphNode::operator=", NM="_ZN4llvm13CallGraphNodeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNodeaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ CallGraphNode /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::DropRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 286,
   FQN="llvm::CallGraphNode::DropRef", NM="_ZN4llvm13CallGraphNode7DropRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode7DropRefEv")
  //</editor-fold>
  private void DropRef() {
    --NumReferences;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::AddRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 287,
   FQN="llvm::CallGraphNode::AddRef", NM="_ZN4llvm13CallGraphNode6AddRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode6AddRefEv")
  //</editor-fold>
  private void AddRef() {
    ++NumReferences;
  }


  /// \brief A special function that should only be used by the CallGraph class.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphNode::allReferencesDropped">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 290,
   FQN="llvm::CallGraphNode::allReferencesDropped", NM="_ZN4llvm13CallGraphNode20allReferencesDroppedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm13CallGraphNode20allReferencesDroppedEv")
  //</editor-fold>
  /*friend*/public/*private*/ void allReferencesDropped() {
    NumReferences = 0;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override Iterator<pairTypePtr<WeakVH, CallGraphNode>> iterator() { return new JavaIterator<>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", CalledFunctions=" + CalledFunctions // NOI18N
              + ", NumReferences=" + NumReferences; // NOI18N
  }
}
