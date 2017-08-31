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

import org.clank.support.*;
import org.llvm.ir.*;


/// \brief Abstract concept of an analysis result.
///
/// This concept is parameterized over the IR unit that this result pertains
/// to.
/*template <typename IRUnitT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultConcept">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 82,
 FQN="llvm::detail::AnalysisResultConcept", NM="_ZN4llvm6detail21AnalysisResultConceptE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail21AnalysisResultConceptE")
//</editor-fold>
public abstract class/*struct*/ AnalysisResultConcept</*typename*/ IRUnitT>  implements NativeSwappable, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultConcept::~AnalysisResultConcept<IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 83,
   FQN="llvm::detail::AnalysisResultConcept::~AnalysisResultConcept<IRUnitT>", NM="_ZN4llvm6detail21AnalysisResultConceptD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail21AnalysisResultConceptD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// \brief Method to try and mark a result as invalid.
  ///
  /// When the outer analysis manager detects a change in some underlying
  /// unit of the IR, it will call this method on all of the results cached.
  ///
  /// This method also receives a set of preserved analyses which can be used
  /// to avoid invalidation because the pass which changed the underlying IR
  /// took care to update or preserve the analysis result in some way.
  ///
  /// \returns true if the result is indeed invalid (the default).
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisResultConcept::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManagerInternal.h", line = 95,
   FQN="llvm::detail::AnalysisResultConcept::invalidate", NM="_ZN4llvm6detail21AnalysisResultConcept10invalidateERT_RKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail21AnalysisResultConcept10invalidateERT_RKNS_17PreservedAnalysesE")
  //</editor-fold>
  public abstract /*virtual*/ boolean invalidate(final IRUnitT /*&*/ IR, final /*const*/ PreservedAnalyses /*&*/ PA)/* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
