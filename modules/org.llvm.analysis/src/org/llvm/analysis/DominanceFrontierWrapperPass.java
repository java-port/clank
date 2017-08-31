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

//<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 146,
 FQN="llvm::DominanceFrontierWrapperPass", NM="_ZN4llvm28DominanceFrontierWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28DominanceFrontierWrapperPassE")
//</editor-fold>
public class DominanceFrontierWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private DominanceFrontier DF;
/*public:*/
  public static final/*char*/Class<DominanceFrontierWrapperPass> ID = DominanceFrontierWrapperPass.class; // Pass ID, replacement for typeid
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::DominanceFrontierWrapperPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 29,
   FQN="llvm::DominanceFrontierWrapperPass::DominanceFrontierWrapperPass", NM="_ZN4llvm28DominanceFrontierWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28DominanceFrontierWrapperPassC1Ev")
  //</editor-fold>
  public DominanceFrontierWrapperPass() {
    // : FunctionPass(ID), DF() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::getDominanceFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 153,
   FQN="llvm::DominanceFrontierWrapperPass::getDominanceFrontier", NM="_ZN4llvm28DominanceFrontierWrapperPass20getDominanceFrontierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28DominanceFrontierWrapperPass20getDominanceFrontierEv")
  //</editor-fold>
  public DominanceFrontier /*&*/ getDominanceFrontier() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::getDominanceFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 154,
   FQN="llvm::DominanceFrontierWrapperPass::getDominanceFrontier", NM="_ZNK4llvm28DominanceFrontierWrapperPass20getDominanceFrontierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm28DominanceFrontierWrapperPass20getDominanceFrontierEv")
  //</editor-fold>
  public /*const*/ DominanceFrontier /*&*/ getDominanceFrontier$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 34,
   FQN="llvm::DominanceFrontierWrapperPass::releaseMemory", NM="_ZN4llvm28DominanceFrontierWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28DominanceFrontierWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 38,
   FQN="llvm::DominanceFrontierWrapperPass::runOnFunction", NM="_ZN4llvm28DominanceFrontierWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28DominanceFrontierWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ $Prm0)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 44,
   FQN="llvm::DominanceFrontierWrapperPass::getAnalysisUsage", NM="_ZNK4llvm28DominanceFrontierWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm28DominanceFrontierWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 49,
   FQN="llvm::DominanceFrontierWrapperPass::print", NM="_ZNK4llvm28DominanceFrontierWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm28DominanceFrontierWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    print(OS, (/*const*/ Module /*P*/ )null);
  }
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ $Prm1/*= null*/) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 54,
   FQN="llvm::DominanceFrontierWrapperPass::dump", NM="_ZNK4llvm28DominanceFrontierWrapperPass4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm28DominanceFrontierWrapperPass4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierWrapperPass::~DominanceFrontierWrapperPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 146,
   FQN="llvm::DominanceFrontierWrapperPass::~DominanceFrontierWrapperPass", NM="_ZN4llvm28DominanceFrontierWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28DominanceFrontierWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DF=" + DF // NOI18N
              + super.toString(); // NOI18N
  }
}
