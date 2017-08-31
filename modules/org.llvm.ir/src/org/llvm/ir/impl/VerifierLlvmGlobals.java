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
package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type VerifierLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.VerifierLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12verifyModuleERKNS_6ModuleEPNS_11raw_ostreamEPb;_ZN4llvm14verifyFunctionERKNS_8FunctionEPNS_11raw_ostreamE;_ZN4llvm18createVerifierPassEb; -static-type=VerifierLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class VerifierLlvmGlobals {


/// \brief Check a function for errors, useful for use when debugging a
/// pass.
///
/// If there are no errors, the function returns false. If an error is found,
/// a message describing the error is written to OS (if non-null) and true is
/// returned.

//===----------------------------------------------------------------------===//
//  Implement the public interfaces to this file...
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::verifyFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4284,
 FQN="llvm::verifyFunction", NM="_ZN4llvm14verifyFunctionERKNS_8FunctionEPNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm14verifyFunctionERKNS_8FunctionEPNS_11raw_ostreamE")
//</editor-fold>
public static boolean verifyFunction(final /*const*/ Function /*&*/ f) {
  return verifyFunction(f, (raw_ostream /*P*/ )null);
}
public static boolean verifyFunction(final /*const*/ Function /*&*/ f, raw_ostream /*P*/ OS/*= null*/) {
  Verifier V = null;
  try {
    final Function /*&*/ F = ((/*const_cast*/Function /*&*/ )(f));
    
    // Don't use a raw_null_ostream.  Printing IR is expensive.
    V/*J*/= new Verifier(OS, /*ShouldTreatBrokenDebugInfoAsError=*/ true);
    
    // Note that this function's return value is inverted from what you would
    // expect of a function called "verify".
    return !V.verify(F);
  } finally {
    if (V != null) { V.$destroy(); }
  }
}


/// \brief Check a module for errors.
///
/// If there are no errors, the function returns false. If an error is
/// found, a message describing the error is written to OS (if
/// non-null) and true is returned.
///
/// \return true if the module is broken. If BrokenDebugInfo is
/// supplied, DebugInfo verification failures won't be considered as
/// error and instead *BrokenDebugInfo will be set to true. Debug
/// info errors can be "recovered" from by stripping the debug info.
//<editor-fold defaultstate="collapsed" desc="llvm::verifyModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4295,
 FQN="llvm::verifyModule", NM="_ZN4llvm12verifyModuleERKNS_6ModuleEPNS_11raw_ostreamEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12verifyModuleERKNS_6ModuleEPNS_11raw_ostreamEPb")
//</editor-fold>
public static boolean verifyModule(final /*const*/ Module /*&*/ M) {
  return verifyModule(M, (raw_ostream /*P*/ )null, 
            (bool$ptr/*bool P*/ )null);
}
public static boolean verifyModule(final /*const*/ Module /*&*/ M, raw_ostream /*P*/ OS/*= null*/) {
  return verifyModule(M, OS, 
            (bool$ptr/*bool P*/ )null);
}
public static boolean verifyModule(final /*const*/ Module /*&*/ M, raw_ostream /*P*/ OS/*= null*/, 
            bool$ptr/*bool P*/ BrokenDebugInfo/*= null*/) {
  Verifier V = null;
  try {
    // Don't use a raw_null_ostream.  Printing IR is expensive.
    V/*J*/= new Verifier(OS, /*ShouldTreatBrokenDebugInfoAsError=*/ !Native.$bool(BrokenDebugInfo));
    
    boolean Broken = false;
    for (final /*const*/ Function /*&*/ F : M)  {
      Broken |= !V.verify(F);
    }
    
    Broken |= !V.verify(M);
    if (Native.$bool(BrokenDebugInfo)) {
      BrokenDebugInfo.$set(V.hasBrokenDebugInfo());
    }
    // Note that this function's return value is inverted from what you would
    // expect of a function called "verify".
    return Broken;
  } finally {
    if (V != null) { V.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::createVerifierPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4370,
 FQN="llvm::createVerifierPass", NM="_ZN4llvm18createVerifierPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm18createVerifierPassEb")
//</editor-fold>
public static FunctionPass /*P*/ createVerifierPass() {
  return createVerifierPass(true);
}
public static FunctionPass /*P*/ createVerifierPass(boolean FatalErrors/*= true*/) {
  return new VerifierLegacyPass(FatalErrors);
}

} // END OF class VerifierLlvmGlobals
