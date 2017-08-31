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


/// An interface layer with SCEV used to manage how we see SCEV expressions
/// for values in the context of existing predicates. We can add new
/// predicates, but we cannot remove them.
///
/// This layer has multiple purposes:
///   - provides a simple interface for SCEV versioning.
///   - guarantees that the order of transformations applied on a SCEV
///     expression for a single Value is consistent across two different
///     getSCEV calls. This means that, for example, once we've obtained
///     an AddRec expression for a certain value through expression
///     rewriting, we will continue to get an AddRec expression for that
///     Value.
///   - lowers the number of expression rewrites.
//<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1724,
 FQN="llvm::PredicatedScalarEvolution", NM="_ZN4llvm25PredicatedScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm25PredicatedScalarEvolutionE")
//</editor-fold>
public class PredicatedScalarEvolution implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::PredicatedScalarEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10341,
   FQN="llvm::PredicatedScalarEvolution::PredicatedScalarEvolution", NM="_ZN4llvm25PredicatedScalarEvolutionC1ERNS_15ScalarEvolutionERNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolutionC1ERNS_15ScalarEvolutionERNS_4LoopE")
  //</editor-fold>
  public PredicatedScalarEvolution(final ScalarEvolution /*&*/ SE, 
      final Loop /*&*/ L) {
    // : RewriteMap(), FlagsMap(), SE(SE), L(L), Preds(), Generation(0), BackedgeCount(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::getUnionPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10380,
   FQN="llvm::PredicatedScalarEvolution::getUnionPredicate", NM="_ZNK4llvm25PredicatedScalarEvolution17getUnionPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm25PredicatedScalarEvolution17getUnionPredicateEv")
  //</editor-fold>
  public /*const*/ SCEVUnionPredicate /*&*/ getUnionPredicate() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Returns the SCEV expression of V, in the context of the current SCEV
  /// predicate.  The order of transformations applied on the expression of V
  /// returned by ScalarEvolution is guaranteed to be preserved, even when
  /// adding new predicates.
  
  /// Returns the SCEV expression of V, in the context of the current SCEV
  /// predicate.  The order of transformations applied on the expression of V
  /// returned by ScalarEvolution is guaranteed to be preserved, even when
  /// adding new predicates.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::getSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10345,
   FQN="llvm::PredicatedScalarEvolution::getSCEV", NM="_ZN4llvm25PredicatedScalarEvolution7getSCEVEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution7getSCEVEPNS_5ValueE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getSCEV(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get the (predicated) backedge count for the analyzed loop.
  
  /// Get the (predicated) backedge count for the analyzed loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::getBackedgeTakenCount">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10364,
   FQN="llvm::PredicatedScalarEvolution::getBackedgeTakenCount", NM="_ZN4llvm25PredicatedScalarEvolution21getBackedgeTakenCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution21getBackedgeTakenCountEv")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ getBackedgeTakenCount() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Adds a new predicate.
  
  /// Adds a new predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::addPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10373,
   FQN="llvm::PredicatedScalarEvolution::addPredicate", NM="_ZN4llvm25PredicatedScalarEvolution12addPredicateERKNS_13SCEVPredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution12addPredicateERKNS_13SCEVPredicateE")
  //</editor-fold>
  public void addPredicate(final /*const*/ SCEVPredicate /*&*/ Pred) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Attempts to produce an AddRecExpr for V by adding additional SCEV
  /// predicates. If we can't transform the expression into an AddRecExpr we
  /// return nullptr and not add additional SCEV predicates to the current
  /// context.
  
  /// Attempts to produce an AddRecExpr for V by adding additional SCEV
  /// predicates. If we can't transform the expression into an AddRecExpr we
  /// return nullptr and not add additional SCEV predicates to the current
  /// context.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::getAsAddRec">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10426,
   FQN="llvm::PredicatedScalarEvolution::getAsAddRec", NM="_ZN4llvm25PredicatedScalarEvolution11getAsAddRecEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution11getAsAddRecEPNS_5ValueE")
  //</editor-fold>
  public /*const*/ SCEVAddRecExpr /*P*/ getAsAddRec(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Proves that V doesn't overflow by adding SCEV predicate.
  
  /// Proves that V doesn't overflow by adding SCEV predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::setNoOverflow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10394,
   FQN="llvm::PredicatedScalarEvolution::setNoOverflow", NM="_ZN4llvm25PredicatedScalarEvolution13setNoOverflowEPNS_5ValueENS_17SCEVWrapPredicate18IncrementWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution13setNoOverflowEPNS_5ValueENS_17SCEVWrapPredicate18IncrementWrapFlagsE")
  //</editor-fold>
  public void setNoOverflow(Value /*P*/ V, /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Returns true if we've proved that V doesn't wrap by means of a SCEV
  /// predicate.
  
  /// Returns true if we've proved that V doesn't wrap by means of a SCEV
  /// predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::hasNoOverflow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10410,
   FQN="llvm::PredicatedScalarEvolution::hasNoOverflow", NM="_ZN4llvm25PredicatedScalarEvolution13hasNoOverflowEPNS_5ValueENS_17SCEVWrapPredicate18IncrementWrapFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution13hasNoOverflowEPNS_5ValueENS_17SCEVWrapPredicate18IncrementWrapFlagsE")
  //</editor-fold>
  public boolean hasNoOverflow(Value /*P*/ V, /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int Flags) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Returns the ScalarEvolution analysis used.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::getSE">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1755,
   FQN="llvm::PredicatedScalarEvolution::getSE", NM="_ZNK4llvm25PredicatedScalarEvolution5getSEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm25PredicatedScalarEvolution5getSEEv")
  //</editor-fold>
  public ScalarEvolution /*P*/ getSE() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// We need to explicitly define the copy constructor because of FlagsMap.
  
  /// We need to explicitly define the copy constructor because of FlagsMap.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::PredicatedScalarEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10438,
   FQN="llvm::PredicatedScalarEvolution::PredicatedScalarEvolution", NM="_ZN4llvm25PredicatedScalarEvolutionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolutionC1ERKS0_")
  //</editor-fold>
  public PredicatedScalarEvolution(final /*const*/ PredicatedScalarEvolution /*&*/ Init) {
    // : RewriteMap(Init.RewriteMap), FlagsMap(), SE(Init.SE), L(Init.L), Preds(Init.Preds), Generation(Init.Generation), BackedgeCount(Init.BackedgeCount) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Print the SCEV mappings done by the Predicated Scalar Evolution.
  /// The printed text is indented by \p Depth.
  
  /// Print the SCEV mappings done by the Predicated Scalar Evolution.
  /// The printed text is indented by \p Depth.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10446,
   FQN="llvm::PredicatedScalarEvolution::print", NM="_ZNK4llvm25PredicatedScalarEvolution5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm25PredicatedScalarEvolution5printERNS_11raw_ostreamEj")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, /*uint*/int Depth) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  /// Increments the version number of the predicate.  This needs to be called
  /// every time the SCEV predicate changes.
  /// Increments the version number of the predicate.  This needs to be called
  /// every time the SCEV predicate changes.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::updateGeneration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10384,
   FQN="llvm::PredicatedScalarEvolution::updateGeneration", NM="_ZN4llvm25PredicatedScalarEvolution16updateGenerationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm25PredicatedScalarEvolution16updateGenerationEv")
  //</editor-fold>
  private void updateGeneration() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Holds a SCEV and the version number of the SCEV predicate used to
  /// perform the rewrite of the expression.
  // JAVA: typedef std::pair<unsigned int, const SCEV *> RewriteEntry
//  public final class RewriteEntry extends std.pairUIntType</*const*/ SCEV /*P*/ >{ };
  
  /// Maps a SCEV to the rewrite result of that SCEV at a certain version
  /// number. If this number doesn't match the current Generation, we will
  /// need to do a rewrite. To preserve the transformation order of previous
  /// rewrites, we will rewrite the previous result instead of the original
  /// SCEV.
  private DenseMap</*const*/ SCEV /*P*/ , std.pairUIntType</*const*/ SCEV /*P*/ >> RewriteMap;
  
  /// Records what NoWrap flags we've added to a Value *.
  //private ValueMap<Value /*P*/ , /*SCEVWrapPredicate::IncrementWrapFlags*//*uint*/int> FlagsMap;
  
  /// The ScalarEvolution analysis.
  private final ScalarEvolution /*&*/ SE;
  
  /// The analyzed Loop.
  private final /*const*/ Loop /*&*/ L;
  
  /// The SCEVPredicate that forms our context. We will rewrite all
  /// expressions assuming that this predicate true.
  private SCEVUnionPredicate Preds;
  
  /// Marks the version of the SCEV predicate used. When rewriting a SCEV
  /// expression we mark it with the version of the predicate. We use this to
  /// figure out if the predicate has changed from the last rewrite of the
  /// SCEV. If so, we need to perform a new rewrite.
  private /*uint*/int Generation;
  
  /// The backedge taken count.
  private /*const*/ SCEV /*P*/ BackedgeCount;
  //<editor-fold defaultstate="collapsed" desc="llvm::PredicatedScalarEvolution::~PredicatedScalarEvolution">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 1724,
   FQN="llvm::PredicatedScalarEvolution::~PredicatedScalarEvolution", NM="_ZN4llvm25PredicatedScalarEvolutionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm25PredicatedScalarEvolutionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RewriteMap=" + RewriteMap // NOI18N
              //+ ", FlagsMap=" + FlagsMap // NOI18N
              + ", SE=" + SE // NOI18N
              + ", L=" + L // NOI18N
              + ", Preds=" + Preds // NOI18N
              + ", Generation=" + Generation // NOI18N
              + ", BackedgeCount=" + BackedgeCount; // NOI18N
  }
}
