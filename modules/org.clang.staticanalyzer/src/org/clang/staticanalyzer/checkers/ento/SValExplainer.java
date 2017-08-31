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

package org.clang.staticanalyzer.checkers.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 26,
 FQN="clang::ento::SValExplainer", NM="_ZN5clang4ento13SValExplainerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainerE")
//</editor-fold>
public class SValExplainer implements /*public*/ FullSValVisitor<SValExplainer, std.string> {
/*private:*/
  private final ASTContext /*&*/ ACtx;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::printStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 30,
   FQN="clang::ento::SValExplainer::printStmt", NM="_ZN5clang4ento13SValExplainer9printStmtEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer9printStmtEPKNS_4StmtE")
  //</editor-fold>
  private std.string printStmt(/*const*/ Stmt /*P*/ S) {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      S.printPretty(OS, (PrinterHelper /*P*/ )null, new PrintingPolicy(ACtx.getLangOpts()));
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::isThisObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 37,
   FQN="clang::ento::SValExplainer::isThisObject", NM="_ZN5clang4ento13SValExplainer12isThisObjectEPKNS0_14SymbolicRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer12isThisObjectEPKNS0_14SymbolicRegionE")
  //</editor-fold>
  private boolean isThisObject(/*const*/ SymbolicRegion /*P*/ R) {
    {
      /*const*/ SymbolRegionValue /*P*/ S = dyn_cast_SymbolRegionValue(R.getSymbol());
      if ((S != null)) {
        if (isa_CXXThisRegion(S.getRegion())) {
          return true;
        }
      }
    }
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::SValExplainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 45,
   FQN="clang::ento::SValExplainer::SValExplainer", NM="_ZN5clang4ento13SValExplainerC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainerC1ERNS_10ASTContextE")
  //</editor-fold>
  public SValExplainer(final ASTContext /*&*/ Ctx) {
    // : FullSValVisitor<SValExplainer, std::string>(), ACtx(Ctx) 
    //START JInit
    $FullSValVisitor();
    this./*&*/ACtx=/*&*/Ctx;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitUnknownVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 47,
   FQN="clang::ento::SValExplainer::VisitUnknownVal", NM="_ZN5clang4ento13SValExplainer15VisitUnknownValENS0_10UnknownValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer15VisitUnknownValENS0_10UnknownValE")
  //</editor-fold>
  public std.string VisitUnknownVal(UnknownVal V) {
    return new std.string(/*KEEP_STR*/"unknown value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitUndefinedVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 51,
   FQN="clang::ento::SValExplainer::VisitUndefinedVal", NM="_ZN5clang4ento13SValExplainer17VisitUndefinedValENS0_12UndefinedValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer17VisitUndefinedValENS0_12UndefinedValE")
  //</editor-fold>
  public std.string VisitUndefinedVal(UndefinedVal V) {
    return new std.string(/*KEEP_STR*/"undefined value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitLocMemRegionVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 55,
   FQN="clang::ento::SValExplainer::VisitLocMemRegionVal", NM="_ZN5clang4ento13SValExplainer20VisitLocMemRegionValENS0_3loc12MemRegionValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer20VisitLocMemRegionValENS0_3loc12MemRegionValE")
  //</editor-fold>
  public std.string VisitLocMemRegionVal(NsLoc.MemRegionVal V) {
    /*const*/ MemRegion /*P*/ R = V.getRegion();
    {
      // Avoid the weird "pointer to pointee of ...".
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
      if ((SR != null)) {
        // However, "pointer to 'this' object" is fine.
        if (!isThisObject(SR)) {
          return Visit(SR.getSymbol());
        }
      }
    }
    return $add_T$C$P_string(/*KEEP_STR*/"pointer to ", Visit(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitLocConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 66,
   FQN="clang::ento::SValExplainer::VisitLocConcreteInt", NM="_ZN5clang4ento13SValExplainer19VisitLocConcreteIntENS0_3loc11ConcreteIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer19VisitLocConcreteIntENS0_3loc11ConcreteIntE")
  //</editor-fold>
  public std.string VisitLocConcreteInt(NsLoc.ConcreteInt V) {
    raw_string_ostream OS = null;
    try {
      APSInt I = new APSInt(V.getValue());
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      $out_raw_ostream_APSInt$C(OS.$out(/*KEEP_STR*/"concrete memory address '"), I).$out(/*KEEP_STR*/$SGL_QUOTE);
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitNonLocSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 74,
   FQN="clang::ento::SValExplainer::VisitNonLocSymbolVal", NM="_ZN5clang4ento13SValExplainer20VisitNonLocSymbolValENS0_6nonloc9SymbolValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer20VisitNonLocSymbolValENS0_6nonloc9SymbolValE")
  //</editor-fold>
  public std.string VisitNonLocSymbolVal(NsNonloc.SymbolVal V) {
    return Visit(V.getSymbol());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitNonLocConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 78,
   FQN="clang::ento::SValExplainer::VisitNonLocConcreteInt", NM="_ZN5clang4ento13SValExplainer22VisitNonLocConcreteIntENS0_6nonloc11ConcreteIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer22VisitNonLocConcreteIntENS0_6nonloc11ConcreteIntE")
  //</editor-fold>
  public std.string VisitNonLocConcreteInt(NsNonloc.ConcreteInt V) {
    raw_string_ostream OS = null;
    try {
      APSInt I = new APSInt(V.getValue());
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      $out_raw_ostream_APSInt$C(OS.$out((I.isSigned() ? $("signed ") : $("unsigned "))).$out_uint(I.getBitWidth()).$out(
              /*KEEP_STR*/"-bit integer '"
          ), I).$out(/*KEEP_STR*/$SGL_QUOTE);
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitNonLocLazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 87,
   FQN="clang::ento::SValExplainer::VisitNonLocLazyCompoundVal", NM="_ZN5clang4ento13SValExplainer26VisitNonLocLazyCompoundValENS0_6nonloc15LazyCompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer26VisitNonLocLazyCompoundValENS0_6nonloc15LazyCompoundValE")
  //</editor-fold>
  public std.string VisitNonLocLazyCompoundVal(NsNonloc.LazyCompoundVal V) {
    return $add_T$C$P_string(/*KEEP_STR*/"lazily frozen compound value of ", Visit(V.getRegion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymbolRegionValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 91,
   FQN="clang::ento::SValExplainer::VisitSymbolRegionValue", NM="_ZN5clang4ento13SValExplainer22VisitSymbolRegionValueEPKNS0_17SymbolRegionValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer22VisitSymbolRegionValueEPKNS0_17SymbolRegionValueE")
  //</editor-fold>
  public std.string VisitSymbolRegionValue(/*const*/ SymbolRegionValue /*P*/ S) {
    /*const*/ MemRegion /*P*/ R = S.getRegion();
    {
      // Special handling for argument values.
      /*const*/ VarRegion /*P*/ V = dyn_cast_VarRegion(R);
      if ((V != null)) {
        {
          /*const*/ ParmVarDecl /*P*/ D = dyn_cast_ParmVarDecl(V.getDecl());
          if ((D != null)) {
            return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"argument '", D.getQualifiedNameAsString()), /*KEEP_STR*/"'");
          }
        }
      }
    }
    return $add_T$C$P_string(/*KEEP_STR*/"initial value of ", Visit(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymbolConjured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 100,
   FQN="clang::ento::SValExplainer::VisitSymbolConjured", NM="_ZN5clang4ento13SValExplainer19VisitSymbolConjuredEPKNS0_14SymbolConjuredE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer19VisitSymbolConjuredEPKNS0_14SymbolConjuredE")
  //</editor-fold>
  public std.string VisitSymbolConjured(/*const*/ SymbolConjured /*P*/ S) {
    return $add_string_T$C$P($add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"symbol of type '", S.getType().getAsString()), 
                /*KEEP_STR*/"' conjured at statement '"), printStmt(S.getStmt())), /*KEEP_STR*/"'");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymbolDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 105,
   FQN="clang::ento::SValExplainer::VisitSymbolDerived", NM="_ZN5clang4ento13SValExplainer18VisitSymbolDerivedEPKNS0_13SymbolDerivedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer18VisitSymbolDerivedEPKNS0_13SymbolDerivedE")
  //</editor-fold>
  public std.string VisitSymbolDerived(/*const*/ SymbolDerived /*P*/ S) {
    return $add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"value derived from (", Visit(S.getParentSymbol())), 
            /*KEEP_STR*/") for "), Visit(S.getRegion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymbolExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 110,
   FQN="clang::ento::SValExplainer::VisitSymbolExtent", NM="_ZN5clang4ento13SValExplainer17VisitSymbolExtentEPKNS0_12SymbolExtentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer17VisitSymbolExtentEPKNS0_12SymbolExtentE")
  //</editor-fold>
  public std.string VisitSymbolExtent(/*const*/ SymbolExtent /*P*/ S) {
    return $add_T$C$P_string(/*KEEP_STR*/"extent of ", Visit(S.getRegion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymbolMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 114,
   FQN="clang::ento::SValExplainer::VisitSymbolMetadata", NM="_ZN5clang4ento13SValExplainer19VisitSymbolMetadataEPKNS0_14SymbolMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer19VisitSymbolMetadataEPKNS0_14SymbolMetadataE")
  //</editor-fold>
  public std.string VisitSymbolMetadata(/*const*/ SymbolMetadata /*P*/ S) {
    return $add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"metadata of type '", S.getType().getAsString()), /*KEEP_STR*/"' tied to "), 
        Visit(S.getRegion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymIntExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 119,
   FQN="clang::ento::SValExplainer::VisitSymIntExpr", NM="_ZN5clang4ento13SValExplainer15VisitSymIntExprEPKNS0_10SymIntExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer15VisitSymIntExprEPKNS0_10SymIntExprE")
  //</editor-fold>
  public std.string VisitSymIntExpr(/*const*/ SymIntExpr /*P*/ S) {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      $out_raw_ostream_APSInt$C(OS.$out(/*KEEP_STR*/$LPAREN).$out(Visit(S.getLHS())).$out(/*KEEP_STR*/") ").$out(
              BinaryOperator.getOpcodeStr(S.getOpcode()).$string()
          ).$out(/*KEEP_STR*/$SPACE), 
          S.getRHS());
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  // TODO: IntSymExpr doesn't appear in practice.
  // Add the relevant code once it does.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 131,
   FQN="clang::ento::SValExplainer::VisitSymSymExpr", NM="_ZN5clang4ento13SValExplainer15VisitSymSymExprEPKNS0_10SymSymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer15VisitSymSymExprEPKNS0_10SymSymExprE")
  //</editor-fold>
  public std.string VisitSymSymExpr(/*const*/ SymSymExpr /*P*/ S) {
    return $add_string_T$C$P($add_string($add_string_T$C$P($add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"(", Visit(S.getLHS())), /*KEEP_STR*/") "), 
                    BinaryOperator.getOpcodeStr(S.getOpcode()).$string()), 
                /*KEEP_STR*/" ("), Visit(S.getRHS())), /*KEEP_STR*/")");
  }

  
  // TODO: SymbolCast doesn't appear in practice.
  // Add the relevant code once it does.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymbolicRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 140,
   FQN="clang::ento::SValExplainer::VisitSymbolicRegion", NM="_ZN5clang4ento13SValExplainer19VisitSymbolicRegionEPKNS0_14SymbolicRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer19VisitSymbolicRegionEPKNS0_14SymbolicRegionE")
  //</editor-fold>
  public std.string VisitSymbolicRegion(/*const*/ SymbolicRegion /*P*/ R) {
    // Explain 'this' object here.
    // TODO: Explain CXXThisRegion itself, find a way to test it.
    if (isThisObject(R)) {
      return new std.string(/*KEEP_STR*/"'this' object");
    }
    return $add_T$C$P_string(/*KEEP_STR*/"pointee of ", Visit(R.getSymbol()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitAllocaRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 148,
   FQN="clang::ento::SValExplainer::VisitAllocaRegion", NM="_ZN5clang4ento13SValExplainer17VisitAllocaRegionEPKNS0_12AllocaRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer17VisitAllocaRegionEPKNS0_12AllocaRegionE")
  //</editor-fold>
  public std.string VisitAllocaRegion(/*const*/ AllocaRegion /*P*/ R) {
    return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"region allocated by '", printStmt(R.getExpr())), /*KEEP_STR*/"'");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitCompoundLiteralRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 152,
   FQN="clang::ento::SValExplainer::VisitCompoundLiteralRegion", NM="_ZN5clang4ento13SValExplainer26VisitCompoundLiteralRegionEPKNS0_21CompoundLiteralRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer26VisitCompoundLiteralRegionEPKNS0_21CompoundLiteralRegionE")
  //</editor-fold>
  public std.string VisitCompoundLiteralRegion(/*const*/ CompoundLiteralRegion /*P*/ R) {
    return $add_T$C$P_string(/*KEEP_STR*/"compound literal ", printStmt(R.getLiteralExpr()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitStringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 156,
   FQN="clang::ento::SValExplainer::VisitStringRegion", NM="_ZN5clang4ento13SValExplainer17VisitStringRegionEPKNS0_12StringRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer17VisitStringRegionEPKNS0_12StringRegionE")
  //</editor-fold>
  public std.string VisitStringRegion(/*const*/ StringRegion /*P*/ R) {
    return $add_T$C$P_string(/*KEEP_STR*/"string literal ", R.getString());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitElementRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 160,
   FQN="clang::ento::SValExplainer::VisitElementRegion", NM="_ZN5clang4ento13SValExplainer18VisitElementRegionEPKNS0_13ElementRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer18VisitElementRegionEPKNS0_13ElementRegionE")
  //</editor-fold>
  public std.string VisitElementRegion(/*const*/ ElementRegion /*P*/ R) {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      OS.$out(/*KEEP_STR*/"element of type '").$out(R.getElementType().getAsString()).$out(
          /*KEEP_STR*/"' with index "
      );
      {
        // For concrete index: omit type of the index integer.
        Optional<NsNonloc.ConcreteInt> I = R.getIndex().getAs(NsNonloc.ConcreteInt.class);
        if (I.$bool()) {
          $out_raw_ostream_APSInt$C(OS, I.$arrow().getValue());
        } else {
          OS.$out(/*KEEP_STR*/$SGL_QUOTE).$out(Visit(new SVal(JD$Move.INSTANCE, R.getIndex()))).$out(/*KEEP_STR*/$SGL_QUOTE);
        }
      }
      OS.$out($add_T$C$P_string(/*KEEP_STR*/" of ", Visit(R.getSuperRegion())));
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitVarRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 174,
   FQN="clang::ento::SValExplainer::VisitVarRegion", NM="_ZN5clang4ento13SValExplainer14VisitVarRegionEPKNS0_9VarRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer14VisitVarRegionEPKNS0_9VarRegionE")
  //</editor-fold>
  public std.string VisitVarRegion(/*const*/ VarRegion /*P*/ R) {
    /*const*/ VarDecl /*P*/ VD = R.getDecl();
    std.string Name = VD.getQualifiedNameAsString();
    if (isa_ParmVarDecl(VD)) {
      return $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"parameter '", Name), /*KEEP_STR*/"'");
    } else if (VD.hasLocalStorage()) {
      return $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"local variable '", Name), /*KEEP_STR*/"'");
    } else if (VD.isStaticLocal()) {
      return $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"static local variable '", Name), /*KEEP_STR*/"'");
    } else if (VD.hasGlobalStorage()) {
      return $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"global variable '", Name), /*KEEP_STR*/"'");
    } else {
      throw new llvm_unreachable("A variable is either local or global");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitFieldRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 189,
   FQN="clang::ento::SValExplainer::VisitFieldRegion", NM="_ZN5clang4ento13SValExplainer16VisitFieldRegionEPKNS0_11FieldRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer16VisitFieldRegionEPKNS0_11FieldRegionE")
  //</editor-fold>
  public std.string VisitFieldRegion(/*const*/ FieldRegion /*P*/ R) {
    return $add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"field '", R.getDecl().getNameAsString()), /*KEEP_STR*/"' of "), 
        Visit(R.getSuperRegion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitCXXTempObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 194,
   FQN="clang::ento::SValExplainer::VisitCXXTempObjectRegion", NM="_ZN5clang4ento13SValExplainer24VisitCXXTempObjectRegionEPKNS0_19CXXTempObjectRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer24VisitCXXTempObjectRegionEPKNS0_19CXXTempObjectRegionE")
  //</editor-fold>
  public std.string VisitCXXTempObjectRegion(/*const*/ CXXTempObjectRegion /*P*/ R) {
    return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"temporary object constructed at statement '", 
            printStmt(R.getExpr())), /*KEEP_STR*/"'");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitCXXBaseObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 199,
   FQN="clang::ento::SValExplainer::VisitCXXBaseObjectRegion", NM="_ZN5clang4ento13SValExplainer24VisitCXXBaseObjectRegionEPKNS0_19CXXBaseObjectRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer24VisitCXXBaseObjectRegionEPKNS0_19CXXBaseObjectRegionE")
  //</editor-fold>
  public std.string VisitCXXBaseObjectRegion(/*const*/ CXXBaseObjectRegion /*P*/ R) {
    return $add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"base object '", R.getDecl().getQualifiedNameAsString()), 
            /*KEEP_STR*/"' inside "), Visit(R.getSuperRegion()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 204,
   FQN="clang::ento::SValExplainer::VisitSVal", NM="_ZN5clang4ento13SValExplainer9VisitSValENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer9VisitSValENS0_4SValE")
  //</editor-fold>
  public std.string VisitSVal(SVal V) {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      $out_raw_ostream_SVal(OS, /*NO_COPY*/V);
      return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"a value unsupported by the explainer: (", 
              new std.string(OS.str())), /*KEEP_STR*/")");
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 212,
   FQN="clang::ento::SValExplainer::VisitSymExpr", NM="_ZN5clang4ento13SValExplainer12VisitSymExprEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer12VisitSymExprEPKNS0_7SymExprE")
  //</editor-fold>
  public std.string VisitSymExpr(/*const*/ SymExpr /*P*/ S) {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      S.dumpToStream(OS);
      return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"a symbolic expression unsupported by the explainer: (", 
              new std.string(OS.str())), /*KEEP_STR*/")");
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValExplainer::VisitMemRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Checkers/SValExplainer.h", line = 220,
   FQN="clang::ento::SValExplainer::VisitMemRegion", NM="_ZN5clang4ento13SValExplainer14VisitMemRegionEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento13SValExplainer14VisitMemRegionEPKNS0_9MemRegionE")
  //</editor-fold>
  public std.string VisitMemRegion(/*const*/ MemRegion /*P*/ R) {
    raw_string_ostream OS = null;
    try {
      std.string Str/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Str);
      $out_raw_ostream_MemRegion$C$P(OS, R);
      return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"a memory region unsupported by the explainer (", 
              new std.string(OS.str())), /*KEEP_STR*/")");
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "ACtx=" + "[ASTContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
