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
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.StringRef;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
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


/// Provides information about what library functions are available for
/// the current target.
///
/// This both allows optimizations to handle them specially and frontends to
/// disable such optimizations through -fno-builtin etc.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 181,
 FQN="llvm::TargetLibraryInfo", NM="_ZN4llvm17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfoE")
//</editor-fold>
public class TargetLibraryInfo {
  /*friend  class TargetLibraryAnalysis*/
  /*friend  class TargetLibraryInfoWrapperPass*/

  private /*const*/ TargetLibraryInfoImpl /*P*/ Impl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::TargetLibraryInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 188,
   FQN="llvm::TargetLibraryInfo::TargetLibraryInfo", NM="_ZN4llvm17TargetLibraryInfoC1ERKNS_21TargetLibraryInfoImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfoC1ERKNS_21TargetLibraryInfoImplE")
  //</editor-fold>
  public /*explicit*/ TargetLibraryInfo(final /*const*/ TargetLibraryInfoImpl /*&*/ Impl) {
    // : Impl(&Impl)
    //START JInit
    this.Impl = $AddrOf(Impl);
    //END JInit
  }


  // Provide value semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::TargetLibraryInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 191,
   FQN="llvm::TargetLibraryInfo::TargetLibraryInfo", NM="_ZN4llvm17TargetLibraryInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfoC1ERKS0_")
  //</editor-fold>
  public TargetLibraryInfo(final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    // : Impl(TLI.Impl)
    //START JInit
    this.Impl = TLI.Impl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::TargetLibraryInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 192,
   FQN="llvm::TargetLibraryInfo::TargetLibraryInfo", NM="_ZN4llvm17TargetLibraryInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfoC1EOS0_")
  //</editor-fold>
  public TargetLibraryInfo(JD$Move _dparam, final TargetLibraryInfo /*&&*/TLI) {
    // : Impl(TLI.Impl)
    //START JInit
    this.Impl = TLI.Impl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 193,
   FQN="llvm::TargetLibraryInfo::operator=", NM="_ZN4llvm17TargetLibraryInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfoaSERKS0_")
  //</editor-fold>
  public TargetLibraryInfo /*&*/ $assign(final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    Impl = TLI.Impl;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 197,
   FQN="llvm::TargetLibraryInfo::operator=", NM="_ZN4llvm17TargetLibraryInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfoaSEOS0_")
  //</editor-fold>
  public TargetLibraryInfo /*&*/ $assignMove(final TargetLibraryInfo /*&&*/TLI) {
    Impl = TLI.Impl;
    return /*Deref*/this;
  }


  /// Searches for a particular function name.
  ///
  /// If it is one of the known library functions, return true and set F to the
  /// corresponding value.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::getLibFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 206,
   FQN="llvm::TargetLibraryInfo::getLibFunc", NM="_ZNK4llvm17TargetLibraryInfo10getLibFuncENS_9StringRefERNS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo10getLibFuncENS_9StringRefERNS_7LibFunc4FuncE")
  //</editor-fold>
  public boolean getLibFunc(StringRef funcName, final type$ref<Func /*&*/> F) /*const*/ {
    return Impl.getLibFunc(new StringRef(funcName), F);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::getLibFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 210,
   FQN="llvm::TargetLibraryInfo::getLibFunc", NM="_ZNK4llvm17TargetLibraryInfo10getLibFuncERKNS_8FunctionERNS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo10getLibFuncERKNS_8FunctionERNS_7LibFunc4FuncE")
  //</editor-fold>
  public boolean getLibFunc(final /*const*/ Function /*&*/ FDecl, final type$ref<Func /*&*/> F) /*const*/ {
    return Impl.getLibFunc(FDecl, F);
  }


  /// Tests whether a library function is available.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::has">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 215,
   FQN="llvm::TargetLibraryInfo::has", NM="_ZNK4llvm17TargetLibraryInfo3hasENS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo3hasENS_7LibFunc4FuncE")
  //</editor-fold>
  public boolean has(Func F) /*const*/ {
    return Impl.getState(F) != TargetLibraryInfoImpl.AvailabilityState.Unavailable;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::isFunctionVectorizable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 218,
   FQN="llvm::TargetLibraryInfo::isFunctionVectorizable", NM="_ZNK4llvm17TargetLibraryInfo22isFunctionVectorizableENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo22isFunctionVectorizableENS_9StringRefEj")
  //</editor-fold>
  public boolean isFunctionVectorizable(StringRef F, /*uint*/int VF) /*const*/ {
    return Impl.isFunctionVectorizable(new StringRef(F), VF);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::isFunctionVectorizable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 221,
   FQN="llvm::TargetLibraryInfo::isFunctionVectorizable", NM="_ZNK4llvm17TargetLibraryInfo22isFunctionVectorizableENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo22isFunctionVectorizableENS_9StringRefE")
  //</editor-fold>
  public boolean isFunctionVectorizable(StringRef F) /*const*/ {
    return Impl.isFunctionVectorizable(new StringRef(F));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::getVectorizedFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 224,
   FQN="llvm::TargetLibraryInfo::getVectorizedFunction", NM="_ZNK4llvm17TargetLibraryInfo21getVectorizedFunctionENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo21getVectorizedFunctionENS_9StringRefEj")
  //</editor-fold>
  public StringRef getVectorizedFunction(StringRef F, /*uint*/int VF) /*const*/ {
    return Impl.getVectorizedFunction(new StringRef(F), VF);
  }


  /// Tests if the function is both available and a candidate for optimized code
  /// generation.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::hasOptimizedCodeGen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 230,
   FQN="llvm::TargetLibraryInfo::hasOptimizedCodeGen", NM="_ZNK4llvm17TargetLibraryInfo19hasOptimizedCodeGenENS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo19hasOptimizedCodeGenENS_7LibFunc4FuncE")
  //</editor-fold>
  public boolean hasOptimizedCodeGen(Func F) /*const*/ {
    if (Impl.getState(F) == TargetLibraryInfoImpl.AvailabilityState.Unavailable) {
      return false;
    }
    switch (F) {
     default:
      break;
     case copysign:
     case copysignf:
     case copysignl:
     case fabs:
     case fabsf:
     case fabsl:
     case sin:
     case sinf:
     case sinl:
     case cos:
     case cosf:
     case cosl:
     case sqrt:
     case sqrtf:
     case sqrtl:
     case sqrt_finite:
     case sqrtf_finite:
     case sqrtl_finite:
     case fmax:
     case fmaxf:
     case fmaxl:
     case fmin:
     case fminf:
     case fminl:
     case floor:
     case floorf:
     case floorl:
     case nearbyint:
     case nearbyintf:
     case nearbyintl:
     case ceil:
     case ceilf:
     case ceill:
     case rint:
     case rintf:
     case rintl:
     case round:
     case roundf:
     case roundl:
     case trunc:
     case truncf:
     case truncl:
     case log2:
     case log2f:
     case log2l:
     case exp2:
     case exp2f:
     case exp2l:
     case memcmp:
     case strcmp:
     case strcpy:
     case stpcpy:
     case strlen:
     case strnlen:
     case memchr:
      return true;
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 260,
   FQN="llvm::TargetLibraryInfo::getName", NM="_ZNK4llvm17TargetLibraryInfo7getNameENS_7LibFunc4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZNK4llvm17TargetLibraryInfo7getNameENS_7LibFunc4FuncE")
  //</editor-fold>
  public StringRef getName(Func F) /*const*/ {
    TargetLibraryInfoImpl.AvailabilityState State = Impl.getState(F);
    if (State == TargetLibraryInfoImpl.AvailabilityState.Unavailable) {
      return new StringRef();
    }
    if (State == TargetLibraryInfoImpl.AvailabilityState.StandardName) {
      return new StringRef(Impl.StandardNames.$at(F.getValue()));
    }
    assert (State == TargetLibraryInfoImpl.AvailabilityState.CustomName);
    return new StringRef(Impl.CustomNames.find$Const(/*KEEP_ENUM*/F.getValue()).$arrow().second);
  }


  /// Handle invalidation from the pass manager.
  ///
  /// If we try to invalidate this info, just return false. It cannot become
  /// invalid even if the module changes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetLibraryInfo::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetLibraryInfo.h", line = 274,
   FQN="llvm::TargetLibraryInfo::invalidate", NM="_ZN4llvm17TargetLibraryInfo10invalidateERNS_6ModuleERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm17TargetLibraryInfo10invalidateERNS_6ModuleERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Module /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    return false;
  }


  @Override public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
