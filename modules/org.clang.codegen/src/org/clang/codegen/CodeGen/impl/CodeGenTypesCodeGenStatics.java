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
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenTypesCodeGenStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenTypesCodeGenStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen13toCXXCtorTypeENS0_12StructorTypeE;_ZN5clang7CodeGen13toCXXDtorTypeENS0_12StructorTypeE;_ZN5clang7CodeGen15getFromCtorTypeENS_11CXXCtorTypeE;_ZN5clang7CodeGen15getFromDtorTypeENS_11CXXDtorTypeE; -static-type=CodeGenTypesCodeGenStatics -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public final class CodeGenTypesCodeGenStatics {

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::toCXXCtorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 65,
 FQN="clang::CodeGen::toCXXCtorType", NM="_ZN5clang7CodeGen13toCXXCtorTypeENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen13toCXXCtorTypeENS0_12StructorTypeE")
//</editor-fold>
public static /*inline*/ CXXCtorType toCXXCtorType(StructorType T) {
  switch (T) {
   case Complete:
    return CXXCtorType.Ctor_Complete;
   case Base:
    return CXXCtorType.Ctor_Base;
   case Deleting:
    throw new llvm_unreachable("cannot have a deleting ctor");
  }
  throw new llvm_unreachable("not a StructorType");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::getFromCtorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 77,
 FQN="clang::CodeGen::getFromCtorType", NM="_ZN5clang7CodeGen15getFromCtorTypeENS_11CXXCtorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen15getFromCtorTypeENS_11CXXCtorTypeE")
//</editor-fold>
public static /*inline*/ StructorType getFromCtorType(CXXCtorType T) {
  switch (T) {
   case Ctor_Complete:
    return StructorType.Complete;
   case Ctor_Base:
    return StructorType.Base;
   case Ctor_Comdat:
    throw new llvm_unreachable("not expecting a COMDAT");
   case Ctor_CopyingClosure:
   case Ctor_DefaultClosure:
    throw new llvm_unreachable("not expecting a closure");
  }
  throw new llvm_unreachable("not a CXXCtorType");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::toCXXDtorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 92,
 FQN="clang::CodeGen::toCXXDtorType", NM="_ZN5clang7CodeGen13toCXXDtorTypeENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen13toCXXDtorTypeENS0_12StructorTypeE")
//</editor-fold>
public static /*inline*/ CXXDtorType toCXXDtorType(StructorType T) {
  switch (T) {
   case Complete:
    return CXXDtorType.Dtor_Complete;
   case Base:
    return CXXDtorType.Dtor_Base;
   case Deleting:
    return CXXDtorType.Dtor_Deleting;
  }
  throw new llvm_unreachable("not a StructorType");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::getFromDtorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 104,
 FQN="clang::CodeGen::getFromDtorType", NM="_ZN5clang7CodeGen15getFromDtorTypeENS_11CXXDtorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen15getFromDtorTypeENS_11CXXDtorTypeE")
//</editor-fold>
public static /*inline*/ StructorType getFromDtorType(CXXDtorType T) {
  switch (T) {
   case Dtor_Deleting:
    return StructorType.Deleting;
   case Dtor_Complete:
    return StructorType.Complete;
   case Dtor_Base:
    return StructorType.Base;
   case Dtor_Comdat:
    throw new llvm_unreachable("not expecting a COMDAT");
  }
  throw new llvm_unreachable("not a CXXDtorType");
}

} // END OF class CodeGenTypesCodeGenStatics
