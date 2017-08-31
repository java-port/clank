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

package org.llvm.ir.legacy;

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
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;
import org.llvm.ir.legacy.impl.FunctionPassManagerImpl;


/// FunctionPassManager manages FunctionPasses and BasicBlockPassManagers.
//<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManager.h", line = 68,
 FQN="llvm::legacy::FunctionPassManager", NM="_ZN4llvm6legacy19FunctionPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManagerE")
//</editor-fold>
public class FunctionPassManager extends /*public*/ PassManagerBase implements Destructors.ClassWithDestructor {
/*public:*/
  /// FunctionPassManager ctor - This initializes the pass manager.  It needs,
  /// but does not take ownership of, the specified Module.

  //===----------------------------------------------------------------------===//
  // FunctionPassManager implementation

  /// Create new Function pass manager
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager::FunctionPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1375,
   FQN="llvm::legacy::FunctionPassManager::FunctionPassManager", NM="_ZN4llvm6legacy19FunctionPassManagerC1EPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManagerC1EPNS_6ModuleE")
  //</editor-fold>
  public FunctionPassManager(Module /*P*/ m) {
    // : PassManagerBase(), M(m)
    //START JInit
    super();
    this.M = m;
    //END JInit
    FPM = new FunctionPassManagerImpl();
    // FPM is the top level manager.
    FPM.setTopLevelManager(FPM);

    AnalysisResolver /*P*/ AR = new AnalysisResolver($Deref(FPM));
    FPM.setResolver(AR);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager::~FunctionPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1384,
   FQN="llvm::legacy::FunctionPassManager::~FunctionPassManager", NM="_ZN4llvm6legacy19FunctionPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManagerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)FPM);
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1388,
   FQN="llvm::legacy::FunctionPassManager::add", NM="_ZN4llvm6legacy19FunctionPassManager3addEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManager3addEPNS_4PassE")
  //</editor-fold>
  @Override public void add(Pass /*P*/ P)/* override*/ {
    FPM.add(P);
  }


  /// run - Execute all of the passes scheduled for execution.  Keep
  /// track of whether any of the passes modifies the function, and if
  /// so, return true.
  ///

  /// run - Execute all of the passes scheduled for execution.  Keep
  /// track of whether any of the passes modifies the function, and if
  /// so, return true.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1396,
   FQN="llvm::legacy::FunctionPassManager::run", NM="_ZN4llvm6legacy19FunctionPassManager3runERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManager3runERNS_8FunctionE")
  //</editor-fold>
  public boolean run(final Function /*&*/ F) {
    {
      std.error_code EC = F.materialize();
      if (EC.$bool()) {
        report_fatal_error($add_T$C$P_string(/*KEEP_STR*/"Error reading bitcode file: ", EC.message()));
      }
    }
    return FPM.run(F);
  }


  /// doInitialization - Run all of the initializers for the function passes.
  ///

  /// doInitialization - Run all of the initializers for the function passes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1405,
   FQN="llvm::legacy::FunctionPassManager::doInitialization", NM="_ZN4llvm6legacy19FunctionPassManager16doInitializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManager16doInitializationEv")
  //</editor-fold>
  public boolean doInitialization() {
    return FPM.doInitialization($Deref(M));
  }


  /// doFinalization - Run all of the finalizers for the function passes.
  ///

  /// doFinalization - Run all of the finalizers for the function passes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManager::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1411,
   FQN="llvm::legacy::FunctionPassManager::doFinalization", NM="_ZN4llvm6legacy19FunctionPassManager14doFinalizationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy19FunctionPassManager14doFinalizationEv")
  //</editor-fold>
  public boolean doFinalization() {
    return FPM.doFinalization($Deref(M));
  }

/*private:*/
  private FunctionPassManagerImpl /*P*/ FPM;
  private Module /*P*/ M;

  @Override public String toString() {
    return "" + "FPM=" + FPM // NOI18N
              + ", M=" + M // NOI18N
              + super.toString(); // NOI18N
  }
}
