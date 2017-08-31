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


/// A wrapper analysis pass for the legacy pass manager that exposes a \c
/// MemoryDepnedenceResults instance.
//<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 487,
 FQN="llvm::MemoryDependenceWrapperPass", NM="_ZN4llvm27MemoryDependenceWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm27MemoryDependenceWrapperPassE")
//</editor-fold>
public class MemoryDependenceWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private Optional<MemoryDependenceResults> MemDep;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass::MemoryDependenceWrapperPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1684,
   FQN="llvm::MemoryDependenceWrapperPass::MemoryDependenceWrapperPass", NM="_ZN4llvm27MemoryDependenceWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm27MemoryDependenceWrapperPassC1Ev")
  //</editor-fold>
  public MemoryDependenceWrapperPass() {
    // : FunctionPass(ID), MemDep() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass::~MemoryDependenceWrapperPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1687,
   FQN="llvm::MemoryDependenceWrapperPass::~MemoryDependenceWrapperPass", NM="_ZN4llvm27MemoryDependenceWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm27MemoryDependenceWrapperPassD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static final/*char*/Class<MemoryDependenceWrapperPass> ID = MemoryDependenceWrapperPass.class;
  
  /// Pass Implementation stuff.  This doesn't do any analysis eagerly.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1701,
   FQN="llvm::MemoryDependenceWrapperPass::runOnFunction", NM="_ZN4llvm27MemoryDependenceWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm27MemoryDependenceWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Clean up memory in between runs
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1689,
   FQN="llvm::MemoryDependenceWrapperPass::releaseMemory", NM="_ZN4llvm27MemoryDependenceWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm27MemoryDependenceWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Does not modify anything.  It uses Value Numbering and Alias Analysis.
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1693,
   FQN="llvm::MemoryDependenceWrapperPass::getAnalysisUsage", NM="_ZNK4llvm27MemoryDependenceWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm27MemoryDependenceWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MemoryDependenceWrapperPass::getMemDep">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 503,
   FQN="llvm::MemoryDependenceWrapperPass::getMemDep", NM="_ZN4llvm27MemoryDependenceWrapperPass9getMemDepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm27MemoryDependenceWrapperPass9getMemDepEv")
  //</editor-fold>
  public MemoryDependenceResults /*&*/ getMemDep() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "MemDep=" + MemDep // NOI18N
              + super.toString(); // NOI18N
  }
}
