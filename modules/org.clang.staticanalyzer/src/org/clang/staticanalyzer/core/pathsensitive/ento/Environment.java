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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


/// An immutable map from EnvironemntEntries to SVals.
//<editor-fold defaultstate="collapsed" desc="clang::ento::Environment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 56,
 FQN="clang::ento::Environment", NM="_ZN5clang4ento11EnvironmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento11EnvironmentE")
//</editor-fold>
public class Environment implements Destructors.ClassWithDestructor, Native.NativeComparable<Environment>, FoldingSetTrait.Profilable {
/*private:*/
  /*friend  class EnvironmentManager*/
  
  // Type definitions.
  /*typedef llvm::ImmutableMap<EnvironmentEntry, SVal> BindingsTy*/
//  public final class BindingsTy extends ImmutableMap<EnvironmentEntry, SVal>{ };
  
  // Data.
  /*package*//*friend*/ ImmutableMap<EnvironmentEntry, SVal> ExprBindings;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 66,
   FQN="clang::ento::Environment::Environment", NM="_ZN5clang4ento11EnvironmentC1EN4llvm12ImmutableMapINS0_16EnvironmentEntryENS0_4SValENS2_16ImutKeyValueInfoIS4_S5_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento11EnvironmentC1EN4llvm12ImmutableMapINS0_16EnvironmentEntryENS0_4SValENS2_16ImutKeyValueInfoIS4_S5_EEEE")
  //</editor-fold>
  /*friend*/public Environment(ImmutableMap<EnvironmentEntry, SVal> eb) {
    // : ExprBindings(eb) 
    //START JInit
    this.ExprBindings = new ImmutableMap<EnvironmentEntry, SVal>(eb);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::lookupExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 60,
   FQN="clang::ento::Environment::lookupExpr", NM="_ZNK5clang4ento11Environment10lookupExprERKNS0_16EnvironmentEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment10lookupExprERKNS0_16EnvironmentEntryE")
  //</editor-fold>
  private SVal lookupExpr(final /*const*/ EnvironmentEntry /*&*/ E) /*const*/ {
    /*const*/ type$ptr<SVal> /*P*/ X = ExprBindings.lookup(E);
    if ((X != null)) {
      SVal V = new SVal($Deref(X.$star()));
      return V;
    }
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

/*public:*/
  /*typedef BindingsTy::iterator iterator*/
//  public final class iterator extends ImmutableMap.iterator<EnvironmentEntry, SVal>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 73,
   FQN="clang::ento::Environment::begin", NM="_ZNK5clang4ento11Environment5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment5beginEv")
  //</editor-fold>
  public ImmutableMap.iterator<EnvironmentEntry, SVal> begin() /*const*/ {
    return ExprBindings.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 74,
   FQN="clang::ento::Environment::end", NM="_ZNK5clang4ento11Environment3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment3endEv")
  //</editor-fold>
  public ImmutableMap.iterator<EnvironmentEntry, SVal> end() /*const*/ {
    return ExprBindings.end();
  }

  
  /// Fetches the current binding of the expression in the
  /// Environment.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::getSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 69,
   FQN="clang::ento::Environment::getSVal", NM="_ZNK5clang4ento11Environment7getSValERKNS0_16EnvironmentEntryERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment7getSValERKNS0_16EnvironmentEntryERNS0_11SValBuilderE")
  //</editor-fold>
  public SVal getSVal(final /*const*/ EnvironmentEntry /*&*/ Entry, 
         final SValBuilder /*&*/ svalBuilder) /*const*/ {
    /*const*/ Stmt /*P*/ S = Entry.getStmt();
    /*const*/ LocationContext /*P*/ LCtx = Entry.getLocationContext();
    switch (S.getStmtClass()) {
     case CXXBindTemporaryExprClass:
     case ExprWithCleanupsClass:
     case GenericSelectionExprClass:
     case OpaqueValueExprClass:
     case ParenExprClass:
     case SubstNonTypeTemplateParmExprClass:
      throw new llvm_unreachable("Should have been handled by ignoreTransparentExprs");
     case AddrLabelExprClass:
     case CharacterLiteralClass:
     case CXXBoolLiteralExprClass:
     case CXXScalarValueInitExprClass:
     case ImplicitValueInitExprClass:
     case IntegerLiteralClass:
     case ObjCBoolLiteralExprClass:
     case CXXNullPtrLiteralExprClass:
     case ObjCStringLiteralClass:
     case StringLiteralClass:
     case TypeTraitExprClass:
      // Known constants; defer to SValBuilder.
      return new SVal(JD$Move.INSTANCE, svalBuilder.getConstantVal(cast_Expr(S)).getValue());
     case ReturnStmtClass:
      {
        /*const*/ ReturnStmt /*P*/ RS = cast_ReturnStmt(S);
        {
          /*const*/ Expr /*P*/ RE = RS.getRetValue$Const();
          if ((RE != null)) {
            return getSVal(new EnvironmentEntry(RE, LCtx), svalBuilder);
          }
        }
        return new SVal(JD$Move.INSTANCE, new UndefinedVal());
      }
     default:
      
      // Handle all other Stmt* using a lookup.
      return lookupExpr(new EnvironmentEntry(S, LCtx));
    }
  }

  
  /// Profile - Profile the contents of an Environment object for use
  ///  in a FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 82,
   FQN="clang::ento::Environment::Profile", NM="_ZN5clang4ento11Environment7ProfileERN4llvm16FoldingSetNodeIDEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento11Environment7ProfileERN4llvm16FoldingSetNodeIDEPKS1_")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, /*const*/ Environment /*P*/ env) {
    env.ExprBindings.Profile(ID);
  }

  
  /// Profile - Used to profile the contents of this object for inclusion
  ///  in a FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 88,
   FQN="clang::ento::Environment::Profile", NM="_ZNK5clang4ento11Environment7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID, this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 92,
   FQN="clang::ento::Environment::operator==", NM="_ZNK5clang4ento11EnvironmenteqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11EnvironmenteqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ Environment /*&*/ RHS) /*const*/ {
    return ExprBindings.$eq(RHS.ExprBindings);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 188,
   FQN="clang::ento::Environment::print", NM="_ZNK5clang4ento11Environment5printERN4llvm11raw_ostreamEPKcS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment5printERN4llvm11raw_ostreamEPKcS6_")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out, /*const*/char$ptr/*char P*/ NL, 
       /*const*/char$ptr/*char P*/ Sep) /*const*/ {
    boolean isFirst = true;
    ImmutableMap.iterator<EnvironmentEntry, SVal> I = null;
    ImmutableMap.iterator<EnvironmentEntry, SVal> E = null;
    try {
      
      for (I = begin(), E = end(); I.$noteq(E); I.$preInc()) {
        final /*const*/ EnvironmentEntry /*&*/ En = I.getKey();
        if (isFirst) {
          Out.$out(NL).$out(NL).$out(
              /*KEEP_STR*/"Expressions:"
          ).$out(
              NL
          );
          isFirst = false;
        } else {
          Out.$out(NL);
        }
        
        /*const*/ Stmt /*P*/ S = En.getStmt();
        assert (S != null) : "Expected non-null Stmt";
        
        Out.$out(/*KEEP_STR*/" (").$out(reinterpret_cast(/*const*/Object/*void P*/ .class, En.getLocationContext())).$out_char($$COMMA).$out(
            reinterpret_cast(/*const*/Object/*void P*/ .class, S)
        ).$out(/*KEEP_STR*/") ");
        LangOptions LO/*J*/= new LangOptions(); // FIXME.
        S.printPretty(Out, (PrinterHelper /*P*/ )null, new PrintingPolicy(LO));
        $out_raw_ostream_SVal(Out.$out(/*KEEP_STR*/" : "), /*NO_COPY*/I.getData());
      }
    } finally {
      if (E != null) { E.$destroy(); }
      if (I != null) { I.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::printAux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 99,
   FQN="clang::ento::Environment::printAux", NM="_ZNK5clang4ento11Environment8printAuxERN4llvm11raw_ostreamEbPKcS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento11Environment8printAuxERN4llvm11raw_ostreamEbPKcS6_")
  //</editor-fold>
  private void printAux(final raw_ostream /*&*/ Out, boolean printLocations, 
          /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 56,
   FQN="clang::ento::Environment::Environment", NM="_ZN5clang4ento11EnvironmentC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento11EnvironmentC1EOS1_")
  //</editor-fold>
  public /*inline*/ Environment(JD$Move _dparam, final Environment /*&&*/$Prm0) {
    // : ExprBindings(static_cast<Environment &&>().ExprBindings) 
    //START JInit
    this.ExprBindings = new ImmutableMap<EnvironmentEntry, SVal>($Prm0.ExprBindings);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::~Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 56,
   FQN="clang::ento::Environment::~Environment", NM="_ZN5clang4ento11EnvironmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento11EnvironmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ExprBindings.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 56,
   FQN="clang::ento::Environment::operator=", NM="_ZN5clang4ento11EnvironmentaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento11EnvironmentaSEOS1_")
  //</editor-fold>
  public /*inline*/ Environment /*&*/ $assignMove(final Environment /*&&*/$Prm0) {
    this.ExprBindings.$assign($Prm0.ExprBindings);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 56,
   FQN="clang::ento::Environment::Environment", NM="_ZN5clang4ento11EnvironmentC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento11EnvironmentC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Environment(final /*const*/ Environment /*&*/ $Prm0) {
    // : ExprBindings(.ExprBindings) 
    //START JInit
    this.ExprBindings = new ImmutableMap<EnvironmentEntry, SVal>($Prm0.ExprBindings);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::Environment::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 56,
   FQN="clang::ento::Environment::operator=", NM="_ZN5clang4ento11EnvironmentaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento11EnvironmentaSERKS1_")
  //</editor-fold>
  public /*inline*/ Environment /*&*/ $assign(final /*const*/ Environment /*&*/ $Prm0) {
    this.ExprBindings.$assign($Prm0.ExprBindings);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "ExprBindings=" + ExprBindings; // NOI18N
  }
}
