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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.ir.java.IPass;


/// \brief A template wrapper used to implement the polymorphic API.
///
/// Can be instantiated for any object which provides a \c run method accepting
/// an \c IRUnitT& and an \c AnalysisManager<IRUnit>&. It requires the pass to
/// be a copyable object. When the
/*template <typename IRUnitT, typename PassT, typename PreservedAnalysesT = PreservedAnalyses> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 54,
 FQN="llvm::detail::PassModel", NM="_ZN4llvm6detail9PassModelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModelE")
//</editor-fold>
public class/*struct*/ PassModel</*typename*/ IRUnitT, /*typename*/ PassT extends IPass<PreservedAnalysesT, IRUnitT>, /*typename*/ PreservedAnalysesT extends PreservedAnalyses/* = PreservedAnalyses*/>  extends /**/ PassConcept<IRUnitT> {
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel::PassModel<IRUnitT, PassT, PreservedAnalysesT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 57,
   FQN="llvm::detail::PassModel::PassModel<IRUnitT, PassT, PreservedAnalysesT>", NM="_ZN4llvm6detail9PassModelC1ET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModelC1ET0_")
  //</editor-fold>
  public /*explicit*/ PassModel(PassT Pass) {
    // : Pass(std::move(Pass)) 
    //START JInit
    this.Pass = (PassT)/*ParenListExpr new PassT*/Native.$Move((NativeMoveable)std.move(Pass));
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel::PassModel<IRUnitT, PassT, PreservedAnalysesT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 60,
   FQN="llvm::detail::PassModel::PassModel<IRUnitT, PassT, PreservedAnalysesT>", NM="_ZN4llvm6detail9PassModelC1ERKNS0_9PassModelIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModelC1ERKNS0_9PassModelIT_T0_T1_EE")
  //</editor-fold>
  public PassModel(final /*const*/ PassModel<IRUnitT, PassT, PreservedAnalysesT> /*&*/ Arg) {
    // : Pass(Arg.Pass) 
    //START JInit
    this.Pass = (PassT)Native.$Clone((NativeCloneable)Arg.Pass);///*ParenListExpr*/new PassT(Arg.Pass);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel::PassModel<IRUnitT, PassT, PreservedAnalysesT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 61,
   FQN="llvm::detail::PassModel::PassModel<IRUnitT, PassT, PreservedAnalysesT>", NM="_ZN4llvm6detail9PassModelC1EONS0_9PassModelIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModelC1EONS0_9PassModelIT_T0_T1_EE")
  //</editor-fold>
  public PassModel(JD$Move _dparam, final PassModel<IRUnitT, PassT, PreservedAnalysesT> /*&&*/Arg) {
    // : Pass(std::move(Arg.Pass)) 
    //START JInit
    this.Pass = (PassT)/*ParenListExpr new PassT*/Native.$Move((NativeMoveable)std.move(Pass));
    //END JInit
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::detail::swap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 62,
   FQN="llvm::detail::swap", NM="_ZN4llvm6detail4swapERNS0_9PassModelIT_T0_T1_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail4swapERNS0_9PassModelIT_T0_T1_EES7_")
  //</editor-fold>
  public static </*typename*/ IRUnitT, /*typename*/ PassT extends IPass<PreservedAnalysesT, IRUnitT>, /*typename*/ PreservedAnalysesT extends PreservedAnalyses/* = PreservedAnalyses*/> void swap(final PassModel<IRUnitT, PassT, PreservedAnalysesT> /*&*/ LHS, final PassModel<IRUnitT, PassT, PreservedAnalysesT> /*&*/ RHS) {
    //JAVA: using std::swap;
    std.swap((NativeSwappable)LHS.Pass, (NativeSwappable)RHS.Pass);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 66,
   FQN="llvm::detail::PassModel::operator=", NM="_ZN4llvm6detail9PassModelaSENS0_9PassModelIT_T0_T1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModelaSENS0_9PassModelIT_T0_T1_EE")
  //</editor-fold>
  public PassModel<IRUnitT, PassT, PreservedAnalysesT> /*&*/ $assign(PassModel<IRUnitT, PassT, PreservedAnalysesT> RHS) {
    swap(/*Deref*/this, RHS);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 71,
   FQN="llvm::detail::PassModel::run", NM="_ZN4llvm6detail9PassModel3runERT_RNS_15AnalysisManagerIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModel3runERT_RNS_15AnalysisManagerIS2_EE")
  //</editor-fold>
  public PreservedAnalysesT run(final IRUnitT /*&*/ IR, final AnalysisManager<IRUnitT> /*&*/ AM)/* override*/ {
    return Pass.run(IR, AM);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::PassModel::name">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 74,
   FQN="llvm::detail::PassModel::name", NM="_ZN4llvm6detail9PassModel4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail9PassModel4nameEv")
  //</editor-fold>
  public StringRef name()/* override*/ {
    return Pass.name();
  }

  public PassT Pass;
  
  @Override public String toString() {
    return "" + "Pass=" + Pass // NOI18N
              + super.toString(); // NOI18N
  }
}
