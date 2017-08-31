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
// IntervalPartition - This class builds and holds an "interval partition" for
// a function.  This partition divides the control flow graph into a set of
// maximal intervals, as defined with the properties above.  Intuitively, an
// interval is a (possibly nonexistent) loop with a "tail" of non-looping
// nodes following it.
//
//<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 40,
 FQN="llvm::IntervalPartition", NM="_ZN4llvm17IntervalPartitionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartitionE")
//</editor-fold>
public class IntervalPartition extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  // JAVA: typedef std::map<BasicBlock *, Interval *> IntervalMapTy
//  public final class IntervalMapTy extends std.map<BasicBlock /*P*/ , Interval /*P*/ >{ };
  private std.mapPtrPtr<BasicBlock /*P*/ , Interval /*P*/ > IntervalMap;
  
  // JAVA: typedef std::vector<Interval *> IntervalListTy
//  public final class IntervalListTy extends std.vector<Interval /*P*/ >{ };
  private Interval /*P*/ RootInterval;
  private std.vector<Interval /*P*/ > Intervals;
/*public:*/
  public static final/*char*/Class<IntervalPartition> ID = IntervalPartition.class; // Pass identification, replacement for typeid
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::IntervalPartition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 51,
   FQN="llvm::IntervalPartition::IntervalPartition", NM="_ZN4llvm17IntervalPartitionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartitionC1Ev")
  //</editor-fold>
  public IntervalPartition() {
    // : FunctionPass(ID), IntervalMap(), RootInterval(null), Intervals() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // run - Calculate the interval partition for this function
  
  // IntervalPartition ctor - Build the first level interval partition for the
  // specified function...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 67,
   FQN="llvm::IntervalPartition::runOnFunction", NM="_ZN4llvm17IntervalPartition13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // IntervalPartition ctor - Build a reduced interval partition from an
  // existing interval graph.  This takes an additional boolean parameter to
  // distinguish it from a copy constructor.  Always pass in false for now.
  //
  
  // IntervalPartition ctor - Build a reduced interval partition from an
  // existing interval graph.  This takes an additional boolean parameter to
  // distinguish it from a copy constructor.  Always pass in false for now.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::IntervalPartition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 92,
   FQN="llvm::IntervalPartition::IntervalPartition", NM="_ZN4llvm17IntervalPartitionC1ERS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartitionC1ERS0_b")
  //</editor-fold>
  public IntervalPartition(final IntervalPartition /*&*/ IP, boolean $Prm1) {
    // : FunctionPass(ID), IntervalMap(), Intervals() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // print - Show contents in human readable format...
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 35,
   FQN="llvm::IntervalPartition::print", NM="_ZNK4llvm17IntervalPartition5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm17IntervalPartition5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ O) /*const*//* override*/ {
    print(O, (/*const*/ Module /*P*/ )null);
  }
  @Override public void print(final raw_ostream /*&*/ O, /*const*/ Module /*P*/ $Prm1/*= null*/) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // getRootInterval() - Return the root interval that contains the starting
  // block of the function.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::getRootInterval">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 69,
   FQN="llvm::IntervalPartition::getRootInterval", NM="_ZN4llvm17IntervalPartition15getRootIntervalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition15getRootIntervalEv")
  //</editor-fold>
  public /*inline*/ Interval /*P*/ getRootInterval() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // isDegeneratePartition() - Returns true if the interval partition contains
  // a single interval, and thus cannot be simplified anymore.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::isDegeneratePartition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 73,
   FQN="llvm::IntervalPartition::isDegeneratePartition", NM="_ZN4llvm17IntervalPartition21isDegeneratePartitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition21isDegeneratePartitionEv")
  //</editor-fold>
  public boolean isDegeneratePartition() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // TODO: isIrreducible - look for triangle graph.
  
  // getBlockInterval - Return the interval that a basic block exists in.
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::getBlockInterval">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 78,
   FQN="llvm::IntervalPartition::getBlockInterval", NM="_ZN4llvm17IntervalPartition16getBlockIntervalEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition16getBlockIntervalEPNS_10BasicBlockE")
  //</editor-fold>
  public /*inline*/ Interval /*P*/ getBlockInterval(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // getAnalysisUsage - Implement the Pass API
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 84,
   FQN="llvm::IntervalPartition::getAnalysisUsage", NM="_ZNK4llvm17IntervalPartition16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm17IntervalPartition16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Interface to Intervals vector...
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::getIntervals">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 89,
   FQN="llvm::IntervalPartition::getIntervals", NM="_ZNK4llvm17IntervalPartition12getIntervalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm17IntervalPartition12getIntervalsEv")
  //</editor-fold>
  public /*const*/std.vector<Interval /*P*/ > /*&*/ getIntervals() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // releaseMemory - Reset state back to before function was analyzed
  
  //===----------------------------------------------------------------------===//
  // IntervalPartition Implementation
  //===----------------------------------------------------------------------===//
  
  // releaseMemory - Reset state back to before function was analyzed
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 27,
   FQN="llvm::IntervalPartition::releaseMemory", NM="_ZN4llvm17IntervalPartition13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  // addIntervalToPartition - Add an interval to the internal list of intervals,
  // and then add mappings from all of the basic blocks in the interval to the
  // interval itself (in the IntervalMap).
  //
  
  // addIntervalToPartition - Add an interval to the internal list of intervals,
  // and then add mappings from all of the basic blocks in the interval to the
  // interval itself (in the IntervalMap).
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::addIntervalToPartition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 44,
   FQN="llvm::IntervalPartition::addIntervalToPartition", NM="_ZN4llvm17IntervalPartition22addIntervalToPartitionEPNS_8IntervalE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition22addIntervalToPartitionEPNS_8IntervalE")
  //</editor-fold>
  private void addIntervalToPartition(Interval /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // updatePredecessors - Interval generation only sets the successor fields of
  // the interval data structures.  After interval generation is complete,
  // run through all of the intervals and propagate successor info as
  // predecessor info.
  //
  
  // updatePredecessors - Interval generation only sets the successor fields of
  // the interval data structures.  After interval generation is complete,
  // run through all of the intervals and propagate successor info as
  // predecessor info.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::updatePredecessors">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 58,
   FQN="llvm::IntervalPartition::updatePredecessors", NM="_ZN4llvm17IntervalPartition18updatePredecessorsEPNS_8IntervalE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartition18updatePredecessorsEPNS_8IntervalE")
  //</editor-fold>
  private void updatePredecessors(Interval /*P*/ Int) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalPartition::~IntervalPartition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalPartition.h", line = 40,
   FQN="llvm::IntervalPartition::~IntervalPartition", NM="_ZN4llvm17IntervalPartitionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17IntervalPartitionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "IntervalMap=" + IntervalMap // NOI18N
              + ", RootInterval=" + RootInterval // NOI18N
              + ", Intervals=" + Intervals // NOI18N
              + super.toString(); // NOI18N
  }
}
