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

import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.junit.Test;


// PPCallbacks test fixture.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 110,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest")
//</editor-fold>
public class PPCallbacksTest extends /*public*/ /*::*/ADTSupportTestBase implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::PPCallbacksTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 112,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::PPCallbacksTest")
  //</editor-fold>
  public PPCallbacksTest() {
    /* : ::Test(), FileMgrOpts(), FileMgr(FileMgrOpts), DiagID(new DiagnosticIDs()), DiagOpts(new DiagnosticOptions()), Diags(DiagID, DiagOpts.getPtr(), new IgnoringDiagConsumer()), SourceMgr(Diags, FileMgr), LangOpts(), TargetOpts(), Target()*/ 
    //START JInit
    super(TestState.Successful);
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
    TargetOpts.$arrow().Triple.$assign($("x86_64-apple-darwin11.1.0"));
    Target.$assign(new IntrusiveRefCntPtr<TargetInfo>(TargetInfo.CreateTargetInfo(Diags, TargetOpts)));
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
  
// Stub to collect data from InclusionDirective callbacks.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InclusionDirectiveCallbacks">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 51,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::InclusionDirectiveCallbacks")
//</editor-fold>
public class InclusionDirectiveCallbacks extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InclusionDirectiveCallbacks::InclusionDirective">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 53,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::InclusionDirectiveCallbacks::InclusionDirective")
  //</editor-fold>
  @Override public void InclusionDirective(SourceLocation HashLoc, SourceLocation EodLoc, /*const*/Token /*&*/ IncludeTok, StringRef FileName, boolean IsAngled, CharSourceRange FilenameRange, /*const*/FileEntry /*P*/ File, StringRef SearchPath, StringRef RelativePath, /*const*/Module /*P*/ Imported) {
    this.HashLoc.$assign(HashLoc);
    this.IncludeTok.$assign(IncludeTok);
    this.FileName.$assign(FileName);
    this.IsAngled = IsAngled;
    this.FilenameRange.$assign(FilenameRange);
    this.File = File;
    this.SearchPath.$assign(SearchPath);
    this.RelativePath.$assign(RelativePath);
    this.Imported = Imported;
  }

  public SourceLocation HashLoc;
  public Token IncludeTok;
  public SmallString/*16*/ FileName;
  public boolean IsAngled;
  public CharSourceRange FilenameRange;
  public /*const*/FileEntry /*P*/ File;
  public SmallString/*16*/ SearchPath;
  public SmallString/*16*/ RelativePath;
  public /*const*/Module /*P*/ Imported;
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InclusionDirectiveCallbacks::~InclusionDirectiveCallbacks">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 51,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::InclusionDirectiveCallbacks::~InclusionDirectiveCallbacks")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::InclusionDirectiveCallbacks::InclusionDirectiveCallbacks">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 51,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::InclusionDirectiveCallbacks::InclusionDirectiveCallbacks")
  //</editor-fold>
  public /*inline*/ InclusionDirectiveCallbacks() {
    /* : PPCallbacks(), HashLoc(), IncludeTok(), FileName(), FilenameRange(), SearchPath(), RelativePath()*/ 
    //START JInit
    super();
    this.HashLoc = new SourceLocation();
    this.IncludeTok = new Token();
    this.FileName = new SmallString(16);
    this.FilenameRange = new CharSourceRange();
    this.SearchPath = new SmallString(16);
    this.RelativePath = new SmallString(16);
    //END JInit
  }

}  
  // JAVA: use LexerTestSupport
  private void PrepareMainFileWithContent(char$ptr SourceText) {
    // prepare FileEntry for source content
    LexerTestSupport.PrepareMainFileWithContent(getTestMethodName(), FileMgr, SourceMgr, new StringRef(SourceText));
  }
  
  // Register a header path as a known file and add its location
  // to search path.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::AddFakeHeader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 135,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::AddFakeHeader")
  //</editor-fold>
  protected void AddFakeHeader(HeaderSearch /*&*/ HeaderInfo, /*const*/char$ptr/*char P*/ HeaderPath, boolean IsSystemHeader) {
    // JAVA: moved to LexerTestSupport
    LexerTestSupport.AddFakeHeader(FileMgr, SourceMgr, HeaderInfo, HeaderPath, StringRef.R$SPACE, IsSystemHeader);
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

  
  // Run lexer over SourceText and collect FilenameRange from
  // the InclusionDirective callback.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::InclusionDirectiveFilenameRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 157,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::InclusionDirectiveFilenameRange")
  //</editor-fold>
  protected CharSourceRange InclusionDirectiveFilenameRange(/*const*/String/*char P*/ __SourceText, /*const*/String/*char P*/ __HeaderPath, boolean SystemHeader) {
    /*const*/char$ptr/*char P*/ SourceText = create_char$ptr(__SourceText);
    /*const*/char$ptr/*char P*/ HeaderPath = create_char$ptr(__HeaderPath);
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    try {
      // JAVA: use LexerTestSupport
      PrepareMainFileWithContent(SourceText);

      ModLoader/*J*/= $track(new VoidModuleLoader());
      
      IntrusiveRefCntPtr<HeaderSearchOptions> HSOpts = new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions());
      HeaderInfo/*J*/= $track(new HeaderSearch(HSOpts, SourceMgr, Diags, LangOpts, Target.get()));
      AddFakeHeader(HeaderInfo, HeaderPath, SystemHeader);
      
      IntrusiveRefCntPtr<PreprocessorOptions> PPOpts = new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions());
      PP/*J*/= $track(new Preprocessor(PPOpts, Diags, LangOpts, SourceMgr, HeaderInfo, ModLoader, null, false));
      PP.Initialize(Target.$star());
      InclusionDirectiveCallbacks /*P*/ Callbacks = new InclusionDirectiveCallbacks();
      PP.addPPCallbacks(new std.unique_ptr(Callbacks)); // Takes ownership.
      
      // Lex source text.
      PP.EnterMainSourceFile();
      while (true) {
        Token Tok/*J*/= new Token();
        PP.Lex(Tok);
        if (Tok.is(tok.TokenKind.eof)) {
          break;
        }
      }
      
      // Callbacks have been executed at this point -- return filename range.
      return Callbacks.FilenameRange;
    } finally {
    }
  }
  
  

//  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::PragmaOpenCLExtensionCall">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 193,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=<anonymous namespace>::PPCallbacksTest::PragmaOpenCLExtensionCall")
//  //</editor-fold>
//  protected PragmaOpenCLExtensionCallbacks.CallbackParameters PragmaOpenCLExtensionCall(/*const*/char$ptr/*char P*/ SourceText) {
//    LangOptions OpenCLLangOpts = null;
//    VoidModuleLoader ModLoader = null;
//    HeaderSearch HeaderInfo = null;
//    Preprocessor PP = null;
//    ASTContext Context = null;
//    ASTConsumer Consumer = null;
//    Sema S = null;
//    Parser P = null;
//    try {
//      OpenCLLangOpts/*J*/= new LangOptions();
//      OpenCLLangOpts.OpenCL = true;
//      
//      MemoryBuffer /*P*/ sourceBuf = MemoryBuffer.getMemBuffer(new StringRef(SourceText), new StringRef("test.cl"));
//      (void)SourceMgr.createMainFileIDForMemBuffer(sourceBuf);
//      
//      ModLoader/*J*/= new VoidModuleLoader();
//      HeaderInfo/*J*/= new HeaderSearch(new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions()), SourceMgr, Diags, OpenCLLangOpts, Target.getPtr());
//      
//      PP/*J*/= new Preprocessor(new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions()), Diags, OpenCLLangOpts, Target.getPtr(), SourceMgr, HeaderInfo, ModLoader, null, false, false);
//      
//      // parser actually sets correct pragma handlers for preprocessor
//      // according to LangOptions, so we init Parser to register opencl
//      // pragma handlers
//      Context/*J*/= new ASTContext(OpenCLLangOpts, SourceMgr, Target.getPtr(), PP.getIdentifierTable(), PP.getSelectorTable(), PP.getBuiltinInfo(), 0);
//      Consumer/*J*/= new ASTConsumer();
//      S/*J*/= new Sema(PP, Context, Consumer);
//      P/*J*/= new Parser(PP, S, false);
//      PragmaOpenCLExtensionCallbacks /*P*/ Callbacks = new PragmaOpenCLExtensionCallbacks();
//      PP.addPPCallbacks(Callbacks); // Takes ownership.
//      
//      // Lex source text.
//      PP.EnterMainSourceFile();
//      while (true) {
//        Token Tok/*J*/= new Token();
//        PP.Lex(Tok);
//        if (Tok.is(tok.TokenKind.eof)) {
//          break;
//        }
//      }
//      
//      PragmaOpenCLExtensionCallbacks.CallbackParameters RetVal = new PragmaOpenCLExtensionCallbacks.CallbackParameters(
//        Callbacks.Name, 
//        Callbacks.State
//      );
//      return RetVal;
//    } finally {
//      if (P != null) { P.$destroy(); }
//      if (S != null) { S.$destroy(); }
//      if (Consumer != null) { Consumer.$destroy(); }
//      if (Context != null) { Context.$destroy(); }
//      if (PP != null) { PP.$destroy(); }
//      if (HeaderInfo != null) { HeaderInfo.$destroy(); }
//      if (ModLoader != null) { ModLoader.$destroy(); }
//      if (OpenCLLangOpts != null) { OpenCLLangOpts.$destroy(); }
//    }
//  }

  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::~PPCallbacksTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 110,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::~PPCallbacksTest")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  @Test
  public void QuotedFilename() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =
      "#include \"quoted.h\"\n";

    CharSourceRange Range =
      InclusionDirectiveFilenameRange(Source, "/quoted.h", false);

    ASSERT_EQ("\"quoted.h\"", GetSourceString(Range));    
  }
  
  @Test
  public void AngledFilename() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =
      "#include <angled.h>\n";

    CharSourceRange Range =
      InclusionDirectiveFilenameRange(Source, "/angled.h", true);

    ASSERT_EQ("<angled.h>", GetSourceString(Range)); 
  }  
  
  @Test
  public void QuotedInMacro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  String Source =
    "#define MACRO_QUOTED \"quoted.h\"\n" +
    "#include MACRO_QUOTED\n";

  CharSourceRange Range =
    InclusionDirectiveFilenameRange(Source, "/quoted.h", false);

  ASSERT_EQ("\"quoted.h\"", GetSourceString(Range));
}

  @Test
  public void AngledInMacro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =
      "#define MACRO_ANGLED <angled.h>\n" +
      "#include MACRO_ANGLED\n";

    CharSourceRange Range =
      InclusionDirectiveFilenameRange(Source, "/angled.h", true);

    ASSERT_EQ("<angled.h>", GetSourceString(Range));
  }  
  
  @Test
  public void StringizedMacroArgument() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =
      "#define MACRO_STRINGIZED(x) #x\n" +
      "#include MACRO_STRINGIZED(quoted.h)\n";

    CharSourceRange Range =
      InclusionDirectiveFilenameRange(Source, "/quoted.h", false);

    ASSERT_EQ("\"quoted.h\"", GetSourceString(Range));
  }

  @Test
  public void ConcatenatedMacroArgument() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String Source =
      "#define MACRO_ANGLED <angled.h>\n" +
      "#define MACRO_CONCAT(x, y) x ## _ ## y\n" +
      "#include MACRO_CONCAT(MACRO, ANGLED)\n";

    CharSourceRange Range =
      InclusionDirectiveFilenameRange(Source, "/angled.h", false);

    ASSERT_EQ("<angled.h>", GetSourceString(Range));
  }

  @Test
  public void TrigraphFilename() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  String Source =
    "#include \"tri??-graph.h\"\n";

  CharSourceRange Range =
    InclusionDirectiveFilenameRange(Source, "/tri~graph.h", false);

  ASSERT_EQ("\"tri??-graph.h\"", GetSourceString(Range));
}

  @Test
  public void TrigraphInMacro() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  String Source =
    "#define MACRO_TRIGRAPH \"tri??-graph.h\"\n" +
    "#include MACRO_TRIGRAPH\n";

  CharSourceRange Range =
    InclusionDirectiveFilenameRange(Source, "/tri~graph.h", false);

  ASSERT_EQ("\"tri??-graph.h\"", GetSourceString(Range));
}

//  @Test
//  public void OpenCLExtensionPragmaEnabled() {
//  String Source =
//    "#pragma OPENCL EXTENSION cl_khr_fp64 : enable\n";
//
//  PragmaOpenCLExtensionCallbacks::CallbackParameters Parameters =
//    PragmaOpenCLExtensionCall(Source);
//
//  ASSERT_EQ("cl_khr_fp64", Parameters.Name);
//  unsigned ExpectedState = 1;
//  ASSERT_EQ(ExpectedState, Parameters.State);
//}

//  @Test
//  public void OpenCLExtensionPragmaDisabled() {
//  String Source =
//    "#pragma OPENCL EXTENSION cl_khr_fp16 : disable\n";
//
//  PragmaOpenCLExtensionCallbacks::CallbackParameters Parameters =
//    PragmaOpenCLExtensionCall(Source);
//
//  ASSERT_EQ("cl_khr_fp16", Parameters.Name);
//  unsigned ExpectedState = 0;
//  ASSERT_EQ(ExpectedState, Parameters.State);
//}    
}
