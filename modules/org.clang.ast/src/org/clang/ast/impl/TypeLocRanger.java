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
import org.clang.basic.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 29,
 FQN="(anonymous namespace)::TypeLocRanger", NM="_ZN12_GLOBAL__N_113TypeLocRangerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRangerE")
//</editor-fold>
public class TypeLocRanger implements /*public*/ TypeLocVisitor<TypeLocRanger, SourceRange> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="(anonymous namespace)::TypeLocRanger::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public SourceRange VisitQualifiedTypeLoc(QualifiedTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="(anonymous namespace)::TypeLocRanger::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public SourceRange VisitBuiltinTypeLoc(BuiltinTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="(anonymous namespace)::TypeLocRanger::VisitComplexTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger19VisitComplexTypeLocEN5clang14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger19VisitComplexTypeLocEN5clang14ComplexTypeLocE")
  //</editor-fold>
  public SourceRange VisitComplexTypeLoc(ComplexTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="(anonymous namespace)::TypeLocRanger::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public SourceRange VisitPointerTypeLoc(PointerTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="(anonymous namespace)::TypeLocRanger::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public SourceRange VisitBlockPointerTypeLoc(BlockPointerTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="(anonymous namespace)::TypeLocRanger::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public SourceRange VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="(anonymous namespace)::TypeLocRanger::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public SourceRange VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="(anonymous namespace)::TypeLocRanger::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public SourceRange VisitMemberPointerTypeLoc(MemberPointerTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="(anonymous namespace)::TypeLocRanger::VisitConstantArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE")
  //</editor-fold>
  public SourceRange VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="(anonymous namespace)::TypeLocRanger::VisitIncompleteArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE")
  //</editor-fold>
  public SourceRange VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="(anonymous namespace)::TypeLocRanger::VisitVariableArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE")
  //</editor-fold>
  public SourceRange VisitVariableArrayTypeLoc(VariableArrayTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="(anonymous namespace)::TypeLocRanger::VisitDependentSizedArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public SourceRange VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="(anonymous namespace)::TypeLocRanger::VisitDependentSizedExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public SourceRange VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="(anonymous namespace)::TypeLocRanger::VisitVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger18VisitVectorTypeLocEN5clang13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger18VisitVectorTypeLocEN5clang13VectorTypeLocE")
  //</editor-fold>
  public SourceRange VisitVectorTypeLoc(VectorTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="(anonymous namespace)::TypeLocRanger::VisitExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE")
  //</editor-fold>
  public SourceRange VisitExtVectorTypeLoc(ExtVectorTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="(anonymous namespace)::TypeLocRanger::VisitFunctionProtoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE")
  //</editor-fold>
  public SourceRange VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="(anonymous namespace)::TypeLocRanger::VisitFunctionNoProtoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public SourceRange VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="(anonymous namespace)::TypeLocRanger::VisitUnresolvedUsingTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public SourceRange VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="(anonymous namespace)::TypeLocRanger::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public SourceRange VisitParenTypeLoc(ParenTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="(anonymous namespace)::TypeLocRanger::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public SourceRange VisitTypedefTypeLoc(TypedefTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="(anonymous namespace)::TypeLocRanger::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public SourceRange VisitAdjustedTypeLoc(AdjustedTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="(anonymous namespace)::TypeLocRanger::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public SourceRange VisitDecayedTypeLoc(DecayedTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="(anonymous namespace)::TypeLocRanger::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public SourceRange VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="(anonymous namespace)::TypeLocRanger::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public SourceRange VisitTypeOfTypeLoc(TypeOfTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="(anonymous namespace)::TypeLocRanger::VisitDecltypeTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE")
  //</editor-fold>
  public SourceRange VisitDecltypeTypeLoc(DecltypeTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="(anonymous namespace)::TypeLocRanger::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public SourceRange VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="(anonymous namespace)::TypeLocRanger::VisitRecordTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger18VisitRecordTypeLocEN5clang13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger18VisitRecordTypeLocEN5clang13RecordTypeLocE")
  //</editor-fold>
  public SourceRange VisitRecordTypeLoc(RecordTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="(anonymous namespace)::TypeLocRanger::VisitEnumTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger16VisitEnumTypeLocEN5clang11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger16VisitEnumTypeLocEN5clang11EnumTypeLocE")
  //</editor-fold>
  public SourceRange VisitEnumTypeLoc(EnumTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="(anonymous namespace)::TypeLocRanger::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public SourceRange VisitElaboratedTypeLoc(ElaboratedTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="(anonymous namespace)::TypeLocRanger::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public SourceRange VisitAttributedTypeLoc(AttributedTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="(anonymous namespace)::TypeLocRanger::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public SourceRange VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="(anonymous namespace)::TypeLocRanger::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public SourceRange VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="(anonymous namespace)::TypeLocRanger::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public SourceRange VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="(anonymous namespace)::TypeLocRanger::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public SourceRange VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="(anonymous namespace)::TypeLocRanger::VisitAutoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger16VisitAutoTypeLocEN5clang11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger16VisitAutoTypeLocEN5clang11AutoTypeLocE")
  //</editor-fold>
  public SourceRange VisitAutoTypeLoc(AutoTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="(anonymous namespace)::TypeLocRanger::VisitInjectedClassNameTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE")
  //</editor-fold>
  public SourceRange VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="(anonymous namespace)::TypeLocRanger::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public SourceRange VisitDependentNameTypeLoc(DependentNameTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="(anonymous namespace)::TypeLocRanger::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public SourceRange VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="(anonymous namespace)::TypeLocRanger::VisitPackExpansionTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE")
  //</editor-fold>
  public SourceRange VisitPackExpansionTypeLoc(PackExpansionTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="(anonymous namespace)::TypeLocRanger::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public SourceRange VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="(anonymous namespace)::TypeLocRanger::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public SourceRange VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="(anonymous namespace)::TypeLocRanger::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public SourceRange VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="(anonymous namespace)::TypeLocRanger::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public SourceRange VisitPipeTypeLoc(PipeTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocRanger::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="(anonymous namespace)::TypeLocRanger::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocRanger18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocRanger18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public SourceRange VisitAtomicTypeLoc(AtomicTypeLoc TyLoc) {
    return TyLoc.getLocalSourceRange();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
