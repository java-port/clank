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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 46,
 FQN="(anonymous namespace)::TypeAligner", NM="_ZN12_GLOBAL__N_111TypeAlignerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAlignerE")
//</editor-fold>
public class TypeAligner implements /*public*/ TypeLocVisitorUInt<TypeAligner> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="(anonymous namespace)::TypeAligner::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitQualifiedTypeLoc(QualifiedTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="(anonymous namespace)::TypeAligner::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitBuiltinTypeLoc(BuiltinTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="(anonymous namespace)::TypeAligner::VisitComplexTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner19VisitComplexTypeLocEN5clang14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner19VisitComplexTypeLocEN5clang14ComplexTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitComplexTypeLoc(ComplexTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="(anonymous namespace)::TypeAligner::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitPointerTypeLoc(PointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="(anonymous namespace)::TypeAligner::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitBlockPointerTypeLoc(BlockPointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="(anonymous namespace)::TypeAligner::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="(anonymous namespace)::TypeAligner::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="(anonymous namespace)::TypeAligner::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitMemberPointerTypeLoc(MemberPointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="(anonymous namespace)::TypeAligner::VisitConstantArrayTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="(anonymous namespace)::TypeAligner::VisitIncompleteArrayTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="(anonymous namespace)::TypeAligner::VisitVariableArrayTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitVariableArrayTypeLoc(VariableArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="(anonymous namespace)::TypeAligner::VisitDependentSizedArrayTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="(anonymous namespace)::TypeAligner::VisitDependentSizedExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="(anonymous namespace)::TypeAligner::VisitVectorTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner18VisitVectorTypeLocEN5clang13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner18VisitVectorTypeLocEN5clang13VectorTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitVectorTypeLoc(VectorTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="(anonymous namespace)::TypeAligner::VisitExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitExtVectorTypeLoc(ExtVectorTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="(anonymous namespace)::TypeAligner::VisitFunctionProtoTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="(anonymous namespace)::TypeAligner::VisitFunctionNoProtoTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="(anonymous namespace)::TypeAligner::VisitUnresolvedUsingTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="(anonymous namespace)::TypeAligner::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitParenTypeLoc(ParenTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="(anonymous namespace)::TypeAligner::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTypedefTypeLoc(TypedefTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="(anonymous namespace)::TypeAligner::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAdjustedTypeLoc(AdjustedTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="(anonymous namespace)::TypeAligner::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDecayedTypeLoc(DecayedTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="(anonymous namespace)::TypeAligner::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="(anonymous namespace)::TypeAligner::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTypeOfTypeLoc(TypeOfTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="(anonymous namespace)::TypeAligner::VisitDecltypeTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDecltypeTypeLoc(DecltypeTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="(anonymous namespace)::TypeAligner::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="(anonymous namespace)::TypeAligner::VisitRecordTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner18VisitRecordTypeLocEN5clang13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner18VisitRecordTypeLocEN5clang13RecordTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitRecordTypeLoc(RecordTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="(anonymous namespace)::TypeAligner::VisitEnumTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner16VisitEnumTypeLocEN5clang11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner16VisitEnumTypeLocEN5clang11EnumTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitEnumTypeLoc(EnumTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="(anonymous namespace)::TypeAligner::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitElaboratedTypeLoc(ElaboratedTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="(anonymous namespace)::TypeAligner::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAttributedTypeLoc(AttributedTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="(anonymous namespace)::TypeAligner::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="(anonymous namespace)::TypeAligner::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="(anonymous namespace)::TypeAligner::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="(anonymous namespace)::TypeAligner::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="(anonymous namespace)::TypeAligner::VisitAutoTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner16VisitAutoTypeLocEN5clang11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner16VisitAutoTypeLocEN5clang11AutoTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAutoTypeLoc(AutoTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="(anonymous namespace)::TypeAligner::VisitInjectedClassNameTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="(anonymous namespace)::TypeAligner::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentNameTypeLoc(DependentNameTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="(anonymous namespace)::TypeAligner::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="(anonymous namespace)::TypeAligner::VisitPackExpansionTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitPackExpansionTypeLoc(PackExpansionTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="(anonymous namespace)::TypeAligner::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="(anonymous namespace)::TypeAligner::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="(anonymous namespace)::TypeAligner::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="(anonymous namespace)::TypeAligner::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitPipeTypeLoc(PipeTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeAligner::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="(anonymous namespace)::TypeAligner::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_111TypeAligner18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_111TypeAligner18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public /*uint*/int VisitAtomicTypeLoc(AtomicTypeLoc TyLoc) {
    return TyLoc.getLocalDataAlignment();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
