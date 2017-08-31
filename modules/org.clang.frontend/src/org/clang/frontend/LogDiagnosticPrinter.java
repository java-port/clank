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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.markup.MarkupGlobals.*;
import org.clang.basic.spi.PreprocessorImplementation;
import static org.clang.frontend.impl.LogDiagnosticPrinterStatics.*;
import org.clang.frontend.*;

//<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 22,
 FQN="clang::LogDiagnosticPrinter", NM="_ZN5clang20LogDiagnosticPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinterE")
//</editor-fold>
public class LogDiagnosticPrinter extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::DiagEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*POD*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 23,
   FQN="clang::LogDiagnosticPrinter::DiagEntry", NM="_ZN5clang20LogDiagnosticPrinter9DiagEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter9DiagEntryE")
  //</editor-fold>
  private static class/*struct*/ DiagEntry implements Destructors.ClassWithDestructor, NativePOD<DiagEntry> {
    /// The primary message line of the diagnostic.
    public std.string Message;
    
    /// The source file name, if available.
    public std.string Filename;
    
    /// The source file line number, if available.
    public /*uint*/int Line;
    
    /// The source file column number, if available.
    public /*uint*/int Column;
    
    /// The ID of the diagnostic.
    public /*uint*/int DiagnosticID;
    
    /// The Option Flag for the diagnostic
    public std.string WarningOption;
    
    /// The level of the diagnostic.
    public DiagnosticsEngine.Level DiagnosticLevel;
    //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::DiagEntry::DiagEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 23,
     FQN="clang::LogDiagnosticPrinter::DiagEntry::DiagEntry", NM="_ZN5clang20LogDiagnosticPrinter9DiagEntryC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter9DiagEntryC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DiagEntry(/*const*/ DiagEntry /*&*/ $Prm0) {
      // : Message(.Message), Filename(.Filename), Line(.Line), Column(.Column), DiagnosticID(.DiagnosticID), WarningOption(.WarningOption), DiagnosticLevel(.DiagnosticLevel) 
      //START JInit
      this.Message = new std.string($Prm0.Message);
      this.Filename = new std.string($Prm0.Filename);
      this.Line = $Prm0.Line;
      this.Column = $Prm0.Column;
      this.DiagnosticID = $Prm0.DiagnosticID;
      this.WarningOption = new std.string($Prm0.WarningOption);
      this.DiagnosticLevel = $Prm0.DiagnosticLevel;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::DiagEntry::DiagEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 23,
     FQN="clang::LogDiagnosticPrinter::DiagEntry::DiagEntry", NM="_ZN5clang20LogDiagnosticPrinter9DiagEntryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter9DiagEntryC1EOS1_")
    //</editor-fold>
    public /*inline*/ DiagEntry(JD$Move _dparam, DiagEntry /*&&*/$Prm0) {
      // : Message(static_cast<DiagEntry &&>().Message), Filename(static_cast<DiagEntry &&>().Filename), Line(static_cast<DiagEntry &&>().Line), Column(static_cast<DiagEntry &&>().Column), DiagnosticID(static_cast<DiagEntry &&>().DiagnosticID), WarningOption(static_cast<DiagEntry &&>().WarningOption), DiagnosticLevel(static_cast<DiagEntry &&>().DiagnosticLevel) 
      //START JInit
      this.Message = new std.string(JD$Move.INSTANCE, $Prm0.Message);
      this.Filename = new std.string(JD$Move.INSTANCE, $Prm0.Filename);
      this.Line = $Prm0.Line;
      this.Column = $Prm0.Column;
      this.DiagnosticID = $Prm0.DiagnosticID;
      this.WarningOption = new std.string(JD$Move.INSTANCE, $Prm0.WarningOption);
      this.DiagnosticLevel = $Prm0.DiagnosticLevel;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::DiagEntry::~DiagEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 23,
     FQN="clang::LogDiagnosticPrinter::DiagEntry::~DiagEntry", NM="_ZN5clang20LogDiagnosticPrinter9DiagEntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter9DiagEntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      WarningOption.$destroy();
      Filename.$destroy();
      Message.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::DiagEntry::DiagEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 23,
     FQN="clang::LogDiagnosticPrinter::DiagEntry::DiagEntry", NM="_ZN5clang20LogDiagnosticPrinter9DiagEntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter9DiagEntryC1Ev")
    //</editor-fold>
    public /*inline*/ DiagEntry() {
      // : Message(), Filename(), WarningOption() 
      //START JInit
      this.Message = new std.string();
      this.Filename = new std.string();
      this.WarningOption = new std.string();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Message=" + Message // NOI18N
                + ", Filename=" + Filename // NOI18N
                + ", Line=" + Line // NOI18N
                + ", Column=" + Column // NOI18N
                + ", DiagnosticID=" + DiagnosticID // NOI18N
                + ", WarningOption=" + WarningOption // NOI18N
                + ", DiagnosticLevel=" + DiagnosticLevel; // NOI18N
    }
    

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override public DiagEntry $assign(DiagEntry $Prm0) {
      //START JInit
      this.Message.$assign($Prm0.Message);
      this.Filename.$assign($Prm0.Filename);
      this.Line = $Prm0.Line;
      this.Column = $Prm0.Column;
      this.DiagnosticID = $Prm0.DiagnosticID;
      this.WarningOption.$assign($Prm0.WarningOption);
      this.DiagnosticLevel = $Prm0.DiagnosticLevel;
      //END JInit
      return this;
    }

        
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override public DiagEntry clone() {
      return new DiagEntry(this);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override public boolean $eq(DiagEntry other) {
      if (this.Line != other.Line) {
        return false;
      }
      if (this.Column != other.Column) {
        return false;
      }
      if (this.DiagnosticID != other.DiagnosticID) {
        return false;
      }
      if (this.DiagnosticLevel != other.DiagnosticLevel) {
        return false;
      }
      if (!this.Message.$eq(other.Message)) {
        return false;
      }
      if (this.Filename.$eq(other.Filename)) {
        return false;
      }
      if (!this.WarningOption.$eq(other.WarningOption)) {
        return false;
      }
      return true;
    }    
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::EmitDiagEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp", line = 39,
   FQN="clang::LogDiagnosticPrinter::EmitDiagEntry", NM="_ZN5clang20LogDiagnosticPrinter13EmitDiagEntryERN4llvm11raw_ostreamERKNS0_9DiagEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter13EmitDiagEntryERN4llvm11raw_ostreamERKNS0_9DiagEntryE")
  //</editor-fold>
  private void EmitDiagEntry(raw_ostream /*&*/ OS, 
               /*const*/ LogDiagnosticPrinter.DiagEntry /*&*/ DE) {
    OS.$out(/*KEEP_STR*/"    <dict>\n");
    OS.$out(/*KEEP_STR*/"      <key>level</key>\n").$out(
        /*KEEP_STR*/"      "
    );
    EmitString(OS, getLevelName(DE.DiagnosticLevel)).$out_char($$LF);
    if (!DE.Filename.empty()) {
      OS.$out(/*KEEP_STR*/"      <key>filename</key>\n").$out(
          /*KEEP_STR*/"      "
      );
      EmitString(OS, new StringRef(DE.Filename)).$out_char($$LF);
    }
    if (DE.Line != 0) {
      OS.$out(/*KEEP_STR*/"      <key>line</key>\n").$out(
          /*KEEP_STR*/"      "
      );
      EmitInteger(OS, $uint2long(DE.Line)).$out_char($$LF);
    }
    if (DE.Column != 0) {
      OS.$out(/*KEEP_STR*/"      <key>column</key>\n").$out(
          /*KEEP_STR*/"      "
      );
      EmitInteger(OS, $uint2long(DE.Column)).$out_char($$LF);
    }
    if (!DE.Message.empty()) {
      OS.$out(/*KEEP_STR*/"      <key>message</key>\n").$out(
          /*KEEP_STR*/"      "
      );
      EmitString(OS, new StringRef(DE.Message)).$out_char($$LF);
    }
    OS.$out(/*KEEP_STR*/"      <key>ID</key>\n").$out(
        /*KEEP_STR*/"      "
    );
    EmitInteger(OS, $uint2long(DE.DiagnosticID)).$out_char($$LF);
    if (!DE.WarningOption.empty()) {
      OS.$out(/*KEEP_STR*/"      <key>WarningOption</key>\n").$out(
          /*KEEP_STR*/"      "
      );
      EmitString(OS, new StringRef(DE.WarningOption)).$out_char($$LF);
    }
    OS.$out(/*KEEP_STR*/"    </dict>\n");
  }

  
  // Conditional ownership (when StreamOwner is non-null, it's keeping OS
  // alive). We might want to replace this with a wrapper for conditional
  // ownership eventually - it seems to pop up often enough.
  private raw_ostream /*&*/ OS;
  private std.unique_ptr<raw_ostream> StreamOwner;
  private /*const*/ LangOptions /*P*/ LangOpts;
  private IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
  
  private SourceLocation LastWarningLoc;
  private FullSourceLoc LastLoc;
  
  private SmallVector<DiagEntry> Entries;
  
  private std.string MainFilename;
  private std.string DwarfDebugFlags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::LogDiagnosticPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp", line = 21,
   FQN="clang::LogDiagnosticPrinter::LogDiagnosticPrinter", NM="_ZN5clang20LogDiagnosticPrinterC1ERN4llvm11raw_ostreamEPNS_17DiagnosticOptionsESt10unique_ptrIS2_St14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinterC1ERN4llvm11raw_ostreamEPNS_17DiagnosticOptionsESt10unique_ptrIS2_St14default_deleteIS2_EE")
  //</editor-fold>
  public LogDiagnosticPrinter(raw_ostream /*&*/ os, DiagnosticOptions /*P*/ diags, 
      std.unique_ptr<raw_ostream> StreamOwner) {
    // : DiagnosticConsumer(), OS(os), StreamOwner(std::move(StreamOwner)), LangOpts(null), DiagOpts(diags), LastWarningLoc(), LastLoc(), Entries(), MainFilename(), DwarfDebugFlags() 
    //START JInit
    super();
    this./*&*/OS=/*&*/os;
    this.StreamOwner = new std.unique_ptr<raw_ostream>(JD$Move.INSTANCE, std.move(StreamOwner));
    this.LangOpts = null;
    this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(diags);
    this.LastWarningLoc = new SourceLocation();
    this.LastLoc = new FullSourceLoc();
    this.Entries = new SmallVector<DiagEntry>(8, new DiagEntry());
    this.MainFilename = new std.string();
    this.DwarfDebugFlags = new std.string();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::setDwarfDebugFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 69,
   FQN="clang::LogDiagnosticPrinter::setDwarfDebugFlags", NM="_ZN5clang20LogDiagnosticPrinter18setDwarfDebugFlagsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter18setDwarfDebugFlagsEN4llvm9StringRefE")
  //</editor-fold>
  public void setDwarfDebugFlags(StringRef Value) {
    DwarfDebugFlags.$assignMove(Value.$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::BeginSourceFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PreprocessorImplementation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 73,
   FQN="clang::LogDiagnosticPrinter::BeginSourceFile", NM="_ZN5clang20LogDiagnosticPrinter15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE")
  //</editor-fold>
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LO, /*const*/ PreprocessorImplementation /*P*/ PP)/* override*/ {
    LangOpts = /*AddrOf*/LO;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::EndSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp", line = 77,
   FQN="clang::LogDiagnosticPrinter::EndSourceFile", NM="_ZN5clang20LogDiagnosticPrinter13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter13EndSourceFileEv")
  //</editor-fold>
  @Override public void EndSourceFile()/* override*/ {
    raw_svector_ostream OS = null;
    try {
      // We emit all the diagnostics in EndSourceFile. However, we don't emit any
      // entry if no diagnostics were present.
      //
      // Note that DiagnosticConsumer has no "end-of-compilation" callback, so we
      // will miss any diagnostics which are emitted after and outside the
      // translation unit processing.
      if (Entries.empty()) {
        return;
      }
      
      // Write to a temporary string to ensure atomic write of diagnostic object.
      SmallString/*512*/ Msg/*J*/= new SmallString/*512*/(512);
      OS/*J*/= new raw_svector_ostream(Msg);
      
      OS.$out(/*KEEP_STR*/"<dict>\n");
      if (!MainFilename.empty()) {
        OS.$out(/*KEEP_STR*/"  <key>main-file</key>\n").$out(
            /*KEEP_STR*/"  "
        );
        EmitString(OS, new StringRef(MainFilename)).$out_char($$LF);
      }
      if (!DwarfDebugFlags.empty()) {
        OS.$out(/*KEEP_STR*/"  <key>dwarf-debug-flags</key>\n").$out(
            /*KEEP_STR*/"  "
        );
        EmitString(OS, new StringRef(DwarfDebugFlags)).$out_char($$LF);
      }
      OS.$out(/*KEEP_STR*/"  <key>diagnostics</key>\n");
      OS.$out(/*KEEP_STR*/"  <array>\n");
      for (DiagEntry /*&*/ DE : Entries)  {
        EmitDiagEntry(OS, DE);
      }
      OS.$out(/*KEEP_STR*/"  </array>\n");
      OS.$out(/*KEEP_STR*/"</dict>\n");
      
      this.OS.$out(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp", line = 112,
   FQN="clang::LogDiagnosticPrinter::HandleDiagnostic", NM="_ZN5clang20LogDiagnosticPrinter16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinter16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level Level, 
                  /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    DiagEntry DE = null;
    try {
      // Default implementation (Warnings/errors count).
      super.HandleDiagnostic(Level, Info);
      
      // Initialize the main file name, if we haven't already fetched it.
      if (MainFilename.empty() && Info.hasSourceManager()) {
        /*const*/ SourceManager /*&*/ SM = Info.getSourceManager();
        FileID FID = SM.getMainFileID();
        if (FID.isValid()) {
          /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(/*NO_COPY*/FID);
          if ((FE != null) && FE.isValid()) {
            MainFilename.$assign_T$C$P(FE.getName());
          }
        }
      }
      
      // Create the diag entry.
      DE/*J*/= new DiagEntry();
      DE.DiagnosticID = Info.getID();
      DE.DiagnosticLevel = Level;
      
      DE.WarningOption.$assignMove(DiagnosticIDs.getWarningOptionForDiag(DE.DiagnosticID).$string());
      
      // Format the message.
      SmallString/*100*/ MessageStr/*J*/= new SmallString/*100*/(100);
      Info.FormatDiagnostic(MessageStr);
      DE.Message.$assignMove(MessageStr.str().$string());
      
      // Set the location information.
      DE.Filename.$assign_T$C$P(/*KEEP_STR*/"");
      DE.Line = DE.Column = 0;
      if (Info.getLocation().isValid() && Info.hasSourceManager()) {
        /*const*/ SourceManager /*&*/ SM = Info.getSourceManager();
        PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Info.getLocation());
        if (PLoc.isInvalid()) {
          // At least print the file name if available:
          FileID FID = SM.getFileID(/*NO_COPY*/Info.getLocation());
          if (FID.isValid()) {
            /*const*/ FileEntry /*P*/ FE = SM.getFileEntryForID(/*NO_COPY*/FID);
            if ((FE != null) && FE.isValid()) {
              DE.Filename.$assign_T$C$P(FE.getName());
            }
          }
        } else {
          DE.Filename.$assign_T$C$P(PLoc.getFilename());
          DE.Line = PLoc.getLine();
          DE.Column = PLoc.getColumn();
        }
      }
      
      // Record the diagnostic entry.
      Entries.push_back_T$C$R(DE);
    } finally {
      if (DE != null) { DE.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LogDiagnosticPrinter::~LogDiagnosticPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LogDiagnosticPrinter.h", line = 22,
   FQN="clang::LogDiagnosticPrinter::~LogDiagnosticPrinter", NM="_ZN5clang20LogDiagnosticPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LogDiagnosticPrinter.cpp -nm=_ZN5clang20LogDiagnosticPrinterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DwarfDebugFlags.$destroy();
    MainFilename.$destroy();
    Entries.$destroy();
    DiagOpts.$destroy();
    StreamOwner.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", StreamOwner=" + StreamOwner // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", DiagOpts=" + DiagOpts // NOI18N
              + ", LastWarningLoc=" + LastWarningLoc // NOI18N
              + ", LastLoc=" + LastLoc // NOI18N
              + ", Entries=" + Entries // NOI18N
              + ", MainFilename=" + MainFilename // NOI18N
              + ", DwarfDebugFlags=" + DwarfDebugFlags // NOI18N
              + super.toString(); // NOI18N
  }
}
