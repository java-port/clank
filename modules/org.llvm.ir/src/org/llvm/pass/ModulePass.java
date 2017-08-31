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
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.impl.IRPrintingPassesLlvmGlobals.createPrintModulePass;


//===----------------------------------------------------------------------===//
/// ModulePass class - This class is used to implement unstructured
/// interprocedural optimizations and analyses.  ModulePasses may do anything
/// they want to the program.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ModulePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 235,
 FQN="llvm::ModulePass", NM="_ZN4llvm10ModulePassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm10ModulePassE")
//</editor-fold>
public abstract class ModulePass extends /*public*/ Pass implements Destructors.ClassWithDestructor {
/*public:*/
  /// createPrinterPass - Get a module printer pass.
  /// createPrinterPass - Get a module printer pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 41,
   FQN="llvm::ModulePass::createPrinterPass", NM="_ZNK4llvm10ModulePass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm10ModulePass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O, 
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    return createPrintModulePass(O, Banner);
  }


  
  /// runOnModule - Virtual method overriden by subclasses to process the module
  /// being operated on.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::runOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 243,
   FQN="llvm::ModulePass::runOnModule", NM="_ZN4llvm10ModulePass11runOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm10ModulePass11runOnModuleERNS_6ModuleE")
  //</editor-fold>
  public abstract /*virtual*/ boolean runOnModule(final Module /*&*/ M)/* = 0*/;

  
  
  /// Find appropriate Module Pass Manager in the PM Stack and
  /// add self into that manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1816,
   FQN="llvm::ModulePass::assignPassManager", NM="_ZN4llvm10ModulePass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm10ModulePass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  @Override public void assignPassManager(final PMStack /*&*/ PMS, 
                   PassManagerType PreferredType)/* override*/ {
    // Find Module Pass Manager
    while (!PMS.empty()) {
      PassManagerType TopPMType = PMS.top().getPassManagerType();
      if (TopPMType == PreferredType) {
        break; // We found desired pass manager
      } else if (TopPMType.getValue() > PassManagerType.PMT_ModulePassManager.getValue()) {
        PMS.pop(); // Pop children pass managers
      } else {
        break;
      }
    }
    assert (!PMS.empty()) : "Unable to find appropriate Pass Manager";
    PMS.top().add(this);
  }

  
  ///  Return what kind of Pass Manager can manage this pass.
  
  ///  Return what kind of Pass Manager can manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 46,
   FQN="llvm::ModulePass::getPotentialPassManagerType", NM="_ZNK4llvm10ModulePass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm10ModulePass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPotentialPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_ModulePassManager;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::ModulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 250,
   FQN="llvm::ModulePass::ModulePass", NM="_ZN4llvm10ModulePassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm10ModulePassC1ERc")
  //</editor-fold>
  public /*explicit*/ ModulePass(final Class<? extends ModulePass>/*char &*/ pid) {
    // : Pass(PT_Module, pid) 
    //START JInit
    super(PassKind.PT_Module, pid);
    //END JInit
  }

  // Force out-of-line virtual method.
  // Force out-of-line virtual method.
  
  // Force out-of-line virtual method.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::~ModulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 39,
   FQN="llvm::ModulePass::~ModulePass", NM="_ZN4llvm10ModulePassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm10ModulePassD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }


/*protected:*/
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when optimization bisect is over the limit.
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when optimization bisect is over the limit.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModulePass::skipModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 50,
   FQN="llvm::ModulePass::skipModule", NM="_ZNK4llvm10ModulePass10skipModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm10ModulePass10skipModuleERNS_6ModuleE")
  //</editor-fold>
  protected boolean skipModule(final Module /*&*/ M) /*const*/ {
    return !M.getContext().getOptBisect().shouldRunPass(this, M);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
