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

package org.llvm.analysis.impl;

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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 695,
 FQN="(anonymous namespace)::SCEVDivision", NM="_ZN12_GLOBAL__N_112SCEVDivisionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivisionE")
//</editor-fold>
public class/*struct*/ SCEVDivision extends /*public*/ SCEVVisitorVoid<SCEVDivision/*, void*/> {
/*public:*/
  // Computes the Quotient and Remainder of the division of Numerator by
  // Denominator.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::divide">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 699,
   FQN="(anonymous namespace)::SCEVDivision::divide", NM="_ZN12_GLOBAL__N_112SCEVDivision6divideERN4llvm15ScalarEvolutionEPKNS1_4SCEVES6_PS6_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision6divideERN4llvm15ScalarEvolutionEPKNS1_4SCEVES6_PS6_S7_")
  //</editor-fold>
  public static void divide(final ScalarEvolution /*&*/ SE, /*const*/ SCEV /*P*/ Numerator, 
        /*const*/ SCEV /*P*/ Denominator, type$ptr</*const*/ SCEV /*P*/ /*P*/> Quotient, 
        type$ptr</*const*/ SCEV /*P*/ /*P*/> Remainder) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Except in the trivial case described above, we do not know how to divide
  // Expr by Denominator for the following functions with empty implementation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitTruncateExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 754,
   FQN="(anonymous namespace)::SCEVDivision::visitTruncateExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision17visitTruncateExprEPKN4llvm16SCEVTruncateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision17visitTruncateExprEPKN4llvm16SCEVTruncateExprE")
  //</editor-fold>
  public void visitTruncateExpr(/*const*/ SCEVTruncateExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitZeroExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 755,
   FQN="(anonymous namespace)::SCEVDivision::visitZeroExtendExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision19visitZeroExtendExprEPKN4llvm18SCEVZeroExtendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision19visitZeroExtendExprEPKN4llvm18SCEVZeroExtendExprE")
  //</editor-fold>
  public void visitZeroExtendExpr(/*const*/ SCEVZeroExtendExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitSignExtendExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 756,
   FQN="(anonymous namespace)::SCEVDivision::visitSignExtendExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision19visitSignExtendExprEPKN4llvm18SCEVSignExtendExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision19visitSignExtendExprEPKN4llvm18SCEVSignExtendExprE")
  //</editor-fold>
  public void visitSignExtendExpr(/*const*/ SCEVSignExtendExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitUDivExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 757,
   FQN="(anonymous namespace)::SCEVDivision::visitUDivExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision13visitUDivExprEPKN4llvm12SCEVUDivExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision13visitUDivExprEPKN4llvm12SCEVUDivExprE")
  //</editor-fold>
  public void visitUDivExpr(/*const*/ SCEVUDivExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitSMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 758,
   FQN="(anonymous namespace)::SCEVDivision::visitSMaxExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision13visitSMaxExprEPKN4llvm12SCEVSMaxExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision13visitSMaxExprEPKN4llvm12SCEVSMaxExprE")
  //</editor-fold>
  public void visitSMaxExpr(/*const*/ SCEVSMaxExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitUMaxExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 759,
   FQN="(anonymous namespace)::SCEVDivision::visitUMaxExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision13visitUMaxExprEPKN4llvm12SCEVUMaxExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision13visitUMaxExprEPKN4llvm12SCEVUMaxExprE")
  //</editor-fold>
  public void visitUMaxExpr(/*const*/ SCEVUMaxExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitUnknown">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 760,
   FQN="(anonymous namespace)::SCEVDivision::visitUnknown", NM="_ZN12_GLOBAL__N_112SCEVDivision12visitUnknownEPKN4llvm11SCEVUnknownE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision12visitUnknownEPKN4llvm11SCEVUnknownE")
  //</editor-fold>
  public void visitUnknown(/*const*/ SCEVUnknown /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitCouldNotCompute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 761,
   FQN="(anonymous namespace)::SCEVDivision::visitCouldNotCompute", NM="_ZN12_GLOBAL__N_112SCEVDivision20visitCouldNotComputeEPKN4llvm19SCEVCouldNotComputeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision20visitCouldNotComputeEPKN4llvm19SCEVCouldNotComputeE")
  //</editor-fold>
  public void visitCouldNotCompute(/*const*/ SCEVCouldNotCompute /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 763,
   FQN="(anonymous namespace)::SCEVDivision::visitConstant", NM="_ZN12_GLOBAL__N_112SCEVDivision13visitConstantEPKN4llvm12SCEVConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision13visitConstantEPKN4llvm12SCEVConstantE")
  //</editor-fold>
  public void visitConstant(/*const*/ SCEVConstant /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitAddRecExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 784,
   FQN="(anonymous namespace)::SCEVDivision::visitAddRecExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision15visitAddRecExprEPKN4llvm14SCEVAddRecExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision15visitAddRecExprEPKN4llvm14SCEVAddRecExprE")
  //</editor-fold>
  public void visitAddRecExpr(/*const*/ SCEVAddRecExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitAddExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 801,
   FQN="(anonymous namespace)::SCEVDivision::visitAddExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision12visitAddExprEPKN4llvm11SCEVAddExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision12visitAddExprEPKN4llvm11SCEVAddExprE")
  //</editor-fold>
  public void visitAddExpr(/*const*/ SCEVAddExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::visitMulExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 827,
   FQN="(anonymous namespace)::SCEVDivision::visitMulExpr", NM="_ZN12_GLOBAL__N_112SCEVDivision12visitMulExprEPKN4llvm11SCEVMulExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision12visitMulExprEPKN4llvm11SCEVMulExprE")
  //</editor-fold>
  public void visitMulExpr(/*const*/ SCEVMulExpr /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::SCEVDivision">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 898,
   FQN="(anonymous namespace)::SCEVDivision::SCEVDivision", NM="_ZN12_GLOBAL__N_112SCEVDivisionC1ERN4llvm15ScalarEvolutionEPKNS1_4SCEVES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivisionC1ERN4llvm15ScalarEvolutionEPKNS1_4SCEVES6_")
  //</editor-fold>
  private SCEVDivision(final ScalarEvolution /*&*/ S, /*const*/ SCEV /*P*/ Numerator, 
      /*const*/ SCEV /*P*/ Denominator) {
    // : SCEVVisitor<SCEVDivision, void>(), SE(S), Denominator(Denominator) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Convenience function for giving up on the division. We set the quotient to
  // be equal to zero and the remainder to be equal to the numerator.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SCEVDivision::cannotDivide">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 912,
   FQN="(anonymous namespace)::SCEVDivision::cannotDivide", NM="_ZN12_GLOBAL__N_112SCEVDivision12cannotDivideEPKN4llvm4SCEVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_112SCEVDivision12cannotDivideEPKN4llvm4SCEVE")
  //</editor-fold>
  private void cannotDivide(/*const*/ SCEV /*P*/ Numerator) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private final ScalarEvolution /*&*/ SE;
  private /*const*/ SCEV /*P*/ Denominator;
  private /*const*/ SCEV /*P*/ Quotient;
  private /*const*/ SCEV /*P*/ Remainder;
  private /*const*/ SCEV /*P*/ Zero;
  private /*const*/ SCEV /*P*/ One;
  
  @Override public String toString() {
    return "" + "SE=" + SE // NOI18N
              + ", Denominator=" + Denominator // NOI18N
              + ", Quotient=" + Quotient // NOI18N
              + ", Remainder=" + Remainder // NOI18N
              + ", Zero=" + Zero // NOI18N
              + ", One=" + One // NOI18N
              + super.toString(); // NOI18N
  }
}
