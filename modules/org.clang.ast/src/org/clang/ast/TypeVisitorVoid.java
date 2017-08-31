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


/// \brief An operation on a type.
///
/// \tparam ImplClass Class implementing the operation. Must be inherited from
///         TypeVisitor.
/// \tparam void %Type of result produced by the operation.
///
/// The class implements polymorphic operation on an object of type derived
/// from Type. The operation is performed by calling method Visit. It then
/// dispatches the call to function \c VisitFooType, if actual argument type
/// is \c FooType.
///
/// The class implements static polymorphism using Curiously Recurring
/// Template Pattern. It is designed to be a base class for some concrete
/// class:
///
/// \code
///     class SomeVisitor : public TypeVisitor<SomeVisitor,sometype> { ... };
///     ...
///     Type *atype = ...
///     ...
///     SomeVisitor avisitor;
///     sometype result = avisitor.Visit(atype);
/// \endcode
///
/// Actual treatment is made by methods of the derived class, TypeVisitor only
/// dispatches call to the appropriate method. If the implementation class
/// \c ImplClass provides specific action for some type, say
/// \c ConstantArrayType, it should define method
/// <tt>VisitConstantArrayType(const ConstantArrayType*)</tt>. Otherwise
/// \c TypeVisitor dispatches call to the method that handles parent type. In
/// this example handlers are tried in the sequence:
///
/// \li <tt>ImplClass::VisitConstantArrayType(const ConstantArrayType*)</tt>
/// \li <tt>ImplClass::VisitArrayType(const ArrayType*)</tt>
/// \li <tt>ImplClass::VisitType(const Type*)</tt>
/// \li <tt>TypeVisitor::VisitType(const Type*)</tt>
///
/// The first function of this sequence that is defined will handle object of
/// type \c ConstantArrayType.
/*template <typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeVisitor.h", line = 64,
 FQN="clang::TypeVisitor", NM="_ZN5clang11TypeVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitorE")
//</editor-fold>
public interface/*class*/ TypeVisitorVoid</*typename*/ ImplClass extends TypeVisitorVoid<?>>  {
/*public:*/
  default void $TypeVisitor() {}
  /// \brief Performs the operation associated with this visitor object.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::Visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeVisitor.h", line = 69,
   FQN="clang::TypeVisitor::Visit", NM="_ZN5clang11TypeVisitor5VisitEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor5VisitEPKNS_4TypeE")
  //</editor-fold>
  public default/*interface*/ void Visit(/*const*/ Type /*P*/ T) {
    // Top switch stmt: dispatch to VisitFooType for each FooType.
    switch (T.getTypeClass()) {
     case Builtin:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBuiltinType(((/*static_cast*//*const*/ BuiltinType /*P*/ )(T))); return;
     case Complex:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitComplexType(((/*static_cast*//*const*/ ComplexType /*P*/ )(T))); return;
     case Pointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPointerType(((/*static_cast*//*const*/ PointerType /*P*/ )(T))); return;
     case BlockPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockPointerType(((/*static_cast*//*const*/ BlockPointerType /*P*/ )(T))); return;
     case LValueReference:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLValueReferenceType(((/*static_cast*//*const*/ LValueReferenceType /*P*/ )(T))); return;
     case RValueReference:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRValueReferenceType(((/*static_cast*//*const*/ RValueReferenceType /*P*/ )(T))); return;
     case MemberPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemberPointerType(((/*static_cast*//*const*/ MemberPointerType /*P*/ )(T))); return;
     case ConstantArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitConstantArrayType(((/*static_cast*//*const*/ ConstantArrayType /*P*/ )(T))); return;
     case IncompleteArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIncompleteArrayType(((/*static_cast*//*const*/ IncompleteArrayType /*P*/ )(T))); return;
     case VariableArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVariableArrayType(((/*static_cast*//*const*/ VariableArrayType /*P*/ )(T))); return;
     case DependentSizedArray:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedArrayType(((/*static_cast*//*const*/ DependentSizedArrayType /*P*/ )(T))); return;
     case DependentSizedExtVector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentSizedExtVectorType(((/*static_cast*//*const*/ DependentSizedExtVectorType /*P*/ )(T))); return;
     case Vector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorType(((/*static_cast*//*const*/ VectorType /*P*/ )(T))); return;
     case ExtVector:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitExtVectorType(((/*static_cast*//*const*/ ExtVectorType /*P*/ )(T))); return;
     case FunctionProto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionProtoType(((/*static_cast*//*const*/ FunctionProtoType /*P*/ )(T))); return;
     case FunctionNoProto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionNoProtoType(((/*static_cast*//*const*/ FunctionNoProtoType /*P*/ )(T))); return;
     case UnresolvedUsing:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnresolvedUsingType(((/*static_cast*//*const*/ UnresolvedUsingType /*P*/ )(T))); return;
     case Paren:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitParenType(((/*static_cast*//*const*/ ParenType /*P*/ )(T))); return;
     case Typedef:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedefType(((/*static_cast*//*const*/ TypedefType /*P*/ )(T))); return;
     case Adjusted:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedType(((/*static_cast*//*const*/ AdjustedType /*P*/ )(T))); return;
     case Decayed:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecayedType(((/*static_cast*//*const*/ DecayedType /*P*/ )(T))); return;
     case TypeOfExpr:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfExprType(((/*static_cast*//*const*/ TypeOfExprType /*P*/ )(T))); return;
     case TypeOf:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypeOfType(((/*static_cast*//*const*/ TypeOfType /*P*/ )(T))); return;
     case Decltype:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDecltypeType(((/*static_cast*//*const*/ DecltypeType /*P*/ )(T))); return;
     case UnaryTransform:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnaryTransformType(((/*static_cast*//*const*/ UnaryTransformType /*P*/ )(T))); return;
     case Record:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitRecordType(((/*static_cast*//*const*/ RecordType /*P*/ )(T))); return;
     case Enum:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitEnumType(((/*static_cast*//*const*/ EnumType /*P*/ )(T))); return;
     case Elaborated:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitElaboratedType(((/*static_cast*//*const*/ ElaboratedType /*P*/ )(T))); return;
     case Attributed:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAttributedType(((/*static_cast*//*const*/ AttributedType /*P*/ )(T))); return;
     case TemplateTypeParm:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateTypeParmType(((/*static_cast*//*const*/ TemplateTypeParmType /*P*/ )(T))); return;
     case SubstTemplateTypeParm:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmType(((/*static_cast*//*const*/ SubstTemplateTypeParmType /*P*/ )(T))); return;
     case SubstTemplateTypeParmPack:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubstTemplateTypeParmPackType(((/*static_cast*//*const*/ SubstTemplateTypeParmPackType /*P*/ )(T))); return;
     case TemplateSpecialization:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTemplateSpecializationType(((/*static_cast*//*const*/ TemplateSpecializationType /*P*/ )(T))); return;
     case Auto:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAutoType(((/*static_cast*//*const*/ AutoType /*P*/ )(T))); return;
     case InjectedClassName:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitInjectedClassNameType(((/*static_cast*//*const*/ InjectedClassNameType /*P*/ )(T))); return;
     case DependentName:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentNameType(((/*static_cast*//*const*/ DependentNameType /*P*/ )(T))); return;
     case DependentTemplateSpecialization:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDependentTemplateSpecializationType(((/*static_cast*//*const*/ DependentTemplateSpecializationType /*P*/ )(T))); return;
     case PackExpansion:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPackExpansionType(((/*static_cast*//*const*/ PackExpansionType /*P*/ )(T))); return;
     case ObjCObject:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectType(((/*static_cast*//*const*/ ObjCObjectType /*P*/ )(T))); return;
     case ObjCInterface:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCInterfaceType(((/*static_cast*//*const*/ ObjCInterfaceType /*P*/ )(T))); return;
     case ObjCObjectPointer:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectPointerType(((/*static_cast*//*const*/ ObjCObjectPointerType /*P*/ )(T))); return;
     case Pipe:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitPipeType(((/*static_cast*//*const*/ PipeType /*P*/ )(T))); return;
     case Atomic:
      ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAtomicType(((/*static_cast*//*const*/ AtomicType /*P*/ )(T))); return;
    }
    throw new llvm_unreachable("Unknown type class!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitBuiltinType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 62,
   FQN="clang::TypeVisitor::VisitBuiltinType", NM="_ZN5clang11TypeVisitor16VisitBuiltinTypeEPKNS_11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor16VisitBuiltinTypeEPKNS_11BuiltinTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitBuiltinType(/*const*/ BuiltinType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitComplexType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 63,
   FQN="clang::TypeVisitor::VisitComplexType", NM="_ZN5clang11TypeVisitor16VisitComplexTypeEPKNS_11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor16VisitComplexTypeEPKNS_11ComplexTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitComplexType(/*const*/ ComplexType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitPointerType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 64,
   FQN="clang::TypeVisitor::VisitPointerType", NM="_ZN5clang11TypeVisitor16VisitPointerTypeEPKNS_11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor16VisitPointerTypeEPKNS_11PointerTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitPointerType(/*const*/ PointerType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 65,
   FQN="clang::TypeVisitor::VisitBlockPointerType", NM="_ZN5clang11TypeVisitor21VisitBlockPointerTypeEPKNS_16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor21VisitBlockPointerTypeEPKNS_16BlockPointerTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitReferenceType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 66,
   FQN="clang::TypeVisitor::VisitReferenceType", NM="_ZN5clang11TypeVisitor18VisitReferenceTypeEPKNS_13ReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor18VisitReferenceTypeEPKNS_13ReferenceTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitReferenceType(/*const*/ ReferenceType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitLValueReferenceType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 67,
   FQN="clang::TypeVisitor::VisitLValueReferenceType", NM="_ZN5clang11TypeVisitor24VisitLValueReferenceTypeEPKNS_19LValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor24VisitLValueReferenceTypeEPKNS_19LValueReferenceTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitLValueReferenceType(/*const*/ LValueReferenceType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReferenceType(((/*static_cast*//*const*/ ReferenceType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitRValueReferenceType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 68,
   FQN="clang::TypeVisitor::VisitRValueReferenceType", NM="_ZN5clang11TypeVisitor24VisitRValueReferenceTypeEPKNS_19RValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor24VisitRValueReferenceTypeEPKNS_19RValueReferenceTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitRValueReferenceType(/*const*/ RValueReferenceType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitReferenceType(((/*static_cast*//*const*/ ReferenceType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 69,
   FQN="clang::TypeVisitor::VisitMemberPointerType", NM="_ZN5clang11TypeVisitor22VisitMemberPointerTypeEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitMemberPointerTypeEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitArrayType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 70,
   FQN="clang::TypeVisitor::VisitArrayType", NM="_ZN5clang11TypeVisitor14VisitArrayTypeEPKNS_9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor14VisitArrayTypeEPKNS_9ArrayTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitArrayType(/*const*/ ArrayType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitConstantArrayType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 71,
   FQN="clang::TypeVisitor::VisitConstantArrayType", NM="_ZN5clang11TypeVisitor22VisitConstantArrayTypeEPKNS_17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitConstantArrayTypeEPKNS_17ConstantArrayTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitConstantArrayType(/*const*/ ConstantArrayType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayType(((/*static_cast*//*const*/ ArrayType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitIncompleteArrayType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 72,
   FQN="clang::TypeVisitor::VisitIncompleteArrayType", NM="_ZN5clang11TypeVisitor24VisitIncompleteArrayTypeEPKNS_19IncompleteArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor24VisitIncompleteArrayTypeEPKNS_19IncompleteArrayTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitIncompleteArrayType(/*const*/ IncompleteArrayType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayType(((/*static_cast*//*const*/ ArrayType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitVariableArrayType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 73,
   FQN="clang::TypeVisitor::VisitVariableArrayType", NM="_ZN5clang11TypeVisitor22VisitVariableArrayTypeEPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitVariableArrayTypeEPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitVariableArrayType(/*const*/ VariableArrayType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayType(((/*static_cast*//*const*/ ArrayType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitDependentSizedArrayType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="clang::TypeVisitor::VisitDependentSizedArrayType", NM="_ZN5clang11TypeVisitor28VisitDependentSizedArrayTypeEPKNS_23DependentSizedArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor28VisitDependentSizedArrayTypeEPKNS_23DependentSizedArrayTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentSizedArrayType(/*const*/ DependentSizedArrayType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitArrayType(((/*static_cast*//*const*/ ArrayType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="clang::TypeVisitor::VisitDependentSizedExtVectorType", NM="_ZN5clang11TypeVisitor32VisitDependentSizedExtVectorTypeEPKNS_27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor32VisitDependentSizedExtVectorTypeEPKNS_27DependentSizedExtVectorTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentSizedExtVectorType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitVectorType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 76,
   FQN="clang::TypeVisitor::VisitVectorType", NM="_ZN5clang11TypeVisitor15VisitVectorTypeEPKNS_10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor15VisitVectorTypeEPKNS_10VectorTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitVectorType(/*const*/ VectorType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitExtVectorType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 77,
   FQN="clang::TypeVisitor::VisitExtVectorType", NM="_ZN5clang11TypeVisitor18VisitExtVectorTypeEPKNS_13ExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor18VisitExtVectorTypeEPKNS_13ExtVectorTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitExtVectorType(/*const*/ ExtVectorType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVectorType(((/*static_cast*//*const*/ VectorType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 78,
   FQN="clang::TypeVisitor::VisitFunctionType", NM="_ZN5clang11TypeVisitor17VisitFunctionTypeEPKNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor17VisitFunctionTypeEPKNS_12FunctionTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitFunctionType(/*const*/ FunctionType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitFunctionProtoType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 79,
   FQN="clang::TypeVisitor::VisitFunctionProtoType", NM="_ZN5clang11TypeVisitor22VisitFunctionProtoTypeEPKNS_17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitFunctionProtoTypeEPKNS_17FunctionProtoTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitFunctionProtoType(/*const*/ FunctionProtoType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionType(((/*static_cast*//*const*/ FunctionType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitFunctionNoProtoType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 80,
   FQN="clang::TypeVisitor::VisitFunctionNoProtoType", NM="_ZN5clang11TypeVisitor24VisitFunctionNoProtoTypeEPKNS_19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor24VisitFunctionNoProtoTypeEPKNS_19FunctionNoProtoTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitFunctionNoProtoType(/*const*/ FunctionNoProtoType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionType(((/*static_cast*//*const*/ FunctionType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitUnresolvedUsingType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="clang::TypeVisitor::VisitUnresolvedUsingType", NM="_ZN5clang11TypeVisitor24VisitUnresolvedUsingTypeEPKNS_19UnresolvedUsingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor24VisitUnresolvedUsingTypeEPKNS_19UnresolvedUsingTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitUnresolvedUsingType(/*const*/ UnresolvedUsingType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitParenType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 82,
   FQN="clang::TypeVisitor::VisitParenType", NM="_ZN5clang11TypeVisitor14VisitParenTypeEPKNS_9ParenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor14VisitParenTypeEPKNS_9ParenTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitParenType(/*const*/ ParenType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitTypedefType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 83,
   FQN="clang::TypeVisitor::VisitTypedefType", NM="_ZN5clang11TypeVisitor16VisitTypedefTypeEPKNS_11TypedefTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor16VisitTypedefTypeEPKNS_11TypedefTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitTypedefType(/*const*/ TypedefType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitAdjustedType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 84,
   FQN="clang::TypeVisitor::VisitAdjustedType", NM="_ZN5clang11TypeVisitor17VisitAdjustedTypeEPKNS_12AdjustedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor17VisitAdjustedTypeEPKNS_12AdjustedTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitAdjustedType(/*const*/ AdjustedType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitDecayedType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 85,
   FQN="clang::TypeVisitor::VisitDecayedType", NM="_ZN5clang11TypeVisitor16VisitDecayedTypeEPKNS_11DecayedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor16VisitDecayedTypeEPKNS_11DecayedTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitDecayedType(/*const*/ DecayedType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAdjustedType(((/*static_cast*//*const*/ AdjustedType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitTypeOfExprType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 86,
   FQN="clang::TypeVisitor::VisitTypeOfExprType", NM="_ZN5clang11TypeVisitor19VisitTypeOfExprTypeEPKNS_14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor19VisitTypeOfExprTypeEPKNS_14TypeOfExprTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitTypeOfExprType(/*const*/ TypeOfExprType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitTypeOfType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 87,
   FQN="clang::TypeVisitor::VisitTypeOfType", NM="_ZN5clang11TypeVisitor15VisitTypeOfTypeEPKNS_10TypeOfTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor15VisitTypeOfTypeEPKNS_10TypeOfTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitTypeOfType(/*const*/ TypeOfType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitDecltypeType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 88,
   FQN="clang::TypeVisitor::VisitDecltypeType", NM="_ZN5clang11TypeVisitor17VisitDecltypeTypeEPKNS_12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor17VisitDecltypeTypeEPKNS_12DecltypeTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitDecltypeType(/*const*/ DecltypeType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitUnaryTransformType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 89,
   FQN="clang::TypeVisitor::VisitUnaryTransformType", NM="_ZN5clang11TypeVisitor23VisitUnaryTransformTypeEPKNS_18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor23VisitUnaryTransformTypeEPKNS_18UnaryTransformTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitUnaryTransformType(/*const*/ UnaryTransformType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitTagType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 90,
   FQN="clang::TypeVisitor::VisitTagType", NM="_ZN5clang11TypeVisitor12VisitTagTypeEPKNS_7TagTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor12VisitTagTypeEPKNS_7TagTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitTagType(/*const*/ TagType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitRecordType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 91,
   FQN="clang::TypeVisitor::VisitRecordType", NM="_ZN5clang11TypeVisitor15VisitRecordTypeEPKNS_10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor15VisitRecordTypeEPKNS_10RecordTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitRecordType(/*const*/ RecordType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagType(((/*static_cast*//*const*/ TagType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitEnumType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 92,
   FQN="clang::TypeVisitor::VisitEnumType", NM="_ZN5clang11TypeVisitor13VisitEnumTypeEPKNS_8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor13VisitEnumTypeEPKNS_8EnumTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitEnumType(/*const*/ EnumType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTagType(((/*static_cast*//*const*/ TagType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitElaboratedType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 93,
   FQN="clang::TypeVisitor::VisitElaboratedType", NM="_ZN5clang11TypeVisitor19VisitElaboratedTypeEPKNS_14ElaboratedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor19VisitElaboratedTypeEPKNS_14ElaboratedTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitElaboratedType(/*const*/ ElaboratedType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitAttributedType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 94,
   FQN="clang::TypeVisitor::VisitAttributedType", NM="_ZN5clang11TypeVisitor19VisitAttributedTypeEPKNS_14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor19VisitAttributedTypeEPKNS_14AttributedTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitAttributedType(/*const*/ AttributedType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="clang::TypeVisitor::VisitTemplateTypeParmType", NM="_ZN5clang11TypeVisitor25VisitTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor25VisitTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 96,
   FQN="clang::TypeVisitor::VisitSubstTemplateTypeParmType", NM="_ZN5clang11TypeVisitor30VisitSubstTemplateTypeParmTypeEPKNS_25SubstTemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor30VisitSubstTemplateTypeParmTypeEPKNS_25SubstTemplateTypeParmTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitSubstTemplateTypeParmType(/*const*/ SubstTemplateTypeParmType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="clang::TypeVisitor::VisitSubstTemplateTypeParmPackType", NM="_ZN5clang11TypeVisitor34VisitSubstTemplateTypeParmPackTypeEPKNS_29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor34VisitSubstTemplateTypeParmPackTypeEPKNS_29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitSubstTemplateTypeParmPackType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitTemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 98,
   FQN="clang::TypeVisitor::VisitTemplateSpecializationType", NM="_ZN5clang11TypeVisitor31VisitTemplateSpecializationTypeEPKNS_26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor31VisitTemplateSpecializationTypeEPKNS_26TemplateSpecializationTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitTemplateSpecializationType(/*const*/ TemplateSpecializationType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitAutoType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 99,
   FQN="clang::TypeVisitor::VisitAutoType", NM="_ZN5clang11TypeVisitor13VisitAutoTypeEPKNS_8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor13VisitAutoTypeEPKNS_8AutoTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitAutoType(/*const*/ AutoType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitInjectedClassNameType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="clang::TypeVisitor::VisitInjectedClassNameType", NM="_ZN5clang11TypeVisitor26VisitInjectedClassNameTypeEPKNS_21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor26VisitInjectedClassNameTypeEPKNS_21InjectedClassNameTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitDependentNameType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="clang::TypeVisitor::VisitDependentNameType", NM="_ZN5clang11TypeVisitor22VisitDependentNameTypeEPKNS_17DependentNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitDependentNameTypeEPKNS_17DependentNameTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentNameType(/*const*/ DependentNameType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="clang::TypeVisitor::VisitDependentTemplateSpecializationType", NM="_ZN5clang11TypeVisitor40VisitDependentTemplateSpecializationTypeEPKNS_35DependentTemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor40VisitDependentTemplateSpecializationTypeEPKNS_35DependentTemplateSpecializationTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitDependentTemplateSpecializationType(/*const*/ DependentTemplateSpecializationType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitPackExpansionType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 103,
   FQN="clang::TypeVisitor::VisitPackExpansionType", NM="_ZN5clang11TypeVisitor22VisitPackExpansionTypeEPKNS_17PackExpansionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitPackExpansionTypeEPKNS_17PackExpansionTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitPackExpansionType(/*const*/ PackExpansionType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitObjCObjectType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 104,
   FQN="clang::TypeVisitor::VisitObjCObjectType", NM="_ZN5clang11TypeVisitor19VisitObjCObjectTypeEPKNS_14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor19VisitObjCObjectTypeEPKNS_14ObjCObjectTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitObjCObjectType(/*const*/ ObjCObjectType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitObjCInterfaceType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 105,
   FQN="clang::TypeVisitor::VisitObjCInterfaceType", NM="_ZN5clang11TypeVisitor22VisitObjCInterfaceTypeEPKNS_17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor22VisitObjCInterfaceTypeEPKNS_17ObjCInterfaceTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitObjCInterfaceType(/*const*/ ObjCInterfaceType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCObjectType(((/*static_cast*//*const*/ ObjCObjectType /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitObjCObjectPointerType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 106,
   FQN="clang::TypeVisitor::VisitObjCObjectPointerType", NM="_ZN5clang11TypeVisitor26VisitObjCObjectPointerTypeEPKNS_21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor26VisitObjCObjectPointerTypeEPKNS_21ObjCObjectPointerTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitObjCObjectPointerType(/*const*/ ObjCObjectPointerType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitPipeType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 107,
   FQN="clang::TypeVisitor::VisitPipeType", NM="_ZN5clang11TypeVisitor13VisitPipeTypeEPKNS_8PipeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor13VisitPipeTypeEPKNS_8PipeTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitPipeType(/*const*/ PipeType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitAtomicType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 108,
   FQN="clang::TypeVisitor::VisitAtomicType", NM="_ZN5clang11TypeVisitor15VisitAtomicTypeEPKNS_10AtomicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor15VisitAtomicTypeEPKNS_10AtomicTypeE")
  //</editor-fold>
  public default/*interface*/ void VisitAtomicType(/*const*/ AtomicType /*P*/ T) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitType(((/*static_cast*//*const*/ Type /*P*/ )(T))); return;
  }

  
  /// \brief Method called if \c ImpClass doesn't provide specific handler
  /// for some type class.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisitor::VisitType">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeVisitor.h", line = 88,
   FQN="clang::TypeVisitor::VisitType", NM="_ZN5clang11TypeVisitor9VisitTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11TypeVisitor9VisitTypeEPKNS_4TypeE")
  //</editor-fold>
  public default/*interface*/ void VisitType(/*const*/ Type /*P*/ $Prm0) {
    return /*void*/;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $destroy$TypeVisitor() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}