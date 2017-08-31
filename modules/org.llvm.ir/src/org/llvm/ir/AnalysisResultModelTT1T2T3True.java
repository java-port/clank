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
import org.llvm.ir.*;
import static org.llvm.ir.java.IRFunctionPointers.*;


/// \brief Specialization of \c AnalysisResultModel which delegates invalidate
/// handling to \c ResultT.
/*template <typename IRUnitT, typename PassT, typename ResultT, typename PreservedAnalysesT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 163,
 FQN="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>", NM="_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEE")
//</editor-fold>
public class/*struct*/ AnalysisResultModelTT1T2T3True</*typename*/ IRUnitT, /*typename*/ PassT extends AnalysisInfoMixin<PassT>, /*typename*/ ResultT extends AnalysisResultConcept<IRUnitT>, /*typename*/ PreservedAnalysesT>  extends /**/ AnalysisResultConcept<IRUnitT> {
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, false>::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, false>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 167,
   FQN="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>", NM="_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEC1ES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEC1ES4_")
  //</editor-fold>
  public /*explicit*/ AnalysisResultModelTT1T2T3True(ResultT Result,
          CopyConstructor<ResultT> $Ctor, Class<PassT> clazzT) {
    // : Result(std::move(Result))
    //START JInit
    this.Result = /*ParenListExpr*//*new ResultT*/$Ctor.$call(std.move(Result));
    this.clazzT = clazzT;
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 170,
   FQN="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>", NM="_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEC1ERKNS1_IS2_S3_S4_S5_Lb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEC1ERKNS1_IS2_S3_S4_S5_Lb1EEE")
  //</editor-fold>
  public AnalysisResultModelTT1T2T3True(final /*const*/ AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> /*&*/ Arg,
          CopyConstructor<ResultT> $Ctor, Class<PassT> clazzT) {
    // : Result(Arg.Result)
    //START JInit
    this.Result = /*ParenListExpr*//*new ResultT*/$Ctor.$call(Arg.Result);
    this.clazzT = clazzT;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 171,
   FQN="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>", NM="_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEC1EONS1_IS2_S3_S4_S5_Lb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEC1EONS1_IS2_S3_S4_S5_Lb1EEE")
  //</editor-fold>
  public AnalysisResultModelTT1T2T3True(JD$Move _dparam, final AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> /*&&*/Arg,
          CopyConstructor<ResultT> $Ctor, Class<PassT> clazzT) {
    // : Result(std::move(Arg.Result))
    //START JInit
    this.Result = /*ParenListExpr*//*new ResultT*/$Ctor.$call(std.move(Arg.Result));
    this.clazzT = clazzT;
    //END JInit
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::detail::swap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 173,
   FQN="llvm::detail::swap", NM="_ZN4llvm6detail4swapERNS0_19AnalysisResultModelIT_T0_T1_T2_Lb1EEES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail4swapERNS0_19AnalysisResultModelIT_T0_T1_T2_Lb1EEES8_")
  //</editor-fold>
  public static <IRUnitT, PassT extends AnalysisInfoMixin<PassT>, ResultT extends AnalysisResultConcept<IRUnitT>, PreservedAnalysesT> void swap(final AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> /*&*/ LHS, final AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> /*&*/ RHS) {
    //JAVA: using std::swap;
    std.swap(LHS.Result, RHS.Result);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 177,
   FQN="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::operator=", NM="_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEaSENS1_IS2_S3_S4_S5_Lb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EEaSENS1_IS2_S3_S4_S5_Lb1EEE")
  //</editor-fold>
  public AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> /*&*/ $assign(AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> RHS) {
    swap(/*Deref*/this, RHS);
    return /*Deref*/this;
  }


  /// \brief The model delegates to the \c ResultT method.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 183,
   FQN="llvm::detail::AnalysisResultModel<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2, type-parameter-0-3, true>::invalidate", NM="_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EE10invalidateERS2_RKS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisResultModelIT_T0_T1_T2_Lb1EE10invalidateERS2_RKS5_")
  //</editor-fold>
  public boolean invalidate(final IRUnitT /*&*/ IR, final /*const*/ PreservedAnalyses /*&*/ PA)/* override*/ {
    return Result.invalidate(IR, PA);
  }


  public ResultT Result;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final Class<PassT> clazzT;

  public @Override void swap(NativeSwappable RHS) {
    AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT> other = 
            (AnalysisResultModelTT1T2T3True<IRUnitT, PassT, ResultT, PreservedAnalysesT>) RHS;
    assert this.clazzT == other.clazzT;
    ResultT myOldResult = this.Result;
    this.Result = other.Result;
    other.Result = myOldResult;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
