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


//===----------------------------------------------------------------------===//
//
/// Interval Class - An Interval is a set of nodes defined such that every node
/// in the interval has all of its predecessors in the interval (except for the
/// header)
///
//<editor-fold defaultstate="collapsed" desc="llvm::Interval">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 37,
 FQN="llvm::Interval", NM="_ZN4llvm8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZN4llvm8IntervalE")
//</editor-fold>
public class Interval implements Destructors.ClassWithDestructor, Native.NativeComparable<Interval> {
  /// HeaderNode - The header BasicBlock, which dominates all BasicBlocks in this
  /// interval.  Also, any loops in this interval must go through the HeaderNode.
  ///
  private BasicBlock /*P*/ HeaderNode;
/*public:*/
  // JAVA: typedef std::vector<BasicBlock *>::iterator succ_iterator
//  public final class succ_iterator extends std.vector.iterator<BasicBlock /*P*/ >{ };
  // JAVA: typedef std::vector<BasicBlock *>::iterator pred_iterator
//  public final class pred_iterator extends std.vector.iterator<BasicBlock /*P*/ >{ };
  // JAVA: typedef std::vector<BasicBlock *>::iterator node_iterator
//  public final class node_iterator extends std.vector.iterator<BasicBlock /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::Interval">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 47,
   FQN="llvm::Interval::Interval", NM="_ZN4llvm8IntervalC1EPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZN4llvm8IntervalC1EPNS_10BasicBlockE")
  //</editor-fold>
  public /*inline*/ Interval(BasicBlock /*P*/ Header) {
    // : HeaderNode(Header), Nodes(), Successors(), Predecessors() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::getHeaderNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 51,
   FQN="llvm::Interval::getHeaderNode", NM="_ZNK4llvm8Interval13getHeaderNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZNK4llvm8Interval13getHeaderNodeEv")
  //</editor-fold>
  public /*inline*/ BasicBlock /*P*/ getHeaderNode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Nodes - The basic blocks in this interval.
  ///
  public std.vector<BasicBlock /*P*/ > Nodes;
  
  /// Successors - List of BasicBlocks that are reachable directly from nodes in
  /// this interval, but are not in the interval themselves.
  /// These nodes necessarily must be header nodes for other intervals.
  ///
  public std.vector<BasicBlock /*P*/ > Successors;
  
  /// Predecessors - List of BasicBlocks that have this Interval's header block
  /// as one of their successors.
  ///
  public std.vector<BasicBlock /*P*/ > Predecessors;
  
  /// contains - Find out if a basic block is in this interval
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 69,
   FQN="llvm::Interval::contains", NM="_ZNK4llvm8Interval8containsEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZNK4llvm8Interval8containsEPNS_10BasicBlockE")
  //</editor-fold>
  public /*inline*/ boolean contains(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isSuccessor - find out if a basic block is a successor of this Interval
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::isSuccessor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 79,
   FQN="llvm::Interval::isSuccessor", NM="_ZNK4llvm8Interval11isSuccessorEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZNK4llvm8Interval11isSuccessorEPNS_10BasicBlockE")
  //</editor-fold>
  public /*inline*/ boolean isSuccessor(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Equality operator.  It is only valid to compare two intervals from the
  /// same partition, because of this, all we have to check is the header node
  /// for equality.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 92,
   FQN="llvm::Interval::operator==", NM="_ZNK4llvm8IntervaleqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZNK4llvm8IntervaleqERKS0_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ Interval /*&*/ I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isLoop - Find out if there is a back edge in this interval...
  
  //===----------------------------------------------------------------------===//
  // Interval Implementation
  //===----------------------------------------------------------------------===//
  
  // isLoop - Find out if there is a back edge in this interval...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::isLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp", line = 29,
   FQN="llvm::Interval::isLoop", NM="_ZNK4llvm8Interval6isLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZNK4llvm8Interval6isLoopEv")
  //</editor-fold>
  public boolean isLoop() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// print - Show contents in human readable format...
  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp", line = 40,
   FQN="llvm::Interval::print", NM="_ZNK4llvm8Interval5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZNK4llvm8Interval5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Interval::~Interval">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 37,
   FQN="llvm::Interval::~Interval", NM="_ZN4llvm8IntervalD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm8IntervalD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "HeaderNode=" + HeaderNode // NOI18N
              + ", Nodes=" + Nodes // NOI18N
              + ", Successors=" + Successors // NOI18N
              + ", Predecessors=" + Predecessors; // NOI18N
  }
}
