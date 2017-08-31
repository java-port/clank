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

package org.clang.analysis.consumed.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.consumed.*;
import static org.clang.analysis.impl.ConsumedStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 290,
 FQN="clang::consumed::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoE")
//</editor-fold>
public class PropagationInfo implements NativeCloneable<PropagationInfo> {
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 291,
   FQN="clang::consumed::PropagationInfo::(anonymous)", NM="_ZN5clang8consumed15PropagationInfoE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    IT_None(0),
    IT_State(IT_None.getValue() + 1),
    IT_VarTest(IT_State.getValue() + 1),
    IT_BinTest(IT_VarTest.getValue() + 1),
    IT_Var(IT_BinTest.getValue() + 1),
    IT_Tmp(IT_Var.getValue() + 1);

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
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  private Unnamed_enum InfoType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::BinTestTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 300,
   FQN="clang::consumed::PropagationInfo::BinTestTy", NM="_ZN5clang8consumed15PropagationInfo9BinTestTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfo9BinTestTyE")
  //</editor-fold>
  private static class/*struct*/ BinTestTy {
    public /*const*/ BinaryOperator /*P*/ Source;
    public EffectiveOp EOp;
    public VarTestResult LTest;
    public VarTestResult RTest;
    //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::BinTestTy::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 300,
     FQN="clang::consumed::PropagationInfo::BinTestTy::operator=", NM="_ZN5clang8consumed15PropagationInfo9BinTestTyaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfo9BinTestTyaSEOS2_")
    //</editor-fold>
    public /*inline*/ BinTestTy /*&*/ $assignMove(final BinTestTy /*&&*/$Prm0) {
      this.Source = $Prm0.Source;
      this.EOp = $Prm0.EOp;
      this.LTest.$assignMove($Prm0.LTest);
      this.RTest.$assignMove($Prm0.RTest);
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Source=" + Source // NOI18N
                + ", EOp=" + EOp // NOI18N
                + ", LTest=" + LTest // NOI18N
                + ", RTest=" + RTest; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 307,
   FQN="clang::consumed::PropagationInfo::(anonymous)", NM="_ZN5clang8consumed15PropagationInfoE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoE_Unnamed_union2")
  //</editor-fold>
  private static class/*union*/ Unnamed_union2 {
    public ConsumedState State;
    public VarTestResult VarTest;
    public /*const*/ VarDecl /*P*/ Var;
    public /*const*/ CXXBindTemporaryExpr /*P*/ Tmp;
    public BinTestTy BinTest;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public Unnamed_union2() {}
    
    //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 307,
     FQN="clang::consumed::PropagationInfo::(anonymous union)::", NM="_ZN5clang8consumed15PropagationInfoUt0_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoUt0_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(final Unnamed_union2 $Prm0) {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 307,
     FQN="clang::consumed::PropagationInfo::(anonymous union)::", NM="_ZN5clang8consumed15PropagationInfoUt0_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoUt0_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(JD$Move _dparam, final Unnamed_union2 $Prm0) {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 307,
     FQN="clang::consumed::PropagationInfo::(anonymous union)::operator=", NM="_ZN5clang8consumed15PropagationInfoUt0_aSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoUt0_aSEOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2 $assignMove(final Unnamed_union2 $Prm0) {
      
      this.State = $Prm0.State;
      
      this.VarTest.$assignMove($Prm0.VarTest);
      
      this.Var = $Prm0.Var;
      
      this.Tmp = $Prm0.Tmp;
      
      this.BinTest.$assignMove($Prm0.BinTest);
      
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "State=" + State // NOI18N
                + ", VarTest=" + VarTest // NOI18N
                + ", Var=" + Var // NOI18N
                + ", Tmp=" + Tmp // NOI18N
                + ", BinTest=" + BinTest; // NOI18N
    }
  };
  private Unnamed_union2 Unnamed_field1 = new Unnamed_union2();
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 316,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1Ev")
  //</editor-fold>
  public PropagationInfo() {
    // : InfoType(IT_None) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_None;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 318,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1ERKN12_GLOBAL__N_113VarTestResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1ERKN12_GLOBAL__N_113VarTestResultE")
  //</editor-fold>
  public PropagationInfo(final /*const*/ VarTestResult /*&*/ VarTest) {
    // : InfoType(IT_VarTest), VarTest(VarTest) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_VarTest;
    /*Indirect*/this.Unnamed_field1.VarTest = new VarTestResult(VarTest);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 321,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1EPKNS_7VarDeclENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1EPKNS_7VarDeclENS0_13ConsumedStateE")
  //</editor-fold>
  public PropagationInfo(/*const*/ VarDecl /*P*/ Var, ConsumedState TestsFor) {
    // : InfoType(IT_VarTest) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_VarTest;
    //END JInit
    
    Unnamed_field1.VarTest.Var = Var;
    Unnamed_field1.VarTest.TestsFor = TestsFor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 328,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1EPKNS_14BinaryOperatorENS0_11EffectiveOpERKN12_GLOBAL__N_113VarTestResultES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1EPKNS_14BinaryOperatorENS0_11EffectiveOpERKN12_GLOBAL__N_113VarTestResultES9_")
  //</editor-fold>
  public PropagationInfo(/*const*/ BinaryOperator /*P*/ Source, EffectiveOp EOp, 
      final /*const*/ VarTestResult /*&*/ LTest, final /*const*/ VarTestResult /*&*/ RTest) {
    // : InfoType(IT_BinTest) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_BinTest;
    //END JInit
    
    Unnamed_field1.BinTest.Source = Source;
    Unnamed_field1.BinTest.EOp = EOp;
    Unnamed_field1.BinTest.LTest.$assign(LTest);
    Unnamed_field1.BinTest.RTest.$assign(RTest);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 338,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1EPKNS_14BinaryOperatorENS0_11EffectiveOpEPKNS_7VarDeclENS0_13ConsumedStateES8_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1EPKNS_14BinaryOperatorENS0_11EffectiveOpEPKNS_7VarDeclENS0_13ConsumedStateES8_S9_")
  //</editor-fold>
  public PropagationInfo(/*const*/ BinaryOperator /*P*/ Source, EffectiveOp EOp, 
      /*const*/ VarDecl /*P*/ LVar, ConsumedState LTestsFor, 
      /*const*/ VarDecl /*P*/ RVar, ConsumedState RTestsFor) {
    // : InfoType(IT_BinTest) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_BinTest;
    //END JInit
    
    Unnamed_field1.BinTest.Source = Source;
    Unnamed_field1.BinTest.EOp = EOp;
    Unnamed_field1.BinTest.LTest.Var = LVar;
    Unnamed_field1.BinTest.LTest.TestsFor = LTestsFor;
    Unnamed_field1.BinTest.RTest.Var = RVar;
    Unnamed_field1.BinTest.RTest.TestsFor = RTestsFor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 351,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1ENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1ENS0_13ConsumedStateE")
  //</editor-fold>
  public PropagationInfo(ConsumedState State) {
    // : InfoType(IT_State), State(State) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_State;
    /*Indirect*/this.Unnamed_field1.State = State;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 354,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1EPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1EPKNS_7VarDeclE")
  //</editor-fold>
  public PropagationInfo(/*const*/ VarDecl /*P*/ Var) {
    // : InfoType(IT_Var), Var(Var) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_Var;
    /*Indirect*/this.Unnamed_field1.Var = Var;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 355,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1EPKNS_20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1EPKNS_20CXXBindTemporaryExprE")
  //</editor-fold>
  public PropagationInfo(/*const*/ CXXBindTemporaryExpr /*P*/ Tmp) {
    // : InfoType(IT_Tmp), Tmp(Tmp) 
    //START JInit
    this.InfoType = Unnamed_enum.IT_Tmp;
    /*Indirect*/this.Unnamed_field1.Tmp = Tmp;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 358,
   FQN="clang::consumed::PropagationInfo::getState", NM="_ZNK5clang8consumed15PropagationInfo8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo8getStateEv")
  //</editor-fold>
  public /*const*/ ConsumedState /*&*/ getState() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_State);
    return Unnamed_field1.State;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getVarTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 363,
   FQN="clang::consumed::PropagationInfo::getVarTest", NM="_ZNK5clang8consumed15PropagationInfo10getVarTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo10getVarTestEv")
  //</editor-fold>
  public /*const*/ VarTestResult /*&*/ getVarTest() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_VarTest);
    return Unnamed_field1.VarTest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getLTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 368,
   FQN="clang::consumed::PropagationInfo::getLTest", NM="_ZNK5clang8consumed15PropagationInfo8getLTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo8getLTestEv")
  //</editor-fold>
  public /*const*/ VarTestResult /*&*/ getLTest() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_BinTest);
    return Unnamed_field1.BinTest.LTest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getRTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 373,
   FQN="clang::consumed::PropagationInfo::getRTest", NM="_ZNK5clang8consumed15PropagationInfo8getRTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo8getRTestEv")
  //</editor-fold>
  public /*const*/ VarTestResult /*&*/ getRTest() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_BinTest);
    return Unnamed_field1.BinTest.RTest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 378,
   FQN="clang::consumed::PropagationInfo::getVar", NM="_ZNK5clang8consumed15PropagationInfo6getVarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo6getVarEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getVar() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_Var);
    return Unnamed_field1.Var;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getTmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 383,
   FQN="clang::consumed::PropagationInfo::getTmp", NM="_ZNK5clang8consumed15PropagationInfo6getTmpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo6getTmpEv")
  //</editor-fold>
  public /*const*/ CXXBindTemporaryExpr /*P*/ getTmp() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_Tmp);
    return Unnamed_field1.Tmp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::getAsState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 388,
   FQN="clang::consumed::PropagationInfo::getAsState", NM="_ZNK5clang8consumed15PropagationInfo10getAsStateEPKNS0_16ConsumedStateMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo10getAsStateEPKNS0_16ConsumedStateMapE")
  //</editor-fold>
  public ConsumedState getAsState(/*const*/ ConsumedStateMap /*P*/ StateMap) /*const*/ {
    assert (isVar() || isTmp() || isState());
    if (isVar()) {
      return StateMap.getState(Unnamed_field1.Var);
    } else if (isTmp()) {
      return StateMap.getState(Unnamed_field1.Tmp);
    } else if (isState()) {
      return Unnamed_field1.State;
    } else {
      return ConsumedState.CS_None;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::testEffectiveOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 401,
   FQN="clang::consumed::PropagationInfo::testEffectiveOp", NM="_ZNK5clang8consumed15PropagationInfo15testEffectiveOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo15testEffectiveOpEv")
  //</editor-fold>
  public EffectiveOp testEffectiveOp() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_BinTest);
    return Unnamed_field1.BinTest.EOp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::testSourceNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 406,
   FQN="clang::consumed::PropagationInfo::testSourceNode", NM="_ZNK5clang8consumed15PropagationInfo14testSourceNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo14testSourceNodeEv")
  //</editor-fold>
  public /*const*/ BinaryOperator /*P*/ testSourceNode() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_BinTest);
    return Unnamed_field1.BinTest.Source;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 411,
   FQN="clang::consumed::PropagationInfo::isValid", NM="_ZNK5clang8consumed15PropagationInfo7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo7isValidEv")
  //</editor-fold>
  public /*inline*/ boolean isValid() /*const*/ {
    return InfoType != Unnamed_enum.IT_None;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 412,
   FQN="clang::consumed::PropagationInfo::isState", NM="_ZNK5clang8consumed15PropagationInfo7isStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo7isStateEv")
  //</editor-fold>
  public /*inline*/ boolean isState() /*const*/ {
    return InfoType == Unnamed_enum.IT_State;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isVarTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 413,
   FQN="clang::consumed::PropagationInfo::isVarTest", NM="_ZNK5clang8consumed15PropagationInfo9isVarTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo9isVarTestEv")
  //</editor-fold>
  public /*inline*/ boolean isVarTest() /*const*/ {
    return InfoType == Unnamed_enum.IT_VarTest;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isBinTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 414,
   FQN="clang::consumed::PropagationInfo::isBinTest", NM="_ZNK5clang8consumed15PropagationInfo9isBinTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo9isBinTestEv")
  //</editor-fold>
  public /*inline*/ boolean isBinTest() /*const*/ {
    return InfoType == Unnamed_enum.IT_BinTest;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 415,
   FQN="clang::consumed::PropagationInfo::isVar", NM="_ZNK5clang8consumed15PropagationInfo5isVarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo5isVarEv")
  //</editor-fold>
  public /*inline*/ boolean isVar() /*const*/ {
    return InfoType == Unnamed_enum.IT_Var;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isTmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 416,
   FQN="clang::consumed::PropagationInfo::isTmp", NM="_ZNK5clang8consumed15PropagationInfo5isTmpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo5isTmpEv")
  //</editor-fold>
  public /*inline*/ boolean isTmp() /*const*/ {
    return InfoType == Unnamed_enum.IT_Tmp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 418,
   FQN="clang::consumed::PropagationInfo::isTest", NM="_ZNK5clang8consumed15PropagationInfo6isTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo6isTestEv")
  //</editor-fold>
  public boolean isTest() /*const*/ {
    return InfoType == Unnamed_enum.IT_VarTest || InfoType == Unnamed_enum.IT_BinTest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::isPointerToValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 422,
   FQN="clang::consumed::PropagationInfo::isPointerToValue", NM="_ZNK5clang8consumed15PropagationInfo16isPointerToValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo16isPointerToValueEv")
  //</editor-fold>
  public boolean isPointerToValue() /*const*/ {
    return InfoType == Unnamed_enum.IT_Var || InfoType == Unnamed_enum.IT_Tmp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::invertTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 426,
   FQN="clang::consumed::PropagationInfo::invertTest", NM="_ZNK5clang8consumed15PropagationInfo10invertTestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZNK5clang8consumed15PropagationInfo10invertTestEv")
  //</editor-fold>
  public PropagationInfo invertTest() /*const*/ {
    assert (InfoType == Unnamed_enum.IT_VarTest || InfoType == Unnamed_enum.IT_BinTest);
    if (InfoType == Unnamed_enum.IT_VarTest) {
      return new PropagationInfo(Unnamed_field1.VarTest.Var, 
          invertConsumedUnconsumed(Unnamed_field1.VarTest.TestsFor));
    } else if (InfoType == Unnamed_enum.IT_BinTest) {
      return new PropagationInfo(Unnamed_field1.BinTest.Source, 
          Unnamed_field1.BinTest.EOp == EffectiveOp.EO_And ? EffectiveOp.EO_Or : EffectiveOp.EO_And, 
          Unnamed_field1.BinTest.LTest.Var, invertConsumedUnconsumed(Unnamed_field1.BinTest.LTest.TestsFor), 
          Unnamed_field1.BinTest.RTest.Var, invertConsumedUnconsumed(Unnamed_field1.BinTest.RTest.TestsFor));
    } else {
      return new PropagationInfo();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 290,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PropagationInfo(final /*const*/ PropagationInfo /*&*/ $Prm0) {
    // : InfoType(.InfoType), Unnamed_field1(.) 
    //START JInit
    this.InfoType = $Prm0.InfoType;
    this.Unnamed_field1 = new Unnamed_union2($Prm0.Unnamed_field1);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::PropagationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 290,
   FQN="clang::consumed::PropagationInfo::PropagationInfo", NM="_ZN5clang8consumed15PropagationInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ PropagationInfo(JD$Move _dparam, final PropagationInfo /*&&*/$Prm0) {
    // : InfoType(static_cast<PropagationInfo &&>().InfoType), Unnamed_field1(static_cast<PropagationInfo &&>().) 
    //START JInit
    this.InfoType = $Prm0.InfoType;
    this.Unnamed_field1 = new Unnamed_union2(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::PropagationInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 290,
   FQN="clang::consumed::PropagationInfo::operator=", NM="_ZN5clang8consumed15PropagationInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed15PropagationInfoaSEOS1_")
  //</editor-fold>
  public /*inline*/ PropagationInfo /*&*/ $assignMove(final PropagationInfo /*&&*/$Prm0) {
    this.InfoType = $Prm0.InfoType;
    this.Unnamed_field1.$assignMove($Prm0.Unnamed_field1);
    return /*Deref*/this;
  }

  @Override
  public PropagationInfo clone() {
    return new PropagationInfo(this);
  }
  
  @Override public String toString() {
    return "" + "InfoType=" + InfoType // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
  }
}
