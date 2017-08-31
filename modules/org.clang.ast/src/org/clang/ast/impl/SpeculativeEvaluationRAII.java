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

package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.clang.ast.*;
import org.clang.basic.java.OptionalNotes;


/// RAII object used to optionally suppress diagnostics and side-effects from
/// a speculative evaluation.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 853,
 FQN="(anonymous namespace)::SpeculativeEvaluationRAII", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIE")
//</editor-fold>
public class SpeculativeEvaluationRAII implements Destructors.ClassWithDestructor {
  /// Pair of EvalInfo, and a bit that stores whether or not we were
  /// speculatively evaluating when we created this RAII.
  private PointerBoolPair<EvalInfo /*P*/ > InfoAndOldSpecEval;
  private Expr.EvalStatus Old;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::moveFromAndCancel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 859,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::moveFromAndCancel", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAII17moveFromAndCancelEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAII17moveFromAndCancelEOS0_")
  //</editor-fold>
  private void moveFromAndCancel(final SpeculativeEvaluationRAII /*&&*/Other) {
    InfoAndOldSpecEval.$assign(Other.InfoAndOldSpecEval);
    Old.$assign(Other.Old);
    Other.InfoAndOldSpecEval.setPointer((EvalInfo /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::maybeRestoreState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 865,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::maybeRestoreState", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAII17maybeRestoreStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAII17maybeRestoreStateEv")
  //</editor-fold>
  private void maybeRestoreState() {
    EvalInfo /*P*/ Info = InfoAndOldSpecEval.getPointer();
    if (!(Info != null)) {
      return;
    }
    
    Info.EvalStatus.$assign(Old);
    Info.IsSpeculativelyEvaluating = InfoAndOldSpecEval.getInt();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 875,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1Ev")
  //</editor-fold>
  public SpeculativeEvaluationRAII() {
    // : InfoAndOldSpecEval(), Old()/* = default*/ 
    //START JInit
    this.InfoAndOldSpecEval = new PointerBoolPair<EvalInfo /*P*/ >();
    this.Old = new Expr.EvalStatus();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 877,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1ERNS_8EvalInfoEPN4llvm15SmallVectorImplISt4pairIN5clang14SourceLocationENS6_17PartialDiagnosticEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1ERNS_8EvalInfoEPN4llvm15SmallVectorImplISt4pairIN5clang14SourceLocationENS6_17PartialDiagnosticEEEE")
  //</editor-fold>
  public SpeculativeEvaluationRAII(final EvalInfo /*&*/ Info) {
    this(Info, (OptionalNotes /*P*/ )null);
  }
  public SpeculativeEvaluationRAII(final EvalInfo /*&*/ Info, OptionalNotes /*P*/ NewDiag/*= null*/) {
    // : InfoAndOldSpecEval(&Info, Info.IsSpeculativelyEvaluating), Old(Info.EvalStatus) 
    //START JInit
    this.InfoAndOldSpecEval = new PointerBoolPair<EvalInfo /*P*/ >($AddrOf(Info), Info.IsSpeculativelyEvaluating);
    this.Old = new Expr.EvalStatus(Info.EvalStatus);
    //END JInit
    Info.EvalStatus.Diag = NewDiag;
    Info.IsSpeculativelyEvaluating = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 885,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1ERKS0_")
  //</editor-fold>
  public SpeculativeEvaluationRAII(final /*const*/ SpeculativeEvaluationRAII /*&*/ Other) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 886,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::SpeculativeEvaluationRAII", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIC1EOS0_")
  //</editor-fold>
  public SpeculativeEvaluationRAII(JD$Move _dparam, final SpeculativeEvaluationRAII /*&&*/Other) {
    // : InfoAndOldSpecEval(), Old() 
    //START JInit
    this.InfoAndOldSpecEval = new PointerBoolPair<EvalInfo /*P*/ >();
    this.Old = new Expr.EvalStatus();
    //END JInit
    moveFromAndCancel(std.move(Other));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 890,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::operator=", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIIaSEOS0_")
  //</editor-fold>
  public SpeculativeEvaluationRAII /*&*/ $assignMove(final SpeculativeEvaluationRAII /*&&*/Other) {
    maybeRestoreState();
    moveFromAndCancel(std.move(Other));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpeculativeEvaluationRAII::~SpeculativeEvaluationRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 896,
   FQN="(anonymous namespace)::SpeculativeEvaluationRAII::~SpeculativeEvaluationRAII", NM="_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_125SpeculativeEvaluationRAIID0Ev")
  //</editor-fold>
  public void $destroy() {
    maybeRestoreState();
  }

  
  @Override public String toString() {
    return "" + "InfoAndOldSpecEval=" + InfoAndOldSpecEval // NOI18N
              + ", Old=" + Old; // NOI18N
  }
}
