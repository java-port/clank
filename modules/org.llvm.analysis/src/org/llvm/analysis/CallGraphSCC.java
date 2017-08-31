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
import org.llvm.adt.scc_iterator;
import org.llvm.ir.java.CallGraphNodeBase;
import org.llvm.ir.java.CallGraphSCCBase;


/// CallGraphSCC - This is a single SCC that a CallGraphSCCPass is run on.
//<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 89,
 FQN="llvm::CallGraphSCC", NM="_ZN4llvm12CallGraphSCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12CallGraphSCCE")
//</editor-fold>
public class CallGraphSCC implements CallGraphSCCBase, Destructors.ClassWithDestructor {
  private final /*const*/ CallGraph /*&*/ CG; // The call graph for this SCC.
  private Object/*void P*/ Context; // The CGPassManager object that is vending this.
  private std.vector<CallGraphNode /*P*/ > Nodes;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::CallGraphSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 95,
   FQN="llvm::CallGraphSCC::CallGraphSCC", NM="_ZN4llvm12CallGraphSCCC1ERNS_9CallGraphEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12CallGraphSCCC1ERNS_9CallGraphEPv")
  //</editor-fold>
  public CallGraphSCC(final CallGraph /*&*/ cg, Object/*void P*/ context) {
    // : CG(cg), Context(context), Nodes()
    //START JInit
    this./*&*/CG=/*&*/cg;
    this.Context = context;
    this.Nodes = new std.vector<CallGraphNode /*P*/ >((CallGraphNode /*P*/ )null);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 97,
   FQN="llvm::CallGraphSCC::initialize", NM="_ZN4llvm12CallGraphSCC10initializeEPKPNS_13CallGraphNodeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12CallGraphSCC10initializeEPKPNS_13CallGraphNodeES4_")
  //</editor-fold>
  public void initialize(type$ptr<CallGraphNode /*P*/ /*const*/ /*P*/> I, type$ptr<CallGraphNode /*P*/ /*const*/ /*P*/> E) {
    Nodes.assign$T(I, E);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::isSingular">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 101,
   FQN="llvm::CallGraphSCC::isSingular", NM="_ZNK4llvm12CallGraphSCC10isSingularEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12CallGraphSCC10isSingularEv")
  //</editor-fold>
  public boolean isSingular() /*const*/ {
    return Nodes.size() == 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 102,
   FQN="llvm::CallGraphSCC::size", NM="_ZNK4llvm12CallGraphSCC4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12CallGraphSCC4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Nodes.size();
  }


  /// ReplaceNode - This informs the SCC and the pass manager that the specified
  /// Old node has been deleted, and New is to be used in its place.

  //===----------------------------------------------------------------------===//
  // CallGraphSCC Implementation
  //===----------------------------------------------------------------------===//

  /// This informs the SCC and the pass manager that the specified
  /// Old node has been deleted, and New is to be used in its place.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::ReplaceNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 527,
   FQN="llvm::CallGraphSCC::ReplaceNode", NM="_ZN4llvm12CallGraphSCC11ReplaceNodeEPNS_13CallGraphNodeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12CallGraphSCC11ReplaceNodeEPNS_13CallGraphNodeES2_")
  //</editor-fold>
  public void ReplaceNode(CallGraphNode /*P*/ Old, CallGraphNode /*P*/ New) {
    assert (Old != New) : "Should not replace node with self";
    for (/*uint*/int i = 0;; ++i) {
      assert (i != Nodes.size()) : "Node not in SCC";
      if (Nodes.$at(i) != Old) {
        continue;
      }
      Nodes.$set(i, New);
      break;
    }

    // Update the active scc_iterator so that it doesn't contain dangling
    // pointers to the old CallGraphNode.
    scc_iterator<CallGraph /*P*/, CallGraphNode, CallGraphNode> /*P*/ CGI = (scc_iterator<CallGraph /*P*/, CallGraphNode, CallGraphNode> /*P*/ )Context;
    CGI.ReplaceNode(Old, New);
  }


  // JAVA: typedef std::vector<CallGraphNode *>::const_iterator iterator
//  public final class iterator extends std.vector.iterator</*const*/ CallGraphNode /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 109,
   FQN="llvm::CallGraphSCC::begin", NM="_ZNK4llvm12CallGraphSCC5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12CallGraphSCC5beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ CallGraphNode /*P*/ > begin() /*const*/ {
    return Nodes.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 110,
   FQN="llvm::CallGraphSCC::end", NM="_ZNK4llvm12CallGraphSCC3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm12CallGraphSCC3endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ CallGraphNode /*P*/ > end() /*const*/ {
    return Nodes.end$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::getCallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 112,
   FQN="llvm::CallGraphSCC::getCallGraph", NM="_ZN4llvm12CallGraphSCC12getCallGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12CallGraphSCC12getCallGraphEv")
  //</editor-fold>
  public /*const*/ CallGraph /*&*/ getCallGraph() {
    return CG;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCC::~CallGraphSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 89,
   FQN="llvm::CallGraphSCC::~CallGraphSCC", NM="_ZN4llvm12CallGraphSCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm12CallGraphSCCD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Nodes.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<CallGraphNodeBase> iterator() {
    final JavaIterator<CallGraphNode> delegate = new JavaIterator<CallGraphNode>(begin(), end());
    return new Iterator<CallGraphNodeBase>() {
      @Override
      public boolean hasNext() {
        return delegate.hasNext();
      }

      @Override
      public CallGraphNodeBase next() {
        return delegate.next();
      }
    };
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "CG=" + CG // NOI18N
              + ", Context=" + NativeTrace.getIdentityStr(Context) // NOI18N
              + ", Nodes=" + Nodes; // NOI18N
  }
}
