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
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.BaseContext;


//<editor-fold defaultstate="collapsed" desc="static type CheckerManagerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZL23expandGraphWithCheckersT_RN5clang4ento15ExplodedNodeSetERKS2_; -static-type=CheckerManagerStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class CheckerManagerStatics {


//===----------------------------------------------------------------------===//
// Functions for running checkers for path-sensitive checking.
//===----------------------------------------------------------------------===//
/*template <typename CHECK_CTX> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="expandGraphWithCheckers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 94,
 FQN="expandGraphWithCheckers", NM="Tpl__ZL23expandGraphWithCheckersT_RN5clang4ento15ExplodedNodeSetERKS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZL23expandGraphWithCheckersT_RN5clang4ento15ExplodedNodeSetERKS2_")
//</editor-fold>
public static <T, /*typename*/ CHECK_CTX extends BaseContext<T>> void expandGraphWithCheckers(CHECK_CTX checkCtx, 
                       final ExplodedNodeSet /*&*/ Dst, 
                       final /*const*/ ExplodedNodeSet /*&*/ Src) {
  ExplodedNodeSet Tmp1 = null;
  ExplodedNodeSet Tmp2 = null;
  try {
    final /*const*/ NodeBuilderContext /*&*/ BldrCtx = checkCtx.Eng.getBuilderContext();
    if (Src.empty()) {
      return;
    }
    type$iterator<? extends type$iterator, T> I = checkCtx.checkers_begin();
    type$iterator<? extends type$iterator, T> E = checkCtx.checkers_end();
    if (Native.$eq_iter(I, E)) {
      Dst.insert(Src);
      return;
    }
    
    Tmp1/*J*/= new ExplodedNodeSet();
    Tmp2/*J*/= new ExplodedNodeSet();
    /*const*/ ExplodedNodeSet /*P*/ PrevSet = $AddrOf(Src);
    
    for (; Native.$noteq_iter(I, E); I.$preInc()) {
      NodeBuilder B = null;
      try {
        ExplodedNodeSet /*P*/ CurrSet = null;
        if (Native.$eq_iter(I.$add(1), E)) {
          CurrSet = $AddrOf(Dst);
        } else {
          CurrSet = (PrevSet == $AddrOf(Tmp1)) ? $AddrOf(Tmp2) : $AddrOf(Tmp1);
          CurrSet.clear();
        }
        
        B/*J*/= new NodeBuilder($Deref(PrevSet), $Deref(CurrSet), BldrCtx);
        for (SmallPtrSetIterator<ExplodedNode /*P*/ > NI = PrevSet.begin$Const(), NE = PrevSet.end$Const();
             NI.$noteq(NE); NI.$preInc()) {
          try {
            checkCtx.runChecker(Native.$star(I), B, NI.$star());
          } catch (Throwable checkerException) {
            // JAVAFIX: checker might fire exception, but we'd like to be recoverable
            NativeTrace.printStackTraceOnce(checkerException);
          }
        }
        
        // If all the produced transitions are sinks, stop.
        if (CurrSet.empty()) {
          return;
        }
        
        // Update which NodeSet is the current one.
        PrevSet = CurrSet;
      } finally {
        if (B != null) { B.$destroy(); }
      }
    }
  } finally {
    if (Tmp2 != null) { Tmp2.$destroy(); }
    if (Tmp1 != null) { Tmp1.$destroy(); }
  }
}

} // END OF class CheckerManagerStatics
