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

import org.clank.support.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinishARCDealloc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 488,
 FQN="(anonymous namespace)::FinishARCDealloc", NM="_ZN12_GLOBAL__N_116FinishARCDeallocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_116FinishARCDeallocE")
//</editor-fold>
public final class/*struct*/ FinishARCDealloc extends /**/ EHScopeStack.Cleanup {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinishARCDealloc::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 489,
   FQN="(anonymous namespace)::FinishARCDealloc::Emit", NM="_ZN12_GLOBAL__N_116FinishARCDealloc4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_116FinishARCDealloc4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    CallArgList args = null;
    try {
      /*const*/ ObjCMethodDecl /*P*/ method = cast_ObjCMethodDecl(CGF.CurCodeDecl);
      
      /*const*/ ObjCImplDecl /*P*/ impl = cast_ObjCImplDecl(method.getDeclContext$Const());
      /*const*/ ObjCInterfaceDecl /*P*/ iface = impl.getClassInterface$Const();
      if (!(iface.getSuperClass() != null)) {
        return;
      }
      
      boolean isCategory = isa_ObjCCategoryImplDecl(impl);
      
      // Call [super dealloc] if we have a superclass.
      Value /*P*/ self = CGF.LoadObjCSelf();
      
      args/*J*/= new CallArgList();
      CGF.CGM.getObjCRuntime().GenerateMessageSendSuper(CGF, new ReturnValueSlot(), 
          CGF.getContext().VoidTy.$QualType(), 
          method.getSelector(), 
          iface, 
          isCategory, 
          self, 
          /*is class msg*/ false, 
          args, 
          method);
    } finally {
      if (args != null) { args.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinishARCDealloc::FinishARCDealloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 488,
   FQN="(anonymous namespace)::FinishARCDealloc::FinishARCDealloc", NM="_ZN12_GLOBAL__N_116FinishARCDeallocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_116FinishARCDeallocC1Ev")
  //</editor-fold>
  public /*inline*/ FinishARCDealloc() {
    // : EHScopeStack::Cleanup() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
