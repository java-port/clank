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
package org.clang.analysis.impl;

import org.clank.support.*;
import static org.clang.analysis.java.AnalysisMemberPointers.*;
import org.clang.analysis.analyses.threadSafety.til.*;


//<editor-fold defaultstate="collapsed" desc="static type ThreadSafetyTILStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZL13computeNodeIDPN5clang12threadSafety3til10BasicBlockEMS2_NS2_12TopologyNodeE;_ZL15computeNodeSizePN5clang12threadSafety3til10BasicBlockEMS2_NS2_12TopologyNodeE; -static-type=ThreadSafetyTILStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ThreadSafetyTILStatics {

//<editor-fold defaultstate="collapsed" desc="computeNodeSize">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 269,
 FQN="computeNodeSize", NM="_ZL15computeNodeSizePN5clang12threadSafety3til10BasicBlockEMS2_NS2_12TopologyNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZL15computeNodeSizePN5clang12threadSafety3til10BasicBlockEMS2_NS2_12TopologyNodeE")
//</editor-fold>
public static /*inline*/ void computeNodeSize(BasicBlock /*P*/ B, 
               BasicBlock$TopologyNode TN) {
  BasicBlock.TopologyNode /*P*/ N = TN.$call(B);///*AddrOf*/(B ->* TN);
  if ((N.Parent != null)) {
    BasicBlock.TopologyNode /*P*/ P = TN.$call(N.Parent);///*AddrOf*/(N.Parent ->* TN);
    // Initially set ID relative to the (as yet uncomputed) parent ID
    N.NodeID = P.SizeOfSubTree;
    P.SizeOfSubTree += N.SizeOfSubTree;
  }
}

//<editor-fold defaultstate="collapsed" desc="computeNodeID">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 280,
 FQN="computeNodeID", NM="_ZL13computeNodeIDPN5clang12threadSafety3til10BasicBlockEMS2_NS2_12TopologyNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZL13computeNodeIDPN5clang12threadSafety3til10BasicBlockEMS2_NS2_12TopologyNodeE")
//</editor-fold>
public static /*inline*/ void computeNodeID(BasicBlock /*P*/ B, 
             BasicBlock$TopologyNode TN) {
  BasicBlock.TopologyNode /*P*/ N = TN.$call(B);///*AddrOf*/(B ->* TN);
  if ((N.Parent != null)) {
    BasicBlock.TopologyNode /*P*/ P = TN.$call(N.Parent);///*AddrOf*/(N.Parent ->* TN);
    N.NodeID += P.NodeID; // Fix NodeIDs relative to starting node.
  }
}

} // END OF class ThreadSafetyTILStatics
