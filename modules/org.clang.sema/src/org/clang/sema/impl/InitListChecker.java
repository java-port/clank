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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaInitStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;



/// @brief Semantic checking for initializer lists.
///
/// The InitListChecker class contains a set of routines that each
/// handle the initialization of a certain kind of entity, e.g.,
/// arrays, vectors, struct/union types, scalars, etc. The
/// InitListChecker itself performs a recursive walk of the subobject
/// structure of the type to be initialized, while stepping through
/// the initializer list one element at a time. The IList and Index
/// parameters to each of the Check* routines contain the active
/// (syntactic) initializer list and the index into that initializer
/// list that represents the current initializer. Each routine is
/// responsible for moving that Index forward as it consumes elements.
///
/// Each Check* routine also has a StructuredList/StructuredIndex
/// arguments, which contains the current "structured" (semantic)
/// initializer list and the index into that initializer list where we
/// are copying initializers as we map them over to the semantic
/// list. Once we have completed our recursive walk of the subobject
/// structure, we will have constructed a full semantic initializer
/// list.
///
/// C99 designators cause changes in the initializer list traversal,
/// because they make the initialization "jump" into a specific
/// subobject and then continue the initialization from that
/// point. CheckDesignatedInitializer() recursively steps into the
/// designated subobject and manages backing out the recursion to
/// initialize the subobjects after the one designated.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 237,
 FQN="(anonymous namespace)::InitListChecker", NM="_ZN12_GLOBAL__N_115InitListCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListCheckerE")
//</editor-fold>
public class InitListChecker implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ SemaRef;
  private boolean hadError;
  private boolean VerifyOnly; // no diagnostics, no structure building
  private boolean TreatUnavailableAsInvalid; // Used only in VerifyOnly mode.
  private DenseMap<InitListExpr /*P*/ , InitListExpr /*P*/ > SyntacticToSemantic;
  private InitListExpr /*P*/ FullyStructuredList;
  
  
  /// Check whether the range of the initializer \p ParentIList from element
  /// \p Index onwards can be used to initialize an object of type \p T. Update
  /// \p Index to indicate how many elements of the list were consumed.
  ///
  /// This also fills in \p StructuredList, from element \p StructuredIndex
  /// onwards, with the fully-braced, desugared form of the initialization.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckImplicitInitList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 822,
   FQN="(anonymous namespace)::InitListChecker::CheckImplicitInitList", NM="_ZN12_GLOBAL__N_115InitListChecker21CheckImplicitInitListERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker21CheckImplicitInitListERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_")
  //</editor-fold>
  private void CheckImplicitInitList(final /*const*/ InitializedEntity /*&*/ Entity, 
                       InitListExpr /*P*/ ParentIList, 
                       QualType T, final uint$ref/*uint &*/ Index, 
                       InitListExpr /*P*/ StructuredList, 
                       final uint$ref/*uint &*/ StructuredIndex) {
    int maxElements = 0;
    if (T.$arrow().isArrayType()) {
      maxElements = numArrayElements(new QualType(T));
    } else if (T.$arrow().isRecordType()) {
      maxElements = numStructUnionElements(new QualType(T));
    } else if (T.$arrow().isVectorType()) {
      maxElements = T.$arrow().getAs(VectorType.class).getNumElements();
    } else {
      throw new llvm_unreachable("CheckImplicitInitList(): Illegal type");
    }
    if (maxElements == 0) {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(SemaRef.Diag(ParentIList.getInit(Index.$deref()).getLocStart(), 
              diag.err_implicit_empty_initializer)));
        } finally {
          $c$.$destroy();
        }
      }
      Index.$set$preInc();
      hadError = true;
      return;
    }
    
    // Build a structured initializer list corresponding to this subobject.
    InitListExpr /*P*/ StructuredSubobjectInitList = getStructuredSubobjectInit(ParentIList, Index.$deref(), new QualType(T), StructuredList, 
        StructuredIndex.$deref(), 
        new SourceRange(ParentIList.getInit(Index.$deref()).getLocStart(), 
            ParentIList.getSourceRange().getEnd()));
    uint$ref StructuredSubobjectInitIndex = create_uint$ref(0);
    
    // Check the element types and build the structural subobject.
    /*uint*/int StartIndex = Index.$deref();
    CheckListElementTypes(Entity, ParentIList, T, 
        /*SubobjectIsDesignatorContext=*/ false, Index, 
        StructuredSubobjectInitList, 
        StructuredSubobjectInitIndex);
    if (!VerifyOnly) {
      StructuredSubobjectInitList.setType(new QualType(T));
      
      /*uint*/int EndIndex = (Index.$deref() == StartIndex ? StartIndex : Index.$deref() - 1);
      // Update the structured sub-object initializer so that it's ending
      // range corresponds with the end of the last initializer it used.
      if ($less_uint(EndIndex, ParentIList.getNumInits())
         && (ParentIList.getInit(EndIndex) != null)) {
        SourceLocation EndLoc = ParentIList.getInit(EndIndex).getSourceRange().getEnd();
        StructuredSubobjectInitList.setRBraceLoc(new SourceLocation(EndLoc));
      }
      
      // Complain about missing braces.
      if (T.$arrow().isArrayType() || T.$arrow().isRecordType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(StructuredSubobjectInitList.getLocStart(), 
                          diag.warn_missing_braces)), 
                      StructuredSubobjectInitList.getSourceRange()), 
                  FixItHint.CreateInsertion(StructuredSubobjectInitList.getLocStart(), new StringRef(/*KEEP_STR*/$LCURLY))), 
              FixItHint.CreateInsertion(SemaRef.getLocForEndOfToken(StructuredSubobjectInitList.getLocEnd()), 
                  new StringRef(/*KEEP_STR*/$RCURLY))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  /// Check whether the initializer \p IList (that was written with explicit
  /// braces) can be used to initialize an object of type \p T.
  ///
  /// This also fills in \p StructuredList with the fully-braced, desugared
  /// form of the initialization.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckExplicitInitList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 956,
   FQN="(anonymous namespace)::InitListChecker::CheckExplicitInitList", NM="_ZN12_GLOBAL__N_115InitListChecker21CheckExplicitInitListERKN5clang17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker21CheckExplicitInitListERKN5clang17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeES6_b")
  //</editor-fold>
  private void CheckExplicitInitList(final /*const*/ InitializedEntity /*&*/ Entity, 
                       InitListExpr /*P*/ IList, final QualType /*&*/ T, 
                       InitListExpr /*P*/ StructuredList) {
    CheckExplicitInitList(Entity, 
                       IList, T, 
                       StructuredList, 
                       false);
  }
  private void CheckExplicitInitList(final /*const*/ InitializedEntity /*&*/ Entity, 
                       InitListExpr /*P*/ IList, final QualType /*&*/ T, 
                       InitListExpr /*P*/ StructuredList, 
                       boolean TopLevelObject/*= false*/) {
    if (!VerifyOnly) {
      SyntacticToSemantic.$set(IList, StructuredList);
      StructuredList.setSyntacticForm(IList);
    }
    
    uint$ref Index = create_uint$ref(0);
    uint$ref StructuredIndex = create_uint$ref(0);
    CheckListElementTypes(Entity, IList, T, /*SubobjectIsDesignatorContext=*/ true, 
        Index, StructuredList, StructuredIndex, TopLevelObject);
    if (!VerifyOnly) {
      QualType ExprTy = new QualType(T);
      if (!ExprTy.$arrow().isArrayType()) {
        ExprTy.$assignMove(ExprTy.getNonLValueExprType(SemaRef.Context));
      }
      IList.setType(new QualType(ExprTy));
      StructuredList.setType(new QualType(ExprTy));
    }
    if (hadError) {
      return;
    }
    if ($less_uint(Index.$deref(), IList.getNumInits())) {
      // We have leftover initializers
      if (VerifyOnly) {
        if (SemaRef.getLangOpts().CPlusPlus
           || (SemaRef.getLangOpts().OpenCL
           && IList.getType().$arrow().isVectorType())) {
          hadError = true;
        }
        return;
      }
      if (StructuredIndex.$deref() == 1
         && IsStringInit(StructuredList.getInit(0), new QualType(T), SemaRef.Context)
         == StringInitFailureKind.SIF_None) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int DK = diag.ext_excess_initializers_in_char_array_initializer;
          if (SemaRef.getLangOpts().CPlusPlus) {
            DK = diag.err_excess_initializers_in_char_array_initializer;
            hadError = true;
          }
          // Special-case
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getInit(Index.$deref()).getLocStart(), DK)), 
              IList.getInit(Index.$deref()).getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else if (!T.$arrow().isIncompleteType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Don't complain for incomplete types, since we'll get an error
          // elsewhere
          QualType CurrentObjectType = StructuredList.getType();
          int initKind = CurrentObjectType.$arrow().isArrayType() ? 0 : CurrentObjectType.$arrow().isVectorType() ? 1 : CurrentObjectType.$arrow().isScalarType() ? 2 : CurrentObjectType.$arrow().isUnionType() ? 3 : 4;
          
          /*uint*/int DK = diag.ext_excess_initializers;
          if (SemaRef.getLangOpts().CPlusPlus) {
            DK = diag.err_excess_initializers;
            hadError = true;
          }
          if (SemaRef.getLangOpts().OpenCL && initKind == 1) {
            DK = diag.err_excess_initializers;
            hadError = true;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getInit(Index.$deref()).getLocStart(), DK)), 
                  initKind), IList.getInit(Index.$deref()).getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!VerifyOnly && T.$arrow().isScalarType()
       && IList.getNumInits() == 1 && !isa_InitListExpr(IList.getInit(0))) {
      warnBracedScalarInit(SemaRef, Entity, IList.getSourceRange());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckListElementTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1031,
   FQN="(anonymous namespace)::InitListChecker::CheckListElementTypes", NM="_ZN12_GLOBAL__N_115InitListChecker21CheckListElementTypesERKN5clang17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeEbRjS6_S9_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker21CheckListElementTypesERKN5clang17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeEbRjS6_S9_b")
  //</editor-fold>
  private void CheckListElementTypes(final /*const*/ InitializedEntity /*&*/ Entity, 
                       InitListExpr /*P*/ IList, 
                       final QualType /*&*/ DeclType, 
                       boolean SubobjectIsDesignatorContext, 
                       final uint$ref/*uint &*/ Index, 
                       InitListExpr /*P*/ StructuredList, 
                       final uint$ref/*uint &*/ StructuredIndex) {
    CheckListElementTypes(Entity, 
                       IList, 
                       DeclType, 
                       SubobjectIsDesignatorContext, 
                       Index, 
                       StructuredList, 
                       StructuredIndex, 
                       false);
  }
  private void CheckListElementTypes(final /*const*/ InitializedEntity /*&*/ Entity, 
                       InitListExpr /*P*/ IList, 
                       final QualType /*&*/ DeclType, 
                       boolean SubobjectIsDesignatorContext, 
                       final uint$ref/*uint &*/ Index, 
                       InitListExpr /*P*/ StructuredList, 
                       final uint$ref/*uint &*/ StructuredIndex, 
                       boolean TopLevelObject/*= false*/) {
    if (DeclType.$arrow().isAnyComplexType() && SubobjectIsDesignatorContext) {
      // Explicitly braced initializer for complex type can be real+imaginary
      // parts.
      CheckComplexType(Entity, IList, new QualType(DeclType), Index, 
          StructuredList, StructuredIndex);
    } else if (DeclType.$arrow().isScalarType()) {
      CheckScalarType(Entity, IList, new QualType(DeclType), Index, 
          StructuredList, StructuredIndex);
    } else if (DeclType.$arrow().isVectorType()) {
      CheckVectorType(Entity, IList, new QualType(DeclType), Index, 
          StructuredList, StructuredIndex);
    } else if (DeclType.$arrow().isRecordType()) {
      assert (DeclType.$arrow().isAggregateType()) : "non-aggregate records should be handed in CheckSubElementType";
      RecordDecl /*P*/ RD = DeclType.$arrow().<RecordType>getAs$RecordType().getDecl();
      iterator_range<CXXBaseSpecifier> Bases = new iterator_range<CXXBaseSpecifier>(((type$ptr<CXXBaseSpecifier /*P*/ >)null), 
          ((type$ptr<CXXBaseSpecifier /*P*/ >)null));
      {
        CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
        if ((CXXRD != null)) {
          Bases.$assignMove(CXXRD.bases());
        }
      }
      CheckStructUnionTypes(Entity, IList, new QualType(DeclType), new iterator_range<CXXBaseSpecifier>(Bases), RD.field_begin(), 
          SubobjectIsDesignatorContext, Index, StructuredList, 
          StructuredIndex, TopLevelObject);
    } else if (DeclType.$arrow().isArrayType()) {
      APSInt Zero/*J*/= new APSInt($ulong2uint(SemaRef.Context.getTypeSize(SemaRef.Context.getSizeType().$QualType())), 
          false);
      CheckArrayType(Entity, IList, DeclType, new APSInt(Zero), 
          SubobjectIsDesignatorContext, Index, 
          StructuredList, StructuredIndex);
    } else if (DeclType.$arrow().isVoidType() || DeclType.$arrow().isFunctionType()) {
      // This type is invalid, issue a diagnostic.
      Index.$set$preInc();
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), diag.err_illegal_initializer_type)), 
              DeclType));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = true;
    } else if (DeclType.$arrow().isReferenceType()) {
      CheckReferenceType(Entity, IList, new QualType(DeclType), Index, 
          StructuredList, StructuredIndex);
    } else if (DeclType.$arrow().isObjCObjectType()) {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), diag.err_init_objc_class)), 
              DeclType));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = true;
    } else {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), diag.err_illegal_initializer_type)), 
              DeclType));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckSubElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1092,
   FQN="(anonymous namespace)::InitListChecker::CheckSubElementType", NM="_ZN12_GLOBAL__N_115InitListChecker19CheckSubElementTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker19CheckSubElementTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_")
  //</editor-fold>
  private void CheckSubElementType(final /*const*/ InitializedEntity /*&*/ Entity, 
                     InitListExpr /*P*/ IList, 
                     QualType ElemType, 
                     final uint$ref/*uint &*/ Index, 
                     InitListExpr /*P*/ StructuredList, 
                     final uint$ref/*uint &*/ StructuredIndex) {
    Expr /*P*/ expr = IList.getInit(Index.$deref());
    if (ElemType.$arrow().isReferenceType()) {
      CheckReferenceType(Entity, IList, new QualType(ElemType), Index, 
          StructuredList, StructuredIndex);
      /*JAVA:return*/return;
    }
    {
      
      InitListExpr /*P*/ SubInitList = dyn_cast_InitListExpr(expr);
      if ((SubInitList != null)) {
        if (SubInitList.getNumInits() == 1
           && IsStringInit(SubInitList.getInit(0), new QualType(ElemType), SemaRef.Context)
           == StringInitFailureKind.SIF_None) {
          expr = SubInitList.getInit(0);
        } else if (!SemaRef.getLangOpts().CPlusPlus) {
          InitListExpr /*P*/ InnerStructuredList = getStructuredSubobjectInit(IList, Index.$deref(), new QualType(ElemType), 
              StructuredList, StructuredIndex.$deref(), 
              SubInitList.getSourceRange(), true);
          CheckExplicitInitList(Entity, SubInitList, ElemType, 
              InnerStructuredList);
          if (!hadError && !VerifyOnly) {
            bool$ref RequiresSecondPass = create_bool$ref(false);
            FillInEmptyInitializations(Entity, InnerStructuredList, 
                RequiresSecondPass);
            if (RequiresSecondPass.$deref() && !hadError) {
              FillInEmptyInitializations(Entity, InnerStructuredList, 
                  RequiresSecondPass);
            }
          }
          StructuredIndex.$set$preInc();
          Index.$set$preInc();
          return;
        }
        // C++ initialization is handled later.
      } else if (isa_ImplicitValueInitExpr(expr)) {
        // This happens during template instantiation when we see an InitListExpr
        // that we've already checked once.
        assert (SemaRef.Context.hasSameType(expr.getType(), new QualType(ElemType))) : "found implicit initialization for the wrong type";
        if (!VerifyOnly) {
          UpdateStructuredListElement(StructuredList, StructuredIndex, expr);
        }
        Index.$set$preInc();
        return;
      }
    }
    if (SemaRef.getLangOpts().CPlusPlus) {
      InitializationSequence Seq = null;
      try {
        // C++ [dcl.init.aggr]p2:
        //   Each member is copy-initialized from the corresponding
        //   initializer-clause.
        
        // FIXME: Better EqualLoc?
        InitializationKind Kind = InitializationKind.CreateCopy(expr.getLocStart(), new SourceLocation());
        Seq/*J*/= new InitializationSequence(SemaRef, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(expr, true), 
            /*TopLevelOfInitList*/ true);
        
        // C++14 [dcl.init.aggr]p13:
        //   If the assignment-expression can initialize a member, the member is
        //   initialized. Otherwise [...] brace elision is assumed
        //
        // Brace elision is never performed if the element is not an
        // assignment-expression.
        if (Seq.$bool() || isa_InitListExpr(expr)) {
          if (!VerifyOnly) {
            ActionResultTTrue<Expr /*P*/ > Result = Seq.Perform(SemaRef, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(expr, true));
            if (Result.isInvalid()) {
              hadError = true;
            }
            
            UpdateStructuredListElement(StructuredList, StructuredIndex, 
                Result.getAs(Expr.class));
          } else if (!Seq.$bool()) {
            hadError = true;
          }
          Index.$set$preInc();
          return;
        }
      } finally {
        if (Seq != null) { Seq.$destroy(); }
      }
      // Fall through for subaggregate initialization
    } else if (ElemType.$arrow().isScalarType() || ElemType.$arrow().isAtomicType()) {
      // FIXME: Need to handle atomic aggregate types with implicit init lists.
      CheckScalarType(Entity, IList, new QualType(ElemType), Index, 
          StructuredList, StructuredIndex);
      /*JAVA:return*/return;
    } else {
      /*const*/ ArrayType /*P*/ arrayType = SemaRef.Context.getAsArrayType(new QualType(ElemType));
      if ((arrayType != null)) {
        // arrayType can be incomplete if we're initializing a flexible
        // array member.  There's nothing we can do with the completed
        // type here, though.
        if (IsStringInit(expr, arrayType, SemaRef.Context) == StringInitFailureKind.SIF_None) {
          if (!VerifyOnly) {
            CheckStringInit(expr, ElemType, arrayType, SemaRef);
            UpdateStructuredListElement(StructuredList, StructuredIndex, expr);
          }
          Index.$set$preInc();
          return;
        }
        // Fall through for subaggregate initialization.
      } else {
        assert ((ElemType.$arrow().isRecordType() || ElemType.$arrow().isVectorType() || ElemType.$arrow().isClkEventT())) : "Unexpected type";
        
        // C99 6.7.8p13:
        //
        //   The initializer for a structure or union object that has
        //   automatic storage duration shall be either an initializer
        //   list as described below, or a single expression that has
        //   compatible structure or union type. In the latter case, the
        //   initial value of the object, including unnamed members, is
        //   that of the expression.
        ActionResultTTrue<Expr /*P*/ > ExprRes = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr);
        if (SemaRef.CheckSingleAssignmentConstraints(new QualType(ElemType), ExprRes, !VerifyOnly) != Sema.AssignConvertType.Incompatible) {
          if (ExprRes.isInvalid()) {
            hadError = true;
          } else {
            ExprRes.$assignMove(SemaRef.DefaultFunctionArrayLvalueConversion(ExprRes.get()));
            if (ExprRes.isInvalid()) {
              hadError = true;
            }
          }
          UpdateStructuredListElement(StructuredList, StructuredIndex, 
              ExprRes.getAs(Expr.class));
          Index.$set$preInc();
          return;
        }
        ExprRes.get();
        // Fall through for subaggregate initialization
      }
    }
    
    // C++ [dcl.init.aggr]p12:
    //
    //   [...] Otherwise, if the member is itself a non-empty
    //   subaggregate, brace elision is assumed and the initializer is
    //   considered for the initialization of the first member of
    //   the subaggregate.
    if (!SemaRef.getLangOpts().OpenCL
       && (ElemType.$arrow().isAggregateType() || ElemType.$arrow().isVectorType())) {
      CheckImplicitInitList(Entity, IList, new QualType(ElemType), Index, StructuredList, 
          StructuredIndex);
      StructuredIndex.$set$preInc();
    } else {
      if (!VerifyOnly) {
        // We cannot initialize this element, so let
        // PerformCopyInitialization produce the appropriate diagnostic.
        SemaRef.PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr), 
            /*TopLevelOfInitList=*/ true);
      }
      hadError = true;
      Index.$set$preInc();
      StructuredIndex.$set$preInc();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1250,
   FQN="(anonymous namespace)::InitListChecker::CheckComplexType", NM="_ZN12_GLOBAL__N_115InitListChecker16CheckComplexTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker16CheckComplexTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_")
  //</editor-fold>
  private void CheckComplexType(final /*const*/ InitializedEntity /*&*/ Entity, 
                  InitListExpr /*P*/ IList, QualType DeclType, 
                  final uint$ref/*uint &*/ Index, 
                  InitListExpr /*P*/ StructuredList, 
                  final uint$ref/*uint &*/ StructuredIndex) {
    assert (Index.$deref() == 0) : "Index in explicit init list must be zero";
    
    // As an extension, clang supports complex initializers, which initialize
    // a complex number component-wise.  When an explicit initializer list for
    // a complex number contains two two initializers, this extension kicks in:
    // it exepcts the initializer list to contain two elements convertible to
    // the element type of the complex type. The first element initializes
    // the real part, and the second element intitializes the imaginary part.
    if (IList.getNumInits() != 2) {
      CheckScalarType(Entity, IList, new QualType(DeclType), Index, StructuredList, 
          StructuredIndex);
      /*JAVA:return*/return;
    }
    
    // This is an extension in C.  (The builtin _Complex type does not exist
    // in the C++ standard.)
    if (!SemaRef.getLangOpts().CPlusPlus && !VerifyOnly) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), diag.ext_complex_component_init)), 
            IList.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Initialize the complex number.
    QualType elementType = DeclType.$arrow().getAs(ComplexType.class).getElementType();
    InitializedEntity ElementEntity = InitializedEntity.InitializeElement(SemaRef.Context, 0, Entity);
    
    for (/*uint*/int i = 0; $less_uint(i, 2); ++i) {
      ElementEntity.setElementIndex(Index.$deref());
      CheckSubElementType(ElementEntity, IList, new QualType(elementType), Index, 
          StructuredList, StructuredIndex);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckScalarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1286,
   FQN="(anonymous namespace)::InitListChecker::CheckScalarType", NM="_ZN12_GLOBAL__N_115InitListChecker15CheckScalarTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker15CheckScalarTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_")
  //</editor-fold>
  private void CheckScalarType(final /*const*/ InitializedEntity /*&*/ Entity, 
                 InitListExpr /*P*/ IList, QualType DeclType, 
                 final uint$ref/*uint &*/ Index, 
                 InitListExpr /*P*/ StructuredList, 
                 final uint$ref/*uint &*/ StructuredIndex) {
    if ($greatereq_uint(Index.$deref(), IList.getNumInits())) {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), 
                  SemaRef.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_empty_scalar_initializer : diag.err_empty_scalar_initializer)), 
              IList.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = !SemaRef.getLangOpts().CPlusPlus11;
      Index.$set$preInc();
      StructuredIndex.$set$preInc();
      return;
    }
    
    Expr /*P*/ expr = IList.getInit(Index.$deref());
    {
      InitListExpr /*P*/ SubIList = dyn_cast_InitListExpr(expr);
      if ((SubIList != null)) {
        // FIXME: This is invalid, and accepting it causes overload resolution
        // to pick the wrong overload in some corner cases.
        if (!VerifyOnly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(SubIList.getLocStart(), 
                    diag.ext_many_braces_around_scalar_init)), 
                SubIList.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        
        CheckScalarType(Entity, SubIList, new QualType(DeclType), Index, StructuredList, 
            StructuredIndex);
        return;
      } else if (isa_DesignatedInitExpr(expr)) {
        if (!VerifyOnly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(expr.getLocStart(), 
                        diag.err_designator_for_scalar_init)), 
                    DeclType), expr.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        hadError = true;
        Index.$set$preInc();
        StructuredIndex.$set$preInc();
        return;
      }
    }
    if (VerifyOnly) {
      if (!SemaRef.CanPerformCopyInitialization(Entity, new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr))) {
        hadError = true;
      }
      Index.$set$preInc();
      return;
    }
    
    ActionResultTTrue<Expr /*P*/ > Result = SemaRef.PerformCopyInitialization(Entity, expr.getLocStart(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr), 
        /*TopLevelOfInitList=*/ true);
    
    Expr /*P*/ ResultExpr = null;
    if (Result.isInvalid()) {
      hadError = true; // types weren't compatible.
    } else {
      ResultExpr = Result.getAs(Expr.class);
      if (ResultExpr != expr) {
        // The type was promoted, update initializer list.
        IList.setInit(Index.$deref(), ResultExpr);
      }
    }
    if (hadError) {
      StructuredIndex.$set$preInc();
    } else {
      UpdateStructuredListElement(StructuredList, StructuredIndex, ResultExpr);
    }
    Index.$set$preInc();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1357,
   FQN="(anonymous namespace)::InitListChecker::CheckReferenceType", NM="_ZN12_GLOBAL__N_115InitListChecker18CheckReferenceTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker18CheckReferenceTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_")
  //</editor-fold>
  private void CheckReferenceType(final /*const*/ InitializedEntity /*&*/ Entity, 
                    InitListExpr /*P*/ IList, QualType DeclType, 
                    final uint$ref/*uint &*/ Index, 
                    InitListExpr /*P*/ StructuredList, 
                    final uint$ref/*uint &*/ StructuredIndex) {
    if ($greatereq_uint(Index.$deref(), IList.getNumInits())) {
      // FIXME: It would be wonderful if we could point at the actual member. In
      // general, it would be useful to pass location information down the stack,
      // so that we know the location (or decl) of the "current object" being
      // initialized.
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), 
                      diag.err_init_reference_member_uninitialized)), 
                  DeclType), 
              IList.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = true;
      Index.$set$preInc();
      StructuredIndex.$set$preInc();
      return;
    }
    
    Expr /*P*/ expr = IList.getInit(Index.$deref());
    if (isa_InitListExpr(expr) && !SemaRef.getLangOpts().CPlusPlus11) {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), diag.err_init_non_aggr_init_list)), 
                  DeclType), IList.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = true;
      Index.$set$preInc();
      StructuredIndex.$set$preInc();
      return;
    }
    if (VerifyOnly) {
      if (!SemaRef.CanPerformCopyInitialization(Entity, new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr))) {
        hadError = true;
      }
      Index.$set$preInc();
      return;
    }
    
    ActionResultTTrue<Expr /*P*/ > Result = SemaRef.PerformCopyInitialization(Entity, expr.getLocStart(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr), 
        /*TopLevelOfInitList=*/ true);
    if (Result.isInvalid()) {
      hadError = true;
    }
    
    expr = Result.getAs(Expr.class);
    IList.setInit(Index.$deref(), expr);
    if (hadError) {
      StructuredIndex.$set$preInc();
    } else {
      UpdateStructuredListElement(StructuredList, StructuredIndex, expr);
    }
    Index.$set$preInc();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1413,
   FQN="(anonymous namespace)::InitListChecker::CheckVectorType", NM="_ZN12_GLOBAL__N_115InitListChecker15CheckVectorTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker15CheckVectorTypeERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeERjS6_S8_")
  //</editor-fold>
  private void CheckVectorType(final /*const*/ InitializedEntity /*&*/ Entity, 
                 InitListExpr /*P*/ IList, QualType DeclType, 
                 final uint$ref/*uint &*/ Index, 
                 InitListExpr /*P*/ StructuredList, 
                 final uint$ref/*uint &*/ StructuredIndex) {
    /*const*/ VectorType /*P*/ VT = DeclType.$arrow().getAs(VectorType.class);
    /*uint*/int maxElements = VT.getNumElements();
    /*uint*/int numEltsInit = 0;
    QualType elementType = VT.getElementType();
    if ($greatereq_uint(Index.$deref(), IList.getNumInits())) {
      // Make sure the element type can be value-initialized.
      if (VerifyOnly) {
        CheckEmptyInitializable(InitializedEntity.InitializeElement(SemaRef.Context, 0, Entity), 
            IList.getLocEnd());
      }
      return;
    }
    if (!SemaRef.getLangOpts().OpenCL) {
      // If the initializing element is a vector, try to copy-initialize
      // instead of breaking it apart (which is doomed to failure anyway).
      Expr /*P*/ Init = IList.getInit(Index.$deref());
      if (!isa_InitListExpr(Init) && Init.getType().$arrow().isVectorType()) {
        if (VerifyOnly) {
          if (!SemaRef.CanPerformCopyInitialization(Entity, new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Init))) {
            hadError = true;
          }
          Index.$set$preInc();
          return;
        }
        
        ActionResultTTrue<Expr /*P*/ > Result = SemaRef.PerformCopyInitialization(Entity, Init.getLocStart(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Init), 
            /*TopLevelOfInitList=*/ true);
        
        Expr /*P*/ ResultExpr = null;
        if (Result.isInvalid()) {
          hadError = true; // types weren't compatible.
        } else {
          ResultExpr = Result.getAs(Expr.class);
          if (ResultExpr != Init) {
            // The type was promoted, update initializer list.
            IList.setInit(Index.$deref(), ResultExpr);
          }
        }
        if (hadError) {
          StructuredIndex.$set$preInc();
        } else {
          UpdateStructuredListElement(StructuredList, StructuredIndex, 
              ResultExpr);
        }
        Index.$set$preInc();
        return;
      }
      
      InitializedEntity ElementEntity = InitializedEntity.InitializeElement(SemaRef.Context, 0, Entity);
      
      for (/*uint*/int i = 0; $less_uint(i, maxElements); ++i , ++numEltsInit) {
        // Don't attempt to go past the end of the init list
        if ($greatereq_uint(Index.$deref(), IList.getNumInits())) {
          if (VerifyOnly) {
            CheckEmptyInitializable(ElementEntity, IList.getLocEnd());
          }
          break;
        }
        
        ElementEntity.setElementIndex(Index.$deref());
        CheckSubElementType(ElementEntity, IList, new QualType(elementType), Index, 
            StructuredList, StructuredIndex);
      }
      if (VerifyOnly) {
        return;
      }
      
      boolean isBigEndian = SemaRef.Context.getTargetInfo().isBigEndian();
      /*const*/ VectorType /*P*/ T = Entity.getType().$arrow().getAs(VectorType.class);
      if (isBigEndian && (T.getVectorKind() == VectorType.VectorKind.NeonVector
         || T.getVectorKind() == VectorType.VectorKind.NeonPolyVector)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The ability to use vector initializer lists is a GNU vector extension
          // and is unrelated to the NEON intrinsics in arm_neon.h. On little
          // endian machines it works fine, however on big endian machines it 
          // exhibits surprising behaviour:
          //
          //   uint32x2_t x = {42, 64};
          //   return vget_lane_u32(x, 0); // Will return 64.
          //
          // Because of this, explicitly call out that it is non-portable.
          //
          $c$.clean($c$.track(SemaRef.Diag(IList.getLocStart(), 
              diag.warn_neon_vector_initializer_non_portable)));
          
          /*const*/char$ptr/*char P*/ typeCode;
          /*uint*/int typeSize = $ulong2uint(SemaRef.Context.getTypeSize(new QualType(elementType)));
          if (elementType.$arrow().isFloatingType()) {
            typeCode = $tryClone($f);
          } else if (elementType.$arrow().isSignedIntegerType()) {
            typeCode = $tryClone($s);
          } else if (elementType.$arrow().isUnsignedIntegerType()) {
            typeCode = $tryClone($u);
          } else {
            throw new llvm_unreachable("Invalid element type!");
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), 
                      $greater_ulong_ullong(SemaRef.Context.getTypeSize(VT), 64) ? diag.note_neon_vector_initializer_non_portable_q : diag.note_neon_vector_initializer_non_portable)), 
                  typeCode), typeSize));
        } finally {
          $c$.$destroy();
        }
      }
      
      return;
    }
    
    InitializedEntity ElementEntity = InitializedEntity.InitializeElement(SemaRef.Context, 0, Entity);
    
    // OpenCL initializers allows vectors to be constructed from vectors.
    for (/*uint*/int i = 0; $less_uint(i, maxElements); ++i) {
      // Don't attempt to go past the end of the init list
      if ($greatereq_uint(Index.$deref(), IList.getNumInits())) {
        break;
      }
      
      ElementEntity.setElementIndex(Index.$deref());
      
      QualType IType = IList.getInit(Index.$deref()).getType();
      if (!IType.$arrow().isVectorType()) {
        CheckSubElementType(ElementEntity, IList, new QualType(elementType), Index, 
            StructuredList, StructuredIndex);
        ++numEltsInit;
      } else {
        QualType VecType/*J*/= new QualType();
        /*const*/ VectorType /*P*/ IVT = IType.$arrow().getAs(VectorType.class);
        /*uint*/int numIElts = IVT.getNumElements();
        if (IType.$arrow().isExtVectorType()) {
          VecType.$assignMove(SemaRef.Context.getExtVectorType(new QualType(elementType), numIElts));
        } else {
          VecType.$assignMove(SemaRef.Context.getVectorType(new QualType(elementType), numIElts, 
                  IVT.getVectorKind()));
        }
        CheckSubElementType(ElementEntity, IList, new QualType(VecType), Index, 
            StructuredList, StructuredIndex);
        numEltsInit += numIElts;
      }
    }
    
    // OpenCL requires all elements to be initialized.
    if (numEltsInit != maxElements) {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getLocStart(), 
                          diag.err_vector_incorrect_num_initializers)), 
                      ($less_uint(numEltsInit, maxElements))), maxElements), numEltsInit));
        } finally {
          $c$.$destroy();
        }
      }
      hadError = true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckStructUnionTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1737,
   FQN="(anonymous namespace)::InitListChecker::CheckStructUnionTypes", NM="_ZN12_GLOBAL__N_115InitListChecker21CheckStructUnionTypesERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeEN4llvm14iterator_rangeIPNS1_16CXXBaseSpecifierEEENS1_11DeclContext22specific_decl_iteratorINS1_9FieldDeclEEEbRjS6_SH_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker21CheckStructUnionTypesERKN5clang17InitializedEntityEPNS1_12InitListExprENS1_8QualTypeEN4llvm14iterator_rangeIPNS1_16CXXBaseSpecifierEEENS1_11DeclContext22specific_decl_iteratorINS1_9FieldDeclEEEbRjS6_SH_b")
  //</editor-fold>
  private void CheckStructUnionTypes(final /*const*/ InitializedEntity /*&*/ Entity, InitListExpr /*P*/ IList, QualType DeclType, 
                       iterator_range<CXXBaseSpecifier> Bases, specific_decl_iterator<FieldDecl> Field, 
                       boolean SubobjectIsDesignatorContext, final uint$ref/*uint &*/ Index, 
                       InitListExpr /*P*/ StructuredList, final uint$ref/*uint &*/ StructuredIndex) {
    CheckStructUnionTypes(Entity, IList, DeclType, 
                       Bases, Field, 
                       SubobjectIsDesignatorContext, Index, 
                       StructuredList, StructuredIndex, 
                       false);
  }
  private void CheckStructUnionTypes(final /*const*/ InitializedEntity /*&*/ Entity, InitListExpr /*P*/ IList, QualType DeclType, 
                       iterator_range<CXXBaseSpecifier> Bases, specific_decl_iterator<FieldDecl> Field, 
                       boolean SubobjectIsDesignatorContext, final uint$ref/*uint &*/ Index, 
                       InitListExpr /*P*/ StructuredList, final uint$ref/*uint &*/ StructuredIndex, 
                       boolean TopLevelObject/*= false*/) {
    RecordDecl /*P*/ structDecl = DeclType.$arrow().<RecordType>getAs$RecordType().getDecl();
    
    // If the record is invalid, some of it's members are invalid. To avoid
    // confusion, we forgo checking the intializer for the entire record.
    if (structDecl.isInvalidDecl()) {
      // Assume it was supposed to consume a single initializer.
      Index.$set$preInc();
      hadError = true;
      return;
    }
    if (DeclType.$arrow().isUnionType() && IList.getNumInits() == 0) {
      RecordDecl /*P*/ RD = DeclType.$arrow().<RecordType>getAs$RecordType().getDecl();
      
      // If there's a default initializer, use it.
      if (isa_CXXRecordDecl(RD) && cast_CXXRecordDecl(RD).hasInClassInitializer()) {
        if (VerifyOnly) {
          return;
        }
        for (specific_decl_iterator<FieldDecl> FieldEnd = RD.field_end();
             $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc()) {
          if (Field.$arrow().hasInClassInitializer()) {
            StructuredList.setInitializedFieldInUnion(Field.$star());
            // FIXME: Actually build a CXXDefaultInitExpr?
            return;
          }
        }
      }
      
      // Value-initialize the first member of the union that isn't an unnamed
      // bitfield.
      for (specific_decl_iterator<FieldDecl> FieldEnd = RD.field_end();
           $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc()) {
        if (!Field.$arrow().isUnnamedBitfield()) {
          if (VerifyOnly) {
            CheckEmptyInitializable(InitializedEntity.InitializeMember(Field.$star(), $AddrOf(Entity)), 
                IList.getLocEnd());
          } else {
            StructuredList.setInitializedFieldInUnion(Field.$star());
          }
          break;
        }
      }
      return;
    }
    
    boolean InitializedSomething = false;
    
    // If we have any base classes, they are initialized prior to the fields.
    for (final CXXBaseSpecifier /*&*/ Base : Bases) {
      Expr /*P*/ Init = $less_uint(Index.$deref(), IList.getNumInits()) ? IList.getInit(Index.$deref()) : null;
      SourceLocation InitLoc = (Init != null) ? Init.getLocStart() : IList.getLocEnd();
      
      // Designated inits always initialize fields, so if we see one, all
      // remaining base classes have no explicit initializer.
      if ((Init != null) && isa_DesignatedInitExpr(Init)) {
        Init = null;
      }
      
      InitializedEntity BaseEntity = InitializedEntity.InitializeBase(SemaRef.Context, $AddrOf(Base), false, $AddrOf(Entity));
      if ((Init != null)) {
        CheckSubElementType(BaseEntity, IList, Base.getType(), Index, 
            StructuredList, StructuredIndex);
        InitializedSomething = true;
      } else if (VerifyOnly) {
        CheckEmptyInitializable(BaseEntity, new SourceLocation(InitLoc));
      }
    }
    
    // If structDecl is a forward declaration, this loop won't do
    // anything except look at designated initializers; That's okay,
    // because an error should get printed out elsewhere. It might be
    // worthwhile to skip over the rest of the initializer, though.
    RecordDecl /*P*/ RD = DeclType.$arrow().<RecordType>getAs$RecordType().getDecl();
    specific_decl_iterator<FieldDecl> FieldEnd = RD.field_end();
    boolean CheckForMissingFields = true;
    while ($less_uint(Index.$deref(), IList.getNumInits())) {
      Expr /*P*/ Init = IList.getInit(Index.$deref());
      {
        
        DesignatedInitExpr /*P*/ DIE = dyn_cast_DesignatedInitExpr(Init);
        if ((DIE != null)) {
          // If we're not the subobject that matches up with the '{' for
          // the designator, we shouldn't be handling the
          // designator. Return immediately.
          if (!SubobjectIsDesignatorContext) {
            return;
          }
          
          // Handle this designated initializer. Field will be updated to
          // the next field that we'll be initializing.
          if (CheckDesignatedInitializer(Entity, IList, DIE, 0, 
              DeclType, $AddrOf(Field), (APSInt /*P*/ )null, Index, 
              StructuredList, StructuredIndex, 
              true, TopLevelObject)) {
            hadError = true;
          }
          
          InitializedSomething = true;
          
          // Disable check for missing fields when designators are used.
          // This matches gcc behaviour.
          CheckForMissingFields = false;
          continue;
        }
      }
      if ($eq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd)) {
        // We've run out of fields. We're done.
        break;
      }
      
      // We've already initialized a member of a union. We're done.
      if (InitializedSomething && DeclType.$arrow().isUnionType()) {
        break;
      }
      
      // If we've hit the flexible array member at the end, we're done.
      if (Field.$arrow().getType().$arrow().isIncompleteArrayType()) {
        break;
      }
      if (Field.$arrow().isUnnamedBitfield()) {
        // Don't initialize unnamed bitfields, e.g. "int : 20;"
        Field.$preInc();
        continue;
      }
      
      // Make sure we can use this declaration.
      boolean InvalidUse;
      if (VerifyOnly) {
        InvalidUse = !SemaRef.CanUseDecl(Field.$star(), TreatUnavailableAsInvalid);
      } else {
        InvalidUse = SemaRef.DiagnoseUseOfDecl(Field.$star(), 
            IList.getInit(Index.$deref()).getLocStart());
      }
      if (InvalidUse) {
        Index.$set$preInc();
        Field.$preInc();
        hadError = true;
        continue;
      }
      
      InitializedEntity MemberEntity = InitializedEntity.InitializeMember(Field.$star(), $AddrOf(Entity));
      CheckSubElementType(MemberEntity, IList, Field.$arrow().getType(), Index, 
          StructuredList, StructuredIndex);
      InitializedSomething = true;
      if (DeclType.$arrow().isUnionType() && !VerifyOnly) {
        // Initialize the first field within the union.
        StructuredList.setInitializedFieldInUnion(Field.$star());
      }
      
      Field.$preInc();
    }
    
    // Emit warnings for missing struct field initializers.
    if (!VerifyOnly && InitializedSomething && CheckForMissingFields
       && $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd) && !Field.$arrow().getType().$arrow().isIncompleteArrayType()
       && !DeclType.$arrow().isUnionType()) {
      // It is possible we have one or more unnamed bitfields remaining.
      // Find first (if any) named field and emit warning.
      for (specific_decl_iterator<FieldDecl> it = new specific_decl_iterator<FieldDecl>(Field), end = RD.field_end();
           $noteq_specific_decl_iterator$SpecificDecl$C(it, end); it.$preInc()) {
        if (!it.$arrow().isUnnamedBitfield() && !it.$arrow().hasInClassInitializer()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IList.getSourceRange().getEnd(), 
                    diag.warn_missing_field_initializers)), it.$star()));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Check that any remaining fields can be value-initialized.
    if (VerifyOnly && $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd) && !DeclType.$arrow().isUnionType()
       && !Field.$arrow().getType().$arrow().isIncompleteArrayType()) {
      // FIXME: Should check for holes left by designated initializers too.
      for (; $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd) && !hadError; Field.$preInc()) {
        if (!Field.$arrow().isUnnamedBitfield() && !Field.$arrow().hasInClassInitializer()) {
          CheckEmptyInitializable(InitializedEntity.InitializeMember(Field.$star(), $AddrOf(Entity)), 
              IList.getLocEnd());
        }
      }
    }
    if ($eq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd) || !Field.$arrow().getType().$arrow().isIncompleteArrayType()
       || $greatereq_uint(Index.$deref(), IList.getNumInits())) {
      return;
    }
    if (CheckFlexibleArrayInit(Entity, IList.getInit(Index.$deref()), Field.$star(), 
        TopLevelObject)) {
      hadError = true;
      Index.$set$preInc();
      return;
    }
    
    InitializedEntity MemberEntity = InitializedEntity.InitializeMember(Field.$star(), $AddrOf(Entity));
    if (isa_InitListExpr(IList.getInit(Index.$deref()))) {
      CheckSubElementType(MemberEntity, IList, Field.$arrow().getType(), Index, 
          StructuredList, StructuredIndex);
    } else {
      CheckImplicitInitList(MemberEntity, IList, Field.$arrow().getType(), Index, 
          StructuredList, StructuredIndex);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1568,
   FQN="(anonymous namespace)::InitListChecker::CheckArrayType", NM="_ZN12_GLOBAL__N_115InitListChecker14CheckArrayTypeERKN5clang17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeEN4llvm6APSIntEbRjS6_SB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker14CheckArrayTypeERKN5clang17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeEN4llvm6APSIntEbRjS6_SB_")
  //</editor-fold>
  private void CheckArrayType(final /*const*/ InitializedEntity /*&*/ Entity, 
                InitListExpr /*P*/ IList, final QualType /*&*/ DeclType, 
                APSInt elementIndex, 
                boolean SubobjectIsDesignatorContext, 
                final uint$ref/*uint &*/ Index, 
                InitListExpr /*P*/ StructuredList, 
                final uint$ref/*uint &*/ StructuredIndex) {
    /*const*/ ArrayType /*P*/ arrayType = SemaRef.Context.getAsArrayType(new QualType(DeclType));
    
    // Check for the special-case of initializing an array with a string.
    if ($less_uint(Index.$deref(), IList.getNumInits())) {
      if (IsStringInit(IList.getInit(Index.$deref()), arrayType, SemaRef.Context)
         == StringInitFailureKind.SIF_None) {
        // We place the string literal directly into the resulting
        // initializer list. This is the only place where the structure
        // of the structured initializer list doesn't match exactly,
        // because doing so would involve allocating one character
        // constant for each string.
        if (!VerifyOnly) {
          CheckStringInit(IList.getInit(Index.$deref()), DeclType, arrayType, SemaRef);
          UpdateStructuredListElement(StructuredList, StructuredIndex, 
              IList.getInit(Index.$deref()));
          StructuredList.resizeInits(SemaRef.Context, StructuredIndex.$deref());
        }
        Index.$set$preInc();
        return;
      }
    }
    {
      /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_VariableArrayType(arrayType);
      if ((VAT != null)) {
        // Check for VLAs; in standard C it would be possible to check this
        // earlier, but I don't know where clang accepts VLAs (gcc accepts
        // them in all sorts of strange places).
        if (!VerifyOnly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VAT.getSizeExpr().getLocStart(), 
                    diag.err_variable_object_no_init)), 
                VAT.getSizeExpr().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        hadError = true;
        Index.$set$preInc();
        StructuredIndex.$set$preInc();
        return;
      }
    }
    
    // We might know the maximum number of elements in advance.
    APSInt maxElements/*J*/= new APSInt(elementIndex.getBitWidth(), 
        elementIndex.isUnsigned());
    boolean maxElementsKnown = false;
    {
      /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(arrayType);
      if ((CAT != null)) {
        maxElements.$assign(new APInt(CAT.getSize()));
        elementIndex.$assignMove(elementIndex.extOrTrunc(maxElements.getBitWidth()));
        elementIndex.setIsUnsigned(maxElements.isUnsigned());
        maxElementsKnown = true;
      }
    }
    
    QualType elementType = arrayType.getElementType();
    while ($less_uint(Index.$deref(), IList.getNumInits())) {
      Expr /*P*/ Init = IList.getInit(Index.$deref());
      {
        DesignatedInitExpr /*P*/ DIE = dyn_cast_DesignatedInitExpr(Init);
        if ((DIE != null)) {
          // If we're not the subobject that matches up with the '{' for
          // the designator, we shouldn't be handling the
          // designator. Return immediately.
          if (!SubobjectIsDesignatorContext) {
            return;
          }
          
          // Handle this designated initializer. elementIndex will be
          // updated to be the next array element we'll initialize.
          if (CheckDesignatedInitializer(Entity, IList, DIE, 0, 
              DeclType, (specific_decl_iterator<FieldDecl> /*P*/ )null, $AddrOf(elementIndex), Index, 
              StructuredList, StructuredIndex, true, 
              false)) {
            hadError = true;
            continue;
          }
          if ($greater_uint(elementIndex.getBitWidth(), maxElements.getBitWidth())) {
            maxElements.$assignMove(maxElements.extend(elementIndex.getBitWidth()));
          } else if ($less_uint(elementIndex.getBitWidth(), maxElements.getBitWidth())) {
            elementIndex.$assignMove(elementIndex.extend(maxElements.getBitWidth()));
          }
          elementIndex.setIsUnsigned(maxElements.isUnsigned());
          
          // If the array is of incomplete type, keep track of the number of
          // elements in the initializer.
          if (!maxElementsKnown && elementIndex.$greater(maxElements)) {
            maxElements.$assign(elementIndex);
          }
          
          continue;
        }
      }
      
      // If we know the maximum number of elements, and we've already
      // hit it, stop consuming elements in the initializer list.
      if (maxElementsKnown && elementIndex.$eq(maxElements)) {
        break;
      }
      
      InitializedEntity ElementEntity = InitializedEntity.InitializeElement(SemaRef.Context, StructuredIndex.$deref(), 
          Entity);
      // Check this element.
      CheckSubElementType(ElementEntity, IList, new QualType(elementType), Index, 
          StructuredList, StructuredIndex);
      elementIndex.$preInc();
      
      // If the array is of incomplete type, keep track of the number of
      // elements in the initializer.
      if (!maxElementsKnown && elementIndex.$greater(maxElements)) {
        maxElements.$assign(elementIndex);
      }
    }
    if (!hadError && DeclType.$arrow().isIncompleteArrayType() && !VerifyOnly) {
      // If this is an incomplete array type, the actual type needs to
      // be calculated here.
      APSInt Zero/*J*/= new APSInt(maxElements.getBitWidth(), maxElements.isUnsigned());
      if (maxElements.$eq(Zero)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Sizing an array implicitly to zero is not allowed by ISO C,
          // but is supported by GNU.
          $c$.clean($c$.track(SemaRef.Diag(IList.getLocStart(), 
              diag.ext_typecheck_zero_array_size)));
        } finally {
          $c$.$destroy();
        }
      }
      
      DeclType.$assignMove(SemaRef.Context.getConstantArrayType(new QualType(elementType), maxElements, 
              ArrayType.ArraySizeModifier.Normal, 0));
    }
    if (!hadError && VerifyOnly) {
      // Check if there are any members of the array that get value-initialized.
      // If so, check if doing that is possible.
      // FIXME: This needs to detect holes left by designated initializers too.
      if (maxElementsKnown && elementIndex.$less(maxElements)) {
        CheckEmptyInitializable(InitializedEntity.InitializeElement(SemaRef.Context, 0, Entity), 
            IList.getLocEnd());
      }
    }
  }

  // end anonymous namespace
  
  /// @brief Check the well-formedness of a C99 designated initializer.
  ///
  /// Determines whether the designated initializer @p DIE, which
  /// resides at the given @p Index within the initializer list @p
  /// IList, is well-formed for a current object of type @p DeclType
  /// (C99 6.7.8). The actual subobject that this designator refers to
  /// within the current subobject is returned in either
  /// @p NextField or @p NextElementIndex (whichever is appropriate).
  ///
  /// @param IList  The initializer list in which this designated
  /// initializer occurs.
  ///
  /// @param DIE The designated initializer expression.
  ///
  /// @param DesigIdx  The index of the current designator.
  ///
  /// @param CurrentObjectType The type of the "current object" (C99 6.7.8p17),
  /// into which the designation in @p DIE should refer.
  ///
  /// @param NextField  If non-NULL and the first designator in @p DIE is
  /// a field, this will be set to the field declaration corresponding
  /// to the field named by the designator.
  ///
  /// @param NextElementIndex  If non-NULL and the first designator in @p
  /// DIE is an array designator or GNU array-range designator, this
  /// will be set to the last index initialized by this designator.
  ///
  /// @param Index  Index into @p IList where the designated initializer
  /// @p DIE occurs.
  ///
  /// @param StructuredList  The initializer list expression that
  /// describes all of the subobject initializers in the order they'll
  /// actually be initialized.
  ///
  /// @returns true if there was an error, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckDesignatedInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2040,
   FQN="(anonymous namespace)::InitListChecker::CheckDesignatedInitializer", NM="_ZN12_GLOBAL__N_115InitListChecker26CheckDesignatedInitializerERKN5clang17InitializedEntityEPNS1_12InitListExprEPNS1_18DesignatedInitExprEjRNS1_8QualTypeEPNS1_11DeclContext22specific_decl_iteratorINS1_9FieldDeclEEEPN4llvm6APSIntERjS6_SJ_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker26CheckDesignatedInitializerERKN5clang17InitializedEntityEPNS1_12InitListExprEPNS1_18DesignatedInitExprEjRNS1_8QualTypeEPNS1_11DeclContext22specific_decl_iteratorINS1_9FieldDeclEEEPN4llvm6APSIntERjS6_SJ_bb")
  //</editor-fold>
  private boolean CheckDesignatedInitializer(final /*const*/ InitializedEntity /*&*/ Entity, 
                            InitListExpr /*P*/ IList, 
                            DesignatedInitExpr /*P*/ DIE, 
                            /*uint*/int DesigIdx, 
                            final QualType /*&*/ CurrentObjectType, 
                            specific_decl_iterator<FieldDecl> /*P*/ NextField, 
                            APSInt /*P*/ NextElementIndex, 
                            final uint$ref/*uint &*/ Index, 
                            InitListExpr /*P*/ StructuredList, 
                            final uint$ref/*uint &*/ StructuredIndex, 
                            boolean FinishSubobjectInit, 
                            boolean TopLevelObject) {
    if (DesigIdx == DIE.size()) {
      // Check the actual initialization for the designated object type.
      boolean prevHadError = hadError;
      
      // Temporarily remove the designator expression from the
      // initializer list that the child calls see, so that we don't try
      // to re-process the designator.
      /*uint*/int OldIndex = Index.$deref();
      IList.setInit(OldIndex, DIE.getInit());
      
      CheckSubElementType(Entity, IList, new QualType(CurrentObjectType), Index, 
          StructuredList, StructuredIndex);
      
      // Restore the designated initializer expression in the syntactic
      // form of the initializer list.
      if (IList.getInit(OldIndex) != DIE.getInit()) {
        DIE.setInit(IList.getInit(OldIndex));
      }
      IList.setInit(OldIndex, DIE);
      
      return hadError && !prevHadError;
    }
    
    DesignatedInitExpr.Designator /*P*/ D = DIE.getDesignator(DesigIdx);
    boolean IsFirstDesignator = (DesigIdx == 0);
    if (!VerifyOnly) {
      assert ((IsFirstDesignator || (StructuredList != null))) : "Need a non-designated initializer list to start from";
      
      // Determine the structural initializer list that corresponds to the
      // current subobject.
      if (IsFirstDesignator) {
        StructuredList = SyntacticToSemantic.lookup(IList);
      } else {
        Expr /*P*/ ExistingInit = $less_uint(StructuredIndex.$deref(), StructuredList.getNumInits()) ? StructuredList.getInit(StructuredIndex.$deref()) : null;
        if (!(ExistingInit != null) && StructuredList.hasArrayFiller()) {
          ExistingInit = StructuredList.getArrayFiller();
        }
        if (!(ExistingInit != null)) {
          StructuredList
             = getStructuredSubobjectInit(IList, Index.$deref(), new QualType(CurrentObjectType), 
              StructuredList, StructuredIndex.$deref(), 
              new SourceRange(D.getLocStart(), 
                  DIE.getLocEnd()));
        } else {
          InitListExpr /*P*/ Result = dyn_cast_InitListExpr(ExistingInit);
          if ((Result != null)) {
            StructuredList = Result;
          } else {
            {
              DesignatedInitUpdateExpr /*P*/ E = dyn_cast_DesignatedInitUpdateExpr(ExistingInit);
              if ((E != null)) {
                StructuredList = E.getUpdater();
              } else {
                final DesignatedInitExpr.Designator /*P*/ L$D = D;
                final Expr /*P*/ L$ExistingInit = ExistingInit;
                final DesignatedInitExpr /*P*/ L$DIE = DIE;
                DesignatedInitUpdateExpr /*P*/ DIUE = /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new DesignatedInitUpdateExpr(SemaRef.Context, 
                    L$D.getLocStart(), L$ExistingInit, 
                    L$DIE.getLocEnd()));
                StructuredList.updateInit(SemaRef.Context, StructuredIndex.$deref(), DIUE);
                StructuredList = DIUE.getUpdater();
              }
            }
            
            // We need to check on source range validity because the previous
            // initializer does not have to be an explicit initializer. e.g.,
            //
            // struct P { int a, b; };
            // struct PP { struct P p } l = { { .a = 2 }, .p.b = 3 };
            //
            // There is an overwrite taking place because the first braced initializer
            // list "{ .a = 2 }" already provides value for .p.b (which is zero).
            if (ExistingInit.getSourceRange().isValid()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // We are creating an initializer list that initializes the
                // subobjects of the current object, but there was already an
                // initialization that completely initialized the current
                // subobject, e.g., by a compound literal:
                //
                // struct X { int a, b; };
                // struct X xs[] = { [0] = (struct X) { 1, 2 }, [0].b = 3 };
                //
                // Here, xs[0].a == 0 and xs[0].b == 3, since the second,
                // designated initializer re-initializes the whole
                // subobject [0], overwriting previous initializers.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocStart(), 
                        diag.warn_subobject_initializer_overrides)), 
                    new SourceRange(D.getLocStart(), DIE.getLocEnd())));
                
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(ExistingInit.getLocStart(), 
                            diag.note_previous_initializer)), 
                        /*FIXME:has side effects=*/ 0), 
                    ExistingInit.getSourceRange()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
      assert ((StructuredList != null)) : "Expected a structured initializer list";
    }
    if (D.isFieldDesignator()) {
      // C99 6.7.8p7:
      //
      //   If a designator has the form
      //
      //      . identifier
      //
      //   then the current object (defined below) shall have
      //   structure or union type and the identifier shall be the
      //   name of a member of that type.
      /*const*/ RecordType /*P*/ RT = CurrentObjectType.$arrow().<RecordType>getAs$RecordType();
      if (!(RT != null)) {
        SourceLocation Loc = D.getDotLoc();
        if (Loc.isInvalid()) {
          Loc.$assignMove(D.getFieldLoc());
        }
        if (!VerifyOnly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_field_designator_non_aggr)), 
                    SemaRef.getLangOpts().CPlusPlus), CurrentObjectType));
          } finally {
            $c$.$destroy();
          }
        }
        Index.$set$preInc();
        return true;
      }
      
      FieldDecl /*P*/ KnownField = D.getField();
      if (!(KnownField != null)) {
        IdentifierInfo /*P*/ FieldName = D.getFieldName();
        DeclContextLookupResult Lookup = RT.getDecl().lookup(new DeclarationName(FieldName));
        for (NamedDecl /*P*/ ND : Lookup) {
          {
            FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ND);
            if ((FD != null)) {
              KnownField = FD;
              break;
            }
          }
          {
            IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(ND);
            if ((IFD != null)) {
              // In verify mode, don't modify the original.
              if (VerifyOnly) {
                DIE = CloneDesignatedInitExpr(SemaRef, DIE);
              }
              ExpandAnonymousFieldDesignator(SemaRef, DIE, DesigIdx, IFD);
              D = DIE.getDesignator(DesigIdx);
              KnownField = cast_FieldDecl(IFD.chain_begin().$star());
              break;
            }
          }
        }
        if (!(KnownField != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (VerifyOnly) {
              Index.$set$preInc();
              return true; // No typo correction when just trying this out.
            }
            
            // Name lookup found something, but it wasn't a field.
            if (!Lookup.empty()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getFieldLoc(), diag.err_field_designator_nonfield)), 
                  FieldName));
              $c$.clean($c$.track(SemaRef.Diag(Lookup.front().getLocation(), 
                  diag.note_field_designator_found)));
              Index.$set$preInc();
              return true;
            }
            {
              TypoCorrection Corrected = null;
              try {
                
                // Name lookup didn't find anything.
                // Determine whether this was a typo for another field name.
                Corrected = $c$.clean(SemaRef.CorrectTypo(new DeclarationNameInfo(new DeclarationName(FieldName), D.getFieldLoc()), 
                    Sema.LookupNameKind.LookupMemberName, /*Scope=*/ (Scope /*P*/ )null, /*SS=*/ (CXXScopeSpec /*P*/ )null, 
                    $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FieldInitializerValidatorCCC(RT.getDecl()))))), 
                    Sema.CorrectTypoKind.CTK_ErrorRecovery, RT.getDecl()));
                if (Corrected.$bool()) {
                  SemaRef.diagnoseTypo(Corrected, 
                      $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track(SemaRef.PDiag(diag.err_field_designator_unknown_suggest)), 
                              FieldName), /*NO_COPY*/CurrentObjectType)); $c$.clean();
                  KnownField = Corrected.getCorrectionDeclAs(FieldDecl.class);
                  hadError = true;
                } else {
                  // Typo correction didn't find anything.
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getFieldLoc(), diag.err_field_designator_unknown)), 
                          FieldName), CurrentObjectType));
                  Index.$set$preInc();
                  return true;
                }
              } finally {
                if (Corrected != null) { Corrected.$destroy(); }
              }
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      uint$ref FieldIndex = create_uint$ref(0);
      for (FieldDecl /*P*/ FI : RT.getDecl().fields()) {
        if (FI.isUnnamedBitfield()) {
          continue;
        }
        if (declaresSameEntity(KnownField, FI)) {
          KnownField = FI;
          break;
        }
        FieldIndex.$set$preInc();
      }
      
      specific_decl_iterator<FieldDecl> Field = new specific_decl_iterator<FieldDecl>(FieldDecl.class, new DeclContext.decl_iterator(KnownField));
      
      // All of the fields of a union are located at the same place in
      // the initializer list.
      if (RT.getDecl().isUnion()) {
        FieldIndex.$set(0);
        if (!VerifyOnly) {
          FieldDecl /*P*/ CurrentField = StructuredList.getInitializedFieldInUnion();
          if ((CurrentField != null) && !declaresSameEntity(CurrentField, Field.$star())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              assert (StructuredList.getNumInits() == 1) : "A union should never have more than one initializer!";
              
              // We're about to throw away an initializer, emit warning.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getFieldLoc(), 
                      diag.warn_initializer_overrides)), 
                  D.getSourceRange()));
              Expr /*P*/ ExistingInit = StructuredList.getInit(0);
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(ExistingInit.getLocStart(), 
                          diag.note_previous_initializer)), 
                      /*FIXME:has side effects=*/ 0), 
                  ExistingInit.getSourceRange()));
              
              // remove existing initializer
              StructuredList.resizeInits(SemaRef.Context, 0);
              StructuredList.setInitializedFieldInUnion((FieldDecl /*P*/ )null);
            } finally {
              $c$.$destroy();
            }
          }
          
          StructuredList.setInitializedFieldInUnion(Field.$star());
        }
      }
      
      // Make sure we can use this declaration.
      boolean InvalidUse;
      if (VerifyOnly) {
        InvalidUse = !SemaRef.CanUseDecl(Field.$star(), TreatUnavailableAsInvalid);
      } else {
        InvalidUse = SemaRef.DiagnoseUseOfDecl(Field.$star(), D.getFieldLoc());
      }
      if (InvalidUse) {
        Index.$set$preInc();
        return true;
      }
      if (!VerifyOnly) {
        // Update the designator with the field declaration.
        D.setField(Field.$star());
        
        // Make sure that our non-designated initializer list has space
        // for a subobject corresponding to this field.
        if ($greatereq_uint(FieldIndex.$deref(), StructuredList.getNumInits())) {
          StructuredList.resizeInits(SemaRef.Context, FieldIndex.$deref() + 1);
        }
      }
      
      // This designator names a flexible array member.
      if (Field.$arrow().getType().$arrow().isIncompleteArrayType()) {
        boolean Invalid = false;
        if ((DesigIdx + 1) != DIE.size()) {
          // We can't designate an object within the flexible array
          // member (because GCC doesn't allow it).
          if (!VerifyOnly) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              DesignatedInitExpr.Designator /*P*/ NextD = DIE.getDesignator(DesigIdx + 1);
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(NextD.getLocStart(), 
                      diag.err_designator_into_flexible_array_member)), 
                  new SourceRange(NextD.getLocStart(), 
                      DIE.getLocEnd())));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Field.$arrow().getLocation(), diag.note_flexible_array_member)), 
                  Field.$star()));
            } finally {
              $c$.$destroy();
            }
          }
          Invalid = true;
        }
        if (!hadError && !isa_InitListExpr(DIE.getInit())
           && !isa_StringLiteral(DIE.getInit())) {
          // The initializer is not an initializer list.
          if (!VerifyOnly) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(DIE.getInit().getLocStart(), 
                      diag.err_flexible_array_init_needs_braces)), 
                  DIE.getInit().getSourceRange()));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Field.$arrow().getLocation(), diag.note_flexible_array_member)), 
                  Field.$star()));
            } finally {
              $c$.$destroy();
            }
          }
          Invalid = true;
        }
        
        // Check GNU flexible array initializer.
        if (!Invalid && CheckFlexibleArrayInit(Entity, DIE.getInit(), Field.$star(), 
            TopLevelObject)) {
          Invalid = true;
        }
        if (Invalid) {
          Index.$set$preInc();
          return true;
        }
        
        // Initialize the array.
        boolean prevHadError = hadError;
        uint$ref newStructuredIndex = create_uint$ref(FieldIndex.$deref());
        /*uint*/int OldIndex = Index.$deref();
        IList.setInit(Index.$deref(), DIE.getInit());
        
        InitializedEntity MemberEntity = InitializedEntity.InitializeMember(Field.$star(), $AddrOf(Entity));
        CheckSubElementType(MemberEntity, IList, Field.$arrow().getType(), Index, 
            StructuredList, newStructuredIndex);
        
        IList.setInit(OldIndex, DIE);
        if (hadError && !prevHadError) {
          Field.$preInc();
          FieldIndex.$set$preInc();
          if ((NextField != null)) {
            /*Deref*/NextField.$assign(Field);
          }
          StructuredIndex.$assign(FieldIndex.$deref());
          return true;
        }
      } else {
        // Recurse to check later designated subobjects.
        QualType FieldType = Field.$arrow().getType();
        uint$ref newStructuredIndex = create_uint$ref(FieldIndex.$deref());
        
        InitializedEntity MemberEntity = InitializedEntity.InitializeMember(Field.$star(), $AddrOf(Entity));
        if (CheckDesignatedInitializer(MemberEntity, IList, DIE, DesigIdx + 1, 
            FieldType, (specific_decl_iterator<FieldDecl> /*P*/ )null, (APSInt /*P*/ )null, Index, 
            StructuredList, newStructuredIndex, 
            FinishSubobjectInit, false)) {
          return true;
        }
      }
      
      // Find the position of the next field to be initialized in this
      // subobject.
      Field.$preInc();
      FieldIndex.$set$preInc();
      
      // If this the first designator, our caller will continue checking
      // the rest of this struct/class/union subobject.
      if (IsFirstDesignator) {
        if ((NextField != null)) {
          /*Deref*/NextField.$assign(Field);
        }
        StructuredIndex.$assign(FieldIndex.$deref());
        return false;
      }
      if (!FinishSubobjectInit) {
        return false;
      }
      
      // We've already initialized something in the union; we're done.
      if (RT.getDecl().isUnion()) {
        return hadError;
      }
      
      // Check the remaining fields within this class/struct/union subobject.
      boolean prevHadError = hadError;
      
      iterator_range<CXXBaseSpecifier> NoBases = new iterator_range<CXXBaseSpecifier>(((type$ptr<CXXBaseSpecifier /*P*/ >)null), 
          ((type$ptr<CXXBaseSpecifier /*P*/ >)null));
      CheckStructUnionTypes(Entity, IList, new QualType(CurrentObjectType), new iterator_range<CXXBaseSpecifier>(NoBases), new specific_decl_iterator<FieldDecl>(Field), 
          false, Index, StructuredList, FieldIndex);
      return hadError && !prevHadError;
    }
    
    // C99 6.7.8p6:
    //
    //   If a designator has the form
    //
    //      [ constant-expression ]
    //
    //   then the current object (defined below) shall have array
    //   type and the expression shall be an integer constant
    //   expression. If the array is of unknown size, any
    //   nonnegative value is valid.
    //
    // Additionally, cope with the GNU extension that permits
    // designators of the form
    //
    //      [ constant-expression ... constant-expression ]
    /*const*/ ArrayType /*P*/ AT = SemaRef.Context.getAsArrayType(new QualType(CurrentObjectType));
    if (!(AT != null)) {
      if (!VerifyOnly) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLBracketLoc(), diag.err_array_designator_non_array)), 
              CurrentObjectType));
        } finally {
          $c$.$destroy();
        }
      }
      Index.$set$preInc();
      return true;
    }
    
    Expr /*P*/ IndexExpr = null;
    APSInt DesignatedStartIndex/*J*/= new APSInt();
    APSInt DesignatedEndIndex/*J*/= new APSInt();
    if (D.isArrayDesignator()) {
      IndexExpr = DIE.getArrayIndex($Deref(D));
      DesignatedStartIndex.$assignMove(IndexExpr.EvaluateKnownConstInt(SemaRef.Context));
      DesignatedEndIndex.$assign(DesignatedStartIndex);
    } else {
      assert (D.isArrayRangeDesignator()) : "Need array-range designator";
      
      DesignatedStartIndex.$assignMove(
          DIE.getArrayRangeStart($Deref(D)).EvaluateKnownConstInt(SemaRef.Context)
      );
      DesignatedEndIndex.$assignMove(
          DIE.getArrayRangeEnd($Deref(D)).EvaluateKnownConstInt(SemaRef.Context)
      );
      IndexExpr = DIE.getArrayRangeEnd($Deref(D));
      
      // Codegen can't handle evaluating array range designators that have side
      // effects, because we replicate the AST value for each initialized element.
      // As such, set the sawArrayRangeDesignator() bit if we initialize multiple
      // elements with something that has a side effect, so codegen can emit an
      // "error unsupported" error instead of miscompiling the app.
      if (DesignatedStartIndex.getZExtValue() != DesignatedEndIndex.getZExtValue()
         && DIE.getInit().HasSideEffects(SemaRef.Context) && !VerifyOnly) {
        FullyStructuredList.sawArrayRangeDesignator();
      }
    }
    if (isa_ConstantArrayType(AT)) {
      APSInt MaxElements/*J*/= new APSInt(new APInt(cast_ConstantArrayType(AT).getSize()), false);
      DesignatedStartIndex.$assignMove(
          DesignatedStartIndex.extOrTrunc(MaxElements.getBitWidth())
      );
      DesignatedStartIndex.setIsUnsigned(MaxElements.isUnsigned());
      DesignatedEndIndex.$assignMove(
          DesignatedEndIndex.extOrTrunc(MaxElements.getBitWidth())
      );
      DesignatedEndIndex.setIsUnsigned(MaxElements.isUnsigned());
      if (DesignatedEndIndex.$greatereq(MaxElements)) {
        if (!VerifyOnly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(IndexExpr.getLocStart(), 
                            diag.err_array_designator_too_large)), 
                        DesignatedEndIndex.__toString(10)), MaxElements.__toString(10)), 
                IndexExpr.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        Index.$set$preInc();
        return true;
      }
    } else {
      /*uint*/int DesignatedIndexBitWidth = ConstantArrayType.getMaxSizeBits(SemaRef.Context);
      DesignatedStartIndex.$assignMove(
          DesignatedStartIndex.extOrTrunc(DesignatedIndexBitWidth)
      );
      DesignatedEndIndex.$assignMove(
          DesignatedEndIndex.extOrTrunc(DesignatedIndexBitWidth)
      );
      DesignatedStartIndex.setIsUnsigned(true);
      DesignatedEndIndex.setIsUnsigned(true);
    }
    if (!VerifyOnly && StructuredList.isStringLiteralInit()) {
      // We're modifying a string literal init; we have to decompose the string
      // so we can modify the individual characters.
      final ASTContext /*&*/ Context = SemaRef.Context;
      Expr /*P*/ SubExpr = StructuredList.getInit(0).IgnoreParens();
      
      // Compute the character type
      QualType CharTy = AT.getElementType();
      
      // Compute the type of the integer literals.
      QualType PromotedCharTy = new QualType(CharTy);
      if (CharTy.$arrow().isPromotableIntegerType()) {
        PromotedCharTy.$assignMove(Context.getPromotedIntegerType(new QualType(CharTy)));
      }
      /*uint*/int PromotedCharTyWidth = $ulong2uint(Context.getTypeSize(new QualType(PromotedCharTy)));
      {
        
        StringLiteral /*P*/ SL = dyn_cast_StringLiteral(SubExpr);
        if ((SL != null)) {
          // Get the length of the string.
          long/*uint64_t*/ StrLen = $uint2ulong(SL.getLength());
          if (cast_ConstantArrayType(AT).getSize().ult(StrLen)) {
            StrLen = cast_ConstantArrayType(AT).getSize().getZExtValue();
          }
          StructuredList.resizeInits(Context, $ulong2uint(StrLen));
          
          // Build a literal for each character in the string, and put them into
          // the init list.
          for (/*uint*/int i = 0, e = $ulong2uint(StrLen); i != e; ++i) {
            APInt CodeUnit/*J*/= new APInt(PromotedCharTyWidth, $uint2ulong(SL.getCodeUnit(i)));
            Expr /*P*/ Init = /*FIXME:NEW_EXPR*//*new (Context)*/ new IntegerLiteral(Context, CodeUnit, new QualType(PromotedCharTy), SubExpr.getExprLoc());
            if ($noteq_QualType$C(CharTy, PromotedCharTy)) {
              Init = ImplicitCastExpr.Create(Context, new QualType(CharTy), CastKind.CK_IntegralCast, 
                  Init, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
            }
            StructuredList.updateInit(Context, i, Init);
          }
        } else {
          ObjCEncodeExpr /*P*/ E = cast_ObjCEncodeExpr(SubExpr);
          std.string Str/*J*/= new std.string();
          Context.getObjCEncodingForType(E.getEncodedType(), Str);
          
          // Get the length of the string.
          long/*uint64_t*/ StrLen = $uint2ulong(Str.size());
          if (cast_ConstantArrayType(AT).getSize().ult(StrLen)) {
            StrLen = cast_ConstantArrayType(AT).getSize().getZExtValue();
          }
          StructuredList.resizeInits(Context, $ulong2uint(StrLen));
          
          // Build a literal for each character in the string, and put them into
          // the init list.
          for (/*uint*/int i = 0, e = $ulong2uint(StrLen); i != e; ++i) {
            APInt CodeUnit/*J*/= new APInt(PromotedCharTyWidth, $char2ulong(Str.$at(i)));
            Expr /*P*/ Init = /*FIXME:NEW_EXPR*//*new (Context)*/ new IntegerLiteral(Context, CodeUnit, new QualType(PromotedCharTy), SubExpr.getExprLoc());
            if ($noteq_QualType$C(CharTy, PromotedCharTy)) {
              Init = ImplicitCastExpr.Create(Context, new QualType(CharTy), CastKind.CK_IntegralCast, 
                  Init, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue);
            }
            StructuredList.updateInit(Context, i, Init);
          }
        }
      }
    }
    
    // Make sure that our non-designated initializer list has space
    // for a subobject corresponding to this array element.
    if (!VerifyOnly
       && $greatereq_ulong_uint(DesignatedEndIndex.getZExtValue(), StructuredList.getNumInits())) {
      StructuredList.resizeInits(SemaRef.Context, 
          $ullong2uint(DesignatedEndIndex.getZExtValue() + 1));
    }
    
    // Repeatedly perform subobject initializations in the range
    // [DesignatedStartIndex, DesignatedEndIndex].
    
    // Move to the next designator
    uint$ref ElementIndex = create_uint$ref($ulong2uint(DesignatedStartIndex.getZExtValue()));
    /*uint*/int OldIndex = Index.$deref();
    
    InitializedEntity ElementEntity = InitializedEntity.InitializeElement(SemaRef.Context, 0, Entity);
    while (DesignatedStartIndex.$lesseq(DesignatedEndIndex)) {
      // Recurse to check later designated subobjects.
      QualType ElementType = AT.getElementType();
      Index.$set(OldIndex);
      
      ElementEntity.setElementIndex(ElementIndex.$deref());
      if (CheckDesignatedInitializer(ElementEntity, IList, DIE, DesigIdx + 1, ElementType, (specific_decl_iterator<FieldDecl> /*P*/ )null, 
          (APSInt /*P*/ )null, Index, StructuredList, ElementIndex, 
          FinishSubobjectInit && (DesignatedStartIndex.$eq(DesignatedEndIndex)), 
          false)) {
        return true;
      }
      
      // Move to the next index in the array that we'll be initializing.
      DesignatedStartIndex.$preInc();
      ElementIndex.$set($ulong2uint(DesignatedStartIndex.getZExtValue()));
    }
    
    // If this the first designator, our caller will continue checking
    // the rest of this array subobject.
    if (IsFirstDesignator) {
      if ((NextElementIndex != null)) {
        /*Deref*/NextElementIndex.$assign(DesignatedStartIndex);
      }
      StructuredIndex.$assign(ElementIndex.$deref());
      return false;
    }
    if (!FinishSubobjectInit) {
      return false;
    }
    
    // Check the remaining elements within this array subobject.
    boolean prevHadError = hadError;
    CheckArrayType(Entity, IList, CurrentObjectType, new APSInt(DesignatedStartIndex), 
        /*SubobjectIsDesignatorContext=*/ false, Index, 
        StructuredList, ElementIndex);
    return hadError && !prevHadError;
  }

  
  // Get the structured initializer list for a subobject of type
  // @p CurrentObjectType.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::getStructuredSubobjectInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2590,
   FQN="(anonymous namespace)::InitListChecker::getStructuredSubobjectInit", NM="_ZN12_GLOBAL__N_115InitListChecker26getStructuredSubobjectInitEPN5clang12InitListExprEjNS1_8QualTypeES3_jNS1_11SourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker26getStructuredSubobjectInitEPN5clang12InitListExprEjNS1_8QualTypeES3_jNS1_11SourceRangeEb")
  //</editor-fold>
  private InitListExpr /*P*/ getStructuredSubobjectInit(InitListExpr /*P*/ IList, /*uint*/int Index, 
                            QualType CurrentObjectType, 
                            InitListExpr /*P*/ StructuredList, 
                            /*uint*/int StructuredIndex, 
                            SourceRange InitRange) {
    return getStructuredSubobjectInit(IList, Index, 
                            CurrentObjectType, 
                            StructuredList, 
                            StructuredIndex, 
                            InitRange, 
                            false);
  }
  private InitListExpr /*P*/ getStructuredSubobjectInit(InitListExpr /*P*/ IList, /*uint*/int Index, 
                            QualType CurrentObjectType, 
                            InitListExpr /*P*/ StructuredList, 
                            /*uint*/int StructuredIndex, 
                            SourceRange InitRange, 
                            boolean IsFullyOverwritten/*= false*/) {
    if (VerifyOnly) {
      return null; // No structured list in verification-only mode.
    }
    Expr /*P*/ ExistingInit = null;
    if (!(StructuredList != null)) {
      ExistingInit = SyntacticToSemantic.lookup(IList);
    } else if ($less_uint(StructuredIndex, StructuredList.getNumInits())) {
      ExistingInit = StructuredList.getInit(StructuredIndex);
    }
    {
      
      InitListExpr /*P*/ Result = dyn_cast_or_null_InitListExpr(ExistingInit);
      if ((Result != null)) {
        // There might have already been initializers for subobjects of the current
        // object, but a subsequent initializer list will overwrite the entirety
        // of the current object. (See DR 253 and C99 6.7.8p21). e.g.,
        //
        // struct P { char x[6]; };
        // struct P l = { .x[2] = 'x', .x = { [0] = 'f' } };
        //
        // The first designated initializer is ignored, and l.x is just "f".
        if (!IsFullyOverwritten) {
          return Result;
        }
      }
    }
    if ((ExistingInit != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We are creating an initializer list that initializes the
        // subobjects of the current object, but there was already an
        // initialization that completely initialized the current
        // subobject, e.g., by a compound literal:
        //
        // struct X { int a, b; };
        // struct X xs[] = { [0] = (struct X) { 1, 2 }, [0].b = 3 };
        //
        // Here, xs[0].a == 0 and xs[0].b == 3, since the second,
        // designated initializer re-initializes the whole
        // subobject [0], overwriting previous initializers.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(InitRange.getBegin(), 
                diag.warn_subobject_initializer_overrides)), 
            InitRange));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(ExistingInit.getLocStart(), 
                    diag.note_previous_initializer)), 
                /*FIXME:has side effects=*/ 0), 
            ExistingInit.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    
    InitListExpr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new InitListExpr(SemaRef.Context, 
        InitRange.getBegin(), new ArrayRef<Expr /*P*/ >(None, true), 
        InitRange.getEnd()));
    
    QualType ResultType = new QualType(CurrentObjectType);
    if (!ResultType.$arrow().isArrayType()) {
      ResultType.$assignMove(ResultType.getNonLValueExprType(SemaRef.Context));
    }
    Result.setType(new QualType(ResultType));
    
    // Pre-allocate storage for the structured initializer list.
    /*uint*/int NumElements = 0;
    /*uint*/int NumInits = 0;
    boolean GotNumInits = false;
    if (!(StructuredList != null)) {
      NumInits = IList.getNumInits();
      GotNumInits = true;
    } else if ($less_uint(Index, IList.getNumInits())) {
      {
        InitListExpr /*P*/ SubList = dyn_cast_InitListExpr(IList.getInit(Index));
        if ((SubList != null)) {
          NumInits = SubList.getNumInits();
          GotNumInits = true;
        }
      }
    }
    {
      
      /*const*/ ArrayType /*P*/ AType = SemaRef.Context.getAsArrayType(new QualType(CurrentObjectType));
      if ((AType != null)) {
        {
          /*const*/ ConstantArrayType /*P*/ CAType = dyn_cast_ConstantArrayType(AType);
          if ((CAType != null)) {
            NumElements = $ulong2uint(CAType.getSize().getZExtValue());
            // Simple heuristic so that we don't allocate a very large
            // initializer with many empty entries at the end.
            if (GotNumInits && $greater_uint(NumElements, NumInits)) {
              NumElements = 0;
            }
          }
        }
      } else {
        /*const*/ VectorType /*P*/ VType = CurrentObjectType.$arrow().getAs(VectorType.class);
        if ((VType != null)) {
          NumElements = VType.getNumElements();
        } else {
          /*const*/ RecordType /*P*/ RType = CurrentObjectType.$arrow().<RecordType>getAs$RecordType();
          if ((RType != null)) {
            RecordDecl /*P*/ RDecl = RType.getDecl();
            if (RDecl.isUnion()) {
              NumElements = 1;
            } else {
              NumElements = std.distance(RDecl.field_begin(), RDecl.field_end());
            }
          }
        }
      }
    }
    
    Result.reserveInits(SemaRef.Context, NumElements);
    
    // Link this new initializer list into the structured initializer
    // lists.
    if ((StructuredList != null)) {
      StructuredList.updateInit(SemaRef.Context, StructuredIndex, Result);
    } else {
      Result.setSyntacticForm(IList);
      SyntacticToSemantic.$set(IList, Result);
    }
    
    return Result;
  }

  
  /// Update the initializer at index @p StructuredIndex within the
  /// structured initializer list to the value @p expr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::UpdateStructuredListElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2697,
   FQN="(anonymous namespace)::InitListChecker::UpdateStructuredListElement", NM="_ZN12_GLOBAL__N_115InitListChecker27UpdateStructuredListElementEPN5clang12InitListExprERjPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker27UpdateStructuredListElementEPN5clang12InitListExprERjPNS1_4ExprE")
  //</editor-fold>
  private void UpdateStructuredListElement(InitListExpr /*P*/ StructuredList, 
                             final uint$ref/*uint &*/ StructuredIndex, 
                             Expr /*P*/ expr) {
    // No structured initializer list to update
    if (!(StructuredList != null)) {
      return;
    }
    {
      
      Expr /*P*/ PrevInit = StructuredList.updateInit(SemaRef.Context, 
          StructuredIndex.$deref(), expr);
      if ((PrevInit != null)) {
        // This initializer overwrites a previous initializer. Warn.
        // We need to check on source range validity because the previous
        // initializer does not have to be an explicit initializer.
        // struct P { int a, b; };
        // struct PP { struct P p } l = { { .a = 2 }, .p.b = 3 };
        // There is an overwrite taking place because the first braced initializer
        // list "{ .a = 2 }' already provides value for .p.b (which is zero).
        if (PrevInit.getSourceRange().isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(expr.getLocStart(), 
                    diag.warn_initializer_overrides)), 
                expr.getSourceRange()));
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(PrevInit.getLocStart(), 
                        diag.note_previous_initializer)), 
                    /*FIXME:has side effects=*/ 0), 
                PrevInit.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    StructuredIndex.$set$preInc();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::numArrayElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 792,
   FQN="(anonymous namespace)::InitListChecker::numArrayElements", NM="_ZN12_GLOBAL__N_115InitListChecker16numArrayElementsEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker16numArrayElementsEN5clang8QualTypeE")
  //</editor-fold>
  private int numArrayElements(QualType DeclType) {
    // FIXME: use a proper constant
    int maxElements = 0x7FFFFFFF;
    {
      /*const*/ ConstantArrayType /*P*/ CAT = SemaRef.Context.getAsConstantArrayType(new QualType(DeclType));
      if ((CAT != null)) {
        maxElements = ((/*static_cast*/int)($ulong2int(CAT.getSize().getZExtValue())));
      }
    }
    return maxElements;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::numStructUnionElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 802,
   FQN="(anonymous namespace)::InitListChecker::numStructUnionElements", NM="_ZN12_GLOBAL__N_115InitListChecker22numStructUnionElementsEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker22numStructUnionElementsEN5clang8QualTypeE")
  //</editor-fold>
  private int numStructUnionElements(QualType DeclType) {
    RecordDecl /*P*/ structDecl = DeclType.$arrow().<RecordType>getAs$RecordType().getDecl();
    int InitializableMembers = 0;
    {
      CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(structDecl);
      if ((CXXRD != null)) {
        InitializableMembers += CXXRD.getNumBases();
      }
    }
    for (/*const*/ FieldDecl /*P*/ Field : structDecl.fields())  {
      if (!Field.isUnnamedBitfield()) {
        ++InitializableMembers;
      }
    }
    if (structDecl.isUnion()) {
      return std.min(InitializableMembers, 1);
    }
    return InitializableMembers - (structDecl.hasFlexibleArrayMember() ? 1 : 0);
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::PerformEmptyInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 376,
   FQN="(anonymous namespace)::InitListChecker::PerformEmptyInit", NM="_ZN12_GLOBAL__N_115InitListChecker16PerformEmptyInitERN5clang4SemaENS1_14SourceLocationERKNS1_17InitializedEntityEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker16PerformEmptyInitERN5clang4SemaENS1_14SourceLocationERKNS1_17InitializedEntityEbb")
  //</editor-fold>
  private static ActionResultTTrue<Expr /*P*/ > PerformEmptyInit(final Sema /*&*/ SemaRef, 
                  SourceLocation Loc, 
                  final /*const*/ InitializedEntity /*&*/ Entity, 
                  boolean VerifyOnly, 
                  boolean TreatUnavailableAsInvalid) {
    InitListExpr DummyInitList = null;
    InitializationSequence InitSeq = null;
    try {
      InitializationKind Kind = InitializationKind.CreateValue(new SourceLocation(Loc), new SourceLocation(Loc), new SourceLocation(Loc), 
          true);
      MutableArrayRef<Expr /*P*/ > SubInit/*J*/= new MutableArrayRef<Expr /*P*/ >(true);
      Expr /*P*/ InitExpr;
      DummyInitList/*J*/= new InitListExpr(SemaRef.Context, new SourceLocation(Loc), new ArrayRef<Expr /*P*/ >(None, true), new SourceLocation(Loc));
      
      // C++ [dcl.init.aggr]p7:
      //   If there are fewer initializer-clauses in the list than there are
      //   members in the aggregate, then each member not explicitly initialized
      //   ...
      boolean EmptyInitList = SemaRef.getLangOpts().CPlusPlus11
         && Entity.getType().$arrow().getBaseElementTypeUnsafe().isRecordType();
      if (EmptyInitList) {
        // C++1y / DR1070:
        //   shall be initialized [...] from an empty initializer list.
        //
        // We apply the resolution of this DR to C++11 but not C++98, since C++98
        // does not have useful semantics for initialization from an init list.
        // We treat this as copy-initialization, because aggregate initialization
        // always performs copy-initialization on its elements.
        //
        // Only do this if we're initializing a class type, to avoid filling in
        // the initializer list where possible.
        InitExpr = VerifyOnly ? $AddrOf(DummyInitList) : /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new InitListExpr(SemaRef.Context, new SourceLocation(Loc), new ArrayRef<Expr /*P*/ >(None, true), new SourceLocation(Loc)));
        InitExpr.setType(SemaRef.Context.VoidTy.$QualType());
        SubInit.$assignMove(new MutableArrayRef<Expr /*P*/ >(InitExpr, true));
        Kind.$assignMove(InitializationKind.CreateCopy(new SourceLocation(Loc), new SourceLocation(Loc)));
      } else {
        // C++03:
        //   shall be value-initialized.
      }
      
      InitSeq/*J*/= new InitializationSequence(SemaRef, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(SubInit));
      // libstdc++4.6 marks the vector default constructor as explicit in
      // _GLIBCXX_DEBUG mode, so recover using the C++03 logic in that case.
      // stlport does so too. Look for std::__debug for libstdc++, and for
      // std:: for stlport.  This is effectively a compiler-side implementation of
      // LWG2193.
      if (!InitSeq.$bool() && EmptyInitList && InitSeq.getFailureKind()
         == InitializationSequence.FailureKind.FK_ExplicitConstructor) {
        type$ptr<OverloadCandidate> Best = create_type$ptr();
        OverloadingResult O = InitSeq.getFailedCandidateSet().
            BestViableFunction(SemaRef, Kind.getLocation(), Best);
        ///*J:(void)*/O;
        assert (O == OverloadingResult.OR_Success) : "Inconsistent overload resolution";
        CXXConstructorDecl /*P*/ CtorDecl = cast_CXXConstructorDecl(Best./*->*/$star().Function);
        CXXRecordDecl /*P*/ R = CtorDecl.getParent();
        if (CtorDecl.getMinRequiredArguments() == 0
           && CtorDecl.isExplicit() && R.getDeclName().$bool()
           && SemaRef.SourceMgr.isInSystemHeader(CtorDecl.getLocation())) {
          boolean IsInStd = false;
          for (NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(R.getDeclContext());
               (ND != null) && !IsInStd; ND = dyn_cast_NamespaceDecl(ND.getParent())) {
            if (SemaRef.getStdNamespace().InEnclosingNamespaceSetOf(ND)) {
              IsInStd = true;
            }
          }
          if (IsInStd && new StringSwitchBool(R.getName()).
              Cases(/*KEEP_STR*/"basic_string", /*KEEP_STR*/"deque", /*KEEP_STR*/"forward_list", true).
              Cases(/*KEEP_STR*/"list", /*KEEP_STR*/"map", /*KEEP_STR*/"multimap", /*KEEP_STR*/"multiset", true).
              Cases(/*KEEP_STR*/"priority_queue", /*KEEP_STR*/"queue", /*KEEP_STR*/"set", /*KEEP_STR*/"stack", true).
              Cases(/*KEEP_STR*/"unordered_map", /*KEEP_STR*/"unordered_set", /*KEEP_STR*/"vector", true).
              Default(false)) {
            InitSeq.InitializeFrom(SemaRef, Entity, 
                InitializationKind.CreateValue(new SourceLocation(Loc), new SourceLocation(Loc), new SourceLocation(Loc), true), 
                new MutableArrayRef<Expr /*P*/ >(true), /*TopLevelOfInitList=*/ false, 
                TreatUnavailableAsInvalid);
            // Emit a warning for this.  System header warnings aren't shown
            // by default, but people working on system headers should see it.
            if (!VerifyOnly) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(SemaRef.Diag(CtorDecl.getLocation(), 
                    diag.warn_invalid_initializer_from_system_header)));
                if (Entity.getKind() == InitializedEntity.EntityKind.EK_Member) {
                  $c$.clean($c$.track(SemaRef.Diag(Entity.getDecl().getLocation(), 
                      diag.note_used_in_initialization_here)));
                } else if (Entity.getKind() == InitializedEntity.EntityKind.EK_ArrayElement) {
                  $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.note_used_in_initialization_here)));
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
      if (!InitSeq.$bool()) {
        if (!VerifyOnly) {
          InitSeq.Diagnose(SemaRef, Entity, Kind, new ArrayRef<Expr /*P*/ >(SubInit));
          if (Entity.getKind() == InitializedEntity.EntityKind.EK_Member) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Entity.getDecl().getLocation(), 
                          diag.note_in_omitted_aggregate_initializer)), 
                      /*field*/ 1), Entity.getDecl()));
            } finally {
              $c$.$destroy();
            }
          } else if (Entity.getKind() == InitializedEntity.EntityKind.EK_ArrayElement) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.note_in_omitted_aggregate_initializer)), 
                      /*array element*/ 0), Entity.getElementIndex()));
            } finally {
              $c$.$destroy();
            }
          }
        }
        return ExprError();
      }
      
      return VerifyOnly ? new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ((/*static_cast*/Expr /*P*/ )((Expr /*P*/ )null))) : InitSeq.Perform(SemaRef, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(SubInit));
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
      if (DummyInitList != null) { DummyInitList.$destroy(); }
    }
  }

  
  // Explanation on the "FillWithNoInit" mode:
  //
  // Assume we have the following definitions (Case#1):
  // struct P { char x[6][6]; } xp = { .x[1] = "bar" };
  // struct PP { struct P lp; } l = { .lp = xp, .lp.x[1][2] = 'f' };
  //
  // l.lp.x[1][0..1] should not be filled with implicit initializers because the
  // "base" initializer "xp" will provide values for them; l.lp.x[1] will be "baf".
  //
  // But if we have (Case#2):
  // struct PP l = { .lp = xp, .lp.x[1] = { [2] = 'f' } };
  //
  // l.lp.x[1][0..1] are implicitly initialized and do not use values from the
  // "base" initializer; l.lp.x[1] will be "\0\0f\0\0\0".
  //
  // To distinguish Case#1 from Case#2, and also to avoid leaving many "holes"
  // in the InitListExpr, the "holes" in Case#1 are filled not with empty
  // initializers but with special "NoInitExpr" place holders, which tells the
  // CodeGen not to generate any initializers for these parts.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::FillInEmptyInitForBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 493,
   FQN="(anonymous namespace)::InitListChecker::FillInEmptyInitForBase", NM="_ZN12_GLOBAL__N_115InitListChecker22FillInEmptyInitForBaseEjRKN5clang16CXXBaseSpecifierERKNS1_17InitializedEntityEPNS1_12InitListExprERbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker22FillInEmptyInitForBaseEjRKN5clang16CXXBaseSpecifierERKNS1_17InitializedEntityEPNS1_12InitListExprERbb")
  //</editor-fold>
  private void FillInEmptyInitForBase(/*uint*/int Init, final /*const*/ CXXBaseSpecifier /*&*/ Base, 
                        final /*const*/ InitializedEntity /*&*/ ParentEntity, InitListExpr /*P*/ ILE, 
                        final bool$ref/*bool &*/ RequiresSecondPass, boolean FillWithNoInit) {
    assert ($less_uint(Init, ILE.getNumInits())) : "should have been expanded";
    
    InitializedEntity BaseEntity = InitializedEntity.InitializeBase(SemaRef.Context, $AddrOf(Base), false, $AddrOf(ParentEntity));
    if (!(ILE.getInit(Init) != null)) {
      ActionResultTTrue<Expr /*P*/ > BaseInit = FillWithNoInit ? new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new NoInitExpr(Base.getType()))) : PerformEmptyInit(SemaRef, ILE.getLocEnd(), BaseEntity, 
          /*VerifyOnly*/ false, 
          TreatUnavailableAsInvalid);
      if (BaseInit.isInvalid()) {
        hadError = true;
        return;
      }
      
      ILE.setInit(Init, BaseInit.getAs(Expr.class));
    } else {
      InitListExpr /*P*/ InnerILE = dyn_cast_InitListExpr(ILE.getInit(Init));
      if ((InnerILE != null)) {
        FillInEmptyInitializations(BaseEntity, InnerILE, 
            RequiresSecondPass, FillWithNoInit);
      } else {
        DesignatedInitUpdateExpr /*P*/ InnerDIUE = dyn_cast_DesignatedInitUpdateExpr(ILE.getInit(Init));
        if ((InnerDIUE != null)) {
          FillInEmptyInitializations(BaseEntity, InnerDIUE.getUpdater(), 
              RequiresSecondPass, /*FillWithNoInit =*/ true);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::FillInEmptyInitForField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 525,
   FQN="(anonymous namespace)::InitListChecker::FillInEmptyInitForField", NM="_ZN12_GLOBAL__N_115InitListChecker23FillInEmptyInitForFieldEjPN5clang9FieldDeclERKNS1_17InitializedEntityEPNS1_12InitListExprERbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker23FillInEmptyInitForFieldEjPN5clang9FieldDeclERKNS1_17InitializedEntityEPNS1_12InitListExprERbb")
  //</editor-fold>
  private void FillInEmptyInitForField(/*uint*/int Init, FieldDecl /*P*/ Field, 
                         final /*const*/ InitializedEntity /*&*/ ParentEntity, 
                         InitListExpr /*P*/ ILE, 
                         final bool$ref/*bool &*/ RequiresSecondPass) {
    FillInEmptyInitForField(Init, Field, 
                         ParentEntity, 
                         ILE, 
                         RequiresSecondPass, 
                         false);
  }
  private void FillInEmptyInitForField(/*uint*/int Init, FieldDecl /*P*/ Field, 
                         final /*const*/ InitializedEntity /*&*/ ParentEntity, 
                         InitListExpr /*P*/ ILE, 
                         final bool$ref/*bool &*/ RequiresSecondPass, 
                         boolean FillWithNoInit/*= false*/) {
    SourceLocation Loc = ILE.getLocEnd();
    /*uint*/int NumInits = ILE.getNumInits();
    InitializedEntity MemberEntity = InitializedEntity.InitializeMember(Field, $AddrOf(ParentEntity));
    {
      
      /*const*/ RecordType /*P*/ RType = ILE.getType().$arrow().<RecordType>getAs$RecordType();
      if ((RType != null)) {
        if (!RType.getDecl().isUnion()) {
          assert ($less_uint(Init, NumInits)) : "This ILE should have been expanded";
        }
      }
    }
    if ($greatereq_uint(Init, NumInits) || !(ILE.getInit(Init) != null)) {
      if (FillWithNoInit) {
        Expr /*P*/ Filler = /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new NoInitExpr(Field.getType()));
        if ($less_uint(Init, NumInits)) {
          ILE.setInit(Init, Filler);
        } else {
          ILE.updateInit(SemaRef.Context, Init, Filler);
        }
        return;
      }
      // C++1y [dcl.init.aggr]p7:
      //   If there are fewer initializer-clauses in the list than there are
      //   members in the aggregate, then each member not explicitly initialized
      //   shall be initialized from its brace-or-equal-initializer [...]
      if (Field.hasInClassInitializer()) {
        ActionResultTTrue<Expr /*P*/ > DIE = SemaRef.BuildCXXDefaultInitExpr(new SourceLocation(Loc), Field);
        if (DIE.isInvalid()) {
          hadError = true;
          return;
        }
        if ($less_uint(Init, NumInits)) {
          ILE.setInit(Init, DIE.get());
        } else {
          ILE.updateInit(SemaRef.Context, Init, DIE.get());
          RequiresSecondPass.$set(true);
        }
        return;
      }
      if (Field.getType().$arrow().isReferenceType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [dcl.init.aggr]p9:
          //   If an incomplete or empty initializer-list leaves a
          //   member of reference type uninitialized, the program is
          //   ill-formed.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_init_reference_member_uninitialized)), 
                  Field.getType()), 
              ILE.getSyntacticForm().getSourceRange()));
          $c$.clean($c$.track(SemaRef.Diag(Field.getLocation(), 
              diag.note_uninit_reference_member)));
          hadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > MemberInit = PerformEmptyInit(SemaRef, new SourceLocation(Loc), MemberEntity, 
          /*VerifyOnly*/ false, 
          TreatUnavailableAsInvalid);
      if (MemberInit.isInvalid()) {
        hadError = true;
        return;
      }
      if (hadError) {
        // Do nothing
      } else if ($less_uint(Init, NumInits)) {
        ILE.setInit(Init, MemberInit.getAs(Expr.class));
      } else if (!isa_ImplicitValueInitExpr(MemberInit.get())) {
        // Empty initialization requires a constructor call, so
        // extend the initializer list to include the constructor
        // call and make a note that we'll need to take another pass
        // through the initializer list.
        ILE.updateInit(SemaRef.Context, Init, MemberInit.getAs(Expr.class));
        RequiresSecondPass.$set(true);
      }
    } else {
      InitListExpr /*P*/ InnerILE = dyn_cast_InitListExpr(ILE.getInit(Init));
      if ((InnerILE != null)) {
        FillInEmptyInitializations(MemberEntity, InnerILE, 
            RequiresSecondPass, FillWithNoInit);
      } else {
        DesignatedInitUpdateExpr /*P*/ InnerDIUE = dyn_cast_DesignatedInitUpdateExpr(ILE.getInit(Init));
        if ((InnerDIUE != null)) {
          FillInEmptyInitializations(MemberEntity, InnerDIUE.getUpdater(), 
              RequiresSecondPass, /*FillWithNoInit =*/ true);
        }
      }
    }
  }

  
  /// Recursively replaces NULL values within the given initializer list
  /// with expressions that perform value-initialization of the
  /// appropriate type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::FillInEmptyInitializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 614,
   FQN="(anonymous namespace)::InitListChecker::FillInEmptyInitializations", NM="_ZN12_GLOBAL__N_115InitListChecker26FillInEmptyInitializationsERKN5clang17InitializedEntityEPNS1_12InitListExprERbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker26FillInEmptyInitializationsERKN5clang17InitializedEntityEPNS1_12InitListExprERbb")
  //</editor-fold>
  private void FillInEmptyInitializations(final /*const*/ InitializedEntity /*&*/ Entity, 
                            InitListExpr /*P*/ ILE, 
                            final bool$ref/*bool &*/ RequiresSecondPass) {
    FillInEmptyInitializations(Entity, 
                            ILE, 
                            RequiresSecondPass, 
                            false);
  }
  private void FillInEmptyInitializations(final /*const*/ InitializedEntity /*&*/ Entity, 
                            InitListExpr /*P*/ ILE, 
                            final bool$ref/*bool &*/ RequiresSecondPass, 
                            boolean FillWithNoInit/*= false*/) {
    assert (($noteq_QualType$C(ILE.getType(), SemaRef.Context.VoidTy.$QualType()))) : "Should not have void type";
    {
      
      /*const*/ RecordType /*P*/ RType = ILE.getType().$arrow().<RecordType>getAs$RecordType();
      if ((RType != null)) {
        /*const*/ RecordDecl /*P*/ RDecl = RType.getDecl();
        if (RDecl.isUnion() && (ILE.getInitializedFieldInUnion() != null)) {
          FillInEmptyInitForField(0, ILE.getInitializedFieldInUnion(), 
              Entity, ILE, RequiresSecondPass, FillWithNoInit);
        } else if (RDecl.isUnion() && isa_CXXRecordDecl(RDecl)
           && cast_CXXRecordDecl(RDecl).hasInClassInitializer()) {
          for (FieldDecl /*P*/ Field : RDecl.fields()) {
            if (Field.hasInClassInitializer()) {
              FillInEmptyInitForField(0, Field, Entity, ILE, RequiresSecondPass, 
                  FillWithNoInit);
              break;
            }
          }
        } else {
          // The fields beyond ILE->getNumInits() are default initialized, so in
          // order to leave them uninitialized, the ILE is expanded and the extra
          // fields are then filled with NoInitExpr.
          /*uint*/int NumElems = numStructUnionElements(ILE.getType());
          if (RDecl.hasFlexibleArrayMember()) {
            ++NumElems;
          }
          if ($less_uint(ILE.getNumInits(), NumElems)) {
            ILE.resizeInits(SemaRef.Context, NumElems);
          }
          
          /*uint*/int Init = 0;
          {
            
            /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RDecl);
            if ((CXXRD != null)) {
              for (final /*const*/ CXXBaseSpecifier /*&*/ Base : CXXRD.bases$Const()) {
                if (hadError) {
                  return;
                }
                
                FillInEmptyInitForBase(Init, Base, Entity, ILE, RequiresSecondPass, 
                    FillWithNoInit);
                ++Init;
              }
            }
          }
          
          for (FieldDecl /*P*/ Field : RDecl.fields()) {
            if (Field.isUnnamedBitfield()) {
              continue;
            }
            if (hadError) {
              return;
            }
            
            FillInEmptyInitForField(Init, Field, Entity, ILE, RequiresSecondPass, 
                FillWithNoInit);
            if (hadError) {
              return;
            }
            
            ++Init;
            
            // Only look at the first initialization of a union.
            if (RDecl.isUnion()) {
              break;
            }
          }
        }
        
        return;
      }
    }
    
    QualType ElementType/*J*/= new QualType();
    
    InitializedEntity ElementEntity = new InitializedEntity(Entity);
    /*uint*/int NumInits = ILE.getNumInits();
    /*uint*/int NumElements = NumInits;
    {
      /*const*/ ArrayType /*P*/ AType = SemaRef.Context.getAsArrayType(ILE.getType());
      if ((AType != null)) {
        ElementType.$assignMove(AType.getElementType());
        {
          /*const*/ ConstantArrayType /*P*/ CAType = dyn_cast_ConstantArrayType(AType);
          if ((CAType != null)) {
            NumElements = $ulong2uint(CAType.getSize().getZExtValue());
          }
        }
        ElementEntity.$assignMove(InitializedEntity.InitializeElement(SemaRef.Context, 
                0, Entity));
      } else {
        /*const*/ VectorType /*P*/ VType = ILE.getType().$arrow().getAs(VectorType.class);
        if ((VType != null)) {
          ElementType.$assignMove(VType.getElementType());
          NumElements = VType.getNumElements();
          ElementEntity.$assignMove(InitializedEntity.InitializeElement(SemaRef.Context, 
                  0, Entity));
        } else {
          ElementType.$assignMove(ILE.getType());
        }
      }
    }
    
    for (/*uint*/int Init = 0; Init != NumElements; ++Init) {
      if (hadError) {
        return;
      }
      if (ElementEntity.getKind() == InitializedEntity.EntityKind.EK_ArrayElement
         || ElementEntity.getKind() == InitializedEntity.EntityKind.EK_VectorElement) {
        ElementEntity.setElementIndex(Init);
      }
      
      Expr /*P*/ InitExpr = ($less_uint(Init, NumInits) ? ILE.getInit(Init) : null);
      if (!(InitExpr != null) && $less_uint(Init, NumInits) && ILE.hasArrayFiller()) {
        ILE.setInit(Init, ILE.getArrayFiller());
      } else if (!(InitExpr != null) && !ILE.hasArrayFiller()) {
        Expr /*P*/ Filler = null;
        if (FillWithNoInit) {
          Filler = /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->new NoInitExpr(new QualType(ElementType)));
        } else {
          ActionResultTTrue<Expr /*P*/ > ElementInit = PerformEmptyInit(SemaRef, ILE.getLocEnd(), 
              ElementEntity, 
              /*VerifyOnly*/ false, 
              TreatUnavailableAsInvalid);
          if (ElementInit.isInvalid()) {
            hadError = true;
            return;
          }
          
          Filler = ElementInit.getAs(Expr.class);
        }
        if (hadError) {
          // Do nothing
        } else if ($less_uint(Init, NumInits)) {
          // For arrays, just set the expression used for value-initialization
          // of the "holes" in the array.
          if (ElementEntity.getKind() == InitializedEntity.EntityKind.EK_ArrayElement) {
            ILE.setArrayFiller(Filler);
          } else {
            ILE.setInit(Init, Filler);
          }
        } else {
          // For arrays, just set the expression used for value-initialization
          // of the rest of elements and exit.
          if (ElementEntity.getKind() == InitializedEntity.EntityKind.EK_ArrayElement) {
            ILE.setArrayFiller(Filler);
            return;
          }
          if (!isa_ImplicitValueInitExpr(Filler) && !isa_NoInitExpr(Filler)) {
            // Empty initialization requires a constructor call, so
            // extend the initializer list to include the constructor
            // call and make a note that we'll need to take another pass
            // through the initializer list.
            ILE.updateInit(SemaRef.Context, Init, Filler);
            RequiresSecondPass.$set(true);
          }
        }
      } else {
        InitListExpr /*P*/ InnerILE = dyn_cast_or_null_InitListExpr(InitExpr);
        if ((InnerILE != null)) {
          FillInEmptyInitializations(ElementEntity, InnerILE, RequiresSecondPass, 
              FillWithNoInit);
        } else {
          DesignatedInitUpdateExpr /*P*/ InnerDIUE = dyn_cast_or_null_DesignatedInitUpdateExpr(InitExpr);
          if ((InnerDIUE != null)) {
            FillInEmptyInitializations(ElementEntity, InnerDIUE.getUpdater(), 
                RequiresSecondPass, /*FillWithNoInit =*/ true);
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckFlexibleArrayInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1698,
   FQN="(anonymous namespace)::InitListChecker::CheckFlexibleArrayInit", NM="_ZN12_GLOBAL__N_115InitListChecker22CheckFlexibleArrayInitERKN5clang17InitializedEntityEPNS1_4ExprEPNS1_9FieldDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker22CheckFlexibleArrayInitERKN5clang17InitializedEntityEPNS1_4ExprEPNS1_9FieldDeclEb")
  //</editor-fold>
  private boolean CheckFlexibleArrayInit(final /*const*/ InitializedEntity /*&*/ Entity, 
                        Expr /*P*/ InitExpr, 
                        FieldDecl /*P*/ Field, 
                        boolean TopLevelObject) {
    // Handle GNU flexible array initializers.
    /*uint*/int FlexArrayDiag;
    if (isa_InitListExpr(InitExpr)
       && cast_InitListExpr(InitExpr).getNumInits() == 0) {
      // Empty flexible array init always allowed as an extension
      FlexArrayDiag = diag.ext_flexible_array_init;
    } else if (SemaRef.getLangOpts().CPlusPlus) {
      // Disallow flexible array init in C++; it is not required for gcc
      // compatibility, and it needs work to IRGen correctly in general.
      FlexArrayDiag = diag.err_flexible_array_init;
    } else if (!TopLevelObject) {
      // Disallow flexible array init on non-top-level object
      FlexArrayDiag = diag.err_flexible_array_init;
    } else if (Entity.getKind() != InitializedEntity.EntityKind.EK_Variable) {
      // Disallow flexible array init on anything which is not a variable.
      FlexArrayDiag = diag.err_flexible_array_init;
    } else if (cast_VarDecl(Entity.getDecl()).hasLocalStorage()) {
      // Disallow flexible array init on local variables.
      FlexArrayDiag = diag.err_flexible_array_init;
    } else {
      // Allow other cases.
      FlexArrayDiag = diag.ext_flexible_array_init;
    }
    if (!VerifyOnly) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(InitExpr.getLocStart(), 
                FlexArrayDiag)), 
            InitExpr.getLocStart()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Field.getLocation(), diag.note_flexible_array_member)), 
            Field));
      } finally {
        $c$.$destroy();
      }
    }
    
    return FlexArrayDiag != diag.ext_flexible_array_init;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::CheckEmptyInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 484,
   FQN="(anonymous namespace)::InitListChecker::CheckEmptyInitializable", NM="_ZN12_GLOBAL__N_115InitListChecker23CheckEmptyInitializableERKN5clang17InitializedEntityENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker23CheckEmptyInitializableERKN5clang17InitializedEntityENS1_14SourceLocationE")
  //</editor-fold>
  private void CheckEmptyInitializable(final /*const*/ InitializedEntity /*&*/ Entity, 
                         SourceLocation Loc) {
    assert (VerifyOnly) : "CheckEmptyInitializable is only inteded for verification mode.";
    if (PerformEmptyInit(SemaRef, new SourceLocation(Loc), Entity, /*VerifyOnly*/ true, 
        TreatUnavailableAsInvalid).isInvalid()) {
      hadError = true;
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::InitListChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 767,
   FQN="(anonymous namespace)::InitListChecker::InitListChecker", NM="_ZN12_GLOBAL__N_115InitListCheckerC1ERN5clang4SemaERKNS1_17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListCheckerC1ERN5clang4SemaERKNS1_17InitializedEntityEPNS1_12InitListExprERNS1_8QualTypeEbb")
  //</editor-fold>
  public InitListChecker(final Sema /*&*/ S, final /*const*/ InitializedEntity /*&*/ Entity, 
      InitListExpr /*P*/ IL, final QualType /*&*/ T, 
      boolean VerifyOnly, 
      boolean TreatUnavailableAsInvalid) {
    // : SemaRef(S), VerifyOnly(VerifyOnly), TreatUnavailableAsInvalid(TreatUnavailableAsInvalid), SyntacticToSemantic() 
    //START JInit
    this./*&*/SemaRef=/*&*/S;
    this.VerifyOnly = VerifyOnly;
    this.TreatUnavailableAsInvalid = TreatUnavailableAsInvalid;
    this.SyntacticToSemantic = new DenseMap<InitListExpr /*P*/ , InitListExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (InitListExpr /*P*/ )null);
    //END JInit
    // FIXME: Check that IL isn't already the semantic form of some other
    // InitListExpr. If it is, we'd create a broken AST.
    hadError = false;
    
    FullyStructuredList
       = getStructuredSubobjectInit(IL, 0, new QualType(T), (InitListExpr /*P*/ )null, 0, IL.getSourceRange());
    CheckExplicitInitList(Entity, IL, T, FullyStructuredList, 
        /*TopLevelObject=*/ true);
    if (!hadError && !VerifyOnly) {
      bool$ref RequiresSecondPass = create_bool$ref(false);
      FillInEmptyInitializations(Entity, FullyStructuredList, RequiresSecondPass);
      if (RequiresSecondPass.$deref() && !hadError) {
        FillInEmptyInitializations(Entity, FullyStructuredList, 
            RequiresSecondPass);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::HadError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 367,
   FQN="(anonymous namespace)::InitListChecker::HadError", NM="_ZN12_GLOBAL__N_115InitListChecker8HadErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListChecker8HadErrorEv")
  //</editor-fold>
  public boolean HadError() {
    return hadError;
  }

  
  // @brief Retrieves the fully-structured initializer list used for
  // semantic analysis and code generation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::getFullyStructuredList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 371,
   FQN="(anonymous namespace)::InitListChecker::getFullyStructuredList", NM="_ZNK12_GLOBAL__N_115InitListChecker22getFullyStructuredListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK12_GLOBAL__N_115InitListChecker22getFullyStructuredListEv")
  //</editor-fold>
  public InitListExpr /*P*/ getFullyStructuredList() /*const*/ {
    return FullyStructuredList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitListChecker::~InitListChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 237,
   FQN="(anonymous namespace)::InitListChecker::~InitListChecker", NM="_ZN12_GLOBAL__N_115InitListCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_115InitListCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SyntacticToSemantic.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", hadError=" + hadError // NOI18N
              + ", VerifyOnly=" + VerifyOnly // NOI18N
              + ", TreatUnavailableAsInvalid=" + TreatUnavailableAsInvalid // NOI18N
              + ", SyntacticToSemantic=" + SyntacticToSemantic // NOI18N
              + ", FullyStructuredList=" + FullyStructuredList; // NOI18N
  }
}
