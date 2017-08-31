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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import static org.clang.frontend.impl.PrintPreprocessedOutputStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type PrintPreprocessedOutputClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN5clang24DoPrintPreprocessedInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE; -static-type=PrintPreprocessedOutputClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class PrintPreprocessedOutputClangGlobals {


/// DoPrintPreprocessedInput - Implement -E mode.

/// DoPrintPreprocessedInput - This implements -E mode.
///
//<editor-fold defaultstate="collapsed" desc="clang::DoPrintPreprocessedInput">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 740,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 719,
 FQN="clang::DoPrintPreprocessedInput", NM="_ZN5clang24DoPrintPreprocessedInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN5clang24DoPrintPreprocessedInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE")
//</editor-fold>
public static void DoPrintPreprocessedInput(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS, 
                        /*const*/ PreprocessorOutputOptions /*&*/ Opts) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Show macros with no output is handled specially.
    if (!Opts.ShowCPP) {
      assert (Opts.ShowMacros) : "Not yet implemented!";
      DoPrintMacros(PP, OS);
      return;
    }
    
    // Inform the preprocessor whether we want it to retain comments or not, due
    // to -C or -CC.
    PP.SetCommentRetentionState(Opts.ShowComments, Opts.ShowMacroComments);
    
    PrintPPOutputPPCallbacks /*P*/ Callbacks = new PrintPPOutputPPCallbacks(PP, /*Deref*/OS, !Opts.ShowLineMarkers, Opts.ShowMacros, Opts.UseLineDirectives);
    
    // Expand macros in pragmas with -fms-extensions.  The assumption is that
    // the majority of pragmas in such a file will be Microsoft pragmas.
    PP.AddPragmaHandler(new UnknownPragmaHandler(/*KEEP_STR*/"#pragma", Callbacks, 
            /*RequireTokenExpansion=*/ PP.getLangOpts().MicrosoftExt));
    PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"GCC"), new UnknownPragmaHandler(/*KEEP_STR*/"#pragma GCC", Callbacks, 
            /*RequireTokenExpansion=*/ PP.getLangOpts().MicrosoftExt));
    PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"clang"), new UnknownPragmaHandler(/*KEEP_STR*/"#pragma clang", Callbacks, 
            /*RequireTokenExpansion=*/ PP.getLangOpts().MicrosoftExt));
    
    // The tokens after pragma omp need to be expanded.
    //
    //  OpenMP [2.1, Directive format]
    //  Preprocessing tokens following the #pragma omp are subject to macro
    //  replacement.
    PP.AddPragmaHandler(new StringRef(/*KEEP_STR*/"omp"), 
        new UnknownPragmaHandler(/*KEEP_STR*/"#pragma omp", Callbacks, 
            /*RequireTokenExpansion=*/ true));
    
    PP.addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(Callbacks))); $c$.clean();
    
    // After we have configured the preprocessor, enter the main file.
    PP.EnterMainSourceFile();
    
    // Consume all of the tokens that come from the predefines buffer.  Those
    // should not be emitted into the output and are guaranteed to be at the
    // start.
    /*const*/ SourceManager /*&*/ SourceMgr = PP.getSourceManager();
    Token Tok/*J*/= new Token();
    do {
      PP.Lex(Tok);
      if (Tok.is(tok.TokenKind.eof) || !SourceLocation.isFileID(Tok.$getLocation())) {
        break;
      }
      
      PresumedLoc PLoc = SourceMgr.getPresumedLoc(Tok.$getLocation());
      if (PLoc.isInvalid()) {
        break;
      }
      if ((strcmp(PLoc.getFilename(), /*KEEP_STR*/"<built-in>") != 0)) {
        break;
      }
    } while (true);
    
    // Read all the preprocessed tokens, printing them out to the stream.
    PrintPreprocessedTokens(PP, Tok, Callbacks, /*Deref*/OS);
    /*Deref*/OS.$out_char($$LF);
  } finally {
    $c$.$destroy();
  }
}

} // END OF class PrintPreprocessedOutputClangGlobals
