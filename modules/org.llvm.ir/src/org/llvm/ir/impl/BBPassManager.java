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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.adt.java.ADTJavaDifferentiators.JD$Timer$P;

//===----------------------------------------------------------------------===//
// BBPassManager
//
/// BBPassManager manages BasicBlockPass. It batches all the
/// pass together and sequence them to process one basic block before
/// processing next basic block.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 172,
 FQN="(anonymous namespace)::BBPassManager", NM="_ZN12_GLOBAL__N_113BBPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManagerE")
//</editor-fold>
public class BBPassManager extends /*public*/ FunctionPass implements /*public*/ PMDataManager, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::BBPassManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 176,
   FQN="(anonymous namespace)::BBPassManager::BBPassManager", NM="_ZN12_GLOBAL__N_113BBPassManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManagerC1Ev")
  //</editor-fold>
  public /*explicit*/ BBPassManager() {
    // : PMDataManager(), FunctionPass(ID) 
    //START JInit
    super(ID);
    this.PMDataManager$Flds = $PMDataManager();
    //END JInit
  }

  
  /// Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the function, and if so, return true.
  
  //===----------------------------------------------------------------------===//
  // BBPassManager implementation
  
  /// Execute all of the passes scheduled for execution by invoking
  /// runOnBasicBlock method.  Keep track of whether any of the passes modifies
  /// the function, and if so, return true.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1289,
   FQN="(anonymous namespace)::BBPassManager::runOnFunction", NM="_ZN12_GLOBAL__N_113BBPassManager13runOnFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager13runOnFunctionERN4llvm8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    if (F.isDeclaration()) {
      return false;
    }
    
    boolean Changed = doInitialization(F);
    
    for (ilist_iterator<BasicBlock> I = F.begin(), E = F.end(); I.$noteq(E); I.$preInc())  {
      for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
        BasicBlockPass /*P*/ BP = getContainedPass(Index);
        boolean LocalChanged = false;
        
        dumpPassInfo(BP, PassDebuggingString.EXECUTION_MSG, PassDebuggingString.ON_BASICBLOCK_MSG, I.$arrow().getName());
        dumpRequiredSet(BP);
        
        initializeAnalysisImpl(BP);
        {
          PassManagerPrettyStackEntry X = null;
          TimeRegion PassTimer = null;
          try {
            // If the pass crashes, remember this.
            X/*J*/= new PassManagerPrettyStackEntry(BP, I.$star());
            PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, IrLlvmGlobals.getPassTimer(BP));
            
            LocalChanged |= BP.runOnBasicBlock(I.$star());
          } finally {
            if (PassTimer != null) { PassTimer.$destroy(); }
            if (X != null) { X.$destroy(); }
          }
        }
        
        Changed |= LocalChanged;
        if (LocalChanged) {
          dumpPassInfo(BP, PassDebuggingString.MODIFICATION_MSG, PassDebuggingString.ON_BASICBLOCK_MSG, 
              I.$arrow().getName());
        }
        dumpPreservedSet(BP);
        dumpUsedSet(BP);
        
        verifyPreservedAnalysis(BP);
        removeNotPreservedAnalysis(BP);
        recordAvailableAnalysis(BP);
        removeDeadPasses(BP, I.$arrow().getName(), PassDebuggingString.ON_BASICBLOCK_MSG);
      }
    }
    
    return doFinalization(F) || Changed;
  }

  
  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 184,
   FQN="(anonymous namespace)::BBPassManager::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_113BBPassManager16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113BBPassManager16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    Info.setPreservesAll();
  }

  
  
  // Implement doInitialization and doFinalization
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1330,
   FQN="(anonymous namespace)::BBPassManager::doInitialization", NM="_ZN12_GLOBAL__N_113BBPassManager16doInitializationERN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager16doInitializationERN4llvm6ModuleE")
  //</editor-fold>
  @Override public boolean doInitialization(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;
    
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index)  {
      Changed |= getContainedPass(Index).doInitialization(M);
    }
    
    return Changed;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1348,
   FQN="(anonymous namespace)::BBPassManager::doInitialization", NM="_ZN12_GLOBAL__N_113BBPassManager16doInitializationERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager16doInitializationERN4llvm8FunctionE")
  //</editor-fold>
  public boolean doInitialization(final Function /*&*/ F) {
    boolean Changed = false;
    
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      BasicBlockPass /*P*/ BP = getContainedPass(Index);
      Changed |= BP.doInitialization(F);
    }
    
    return Changed;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1339,
   FQN="(anonymous namespace)::BBPassManager::doFinalization", NM="_ZN12_GLOBAL__N_113BBPassManager14doFinalizationERN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager14doFinalizationERN4llvm6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module /*&*/ M)/* override*/ {
    boolean Changed = false;
    
    for (int Index = getNumContainedPasses() - 1; Index >= 0; --Index)  {
      Changed |= getContainedPass(Index).doFinalization(M);
    }
    
    return Changed;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1359,
   FQN="(anonymous namespace)::BBPassManager::doFinalization", NM="_ZN12_GLOBAL__N_113BBPassManager14doFinalizationERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager14doFinalizationERN4llvm8FunctionE")
  //</editor-fold>
  public boolean doFinalization(final Function /*&*/ F) {
    boolean Changed = false;
    
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      BasicBlockPass /*P*/ BP = getContainedPass(Index);
      Changed |= BP.doFinalization(F);
    }
    
    return Changed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 193,
   FQN="(anonymous namespace)::BBPassManager::getAsPMDataManager", NM="_ZN12_GLOBAL__N_113BBPassManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 194,
   FQN="(anonymous namespace)::BBPassManager::getAsPass", NM="_ZN12_GLOBAL__N_113BBPassManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 196,
   FQN="(anonymous namespace)::BBPassManager::getPassName", NM="_ZNK12_GLOBAL__N_113BBPassManager11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113BBPassManager11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    return $("BasicBlock Pass Manager");
  }

  
  // Print passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::dumpPassStructure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 201,
   FQN="(anonymous namespace)::BBPassManager::dumpPassStructure", NM="_ZN12_GLOBAL__N_113BBPassManager17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager17dumpPassStructureEj")
  //</editor-fold>
  @Override public void dumpPassStructure(/*uint*/int Offset)/* override*/ {
    dbgs().indent(Offset * 2).$out(/*KEEP_STR*/"BasicBlockPass Manager\n");
    for (/*uint*/int Index = 0; $less_uint(Index, getNumContainedPasses()); ++Index) {
      BasicBlockPass /*P*/ BP = getContainedPass(Index);
      BP.dumpPassStructure(Offset + 1);
      dumpLastUses(BP, Offset + 1);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::getContainedPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 210,
   FQN="(anonymous namespace)::BBPassManager::getContainedPass", NM="_ZN12_GLOBAL__N_113BBPassManager16getContainedPassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManager16getContainedPassEj")
  //</editor-fold>
  public BasicBlockPass /*P*/ getContainedPass(/*uint*/int N) {
    assert ($less_uint(N, /*J:ToBase*/PMDataManager /*P*/ .super.$PMDataManager$Fields().PassVector.size())) : "Pass number out of range!";
    BasicBlockPass /*P*/ BP = ((/*static_cast*/BasicBlockPass /*P*/ )(/*J:ToBase*/PMDataManager /*P*/ .super.$PMDataManager$Fields().PassVector.$at(N)));
    return BP;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 216,
   FQN="(anonymous namespace)::BBPassManager::getPassManagerType", NM="_ZNK12_GLOBAL__N_113BBPassManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK12_GLOBAL__N_113BBPassManager18getPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_BasicBlockPassManager;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BBPassManager::~BBPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 172,
   FQN="(anonymous namespace)::BBPassManager::~BBPassManager", NM="_ZN12_GLOBAL__N_113BBPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_113BBPassManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    PMDataManager.super.$destroy$PMDataManager();
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<BBPassManager> ID = BBPassManager.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
