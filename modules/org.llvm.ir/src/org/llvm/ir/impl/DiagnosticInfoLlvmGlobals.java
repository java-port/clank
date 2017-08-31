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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type DiagnosticInfoLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.DiagnosticInfoLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm22emitOptimizationRemarkERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm24emitLoopVectorizeWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm25emitLoopInterleaveWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm28emitOptimizationRemarkMissedERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm30emitOptimizationRemarkAnalysisERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm36getNextAvailablePluginDiagnosticKindEv;_ZN4llvm38emitOptimizationRemarkAnalysisAliasingERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm39emitOptimizationRemarkAnalysisFPCommuteERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm4wrapEPKNS_14DiagnosticInfoE;_ZN4llvm6unwrapEP24LLVMOpaqueDiagnosticInfo; -static-type=DiagnosticInfoLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class DiagnosticInfoLlvmGlobals {


/// \brief Get the next available kind ID for a plugin diagnostic.
/// Each time this function is called, it returns a different number.
/// Therefore, a plugin that wants to "identify" its own classes
/// with a dynamic identifier, just have to use this method to get a new ID
/// and assign it to each of its classes.
/// The returned ID will be greater than or equal to DK_FirstPluginKind.
/// Thus, the plugin identifiers will not conflict with the
/// DiagnosticKind values.
//<editor-fold defaultstate="collapsed" desc="llvm::getNextAvailablePluginDiagnosticKind">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 89,
 FQN="llvm::getNextAvailablePluginDiagnosticKind", NM="_ZN4llvm36getNextAvailablePluginDiagnosticKindEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm36getNextAvailablePluginDiagnosticKindEv")
//</editor-fold>
public static int getNextAvailablePluginDiagnosticKind() {
  final/*static*/ std.atomicInt PluginKindID = getNextAvailablePluginDiagnosticKind$$.PluginKindID;
  return PluginKindID.$preInc();
}
private static final class getNextAvailablePluginDiagnosticKind$$ {
  static final/*static*/ std.atomicInt PluginKindID/*J*/= new std.atomicInt(DiagnosticKind.DK_FirstPluginKind.getValue());
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 588,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP24LLVMOpaqueDiagnosticInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm6unwrapEP24LLVMOpaqueDiagnosticInfo")
//</editor-fold>
public static /*inline*/ DiagnosticInfo /*P*/ unwrap( LLVMOpaqueDiagnosticInfo /*P*/ P) {
  return reinterpret_cast(DiagnosticInfo /*P*/ .class, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 588,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_14DiagnosticInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm4wrapEPKNS_14DiagnosticInfoE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueDiagnosticInfo /*P*/ wrap(/*const*/ DiagnosticInfo /*P*/ P) {
  return reinterpret_cast( LLVMOpaqueDiagnosticInfo /*P*/ .class, ((/*const_cast*/DiagnosticInfo /*P*/ )(P)));
}


/// Emit an optimization-applied message. \p PassName is the name of the pass
/// emitting the message. If -Rpass= is given and \p PassName matches the
/// regular expression in -Rpass, then the remark will be emitted. \p Fn is
/// the function triggering the remark, \p DLoc is the debug location where
/// the diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemark">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 199,
 FQN="llvm::emitOptimizationRemark", NM="_ZN4llvm22emitOptimizationRemarkERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm22emitOptimizationRemarkERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemark(final LLVMContext /*&*/ Ctx, /*const*/char$ptr/*char P*/ PassName, 
                      final /*const*/ Function /*&*/ Fn, final /*const*/ DebugLoc /*&*/ DLoc, 
                      final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationRemark(PassName, Fn, DLoc, Msg))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// Emit an optimization-missed message. \p PassName is the name of the
/// pass emitting the message. If -Rpass-missed= is given and \p PassName
/// matches the regular expression in -Rpass, then the remark will be
/// emitted. \p Fn is the function triggering the remark, \p DLoc is the
/// debug location where the diagnostic is generated. \p Msg is the
/// message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkMissed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 205,
 FQN="llvm::emitOptimizationRemarkMissed", NM="_ZN4llvm28emitOptimizationRemarkMissedERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm28emitOptimizationRemarkMissedERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkMissed(final LLVMContext /*&*/ Ctx, /*const*/char$ptr/*char P*/ PassName, 
                            final /*const*/ Function /*&*/ Fn, 
                            final /*const*/ DebugLoc /*&*/ DLoc, 
                            final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationRemarkMissed(PassName, Fn, DLoc, Msg))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// Emit an optimization analysis remark message. \p PassName is the name of
/// the pass emitting the message. If -Rpass-analysis= is given and \p
/// PassName matches the regular expression in -Rpass, then the remark will be
/// emitted. \p Fn is the function triggering the remark, \p DLoc is the debug
/// location where the diagnostic is generated. \p Msg is the message string
/// to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 212,
 FQN="llvm::emitOptimizationRemarkAnalysis", NM="_ZN4llvm30emitOptimizationRemarkAnalysisERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30emitOptimizationRemarkAnalysisERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkAnalysis(final LLVMContext /*&*/ Ctx, 
                              /*const*/char$ptr/*char P*/ PassName, 
                              final /*const*/ Function /*&*/ Fn, 
                              final /*const*/ DebugLoc /*&*/ DLoc, 
                              final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationRemarkAnalysis(PassName, Fn, DLoc, Msg))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// Emit an optimization analysis remark related to messages about
/// floating-point non-commutativity. \p PassName is the name of the pass
/// emitting the message. If -Rpass-analysis= is given and \p PassName matches
/// the regular expression in -Rpass, then the remark will be emitted. \p Fn is
/// the function triggering the remark, \p DLoc is the debug location where the
/// diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkAnalysisFPCommute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 221,
 FQN="llvm::emitOptimizationRemarkAnalysisFPCommute", NM="_ZN4llvm39emitOptimizationRemarkAnalysisFPCommuteERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm39emitOptimizationRemarkAnalysisFPCommuteERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkAnalysisFPCommute(final LLVMContext /*&*/ Ctx, 
                                       /*const*/char$ptr/*char P*/ PassName, 
                                       final /*const*/ Function /*&*/ Fn, 
                                       final /*const*/ DebugLoc /*&*/ DLoc, 
                                       final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationRemarkAnalysisFPCommute(PassName, Fn, 
            DLoc, Msg))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// Emit an optimization analysis remark related to messages about
/// pointer aliasing. \p PassName is the name of the pass emitting the message.
/// If -Rpass-analysis= is given and \p PassName matches the regular expression
/// in -Rpass, then the remark will be emitted. \p Fn is the function triggering
/// the remark, \p DLoc is the debug location where the diagnostic is generated.
/// \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkAnalysisAliasing">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 230,
 FQN="llvm::emitOptimizationRemarkAnalysisAliasing", NM="_ZN4llvm38emitOptimizationRemarkAnalysisAliasingERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm38emitOptimizationRemarkAnalysisAliasingERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkAnalysisAliasing(final LLVMContext /*&*/ Ctx, 
                                      /*const*/char$ptr/*char P*/ PassName, 
                                      final /*const*/ Function /*&*/ Fn, 
                                      final /*const*/ DebugLoc /*&*/ DLoc, 
                                      final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationRemarkAnalysisAliasing(PassName, Fn, 
            DLoc, Msg))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// Emit a warning when loop vectorization is specified but fails. \p Fn is the
/// function triggering the warning, \p DLoc is the debug location where the
/// diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitLoopVectorizeWarning">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 254,
 FQN="llvm::emitLoopVectorizeWarning", NM="_ZN4llvm24emitLoopVectorizeWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm24emitLoopVectorizeWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitLoopVectorizeWarning(final LLVMContext /*&*/ Ctx, final /*const*/ Function /*&*/ Fn, 
                        final /*const*/ DebugLoc /*&*/ DLoc, final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationFailure(Fn, DLoc, $add_Twine$C(new Twine(/*KEEP_STR*/"loop not vectorized: "), Msg)))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// Emit a warning when loop interleaving is specified but fails. \p Fn is the
/// function triggering the warning, \p DLoc is the debug location where the
/// diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitLoopInterleaveWarning">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 260,
 FQN="llvm::emitLoopInterleaveWarning", NM="_ZN4llvm25emitLoopInterleaveWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm25emitLoopInterleaveWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitLoopInterleaveWarning(final LLVMContext /*&*/ Ctx, final /*const*/ Function /*&*/ Fn, 
                         final /*const*/ DebugLoc /*&*/ DLoc, final /*const*/ Twine /*&*/ Msg) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Ctx.diagnose($c$.track(new DiagnosticInfoOptimizationFailure(Fn, DLoc, $add_Twine$C(new Twine(/*KEEP_STR*/"loop not interleaved: "), Msg)))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class DiagnosticInfoLlvmGlobals
