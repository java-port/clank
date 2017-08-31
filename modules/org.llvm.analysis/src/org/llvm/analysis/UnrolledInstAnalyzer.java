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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 40,
 FQN="llvm::UnrolledInstAnalyzer", NM="_ZN4llvm20UnrolledInstAnalyzerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzerE")
//</editor-fold>
public class UnrolledInstAnalyzer implements /*private*/ InstVisitorBool<UnrolledInstAnalyzer>, Destructors.ClassWithDestructor {
  // JAVA: typedef InstVisitor<UnrolledInstAnalyzer, bool> Base
//  public final class Base extends InstVisitor<UnrolledInstAnalyzer, boolean>{ };
  /*friend  class InstVisitor<UnrolledInstAnalyzer, bool>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::SimplifiedAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 43,
   FQN="llvm::UnrolledInstAnalyzer::SimplifiedAddress", NM="_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressE")
  //</editor-fold>
  private static class/*struct*/ SimplifiedAddress {
    public Value /*P*/ Base/* = null*/;
    public ConstantInt /*P*/ Offset/* = null*/;
    //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::SimplifiedAddress::SimplifiedAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 43,
     FQN="llvm::UnrolledInstAnalyzer::SimplifiedAddress::SimplifiedAddress", NM="_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressC1Ev")
    //</editor-fold>
    public /*inline*/ SimplifiedAddress() {
      // : Base(null), Offset(null) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::SimplifiedAddress::SimplifiedAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 43,
     FQN="llvm::UnrolledInstAnalyzer::SimplifiedAddress::SimplifiedAddress", NM="_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressC1ERKS1_")
    //</editor-fold>
    public /*inline*/ SimplifiedAddress(final /*const*/ SimplifiedAddress /*&*/ $Prm0) {
      // : Base(.Base), Offset(.Offset) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::SimplifiedAddress::SimplifiedAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 43,
     FQN="llvm::UnrolledInstAnalyzer::SimplifiedAddress::SimplifiedAddress", NM="_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressC1EOS1_")
    //</editor-fold>
    public /*inline*/ SimplifiedAddress(JD$Move _dparam, final SimplifiedAddress /*&&*/$Prm0) {
      // : Base(static_cast<SimplifiedAddress &&>().Base), Offset(static_cast<SimplifiedAddress &&>().Offset) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::SimplifiedAddress::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 43,
     FQN="llvm::UnrolledInstAnalyzer::SimplifiedAddress::operator=", NM="_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer17SimplifiedAddressaSERKS1_")
    //</editor-fold>
    public /*inline*/ SimplifiedAddress /*&*/ $assign(final /*const*/ SimplifiedAddress /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Base=" + Base // NOI18N
                + ", Offset=" + Offset; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::UnrolledInstAnalyzer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 49,
   FQN="llvm::UnrolledInstAnalyzer::UnrolledInstAnalyzer", NM="_ZN4llvm20UnrolledInstAnalyzerC1EjRNS_8DenseMapIPNS_5ValueEPNS_8ConstantENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S5_EEEERNS_15ScalarEvolutionEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzerC1EjRNS_8DenseMapIPNS_5ValueEPNS_8ConstantENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S5_EEEERNS_15ScalarEvolutionEPKNS_4LoopE")
  //</editor-fold>
  public UnrolledInstAnalyzer(/*uint*/int Iteration, 
      final DenseMap<Value /*P*/ , Constant /*P*/ > /*&*/ SimplifiedValues, 
      final ScalarEvolution /*&*/ SE, /*const*/ Loop /*P*/ L) {
    // : InstVisitor<UnrolledInstAnalyzer, bool>(), SimplifiedAddresses(), SimplifiedValues(SimplifiedValues), SE(SE), L(L) 
    $InstVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Allow access to the initial visit method.
  //JAVA: using InstVisitor<UnrolledInstAnalyzer, boolean>::visit;
/*private:*/
  /// \brief A cache of pointer bases and constant-folded offsets corresponding
  /// to GEP (or derived from GEP) instructions.
  ///
  /// In order to find the base pointer one needs to perform non-trivial
  /// traversal of the corresponding SCEV expression, so it's good to have the
  /// results saved.
  private DenseMap<Value /*P*/ , SimplifiedAddress> SimplifiedAddresses;
  
  /// \brief SCEV expression corresponding to number of currently simulated
  /// iteration.
  private /*const*/ SCEV /*P*/ IterationNumber;
  
  /// \brief A Value->Constant map for keeping values that we managed to
  /// constant-fold on the given iteration.
  ///
  /// While we walk the loop instructions, we build up and maintain a mapping
  /// of simplified values specific to this iteration.  The idea is to propagate
  /// any special information we have about loads that can be replaced with
  /// constants after complete unrolling, and account for likely simplifications
  /// post-unrolling.
  private final DenseMap<Value /*P*/ , Constant /*P*/ > /*&*/ SimplifiedValues;
  
  private final ScalarEvolution /*&*/ SE;
  private /*const*/ Loop /*P*/ L;
  
  
  /// \brief Try to simplify instruction \param I using its SCEV expression.
  ///
  /// The idea is that some AddRec expressions become constants, which then
  /// could trigger folding of other instructions. However, that only happens
  /// for expressions whose start value is also constant, which isn't always the
  /// case. In another common and important case the start value is just some
  /// address (i.e. SCEVUnknown) - in this case we compute the offset and save
  /// it along with the base address instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::simplifyInstWithSCEV">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp", line = 29,
   FQN="llvm::UnrolledInstAnalyzer::simplifyInstWithSCEV", NM="_ZN4llvm20UnrolledInstAnalyzer20simplifyInstWithSCEVEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer20simplifyInstWithSCEVEPNS_11InstructionE")
  //</editor-fold>
  private boolean simplifyInstWithSCEV(Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::visitInstruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 87,
   FQN="llvm::UnrolledInstAnalyzer::visitInstruction", NM="_ZN4llvm20UnrolledInstAnalyzer16visitInstructionERNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer16visitInstructionERNS_11InstructionE")
  //</editor-fold>
  public/*private*/ boolean visitInstruction(final Instruction /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to simplify binary operator I.
  ///
  /// TODO: Probably it's worth to hoist the code for estimating the
  /// simplifications effects to a separate class, since we have a very similar
  /// code in InlineCost already.
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::visitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp", line = 70,
   FQN="llvm::UnrolledInstAnalyzer::visitBinaryOperator", NM="_ZN4llvm20UnrolledInstAnalyzer19visitBinaryOperatorERNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer19visitBinaryOperatorERNS_14BinaryOperatorE")
  //</editor-fold>
  public/*private*/ boolean visitBinaryOperator(final BinaryOperator /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to fold load I.
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::visitLoad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp", line = 96,
   FQN="llvm::UnrolledInstAnalyzer::visitLoad", NM="_ZN4llvm20UnrolledInstAnalyzer9visitLoadERNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer9visitLoadERNS_8LoadInstE")
  //</editor-fold>
  public/*private*/ boolean visitLoad(final LoadInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to simplify cast instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::visitCastInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp", line = 145,
   FQN="llvm::UnrolledInstAnalyzer::visitCastInst", NM="_ZN4llvm20UnrolledInstAnalyzer13visitCastInstERNS_8CastInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer13visitCastInstERNS_8CastInstE")
  //</editor-fold>
  public/*private*/ boolean visitCastInst(final CastInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Try to simplify cmp instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::visitCmpInst">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp", line = 168,
   FQN="llvm::UnrolledInstAnalyzer::visitCmpInst", NM="_ZN4llvm20UnrolledInstAnalyzer12visitCmpInstERNS_7CmpInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer12visitCmpInstERNS_7CmpInstE")
  //</editor-fold>
  public/*private*/ boolean visitCmpInst(final CmpInst /*&*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::visitPHINode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp", line = 208,
   FQN="llvm::UnrolledInstAnalyzer::visitPHINode", NM="_ZN4llvm20UnrolledInstAnalyzer12visitPHINodeERNS_7PHINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopUnrollAnalyzer.cpp -nm=_ZN4llvm20UnrolledInstAnalyzer12visitPHINodeERNS_7PHINodeE")
  //</editor-fold>
  public/*private*/ boolean visitPHINode(final PHINode /*&*/ PN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnrolledInstAnalyzer::~UnrolledInstAnalyzer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopUnrollAnalyzer.h", line = 40,
   FQN="llvm::UnrolledInstAnalyzer::~UnrolledInstAnalyzer", NM="_ZN4llvm20UnrolledInstAnalyzerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm20UnrolledInstAnalyzerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "SimplifiedAddresses=" + SimplifiedAddresses // NOI18N
              + ", IterationNumber=" + IterationNumber // NOI18N
              + ", SimplifiedValues=" + SimplifiedValues // NOI18N
              + ", SE=" + SE // NOI18N
              + ", L=" + L // NOI18N
              + super.toString(); // NOI18N
  }
}
