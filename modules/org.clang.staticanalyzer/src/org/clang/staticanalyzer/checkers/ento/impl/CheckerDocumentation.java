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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.ento.check.PostStmt;
import org.clang.staticanalyzer.core.ento.check.PreStmt;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.CheckBase;


/// This checker documents the callback functions checkers can use to implement
/// the custom handling of the specific events during path exploration as well
/// as reporting bugs. Most of the callbacks are targeted at path-sensitive
/// checking.
///
/// \sa CheckerContext
//<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 37,
 FQN="clang::ento::CheckerDocumentation", NM="_ZN5clang4ento20CheckerDocumentationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZN5clang4ento20CheckerDocumentationE")
//</editor-fold>
public class CheckerDocumentation extends /*public*/ Checker/*<PreStmt<ReturnStmt>, PostStmt<DeclStmt>, PreObjCMessage, PostObjCMessage, ObjCMessageNil, PreCall, PostCall, BranchCondition, Location, Bind, DeadSymbols, EndFunction, EndAnalysis, EndOfTranslationUnit, eval.Call, eval.Assume, LiveSymbols, RegionChanges, PointerEscape, ConstPointerEscape, Event<ImplicitNullDerefEvent>, ASTDecl<FunctionDecl> >*/
        implements org.clang.staticanalyzer.java.EvalAssumeChecker, org.clang.staticanalyzer.java.EvalCallChecker, org.clang.staticanalyzer.java.RegionChangesChecker, org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.PointerEscapeChecker, org.clang.staticanalyzer.java.ObjCMessageNilChecker, org.clang.staticanalyzer.java.LocationChecker, org.clang.staticanalyzer.java.LiveSymbolsChecker, org.clang.staticanalyzer.java.EventChecker, org.clang.staticanalyzer.java.EndOfTranslationUnitChecker, org.clang.staticanalyzer.java.BeginFunctionChecker, org.clang.staticanalyzer.java.EndFunctionChecker, org.clang.staticanalyzer.java.EndAnalysisChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, org.clang.staticanalyzer.java.ConstPointerEscapeChecker, org.clang.staticanalyzer.java.BranchConditionChecker, org.clang.staticanalyzer.java.BindChecker, org.clang.staticanalyzer.java.ASTDeclChecker<FunctionDecl>, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Pre-visit the Statement.
  ///
  /// The method will be called before the analyzer core processes the
  /// statement. The notification is performed for every explored CFGElement,
  /// which does not include the control flow statements such as IfStmt. The
  /// callback can be specialized to be called with any subclass of Stmt.
  ///
  /// See checkBranchCondition() callback for performing custom processing of
  /// the branching statements.
  ///
  /// check::PreStmt<ReturnStmt>
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 71,
   FQN="clang::ento::CheckerDocumentation::checkPreStmt", NM="_ZNK5clang4ento20CheckerDocumentation12checkPreStmtEPKNS_10ReturnStmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation12checkPreStmtEPKNS_10ReturnStmtERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ DS, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Post-visit the Statement.
  ///
  /// The method will be called after the analyzer core processes the
  /// statement. The notification is performed for every explored CFGElement,
  /// which does not include the control flow statements such as IfStmt. The
  /// callback can be specialized to be called with any subclass of Stmt.
  ///
  /// check::PostStmt<DeclStmt>
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 320,
   FQN="clang::ento::CheckerDocumentation::checkPostStmt", NM="_ZNK5clang4ento20CheckerDocumentation13checkPostStmtEPKNS_8DeclStmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation13checkPostStmtEPKNS_8DeclStmtERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ DeclStmt /*P*/ DS, 
               final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Pre-visit the Objective C message.
  ///
  /// This will be called before the analyzer core processes the method call.
  /// This is called for any action which produces an Objective-C message send,
  /// including explicit message syntax and property access.
  ///
  /// check::PreObjCMessage
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 90,
   FQN="clang::ento::CheckerDocumentation::checkPreObjCMessage", NM="_ZNK5clang4ento20CheckerDocumentation19checkPreObjCMessageERKNS0_14ObjCMethodCallERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation19checkPreObjCMessageERKNS0_14ObjCMethodCallERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Post-visit the Objective C message.
  /// \sa checkPreObjCMessage()
  ///
  /// check::PostObjCMessage
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 96,
   FQN="clang::ento::CheckerDocumentation::checkPostObjCMessage", NM="_ZNK5clang4ento20CheckerDocumentation20checkPostObjCMessageERKNS0_14ObjCMethodCallERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation20checkPostObjCMessageERKNS0_14ObjCMethodCallERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Visit an Objective-C message whose receiver is nil.
  ///
  /// This will be called when the analyzer core processes a method call whose
  /// receiver is definitely nil. In this case, check{Pre/Post}ObjCMessage and
  /// check{Pre/Post}Call will not be called.
  ///
  /// check::ObjCMessageNil
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkObjCMessageNil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 105,
   FQN="clang::ento::CheckerDocumentation::checkObjCMessageNil", NM="_ZNK5clang4ento20CheckerDocumentation19checkObjCMessageNilERKNS0_14ObjCMethodCallERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation19checkObjCMessageNilERKNS0_14ObjCMethodCallERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkObjCMessageNil(final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Pre-visit an abstract "call" event.
  ///
  /// This is used for checkers that want to check arguments or attributed
  /// behavior for functions and methods no matter how they are being invoked.
  ///
  /// Note that this includes ALL cross-body invocations, so if you want to
  /// limit your checks to, say, function calls, you should test for that at the
  /// beginning of your callback function.
  ///
  /// check::PreCall
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 117,
   FQN="clang::ento::CheckerDocumentation::checkPreCall", NM="_ZNK5clang4ento20CheckerDocumentation12checkPreCallERKNS0_9CallEventERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation12checkPreCallERKNS0_9CallEventERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Post-visit an abstract "call" event.
  /// \sa checkPreObjCMessage()
  ///
  /// check::PostCall
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 123,
   FQN="clang::ento::CheckerDocumentation::checkPostCall", NM="_ZNK5clang4ento20CheckerDocumentation13checkPostCallERKNS0_9CallEventERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation13checkPostCallERKNS0_9CallEventERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Pre-visit of the condition statement of a branch (such as IfStmt).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkBranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 126,
   FQN="clang::ento::CheckerDocumentation::checkBranchCondition", NM="_ZNK5clang4ento20CheckerDocumentation20checkBranchConditionEPKNS_4StmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation20checkBranchConditionEPKNS_4StmtERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkBranchCondition(/*const*/ Stmt /*P*/ Condition, final CheckerContext /*&*/ Ctx) /*const*/ {
  }

  
  /// \brief Called on a load from and a store to a location.
  ///
  /// The method will be called each time a location (pointer) value is
  /// accessed.
  /// \param Loc    The value of the location (pointer).
  /// \param IsLoad The flag specifying if the location is a store or a load.
  /// \param S      The load is performed while processing the statement.
  ///
  /// check::Location
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 137,
   FQN="clang::ento::CheckerDocumentation::checkLocation", NM="_ZNK5clang4ento20CheckerDocumentation13checkLocationENS0_4SValEbPKNS_4StmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation13checkLocationENS0_4SValEbPKNS_4StmtERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkLocation(SVal Loc, boolean IsLoad, /*const*/ Stmt /*P*/ S, 
               final CheckerContext /*&*/ $Prm3) /*const*/ {
  }

  
  /// \brief Called on binding of a value to a location.
  ///
  /// \param Loc The value of the location (pointer).
  /// \param Val The value which will be stored at the location Loc.
  /// \param S   The bind is performed while processing the statement S.
  ///
  /// check::Bind
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkBind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 147,
   FQN="clang::ento::CheckerDocumentation::checkBind", NM="_ZNK5clang4ento20CheckerDocumentation9checkBindENS0_4SValES2_PKNS_4StmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation9checkBindENS0_4SValES2_PKNS_4StmtERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal Loc, SVal Val, /*const*/ Stmt /*P*/ S, final CheckerContext /*&*/ $Prm3) /*const*/ {
  }

  
  /// \brief Called whenever a symbol becomes dead.
  ///
  /// This callback should be used by the checkers to aggressively clean
  /// up/reduce the checker state, which is important for reducing the overall
  /// memory usage. Specifically, if a checker keeps symbol specific information
  /// in the sate, it can and should be dropped after the symbol becomes dead.
  /// In addition, reporting a bug as soon as the checker becomes dead leads to
  /// more precise diagnostics. (For example, one should report that a malloced
  /// variable is not freed right after it goes out of scope.)
  ///
  /// \param SR The SymbolReaper object can be queried to determine which
  ///           symbols are dead.
  ///
  /// check::DeadSymbols
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 163,
   FQN="clang::ento::CheckerDocumentation::checkDeadSymbols", NM="_ZNK5clang4ento20CheckerDocumentation16checkDeadSymbolsERNS0_12SymbolReaperERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation16checkDeadSymbolsERNS0_12SymbolReaperERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SR, final CheckerContext /*&*/ C) /*const*/ {
  }

  
  /// \brief Called when the analyzer core starts analyzing a function,
  /// regardless of whether it is analyzed at the top level or is inlined.
  ///
  /// check::BeginFunction
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkBeginFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 170,
   FQN="clang::ento::CheckerDocumentation::checkBeginFunction", NM="_ZNK5clang4ento20CheckerDocumentation18checkBeginFunctionERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation18checkBeginFunctionERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkBeginFunction(final CheckerContext /*&*/ Ctx) /*const*/ {
  }

  
  /// \brief Called when the analyzer core reaches the end of a
  /// function being analyzed regardless of whether it is analyzed at the top
  /// level or is inlined.
  ///
  /// check::EndFunction
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkEndFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 177,
   FQN="clang::ento::CheckerDocumentation::checkEndFunction", NM="_ZNK5clang4ento20CheckerDocumentation16checkEndFunctionERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation16checkEndFunctionERNS0_14CheckerContextE")
  //</editor-fold>
  public void checkEndFunction(final CheckerContext /*&*/ Ctx) /*const*/ {
  }

  
  /// \brief Called after all the paths in the ExplodedGraph reach end of path
  /// - the symbolic execution graph is fully explored.
  ///
  /// This callback should be used in cases when a checker needs to have a
  /// global view of the information generated on all paths. For example, to
  /// compare execution summary/result several paths.
  /// See IdempotentOperationChecker for a usage example.
  ///
  /// check::EndAnalysis
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkEndAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 188,
   FQN="clang::ento::CheckerDocumentation::checkEndAnalysis", NM="_ZNK5clang4ento20CheckerDocumentation16checkEndAnalysisERNS0_13ExplodedGraphERNS0_11BugReporterERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation16checkEndAnalysisERNS0_13ExplodedGraphERNS0_11BugReporterERNS0_10ExprEngineE")
  //</editor-fold>
  public void checkEndAnalysis(final ExplodedGraph /*&*/ G, 
                  final BugReporter /*&*/ BR, 
                  final ExprEngine /*&*/ Eng) /*const*/ {
  }

  
  /// \brief Called after analysis of a TranslationUnit is complete.
  ///
  /// check::EndOfTranslationUnit
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkEndOfTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 195,
   FQN="clang::ento::CheckerDocumentation::checkEndOfTranslationUnit", NM="_ZNK5clang4ento20CheckerDocumentation25checkEndOfTranslationUnitEPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation25checkEndOfTranslationUnitEPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterE")
  //</editor-fold>
  public void checkEndOfTranslationUnit(/*const*/ TranslationUnitDecl /*P*/ TU, 
                           final AnalysisManager /*&*/ Mgr, 
                           final BugReporter /*&*/ BR) /*const*/ {
  }

  
  /// \brief Evaluates function call.
  ///
  /// The analysis core threats all function calls in the same way. However, some
  /// functions have special meaning, which should be reflected in the program
  /// state. This callback allows a checker to provide domain specific knowledge
  /// about the particular functions it knows about.
  ///
  /// \returns true if the call has been successfully evaluated
  /// and false otherwise. Note, that only one checker can evaluate a call. If
  /// more than one checker claims that they can evaluate the same call the
  /// first one wins.
  ///
  /// eval::Call
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 212,
   FQN="clang::ento::CheckerDocumentation::evalCall", NM="_ZNK5clang4ento20CheckerDocumentation8evalCallEPKNS_8CallExprERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation8evalCallEPKNS_8CallExprERNS0_14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    return true;
  }

  
  /// \brief Handles assumptions on symbolic values.
  ///
  /// This method is called when a symbolic expression is assumed to be true or
  /// false. For example, the assumptions are performed when evaluating a
  /// condition at a branch. The callback allows checkers track the assumptions
  /// performed on the symbols of interest and change the state accordingly.
  ///
  /// eval::Assume
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::evalAssume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 222,
   FQN="clang::ento::CheckerDocumentation::evalAssume", NM="_ZNK5clang4ento20CheckerDocumentation10evalAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation10evalAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> evalAssume(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
            SVal Cond, 
            boolean Assumption) /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  
  /// Allows modifying SymbolReaper object. For example, checkers can explicitly
  /// register symbols of interest as live. These symbols will not be marked
  /// dead and removed.
  ///
  /// check::LiveSymbols
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkLiveSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 231,
   FQN="clang::ento::CheckerDocumentation::checkLiveSymbols", NM="_ZNK5clang4ento20CheckerDocumentation16checkLiveSymbolsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation16checkLiveSymbolsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperE")
  //</editor-fold>
  public void checkLiveSymbols(IntrusiveRefCntPtr</*const*/ ProgramState> State, final SymbolReaper /*&*/ SR) /*const*/ {
  }

  
  /// \brief Called to determine if the checker currently needs to know if when
  /// contents of any regions change.
  ///
  /// Since it is not necessarily cheap to compute which regions are being
  /// changed, this allows the analyzer core to skip the more expensive
  /// #checkRegionChanges when no checkers are tracking any state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 239,
   FQN="clang::ento::CheckerDocumentation::wantsRegionChangeUpdate", NM="_ZNK5clang4ento20CheckerDocumentation23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public boolean wantsRegionChangeUpdate(IntrusiveRefCntPtr</*const*/ ProgramState> St) /*const*/ {
    return true;
  }

  
  /// \brief Called when the contents of one or more regions change.
  ///
  /// This can occur in many different ways: an explicit bind, a blanket
  /// invalidation of the region contents, or by passing a region to a function
  /// call whose behavior the analyzer cannot model perfectly.
  ///
  /// \param State The current program state.
  /// \param Invalidated A set of all symbols potentially touched by the change.
  /// \param ExplicitRegions The regions explicitly requested for invalidation.
  ///        For a function call, this would be the arguments. For a bind, this
  ///        would be the region being bound to.
  /// \param Regions The transitive closure of regions accessible from,
  ///        \p ExplicitRegions, i.e. all regions that may have been touched
  ///        by this change. For a simple bind, this list will be the same as
  ///        \p ExplicitRegions, since a bind does not affect the contents of
  ///        anything accessible through the base region.
  /// \param Call The opaque call triggering this invalidation. Will be 0 if the
  ///        change was not triggered by a call.
  ///
  /// Note that this callback will not be invoked unless
  /// #wantsRegionChangeUpdate returns \c true.
  ///
  /// check::RegionChanges
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkRegionChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 264,
   FQN="clang::ento::CheckerDocumentation::checkRegionChanges", NM="_ZNK5clang4ento20CheckerDocumentation18checkRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation18checkRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkRegionChanges(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ Invalidated, 
                    ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                    ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                    /*const*/ CallEvent /*P*/ Call) /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  
  /// \brief Called when pointers escape.
  ///
  /// This notifies the checkers about pointer escape, which occurs whenever
  /// the analyzer cannot track the symbol any more. For example, as a
  /// result of assigning a pointer into a global or when it's passed to a
  /// function call the analyzer cannot model.
  ///
  /// \param State The state at the point of escape.
  /// \param Escaped The list of escaped symbols.
  /// \param Call The corresponding CallEvent, if the symbols escape as
  /// parameters to the given call.
  /// \param Kind How the symbols have escaped.
  /// \returns Checkers can modify the state by returning a new state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 286,
   FQN="clang::ento::CheckerDocumentation::checkPointerEscape", NM="_ZNK5clang4ento20CheckerDocumentation18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                    /*const*/ CallEvent /*P*/ Call, 
                    PointerEscapeKind Kind) /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  
  /// \brief Called when const pointers escape.
  ///
  /// Note: in most cases checkPointerEscape callback is sufficient.
  /// \sa checkPointerEscape
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkConstPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 297,
   FQN="clang::ento::CheckerDocumentation::checkConstPointerEscape", NM="_ZNK5clang4ento20CheckerDocumentation23checkConstPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation23checkConstPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkConstPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                         final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                         /*const*/ CallEvent /*P*/ Call, 
                         PointerEscapeKind Kind) /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  
  /// check::Event<ImplicitNullDerefEvent>
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 305,
   FQN="clang::ento::CheckerDocumentation::checkEvent", NM="_ZNK5clang4ento20CheckerDocumentation10checkEventENS0_22ImplicitNullDerefEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation10checkEventENS0_22ImplicitNullDerefEventE")
  //</editor-fold>
  public void checkEvent(ImplicitNullDerefEvent Event) /*const*/ {
  }

  
  /// \brief Check every declaration in the AST.
  ///
  /// An AST traversal callback, which should only be used when the checker is
  /// not path sensitive. It will be called for every Declaration in the AST and
  /// can be specialized to only be called on subclasses of Decl, for example,
  /// FunctionDecl.
  ///
  /// check::ASTDecl<FunctionDecl>
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 315,
   FQN="clang::ento::CheckerDocumentation::checkASTDecl", NM="_ZNK5clang4ento20CheckerDocumentation12checkASTDeclEPKNS_12FunctionDeclERNS0_15AnalysisManagerERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZNK5clang4ento20CheckerDocumentation12checkASTDeclEPKNS_12FunctionDeclERNS0_15AnalysisManagerERNS0_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ FunctionDecl /*P*/ D, 
              final AnalysisManager /*&*/ Mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerDocumentation::~CheckerDocumentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp", line = 37,
   FQN="clang::ento::CheckerDocumentation::~CheckerDocumentation", NM="_ZN5clang4ento20CheckerDocumentationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckerDocumentation.cpp -nm=_ZN5clang4ento20CheckerDocumentationD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $checkPreStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof ReturnStmt) { checkPreStmt((ReturnStmt) stmt, C); } }
  
  @Override public void $checkPostStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof DeclStmt) { checkPostStmt((DeclStmt) stmt, C); } }

  private final CheckBase $CHECKS[] = {
    new PreStmt<ReturnStmt>(ReturnStmt.class), 
    new PostStmt<DeclStmt>(DeclStmt.class), 
    new PreObjCMessage(), 
    new PostObjCMessage(), 
    new ObjCMessageNil(), 
    new PreCall(), 
    new PostCall(), 
    new BranchCondition(), 
    new Location(), 
    new Bind(), 
    new DeadSymbols(), 
    new EndFunction(), 
    new EndAnalysis(), 
    new EndOfTranslationUnit(), 
    new eval.Call(), 
    new eval.Assume(), 
    new LiveSymbols(), 
    new RegionChanges(), 
    new PointerEscape(), 
    new ConstPointerEscape(), 
    new Event<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class), 
    new ASTDecl<FunctionDecl>(FunctionDecl.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
