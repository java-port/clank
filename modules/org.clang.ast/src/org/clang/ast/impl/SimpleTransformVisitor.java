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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.impl.TypeStatics.*;


/// Visitor used by simpleTransform() to perform the transformation.
/*template <typename F> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 659,
 FQN="(anonymous namespace)::SimpleTransformVisitor", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitorE")
//</editor-fold>
public class/*struct*/ SimpleTransformVisitor/*<typename F extends QualType2QualType>*/  implements /*public*/ TypeVisitor<SimpleTransformVisitor, QualType> {
  public final ASTContext /*&*/ Ctx;
  public final QualType2QualType /*&&*/TheFunc;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::recurse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 665,
   FQN="(anonymous namespace)::SimpleTransformVisitor::recurse", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor7recurseEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor7recurseEN5clang8QualTypeE")
  //</editor-fold>
  public QualType recurse(QualType type) {
    return simpleTransform(Ctx, type, std.move(TheFunc));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::SimpleTransformVisitor<F>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 670,
   FQN="(anonymous namespace)::SimpleTransformVisitor::SimpleTransformVisitor<F>", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitorC1ERN5clang10ASTContextEOT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitorC1ERN5clang10ASTContextEOT_")
  //</editor-fold>
  public SimpleTransformVisitor(final ASTContext /*&*/ ctx, final QualType2QualType /*&&*/f) {
    // : Ctx(ctx), TheFunc(std::move(f)) 
    //START JInit
    this./*&*/Ctx=/*&*/ctx;
    this./*&*/TheFunc=/*&*//*ParenListExpr*/std.move(f);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 74,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitDependentSizedArrayType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor28VisitDependentSizedArrayTypeEPKN5clang23DependentSizedArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor28VisitDependentSizedArrayTypeEPKN5clang23DependentSizedArrayTypeE")
  //</editor-fold>
  public QualType VisitDependentSizedArrayType(/*const*/ DependentSizedArrayType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 75,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitDependentSizedExtVectorType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE")
  //</editor-fold>
  public QualType VisitDependentSizedExtVectorType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitUnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 81,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitUnresolvedUsingType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitUnresolvedUsingTypeEPKN5clang19UnresolvedUsingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitUnresolvedUsingTypeEPKN5clang19UnresolvedUsingTypeE")
  //</editor-fold>
  public QualType VisitUnresolvedUsingType(/*const*/ UnresolvedUsingType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 95,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitTemplateTypeParmType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE")
  //</editor-fold>
  public QualType VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 97,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitSubstTemplateTypeParmPackType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  public QualType VisitSubstTemplateTypeParmPackType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 100,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitInjectedClassNameType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor26VisitInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor26VisitInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE")
  //</editor-fold>
  public QualType VisitInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitDependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 101,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitDependentNameType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitDependentNameTypeEPKN5clang17DependentNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitDependentNameTypeEPKN5clang17DependentNameTypeE")
  //</editor-fold>
  public QualType VisitDependentNameType(/*const*/ DependentNameType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeNodes.def", line = 102,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitDependentTemplateSpecializationType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor40VisitDependentTemplateSpecializationTypeEPKN5clang35DependentTemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor40VisitDependentTemplateSpecializationTypeEPKN5clang35DependentTemplateSpecializationTypeE")
  //</editor-fold>
  public QualType VisitDependentTemplateSpecializationType(/*const*/ DependentTemplateSpecializationType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 682,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitBuiltinType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitBuiltinTypeEPKN5clang11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitBuiltinTypeEPKN5clang11BuiltinTypeE")
  //</editor-fold>
  public QualType VisitBuiltinType(/*const*/ BuiltinType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 684,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitComplexType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitComplexTypeEPKN5clang11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitComplexTypeEPKN5clang11ComplexTypeE")
  //</editor-fold>
  public QualType VisitComplexType(/*const*/ ComplexType /*P*/ T) {
    QualType elementType = recurse(T.getElementType());
    if (elementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(elementType.getAsOpaquePtr(), T.getElementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getComplexType(elementType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 695,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitPointerType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitPointerTypeEPKN5clang11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitPointerTypeEPKN5clang11PointerTypeE")
  //</editor-fold>
  public QualType VisitPointerType(/*const*/ PointerType /*P*/ T) {
    QualType pointeeType = recurse(T.getPointeeType());
    if (pointeeType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(pointeeType.getAsOpaquePtr(), T.getPointeeType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getPointerType(pointeeType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 706,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitBlockPointerType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE")
  //</editor-fold>
  public QualType VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    QualType pointeeType = recurse(T.getPointeeType());
    if (pointeeType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(pointeeType.getAsOpaquePtr(), T.getPointeeType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getBlockPointerType(pointeeType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 717,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitLValueReferenceType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitLValueReferenceTypeEPKN5clang19LValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitLValueReferenceTypeEPKN5clang19LValueReferenceTypeE")
  //</editor-fold>
  public QualType VisitLValueReferenceType(/*const*/ LValueReferenceType /*P*/ T) {
    QualType pointeeType = recurse(T.getPointeeTypeAsWritten());
    if (pointeeType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(pointeeType.getAsOpaquePtr(), T.getPointeeTypeAsWritten().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getLValueReferenceType(pointeeType, T.isSpelledAsLValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 729,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitRValueReferenceType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitRValueReferenceTypeEPKN5clang19RValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitRValueReferenceTypeEPKN5clang19RValueReferenceTypeE")
  //</editor-fold>
  public QualType VisitRValueReferenceType(/*const*/ RValueReferenceType /*P*/ T) {
    QualType pointeeType = recurse(T.getPointeeTypeAsWritten());
    if (pointeeType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(pointeeType.getAsOpaquePtr(), T.getPointeeTypeAsWritten().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getRValueReferenceType(pointeeType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 741,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitMemberPointerType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  public QualType VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    QualType pointeeType = recurse(T.getPointeeType());
    if (pointeeType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(pointeeType.getAsOpaquePtr(), T.getPointeeType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getMemberPointerType(pointeeType, T.__getClass());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 752,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitConstantArrayType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitConstantArrayTypeEPKN5clang17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitConstantArrayTypeEPKN5clang17ConstantArrayTypeE")
  //</editor-fold>
  public QualType VisitConstantArrayType(/*const*/ ConstantArrayType /*P*/ T) {
    QualType elementType = recurse(T.getElementType());
    if (elementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(elementType.getAsOpaquePtr(), T.getElementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getConstantArrayType(elementType, T.getSize(), 
        T.getSizeModifier(), 
        T.getIndexTypeCVRQualifiers());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 765,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitVariableArrayType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitVariableArrayTypeEPKN5clang17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitVariableArrayTypeEPKN5clang17VariableArrayTypeE")
  //</editor-fold>
  public QualType VisitVariableArrayType(/*const*/ VariableArrayType /*P*/ T) {
    QualType elementType = recurse(T.getElementType());
    if (elementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(elementType.getAsOpaquePtr(), T.getElementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getVariableArrayType(elementType, T.getSizeExpr(), 
        T.getSizeModifier(), 
        T.getIndexTypeCVRQualifiers(), 
        T.getBracketsRange());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 779,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitIncompleteArrayType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitIncompleteArrayTypeEPKN5clang19IncompleteArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitIncompleteArrayTypeEPKN5clang19IncompleteArrayTypeE")
  //</editor-fold>
  public QualType VisitIncompleteArrayType(/*const*/ IncompleteArrayType /*P*/ T) {
    QualType elementType = recurse(T.getElementType());
    if (elementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(elementType.getAsOpaquePtr(), T.getElementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getIncompleteArrayType(elementType, T.getSizeModifier(), 
        T.getIndexTypeCVRQualifiers());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 791,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitVectorType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitVectorTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitVectorTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  public QualType VisitVectorType(/*const*/ VectorType /*P*/ T) {
    QualType elementType = recurse(T.getElementType());
    if (elementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(elementType.getAsOpaquePtr(), T.getElementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getVectorType(elementType, T.getNumElements(), 
        T.getVectorKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 803,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitExtVectorType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor18VisitExtVectorTypeEPKN5clang13ExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor18VisitExtVectorTypeEPKN5clang13ExtVectorTypeE")
  //</editor-fold>
  public QualType VisitExtVectorType(/*const*/ ExtVectorType /*P*/ T) {
    QualType elementType = recurse(T.getElementType());
    if (elementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(elementType.getAsOpaquePtr(), T.getElementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getExtVectorType(elementType, T.getNumElements());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 814,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitFunctionNoProtoType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitFunctionNoProtoTypeEPKN5clang19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor24VisitFunctionNoProtoTypeEPKN5clang19FunctionNoProtoTypeE")
  //</editor-fold>
  public QualType VisitFunctionNoProtoType(/*const*/ FunctionNoProtoType /*P*/ T) {
    QualType returnType = recurse(T.getReturnType());
    if (returnType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(returnType.getAsOpaquePtr(), T.getReturnType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getFunctionNoProtoType(returnType, T.getExtInfo());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitFunctionProtoType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*check use of copy*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 825,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitFunctionProtoType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitFunctionProtoTypeEPKN5clang17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitFunctionProtoTypeEPKN5clang17FunctionProtoTypeE")
  //</editor-fold>
  public QualType VisitFunctionProtoType(/*const*/ FunctionProtoType /*P*/ T) {
    QualType returnType = recurse(T.getReturnType());
    if (returnType.isNull()) {
      return new QualType();
    }
    
    // Transform parameter types.
    SmallVector<QualType> paramTypes/*J*/= new SmallVector<QualType>(4, new QualType());
    boolean paramChanged = false;
    for (QualType paramType : T.getParamTypes()) {
      QualType newParamType = recurse(paramType);
      if (newParamType.isNull()) {
        return new QualType();
      }
      if ($noteq_ptr(newParamType.getAsOpaquePtr(), paramType.getAsOpaquePtr())) {
        paramChanged = true;
      }
      
      paramTypes.push_back(newParamType);
    }
    
    // Transform extended info.
    FunctionProtoType.ExtProtoInfo info = T.getExtProtoInfo();
    boolean exceptionChanged = false;
    if (info.ExceptionSpec.Type == ExceptionSpecificationType.EST_Dynamic) {
      SmallVector<QualType> exceptionTypes/*J*/= new SmallVector<QualType>(4, new QualType());
      for (QualType exceptionType : info.ExceptionSpec.Exceptions) {
        QualType newExceptionType = recurse(exceptionType);
        if (newExceptionType.isNull()) {
          return new QualType();
        }
        if ($noteq_ptr(newExceptionType.getAsOpaquePtr(), exceptionType.getAsOpaquePtr())) {
          exceptionChanged = true;
        }
        
        exceptionTypes.push_back(newExceptionType);
      }
      if (exceptionChanged) {
        info.ExceptionSpec.Exceptions
           = llvm.makeArrayRef(exceptionTypes).copy(QualType.class, Ctx);
      }
    }
    if ($eq_ptr(returnType.getAsOpaquePtr(), T.getReturnType().getAsOpaquePtr())
       && !paramChanged && !exceptionChanged) {
      return new QualType(T, 0);
    }
    
    return Ctx.getFunctionType(returnType, new ArrayRef(paramTypes), info);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 874,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitParenType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor14VisitParenTypeEPKN5clang9ParenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor14VisitParenTypeEPKN5clang9ParenTypeE")
  //</editor-fold>
  public QualType VisitParenType(/*const*/ ParenType /*P*/ T) {
    QualType innerType = recurse(T.getInnerType());
    if (innerType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(innerType.getAsOpaquePtr(), T.getInnerType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getParenType(innerType);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 885,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitTypedefType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitTypedefTypeEPKN5clang11TypedefTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitTypedefTypeEPKN5clang11TypedefTypeE")
  //</editor-fold>
  public QualType VisitTypedefType(/*const*/ TypedefType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 887,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitAdjustedType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor17VisitAdjustedTypeEPKN5clang12AdjustedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor17VisitAdjustedTypeEPKN5clang12AdjustedTypeE")
  //</editor-fold>
  public QualType VisitAdjustedType(/*const*/ AdjustedType /*P*/ T) {
    QualType originalType = recurse(T.getOriginalType());
    if (originalType.isNull()) {
      return new QualType();
    }
    
    QualType adjustedType = recurse(T.getAdjustedType());
    if (adjustedType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(originalType.getAsOpaquePtr(), T.getOriginalType().getAsOpaquePtr())
       && $eq_ptr(adjustedType.getAsOpaquePtr(), T.getAdjustedType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getAdjustedType(originalType, adjustedType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 904,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitDecayedType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitDecayedTypeEPKN5clang11DecayedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor16VisitDecayedTypeEPKN5clang11DecayedTypeE")
  //</editor-fold>
  public QualType VisitDecayedType(/*const*/ DecayedType /*P*/ T) {
    QualType originalType = recurse(T.getOriginalType());
    if (originalType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(originalType.getAsOpaquePtr(), T.getOriginalType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getDecayedType(originalType);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 916,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitTypeOfExprType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitTypeOfExprTypeEPKN5clang14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitTypeOfExprTypeEPKN5clang14TypeOfExprTypeE")
  //</editor-fold>
  public QualType VisitTypeOfExprType(/*const*/ TypeOfExprType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 917,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitTypeOfType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitTypeOfTypeEPKN5clang10TypeOfTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitTypeOfTypeEPKN5clang10TypeOfTypeE")
  //</editor-fold>
  public QualType VisitTypeOfType(/*const*/ TypeOfType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 918,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitDecltypeType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor17VisitDecltypeTypeEPKN5clang12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor17VisitDecltypeTypeEPKN5clang12DecltypeTypeE")
  //</editor-fold>
  public QualType VisitDecltypeType(/*const*/ DecltypeType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 919,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitUnaryTransformType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor23VisitUnaryTransformTypeEPKN5clang18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor23VisitUnaryTransformTypeEPKN5clang18UnaryTransformTypeE")
  //</editor-fold>
  public QualType VisitUnaryTransformType(/*const*/ UnaryTransformType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 920,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitRecordType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitRecordTypeEPKN5clang10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitRecordTypeEPKN5clang10RecordTypeE")
  //</editor-fold>
  public QualType VisitRecordType(/*const*/ RecordType /*P*/ T) {
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 921,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitEnumType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor13VisitEnumTypeEPKN5clang8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor13VisitEnumTypeEPKN5clang8EnumTypeE")
  //</editor-fold>
  public QualType VisitEnumType(/*const*/ EnumType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  // FIXME: Non-trivial to implement, but important for C++
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 924,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitElaboratedType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitElaboratedTypeEPKN5clang14ElaboratedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitElaboratedTypeEPKN5clang14ElaboratedTypeE")
  //</editor-fold>
  public QualType VisitElaboratedType(/*const*/ ElaboratedType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 926,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitAttributedType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitAttributedTypeEPKN5clang14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitAttributedTypeEPKN5clang14AttributedTypeE")
  //</editor-fold>
  public QualType VisitAttributedType(/*const*/ AttributedType /*P*/ T) {
    QualType modifiedType = recurse(T.getModifiedType());
    if (modifiedType.isNull()) {
      return new QualType();
    }
    
    QualType equivalentType = recurse(T.getEquivalentType());
    if (equivalentType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(modifiedType.getAsOpaquePtr(), T.getModifiedType().getAsOpaquePtr())
       && $eq_ptr(equivalentType.getAsOpaquePtr(), T.getEquivalentType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getAttributedType(T.getAttrKind(), modifiedType, 
        equivalentType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 945,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitSubstTemplateTypeParmType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE")
  //</editor-fold>
  public QualType VisitSubstTemplateTypeParmType(/*const*/ SubstTemplateTypeParmType /*P*/ T) {
    QualType replacementType = recurse(T.getReplacementType());
    if (replacementType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(replacementType.getAsOpaquePtr(), T.getReplacementType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getSubstTemplateTypeParmType(T.getReplacedParameter(), 
        replacementType);
  }

  
  // FIXME: Non-trivial to implement, but important for C++
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 959,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitTemplateSpecializationType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor31VisitTemplateSpecializationTypeEPKN5clang26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor31VisitTemplateSpecializationTypeEPKN5clang26TemplateSpecializationTypeE")
  //</editor-fold>
  public QualType VisitTemplateSpecializationType(/*const*/ TemplateSpecializationType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 961,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitAutoType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor13VisitAutoTypeEPKN5clang8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor13VisitAutoTypeEPKN5clang8AutoTypeE")
  //</editor-fold>
  public QualType VisitAutoType(/*const*/ AutoType /*P*/ T) {
    if (!T.isDeduced()) {
      return new QualType(T, 0);
    }
    
    QualType deducedType = recurse(T.getDeducedType());
    if (deducedType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(deducedType.getAsOpaquePtr(), T.getDeducedType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getAutoType(deducedType, T.getKeyword(), 
        T.isDependentType());
  }

  
  // FIXME: Non-trivial to implement, but important for C++
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 978,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitPackExpansionType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitPackExpansionTypeEPKN5clang17PackExpansionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitPackExpansionTypeEPKN5clang17PackExpansionTypeE")
  //</editor-fold>
  public QualType VisitPackExpansionType(/*const*/ PackExpansionType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitObjCObjectType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 980,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitObjCObjectType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitObjCObjectTypeEPKN5clang14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor19VisitObjCObjectTypeEPKN5clang14ObjCObjectTypeE")
  //</editor-fold>
  public QualType VisitObjCObjectType(/*const*/ ObjCObjectType /*P*/ T) {
    QualType baseType = recurse(T.getBaseType());
    if (baseType.isNull()) {
      return new QualType();
    }
    
    // Transform type arguments.
    boolean typeArgChanged = false;
    SmallVector<QualType> typeArgs/*J*/= new SmallVector<QualType>(4, new QualType());
    for (QualType typeArg : T.getTypeArgsAsWritten()) {
      QualType newTypeArg = recurse(typeArg);
      if (newTypeArg.isNull()) {
        return new QualType();
      }
      if ($noteq_ptr(newTypeArg.getAsOpaquePtr(), typeArg.getAsOpaquePtr())) {
        typeArgChanged = true;
      }
      
      typeArgs.push_back(newTypeArg);
    }
    if ($eq_ptr(baseType.getAsOpaquePtr(), T.getBaseType().getAsOpaquePtr())
       && !typeArgChanged) {
      return new QualType(T, 0);
    }
    
    return Ctx.getObjCObjectType(baseType, new ArrayRef(typeArgs), 
        llvm.makeArrayRef(T.qual_begin(), 
            T.getNumProtocols()), 
        T.isKindOfTypeAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1009,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitObjCInterfaceType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitObjCInterfaceTypeEPKN5clang17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor22VisitObjCInterfaceTypeEPKN5clang17ObjCInterfaceTypeE")
  //</editor-fold>
  public QualType VisitObjCInterfaceType(/*const*/ ObjCInterfaceType /*P*/ T) {
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1011,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitObjCObjectPointerType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor26VisitObjCObjectPointerTypeEPKN5clang21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor26VisitObjCObjectPointerTypeEPKN5clang21ObjCObjectPointerTypeE")
  //</editor-fold>
  public QualType VisitObjCObjectPointerType(/*const*/ ObjCObjectPointerType /*P*/ T) {
    QualType pointeeType = recurse(T.getPointeeType());
    if (pointeeType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(pointeeType.getAsOpaquePtr(), T.getPointeeType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getObjCObjectPointerType(pointeeType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleTransformVisitor::VisitAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1023,
   FQN="(anonymous namespace)::SimpleTransformVisitor::VisitAtomicType", NM="_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitAtomicTypeEPKN5clang10AtomicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_122SimpleTransformVisitor15VisitAtomicTypeEPKN5clang10AtomicTypeE")
  //</editor-fold>
  public QualType VisitAtomicType(/*const*/ AtomicType /*P*/ T) {
    QualType valueType = recurse(T.getValueType());
    if (valueType.isNull()) {
      return new QualType();
    }
    if ($eq_ptr(valueType.getAsOpaquePtr(), T.getValueType().getAsOpaquePtr())) {
      return new QualType(T, 0);
    }
    
    return Ctx.getAtomicType(valueType);
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", TheFunc=" + TheFunc // NOI18N
              + super.toString(); // NOI18N
  }
}
