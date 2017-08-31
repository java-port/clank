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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import org.clang.staticanalyzer.checkers.ento.impl.EntoStatics;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 96,
 FQN="(anonymous namespace)::NilArgChecker", NM="_ZN12_GLOBAL__N_113NilArgCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_113NilArgCheckerE")
//</editor-fold>
public class NilArgChecker extends /*public*/ Checker/*<PreObjCMessage, PostStmt<ObjCDictionaryLiteral>, PostStmt<ObjCArrayLiteral> >*/ 
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<APIMisuse> BT;
  
  private /*mutable */SmallDenseMapTypeUInt<Selector> StringSelectors;
  private /*mutable */Selector ArrayWithObjectSel;
  private /*mutable */Selector AddObjectSel;
  private /*mutable */Selector InsertObjectAtIndexSel;
  private /*mutable */Selector ReplaceObjectAtIndexWithObjectSel;
  private /*mutable */Selector SetObjectAtIndexedSubscriptSel;
  private /*mutable */Selector ArrayByAddingObjectSel;
  private /*mutable */Selector DictionaryWithObjectForKeySel;
  private /*mutable */Selector SetObjectForKeySel;
  private /*mutable */Selector SetObjectForKeyedSubscriptSel;
  private /*mutable */Selector RemoveObjectForKeySel;
  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::warnIfNilExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 137,
   FQN="(anonymous namespace)::NilArgChecker::warnIfNilExpr", NM="_ZNK12_GLOBAL__N_113NilArgChecker13warnIfNilExprEPKN5clang4ExprEPKcRNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_113NilArgChecker13warnIfNilExprEPKN5clang4ExprEPKcRNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void warnIfNilExpr(/*const*/ Expr /*P*/ E, 
               /*const*/char$ptr/*char P*/ Msg, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean($c$.track(State.$arrow().isNull(C.getSVal(E))).isConstrainedTrue())) {
        {
          
          ExplodedNode /*P*/ N = C.generateErrorNode();
          if ((N != null)) {
            generateBugReport(N, new StringRef(Msg), E.getSourceRange(), E, C);
          }
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::warnIfNilArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 149,
   FQN="(anonymous namespace)::NilArgChecker::warnIfNilArg", NM="_ZNK12_GLOBAL__N_113NilArgChecker12warnIfNilArgERN5clang4ento14CheckerContextERKNS2_14ObjCMethodCallEj15FoundationClassb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_113NilArgChecker12warnIfNilArgERN5clang4ento14CheckerContextERKNS2_14ObjCMethodCallEj15FoundationClassb")
  //</editor-fold>
  private void warnIfNilArg(final CheckerContext /*&*/ C, 
              final /*const*/ ObjCMethodCall /*&*/ msg, 
              /*uint*/int Arg, 
              FoundationClass Class) /*const*/ {
    warnIfNilArg(C, 
              msg, 
              Arg, 
              Class, 
              false);
  }
  private void warnIfNilArg(final CheckerContext /*&*/ C, 
              final /*const*/ ObjCMethodCall /*&*/ msg, 
              /*uint*/int Arg, 
              FoundationClass Class, 
              boolean CanBeSubscript/*= false*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Check if the argument is nil.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!$c$.track(State.$arrow().isNull(msg.getArgSVal(Arg))).isConstrainedTrue())) {
        return;
      }
      {
        
        ExplodedNode /*P*/ N = C.generateErrorNode();
        if ((N != null)) {
          raw_svector_ostream os = null;
          try {
            SmallString/*<128>*/ sbuf/*J*/= new SmallString/*<128>*/(128);
            os/*J*/= new raw_svector_ostream(sbuf);
            if (CanBeSubscript && msg.getMessageKind() == ObjCMessageKind.OCM_Subscript) {
              if (Class == FoundationClass.FC_NSArray) {
                os.$out(/*KEEP_STR*/"Array element cannot be nil");
              } else if (Class == FoundationClass.FC_NSDictionary) {
                if (Arg == 0) {
                  os.$out(/*KEEP_STR*/"Value stored into '");
                  os.$out(BasicObjCFoundationChecksStatics.GetReceiverInterfaceName(msg)).$out(/*KEEP_STR*/"' cannot be nil");
                } else {
                  assert (Arg == 1);
                  os.$out(/*KEEP_STR*/$SGL_QUOTE).$out(BasicObjCFoundationChecksStatics.GetReceiverInterfaceName(msg)).$out(/*KEEP_STR*/"' key cannot be nil");
                }
              } else {
                throw new llvm_unreachable("Missing foundation class for the subscript expr");
              }
            } else {
              if (Class == FoundationClass.FC_NSDictionary) {
                if (Arg == 0) {
                  os.$out(/*KEEP_STR*/"Value argument ");
                } else {
                  assert (Arg == 1);
                  os.$out(/*KEEP_STR*/"Key argument ");
                }
                os.$out(/*KEEP_STR*/"to '");
                msg.getSelector().print(os);
                os.$out(/*KEEP_STR*/"' cannot be nil");
              } else {
                os.$out(/*KEEP_STR*/"Argument to '").$out(BasicObjCFoundationChecksStatics.GetReceiverInterfaceName(msg)).$out(/*KEEP_STR*/"' method '");
                msg.getSelector().print(os);
                os.$out(/*KEEP_STR*/"' cannot be nil");
              }
            }
            
            generateBugReport(N, os.str(), msg.getArgSourceRange(Arg), 
                msg.getArgExpr(Arg), C);
          } finally {
            if (os != null) { os.$destroy(); }
          }
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::generateBugReport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 201,
   FQN="(anonymous namespace)::NilArgChecker::generateBugReport", NM="_ZNK12_GLOBAL__N_113NilArgChecker17generateBugReportEPN5clang4ento12ExplodedNodeEN4llvm9StringRefENS1_11SourceRangeEPKNS1_4ExprERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_113NilArgChecker17generateBugReportEPN5clang4ento12ExplodedNodeEN4llvm9StringRefENS1_11SourceRangeEPKNS1_4ExprERNS2_14CheckerContextE")
  //</editor-fold>
  private void generateBugReport(ExplodedNode /*P*/ N, 
                   StringRef Msg, 
                   SourceRange Range, 
                   /*const*/ Expr /*P*/ E, 
                   final CheckerContext /*&*/ C) /*const*/ {
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BT.$bool()) {
        BT.reset(new APIMisuse(this, $("nil argument")));
      }
      
      R = llvm.make_unique(new BugReport(BT.$star(), Msg, N));
      R.$arrow().addRange(new SourceRange(Range));
      NsBugreporter.trackNullOrUndefValue(N, E, R.$star());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 215,
   FQN="(anonymous namespace)::NilArgChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_113NilArgChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_113NilArgChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ ID = msg.getReceiverInterface();
    if (!(ID != null)) {
      return;
    }
    
    FoundationClass Class = BasicObjCFoundationChecksStatics.findKnownClass(ID);
    
    final/*static*/ /*const*//*uint*/int InvalidArgIndex = checkPreObjCMessage$$.InvalidArgIndex;
    /*uint*/int Arg = InvalidArgIndex;
    boolean CanBeSubscript = false;
    if (Class == FoundationClass.FC_NSString) {
      Selector S = msg.getSelector();
      if (S.isUnarySelector()) {
        return;
      }
      if (StringSelectors.empty()) {
        final ASTContext /*&*/ Ctx = C.getASTContext();
        Selector Sels[/*10*/] = new Selector [/*10*/] {
          EntoStatics.getKeywordSelector(Ctx, $("caseInsensitiveCompare"), null), 
          EntoStatics.getKeywordSelector(Ctx, $("compare"), null), 
          EntoStatics.getKeywordSelector(Ctx, $("compare"), $("options"), null), 
          EntoStatics.getKeywordSelector(Ctx, $("compare"), $("options"), $("range"), null), 
          EntoStatics.getKeywordSelector(Ctx, $("compare"), $("options"), $("range"), $("locale"), 
              null), 
          EntoStatics.getKeywordSelector(Ctx, $("componentsSeparatedByCharactersInSet"), 
              null), 
          EntoStatics.getKeywordSelector(Ctx, $("initWithFormat"), 
              null), 
          EntoStatics.getKeywordSelector(Ctx, $("localizedCaseInsensitiveCompare"), null), 
          EntoStatics.getKeywordSelector(Ctx, $("localizedCompare"), null), 
          EntoStatics.getKeywordSelector(Ctx, $("localizedStandardCompare"), null)
        };
        for (Selector KnownSel : Sels)  {
          StringSelectors.$set(KnownSel, 0);
        }
      }
      DenseMapIteratorTypeUInt<Selector> I = StringSelectors.find(S);
      if (I.$eq(/*NO_ITER_COPY*/StringSelectors.end())) {
        return;
      }
      Arg = I.$arrow().second;
    } else if (Class == FoundationClass.FC_NSArray) {
      Selector S = msg.getSelector();
      if (S.isUnarySelector()) {
        return;
      }
      if (ArrayWithObjectSel.isNull()) {
        final ASTContext /*&*/ Ctx = C.getASTContext();
        ArrayWithObjectSel.$assignMove(EntoStatics.getKeywordSelector(Ctx, $("arrayWithObject"), null));
        AddObjectSel.$assignMove(EntoStatics.getKeywordSelector(Ctx, $("addObject"), null));
        InsertObjectAtIndexSel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("insertObject"), $("atIndex"), null)
        );
        ReplaceObjectAtIndexWithObjectSel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("replaceObjectAtIndex"), $("withObject"), null)
        );
        SetObjectAtIndexedSubscriptSel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("setObject"), $("atIndexedSubscript"), null)
        );
        ArrayByAddingObjectSel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("arrayByAddingObject"), null)
        );
      }
      if (S.$eq(/*NO_COPY*/ArrayWithObjectSel) || S.$eq(/*NO_COPY*/AddObjectSel)
         || S.$eq(/*NO_COPY*/InsertObjectAtIndexSel) || S.$eq(/*NO_COPY*/ArrayByAddingObjectSel)) {
        Arg = 0;
      } else if (S.$eq(/*NO_COPY*/SetObjectAtIndexedSubscriptSel)) {
        Arg = 0;
        CanBeSubscript = true;
      } else if (S.$eq(/*NO_COPY*/ReplaceObjectAtIndexWithObjectSel)) {
        Arg = 1;
      }
    } else if (Class == FoundationClass.FC_NSDictionary) {
      Selector S = msg.getSelector();
      if (S.isUnarySelector()) {
        return;
      }
      if (DictionaryWithObjectForKeySel.isNull()) {
        final ASTContext /*&*/ Ctx = C.getASTContext();
        DictionaryWithObjectForKeySel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("dictionaryWithObject"), $("forKey"), null)
        );
        SetObjectForKeySel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("setObject"), $("forKey"), null)
        );
        SetObjectForKeyedSubscriptSel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("setObject"), $("forKeyedSubscript"), null)
        );
        RemoveObjectForKeySel.$assignMove(
            EntoStatics.getKeywordSelector(Ctx, $("removeObjectForKey"), null)
        );
      }
      if (S.$eq(/*NO_COPY*/DictionaryWithObjectForKeySel) || S.$eq(/*NO_COPY*/SetObjectForKeySel)) {
        Arg = 0;
        warnIfNilArg(C, msg, /* Arg */ 1, Class);
      } else if (S.$eq(/*NO_COPY*/SetObjectForKeyedSubscriptSel)) {
        CanBeSubscript = true;
        Arg = 1;
      } else if (S.$eq(/*NO_COPY*/RemoveObjectForKeySel)) {
        Arg = 0;
      }
    }
    
    // If argument is '0', report a warning.
    if ((Arg != InvalidArgIndex)) {
      warnIfNilArg(C, msg, Arg, Class, CanBeSubscript);
    }
  }
  private static final class checkPreObjCMessage$$ {
    static final/*static*/ /*const*//*uint*/int InvalidArgIndex = UINT_MAX;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 328,
   FQN="(anonymous namespace)::NilArgChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_113NilArgChecker13checkPostStmtEPKN5clang21ObjCDictionaryLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_113NilArgChecker13checkPostStmtEPKN5clang21ObjCDictionaryLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCDictionaryLiteral /*P*/ DL, 
               final CheckerContext /*&*/ C) /*const*/ {
    /*uint*/int NumOfElements = DL.getNumElements();
    for (/*uint*/int i = 0; $less_uint(i, NumOfElements); ++i) {
      ObjCDictionaryElement Element = null;
      try {
        Element = DL.getKeyValueElement(i);
        warnIfNilExpr(Element.Key, $("Dictionary key cannot be nil"), C);
        warnIfNilExpr(Element.Value, $("Dictionary value cannot be nil"), C);
      } finally {
        if (Element != null) { Element.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 320,
   FQN="(anonymous namespace)::NilArgChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_113NilArgChecker13checkPostStmtEPKN5clang16ObjCArrayLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_113NilArgChecker13checkPostStmtEPKN5clang16ObjCArrayLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCArrayLiteral /*P*/ AL, 
               final CheckerContext /*&*/ C) /*const*/ {
    /*uint*/int NumOfElements = AL.getNumElements();
    for (/*uint*/int i = 0; $less_uint(i, NumOfElements); ++i) {
      warnIfNilExpr(AL.getElement$Const(i), $("Array element cannot be nil"), C);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::~NilArgChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 96,
   FQN="(anonymous namespace)::NilArgChecker::~NilArgChecker", NM="_ZN12_GLOBAL__N_113NilArgCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_113NilArgCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    StringSelectors.$destroy();
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NilArgChecker::NilArgChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 96,
   FQN="(anonymous namespace)::NilArgChecker::NilArgChecker", NM="_ZN12_GLOBAL__N_113NilArgCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_113NilArgCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ NilArgChecker() {
    // : Checker<PreObjCMessage, PostStmt<ObjCDictionaryLiteral>, PostStmt<ObjCArrayLiteral> >(), BT(), StringSelectors(), ArrayWithObjectSel(), AddObjectSel(), InsertObjectAtIndexSel(), ReplaceObjectAtIndexWithObjectSel(), SetObjectAtIndexedSubscriptSel(), ArrayByAddingObjectSel(), DictionaryWithObjectForKeySel(), SetObjectForKeySel(), SetObjectForKeyedSubscriptSel(), RemoveObjectForKeySel() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<APIMisuse>();
    this.StringSelectors = new SmallDenseMapTypeUInt<Selector>(DenseMapInfoSelector.$Info(), 16, (/*uint*/int)0);
    this.ArrayWithObjectSel = new Selector();
    this.AddObjectSel = new Selector();
    this.InsertObjectAtIndexSel = new Selector();
    this.ReplaceObjectAtIndexWithObjectSel = new Selector();
    this.SetObjectAtIndexedSubscriptSel = new Selector();
    this.ArrayByAddingObjectSel = new Selector();
    this.DictionaryWithObjectForKeySel = new Selector();
    this.SetObjectForKeySel = new Selector();
    this.SetObjectForKeyedSubscriptSel = new Selector();
    this.RemoveObjectForKeySel = new Selector();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ObjCDictionaryLiteral) {
      checkPostStmt((ObjCDictionaryLiteral) stmt, C);
    } else if (stmt instanceof ObjCArrayLiteral) {
      checkPostStmt((ObjCArrayLiteral) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new PreObjCMessage(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCDictionaryLiteral>(ObjCDictionaryLiteral.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCArrayLiteral>(ObjCArrayLiteral.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", StringSelectors=" + StringSelectors // NOI18N
              + ", ArrayWithObjectSel=" + ArrayWithObjectSel // NOI18N
              + ", AddObjectSel=" + AddObjectSel // NOI18N
              + ", InsertObjectAtIndexSel=" + InsertObjectAtIndexSel // NOI18N
              + ", ReplaceObjectAtIndexWithObjectSel=" + ReplaceObjectAtIndexWithObjectSel // NOI18N
              + ", SetObjectAtIndexedSubscriptSel=" + SetObjectAtIndexedSubscriptSel // NOI18N
              + ", ArrayByAddingObjectSel=" + ArrayByAddingObjectSel // NOI18N
              + ", DictionaryWithObjectForKeySel=" + DictionaryWithObjectForKeySel // NOI18N
              + ", SetObjectForKeySel=" + SetObjectForKeySel // NOI18N
              + ", SetObjectForKeyedSubscriptSel=" + SetObjectForKeyedSubscriptSel // NOI18N
              + ", RemoveObjectForKeySel=" + RemoveObjectForKeySel // NOI18N
              + super.toString(); // NOI18N
  }
}
