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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.ir.*;


/// FullDependence - This class represents a dependence between two memory
/// references in a function. It contains detailed information about the
/// dependence (direction vectors, etc.) and is used when the compiler is
/// able to accurately analyze the interaction of the references; that is,
/// it is not a confused dependence (see Dependence). In most cases
/// (for output, flow, and anti dependences), the dependence implies an
/// ordering, where the source must precede the destination; in contrast,
/// input dependences are unordered.
//<editor-fold defaultstate="collapsed" desc="llvm::FullDependence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 220,
 FQN="llvm::FullDependence", NM="_ZN4llvm14FullDependenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14FullDependenceE")
//</editor-fold>
public final class FullDependence extends /*public*/ Dependence implements Destructors.ClassWithDestructor {
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // FullDependence methods
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::FullDependence">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 236,
   FQN="llvm::FullDependence::FullDependence", NM="_ZN4llvm14FullDependenceC1EPNS_11InstructionES2_bj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14FullDependenceC1EPNS_11InstructionES2_bj")
  //</editor-fold>
  public FullDependence(Instruction /*P*/ Source, Instruction /*P*/ Destination, 
      boolean PossiblyLoopIndependent, 
      /*uint*/int CommonLevels) {
    // : Dependence(Source, Destination), Levels(CommonLevels), LoopIndependent(PossiblyLoopIndependent), DV() 
    //START JInit
    super(Source, Destination);
    this.Levels = $uint2ushort(CommonLevels);
    this.LoopIndependent = PossiblyLoopIndependent;
    this.DV = new unique_ptr_array<Dependence.DVEntry>();
    //END JInit
    Consistent = true;
    if ((CommonLevels != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(DV.$assignMove($c$.track(llvm.make_unique(new Dependence.DVEntry[CommonLevels]))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::FullDependence">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 225,
   FQN="llvm::FullDependence::FullDependence", NM="_ZN4llvm14FullDependenceC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14FullDependenceC1EOS0_")
  //</editor-fold>
  public FullDependence(JD$Move _dparam, final FullDependence /*&&*/RHS) {
    // : Dependence(std::move(RHS)), Levels(RHS.Levels), LoopIndependent(RHS.LoopIndependent), Consistent(RHS.Consistent), DV(std::move(RHS.DV)) 
    //START JInit
    super(std.move(RHS));
    this.Levels = RHS.Levels;
    this.LoopIndependent = RHS.LoopIndependent;
    this.Consistent = RHS.Consistent;
    this.DV = new unique_ptr_array<Dependence.DVEntry>(JD$Move.INSTANCE, std.move(RHS.DV));
    //END JInit
  }

  
  /// isLoopIndependent - Returns true if this is a loop-independent
  /// dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isLoopIndependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 232,
   FQN="llvm::FullDependence::isLoopIndependent", NM="_ZNK4llvm14FullDependence17isLoopIndependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence17isLoopIndependentEv")
  //</editor-fold>
  @Override public boolean isLoopIndependent() /*const*//* override*/ {
    return LoopIndependent;
  }

  
  /// isConfused - Returns true if this dependence is confused
  /// (the compiler understands nothing and makes worst-case
  /// assumptions).
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isConfused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 237,
   FQN="llvm::FullDependence::isConfused", NM="_ZNK4llvm14FullDependence10isConfusedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence10isConfusedEv")
  //</editor-fold>
  @Override public boolean isConfused() /*const*//* override*/ {
    return false;
  }

  
  /// isConsistent - Returns true if this dependence is consistent
  /// (occurs every time the source and destination are executed).
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isConsistent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 241,
   FQN="llvm::FullDependence::isConsistent", NM="_ZNK4llvm14FullDependence12isConsistentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence12isConsistentEv")
  //</editor-fold>
  @Override public boolean isConsistent() /*const*//* override*/ {
    return Consistent;
  }

  
  /// getLevels - Returns the number of common loops surrounding the
  /// source and destination of the dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::getLevels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 245,
   FQN="llvm::FullDependence::getLevels", NM="_ZNK4llvm14FullDependence9getLevelsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence9getLevelsEv")
  //</editor-fold>
  @Override public /*uint*/int getLevels() /*const*//* override*/ {
    return $ushort2uint(Levels);
  }

  
  /// getDirection - Returns the direction associated with a particular
  /// level.
  
  // The rest are simple getters that hide the implementation.
  
  // getDirection - Returns the direction associated with a particular level.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::getDirection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 249,
   FQN="llvm::FullDependence::getDirection", NM="_ZNK4llvm14FullDependence12getDirectionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence12getDirectionEj")
  //</editor-fold>
  @Override public /*uint*/int getDirection(/*uint*/int Level) /*const*//* override*/ {
    assert ($less_uint(0, Level) && $lesseq_uint_char$C(Level, Levels)) : "Level out of range";
    return $uchar2uint($3bits_uchar2uchar(DV.$at(Level - 1).Direction));
  }

  
  /// getDistance - Returns the distance (or NULL) associated with a
  /// particular level.
  
  // Returns the distance (or NULL) associated with a particular level.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::getDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 256,
   FQN="llvm::FullDependence::getDistance", NM="_ZNK4llvm14FullDependence11getDistanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence11getDistanceEj")
  //</editor-fold>
  @Override public /*const*/ SCEV /*P*/ getDistance(/*uint*/int Level) /*const*//* override*/ {
    assert ($less_uint(0, Level) && $lesseq_uint_char$C(Level, Levels)) : "Level out of range";
    return DV.$at(Level - 1).Distance;
  }

  
  /// isPeelFirst - Returns true if peeling the first iteration from
  /// this loop will break this dependence.
  
  // Returns true if peeling the first iteration from this loop
  // will break this dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isPeelFirst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 273,
   FQN="llvm::FullDependence::isPeelFirst", NM="_ZNK4llvm14FullDependence11isPeelFirstEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence11isPeelFirstEj")
  //</editor-fold>
  @Override public boolean isPeelFirst(/*uint*/int Level) /*const*//* override*/ {
    assert ($less_uint(0, Level) && $lesseq_uint_char$C(Level, Levels)) : "Level out of range";
    return DV.$at(Level - 1).PeelFirst;
  }

  
  /// isPeelLast - Returns true if peeling the last iteration from
  /// this loop will break this dependence.
  
  // Returns true if peeling the last iteration from this loop
  // will break this dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isPeelLast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 281,
   FQN="llvm::FullDependence::isPeelLast", NM="_ZNK4llvm14FullDependence10isPeelLastEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence10isPeelLastEj")
  //</editor-fold>
  @Override public boolean isPeelLast(/*uint*/int Level) /*const*//* override*/ {
    assert ($less_uint(0, Level) && $lesseq_uint_char$C(Level, Levels)) : "Level out of range";
    return DV.$at(Level - 1).PeelLast;
  }

  
  /// isSplitable - Returns true if splitting the loop will break
  /// the dependence.
  
  // Returns true if splitting this loop will break the dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isSplitable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 288,
   FQN="llvm::FullDependence::isSplitable", NM="_ZNK4llvm14FullDependence11isSplitableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence11isSplitableEj")
  //</editor-fold>
  @Override public boolean isSplitable(/*uint*/int Level) /*const*//* override*/ {
    assert ($less_uint(0, Level) && $lesseq_uint_char$C(Level, Levels)) : "Level out of range";
    return DV.$at(Level - 1).Splitable;
  }

  
  /// isScalar - Returns true if a particular level is scalar; that is,
  /// if no subscript in the source or destination mention the induction
  /// variable associated with the loop at this level.
  
  // Returns true if a particular level is scalar; that is,
  // if no subscript in the source or destination mention the induction
  // variable associated with the loop at this level.
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::isScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 265,
   FQN="llvm::FullDependence::isScalar", NM="_ZNK4llvm14FullDependence8isScalarEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm14FullDependence8isScalarEj")
  //</editor-fold>
  @Override public boolean isScalar(/*uint*/int Level) /*const*//* override*/ {
    assert ($less_uint(0, Level) && $lesseq_uint_char$C(Level, Levels)) : "Level out of range";
    return DV.$at(Level - 1).Scalar;
  }

/*private:*/
  private /*ushort*/char Levels;
  /*friend*/public/*private*/ boolean LoopIndependent;
  /*friend*/public/*private*/ boolean Consistent; // Init to true, then refine.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  /*friend*/public/*private*/ unique_ptr_array<Dependence.DVEntry> DV;
  /*friend  class DependenceInfo*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FullDependence::~FullDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 220,
   FQN="llvm::FullDependence::~FullDependence", NM="_ZN4llvm14FullDependenceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm14FullDependenceD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DV.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public bool$ref Consistent_ref = new bool$ref(){
    @Override
    public boolean $deref() {
      return Consistent;
    }
  
    @Override
    public boolean $set(boolean value) {
      Consistent = value;
      return Consistent;
    }
  };
  
  public FullDependence(FullDependence Other) {
    super(Other);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Levels=" + $ushort2uint(Levels) // NOI18N
              + ", LoopIndependent=" + LoopIndependent // NOI18N
              + ", Consistent=" + Consistent // NOI18N
              + ", DV=" + DV // NOI18N
              + super.toString(); // NOI18N
  }
}
