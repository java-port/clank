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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.basic.target.TargetOptions;
import static org.llvm.bitcode.BitcodeLlvmGlobals.*;
import static org.llvm.pass.IrLlvmGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type BackendUtilClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.BackendUtilClangGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN5clang12EmbedBitcodeEPN4llvm6ModuleERKNS_14CodeGenOptionsENS0_15MemoryBufferRefE;_ZN5clang17EmitBackendOutputERNS_17DiagnosticsEngineERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsERKN4llvm10DataLayoutEPNSB_6ModuleENS_13BackendActionESt10unique_ptrINSB_17raw_pwrite_streamESt14default_deleteISJ_EE; -static-type=BackendUtilClangGlobals -package=org.clang.codegen.impl")
//</editor-fold>
public final class BackendUtilClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::EmitBackendOutput">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 743,
 FQN="clang::EmitBackendOutput", NM="_ZN5clang17EmitBackendOutputERNS_17DiagnosticsEngineERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsERKN4llvm10DataLayoutEPNSB_6ModuleENS_13BackendActionESt10unique_ptrINSB_17raw_pwrite_streamESt14default_deleteISJ_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN5clang17EmitBackendOutputERNS_17DiagnosticsEngineERKNS_14CodeGenOptionsERKNS_13TargetOptionsERKNS_11LangOptionsERKN4llvm10DataLayoutEPNSB_6ModuleENS_13BackendActionESt10unique_ptrINSB_17raw_pwrite_streamESt14default_deleteISJ_EE")
//</editor-fold>
public static void EmitBackendOutput(final DiagnosticsEngine /*&*/ Diags, 
                 final /*const*/ CodeGenOptions /*&*/ CGOpts, 
                 final /*const*/ TargetOptions /*&*/ TOpts, 
                 final /*const*/ LangOptions /*&*/ LOpts, final /*const*/ DataLayout /*&*/ TDesc, 
                 org.llvm.ir.Module /*P*/ M, BackendAction Action, 
                 std.unique_ptr<raw_pwrite_stream> OS) {
  EmitAssemblyHelper AsmHelper = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    AsmHelper/*J*/= new EmitAssemblyHelper(Diags, CGOpts, TOpts, LOpts, M);
    
    AsmHelper.EmitAssembly(Action, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS)))); $c$.clean();
    
    // Verify clang's TargetInfo DataLayout against the LLVM TargetMachine's
    // DataLayout.
    if (AsmHelper.TM.$bool()) {
      std.string DLDesc = new std.string(M.getDataLayout().getStringRepresentation());
      if ($noteq_string$C(DLDesc, TDesc.getStringRepresentation())) {
        /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, /*KEEP_STR*/"backend data layout '%0' does not match expected target description '%1'");
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(DiagID)), new StringRef(DLDesc)), new StringRef(TDesc.getStringRepresentation())));
      }
    }
  } finally {
    if (AsmHelper != null) { AsmHelper.$destroy(); }
    $c$.$destroy();
  }
}


// With -fembed-bitcode, save a copy of the llvm IR as data in the
// __LLVM,__bitcode section.
//<editor-fold defaultstate="collapsed" desc="clang::EmbedBitcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 792,
 FQN="clang::EmbedBitcode", NM="_ZN5clang12EmbedBitcodeEPN4llvm6ModuleERKNS_14CodeGenOptionsENS0_15MemoryBufferRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN5clang12EmbedBitcodeEPN4llvm6ModuleERKNS_14CodeGenOptionsENS0_15MemoryBufferRefE")
//</editor-fold>
public static void EmbedBitcode(org.llvm.ir.Module /*P*/ M, final /*const*/ CodeGenOptions /*&*/ CGOpts, 
            MemoryBufferRef Buf) {
  SmallSetT$PLess$T$P<GlobalValue /*P*/ > UsedGlobals = null;
  try {
    if (CGOpts.getEmbedBitcode() == CodeGenOptions.EmbedBitcodeKind.Embed_Off) {
      return;
    }
    
    // Save llvm.compiler.used and remote it.
    SmallVector<Constant /*P*/ > UsedArray/*J*/= new SmallVector<Constant /*P*/ >(2, (Constant /*P*/ )null);
    UsedGlobals/*J*/= new SmallSetT$PLess$T$P<GlobalValue /*P*/ >(4);
    org.llvm.ir.Type /*P*/ UsedElementType = org.llvm.ir.Type.getInt8Ty(M.getContext()).getPointerTo(0);
    GlobalVariable /*P*/ Used = collectUsedGlobalVariables($Deref(M), UsedGlobals, true);
    for (GlobalValue /*P*/ GV : UsedGlobals) {
      if ($noteq_StringRef(GV.getName(), /*STRINGREF_STR*/"llvm.embedded.module")
         && $noteq_StringRef(GV.getName(), /*STRINGREF_STR*/"llvm.cmdline")) {
        UsedArray.push_back(ConstantExpr.getPointerBitCastOrAddrSpaceCast(GV, UsedElementType));
      }
    }
    if ((Used != null)) {
      Used.eraseFromParent();
    }
    
    // Embed the bitcode for the llvm module.
    std.string Data/*J*/= new std.string();
    ArrayRefUChar ModuleData/*J*/= new ArrayRefUChar();
    Triple T/*J*/= new Triple(new Twine(M.getTargetTriple()));
    // Create a constant that contains the bitcode.
    // In case of embedding a marker, ignore the input Buf and use the empty
    // ArrayRef. It is also legal to create a bitcode marker even Buf is empty.
    if (CGOpts.getEmbedBitcode() != CodeGenOptions.EmbedBitcodeKind.Embed_Marker) {
      if (!isBitcode(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buf.getBufferStart()), 
          reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buf.getBufferEnd()))) {
        raw_string_ostream OS = null;
        try {
          // If the input is LLVM Assembly, bitcode is produced by serializing
          // the module. Use-lists order need to be perserved in this case.
          OS/*J*/= new raw_string_ostream(Data);
          WriteBitcodeToFile(M, OS, /* ShouldPreserveUseListOrder */ true);
          ModuleData.$assignMove(
              new ArrayRefUChar(OS.str().data().$array(), OS.str().size())
          );
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      } else {
        // If the input is LLVM bitcode, write the input byte stream directly.
        ModuleData.$assignMove(new ArrayRefUChar(Buf.getBufferStart().$array(), 
                Buf.getBufferSize()));
      }
    }
    Constant /*P*/ ModuleConstant = ConstantDataArray.get_LLVMContext_ArrayRefUChar(M.getContext(), new ArrayRefUChar(ModuleData));
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($Deref(M), ModuleConstant.getType(), true, GlobalValue.LinkageTypes.PrivateLinkage, 
        ModuleConstant);
     });
    GV.setSection(new StringRef(BackendUtilStatics.getSectionNameForBitcode(T)));
    UsedArray.push_back(ConstantExpr.getPointerBitCastOrAddrSpaceCast(GV, UsedElementType));
    {
      GlobalVariable /*P*/ Old = M.getGlobalVariable(new StringRef(/*KEEP_STR*/"llvm.embedded.module"), true);
      if ((Old != null)) {
        assert (Old.hasOneUse()) : "llvm.embedded.module can only be used once in llvm.compiler.used";
        GV.takeName(Old);
        Old.eraseFromParent();
      } else {
        GV.setName(new Twine(/*KEEP_STR*/"llvm.embedded.module"));
      }
    }
    
    // Skip if only bitcode needs to be embedded.
    if (CGOpts.getEmbedBitcode() != CodeGenOptions.EmbedBitcodeKind.Embed_Bitcode) {
      // Embed command-line options.
      ArrayRefUChar CmdData/*J*/= new ArrayRefUChar(CGOpts.CmdArgs.data(), 
          CGOpts.CmdArgs.size());
      Constant /*P*/ CmdConstant = ConstantDataArray.get_LLVMContext_ArrayRefUChar(M.getContext(), new ArrayRefUChar(CmdData));
      GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable($Deref(M), CmdConstant.getType(), true, 
          GlobalValue.LinkageTypes.PrivateLinkage, 
          CmdConstant);
       });
      GV.setSection(new StringRef(BackendUtilStatics.getSectionNameForCommandline(T)));
      UsedArray.push_back(ConstantExpr.getPointerBitCastOrAddrSpaceCast(GV, UsedElementType));
      {
        GlobalVariable /*P*/ Old = M.getGlobalVariable(new StringRef(/*KEEP_STR*/"llvm.cmdline"), true);
        if ((Old != null)) {
          assert (Old.hasOneUse()) : "llvm.cmdline can only be used once in llvm.compiler.used";
          GV.takeName(Old);
          Old.eraseFromParent();
        } else {
          GV.setName(new Twine(/*KEEP_STR*/"llvm.cmdline"));
        }
      }
    }
    if (UsedArray.empty()) {
      return;
    }
    
    // Recreate llvm.compiler.used.
    org.llvm.ir.ArrayType /*P*/ ATy = org.llvm.ir.ArrayType.get(UsedElementType, $uint2ulong(UsedArray.size()));
    GlobalVariable /*P*/ NewUsed = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($Deref(M), ATy, false, GlobalValue.LinkageTypes.AppendingLinkage, 
        ConstantArray.get(ATy, new ArrayRef<Constant /*P*/ >(UsedArray, true)), new Twine(/*KEEP_STR*/"llvm.compiler.used"));
     });
    NewUsed.setSection(new StringRef(/*KEEP_STR*/"llvm.metadata"));
  } finally {
    if (UsedGlobals != null) { UsedGlobals.$destroy(); }
  }
}

} // END OF class BackendUtilClangGlobals
