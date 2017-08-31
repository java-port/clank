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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.ir.*;


//===----------------------------------------------------------------------===//
/// ImmutablePass class - This class is used to provide information that does
/// not need to be run.  This is useful for things like target information and
/// "basic" versions of AnalysisGroups.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutablePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 266,
 FQN="llvm::ImmutablePass", NM="_ZN4llvm13ImmutablePassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13ImmutablePassE")
//</editor-fold>
public class ImmutablePass extends /*public*/ ModulePass implements Destructors.ClassWithDestructor {
/*public:*/
  /// initializePass - This method may be overriden by immutable passes to allow
  /// them to perform various initialization actions they require.  This is
  /// primarily because an ImmutablePass can "require" another ImmutablePass,
  /// and if it does, the overloaded version of initializePass may get access to
  /// these passes with getAnalysis<>.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutablePass::initializePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 132,
   FQN="llvm::ImmutablePass::initializePass", NM="_ZN4llvm13ImmutablePass14initializePassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13ImmutablePass14initializePassEv")
  //</editor-fold>
  public void initializePass() {
    // By default, don't do anything.
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutablePass::getAsImmutablePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 276,
   FQN="llvm::ImmutablePass::getAsImmutablePass", NM="_ZN4llvm13ImmutablePass18getAsImmutablePassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13ImmutablePass18getAsImmutablePassEv")
  //</editor-fold>
  @Override public ImmutablePass /*P*/ getAsImmutablePass()/* override*/ {
    return this;
  }

  
  /// ImmutablePasses are never run.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutablePass::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 280,
   FQN="llvm::ImmutablePass::runOnModule", NM="_ZN4llvm13ImmutablePass11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13ImmutablePass11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module /*&*/ $Prm0)/* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutablePass::ImmutablePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 282,
   FQN="llvm::ImmutablePass::ImmutablePass", NM="_ZN4llvm13ImmutablePassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13ImmutablePassC1ERc")
  //</editor-fold>
  public /*explicit*/ ImmutablePass(final Class<? extends ImmutablePass>/*char &*/ pid) {
    // : ModulePass(pid) 
    //START JInit
    super(pid);
    //END JInit
  }

  
  // Force out-of-line virtual method.
  
  //===----------------------------------------------------------------------===//
  // ImmutablePass Implementation
  //
  // Force out-of-line virtual method.
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutablePass::~ImmutablePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 130,
   FQN="llvm::ImmutablePass::~ImmutablePass", NM="_ZN4llvm13ImmutablePassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13ImmutablePassD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
