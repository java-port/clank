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
import org.llvm.adt.*;
import org.llvm.ir.*;


//===----------------------------------------------------------------------===//
/// Pass interface - Implemented by all 'passes'.  Subclass this if you are an
/// interprocedural optimization or you do not fit into any of the more
/// constrained passes described below.
///
//<editor-fold defaultstate="collapsed" desc="llvm::Pass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 81,
 FQN="llvm::Pass", NM="_ZN4llvm4PassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4PassE")
//</editor-fold>
public abstract class Pass implements Destructors.ClassWithDestructor {
  private AnalysisResolver /*P*/ Resolver; // Used to resolve analysis
  private final /*const*/Class<? extends Pass>/*void P*/ PassID;
  private PassKind Kind;
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 85,
   FQN="llvm::Pass::operator=", NM="_ZN4llvm4PassaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4PassaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ Pass /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::Pass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 86,
   FQN="llvm::Pass::Pass", NM="_ZN4llvm4PassC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4PassC1ERKS0_")
  //</editor-fold>
  protected/*private*/ Pass(final /*const*/ Pass /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::Pass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 89,
   FQN="llvm::Pass::Pass", NM="_ZN4llvm4PassC1ENS_8PassKindERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4PassC1ENS_8PassKindERc")
  //</editor-fold>
  public /*explicit*/ Pass(PassKind K, final Class<? extends Pass>/*char &*/ pid) {
    // : Resolver(null), PassID(&pid), Kind(K) 
    //START JInit
    this.Resolver = null;
    this.PassID = pid;
    this.Kind = K;
    //END JInit
  }

  
  //===----------------------------------------------------------------------===//
  // Pass Implementation
  //
  
  // Force out-of-line virtual method.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::~Pass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 34,
   FQN="llvm::Pass::~Pass", NM="_ZN4llvm4PassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4PassD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Resolver);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getPassKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 94,
   FQN="llvm::Pass::getPassKind", NM="_ZNK4llvm4Pass11getPassKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass11getPassKindEv")
  //</editor-fold>
  public PassKind getPassKind() /*const*/ {
    return Kind;
  }

  
  /// getPassName - Return a nice clean name for a pass.  This usually
  /// implemented in terms of the name that is registered by one of the
  /// Registration templates, but can be overloaded directly.
  ///
  
  /// getPassName - Return a nice clean name for a pass.  This usually
  /// implemented in terms of the name that is registered by one of the
  /// Registration templates, but can be overloaded directly.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getPassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 67,
   FQN="llvm::Pass::getPassName", NM="_ZNK4llvm4Pass11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass11getPassNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPassName() /*const*/ {
    /*const*/Object/*void P*/ AID = getPassID();
    /*const*/ PassInfo /*P*/ PI = PassRegistry.getPassRegistry().getPassInfo(AID);
    if ((PI != null)) {
      return PI.getPassName();
    }
    return $("Unnamed pass: implement Pass::getPassName()");
  }

  
  /// getPassID - Return the PassID number that corresponds to this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getPassID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 103,
   FQN="llvm::Pass::getPassID", NM="_ZNK4llvm4Pass9getPassIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass9getPassIDEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getPassID() /*const*/ {
    return PassID;
  }

  
  /// doInitialization - Virtual method overridden by subclasses to do
  /// any necessary initialization before any pass is run.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 110,
   FQN="llvm::Pass::doInitialization", NM="_ZN4llvm4Pass16doInitializationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass16doInitializationERNS_6ModuleE")
  //</editor-fold>
  public /*virtual*/ boolean doInitialization(final Module /*&*/ $Prm0) {
    return false;
  }

  
  /// doFinalization - Virtual method overriden by subclasses to do any
  /// necessary clean up after all passes have run.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 115,
   FQN="llvm::Pass::doFinalization", NM="_ZN4llvm4Pass14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  public /*virtual*/ boolean doFinalization(final Module /*&*/ $Prm0) {
    return false;
  }

  
  /// print - Print out the internal state of the pass.  This is called by
  /// Analyze to print out the contents of an analysis.  Otherwise it is not
  /// necessary to implement this method.  Beware that the module pointer MAY be
  /// null.  This automatically forwards to a virtual function that does not
  /// provide the Module* in case the analysis doesn't need it it can just be
  /// ignored.
  ///
  
  // print - Print out the internal state of the pass.  This is called by Analyze
  // to print out the contents of an analysis.  Otherwise it is not necessary to
  // implement this method.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 117,
   FQN="llvm::Pass::print", NM="_ZNK4llvm4Pass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ O, /*const*/ Module /*P*/ $Prm1) /*const*/ {
    O.$out(/*KEEP_STR*/"Pass::print not implemented for pass: '").$out(getPassName()).$out(/*KEEP_STR*/"'!\n");
  }

  
  // dump - call print(cerr);
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 122,
   FQN="llvm::Pass::dump", NM="_ZNK4llvm4Pass4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), (/*const*/ Module /*P*/ )null);
  }
 // dump - Print to stderr.
  
  /// createPrinterPass - Get a Pass appropriate to print the IR this
  /// pass operates on (Module, Function or MachineFunction).
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 129,
   FQN="llvm::Pass::createPrinterPass", NM="_ZNK4llvm4Pass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  public abstract /*virtual*/ Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O, 
                   final /*const*/std.string/*&*/ Banner) /*const*//* = 0*/;

  
  /// Each pass is responsible for assigning a pass manager to itself.
  /// PMS is the stack of available pass manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 134,
   FQN="llvm::Pass::assignPassManager", NM="_ZN4llvm4Pass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  public /*virtual*/ void assignPassManager(final PMStack /*&*/ $Prm0, 
                   PassManagerType $Prm1) {
  }

  /// Check if available pass managers are suitable for this pass or not.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::preparePassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 75,
   FQN="llvm::Pass::preparePassManager", NM="_ZN4llvm4Pass18preparePassManagerERNS_7PMStackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass18preparePassManagerERNS_7PMStackE")
  //</editor-fold>
  public void preparePassManager(final PMStack /*&*/ $Prm0) {
    // By default, don't do anything.
  }

  
  ///  Return what kind of Pass Manager can manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 79,
   FQN="llvm::Pass::getPotentialPassManagerType", NM="_ZNK4llvm4Pass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  public PassManagerType getPotentialPassManagerType() /*const*/ {
    // Default implementation.
    return PassManagerType.PMT_Unknown;
  }

  
  // Access AnalysisResolver
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::setResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 108,
   FQN="llvm::Pass::setResolver", NM="_ZN4llvm4Pass11setResolverEPNS_16AnalysisResolverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass11setResolverEPNS_16AnalysisResolverE")
  //</editor-fold>
  public void setResolver(AnalysisResolver /*P*/ AR) {
    assert (!(Resolver != null)) : "Resolver is already set";
    Resolver = AR;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Pass.h", line = 144,
   FQN="llvm::Pass::getResolver", NM="_ZNK4llvm4Pass11getResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass11getResolverEv")
  //</editor-fold>
  public AnalysisResolver /*P*/ getResolver() /*const*/ {
    return Resolver;
  }

  
  /// getAnalysisUsage - This function should be overriden by passes that need
  /// analysis information to do their job.  If a pass specifies that it uses a
  /// particular analysis result to this function, it can then use the
  /// getAnalysis<AnalysisType>() function, below.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 84,
   FQN="llvm::Pass::getAnalysisUsage", NM="_ZNK4llvm4Pass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  public void getAnalysisUsage(final AnalysisUsage /*&*/ $Prm0) /*const*/ {
    // By default, no analysis results are used, all are invalidated.
  }

  
  /// releaseMemory() - This member can be implemented by a pass if it wants to
  /// be able to release its memory when it is no longer needed.  The default
  /// behavior of passes is to hold onto memory for the entire duration of their
  /// lifetime (which is the entire compile time).  For pipelined passes, this
  /// is not a big deal because that memory gets recycled every time the pass is
  /// invoked on another program unit.  For IP passes, it is more important to
  /// free memory when it is unused.
  ///
  /// Optionally implement this function to release pass memory when it is no
  /// longer used.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 88,
   FQN="llvm::Pass::releaseMemory", NM="_ZN4llvm4Pass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    // By default, don't do anything.
  }

  
  /// getAdjustedAnalysisPointer - This method is used when a pass implements
  /// an analysis interface through multiple inheritance.  If needed, it should
  /// override this to adjust the this pointer as needed for the specified pass
  /// info.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAdjustedAnalysisPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 96,
   FQN="llvm::Pass::getAdjustedAnalysisPointer", NM="_ZN4llvm4Pass26getAdjustedAnalysisPointerEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass26getAdjustedAnalysisPointerEPKv")
  //</editor-fold>
  public Object/*void P*/ getAdjustedAnalysisPointer(/*const*/Object/*void P*/ AID) {
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAsImmutablePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 100,
   FQN="llvm::Pass::getAsImmutablePass", NM="_ZN4llvm4Pass18getAsImmutablePassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass18getAsImmutablePassEv")
  //</editor-fold>
  public ImmutablePass /*P*/ getAsImmutablePass() {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 104,
   FQN="llvm::Pass::getAsPMDataManager", NM="_ZN4llvm4Pass18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass18getAsPMDataManagerEv")
  //</editor-fold>
  public PMDataManager /*P*/ getAsPMDataManager() {
    return null;
  }

  
  /// verifyAnalysis() - This member can be implemented by a analysis pass to
  /// check state of analysis information.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::verifyAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 92,
   FQN="llvm::Pass::verifyAnalysis", NM="_ZNK4llvm4Pass14verifyAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass14verifyAnalysisEv")
  //</editor-fold>
  public void verifyAnalysis() /*const*/ {
    // By default, don't do anything.
  }

  
  // dumpPassStructure - Implement the -debug-passes=PassStructure option
  
  // dumpPassStructure - Implement the -debug-pass=Structure option
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::dumpPassStructure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 59,
   FQN="llvm::Pass::dumpPassStructure", NM="_ZN4llvm4Pass17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass17dumpPassStructureEj")
  //</editor-fold>
  public void dumpPassStructure() {
    dumpPassStructure(0);
  }
  public void dumpPassStructure(/*uint*/int Offset/*= 0*/) {
    dbgs().indent(Offset * 2).$out(getPassName()).$out(/*KEEP_STR*/$LF);
  }

  
  // lookupPassInfo - Return the pass info object for the specified pass class,
  // or null if it is not known.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::lookupPassInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 200,
   FQN="llvm::Pass::lookupPassInfo", NM="_ZN4llvm4Pass14lookupPassInfoEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass14lookupPassInfoEPKv")
  //</editor-fold>
  public static /*const*/ PassInfo /*P*/ lookupPassInfo(/*const*/Object/*void P*/ TI) {
    return PassRegistry.getPassRegistry().getPassInfo(TI);
  }

  
  // lookupPassInfo - Return the pass info object for the pass with the given
  // argument string, or null if it is not known.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::lookupPassInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 204,
   FQN="llvm::Pass::lookupPassInfo", NM="_ZN4llvm4Pass14lookupPassInfoENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass14lookupPassInfoENS_9StringRefE")
  //</editor-fold>
  public static /*const*/ PassInfo /*P*/ lookupPassInfo(StringRef Arg) {
    return PassRegistry.getPassRegistry().getPassInfo(new StringRef(Arg));
  }

  
  // createPass - Create a object for the specified pass class,
  // or null if it is not known.
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::createPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 208,
   FQN="llvm::Pass::createPass", NM="_ZN4llvm4Pass10createPassEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm4Pass10createPassEPKv")
  //</editor-fold>
  public static Pass /*P*/ createPass(/*const*/Object/*void P*/ ID) {
    /*const*/ PassInfo /*P*/ PI = PassRegistry.getPassRegistry().getPassInfo(ID);
    if (!(PI != null)) {
      return null;
    }
    return PI.createPass();
  }

  
  /// getAnalysisIfAvailable<AnalysisType>() - Subclasses use this function to
  /// get analysis information that might be around, for example to update it.
  /// This is different than getAnalysis in that it can fail (if the analysis
  /// results haven't been computed), so should only be used if you can handle
  /// the case when the analysis is not available.  This method is often used by
  /// transformation APIs to update analysis results for a pass automatically as
  /// the transform is performed.
  ///
  /*template <typename AnalysisType> TEMPLATE*/
  
  /// getAnalysisIfAvailable<AnalysisType>() - Subclasses use this function to
  /// get analysis information that might be around, for example to update it.
  /// This is different than getAnalysis in that it can fail (if the analysis
  /// results haven't been computed), so should only be used if you can handle
  /// the case when the analysis is not available.  This method is often used by
  /// transformation APIs to update analysis results for a pass automatically as
  /// the transform is performed.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAnalysisIfAvailable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 201,
   FQN="llvm::Pass::getAnalysisIfAvailable", NM="Tpl__ZNK4llvm4Pass22getAnalysisIfAvailableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZNK4llvm4Pass22getAnalysisIfAvailableEv")
  //</editor-fold>
  public </*typename*/ AnalysisType> AnalysisType /*P*/ getAnalysisIfAvailable(Class<AnalysisType> cls) /*const*/ {
    assert ((Resolver != null)) : "Pass not resident in a PassManager object!";
    
    /*const*/Object/*void P*/ PI = cls;//$AddrOf(AnalysisType.ID);
    
    Pass /*P*/ ResultPass = Resolver.getAnalysisIfAvailable(PI, true);
    if (!(ResultPass != null)) {
      return null;
    }
    
    // Because the AnalysisType may not be a subclass of pass (for
    // AnalysisGroups), we use getAdjustedAnalysisPointer here to potentially
    // adjust the return pointer (because the class may multiply inherit, once
    // from pass, once from AnalysisType).
    return (AnalysisType /*P*/ )ResultPass.getAdjustedAnalysisPointer(PI);
  }
 // Defined in PassAnalysisSupport.h
  
  /// mustPreserveAnalysisID - This method serves the same function as
  /// getAnalysisIfAvailable, but works if you just have an AnalysisID.  This
  /// obviously cannot give you a properly typed instance of the class if you
  /// don't have the class name available (use getAnalysisIfAvailable if you
  /// do), but it can tell you if you need to preserve the pass at least.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::mustPreserveAnalysisID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Pass.cpp", line = 54,
   FQN="llvm::Pass::mustPreserveAnalysisID", NM="_ZNK4llvm4Pass22mustPreserveAnalysisIDERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZNK4llvm4Pass22mustPreserveAnalysisIDERc")
  //</editor-fold>
  public boolean mustPreserveAnalysisID(final char$ref/*char &*/ AID) /*const*/ {
    return Resolver.getAnalysisIfAvailable(AID.deref$ptr(), true) != null;
  }

  
  /// getAnalysis<AnalysisType>() - This function is used by subclasses to get
  /// to the analysis information that they claim to use by overriding the
  /// getAnalysisUsage function.
  ///
  /*template <typename AnalysisType> TEMPLATE*/
  
  /// getAnalysis<AnalysisType>() - This function is used by subclasses to get
  /// to the analysis information that they claim to use by overriding the
  /// getAnalysisUsage function.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 221,
   FQN="llvm::Pass::getAnalysis", NM="Tpl__ZNK4llvm4Pass11getAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZNK4llvm4Pass11getAnalysisEv")
  //</editor-fold>
  public </*typename*/ AnalysisType> AnalysisType /*&*/ getAnalysis(Class<AnalysisType> cls) /*const*/ {
    assert ((Resolver != null)) : "Pass has not been inserted into a PassManager object!";
    return getAnalysisID(cls);//$AddrOf(AnalysisType.ID));
  }
 // Defined in PassAnalysisSupport.h
  
  /*template <typename AnalysisType> TEMPLATE*/
  
  /// getAnalysis<AnalysisType>() - This function is used by subclasses to get
  /// to the analysis information that they claim to use by overriding the
  /// getAnalysisUsage function.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 250,
   FQN="llvm::Pass::getAnalysis", NM="Tpl__ZN4llvm4Pass11getAnalysisERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm4Pass11getAnalysisERNS_8FunctionE")
  //</editor-fold>
  public </*typename*/ AnalysisType> AnalysisType /*&*/ getAnalysis(Class<AnalysisType> cls, final Function /*&*/ F) {
    assert ((Resolver != null)) : "Pass has not been inserted into a PassManager object!";
    
    return getAnalysisID(cls);//$AddrOf(AnalysisType.ID), F);
  }
 // Defined in PassAnalysisSupport.h
  
  /*template <typename AnalysisType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAnalysisID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 227,
   FQN="llvm::Pass::getAnalysisID", NM="Tpl__ZNK4llvm4Pass13getAnalysisIDEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZNK4llvm4Pass13getAnalysisIDEPKv")
  //</editor-fold>
  public </*typename*/ AnalysisType> AnalysisType /*&*/ getAnalysisID(/*const*/Object/*void P*/ PI) /*const*/ {
    assert ((PI != null)) : "getAnalysis for unregistered pass!";
    assert ((Resolver != null)) : "Pass has not been inserted into a PassManager object!";
    // PI *must* appear in AnalysisImpls.  Because the number of passes used
    // should be a small number, we just do a linear search over a (dense)
    // vector.
    Pass /*P*/ ResultPass = Resolver.findImplPass(PI);
    assert ((ResultPass != null)) : "getAnalysis*() called on an analysis that was not 'required' by pass!";
    
    // Because the AnalysisType may not be a subclass of pass (for
    // AnalysisGroups), we use getAdjustedAnalysisPointer here to potentially
    // adjust the return pointer (because the class may multiply inherit, once
    // from pass, once from AnalysisType).
    return $Deref((AnalysisType /*P*/ )ResultPass.getAdjustedAnalysisPointer(PI));
  }

  
  /*template <typename AnalysisType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Pass::getAnalysisID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/PassAnalysisSupport.h", line = 257,
   FQN="llvm::Pass::getAnalysisID", NM="Tpl__ZN4llvm4Pass13getAnalysisIDEPKvRNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=Tpl__ZN4llvm4Pass13getAnalysisIDEPKvRNS_8FunctionE")
  //</editor-fold>
  public </*typename*/ AnalysisType> AnalysisType /*&*/ getAnalysisID(/*const*/Object/*void P*/ PI, final Function /*&*/ F) {
    assert ((PI != null)) : "getAnalysis for unregistered pass!";
    assert ((Resolver != null)) : "Pass has not been inserted into a PassManager object!";
    // PI *must* appear in AnalysisImpls.  Because the number of passes used
    // should be a small number, we just do a linear search over a (dense)
    // vector.
    Pass /*P*/ ResultPass = Resolver.findImplPass(this, PI, F);
    assert ((ResultPass != null)) : "Unable to find requested analysis info";
    
    // Because the AnalysisType may not be a subclass of pass (for
    // AnalysisGroups), we use getAdjustedAnalysisPointer here to potentially
    // adjust the return pointer (because the class may multiply inherit, once
    // from pass, once from AnalysisType).
    return $Deref((AnalysisType /*P*/ )ResultPass.getAdjustedAnalysisPointer(PI));
  }
  
  @Override public String toString() {
    return "" + "Resolver=" + Resolver // NOI18N
              + ", PassID=" + NativeTrace.getIdentityStr(PassID) // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
