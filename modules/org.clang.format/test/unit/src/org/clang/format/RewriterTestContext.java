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

package org.clang.format;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.clang.frontend.TextDiagnosticPrinter;
import org.clang.rewrite.core.Rewriter;
import org.llvm.support.sys.fs;


//JAVA: namespace clang {

/// \brief A class that sets up a ready to use Rewriter.
///
/// Useful in unit tests that need a Rewriter. Creates all dependencies
/// of a Rewriter with default values for testing and provides convenience
/// methods, which help with writing tests that change files.
//<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 35,
 FQN="clang::RewriterTestContext", NM="_ZN5clang19RewriterTestContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContextE")
//</editor-fold>
public class RewriterTestContext implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::RewriterTestContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 37,
   FQN="clang::RewriterTestContext::RewriterTestContext", NM="_ZN5clang19RewriterTestContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContextC1Ev")
  //</editor-fold>
  public RewriterTestContext() {
    // : DiagOpts(new DiagnosticOptions()), Diagnostics(IntrusiveRefCntPtr<DiagnosticIDs>($c$.track(new DiagnosticIDs)), &* DiagOpts), DiagnosticPrinter(llvm::outs(), &* DiagOpts), InMemoryFileSystem(new InMemoryFileSystem), OverlayFileSystem(new OverlayFileSystem($c$.track(vfs::getRealFileSystem()))), Files(FileSystemOptions(), $c$.track(OverlayFileSystem)), Sources(Diagnostics, Files), Options(), Rewrite(Sources, Options), TemporaryFiles() 
    //START JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
      this.Diagnostics = $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
          /*AddrOf*/DiagOpts.$star()));
      this.DiagnosticPrinter = new TextDiagnosticPrinter(llvm.outs(), /*AddrOf*/DiagOpts.$star());
      this.InMemoryFileSystem = new IntrusiveRefCntPtr<InMemoryFileSystem>(new InMemoryFileSystem());
      this.OverlayFileSystem = $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(VfsGlobals.getRealFileSystem()))));
      this.Files = $c$.clean(new FileManager(new FileSystemOptions(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, OverlayFileSystem))));
      this.Sources = new SourceManager(Diagnostics, Files);
      this.Options = new LangOptions();
      this.Rewrite = new Rewriter(Sources, Options);
      this.TemporaryFiles = new StringMap<std.string>(std.string.EMPTY);
    } finally {
        $c$.$destroy();
    }
    //END JInit
    JavaCleaner $c$2 = $createJavaCleaner();
    try {
      Diagnostics.setClient(/*AddrOf*/DiagnosticPrinter, false);
      // FIXME: To make these tests truly in-memory, we need to overlay the
      // builtin headers.
      OverlayFileSystem.$arrow().pushOverlay($c$2.track(new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, InMemoryFileSystem))); $c$2.clean();
    } finally {
      $c$2.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::~RewriterTestContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 53,
   FQN="clang::RewriterTestContext::~RewriterTestContext", NM="_ZN5clang19RewriterTestContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    TemporaryFiles.$destroy();
    Rewrite.$destroy();
    Options.$destroy();
    Sources.$destroy();
    Files.$destroy();
    OverlayFileSystem.$destroy();
    InMemoryFileSystem.$destroy();
    DiagnosticPrinter.$destroy();
    Diagnostics.$destroy();
    DiagOpts.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::createInMemoryFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 55,
   FQN="clang::RewriterTestContext::createInMemoryFile", NM="_ZN5clang19RewriterTestContext18createInMemoryFileEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContext18createInMemoryFileEN4llvm9StringRefES2_")
  //</editor-fold>
  public FileID createInMemoryFile(StringRef Name, StringRef Content) {
    std.unique_ptr<MemoryBuffer> Source = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Source = MemoryBuffer.getMemBuffer(new StringRef(Content));
      $c$.clean(InMemoryFileSystem.$arrow().addFile(new Twine(Name), 0, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Source)))));
      
      /*const*/ FileEntry /*P*/ Entry = Files.getFile(/*NO_COPY*/Name);
      assert (Entry != null);
      return Sources.createFileID(Entry, new SourceLocation(), SrcMgr.CharacteristicKind.C_User);
    } finally {
      if (Source != null) { Source.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // FIXME: this code is mostly a duplicate of
  // unittests/Tooling/RefactoringTest.cpp. Figure out a way to share it.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::createOnDiskFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 67,
   FQN="clang::RewriterTestContext::createOnDiskFile", NM="_ZN5clang19RewriterTestContext16createOnDiskFileEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContext16createOnDiskFileEN4llvm9StringRefES2_")
  //</editor-fold>
  public FileID createOnDiskFile(StringRef Name, StringRef Content) {
    raw_fd_ostream OutStream = null;
    try {
      SmallString/*1024*/ Path/*J*/= new SmallString/*1024*/(1024);
      int$ref FD = create_int$ref();
      std.error_code EC = fs.createTemporaryFile(new Twine(Name), new StringRef(/*KEEP_STR*/$EMPTY), FD, Path);
      assert (!EC.$bool());
      ///*J:(void)*/EC;
      
      OutStream/*J*/= new raw_fd_ostream(FD.$deref(), true);
      OutStream.$out(/*NO_COPY*/Content);      
      OutStream.close(); //JAVA: was OutStream.test_fd(); but in the original I see OutStream.close();
      /*const*/ FileEntry /*P*/ File = Files.getFile(Path.$StringRef());
      assert (File != null);
      
      StringRef Found = new StringRef(TemporaryFiles.insert(std.make_pair_T_T2T(Name, Path.str().$string())).first.$arrow().second);
      assert ($eq_StringRef(/*NO_COPY*/Found, Path.$StringRef()));
      ///*J:(void)*/Found;
      return Sources.createFileID(File, new SourceLocation(), SrcMgr.CharacteristicKind.C_User);
    } finally {
      if (OutStream != null) { OutStream.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 87,
   FQN="clang::RewriterTestContext::getLocation", NM="_ZN5clang19RewriterTestContext11getLocationENS_6FileIDEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContext11getLocationENS_6FileIDEjj")
  //</editor-fold>
  public SourceLocation getLocation(FileID ID, /*uint*/int Line, /*uint*/int Column) {
    SourceLocation Result = Sources.translateFileLineCol(Sources.getFileEntryForID(/*NO_COPY*/ID), Line, Column);
    assert (Result.isValid());
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::getRewrittenText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 94,
   FQN="clang::RewriterTestContext::getRewrittenText", NM="_ZN5clang19RewriterTestContext16getRewrittenTextENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContext16getRewrittenTextENS_6FileIDE")
  //</editor-fold>
  public std.string getRewrittenText(FileID ID) {
    raw_string_ostream OS = null;
    try {
      std.string Result/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Result);
      Rewrite.getEditBuffer(new FileID(ID)).write(OS);
      OS.flush();
      return Result;
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriterTestContext::getFileContentFromDisk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h", line = 102,
   FQN="clang::RewriterTestContext::getFileContentFromDisk", NM="_ZN5clang19RewriterTestContext22getFileContentFromDiskEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Tooling/RewriterTestContext.h -nm=_ZN5clang19RewriterTestContext22getFileContentFromDiskEN4llvm9StringRefE")
  //</editor-fold>
  public std.string getFileContentFromDisk(StringRef Name) {
    ErrorOr<unique_ptr<MemoryBuffer> > FileBuffer = null;
    try {
      std.string Path = TemporaryFiles.lookup(new StringRef(Name));
      assert (!Path.empty());
      // We need to read directly from the FileManager without relaying through
      // a FileEntry, as otherwise we'd read through an already opened file
      // descriptor, which might not see the changes made.
      // FIXME: Figure out whether there is a way to get the SourceManger to
      // reopen the file.
      FileBuffer = Files.getBufferForFile(new StringRef(Path));
      return (FileBuffer.$star()).$arrow().getBuffer().$string();
    } finally {
      if (FileBuffer != null) { FileBuffer.$destroy(); }
    }
  }

  
  public IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
  public DiagnosticsEngine Diagnostics;
  public TextDiagnosticPrinter DiagnosticPrinter;
  public IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem;
  public IntrusiveRefCntPtr<OverlayFileSystem> OverlayFileSystem;
  public FileManager Files;
  public SourceManager Sources;
  public LangOptions Options;
  public Rewriter Rewrite;
  
  // Will be set once on disk files are generated.
  public StringMap<std.string> TemporaryFiles;
  
  @Override public String toString() {
    return "" + "DiagOpts=" + DiagOpts // NOI18N
              + ", Diagnostics=" + "[DiagnosticsEngine]" // NOI18N
              + ", DiagnosticPrinter=" + DiagnosticPrinter // NOI18N
              + ", InMemoryFileSystem=" + InMemoryFileSystem // NOI18N
              + ", OverlayFileSystem=" + OverlayFileSystem // NOI18N
              + ", Files=" + "[FileManager]" // NOI18N
              + ", Sources=" + "[SourceManager]" // NOI18N
              + ", Options=" + Options // NOI18N
              + ", Rewrite=" + Rewrite // NOI18N
              + ", TemporaryFiles=" + TemporaryFiles; // NOI18N
  }
}
//} JAVA: end of namespace clang
