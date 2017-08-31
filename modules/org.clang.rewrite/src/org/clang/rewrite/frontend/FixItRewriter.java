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

package org.clang.rewrite.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.rewrite.core.*;
import org.clang.rewrite.frontend.*;
import org.clang.rewrite.frontend.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.edit.*;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FixItRewriter.h", line = 60,
 FQN="clang::FixItRewriter", NM="_ZN5clang13FixItRewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriterE")
//</editor-fold>
public class FixItRewriter extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  /// \brief The diagnostics machinery.
  private DiagnosticsEngine /*&*/ Diags;
  
  private EditedSource Editor;
  
  /// \brief The rewriter used to perform the various code
  /// modifications.
  private Rewriter Rewrite;
  
  /// \brief The diagnostic client that performs the actual formatting
  /// of error messages.
  private DiagnosticConsumer /*P*/ Client;
  private std.unique_ptr<DiagnosticConsumer> Owner;
  
  /// \brief Turn an input path into an output path. NULL implies overwriting
  /// the original.
  private FixItOptions /*P*/ FixItOpts;
  
  /// \brief The number of rewriter failures.
  private /*uint*/int NumFailures;
  
  /// \brief Whether the previous diagnostic was not passed to the consumer.
  private boolean PrevDiagSilenced;
/*public:*/
  /*typedef Rewriter::buffer_iterator iterator*/
//  public final class iterator extends std.map.iterator<FileID, RewriteBuffer>{ };
  
  /// \brief Initialize a new fix-it rewriter.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::FixItRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 30,
   FQN="clang::FixItRewriter::FixItRewriter", NM="_ZN5clang13FixItRewriterC1ERNS_17DiagnosticsEngineERNS_13SourceManagerERKNS_11LangOptionsEPNS_12FixItOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriterC1ERNS_17DiagnosticsEngineERNS_13SourceManagerERKNS_11LangOptionsEPNS_12FixItOptionsE")
  //</editor-fold>
  public FixItRewriter(DiagnosticsEngine /*&*/ Diags, SourceManager /*&*/ SourceMgr, 
      /*const*/ LangOptions /*&*/ LangOpts, 
      FixItOptions /*P*/ FixItOpts) {
    // : DiagnosticConsumer(), Diags(Diags), Editor(SourceMgr, LangOpts), Rewrite(SourceMgr, LangOpts), Owner(), FixItOpts(FixItOpts), NumFailures(0), PrevDiagSilenced(false) 
    //START JInit
    super();
    this./*&*/Diags=/*&*/Diags;
    this.Editor = new EditedSource(SourceMgr, LangOpts);
    this.Rewrite = new Rewriter(SourceMgr, LangOpts);
    this.Owner = new std.unique_ptr<DiagnosticConsumer>();
    this.FixItOpts = FixItOpts;
    this.NumFailures = 0;
    this.PrevDiagSilenced = false;
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(Owner.$assignMove($c$.track(Diags.takeClient())));
      Client = Diags.getClient();
      Diags.setClient(this, false);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Destroy the fix-it rewriter.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::~FixItRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 44,
   FQN="clang::FixItRewriter::~FixItRewriter", NM="_ZN5clang13FixItRewriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriterD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    Diags.setClient(Client, Owner.release() != (DiagnosticConsumer)null);
    //START JDestroy
    Owner.$destroy();
    Rewrite.$destroy();
    Editor.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// \brief Check whether there are modifications for a given file.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::IsModified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FixItRewriter.h", line = 96,
   FQN="clang::FixItRewriter::IsModified", NM="_ZNK5clang13FixItRewriter10IsModifiedENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZNK5clang13FixItRewriter10IsModifiedENS_6FileIDE")
  //</editor-fold>
  public boolean IsModified(FileID ID) /*const*/ {
    return Rewrite.getRewriteBufferFor(new FileID(ID)) != null;
  }

  
  // Iteration over files with changes.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::buffer_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FixItRewriter.h", line = 101,
   FQN="clang::FixItRewriter::buffer_begin", NM="_ZN5clang13FixItRewriter12buffer_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriter12buffer_beginEv")
  //</editor-fold>
  public std.mapTypeType.iterator<FileID, RewriteBuffer> buffer_begin() {
    return Rewrite.buffer_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::buffer_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FixItRewriter.h", line = 102,
   FQN="clang::FixItRewriter::buffer_end", NM="_ZN5clang13FixItRewriter10buffer_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriter10buffer_endEv")
  //</editor-fold>
  public std.mapTypeType.iterator<FileID, RewriteBuffer> buffer_end() {
    return Rewrite.buffer_end();
  }

  
  /// \brief Write a single modified source file.
  ///
  /// \returns true if there was an error, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::WriteFixedFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 48,
   FQN="clang::FixItRewriter::WriteFixedFile", NM="_ZN5clang13FixItRewriter14WriteFixedFileENS_6FileIDERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriter14WriteFixedFileENS_6FileIDERN4llvm11raw_ostreamE")
  //</editor-fold>
  public boolean WriteFixedFile(FileID ID, raw_ostream /*&*/ OS) {
    /*const*/ RewriteBuffer /*P*/ RewriteBuf = Rewrite.getRewriteBufferFor(new FileID(ID));
    if (!(RewriteBuf != null)) {
      return true;
    }
    RewriteBuf.write(OS);
    OS.flush();
    return false;
  }

  
  /// \brief Write the modified source files.
  ///
  /// \returns true if there was an error, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::WriteFixedFiles">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 74,
   FQN="clang::FixItRewriter::WriteFixedFiles", NM="_ZN5clang13FixItRewriter15WriteFixedFilesEPSt6vectorISt4pairISsSsESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriter15WriteFixedFilesEPSt6vectorISt4pairISsSsESaIS3_EE")
  //</editor-fold>
  public boolean WriteFixedFiles() {
    return WriteFixedFiles((std.vector<std.pair<std.string, std.string>> /*P*/)null);
  }
  public boolean WriteFixedFiles(std.vector<std.pair<std.string, std.string>> /*P*/ RewrittenFiles/*= null*/) {
    RewritesReceiver Rec = null;
    try {
      if ($greater_uint(NumFailures, 0) && !FixItOpts.FixWhatYouCan) {
        Diag(new SourceLocation(JD$Move.INSTANCE, new FullSourceLoc()), diag.warn_fixit_no_changes);
        return true;
      }
      
      Rec/*J*/= new RewritesReceiver(Rewrite);
      Editor.applyRewrites(Rec);
      if (FixItOpts.InPlace) {
        // Overwriting open files on Windows is tricky, but the rewriter can do it
        // for us.
        Rewrite.overwriteChangedFiles();
        return false;
      }
      
      for (std.mapTypeType.iterator<FileID, RewriteBuffer> I = buffer_begin(), E = buffer_end(); I.$noteq(E); I.$preInc()) {
        std.unique_ptr<raw_fd_ostream> OS = null;
        try {
          /*const*/ FileEntry /*P*/ Entry = Rewrite.getSourceMgr().getFileEntryForID(/*NO_COPY*/I.$arrow().first);
          int$ref fd = create_int$ref();
          std.string Filename = FixItOpts.RewriteFilename(new std.string(Entry.getName()), fd);
          std.error_code EC/*J*/= new std.error_code();
          OS/*J*/= new std.unique_ptr<raw_fd_ostream>();
          if (fd.$deref() != -1) {
            OS.reset(new raw_fd_ostream(fd, /*shouldClose=*/ true));
          } else {
            OS.reset(new raw_fd_ostream(new StringRef(Filename), EC, fs.OpenFlags.F_None));
          }
          if (EC.$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_unable_to_open_output)), new StringRef(Filename)), 
                  new StringRef(EC.message())));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          RewriteBuffer /*&*/ RewriteBuf = I.$arrow().second;
          RewriteBuf.write(OS.$star());
          OS.$arrow().flush();
          if ((RewrittenFiles != null)) {
            RewrittenFiles.push_back_T$RR(std.make_pair_Ptr2T_T(new std.string(Entry.getName()), Filename));
          }
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
      
      return false;
    } finally {
      if (Rec != null) { Rec.$destroy(); }
    }
  }

  
  /// IncludeInDiagnosticCounts - This method (whose default implementation
  /// returns true) indicates whether the diagnostics handled by this
  /// DiagnosticConsumer should be included in the number of diagnostics
  /// reported by DiagnosticsEngine.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::IncludeInDiagnosticCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 118,
   FQN="clang::FixItRewriter::IncludeInDiagnosticCounts", NM="_ZNK5clang13FixItRewriter25IncludeInDiagnosticCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZNK5clang13FixItRewriter25IncludeInDiagnosticCountsEv")
  //</editor-fold>
  @Override public boolean IncludeInDiagnosticCounts() /*const*//* override*/ {
    return (Client != null) ? Client.IncludeInDiagnosticCounts() : true;
  }

  
  /// HandleDiagnostic - Handle this diagnostic, reporting it to the user or
  /// capturing it to a log as needed.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 122,
   FQN="clang::FixItRewriter::HandleDiagnostic", NM="_ZN5clang13FixItRewriter16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriter16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, 
                  /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    Commit commit = null;
    try {
      // Default implementation (Warnings/errors count).
      super.HandleDiagnostic(DiagLevel, Info);
      if (!FixItOpts.Silent
         || DiagLevel.getValue() >= DiagnosticsEngine.Level.Error.getValue()
         || (DiagLevel == DiagnosticsEngine.Level.Note && !PrevDiagSilenced)
         || (DiagLevel.getValue() > DiagnosticsEngine.Level.Note.getValue() && (Info.getNumFixItHints() != 0))) {
        Client.HandleDiagnostic(DiagLevel, Info);
        PrevDiagSilenced = false;
      } else {
        PrevDiagSilenced = true;
      }
      
      // Skip over any diagnostics that are ignored or notes.
      if (DiagLevel.getValue() <= DiagnosticsEngine.Level.Note.getValue()) {
        return;
      }
      // Skip over errors if we are only fixing warnings.
      if (DiagLevel.getValue() >= DiagnosticsEngine.Level.Error.getValue() && FixItOpts.FixOnlyWarnings) {
        ++NumFailures;
        return;
      }
      
      // Make sure that we can perform all of the modifications we
      // in this diagnostic.
      commit/*J*/= new Commit(Editor);
      for (/*uint*/int Idx = 0, Last = Info.getNumFixItHints();
           $less_uint(Idx, Last); ++Idx) {
        /*const*/ FixItHint /*&*/ Hint = Info.getFixItHint(Idx);
        if (Hint.CodeToInsert.empty()) {
          if (Hint.InsertFromRange.isValid()) {
            commit.insertFromRange(Hint.RemoveRange.getBegin(), 
                new CharSourceRange(Hint.InsertFromRange), /*afterToken=*/ false, 
                Hint.BeforePreviousInsertions);
          } else {
            commit.remove(new CharSourceRange(Hint.RemoveRange));
          }
        } else {
          if (Hint.RemoveRange.isTokenRange()
             || $noteq_SourceLocation$C(Hint.RemoveRange.getBegin(), Hint.RemoveRange.getEnd())) {
            commit.replace(new CharSourceRange(Hint.RemoveRange), new StringRef(Hint.CodeToInsert));
          } else {
            commit.insert(Hint.RemoveRange.getBegin(), new StringRef(Hint.CodeToInsert), 
                /*afterToken=*/ false, Hint.BeforePreviousInsertions);
          }
        }
      }
      boolean CanRewrite = $greater_uint(Info.getNumFixItHints(), 0) && commit.isCommitable();
      if (!CanRewrite) {
        if ($greater_uint(Info.getNumFixItHints(), 0)) {
          Diag(new SourceLocation(Info.getLocation()), diag.note_fixit_in_macro);
        }
        
        // If this was an error, refuse to perform any rewriting.
        if (DiagLevel.getValue() >= DiagnosticsEngine.Level.Error.getValue()) {
          if (++NumFailures == 1) {
            Diag(new SourceLocation(Info.getLocation()), diag.note_fixit_unfixed_error);
          }
        }
        return;
      }
      if (!Editor.commit(commit)) {
        ++NumFailures;
        Diag(new SourceLocation(Info.getLocation()), diag.note_fixit_failed);
        return;
      }
      
      Diag(new SourceLocation(Info.getLocation()), diag.note_fixit_applied);
    } finally {
      if (commit != null) { commit.$destroy(); }
    }
  }

  
  /// \brief Emit a diagnostic via the adapted diagnostic client.
  
  /// \brief Emit a diagnostic via the adapted diagnostic client.
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRewriter::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp", line = 193,
   FQN="clang::FixItRewriter::Diag", NM="_ZN5clang13FixItRewriter4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FixItRewriter.cpp -nm=_ZN5clang13FixItRewriter4DiagENS_14SourceLocationEj")
  //</editor-fold>
  public void Diag(SourceLocation Loc, /*uint*/int DiagID) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // When producing this diagnostic, we temporarily bypass ourselves,
      // clear out any current diagnostic, and let the downstream client
      // format the diagnostic.
      Diags.setClient(Client, false);
      Diags.Clear();
      $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Loc, DiagID)));
      Diags.setClient(this, false);
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "Diags=" + Diags // NOI18N
              + ", Editor=" + Editor // NOI18N
              + ", Rewrite=" + Rewrite // NOI18N
              + ", Client=" + Client // NOI18N
              + ", Owner=" + Owner // NOI18N
              + ", FixItOpts=" + FixItOpts // NOI18N
              + ", NumFailures=" + NumFailures // NOI18N
              + ", PrevDiagSilenced=" + PrevDiagSilenced // NOI18N
              + super.toString(); // NOI18N
  }
}
