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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// This class uses information about analyze scalars to
/// rewrite expressions in canonical form.
///
/// Clients should create an instance of this class when rewriting is needed,
/// and destroy it when finished to allow the release of the associated
/// memory.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 37,
 FQN="llvm::SCEVExpander", NM="_ZN4llvm12SCEVExpanderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpanderE")
//</editor-fold>
public class SCEVExpander extends /*public*/ SCEVVisitor<SCEVExpander, Value /*P*/ > implements Destructors.ClassWithDestructor {
  private final ScalarEvolution /*&*/ SE;
  private final /*const*/ DataLayout /*&*/ DL;
  
  // New instructions receive a name to identifies them with the current pass.
  private /*const*/char$ptr/*char P*/ IVName;
  
  // InsertedExpressions caches Values for reuse, so must track RAUW.
  private std.mapTypeType<std.pair</*const*/ SCEV /*P*/ , Instruction /*P*/ >, TrackingVH<Value>> InsertedExpressions;
  // InsertedValues only flags inserted instructions so needs no RAUW.
  private std.setType<AssertingVH<Value> > InsertedValues;
  private std.setType<AssertingVH<Value> > InsertedPostIncValues;
  
  /// A memoization of the "relevant" loop for a given SCEV.
  private DenseMap</*const*/ SCEV /*P*/ , /*const*/ Loop /*P*/ > RelevantLoops;
  
  /// \brief Addrecs referring to any of the given loops are expanded
  /// in post-inc mode. For example, expanding {1,+,1}<L> in post-inc mode
  /// returns the add instruction that adds one to the phi for {0,+,1}<L>,
  /// as opposed to a new phi starting at 1. This is only supported in
  /// non-canonical mode.
  private SmallPtrSet</*const*/ Loop /*P*/ > PostIncLoops;
  
  /// \brief When this is non-null, addrecs expanded in the loop it indicates
  /// should be inserted with increments at IVIncInsertPos.
  private /*const*/ Loop /*P*/ IVIncInsertLoop;
  
  /// \brief When expanding addrecs in the IVIncInsertLoop loop, insert the IV
  /// increment at this position.
  private Instruction /*P*/ IVIncInsertPos;
  
  /// \brief Phis that complete an IV chain. Reuse
  private std.setType<AssertingVH<PHINode> > ChainedPhis;
  
  /// \brief When true, expressions are expanded in "canonical" form. In
  /// particular, addrecs are expanded as arithmetic based on a canonical
  /// induction variable. When false, expression are expanded in a more
  /// literal form.
  private boolean CanonicalMode;
  
  /// \brief When invoked from LSR, the expander is in "strength reduction"
  /// mode. The only difference is that phi's are only reused if they are
  /// already in "expanded" form.
  private boolean LSRMode;
  
  // JAVA: typedef IRBuilder<TargetFolder> BuilderType
//  public final class BuilderType extends IRBuilder<TargetFolder>{ };
  private IRBuilder<TargetFolder, IRBuilderDefaultInserter> Builder;
  
  // RAII object that stores the current insertion point and restores it when
  // the object is destroyed. This includes the debug location.  Duplicated
  // from InsertPointGuard to add SetInsertPoint() which is used to updated
  // InsertPointGuards stack when insert points are moved during SCEV
  // expansion.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 91,
   FQN="llvm::SCEVExpander::SCEVInsertPointGuard", NM="_ZN4llvm12SCEVExpander20SCEVInsertPointGuardE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20SCEVInsertPointGuardE")
  //</editor-fold>
  private static class SCEVInsertPointGuard implements Destructors.ClassWithDestructor {
    private final IRBuilderBase /*&*/ Builder;
    private AssertingVH<BasicBlock> Block;
    private ilist_iterator<Instruction> Point;
    private DebugLoc DbgLoc;
    private SCEVExpander /*P*/ SE;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard::SCEVInsertPointGuard">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 98,
     FQN="llvm::SCEVExpander::SCEVInsertPointGuard::SCEVInsertPointGuard", NM="_ZN4llvm12SCEVExpander20SCEVInsertPointGuardC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20SCEVInsertPointGuardC1ERKS1_")
    //</editor-fold>
    protected/*private*/ SCEVInsertPointGuard(final /*const*/ SCEVInsertPointGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 99,
     FQN="llvm::SCEVExpander::SCEVInsertPointGuard::operator=", NM="_ZN4llvm12SCEVExpander20SCEVInsertPointGuardaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20SCEVInsertPointGuardaSERKS1_")
    //</editor-fold>
    protected/*private*/ SCEVInsertPointGuard /*&*/ $assign(final /*const*/ SCEVInsertPointGuard /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard::SCEVInsertPointGuard">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 102,
     FQN="llvm::SCEVExpander::SCEVInsertPointGuard::SCEVInsertPointGuard", NM="_ZN4llvm12SCEVExpander20SCEVInsertPointGuardC1ERNS_13IRBuilderBaseEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20SCEVInsertPointGuardC1ERNS_13IRBuilderBaseEPS0_")
    //</editor-fold>
    public SCEVInsertPointGuard(final IRBuilderBase /*&*/ B, SCEVExpander /*P*/ SE) {
      // : Builder(B), Block(B.GetInsertBlock()), Point(B.GetInsertPoint()), DbgLoc(B.getCurrentDebugLocation()), SE(SE) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard::~SCEVInsertPointGuard">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 108,
     FQN="llvm::SCEVExpander::SCEVInsertPointGuard::~SCEVInsertPointGuard", NM="_ZN4llvm12SCEVExpander20SCEVInsertPointGuardD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20SCEVInsertPointGuardD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard::GetInsertPoint">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 118,
     FQN="llvm::SCEVExpander::SCEVInsertPointGuard::GetInsertPoint", NM="_ZNK4llvm12SCEVExpander20SCEVInsertPointGuard14GetInsertPointEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVExpander20SCEVInsertPointGuard14GetInsertPointEv")
    //</editor-fold>
    public ilist_iterator<Instruction> GetInsertPoint() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVInsertPointGuard::SetInsertPoint">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 119,
     FQN="llvm::SCEVExpander::SCEVInsertPointGuard::SetInsertPoint", NM="_ZN4llvm12SCEVExpander20SCEVInsertPointGuard14SetInsertPointENS_14ilist_iteratorINS_11InstructionEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20SCEVInsertPointGuard14SetInsertPointENS_14ilist_iteratorINS_11InstructionEEE")
    //</editor-fold>
    public void SetInsertPoint(ilist_iterator<Instruction> I) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Builder=" + Builder // NOI18N
                + ", Block=" + Block // NOI18N
                + ", Point=" + Point // NOI18N
                + ", DbgLoc=" + DbgLoc // NOI18N
                + ", SE=" + SE; // NOI18N
    }
  };
  
  /// Stack of pointers to saved insert points, used to keep insert points
  /// consistent when instructions are moved.
  private SmallVector<SCEVInsertPointGuard /*P*/ > InsertPointGuards;
  private /*const*/char$ptr/*char P*/ DebugType;
  
  /*friend  struct SCEVVisitor<SCEVExpander, Value *>*/
/*public:*/
  /// \brief Construct a SCEVExpander in "canonical" mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::SCEVExpander">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 134,
   FQN="llvm::SCEVExpander::SCEVExpander", NM="_ZN4llvm12SCEVExpanderC1ERNS_15ScalarEvolutionERKNS_10DataLayoutEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpanderC1ERNS_15ScalarEvolutionERKNS_10DataLayoutEPKc")
  //</editor-fold>
  public /*explicit*/ SCEVExpander(final ScalarEvolution /*&*/ se, final /*const*/ DataLayout /*&*/ DL, 
      /*const*/char$ptr/*char P*/ name) {
    // : SCEVVisitor<SCEVExpander, Value * >(), SE(se), DL(DL), IVName(name), InsertedExpressions(), InsertedValues(), InsertedPostIncValues(), RelevantLoops(), PostIncLoops(), IVIncInsertLoop(null), IVIncInsertPos(null), ChainedPhis(), CanonicalMode(true), LSRMode(false), Builder(se.getContext(), TargetFolder(DL)), InsertPointGuards() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::~SCEVExpander">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 144,
   FQN="llvm::SCEVExpander::~SCEVExpander", NM="_ZN4llvm12SCEVExpanderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpanderD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::setDebugType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 150,
   FQN="llvm::SCEVExpander::setDebugType", NM="_ZN4llvm12SCEVExpander12setDebugTypeEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander12setDebugTypeEPKc")
  //</editor-fold>
  public void setDebugType(/*const*/char$ptr/*char P*/ s) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Erase the contents of the InsertedExpressions map so that users
  /// trying to expand the same expression into multiple BasicBlocks or
  /// different places within the same BasicBlock can do so.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 156,
   FQN="llvm::SCEVExpander::clear", NM="_ZN4llvm12SCEVExpander5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return true for expressions that may incur non-trivial cost to
  /// evaluate at runtime.
  ///
  /// At is an optional parameter which specifies point in code where user is
  /// going to expand this expression. Sometimes this knowledge can lead to a
  /// more accurate cost estimation.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::isHighCostExpansion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 169,
   FQN="llvm::SCEVExpander::isHighCostExpansion", NM="_ZN4llvm12SCEVExpander19isHighCostExpansionEPKNS_4SCEVEPNS_4LoopEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander19isHighCostExpansionEPKNS_4SCEVEPNS_4LoopEPKNS_11InstructionE")
  //</editor-fold>
  public boolean isHighCostExpansion(/*const*/ SCEV /*P*/ Expr, Loop /*P*/ L) {
    return isHighCostExpansion(Expr, L, 
                     (/*const*/ Instruction /*P*/ )null);
  }
  public boolean isHighCostExpansion(/*const*/ SCEV /*P*/ Expr, Loop /*P*/ L, 
                     /*const*/ Instruction /*P*/ At/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief This method returns the canonical induction variable of the
  /// specified type for the specified loop (inserting one if there is none).
  /// A canonical induction variable starts at zero and steps by one on each
  /// iteration.
  
  /// getOrInsertCanonicalInductionVariable - This method returns the
  /// canonical induction variable of the specified type for the specified
  /// loop (inserting one if there is none).  A canonical induction variable
  /// starts at zero and steps by one on each iteration.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::getOrInsertCanonicalInductionVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1727,
   FQN="llvm::SCEVExpander::getOrInsertCanonicalInductionVariable", NM="_ZN4llvm12SCEVExpander37getOrInsertCanonicalInductionVariableEPKNS_4LoopEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander37getOrInsertCanonicalInductionVariableEPKNS_4LoopEPNS_4TypeE")
  //</editor-fold>
  public PHINode /*P*/ getOrInsertCanonicalInductionVariable(/*const*/ Loop /*P*/ L, 
                                       Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the induction variable increment's IV operand.
  
  /// getIVIncOperand returns an induction variable increment's induction
  /// variable operand.
  ///
  /// If allowScale is set, any type of GEP is allowed as long as the nonIV
  /// operands dominate InsertPos.
  ///
  /// If allowScale is not set, ensure that a GEP increment conforms to one of the
  /// simple patterns generated by getAddRecExprPHILiterally and
  /// expandAddtoGEP. If the pattern isn't recognized, return NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::getIVIncOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 859,
   FQN="llvm::SCEVExpander::getIVIncOperand", NM="_ZN4llvm12SCEVExpander15getIVIncOperandEPNS_11InstructionES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander15getIVIncOperandEPNS_11InstructionES2_b")
  //</editor-fold>
  public Instruction /*P*/ getIVIncOperand(Instruction /*P*/ IncV, 
                 Instruction /*P*/ InsertPos, 
                 boolean allowScale) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Utility for hoisting an IV increment.
  
  /// hoistStep - Attempt to hoist a simple IV increment above InsertPos to make
  /// it available to other uses in this loop. Recursively hoist any operands,
  /// until we reach a value that dominates InsertPos.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::hoistIVInc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 926,
   FQN="llvm::SCEVExpander::hoistIVInc", NM="_ZN4llvm12SCEVExpander10hoistIVIncEPNS_11InstructionES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander10hoistIVIncEPNS_11InstructionES2_")
  //</editor-fold>
  public boolean hoistIVInc(Instruction /*P*/ IncV, Instruction /*P*/ InsertPos) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief replace congruent phis with their most canonical
  /// representative. Return the number of phis eliminated.
  
  /// replaceCongruentIVs - Check for congruent phis in this loop header and
  /// replace them with their most canonical representative. Return the number of
  /// phis eliminated.
  ///
  /// This does not depend on any SCEVExpander state but should be used in
  /// the same context that SCEVExpander is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::replaceCongruentIVs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1751,
   FQN="llvm::SCEVExpander::replaceCongruentIVs", NM="_ZN4llvm12SCEVExpander19replaceCongruentIVsEPNS_4LoopEPKNS_13DominatorTreeERNS_15SmallVectorImplINS_6WeakVHEEEPKNS_19TargetTransformInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander19replaceCongruentIVsEPNS_4LoopEPKNS_13DominatorTreeERNS_15SmallVectorImplINS_6WeakVHEEEPKNS_19TargetTransformInfoE")
  //</editor-fold>
  public /*uint*/int replaceCongruentIVs(Loop /*P*/ L, /*const*/ DominatorTree /*P*/ DT, 
                     final SmallVectorImpl<WeakVH> /*&*/ DeadInsts) {
    return replaceCongruentIVs(L, DT, 
                     DeadInsts, 
                     (/*const*/ TargetTransformInfo /*P*/ )null);
  }
  public /*uint*/int replaceCongruentIVs(Loop /*P*/ L, /*const*/ DominatorTree /*P*/ DT, 
                     final SmallVectorImpl<WeakVH> /*&*/ DeadInsts, 
                     /*const*/ TargetTransformInfo /*P*/ TTI/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Insert code to directly compute the specified SCEV expression
  /// into the program.  The inserted code is inserted into the specified
  /// block.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandCodeFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1611,
   FQN="llvm::SCEVExpander::expandCodeFor", NM="_ZN4llvm12SCEVExpander13expandCodeForEPKNS_4SCEVEPNS_4TypeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13expandCodeForEPKNS_4SCEVEPNS_4TypeEPNS_11InstructionE")
  //</editor-fold>
  public Value /*P*/ expandCodeFor(/*const*/ SCEV /*P*/ SH, Type /*P*/ Ty, 
               Instruction /*P*/ IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Insert code to directly compute the specified SCEV expression
  /// into the program.  The inserted code is inserted into the SCEVExpander's
  /// current insertion point. If a type is specified, the result will be
  /// expanded to have that type, with a cast if necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandCodeFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1617,
   FQN="llvm::SCEVExpander::expandCodeFor", NM="_ZN4llvm12SCEVExpander13expandCodeForEPKNS_4SCEVEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13expandCodeForEPKNS_4SCEVEPNS_4TypeE")
  //</editor-fold>
  public Value /*P*/ expandCodeFor(/*const*/ SCEV /*P*/ SH) {
    return expandCodeFor(SH, (Type /*P*/ )null);
  }
  public Value /*P*/ expandCodeFor(/*const*/ SCEV /*P*/ SH, Type /*P*/ Ty/*= null*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Generates a code sequence that evaluates this predicate.
  /// The inserted instructions will be at position \p Loc.
  /// The result will be of type i1 and will have a value of 0 when the
  /// predicate is false and 1 otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandCodeForPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2005,
   FQN="llvm::SCEVExpander::expandCodeForPredicate", NM="_ZN4llvm12SCEVExpander22expandCodeForPredicateEPKNS_13SCEVPredicateEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander22expandCodeForPredicateEPKNS_13SCEVPredicateEPNS_11InstructionE")
  //</editor-fold>
  public Value /*P*/ expandCodeForPredicate(/*const*/ SCEVPredicate /*P*/ Pred, 
                        Instruction /*P*/ IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief A specialized variant of expandCodeForPredicate, handling the
  /// case when we are expanding code for a SCEVEqualPredicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandEqualPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2021,
   FQN="llvm::SCEVExpander::expandEqualPredicate", NM="_ZN4llvm12SCEVExpander20expandEqualPredicateEPKNS_18SCEVEqualPredicateEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20expandEqualPredicateEPKNS_18SCEVEqualPredicateEPNS_11InstructionE")
  //</editor-fold>
  public Value /*P*/ expandEqualPredicate(/*const*/ SCEVEqualPredicate /*P*/ Pred, 
                      Instruction /*P*/ IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Generates code that evaluates if the \p AR expression will
  /// overflow.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::generateOverflowCheck">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2031,
   FQN="llvm::SCEVExpander::generateOverflowCheck", NM="_ZN4llvm12SCEVExpander21generateOverflowCheckEPKNS_14SCEVAddRecExprEPNS_11InstructionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander21generateOverflowCheckEPKNS_14SCEVAddRecExprEPNS_11InstructionEb")
  //</editor-fold>
  public Value /*P*/ generateOverflowCheck(/*const*/ SCEVAddRecExpr /*P*/ AR, 
                       Instruction /*P*/ Loc, boolean Signed) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief A specialized variant of expandCodeForPredicate, handling the
  /// case when we are expanding code for a SCEVWrapPredicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandWrapPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2116,
   FQN="llvm::SCEVExpander::expandWrapPredicate", NM="_ZN4llvm12SCEVExpander19expandWrapPredicateEPKNS_17SCEVWrapPredicateEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander19expandWrapPredicateEPKNS_17SCEVWrapPredicateEPNS_11InstructionE")
  //</editor-fold>
  public Value /*P*/ expandWrapPredicate(/*const*/ SCEVWrapPredicate /*P*/ Pred, 
                     Instruction /*P*/ IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief A specialized variant of expandCodeForPredicate, handling the
  /// case when we are expanding code for a SCEVUnionPredicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandUnionPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2141,
   FQN="llvm::SCEVExpander::expandUnionPredicate", NM="_ZN4llvm12SCEVExpander20expandUnionPredicateEPKNS_18SCEVUnionPredicateEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20expandUnionPredicateEPKNS_18SCEVUnionPredicateEPNS_11InstructionE")
  //</editor-fold>
  public Value /*P*/ expandUnionPredicate(/*const*/ SCEVUnionPredicate /*P*/ Union, 
                      Instruction /*P*/ IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Set the current IV increment loop and position.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::setIVIncInsertPos">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 232,
   FQN="llvm::SCEVExpander::setIVIncInsertPos", NM="_ZN4llvm12SCEVExpander17setIVIncInsertPosEPKNS_4LoopEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander17setIVIncInsertPosEPKNS_4LoopEPNS_11InstructionE")
  //</editor-fold>
  public void setIVIncInsertPos(/*const*/ Loop /*P*/ L, Instruction /*P*/ Pos) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Enable post-inc expansion for addrecs referring to the given
  /// loops. Post-inc expansion is only supported in non-canonical mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::setPostInc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 241,
   FQN="llvm::SCEVExpander::setPostInc", NM="_ZN4llvm12SCEVExpander10setPostIncERKNS_11SmallPtrSetIPKNS_4LoopELj2EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander10setPostIncERKNS_11SmallPtrSetIPKNS_4LoopELj2EEE")
  //</editor-fold>
  public void setPostInc(final /*const*/SmallPtrSet</*const*/ Loop /*P*/ > /*&*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Disable all post-inc expansion.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::clearPostInc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 248,
   FQN="llvm::SCEVExpander::clearPostInc", NM="_ZN4llvm12SCEVExpander12clearPostIncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander12clearPostIncEv")
  //</editor-fold>
  public void clearPostInc() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Disable the behavior of expanding expressions in canonical form
  /// rather than in a more literal form. Non-canonical mode is useful for
  /// late optimization passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::disableCanonicalMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 259,
   FQN="llvm::SCEVExpander::disableCanonicalMode", NM="_ZN4llvm12SCEVExpander20disableCanonicalModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander20disableCanonicalModeEv")
  //</editor-fold>
  public void disableCanonicalMode() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::enableLSRMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 261,
   FQN="llvm::SCEVExpander::enableLSRMode", NM="_ZN4llvm12SCEVExpander13enableLSRModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13enableLSRModeEv")
  //</editor-fold>
  public void enableLSRMode() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Set the current insertion point. This is useful if multiple calls
  /// to expandCodeFor() are going to be made with the same insert point and
  /// the insert point may be moved during one of the expansions (e.g. if the
  /// insert point is not a block terminator).
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::setInsertPoint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 267,
   FQN="llvm::SCEVExpander::setInsertPoint", NM="_ZN4llvm12SCEVExpander14setInsertPointEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander14setInsertPointEPNS_11InstructionE")
  //</editor-fold>
  public void setInsertPoint(Instruction /*P*/ IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Clear the current insertion point. This is useful if the
  /// instruction that had been serving as the insertion point may have been
  /// deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::clearInsertPoint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 275,
   FQN="llvm::SCEVExpander::clearInsertPoint", NM="_ZN4llvm12SCEVExpander16clearInsertPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander16clearInsertPointEv")
  //</editor-fold>
  public void clearInsertPoint() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return true if the specified instruction was inserted by the code
  /// rewriter.  If so, the client should not modify the instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::isInsertedInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 281,
   FQN="llvm::SCEVExpander::isInsertedInstruction", NM="_ZNK4llvm12SCEVExpander21isInsertedInstructionEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVExpander21isInsertedInstructionEPNS_11InstructionE")
  //</editor-fold>
  public boolean isInsertedInstruction(Instruction /*P*/ I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::setChainedPhi">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 285,
   FQN="llvm::SCEVExpander::setChainedPhi", NM="_ZN4llvm12SCEVExpander13setChainedPhiEPNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13setChainedPhiEPNS_7PHINodeE")
  //</editor-fold>
  public void setChainedPhi(PHINode /*P*/ PN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Try to find LLVM IR value for S available at the point At.
  ///
  /// L is a hint which tells in which loop to look for the suitable value.
  /// On success return value which is equivalent to the expanded S at point
  /// At. Return nullptr if value was not found.
  ///
  /// Note that this function does not perform an exhaustive search. I.e if it
  /// didn't find any value it does not mean that there is no such value.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::findExistingExpansion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1890,
   FQN="llvm::SCEVExpander::findExistingExpansion", NM="_ZN4llvm12SCEVExpander21findExistingExpansionEPKNS_4SCEVEPKNS_11InstructionEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander21findExistingExpansionEPKNS_4SCEVEPKNS_11InstructionEPNS_4LoopE")
  //</editor-fold>
  public Value /*P*/ findExistingExpansion(/*const*/ SCEV /*P*/ S, 
                       /*const*/ Instruction /*P*/ At, Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::getContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 298,
   FQN="llvm::SCEVExpander::getContext", NM="_ZNK4llvm12SCEVExpander10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZNK4llvm12SCEVExpander10getContextEv")
  //</editor-fold>
  private LLVMContext /*&*/ getContext() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Recursive helper function for isHighCostExpansion.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::isHighCostExpansionHelper">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1927,
   FQN="llvm::SCEVExpander::isHighCostExpansionHelper", NM="_ZN4llvm12SCEVExpander25isHighCostExpansionHelperEPKNS_4SCEVEPNS_4LoopEPKNS_11InstructionERNS_15SmallPtrSetImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander25isHighCostExpansionHelperEPKNS_4SCEVEPNS_4LoopEPKNS_11InstructionERNS_15SmallPtrSetImplIS3_EE")
  //</editor-fold>
  private boolean isHighCostExpansionHelper(/*const*/ SCEV /*P*/ S, Loop /*P*/ L, /*const*/ Instruction /*P*/ At, 
                           final SmallPtrSetImpl</*const*/ SCEV /*P*/ > /*&*/ Processed) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Insert the specified binary operator, doing a small amount
  /// of work to avoid inserting an obviously redundant operation.
  
  /// InsertBinop - Insert the specified binary operator, doing a small amount
  /// of work to avoid inserting an obviously redundant operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::InsertBinop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 171,
   FQN="llvm::SCEVExpander::InsertBinop", NM="_ZN4llvm12SCEVExpander11InsertBinopENS_11Instruction9BinaryOpsEPNS_5ValueES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander11InsertBinopENS_11Instruction9BinaryOpsEPNS_5ValueES4_")
  //</editor-fold>
  private Value /*P*/ InsertBinop(Instruction.BinaryOps Opcode, 
             Value /*P*/ LHS, Value /*P*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Arrange for there to be a cast of V to Ty at IP, reusing an
  /// existing cast if a suitable one exists, moving an existing cast if a
  /// suitable one exists but isn't in the right place, or or creating a new
  /// one.
  
  /// ReuseOrCreateCast - Arrange for there to be a cast of V to Ty at IP,
  /// reusing an existing cast if a suitable one exists, moving an existing
  /// cast if a suitable one exists but isn't in the right place, or
  /// creating a new one.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::ReuseOrCreateCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 38,
   FQN="llvm::SCEVExpander::ReuseOrCreateCast", NM="_ZN4llvm12SCEVExpander17ReuseOrCreateCastEPNS_5ValueEPNS_4TypeENS_11Instruction7CastOpsENS_14ilist_iteratorIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander17ReuseOrCreateCastEPNS_5ValueEPNS_4TypeENS_11Instruction7CastOpsENS_14ilist_iteratorIS5_EE")
  //</editor-fold>
  private Value /*P*/ ReuseOrCreateCast(Value /*P*/ V, Type /*P*/ Ty, 
                   Instruction.CastOps Op, 
                   ilist_iterator<Instruction> IP) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Insert a cast of V to the specified type, which must be possible
  /// with a noop cast, doing what we can to share the casts.
  
  /// InsertNoopCastOfTo - Insert a cast of V to the specified type,
  /// which must be possible with a noop cast, doing what we can to share
  /// the casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::InsertNoopCastOfTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 112,
   FQN="llvm::SCEVExpander::InsertNoopCastOfTo", NM="_ZN4llvm12SCEVExpander18InsertNoopCastOfToEPNS_5ValueEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander18InsertNoopCastOfToEPNS_5ValueEPNS_4TypeE")
  //</editor-fold>
  private Value /*P*/ InsertNoopCastOfTo(Value /*P*/ V, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Expand a SCEVAddExpr with a pointer type into a GEP
  /// instead of using ptrtoint+arithmetic+inttoptr.
  
  /// expandAddToGEP - Expand an addition expression with a pointer type into
  /// a GEP instead of using ptrtoint+arithmetic+inttoptr. This helps
  /// BasicAliasAnalysis and other passes analyze the result. See the rules
  /// for getelementptr vs. inttoptr in
  /// http://llvm.org/docs/LangRef.html#pointeraliasing
  /// for details.
  ///
  /// Design note: The correctness of using getelementptr here depends on
  /// ScalarEvolution not recognizing inttoptr and ptrtoint operators, as
  /// they may introduce pointer arithmetic which may not be safely converted
  /// into getelementptr.
  ///
  /// Design note: It might seem desirable for this function to be more
  /// loop-aware. If some of the indices are loop-invariant while others
  /// aren't, it might seem desirable to emit multiple GEPs, keeping the
  /// loop-invariant portions of the overall computation outside the loop.
  /// However, there are a few reasons this is not done here. Hoisting simple
  /// arithmetic is a low-level optimization that often isn't very
  /// important until late in the optimization process. In fact, passes
  /// like InstructionCombining will combine GEPs, even if it means
  /// pushing loop-invariant computation down into loops, so even if the
  /// GEPs were split here, the work would quickly be undone. The
  /// LoopStrengthReduction pass, which is usually run quite late (and
  /// after the last InstructionCombining pass), takes care of hoisting
  /// loop-invariant portions of expressions, after considering what
  /// can be folded using target addressing modes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandAddToGEP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 385,
   FQN="llvm::SCEVExpander::expandAddToGEP", NM="_ZN4llvm12SCEVExpander14expandAddToGEPEPKPKNS_4SCEVES5_PNS_11PointerTypeEPNS_4TypeEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander14expandAddToGEPEPKPKNS_4SCEVES5_PNS_11PointerTypeEPNS_4TypeEPNS_5ValueE")
  //</editor-fold>
  private Value /*P*/ expandAddToGEP(type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> op_begin, 
                type$ptr</*const*/ SCEV /*P*/ /*const*/ /*P*/> op_end, 
                PointerType /*P*/ PTy, 
                Type /*P*/ Ty, 
                Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Find a previous Value in ExprValueMap for expand.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::FindValueInExprValueMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1628,
   FQN="llvm::SCEVExpander::FindValueInExprValueMap", NM="_ZN4llvm12SCEVExpander23FindValueInExprValueMapEPKNS_4SCEVEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander23FindValueInExprValueMapEPKNS_4SCEVEPKNS_11InstructionE")
  //</editor-fold>
  private Value /*P*/ FindValueInExprValueMap(/*const*/ SCEV /*P*/ S, 
                         /*const*/ Instruction /*P*/ InsertPt) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  // The expansion of SCEV will either reuse a previous Value in ExprValueMap,
  // or expand the SCEV literally. Specifically, if the expansion is in LSRMode,
  // and the SCEV contains any sub scAddRecExpr type SCEV, it will be expanded
  // literally, to prevent LSR's transformed SCEV from being reverted. Otherwise,
  // the expansion will try to reuse Value from ExprValueMap, and only when it
  // fails, expand the SCEV literally.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1662,
   FQN="llvm::SCEVExpander::expand", NM="_ZN4llvm12SCEVExpander6expandEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander6expandEPKNS_4SCEVE")
  //</editor-fold>
  private Value /*P*/ expand(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Determine the most "relevant" loop for the given SCEV.
  
  /// getRelevantLoop - Get the most relevant loop associated with the given
  /// expression, according to PickMostRelevantLoop.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::getRelevantLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 596,
   FQN="llvm::SCEVExpander::getRelevantLoop", NM="_ZN4llvm12SCEVExpander15getRelevantLoopEPKNS_4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander15getRelevantLoopEPKNS_4SCEVE")
  //</editor-fold>
  private /*const*/ Loop /*P*/ getRelevantLoop(/*const*/ SCEV /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 335,
   FQN="llvm::SCEVExpander::visitConstant", NM="_ZN4llvm12SCEVExpander13visitConstantEPKNS_12SCEVConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13visitConstantEPKNS_12SCEVConstantE")
  //</editor-fold>
  private Value /*P*/ visitConstant(/*const*/ SCEVConstant /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitTruncateExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1536,
   FQN="llvm::SCEVExpander::visitTruncateExpr", NM="_ZN4llvm12SCEVExpander17visitTruncateExprEPKNS_16SCEVTruncateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander17visitTruncateExprEPKNS_16SCEVTruncateExprE")
  //</editor-fold>
  private Value /*P*/ visitTruncateExpr(/*const*/ SCEVTruncateExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitZeroExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1545,
   FQN="llvm::SCEVExpander::visitZeroExtendExpr", NM="_ZN4llvm12SCEVExpander19visitZeroExtendExprEPKNS_18SCEVZeroExtendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander19visitZeroExtendExprEPKNS_18SCEVZeroExtendExprE")
  //</editor-fold>
  private Value /*P*/ visitZeroExtendExpr(/*const*/ SCEVZeroExtendExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitSignExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1554,
   FQN="llvm::SCEVExpander::visitSignExtendExpr", NM="_ZN4llvm12SCEVExpander19visitSignExtendExprEPKNS_18SCEVSignExtendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander19visitSignExtendExprEPKNS_18SCEVSignExtendExprE")
  //</editor-fold>
  private Value /*P*/ visitSignExtendExpr(/*const*/ SCEVSignExtendExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitAddExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 666,
   FQN="llvm::SCEVExpander::visitAddExpr", NM="_ZN4llvm12SCEVExpander12visitAddExprEPKNS_11SCEVAddExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander12visitAddExprEPKNS_11SCEVAddExprE")
  //</editor-fold>
  private Value /*P*/ visitAddExpr(/*const*/ SCEVAddExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitMulExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 736,
   FQN="llvm::SCEVExpander::visitMulExpr", NM="_ZN4llvm12SCEVExpander12visitMulExprEPKNS_11SCEVMulExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander12visitMulExprEPKNS_11SCEVMulExprE")
  //</editor-fold>
  private Value /*P*/ visitMulExpr(/*const*/ SCEVMulExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitUDivExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 782,
   FQN="llvm::SCEVExpander::visitUDivExpr", NM="_ZN4llvm12SCEVExpander13visitUDivExprEPKNS_12SCEVUDivExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13visitUDivExprEPKNS_12SCEVUDivExprE")
  //</editor-fold>
  private Value /*P*/ visitUDivExpr(/*const*/ SCEVUDivExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1398,
   FQN="llvm::SCEVExpander::visitAddRecExpr", NM="_ZN4llvm12SCEVExpander15visitAddRecExprEPKNS_14SCEVAddRecExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander15visitAddRecExprEPKNS_14SCEVAddRecExprE")
  //</editor-fold>
  private Value /*P*/ visitAddRecExpr(/*const*/ SCEVAddRecExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitSMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1563,
   FQN="llvm::SCEVExpander::visitSMaxExpr", NM="_ZN4llvm12SCEVExpander13visitSMaxExprEPKNS_12SCEVSMaxExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13visitSMaxExprEPKNS_12SCEVSMaxExprE")
  //</editor-fold>
  private Value /*P*/ visitSMaxExpr(/*const*/ SCEVSMaxExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitUMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1587,
   FQN="llvm::SCEVExpander::visitUMaxExpr", NM="_ZN4llvm12SCEVExpander13visitUMaxExprEPKNS_12SCEVUMaxExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander13visitUMaxExprEPKNS_12SCEVUMaxExprE")
  //</editor-fold>
  private Value /*P*/ visitUMaxExpr(/*const*/ SCEVUMaxExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::visitUnknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpander.h", line = 357,
   FQN="llvm::SCEVExpander::visitUnknown", NM="_ZN4llvm12SCEVExpander12visitUnknownEPKNS_11SCEVUnknownE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander12visitUnknownEPKNS_11SCEVUnknownE")
  //</editor-fold>
  private Value /*P*/ visitUnknown(/*const*/ SCEVUnknown /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::rememberInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1716,
   FQN="llvm::SCEVExpander::rememberInstruction", NM="_ZN4llvm12SCEVExpander19rememberInstructionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander19rememberInstructionEPNS_5ValueE")
  //</editor-fold>
  private void rememberInstruction(Value /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Determine if this is a well-behaved chain of instructions leading back to
  /// the PHI. If so, it may be reused by expanded expressions.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::isNormalAddRecExprPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 821,
   FQN="llvm::SCEVExpander::isNormalAddRecExprPHI", NM="_ZN4llvm12SCEVExpander21isNormalAddRecExprPHIEPNS_7PHINodeEPNS_11InstructionEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander21isNormalAddRecExprPHIEPNS_7PHINodeEPNS_11InstructionEPKNS_4LoopE")
  //</editor-fold>
  private boolean isNormalAddRecExprPHI(PHINode /*P*/ PN, Instruction /*P*/ IncV, 
                       /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Determine if this cyclic phi is in a form that would have been generated by
  /// LSR. We don't care if the phi was actually expanded in this pass, as long
  /// as it is in a low-cost form, for example, no implied multiplication. This
  /// should match any patterns generated by getAddRecExprPHILiterally and
  /// expandAddtoGEP.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::isExpandedAddRecExprPHI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 963,
   FQN="llvm::SCEVExpander::isExpandedAddRecExprPHI", NM="_ZN4llvm12SCEVExpander23isExpandedAddRecExprPHIEPNS_7PHINodeEPNS_11InstructionEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander23isExpandedAddRecExprPHIEPNS_7PHINodeEPNS_11InstructionEPKNS_4LoopE")
  //</editor-fold>
  private boolean isExpandedAddRecExprPHI(PHINode /*P*/ PN, Instruction /*P*/ IncV, 
                         /*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandAddRecExprLiterally">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1258,
   FQN="llvm::SCEVExpander::expandAddRecExprLiterally", NM="_ZN4llvm12SCEVExpander25expandAddRecExprLiterallyEPKNS_14SCEVAddRecExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander25expandAddRecExprLiterallyEPKNS_14SCEVAddRecExprE")
  //</editor-fold>
  private Value /*P*/ expandAddRecExprLiterally(/*const*/ SCEVAddRecExpr /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getAddRecExprPHILiterally - Helper for expandAddRecExprLiterally. Expand
  /// the base addrec, which is the addrec without any non-loop-dominating
  /// values, and return the PHI.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::getAddRecExprPHILiterally">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1084,
   FQN="llvm::SCEVExpander::getAddRecExprPHILiterally", NM="_ZN4llvm12SCEVExpander25getAddRecExprPHILiterallyEPKNS_14SCEVAddRecExprEPKNS_4LoopEPNS_4TypeES8_RS8_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander25getAddRecExprPHILiterallyEPKNS_14SCEVAddRecExprEPKNS_4LoopEPNS_4TypeES8_RS8_Rb")
  //</editor-fold>
  private PHINode /*P*/ getAddRecExprPHILiterally(/*const*/ SCEVAddRecExpr /*P*/ Normalized, 
                           /*const*/ Loop /*P*/ L, 
                           Type /*P*/ ExpandTy, 
                           Type /*P*/ IntTy, 
                           final type$ref<Type /*P*/ /*&*/> TruncTy, 
                           final bool$ref/*bool &*/ InvertStep) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// expandIVInc - Expand an IV increment at Builder's current InsertPos.
  /// Typically this is the LatchBlock terminator or IVIncInsertPos, but we may
  /// need to materialize IV increments elsewhere to handle difficult situations.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::expandIVInc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 977,
   FQN="llvm::SCEVExpander::expandIVInc", NM="_ZN4llvm12SCEVExpander11expandIVIncEPNS_7PHINodeEPNS_5ValueEPKNS_4LoopEPNS_4TypeES9_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander11expandIVIncEPNS_7PHINodeEPNS_5ValueEPKNS_4LoopEPNS_4TypeES9_b")
  //</editor-fold>
  private Value /*P*/ expandIVInc(PHINode /*P*/ PN, Value /*P*/ StepV, /*const*/ Loop /*P*/ L, 
             Type /*P*/ ExpandTy, Type /*P*/ IntTy, 
             boolean useSubtract) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// \brief Hoist the addrec instruction chain rooted in the loop phi above the
  /// position. This routine assumes that this is possible (has been checked).
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::hoistBeforePos">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 1006,
   FQN="llvm::SCEVExpander::hoistBeforePos", NM="_ZN4llvm12SCEVExpander14hoistBeforePosEPNS_13DominatorTreeEPNS_11InstructionES4_PNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander14hoistBeforePosEPNS_13DominatorTreeEPNS_11InstructionES4_PNS_7PHINodeE")
  //</editor-fold>
  private void hoistBeforePos(DominatorTree /*P*/ DT, Instruction /*P*/ InstToHoist, 
                Instruction /*P*/ Pos, PHINode /*P*/ LoopPhi) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// If the insert point of the current builder or any of the builders on the
  /// stack of saved builders has 'I' as its insert point, update it to point to
  /// the instruction after 'I'.  This is intended to be used when the instruction
  /// 'I' is being moved.  If this fixup is not done and 'I' is moved to a
  /// different block, the inconsistent insert point (with a mismatched
  /// Instruction and Block) can lead to an instruction being inserted in a block
  /// other than its parent.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVExpander::fixupInsertPoints">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 913,
   FQN="llvm::SCEVExpander::fixupInsertPoints", NM="_ZN4llvm12SCEVExpander17fixupInsertPointsEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm12SCEVExpander17fixupInsertPointsEPNS_11InstructionE")
  //</editor-fold>
  private void fixupInsertPoints(Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "SE=" + SE // NOI18N
              + ", DL=" + DL // NOI18N
              + ", IVName=" + IVName // NOI18N
              + ", InsertedExpressions=" + InsertedExpressions // NOI18N
              + ", InsertedValues=" + InsertedValues // NOI18N
              + ", InsertedPostIncValues=" + InsertedPostIncValues // NOI18N
              + ", RelevantLoops=" + RelevantLoops // NOI18N
              + ", PostIncLoops=" + PostIncLoops // NOI18N
              + ", IVIncInsertLoop=" + IVIncInsertLoop // NOI18N
              + ", IVIncInsertPos=" + IVIncInsertPos // NOI18N
              + ", ChainedPhis=" + ChainedPhis // NOI18N
              + ", CanonicalMode=" + CanonicalMode // NOI18N
              + ", LSRMode=" + LSRMode // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", InsertPointGuards=" + InsertPointGuards // NOI18N
              + ", DebugType=" + DebugType // NOI18N
              + super.toString(); // NOI18N
  }
}
