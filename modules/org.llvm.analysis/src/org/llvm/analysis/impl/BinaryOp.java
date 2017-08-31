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

/// Represents an abstract binary operation.  This may exist as a
/// normal instruction or constant expression, or may have been
/// derived from an expression tree.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BinaryOp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3789,
 FQN="(anonymous namespace)::BinaryOp", NM="_ZN12_GLOBAL__N_18BinaryOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_18BinaryOpE")
//</editor-fold>
public class/*struct*/ BinaryOp {
  public /*uint*/int Opcode;
  public Value /*P*/ LHS;
  public Value /*P*/ RHS;
  public boolean IsNSW;
  public boolean IsNUW;
  
  /// Op is set if this BinaryOp corresponds to a concrete LLVM instruction or
  /// constant expression.
  public Operator /*P*/ Op;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BinaryOp::BinaryOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3800,
   FQN="(anonymous namespace)::BinaryOp::BinaryOp", NM="_ZN12_GLOBAL__N_18BinaryOpC1EPN4llvm8OperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_18BinaryOpC1EPN4llvm8OperatorE")
  //</editor-fold>
  public /*explicit*/ BinaryOp(Operator /*P*/ Op) {
    // : Opcode(Op->getOpcode()), LHS(Op->getOperand(0)), RHS(Op->getOperand(1)), IsNSW(false), IsNUW(false), Op(Op) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BinaryOp::BinaryOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3809,
   FQN="(anonymous namespace)::BinaryOp::BinaryOp", NM="_ZN12_GLOBAL__N_18BinaryOpC1EjPN4llvm5ValueES3_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_18BinaryOpC1EjPN4llvm5ValueES3_bb")
  //</editor-fold>
  public /*explicit*/ BinaryOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS) {
    this(Opcode, LHS, RHS, false, 
      false);
  }
  public /*explicit*/ BinaryOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, boolean IsNSW/*= false*/) {
    this(Opcode, LHS, RHS, IsNSW, 
      false);
  }
  public /*explicit*/ BinaryOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS, boolean IsNSW/*= false*/, 
      boolean IsNUW/*= false*/) {
    // : Opcode(Opcode), LHS(LHS), RHS(RHS), IsNSW(IsNSW), IsNUW(IsNUW), Op(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BinaryOp::BinaryOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3789,
   FQN="(anonymous namespace)::BinaryOp::BinaryOp", NM="_ZN12_GLOBAL__N_18BinaryOpC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_18BinaryOpC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BinaryOp(final /*const*/ BinaryOp /*&*/ $Prm0) {
    // : Opcode(.Opcode), LHS(.LHS), RHS(.RHS), IsNSW(.IsNSW), IsNUW(.IsNUW), Op(.Op) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BinaryOp::BinaryOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3789,
   FQN="(anonymous namespace)::BinaryOp::BinaryOp", NM="_ZN12_GLOBAL__N_18BinaryOpC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_18BinaryOpC1EOS0_")
  //</editor-fold>
  public /*inline*/ BinaryOp(JD$Move _dparam, final BinaryOp /*&&*/$Prm0) {
    // : Opcode(static_cast<BinaryOp &&>().Opcode), LHS(static_cast<BinaryOp &&>().LHS), RHS(static_cast<BinaryOp &&>().RHS), IsNSW(static_cast<BinaryOp &&>().IsNSW), IsNUW(static_cast<BinaryOp &&>().IsNUW), Op(static_cast<BinaryOp &&>().Op) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BinaryOp::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 3789,
   FQN="(anonymous namespace)::BinaryOp::operator=", NM="_ZN12_GLOBAL__N_18BinaryOpaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN12_GLOBAL__N_18BinaryOpaSERKS0_")
  //</editor-fold>
  public /*inline*/ BinaryOp /*&*/ $assign(final /*const*/ BinaryOp /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Opcode=" + Opcode // NOI18N
              + ", LHS=" + LHS // NOI18N
              + ", RHS=" + RHS // NOI18N
              + ", IsNSW=" + IsNSW // NOI18N
              + ", IsNUW=" + IsNUW // NOI18N
              + ", Op=" + Op; // NOI18N
  }
}
