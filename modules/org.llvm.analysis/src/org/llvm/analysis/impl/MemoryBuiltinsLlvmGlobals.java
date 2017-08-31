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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type MemoryBuiltinsLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm10isFreeCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm11isNoAliasFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm13getMallocTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvm13getObjectSizeEPKNS_5ValueERyRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEbNS_11ObjSizeModeE;_ZN4llvm13isAllocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm14isAllocationFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm14isCallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm14isMallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm17extractCallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm17extractMallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm18getMallocArraySizeEPNS_8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb;_ZN4llvm22getMallocAllocatedTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvmL10isFreeCallEPNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvmL17extractCallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvmL17extractMallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE; -static-type=MemoryBuiltinsLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class MemoryBuiltinsLlvmGlobals {


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates or reallocates memory (either malloc, calloc, realloc, or strdup
/// like).

/// \brief Tests if a value is a call or invoke to a library function that
/// allocates or reallocates memory (either malloc, calloc, realloc, or strdup
/// like).
//<editor-fold defaultstate="collapsed" desc="llvm::isAllocationFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 176,
 FQN="llvm::isAllocationFn", NM="_ZN4llvm14isAllocationFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm14isAllocationFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isAllocationFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isAllocationFn(V, TLI, 
              false);
}
public static boolean isAllocationFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI, 
              boolean LookThroughBitCast/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Tests if a value is a call or invoke to a function that returns a
/// NoAlias pointer (including malloc/calloc/realloc/strdup-like functions).

/// \brief Tests if a value is a call or invoke to a function that returns a
/// NoAlias pointer (including malloc/calloc/realloc/strdup-like functions).
//<editor-fold defaultstate="collapsed" desc="llvm::isNoAliasFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 183,
 FQN="llvm::isNoAliasFn", NM="_ZN4llvm11isNoAliasFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm11isNoAliasFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isNoAliasFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isNoAliasFn(V, TLI, 
           false);
}
public static boolean isNoAliasFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI, 
           boolean LookThroughBitCast/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates uninitialized memory (such as malloc).

/// \brief Tests if a value is a call or invoke to a library function that
/// allocates uninitialized memory (such as malloc).
//<editor-fold defaultstate="collapsed" desc="llvm::isMallocLikeFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 193,
 FQN="llvm::isMallocLikeFn", NM="_ZN4llvm14isMallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm14isMallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isMallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isMallocLikeFn(V, TLI, 
              false);
}
public static boolean isMallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI, 
              boolean LookThroughBitCast/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates zero-filled memory (such as calloc).

/// \brief Tests if a value is a call or invoke to a library function that
/// allocates zero-filled memory (such as calloc).
//<editor-fold defaultstate="collapsed" desc="llvm::isCallocLikeFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 200,
 FQN="llvm::isCallocLikeFn", NM="_ZN4llvm14isCallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm14isCallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isCallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isCallocLikeFn(V, TLI, 
              false);
}
public static boolean isCallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI, 
              boolean LookThroughBitCast/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates memory (either malloc, calloc, or strdup like).

/// \brief Tests if a value is a call or invoke to a library function that
/// allocates memory (either malloc, calloc, or strdup like).
//<editor-fold defaultstate="collapsed" desc="llvm::isAllocLikeFn">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 207,
 FQN="llvm::isAllocLikeFn", NM="_ZN4llvm13isAllocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm13isAllocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isAllocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isAllocLikeFn(V, TLI, 
             false);
}
public static boolean isAllocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI, 
             boolean LookThroughBitCast/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  malloc Call Utility Functions.
//

/// extractMallocCall - Returns the corresponding CallInst if the instruction
/// is a malloc call.  Since CallInst::CreateMalloc() only creates calls, we
/// ignore InvokeInst here.

/// extractMallocCall - Returns the corresponding CallInst if the instruction
/// is a malloc call.  Since CallInst::CreateMalloc() only creates calls, we
/// ignore InvokeInst here.
//<editor-fold defaultstate="collapsed" desc="llvm::extractMallocCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 215,
 FQN="llvm::extractMallocCall", NM="_ZN4llvm17extractMallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm17extractMallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*const*/ CallInst /*P*/ extractMallocCall_Value$C$P_TargetLibraryInfo$C$P(/*const*/ Value /*P*/ I, 
                                                 /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::extractMallocCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 75,
 FQN="llvm::extractMallocCall", NM="_ZN4llvmL17extractMallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvmL17extractMallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*inline*/ CallInst /*P*/ extractMallocCall_Value$P_TargetLibraryInfo$C$P(Value /*P*/ I, 
                                               /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// getMallocType - Returns the PointerType resulting from the malloc call.
/// The PointerType depends on the number of bitcast uses of the malloc call:
///   0: PointerType is the malloc calls' return type.
///   1: PointerType is the bitcast's result type.
///  >1: Unique PointerType cannot be determined, return NULL.

/// getMallocType - Returns the PointerType resulting from the malloc call.
/// The PointerType depends on the number of bitcast uses of the malloc call:
///   0: PointerType is the calls' return type.
///   1: PointerType is the bitcast's result type.
///  >1: Unique PointerType cannot be determined, return NULL.
//<editor-fold defaultstate="collapsed" desc="llvm::getMallocType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 250,
 FQN="llvm::getMallocType", NM="_ZN4llvm13getMallocTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm13getMallocTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static PointerType /*P*/ getMallocType(/*const*/ CallInst /*P*/ CI, 
             /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// getMallocAllocatedType - Returns the Type allocated by malloc call.
/// The Type depends on the number of bitcast uses of the malloc call:
///   0: PointerType is the malloc calls' return type.
///   1: PointerType is the bitcast's result type.
///  >1: Unique PointerType cannot be determined, return NULL.

/// getMallocAllocatedType - Returns the Type allocated by malloc call.
/// The Type depends on the number of bitcast uses of the malloc call:
///   0: PointerType is the malloc calls' return type.
///   1: PointerType is the bitcast's result type.
///  >1: Unique PointerType cannot be determined, return NULL.
//<editor-fold defaultstate="collapsed" desc="llvm::getMallocAllocatedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 282,
 FQN="llvm::getMallocAllocatedType", NM="_ZN4llvm22getMallocAllocatedTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm22getMallocAllocatedTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Type /*P*/ getMallocAllocatedType(/*const*/ CallInst /*P*/ CI, 
                      /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// getMallocArraySize - Returns the array size of a malloc call.  If the
/// argument passed to malloc is a multiple of the size of the malloced type,
/// then return that multiple.  For non-array mallocs, the multiple is
/// constant 1.  Otherwise, return NULL for mallocs whose array size cannot be
/// determined.

/// getMallocArraySize - Returns the array size of a malloc call.  If the
/// argument passed to malloc is a multiple of the size of the malloced type,
/// then return that multiple.  For non-array mallocs, the multiple is
/// constant 1.  Otherwise, return NULL for mallocs whose array size cannot be
/// determined.
//<editor-fold defaultstate="collapsed" desc="llvm::getMallocArraySize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 293,
 FQN="llvm::getMallocArraySize", NM="_ZN4llvm18getMallocArraySizeEPNS_8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm18getMallocArraySizeEPNS_8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static Value /*P*/ getMallocArraySize(CallInst /*P*/ CI, final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return getMallocArraySize(CI, DL, 
                  TLI, 
                  false);
}
public static Value /*P*/ getMallocArraySize(CallInst /*P*/ CI, final /*const*/ DataLayout /*&*/ DL, 
                  /*const*/ TargetLibraryInfo /*P*/ TLI, 
                  boolean LookThroughSExt/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  calloc Call Utility Functions.
//

/// extractCallocCall - Returns the corresponding CallInst if the instruction
/// is a calloc call.

/// extractCallocCall - Returns the corresponding CallInst if the instruction
/// is a calloc call.
//<editor-fold defaultstate="collapsed" desc="llvm::extractCallocCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 303,
 FQN="llvm::extractCallocCall", NM="_ZN4llvm17extractCallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm17extractCallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*const*/ CallInst /*P*/ extractCallocCall_Value$C$P_TargetLibraryInfo$C$P(/*const*/ Value /*P*/ I, 
                                                 /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::extractCallocCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 110,
 FQN="llvm::extractCallocCall", NM="_ZN4llvmL17extractCallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvmL17extractCallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*inline*/ CallInst /*P*/ extractCallocCall_Value$P_TargetLibraryInfo$C$P(Value /*P*/ I, 
                                               /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  free Call Utility Functions.
//

/// isFreeCall - Returns non-null if the value is a call to the builtin free()

/// isFreeCall - Returns non-null if the value is a call to the builtin free()
//<editor-fold defaultstate="collapsed" desc="llvm::isFreeCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 310,
 FQN="llvm::isFreeCall", NM="_ZN4llvm10isFreeCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm10isFreeCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*const*/ CallInst /*P*/ isFreeCall_Value$C$P_TargetLibraryInfo$C$P(/*const*/ Value /*P*/ I, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::isFreeCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 123,
 FQN="llvm::isFreeCall", NM="_ZN4llvmL10isFreeCallEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvmL10isFreeCallEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*inline*/ CallInst /*P*/ isFreeCall_Value$P_TargetLibraryInfo$C$P(Value /*P*/ I, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Utility functions to compute size of objects.
//

/// \brief Compute the size of the object pointed by Ptr. Returns true and the
/// object size in Size if successful, and false otherwise. In this context, by
/// object we mean the region of memory starting at Ptr to the end of the
/// underlying object pointed to by Ptr.
/// If RoundToAlign is true, then Size is rounded up to the aligment of allocas,
/// byval arguments, and global variables.
/// If Mode is Min or Max the size will be evaluated even if it depends on
/// a condition and corresponding value will be returned (min or max).

/// \brief Compute the size of the object pointed by Ptr. Returns true and the
/// object size in Size if successful, and false otherwise.
/// If RoundToAlign is true, then Size is rounded up to the aligment of allocas,
/// byval arguments, and global variables.
//<editor-fold defaultstate="collapsed" desc="llvm::getObjectSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 379,
 FQN="llvm::getObjectSize", NM="_ZN4llvm13getObjectSizeEPKNS_5ValueERyRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEbNS_11ObjSizeModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZN4llvm13getObjectSizeEPKNS_5ValueERyRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEbNS_11ObjSizeModeE")
//</editor-fold>
public static boolean getObjectSize(/*const*/ Value /*P*/ Ptr, final ulong$ref/*uint64_t &*/ Size, final /*const*/ DataLayout /*&*/ DL, 
             /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return getObjectSize(Ptr, Size, DL, 
             TLI, false, 
             ObjSizeMode.Exact);
}
public static boolean getObjectSize(/*const*/ Value /*P*/ Ptr, final ulong$ref/*uint64_t &*/ Size, final /*const*/ DataLayout /*&*/ DL, 
             /*const*/ TargetLibraryInfo /*P*/ TLI, boolean RoundToAlign/*= false*/) {
  return getObjectSize(Ptr, Size, DL, 
             TLI, RoundToAlign, 
             ObjSizeMode.Exact);
}
public static boolean getObjectSize(/*const*/ Value /*P*/ Ptr, final ulong$ref/*uint64_t &*/ Size, final /*const*/ DataLayout /*&*/ DL, 
             /*const*/ TargetLibraryInfo /*P*/ TLI, boolean RoundToAlign/*= false*/, 
             ObjSizeMode Mode/*= ObjSizeMode::Exact*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class MemoryBuiltinsLlvmGlobals
