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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.spi.PreprocessorImplementation;
import org.clang.frontend.*;
import static org.clang.frontend.impl.TextDiagnosticPrinterStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticPrinter.h", line = 28,
 FQN="clang::TextDiagnosticPrinter", NM="_ZN5clang21TextDiagnosticPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinterE")
//</editor-fold>
public class TextDiagnosticPrinter extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  private raw_ostream /*&*/ OS;
  private IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
  
  /// \brief Handle to the currently active text diagnostic emitter.
  private std.unique_ptr<TextDiagnostic> TextDiag;
  
  /// A string to prefix to error messages.
  private std.string Prefix;
  
  private /*JBIT unsigned int*/ boolean OwnsOutputStream /*: 1*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter::TextDiagnosticPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp", line = 27,
   FQN="clang::TextDiagnosticPrinter::TextDiagnosticPrinter", NM="_ZN5clang21TextDiagnosticPrinterC1ERN4llvm11raw_ostreamEPNS_17DiagnosticOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinterC1ERN4llvm11raw_ostreamEPNS_17DiagnosticOptionsEb")
  //</editor-fold>
  public TextDiagnosticPrinter(raw_ostream /*&*/ os, 
      DiagnosticOptions /*P*/ diags) {
    this(os, 
      diags, 
      false);
  }
  public TextDiagnosticPrinter(raw_ostream /*&*/ os, 
      DiagnosticOptions /*P*/ diags, 
      boolean _OwnsOutputStream/*= false*/) {
    // : DiagnosticConsumer(), OS(os), DiagOpts(diags), TextDiag(), Prefix(), OwnsOutputStream(_OwnsOutputStream) 
    //START JInit
    super();
    this./*&*/OS=/*&*/os;
    this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(diags);
    this.TextDiag = new std.unique_ptr<TextDiagnostic>();
    this.Prefix = new std.string();
    this.OwnsOutputStream = _OwnsOutputStream;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter::~TextDiagnosticPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp", line = 34,
   FQN="clang::TextDiagnosticPrinter::~TextDiagnosticPrinter", NM="_ZN5clang21TextDiagnosticPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinterD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (OwnsOutputStream) {
      if (/*AddrOf*/OS != null) { /*AddrOf*/OS.$destroy();};
    }
    //START JDestroy
    Prefix.$destroy();
    TextDiag.$destroy();
    DiagOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// setPrefix - Set the diagnostic printer prefix string, which will be
  /// printed at the start of any diagnostics. If empty, no prefix string is
  /// used.
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter::setPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticPrinter.h", line = 48,
   FQN="clang::TextDiagnosticPrinter::setPrefix", NM="_ZN5clang21TextDiagnosticPrinter9setPrefixESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinter9setPrefixESs")
  //</editor-fold>
  public void setPrefix(std.string Value) {
    Prefix.$assign(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter::BeginSourceFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PreprocessorImplementation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp", line = 39,
   FQN="clang::TextDiagnosticPrinter::BeginSourceFile", NM="_ZN5clang21TextDiagnosticPrinter15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinter15BeginSourceFileERKNS_11LangOptionsEPKNS_12PreprocessorE")
  //</editor-fold>
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LO, 
                 /*const*/ PreprocessorImplementation /*P*/ PP)/* override*/ {
    // Build the TextDiagnostic utility.
    TextDiag.reset(new TextDiagnostic(OS, LO, /*AddrOf*/DiagOpts.$star()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter::EndSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp", line = 45,
   FQN="clang::TextDiagnosticPrinter::EndSourceFile", NM="_ZN5clang21TextDiagnosticPrinter13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinter13EndSourceFileEv")
  //</editor-fold>
  @Override public void EndSourceFile()/* override*/ {
    TextDiag.reset();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticPrinter::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp", line = 112,
   FQN="clang::TextDiagnosticPrinter::HandleDiagnostic", NM="_ZN5clang21TextDiagnosticPrinter16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZN5clang21TextDiagnosticPrinter16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level Level, 
                  /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    raw_svector_ostream DiagMessageStream = null;
    try {
      // Default implementation (Warnings/errors count).
      super.HandleDiagnostic(Level, Info);
      
      // Render the diagnostic message into a temporary buffer eagerly. We'll use
      // this later as we print out the diagnostic to the terminal.
      SmallString/*100*/ OutStr/*J*/= new SmallString/*100*/(100);
      Info.FormatDiagnostic(OutStr);
      
      DiagMessageStream/*J*/= new raw_svector_ostream(OutStr);
      printDiagnosticOptions(DiagMessageStream, Level, Info, DiagOpts.$star());
      
      // Keeps track of the starting position of the location
      // information (e.g., "foo.c:10:4:") that precedes the error
      // message. We use this information to determine how long the
      // file+line+column number prefix is.
      long/*uint64_t*/ StartOfLocationInfo = OS.tell();
      if (!Prefix.empty()) {
        OS.$out(Prefix).$out(/*KEEP_STR*/": ");
      }
      
      // Use a dedicated, simpler path for diagnostics without a valid location.
      // This is important as if the location is missing, we may be emitting
      // diagnostics in a context that lacks language options, a source manager, or
      // other infrastructure necessary when emitting more rich diagnostics.
      if (!Info.getLocation().isValid()) {
        TextDiagnostic.printDiagnosticLevel(OS, Level, DiagOpts.$arrow().ShowColors, 
            DiagOpts.$arrow().CLFallbackMode);
        TextDiagnostic.printDiagnosticMessage(OS, (Level.getValue() != 0), DiagMessageStream.str(), 
            $ullong2uint(OS.tell() - StartOfLocationInfo), 
            DiagOpts.$arrow().MessageLength, 
            DiagOpts.$arrow().ShowColors);
        OS.flush();
        return;
      }
      
      // Assert that the rest of our infrastructure is setup properly.
      assert (DiagOpts.$bool()) : "Unexpected diagnostic without options set";
      assert (Info.hasSourceManager()) : "Unexpected diagnostic with no source manager";
      assert (TextDiag.$bool()) : "Unexpected diagnostic outside source file processing";
      
      TextDiag.$arrow().emitDiagnostic(new SourceLocation(Info.getLocation()), Level, DiagMessageStream.str(), 
          Info.getRanges(), 
          Info.getFixItHints(), 
          /*AddrOf*/Info.getSourceManager());
      
      OS.flush();
    } finally {
      if (DiagMessageStream != null) { DiagMessageStream.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", DiagOpts=" + DiagOpts // NOI18N
              + ", TextDiag=" + TextDiag // NOI18N
              + ", Prefix=" + Prefix // NOI18N
              + ", OwnsOutputStream=" + OwnsOutputStream // NOI18N
              + super.toString(); // NOI18N
  }
}
