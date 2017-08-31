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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.lex.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.basic.tok.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 934,
 FQN="(anonymous namespace)::EmptyLocalizationContextChecker", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextCheckerE")
//</editor-fold>
public class EmptyLocalizationContextChecker extends /*public*/ Checker/*T<ASTDecl<ObjCImplementationDecl> > */
        implements org.clang.staticanalyzer.java.ASTDeclChecker<ObjCImplementationDecl>, Destructors.ClassWithDestructor {

  // A helper class, which walks the AST
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 938,
   FQN="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawlerE")
  //</editor-fold>
  private static class MethodCrawler implements /*public*/ ConstStmtVisitorVoid<MethodCrawler> {
    private /*const*/ ObjCMethodDecl /*P*/ MD;
    private final BugReporter /*&*/ BR;
    private final AnalysisManager /*&*/ Mgr;
    private /*const*/ CheckerBase /*P*/ Checker;
    private PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > DCtx;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::MethodCrawler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 946,
     FQN="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::MethodCrawler", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawlerC1EPKN5clang14ObjCMethodDeclERNS2_4ento11BugReporterEPKNS6_11CheckerBaseERNS6_15AnalysisManagerEPNS2_19AnalysisDeclContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawlerC1EPKN5clang14ObjCMethodDeclERNS2_4ento11BugReporterEPKNS6_11CheckerBaseERNS6_15AnalysisManagerEPNS2_19AnalysisDeclContextE")
    //</editor-fold>
    public MethodCrawler(/*const*/ ObjCMethodDecl /*P*/ InMD, final BugReporter /*&*/ InBR, 
        /*const*/ CheckerBase /*P*/ Checker, final AnalysisManager /*&*/ InMgr, 
        AnalysisDeclContext /*P*/ InDCtx) {
      // : ConstStmtVisitor<MethodCrawler>(), MD(InMD), BR(InBR), Mgr(InMgr), Checker(Checker), DCtx(InDCtx) 
      //START JInit
      $ConstStmtVisitor();
      this.MD = InMD;
      this./*&*/BR=/*&*/InBR;
      this./*&*/Mgr=/*&*/InMgr;
      this.Checker = Checker;
      this.DCtx = new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, InDCtx);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::VisitStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 951,
     FQN="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::VisitStmt", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler9VisitStmtEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler9VisitStmtEPKN5clang4StmtE")
    //</editor-fold>
    public void VisitStmt(/*const*/ Stmt /*P*/ S) {
      VisitChildren(S);
    }

    
    
    /// This check attempts to match these macros, assuming they are defined as
    /// follows:
    ///
    /// #define NSLocalizedString(key, comment) \
    /// [[NSBundle mainBundle] localizedStringForKey:(key) value:@"" table:nil]
    /// #define NSLocalizedStringFromTable(key, tbl, comment) \
    /// [[NSBundle mainBundle] localizedStringForKey:(key) value:@"" table:(tbl)]
    /// #define NSLocalizedStringFromTableInBundle(key, tbl, bundle, comment) \
    /// [bundle localizedStringForKey:(key) value:@"" table:(tbl)]
    /// #define NSLocalizedStringWithDefaultValue(key, tbl, bundle, val, comment)
    ///
    /// We cannot use the path sensitive check because the macro argument we are
    /// checking for (comment) is not used and thus not present in the AST,
    /// so we use Lexer on the original macro call and retrieve the value of
    /// the comment. If it's empty or nil, we raise a warning.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::VisitObjCMessageExpr">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*unfold SLocEntry*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1001,
     FQN="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE")
    //</editor-fold>
    public void VisitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ ME) {
      Lexer TheLexer = null;
      try {
        
        /*const*/ ObjCInterfaceDecl /*P*/ OD = ME.getReceiverInterface();
        if (!(OD != null)) {
          return;
        }
        
        /*const*/ IdentifierInfo /*P*/ odInfo = OD.getIdentifier();
        if (!(odInfo.isStr(/*KEEP_STR*/"NSBundle")
           && $eq_string$C_T$C$P(ME.getSelector().getAsString(), 
            /*KEEP_STR*/"localizedStringForKey:value:table:"))) {
          return;
        }
        
        SourceRange R = ME.getSourceRange();
        if (!R.getBegin().isMacroID()) {
          return;
        }
        
        // getImmediateMacroCallerLoc gets the location of the immediate macro
        // caller, one level up the stack toward the initial macro typed into the
        // source, so SL should point to the NSLocalizedString macro.
        SourceLocation SL = Mgr.getSourceManager().getImmediateMacroCallerLoc(R.getBegin());
        std.pairTypeUInt<FileID> SLInfo = Mgr.getSourceManager().getDecomposedLoc(/*NO_COPY*/SL);
        
        // JAVA: we don't have SLocEntry instances, use index instead
        if (false) {
          SrcMgr.SLocEntry SE = new SrcMgr.SLocEntry(Mgr.getSourceManager().getSLocEntry(/*NO_COPY*/SLInfo.first));
        }
        SourceManager $SM = Mgr.getSourceManager();
        /*SrcMgr.SLocEntry*/int SE = $SM.getSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/SLInfo.first.$ID());
        
        // If NSLocalizedString macro is wrapped in another macro, we need to
        // unwrap the expansion until we get to the NSLocalizedStringMacro.
        while ($SM.$isExpansion(SE)) {
          SL.$assignMove($SM.$getSpellingLoc(SE));
          SLInfo.$assignMove(Mgr.getSourceManager().getDecomposedLoc(/*NO_COPY*/SL));
          SE = $SM.getSLocEntryByID_LoadEntryIfAbsent(/*NO_COPY*/SLInfo.first.$ID());
        }
        
        MemoryBuffer /*P*/ BF = $SM.$getContentCache(SE).getRawBuffer();
        TheLexer/*J*/= new Lexer(/*NO_COPY*/SL, new LangOptions(), BF.getBufferStart(), 
            BF.getBufferStart().$add(SLInfo.second), BF.getBufferEnd());
        
        Token I/*J*/= new Token();
        Token Result/*J*/= new Token(); // This will hold the token just before the last ')'
        int p_count = 0; // This is for parenthesis matching
        while (!TheLexer.LexFromRawLexer(I)) {
          if (I.getKind() == tok.TokenKind.l_paren) {
            ++p_count;
          }
          if (I.getKind() == tok.TokenKind.r_paren) {
            if (p_count == 1) {
              break;
            }
            --p_count;
          }
          Result.$assign(I);
        }
        if (isAnyIdentifier(Result.getKind())) {
          if (Result.getRawIdentifier().equals(/*STRINGREF_STR*/"nil")) {
            reportEmptyContextError(ME);
            return;
          }
        }
        if (!isStringLiteral(Result.getKind())) {
          return;
        }
        
        StringRef Comment = new StringRef(Result.getLiteralData(), Result.getLength()).trim(new StringRef($DBL_QUOTE));
        if ((Comment.trim().size() == 0 && $greater_uint(Comment.size(), 0)) // Is Whitespace
           || Comment.empty()) {
          reportEmptyContextError(ME);
        }
      } finally {
        if (TheLexer != null) { TheLexer.$destroy(); }
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::reportEmptyContextError">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1075,
     FQN="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::reportEmptyContextError", NM="_ZNK12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler23reportEmptyContextErrorEPKN5clang15ObjCMessageExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler23reportEmptyContextErrorEPKN5clang15ObjCMessageExprE")
    //</editor-fold>
    public void reportEmptyContextError(/*const*/ ObjCMessageExpr /*P*/ ME) /*const*/ {
      // Generate the bug report.
      BR.EmitBasicReport(MD, Checker, new StringRef(/*KEEP_STR*/"Context Missing"), 
          new StringRef(/*KEEP_STR*/"Localizability Issue (Apple)"), 
          new StringRef(/*KEEP_STR*/"Localized string macro should include a non-empty comment for translators"), 
          new PathDiagnosticLocation(ME, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(DCtx)));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::VisitChildren">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 957,
     FQN="(anonymous namespace)::EmptyLocalizationContextChecker::MethodCrawler::VisitChildren", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler13VisitChildrenEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextChecker13MethodCrawler13VisitChildrenEPKN5clang4StmtE")
    //</editor-fold>
    public void VisitChildren(/*const*/ Stmt /*P*/ S) {
      for (/*const*/ Stmt /*P*/ Child : S.children$Const()) {
        if ((Child != null)) {
          /*J:ToBase*/ConstStmtVisitorVoid /*P*/ .super.Visit(Child);
        }
      }
    }

    
    @Override public String toString() {
      return "" + "MD=" + MD // NOI18N
                + ", BR=" + BR // NOI18N
                + ", Mgr=" + "[AnalysisManager]" // NOI18N
                + ", Checker=" + Checker // NOI18N
                + ", DCtx=" + "[PointerUnion$LocationContext$AnalysisDeclContext]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 971,
   FQN="(anonymous namespace)::EmptyLocalizationContextChecker::checkASTDecl", NM="_ZNK12_GLOBAL__N_131EmptyLocalizationContextChecker12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_131EmptyLocalizationContextChecker12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ ObjCImplementationDecl /*P*/ D, final AnalysisManager /*&*/ Mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
    
    for (/*const*/ ObjCMethodDecl /*P*/ M : D.methods()) {
      AnalysisDeclContext /*P*/ DCtx = Mgr.getAnalysisDeclContext(M);
      
      /*const*/ Stmt /*P*/ Body = M.getBody();
      assert Native.$bool(Body);
      
      MethodCrawler MC/*J*/= new MethodCrawler(M.getCanonicalDecl$Const(), BR, this, Mgr, DCtx);
      MC.VisitStmt(Body);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::~EmptyLocalizationContextChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 934,
   FQN="(anonymous namespace)::EmptyLocalizationContextChecker::~EmptyLocalizationContextChecker", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptyLocalizationContextChecker::EmptyLocalizationContextChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 934,
   FQN="(anonymous namespace)::EmptyLocalizationContextChecker::EmptyLocalizationContextChecker", NM="_ZN12_GLOBAL__N_131EmptyLocalizationContextCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_131EmptyLocalizationContextCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ EmptyLocalizationContextChecker() {
    // : Checker<ASTDecl<ObjCImplementationDecl> >() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTDecl<ObjCImplementationDecl>(ObjCImplementationDecl.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
