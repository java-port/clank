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

package org.llvm.pass;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 144,
 FQN="llvm::AnalysisResolver", NM="_ZN4llvm16AnalysisResolverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolverE")
//</editor-fold>
public class AnalysisResolver implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::AnalysisResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 146,
   FQN="llvm::AnalysisResolver::AnalysisResolver", NM="_ZN4llvm16AnalysisResolverC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolverC1Ev")
  //</editor-fold>
  protected/*private*/ AnalysisResolver() { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::AnalysisResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 149,
   FQN="llvm::AnalysisResolver::AnalysisResolver", NM="_ZN4llvm16AnalysisResolverC1ERNS_13PMDataManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolverC1ERNS_13PMDataManagerE")
  //</editor-fold>
  public /*explicit*/ AnalysisResolver(final PMDataManager /*&*/ P) {
    // : AnalysisImpls(), PM(P) 
    //START JInit
    this.AnalysisImpls = new std.vector<std.pairPtrPtr</*const*/Object/*void P*/ , Pass /*P*/ >>(new std.pairPtrPtr</*const*/Object/*void P*/ , Pass /*P*/ >());
    this./*&*/PM=/*&*/P;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::getPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 151,
   FQN="llvm::AnalysisResolver::getPMDataManager", NM="_ZN4llvm16AnalysisResolver16getPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolver16getPMDataManagerEv")
  //</editor-fold>
  public /*inline*/ PMDataManager /*&*/ getPMDataManager() {
    return PM;
  }

  
  /// Find pass that is implementing PI.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::findImplPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 154,
   FQN="llvm::AnalysisResolver::findImplPass", NM="_ZN4llvm16AnalysisResolver12findImplPassEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolver12findImplPassEPKv")
  //</editor-fold>
  public Pass /*P*/ findImplPass(/*const*/Object/*void P*/ PI) {
    Pass /*P*/ ResultPass = null;
    for (final /*const*/std.pairPtrPtr</*const*/Object/*void P*/ , Pass /*P*/ > /*&*/ AnalysisImpl : AnalysisImpls) {
      if (AnalysisImpl.first == PI) {
        ResultPass = AnalysisImpl.second;
        break;
      }
    }
    return ResultPass;
  }

  
  /// Find pass that is implementing PI. Initialize pass for Function F.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::findImplPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1278,
   FQN="llvm::AnalysisResolver::findImplPass", NM="_ZN4llvm16AnalysisResolver12findImplPassEPNS_4PassEPKvRNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolver12findImplPassEPNS_4PassEPKvRNS_8FunctionE")
  //</editor-fold>
  public Pass /*P*/ findImplPass(Pass /*P*/ P, /*const*/Object/*void P*/ AnalysisPI, 
              final Function /*&*/ F) {
    return PM.getOnTheFlyPass(P, AnalysisPI, F);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::addAnalysisImplsPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 168,
   FQN="llvm::AnalysisResolver::addAnalysisImplsPair", NM="_ZN4llvm16AnalysisResolver20addAnalysisImplsPairEPKvPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolver20addAnalysisImplsPairEPKvPNS_4PassE")
  //</editor-fold>
  public void addAnalysisImplsPair(/*const*/Object/*void P*/ PI, Pass /*P*/ P) {
    if (findImplPass(PI) == P) {
      return;
    }
    std.pairPtrPtr</*const*/Object/*void P*/ , Pass /*P*/ > pir = std.make_pair_Ptr_Ptr(PI, P);
    AnalysisImpls.push_back_T$C$R(pir);
  }

  
  /// Clear cache that is used to connect a pass to the the analysis (PassInfo).
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::clearAnalysisImpls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 176,
   FQN="llvm::AnalysisResolver::clearAnalysisImpls", NM="_ZN4llvm16AnalysisResolver18clearAnalysisImplsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm16AnalysisResolver18clearAnalysisImplsEv")
  //</editor-fold>
  public void clearAnalysisImpls() {
    AnalysisImpls.clear();
  }

  
  /// Return analysis result or null if it doesn't exist.
  
  //===----------------------------------------------------------------------===//
  // NOTE: Is this the right place to define this method ?
  // getAnalysisIfAvailable - Return analysis result or null if it doesn't exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::getAnalysisIfAvailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1274,
   FQN="llvm::AnalysisResolver::getAnalysisIfAvailable", NM="_ZNK4llvm16AnalysisResolver22getAnalysisIfAvailableEPKvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm16AnalysisResolver22getAnalysisIfAvailableEPKvb")
  //</editor-fold>
  public Pass /*P*/ getAnalysisIfAvailable(/*const*/Object/*void P*/ ID, boolean dir) /*const*/ {
    return PM.findAnalysisPass(ID, dir);
  }

/*private:*/
  /// This keeps track of which passes implements the interfaces that are
  /// required by the current pass (to implement getAnalysis()).
  private std.vector<std.pairPtrPtr</*const*/Object/*void P*/ , Pass /*P*/ >> AnalysisImpls;
  
  /// PassManager that is used to resolve analysis info
  private final PMDataManager /*&*/ PM;
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisResolver::~AnalysisResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 144,
   FQN="llvm::AnalysisResolver::~AnalysisResolver", NM="_ZN4llvm16AnalysisResolverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm16AnalysisResolverD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AnalysisImpls.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "AnalysisImpls=" + AnalysisImpls // NOI18N
              + ", PM=" + "[PMDataManager]"; // NOI18N
  }
}
