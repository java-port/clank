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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import static org.clang.frontend.impl.InitPreprocessorStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type InitPreprocessorClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZN5clang22InitializePreprocessorERNS_12PreprocessorERKNS_19PreprocessorOptionsERKNS_18PCHContainerReaderERKNS_15FrontendOptionsE; -static-type=InitPreprocessorClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class InitPreprocessorClangGlobals {


/// InitializePreprocessor - Initialize the preprocessor getting it and the
/// environment ready to process a single file.

/// InitializePreprocessor - Initialize the preprocessor getting it and the
/// environment ready to process a single file. This returns true on error.
///
//<editor-fold defaultstate="collapsed" desc="clang::InitializePreprocessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 974,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", old_line = 915,
 FQN="clang::InitializePreprocessor", NM="_ZN5clang22InitializePreprocessorERNS_12PreprocessorERKNS_19PreprocessorOptionsERKNS_18PCHContainerReaderERKNS_15FrontendOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZN5clang22InitializePreprocessorERNS_12PreprocessorERKNS_19PreprocessorOptionsERKNS_18PCHContainerReaderERKNS_15FrontendOptionsE")
//</editor-fold>
public static void InitializePreprocessor(Preprocessor /*&*/ PP, /*const*/ PreprocessorOptions /*&*/ InitOpts, 
                      /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                      /*const*/ FrontendOptions /*&*/ FEOpts) {
  raw_string_ostream Predefines = null;
  try {
    /*const*/ LangOptions /*&*/ LangOpts = PP.getLangOpts();
    std.string PredefineBuffer/*J*/= new std.string();
    PredefineBuffer.reserve(4080);
    Predefines/*J*/= new raw_string_ostream(PredefineBuffer);
    MacroBuilder Builder/*J*/= new MacroBuilder(Predefines);
    
    // Emit line markers for various builtin sections of the file.  We don't do
    // this in asm preprocessor mode, because "# 4" is not a line marker directive
    // in this mode.
    if (!PP.getLangOpts().AsmPreprocessor) {
      Builder.append(new Twine(/*KEEP_STR*/"# 1 \"<built-in>\" 3"));
    }
    
    // Install things like __POWERPC__, __GNUC__, etc into the macro table.
    if (InitOpts.UsePredefines) {
      if (LangOpts.CUDA && (PP.getAuxTargetInfo() != null)) {
        InitializePredefinedMacros(/*Deref*/PP.getAuxTargetInfo(), LangOpts, FEOpts, 
            Builder);
      }
      
      InitializePredefinedMacros(PP.getTargetInfo(), LangOpts, FEOpts, Builder);
      
      // Install definitions to make Objective-C++ ARC work well with various
      // C++ Standard Library implementations.
      if (LangOpts.ObjC1 && LangOpts.CPlusPlus
         && (LangOpts.ObjCAutoRefCount || LangOpts.ObjCWeak)) {
        switch (InitOpts.ObjCXXARCStandardLibrary) {
         case ARCXX_nolib:
         case ARCXX_libcxx:
          break;
         case ARCXX_libstdcxx:
          AddObjCXXARCLibstdcxxDefines(LangOpts, Builder);
          break;
        }
      }
    }
    
    // Even with predefines off, some macros are still predefined.
    // These should all be defined in the preprocessor according to the
    // current language configuration.
    InitializeStandardPredefinedMacros(PP.getTargetInfo(), PP.getLangOpts(), 
        FEOpts, Builder);
    
    // Add on the predefines from the driver.  Wrap in a #line directive to report
    // that they come from the command line.
    if (!PP.getLangOpts().AsmPreprocessor) {
      Builder.append(new Twine(/*KEEP_STR*/"# 1 \"<command line>\" 1"));
    }
    
    // Process #define's and #undef's in the order they are given.
    for (/*uint*/int i = 0, e = InitOpts.Macros.size(); i != e; ++i) {
      if (InitOpts.Macros.$at$Const(i).second) { // isUndef
        Builder.undefineMacro(new Twine(InitOpts.Macros.$at$Const(i).first));
      } else {
        DefineBuiltinMacro(Builder, new StringRef(InitOpts.Macros.$at$Const(i).first), 
            PP.getDiagnostics());
      }
    }
    
    // Exit the command line and go back to <built-in> (2 is LC_LEAVE).
    if (!PP.getLangOpts().AsmPreprocessor) {
      Builder.append(new Twine(/*KEEP_STR*/"# 1 \"<built-in>\" 2"));
    }
    
    // If -imacros are specified, include them now.  These are processed before
    // any -include directives.
    for (/*uint*/int i = 0, e = InitOpts.MacroIncludes.size(); i != e; ++i)  {
      AddImplicitIncludeMacros(Builder, new StringRef(InitOpts.MacroIncludes.$at$Const(i)));
    }
    
    // Process -include-pch/-include-pth directives.
    if (!InitOpts.ImplicitPCHInclude.empty()) {
      AddImplicitIncludePCH(Builder, PP, PCHContainerRdr, 
          new StringRef(InitOpts.ImplicitPCHInclude));
    }
    if (!InitOpts.ImplicitPTHInclude.empty()) {
      AddImplicitIncludePTH(Builder, PP, new StringRef(InitOpts.ImplicitPTHInclude));
    }
    
    // Process -include directives.
    for (/*uint*/int i = 0, e = InitOpts.Includes.size(); i != e; ++i) {
      /*const*/std.string/*&*/ Path = InitOpts.Includes.$at$Const(i);
      AddImplicitInclude(Builder, new StringRef(Path));
    }
    
    // Instruct the preprocessor to skip the preamble.
    PP.setSkipMainFilePreamble(InitOpts.PrecompiledPreambleBytes.first, 
        InitOpts.PrecompiledPreambleBytes.second);
    
    // Copy PredefinedBuffer into the Preprocessor.
    PP.setPredefines(new StringRef(Predefines.str()));
  } finally {
    if (Predefines != null) { Predefines.$destroy(); }
  }
}

} // END OF class InitPreprocessorClangGlobals
