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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// PrettyDeclStackTraceEntry - If a crash occurs in the parser while
/// parsing something related to a declaration, include that
/// declaration in the stack trace.
//<editor-fold defaultstate="collapsed" desc="clang::PrettyDeclStackTraceEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/PrettyDeclStackTrace.h", line = 31,
 FQN="clang::PrettyDeclStackTraceEntry", NM="_ZN5clang25PrettyDeclStackTraceEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang25PrettyDeclStackTraceEntryE")
//</editor-fold>
public class PrettyDeclStackTraceEntry extends /*public*/ PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  private Decl /*P*/ TheDecl;
  private SourceLocation Loc;
  private /*const*/char$ptr/*char P*/ Message;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PrettyDeclStackTraceEntry::PrettyDeclStackTraceEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/PrettyDeclStackTrace.h", line = 38,
   FQN="clang::PrettyDeclStackTraceEntry::PrettyDeclStackTraceEntry", NM="_ZN5clang25PrettyDeclStackTraceEntryC1ERNS_4SemaEPNS_4DeclENS_14SourceLocationEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang25PrettyDeclStackTraceEntryC1ERNS_4SemaEPNS_4DeclENS_14SourceLocationEPKc")
  //</editor-fold>
  public PrettyDeclStackTraceEntry(final Sema /*&*/ S, Decl /*P*/ D, SourceLocation Loc, 
      /*const*/char$ptr/*char P*/ Msg) {
    // : PrettyStackTraceEntry(), S(S), TheDecl(D), Loc(Loc), Message(Msg) 
    //START JInit
    super();
    this./*&*/S=/*&*/S;
    this.TheDecl = D;
    this.Loc = new SourceLocation(Loc);
    this.Message = $tryClone(Msg);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PrettyDeclStackTraceEntry::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1268,
   FQN="clang::PrettyDeclStackTraceEntry::print", NM="_ZNK5clang25PrettyDeclStackTraceEntry5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang25PrettyDeclStackTraceEntry5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    SourceLocation Loc = new SourceLocation(this.Loc);
    if (!Loc.isValid() && (TheDecl != null)) {
      Loc.$assignMove(TheDecl.getLocation());
    }
    if (Loc.isValid()) {
      Loc.print(OS, S.getSourceManager());
      OS.$out(/*KEEP_STR*/": ");
    }
    OS.$out(Message);
    {
      
      NamedDecl /*P*/ ND = dyn_cast_or_null(NamedDecl.class, TheDecl);
      if ((ND != null)) {
        OS.$out(/*KEEP_STR*/" '");
        ND.getNameForDiagnostic(OS, ND.getASTContext().getPrintingPolicy(), true);
        OS.$out(/*KEEP_STR*/$SGL_QUOTE);
      }
    }
    
    OS.$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrettyDeclStackTraceEntry::~PrettyDeclStackTraceEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/PrettyDeclStackTrace.h", line = 31,
   FQN="clang::PrettyDeclStackTraceEntry::~PrettyDeclStackTraceEntry", NM="_ZN5clang25PrettyDeclStackTraceEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang25PrettyDeclStackTraceEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", TheDecl=" + TheDecl // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Message=" + Message // NOI18N
              + super.toString(); // NOI18N
  }
}
