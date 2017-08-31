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


/// \brief Represents the cost of inlining a function.
///
/// This supports special values for functions which should "always" or
/// "never" be inlined. Otherwise, the cost represents a unitless amount;
/// smaller values increase the likelihood of the function being inlined.
///
/// Objects of this type also provide the adjusted threshold for inlining
/// based on the information available for a particular callsite. They can be
/// directly tested to determine if inlining should occur given the cost and
/// threshold for this cost metric.
//<editor-fold defaultstate="collapsed" desc="llvm::InlineCost">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 52,
 FQN="llvm::InlineCost", NM="_ZN4llvm10InlineCostE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCostE")
//</editor-fold>
public class InlineCost implements Native.Native$Bool {
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::SentinelValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 53,
   FQN="llvm::InlineCost::SentinelValues", NM="_ZN4llvm10InlineCost14SentinelValuesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCost14SentinelValuesE")
  //</editor-fold>
  private enum SentinelValues implements Native.NativeIntEnum {
    AlwaysInlineCost(INT_MIN),
    NeverInlineCost(INT_MAX);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SentinelValues valueOf(int val) {
      SentinelValues out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SentinelValues[] VALUES;
      private static final SentinelValues[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SentinelValues kind : SentinelValues.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SentinelValues[min < 0 ? (1-min) : 0];
        VALUES = new SentinelValues[max >= 0 ? (1+max) : 0];
        for (SentinelValues kind : SentinelValues.values()) {
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

    private final int value;
    private SentinelValues(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief The estimated cost of inlining this callsite.
  private /*const*/int Cost;
  
  /// \brief The adjusted threshold against which this cost was computed.
  private /*const*/int Threshold;
  
  // Trivial constructor, interesting logic in the factory functions below.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::InlineCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 65,
   FQN="llvm::InlineCost::InlineCost", NM="_ZN4llvm10InlineCostC1Eii",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCostC1Eii")
  //</editor-fold>
  private InlineCost(int Cost, int Threshold) {
    // : Cost(Cost), Threshold(Threshold) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 68,
   FQN="llvm::InlineCost::get", NM="_ZN4llvm10InlineCost3getEii",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCost3getEii")
  //</editor-fold>
  public static InlineCost get(int Cost, int Threshold) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::getAlways">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 73,
   FQN="llvm::InlineCost::getAlways", NM="_ZN4llvm10InlineCost9getAlwaysEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCost9getAlwaysEv")
  //</editor-fold>
  public static InlineCost getAlways() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::getNever">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 76,
   FQN="llvm::InlineCost::getNever", NM="_ZN4llvm10InlineCost8getNeverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCost8getNeverEv")
  //</editor-fold>
  public static InlineCost getNever() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Test whether the inline cost is low enough for inlining.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::operator bool">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 81,
   FQN="llvm::InlineCost::operator bool", NM="_ZNK4llvm10InlineCostcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm10InlineCostcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::isAlways">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 85,
   FQN="llvm::InlineCost::isAlways", NM="_ZNK4llvm10InlineCost8isAlwaysEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm10InlineCost8isAlwaysEv")
  //</editor-fold>
  public boolean isAlways() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::isNever">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 86,
   FQN="llvm::InlineCost::isNever", NM="_ZNK4llvm10InlineCost7isNeverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm10InlineCost7isNeverEv")
  //</editor-fold>
  public boolean isNever() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::isVariable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 87,
   FQN="llvm::InlineCost::isVariable", NM="_ZNK4llvm10InlineCost10isVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm10InlineCost10isVariableEv")
  //</editor-fold>
  public boolean isVariable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the inline cost estimate.
  /// It is an error to call this on an "always" or "never" InlineCost.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::getCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 91,
   FQN="llvm::InlineCost::getCost", NM="_ZNK4llvm10InlineCost7getCostEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm10InlineCost7getCostEv")
  //</editor-fold>
  public int getCost() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the cost delta from the threshold for inlining.
  /// Only valid if the cost is of the variable kind. Returns a negative
  /// value if the cost is too high to inline.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::getCostDelta">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 99,
   FQN="llvm::InlineCost::getCostDelta", NM="_ZNK4llvm10InlineCost12getCostDeltaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZNK4llvm10InlineCost12getCostDeltaEv")
  //</editor-fold>
  public int getCostDelta() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::InlineCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 52,
   FQN="llvm::InlineCost::InlineCost", NM="_ZN4llvm10InlineCostC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCostC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InlineCost(final /*const*/ InlineCost /*&*/ $Prm0) {
    // : Cost(.Cost), Threshold(.Threshold) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineCost::InlineCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InlineCost.h", line = 52,
   FQN="llvm::InlineCost::InlineCost", NM="_ZN4llvm10InlineCostC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Inliner.cpp -nm=_ZN4llvm10InlineCostC1EOS0_")
  //</editor-fold>
  public /*inline*/ InlineCost(JD$Move _dparam, final InlineCost /*&&*/$Prm0) {
    // : Cost(static_cast<InlineCost &&>().Cost), Threshold(static_cast<InlineCost &&>().Threshold) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Cost=" + Cost // NOI18N
              + ", Threshold=" + Threshold; // NOI18N
  }
}
