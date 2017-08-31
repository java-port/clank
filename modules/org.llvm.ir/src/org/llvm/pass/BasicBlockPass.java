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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.impl.IRPrintingPassesLlvmGlobals.createPrintBasicBlockPass;


//===----------------------------------------------------------------------===//
/// BasicBlockPass class - This class is used to implement most local
/// optimizations.  Optimizations should subclass this class if they
/// meet the following constraints:
///   1. Optimizations are local, operating on either a basic block or
///      instruction at a time.
///   2. Optimizations do not modify the CFG of the contained function, or any
///      other basic block in the function.
///   3. Optimizations conform to all of the constraints of FunctionPasses.
///
//<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 335,
 FQN="llvm::BasicBlockPass", NM="_ZN4llvm14BasicBlockPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm14BasicBlockPassE")
//</editor-fold>
public abstract class BasicBlockPass extends /*public*/ Pass implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::BasicBlockPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 337,
   FQN="llvm::BasicBlockPass::BasicBlockPass", NM="_ZN4llvm14BasicBlockPassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm14BasicBlockPassC1ERc")
  //</editor-fold>
  public /*explicit*/ BasicBlockPass(final Class<? extends BasicBlockPass>/*char &*/ pid) {
    // : Pass(PT_BasicBlock, pid) 
    //START JInit
    super(PassKind.PT_BasicBlock, pid);
    //END JInit
  }

  
  /// createPrinterPass - Get a basic block printer pass.
  
  /// createPrinterPass - Get a basic block printer pass.
  
  //===----------------------------------------------------------------------===//
  // BasicBlockPass Implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 165,
   FQN="llvm::BasicBlockPass::createPrinterPass", NM="_ZNK4llvm14BasicBlockPass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm14BasicBlockPass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O, 
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    return createPrintBasicBlockPass(O, Banner);
  }


  
  //JAVA: using llvm::Pass::doInitialization;
  //JAVA: using llvm::Pass::doFinalization;
  
  /// doInitialization - Virtual method overridden by BasicBlockPass subclasses
  /// to do any necessary per-function initialization.
  ///
  
  /// doInitialization - Virtual method overridden by BasicBlockPass subclasses
  /// to do any necessary per-function initialization.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 170,
   FQN="llvm::BasicBlockPass::doInitialization", NM="_ZN4llvm14BasicBlockPass16doInitializationERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14BasicBlockPass16doInitializationERNS_8FunctionE")
  //</editor-fold>
  public boolean doInitialization(final Function /*&*/ $Prm0) {
    // By default, don't do anything.
    return false;
  }


  
  /// runOnBasicBlock - Virtual method overriden by subclasses to do the
  /// per-basicblock processing of the pass.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::runOnBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 354,
   FQN="llvm::BasicBlockPass::runOnBasicBlock", NM="_ZN4llvm14BasicBlockPass15runOnBasicBlockERNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm14BasicBlockPass15runOnBasicBlockERNS_10BasicBlockE")
  //</editor-fold>
  public abstract /*virtual*/ boolean runOnBasicBlock(final BasicBlock /*&*/ BB)/* = 0*/;

  
  /// doFinalization - Virtual method overriden by BasicBlockPass subclasses to
  /// do any post processing needed after all passes have run.
  ///
  
  /// doFinalization - Virtual method overriden by BasicBlockPass subclasses to
  /// do any post processing needed after all passes have run.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 175,
   FQN="llvm::BasicBlockPass::doFinalization", NM="_ZN4llvm14BasicBlockPass14doFinalizationERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14BasicBlockPass14doFinalizationERNS_8FunctionE")
  //</editor-fold>
  public boolean doFinalization(final Function /*&*/ $Prm0) {
    // By default, don't do anything.
    return false;
  }


  
  
  /// Find appropriate Basic Pass Manager or Call Graph Pass Manager
  /// in the PM Stack and add self into that manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1875,
   FQN="llvm::BasicBlockPass::assignPassManager", NM="_ZN4llvm14BasicBlockPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm14BasicBlockPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  @Override public void assignPassManager(final PMStack /*&*/ PMS, 
                   PassManagerType PreferredType)/* override*/ {
    BBPassManager /*P*/ BBP;
    
    // Basic Pass Manager is a leaf pass manager. It does not handle
    // any other pass manager.
    if (!PMS.empty()
       && PMS.top().getPassManagerType() == PassManagerType.PMT_BasicBlockPassManager) {
      BBP = (BBPassManager /*P*/ )PMS.top();
    } else {
      // If leaf manager is not Basic Block Pass manager then create new
      // basic Block Pass manager.
      assert (!PMS.empty()) : "Unable to create BasicBlock Pass Manager";
      PMDataManager /*P*/ PMD = PMS.top();
      
      // [1] Create new Basic Block Manager
      BBP = new BBPassManager();
      
      // [2] Set up new manager's top level manager
      // Basic Block Pass Manager does not live by itself
      PMTopLevelManager /*P*/ TPM = PMD.getTopLevelManager();
      TPM.addIndirectPassManager(BBP);
      
      // [3] Assign manager to manage this new manager. This may create
      // and push new managers into PMS
      BBP.assignPassManager(PMS, PreferredType);
      
      // [4] Push new manager into PMS
      PMS.push(BBP);
    }
    
    // Assign BBP as the manager of this pass.
    BBP.add(this);
  }

  
  ///  Return what kind of Pass Manager can manage this pass.
  
  ///  Return what kind of Pass Manager can manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 196,
   FQN="llvm::BasicBlockPass::getPotentialPassManagerType", NM="_ZNK4llvm14BasicBlockPass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm14BasicBlockPass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPotentialPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_BasicBlockPassManager;
  }


/*protected:*/
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when Attribute::OptimizeNone is set or when
  /// optimization bisect is over the limit.
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when Attribute::OptimizeNone is set or when
  /// optimization bisect is over the limit.
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::skipBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 180,
   FQN="llvm::BasicBlockPass::skipBasicBlock", NM="_ZNK4llvm14BasicBlockPass14skipBasicBlockERKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm14BasicBlockPass14skipBasicBlockERKNS_10BasicBlockE")
  //</editor-fold>
  protected boolean skipBasicBlock(final /*const*/ BasicBlock /*&*/ BB) /*const*/ {
    /*const*/ Function /*P*/ F = BB.getParent$Const();
    if (!(F != null)) {
      return false;
    }
    if (!F.getContext().getOptBisect().shouldRunPass(this, BB)) {
      return true;
    }
    if (F.hasFnAttribute(Attribute.AttrKind.OptimizeNone)) {
      // Report this only once per function.
      if ($AddrOf(BB) == $AddrOf(F.getEntryBlock$Const())) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"ir")) {
            dbgs().$out(/*KEEP_STR*/"Skipping pass '").$out(getPassName()).$out(/*KEEP_STR*/"' on function ").$out(F.getName()).$out(/*KEEP_STR*/$LF);
          }
        } while (false);
      }
      return true;
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockPass::~BasicBlockPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 335,
   FQN="llvm::BasicBlockPass::~BasicBlockPass", NM="_ZN4llvm14BasicBlockPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm14BasicBlockPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
