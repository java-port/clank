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


/// Manage lifetime of a slot tracker for printing IR.
///
/// Wrapper around the \a SlotTracker used internally by \a AsmWriter.  This
/// class allows callers to share the cost of incorporating the metadata in a
/// module or a function.
///
/// If the IR changes from underneath \a ModuleSlotTracker, strings like
/// "<badref>" will be printed, or, worse, the wrong slots entirely.
//<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSlotTracker.h", line = 30,
 FQN="llvm::ModuleSlotTracker", NM="_ZN4llvm17ModuleSlotTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTrackerE")
//</editor-fold>
public class ModuleSlotTracker implements Destructors.ClassWithDestructor {
  /// Storage for a slot tracker.
  private std.unique_ptr<SlotTracker> MachineStorage;
  private boolean ShouldCreateStorage/* = false*/;
  private boolean ShouldInitializeAllMetadata/* = false*/;

  private /*const*/ Module /*P*/ M/* = null*/;
  private /*const*/ Function /*P*/ F/* = null*/;
  private SlotTracker /*P*/ Machine/* = null*/;
/*public:*/
  /// Wrap a preinitialized SlotTracker.
  // namespace llvm
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::ModuleSlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 698,
   FQN="llvm::ModuleSlotTracker::ModuleSlotTracker", NM="_ZN4llvm17ModuleSlotTrackerC1ERNS_11SlotTrackerEPKNS_6ModuleEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTrackerC1ERNS_11SlotTrackerEPKNS_6ModuleEPKNS_8FunctionE")
  //</editor-fold>
  public ModuleSlotTracker(final SlotTracker /*&*/ Machine, /*const*/ Module /*P*/ M) {
    this(Machine, M,
      (/*const*/ Function /*P*/ )null);
  }
  public ModuleSlotTracker(final SlotTracker /*&*/ Machine, /*const*/ Module /*P*/ M,
      /*const*/ Function /*P*/ F/*= null*/) {
    // : MachineStorage(), ShouldCreateStorage(false), ShouldInitializeAllMetadata(false), M(M), F(F), Machine(&Machine)
    //START JInit
    this.MachineStorage = new std.unique_ptr<SlotTracker>();
    /*InClass*/this.ShouldCreateStorage = false;
    /*InClass*/this.ShouldInitializeAllMetadata = false;
    this.M = M;
    this.F = F;
    this.Machine = $AddrOf(Machine);
    //END JInit
  }


  /// Construct a slot tracker from a module.
  ///
  /// If \a M is \c nullptr, uses a null slot tracker.  Otherwise, initializes
  /// a slot tracker, and initializes all metadata slots.  \c
  /// ShouldInitializeAllMetadata defaults to true because this is expected to
  /// be shared between multiple callers, and otherwise MDNode references will
  /// not match up.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::ModuleSlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 702,
   FQN="llvm::ModuleSlotTracker::ModuleSlotTracker", NM="_ZN4llvm17ModuleSlotTrackerC1EPKNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTrackerC1EPKNS_6ModuleEb")
  //</editor-fold>
  public ModuleSlotTracker(/*const*/ Module /*P*/ M) {
    this(M,
      true);
  }
  public ModuleSlotTracker(/*const*/ Module /*P*/ M,
      boolean ShouldInitializeAllMetadata/*= true*/) {
    // : MachineStorage(), ShouldCreateStorage(M), ShouldInitializeAllMetadata(ShouldInitializeAllMetadata), M(M), F(null), Machine(null)
    //START JInit
    this.MachineStorage = new std.unique_ptr<SlotTracker>();
    this.ShouldCreateStorage = (M != null);
    this.ShouldInitializeAllMetadata = ShouldInitializeAllMetadata;
    this.M = M;
    /*InClass*/this.F = null;
    /*InClass*/this.Machine = null;
    //END JInit
  }


  /// Destructor to clean up storage.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::~ModuleSlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 707,
   FQN="llvm::ModuleSlotTracker::~ModuleSlotTracker", NM="_ZN4llvm17ModuleSlotTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTrackerD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    MachineStorage.$destroy();
    //END JDestroy
  }


  /// Lazily creates a slot tracker.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::getMachine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 709,
   FQN="llvm::ModuleSlotTracker::getMachine", NM="_ZN4llvm17ModuleSlotTracker10getMachineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTracker10getMachineEv")
  //</editor-fold>
  public SlotTracker /*P*/ getMachine() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!ShouldCreateStorage) {
        return Machine;
      }

      ShouldCreateStorage = false;
      $c$.clean(MachineStorage.$assignMove(
          $c$.track(llvm.make_unique(new SlotTracker(M, ShouldInitializeAllMetadata)))
      ));
      Machine = MachineStorage.get();
      return Machine;
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSlotTracker.h", line = 61,
   FQN="llvm::ModuleSlotTracker::getModule", NM="_ZNK4llvm17ModuleSlotTracker9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm17ModuleSlotTracker9getModuleEv")
  //</editor-fold>
  public /*const*/ Module /*P*/ getModule() /*const*/ {
    return M;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::getCurrentFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSlotTracker.h", line = 62,
   FQN="llvm::ModuleSlotTracker::getCurrentFunction", NM="_ZNK4llvm17ModuleSlotTracker18getCurrentFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm17ModuleSlotTracker18getCurrentFunctionEv")
  //</editor-fold>
  public /*const*/ Function /*P*/ getCurrentFunction() /*const*/ {
    return F;
  }


  /// Incorporate the given function.
  ///
  /// Purge the currently incorporated function and incorporate \c F.  If \c F
  /// is currently incorporated, this is a no-op.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::incorporateFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 720,
   FQN="llvm::ModuleSlotTracker::incorporateFunction", NM="_ZN4llvm17ModuleSlotTracker19incorporateFunctionERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTracker19incorporateFunctionERKNS_8FunctionE")
  //</editor-fold>
  public void incorporateFunction(final /*const*/ Function /*&*/ F) {
    // Using getMachine() may lazily create the slot tracker.
    if (!(getMachine() != null)) {
      return;
    }

    // Nothing to do if this is the right function already.
    if (this.F == $AddrOf(F)) {
      return;
    }
    if ((this.F != null)) {
      Machine.purgeFunction();
    }
    Machine.incorporateFunction($AddrOf(F));
    this.F = $AddrOf(F);
  }


  /// Return the slot number of the specified local value.
  ///
  /// A function that defines this value should be incorporated prior to calling
  /// this method.
  /// Return -1 if the value is not in the function's SlotTracker.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleSlotTracker::getLocalSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 734,
   FQN="llvm::ModuleSlotTracker::getLocalSlot", NM="_ZN4llvm17ModuleSlotTracker12getLocalSlotEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm17ModuleSlotTracker12getLocalSlotEPKNS_5ValueE")
  //</editor-fold>
  public int getLocalSlot(/*const*/ Value /*P*/ V) {
    assert ((F != null)) : "No function incorporated";
    return Machine.getLocalSlot(V);
  }


  @Override public String toString() {
    return "" + "MachineStorage=" + MachineStorage // NOI18N
              + ", ShouldCreateStorage=" + ShouldCreateStorage // NOI18N
              + ", ShouldInitializeAllMetadata=" + ShouldInitializeAllMetadata // NOI18N
              + ", M=" + M // NOI18N
              + ", F=" + F // NOI18N
              + ", Machine=" + Machine; // NOI18N
  }
}
