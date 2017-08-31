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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clank.java.std;

//<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 133,
 FQN="clang::CallGraphNode", NM="_ZN5clang13CallGraphNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang13CallGraphNodeE")
//</editor-fold>
public class CallGraphNode implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef CallGraphNode *CallRecord*/
//  public final class CallRecord extends CallGraphNode /*P*/ { };
/*private:*/
  /// \brief The function/method declaration.
  private Decl /*P*/ FD;
  
  /// \brief The list of functions called from this node.
  private SmallVector<CallGraphNode> CalledFunctions;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::CallGraphNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 145,
   FQN="clang::CallGraphNode::CallGraphNode", NM="_ZN5clang13CallGraphNodeC1EPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang13CallGraphNodeC1EPNS_4DeclE")
  //</editor-fold>
  public CallGraphNode(Decl /*P*/ D) {
    // : FD(D), CalledFunctions() 
    //START JInit
    this.FD = D;
    this.CalledFunctions = new SmallVector<CallGraphNode>(5, (CallGraphNode)null);
    //END JInit
  }

  
  /*typedef SmallVectorImpl<CallRecord>::iterator iterator*/
//  public final class iterator extends type$ptr<CallGraphNode/*P*/>{ };
  /*typedef SmallVectorImpl<CallRecord>::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr<CallGraphNode/*P*/>{ };
  
  /// Iterators through all the callees/children of the node.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 151,
   FQN="clang::CallGraphNode::begin", NM="_ZN5clang13CallGraphNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang13CallGraphNode5beginEv")
  //</editor-fold>
  public /*inline*/ type$ptr<CallGraphNode/*P*/> begin() {
    return CalledFunctions.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 152,
   FQN="clang::CallGraphNode::end", NM="_ZN5clang13CallGraphNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang13CallGraphNode3endEv")
  //</editor-fold>
  public /*inline*/ type$ptr<CallGraphNode/*P*/> end() {
    return CalledFunctions.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 153,
   FQN="clang::CallGraphNode::begin", NM="_ZNK5clang13CallGraphNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode5beginEv")
  //</editor-fold>
  public /*inline*/ type$ptr<CallGraphNode/*P*/> begin$Const() /*const*/ {
    return CalledFunctions.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 154,
   FQN="clang::CallGraphNode::end", NM="_ZNK5clang13CallGraphNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode3endEv")
  //</editor-fold>
  public /*inline*/ type$ptr<CallGraphNode/*P*/> end$Const() /*const*/ {
    return CalledFunctions.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 156,
   FQN="clang::CallGraphNode::empty", NM="_ZNK5clang13CallGraphNode5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode5emptyEv")
  //</editor-fold>
  public /*inline*/ boolean empty() /*const*/ {
    return CalledFunctions.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 157,
   FQN="clang::CallGraphNode::size", NM="_ZNK5clang13CallGraphNode4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode4sizeEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int size() /*const*/ {
    return CalledFunctions.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::addCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 159,
   FQN="clang::CallGraphNode::addCallee", NM="_ZN5clang13CallGraphNode9addCalleeEPS0_PNS_9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang13CallGraphNode9addCalleeEPS0_PNS_9CallGraphE")
  //</editor-fold>
  public void addCallee(CallGraphNode /*P*/ N, CallGraph /*P*/ CG) {
    CalledFunctions.push_back(N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 163,
   FQN="clang::CallGraphNode::getDecl", NM="_ZNK5clang13CallGraphNode7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode7getDeclEv")
  //</editor-fold>
  public Decl /*P*/ getDecl() /*const*/ {
    return FD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 199,
   FQN="clang::CallGraphNode::print", NM="_ZNK5clang13CallGraphNode5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ os) /*const*/ {
    {
      /*const*/ NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(FD);
      if ((ND != null)) {
        ND.printName(os);
        /*JAVA:return*/return;
      }
    }
    os.$out(/*KEEP_STR*/"< >");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 205,
   FQN="clang::CallGraphNode::dump", NM="_ZNK5clang13CallGraphNode4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang13CallGraphNode4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraphNode::~CallGraphNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 133,
   FQN="clang::CallGraphNode::~CallGraphNode", NM="_ZN5clang13CallGraphNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang13CallGraphNodeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CalledFunctions.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      print(OS);
      OS.flush();      
      return Buf.toJavaString();
    }    
    return "" + "FD=" + FD // NOI18N
              + ", CalledFunctions=" + CalledFunctions; // NOI18N
  }
}
