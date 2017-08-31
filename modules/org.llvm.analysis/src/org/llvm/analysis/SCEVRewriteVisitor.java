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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// Recursively visits a SCEV expression and re-writes it.
/*template <typename SC> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 541,
 FQN="llvm::SCEVRewriteVisitor", NM="_ZN4llvm18SCEVRewriteVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitorE")
//</editor-fold>
public class SCEVRewriteVisitor</*typename*/ SC>  extends /*public*/ SCEVVisitor<SC, /*const*/ SCEV /*P*/ > {
/*protected:*/
  protected final ScalarEvolution /*&*/ SE;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::SCEVRewriteVisitor<SC>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 546,
   FQN="llvm::SCEVRewriteVisitor::SCEVRewriteVisitor<SC>", NM="_ZN4llvm18SCEVRewriteVisitorC1ERNS_15ScalarEvolutionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitorC1ERNS_15ScalarEvolutionE")
  //</editor-fold>
  public SCEVRewriteVisitor(final ScalarEvolution /*&*/ SE) {
    // : SE(SE) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 548,
   FQN="llvm::SCEVRewriteVisitor::visitConstant", NM="_ZN4llvm18SCEVRewriteVisitor13visitConstantEPKNS_12SCEVConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor13visitConstantEPKNS_12SCEVConstantE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitConstant(/*const*/ SCEVConstant /*P*/ Constant) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitTruncateExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 552,
   FQN="llvm::SCEVRewriteVisitor::visitTruncateExpr", NM="_ZN4llvm18SCEVRewriteVisitor17visitTruncateExprEPKNS_16SCEVTruncateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor17visitTruncateExprEPKNS_16SCEVTruncateExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitTruncateExpr(/*const*/ SCEVTruncateExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitZeroExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 557,
   FQN="llvm::SCEVRewriteVisitor::visitZeroExtendExpr", NM="_ZN4llvm18SCEVRewriteVisitor19visitZeroExtendExprEPKNS_18SCEVZeroExtendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor19visitZeroExtendExprEPKNS_18SCEVZeroExtendExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitZeroExtendExpr(/*const*/ SCEVZeroExtendExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitSignExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 562,
   FQN="llvm::SCEVRewriteVisitor::visitSignExtendExpr", NM="_ZN4llvm18SCEVRewriteVisitor19visitSignExtendExprEPKNS_18SCEVSignExtendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor19visitSignExtendExprEPKNS_18SCEVSignExtendExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitSignExtendExpr(/*const*/ SCEVSignExtendExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitAddExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 567,
   FQN="llvm::SCEVRewriteVisitor::visitAddExpr", NM="_ZN4llvm18SCEVRewriteVisitor12visitAddExprEPKNS_11SCEVAddExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor12visitAddExprEPKNS_11SCEVAddExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitAddExpr(/*const*/ SCEVAddExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitMulExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 574,
   FQN="llvm::SCEVRewriteVisitor::visitMulExpr", NM="_ZN4llvm18SCEVRewriteVisitor12visitMulExprEPKNS_11SCEVMulExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor12visitMulExprEPKNS_11SCEVMulExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitMulExpr(/*const*/ SCEVMulExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitUDivExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 581,
   FQN="llvm::SCEVRewriteVisitor::visitUDivExpr", NM="_ZN4llvm18SCEVRewriteVisitor13visitUDivExprEPKNS_12SCEVUDivExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor13visitUDivExprEPKNS_12SCEVUDivExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitUDivExpr(/*const*/ SCEVUDivExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 586,
   FQN="llvm::SCEVRewriteVisitor::visitAddRecExpr", NM="_ZN4llvm18SCEVRewriteVisitor15visitAddRecExprEPKNS_14SCEVAddRecExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor15visitAddRecExprEPKNS_14SCEVAddRecExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitAddRecExpr(/*const*/ SCEVAddRecExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitSMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 594,
   FQN="llvm::SCEVRewriteVisitor::visitSMaxExpr", NM="_ZN4llvm18SCEVRewriteVisitor13visitSMaxExprEPKNS_12SCEVSMaxExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor13visitSMaxExprEPKNS_12SCEVSMaxExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitSMaxExpr(/*const*/ SCEVSMaxExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitUMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 601,
   FQN="llvm::SCEVRewriteVisitor::visitUMaxExpr", NM="_ZN4llvm18SCEVRewriteVisitor13visitUMaxExprEPKNS_12SCEVUMaxExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor13visitUMaxExprEPKNS_12SCEVUMaxExprE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitUMaxExpr(/*const*/ SCEVUMaxExpr /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitUnknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 608,
   FQN="llvm::SCEVRewriteVisitor::visitUnknown", NM="_ZN4llvm18SCEVRewriteVisitor12visitUnknownEPKNS_11SCEVUnknownE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor12visitUnknownEPKNS_11SCEVUnknownE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitUnknown(/*const*/ SCEVUnknown /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SCEVRewriteVisitor::visitCouldNotCompute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 612,
   FQN="llvm::SCEVRewriteVisitor::visitCouldNotCompute", NM="_ZN4llvm18SCEVRewriteVisitor20visitCouldNotComputeEPKNS_19SCEVCouldNotComputeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm18SCEVRewriteVisitor20visitCouldNotComputeEPKNS_19SCEVCouldNotComputeE")
  //</editor-fold>
  public /*const*/ SCEV /*P*/ visitCouldNotCompute(/*const*/ SCEVCouldNotCompute /*P*/ Expr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "SE=" + SE // NOI18N
              + super.toString(); // NOI18N
  }
}
