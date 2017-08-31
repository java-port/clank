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

package org.clang.ast.impl;

import org.clank.support.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1542,
 FQN="(anonymous namespace)::GetContainedAutoVisitor", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitorE")
//</editor-fold>
public class GetContainedAutoVisitor implements /*public*/ TypeVisitor<GetContainedAutoVisitor, AutoType /*P*/ > {
/*public:*/
  //JAVA: using TypeVisitor<GetContainedAutoVisitor, AutoType /*P*/ >::Visit;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1546,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::Visit", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor5VisitEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor5VisitEN5clang8QualTypeE")
  //</editor-fold>
  public AutoType /*P*/ Visit(QualType T) {
    if (T.isNull()) {
      return null;
    }
    return Visit(T.getTypePtr());
  }

  
  // The 'auto' type itself.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1553,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitAutoType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor13VisitAutoTypeEPKN5clang8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor13VisitAutoTypeEPKN5clang8AutoTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitAutoType(/*const*/ AutoType /*P*/ AT) {
    return ((/*const_cast*/AutoType /*P*/ )(AT));
  }

  
  // Only these types can contain the desired 'auto' type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1558,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitPointerType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor16VisitPointerTypeEPKN5clang11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor16VisitPointerTypeEPKN5clang11PointerTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitPointerType(/*const*/ PointerType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1561,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitBlockPointerType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1564,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitReferenceType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor18VisitReferenceTypeEPKN5clang13ReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor18VisitReferenceTypeEPKN5clang13ReferenceTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitReferenceType(/*const*/ ReferenceType /*P*/ T) {
    return Visit(T.getPointeeTypeAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1567,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitMemberPointerType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    return Visit(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1570,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitArrayType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor14VisitArrayTypeEPKN5clang9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor14VisitArrayTypeEPKN5clang9ArrayTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitArrayType(/*const*/ ArrayType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1573,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitDependentSizedExtVectorType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitDependentSizedExtVectorType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1577,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitVectorType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor15VisitVectorTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor15VisitVectorTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitVectorType(/*const*/ VectorType /*P*/ T) {
    return Visit(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1580,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitFunctionType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor17VisitFunctionTypeEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor17VisitFunctionTypeEPKN5clang12FunctionTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitFunctionType(/*const*/ FunctionType /*P*/ T) {
    return Visit(T.getReturnType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1583,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitParenType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor14VisitParenTypeEPKN5clang9ParenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor14VisitParenTypeEPKN5clang9ParenTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitParenType(/*const*/ ParenType /*P*/ T) {
    return Visit(T.getInnerType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1586,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitAttributedType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor19VisitAttributedTypeEPKN5clang14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor19VisitAttributedTypeEPKN5clang14AttributedTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitAttributedType(/*const*/ AttributedType /*P*/ T) {
    return Visit(T.getModifiedType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetContainedAutoVisitor::VisitAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1589,
   FQN="(anonymous namespace)::GetContainedAutoVisitor::VisitAdjustedType", NM="_ZN12_GLOBAL__N_123GetContainedAutoVisitor17VisitAdjustedTypeEPKN5clang12AdjustedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_123GetContainedAutoVisitor17VisitAdjustedTypeEPKN5clang12AdjustedTypeE")
  //</editor-fold>
  public AutoType /*P*/ VisitAdjustedType(/*const*/ AdjustedType /*P*/ T) {
    return Visit(T.getOriginalType());
  }

  @Override public AutoType /*P*/ $TypeVisitor$RetTy() { return (AutoType /*P*/)null; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
