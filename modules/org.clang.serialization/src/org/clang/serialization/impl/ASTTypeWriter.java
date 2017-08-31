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

package org.clang.serialization.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.serialization.impl.ASTWriterStatics.addExceptionSpec;
import org.llvm.adt.ADTAliases.OptionalUInt;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 86,
 FQN="clang::ASTTypeWriter", NM="_ZN5clang13ASTTypeWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriterE")
//</editor-fold>
public class ASTTypeWriter implements Destructors.ClassWithDestructor {
  private final ASTWriter /*&*/ Writer;
  private ASTRecordWriter Record;
  
  /// \brief Type code that corresponds to the record generated.
  private /*TypeCode*/int Code;
  /// \brief Abbreviation to use for the record, if any.
  private /*uint*/int AbbrevToUse;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::ASTTypeWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 96,
   FQN="clang::ASTTypeWriter::ASTTypeWriter", NM="_ZN5clang13ASTTypeWriterC1ERNS_9ASTWriterERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriterC1ERNS_9ASTWriterERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public ASTTypeWriter(final ASTWriter /*&*/ Writer, final SmallVectorImplULong /*&*/ Record) {
    // : Writer(Writer), Record(Writer, Record), Code((TypeCode)0), AbbrevToUse(0) 
    //START JInit
    this./*&*/Writer=/*&*/Writer;
    this.Record = new ASTRecordWriter(Writer, Record);
    this.Code = 0;
    this.AbbrevToUse = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 99,
   FQN="clang::ASTTypeWriter::Emit", NM="_ZN5clang13ASTTypeWriter4EmitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter4EmitEv")
  //</editor-fold>
  public long/*uint64_t*/ Emit() {
    return Record.Emit(Code, AbbrevToUse);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 103,
   FQN="clang::ASTTypeWriter::Visit", NM="_ZN5clang13ASTTypeWriter5VisitENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter5VisitENS_8QualTypeE")
  //</editor-fold>
  public void Visit(QualType T) {
    if (T.hasLocalNonFastQualifiers()) {
      Qualifiers Qs = T.getLocalQualifiers();
      Record.AddTypeRef(T.getLocalUnqualifiedType());
      Record.push_back($uint2ulong(Qs.getAsOpaqueValue()));
      Code = TypeCode.TYPE_EXT_QUAL;
      AbbrevToUse = Writer.TypeExtQualAbbrev;
    } else {
      switch (T.$arrow().getTypeClass()) {
       case Builtin:
        VisitBuiltinType(cast_BuiltinType(T));
        break;
       case Complex:
        VisitComplexType(cast_ComplexType(T));
        break;
       case Pointer:
        VisitPointerType(cast_PointerType(T));
        break;
       case BlockPointer:
        VisitBlockPointerType(cast_BlockPointerType(T));
        break;
       case LValueReference:
        VisitLValueReferenceType(cast_LValueReferenceType(T));
        break;
       case RValueReference:
        VisitRValueReferenceType(cast_RValueReferenceType(T));
        break;
       case MemberPointer:
        VisitMemberPointerType(cast_MemberPointerType(T));
        break;
       case ConstantArray:
        VisitConstantArrayType(cast_ConstantArrayType(T));
        break;
       case IncompleteArray:
        VisitIncompleteArrayType(cast_IncompleteArrayType(T));
        break;
       case VariableArray:
        VisitVariableArrayType(cast_VariableArrayType(T));
        break;
       case DependentSizedArray:
        VisitDependentSizedArrayType(cast_DependentSizedArrayType(T));
        break;
       case DependentSizedExtVector:
        VisitDependentSizedExtVectorType(cast_DependentSizedExtVectorType(T));
        break;
       case Vector:
        VisitVectorType(cast_VectorType(T));
        break;
       case ExtVector:
        VisitExtVectorType(cast_ExtVectorType(T));
        break;
       case FunctionProto:
        VisitFunctionProtoType(cast_FunctionProtoType(T));
        break;
       case FunctionNoProto:
        VisitFunctionNoProtoType(cast_FunctionNoProtoType(T));
        break;
       case UnresolvedUsing:
        VisitUnresolvedUsingType(cast_UnresolvedUsingType(T));
        break;
       case Paren:
        VisitParenType(cast_ParenType(T));
        break;
       case Typedef:
        VisitTypedefType(cast_TypedefType(T));
        break;
       case Adjusted:
        VisitAdjustedType(cast_AdjustedType(T));
        break;
       case Decayed:
        VisitDecayedType(cast_DecayedType(T));
        break;
       case TypeOfExpr:
        VisitTypeOfExprType(cast_TypeOfExprType(T));
        break;
       case TypeOf:
        VisitTypeOfType(cast_TypeOfType(T));
        break;
       case Decltype:
        VisitDecltypeType(cast_DecltypeType(T));
        break;
       case UnaryTransform:
        VisitUnaryTransformType(cast_UnaryTransformType(T));
        break;
       case Record:
        VisitRecordType(cast_RecordType(T));
        break;
       case Enum:
        VisitEnumType(cast_EnumType(T));
        break;
       case Elaborated:
        VisitElaboratedType(cast_ElaboratedType(T));
        break;
       case Attributed:
        VisitAttributedType(cast_AttributedType(T));
        break;
       case TemplateTypeParm:
        VisitTemplateTypeParmType(cast_TemplateTypeParmType(T));
        break;
       case SubstTemplateTypeParm:
        VisitSubstTemplateTypeParmType(cast_SubstTemplateTypeParmType(T));
        break;
       case SubstTemplateTypeParmPack:
        VisitSubstTemplateTypeParmPackType(cast_SubstTemplateTypeParmPackType(T));
        break;
       case TemplateSpecialization:
        VisitTemplateSpecializationType(cast_TemplateSpecializationType(T));
        break;
       case Auto:
        VisitAutoType(cast_AutoType(T));
        break;
       case InjectedClassName:
        VisitInjectedClassNameType(cast_InjectedClassNameType(T));
        break;
       case DependentName:
        VisitDependentNameType(cast_DependentNameType(T));
        break;
       case DependentTemplateSpecialization:
        VisitDependentTemplateSpecializationType(cast_DependentTemplateSpecializationType(T));
        break;
       case PackExpansion:
        VisitPackExpansionType(cast_PackExpansionType(T));
        break;
       case ObjCObject:
        VisitObjCObjectType(cast_ObjCObjectType(T));
        break;
       case ObjCInterface:
        VisitObjCInterfaceType(cast_ObjCInterfaceType(T));
        break;
       case ObjCObjectPointer:
        VisitObjCObjectPointerType(cast_ObjCObjectPointerType(T));
        break;
       case Pipe:
        VisitPipeType(cast_PipeType(T));
        break;
       case Atomic:
        VisitAtomicType(cast_AtomicType(T));
        break;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 179,
   FQN="clang::ASTTypeWriter::VisitArrayType", NM="_ZN5clang13ASTTypeWriter14VisitArrayTypeEPKNS_9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter14VisitArrayTypeEPKNS_9ArrayTypeE")
  //</editor-fold>
  public void VisitArrayType(/*const*/ ArrayType /*P*/ T) {
    Record.AddTypeRef(T.getElementType());
    Record.push_back(T.getSizeModifier().getValue()); // FIXME: stable values
    Record.push_back($uint2ulong(T.getIndexTypeCVRQualifiers())); // FIXME: stable values
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 216,
   FQN="clang::ASTTypeWriter::VisitFunctionType", NM="_ZN5clang13ASTTypeWriter17VisitFunctionTypeEPKNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter17VisitFunctionTypeEPKNS_12FunctionTypeE")
  //</editor-fold>
  public void VisitFunctionType(/*const*/ FunctionType /*P*/ T) {
    Record.AddTypeRef(T.getReturnType());
    FunctionType.ExtInfo C = T.getExtInfo();
    Record.push_back((C.getNoReturn() ? 1 : 0));
    Record.push_back((C.getHasRegParm() ? 1 : 0));
    Record.push_back($uint2ulong(C.getRegParm()));
    // FIXME: need to stabilize encoding of calling convention...
    Record.push_back(C.getCC().getValue());
    Record.push_back((C.getProducesResult() ? 1 : 0));
    if (C.getHasRegParm() || (C.getRegParm() != 0) || C.getProducesResult()) {
      AbbrevToUse = 0;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitTagType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 321,
   FQN="clang::ASTTypeWriter::VisitTagType", NM="_ZN5clang13ASTTypeWriter12VisitTagTypeEPKNS_7TagTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter12VisitTagTypeEPKNS_7TagTypeE")
  //</editor-fold>
  public void VisitTagType(/*const*/ TagType /*P*/ T) {
    Record.push_back((T.isDependentType() ? 1 : 0));
    Record.AddDeclRef(T.getDecl().getCanonicalDecl());
    assert (!T.isBeingDefined()) : "Cannot serialize in the middle of a type definition";
  }

  // end namespace clang
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 132,
   FQN="clang::ASTTypeWriter::VisitBuiltinType", NM="_ZN5clang13ASTTypeWriter16VisitBuiltinTypeEPKNS_11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter16VisitBuiltinTypeEPKNS_11BuiltinTypeE")
  //</editor-fold>
  public void VisitBuiltinType(/*const*/ BuiltinType /*P*/ T) {
    throw new llvm_unreachable("Built-in types are never serialized");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 136,
   FQN="clang::ASTTypeWriter::VisitComplexType", NM="_ZN5clang13ASTTypeWriter16VisitComplexTypeEPKNS_11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter16VisitComplexTypeEPKNS_11ComplexTypeE")
  //</editor-fold>
  public void VisitComplexType(/*const*/ ComplexType /*P*/ T) {
    Record.AddTypeRef(T.getElementType());
    Code = TypeCode.TYPE_COMPLEX;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 141,
   FQN="clang::ASTTypeWriter::VisitPointerType", NM="_ZN5clang13ASTTypeWriter16VisitPointerTypeEPKNS_11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter16VisitPointerTypeEPKNS_11PointerTypeE")
  //</editor-fold>
  public void VisitPointerType(/*const*/ PointerType /*P*/ T) {
    Record.AddTypeRef(T.getPointeeType());
    Code = TypeCode.TYPE_POINTER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 157,
   FQN="clang::ASTTypeWriter::VisitBlockPointerType", NM="_ZN5clang13ASTTypeWriter21VisitBlockPointerTypeEPKNS_16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter21VisitBlockPointerTypeEPKNS_16BlockPointerTypeE")
  //</editor-fold>
  public void VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    Record.AddTypeRef(T.getPointeeType());
    Code = TypeCode.TYPE_BLOCK_POINTER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 162,
   FQN="clang::ASTTypeWriter::VisitLValueReferenceType", NM="_ZN5clang13ASTTypeWriter24VisitLValueReferenceTypeEPKNS_19LValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter24VisitLValueReferenceTypeEPKNS_19LValueReferenceTypeE")
  //</editor-fold>
  public void VisitLValueReferenceType(/*const*/ LValueReferenceType /*P*/ T) {
    Record.AddTypeRef(T.getPointeeTypeAsWritten());
    Record.push_back((T.isSpelledAsLValue() ? 1 : 0));
    Code = TypeCode.TYPE_LVALUE_REFERENCE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 168,
   FQN="clang::ASTTypeWriter::VisitRValueReferenceType", NM="_ZN5clang13ASTTypeWriter24VisitRValueReferenceTypeEPKNS_19RValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter24VisitRValueReferenceTypeEPKNS_19RValueReferenceTypeE")
  //</editor-fold>
  public void VisitRValueReferenceType(/*const*/ RValueReferenceType /*P*/ T) {
    Record.AddTypeRef(T.getPointeeTypeAsWritten());
    Code = TypeCode.TYPE_RVALUE_REFERENCE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 173,
   FQN="clang::ASTTypeWriter::VisitMemberPointerType", NM="_ZN5clang13ASTTypeWriter22VisitMemberPointerTypeEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitMemberPointerTypeEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public void VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    Record.AddTypeRef(T.getPointeeType());
    Record.AddTypeRef(new QualType(T.__getClass(), 0));
    Code = TypeCode.TYPE_MEMBER_POINTER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 185,
   FQN="clang::ASTTypeWriter::VisitConstantArrayType", NM="_ZN5clang13ASTTypeWriter22VisitConstantArrayTypeEPKNS_17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitConstantArrayTypeEPKNS_17ConstantArrayTypeE")
  //</editor-fold>
  public void VisitConstantArrayType(/*const*/ ConstantArrayType /*P*/ T) {
    VisitArrayType(T);
    Record.AddAPInt(T.getSize());
    Code = TypeCode.TYPE_CONSTANT_ARRAY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 191,
   FQN="clang::ASTTypeWriter::VisitIncompleteArrayType", NM="_ZN5clang13ASTTypeWriter24VisitIncompleteArrayTypeEPKNS_19IncompleteArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter24VisitIncompleteArrayTypeEPKNS_19IncompleteArrayTypeE")
  //</editor-fold>
  public void VisitIncompleteArrayType(/*const*/ IncompleteArrayType /*P*/ T) {
    VisitArrayType(T);
    Code = TypeCode.TYPE_INCOMPLETE_ARRAY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 196,
   FQN="clang::ASTTypeWriter::VisitVariableArrayType", NM="_ZN5clang13ASTTypeWriter22VisitVariableArrayTypeEPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitVariableArrayTypeEPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public void VisitVariableArrayType(/*const*/ VariableArrayType /*P*/ T) {
    VisitArrayType(T);
    Record.AddSourceLocation(T.getLBracketLoc());
    Record.AddSourceLocation(T.getRBracketLoc());
    Record.AddStmt(T.getSizeExpr());
    Code = TypeCode.TYPE_VARIABLE_ARRAY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 376,
   FQN="clang::ASTTypeWriter::VisitDependentSizedArrayType", NM="_ZN5clang13ASTTypeWriter28VisitDependentSizedArrayTypeEPKNS_23DependentSizedArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter28VisitDependentSizedArrayTypeEPKNS_23DependentSizedArrayTypeE")
  //</editor-fold>
  public void VisitDependentSizedArrayType(/*const*/ DependentSizedArrayType /*P*/ T) {
    VisitArrayType(T);
    Record.AddStmt(T.getSizeExpr());
    Record.AddSourceRange(T.getBracketsRange());
    Code = TypeCode.TYPE_DEPENDENT_SIZED_ARRAY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 384,
   FQN="clang::ASTTypeWriter::VisitDependentSizedExtVectorType", NM="_ZN5clang13ASTTypeWriter32VisitDependentSizedExtVectorTypeEPKNS_27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter32VisitDependentSizedExtVectorTypeEPKNS_27DependentSizedExtVectorTypeE")
  //</editor-fold>
  public void VisitDependentSizedExtVectorType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    // FIXME: Serialize this type (C++ only)
    throw new llvm_unreachable("Cannot serialize dependent sized extended vector types");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 204,
   FQN="clang::ASTTypeWriter::VisitVectorType", NM="_ZN5clang13ASTTypeWriter15VisitVectorTypeEPKNS_10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter15VisitVectorTypeEPKNS_10VectorTypeE")
  //</editor-fold>
  public void VisitVectorType(/*const*/ VectorType /*P*/ T) {
    Record.AddTypeRef(T.getElementType());
    Record.push_back($uint2ulong(T.getNumElements()));
    Record.push_back(T.getVectorKind().getValue());
    Code = TypeCode.TYPE_VECTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 211,
   FQN="clang::ASTTypeWriter::VisitExtVectorType", NM="_ZN5clang13ASTTypeWriter18VisitExtVectorTypeEPKNS_13ExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter18VisitExtVectorTypeEPKNS_13ExtVectorTypeE")
  //</editor-fold>
  public void VisitExtVectorType(/*const*/ ExtVectorType /*P*/ T) {
    VisitVectorType(T);
    Code = TypeCode.TYPE_EXT_VECTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 252,
   FQN="clang::ASTTypeWriter::VisitFunctionProtoType", NM="_ZN5clang13ASTTypeWriter22VisitFunctionProtoTypeEPKNS_17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitFunctionProtoTypeEPKNS_17FunctionProtoTypeE")
  //</editor-fold>
  public void VisitFunctionProtoType(/*const*/ FunctionProtoType /*P*/ T) {
    VisitFunctionType(T);
    
    Record.push_back((T.isVariadic() ? 1 : 0));
    Record.push_back((T.hasTrailingReturn() ? 1 : 0));
    Record.push_back($uint2ulong(T.getTypeQuals()));
    Record.push_back($uint2ulong(((/*static_cast*//*uint*/int)(T.getRefQualifier().getValue()))));
    addExceptionSpec(T, Record);
    
    Record.push_back($uint2ulong(T.getNumParams()));
    for (/*uint*/int I = 0, N = T.getNumParams(); I != N; ++I)  {
      Record.AddTypeRef(T.getParamType(I));
    }
    if (T.hasExtParameterInfos()) {
      for (/*uint*/int I = 0, N = T.getNumParams(); I != N; ++I)  {
        Record.push_back($uchar2ulong(T.getExtParameterInfo(I).getOpaqueValue()));
      }
    }
    if (T.isVariadic() || T.hasTrailingReturn() || (T.getTypeQuals() != 0)
       || (T.getRefQualifier().getValue() != 0) || T.getExceptionSpecType() != ExceptionSpecificationType.EST_None
       || T.hasExtParameterInfos()) {
      AbbrevToUse = 0;
    }
    
    Code = TypeCode.TYPE_FUNCTION_PROTO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 230,
   FQN="clang::ASTTypeWriter::VisitFunctionNoProtoType", NM="_ZN5clang13ASTTypeWriter24VisitFunctionNoProtoTypeEPKNS_19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter24VisitFunctionNoProtoTypeEPKNS_19FunctionNoProtoTypeE")
  //</editor-fold>
  public void VisitFunctionNoProtoType(/*const*/ FunctionNoProtoType /*P*/ T) {
    VisitFunctionType(T);
    Code = TypeCode.TYPE_FUNCTION_NO_PROTO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitUnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 278,
   FQN="clang::ASTTypeWriter::VisitUnresolvedUsingType", NM="_ZN5clang13ASTTypeWriter24VisitUnresolvedUsingTypeEPKNS_19UnresolvedUsingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter24VisitUnresolvedUsingTypeEPKNS_19UnresolvedUsingTypeE")
  //</editor-fold>
  public void VisitUnresolvedUsingType(/*const*/ UnresolvedUsingType /*P*/ T) {
    Record.AddDeclRef(T.getDecl());
    Code = TypeCode.TYPE_UNRESOLVED_USING;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 431,
   FQN="clang::ASTTypeWriter::VisitParenType", NM="_ZN5clang13ASTTypeWriter14VisitParenTypeEPKNS_9ParenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter14VisitParenTypeEPKNS_9ParenTypeE")
  //</editor-fold>
  public void VisitParenType(/*const*/ ParenType /*P*/ T) {
    Record.AddTypeRef(T.getInnerType());
    Code = TypeCode.TYPE_PAREN;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 283,
   FQN="clang::ASTTypeWriter::VisitTypedefType", NM="_ZN5clang13ASTTypeWriter16VisitTypedefTypeEPKNS_11TypedefTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter16VisitTypedefTypeEPKNS_11TypedefTypeE")
  //</editor-fold>
  public void VisitTypedefType(/*const*/ TypedefType /*P*/ T) {
    Record.AddDeclRef(T.getDecl());
    assert (!T.isCanonicalUnqualified()) : "Invalid typedef ?";
    Record.AddTypeRef(T.getCanonicalTypeInternal());
    Code = TypeCode.TYPE_TYPEDEF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 151,
   FQN="clang::ASTTypeWriter::VisitAdjustedType", NM="_ZN5clang13ASTTypeWriter17VisitAdjustedTypeEPKNS_12AdjustedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter17VisitAdjustedTypeEPKNS_12AdjustedTypeE")
  //</editor-fold>
  public void VisitAdjustedType(/*const*/ AdjustedType /*P*/ T) {
    Record.AddTypeRef(T.getOriginalType());
    Record.AddTypeRef(T.getAdjustedType());
    Code = TypeCode.TYPE_ADJUSTED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 146,
   FQN="clang::ASTTypeWriter::VisitDecayedType", NM="_ZN5clang13ASTTypeWriter16VisitDecayedTypeEPKNS_11DecayedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter16VisitDecayedTypeEPKNS_11DecayedTypeE")
  //</editor-fold>
  public void VisitDecayedType(/*const*/ DecayedType /*P*/ T) {
    Record.AddTypeRef(T.getOriginalType());
    Code = TypeCode.TYPE_DECAYED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 290,
   FQN="clang::ASTTypeWriter::VisitTypeOfExprType", NM="_ZN5clang13ASTTypeWriter19VisitTypeOfExprTypeEPKNS_14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter19VisitTypeOfExprTypeEPKNS_14TypeOfExprTypeE")
  //</editor-fold>
  public void VisitTypeOfExprType(/*const*/ TypeOfExprType /*P*/ T) {
    Record.AddStmt(T.getUnderlyingExpr());
    Code = TypeCode.TYPE_TYPEOF_EXPR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 295,
   FQN="clang::ASTTypeWriter::VisitTypeOfType", NM="_ZN5clang13ASTTypeWriter15VisitTypeOfTypeEPKNS_10TypeOfTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter15VisitTypeOfTypeEPKNS_10TypeOfTypeE")
  //</editor-fold>
  public void VisitTypeOfType(/*const*/ TypeOfType /*P*/ T) {
    Record.AddTypeRef(T.getUnderlyingType());
    Code = TypeCode.TYPE_TYPEOF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 300,
   FQN="clang::ASTTypeWriter::VisitDecltypeType", NM="_ZN5clang13ASTTypeWriter17VisitDecltypeTypeEPKNS_12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter17VisitDecltypeTypeEPKNS_12DecltypeTypeE")
  //</editor-fold>
  public void VisitDecltypeType(/*const*/ DecltypeType /*P*/ T) {
    Record.AddTypeRef(T.getUnderlyingType());
    Record.AddStmt(T.getUnderlyingExpr());
    Code = TypeCode.TYPE_DECLTYPE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 306,
   FQN="clang::ASTTypeWriter::VisitUnaryTransformType", NM="_ZN5clang13ASTTypeWriter23VisitUnaryTransformTypeEPKNS_18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter23VisitUnaryTransformTypeEPKNS_18UnaryTransformTypeE")
  //</editor-fold>
  public void VisitUnaryTransformType(/*const*/ UnaryTransformType /*P*/ T) {
    Record.AddTypeRef(T.getBaseType());
    Record.AddTypeRef(T.getUnderlyingType());
    Record.push_back(T.getUTTKind().getValue());
    Code = TypeCode.TYPE_UNARY_TRANSFORM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 328,
   FQN="clang::ASTTypeWriter::VisitRecordType", NM="_ZN5clang13ASTTypeWriter15VisitRecordTypeEPKNS_10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter15VisitRecordTypeEPKNS_10RecordTypeE")
  //</editor-fold>
  public void VisitRecordType(/*const*/ RecordType /*P*/ T) {
    VisitTagType(T);
    Code = TypeCode.TYPE_RECORD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 333,
   FQN="clang::ASTTypeWriter::VisitEnumType", NM="_ZN5clang13ASTTypeWriter13VisitEnumTypeEPKNS_8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter13VisitEnumTypeEPKNS_8EnumTypeE")
  //</editor-fold>
  public void VisitEnumType(/*const*/ EnumType /*P*/ T) {
    VisitTagType(T);
    Code = TypeCode.TYPE_ENUM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 436,
   FQN="clang::ASTTypeWriter::VisitElaboratedType", NM="_ZN5clang13ASTTypeWriter19VisitElaboratedTypeEPKNS_14ElaboratedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter19VisitElaboratedTypeEPKNS_14ElaboratedTypeE")
  //</editor-fold>
  public void VisitElaboratedType(/*const*/ ElaboratedType /*P*/ T) {
    Record.push_back(T.getKeyword().getValue());
    Record.AddNestedNameSpecifier(T.getQualifier());
    Record.AddTypeRef(T.getNamedType());
    Code = TypeCode.TYPE_ELABORATED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 338,
   FQN="clang::ASTTypeWriter::VisitAttributedType", NM="_ZN5clang13ASTTypeWriter19VisitAttributedTypeEPKNS_14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter19VisitAttributedTypeEPKNS_14AttributedTypeE")
  //</editor-fold>
  public void VisitAttributedType(/*const*/ AttributedType /*P*/ T) {
    Record.AddTypeRef(T.getModifiedType());
    Record.AddTypeRef(T.getEquivalentType());
    Record.push_back(T.getAttrKind().getValue());
    Code = TypeCode.TYPE_ATTRIBUTED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 391,
   FQN="clang::ASTTypeWriter::VisitTemplateTypeParmType", NM="_ZN5clang13ASTTypeWriter25VisitTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter25VisitTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeE")
  //</editor-fold>
  public void VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ T) {
    Record.push_back($uint2ulong(T.getDepth()));
    Record.push_back($uint2ulong(T.getIndex()));
    Record.push_back((T.isParameterPack() ? 1 : 0));
    Record.AddDeclRef(T.getDecl());
    Code = TypeCode.TYPE_TEMPLATE_TYPE_PARM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 345,
   FQN="clang::ASTTypeWriter::VisitSubstTemplateTypeParmType", NM="_ZN5clang13ASTTypeWriter30VisitSubstTemplateTypeParmTypeEPKNS_25SubstTemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter30VisitSubstTemplateTypeParmTypeEPKNS_25SubstTemplateTypeParmTypeE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmType(/*const*/ SubstTemplateTypeParmType /*P*/ T) {
    Record.AddTypeRef(new QualType(T.getReplacedParameter(), 0));
    Record.AddTypeRef(T.getReplacementType());
    Code = TypeCode.TYPE_SUBST_TEMPLATE_TYPE_PARM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 353,
   FQN="clang::ASTTypeWriter::VisitSubstTemplateTypeParmPackType", NM="_ZN5clang13ASTTypeWriter34VisitSubstTemplateTypeParmPackTypeEPKNS_29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter34VisitSubstTemplateTypeParmPackTypeEPKNS_29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmPackType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T) {
    Record.AddTypeRef(new QualType(T.getReplacedParameter(), 0));
    Record.AddTemplateArgument(T.getArgumentPack());
    Code = TypeCode.TYPE_SUBST_TEMPLATE_TYPE_PARM_PACK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 361,
   FQN="clang::ASTTypeWriter::VisitTemplateSpecializationType", NM="_ZN5clang13ASTTypeWriter31VisitTemplateSpecializationTypeEPKNS_26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter31VisitTemplateSpecializationTypeEPKNS_26TemplateSpecializationTypeE")
  //</editor-fold>
  public void VisitTemplateSpecializationType(/*const*/ TemplateSpecializationType /*P*/ T) {
    Record.push_back((T.isDependentType() ? 1 : 0));
    Record.AddTemplateName(T.getTemplateName());
    Record.push_back($uint2ulong(T.getNumArgs()));
    for (final /*const*/ TemplateArgument /*&*/ ArgI : $Deref(T))  {
      Record.AddTemplateArgument(ArgI);
    }
    Record.AddTypeRef(T.isTypeAlias() ? T.getAliasedType() : T.isCanonicalUnqualified() ? new QualType() : T.getCanonicalTypeInternal());
    Code = TypeCode.TYPE_TEMPLATE_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 313,
   FQN="clang::ASTTypeWriter::VisitAutoType", NM="_ZN5clang13ASTTypeWriter13VisitAutoTypeEPKNS_8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter13VisitAutoTypeEPKNS_8AutoTypeE")
  //</editor-fold>
  public void VisitAutoType(/*const*/ AutoType /*P*/ T) {
    Record.AddTypeRef(T.getDeducedType());
    Record.push_back($uint2ulong(((/*uint*/int)T.getKeyword().getValue())));
    if (T.getDeducedType().isNull()) {
      Record.push_back((T.isDependentType() ? 1 : 0));
    }
    Code = TypeCode.TYPE_AUTO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 443,
   FQN="clang::ASTTypeWriter::VisitInjectedClassNameType", NM="_ZN5clang13ASTTypeWriter26VisitInjectedClassNameTypeEPKNS_21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter26VisitInjectedClassNameTypeEPKNS_21InjectedClassNameTypeE")
  //</editor-fold>
  public void VisitInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    Record.AddDeclRef(T.getDecl().getCanonicalDecl());
    Record.AddTypeRef(T.getInjectedSpecializationType());
    Code = TypeCode.TYPE_INJECTED_CLASS_NAME;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitDependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 400,
   FQN="clang::ASTTypeWriter::VisitDependentNameType", NM="_ZN5clang13ASTTypeWriter22VisitDependentNameTypeEPKNS_17DependentNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitDependentNameTypeEPKNS_17DependentNameTypeE")
  //</editor-fold>
  public void VisitDependentNameType(/*const*/ DependentNameType /*P*/ T) {
    Record.push_back(T.getKeyword().getValue());
    Record.AddNestedNameSpecifier(T.getQualifier());
    Record.AddIdentifierRef(T.getIdentifier());
    Record.AddTypeRef(T.isCanonicalUnqualified() ? new QualType() : T.getCanonicalTypeInternal());
    Code = TypeCode.TYPE_DEPENDENT_NAME;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 410,
   FQN="clang::ASTTypeWriter::VisitDependentTemplateSpecializationType", NM="_ZN5clang13ASTTypeWriter40VisitDependentTemplateSpecializationTypeEPKNS_35DependentTemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter40VisitDependentTemplateSpecializationTypeEPKNS_35DependentTemplateSpecializationTypeE")
  //</editor-fold>
  public void VisitDependentTemplateSpecializationType(/*const*/ DependentTemplateSpecializationType /*P*/ T) {
    Record.push_back(T.getKeyword().getValue());
    Record.AddNestedNameSpecifier(T.getQualifier());
    Record.AddIdentifierRef(T.getIdentifier());
    Record.push_back($uint2ulong(T.getNumArgs()));
    for (final /*const*/ TemplateArgument /*&*/ I : $Deref(T))  {
      Record.AddTemplateArgument(I);
    }
    Code = TypeCode.TYPE_DEPENDENT_TEMPLATE_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 422,
   FQN="clang::ASTTypeWriter::VisitPackExpansionType", NM="_ZN5clang13ASTTypeWriter22VisitPackExpansionTypeEPKNS_17PackExpansionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitPackExpansionTypeEPKNS_17PackExpansionTypeE")
  //</editor-fold>
  public void VisitPackExpansionType(/*const*/ PackExpansionType /*P*/ T) {
    Record.AddTypeRef(T.getPattern());
    {
      OptionalUInt NumExpansions = T.getNumExpansions();
      if (NumExpansions.$bool()) {
        Record.push_back($uint2ulong(NumExpansions.$star() + 1));
      } else {
        Record.push_back($int2ulong(0));
      }
    }
    Code = TypeCode.TYPE_PACK_EXPANSION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 454,
   FQN="clang::ASTTypeWriter::VisitObjCObjectType", NM="_ZN5clang13ASTTypeWriter19VisitObjCObjectTypeEPKNS_14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter19VisitObjCObjectTypeEPKNS_14ObjCObjectTypeE")
  //</editor-fold>
  public void VisitObjCObjectType(/*const*/ ObjCObjectType /*P*/ T) {
    Record.AddTypeRef(T.getBaseType());
    Record.push_back($uint2ulong(T.getTypeArgsAsWritten().size()));
    for (QualType TypeArg : T.getTypeArgsAsWritten())  {
      Record.AddTypeRef(new QualType(TypeArg));
    }
    Record.push_back($uint2ulong(T.getNumProtocols()));
    for (/*const*/ ObjCProtocolDecl /*P*/ I : T.quals())  {
      Record.AddDeclRef(I);
    }
    Record.push_back((T.isKindOfTypeAsWritten() ? 1 : 0));
    Code = TypeCode.TYPE_OBJC_OBJECT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 449,
   FQN="clang::ASTTypeWriter::VisitObjCInterfaceType", NM="_ZN5clang13ASTTypeWriter22VisitObjCInterfaceTypeEPKNS_17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter22VisitObjCInterfaceTypeEPKNS_17ObjCInterfaceTypeE")
  //</editor-fold>
  public void VisitObjCInterfaceType(/*const*/ ObjCInterfaceType /*P*/ T) {
    Record.AddDeclRef(T.getDecl().getCanonicalDecl());
    Code = TypeCode.TYPE_OBJC_INTERFACE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 466,
   FQN="clang::ASTTypeWriter::VisitObjCObjectPointerType", NM="_ZN5clang13ASTTypeWriter26VisitObjCObjectPointerTypeEPKNS_21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter26VisitObjCObjectPointerTypeEPKNS_21ObjCObjectPointerTypeE")
  //</editor-fold>
  public void VisitObjCObjectPointerType(/*const*/ ObjCObjectPointerType /*P*/ T) {
    Record.AddTypeRef(T.getPointeeType());
    Code = TypeCode.TYPE_OBJC_OBJECT_POINTER;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 478,
   FQN="clang::ASTTypeWriter::VisitPipeType", NM="_ZN5clang13ASTTypeWriter13VisitPipeTypeEPKNS_8PipeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter13VisitPipeTypeEPKNS_8PipeTypeE")
  //</editor-fold>
  public void VisitPipeType(/*const*/ PipeType /*P*/ T) {
    Record.AddTypeRef(T.getElementType());
    Code = TypeCode.TYPE_PIPE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::VisitAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 472,
   FQN="clang::ASTTypeWriter::VisitAtomicType", NM="_ZN5clang13ASTTypeWriter15VisitAtomicTypeEPKNS_10AtomicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriter15VisitAtomicTypeEPKNS_10AtomicTypeE")
  //</editor-fold>
  public void VisitAtomicType(/*const*/ AtomicType /*P*/ T) {
    Record.AddTypeRef(T.getValueType());
    Code = TypeCode.TYPE_ATOMIC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTypeWriter::~ASTTypeWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 86,
   FQN="clang::ASTTypeWriter::~ASTTypeWriter", NM="_ZN5clang13ASTTypeWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang13ASTTypeWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Record.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Code=" + Code // NOI18N
              + ", AbbrevToUse=" + AbbrevToUse; // NOI18N
  }
}
