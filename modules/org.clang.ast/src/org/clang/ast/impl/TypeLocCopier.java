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
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 131,
 FQN="(anonymous namespace)::TypeLocCopier", NM="_ZN12_GLOBAL__N_113TypeLocCopierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopierE")
//</editor-fold>
public class TypeLocCopier implements /*public*/ TypeLocVisitorVoid<TypeLocCopier> {
  private TypeLoc Source;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::TypeLocCopier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 134,
   FQN="(anonymous namespace)::TypeLocCopier::TypeLocCopier", NM="_ZN12_GLOBAL__N_113TypeLocCopierC1EN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopierC1EN5clang7TypeLocE")
  //</editor-fold>
  public TypeLocCopier(TypeLoc source) {
    // : TypeLocVisitor<TypeLocCopier>(), Source(source) 
    //START JInit
    $TypeLocVisitor();
    this.Source = new TypeLoc(source);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="(anonymous namespace)::TypeLocCopier::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public void VisitQualifiedTypeLoc(QualifiedTypeLoc dest) {
    dest.copyLocal(new TypeLoc(JD$Move.INSTANCE, Source.castAs(QualifiedTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="(anonymous namespace)::TypeLocCopier::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public void VisitBuiltinTypeLoc(BuiltinTypeLoc dest) {
    dest.copyLocal(Source.castAs(BuiltinTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="(anonymous namespace)::TypeLocCopier::VisitComplexTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier19VisitComplexTypeLocEN5clang14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier19VisitComplexTypeLocEN5clang14ComplexTypeLocE")
  //</editor-fold>
  public void VisitComplexTypeLoc(ComplexTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(ComplexTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="(anonymous namespace)::TypeLocCopier::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public void VisitPointerTypeLoc(PointerTypeLoc dest) {
    dest.copyLocal(Source.castAs(PointerTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="(anonymous namespace)::TypeLocCopier::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public void VisitBlockPointerTypeLoc(BlockPointerTypeLoc dest) {
    dest.copyLocal(Source.castAs(BlockPointerTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="(anonymous namespace)::TypeLocCopier::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc dest) {
    dest.copyLocal(new ReferenceTypeLoc(JD$Move.INSTANCE, Source.castAs(LValueReferenceTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="(anonymous namespace)::TypeLocCopier::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public void VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc dest) {
    dest.copyLocal(new ReferenceTypeLoc(JD$Move.INSTANCE, Source.castAs(RValueReferenceTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="(anonymous namespace)::TypeLocCopier::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public void VisitMemberPointerTypeLoc(MemberPointerTypeLoc dest) {
    dest.copyLocal(Source.castAs(MemberPointerTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="(anonymous namespace)::TypeLocCopier::VisitConstantArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE")
  //</editor-fold>
  public void VisitConstantArrayTypeLoc(ConstantArrayTypeLoc dest) {
    dest.copyLocal(new ArrayTypeLoc(JD$Move.INSTANCE, Source.castAs(ConstantArrayTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="(anonymous namespace)::TypeLocCopier::VisitIncompleteArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE")
  //</editor-fold>
  public void VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc dest) {
    dest.copyLocal(new ArrayTypeLoc(JD$Move.INSTANCE, Source.castAs(IncompleteArrayTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="(anonymous namespace)::TypeLocCopier::VisitVariableArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE")
  //</editor-fold>
  public void VisitVariableArrayTypeLoc(VariableArrayTypeLoc dest) {
    dest.copyLocal(new ArrayTypeLoc(JD$Move.INSTANCE, Source.castAs(VariableArrayTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="(anonymous namespace)::TypeLocCopier::VisitDependentSizedArrayTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public void VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc dest) {
    dest.copyLocal(new ArrayTypeLoc(JD$Move.INSTANCE, Source.castAs(DependentSizedArrayTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="(anonymous namespace)::TypeLocCopier::VisitDependentSizedExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public void VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(DependentSizedExtVectorTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="(anonymous namespace)::TypeLocCopier::VisitVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier18VisitVectorTypeLocEN5clang13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier18VisitVectorTypeLocEN5clang13VectorTypeLocE")
  //</editor-fold>
  public void VisitVectorTypeLoc(VectorTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(VectorTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="(anonymous namespace)::TypeLocCopier::VisitExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE")
  //</editor-fold>
  public void VisitExtVectorTypeLoc(ExtVectorTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(ExtVectorTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="(anonymous namespace)::TypeLocCopier::VisitFunctionProtoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE")
  //</editor-fold>
  public void VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc dest) {
    dest.copyLocal(new FunctionTypeLoc(JD$Move.INSTANCE, Source.castAs(FunctionProtoTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="(anonymous namespace)::TypeLocCopier::VisitFunctionNoProtoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public void VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc dest) {
    dest.copyLocal(new FunctionTypeLoc(JD$Move.INSTANCE, Source.castAs(FunctionNoProtoTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="(anonymous namespace)::TypeLocCopier::VisitUnresolvedUsingTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(UnresolvedUsingTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="(anonymous namespace)::TypeLocCopier::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public void VisitParenTypeLoc(ParenTypeLoc dest) {
    dest.copyLocal(Source.castAs(ParenTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="(anonymous namespace)::TypeLocCopier::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public void VisitTypedefTypeLoc(TypedefTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(TypedefTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="(anonymous namespace)::TypeLocCopier::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public void VisitAdjustedTypeLoc(AdjustedTypeLoc dest) {
    dest.copyLocal(Source.castAs(AdjustedTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="(anonymous namespace)::TypeLocCopier::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public void VisitDecayedTypeLoc(DecayedTypeLoc dest) {
    dest.copyLocal(new AdjustedTypeLoc(JD$Move.INSTANCE, Source.castAs(DecayedTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="(anonymous namespace)::TypeLocCopier::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public void VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc dest) {
    dest.copyLocal(Source.castAs(TypeOfExprTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="(anonymous namespace)::TypeLocCopier::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public void VisitTypeOfTypeLoc(TypeOfTypeLoc dest) {
    dest.copyLocal(Source.castAs(TypeOfTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="(anonymous namespace)::TypeLocCopier::VisitDecltypeTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE")
  //</editor-fold>
  public void VisitDecltypeTypeLoc(DecltypeTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(DecltypeTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="(anonymous namespace)::TypeLocCopier::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public void VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc dest) {
    dest.copyLocal(Source.castAs(UnaryTransformTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="(anonymous namespace)::TypeLocCopier::VisitRecordTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier18VisitRecordTypeLocEN5clang13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier18VisitRecordTypeLocEN5clang13RecordTypeLocE")
  //</editor-fold>
  public void VisitRecordTypeLoc(RecordTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(RecordTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="(anonymous namespace)::TypeLocCopier::VisitEnumTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier16VisitEnumTypeLocEN5clang11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier16VisitEnumTypeLocEN5clang11EnumTypeLocE")
  //</editor-fold>
  public void VisitEnumTypeLoc(EnumTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(EnumTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="(anonymous namespace)::TypeLocCopier::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public void VisitElaboratedTypeLoc(ElaboratedTypeLoc dest) {
    dest.copyLocal(Source.castAs(ElaboratedTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="(anonymous namespace)::TypeLocCopier::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public void VisitAttributedTypeLoc(AttributedTypeLoc dest) {
    dest.copyLocal(Source.castAs(AttributedTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="(anonymous namespace)::TypeLocCopier::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public void VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(TemplateTypeParmTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="(anonymous namespace)::TypeLocCopier::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(SubstTemplateTypeParmTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="(anonymous namespace)::TypeLocCopier::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(SubstTemplateTypeParmPackTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="(anonymous namespace)::TypeLocCopier::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc dest) {
    dest.copyLocal(Source.castAs(TemplateSpecializationTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="(anonymous namespace)::TypeLocCopier::VisitAutoTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier16VisitAutoTypeLocEN5clang11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier16VisitAutoTypeLocEN5clang11AutoTypeLocE")
  //</editor-fold>
  public void VisitAutoTypeLoc(AutoTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(AutoTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="(anonymous namespace)::TypeLocCopier::VisitInjectedClassNameTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE")
  //</editor-fold>
  public void VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc dest) {
    dest.copyLocal(new TypeSpecTypeLoc(JD$Move.INSTANCE, Source.castAs(InjectedClassNameTypeLoc.class)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="(anonymous namespace)::TypeLocCopier::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public void VisitDependentNameTypeLoc(DependentNameTypeLoc dest) {
    dest.copyLocal(Source.castAs(DependentNameTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="(anonymous namespace)::TypeLocCopier::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public void VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc dest) {
    dest.copyLocal(Source.castAs(DependentTemplateSpecializationTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="(anonymous namespace)::TypeLocCopier::VisitPackExpansionTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE")
  //</editor-fold>
  public void VisitPackExpansionTypeLoc(PackExpansionTypeLoc dest) {
    dest.copyLocal(Source.castAs(PackExpansionTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="(anonymous namespace)::TypeLocCopier::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectTypeLoc(ObjCObjectTypeLoc dest) {
    dest.copyLocal(Source.castAs(ObjCObjectTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="(anonymous namespace)::TypeLocCopier::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public void VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc dest) {
    dest.copyLocal(Source.castAs(ObjCInterfaceTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="(anonymous namespace)::TypeLocCopier::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public void VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc dest) {
    dest.copyLocal(Source.castAs(ObjCObjectPointerTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="(anonymous namespace)::TypeLocCopier::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public void VisitPipeTypeLoc(PipeTypeLoc dest) {
    dest.copyLocal(Source.castAs(PipeTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeLocCopier::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="(anonymous namespace)::TypeLocCopier::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_113TypeLocCopier18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_113TypeLocCopier18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public void VisitAtomicTypeLoc(AtomicTypeLoc dest) {
    dest.copyLocal(Source.castAs(AtomicTypeLoc.class));
  }

  
  @Override public String toString() {
    return "" + "Source=" + Source // NOI18N
              + super.toString(); // NOI18N
  }
}
