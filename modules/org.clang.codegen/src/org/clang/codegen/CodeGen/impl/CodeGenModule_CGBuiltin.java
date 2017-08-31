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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.llvm.ir.FunctionType;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGBuiltin",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGBlocks ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21getBuiltinLibFunctionEPKNS_12FunctionDeclEj; -static-type=CodeGenModule_CGBuiltin -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGBuiltin extends CodeGenModule_CGBlocks {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// Given a builtin id for a function like "__builtin_fabsf", return a
/// Function* for "fabsf".

/// getBuiltinLibFunction - Given a builtin id for a function like
/// "__builtin_fabsf", return a Function* for "fabsf".
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getBuiltinLibFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp", line = 38,
 FQN="clang::CodeGen::CodeGenModule::getBuiltinLibFunction", NM="_ZN5clang7CodeGen13CodeGenModule21getBuiltinLibFunctionEPKNS_12FunctionDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21getBuiltinLibFunctionEPKNS_12FunctionDeclEj")
//</editor-fold>
public final Value /*P*/ getBuiltinLibFunction(/*const*/ FunctionDecl /*P*/ FD, 
                     /*uint*/int BuiltinID) {
  assert ($this().Context.BuiltinInfo.isLibFunction(BuiltinID));
  
  // Get the name, skip over the __builtin_ prefix (if necessary).
  StringRef Name/*J*/= new StringRef();
  GlobalDecl D/*J*/= new GlobalDecl(FD);
  
  // If the builtin has been declared explicitly with an assembler label,
  // use the mangled name. This differs from the plain label on platforms
  // that prefix labels.
  if (FD.hasAttr(AsmLabelAttr.class)) {
    Name.$assignMove($this().getMangledName(new GlobalDecl(D)));
  } else {
    Name.$assignMove(/*STRINGREF_STR*/$this().Context.BuiltinInfo.getName(BuiltinID).$add(10));
  }
  
  FunctionType /*P*/ Ty = cast_FunctionType($this().getTypes().ConvertType(FD.getType()));
  
  return $this().GetOrCreateLLVMFunction(new StringRef(Name), Ty, new GlobalDecl(D), /*ForVTable=*/ false);
}

} // END OF class CodeGenModule_CGBuiltin
