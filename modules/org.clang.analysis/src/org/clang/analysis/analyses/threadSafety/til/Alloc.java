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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// Allocate memory for a new value on the heap or stack.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 993,
 FQN="clang::threadSafety::til::Alloc", NM="_ZN5clang12threadSafety3til5AllocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5AllocE")
//</editor-fold>
public class Alloc extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 995,
   FQN="clang::threadSafety::til::Alloc::classof", NM="_ZN5clang12threadSafety3til5Alloc7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5Alloc7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Call;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::AllocKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 997,
   FQN="clang::threadSafety::til::Alloc::AllocKind", NM="_ZN5clang12threadSafety3til5Alloc9AllocKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5Alloc9AllocKindE")
  //</editor-fold>
  public enum AllocKind implements Native.ComparableLower {
    AK_Stack(0),
    AK_Heap(AK_Stack.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AllocKind valueOf(int val) {
      AllocKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AllocKind[] VALUES;
      private static final AllocKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AllocKind kind : AllocKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AllocKind[min < 0 ? (1-min) : 0];
        VALUES = new AllocKind[max >= 0 ? (1+max) : 0];
        for (AllocKind kind : AllocKind.values()) {
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
    private AllocKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AllocKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AllocKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::Alloc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1002,
   FQN="clang::threadSafety::til::Alloc::Alloc", NM="_ZN5clang12threadSafety3til5AllocC1EPNS1_5SExprENS2_9AllocKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5AllocC1EPNS1_5SExprENS2_9AllocKindE")
  //</editor-fold>
  public Alloc(SExpr /*P*/ D, AllocKind K) {
    // : SExpr(COP_Alloc), Dtype(D) 
    //START JInit
    super(TIL_Opcode.COP_Alloc);
    this.Dtype = D;
    //END JInit
    Flags = $uint2ushort(K.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::Alloc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1003,
   FQN="clang::threadSafety::til::Alloc::Alloc", NM="_ZN5clang12threadSafety3til5AllocC1ERKS2_PNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5AllocC1ERKS2_PNS1_5SExprE")
  //</editor-fold>
  public Alloc(final /*const*/ Alloc /*&*/ A, SExpr /*P*/ Dt) {
    // : SExpr(A), Dtype(Dt) 
    //START JInit
    super(A);
    this.Dtype = Dt;
    //END JInit
    Flags = $uint2ushort(A.kind().getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1005,
   FQN="clang::threadSafety::til::Alloc::kind", NM="_ZNK5clang12threadSafety3til5Alloc4kindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5Alloc4kindEv")
  //</editor-fold>
  public AllocKind kind() /*const*/ {
    return /*static_cast*/AllocKind.valueOf(Flags);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::dataType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1007,
   FQN="clang::threadSafety::til::Alloc::dataType", NM="_ZN5clang12threadSafety3til5Alloc8dataTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til5Alloc8dataTypeEv")
  //</editor-fold>
  public SExpr /*P*/ dataType() {
    return Dtype;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::dataType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1008,
   FQN="clang::threadSafety::til::Alloc::dataType", NM="_ZNK5clang12threadSafety3til5Alloc8dataTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til5Alloc8dataTypeEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ dataType$Const() /*const*/ {
    return Dtype;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1011,
   FQN="clang::threadSafety::til::Alloc::traverse", NM="Tpl__ZN5clang12threadSafety3til5Alloc8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til5Alloc8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    /*<dependent type>*/boolean Nd = Vs.traverse(Dtype, Vs.declCtx(Ctx));
    return Vs.reduceAlloc(/*Deref*/this, Nd);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Alloc::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 1017,
   FQN="clang::threadSafety::til::Alloc::compare", NM="Tpl__ZNK5clang12threadSafety3til5Alloc7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til5Alloc7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Alloc /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    boolean/*C.CType*/ Ct = Cmp.compareIntegers(kind().getValue(), E.kind().getValue());
    if (Cmp.notTrue(Ct)) {
      return Ct;
    }
    return Cmp.compare(dataType$Const(), E.dataType$Const());
  }

/*private:*/
  private SExpr /*P*/ Dtype;
  
  @Override public String toString() {
    return "" + "Dtype=" + Dtype // NOI18N
              + super.toString(); // NOI18N
  }
}
