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

package org.clang.basic;

import static org.clank.support.Native.$AddrOf;
import org.clang.lex.llvm.ModuleIdPath;
import org.clang.basic.tok.TokenKind;
import org.clang.lex.*;
import org.junit.Test;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.lex.spi.GlobalModuleIndexImplementation;


//<editor-fold defaultstate="collapsed" desc="static type SourceManagerTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -test=SourceManagerTest")
//</editor-fold>
public final class SourceManagerTest extends ADTSupportTestBase {

//JAVA: using namespace llvm
//JAVA: using namespace clang
//JAVA: namespace (anonymous) {

// The test fixture.
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceManagerTest::SourceManagerTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 33,
   FQN="(anonymous namespace)::SourceManagerTest::SourceManagerTest", NM="_ZN12_GLOBAL__N_117SourceManagerTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_117SourceManagerTestC1Ev")
  //</editor-fold>
  public SourceManagerTest() {
    /* : ::Test(), FileMgrOpts(), FileMgr(FileMgrOpts), DiagID(new DiagnosticIDs()), Diags(DiagID, new DiagnosticOptions, new IgnoringDiagConsumer()), SourceMgr(Diags, FileMgr), LangOpts(), TargetOpts(new TargetOptions), Target()*/ 
    //START JInit
    super();
    this.FileMgrOpts = new FileSystemOptions();
    this.FileMgr = new FileManager(FileMgrOpts);
    this.DiagID = new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
    this.Diags = new DiagnosticsEngine(DiagID, new DiagnosticOptions(), new IgnoringDiagConsumer());
    this.SourceMgr = new SourceManager(Diags, FileMgr);
    this.LangOpts = new LangOptions();
    this.TargetOpts = new std.shared_ptr<TargetOptions>(new TargetOptions());
    this.Target = new IntrusiveRefCntPtr<TargetInfo>();
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      TargetOpts.$arrow().Triple.$assign(/*KEEP_STR*/"x86_64-apple-darwin11.1.0");
      $c$.clean(Target.$assign($c$.track(new IntrusiveRefCntPtr<TargetInfo>(TargetInfo.CreateTargetInfo(Diags, TargetOpts)))));
    } finally {
      $c$.$destroy();
    }
  }

  
  protected FileSystemOptions FileMgrOpts;
  protected FileManager FileMgr;
  protected IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
  protected DiagnosticsEngine Diags;
  protected SourceManager SourceMgr;
  protected LangOptions LangOpts;
  protected std.shared_ptr<TargetOptions> TargetOpts;
  protected IntrusiveRefCntPtr<TargetInfo> Target;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceManagerTest::~SourceManagerTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 31,
   FQN="(anonymous namespace)::SourceManagerTest::~SourceManagerTest", NM="_ZN12_GLOBAL__N_117SourceManagerTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_117SourceManagerTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Target.$destroy();
    TargetOpts.$destroy();
    LangOpts.$destroy();
    SourceMgr.$destroy();
    Diags.$destroy();
    DiagID.$destroy();
    FileMgr.$destroy();
    FileMgrOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "FileMgrOpts=" + FileMgrOpts // NOI18N
              /* STACKOVERFLOW: NEVER PRINT FileManager + ", FileMgr=" + FileMgr // NOI18N */
              + ", DiagID=" + DiagID // NOI18N
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diags=" + Diags // NOI18N*/
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", LangOpts=" + LangOpts // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", Target=" + Target // NOI18N
              + super.toString(); // NOI18N
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 53,
   FQN="(anonymous namespace)::VoidModuleLoader", NM="_ZN12_GLOBAL__N_116VoidModuleLoaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoaderE")
  //</editor-fold>
  public static class VoidModuleLoader extends /*public*/ ModuleLoader implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader::loadModule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 54,
     FQN="(anonymous namespace)::VoidModuleLoader::loadModule", NM="_ZN12_GLOBAL__N_116VoidModuleLoader10loadModuleEN5clang14SourceLocationEN4llvm8ArrayRefISt4pairIPNS1_14IdentifierInfoES2_EEENS1_6Module18NameVisibilityKindEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoader10loadModuleEN5clang14SourceLocationEN4llvm8ArrayRefISt4pairIPNS1_14IdentifierInfoES2_EEENS1_6Module18NameVisibilityKindEb")
    //</editor-fold>
    @Override public/*private*/ ModuleLoadResult loadModule(SourceLocation ImportLoc, 
              ModuleIdPath Path, 
              Module.NameVisibilityKind Visibility, 
              boolean IsInclusionDirective)/* override*/ {
      return new ModuleLoadResult();
    }


    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader::makeModuleVisible">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 61,
     FQN="(anonymous namespace)::VoidModuleLoader::makeModuleVisible", NM="_ZN12_GLOBAL__N_116VoidModuleLoader17makeModuleVisibleEPN5clang6ModuleENS2_18NameVisibilityKindENS1_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoader17makeModuleVisibleEPN5clang6ModuleENS2_18NameVisibilityKindENS1_14SourceLocationE")
    //</editor-fold>
    @Override public/*private*/ void makeModuleVisible(Module /*P*/ Mod, 
                     Module.NameVisibilityKind Visibility, 
                     SourceLocation ImportLoc)/* override*/ {
    }


    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader::loadGlobalModuleIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 65,
     FQN="(anonymous namespace)::VoidModuleLoader::loadGlobalModuleIndex", NM="_ZN12_GLOBAL__N_116VoidModuleLoader21loadGlobalModuleIndexEN5clang14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoader21loadGlobalModuleIndexEN5clang14SourceLocationE")
    //</editor-fold>
    @Override public/*private*/ GlobalModuleIndexImplementation /*P*/ loadGlobalModuleIndex(SourceLocation TriggerLoc)/* override*/ {
      return null;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader::lookupMissingImports">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 67,
     FQN="(anonymous namespace)::VoidModuleLoader::lookupMissingImports", NM="_ZN12_GLOBAL__N_116VoidModuleLoader20lookupMissingImportsEN4llvm9StringRefEN5clang14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoader20lookupMissingImportsEN4llvm9StringRefEN5clang14SourceLocationE")
    //</editor-fold>
    @Override public/*private*/ boolean lookupMissingImports(StringRef Name, SourceLocation TriggerLoc)/* override*/ {
      return false;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader::~VoidModuleLoader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 53,
     FQN="(anonymous namespace)::VoidModuleLoader::~VoidModuleLoader", NM="_ZN12_GLOBAL__N_116VoidModuleLoaderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoaderD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidModuleLoader::VoidModuleLoader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 53,
     FQN="(anonymous namespace)::VoidModuleLoader::VoidModuleLoader", NM="_ZN12_GLOBAL__N_116VoidModuleLoaderC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_116VoidModuleLoaderC1Ev")
    //</editor-fold>
    public /*inline*/ VoidModuleLoader() {
      /* : ModuleLoader()*/ 
      //START JInit
      super();
      //END JInit
    }


    public String toString() {
      return "" + super.toString(); // NOI18N
    }
  }
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceManagerTest_isBeforeInTranslationUnit_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 71,
   FQN="(anonymous namespace)::SourceManagerTest_isBeforeInTranslationUnit_Test::TestBody", NM="_ZN12_GLOBAL__N_148SourceManagerTest_isBeforeInTranslationUnit_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_148SourceManagerTest_isBeforeInTranslationUnit_Test8TestBodyEv")
  //</editor-fold>
  public void test_isBeforeInTranslationUnit() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.unique_ptr<MemoryBuffer> Buf = null;
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    std.vector<Token> toks = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/char$ptr/*char P*/ source = $("#define M(x) [x]\nM(foo)");
      Buf = MemoryBuffer.getMemBuffer(new StringRef(source));
      FileID mainFileID = FileID.get(SourceMgr.createFileID($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buf)))));
      SourceMgr.setMainFileID(/*NO_COPY*/mainFileID);

      ModLoader/*J*/= new VoidModuleLoader();
      HeaderInfo/*J*/= $c$.clean(new HeaderSearch($c$.track(new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions())), SourceMgr, Diags, LangOpts, 
          $AddrOf(Target.$star())));
      PP/*J*/= $c$.clean(new Preprocessor($c$.track(new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions())), Diags, LangOpts, SourceMgr, 
          HeaderInfo, ModLoader, 
          /*IILookup =*/ (IdentifierInfoLookup /*P*/ )null, 
          /*OwnsHeaderSearch =*/ false));
      PP.Initialize(Target.$star());
      PP.EnterMainSourceFile();

      toks/*J*/= new std.vector<Token>(new Token());
      while (true) {
        Token tok/*J*/= new Token();
        PP.Lex(tok);
        if (tok.is(TokenKind.eof)) {
          break;
        }
        toks.push_back(tok);
      }
      // JAVA: added extra check
      for (int i = 0; i < toks.size() - 1; i++) {
        EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(toks.$at(i).getLocation(), toks.$at(i + 1).getLocation()));
      }      
      // Make sure we got the tokens that we expected.
      EXPECT_EQ(3/*U*/,toks.size());
      EXPECT_EQ(tok.TokenKind.l_square,toks.$at(0).getKind());
      EXPECT_EQ(tok.TokenKind.identifier,toks.$at(1).getKind());
      EXPECT_EQ(tok.TokenKind.r_square,toks.$at(2).getKind());

      SourceLocation lsqrLoc = toks.$at(0).getLocation();
      SourceLocation idLoc = toks.$at(1).getLocation();
      SourceLocation rsqrLoc = toks.$at(2).getLocation();

      SourceLocation macroExpStartLoc = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 2, 1);
      SourceLocation macroExpEndLoc = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 2, 6);
      ASSERT_TRUE(macroExpStartLoc.isFileID());
      ASSERT_TRUE(macroExpEndLoc.isFileID());

      SmallString/*32*/ str/*J*/= new SmallString/*32*/(32);
      EXPECT_EQ("M",PP.getSpelling(new SourceLocation(macroExpStartLoc), str));
      EXPECT_EQ(")",PP.getSpelling(new SourceLocation(macroExpEndLoc), str));
      EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/lsqrLoc, /*NO_COPY*/idLoc));
      EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/idLoc, /*NO_COPY*/rsqrLoc));
      EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/macroExpStartLoc, /*NO_COPY*/idLoc));
      EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/idLoc, /*NO_COPY*/macroExpEndLoc));
    } finally {
      if (toks != null) { toks.$destroy(); }
      if (PP != null) { PP.$destroy(); }
      if (HeaderInfo != null) { HeaderInfo.$destroy(); }
      if (ModLoader != null) { ModLoader.$destroy(); }
      if (Buf != null) { Buf.$destroy(); }
      $c$.$destroy();
    }
  }

  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceManagerTest_getColumnNumber_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 124,
   FQN="(anonymous namespace)::SourceManagerTest_getColumnNumber_Test::TestBody", NM="_ZN12_GLOBAL__N_138SourceManagerTest_getColumnNumber_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_138SourceManagerTest_getColumnNumber_Test8TestBodyEv")
  //</editor-fold>
  public void test_getColumnNumber() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.unique_ptr<MemoryBuffer> Buf = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/char$ptr/*char P*/ Source = 
              $("int x;\n"
              + "int y;");

      Buf = MemoryBuffer.getMemBuffer(new StringRef(Source));
      FileID MainFileID = FileID.get(SourceMgr.createFileID(Buf));
      SourceMgr.setMainFileID(/*NO_COPY*/MainFileID);

      bool$ptr Invalid;

      Invalid = NativePointer.create_bool$ptr(false);
      EXPECT_EQ(1/*U*/,SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, 0, $AddrOf(Invalid)));
      EXPECT_TRUE(!Invalid.$star());

      Invalid = NativePointer.create_bool$ptr(false);
      EXPECT_EQ(5/*U*/,SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, 4, $AddrOf(Invalid)));
      EXPECT_TRUE(!Invalid.$star());

      Invalid = NativePointer.create_bool$ptr(false);
      EXPECT_EQ(1/*U*/,SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, 7, $AddrOf(Invalid)));
      EXPECT_TRUE(!Invalid.$star());

      Invalid = NativePointer.create_bool$ptr(false);
      EXPECT_EQ(5/*U*/,SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, 11, $AddrOf(Invalid)));
      EXPECT_TRUE(!Invalid.$star());

      Invalid = NativePointer.create_bool$ptr(false);
      EXPECT_EQ(7/*U*/,SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, strlen(Source), $AddrOf(Invalid)));
      EXPECT_TRUE(!Invalid.$star());

      Invalid = NativePointer.create_bool$ptr(false);
      SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, strlen(Source) + 1, $AddrOf(Invalid));
      EXPECT_TRUE(Invalid);

      // Test invalid files
      Invalid = NativePointer.create_bool$ptr(false);
      SourceMgr.getColumnNumber(new FileID(), 0, $AddrOf(Invalid));
      EXPECT_TRUE(Invalid);

      Invalid = NativePointer.create_bool$ptr(false);
      SourceMgr.getColumnNumber(new FileID(), 1, $AddrOf(Invalid));
      EXPECT_TRUE(Invalid);
      // Test with no invalid flag.
      EXPECT_EQ(1/*U*/, SourceMgr.getColumnNumber(/*NO_COPY*/MainFileID, 0, (bool$ptr/*bool P*/ )null));
    } finally {
      if (Buf != null) { Buf.$destroy(); }
      $c$.$destroy();
    }
  }

  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceManagerTest_getMacroArgExpandedLocation_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 176,
   FQN="(anonymous namespace)::SourceManagerTest_getMacroArgExpandedLocation_Test::TestBody", NM="_ZN12_GLOBAL__N_150SourceManagerTest_getMacroArgExpandedLocation_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_150SourceManagerTest_getMacroArgExpandedLocation_Test8TestBodyEv")
  //</editor-fold>
  public void test_getMacroArgExpandedLocation() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.unique_ptr<MemoryBuffer> HeaderBuf = null;
    std.unique_ptr<MemoryBuffer> MainBuf = null;
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    std.vector<Token> toks = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/char$ptr/*char P*/ header = $("#define FM(x,y) x\n");

      /*const*/char$ptr/*char P*/ main = 
              $("#include \"/test-header.h\"\n"
              + "#define VAL 0\nFM(VAL,0)\n"
              + "FM(0,VAL)\nFM(FM(0,VAL),0)\n"
              + "#define CONCAT(X, Y) X##Y\n"
              + "CONCAT(1,1)\n");

      HeaderBuf = MemoryBuffer.getMemBuffer(new StringRef(header));
      MainBuf = MemoryBuffer.getMemBuffer(new StringRef(main));
      FileID mainFileID = FileID.get(SourceMgr.createFileID($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(MainBuf)))));
      SourceMgr.setMainFileID(/*NO_COPY*/mainFileID);

      /*const*/ FileEntry /*P*/ headerFile = FileMgr.getVirtualFile(new StringRef(/*KEEP_STR*/"/test-header.h"), 
          HeaderBuf.$arrow().getBufferSize(), 0);
      SourceMgr.overrideFileContents(headerFile, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(HeaderBuf)))); $c$.clean();

      ModLoader/*J*/= new VoidModuleLoader();
      HeaderInfo/*J*/= $c$.clean(new HeaderSearch($c$.track(new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions())), SourceMgr, Diags, LangOpts, 
          $AddrOf(Target.$star())));
      PP/*J*/= $c$.clean(new Preprocessor($c$.track(new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions())), Diags, LangOpts, SourceMgr, 
          HeaderInfo, ModLoader, 
          /*IILookup =*/ (IdentifierInfoLookup /*P*/ )null, 
          /*OwnsHeaderSearch =*/ false));
      PP.Initialize(Target.$star());
      PP.EnterMainSourceFile();

      toks/*J*/= new std.vector<Token>(new Token());
      while (true) {
        Token tok/*J*/= new Token();
        PP.Lex(tok);
        if (tok.is(TokenKind.eof)) {
          break;
        }
        toks.push_back(tok);
      }
      // Make sure we got the tokens that we expected.
      EXPECT_EQ(4/*U*/,toks.size());
      EXPECT_EQ(tok.TokenKind.numeric_constant,toks.$at(0).getKind());
      EXPECT_EQ(tok.TokenKind.numeric_constant,toks.$at(1).getKind());
      EXPECT_EQ(tok.TokenKind.numeric_constant,toks.$at(2).getKind());
      EXPECT_EQ(tok.TokenKind.numeric_constant,toks.$at(3).getKind());

      SourceLocation defLoc = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 2, 13);
      SourceLocation loc1 = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 3, 8);
      SourceLocation loc2 = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 4, 4);
      SourceLocation loc3 = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 5, 7);
      SourceLocation defLoc2 = SourceMgr.translateLineCol(/*NO_COPY*/mainFileID, 6, 22);
      defLoc.$assignMove(SourceMgr.getMacroArgExpandedLocation(/*NO_COPY*/defLoc));
      loc1.$assignMove(SourceMgr.getMacroArgExpandedLocation(/*NO_COPY*/loc1));
      loc2.$assignMove(SourceMgr.getMacroArgExpandedLocation(/*NO_COPY*/loc2));
      loc3.$assignMove(SourceMgr.getMacroArgExpandedLocation(/*NO_COPY*/loc3));
      defLoc2.$assignMove(SourceMgr.getMacroArgExpandedLocation(/*NO_COPY*/defLoc2));
      EXPECT_TRUE(defLoc.isFileID());
      EXPECT_TRUE(loc1.isFileID());
      EXPECT_TRUE(SourceMgr.isMacroArgExpansion(/*NO_COPY*/loc2));
      EXPECT_TRUE(SourceMgr.isMacroArgExpansion(/*NO_COPY*/loc3));
      EXPECT_EQ(loc2,toks.$at(1).getLocation());
      EXPECT_EQ(loc3,toks.$at(2).getLocation());
      EXPECT_TRUE(defLoc2.isFileID());
    } finally {
      if (toks != null) { toks.$destroy(); }
      if (PP != null) { PP.$destroy(); }
      if (HeaderInfo != null) { HeaderInfo.$destroy(); }
      if (ModLoader != null) { ModLoader.$destroy(); }
      if (MainBuf != null) { MainBuf.$destroy(); }
      if (HeaderBuf != null) { HeaderBuf.$destroy(); }
      $c$.$destroy();
    }
  }


  //JAVA: namespace (anonymous) {

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 248,
   FQN="(anonymous namespace)::(anonymous namespace)::MacroAction", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionE")
  //</editor-fold>
  public static class/*struct*/ MacroAction implements Destructors.ClassWithDestructor {
    public SourceLocation Loc;
    public std.string Name;
    public boolean isDefinition; // if false, it is expansion.

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroAction::MacroAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 253,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroAction::MacroAction", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionC1EN5clang14SourceLocationEN4llvm9StringRefEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionC1EN5clang14SourceLocationEN4llvm9StringRefEb")
    //</editor-fold>
    public MacroAction(SourceLocation Loc, StringRef Name, boolean isDefinition) {
      /* : Loc(Loc), Name(Name.operator basic_string()), isDefinition(isDefinition)*/ 
      //START JInit
      this.Loc = new SourceLocation(Loc);
      this.Name = Name.$string();
      this.isDefinition = isDefinition;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroAction::MacroAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 248,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroAction::MacroAction", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionC1EOS1_")
    //</editor-fold>
    public /*inline*/ MacroAction(JD$Move _dparam, MacroAction /*&&*/$Prm0) {
      /* : Loc(static_cast<MacroAction &&>().Loc), Name(static_cast<MacroAction &&>().Name), isDefinition(static_cast<MacroAction &&>().isDefinition)*/ 
      //START JInit
      this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
      this.Name = new std.string(JD$Move.INSTANCE, $Prm0.Name);
      this.isDefinition = $Prm0.isDefinition;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroAction::~MacroAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 248,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroAction::~MacroAction", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_111MacroActionD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Name.$destroy();
      //END JDestroy
    }


    public String toString() {
      return "" + "Loc=" + Loc // NOI18N
                + ", Name=" + Name // NOI18N
                + ", isDefinition=" + isDefinition; // NOI18N
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 257,
   FQN="(anonymous namespace)::(anonymous namespace)::MacroTracker", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTrackerE")
  //</editor-fold>
  public static class MacroTracker extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
    private std.vector<MacroAction>/*&*/ Macros;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroTracker::MacroTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 261,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroTracker::MacroTracker", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTrackerC1ERSt6vectorINS0_11MacroActionESaIS3_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTrackerC1ERSt6vectorINS0_11MacroActionESaIS3_EE")
    //</editor-fold>
    public /*explicit*/ MacroTracker(std.vector<MacroAction>/*&*/ Macros) {
      /* : PPCallbacks(), Macros(Macros)*/ 
      //START JInit
      super();
      this./*&*/Macros=/*&*/Macros;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroTracker::MacroDefined">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 263,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroTracker::MacroDefined", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTracker12MacroDefinedERKN5clang5TokenEPKNS2_14MacroDefinitionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTracker12MacroDefinedERKN5clang5TokenEPKNS2_14MacroDirectiveE")
    //</editor-fold>
    @Override public void MacroDefined(SourceLocation HashLoc, SourceLocation EodLoc, 
                /*const*/ Token /*&*/ MacroNameTok, 
                /*const*/ MacroDirective /*P*/ MD)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Macros.push_back($c$.track(new MacroAction(MD.getLocation(), 
                MacroNameTok.getIdentifierInfo().getName(), 
                true))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroTracker::MacroExpands">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 269,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroTracker::MacroExpands", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTracker12MacroExpandsERKN5clang5TokenERKNS2_15MacroDefinitionENS2_11SourceRangeEPKNS2_9MacroArgsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTracker12MacroExpandsERKN5clang5TokenERKNS2_15MacroDefinitionENS2_11SourceRangeEPKNS2_9MacroArgsE")
    //</editor-fold>
    @Override public void MacroExpands(/*const*/ Token /*&*/ MacroNameTok, /*const*/ MacroDefinition /*&*/ MD, 
                SourceRange Range, final/*const*/MacroArgs/*MacroArgs P*/ Args)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Macros.push_back($c$.track(new MacroAction(MacroNameTok.getLocation(), 
                MacroNameTok.getIdentifierInfo().getName(), 
                false))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::MacroTracker::~MacroTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 257,
     FQN="(anonymous namespace)::(anonymous namespace)::MacroTracker::~MacroTracker", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTrackerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_112MacroTrackerD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    public String toString() {
      return "" + "Macros=" + Macros // NOI18N
                + super.toString(); // NOI18N
    }
  }
  //} JAVA: end of namespace (anonymous)
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceManagerTest_isBeforeInTranslationUnitWithMacroInInclude_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp", line = 279,
   FQN="(anonymous namespace)::SourceManagerTest_isBeforeInTranslationUnitWithMacroInInclude_Test::TestBody", NM="_ZN12_GLOBAL__N_166SourceManagerTest_isBeforeInTranslationUnitWithMacroInInclude_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/SourceManagerTest.cpp -nm=_ZN12_GLOBAL__N_166SourceManagerTest_isBeforeInTranslationUnitWithMacroInInclude_Test8TestBodyEv")
  //</editor-fold>
  public void test_isBeforeInTranslationUnitWithMacroInInclude() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.unique_ptr<MemoryBuffer> HeaderBuf = null;
    std.unique_ptr<MemoryBuffer> MainBuf = null;
    VoidModuleLoader ModLoader = null;
    HeaderSearch HeaderInfo = null;
    Preprocessor PP = null;
    std.vector<MacroAction> Macros = null;
    std.vector<Token> toks = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/char$ptr/*char P*/ header = 
              $("#define MACRO_IN_INCLUDE 0\n");

      /*const*/char$ptr/*char P*/ main = 
              $("#define M(x) x\n#define INC \"/test-header.h\"\n"
              + "#include M(INC)\n"
              + "#define INC2 </test-header.h>\n"
              + "#include M(INC2)\n");

      HeaderBuf = MemoryBuffer.getMemBuffer(new StringRef(header));
      MainBuf = MemoryBuffer.getMemBuffer(new StringRef(main));
      SourceMgr.setMainFileID(SourceMgr.createFileID($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(MainBuf))))); $c$.clean();

      /*const*/ FileEntry /*P*/ headerFile = FileMgr.getVirtualFile(new StringRef(/*KEEP_STR*/"/test-header.h"), 
          HeaderBuf.$arrow().getBufferSize(), 0);
      SourceMgr.overrideFileContents(headerFile, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(HeaderBuf)))); $c$.clean();

      ModLoader/*J*/= new VoidModuleLoader();
      HeaderInfo/*J*/= $c$.clean(new HeaderSearch($c$.track(new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions())), SourceMgr, Diags, LangOpts, 
          $AddrOf(Target.$star())));
      PP/*J*/= $c$.clean(new Preprocessor($c$.track(new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions())), Diags, LangOpts, SourceMgr, 
          HeaderInfo, ModLoader, 
          /*IILookup =*/ (IdentifierInfoLookup /*P*/ )null, 
          /*OwnsHeaderSearch =*/ false));
      PP.Initialize(Target.$star());

      Macros/*J*/= new std.vector<MacroAction>((MacroAction)null);
      PP.addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>($c$.track(llvm.make_unique(new MacroTracker(Macros)))))); $c$.clean();

      PP.EnterMainSourceFile();

      toks/*J*/= new std.vector<Token>(new Token());
      while (true) {
        Token tok/*J*/= new Token();
        PP.Lex(tok);
        if (tok.is(TokenKind.eof)) {
          break;
        }
        toks.push_back(tok);
      }
      // Make sure we got the tokens that we expected.
      EXPECT_EQ(0, toks.size());
      EXPECT_EQ(9/*U*/,Macros.size());
      // #define M(x) x
      ASSERT_TRUE(Macros.$at(0).isDefinition);
      EXPECT_EQ("M",Macros.$at(0).Name);
      // #define INC "/test-header.h"
      ASSERT_TRUE(Macros.$at(1).isDefinition);
      EXPECT_EQ("INC",Macros.$at(1).Name);
      // M expansion in #include M(INC)
      ASSERT_FALSE((Macros.$at(2).isDefinition));
      EXPECT_EQ("M",Macros.$at(2).Name);
      // INC expansion in #include M(INC)
      ASSERT_FALSE((Macros.$at(3).isDefinition));
      EXPECT_EQ("INC",Macros.$at(3).Name);
      // #define MACRO_IN_INCLUDE 0
      ASSERT_TRUE(Macros.$at(4).isDefinition);
      EXPECT_EQ("MACRO_IN_INCLUDE",Macros.$at(4).Name);
      // #define INC2 </test-header.h>
      ASSERT_TRUE(Macros.$at(5).isDefinition);
      EXPECT_EQ("INC2",Macros.$at(5).Name);
      // M expansion in #include M(INC2)
      ASSERT_FALSE((Macros.$at(6).isDefinition));
      EXPECT_EQ("M",Macros.$at(6).Name);
      // INC2 expansion in #include M(INC2)
      ASSERT_FALSE((Macros.$at(7).isDefinition));
      EXPECT_EQ("INC2",Macros.$at(7).Name);
      // #define MACRO_IN_INCLUDE 0
      ASSERT_TRUE(Macros.$at(8).isDefinition);
      EXPECT_EQ("MACRO_IN_INCLUDE",Macros.$at(8).Name);

      // The INC expansion in #include M(INC) comes before the first
      // MACRO_IN_INCLUDE definition of the included file.
      EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/Macros.$at(3).Loc, /*NO_COPY*/Macros.$at(4).Loc));

      // The INC2 expansion in #include M(INC2) comes before the second
      // MACRO_IN_INCLUDE definition of the included file.
      EXPECT_TRUE(SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/Macros.$at(7).Loc, /*NO_COPY*/Macros.$at(8).Loc));
    } finally {
      if (toks != null) { toks.$destroy(); }
      if (Macros != null) { Macros.$destroy(); }
      if (PP != null) { PP.$destroy(); }
      if (HeaderInfo != null) { HeaderInfo.$destroy(); }
      if (ModLoader != null) { ModLoader.$destroy(); }
      if (MainBuf != null) { MainBuf.$destroy(); }
      if (HeaderBuf != null) { HeaderBuf.$destroy(); }
      $c$.$destroy();
    }
  }

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class SourceManagerTest
