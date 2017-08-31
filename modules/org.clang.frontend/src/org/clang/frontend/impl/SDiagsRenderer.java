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

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 59,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 58,
 FQN="(anonymous namespace)::SDiagsRenderer", NM="_ZN12_GLOBAL__N_114SDiagsRendererE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRendererE")
//</editor-fold>
public class SDiagsRenderer extends /*public*/ DiagnosticNoteRenderer implements Destructors.ClassWithDestructor {
  private SDiagsWriter /*&*/ Writer;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::SDiagsRenderer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 62,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 61,
   FQN="(anonymous namespace)::SDiagsRenderer::SDiagsRenderer", NM="_ZN12_GLOBAL__N_114SDiagsRendererC1ERNS_12SDiagsWriterERKN5clang11LangOptionsEPNS3_17DiagnosticOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRendererC1ERNS_12SDiagsWriterERKN5clang11LangOptionsEPNS3_17DiagnosticOptionsE")
  //</editor-fold>
  public SDiagsRenderer(SDiagsWriter /*&*/ Writer, /*const*/ LangOptions /*&*/ LangOpts, 
      DiagnosticOptions /*P*/ DiagOpts) {
    // : DiagnosticNoteRenderer(LangOpts, DiagOpts), Writer(Writer) 
    //START JInit
    super(LangOpts, DiagOpts);
    this./*&*/Writer=/*&*/Writer;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::~SDiagsRenderer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 66,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 65,
   FQN="(anonymous namespace)::SDiagsRenderer::~SDiagsRenderer", NM="_ZN12_GLOBAL__N_114SDiagsRendererD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRendererD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::emitDiagnosticMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 678,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 677,
   FQN="(anonymous namespace)::SDiagsRenderer::emitDiagnosticMessage", NM="_ZN12_GLOBAL__N_114SDiagsRenderer21emitDiagnosticMessageEN5clang14SourceLocationENS1_11PresumedLocENS1_17DiagnosticsEngine5LevelEN4llvm9StringRefENS6_8ArrayRefINS1_15CharSourceRangeEEEPKNS1_13SourceManagerENS6_12PointerUnionIPKNS1_10DiagnosticEPKNS1_16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRenderer21emitDiagnosticMessageEN5clang14SourceLocationENS1_11PresumedLocENS1_17DiagnosticsEngine5LevelEN4llvm9StringRefENS6_8ArrayRefINS1_15CharSourceRangeEEEPKNS1_13SourceManagerENS6_12PointerUnionIPKNS1_10DiagnosticEPKNS1_16StoredDiagnosticEEE")
  //</editor-fold>
  @Override protected void emitDiagnosticMessage(SourceLocation Loc, 
                       PresumedLoc PLoc, 
                       DiagnosticsEngine.Level Level, 
                       StringRef Message, 
                       ArrayRef<CharSourceRange> Ranges, 
                       /*const*/ SourceManager /*P*/ SM, 
                       PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D)/* override*/ {
    Writer.EmitDiagnosticMessage(new SourceLocation(Loc), new PresumedLoc(PLoc), Level, new StringRef(Message), SM, new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(D));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::emitDiagnosticLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 76,
   FQN="(anonymous namespace)::SDiagsRenderer::emitDiagnosticLoc", NM="_ZN12_GLOBAL__N_114SDiagsRenderer17emitDiagnosticLocEN5clang14SourceLocationENS1_11PresumedLocENS1_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS1_15CharSourceRangeEEERKNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRenderer17emitDiagnosticLocEN5clang14SourceLocationENS1_11PresumedLocENS1_17DiagnosticsEngine5LevelEN4llvm8ArrayRefINS1_15CharSourceRangeEEERKNS1_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitDiagnosticLoc(SourceLocation Loc, PresumedLoc PLoc, 
                   DiagnosticsEngine.Level Level, 
                   ArrayRef<CharSourceRange> Ranges, 
                   /*const*/ SourceManager /*&*/ SM)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::emitNote">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 747,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 746,
   FQN="(anonymous namespace)::SDiagsRenderer::emitNote", NM="_ZN12_GLOBAL__N_114SDiagsRenderer8emitNoteEN5clang14SourceLocationEN4llvm9StringRefEPKNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRenderer8emitNoteEN5clang14SourceLocationEN4llvm9StringRefEPKNS1_13SourceManagerE")
  //</editor-fold>
  @Override public/*protected*/ void emitNote(SourceLocation Loc, StringRef Message, 
          /*const*/ SourceManager /*P*/ SM)/* override*/ {
    Writer.EnterDiagBlock();
    PresumedLoc PLoc = (SM != null) ? SM.getPresumedLoc(/*NO_COPY*/Loc) : new PresumedLoc();
    Writer.EmitDiagnosticMessage(new SourceLocation(Loc), new PresumedLoc(PLoc), DiagnosticsEngine.Level.Note, 
        new StringRef(Message), SM, new PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ >(Diagnostic.class));
    Writer.ExitDiagBlock();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::emitCodeContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 739,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 738,
   FQN="(anonymous namespace)::SDiagsRenderer::emitCodeContext", NM="_ZN12_GLOBAL__N_114SDiagsRenderer15emitCodeContextEN5clang14SourceLocationENS1_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS1_15CharSourceRangeEEENS5_8ArrayRefINS1_9FixItHintEEERKNS1_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRenderer15emitCodeContextEN5clang14SourceLocationENS1_17DiagnosticsEngine5LevelERN4llvm15SmallVectorImplINS1_15CharSourceRangeEEENS5_8ArrayRefINS1_9FixItHintEEERKNS1_13SourceManagerE")
  //</editor-fold>
  @Override protected void emitCodeContext(SourceLocation Loc, 
                 DiagnosticsEngine.Level Level, 
                 SmallVectorImpl<CharSourceRange> /*&*/ Ranges, 
                 ArrayRef<FixItHint> Hints, 
                 /*const*/ SourceManager /*&*/ SM)/* override*/ {
    Writer.EmitCodeContext(Ranges, new ArrayRef<FixItHint>(Hints), SM);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::beginDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 697,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 696,
   FQN="(anonymous namespace)::SDiagsRenderer::beginDiagnostic", NM="_ZN12_GLOBAL__N_114SDiagsRenderer15beginDiagnosticEN4llvm12PointerUnionIPKN5clang10DiagnosticEPKNS3_16StoredDiagnosticEEENS3_17DiagnosticsEngine5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRenderer15beginDiagnosticEN4llvm12PointerUnionIPKN5clang10DiagnosticEPKNS3_16StoredDiagnosticEEENS3_17DiagnosticsEngine5LevelE")
  //</editor-fold>
  @Override protected void beginDiagnostic(PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D, 
                 DiagnosticsEngine.Level Level)/* override*/ {
    if (Level == DiagnosticsEngine.Level.Note) {
      Writer.EnterDiagBlock();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SDiagsRenderer::endDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", line = 703,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp", old_line = 702,
   FQN="(anonymous namespace)::SDiagsRenderer::endDiagnostic", NM="_ZN12_GLOBAL__N_114SDiagsRenderer13endDiagnosticEN4llvm12PointerUnionIPKN5clang10DiagnosticEPKNS3_16StoredDiagnosticEEENS3_17DiagnosticsEngine5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticPrinter.cpp -nm=_ZN12_GLOBAL__N_114SDiagsRenderer13endDiagnosticEN4llvm12PointerUnionIPKN5clang10DiagnosticEPKNS3_16StoredDiagnosticEEENS3_17DiagnosticsEngine5LevelE")
  //</editor-fold>
  @Override protected void endDiagnostic(PointerUnion</*const*/ Diagnostic /*P*/ , /*const*/ StoredDiagnostic /*P*/ > D, 
               DiagnosticsEngine.Level Level)/* override*/ {
    // Only end note diagnostics here, because we can't be sure when we've seen
    // the last note associated with a non-note diagnostic.
    if (Level == DiagnosticsEngine.Level.Note) {
      Writer.ExitDiagBlock();
    }
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + super.toString(); // NOI18N
  }
}
