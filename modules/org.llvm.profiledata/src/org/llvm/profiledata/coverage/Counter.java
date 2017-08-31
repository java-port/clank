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

package org.llvm.profiledata.coverage;

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


/// \brief A Counter is an abstract value that describes how to compute the
/// execution count for a region of code using the collected profile count data.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 84,
 FQN="llvm::coverage::Counter", NM="_ZN4llvm8coverage7CounterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounterE")
//</editor-fold>
public class/*struct*/ Counter {
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::CounterKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 85,
   FQN="llvm::coverage::Counter::CounterKind", NM="_ZN4llvm8coverage7Counter11CounterKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7Counter11CounterKindE")
  //</editor-fold>
  public enum CounterKind implements Native.NativeUIntEnum {
    Zero(0),
    CounterValueReference(Zero.getValue() + 1),
    Expression(CounterValueReference.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CounterKind valueOf(int val) {
      CounterKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CounterKind[] VALUES;
      private static final CounterKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CounterKind kind : CounterKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CounterKind[min < 0 ? (1-min) : 0];
        VALUES = new CounterKind[max >= 0 ? (1+max) : 0];
        for (CounterKind kind : CounterKind.values()) {
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
    private CounterKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  public static /*const*//*uint*/int EncodingTagBits = 2;
  public static /*const*//*uint*/int EncodingTagMask = 0x3;
  public static /*const*//*uint*/int EncodingCounterTagAndExpansionRegionTagBits = EncodingTagBits + 1;
/*private:*/
  private CounterKind Kind;
  private /*uint*/int ID;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::Counter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 95,
   FQN="llvm::coverage::Counter::Counter", NM="_ZN4llvm8coverage7CounterC1ENS1_11CounterKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounterC1ENS1_11CounterKindEj")
  //</editor-fold>
  private Counter(CounterKind Kind, /*uint*/int ID) {
    // : Kind(Kind), ID(ID) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::Counter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 98,
   FQN="llvm::coverage::Counter::Counter", NM="_ZN4llvm8coverage7CounterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounterC1Ev")
  //</editor-fold>
  public Counter() {
    // : Kind(Zero), ID(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::getKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 100,
   FQN="llvm::coverage::Counter::getKind", NM="_ZNK4llvm8coverage7Counter7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage7Counter7getKindEv")
  //</editor-fold>
  public CounterKind getKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::isZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 102,
   FQN="llvm::coverage::Counter::isZero", NM="_ZNK4llvm8coverage7Counter6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage7Counter6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::isExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 104,
   FQN="llvm::coverage::Counter::isExpression", NM="_ZNK4llvm8coverage7Counter12isExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage7Counter12isExpressionEv")
  //</editor-fold>
  public boolean isExpression() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::getCounterID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 106,
   FQN="llvm::coverage::Counter::getCounterID", NM="_ZNK4llvm8coverage7Counter12getCounterIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage7Counter12getCounterIDEv")
  //</editor-fold>
  public /*uint*/int getCounterID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::getExpressionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 108,
   FQN="llvm::coverage::Counter::getExpressionID", NM="_ZNK4llvm8coverage7Counter15getExpressionIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage7Counter15getExpressionIDEv")
  //</editor-fold>
  public /*uint*/int getExpressionID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::coverage::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 110,
   FQN="llvm::coverage::operator==", NM="_ZN4llvm8coverageeqERKNS0_7CounterES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverageeqERKNS0_7CounterES3_")
  //</editor-fold>
  public static boolean $eq_Counter$C(final /*const*/ Counter /*&*/ LHS, final /*const*/ Counter /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::coverage::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 114,
   FQN="llvm::coverage::operator!=", NM="_ZN4llvm8coverageneERKNS0_7CounterES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverageneERKNS0_7CounterES3_")
  //</editor-fold>
  public static boolean $noteq_Counter$C(final /*const*/ Counter /*&*/ LHS, final /*const*/ Counter /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::coverage::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 118,
   FQN="llvm::coverage::operator<", NM="_ZN4llvm8coverageltERKNS0_7CounterES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverageltERKNS0_7CounterES3_")
  //</editor-fold>
  public static boolean $less_Counter$C(final /*const*/ Counter /*&*/ LHS, final /*const*/ Counter /*&*/ RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the counter that represents the number zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::getZero">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 123,
   FQN="llvm::coverage::Counter::getZero", NM="_ZN4llvm8coverage7Counter7getZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7Counter7getZeroEv")
  //</editor-fold>
  public static Counter getZero() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the counter that corresponds to a specific profile counter.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::getCounter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 126,
   FQN="llvm::coverage::Counter::getCounter", NM="_ZN4llvm8coverage7Counter10getCounterEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7Counter10getCounterEj")
  //</editor-fold>
  public static Counter getCounter(/*uint*/int CounterId) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the counter that corresponds to a specific
  /// addition counter expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::getExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 132,
   FQN="llvm::coverage::Counter::getExpression", NM="_ZN4llvm8coverage7Counter13getExpressionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7Counter13getExpressionEj")
  //</editor-fold>
  public static Counter getExpression(/*uint*/int ExpressionId) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::Counter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 84,
   FQN="llvm::coverage::Counter::Counter", NM="_ZN4llvm8coverage7CounterC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounterC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Counter(final /*const*/ Counter /*&*/ $Prm0) {
    // : Kind(.Kind), ID(.ID) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::Counter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 84,
   FQN="llvm::coverage::Counter::Counter", NM="_ZN4llvm8coverage7CounterC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounterC1EOS1_")
  //</editor-fold>
  public /*inline*/ Counter(JD$Move _dparam, final Counter /*&&*/$Prm0) {
    // : Kind(static_cast<Counter &&>().Kind), ID(static_cast<Counter &&>().ID) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 84,
   FQN="llvm::coverage::Counter::operator=", NM="_ZN4llvm8coverage7CounteraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounteraSERKS1_")
  //</editor-fold>
  public /*inline*/ Counter /*&*/ $assign(final /*const*/ Counter /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::Counter::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 84,
   FQN="llvm::coverage::Counter::operator=", NM="_ZN4llvm8coverage7CounteraSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage7CounteraSEOS1_")
  //</editor-fold>
  public /*inline*/ Counter /*&*/ $assignMove(final Counter /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", ID=" + ID; // NOI18N
  }
}
