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


/// This class represents an assumption made using SCEV expressions which can
/// be checked at run-time.
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 174,
 FQN="llvm::SCEVPredicate", NM="_ZN4llvm13SCEVPredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm13SCEVPredicateE")
//</editor-fold>
public abstract class SCEVPredicate implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  /*friend  struct FoldingSetTrait<SCEVPredicate>*/
  
  /// A reference to an Interned FoldingSetNodeID for this node.  The
  /// ScalarEvolution's BumpPtrAllocator holds the data.
  private FoldingSetNodeIDRef FastID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::SCEVPredicateKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 182,
   FQN="llvm::SCEVPredicate::SCEVPredicateKind", NM="_ZN4llvm13SCEVPredicate17SCEVPredicateKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm13SCEVPredicate17SCEVPredicateKindE")
  //</editor-fold>
  public enum SCEVPredicateKind implements Native.NativeUIntEnum {
    P_Union(0),
    P_Equal(P_Union.getValue() + 1),
    P_Wrap(P_Equal.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SCEVPredicateKind valueOf(int val) {
      SCEVPredicateKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SCEVPredicateKind[] VALUES;
      private static final SCEVPredicateKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SCEVPredicateKind kind : SCEVPredicateKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SCEVPredicateKind[min < 0 ? (1-min) : 0];
        VALUES = new SCEVPredicateKind[max >= 0 ? (1+max) : 0];
        for (SCEVPredicateKind kind : SCEVPredicateKind.values()) {
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
    private SCEVPredicateKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*protected:*/
  protected SCEVPredicateKind Kind;
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::~SCEVPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 186,
   FQN="llvm::SCEVPredicate::~SCEVPredicate", NM="_ZN4llvm13SCEVPredicateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm13SCEVPredicateD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::SCEVPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 187,
   FQN="llvm::SCEVPredicate::SCEVPredicate", NM="_ZN4llvm13SCEVPredicateC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm13SCEVPredicateC1ERKS0_")
  //</editor-fold>
  protected SCEVPredicate(final /*const*/ SCEVPredicate /*&*/ $Prm0) {
    // : FoldingSetNode(), FastID(.FastID), Kind(.Kind)/* = default*/ 
    $Node($Prm0);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 188,
   FQN="llvm::SCEVPredicate::operator=", NM="_ZN4llvm13SCEVPredicateaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm13SCEVPredicateaSERKS0_")
  //</editor-fold>
  protected SCEVPredicate /*&*/ $assign(final /*const*/ SCEVPredicate /*&*/ $Prm0)/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  
  /// SCEV predicates
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::SCEVPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10206,
   FQN="llvm::SCEVPredicate::SCEVPredicate", NM="_ZN4llvm13SCEVPredicateC1ENS_19FoldingSetNodeIDRefENS0_17SCEVPredicateKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm13SCEVPredicateC1ENS_19FoldingSetNodeIDRefENS0_17SCEVPredicateKindE")
  //</editor-fold>
  public SCEVPredicate(/*const*/ FoldingSetNodeIDRef ID, 
      SCEVPredicateKind Kind) {
    // : FoldingSetNode(), FastID(ID), Kind(Kind) 
    $Node();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::getKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 193,
   FQN="llvm::SCEVPredicate::getKind", NM="_ZNK4llvm13SCEVPredicate7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm13SCEVPredicate7getKindEv")
  //</editor-fold>
  public SCEVPredicateKind getKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the estimated complexity of this predicate.  This is roughly
  /// measured in the number of run-time checks required.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::getComplexity">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 197,
   FQN="llvm::SCEVPredicate::getComplexity", NM="_ZNK4llvm13SCEVPredicate13getComplexityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm13SCEVPredicate13getComplexityEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getComplexity() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns true if the predicate is always true. This means that no
  /// assumptions were made and nothing needs to be checked at run-time.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::isAlwaysTrue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 201,
   FQN="llvm::SCEVPredicate::isAlwaysTrue", NM="_ZNK4llvm13SCEVPredicate12isAlwaysTrueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm13SCEVPredicate12isAlwaysTrueEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isAlwaysTrue() /*const*//* = 0*/;

  
  /// Returns true if this predicate implies \p N.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::implies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 204,
   FQN="llvm::SCEVPredicate::implies", NM="_ZNK4llvm13SCEVPredicate7impliesEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm13SCEVPredicate7impliesEPKS0_")
  //</editor-fold>
  public abstract /*virtual*/ boolean implies(/*const*/ SCEVPredicate /*P*/ N) /*const*//* = 0*/;

  
  /// Prints a textual representation of this predicate with an indentation of
  /// \p Depth.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 208,
   FQN="llvm::SCEVPredicate::print", NM="_ZNK4llvm13SCEVPredicate5printERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm13SCEVPredicate5printERNS_11raw_ostreamEj")
  //</editor-fold>
  public abstract /*virtual*/ void print(final raw_ostream /*&*/ OS) /*const*//* = 0*/;
  public abstract /*virtual*/ void print(final raw_ostream /*&*/ OS, /*uint*/int Depth/*= 0*/) /*const*//* = 0*/;

  
  /// Returns the SCEV to which this predicate applies, or nullptr if this is
  /// a SCEVUnionPredicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVPredicate::getExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 212,
   FQN="llvm::SCEVPredicate::getExpr", NM="_ZNK4llvm13SCEVPredicate7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZNK4llvm13SCEVPredicate7getExprEv")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ SCEV /*P*/ getExpr() /*const*//* = 0*/;

  
  @Override public String toString() {
    return "" + "FastID=" + FastID // NOI18N
              + ", Kind=" + Kind // NOI18N
              + super.toString(); // NOI18N
  }
}
