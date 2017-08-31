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

package org.clang.ast;

import org.clank.support.*;
import org.llvm.support.*;

/*template <typename ImplClass, typename RetTy = bool> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorBool.h", line = 26,
 FQN="clang::TypeLocVisitorBool", NM="_ZN5clang14TypeLocVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitorE")
//</editor-fold>
public interface/*class*/ TypeLocVisitorBool</*typename*/ ImplClass extends TypeLocVisitorBool<?>/*, = bool*/>  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::Visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorBool.h", line = 29,
   FQN="clang::TypeLocVisitorBool::Visit", NM="_ZN5clang14TypeLocVisitor5VisitENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor5VisitENS_7TypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean Visit(TypeLoc TyLoc) {
    switch (TyLoc.getTypeLocClass()) {
     case Qualified:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitQualifiedTypeLoc(TyLoc.castAs(QualifiedTypeLoc.class));
     case Builtin:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBuiltinTypeLoc(TyLoc.castAs(BuiltinTypeLoc.class));
     case Complex:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitComplexTypeLoc(TyLoc.castAs(ComplexTypeLoc.class));
     case Pointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPointerTypeLoc(TyLoc.castAs(PointerTypeLoc.class));
     case BlockPointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockPointerTypeLoc(TyLoc.castAs(BlockPointerTypeLoc.class));
     case LValueReference:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLValueReferenceTypeLoc(TyLoc.castAs(LValueReferenceTypeLoc.class));
     case RValueReference:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRValueReferenceTypeLoc(TyLoc.castAs(RValueReferenceTypeLoc.class));
     case MemberPointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemberPointerTypeLoc(TyLoc.castAs(MemberPointerTypeLoc.class));
     case ConstantArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConstantArrayTypeLoc(TyLoc.castAs(ConstantArrayTypeLoc.class));
     case IncompleteArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIncompleteArrayTypeLoc(TyLoc.castAs(IncompleteArrayTypeLoc.class));
     case VariableArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVariableArrayTypeLoc(TyLoc.castAs(VariableArrayTypeLoc.class));
     case DependentSizedArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedArrayTypeLoc(TyLoc.castAs(DependentSizedArrayTypeLoc.class));
     case DependentSizedExtVector:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedExtVectorTypeLoc(TyLoc.castAs(DependentSizedExtVectorTypeLoc.class));
     case Vector:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorTypeLoc(TyLoc.castAs(VectorTypeLoc.class));
     case ExtVector:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExtVectorTypeLoc(TyLoc.castAs(ExtVectorTypeLoc.class));
     case FunctionProto:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionProtoTypeLoc(TyLoc.castAs(FunctionProtoTypeLoc.class));
     case FunctionNoProto:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionNoProtoTypeLoc(TyLoc.castAs(FunctionNoProtoTypeLoc.class));
     case UnresolvedUsing:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingTypeLoc(TyLoc.castAs(UnresolvedUsingTypeLoc.class));
     case Paren:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenTypeLoc(TyLoc.castAs(ParenTypeLoc.class));
     case Typedef:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefTypeLoc(TyLoc.castAs(TypedefTypeLoc.class));
     case Adjusted:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedTypeLoc(TyLoc.castAs(AdjustedTypeLoc.class));
     case Decayed:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecayedTypeLoc(TyLoc.castAs(DecayedTypeLoc.class));
     case TypeOfExpr:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfExprTypeLoc(TyLoc.castAs(TypeOfExprTypeLoc.class));
     case TypeOf:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfTypeLoc(TyLoc.castAs(TypeOfTypeLoc.class));
     case Decltype:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecltypeTypeLoc(TyLoc.castAs(DecltypeTypeLoc.class));
     case UnaryTransform:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryTransformTypeLoc(TyLoc.castAs(UnaryTransformTypeLoc.class));
     case Record:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordTypeLoc(TyLoc.castAs(RecordTypeLoc.class));
     case Enum:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumTypeLoc(TyLoc.castAs(EnumTypeLoc.class));
     case Elaborated:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitElaboratedTypeLoc(TyLoc.castAs(ElaboratedTypeLoc.class));
     case Attributed:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAttributedTypeLoc(TyLoc.castAs(AttributedTypeLoc.class));
     case TemplateTypeParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTypeParmTypeLoc(TyLoc.castAs(TemplateTypeParmTypeLoc.class));
     case SubstTemplateTypeParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmTypeLoc(TyLoc.castAs(SubstTemplateTypeParmTypeLoc.class));
     case SubstTemplateTypeParmPack:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmPackTypeLoc(TyLoc.castAs(SubstTemplateTypeParmPackTypeLoc.class));
     case TemplateSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateSpecializationTypeLoc(TyLoc.castAs(TemplateSpecializationTypeLoc.class));
     case Auto:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAutoTypeLoc(TyLoc.castAs(AutoTypeLoc.class));
     case InjectedClassName:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitInjectedClassNameTypeLoc(TyLoc.castAs(InjectedClassNameTypeLoc.class));
     case DependentName:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentNameTypeLoc(TyLoc.castAs(DependentNameTypeLoc.class));
     case DependentTemplateSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentTemplateSpecializationTypeLoc(TyLoc.castAs(DependentTemplateSpecializationTypeLoc.class));
     case PackExpansion:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPackExpansionTypeLoc(TyLoc.castAs(PackExpansionTypeLoc.class));
     case ObjCObject:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectTypeLoc(TyLoc.castAs(ObjCObjectTypeLoc.class));
     case ObjCInterface:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCInterfaceTypeLoc(TyLoc.castAs(ObjCInterfaceTypeLoc.class));
     case ObjCObjectPointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectPointerTypeLoc(TyLoc.castAs(ObjCObjectPointerTypeLoc.class));
     case Pipe:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPipeTypeLoc(TyLoc.castAs(PipeTypeLoc.class));
     case Atomic:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAtomicTypeLoc(TyLoc.castAs(AtomicTypeLoc.class));
    }
    throw new llvm_unreachable("unexpected type loc class!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::Visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorBool.h", line = 39,
   FQN="clang::TypeLocVisitorBool::Visit", NM="_ZN5clang14TypeLocVisitor5VisitENS_13UnqualTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor5VisitENS_13UnqualTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean Visit(UnqualTypeLoc TyLoc) {
    switch (TyLoc.getTypeLocClass()) {
     case Qualified:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitQualifiedTypeLoc(TyLoc.castAs(QualifiedTypeLoc.class));
     case Builtin:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBuiltinTypeLoc(TyLoc.castAs(BuiltinTypeLoc.class));
     case Complex:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitComplexTypeLoc(TyLoc.castAs(ComplexTypeLoc.class));
     case Pointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPointerTypeLoc(TyLoc.castAs(PointerTypeLoc.class));
     case BlockPointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockPointerTypeLoc(TyLoc.castAs(BlockPointerTypeLoc.class));
     case LValueReference:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLValueReferenceTypeLoc(TyLoc.castAs(LValueReferenceTypeLoc.class));
     case RValueReference:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRValueReferenceTypeLoc(TyLoc.castAs(RValueReferenceTypeLoc.class));
     case MemberPointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemberPointerTypeLoc(TyLoc.castAs(MemberPointerTypeLoc.class));
     case ConstantArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConstantArrayTypeLoc(TyLoc.castAs(ConstantArrayTypeLoc.class));
     case IncompleteArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIncompleteArrayTypeLoc(TyLoc.castAs(IncompleteArrayTypeLoc.class));
     case VariableArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVariableArrayTypeLoc(TyLoc.castAs(VariableArrayTypeLoc.class));
     case DependentSizedArray:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedArrayTypeLoc(TyLoc.castAs(DependentSizedArrayTypeLoc.class));
     case DependentSizedExtVector:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedExtVectorTypeLoc(TyLoc.castAs(DependentSizedExtVectorTypeLoc.class));
     case Vector:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorTypeLoc(TyLoc.castAs(VectorTypeLoc.class));
     case ExtVector:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExtVectorTypeLoc(TyLoc.castAs(ExtVectorTypeLoc.class));
     case FunctionProto:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionProtoTypeLoc(TyLoc.castAs(FunctionProtoTypeLoc.class));
     case FunctionNoProto:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionNoProtoTypeLoc(TyLoc.castAs(FunctionNoProtoTypeLoc.class));
     case UnresolvedUsing:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingTypeLoc(TyLoc.castAs(UnresolvedUsingTypeLoc.class));
     case Paren:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenTypeLoc(TyLoc.castAs(ParenTypeLoc.class));
     case Typedef:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefTypeLoc(TyLoc.castAs(TypedefTypeLoc.class));
     case Adjusted:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedTypeLoc(TyLoc.castAs(AdjustedTypeLoc.class));
     case Decayed:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecayedTypeLoc(TyLoc.castAs(DecayedTypeLoc.class));
     case TypeOfExpr:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfExprTypeLoc(TyLoc.castAs(TypeOfExprTypeLoc.class));
     case TypeOf:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfTypeLoc(TyLoc.castAs(TypeOfTypeLoc.class));
     case Decltype:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecltypeTypeLoc(TyLoc.castAs(DecltypeTypeLoc.class));
     case UnaryTransform:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryTransformTypeLoc(TyLoc.castAs(UnaryTransformTypeLoc.class));
     case Record:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordTypeLoc(TyLoc.castAs(RecordTypeLoc.class));
     case Enum:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumTypeLoc(TyLoc.castAs(EnumTypeLoc.class));
     case Elaborated:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitElaboratedTypeLoc(TyLoc.castAs(ElaboratedTypeLoc.class));
     case Attributed:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAttributedTypeLoc(TyLoc.castAs(AttributedTypeLoc.class));
     case TemplateTypeParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTypeParmTypeLoc(TyLoc.castAs(TemplateTypeParmTypeLoc.class));
     case SubstTemplateTypeParm:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmTypeLoc(TyLoc.castAs(SubstTemplateTypeParmTypeLoc.class));
     case SubstTemplateTypeParmPack:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmPackTypeLoc(TyLoc.castAs(SubstTemplateTypeParmPackTypeLoc.class));
     case TemplateSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateSpecializationTypeLoc(TyLoc.castAs(TemplateSpecializationTypeLoc.class));
     case Auto:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAutoTypeLoc(TyLoc.castAs(AutoTypeLoc.class));
     case InjectedClassName:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitInjectedClassNameTypeLoc(TyLoc.castAs(InjectedClassNameTypeLoc.class));
     case DependentName:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentNameTypeLoc(TyLoc.castAs(DependentNameTypeLoc.class));
     case DependentTemplateSpecialization:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentTemplateSpecializationTypeLoc(TyLoc.castAs(DependentTemplateSpecializationTypeLoc.class));
     case PackExpansion:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPackExpansionTypeLoc(TyLoc.castAs(PackExpansionTypeLoc.class));
     case ObjCObject:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectTypeLoc(TyLoc.castAs(ObjCObjectTypeLoc.class));
     case ObjCInterface:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCInterfaceTypeLoc(TyLoc.castAs(ObjCInterfaceTypeLoc.class));
     case ObjCObjectPointer:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectPointerTypeLoc(TyLoc.castAs(ObjCObjectPointerTypeLoc.class));
     case Pipe:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPipeTypeLoc(TyLoc.castAs(PipeTypeLoc.class));
     case Atomic:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAtomicTypeLoc(TyLoc.castAs(AtomicTypeLoc.class));
    }
    throw new llvm_unreachable("unexpected type loc class!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="clang::TypeLocVisitorBool::VisitQualifiedTypeLoc", NM="_ZN5clang14TypeLocVisitor21VisitQualifiedTypeLocENS_16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor21VisitQualifiedTypeLocENS_16QualifiedTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitQualifiedTypeLoc(QualifiedTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="clang::TypeLocVisitorBool::VisitBuiltinTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitBuiltinTypeLocENS_14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitBuiltinTypeLocENS_14BuiltinTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitBuiltinTypeLoc(BuiltinTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="clang::TypeLocVisitorBool::VisitComplexTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitComplexTypeLocENS_14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitComplexTypeLocENS_14ComplexTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitComplexTypeLoc(ComplexTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="clang::TypeLocVisitorBool::VisitPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitPointerTypeLocENS_14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitPointerTypeLocENS_14PointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitPointerTypeLoc(PointerTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="clang::TypeLocVisitorBool::VisitBlockPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor24VisitBlockPointerTypeLocENS_19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor24VisitBlockPointerTypeLocENS_19BlockPointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitBlockPointerTypeLoc(BlockPointerTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitReferenceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 66,
   FQN="clang::TypeLocVisitorBool::VisitReferenceTypeLoc", NM="_ZN5clang14TypeLocVisitor21VisitReferenceTypeLocENS_16ReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor21VisitReferenceTypeLocENS_16ReferenceTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitReferenceTypeLoc(ReferenceTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="clang::TypeLocVisitorBool::VisitLValueReferenceTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitLValueReferenceTypeLocENS_22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitLValueReferenceTypeLocENS_22LValueReferenceTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReferenceTypeLoc(TyLoc.castAs(ReferenceTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="clang::TypeLocVisitorBool::VisitRValueReferenceTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitRValueReferenceTypeLocENS_22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitRValueReferenceTypeLocENS_22RValueReferenceTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReferenceTypeLoc(TyLoc.castAs(ReferenceTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="clang::TypeLocVisitorBool::VisitMemberPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitMemberPointerTypeLocENS_20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitMemberPointerTypeLocENS_20MemberPointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitMemberPointerTypeLoc(MemberPointerTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 70,
   FQN="clang::TypeLocVisitorBool::VisitArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor17VisitArrayTypeLocENS_12ArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor17VisitArrayTypeLocENS_12ArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitArrayTypeLoc(ArrayTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="clang::TypeLocVisitorBool::VisitConstantArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitConstantArrayTypeLocENS_20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitConstantArrayTypeLocENS_20ConstantArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="clang::TypeLocVisitorBool::VisitIncompleteArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitIncompleteArrayTypeLocENS_22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitIncompleteArrayTypeLocENS_22IncompleteArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="clang::TypeLocVisitorBool::VisitVariableArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitVariableArrayTypeLocENS_20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitVariableArrayTypeLocENS_20VariableArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitVariableArrayTypeLoc(VariableArrayTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="clang::TypeLocVisitorBool::VisitDependentSizedArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor31VisitDependentSizedArrayTypeLocENS_26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor31VisitDependentSizedArrayTypeLocENS_26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="clang::TypeLocVisitorBool::VisitDependentSizedExtVectorTypeLoc", NM="_ZN5clang14TypeLocVisitor35VisitDependentSizedExtVectorTypeLocENS_30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor35VisitDependentSizedExtVectorTypeLocENS_30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="clang::TypeLocVisitorBool::VisitVectorTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitVectorTypeLocENS_13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitVectorTypeLocENS_13VectorTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitVectorTypeLoc(VectorTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="clang::TypeLocVisitorBool::VisitExtVectorTypeLoc", NM="_ZN5clang14TypeLocVisitor21VisitExtVectorTypeLocENS_16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor21VisitExtVectorTypeLocENS_16ExtVectorTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitExtVectorTypeLoc(ExtVectorTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorTypeLoc(TyLoc.castAs(VectorTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitFunctionTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 78,
   FQN="clang::TypeLocVisitorBool::VisitFunctionTypeLoc", NM="_ZN5clang14TypeLocVisitor20VisitFunctionTypeLocENS_15FunctionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor20VisitFunctionTypeLocENS_15FunctionTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitFunctionTypeLoc(FunctionTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="clang::TypeLocVisitorBool::VisitFunctionProtoTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitFunctionProtoTypeLocENS_20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitFunctionProtoTypeLocENS_20FunctionProtoTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionTypeLoc(TyLoc.castAs(FunctionTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="clang::TypeLocVisitorBool::VisitFunctionNoProtoTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitFunctionNoProtoTypeLocENS_22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitFunctionNoProtoTypeLocENS_22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionTypeLoc(TyLoc.castAs(FunctionTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="clang::TypeLocVisitorBool::VisitUnresolvedUsingTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitUnresolvedUsingTypeLocENS_22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitUnresolvedUsingTypeLocENS_22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="clang::TypeLocVisitorBool::VisitParenTypeLoc", NM="_ZN5clang14TypeLocVisitor17VisitParenTypeLocENS_12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor17VisitParenTypeLocENS_12ParenTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitParenTypeLoc(ParenTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="clang::TypeLocVisitorBool::VisitTypedefTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitTypedefTypeLocENS_14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitTypedefTypeLocENS_14TypedefTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTypedefTypeLoc(TypedefTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="clang::TypeLocVisitorBool::VisitAdjustedTypeLoc", NM="_ZN5clang14TypeLocVisitor20VisitAdjustedTypeLocENS_15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor20VisitAdjustedTypeLocENS_15AdjustedTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitAdjustedTypeLoc(AdjustedTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="clang::TypeLocVisitorBool::VisitDecayedTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitDecayedTypeLocENS_14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitDecayedTypeLocENS_14DecayedTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitDecayedTypeLoc(DecayedTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedTypeLoc(TyLoc.castAs(AdjustedTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="clang::TypeLocVisitorBool::VisitTypeOfExprTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitTypeOfExprTypeLocENS_17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitTypeOfExprTypeLocENS_17TypeOfExprTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="clang::TypeLocVisitorBool::VisitTypeOfTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitTypeOfTypeLocENS_13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitTypeOfTypeLocENS_13TypeOfTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTypeOfTypeLoc(TypeOfTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="clang::TypeLocVisitorBool::VisitDecltypeTypeLoc", NM="_ZN5clang14TypeLocVisitor20VisitDecltypeTypeLocENS_15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor20VisitDecltypeTypeLocENS_15DecltypeTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitDecltypeTypeLoc(DecltypeTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="clang::TypeLocVisitorBool::VisitUnaryTransformTypeLoc", NM="_ZN5clang14TypeLocVisitor26VisitUnaryTransformTypeLocENS_21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor26VisitUnaryTransformTypeLocENS_21UnaryTransformTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTagTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 90,
   FQN="clang::TypeLocVisitorBool::VisitTagTypeLoc", NM="_ZN5clang14TypeLocVisitor15VisitTagTypeLocENS_10TagTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor15VisitTagTypeLocENS_10TagTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTagTypeLoc(TagTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="clang::TypeLocVisitorBool::VisitRecordTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitRecordTypeLocENS_13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitRecordTypeLocENS_13RecordTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitRecordTypeLoc(RecordTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagTypeLoc(TyLoc.castAs(TagTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="clang::TypeLocVisitorBool::VisitEnumTypeLoc", NM="_ZN5clang14TypeLocVisitor16VisitEnumTypeLocENS_11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor16VisitEnumTypeLocENS_11EnumTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitEnumTypeLoc(EnumTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagTypeLoc(TyLoc.castAs(TagTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="clang::TypeLocVisitorBool::VisitElaboratedTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitElaboratedTypeLocENS_17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitElaboratedTypeLocENS_17ElaboratedTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitElaboratedTypeLoc(ElaboratedTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="clang::TypeLocVisitorBool::VisitAttributedTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitAttributedTypeLocENS_17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitAttributedTypeLocENS_17AttributedTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitAttributedTypeLoc(AttributedTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="clang::TypeLocVisitorBool::VisitTemplateTypeParmTypeLoc", NM="_ZN5clang14TypeLocVisitor28VisitTemplateTypeParmTypeLocENS_23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor28VisitTemplateTypeParmTypeLocENS_23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="clang::TypeLocVisitorBool::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN5clang14TypeLocVisitor33VisitSubstTemplateTypeParmTypeLocENS_28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor33VisitSubstTemplateTypeParmTypeLocENS_28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="clang::TypeLocVisitorBool::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN5clang14TypeLocVisitor37VisitSubstTemplateTypeParmPackTypeLocENS_32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor37VisitSubstTemplateTypeParmPackTypeLocENS_32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="clang::TypeLocVisitorBool::VisitTemplateSpecializationTypeLoc", NM="_ZN5clang14TypeLocVisitor34VisitTemplateSpecializationTypeLocENS_29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor34VisitTemplateSpecializationTypeLocENS_29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="clang::TypeLocVisitorBool::VisitAutoTypeLoc", NM="_ZN5clang14TypeLocVisitor16VisitAutoTypeLocENS_11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor16VisitAutoTypeLocENS_11AutoTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitAutoTypeLoc(AutoTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="clang::TypeLocVisitorBool::VisitInjectedClassNameTypeLoc", NM="_ZN5clang14TypeLocVisitor29VisitInjectedClassNameTypeLocENS_24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor29VisitInjectedClassNameTypeLocENS_24InjectedClassNameTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="clang::TypeLocVisitorBool::VisitDependentNameTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitDependentNameTypeLocENS_20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitDependentNameTypeLocENS_20DependentNameTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitDependentNameTypeLoc(DependentNameTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="clang::TypeLocVisitorBool::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN5clang14TypeLocVisitor43VisitDependentTemplateSpecializationTypeLocENS_38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor43VisitDependentTemplateSpecializationTypeLocENS_38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="clang::TypeLocVisitorBool::VisitPackExpansionTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitPackExpansionTypeLocENS_20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitPackExpansionTypeLocENS_20PackExpansionTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitPackExpansionTypeLoc(PackExpansionTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="clang::TypeLocVisitorBool::VisitObjCObjectTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitObjCObjectTypeLocENS_17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitObjCObjectTypeLocENS_17ObjCObjectTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="clang::TypeLocVisitorBool::VisitObjCInterfaceTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitObjCInterfaceTypeLocENS_20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitObjCInterfaceTypeLocENS_20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectTypeLoc(TyLoc.castAs(ObjCObjectTypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="clang::TypeLocVisitorBool::VisitObjCObjectPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor29VisitObjCObjectPointerTypeLocENS_24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor29VisitObjCObjectPointerTypeLocENS_24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="clang::TypeLocVisitorBool::VisitPipeTypeLoc", NM="_ZN5clang14TypeLocVisitor16VisitPipeTypeLocENS_11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor16VisitPipeTypeLocENS_11PipeTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitPipeTypeLoc(PipeTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="clang::TypeLocVisitorBool::VisitAtomicTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitAtomicTypeLocENS_13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitAtomicTypeLocENS_13AtomicTypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitAtomicTypeLoc(AtomicTypeLoc TyLoc) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorBool::VisitTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorBool.h", line = 55,
   FQN="clang::TypeLocVisitorBool::VisitTypeLoc", NM="_ZN5clang14TypeLocVisitor12VisitTypeLocENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor12VisitTypeLocENS_7TypeLocE")
  //</editor-fold>
  public default/*interface*/ boolean VisitTypeLoc(TypeLoc TyLoc) {
    return false;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default/*interface*/ void $TypeLocVisitor() { 
    /*for derived classes*/ 
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
