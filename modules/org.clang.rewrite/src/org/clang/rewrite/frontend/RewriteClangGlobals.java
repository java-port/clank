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
package org.clang.rewrite.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.rewrite.frontend.RewriteClangGlobals.*;
import org.clang.frontend.*;
import org.clang.ast.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type RewriteClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteTest.cpp -nm=_ZN5clang13DoRewriteTestERNS_12PreprocessorEPN4llvm11raw_ostreamE;_ZN5clang17CreateHTMLPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EERNS_12PreprocessorEbb;_ZN5clang18CreateObjCRewriterERKSsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS4_EERNS_17DiagnosticsEngineERKNS_11LangOptionsEb;_ZN5clang20RewriteMacrosInInputERNS_12PreprocessorEPN4llvm11raw_ostreamE;_ZN5clang22RewriteIncludesInInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE;_ZN5clang24CreateModernObjCRewriterERKSsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS4_EERNS_17DiagnosticsEngineERKNS_11LangOptionsEbb; -static-type=RewriteClangGlobals -package=org.clang.rewrite.frontend")
//</editor-fold>
public final class RewriteClangGlobals {


/// CreateHTMLPrinter - Create an AST consumer which rewrites source code to
/// HTML with syntax highlighting suitable for viewing in a web-browser.
//<editor-fold defaultstate="collapsed" desc="clang::CreateHTMLPrinter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp", line = 50,
 FQN="clang::CreateHTMLPrinter", NM="_ZN5clang17CreateHTMLPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EERNS_12PreprocessorEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/HTMLPrint.cpp -nm=_ZN5clang17CreateHTMLPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EERNS_12PreprocessorEbb")
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
  return /*delegate*/org.clang.rewrite.frontend.impl.HTMLPrintClangGlobals.
    CreateHTMLPrinter(OS, PP, 
                 SyntaxHighlight, HighlightMacros);
}


/// RewriteIncludesInInput - Implement -frewrite-includes mode.

/// InclusionRewriterInInput - Implement -frewrite-includes mode.
//<editor-fold defaultstate="collapsed" desc="clang::RewriteIncludesInInput">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp", line = 578,
 FQN="clang::RewriteIncludesInInput", NM="_ZN5clang22RewriteIncludesInInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/InclusionRewriter.cpp -nm=_ZN5clang22RewriteIncludesInInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE")
//</editor-fold>
public static void RewriteIncludesInInput(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS, 
                      /*const*/ PreprocessorOutputOptions /*&*/ Opts) {
  /*delegate*/org.clang.rewrite.frontend.impl.InclusionRewriterClangGlobals.
    RewriteIncludesInInput(PP, OS, 
                      Opts);
}


/// RewriteMacrosInInput - Implement -rewrite-macros mode.

/// RewriteMacrosInInput - Implement -rewrite-macros mode.
//<editor-fold defaultstate="collapsed" desc="clang::RewriteMacrosInInput">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp", line = 90,
 FQN="clang::RewriteMacrosInInput", NM="_ZN5clang20RewriteMacrosInInputERNS_12PreprocessorEPN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZN5clang20RewriteMacrosInInputERNS_12PreprocessorEPN4llvm11raw_ostreamE")
//</editor-fold>
public static void RewriteMacrosInInput(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS) {
  /*delegate*/org.clang.rewrite.frontend.impl.RewriteMacrosClangGlobals.
    RewriteMacrosInInput(PP, OS);
}

//<editor-fold defaultstate="collapsed" desc="clang::CreateModernObjCRewriter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 662,
 FQN="clang::CreateModernObjCRewriter", NM="_ZN5clang24CreateModernObjCRewriterERKSsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS4_EERNS_17DiagnosticsEngineERKNS_11LangOptionsEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZN5clang24CreateModernObjCRewriterERKSsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS4_EERNS_17DiagnosticsEngineERKNS_11LangOptionsEbb")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateModernObjCRewriter(/*const*/std.string/*&*/ InFile, std.unique_ptr<raw_ostream> OS, 
                        DiagnosticsEngine /*&*/ Diags, /*const*/ LangOptions /*&*/ LOpts, 
                        boolean SilenceRewriteMacroWarning, boolean LineInfo) {
  return /*delegate*/org.clang.rewrite.frontend.impl.RewriteModernObjCClangGlobals.
    CreateModernObjCRewriter(InFile, OS, 
                        Diags, LOpts, 
                        SilenceRewriteMacroWarning, LineInfo);
}


// ObjC rewriter: attempts to rewrite ObjC constructs into pure C code.
// This is considered experimental, and only works with Apple's ObjC runtime.
//<editor-fold defaultstate="collapsed" desc="clang::CreateObjCRewriter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 591,
 FQN="clang::CreateObjCRewriter", NM="_ZN5clang18CreateObjCRewriterERKSsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS4_EERNS_17DiagnosticsEngineERKNS_11LangOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang18CreateObjCRewriterERKSsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS4_EERNS_17DiagnosticsEngineERKNS_11LangOptionsEb")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateObjCRewriter(/*const*/std.string/*&*/ InFile, 
                  std.unique_ptr<raw_ostream> OS, 
                  DiagnosticsEngine /*&*/ Diags, /*const*/ LangOptions /*&*/ LOpts, 
                  boolean SilenceRewriteMacroWarning) {
  return /*delegate*/org.clang.rewrite.frontend.impl.RewriteObjCClangGlobals.
    CreateObjCRewriter(InFile, 
                  OS, 
                  Diags, LOpts, 
                  SilenceRewriteMacroWarning);
}


/// DoRewriteTest - A simple test for the TokenRewriter class.
//<editor-fold defaultstate="collapsed" desc="clang::DoRewriteTest">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteTest.cpp", line = 19,
 FQN="clang::DoRewriteTest", NM="_ZN5clang13DoRewriteTestERNS_12PreprocessorEPN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteTest.cpp -nm=_ZN5clang13DoRewriteTestERNS_12PreprocessorEPN4llvm11raw_ostreamE")
//</editor-fold>
public static void DoRewriteTest(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS) {
  /*delegate*/org.clang.rewrite.frontend.impl.RewriteTestClangGlobals.
    DoRewriteTest(PP, OS);
}

} // END OF class RewriteClangGlobals
