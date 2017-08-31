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

package org.clang.sema.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3741,
 FQN="(anonymous namespace)::UncoveredArgHandler", NM="_ZN12_GLOBAL__N_119UncoveredArgHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandlerE")
//</editor-fold>
public class UncoveredArgHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3742,
   FQN="(anonymous namespace)::UncoveredArgHandler::(anonymous)", NM="_ZN12_GLOBAL__N_119UncoveredArgHandlerE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandlerE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    Unknown(-1),
    AllCovered(-2);

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
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private Unnamed_enum(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  private int FirstUncoveredArg;
  private SmallVector</*const*/ Expr /*P*/ > DiagnosticExprs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::UncoveredArgHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3747,
   FQN="(anonymous namespace)::UncoveredArgHandler::UncoveredArgHandler", NM="_ZN12_GLOBAL__N_119UncoveredArgHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandlerC1Ev")
  //</editor-fold>
  public UncoveredArgHandler() {
    // : FirstUncoveredArg(Unknown), DiagnosticExprs() 
    //START JInit
    this.FirstUncoveredArg = Unnamed_enum.Unknown.getValue();
    this.DiagnosticExprs = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::hasUncoveredArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3749,
   FQN="(anonymous namespace)::UncoveredArgHandler::hasUncoveredArg", NM="_ZNK12_GLOBAL__N_119UncoveredArgHandler15hasUncoveredArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZNK12_GLOBAL__N_119UncoveredArgHandler15hasUncoveredArgEv")
  //</editor-fold>
  public boolean hasUncoveredArg() /*const*/ {
    return (FirstUncoveredArg >= 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::getUncoveredArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3753,
   FQN="(anonymous namespace)::UncoveredArgHandler::getUncoveredArg", NM="_ZNK12_GLOBAL__N_119UncoveredArgHandler15getUncoveredArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZNK12_GLOBAL__N_119UncoveredArgHandler15getUncoveredArgEv")
  //</editor-fold>
  public /*uint*/int getUncoveredArg() /*const*/ {
    assert (hasUncoveredArg()) : "no uncovered argument";
    return FirstUncoveredArg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::setAllCovered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3758,
   FQN="(anonymous namespace)::UncoveredArgHandler::setAllCovered", NM="_ZN12_GLOBAL__N_119UncoveredArgHandler13setAllCoveredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandler13setAllCoveredEv")
  //</editor-fold>
  public void setAllCovered() {
    // A string has been found with all arguments covered, so clear out
    // the diagnostics.
    DiagnosticExprs.clear();
    FirstUncoveredArg = Unnamed_enum.AllCovered.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::Update">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3765,
   FQN="(anonymous namespace)::UncoveredArgHandler::Update", NM="_ZN12_GLOBAL__N_119UncoveredArgHandler6UpdateEiPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandler6UpdateEiPKN5clang4ExprE")
  //</editor-fold>
  public void Update(int NewFirstUncoveredArg, /*const*/ Expr /*P*/ StrExpr) {
    assert (NewFirstUncoveredArg >= 0) : "Outside range";
    
    // Don't update if a previous string covers all arguments.
    if (FirstUncoveredArg == Unnamed_enum.AllCovered.getValue()) {
      return;
    }
    
    // UncoveredArgHandler tracks the highest uncovered argument index
    // and with it all the strings that match this index.
    if (NewFirstUncoveredArg == FirstUncoveredArg) {
      DiagnosticExprs.push_back(StrExpr);
    } else if (NewFirstUncoveredArg > FirstUncoveredArg) {
      DiagnosticExprs.clear();
      DiagnosticExprs.push_back(StrExpr);
      FirstUncoveredArg = NewFirstUncoveredArg;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::Diagnose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4408,
   FQN="(anonymous namespace)::UncoveredArgHandler::Diagnose", NM="_ZN12_GLOBAL__N_119UncoveredArgHandler8DiagnoseERN5clang4SemaEbPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandler8DiagnoseERN5clang4SemaEbPKNS1_4ExprE")
  //</editor-fold>
  public void Diagnose(final Sema /*&*/ S, boolean IsFunctionCall, 
          /*const*/ Expr /*P*/ ArgExpr) {
    PartialDiagnostic PDiag = null;
    try {
      assert (hasUncoveredArg() && $greater_uint(DiagnosticExprs.size(), 0)) : "Invalid state";
      if (!(ArgExpr != null)) {
        return;
      }
      
      SourceLocation Loc = ArgExpr.getLocStart();
      if (S.getSourceManager().isInSystemMacro(/*NO_COPY*/Loc)) {
        return;
      }
      
      PDiag = S.PDiag(diag.warn_printf_data_arg_not_used);
      for (/*const*/ Expr /*P*/ E : DiagnosticExprs)  {
        $out_PartialDiagnostic$C_SourceRange(PDiag, E.getSourceRange());
      }
      
      CheckFormatHandler.EmitFormatDiagnostic(S, IsFunctionCall, DiagnosticExprs.$at(0), 
          PDiag, new SourceLocation(Loc), /*IsStringLocation*/ false, 
          DiagnosticExprs.$at(0).getSourceRange());
    } finally {
      if (PDiag != null) { PDiag.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UncoveredArgHandler::~UncoveredArgHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3741,
   FQN="(anonymous namespace)::UncoveredArgHandler::~UncoveredArgHandler", NM="_ZN12_GLOBAL__N_119UncoveredArgHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_119UncoveredArgHandlerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DiagnosticExprs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "FirstUncoveredArg=" + FirstUncoveredArg // NOI18N
              + ", DiagnosticExprs=" + DiagnosticExprs; // NOI18N
  }
}
