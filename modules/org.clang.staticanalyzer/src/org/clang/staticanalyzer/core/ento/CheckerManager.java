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

package org.clang.staticanalyzer.core.ento;

import static org.clank.support.Native.$AddrOf;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.AstFunctionPointers.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.staticanalyzer.core.impl.CheckerManagerStatics.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 103,
 FQN="clang::ento::CheckerManager", NM="_ZN5clang4ento14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManagerE")
//</editor-fold>
public class CheckerManager implements Destructors.ClassWithDestructor {
  private /*const*/ LangOptions LangOpts;
  private IntrusiveRefCntPtr<AnalyzerOptions> AOptions;
  private CheckName CurrentCheckName;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::CheckerManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 109,
   FQN="clang::ento::CheckerManager::CheckerManager", NM="_ZN5clang4ento14CheckerManagerC1ERKNS_11LangOptionsEN4llvm18IntrusiveRefCntPtrINS_15AnalyzerOptionsEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManagerC1ERKNS_11LangOptionsEN4llvm18IntrusiveRefCntPtrINS_15AnalyzerOptionsEEE")
  //</editor-fold>
  public CheckerManager(final /*const*/ LangOptions /*&*/ langOpts, IntrusiveRefCntPtr<AnalyzerOptions> AOptions) {
    // : LangOpts(langOpts), AOptions(std::move(AOptions)), CurrentCheckName(), CheckerTags(), CheckerDtors(), DeclCheckers(), BodyCheckers(), CachedDeclCheckersMap(), StmtCheckers(), CachedStmtCheckersMap(), PreObjCMessageCheckers(), PostObjCMessageCheckers(), ObjCMessageNilCheckers(), PreCallCheckers(), PostCallCheckers(), LocationCheckers(), BindCheckers(), EndAnalysisCheckers(), BeginFunctionCheckers(), EndFunctionCheckers(), BranchConditionCheckers(), LiveSymbolsCheckers(), DeadSymbolsCheckers(), RegionChangesCheckers(), PointerEscapeCheckers(), EvalAssumeCheckers(), EvalCallCheckers(), EndOfTranslationUnitCheckers(), Events() 
    //START JInit
    this.LangOpts = new LangOptions(langOpts);
    this.AOptions = new IntrusiveRefCntPtr<AnalyzerOptions>(JD$Move.INSTANCE, std.move(AOptions));
    this.CurrentCheckName = new CheckName();
    this.CheckerTags = new DenseMap</*const*/Object/*void P*/, CheckerBase /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CheckerBase /*P*/ )null);
    this.CheckerDtors = new std.vector<Check$CheckerDtor>(/*Check$CheckerDtor.EMPTY*/(Check$CheckerDtor)null);
    this.DeclCheckers = new std.vector<DeclCheckerInfo>(new DeclCheckerInfo());
    this.BodyCheckers = new std.vector<Check$CheckDeclFunc>(/*Check$CheckDeclFunc.EMPTY*/(Check$CheckDeclFunc)null);
    this.CachedDeclCheckersMap = new DenseMapUIntType<SmallVector<Check$CheckDeclFunc>>(DenseMapInfoUInt.$Info(),
            new SmallVector<Check$CheckDeclFunc>(4, /*Check$CheckDeclFunc.EMPTY*/(Check$CheckDeclFunc)null));
    this.StmtCheckers = new std.vector<StmtCheckerInfo>(new StmtCheckerInfo());
    this.CachedStmtCheckersMap = new DenseMapUIntType<SmallVector<Check$CheckStmtFunc>>(DenseMapInfoUInt.$Info(),
            new SmallVector<Check$CheckStmtFunc>(4,/*Check$CheckStmtFunc.EMPTY*/(Check$CheckStmtFunc)null));
    this.PreObjCMessageCheckers = new std.vector<Check$CheckObjCMessageFunc>(/*Check$CheckObjCMessageFunc.EMPTY*/(Check$CheckObjCMessageFunc)null);
    this.PostObjCMessageCheckers = new std.vector<Check$CheckObjCMessageFunc>(/*Check$CheckObjCMessageFunc.EMPTY*/(Check$CheckObjCMessageFunc)null);
    this.ObjCMessageNilCheckers = new std.vector<Check$CheckObjCMessageFunc>(/*Check$CheckObjCMessageFunc.EMPTY*/(Check$CheckObjCMessageFunc)null);
    this.PreCallCheckers = new std.vector<Check$CheckCallFunc>(/*Check$CheckCallFunc.EMPTY*/(Check$CheckCallFunc)null);
    this.PostCallCheckers = new std.vector<Check$CheckCallFunc>(/*Check$CheckCallFunc.EMPTY*/(Check$CheckCallFunc)null);
    this.LocationCheckers = new std.vector<Check$CheckLocationFunc>(/*Check$CheckLocationFunc.EMPTY*/(Check$CheckLocationFunc)null);
    this.BindCheckers = new std.vector<Check$CheckBindFunc>(/*Check$CheckBindFunc.EMPTY*/(Check$CheckBindFunc)null);
    this.EndAnalysisCheckers = new std.vector<Check$CheckEndAnalysisFunc>(/*Check$CheckEndAnalysisFunc.EMPTY*/(Check$CheckEndAnalysisFunc)null);
    this.BeginFunctionCheckers = new std.vector<Check$CheckBeginFunctionFunc>(/*Check$CheckBeginFunctionFunc.EMPTY*/(Check$CheckBeginFunctionFunc)null);
    this.EndFunctionCheckers = new std.vector<Check$CheckEndFunctionFunc>(/*Check$CheckEndFunctionFunc.EMPTY*/(Check$CheckEndFunctionFunc)null);
    this.BranchConditionCheckers = new std.vector<Check$CheckBranchConditionFunc>(/*Check$CheckBranchConditionFunc.EMPTY*/(Check$CheckBranchConditionFunc)null);
    this.LiveSymbolsCheckers = new std.vector<Check$CheckLiveSymbolsFunc>(/*Check$CheckLiveSymbolsFunc.EMPTY*/(Check$CheckLiveSymbolsFunc)null);
    this.DeadSymbolsCheckers = new std.vector<Check$CheckDeadSymbolsFunc>(/*Check$CheckDeadSymbolsFunc.EMPTY*/(Check$CheckDeadSymbolsFunc)null);
    this.RegionChangesCheckers = new std.vector<RegionChangesCheckerInfo>(new RegionChangesCheckerInfo());
    this.PointerEscapeCheckers = new std.vector<Check$CheckPointerEscapeFunc>(/*Check$CheckPointerEscapeFunc.EMPTY*/(Check$CheckPointerEscapeFunc)null);
    this.EvalAssumeCheckers = new std.vector<Check$EvalAssumeFunc>(/*Check$EvalAssumeFunc.EMPTY*/(Check$EvalAssumeFunc)null);
    this.EvalCallCheckers = new std.vector<Check$EvalCallFunc>(/*Check$EvalCallFunc.EMPTY*/(Check$EvalCallFunc)null);
    this.EndOfTranslationUnitCheckers = new std.vector<Check$CheckEndOfTranslationUnit>(/*Check$CheckEndOfTranslationUnit.EMPTY*/(Check$CheckEndOfTranslationUnit)null);
    this.Events = new DenseMap<Object/*void P*/ , EventInfo>(DenseMapInfo$LikePtr.$Info(), new EventInfo());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::~CheckerManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 780,
   FQN="clang::ento::CheckerManager::~CheckerManager", NM="_ZN5clang4ento14CheckerManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (/*uint*/int i = 0, e = CheckerDtors.size(); i != e; ++i)  {
      CheckerDtors.$at(i).$call();
    }
    //START JDestroy
    Events.$destroy();
    EndOfTranslationUnitCheckers.$destroy();
    EvalCallCheckers.$destroy();
    EvalAssumeCheckers.$destroy();
    PointerEscapeCheckers.$destroy();
    RegionChangesCheckers.$destroy();
    DeadSymbolsCheckers.$destroy();
    LiveSymbolsCheckers.$destroy();
    BranchConditionCheckers.$destroy();
    EndFunctionCheckers.$destroy();
    BeginFunctionCheckers.$destroy();
    EndAnalysisCheckers.$destroy();
    BindCheckers.$destroy();
    LocationCheckers.$destroy();
    PostCallCheckers.$destroy();
    PreCallCheckers.$destroy();
    ObjCMessageNilCheckers.$destroy();
    PostObjCMessageCheckers.$destroy();
    PreObjCMessageCheckers.$destroy();
    CachedStmtCheckersMap.$destroy();
    StmtCheckers.$destroy();
    CachedDeclCheckersMap.$destroy();
    BodyCheckers.$destroy();
    DeclCheckers.$destroy();
    CheckerDtors.$destroy();
    CheckerTags.$destroy();
    AOptions.$destroy();
    LangOpts.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::setCurrentCheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 114,
   FQN="clang::ento::CheckerManager::setCurrentCheckName", NM="_ZN5clang4ento14CheckerManager19setCurrentCheckNameENS0_9CheckNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager19setCurrentCheckNameENS0_9CheckNameE")
  //</editor-fold>
  public void setCurrentCheckName(CheckName name) {
    CurrentCheckName.$assign(name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::getCurrentCheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 115,
   FQN="clang::ento::CheckerManager::getCurrentCheckName", NM="_ZNK5clang4ento14CheckerManager19getCurrentCheckNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZNK5clang4ento14CheckerManager19getCurrentCheckNameEv")
  //</editor-fold>
  public CheckName getCurrentCheckName() /*const*/ {
    return new CheckName(CurrentCheckName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::hasPathSensitiveCheckers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 24,
   FQN="clang::ento::CheckerManager::hasPathSensitiveCheckers", NM="_ZNK5clang4ento14CheckerManager24hasPathSensitiveCheckersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZNK5clang4ento14CheckerManager24hasPathSensitiveCheckersEv")
  //</editor-fold>
  public boolean hasPathSensitiveCheckers() /*const*/ {
    return !StmtCheckers.empty()
       || !PreObjCMessageCheckers.empty()
       || !PostObjCMessageCheckers.empty()
       || !PreCallCheckers.empty()
       || !PostCallCheckers.empty()
       || !LocationCheckers.empty()
       || !BindCheckers.empty()
       || !EndAnalysisCheckers.empty()
       || !EndFunctionCheckers.empty()
       || !BranchConditionCheckers.empty()
       || !LiveSymbolsCheckers.empty()
       || !DeadSymbolsCheckers.empty()
       || !RegionChangesCheckers.empty()
       || !EvalAssumeCheckers.empty()
       || !EvalCallCheckers.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::finishedCheckerRegistration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 42,
   FQN="clang::ento::CheckerManager::finishedCheckerRegistration", NM="_ZN5clang4ento14CheckerManager27finishedCheckerRegistrationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager27finishedCheckerRegistrationEv")
  //</editor-fold>
  public void finishedCheckerRegistration() {
    // Make sure that for every event that has listeners, there is at least
    // one dispatcher registered for it.
    for (DenseMapIterator<Object/*void P*/ , EventInfo> I = Events.begin(), E = Events.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
      assert (I.$arrow().second.HasDispatcher) : "No dispatcher registered for an event";
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 121,
   FQN="clang::ento::CheckerManager::getLangOpts", NM="_ZNK5clang4ento14CheckerManager11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZNK5clang4ento14CheckerManager11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::getAnalyzerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 122,
   FQN="clang::ento::CheckerManager::getAnalyzerOptions", NM="_ZN5clang4ento14CheckerManager18getAnalyzerOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager18getAnalyzerOptionsEv")
  //</editor-fold>
  public AnalyzerOptions /*&*/ getAnalyzerOptions() {
    return AOptions.$star();
  }

  
  // JAVA: typedef CheckerBase *CheckerRef
//  public final class CheckerRef extends CheckerBase /*P*/ { };
  // JAVA: typedef const void *CheckerTag;
  // JAVA: typedef CheckerFn<void ()> CheckerDtor
//  public final class CheckerDtor extends CheckerFnT1ToT<void>{ };
  
  //===----------------------------------------------------------------------===//
  // registerChecker
  //===----------------------------------------------------------------------===//
  
  /// \brief Used to register checkers.
  ///
  /// \returns a pointer to the checker object.
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::registerChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 136,
   FQN="clang::ento::CheckerManager::registerChecker", NM="Tpl__ZN5clang4ento14CheckerManager15registerCheckerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp -nm=Tpl__ZN5clang4ento14CheckerManager15registerCheckerEv")
  //</editor-fold>
  public </*typename*/ CHECKER extends CheckerBase> CHECKER /*P*/ registerChecker(Class<CHECKER> clazz) {
    /*const*/Object/*void P*/ tag = CheckerManager.getTag(clazz);
    final type$ref<CheckerBase /*P*/ /*&*/> ref = CheckerTags.ref$at(tag);
    if ((ref.$deref() != null)) {
      return ((/*static_cast*/CHECKER /*P*/ )(ref.$deref())); // already registered.
    }
    final CHECKER /*P*/ checker;
    try {
      checker = clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException ex) {
      Logger.getLogger(CheckerManager.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
    checker.Name = CurrentCheckName;
    CheckerDtors.push_back_T$RR(new Check$CheckerDtor(/*checker, destruct<CHECKER>*/) {
      @Override
      public void $call(Object C) {
        destruct(checker);
      }

      @Override
      public CheckerBase getChecker() {
        return checker;
      }
    });
    for(CheckBase c : checker.$getChecks()) {
      c._register(checker, /*Deref*/this);
    }
    ref.$set(checker);
    return checker;
  }

  
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::registerChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 151,
   FQN="clang::ento::CheckerManager::registerChecker", NM="Tpl__ZN5clang4ento14CheckerManager15registerCheckerERNS_15AnalyzerOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=Tpl__ZN5clang4ento14CheckerManager15registerCheckerERNS_15AnalyzerOptionsE")
  //</editor-fold>
  public </*typename*/ CHECKER extends CheckerBase> CHECKER /*P*/ registerChecker(Class<CHECKER> clazz, final AnalyzerOptions /*&*/ AOpts) {
    /*const*/Object/*void P*/ tag = CheckerManager.getTag(clazz);
    final type$ref<CheckerBase /*P*/ /*&*/> ref = CheckerTags.ref$at(tag);
    if ((ref.$deref() != null)) {
      return ((/*static_cast*/CHECKER /*P*/ )(ref.$deref())); // already registered.
    }
    final CHECKER /*P*/ checker;
    try {
      checker = clazz.getConstructor(AnalyzerOptions.class).newInstance(AOpts);
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
      Logger.getLogger(CheckerManager.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
    
    checker.Name = CurrentCheckName;
    CheckerDtors.push_back_T$RR(new Check$CheckerDtor(/*checker, destruct<CHECKER>*/) {
      @Override
      public void $call(Object C) {
        destruct(checker);
      }

      @Override
      public CheckerBase getChecker() {
        return checker;
      }
    });
    for(CheckBase c : checker.$getChecks()) {
      c._register(checker, /*Deref*/this);
    }
    ref.$set(checker);
    return checker;
  }

  
  //===----------------------------------------------------------------------===//
  // Functions for running checkers for AST traversing..
  //===----------------------------------------------------------------------===//
  
  /// \brief Run checkers handling Decls.
  
  //===----------------------------------------------------------------------===//
  // Functions for running checkers for AST traversing..
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersOnASTDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*protect from exceptions*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 56,
   FQN="clang::ento::CheckerManager::runCheckersOnASTDecl", NM="_ZN5clang4ento14CheckerManager20runCheckersOnASTDeclEPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager20runCheckersOnASTDeclEPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterE")
  //</editor-fold>
  public void runCheckersOnASTDecl(/*const*/ Decl /*P*/ D, final AnalysisManager /*&*/ mgr, 
                      final BugReporter /*&*/ BR) {
    assert Native.$bool(D);
    
    /*uint*/int DeclKind = D.getKind().getValue();
    SmallVector<Check$CheckDeclFunc> /*P*/ checkers = null;
    DenseMapIteratorUIntType<SmallVector<Check$CheckDeclFunc>> CCI = CachedDeclCheckersMap.find(DeclKind);
    if (CCI.$noteq(/*NO_ITER_COPY*/CachedDeclCheckersMap.end())) {
      checkers = $AddrOf((CCI.$arrow().second));
    } else {
      // Find the checkers that should run for this Decl and cache them.
      checkers = $AddrOf(CachedDeclCheckersMap.$at_T1$C$R(DeclKind));
      for (/*uint*/int i = 0, e = DeclCheckers.size(); i != e; ++i) {
        final DeclCheckerInfo /*&*/ info = DeclCheckers.$at(i);
        if (info.IsForDeclFn.$call(D)) {
          checkers.push_back(info.CheckFn);
        }
      }
    }
    assert Native.$bool(checkers);
    for (type$ptr<Check$CheckDeclFunc/*P*/ > I = $tryClone(checkers.begin()), /*P*/ E = $tryClone(checkers.end()); $noteq_ptr(I, E); I.$preInc())  {
      try {
        (I.$star()).$call(D, mgr, BR);
      } catch (Throwable checkerException) {
        // JAVAFIX: checker might fire exception, but we'd like to be recoverable
        NativeTrace.printStackTraceOnce(checkerException);
      }
    }
  }

  
  /// \brief Run checkers handling Decls containing a Stmt body.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersOnASTBody">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*protect from exceptions*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 81,
   FQN="clang::ento::CheckerManager::runCheckersOnASTBody", NM="_ZN5clang4ento14CheckerManager20runCheckersOnASTBodyEPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager20runCheckersOnASTBodyEPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterE")
  //</editor-fold>
  public void runCheckersOnASTBody(/*const*/ Decl /*P*/ D, final AnalysisManager /*&*/ mgr, 
                      final BugReporter /*&*/ BR) {
    assert ((D != null) && D.hasBody());
    
    for (/*uint*/int i = 0, e = BodyCheckers.size(); i != e; ++i)  {
      try {
        BodyCheckers.$at(i).$call(D, mgr, BR);
      } catch (Throwable checkerException) {
        // JAVAFIX: checker might fire exception, but we'd like to be recoverable
        NativeTrace.printStackTraceOnce(checkerException);
      }      
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Functions for running checkers for path-sensitive checking.
  //===----------------------------------------------------------------------===//
  
  /// \brief Run checkers for pre-visiting Stmts.
  ///
  /// The notification is performed for every explored CFGElement, which does
  /// not include the control flow statements such as IfStmt.
  ///
  /// \sa runCheckersForBranchCondition, runCheckersForPostStmt
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 187,
   FQN="clang::ento::CheckerManager::runCheckersForPreStmt", NM="_ZN5clang4ento14CheckerManager21runCheckersForPreStmtERNS0_15ExplodedNodeSetERKS2_PKNS_4StmtERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager21runCheckersForPreStmtERNS0_15ExplodedNodeSetERKS2_PKNS_4StmtERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForPreStmt(final ExplodedNodeSet /*&*/ Dst, 
                       final /*const*/ ExplodedNodeSet /*&*/ Src, 
                       /*const*/ Stmt /*P*/ S, 
                       final ExprEngine /*&*/ Eng) {
    runCheckersForStmt(/*isPreVisit=*/ true, Dst, Src, S, Eng);
  }

  
  /// \brief Run checkers for post-visiting Stmts.
  ///
  /// The notification is performed for every explored CFGElement, which does
  /// not include the control flow statements such as IfStmt.
  ///
  /// \sa runCheckersForBranchCondition, runCheckersForPreStmt
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 200,
   FQN="clang::ento::CheckerManager::runCheckersForPostStmt", NM="_ZN5clang4ento14CheckerManager22runCheckersForPostStmtERNS0_15ExplodedNodeSetERKS2_PKNS_4StmtERNS0_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager22runCheckersForPostStmtERNS0_15ExplodedNodeSetERKS2_PKNS_4StmtERNS0_10ExprEngineEb")
  //</editor-fold>
  public void runCheckersForPostStmt(final ExplodedNodeSet /*&*/ Dst, 
                        final /*const*/ ExplodedNodeSet /*&*/ Src, 
                        /*const*/ Stmt /*P*/ S, 
                        final ExprEngine /*&*/ Eng) {
    runCheckersForPostStmt(Dst, 
                        Src, 
                        S, 
                        Eng, 
                        false);
  }
  public void runCheckersForPostStmt(final ExplodedNodeSet /*&*/ Dst, 
                        final /*const*/ ExplodedNodeSet /*&*/ Src, 
                        /*const*/ Stmt /*P*/ S, 
                        final ExprEngine /*&*/ Eng, 
                        boolean wasInlined/*= false*/) {
    runCheckersForStmt(/*isPreVisit=*/ false, Dst, Src, S, Eng, wasInlined);
  }

  
  /// \brief Run checkers for visiting Stmts.
  
  /// \brief Run checkers for visiting Stmts.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 166,
   FQN="clang::ento::CheckerManager::runCheckersForStmt", NM="_ZN5clang4ento14CheckerManager18runCheckersForStmtEbRNS0_15ExplodedNodeSetERKS2_PKNS_4StmtERNS0_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager18runCheckersForStmtEbRNS0_15ExplodedNodeSetERKS2_PKNS_4StmtERNS0_10ExprEngineEb")
  //</editor-fold>
  public void runCheckersForStmt(boolean isPreVisit, 
                    final ExplodedNodeSet /*&*/ Dst, 
                    final /*const*/ ExplodedNodeSet /*&*/ Src, 
                    /*const*/ Stmt /*P*/ S, 
                    final ExprEngine /*&*/ Eng) {
    runCheckersForStmt(isPreVisit, 
                    Dst, 
                    Src, 
                    S, 
                    Eng, 
                    false);
  }
  public void runCheckersForStmt(boolean isPreVisit, 
                    final ExplodedNodeSet /*&*/ Dst, 
                    final /*const*/ ExplodedNodeSet /*&*/ Src, 
                    /*const*/ Stmt /*P*/ S, 
                    final ExprEngine /*&*/ Eng, 
                    boolean WasInlined/*= false*/) {
    CheckStmtContext C/*J*/= new CheckStmtContext(isPreVisit, getCachedStmtCheckersFor(S, isPreVisit), 
        S, Eng, WasInlined);
    CheckerManagerStatics.expandGraphWithCheckers(new CheckStmtContext(C), Dst, Src);
  }

  
  /// \brief Run checkers for pre-visiting obj-c messages.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 215,
   FQN="clang::ento::CheckerManager::runCheckersForPreObjCMessage", NM="_ZN5clang4ento14CheckerManager28runCheckersForPreObjCMessageERNS0_15ExplodedNodeSetERKS2_RKNS0_14ObjCMethodCallERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager28runCheckersForPreObjCMessageERNS0_15ExplodedNodeSetERKS2_RKNS0_14ObjCMethodCallERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForPreObjCMessage(final ExplodedNodeSet /*&*/ Dst, 
                              final /*const*/ ExplodedNodeSet /*&*/ Src, 
                              final /*const*/ ObjCMethodCall /*&*/ msg, 
                              final ExprEngine /*&*/ Eng) {
    runCheckersForObjCMessage(ObjCMessageVisitKind.Pre, Dst, Src, msg, Eng);
  }

  
  /// \brief Run checkers for post-visiting obj-c messages.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 223,
   FQN="clang::ento::CheckerManager::runCheckersForPostObjCMessage", NM="_ZN5clang4ento14CheckerManager29runCheckersForPostObjCMessageERNS0_15ExplodedNodeSetERKS2_RKNS0_14ObjCMethodCallERNS0_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager29runCheckersForPostObjCMessageERNS0_15ExplodedNodeSetERKS2_RKNS0_14ObjCMethodCallERNS0_10ExprEngineEb")
  //</editor-fold>
  public void runCheckersForPostObjCMessage(final ExplodedNodeSet /*&*/ Dst, 
                               final /*const*/ ExplodedNodeSet /*&*/ Src, 
                               final /*const*/ ObjCMethodCall /*&*/ msg, 
                               final ExprEngine /*&*/ Eng) {
    runCheckersForPostObjCMessage(Dst, 
                               Src, 
                               msg, 
                               Eng, 
                               false);
  }
  public void runCheckersForPostObjCMessage(final ExplodedNodeSet /*&*/ Dst, 
                               final /*const*/ ExplodedNodeSet /*&*/ Src, 
                               final /*const*/ ObjCMethodCall /*&*/ msg, 
                               final ExprEngine /*&*/ Eng, 
                               boolean wasInlined/*= false*/) {
    runCheckersForObjCMessage(ObjCMessageVisitKind.Post, Dst, Src, msg, Eng, 
        wasInlined);
  }

  
  /// \brief Run checkers for visiting an obj-c message to nil.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForObjCMessageNil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 233,
   FQN="clang::ento::CheckerManager::runCheckersForObjCMessageNil", NM="_ZN5clang4ento14CheckerManager28runCheckersForObjCMessageNilERNS0_15ExplodedNodeSetERKS2_RKNS0_14ObjCMethodCallERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager28runCheckersForObjCMessageNilERNS0_15ExplodedNodeSetERKS2_RKNS0_14ObjCMethodCallERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForObjCMessageNil(final ExplodedNodeSet /*&*/ Dst, 
                              final /*const*/ ExplodedNodeSet /*&*/ Src, 
                              final /*const*/ ObjCMethodCall /*&*/ msg, 
                              final ExprEngine /*&*/ Eng) {
    runCheckersForObjCMessage(ObjCMessageVisitKind.MessageNil, Dst, Src, msg, 
        Eng);
  }

  
  /// \brief Run checkers for visiting obj-c messages.
  
  /// \brief Run checkers for visiting obj-c messages.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 221,
   FQN="clang::ento::CheckerManager::runCheckersForObjCMessage", NM="_ZN5clang4ento14CheckerManager25runCheckersForObjCMessageENS0_20ObjCMessageVisitKindERNS0_15ExplodedNodeSetERKS3_RKNS0_14ObjCMethodCallERNS0_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25runCheckersForObjCMessageENS0_20ObjCMessageVisitKindERNS0_15ExplodedNodeSetERKS3_RKNS0_14ObjCMethodCallERNS0_10ExprEngineEb")
  //</editor-fold>
  public void runCheckersForObjCMessage(ObjCMessageVisitKind visitKind, 
                           final ExplodedNodeSet /*&*/ Dst, 
                           final /*const*/ ExplodedNodeSet /*&*/ Src, 
                           final /*const*/ ObjCMethodCall /*&*/ msg, 
                           final ExprEngine /*&*/ Eng) {
    runCheckersForObjCMessage(visitKind, 
                           Dst, 
                           Src, 
                           msg, 
                           Eng, 
                           false);
  }
  public void runCheckersForObjCMessage(ObjCMessageVisitKind visitKind, 
                           final ExplodedNodeSet /*&*/ Dst, 
                           final /*const*/ ExplodedNodeSet /*&*/ Src, 
                           final /*const*/ ObjCMethodCall /*&*/ msg, 
                           final ExprEngine /*&*/ Eng, 
                           boolean WasInlined/*= false*/) {
    final /*constconst*/std.vector<Check$CheckObjCMessageFunc/*,default_cls_allocator*/> /*&*/ checkers = getObjCMessageCheckers(visitKind);
    CheckObjCMessageContext C/*J*/= new CheckObjCMessageContext(visitKind, checkers, msg, Eng, WasInlined);
    CheckerManagerStatics.expandGraphWithCheckers(new CheckObjCMessageContext(C), Dst, Src);
  }

  
  /// \brief Run checkers for pre-visiting obj-c messages.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 250,
   FQN="clang::ento::CheckerManager::runCheckersForPreCall", NM="_ZN5clang4ento14CheckerManager21runCheckersForPreCallERNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager21runCheckersForPreCallERNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForPreCall(final ExplodedNodeSet /*&*/ Dst, final /*const*/ ExplodedNodeSet /*&*/ Src, 
                       final /*const*/ CallEvent /*&*/ Call, final ExprEngine /*&*/ Eng) {
    runCheckersForCallEvent(/*isPreVisit=*/ true, Dst, Src, Call, Eng);
  }

  
  /// \brief Run checkers for post-visiting obj-c messages.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 256,
   FQN="clang::ento::CheckerManager::runCheckersForPostCall", NM="_ZN5clang4ento14CheckerManager22runCheckersForPostCallERNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager22runCheckersForPostCallERNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineEb")
  //</editor-fold>
  public void runCheckersForPostCall(final ExplodedNodeSet /*&*/ Dst, final /*const*/ ExplodedNodeSet /*&*/ Src, 
                        final /*const*/ CallEvent /*&*/ Call, final ExprEngine /*&*/ Eng) {
    runCheckersForPostCall(Dst, Src, 
                        Call, Eng, 
                        false);
  }
  public void runCheckersForPostCall(final ExplodedNodeSet /*&*/ Dst, final /*const*/ ExplodedNodeSet /*&*/ Src, 
                        final /*const*/ CallEvent /*&*/ Call, final ExprEngine /*&*/ Eng, 
                        boolean wasInlined/*= false*/) {
    runCheckersForCallEvent(/*isPreVisit=*/ false, Dst, Src, Call, Eng, 
        wasInlined);
  }

  
  /// \brief Run checkers for visiting obj-c messages.
  
  /// \brief Run checkers for visiting an abstract call event.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForCallEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 275,
   FQN="clang::ento::CheckerManager::runCheckersForCallEvent", NM="_ZN5clang4ento14CheckerManager23runCheckersForCallEventEbRNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager23runCheckersForCallEventEbRNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineEb")
  //</editor-fold>
  public void runCheckersForCallEvent(boolean isPreVisit, 
                         final ExplodedNodeSet /*&*/ Dst, 
                         final /*const*/ ExplodedNodeSet /*&*/ Src, 
                         final /*const*/ CallEvent /*&*/ Call, 
                         final ExprEngine /*&*/ Eng) {
    runCheckersForCallEvent(isPreVisit, 
                         Dst, 
                         Src, 
                         Call, 
                         Eng, 
                         false);
  }
  public void runCheckersForCallEvent(boolean isPreVisit, 
                         final ExplodedNodeSet /*&*/ Dst, 
                         final /*const*/ ExplodedNodeSet /*&*/ Src, 
                         final /*const*/ CallEvent /*&*/ Call, 
                         final ExprEngine /*&*/ Eng, 
                         boolean WasInlined/*= false*/) {
    CheckCallContext C/*J*/= new CheckCallContext(isPreVisit, 
        isPreVisit ? PreCallCheckers : PostCallCheckers, 
        Call, Eng, WasInlined);
    CheckerManagerStatics.expandGraphWithCheckers(new CheckCallContext(C), Dst, Src);
  }

  
  /// \brief Run checkers for load/store of a location.
  
  /// \brief Run checkers for load/store of a location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 324,
   FQN="clang::ento::CheckerManager::runCheckersForLocation", NM="_ZN5clang4ento14CheckerManager22runCheckersForLocationERNS0_15ExplodedNodeSetERKS2_NS0_4SValEbPKNS_4StmtES9_RNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager22runCheckersForLocationERNS0_15ExplodedNodeSetERKS2_NS0_4SValEbPKNS_4StmtES9_RNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForLocation(final ExplodedNodeSet /*&*/ Dst, 
                        final /*const*/ ExplodedNodeSet /*&*/ Src, 
                        SVal location, boolean isLoad, 
                        /*const*/ Stmt /*P*/ NodeEx, 
                        /*const*/ Stmt /*P*/ BoundEx, 
                        final ExprEngine /*&*/ Eng) {
    CheckLocationContext C/*J*/= new CheckLocationContext(LocationCheckers, new SVal(location), isLoad, NodeEx, 
        BoundEx, Eng);
    CheckerManagerStatics.expandGraphWithCheckers(new CheckLocationContext(C), Dst, Src);
  }

  
  /// \brief Run checkers for binding of a value to a location.
  
  /// \brief Run checkers for binding of a value to a location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForBind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 364,
   FQN="clang::ento::CheckerManager::runCheckersForBind", NM="_ZN5clang4ento14CheckerManager18runCheckersForBindERNS0_15ExplodedNodeSetERKS2_NS0_4SValES6_PKNS_4StmtERNS0_10ExprEngineERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager18runCheckersForBindERNS0_15ExplodedNodeSetERKS2_NS0_4SValES6_PKNS_4StmtERNS0_10ExprEngineERKNS_12ProgramPointE")
  //</editor-fold>
  public void runCheckersForBind(final ExplodedNodeSet /*&*/ Dst, 
                    final /*const*/ ExplodedNodeSet /*&*/ Src, 
                    SVal location, SVal val, 
                    /*const*/ Stmt /*P*/ S, final ExprEngine /*&*/ Eng, 
                    final /*const*/ ProgramPoint /*&*/ PP) {
    CheckBindContext C/*J*/= new CheckBindContext(BindCheckers, new SVal(location), new SVal(val), S, Eng, PP);
    CheckerManagerStatics.expandGraphWithCheckers(new CheckBindContext(C), Dst, Src);
  }

  
  /// \brief Run checkers for end of analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForEndAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 373,
   FQN="clang::ento::CheckerManager::runCheckersForEndAnalysis", NM="_ZN5clang4ento14CheckerManager25runCheckersForEndAnalysisERNS0_13ExplodedGraphERNS0_11BugReporterERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25runCheckersForEndAnalysisERNS0_13ExplodedGraphERNS0_11BugReporterERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForEndAnalysis(final ExplodedGraph /*&*/ G, 
                           final BugReporter /*&*/ BR, 
                           final ExprEngine /*&*/ Eng) {
    for (/*uint*/int i = 0, e = EndAnalysisCheckers.size(); i != e; ++i)  {
      EndAnalysisCheckers.$at(i).$call(G, BR, Eng);
    }
  }

  
  /// \brief Run checkers on begining of function.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForBeginFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 404,
   FQN="clang::ento::CheckerManager::runCheckersForBeginFunction", NM="_ZN5clang4ento14CheckerManager27runCheckersForBeginFunctionERNS0_15ExplodedNodeSetERKNS_9BlockEdgeEPNS0_12ExplodedNodeERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager27runCheckersForBeginFunctionERNS0_15ExplodedNodeSetERKNS_9BlockEdgeEPNS0_12ExplodedNodeERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForBeginFunction(final ExplodedNodeSet /*&*/ Dst, 
                             final /*const*/ BlockEdge /*&*/ L, 
                             ExplodedNode /*P*/ Pred, 
                             final ExprEngine /*&*/ Eng) {
    ExplodedNodeSet Src = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Src/*J*/= new ExplodedNodeSet();
      Src.insert($c$.track(new ExplodedNodeSet(Pred))); $c$.clean();
      CheckBeginFunctionContext C/*J*/= new CheckBeginFunctionContext(BeginFunctionCheckers, Eng, L);
      CheckerManagerStatics.expandGraphWithCheckers(new CheckBeginFunctionContext(C), Dst, Src);
    } finally {
      if (Src != null) { Src.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Run checkers on end of function.
  
  /// \brief Run checkers for end of path.
  // Note, We do not chain the checker output (like in expandGraphWithCheckers)
  // for this callback since end of path nodes are expected to be final.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForEndFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 417,
   FQN="clang::ento::CheckerManager::runCheckersForEndFunction", NM="_ZN5clang4ento14CheckerManager25runCheckersForEndFunctionERNS0_18NodeBuilderContextERNS0_15ExplodedNodeSetEPNS0_12ExplodedNodeERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25runCheckersForEndFunctionERNS0_18NodeBuilderContextERNS0_15ExplodedNodeSetEPNS0_12ExplodedNodeERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForEndFunction(final NodeBuilderContext /*&*/ BC, 
                           final ExplodedNodeSet /*&*/ Dst, 
                           ExplodedNode /*P*/ Pred, 
                           final ExprEngine /*&*/ Eng) {
    NodeBuilder Bldr = null;
    try {
      
      // We define the builder outside of the loop bacause if at least one checkers
      // creates a sucsessor for Pred, we do not need to generate an
      // autotransition for it.
      Bldr/*J*/= new NodeBuilder(Pred, Dst, BC);
      for (/*uint*/int i = 0, e = EndFunctionCheckers.size(); i != e; ++i) {
        Check$CheckEndFunctionFunc checkFn = EndFunctionCheckers.$at(i);

        final /*const*/ ProgramPoint /*&*/ L = new BlockEntrance(BC.Block, 
            Pred.getLocationContext(), 
            checkFn.getChecker());
        CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L);
        checkFn.$call(C);
      }
    } finally {
      if (Bldr != null) { Bldr.$destroy(); }
    }
  }

  
  /// \brief Run checkers for branch condition.
  
  /// \brief Run checkers for branch condition.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForBranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 462,
   FQN="clang::ento::CheckerManager::runCheckersForBranchCondition", NM="_ZN5clang4ento14CheckerManager29runCheckersForBranchConditionEPKNS_4StmtERNS0_15ExplodedNodeSetEPNS0_12ExplodedNodeERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager29runCheckersForBranchConditionEPKNS_4StmtERNS0_15ExplodedNodeSetEPNS0_12ExplodedNodeERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForBranchCondition(/*const*/ Stmt /*P*/ Condition, 
                               final ExplodedNodeSet /*&*/ Dst, 
                               ExplodedNode /*P*/ Pred, 
                               final ExprEngine /*&*/ Eng) {
    ExplodedNodeSet Src = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Src/*J*/= new ExplodedNodeSet();
      Src.insert($c$.track(new ExplodedNodeSet(Pred))); $c$.clean();
      CheckBranchConditionContext C/*J*/= new CheckBranchConditionContext(BranchConditionCheckers, Condition, Eng);
      CheckerManagerStatics.expandGraphWithCheckers(new CheckBranchConditionContext(C), Dst, Src);
    } finally {
      if (Src != null) { Src.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Run checkers for live symbols.
  ///
  /// Allows modifying SymbolReaper object. For example, checkers can explicitly
  /// register symbols of interest as live. These symbols will not be marked
  /// dead and removed.
  
  /// \brief Run checkers for live symbols.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForLiveSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 473,
   FQN="clang::ento::CheckerManager::runCheckersForLiveSymbols", NM="_ZN5clang4ento14CheckerManager25runCheckersForLiveSymbolsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25runCheckersForLiveSymbolsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperE")
  //</editor-fold>
  public void runCheckersForLiveSymbols(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                           final SymbolReaper /*&*/ SymReaper) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      for (/*uint*/int i = 0, e = LiveSymbolsCheckers.size(); i != e; ++i)  {
        LiveSymbolsCheckers.$at(i).$call($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), SymReaper); $c$.clean();
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Run checkers for dead symbols.
  ///
  /// Notifies checkers when symbols become dead. For example, this allows
  /// checkers to aggressively clean up/reduce the checker state and produce
  /// precise diagnostics.
  
  /// \brief Run checkers for dead symbols.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 511,
   FQN="clang::ento::CheckerManager::runCheckersForDeadSymbols", NM="_ZN5clang4ento14CheckerManager25runCheckersForDeadSymbolsERNS0_15ExplodedNodeSetERKS2_RNS0_12SymbolReaperEPKNS_4StmtERNS0_10ExprEngineENS_12ProgramPoint4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25runCheckersForDeadSymbolsERNS0_15ExplodedNodeSetERKS2_RNS0_12SymbolReaperEPKNS_4StmtERNS0_10ExprEngineENS_12ProgramPoint4KindE")
  //</editor-fold>
  public void runCheckersForDeadSymbols(final ExplodedNodeSet /*&*/ Dst, 
                           final /*const*/ ExplodedNodeSet /*&*/ Src, 
                           final SymbolReaper /*&*/ SymReaper, 
                           /*const*/ Stmt /*P*/ S, 
                           final ExprEngine /*&*/ Eng, 
                           ProgramPoint.Kind K) {
    CheckDeadSymbolsContext C/*J*/= new CheckDeadSymbolsContext(DeadSymbolsCheckers, SymReaper, S, Eng, K);
    CheckerManagerStatics.expandGraphWithCheckers(new CheckDeadSymbolsContext(C), Dst, Src);
  }

  
  /// \brief True if at least one checker wants to check region changes.
  
  /// \brief True if at least one checker wants to check region changes.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 522,
   FQN="clang::ento::CheckerManager::wantsRegionChangeUpdate", NM="_ZN5clang4ento14CheckerManager23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager23wantsRegionChangeUpdateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public boolean wantsRegionChangeUpdate(IntrusiveRefCntPtr</*const*/ ProgramState> state) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      for (/*uint*/int i = 0, e = RegionChangesCheckers.size(); i != e; ++i)  {
        if ($c$.clean(RegionChangesCheckers.$at(i).WantUpdateFn.$call($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))))) {
          return true;
        }
      }
      
      return false;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Run checkers for region changes.
  ///
  /// This corresponds to the check::RegionChanges callback.
  /// \param state The current program state.
  /// \param invalidated A set of all symbols potentially touched by the change.
  /// \param ExplicitRegions The regions explicitly requested for invalidation.
  ///   For example, in the case of a function call, these would be arguments.
  /// \param Regions The transitive closure of accessible regions,
  ///   i.e. all regions that may have been touched by this change.
  /// \param Call The call expression wrapper if the regions are invalidated
  ///   by a call.
  
  /// \brief Run checkers for region changes.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForRegionChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 531,
   FQN="clang::ento::CheckerManager::runCheckersForRegionChanges", NM="_ZN5clang4ento14CheckerManager27runCheckersForRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager27runCheckersForRegionChangesEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEENS2_8ArrayRefIPKNS0_9MemRegionEEESK_PKNS0_9CallEventE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> runCheckersForRegionChanges(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                             /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ invalidated, 
                             ArrayRef</*const*/ MemRegion /*P*/ > ExplicitRegions, 
                             ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                             /*const*/ CallEvent /*P*/ Call) {
    for (/*uint*/int i = 0, e = RegionChangesCheckers.size(); i != e; ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If any checker declares the state infeasible (or if it starts that way),
        // bail out.
        if (!state.$bool()) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        }
        $c$.clean(state.$assign($c$.track(RegionChangesCheckers.$at(i).CheckFn.$call($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), invalidated, 
                /*NO_COPY*/ExplicitRegions, /*NO_COPY*/Regions, Call
            ))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
  }

  
  /// \brief Run checkers when pointers escape.
  ///
  /// This notifies the checkers about pointer escape, which occurs whenever
  /// the analyzer cannot track the symbol any more. For example, as a
  /// result of assigning a pointer into a global or when it's passed to a 
  /// function call the analyzer cannot model.
  /// 
  /// \param State The state at the point of escape.
  /// \param Escaped The list of escaped symbols.
  /// \param Call The corresponding CallEvent, if the symbols escape as 
  ///        parameters to the given call.
  /// \param Kind The reason of pointer escape.
  /// \param ITraits Information about invalidation for a particular 
  ///        region/symbol.
  /// \returns Checkers can modify the state by returning a new one.
  
  /// \brief Run checkers to process symbol escape event.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 549,
   FQN="clang::ento::CheckerManager::runCheckersForPointerEscape", NM="_ZN5clang4ento14CheckerManager27runCheckersForPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager27runCheckersForPointerEscapeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISA_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> runCheckersForPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                             final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                             /*const*/ CallEvent /*P*/ Call, 
                             PointerEscapeKind Kind, 
                             RegionAndSymbolInvalidationTraits /*P*/ ETraits) {
    assert ((Call != null || (Kind != PointerEscapeKind.PSK_DirectEscapeOnCall && Kind != PointerEscapeKind.PSK_IndirectEscapeOnCall))) : "Call must not be NULL when escaping on call";
    for (/*uint*/int i = 0, e = PointerEscapeCheckers.size(); i != e; ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If any checker declares the state infeasible (or if it starts that
        //  way), bail out.
        if (!State.$bool()) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        }
        $c$.clean(State.$assign($c$.track(PointerEscapeCheckers.$at(i).$call($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Escaped, Call, /*KEEP_ENUM*/Kind, ETraits))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  
  /// \brief Run checkers for handling assumptions on symbolic values.
  
  /// \brief Run checkers for handling assumptions on symbolic values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForEvalAssume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 570,
   FQN="clang::ento::CheckerManager::runCheckersForEvalAssume", NM="_ZN5clang4ento14CheckerManager24runCheckersForEvalAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager24runCheckersForEvalAssumeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEENS0_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> runCheckersForEvalAssume(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                          SVal Cond, boolean Assumption) {
    for (/*uint*/int i = 0, e = EvalAssumeCheckers.size(); i != e; ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If any checker declares the state infeasible (or if it starts that way),
        // bail out.
        if (!state.$bool()) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
        }
        $c$.clean(state.$assign($c$.track(EvalAssumeCheckers.$at(i).$call($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), Cond, /*KEEP_BOOL*/Assumption))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, state);
  }

  
  /// \brief Run checkers for evaluating a call.
  ///
  /// Warning: Currently, the CallEvent MUST come from a CallExpr!
  
  /// \brief Run checkers for evaluating a call.
  /// Only one checker will evaluate the call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForEvalCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 585,
   FQN="clang::ento::CheckerManager::runCheckersForEvalCall", NM="_ZN5clang4ento14CheckerManager22runCheckersForEvalCallERNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager22runCheckersForEvalCallERNS0_15ExplodedNodeSetERKS2_RKNS0_9CallEventERNS0_10ExprEngineE")
  //</editor-fold>
  public void runCheckersForEvalCall(final ExplodedNodeSet /*&*/ Dst, 
                        final /*const*/ ExplodedNodeSet /*&*/ Src, 
                        final /*const*/ CallEvent /*&*/ Call, 
                        final ExprEngine /*&*/ Eng) {
    /*const*/ CallExpr /*P*/ CE = cast_CallExpr(Call.getOriginExpr());
    for (SmallPtrSetIterator<ExplodedNode /*P*/ > NI = Src.begin$Const(), NE = Src.end$Const(); NI.$noteq(NE); NI.$preInc()) {
      ExplodedNodeSet checkDst = null;
      NodeBuilder B = null;
      try {
        ExplodedNode /*P*/ Pred = NI.$star();
        boolean anyEvaluated = false;
        
        checkDst/*J*/= new ExplodedNodeSet();
        B/*J*/= new NodeBuilder(Pred, checkDst, Eng.getBuilderContext());
        
        // Check if any of the EvalCall callbacks can evaluate the call.
        for (std.vector.iterator<Check$EvalCallFunc/*P*/> EI = EvalCallCheckers.begin(), EE = EvalCallCheckers.end();
             $noteq___normal_iterator$C(EI, EE); EI.$preInc()) {
          ProgramPoint.Kind K = ProgramPoint.Kind.PostStmtKind;
          final /*const*/ ProgramPoint /*&*/ L = ProgramPoint.getProgramPoint(CE, K, 
              Pred.getLocationContext(), EI.$arrow().getChecker());
          boolean evaluated = false;
          { // CheckerContext generates transitions(populates checkDest) on
// destruction, so introduce the scope to make sure it gets properly
// populated.
            CheckerContext C/*J*/= new CheckerContext(B, Eng, Pred, L);
            evaluated = (EI.$star()).$call(CE, C);
          }
          assert (!(evaluated && anyEvaluated)) : "There are more than one checkers evaluating the call";
          if (evaluated) {
            anyEvaluated = true;
            Dst.insert(checkDst);
          }
        }
        
        // If none of the checkers evaluated the call, ask ExprEngine to handle it.
        if (!anyEvaluated) {
          NodeBuilder B$1 = null;
          try {
            B$1/*J*/= new NodeBuilder(Pred, Dst, Eng.getBuilderContext());
            Eng.defaultEvalCall(B$1, Pred, Call);
          } finally {
            if (B$1 != null) { B$1.$destroy(); }
          }
        }
      } finally {
        if (B != null) { B.$destroy(); }
        if (checkDst != null) { checkDst.$destroy(); }
      }
    }
  }

  
  /// \brief Run checkers for the entire Translation Unit.
  
  /// \brief Run checkers for the entire Translation Unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersOnEndOfTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 632,
   FQN="clang::ento::CheckerManager::runCheckersOnEndOfTranslationUnit", NM="_ZN5clang4ento14CheckerManager33runCheckersOnEndOfTranslationUnitEPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager33runCheckersOnEndOfTranslationUnitEPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterE")
  //</editor-fold>
  public void runCheckersOnEndOfTranslationUnit(/*const*/ TranslationUnitDecl /*P*/ TU, 
                                   final AnalysisManager /*&*/ mgr, 
                                   final BugReporter /*&*/ BR) {
    for (/*uint*/int i = 0, e = EndOfTranslationUnitCheckers.size(); i != e; ++i)  {
      EndOfTranslationUnitCheckers.$at(i).$call(TU, mgr, BR);
    }
  }

  
  /// \brief Run checkers for debug-printing a ProgramState.
  ///
  /// Unlike most other callbacks, any checker can simply implement the virtual
  /// method CheckerBase::printState if it has custom data to print.
  /// \param Out The output stream
  /// \param State The state being printed
  /// \param NL The preferred representation of a newline.
  /// \param Sep The preferred separator between different kinds of data.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::runCheckersForPrintState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 640,
   FQN="clang::ento::CheckerManager::runCheckersForPrintState", NM="_ZN5clang4ento14CheckerManager24runCheckersForPrintStateERN4llvm11raw_ostreamENS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKcSA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager24runCheckersForPrintStateERN4llvm11raw_ostreamENS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKcSA_")
  //</editor-fold>
  public void runCheckersForPrintState(final raw_ostream /*&*/ Out, 
                          IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                          /*const*/char$ptr/*char P*/ NL, /*const*/char$ptr/*char P*/ Sep) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      for (DenseMapIterator</*const*/Object/*void P*/ , CheckerBase /*P*/ > I = CheckerTags.begin(), E = CheckerTags.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
        I.$arrow().second.printState(Out, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), NL, Sep); $c$.clean();
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Internal registration functions for AST traversing.
  //===----------------------------------------------------------------------===//
  
  // Functions used by the registration mechanism, checkers should not touch
  // these directly.
  // JAVA: typedef CheckerFn<void (const Decl *, AnalysisManager &, BugReporter &)> CheckDeclFunc
//  public final class CheckDeclFunc extends Check$CheckDeclFunc{ };
  
  // JAVA: typedef bool (*HandlesDeclFunc)(const Decl *);
  
  //===----------------------------------------------------------------------===//
  // Internal registration functions for AST traversing.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 652,
   FQN="clang::ento::CheckerManager::_registerForDecl", NM="_ZN5clang4ento14CheckerManager16_registerForDeclENS0_9CheckerFnIFvPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterEEEEPFbS5_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager16_registerForDeclENS0_9CheckerFnIFvPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterEEEEPFbS5_E")
  //</editor-fold>
  public void _registerForDecl(Check$CheckDeclFunc checkfn, 
                  Decl2Bool isForDeclFn) {
    DeclCheckerInfo info = new DeclCheckerInfo(checkfn, isForDeclFn);
    DeclCheckers.push_back_T$C$R(info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 658,
   FQN="clang::ento::CheckerManager::_registerForBody", NM="_ZN5clang4ento14CheckerManager16_registerForBodyENS0_9CheckerFnIFvPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager16_registerForBodyENS0_9CheckerFnIFvPKNS_4DeclERNS0_15AnalysisManagerERNS0_11BugReporterEEEE")
  //</editor-fold>
  public void _registerForBody(Check$CheckDeclFunc checkfn) {
    BodyCheckers.push_back_T$C$R(checkfn);
  }

  
  //===----------------------------------------------------------------------===//
  // Internal registration functions for path-sensitive checking.
  //===----------------------------------------------------------------------===//
  // JAVA: typedef CheckerFn<void (const Stmt *, CheckerContext &)> CheckStmtFunc
//  public final class CheckStmtFunc extends Check$CheckBranchConditionFunc{ };
  
  // JAVA: typedef CheckerFn<void (const ObjCMethodCall &, CheckerContext &)> CheckObjCMessageFunc
//  public final class CheckObjCMessageFunc extends Check$CheckObjCMessageFunc{ };
  
  // JAVA: typedef CheckerFn<void (const CallEvent &, CheckerContext &)> CheckCallFunc
//  public final class CheckCallFunc extends Check$CheckCallFunc{ };
  
  // JAVA: typedef CheckerFn<void (const SVal &, bool, const Stmt *, CheckerContext &)> CheckLocationFunc
//  public final class CheckLocationFunc extends Check$CheckLocationFunc{ };
  
  // JAVA: typedef CheckerFn<void (const SVal &, const SVal &, const Stmt *, CheckerContext &)> CheckBindFunc
//  public final class CheckBindFunc extends Check$CheckBindFunc{ };
  
  // JAVA: typedef CheckerFn<void (ExplodedGraph &, BugReporter &, ExprEngine &)> CheckEndAnalysisFunc
//  public final class CheckEndAnalysisFunc extends Check$CheckEndAnalysisFunc{ };
  
  // JAVA: typedef CheckerFn<void (CheckerContext &)> CheckBeginFunctionFunc
//  public final class CheckBeginFunctionFunc extends Check$CheckBeginEndFunctionFunc{ };
  
  // JAVA: typedef CheckerFn<void (CheckerContext &)> CheckEndFunctionFunc
//  public final class CheckEndFunctionFunc extends Check$CheckBeginEndFunctionFunc{ };
  
  // JAVA: typedef CheckerFn<void (const Stmt *, CheckerContext &)> CheckBranchConditionFunc
//  public final class CheckBranchConditionFunc extends Check$CheckBranchConditionFunc{ };
  
  // JAVA: typedef CheckerFn<void (SymbolReaper &, CheckerContext &)> CheckDeadSymbolsFunc
//  public final class CheckDeadSymbolsFunc extends Check$CheckDeadSymbolsFunc{ };
  
  // JAVA: typedef CheckerFn<void (ProgramStateRef, SymbolReaper &)> CheckLiveSymbolsFunc
//  public final class CheckLiveSymbolsFunc extends Check$CheckLiveSymbolsFunc{ };
  
  // JAVA: typedef CheckerFn<ProgramStateRef (ProgramStateRef, const InvalidatedSymbols *, ArrayRef<const MemRegion *>, ArrayRef<const MemRegion *>, const CallEvent *)> CheckRegionChangesFunc
//  public final class CheckRegionChangesFunc extends CheckerFnT1ToT<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>, /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/, ArrayRef</*const*/ MemRegion /*P*/ >, ArrayRef</*const*/ MemRegion /*P*/ >, /*const*/ CallEvent /*P*/ >{ };
  
  // JAVA: typedef CheckerFn<bool (ProgramStateRef)> WantsRegionChangeUpdateFunc
//  public final class WantsRegionChangeUpdateFunc extends Check$WantsRegionChangeUpdateFunc{ };
  
  // JAVA: typedef CheckerFn<ProgramStateRef (ProgramStateRef, const InvalidatedSymbols &, const CallEvent *, PointerEscapeKind, RegionAndSymbolInvalidationTraits *)> CheckPointerEscapeFunc
//  public final class CheckPointerEscapeFunc extends CheckerFnT1ToT<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>, /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/, /*const*/ CallEvent /*P*/ , PointerEscapeKind, RegionAndSymbolInvalidationTraits /*P*/ >{ };
  
  // JAVA: typedef CheckerFn<ProgramStateRef (ProgramStateRef, const SVal &, bool)> EvalAssumeFunc
//  public final class EvalAssumeFunc extends Check$EvalAssumeFunc{ };
  
  // JAVA: typedef CheckerFn<bool (const CallExpr *, CheckerContext &)> EvalCallFunc
//  public final class EvalCallFunc extends Check$EvalCallFunc{ };
  
  // JAVA: typedef CheckerFn<void (const TranslationUnitDecl *, AnalysisManager &, BugReporter &)> CheckEndOfTranslationUnit
//  public final class CheckEndOfTranslationUnit extends Check$CheckEndOfTranslationUnit{ };
  
  // JAVA: typedef bool (*HandlesStmtFunc)(const Stmt *);
  
  //===----------------------------------------------------------------------===//
  // Internal registration functions for path-sensitive checking.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 666,
   FQN="clang::ento::CheckerManager::_registerForPreStmt", NM="_ZN5clang4ento14CheckerManager19_registerForPreStmtENS0_9CheckerFnIFvPKNS_4StmtERNS0_14CheckerContextEEEEPFbS5_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager19_registerForPreStmtENS0_9CheckerFnIFvPKNS_4StmtERNS0_14CheckerContextEEEEPFbS5_E")
  //</editor-fold>
  public void _registerForPreStmt(Check$CheckStmtFunc checkfn, 
                     Stmt2Bool isForStmtFn) {
    StmtCheckerInfo info = new StmtCheckerInfo(checkfn, isForStmtFn, /*IsPreVisit*/ true);
    StmtCheckers.push_back_T$C$R(info);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 671,
   FQN="clang::ento::CheckerManager::_registerForPostStmt", NM="_ZN5clang4ento14CheckerManager20_registerForPostStmtENS0_9CheckerFnIFvPKNS_4StmtERNS0_14CheckerContextEEEEPFbS5_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager20_registerForPostStmtENS0_9CheckerFnIFvPKNS_4StmtERNS0_14CheckerContextEEEEPFbS5_E")
  //</editor-fold>
  public void _registerForPostStmt(Check$CheckStmtFunc checkfn, 
                      Stmt2Bool isForStmtFn) {
    StmtCheckerInfo info = new StmtCheckerInfo(checkfn, isForStmtFn, /*IsPreVisit*/ false);
    StmtCheckers.push_back_T$C$R(info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 677,
   FQN="clang::ento::CheckerManager::_registerForPreObjCMessage", NM="_ZN5clang4ento14CheckerManager26_registerForPreObjCMessageENS0_9CheckerFnIFvRKNS0_14ObjCMethodCallERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager26_registerForPreObjCMessageENS0_9CheckerFnIFvRKNS0_14ObjCMethodCallERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForPreObjCMessage(Check$CheckObjCMessageFunc checkfn) {
    PreObjCMessageCheckers.push_back_T$C$R(checkfn);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 685,
   FQN="clang::ento::CheckerManager::_registerForPostObjCMessage", NM="_ZN5clang4ento14CheckerManager27_registerForPostObjCMessageENS0_9CheckerFnIFvRKNS0_14ObjCMethodCallERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager27_registerForPostObjCMessageENS0_9CheckerFnIFvRKNS0_14ObjCMethodCallERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForPostObjCMessage(Check$CheckObjCMessageFunc checkfn) {
    PostObjCMessageCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForObjCMessageNil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 681,
   FQN="clang::ento::CheckerManager::_registerForObjCMessageNil", NM="_ZN5clang4ento14CheckerManager26_registerForObjCMessageNilENS0_9CheckerFnIFvRKNS0_14ObjCMethodCallERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager26_registerForObjCMessageNilENS0_9CheckerFnIFvRKNS0_14ObjCMethodCallERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForObjCMessageNil(Check$CheckObjCMessageFunc checkfn) {
    ObjCMessageNilCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 689,
   FQN="clang::ento::CheckerManager::_registerForPreCall", NM="_ZN5clang4ento14CheckerManager19_registerForPreCallENS0_9CheckerFnIFvRKNS0_9CallEventERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager19_registerForPreCallENS0_9CheckerFnIFvRKNS0_9CallEventERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForPreCall(Check$CheckCallFunc checkfn) {
    PreCallCheckers.push_back_T$C$R(checkfn);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 692,
   FQN="clang::ento::CheckerManager::_registerForPostCall", NM="_ZN5clang4ento14CheckerManager20_registerForPostCallENS0_9CheckerFnIFvRKNS0_9CallEventERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager20_registerForPostCallENS0_9CheckerFnIFvRKNS0_9CallEventERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForPostCall(Check$CheckCallFunc checkfn) {
    PostCallCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 696,
   FQN="clang::ento::CheckerManager::_registerForLocation", NM="_ZN5clang4ento14CheckerManager20_registerForLocationENS0_9CheckerFnIFvRKNS0_4SValEbPKNS_4StmtERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager20_registerForLocationENS0_9CheckerFnIFvRKNS0_4SValEbPKNS_4StmtERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForLocation(Check$CheckLocationFunc checkfn) {
    LocationCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForBind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 700,
   FQN="clang::ento::CheckerManager::_registerForBind", NM="_ZN5clang4ento14CheckerManager16_registerForBindENS0_9CheckerFnIFvRKNS0_4SValES5_PKNS_4StmtERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager16_registerForBindENS0_9CheckerFnIFvRKNS0_4SValES5_PKNS_4StmtERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForBind(Check$CheckBindFunc checkfn) {
    BindCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForEndAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 704,
   FQN="clang::ento::CheckerManager::_registerForEndAnalysis", NM="_ZN5clang4ento14CheckerManager23_registerForEndAnalysisENS0_9CheckerFnIFvRNS0_13ExplodedGraphERNS0_11BugReporterERNS0_10ExprEngineEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager23_registerForEndAnalysisENS0_9CheckerFnIFvRNS0_13ExplodedGraphERNS0_11BugReporterERNS0_10ExprEngineEEEE")
  //</editor-fold>
  public void _registerForEndAnalysis(Check$CheckEndAnalysisFunc checkfn) {
    EndAnalysisCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForBeginFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 708,
   FQN="clang::ento::CheckerManager::_registerForBeginFunction", NM="_ZN5clang4ento14CheckerManager25_registerForBeginFunctionENS0_9CheckerFnIFvRNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25_registerForBeginFunctionENS0_9CheckerFnIFvRNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForBeginFunction(Check$CheckBeginFunctionFunc checkfn) {
    BeginFunctionCheckers.push_back_T$C$R(checkfn);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForEndFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 712,
   FQN="clang::ento::CheckerManager::_registerForEndFunction", NM="_ZN5clang4ento14CheckerManager23_registerForEndFunctionENS0_9CheckerFnIFvRNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager23_registerForEndFunctionENS0_9CheckerFnIFvRNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForEndFunction(Check$CheckEndFunctionFunc checkfn) {
    EndFunctionCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForBranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 716,
   FQN="clang::ento::CheckerManager::_registerForBranchCondition", NM="_ZN5clang4ento14CheckerManager27_registerForBranchConditionENS0_9CheckerFnIFvPKNS_4StmtERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager27_registerForBranchConditionENS0_9CheckerFnIFvPKNS_4StmtERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForBranchCondition(Check$CheckBranchConditionFunc checkfn) {
    BranchConditionCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForLiveSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 721,
   FQN="clang::ento::CheckerManager::_registerForLiveSymbols", NM="_ZN5clang4ento14CheckerManager23_registerForLiveSymbolsENS0_9CheckerFnIFvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager23_registerForLiveSymbolsENS0_9CheckerFnIFvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERNS0_12SymbolReaperEEEE")
  //</editor-fold>
  public void _registerForLiveSymbols(Check$CheckLiveSymbolsFunc checkfn) {
    LiveSymbolsCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 725,
   FQN="clang::ento::CheckerManager::_registerForDeadSymbols", NM="_ZN5clang4ento14CheckerManager23_registerForDeadSymbolsENS0_9CheckerFnIFvRNS0_12SymbolReaperERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager23_registerForDeadSymbolsENS0_9CheckerFnIFvRNS0_12SymbolReaperERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForDeadSymbols(Check$CheckDeadSymbolsFunc checkfn) {
    DeadSymbolsCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForRegionChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 729,
   FQN="clang::ento::CheckerManager::_registerForRegionChanges", NM="_ZN5clang4ento14CheckerManager25_registerForRegionChangesENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_PKNS3_8DenseSetIPKNS0_7SymExprENS3_12DenseMapInfoISB_EEEENS3_8ArrayRefIPKNS0_9MemRegionEEESL_PKNS0_9CallEventEEEENS2_IFbS7_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25_registerForRegionChangesENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_PKNS3_8DenseSetIPKNS0_7SymExprENS3_12DenseMapInfoISB_EEEENS3_8ArrayRefIPKNS0_9MemRegionEEESL_PKNS0_9CallEventEEEENS2_IFbS7_EEE")
  //</editor-fold>
  public void _registerForRegionChanges(Check$CheckRegionChangesFunc checkfn, 
                           Check$WantsRegionChangeUpdateFunc wantUpdateFn) {
    RegionChangesCheckerInfo info = new RegionChangesCheckerInfo(checkfn, wantUpdateFn);
    RegionChangesCheckers.push_back_T$C$R(info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 735,
   FQN="clang::ento::CheckerManager::_registerForPointerEscape", NM="_ZN5clang4ento14CheckerManager25_registerForPointerEscapeENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_RKNS3_8DenseSetIPKNS0_7SymExprENS3_12DenseMapInfoISB_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindEPNS0_33RegionAndSymbolInvalidationTraitsEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager25_registerForPointerEscapeENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_RKNS3_8DenseSetIPKNS0_7SymExprENS3_12DenseMapInfoISB_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindEPNS0_33RegionAndSymbolInvalidationTraitsEEEE")
  //</editor-fold>
  public void _registerForPointerEscape(Check$CheckPointerEscapeFunc checkfn) {
    PointerEscapeCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForConstPointerEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 739,
   FQN="clang::ento::CheckerManager::_registerForConstPointerEscape", NM="_ZN5clang4ento14CheckerManager30_registerForConstPointerEscapeENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_RKNS3_8DenseSetIPKNS0_7SymExprENS3_12DenseMapInfoISB_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindEPNS0_33RegionAndSymbolInvalidationTraitsEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager30_registerForConstPointerEscapeENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_RKNS3_8DenseSetIPKNS0_7SymExprENS3_12DenseMapInfoISB_EEEEPKNS0_9CallEventENS0_17PointerEscapeKindEPNS0_33RegionAndSymbolInvalidationTraitsEEEE")
  //</editor-fold>
  public void _registerForConstPointerEscape(Check$CheckPointerEscapeFunc checkfn) {
    PointerEscapeCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForEvalAssume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 744,
   FQN="clang::ento::CheckerManager::_registerForEvalAssume", NM="_ZN5clang4ento14CheckerManager22_registerForEvalAssumeENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_RKNS0_4SValEbEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager22_registerForEvalAssumeENS0_9CheckerFnIFN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEES7_RKNS0_4SValEbEEE")
  //</editor-fold>
  public void _registerForEvalAssume(Check$EvalAssumeFunc checkfn) {
    EvalAssumeCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForEvalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 748,
   FQN="clang::ento::CheckerManager::_registerForEvalCall", NM="_ZN5clang4ento14CheckerManager20_registerForEvalCallENS0_9CheckerFnIFbPKNS_8CallExprERNS0_14CheckerContextEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager20_registerForEvalCallENS0_9CheckerFnIFbPKNS_8CallExprERNS0_14CheckerContextEEEE")
  //</editor-fold>
  public void _registerForEvalCall(Check$EvalCallFunc checkfn) {
    EvalCallCheckers.push_back_T$C$R(checkfn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerForEndOfTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 752,
   FQN="clang::ento::CheckerManager::_registerForEndOfTranslationUnit", NM="_ZN5clang4ento14CheckerManager32_registerForEndOfTranslationUnitENS0_9CheckerFnIFvPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager32_registerForEndOfTranslationUnitENS0_9CheckerFnIFvPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterEEEE")
  //</editor-fold>
  public void _registerForEndOfTranslationUnit(Check$CheckEndOfTranslationUnit checkfn) {
    EndOfTranslationUnitCheckers.push_back_T$C$R(checkfn);
  }

  
  //===----------------------------------------------------------------------===//
  // Internal registration functions for events.
  //===----------------------------------------------------------------------===//
  // JAVA: typedef void *EventTag;
  // JAVA: typedef CheckerFn<void (const void *)> CheckEventFunc
//  public final class CheckEventFunc extends Check$CheckEventFunc{ };
  
  /*template <typename EVENT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerListenerForEvent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 525,
   FQN="clang::ento::CheckerManager::_registerListenerForEvent", NM="Tpl__ZN5clang4ento14CheckerManager25_registerListenerForEventENS0_9CheckerFnIFvPKvEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZN5clang4ento14CheckerManager25_registerListenerForEventENS0_9CheckerFnIFvPKvEEE")
  //</editor-fold>
  public </*typename*/ EVENT> void _registerListenerForEvent(Class<EVENT> clazz, Check$CheckEventFunc checkfn) {
    final EventInfo /*&*/ info = Events.$at(getTag(clazz));
    info.Checkers.push_back(checkfn);
  }

  
  /*template <typename EVENT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_registerDispatcherForEvent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 531,
   FQN="clang::ento::CheckerManager::_registerDispatcherForEvent", NM="Tpl__ZN5clang4ento14CheckerManager27_registerDispatcherForEventEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZN5clang4ento14CheckerManager27_registerDispatcherForEventEv")
  //</editor-fold>
  public </*typename*/ EVENT> void _registerDispatcherForEvent(Class<EVENT> clazz) {
    final EventInfo /*&*/ info = Events.$at(getTag(clazz));
    info.HasDispatcher = true;
  }

  
  /*template <typename EVENT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::_dispatchEvent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 537,
   FQN="clang::ento::CheckerManager::_dispatchEvent", NM="Tpl__ZNK5clang4ento14CheckerManager14_dispatchEventERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZNK5clang4ento14CheckerManager14_dispatchEventERKT_")
  //</editor-fold>
  public </*typename*/ EVENT> void _dispatchEvent(Class<EVENT> clazz, final /*const*/ EVENT /*&*/ event) /*const*/ {
    DenseMapIterator<Object/*void P*/ , EventInfo> I = Events.find(getTag(clazz));
    if (I.$eq(Events.end$Const())) {
      return;
    }
    final /*const*/ EventInfo /*&*/ info = I.$arrow().second;
    for (/*uint*/int i = 0, e = info.Checkers.size(); i != e; ++i)  {
      info.Checkers.$at$Const(i).$call(Native.$addr(event));
    }
  }


  //===----------------------------------------------------------------------===//
  // Implementation details.
  //===----------------------------------------------------------------------===//
  /*private:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::destruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 552,
   FQN="clang::ento::CheckerManager::destruct", NM="Tpl__ZN5clang4ento14CheckerManager8destructEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZN5clang4ento14CheckerManager8destructEPv")
  //</editor-fold>
  private static </*typename*/ CHECKER> void destruct(Object/*void P*/ obj) {
    /*delete*/Destructors.$destroy(((/*static_cast*/CHECKER /*P*/ )(obj)));
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 555,
   FQN="clang::ento::CheckerManager::getTag", NM="Tpl__ZN5clang4ento14CheckerManager6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=Tpl__ZN5clang4ento14CheckerManager6getTagEv")
  //</editor-fold>
  private static </*typename*/ T> Object/*void P*/ getTag(Class<T> clazz) {
    if (false) {
      final/*static*/ Object tag = getTag$$.tag;
    }
    // JAVA: clazz itself is good unique 'tag'
    return $AddrOf(clazz);
  }
  private static final class getTag$$ {
    static {
      if (true) throw new IllegalStateException("Each specialization must have own tag (we use class itself");
    }
    static final/*static*/ Object tag;
  }

  
  private DenseMap</*const*/Object/*void P*/, CheckerBase /*P*/ > CheckerTags;
  
  private std.vector<Check$CheckerDtor> CheckerDtors;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::DeclCheckerInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 561,
   FQN="clang::ento::CheckerManager::DeclCheckerInfo", NM="_ZN5clang4ento14CheckerManager15DeclCheckerInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager15DeclCheckerInfoE")
  //</editor-fold>
  private static class/*struct*/ DeclCheckerInfo implements NativeCloneable<DeclCheckerInfo> {
    public Check$CheckDeclFunc CheckFn;
    public Decl2Bool IsForDeclFn;
    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::DeclCheckerInfo::DeclCheckerInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 561,
     FQN="clang::ento::CheckerManager::DeclCheckerInfo::DeclCheckerInfo", NM="_ZN5clang4ento14CheckerManager15DeclCheckerInfoC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager15DeclCheckerInfoC1ERKS2_")
    //</editor-fold>
    public /*inline*/ DeclCheckerInfo(final /*const*/ DeclCheckerInfo /*&*/ $Prm0) {
      // : CheckFn(.CheckFn), IsForDeclFn(.IsForDeclFn) 
      //START JInit
      this.CheckFn = /*new Check$CheckDeclFunc*/($Prm0.CheckFn);
      this.IsForDeclFn = $tryClone($Prm0.IsForDeclFn);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::DeclCheckerInfo::DeclCheckerInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 561,
     FQN="clang::ento::CheckerManager::DeclCheckerInfo::DeclCheckerInfo", NM="_ZN5clang4ento14CheckerManager15DeclCheckerInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager15DeclCheckerInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ DeclCheckerInfo(JD$Move _dparam, final DeclCheckerInfo /*&&*/$Prm0) {
      // : CheckFn(static_cast<DeclCheckerInfo &&>().CheckFn), IsForDeclFn(static_cast<DeclCheckerInfo &&>().IsForDeclFn) 
      //START JInit
      this.CheckFn = /*new Check$CheckDeclFunc(JD$Move.INSTANCE, */($Prm0.CheckFn);
      this.IsForDeclFn = $tryClone($Prm0.IsForDeclFn);
      //END JInit
    }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public DeclCheckerInfo(Check$CheckDeclFunc CheckFn, Decl2Bool IsForDeclFn) { this.CheckFn = CheckFn; this.IsForDeclFn = IsForDeclFn; }
  
  public DeclCheckerInfo() { }

  @Override public DeclCheckerInfo clone() { return new DeclCheckerInfo(this.CheckFn, this.IsForDeclFn); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
      return "" + "CheckFn=" + CheckFn // NOI18N
                + ", IsForDeclFn=" + IsForDeclFn; // NOI18N
    }
  };
  private std.vector<DeclCheckerInfo> DeclCheckers;
  
  private std.vector<Check$CheckDeclFunc> BodyCheckers;
  
  // JAVA: typedef SmallVector<CheckDeclFunc, 4> CachedDeclCheckers
//  public final class CachedDeclCheckers extends SmallVector<Check$CheckDeclFunc>{ };
  // JAVA: typedef llvm::DenseMap<unsigned int, CachedDeclCheckers> CachedDeclCheckersMapTy
//  public final class CachedDeclCheckersMapTy extends DenseMapUIntType<SmallVector<Check$CheckDeclFunc>>{ };
  private DenseMapUIntType<SmallVector<Check$CheckDeclFunc>> CachedDeclCheckersMap;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::StmtCheckerInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 573,
   FQN="clang::ento::CheckerManager::StmtCheckerInfo", NM="_ZN5clang4ento14CheckerManager15StmtCheckerInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager15StmtCheckerInfoE")
  //</editor-fold>
  private static class/*struct*/ StmtCheckerInfo implements NativeCloneable<StmtCheckerInfo> {
    public Check$CheckStmtFunc CheckFn;
    public Stmt2Bool IsForStmtFn;
    public boolean IsPreVisit;
    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::StmtCheckerInfo::StmtCheckerInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 573,
     FQN="clang::ento::CheckerManager::StmtCheckerInfo::StmtCheckerInfo", NM="_ZN5clang4ento14CheckerManager15StmtCheckerInfoC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager15StmtCheckerInfoC1ERKS2_")
    //</editor-fold>
    public /*inline*/ StmtCheckerInfo(final /*const*/ StmtCheckerInfo /*&*/ $Prm0) {
      // : CheckFn(.CheckFn), IsForStmtFn(.IsForStmtFn), IsPreVisit(.IsPreVisit) 
      //START JInit
      this.CheckFn = /*new Check$CheckStmtFunc*/($Prm0.CheckFn);
      this.IsForStmtFn = $tryClone($Prm0.IsForStmtFn);
      this.IsPreVisit = $Prm0.IsPreVisit;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::StmtCheckerInfo::StmtCheckerInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 573,
     FQN="clang::ento::CheckerManager::StmtCheckerInfo::StmtCheckerInfo", NM="_ZN5clang4ento14CheckerManager15StmtCheckerInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager15StmtCheckerInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ StmtCheckerInfo(JD$Move _dparam, final StmtCheckerInfo /*&&*/$Prm0) {
      // : CheckFn(static_cast<StmtCheckerInfo &&>().CheckFn), IsForStmtFn(static_cast<StmtCheckerInfo &&>().IsForStmtFn), IsPreVisit(static_cast<StmtCheckerInfo &&>().IsPreVisit) 
      //START JInit
      this.CheckFn = /*new Check$CheckStmtFunc(JD$Move.INSTANCE, */($Prm0.CheckFn);
      this.IsForStmtFn = $tryClone($Prm0.IsForStmtFn);
      this.IsPreVisit = $Prm0.IsPreVisit;
      //END JInit
    }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public StmtCheckerInfo(Check$CheckStmtFunc CheckFn, Stmt2Bool IsForStmtFn, boolean IsPreVisit) { this.CheckFn = CheckFn; this.IsForStmtFn = IsForStmtFn; this.IsPreVisit = IsPreVisit; }
  
  public StmtCheckerInfo() { }

  @Override public StmtCheckerInfo clone() { return new StmtCheckerInfo(this.CheckFn, this.IsForStmtFn, this.IsPreVisit); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
      return "" + "CheckFn=" + CheckFn // NOI18N
                + ", IsForStmtFn=" + IsForStmtFn // NOI18N
                + ", IsPreVisit=" + IsPreVisit; // NOI18N
    }
  };
  private std.vector<StmtCheckerInfo> StmtCheckers;
  
  // JAVA: typedef SmallVector<CheckStmtFunc, 4> CachedStmtCheckers
//  public final class CachedStmtCheckers extends SmallVector<Check$CheckStmtFunc>{ };
  // JAVA: typedef llvm::DenseMap<unsigned int, CachedStmtCheckers> CachedStmtCheckersMapTy
//  public final class CachedStmtCheckersMapTy extends DenseMapUIntType<SmallVector<Check$CheckStmtFunc>>{ };
  private DenseMapUIntType<SmallVector<Check$CheckStmtFunc>> CachedStmtCheckersMap;
  
  
  //===----------------------------------------------------------------------===//
  // Implementation details.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::getCachedStmtCheckersFor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 761,
   FQN="clang::ento::CheckerManager::getCachedStmtCheckersFor", NM="_ZN5clang4ento14CheckerManager24getCachedStmtCheckersForEPKNS_4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager24getCachedStmtCheckersForEPKNS_4StmtEb")
  //</editor-fold>
  private /*const*/SmallVector<Check$CheckStmtFunc> /*&*/ getCachedStmtCheckersFor(/*const*/ Stmt /*P*/ S, boolean isPreVisit) {
    assert Native.$bool(S);
    
    /*uint*/int Key = (S.getStmtClass().getValue() << 1) | ((/*uint*/int)((isPreVisit ? 1 : 0)));
    DenseMapIteratorUIntType<SmallVector<Check$CheckStmtFunc>> CCI = CachedStmtCheckersMap.find(Key);
    if (CCI.$noteq(/*NO_ITER_COPY*/CachedStmtCheckersMap.end())) {
      return CCI.$arrow().second;
    }
    
    // Find the checkers that should run for this Stmt and cache them.
    final SmallVector<Check$CheckStmtFunc> /*&*/ Checkers = CachedStmtCheckersMap.$at_T1$C$R(Key);
    for (/*uint*/int i = 0, e = StmtCheckers.size(); i != e; ++i) {
      final StmtCheckerInfo /*&*/ Info = StmtCheckers.$at(i);
      if (Info.IsPreVisit == isPreVisit && Info.IsForStmtFn.$call(S)) {
        Checkers.push_back(Info.CheckFn);
      }
    }
    return Checkers;
  }

  
  /// Returns the checkers that have registered for callbacks of the
  /// given \p Kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::getObjCMessageCheckers">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 232,
   FQN="clang::ento::CheckerManager::getObjCMessageCheckers", NM="_ZN5clang4ento14CheckerManager22getObjCMessageCheckersENS0_20ObjCMessageVisitKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager22getObjCMessageCheckersENS0_20ObjCMessageVisitKindE")
  //</editor-fold>
  private /*const*/std.vector<Check$CheckObjCMessageFunc> /*&*/ getObjCMessageCheckers(ObjCMessageVisitKind Kind) {
    switch (Kind) {
     case Pre:
      return PreObjCMessageCheckers;
      //break;
     case Post:
      return PostObjCMessageCheckers;
     case MessageNil:
      return ObjCMessageNilCheckers;
    }
    throw new llvm_unreachable("Unknown Kind");
  }

  
  private std.vector<Check$CheckObjCMessageFunc> PreObjCMessageCheckers;
  private std.vector<Check$CheckObjCMessageFunc> PostObjCMessageCheckers;
  private std.vector<Check$CheckObjCMessageFunc> ObjCMessageNilCheckers;
  
  private std.vector<Check$CheckCallFunc> PreCallCheckers;
  private std.vector<Check$CheckCallFunc> PostCallCheckers;
  
  private std.vector<Check$CheckLocationFunc> LocationCheckers;
  
  private std.vector<Check$CheckBindFunc> BindCheckers;
  
  private std.vector<Check$CheckEndAnalysisFunc> EndAnalysisCheckers;
  
  private std.vector<Check$CheckBeginFunctionFunc> BeginFunctionCheckers;
  private std.vector<Check$CheckEndFunctionFunc> EndFunctionCheckers;
  
  private std.vector<Check$CheckBranchConditionFunc> BranchConditionCheckers;
  
  private std.vector<Check$CheckLiveSymbolsFunc> LiveSymbolsCheckers;
  
  private std.vector<Check$CheckDeadSymbolsFunc> DeadSymbolsCheckers;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::RegionChangesCheckerInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 614,
   FQN="clang::ento::CheckerManager::RegionChangesCheckerInfo", NM="_ZN5clang4ento14CheckerManager24RegionChangesCheckerInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager24RegionChangesCheckerInfoE")
  //</editor-fold>
  private static class/*struct*/ RegionChangesCheckerInfo implements NativeCloneable<RegionChangesCheckerInfo> {
    public Check$CheckRegionChangesFunc CheckFn;
    public Check$WantsRegionChangeUpdateFunc WantUpdateFn;
    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::RegionChangesCheckerInfo::RegionChangesCheckerInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 614,
     FQN="clang::ento::CheckerManager::RegionChangesCheckerInfo::RegionChangesCheckerInfo", NM="_ZN5clang4ento14CheckerManager24RegionChangesCheckerInfoC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager24RegionChangesCheckerInfoC1ERKS2_")
    //</editor-fold>
    public /*inline*/ RegionChangesCheckerInfo(final /*const*/ RegionChangesCheckerInfo /*&*/ $Prm0) {
      // : CheckFn(.CheckFn), WantUpdateFn(.WantUpdateFn) 
      //START JInit
      this.CheckFn = /*new Check$CheckRegionChangesFunc*/($Prm0.CheckFn);
      this.WantUpdateFn = /*new Check$WantsRegionChangeUpdateFunc*/($Prm0.WantUpdateFn);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::RegionChangesCheckerInfo::RegionChangesCheckerInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 614,
     FQN="clang::ento::CheckerManager::RegionChangesCheckerInfo::RegionChangesCheckerInfo", NM="_ZN5clang4ento14CheckerManager24RegionChangesCheckerInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager24RegionChangesCheckerInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ RegionChangesCheckerInfo(JD$Move _dparam, final RegionChangesCheckerInfo /*&&*/$Prm0) {
      // : CheckFn(static_cast<RegionChangesCheckerInfo &&>().CheckFn), WantUpdateFn(static_cast<RegionChangesCheckerInfo &&>().WantUpdateFn) 
      //START JInit
      this.CheckFn = /*new Check$CheckRegionChangesFunc(JD$Move.INSTANCE, */($Prm0.CheckFn);
      this.WantUpdateFn = /*new Check$WantsRegionChangeUpdateFunc(JD$Move.INSTANCE, */($Prm0.WantUpdateFn);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public RegionChangesCheckerInfo(Check$CheckRegionChangesFunc CheckFn, Check$WantsRegionChangeUpdateFunc WantUpdateFn) {this.CheckFn = CheckFn; this.WantUpdateFn = WantUpdateFn; }

    public RegionChangesCheckerInfo() { }

    @Override public RegionChangesCheckerInfo clone() { return new RegionChangesCheckerInfo(this.CheckFn, this.WantUpdateFn); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "CheckFn=" + CheckFn // NOI18N
                + ", WantUpdateFn=" + WantUpdateFn; // NOI18N
    }
  };
  private std.vector<RegionChangesCheckerInfo> RegionChangesCheckers;
  
  private std.vector<Check$CheckPointerEscapeFunc> PointerEscapeCheckers;
  
  private std.vector<Check$EvalAssumeFunc> EvalAssumeCheckers;
  
  private std.vector<Check$EvalCallFunc> EvalCallCheckers;
  
  private std.vector<Check$CheckEndOfTranslationUnit> EndOfTranslationUnitCheckers;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::EventInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 628,
   FQN="clang::ento::CheckerManager::EventInfo", NM="_ZN5clang4ento14CheckerManager9EventInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager9EventInfoE")
  //</editor-fold>
  private static class/*struct*/ EventInfo implements NativeCloneable<EventInfo>, Destructors.ClassWithDestructor {
    public SmallVector<Check$CheckEventFunc> Checkers;
    public boolean HasDispatcher;
    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::EventInfo::EventInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 631,
     FQN="clang::ento::CheckerManager::EventInfo::EventInfo", NM="_ZN5clang4ento14CheckerManager9EventInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager9EventInfoC1Ev")
    //</editor-fold>
    public EventInfo() {
      // : Checkers(), HasDispatcher(false) 
      //START JInit
      this.Checkers = new SmallVector<Check$CheckEventFunc>(4, /*Check$CheckEventFunc.EMPTY*/(Check$CheckEventFunc)null);
      this.HasDispatcher = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::EventInfo::~EventInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 628,
     FQN="clang::ento::CheckerManager::EventInfo::~EventInfo", NM="_ZN5clang4ento14CheckerManager9EventInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento14CheckerManager9EventInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Checkers.$destroy();
      //END JDestroy
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerManager::EventInfo::EventInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 628,
     FQN="clang::ento::CheckerManager::EventInfo::EventInfo", NM="_ZN5clang4ento14CheckerManager9EventInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN5clang4ento14CheckerManager9EventInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ EventInfo(JD$Move _dparam, final EventInfo /*&&*/$Prm0) {
      // : Checkers(static_cast<EventInfo &&>().Checkers), HasDispatcher(static_cast<EventInfo &&>().HasDispatcher) 
      //START JInit
      this.Checkers = new SmallVector<Check$CheckEventFunc>(JD$Move.INSTANCE, $Prm0.Checkers);
      this.HasDispatcher = $Prm0.HasDispatcher;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    public /*inline*/ EventInfo(final EventInfo /*&&*/ $Prm0) {
      // : Checkers(static_cast<EventInfo &&>().Checkers), HasDispatcher(static_cast<EventInfo &&>().HasDispatcher) 
      //START JInit
      this.Checkers = new SmallVector<Check$CheckEventFunc>($Prm0.Checkers);
      this.HasDispatcher = $Prm0.HasDispatcher;
      //END JInit
    }

    @Override
    public EventInfo clone() {
      return new EventInfo(this);
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Checkers=" + Checkers // NOI18N
                + ", HasDispatcher=" + HasDispatcher; // NOI18N
    }
  };
  
  // JAVA: typedef llvm::DenseMap<EventTag, EventInfo> EventsTy
//  public final class EventsTy extends DenseMap<Object/*void P*/ , EventInfo>{ };
  private DenseMap<Object/*void P*/ , EventInfo> Events;
  
  @Override public String toString() {
    return "" + "LangOpts=" + LangOpts // NOI18N
              + ", AOptions=" + AOptions // NOI18N
              + ", CurrentCheckName=" + CurrentCheckName // NOI18N
              + ", CheckerTags=" + CheckerTags // NOI18N
              + ", CheckerDtors=" + CheckerDtors // NOI18N
              + ", DeclCheckers=" + DeclCheckers // NOI18N
              + ", BodyCheckers=" + BodyCheckers // NOI18N
              + ", CachedDeclCheckersMap=" + CachedDeclCheckersMap // NOI18N
              + ", StmtCheckers=" + StmtCheckers // NOI18N
              + ", CachedStmtCheckersMap=" + CachedStmtCheckersMap // NOI18N
              + ", PreObjCMessageCheckers=" + PreObjCMessageCheckers // NOI18N
              + ", PostObjCMessageCheckers=" + PostObjCMessageCheckers // NOI18N
              + ", ObjCMessageNilCheckers=" + ObjCMessageNilCheckers // NOI18N
              + ", PreCallCheckers=" + PreCallCheckers // NOI18N
              + ", PostCallCheckers=" + PostCallCheckers // NOI18N
              + ", LocationCheckers=" + LocationCheckers // NOI18N
              + ", BindCheckers=" + BindCheckers // NOI18N
              + ", EndAnalysisCheckers=" + EndAnalysisCheckers // NOI18N
              + ", BeginFunctionCheckers=" + BeginFunctionCheckers // NOI18N
              + ", EndFunctionCheckers=" + EndFunctionCheckers // NOI18N
              + ", BranchConditionCheckers=" + BranchConditionCheckers // NOI18N
              + ", LiveSymbolsCheckers=" + LiveSymbolsCheckers // NOI18N
              + ", DeadSymbolsCheckers=" + DeadSymbolsCheckers // NOI18N
              + ", RegionChangesCheckers=" + RegionChangesCheckers // NOI18N
              + ", PointerEscapeCheckers=" + PointerEscapeCheckers // NOI18N
              + ", EvalAssumeCheckers=" + EvalAssumeCheckers // NOI18N
              + ", EvalCallCheckers=" + EvalCallCheckers // NOI18N
              + ", EndOfTranslationUnitCheckers=" + EndOfTranslationUnitCheckers // NOI18N
              + ", Events=" + Events; // NOI18N
  }
}
