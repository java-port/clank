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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type HTMLPrintClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN5clang17CreateHTMLPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EERNS_12PreprocessorEbb; -static-type=HTMLPrintClangGlobals -package=org.clang.rewrite.frontend.impl")
//</editor-fold>
public final class HTMLPrintClangGlobals {


/// CreateHTMLPrinter - Create an AST consumer which rewrites source code to
/// HTML with syntax highlighting suitable for viewing in a web-browser.
//<editor-fold defaultstate="collapsed" desc="clang::CreateHTMLPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 50,
 FQN="clang::CreateHTMLPrinter", NM="_ZN5clang17CreateHTMLPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EERNS_12PreprocessorEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN5clang17CreateHTMLPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EERNS_12PreprocessorEbb")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateHTMLPrinter(std.unique_ptr<raw_ostream> OS, Preprocessor /*&*/ PP) {
  return CreateHTMLPrinter(OS, PP, 
                 true, true);
}
public static std.unique_ptr<ASTConsumer> CreateHTMLPrinter(std.unique_ptr<raw_ostream> OS, Preprocessor /*&*/ PP, 
                 boolean SyntaxHighlight/*= true*/) {
  return CreateHTMLPrinter(OS, PP, 
                 SyntaxHighlight, true);
}
public static std.unique_ptr<ASTConsumer> CreateHTMLPrinter(std.unique_ptr<raw_ostream> OS, Preprocessor /*&*/ PP, 
                 boolean SyntaxHighlight/*= true*/, boolean HighlightMacros/*= true*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new HTMLPrinter(std.move(OS), PP, SyntaxHighlight, 
            HighlightMacros)))));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class HTMLPrintClangGlobals
