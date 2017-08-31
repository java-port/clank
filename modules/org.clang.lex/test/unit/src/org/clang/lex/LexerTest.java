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

package org.clang.lex;

import static org.clank.support.Native.$AddrOf;
import java.io.PrintStream;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import java.nio.charset.Charset;
import org.clang.basic.*;
import org.clang.basic.tok.TokenKind;
import org.clang.frontend.PreprocessorOutputOptions;
import org.clang.lex.*;
import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.junit.Test;
import static org.junit.Assert.*;

// The test fixture.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 46,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=__anonymous_namespace::LexerTest")
//</editor-fold>
public class LexerTest extends ADTSupportTestBase implements Destructors.ClassWithDestructor {  
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest::LexerTest">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 48,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=__anonymous_namespace::LexerTest::LexerTest")
  //</editor-fold>
  public LexerTest() {
    /* : ::Test(), FileMgrOpts(), FileMgr(FileMgrOpts), DiagID(new DiagnosticIDs()), Diags(DiagID, new DiagnosticOptions, new IgnoringDiagConsumer()), SourceMgr(Diags, FileMgr), LangOpts(), TargetOpts(new TargetOptions), Target()*/ 
    //START JInit
    super(TestState.Successful);
    this.FileMgrOpts = new FileSystemOptions();
    this.FileMgr = new FileManager(FileMgrOpts);
    this.DiagID = new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
    this.Diags = new DiagnosticsEngine(DiagID, new DiagnosticOptions(), new TestDiagnosticConsumer());
    this.SourceMgr = new SourceManager(Diags, FileMgr);
    this.LangOpts = new LangOptions();
    this.TargetOpts = new std.shared_ptr<TargetOptions>(new TargetOptions());
    this.Target = new IntrusiveRefCntPtr<TargetInfo>();
    //END JInit
    TargetOpts.$arrow().Triple.$assign("x86_64-apple-darwin11.1.0");
    Target.$assign(new IntrusiveRefCntPtr<TargetInfo>(TargetInfo.CreateTargetInfo(Diags, TargetOpts)));
  }  
  
  // JAVA: use LexerTestSupport
  private void PrepareMainFileWithContent(StringRef Source) {
    LexerTestSupport.PrepareMainFileWithContent(getTestMethodName(), FileMgr, SourceMgr, Source);
  }
  
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest::CheckLex">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 59,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=__anonymous_namespace::LexerTest::CheckLex")
  //</editor-fold>
  protected std.vector<Token> CheckLex(StringRef Source, ArrayRefUShort/*<tok.TokenKind>*/ ExpectedTokens, LexerInitializer lexerInitializer, LexerResultHandler handler) {
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    std.vector<Token> toks = null;
    try {
      // JAVA
      PrepareMainFileWithContent(Source);
      
      ModLoader/*J*/= $track(new VoidModuleLoader());
      HeaderInfo/*J*/= $track(lexerInitializer.createHeaderSearch());
      PP/*J*/= $track(lexerInitializer.createPreprocessor(HeaderInfo, ModLoader));
      PP.EnterMainSourceFile();
      PP.createPreprocessingRecord();
      toks/*J*/= new std.vector<Token>((Token) null);
      Token tok/*J*/= new Token();
      while (true) {
        PP.Lex(tok);
        if (tok.is(TokenKind.eof)) {
          break;
        }
        toks.push_back(new Token(tok));
      }
      if (ExpectedTokens != null) {
        assertEquals(ExpectedTokens.size(), toks.size());
        for (/*uint*/int i = 0, e = ExpectedTokens.size(); i != e; ++i) {
          assertEquals(ExpectedTokens.$at(i), toks.$at(i).getKind());
        }
      }
      for (int i = 0; i < toks.size() - 1; i++) {
        EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(toks.$at(i).getLocation(), toks.$at(i + 1).getLocation()));
      }      
      vector<Token> result = new std.vector<Token>(toks);
      if (handler != null) {
        handler.handle(PP, toks);
      }
      return result;
    } finally {
      if (toks != null) { toks.$destroy(); }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest::CheckLex">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 59,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=__anonymous_namespace::LexerTest::CheckLex")
  //</editor-fold>
  protected string CheckPPOutput(String Source) {
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = true;
    opts.ShowLineMarkers = true;
    opts.ShowMacros = true;
    opts.ShowMacroComments = true;
    return CheckPPOutput(Source, opts, new DefaultLexerInitializer());
  }
  protected string CheckPPOutput(String Source, PreprocessorOutputOptions PPOpts) {
    return CheckPPOutput(Source, PPOpts, new DefaultLexerInitializer());
  }
  protected string CheckPPOutput(String fileText, PreprocessorOutputOptions PPOpts, LexerInitializer lexerInitializer) {
    StringRef Source = new StringRef(create_char$ptr_utf8(fileText));
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    std.vector<Token> toks = null;
    try {
      MemoryBuffer /*P*/ buf = MemoryBuffer.getMemBuffer(Source).release();
      SourceMgr.setMainFileID(SourceMgr.createFileID(new unique_ptr<MemoryBuffer>(buf)));
      
      ModLoader/*J*/= $track(new VoidModuleLoader());
      HeaderInfo/*J*/= $track(lexerInitializer.createHeaderSearch());
      PP/*J*/= $track(lexerInitializer.createPreprocessor(HeaderInfo, ModLoader));
      raw_string_ostream OS = new raw_string_ostream(new std.string());
      org.clang.frontend.FrontendClangGlobals.DoPrintPreprocessedInput(PP, OS, PPOpts);
      OS.flush();
      return OS.str();
    } finally {
      if (toks != null) { toks.$destroy(); }
    }
  }
  
  protected std.vector<Token> CheckLex(String Source, std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens, LexerInitializer lexerInitializer) {
    Source += "\0";
    byte[] bytes = Source.getBytes(Charset.forName("UTF-8"));    
    return CheckLex(new StringRef(bytes, bytes.length-1), 
            ExpectedTokens == null ? null : new ArrayRefUShort/*<tok.TokenKind>*/(ExpectedTokens), 
            lexerInitializer,
            null);
  }  
  
  protected std.vector<Token> CheckLex(StringRef Source, ArrayRefUShort/*<tok.TokenKind>*/ ExpectedTokens) {
    return CheckLex(Source, ExpectedTokens, new DefaultLexerInitializer(), null);
  }
  
  protected std.vector<Token> CheckLex(String Source, std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens) {
    Source += "\0";
    byte[] bytes = Source.getBytes(Charset.forName("UTF-8"));
    return CheckLex(
            new StringRef(bytes, bytes.length-1), 
            ExpectedTokens != null ? new ArrayRefUShort/*<tok.TokenKind>*/(ExpectedTokens) : null
    );
  }
  
  protected std.vector<Token> CheckLex(String Source, LexerResultHandler handler) {
    return CheckLex(Source, new DefaultLexerInitializer(), handler);
  }
  
  protected std.vector<Token> CheckLex(String Source, LexerInitializer lexerInitializer, LexerResultHandler handler) {
    Source += "\0";
    byte[] bytes = Source.getBytes(Charset.forName("UTF-8"));
    return CheckLex(
            new StringRef(bytes, bytes.length-1), 
            null,
            lexerInitializer,
            handler
    );
  }

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

  protected FileSystemOptions FileMgrOpts;
  protected FileManager FileMgr;
  protected IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
  protected DiagnosticsEngine Diags;
  protected SourceManager SourceMgr;
  protected LangOptions LangOpts;
  protected std.shared_ptr<TargetOptions> TargetOpts;
  protected IntrusiveRefCntPtr<TargetInfo> Target;
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::LexerTest::~LexerTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp", line = 46,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/LexerTest.cpp -filter=__anonymous_namespace::LexerTest::~LexerTest")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
//    super.$destroy();
    throw new UnsupportedOperationException("Not implemented!");
  }  
  
  @Test 
  public void IncompleteStringization() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*tok.TokenKind*/ ExpectedTokens = new std.vectorUShort/*tok.TokenKind*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.numeric_constant);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    // JAVA: added DiscardUntilEndOfDirective in PP.HandleDefineDirective
    CheckLex(
            "//E t_6_048.cpp(23): error: ill formed preprocessing operator: stringize ('#')\n" +
            "#define FUNC(a)  # b c d e f\n" +
            "int FUNC(1);",
            ExpectedTokens);
  }
  
  @Test
  public void GetSourceTextExpandsToMaximumInMacroArgument() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*tok.TokenKind*/ ExpectedTokens = new std.vectorUShort/*tok.TokenKind*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\nM(f(M(i)))",
                                       ExpectedTokens);

    EXPECT_EQ("M(i)", getSourceText(toks.$at(2), toks.$at(2)));    
  } 
  
  @Test
  public void GetSourceTextExpandsToMaximumInMacroArgumentForEndOfMacro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" + 
                                      "M(M(i) c)",
                                      ExpectedTokens);

    EXPECT_EQ("M(i)", getSourceText(toks.$at(0), toks.$at(0))); 
  }  

  @Test
  public void GetSourceTextExpandsInMacroArgumentForBeginOfMacro() {  
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" +
                                      "M(c c M(i))",
                                      ExpectedTokens);

    EXPECT_EQ("c M(i)", getSourceText(toks.$at(1), toks.$at(2)));
  }  
  
  @Test
  public void GetSourceTextExpandsInMacroArgumentForEndOfMacro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" +
                                       "M(M(i) c c)",
                                       ExpectedTokens);

    EXPECT_EQ("M(i) c", getSourceText(toks.$at(0), toks.$at(1)));
  }

  @Test
  public void GetSourceTextInSeparateFnMacros() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" +
                                       "M(c M(i)) M(M(i) c)",
                                       ExpectedTokens);

    EXPECT_EQ("<INVALID>", getSourceText(toks.$at(1), toks.$at(2)));
  }

  @Test
  public void GetSourceTextWorksAcrossTokenPastes() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" + 
                                       "#define C(x) M(x##c)\n" +
                                       "M(f(C(i)))",
                                       ExpectedTokens);

    EXPECT_EQ("C(i)", getSourceText(toks.$at(2), toks.$at(2)));
  }

  @Test 
  public void Concatenation_01() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_struct);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    std.vector<Token> toks = CheckLex( "#define DEFINE_STRUCT(index) struct foo##index;\n" +
                                       "#define GEN_STRUCT_0(index) DEFINE_STRUCT(index##1)\n" + 
                                       "#define GEN_STRUCT_1(index) GEN_STRUCT_0(index##1)\n" +
                                       "GEN_STRUCT_0(0)",
                                       ExpectedTokens);
  }
  
  @Test 
  public void Concatenation_011() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_struct);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    std.vector<Token> toks = CheckLex( "#define DEFINE_STRUCT(index) struct foo##index;\n" +
                                       "#define GEN_STRUCT_0(index) DEFINE_STRUCT(index##1)\n" + 
                                       "#define GEN_STRUCT_1(index) GEN_STRUCT_0(index##1)\n" +
                                       "GEN_STRUCT_1(0)",
                                       ExpectedTokens);
  }
  
  private static final String PrintStringizedTokens_Input = 
            "#define MACRO(V1) #V1\n" +
            "#define MACRO2(V2) #V2\n" +
            "#define MACRO3(V3) #V3\n" +
            "\n" +
            "MACRO(A1) MACRO2(B11) MACRO3(C111)\n";
  
  @Test
  public void PrintStringizedTokens() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = false;
    opts.ShowLineMarkers = false;
    opts.ShowMacros = false;
    opts.ShowMacroComments = false;    
    string Output = CheckPPOutput(PrintStringizedTokens_Input, opts);
//    System.out.println(Output.toJavaString());
    EXPECT_EQ("\n" +
              "\n" +
              "\n" +
              "\n" +
              "\"A1\" \"B11\" \"C111\"\n"
              , Output);
  } 
  
  private static final String PrintExpandedTokens_Input =  
          "#define DEFINE_STRUCT(index) struct A { int i##index; \\\n" +
          "};\n" +
          "#define /*c1*/GEN_STRUCT_TWICE DEFINE_STRUCT(1) /*c2*/ DEFINE_STRUCT(2)\n" + 
          "/*c3*/ GEN_STRUCT_TWICE /*c4*/";
  @Test 
  public void PrintExpandedTokens_Comments_LineMarkers_MacroAndMacroComments() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = true;
    opts.ShowLineMarkers = true;
    opts.ShowMacros = true;
    opts.ShowMacroComments = true;    
    string Output = CheckPPOutput(PrintExpandedTokens_Input, opts);
//    System.out.println(Output.toJavaString());
    EXPECT_EQ("# 1 \"\"\n" +
              "# 1 \"<built-in>\" 1\n" +
              "# 1 \"\" 2\n" +
              "#define DEFINE_STRUCT(index) struct A { int i##index; };\n" +
              "\n" +
              "#define GEN_STRUCT_TWICE DEFINE_STRUCT(1) /*c2*/ DEFINE_STRUCT(2)\n" +
              "/*c3*/ struct A { int i1; }; /*c2*/ struct A { int i2; }; /*c4*/\n",
            Output);    
  }
  
  @Test 
  public void PrintExpandedTokens_Comments_LineMarkers_Macros() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = true;
    opts.ShowLineMarkers = true;
    opts.ShowMacros = true;
    opts.ShowMacroComments = false;    
    string Output = CheckPPOutput(PrintExpandedTokens_Input, opts);
//    System.out.println(Output.toJavaString());
    EXPECT_EQ("# 1 \"\"\n" +
              "# 1 \"<built-in>\" 1\n" +
              "# 1 \"\" 2\n" +
              "#define DEFINE_STRUCT(index) struct A { int i##index; };\n" +
              "\n" +
              "#define GEN_STRUCT_TWICE DEFINE_STRUCT(1) DEFINE_STRUCT(2)\n" +
              "/*c3*/ struct A { int i1; }; struct A { int i2; }; /*c4*/\n",
            Output);
  }
  
  @Test 
  public void PrintExpandedTokens_Comments_LineMarkers() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = true;
    opts.ShowLineMarkers = true;
    opts.ShowMacros = false;
    opts.ShowMacroComments = false;    
    string Output = CheckPPOutput(PrintExpandedTokens_Input, opts);
//    System.out.println(Output.toJavaString());
    EXPECT_EQ("# 1 \"\"\n" +
              "# 1 \"<built-in>\" 1\n" +
              "# 1 \"\" 2\n" +
              "\n" +
              "\n" +
              "\n" +
              "/*c3*/ struct A { int i1; }; struct A { int i2; }; /*c4*/\n"
              , Output);
  }
  
  @Test
  public void PrintExpandedTokens_Comments() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = true;
    opts.ShowLineMarkers = false;
    opts.ShowMacros = false;
    opts.ShowMacroComments = false;    
    string Output = CheckPPOutput(PrintExpandedTokens_Input, opts);
//    System.out.println(Output.toJavaString());
    EXPECT_EQ("\n" + 
              "\n" +
              "\n" +
              "/*c3*/ struct A { int i1; }; struct A { int i2; }; /*c4*/\n"
              , Output);
  }
  
  @Test
  public void PrintExpandedTokens() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PreprocessorOutputOptions opts = new PreprocessorOutputOptions();
    opts.ShowCPP = true;
    opts.ShowComments = false;
    opts.ShowLineMarkers = false;
    opts.ShowMacros = false;
    opts.ShowMacroComments = false;    
    string Output = CheckPPOutput(PrintExpandedTokens_Input, opts);
//    System.out.println(Output.toJavaString());
    EXPECT_EQ("\n" +
              "\n" +
              "\n" +
              "       struct A { int i1; }; struct A { int i2; };\n"
              , Output);
  }
  
  @Test
  public void GetMathHTokens() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String path = "/opt/csw/lib/gcc/i386-pc-solaris2.10/4.6.3/include-fixed/math.h";
    if (!new java.io.File(path).exists()) {
      path = "/usr/include/math.h";
    }
    std.vector<Token> toks = CheckLex("#include \"" + path + "\"", null, new AdvancedLexerInitializer());
    int a = 1;
    a++;
  }
  
  @Test
  public void GetSourceTextExpandsAcrossMultipleMacroCalls() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" +
                                       "f(M(M(i)))",
                                       ExpectedTokens);
    EXPECT_EQ("M(M(i))", getSourceText(toks.$at(2), toks.$at(2)));
  }

  @Test
  public void GetSourceTextInMiddleOfMacroArgument() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" +
                                       "M(f(i))",
                                       ExpectedTokens);
    EXPECT_EQ("i", getSourceText(toks.$at(2), toks.$at(2)));
  }

  @Test
  public void GetSourceTextExpandsAroundDifferentMacroCalls() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" + 
                                       "#define C(x) x\n" + 
                                       "f(C(M(i)))",
                                       ExpectedTokens);
    EXPECT_EQ("C(M(i))", getSourceText(toks.$at(2), toks.$at(2)));
  }

  @Test
  public void GetSourceTextOnlyExpandsIfFirstTokenInMacro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" + 
                                       "#define C(x) c x\n" + 
                                       "f(C(M(i)))",
                                       ExpectedTokens);
    EXPECT_EQ("M(i)", getSourceText(toks.$at(3), toks.$at(3)));
  }

  @Test
  public void GetSourceTextExpandsRecursively() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.l_paren);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.r_paren);

    std.vector<Token> toks = CheckLex("#define M(x) x\n" + 
                                       "#define C(x) c M(x)\n" +
                                       "C(f(M(i)))",
                                       ExpectedTokens);
    EXPECT_EQ("M(i)", getSourceText(toks.$at(3), toks.$at(3)));
  }
  
  @Test
  public void LexAPI() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = null;
    try {
      ExpectedTokens/*J*/= new std.vectorUShort/*<tok.TokenKind>*/();
      ExpectedTokens.push_back(tok.TokenKind.l_square);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.r_square);
      ExpectedTokens.push_back(tok.TokenKind.l_square);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.r_square);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.identifier);
      ExpectedTokens.push_back(tok.TokenKind.identifier);      
      
      std.vector<Token> toks = CheckLex("#define M(x) [x]\n" +
                                         "#define N(x) x\n" +
                                         "#define INN(x) x\n" +
                                         "#define NOF1 INN(val)\n" +
                                         "#define NOF2 val\n" +
                                         "M(foo) N([bar])\n" +
                                         "N(INN(val)) N(NOF1) N(NOF2) N(val)",
                                         ExpectedTokens);    
      
      SourceLocation lsqrLoc = toks.$at(0).getLocation();
      SourceLocation idLoc = toks.$at(1).getLocation();
      SourceLocation rsqrLoc = toks.$at(2).getLocation();
      std.pair<SourceLocation, SourceLocation> macroPair = SourceMgr.getExpansionRange(lsqrLoc);
      SourceRange macroRange = new SourceRange(macroPair.first, macroPair.second);
      
      SourceLocation Loc/*J*/= new SourceLocation();     
      
      EXPECT_TRUE(Lexer.isAtStartOfMacroExpansion(lsqrLoc, SourceMgr, LangOpts, $AddrOf(Loc)));
      EXPECT_EQ(Loc, macroRange.getBegin());
      EXPECT_FALSE(Lexer.isAtStartOfMacroExpansion(idLoc, SourceMgr, LangOpts));
      EXPECT_FALSE(Lexer.isAtEndOfMacroExpansion(idLoc, SourceMgr, LangOpts));
      EXPECT_TRUE(Lexer.isAtEndOfMacroExpansion(rsqrLoc, SourceMgr, LangOpts, Loc));
      EXPECT_EQ(Loc, macroRange.getEnd());   
      
      CharSourceRange range = Lexer.makeFileCharRange(
               CharSourceRange.getTokenRange(lsqrLoc, idLoc), SourceMgr, LangOpts);
      EXPECT_TRUE(range.isInvalid());
      range = Lexer.makeFileCharRange(CharSourceRange.getTokenRange(idLoc, rsqrLoc),
                                       SourceMgr, LangOpts);
      EXPECT_TRUE(range.isInvalid());
      range = Lexer.makeFileCharRange(CharSourceRange.getTokenRange(lsqrLoc, rsqrLoc),
                                       SourceMgr, LangOpts);
      EXPECT_TRUE(!range.isTokenRange());
      EXPECT_EQ(range.getAsRange(),
                new SourceRange(macroRange.getBegin(),
                            macroRange.getEnd().getLocWithOffset(1)));

      StringRef text = Lexer.getSourceText(
                                   CharSourceRange.getTokenRange(lsqrLoc, rsqrLoc),
                                   SourceMgr, LangOpts);
      EXPECT_EQ(text, "M(foo)");      
      
      SourceLocation macroLsqrLoc = toks.$at(3).getLocation();
      SourceLocation macroIdLoc = toks.$at(4).getLocation();
      SourceLocation macroRsqrLoc = toks.$at(5).getLocation();
      SourceLocation fileLsqrLoc = SourceMgr.getSpellingLoc(macroLsqrLoc);
      SourceLocation fileIdLoc = SourceMgr.getSpellingLoc(macroIdLoc);
      SourceLocation fileRsqrLoc = SourceMgr.getSpellingLoc(macroRsqrLoc);      
      

      range = Lexer.makeFileCharRange(
          CharSourceRange.getTokenRange(macroLsqrLoc, macroIdLoc),
          SourceMgr, LangOpts);
      EXPECT_EQ(new SourceRange(fileLsqrLoc, fileIdLoc.getLocWithOffset(3)),
                range.getAsRange());

      range = Lexer.makeFileCharRange(CharSourceRange.getTokenRange(macroIdLoc, macroRsqrLoc),
                                       SourceMgr, LangOpts);
      EXPECT_EQ(new SourceRange(fileIdLoc, fileRsqrLoc.getLocWithOffset(1)),
                range.getAsRange());

      macroPair = SourceMgr.getExpansionRange(macroLsqrLoc);
      range = Lexer.makeFileCharRange(
                         CharSourceRange.getTokenRange(macroLsqrLoc, macroRsqrLoc),
                         SourceMgr, LangOpts);
      EXPECT_EQ(new SourceRange(macroPair.first, macroPair.second.getLocWithOffset(1)),
                range.getAsRange());

      text = Lexer.getSourceText(
              CharSourceRange.getTokenRange(new SourceRange(macroLsqrLoc, macroIdLoc)),
              SourceMgr, LangOpts);
      EXPECT_EQ(text, "[bar");      
      
    } finally {
      if (ExpectedTokens != null) { ExpectedTokens.$destroy(); }
    }
  }
  
  @Test
  public void TestMultiLinePPDirective() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);

    std.vector<Token> toks = CheckLex(
        "#if defined(__SMTH__) || \\\n !defined(__ATTRIBUTE_DISABLED)\n" + 
        "int x;\n" +
        "#endif", 
        ExpectedTokens
    );

    EXPECT_EQ("int x;", getSourceText(toks.$at(0), toks.$at(2)));
  }   
  
  /*************************************************************************
   * Java tests                                                            * 
   *************************************************************************/
  
  @Test 
  public void TestBug0001() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens/*J*/= new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    std.vector<Token> toks = CheckLex(
            "#define MAC1 A\n" +
            "#define MAC2 B\n" +
            "#define MAC1MAC2 A_B\n" +
            "#define MAC3(x, y) x ## y\n" +
            "#define MAC4(x, y) MAC3(x, y)\n" +
            "// this one expands to AB !!!\n" +
            "int MAC4(MAC1, MAC2); ", 
            ExpectedTokens
    );
    IdentifierInfo ident = toks.$at(1).getIdentifierInfo();
    EXPECT_EQ("AB", Native.$toString(ident.getNameStart(), ident.getLength()));
  }
  
  @Test
  public void TestBug0002() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Interesting case - strings 'v2' and 'tt' have equal hash codes in string map.
    
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens/*J*/= new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    vector<Token> tokens = CheckLex(
            "int v2;\n" +
            "int tt;",
            ExpectedTokens
    );
    Token tokId1 = tokens.$at(1);
    Token tokId2 = tokens.$at(4);
    IdentifierInfo id1 = tokId1.getIdentifierInfo();
    IdentifierInfo id2 = tokId2.getIdentifierInfo();
    EXPECT_EQ("v2", Native.$toString(id1.getNameStart(), id1.getLength()));
    EXPECT_EQ("tt", Native.$toString(id2.getNameStart(), id2.getLength()));
  }
  
  @Test
  public void TestBug0003() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);

    std.vector<Token> toks = CheckLex(
        "#if '\\n' == 0x0A && ' ' == 0x20 && '0' == 0x30 \\\n" +
        "   && 'A' == 0x41 && 'a' == 0x61 && '!' == 0x21\n" + 
        "int ascii_host;\n" +
        "#endif", 
        ExpectedTokens
    );

    EXPECT_EQ("int ascii_host;", getSourceText(toks.$at(0), toks.$at(2)));
  }   
  
  @Test
  public void TestBug0004() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);

    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);

    std.vector<Token> toks = CheckLex(
        "#  define SIZE_MAX_VAL              (18446744073709551615UL)\n" +
        "#  define UINTPTR_MAX_VAL           (18446744073709551615UL)\n" +
        "#if (SIZE_MAX_VAL != UINTPTR_MAX_VAL)\n" +
        "int different;\n" +
        "#else\n" +
        "int equal;\n" +
        "#endif\n" +
        "\n" +
        "#if (SIZE_MAX_VAL == UINTPTR_MAX_VAL)\n" +
        "int equal2;\n" +
        "#else\n" +
        "int different2;\n" +
        "#endif", 
        ExpectedTokens
    );

    EXPECT_EQ("int equal;", getSourceText(toks.$at(0), toks.$at(2)));
    EXPECT_EQ("int equal2;", getSourceText(toks.$at(3), toks.$at(5)));
  } 
  
  @Test
  public void TestBug0005() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    // This is fixed manually in TokenLexer.PasteTokens
    std.vector<Token> toks = CheckLex(
              "#define macro_concat255481(x, y) x ## y\n"
            + "int macro_concat255481(a, b);\n"
            + "int macro_concat255481(e, /**/ f);\n",
            ExpectedTokens, new KeepCommentsLexerInitializer()
    );

    IdentifierInfo ident = toks.$at(1).getIdentifierInfo();
    EXPECT_EQ("ab", Native.$toString(ident.getNameStart(), ident.getLength()));
    ident = toks.$at(4).getIdentifierInfo();
    EXPECT_EQ("ef", Native.$toString(ident.getNameStart(), ident.getLength()));
  } 
  
  @Test
  public void TestIZ_256630() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    std.vector<Token> toks = CheckLex(
      "#if 5 >> 1 != 2 || 5 >> -2 != 20 || -5 >> 1 != -3\n" +
      "# error		/* { dg-bogus error }  */\n" + 
      "#endif\n" +
      "int x;",
      ExpectedTokens, new KeepCommentsLexerInitializer());
  }
  
  @Test
  public void TestIZ_256626() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    std.vector<Token> toks = CheckLex(
      "#pragma message \"\n",
      ExpectedTokens, new KeepCommentsLexerInitializer());
  }

  @Test
  public void TestIZ_257133() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    std.vector<Token> toks = CheckLex(
      "#pragma message \" \n ",
      ExpectedTokens, new KeepCommentsLexerInitializer());    
  }

  @Test
  public void TestIZ_257133_2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    std.vector<Token> toks = CheckLex(
      "#pragma message \" \n " + 
      "int a;",
      ExpectedTokens, new KeepCommentsLexerInitializer());    
  }

  @Test
  public void TestIZ_257133_3() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    boolean oldCpp11 = LangOpts.CPlusPlus11;
    LangOpts.CPlusPlus11 = true;
    try {
      std.vector<Token> toks = CheckLex(
        "#pragma message R\"delim( )delim )delim )delim\"\n",
        ExpectedTokens, new KeepCommentsLexerInitializer());    
    } finally {
      LangOpts.CPlusPlus11 = oldCpp11;
    }
  }
  
  @Test
  public void TestIZ_256628() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    CheckLex(
      "#if 'x\n" +
      "#endif\n",
      ExpectedTokens, new KeepCommentsLexerInitializer());
  }  

  @Test
  public void TestBug0006() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.comment);
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    ExpectedTokens.push_back(tok.TokenKind.comment);
    // This is fixed manually in Lexer.SkipBlockComment
    std.vector<Token> toks = CheckLex(
              "/*\n"
            + " */#ifndef QQ\n"
            + "int x215640;\n"
            + "/**\n"
            + "*/#endif\n"
            + "",
        ExpectedTokens, new KeepCommentsLexerInitializer()
    );

    EXPECT_EQ("int x215640;", getSourceText(toks.$at(1), toks.$at(3)));
  } 

  @Test
  public void TestBug0007() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.comment);
    ExpectedTokens.push_back(tok.TokenKind.comment);
    // This is fixed manually in Lexer.SkipBlockComment
    std.vector<Token> toks = CheckLex(
              "/*comment1\n"
            + " */#ifdef QQ\n"
            + "int x215640;\n"
            + "/**\n"
            + "*/#endif\n"
            + "/*comment2*/",
        ExpectedTokens, new KeepCommentsLexerInitializer()
    );
    EXPECT_EQ("/*comment1\n"
            + " */", getSourceText(toks.$at(0), toks.$at(0)));
    EXPECT_EQ("/*comment2*/", getSourceText(toks.$at(1), toks.$at(1)));
  } 
  
  @Test
  public void TestBug267334() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.vectorUShort/*<tok.TokenKind>*/ ExpectedTokens = new std.vectorUShort/*<tok.TokenKind>*/();
    ExpectedTokens.push_back(tok.TokenKind.kw_int);
    ExpectedTokens.push_back(tok.TokenKind.identifier);
    ExpectedTokens.push_back(tok.TokenKind.equal);
    ExpectedTokens.push_back(tok.TokenKind.numeric_constant);
    ExpectedTokens.push_back(tok.TokenKind.semi);
    // This is fixed manually in Lexer.SkipBlockComment
    std.vector<Token> toks = CheckLex(
        "#define AAA(x) x\n" +
        "int x = AAA(\n" +
        "#if AAA(5) == 5\n" +
        " 1\n" +
        "#else\n" +
        " err\n" +
        "#endif \n" +
        ");",
        ExpectedTokens, new KeepCommentsLexerInitializer()
    );
  }

  private static interface LexerInitializer {
    
    HeaderSearch createHeaderSearch();
    
    Preprocessor createPreprocessor(HeaderSearch headerInfo, ModuleLoader modLoader);
    
  }
  
  private class DefaultLexerInitializer implements LexerInitializer {

    @Override
    public HeaderSearch createHeaderSearch() {
      return new HeaderSearch(new IntrusiveRefCntPtr<HeaderSearchOptions>(createHeaderSearchOptions()), SourceMgr, Diags, LangOpts, Target.get());
    }

    @Override
    public Preprocessor createPreprocessor(HeaderSearch HeaderInfo, ModuleLoader ModLoader) {
      Preprocessor PP = new Preprocessor(new IntrusiveRefCntPtr<PreprocessorOptions>(createPreprocessorOptions()), Diags, LangOpts, SourceMgr, HeaderInfo, ModLoader, null, false);
      PP.Initialize(Target.$star());
      return PP;
    }
    
    protected HeaderSearchOptions createHeaderSearchOptions() {
        HeaderSearchOptions HSOpts = new HeaderSearchOptions();
        HSOpts.UseBuiltinIncludes = false;
        HSOpts.UseLibcxx = false;
        HSOpts.UseStandardCXXIncludes = false;
        HSOpts.UseStandardSystemIncludes = false;
        return HSOpts;
    }
    
    protected PreprocessorOptions createPreprocessorOptions() {
        PreprocessorOptions out = new PreprocessorOptions();
        out.UsePredefines = false;
        return out;
    }
  }

  private class KeepCommentsLexerInitializer extends DefaultLexerInitializer {

    @Override
    public Preprocessor createPreprocessor(HeaderSearch HeaderInfo, ModuleLoader ModLoader) {
      Preprocessor PP = super.createPreprocessor(HeaderInfo, ModLoader);
      PP.SetCommentRetentionState(true, true);
      return PP;
    }
  }
  
  private class AdvancedLexerInitializer extends DefaultLexerInitializer {

    @Override
    public HeaderSearch createHeaderSearch() {
      HeaderSearch hs = super.createHeaderSearch();
      addHeaderSearchPath(hs, "/usr/include");
      return hs;
    }
    
    @Override
    protected HeaderSearchOptions createHeaderSearchOptions() {
      HeaderSearchOptions options = super.createHeaderSearchOptions();
      options.AddSystemHeaderPrefix(new StringRef("/usr/include/"), true);
      return options;
    }
    
    private void addHeaderSearchPath(HeaderSearch HeaderInfo, String SearchPath) {
      // Add header's parent path to search path.
      /*const*/DirectoryEntry /*P*/ DE = FileMgr.getDirectory(new StringRef(SearchPath));
      DirectoryLookup DL/*J*/= new DirectoryLookup(DE, SrcMgr.CharacteristicKind.C_System, false);
      HeaderInfo.AddSearchPath(DL, true);
    }    
  }
  
  private static interface LexerResultHandler {
    
    void handle(Preprocessor PP, std.vector<Token> tokens);
  }
  
  private static class DumpTokensHandler implements LexerResultHandler {
    
    private final PrintStream stream;
    
    private final std.string buffer = new std.string();
    
    public DumpTokensHandler() {
      this(null);
    }
    
    public DumpTokensHandler(PrintStream stream) {
      this.stream = stream;
    }

    public string getBuffer() {
      return buffer;
    }

    @Override
    public void handle(Preprocessor PP, vector<Token> tokens) {
      raw_string_ostream stringStream = new raw_string_ostream(buffer);
      for (Token tok : tokens) {
        PP.DumpToken(tok, false, stringStream);
        stringStream.$out("\n");
      }
      stringStream.flush();
      if (stream != null) {
        stream.println(buffer.toJavaString());
      }
    }
  }
}
