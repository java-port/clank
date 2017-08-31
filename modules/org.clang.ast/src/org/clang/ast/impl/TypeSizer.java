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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 64,
 FQN="(anonymous namespace)::TypeSizer", NM="_ZN12_GLOBAL__N_19TypeSizerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizerE")
//</editor-fold>
public class TypeSizer implements /*public*/ TypeLocVisitorUInt<TypeSizer> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="(anonymous namespace)::TypeSizer::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitQualifiedTypeLoc(QualifiedTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="(anonymous namespace)::TypeSizer::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitBuiltinTypeLoc(BuiltinTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="(anonymous namespace)::TypeSizer::VisitComplexTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer19VisitComplexTypeLocEN5clang14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer19VisitComplexTypeLocEN5clang14ComplexTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitComplexTypeLoc(ComplexTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="(anonymous namespace)::TypeSizer::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitPointerTypeLoc(PointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="(anonymous namespace)::TypeSizer::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitBlockPointerTypeLoc(BlockPointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="(anonymous namespace)::TypeSizer::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="(anonymous namespace)::TypeSizer::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="(anonymous namespace)::TypeSizer::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitMemberPointerTypeLoc(MemberPointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="(anonymous namespace)::TypeSizer::VisitConstantArrayTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="(anonymous namespace)::TypeSizer::VisitIncompleteArrayTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="(anonymous namespace)::TypeSizer::VisitVariableArrayTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitVariableArrayTypeLoc(VariableArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="(anonymous namespace)::TypeSizer::VisitDependentSizedArrayTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="(anonymous namespace)::TypeSizer::VisitDependentSizedExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="(anonymous namespace)::TypeSizer::VisitVectorTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer18VisitVectorTypeLocEN5clang13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer18VisitVectorTypeLocEN5clang13VectorTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitVectorTypeLoc(VectorTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="(anonymous namespace)::TypeSizer::VisitExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitExtVectorTypeLoc(ExtVectorTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="(anonymous namespace)::TypeSizer::VisitFunctionProtoTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="(anonymous namespace)::TypeSizer::VisitFunctionNoProtoTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="(anonymous namespace)::TypeSizer::VisitUnresolvedUsingTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="(anonymous namespace)::TypeSizer::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitParenTypeLoc(ParenTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="(anonymous namespace)::TypeSizer::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTypedefTypeLoc(TypedefTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="(anonymous namespace)::TypeSizer::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAdjustedTypeLoc(AdjustedTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="(anonymous namespace)::TypeSizer::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDecayedTypeLoc(DecayedTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="(anonymous namespace)::TypeSizer::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="(anonymous namespace)::TypeSizer::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTypeOfTypeLoc(TypeOfTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="(anonymous namespace)::TypeSizer::VisitDecltypeTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDecltypeTypeLoc(DecltypeTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="(anonymous namespace)::TypeSizer::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="(anonymous namespace)::TypeSizer::VisitRecordTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer18VisitRecordTypeLocEN5clang13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer18VisitRecordTypeLocEN5clang13RecordTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitRecordTypeLoc(RecordTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="(anonymous namespace)::TypeSizer::VisitEnumTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer16VisitEnumTypeLocEN5clang11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer16VisitEnumTypeLocEN5clang11EnumTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitEnumTypeLoc(EnumTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="(anonymous namespace)::TypeSizer::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitElaboratedTypeLoc(ElaboratedTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="(anonymous namespace)::TypeSizer::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAttributedTypeLoc(AttributedTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="(anonymous namespace)::TypeSizer::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="(anonymous namespace)::TypeSizer::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="(anonymous namespace)::TypeSizer::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="(anonymous namespace)::TypeSizer::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="(anonymous namespace)::TypeSizer::VisitAutoTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer16VisitAutoTypeLocEN5clang11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer16VisitAutoTypeLocEN5clang11AutoTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAutoTypeLoc(AutoTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="(anonymous namespace)::TypeSizer::VisitInjectedClassNameTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="(anonymous namespace)::TypeSizer::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentNameTypeLoc(DependentNameTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="(anonymous namespace)::TypeSizer::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="(anonymous namespace)::TypeSizer::VisitPackExpansionTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitPackExpansionTypeLoc(PackExpansionTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="(anonymous namespace)::TypeSizer::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="(anonymous namespace)::TypeSizer::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="(anonymous namespace)::TypeSizer::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="(anonymous namespace)::TypeSizer::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitPipeTypeLoc(PipeTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeSizer::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="(anonymous namespace)::TypeSizer::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_19TypeSizer18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_19TypeSizer18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAtomicTypeLoc(AtomicTypeLoc TyLoc) {
    return TyLoc.getLocalDataSize();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
