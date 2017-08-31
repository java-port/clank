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
package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import static org.clank.support.Native.$Deref;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_TargetInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CodeGenTypes ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getTargetCodeGenInfoEv;_ZNK5clang7CodeGen13CodeGenModule14supportsCOMDATEv;_ZNK5clang7CodeGen13CodeGenModule9getTripleEv; -static-type=CodeGenModule_TargetInfo -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_TargetInfo extends CodeGenModule_CodeGenTypes {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


//===----------------------------------------------------------------------===//
// Driver code
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7885,
 FQN="clang::CodeGen::CodeGenModule::getTriple", NM="_ZNK5clang7CodeGen13CodeGenModule9getTripleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule9getTripleEv")
//</editor-fold>
public final /*const*/ Triple /*&*/ getTriple() /*const*/ {
  return $this().getTarget().getTriple();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::supportsCOMDAT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7889,
 FQN="clang::CodeGen::CodeGenModule::supportsCOMDAT", NM="_ZNK5clang7CodeGen13CodeGenModule14supportsCOMDATEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule14supportsCOMDATEv")
//</editor-fold>
public final boolean supportsCOMDAT() /*const*/ {
  return $this().getTriple().supportsCOMDAT();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTargetCodeGenInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*getTargetCodeGenInfo is called from ctr of CodeGenTypes*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7893,
 FQN="clang::CodeGen::CodeGenModule::getTargetCodeGenInfo", NM="_ZN5clang7CodeGen13CodeGenModule20getTargetCodeGenInfoEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getTargetCodeGenInfoEv")
//</editor-fold>
public final /*const*/ TargetCodeGenInfo /*&*/ getTargetCodeGenInfo() {
  return getTargetCodeGenInfo($this().Types);
}
/*for CodeGenTypes ctr*/final /*const*/ TargetCodeGenInfo /*&*/ getTargetCodeGenInfo(final CodeGenTypes This$Types) {
  assert $this().Types == null || $this().Types == This$Types;
  if ($this().TheTargetCodeGenInfo.$bool()) {
    return $this().TheTargetCodeGenInfo.$star();
  }
  
  // Helper to set the unique_ptr while still keeping the return value.
  TargetCodeGenInfo2TargetCodeGenInfo SetCGInfo = /*[&, this]*/ (TargetCodeGenInfo /*P*/ P) -> {
        $this().TheTargetCodeGenInfo.reset(P);
        return $Deref(P);
      };
  
  final /*const*/ Triple /*&*/ $Triple = $this().getTarget().getTriple();
  switch ($Triple.getArch()) {
   default:
    return SetCGInfo.$call(new DefaultTargetCodeGenInfo(This$Types));
   case le32:
    return SetCGInfo.$call(new PNaClTargetCodeGenInfo(This$Types));
   case mips:
   case mipsel:
    if ($Triple.getOS() == Triple.OSType.NaCl) {
      return SetCGInfo.$call(new PNaClTargetCodeGenInfo(This$Types));
    }
    return SetCGInfo.$call(new MIPSTargetCodeGenInfo(This$Types, true));
   case mips64:
   case mips64el:
    return SetCGInfo.$call(new MIPSTargetCodeGenInfo(This$Types, false));
   case aarch64:
   case aarch64_be:
    {
      AArch64ABIInfo.ABIKind Kind = AArch64ABIInfo.ABIKind.AAPCS;
      if ($eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"darwinpcs")) {
        Kind = AArch64ABIInfo.ABIKind.DarwinPCS;
      }
      
      return SetCGInfo.$call(new AArch64TargetCodeGenInfo(This$Types, Kind));
    }
   case wasm32:
   case wasm64:
    return SetCGInfo.$call(new WebAssemblyTargetCodeGenInfo(This$Types));
   case arm:
   case armeb:
   case thumb:
   case thumbeb:
    {
      if ($Triple.getOS() == Triple.OSType.Win32) {
        return SetCGInfo.$call(
            new WindowsARMTargetCodeGenInfo(This$Types, ARMABIInfo.ABIKind.AAPCS_VFP)
        );
      }
      
      ARMABIInfo.ABIKind Kind = ARMABIInfo.ABIKind.AAPCS;
      StringRef ABIStr = $this().getTarget().getABI();
      if ($eq_StringRef(/*NO_COPY*/ABIStr, /*STRINGREF_STR*/"apcs-gnu")) {
        Kind = ARMABIInfo.ABIKind.APCS;
      } else if ($eq_StringRef(/*NO_COPY*/ABIStr, /*STRINGREF_STR*/"aapcs16")) {
        Kind = ARMABIInfo.ABIKind.AAPCS16_VFP;
      } else if ($eq_string$C_T$C$P($this().CodeGenOpts.FloatABI, /*KEEP_STR*/"hard")
         || ($noteq_string$C_T$C$P($this().CodeGenOpts.FloatABI, /*KEEP_STR*/"soft")
         && ($Triple.getEnvironment() == Triple.EnvironmentType.GNUEABIHF
         || $Triple.getEnvironment() == Triple.EnvironmentType.MuslEABIHF
         || $Triple.getEnvironment() == Triple.EnvironmentType.EABIHF))) {
        Kind = ARMABIInfo.ABIKind.AAPCS_VFP;
      }
      
      return SetCGInfo.$call(new ARMTargetCodeGenInfo(This$Types, Kind));
    }
   case ppc:
    return SetCGInfo.$call(
        new PPC32TargetCodeGenInfo(This$Types, $eq_string$C_T$C$P($this().CodeGenOpts.FloatABI, /*KEEP_STR*/"soft"))
    );
   case ppc64:
    if ($Triple.isOSBinFormatELF()) {
      PPC64_SVR4_ABIInfo.ABIKind Kind = PPC64_SVR4_ABIInfo.ABIKind.ELFv1;
      if ($eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"elfv2")) {
        Kind = PPC64_SVR4_ABIInfo.ABIKind.ELFv2;
      }
      boolean HasQPX = $eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"elfv1-qpx");
      
      return SetCGInfo.$call(new PPC64_SVR4_TargetCodeGenInfo(This$Types, Kind, HasQPX));
    } else {
      return SetCGInfo.$call(new PPC64TargetCodeGenInfo(This$Types));
    }
   case ppc64le:
    {
      assert ($Triple.isOSBinFormatELF()) : "PPC64 LE non-ELF not supported!";
      PPC64_SVR4_ABIInfo.ABIKind Kind = PPC64_SVR4_ABIInfo.ABIKind.ELFv2;
      if ($eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"elfv1") || $eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"elfv1-qpx")) {
        Kind = PPC64_SVR4_ABIInfo.ABIKind.ELFv1;
      }
      boolean HasQPX = $eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"elfv1-qpx");
      
      return SetCGInfo.$call(new PPC64_SVR4_TargetCodeGenInfo(This$Types, Kind, HasQPX));
    }
   case nvptx:
   case nvptx64:
    return SetCGInfo.$call(new NVPTXTargetCodeGenInfo(This$Types));
   case msp430:
    return SetCGInfo.$call(new MSP430TargetCodeGenInfo(This$Types));
   case systemz:
    {
      boolean HasVector = $eq_StringRef($this().getTarget().getABI(), /*STRINGREF_STR*/"vector");
      return SetCGInfo.$call(new SystemZTargetCodeGenInfo(This$Types, HasVector));
    }
   case tce:
    return SetCGInfo.$call(new TCETargetCodeGenInfo(This$Types));
   case x86:
    {
      boolean IsDarwinVectorABI = $Triple.isOSDarwin();
      boolean RetSmallStructInRegABI = X86_32TargetCodeGenInfo.isStructReturnInRegABI($Triple, $this().CodeGenOpts);
      boolean IsWin32FloatStructABI = $Triple.isOSWindows() && !$Triple.isOSCygMing();
      if ($Triple.getOS() == Triple.OSType.Win32) {
        return SetCGInfo.$call(new WinX86_32TargetCodeGenInfo(This$Types, IsDarwinVectorABI, RetSmallStructInRegABI, 
                IsWin32FloatStructABI, $this().CodeGenOpts.NumRegisterParameters));
      } else {
        return SetCGInfo.$call(new X86_32TargetCodeGenInfo(This$Types, IsDarwinVectorABI, RetSmallStructInRegABI, 
                IsWin32FloatStructABI, $this().CodeGenOpts.NumRegisterParameters, 
                $eq_string$C_T$C$P($this().CodeGenOpts.FloatABI, /*KEEP_STR*/"soft")));
      }
    }
   case x86_64:
    {
      StringRef ABI = $this().getTarget().getABI();
      X86AVXABILevel AVXLevel = ($eq_StringRef(/*NO_COPY*/ABI, /*STRINGREF_STR*/"avx512") ? X86AVXABILevel.AVX512 : $eq_StringRef(/*NO_COPY*/ABI, /*STRINGREF_STR*/"avx") ? X86AVXABILevel.AVX : X86AVXABILevel.None);
      switch ($Triple.getOS()) {
       case Win32:
        return SetCGInfo.$call(new WinX86_64TargetCodeGenInfo(This$Types, AVXLevel));
       case PS4:
        return SetCGInfo.$call(new PS4TargetCodeGenInfo(This$Types, AVXLevel));
       default:
        return SetCGInfo.$call(new X86_64TargetCodeGenInfo(This$Types, AVXLevel));
      }
    }
   case hexagon:
    return SetCGInfo.$call(new HexagonTargetCodeGenInfo(This$Types));
   case lanai:
    return SetCGInfo.$call(new LanaiTargetCodeGenInfo(This$Types));
   case r600:
    return SetCGInfo.$call(new AMDGPUTargetCodeGenInfo(This$Types));
   case amdgcn:
    return SetCGInfo.$call(new AMDGPUTargetCodeGenInfo(This$Types));
   case sparc:
    return SetCGInfo.$call(new SparcV8TargetCodeGenInfo(This$Types));
   case sparcv9:
    return SetCGInfo.$call(new SparcV9TargetCodeGenInfo(This$Types));
   case xcore:
    return SetCGInfo.$call(new XCoreTargetCodeGenInfo(This$Types));
   case spir:
   case spir64:
    return SetCGInfo.$call(new SPIRTargetCodeGenInfo(This$Types));
  }
}

} // END OF class CodeGenModule_TargetInfo
