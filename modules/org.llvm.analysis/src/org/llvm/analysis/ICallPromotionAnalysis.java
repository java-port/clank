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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import org.llvm.profiledata.InstrProfValueData;


// Class for identifying profitable indirect call promotion candidates when
// the indirect-call value profile metadata is available.
//<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IndirectCallPromotionAnalysis.h", line = 25,
 FQN="llvm::ICallPromotionAnalysis", NM="_ZN4llvm22ICallPromotionAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm22ICallPromotionAnalysisE")
//</editor-fold>
public class ICallPromotionAnalysis implements Destructors.ClassWithDestructor {
/*private:*/
  // Allocate space to read the profile annotation.
  private unique_ptr_array<InstrProfValueData []> ValueDataArray;
  
  // Count is the call count for the direct-call target and
  // TotalCount is the call count for the indirect-call callsite.
  // Return true we should promote this indirect-call target.
  
  // Count is the call count for the direct-call target and
  // TotalCount is the call count for the indirect-call callsite.
  // Return true we should promote this indirect-call target.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::isPromotionProfitable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp", line = 61,
   FQN="llvm::ICallPromotionAnalysis::isPromotionProfitable", NM="_ZN4llvm22ICallPromotionAnalysis21isPromotionProfitableEyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp -nm=_ZN4llvm22ICallPromotionAnalysis21isPromotionProfitableEyy")
  //</editor-fold>
  private boolean isPromotionProfitable(long/*uint64_t*/ Count, 
                       long/*uint64_t*/ TotalCount) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Returns the number of profitable candidates to promote for the
  // current ValueDataArray and the given \p Inst.
  
  // Returns the number of profitable candidates to promote for the
  // current ValueDataArray and the given \p Inst.
  
  // Indirect-call promotion heuristic. The direct targets are sorted based on
  // the count. Stop at the first target that is not promoted. Returns the
  // number of candidates deemed profitable.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::getProfitablePromotionCandidates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp", line = 73,
   FQN="llvm::ICallPromotionAnalysis::getProfitablePromotionCandidates", NM="_ZN4llvm22ICallPromotionAnalysis32getProfitablePromotionCandidatesEPKNS_11InstructionEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp -nm=_ZN4llvm22ICallPromotionAnalysis32getProfitablePromotionCandidatesEPKNS_11InstructionEjy")
  //</editor-fold>
  private /*uint32_t*/int getProfitablePromotionCandidates(/*const*/ Instruction /*P*/ Inst, /*uint32_t*/int NumVals, long/*uint64_t*/ TotalCount) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Noncopyable
  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::ICallPromotionAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IndirectCallPromotionAnalysis.h", line = 42,
   FQN="llvm::ICallPromotionAnalysis::ICallPromotionAnalysis", NM="_ZN4llvm22ICallPromotionAnalysisC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm22ICallPromotionAnalysisC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ICallPromotionAnalysis(final /*const*/ ICallPromotionAnalysis /*&*/ other) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IndirectCallPromotionAnalysis.h", line = 43,
   FQN="llvm::ICallPromotionAnalysis::operator=", NM="_ZN4llvm22ICallPromotionAnalysisaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm22ICallPromotionAnalysisaSERKS0_")
  //</editor-fold>
  protected/*private*/ ICallPromotionAnalysis /*&*/ $assign(final /*const*/ ICallPromotionAnalysis /*&*/ other) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::ICallPromotionAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp", line = 57,
   FQN="llvm::ICallPromotionAnalysis::ICallPromotionAnalysis", NM="_ZN4llvm22ICallPromotionAnalysisC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp -nm=_ZN4llvm22ICallPromotionAnalysisC1Ev")
  //</editor-fold>
  public ICallPromotionAnalysis() {
    // : ValueDataArray() 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Returns reference to array of InstrProfValueData for the given
  /// instruction \p I.
  ///
  /// The \p NumVals, \p TotalCount and \p NumCandidates
  /// are set to the number of values in the array, the total profile count
  /// of the indirect call \p I, and the number of profitable candidates
  /// in the given array (which is sorted in reverse order of profitability).
  ///
  /// The returned array space is owned by this class, and overwritten on
  /// subsequent calls.
  
  /// \brief Returns reference to array of InstrProfValueData for the given
  /// instruction \p I.
  ///
  /// The \p NumVals, \p TotalCount and \p NumCandidates
  /// are set to the number of values in the array, the total profile count
  /// of the indirect call \p I, and the number of profitable candidates
  /// in the given array (which is sorted in reverse order of profitability).
  ///
  /// The returned array space is owned by this class, and overwritten on
  /// subsequent calls.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::getPromotionCandidatesForInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp", line = 96,
   FQN="llvm::ICallPromotionAnalysis::getPromotionCandidatesForInstruction", NM="_ZN4llvm22ICallPromotionAnalysis36getPromotionCandidatesForInstructionEPKNS_11InstructionERjRyS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp -nm=_ZN4llvm22ICallPromotionAnalysis36getPromotionCandidatesForInstructionEPKNS_11InstructionERjRyS4_")
  //</editor-fold>
  public ArrayRef< InstrProfValueData> getPromotionCandidatesForInstruction(/*const*/ Instruction /*P*/ I, final /*uint32_t &*/uint$ref NumVals, final ulong$ref/*uint64_t &*/ TotalCount, 
                                      final /*uint32_t &*/uint$ref NumCandidates) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ICallPromotionAnalysis::~ICallPromotionAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IndirectCallPromotionAnalysis.h", line = 25,
   FQN="llvm::ICallPromotionAnalysis::~ICallPromotionAnalysis", NM="_ZN4llvm22ICallPromotionAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm22ICallPromotionAnalysisD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ValueDataArray=" + ValueDataArray; // NOI18N
  }
}
