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

package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.rewrite.core.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 33,
 FQN="(anonymous namespace)::HTMLPrinter", NM="_ZN12_GLOBAL__N_111HTMLPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN12_GLOBAL__N_111HTMLPrinterE")
//</editor-fold>
public class HTMLPrinter extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  private Rewriter R;
  private std.unique_ptr<raw_ostream> Out;
  private Preprocessor /*&*/ PP;
  private boolean SyntaxHighlight;
  private boolean HighlightMacros;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLPrinter::HTMLPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 40,
   FQN="(anonymous namespace)::HTMLPrinter::HTMLPrinter", NM="_ZN12_GLOBAL__N_111HTMLPrinterC1ESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang12PreprocessorEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN12_GLOBAL__N_111HTMLPrinterC1ESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang12PreprocessorEbb")
  //</editor-fold>
  public HTMLPrinter(std.unique_ptr<raw_ostream> OS, Preprocessor /*&*/ pp, 
      boolean _SyntaxHighlight, boolean _HighlightMacros) {
    // : ASTConsumer(), R(), Out(std::move(OS)), PP(pp), SyntaxHighlight(_SyntaxHighlight), HighlightMacros(_HighlightMacros) 
    //START JInit
    super();
    this.R = new Rewriter();
    this.Out = new std.unique_ptr<raw_ostream>(JD$Move.INSTANCE, std.move(OS));
    this./*&*/PP=/*&*/pp;
    this.SyntaxHighlight = _SyntaxHighlight;
    this.HighlightMacros = _HighlightMacros;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLPrinter::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 57,
   FQN="(anonymous namespace)::HTMLPrinter::Initialize", NM="_ZN12_GLOBAL__N_111HTMLPrinter10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN12_GLOBAL__N_111HTMLPrinter10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(ASTContext /*&*/ context)/* override*/ {
    R.setSourceMgr(context.getSourceManager(), context.getLangOpts());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLPrinter::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 61,
   FQN="(anonymous namespace)::HTMLPrinter::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_111HTMLPrinter21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN12_GLOBAL__N_111HTMLPrinter21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ Ctx)/* override*/ {
    if (PP.getDiagnostics().hasErrorOccurred()) {
      return;
    }
    
    // Format the file.
    FileID FID = R.getSourceMgr().getMainFileID();
    /*const*/ FileEntry /*P*/ Entry = R.getSourceMgr().getFileEntryForID(/*NO_COPY*/FID);
    /*const*/char$ptr/*char P*/ Name;
    // In some cases, in particular the case where the input is from stdin,
    // there is no entry.  Fall back to the memory buffer for a name in those
    // cases.
    if ((Entry != null)) {
      Name = $tryClone(Entry.getName());
    } else {
      Name = $tryClone(R.getSourceMgr().getBuffer(/*NO_COPY*/FID).getBufferIdentifier());
    }
    
    html.AddLineNumbers(R, new FileID(FID));
    html.AddHeaderFooterInternalBuiltinCSS(R, new FileID(FID), Name);
    
    // If we have a preprocessor, relex the file and syntax highlight.
    // We might not have a preprocessor if we come from a deserialized AST file,
    // for example.
    if (SyntaxHighlight) {
      html.SyntaxHighlight(R, new FileID(FID), PP);
    }
    if (HighlightMacros) {
      html.HighlightMacros(R, new FileID(FID), PP);
    }
    html.EscapeText(R, new FileID(FID), false, true);
    
    // Emit the HTML.
    /*const*/ RewriteBuffer /*&*/ RewriteBuf = R.getEditBuffer(new FileID(FID));
    char$ptr/*char P*/ Buffer = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, malloc(RewriteBuf.size())));
    std.copy(RewriteBuf.begin(), RewriteBuf.end(), Buffer);
    Out.$arrow().write(Buffer, RewriteBuf.size());
    free(Buffer);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLPrinter::~HTMLPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 33,
   FQN="(anonymous namespace)::HTMLPrinter::~HTMLPrinter", NM="_ZN12_GLOBAL__N_111HTMLPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN12_GLOBAL__N_111HTMLPrinterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Out.$destroy();
    R.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + ", Out=" + Out // NOI18N
              + ", PP=" + PP // NOI18N
              + ", SyntaxHighlight=" + SyntaxHighlight // NOI18N
              + ", HighlightMacros=" + HighlightMacros // NOI18N
              + super.toString(); // NOI18N
  }
}
