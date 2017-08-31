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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// PrettyStackTraceDecl - If a crash occurs, indicate that it happened when
/// doing something to a specific decl.
//<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1051,
 FQN="clang::PrettyStackTraceDecl", NM="_ZN5clang20PrettyStackTraceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang20PrettyStackTraceDeclE")
//</editor-fold>
public class PrettyStackTraceDecl extends /*public*/ PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  private /*const*/ Decl /*P*/ TheDecl;
  private SourceLocation Loc;
  private final SourceManager /*&*/ SM;
  private /*const*/char$ptr/*char P*/ Message;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceDecl::PrettyStackTraceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1057,
   FQN="clang::PrettyStackTraceDecl::PrettyStackTraceDecl", NM="_ZN5clang20PrettyStackTraceDeclC1EPKNS_4DeclENS_14SourceLocationERNS_13SourceManagerEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang20PrettyStackTraceDeclC1EPKNS_4DeclENS_14SourceLocationERNS_13SourceManagerEPKc")
  //</editor-fold>
  public PrettyStackTraceDecl(/*const*/ Decl /*P*/ theDecl, SourceLocation L, 
      final SourceManager /*&*/ sm, /*const*/char$ptr/*char P*/ Msg) {
    // : PrettyStackTraceEntry(), TheDecl(theDecl), Loc(L), SM(sm), Message(Msg) 
    //START JInit
    super();
    this.TheDecl = theDecl;
    this.Loc = new SourceLocation(L);
    this./*&*/SM=/*&*/sm;
    this.Message = $tryClone(Msg);
    //END JInit
  }

  
  
  //===----------------------------------------------------------------------===//
  // PrettyStackTraceDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceDecl::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 226,
   FQN="clang::PrettyStackTraceDecl::print", NM="_ZNK5clang20PrettyStackTraceDecl5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang20PrettyStackTraceDecl5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    SourceLocation TheLoc = new SourceLocation(Loc);
    if (TheLoc.isInvalid() && (TheDecl != null)) {
      TheLoc.$assignMove(TheDecl.getLocation());
    }
    if (TheLoc.isValid()) {
      TheLoc.print(OS, SM);
      OS.$out(/*KEEP_STR*/": ");
    }
    
    OS.$out(Message);
    {
      
      /*const*/ NamedDecl /*P*/ DN = dyn_cast_or_null_NamedDecl(TheDecl);
      if ((DN != null)) {
        OS.$out(/*KEEP_STR*/" '");
        DN.printQualifiedName(OS);
        OS.$out_char($$SGL_QUOTE);
      }
    }
    OS.$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceDecl::~PrettyStackTraceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1051,
   FQN="clang::PrettyStackTraceDecl::~PrettyStackTraceDecl", NM="_ZN5clang20PrettyStackTraceDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang20PrettyStackTraceDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TheDecl=" + TheDecl // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", SM=" + "[SourceManager]" // NOI18N
              + ", Message=" + Message // NOI18N
              + super.toString(); // NOI18N
  }
}
