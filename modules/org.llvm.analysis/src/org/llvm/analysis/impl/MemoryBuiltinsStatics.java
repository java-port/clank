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


//<editor-fold defaultstate="collapsed" desc="static type MemoryBuiltinsStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.MemoryBuiltinsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL14hasNoAliasAttrPKN4llvm5ValueEb;_ZL16AllocationFnData;_ZL16computeArraySizePKN4llvm8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb;_ZL17ObjectVisitorLoad;_ZL17getAllocationDataPKN4llvm5ValueE9AllocTypePKNS_17TargetLibraryInfoEb;_ZL17getCalledFunctionPKN4llvm5ValueEb;_ZL19getSizeWithOverflowRKSt4pairIN4llvm5APIntES1_E;_ZL21ObjectVisitorArgument; -static-type=MemoryBuiltinsStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class MemoryBuiltinsStatics {


// FIXME: certain users need more information. E.g., SimplifyLibCalls needs to
// know which functions are nounwind, noalias, nocapture parameters, etc.
//<editor-fold defaultstate="collapsed" desc="AllocationFnData">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 53,
 FQN="AllocationFnData", NM="_ZL16AllocationFnData",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL16AllocationFnData")
//</editor-fold>
public static /*const*/ std.pair<Func, AllocFnsTy> AllocationFnData[/*23*/] = new /*const*/ std.pair [/*23*/] {
  std.make_pair_E_T(Func.malloc, new AllocFnsTy(AllocType.MallocLike, 1, 0, -1)), 
  std.make_pair_E_T(Func.valloc, new AllocFnsTy(AllocType.MallocLike, 1, 0, -1)), 
  std.make_pair_E_T(Func.Znwj, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new(unsigned int)
  std.make_pair_E_T(Func.ZnwjRKSt9nothrow_t, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new(unsigned int, nothrow)
  std.make_pair_E_T(Func.Znwm, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new(unsigned long)
  std.make_pair_E_T(Func.ZnwmRKSt9nothrow_t, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new(unsigned long, nothrow)
  std.make_pair_E_T(Func.Znaj, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new[](unsigned int)
  std.make_pair_E_T(Func.ZnajRKSt9nothrow_t, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new[](unsigned int, nothrow)
  std.make_pair_E_T(Func.Znam, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new[](unsigned long)
  std.make_pair_E_T(Func.ZnamRKSt9nothrow_t, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new[](unsigned long, nothrow)
  std.make_pair_E_T(Func.msvc_new_int, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new(unsigned int)
  std.make_pair_E_T(Func.msvc_new_int_nothrow, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new(unsigned int, nothrow)
  std.make_pair_E_T(Func.msvc_new_longlong, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new(unsigned long long)
  std.make_pair_E_T(Func.msvc_new_longlong_nothrow, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new(unsigned long long, nothrow)
  std.make_pair_E_T(Func.msvc_new_array_int, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new[](unsigned int)
  std.make_pair_E_T(Func.msvc_new_array_int_nothrow, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new[](unsigned int, nothrow)
  std.make_pair_E_T(Func.msvc_new_array_longlong, new AllocFnsTy(AllocType.OpNewLike, 1, 0, -1)),  // new[](unsigned long long)
  std.make_pair_E_T(Func.msvc_new_array_longlong_nothrow, new AllocFnsTy(AllocType.MallocLike, 2, 0, -1)),  // new[](unsigned long long, nothrow)
  std.make_pair_E_T(Func.calloc, new AllocFnsTy(AllocType.CallocLike, 2, 0, 1)), 
  std.make_pair_E_T(Func.realloc, new AllocFnsTy(AllocType.ReallocLike, 2, 1, -1)), 
  std.make_pair_E_T(Func.reallocf, new AllocFnsTy(AllocType.ReallocLike, 2, 1, -1)), 
  std.make_pair_E_T(Func.strdup, new AllocFnsTy(AllocType.StrDupLike, 1, -1, -1)), 
  std.make_pair_E_T(Func.strndup, new AllocFnsTy(AllocType.StrDupLike, 2, 1, -1))
};
//<editor-fold defaultstate="collapsed" desc="getCalledFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 81,
 FQN="getCalledFunction", NM="_ZL17getCalledFunctionPKN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL17getCalledFunctionPKN4llvm5ValueEb")
//</editor-fold>
public static Function /*P*/ getCalledFunction(/*const*/ Value /*P*/ V, boolean LookThroughBitCast) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns the allocation data for the given value if it's either a call to a
/// known allocation function, or a call to a function with the allocsize
/// attribute.
//<editor-fold defaultstate="collapsed" desc="getAllocationData">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 101,
 FQN="getAllocationData", NM="_ZL17getAllocationDataPKN4llvm5ValueE9AllocTypePKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL17getAllocationDataPKN4llvm5ValueE9AllocTypePKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static Optional<AllocFnsTy> getAllocationData(/*const*/ Value /*P*/ V, /*AllocType*/byte/*uint8_t*/ AllocTy, 
                 /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return getAllocationData(V, AllocTy, 
                 TLI, 
                 false);
}
public static Optional<AllocFnsTy> getAllocationData(/*const*/ Value /*P*/ V, /*AllocType*/byte/*uint8_t*/ AllocTy, 
                 /*const*/ TargetLibraryInfo /*P*/ TLI, 
                 boolean LookThroughBitCast/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="hasNoAliasAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 167,
 FQN="hasNoAliasAttr", NM="_ZL14hasNoAliasAttrPKN4llvm5ValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL14hasNoAliasAttrPKN4llvm5ValueEb")
//</editor-fold>
public static boolean hasNoAliasAttr(/*const*/ Value /*P*/ V, boolean LookThroughBitCast) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="computeArraySize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 220,
 FQN="computeArraySize", NM="_ZL16computeArraySizePKN4llvm8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL16computeArraySizePKN4llvm8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static Value /*P*/ computeArraySize(/*const*/ CallInst /*P*/ CI, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return computeArraySize(CI, DL, 
                TLI, 
                false);
}
public static Value /*P*/ computeArraySize(/*const*/ CallInst /*P*/ CI, final /*const*/ DataLayout /*&*/ DL, 
                /*const*/ TargetLibraryInfo /*P*/ TLI, 
                boolean LookThroughSExt/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Utility functions to compute size of objects.
//
//<editor-fold defaultstate="collapsed" desc="getSizeWithOverflow">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 369,
 FQN="getSizeWithOverflow", NM="_ZL19getSizeWithOverflowRKSt4pairIN4llvm5APIntES1_E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL19getSizeWithOverflowRKSt4pairIN4llvm5APIntES1_E")
//</editor-fold>
public static APInt getSizeWithOverflow(final /*const*/ std.pair<APInt, APInt> /*&*/ Data) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="ObjectVisitorArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 392,
 FQN="ObjectVisitorArgument", NM="_ZL21ObjectVisitorArgument",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL21ObjectVisitorArgument")
//</editor-fold>
public static Statistic ObjectVisitorArgument = new Statistic($("memory-builtins"), $("ObjectVisitorArgument"), $("Number of arguments with unsolved size and offset"), 0, false);
//<editor-fold defaultstate="collapsed" desc="ObjectVisitorLoad">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp", line = 394,
 FQN="ObjectVisitorLoad", NM="_ZL17ObjectVisitorLoad",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryBuiltins.cpp -nm=_ZL17ObjectVisitorLoad")
//</editor-fold>
public static Statistic ObjectVisitorLoad = new Statistic($("memory-builtins"), $("ObjectVisitorLoad"), $("Number of load instructions with unsolved size and offset"), 0, false);
} // END OF class MemoryBuiltinsStatics
