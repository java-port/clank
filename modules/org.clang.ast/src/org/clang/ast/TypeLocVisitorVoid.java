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

/*template <typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorVoid.h", line = 26,
 FQN="clang::TypeLocVisitorVoid", NM="_ZN5clang14TypeLocVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitorE")
//</editor-fold>
public interface/*class*/ TypeLocVisitorVoid</*typename*/ ImplClass extends TypeLocVisitorVoid<?>/*, = void*/>  {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::Visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorVoid.h", line = 29,
   FQN="clang::TypeLocVisitorVoid::Visit", NM="_ZN5clang14TypeLocVisitor5VisitENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor5VisitENS_7TypeLocE")
  //</editor-fold>
  public default/*interface*/ void Visit(TypeLoc TyLoc) {
    switch (TyLoc.getTypeLocClass()) {
     case Qualified:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitQualifiedTypeLoc(TyLoc.castAs(QualifiedTypeLoc.class));return;
     case Builtin:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBuiltinTypeLoc(TyLoc.castAs(BuiltinTypeLoc.class));return;
     case Complex:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitComplexTypeLoc(TyLoc.castAs(ComplexTypeLoc.class));return;
     case Pointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPointerTypeLoc(TyLoc.castAs(PointerTypeLoc.class));return;
     case BlockPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockPointerTypeLoc(TyLoc.castAs(BlockPointerTypeLoc.class));return;
     case LValueReference:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLValueReferenceTypeLoc(TyLoc.castAs(LValueReferenceTypeLoc.class));return;
     case RValueReference:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRValueReferenceTypeLoc(TyLoc.castAs(RValueReferenceTypeLoc.class));return;
     case MemberPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemberPointerTypeLoc(TyLoc.castAs(MemberPointerTypeLoc.class));return;
     case ConstantArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConstantArrayTypeLoc(TyLoc.castAs(ConstantArrayTypeLoc.class));return;
     case IncompleteArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIncompleteArrayTypeLoc(TyLoc.castAs(IncompleteArrayTypeLoc.class));return;
     case VariableArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVariableArrayTypeLoc(TyLoc.castAs(VariableArrayTypeLoc.class));return;
     case DependentSizedArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedArrayTypeLoc(TyLoc.castAs(DependentSizedArrayTypeLoc.class));return;
     case DependentSizedExtVector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedExtVectorTypeLoc(TyLoc.castAs(DependentSizedExtVectorTypeLoc.class));return;
     case Vector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorTypeLoc(TyLoc.castAs(VectorTypeLoc.class));return;
     case ExtVector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExtVectorTypeLoc(TyLoc.castAs(ExtVectorTypeLoc.class));return;
     case FunctionProto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionProtoTypeLoc(TyLoc.castAs(FunctionProtoTypeLoc.class));return;
     case FunctionNoProto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionNoProtoTypeLoc(TyLoc.castAs(FunctionNoProtoTypeLoc.class));return;
     case UnresolvedUsing:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingTypeLoc(TyLoc.castAs(UnresolvedUsingTypeLoc.class));return;
     case Paren:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenTypeLoc(TyLoc.castAs(ParenTypeLoc.class));return;
     case Typedef:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefTypeLoc(TyLoc.castAs(TypedefTypeLoc.class));return;
     case Adjusted:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedTypeLoc(TyLoc.castAs(AdjustedTypeLoc.class));return;
     case Decayed:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecayedTypeLoc(TyLoc.castAs(DecayedTypeLoc.class));return;
     case TypeOfExpr:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfExprTypeLoc(TyLoc.castAs(TypeOfExprTypeLoc.class));return;
     case TypeOf:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfTypeLoc(TyLoc.castAs(TypeOfTypeLoc.class));return;
     case Decltype:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecltypeTypeLoc(TyLoc.castAs(DecltypeTypeLoc.class));return;
     case UnaryTransform:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryTransformTypeLoc(TyLoc.castAs(UnaryTransformTypeLoc.class));return;
     case Record:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordTypeLoc(TyLoc.castAs(RecordTypeLoc.class));return;
     case Enum:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumTypeLoc(TyLoc.castAs(EnumTypeLoc.class));return;
     case Elaborated:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitElaboratedTypeLoc(TyLoc.castAs(ElaboratedTypeLoc.class));return;
     case Attributed:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAttributedTypeLoc(TyLoc.castAs(AttributedTypeLoc.class));return;
     case TemplateTypeParm:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTypeParmTypeLoc(TyLoc.castAs(TemplateTypeParmTypeLoc.class));return;
     case SubstTemplateTypeParm:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmTypeLoc(TyLoc.castAs(SubstTemplateTypeParmTypeLoc.class));return;
     case SubstTemplateTypeParmPack:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmPackTypeLoc(TyLoc.castAs(SubstTemplateTypeParmPackTypeLoc.class));return;
     case TemplateSpecialization:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateSpecializationTypeLoc(TyLoc.castAs(TemplateSpecializationTypeLoc.class));return;
     case Auto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAutoTypeLoc(TyLoc.castAs(AutoTypeLoc.class));return;
     case InjectedClassName:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitInjectedClassNameTypeLoc(TyLoc.castAs(InjectedClassNameTypeLoc.class));return;
     case DependentName:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentNameTypeLoc(TyLoc.castAs(DependentNameTypeLoc.class));return;
     case DependentTemplateSpecialization:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentTemplateSpecializationTypeLoc(TyLoc.castAs(DependentTemplateSpecializationTypeLoc.class));return;
     case PackExpansion:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPackExpansionTypeLoc(TyLoc.castAs(PackExpansionTypeLoc.class));return;
     case ObjCObject:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectTypeLoc(TyLoc.castAs(ObjCObjectTypeLoc.class));return;
     case ObjCInterface:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCInterfaceTypeLoc(TyLoc.castAs(ObjCInterfaceTypeLoc.class));return;
     case ObjCObjectPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectPointerTypeLoc(TyLoc.castAs(ObjCObjectPointerTypeLoc.class));return;
     case Pipe:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPipeTypeLoc(TyLoc.castAs(PipeTypeLoc.class));return;
     case Atomic:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAtomicTypeLoc(TyLoc.castAs(AtomicTypeLoc.class));return;
    }
    throw new llvm_unreachable("unexpected type loc class!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::Visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorVoid.h", line = 39,
   FQN="clang::TypeLocVisitorVoid::Visit", NM="_ZN5clang14TypeLocVisitor5VisitENS_13UnqualTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor5VisitENS_13UnqualTypeLocE")
  //</editor-fold>
  public default/*interface*/ void Visit(UnqualTypeLoc TyLoc) {
    switch (TyLoc.getTypeLocClass()) {
     case Qualified:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitQualifiedTypeLoc(TyLoc.castAs(QualifiedTypeLoc.class));return;
     case Builtin:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBuiltinTypeLoc(TyLoc.castAs(BuiltinTypeLoc.class));return;
     case Complex:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitComplexTypeLoc(TyLoc.castAs(ComplexTypeLoc.class));return;
     case Pointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPointerTypeLoc(TyLoc.castAs(PointerTypeLoc.class));return;
     case BlockPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockPointerTypeLoc(TyLoc.castAs(BlockPointerTypeLoc.class));return;
     case LValueReference:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLValueReferenceTypeLoc(TyLoc.castAs(LValueReferenceTypeLoc.class));return;
     case RValueReference:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRValueReferenceTypeLoc(TyLoc.castAs(RValueReferenceTypeLoc.class));return;
     case MemberPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemberPointerTypeLoc(TyLoc.castAs(MemberPointerTypeLoc.class));return;
     case ConstantArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConstantArrayTypeLoc(TyLoc.castAs(ConstantArrayTypeLoc.class));return;
     case IncompleteArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIncompleteArrayTypeLoc(TyLoc.castAs(IncompleteArrayTypeLoc.class));return;
     case VariableArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVariableArrayTypeLoc(TyLoc.castAs(VariableArrayTypeLoc.class));return;
     case DependentSizedArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedArrayTypeLoc(TyLoc.castAs(DependentSizedArrayTypeLoc.class));return;
     case DependentSizedExtVector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedExtVectorTypeLoc(TyLoc.castAs(DependentSizedExtVectorTypeLoc.class));return;
     case Vector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorTypeLoc(TyLoc.castAs(VectorTypeLoc.class));return;
     case ExtVector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExtVectorTypeLoc(TyLoc.castAs(ExtVectorTypeLoc.class));return;
     case FunctionProto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionProtoTypeLoc(TyLoc.castAs(FunctionProtoTypeLoc.class));return;
     case FunctionNoProto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionNoProtoTypeLoc(TyLoc.castAs(FunctionNoProtoTypeLoc.class));return;
     case UnresolvedUsing:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingTypeLoc(TyLoc.castAs(UnresolvedUsingTypeLoc.class));return;
     case Paren:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenTypeLoc(TyLoc.castAs(ParenTypeLoc.class));return;
     case Typedef:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefTypeLoc(TyLoc.castAs(TypedefTypeLoc.class));return;
     case Adjusted:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedTypeLoc(TyLoc.castAs(AdjustedTypeLoc.class));return;
     case Decayed:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecayedTypeLoc(TyLoc.castAs(DecayedTypeLoc.class));return;
     case TypeOfExpr:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfExprTypeLoc(TyLoc.castAs(TypeOfExprTypeLoc.class));return;
     case TypeOf:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfTypeLoc(TyLoc.castAs(TypeOfTypeLoc.class));return;
     case Decltype:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecltypeTypeLoc(TyLoc.castAs(DecltypeTypeLoc.class));return;
     case UnaryTransform:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryTransformTypeLoc(TyLoc.castAs(UnaryTransformTypeLoc.class));return;
     case Record:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordTypeLoc(TyLoc.castAs(RecordTypeLoc.class));return;
     case Enum:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumTypeLoc(TyLoc.castAs(EnumTypeLoc.class));return;
     case Elaborated:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitElaboratedTypeLoc(TyLoc.castAs(ElaboratedTypeLoc.class));return;
     case Attributed:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAttributedTypeLoc(TyLoc.castAs(AttributedTypeLoc.class));return;
     case TemplateTypeParm:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTypeParmTypeLoc(TyLoc.castAs(TemplateTypeParmTypeLoc.class));return;
     case SubstTemplateTypeParm:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmTypeLoc(TyLoc.castAs(SubstTemplateTypeParmTypeLoc.class));return;
     case SubstTemplateTypeParmPack:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmPackTypeLoc(TyLoc.castAs(SubstTemplateTypeParmPackTypeLoc.class));return;
     case TemplateSpecialization:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateSpecializationTypeLoc(TyLoc.castAs(TemplateSpecializationTypeLoc.class));return;
     case Auto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAutoTypeLoc(TyLoc.castAs(AutoTypeLoc.class));return;
     case InjectedClassName:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitInjectedClassNameTypeLoc(TyLoc.castAs(InjectedClassNameTypeLoc.class));return;
     case DependentName:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentNameTypeLoc(TyLoc.castAs(DependentNameTypeLoc.class));return;
     case DependentTemplateSpecialization:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentTemplateSpecializationTypeLoc(TyLoc.castAs(DependentTemplateSpecializationTypeLoc.class));return;
     case PackExpansion:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPackExpansionTypeLoc(TyLoc.castAs(PackExpansionTypeLoc.class));return;
     case ObjCObject:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectTypeLoc(TyLoc.castAs(ObjCObjectTypeLoc.class));return;
     case ObjCInterface:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCInterfaceTypeLoc(TyLoc.castAs(ObjCInterfaceTypeLoc.class));return;
     case ObjCObjectPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectPointerTypeLoc(TyLoc.castAs(ObjCObjectPointerTypeLoc.class));return;
     case Pipe:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPipeTypeLoc(TyLoc.castAs(PipeTypeLoc.class));return;
     case Atomic:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAtomicTypeLoc(TyLoc.castAs(AtomicTypeLoc.class));return;
    }
    throw new llvm_unreachable("unexpected type loc class!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitQualifiedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocNodes.def", line = 32,
   FQN="clang::TypeLocVisitorVoid::VisitQualifiedTypeLoc", NM="_ZN5clang14TypeLocVisitor21VisitQualifiedTypeLocENS_16QualifiedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor21VisitQualifiedTypeLocENS_16QualifiedTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitQualifiedTypeLoc(QualifiedTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitBuiltinTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="clang::TypeLocVisitorVoid::VisitBuiltinTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitBuiltinTypeLocENS_14BuiltinTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitBuiltinTypeLocENS_14BuiltinTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitBuiltinTypeLoc(BuiltinTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitComplexTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="clang::TypeLocVisitorVoid::VisitComplexTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitComplexTypeLocENS_14ComplexTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitComplexTypeLocENS_14ComplexTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitComplexTypeLoc(ComplexTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="clang::TypeLocVisitorVoid::VisitPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitPointerTypeLocENS_14PointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitPointerTypeLocENS_14PointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitPointerTypeLoc(PointerTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitBlockPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="clang::TypeLocVisitorVoid::VisitBlockPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor24VisitBlockPointerTypeLocENS_19BlockPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor24VisitBlockPointerTypeLocENS_19BlockPointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitBlockPointerTypeLoc(BlockPointerTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitReferenceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 66,
   FQN="clang::TypeLocVisitorVoid::VisitReferenceTypeLoc", NM="_ZN5clang14TypeLocVisitor21VisitReferenceTypeLocENS_16ReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor21VisitReferenceTypeLocENS_16ReferenceTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitReferenceTypeLoc(ReferenceTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitLValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="clang::TypeLocVisitorVoid::VisitLValueReferenceTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitLValueReferenceTypeLocENS_22LValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitLValueReferenceTypeLocENS_22LValueReferenceTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitLValueReferenceTypeLoc(LValueReferenceTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReferenceTypeLoc(TyLoc.castAs(ReferenceTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitRValueReferenceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="clang::TypeLocVisitorVoid::VisitRValueReferenceTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitRValueReferenceTypeLocENS_22RValueReferenceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitRValueReferenceTypeLocENS_22RValueReferenceTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitRValueReferenceTypeLoc(RValueReferenceTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReferenceTypeLoc(TyLoc.castAs(ReferenceTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitMemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="clang::TypeLocVisitorVoid::VisitMemberPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitMemberPointerTypeLocENS_20MemberPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitMemberPointerTypeLocENS_20MemberPointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitMemberPointerTypeLoc(MemberPointerTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 70,
   FQN="clang::TypeLocVisitorVoid::VisitArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor17VisitArrayTypeLocENS_12ArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor17VisitArrayTypeLocENS_12ArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitArrayTypeLoc(ArrayTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitConstantArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="clang::TypeLocVisitorVoid::VisitConstantArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitConstantArrayTypeLocENS_20ConstantArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitConstantArrayTypeLocENS_20ConstantArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitConstantArrayTypeLoc(ConstantArrayTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitIncompleteArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="clang::TypeLocVisitorVoid::VisitIncompleteArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitIncompleteArrayTypeLocENS_22IncompleteArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitIncompleteArrayTypeLocENS_22IncompleteArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitIncompleteArrayTypeLoc(IncompleteArrayTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitVariableArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="clang::TypeLocVisitorVoid::VisitVariableArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitVariableArrayTypeLocENS_20VariableArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitVariableArrayTypeLocENS_20VariableArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitVariableArrayTypeLoc(VariableArrayTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitDependentSizedArrayTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="clang::TypeLocVisitorVoid::VisitDependentSizedArrayTypeLoc", NM="_ZN5clang14TypeLocVisitor31VisitDependentSizedArrayTypeLocENS_26DependentSizedArrayTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor31VisitDependentSizedArrayTypeLocENS_26DependentSizedArrayTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentSizedArrayTypeLoc(DependentSizedArrayTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayTypeLoc(TyLoc.castAs(ArrayTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitDependentSizedExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="clang::TypeLocVisitorVoid::VisitDependentSizedExtVectorTypeLoc", NM="_ZN5clang14TypeLocVisitor35VisitDependentSizedExtVectorTypeLocENS_30DependentSizedExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor35VisitDependentSizedExtVectorTypeLocENS_30DependentSizedExtVectorTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentSizedExtVectorTypeLoc(DependentSizedExtVectorTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitVectorTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="clang::TypeLocVisitorVoid::VisitVectorTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitVectorTypeLocENS_13VectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitVectorTypeLocENS_13VectorTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitVectorTypeLoc(VectorTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitExtVectorTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="clang::TypeLocVisitorVoid::VisitExtVectorTypeLoc", NM="_ZN5clang14TypeLocVisitor21VisitExtVectorTypeLocENS_16ExtVectorTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor21VisitExtVectorTypeLocENS_16ExtVectorTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitExtVectorTypeLoc(ExtVectorTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorTypeLoc(TyLoc.castAs(VectorTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitFunctionTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 78,
   FQN="clang::TypeLocVisitorVoid::VisitFunctionTypeLoc", NM="_ZN5clang14TypeLocVisitor20VisitFunctionTypeLocENS_15FunctionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor20VisitFunctionTypeLocENS_15FunctionTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitFunctionTypeLoc(FunctionTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitFunctionProtoTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="clang::TypeLocVisitorVoid::VisitFunctionProtoTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitFunctionProtoTypeLocENS_20FunctionProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitFunctionProtoTypeLocENS_20FunctionProtoTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitFunctionProtoTypeLoc(FunctionProtoTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionTypeLoc(TyLoc.castAs(FunctionTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitFunctionNoProtoTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="clang::TypeLocVisitorVoid::VisitFunctionNoProtoTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitFunctionNoProtoTypeLocENS_22FunctionNoProtoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitFunctionNoProtoTypeLocENS_22FunctionNoProtoTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitFunctionNoProtoTypeLoc(FunctionNoProtoTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionTypeLoc(TyLoc.castAs(FunctionTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitUnresolvedUsingTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="clang::TypeLocVisitorVoid::VisitUnresolvedUsingTypeLoc", NM="_ZN5clang14TypeLocVisitor27VisitUnresolvedUsingTypeLocENS_22UnresolvedUsingTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor27VisitUnresolvedUsingTypeLocENS_22UnresolvedUsingTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitUnresolvedUsingTypeLoc(UnresolvedUsingTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitParenTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="clang::TypeLocVisitorVoid::VisitParenTypeLoc", NM="_ZN5clang14TypeLocVisitor17VisitParenTypeLocENS_12ParenTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor17VisitParenTypeLocENS_12ParenTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitParenTypeLoc(ParenTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTypedefTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="clang::TypeLocVisitorVoid::VisitTypedefTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitTypedefTypeLocENS_14TypedefTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitTypedefTypeLocENS_14TypedefTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTypedefTypeLoc(TypedefTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitAdjustedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="clang::TypeLocVisitorVoid::VisitAdjustedTypeLoc", NM="_ZN5clang14TypeLocVisitor20VisitAdjustedTypeLocENS_15AdjustedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor20VisitAdjustedTypeLocENS_15AdjustedTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitAdjustedTypeLoc(AdjustedTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitDecayedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="clang::TypeLocVisitorVoid::VisitDecayedTypeLoc", NM="_ZN5clang14TypeLocVisitor19VisitDecayedTypeLocENS_14DecayedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor19VisitDecayedTypeLocENS_14DecayedTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitDecayedTypeLoc(DecayedTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedTypeLoc(TyLoc.castAs(AdjustedTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="clang::TypeLocVisitorVoid::VisitTypeOfExprTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitTypeOfExprTypeLocENS_17TypeOfExprTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitTypeOfExprTypeLocENS_17TypeOfExprTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTypeOfExprTypeLoc(TypeOfExprTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTypeOfTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="clang::TypeLocVisitorVoid::VisitTypeOfTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitTypeOfTypeLocENS_13TypeOfTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitTypeOfTypeLocENS_13TypeOfTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTypeOfTypeLoc(TypeOfTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitDecltypeTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="clang::TypeLocVisitorVoid::VisitDecltypeTypeLoc", NM="_ZN5clang14TypeLocVisitor20VisitDecltypeTypeLocENS_15DecltypeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor20VisitDecltypeTypeLocENS_15DecltypeTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitDecltypeTypeLoc(DecltypeTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitUnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="clang::TypeLocVisitorVoid::VisitUnaryTransformTypeLoc", NM="_ZN5clang14TypeLocVisitor26VisitUnaryTransformTypeLocENS_21UnaryTransformTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor26VisitUnaryTransformTypeLocENS_21UnaryTransformTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitUnaryTransformTypeLoc(UnaryTransformTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTagTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 90,
   FQN="clang::TypeLocVisitorVoid::VisitTagTypeLoc", NM="_ZN5clang14TypeLocVisitor15VisitTagTypeLocENS_10TagTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor15VisitTagTypeLocENS_10TagTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTagTypeLoc(TagTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitRecordTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="clang::TypeLocVisitorVoid::VisitRecordTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitRecordTypeLocENS_13RecordTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitRecordTypeLocENS_13RecordTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitRecordTypeLoc(RecordTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagTypeLoc(TyLoc.castAs(TagTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitEnumTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="clang::TypeLocVisitorVoid::VisitEnumTypeLoc", NM="_ZN5clang14TypeLocVisitor16VisitEnumTypeLocENS_11EnumTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor16VisitEnumTypeLocENS_11EnumTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitEnumTypeLoc(EnumTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagTypeLoc(TyLoc.castAs(TagTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="clang::TypeLocVisitorVoid::VisitElaboratedTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitElaboratedTypeLocENS_17ElaboratedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitElaboratedTypeLocENS_17ElaboratedTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitElaboratedTypeLoc(ElaboratedTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitAttributedTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="clang::TypeLocVisitorVoid::VisitAttributedTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitAttributedTypeLocENS_17AttributedTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitAttributedTypeLocENS_17AttributedTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitAttributedTypeLoc(AttributedTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="clang::TypeLocVisitorVoid::VisitTemplateTypeParmTypeLoc", NM="_ZN5clang14TypeLocVisitor28VisitTemplateTypeParmTypeLocENS_23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor28VisitTemplateTypeParmTypeLocENS_23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitSubstTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="clang::TypeLocVisitorVoid::VisitSubstTemplateTypeParmTypeLoc", NM="_ZN5clang14TypeLocVisitor33VisitSubstTemplateTypeParmTypeLocENS_28SubstTemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor33VisitSubstTemplateTypeParmTypeLocENS_28SubstTemplateTypeParmTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitSubstTemplateTypeParmTypeLoc(SubstTemplateTypeParmTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitSubstTemplateTypeParmPackTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="clang::TypeLocVisitorVoid::VisitSubstTemplateTypeParmPackTypeLoc", NM="_ZN5clang14TypeLocVisitor37VisitSubstTemplateTypeParmPackTypeLocENS_32SubstTemplateTypeParmPackTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor37VisitSubstTemplateTypeParmPackTypeLocENS_32SubstTemplateTypeParmPackTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitSubstTemplateTypeParmPackTypeLoc(SubstTemplateTypeParmPackTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="clang::TypeLocVisitorVoid::VisitTemplateSpecializationTypeLoc", NM="_ZN5clang14TypeLocVisitor34VisitTemplateSpecializationTypeLocENS_29TemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor34VisitTemplateSpecializationTypeLocENS_29TemplateSpecializationTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTemplateSpecializationTypeLoc(TemplateSpecializationTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitAutoTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="clang::TypeLocVisitorVoid::VisitAutoTypeLoc", NM="_ZN5clang14TypeLocVisitor16VisitAutoTypeLocENS_11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor16VisitAutoTypeLocENS_11AutoTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitAutoTypeLoc(AutoTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitInjectedClassNameTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="clang::TypeLocVisitorVoid::VisitInjectedClassNameTypeLoc", NM="_ZN5clang14TypeLocVisitor29VisitInjectedClassNameTypeLocENS_24InjectedClassNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor29VisitInjectedClassNameTypeLocENS_24InjectedClassNameTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitInjectedClassNameTypeLoc(InjectedClassNameTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitDependentNameTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="clang::TypeLocVisitorVoid::VisitDependentNameTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitDependentNameTypeLocENS_20DependentNameTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitDependentNameTypeLocENS_20DependentNameTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentNameTypeLoc(DependentNameTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitDependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="clang::TypeLocVisitorVoid::VisitDependentTemplateSpecializationTypeLoc", NM="_ZN5clang14TypeLocVisitor43VisitDependentTemplateSpecializationTypeLocENS_38DependentTemplateSpecializationTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor43VisitDependentTemplateSpecializationTypeLocENS_38DependentTemplateSpecializationTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentTemplateSpecializationTypeLoc(DependentTemplateSpecializationTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitPackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="clang::TypeLocVisitorVoid::VisitPackExpansionTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitPackExpansionTypeLocENS_20PackExpansionTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitPackExpansionTypeLocENS_20PackExpansionTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitPackExpansionTypeLoc(PackExpansionTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="clang::TypeLocVisitorVoid::VisitObjCObjectTypeLoc", NM="_ZN5clang14TypeLocVisitor22VisitObjCObjectTypeLocENS_17ObjCObjectTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor22VisitObjCObjectTypeLocENS_17ObjCObjectTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitObjCObjectTypeLoc(ObjCObjectTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="clang::TypeLocVisitorVoid::VisitObjCInterfaceTypeLoc", NM="_ZN5clang14TypeLocVisitor25VisitObjCInterfaceTypeLocENS_20ObjCInterfaceTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor25VisitObjCInterfaceTypeLocENS_20ObjCInterfaceTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitObjCInterfaceTypeLoc(ObjCInterfaceTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectTypeLoc(TyLoc.castAs(ObjCObjectTypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitObjCObjectPointerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="clang::TypeLocVisitorVoid::VisitObjCObjectPointerTypeLoc", NM="_ZN5clang14TypeLocVisitor29VisitObjCObjectPointerTypeLocENS_24ObjCObjectPointerTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor29VisitObjCObjectPointerTypeLocENS_24ObjCObjectPointerTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitObjCObjectPointerTypeLoc(ObjCObjectPointerTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitPipeTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="clang::TypeLocVisitorVoid::VisitPipeTypeLoc", NM="_ZN5clang14TypeLocVisitor16VisitPipeTypeLocENS_11PipeTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor16VisitPipeTypeLocENS_11PipeTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitPipeTypeLoc(PipeTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitAtomicTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="clang::TypeLocVisitorVoid::VisitAtomicTypeLoc", NM="_ZN5clang14TypeLocVisitor18VisitAtomicTypeLocENS_13AtomicTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor18VisitAtomicTypeLocENS_13AtomicTypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitAtomicTypeLoc(AtomicTypeLoc TyLoc) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeLoc(TyLoc.castAs(TypeLoc.class));return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocVisitorVoid::VisitTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLocVisitorVoid.h", line = 55,
   FQN="clang::TypeLocVisitorVoid::VisitTypeLoc", NM="_ZN5clang14TypeLocVisitor12VisitTypeLocENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang14TypeLocVisitor12VisitTypeLocENS_7TypeLocE")
  //</editor-fold>
  public default/*interface*/ void VisitTypeLoc(TypeLoc TyLoc) {
    return;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default/*interface*/ void $TypeLocVisitor() { 
    /*for derived classes*/ 
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
