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
package org.clang.staticanalyzer.core.pathsensitive.ento.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.staticanalyzer.core.impl.LoopWideningStatics;


//<editor-fold defaultstate="collapsed" desc="static type LoopWideningEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.pathsensitive.ento.impl.LoopWideningEntoGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN5clang4ento19getWidenedLoopStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEjPKNS_4StmtE; -static-type=LoopWideningEntoGlobals -package=org.clang.staticanalyzer.core.pathsensitive.ento.impl")
//</editor-fold>
public final class LoopWideningEntoGlobals {


/// \brief Get the states that result from widening the loop.
///
/// Widen the loop by invalidating anything that might be modified
/// by the loop body in any iteration.
//<editor-fold defaultstate="collapsed" desc="clang::ento::getWidenedLoopState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp", line = 39,
 FQN="clang::ento::getWidenedLoopState", NM="_ZN5clang4ento19getWidenedLoopStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEjPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN5clang4ento19getWidenedLoopStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEjPKNS_4StmtE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> getWidenedLoopState(IntrusiveRefCntPtr</*const*/ ProgramState> PrevState, 
                   /*const*/ LocationContext /*P*/ LCtx, 
                   /*uint*/int BlockCount, /*const*/ Stmt /*P*/ LoopStmt) {
  RegionAndSymbolInvalidationTraits ITraits = null;
  try {
    assert (isa_ForStmt(LoopStmt) || isa_WhileStmt(LoopStmt) || isa_DoStmt(LoopStmt));
    
    // Invalidate values in the current state.
    // TODO Make this more conservative by only invalidating values that might
    //      be modified by the body of the loop.
    // TODO Nested loops are currently widened as a result of the invalidation
    //      being so inprecise. When the invalidation is improved, the handling
    //      of nested loops will also need to be improved.
    /*const*/ StackFrameContext /*P*/ STC = LCtx.getCurrentStackFrame();
    final MemRegionManager /*&*/ MRMgr = PrevState.$arrow().getStateManager().getRegionManager();
    /*const*/ MemRegion /*P*/ Regions[/*3*/] = new /*const*/ MemRegion /*P*/  [/*3*/] {
      MRMgr.getStackLocalsRegion(STC), 
      MRMgr.getStackArgumentsRegion(STC), 
      MRMgr.getGlobalsRegion()};
    ITraits/*J*/= new RegionAndSymbolInvalidationTraits();
    for (/*const*/ MemRegion /*P*/ Region : Regions) {
      ITraits.setTrait(Region, 
          RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_EntireMemSpace);
    }
    return PrevState.$arrow().invalidateRegions_ArrayRef1(new ArrayRef</*const*/ MemRegion /*P*/ >(Regions, true), LoopWideningStatics.getLoopCondition(LoopStmt), 
        BlockCount, LCtx, true, (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null, (/*const*/ CallEvent /*P*/ )null, 
        $AddrOf(ITraits));
  } finally {
    if (ITraits != null) { ITraits.$destroy(); }
  }
}

} // END OF class LoopWideningEntoGlobals
