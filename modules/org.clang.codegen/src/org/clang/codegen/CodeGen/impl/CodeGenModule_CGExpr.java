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
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGExpr">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGExpr",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGException ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24EmitExplicitCastExprTypeEPKNS_16ExplicitCastExprEPNS0_15CodeGenFunctionE; -static-type=CodeGenModule_CGExpr -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGExpr extends CodeGenModule_CGException {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// \brief Emit type info if type of an expression is a variably modified
/// type. Also emit proper debug info for cast types.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitExplicitCastExprType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 804,
 FQN="clang::CodeGen::CodeGenModule::EmitExplicitCastExprType", NM="_ZN5clang7CodeGen13CodeGenModule24EmitExplicitCastExprTypeEPKNS_16ExplicitCastExprEPNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24EmitExplicitCastExprTypeEPKNS_16ExplicitCastExprEPNS0_15CodeGenFunctionE")
//</editor-fold>
public final void EmitExplicitCastExprType(/*const*/ ExplicitCastExpr /*P*/ E) {
  EmitExplicitCastExprType(E, 
                        (CodeGenFunction /*P*/ )null);
}
public final void EmitExplicitCastExprType(/*const*/ ExplicitCastExpr /*P*/ E, 
                        CodeGenFunction /*P*/ CGF/*= null*/) {
  // Bind VLAs in the cast type.
  if ((CGF != null) && E.getType().$arrow().isVariablyModifiedType()) {
    CGF.EmitVariablyModifiedType(E.getType());
  }
  {
    
    CGDebugInfo /*P*/ DI = $this().getModuleDebugInfo();
    if ((DI != null)) {
      DI.EmitExplicitCastType(E.getType());
    }
  }
}

} // END OF class CodeGenModule_CGExpr
