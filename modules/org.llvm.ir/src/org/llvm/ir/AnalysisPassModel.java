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
import static org.llvm.ir.java.IRFunctionPointers.*;
import org.llvm.ir.java.*;


/// \brief Wrapper to model the analysis pass concept.
///
/// Can wrap any type which implements a suitable \c run method. The method
/// must accept an \c IRUnitT& and an \c AnalysisManager<IRUnitT>& as arguments
/// and produce an object which can be wrapped in a \c AnalysisResultModel.
/*template <typename IRUnitT, typename PassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 212,
 FQN="llvm::detail::AnalysisPassModel", NM="_ZN4llvm6detail17AnalysisPassModelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModelE")
//</editor-fold>
public class/*struct*/ AnalysisPassModel</*typename*/ IRUnitT, /*typename*/ PassT extends IPass<AnalysisResultConcept<IRUnitT>, IRUnitT>>  extends /**/ AnalysisPassConcept<IRUnitT> {
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel::AnalysisPassModel<IRUnitT, PassT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 214,
   FQN="llvm::detail::AnalysisPassModel::AnalysisPassModel<IRUnitT, PassT>", NM="_ZN4llvm6detail17AnalysisPassModelC1ET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModelC1ET0_")
  //</editor-fold>
  public /*explicit*/ AnalysisPassModel(PassT Pass) {
    // : Pass(std::move(Pass))
    //START JInit
    this.Pass = /*ParenListExpr*//*new PassT*/std.move(Pass); // JAVA: do we really need a copy ctor?
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel::AnalysisPassModel<IRUnitT, PassT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 217,
   FQN="llvm::detail::AnalysisPassModel::AnalysisPassModel<IRUnitT, PassT>", NM="_ZN4llvm6detail17AnalysisPassModelC1ERKNS0_17AnalysisPassModelIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModelC1ERKNS0_17AnalysisPassModelIT_T0_EE")
  //</editor-fold>
  public AnalysisPassModel(final /*const*/ AnalysisPassModel<IRUnitT, PassT> /*&*/ Arg, CopyConstructor<PassT> ctor) {
    // : Pass(Arg.Pass)
    //START JInit
    this.Pass = /*ParenListExpr*//*new PassT*/ctor.$call(Arg.Pass);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel::AnalysisPassModel<IRUnitT, PassT>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 218,
   FQN="llvm::detail::AnalysisPassModel::AnalysisPassModel<IRUnitT, PassT>", NM="_ZN4llvm6detail17AnalysisPassModelC1EONS0_17AnalysisPassModelIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModelC1EONS0_17AnalysisPassModelIT_T0_EE")
  //</editor-fold>
  public AnalysisPassModel(JD$Move _dparam, final AnalysisPassModel<IRUnitT, PassT> /*&&*/Arg, CopyConstructor<PassT> ctor) {
    // : Pass(std::move(Arg.Pass))
    //START JInit
    this.Pass = /*ParenListExpr*//*new PassT*/ctor.$call(std.move(Arg.Pass));
    //END JInit
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::detail::swap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 219,
   FQN="llvm::detail::swap", NM="_ZN4llvm6detail4swapERNS0_17AnalysisPassModelIT_T0_EES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail4swapERNS0_17AnalysisPassModelIT_T0_EES6_")
  //</editor-fold>
  public static </*typename*/ IRUnitT, /*typename*/ PassT extends IPass<AnalysisResultConcept<IRUnitT>, IRUnitT>> void swap(final AnalysisPassModel<IRUnitT, PassT> /*&*/ LHS, final AnalysisPassModel<IRUnitT, PassT> /*&*/ RHS) {
    //JAVA: using std::swap;
    std.swap((NativeSwappable)LHS.Pass, (NativeSwappable)RHS.Pass);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 223,
   FQN="llvm::detail::AnalysisPassModel::operator=", NM="_ZN4llvm6detail17AnalysisPassModelaSENS0_17AnalysisPassModelIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModelaSENS0_17AnalysisPassModelIT_T0_EE")
  //</editor-fold>
  public AnalysisPassModel<IRUnitT, PassT> /*&*/ $assign(AnalysisPassModel<IRUnitT, PassT> RHS) {
    swap(/*Deref*/this, RHS);
    return /*Deref*/this;
  }


  // FIXME: Replace PassT::Result with type traits when we use C++11.
  // JAVA: typedef AnalysisResultModel<IRUnitT, PassT, typename PassT::Result> ResultModelT
//  public final class ResultModelT extends AnalysisResultModel<IRUnitT, PassT,  PassT.Result>{ };

  /// \brief The model delegates to the \c PassT::run method.
  ///
  /// The return is wrapped in an \c AnalysisResultModel.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 235,
   FQN="llvm::detail::AnalysisPassModel::run", NM="_ZN4llvm6detail17AnalysisPassModel3runERT_RNS_15AnalysisManagerIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModel3runERT_RNS_15AnalysisManagerIS2_EE")
  //</editor-fold>
  @Override
  public std.unique_ptr<AnalysisResultConcept<IRUnitT> > run(final IRUnitT /*&*/ IR, final AnalysisManager<IRUnitT> /*&*/ AM)/* override*/ {
    return std.make_unique(Pass.run(IR, AM));
  }


  /// \brief The model delegates to a static \c PassT::name method.
  ///
  /// The returned string ref must point to constant immutable data!
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisPassModel::name">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 243,
   FQN="llvm::detail::AnalysisPassModel::name", NM="_ZN4llvm6detail17AnalysisPassModel4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail17AnalysisPassModel4nameEv")
  //</editor-fold>
  public StringRef name()/* override*/ {
    return new StringRef(Pass.getClass().getSimpleName());
  }

  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 245)
  public PassT Pass;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override void swap(NativeSwappable RHS) {
    AnalysisPassModel<IRUnitT, PassT> other = (AnalysisPassModel<IRUnitT, PassT>) RHS;
    PassT old = this.Pass;
    this.Pass = other.Pass;
    other.Pass = old;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Pass=" + Pass // NOI18N
              + super.toString(); // NOI18N
  }
}
