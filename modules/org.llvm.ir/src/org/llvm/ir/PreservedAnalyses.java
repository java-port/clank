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


/// \brief An abstract set of preserved analyses following a transformation pass
/// run.
///
/// When a transformation pass is run, it can return a set of analyses whose
/// results were preserved by that transformation. The default set is "none",
/// and preserving analyses must be done explicitly.
///
/// There is also an explicit all state which can be used (for example) when
/// the IR is not mutated at all.
//<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 66,
 FQN="llvm::PreservedAnalyses", NM="_ZN4llvm17PreservedAnalysesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalysesE")
//</editor-fold>
public class PreservedAnalyses implements Destructors.ClassWithDestructor {
/*public:*/
  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::PreservedAnalyses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 70,
   FQN="llvm::PreservedAnalyses::PreservedAnalyses", NM="_ZN4llvm17PreservedAnalysesC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalysesC1Ev")
  //</editor-fold>
  public PreservedAnalyses() {
    // : PreservedPassIDs()
    //START JInit
    this.PreservedPassIDs = new SmallPtrSet/*<void*>*/(DenseMapInfo$LikePtr.$Info(), 2);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::PreservedAnalyses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 71,
   FQN="llvm::PreservedAnalyses::PreservedAnalyses", NM="_ZN4llvm17PreservedAnalysesC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalysesC1ERKS0_")
  //</editor-fold>
  public PreservedAnalyses(final /*const*/ PreservedAnalyses /*&*/ Arg) {
    // : PreservedPassIDs(Arg.PreservedPassIDs)
    //START JInit
    this.PreservedPassIDs = new SmallPtrSet/*<void*>*/(Arg.PreservedPassIDs);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::PreservedAnalyses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 73,
   FQN="llvm::PreservedAnalyses::PreservedAnalyses", NM="_ZN4llvm17PreservedAnalysesC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalysesC1EOS0_")
  //</editor-fold>
  public PreservedAnalyses(JD$Move _dparam, final PreservedAnalyses /*&&*/Arg) {
    // : PreservedPassIDs(std::move(Arg.PreservedPassIDs))
    //START JInit
    this.PreservedPassIDs = new SmallPtrSet/*<void*>*/(JD$Move.INSTANCE, std.move(Arg.PreservedPassIDs));
    //END JInit
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::swap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 75,
   FQN="llvm::swap", NM="_ZN4llvm4swapERNS_17PreservedAnalysesES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm4swapERNS_17PreservedAnalysesES1_")
  //</editor-fold>
  public static void swap(final PreservedAnalyses /*&*/ LHS, final PreservedAnalyses /*&*/ RHS) {
    //JAVA: using std::swap;
    std.swap(LHS.PreservedPassIDs, RHS.PreservedPassIDs);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 79,
   FQN="llvm::PreservedAnalyses::operator=", NM="_ZN4llvm17PreservedAnalysesaSES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalysesaSES0_")
  //</editor-fold>
  public PreservedAnalyses /*&*/ $assign(PreservedAnalyses RHS) {
    PreservedAnalyses.swap(/*Deref*/this, RHS);
    return /*Deref*/this;
  }


  /// \brief Convenience factory function for the empty preserved set.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::none">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 85,
   FQN="llvm::PreservedAnalyses::none", NM="_ZN4llvm17PreservedAnalyses4noneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalyses4noneEv")
  //</editor-fold>
  public static PreservedAnalyses none() {
    return new PreservedAnalyses();
  }


  /// \brief Construct a special preserved set that preserves all passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::all">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 88,
   FQN="llvm::PreservedAnalyses::all", NM="_ZN4llvm17PreservedAnalyses3allEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalyses3allEv")
  //</editor-fold>
  public static PreservedAnalyses all() {
    PreservedAnalyses PA = null;
    try {
      PA/*J*/= new PreservedAnalyses();
      PA.PreservedPassIDs.insert((Object/*void P*/ )AllPassesID);
      return new PreservedAnalyses(JD$Move.INSTANCE, PA);
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }


  /// \brief Mark a particular pass as preserved, adding it to the set.
  /*template <typename PassT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::preserve">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 95,
   FQN="llvm::PreservedAnalyses::preserve", NM="Tpl__ZN4llvm17PreservedAnalyses8preserveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZN4llvm17PreservedAnalyses8preserveEv")
  //</editor-fold>
  public </*typename*/ PassT> void preserve(Class<PassT> ID) {
    preserve(ID);
  }


  /// \brief Mark an abstract PassID as preserved, adding it to the set.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::preserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 98,
   FQN="llvm::PreservedAnalyses::preserve", NM="_ZN4llvm17PreservedAnalyses8preserveEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalyses8preserveEPv")
  //</editor-fold>
  public void preserve(Object/*void P*/ PassID) {
    if (!areAllPreserved()) {
      PreservedPassIDs.insert(PassID);
    }
  }


  /// \brief Intersect this set with another in place.
  ///
  /// This is a mutating operation on this preserved set, removing all
  /// preserved passes which are not also preserved in the argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::intersect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 107,
   FQN="llvm::PreservedAnalyses::intersect", NM="_ZN4llvm17PreservedAnalyses9intersectERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalyses9intersectERKS0_")
  //</editor-fold>
  public void intersect_PreservedAnalyses$C(final /*const*/ PreservedAnalyses /*&*/ Arg) {
    if (Arg.areAllPreserved()) {
      return;
    }
    if (areAllPreserved()) {
      PreservedPassIDs.$assign(Arg.PreservedPassIDs);
      return;
    }
    for (Object/*void P*/ P : PreservedPassIDs)  {
      if (!(Arg.PreservedPassIDs.count(P) != 0)) {
        PreservedPassIDs.erase(P);
      }
    }
  }


  /// \brief Intersect this set with a temporary other set in place.
  ///
  /// This is a mutating operation on this preserved set, removing all
  /// preserved passes which are not also preserved in the argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::intersect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 123,
   FQN="llvm::PreservedAnalyses::intersect", NM="_ZN4llvm17PreservedAnalyses9intersectEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalyses9intersectEOS0_")
  //</editor-fold>
  public void intersect_PreservedAnalyses(final PreservedAnalyses /*&&*/Arg) {
    if (Arg.areAllPreserved()) {
      return;
    }
    if (areAllPreserved()) {
      PreservedPassIDs.$assignMove(std.move(Arg.PreservedPassIDs));
      return;
    }
    for (Object/*void P*/ P : PreservedPassIDs)  {
      if (!(Arg.PreservedPassIDs.count(P) != 0)) {
        PreservedPassIDs.erase(P);
      }
    }
  }


  /// \brief Query whether a pass is marked as preserved by this set.
  /*template <typename PassT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::preserved">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 136,
   FQN="llvm::PreservedAnalyses::preserved", NM="Tpl__ZNK4llvm17PreservedAnalyses9preservedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZNK4llvm17PreservedAnalyses9preservedEv")
  //</editor-fold>
  public </*typename*/ PassT> boolean preserved(Class<PassT> ID) /*const*/ {
    return preserved(ID);
  }


  /// \brief Query whether an abstract pass ID is marked as preserved by this
  /// set.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::preserved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 142,
   FQN="llvm::PreservedAnalyses::preserved", NM="_ZNK4llvm17PreservedAnalyses9preservedEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm17PreservedAnalyses9preservedEPv")
  //</editor-fold>
  public boolean preserved(Object/*void P*/ PassID) /*const*/ {
    return (PreservedPassIDs.count((Object/*void P*/ )AllPassesID) != 0)
       || (PreservedPassIDs.count(PassID) != 0);
  }


  /// \brief Query whether all of the analyses in the set are preserved.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::preserved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 148,
   FQN="llvm::PreservedAnalyses::preserved", NM="_ZN4llvm17PreservedAnalyses9preservedES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalyses9preservedES0_")
  //</editor-fold>
  public boolean preserved(PreservedAnalyses Arg) {
    if (Arg.areAllPreserved()) {
      return areAllPreserved();
    }
    for (Object/*void P*/ P : Arg.PreservedPassIDs)  {
      if (!preserved(P)) {
        return false;
      }
    }
    return true;
  }


  /// \brief Test whether all passes are preserved.
  ///
  /// This is used primarily to optimize for the case of no changes which will
  /// common in many scenarios.
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::areAllPreserved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 161,
   FQN="llvm::PreservedAnalyses::areAllPreserved", NM="_ZNK4llvm17PreservedAnalyses15areAllPreservedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm17PreservedAnalyses15areAllPreservedEv")
  //</editor-fold>
  public boolean areAllPreserved() /*const*/ {
    return (PreservedPassIDs.count((Object/*void P*/ )AllPassesID) != 0);
  }

/*private:*/
  // Note that this must not be -1 or -2 as those are already used by the
  // SmallPtrSet.
  private static /*const*/Object/*uintptr_t*/ AllPassesID = (Object/*intptr_t*/)(-3);

  private SmallPtrSet/*<void*>*/ PreservedPassIDs;
  //<editor-fold defaultstate="collapsed" desc="llvm::PreservedAnalyses::~PreservedAnalyses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 66,
   FQN="llvm::PreservedAnalyses::~PreservedAnalyses", NM="_ZN4llvm17PreservedAnalysesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm17PreservedAnalysesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PreservedPassIDs.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "PreservedPassIDs=" + PreservedPassIDs; // NOI18N
  }
}
