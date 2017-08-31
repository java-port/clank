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
import org.clang.basic.tok.TokenKind;
import org.clang.lex.*;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.junit.Test;
import org.llvm.adt.*;


// The test fixture.
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPConditionalDirectiveRecordTest">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPConditionalDirectiveRecordTest.cpp", line = 32,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPConditionalDirectiveRecordTest.cpp -filter=__anonymous_namespace::PPConditionalDirectiveRecordTest")
//</editor-fold>
public class PPConditionalDirectiveRecordTest extends /*public*/ /*::*/ADTSupportTestBase implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPConditionalDirectiveRecordTest::PPConditionalDirectiveRecordTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPConditionalDirectiveRecordTest.cpp", line = 34,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPConditionalDirectiveRecordTest.cpp -filter=__anonymous_namespace::PPConditionalDirectiveRecordTest::PPConditionalDirectiveRecordTest")
  //</editor-fold>
  public PPConditionalDirectiveRecordTest() {
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
    TargetOpts.$arrow().Triple.$assign($("x86_64-apple-darwin11.1.0"));
    Target.$assign(new IntrusiveRefCntPtr<TargetInfo>(TargetInfo.CreateTargetInfo(Diags, TargetOpts)));
  }

  protected FileSystemOptions FileMgrOpts;
  protected FileManager FileMgr;
  protected IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
  protected DiagnosticsEngine Diags;
  protected SourceManager SourceMgr;
  protected LangOptions LangOpts;
  protected std.shared_ptr<TargetOptions> TargetOpts;
  protected IntrusiveRefCntPtr<TargetInfo> Target;
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPConditionalDirectiveRecordTest::~PPConditionalDirectiveRecordTest">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPConditionalDirectiveRecordTest.cpp", line = 32,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPConditionalDirectiveRecordTest.cpp -filter=__anonymous_namespace::PPConditionalDirectiveRecordTest::~PPConditionalDirectiveRecordTest")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  // JAVA: use LexerTestSupport
  private void PrepareMainFileWithContent(String Source) {
    LexerTestSupport.PrepareMainFileWithContent(getTestMethodName(), FileMgr, SourceMgr, new StringRef(Source));
  }
  
  @Test
  public void PPRecAPI() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    std.vector<Token> toks = null;
    try {
      /*const*/String/*char P*/ source = "0 1\n#if 1\n2\n#ifndef BB\n3 4\n#else\n#endif\n5\n#endif\n6\n#if 1\n7\n#if 1\n#endif\n8\n#endif\n9\n";
      // JAVA: use LexerTestSupport
      PrepareMainFileWithContent(source);

      ModLoader/*J*/= new VoidModuleLoader();
      HeaderInfo/*J*/= new HeaderSearch(new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions()), SourceMgr, Diags, LangOpts, Target.get());
      PP/*J*/= new Preprocessor(new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions()), Diags, LangOpts, SourceMgr, HeaderInfo, ModLoader, null, false);
      PP.Initialize(Target.$star());
      PPConditionalDirectiveRecord /*P*/ PPRec = new PPConditionalDirectiveRecord(SourceMgr);
      PP.addPPCallbacks(new std.unique_ptr(PPRec));
      PP.EnterMainSourceFile();
      
      toks/*J*/= new std.vector<Token>((Token) null);
      while (true) {
        Token tok/*J*/= new Token();
        PP.Lex(tok);
        if (tok.is(TokenKind.eof)) {
          break;
        }
        toks.push_back(tok);
      }


  // Make sure we got the tokens that we expected.
  ASSERT_EQ(10L, toks.size());
  
  EXPECT_FALSE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(0).getLocation(), toks.$at(1).getLocation())));
  EXPECT_TRUE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(0).getLocation(), toks.$at(2).getLocation())));
  EXPECT_FALSE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(3).getLocation(), toks.$at(4).getLocation())));
  EXPECT_TRUE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(1).getLocation(), toks.$at(5).getLocation())));
  EXPECT_TRUE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(2).getLocation(), toks.$at(6).getLocation())));
  EXPECT_FALSE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(2).getLocation(), toks.$at(5).getLocation())));
  EXPECT_FALSE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(0).getLocation(), toks.$at(6).getLocation())));
  EXPECT_TRUE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(2).getLocation(), toks.$at(8).getLocation())));
  EXPECT_FALSE(PPRec.rangeIntersectsConditionalDirective(
                    new SourceRange(toks.$at(0).getLocation(), toks.$at(9).getLocation())));

  EXPECT_TRUE(PPRec.areInDifferentConditionalDirectiveRegion(
                    toks.$at(0).getLocation(), toks.$at(2).getLocation()));
  EXPECT_FALSE(PPRec.areInDifferentConditionalDirectiveRegion(
                    toks.$at(3).getLocation(), toks.$at(4).getLocation()));
  EXPECT_TRUE(PPRec.areInDifferentConditionalDirectiveRegion(
                    toks.$at(1).getLocation(), toks.$at(5).getLocation()));
  EXPECT_TRUE(PPRec.areInDifferentConditionalDirectiveRegion(
                    toks.$at(2).getLocation(), toks.$at(0).getLocation()));
  EXPECT_FALSE(PPRec.areInDifferentConditionalDirectiveRegion(
                    toks.$at(4).getLocation(), toks.$at(3).getLocation()));
  EXPECT_TRUE(PPRec.areInDifferentConditionalDirectiveRegion(
                    toks.$at(5).getLocation(), toks.$at(1).getLocation()));

    } finally {
      if (toks != null) { toks.$destroy(); }
      if (PP != null) { PP.$destroy(); }
      if (HeaderInfo != null) { HeaderInfo.$destroy(); }
      if (ModLoader != null) { ModLoader.$destroy(); }
    }

}  
}
