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
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.Type;
import org.clang.ast.java.AstDeclarationsRTTI;
import org.clang.ast.java.AstJavaDifferentiators;
import org.clang.codegen.impl.CGCXXStatics;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGCXX">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGCXX",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGCUDABuiltin ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25BuildAppleKextVirtualCallEPKNS_13CXXMethodDeclEPNS_19NestedNameSpecifierEPN4llvm4TypeE;_ZN5clang7CodeGen15CodeGenFunction35BuildAppleKextVirtualDestructorCallEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEPKNS_13CXXRecordDeclE; -static-type=CodeGenFunction_CGCXX -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGCXX extends CodeGenFunction_CGCUDABuiltin {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGCXX(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// BuildAppleKextVirtualCall - This routine is to support gcc's kext ABI making
/// indirect call to virtual functions. It makes the call through indexing
/// into the vtable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BuildAppleKextVirtualCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 288,
 FQN="clang::CodeGen::CodeGenFunction::BuildAppleKextVirtualCall", NM="_ZN5clang7CodeGen15CodeGenFunction25BuildAppleKextVirtualCallEPKNS_13CXXMethodDeclEPNS_19NestedNameSpecifierEPN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25BuildAppleKextVirtualCallEPKNS_13CXXMethodDeclEPNS_19NestedNameSpecifierEPN4llvm4TypeE")
//</editor-fold>
public final Value /*P*/ BuildAppleKextVirtualCall(/*const*/ CXXMethodDecl /*P*/ MD, 
                         NestedNameSpecifier /*P*/ Qual, 
                         org.llvm.ir.Type /*P*/ Ty) {
  assert ((Qual.getKind() == NestedNameSpecifier.SpecifierKind.TypeSpec)) : "BuildAppleKextVirtualCall - bad Qual kind";
  
  /*const*/ org.clang.ast.Type /*P*/ QTy = Qual.getAsType();
  QualType T = new QualType(QTy, 0);
  /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
  assert ((RT != null)) : "BuildAppleKextVirtualCall - Qual type must be record";
  /*const*/ CXXRecordDecl /*P*/ RD = AstDeclarationsRTTI.cast_CXXRecordDecl(RT.getDecl());
  {
    
    /*const*/ CXXDestructorDecl /*P*/ DD = AstDeclarationsRTTI.dyn_cast_CXXDestructorDecl(MD);
    if ((DD != null)) {
      return $this().BuildAppleKextVirtualDestructorCall(DD, CXXDtorType.Dtor_Complete, RD);
    }
  }
  
  return /*::*/CGCXXStatics.BuildAppleKextVirtualCall(/*Deref*/$this(), new GlobalDecl(MD), Ty, RD);
}


/// BuildVirtualCall - This routine makes indirect vtable call for
/// call to virtual destructors. It returns 0 if it could not do it.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BuildAppleKextVirtualDestructorCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 309,
 FQN="clang::CodeGen::CodeGenFunction::BuildAppleKextVirtualDestructorCall", NM="_ZN5clang7CodeGen15CodeGenFunction35BuildAppleKextVirtualDestructorCallEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction35BuildAppleKextVirtualDestructorCallEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final Value /*P*/ BuildAppleKextVirtualDestructorCall(/*const*/ CXXDestructorDecl /*P*/ DD, 
                                   CXXDtorType Type, 
                                   /*const*/ CXXRecordDecl /*P*/ RD) {
  /*const*/ CXXMethodDecl /*P*/ MD =  AstDeclarationsRTTI.cast_CXXMethodDecl(DD);
  // FIXME. Dtor_Base dtor is always direct!!
  // It need be somehow inline expanded into the caller.
  // -O does that. But need to support -O0 as well.
  if (MD.isVirtual() && Type != CXXDtorType.Dtor_Base) {
    // Compute the function type we're calling.
    final /*const*/ CGFunctionInfo /*&*/ FInfo = $this().CGM.getTypes().arrangeCXXStructorDeclaration(DD, StructorType.Complete);
    org.llvm.ir.Type /*P*/ Ty = $this().CGM.getTypes().GetFunctionType(FInfo);
    return /*::*/CGCXXStatics.BuildAppleKextVirtualCall(/*Deref*/$this(), new GlobalDecl(AstJavaDifferentiators.JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, Type), Ty, RD);
  }
  return null;
}

} // END OF class CodeGenFunction_CGCXX
