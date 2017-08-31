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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import org.llvm.pass.*;


//===----------------------------------------------------------------------===//
// PMTopLevelManager
//
/// PMTopLevelManager manages LastUser info and collects common APIs used by
/// top level pass managers.
//<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 166,
 FQN="llvm::PMTopLevelManager", NM="_ZN4llvm17PMTopLevelManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManagerE")
//</editor-fold>
public abstract interface/*class*/ PMTopLevelManager extends Destructors.ClassWithDestructor {
/*protected:*/

  //===----------------------------------------------------------------------===//
  // PMTopLevelManager implementation

  /// Initialize top level manager. Create first pass manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::PMTopLevelManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 494,
   FQN="llvm::PMTopLevelManager::PMTopLevelManager", NM="_ZN4llvm17PMTopLevelManagerC1EPNS_13PMDataManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManagerC1EPNS_13PMDataManagerE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ PMTopLevelManager$Fields $PMTopLevelManager(PMDataManager /*P*/ PMDM) {
    // : activeStack(), PassManagers(), IndirectPassManagers(), LastUser(), InversedLastUser(), ImmutablePasses(), ImmutablePassMap(), UniqueAnalysisUsages(), AUFoldingSetNodeAllocator(), AnUsageMap(), AnalysisPassInfos()
    PMDM.setTopLevelManager(this);
    PMTopLevelManager$Fields $Fields = new PMTopLevelManager$Fields();
    $Fields.activeStack.push(PMDM);
    this.addPassManager(PMDM, $Fields);
    return $Fields;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::getNumContainedManagers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 170,
   FQN="llvm::PMTopLevelManager::getNumContainedManagers", NM="_ZNK4llvm17PMTopLevelManager23getNumContainedManagersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm17PMTopLevelManager23getNumContainedManagersEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ /*uint*/int getNumContainedManagers() /*const*/ {
    return (/*uint*/int)$PMTopLevelManager$Fields().PassManagers.size();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::initializeAllAnalysisInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 788,
   FQN="llvm::PMTopLevelManager::initializeAllAnalysisInfo", NM="_ZN4llvm17PMTopLevelManager25initializeAllAnalysisInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager25initializeAllAnalysisInfoEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ void initializeAllAnalysisInfo() {
    for (PMDataManager /*P*/ PM : $PMTopLevelManager$Fields().PassManagers)  {
      PM.initializeAnalysisInfo();
    }

    // Initailize other pass managers
    for (PMDataManager /*P*/ IPM : $PMTopLevelManager$Fields().IndirectPassManagers)  {
      IPM.initializeAnalysisInfo();
    }

    for (DenseMapIterator<Pass /*P*/ , Pass /*P*/ > DMI = $PMTopLevelManager$Fields().LastUser.begin(),
        DME = $PMTopLevelManager$Fields().LastUser.end(); DMI.$noteq(/*NO_ITER_COPY*/DME); DMI.$preInc()) {
      final SmallPtrSet<Pass /*P*/ > /*&*/ L = $PMTopLevelManager$Fields().InversedLastUser.$at_T1$C$R(DMI.$arrow().second);
      L.insert(DMI.$arrow().first);
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 177,
   FQN="llvm::PMTopLevelManager::getAsPMDataManager", NM="_ZN4llvm17PMTopLevelManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager18getAsPMDataManagerEv")
  //</editor-fold>
  public/*private*/ /*interface*/ abstract /*virtual*/ PMDataManager /*P*/ getAsPMDataManager()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::getTopLevelPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 178,
   FQN="llvm::PMTopLevelManager::getTopLevelPassManagerType", NM="_ZN4llvm17PMTopLevelManager26getTopLevelPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager26getTopLevelPassManagerTypeEv")
  //</editor-fold>
  public/*private*/ /*interface*/ abstract /*virtual*/ PassManagerType getTopLevelPassManagerType()/* = 0*/;

/*public:*/
  /// Schedule pass P for execution. Make sure that passes required by
  /// P are run before P is run. Update analysis info maintained by
  /// the manager. Remove dead passes. This is a recursive function.

  /// Schedule pass P for execution. Make sure that passes required by
  /// P are run before P is run. Update analysis info maintained by
  /// the manager. Remove dead passes. This is a recursive function.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::schedulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 602,
   FQN="llvm::PMTopLevelManager::schedulePass", NM="_ZN4llvm17PMTopLevelManager12schedulePassEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager12schedulePassEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ void schedulePass(Pass /*P*/ P) {

    // TODO : Allocate function manager for this pass, other wise required set
    // may be inserted into previous function manager

    // Give pass a chance to prepare the stage.
    P.preparePassManager($PMTopLevelManager$Fields().activeStack);

    // If P is an analysis pass and it is available then do not
    // generate the analysis again. Stale analysis info should not be
    // available at this point.
    /*const*/ PassInfo /*P*/ PI = this.findAnalysisPassInfo(P.getPassID());
    if ((PI != null) && PI.isAnalysis() && (this.findAnalysisPass(P.getPassID()) != null)) {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)P);
      return;
    }

    AnalysisUsage /*P*/ AnUsage = this.findAnalysisUsage(P);

    boolean checkAnalysis = true;
    while (checkAnalysis) {
      checkAnalysis = false;

      final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ RequiredSet = AnUsage.getRequiredSet();
      for (/*const*/type$ptr<Object>/*void P const P*/ I = $tryClone(RequiredSet.begin$Const()),
          /*P*/ E = $tryClone(RequiredSet.end$Const()); $noteq_ptr(I, E); I.$preInc()) {

        Pass /*P*/ AnalysisPass = this.findAnalysisPass(I.$star());
        if (!(AnalysisPass != null)) {
          /*const*/ PassInfo /*P*/ PI$1 = this.findAnalysisPassInfo(I.$star());
          if (!(PI$1 != null)) {
            // Pass P is not in the global PassRegistry
            dbgs().$out(/*KEEP_STR*/"Pass '").$out(P.getPassName()).$out(/*KEEP_STR*/"' is not initialized.").$out(/*KEEP_STR*/$LF);
            dbgs().$out(/*KEEP_STR*/"Verify if there is a pass dependency cycle.").$out(/*KEEP_STR*/$LF);
            dbgs().$out(/*KEEP_STR*/"Required Passes:").$out(/*KEEP_STR*/$LF);
            for (/*const*/type$ptr<Object>/*void P const P*/ I2 = $tryClone(RequiredSet.begin$Const()),
                /*P*/ E$1 = $tryClone(RequiredSet.end$Const()); $noteq_ptr(I2, E$1) && $noteq_ptr(I2, I); I2.$preInc()) {
              Pass /*P*/ AnalysisPass2 = this.findAnalysisPass(I2.$star());
              if ((AnalysisPass2 != null)) {
                dbgs().$out(/*KEEP_STR*/$TAB).$out(AnalysisPass2.getPassName()).$out(/*KEEP_STR*/$LF);
              } else {
                dbgs().$out(/*KEEP_STR*/$TAB).$out(/*KEEP_STR*/"Error: Required pass not found! Possible causes:").$out(/*KEEP_STR*/$LF);
                dbgs().$out(/*KEEP_STR*/"\t\t").$out(/*KEEP_STR*/"- Pass misconfiguration (e.g.: missing macros)").$out(/*KEEP_STR*/$LF);
                dbgs().$out(/*KEEP_STR*/"\t\t").$out(/*KEEP_STR*/"- Corruption of the global PassRegistry").$out(/*KEEP_STR*/$LF);
              }
            }
          }
          assert ((PI$1 != null)) : "Expected required passes to be initialized";
          AnalysisPass = PI$1.createPass();
          if (P.getPotentialPassManagerType()
             == AnalysisPass.getPotentialPassManagerType()) {
            // Schedule analysis pass that is managed by the same pass manager.
            this.schedulePass(AnalysisPass);
          } else if (P.getPotentialPassManagerType().getValue()
             > AnalysisPass.getPotentialPassManagerType().getValue()) {
            // Schedule analysis pass that is managed by a new manager.
            this.schedulePass(AnalysisPass);
            // Recheck analysis passes to ensure that required analyses that
            // are already checked are still available.
            checkAnalysis = true;
          } else {
            // Do not schedule this analysis. Lower level analysis
            // passes are run on the fly.
            /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)AnalysisPass);
          }
        }
      }
    }
    {

      // Now all required passes are available.
      ImmutablePass /*P*/ IP = P.getAsImmutablePass();
      if ((IP != null)) {
        // P is a immutable pass and it will be managed by this
        // top level manager. Set up analysis resolver to connect them.
        PMDataManager /*P*/ DM = this.getAsPMDataManager();
        AnalysisResolver /*P*/ AR = new AnalysisResolver($Deref(DM));
        P.setResolver(AR);
        DM.initializeAnalysisImpl(P);
        this.addImmutablePass(IP);
        DM.recordAvailableAnalysis(IP);
        return;
      }
    }
    if ((PI != null) && !PI.isAnalysis() && LegacyPassManagerStatics.ShouldPrintBeforePass(PI)) {
      Pass /*P*/ PP = P.createPrinterPass(dbgs(), $add_string_T$C$P($add_string_T$C$P(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"*** IR Dump Before "), P.getPassName()), /*KEEP_STR*/" ***"));
      PP.assignPassManager($PMTopLevelManager$Fields().activeStack, this.getTopLevelPassManagerType());
    }

    // Add the requested pass to the best available pass manager.
    P.assignPassManager($PMTopLevelManager$Fields().activeStack, this.getTopLevelPassManagerType());
    if ((PI != null) && !PI.isAnalysis() && LegacyPassManagerStatics.ShouldPrintAfterPass(PI)) {
      Pass /*P*/ PP = P.createPrinterPass(dbgs(), $add_string_T$C$P($add_string_T$C$P(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"*** IR Dump After "), P.getPassName()), /*KEEP_STR*/" ***"));
      PP.assignPassManager($PMTopLevelManager$Fields().activeStack, this.getTopLevelPassManagerType());
    }
  }


  /// Set pass P as the last user of the given analysis passes.

  /// Set pass P as the last user of the given analysis passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::setLastUser">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 501,
   FQN="llvm::PMTopLevelManager::setLastUser", NM="_ZN4llvm17PMTopLevelManager11setLastUserENS_8ArrayRefIPNS_4PassEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager11setLastUserENS_8ArrayRefIPNS_4PassEEES3_")
  //</editor-fold>
  public default/*interface*/ void setLastUser(ArrayRef<Pass /*P*/ > AnalysisPasses, Pass /*P*/ P) {
    /*uint*/int PDepth = 0;
    if ((P.getResolver() != null)) {
      PDepth = P.getResolver().getPMDataManager().getDepth();
    }

    for (Pass /*P*/ AP : AnalysisPasses) {
      $PMTopLevelManager$Fields().LastUser.$set(AP, P);
      if (P == AP) {
        continue;
      }

      // Update the last users of passes that are required transitive by AP.
      AnalysisUsage /*P*/ AnUsage = this.findAnalysisUsage(AP);
      final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ IDs = AnUsage.getRequiredTransitiveSet();
      SmallVector<Pass /*P*/ > LastUses/*J*/= new SmallVector<Pass /*P*/ >(12, (Pass /*P*/ )null);
      SmallVector<Pass /*P*/ > LastPMUses/*J*/= new SmallVector<Pass /*P*/ >(12, (Pass /*P*/ )null);
      for (/*const*/Object/*void P*/ ID : IDs) {
        assert Pass.class.isAssignableFrom((Class)ID) : "Expected child of Pass: " + ID;
        Pass /*P*/ AnalysisPass = this.findAnalysisPass(ID);
        assert ((AnalysisPass != null)) : "Expected analysis pass to exist.";
        AnalysisResolver /*P*/ AR = AnalysisPass.getResolver();
        assert ((AR != null)) : "Expected analysis resolver to exist.";
        /*uint*/int APDepth = AR.getPMDataManager().getDepth();
        if (PDepth == APDepth) {
          LastUses.push_back(AnalysisPass);
        } else if ($greater_uint(PDepth, APDepth)) {
          LastPMUses.push_back(AnalysisPass);
        }
      }

      this.setLastUser(new ArrayRef<Pass /*P*/ >(LastUses, true), P);

      // If this pass has a corresponding pass manager, push higher level
      // analysis to this pass manager.
      if ((P.getResolver() != null)) {
        this.setLastUser(new ArrayRef<Pass /*P*/ >(LastPMUses, true), P.getResolver().getPMDataManager().getAsPass());
      }

      // If AP is the last user of other passes then make P last user of
      // such passes.
      for (DenseMapIterator<Pass /*P*/ , Pass /*P*/ > LUI = $PMTopLevelManager$Fields().LastUser.begin(),
          LUE = $PMTopLevelManager$Fields().LastUser.end(); LUI.$noteq(/*NO_ITER_COPY*/LUE); LUI.$preInc()) {
        if (LUI.$arrow().second == AP) {
          // DenseMap iterator is not invalidated here because
          // this is just updating existing entries.
          $PMTopLevelManager$Fields().LastUser.$set(LUI.$arrow().first, P);
        }
      }
    }
  }


  /// Collect passes whose last user is P

  /// Collect passes whose last user is P
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::collectLastUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 552,
   FQN="llvm::PMTopLevelManager::collectLastUses", NM="_ZN4llvm17PMTopLevelManager15collectLastUsesERNS_15SmallVectorImplIPNS_4PassEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager15collectLastUsesERNS_15SmallVectorImplIPNS_4PassEEES3_")
  //</editor-fold>
  public default/*interface*/ void collectLastUses(final SmallVectorImpl<Pass /*P*/ > /*&*/ LastUses,
                 Pass /*P*/ P) {
    DenseMapIterator<Pass /*P*/ , SmallPtrSet<Pass /*P*/ >> DMI = $PMTopLevelManager$Fields().InversedLastUser.find(P);
    if (DMI.$eq(/*NO_ITER_COPY*/$PMTopLevelManager$Fields().InversedLastUser.end())) {
      return;
    }

    final SmallPtrSet<Pass /*P*/ > /*&*/ LU = DMI.$arrow().second;
    for (Pass /*P*/ LUP : LU) {
      LastUses.push_back(LUP);
    }
  }


  /// Find the pass that implements Analysis AID. Search immutable
  /// passes and all pass managers. If desired pass is not found
  /// then return NULL.

  /// Find the pass that implements Analysis AID. Search immutable
  /// passes and all pass managers. If desired pass is not found
  /// then return NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::findAnalysisPass">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 704,
   FQN="llvm::PMTopLevelManager::findAnalysisPass", NM="_ZN4llvm17PMTopLevelManager16findAnalysisPassEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager16findAnalysisPassEPKv")
  //</editor-fold>
  public default/*interface*/ Pass /*P*/ findAnalysisPass(/*const*/Object/*void P*/ AID) {
    assert Pass.class.isAssignableFrom((Class)AID) : "Expected child of Pass: " + AID;
    {
      // For immutable passes we have a direct mapping from ID to pass, so check
      // that first.
      Pass /*P*/ P = $PMTopLevelManager$Fields().ImmutablePassMap.lookup(AID);
      if ((P != null)) {
        return P;
      }
    }

    // Check pass managers
    for (PMDataManager /*P*/ PassManager : $PMTopLevelManager$Fields().PassManagers)  {
      {
        Pass /*P*/ P = PassManager.findAnalysisPass(AID, false);
        if ((P != null)) {
          return P;
        }
      }
    }

    // Check other pass managers
    for (PMDataManager /*P*/ IndirectPassManager : $PMTopLevelManager$Fields().IndirectPassManagers)  {
      {
        Pass /*P*/ P = IndirectPassManager.findAnalysisPass(AID, false);
        if ((P != null)) {
          return P;
        }
      }
    }

    return null;
  }


  /// Retrieve the PassInfo for an analysis.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::findAnalysisPassInfo">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 723,
   FQN="llvm::PMTopLevelManager::findAnalysisPassInfo", NM="_ZNK4llvm17PMTopLevelManager20findAnalysisPassInfoEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm17PMTopLevelManager20findAnalysisPassInfoEPKv")
  //</editor-fold>
  public default/*interface*/ /*const*/ PassInfo /*P*/ findAnalysisPassInfo(/*const*/Object/*void P*/ AID) /*const*/ {
    assert Pass.class.isAssignableFrom((Class)AID) : "Expected child of Pass: " + AID;
    final type$ref</*const*/ PassInfo /*P*/ /*&*/> PI = $PMTopLevelManager$Fields().AnalysisPassInfos.ref$at(AID);
    if (!(PI.$deref() != null)) {
      PI.$set(PassRegistry.getPassRegistry().getPassInfo(AID));
    } else {
      assert (PI.$deref() == PassRegistry.getPassRegistry().getPassInfo(AID)) : "The pass info pointer changed for an analysis ID!";
    }

    return PI.$deref();
  }


  /// Find analysis usage information for the pass P.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::findAnalysisUsage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 566,
   FQN="llvm::PMTopLevelManager::findAnalysisUsage", NM="_ZN4llvm17PMTopLevelManager17findAnalysisUsageEPNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager17findAnalysisUsageEPNS_4PassE")
  //</editor-fold>
  public default/*interface*/ AnalysisUsage /*P*/ findAnalysisUsage(Pass /*P*/ P) {
    AnalysisUsage /*P*/ AnUsage = null;
    DenseMapIterator<Pass /*P*/ , AnalysisUsage /*P*/ > DMI = $PMTopLevelManager$Fields().AnUsageMap.find(P);
    if (DMI.$noteq(/*NO_ITER_COPY*/$PMTopLevelManager$Fields().AnUsageMap.end())) {
      AnUsage = DMI.$arrow().second;
    } else {
      AnalysisUsage AU = null;
      try {
        // Look up the analysis usage from the pass instance (different instances
        // of the same pass can produce different results), but unique the
        // resulting object to reduce memory usage.  This helps to greatly reduce
        // memory usage when we have many instances of only a few pass types
        // (e.g. instcombine, simplifycfg, etc...) which tend to share a fixed set
        // of dependencies.
        AU/*J*/= new AnalysisUsage();
        P.getAnalysisUsage(AU);

        AUFoldingSetNode /*P*/ Node = null;
        FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
        AUFoldingSetNode.Profile(ID, AU);
        type$ref<type$ptr<AUFoldingSetNode>/*void P*/ > IP = create_type$null$ref(null);
        {
          AUFoldingSetNode /*P*/ N = $PMTopLevelManager$Fields().UniqueAnalysisUsages.FindNodeOrInsertPos(ID, IP);
          if ((N != null)) {
            Node = N;
          } else {
            AnalysisUsage AU$Final = AU;
            Node = ((/*JCast*/AUFoldingSetNode /*P*/ )(/*NEW_EXPR [System]*//*new (AUFoldingSetNodeAllocator.Allocate())*/ $new_uint_voidPtr($PMTopLevelManager$Fields().AUFoldingSetNodeAllocator.Allocate(), (type$ptr<?> New$Mem)->{
                return new AUFoldingSetNode(AU$Final);
             })));
            $PMTopLevelManager$Fields().UniqueAnalysisUsages.InsertNode(Node, IP.$deref());
          }
        }
        assert ((Node != null)) : "cached analysis usage must be non null";

        $PMTopLevelManager$Fields().AnUsageMap.$set(P, $AddrOf(Node.AU));
        AnUsage = $AddrOf(Node.AU);
        ;
      } finally {
        if (AU != null) { AU.$destroy(); }
      }
    }
    return AnUsage;
  }



  /// Destructor
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::~PMTopLevelManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 804,
   FQN="llvm::PMTopLevelManager::~PMTopLevelManager", NM="_ZN4llvm17PMTopLevelManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManagerD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$PMTopLevelManager() {
    for (PMDataManager /*P*/ PM : $PMTopLevelManager$Fields().PassManagers)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)PM);
    }

    for (ImmutablePass /*P*/ P : $PMTopLevelManager$Fields().ImmutablePasses)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)P);
    }
    //START JDestroy
    $PMTopLevelManager$Fields().AnalysisPassInfos.$destroy();
    $PMTopLevelManager$Fields().AnUsageMap.$destroy();
    $PMTopLevelManager$Fields().AUFoldingSetNodeAllocator.$destroy();
    $PMTopLevelManager$Fields().UniqueAnalysisUsages.$destroy();
    $PMTopLevelManager$Fields().ImmutablePassMap.$destroy();
    $PMTopLevelManager$Fields().ImmutablePasses.$destroy();
    $PMTopLevelManager$Fields().InversedLastUser.$destroy();
    $PMTopLevelManager$Fields().LastUser.$destroy();
    $PMTopLevelManager$Fields().IndirectPassManagers.$destroy();
    $PMTopLevelManager$Fields().PassManagers.$destroy();
    $PMTopLevelManager$Fields().activeStack.$destroy();
    //END JDestroy
  }


  /// Add immutable pass and initialize it.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::addImmutablePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 734,
   FQN="llvm::PMTopLevelManager::addImmutablePass", NM="_ZN4llvm17PMTopLevelManager16addImmutablePassEPNS_13ImmutablePassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager16addImmutablePassEPNS_13ImmutablePassE")
  //</editor-fold>
  public default/*interface*/ void addImmutablePass(ImmutablePass /*P*/ P) {
    P.initializePass();
    $PMTopLevelManager$Fields().ImmutablePasses.push_back(P);

    // Add this pass to the map from its analysis ID. We clobber any prior runs
    // of the pass in the map so that the last one added is the one found when
    // doing lookups.
    /*const*/Object/*void P*/ AID = P.getPassID();
    $PMTopLevelManager$Fields().ImmutablePassMap.$set(AID, P);

    // Also add any interfaces implemented by the immutable pass to the map for
    // fast lookup.
    /*const*/ PassInfo /*P*/ PassInf = this.findAnalysisPassInfo(AID);
    assert ((PassInf != null)) : "Expected all immutable passes to be initialized";
    for (/*const*/ PassInfo /*P*/ ImmPI : PassInf.getInterfacesImplemented())  {
      $PMTopLevelManager$Fields().ImmutablePassMap.$set(ImmPI.getTypeInfo(), P);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::getImmutablePasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 208,
   FQN="llvm::PMTopLevelManager::getImmutablePasses", NM="_ZN4llvm17PMTopLevelManager18getImmutablePassesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager18getImmutablePassesEv")
  //</editor-fold>
  public default/*interface*/ /*inline*/ SmallVectorImpl<ImmutablePass /*P*/ > /*&*/ getImmutablePasses() {
    return $PMTopLevelManager$Fields().ImmutablePasses;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::addPassManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 212,
   FQN="llvm::PMTopLevelManager::addPassManager", NM="_ZN4llvm17PMTopLevelManager14addPassManagerEPNS_13PMDataManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager14addPassManagerEPNS_13PMDataManagerE")
  //</editor-fold>
  public default/*interface*/ void addPassManager(PMDataManager /*P*/ Manager) {
    addPassManager(Manager, $PMTopLevelManager$Fields());
  }
  public default/*interface*/ void addPassManager(PMDataManager /*P*/ Manager, PMTopLevelManager$Fields $Fields) {
    $Fields.PassManagers.push_back(Manager);
  }


  // Add Manager into the list of managers that are not directly
  // maintained by this top level pass manager
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::addIndirectPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 218,
   FQN="llvm::PMTopLevelManager::addIndirectPassManager", NM="_ZN4llvm17PMTopLevelManager22addIndirectPassManagerEPNS_13PMDataManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager22addIndirectPassManagerEPNS_13PMDataManagerE")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void addIndirectPassManager(PMDataManager /*P*/ Manager) {
    $PMTopLevelManager$Fields().IndirectPassManagers.push_back(Manager);
  }


  // Print passes managed by this top level manager.

  // Print passes managed by this top level manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::dumpPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 753,
   FQN="llvm::PMTopLevelManager::dumpPasses", NM="_ZNK4llvm17PMTopLevelManager10dumpPassesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm17PMTopLevelManager10dumpPassesEv")
  //</editor-fold>
  public default/*interface*/ void dumpPasses() /*const*/ {
    if (LegacyPassManagerStatics.PassDebugging.$T().getValue() < PassDebugLevel.Structure.getValue()) {
      return;
    }

    // Print out the immutable passes
    for (/*uint*/int i = 0, e = $PMTopLevelManager$Fields().ImmutablePasses.size(); i != e; ++i) {
      $PMTopLevelManager$Fields().ImmutablePasses.$at$Const(i).dumpPassStructure(0);
    }

    // Every class that derives from PMDataManager also derives from Pass
    // (sometimes indirectly), but there's no inheritance relationship
    // between PMDataManager and Pass, so we have to getAsPass to get
    // from a PMDataManager* to a Pass*.
    for (PMDataManager /*P*/ Manager : $PMTopLevelManager$Fields().PassManagers) {
      Manager.getAsPass().dumpPassStructure(1);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::dumpArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 771,
   FQN="llvm::PMTopLevelManager::dumpArguments", NM="_ZNK4llvm17PMTopLevelManager13dumpArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm17PMTopLevelManager13dumpArgumentsEv")
  //</editor-fold>
  public default/*interface*/ void dumpArguments() /*const*/ {
    if (LegacyPassManagerStatics.PassDebugging.$T().getValue() < PassDebugLevel.Arguments.getValue()) {
      return;
    }

    dbgs().$out(/*KEEP_STR*/"Pass Arguments: ");
    for (ImmutablePass /*P*/ P : $PMTopLevelManager$Fields().ImmutablePasses) {
      {
        /*const*/ PassInfo /*P*/ PI = this.findAnalysisPassInfo(P.getPassID());
        if ((PI != null)) {
          assert ((PI != null)) : "Expected all immutable passes to be initialized";
          if (!PI.isAnalysisGroup()) {
            dbgs().$out(/*KEEP_STR*/" -").$out(PI.getPassArgument());
          }
        }
      }
    }
    for (PMDataManager /*P*/ PM : $PMTopLevelManager$Fields().PassManagers) {
      PM.dumpPassArguments();
    }
    dbgs().$out(/*KEEP_STR*/$LF);
  }

  /// A wrapper around AnalysisUsage for the purpose of uniqueing.  The wrapper
  /// is used to avoid needing to make AnalysisUsage itself a folding set node.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::AUFoldingSetNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 256,
   FQN="llvm::PMTopLevelManager::AUFoldingSetNode", NM="_ZN4llvm17PMTopLevelManager16AUFoldingSetNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager16AUFoldingSetNodeE")
  //</editor-fold>
  public/*private*/ static class/*struct*/ AUFoldingSetNode implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
    public AnalysisUsage AU;
    //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::AUFoldingSetNode::AUFoldingSetNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 258,
     FQN="llvm::PMTopLevelManager::AUFoldingSetNode::AUFoldingSetNode", NM="_ZN4llvm17PMTopLevelManager16AUFoldingSetNodeC1ERKNS_13AnalysisUsageE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager16AUFoldingSetNodeC1ERKNS_13AnalysisUsageE")
    //</editor-fold>
    public AUFoldingSetNode(final /*const*/ AnalysisUsage /*&*/ AU) {
      // : FoldingSetNode(), AU(AU)
      //START JInit
      $Node();
      this.AU = new AnalysisUsage(AU);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::AUFoldingSetNode::Profile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 259,
     FQN="llvm::PMTopLevelManager::AUFoldingSetNode::Profile", NM="_ZNK4llvm17PMTopLevelManager16AUFoldingSetNode7ProfileERNS_16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm17PMTopLevelManager16AUFoldingSetNode7ProfileERNS_16FoldingSetNodeIDE")
    //</editor-fold>
    public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
      AUFoldingSetNode.Profile(ID, AU);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::AUFoldingSetNode::Profile">
    @Converted(kind = Converted.Kind.MANUAL,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 262,
     FQN="llvm::PMTopLevelManager::AUFoldingSetNode::Profile", NM="_ZN4llvm17PMTopLevelManager16AUFoldingSetNode7ProfileERNS_16FoldingSetNodeIDERKNS_13AnalysisUsageE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager16AUFoldingSetNode7ProfileERNS_16FoldingSetNodeIDERKNS_13AnalysisUsageE")
    //</editor-fold>
    public static void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ AnalysisUsage /*&*/ AU) {
      // TODO: We could consider sorting the dependency arrays within the
      // AnalysisUsage (since they are conceptually unordered).
      ID.AddBoolean(AU.getPreservesAll());
      Type2Void<SmallVectorImpl<Object>> ProfileVec = /*[&, &ID]*/ (final /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ Vec) -> {
            ID.AddInteger_uint(Vec.size());
            for (/*const*/Object/*void P*/ AID : Vec)  {
              assert Pass.class.isAssignableFrom((Class)AID) : "Expected child of Pass: " + AID;
              ID.AddPointer(AID);
            }
          };
      ProfileVec.$call(AU.getRequiredSet());
      ProfileVec.$call(AU.getRequiredTransitiveSet());
      ProfileVec.$call(AU.getPreservedSet());
      ProfileVec.$call(AU.getUsedSet());
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::PMTopLevelManager::AUFoldingSetNode::~AUFoldingSetNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 256,
     FQN="llvm::PMTopLevelManager::AUFoldingSetNode::~AUFoldingSetNode", NM="_ZN4llvm17PMTopLevelManager16AUFoldingSetNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm17PMTopLevelManager16AUFoldingSetNodeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      AU.$destroy();
      FoldingSetImpl.Node.super.$destroy$Node();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public void $Node() {}

    @Override
    public FoldingSetImpl.NodeImpl $nodeImpl() {
      return $nodeImpl;
    }

    private final FoldingSetImpl.NodeImpl $nodeImpl = new FoldingSetImpl.NodeImpl();

    private static FoldingSetTrait<AUFoldingSetNode> $Trait = new FoldingSetTraitAUFoldingSetNode();

    private static FoldingSetTrait<AUFoldingSetNode> $Trait() { return $Trait; }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "AU=" + AU // NOI18N
                + super.toString(); // NOI18N
    }
  };

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 252)
  class FoldingSetTraitAUFoldingSetNode implements FoldingSetTrait<AUFoldingSetNode> {
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 261)
    @Override
    public void Profile(AUFoldingSetNode X, FoldingSetNodeID ID) {
      X.Profile(ID);
    }


    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 387)
    @Override
    public boolean Equals(AUFoldingSetNode X, FoldingSetNodeID ID, int $Prm2, FoldingSetNodeID TempID) {
      X.Profile(TempID);
      return $eq(TempID, ID);
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 397)
    public int ComputeHash(AUFoldingSetNode X, FoldingSetNodeID TempID) {
      return TempID.ComputeHash();
    }
  }

  public static class PMTopLevelManager$Fields {

    // Active Pass Managers
    public PMStack activeStack;
    /*protected:*/
    /// Collection of pass managers
    public/*protected*/ SmallVector<PMDataManager /*P*/> PassManagers;
    /*private:*/
    /// Collection of pass managers that are not directly maintained
    /// by this pass manager
    private SmallVector<PMDataManager /*P*/> IndirectPassManagers;

    // Map to keep track of last user of the analysis pass.
    // LastUser->second is the last user of Lastuser->first.
    private DenseMap<Pass /*P*/, Pass /*P*/> LastUser;

    // Map to keep track of passes that are last used by a pass.
    // This inverse map is initialized at PM->run() based on
    // LastUser map.
    private DenseMap<Pass /*P*/, SmallPtrSet<Pass /*P*/>> InversedLastUser;

    /// Immutable passes are managed by top level manager.
    private SmallVector<ImmutablePass /*P*/> ImmutablePasses;

    /// Map from ID to immutable passes.
    private SmallDenseMap</*AnalysisID*/Object, ImmutablePass /*,8*/> ImmutablePassMap;

    // Contains all of the unique combinations of AnalysisUsage.  This is helpful
    // when we have multiple instances of the same pass since they'll usually
    // have the same analysis usage and can share storage.

    private FoldingSet<AUFoldingSetNode> UniqueAnalysisUsages;

    // Allocator used for allocating UAFoldingSetNodes.  This handles deletion of
    // all allocated nodes in one fell swoop.
    private SpecificBumpPtrAllocator<AUFoldingSetNode> AUFoldingSetNodeAllocator;

    // Maps from a pass to it's associated entry in UniqueAnalysisUsages.  Does
    // not own the storage associated with either key or value..
    private DenseMap<Pass /*P*/, AnalysisUsage /*P*/> AnUsageMap;

    /// Collection of PassInfo objects found via analysis IDs and in this top
    /// level manager. This is used to memoize queries to the pass registry.
    /// FIXME: This is an egregious hack because querying the pass registry is
    /// either slow or racy.
    private /*mutable */ DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/> AnalysisPassInfos;

    private PMTopLevelManager$Fields() {
      activeStack = new PMStack();
      PassManagers = new SmallVector<PMDataManager /*P*/>(8, (PMDataManager /*P*/) null);
      IndirectPassManagers = new SmallVector<PMDataManager /*P*/>(8, (PMDataManager /*P*/) null);
      LastUser = new DenseMap<Pass /*P*/, Pass /*P*/>(DenseMapInfo$LikePtr.$Info(), (Pass /*P*/) null);
      InversedLastUser = new DenseMap<Pass /*P*/, SmallPtrSet<Pass /*P*/>>(DenseMapInfo$LikePtr.$Info(), new SmallPtrSet<Pass /*P*/>(DenseMapInfo$LikePtr.$Info(), 8));
      ImmutablePasses = new SmallVector<ImmutablePass /*P*/>(16, (ImmutablePass /*P*/) null);
      ImmutablePassMap = new SmallDenseMap<>(DenseMapInfo$LikePtr.$Info(), (ImmutablePass) null);
      UniqueAnalysisUsages = new FoldingSet<AUFoldingSetNode>(AUFoldingSetNode.$Trait());
      AUFoldingSetNodeAllocator = new SpecificBumpPtrAllocator<AUFoldingSetNode>(AUFoldingSetNode.class);
      AnUsageMap = new DenseMap<Pass /*P*/, AnalysisUsage /*P*/>(DenseMapInfo$LikePtr.$Info(), (AnalysisUsage /*P*/) null);
      AnalysisPassInfos = new DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/>(/*DenseMapInfo$LikePtr*/DenseMapInfo$LikePtr.$Info(), (/*const*/PassInfo /*P*/) null);
    }

    @Override
    public String toString() {
      return "" + "activeStack=" + activeStack // NOI18N
              + ", PassManagers=" + "[SmallVector$PMDataManager]" // NOI18N
              + ", IndirectPassManagers=" + "[SmallVector$PMDataManager]" // NOI18N
              + ", LastUser=" + LastUser // NOI18N
              + ", InversedLastUser=" + InversedLastUser // NOI18N
              + ", ImmutablePasses=" + ImmutablePasses // NOI18N
              + ", ImmutablePassMap=" + ImmutablePassMap // NOI18N
              + ", UniqueAnalysisUsages=" + UniqueAnalysisUsages // NOI18N
              + ", AUFoldingSetNodeAllocator=" + AUFoldingSetNodeAllocator // NOI18N
              + ", AnUsageMap=" + AnUsageMap // NOI18N
              + ", AnalysisPassInfos=" + AnalysisPassInfos; // NOI18N
    }
  }

  default PMTopLevelManager$Fields $PMTopLevelManager$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived?");
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

}
