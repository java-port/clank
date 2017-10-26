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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.analysis.impl.*;


/// Dependence - This class represents a dependence between two memory
/// memory references in a function. It contains minimal information and
/// is used in the very common situation where the compiler is unable to
/// determine anything beyond the existence of a dependence; that is, it
/// represents a confused dependence (see also FullDependence). In most
/// cases (for output, flow, and anti dependences), the dependence implies
/// an ordering, where the source must precede the destination; in contrast,
/// input dependences are unordered.
///
/// When a dependence graph is built, each Dependence will be a member of
/// the set of predecessor edges for its destination instruction and a set
/// if successor edges for its source instruction. These sets are represented
/// as singly-linked lists, with the "next" fields stored in the dependence
/// itelf.
//<editor-fold defaultstate="collapsed" desc="llvm::Dependence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 71,
 FQN="llvm::Dependence", NM="_ZN4llvm10DependenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10DependenceE")
//</editor-fold>
public class Dependence implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::Dependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 73,
   FQN="llvm::Dependence::Dependence", NM="_ZN4llvm10DependenceC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10DependenceC1ERKS0_")
  //</editor-fold>
  protected Dependence(final /*const*/ Dependence /*&*/ $Prm0) {
    // : Src(.Src), Dst(.Dst), NextPredecessor(.NextPredecessor), NextSuccessor(.NextSuccessor)/* = default*/ 
    //START JInit
    this.Src = $Prm0.Src;
    this.Dst = $Prm0.Dst;
    this.NextPredecessor = $Prm0.NextPredecessor;
    this.NextSuccessor = $Prm0.NextSuccessor;
    //END JInit
  }


  // FIXME: When we move to MSVC 2015 as the base compiler for Visual Studio
  // support, uncomment this line to allow a defaulted move constructor for
  // Dependence. Currently, FullDependence relies on the copy constructor, but
  // that is acceptable given the triviality of the class.
  // Dependence(Dependence &&) = default;
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::Dependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 82,
   FQN="llvm::Dependence::Dependence", NM="_ZN4llvm10DependenceC1EPNS_11InstructionES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10DependenceC1EPNS_11InstructionES2_")
  //</editor-fold>
  public Dependence(Instruction /*P*/ Source, 
      Instruction /*P*/ Destination) {
    // : Src(Source), Dst(Destination), NextPredecessor(null), NextSuccessor(null) 
    //START JInit
    this.Src = Source;
    this.Dst = Destination;
    this.NextPredecessor = null;
    this.NextSuccessor = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::~Dependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 88,
   FQN="llvm::Dependence::~Dependence", NM="_ZN4llvm10DependenceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10DependenceD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// Dependence::DVEntry - Each level in the distance/direction vector
  /// has a direction (or perhaps a union of several directions), and
  /// perhaps a distance.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::DVEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 93,
   FQN="llvm::Dependence::DVEntry", NM="_ZN4llvm10Dependence7DVEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10Dependence7DVEntryE")
  //</editor-fold>
  public static class/*struct*/ DVEntry {
    //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::DVEntry::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 94,
     FQN="llvm::Dependence::DVEntry::(anonymous)", NM="_ZN4llvm10Dependence7DVEntryE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10Dependence7DVEntryE_Unnamed_enum")
    //</editor-fold>
    public enum Unnamed_enum implements Native.NativeUIntEnum {
      NONE(0),
      LT(1),
      EQ(2),
      LE(3),
      GT(4),
      NE(5),
      GE(6),
      ALL(7);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Unnamed_enum valueOf(int val) {
        Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Unnamed_enum[] VALUES;
        private static final Unnamed_enum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
          VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    public /*JBYTE unsigned char*/ byte Direction /*: 3*/; // Init to ALL, then refine.
    public /*JBIT bool*/ boolean Scalar /*: 1*/; // Init to true.
    public /*JBIT bool*/ boolean PeelFirst /*: 1*/; // Peeling the first iteration will break dependence.
    public /*JBIT bool*/ boolean PeelLast /*: 1*/; // Peeling the last iteration will break the dependence.
    public /*JBIT bool*/ boolean Splitable /*: 1*/; // Splitting the loop will break dependence.
    public /*const*/ SCEV /*P*/ Distance; // NULL implies no distance available.
    //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::DVEntry::DVEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 108,
     FQN="llvm::Dependence::DVEntry::DVEntry", NM="_ZN4llvm10Dependence7DVEntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10Dependence7DVEntryC1Ev")
    //</editor-fold>
    public DVEntry() {
      // : Direction(ALL), Scalar(true), PeelFirst(false), PeelLast(false), Splitable(false), Distance(null) 
      //START JInit
      this.Direction = $uchar2uchar_3bits(Unnamed_enum.ALL.getValue());
      this.Scalar = true;
      this.PeelFirst = false;
      this.PeelLast = false;
      this.Splitable = false;
      this.Distance = null;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Direction=" + $uchar2uint(Direction) // NOI18N
                + ", Scalar=" + Scalar // NOI18N
                + ", PeelFirst=" + PeelFirst // NOI18N
                + ", PeelLast=" + PeelLast // NOI18N
                + ", Splitable=" + Splitable // NOI18N
                + ", Distance=" + Distance; // NOI18N
    }
  };
  
  /// getSrc - Returns the source instruction for this dependence.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getSrc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 114,
   FQN="llvm::Dependence::getSrc", NM="_ZNK4llvm10Dependence6getSrcEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence6getSrcEv")
  //</editor-fold>
  public Instruction /*P*/ getSrc() /*const*/ {
    return Src;
  }

  
  /// getDst - Returns the destination instruction for this dependence.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getDst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 118,
   FQN="llvm::Dependence::getDst", NM="_ZNK4llvm10Dependence6getDstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence6getDstEv")
  //</editor-fold>
  public Instruction /*P*/ getDst() /*const*/ {
    return Dst;
  }

  
  /// isInput - Returns true if this is an input dependence.
  ///
  
  //===----------------------------------------------------------------------===//
  // Dependence methods
  
  // Returns true if this is an input dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isInput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 201,
   FQN="llvm::Dependence::isInput", NM="_ZNK4llvm10Dependence7isInputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence7isInputEv")
  //</editor-fold>
  public boolean isInput() /*const*/ {
    return Src.mayReadFromMemory() && Dst.mayReadFromMemory();
  }

  
  /// isOutput - Returns true if this is an output dependence.
  ///
  
  // Returns true if this is an output dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isOutput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 207,
   FQN="llvm::Dependence::isOutput", NM="_ZNK4llvm10Dependence8isOutputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence8isOutputEv")
  //</editor-fold>
  public boolean isOutput() /*const*/ {
    return Src.mayWriteToMemory() && Dst.mayWriteToMemory();
  }

  
  /// isFlow - Returns true if this is a flow (aka true) dependence.
  ///
  
  // Returns true if this is an flow (aka true)  dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isFlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 213,
   FQN="llvm::Dependence::isFlow", NM="_ZNK4llvm10Dependence6isFlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence6isFlowEv")
  //</editor-fold>
  public boolean isFlow() /*const*/ {
    return Src.mayWriteToMemory() && Dst.mayReadFromMemory();
  }

  
  /// isAnti - Returns true if this is an anti dependence.
  ///
  
  // Returns true if this is an anti dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isAnti">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 219,
   FQN="llvm::Dependence::isAnti", NM="_ZNK4llvm10Dependence6isAntiEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence6isAntiEv")
  //</editor-fold>
  public boolean isAnti() /*const*/ {
    return Src.mayReadFromMemory() && Dst.mayWriteToMemory();
  }

  
  /// isOrdered - Returns true if dependence is Output, Flow, or Anti
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isOrdered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 138,
   FQN="llvm::Dependence::isOrdered", NM="_ZNK4llvm10Dependence9isOrderedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence9isOrderedEv")
  //</editor-fold>
  public boolean isOrdered() /*const*/ {
    return isOutput() || isFlow() || isAnti();
  }

  
  /// isUnordered - Returns true if dependence is Input
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isUnordered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 142,
   FQN="llvm::Dependence::isUnordered", NM="_ZNK4llvm10Dependence11isUnorderedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence11isUnorderedEv")
  //</editor-fold>
  public boolean isUnordered() /*const*/ {
    return isInput();
  }

  
  /// isLoopIndependent - Returns true if this is a loop-independent
  /// dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isLoopIndependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 146,
   FQN="llvm::Dependence::isLoopIndependent", NM="_ZNK4llvm10Dependence17isLoopIndependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence17isLoopIndependentEv")
  //</editor-fold>
  public /*virtual*/ boolean isLoopIndependent() /*const*/ {
    return true;
  }

  
  /// isConfused - Returns true if this dependence is confused
  /// (the compiler understands nothing and makes worst-case
  /// assumptions).
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isConfused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 151,
   FQN="llvm::Dependence::isConfused", NM="_ZNK4llvm10Dependence10isConfusedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence10isConfusedEv")
  //</editor-fold>
  public /*virtual*/ boolean isConfused() /*const*/ {
    return true;
  }

  
  /// isConsistent - Returns true if this dependence is consistent
  /// (occurs every time the source and destination are executed).
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isConsistent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 155,
   FQN="llvm::Dependence::isConsistent", NM="_ZNK4llvm10Dependence12isConsistentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence12isConsistentEv")
  //</editor-fold>
  public /*virtual*/ boolean isConsistent() /*const*/ {
    return false;
  }

  
  /// getLevels - Returns the number of common loops surrounding the
  /// source and destination of the dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getLevels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 159,
   FQN="llvm::Dependence::getLevels", NM="_ZNK4llvm10Dependence9getLevelsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence9getLevelsEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getLevels() /*const*/ {
    return 0;
  }

  
  /// getDirection - Returns the direction associated with a particular
  /// level.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getDirection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 163,
   FQN="llvm::Dependence::getDirection", NM="_ZNK4llvm10Dependence12getDirectionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence12getDirectionEj")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getDirection(/*uint*/int Level) /*const*/ {
    return DVEntry.Unnamed_enum.ALL.getValue();
  }

  
  /// getDistance - Returns the distance (or NULL) associated with a
  /// particular level.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 167,
   FQN="llvm::Dependence::getDistance", NM="_ZNK4llvm10Dependence11getDistanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence11getDistanceEj")
  //</editor-fold>
  public /*virtual*/ /*const*/ SCEV /*P*/ getDistance(/*uint*/int Level) /*const*/ {
    return null;
  }

  
  /// isPeelFirst - Returns true if peeling the first iteration from
  /// this loop will break this dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isPeelFirst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 171,
   FQN="llvm::Dependence::isPeelFirst", NM="_ZNK4llvm10Dependence11isPeelFirstEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence11isPeelFirstEj")
  //</editor-fold>
  public /*virtual*/ boolean isPeelFirst(/*uint*/int Level) /*const*/ {
    return false;
  }

  
  /// isPeelLast - Returns true if peeling the last iteration from
  /// this loop will break this dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isPeelLast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 175,
   FQN="llvm::Dependence::isPeelLast", NM="_ZNK4llvm10Dependence10isPeelLastEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence10isPeelLastEj")
  //</editor-fold>
  public /*virtual*/ boolean isPeelLast(/*uint*/int Level) /*const*/ {
    return false;
  }

  
  /// isSplitable - Returns true if splitting this loop will break
  /// the dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isSplitable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 179,
   FQN="llvm::Dependence::isSplitable", NM="_ZNK4llvm10Dependence11isSplitableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence11isSplitableEj")
  //</editor-fold>
  public /*virtual*/ boolean isSplitable(/*uint*/int Level) /*const*/ {
    return false;
  }

  
  /// isScalar - Returns true if a particular level is scalar; that is,
  /// if no subscript in the source or destination mention the induction
  /// variable associated with the loop at this level.
  
  // Returns true if a particular level is scalar; that is,
  // if no subscript in the source or destination mention the induction
  // variable associated with the loop at this level.
  // Leave this out of line, so it will serve as a virtual method anchor
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::isScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 228,
   FQN="llvm::Dependence::isScalar", NM="_ZNK4llvm10Dependence8isScalarEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence8isScalarEj")
  //</editor-fold>
  public boolean isScalar(/*uint*/int level) /*const*/ {
    return false;
  }

  
  /// getNextPredecessor - Returns the value of the NextPredecessor
  /// field.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getNextPredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 188,
   FQN="llvm::Dependence::getNextPredecessor", NM="_ZNK4llvm10Dependence18getNextPredecessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence18getNextPredecessorEv")
  //</editor-fold>
  public /*const*/ Dependence /*P*/ getNextPredecessor() /*const*/ {
    return NextPredecessor;
  }

  
  /// getNextSuccessor - Returns the value of the NextSuccessor
  /// field.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::getNextSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 192,
   FQN="llvm::Dependence::getNextSuccessor", NM="_ZNK4llvm10Dependence16getNextSuccessorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence16getNextSuccessorEv")
  //</editor-fold>
  public /*const*/ Dependence /*P*/ getNextSuccessor() /*const*/ {
    return NextSuccessor;
  }

  
  /// setNextPredecessor - Sets the value of the NextPredecessor
  /// field.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::setNextPredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 196,
   FQN="llvm::Dependence::setNextPredecessor", NM="_ZN4llvm10Dependence18setNextPredecessorEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10Dependence18setNextPredecessorEPKS0_")
  //</editor-fold>
  public void setNextPredecessor(/*const*/ Dependence /*P*/ pred) {
    NextPredecessor = pred;
  }

  
  /// setNextSuccessor - Sets the value of the NextSuccessor
  /// field.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::setNextSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DependenceAnalysis.h", line = 200,
   FQN="llvm::Dependence::setNextSuccessor", NM="_ZN4llvm10Dependence16setNextSuccessorEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm10Dependence16setNextSuccessorEPKS0_")
  //</editor-fold>
  public void setNextSuccessor(/*const*/ Dependence /*P*/ succ) {
    NextSuccessor = succ;
  }

  
  /// dump - For debugging purposes, dumps a dependence to OS.
  ///
  
  //===----------------------------------------------------------------------===//
  // DependenceInfo methods
  
  // For debugging purposes. Dumps a dependence to OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::Dependence::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 570,
   FQN="llvm::Dependence::dump", NM="_ZNK4llvm10Dependence4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZNK4llvm10Dependence4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    boolean Splitable = false;
    if (isConfused()) {
      OS.$out(/*KEEP_STR*/"confused");
    } else {
      if (isConsistent()) {
        OS.$out(/*KEEP_STR*/"consistent ");
      }
      if (isFlow()) {
        OS.$out(/*KEEP_STR*/"flow");
      } else if (isOutput()) {
        OS.$out(/*KEEP_STR*/"output");
      } else if (isAnti()) {
        OS.$out(/*KEEP_STR*/"anti");
      } else if (isInput()) {
        OS.$out(/*KEEP_STR*/"input");
      }
      /*uint*/int Levels = getLevels();
      OS.$out(/*KEEP_STR*/" [");
      for (/*uint*/int II = 1; $lesseq_uint(II, Levels); ++II) {
        if (isSplitable(II)) {
          Splitable = true;
        }
        if (isPeelFirst(II)) {
          OS.$out_char($$p);
        }
        /*const*/ SCEV /*P*/ Distance = getDistance(II);
        if ((Distance != null)) {
          ScalarEvolutionLlvmGlobals.$out_raw_ostream_SCEV$C(OS, $Deref(Distance));
        } else if (isScalar(II)) {
          OS.$out(/*KEEP_STR*/$S);
        } else {
          /*uint*/int Direction = getDirection(II);
          if (Direction == DVEntry.Unnamed_enum.ALL.getValue()) {
            OS.$out(/*KEEP_STR*/$STAR);
          } else {
            if (((Direction & DVEntry.Unnamed_enum.LT.getValue()) != 0)) {
              OS.$out(/*KEEP_STR*/$LT);
            }
            if (((Direction & DVEntry.Unnamed_enum.EQ.getValue()) != 0)) {
              OS.$out(/*KEEP_STR*/$EQ);
            }
            if (((Direction & DVEntry.Unnamed_enum.GT.getValue()) != 0)) {
              OS.$out(/*KEEP_STR*/$GT);
            }
          }
        }
        if (isPeelLast(II)) {
          OS.$out_char($$p);
        }
        if ($less_uint(II, Levels)) {
          OS.$out(/*KEEP_STR*/$SPACE);
        }
      }
      if (isLoopIndependent()) {
        OS.$out(/*KEEP_STR*/"|<");
      }
      OS.$out(/*KEEP_STR*/$RSQUARE);
      if (Splitable) {
        OS.$out(/*KEEP_STR*/" splitable");
      }
    }
    OS.$out(/*KEEP_STR*/"!\n");
  }

/*private:*/
  private Instruction /*P*/ Src;
  private Instruction /*P*/ Dst;
  private /*const*/ Dependence /*P*/ NextPredecessor;
  private /*const*/ Dependence /*P*/ NextSuccessor;
  /*friend  class DependenceInfo*/
  
  @Override public String toString() {
    return "" + "Src=" + Src // NOI18N
              + ", Dst=" + Dst // NOI18N
              + ", NextPredecessor=" + NextPredecessor // NOI18N
              + ", NextSuccessor=" + NextSuccessor; // NOI18N
  }
}
