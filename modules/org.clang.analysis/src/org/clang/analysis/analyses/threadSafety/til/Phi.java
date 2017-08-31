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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// Phi Node, for code in SSA form.
/// Each Phi node has an array of possible values that it can take,
/// depending on where control flow comes from.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1298,
 FQN="clang::threadSafety::til::Phi", NM="_ZN5clang12threadSafety3til3PhiE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3PhiE")
//</editor-fold>
public class Phi extends /*public*/ SExpr {
/*public:*/
  /*typedef SimpleArray<SExpr *> ValArray*/
//  public final class ValArray extends SimpleArray<SExpr /*P*/ >{ };
  
  // In minimal SSA form, all Phi nodes are MultiVal.
  // During conversion to SSA, incomplete Phi nodes may be introduced, which
  // are later determined to be SingleVal, and are thus redundant.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1305,
   FQN="clang::threadSafety::til::Phi::Status", NM="_ZN5clang12threadSafety3til3Phi6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3Phi6StatusE")
  //</editor-fold>
  public enum Status implements Native.ComparableLower {
    PH_MultiVal(0), // Phi node has multiple distinct values.  (Normal)
    PH_SingleVal(PH_MultiVal.getValue() + 1), // Phi node has one distinct value, and can be eliminated
    PH_Incomplete(PH_SingleVal.getValue() + 1); // Phi node is incomplete

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Status valueOf(int val) {
      Status out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Status[] VALUES;
      private static final Status[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Status kind : Status.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Status[min < 0 ? (1-min) : 0];
        VALUES = new Status[max >= 0 ? (1+max) : 0];
        for (Status kind : Status.values()) {
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
    private Status(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Status)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Status)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1311,
   FQN="clang::threadSafety::til::Phi::classof", NM="_ZN5clang12threadSafety3til3Phi7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3Phi7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Phi;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::Phi">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1313,
   FQN="clang::threadSafety::til::Phi::Phi", NM="_ZN5clang12threadSafety3til3PhiC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3PhiC1Ev")
  //</editor-fold>
  public Phi() {
    // : SExpr(COP_Phi), Values(), Cvdecl(null) 
    //START JInit
    super(TIL_Opcode.COP_Phi);
    this._Values = new SimpleArray<SExpr /*P*/ >();
    this.Cvdecl = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::Phi">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1315,
   FQN="clang::threadSafety::til::Phi::Phi", NM="_ZN5clang12threadSafety3til3PhiC1ENS1_12MemRegionRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3PhiC1ENS1_12MemRegionRefEj")
  //</editor-fold>
  public Phi(MemRegionRef A, /*uint*/int Nvals) {
    // : SExpr(COP_Phi), Values(A, Nvals), Cvdecl(null) 
    //START JInit
    super(TIL_Opcode.COP_Phi);
    this._Values = new SimpleArray<SExpr /*P*/ >(new MemRegionRef(A), Nvals);
    this.Cvdecl = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::Phi">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1317,
   FQN="clang::threadSafety::til::Phi::Phi", NM="_ZN5clang12threadSafety3til3PhiC1ERKS2_ONS1_11SimpleArrayIPNS1_5SExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3PhiC1ERKS2_ONS1_11SimpleArrayIPNS1_5SExprEEE")
  //</editor-fold>
  public Phi(final /*const*/ Phi /*&*/ P, final SimpleArray<SExpr /*P*/ > /*&&*/Vs) {
    // : SExpr(P), Values(std::move(Vs)), Cvdecl(null) 
    //START JInit
    super(P);
    this._Values = new SimpleArray<SExpr /*P*/ >(JD$Move.INSTANCE, std.move(Vs));
    this.Cvdecl = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::values">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1320,
   FQN="clang::threadSafety::til::Phi::values", NM="_ZNK5clang12threadSafety3til3Phi6valuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til3Phi6valuesEv")
  //</editor-fold>
  public /*const*/ SimpleArray<SExpr /*P*/ > /*&*/ values$Const() /*const*/ {
    return _Values;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::values">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1321,
   FQN="clang::threadSafety::til::Phi::values", NM="_ZN5clang12threadSafety3til3Phi6valuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3Phi6valuesEv")
  //</editor-fold>
  public SimpleArray<SExpr /*P*/ > /*&*/ values() {
    return _Values;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1323,
   FQN="clang::threadSafety::til::Phi::status", NM="_ZNK5clang12threadSafety3til3Phi6statusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til3Phi6statusEv")
  //</editor-fold>
  public Status status() /*const*/ {
    return /*static_cast*/Status.valueOf(Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::setStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1324,
   FQN="clang::threadSafety::til::Phi::setStatus", NM="_ZN5clang12threadSafety3til3Phi9setStatusENS2_6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3Phi9setStatusENS2_6StatusE")
  //</editor-fold>
  public void setStatus(Status s) {
    Flags = $uint2ushort(s.getValue());
  }

  
  /// Return the clang declaration of the variable for this Phi node, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::clangDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1327,
   FQN="clang::threadSafety::til::Phi::clangDecl", NM="_ZNK5clang12threadSafety3til3Phi9clangDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til3Phi9clangDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ clangDecl() /*const*/ {
    return Cvdecl;
  }

  
  /// Set the clang variable associated with this Phi node.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::setClangDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1330,
   FQN="clang::threadSafety::til::Phi::setClangDecl", NM="_ZN5clang12threadSafety3til3Phi12setClangDeclEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til3Phi12setClangDeclEPKNS_9ValueDeclE")
  //</editor-fold>
  public void setClangDecl(/*const*/ ValueDecl /*P*/ Cvd) {
    Cvdecl = Cvd;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1333,
   FQN="clang::threadSafety::til::Phi::traverse", NM="Tpl__ZN5clang12threadSafety3til3Phi8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til3Phi8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
     VisitReducer.Container<Boolean/*V.R_SExpr*/> Nvs/*J*/= /*ParenList*/new  VisitReducer.Container<Boolean/*V.R_SExpr*/>(Vs, _Values.size());
    
    for (SExpr /*P*/ Val : _Values) {
      Nvs.push_back(Vs.traverse(Val, Vs.subExprCtx(Ctx)));
    }
    return Vs.reducePhi(/*Deref*/this, Nvs);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Phi::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1344,
   FQN="clang::threadSafety::til::Phi::compare", NM="Tpl__ZNK5clang12threadSafety3til3Phi7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til3Phi7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Phi /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    // TODO: implement CFG comparisons
    return Cmp.comparePointers(this, E);
  }

/*private:*/
  private SimpleArray<SExpr /*P*/ > _Values;
  private /*const*/ ValueDecl /*P*/ Cvdecl;
  
  @Override public String toString() {
    return "" + "_Values=" + _Values // NOI18N
              + ", Cvdecl=" + Cvdecl // NOI18N
              + super.toString(); // NOI18N
  }
}
