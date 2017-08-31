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


/// This is a simple wrapper around an MDNode which provides a
/// higher-level interface by hiding the details of how alias analysis
/// information is encoded in its operands.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 213,
 FQN="(anonymous namespace)::TBAAStructTypeNode", NM="_ZN12_GLOBAL__N_118TBAAStructTypeNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_118TBAAStructTypeNodeE")
//</editor-fold>
public class TBAAStructTypeNode {
  /// This node should be created with createTBAAStructTypeNode.
  private /*const*/ MDNode /*P*/ Node;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::TBAAStructTypeNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 218,
   FQN="(anonymous namespace)::TBAAStructTypeNode::TBAAStructTypeNode", NM="_ZN12_GLOBAL__N_118TBAAStructTypeNodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_118TBAAStructTypeNodeC1Ev")
  //</editor-fold>
  public TBAAStructTypeNode() {
    // : Node(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::TBAAStructTypeNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 219,
   FQN="(anonymous namespace)::TBAAStructTypeNode::TBAAStructTypeNode", NM="_ZN12_GLOBAL__N_118TBAAStructTypeNodeC1EPKN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_118TBAAStructTypeNodeC1EPKN4llvm6MDNodeE")
  //</editor-fold>
  public /*explicit*/ TBAAStructTypeNode(/*const*/ MDNode /*P*/ N) {
    // : Node(N) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the MDNode for this TBAAStructTypeNode.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 222,
   FQN="(anonymous namespace)::TBAAStructTypeNode::getNode", NM="_ZNK12_GLOBAL__N_118TBAAStructTypeNode7getNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_118TBAAStructTypeNode7getNodeEv")
  //</editor-fold>
  public /*const*/ MDNode /*P*/ getNode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get this TBAAStructTypeNode's field in the type DAG with
  /// given offset. Update the offset to be relative to the field type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::getParent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 226,
   FQN="(anonymous namespace)::TBAAStructTypeNode::getParent", NM="_ZNK12_GLOBAL__N_118TBAAStructTypeNode9getParentERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_118TBAAStructTypeNode9getParentERy")
  //</editor-fold>
  public TBAAStructTypeNode getParent(final ulong$ref/*uint64_t &*/ Offset) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::TBAAStructTypeNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 213,
   FQN="(anonymous namespace)::TBAAStructTypeNode::TBAAStructTypeNode", NM="_ZN12_GLOBAL__N_118TBAAStructTypeNodeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_118TBAAStructTypeNodeC1EOS0_")
  //</editor-fold>
  public /*inline*/ TBAAStructTypeNode(JD$Move _dparam, final TBAAStructTypeNode /*&&*/$Prm0) {
    // : Node(static_cast<TBAAStructTypeNode &&>().Node) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 213,
   FQN="(anonymous namespace)::TBAAStructTypeNode::operator=", NM="_ZN12_GLOBAL__N_118TBAAStructTypeNodeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_118TBAAStructTypeNodeaSERKS0_")
  //</editor-fold>
  public /*inline*/ TBAAStructTypeNode /*&*/ $assign(final /*const*/ TBAAStructTypeNode /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTypeNode::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 213,
   FQN="(anonymous namespace)::TBAAStructTypeNode::operator=", NM="_ZN12_GLOBAL__N_118TBAAStructTypeNodeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_118TBAAStructTypeNodeaSEOS0_")
  //</editor-fold>
  public /*inline*/ TBAAStructTypeNode /*&*/ $assignMove(final TBAAStructTypeNode /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Node=" + Node; // NOI18N
  }
}
