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


//===----------------------------------------------------------------------===//
// PMStack
//
/// PMStack - This class implements a stack data structure of PMDataManager
/// pointers.
///
/// Top level pass managers (see PassManager.cpp) maintain active Pass Managers
/// using PMStack. Each Pass implements assignPassManager() to connect itself
/// with appropriate manager. assignPassManager() walks PMStack to find
/// suitable manager.
//<editor-fold defaultstate="collapsed" desc="llvm::PMStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 144,
 FQN="llvm::PMStack", NM="_ZN4llvm7PMStackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm7PMStackE")
//</editor-fold>
public class PMStack implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef std::vector<PMDataManager *>::const_reverse_iterator iterator
//  public final class iterator extends std.reverse_iterator</*const*/ PMDataManager /*&*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 147,
   FQN="llvm::PMStack::begin", NM="_ZNK4llvm7PMStack5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm7PMStack5beginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ PMDataManager /*&*/ > begin() /*const*/ {
    return S.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 148,
   FQN="llvm::PMStack::end", NM="_ZNK4llvm7PMStack3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm7PMStack3endEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ PMDataManager /*&*/ > end() /*const*/ {
    return S.rend$Const();
  }



  //===----------------------------------------------------------------------===//
  // PMStack implementation
  //

  // Pop Pass Manager from the stack and clear its analysis info.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::pop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1773,
   FQN="llvm::PMStack::pop", NM="_ZN4llvm7PMStack3popEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm7PMStack3popEv")
  //</editor-fold>
  public void pop() {

    PMDataManager /*P*/ Top = this.top();
    Top.initializeAnalysisInfo();

    S.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::top">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 151,
   FQN="llvm::PMStack::top", NM="_ZNK4llvm7PMStack3topEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm7PMStack3topEv")
  //</editor-fold>
  public PMDataManager /*P*/ top() /*const*/ {
    return S.back$Const();
  }


  // Push PM on the stack and set its top level manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::push">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1782,
   FQN="llvm::PMStack::push", NM="_ZN4llvm7PMStack4pushEPNS_13PMDataManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm7PMStack4pushEPNS_13PMDataManagerE")
  //</editor-fold>
  public void push(PMDataManager /*P*/ PM) {
    assert ((PM != null)) : "Unable to push. Pass Manager expected";
    assert (PM.getDepth() == 0) : "Pass Manager depth set too early";
    if (!this.empty()) {
      assert (PM.getPassManagerType().getValue() > this.top().getPassManagerType().getValue()) : "pushing bad pass manager to PMStack";
      PMTopLevelManager /*P*/ TPM = this.top().getTopLevelManager();
      assert ((TPM != null)) : "Unable to find top level manager";
      TPM.addIndirectPassManager(PM);
      PM.setTopLevelManager(TPM);
      PM.setDepth(this.top().getDepth() + 1);
    } else {
      assert ((PM.getPassManagerType() == PassManagerType.PMT_ModulePassManager || PM.getPassManagerType() == PassManagerType.PMT_FunctionPassManager)) : "pushing bad pass manager to PMStack";
      PM.setDepth(1);
    }

    S.push_back_T$C$R(PM);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 153,
   FQN="llvm::PMStack::empty", NM="_ZNK4llvm7PMStack5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm7PMStack5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return S.empty();
  }



  // Dump content of the pass manager stack.
  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1806,
   FQN="llvm::PMStack::dump", NM="_ZNK4llvm7PMStack4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZNK4llvm7PMStack4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    for (PMDataManager /*P*/ Manager : S)  {
      dbgs().$out(Manager.getAsPass().getPassName()).$out_char($$SPACE);
    }
    if (!S.empty()) {
      dbgs().$out_char($$LF);
    }
  }

/*private:*/
  private std.vector<PMDataManager /*P*/ > S;
  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::~PMStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 144,
   FQN="llvm::PMStack::~PMStack", NM="_ZN4llvm7PMStackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm7PMStackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    S.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PMStack::PMStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManagers.h", line = 144,
   FQN="llvm::PMStack::PMStack", NM="_ZN4llvm7PMStackC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm7PMStackC1Ev")
  //</editor-fold>
  public /*inline*/ PMStack() {
    // : S()
    //START JInit
    this.S = new std.vector<PMDataManager /*P*/ >((PMDataManager /*P*/ )null);
    //END JInit
  }


  @Override public String toString() {
    return "" + "S=" + "[Vector$PMDataManager]"; // NOI18N
  }
}
