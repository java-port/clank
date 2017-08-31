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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.frontend.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTConsumersClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang15CreateASTDumperEN4llvm9StringRefEbb;_ZN5clang15CreateASTViewerEv;_ZN5clang16CreateASTPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EENS1_9StringRefE;_ZN5clang23CreateASTDeclNodeListerEv;_ZN5clang24CreateDeclContextPrinterEv; -static-type=ASTConsumersClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class ASTConsumersClangGlobals {


// AST pretty-printer: prints out the AST in a format that is close to the
// original C code.  The output is intended to be in a format such that
// clang could re-parse the output back into the same AST, but the
// implementation is still incomplete.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 126,
 FQN="clang::CreateASTPrinter", NM="_ZN5clang16CreateASTPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EENS1_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang16CreateASTPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EENS1_9StringRefE")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTPrinter(std.unique_ptr<raw_ostream> Out, 
                StringRef FilterString) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ASTPrinter(std.move(Out), /*Dump=*/ false, 
            FilterString)))));
  } finally {
    $c$.$destroy();
  }
}


// AST dumper: dumps the raw AST in human-readable form to stderr; this is
// intended for debugging.
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTDumper">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 133,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 130,
 FQN="clang::CreateASTDumper", NM="_ZN5clang15CreateASTDumperEN4llvm9StringRefEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang15CreateASTDumperEN4llvm9StringRefEbb")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTDumper(StringRef FilterString, 
               boolean DumpDecls, 
               boolean DumpLookups) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert ((DumpDecls || DumpLookups)) : "nothing to dump";
    return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ASTPrinter(new std.unique_ptr(JD$NullPtr.INSTANCE, null), DumpDecls, FilterString, 
            DumpLookups)))));
  } finally {
    $c$.$destroy();
  }
}


// AST Decl node lister: prints qualified names of all filterable AST Decl
// nodes.
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTDeclNodeLister">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 141,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 138,
 FQN="clang::CreateASTDeclNodeLister", NM="_ZN5clang23CreateASTDeclNodeListerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang23CreateASTDeclNodeListerEv")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTDeclNodeLister() {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ASTDeclNodeLister(null)))));
  } finally {
    $c$.$destroy();
  }
}


// Graphical AST viewer: for each function definition, creates a graph of
// the AST and displays it with the graph viewer "dotty".  Also outputs
// function declarations to stderr.
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTViewer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 178,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 175,
 FQN="clang::CreateASTViewer", NM="_ZN5clang15CreateASTViewerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang15CreateASTViewerEv")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTViewer() {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ASTViewer()))));
  } finally {
    $c$.$destroy();
  }
}


// DeclContext printer: prints out the DeclContext tree in human-readable form
// to stderr; this is intended for debugging.
//<editor-fold defaultstate="collapsed" desc="clang::CreateDeclContextPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 488,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 487,
 FQN="clang::CreateDeclContextPrinter", NM="_ZN5clang24CreateDeclContextPrinterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang24CreateDeclContextPrinterEv")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateDeclContextPrinter() {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DeclContextPrinter()))));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class ASTConsumersClangGlobals
