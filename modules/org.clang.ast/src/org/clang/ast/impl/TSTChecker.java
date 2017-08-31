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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 249,
 FQN="(anonymous namespace)::TSTChecker", NM="_ZN12_GLOBAL__N_110TSTCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTCheckerE")
//</editor-fold>
public class/*struct*/ TSTChecker implements /*public*/ TypeLocVisitorBool<TSTChecker> {
  // Overload resolution does the real work for us.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::isTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 251,
   FQN="(anonymous namespace)::TSTChecker::isTypeSpec", NM="_ZN12_GLOBAL__N_110TSTChecker10isTypeSpecEN5clang15TypeSpecTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker10isTypeSpecEN5clang15TypeSpecTypeLocE")
  //</editor-fold>
  public static boolean isTypeSpec(TypeSpecTypeLoc _) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::isTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 252,
   FQN="(anonymous namespace)::TSTChecker::isTypeSpec", NM="_ZN12_GLOBAL__N_110TSTChecker10isTypeSpecEN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker10isTypeSpecEN5clang7TypeLocE")
  //</editor-fold>
  public static boolean isTypeSpec(TypeLoc _) {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="(anonymous namespace)::TSTChecker::VisitQualifiedTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker21VisitQualifiedTypeLocEN5clang16QualifiedTypeLocE")
  //</editor-fold>
  public boolean VisitQualifiedTypeLoc(QualifiedTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="(anonymous namespace)::TSTChecker::VisitBuiltinTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker19VisitBuiltinTypeLocEN5clang14BuiltinTypeLocE")
  //</editor-fold>
  public boolean VisitBuiltinTypeLoc(BuiltinTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="(anonymous namespace)::TSTChecker::VisitComplexTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker19VisitComplexTypeLocEN5clang14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker19VisitComplexTypeLocEN5clang14ComplexTypeLocE")
  //</editor-fold>
  public boolean VisitComplexTypeLoc(ComplexTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="(anonymous namespace)::TSTChecker::VisitPointerTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker19VisitPointerTypeLocEN5clang14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker19VisitPointerTypeLocEN5clang14PointerTypeLocE")
  //</editor-fold>
  public boolean VisitPointerTypeLoc(PointerTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="(anonymous namespace)::TSTChecker::VisitBlockPointerTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker24VisitBlockPointerTypeLocEN5clang19BlockPointerTypeLocE")
  //</editor-fold>
  public boolean VisitBlockPointerTypeLoc(BlockPointerTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="(anonymous namespace)::TSTChecker::VisitLValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker27VisitLValueReferenceTypeLocEN5clang22LValueReferenceTypeLocE")
  //</editor-fold>
  public boolean VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="(anonymous namespace)::TSTChecker::VisitRValueReferenceTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker27VisitRValueReferenceTypeLocEN5clang22RValueReferenceTypeLocE")
  //</editor-fold>
  public boolean VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="(anonymous namespace)::TSTChecker::VisitMemberPointerTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitMemberPointerTypeLocEN5clang20MemberPointerTypeLocE")
  //</editor-fold>
  public boolean VisitMemberPointerTypeLoc(MemberPointerTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="(anonymous namespace)::TSTChecker::VisitConstantArrayTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitConstantArrayTypeLocEN5clang20ConstantArrayTypeLocE")
  //</editor-fold>
  public boolean VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="(anonymous namespace)::TSTChecker::VisitIncompleteArrayTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker27VisitIncompleteArrayTypeLocEN5clang22IncompleteArrayTypeLocE")
  //</editor-fold>
  public boolean VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="(anonymous namespace)::TSTChecker::VisitVariableArrayTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitVariableArrayTypeLocEN5clang20VariableArrayTypeLocE")
  //</editor-fold>
  public boolean VisitVariableArrayTypeLoc(VariableArrayTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="(anonymous namespace)::TSTChecker::VisitDependentSizedArrayTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker31VisitDependentSizedArrayTypeLocEN5clang26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public boolean VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="(anonymous namespace)::TSTChecker::VisitDependentSizedExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker35VisitDependentSizedExtVectorTypeLocEN5clang30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public boolean VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="(anonymous namespace)::TSTChecker::VisitVectorTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker18VisitVectorTypeLocEN5clang13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker18VisitVectorTypeLocEN5clang13VectorTypeLocE")
  //</editor-fold>
  public boolean VisitVectorTypeLoc(VectorTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="(anonymous namespace)::TSTChecker::VisitExtVectorTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker21VisitExtVectorTypeLocEN5clang16ExtVectorTypeLocE")
  //</editor-fold>
  public boolean VisitExtVectorTypeLoc(ExtVectorTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="(anonymous namespace)::TSTChecker::VisitFunctionProtoTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitFunctionProtoTypeLocEN5clang20FunctionProtoTypeLocE")
  //</editor-fold>
  public boolean VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="(anonymous namespace)::TSTChecker::VisitFunctionNoProtoTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker27VisitFunctionNoProtoTypeLocEN5clang22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public boolean VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="(anonymous namespace)::TSTChecker::VisitUnresolvedUsingTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker27VisitUnresolvedUsingTypeLocEN5clang22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public boolean VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="(anonymous namespace)::TSTChecker::VisitParenTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker17VisitParenTypeLocEN5clang12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker17VisitParenTypeLocEN5clang12ParenTypeLocE")
  //</editor-fold>
  public boolean VisitParenTypeLoc(ParenTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="(anonymous namespace)::TSTChecker::VisitTypedefTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker19VisitTypedefTypeLocEN5clang14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker19VisitTypedefTypeLocEN5clang14TypedefTypeLocE")
  //</editor-fold>
  public boolean VisitTypedefTypeLoc(TypedefTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="(anonymous namespace)::TSTChecker::VisitAdjustedTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker20VisitAdjustedTypeLocEN5clang15AdjustedTypeLocE")
  //</editor-fold>
  public boolean VisitAdjustedTypeLoc(AdjustedTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="(anonymous namespace)::TSTChecker::VisitDecayedTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker19VisitDecayedTypeLocEN5clang14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker19VisitDecayedTypeLocEN5clang14DecayedTypeLocE")
  //</editor-fold>
  public boolean VisitDecayedTypeLoc(DecayedTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="(anonymous namespace)::TSTChecker::VisitTypeOfExprTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker22VisitTypeOfExprTypeLocEN5clang17TypeOfExprTypeLocE")
  //</editor-fold>
  public boolean VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="(anonymous namespace)::TSTChecker::VisitTypeOfTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker18VisitTypeOfTypeLocEN5clang13TypeOfTypeLocE")
  //</editor-fold>
  public boolean VisitTypeOfTypeLoc(TypeOfTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="(anonymous namespace)::TSTChecker::VisitDecltypeTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker20VisitDecltypeTypeLocEN5clang15DecltypeTypeLocE")
  //</editor-fold>
  public boolean VisitDecltypeTypeLoc(DecltypeTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="(anonymous namespace)::TSTChecker::VisitUnaryTransformTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker26VisitUnaryTransformTypeLocEN5clang21UnaryTransformTypeLocE")
  //</editor-fold>
  public boolean VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="(anonymous namespace)::TSTChecker::VisitRecordTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker18VisitRecordTypeLocEN5clang13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker18VisitRecordTypeLocEN5clang13RecordTypeLocE")
  //</editor-fold>
  public boolean VisitRecordTypeLoc(RecordTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="(anonymous namespace)::TSTChecker::VisitEnumTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker16VisitEnumTypeLocEN5clang11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker16VisitEnumTypeLocEN5clang11EnumTypeLocE")
  //</editor-fold>
  public boolean VisitEnumTypeLoc(EnumTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="(anonymous namespace)::TSTChecker::VisitElaboratedTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker22VisitElaboratedTypeLocEN5clang17ElaboratedTypeLocE")
  //</editor-fold>
  public boolean VisitElaboratedTypeLoc(ElaboratedTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="(anonymous namespace)::TSTChecker::VisitAttributedTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker22VisitAttributedTypeLocEN5clang17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker22VisitAttributedTypeLocEN5clang17AttributedTypeLocE")
  //</editor-fold>
  public boolean VisitAttributedTypeLoc(AttributedTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="(anonymous namespace)::TSTChecker::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public boolean VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="(anonymous namespace)::TSTChecker::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker33VisitSubstTemplateTypeParmTypeLocEN5clang28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public boolean VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="(anonymous namespace)::TSTChecker::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker37VisitSubstTemplateTypeParmPackTypeLocEN5clang32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public boolean VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="(anonymous namespace)::TSTChecker::VisitTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker34VisitTemplateSpecializationTypeLocEN5clang29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public boolean VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="(anonymous namespace)::TSTChecker::VisitAutoTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker16VisitAutoTypeLocEN5clang11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker16VisitAutoTypeLocEN5clang11AutoTypeLocE")
  //</editor-fold>
  public boolean VisitAutoTypeLoc(AutoTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="(anonymous namespace)::TSTChecker::VisitInjectedClassNameTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker29VisitInjectedClassNameTypeLocEN5clang24InjectedClassNameTypeLocE")
  //</editor-fold>
  public boolean VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TyLoc) {
    return isTypeSpec(new TypeSpecTypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="(anonymous namespace)::TSTChecker::VisitDependentNameTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitDependentNameTypeLocEN5clang20DependentNameTypeLocE")
  //</editor-fold>
  public boolean VisitDependentNameTypeLoc(DependentNameTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="(anonymous namespace)::TSTChecker::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker43VisitDependentTemplateSpecializationTypeLocEN5clang38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public boolean VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="(anonymous namespace)::TSTChecker::VisitPackExpansionTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitPackExpansionTypeLocEN5clang20PackExpansionTypeLocE")
  //</editor-fold>
  public boolean VisitPackExpansionTypeLoc(PackExpansionTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="(anonymous namespace)::TSTChecker::VisitObjCObjectTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker22VisitObjCObjectTypeLocEN5clang17ObjCObjectTypeLocE")
  //</editor-fold>
  public boolean VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="(anonymous namespace)::TSTChecker::VisitObjCInterfaceTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker25VisitObjCInterfaceTypeLocEN5clang20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public boolean VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="(anonymous namespace)::TSTChecker::VisitObjCObjectPointerTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker29VisitObjCObjectPointerTypeLocEN5clang24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public boolean VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="(anonymous namespace)::TSTChecker::VisitPipeTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker16VisitPipeTypeLocEN5clang11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker16VisitPipeTypeLocEN5clang11PipeTypeLocE")
  //</editor-fold>
  public boolean VisitPipeTypeLoc(PipeTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TSTChecker::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="(anonymous namespace)::TSTChecker::VisitAtomicTypeLoc", NM="_ZN12_GLOBAL__N_110TSTChecker18VisitAtomicTypeLocEN5clang13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN12_GLOBAL__N_110TSTChecker18VisitAtomicTypeLocEN5clang13AtomicTypeLocE")
  //</editor-fold>
  public boolean VisitAtomicTypeLoc(AtomicTypeLoc TyLoc) {
    return isTypeSpec(new TypeLoc(TyLoc));
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
