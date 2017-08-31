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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import org.clank.java.stdimpl.aliases.StdMapPtrPtr;
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
import org.llvm.adt.java.ADTJavaDifferentiators.*;
import static org.llvm.ir.impl.IRPrintingPassesLlvmGlobals.createPrintModulePass;
import org.llvm.ir.legacy.impl.FunctionPassManagerImpl;

//===----------------------------------------------------------------------===//
// MPPassManager
//
/// MPPassManager manages ModulePasses and function pass managers.
/// It batches all Module passes and function pass managers together and
/// sequences them to process one module.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 301,
 FQN="(anonymous namespace)::MPPassManager", NM="_ZN12_GLOBAL__N_113MPPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManagerE")
//</editor-fold>
public class MPPassManager extends /*public*/ Pass implements /*public*/ PMDataManager, Destructors.ClassWithDestructor {
/*public:*/
  public static final/*char*/Class<MPPassManager> ID = org.llvm.ir.impl.MPPassManager.class;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::MPPassManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 304,
   FQN="(anonymous namespace)::MPPassManager::MPPassManager", NM="_ZN12_GLOBAL__N_113MPPassManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManagerC1Ev")
  //</editor-fold>
  public /*explicit*/ MPPassManager() {
    // : Pass(PT_PassManager, ID), PMDataManager(), OnTheFlyManagers()
    //START JInit
    super(PassKind.PT_PassManager, ID);
    this.PMDataManager$Flds = $PMDataManager();
    this.OnTheFlyManagers = new std.mapPtrPtr<Pass /*P*/ , FunctionPassManagerImpl /*P*/ >();
    //END JInit
  }


  // Delete on the fly managers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::~MPPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 308,
   FQN="(anonymous namespace)::MPPassManager::~MPPassManager", NM="_ZN12_GLOBAL__N_113MPPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManagerD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    for (final std.pairPtrPtr<Pass /*P*/ /*const*/, FunctionPassManagerImpl /*P*/ > /*&*/ OnTheFlyManager : OnTheFlyManagers) {
      FunctionPassManagerImpl /*P*/ FPP = OnTheFlyManager.second;
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)FPP);
    }
    //START JDestroy
    OnTheFlyManagers.$destroy();
    super.$destroy();
    PMDataManager.super.$destroy$PMDataManager();
    //END JDestroy
  }


  /// createPrinterPass - Get a module printer pass.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 316,
   FQN="(anonymous namespace)::MPPassManager::createPrinterPass", NM="_ZNK12_GLOBAL__N_113MPPassManager17createPrinterPassERN4llvm11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113MPPassManager17createPrinterPassERN4llvm11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O,
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    return createPrintModulePass(O, Banner);
  }


  /// run - Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the module, and if so, return true.

  //===----------------------------------------------------------------------===//
  // MPPassManager implementation

  /// Execute all of the passes scheduled for execution by invoking
  /// runOnModule method.  Keep track of whether any of the passes modifies
  /// the module, and if so, return true.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1576,
   FQN="(anonymous namespace)::MPPassManager::runOnModule", NM="_ZN12_GLOBAL__N_113MPPassManager11runOnModuleERN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager11runOnModuleERN4llvm6ModuleE")
  //</editor-fold>
  public boolean runOnModule(final Module /*&*/ M) {
    boolean Changed = false;

    // Initialize on-the-fly passes
    for (final std.pairPtrPtr<Pass /*P*/ /*const*/, FunctionPassManagerImpl /*P*/ > /*&*/ OnTheFlyManager : OnTheFlyManagers) {
      FunctionPassManagerImpl /*P*/ FPP = OnTheFlyManager.second;
      Changed |= FPP.doInitialization(M);
    }

    // Initialize module passes
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index)  {
      Changed |= getContainedPass(Index).doInitialization(M);
    }

    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      ModulePass /*P*/ MP = getContainedPass(Index);
      boolean LocalChanged = false;

      dumpPassInfo(MP, PassDebuggingString.EXECUTION_MSG, PassDebuggingString.ON_MODULE_MSG, new StringRef(M.getModuleIdentifier()));
      dumpRequiredSet(MP);

      initializeAnalysisImpl(MP);
      {
        PassManagerPrettyStackEntry X = null;
        TimeRegion PassTimer = null;
        try {
          X/*J*/= new PassManagerPrettyStackEntry(MP, M);
          PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, IrLlvmGlobals.getPassTimer(MP));

          LocalChanged |= MP.runOnModule(M);
        } finally {
          if (PassTimer != null) { PassTimer.$destroy(); }
          if (X != null) { X.$destroy(); }
        }
      }

      Changed |= LocalChanged;
      if (LocalChanged) {
        dumpPassInfo(MP, PassDebuggingString.MODIFICATION_MSG, PassDebuggingString.ON_MODULE_MSG,
            new StringRef(M.getModuleIdentifier()));
      }
      dumpPreservedSet(MP);
      dumpUsedSet(MP);

      verifyPreservedAnalysis(MP);
      removeNotPreservedAnalysis(MP);
      recordAvailableAnalysis(MP);
      removeDeadPasses(MP, new StringRef(M.getModuleIdentifier()), PassDebuggingString.ON_MODULE_MSG);
    }

    // Finalize module passes
    for (int Index = getNumContainedPasses() - 1; Index >= 0; --Index)  {
      Changed |= getContainedPass(Index).doFinalization(M);
    }

    // Finalize on-the-fly passes
    for (final std.pairPtrPtr<Pass /*P*/ /*const*/, FunctionPassManagerImpl /*P*/ > /*&*/ OnTheFlyManager : OnTheFlyManagers) {
      FunctionPassManagerImpl /*P*/ FPP = OnTheFlyManager.second;
      // We don't know when is the last time an on-the-fly pass is run,
      // so we need to releaseMemory / finalize here
      FPP.releaseMemoryOnTheFly();
      Changed |= FPP.doFinalization(M);
    }

    return Changed;
  }


  //JAVA: using llvm::Pass::doInitialization;
  //JAVA: using llvm::Pass::doFinalization;

  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 329,
   FQN="(anonymous namespace)::MPPassManager::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_113MPPassManager16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113MPPassManager16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    Info.setPreservesAll();
  }


  /// Add RequiredPass into list of lower level passes required by pass P.
  /// RequiredPass is run on the fly by Pass Manager when P requests it
  /// through getAnalysis interface.

  /// Add RequiredPass into list of lower level passes required by pass P.
  /// RequiredPass is run on the fly by Pass Manager when P requests it
  /// through getAnalysis interface.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::addLowerLevelRequiredPass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1638,
   FQN="(anonymous namespace)::MPPassManager::addLowerLevelRequiredPass", NM="_ZN12_GLOBAL__N_113MPPassManager25addLowerLevelRequiredPassEPN4llvm4PassES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager25addLowerLevelRequiredPassEPN4llvm4PassES3_")
  //</editor-fold>
  @Override public void addLowerLevelRequiredPass(Pass /*P*/ P, Pass /*P*/ RequiredPass)/* override*/ {
    assert ((P.getPotentialPassManagerType().getValue() < RequiredPass.getPotentialPassManagerType().getValue())) : "Unable to handle Pass that requires lower level Analysis pass";
    if (!(RequiredPass != null)) {
      return;
    }

    FunctionPassManagerImpl /*P*/ FPP = OnTheFlyManagers.$at_T$C$R(P);
    if (!(FPP != null)) {
      FPP = new FunctionPassManagerImpl();
      // FPP is the top level manager.
      FPP.setTopLevelManager(FPP);

      OnTheFlyManagers.$set(P, FPP);
    }
    /*const*/ PassInfo /*P*/ RequiredPassPI = /*J:ToBase*//*P*/ ((PMTopLevelManager /*P*/ )FPP).findAnalysisPassInfo(RequiredPass.getPassID());

    Pass /*P*/ FoundPass = null;
    if ((RequiredPassPI != null) && RequiredPassPI.isAnalysis()) {
      FoundPass
         = ((PMTopLevelManager /*P*/ )FPP).findAnalysisPass(RequiredPass.getPassID());
    }
    if (!(FoundPass != null)) {
      FoundPass = RequiredPass;
      // This should be guaranteed to add RequiredPass to the passmanager given
      // that we checked for an available analysis above.
      FPP.add(RequiredPass);
    }
    // Register P as the last user of FoundPass or RequiredPass.
    SmallVector<Pass /*P*/ > LU/*J*/= new SmallVector<Pass /*P*/ >(1, (Pass /*P*/ )null);
    LU.push_back(FoundPass);
    FPP.setLastUser(new ArrayRef<Pass /*P*/ >(LU, true), P);
  }

  /// Return function pass corresponding to PassInfo PI, that is
  /// required by module pass MP. Instantiate analysis pass, by using
  /// its runOnFunction() for function F.

  /// Return function pass corresponding to PassInfo PI, that is
  /// required by module pass MP. Instantiate analysis pass, by using
  /// its runOnFunction() for function F.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getOnTheFlyPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1678,
   FQN="(anonymous namespace)::MPPassManager::getOnTheFlyPass", NM="_ZN12_GLOBAL__N_113MPPassManager15getOnTheFlyPassEPN4llvm4PassEPKvRNS1_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager15getOnTheFlyPassEPN4llvm4PassEPKvRNS1_8FunctionE")
  //</editor-fold>
  @Override public Pass /*P*/ getOnTheFlyPass(Pass /*P*/ MP, /*const*/Object/*void P*/ PI, final Function /*&*/ F)/* override*/ {
    FunctionPassManagerImpl /*P*/ FPP = OnTheFlyManagers.$at_T$C$R(MP);
    assert ((FPP != null)) : "Unable to find on the fly pass";

    FPP.releaseMemoryOnTheFly();
    FPP.run(F);
    return ((PMTopLevelManager /*P*/ )FPP).findAnalysisPass(PI);
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 343,
   FQN="(anonymous namespace)::MPPassManager::getPassName", NM="_ZNK12_GLOBAL__N_113MPPassManager11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113MPPassManager11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    return $("Module Pass Manager");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 347,
   FQN="(anonymous namespace)::MPPassManager::getAsPMDataManager", NM="_ZN12_GLOBAL__N_113MPPassManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 348,
   FQN="(anonymous namespace)::MPPassManager::getAsPass", NM="_ZN12_GLOBAL__N_113MPPassManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    return this;
  }


  // Print passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::dumpPassStructure">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 351,
   FQN="(anonymous namespace)::MPPassManager::dumpPassStructure", NM="_ZN12_GLOBAL__N_113MPPassManager17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager17dumpPassStructureEj")
  //</editor-fold>
  @Override public void dumpPassStructure(/*uint*/int Offset)/* override*/ {
    dbgs().indent(Offset * 2).$out(/*KEEP_STR*/"ModulePass Manager\n");
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      ModulePass /*P*/ MP = getContainedPass(Index);
      MP.dumpPassStructure(Offset + 1);
      std.mapPtrPtr.iterator<Pass /*P*/ /*const*/, FunctionPassManagerImpl /*P*/> I = new StdMapPtrPtr.iterator<Pass, FunctionPassManagerImpl>(OnTheFlyManagers.find(MP));
      if (I.$noteq(new std.mapPtrPtr.iterator<Pass, FunctionPassManagerImpl>(OnTheFlyManagers.end()))) {
        I.$arrow().second.dumpPassStructure(Offset + 2);
      }
      dumpLastUses(MP, Offset + 1);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getContainedPass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 364,
   FQN="(anonymous namespace)::MPPassManager::getContainedPass", NM="_ZN12_GLOBAL__N_113MPPassManager16getContainedPassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113MPPassManager16getContainedPassEj")
  //</editor-fold>
  public ModulePass /*P*/ getContainedPass(/*uint*/int N) {
    assert ($less_uint(N, /*J:ToBase*//*P*/$PMDataManager$Fields().PassVector.size())) : "Pass number out of range!";
    return ((/*static_cast*/ModulePass /*P*/ )(/*J:ToBase*//*P*/ $PMDataManager$Fields().PassVector.$at(N)));
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MPPassManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 369,
   FQN="(anonymous namespace)::MPPassManager::getPassManagerType", NM="_ZNK12_GLOBAL__N_113MPPassManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113MPPassManager18getPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_ModulePassManager;
  }

/*private:*/
  /// Collection of on the fly FPPassManagers. These managers manage
  /// function passes that are required by module passes.
  private std.mapPtrPtr<Pass /*P*/ , FunctionPassManagerImpl /*P*/ > OnTheFlyManagers;

  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }

  @Override public String toString() {
    return "" + "OnTheFlyManagers=" + OnTheFlyManagers // NOI18N
              + super.toString(); // NOI18N
  }
}
