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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.target.TargetOptions;
import org.clang.lex.*;
import org.clang.serialization.*;

/// \brief AST reader listener that dumps module information for a module
/// file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 455,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 450,
 FQN="(anonymous namespace)::DumpModuleInfoListener", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListenerE")
//</editor-fold>
public class DumpModuleInfoListener extends /*public*/ ASTReaderListener implements Destructors.ClassWithDestructor {
  private raw_ostream /*&*/ Out;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::DumpModuleInfoListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 459,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 454,
   FQN="(anonymous namespace)::DumpModuleInfoListener::DumpModuleInfoListener", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListenerC1ERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListenerC1ERN4llvm11raw_ostreamE")
  //</editor-fold>
  public DumpModuleInfoListener(raw_ostream /*&*/ Out) {
    // : ASTReaderListener(), Out(Out) 
    //START JInit
    super();
    this./*&*/Out=/*&*/Out;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadFullVersionInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 464,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 459,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadFullVersionInformation", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener26ReadFullVersionInformationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener26ReadFullVersionInformationEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean ReadFullVersionInformation(StringRef FullVersion)/* override*/ {
    Out.indent(2).$out(
        /*KEEP_STR*/"Generated by "
    ).$out(
        ($eq_StringRef(/*NO_COPY*/FullVersion, new StringRef(getClangFullRepositoryVersion())) ? $this : $("a different"))
    ).$out(
        /*KEEP_STR*/" Clang: "
    ).$out(/*NO_COPY*/FullVersion).$out(/*KEEP_STR*/$LF);
    return super.ReadFullVersionInformation(new StringRef(FullVersion));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadModuleName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 473,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 468,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadModuleName", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener14ReadModuleNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener14ReadModuleNameEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void ReadModuleName(StringRef ModuleName)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Module name: ").$out(/*NO_COPY*/ModuleName).$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 476,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 471,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadModuleMapFile", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener17ReadModuleMapFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener17ReadModuleMapFileEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void ReadModuleMapFile(StringRef ModuleMapPath)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Module map file: ").$out(/*NO_COPY*/ModuleMapPath).$out(/*KEEP_STR*/$LF);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadLanguageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 480,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 475,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadLanguageOptions", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener19ReadLanguageOptionsERKN5clang11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener19ReadLanguageOptionsERKN5clang11LangOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadLanguageOptions(/*const*/ LangOptions /*&*/ LangOpts, boolean Complain, 
                     boolean AllowCompatibleDifferences)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Language options:\n");
    
    // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
    Out.indent(4).$out(/*KEEP_STR*/"C99").$out(/*KEEP_STR*/": ").$out((LangOpts.C99 ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C11").$out(/*KEEP_STR*/": ").$out((LangOpts.C11 ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Microsoft Visual C++ full compatibility mode").$out(/*KEEP_STR*/": ").$out((LangOpts.MSVCCompat ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Microsoft C++ extensions").$out(/*KEEP_STR*/": ").$out((LangOpts.MicrosoftExt ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Microsoft inline asm blocks").$out(/*KEEP_STR*/": ").$out((LangOpts.AsmBlocks ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Borland extensions").$out(/*KEEP_STR*/": ").$out((LangOpts.Borland ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++").$out(/*KEEP_STR*/": ").$out((LangOpts.CPlusPlus ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++11").$out(/*KEEP_STR*/": ").$out((LangOpts.CPlusPlus11 ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++14").$out(/*KEEP_STR*/": ").$out((LangOpts.CPlusPlus14 ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++1z").$out(/*KEEP_STR*/": ").$out((LangOpts.CPlusPlus1z ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C 1").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjC1 ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C 2").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjC2 ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C App Extension").$out(/*KEEP_STR*/": ").$out((LangOpts.AppExt ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"trigraphs").$out(/*KEEP_STR*/": ").$out((LangOpts.Trigraphs ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"'//' comments").$out(/*KEEP_STR*/": ").$out((LangOpts.LineComment ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"bool, true, and false keywords").$out(/*KEEP_STR*/": ").$out((LangOpts.Bool ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"half keyword").$out(/*KEEP_STR*/": ").$out((LangOpts.Half ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"wchar_t keyword").$out(/*KEEP_STR*/": ").$out((LangOpts.WChar ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__declspec keyword").$out(/*KEEP_STR*/": ").$out((LangOpts.DeclSpecKeyword ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"GNU keywords").$out(/*KEEP_STR*/": ").$out((LangOpts.GNUKeywords ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"digraphs").$out(/*KEEP_STR*/": ").$out((LangOpts.Digraphs ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++ operator name keywords").$out(/*KEEP_STR*/": ").$out((LangOpts.CXXOperatorNames ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Apple kext support").$out(/*KEEP_STR*/": ").$out((LangOpts.AppleKext ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"writable string support").$out(/*KEEP_STR*/": ").$out((LangOpts.WritableStrings ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"const-qualified string support").$out(/*KEEP_STR*/": ").$out((LangOpts.ConstStrings ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"lax vector conversions").$out(/*KEEP_STR*/": ").$out((LangOpts.LaxVectorConversions ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"AltiVec-style vector initializers").$out(/*KEEP_STR*/": ").$out((LangOpts.AltiVec ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"System z vector extensions").$out(/*KEEP_STR*/": ").$out((LangOpts.ZVector ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"exception handling").$out(/*KEEP_STR*/": ").$out((LangOpts.Exceptions ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C exceptions").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjCExceptions ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++ exceptions").$out(/*KEEP_STR*/": ").$out((LangOpts.CXXExceptions ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"setjmp-longjump exception handling").$out(/*KEEP_STR*/": ").$out((LangOpts.SjLjExceptions ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Assume extern C functions don't unwind").$out(/*KEEP_STR*/": ").$out((LangOpts.ExternCNoUnwind ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"traditional CPP emulation").$out(/*KEEP_STR*/": ").$out((LangOpts.TraditionalCPP ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"run-time type information").$out(/*KEEP_STR*/": ").$out((LangOpts.RTTI ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"emit run-time type information data").$out(/*KEEP_STR*/": ").$out((LangOpts.RTTIData ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Microsoft-compatible structure layout").$out(/*KEEP_STR*/": ").$out((LangOpts.MSBitfields ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"freestanding implementation").$out(/*KEEP_STR*/": ").$out((LangOpts.Freestanding ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"disable builtin functions").$out(/*KEEP_STR*/": ").$out((LangOpts.NoBuiltin ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"disable math builtin functions").$out(/*KEEP_STR*/": ").$out((LangOpts.NoMathBuiltin ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"GNU-style inline assembly").$out(/*KEEP_STR*/": ").$out((LangOpts.GNUAsm ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"C++ coroutines").$out(/*KEEP_STR*/": ").$out((LangOpts.Coroutines ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"POSIX thread support").$out(/*KEEP_STR*/": ").$out((LangOpts.POSIXThreads ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"blocks extension to C").$out(/*KEEP_STR*/": ").$out((LangOpts.Blocks ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"errno in math functions").$out(/*KEEP_STR*/": ").$out((LangOpts.MathErrno ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"modules extension to C").$out(/*KEEP_STR*/": ").$out((LangOpts.Modules ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"require declaration of module uses").$out(/*KEEP_STR*/": ").$out((LangOpts.ModulesDeclUse ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"requiring declaration of module uses and all headers to be in modules").$out(/*KEEP_STR*/": ").$out((LangOpts.ModulesStrictDeclUse ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"local submodule visibility").$out(/*KEEP_STR*/": ").$out((LangOpts.ModulesLocalVisibility ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__OPTIMIZE__ predefined macro").$out(/*KEEP_STR*/": ").$out((LangOpts.Optimize ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__OPTIMIZE_SIZE__ predefined macro").$out(/*KEEP_STR*/": ").$out((LangOpts.OptimizeSize ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__STATIC__ predefined macro (as opposed to __DYNAMIC__)").$out(/*KEEP_STR*/": ").$out((LangOpts.Static ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"default struct packing maximum alignment").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.PackStruct).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"default maximum alignment for types").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.MaxTypeAlign).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Controls if doubles should be aligned to 8 bytes (x86 only)").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.AlignDouble).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__PIC__ level").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.PICLevel).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"is pie").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.PIE).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"GNU inline semantics").$out(/*KEEP_STR*/": ").$out((LangOpts.GNUInline ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__NO_INLINE__ predefined macro").$out(/*KEEP_STR*/": ").$out((LangOpts.NoInlineDefine ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__DEPRECATED predefined macro").$out(/*KEEP_STR*/": ").$out((LangOpts.Deprecated ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"fast FP math optimizations, and __FAST_MATH__ predefined macro").$out(/*KEEP_STR*/": ").$out((LangOpts.FastMath ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__FINITE_MATH_ONLY__ predefined macro").$out(/*KEEP_STR*/": ").$out((LangOpts.FiniteMathOnly ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Unsafe Floating Point Math").$out(/*KEEP_STR*/": ").$out((LangOpts.UnsafeFPMath ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/$signed_char).$out(/*KEEP_STR*/": ").$out((LangOpts.CharIsSigned ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"unsigned short wchar_t").$out(/*KEEP_STR*/": ").$out((LangOpts.ShortWChar ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"member-pointer representation method").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getMSPointerToMemberRepresentationMethod().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"default calling convention").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getDefaultCallingConv().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"short enum types").$out(/*KEEP_STR*/": ").$out((LangOpts.ShortEnums ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"OpenCL").$out(/*KEEP_STR*/": ").$out((LangOpts.OpenCL ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"OpenCL version").$out(/*KEEP_STR*/": ").$out(((LangOpts.OpenCLVersion != 0) ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Native half type support").$out(/*KEEP_STR*/": ").$out((LangOpts.NativeHalfType ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Native half args and returns").$out(/*KEEP_STR*/": ").$out((LangOpts.NativeHalfArgsAndReturns ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"half args and returns").$out(/*KEEP_STR*/": ").$out((LangOpts.HalfArgsAndReturns ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"CUDA").$out(/*KEEP_STR*/": ").$out((LangOpts.CUDA ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"OpenMP support and version of OpenMP (31, 40 or 45)").$out(/*KEEP_STR*/": ").$out(((LangOpts.OpenMP != 0) ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Use TLS for threadprivates or runtime calls").$out(/*KEEP_STR*/": ").$out((LangOpts.OpenMPUseTLS ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Generate code only for OpenMP target device").$out(/*KEEP_STR*/": ").$out((LangOpts.OpenMPIsDevice ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"RenderScript").$out(/*KEEP_STR*/": ").$out((LangOpts.RenderScript ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"compiling for CUDA device").$out(/*KEEP_STR*/": ").$out((LangOpts.CUDAIsDevice ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"allowing variadic functions in CUDA device code").$out(/*KEEP_STR*/": ").$out((LangOpts.CUDAAllowVariadicFunctions ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"treating unattributed constexpr functions as __host__ __device__").$out(/*KEEP_STR*/": ").$out((LangOpts.CUDAHostDeviceConstexpr ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"flushing denormals to zero").$out(/*KEEP_STR*/": ").$out((LangOpts.CUDADeviceFlushDenormalsToZero ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"using approximate transcendental functions").$out(/*KEEP_STR*/": ").$out((LangOpts.CUDADeviceApproxTranscendentals ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"enable sized deallocation functions").$out(/*KEEP_STR*/": ").$out((LangOpts.SizedDeallocation ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"enable C++ Extensions for Concepts").$out(/*KEEP_STR*/": ").$out((LangOpts.ConceptsTS ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"no constant CoreFoundation strings").$out(/*KEEP_STR*/": ").$out((LangOpts.NoConstantCFStrings ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"treating double-precision floating point constants as single precision constants").$out(/*KEEP_STR*/": ").$out((LangOpts.SinglePrecisionConstants ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"OpenCL fast relaxed math").$out(/*KEEP_STR*/": ").$out((LangOpts.FastRelaxedMath ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"FP_CONTRACT").$out(/*KEEP_STR*/": ").$out((LangOpts.DefaultFPContract ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"bit-field type alignment").$out(/*KEEP_STR*/": ").$out((LangOpts.NoBitFieldTypeAlign ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"hexagon-qdsp6 backward compatibility").$out(/*KEEP_STR*/": ").$out((LangOpts.HexagonQdsp6Compat ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C automated reference counting").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjCAutoRefCount ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"__weak support in the ARC runtime").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjCWeakRuntime ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C __weak in ARC and MRC files").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjCWeak ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Subscripting support in legacy ObjectiveC runtime").$out(/*KEEP_STR*/": ").$out((LangOpts.ObjCSubscriptingLegacyRuntime ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"OpenCL fake address space map").$out(/*KEEP_STR*/": ").$out((LangOpts.FakeAddressSpaceMap ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"OpenCL address space map mangling mode").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getAddressSpaceMapMangling().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Include default header file for OpenCL").$out(/*KEEP_STR*/": ").$out((LangOpts.IncludeDefaultHeader ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"optional blocks runtime").$out(/*KEEP_STR*/": ").$out((LangOpts.BlocksRuntimeOptional ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Objective-C Garbage Collection mode").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getGC().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"value symbol visibility").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getValueVisibilityMode().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"type symbol visibility").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getTypeVisibilityMode().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"stack protector mode").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getStackProtector().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"signed integer overflow handling").$out(/*KEEP_STR*/": ").$out_uint(((/*static_cast*//*uint*/int)(LangOpts.getSignedOverflowBehavior().getValue()))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Microsoft Visual C/C++ Version").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.MSCompatibilityVersion).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"How many vtordisps to insert").$out(/*KEEP_STR*/": ").$out_uint(LangOpts.VtorDispMode).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Apple gcc-compatible #pragma pack handling").$out(/*KEEP_STR*/": ").$out((LangOpts.ApplePragmaPack ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"retain documentation comments from system headers in the AST").$out(/*KEEP_STR*/": ").$out((LangOpts.RetainCommentsFromSystemHeaders ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"controls how aggressive is ASan field padding (0: none, 1:least aggressive, 2: more aggressive)").$out(/*KEEP_STR*/": ").$out(((LangOpts.SanitizeAddressFieldPadding != 0) ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    if (!LangOpts.ModuleFeatures.empty()) {
      Out.indent(4).$out(/*KEEP_STR*/"Module features:\n");
      for (string Feature : LangOpts.ModuleFeatures)  {
        Out.indent(6).$out(/*NO_COPY*/Feature).$out(/*KEEP_STR*/$LF);
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 503,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 498,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadTargetOptions", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener17ReadTargetOptionsERKN5clang13TargetOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener17ReadTargetOptionsERKN5clang13TargetOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadTargetOptions(/*const*/ TargetOptions /*&*/ TargetOpts, boolean Complain, 
                   boolean AllowCompatibleDifferences)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Target options:\n");
    Out.indent(4).$out(/*KEEP_STR*/"  Triple: ").$out(TargetOpts.Triple).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"  CPU: ").$out(TargetOpts.CPU).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"  ABI: ").$out(TargetOpts.ABI).$out(/*KEEP_STR*/$LF);
    if (!TargetOpts.FeaturesAsWritten.empty()) {
      Out.indent(4).$out(/*KEEP_STR*/"Target features:\n");
      for (/*uint*/int I = 0, N = TargetOpts.FeaturesAsWritten.size();
           I != N; ++I) {
        Out.indent(6).$out(TargetOpts.FeaturesAsWritten.$at$Const(I)).$out(/*KEEP_STR*/$LF);
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadDiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 521,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 516,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadDiagnosticOptions", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrIN5clang17DiagnosticOptionsEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrIN5clang17DiagnosticOptionsEEEb")
  //</editor-fold>
  @Override public boolean ReadDiagnosticOptions(IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts, 
                       boolean Complain)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Diagnostic options:\n");
    Out.indent(4).$out(/*KEEP_STR*/"IgnoreWarnings").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().IgnoreWarnings ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// -w
    Out.indent(4).$out(/*KEEP_STR*/"NoRewriteMacros").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().NoRewriteMacros ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// -Wno-rewrite-macros
    Out.indent(4).$out(/*KEEP_STR*/"Pedantic").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().Pedantic ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// -pedantic
    Out.indent(4).$out(/*KEEP_STR*/"PedanticErrors").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().PedanticErrors ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// -pedantic-errors
    Out.indent(4).$out(/*KEEP_STR*/"ShowColumn").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowColumn ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show column number on diagnostics.
    Out.indent(4).$out(/*KEEP_STR*/"ShowLocation").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowLocation ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show source location information.
    Out.indent(4).$out(/*KEEP_STR*/"ShowCarets").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowCarets ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show carets in diagnostics.
    Out.indent(4).$out(/*KEEP_STR*/"ShowFixits").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowFixits ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show fixit information.
    Out.indent(4).$out(/*KEEP_STR*/"ShowSourceRanges").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowSourceRanges ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show source ranges in numeric form.
    Out.indent(4).$out(/*KEEP_STR*/"ShowParseableFixits").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowParseableFixits ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show machine parseable fix-its.
    Out.indent(4).$out(/*KEEP_STR*/"ShowPresumedLoc").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowPresumedLoc ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show presumed location for diagnostics.
    Out.indent(4).$out(/*KEEP_STR*/"ShowOptionNames").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowOptionNames ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show the option name for mappable
    /// diagnostics.
    Out.indent(4).$out(/*KEEP_STR*/"ShowNoteIncludeStack").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowNoteIncludeStack ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show include stacks for notes.
    Out.indent(4).$out(/*KEEP_STR*/"ShowCategories").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().ShowCategories).$out(/*KEEP_STR*/$LF); /// Show categories: 0 -> none, 1 -> Number,
    /// 2 -> Full Name.
    Out.indent(4).$out(/*KEEP_STR*/"Format").$out(/*KEEP_STR*/": ").$out_int(DiagOpts.$arrow().getFormat().getValue()).$out(/*KEEP_STR*/$LF); /// Format for diagnostics: 
    Out.indent(4).$out(/*KEEP_STR*/"ShowColors").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowColors ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Show diagnostics with ANSI color sequences.
    Out.indent(4).$out(/*KEEP_STR*/"ShowOverloads").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().getShowOverloads().getValue()).$out(/*KEEP_STR*/$LF); /// Overload candidates to show.
    Out.indent(4).$out(/*KEEP_STR*/"VerifyDiagnostics").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().VerifyDiagnostics ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Check that diagnostics match the expected
    /// diagnostics, indicated by markers in the
    /// input source file.
    $out_raw_ostream_DiagnosticLevelMask(Out.indent(4).$out(/*KEEP_STR*/"VerifyIgnoreUnexpected").$out(/*KEEP_STR*/": "), DiagOpts.$arrow().getVerifyIgnoreUnexpected()).$out(/*KEEP_STR*/$LF); /// Ignore unexpected diagnostics of
    /// the specified levels when using
    /// -verify.
    Out.indent(4).$out(/*KEEP_STR*/"ElideType").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ElideType ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Elide identical types in template diffing
    Out.indent(4).$out(/*KEEP_STR*/"ShowTemplateTree").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().ShowTemplateTree ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Print a template tree when diffing
    Out.indent(4).$out(/*KEEP_STR*/"CLFallbackMode").$out(/*KEEP_STR*/": ").$out((DiagOpts.$arrow().CLFallbackMode ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF); /// Format for clang-cl fallback mode
    Out.indent(4).$out(/*KEEP_STR*/"ErrorLimit").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().ErrorLimit).$out(/*KEEP_STR*/$LF); /// Limit # errors emitted.
    /// Limit depth of macro expansion backtrace.
    Out.indent(4).$out(/*KEEP_STR*/"MacroBacktraceLimit").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().MacroBacktraceLimit).$out(/*KEEP_STR*/$LF);
    /// Limit depth of instantiation backtrace.
    Out.indent(4).$out(/*KEEP_STR*/"TemplateBacktraceLimit").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().TemplateBacktraceLimit).$out(/*KEEP_STR*/$LF);
    /// Limit depth of constexpr backtrace.
    Out.indent(4).$out(/*KEEP_STR*/"ConstexprBacktraceLimit").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().ConstexprBacktraceLimit).$out(/*KEEP_STR*/$LF);
    /// Limit number of times to perform spell checking.
    Out.indent(4).$out(/*KEEP_STR*/"SpellCheckingLimit").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().SpellCheckingLimit).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"TabStop").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().TabStop).$out(/*KEEP_STR*/$LF); /// The distance between tab stops.
    /// Column limit for formatting message diagnostics, or 0 if unused.
    Out.indent(4).$out(/*KEEP_STR*/"MessageLength").$out(/*KEEP_STR*/": ").$out_uint(DiagOpts.$arrow().MessageLength).$out(/*KEEP_STR*/$LF);
    
    Out.indent(4).$out(/*KEEP_STR*/"Diagnostic flags:\n");
    for (/*const*/std.string/*&*/ Warning : DiagOpts.$arrow().Warnings)  {
      Out.indent(6).$out(/*KEEP_STR*/"-W").$out(Warning).$out(/*KEEP_STR*/$LF);
    }
    for (/*const*/std.string/*&*/ Remark : DiagOpts.$arrow().Remarks)  {
      Out.indent(6).$out(/*KEEP_STR*/"-R").$out(Remark).$out(/*KEEP_STR*/$LF);
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadHeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 540,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 535,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadHeaderSearchOptions", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener23ReadHeaderSearchOptionsERKN5clang19HeaderSearchOptionsEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener23ReadHeaderSearchOptionsERKN5clang19HeaderSearchOptionsEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public boolean ReadHeaderSearchOptions(/*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                         StringRef SpecificModuleCachePath, 
                         boolean Complain)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Header search options:\n");
    Out.indent(4).$out(/*KEEP_STR*/"System root [-isysroot=]: '").$out(HSOpts.Sysroot).$out(/*KEEP_STR*/"'\n");
    Out.indent(4).$out(/*KEEP_STR*/"Module Cache: '").$out(/*NO_COPY*/SpecificModuleCachePath).$out(/*KEEP_STR*/"'\n");
    Out.indent(4).$out(/*KEEP_STR*/"Use builtin include directories [-nobuiltininc]").$out(/*KEEP_STR*/": ").$out((HSOpts.UseBuiltinIncludes ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Use standard system include directories [-nostdinc]").$out(/*KEEP_STR*/": ").$out((HSOpts.UseStandardSystemIncludes ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Use standard C++ include directories [-nostdinc++]").$out(/*KEEP_STR*/": ").$out((HSOpts.UseStandardCXXIncludes ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Use libc++ (rather than libstdc++) [-stdlib=]").$out(/*KEEP_STR*/": ").$out((HSOpts.UseLibcxx ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::ReadPreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 557,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 552,
   FQN="(anonymous namespace)::DumpModuleInfoListener::ReadPreprocessorOptions", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener23ReadPreprocessorOptionsERKN5clang19PreprocessorOptionsEbRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener23ReadPreprocessorOptionsERKN5clang19PreprocessorOptionsEbRSs")
  //</editor-fold>
  @Override public boolean ReadPreprocessorOptions(/*const*/ PreprocessorOptions /*&*/ PPOpts, 
                         boolean Complain, 
                         std.string/*&*/ SuggestedPredefines)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Preprocessor options:\n");
    Out.indent(4).$out(/*KEEP_STR*/"Uses compiler/target-specific predefines [-undef]").$out(/*KEEP_STR*/": ").$out((PPOpts.UsePredefines ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    Out.indent(4).$out(/*KEEP_STR*/"Uses detailed preprocessing record (for indexing)").$out(/*KEEP_STR*/": ").$out((PPOpts.DetailedRecord ? $("Yes") : $("No"))).$out(/*KEEP_STR*/$LF);
    if (!PPOpts.Macros.empty()) {
      Out.indent(4).$out(/*KEEP_STR*/"Predefined macros:\n");
    }
    
    for (std.vector.iterator<pairTypeBool<string>> I = PPOpts./*isUndef*/
        Macros.begin$Const(), IEnd = PPOpts.Macros.end$Const();
         $noteq___normal_iterator$C(I, IEnd); I.$preInc()) {
      Out.indent(6);
      if (I.$arrow().second) {
        Out.$out(/*KEEP_STR*/"-U");
      } else {
        Out.$out(/*KEEP_STR*/"-D");
      }
      Out.$out(I.$arrow().first).$out(/*KEEP_STR*/$LF);
    }
    return false;
  }

  
  /// Indicates that a particular module file extension has been read.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::readModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 584,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 579,
   FQN="(anonymous namespace)::DumpModuleInfoListener::readModuleFileExtension", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListener23readModuleFileExtensionERKN5clang27ModuleFileExtensionMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListener23readModuleFileExtensionERKN5clang27ModuleFileExtensionMetadataE")
  //</editor-fold>
  @Override public void readModuleFileExtension(/*const*/ ModuleFileExtensionMetadata /*&*/ Metadata)/* override*/ {
    Out.indent(2).$out(/*KEEP_STR*/"Module file extension '").$out(
        Metadata.BlockName
    ).$out(/*KEEP_STR*/"' ").$out_uint(Metadata.MajorVersion).$out(
        /*KEEP_STR*/$DOT
    ).$out_uint(Metadata.MinorVersion);
    if (!Metadata.UserInfo.empty()) {
      Out.$out(/*KEEP_STR*/": ");
      Out.write_escaped(new StringRef(Metadata.UserInfo));
    }
    
    Out.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DumpModuleInfoListener::~DumpModuleInfoListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 455,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 450,
   FQN="(anonymous namespace)::DumpModuleInfoListener::~DumpModuleInfoListener", NM="_ZN12_GLOBAL__N_122DumpModuleInfoListenerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_122DumpModuleInfoListenerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + super.toString(); // NOI18N
  }
}
