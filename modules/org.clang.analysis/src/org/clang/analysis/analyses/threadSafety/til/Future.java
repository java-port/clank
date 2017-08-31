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
import org.clang.analysis.analyses.threadSafety.til.*;


/// Placeholder for an expression that has not yet been created.
/// Used to implement lazy copy and rewriting strategies.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 414,
 FQN="clang::threadSafety::til::Future", NM="_ZN5clang12threadSafety3til6FutureE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6FutureE")
//</editor-fold>
public class Future extends /*public*/ SExpr implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 416,
   FQN="clang::threadSafety::til::Future::classof", NM="_ZN5clang12threadSafety3til6Future7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Future7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Future;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::FutureStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 418,
   FQN="clang::threadSafety::til::Future::FutureStatus", NM="_ZN5clang12threadSafety3til6Future12FutureStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Future12FutureStatusE")
  //</editor-fold>
  public enum FutureStatus implements Native.ComparableLower {
    FS_pending(0),
    FS_evaluating(FS_pending.getValue() + 1),
    FS_done(FS_evaluating.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FutureStatus valueOf(int val) {
      FutureStatus out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FutureStatus[] VALUES;
      private static final FutureStatus[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FutureStatus kind : FutureStatus.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FutureStatus[min < 0 ? (1-min) : 0];
        VALUES = new FutureStatus[max >= 0 ? (1+max) : 0];
        for (FutureStatus kind : FutureStatus.values()) {
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
    private FutureStatus(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FutureStatus)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FutureStatus)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::Future">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 424,
   FQN="clang::threadSafety::til::Future::Future", NM="_ZN5clang12threadSafety3til6FutureC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6FutureC1Ev")
  //</editor-fold>
  public Future() {
    // : SExpr(COP_Future), Status(FS_pending), Result(null) 
    //START JInit
    super(TIL_Opcode.COP_Future);
    this.Status = FutureStatus.FS_pending;
    this.Result = null;
    //END JInit
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::~Future">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 427,
   FQN="clang::threadSafety::til::Future::~Future", NM="_ZN5clang12threadSafety3til6FutureD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6FutureD0Ev")
  //</editor-fold>
  public/*private*/ /*virtual*/ void $destroy() { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  // A lazy rewriting strategy should subclass Future and override this method.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::compute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 431,
   FQN="clang::threadSafety::til::Future::compute", NM="_ZN5clang12threadSafety3til6Future7computeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Future7computeEv")
  //</editor-fold>
  public /*virtual*/ SExpr /*P*/ compute() {
    return null;
  }

  
  // Return the result of this future if it exists, otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::maybeGetResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 434,
   FQN="clang::threadSafety::til::Future::maybeGetResult", NM="_ZNK5clang12threadSafety3til6Future14maybeGetResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til6Future14maybeGetResultEv")
  //</editor-fold>
  public SExpr /*P*/ maybeGetResult() /*const*/ {
    return Result;
  }

  
  // Return the result of this future; forcing it if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::result">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 439,
   FQN="clang::threadSafety::til::Future::result", NM="_ZN5clang12threadSafety3til6Future6resultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Future6resultEv")
  //</editor-fold>
  public SExpr /*P*/ result() {
    switch (Status) {
     case FS_pending:
      return force();
     case FS_evaluating:
      return null; // infinite loop; illegal recursion.
     case FS_done:
     default:
      return Result;
    }
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 451,
   FQN="clang::threadSafety::til::Future::traverse", NM="Tpl__ZN5clang12threadSafety3til6Future8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til6Future8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    assert ((Result != null)) : "Cannot traverse Future that has not been forced.";
    return Vs.traverse(Result, Ctx);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 457,
   FQN="clang::threadSafety::til::Future::compare", NM="Tpl__ZNK5clang12threadSafety3til6Future7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til6Future7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Future /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    if (!(Result != null) || !(E.Result != null)) {
      return Cmp.comparePointers(this, E);
    }
    return Cmp.compare(Result, E.Result);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Future::force">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 48,
   FQN="clang::threadSafety::til::Future::force", NM="_ZN5clang12threadSafety3til6Future5forceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til6Future5forceEv")
  //</editor-fold>
  private SExpr /*P*/ force() {
    Status = FutureStatus.FS_evaluating;
    Result = compute();
    Status = FutureStatus.FS_done;
    return Result;
  }

  
  private FutureStatus Status;
  private SExpr /*P*/ Result;
  
  @Override public String toString() {
    return "" + "Status=" + Status // NOI18N
              + ", Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
