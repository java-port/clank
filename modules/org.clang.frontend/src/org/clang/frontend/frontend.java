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

// JAVA: put into frontend class (correspond to frontend namespace) two containers for frontend constants

//<editor-fold defaultstate="collapsed" desc="static type frontend">
@Converted(kind = Converted.Kind.MANUAL/*moved here two classes from top level*/, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendOptions.cpp -nm=_ZN5clang8frontend10ActionKindE;_ZN5clang8frontend12LangFeaturesE; -static-type=frontend")
//</editor-fold>
public final class frontend {

//<editor-fold defaultstate="collapsed" desc="clang::frontend::LangFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/LangStandard.h", line = 20,
 FQN="clang::frontend::LangFeatures", NM="_ZN5clang8frontend12LangFeaturesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/LangStandards.cpp -nm=_ZN5clang8frontend12LangFeaturesE")
//</editor-fold>
public final class/*enum*/ LangFeatures {
  public static final /*uint*/int LineComment = (1 << 0);
  public static final /*uint*/int C89 = (1 << 1);
  public static final /*uint*/int C99 = (1 << 2);
  public static final /*uint*/int C11 = (1 << 3);
  public static final /*uint*/int CPlusPlus = (1 << 4);
  public static final /*uint*/int CPlusPlus11 = (1 << 5);
  public static final /*uint*/int CPlusPlus14 = (1 << 6);
  public static final /*uint*/int CPlusPlus1z = (1 << 7);
  public static final /*uint*/int Digraphs = (1 << 8);
  public static final /*uint*/int GNUMode = (1 << 9);
  public static final /*uint*/int HexFloat = (1 << 10);
  public static final /*uint*/int ImplicitInt = (1 << 11);
}

//<editor-fold defaultstate="collapsed" desc="clang::frontend::ActionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 28,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 27,
 FQN="clang::frontend::ActionKind", NM="_ZN5clang8frontend10ActionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendOptions.cpp -nm=_ZN5clang8frontend10ActionKindE")
//</editor-fold>
public enum ActionKind implements Native.ComparableLower {
  ASTDeclList(0), ///< Parse ASTs and list Decl nodes.
  ASTDump(ASTDeclList.getValue() + 1), ///< Parse ASTs and dump them.
  ASTPrint(ASTDump.getValue() + 1), ///< Parse ASTs and print them.
  ASTView(ASTPrint.getValue() + 1), ///< Parse ASTs and view them in Graphviz.
  DumpRawTokens(ASTView.getValue() + 1), ///< Dump out raw tokens.
  DumpTokens(DumpRawTokens.getValue() + 1), ///< Dump out preprocessed tokens.
  EmitAssembly(DumpTokens.getValue() + 1), ///< Emit a .s file.
  EmitBC(EmitAssembly.getValue() + 1), ///< Emit a .bc file.
  EmitHTML(EmitBC.getValue() + 1), ///< Translate input source into HTML.
  EmitLLVM(EmitHTML.getValue() + 1), ///< Emit a .ll file.
  EmitLLVMOnly(EmitLLVM.getValue() + 1), ///< Generate LLVM IR, but do not emit anything.
  EmitCodeGenOnly(EmitLLVMOnly.getValue() + 1), ///< Generate machine code, but don't emit anything.
  EmitObj(EmitCodeGenOnly.getValue() + 1), ///< Emit a .o file.
  FixIt(EmitObj.getValue() + 1), ///< Parse and apply any fixits to the source.
  GenerateModule(FixIt.getValue() + 1), ///< Generate pre-compiled module.
  GeneratePCH(GenerateModule.getValue() + 1), ///< Generate pre-compiled header.
  GeneratePTH(GeneratePCH.getValue() + 1), ///< Generate pre-tokenized header.
  InitOnly(GeneratePTH.getValue() + 1), ///< Only execute frontend initialization.
  ModuleFileInfo(InitOnly.getValue() + 1), ///< Dump information about a module file.
  VerifyPCH(ModuleFileInfo.getValue() + 1), ///< Load and verify that a PCH file is usable.
  ParseSyntaxOnly(VerifyPCH.getValue() + 1), ///< Parse and perform semantic analysis.
  PluginAction(ParseSyntaxOnly.getValue() + 1), ///< Run a plugin action, \see ActionName.
  PrintDeclContext(PluginAction.getValue() + 1), ///< Print DeclContext and their Decls.
  PrintPreamble(PrintDeclContext.getValue() + 1), ///< Print the "preamble" of the input file
  PrintPreprocessedInput(PrintPreamble.getValue() + 1), ///< -E mode.
  RewriteMacros(PrintPreprocessedInput.getValue() + 1), ///< Expand macros but not \#includes.
  RewriteObjC(RewriteMacros.getValue() + 1), ///< ObjC->C Rewriter.
  RewriteTest(RewriteObjC.getValue() + 1), ///< Rewriter playground
  RunAnalysis(RewriteTest.getValue() + 1), ///< Run one or more source code analyses.
  MigrateSource(RunAnalysis.getValue() + 1), ///< Run migrator.
  RunPreprocessorOnly(MigrateSource.getValue() + 1); ///< Just lex, no output.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ActionKind valueOf(int val) {
    ActionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ActionKind[] VALUES;
    private static final ActionKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ActionKind kind : ActionKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ActionKind[min < 0 ? (1-min) : 0];
      VALUES = new ActionKind[max >= 0 ? (1+max) : 0];
      for (ActionKind kind : ActionKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ActionKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ActionKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ActionKind)obj).value);}
  //</editor-fold>
}

} // END OF class frontend
