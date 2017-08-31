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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type InclusionRewriterClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN5clang22RewriteIncludesInInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE; -static-type=InclusionRewriterClangGlobals -package=org.clang.rewrite.frontend.impl")
//</editor-fold>
public final class InclusionRewriterClangGlobals {


/// RewriteIncludesInInput - Implement -frewrite-includes mode.

/// InclusionRewriterInInput - Implement -frewrite-includes mode.
//<editor-fold defaultstate="collapsed" desc="clang::RewriteIncludesInInput">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 578,
 FQN="clang::RewriteIncludesInInput", NM="_ZN5clang22RewriteIncludesInInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN5clang22RewriteIncludesInInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE")
//</editor-fold>
public static void RewriteIncludesInInput(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS, 
                      /*const*/ PreprocessorOutputOptions /*&*/ Opts) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceManager /*&*/ SM = PP.getSourceManager();
    InclusionRewriter /*P*/ Rewrite = new InclusionRewriter(PP, /*Deref*/OS, Opts.ShowLineMarkers, Opts.UseLineDirectives);
    Rewrite.detectMainFileEOL();
    
    PP.addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(Rewrite))); $c$.clean();
    PP.IgnorePragmas();
    
    // First let the preprocessor process the entire file and call callbacks.
    // Callbacks will record which #include's were actually performed.
    PP.EnterMainSourceFile();
    Token Tok/*J*/= new Token();
    // Only preprocessor directives matter here, so disable macro expansion
    // everywhere else as an optimization.
    // TODO: It would be even faster if the preprocessor could be switched
    // to a mode where it would parse only preprocessor directives and comments,
    // nothing else matters for parsing or processing.
    PP.SetMacroExpansionOnlyInDirectives();
    do {
      PP.Lex(Tok);
    } while (Tok.isNot(tok.TokenKind.eof));
    Rewrite.setPredefinesBuffer(SM.getBuffer(PP.getPredefinesFileID()));
    Rewrite.Process(PP.getPredefinesFileID(), SrcMgr.CharacteristicKind.C_User);
    Rewrite.Process(SM.getMainFileID(), SrcMgr.CharacteristicKind.C_User);
    OS.flush();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class InclusionRewriterClangGlobals
