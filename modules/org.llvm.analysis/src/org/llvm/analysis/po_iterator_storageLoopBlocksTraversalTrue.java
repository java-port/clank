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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;


/// Specialize po_iterator_storage to record postorder numbers.
//<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<LoopBlocksTraversal, true>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 112,
 FQN="llvm::po_iterator_storage<LoopBlocksTraversal, true>", NM="_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEE")
//</editor-fold>
public class po_iterator_storageLoopBlocksTraversalTrue {
  private final LoopBlocksTraversal /*&*/ LBT;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<LoopBlocksTraversal, true>::po_iterator_storage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 115,
   FQN="llvm::po_iterator_storage<LoopBlocksTraversal, true>::po_iterator_storage", NM="_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEC1ERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEC1ERS1_")
  //</editor-fold>
  public po_iterator_storageLoopBlocksTraversalTrue(final LoopBlocksTraversal /*&*/ lbs) {
    // : LBT(lbs) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  // These functions are defined below.
  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<LoopBlocksTraversal, true>::insertEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 169,
   FQN="llvm::po_iterator_storage<LoopBlocksTraversal, true>::insertEdge", NM="_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EE10insertEdgeEPNS_10BasicBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EE10insertEdgeEPNS_10BasicBlockES4_")
  //</editor-fold>
  public /*inline*/ boolean insertEdge(BasicBlock /*P*/ From, BasicBlock /*P*/ To) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<LoopBlocksTraversal, true>::finishPostorder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 174,
   FQN="llvm::po_iterator_storage<LoopBlocksTraversal, true>::finishPostorder", NM="_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EE15finishPostorderEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EE15finishPostorderEPNS_10BasicBlockE")
  //</editor-fold>
  public /*inline*/ void finishPostorder(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<LoopBlocksTraversal, true>::po_iterator_storage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 112,
   FQN="llvm::po_iterator_storage<LoopBlocksTraversal, true>::po_iterator_storage", NM="_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEC1ERKS2_")
  //</editor-fold>
  public /*inline*/ po_iterator_storageLoopBlocksTraversalTrue(final /*const*/ po_iterator_storageLoopBlocksTraversalTrue /*&*/ $Prm0) {
    // : LBT(.LBT) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::po_iterator_storage<LoopBlocksTraversal, true>::po_iterator_storage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopIterator.h", line = 112,
   FQN="llvm::po_iterator_storage<LoopBlocksTraversal, true>::po_iterator_storage", NM="_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm19po_iterator_storageINS_19LoopBlocksTraversalELb1EEC1EOS2_")
  //</editor-fold>
  public /*inline*/ po_iterator_storageLoopBlocksTraversalTrue(JD$Move _dparam, final po_iterator_storageLoopBlocksTraversalTrue /*&&*/$Prm0) {
    // : LBT(static_cast<po_iterator_storageLoopBlocksTraversalTrue &&>().LBT) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LBT=" + LBT; // NOI18N
  }
}
