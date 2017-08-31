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
import org.clang.ast.*;

/// ContainsReference - A visitor class to search for references to
/// a particular declaration (the needle) within any evaluated component of an
/// expression (recursively).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContainsReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 589,
 FQN="(anonymous namespace)::ContainsReference", NM="_ZN12_GLOBAL__N_117ContainsReferenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117ContainsReferenceE")
//</editor-fold>
public class ContainsReference implements /*public*/ ConstEvaluatedExprVisitor<ContainsReference> {
  private boolean FoundReference;
  private /*const*/ DeclRefExpr /*P*/ Needle;
/*public:*/
  /*typedef ConstEvaluatedExprVisitor<ContainsReference> Inherited*/
//  public final class Inherited extends ConstEvaluatedExprVisitor<ContainsReference>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContainsReference::ContainsReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 596,
   FQN="(anonymous namespace)::ContainsReference::ContainsReference", NM="_ZN12_GLOBAL__N_117ContainsReferenceC1ERN5clang10ASTContextEPKNS1_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117ContainsReferenceC1ERN5clang10ASTContextEPKNS1_11DeclRefExprE")
  //</editor-fold>
  public ContainsReference(final ASTContext /*&*/ Context, /*const*/ DeclRefExpr /*P*/ Needle) {
    // : Inherited(Context), FoundReference(false), Needle(Needle) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $ConstEvaluatedExprVisitor(Context);
    this.FoundReference = false;
    this.Needle = Needle;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContainsReference::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 599,
   FQN="(anonymous namespace)::ContainsReference::VisitExpr", NM="_ZN12_GLOBAL__N_117ContainsReference9VisitExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117ContainsReference9VisitExprEPKN5clang4ExprE")
  //</editor-fold>
  public void VisitExpr(/*const*/ Expr /*P*/ E) {
    // Stop evaluating if we already have a reference.
    if (FoundReference) {
      return;
    }
    
    ConstEvaluatedExprVisitor.super.VisitExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContainsReference::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 607,
   FQN="(anonymous namespace)::ContainsReference::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_117ContainsReference16VisitDeclRefExprEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN12_GLOBAL__N_117ContainsReference16VisitDeclRefExprEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ E) {
    if (E == Needle) {
      FoundReference = true;
    } else {
      ConstEvaluatedExprVisitor.super.VisitDeclRefExpr(E);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContainsReference::doesContainReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 614,
   FQN="(anonymous namespace)::ContainsReference::doesContainReference", NM="_ZNK12_GLOBAL__N_117ContainsReference20doesContainReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK12_GLOBAL__N_117ContainsReference20doesContainReferenceEv")
  //</editor-fold>
  public boolean doesContainReference() /*const*/ {
    return FoundReference;
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $ConstEvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "FoundReference=" + FoundReference // NOI18N
              + ", Needle=" + Needle // NOI18N
              + super.toString(); // NOI18N
  }
}
