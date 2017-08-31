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

package org.clang.analysis;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::LocationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 214,
 FQN="clang::LocationContext", NM="_ZN5clang15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang15LocationContextE")
//</editor-fold>
public abstract class LocationContext extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::ContextKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 216,
   FQN="clang::LocationContext::ContextKind", NM="_ZN5clang15LocationContext11ContextKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang15LocationContext11ContextKindE")
  //</editor-fold>
  public enum ContextKind implements Native.ComparableLower {
    StackFrame(0),
    Scope(StackFrame.getValue() + 1),
    Block(Scope.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ContextKind valueOf(int val) {
      ContextKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ContextKind[] VALUES;
      private static final ContextKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ContextKind kind : ContextKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ContextKind[min < 0 ? (1-min) : 0];
        VALUES = new ContextKind[max >= 0 ? (1+max) : 0];
        for (ContextKind kind : ContextKind.values()) {
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
    private ContextKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ContextKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ContextKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private ContextKind Kind;
  
  // AnalysisDeclContext can't be const since some methods may modify its
  // member.
  private AnalysisDeclContext /*P*/ Ctx;
  
  private /*const*/ LocationContext /*P*/ Parent;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::LocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 228,
   FQN="clang::LocationContext::LocationContext", NM="_ZN5clang15LocationContextC1ENS0_11ContextKindEPNS_19AnalysisDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang15LocationContextC1ENS0_11ContextKindEPNS_19AnalysisDeclContextEPKS0_")
  //</editor-fold>
  protected LocationContext(ContextKind k, AnalysisDeclContext /*P*/ ctx, 
      /*const*/ LocationContext /*P*/ parent) {
    // : FoldingSetNode(), Kind(k), Ctx(ctx), Parent(parent) 
    //START JInit
    $Node();
    this.Kind = k;
    this.Ctx = ctx;
    this.Parent = parent;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::~LocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 613,
   FQN="clang::LocationContext::~LocationContext", NM="_ZN5clang15LocationContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang15LocationContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    FoldingSetImpl.Node.super.$destroy$Node();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 235,
   FQN="clang::LocationContext::getKind", NM="_ZNK5clang15LocationContext7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext7getKindEv")
  //</editor-fold>
  public ContextKind getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getAnalysisDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 237,
   FQN="clang::LocationContext::getAnalysisDeclContext", NM="_ZNK5clang15LocationContext22getAnalysisDeclContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext22getAnalysisDeclContextEv")
  //</editor-fold>
  public AnalysisDeclContext /*P*/ getAnalysisDeclContext() /*const*/ {
    return Ctx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 239,
   FQN="clang::LocationContext::getParent", NM="_ZNK5clang15LocationContext9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext9getParentEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getParent() /*const*/ {
    return Parent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::isParentOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 460,
   FQN="clang::LocationContext::isParentOf", NM="_ZNK5clang15LocationContext10isParentOfEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext10isParentOfEPKS0_")
  //</editor-fold>
  public boolean isParentOf(/*const*/ LocationContext /*P*/ LC) /*const*/ {
    do {
      /*const*/ LocationContext /*P*/ Parent = LC.getParent();
      if (Parent == this) {
        return true;
      } else {
        LC = Parent;
      }
    } while ((LC != null));
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 243,
   FQN="clang::LocationContext::getDecl", NM="_ZNK5clang15LocationContext7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext7getDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDecl() /*const*/ {
    return getAnalysisDeclContext().getDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 245,
   FQN="clang::LocationContext::getCFG", NM="_ZNK5clang15LocationContext6getCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext6getCFGEv")
  //</editor-fold>
  public CFG /*P*/ getCFG() /*const*/ {
    return getAnalysisDeclContext().getCFG();
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 248,
   FQN="clang::LocationContext::getAnalysis", NM="Tpl__ZNK5clang15LocationContext11getAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=Tpl__ZNK5clang15LocationContext11getAnalysisEv")
  //</editor-fold>
  public </*typename*/ T extends ManagedAnalysis> T /*P*/ getAnalysis(Class<T> clazz) /*const*/ {
    return getAnalysisDeclContext().getAnalysis(clazz);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getParentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 252,
   FQN="clang::LocationContext::getParentMap", NM="_ZNK5clang15LocationContext12getParentMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext12getParentMapEv")
  //</editor-fold>
  public ParentMap /*&*/ getParentMap() /*const*/ {
    return getAnalysisDeclContext().getParentMap();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getSelfDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 256,
   FQN="clang::LocationContext::getSelfDecl", NM="_ZNK5clang15LocationContext11getSelfDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext11getSelfDeclEv")
  //</editor-fold>
  public /*const*/ ImplicitParamDecl /*P*/ getSelfDecl() /*const*/ {
    return Ctx.getSelfDecl();
  }

  
  
  //===----------------------------------------------------------------------===//
  // LocationContext methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::getCurrentStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 446,
   FQN="clang::LocationContext::getCurrentStackFrame", NM="_ZNK5clang15LocationContext20getCurrentStackFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext20getCurrentStackFrameEv")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getCurrentStackFrame() /*const*/ {
    /*const*/ LocationContext /*P*/ LC = this;
    while ((LC != null)) {
      {
        /*const*/ StackFrameContext /*P*/ SFC = dyn_cast_StackFrameContext(LC);
        if ((SFC != null)) {
          return SFC;
        }
      }
      LC = LC.getParent();
    }
    return null;
  }

  
  /// Return true if the current LocationContext has no caller context.
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::inTopFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 456,
   FQN="clang::LocationContext::inTopFrame", NM="_ZNK5clang15LocationContext10inTopFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext10inTopFrameEv")
  //</editor-fold>
  public boolean inTopFrame() /*const*/ {
    return getCurrentStackFrame().inTopFrame();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 265,
   FQN="clang::LocationContext::Profile", NM="_ZN5clang15LocationContext7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang15LocationContext7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public abstract /*virtual*/ void Profile(final FoldingSetNodeID /*&*/ ID)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::dumpStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 472,
   FQN="clang::LocationContext::dumpStack", NM="_ZNK5clang15LocationContext9dumpStackERN4llvm11raw_ostreamENS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext9dumpStackERN4llvm11raw_ostreamENS1_9StringRefE")
  //</editor-fold>
  public void dumpStack(final raw_ostream /*&*/ OS) /*const*/ {
    dumpStack(OS, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public void dumpStack(final raw_ostream /*&*/ OS, StringRef Indent/*= ""*/) /*const*/ {
    final ASTContext /*&*/ Ctx = getAnalysisDeclContext().getASTContext();
    PrintingPolicy PP/*J*/= new PrintingPolicy(Ctx.getLangOpts());
    PP.TerseOutput = true;
    
    /*uint*/int Frame = 0;
    for (/*const*/ LocationContext /*P*/ LCtx = this; (LCtx != null); LCtx = LCtx.getParent()) {
      switch (LCtx.getKind()) {
       case StackFrame:
        OS.$out(/*NO_COPY*/Indent).$out_char($$HASH).$out_uint(Frame++).$out_char($$SPACE);
        cast_StackFrameContext(LCtx).getDecl().print(OS, PP);
        OS.$out_char($$LF);
        break;
       case Scope:
        OS.$out(/*NO_COPY*/Indent).$out(/*KEEP_STR*/"    (scope)\n");
        break;
       case Block:
        OS.$out(/*NO_COPY*/Indent).$out(/*KEEP_STR*/"    (block context: ").$out(
            cast_BlockInvocationContext(LCtx).getContextData()
        ).$out(
            /*KEEP_STR*/")\n"
        );
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::dumpStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 497,
   FQN="clang::LocationContext::dumpStack", NM="_ZNK5clang15LocationContext9dumpStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang15LocationContext9dumpStackEv")
  //</editor-fold>
  public void dumpStack() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpStack(llvm.errs());
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // FoldingSet profiling.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::LocationContext::ProfileCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 355,
   FQN="clang::LocationContext::ProfileCommon", NM="_ZN5clang15LocationContext13ProfileCommonERN4llvm16FoldingSetNodeIDENS0_11ContextKindEPNS_19AnalysisDeclContextEPKS0_PKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang15LocationContext13ProfileCommonERN4llvm16FoldingSetNodeIDENS0_11ContextKindEPNS_19AnalysisDeclContextEPKS0_PKv")
  //</editor-fold>
  public static void ProfileCommon(final FoldingSetNodeID /*&*/ ID, 
               ContextKind ck, 
               AnalysisDeclContext /*P*/ ctx, 
               /*const*/ LocationContext /*P*/ parent, 
               /*const*/Object/*void P*/ data) {
    ID.AddInteger_int(ck.getValue());
    ID.AddPointer(ctx);
    ID.AddPointer(parent);
    ID.AddPointer(data);
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Ctx=" + NativeTrace.getIdentityStr(Ctx) // NOI18N
              + ", Parent=" + NativeTrace.getIdentityStr(Parent) // NOI18N
              + super.toString(); // NOI18N
  }
}
