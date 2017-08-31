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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type NsNonloc">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento6nonloc11CompoundValE;_ZN5clang4ento6nonloc11ConcreteIntE;_ZN5clang4ento6nonloc12LocAsIntegerE;_ZN5clang4ento6nonloc15LazyCompoundValE;_ZN5clang4ento6nonloc4KindE;_ZN5clang4ento6nonloc9SymbolValE; -static-type=NsNonloc -package=org.clang.staticanalyzer.core.pathsensitive.ento")
//</editor-fold>
public final class NsNonloc {

//<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::Kind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 309,
 FQN="clang::ento::nonloc::Kind", NM="_ZN5clang4ento6nonloc4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc4KindE")
//</editor-fold>
public enum Kind implements Native.ComparableLower {
  CompoundValKind(0),
  ConcreteIntKind(CompoundValKind.getValue() + 1),
  LazyCompoundValKind(ConcreteIntKind.getValue() + 1),
  LocAsIntegerKind(LazyCompoundValKind.getValue() + 1),
  SymbolValKind(LocAsIntegerKind.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Kind valueOf(int val) {
    Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Kind[] VALUES;
    private static final Kind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Kind kind : Kind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Kind[min < 0 ? (1-min) : 0];
      VALUES = new Kind[max >= 0 ? (1+max) : 0];
      for (Kind kind : Kind.values()) {
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
  private Kind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
  //</editor-fold>
}

/// \brief Represents symbolic expression.
//<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 315,
 FQN="clang::ento::nonloc::SymbolVal", NM="_ZN5clang4ento6nonloc9SymbolValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc9SymbolValE")
//</editor-fold>
public static class SymbolVal extends /*public*/ NonLoc {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::SymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 317,
   FQN="clang::ento::nonloc::SymbolVal::SymbolVal", NM="_ZN5clang4ento6nonloc9SymbolValC1EPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc9SymbolValC1EPKNS0_7SymExprE")
  //</editor-fold>
  public SymbolVal(/*const*/ SymExpr /*P*/ sym) {
    // : NonLoc(SymbolValKind, sym) 
    //START JInit
    super(Kind.SymbolValKind.getValue(), sym);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::getSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 319,
   FQN="clang::ento::nonloc::SymbolVal::getSymbol", NM="_ZNK5clang4ento6nonloc9SymbolVal9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc9SymbolVal9getSymbolEv")
  //</editor-fold>
  public /*const*/ SymExpr /*P*/ getSymbol() /*const*/ {
    return (/*const*/ SymExpr /*P*/ )Data;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::isExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 323,
   FQN="clang::ento::nonloc::SymbolVal::isExpression", NM="_ZNK5clang4ento6nonloc9SymbolVal12isExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc9SymbolVal12isExpressionEv")
  //</editor-fold>
  public boolean isExpression() /*const*/ {
    return !isa_SymbolData(getSymbol());
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::SymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 329,
   FQN="clang::ento::nonloc::SymbolVal::SymbolVal", NM="_ZN5clang4ento6nonloc9SymbolValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc9SymbolValC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ SymbolVal() {
    // : NonLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 330,
   FQN="clang::ento::nonloc::SymbolVal::isKind", NM="_ZN5clang4ento6nonloc9SymbolVal6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc9SymbolVal6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.NonLocKind
       && V.getSubKind() == Kind.SymbolValKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 335,
   FQN="clang::ento::nonloc::SymbolVal::isKind", NM="_ZN5clang4ento6nonloc9SymbolVal6isKindERKNS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc9SymbolVal6isKindERKNS0_6NonLocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ NonLoc /*&*/ V) {
    return V.getSubKind() == Kind.SymbolValKind.getValue();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::~SymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 315,
   FQN="clang::ento::nonloc::SymbolVal::~SymbolVal", NM="_ZN5clang4ento6nonloc9SymbolValD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SValBuilder.cpp -nm=_ZN5clang4ento6nonloc9SymbolValD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::SymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 315,
   FQN="clang::ento::nonloc::SymbolVal::SymbolVal", NM="_ZN5clang4ento6nonloc9SymbolValC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento6nonloc9SymbolValC1ERKS2_")
  //</editor-fold>
  public /*inline*/ SymbolVal(final /*const*/ SymbolVal /*&*/ $Prm0) {
    // : NonLoc() 
    //START JInit
    super($Prm0);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::SymbolVal::SymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 315,
   FQN="clang::ento::nonloc::SymbolVal::SymbolVal", NM="_ZN5clang4ento6nonloc9SymbolValC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento6nonloc9SymbolValC1EOS2_")
  //</editor-fold>
  public /*inline*/ SymbolVal(JD$Move _dparam, final SymbolVal /*&&*/$Prm0) {
    // : NonLoc(static_cast<SymbolVal &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public SymbolVal clone() {
    assert this.getClass() == SymbolVal.class : "Why not overridden in " + this.getClass();
    return new SymbolVal(this);
  }

  @Override
  public SymbolVal move() {
    assert this.getClass() == SymbolVal.class : "Why not overridden in " + this.getClass();
    return new SymbolVal(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  ////////////////////////////////////////////////////////////// 
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}

/// \brief Value representing integer constant.
//<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 341,
 FQN="clang::ento::nonloc::ConcreteInt", NM="_ZN5clang4ento6nonloc11ConcreteIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteIntE")
//</editor-fold>
public static class ConcreteInt extends /*public*/ NonLoc {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 343,
   FQN="clang::ento::nonloc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento6nonloc11ConcreteIntC1ERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteIntC1ERKN4llvm6APSIntE")
  //</editor-fold>
  public /*explicit*/ ConcreteInt(final /*const*/ APSInt /*&*/ V) {
    // : NonLoc(ConcreteIntKind, &V) 
    //START JInit
    super(Kind.ConcreteIntKind.getValue(), $AddrOf(V));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 345,
   FQN="clang::ento::nonloc::ConcreteInt::getValue", NM="_ZNK5clang4ento6nonloc11ConcreteInt8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc11ConcreteInt8getValueEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getValue() /*const*/ {
    return $Deref(((/*static_cast*//*const*/ APSInt /*P*/ )(Data)));
  }

  
  // Transfer functions for binary/unary operations on ConcreteInts.
  
  // Transfer functions for binary/unary operations on ConcreteInts.
  
  //===----------------------------------------------------------------------===//
  // Transfer function dispatch for Non-Locs.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::evalBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 195,
   FQN="clang::ento::nonloc::ConcreteInt::evalBinOp", NM="_ZNK5clang4ento6nonloc11ConcreteInt9evalBinOpERNS0_11SValBuilderENS_18BinaryOperatorKindERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc11ConcreteInt9evalBinOpERNS0_11SValBuilderENS_18BinaryOperatorKindERKS2_")
  //</editor-fold>
  public SVal evalBinOp(final SValBuilder /*&*/ svalBuilder, 
           BinaryOperatorKind Op, 
           final /*const*/NsNonloc.ConcreteInt/*&*/ R) /*const*/ {
    /*const*/ APSInt /*P*/ X = svalBuilder.getBasicValueFactory().evalAPSInt(Op, getValue(), R.getValue());
    if ((X != null)) {
      return new SVal(JD$Move.INSTANCE, new NsNonloc.ConcreteInt($Deref(X)));
    } else {
      return new SVal(JD$Move.INSTANCE, new UndefinedVal());
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::evalComplement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 207,
   FQN="clang::ento::nonloc::ConcreteInt::evalComplement", NM="_ZNK5clang4ento6nonloc11ConcreteInt14evalComplementERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc11ConcreteInt14evalComplementERNS0_11SValBuilderE")
  //</editor-fold>
  public NsNonloc.ConcreteInt evalComplement(final SValBuilder /*&*/ svalBuilder) /*const*/ {
    return svalBuilder.makeIntVal(getValue().$bitnot());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::evalMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 212,
   FQN="clang::ento::nonloc::ConcreteInt::evalMinus", NM="_ZNK5clang4ento6nonloc11ConcreteInt9evalMinusERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc11ConcreteInt9evalMinusERNS0_11SValBuilderE")
  //</editor-fold>
  public NsNonloc.ConcreteInt evalMinus(final SValBuilder /*&*/ svalBuilder) /*const*/ {
    return svalBuilder.makeIntVal(getValue().$sub());
  }


/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 359,
   FQN="clang::ento::nonloc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento6nonloc11ConcreteIntC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteIntC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ ConcreteInt() {
    // : NonLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 360,
   FQN="clang::ento::nonloc::ConcreteInt::isKind", NM="_ZN5clang4ento6nonloc11ConcreteInt6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteInt6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.NonLocKind
       && V.getSubKind() == Kind.ConcreteIntKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 365,
   FQN="clang::ento::nonloc::ConcreteInt::isKind", NM="_ZN5clang4ento6nonloc11ConcreteInt6isKindERKNS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteInt6isKindERKNS0_6NonLocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ NonLoc /*&*/ V) {
    return V.getSubKind() == Kind.ConcreteIntKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 341,
   FQN="clang::ento::nonloc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento6nonloc11ConcreteIntC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteIntC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ConcreteInt(final /*const*/ ConcreteInt /*&*/ $Prm0) {
    // : NonLoc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 341,
   FQN="clang::ento::nonloc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento6nonloc11ConcreteIntC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11ConcreteIntC1EOS2_")
  //</editor-fold>
  public /*inline*/ ConcreteInt(JD$Move _dparam, final ConcreteInt /*&&*/$Prm0) {
    // : NonLoc(static_cast<ConcreteInt &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public ConcreteInt clone() {
    assert this.getClass() == ConcreteInt.class : "Why not overridden in " + this.getClass();
    return new ConcreteInt(this);
  }

  @Override
  public ConcreteInt move() {
    assert this.getClass() == ConcreteInt.class : "Why not overridden in " + this.getClass();
    return new ConcreteInt(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 370,
 FQN="clang::ento::nonloc::LocAsInteger", NM="_ZN5clang4ento6nonloc12LocAsIntegerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsIntegerE")
//</editor-fold>
public static class LocAsInteger extends /*public*/ NonLoc {
  /*friend  class ento::SValBuilder*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::LocAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 373,
   FQN="clang::ento::nonloc::LocAsInteger::LocAsInteger", NM="_ZN5clang4ento6nonloc12LocAsIntegerC1ERKSt4pairINS0_4SValEjE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsIntegerC1ERKSt4pairINS0_4SValEjE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ LocAsInteger(final /*const*/std.pairTypeUInt<SVal> /*&*/ data) {
    // : NonLoc(LocAsIntegerKind, &data) 
    //START JInit
    super(Kind.LocAsIntegerKind.getValue(), $AddrOf(data));
    //END JInit
    assert ((data.first.getAs(Loc.class)).$bool());
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 380,
   FQN="clang::ento::nonloc::LocAsInteger::getLoc", NM="_ZNK5clang4ento6nonloc12LocAsInteger6getLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc12LocAsInteger6getLocEv")
  //</editor-fold>
  public Loc getLoc() /*const*/ {
    /*const*/std.pairTypeUInt<SVal> /*P*/ D = ((/*static_cast*//*const*/std.pairTypeUInt<SVal> /*P*/)(Data));
    return D.first.castAs(Loc.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::getPersistentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 386,
   FQN="clang::ento::nonloc::LocAsInteger::getPersistentLoc", NM="_ZNK5clang4ento6nonloc12LocAsInteger16getPersistentLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc12LocAsInteger16getPersistentLocEv")
  //</editor-fold>
  public Loc getPersistentLoc() /*const*/ {
    /*const*/std.pairTypeUInt<SVal> /*P*/ D = ((/*static_cast*//*const*/std.pairTypeUInt<SVal> /*P*/)(Data));
    final /*const*/ SVal /*&*/ V = D.first;
    return V.castAs(Loc.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::getNumBits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 393,
   FQN="clang::ento::nonloc::LocAsInteger::getNumBits", NM="_ZNK5clang4ento6nonloc12LocAsInteger10getNumBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc12LocAsInteger10getNumBitsEv")
  //</editor-fold>
  public /*uint*/int getNumBits() /*const*/ {
    /*const*/std.pairTypeUInt<SVal> /*P*/ D = ((/*static_cast*//*const*/std.pairTypeUInt<SVal> /*P*/)(Data));
    return (int) D.second;
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::LocAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 401,
   FQN="clang::ento::nonloc::LocAsInteger::LocAsInteger", NM="_ZN5clang4ento6nonloc12LocAsIntegerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsIntegerC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ LocAsInteger() {
    // : NonLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 402,
   FQN="clang::ento::nonloc::LocAsInteger::isKind", NM="_ZN5clang4ento6nonloc12LocAsInteger6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsInteger6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.NonLocKind
       && V.getSubKind() == Kind.LocAsIntegerKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 407,
   FQN="clang::ento::nonloc::LocAsInteger::isKind", NM="_ZN5clang4ento6nonloc12LocAsInteger6isKindERKNS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsInteger6isKindERKNS0_6NonLocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ NonLoc /*&*/ V) {
    return V.getSubKind() == Kind.LocAsIntegerKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::LocAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 370,
   FQN="clang::ento::nonloc::LocAsInteger::LocAsInteger", NM="_ZN5clang4ento6nonloc12LocAsIntegerC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsIntegerC1ERKS2_")
  //</editor-fold>
  public /*inline*/ LocAsInteger(final /*const*/ LocAsInteger /*&*/ $Prm0) {
    // : NonLoc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LocAsInteger::LocAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 370,
   FQN="clang::ento::nonloc::LocAsInteger::LocAsInteger", NM="_ZN5clang4ento6nonloc12LocAsIntegerC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc12LocAsIntegerC1EOS2_")
  //</editor-fold>
  public /*inline*/ LocAsInteger(JD$Move _dparam, final LocAsInteger /*&&*/$Prm0) {
    // : NonLoc(static_cast<LocAsInteger &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public LocAsInteger clone() {
    assert this.getClass() == LocAsInteger.class : "Why not overridden in " + this.getClass();
    return new LocAsInteger(this);
  }

  @Override
  public LocAsInteger move() {
    assert this.getClass() == LocAsInteger.class : "Why not overridden in " + this.getClass();
    return new LocAsInteger(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  ////////////////////////////////////////////////////////////// 
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 412,
 FQN="clang::ento::nonloc::CompoundVal", NM="_ZN5clang4ento6nonloc11CompoundValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundValE")
//</editor-fold>
public static class CompoundVal extends /*public*/ NonLoc {
  /*friend  class ento::SValBuilder*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::CompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 415,
   FQN="clang::ento::nonloc::CompoundVal::CompoundVal", NM="_ZN5clang4ento6nonloc11CompoundValC1EPKNS0_15CompoundValDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundValC1EPKNS0_15CompoundValDataE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ CompoundVal(/*const*/ CompoundValData /*P*/ D) {
    // : NonLoc(CompoundValKind, D) 
    //START JInit
    super(Kind.CompoundValKind.getValue(), D);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 418,
   FQN="clang::ento::nonloc::CompoundVal::getValue", NM="_ZNK5clang4ento6nonloc11CompoundVal8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc11CompoundVal8getValueEv")
  //</editor-fold>
  public /*const*/ CompoundValData /*P*/ getValue() /*const*/ {
    return ((/*static_cast*//*const*/ CompoundValData /*P*/ )(Data));
  }

  
  /*typedef llvm::ImmutableList<SVal>::iterator iterator*/
//  public final class iterator extends ImmutableList.iterator<SVal>{ };
  
  //===----------------------------------------------------------------------===//
  // Other Iterators.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 162,
   FQN="clang::ento::nonloc::CompoundVal::begin", NM="_ZNK5clang4ento6nonloc11CompoundVal5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc11CompoundVal5beginEv")
  //</editor-fold>
  public ImmutableList.iterator<SVal> begin() /*const*/ {
    return getValue().begin();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 166,
   FQN="clang::ento::nonloc::CompoundVal::end", NM="_ZNK5clang4ento6nonloc11CompoundVal3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc11CompoundVal3endEv")
  //</editor-fold>
  public ImmutableList.iterator<SVal> end() /*const*/ {
    return getValue().end();
  }


/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::CompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 428,
   FQN="clang::ento::nonloc::CompoundVal::CompoundVal", NM="_ZN5clang4ento6nonloc11CompoundValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundValC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ CompoundVal() {
    // : NonLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 429,
   FQN="clang::ento::nonloc::CompoundVal::isKind", NM="_ZN5clang4ento6nonloc11CompoundVal6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundVal6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.NonLocKind && V.getSubKind() == Kind.CompoundValKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 433,
   FQN="clang::ento::nonloc::CompoundVal::isKind", NM="_ZN5clang4ento6nonloc11CompoundVal6isKindERKNS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundVal6isKindERKNS0_6NonLocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ NonLoc /*&*/ V) {
    return V.getSubKind() == Kind.CompoundValKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::CompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 412,
   FQN="clang::ento::nonloc::CompoundVal::CompoundVal", NM="_ZN5clang4ento6nonloc11CompoundValC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundValC1ERKS2_")
  //</editor-fold>
  public /*inline*/ CompoundVal(final /*const*/ CompoundVal /*&*/ $Prm0) {
    // : NonLoc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::CompoundVal::CompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 412,
   FQN="clang::ento::nonloc::CompoundVal::CompoundVal", NM="_ZN5clang4ento6nonloc11CompoundValC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc11CompoundValC1EOS2_")
  //</editor-fold>
  public /*inline*/ CompoundVal(JD$Move _dparam, final CompoundVal /*&&*/$Prm0) {
    // : NonLoc(static_cast<CompoundVal &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public CompoundVal clone() {
    assert this.getClass() == CompoundVal.class : "Why not overridden in " + this.getClass();
    return new CompoundVal(this);
  }

  @Override
  public CompoundVal move() {
    assert this.getClass() == CompoundVal.class : "Why not overridden in " + this.getClass();
    return new CompoundVal(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 438,
 FQN="clang::ento::nonloc::LazyCompoundVal", NM="_ZN5clang4ento6nonloc15LazyCompoundValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundValE")
//</editor-fold>
public static class LazyCompoundVal extends /*public*/ NonLoc {
  /*friend  class ento::SValBuilder*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 441,
   FQN="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal", NM="_ZN5clang4ento6nonloc15LazyCompoundValC1EPKNS0_19LazyCompoundValDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundValC1EPKNS0_19LazyCompoundValDataE")
  //</editor-fold>
   /*friend*/public/*private*/ /*explicit*/ LazyCompoundVal(/*const*/ LazyCompoundValData /*P*/ D) {
    // : NonLoc(LazyCompoundValKind, D) 
    //START JInit
    super(Kind.LazyCompoundValKind.getValue(), D);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::getCVData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 444,
   FQN="clang::ento::nonloc::LazyCompoundVal::getCVData", NM="_ZNK5clang4ento6nonloc15LazyCompoundVal9getCVDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento6nonloc15LazyCompoundVal9getCVDataEv")
  //</editor-fold>
  public /*const*/ LazyCompoundValData /*P*/ getCVData() /*const*/ {
    return ((/*static_cast*//*const*/ LazyCompoundValData /*P*/ )(Data));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::getStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 150,
   FQN="clang::ento::nonloc::LazyCompoundVal::getStore", NM="_ZNK5clang4ento6nonloc15LazyCompoundVal8getStoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc15LazyCompoundVal8getStoreEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getStore() /*const*/ {
    return ((/*static_cast*//*const*/ LazyCompoundValData /*P*/ )(Data)).getStore();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 154,
   FQN="clang::ento::nonloc::LazyCompoundVal::getRegion", NM="_ZNK5clang4ento6nonloc15LazyCompoundVal9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento6nonloc15LazyCompoundVal9getRegionEv")
  //</editor-fold>
  public /*const*/ TypedValueRegion /*P*/ getRegion() /*const*/ {
    return ((/*static_cast*//*const*/ LazyCompoundValData /*P*/ )(Data)).getRegion();
  }


/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 452,
   FQN="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal", NM="_ZN5clang4ento6nonloc15LazyCompoundValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundValC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ LazyCompoundVal() {
    // : NonLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 453,
   FQN="clang::ento::nonloc::LazyCompoundVal::isKind", NM="_ZN5clang4ento6nonloc15LazyCompoundVal6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundVal6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.NonLocKind
       && V.getSubKind() == Kind.LazyCompoundValKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 457,
   FQN="clang::ento::nonloc::LazyCompoundVal::isKind", NM="_ZN5clang4ento6nonloc15LazyCompoundVal6isKindERKNS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundVal6isKindERKNS0_6NonLocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ NonLoc /*&*/ V) {
    return V.getSubKind() == Kind.LazyCompoundValKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 438,
   FQN="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal", NM="_ZN5clang4ento6nonloc15LazyCompoundValC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundValC1ERKS2_")
  //</editor-fold>
  public /*inline*/ LazyCompoundVal(final /*const*/ LazyCompoundVal /*&*/ $Prm0) {
    // : NonLoc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 438,
   FQN="clang::ento::nonloc::LazyCompoundVal::LazyCompoundVal", NM="_ZN5clang4ento6nonloc15LazyCompoundValC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento6nonloc15LazyCompoundValC1EOS2_")
  //</editor-fold>
  public /*inline*/ LazyCompoundVal(JD$Move _dparam, final LazyCompoundVal /*&&*/$Prm0) {
    // : NonLoc(static_cast<LazyCompoundVal &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public LazyCompoundVal clone() {
    assert this.getClass() == LazyCompoundVal.class : "Why not overridden in " + this.getClass();
    return new LazyCompoundVal(this);
  }

  @Override
  public LazyCompoundVal move() {
    assert this.getClass() == LazyCompoundVal.class : "Why not overridden in " + this.getClass();
    return new LazyCompoundVal(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class NsNonloc
