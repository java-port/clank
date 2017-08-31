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
package org.llvm.ir;

import org.clank.support.*;


//<editor-fold defaultstate="collapsed" desc="static type CallingConv">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN4llvm11CallingConvE_CallingConv_h_Unnamed_enum; -static-type=CallingConv -package=org.llvm.ir")
//</editor-fold>
public final class CallingConv {


/// A set of enums which specify the assigned numeric values for known llvm
/// calling conventions.
/// @brief LLVM Calling Convention Representation
//<editor-fold defaultstate="collapsed" desc="llvm::CallingConv::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CallingConv.h", line = 29,
 FQN="llvm::CallingConv::(anonymous)", NM="_ZN4llvm11CallingConvE_CallingConv_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SwiftCallingConv.cpp -nm=_ZN4llvm11CallingConvE_CallingConv_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  /// C - The default llvm calling convention, compatible with C.  This
  /// convention is the only calling convention that supports varargs calls.
  /// As with typical C calling conventions, the callee/caller have to
  /// tolerate certain amounts of prototype mismatch.
  public static final /*uint*/int C = 0;
  
  // Generic LLVM calling conventions.  None of these calling conventions
  // support varargs calls, and all assume that the caller and callee
  // prototype exactly match.
  
  /// Fast - This calling convention attempts to make calls as fast as
  /// possible (e.g. by passing things in registers).
  public static final /*uint*/int Fast = 8;
  
  // Cold - This calling convention attempts to make code in the caller as
  // efficient as possible under the assumption that the call is not commonly
  // executed.  As such, these calls often preserve all registers so that the
  // call does not break any live ranges in the caller side.
  public static final /*uint*/int Cold = 9;
  
  // GHC - Calling convention used by the Glasgow Haskell Compiler (GHC).
  public static final /*uint*/int GHC = 10;
  
  // HiPE - Calling convention used by the High-Performance Erlang Compiler
  // (HiPE).
  public static final /*uint*/int HiPE = 11;
  
  // WebKit JS - Calling convention for stack based JavaScript calls
  public static final /*uint*/int WebKit_JS = 12;
  
  // AnyReg - Calling convention for dynamic register based calls (e.g.
  // stackmap and patchpoint intrinsics).
  public static final /*uint*/int AnyReg = 13;
  
  // PreserveMost - Calling convention for runtime calls that preserves most
  // registers.
  public static final /*uint*/int PreserveMost = 14;
  
  // PreserveAll - Calling convention for runtime calls that preserves
  // (almost) all registers.
  public static final /*uint*/int PreserveAll = 15;
  
  // Swift - Calling convention for Swift.
  public static final /*uint*/int Swift = 16;
  
  // CXX_FAST_TLS - Calling convention for access functions.
  public static final /*uint*/int CXX_FAST_TLS = 17;
  
  // Target - This is the start of the target-specific calling conventions,
  // e.g. fastcall and thiscall on X86.
  public static final /*uint*/int FirstTargetCC = 64;
  
  /// X86_StdCall - stdcall is the calling conventions mostly used by the
  /// Win32 API. It is basically the same as the C convention with the
  /// difference in that the callee is responsible for popping the arguments
  /// from the stack.
  public static final /*uint*/int X86_StdCall = 64;
  
  /// X86_FastCall - 'fast' analog of X86_StdCall. Passes first two arguments
  /// in ECX:EDX registers, others - via stack. Callee is responsible for
  /// stack cleaning.
  public static final /*uint*/int X86_FastCall = 65;
  
  /// ARM_APCS - ARM Procedure Calling Standard calling convention (obsolete,
  /// but still used on some targets).
  public static final /*uint*/int ARM_APCS = 66;
  
  /// ARM_AAPCS - ARM Architecture Procedure Calling Standard calling
  /// convention (aka EABI). Soft float variant.
  public static final /*uint*/int ARM_AAPCS = 67;
  
  /// ARM_AAPCS_VFP - Same as ARM_AAPCS, but uses hard floating point ABI.
  public static final /*uint*/int ARM_AAPCS_VFP = 68;
  
  /// MSP430_INTR - Calling convention used for MSP430 interrupt routines.
  public static final /*uint*/int MSP430_INTR = 69;
  
  /// X86_ThisCall - Similar to X86_StdCall. Passes first argument in ECX,
  /// others via stack. Callee is responsible for stack cleaning. MSVC uses
  /// this by default for methods in its ABI.
  public static final /*uint*/int X86_ThisCall = 70;
  
  /// PTX_Kernel - Call to a PTX kernel.
  /// Passes all arguments in parameter space.
  public static final /*uint*/int PTX_Kernel = 71;
  
  /// PTX_Device - Call to a PTX device function.
  /// Passes all arguments in register or parameter space.
  public static final /*uint*/int PTX_Device = 72;
  
  /// SPIR_FUNC - Calling convention for SPIR non-kernel device functions.
  /// No lowering or expansion of arguments.
  /// Structures are passed as a pointer to a struct with the byval attribute.
  /// Functions can only call SPIR_FUNC and SPIR_KERNEL functions.
  /// Functions can only have zero or one return values.
  /// Variable arguments are not allowed, except for printf.
  /// How arguments/return values are lowered are not specified.
  /// Functions are only visible to the devices.
  public static final /*uint*/int SPIR_FUNC = 75;
  
  /// SPIR_KERNEL - Calling convention for SPIR kernel functions.
  /// Inherits the restrictions of SPIR_FUNC, except
  /// Cannot have non-void return values.
  /// Cannot have variable arguments.
  /// Can also be called by the host.
  /// Is externally visible.
  public static final /*uint*/int SPIR_KERNEL = 76;
  
  /// Intel_OCL_BI - Calling conventions for Intel OpenCL built-ins
  public static final /*uint*/int Intel_OCL_BI = 77;
  
  /// \brief The C convention as specified in the x86-64 supplement to the
  /// System V ABI, used on most non-Windows systems.
  public static final /*uint*/int X86_64_SysV = 78;
  
  /// \brief The C convention as implemented on Windows/x86-64. This
  /// convention differs from the more common \c X86_64_SysV convention
  /// in a number of ways, most notably in that XMM registers used to pass
  /// arguments are shadowed by GPRs, and vice versa.
  public static final /*uint*/int X86_64_Win64 = 79;
  
  /// \brief MSVC calling convention that passes vectors and vector aggregates
  /// in SSE registers.
  public static final /*uint*/int X86_VectorCall = 80;
  
  /// \brief Calling convention used by HipHop Virtual Machine (HHVM) to
  /// perform calls to and from translation cache, and for calling PHP
  /// functions.
  /// HHVM calling convention supports tail/sibling call elimination.
  public static final /*uint*/int HHVM = 81;
  
  /// \brief HHVM calling convention for invoking C/C++ helpers.
  public static final /*uint*/int HHVM_C = 82;
  
  /// X86_INTR - x86 hardware interrupt context. Callee may take one or two
  /// parameters, where the 1st represents a pointer to hardware context frame
  /// and the 2nd represents hardware error code, the presence of the later
  /// depends on the interrupt vector taken. Valid for both 32- and 64-bit
  /// subtargets.
  public static final /*uint*/int X86_INTR = 83;
  
  /// Used for AVR interrupt routines.
  public static final /*uint*/int AVR_INTR = 84;
  
  /// Calling convention used for AVR signal routines.
  public static final /*uint*/int AVR_SIGNAL = 85;
  
  /// Calling convention used for special AVR rtlib functions
  /// which have an "optimized" convention to preserve registers.
  public static final /*uint*/int AVR_BUILTIN = 86;
  
  /// Calling convention used for Mesa vertex shaders.
  public static final /*uint*/int AMDGPU_VS = 87;
  
  /// Calling convention used for Mesa geometry shaders.
  public static final /*uint*/int AMDGPU_GS = 88;
  
  /// Calling convention used for Mesa pixel shaders.
  public static final /*uint*/int AMDGPU_PS = 89;
  
  /// Calling convention used for Mesa compute shaders.
  public static final /*uint*/int AMDGPU_CS = 90;
  
  /// Calling convention for AMDGPU code object kernels.
  public static final /*uint*/int AMDGPU_KERNEL = 91;
  
  /// The highest possible calling convention ID. Must be some 2^k - 1.
  public static final /*uint*/int MaxID = 1023;
/*}*/
} // END OF class CallingConv
