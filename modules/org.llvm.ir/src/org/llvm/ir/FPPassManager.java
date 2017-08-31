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

package org.llvm.ir;

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
import org.llvm.adt.java.ADTJavaDifferentiators.JD$Timer$P;


//===----------------------------------------------------------------------===//
// FPPassManager
//
/// FPPassManager manages BBPassManagers and FunctionPasses.
/// It batches all function passes and basic block pass managers together and
/// sequence them to process one function at a time before processing next
/// function.
//<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 446,
 FQN="llvm::FPPassManager", NM="_ZN4llvm13FPPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManagerE")
//</editor-fold>
public class FPPassManager extends /*public*/ ModulePass implements /*public*/ PMDataManager, Destructors.ClassWithDestructor {
/*public:*/

  //===----------------------------------------------------------------------===//
  // FPPassManager implementation
  public static final/*char*/Class<FPPassManager> ID = FPPassManager.class;
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::FPPassManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 449,
   FQN="llvm::FPPassManager::FPPassManager", NM="_ZN4llvm13FPPassManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManagerC1Ev")
  //</editor-fold>
  public /*explicit*/ FPPassManager() {
    // : ModulePass(ID), PMDataManager()
    //START JInit
    super(ID);
    this.PMDataManager$Flds = $PMDataManager();
    //END JInit
  }


  /// run - Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the module, and if so, return true.

  /// Execute all of the passes scheduled for execution by invoking
  /// runOnFunction method.  Keep track of whether any of the passes modifies
  /// the function, and if so, return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::runOnFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1504,
   FQN="llvm::FPPassManager::runOnFunction", NM="_ZN4llvm13FPPassManager13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  public boolean runOnFunction(final Function /*&*/ F) {
    if (F.isDeclaration()) {
      return false;
    }

    boolean Changed = false;

    // Collect inherited analysis from Module level pass manager.
    populateInheritedAnalysis(/*J:ToBase*/$PMDataManager$Fields().TPM.$PMTopLevelManager$Fields().activeStack);

    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      FunctionPass /*P*/ FP = getContainedPass(Index);
      boolean LocalChanged = false;

      dumpPassInfo(FP, PassDebuggingString.EXECUTION_MSG, PassDebuggingString.ON_FUNCTION_MSG, F.getName());
      dumpRequiredSet(FP);

      initializeAnalysisImpl(FP);
      {
        PassManagerPrettyStackEntry X = null;
        TimeRegion PassTimer = null;
        try {
          X/*J*/= new PassManagerPrettyStackEntry(FP, F);
          PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, IrLlvmGlobals.getPassTimer(FP));

          LocalChanged |= FP.runOnFunction(F);
        } finally {
          if (PassTimer != null) { PassTimer.$destroy(); }
          if (X != null) { X.$destroy(); }
        }
      }

      Changed |= LocalChanged;
      if (LocalChanged) {
        dumpPassInfo(FP, PassDebuggingString.MODIFICATION_MSG, PassDebuggingString.ON_FUNCTION_MSG, F.getName());
      }
      dumpPreservedSet(FP);
      dumpUsedSet(FP);

      verifyPreservedAnalysis(FP);
      removeNotPreservedAnalysis(FP);
      recordAvailableAnalysis(FP);
      removeDeadPasses(FP, F.getName(), PassDebuggingString.ON_FUNCTION_MSG);
    }
    return Changed;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1543,
   FQN="llvm::FPPassManager::runOnModule", NM="_ZN4llvm13FPPassManager11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean runOnModule(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;

    for (final Function /*&*/ F : M)  {
      Changed |= runOnFunction(F);
    }

    return Changed;
  }


  /// cleanup - After running all passes, clean up pass manager cache.

  /// cleanup - After running all passes, clean up pass manager cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::cleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1446,
   FQN="llvm::FPPassManager::cleanup", NM="_ZN4llvm13FPPassManager7cleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager7cleanupEv")
  //</editor-fold>
  public void cleanup() {
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      FunctionPass /*P*/ FP = getContainedPass(Index);
      AnalysisResolver /*P*/ AR = FP.getResolver();
      assert ((AR != null)) : "Analysis Resolver is not set";
      AR.clearAnalysisImpls();
    }
  }


  /// doInitialization - Overrides ModulePass doInitialization for global
  /// initialization tasks
  ///
  //JAVA: using ModulePass::doInitialization;

  /// doInitialization - Run all of the initializers for the function passes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1552,
   FQN="llvm::FPPassManager::doInitialization", NM="_ZN4llvm13FPPassManager16doInitializationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager16doInitializationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doInitialization(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;

    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index)  {
      Changed |= getContainedPass(Index).doInitialization(M);
    }

    return Changed;
  }


  /// doFinalization - Overrides ModulePass doFinalization for global
  /// finalization tasks
  ///
  //JAVA: using ModulePass::doFinalization;

  /// doFinalization - Run all of the finalizers for the function passes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1561,
   FQN="llvm::FPPassManager::doFinalization", NM="_ZN4llvm13FPPassManager14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;

    for (int Index = getNumContainedPasses() - 1; Index >= 0; --Index)  {
      Changed |= getContainedPass(Index).doFinalization(M);
    }

    return Changed;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 478,
   FQN="llvm::FPPassManager::getAsPMDataManager", NM="_ZN4llvm13FPPassManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 479,
   FQN="llvm::FPPassManager::getAsPass", NM="_ZN4llvm13FPPassManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    return this;
  }


  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 482,
   FQN="llvm::FPPassManager::getAnalysisUsage", NM="_ZNK4llvm13FPPassManager16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13FPPassManager16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    Info.setPreservesAll();
  }


  // Print passes managed by this manager
  /// Print passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::dumpPassStructure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1491,
   FQN="llvm::FPPassManager::dumpPassStructure", NM="_ZN4llvm13FPPassManager17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager17dumpPassStructureEj")
  //</editor-fold>
  @Override public void dumpPassStructure(/*uint*/int Offset)/* override*/ {
    dbgs().indent(Offset * 2).$out(/*KEEP_STR*/"FunctionPass Manager\n");
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      FunctionPass /*P*/ FP = getContainedPass(Index);
      FP.dumpPassStructure(Offset + 1);
      dumpLastUses(FP, Offset + 1);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 489,
   FQN="llvm::FPPassManager::getPassName", NM="_ZNK4llvm13FPPassManager11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13FPPassManager11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    return $("Function Pass Manager");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::getContainedPass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 493,
   FQN="llvm::FPPassManager::getContainedPass", NM="_ZN4llvm13FPPassManager16getContainedPassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManager16getContainedPassEj")
  //</editor-fold>
  public FunctionPass /*P*/ getContainedPass(/*uint*/int N) {
    assert ($less_uint(N, /*J:ToBase*/$PMDataManager$Fields().PassVector.size())) : "Pass number out of range!";
    FunctionPass /*P*/ FP = ((/*static_cast*/FunctionPass /*P*/ )(/*J:ToBase*/$PMDataManager$Fields().PassVector.$at(N)));
    return FP;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 499,
   FQN="llvm::FPPassManager::getPassManagerType", NM="_ZNK4llvm13FPPassManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13FPPassManager18getPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_FunctionPassManager;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPPassManager::~FPPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 446,
   FQN="llvm::FPPassManager::~FPPassManager", NM="_ZN4llvm13FPPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13FPPassManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    PMDataManager.super.$destroy$PMDataManager();
  }


  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
