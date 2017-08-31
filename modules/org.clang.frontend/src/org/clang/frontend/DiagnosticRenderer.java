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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.frontend.impl.DiagnosticRendererStatics.*;


/// \brief Class to encapsulate the logic for formatting a diagnostic message.
///
/// Actual "printing" logic is implemented by subclasses.
///
/// This class provides an interface for building and emitting
/// diagnostic, including all of the macro backtraces, caret diagnostics, FixIt
/// Hints, and code snippets. In the presence of macros this involves
/// a recursive process, synthesizing notes for each macro expansion.
///
/// A brief worklist:
/// FIXME: Sink the recursive printing of template instantiations into this
/// class.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 46,
 FQN="clang::DiagnosticRenderer", NM="_ZN5clang18DiagnosticRendererE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRendererE")
//</editor-fold>
public abstract class DiagnosticRenderer implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*const*/ LangOptions /*&*/ LangOpts;
  protected IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts;
  
  /// \brief The location of the previous diagnostic if known.
  ///
  /// This will be invalid in cases where there is no (known) previous
  /// diagnostic location, or that location itself is invalid or comes from
  /// a different source manager than SM.
  protected SourceLocation LastLoc;
  
  /// \brief The location of the last include whose stack was printed if known.
  ///
  /// Same restriction as LastLoc essentially, but tracking include stack
  /// root locations rather than diagnostic locations.
  protected SourceLocation LastIncludeLoc;
  
  /// \brief The level of the last diagnostic emitted.
  ///
  /// The level of the last diagnostic emitted. Used to detect level changes
  /// which change the amount of information displayed.
  protected DiagnosticsEngine.Level LastLevel;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::DiagnosticRenderer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 68,
   FQN="clang::DiagnosticRenderer::DiagnosticRenderer", NM="_ZN5clang18DiagnosticRendererC1ERKNS_11LangOptionsEPNS_17DiagnosticOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRendererC1ERKNS_11LangOptionsEPNS_17DiagnosticOptionsE")
  //</editor-fold>
  protected DiagnosticRenderer(/*const*/ LangOptions /*&*/ LangOpts, 
      DiagnosticOptions /*P*/ DiagOpts) {
    // : LangOpts(LangOpts), DiagOpts(DiagOpts), LastLoc(), LastIncludeLoc(), LastLevel(implicit DiagnosticsEngine::Level()) 
    //START JInit
    this./*&*/LangOpts=/*&*/LangOpts;
    this.DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(DiagOpts);
    this.LastLoc = new SourceLocation();
    this.LastIncludeLoc = new SourceLocation();
    this.LastLevel = /*implicit-init*/DiagnosticsEngine.Level.valueOf(/*zero-init*/0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::~DiagnosticRenderer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 30,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 72,
   FQN="clang::DiagnosticRenderer::~DiagnosticRenderer", NM="_ZN5clang18DiagnosticRendererD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRendererD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
    //START JDestroy
    DiagOpts.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitDiagnosticMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 75,
   FQN="clang::DiagnosticRenderer::emitDiagnosticMessage", NM="_ZN5clang18DiagnosticRenderer21emitDiagnosticMessageENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm9StringRefENS5_8ArrayRefINS_15CharSourceRangeEEEPKNS_13SourceManagerENS5_12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer21emitDiagnosticMessageENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm9StringRefENS5_8ArrayRefINS_15CharSourceRangeEEEPKNS_13SourceManagerENS5_12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEE")
  //</editor-fold>
  protected abstract /*virtual*/ void emitDiagnosticMessage(SourceLocation Loc, PresumedLoc PLoc, 
                       DiagnosticsEngine.Level Level, 
                       StringRef Message, 
                       ArrayRef<CharSourceRange> Ranges, 
                       /*const*/ SourceManager /*P*/ SM, 
                       PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > Info)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitDiagnosticLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 82,
   FQN="clang::DiagnosticRenderer::emitDiagnosticLoc", NM="_ZN5clang18DiagnosticRenderer17emitDiagnosticLocENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer17emitDiagnosticLocENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE")
  //</editor-fold>
  protected abstract /*virtual*/ void emitDiagnosticLoc(SourceLocation Loc, PresumedLoc PLoc, 
                   DiagnosticsEngine.Level Level, 
                   ArrayRef<CharSourceRange> Ranges, 
                   /*const*/ SourceManager /*&*/ SM)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitCodeContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 87,
   FQN="clang::DiagnosticRenderer::emitCodeContext", NM="_ZN5clang18DiagnosticRenderer15emitCodeContextENS_14SourceLocationENS_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS_15CharSourceRangeEEENS4_8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer15emitCodeContextENS_14SourceLocationENS_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS_15CharSourceRangeEEENS4_8ArrayRefINS_9FixItHintEEERKNS_13SourceManagerE")
  //</editor-fold>
  protected abstract /*virtual*/ void emitCodeContext(SourceLocation Loc, 
                 DiagnosticsEngine.Level Level, 
                 SmallVectorImpl<CharSourceRange> /*&*/ Ranges, 
                 ArrayRef<FixItHint> Hints, 
                 /*const*/ SourceManager /*&*/ SM)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitIncludeLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 93,
   FQN="clang::DiagnosticRenderer::emitIncludeLocation", NM="_ZN5clang18DiagnosticRenderer19emitIncludeLocationENS_14SourceLocationENS_11PresumedLocERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer19emitIncludeLocationENS_14SourceLocationENS_11PresumedLocERKNS_13SourceManagerE")
  //</editor-fold>
  protected abstract /*virtual*/ void emitIncludeLocation(SourceLocation Loc, PresumedLoc PLoc, 
                     /*const*/ SourceManager /*&*/ SM)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitImportLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 95,
   FQN="clang::DiagnosticRenderer::emitImportLocation", NM="_ZN5clang18DiagnosticRenderer18emitImportLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer18emitImportLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  protected abstract /*virtual*/ void emitImportLocation(SourceLocation Loc, PresumedLoc PLoc, 
                    StringRef ModuleName, 
                    /*const*/ SourceManager /*&*/ SM)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitBuildingModuleLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 98,
   FQN="clang::DiagnosticRenderer::emitBuildingModuleLocation", NM="_ZN5clang18DiagnosticRenderer26emitBuildingModuleLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer26emitBuildingModuleLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  protected abstract /*virtual*/ void emitBuildingModuleLocation(SourceLocation Loc, PresumedLoc PLoc, 
                            StringRef ModuleName, 
                            /*const*/ SourceManager /*&*/ SM)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::beginDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 102,
   FQN="clang::DiagnosticRenderer::beginDiagnostic", NM="_ZN5clang18DiagnosticRenderer15beginDiagnosticEN4llvm12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEENS_17DiagnosticsEngine5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer15beginDiagnosticEN4llvm12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEENS_17DiagnosticsEngine5LevelE")
  //</editor-fold>
  protected /*virtual*/ void beginDiagnostic(PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D, 
                 DiagnosticsEngine.Level Level) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::endDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 104,
   FQN="clang::DiagnosticRenderer::endDiagnostic", NM="_ZN5clang18DiagnosticRenderer13endDiagnosticEN4llvm12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEENS_17DiagnosticsEngine5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer13endDiagnosticEN4llvm12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEENS_17DiagnosticsEngine5LevelE")
  //</editor-fold>
  protected /*virtual*/ void endDiagnostic(PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D, 
               DiagnosticsEngine.Level Level) {
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitBasicNote">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 191,
   FQN="clang::DiagnosticRenderer::emitBasicNote", NM="_ZN5clang18DiagnosticRenderer13emitBasicNoteEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer13emitBasicNoteEN4llvm9StringRefE")
  //</editor-fold>
  private void emitBasicNote(StringRef Message) {
    emitDiagnosticMessage(new SourceLocation(), new PresumedLoc(), DiagnosticsEngine.Level.Note, new StringRef(Message), 
        new ArrayRef<CharSourceRange>(None), (/*const*/ SourceManager /*P*/ )null, new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(Diagnostic.class));
  }

  
  /// \brief Prints an include stack when appropriate for a particular
  /// diagnostic level and location.
  ///
  /// This routine handles all the logic of suppressing particular include
  /// stacks (such as those for notes) and duplicate include stacks when
  /// repeated warnings occur within the same file. It also handles the logic
  /// of customizing the formatting and display of the include stack.
  ///
  /// \param Loc   The diagnostic location.
  /// \param PLoc  The presumed location of the diagnostic location.
  /// \param Level The diagnostic level of the message this stack pertains to.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitIncludeStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 208,
   FQN="clang::DiagnosticRenderer::emitIncludeStack", NM="_ZN5clang18DiagnosticRenderer16emitIncludeStackENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer16emitIncludeStackENS_14SourceLocationENS_11PresumedLocENS_17DiagnosticsEngine5LevelERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitIncludeStack(SourceLocation Loc, 
                  PresumedLoc PLoc, 
                  DiagnosticsEngine.Level Level, 
                  /*const*/ SourceManager /*&*/ SM) {
    SourceLocation IncludeLoc = PLoc.isInvalid() ? new SourceLocation() : PLoc.getIncludeLoc();
    
    // Skip redundant include stacks altogether.
    if ($eq_SourceLocation$C(LastIncludeLoc, IncludeLoc)) {
      return;
    }
    
    LastIncludeLoc.$assign(IncludeLoc);
    if (!DiagOpts.$arrow().ShowNoteIncludeStack && Level == DiagnosticsEngine.Level.Note) {
      return;
    }
    if (IncludeLoc.isValid()) {
      emitIncludeStackRecursively(/*NO_COPY*/IncludeLoc, SM);
    } else {
      emitModuleBuildStack(SM);
      emitImportStack(new SourceLocation(Loc), SM);
    }
  }

  
  /// \brief Helper to recursivly walk up the include stack and print each layer
  /// on the way back down.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitIncludeStackRecursively">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 192,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 233,
   FQN="clang::DiagnosticRenderer::emitIncludeStackRecursively", NM="_ZN5clang18DiagnosticRenderer27emitIncludeStackRecursivelyENS_14SourceLocationERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer27emitIncludeStackRecursivelyENS_14SourceLocationERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitIncludeStackRecursively(SourceLocation Loc, 
                             /*const*/ SourceManager /*&*/ SM) {
    if (Loc.isInvalid()) {
      emitModuleBuildStack(SM);
      return;
    }
    
    PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc, DiagOpts.$arrow().ShowPresumedLoc);
    if (PLoc.isInvalid()) {
      return;
    }
    
    // If this source location was imported from a module, print the module
    // import stack rather than the 
    // FIXME: We want submodule granularity here.
    std.pair<SourceLocation, StringRef> Imported = SM.getModuleImportLoc(/*NO_COPY*/Loc);
    if (!Imported.second.empty()) {
      // This location was imported by a module. Emit the module import stack.
      emitImportStackRecursively(/*NO_COPY*/Imported.first, /*NO_COPY*/Imported.second, SM);
      return;
    }
    
    // Emit the other include frames first.
    emitIncludeStackRecursively(PLoc.getIncludeLoc(), SM);
    
    // Emit the inclusion text/note.
    emitIncludeLocation(new SourceLocation(Loc), new PresumedLoc(PLoc), SM);
  }

  
  /// \brief Emit the module import stack associated with the current location.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitImportStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 221,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 262,
   FQN="clang::DiagnosticRenderer::emitImportStack", NM="_ZN5clang18DiagnosticRenderer15emitImportStackENS_14SourceLocationERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer15emitImportStackENS_14SourceLocationERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitImportStack(SourceLocation Loc, 
                 /*const*/ SourceManager /*&*/ SM) {
    if (Loc.isInvalid()) {
      emitModuleBuildStack(SM);
      return;
    }
    
    std.pair<SourceLocation, StringRef> NextImportLoc = SM.getModuleImportLoc(/*NO_COPY*/Loc);
    emitImportStackRecursively(/*NO_COPY*/NextImportLoc.first, /*NO_COPY*/NextImportLoc.second, SM);
  }

  
  /// \brief Helper to recursivly walk up the import stack and print each layer
  /// on the way back down.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitImportStackRecursively">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 235,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 276,
   FQN="clang::DiagnosticRenderer::emitImportStackRecursively", NM="_ZN5clang18DiagnosticRenderer26emitImportStackRecursivelyENS_14SourceLocationEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer26emitImportStackRecursivelyENS_14SourceLocationEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitImportStackRecursively(SourceLocation Loc, 
                            StringRef ModuleName, 
                            /*const*/ SourceManager /*&*/ SM) {
    if (ModuleName.empty()) {
      return;
    }
    
    PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc, DiagOpts.$arrow().ShowPresumedLoc);
    
    // Emit the other import frames first.
    std.pair<SourceLocation, StringRef> NextImportLoc = SM.getModuleImportLoc(/*NO_COPY*/Loc);
    emitImportStackRecursively(/*NO_COPY*/NextImportLoc.first, /*NO_COPY*/NextImportLoc.second, SM);
    
    // Emit the inclusion text/note.
    emitImportLocation(new SourceLocation(Loc), new PresumedLoc(PLoc), new StringRef(ModuleName), SM);
  }

  
  /// \brief Emit the module build stack, for cases where a module is (re-)built
  /// on demand.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitModuleBuildStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 296,
   FQN="clang::DiagnosticRenderer::emitModuleBuildStack", NM="_ZN5clang18DiagnosticRenderer20emitModuleBuildStackERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer20emitModuleBuildStackERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitModuleBuildStack(/*const*/ SourceManager /*&*/ SM) {
    ArrayRef<std.pair<std.string, FullSourceLoc> > Stack = SM.getModuleBuildStack();
    for (/*uint*/int I = 0, N = Stack.size(); I != N; ++I) {
      /*const*/ SourceManager /*&*/ CurSM = Stack.$at(I).second.getManager();
      SourceLocation CurLoc = new SourceLocation(Stack.$at(I).second);
      emitBuildingModuleLocation(new SourceLocation(CurLoc), 
          CurSM.getPresumedLoc(/*NO_COPY*/CurLoc, 
              DiagOpts.$arrow().ShowPresumedLoc), 
          new StringRef(Stack.$at(I).first), 
          CurSM);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitCaret">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 409,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 450,
   FQN="clang::DiagnosticRenderer::emitCaret", NM="_ZN5clang18DiagnosticRenderer9emitCaretENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEENS5_INS_9FixItHintEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer9emitCaretENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEENS5_INS_9FixItHintEEERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitCaret(SourceLocation Loc, 
           DiagnosticsEngine.Level Level, 
           ArrayRef<CharSourceRange> Ranges, 
           ArrayRef<FixItHint> Hints, 
           /*const*/ SourceManager /*&*/ SM) {
    SmallVector<CharSourceRange/*,4*/> SpellingRanges/*J*/= new SmallVector<CharSourceRange/*,4*/>(4, new CharSourceRange());
    mapDiagnosticRanges(/*NO_COPY*/Loc, /*NO_COPY*/Ranges, SpellingRanges, /*AddrOf*/SM);
    emitCodeContext(new SourceLocation(Loc), Level, SpellingRanges, new ArrayRef<FixItHint>(Hints), SM);
  }

  
  /// \brief A helper function for emitMacroExpansion to print the
  /// macro expansion message
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitSingleMacroExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 421,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 462,
   FQN="clang::DiagnosticRenderer::emitSingleMacroExpansion", NM="_ZN5clang18DiagnosticRenderer24emitSingleMacroExpansionENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer24emitSingleMacroExpansionENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitSingleMacroExpansion(SourceLocation Loc, 
                          DiagnosticsEngine.Level Level, 
                          ArrayRef<CharSourceRange> Ranges, 
                          /*const*/ SourceManager /*&*/ SM) {
    raw_svector_ostream Message = null;
    try {
      // Find the spelling location for the macro definition. We must use the
      // spelling location here to avoid emitting a macro backtrace for the note.
      SourceLocation SpellingLoc = SM.getSpellingLoc(/*NO_COPY*/Loc);
      
      // Map the ranges into the FileID of the diagnostic location.
      SmallVector<CharSourceRange/*,4*/> SpellingRanges/*J*/= new SmallVector<CharSourceRange/*,4*/>(4, new CharSourceRange());
      mapDiagnosticRanges(/*NO_COPY*/Loc, /*NO_COPY*/Ranges, SpellingRanges, /*AddrOf*/SM);
      
      SmallString/*100*/ MessageStorage/*J*/= new SmallString/*100*/(100);
      Message/*J*/= new raw_svector_ostream(MessageStorage);
      StringRef MacroName = Lexer.getImmediateMacroNameForDiagnostics(/*NO_COPY*/Loc, SM, LangOpts);
      if (MacroName.empty()) {
        Message.$out(/*KEEP_STR*/"expanded from here");
      } else {
        Message.$out(/*KEEP_STR*/"expanded from macro '").$out(/*NO_COPY*/MacroName).$out(/*KEEP_STR*/$SGL_QUOTE);
      }
      
      emitDiagnostic(new SourceLocation(SpellingLoc), DiagnosticsEngine.Level.Note, Message.str(), 
          new ArrayRef<CharSourceRange>(SpellingRanges), ArrayRef.None(), /*AddrOf*/SM);
    } finally {
      if (Message != null) { Message.$destroy(); }
    }
  }

  
  /// \brief Recursively emit notes for each macro expansion and caret
  /// diagnostics where appropriate.
  ///
  /// Walks up the macro expansion stack printing expansion notes, the code
  /// snippet, caret, underlines and FixItHint display as appropriate at each
  /// level.
  ///
  /// \param Loc The location for this caret.
  /// \param Level The diagnostic level currently being emitted.
  /// \param Ranges The underlined ranges for this code snippet.
  /// \param Hints The FixIt hints active for this diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitMacroExpansions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 521,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 561,
   FQN="clang::DiagnosticRenderer::emitMacroExpansions", NM="_ZN5clang18DiagnosticRenderer19emitMacroExpansionsENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEENS5_INS_9FixItHintEEERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer19emitMacroExpansionsENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS_15CharSourceRangeEEENS5_INS_9FixItHintEEERKNS_13SourceManagerE")
  //</editor-fold>
  private void emitMacroExpansions(SourceLocation Loc, 
                     DiagnosticsEngine.Level Level, 
                     ArrayRef<CharSourceRange> Ranges, 
                     ArrayRef<FixItHint> Hints, 
                     /*const*/ SourceManager /*&*/ SM) {
    raw_svector_ostream Message = null;
    try {
      assert (Loc.isValid()) : "must have a valid source location here";
      
      // Produce a stack of macro backtraces.
      SmallVector<SourceLocation> LocationStack/*J*/= new SmallVector<SourceLocation>(8, new SourceLocation());
      /*uint*/int IgnoredEnd = 0;
      while (Loc.isMacroID()) {
        // If this is the expansion of a macro argument, point the caret at the
        // use of the argument in the definition of the macro, not the expansion.
        if (SM.isMacroArgExpansion(/*NO_COPY*/Loc)) {
          LocationStack.push_back(SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first);
        } else {
          LocationStack.push_back(Loc);
        }
        if (checkRangesForMacroArgExpansion(/*NO_COPY*/Loc, /*NO_COPY*/Ranges, SM)) {
          IgnoredEnd = LocationStack.size();
        }
        
        Loc.$assignMove(SM.getImmediateMacroCallerLoc(/*NO_COPY*/Loc));
        
        // Once the location no longer points into a macro, try stepping through
        // the last found location.  This sometimes produces additional useful
        // backtraces.
        if (Loc.isFileID()) {
          Loc.$assignMove(SM.getImmediateMacroCallerLoc(/*NO_COPY*/LocationStack.back()));
        }
        assert (Loc.isValid()) : "must have a valid source location here";
      }
      
      LocationStack.erase(LocationStack.begin(), 
          LocationStack.begin().$add(IgnoredEnd));
      
      /*uint*/int MacroDepth = LocationStack.size();
      /*uint*/int MacroLimit = DiagOpts.$arrow().MacroBacktraceLimit;
      if ($lesseq_uint(MacroDepth, MacroLimit) || MacroLimit == 0) {
        for (reverse_iterator<SourceLocation /*P*/ > I = LocationStack.rbegin(), E = LocationStack.rend();
             $noteq_reverse_iterator$C(I, E); I.$preInc())  {
          emitSingleMacroExpansion(/*NO_COPY*/I.$star(), Level, /*NO_COPY*/Ranges, SM);
        }
        return;
      }
      
      /*uint*/int MacroStartMessages = MacroLimit / 2;
      /*uint*/int MacroEndMessages = MacroLimit / 2 + MacroLimit % 2;
      
      for (reverse_iterator<SourceLocation /*P*/ > I = LocationStack.rbegin(), 
          E = LocationStack.rbegin().$add(MacroStartMessages);
           $noteq_reverse_iterator$C(I, E); I.$preInc())  {
        emitSingleMacroExpansion(/*NO_COPY*/I.$star(), Level, /*NO_COPY*/Ranges, SM);
      }
      
      SmallString/*200*/ MessageStorage/*J*/= new SmallString/*200*/(200);
      Message/*J*/= new raw_svector_ostream(MessageStorage);
      Message.$out(/*KEEP_STR*/"(skipping ").$out_uint((MacroDepth - MacroLimit)).$out(
          /*KEEP_STR*/" expansions in backtrace; use -fmacro-backtrace-limit=0 to see all)"
      );
      emitBasicNote(Message.str());
      
      for (reverse_iterator<SourceLocation /*P*/ > I = LocationStack.rend().$sub(MacroEndMessages), 
          E = LocationStack.rend();
           $noteq_reverse_iterator$C(I, E); I.$preInc())  {
        emitSingleMacroExpansion(/*NO_COPY*/I.$star(), Level, /*NO_COPY*/Ranges, SM);
      }
    } finally {
      if (Message != null) { Message.$destroy(); }
    }
  }

/*public:*/
  /// \brief Emit a diagnostic.
  ///
  /// This is the primary entry point for emitting diagnostic messages.
  /// It handles formatting and rendering the message as well as any ancillary
  /// information needed based on macros whose expansions impact the
  /// diagnostic.
  ///
  /// \param Loc The location for this caret.
  /// \param Level The level of the diagnostic to be emitted.
  /// \param Message The diagnostic message to emit.
  /// \param Ranges The underlined ranges for this code snippet.
  /// \param FixItHints The FixIt hints active for this diagnostic.
  /// \param SM The SourceManager; will be null if the diagnostic came from the
  ///        frontend, thus \p Loc will be invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 123,
   FQN="clang::DiagnosticRenderer::emitDiagnostic", NM="_ZN5clang18DiagnosticRenderer14emitDiagnosticENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm9StringRefENS4_8ArrayRefINS_15CharSourceRangeEEENS6_INS_9FixItHintEEEPKNS_13SourceManagerENS4_12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer14emitDiagnosticENS_14SourceLocationENS_17DiagnosticsEngine5LevelEN4llvm9StringRefENS4_8ArrayRefINS_15CharSourceRangeEEENS6_INS_9FixItHintEEEPKNS_13SourceManagerENS4_12PointerUnionIPKNS_10DiagnosticEPKNS_16StoredDiagnosticEEE")
  //</editor-fold>
  public void emitDiagnostic(SourceLocation Loc, 
                DiagnosticsEngine.Level Level, 
                StringRef Message, 
                ArrayRef<CharSourceRange> Ranges, 
                ArrayRef<FixItHint> FixItHints, 
                /*const*/ SourceManager /*P*/ SM) {
    emitDiagnostic(Loc, 
                Level, 
                Message, 
                Ranges, 
                FixItHints, 
                SM, 
                new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(JD$T.INSTANCE, Diagnostic.class, (Diagnostic /*P*/ )null));
  }
  public void emitDiagnostic(SourceLocation Loc, 
                DiagnosticsEngine.Level Level, 
                StringRef Message, 
                ArrayRef<CharSourceRange> Ranges, 
                ArrayRef<FixItHint> FixItHints, 
                /*const*/ SourceManager /*P*/ SM, 
                PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D/*= (Diagnostic * )null*/) {
    assert ((SM != null) || Loc.isInvalid());
    
    beginDiagnostic(new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(D), Level);
    if (!Loc.isValid()) {
      // If we have no source location, just emit the diagnostic message.
      emitDiagnosticMessage(new SourceLocation(Loc), new PresumedLoc(), Level, new StringRef(Message), new ArrayRef<CharSourceRange>(Ranges), SM, new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(D));
    } else {
      // Get the ranges into a local array we can hack on.
      SmallVector<CharSourceRange/*,20*/> MutableRanges/*J*/= new SmallVector<CharSourceRange/*,20*/>(20, Ranges.begin(), 
          Ranges.end(), new CharSourceRange());
      
      SmallVector<FixItHint> MergedFixits/*J*/= new SmallVector<FixItHint>(8, new FixItHint());
      if (!FixItHints.empty()) {
        mergeFixits(new ArrayRef<FixItHint>(FixItHints), /*Deref*/SM, LangOpts, MergedFixits);
        FixItHints.$assignMove(new ArrayRef<FixItHint>(MergedFixits));
      }
      
      for (type$ptr<FixItHint> I = $tryClone(FixItHints.begin()), 
          /*P*/ E = FixItHints.end();
           I.$noteq(E); I.$preInc())  {
        if (I.$star().RemoveRange.isValid()) {
          MutableRanges.push_back(I.$star().RemoveRange);
        }
      }
      
      SourceLocation UnexpandedLoc = new SourceLocation(Loc);
      
      // Find the ultimate expansion location for the diagnostic.
      Loc.$assignMove(SM.getFileLoc(/*NO_COPY*/Loc));
      
      PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc, DiagOpts.$arrow().ShowPresumedLoc);
      
      // First, if this diagnostic is not in the main file, print out the
      // "included from" lines.
      emitIncludeStack(/*NO_COPY*/Loc, /*NO_COPY*/PLoc, Level, /*Deref*/SM);
      
      // Next, emit the actual diagnostic message and caret.
      emitDiagnosticMessage(new SourceLocation(Loc), new PresumedLoc(PLoc), Level, new StringRef(Message), new ArrayRef<CharSourceRange>(Ranges), SM, new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(D));
      emitCaret(new SourceLocation(Loc), Level, new ArrayRef<CharSourceRange>(MutableRanges), new ArrayRef<FixItHint>(FixItHints), /*Deref*/SM);
      
      // If this location is within a macro, walk from UnexpandedLoc up to Loc
      // and produce a macro backtrace.
      if (UnexpandedLoc.isValid() && UnexpandedLoc.isMacroID()) {
        emitMacroExpansions(new SourceLocation(UnexpandedLoc), Level, new ArrayRef<CharSourceRange>(MutableRanges), new ArrayRef<FixItHint>(FixItHints), /*Deref*/SM);
      }
    }
    
    LastLoc.$assign(Loc);
    LastLevel = Level;
    
    endDiagnostic(new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(D), Level);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticRenderer::emitStoredDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 141,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 183,
   FQN="clang::DiagnosticRenderer::emitStoredDiagnostic", NM="_ZN5clang18DiagnosticRenderer20emitStoredDiagnosticERNS_16StoredDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang18DiagnosticRenderer20emitStoredDiagnosticERNS_16StoredDiagnosticE")
  //</editor-fold>
  public void emitStoredDiagnostic(StoredDiagnostic /*&*/ Diag) {
    emitDiagnostic(new SourceLocation(Diag.getLocation()), Diag.getLevel(), Diag.getMessage(), 
        Diag.getRanges(), Diag.getFixIts(), 
        Diag.getLocation().isValid() ? /*AddrOf*/Diag.getLocation().getManager() : (/*const*/ SourceManager /*P*/ )null, 
        new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(JD$T1.INSTANCE, StoredDiagnostic.class, /*AddrOf*/Diag));
  }

  
  @Override public String toString() {
    return "" + "LangOpts=" + LangOpts // NOI18N
              + ", DiagOpts=" + DiagOpts // NOI18N
              + ", LastLoc=" + LastLoc // NOI18N
              + ", LastIncludeLoc=" + LastIncludeLoc // NOI18N
              + ", LastLevel=" + LastLevel; // NOI18N
  }
}
