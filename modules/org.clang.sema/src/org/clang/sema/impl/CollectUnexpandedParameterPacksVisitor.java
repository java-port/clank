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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// \brief A class that collects unexpanded parameter packs.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 31,
 FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitorE")
//</editor-fold>
public class CollectUnexpandedParameterPacksVisitor implements /*public*/ RecursiveASTVisitor<CollectUnexpandedParameterPacksVisitor> {
  /*typedef RecursiveASTVisitor<CollectUnexpandedParameterPacksVisitor> inherited*/
//  public final class inherited extends RecursiveASTVisitor<CollectUnexpandedParameterPacksVisitor>{ };
  
  private final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded;
  
  private boolean InLambda;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::CollectUnexpandedParameterPacksVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 42,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::CollectUnexpandedParameterPacksVisitor", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitorC1ERN4llvm15SmallVectorImplISt4pairINS1_12PointerUnionIPKN5clang20TemplateTypeParmTypeEPNS5_9NamedDeclEEENS5_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitorC1ERN4llvm15SmallVectorImplISt4pairINS1_12PointerUnionIPKN5clang20TemplateTypeParmTypeEPNS5_9NamedDeclEEENS5_14SourceLocationEEEE")
  //</editor-fold>
  public /*explicit*/ CollectUnexpandedParameterPacksVisitor(final SmallVectorImpl<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> > /*&*/ Unexpanded) {
    // : RecursiveASTVisitor<CollectUnexpandedParameterPacksVisitor>(), Unexpanded(Unexpanded), InLambda(false) 
    //START JInit
    $RecursiveASTVisitor();
    this./*&*/Unexpanded=/*&*/Unexpanded;
    this.InLambda = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::shouldWalkTypesOfTypeLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 46,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::shouldWalkTypesOfTypeLocs", NM="_ZNK12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor25shouldWalkTypesOfTypeLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZNK12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor25shouldWalkTypesOfTypeLocsEv")
  //</editor-fold>
  public boolean shouldWalkTypesOfTypeLocs() /*const*/ {
    return false;
  }

  
  //------------------------------------------------------------------------
  // Recording occurrences of (unexpanded) parameter packs.
  //------------------------------------------------------------------------
  
  /// \brief Record occurrences of template type parameter packs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*//*PointerUnion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 53,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public boolean VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TL) {
    if (TL.getTypePtr().isParameterPack()) {
      Unexpanded.push_back(std.make_pair_Ptr2T_T(new PointerUnion<>(JD$T.INSTANCE, TemplateTypeParmType.class, TL.getTypePtr()), TL.getNameLoc()));
    }
    return true;
  }

  
  /// \brief Record occurrences of template type parameter packs
  /// when we don't have proper source-location information for
  /// them.
  ///
  /// Ideally, this routine would never be used.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*//*PointerUnion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 64,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::VisitTemplateTypeParmType", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor25VisitTemplateTypeParmTypeEPN5clang20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor25VisitTemplateTypeParmTypeEPN5clang20TemplateTypeParmTypeE")
  //</editor-fold>
  public boolean VisitTemplateTypeParmType(TemplateTypeParmType /*P*/ T) {
    if (T.isParameterPack()) {
      Unexpanded.push_back(std.make_pair_Ptr2T_T(new PointerUnion<>(JD$T.INSTANCE, TemplateTypeParmType.class, T), new SourceLocation()));
    }
    
    return true;
  }

  
  /// \brief Record occurrences of function and non-type template
  /// parameter packs in an expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*//*PointerUnion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 73,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    if (E.getDecl().isParameterPack()) {
      Unexpanded.push_back(std.make_pair_Ptr2T_T(new PointerUnion<>(JD$T1.INSTANCE, NamedDecl.class, E.getDecl()), E.getLocation()));
    }
    
    return true;
  }

  
  /// \brief Record occurrences of template template parameter packs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTemplateName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*//*PointerUnion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 81,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTemplateName", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor20TraverseTemplateNameEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor20TraverseTemplateNameEN5clang12TemplateNameE")
  //</editor-fold>
  public boolean TraverseTemplateName(TemplateName Template) {
    {
      TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_or_null_TemplateTemplateParmDecl(Template.getAsTemplateDecl());
      if ((TTP != null)) {
        if (TTP.isParameterPack()) {
          Unexpanded.push_back(std.make_pair_Ptr2T_T(new PointerUnion<>(JD$T1.INSTANCE, NamedDecl.class, TTP), new SourceLocation()));
        }
      }
    }
    
    return RecursiveASTVisitor.super.TraverseTemplateName(new TemplateName(Template));
  }

  
  /// \brief Suppress traversal into Objective-C container literal
  /// elements that are pack expansions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 93,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseObjCDictionaryLiteral", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor29TraverseObjCDictionaryLiteralEPN5clang21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor29TraverseObjCDictionaryLiteralEPN5clang21ObjCDictionaryLiteralE")
  //</editor-fold>
  public boolean TraverseObjCDictionaryLiteral(ObjCDictionaryLiteral /*P*/ E) {
    if (!E.containsUnexpandedParameterPack()) {
      return true;
    }
    
    for (/*uint*/int I = 0, N = E.getNumElements(); I != N; ++I) {
      ObjCDictionaryElement Element = null;
      try {
        Element = E.getKeyValueElement(I);
        if (Element.isPackExpansion()) {
          continue;
        }
        
        TraverseStmt(Element.Key);
        TraverseStmt(Element.Value);
      } finally {
        if (Element != null) { Element.$destroy(); }
      }
    }
    return true;
  }

  //------------------------------------------------------------------------
  // Pruning the search for unexpanded parameter packs.
  //------------------------------------------------------------------------
  
  /// \brief Suppress traversal into statements and expressions that
  /// do not contain unexpanded parameter packs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 113,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseStmt", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor12TraverseStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor12TraverseStmtEPN5clang4StmtE")
  //</editor-fold>
  public boolean TraverseStmt(Stmt /*P*/ S) {
    Expr /*P*/ E = dyn_cast_or_null_Expr(S);
    if (((E != null) && E.containsUnexpandedParameterPack()) || InLambda) {
      return RecursiveASTVisitor.super.TraverseStmt(S);
    }
    
    return true;
  }

  
  /// \brief Suppress traversal into types that do not contain
  /// unexpanded parameter packs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 123,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseType", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor12TraverseTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor12TraverseTypeEN5clang8QualTypeE")
  //</editor-fold>
  public boolean TraverseType(QualType T) {
    if ((!T.isNull() && T.$arrow().containsUnexpandedParameterPack()) || InLambda) {
      return RecursiveASTVisitor.super.TraverseType(new QualType(T));
    }
    
    return true;
  }

  
  /// \brief Suppress traversel into types with location information
  /// that do not contain unexpanded parameter packs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 132,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTypeLoc", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor15TraverseTypeLocEN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor15TraverseTypeLocEN5clang7TypeLocE")
  //</editor-fold>
  public boolean TraverseTypeLoc(TypeLoc TL) {
    if ((!TL.getType().isNull()
       && TL.getType().$arrow().containsUnexpandedParameterPack())
       || InLambda) {
      return RecursiveASTVisitor.super.TraverseTypeLoc(new TypeLoc(TL));
    }
    
    return true;
  }

  
  /// \brief Suppress traversal of non-parameter declarations, since
  /// they cannot contain unexpanded parameter packs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 143,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseDecl", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor12TraverseDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor12TraverseDeclEPN5clang4DeclE")
  //</editor-fold>
  public boolean TraverseDecl(Decl /*P*/ D) {
    if (((D != null) && isa_ParmVarDecl(D)) || InLambda) {
      return RecursiveASTVisitor.super.TraverseDecl(D);
    }
    
    return true;
  }

  
  /// \brief Suppress traversal of template argument pack expansions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 151,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTemplateArgument", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor24TraverseTemplateArgumentERKN5clang16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor24TraverseTemplateArgumentERKN5clang16TemplateArgumentE")
  //</editor-fold>
  public boolean TraverseTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg) {
    if (Arg.isPackExpansion()) {
      return true;
    }
    
    return RecursiveASTVisitor.super.TraverseTemplateArgument(Arg);
  }

  
  /// \brief Suppress traversal of template argument pack expansions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 159,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseTemplateArgumentLoc", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor27TraverseTemplateArgumentLocERKN5clang19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor27TraverseTemplateArgumentLocERKN5clang19TemplateArgumentLocE")
  //</editor-fold>
  public boolean TraverseTemplateArgumentLoc(final /*const*/ TemplateArgumentLoc /*&*/ ArgLoc) {
    if (ArgLoc.getArgument().isPackExpansion()) {
      return true;
    }
    
    return RecursiveASTVisitor.super.TraverseTemplateArgumentLoc(ArgLoc);
  }

  
  /// \brief Note whether we're traversing a lambda containing an unexpanded
  /// parameter pack. In this case, the unexpanded pack can occur anywhere,
  /// including all the places where we normally wouldn't look. Within a
  /// lambda, we don't propagate the 'contains unexpanded parameter pack' bit
  /// outside an expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseLambdaExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*//*PointerUnion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 171,
   FQN="(anonymous namespace)::CollectUnexpandedParameterPacksVisitor::TraverseLambdaExpr", NM="_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor18TraverseLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZN12_GLOBAL__N_138CollectUnexpandedParameterPacksVisitor18TraverseLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public boolean TraverseLambdaExpr(LambdaExpr /*P*/ Lambda) {
    // The ContainsUnexpandedParameterPack bit on a lambda is always correct,
    // even if it's contained within another lambda.
    if (!Lambda.containsUnexpandedParameterPack()) {
      return true;
    }
    
    boolean WasInLambda = InLambda;
    InLambda = true;
    
    // If any capture names a function parameter pack, that pack is expanded
    // when the lambda is expanded.
    for (type$ptr<LambdaCapture> I = $tryClone(Lambda.capture_begin()), 
        /*P*/ E = $tryClone(Lambda.capture_end());
         $noteq_ptr(I, E); I.$preInc()) {
      if (I./*->*/$star().capturesVariable()) {
        VarDecl /*P*/ VD = I./*->*/$star().getCapturedVar();
        if (VD.isParameterPack()) {
          Unexpanded.push_back(std.make_pair_Ptr2T_T(new PointerUnion<>(JD$T1.INSTANCE, NamedDecl.class, VD), I./*->*/$star().getLocation()));
        }
      }
    }
    
    RecursiveASTVisitor.super.TraverseLambdaExpr(Lambda);
    
    InLambda = WasInLambda;
    return true;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    return false; // There are no traversal methods with queue in this class.
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Unexpanded=" + Unexpanded // NOI18N
              + ", InLambda=" + InLambda // NOI18N
              + super.toString(); // NOI18N
  }
}
