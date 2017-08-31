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

package org.llvm.analysis.impl;

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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 65,
 FQN="(anonymous namespace)::LVILatticeVal", NM="_ZN12_GLOBAL__N_113LVILatticeValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValE")
//</editor-fold>
public class LVILatticeVal implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::LatticeValueTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 66,
   FQN="(anonymous namespace)::LVILatticeVal::LatticeValueTy", NM="_ZN12_GLOBAL__N_113LVILatticeVal14LatticeValueTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal14LatticeValueTyE")
  //</editor-fold>
  private enum LatticeValueTy implements Native.NativeUIntEnum {
    /// This Value has no known value yet.  As a result, this implies the
    /// producing instruction is dead.  Caution: We use this as the starting
    /// state in our local meet rules.  In this usage, it's taken to mean
    /// "nothing known yet".
    undefined(0),
    
    /// This Value has a specific constant value.  (For integers, constantrange
    /// is used instead.)
    constant(undefined.getValue() + 1),
    
    /// This Value is known to not have the specified value.  (For integers,
    /// constantrange is used instead.)
    notconstant(constant.getValue() + 1),
    
    /// The Value falls within this range. (Used only for integer typed values.)
    constantrange(notconstant.getValue() + 1),
    
    /// We can not precisely model the dynamic values this value might take.
    overdefined(constantrange.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LatticeValueTy valueOf(int val) {
      LatticeValueTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LatticeValueTy[] VALUES;
      private static final LatticeValueTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LatticeValueTy kind : LatticeValueTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LatticeValueTy[min < 0 ? (1-min) : 0];
        VALUES = new LatticeValueTy[max >= 0 ? (1+max) : 0];
        for (LatticeValueTy kind : LatticeValueTy.values()) {
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
    private LatticeValueTy(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Val: This stores the current lattice value along with the Constant* for
  /// the constant if this is a 'constant' or 'notconstant' value.
  private LatticeValueTy Tag;
  private Constant /*P*/ Val;
  private ConstantRange Range;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::LVILatticeVal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 95,
   FQN="(anonymous namespace)::LVILatticeVal::LVILatticeVal", NM="_ZN12_GLOBAL__N_113LVILatticeValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValC1Ev")
  //</editor-fold>
  public LVILatticeVal() {
    // : Tag(undefined), Val(null), Range(1, true) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 97,
   FQN="(anonymous namespace)::LVILatticeVal::get", NM="_ZN12_GLOBAL__N_113LVILatticeVal3getEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal3getEPN4llvm8ConstantE")
  //</editor-fold>
  public static LVILatticeVal get(Constant /*P*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::getNot">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 103,
   FQN="(anonymous namespace)::LVILatticeVal::getNot", NM="_ZN12_GLOBAL__N_113LVILatticeVal6getNotEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal6getNotEPN4llvm8ConstantE")
  //</editor-fold>
  public static LVILatticeVal getNot(Constant /*P*/ C) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::getRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 109,
   FQN="(anonymous namespace)::LVILatticeVal::getRange", NM="_ZN12_GLOBAL__N_113LVILatticeVal8getRangeEN4llvm13ConstantRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal8getRangeEN4llvm13ConstantRangeE")
  //</editor-fold>
  public static LVILatticeVal getRange(ConstantRange CR) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::getOverdefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 114,
   FQN="(anonymous namespace)::LVILatticeVal::getOverdefined", NM="_ZN12_GLOBAL__N_113LVILatticeVal14getOverdefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal14getOverdefinedEv")
  //</editor-fold>
  public static LVILatticeVal getOverdefined() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::isUndefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 120,
   FQN="(anonymous namespace)::LVILatticeVal::isUndefined", NM="_ZNK12_GLOBAL__N_113LVILatticeVal11isUndefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal11isUndefinedEv")
  //</editor-fold>
  public boolean isUndefined() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::isConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 121,
   FQN="(anonymous namespace)::LVILatticeVal::isConstant", NM="_ZNK12_GLOBAL__N_113LVILatticeVal10isConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal10isConstantEv")
  //</editor-fold>
  public boolean isConstant() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::isNotConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 122,
   FQN="(anonymous namespace)::LVILatticeVal::isNotConstant", NM="_ZNK12_GLOBAL__N_113LVILatticeVal13isNotConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal13isNotConstantEv")
  //</editor-fold>
  public boolean isNotConstant() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::isConstantRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 123,
   FQN="(anonymous namespace)::LVILatticeVal::isConstantRange", NM="_ZNK12_GLOBAL__N_113LVILatticeVal15isConstantRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal15isConstantRangeEv")
  //</editor-fold>
  public boolean isConstantRange() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::isOverdefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 124,
   FQN="(anonymous namespace)::LVILatticeVal::isOverdefined", NM="_ZNK12_GLOBAL__N_113LVILatticeVal13isOverdefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal13isOverdefinedEv")
  //</editor-fold>
  public boolean isOverdefined() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::getConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 126,
   FQN="(anonymous namespace)::LVILatticeVal::getConstant", NM="_ZNK12_GLOBAL__N_113LVILatticeVal11getConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal11getConstantEv")
  //</editor-fold>
  public Constant /*P*/ getConstant() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::getNotConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 131,
   FQN="(anonymous namespace)::LVILatticeVal::getNotConstant", NM="_ZNK12_GLOBAL__N_113LVILatticeVal14getNotConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal14getNotConstantEv")
  //</editor-fold>
  public Constant /*P*/ getNotConstant() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::getConstantRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 136,
   FQN="(anonymous namespace)::LVILatticeVal::getConstantRange", NM="_ZNK12_GLOBAL__N_113LVILatticeVal16getConstantRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZNK12_GLOBAL__N_113LVILatticeVal16getConstantRangeEv")
  //</editor-fold>
  public ConstantRange getConstantRange() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this is a change in status.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::markOverdefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 143,
   FQN="(anonymous namespace)::LVILatticeVal::markOverdefined", NM="_ZN12_GLOBAL__N_113LVILatticeVal15markOverdefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal15markOverdefinedEv")
  //</editor-fold>
  public boolean markOverdefined() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this is a change in status.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::markConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 151,
   FQN="(anonymous namespace)::LVILatticeVal::markConstant", NM="_ZN12_GLOBAL__N_113LVILatticeVal12markConstantEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal12markConstantEPN4llvm8ConstantE")
  //</editor-fold>
  public boolean markConstant(Constant /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this is a change in status.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::markNotConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 167,
   FQN="(anonymous namespace)::LVILatticeVal::markNotConstant", NM="_ZN12_GLOBAL__N_113LVILatticeVal15markNotConstantEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal15markNotConstantEPN4llvm8ConstantE")
  //</editor-fold>
  public boolean markNotConstant(Constant /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if this is a change in status.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::markConstantRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 185,
   FQN="(anonymous namespace)::LVILatticeVal::markConstantRange", NM="_ZN12_GLOBAL__N_113LVILatticeVal17markConstantRangeEN4llvm13ConstantRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal17markConstantRangeEN4llvm13ConstantRangeE")
  //</editor-fold>
  public boolean markConstantRange(ConstantRange NewR) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Merge the specified lattice value into this one, updating this
  /// one and returning true if anything changed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::mergeIn">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 206,
   FQN="(anonymous namespace)::LVILatticeVal::mergeIn", NM="_ZN12_GLOBAL__N_113LVILatticeVal7mergeInERKS0_RKN4llvm10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeVal7mergeInERKS0_RKN4llvm10DataLayoutE")
  //</editor-fold>
  public boolean mergeIn(final /*const*/ LVILatticeVal /*&*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::LVILatticeVal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 65,
   FQN="(anonymous namespace)::LVILatticeVal::LVILatticeVal", NM="_ZN12_GLOBAL__N_113LVILatticeValC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LVILatticeVal(final /*const*/ LVILatticeVal /*&*/ $Prm0) {
    // : Tag(.Tag), Val(.Val), Range(.Range) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::LVILatticeVal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 65,
   FQN="(anonymous namespace)::LVILatticeVal::LVILatticeVal", NM="_ZN12_GLOBAL__N_113LVILatticeValC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValC1EOS0_")
  //</editor-fold>
  public /*inline*/ LVILatticeVal(JD$Move _dparam, final LVILatticeVal /*&&*/$Prm0) {
    // : Tag(static_cast<LVILatticeVal &&>().Tag), Val(static_cast<LVILatticeVal &&>().Val), Range(static_cast<LVILatticeVal &&>().Range) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::~LVILatticeVal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 65,
   FQN="(anonymous namespace)::LVILatticeVal::~LVILatticeVal", NM="_ZN12_GLOBAL__N_113LVILatticeValD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 65,
   FQN="(anonymous namespace)::LVILatticeVal::operator=", NM="_ZN12_GLOBAL__N_113LVILatticeValaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValaSERKS0_")
  //</editor-fold>
  public /*inline*/ LVILatticeVal /*&*/ $assign(final /*const*/ LVILatticeVal /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LVILatticeVal::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 65,
   FQN="(anonymous namespace)::LVILatticeVal::operator=", NM="_ZN12_GLOBAL__N_113LVILatticeValaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN12_GLOBAL__N_113LVILatticeValaSEOS0_")
  //</editor-fold>
  public /*inline*/ LVILatticeVal /*&*/ $assignMove(final LVILatticeVal /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Tag=" + Tag // NOI18N
              + ", Val=" + Val // NOI18N
              + ", Range=" + Range; // NOI18N
  }
}
