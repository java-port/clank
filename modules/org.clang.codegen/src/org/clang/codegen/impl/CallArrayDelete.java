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
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGExprCXXStatics.*;

/// Calls the given 'operator delete' on an array of objects.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallArrayDelete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1600,
 FQN="(anonymous namespace)::CallArrayDelete", NM="_ZN12_GLOBAL__N_115CallArrayDeleteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_115CallArrayDeleteE")
//</editor-fold>
public final class/*struct*/ CallArrayDelete extends /**/ EHScopeStack.Cleanup {
  public Value /*P*/ Ptr;
  public /*const*/ FunctionDecl /*P*/ OperatorDelete;
  public Value /*P*/ NumElements;
  public QualType ElementType;
  public CharUnits CookieSize;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallArrayDelete::CallArrayDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1607,
   FQN="(anonymous namespace)::CallArrayDelete::CallArrayDelete", NM="_ZN12_GLOBAL__N_115CallArrayDeleteC1EPN4llvm5ValueEPKN5clang12FunctionDeclES3_NS4_8QualTypeENS4_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_115CallArrayDeleteC1EPN4llvm5ValueEPKN5clang12FunctionDeclES3_NS4_8QualTypeENS4_9CharUnitsE")
  //</editor-fold>
  public CallArrayDelete(Value /*P*/ Ptr, 
      /*const*/ FunctionDecl /*P*/ OperatorDelete, 
      Value /*P*/ NumElements, 
      QualType ElementType, 
      CharUnits CookieSize) {
    // : EHScopeStack::Cleanup(), Ptr(Ptr), OperatorDelete(OperatorDelete), NumElements(NumElements), ElementType(ElementType), CookieSize(CookieSize) 
    //START JInit
    super();
    this.Ptr = Ptr;
    this.OperatorDelete = OperatorDelete;
    this.NumElements = NumElements;
    this.ElementType = new QualType(ElementType);
    this.CookieSize = new CharUnits(CookieSize);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallArrayDelete::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1615,
   FQN="(anonymous namespace)::CallArrayDelete::Emit", NM="_ZN12_GLOBAL__N_115CallArrayDelete4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_115CallArrayDelete4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    CallArgList Args = null;
    try {
      /*const*/ FunctionProtoType /*P*/ DeleteFTy = OperatorDelete.getType().$arrow().getAs(FunctionProtoType.class);
      assert (DeleteFTy.getNumParams() == 1 || DeleteFTy.getNumParams() == 2);
      
      Args/*J*/= new CallArgList();
      
      // Pass the pointer as the first argument.
      QualType VoidPtrTy = DeleteFTy.getParamType(0);
      Value /*P*/ DeletePtr = CGF.Builder.CreateBitCast(Ptr, CGF.ConvertType(new QualType(VoidPtrTy)));
      Args.add(RValue.get(DeletePtr), new QualType(VoidPtrTy));
      
      // Pass the original requested size as the second argument.
      if (DeleteFTy.getNumParams() == 2) {
        QualType size_t = DeleteFTy.getParamType(1);
        IntegerType /*P*/ SizeTy = cast_IntegerType(CGF.ConvertType(new QualType(size_t)));
        
        CharUnits ElementTypeSize = CGF.CGM.getContext().getTypeSizeInChars(/*NO_COPY*/ElementType);
        
        // The size of an element, multiplied by the number of elements.
        Value /*P*/ Size = ConstantInt.get(SizeTy, ElementTypeSize.getQuantity());
        if ((NumElements != null)) {
          Size = CGF.Builder.CreateMul(Size, NumElements);
        }
        
        // Plus the size of the cookie if applicable.
        if (!CookieSize.isZero()) {
          Value /*P*/ CookieSizeV = ConstantInt.get(SizeTy, CookieSize.getQuantity());
          Size = CGF.Builder.CreateAdd(Size, CookieSizeV);
        }
        
        Args.add(RValue.get(Size), new QualType(size_t));
      }
      
      // Emit the call to delete.
      EmitNewDeleteCall(CGF, OperatorDelete, DeleteFTy, Args);
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr // NOI18N
              + ", OperatorDelete=" + "[FunctionDecl]" // NOI18N
              + ", NumElements=" + NumElements // NOI18N
              + ", ElementType=" + ElementType // NOI18N
              + ", CookieSize=" + CookieSize // NOI18N
              + super.toString(); // NOI18N
  }
}
