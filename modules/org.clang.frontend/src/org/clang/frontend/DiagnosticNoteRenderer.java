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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.frontend.*;


/// Subclass of DiagnosticRender that turns all subdiagostics into explicit
/// notes.  It is up to subclasses to further define the behavior.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 155,
 FQN="clang::DiagnosticNoteRenderer", NM="_ZN5clang22DiagnosticNoteRendererE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRendererE")
//</editor-fold>
public abstract class DiagnosticNoteRenderer extends /*public*/ DiagnosticRenderer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer::DiagnosticNoteRenderer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 157,
   FQN="clang::DiagnosticNoteRenderer::DiagnosticNoteRenderer", NM="_ZN5clang22DiagnosticNoteRendererC1ERKNS_11LangOptionsEPNS_17DiagnosticOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRendererC1ERKNS_11LangOptionsEPNS_17DiagnosticOptionsE")
  //</editor-fold>
  public DiagnosticNoteRenderer(/*const*/ LangOptions /*&*/ LangOpts, 
      DiagnosticOptions /*P*/ DiagOpts) {
    // : DiagnosticRenderer(LangOpts, DiagOpts) 
    //START JInit
    super(LangOpts, DiagOpts);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer::~DiagnosticNoteRenderer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 585,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 625,
   FQN="clang::DiagnosticNoteRenderer::~DiagnosticNoteRenderer", NM="_ZN5clang22DiagnosticNoteRendererD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRendererD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer::emitIncludeLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 587,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 627,
   FQN="clang::DiagnosticNoteRenderer::emitIncludeLocation", NM="_ZN5clang22DiagnosticNoteRenderer19emitIncludeLocationENS_14SourceLocationENS_11PresumedLocERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRenderer19emitIncludeLocationENS_14SourceLocationENS_11PresumedLocERKNS_13SourceManagerE")
  //</editor-fold>
  @Override public void emitIncludeLocation(SourceLocation Loc, 
                     PresumedLoc PLoc, 
                     /*const*/ SourceManager /*&*/ SM)/* override*/ {
    raw_svector_ostream Message = null;
    try {
      // Generate a note indicating the include location.
      SmallString/*200*/ MessageStorage/*J*/= new SmallString/*200*/(200);
      Message/*J*/= new raw_svector_ostream(MessageStorage);
      Message.$out(/*KEEP_STR*/"in file included from ").$out(PLoc.getFilename()).$out_char($$COLON).$out_uint(
          PLoc.getLine()
      ).$out(/*KEEP_STR*/$COLON);
      emitNote(new SourceLocation(Loc), Message.str(), /*AddrOf*/SM);
    } finally {
      if (Message != null) { Message.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer::emitImportLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 598,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 638,
   FQN="clang::DiagnosticNoteRenderer::emitImportLocation", NM="_ZN5clang22DiagnosticNoteRenderer18emitImportLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRenderer18emitImportLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  @Override public void emitImportLocation(SourceLocation Loc, 
                    PresumedLoc PLoc, 
                    StringRef ModuleName, 
                    /*const*/ SourceManager /*&*/ SM)/* override*/ {
    raw_svector_ostream Message = null;
    try {
      // Generate a note indicating the include location.
      SmallString/*200*/ MessageStorage/*J*/= new SmallString/*200*/(200);
      Message/*J*/= new raw_svector_ostream(MessageStorage);
      Message.$out(/*KEEP_STR*/"in module '").$out(/*NO_COPY*/ModuleName);
      if (PLoc.isValid()) {
        Message.$out(/*KEEP_STR*/"' imported from ").$out(PLoc.getFilename()).$out_char($$COLON).$out_uint(
            PLoc.getLine()
        );
      }
      Message.$out(/*KEEP_STR*/$COLON);
      emitNote(new SourceLocation(Loc), Message.str(), /*AddrOf*/SM);
    } finally {
      if (Message != null) { Message.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer::emitBuildingModuleLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", line = 613,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp", old_line = 653,
   FQN="clang::DiagnosticNoteRenderer::emitBuildingModuleLocation", NM="_ZN5clang22DiagnosticNoteRenderer26emitBuildingModuleLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRenderer26emitBuildingModuleLocationENS_14SourceLocationENS_11PresumedLocEN4llvm9StringRefERKNS_13SourceManagerE")
  //</editor-fold>
  @Override public void emitBuildingModuleLocation(SourceLocation Loc, 
                            PresumedLoc PLoc, 
                            StringRef ModuleName, 
                            /*const*/ SourceManager /*&*/ SM)/* override*/ {
    raw_svector_ostream Message = null;
    try {
      // Generate a note indicating the include location.
      SmallString/*200*/ MessageStorage/*J*/= new SmallString/*200*/(200);
      Message/*J*/= new raw_svector_ostream(MessageStorage);
      if (PLoc.isValid()) {
        Message.$out(/*KEEP_STR*/"while building module '").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/"' imported from ").$out(
            PLoc.getFilename()
        ).$out_char($$COLON).$out_uint(PLoc.getLine()).$out(/*KEEP_STR*/$COLON);
      } else {
        Message.$out(/*KEEP_STR*/"while building module '").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/"':");
      }
      emitNote(new SourceLocation(Loc), Message.str(), /*AddrOf*/SM);
    } finally {
      if (Message != null) { Message.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticNoteRenderer::emitNote">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DiagnosticRenderer.h", line = 174,
   FQN="clang::DiagnosticNoteRenderer::emitNote", NM="_ZN5clang22DiagnosticNoteRenderer8emitNoteENS_14SourceLocationEN4llvm9StringRefEPKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DiagnosticRenderer.cpp -nm=_ZN5clang22DiagnosticNoteRenderer8emitNoteENS_14SourceLocationEN4llvm9StringRefEPKNS_13SourceManagerE")
  //</editor-fold>
  public abstract /*virtual*/ void emitNote(SourceLocation Loc, StringRef Message, 
          /*const*/ SourceManager /*P*/ SM)/* = 0*/;

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
