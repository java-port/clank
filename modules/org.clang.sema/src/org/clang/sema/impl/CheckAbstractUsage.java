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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.AstClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4505,
 FQN="(anonymous namespace)::CheckAbstractUsage", NM="_ZN12_GLOBAL__N_118CheckAbstractUsageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsageE")
//</editor-fold>
public class/*struct*/ CheckAbstractUsage {
  public final AbstractUsageInfo /*&*/ Info;
  public /*const*/NamedDecl/*P*/ Ctx;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::CheckAbstractUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4509,
   FQN="(anonymous namespace)::CheckAbstractUsage::CheckAbstractUsage", NM="_ZN12_GLOBAL__N_118CheckAbstractUsageC1ERNS_17AbstractUsageInfoEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsageC1ERNS_17AbstractUsageInfoEPKN5clang9NamedDeclE")
  //</editor-fold>
  public CheckAbstractUsage(final AbstractUsageInfo /*&*/ Info, /*const*/NamedDecl/*P*/ Ctx) {
    // : Info(Info), Ctx(Ctx) 
    //START JInit
    this./*&*/Info=/*&*/Info;
    this.Ctx = Ctx;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4512,
   FQN="(anonymous namespace)::CheckAbstractUsage::Visit", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5VisitEN5clang7TypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5VisitEN5clang7TypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Visit(TypeLoc TL, Sema.AbstractDiagSelID Sel) {
    switch (TL.getTypeLocClass()) {
     case Qualified:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(QualifiedTypeLoc.class)), Sel);
      break;
     case Builtin:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(BuiltinTypeLoc.class)), Sel);
      break;
     case Complex:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ComplexTypeLoc.class)), Sel);
      break;
     case Pointer:
      Check(TL.castAs(PointerTypeLoc.class), Sel);
      break;
     case BlockPointer:
      Check(TL.castAs(BlockPointerTypeLoc.class), Sel);
      break;
     case LValueReference:
      Check(new ReferenceTypeLoc(JD$Move.INSTANCE, TL.castAs(LValueReferenceTypeLoc.class)), Sel);
      break;
     case RValueReference:
      Check(new ReferenceTypeLoc(JD$Move.INSTANCE, TL.castAs(RValueReferenceTypeLoc.class)), Sel);
      break;
     case MemberPointer:
      Check(TL.castAs(MemberPointerTypeLoc.class), Sel);
      break;
     case ConstantArray:
      Check(new ArrayTypeLoc(JD$Move.INSTANCE, TL.castAs(ConstantArrayTypeLoc.class)), Sel);
      break;
     case IncompleteArray:
      Check(new ArrayTypeLoc(JD$Move.INSTANCE, TL.castAs(IncompleteArrayTypeLoc.class)), Sel);
      break;
     case VariableArray:
      Check(new ArrayTypeLoc(JD$Move.INSTANCE, TL.castAs(VariableArrayTypeLoc.class)), Sel);
      break;
     case DependentSizedArray:
      Check(new ArrayTypeLoc(JD$Move.INSTANCE, TL.castAs(DependentSizedArrayTypeLoc.class)), Sel);
      break;
     case DependentSizedExtVector:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(DependentSizedExtVectorTypeLoc.class)), Sel);
      break;
     case Vector:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(VectorTypeLoc.class)), Sel);
      break;
     case ExtVector:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ExtVectorTypeLoc.class)), Sel);
      break;
     case FunctionProto:
      Check(TL.castAs(FunctionProtoTypeLoc.class), Sel);
      break;
     case FunctionNoProto:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(FunctionNoProtoTypeLoc.class)), Sel);
      break;
     case UnresolvedUsing:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(UnresolvedUsingTypeLoc.class)), Sel);
      break;
     case Paren:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ParenTypeLoc.class)), Sel);
      break;
     case Typedef:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(TypedefTypeLoc.class)), Sel);
      break;
     case Adjusted:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(AdjustedTypeLoc.class)), Sel);
      break;
     case Decayed:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(DecayedTypeLoc.class)), Sel);
      break;
     case TypeOfExpr:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(TypeOfExprTypeLoc.class)), Sel);
      break;
     case TypeOf:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(TypeOfTypeLoc.class)), Sel);
      break;
     case Decltype:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(DecltypeTypeLoc.class)), Sel);
      break;
     case UnaryTransform:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(UnaryTransformTypeLoc.class)), Sel);
      break;
     case Record:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(RecordTypeLoc.class)), Sel);
      break;
     case Enum:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(EnumTypeLoc.class)), Sel);
      break;
     case Elaborated:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ElaboratedTypeLoc.class)), Sel);
      break;
     case Attributed:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(AttributedTypeLoc.class)), Sel);
      break;
     case TemplateTypeParm:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(TemplateTypeParmTypeLoc.class)), Sel);
      break;
     case SubstTemplateTypeParm:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(SubstTemplateTypeParmTypeLoc.class)), Sel);
      break;
     case SubstTemplateTypeParmPack:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(SubstTemplateTypeParmPackTypeLoc.class)), Sel);
      break;
     case TemplateSpecialization:
      Check(TL.castAs(TemplateSpecializationTypeLoc.class), Sel);
      break;
     case Auto:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(AutoTypeLoc.class)), Sel);
      break;
     case InjectedClassName:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(InjectedClassNameTypeLoc.class)), Sel);
      break;
     case DependentName:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(DependentNameTypeLoc.class)), Sel);
      break;
     case DependentTemplateSpecialization:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(DependentTemplateSpecializationTypeLoc.class)), Sel);
      break;
     case PackExpansion:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(PackExpansionTypeLoc.class)), Sel);
      break;
     case ObjCObject:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ObjCObjectTypeLoc.class)), Sel);
      break;
     case ObjCInterface:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ObjCInterfaceTypeLoc.class)), Sel);
      break;
     case ObjCObjectPointer:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(ObjCObjectPointerTypeLoc.class)), Sel);
      break;
     case Pipe:
      Check(new TypeLoc(JD$Move.INSTANCE, TL.castAs(PipeTypeLoc.class)), Sel);
      break;
     case Atomic:
      Check(TL.castAs(AtomicTypeLoc.class), Sel);
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4521,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang20FunctionProtoTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang20FunctionProtoTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(FunctionProtoTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getReturnLoc(), Sema.AbstractDiagSelID.AbstractReturnType);
    for (/*uint*/int I = 0, E = TL.getNumParams(); I != E; ++I) {
      if (!(TL.getParam(I) != null)) {
        continue;
      }
      
      TypeSourceInfo /*P*/ TSI = TL.getParam(I).getTypeSourceInfo();
      if ((TSI != null)) {
        Visit(TSI.getTypeLoc(), Sema.AbstractDiagSelID.AbstractParamType);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4532,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang12ArrayTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang12ArrayTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(ArrayTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getElementLoc(), Sema.AbstractDiagSelID.AbstractArrayType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4536,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang29TemplateSpecializationTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang29TemplateSpecializationTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(TemplateSpecializationTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    // Visit the type parameters from a permissive context.
    for (/*uint*/int I = 0, E = TL.getNumArgs(); I != E; ++I) {
      TemplateArgumentLoc TAL = TL.getArgLoc(I);
      if (TAL.getArgument().getKind() == TemplateArgument.ArgKind.Type) {
        {
          TypeSourceInfo /*P*/ TSI = TAL.getTypeSourceInfo();
          if ((TSI != null)) {
            Visit(TSI.getTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
          }
        }
      }
      // TODO: other template argument types?
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4552,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang14PointerTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang14PointerTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(PointerTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getNextTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4553,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang16ReferenceTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang16ReferenceTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(ReferenceTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getNextTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4554,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang20MemberPointerTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang20MemberPointerTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(MemberPointerTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getNextTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4555,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang19BlockPointerTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang19BlockPointerTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(BlockPointerTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getNextTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4556,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang13AtomicTypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang13AtomicTypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(AtomicTypeLoc TL, Sema.AbstractDiagSelID Sel) {
    Visit(TL.getNextTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
  }

  
  /// Handle all the types we haven't given a more specific
  /// implementation for above.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckAbstractUsage::Check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4560,
   FQN="(anonymous namespace)::CheckAbstractUsage::Check", NM="_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang7TypeLocENS1_4Sema17AbstractDiagSelIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckAbstractUsage5CheckEN5clang7TypeLocENS1_4Sema17AbstractDiagSelIDE")
  //</editor-fold>
  public void Check(TypeLoc TL, Sema.AbstractDiagSelID Sel) {
    {
      // Every other kind of type that we haven't called out already
      // that has an inner type is either (1) sugar or (2) contains that
      // inner type in some way as a subobject.
      TypeLoc Next = TL.getNextTypeLoc();
      if (Next.$bool()) {
        Visit(new TypeLoc(Next), Sel);
        /*JAVA:return*/return;
      }
    }
    
    // If there's no inner type and we're in a permissive context,
    // don't diagnose.
    if (Sel == Sema.AbstractDiagSelID.AbstractNone) {
      return;
    }
    
    // Check whether the type matches the abstract type.
    QualType T = TL.getType();
    if (T.$arrow().isArrayType()) {
      Sel = Sema.AbstractDiagSelID.AbstractArrayType;
      T.$assignMove(Info.S.Context.getBaseElementType(new QualType(T)));
    }
    CanQual<Type> CT = T.$arrow().getCanonicalTypeUnqualified().getUnqualifiedType();
    if ($noteq_CanQual$T_CanQual$U(/*NO_COPY*/CT, /*NO_COPY*/Info.AbstractType)) {
      return;
    }
    
    // It matched; do some magic.
    if (Sel == Sema.AbstractDiagSelID.AbstractArrayType) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Info.S.Diag(Ctx.getLocation(), diag.err_array_of_abstract_type)), 
                T), TL.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Info.S.Diag(Ctx.getLocation(), diag.err_abstract_type_in_decl)), 
                    Sel), T), TL.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    Info.DiagnoseAbstractType();
  }

  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", Ctx=" + Ctx; // NOI18N
  }
}
