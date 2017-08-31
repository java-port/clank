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

package org.llvm.analysis.target;

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


/// \brief Base class for use as a mix-in that aids implementing
/// a TargetTransformInfo-compatible class.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 31,
 FQN="llvm::TargetTransformInfoImplBase", NM="_ZN4llvm27TargetTransformInfoImplBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBaseE")
//</editor-fold>
public class TargetTransformInfoImplBase {
/*protected:*/
  // JAVA: typedef TargetTransformInfo TTI
//  public final class TTI extends TargetTransformInfo{ };
  
  protected final /*const*/ DataLayout /*&*/ DL;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::TargetTransformInfoImplBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 37,
   FQN="llvm::TargetTransformInfoImplBase::TargetTransformInfoImplBase", NM="_ZN4llvm27TargetTransformInfoImplBaseC1ERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBaseC1ERKNS_10DataLayoutE")
  //</editor-fold>
  protected /*explicit*/ TargetTransformInfoImplBase(final /*const*/ DataLayout /*&*/ DL) {
    // : DL(DL) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  // Provide value semantics. MSVC requires that we spell all of these out.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::TargetTransformInfoImplBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 41,
   FQN="llvm::TargetTransformInfoImplBase::TargetTransformInfoImplBase", NM="_ZN4llvm27TargetTransformInfoImplBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBaseC1ERKS0_")
  //</editor-fold>
  public TargetTransformInfoImplBase(final /*const*/ TargetTransformInfoImplBase /*&*/ Arg) {
    // : DL(Arg.DL) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::TargetTransformInfoImplBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 43,
   FQN="llvm::TargetTransformInfoImplBase::TargetTransformInfoImplBase", NM="_ZN4llvm27TargetTransformInfoImplBaseC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBaseC1EOS0_")
  //</editor-fold>
  public TargetTransformInfoImplBase(JD$Move _dparam, final TargetTransformInfoImplBase /*&&*/Arg) {
    // : DL(Arg.DL) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getDataLayout">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 45,
   FQN="llvm::TargetTransformInfoImplBase::getDataLayout", NM="_ZNK4llvm27TargetTransformInfoImplBase13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm27TargetTransformInfoImplBase13getDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getOperationCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 47,
   FQN="llvm::TargetTransformInfoImplBase::getOperationCost", NM="_ZN4llvm27TargetTransformInfoImplBase16getOperationCostEjPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getOperationCostEjPNS_4TypeES2_")
  //</editor-fold>
  public /*uint*/int getOperationCost(/*uint*/int Opcode, Type /*P*/ Ty, Type /*P*/ OpTy) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getGEPCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 105,
   FQN="llvm::TargetTransformInfoImplBase::getGEPCost", NM="_ZN4llvm27TargetTransformInfoImplBase10getGEPCostEPNS_4TypeEPKNS_5ValueENS_8ArrayRefIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase10getGEPCostEPNS_4TypeEPKNS_5ValueENS_8ArrayRefIS5_EE")
  //</editor-fold>
  public int getGEPCost(Type /*P*/ PointeeType, /*const*/ Value /*P*/ Ptr, 
            ArrayRef</*const*/ Value /*P*/ > Operands) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCallCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 116,
   FQN="llvm::TargetTransformInfoImplBase::getCallCost", NM="_ZN4llvm27TargetTransformInfoImplBase11getCallCostEPNS_12FunctionTypeEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase11getCallCostEPNS_12FunctionTypeEi")
  //</editor-fold>
  public /*uint*/int getCallCost(FunctionType /*P*/ FTy, int NumArgs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getInliningThresholdMultiplier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 131,
   FQN="llvm::TargetTransformInfoImplBase::getInliningThresholdMultiplier", NM="_ZN4llvm27TargetTransformInfoImplBase30getInliningThresholdMultiplierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase30getInliningThresholdMultiplierEv")
  //</editor-fold>
  public /*uint*/int getInliningThresholdMultiplier() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntrinsicCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 133,
   FQN="llvm::TargetTransformInfoImplBase::getIntrinsicCost", NM="_ZN4llvm27TargetTransformInfoImplBase16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public /*uint*/int getIntrinsicCost(/*Intrinsic.ID*/int IID, Type /*P*/ RetTy, 
                  ArrayRef<Type /*P*/ > ParamTys) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::hasBranchDivergence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 160,
   FQN="llvm::TargetTransformInfoImplBase::hasBranchDivergence", NM="_ZN4llvm27TargetTransformInfoImplBase19hasBranchDivergenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19hasBranchDivergenceEv")
  //</editor-fold>
  public boolean hasBranchDivergence() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isSourceOfDivergence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 162,
   FQN="llvm::TargetTransformInfoImplBase::isSourceOfDivergence", NM="_ZN4llvm27TargetTransformInfoImplBase20isSourceOfDivergenceEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase20isSourceOfDivergenceEPKNS_5ValueE")
  //</editor-fold>
  public boolean isSourceOfDivergence(/*const*/ Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLoweredToCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 164,
   FQN="llvm::TargetTransformInfoImplBase::isLoweredToCall", NM="_ZN4llvm27TargetTransformInfoImplBase15isLoweredToCallEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase15isLoweredToCallEPKNS_8FunctionE")
  //</editor-fold>
  public boolean isLoweredToCall(/*const*/ Function /*P*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getUnrollingPreferences">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 198,
   FQN="llvm::TargetTransformInfoImplBase::getUnrollingPreferences", NM="_ZN4llvm27TargetTransformInfoImplBase23getUnrollingPreferencesEPNS_4LoopERNS_19TargetTransformInfo20UnrollingPreferencesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase23getUnrollingPreferencesEPNS_4LoopERNS_19TargetTransformInfo20UnrollingPreferencesE")
  //</editor-fold>
  public void getUnrollingPreferences(Loop /*P*/ $Prm0, final TargetTransformInfo.UnrollingPreferences /*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalAddImmediate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 200,
   FQN="llvm::TargetTransformInfoImplBase::isLegalAddImmediate", NM="_ZN4llvm27TargetTransformInfoImplBase19isLegalAddImmediateEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19isLegalAddImmediateEx")
  //</editor-fold>
  public boolean isLegalAddImmediate(long/*int64_t*/ Imm) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalICmpImmediate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 202,
   FQN="llvm::TargetTransformInfoImplBase::isLegalICmpImmediate", NM="_ZN4llvm27TargetTransformInfoImplBase20isLegalICmpImmediateEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase20isLegalICmpImmediateEx")
  //</editor-fold>
  public boolean isLegalICmpImmediate(long/*int64_t*/ Imm) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalAddressingMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 204,
   FQN="llvm::TargetTransformInfoImplBase::isLegalAddressingMode", NM="_ZN4llvm27TargetTransformInfoImplBase21isLegalAddressingModeEPNS_4TypeEPNS_11GlobalValueExbxj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase21isLegalAddressingModeEPNS_4TypeEPNS_11GlobalValueExbxj")
  //</editor-fold>
  public boolean isLegalAddressingMode(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, long/*int64_t*/ BaseOffset, 
                       boolean HasBaseReg, long/*int64_t*/ Scale, 
                       /*uint*/int AddrSpace) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalMaskedStore">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 212,
   FQN="llvm::TargetTransformInfoImplBase::isLegalMaskedStore", NM="_ZN4llvm27TargetTransformInfoImplBase18isLegalMaskedStoreEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase18isLegalMaskedStoreEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedStore(Type /*P*/ DataType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalMaskedLoad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 214,
   FQN="llvm::TargetTransformInfoImplBase::isLegalMaskedLoad", NM="_ZN4llvm27TargetTransformInfoImplBase17isLegalMaskedLoadEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase17isLegalMaskedLoadEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedLoad(Type /*P*/ DataType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalMaskedScatter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 216,
   FQN="llvm::TargetTransformInfoImplBase::isLegalMaskedScatter", NM="_ZN4llvm27TargetTransformInfoImplBase20isLegalMaskedScatterEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase20isLegalMaskedScatterEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedScatter(Type /*P*/ DataType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isLegalMaskedGather">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 218,
   FQN="llvm::TargetTransformInfoImplBase::isLegalMaskedGather", NM="_ZN4llvm27TargetTransformInfoImplBase19isLegalMaskedGatherEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19isLegalMaskedGatherEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedGather(Type /*P*/ DataType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getScalingFactorCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 220,
   FQN="llvm::TargetTransformInfoImplBase::getScalingFactorCost", NM="_ZN4llvm27TargetTransformInfoImplBase20getScalingFactorCostEPNS_4TypeEPNS_11GlobalValueExbxj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase20getScalingFactorCostEPNS_4TypeEPNS_11GlobalValueExbxj")
  //</editor-fold>
  public int getScalingFactorCost(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, long/*int64_t*/ BaseOffset, 
                      boolean HasBaseReg, long/*int64_t*/ Scale, /*uint*/int AddrSpace) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isTruncateFree">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 229,
   FQN="llvm::TargetTransformInfoImplBase::isTruncateFree", NM="_ZN4llvm27TargetTransformInfoImplBase14isTruncateFreeEPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase14isTruncateFreeEPNS_4TypeES2_")
  //</editor-fold>
  public boolean isTruncateFree(Type /*P*/ Ty1, Type /*P*/ Ty2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isProfitableToHoist">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 231,
   FQN="llvm::TargetTransformInfoImplBase::isProfitableToHoist", NM="_ZN4llvm27TargetTransformInfoImplBase19isProfitableToHoistEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19isProfitableToHoistEPNS_11InstructionE")
  //</editor-fold>
  public boolean isProfitableToHoist(Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isTypeLegal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 233,
   FQN="llvm::TargetTransformInfoImplBase::isTypeLegal", NM="_ZN4llvm27TargetTransformInfoImplBase11isTypeLegalEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase11isTypeLegalEPNS_4TypeE")
  //</editor-fold>
  public boolean isTypeLegal(Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getJumpBufAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 235,
   FQN="llvm::TargetTransformInfoImplBase::getJumpBufAlignment", NM="_ZN4llvm27TargetTransformInfoImplBase19getJumpBufAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19getJumpBufAlignmentEv")
  //</editor-fold>
  public /*uint*/int getJumpBufAlignment() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getJumpBufSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 237,
   FQN="llvm::TargetTransformInfoImplBase::getJumpBufSize", NM="_ZN4llvm27TargetTransformInfoImplBase14getJumpBufSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase14getJumpBufSizeEv")
  //</editor-fold>
  public /*uint*/int getJumpBufSize() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::shouldBuildLookupTables">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 239,
   FQN="llvm::TargetTransformInfoImplBase::shouldBuildLookupTables", NM="_ZN4llvm27TargetTransformInfoImplBase23shouldBuildLookupTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase23shouldBuildLookupTablesEv")
  //</editor-fold>
  public boolean shouldBuildLookupTables() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::enableAggressiveInterleaving">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 241,
   FQN="llvm::TargetTransformInfoImplBase::enableAggressiveInterleaving", NM="_ZN4llvm27TargetTransformInfoImplBase28enableAggressiveInterleavingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase28enableAggressiveInterleavingEb")
  //</editor-fold>
  public boolean enableAggressiveInterleaving(boolean LoopHasReductions) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::enableInterleavedAccessVectorization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 243,
   FQN="llvm::TargetTransformInfoImplBase::enableInterleavedAccessVectorization", NM="_ZN4llvm27TargetTransformInfoImplBase36enableInterleavedAccessVectorizationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase36enableInterleavedAccessVectorizationEv")
  //</editor-fold>
  public boolean enableInterleavedAccessVectorization() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::isFPVectorizationPotentiallyUnsafe">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 245,
   FQN="llvm::TargetTransformInfoImplBase::isFPVectorizationPotentiallyUnsafe", NM="_ZN4llvm27TargetTransformInfoImplBase34isFPVectorizationPotentiallyUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase34isFPVectorizationPotentiallyUnsafeEv")
  //</editor-fold>
  public boolean isFPVectorizationPotentiallyUnsafe() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::allowsMisalignedMemoryAccesses">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 247,
   FQN="llvm::TargetTransformInfoImplBase::allowsMisalignedMemoryAccesses", NM="_ZN4llvm27TargetTransformInfoImplBase30allowsMisalignedMemoryAccessesEjjjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase30allowsMisalignedMemoryAccessesEjjjPb")
  //</editor-fold>
  public boolean allowsMisalignedMemoryAccesses(/*uint*/int BitWidth, 
                                /*uint*/int AddressSpace, 
                                /*uint*/int Alignment, 
                                bool$ptr/*bool P*/ Fast) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getPopcntSupport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 252,
   FQN="llvm::TargetTransformInfoImplBase::getPopcntSupport", NM="_ZN4llvm27TargetTransformInfoImplBase16getPopcntSupportEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getPopcntSupportEj")
  //</editor-fold>
  public TargetTransformInfo.PopcntSupportKind getPopcntSupport(/*uint*/int IntTyWidthInBit) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::haveFastSqrt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 256,
   FQN="llvm::TargetTransformInfoImplBase::haveFastSqrt", NM="_ZN4llvm27TargetTransformInfoImplBase12haveFastSqrtEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase12haveFastSqrtEPNS_4TypeE")
  //</editor-fold>
  public boolean haveFastSqrt(Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getFPOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 258,
   FQN="llvm::TargetTransformInfoImplBase::getFPOpCost", NM="_ZN4llvm27TargetTransformInfoImplBase11getFPOpCostEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase11getFPOpCostEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getFPOpCost(Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntImmCodeSizeCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 260,
   FQN="llvm::TargetTransformInfoImplBase::getIntImmCodeSizeCost", NM="_ZN4llvm27TargetTransformInfoImplBase21getIntImmCodeSizeCostEjjRKNS_5APIntEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase21getIntImmCodeSizeCostEjjRKNS_5APIntEPNS_4TypeE")
  //</editor-fold>
  public int getIntImmCodeSizeCost(/*uint*/int Opcode, /*uint*/int Idx, final /*const*/ APInt /*&*/ Imm, 
                       Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntImmCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 265,
   FQN="llvm::TargetTransformInfoImplBase::getIntImmCost", NM="_ZN4llvm27TargetTransformInfoImplBase13getIntImmCostERKNS_5APIntEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase13getIntImmCostERKNS_5APIntEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getIntImmCost(final /*const*/ APInt /*&*/ Imm, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntImmCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 267,
   FQN="llvm::TargetTransformInfoImplBase::getIntImmCost", NM="_ZN4llvm27TargetTransformInfoImplBase13getIntImmCostEjjRKNS_5APIntEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase13getIntImmCostEjjRKNS_5APIntEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getIntImmCost(/*uint*/int Opcode, /*uint*/int Idx, final /*const*/ APInt /*&*/ Imm, 
               Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntImmCost">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 272,
//   FQN="llvm::TargetTransformInfoImplBase::getIntImmCost", NM="_ZN4llvm27TargetTransformInfoImplBase13getIntImmCostENS_9Intrinsic2IDEjRKNS_5APIntEPNS_4TypeE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase13getIntImmCostENS_9Intrinsic2IDEjRKNS_5APIntEPNS_4TypeE")
//  //</editor-fold>
//  public /*uint*/int getIntImmCost(/*Intrinsic.ID*/int IID, /*uint*/int Idx, final /*const*/ APInt /*&*/ Imm, 
//               Type /*P*/ Ty) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getNumberOfRegisters">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 277,
   FQN="llvm::TargetTransformInfoImplBase::getNumberOfRegisters", NM="_ZN4llvm27TargetTransformInfoImplBase20getNumberOfRegistersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase20getNumberOfRegistersEb")
  //</editor-fold>
  public /*uint*/int getNumberOfRegisters(boolean Vector) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getRegisterBitWidth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 279,
   FQN="llvm::TargetTransformInfoImplBase::getRegisterBitWidth", NM="_ZN4llvm27TargetTransformInfoImplBase19getRegisterBitWidthEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19getRegisterBitWidthEb")
  //</editor-fold>
  public /*uint*/int getRegisterBitWidth(boolean Vector) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getLoadStoreVecRegBitWidth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 281,
   FQN="llvm::TargetTransformInfoImplBase::getLoadStoreVecRegBitWidth", NM="_ZN4llvm27TargetTransformInfoImplBase26getLoadStoreVecRegBitWidthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase26getLoadStoreVecRegBitWidthEj")
  //</editor-fold>
  public /*uint*/int getLoadStoreVecRegBitWidth(/*uint*/int AddrSpace) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCacheLineSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 283,
   FQN="llvm::TargetTransformInfoImplBase::getCacheLineSize", NM="_ZN4llvm27TargetTransformInfoImplBase16getCacheLineSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getCacheLineSizeEv")
  //</editor-fold>
  public /*uint*/int getCacheLineSize() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getPrefetchDistance">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 285,
   FQN="llvm::TargetTransformInfoImplBase::getPrefetchDistance", NM="_ZN4llvm27TargetTransformInfoImplBase19getPrefetchDistanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase19getPrefetchDistanceEv")
  //</editor-fold>
  public /*uint*/int getPrefetchDistance() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getMinPrefetchStride">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 287,
   FQN="llvm::TargetTransformInfoImplBase::getMinPrefetchStride", NM="_ZN4llvm27TargetTransformInfoImplBase20getMinPrefetchStrideEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase20getMinPrefetchStrideEv")
  //</editor-fold>
  public /*uint*/int getMinPrefetchStride() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getMaxPrefetchIterationsAhead">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 289,
   FQN="llvm::TargetTransformInfoImplBase::getMaxPrefetchIterationsAhead", NM="_ZN4llvm27TargetTransformInfoImplBase29getMaxPrefetchIterationsAheadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase29getMaxPrefetchIterationsAheadEv")
  //</editor-fold>
  public /*uint*/int getMaxPrefetchIterationsAhead() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getMaxInterleaveFactor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 291,
   FQN="llvm::TargetTransformInfoImplBase::getMaxInterleaveFactor", NM="_ZN4llvm27TargetTransformInfoImplBase22getMaxInterleaveFactorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase22getMaxInterleaveFactorEj")
  //</editor-fold>
  public /*uint*/int getMaxInterleaveFactor(/*uint*/int VF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getArithmeticInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 293,
   FQN="llvm::TargetTransformInfoImplBase::getArithmeticInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase22getArithmeticInstrCostEjPNS_4TypeENS_19TargetTransformInfo16OperandValueKindES4_NS3_22OperandValuePropertiesES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase22getArithmeticInstrCostEjPNS_4TypeENS_19TargetTransformInfo16OperandValueKindES4_NS3_22OperandValuePropertiesES5_")
  //</editor-fold>
  public /*uint*/int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty, 
                        TargetTransformInfo.OperandValueKind Opd1Info, 
                        TargetTransformInfo.OperandValueKind Opd2Info, 
                        TargetTransformInfo.OperandValueProperties Opd1PropInfo, 
                        TargetTransformInfo.OperandValueProperties Opd2PropInfo) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getShuffleCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 301,
   FQN="llvm::TargetTransformInfoImplBase::getShuffleCost", NM="_ZN4llvm27TargetTransformInfoImplBase14getShuffleCostENS_19TargetTransformInfo11ShuffleKindEPNS_4TypeEiS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase14getShuffleCostENS_19TargetTransformInfo11ShuffleKindEPNS_4TypeEiS4_")
  //</editor-fold>
  public /*uint*/int getShuffleCost(TargetTransformInfo.ShuffleKind Kind, Type /*P*/ Ty, int Index, 
                Type /*P*/ SubTp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCastInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 306,
   FQN="llvm::TargetTransformInfoImplBase::getCastInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase16getCastInstrCostEjPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getCastInstrCostEjPNS_4TypeES2_")
  //</editor-fold>
  public /*uint*/int getCastInstrCost(/*uint*/int Opcode, Type /*P*/ Dst, Type /*P*/ Src) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getExtractWithExtendCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 308,
   FQN="llvm::TargetTransformInfoImplBase::getExtractWithExtendCost", NM="_ZN4llvm27TargetTransformInfoImplBase24getExtractWithExtendCostEjPNS_4TypeEPNS_10VectorTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase24getExtractWithExtendCostEjPNS_4TypeEPNS_10VectorTypeEj")
  //</editor-fold>
  public /*uint*/int getExtractWithExtendCost(/*uint*/int Opcode, Type /*P*/ Dst, 
                          VectorType /*P*/ VecTy, /*uint*/int Index) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCFInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 313,
   FQN="llvm::TargetTransformInfoImplBase::getCFInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase14getCFInstrCostEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase14getCFInstrCostEj")
  //</editor-fold>
  public /*uint*/int getCFInstrCost(/*uint*/int Opcode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCmpSelInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 315,
   FQN="llvm::TargetTransformInfoImplBase::getCmpSelInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase18getCmpSelInstrCostEjPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase18getCmpSelInstrCostEjPNS_4TypeES2_")
  //</editor-fold>
  public /*uint*/int getCmpSelInstrCost(/*uint*/int Opcode, Type /*P*/ ValTy, Type /*P*/ CondTy) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getVectorInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 319,
   FQN="llvm::TargetTransformInfoImplBase::getVectorInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase18getVectorInstrCostEjPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase18getVectorInstrCostEjPNS_4TypeEj")
  //</editor-fold>
  public /*uint*/int getVectorInstrCost(/*uint*/int Opcode, Type /*P*/ Val, /*uint*/int Index) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getMemoryOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 323,
   FQN="llvm::TargetTransformInfoImplBase::getMemoryOpCost", NM="_ZN4llvm27TargetTransformInfoImplBase15getMemoryOpCostEjPNS_4TypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase15getMemoryOpCostEjPNS_4TypeEjj")
  //</editor-fold>
  public /*uint*/int getMemoryOpCost(/*uint*/int Opcode, Type /*P*/ Src, /*uint*/int Alignment, 
                 /*uint*/int AddressSpace) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getMaskedMemoryOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 328,
   FQN="llvm::TargetTransformInfoImplBase::getMaskedMemoryOpCost", NM="_ZN4llvm27TargetTransformInfoImplBase21getMaskedMemoryOpCostEjPNS_4TypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase21getMaskedMemoryOpCostEjPNS_4TypeEjj")
  //</editor-fold>
  public /*uint*/int getMaskedMemoryOpCost(/*uint*/int Opcode, Type /*P*/ Src, /*uint*/int Alignment, 
                       /*uint*/int AddressSpace) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getGatherScatterOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 333,
   FQN="llvm::TargetTransformInfoImplBase::getGatherScatterOpCost", NM="_ZN4llvm27TargetTransformInfoImplBase22getGatherScatterOpCostEjPNS_4TypeEPNS_5ValueEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase22getGatherScatterOpCostEjPNS_4TypeEPNS_5ValueEbj")
  //</editor-fold>
  public /*uint*/int getGatherScatterOpCost(/*uint*/int Opcode, Type /*P*/ DataTy, Value /*P*/ Ptr, 
                        boolean VariableMask, 
                        /*uint*/int Alignment) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getInterleavedMemoryOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 339,
   FQN="llvm::TargetTransformInfoImplBase::getInterleavedMemoryOpCost", NM="_ZN4llvm27TargetTransformInfoImplBase26getInterleavedMemoryOpCostEjPNS_4TypeEjNS_8ArrayRefIjEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase26getInterleavedMemoryOpCostEjPNS_4TypeEjNS_8ArrayRefIjEEjj")
  //</editor-fold>
  public /*uint*/int getInterleavedMemoryOpCost(/*uint*/int Opcode, Type /*P*/ VecTy, 
                            /*uint*/int Factor, 
                            ArrayRefUInt Indices, 
                            /*uint*/int Alignment, 
                            /*uint*/int AddressSpace) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntrinsicInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 347,
   FQN="llvm::TargetTransformInfoImplBase::getIntrinsicInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EENS_13FastMathFlagsE")
  //</editor-fold>
  public /*uint*/int getIntrinsicInstrCost_ID_Type$P_ArrayRef$Type$P_FastMathFlags(/*Intrinsic.ID*/int ID, Type /*P*/ RetTy, 
                                                               ArrayRef<Type /*P*/ > Tys, FastMathFlags FMF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getIntrinsicInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 351,
   FQN="llvm::TargetTransformInfoImplBase::getIntrinsicInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEENS_13FastMathFlagsE")
  //</editor-fold>
  public /*uint*/int getIntrinsicInstrCost_ID_Type$P_ArrayRef$Value$P_FastMathFlags(/*Intrinsic.ID*/int ID, Type /*P*/ RetTy, 
                                                                ArrayRef<Value /*P*/ > Args, FastMathFlags FMF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCallInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 356,
   FQN="llvm::TargetTransformInfoImplBase::getCallInstrCost", NM="_ZN4llvm27TargetTransformInfoImplBase16getCallInstrCostEPNS_8FunctionEPNS_4TypeENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getCallInstrCostEPNS_8FunctionEPNS_4TypeENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public /*uint*/int getCallInstrCost(Function /*P*/ F, Type /*P*/ RetTy, ArrayRef<Type /*P*/ > Tys) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getNumberOfParts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 360,
   FQN="llvm::TargetTransformInfoImplBase::getNumberOfParts", NM="_ZN4llvm27TargetTransformInfoImplBase16getNumberOfPartsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getNumberOfPartsEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getNumberOfParts(Type /*P*/ Tp) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getAddressComputationCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 362,
   FQN="llvm::TargetTransformInfoImplBase::getAddressComputationCost", NM="_ZN4llvm27TargetTransformInfoImplBase25getAddressComputationCostEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase25getAddressComputationCostEPNS_4TypeEb")
  //</editor-fold>
  public /*uint*/int getAddressComputationCost(Type /*P*/ Tp, boolean $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getReductionCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 364,
   FQN="llvm::TargetTransformInfoImplBase::getReductionCost", NM="_ZN4llvm27TargetTransformInfoImplBase16getReductionCostEjPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase16getReductionCostEjPNS_4TypeEb")
  //</editor-fold>
  public /*uint*/int getReductionCost(/*uint*/int $Prm0, Type /*P*/ $Prm1, boolean $Prm2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getCostOfKeepingLiveOverCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 366,
   FQN="llvm::TargetTransformInfoImplBase::getCostOfKeepingLiveOverCall", NM="_ZN4llvm27TargetTransformInfoImplBase28getCostOfKeepingLiveOverCallENS_8ArrayRefIPNS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase28getCostOfKeepingLiveOverCallENS_8ArrayRefIPNS_4TypeEEE")
  //</editor-fold>
  public /*uint*/int getCostOfKeepingLiveOverCall(ArrayRef<Type /*P*/ > Tys) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getTgtMemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 368,
   FQN="llvm::TargetTransformInfoImplBase::getTgtMemIntrinsic", NM="_ZN4llvm27TargetTransformInfoImplBase18getTgtMemIntrinsicEPNS_13IntrinsicInstERNS_16MemIntrinsicInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase18getTgtMemIntrinsicEPNS_13IntrinsicInstERNS_16MemIntrinsicInfoE")
  //</editor-fold>
  public boolean getTgtMemIntrinsic(IntrinsicInst /*P*/ Inst, final MemIntrinsicInfo /*&*/ Info) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::getOrCreateResultFromMemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 372,
   FQN="llvm::TargetTransformInfoImplBase::getOrCreateResultFromMemIntrinsic", NM="_ZN4llvm27TargetTransformInfoImplBase33getOrCreateResultFromMemIntrinsicEPNS_13IntrinsicInstEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm27TargetTransformInfoImplBase33getOrCreateResultFromMemIntrinsicEPNS_13IntrinsicInstEPNS_4TypeE")
  //</editor-fold>
  public Value /*P*/ getOrCreateResultFromMemIntrinsic(IntrinsicInst /*P*/ Inst, 
                                   Type /*P*/ ExpectedType) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoImplBase::areInlineCompatible">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfoImpl.h", line = 377,
   FQN="llvm::TargetTransformInfoImplBase::areInlineCompatible", NM="_ZNK4llvm27TargetTransformInfoImplBase19areInlineCompatibleEPKNS_8FunctionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm27TargetTransformInfoImplBase19areInlineCompatibleEPKNS_8FunctionES3_")
  //</editor-fold>
  public boolean areInlineCompatible(/*const*/ Function /*P*/ Caller, 
                     /*const*/ Function /*P*/ Callee) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DL=" + DL; // NOI18N
  }
}
