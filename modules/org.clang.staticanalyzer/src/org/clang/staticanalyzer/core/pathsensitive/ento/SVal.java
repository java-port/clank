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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clank.java.std;


/// SVal - This represents a symbolic expression, which can be either
///  an L-value or an R-value.
///
//<editor-fold defaultstate="collapsed" desc="clang::ento::SVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 46,
 FQN="clang::ento::SVal", NM="_ZN5clang4ento4SValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValE")
//</editor-fold>
public class SVal implements FoldingSetTrait.Profilable, Native.NativeComparable<SVal>,
        NativePOD<SVal>, NativeMoveable<SVal>, NativeSwappable {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::BaseKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 48,
   FQN="clang::ento::SVal::BaseKind", NM="_ZN5clang4ento4SVal8BaseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SVal8BaseKindE")
  //</editor-fold>
  public enum BaseKind implements Native.ComparableLower {
    UndefinedValKind(0),
    UnknownValKind(UndefinedValKind.getValue() + 1),
    LocKind(UnknownValKind.getValue() + 1),
    NonLocKind(LocKind.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BaseKind valueOf(int val) {
      BaseKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BaseKind[] VALUES;
      private static final BaseKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BaseKind kind : BaseKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BaseKind[min < 0 ? (1-min) : 0];
        VALUES = new BaseKind[max >= 0 ? (1+max) : 0];
        for (BaseKind kind : BaseKind.values()) {
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
    private BaseKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BaseKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BaseKind)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 54,
   FQN="clang::ento::SVal::(anonymous)", NM="_ZN5clang4ento4SValE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int BaseBits = 2;
    public static final /*uint*/int BaseMask = 0x3;
  /*}*/;
/*protected:*/
  protected /*const*/Object/*void P*/ Data;
  
  /// The lowest 2 bits are a BaseKind (0 -- 3).
  ///  The higher bits are an unsigned "kind" value.
  protected /*uint*/int _Kind;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::SVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 63,
   FQN="clang::ento::SVal::SVal", NM="_ZN5clang4ento4SValC1EPKvbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValC1EPKvbj")
  //</editor-fold>
  protected /*explicit*/ SVal(/*const*/Object/*void P*/ d, boolean isLoc, /*uint*/int ValKind) {
    // : Data(d), Kind((isLoc ? LocKind : NonLocKind) | (ValKind << BaseBits)) 
    //START JInit
    this.Data = d;
    this._Kind = (isLoc ? BaseKind.LocKind : BaseKind.NonLocKind).getValue() | (ValKind << BaseBits);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::SVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 66,
   FQN="clang::ento::SVal::SVal", NM="_ZN5clang4ento4SValC1ENS1_8BaseKindEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValC1ENS1_8BaseKindEPKv")
  //</editor-fold>
  protected /*explicit*/ SVal(BaseKind k) {
    this(k, (/*const*/Object/*void P*/ )null);
  }
  protected /*explicit*/ SVal(BaseKind k, /*const*/Object/*void P*/ D/*= null*/) {
    // : Data(D), Kind(k) 
    //START JInit
    this.Data = D;
    this._Kind = k.getValue();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::SVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 70,
   FQN="clang::ento::SVal::SVal", NM="_ZN5clang4ento4SValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValC1Ev")
  //</editor-fold>
  public /*explicit*/ SVal() {
    // : Data(null), Kind(0) 
    //START JInit
    this.Data = null;
    this._Kind = 0;
    //END JInit
  }

  
  /// \brief Convert to the specified SVal type, asserting that this SVal is of
  /// the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::castAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 75,
   FQN="clang::ento::SVal::castAs", NM="Tpl__ZNK5clang4ento4SVal6castAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=Tpl__ZNK5clang4ento4SVal6castAsEv")
  //</editor-fold>
  public </*typename*/ T extends SVal> T castAs(Class<T> clazz) /*const*/ {
    SValToIsKind.get(clazz).$call(this);
    assert SValToIsKind.get(clazz).$call(this);;//Native.$bool(T.isKind(/*Deref*/this));
    T t = (T) SValConstuctor.get(clazz).$call();
    final SVal /*&*/ sv = t;
    sv.$assign(/*Deref*/this);
    return t;
  }

  
  /// \brief Convert to the specified SVal type, returning None if this SVal is
  /// not of the desired type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 86,
   FQN="clang::ento::SVal::getAs", NM="Tpl__ZNK5clang4ento4SVal5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=Tpl__ZNK5clang4ento4SVal5getAsEv")
  //</editor-fold>
  public </*typename*/ T extends SVal> Optional<T> getAs(Class<T> clazz) /*const*/ {
    if (!SValToIsKind.get(clazz).$call(this)) {//Native.$not(T.isKind(/*Deref*/this))) {
      return new Optional<T>(None);
    }
    T t = (T) SValConstuctor.get(clazz).$call();
    final SVal /*&*/ sv = t;
    sv.$assign(/*Deref*/this);
    return new Optional<T>(JD$T$C$R.INSTANCE, t);
  }

  
  /// BufferTy - A temporary buffer to hold a set of SVals.
  /*typedef SmallVector<SVal, 5> BufferTy*/
//  public final class BufferTy extends SmallVector<SVal>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getRawKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 98,
   FQN="clang::ento::SVal::getRawKind", NM="_ZNK5clang4ento4SVal10getRawKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal10getRawKindEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getRawKind() /*const*/ {
    return _Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getBaseKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 99,
   FQN="clang::ento::SVal::getBaseKind", NM="_ZNK5clang4ento4SVal11getBaseKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal11getBaseKindEv")
  //</editor-fold>
  public /*inline*/ BaseKind getBaseKind() /*const*/ {
    return BaseKind.valueOf((_Kind & BaseMask));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getSubKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 100,
   FQN="clang::ento::SVal::getSubKind", NM="_ZNK5clang4ento4SVal10getSubKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal10getSubKindEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getSubKind() /*const*/ {
    return (_Kind & ~BaseMask) >>> BaseBits;
  }

  
  // This method is required for using SVal in a FoldingSetNode.  It
  // extracts a unique signature for this SVal object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 104,
   FQN="clang::ento::SVal::Profile", NM="_ZNK5clang4ento4SVal7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public /*inline*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint((/*uint*/int)getRawKind());
    ID.AddPointer(Data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 109,
   FQN="clang::ento::SVal::operator==", NM="_ZNK5clang4ento4SValeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SValeqERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ SVal /*&*/ R) /*const*/ {
    return getRawKind() == R.getRawKind() && $eq_ptr(Data, R.Data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 113,
   FQN="clang::ento::SVal::operator!=", NM="_ZNK5clang4ento4SValneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SValneERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ SVal /*&*/ R) /*const*/ {
    return !(/*Deref*/this.$eq(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 117,
   FQN="clang::ento::SVal::isUnknown", NM="_ZNK5clang4ento4SVal9isUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal9isUnknownEv")
  //</editor-fold>
  public /*inline*/ boolean isUnknown$SVal() /*const*/ {
    return getRawKind() == BaseKind.UnknownValKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 121,
   FQN="clang::ento::SVal::isUndef", NM="_ZNK5clang4ento4SVal7isUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal7isUndefEv")
  //</editor-fold>
  public final /*inline*/ boolean isUndef$SVal() /*const*/ {
    return getRawKind() == BaseKind.UndefinedValKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isUnknownOrUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 125,
   FQN="clang::ento::SVal::isUnknownOrUndef", NM="_ZNK5clang4ento4SVal16isUnknownOrUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal16isUnknownOrUndefEv")
  //</editor-fold>
  public final /*inline*/ boolean isUnknownOrUndef$SVal() /*const*/ {
    return $lesseq_uint(getRawKind(), BaseKind.UnknownValKind.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 129,
   FQN="clang::ento::SVal::isValid", NM="_ZNK5clang4ento4SVal7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal7isValidEv")
  //</editor-fold>
  public final /*inline*/ boolean isValid$SVal() /*const*/ {
    return $greater_uint(getRawKind(), BaseKind.UnknownValKind.getValue());
  }

  
  
  //===----------------------------------------------------------------------===//
  // Useful predicates.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 174,
   FQN="clang::ento::SVal::isConstant", NM="_ZNK5clang4ento4SVal10isConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal10isConstantEv")
  //</editor-fold>
  public boolean isConstant() /*const*/ {
    return getAs(NsNonloc.ConcreteInt.class).$bool() || getAs(NsLoc.ConcreteInt.class).$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 178,
   FQN="clang::ento::SVal::isConstant", NM="_ZNK5clang4ento4SVal10isConstantEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal10isConstantEi")
  //</editor-fold>
  public boolean isConstant(int I) /*const*/ {
    {
      Optional<NsLoc.ConcreteInt> LV = getAs(NsLoc.ConcreteInt.class);
      if (LV.$bool()) {
        return LV.$arrow().getValue().$eq(I);
      }
    }
    {
      Optional<NsNonloc.ConcreteInt> NV = getAs(NsNonloc.ConcreteInt.class);
      if (NV.$bool()) {
        return NV.$arrow().getValue().$eq(I);
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::isZeroConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 186,
   FQN="clang::ento::SVal::isZeroConstant", NM="_ZNK5clang4ento4SVal14isZeroConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal14isZeroConstantEv")
  //</editor-fold>
  public boolean isZeroConstant() /*const*/ {
    return isConstant(0);
  }

  
  /// hasConjuredSymbol - If this SVal wraps a conjured symbol, return true;
  
  //===----------------------------------------------------------------------===//
  // Symbol iteration within an SVal.
  //===----------------------------------------------------------------------===//
  
  //===----------------------------------------------------------------------===//
  // Utility methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::hasConjuredSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 32,
   FQN="clang::ento::SVal::hasConjuredSymbol", NM="_ZNK5clang4ento4SVal17hasConjuredSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal17hasConjuredSymbolEv")
  //</editor-fold>
  public boolean hasConjuredSymbol() /*const*/ {
    {
      Optional<NsNonloc.SymbolVal> SV = getAs(NsNonloc.SymbolVal.class);
      if (SV.$bool()) {
        /*const*/ SymExpr /*P*/ sym = SV.$arrow().getSymbol();
        if (isa_SymbolConjured(sym)) {
          return true;
        }
      }
    }
    {
      
      Optional<NsLoc.MemRegionVal> RV = getAs(NsLoc.MemRegionVal.class);
      if (RV.$bool()) {
        /*const*/ MemRegion /*P*/ R = RV.$arrow().getRegion();
        {
          /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
          if ((SR != null)) {
            /*const*/ SymExpr /*P*/ sym = SR.getSymbol();
            if (isa_SymbolConjured(sym)) {
              return true;
            }
          }
        }
      }
    }
    
    return false;
  }

  
  /// getAsFunctionDecl - If this SVal is a MemRegionVal and wraps a
  /// CodeTextRegion wrapping a FunctionDecl, return that FunctionDecl.
  /// Otherwise return 0.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAsFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 51,
   FQN="clang::ento::SVal::getAsFunctionDecl", NM="_ZNK5clang4ento4SVal17getAsFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal17getAsFunctionDeclEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getAsFunctionDecl() /*const*/ {
    {
      Optional<NsLoc.MemRegionVal> X = getAs(NsLoc.MemRegionVal.class);
      if (X.$bool()) {
        /*const*/ MemRegion /*P*/ R = X.$arrow().getRegion();
        {
          /*const*/ FunctionCodeRegion /*P*/ CTR = R.getAs(FunctionCodeRegion.class);
          if ((CTR != null)) {
            {
              /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CTR.getDecl());
              if ((FD != null)) {
                return FD;
              }
            }
          }
        }
      }
    }
    
    return null;
  }

  
  /// \brief If this SVal is a location and wraps a symbol, return that
  ///  SymbolRef. Otherwise return 0.
  ///
  /// Casts are ignored during lookup.
  /// \param IncludeBaseRegions The boolean that controls whether the search
  /// should continue to the base regions if the region is not symbolic.
  
  /// \brief If this SVal is a location (subclasses Loc) and wraps a symbol,
  /// return that SymbolRef.  Otherwise return 0.
  ///
  /// Implicit casts (ex: void* -> char*) can turn Symbolic region into Element
  /// region. If that is the case, gets the underlining region.
  /// When IncludeBaseRegions is set to true and the SubRegion is non-symbolic,
  /// the first symbolic parent region is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAsLocSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 69,
   FQN="clang::ento::SVal::getAsLocSymbol", NM="_ZNK5clang4ento4SVal14getAsLocSymbolEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal14getAsLocSymbolEb")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getAsLocSymbol() /*const*/ {
    return getAsLocSymbol(false);
  }
  public /*const*/ SymExpr /*P*/ getAsLocSymbol(boolean IncludeBaseRegions/*= false*/) /*const*/ {
    {
      // FIXME: should we consider SymbolRef wrapped in CodeTextRegion?
      Optional<NsNonloc.LocAsInteger> X = getAs(NsNonloc.LocAsInteger.class);
      if (X.$bool()) {
        return X.$arrow().getLoc().getAsLocSymbol();
      }
    }
    {
      
      Optional<NsLoc.MemRegionVal> X = getAs(NsLoc.MemRegionVal.class);
      if (X.$bool()) {
        /*const*/ MemRegion /*P*/ R = X.$arrow().getRegion();
        {
          /*const*/ SymbolicRegion /*P*/ SymR = IncludeBaseRegions ? R.getSymbolicBase() : dyn_cast_SymbolicRegion(R.StripCasts());
          if ((SymR != null)) {
            return SymR.getSymbol();
          }
        }
      }
    }
    return null;
  }

  
  /// Get the symbol in the SVal or its base region.
  
  /// Get the symbol in the SVal or its base region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getLocSymbolInBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 85,
   FQN="clang::ento::SVal::getLocSymbolInBase", NM="_ZNK5clang4ento4SVal18getLocSymbolInBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal18getLocSymbolInBaseEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getLocSymbolInBase() /*const*/ {
    Optional<NsLoc.MemRegionVal> X = getAs(NsLoc.MemRegionVal.class);
    if (!X.$bool()) {
      return null;
    }
    
    /*const*/ MemRegion /*P*/ R = X.$arrow().getRegion();
    {
      
      /*const*/ SubRegion /*P*/ SR;
      while (((/*P*/ SR = dyn_cast_SubRegion(R)) != null)) {
        {
          /*const*/ SymbolicRegion /*P*/ SymR = dyn_cast_SymbolicRegion(SR);
          if ((SymR != null)) {
            return SymR.getSymbol();
          } else {
            R = SR.getSuperRegion();
          }
        }
      }
    }
    
    return null;
  }

  
  /// \brief If this SVal wraps a symbol return that SymbolRef.
  /// Otherwise, return 0.
  ///
  /// Casts are ignored during lookup.
  /// \param IncludeBaseRegions The boolean that controls whether the search
  /// should continue to the base regions if the region is not symbolic.
  
  // TODO: The next 3 functions have to be simplified.
  
  /// \brief If this SVal wraps a symbol return that SymbolRef.
  /// Otherwise, return 0.
  ///
  /// Casts are ignored during lookup.
  /// \param IncludeBaseRegions The boolean that controls whether the search
  /// should continue to the base regions if the region is not symbolic.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAsSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 111,
   FQN="clang::ento::SVal::getAsSymbol", NM="_ZNK5clang4ento4SVal11getAsSymbolEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal11getAsSymbolEb")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getAsSymbol() /*const*/ {
    return getAsSymbol(false);
  }
  public /*const*/ SymExpr /*P*/ getAsSymbol(boolean IncludeBaseRegion/*= false*/) /*const*/ {
    {
      // FIXME: should we consider SymbolRef wrapped in CodeTextRegion?
      Optional<NsNonloc.SymbolVal> X = getAs(NsNonloc.SymbolVal.class);
      if (X.$bool()) {
        return X.$arrow().getSymbol();
      }
    }
    
    return getAsLocSymbol(IncludeBaseRegion);
  }

  
  /// getAsSymbolicExpression - If this Sval wraps a symbolic expression then
  ///  return that expression.  Otherwise return NULL.
  
  /// getAsSymbolicExpression - If this Sval wraps a symbolic expression then
  ///  return that expression.  Otherwise return NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAsSymbolicExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 121,
   FQN="clang::ento::SVal::getAsSymbolicExpression", NM="_ZNK5clang4ento4SVal23getAsSymbolicExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal23getAsSymbolicExpressionEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getAsSymbolicExpression() /*const*/ {
    {
      Optional<NsNonloc.SymbolVal> X = getAs(NsNonloc.SymbolVal.class);
      if (X.$bool()) {
        return X.$arrow().getSymbol();
      }
    }
    
    return getAsSymbol();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAsSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 128,
   FQN="clang::ento::SVal::getAsSymExpr", NM="_ZNK5clang4ento4SVal12getAsSymExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal12getAsSymExprEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getAsSymExpr() /*const*/ {
    /*const*/ SymExpr /*P*/ Sym = getAsSymbol();
    if (!(Sym != null)) {
      Sym = getAsSymbolicExpression();
    }
    return Sym;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::getAsRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 135,
   FQN="clang::ento::SVal::getAsRegion", NM="_ZNK5clang4ento4SVal11getAsRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal11getAsRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getAsRegion() /*const*/ {
    {
      Optional<NsLoc.MemRegionVal> X = getAs(NsLoc.MemRegionVal.class);
      if (X.$bool()) {
        return X.$arrow().getRegion();
      }
    }
    {
      
      Optional<NsNonloc.LocAsInteger> X = getAs(NsNonloc.LocAsInteger.class);
      if (X.$bool()) {
        return X.$arrow().getLoc().getAsRegion();
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 241,
   FQN="clang::ento::SVal::dumpToStream", NM="_ZNK5clang4ento4SVal12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
    switch (getBaseKind()) {
     case UnknownValKind:
      os.$out(/*KEEP_STR*/"Unknown");
      break;
     case NonLocKind:
      castAs(NonLoc.class).dumpToStream(os);
      break;
     case LocKind:
      castAs(Loc.class).dumpToStream(os);
      break;
     case UndefinedValKind:
      os.$out(/*KEEP_STR*/"Undefined");
      break;
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Pretty-Printing.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 239,
   FQN="clang::ento::SVal::dump", NM="_ZNK5clang4ento4SVal4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpToStream(llvm.errs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::symbol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 177,
   FQN="clang::ento::SVal::symbol_begin", NM="_ZNK5clang4ento4SVal12symbol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal12symbol_beginEv")
  //</editor-fold>
  public SymExpr.symbol_iterator symbol_begin() /*const*/ {
    /*const*/ SymExpr /*P*/ SE = getAsSymbolicExpression();
    if ((SE != null)) {
      return SE.symbol_begin();
    } else {
      return new SymExpr.symbol_iterator();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::symbol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 185,
   FQN="clang::ento::SVal::symbol_end", NM="_ZNK5clang4ento4SVal10symbol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento4SVal10symbol_endEv")
  //</editor-fold>
  public SymExpr.symbol_iterator symbol_end() /*const*/ {
    return SymExpr.symbol_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 46,
   FQN="clang::ento::SVal::operator=", NM="_ZN5clang4ento4SValaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValaSERKS1_")
  //</editor-fold>
  public /*inline*/ SVal /*&*/ $assign(final /*const*/ SVal /*&*/ $Prm0) {
    this.Data = $Prm0.Data;
    this._Kind = $Prm0._Kind;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 46,
   FQN="clang::ento::SVal::operator=", NM="_ZN5clang4ento4SValaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValaSEOS1_")
  //</editor-fold>
  public /*inline*/ SVal /*&*/ $assignMove(final SVal /*&&*/$Prm0) {
    this.Data = $Prm0.Data;
    this._Kind = $Prm0._Kind;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::SVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 46,
   FQN="clang::ento::SVal::SVal", NM="_ZN5clang4ento4SValC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValC1ERKS1_")
  //</editor-fold>
  public /*inline*/ SVal(final /*const*/ SVal /*&*/ $Prm0) {
    // : Data(.Data), Kind(.Kind) 
    //START JInit
    this.Data = $Prm0.Data;
    this._Kind = $Prm0._Kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SVal::SVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 46,
   FQN="clang::ento::SVal::SVal", NM="_ZN5clang4ento4SValC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento4SValC1EOS1_")
  //</editor-fold>
  public /*inline*/ SVal(JD$Move _dparam, final SVal /*&&*/$Prm0) {
    // : Data(static_cast<SVal &&>().Data), Kind(static_cast<SVal &&>().Kind) 
    //START JInit
    this.Data = $Prm0.Data;
    this._Kind = $Prm0._Kind;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void $destroy() { }
  
  @FunctionalInterface
  public interface Void2SVal {
    SVal $call();
  }
  
  @FunctionalInterface
  public interface SVal2Boolean {
    boolean $call(SVal p);
  }
  
  private static final java.util.Map<Class<? extends SVal>, Void2SVal> SValConstuctor = new java.util.HashMap<>(64);
  private static final java.util.Map<Class<? extends SVal>, SVal2Boolean> SValToIsKind = new java.util.HashMap<>(64);
  static void mapSValToTypeClass(Class<? extends SVal> SValClass, SVal2Boolean isKind, Void2SVal conctructor) {
    SValConstuctor.put(SValClass, conctructor);
    SValToIsKind.put(SValClass, isKind);
  }
  
  static { SVal.mapSValToTypeClass(UnknownVal.class, UnknownVal::isKind, ()->{return new UnknownVal();}); }
  static { SVal.mapSValToTypeClass(KnownSVal.class, KnownSVal::isKind, ()->{return new KnownSVal();}); }
  static { SVal.mapSValToTypeClass(NonLoc.class, NonLoc::isKind, ()->{return new NonLoc();}); }
  static { SVal.mapSValToTypeClass(Loc.class, Loc::isKind, ()->{return new Loc();}); }
  static { SVal.mapSValToTypeClass(DefinedOrUnknownSVal.class, DefinedOrUnknownSVal::isKind, ()->{return new DefinedOrUnknownSVal();}); }
  static { SVal.mapSValToTypeClass(NsLoc.GotoLabel.class, NsLoc.GotoLabel::isKind, ()->{return new NsLoc.GotoLabel();}); }
  static { SVal.mapSValToTypeClass(NsLoc.MemRegionVal.class, NsLoc.MemRegionVal::isKind, ()->{return new NsLoc.MemRegionVal();}); }
  static { SVal.mapSValToTypeClass(NsLoc.ConcreteInt.class, NsLoc.ConcreteInt::isKind, ()->{return new NsLoc.ConcreteInt();}); }
  static { SVal.mapSValToTypeClass(NsNonloc.SymbolVal.class, NsNonloc.SymbolVal::isKind, ()->{return new NsNonloc.SymbolVal();}); }
  static { SVal.mapSValToTypeClass(NsNonloc.ConcreteInt.class, NsNonloc.ConcreteInt::isKind, ()->{return new NsNonloc.ConcreteInt();}); }
  static { SVal.mapSValToTypeClass(NsNonloc.LocAsInteger.class, NsNonloc.LocAsInteger::isKind, ()->{return new NsNonloc.LocAsInteger();}); }
  static { SVal.mapSValToTypeClass(NsNonloc.CompoundVal.class, NsNonloc.CompoundVal::isKind, ()->{return new NsNonloc.CompoundVal();}); }
  static { SVal.mapSValToTypeClass(NsNonloc.LazyCompoundVal.class, NsNonloc.LazyCompoundVal::isKind, ()->{return new NsNonloc.LazyCompoundVal();}); }
  static { SVal.mapSValToTypeClass(UndefinedVal.class, UndefinedVal::isKind, ()->{return new UndefinedVal();}); }
  static { SVal.mapSValToTypeClass(DefinedSVal.class, DefinedSVal::isKind, ()->{return new DefinedSVal();}); }

  @Override public SVal clone() { 
    assert this.getClass() == SVal.class : "Why not overridden in " + this.getClass();
    return new SVal(this); 
  }
  
  @Override public SVal move() {
    assert this.getClass() == SVal.class : "Why not overridden in " + this.getClass();
    return new SVal(JD$Move.INSTANCE, this);
  }

  @Override public void swap(NativeSwappable Other) {
    assert this.getClass() == Other.getClass();
    SVal RHS = (SVal) Other;
    Object tmp = this.Data; 
    this.Data = RHS.Data; 
    RHS.Data = tmp; 
    int t = this._Kind; 
    this._Kind = RHS._Kind; 
    RHS._Kind = t; 
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      dumpToStream(OS);
      OS.flush();
      return Buf.toJavaString();
    }
    return "" + "Data=" + Data // NOI18N
              + ", _Kind=" + _Kind; // NOI18N
  }
}
