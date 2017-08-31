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

package org.llvm.ir.legacy.impl;

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
import static org.llvm.ir.impl.IRPrintingPassesLlvmGlobals.createPrintFunctionPass;

//===----------------------------------------------------------------------===//
// FunctionPassManagerImpl
//
/// FunctionPassManagerImpl manages FPPassManagers
//<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 230,
 FQN="llvm::legacy::FunctionPassManagerImpl", NM="_ZN4llvm6legacy23FunctionPassManagerImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImplE")
//</editor-fold>
public class FunctionPassManagerImpl extends /*public*/ Pass implements /*public*/ PMDataManager, /*public*/ PMTopLevelManager, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 288,
   FQN="llvm::legacy::FunctionPassManagerImpl::anchor", NM="_ZN4llvm6legacy23FunctionPassManagerImpl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*private:*/
  private boolean wasRun;
/*public:*/
  // JAVA: see ID class in extra members
  // public static /*char*/byte ID = $int2char(0);
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::FunctionPassManagerImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 238,
   FQN="llvm::legacy::FunctionPassManagerImpl::FunctionPassManagerImpl", NM="_ZN4llvm6legacy23FunctionPassManagerImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImplC1Ev")
  //</editor-fold>
  public /*explicit*/ FunctionPassManagerImpl() {
    // : Pass(PT_PassManager, ID), PMDataManager(), PMTopLevelManager(new FPPassManager()), wasRun(false)
    //START JInit
    super(PassKind.PT_PassManager, ID);
    this.PMDataManager$Flds = $PMDataManager();
    this.PMTopLevelManager$Flds = $PMTopLevelManager(new FPPassManager());
    this.wasRun = false;
    //END JInit
  }


  /// \copydoc FunctionPassManager::add()
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 243,
   FQN="llvm::legacy::FunctionPassManagerImpl::add", NM="_ZN4llvm6legacy23FunctionPassManagerImpl3addEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl3addEPNS_4PassE")
  //</editor-fold>
  public void add(Pass /*P*/ P) {
    schedulePass(P);
  }


  /// createPrinterPass - Get a function printer pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 248,
   FQN="llvm::legacy::FunctionPassManagerImpl::createPrinterPass", NM="_ZNK4llvm6legacy23FunctionPassManagerImpl17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm6legacy23FunctionPassManagerImpl17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O,
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    return createPrintFunctionPass(O, Banner);
  }


  // Prepare for running an on the fly pass, freeing memory if needed
  // from a previous run.
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::releaseMemoryOnTheFly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1455,
   FQN="llvm::legacy::FunctionPassManagerImpl::releaseMemoryOnTheFly", NM="_ZN4llvm6legacy23FunctionPassManagerImpl21releaseMemoryOnTheFlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl21releaseMemoryOnTheFlyEv")
  //</editor-fold>
  public void releaseMemoryOnTheFly() {
    if (!wasRun) {
      return;
    }
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedManagers()); ++Index) {
      FPPassManager /*P*/ FPPM = getContainedManager(Index);
      for (/*uint*/int Index$1 = 0; $less_uint(Index$1, FPPM.getNumContainedPasses()); ++Index$1) {
        FPPM.getContainedPass(Index$1).releaseMemory();
      }
    }
    wasRun = false;
  }


  /// run - Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the module, and if so, return true.

  // Execute all the passes managed by this top level manager.
  // Return true if any function is modified by a pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1469,
   FQN="llvm::legacy::FunctionPassManagerImpl::run", NM="_ZN4llvm6legacy23FunctionPassManagerImpl3runERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl3runERNS_8FunctionE")
  //</editor-fold>
  public boolean run(final Function /*&*/ F) {
    boolean Changed = false;
    TimingInfo.createTheTimeInfo();

    initializeAllAnalysisInfo();
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedManagers()); ++Index) {
      Changed |= getContainedManager(Index).runOnFunction(F);
      F.getContext().yield();
    }

    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedManagers()); ++Index)  {
      getContainedManager(Index).cleanup();
    }

    wasRun = true;
    return Changed;
  }


  /// doInitialization - Run all of the initializers for the function passes.
  ///

  //===----------------------------------------------------------------------===//
  // FunctionPassManagerImpl implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1418,
   FQN="llvm::legacy::FunctionPassManagerImpl::doInitialization", NM="_ZN4llvm6legacy23FunctionPassManagerImpl16doInitializationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl16doInitializationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doInitialization(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;

    dumpArguments();
    dumpPasses();

    for (ImmutablePass /*P*/ ImPass : getImmutablePasses())  {
      Changed |= ImPass.doInitialization(M);
    }

    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedManagers()); ++Index)  {
      Changed |= getContainedManager(Index).doInitialization(M);
    }

    return Changed;
  }


  /// doFinalization - Run all of the finalizers for the function passes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1433,
   FQN="llvm::legacy::FunctionPassManagerImpl::doFinalization", NM="_ZN4llvm6legacy23FunctionPassManagerImpl14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;

    for (int Index = getNumContainedManagers() - 1; Index >= 0; --Index)  {
      Changed |= getContainedManager(Index).doFinalization(M);
    }

    for (ImmutablePass /*P*/ ImPass : getImmutablePasses())  {
      Changed |= ImPass.doFinalization(M);
    }

    return Changed;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 270,
   FQN="llvm::legacy::FunctionPassManagerImpl::getAsPMDataManager", NM="_ZN4llvm6legacy23FunctionPassManagerImpl18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::getAsPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 271,
   FQN="llvm::legacy::FunctionPassManagerImpl::getAsPass", NM="_ZN4llvm6legacy23FunctionPassManagerImpl9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::getTopLevelPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 272,
   FQN="llvm::legacy::FunctionPassManagerImpl::getTopLevelPassManagerType", NM="_ZN4llvm6legacy23FunctionPassManagerImpl26getTopLevelPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl26getTopLevelPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getTopLevelPassManagerType()/* override*/ {
    return PassManagerType.PMT_FunctionPassManager;
  }


  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 277,
   FQN="llvm::legacy::FunctionPassManagerImpl::getAnalysisUsage", NM="_ZNK4llvm6legacy23FunctionPassManagerImpl16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm6legacy23FunctionPassManagerImpl16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    Info.setPreservesAll();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::getContainedManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 281,
   FQN="llvm::legacy::FunctionPassManagerImpl::getContainedManager", NM="_ZN4llvm6legacy23FunctionPassManagerImpl19getContainedManagerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImpl19getContainedManagerEj")
  //</editor-fold>
  public FPPassManager /*P*/ getContainedManager(/*uint*/int N) {
    assert ($less_uint(N, /*J:ToBase*/$PMTopLevelManager$Fields().PassManagers.size())) : "Pass number out of range!";
    FPPassManager /*P*/ FP = ((/*static_cast*/FPPassManager /*P*/ )(/*J:ToBase*/$PMTopLevelManager$Fields().PassManagers.$at(N)));
    return FP;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::legacy::FunctionPassManagerImpl::~FunctionPassManagerImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 230,
   FQN="llvm::legacy::FunctionPassManagerImpl::~FunctionPassManagerImpl", NM="_ZN4llvm6legacy23FunctionPassManagerImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm6legacy23FunctionPassManagerImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    PMDataManager.super.$destroy$PMDataManager();
    PMTopLevelManager.super.$destroy$PMTopLevelManager();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final /*char*/Class<FunctionPassManagerImpl> ID = org.llvm.ir.legacy.impl.FunctionPassManagerImpl.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }

  private final PMTopLevelManager$Fields PMTopLevelManager$Flds;// use return value of $PMTopLevelManager();
  @Override public final PMTopLevelManager$Fields $PMTopLevelManager$Fields() { return PMTopLevelManager$Flds; }

  @Override public String toString() {
    return "" + "wasRun=" + wasRun // NOI18N
              + super.toString(); // NOI18N
  }
}
