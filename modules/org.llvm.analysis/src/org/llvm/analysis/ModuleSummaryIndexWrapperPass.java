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


/// Legacy wrapper pass to provide the ModuleSummaryIndex object.
//<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ModuleSummaryAnalysis.h", line = 59,
 FQN="llvm::ModuleSummaryIndexWrapperPass", NM="_ZN4llvm29ModuleSummaryIndexWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm29ModuleSummaryIndexWrapperPassE")
//</editor-fold>
public class ModuleSummaryIndexWrapperPass extends /*public*/ ModulePass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<ModuleSummaryIndexBuilder> IndexBuilder;
/*public:*/
  public static final/*char*/Class<ModuleSummaryIndexWrapperPass> ID = ModuleSummaryIndexWrapperPass.class;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::ModuleSummaryIndexWrapperPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 188,
   FQN="llvm::ModuleSummaryIndexWrapperPass::ModuleSummaryIndexWrapperPass", NM="_ZN4llvm29ModuleSummaryIndexWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm29ModuleSummaryIndexWrapperPassC1Ev")
  //</editor-fold>
  public ModuleSummaryIndexWrapperPass() {
    // : ModulePass(ID), IndexBuilder() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the index built by pass
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::getIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ModuleSummaryAnalysis.h", line = 68,
   FQN="llvm::ModuleSummaryIndexWrapperPass::getIndex", NM="_ZN4llvm29ModuleSummaryIndexWrapperPass8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm29ModuleSummaryIndexWrapperPass8getIndexEv")
  //</editor-fold>
  public ModuleSummaryIndex /*&*/ getIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::getIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ModuleSummaryAnalysis.h", line = 69,
   FQN="llvm::ModuleSummaryIndexWrapperPass::getIndex", NM="_ZNK4llvm29ModuleSummaryIndexWrapperPass8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm29ModuleSummaryIndexWrapperPass8getIndexEv")
  //</editor-fold>
  public /*const*/ ModuleSummaryIndex /*&*/ getIndex$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::runOnModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 193,
   FQN="llvm::ModuleSummaryIndexWrapperPass::runOnModule", NM="_ZN4llvm29ModuleSummaryIndexWrapperPass11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm29ModuleSummaryIndexWrapperPass11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module /*&*/ M)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 203,
   FQN="llvm::ModuleSummaryIndexWrapperPass::doFinalization", NM="_ZN4llvm29ModuleSummaryIndexWrapperPass14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm29ModuleSummaryIndexWrapperPass14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module /*&*/ M)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 208,
   FQN="llvm::ModuleSummaryIndexWrapperPass::getAnalysisUsage", NM="_ZNK4llvm29ModuleSummaryIndexWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZNK4llvm29ModuleSummaryIndexWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSummaryIndexWrapperPass::~ModuleSummaryIndexWrapperPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ModuleSummaryAnalysis.h", line = 59,
   FQN="llvm::ModuleSummaryIndexWrapperPass::~ModuleSummaryIndexWrapperPass", NM="_ZN4llvm29ModuleSummaryIndexWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm29ModuleSummaryIndexWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "IndexBuilder=" + "[Unique_ptr$ModuleSummaryIndexBuilder]" // NOI18N
              + super.toString(); // NOI18N
  }
}
