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
import org.llvm.adt.java.ADTJavaDifferentiators.JD$Timer$P;
import org.llvm.support.sys.TimeValue;


//===----------------------------------------------------------------------===//
// PMDataManager

/// PMDataManager provides the common place to manage the analysis data
/// used by pass managers.
//<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 303,
 FQN="llvm::PMDataManager", NM="_ZN4llvm13PMDataManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManagerE")
//</editor-fold>
public abstract interface/*class*/ PMDataManager extends Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::PMDataManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 305,
   FQN="llvm::PMDataManager::PMDataManager", NM="_ZN4llvm13PMDataManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManagerC1Ev")
  //</editor-fold>
  public default/*interface*/ /*explicit*/ PMDataManager$Fields $PMDataManager() {
    // : TPM(null), PassVector(), AvailableAnalysis(), HigherLevelAnalysis(), Depth(0)
    //START JInit
    PMDataManager$Fields $Fields = new PMDataManager$Fields();
    //END JInit
    this.initializeAnalysisInfo($Fields);
    return $Fields;
  }



  // Destructor
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::~PMDataManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1265,
   FQN="llvm::PMDataManager::~PMDataManager", NM="_ZN4llvm13PMDataManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManagerD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$PMDataManager() {
    for (type$ptr<Pass /*P*/ /*P*/> I = $tryClone($PMDataManager$Fields().PassVector.begin()),
        /*P*/ E = $tryClone($PMDataManager$Fields().PassVector.end()); $noteq_ptr(I, E); I.$preInc())  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I.$star());
    }
    //START JDestroy
    $PMDataManager$Fields().HigherLevelAnalysis.$destroy();
    $PMDataManager$Fields().AvailableAnalysis.$destroy();
    $PMDataManager$Fields().PassVector.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 311,
   FQN="llvm::PMDataManager::getAsPass", NM="_ZN4llvm13PMDataManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager9getAsPassEv")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ Pass /*P*/ getAsPass()/* = 0*/;


  /// Augment AvailableAnalysis by adding analysis made available by pass P.

  //===----------------------------------------------------------------------===//
  // PMDataManager implementation

  /// Augement AvailableAnalysis by adding analysis made available by pass P.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::recordAvailableAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 816,
   FQN="llvm::PMDataManager::recordAvailableAnalysis", NM="_ZN4llvm13PMDataManager23recordAvailableAnalysisEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager23recordAvailableAnalysisEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void recordAvailableAnalysis(Pass /*P*/ P) {
    /*const*/Object/*void P*/ PI = P.getPassID();

    $PMDataManager$Fields().AvailableAnalysis.$set(PI, P);
    assert (!$PMDataManager$Fields().AvailableAnalysis.empty());

    // This pass is the current implementation of all of the interfaces it
    // implements as well.
    /*const*/ PassInfo /*P*/ PInf = $PMDataManager$Fields().TPM.findAnalysisPassInfo(PI);
    if (!(PInf != null)) {
      return;
    }
    final /*const*/std.vector</*const*/ PassInfo /*P*/ > /*&*/ II = PInf.getInterfacesImplemented();
    for (/*uint*/int i = 0, e = II.size(); i != e; ++i)  {
      $PMDataManager$Fields().AvailableAnalysis.$set(II.$at$Const(i).getTypeInfo(), P);
    }
  }


  /// verifyPreservedAnalysis -- Verify analysis presreved by pass P.

  /// verifyPreservedAnalysis -- Verify analysis preserved by pass P.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::verifyPreservedAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 854,
   FQN="llvm::PMDataManager::verifyPreservedAnalysis", NM="_ZN4llvm13PMDataManager23verifyPreservedAnalysisEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager23verifyPreservedAnalysisEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void verifyPreservedAnalysis(Pass /*P*/ P) {
    AnalysisUsage /*P*/ AnUsage = $PMDataManager$Fields().TPM.findAnalysisUsage(P);
    final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ PreservedSet = AnUsage.getPreservedSet();

    // Verify preserved analysis
    for (/*const*/type$ptr<Object>/*void P const P*/ I = $tryClone(PreservedSet.begin$Const()),
        /*P*/ E = $tryClone(PreservedSet.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      /*const*/Object/*void P*/ AID = I.$star();
      {
        Pass /*P*/ AP = this.findAnalysisPass(AID, true);
        if ((AP != null)) {
          TimeRegion PassTimer = null;
          try {
            PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, IrLlvmGlobals.getPassTimer(AP));
            AP.verifyAnalysis();
          } finally {
            if (PassTimer != null) { PassTimer.$destroy(); }
          }
        }
      }
    }
  }


  /// Remove Analysis that is not preserved by the pass

  /// Remove Analysis not preserved by Pass P
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::removeNotPreservedAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 874,
   FQN="llvm::PMDataManager::removeNotPreservedAnalysis", NM="_ZN4llvm13PMDataManager26removeNotPreservedAnalysisEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager26removeNotPreservedAnalysisEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void removeNotPreservedAnalysis(Pass /*P*/ P) {
    AnalysisUsage /*P*/ AnUsage = $PMDataManager$Fields().TPM.findAnalysisUsage(P);
    if (AnUsage.getPreservesAll()) {
      return;
    }

    final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ PreservedSet = AnUsage.getPreservedSet();
    for (DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ > I = $PMDataManager$Fields().AvailableAnalysis.begin(),
        E = $PMDataManager$Fields().AvailableAnalysis.end(); I.$noteq(/*NO_ITER_COPY*/E);) {
      DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ > Info = I.$postInc(0);
      if (Info.$arrow().second.getAsImmutablePass() == null
         && $eq_ptr(std.find(PreservedSet.begin$Const(), PreservedSet.end$Const(), Info.$arrow().first), PreservedSet.end$Const())) {
        // Remove this analysis
        if (LegacyPassManagerStatics.PassDebugging.$T().getValue() >= PassDebugLevel.Details.getValue()) {
          Pass /*P*/ S = Info.$arrow().second;
          dbgs().$out(/*KEEP_STR*/" -- '").$out(P.getPassName()).$out(/*KEEP_STR*/"' is not preserving '");
          dbgs().$out(S.getPassName()).$out(/*KEEP_STR*/"'\n");
        }
        $PMDataManager$Fields().AvailableAnalysis.erase(new DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ >(Info));
      }
    }

    // Check inherited analysis also. If P is not preserving analysis
    // provided by parent manager then remove it here.
    for (/*uint*/int Index = 0; $less_uint(Index, PassManagerType.PMT_Last.getValue()); ++Index) {
      if (!($PMDataManager$Fields().InheritedAnalysis[Index] != null)) {
        continue;
      }

      for (DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ > I = $PMDataManager$Fields().InheritedAnalysis[Index].begin(),
          E = $PMDataManager$Fields().InheritedAnalysis[Index].end(); I.$noteq(/*NO_ITER_COPY*/E);) {
        DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ > Info = I.$postInc(0);
        if (Info.$arrow().second.getAsImmutablePass() == null
           && $eq_ptr(std.find(PreservedSet.begin$Const(), PreservedSet.end$Const(), Info.$arrow().first), PreservedSet.end$Const())) {
          // Remove this analysis
          if (LegacyPassManagerStatics.PassDebugging.$T().getValue() >= PassDebugLevel.Details.getValue()) {
            Pass /*P*/ S = Info.$arrow().second;
            dbgs().$out(/*KEEP_STR*/" -- '").$out(P.getPassName()).$out(/*KEEP_STR*/"' is not preserving '");
            dbgs().$out(S.getPassName()).$out(/*KEEP_STR*/"'\n");
          }
          $PMDataManager$Fields().InheritedAnalysis[Index].erase(new DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ >(Info));
        }
      }
    }
  }


  /// Remove dead passes used by P.

  /// Remove analysis passes that are not used any longer
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::removeDeadPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 923,
   FQN="llvm::PMDataManager::removeDeadPasses", NM="_ZN4llvm13PMDataManager16removeDeadPassesEPNS_4PassENS_9StringRefENS_19PassDebuggingStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager16removeDeadPassesEPNS_4PassENS_9StringRefENS_19PassDebuggingStringE")
  //</editor-fold>
  public default/*interface*/ void removeDeadPasses(Pass /*P*/ P, StringRef Msg,
                   PassDebuggingString DBG_STR) {

    SmallVector<Pass /*P*/ > DeadPasses/*J*/= new SmallVector<Pass /*P*/ >(12, (Pass /*P*/ )null);

    // If this is a on the fly manager then it does not have TPM.
    if (!($PMDataManager$Fields().TPM != null)) {
      return;
    }

    $PMDataManager$Fields().TPM.collectLastUses(DeadPasses, P);
    if (LegacyPassManagerStatics.PassDebugging.$T().getValue() >= PassDebugLevel.Details.getValue() && !DeadPasses.empty()) {
      dbgs().$out(/*KEEP_STR*/" -*- '").$out(P.getPassName());
      dbgs().$out(/*KEEP_STR*/"' is the last user of following pass instances.");
      dbgs().$out(/*KEEP_STR*/" Free these instances\n");
    }

    for (type$ptr<Pass /*P*/ /*P*/> I = $tryClone(DeadPasses.begin()),
        /*P*/ E = $tryClone(DeadPasses.end()); $noteq_ptr(I, E); I.$preInc())  {
      this.freePass(I.$star(), new StringRef(Msg), DBG_STR);
    }
  }


  /// Remove P.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::freePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 945,
   FQN="llvm::PMDataManager::freePass", NM="_ZN4llvm13PMDataManager8freePassEPNS_4PassENS_9StringRefENS_19PassDebuggingStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager8freePassEPNS_4PassENS_9StringRefENS_19PassDebuggingStringE")
  //</editor-fold>
  public default/*interface*/ void freePass(Pass /*P*/ P, StringRef Msg,
           PassDebuggingString DBG_STR) {
    this.dumpPassInfo(P, PassDebuggingString.FREEING_MSG, DBG_STR, new StringRef(Msg));
    {
      PassManagerPrettyStackEntry X = null;
      TimeRegion PassTimer = null;
      try {
        // If the pass crashes releasing memory, remember this.
        X/*J*/= new PassManagerPrettyStackEntry(P);
        PassTimer/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, IrLlvmGlobals.getPassTimer(P));

        P.releaseMemory();
      } finally {
        if (PassTimer != null) { PassTimer.$destroy(); }
        if (X != null) { X.$destroy(); }
      }
    }

    /*const*/Object/*void P*/ PI = P.getPassID();
    {
      /*const*/ PassInfo /*P*/ PInf = $PMDataManager$Fields().TPM.findAnalysisPassInfo(PI);
      if ((PInf != null)) {
        // Remove the pass itself (if it is not already removed).
        $PMDataManager$Fields().AvailableAnalysis.erase(PI);

        // Remove all interfaces this pass implements, for which it is also
        // listed as the available implementation.
        final /*const*/std.vector</*const*/ PassInfo /*P*/ > /*&*/ II = PInf.getInterfacesImplemented();
        for (/*uint*/int i = 0, e = II.size(); i != e; ++i) {
          DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ > Pos = $PMDataManager$Fields().AvailableAnalysis.find(II.$at$Const(i).getTypeInfo());
          if (Pos.$noteq(/*NO_ITER_COPY*/$PMDataManager$Fields().AvailableAnalysis.end()) && Pos.$arrow().second == P) {
            $PMDataManager$Fields().AvailableAnalysis.erase(new DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ >(Pos));
          }
        }
      }
    }
  }


  /// Add pass P into the PassVector. Update
  /// AvailableAnalysis appropriately if ProcessAnalysis is true.

  /// Add pass P into the PassVector. Update
  /// AvailableAnalysis appropriately if ProcessAnalysis is true.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 976,
   FQN="llvm::PMDataManager::add", NM="_ZN4llvm13PMDataManager3addEPNS_4PassEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager3addEPNS_4PassEb")
  //</editor-fold>
  public default/*interface*/ void add(Pass /*P*/ P) {
    add(P, true);
  }
  public default/*interface*/ void add(Pass /*P*/ P, boolean ProcessAnalysis/*= true*/) {
    // This manager is going to manage pass P. Set up analysis resolver
    // to connect them.
    AnalysisResolver /*P*/ AR = new AnalysisResolver(/*Deref*/this);
    P.setResolver(AR);

    // If a FunctionPass F is the last user of ModulePass info M
    // then the F's manager, not F, records itself as a last user of M.
    SmallVector<Pass /*P*/ > TransferLastUses/*J*/= new SmallVector<Pass /*P*/ >(12, (Pass /*P*/ )null);
    if (!ProcessAnalysis) {
      // Add pass
      $PMDataManager$Fields().PassVector.push_back(P);
      return;
    }

    // At the moment, this pass is the last user of all required passes.
    SmallVector<Pass /*P*/ > LastUses/*J*/= new SmallVector<Pass /*P*/ >(12, (Pass /*P*/ )null);
    SmallVector<Pass /*P*/ > UsedPasses/*J*/= new SmallVector<Pass /*P*/ >(8, (Pass /*P*/ )null);
    SmallVector</*const*/Object/*void P*/> ReqAnalysisNotAvailable/*J*/= new SmallVector</*const*/Object/*void P*/>(8, (/*const*/Object/*void P*/)null);

    /*uint*/int PDepth = this.getDepth();

    this.collectRequiredAndUsedAnalyses(UsedPasses, ReqAnalysisNotAvailable, P);
    for (Pass /*P*/ PUsed : UsedPasses) {
      /*uint*/int RDepth = 0;
      assert ((PUsed.getResolver() != null)) : "Analysis Resolver is not set";
      final PMDataManager /*&*/ DM = PUsed.getResolver().getPMDataManager();
      RDepth = DM.getDepth();
      if (PDepth == RDepth) {
        LastUses.push_back(PUsed);
      } else if ($greater_uint(PDepth, RDepth)) {
        // Let the parent claim responsibility of last use
        TransferLastUses.push_back(PUsed);
        // Keep track of higher level analysis used by this manager.
        $PMDataManager$Fields().HigherLevelAnalysis.push_back(PUsed);
      } else {
        throw new llvm_unreachable("Unable to accommodate Used Pass");
      }
    }

    // Set P as P's last user until someone starts using P.
    // However, if P is a Pass Manager then it does not need
    // to record its last user.
    if (!(P.getAsPMDataManager() != null)) {
      LastUses.push_back(P);
    }
    $PMDataManager$Fields().TPM.setLastUser(new ArrayRef<Pass /*P*/ >(LastUses, true), P);
    if (!TransferLastUses.empty()) {
      Pass /*P*/ My_PM = this.getAsPass();
      $PMDataManager$Fields().TPM.setLastUser(new ArrayRef<Pass /*P*/ >(TransferLastUses, true), My_PM);
      TransferLastUses.clear();
    }

    // Now, take care of required analyses that are not available.
    for (/*const*/Object/*void P*/ ID : ReqAnalysisNotAvailable) {
      /*const*/ PassInfo /*P*/ PI = $PMDataManager$Fields().TPM.findAnalysisPassInfo(ID);
      Pass /*P*/ AnalysisPass = PI.createPass();
      this.addLowerLevelRequiredPass(P, AnalysisPass);
    }

    // Take a note of analysis required and made available by this pass.
    // Remove the analysis not preserved by this pass
    this.removeNotPreservedAnalysis(P);
    this.recordAvailableAnalysis(P);

    // Add pass
    $PMDataManager$Fields().PassVector.push_back(P);
  }


  /// Add RequiredPass into list of lower level passes required by pass P.
  /// RequiredPass is run on the fly by Pass Manager when P requests it
  /// through getAnalysis interface.

  /// Add RequiredPass into list of lower level passes required by pass P.
  /// RequiredPass is run on the fly by Pass Manager when P requests it
  /// through getAnalysis interface.
  /// This should be handled by specific pass manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::addLowerLevelRequiredPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1238,
   FQN="llvm::PMDataManager::addLowerLevelRequiredPass", NM="_ZN4llvm13PMDataManager25addLowerLevelRequiredPassEPNS_4PassES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager25addLowerLevelRequiredPassEPNS_4PassES2_")
  //</editor-fold>
  public default/*interface*/ void addLowerLevelRequiredPass(Pass /*P*/ P, Pass /*P*/ RequiredPass) {
    if (($PMDataManager$Fields().TPM != null)) {
      $PMDataManager$Fields().TPM.dumpArguments();
      $PMDataManager$Fields().TPM.dumpPasses();
    }
    dbgs().$out(/*KEEP_STR*/"Unable to schedule '").$out(RequiredPass.getPassName());
    dbgs().$out(/*KEEP_STR*/"' required by '").$out(P.getPassName()).$out(/*KEEP_STR*/"'\n");
    throw new llvm_unreachable("Unable to schedule pass");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getOnTheFlyPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1260,
   FQN="llvm::PMDataManager::getOnTheFlyPass", NM="_ZN4llvm13PMDataManager15getOnTheFlyPassEPNS_4PassEPKvRNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager15getOnTheFlyPassEPNS_4PassEPKvRNS_8FunctionE")
  //</editor-fold>
  public default/*interface*/ Pass /*P*/ getOnTheFlyPass(Pass /*P*/ P, /*const*/Object/*void P*/ PI, final Function /*&*/ F) {
    throw new llvm_unreachable("Unable to find on the fly pass");
  }


  /// Initialize available analysis information.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::initializeAnalysisInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 342,
   FQN="llvm::PMDataManager::initializeAnalysisInfo", NM="_ZN4llvm13PMDataManager22initializeAnalysisInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager22initializeAnalysisInfoEv")
  //</editor-fold>
  public default/*interface*/ void initializeAnalysisInfo() {
    initializeAnalysisInfo($PMDataManager$Fields());
  }
  public default/*interface*/ void initializeAnalysisInfo(PMDataManager$Fields $Fields) {
    $Fields.AvailableAnalysis.clear();
    for (/*uint*/int i = 0; $less_uint(i, PassManagerType.PMT_Last.getValue()); ++i)  {
      $Fields.InheritedAnalysis[i] = null;
    }
  }


  // Return true if P preserves high level analysis used by other
  // passes that are managed by this manager.

  // Return true if P preserves high level analysis used by other
  // passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::preserveHigherLevelAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 834,
   FQN="llvm::PMDataManager::preserveHigherLevelAnalysis", NM="_ZN4llvm13PMDataManager27preserveHigherLevelAnalysisEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager27preserveHigherLevelAnalysisEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ boolean preserveHigherLevelAnalysis(Pass /*P*/ P) {
    AnalysisUsage /*P*/ AnUsage = $PMDataManager$Fields().TPM.findAnalysisUsage(P);
    if (AnUsage.getPreservesAll()) {
      return true;
    }

    final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ PreservedSet = AnUsage.getPreservedSet();
    for (type$ptr<Pass /*P*/ /*P*/> I = $tryClone($PMDataManager$Fields().HigherLevelAnalysis.begin()),
        /*P*/ E = $tryClone($PMDataManager$Fields().HigherLevelAnalysis.end()); $noteq_ptr(I, E); I.$preInc()) {
      Pass /*P*/ P1 = I.$star();
      if (P1.getAsImmutablePass() == null
         && $eq_ptr(std.find(PreservedSet.begin$Const(), PreservedSet.end$Const(),
          P1.getPassID()), PreservedSet.end$Const())) {
        return false;
      }
    }

    return true;
  }


  /// Populate UsedPasses with analysis pass that are used or required by pass
  /// P and are available. Populate ReqPassNotAvailable with analysis pass that
  /// are required by pass P but are not available.

  /// Populate UP with analysis pass that are used or required by
  /// pass P and are available. Populate RP_NotAvail with analysis
  /// pass that are required by pass P but are not available.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::collectRequiredAndUsedAnalyses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1051,
   FQN="llvm::PMDataManager::collectRequiredAndUsedAnalyses", NM="_ZN4llvm13PMDataManager30collectRequiredAndUsedAnalysesERNS_15SmallVectorImplIPNS_4PassEEERNS1_IPKvEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager30collectRequiredAndUsedAnalysesERNS_15SmallVectorImplIPNS_4PassEEERNS1_IPKvEES3_")
  //</editor-fold>
  public default/*interface*/ void collectRequiredAndUsedAnalyses(final SmallVectorImpl<Pass /*P*/ > /*&*/ UP, final SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ RP_NotAvail,
                                Pass /*P*/ P) {
    AnalysisUsage /*P*/ AnUsage = $PMDataManager$Fields().TPM.findAnalysisUsage(P);

    for (final /*const*/Object/*void P*//*const*/ /*&*/ UsedID : AnUsage.getUsedSet())  {
      {
        Pass /*P*/ AnalysisPass = this.findAnalysisPass(UsedID, true);
        if ((AnalysisPass != null)) {
          UP.push_back(AnalysisPass);
        }
      }
    }

    for (final /*const*/Object/*void P*//*const*/ /*&*/ RequiredID : AnUsage.getRequiredSet())  {
      {
        Pass /*P*/ AnalysisPass = this.findAnalysisPass(RequiredID, true);
        if ((AnalysisPass != null)) {
          UP.push_back(AnalysisPass);
        } else {
          RP_NotAvail.push_back(RequiredID);
        }
      }
    }

    for (final /*const*/Object/*void P*//*const*/ /*&*/ RequiredID : AnUsage.getRequiredTransitiveSet())  {
      {
        Pass /*P*/ AnalysisPass = this.findAnalysisPass(RequiredID, true);
        if ((AnalysisPass != null)) {
          UP.push_back(AnalysisPass);
        } else {
          RP_NotAvail.push_back(RequiredID);
        }
      }
    }
  }


  /// All Required analyses should be available to the pass as it runs!  Here
  /// we fill in the AnalysisImpls member of the pass so that it can
  /// successfully use the getAnalysis() method to retrieve the
  /// implementations it needs.

  // All Required analyses should be available to the pass as it runs!  Here
  // we fill in the AnalysisImpls member of the pass so that it can
  // successfully use the getAnalysis() method to retrieve the
  // implementations it needs.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::initializeAnalysisImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1078,
   FQN="llvm::PMDataManager::initializeAnalysisImpl", NM="_ZN4llvm13PMDataManager22initializeAnalysisImplEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager22initializeAnalysisImplEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void initializeAnalysisImpl(Pass /*P*/ P) {
    AnalysisUsage /*P*/ AnUsage = $PMDataManager$Fields().TPM.findAnalysisUsage(P);

    for (/*const*/type$ptr<Object>/*void P const P*/ I = $tryClone(AnUsage.getRequiredSet().begin$Const()),
        /*P*/ E = $tryClone(AnUsage.getRequiredSet().end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      Pass /*P*/ Impl = this.findAnalysisPass(I.$star(), true);
      if (!(Impl != null)) {
        // This may be analysis pass that is initialized on the fly.
        // If that is not the case then it will raise an assert when it is used.
        continue;
      }
      AnalysisResolver /*P*/ AR = P.getResolver();
      assert ((AR != null)) : "Analysis Resolver is not set";
      AR.addAnalysisImplsPair(I.$star(), Impl);
    }
  }


  /// Find the pass that implements Analysis AID. If desired pass is not found
  /// then return NULL.

  /// Find the pass that implements Analysis AID. If desired pass is not found
  /// then return NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::findAnalysisPass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1097,
   FQN="llvm::PMDataManager::findAnalysisPass", NM="_ZN4llvm13PMDataManager16findAnalysisPassEPKvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager16findAnalysisPassEPKvb")
  //</editor-fold>
  public default/*interface*/ Pass /*P*/ findAnalysisPass(/*const*/Object/*void P*/ AID, boolean SearchParent) {

    // Check if AvailableAnalysis map has one entry.
    DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ > I = new DenseMapIterator</*const*/Object/*void P*/ , Pass /*P*/ >($PMDataManager$Fields().AvailableAnalysis.find(AID));
    if (I.$noteq(/*NO_ITER_COPY*/$PMDataManager$Fields().AvailableAnalysis.end())) {
      return I.$arrow().second;
    }

    // Search Parents through TopLevelManager
    if (SearchParent) {
      return $PMDataManager$Fields().TPM.findAnalysisPass(AID);
    }

    return null;
  }


  // Access toplevel manager
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getTopLevelManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 370,
   FQN="llvm::PMDataManager::getTopLevelManager", NM="_ZN4llvm13PMDataManager18getTopLevelManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager18getTopLevelManagerEv")
  //</editor-fold>
  public default/*interface*/ PMTopLevelManager /*P*/ getTopLevelManager() {
    return $PMDataManager$Fields().TPM;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::setTopLevelManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 371,
   FQN="llvm::PMDataManager::setTopLevelManager", NM="_ZN4llvm13PMDataManager18setTopLevelManagerEPNS_17PMTopLevelManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager18setTopLevelManagerEPNS_17PMTopLevelManagerE")
  //</editor-fold>
  public default/*interface*/ void setTopLevelManager(PMTopLevelManager /*P*/ T) {
    $PMDataManager$Fields().TPM = T;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 373,
   FQN="llvm::PMDataManager::getDepth", NM="_ZNK4llvm13PMDataManager8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager8getDepthEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getDepth() /*const*/ {
    return $PMDataManager$Fields().Depth;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::setDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 374,
   FQN="llvm::PMDataManager::setDepth", NM="_ZN4llvm13PMDataManager8setDepthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager8setDepthEj")
  //</editor-fold>
  public default/*interface*/ void setDepth(/*uint*/int newDepth) {
    $PMDataManager$Fields().Depth = newDepth;
  }


  // Print routines used by debug-pass

  // Print list of passes that are last used by P.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpLastUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1113,
   FQN="llvm::PMDataManager::dumpLastUses", NM="_ZNK4llvm13PMDataManager12dumpLastUsesEPNS_4PassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager12dumpLastUsesEPNS_4PassEj")
  //</editor-fold>
  public default/*interface*/ void dumpLastUses(Pass /*P*/ P, /*uint*/int Offset) /*const*/ {

    SmallVector<Pass /*P*/ > LUses/*J*/= new SmallVector<Pass /*P*/ >(12, (Pass /*P*/ )null);

    // If this is a on the fly manager then it does not have TPM.
    if (!($PMDataManager$Fields().TPM != null)) {
      return;
    }

    $PMDataManager$Fields().TPM.collectLastUses(LUses, P);

    for (type$ptr<Pass /*P*/ /*P*/> I = $tryClone(LUses.begin()),
        /*P*/ E = $tryClone(LUses.end()); $noteq_ptr(I, E); I.$preInc()) {
      dbgs().$out(/*KEEP_STR*/$MINUS_MINUS).$out(new std.string(Offset * 2, $$SPACE));
      (I.$star()).dumpPassStructure(0);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpPassArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1130,
   FQN="llvm::PMDataManager::dumpPassArguments", NM="_ZNK4llvm13PMDataManager17dumpPassArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager17dumpPassArgumentsEv")
  //</editor-fold>
  public default/*interface*/ void dumpPassArguments() /*const*/ {
    for (type$ptr<Pass /*P*/ /*P*/> I = $tryClone($PMDataManager$Fields().PassVector.begin$Const()),
        /*P*/ E = $tryClone($PMDataManager$Fields().PassVector.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      {
        PMDataManager /*P*/ PMD = (I.$star()).getAsPMDataManager();
        if ((PMD != null)) {
          PMD.dumpPassArguments();
        } else {
          /*const*/ PassInfo /*P*/ PI = $PMDataManager$Fields().TPM.findAnalysisPassInfo((I.$star()).getPassID());
          if ((PI != null)) {
            if (!PI.isAnalysisGroup()) {
              dbgs().$out(/*KEEP_STR*/" -").$out(PI.getPassArgument());
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpPassInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1143,
   FQN="llvm::PMDataManager::dumpPassInfo", NM="_ZN4llvm13PMDataManager12dumpPassInfoEPNS_4PassENS_19PassDebuggingStringES3_NS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager12dumpPassInfoEPNS_4PassENS_19PassDebuggingStringES3_NS_9StringRefE")
  //</editor-fold>
  public default/*interface*/ void dumpPassInfo(Pass /*P*/ P,  PassDebuggingString S1,
               PassDebuggingString S2,
              StringRef Msg) {
    if (LegacyPassManagerStatics.PassDebugging.$T().getValue() < PassDebugLevel.Executions.getValue()) {
      return;
    }
    dbgs().$out(/*KEEP_STR*/$LSQUARE).$out(TimeValue.now().str()).$out(/*KEEP_STR*/"] ").$out(reinterpret_cast(Object/*void P*/ .class, this)).$out(
        new std.string(this.getDepth() * 2 + 1, $$SPACE)
    );
    switch (S1) {
     case EXECUTION_MSG:
      dbgs().$out(/*KEEP_STR*/"Executing Pass '").$out(P.getPassName());
      break;
     case MODIFICATION_MSG:
      dbgs().$out(/*KEEP_STR*/"Made Modification '").$out(P.getPassName());
      break;
     case FREEING_MSG:
      dbgs().$out(/*KEEP_STR*/" Freeing Pass '").$out(P.getPassName());
      break;
     default:
      break;
    }
    switch (S2) {
     case ON_BASICBLOCK_MSG:
      dbgs().$out(/*KEEP_STR*/"' on BasicBlock '").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/"'...\n");
      break;
     case ON_FUNCTION_MSG:
      dbgs().$out(/*KEEP_STR*/"' on Function '").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/"'...\n");
      break;
     case ON_MODULE_MSG:
      dbgs().$out(/*KEEP_STR*/"' on Module '").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/"'...\n");
      break;
     case ON_REGION_MSG:
      dbgs().$out(/*KEEP_STR*/"' on Region '").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/"'...\n");
      break;
     case ON_LOOP_MSG:
      dbgs().$out(/*KEEP_STR*/"' on Loop '").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/"'...\n");
      break;
     case ON_CG_MSG:
      dbgs().$out(/*KEEP_STR*/"' on Call Graph Nodes '").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/"'...\n");
      break;
     default:
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpRequiredSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1187,
   FQN="llvm::PMDataManager::dumpRequiredSet", NM="_ZNK4llvm13PMDataManager15dumpRequiredSetEPKNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager15dumpRequiredSetEPKNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void dumpRequiredSet(/*const*/ Pass /*P*/ P) /*const*/ {
    AnalysisUsage analysisUsage = null;
    try {
      if (LegacyPassManagerStatics.PassDebugging.$T().getValue() < PassDebugLevel.Details.getValue()) {
        return;
      }

      analysisUsage/*J*/= new AnalysisUsage();
      P.getAnalysisUsage(analysisUsage);
      this.dumpAnalysisUsage(new StringRef(/*KEEP_STR*/"Required"), P, analysisUsage.getRequiredSet());
    } finally {
      if (analysisUsage != null) { analysisUsage.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpPreservedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1196,
   FQN="llvm::PMDataManager::dumpPreservedSet", NM="_ZNK4llvm13PMDataManager16dumpPreservedSetEPKNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager16dumpPreservedSetEPKNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void dumpPreservedSet(/*const*/ Pass /*P*/ P) /*const*/ {
    AnalysisUsage analysisUsage = null;
    try {
      if (LegacyPassManagerStatics.PassDebugging.$T().getValue() < PassDebugLevel.Details.getValue()) {
        return;
      }

      analysisUsage/*J*/= new AnalysisUsage();
      P.getAnalysisUsage(analysisUsage);
      this.dumpAnalysisUsage(new StringRef(/*KEEP_STR*/"Preserved"), P, analysisUsage.getPreservedSet());
    } finally {
      if (analysisUsage != null) { analysisUsage.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpUsedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1205,
   FQN="llvm::PMDataManager::dumpUsedSet", NM="_ZNK4llvm13PMDataManager11dumpUsedSetEPKNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager11dumpUsedSetEPKNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void dumpUsedSet(/*const*/ Pass /*P*/ P) /*const*/ {
    AnalysisUsage analysisUsage = null;
    try {
      if (LegacyPassManagerStatics.PassDebugging.$T().getValue() < PassDebugLevel.Details.getValue()) {
        return;
      }

      analysisUsage/*J*/= new AnalysisUsage();
      P.getAnalysisUsage(analysisUsage);
      this.dumpAnalysisUsage(new StringRef(/*KEEP_STR*/"Used"), P, analysisUsage.getUsedSet());
    } finally {
      if (analysisUsage != null) { analysisUsage.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getNumContainedPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 385,
   FQN="llvm::PMDataManager::getNumContainedPasses", NM="_ZNK4llvm13PMDataManager21getNumContainedPassesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager21getNumContainedPassesEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getNumContainedPasses() /*const*/ {
    return (/*uint*/int)$PMDataManager$Fields().PassVector.size();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 389,
   FQN="llvm::PMDataManager::getPassManagerType", NM="_ZNK4llvm13PMDataManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager18getPassManagerTypeEv")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ PassManagerType getPassManagerType() /*const*/ {
    assert (false) : "Invalid use of getPassManagerType";
    return PassManagerType.PMT_Unknown;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::getAvailableAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 394,
   FQN="llvm::PMDataManager::getAvailableAnalysis", NM="_ZN4llvm13PMDataManager20getAvailableAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager20getAvailableAnalysisEv")
  //</editor-fold>
  public default/*interface*/ DenseMap</*const*/Object/*void P*/, Pass /*P*/ > /*P*/ getAvailableAnalysis() {
    return $AddrOf($PMDataManager$Fields().AvailableAnalysis);
  }


  // Collect AvailableAnalysis from all the active Pass Managers.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::populateInheritedAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 399,
   FQN="llvm::PMDataManager::populateInheritedAnalysis", NM="_ZN4llvm13PMDataManager25populateInheritedAnalysisERNS_7PMStackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm13PMDataManager25populateInheritedAnalysisERNS_7PMStackE")
  //</editor-fold>
  public default/*interface*/ void populateInheritedAnalysis(final PMStack /*&*/ PMS) {
    /*uint*/int Index = 0;
    for (std.reverse_iterator</*const*/ PMDataManager /*&*/ > I = PMS.begin(), E = PMS.end();
         $noteq_reverse_iterator$C(I, E); I.$preInc())  {
      $PMDataManager$Fields().InheritedAnalysis[Index++] = (I.$star()).getAvailableAnalysis();
    }
  }

  /// isPassDebuggingExecutionsOrMore - Return true if -debug-pass=Executions
  /// or higher is specified.
  /// isPassDebuggingExecutionsOrMore - Return true if -debug-pass=Executions
  /// or higher is specified.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::isPassDebuggingExecutionsOrMore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 127,
   FQN="llvm::PMDataManager::isPassDebuggingExecutionsOrMore", NM="_ZNK4llvm13PMDataManager31isPassDebuggingExecutionsOrMoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager31isPassDebuggingExecutionsOrMoreEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ boolean isPassDebuggingExecutionsOrMore() /*const*/ {
    return LegacyPassManagerStatics.PassDebugging.$T().getValue() >= PassDebugLevel.Executions.getValue();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PMDataManager::dumpAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1214,
   FQN="llvm::PMDataManager::dumpAnalysisUsage", NM="_ZNK4llvm13PMDataManager17dumpAnalysisUsageENS_9StringRefEPKNS_4PassERKNS_15SmallVectorImplIPKvEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm13PMDataManager17dumpAnalysisUsageENS_9StringRefEPKNS_4PassERKNS_15SmallVectorImplIPKvEE")
  //</editor-fold>
  public/*private*/ default/*interface*/ void dumpAnalysisUsage(StringRef Msg, /*const*/ Pass /*P*/ P,
                   final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ Set) /*const*/ {
    assert (LegacyPassManagerStatics.PassDebugging.$T().getValue() >= PassDebugLevel.Details.getValue());
    if (Set.empty()) {
      return;
    }
    dbgs().$out(reinterpret_cast(/*const*/Object/*void P*/ .class, P)).$out(new std.string(this.getDepth() * 2 + 3, $$SPACE)).$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/" Analyses:");
    for (/*uint*/int i = 0; i != Set.size(); ++i) {
      if ((i != 0)) {
        dbgs().$out_char($$COMMA);
      }
      /*const*/ PassInfo /*P*/ PInf = $PMDataManager$Fields().TPM.findAnalysisPassInfo(Set.$at$Const(i));
      if (!(PInf != null)) {
        // Some preserved passes, such as AliasAnalysis, may not be initialized by
        // all drivers.
        dbgs().$out(/*KEEP_STR*/" Uninitialized Pass");
        continue;
      }
      dbgs().$out_char($$SPACE).$out(PInf.getPassName());
    }
    dbgs().$out_char($$LF);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static class PMDataManager$Fields {
    /*protected:*/
    // Top level manager.
    public/*protected*/ PMTopLevelManager /*P*/ TPM;

    // Collection of pass that are managed by this manager
    public/*protected*/ SmallVector<Pass /*P*/> PassVector;

    // Collection of Analysis provided by Parent pass manager and
    // used by current pass manager. At at time there can not be more
    // then PMT_Last active pass mangers.
    public/*protected*/ DenseMap</*const*/Object/*void P*/, Pass /*P*/> /*P*/ InheritedAnalysis[/*7*/] = new DenseMap /*P*/[7];

    // Set of available Analysis. This information is used while scheduling
    // pass. If a pass requires an analysis which is not available then
    // the required analysis pass is scheduled to run before the pass itself is
    // scheduled to run.
    public/*private*/ DenseMap</*const*/Object/*void P*/, Pass /*P*/ > AvailableAnalysis;

    // Collection of higher level analysis used by the pass managed by
    // this manager.
    public/*private*/ SmallVector<Pass /*P*/ > HigherLevelAnalysis;

    public/*private*/ /*uint*/int Depth;

    public PMDataManager$Fields() {
      TPM = null;
      PassVector = new SmallVector<Pass /*P*/ >(16, (Pass /*P*/ )null);
      AvailableAnalysis = new DenseMap</*const*/Object/*void P*/, Pass /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Pass /*P*/ )null);
      HigherLevelAnalysis = new SmallVector<Pass /*P*/ >(16, (Pass /*P*/ )null);
      Depth = 0;
    }

    @Override
    public String toString() {
      return "" + "TPM=" + "[PMTopLevelManager]" // NOI18N
              + ", PassVector=" + PassVector // NOI18N
              + ", InheritedAnalysis=" + InheritedAnalysis // NOI18N
              + ", AvailableAnalysis=" + AvailableAnalysis // NOI18N
              + ", HigherLevelAnalysis=" + HigherLevelAnalysis // NOI18N
              + ", Depth=" + Depth; // NOI18N
    }
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*private*/ default PMDataManager$Fields $PMDataManager$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived?");
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

}
