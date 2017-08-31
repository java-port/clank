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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectReachableSymbolsCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2119,
 FQN="(anonymous namespace)::CollectReachableSymbolsCallback", NM="_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackE")
//</editor-fold>
public final class CollectReachableSymbolsCallback extends /*public*/ SymbolVisitor implements Destructors.ClassWithDestructor {
  private DenseSet</*const*/ SymExpr /*P*/ > Symbols;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectReachableSymbolsCallback::CollectReachableSymbolsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2123,
   FQN="(anonymous namespace)::CollectReachableSymbolsCallback::CollectReachableSymbolsCallback", NM="_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  public CollectReachableSymbolsCallback(IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    // : SymbolVisitor(), Symbols() 
    //START JInit
    super();
    this.Symbols = new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectReachableSymbolsCallback::getSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2124,
   FQN="(anonymous namespace)::CollectReachableSymbolsCallback::getSymbols", NM="_ZNK12_GLOBAL__N_131CollectReachableSymbolsCallback10getSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK12_GLOBAL__N_131CollectReachableSymbolsCallback10getSymbolsEv")
  //</editor-fold>
  public /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ getSymbols() /*const*/ {
    return Symbols;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectReachableSymbolsCallback::VisitSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2126,
   FQN="(anonymous namespace)::CollectReachableSymbolsCallback::VisitSymbol", NM="_ZN12_GLOBAL__N_131CollectReachableSymbolsCallback11VisitSymbolEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN12_GLOBAL__N_131CollectReachableSymbolsCallback11VisitSymbolEPKN5clang4ento7SymExprE")
  //</editor-fold>
  @Override public boolean VisitSymbol(/*const*/ SymExpr /*P*/ Sym)/* override*/ {
    Symbols.insert(Sym);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectReachableSymbolsCallback::CollectReachableSymbolsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2119,
   FQN="(anonymous namespace)::CollectReachableSymbolsCallback::CollectReachableSymbolsCallback", NM="_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackC1EOS0_")
  //</editor-fold>
  public /*inline*/ CollectReachableSymbolsCallback(JD$Move _dparam, final CollectReachableSymbolsCallback /*&&*/$Prm0) {
    // : SymbolVisitor(static_cast<CollectReachableSymbolsCallback &&>()), Symbols(static_cast<CollectReachableSymbolsCallback &&>().Symbols) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Symbols = new DenseSet</*const*/ SymExpr /*P*/ >(JD$Move.INSTANCE, $Prm0.Symbols);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectReachableSymbolsCallback::~CollectReachableSymbolsCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2119,
   FQN="(anonymous namespace)::CollectReachableSymbolsCallback::~CollectReachableSymbolsCallback", NM="_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN12_GLOBAL__N_131CollectReachableSymbolsCallbackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Symbols.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Symbols=" + "[DenseSet$SymExpr]" // NOI18N
              + super.toString(); // NOI18N
  }
}
