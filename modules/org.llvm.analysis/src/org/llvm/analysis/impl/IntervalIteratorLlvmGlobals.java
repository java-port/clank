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
package org.llvm.analysis.impl;

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


//<editor-fold defaultstate="collapsed" desc="static type IntervalIteratorLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.IntervalIteratorLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13getNodeHeaderEPNS_10BasicBlockE;_ZN4llvm13getNodeHeaderEPNS_8IntervalE;_ZN4llvm13intervals_endEPNS_8FunctionE;_ZN4llvm13intervals_endERNS_17IntervalPartitionE;_ZN4llvm15intervals_beginEPNS_8FunctionEb;_ZN4llvm15intervals_beginERNS_17IntervalPartitionEb;_ZN4llvm17addNodeToIntervalEPNS_8IntervalEPNS_10BasicBlockE;_ZN4llvm17addNodeToIntervalEPNS_8IntervalES1_;_ZN4llvm18getSourceGraphNodeEPNS_17IntervalPartitionEPNS_10BasicBlockE;_ZN4llvm18getSourceGraphNodeEPNS_8FunctionEPNS_10BasicBlockE; -static-type=IntervalIteratorLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class IntervalIteratorLlvmGlobals {


// getNodeHeader - Given a source graph node and the source graph, return the
// BasicBlock that is the header node.  This is the opposite of
// getSourceGraphNode.
//
//<editor-fold defaultstate="collapsed" desc="llvm::getNodeHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 49,
 FQN="llvm::getNodeHeader", NM="_ZN4llvm13getNodeHeaderEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13getNodeHeaderEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ getNodeHeader(BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::getNodeHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 50,
 FQN="llvm::getNodeHeader", NM="_ZN4llvm13getNodeHeaderEPNS_8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13getNodeHeaderEPNS_8IntervalE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ getNodeHeader(Interval /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


// getSourceGraphNode - Given a BasicBlock and the source graph, return the
// source graph node that corresponds to the BasicBlock.  This is the opposite
// of getNodeHeader.
//
//<editor-fold defaultstate="collapsed" desc="llvm::getSourceGraphNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 56,
 FQN="llvm::getSourceGraphNode", NM="_ZN4llvm18getSourceGraphNodeEPNS_8FunctionEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm18getSourceGraphNodeEPNS_8FunctionEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ getSourceGraphNode(Function /*P*/ $Prm0, BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::getSourceGraphNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 59,
 FQN="llvm::getSourceGraphNode", NM="_ZN4llvm18getSourceGraphNodeEPNS_17IntervalPartitionEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm18getSourceGraphNodeEPNS_17IntervalPartitionEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ Interval /*P*/ getSourceGraphNode(IntervalPartition /*P*/ IP, BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


// addNodeToInterval - This method exists to assist the generic ProcessNode
// with the task of adding a node to the new interval, depending on the
// type of the source node.  In the case of a CFG source graph (BasicBlock
// case), the BasicBlock itself is added to the interval.
//
//<editor-fold defaultstate="collapsed" desc="llvm::addNodeToInterval">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 68,
 FQN="llvm::addNodeToInterval", NM="_ZN4llvm17addNodeToIntervalEPNS_8IntervalEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17addNodeToIntervalEPNS_8IntervalEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ void addNodeToInterval(Interval /*P*/ Int, BasicBlock /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}


// addNodeToInterval - This method exists to assist the generic ProcessNode
// with the task of adding a node to the new interval, depending on the
// type of the source node.  In the case of a CFG source graph (BasicBlock
// case), the BasicBlock itself is added to the interval.  In the case of
// an IntervalPartition source graph (Interval case), all of the member
// BasicBlocks are added to the interval.
//
//<editor-fold defaultstate="collapsed" desc="llvm::addNodeToInterval">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 79,
 FQN="llvm::addNodeToInterval", NM="_ZN4llvm17addNodeToIntervalEPNS_8IntervalES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17addNodeToIntervalEPNS_8IntervalES1_")
//</editor-fold>
public static /*inline*/ void addNodeToInterval(Interval /*P*/ Int, Interval /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_begin">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 249,
 FQN="llvm::intervals_begin", NM="_ZN4llvm15intervals_beginEPNS_8FunctionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm15intervals_beginEPNS_8FunctionEb")
//</editor-fold>
public static /*inline*/ IntervalIterator<BasicBlock, Function> intervals_begin(Function /*P*/ F) {
  return intervals_begin(F, 
               true);
}
public static /*inline*/ IntervalIterator<BasicBlock, Function> intervals_begin(Function /*P*/ F, 
               boolean DeleteInts/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_end">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 253,
 FQN="llvm::intervals_end", NM="_ZN4llvm13intervals_endEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13intervals_endEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ IntervalIterator<BasicBlock, Function> intervals_end(Function /*P*/ $Prm0) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_begin">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 257,
 FQN="llvm::intervals_begin", NM="_ZN4llvm15intervals_beginERNS_17IntervalPartitionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm15intervals_beginERNS_17IntervalPartitionEb")
//</editor-fold>
public static /*inline*/ IntervalIterator<Interval, IntervalPartition> intervals_begin(final IntervalPartition /*&*/ IP) {
  return intervals_begin(IP, true);
}
public static /*inline*/ IntervalIterator<Interval, IntervalPartition> intervals_begin(final IntervalPartition /*&*/ IP, boolean DeleteIntervals/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_end">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 262,
 FQN="llvm::intervals_end", NM="_ZN4llvm13intervals_endERNS_17IntervalPartitionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13intervals_endERNS_17IntervalPartitionE")
//</editor-fold>
public static /*inline*/ IntervalIterator<Interval, IntervalPartition> intervals_end(final IntervalPartition /*&*/ IP) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class IntervalIteratorLlvmGlobals
