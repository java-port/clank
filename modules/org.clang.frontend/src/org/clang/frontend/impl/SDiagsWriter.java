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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.spi.PreprocessorImplementation;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import static org.clang.frontend.impl.SerializedDiagnosticPrinterStatics.*;
import org.clang.frontend.serialized_diags.*;
import static org.clang.frontend.serialized_diags.*;
import org.llvm.bitcode.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 143,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 142,
 FQN="(anonymous namespace)::SDiagsWriter", NM="_ZN12_GLOBAL__N_112SDiagsWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriterE")
//</editor-fold>
public class SDiagsWriter extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  /*friend  class SDiagsRenderer*/
  /*friend  class SDiagsMerger*/
  
  
  /// \brief State that is shared among the various clones of this diagnostic
  /// consumer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::SharedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 257,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 146,
   FQN="(anonymous namespace)::SDiagsWriter::SharedState", NM="_ZN12_GLOBAL__N_112SDiagsWriter11SharedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter11SharedStateE")
  //</editor-fold>
  /*friend*//*private*/ static class/*struct*/ SharedState extends /**/ RefCountedBase<SharedState> implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::SharedState::SharedState">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 258,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 257,
     FQN="(anonymous namespace)::SDiagsWriter::SharedState::SharedState", NM="_ZN12_GLOBAL__N_112SDiagsWriter11SharedStateC1EN4llvm9StringRefEPN5clang17DiagnosticOptionsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter11SharedStateC1EN4llvm9StringRefEPN5clang17DiagnosticOptionsE")
    //</editor-fold>
    public SharedState(StringRef File, DiagnosticOptions /*P*/ Diags) {
      // : RefCountedBase<SharedState>(), DiagOpts(Diags), Buffer(), Stream(Buffer), OutputFile(File.str()), Abbrevs(), Record(), diagBuf(), Categories(), Files(), DiagFlags(), EmittedAnyDiagBlocks(false), MetaDiagnostics() 
      //START JInit
      super();
      this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(Diags);
      this.Buffer = new SmallString/*1024*/(1024);
      this.Stream = new BitstreamWriter(Buffer);
      this.OutputFile = File.str();
      this.Abbrevs = new AbbreviationMap();
      this.Record = new SmallVectorULong(64, 0);
      this.diagBuf = new SmallString/*256*/(256);
      this.Categories = new DenseSetUInt(DenseMapInfoUInt.$Info());
      this.Files = new DenseMapTypeUInt</*const*/char$ptr/*char P*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
      this.DiagFlags = new DenseMap</*const*/Object/*void P*/ , std.pairUIntType<StringRef> >(DenseMapInfoVoid$Ptr.$Info(), new std.pairUIntType(0, new StringRef()));
      this.EmittedAnyDiagBlocks = false;
      this.MetaDiagnostics = new std.unique_ptr<DiagnosticsEngine>();
      //END JInit
    }

    
    /// \brief Diagnostic options.
    public IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
    
    /// \brief The byte buffer for the serialized content.
    public SmallString/*1024*/ Buffer;
    
    /// \brief The BitStreamWriter for the serialized diagnostics.
    public BitstreamWriter Stream;
    
    /// \brief The name of the diagnostics file.
    public std.string OutputFile;
    
    /// \brief The set of constructed record abbreviations.
    public AbbreviationMap Abbrevs;
    
    /// \brief A utility buffer for constructing record content.
    public SmallVectorULong Record;
    
    /// \brief A text buffer for rendering diagnostic text.
    public SmallString/*256*/ diagBuf;
    
    /// \brief The collection of diagnostic categories used.
    public DenseSetUInt Categories;
    
    /// \brief The collection of files used.
    public DenseMapTypeUInt</*const*/char$ptr/*char P*/> Files;
    
    /*typedef llvm::DenseMap<const void *, std::pair<unsigned int, StringRef> > DiagFlagsTy*/
//    public final class DiagFlagsTy extends DenseMap</*const*/Object/*void P*/ , std.pairUIntType<StringRef> >{ };
    
    /// \brief Map for uniquing strings.
    public DenseMap</*const*/Object/*void P*/ , std.pairUIntType<StringRef> > DiagFlags;
    
    /// \brief Whether we have already started emission of any DIAG blocks. Once
    /// this becomes \c true, we never close a DIAG block until we know that we're
    /// starting another one or we're done.
    public boolean EmittedAnyDiagBlocks;
    
    /// \brief Engine for emitting diagnostics about the diagnostics.
    public std.unique_ptr<DiagnosticsEngine> MetaDiagnostics;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::SharedState::~SharedState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 257,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 256,
     FQN="(anonymous namespace)::SDiagsWriter::SharedState::~SharedState", NM="_ZN12_GLOBAL__N_112SDiagsWriter11SharedStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter11SharedStateD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      MetaDiagnostics.$destroy();
      DiagFlags.$destroy();
      Files.$destroy();
      Categories.$destroy();
      diagBuf.$destroy();
      Record.$destroy();
      Abbrevs.$destroy();
      OutputFile.$destroy();
      Stream.$destroy();
      Buffer.$destroy();
      DiagOpts.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "DiagOpts=" + DiagOpts // NOI18N
                + ", Buffer=" + Buffer // NOI18N
                + ", Stream=" + Stream // NOI18N
                + ", OutputFile=" + OutputFile // NOI18N
                + ", Abbrevs=" + Abbrevs // NOI18N
                + ", Record=" + Record // NOI18N
                + ", diagBuf=" + diagBuf // NOI18N
                + ", Categories=" + Categories // NOI18N
                + ", Files=" + Files // NOI18N
                + ", DiagFlags=" + DiagFlags // NOI18N
                + ", EmittedAnyDiagBlocks=" + EmittedAnyDiagBlocks // NOI18N
                + ", MetaDiagnostics=" + MetaDiagnostics // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::SDiagsWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 148,
   FQN="(anonymous namespace)::SDiagsWriter::SDiagsWriter", NM="_ZN12_GLOBAL__N_112SDiagsWriterC1EN4llvm18IntrusiveRefCntPtrINS0_11SharedStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriterC1EN4llvm18IntrusiveRefCntPtrINS0_11SharedStateEEE")
  //</editor-fold>
  private /*explicit*/ SDiagsWriter(IntrusiveRefCntPtr<SharedState> State) {
    // : DiagnosticConsumer(), LangOpts(null), OriginalInstance(false), MergeChildRecords(false), State(std::move(State)) 
    //START JInit
    super();
    this.LangOpts = null;
    this.OriginalInstance = false;
    this.MergeChildRecords = false;
    this.State = new IntrusiveRefCntPtr<SharedState>(JD$Move.INSTANCE, std.move(State));
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::SDiagsWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 154,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 153,
   FQN="(anonymous namespace)::SDiagsWriter::SDiagsWriter", NM="_ZN12_GLOBAL__N_112SDiagsWriterC1EN4llvm9StringRefEPN5clang17DiagnosticOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriterC1EN4llvm9StringRefEPN5clang17DiagnosticOptionsEb")
  //</editor-fold>
  public SDiagsWriter(StringRef File, DiagnosticOptions /*P*/ Diags, boolean MergeChildRecords) {
    // : DiagnosticConsumer(), LangOpts(null), OriginalInstance(true), MergeChildRecords(MergeChildRecords), State(new SharedState(File, Diags)) 
    //START JInit
    super();
    this.LangOpts = null;
    this.OriginalInstance = true;
    this.MergeChildRecords = MergeChildRecords;
    this.State = new IntrusiveRefCntPtr<SharedState>(new SharedState(new StringRef(File), Diags));
    //END JInit
    if (MergeChildRecords) {
      RemoveOldDiagnostics();
    }
    EmitPreamble();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::~SDiagsWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 163,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 162,
   FQN="(anonymous namespace)::SDiagsWriter::~SDiagsWriter", NM="_ZN12_GLOBAL__N_112SDiagsWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriterD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    State.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 585,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 584,
   FQN="(anonymous namespace)::SDiagsWriter::HandleDiagnostic", NM="_ZN12_GLOBAL__N_112SDiagsWriter16HandleDiagnosticEN5clang17DiagnosticsEngine5LevelERKNS1_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter16HandleDiagnosticEN5clang17DiagnosticsEngine5LevelERKNS1_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, 
                  final /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    SDiagsRenderer Renderer = null;
    try {
      // Enter the block for a non-note diagnostic immediately, rather than waiting
      // for beginDiagnostic, in case associated notes are emitted before we get
      // there.
      if (DiagLevel != DiagnosticsEngine.Level.Note) {
        if (State.$arrow().EmittedAnyDiagBlocks) {
          ExitDiagBlock();
        }
        
        EnterDiagBlock();
        State.$arrow().EmittedAnyDiagBlocks = true;
      }
      
      // Compute the diagnostic text.
      State.$arrow().diagBuf.clear();
      Info.FormatDiagnostic(State.$arrow().diagBuf);
      if (Info.getLocation().isInvalid()) {
        // Special-case diagnostics with no location. We may not have entered a
        // source file in this case, so we can't use the normal DiagnosticsRenderer
        // machinery.
        
        // Make sure we bracket all notes as "sub-diagnostics".  This matches
        // the behavior in SDiagsRenderer::emitDiagnostic().
        if (DiagLevel == DiagnosticsEngine.Level.Note) {
          EnterDiagBlock();
        }
        
        EmitDiagnosticMessage(new SourceLocation(), new PresumedLoc(), DiagLevel, 
            State.$arrow().diagBuf.$StringRef(), (/*const*/ SourceManager /*P*/ )null, new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(JD$T.INSTANCE, Diagnostic.class, /*AddrOf*/Info));
        if (DiagLevel == DiagnosticsEngine.Level.Note) {
          ExitDiagBlock();
        }
        
        return;
      }
      assert (Info.hasSourceManager() && (LangOpts != null)) : "Unexpected diagnostic with valid location outside of a source file";
      Renderer/*J*/= new SDiagsRenderer(/*Deref*/this, /*Deref*/LangOpts, /*AddrOf*/State.$arrow().DiagOpts.$star());
      Renderer.emitDiagnostic(new SourceLocation(Info.getLocation()), DiagLevel, 
          State.$arrow().diagBuf.$StringRef(), 
          Info.getRanges(), 
          Info.getFixItHints(), 
          /*AddrOf*/Info.getSourceManager(), 
          new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(JD$T.INSTANCE, Diagnostic.class, /*AddrOf*/Info));
    } finally {
      if (Renderer != null) { Renderer.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::BeginSourceFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 167,
   FQN="(anonymous namespace)::SDiagsWriter::BeginSourceFile", NM="_ZN12_GLOBAL__N_112SDiagsWriter15BeginSourceFileERKN5clang11LangOptionsEPKNS1_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter15BeginSourceFileERKN5clang11LangOptionsEPKNS1_12PreprocessorE")
  //</editor-fold>
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LO, /*const*/ PreprocessorImplementation /*P*/ PP)/* override*/ {
    LangOpts = /*AddrOf*/LO;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::finish">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*front()=>data$Const()*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 790,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 789,
   FQN="(anonymous namespace)::SDiagsWriter::finish", NM="_ZN12_GLOBAL__N_112SDiagsWriter6finishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter6finishEv")
  //</editor-fold>
  @Override public void finish()/* override*/ {
    unique_ptr<raw_fd_ostream> OS = null;
    try {
      // The original instance is responsible for writing the file.
      if (!OriginalInstance) {
        return;
      }
      
      // Finish off any diagnostic we were in the process of emitting.
      if (State.$arrow().EmittedAnyDiagBlocks) {
        ExitDiagBlock();
      }
      if (MergeChildRecords) {
        if (!State.$arrow().EmittedAnyDiagBlocks) {
          // We have no diagnostics of our own, so we can just leave the child
          // process' output alone
          return;
        }
        if (fs.exists(new Twine(State.$arrow().OutputFile))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if ($c$.clean($c$.track(new SDiagsMerger(/*Deref*/this)).mergeRecordsFromFile(State.$arrow().OutputFile.c_str()).$bool())) {
              $c$.clean($c$.track(getMetaDiags().Report(diag.warn_fe_serialized_diag_merge_failure)));
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      std.error_code EC/*J*/= new std.error_code();
      OS = llvm.make_unique(new raw_fd_ostream(State.$arrow().OutputFile.c_str(), 
          EC, fs.OpenFlags.F_None));
      if (EC.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getMetaDiags().Report(diag.warn_fe_serialized_diag_failure)), 
                  new StringRef(State.$arrow().OutputFile)), new StringRef(EC.message())));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Write the generated bitstream to "Out".
      OS.$arrow().write(reinterpret_cast(char$ptr/*char P*/ .class, /*AddrOf*/State.$arrow().Buffer.data$Const/*front*/()), State.$arrow().Buffer.size());
      OS.$arrow().flush();
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

/*private:*/
  /// \brief Build a DiagnosticsEngine to emit diagnostics about the diagnostics
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::getMetaDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 756,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 755,
   FQN="(anonymous namespace)::SDiagsWriter::getMetaDiags", NM="_ZN12_GLOBAL__N_112SDiagsWriter12getMetaDiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter12getMetaDiagsEv")
  //</editor-fold>
  private DiagnosticsEngine /*P*/ getMetaDiags() {
    // FIXME: It's slightly absurd to create a new diagnostics engine here, but
    // the other options that are available today are worse:
    //
    // 1. Teach DiagnosticsConsumers to emit diagnostics to the engine they are a
    //    part of. The DiagnosticsEngine would need to know not to send
    //    diagnostics back to the consumer that failed. This would require us to
    //    rework ChainedDiagnosticsConsumer and teach the engine about multiple
    //    consumers, which is difficult today because most APIs interface with
    //    consumers rather than the engine itself.
    //
    // 2. Pass a DiagnosticsEngine to SDiagsWriter on creation - this would need
    //    to be distinct from the engine the writer was being added to and would
    //    normally not be used.
    if (!State.$arrow().MetaDiagnostics.$bool()) {
      IntrusiveRefCntPtr<DiagnosticIDs> IDs = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        IDs/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
        TextDiagnosticPrinter /*P*/ Client = new TextDiagnosticPrinter(llvm.errs(), State.$arrow().DiagOpts.get());
        $c$.clean(State.$arrow().MetaDiagnostics.$assignMove($c$.track(llvm.make_unique(new DiagnosticsEngine(IDs, State.$arrow().DiagOpts.get(), Client)))));
      } finally {
        if (IDs != null) { IDs.$destroy(); }
        $c$.$destroy();
      }
    }
    return State.$arrow().MetaDiagnostics.get();
  }

  
  /// \brief Remove old copies of the serialized diagnostics. This is necessary
  /// so that we can detect when subprocesses write diagnostics that we should
  /// merge into our own.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::RemoveOldDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 779,
   FQN="(anonymous namespace)::SDiagsWriter::RemoveOldDiagnostics", NM="_ZN12_GLOBAL__N_112SDiagsWriter20RemoveOldDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter20RemoveOldDiagnosticsEv")
  //</editor-fold>
  private void RemoveOldDiagnostics() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!fs.remove(new Twine(State.$arrow().OutputFile)).$bool()) {
        return;
      }
      
      $c$.clean($c$.track(getMetaDiags().Report(diag.warn_fe_serialized_diag_merge_failure)));
      // Disable merging child records, as whatever is in this file may be
      // misleading.
      MergeChildRecords = false;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Emit the preamble for the serialized diagnostics.
  
  /// \brief Emits the preamble of the diagnostics file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EmitPreamble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 417,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 416,
   FQN="(anonymous namespace)::SDiagsWriter::EmitPreamble", NM="_ZN12_GLOBAL__N_112SDiagsWriter12EmitPreambleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter12EmitPreambleEv")
  //</editor-fold>
  private void EmitPreamble() {
    // Emit the file header.
    State.$arrow().Stream.Emit((/*uint*/int)$char2uint($$D), 8);
    State.$arrow().Stream.Emit((/*uint*/int)$char2uint($$I), 8);
    State.$arrow().Stream.Emit((/*uint*/int)$char2uint($$A), 8);
    State.$arrow().Stream.Emit((/*uint*/int)$char2uint($$G), 8);

    EmitBlockInfoBlock();
    EmitMetaBlock();
  }

  
  /// \brief Emit the BLOCKINFO block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EmitBlockInfoBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 441,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 440,
   FQN="(anonymous namespace)::SDiagsWriter::EmitBlockInfoBlock", NM="_ZN12_GLOBAL__N_112SDiagsWriter18EmitBlockInfoBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter18EmitBlockInfoBlockEv")
  //</editor-fold>
  private void EmitBlockInfoBlock() {
    State.$arrow().Stream.EnterBlockInfoBlock(3);
    
    //JAVA: using namespace llvm;
    BitstreamWriter /*&*/ Stream = State.$arrow().Stream;
    SmallVectorULong /*&*/ Record = State.$arrow().Record;
    AbbreviationMap /*&*/ Abbrevs = State.$arrow().Abbrevs;
    
    // ==---------------------------------------------------------------------==//
    // The subsequent records and Abbrevs are for the "Meta" block.
    // ==---------------------------------------------------------------------==//
    EmitBlockID(BlockIDs.BLOCK_META, $("Meta"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_VERSION.getValue(), $("Version"), Stream, Record);
    BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_VERSION.getValue()));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 32));
    Abbrevs.set(RecordIDs.RECORD_VERSION.getValue(), Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_META, Abbrev));
    
    // ==---------------------------------------------------------------------==//
    // The subsequent records and Abbrevs are for the "Diagnostic" block.
    // ==---------------------------------------------------------------------==//
    EmitBlockID(BlockIDs.BLOCK_DIAG, $("Diag"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_DIAG.getValue(), $("DiagInfo"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_SOURCE_RANGE.getValue(), $("SrcRange"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_CATEGORY.getValue(), $("CatName"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_DIAG_FLAG.getValue(), $("DiagFlag"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_FILENAME.getValue(), $("FileName"), Stream, Record);
    EmitRecordID(RecordIDs.RECORD_FIXIT.getValue(), $("FixIt"), Stream, Record);
    
    // Emit abbreviation for RECORD_DIAG.
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_DIAG.getValue()));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 3)); // Diag level.
    AddSourceLocationAbbrev(Abbrev);
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 10)); // Category.  
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 10)); // Mapped Diag ID.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, 16)); // Text size.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Diagnostc text.
    Abbrevs.set(RecordIDs.RECORD_DIAG.getValue(), Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_DIAG, Abbrev));
    
    // Emit abbrevation for RECORD_CATEGORY.
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_CATEGORY.getValue()));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 16)); // Category ID.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 8)); // Text size.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Category text.
    Abbrevs.set(RecordIDs.RECORD_CATEGORY.getValue(), Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_DIAG, Abbrev));
    
    // Emit abbrevation for RECORD_SOURCE_RANGE.
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_SOURCE_RANGE.getValue()));
    AddRangeLocationAbbrev(Abbrev);
    Abbrevs.set(RecordIDs.RECORD_SOURCE_RANGE.getValue(), 
        Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_DIAG, Abbrev));
    
    // Emit the abbreviation for RECORD_DIAG_FLAG.
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_DIAG_FLAG.getValue()));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 10)); // Mapped Diag ID.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 16)); // Text size.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Flag name text.
    Abbrevs.set(RecordIDs.RECORD_DIAG_FLAG.getValue(), Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_DIAG, 
            Abbrev));
    
    // Emit the abbreviation for RECORD_FILENAME.
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_FILENAME.getValue()));
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 10)); // Mapped file ID.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 32)); // Size.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 32)); // Modifcation time.  
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 16)); // Text size.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // File name text.
    Abbrevs.set(RecordIDs.RECORD_FILENAME.getValue(), Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_DIAG, 
            Abbrev));
    
    // Emit the abbreviation for RECORD_FIXIT.
    Abbrev = new BitCodeAbbrev();
    Abbrev.Add(new BitCodeAbbrevOp(RecordIDs.RECORD_FIXIT.getValue()));
    AddRangeLocationAbbrev(Abbrev);
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, 16)); // Text size.
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // FixIt text.
    Abbrevs.set(RecordIDs.RECORD_FIXIT.getValue(), Stream.EmitBlockInfoAbbrev(BlockIDs.BLOCK_DIAG, 
            Abbrev));
    
    Stream.ExitBlock();
  }

  
  /// \brief Emit the META data block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EmitMetaBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 530,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 529,
   FQN="(anonymous namespace)::SDiagsWriter::EmitMetaBlock", NM="_ZN12_GLOBAL__N_112SDiagsWriter13EmitMetaBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter13EmitMetaBlockEv")
  //</editor-fold>
  private void EmitMetaBlock() {
    BitstreamWriter /*&*/ Stream = State.$arrow().Stream;
    AbbreviationMap /*&*/ Abbrevs = State.$arrow().Abbrevs;
    
    Stream.EnterSubblock(BlockIDs.BLOCK_META, 3);
    /*ulong*/long Record[/*2*/] = new /*ulong*/long [/*2*/] {RecordIDs.RECORD_VERSION.getValue(), $uint2ullong(VersionNumber)};
    Stream.EmitRecordWithAbbrev(Abbrevs.get(RecordIDs.RECORD_VERSION.getValue()), Record);
    Stream.ExitBlock();
  }

  
  /// \brief Start a DIAG block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EnterDiagBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 689,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 688,
   FQN="(anonymous namespace)::SDiagsWriter::EnterDiagBlock", NM="_ZN12_GLOBAL__N_112SDiagsWriter14EnterDiagBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter14EnterDiagBlockEv")
  //</editor-fold>
  /*friend*//*private*/ void EnterDiagBlock() {
    State.$arrow().Stream.EnterSubblock(BlockIDs.BLOCK_DIAG, 4);
  }

  
  /// \brief End a DIAG block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::ExitDiagBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 693,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 692,
   FQN="(anonymous namespace)::SDiagsWriter::ExitDiagBlock", NM="_ZN12_GLOBAL__N_112SDiagsWriter13ExitDiagBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter13ExitDiagBlockEv")
  //</editor-fold>
  /*friend*//*private*/ void ExitDiagBlock() {
    State.$arrow().Stream.ExitBlock();
  }

  
  /// \brief Emit a DIAG record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EmitDiagnosticMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 647,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 646,
   FQN="(anonymous namespace)::SDiagsWriter::EmitDiagnosticMessage", NM="_ZN12_GLOBAL__N_112SDiagsWriter21EmitDiagnosticMessageEN5clang14SourceLocationENS1_11PresumedLocENS1_17DiagnosticsEngine5LevelEN4llvm9StringRefEPKNS1_13SourceManagerENS6_12PointerUnionIPKNS1_10DiagnosticEPKNS1_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter21EmitDiagnosticMessageEN5clang14SourceLocationENS1_11PresumedLocENS1_17DiagnosticsEngine5LevelEN4llvm9StringRefEPKNS1_13SourceManagerENS6_12PointerUnionIPKNS1_10DiagnosticEPKNS1_16StoredDiagnosticEEE")
  //</editor-fold>
  /*friend*//*private*/ void EmitDiagnosticMessage(SourceLocation Loc, 
                       PresumedLoc PLoc, 
                       DiagnosticsEngine.Level Level, 
                       StringRef Message, 
                       /*const*/ SourceManager /*P*/ SM, 
                       PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D) {
    BitstreamWriter /*&*/ Stream = State.$arrow().Stream;
    SmallVectorULong /*&*/ Record = State.$arrow().Record;
    AbbreviationMap /*&*/ Abbrevs = State.$arrow().Abbrevs;
    
    // Emit the RECORD_DIAG record.
    Record.clear();
    Record.push_back(RecordIDs.RECORD_DIAG.getValue());
    Record.push_back(getStableLevel(Level).getValue());
    AddLocToRecord(new SourceLocation(Loc), SM, new PresumedLoc(PLoc), Record);
    {
      
      /*const*/ Diagnostic /*P*/ Info = D.dyn_cast(/*const*/ Diagnostic /*P*/ .class);
      if ((Info != null)) {
        // Emit the category string lazily and get the category ID.
        /*uint*/int DiagID = DiagnosticIDs.getCategoryNumberForDiag(Info.getID());
        Record.push_back($uint2ullong(getEmitCategory(DiagID)));
        // Emit the diagnostic flag string lazily and get the mapped ID.
        Record.push_back($uint2ullong(getEmitDiagnosticFlag(Level, Info.getID())));
      } else {
        Record.push_back($uint2ullong(getEmitCategory()));
        Record.push_back($uint2ullong(getEmitDiagnosticFlag(Level)));
      }
    }
    
    Record.push_back($uint2ullong(Message.size()));
    Stream.EmitRecordWithBlob(Abbrevs.get(RecordIDs.RECORD_DIAG.getValue()), Record, new StringRef(Message));
  }

  
  /// \brief Emit FIXIT and SOURCE_RANGE records for a diagnostic.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EmitCodeContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 711,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 710,
   FQN="(anonymous namespace)::SDiagsWriter::EmitCodeContext", NM="_ZN12_GLOBAL__N_112SDiagsWriter15EmitCodeContextERN4llvm15SmallVectorImplIN5clang15CharSourceRangeEEENS1_8ArrayRefINS3_9FixItHintEEERKNS3_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter15EmitCodeContextERN4llvm15SmallVectorImplIN5clang15CharSourceRangeEEENS1_8ArrayRefINS3_9FixItHintEEERKNS3_13SourceManagerE")
  //</editor-fold>
  /*friend*//*private*/ void EmitCodeContext(SmallVectorImpl<CharSourceRange> /*&*/ Ranges, 
                 ArrayRef<FixItHint> Hints, 
                 /*const*/ SourceManager /*&*/ SM) {
    BitstreamWriter /*&*/ Stream = State.$arrow().Stream;
    SmallVectorULong /*&*/ Record = State.$arrow().Record;
    AbbreviationMap /*&*/ Abbrevs = State.$arrow().Abbrevs;
    
    // Emit Source Ranges.
    for (type$ptr<CharSourceRange> I = Ranges.begin(), /*P*/ E = Ranges.end();
         I.$noteq(E); I.$preInc())  {
      if (I.$arrow().isValid()) {
        EmitCharSourceRange(new CharSourceRange(/*Deref*/I.$star()), SM);
      }
    }
    
    // Emit FixIts.
    for (type$ptr<FixItHint> I = $tryClone(Hints.begin()), /*P*/ E = Hints.end();
         I.$noteq(E); I.$preInc()) {
      /*const*/ FixItHint /*&*/ Fix = /*Deref*/I.$star();
      if (Fix.isNull()) {
        continue;
      }
      Record.clear();
      Record.push_back(RecordIDs.RECORD_FIXIT.getValue());
      AddCharSourceRangeToRecord(new CharSourceRange(Fix.RemoveRange), Record, SM);
      Record.push_back($uint2ullong(Fix.CodeToInsert.size()));
      Stream.EmitRecordWithBlob(Abbrevs.get(RecordIDs.RECORD_FIXIT.getValue()), Record, 
          new StringRef(Fix.CodeToInsert));
    }
  }

  
  /// \brief Emit a record for a CharSourceRange.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::EmitCharSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 407,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 406,
   FQN="(anonymous namespace)::SDiagsWriter::EmitCharSourceRange", NM="_ZN12_GLOBAL__N_112SDiagsWriter19EmitCharSourceRangeEN5clang15CharSourceRangeERKNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter19EmitCharSourceRangeEN5clang15CharSourceRangeERKNS1_13SourceManagerE")
  //</editor-fold>
  private void EmitCharSourceRange(CharSourceRange R, 
                     /*const*/ SourceManager /*&*/ SM) {
    State.$arrow().Record.clear();
    State.$arrow().Record.push_back(RecordIDs.RECORD_SOURCE_RANGE.getValue());
    AddCharSourceRangeToRecord(new CharSourceRange(R), State.$arrow().Record, SM);
    State.$arrow().Stream.EmitRecordWithAbbrev(State.$arrow().Abbrevs.get(RecordIDs.RECORD_SOURCE_RANGE.getValue()), 
        State.$arrow().Record);
  }

  
  /// \brief Emit the string information for the category.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::getEmitCategory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 540,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 539,
   FQN="(anonymous namespace)::SDiagsWriter::getEmitCategory", NM="_ZN12_GLOBAL__N_112SDiagsWriter15getEmitCategoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter15getEmitCategoryEj")
  //</editor-fold>
  /*friend*//*private*/ /*uint*/int getEmitCategory() {
    return getEmitCategory(0);
  }
  /*friend*//*private*/ /*uint*/int getEmitCategory(/*uint*/int category/*= 0*/) {
    if (!State.$arrow().Categories.insert(category).second) {
      return category;
    }
    
    // We use a local version of 'Record' so that we can be generating
    // another record when we lazily generate one for the category entry.
    StringRef catName = DiagnosticIDs.getCategoryNameFromID(category);
    /*SmallVectorULong.value_type*/long Record[/*3*/] = new /*SmallVectorULong.value_type*/long [/*3*/] {RecordIDs.RECORD_CATEGORY.getValue(), $uint2ullong(category), $uint2ullong(catName.size())};
    State.$arrow().Stream.EmitRecordWithBlob(State.$arrow().Abbrevs.get(RecordIDs.RECORD_CATEGORY.getValue()), Record, 
        new StringRef(catName));
    
    return category;
  }

  
  /// \brief Emit the string information for diagnostic flags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::getEmitDiagnosticFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 554,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 553,
   FQN="(anonymous namespace)::SDiagsWriter::getEmitDiagnosticFlag", NM="_ZN12_GLOBAL__N_112SDiagsWriter21getEmitDiagnosticFlagEN5clang17DiagnosticsEngine5LevelEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter21getEmitDiagnosticFlagEN5clang17DiagnosticsEngine5LevelEj")
  //</editor-fold>
  private /*uint*/int getEmitDiagnosticFlag(DiagnosticsEngine.Level DiagLevel) {
    return getEmitDiagnosticFlag(DiagLevel, 
                       0);
  }
  private /*uint*/int getEmitDiagnosticFlag(DiagnosticsEngine.Level DiagLevel, 
                       /*uint*/int DiagID/*= 0*/) {
    if (DiagLevel == DiagnosticsEngine.Level.Note) {
      return 0; // No flag for notes.
    }
    
    StringRef FlagName = DiagnosticIDs.getWarningOptionForDiag(DiagID);
    return getEmitDiagnosticFlag(new StringRef(FlagName));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::getEmitDiagnosticFlag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 563,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 562,
   FQN="(anonymous namespace)::SDiagsWriter::getEmitDiagnosticFlag", NM="_ZN12_GLOBAL__N_112SDiagsWriter21getEmitDiagnosticFlagEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter21getEmitDiagnosticFlagEN4llvm9StringRefE")
  //</editor-fold>
  /*friend*//*private*/ /*uint*/int getEmitDiagnosticFlag(StringRef FlagName) {
    if (FlagName.empty()) {
      return 0;
    }
    
    // Here we assume that FlagName points to static data whose pointer
    // value is fixed.  This allows us to unique by diagnostic groups.
    /*const*/Object/*void P*/ data = $tryClone(FlagName.data());
    std.pairUIntType<StringRef> /*&*/ entry = State.$arrow().DiagFlags.$at(data);
    if (entry.first == 0) {
      entry.first = State.$arrow().DiagFlags.size();
      entry.second.$assign(FlagName);
      
      // Lazily emit the string in a separate record.
      /*SmallVectorULong.value_type*/long Record[/*3*/] = new /*SmallVectorULong.value_type*/long [/*3*/] {
        RecordIDs.RECORD_DIAG_FLAG.getValue(), $uint2ullong(entry.first), 
        $uint2ullong(FlagName.size())};
      State.$arrow().Stream.EmitRecordWithBlob(State.$arrow().Abbrevs.get(RecordIDs.RECORD_DIAG_FLAG.getValue()), 
          Record, new StringRef(FlagName));
    }
    
    return entry.first;
  }

  
  /// \brief Emit (lazily) the file string and retrieved the file identifier.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::getEmitFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 388,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 387,
   FQN="(anonymous namespace)::SDiagsWriter::getEmitFile", NM="_ZN12_GLOBAL__N_112SDiagsWriter11getEmitFileEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter11getEmitFileEPKc")
  //</editor-fold>
  /*friend*//*private*/ /*uint*/int getEmitFile(/*const*/char$ptr/*char P*/ FileName) {
    if (!(FileName != null)) {
      return 0;
    }
    
    uint$ref/*uint &*/ entry = State.$arrow().Files.ref$at(FileName);
    if ((entry.$deref() != 0)) {
      return entry.$deref();
    }
    
    // Lazily generate the record for the file.
    entry.$set(State.$arrow().Files.size());
    StringRef Name/*J*/= new StringRef(FileName);
    /*SmallVectorULong.value_type*/long Record[/*5*/] = new /*SmallVectorULong.value_type*/long [/*5*/] {
      RecordIDs.RECORD_FILENAME.getValue(), $uint2ullong(entry.$deref()), 0/* For legacy */, 
      0/* For legacy */, $uint2ullong(Name.size())};
    State.$arrow().Stream.EmitRecordWithBlob(State.$arrow().Abbrevs.get(RecordIDs.RECORD_FILENAME.getValue()), Record, 
        new StringRef(Name));
    
    return entry.$deref();
  }

  
  /// \brief Add SourceLocation information the specified record.  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::AddLocToRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 356,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 355,
   FQN="(anonymous namespace)::SDiagsWriter::AddLocToRecord", NM="_ZN12_GLOBAL__N_112SDiagsWriter14AddLocToRecordEN5clang14SourceLocationEPKNS1_13SourceManagerENS1_11PresumedLocERN4llvm15SmallVectorImplIyEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter14AddLocToRecordEN5clang14SourceLocationEPKNS1_13SourceManagerENS1_11PresumedLocERN4llvm15SmallVectorImplIyEEj")
  //</editor-fold>
  private void AddLocToRecord(SourceLocation Loc, 
                /*const*/ SourceManager /*P*/ SM, 
                PresumedLoc PLoc, 
                SmallVectorImplULong /*&*/ Record) {
    AddLocToRecord(Loc, 
                SM, 
                PLoc, 
                Record, 
                0);
  }
  private void AddLocToRecord(SourceLocation Loc, 
                /*const*/ SourceManager /*P*/ SM, 
                PresumedLoc PLoc, 
                SmallVectorImplULong /*&*/ Record, 
                /*uint*/int TokSize/*= 0*/) {
    if (PLoc.isInvalid()) {
      // Emit a "sentinel" location.
      Record.push_back($uint2ullong((/*uint*/int)0)); // File.
      Record.push_back($uint2ullong((/*uint*/int)0)); // Line.
      Record.push_back($uint2ullong((/*uint*/int)0)); // Column.
      Record.push_back($uint2ullong((/*uint*/int)0)); // Offset.
      return;
    }
    
    Record.push_back($uint2ullong(getEmitFile(PLoc.getFilename())));
    Record.push_back($uint2ullong(PLoc.getLine()));
    Record.push_back($uint2ullong(PLoc.getColumn() + TokSize));
    Record.push_back($uint2ullong(SM.getFileOffset(/*NO_COPY*/Loc)));
  }

  
  /// \brief Add SourceLocation information the specified record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::AddLocToRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 231,
   FQN="(anonymous namespace)::SDiagsWriter::AddLocToRecord", NM="_ZN12_GLOBAL__N_112SDiagsWriter14AddLocToRecordEN5clang14SourceLocationERN4llvm15SmallVectorImplIyEEPKNS1_13SourceManagerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter14AddLocToRecordEN5clang14SourceLocationERN4llvm15SmallVectorImplIyEEPKNS1_13SourceManagerEj")
  //</editor-fold>
  private void AddLocToRecord(SourceLocation Loc, SmallVectorImplULong /*&*/ Record, 
                /*const*/ SourceManager /*P*/ SM) {
    AddLocToRecord(Loc, Record, 
                SM, 
                0);
  }
  private void AddLocToRecord(SourceLocation Loc, SmallVectorImplULong /*&*/ Record, 
                /*const*/ SourceManager /*P*/ SM, 
                /*uint*/int TokSize/*= 0*/) {
    AddLocToRecord(new SourceLocation(Loc), SM, (SM != null) ? SM.getPresumedLoc(/*NO_COPY*/Loc) : new PresumedLoc(), 
        Record, TokSize);
  }

  
  /// \brief Add CharSourceRange information the specified record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsWriter::AddCharSourceRangeToRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 376,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 375,
   FQN="(anonymous namespace)::SDiagsWriter::AddCharSourceRangeToRecord", NM="_ZN12_GLOBAL__N_112SDiagsWriter26AddCharSourceRangeToRecordEN5clang15CharSourceRangeERN4llvm15SmallVectorImplIyEERKNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_112SDiagsWriter26AddCharSourceRangeToRecordEN5clang15CharSourceRangeERN4llvm15SmallVectorImplIyEERKNS1_13SourceManagerE")
  //</editor-fold>
  private void AddCharSourceRangeToRecord(CharSourceRange Range, 
                            SmallVectorImplULong /*&*/ Record, 
                            /*const*/ SourceManager /*&*/ SM) {
    AddLocToRecord(Range.getBegin(), Record, /*AddrOf*/SM);
    /*uint*/int TokSize = 0;
    if (Range.isTokenRange()) {
      TokSize = Lexer.MeasureTokenLength(Range.getEnd(), 
          SM, /*Deref*/LangOpts);
    }
    
    AddLocToRecord(Range.getEnd(), Record, /*AddrOf*/SM, TokSize);
  }

  
  /// \brief Language options, which can differ from one clone of this client
  /// to another.
  private /*const*/ LangOptions /*P*/ LangOpts;
  
  /// \brief Whether this is the original instance (rather than one of its
  /// clones), responsible for writing the file at the end.
  private boolean OriginalInstance;
  
  /// \brief Whether this instance should aggregate diagnostics that are
  /// generated from child processes.
  private boolean MergeChildRecords;
  
  /// \brief State shared among the various clones of this diagnostic consumer.
  /*friend*//*private*/ IntrusiveRefCntPtr<SharedState> State;
  
  @Override public String toString() {
    return "" + "LangOpts=" + LangOpts // NOI18N
              + ", OriginalInstance=" + OriginalInstance // NOI18N
              + ", MergeChildRecords=" + MergeChildRecords // NOI18N
              + ", State=" + State // NOI18N
              + super.toString(); // NOI18N
  }
}
