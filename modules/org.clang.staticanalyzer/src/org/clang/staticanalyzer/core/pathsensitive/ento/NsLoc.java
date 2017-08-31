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
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type NsLoc">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZN5clang4ento3loc11ConcreteIntE;_ZN5clang4ento3loc12MemRegionValE;_ZN5clang4ento3loc4KindE;_ZN5clang4ento3loc9GotoLabelE; -static-type=NsLoc -package=org.clang.staticanalyzer.core.pathsensitive.ento")
//</editor-fold>
public final class NsLoc {

//<editor-fold defaultstate="collapsed" desc="clang::ento::loc::Kind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 470,
 FQN="clang::ento::loc::Kind", NM="_ZN5clang4ento3loc4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc4KindE")
//</editor-fold>
public enum Kind implements Native.ComparableLower {
  ConcreteIntKind(0),
  GotoLabelKind(ConcreteIntKind.getValue() + 1),
  MemRegionValKind(GotoLabelKind.getValue() + 1);

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
//<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 475,
 FQN="clang::ento::loc::GotoLabel", NM="_ZN5clang4ento3loc9GotoLabelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabelE")
//</editor-fold>
public static class GotoLabel extends /*public*/ Loc {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::GotoLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 477,
   FQN="clang::ento::loc::GotoLabel::GotoLabel", NM="_ZN5clang4ento3loc9GotoLabelC1EPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabelC1EPNS_9LabelDeclE")
  //</editor-fold>
  public /*explicit*/ GotoLabel(LabelDecl /*P*/ Label) {
    // : Loc(GotoLabelKind, Label) 
    //START JInit
    super(Kind.GotoLabelKind.getValue(), Label);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 479,
   FQN="clang::ento::loc::GotoLabel::getLabel", NM="_ZNK5clang4ento3loc9GotoLabel8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento3loc9GotoLabel8getLabelEv")
  //</editor-fold>
  public /*const*/ LabelDecl /*P*/ getLabel() /*const*/ {
    return ((/*static_cast*//*const*/ LabelDecl /*P*/ )(Data));
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::GotoLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 485,
   FQN="clang::ento::loc::GotoLabel::GotoLabel", NM="_ZN5clang4ento3loc9GotoLabelC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabelC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ GotoLabel() {
    // : Loc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 486,
   FQN="clang::ento::loc::GotoLabel::isKind", NM="_ZN5clang4ento3loc9GotoLabel6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabel6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.LocKind && V.getSubKind() == Kind.GotoLabelKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 490,
   FQN="clang::ento::loc::GotoLabel::isKind", NM="_ZN5clang4ento3loc9GotoLabel6isKindERKNS0_3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabel6isKindERKNS0_3LocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ Loc /*&*/ V) {
    return V.getSubKind() == Kind.GotoLabelKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::GotoLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 475,
   FQN="clang::ento::loc::GotoLabel::GotoLabel", NM="_ZN5clang4ento3loc9GotoLabelC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabelC1ERKS2_")
  //</editor-fold>
  public /*inline*/ GotoLabel(final /*const*/ GotoLabel /*&*/ $Prm0) {
    // : Loc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::GotoLabel::GotoLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 475,
   FQN="clang::ento::loc::GotoLabel::GotoLabel", NM="_ZN5clang4ento3loc9GotoLabelC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc9GotoLabelC1EOS2_")
  //</editor-fold>
  public /*inline*/ GotoLabel(JD$Move _dparam, final GotoLabel /*&&*/$Prm0) {
    // : Loc(static_cast<GotoLabel &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public GotoLabel clone() {
    assert this.getClass() == GotoLabel.class : "Why not overridden in " + this.getClass();
    return new GotoLabel(this);
  }

  @Override
  public GotoLabel move() {
    assert this.getClass() == GotoLabel.class : "Why not overridden in " + this.getClass();
    return new GotoLabel(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 496,
 FQN="clang::ento::loc::MemRegionVal", NM="_ZN5clang4ento3loc12MemRegionValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionValE")
//</editor-fold>
public static class MemRegionVal extends /*public*/ Loc implements Native.NativeComparable<SVal> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::MemRegionVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 498,
   FQN="clang::ento::loc::MemRegionVal::MemRegionVal", NM="_ZN5clang4ento3loc12MemRegionValC1EPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionValC1EPKNS0_9MemRegionE")
  //</editor-fold>
  public /*explicit*/ MemRegionVal(/*const*/ MemRegion /*P*/ r) {
    // : Loc(MemRegionValKind, r) 
    //START JInit
    super(Kind.MemRegionValKind.getValue(), r);
    //END JInit
  }

  
  /// \brief Get the underlining region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 501,
   FQN="clang::ento::loc::MemRegionVal::getRegion", NM="_ZNK5clang4ento3loc12MemRegionVal9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento3loc12MemRegionVal9getRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getRegion() /*const*/ {
    return ((/*static_cast*//*const*/ MemRegion /*P*/ )(Data));
  }

  
  /// \brief Get the underlining region and strip casts.
  
  /// \brief Get the underlining region and strip casts.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::stripCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 145,
   FQN="clang::ento::loc::MemRegionVal::stripCasts", NM="_ZNK5clang4ento3loc12MemRegionVal10stripCastsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento3loc12MemRegionVal10stripCastsEb")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ stripCasts() /*const*/ {
    return stripCasts(true);
  }
  public /*const*/ MemRegion /*P*/ stripCasts(boolean StripBaseCasts/*= true*/) /*const*/ {
    /*const*/ MemRegion /*P*/ R = getRegion();
    return (R != null) ? R.StripCasts(StripBaseCasts) : null;
  }


  
  /*template <typename REGION> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::getRegionAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 509,
   FQN="clang::ento::loc::MemRegionVal::getRegionAs", NM="Tpl__ZNK5clang4ento3loc12MemRegionVal11getRegionAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=Tpl__ZNK5clang4ento3loc12MemRegionVal11getRegionAsEv")
  //</editor-fold>
  public </*typename*/ REGION extends MemRegion> /*const*/ REGION /*P*/ getRegionAs(Class<REGION> clazz) /*const*/ {
    return dyn_cast(clazz, getRegion());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 513,
   FQN="clang::ento::loc::MemRegionVal::operator==", NM="_ZNK5clang4ento3loc12MemRegionValeqERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento3loc12MemRegionValeqERKS2_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ MemRegionVal /*&*/ R) /*const*/ {
    return getRegion() == R.getRegion();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 517,
   FQN="clang::ento::loc::MemRegionVal::operator!=", NM="_ZNK5clang4ento3loc12MemRegionValneERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento3loc12MemRegionValneERKS2_")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ MemRegionVal /*&*/ R) /*const*/ {
    return getRegion() != R.getRegion();
  }

/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::MemRegionVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 523,
   FQN="clang::ento::loc::MemRegionVal::MemRegionVal", NM="_ZN5clang4ento3loc12MemRegionValC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionValC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ MemRegionVal() {
    // : Loc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 524,
   FQN="clang::ento::loc::MemRegionVal::isKind", NM="_ZN5clang4ento3loc12MemRegionVal6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionVal6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.LocKind
       && V.getSubKind() == Kind.MemRegionValKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 529,
   FQN="clang::ento::loc::MemRegionVal::isKind", NM="_ZN5clang4ento3loc12MemRegionVal6isKindERKNS0_3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionVal6isKindERKNS0_3LocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ Loc /*&*/ V) {
    return V.getSubKind() == Kind.MemRegionValKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::MemRegionVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 496,
   FQN="clang::ento::loc::MemRegionVal::MemRegionVal", NM="_ZN5clang4ento3loc12MemRegionValC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionValC1ERKS2_")
  //</editor-fold>
  public /*inline*/ MemRegionVal(final /*const*/ MemRegionVal /*&*/ $Prm0) {
    // : Loc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::MemRegionVal::MemRegionVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 496,
   FQN="clang::ento::loc::MemRegionVal::MemRegionVal", NM="_ZN5clang4ento3loc12MemRegionValC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc12MemRegionValC1EOS2_")
  //</editor-fold>
  public /*inline*/ MemRegionVal(JD$Move _dparam, final MemRegionVal /*&&*/$Prm0) {
    // : Loc(static_cast<MemRegionVal &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public MemRegionVal clone() {
    assert this.getClass() == MemRegionVal.class : "Why not overridden in " + this.getClass();
    return new MemRegionVal(this);
  }

  @Override
  public MemRegionVal move() {
    assert this.getClass() == MemRegionVal.class : "Why not overridden in " + this.getClass();
    return new MemRegionVal(JD$Move.INSTANCE, this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 534,
 FQN="clang::ento::loc::ConcreteInt", NM="_ZN5clang4ento3loc11ConcreteIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteIntE")
//</editor-fold>
public static class ConcreteInt extends /*public*/ Loc {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 536,
   FQN="clang::ento::loc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento3loc11ConcreteIntC1ERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteIntC1ERKN4llvm6APSIntE")
  //</editor-fold>
  public /*explicit*/ ConcreteInt(final /*const*/ APSInt /*&*/ V) {
    // : Loc(ConcreteIntKind, &V) 
    //START JInit
    super(Kind.ConcreteIntKind.getValue(), $AddrOf(V));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 538,
   FQN="clang::ento::loc::ConcreteInt::getValue", NM="_ZNK5clang4ento3loc11ConcreteInt8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento3loc11ConcreteInt8getValueEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getValue() /*const*/ {
    return $Deref(((/*static_cast*//*const*/ APSInt /*P*/ )(Data)));
  }

  
  // Transfer functions for binary/unary operations on ConcreteInts.
  
  // Transfer functions for binary/unary operations on ConcreteInts.
  
  //===----------------------------------------------------------------------===//
  // Transfer function dispatch for Locs.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::evalBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp", line = 221,
   FQN="clang::ento::loc::ConcreteInt::evalBinOp", NM="_ZNK5clang4ento3loc11ConcreteInt9evalBinOpERNS0_17BasicValueFactoryENS_18BinaryOperatorKindERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp -nm=_ZNK5clang4ento3loc11ConcreteInt9evalBinOpERNS0_17BasicValueFactoryENS_18BinaryOperatorKindERKS2_")
  //</editor-fold>
  public SVal evalBinOp(final BasicValueFactory /*&*/ BasicVals, 
           BinaryOperatorKind Op, 
           final /*const*/NsLoc.ConcreteInt/*&*/ R) /*const*/ {
    assert (BinaryOperator.isComparisonOp(Op) || Op == BinaryOperatorKind.BO_Sub);
    
    /*const*/ APSInt /*P*/ X = BasicVals.evalAPSInt(Op, getValue(), R.getValue());
    if ((X != null)) {
      return new SVal(JD$Move.INSTANCE, new NsNonloc.ConcreteInt($Deref(X)));
    } else {
      return new SVal(JD$Move.INSTANCE, new UndefinedVal());
    }
  }


/*private:*/
  /*friend  class SVal*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 548,
   FQN="clang::ento::loc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento3loc11ConcreteIntC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteIntC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ ConcreteInt() {
    // : Loc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 549,
   FQN="clang::ento::loc::ConcreteInt::isKind", NM="_ZN5clang4ento3loc11ConcreteInt6isKindERKNS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteInt6isKindERKNS0_4SValE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ SVal /*&*/ V) {
    return V.getBaseKind() == BaseKind.LocKind
       && V.getSubKind() == Kind.ConcreteIntKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 554,
   FQN="clang::ento::loc::ConcreteInt::isKind", NM="_ZN5clang4ento3loc11ConcreteInt6isKindERKNS0_3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteInt6isKindERKNS0_3LocE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ Loc /*&*/ V) {
    return V.getSubKind() == Kind.ConcreteIntKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 534,
   FQN="clang::ento::loc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento3loc11ConcreteIntC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteIntC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ConcreteInt(final /*const*/ ConcreteInt /*&*/ $Prm0) {
    // : Loc() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::loc::ConcreteInt::ConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.h", line = 534,
   FQN="clang::ento::loc::ConcreteInt::ConcreteInt", NM="_ZN5clang4ento3loc11ConcreteIntC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento3loc11ConcreteIntC1EOS2_")
  //</editor-fold>
  public /*inline*/ ConcreteInt(JD$Move _dparam, final ConcreteInt /*&&*/$Prm0) {
    // : Loc(static_cast<ConcreteInt &&>()) 
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
} // END OF class NsLoc
