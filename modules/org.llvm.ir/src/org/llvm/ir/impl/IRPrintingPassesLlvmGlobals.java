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
package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type IRPrintingPassesLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.IRPrintingPassesLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm21createPrintModulePassERNS_11raw_ostreamERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEb;_ZN4llvm23createPrintFunctionPassERNS_11raw_ostreamERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvm25createPrintBasicBlockPassERNS_11raw_ostreamERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE; -static-type=IRPrintingPassesLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class IRPrintingPassesLlvmGlobals {


/// \brief Create and return a pass that writes the module to the specified
/// \c raw_ostream.
//<editor-fold defaultstate="collapsed" desc="llvm::createPrintModulePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 128,
 FQN="llvm::createPrintModulePass", NM="_ZN4llvm21createPrintModulePassERNS_11raw_ostreamERKSsb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm21createPrintModulePassERNS_11raw_ostreamERKSsb")
//</editor-fold>
public static ModulePass /*P*/ createPrintModulePass(final raw_ostream /*&*/ OS) {
  return createPrintModulePass(OS, 
                     new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY), 
                     false);
}
public static ModulePass /*P*/ createPrintModulePass(final raw_ostream /*&*/ OS, 
                     final /*const*/std.string/*&*/ Banner/*= ""*/) {
  return createPrintModulePass(OS, 
                     Banner, 
                     false);
}
public static ModulePass /*P*/ createPrintModulePass(final raw_ostream /*&*/ OS, 
                     final /*const*/std.string/*&*/ Banner/*= ""*/, 
                     boolean ShouldPreserveUseListOrder/*= false*/) {
  return new PrintModulePassWrapper(OS, Banner, ShouldPreserveUseListOrder);
}


/// \brief Create and return a pass that prints functions to the specified
/// \c raw_ostream as they are processed.
//<editor-fold defaultstate="collapsed" desc="llvm::createPrintFunctionPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 134,
 FQN="llvm::createPrintFunctionPass", NM="_ZN4llvm23createPrintFunctionPassERNS_11raw_ostreamERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm23createPrintFunctionPassERNS_11raw_ostreamERKSs")
//</editor-fold>
public static FunctionPass /*P*/ createPrintFunctionPass(final raw_ostream /*&*/ OS) {
  return createPrintFunctionPass(OS, 
                       new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY));
}
public static FunctionPass /*P*/ createPrintFunctionPass(final raw_ostream /*&*/ OS, 
                       final /*const*/std.string/*&*/ Banner/*= ""*/) {
  return new PrintFunctionPassWrapper(OS, Banner);
}


/// \brief Create and return a pass that writes the BB to the specified
/// \c raw_ostream.
//<editor-fold defaultstate="collapsed" desc="llvm::createPrintBasicBlockPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 139,
 FQN="llvm::createPrintBasicBlockPass", NM="_ZN4llvm25createPrintBasicBlockPassERNS_11raw_ostreamERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm25createPrintBasicBlockPassERNS_11raw_ostreamERKSs")
//</editor-fold>
public static BasicBlockPass /*P*/ createPrintBasicBlockPass(final raw_ostream /*&*/ OS) {
  return createPrintBasicBlockPass(OS, 
                         new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY));
}
public static BasicBlockPass /*P*/ createPrintBasicBlockPass(final raw_ostream /*&*/ OS, 
                         final /*const*/std.string/*&*/ Banner/*= ""*/) {
  return new PrintBasicBlockPass(OS, Banner);
}

} // END OF class IRPrintingPassesLlvmGlobals
