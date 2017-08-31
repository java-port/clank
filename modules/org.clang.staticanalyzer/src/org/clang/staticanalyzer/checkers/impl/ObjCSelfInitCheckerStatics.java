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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
;


//<editor-fold defaultstate="collapsed" desc="static type ObjCSelfInitCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.ObjCSelfInitCheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL11addSelfFlagN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValEN12_GLOBAL__N_112SelfFlagEnumERNS2_14CheckerContextE;_ZL11hasSelfFlagN5clang4ento4SValEN12_GLOBAL__N_112SelfFlagEnumERNS0_14CheckerContextE;_ZL12getSelfFlagsN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE;_ZL12getSelfFlagsN5clang4ento4SValERNS0_14CheckerContextE;_ZL13isInitMessageRKN5clang4ento14ObjCMethodCallE;_ZL13isInvalidSelfPKN5clang4ExprERNS_4ento14CheckerContextE;_ZL22isInitializationMethodPKN5clang14ObjCMethodDeclE;_ZL27shouldRunOnFunctionOrMethodPKN5clang9NamedDeclE;_ZL9isSelfVarN5clang4ento4SValERNS0_14CheckerContextE; -static-type=ObjCSelfInitCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class ObjCSelfInitCheckerStatics {


// FIXME: A callback should disable checkers at the start of functions.
//<editor-fold defaultstate="collapsed" desc="shouldRunOnFunctionOrMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 386,
 FQN="shouldRunOnFunctionOrMethod", NM="_ZL27shouldRunOnFunctionOrMethodPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL27shouldRunOnFunctionOrMethodPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean shouldRunOnFunctionOrMethod(/*const*/ NamedDecl /*P*/ ND) {
  if (!(ND != null)) {
    return false;
  }
  
  /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(ND);
  if (!(MD != null)) {
    return false;
  }
  if (!isInitializationMethod(MD)) {
    return false;
  }
  
  // self = [super init] applies only to NSObject subclasses.
  // For instance, NSProxy doesn't implement -init.
  final ASTContext /*&*/ Ctx = MD.getASTContext();
  IdentifierInfo /*P*/ NSObjectII = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSObject")));
  ObjCInterfaceDecl /*P*/ ID = MD.getClassInterface$Const().getSuperClass();
  for (; (ID != null); ID = ID.getSuperClass()) {
    IdentifierInfo /*P*/ II = ID.getIdentifier();
    if (II == NSObjectII) {
      break;
    }
  }
  return ID != null;
}

//<editor-fold defaultstate="collapsed" desc="isInitializationMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 425,
 FQN="isInitializationMethod", NM="_ZL22isInitializationMethodPKN5clang14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL22isInitializationMethodPKN5clang14ObjCMethodDeclE")
//</editor-fold>
public static boolean isInitializationMethod(/*const*/ ObjCMethodDecl /*P*/ MD) {
  return MD.getMethodFamily() == ObjCMethodFamily.OMF_init;
}

//<editor-fold defaultstate="collapsed" desc="isInitMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 429,
 FQN="isInitMessage", NM="_ZL13isInitMessageRKN5clang4ento14ObjCMethodCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL13isInitMessageRKN5clang4ento14ObjCMethodCallE")
//</editor-fold>
public static boolean isInitMessage(final /*const*/ ObjCMethodCall /*&*/ Call) {
  return Call.getMethodFamily() == ObjCMethodFamily.OMF_init;
}


/// \brief Returns true if the location is 'self'.
//<editor-fold defaultstate="collapsed" desc="isSelfVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 411,
 FQN="isSelfVar", NM="_ZL9isSelfVarN5clang4ento4SValERNS0_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL9isSelfVarN5clang4ento4SValERNS0_14CheckerContextE")
//</editor-fold>
public static boolean isSelfVar(SVal location, final CheckerContext /*&*/ C) {
  AnalysisDeclContext /*P*/ analCtx = C.getCurrentAnalysisDeclContext();
  if (!(analCtx.getSelfDecl() != null)) {
    return false;
  }
  if (!location.getAs(NsLoc.MemRegionVal.class).$bool()) {
    return false;
  }
  
  NsLoc.MemRegionVal MRV = location.castAs(NsLoc.MemRegionVal.class);
  {
    /*const*/ DeclRegion /*P*/ DR = dyn_cast_DeclRegion(MRV.stripCasts());
    if ((DR != null)) {
      return (DR.getDecl() == analCtx.getSelfDecl());
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getSelfFlags">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 107,
 FQN="getSelfFlags", NM="_ZL12getSelfFlagsN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL12getSelfFlagsN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
//</editor-fold>
public static /*SelfFlagEnum*//*uint*/int getSelfFlags(SVal val, IntrusiveRefCntPtr</*const*/ ProgramState> state) {
  {
    /*const*/ SymExpr /*P*/ sym = val.getAsSymbol();
    if ((sym != null)) {
      {
        /*const*/uint$ptr/*uint P*/ attachedFlags = state.$arrow().get(ProgramStateTraitSelfFlag.$Instance, sym);
        if (/*JAVA*/(attachedFlags != null)) {
          return (/*SelfFlagEnum*//*uint*/int)attachedFlags.$star();
        }
      }
    }
  }
  return SelfFlagEnum.SelfFlag_None;
}

//<editor-fold defaultstate="collapsed" desc="getSelfFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 114,
 FQN="getSelfFlags", NM="_ZL12getSelfFlagsN5clang4ento4SValERNS0_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL12getSelfFlagsN5clang4ento4SValERNS0_14CheckerContextE")
//</editor-fold>
public static /*SelfFlagEnum*//*uint*/int getSelfFlags(SVal val, final CheckerContext /*&*/ C) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(getSelfFlags(new SVal(val), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState()))));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="addSelfFlag">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 118,
 FQN="addSelfFlag", NM="_ZL11addSelfFlagN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValEN12_GLOBAL__N_112SelfFlagEnumERNS2_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL11addSelfFlagN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValEN12_GLOBAL__N_112SelfFlagEnumERNS2_14CheckerContextE")
//</editor-fold>
public static void addSelfFlag(IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal val, 
           /*SelfFlagEnum*//*uint*/int flag, final CheckerContext /*&*/ C) {
  {
    // We tag the symbol that the SVal wraps.
    /*const*/ SymExpr /*P*/ sym = val.getAsSymbol();
    if ((sym != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(state.$assign($c$.track(state.$arrow().set(ProgramStateTraitSelfFlag.$Instance, sym, getSelfFlags(new SVal(val), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))) | flag))));
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="hasSelfFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 127,
 FQN="hasSelfFlag", NM="_ZL11hasSelfFlagN5clang4ento4SValEN12_GLOBAL__N_112SelfFlagEnumERNS0_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL11hasSelfFlagN5clang4ento4SValEN12_GLOBAL__N_112SelfFlagEnumERNS0_14CheckerContextE")
//</editor-fold>
public static boolean hasSelfFlag(SVal val, /*SelfFlagEnum*//*uint*/int flag, final CheckerContext /*&*/ C) {
  return ((getSelfFlags(new SVal(val), C) & flag) != 0);
}


/// \brief Returns true of the value of the expression is the object that 'self'
/// points to and is an object that did not come from the result of calling
/// an initializer.
//<editor-fold defaultstate="collapsed" desc="isInvalidSelf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 134,
 FQN="isInvalidSelf", NM="_ZL13isInvalidSelfPKN5clang4ExprERNS_4ento14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZL13isInvalidSelfPKN5clang4ExprERNS_4ento14CheckerContextE")
//</editor-fold>
public static boolean isInvalidSelf(/*const*/ Expr /*P*/ E, final CheckerContext /*&*/ C) {
  SVal exprVal = C.getState().$arrow().getSVal(E, C.getLocationContext());
  if (!hasSelfFlag(new SVal(exprVal), SelfFlagEnum.SelfFlag_Self, C)) {
    return false; // value did not come from 'self'.
  }
  if (hasSelfFlag(new SVal(exprVal), SelfFlagEnum.SelfFlag_InitRes, C)) {
    return false; // 'self' is properly initialized.
  }
  
  return true;
}

} // END OF class ObjCSelfInitCheckerStatics
