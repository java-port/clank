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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.ast.FunctionProtoType.ExtParameterInfo;
import static org.clang.ast.QualType.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.TypePrinterStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 82,
 FQN="(anonymous namespace)::TypePrinter", NM="_ZN12_GLOBAL__N_111TypePrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinterE")
//</editor-fold>
public class TypePrinter {
  private PrintingPolicy Policy;
  private /*uint*/int Indentation;
  private bool$ref HasEmptyPlaceHolder = create_bool$ref(false);
  private bool$ref InsideCCAttribute = create_bool$ref(false);;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::TypePrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 89,
   FQN="(anonymous namespace)::TypePrinter::TypePrinter", NM="_ZN12_GLOBAL__N_111TypePrinterC1ERKN5clang14PrintingPolicyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinterC1ERKN5clang14PrintingPolicyEj")
  //</editor-fold>
  public /*explicit*/ TypePrinter(final /*const*/ PrintingPolicy /*&*/ Policy) {
    this(Policy, 0);
  }
  public /*explicit*/ TypePrinter(final /*const*/ PrintingPolicy /*&*/ Policy, /*uint*/int Indentation/*= 0*/) {
    // : Policy(Policy), Indentation(Indentation), HasEmptyPlaceHolder(false), InsideCCAttribute(false) 
    //START JInit
    this.Policy = new PrintingPolicy(Policy);
    this.Indentation = Indentation;
    this.HasEmptyPlaceHolder.$set(false);
    this.InsideCCAttribute.$set(false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 147,
   FQN="(anonymous namespace)::TypePrinter::print", NM="_ZN12_GLOBAL__N_111TypePrinter5printEPKN5clang4TypeENS1_10QualifiersERN4llvm11raw_ostreamENS6_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter5printEPKN5clang4TypeENS1_10QualifiersERN4llvm11raw_ostreamENS6_9StringRefE")
  //</editor-fold>
  public void print(/*const*/ Type /*P*/ T, Qualifiers Quals, final raw_ostream /*&*/ OS, 
       StringRef PlaceHolder) {
    SaveAndRestoreBool PHVal = null;
    try {
      if (!(T != null)) {
        OS.$out(/*KEEP_STR*/"NULL TYPE");
        return;
      }
      
      PHVal/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, PlaceHolder.empty());
      
      printBefore(T, new Qualifiers(Quals), OS);
      OS.$out(/*NO_COPY*/PlaceHolder);
      printAfter(T, new Qualifiers(Quals), OS);
    } finally {
      if (PHVal != null) { PHVal.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 142,
   FQN="(anonymous namespace)::TypePrinter::print", NM="_ZN12_GLOBAL__N_111TypePrinter5printEN5clang8QualTypeERN4llvm11raw_ostreamENS3_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter5printEN5clang8QualTypeERN4llvm11raw_ostreamENS3_9StringRefE")
  //</editor-fold>
  public void print(QualType t, final raw_ostream /*&*/ OS, StringRef PlaceHolder) {
    SplitQualType split = t.split();
    print(split.Ty, new Qualifiers(split.Quals), OS, new StringRef(PlaceHolder));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::canPrefixQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 161,
   FQN="(anonymous namespace)::TypePrinter::canPrefixQualifiers", NM="_ZN12_GLOBAL__N_111TypePrinter19canPrefixQualifiersEPKN5clang4TypeERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter19canPrefixQualifiersEPKN5clang4TypeERb")
  //</editor-fold>
  public static boolean canPrefixQualifiers(/*const*/ Type /*P*/ T, 
                     final bool$ref/*bool &*/ NeedARCStrongQualifier) {
    // CanPrefixQualifiers - We prefer to print type qualifiers before the type,
    // so that we get "const int" instead of "int const", but we can't do this if
    // the type is complex.  For example if the type is "int*", we *must* print
    // "int * const", printing "const int *" is different.  Only do this when the
    // type expands to a simple string.
    boolean CanPrefixQualifiers = false;
    NeedARCStrongQualifier.$set(false);
    Type.TypeClass TC = T.getTypeClass();
    {
      /*const*/ AutoType /*P*/ AT = dyn_cast_AutoType(T);
      if ((AT != null)) {
        TC = AT.desugar().$arrow().getTypeClass();
      }
    }
    {
      /*const*/ SubstTemplateTypeParmType /*P*/ Subst = dyn_cast_SubstTemplateTypeParmType(T);
      if ((Subst != null)) {
        TC = Subst.getReplacementType().$arrow().getTypeClass();
      }
    }
    switch (TC) {
     case Auto:
     case Builtin:
     case Complex:
     case UnresolvedUsing:
     case Typedef:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case Record:
     case Enum:
     case Elaborated:
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case ObjCObject:
     case ObjCInterface:
     case Atomic:
     case Pipe:
      CanPrefixQualifiers = true;
      break;
     case ObjCObjectPointer:
      CanPrefixQualifiers = T.isObjCIdType() || T.isObjCClassType()
         || T.isObjCQualifiedIdType() || T.isObjCQualifiedClassType();
      break;
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
     case DependentSizedArray:
      NeedARCStrongQualifier.$set(true);
     case Adjusted:
     case Decayed:
     case Pointer:
     case BlockPointer:
     case LValueReference:
     case RValueReference:
     case MemberPointer:
     case DependentSizedExtVector:
     case Vector:
     case ExtVector:
     case FunctionProto:
     case FunctionNoProto:
     case Paren:
     case Attributed:
     case PackExpansion:
     case SubstTemplateTypeParm:
      // Fall through
      CanPrefixQualifiers = false;
      break;
    }
    
    return CanPrefixQualifiers;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::spaceBeforePlaceHolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 137,
   FQN="(anonymous namespace)::TypePrinter::spaceBeforePlaceHolder", NM="_ZN12_GLOBAL__N_111TypePrinter22spaceBeforePlaceHolderERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter22spaceBeforePlaceHolderERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void spaceBeforePlaceHolder(final raw_ostream /*&*/ OS) {
    if (!HasEmptyPlaceHolder.$deref()) {
      OS.$out_char($$SPACE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 796,
   FQN="(anonymous namespace)::TypePrinter::printTypeSpec", NM="_ZN12_GLOBAL__N_111TypePrinter13printTypeSpecEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter13printTypeSpecEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypeSpec(/*const*/ NamedDecl /*P*/ D, final raw_ostream /*&*/ OS) {
    IdentifierInfo /*P*/ II = D.getIdentifier();
    OS.$out(II.getName());
    spaceBeforePlaceHolder(OS);
  }

  
  
  /// \brief Prints the part of the type string before an identifier, e.g. for
  /// "int foo[10]" it prints "int ".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 253,
   FQN="(anonymous namespace)::TypePrinter::printBefore", NM="_ZN12_GLOBAL__N_111TypePrinter11printBeforeEPKN5clang4TypeENS1_10QualifiersERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter11printBeforeEPKN5clang4TypeENS1_10QualifiersERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printBefore(/*const*/ Type /*P*/ T, Qualifiers Quals, final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool PrevPHIsEmpty = null;
    try {
      if (Policy.SuppressSpecifiers && T.isSpecifierType()) {
        return;
      }
      
      PrevPHIsEmpty/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder);
      
      // Print qualifiers as appropriate.
      boolean CanPrefixQualifiers = false;
      bool$ref NeedARCStrongQualifier = create_bool$ref(false);
      CanPrefixQualifiers = canPrefixQualifiers(T, NeedARCStrongQualifier);
      if (CanPrefixQualifiers && !Quals.empty()) {
        if (NeedARCStrongQualifier.$deref()) {
          IncludeStrongLifetimeRAII Strong = null;
          try {
            Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
            Quals.print(OS, Policy, /*appendSpaceIfNonEmpty=*/ true);
          } finally {
            if (Strong != null) { Strong.$destroy(); }
          }
        } else {
          Quals.print(OS, Policy, /*appendSpaceIfNonEmpty=*/ true);
        }
      }
      
      boolean hasAfterQuals = false;
      if (!CanPrefixQualifiers && !Quals.empty()) {
        hasAfterQuals = !Quals.isEmptyWhenPrinted(Policy);
        if (hasAfterQuals) {
          HasEmptyPlaceHolder.$set(false);
        }
      }
      switch (T.getTypeClass()) {
       case Builtin:
        printBuiltinBefore(cast_BuiltinType(T), OS);
        break;
       case Complex:
        printComplexBefore(cast_ComplexType(T), OS);
        break;
       case Pointer:
        printPointerBefore(cast_PointerType(T), OS);
        break;
       case BlockPointer:
        printBlockPointerBefore(cast_BlockPointerType(T), OS);
        break;
       case LValueReference:
        printLValueReferenceBefore(cast_LValueReferenceType(T), OS);
        break;
       case RValueReference:
        printRValueReferenceBefore(cast_RValueReferenceType(T), OS);
        break;
       case MemberPointer:
        printMemberPointerBefore(cast_MemberPointerType(T), OS);
        break;
       case ConstantArray:
        printConstantArrayBefore(cast_ConstantArrayType(T), OS);
        break;
       case IncompleteArray:
        printIncompleteArrayBefore(cast_IncompleteArrayType(T), OS);
        break;
       case VariableArray:
        printVariableArrayBefore(cast_VariableArrayType(T), OS);
        break;
       case DependentSizedArray:
        printDependentSizedArrayBefore(cast_DependentSizedArrayType(T), OS);
        break;
       case DependentSizedExtVector:
        printDependentSizedExtVectorBefore(cast_DependentSizedExtVectorType(T), OS);
        break;
       case Vector:
        printVectorBefore(cast_VectorType(T), OS);
        break;
       case ExtVector:
        printExtVectorBefore(cast_ExtVectorType(T), OS);
        break;
       case FunctionProto:
        printFunctionProtoBefore(cast_FunctionProtoType(T), OS);
        break;
       case FunctionNoProto:
        printFunctionNoProtoBefore(cast_FunctionNoProtoType(T), OS);
        break;
       case UnresolvedUsing:
        printUnresolvedUsingBefore(cast_UnresolvedUsingType(T), OS);
        break;
       case Paren:
        printParenBefore(cast_ParenType(T), OS);
        break;
       case Typedef:
        printTypedefBefore(cast_TypedefType(T), OS);
        break;
       case Adjusted:
        printAdjustedBefore(cast_AdjustedType(T), OS);
        break;
       case Decayed:
        printDecayedBefore(cast_DecayedType(T), OS);
        break;
       case TypeOfExpr:
        printTypeOfExprBefore(cast_TypeOfExprType(T), OS);
        break;
       case TypeOf:
        printTypeOfBefore(cast_TypeOfType(T), OS);
        break;
       case Decltype:
        printDecltypeBefore(cast_DecltypeType(T), OS);
        break;
       case UnaryTransform:
        printUnaryTransformBefore(cast_UnaryTransformType(T), OS);
        break;
       case Record:
        printRecordBefore(cast_RecordType(T), OS);
        break;
       case Enum:
        printEnumBefore(cast_EnumType(T), OS);
        break;
       case Elaborated:
        printElaboratedBefore(cast_ElaboratedType(T), OS);
        break;
       case Attributed:
        printAttributedBefore(cast_AttributedType(T), OS);
        break;
       case TemplateTypeParm:
        printTemplateTypeParmBefore(cast_TemplateTypeParmType(T), OS);
        break;
       case SubstTemplateTypeParm:
        printSubstTemplateTypeParmBefore(cast_SubstTemplateTypeParmType(T), OS);
        break;
       case SubstTemplateTypeParmPack:
        printSubstTemplateTypeParmPackBefore(cast_SubstTemplateTypeParmPackType(T), OS);
        break;
       case TemplateSpecialization:
        printTemplateSpecializationBefore(cast_TemplateSpecializationType(T), OS);
        break;
       case Auto:
        printAutoBefore(cast_AutoType(T), OS);
        break;
       case InjectedClassName:
        printInjectedClassNameBefore(cast_InjectedClassNameType(T), OS);
        break;
       case DependentName:
        printDependentNameBefore(cast_DependentNameType(T), OS);
        break;
       case DependentTemplateSpecialization:
        printDependentTemplateSpecializationBefore(cast_DependentTemplateSpecializationType(T), OS);
        break;
       case PackExpansion:
        printPackExpansionBefore(cast_PackExpansionType(T), OS);
        break;
       case ObjCObject:
        printObjCObjectBefore(cast_ObjCObjectType(T), OS);
        break;
       case ObjCInterface:
        printObjCInterfaceBefore(cast_ObjCInterfaceType(T), OS);
        break;
       case ObjCObjectPointer:
        printObjCObjectPointerBefore(cast_ObjCObjectPointerType(T), OS);
        break;
       case Pipe:
        printPipeBefore(cast_PipeType(T), OS);
        break;
       case Atomic:
        printAtomicBefore(cast_AtomicType(T), OS);
        break;
      }
      if (hasAfterQuals) {
        if (NeedARCStrongQualifier.$deref()) {
          IncludeStrongLifetimeRAII Strong = null;
          try {
            Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
            Quals.print(OS, Policy, /*appendSpaceIfNonEmpty=*/ !PrevPHIsEmpty.get());
          } finally {
            if (Strong != null) { Strong.$destroy(); }
          }
        } else {
          Quals.print(OS, Policy, /*appendSpaceIfNonEmpty=*/ !PrevPHIsEmpty.get());
        }
      }
    } finally {
      if (PrevPHIsEmpty != null) { PrevPHIsEmpty.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 238,
   FQN="(anonymous namespace)::TypePrinter::printBefore", NM="_ZN12_GLOBAL__N_111TypePrinter11printBeforeEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter11printBeforeEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printBefore(QualType T, final raw_ostream /*&*/ OS) {
    SplitQualType Split = T.split();
    
    // If we have cv1 T, where T is substituted for cv2 U, only print cv1 - cv2
    // at this level.
    Qualifiers Quals = new Qualifiers(Split.Quals);
    {
      /*const*/ SubstTemplateTypeParmType /*P*/ Subst = dyn_cast_SubstTemplateTypeParmType(Split.Ty);
      if ((Subst != null)) {
        Quals.$minusassign(new QualType(Subst, 0).getQualifiers());
      }
    }
    
    printBefore(Split.Ty, new Qualifiers(Quals), OS);
  }

  
  /// \brief Prints the part of the type string after an identifier, e.g. for
  /// "int foo[10]" it prints "[10]".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 306,
   FQN="(anonymous namespace)::TypePrinter::printAfter", NM="_ZN12_GLOBAL__N_111TypePrinter10printAfterEPKN5clang4TypeENS1_10QualifiersERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter10printAfterEPKN5clang4TypeENS1_10QualifiersERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAfter(/*const*/ Type /*P*/ T, Qualifiers Quals, final raw_ostream /*&*/ OS) {
    switch (T.getTypeClass()) {
     case Builtin:
      printBuiltinAfter(cast_BuiltinType(T), OS);
      break;
     case Complex:
      printComplexAfter(cast_ComplexType(T), OS);
      break;
     case Pointer:
      printPointerAfter(cast_PointerType(T), OS);
      break;
     case BlockPointer:
      printBlockPointerAfter(cast_BlockPointerType(T), OS);
      break;
     case LValueReference:
      printLValueReferenceAfter(cast_LValueReferenceType(T), OS);
      break;
     case RValueReference:
      printRValueReferenceAfter(cast_RValueReferenceType(T), OS);
      break;
     case MemberPointer:
      printMemberPointerAfter(cast_MemberPointerType(T), OS);
      break;
     case ConstantArray:
      printConstantArrayAfter(cast_ConstantArrayType(T), OS);
      break;
     case IncompleteArray:
      printIncompleteArrayAfter(cast_IncompleteArrayType(T), OS);
      break;
     case VariableArray:
      printVariableArrayAfter(cast_VariableArrayType(T), OS);
      break;
     case DependentSizedArray:
      printDependentSizedArrayAfter(cast_DependentSizedArrayType(T), OS);
      break;
     case DependentSizedExtVector:
      printDependentSizedExtVectorAfter(cast_DependentSizedExtVectorType(T), OS);
      break;
     case Vector:
      printVectorAfter(cast_VectorType(T), OS);
      break;
     case ExtVector:
      printExtVectorAfter(cast_ExtVectorType(T), OS);
      break;
     case FunctionProto:
      printFunctionProtoAfter(cast_FunctionProtoType(T), OS);
      break;
     case FunctionNoProto:
      printFunctionNoProtoAfter(cast_FunctionNoProtoType(T), OS);
      break;
     case UnresolvedUsing:
      printUnresolvedUsingAfter(cast_UnresolvedUsingType(T), OS);
      break;
     case Paren:
      printParenAfter(cast_ParenType(T), OS);
      break;
     case Typedef:
      printTypedefAfter(cast_TypedefType(T), OS);
      break;
     case Adjusted:
      printAdjustedAfter(cast_AdjustedType(T), OS);
      break;
     case Decayed:
      printDecayedAfter(cast_DecayedType(T), OS);
      break;
     case TypeOfExpr:
      printTypeOfExprAfter(cast_TypeOfExprType(T), OS);
      break;
     case TypeOf:
      printTypeOfAfter(cast_TypeOfType(T), OS);
      break;
     case Decltype:
      printDecltypeAfter(cast_DecltypeType(T), OS);
      break;
     case UnaryTransform:
      printUnaryTransformAfter(cast_UnaryTransformType(T), OS);
      break;
     case Record:
      printRecordAfter(cast_RecordType(T), OS);
      break;
     case Enum:
      printEnumAfter(cast_EnumType(T), OS);
      break;
     case Elaborated:
      printElaboratedAfter(cast_ElaboratedType(T), OS);
      break;
     case Attributed:
      printAttributedAfter(cast_AttributedType(T), OS);
      break;
     case TemplateTypeParm:
      printTemplateTypeParmAfter(cast_TemplateTypeParmType(T), OS);
      break;
     case SubstTemplateTypeParm:
      printSubstTemplateTypeParmAfter(cast_SubstTemplateTypeParmType(T), OS);
      break;
     case SubstTemplateTypeParmPack:
      printSubstTemplateTypeParmPackAfter(cast_SubstTemplateTypeParmPackType(T), OS);
      break;
     case TemplateSpecialization:
      printTemplateSpecializationAfter(cast_TemplateSpecializationType(T), OS);
      break;
     case Auto:
      printAutoAfter(cast_AutoType(T), OS);
      break;
     case InjectedClassName:
      printInjectedClassNameAfter(cast_InjectedClassNameType(T), OS);
      break;
     case DependentName:
      printDependentNameAfter(cast_DependentNameType(T), OS);
      break;
     case DependentTemplateSpecialization:
      printDependentTemplateSpecializationAfter(cast_DependentTemplateSpecializationType(T), OS);
      break;
     case PackExpansion:
      printPackExpansionAfter(cast_PackExpansionType(T), OS);
      break;
     case ObjCObject:
      printObjCObjectAfter(cast_ObjCObjectType(T), OS);
      break;
     case ObjCInterface:
      printObjCInterfaceAfter(cast_ObjCInterfaceType(T), OS);
      break;
     case ObjCObjectPointer:
      printObjCObjectPointerAfter(cast_ObjCObjectPointerType(T), OS);
      break;
     case Pipe:
      printPipeAfter(cast_PipeType(T), OS);
      break;
     case Atomic:
      printAtomicAfter(cast_AtomicType(T), OS);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 299,
   FQN="(anonymous namespace)::TypePrinter::printAfter", NM="_ZN12_GLOBAL__N_111TypePrinter10printAfterEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter10printAfterEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAfter(QualType t, final raw_ostream /*&*/ OS) {
    SplitQualType split = t.split();
    printAfter(split.Ty, new Qualifiers(split.Quals), OS);
  }

  /// Appends the given scope to the end of a string.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::AppendScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 908,
   FQN="(anonymous namespace)::TypePrinter::AppendScope", NM="_ZN12_GLOBAL__N_111TypePrinter11AppendScopeEPN5clang11DeclContextERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter11AppendScopeEPN5clang11DeclContextERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void AppendScope(DeclContext /*P*/ DC, final raw_ostream /*&*/ OS) {
    if (DC.isTranslationUnit()) {
      return;
    }
    if (DC.isFunctionOrMethod()) {
      return;
    }
    AppendScope(DC.getParent(), OS);
    {
      
      NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(DC);
      if ((NS != null)) {
        if (Policy.SuppressUnwrittenScope
           && (NS.isAnonymousNamespace() || NS.isInline())) {
          return;
        }
        if ((NS.getIdentifier() != null)) {
          OS.$out(NS.getName()).$out(/*KEEP_STR*/$COLON_COLON);
        } else {
          OS.$out(/*KEEP_STR*/"(anonymous namespace)::");
        }
      } else {
        ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(DC);
        if ((Spec != null)) {
          IncludeStrongLifetimeRAII Strong = null;
          try {
            Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
            OS.$out(Spec.getIdentifier().getName());
            final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = Spec.getTemplateArgs();
            TemplateSpecializationType.PrintTemplateArgumentList1(OS, TemplateArgs.asArray(), Policy);
            OS.$out(/*KEEP_STR*/$COLON_COLON);
          } finally {
            if (Strong != null) { Strong.$destroy(); }
          }
        } else {
          TagDecl /*P*/ Tag = dyn_cast_TagDecl(DC);
          if ((Tag != null)) {
            {
              TypedefNameDecl /*P*/ Typedef = Tag.getTypedefNameForAnonDecl();
              if ((Typedef != null)) {
                OS.$out(Typedef.getIdentifier().getName()).$out(/*KEEP_STR*/$COLON_COLON);
              } else if ((Tag.getIdentifier() != null)) {
                OS.$out(Tag.getIdentifier().getName()).$out(/*KEEP_STR*/$COLON_COLON);
              } else {
                return;
              }
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 939,
   FQN="(anonymous namespace)::TypePrinter::printTag", NM="_ZN12_GLOBAL__N_111TypePrinter8printTagEPN5clang7TagDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter8printTagEPN5clang7TagDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTag(TagDecl /*P*/ D, final raw_ostream /*&*/ OS) {
    if (Policy.IncludeTagDefinition) {
      PrintingPolicy SubPolicy = new PrintingPolicy(Policy);
      SubPolicy.IncludeTagDefinition = false;
      D.print(OS, SubPolicy, Indentation);
      spaceBeforePlaceHolder(OS);
      return;
    }
    
    boolean HasKindDecoration = false;
    
    // We don't print tags unless this is an elaborated type.
    // In C, we just assume every RecordType is an elaborated type.
    if (!Policy.SuppressTagKeyword && !(D.getTypedefNameForAnonDecl() != null)) {
      HasKindDecoration = true;
      OS.$out(D.getKindName());
      OS.$out_char($$SPACE);
    }
    
    // Compute the full nested-name-specifier for this type.
    // In C, this will always be empty except when the type
    // being printed is anonymous within other Record.
    if (!Policy.SuppressScope) {
      AppendScope(D.getDeclContext(), OS);
    }
    {
      
      /*const*/ IdentifierInfo /*P*/ II = D.getIdentifier();
      if ((II != null)) {
        OS.$out(II.getName());
      } else {
        TypedefNameDecl /*P*/ Typedef = D.getTypedefNameForAnonDecl();
        if ((Typedef != null)) {
          assert ((Typedef.getIdentifier() != null)) : "Typedef without identifier?";
          OS.$out(Typedef.getIdentifier().getName());
        } else {
          // Make an unambiguous representation for anonymous types, e.g.
          //   (anonymous enum at /usr/include/string.h:120:9)
          OS.$out_char((Policy.MSVCFormatting ? $$BACKQUOTE : $$LPAREN));
          if (isa_CXXRecordDecl(D) && cast_CXXRecordDecl(D).isLambda()) {
            OS.$out(/*KEEP_STR*/"lambda");
            HasKindDecoration = true;
          } else {
            OS.$out(/*KEEP_STR*/"anonymous");
          }
          if (Policy.AnonymousTagLocations) {
            // Suppress the redundant tag keyword if we just printed one.
            // We don't have to worry about ElaboratedTypes here because you can't
            // refer to an anonymous type with one.
            if (!HasKindDecoration) {
              OS.$out(/*KEEP_STR*/$SPACE).$out(D.getKindName());
            }
            
            PresumedLoc PLoc = D.getASTContext().getSourceManager().getPresumedLoc(D.getLocation());
            if (PLoc.isValid()) {
              OS.$out(/*KEEP_STR*/" at ").$out(PLoc.getFilename()).$out_char(
                  $$COLON
              ).$out_uint(PLoc.getLine()).$out_char(
                  $$COLON
              ).$out_uint(PLoc.getColumn());
            }
          }
          
          OS.$out_char((Policy.MSVCFormatting ? $$SGL_QUOTE : $$RPAREN));
        }
      }
    }
    {
      
      // If this is a class template specialization, print the template
      // arguments.
      ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(D);
      if ((Spec != null)) {
        IncludeStrongLifetimeRAII Strong = null;
        try {
          ArrayRef<TemplateArgument> Args/*J*/= new ArrayRef<TemplateArgument>(false);
          {
            TypeSourceInfo /*P*/ TAW = Spec.getTypeAsWritten();
            if ((TAW != null)) {
              /*const*/ TemplateSpecializationType /*P*/ TST = cast_TemplateSpecializationType(TAW.getType());
              Args.$assignMove(TST.template_arguments());
            } else {
              final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = Spec.getTemplateArgs();
              // JAVA: take array
              Args = (TemplateArgs.asArray());
            }
          }
          Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
          TemplateSpecializationType.PrintTemplateArgumentList1(OS, new ArrayRef<TemplateArgument>(Args), Policy);
        } finally {
          if (Strong != null) { Strong.$destroy(); }
        }
      }
    }
    
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printBuiltinBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 316,
   FQN="(anonymous namespace)::TypePrinter::printBuiltinBefore", NM="_ZN12_GLOBAL__N_111TypePrinter18printBuiltinBeforeEPKN5clang11BuiltinTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printBuiltinBeforeEPKN5clang11BuiltinTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printBuiltinBefore(/*const*/ BuiltinType /*P*/ T, final raw_ostream /*&*/ OS) {
    OS.$out(T.getName(Policy));
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printBuiltinAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 320,
   FQN="(anonymous namespace)::TypePrinter::printBuiltinAfter", NM="_ZN12_GLOBAL__N_111TypePrinter17printBuiltinAfterEPKN5clang11BuiltinTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printBuiltinAfterEPKN5clang11BuiltinTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printBuiltinAfter(/*const*/ BuiltinType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printComplexBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 322,
   FQN="(anonymous namespace)::TypePrinter::printComplexBefore", NM="_ZN12_GLOBAL__N_111TypePrinter18printComplexBeforeEPKN5clang11ComplexTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printComplexBeforeEPKN5clang11ComplexTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printComplexBefore(/*const*/ ComplexType /*P*/ T, final raw_ostream /*&*/ OS) {
    OS.$out(/*KEEP_STR*/"_Complex ");
    printBefore(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printComplexAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 326,
   FQN="(anonymous namespace)::TypePrinter::printComplexAfter", NM="_ZN12_GLOBAL__N_111TypePrinter17printComplexAfterEPKN5clang11ComplexTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printComplexAfterEPKN5clang11ComplexTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printComplexAfter(/*const*/ ComplexType /*P*/ T, final raw_ostream /*&*/ OS) {
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printPointerBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 330,
   FQN="(anonymous namespace)::TypePrinter::printPointerBefore", NM="_ZN12_GLOBAL__N_111TypePrinter18printPointerBeforeEPKN5clang11PointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printPointerBeforeEPKN5clang11PointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPointerBefore(/*const*/ PointerType /*P*/ T, final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getPointeeType(), OS);
      // Handle things like 'int (*A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeType())) {
        OS.$out_char($$LPAREN);
      }
      OS.$out_char($$STAR);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printPointerAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 340,
   FQN="(anonymous namespace)::TypePrinter::printPointerAfter", NM="_ZN12_GLOBAL__N_111TypePrinter17printPointerAfterEPKN5clang11PointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printPointerAfterEPKN5clang11PointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPointerAfter(/*const*/ PointerType /*P*/ T, final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      // Handle things like 'int (*A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeType())) {
        OS.$out_char($$RPAREN);
      }
      printAfter(T.getPointeeType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printBlockPointerBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 350,
   FQN="(anonymous namespace)::TypePrinter::printBlockPointerBefore", NM="_ZN12_GLOBAL__N_111TypePrinter23printBlockPointerBeforeEPKN5clang16BlockPointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printBlockPointerBeforeEPKN5clang16BlockPointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printBlockPointerBefore(/*const*/ BlockPointerType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getPointeeType(), OS);
      OS.$out_char($$CARET);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printBlockPointerAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 356,
   FQN="(anonymous namespace)::TypePrinter::printBlockPointerAfter", NM="_ZN12_GLOBAL__N_111TypePrinter22printBlockPointerAfterEPKN5clang16BlockPointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter22printBlockPointerAfterEPKN5clang16BlockPointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printBlockPointerAfter(/*const*/ BlockPointerType /*P*/ T, 
                        final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printAfter(T.getPointeeType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printLValueReferenceBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 362,
   FQN="(anonymous namespace)::TypePrinter::printLValueReferenceBefore", NM="_ZN12_GLOBAL__N_111TypePrinter26printLValueReferenceBeforeEPKN5clang19LValueReferenceTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter26printLValueReferenceBeforeEPKN5clang19LValueReferenceTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printLValueReferenceBefore(/*const*/ LValueReferenceType /*P*/ T, 
                            final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getPointeeTypeAsWritten(), OS);
      // Handle things like 'int (&A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeTypeAsWritten())) {
        OS.$out_char($$LPAREN);
      }
      OS.$out_char($$AMP);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printLValueReferenceAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 373,
   FQN="(anonymous namespace)::TypePrinter::printLValueReferenceAfter", NM="_ZN12_GLOBAL__N_111TypePrinter25printLValueReferenceAfterEPKN5clang19LValueReferenceTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter25printLValueReferenceAfterEPKN5clang19LValueReferenceTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printLValueReferenceAfter(/*const*/ LValueReferenceType /*P*/ T, 
                           final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      // Handle things like 'int (&A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeTypeAsWritten())) {
        OS.$out_char($$RPAREN);
      }
      printAfter(T.getPointeeTypeAsWritten(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printRValueReferenceBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 384,
   FQN="(anonymous namespace)::TypePrinter::printRValueReferenceBefore", NM="_ZN12_GLOBAL__N_111TypePrinter26printRValueReferenceBeforeEPKN5clang19RValueReferenceTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter26printRValueReferenceBeforeEPKN5clang19RValueReferenceTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printRValueReferenceBefore(/*const*/ RValueReferenceType /*P*/ T, 
                            final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getPointeeTypeAsWritten(), OS);
      // Handle things like 'int (&&A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeTypeAsWritten())) {
        OS.$out_char($$LPAREN);
      }
      OS.$out(/*KEEP_STR*/$AMP_AMP);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printRValueReferenceAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 395,
   FQN="(anonymous namespace)::TypePrinter::printRValueReferenceAfter", NM="_ZN12_GLOBAL__N_111TypePrinter25printRValueReferenceAfterEPKN5clang19RValueReferenceTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter25printRValueReferenceAfterEPKN5clang19RValueReferenceTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printRValueReferenceAfter(/*const*/ RValueReferenceType /*P*/ T, 
                           final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      // Handle things like 'int (&&A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeTypeAsWritten())) {
        OS.$out_char($$RPAREN);
      }
      printAfter(T.getPointeeTypeAsWritten(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printMemberPointerBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 406,
   FQN="(anonymous namespace)::TypePrinter::printMemberPointerBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printMemberPointerBeforeEPKN5clang17MemberPointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printMemberPointerBeforeEPKN5clang17MemberPointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printMemberPointerBefore(/*const*/ MemberPointerType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getPointeeType(), OS);
      // Handle things like 'int (Cls::*A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeType())) {
        OS.$out_char($$LPAREN);
      }
      
      PrintingPolicy InnerPolicy/*J*/= new PrintingPolicy(Policy);
      InnerPolicy.IncludeTagDefinition = false;
      new TypePrinter(InnerPolicy).print(new QualType(T.__getClass(), 0), OS, new StringRef());
      
      OS.$out(/*KEEP_STR*/"::*");
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printMemberPointerAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 422,
   FQN="(anonymous namespace)::TypePrinter::printMemberPointerAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printMemberPointerAfterEPKN5clang17MemberPointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printMemberPointerAfterEPKN5clang17MemberPointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printMemberPointerAfter(/*const*/ MemberPointerType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      // Handle things like 'int (Cls::*A)[4];' correctly.
      // FIXME: this should include vectors, but vectors use attributes I guess.
      if (isa_ArrayType(T.getPointeeType())) {
        OS.$out_char($$RPAREN);
      }
      printAfter(T.getPointeeType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printConstantArrayBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 433,
   FQN="(anonymous namespace)::TypePrinter::printConstantArrayBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printConstantArrayBeforeEPKN5clang17ConstantArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printConstantArrayBeforeEPKN5clang17ConstantArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printConstantArrayBefore(/*const*/ ConstantArrayType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getElementType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printConstantArrayAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 439,
   FQN="(anonymous namespace)::TypePrinter::printConstantArrayAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printConstantArrayAfterEPKN5clang17ConstantArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printConstantArrayAfterEPKN5clang17ConstantArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printConstantArrayAfter(/*const*/ ConstantArrayType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
    OS.$out_char($$LSQUARE);
    if (T.getIndexTypeQualifiers().hasQualifiers()) {
      AppendTypeQualList(OS, T.getIndexTypeCVRQualifiers(), 
          Policy.Restrict);
      OS.$out_char($$SPACE);
    }
    if (T.getSizeModifier() == ArrayType.ArraySizeModifier.Static) {
      OS.$out(/*KEEP_STR*/"static ");
    }
    
    OS.$out_ullong(T.getSize().getZExtValue()).$out_char($$RSQUARE);
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printIncompleteArrayBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 455,
   FQN="(anonymous namespace)::TypePrinter::printIncompleteArrayBefore", NM="_ZN12_GLOBAL__N_111TypePrinter26printIncompleteArrayBeforeEPKN5clang19IncompleteArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter26printIncompleteArrayBeforeEPKN5clang19IncompleteArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printIncompleteArrayBefore(/*const*/ IncompleteArrayType /*P*/ T, 
                            final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getElementType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printIncompleteArrayAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 461,
   FQN="(anonymous namespace)::TypePrinter::printIncompleteArrayAfter", NM="_ZN12_GLOBAL__N_111TypePrinter25printIncompleteArrayAfterEPKN5clang19IncompleteArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter25printIncompleteArrayAfterEPKN5clang19IncompleteArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printIncompleteArrayAfter(/*const*/ IncompleteArrayType /*P*/ T, 
                           final raw_ostream /*&*/ OS) {
    OS.$out(/*KEEP_STR*/$LSQUARE_RSQUARE);
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printVariableArrayBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 467,
   FQN="(anonymous namespace)::TypePrinter::printVariableArrayBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printVariableArrayBeforeEPKN5clang17VariableArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printVariableArrayBeforeEPKN5clang17VariableArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printVariableArrayBefore(/*const*/ VariableArrayType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getElementType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printVariableArrayAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 473,
   FQN="(anonymous namespace)::TypePrinter::printVariableArrayAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printVariableArrayAfterEPKN5clang17VariableArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printVariableArrayAfterEPKN5clang17VariableArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printVariableArrayAfter(/*const*/ VariableArrayType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
    OS.$out_char($$LSQUARE);
    if (T.getIndexTypeQualifiers().hasQualifiers()) {
      AppendTypeQualList(OS, T.getIndexTypeCVRQualifiers(), Policy.Restrict);
      OS.$out_char($$SPACE);
    }
    if (T.getSizeModifier() == VariableArrayType.ArraySizeModifier.Static) {
      OS.$out(/*KEEP_STR*/"static ");
    } else if (T.getSizeModifier() == VariableArrayType.ArraySizeModifier.Star) {
      OS.$out_char($$STAR);
    }
    if ((T.getSizeExpr() != null)) {
      T.getSizeExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
    }
    OS.$out_char($$RSQUARE);
    
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentSizedArrayBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 510,
   FQN="(anonymous namespace)::TypePrinter::printDependentSizedArrayBefore", NM="_ZN12_GLOBAL__N_111TypePrinter30printDependentSizedArrayBeforeEPKN5clang23DependentSizedArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter30printDependentSizedArrayBeforeEPKN5clang23DependentSizedArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentSizedArrayBefore(/*const*/ DependentSizedArrayType /*P*/ T, 
                                final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getElementType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentSizedArrayAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 517,
   FQN="(anonymous namespace)::TypePrinter::printDependentSizedArrayAfter", NM="_ZN12_GLOBAL__N_111TypePrinter29printDependentSizedArrayAfterEPKN5clang23DependentSizedArrayTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter29printDependentSizedArrayAfterEPKN5clang23DependentSizedArrayTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentSizedArrayAfter(/*const*/ DependentSizedArrayType /*P*/ T, 
                               final raw_ostream /*&*/ OS) {
    OS.$out_char($$LSQUARE);
    if ((T.getSizeExpr() != null)) {
      T.getSizeExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
    }
    OS.$out_char($$RSQUARE);
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentSizedExtVectorBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 527,
   FQN="(anonymous namespace)::TypePrinter::printDependentSizedExtVectorBefore", NM="_ZN12_GLOBAL__N_111TypePrinter34printDependentSizedExtVectorBeforeEPKN5clang27DependentSizedExtVectorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter34printDependentSizedExtVectorBeforeEPKN5clang27DependentSizedExtVectorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentSizedExtVectorBefore(/*const*/ DependentSizedExtVectorType /*P*/ T, 
                                    final raw_ostream /*&*/ OS) {
    printBefore(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentSizedExtVectorAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 532,
   FQN="(anonymous namespace)::TypePrinter::printDependentSizedExtVectorAfter", NM="_ZN12_GLOBAL__N_111TypePrinter33printDependentSizedExtVectorAfterEPKN5clang27DependentSizedExtVectorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter33printDependentSizedExtVectorAfterEPKN5clang27DependentSizedExtVectorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentSizedExtVectorAfter(/*const*/ DependentSizedExtVectorType /*P*/ T, 
                                   final raw_ostream /*&*/ OS) {
    OS.$out(/*KEEP_STR*/" __attribute__((ext_vector_type(");
    if ((T.getSizeExpr() != null)) {
      T.getSizeExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
    }
    OS.$out(/*KEEP_STR*/")))");
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printVectorBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 542,
   FQN="(anonymous namespace)::TypePrinter::printVectorBefore", NM="_ZN12_GLOBAL__N_111TypePrinter17printVectorBeforeEPKN5clang10VectorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printVectorBeforeEPKN5clang10VectorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printVectorBefore(/*const*/ VectorType /*P*/ T, final raw_ostream /*&*/ OS) {
    switch (T.getVectorKind()) {
     case AltiVecPixel:
      OS.$out(/*KEEP_STR*/"__vector __pixel ");
      break;
     case AltiVecBool:
      OS.$out(/*KEEP_STR*/"__vector __bool ");
      printBefore(T.getElementType(), OS);
      break;
     case AltiVecVector:
      OS.$out(/*KEEP_STR*/"__vector ");
      printBefore(T.getElementType(), OS);
      break;
     case NeonVector:
      OS.$out(/*KEEP_STR*/"__attribute__((neon_vector_type(").$out_uint(
          T.getNumElements()
      ).$out(/*KEEP_STR*/"))) ");
      printBefore(T.getElementType(), OS);
      break;
     case NeonPolyVector:
      OS.$out(/*KEEP_STR*/"__attribute__((neon_polyvector_type(").$out_uint(
          T.getNumElements()
      ).$out(/*KEEP_STR*/"))) ");
      printBefore(T.getElementType(), OS);
      break;
     case GenericVector:
      {
        // FIXME: We prefer to print the size directly here, but have no way
        // to get the size of the type.
        OS.$out(/*KEEP_STR*/"__attribute__((__vector_size__(").$out_uint(
            T.getNumElements()
        ).$out(
            /*KEEP_STR*/" * sizeof("
        );
        print(T.getElementType(), OS, new StringRef());
        OS.$out(/*KEEP_STR*/")))) ");
        printBefore(T.getElementType(), OS);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printVectorAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 578,
   FQN="(anonymous namespace)::TypePrinter::printVectorAfter", NM="_ZN12_GLOBAL__N_111TypePrinter16printVectorAfterEPKN5clang10VectorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter16printVectorAfterEPKN5clang10VectorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printVectorAfter(/*const*/ VectorType /*P*/ T, final raw_ostream /*&*/ OS) {
    printAfter(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printExtVectorBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 582,
   FQN="(anonymous namespace)::TypePrinter::printExtVectorBefore", NM="_ZN12_GLOBAL__N_111TypePrinter20printExtVectorBeforeEPKN5clang13ExtVectorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter20printExtVectorBeforeEPKN5clang13ExtVectorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printExtVectorBefore(/*const*/ ExtVectorType /*P*/ T, 
                      final raw_ostream /*&*/ OS) {
    printBefore(T.getElementType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printExtVectorAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 586,
   FQN="(anonymous namespace)::TypePrinter::printExtVectorAfter", NM="_ZN12_GLOBAL__N_111TypePrinter19printExtVectorAfterEPKN5clang13ExtVectorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter19printExtVectorAfterEPKN5clang13ExtVectorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printExtVectorAfter(/*const*/ ExtVectorType /*P*/ T, final raw_ostream /*&*/ OS) {
    printAfter(T.getElementType(), OS);
    OS.$out(/*KEEP_STR*/" __attribute__((ext_vector_type(");
    OS.$out_uint(T.getNumElements());
    OS.$out(/*KEEP_STR*/")))");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printFunctionProtoBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 621,
   FQN="(anonymous namespace)::TypePrinter::printFunctionProtoBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printFunctionProtoBeforeEPKN5clang17FunctionProtoTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printFunctionProtoBeforeEPKN5clang17FunctionProtoTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printFunctionProtoBefore(/*const*/ FunctionProtoType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    if (T.hasTrailingReturn()) {
      OS.$out(/*KEEP_STR*/"auto ");
      if (!HasEmptyPlaceHolder.$deref()) {
        OS.$out_char($$LPAREN);
      }
    } else {
      SaveAndRestoreBool PrevPHIsEmpty = null;
      try {
        // If needed for precedence reasons, wrap the inner part in grouping parens.
        PrevPHIsEmpty/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
        printBefore(T.getReturnType(), OS);
        if (!PrevPHIsEmpty.get()) {
          OS.$out_char($$LPAREN);
        }
      } finally {
        if (PrevPHIsEmpty != null) { PrevPHIsEmpty.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printFunctionProtoAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 650,
   FQN="(anonymous namespace)::TypePrinter::printFunctionProtoAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printFunctionProtoAfterEPKN5clang17FunctionProtoTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printFunctionProtoAfterEPKN5clang17FunctionProtoTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printFunctionProtoAfter(/*const*/ FunctionProtoType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      // If needed for precedence reasons, wrap the inner part in grouping parens.
      if (!HasEmptyPlaceHolder.$deref()) {
        OS.$out_char($$RPAREN);
      }
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      
      OS.$out_char($$LPAREN);
      {
        ParamPolicyRAII ParamPolicy = null;
        try {
          ParamPolicy/*J*/= new ParamPolicyRAII(Policy);
          for (/*uint*/int i = 0, e = T.getNumParams(); i != e; ++i) {
            if ((i != 0)) {
              OS.$out(/*KEEP_STR*/$COMMA_SPACE);
            }
            
            ExtParameterInfo EPI = T.getExtParameterInfo(i);
            if (EPI.isConsumed()) {
              OS.$out(/*KEEP_STR*/"__attribute__((ns_consumed)) ");
            }
            ParameterABI ABI = EPI.getABI();
            if (ABI != ParameterABI.Ordinary) {
              OS.$out(/*KEEP_STR*/"__attribute__((").$out(getParameterABISpelling(ABI)).$out(/*KEEP_STR*/")) ");
            }
            
            print(T.getParamType(i), OS, new StringRef());
          }
        } finally {
          if (ParamPolicy != null) { ParamPolicy.$destroy(); }
        }
      }
      if (T.isVariadic()) {
        if ((T.getNumParams() != 0)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        OS.$out(/*KEEP_STR*/$ELLIPSIS);
      } else if (T.getNumParams() == 0 && Policy.UseVoidForZeroParams) {
        // Do not emit int() if we have a proto, emit 'int(void)'.
        OS.$out(/*KEEP_STR*/$void);
      }
      
      OS.$out_char($$RPAREN);
      
      FunctionType.ExtInfo Info = T.getExtInfo();
      if (!InsideCCAttribute.$deref()) {
        switch (Info.getCC()) {
         case CC_C:
          // The C calling convention is the default on the vast majority of platforms
          // we support.  If the user wrote it explicitly, it will usually be printed
          // while traversing the AttributedType.  If the type has been desugared, let
          // the canonical spelling be the implicit calling convention.
          // FIXME: It would be better to be explicit in certain contexts, such as a
          // cdecl function typedef used to declare a member function with the
          // Microsoft C++ ABI.
          break;
         case CC_X86StdCall:
          OS.$out(/*KEEP_STR*/" __attribute__((stdcall))");
          break;
         case CC_X86FastCall:
          OS.$out(/*KEEP_STR*/" __attribute__((fastcall))");
          break;
         case CC_X86ThisCall:
          OS.$out(/*KEEP_STR*/" __attribute__((thiscall))");
          break;
         case CC_X86VectorCall:
          OS.$out(/*KEEP_STR*/" __attribute__((vectorcall))");
          break;
         case CC_X86Pascal:
          OS.$out(/*KEEP_STR*/" __attribute__((pascal))");
          break;
         case CC_AAPCS:
          OS.$out(/*KEEP_STR*/" __attribute__((pcs(\"aapcs\")))");
          break;
         case CC_AAPCS_VFP:
          OS.$out(/*KEEP_STR*/" __attribute__((pcs(\"aapcs-vfp\")))");
          break;
         case CC_IntelOclBicc:
          OS.$out(/*KEEP_STR*/" __attribute__((intel_ocl_bicc))");
          break;
         case CC_X86_64Win64:
          OS.$out(/*KEEP_STR*/" __attribute__((ms_abi))");
          break;
         case CC_X86_64SysV:
          OS.$out(/*KEEP_STR*/" __attribute__((sysv_abi))");
          break;
         case CC_SpirFunction:
         case CC_OpenCLKernel:
          // Do nothing. These CCs are not available as attributes.
          break;
         case CC_Swift:
          OS.$out(/*KEEP_STR*/" __attribute__((swiftcall))");
          break;
         case CC_PreserveMost:
          OS.$out(/*KEEP_STR*/" __attribute__((preserve_most))");
          break;
         case CC_PreserveAll:
          OS.$out(/*KEEP_STR*/" __attribute__((preserve_all))");
          break;
        }
      }
      if (Info.getNoReturn()) {
        OS.$out(/*KEEP_STR*/" __attribute__((noreturn))");
      }
      if ((Info.getRegParm() != 0)) {
        OS.$out(/*KEEP_STR*/" __attribute__((regparm (").$out_uint(
            Info.getRegParm()
        ).$out(/*KEEP_STR*/")))");
      }
      {
        
        /*uint*/int quals = T.getTypeQuals();
        if ((quals != 0)) {
          OS.$out_char($$SPACE);
          AppendTypeQualList(OS, quals, Policy.Restrict);
        }
      }
      switch (T.getRefQualifier()) {
       case RQ_None:
        break;
       case RQ_LValue:
        OS.$out(/*KEEP_STR*/" &");
        break;
       case RQ_RValue:
        OS.$out(/*KEEP_STR*/" &&");
        break;
      }
      T.printExceptionSpecification(OS, Policy);
      if (T.hasTrailingReturn()) {
        OS.$out(/*KEEP_STR*/" -> ");
        print(T.getReturnType(), OS, new StringRef());
      } else {
        printAfter(T.getReturnType(), OS);
      }
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printFunctionNoProtoBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 775,
   FQN="(anonymous namespace)::TypePrinter::printFunctionNoProtoBefore", NM="_ZN12_GLOBAL__N_111TypePrinter26printFunctionNoProtoBeforeEPKN5clang19FunctionNoProtoTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter26printFunctionNoProtoBeforeEPKN5clang19FunctionNoProtoTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printFunctionNoProtoBefore(/*const*/ FunctionNoProtoType /*P*/ T, 
                            final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool PrevPHIsEmpty = null;
    try {
      // If needed for precedence reasons, wrap the inner part in grouping parens.
      PrevPHIsEmpty/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      printBefore(T.getReturnType(), OS);
      if (!PrevPHIsEmpty.get()) {
        OS.$out_char($$LPAREN);
      }
    } finally {
      if (PrevPHIsEmpty != null) { PrevPHIsEmpty.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printFunctionNoProtoAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 783,
   FQN="(anonymous namespace)::TypePrinter::printFunctionNoProtoAfter", NM="_ZN12_GLOBAL__N_111TypePrinter25printFunctionNoProtoAfterEPKN5clang19FunctionNoProtoTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter25printFunctionNoProtoAfterEPKN5clang19FunctionNoProtoTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printFunctionNoProtoAfter(/*const*/ FunctionNoProtoType /*P*/ T, 
                           final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool NonEmptyPH = null;
    try {
      // If needed for precedence reasons, wrap the inner part in grouping parens.
      if (!HasEmptyPlaceHolder.$deref()) {
        OS.$out_char($$RPAREN);
      }
      NonEmptyPH/*J*/= new SaveAndRestoreBool(HasEmptyPlaceHolder, false);
      
      OS.$out(/*KEEP_STR*/$LPAREN_RPAREN);
      if (T.getNoReturnAttr()) {
        OS.$out(/*KEEP_STR*/" __attribute__((noreturn))");
      }
      printAfter(T.getReturnType(), OS);
    } finally {
      if (NonEmptyPH != null) { NonEmptyPH.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printUnresolvedUsingBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 802,
   FQN="(anonymous namespace)::TypePrinter::printUnresolvedUsingBefore", NM="_ZN12_GLOBAL__N_111TypePrinter26printUnresolvedUsingBeforeEPKN5clang19UnresolvedUsingTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter26printUnresolvedUsingBeforeEPKN5clang19UnresolvedUsingTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printUnresolvedUsingBefore(/*const*/ UnresolvedUsingType /*P*/ T, 
                            final raw_ostream /*&*/ OS) {
    printTypeSpec(T.getDecl(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printUnresolvedUsingAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 806,
   FQN="(anonymous namespace)::TypePrinter::printUnresolvedUsingAfter", NM="_ZN12_GLOBAL__N_111TypePrinter25printUnresolvedUsingAfterEPKN5clang19UnresolvedUsingTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter25printUnresolvedUsingAfterEPKN5clang19UnresolvedUsingTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printUnresolvedUsingAfter(/*const*/ UnresolvedUsingType /*P*/ T, 
                           final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printParenBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1110,
   FQN="(anonymous namespace)::TypePrinter::printParenBefore", NM="_ZN12_GLOBAL__N_111TypePrinter16printParenBeforeEPKN5clang9ParenTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter16printParenBeforeEPKN5clang9ParenTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printParenBefore(/*const*/ ParenType /*P*/ T, final raw_ostream /*&*/ OS) {
    if (!HasEmptyPlaceHolder.$deref() && !isa_FunctionType(T.getInnerType())) {
      printBefore(T.getInnerType(), OS);
      OS.$out_char($$LPAREN);
    } else {
      printBefore(T.getInnerType(), OS);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printParenAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1117,
   FQN="(anonymous namespace)::TypePrinter::printParenAfter", NM="_ZN12_GLOBAL__N_111TypePrinter15printParenAfterEPKN5clang9ParenTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter15printParenAfterEPKN5clang9ParenTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printParenAfter(/*const*/ ParenType /*P*/ T, final raw_ostream /*&*/ OS) {
    if (!HasEmptyPlaceHolder.$deref() && !isa_FunctionType(T.getInnerType())) {
      OS.$out_char($$RPAREN);
      printAfter(T.getInnerType(), OS);
    } else {
      printAfter(T.getInnerType(), OS);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypedefBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 809,
   FQN="(anonymous namespace)::TypePrinter::printTypedefBefore", NM="_ZN12_GLOBAL__N_111TypePrinter18printTypedefBeforeEPKN5clang11TypedefTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printTypedefBeforeEPKN5clang11TypedefTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypedefBefore(/*const*/ TypedefType /*P*/ T, final raw_ostream /*&*/ OS) {
    printTypeSpec(T.getDecl(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypedefAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 812,
   FQN="(anonymous namespace)::TypePrinter::printTypedefAfter", NM="_ZN12_GLOBAL__N_111TypePrinter17printTypedefAfterEPKN5clang11TypedefTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printTypedefAfterEPKN5clang11TypedefTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypedefAfter(/*const*/ TypedefType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAdjustedBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 493,
   FQN="(anonymous namespace)::TypePrinter::printAdjustedBefore", NM="_ZN12_GLOBAL__N_111TypePrinter19printAdjustedBeforeEPKN5clang12AdjustedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter19printAdjustedBeforeEPKN5clang12AdjustedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAdjustedBefore(/*const*/ AdjustedType /*P*/ T, final raw_ostream /*&*/ OS) {
    // Print the adjusted representation, otherwise the adjustment will be
    // invisible.
    printBefore(T.getAdjustedType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAdjustedAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 498,
   FQN="(anonymous namespace)::TypePrinter::printAdjustedAfter", NM="_ZN12_GLOBAL__N_111TypePrinter18printAdjustedAfterEPKN5clang12AdjustedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printAdjustedAfterEPKN5clang12AdjustedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAdjustedAfter(/*const*/ AdjustedType /*P*/ T, final raw_ostream /*&*/ OS) {
    printAfter(T.getAdjustedType(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDecayedBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 502,
   FQN="(anonymous namespace)::TypePrinter::printDecayedBefore", NM="_ZN12_GLOBAL__N_111TypePrinter18printDecayedBeforeEPKN5clang11DecayedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printDecayedBeforeEPKN5clang11DecayedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDecayedBefore(/*const*/ DecayedType /*P*/ T, final raw_ostream /*&*/ OS) {
    // Print as though it's a pointer.
    printAdjustedBefore(T, OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDecayedAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 506,
   FQN="(anonymous namespace)::TypePrinter::printDecayedAfter", NM="_ZN12_GLOBAL__N_111TypePrinter17printDecayedAfterEPKN5clang11DecayedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printDecayedAfterEPKN5clang11DecayedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDecayedAfter(/*const*/ DecayedType /*P*/ T, final raw_ostream /*&*/ OS) {
    printAdjustedAfter(T, OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypeOfExprBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 814,
   FQN="(anonymous namespace)::TypePrinter::printTypeOfExprBefore", NM="_ZN12_GLOBAL__N_111TypePrinter21printTypeOfExprBeforeEPKN5clang14TypeOfExprTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter21printTypeOfExprBeforeEPKN5clang14TypeOfExprTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypeOfExprBefore(/*const*/ TypeOfExprType /*P*/ T, 
                       final raw_ostream /*&*/ OS) {
    OS.$out(/*KEEP_STR*/"typeof ");
    if ((T.getUnderlyingExpr() != null)) {
      T.getUnderlyingExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
    }
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypeOfExprAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 821,
   FQN="(anonymous namespace)::TypePrinter::printTypeOfExprAfter", NM="_ZN12_GLOBAL__N_111TypePrinter20printTypeOfExprAfterEPKN5clang14TypeOfExprTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter20printTypeOfExprAfterEPKN5clang14TypeOfExprTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypeOfExprAfter(/*const*/ TypeOfExprType /*P*/ T, 
                      final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypeOfBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 824,
   FQN="(anonymous namespace)::TypePrinter::printTypeOfBefore", NM="_ZN12_GLOBAL__N_111TypePrinter17printTypeOfBeforeEPKN5clang10TypeOfTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printTypeOfBeforeEPKN5clang10TypeOfTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypeOfBefore(/*const*/ TypeOfType /*P*/ T, final raw_ostream /*&*/ OS) {
    OS.$out(/*KEEP_STR*/"typeof(");
    print(T.getUnderlyingType(), OS, new StringRef());
    OS.$out_char($$RPAREN);
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTypeOfAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 830,
   FQN="(anonymous namespace)::TypePrinter::printTypeOfAfter", NM="_ZN12_GLOBAL__N_111TypePrinter16printTypeOfAfterEPKN5clang10TypeOfTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter16printTypeOfAfterEPKN5clang10TypeOfTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTypeOfAfter(/*const*/ TypeOfType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDecltypeBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 832,
   FQN="(anonymous namespace)::TypePrinter::printDecltypeBefore", NM="_ZN12_GLOBAL__N_111TypePrinter19printDecltypeBeforeEPKN5clang12DecltypeTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter19printDecltypeBeforeEPKN5clang12DecltypeTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDecltypeBefore(/*const*/ DecltypeType /*P*/ T, final raw_ostream /*&*/ OS) {
    OS.$out(/*KEEP_STR*/"decltype(");
    if ((T.getUnderlyingExpr() != null)) {
      T.getUnderlyingExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
    }
    OS.$out_char($$RPAREN);
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDecltypeAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 839,
   FQN="(anonymous namespace)::TypePrinter::printDecltypeAfter", NM="_ZN12_GLOBAL__N_111TypePrinter18printDecltypeAfterEPKN5clang12DecltypeTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter18printDecltypeAfterEPKN5clang12DecltypeTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDecltypeAfter(/*const*/ DecltypeType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printUnaryTransformBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 841,
   FQN="(anonymous namespace)::TypePrinter::printUnaryTransformBefore", NM="_ZN12_GLOBAL__N_111TypePrinter25printUnaryTransformBeforeEPKN5clang18UnaryTransformTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter25printUnaryTransformBeforeEPKN5clang18UnaryTransformTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printUnaryTransformBefore(/*const*/ UnaryTransformType /*P*/ T, 
                           final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      switch (T.getUTTKind()) {
       case EnumUnderlyingType:
        OS.$out(/*KEEP_STR*/"__underlying_type(");
        print(T.getBaseType(), OS, new StringRef());
        OS.$out_char($$RPAREN);
        spaceBeforePlaceHolder(OS);
        return;
      }
      
      printBefore(T.getBaseType(), OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printUnaryTransformAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 856,
   FQN="(anonymous namespace)::TypePrinter::printUnaryTransformAfter", NM="_ZN12_GLOBAL__N_111TypePrinter24printUnaryTransformAfterEPKN5clang18UnaryTransformTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printUnaryTransformAfterEPKN5clang18UnaryTransformTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printUnaryTransformAfter(/*const*/ UnaryTransformType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      switch (T.getUTTKind()) {
       case EnumUnderlyingType:
        return;
      }
      
      printAfter(T.getBaseType(), OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printRecordBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1020,
   FQN="(anonymous namespace)::TypePrinter::printRecordBefore", NM="_ZN12_GLOBAL__N_111TypePrinter17printRecordBeforeEPKN5clang10RecordTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printRecordBeforeEPKN5clang10RecordTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printRecordBefore(/*const*/ RecordType /*P*/ T, final raw_ostream /*&*/ OS) {
    printTag(T.getDecl(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printRecordAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1023,
   FQN="(anonymous namespace)::TypePrinter::printRecordAfter", NM="_ZN12_GLOBAL__N_111TypePrinter16printRecordAfterEPKN5clang10RecordTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter16printRecordAfterEPKN5clang10RecordTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printRecordAfter(/*const*/ RecordType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printEnumBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1025,
   FQN="(anonymous namespace)::TypePrinter::printEnumBefore", NM="_ZN12_GLOBAL__N_111TypePrinter15printEnumBeforeEPKN5clang8EnumTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter15printEnumBeforeEPKN5clang8EnumTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printEnumBefore(/*const*/ EnumType /*P*/ T, final raw_ostream /*&*/ OS) {
    printTag(T.getDecl(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printEnumAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1028,
   FQN="(anonymous namespace)::TypePrinter::printEnumAfter", NM="_ZN12_GLOBAL__N_111TypePrinter14printEnumAfterEPKN5clang8EnumTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter14printEnumAfterEPKN5clang8EnumTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printEnumAfter(/*const*/ EnumType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printElaboratedBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1088,
   FQN="(anonymous namespace)::TypePrinter::printElaboratedBefore", NM="_ZN12_GLOBAL__N_111TypePrinter21printElaboratedBeforeEPKN5clang14ElaboratedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter21printElaboratedBeforeEPKN5clang14ElaboratedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printElaboratedBefore(/*const*/ ElaboratedType /*P*/ T, 
                       final raw_ostream /*&*/ OS) {
    ElaboratedTypePolicyRAII PolicyRAII = null;
    try {
      // The tag definition will take care of these.
      if (!Policy.IncludeTagDefinition) {
        OS.$out(TypeWithKeyword.getKeywordName(T.getKeyword()));
        if (T.getKeyword() != ElaboratedTypeKeyword.ETK_None) {
          OS.$out(/*KEEP_STR*/$SPACE);
        }
        NestedNameSpecifier /*P*/ Qualifier = T.getQualifier();
        if ((Qualifier != null)) {
          Qualifier.print(OS, Policy);
        }
      }
      
      PolicyRAII/*J*/= new ElaboratedTypePolicyRAII(Policy);
      printBefore(T.getNamedType(), OS);
    } finally {
      if (PolicyRAII != null) { PolicyRAII.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printElaboratedAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1104,
   FQN="(anonymous namespace)::TypePrinter::printElaboratedAfter", NM="_ZN12_GLOBAL__N_111TypePrinter20printElaboratedAfterEPKN5clang14ElaboratedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter20printElaboratedAfterEPKN5clang14ElaboratedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printElaboratedAfter(/*const*/ ElaboratedType /*P*/ T, 
                      final raw_ostream /*&*/ OS) {
    ElaboratedTypePolicyRAII PolicyRAII = null;
    try {
      PolicyRAII/*J*/= new ElaboratedTypePolicyRAII(Policy);
      printAfter(T.getNamedType(), OS);
    } finally {
      if (PolicyRAII != null) { PolicyRAII.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAttributedBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1168,
   FQN="(anonymous namespace)::TypePrinter::printAttributedBefore", NM="_ZN12_GLOBAL__N_111TypePrinter21printAttributedBeforeEPKN5clang14AttributedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter21printAttributedBeforeEPKN5clang14AttributedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAttributedBefore(/*const*/ AttributedType /*P*/ T, 
                       final raw_ostream /*&*/ OS) {
    // Prefer the macro forms of the GC and ownership qualifiers.
    if (T.getAttrKind() == AttributedType.Kind.attr_objc_gc
       || T.getAttrKind() == AttributedType.Kind.attr_objc_ownership) {
      printBefore(T.getEquivalentType(), OS);
      /*JAVA:return*/return;
    }
    if (T.getAttrKind() == AttributedType.Kind.attr_objc_kindof) {
      OS.$out(/*KEEP_STR*/"__kindof ");
    }
    
    printBefore(T.getModifiedType(), OS);
    if (T.isMSTypeSpec()) {
      switch (T.getAttrKind()) {
       default:
        return;
       case attr_ptr32:
        OS.$out(/*KEEP_STR*/" __ptr32");
        break;
       case attr_ptr64:
        OS.$out(/*KEEP_STR*/" __ptr64");
        break;
       case attr_sptr:
        OS.$out(/*KEEP_STR*/" __sptr");
        break;
       case attr_uptr:
        OS.$out(/*KEEP_STR*/" __uptr");
        break;
      }
      spaceBeforePlaceHolder(OS);
    }
    
    // Print nullability type specifiers.
    if (T.getAttrKind() == AttributedType.Kind.attr_nonnull
       || T.getAttrKind() == AttributedType.Kind.attr_nullable
       || T.getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
      if (T.getAttrKind() == AttributedType.Kind.attr_nonnull) {
        OS.$out(/*KEEP_STR*/" _Nonnull");
      } else if (T.getAttrKind() == AttributedType.Kind.attr_nullable) {
        OS.$out(/*KEEP_STR*/" _Nullable");
      } else if (T.getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
        OS.$out(/*KEEP_STR*/" _Null_unspecified");
      } else {
        throw new llvm_unreachable("unhandled nullability");
      }
      spaceBeforePlaceHolder(OS);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAttributedAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1207,
   FQN="(anonymous namespace)::TypePrinter::printAttributedAfter", NM="_ZN12_GLOBAL__N_111TypePrinter20printAttributedAfterEPKN5clang14AttributedTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter20printAttributedAfterEPKN5clang14AttributedTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAttributedAfter(/*const*/ AttributedType /*P*/ T, 
                      final raw_ostream /*&*/ OS) {
    SaveAndRestoreBool MaybeSuppressCC = null;
    try {
      // Prefer the macro forms of the GC and ownership qualifiers.
      if (T.getAttrKind() == AttributedType.Kind.attr_objc_gc
         || T.getAttrKind() == AttributedType.Kind.attr_objc_ownership) {
        printAfter(T.getEquivalentType(), OS);
        /*JAVA:return*/return;
      }
      if (T.getAttrKind() == AttributedType.Kind.attr_objc_kindof) {
        return;
      }
      
      // TODO: not all attributes are GCC-style attributes.
      if (T.isMSTypeSpec()) {
        return;
      }
      
      // Nothing to print after.
      if (T.getAttrKind() == AttributedType.Kind.attr_nonnull
         || T.getAttrKind() == AttributedType.Kind.attr_nullable
         || T.getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
        printAfter(T.getModifiedType(), OS);
        /*JAVA:return*/return;
      }
      
      // If this is a calling convention attribute, don't print the implicit CC from
      // the modified type.
      MaybeSuppressCC/*J*/= new SaveAndRestoreBool(InsideCCAttribute, T.isCallingConv());
      
      printAfter(T.getModifiedType(), OS);
      
      // Don't print the inert __unsafe_unretained attribute at all.
      if (T.getAttrKind() == AttributedType.Kind.attr_objc_inert_unsafe_unretained) {
        return;
      }
      
      // Print nullability type specifiers that occur after
      if (T.getAttrKind() == AttributedType.Kind.attr_nonnull
         || T.getAttrKind() == AttributedType.Kind.attr_nullable
         || T.getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
        if (T.getAttrKind() == AttributedType.Kind.attr_nonnull) {
          OS.$out(/*KEEP_STR*/" _Nonnull");
        } else if (T.getAttrKind() == AttributedType.Kind.attr_nullable) {
          OS.$out(/*KEEP_STR*/" _Nullable");
        } else if (T.getAttrKind() == AttributedType.Kind.attr_null_unspecified) {
          OS.$out(/*KEEP_STR*/" _Null_unspecified");
        } else {
          throw new llvm_unreachable("unhandled nullability");
        }
        
        return;
      }
      
      OS.$out(/*KEEP_STR*/" __attribute__((");
      switch (T.getAttrKind()) {
       default:
        throw new llvm_unreachable("This attribute should have been handled already");
       case attr_address_space:
        OS.$out(/*KEEP_STR*/"address_space(");
        OS.$out_uint(T.getEquivalentType().getAddressSpace());
        OS.$out_char($$RPAREN);
        break;
       case attr_vector_size:
        {
          OS.$out(/*KEEP_STR*/"__vector_size__(");
          {
            /*const*/ VectorType /*P*/ vector = T.getEquivalentType().$arrow().getAs(VectorType.class);
            if ((vector != null)) {
              OS.$out_uint(vector.getNumElements());
              OS.$out(/*KEEP_STR*/" * sizeof(");
              print(vector.getElementType(), OS, new StringRef());
              OS.$out_char($$RPAREN);
            }
          }
          OS.$out_char($$RPAREN);
          break;
        }
       case attr_neon_vector_type:
       case attr_neon_polyvector_type:
        {
          if (T.getAttrKind() == AttributedType.Kind.attr_neon_vector_type) {
            OS.$out(/*KEEP_STR*/"neon_vector_type(");
          } else {
            OS.$out(/*KEEP_STR*/"neon_polyvector_type(");
          }
          /*const*/ VectorType /*P*/ vector = T.getEquivalentType().$arrow().getAs(VectorType.class);
          OS.$out_uint(vector.getNumElements());
          OS.$out_char($$RPAREN);
          break;
        }
       case attr_regparm:
        {
          // FIXME: When Sema learns to form this AttributedType, avoid printing the
          // attribute again in printFunctionProtoAfter.
          OS.$out(/*KEEP_STR*/"regparm(");
          QualType t = T.getEquivalentType();
          while (!t.$arrow().isFunctionType()) {
            t.$assignMove(t.$arrow().getPointeeType());
          }
          OS.$out_uint(t.$arrow().getAs(FunctionType.class).getRegParmType());
          OS.$out_char($$RPAREN);
          break;
        }
       case attr_objc_gc:
        {
          OS.$out(/*KEEP_STR*/"objc_gc(");
          
          QualType tmp = T.getEquivalentType();
          while (tmp.getObjCGCAttr() == Qualifiers.GC.GCNone) {
            QualType next = tmp.$arrow().getPointeeType();
            if ($eq_QualType$C(next, tmp)) {
              break;
            }
            tmp.$assign(next);
          }
          if (tmp.isObjCGCWeak()) {
            OS.$out(/*KEEP_STR*/"weak");
          } else {
            OS.$out(/*KEEP_STR*/"strong");
          }
          OS.$out_char($$RPAREN);
          break;
        }
       case attr_objc_ownership:
        OS.$out(/*KEEP_STR*/"objc_ownership(");
        switch (T.getEquivalentType().getObjCLifetime()) {
         case OCL_None:
          throw new llvm_unreachable("no ownership!");
         case OCL_ExplicitNone:
          OS.$out(/*KEEP_STR*/"none");
          break;
         case OCL_Strong:
          OS.$out(/*KEEP_STR*/"strong");
          break;
         case OCL_Weak:
          OS.$out(/*KEEP_STR*/"weak");
          break;
         case OCL_Autoreleasing:
          OS.$out(/*KEEP_STR*/"autoreleasing");
          break;
        }
        OS.$out_char($$RPAREN);
        break;
       case attr_noreturn:
        
        // FIXME: When Sema learns to form this AttributedType, avoid printing the
        // attribute again in printFunctionProtoAfter.
        OS.$out(/*KEEP_STR*/"noreturn");
        break;
       case attr_cdecl:
        OS.$out(/*KEEP_STR*/"cdecl");
        break;
       case attr_fastcall:
        OS.$out(/*KEEP_STR*/"fastcall");
        break;
       case attr_stdcall:
        OS.$out(/*KEEP_STR*/"stdcall");
        break;
       case attr_thiscall:
        OS.$out(/*KEEP_STR*/"thiscall");
        break;
       case attr_swiftcall:
        OS.$out(/*KEEP_STR*/"swiftcall");
        break;
       case attr_vectorcall:
        OS.$out(/*KEEP_STR*/"vectorcall");
        break;
       case attr_pascal:
        OS.$out(/*KEEP_STR*/"pascal");
        break;
       case attr_ms_abi:
        OS.$out(/*KEEP_STR*/"ms_abi");
        break;
       case attr_sysv_abi:
        OS.$out(/*KEEP_STR*/"sysv_abi");
        break;
       case attr_pcs:
       case attr_pcs_vfp:
        {
          OS.$out(/*KEEP_STR*/"pcs(");
          QualType t = T.getEquivalentType();
          while (!t.$arrow().isFunctionType()) {
            t.$assignMove(t.$arrow().getPointeeType());
          }
          OS.$out((t.$arrow().getAs(FunctionType.class).getCallConv() == CallingConv.CC_AAPCS ? $("\"aapcs\"") : $("\"aapcs-vfp\"")));
          OS.$out_char($$RPAREN);
          break;
        }
       case attr_inteloclbicc:
        OS.$out(/*KEEP_STR*/"inteloclbicc");
        break;
       case attr_preserve_most:
        OS.$out(/*KEEP_STR*/"preserve_most");
        break;
       case attr_preserve_all:
        OS.$out(/*KEEP_STR*/"preserve_all");
        break;
      }
      OS.$out(/*KEEP_STR*/"))");
    } finally {
      if (MaybeSuppressCC != null) { MaybeSuppressCC.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTemplateTypeParmBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1030,
   FQN="(anonymous namespace)::TypePrinter::printTemplateTypeParmBefore", NM="_ZN12_GLOBAL__N_111TypePrinter27printTemplateTypeParmBeforeEPKN5clang20TemplateTypeParmTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter27printTemplateTypeParmBeforeEPKN5clang20TemplateTypeParmTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTemplateTypeParmBefore(/*const*/ TemplateTypeParmType /*P*/ T, 
                             final raw_ostream /*&*/ OS) {
    {
      IdentifierInfo /*P*/ Id = T.getIdentifier();
      if ((Id != null)) {
        OS.$out(Id.getName());
      } else {
        OS.$out(/*KEEP_STR*/"type-parameter-").$out_uint(T.getDepth()).$out_char($$MINUS).$out_uint(T.getIndex());
      }
    }
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTemplateTypeParmAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1038,
   FQN="(anonymous namespace)::TypePrinter::printTemplateTypeParmAfter", NM="_ZN12_GLOBAL__N_111TypePrinter26printTemplateTypeParmAfterEPKN5clang20TemplateTypeParmTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter26printTemplateTypeParmAfterEPKN5clang20TemplateTypeParmTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTemplateTypeParmAfter(/*const*/ TemplateTypeParmType /*P*/ T, 
                            final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1041,
   FQN="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmBefore", NM="_ZN12_GLOBAL__N_111TypePrinter32printSubstTemplateTypeParmBeforeEPKN5clang25SubstTemplateTypeParmTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter32printSubstTemplateTypeParmBeforeEPKN5clang25SubstTemplateTypeParmTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printSubstTemplateTypeParmBefore(/*const*/ SubstTemplateTypeParmType /*P*/ T, 
                                  final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      printBefore(T.getReplacementType(), OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1047,
   FQN="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmAfter", NM="_ZN12_GLOBAL__N_111TypePrinter31printSubstTemplateTypeParmAfterEPKN5clang25SubstTemplateTypeParmTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter31printSubstTemplateTypeParmAfterEPKN5clang25SubstTemplateTypeParmTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printSubstTemplateTypeParmAfter(/*const*/ SubstTemplateTypeParmType /*P*/ T, 
                                 final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      printAfter(T.getReplacementType(), OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmPackBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1054,
   FQN="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmPackBefore", NM="_ZN12_GLOBAL__N_111TypePrinter36printSubstTemplateTypeParmPackBeforeEPKN5clang29SubstTemplateTypeParmPackTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter36printSubstTemplateTypeParmPackBeforeEPKN5clang29SubstTemplateTypeParmPackTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printSubstTemplateTypeParmPackBefore(/*const*/ SubstTemplateTypeParmPackType /*P*/ T, 
                                      final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      printTemplateTypeParmBefore(T.getReplacedParameter(), OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmPackAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1060,
   FQN="(anonymous namespace)::TypePrinter::printSubstTemplateTypeParmPackAfter", NM="_ZN12_GLOBAL__N_111TypePrinter35printSubstTemplateTypeParmPackAfterEPKN5clang29SubstTemplateTypeParmPackTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter35printSubstTemplateTypeParmPackAfterEPKN5clang29SubstTemplateTypeParmPackTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printSubstTemplateTypeParmPackAfter(/*const*/ SubstTemplateTypeParmPackType /*P*/ T, 
                                     final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      printTemplateTypeParmAfter(T.getReplacedParameter(), OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTemplateSpecializationBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1067,
   FQN="(anonymous namespace)::TypePrinter::printTemplateSpecializationBefore", NM="_ZN12_GLOBAL__N_111TypePrinter33printTemplateSpecializationBeforeEPKN5clang26TemplateSpecializationTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter33printTemplateSpecializationBeforeEPKN5clang26TemplateSpecializationTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTemplateSpecializationBefore(/*const*/ TemplateSpecializationType /*P*/ T, 
                                   final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      T.getTemplateName().print(OS, Policy);
      
      TemplateSpecializationType.PrintTemplateArgumentList1(OS, T.template_arguments(), Policy);
      spaceBeforePlaceHolder(OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printTemplateSpecializationAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1077,
   FQN="(anonymous namespace)::TypePrinter::printTemplateSpecializationAfter", NM="_ZN12_GLOBAL__N_111TypePrinter32printTemplateSpecializationAfterEPKN5clang26TemplateSpecializationTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter32printTemplateSpecializationAfterEPKN5clang26TemplateSpecializationTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printTemplateSpecializationAfter(/*const*/ TemplateSpecializationType /*P*/ T, 
                                  final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAutoBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 868,
   FQN="(anonymous namespace)::TypePrinter::printAutoBefore", NM="_ZN12_GLOBAL__N_111TypePrinter15printAutoBeforeEPKN5clang8AutoTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter15printAutoBeforeEPKN5clang8AutoTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAutoBefore(/*const*/ AutoType /*P*/ T, final raw_ostream /*&*/ OS) {
    // If the type has been deduced, do not print 'auto'.
    if (!T.getDeducedType().isNull()) {
      printBefore(T.getDeducedType(), OS);
    } else {
      switch (AutoTypeKeyword.valueOf(T.getKeyword().getValue())) {
       case Auto:
        OS.$out(/*KEEP_STR*/$auto);
        break;
       case DecltypeAuto:
        OS.$out(/*KEEP_STR*/"decltype(auto)");
        break;
       case GNUAutoType:
        OS.$out(/*KEEP_STR*/$__auto_type);
        break;
      }
      spaceBeforePlaceHolder(OS);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAutoAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 881,
   FQN="(anonymous namespace)::TypePrinter::printAutoAfter", NM="_ZN12_GLOBAL__N_111TypePrinter14printAutoAfterEPKN5clang8AutoTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter14printAutoAfterEPKN5clang8AutoTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAutoAfter(/*const*/ AutoType /*P*/ T, final raw_ostream /*&*/ OS) {
    // If the type has been deduced, do not print 'auto'.
    if (!T.getDeducedType().isNull()) {
      printAfter(T.getDeducedType(), OS);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printInjectedClassNameBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1081,
   FQN="(anonymous namespace)::TypePrinter::printInjectedClassNameBefore", NM="_ZN12_GLOBAL__N_111TypePrinter28printInjectedClassNameBeforeEPKN5clang21InjectedClassNameTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter28printInjectedClassNameBeforeEPKN5clang21InjectedClassNameTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printInjectedClassNameBefore(/*const*/ InjectedClassNameType /*P*/ T, 
                              final raw_ostream /*&*/ OS) {
    printTemplateSpecializationBefore(T.getInjectedTST(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printInjectedClassNameAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1085,
   FQN="(anonymous namespace)::TypePrinter::printInjectedClassNameAfter", NM="_ZN12_GLOBAL__N_111TypePrinter27printInjectedClassNameAfterEPKN5clang21InjectedClassNameTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter27printInjectedClassNameAfterEPKN5clang21InjectedClassNameTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printInjectedClassNameAfter(/*const*/ InjectedClassNameType /*P*/ T, 
                             final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentNameBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1125,
   FQN="(anonymous namespace)::TypePrinter::printDependentNameBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printDependentNameBeforeEPKN5clang17DependentNameTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printDependentNameBeforeEPKN5clang17DependentNameTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentNameBefore(/*const*/ DependentNameType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    OS.$out(TypeWithKeyword.getKeywordName(T.getKeyword()));
    if (T.getKeyword() != ElaboratedTypeKeyword.ETK_None) {
      OS.$out(/*KEEP_STR*/$SPACE);
    }
    
    T.getQualifier().print(OS, Policy);
    
    OS.$out(T.getIdentifier().getName());
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentNameAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1136,
   FQN="(anonymous namespace)::TypePrinter::printDependentNameAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printDependentNameAfterEPKN5clang17DependentNameTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printDependentNameAfterEPKN5clang17DependentNameTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentNameAfter(/*const*/ DependentNameType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentTemplateSpecializationBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1139,
   FQN="(anonymous namespace)::TypePrinter::printDependentTemplateSpecializationBefore", NM="_ZN12_GLOBAL__N_111TypePrinter42printDependentTemplateSpecializationBeforeEPKN5clang35DependentTemplateSpecializationTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter42printDependentTemplateSpecializationBeforeEPKN5clang35DependentTemplateSpecializationTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentTemplateSpecializationBefore(/*const*/ DependentTemplateSpecializationType /*P*/ T, final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      
      OS.$out(TypeWithKeyword.getKeywordName(T.getKeyword()));
      if (T.getKeyword() != ElaboratedTypeKeyword.ETK_None) {
        OS.$out(/*KEEP_STR*/$SPACE);
      }
      if ((T.getQualifier() != null)) {
        T.getQualifier().print(OS, Policy);
      }
      OS.$out(T.getIdentifier().getName());
      TemplateSpecializationType.PrintTemplateArgumentList1(OS, 
          T.template_arguments(), 
          Policy);
      spaceBeforePlaceHolder(OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printDependentTemplateSpecializationAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1155,
   FQN="(anonymous namespace)::TypePrinter::printDependentTemplateSpecializationAfter", NM="_ZN12_GLOBAL__N_111TypePrinter41printDependentTemplateSpecializationAfterEPKN5clang35DependentTemplateSpecializationTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter41printDependentTemplateSpecializationAfterEPKN5clang35DependentTemplateSpecializationTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDependentTemplateSpecializationAfter(/*const*/ DependentTemplateSpecializationType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printPackExpansionBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1158,
   FQN="(anonymous namespace)::TypePrinter::printPackExpansionBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printPackExpansionBeforeEPKN5clang17PackExpansionTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printPackExpansionBeforeEPKN5clang17PackExpansionTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPackExpansionBefore(/*const*/ PackExpansionType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    printBefore(T.getPattern(), OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printPackExpansionAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1162,
   FQN="(anonymous namespace)::TypePrinter::printPackExpansionAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printPackExpansionAfterEPKN5clang17PackExpansionTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printPackExpansionAfterEPKN5clang17PackExpansionTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPackExpansionAfter(/*const*/ PackExpansionType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
    printAfter(T.getPattern(), OS);
    OS.$out(/*KEEP_STR*/$ELLIPSIS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printObjCObjectBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1371,
   FQN="(anonymous namespace)::TypePrinter::printObjCObjectBefore", NM="_ZN12_GLOBAL__N_111TypePrinter21printObjCObjectBeforeEPKN5clang14ObjCObjectTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter21printObjCObjectBeforeEPKN5clang14ObjCObjectTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printObjCObjectBefore(/*const*/ ObjCObjectType /*P*/ T, 
                       final raw_ostream /*&*/ OS) {
    if (T.qual_empty() && T.isUnspecializedAsWritten()
       && !T.isKindOfTypeAsWritten()) {
      printBefore(T.getBaseType(), OS);
      /*JAVA:return*/return;
    }
    if (T.isKindOfTypeAsWritten()) {
      OS.$out(/*KEEP_STR*/"__kindof ");
    }
    
    print(T.getBaseType(), OS, new StringRef());
    if (T.isSpecializedAsWritten()) {
      boolean isFirst = true;
      OS.$out_char($$LT);
      for (QualType typeArg : T.getTypeArgsAsWritten()) {
        if (isFirst) {
          isFirst = false;
        } else {
          OS.$out(/*KEEP_STR*/$COMMA);
        }
        
        print(new QualType(typeArg), OS, new StringRef());
      }
      OS.$out_char($$GT);
    }
    if (!T.qual_empty()) {
      boolean isFirst = true;
      OS.$out_char($$LT);
      for (/*const*/ ObjCProtocolDecl /*P*/ I : T.quals()) {
        if (isFirst) {
          isFirst = false;
        } else {
          OS.$out_char($$COMMA);
        }
        OS.$out(I.getName());
      }
      OS.$out_char($$GT);
    }
    
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printObjCObjectAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1411,
   FQN="(anonymous namespace)::TypePrinter::printObjCObjectAfter", NM="_ZN12_GLOBAL__N_111TypePrinter20printObjCObjectAfterEPKN5clang14ObjCObjectTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter20printObjCObjectAfterEPKN5clang14ObjCObjectTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printObjCObjectAfter(/*const*/ ObjCObjectType /*P*/ T, 
                      final raw_ostream /*&*/ OS) {
    if (T.qual_empty() && T.isUnspecializedAsWritten()
       && !T.isKindOfTypeAsWritten()) {
      printAfter(T.getBaseType(), OS);
      /*JAVA:return*/return;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printObjCInterfaceBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1363,
   FQN="(anonymous namespace)::TypePrinter::printObjCInterfaceBefore", NM="_ZN12_GLOBAL__N_111TypePrinter24printObjCInterfaceBeforeEPKN5clang17ObjCInterfaceTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter24printObjCInterfaceBeforeEPKN5clang17ObjCInterfaceTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printObjCInterfaceBefore(/*const*/ ObjCInterfaceType /*P*/ T, 
                          final raw_ostream /*&*/ OS) {
    OS.$out(T.getDecl().getName());
    spaceBeforePlaceHolder(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printObjCInterfaceAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1368,
   FQN="(anonymous namespace)::TypePrinter::printObjCInterfaceAfter", NM="_ZN12_GLOBAL__N_111TypePrinter23printObjCInterfaceAfterEPKN5clang17ObjCInterfaceTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter23printObjCInterfaceAfterEPKN5clang17ObjCInterfaceTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printObjCInterfaceAfter(/*const*/ ObjCInterfaceType /*P*/ T, 
                         final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printObjCObjectPointerBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1418,
   FQN="(anonymous namespace)::TypePrinter::printObjCObjectPointerBefore", NM="_ZN12_GLOBAL__N_111TypePrinter28printObjCObjectPointerBeforeEPKN5clang21ObjCObjectPointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter28printObjCObjectPointerBeforeEPKN5clang21ObjCObjectPointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printObjCObjectPointerBefore(/*const*/ ObjCObjectPointerType /*P*/ T, 
                              final raw_ostream /*&*/ OS) {
    printBefore(T.getPointeeType(), OS);
    
    // If we need to print the pointer, print it now.
    if (!T.isObjCIdType() && !T.isObjCQualifiedIdType()
       && !T.isObjCClassType() && !T.isObjCQualifiedClassType()) {
      if (HasEmptyPlaceHolder.$deref()) {
        OS.$out_char($$SPACE);
      }
      OS.$out_char($$STAR);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printObjCObjectPointerAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 1430,
   FQN="(anonymous namespace)::TypePrinter::printObjCObjectPointerAfter", NM="_ZN12_GLOBAL__N_111TypePrinter27printObjCObjectPointerAfterEPKN5clang21ObjCObjectPointerTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter27printObjCObjectPointerAfterEPKN5clang21ObjCObjectPointerTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printObjCObjectPointerAfter(/*const*/ ObjCObjectPointerType /*P*/ T, 
                             final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printPipeBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 897,
   FQN="(anonymous namespace)::TypePrinter::printPipeBefore", NM="_ZN12_GLOBAL__N_111TypePrinter15printPipeBeforeEPKN5clang8PipeTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter15printPipeBeforeEPKN5clang8PipeTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPipeBefore(/*const*/ PipeType /*P*/ T, final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      
      OS.$out(/*KEEP_STR*/"pipe ");
      print(T.getElementType(), OS, new StringRef());
      spaceBeforePlaceHolder(OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printPipeAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 905,
   FQN="(anonymous namespace)::TypePrinter::printPipeAfter", NM="_ZN12_GLOBAL__N_111TypePrinter14printPipeAfterEPKN5clang8PipeTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter14printPipeAfterEPKN5clang8PipeTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printPipeAfter(/*const*/ PipeType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAtomicBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 887,
   FQN="(anonymous namespace)::TypePrinter::printAtomicBefore", NM="_ZN12_GLOBAL__N_111TypePrinter17printAtomicBeforeEPKN5clang10AtomicTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter17printAtomicBeforeEPKN5clang10AtomicTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAtomicBefore(/*const*/ AtomicType /*P*/ T, final raw_ostream /*&*/ OS) {
    IncludeStrongLifetimeRAII Strong = null;
    try {
      Strong/*J*/= new IncludeStrongLifetimeRAII(Policy);
      
      OS.$out(/*KEEP_STR*/"_Atomic(");
      print(T.getValueType(), OS, new StringRef());
      OS.$out_char($$RPAREN);
      spaceBeforePlaceHolder(OS);
    } finally {
      if (Strong != null) { Strong.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinter::printAtomicAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 895,
   FQN="(anonymous namespace)::TypePrinter::printAtomicAfter", NM="_ZN12_GLOBAL__N_111TypePrinter16printAtomicAfterEPKN5clang10AtomicTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN12_GLOBAL__N_111TypePrinter16printAtomicAfterEPKN5clang10AtomicTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printAtomicAfter(/*const*/ AtomicType /*P*/ T, final raw_ostream /*&*/ OS) {
  }

  
  @Override public String toString() {
    return "" + "Policy=" + Policy // NOI18N
              + ", Indentation=" + Indentation // NOI18N
              + ", HasEmptyPlaceHolder=" + HasEmptyPlaceHolder // NOI18N
              + ", InsideCCAttribute=" + InsideCCAttribute; // NOI18N
  }
}
