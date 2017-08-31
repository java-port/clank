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

package org.clang.lex.test;

import static org.clank.support.Native.$AddrOf;
import org.clang.lex.java.PTHManagerDriver;
import java.util.ArrayList;
import java.util.List;
import org.clang.lex.*;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import org.clang.basic.*;
import org.clang.frontend.VerifyDiagnosticConsumer;
import org.clang.frontend.impl.CompilerInstanceStatics;
import org.clang.lex.test.PPCallbackEventsTracker.*;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import static org.junit.Assert.assertEquals;
import org.llvm.adt.*;
import org.llvm.support.*;

// PPCallbacks test fixture.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 110,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest")
//</editor-fold>
public class PPCallbackEventsTestBase extends /*public*/ /*::*/ADTSupportTestBase implements Destructors.ClassWithDestructor {
  /**
   * special marker to gather tokens
   */
  protected static final std.vectorUShort/*<tok.TokenKind>*/ PRINT_TOKENS = new std.vectorUShort();
  
  /**
   * special marker collection which allows to gather events on the first (non-PTH) run
   * and use it as golden against events collected during the second (with-PTH) run
   */
  protected static final List<PPCallbackEvent> GATHER_EVENTS_FROM_NON_PTH_RUN = new ArrayList<PPCallbackEvent>(0);
  /**
   * special marker collection which allows to print events on the first (non-PTH) run
   */
  protected static final List<PPCallbackEvent> PRINT_EVENTS_FROM_NON_PTH_RUN = new ArrayList<PPCallbackEvent>(0);
  
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::PPCallbacksTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 112,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::PPCallbacksTest")
  //</editor-fold>
  public PPCallbackEventsTestBase(TestState runTestsWithSpecifiedState) {
    /* : ::Test(), FileMgrOpts(), FileMgr(FileMgrOpts), DiagID(new DiagnosticIDs()), DiagOpts(new DiagnosticOptions()), Diags(DiagID, DiagOpts.getPtr(), new IgnoringDiagConsumer()), SourceMgr(Diags, FileMgr), LangOpts(), TargetOpts(), Target()*/ 
    //START JInit
    super(runTestsWithSpecifiedState);
    this.FileMgrOpts = new FileSystemOptions();
    this.FileMgr = new FileManager(FileMgrOpts);
    this.DiagID = new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
    this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
    this.Diags = new DiagnosticsEngine(DiagID, DiagOpts.get(), new TestDiagnosticConsumer());
    this.SourceMgr = new SourceManager(Diags, FileMgr);
    this.LangOpts = new LangOptions();
    this.TargetOpts = new std.shared_ptr<TargetOptions>(new TargetOptions());
    this.Target = new IntrusiveRefCntPtr<TargetInfo>();
    //END JInit
    // use the biggest union like in PTHWriter
    LangOpts.C11 = true;
    LangOpts.CPlusPlus   = true;
    LangOpts.CPlusPlus11 = true;
    LangOpts.CPlusPlus14 = true;
    LangOpts.CPlusPlus1z = true;    
    LangOpts.Digraphs = true;
    LangOpts.Trigraphs = true;
    LangOpts.LineComment = true;
    TargetOpts.$arrow().Triple.$assign($("x86_64-apple-darwin11.1.0"));
    Target.$assign(new IntrusiveRefCntPtr<TargetInfo>(TargetInfo.CreateTargetInfo(Diags, TargetOpts)));
    this.verifyDiagnosticConsumer = new VerifyDiagnosticConsumer(Diags);
    Diags.setClient(verifyDiagnosticConsumer);
  }

  protected FileSystemOptions FileMgrOpts;
  protected FileManager FileMgr;
  protected IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
  protected IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
  protected DiagnosticsEngine Diags;
  protected SourceManager SourceMgr;
  protected LangOptions LangOpts;
  protected std.shared_ptr<TargetOptions> TargetOpts;
  protected IntrusiveRefCntPtr<TargetInfo> Target;
  protected final VerifyDiagnosticConsumer verifyDiagnosticConsumer;
  
  protected void PrepareMainFileWithContent(char$ptr SourceText) {
    // prepare FileEntry for source content
    LexerTestSupport.PrepareMainFileWithContent(getTestMethodName(), FileMgr, SourceMgr, new StringRef(SourceText));
  }
  
  // Register a header path as a known file and add its location
  // to search path.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::AddFakeHeader">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 135,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::AddFakeHeader")
  //</editor-fold>
  protected void AddFakeHeader(HeaderSearch /*&*/ HeaderInfo, 
          /*const*/char$ptr/*char P*/ HeaderPath, StringRef HeaderContent, boolean IsSystemHeader) {
    LexerTestSupport.AddFakeHeader(FileMgr, SourceMgr, HeaderInfo, HeaderPath, HeaderContent, IsSystemHeader);
  }

  
  // Get the raw source string of the range.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::GetSourceString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 148,
   optimized = Converted.Optimization.COMPLEX,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::GetSourceString")
  //</editor-fold>
  protected StringRef GetSourceString(CharSourceRange Range) {
    // JAVA PERF: use specialized method
    if (false) {
      /*const*/char$ptr/*char P*/ B = SourceMgr.getCharacterData(Range.$getBegin());
      /*const*/char$ptr/*char P*/ E = SourceMgr.getCharacterData(Range.$getEnd());

      return new StringRef(B, E.$sub(B));
    }
    return SourceMgr.getCharacterDataStringRef_ValidOnly(Range.$getBegin(), Range.$getEnd());
  }

  // Get preprocessed output between two tokens
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest::getSourceText">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 90,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=__anonymous_namespace::LexerTest::getSourceText")
  //</editor-fold>
  protected std.string getSourceText(Token Begin, Token End) {
    boolean Invalid;
    bool$ptr Invalid$ptr = NativePointer.create_bool$ptr();
    StringRef Str = Lexer.getSourceText(CharSourceRange.getTokenRange(new SourceRange(Begin.getLocation(), End.getLocation())), SourceMgr, LangOpts, $AddrOf(Invalid$ptr));
    Invalid = Invalid$ptr.$star();
    if (Invalid) {
      return new std.string("<INVALID>");
    }
    return Str.$string();
  }
  
  // Run lexer over SourceText and collect FilenameRange from
  // the InclusionDirective callback.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::InclusionDirectiveFilenameRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 157,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::InclusionDirectiveFilenameRange")
  //</editor-fold>
  protected PPCallbackEventsTracker RunPreprocessor(/*const*/String/*char P*/ __SourceText, 
          boolean usePTHDriver,
          std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens,
          PreprocessorInitializer PPInitializer,          
          /*const*/String/*char P*/ __HeaderPath, String __HeaderText, boolean SystemHeader) {
    if (PPInitializer == null) {
      PPInitializer = new PreprocessorInitializer();
    }
    /*const*/char$ptr/*char P*/ SourceText = create_char$ptr_utf8(__SourceText);
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    try {
      if (usePTHDriver && !SourceMgr.getMainFileID().isInvalid()) {
        Diags.Reset();
        // on the second run source text must be the same as in non-PTH run
        MemoryBuffer buffer = SourceMgr.getBuffer(SourceMgr.getMainFileID());
        ASSERT_EQ(Native.$toString(SourceText), Native.$toString(buffer.getBufferStart(), buffer.getBufferSize()));
        SourceMgr.clearIDTables();
      }
      // prepare FileEntry for source content
      PrepareMainFileWithContent(SourceText);
      
      ModLoader/*J*/= $track(new VoidModuleLoader());
      
      IntrusiveRefCntPtr<HeaderSearchOptions> HSOpts = new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions());
      HSOpts.get().UseBuiltinIncludes = false;
      HSOpts.get().UseLibcxx = false;
      HSOpts.get().UseStandardCXXIncludes = false;
      HSOpts.get().UseStandardSystemIncludes = false;
      HeaderInfo/*J*/= $track(new HeaderSearch(HSOpts, SourceMgr, Diags, LangOpts, Target.get()));
      if (__HeaderPath.length() > 0) {
        /*const*/char$ptr/*char P*/ HeaderPath = create_char$ptr_utf8(__HeaderPath);
        AddFakeHeader(HeaderInfo, HeaderPath, new StringRef(create_char$ptr_utf8(__HeaderText)), SystemHeader);
      }
      
      IntrusiveRefCntPtr<PreprocessorOptions> PPOpts = new IntrusiveRefCntPtr<PreprocessorOptions>(PPInitializer.getPreprocessorOptions());
      PP/*J*/= $track(new Preprocessor(PPOpts, Diags, LangOpts, SourceMgr, HeaderInfo, ModLoader, null, false));
      PP.Initialize(Target.$star());
      CompilerInstanceStatics.InitializeFileRemapping(Diags, SourceMgr, FileMgr, PPOpts.get());
      PPCallbackEventsTracker /*P*/ Callback = new PPCallbackEventsTracker();
      PP.addPPCallbacks(new std.unique_ptr(Callback)); // Takes ownership.
      
      if (usePTHDriver) {
        PTHManagerDriver.PreparePTHForPreprocessor(PP);
      }
      PP.SetSuppressIncludeNotFoundError(PPInitializer.GetSuppressIncludeNotFoundError());
      PP.SetCommentRetentionState(PPInitializer.GetKeepComments(), PPInitializer.GetKeepMacroComments());
      // notify 
      Diags.getClient().BeginSourceFile(LangOpts, PP);
      // Lex source text.
      PP.EnterMainSourceFile();
      
      std.vector<Token> toks/*J*/= new std.vector<Token>((Token) null);
      while (true) {
        Token Tok/*J*/= new Token();
        PP.Lex(Tok);
        if (Tok.is(tok.TokenKind.eof)) {
          break;
        }
        toks.push_back(new Token(Tok));
      }
      if (ExpectedTokens == PRINT_TOKENS) {
        for (/*uint*/int i = 0, e = toks.size(); i != e; ++i) {          
          System.out.print("ExpectedTokens.push_back(tok.TokenKind.");
          if (tok.getKeywordSpelling(toks.$at(i).getKind()) != null) {
            System.out.print("kw_");
          }
          System.out.println(tok.getTokenName(toks.$at(i).getKind()) + ");");
        }
      } else if (ExpectedTokens != null) {
        if (ExpectedTokens.size() != toks.size()) {
          ASSERT_TRUE(false, "expected\n" + stringify(ExpectedTokens) + "\nvs.\n" + stringify(toks));
        }
        for (/*uint*/int i = 0, e = ExpectedTokens.size(); i != e; ++i) {
          assertEquals("at " + i, tok.getTokenName($int2ushort(ExpectedTokens.$at(i))), tok.getTokenName(toks.$at(i).getKind()));
        }
      }
      for (int i = 0; i < toks.size() - 1; i++) {
        EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(toks.$at(i).getLocation(), toks.$at(i + 1).getLocation()));
      }        
      // allow extra checks of produced tokens
      PPInitializer.checkTokens(toks);
      PP.getDiagnostics().getClient().EndSourceFile();
      assertEquals("Check Output: Unhandled " + 
              verifyDiagnosticConsumer.getNumErrors() + " Errors and " + 
              verifyDiagnosticConsumer.getNumWarnings() + " Warnings in " + 
              getTestMethodName(), 0, 
              verifyDiagnosticConsumer.getNumErrors()+verifyDiagnosticConsumer.getNumWarnings());
      // Callbacks have been executed at this point -- return filename range.
      return Callback;
    } finally {
    }
  }

  private String stringify(std.vectorUShort ExpectedTokens) {
    StringBuilder out = new StringBuilder();
    for (/*uint*/int i = 0, e = ExpectedTokens.size(); i != e; ++i) {
      if (i > 0) {
        out.append("\n");
      }
      out.append(tok.getTokenName(ExpectedTokens.$at(i)));
    }
    return out.toString();
  }

  private String stringify(std.vector<Token> toks) {
    StringBuilder out = new StringBuilder();
    for (/*uint*/int i = 0, e = toks.size(); i != e; ++i) {
      if (i > 0) {
        out.append("\n");
      }
      out.append(tok.getTokenName(toks.$at(i).getKind()));
    }
    return out.toString();
  }

  protected class PreprocessorInitializer {

    private final boolean keepComments;

    public PreprocessorInitializer() {
      this(false);
    }

    public PreprocessorInitializer(boolean keepComments) {
      this.keepComments = keepComments;
    }
    
    
    protected PreprocessorOptions getPreprocessorOptions() {
      PreprocessorOptions PPOpts = new PreprocessorOptions();
      PPOpts.UsePredefines = false;
      PPOpts.AllowPCHWithCompilerErrors = true;
      return PPOpts;
    }
    
    protected boolean GetSuppressIncludeNotFoundError() {
      return false;
    }
    
    protected boolean GetKeepComments() {
      return keepComments;
    }
    
    protected boolean GetKeepMacroComments() {
      return false;
    }
    
    protected void checkTokens(std.vector<Token> toks) {
      // override to check produced tokens before they are destroyed
    }
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::~PPCallbacksTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 110,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::~PPCallbacksTest")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }
}
