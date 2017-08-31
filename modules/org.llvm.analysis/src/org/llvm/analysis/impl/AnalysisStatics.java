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
import org.llvm.llvmc.LLVMOpaqueModule;
import org.llvm.llvmc.LLVMOpaquePassRegistry;
import org.llvm.llvmc.LLVMOpaqueValue;


//<editor-fold defaultstate="collapsed" desc="static type AnalysisStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.AnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z16LLVMVerifyModule;_Z17LLVMInitializeIPA;_Z18LLVMVerifyFunction;_Z19LLVMViewFunctionCFG;_Z22LLVMInitializeAnalysis;_Z23LLVMViewFunctionCFGOnly; -static-type=AnalysisStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class AnalysisStatics {


/* Verifies that a module is valid, taking the specified action if not.
Optionally returns a human-readable description of any invalid constructs.
OutMessage must be disposed with LLVMDisposeMessage. */
//<editor-fold defaultstate="collapsed" desc="LLVMVerifyModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 89,
 FQN="LLVMVerifyModule", NM="_Z16LLVMVerifyModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z16LLVMVerifyModule")
//</editor-fold>
public static int LLVMVerifyModule( LLVMOpaqueModule /*P*/ M, LLVMVerifierFailureAction Action, 
                type$ptr<char$ptr>/*char PP*/ OutMessages) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Verifies that a single function is valid, taking the specified action. Useful
for debugging. */
//<editor-fold defaultstate="collapsed" desc="LLVMVerifyFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 110,
 FQN="LLVMVerifyFunction", NM="_Z18LLVMVerifyFunction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z18LLVMVerifyFunction")
//</editor-fold>
public static int LLVMVerifyFunction( LLVMOpaqueValue /*P*/ Fn, LLVMVerifierFailureAction Action) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Open up a ghostview window that displays the CFG of the current function.
Useful for debugging. */
//<editor-fold defaultstate="collapsed" desc="LLVMViewFunctionCFG">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 121,
 FQN="LLVMViewFunctionCFG", NM="_Z19LLVMViewFunctionCFG",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z19LLVMViewFunctionCFG")
//</editor-fold>
public static void LLVMViewFunctionCFG( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMViewFunctionCFGOnly">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 126,
 FQN="LLVMViewFunctionCFGOnly", NM="_Z23LLVMViewFunctionCFGOnly",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z23LLVMViewFunctionCFGOnly")
//</editor-fold>
public static void LLVMViewFunctionCFGOnly( LLVMOpaqueValue /*P*/ Fn) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 81,
 FQN="LLVMInitializeAnalysis", NM="_Z22LLVMInitializeAnalysis",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z22LLVMInitializeAnalysis")
//</editor-fold>
public static void LLVMInitializeAnalysis( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeIPA">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 85,
 FQN="LLVMInitializeIPA", NM="_Z17LLVMInitializeIPA",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_Z17LLVMInitializeIPA")
//</editor-fold>
public static void LLVMInitializeIPA( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

  private static class LLVMVerifierFailureAction {

    public LLVMVerifierFailureAction() {
    }
  }

} // END OF class AnalysisStatics
