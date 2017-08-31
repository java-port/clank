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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 25,
 FQN="clang::TextDiagnosticBuffer", NM="_ZN5clang20TextDiagnosticBufferE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZN5clang20TextDiagnosticBufferE")
//</editor-fold>
public class TextDiagnosticBuffer extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef std::vector<std::pair<SourceLocation, std::string> > DiagList*/
//  public final class DiagList extends std.vector<std.pair<SourceLocation, std.string>>{ };
  /*typedef DiagList::iterator iterator*/
//  public final class iterator extends std.vector.iterator<std.pair<SourceLocation, std.string> >{ };
  /*typedef DiagList::const_iterator const_iterator*/
//  public final class const_iterator extends std.vector.iterator<std.pair<SourceLocation, std.string> >{ };
/*private:*/
  private std.vector<std.pair<SourceLocation, std.string>> Errors;
  private std.vector<std.pair<SourceLocation, std.string>> Warnings;
  private std.vector<std.pair<SourceLocation, std.string>> Remarks;
  private std.vector<std.pair<SourceLocation, std.string>> Notes;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::err_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 33,
   FQN="clang::TextDiagnosticBuffer::err_begin", NM="_ZNK5clang20TextDiagnosticBuffer9err_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer9err_beginEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > err_begin() /*const*/ {
    return Errors.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::err_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 34,
   FQN="clang::TextDiagnosticBuffer::err_end", NM="_ZNK5clang20TextDiagnosticBuffer7err_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer7err_endEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > err_end() /*const*/ {
    return Errors.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::warn_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 36,
   FQN="clang::TextDiagnosticBuffer::warn_begin", NM="_ZNK5clang20TextDiagnosticBuffer10warn_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer10warn_beginEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > warn_begin() /*const*/ {
    return Warnings.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::warn_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 37,
   FQN="clang::TextDiagnosticBuffer::warn_end", NM="_ZNK5clang20TextDiagnosticBuffer8warn_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer8warn_endEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > warn_end() /*const*/ {
    return Warnings.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::remark_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 39,
   FQN="clang::TextDiagnosticBuffer::remark_begin", NM="_ZNK5clang20TextDiagnosticBuffer12remark_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer12remark_beginEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > remark_begin() /*const*/ {
    return Remarks.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::remark_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 40,
   FQN="clang::TextDiagnosticBuffer::remark_end", NM="_ZNK5clang20TextDiagnosticBuffer10remark_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer10remark_endEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > remark_end() /*const*/ {
    return Remarks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::note_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 42,
   FQN="clang::TextDiagnosticBuffer::note_begin", NM="_ZNK5clang20TextDiagnosticBuffer10note_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer10note_beginEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > note_begin() /*const*/ {
    return Notes.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::note_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 43,
   FQN="clang::TextDiagnosticBuffer::note_end", NM="_ZNK5clang20TextDiagnosticBuffer8note_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer8note_endEv")
  //</editor-fold>
  public std.vector.iterator<std.pair<SourceLocation, std.string> > note_end() /*const*/ {
    return Notes.end$Const();
  }

  
  
  /// HandleDiagnostic - Store the errors, warnings, and notes that are
  /// reported.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL/*emplace back Clone*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp", line = 22,
   FQN="clang::TextDiagnosticBuffer::HandleDiagnostic", NM="_ZN5clang20TextDiagnosticBuffer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZN5clang20TextDiagnosticBuffer16HandleDiagnosticENS_17DiagnosticsEngine5LevelERKNS_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level Level, 
                  /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    // Default implementation (Warnings/errors count).
    super.HandleDiagnostic(Level, Info);
    
    SmallString/*100*/ Buf/*J*/= new SmallString/*100*/(100);
    Info.FormatDiagnostic(Buf);
    switch (Level) {
     default:
      throw new llvm_unreachable("Diagnostic not handled during diagnostic buffering!");
     case Note:
      Notes.emplace_back(new std.pairTypeType<SourceLocation, std.string>(Native.$Clone(Info.getLocation()), Buf.str().$string()));
      break;
     case Warning:
      Warnings.emplace_back(new std.pairTypeType<SourceLocation, std.string>(Native.$Clone(Info.getLocation()), Buf.str().$string()));
      break;
     case Remark:
      Remarks.emplace_back(new std.pairTypeType<SourceLocation, std.string>(Native.$Clone(Info.getLocation()), Buf.str().$string()));
      break;
     case Error:
     case Fatal:
      Errors.emplace_back(new std.pairTypeType<SourceLocation, std.string>(Native.$Clone(Info.getLocation()), Buf.str().$string()));
      break;
    }
  }

  
  /// FlushDiagnostics - Flush the buffered diagnostics to an given
  /// diagnostic engine.
  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::FlushDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp", line = 48,
   FQN="clang::TextDiagnosticBuffer::FlushDiagnostics", NM="_ZNK5clang20TextDiagnosticBuffer16FlushDiagnosticsERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZNK5clang20TextDiagnosticBuffer16FlushDiagnosticsERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public void FlushDiagnostics(DiagnosticsEngine /*&*/ Diags) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Flush the diagnostics in order.
      for (std.vector.iterator<std.pair<SourceLocation, std.string> > it = err_begin(), ie = err_end(); $noteq___normal_iterator$C(it, ie); it.$preInc())  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, /*KEEP_STR*/"%0"))), 
            new StringRef(it.$arrow().second)));
      }
      for (std.vector.iterator<std.pair<SourceLocation, std.string> > it = warn_begin(), ie = warn_end(); $noteq___normal_iterator$C(it, ie); it.$preInc())  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Warning, /*KEEP_STR*/"%0"))), 
            new StringRef(it.$arrow().second)));
      }
      for (std.vector.iterator<std.pair<SourceLocation, std.string> > it = remark_begin(), ie = remark_end(); $noteq___normal_iterator$C(it, ie); it.$preInc())  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Remark, /*KEEP_STR*/"%0"))), 
            new StringRef(it.$arrow().second)));
      }
      for (std.vector.iterator<std.pair<SourceLocation, std.string> > it = note_begin(), ie = note_end(); $noteq___normal_iterator$C(it, ie); it.$preInc())  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Note, /*KEEP_STR*/"%0"))), 
            new StringRef(it.$arrow().second)));
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::~TextDiagnosticBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 25,
   FQN="clang::TextDiagnosticBuffer::~TextDiagnosticBuffer", NM="_ZN5clang20TextDiagnosticBufferD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticBuffer.cpp -nm=_ZN5clang20TextDiagnosticBufferD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Notes.$destroy();
    Remarks.$destroy();
    Warnings.$destroy();
    Errors.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TextDiagnosticBuffer::TextDiagnosticBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/TextDiagnosticBuffer.h", line = 25,
   FQN="clang::TextDiagnosticBuffer::TextDiagnosticBuffer", NM="_ZN5clang20TextDiagnosticBufferC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN5clang20TextDiagnosticBufferC1Ev")
  //</editor-fold>
  public /*inline*/ TextDiagnosticBuffer() {
    // : DiagnosticConsumer(), Errors(), Warnings(), Remarks(), Notes() 
    //START JInit
    super();
    this.Errors = new std.vector<std.pair<SourceLocation, std.string>>(new std.pairTypeType<SourceLocation, std.string>(new SourceLocation(), std.string.EMPTY));
    this.Warnings = new std.vector<std.pair<SourceLocation, std.string>>(new std.pairTypeType<SourceLocation, std.string>(new SourceLocation(), std.string.EMPTY));
    this.Remarks = new std.vector<std.pair<SourceLocation, std.string>>(new std.pairTypeType<SourceLocation, std.string>(new SourceLocation(), std.string.EMPTY));
    this.Notes = new std.vector<std.pair<SourceLocation, std.string>>(new std.pairTypeType<SourceLocation, std.string>(new SourceLocation(), std.string.EMPTY));
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Errors=" + Errors // NOI18N
              + ", Warnings=" + Warnings // NOI18N
              + ", Remarks=" + Remarks // NOI18N
              + ", Notes=" + Notes // NOI18N
              + super.toString(); // NOI18N
  }
}
