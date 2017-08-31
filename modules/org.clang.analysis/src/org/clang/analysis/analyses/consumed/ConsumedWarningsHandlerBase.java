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

package org.clang.analysis.analyses.consumed;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 43,
 FQN="clang::consumed::ConsumedWarningsHandlerBase", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBaseE")
//</editor-fold>
public class ConsumedWarningsHandlerBase implements Destructors.ClassWithDestructor {
/*public:*/
  
  // Key method definition
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::~ConsumedWarningsHandlerBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 55,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::~ConsumedWarningsHandlerBase", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBaseD0Ev")
  //</editor-fold>
  public void $destroy() {
  }


  
  /// \brief Emit the warnings and notes left by the analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::emitDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 50,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::emitDiagnostics", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase15emitDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase15emitDiagnosticsEv")
  //</editor-fold>
  public /*virtual*/ void emitDiagnostics() {
  }

  
  /// \brief Warn that a variable's state doesn't match at the entry and exit
  /// of a loop.
  ///
  /// \param Loc -- The location of the end of the loop.
  ///
  /// \param VariableName -- The name of the variable that has a mismatched
  /// state.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnLoopStateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 59,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnLoopStateMismatch", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase21warnLoopStateMismatchENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase21warnLoopStateMismatchENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void warnLoopStateMismatch(SourceLocation Loc, 
                       StringRef VariableName) {
  }

  
  /// \brief Warn about parameter typestate mismatches upon return.
  ///
  /// \param Loc -- The SourceLocation of the return statement.
  ///
  /// \param ExpectedState -- The state the return value was expected to be
  /// in.
  ///
  /// \param ObservedState -- The state the return value was observed to be
  /// in.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnParamReturnTypestateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 71,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnParamReturnTypestateMismatch", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase32warnParamReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase32warnParamReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES4_S4_")
  //</editor-fold>
  public /*virtual*/ void warnParamReturnTypestateMismatch(SourceLocation Loc, 
                                  StringRef VariableName, 
                                  StringRef ExpectedState, 
                                  StringRef ObservedState) {
  }

  
  // FIXME: Add documentation.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnParamTypestateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 77,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnParamTypestateMismatch", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase26warnParamTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase26warnParamTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES4_")
  //</editor-fold>
  public /*virtual*/ void warnParamTypestateMismatch(SourceLocation LOC, 
                            StringRef ExpectedState, 
                            StringRef ObservedState) {
  }

  
  // FIXME: This can be removed when the attr propagation fix for templated
  //        classes lands.
  /// \brief Warn about return typestates set for unconsumable types.
  /// 
  /// \param Loc -- The location of the attributes.
  ///
  /// \param TypeName -- The name of the unconsumable type.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnReturnTypestateForUnconsumableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 88,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnReturnTypestateForUnconsumableType", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase38warnReturnTypestateForUnconsumableTypeENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase38warnReturnTypestateForUnconsumableTypeENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public /*virtual*/ void warnReturnTypestateForUnconsumableType(SourceLocation Loc, 
                                        StringRef TypeName) {
  }

  
  /// \brief Warn about return typestate mismatches.
  ///
  /// \param Loc -- The SourceLocation of the return statement.
  ///
  /// \param ExpectedState -- The state the return value was expected to be
  /// in.
  ///
  /// \param ObservedState -- The state the return value was observed to be
  /// in.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnReturnTypestateMismatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 100,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnReturnTypestateMismatch", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase27warnReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase27warnReturnTypestateMismatchENS_14SourceLocationEN4llvm9StringRefES4_")
  //</editor-fold>
  public /*virtual*/ void warnReturnTypestateMismatch(SourceLocation Loc, 
                             StringRef ExpectedState, 
                             StringRef ObservedState) {
  }

  
  /// \brief Warn about use-while-consumed errors.
  /// \param MethodName -- The name of the method that was incorrectly
  /// invoked.
  ///
  /// \param State -- The state the object was used in.
  ///
  /// \param Loc -- The SourceLocation of the method invocation.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnUseOfTempInInvalidState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 111,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnUseOfTempInInvalidState", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase27warnUseOfTempInInvalidStateEN4llvm9StringRefES3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase27warnUseOfTempInInvalidStateEN4llvm9StringRefES3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void warnUseOfTempInInvalidState(StringRef MethodName, 
                             StringRef State, 
                             SourceLocation Loc) {
  }

  
  /// \brief Warn about use-while-consumed errors.
  /// \param MethodName -- The name of the method that was incorrectly
  /// invoked.
  ///
  /// \param State -- The state the object was used in.
  ///
  /// \param VariableName -- The name of the variable that holds the unique
  /// value.
  ///
  /// \param Loc -- The SourceLocation of the method invocation.
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::warnUseInInvalidState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 125,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::warnUseInInvalidState", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBase21warnUseInInvalidStateEN4llvm9StringRefES3_S3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBase21warnUseInInvalidStateEN4llvm9StringRefES3_S3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void warnUseInInvalidState(StringRef MethodName, 
                       StringRef VariableName, 
                       StringRef State, 
                       SourceLocation Loc) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedWarningsHandlerBase::ConsumedWarningsHandlerBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 43,
   FQN="clang::consumed::ConsumedWarningsHandlerBase::ConsumedWarningsHandlerBase", NM="_ZN5clang8consumed27ConsumedWarningsHandlerBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8consumed27ConsumedWarningsHandlerBaseC1Ev")
  //</editor-fold>
  public /*inline*/ ConsumedWarningsHandlerBase() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
