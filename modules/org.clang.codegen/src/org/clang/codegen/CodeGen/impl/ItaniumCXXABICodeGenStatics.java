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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type ItaniumCXXABICodeGenStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN5clang7CodeGen19CreateItaniumCXXABIERNS0_13CodeGenModuleE; -static-type=ItaniumCXXABICodeGenStatics -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public final class ItaniumCXXABICodeGenStatics {


// Create an instance of a C++ ABI class:

/// Creates an Itanium-family ABI.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CreateItaniumCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 450,
 FQN="clang::CodeGen::CreateItaniumCXXABI", NM="_ZN5clang7CodeGen19CreateItaniumCXXABIERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN5clang7CodeGen19CreateItaniumCXXABIERNS0_13CodeGenModuleE")
//</editor-fold>
public static CGCXXABI /*P*/ CreateItaniumCXXABI(final CodeGenModule /*&*/ CGM) {
  switch (CGM.getTarget().getCXXABI().getKind()) {
   case GenericARM:
   case iOS:
   case WatchOS:
    // For IR-generation purposes, there's no significant difference
    // between the ARM and iOS ABIs.
    return new ARMCXXABI(CGM);
   case iOS64:
    return new iOS64CXXABI(CGM);
   case GenericAArch64:
    
    // Note that AArch64 uses the generic ItaniumCXXABI class since it doesn't
    // include the other 32-bit ARM oddities: constructor/destructor return values
    // and array cookies.
    return new ItaniumCXXABI(CGM, /* UseARMMethodPtrABI = */ true, 
        /* UseARMGuardVarABI = */ true);
   case GenericMIPS:
    return new ItaniumCXXABI(CGM, /* UseARMMethodPtrABI = */ true);
   case WebAssembly:
    return new WebAssemblyCXXABI(CGM);
   case GenericItanium:
    if (CGM.getContext().getTargetInfo().getTriple().getArch()
       == Triple.ArchType.le32) {
      // For PNaCl, use ARM-style method pointers so that PNaCl code
      // does not assume anything about the alignment of function
      // pointers.
      return new ItaniumCXXABI(CGM, /* UseARMMethodPtrABI = */ true, 
          /* UseARMGuardVarABI = */ false);
    }
    return new ItaniumCXXABI(CGM);
   case Microsoft:
    throw new llvm_unreachable("Microsoft ABI is not Itanium-based");
  }
  throw new llvm_unreachable("bad ABI kind");
}

} // END OF class ItaniumCXXABICodeGenStatics
