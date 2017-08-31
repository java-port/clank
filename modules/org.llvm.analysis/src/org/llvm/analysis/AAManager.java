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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.target.TargetLibraryAnalysis;
import org.llvm.ir.java.IAnalysisResult;


/// A manager for alias analyses.
///
/// This class can have analyses registered with it and when run, it will run
/// all of them and aggregate their results into single AA results interface
/// that dispatches across all of the alias analysis results available.
///
/// Note that the order in which analyses are registered is very significant.
/// That is the order in which the results will be aggregated and queried.
///
/// This manager effectively wraps the AnalysisManager for registering alias
/// analyses. When you register your alias analysis with this manager, it will
/// ensure the analysis itself is registered with its AnalysisManager.
//<editor-fold defaultstate="collapsed" desc="llvm::AAManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 853,
 FQN="llvm::AAManager", NM="_ZN4llvm9AAManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManagerE")
//</editor-fold>
public class AAManager implements /*public*/ AnalysisInfoMixin<AAManager>, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef AAResults Result
//  public final class Result extends AAResults{ };
  
  // This type hase value semantics. We have to spell these out because MSVC
  // won't synthesize them.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::AAManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 859,
   FQN="llvm::AAManager::AAManager", NM="_ZN4llvm9AAManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManagerC1Ev")
  //</editor-fold>
  public AAManager() {
    // : AnalysisInfoMixin<AAManager>(), ResultGetters() 
    //START JInit
    $AnalysisInfoMixin();
    this.ResultGetters = new SmallVector<FunctionAnalysisManager$FunctionAAResults2Void>(4, (FunctionAnalysisManager$FunctionAAResults2Void)null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::AAManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 860,
   FQN="llvm::AAManager::AAManager", NM="_ZN4llvm9AAManagerC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManagerC1EOS0_")
  //</editor-fold>
  public AAManager(JD$Move _dparam, final AAManager /*&&*/Arg) {
    // : AnalysisInfoMixin<AAManager>(), ResultGetters(std::move(Arg.ResultGetters)) 
    //START JInit
    $AnalysisInfoMixin();
    this.ResultGetters = new SmallVector<FunctionAnalysisManager$FunctionAAResults2Void>(JD$Move.INSTANCE, std.move(Arg.ResultGetters));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::AAManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 861,
   FQN="llvm::AAManager::AAManager", NM="_ZN4llvm9AAManagerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManagerC1ERKS0_")
  //</editor-fold>
  public AAManager(final /*const*/ AAManager /*&*/ Arg) {
    // : AnalysisInfoMixin<AAManager>(), ResultGetters(Arg.ResultGetters) 
    //START JInit
    $AnalysisInfoMixin();
    this.ResultGetters = new SmallVector<FunctionAnalysisManager$FunctionAAResults2Void>(Arg.ResultGetters);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 862,
   FQN="llvm::AAManager::operator=", NM="_ZN4llvm9AAManageraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManageraSEOS0_")
  //</editor-fold>
  public AAManager /*&*/ $assignMove(final AAManager /*&&*/RHS) {
    ResultGetters.$assignMove(std.move(RHS.ResultGetters));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 866,
   FQN="llvm::AAManager::operator=", NM="_ZN4llvm9AAManageraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManageraSERKS0_")
  //</editor-fold>
  public AAManager /*&*/ $assign(final /*const*/ AAManager /*&*/ RHS) {
    ResultGetters.$assign(RHS.ResultGetters);
    return /*Deref*/this;
  }

  
  /// Register a specific AA result.
  /*template <typename AnalysisT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::registerFunctionAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 872,
   FQN="llvm::AAManager::registerFunctionAnalysis", NM="Tpl__ZN4llvm9AAManager24registerFunctionAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvm9AAManager24registerFunctionAnalysisEv")
  //</editor-fold>
  public </*typename*/ AnalysisT extends AnalysisInfoMixin<AnalysisT>> void registerFunctionAnalysis(Class<AnalysisT> cls) {
    ResultGetters.push_back((FunctionAnalysisManager$FunctionAAResults2Void) (Function F, AnalysisManager<Function> AM, AAResults $AAResults) -> {
      getFunctionAAResultImpl(cls, F, AM, $AAResults);
    });
    //ResultGetters.push_back(AAManager::getFunctionAAResultImpl);
  }

  
  /// Register a specific AA result.
  /*template <typename AnalysisT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::registerModuleAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 877,
   FQN="llvm::AAManager::registerModuleAnalysis", NM="Tpl__ZN4llvm9AAManager22registerModuleAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvm9AAManager22registerModuleAnalysisEv")
  //</editor-fold>
  public </*typename*/ AnalysisT extends AnalysisInfoMixin<AnalysisT>> void registerModuleAnalysis(Class<AnalysisT> cls) {
    ResultGetters.push_back((FunctionAnalysisManager$FunctionAAResults2Void) (Function F, AnalysisManager<Function> AM, AAResults $AAResults) -> {
      getModuleAAResultImpl(cls, F, AM, $AAResults);
    });
    //ResultGetters.push_back(AAManager::getModuleAAResultImpl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::run">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 881,
   FQN="llvm::AAManager::run", NM="_ZN4llvm9AAManager3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm9AAManager3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public AAResults run(final Function /*&*/ F, final AnalysisManager<Function> /*&*/ AM) {
    AAResults R = null;
    try {
      R/*J*/= new AAResults(AM.getResult(TargetLibraryAnalysis.class, F));
      for (FunctionAnalysisManager$FunctionAAResults2Void Getter : ResultGetters)  {
        Getter.$call(F, AM, R);
      }
      return new AAResults(JD$Move.INSTANCE, R);
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }

/*private:*/
  /*friend  AnalysisInfoMixin<AAManager>*/
  
  // Provide a definition for the static object used to identify passes.
  private static /*char*/byte PassID;
  
  private SmallVector<FunctionAnalysisManager$FunctionAAResults2Void> ResultGetters;
  
  /*template <typename AnalysisT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::getFunctionAAResultImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 897,
   FQN="llvm::AAManager::getFunctionAAResultImpl", NM="Tpl__ZN4llvm9AAManager23getFunctionAAResultImplERNS_8FunctionERNS_15AnalysisManagerIS1_EERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvm9AAManager23getFunctionAAResultImplERNS_8FunctionERNS_15AnalysisManagerIS1_EERNS_9AAResultsE")
  //</editor-fold>
  private static </*typename*/ AnalysisT extends AnalysisInfoMixin<AnalysisT>> void getFunctionAAResultImpl(Class<AnalysisT> cls, final Function /*&*/ F, 
                         final AnalysisManager<Function> /*&*/ AM, 
                         final AAResults /*&*/ $AAResults) {
    $AAResults.addAAResult(AM.getResult(cls, F));
  }

  
  /*template <typename AnalysisT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::getModuleAAResultImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 904,
   FQN="llvm::AAManager::getModuleAAResultImpl", NM="Tpl__ZN4llvm9AAManager21getModuleAAResultImplERNS_8FunctionERNS_15AnalysisManagerIS1_EERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvm9AAManager21getModuleAAResultImplERNS_8FunctionERNS_15AnalysisManagerIS1_EERNS_9AAResultsE")
  //</editor-fold>
  private static </*typename*/ AnalysisT extends AnalysisInfoMixin<AnalysisT>> void getModuleAAResultImpl(Class<AnalysisT> cls, final Function /*&*/ F, final AnalysisManager<Function> /*&*/ AM, 
                       final AAResults /*&*/ $AAResults) {
    IAnalysisResult result = AM.getResult((Class<OuterAnalysisManagerProxy<AnalysisManager<Module>, Function>>)(Class<?>)OuterAnalysisManagerProxy.class, F);
    final /*constconst*/AnalysisManager<Module> /*&*/ MAM = (AnalysisManager<Module> /*&*/) ((OuterAnalysisManagerProxy.Result)result).getManager();
    {
      IAnalysisResult R = MAM.getCachedResult(cls, $Deref(F.getParent()));
      if (R != null) {
        $AAResults.addAAResult((AAResultBase)$Deref(R));
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AAManager::~AAManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 853,
   FQN="llvm::AAManager::~AAManager", NM="_ZN4llvm9AAManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm9AAManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ResultGetters.$destroy();
    AnalysisInfoMixin.super.$destroy$PassInfoMixin();
    //END JDestroy
  }

  @Override public String toString() {
    return "" + "ResultGetters=" + ResultGetters // NOI18N
              + super.toString(); // NOI18N
  }
}
