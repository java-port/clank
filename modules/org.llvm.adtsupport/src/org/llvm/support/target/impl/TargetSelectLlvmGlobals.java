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
package org.llvm.support.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import org.llvm.cl.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.clank.java.stdimpl.aliases.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.adt.*;
import org.llvm.support.AdtsupportLlvmGlobals;


//<editor-fold defaultstate="collapsed" desc="static type TargetSelectLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.target.impl.TargetSelectLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm20InitializeAllTargetsEv;_ZN4llvm22InitializeAllTargetMCsEv;_ZN4llvm22InitializeNativeTargetEv;_ZN4llvm23InitializeAllAsmParsersEv;_ZN4llvm24InitializeAllAsmPrintersEv;_ZN4llvm24InitializeAllTargetInfosEv;_ZN4llvm26InitializeAllDisassemblersEv;_ZN4llvm31InitializeNativeTargetAsmParserEv;_ZN4llvm32InitializeNativeTargetAsmPrinterEv;_ZN4llvm34InitializeNativeTargetDisassemblerEv; -static-type=TargetSelectLlvmGlobals -package=org.llvm.support.target.impl")
//</editor-fold>
public final class TargetSelectLlvmGlobals {

/// InitializeAllTargetInfos - The main program should call this function if
/// it wants access to all available targets that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetInfos">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 53,
 FQN="llvm::InitializeAllTargetInfos", NM="_ZN4llvm24InitializeAllTargetInfosEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm24InitializeAllTargetInfosEv")
//</editor-fold>
public static /*inline*/ void InitializeAllTargetInfos() {
  NativeTrace.traceNotImplemented("llvm.InitializeAllTargetInfos");
//  LLVMInitializeAArch64TargetInfo();
//  LLVMInitializeAMDGPUTargetInfo();
//  LLVMInitializeARMTargetInfo();
//  LLVMInitializeBPFTargetInfo();
//  LLVMInitializeHexagonTargetInfo();
//  LLVMInitializeMipsTargetInfo();
//  LLVMInitializeMSP430TargetInfo();
//  LLVMInitializeNVPTXTargetInfo();
//  LLVMInitializePowerPCTargetInfo();
//  LLVMInitializeSparcTargetInfo();
//  LLVMInitializeSystemZTargetInfo();
//  LLVMInitializeX86TargetInfo();
//  LLVMInitializeXCoreTargetInfo();
}


/// InitializeAllTargets - The main program should call this function if it
/// wants access to all available target machines that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 63,
 FQN="llvm::InitializeAllTargets", NM="_ZN4llvm20InitializeAllTargetsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm20InitializeAllTargetsEv")
//</editor-fold>
public static /*inline*/ void InitializeAllTargets() {
  // FIXME: Remove this, clients should do it.
  AdtsupportLlvmGlobals.InitializeAllTargetInfos();
//  LLVMInitializeAArch64Target();
//  LLVMInitializeAMDGPUTarget();
//  LLVMInitializeARMTarget();
//  LLVMInitializeBPFTarget();
//  LLVMInitializeHexagonTarget();
//  LLVMInitializeMipsTarget();
//  LLVMInitializeMSP430Target();
//  LLVMInitializeNVPTXTarget();
//  LLVMInitializePowerPCTarget();
//  LLVMInitializeSparcTarget();
//  LLVMInitializeSystemZTarget();
//  LLVMInitializeX86Target();
//  LLVMInitializeXCoreTarget();
}


/// InitializeAllTargetMCs - The main program should call this function if it
/// wants access to all available target MC that LLVM is configured to
/// support, to make them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllTargetMCs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 76,
 FQN="llvm::InitializeAllTargetMCs", NM="_ZN4llvm22InitializeAllTargetMCsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm22InitializeAllTargetMCsEv")
//</editor-fold>
public static /*inline*/ void InitializeAllTargetMCs() {
//  LLVMInitializeAArch64TargetMC();
//  LLVMInitializeAMDGPUTargetMC();
//  LLVMInitializeARMTargetMC();
//  LLVMInitializeBPFTargetMC();
//  LLVMInitializeHexagonTargetMC();
//  LLVMInitializeMipsTargetMC();
//  LLVMInitializeMSP430TargetMC();
//  LLVMInitializeNVPTXTargetMC();
//  LLVMInitializePowerPCTargetMC();
//  LLVMInitializeSparcTargetMC();
//  LLVMInitializeSystemZTargetMC();
//  LLVMInitializeX86TargetMC();
//  LLVMInitializeXCoreTargetMC();
}


/// InitializeAllAsmPrinters - The main program should call this function if
/// it wants all asm printers that LLVM is configured to support, to make them
/// available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllAsmPrinters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 86,
 FQN="llvm::InitializeAllAsmPrinters", NM="_ZN4llvm24InitializeAllAsmPrintersEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm24InitializeAllAsmPrintersEv")
//</editor-fold>
public static /*inline*/ void InitializeAllAsmPrinters() {
//  LLVMInitializeAArch64AsmPrinter();
//  LLVMInitializeAMDGPUAsmPrinter();
//  LLVMInitializeARMAsmPrinter();
//  LLVMInitializeBPFAsmPrinter();
//  LLVMInitializeHexagonAsmPrinter();
//  LLVMInitializeMipsAsmPrinter();
//  LLVMInitializeMSP430AsmPrinter();
//  LLVMInitializeNVPTXAsmPrinter();
//  LLVMInitializePowerPCAsmPrinter();
//  LLVMInitializeSparcAsmPrinter();
//  LLVMInitializeSystemZAsmPrinter();
//  LLVMInitializeX86AsmPrinter();
//  LLVMInitializeXCoreAsmPrinter();
}


/// InitializeAllAsmParsers - The main program should call this function if it
/// wants all asm parsers that LLVM is configured to support, to make them
/// available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllAsmParsers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 96,
 FQN="llvm::InitializeAllAsmParsers", NM="_ZN4llvm23InitializeAllAsmParsersEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm23InitializeAllAsmParsersEv")
//</editor-fold>
public static /*inline*/ void InitializeAllAsmParsers() {
//  LLVMInitializeAArch64AsmParser();
//  LLVMInitializeAMDGPUAsmParser();
//  LLVMInitializeARMAsmParser();
//  LLVMInitializeHexagonAsmParser();
//  LLVMInitializeMipsAsmParser();
//  LLVMInitializePowerPCAsmParser();
//  LLVMInitializeSparcAsmParser();
//  LLVMInitializeSystemZAsmParser();
//  LLVMInitializeX86AsmParser();
}


/// InitializeAllDisassemblers - The main program should call this function if
/// it wants all disassemblers that LLVM is configured to support, to make
/// them available via the TargetRegistry.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeAllDisassemblers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 106,
 FQN="llvm::InitializeAllDisassemblers", NM="_ZN4llvm26InitializeAllDisassemblersEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm26InitializeAllDisassemblersEv")
//</editor-fold>
public static /*inline*/ void InitializeAllDisassemblers() {
//  LLVMInitializeAArch64Disassembler();
//  LLVMInitializeAMDGPUDisassembler();
//  LLVMInitializeARMDisassembler();
//  LLVMInitializeHexagonDisassembler();
//  LLVMInitializeMipsDisassembler();
//  LLVMInitializePowerPCDisassembler();
//  LLVMInitializeSparcDisassembler();
//  LLVMInitializeSystemZDisassembler();
//  LLVMInitializeX86Disassembler();
//  LLVMInitializeXCoreDisassembler();
}


/// InitializeNativeTarget - The main program should call this function to
/// initialize the native target corresponding to the host.  This is useful
/// for JIT applications to ensure that the target gets linked in correctly.
///
/// It is legal for a client to make multiple calls to this function.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 116,
 FQN="llvm::InitializeNativeTarget", NM="_ZN4llvm22InitializeNativeTargetEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm22InitializeNativeTargetEv")
//</editor-fold>
public static /*inline*/ boolean InitializeNativeTarget() {
//  LLVMInitializeX86TargetInfo();
//  LLVMInitializeX86Target();
//  LLVMInitializeX86TargetMC();
  return false;
}


/// InitializeNativeTargetAsmPrinter - The main program should call
/// this function to initialize the native target asm printer.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTargetAsmPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 130,
 FQN="llvm::InitializeNativeTargetAsmPrinter", NM="_ZN4llvm32InitializeNativeTargetAsmPrinterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm32InitializeNativeTargetAsmPrinterEv")
//</editor-fold>
public static /*inline*/ boolean InitializeNativeTargetAsmPrinter() {
//  LLVMInitializeX86AsmPrinter();
  return false;
}


/// InitializeNativeTargetAsmParser - The main program should call
/// this function to initialize the native target asm parser.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTargetAsmParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 142,
 FQN="llvm::InitializeNativeTargetAsmParser", NM="_ZN4llvm31InitializeNativeTargetAsmParserEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm31InitializeNativeTargetAsmParserEv")
//</editor-fold>
public static /*inline*/ boolean InitializeNativeTargetAsmParser() {
//  LLVMInitializeX86AsmParser();
  return false;
}


/// InitializeNativeTargetDisassembler - The main program should call
/// this function to initialize the native target disassembler.
//<editor-fold defaultstate="collapsed" desc="llvm::InitializeNativeTargetDisassembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetSelect.h", line = 154,
 FQN="llvm::InitializeNativeTargetDisassembler", NM="_ZN4llvm34InitializeNativeTargetDisassemblerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN4llvm34InitializeNativeTargetDisassemblerEv")
//</editor-fold>
public static /*inline*/ boolean InitializeNativeTargetDisassembler() {
//  LLVMInitializeX86Disassembler();
  return false;
}

} // END OF class TargetSelectLlvmGlobals
