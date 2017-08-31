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
package org.clang.staticanalyzer.checkers.ento.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type EntoStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AllocationDiagnostics.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4ento27registerCStringCheckerBasicERNS0_14CheckerManagerE;_ZN5clang4ento44shouldIncludeAllocationSiteInLeakDiagnosticsERNS_15AnalyzerOptionsE;_ZN5clang4entoL17computeAdjustmentERPKNS0_7SymExprERN4llvm6APSIntE;_ZN5clang4entoL18getKeywordSelectorERNS_10ASTContextEPKcz;_ZN5clang4entoL18getKeywordSelectorERNS_10ASTContextEPc;_ZN5clang4entoL22getKeywordSelectorImplERNS_10ASTContextEPKcPc;_ZN5clang4entoL23lazyInitKeywordSelectorERNS_8SelectorERNS_10ASTContextEPKcz;_ZN5clang4entoL23lazyInitNullarySelectorERNS_8SelectorERNS_10ASTContextEPKc; -static-type=EntoStatics -package=org.clang.staticanalyzer.checkers.ento.impl")
//</editor-fold>
public final class EntoStatics {


/// \brief Returns true if leak diagnostics should directly reference
/// the allocatin site (where possible).
///
/// The default is false.
///
//<editor-fold defaultstate="collapsed" desc="clang::ento::shouldIncludeAllocationSiteInLeakDiagnostics">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AllocationDiagnostics.cpp", line = 19,
 FQN="clang::ento::shouldIncludeAllocationSiteInLeakDiagnostics", NM="_ZN5clang4ento44shouldIncludeAllocationSiteInLeakDiagnosticsERNS_15AnalyzerOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AllocationDiagnostics.cpp -nm=_ZN5clang4ento44shouldIncludeAllocationSiteInLeakDiagnosticsERNS_15AnalyzerOptionsE")
//</editor-fold>
public static boolean shouldIncludeAllocationSiteInLeakDiagnostics(final AnalyzerOptions /*&*/ AOpts) {
  return /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.AllocationDiagnosticsEntoStatics.
    shouldIncludeAllocationSiteInLeakDiagnostics(AOpts);
}


/// Register the checker which evaluates CString API calls.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCStringCheckerBasic">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2224,
 FQN="clang::ento::registerCStringCheckerBasic", NM="_ZN5clang4ento27registerCStringCheckerBasicERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento27registerCStringCheckerBasicERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCStringCheckerBasic(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CStringCheckerEntoStatics.
    registerCStringCheckerBasic(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::getKeywordSelectorImpl">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SelectorExtras.h", line = 19,
 FQN="clang::ento::getKeywordSelectorImpl", NM="_ZN5clang4entoL22getKeywordSelectorImplERNS_10ASTContextEPKcPc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4entoL22getKeywordSelectorImplERNS_10ASTContextEPKcPc")
//</editor-fold>
public static /*inline*/ Selector getKeywordSelectorImpl(final ASTContext /*&*/ Ctx, 
                      /*const*/char$ptr/*char P*/ First, 
                      type$ptr/*char P*/ argp) {
  return /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.SelectorExtrasEntoStatics.
    getKeywordSelectorImpl(Ctx, 
                      First, 
                      argp);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::getKeywordSelector">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SelectorExtras.h", line = 31,
 FQN="clang::ento::getKeywordSelector", NM="_ZN5clang4entoL18getKeywordSelectorERNS_10ASTContextEPc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4entoL18getKeywordSelectorERNS_10ASTContextEPc")
//</editor-fold>
public static /*inline*/ Selector getKeywordSelector(final ASTContext /*&*/ Ctx, type$ptr/*char P*/ argp) {
  return /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.SelectorExtrasEntoStatics.
    getKeywordSelector(Ctx, argp);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::getKeywordSelector">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SelectorExtras.h", line = 37,
 FQN="clang::ento::getKeywordSelector", NM="_ZN5clang4entoL18getKeywordSelectorERNS_10ASTContextEPKcz",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4entoL18getKeywordSelectorERNS_10ASTContextEPKcz")
//</editor-fold>
public static /*inline*/ Selector getKeywordSelector(final ASTContext /*&*/ Ctx, 
                  /*const*/char$ptr/*char P*/ First, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
  return /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.SelectorExtrasEntoStatics.
    getKeywordSelector(Ctx, 
                  First, $VarArg);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::lazyInitKeywordSelector">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SelectorExtras.h", line = 47,
 FQN="clang::ento::lazyInitKeywordSelector", NM="_ZN5clang4entoL23lazyInitKeywordSelectorERNS_8SelectorERNS_10ASTContextEPKcz",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4entoL23lazyInitKeywordSelectorERNS_8SelectorERNS_10ASTContextEPKcz")
//</editor-fold>
public static /*inline*/ void lazyInitKeywordSelector(final Selector /*&*/ Sel, final ASTContext /*&*/ Ctx, 
                       /*const*/char$ptr/*char P*/ First, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.SelectorExtrasEntoStatics.
    lazyInitKeywordSelector(Sel, Ctx, 
                       First, $VarArg);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::lazyInitNullarySelector">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SelectorExtras.h", line = 58,
 FQN="clang::ento::lazyInitNullarySelector", NM="_ZN5clang4entoL23lazyInitNullarySelectorERNS_8SelectorERNS_10ASTContextEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4entoL23lazyInitNullarySelectorERNS_8SelectorERNS_10ASTContextEPKc")
//</editor-fold>
public static /*inline*/ void lazyInitNullarySelector(final Selector /*&*/ Sel, final ASTContext /*&*/ Ctx, 
                       /*const*/char$ptr/*char P*/ Name) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.SelectorExtrasEntoStatics.
    lazyInitNullarySelector(Sel, Ctx, 
                       Name);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::computeAdjustment">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp", line = 229,
 FQN="clang::ento::computeAdjustment", NM="_ZN5clang4entoL17computeAdjustmentERPKNS0_7SymExprERN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleConstraintManager.cpp -nm=_ZN5clang4entoL17computeAdjustmentERPKNS0_7SymExprERN4llvm6APSIntE")
//</editor-fold>
public static void computeAdjustment(final type$ref</*const*/SymExpr/*P*/> /*&*/ Sym, final APSInt /*&*/ Adjustment) {
  /*delegate*/org.clang.staticanalyzer.core.ento.impl.SimpleConstraintManagerEntoStatics.
    computeAdjustment(Sym, Adjustment);
}

} // END OF class EntoStatics
