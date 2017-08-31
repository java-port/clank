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
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 178,
 FQN="(anonymous namespace)::TBAAStructTagNode", NM="_ZN12_GLOBAL__N_117TBAAStructTagNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_117TBAAStructTagNodeE")
//</editor-fold>
public class TBAAStructTagNode {
  /// This node should be created with createTBAAStructTagNode.
  private /*const*/ MDNode /*P*/ Node;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode::TBAAStructTagNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 183,
   FQN="(anonymous namespace)::TBAAStructTagNode::TBAAStructTagNode", NM="_ZN12_GLOBAL__N_117TBAAStructTagNodeC1EPKN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN12_GLOBAL__N_117TBAAStructTagNodeC1EPKN4llvm6MDNodeE")
  //</editor-fold>
  public /*explicit*/ TBAAStructTagNode(/*const*/ MDNode /*P*/ N) {
    // : Node(N) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the MDNode for this TBAAStructTagNode.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 186,
   FQN="(anonymous namespace)::TBAAStructTagNode::getNode", NM="_ZNK12_GLOBAL__N_117TBAAStructTagNode7getNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_117TBAAStructTagNode7getNodeEv")
  //</editor-fold>
  public /*const*/ MDNode /*P*/ getNode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode::getBaseType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 188,
   FQN="(anonymous namespace)::TBAAStructTagNode::getBaseType", NM="_ZNK12_GLOBAL__N_117TBAAStructTagNode11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_117TBAAStructTagNode11getBaseTypeEv")
  //</editor-fold>
  public /*const*/ MDNode /*P*/ getBaseType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode::getAccessType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 191,
   FQN="(anonymous namespace)::TBAAStructTagNode::getAccessType", NM="_ZNK12_GLOBAL__N_117TBAAStructTagNode13getAccessTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_117TBAAStructTagNode13getAccessTypeEv")
  //</editor-fold>
  public /*const*/ MDNode /*P*/ getAccessType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode::getOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 194,
   FQN="(anonymous namespace)::TBAAStructTagNode::getOffset", NM="_ZNK12_GLOBAL__N_117TBAAStructTagNode9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_117TBAAStructTagNode9getOffsetEv")
  //</editor-fold>
  public long/*uint64_t*/ getOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// TypeIsImmutable - Test if this TBAAStructTagNode represents a type for
  /// objects which are not modified (by any means) in the context where this
  /// AliasAnalysis is relevant.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TBAAStructTagNode::TypeIsImmutable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 200,
   FQN="(anonymous namespace)::TBAAStructTagNode::TypeIsImmutable", NM="_ZNK12_GLOBAL__N_117TBAAStructTagNode15TypeIsImmutableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK12_GLOBAL__N_117TBAAStructTagNode15TypeIsImmutableEv")
  //</editor-fold>
  public boolean TypeIsImmutable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Node=" + Node; // NOI18N
  }
}
