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

package org.llvm.transforms.utils;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.analysis.AssumptionCacheTracker;
import org.llvm.analysis.CallGraph;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.transforms.java.TransformDummies.*;


/// InlineFunctionInfo - This class captures the data input to the
/// InlineFunction call, and records the auxiliary results produced by it.
//<editor-fold defaultstate="collapsed" desc="llvm::InlineFunctionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/Cloning.h", line = 176,
 FQN="llvm::InlineFunctionInfo", NM="_ZN4llvm18InlineFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm18InlineFunctionInfoE")
//</editor-fold>
public class InlineFunctionInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineFunctionInfo::InlineFunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/Cloning.h", line = 178,
   FQN="llvm::InlineFunctionInfo::InlineFunctionInfo", NM="_ZN4llvm18InlineFunctionInfoC1EPNS_9CallGraphEPNS_22AssumptionCacheTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm18InlineFunctionInfoC1EPNS_9CallGraphEPNS_22AssumptionCacheTrackerE")
  //</editor-fold>
  public /*explicit*/ InlineFunctionInfo() {
    this((CallGraph /*P*/ )null,
      (AssumptionCacheTracker /*P*/ )null);
  }
  public /*explicit*/ InlineFunctionInfo(CallGraph /*P*/ cg/*= null*/) {
    this(cg,
      (AssumptionCacheTracker /*P*/ )null);
  }
  public /*explicit*/ InlineFunctionInfo(CallGraph /*P*/ cg/*= null*/,
      AssumptionCacheTracker /*P*/ ACT/*= null*/) {
    // : CG(cg), ACT(ACT), StaticAllocas(), InlinedCalls()
    //START JInit
    this.CG = cg;
    this.ACT = ACT;
    this.StaticAllocas = new SmallVector<AllocaInst /*P*/ >(4, (AllocaInst /*P*/ )null);
    this.InlinedCalls = new SmallVector<WeakVH>(8, new WeakVH());
    //END JInit
  }


  /// CG - If non-null, InlineFunction will update the callgraph to reflect the
  /// changes it makes.
  public CallGraph /*P*/ CG;
  public AssumptionCacheTracker /*P*/ ACT;

  /// StaticAllocas - InlineFunction fills this in with all static allocas that
  /// get copied into the caller.
  public SmallVector<AllocaInst /*P*/ > StaticAllocas;

  /// InlinedCalls - InlineFunction fills this in with callsites that were
  /// inlined from the callee.  This is only filled in if CG is non-null.
  public SmallVector<WeakVH> InlinedCalls;

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineFunctionInfo::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/Cloning.h", line = 195,
   FQN="llvm::InlineFunctionInfo::reset", NM="_ZN4llvm18InlineFunctionInfo5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm18InlineFunctionInfo5resetEv")
  //</editor-fold>
  public void reset() {
    StaticAllocas.clear();
    InlinedCalls.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineFunctionInfo::~InlineFunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/Cloning.h", line = 176,
   FQN="llvm::InlineFunctionInfo::~InlineFunctionInfo", NM="_ZN4llvm18InlineFunctionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm18InlineFunctionInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    InlinedCalls.$destroy();
    StaticAllocas.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "CG=" + CG // NOI18N
              + ", ACT=" + ACT // NOI18N
              + ", StaticAllocas=" + StaticAllocas // NOI18N
              + ", InlinedCalls=" + InlinedCalls; // NOI18N
  }
}
