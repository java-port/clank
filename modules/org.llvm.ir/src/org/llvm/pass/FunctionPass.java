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
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.impl.IRPrintingPassesLlvmGlobals.createPrintFunctionPass;


//===----------------------------------------------------------------------===//
/// FunctionPass class - This class is used to implement most global
/// optimizations.  Optimizations should subclass this class if they meet the
/// following constraints:
///
///  1. Optimizations are organized globally, i.e., a function at a time
///  2. Optimizing a function does not cause the addition or removal of any
///     functions in the module
///
//<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 298,
 FQN="llvm::FunctionPass", NM="_ZN4llvm12FunctionPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm12FunctionPassE")
//</editor-fold>
public abstract class FunctionPass extends /*public*/ Pass implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::FunctionPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 300,
   FQN="llvm::FunctionPass::FunctionPass", NM="_ZN4llvm12FunctionPassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm12FunctionPassC1ERc")
  //</editor-fold>
  public /*explicit*/ FunctionPass(final Class<? extends FunctionPass>/*char &*/ pid) {
    // : Pass(PT_Function, pid) 
    //START JInit
    super(PassKind.PT_Function, pid);
    //END JInit
  }

  
  /// createPrinterPass - Get a function printer pass.
  
  /// createPrinterPass - Get a function printer pass.
  
  //===----------------------------------------------------------------------===//
  // FunctionPass Implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 140,
   FQN="llvm::FunctionPass::createPrinterPass", NM="_ZNK4llvm12FunctionPass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm12FunctionPass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O, 
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    return createPrintFunctionPass(O, Banner);
  }


  
  /// runOnFunction - Virtual method overriden by subclasses to do the
  /// per-function processing of the pass.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 309,
   FQN="llvm::FunctionPass::runOnFunction", NM="_ZN4llvm12FunctionPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm12FunctionPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  public abstract /*virtual*/ boolean runOnFunction(final Function /*&*/ F)/* = 0*/;

  
  
  /// Find appropriate Function Pass Manager or Call Graph Pass Manager
  /// in the PM Stack and add self into that manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1834,
   FQN="llvm::FunctionPass::assignPassManager", NM="_ZN4llvm12FunctionPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm12FunctionPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  @Override public void assignPassManager(final PMStack /*&*/ PMS, 
                   PassManagerType PreferredType)/* override*/ {
    
    // Find Function Pass Manager
    while (!PMS.empty()) {
      if (PMS.top().getPassManagerType().getValue() > PassManagerType.PMT_FunctionPassManager.getValue()) {
        PMS.pop();
      } else {
        break;
      }
    }
    
    // Create new Function Pass Manager if needed.
    FPPassManager /*P*/ FPP;
    if (PMS.top().getPassManagerType() == PassManagerType.PMT_FunctionPassManager) {
      FPP = (FPPassManager /*P*/ )PMS.top();
    } else {
      assert (!PMS.empty()) : "Unable to create Function Pass Manager";
      PMDataManager /*P*/ PMD = PMS.top();
      
      // [1] Create new Function Pass Manager
      FPP = new FPPassManager();
      FPP.populateInheritedAnalysis(PMS);
      
      // [2] Set up new manager's top level manager
      PMTopLevelManager /*P*/ TPM = PMD.getTopLevelManager();
      TPM.addIndirectPassManager(FPP);
      
      // [3] Assign manager to manage this new manager. This may create
      // and push new managers into PMS
      FPP.assignPassManager(PMS, PMD.getPassManagerType());
      
      // [4] Push new manager into PMS
      PMS.push(FPP);
    }
    
    // Assign FPP as the manager of this pass.
    FPP.add(this);
  }

  
  ///  Return what kind of Pass Manager can manage this pass.
  
  ///  Return what kind of Pass Manager can manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 145,
   FQN="llvm::FunctionPass::getPotentialPassManagerType", NM="_ZNK4llvm12FunctionPass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm12FunctionPass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPotentialPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_FunctionPassManager;
  }


/*protected:*/
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when Attribute::OptimizeNone is set or when
  /// optimization bisect is over the limit.
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when Attribute::OptimizeNone is set or when
  /// optimization bisect is over the limit.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::skipFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 149,
   FQN="llvm::FunctionPass::skipFunction", NM="_ZNK4llvm12FunctionPass12skipFunctionERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm12FunctionPass12skipFunctionERKNS_8FunctionE")
  //</editor-fold>
  protected boolean skipFunction(final /*const*/ Function /*&*/ F) /*const*/ {
    if (!F.getContext().getOptBisect().shouldRunPass(this, F)) {
      return true;
    }
    if (F.hasFnAttribute(Attribute.AttrKind.OptimizeNone)) {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"ir")) {
          dbgs().$out(/*KEEP_STR*/"Skipping pass '").$out(getPassName()).$out(/*KEEP_STR*/"' on function ").$out(F.getName()).$out(/*KEEP_STR*/$LF);
        }
      } while (false);
      return true;
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionPass::~FunctionPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 298,
   FQN="llvm::FunctionPass::~FunctionPass", NM="_ZN4llvm12FunctionPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm12FunctionPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
