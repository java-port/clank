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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;


//===----------------------------------------------------------------------===//
/// Represent the analysis usage information of a pass.  This tracks analyses
/// that the pass REQUIRES (must be available when the pass runs), REQUIRES
/// TRANSITIVE (must be available throughout the lifetime of the pass), and
/// analyses that the pass PRESERVES (the pass does not invalidate the results
/// of these analyses).  This information is provided by a pass to the Pass
/// infrastructure through the getAnalysisUsage virtual function.
///
//<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 37,
 FQN="llvm::AnalysisUsage", NM="_ZN4llvm13AnalysisUsageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsageE")
//</editor-fold>
public class AnalysisUsage implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef SmallVectorImpl<AnalysisID> VectorType
//  public final class VectorType extends SmallVectorImpl</*const*/Object/*void P*/ >{ };
/*private:*/
  /// Sets of analyses required and preserved by a pass
  // TODO: It's not clear that SmallVector is an appropriate data structure for
  // this usecase.  The sizes were picked to minimize wasted space, but are
  // otherwise fairly meaningless.
  private SmallVector</*const*/Object/*void P*/> Required;
  private SmallVector</*const*/Object/*void P*/> RequiredTransitive;
  private SmallVector</*const*/Object/*void P*/> Preserved;
  private SmallVector</*const*/Object/*void P*/> Used;
  private boolean PreservesAll;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::AnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 53,
   FQN="llvm::AnalysisUsage::AnalysisUsage", NM="_ZN4llvm13AnalysisUsageC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsageC1Ev")
  //</editor-fold>
  public AnalysisUsage() {
    // : Required(), RequiredTransitive(), Preserved(), Used(), PreservesAll(false) 
    //START JInit
    this.Required = new SmallVector</*const*/Object/*void P*/>(8, (/*const*/Object/*void P*/)null);
    this.RequiredTransitive = new SmallVector</*const*/Object/*void P*/>(2, (/*const*/Object/*void P*/)null);
    this.Preserved = new SmallVector</*const*/Object/*void P*/>(2, (/*const*/Object/*void P*/)null);
    this.Used = new SmallVector</*const*/Object/*void P*/>(0, (/*const*/Object/*void P*/)null);
    this.PreservesAll = false;
    //END JInit
  }

  
  ///@{
  /// Add the specified ID to the required set of the usage info for a pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addRequiredID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 289,
   FQN="llvm::AnalysisUsage::addRequiredID", NM="_ZN4llvm13AnalysisUsage13addRequiredIDEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage13addRequiredIDEPKv")
  //</editor-fold>
  public AnalysisUsage /*&*/ addRequiredID(/*const*/Object/*void P*/ ID) {
    assert Pass.class.isAssignableFrom((Class)ID) : "Expected child of Pass: " + ID;
    Required.push_back(ID);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addRequiredID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 294,
   FQN="llvm::AnalysisUsage::addRequiredID", NM="_ZN4llvm13AnalysisUsage13addRequiredIDERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage13addRequiredIDERc")
  //</editor-fold>
  public AnalysisUsage /*&*/ addRequiredID(final char$ref/*char &*/ ID) {
    assert false : "Not expected call";
    Required.push_back(ID.deref$ptr());
    return /*Deref*/this;
  }

  /*template <class PassClass> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addRequired">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 60,
   FQN="llvm::AnalysisUsage::addRequired", NM="Tpl__ZN4llvm13AnalysisUsage11addRequiredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm13AnalysisUsage11addRequiredEv")
  //</editor-fold>
  public </*class*/ PassClass extends Pass> AnalysisUsage /*&*/ addRequired(Class<PassClass> cls) {
    return addRequiredID(cls);//PassClass.ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addRequiredTransitiveID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 299,
   FQN="llvm::AnalysisUsage::addRequiredTransitiveID", NM="_ZN4llvm13AnalysisUsage23addRequiredTransitiveIDERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage23addRequiredTransitiveIDERc")
  //</editor-fold>
  public </*class*/ PassClass extends Pass> AnalysisUsage /*&*/ addRequiredTransitiveID(Class<PassClass> cls) {//final char$ref/*char &*/ ID) {
    Required.push_back(cls);//ID.deref$ptr());
    RequiredTransitive.push_back(cls);//ID.deref$ptr());
    return /*Deref*/this;
  }

  /*template <class PassClass> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addRequiredTransitive">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 66,
   FQN="llvm::AnalysisUsage::addRequiredTransitive", NM="Tpl__ZN4llvm13AnalysisUsage21addRequiredTransitiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm13AnalysisUsage21addRequiredTransitiveEv")
  //</editor-fold>
  public </*class*/ PassClass extends Pass> AnalysisUsage /*&*/ addRequiredTransitive(Class<PassClass> cls) {
    return addRequiredTransitiveID(cls);//PassClass.ID);
  }

  ///@}
  
  ///@{
  /// Add the specified ID to the set of analyses preserved by this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addPreservedID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 73,
   FQN="llvm::AnalysisUsage::addPreservedID", NM="_ZN4llvm13AnalysisUsage14addPreservedIDEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage14addPreservedIDEPKv")
  //</editor-fold>
  public AnalysisUsage /*&*/ addPreservedID(/*const*/Object/*void P*/ ID) {
    assert Pass.class.isAssignableFrom((Class)ID) : "Expected child of Pass: " + ID;
    Preserved.push_back(ID);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addPreservedID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 77,
   FQN="llvm::AnalysisUsage::addPreservedID", NM="_ZN4llvm13AnalysisUsage14addPreservedIDERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage14addPreservedIDERc")
  //</editor-fold>
  public AnalysisUsage /*&*/ addPreservedID(final char$ref/*char &*/ ID) {
    assert false : "Not expected call";
    Preserved.push_back(ID.deref$ptr());
    return /*Deref*/this;
  }

  /// Add the specified Pass class to the set of analyses preserved by this pass.
  /*template <class PassClass> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addPreserved">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 83,
   FQN="llvm::AnalysisUsage::addPreserved", NM="Tpl__ZN4llvm13AnalysisUsage12addPreservedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm13AnalysisUsage12addPreservedEv")
  //</editor-fold>
  public </*class*/ PassClass extends Pass> AnalysisUsage /*&*/ addPreserved(Class<PassClass> cls) {
    Preserved.push_back(cls);//$AddrOf(PassClass.ID));
    return /*Deref*/this;
  }

  ///@}
  
  ///@{
  /// Add the specified ID to the set of analyses used by this pass if they are
  /// available..
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addUsedIfAvailableID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 92,
   FQN="llvm::AnalysisUsage::addUsedIfAvailableID", NM="_ZN4llvm13AnalysisUsage20addUsedIfAvailableIDEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage20addUsedIfAvailableIDEPKv")
  //</editor-fold>
  public AnalysisUsage /*&*/ addUsedIfAvailableID(/*const*/Object/*void P*/ ID) {
    assert Pass.class.isAssignableFrom((Class)ID) : "Expected child of Pass: " + ID;
    Used.push_back(ID);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addUsedIfAvailableID">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 96,
   FQN="llvm::AnalysisUsage::addUsedIfAvailableID", NM="_ZN4llvm13AnalysisUsage20addUsedIfAvailableIDERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage20addUsedIfAvailableIDERc")
  //</editor-fold>
  public AnalysisUsage /*&*/ addUsedIfAvailableID(final char$ref/*char &*/ ID) {
    assert false : "Not expected call";
    Used.push_back(ID.deref$ptr());
    return /*Deref*/this;
  }

  /// Add the specified Pass class to the set of analyses used by this pass.
  /*template <class PassClass> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addUsedIfAvailable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 102,
   FQN="llvm::AnalysisUsage::addUsedIfAvailable", NM="Tpl__ZN4llvm13AnalysisUsage18addUsedIfAvailableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm13AnalysisUsage18addUsedIfAvailableEv")
  //</editor-fold>
  public </*class*/ PassClass> AnalysisUsage /*&*/ addUsedIfAvailable(Class<PassClass> cls) {
    Used.push_back(cls);//$AddrOf(PassClass.ID));
    return /*Deref*/this;
  }

  ///@}
  
  /// Add the Pass with the specified argument string to the set of analyses
  /// preserved by this pass. If no such Pass exists, do nothing. This can be
  /// useful when a pass is trivially preserved, but may not be linked in. Be
  /// careful about spelling!
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::addPreserved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 282,
   FQN="llvm::AnalysisUsage::addPreserved", NM="_ZN4llvm13AnalysisUsage12addPreservedENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage12addPreservedENS_9StringRefE")
  //</editor-fold>
  public AnalysisUsage /*&*/ addPreserved(StringRef Arg) {
    /*const*/ PassInfo /*P*/ PI = Pass.lookupPassInfo(new StringRef(Arg));
    // If the pass exists, preserve it. Otherwise silently do nothing.
    if ((PI != null)) {
      Preserved.push_back(PI.getTypeInfo());
    }
    return /*Deref*/this;
  }

  
  /// Set by analyses that do not transform their input at all
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::setPreservesAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 115,
   FQN="llvm::AnalysisUsage::setPreservesAll", NM="_ZN4llvm13AnalysisUsage15setPreservesAllEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage15setPreservesAllEv")
  //</editor-fold>
  public void setPreservesAll() {
    PreservesAll = true;
  }

  
  /// Determine whether a pass said it does not transform its input at all
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::getPreservesAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 118,
   FQN="llvm::AnalysisUsage::getPreservesAll", NM="_ZNK4llvm13AnalysisUsage15getPreservesAllEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm13AnalysisUsage15getPreservesAllEv")
  //</editor-fold>
  public boolean getPreservesAll() /*const*/ {
    return PreservesAll;
  }

  
  /// This function should be called by the pass, iff they do not:
  ///
  ///  1. Add or remove basic blocks from the function
  ///  2. Modify terminator instructions in any way.
  ///
  /// This function annotates the AnalysisUsage info object to say that analyses
  /// that only depend on the CFG are preserved by this pass.
  ///
  
  // setPreservesCFG - This function should be called to by the pass, iff they do
  // not:
  //
  //  1. Add or remove basic blocks from the function
  //  2. Modify terminator instructions in any way.
  //
  // This function annotates the AnalysisUsage info object to say that analyses
  // that only depend on the CFG are preserved by this pass.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::setPreservesCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 276,
   FQN="llvm::AnalysisUsage::setPreservesCFG", NM="_ZN4llvm13AnalysisUsage15setPreservesCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm13AnalysisUsage15setPreservesCFGEv")
  //</editor-fold>
  public void setPreservesCFG() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Since this transformation doesn't modify the CFG, it preserves all analyses
      // that only depend on the CFG (like dominators, loop info, etc...)
      $c$.track(new GetCFGOnlyPasses(Preserved)).enumeratePasses(); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::getRequiredSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 130,
   FQN="llvm::AnalysisUsage::getRequiredSet", NM="_ZNK4llvm13AnalysisUsage14getRequiredSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm13AnalysisUsage14getRequiredSetEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ getRequiredSet() /*const*/ {
    return Required;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::getRequiredTransitiveSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 131,
   FQN="llvm::AnalysisUsage::getRequiredTransitiveSet", NM="_ZNK4llvm13AnalysisUsage24getRequiredTransitiveSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm13AnalysisUsage24getRequiredTransitiveSetEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ getRequiredTransitiveSet() /*const*/ {
    return RequiredTransitive;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::getPreservedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 134,
   FQN="llvm::AnalysisUsage::getPreservedSet", NM="_ZNK4llvm13AnalysisUsage15getPreservedSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm13AnalysisUsage15getPreservedSetEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ getPreservedSet() /*const*/ {
    return Preserved;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::getUsedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 135,
   FQN="llvm::AnalysisUsage::getUsedSet", NM="_ZNK4llvm13AnalysisUsage10getUsedSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm13AnalysisUsage10getUsedSetEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ getUsedSet() /*const*/ {
    return Used;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::AnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 37,
   FQN="llvm::AnalysisUsage::AnalysisUsage", NM="_ZN4llvm13AnalysisUsageC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm13AnalysisUsageC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AnalysisUsage(final /*const*/ AnalysisUsage /*&*/ $Prm0) {
    // : Required(.Required), RequiredTransitive(.RequiredTransitive), Preserved(.Preserved), Used(.Used), PreservesAll(.PreservesAll) 
    //START JInit
    this.Required = new SmallVector</*const*/Object/*void P*/>($Prm0.Required);
    this.RequiredTransitive = new SmallVector</*const*/Object/*void P*/>($Prm0.RequiredTransitive);
    this.Preserved = new SmallVector</*const*/Object/*void P*/>($Prm0.Preserved);
    this.Used = new SmallVector</*const*/Object/*void P*/>($Prm0.Used);
    this.PreservesAll = $Prm0.PreservesAll;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisUsage::~AnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 37,
   FQN="llvm::AnalysisUsage::~AnalysisUsage", NM="_ZN4llvm13AnalysisUsageD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm13AnalysisUsageD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Used.$destroy();
    Preserved.$destroy();
    RequiredTransitive.$destroy();
    Required.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Required=" + Required // NOI18N
              + ", RequiredTransitive=" + RequiredTransitive // NOI18N
              + ", Preserved=" + Preserved // NOI18N
              + ", Used=" + Used // NOI18N
              + ", PreservesAll=" + PreservesAll; // NOI18N
  }
}
