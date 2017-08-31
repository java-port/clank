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


/// \brief The core module pass which does a post-order walk of the SCCs and
/// runs a CGSCC pass over each one.
///
/// Designed to allow composition of a CGSCCPass(Manager) and
/// a ModulePassManager. Note that this pass must be run with a module analysis
/// manager as it uses the LazyCallGraph analysis. It will also run the
/// \c CGSCCAnalysisManagerModuleProxy analysis prior to running the CGSCC
/// pass over the module to enable a \c FunctionAnalysisManager to be used
/// within this run safely.
/*template <typename CGSCCPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ModuleToPostOrderCGSCCPassAdaptor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 66,
 FQN="llvm::ModuleToPostOrderCGSCCPassAdaptor", NM="_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorE")
//</editor-fold>
public class ModuleToPostOrderCGSCCPassAdaptor</*typename*/ CGSCCPassT>  implements /*public*/ PassInfoMixin<ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> > {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToPostOrderCGSCCPassAdaptor::ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 70,
   FQN="llvm::ModuleToPostOrderCGSCCPassAdaptor::ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT>", NM="_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorC1ET_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorC1ET_b")
  //</editor-fold>
  public /*explicit*/ ModuleToPostOrderCGSCCPassAdaptor(CGSCCPassT Pass) {
    this(Pass, false);
  }
  public /*explicit*/ ModuleToPostOrderCGSCCPassAdaptor(CGSCCPassT Pass, boolean DebugLogging/*= false*/) {
    // : Pass(std::move(Pass)), DebugLogging(DebugLogging) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToPostOrderCGSCCPassAdaptor::ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 74,
   FQN="llvm::ModuleToPostOrderCGSCCPassAdaptor::ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT>", NM="_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorC1ERKNS_33ModuleToPostOrderCGSCCPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorC1ERKNS_33ModuleToPostOrderCGSCCPassAdaptorIT_EE")
  //</editor-fold>
  public ModuleToPostOrderCGSCCPassAdaptor(final /*const*/ ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> /*&*/ Arg) {
    // : Pass(Arg.Pass), DebugLogging(Arg.DebugLogging) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToPostOrderCGSCCPassAdaptor::ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 77,
   FQN="llvm::ModuleToPostOrderCGSCCPassAdaptor::ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT>", NM="_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorC1EONS_33ModuleToPostOrderCGSCCPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptorC1EONS_33ModuleToPostOrderCGSCCPassAdaptorIT_EE")
  //</editor-fold>
  public ModuleToPostOrderCGSCCPassAdaptor(JD$Move _dparam, final ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> /*&&*/Arg) {
    // : Pass(std::move(Arg.Pass)), DebugLogging(Arg.DebugLogging) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::swap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 79,
   FQN="llvm::swap", NM="_ZN4llvm4swapERNS_33ModuleToPostOrderCGSCCPassAdaptorIT_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm4swapERNS_33ModuleToPostOrderCGSCCPassAdaptorIT_EES4_")
  //</editor-fold>
  public static </*typename*/ CGSCCPassT> void swap(final ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> /*&*/ LHS, 
      final ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToPostOrderCGSCCPassAdaptor::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 85,
   FQN="llvm::ModuleToPostOrderCGSCCPassAdaptor::operator=", NM="_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptoraSENS_33ModuleToPostOrderCGSCCPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptoraSENS_33ModuleToPostOrderCGSCCPassAdaptorIT_EE")
  //</editor-fold>
  public ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> /*&*/ $assign(ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Runs the CGSCC pass across every SCC in the module.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToPostOrderCGSCCPassAdaptor::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 92,
   FQN="llvm::ModuleToPostOrderCGSCCPassAdaptor::run", NM="_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptor3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm33ModuleToPostOrderCGSCCPassAdaptor3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Module /*&*/ M, final AnalysisManager<Module>/*&*/ AM) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private CGSCCPassT Pass;
  private boolean DebugLogging;
  
  @Override public String toString() {
    return "" + "Pass=" + Pass // NOI18N
              + ", DebugLogging=" + DebugLogging // NOI18N
              + super.toString(); // NOI18N
  }
}
