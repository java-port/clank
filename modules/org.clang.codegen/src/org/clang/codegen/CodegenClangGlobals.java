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
package org.clang.codegen;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.clang.codegen.*;
import org.clang.codegen.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.basic.target.TargetOptions;


//<editor-fold defaultstate="collapsed" desc="static type CodegenClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodegenClangGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang12EmbedBitcodeEPN4llvm6ModuleERKNS_14CodeGenOptionsENS0_15MemoryBufferRefE;_ZN5clang17CreateLLVMCodeGenERNS_17DiagnosticsEngineEN4llvm9StringRefERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERNS2_11LLVMContextEPNS_18CoverageSourceInfoE;_ZN5clang17EmitBackendOutputERNS_17DiagnosticsEngineERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsERKN4llvm10DataLayoutEPNSB_6ModuleENS_13BackendActionESt10unique_ptrINSB_17raw_pwrite_streamESt14default_deleteISJ_EE; -static-type=CodegenClangGlobals -package=org.clang.codegen")
//</editor-fold>
public final class CodegenClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::EmitBackendOutput">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 743,
 FQN="clang::EmitBackendOutput", NM="_ZN5clang17EmitBackendOutputERNS_17DiagnosticsEngineERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsERKN4llvm10DataLayoutEPNSB_6ModuleENS_13BackendActionESt10unique_ptrINSB_17raw_pwrite_streamESt14default_deleteISJ_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN5clang17EmitBackendOutputERNS_17DiagnosticsEngineERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsERKN4llvm10DataLayoutEPNSB_6ModuleENS_13BackendActionESt10unique_ptrINSB_17raw_pwrite_streamESt14default_deleteISJ_EE")
//</editor-fold>
public static void EmitBackendOutput(final DiagnosticsEngine /*&*/ Diags, 
                 final /*const*/ CodeGenOptions /*&*/ CGOpts, 
                 final /*const*/ TargetOptions /*&*/ TOpts, 
                 final /*const*/ LangOptions /*&*/ LOpts, final /*const*/ DataLayout /*&*/ TDesc, 
                 org.llvm.ir.Module /*P*/ M, BackendAction Action, 
                 std.unique_ptr<raw_pwrite_stream> OS) {
  /*delegate*/org.clang.codegen.impl.BackendUtilClangGlobals.
    EmitBackendOutput(Diags, 
                 CGOpts, 
                 TOpts, 
                 LOpts, TDesc, 
                 M, Action, 
                 OS);
}


// With -fembed-bitcode, save a copy of the llvm IR as data in the
// __LLVM,__bitcode section.
//<editor-fold defaultstate="collapsed" desc="clang::EmbedBitcode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 792,
 FQN="clang::EmbedBitcode", NM="_ZN5clang12EmbedBitcodeEPN4llvm6ModuleERKNS_14CodeGenOptionsENS0_15MemoryBufferRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN5clang12EmbedBitcodeEPN4llvm6ModuleERKNS_14CodeGenOptionsENS0_15MemoryBufferRefE")
//</editor-fold>
public static void EmbedBitcode(org.llvm.ir.Module /*P*/ M, final /*const*/ CodeGenOptions /*&*/ CGOpts, 
            MemoryBufferRef Buf) {
  /*delegate*/org.clang.codegen.impl.BackendUtilClangGlobals.
    EmbedBitcode(M, CGOpts, 
            Buf);
}


/// CreateLLVMCodeGen - Create a CodeGenerator instance.
/// It is the responsibility of the caller to call delete on
/// the allocated CodeGenerator instance.
//<editor-fold defaultstate="collapsed" desc="clang::CreateLLVMCodeGen">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 312,
 FQN="clang::CreateLLVMCodeGen", NM="_ZN5clang17CreateLLVMCodeGenERNS_17DiagnosticsEngineEN4llvm9StringRefERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERNS2_11LLVMContextEPNS_18CoverageSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang17CreateLLVMCodeGenERNS_17DiagnosticsEngineEN4llvm9StringRefERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERNS2_11LLVMContextEPNS_18CoverageSourceInfoE")
//</editor-fold>
public static CodeGenerator /*P*/ CreateLLVMCodeGen(final DiagnosticsEngine /*&*/ Diags, StringRef ModuleName, 
                 final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts, 
                 final /*const*/ PreprocessorOptions /*&*/ PreprocessorOpts, final /*const*/ CodeGenOptions /*&*/ CGO, 
                 final LLVMContext /*&*/ C) {
  return CreateLLVMCodeGen(Diags, ModuleName, 
                 HeaderSearchOpts, 
                 PreprocessorOpts, CGO, 
                 C, (CoverageSourceInfo /*P*/ )null);
}
public static CodeGenerator /*P*/ CreateLLVMCodeGen(final DiagnosticsEngine /*&*/ Diags, StringRef ModuleName, 
                 final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts, 
                 final /*const*/ PreprocessorOptions /*&*/ PreprocessorOpts, final /*const*/ CodeGenOptions /*&*/ CGO, 
                 final LLVMContext /*&*/ C, CoverageSourceInfo /*P*/ CoverageInfo/*= null*/) {
  return /*delegate*/org.clang.codegen.impl.ModuleBuilderClangGlobals.
    CreateLLVMCodeGen(Diags, ModuleName, 
                 HeaderSearchOpts, 
                 PreprocessorOpts, CGO, 
                 C, CoverageInfo);
}

} // END OF class CodegenClangGlobals
