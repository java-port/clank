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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.analysis.support.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 506,
 FQN="(anonymous namespace)::FindBlockDeclRefExprsVals", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsValsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsValsE")
//</editor-fold>
public class FindBlockDeclRefExprsVals implements /*public*/ StmtVisitorVoid<FindBlockDeclRefExprsVals>, Destructors.ClassWithDestructor {
  private final BumpVector</*const*/ VarDecl /*P*/ > /*&*/ BEVals;
  private final BumpVectorContext /*&*/ BC;
  private SmallPtrSet</*const*/ VarDecl /*P*/ > Visited;
  private SmallPtrSet</*const*/ DeclContext /*P*/ > IgnoredContexts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals::FindBlockDeclRefExprsVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 512,
   FQN="(anonymous namespace)::FindBlockDeclRefExprsVals::FindBlockDeclRefExprsVals", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsValsC1ERN5clang10BumpVectorIPKNS1_7VarDeclEEERNS1_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsValsC1ERN5clang10BumpVectorIPKNS1_7VarDeclEEERNS1_17BumpVectorContextE")
  //</editor-fold>
  public FindBlockDeclRefExprsVals(final BumpVector</*const*/ VarDecl /*P*/ > /*&*/ bevals, 
      final BumpVectorContext /*&*/ bc) {
    // : StmtVisitor<FindBlockDeclRefExprsVals>(), BEVals(bevals), BC(bc), Visited(), IgnoredContexts() 
    //START JInit
    $StmtVisitor();
    this./*&*/BEVals=/*&*/bevals;
    this./*&*/BC=/*&*/bc;
    this.Visited = new SmallPtrSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.IgnoredContexts = new SmallPtrSet</*const*/ DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 516,
   FQN="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitStmt", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 522,
   FQN="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ DR) {
    {
      // Non-local variables are also directly modified.
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl());
      if ((VD != null)) {
        if (!VD.hasLocalStorage()) {
          if (Visited.insert(VD).second) {
            BEVals.push_back(VD, BC);
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 532,
   FQN="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitBlockExpr", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals14VisitBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals14VisitBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(BlockExpr /*P*/ BR) {
    // Blocks containing blocks can transitively capture more variables.
    IgnoredContexts.insert(BR.getBlockDecl());
    Visit(BR.getBlockDecl().getBody());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 538,
   FQN="(anonymous namespace)::FindBlockDeclRefExprsVals::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsVals21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public void VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ PE) {
    for (type$ptr<Expr /*P*/ /*const*/ /*P*/> it = $tryClone(PE.semantics_begin()), 
        /*P*/ /*const*/ /*P*/ et = $tryClone(PE.semantics_end()); $noteq_ptr(it, et); it.$preInc()) {
      Expr /*P*/ Semantic = it.$star();
      {
        OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(Semantic);
        if ((OVE != null)) {
          Semantic = OVE.getSourceExpr();
        }
      }
      Visit(Semantic);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindBlockDeclRefExprsVals::~FindBlockDeclRefExprsVals">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 506,
   FQN="(anonymous namespace)::FindBlockDeclRefExprsVals::~FindBlockDeclRefExprsVals", NM="_ZN12_GLOBAL__N_125FindBlockDeclRefExprsValsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN12_GLOBAL__N_125FindBlockDeclRefExprsValsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IgnoredContexts.$destroy();
    Visited.$destroy();
    StmtVisitorVoid.super.$destroy$StmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "BEVals=" + BEVals // NOI18N
              + ", BC=" + "[BumpVectorContext]" // NOI18N
              + ", Visited=" + Visited // NOI18N
              + ", IgnoredContexts=" + "[SmallPtrSet$DeclContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
