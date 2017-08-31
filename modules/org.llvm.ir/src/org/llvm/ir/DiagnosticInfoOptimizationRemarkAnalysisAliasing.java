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
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// Diagnostic information for optimization analysis remarks related to
/// pointer aliasing.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 544,
 FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing", NM="_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingE")
//</editor-fold>
public class DiagnosticInfoOptimizationRemarkAnalysisAliasing extends /*public*/ DiagnosticInfoOptimizationRemarkAnalysis implements Destructors.ClassWithDestructor {
/*public:*/
  /// \p PassName is the name of the pass emitting this diagnostic. If
  /// this name matches the regular expression given in -Rpass-analysis=, then
  /// the diagnostic will be emitted. \p Fn is the function where the diagnostic
  /// is being emitted. \p DLoc is the location information to use in the
  /// diagnostic. If line table information is available, the diagnostic will
  /// include the source code location. \p Msg is the message to show. The
  /// front-end will append its own message related to options that address
  /// pointer aliasing legality. Note that this class does not copy this
  /// message, so this reference must be valid for the whole life time of the
  /// diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing::DiagnosticInfoOptimizationRemarkAnalysisAliasing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 557,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing::DiagnosticInfoOptimizationRemarkAnalysisAliasing", NM="_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingC1EPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingC1EPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
  //</editor-fold>
  public DiagnosticInfoOptimizationRemarkAnalysisAliasing(/*const*/char$ptr/*char P*/ PassName,
      final /*const*/ Function /*&*/ Fn,
      final /*const*/ DebugLoc /*&*/ DLoc,
      final /*const*/ Twine /*&*/ Msg) {
    // : DiagnosticInfoOptimizationRemarkAnalysis(DK_OptimizationRemarkAnalysisAliasing, PassName, Fn, DLoc, Msg)
    //START JInit
    super(DiagnosticKind.DK_OptimizationRemarkAnalysisAliasing, PassName, Fn, DLoc, Msg);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 564,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing::classof", NM="_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasing7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasing7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_OptimizationRemarkAnalysisAliasing.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing::~DiagnosticInfoOptimizationRemarkAnalysisAliasing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 544,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysisAliasing::~DiagnosticInfoOptimizationRemarkAnalysisAliasing", NM="_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm48DiagnosticInfoOptimizationRemarkAnalysisAliasingD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
