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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type MacOSKeychainAPICheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.MacOSKeychainAPICheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZL18getAsPointeeSymbolPKN5clang4ExprERNS_4ento14CheckerContextE;_ZL24isEnclosingFunctionParamPKN5clang4ExprE;_ZL25isBadDeallocationArgumentPKN5clang4ento9MemRegionE; -static-type=MacOSKeychainAPICheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class MacOSKeychainAPICheckerStatics {

//<editor-fold defaultstate="collapsed" desc="isEnclosingFunctionParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 161,
 FQN="isEnclosingFunctionParam", NM="_ZL24isEnclosingFunctionParamPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZL24isEnclosingFunctionParamPKN5clang4ExprE")
//</editor-fold>
public static boolean isEnclosingFunctionParam(/*const*/ Expr /*P*/ E) {
  E = E.IgnoreParenCasts$Const();
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      /*const*/ ValueDecl /*P*/ VD = DRE.getDecl$Const();
      if (isa_ImplicitParamDecl(VD) || isa_ParmVarDecl(VD)) {
        return true;
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isBadDeallocationArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 201,
 FQN="isBadDeallocationArgument", NM="_ZL25isBadDeallocationArgumentPKN5clang4ento9MemRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZL25isBadDeallocationArgumentPKN5clang4ento9MemRegionE")
//</editor-fold>
public static boolean isBadDeallocationArgument(/*const*/ MemRegion /*P*/ Arg) {
  if (!(Arg != null)) {
    return false;
  }
  return isa_AllocaRegion(Arg) || isa_BlockDataRegion(Arg)
     || isa_TypedRegion(Arg);
}


/// Given the address expression, retrieve the value it's pointing to. Assume
/// that value is itself an address, and return the corresponding symbol.
//<editor-fold defaultstate="collapsed" desc="getAsPointeeSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 210,
 FQN="getAsPointeeSymbol", NM="_ZL18getAsPointeeSymbolPKN5clang4ExprERNS_4ento14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZL18getAsPointeeSymbolPKN5clang4ExprERNS_4ento14CheckerContextE")
//</editor-fold>
public static /*const*/ SymExpr /*P*/ getAsPointeeSymbol(/*const*/ Expr /*P*/ $Expr, 
                  final CheckerContext /*&*/ C) {
  IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
  try {
    State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
    SVal ArgV = State.$arrow().getSVal($Expr, C.getLocationContext());
    {
      
      Optional<NsLoc.MemRegionVal> X = ArgV.getAs(NsLoc.MemRegionVal.class);
      if (X.$bool()) {
        final StoreManager /*&*/ SM = C.getStoreManager();
        /*const*/ SymExpr /*P*/ sym = SM.getBinding(State.$arrow().getStore(), new Loc(X.$star())).getAsLocSymbol();
        if ((sym != null)) {
          return sym;
        }
      }
    }
    return null;
  } finally {
    if (State != null) { State.$destroy(); }
  } 
}

} // END OF class MacOSKeychainAPICheckerStatics
