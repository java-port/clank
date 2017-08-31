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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.impl.ExprStatics.*;
import org.clank.java.std;
import org.llvm.support.TrailingObjects.*;


/// \brief A reference to a declared variable, function, enum, etc.
/// [C99 6.5.1p2]
///
/// This encodes all the information about how a declaration is referenced
/// within an expression.
///
/// There are several optional constructs attached to DeclRefExprs only when
/// they apply in order to conserve memory. These are laid out past the end of
/// the object, and flags in the DeclRefExprBitfield track whether they exist:
///
///   DeclRefExprBits.HasQualifier:
///       Specifies when this declaration reference expression has a C++
///       nested-name-specifier.
///   DeclRefExprBits.HasFoundDecl:
///       Specifies when this declaration reference expression has a record of
///       a NamedDecl (different from the referenced ValueDecl) which was found
///       during name lookup and/or overload resolution.
///   DeclRefExprBits.HasTemplateKWAndArgsInfo:
///       Specifies when this declaration reference expression has an explicit
///       C++ template keyword and/or template argument list.
///   DeclRefExprBits.RefersToEnclosingVariableOrCapture
///       Specifies when this declaration reference expression (validly)
///       refers to an enclosed local or a captured variable.
//<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 932,
 FQN="clang::DeclRefExpr", NM="_ZN5clang11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExprE")
//</editor-fold>
public final class DeclRefExpr extends /*public*/ Expr implements /*private*/ TrailingObjects4<DeclRefExpr, NestedNameSpecifierLoc, NamedDecl /*P*/ , ASTTemplateKWAndArgsInfo, TemplateArgumentLoc> {  
  /// \brief The declaration that we are referencing.
  private ValueDecl /*P*/ D;
  
  /// \brief The location of the declaration name itself.
  private SourceLocation Loc;
  
  /// \brief Provides source/type location info for the declaration name
  /// embedded in D.
  /*friend*/public DeclarationNameLoc DNLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 947,
   FQN="clang::DeclRefExpr::numTrailingObjects", NM="_ZNK5clang11DeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_22NestedNameSpecifierLocEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_22NestedNameSpecifierLocEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$NestedNameSpecifierLoc(OverloadToken<NestedNameSpecifierLoc> $Prm0) /*const*/ {
    return hasQualifier() ? 1 : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 951,
   FQN="clang::DeclRefExpr::numTrailingObjects", NM="_ZNK5clang11DeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9NamedDeclEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$NamedDecl$P(OverloadToken<NamedDecl /*P*/ > $Prm0) /*const*/ {
    return hasFoundDecl() ? 1 : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 955,
   FQN="clang::DeclRefExpr::numTrailingObjects", NM="_ZNK5clang11DeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$ASTTemplateKWAndArgsInfo(OverloadToken<ASTTemplateKWAndArgsInfo> $Prm0) /*const*/ {
    return hasTemplateKWAndArgsInfo() ? 1 : 0;
  }

  
  /// \brief Test whether there is a distinct FoundDecl attached to the end of
  /// this DRE.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::hasFoundDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 961,
   FQN="clang::DeclRefExpr::hasFoundDecl", NM="_ZNK5clang11DeclRefExpr12hasFoundDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr12hasFoundDeclEv")
  //</editor-fold>
  /*friend*/public boolean hasFoundDecl() /*const*/ {
    return Unnamed_field.DeclRefExprBits.HasFoundDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::DeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Allocations + $this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 322,
   FQN="clang::DeclRefExpr::DeclRefExpr", NM="_ZN5clang11DeclRefExprC1ERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationEPNS_9ValueDeclEbRKNS_19DeclarationNameInfoEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoENS_8QualTypeENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExprC1ERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationEPNS_9ValueDeclEbRKNS_19DeclarationNameInfoEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoENS_8QualTypeENS_13ExprValueKindE")
  //</editor-fold>
  public DeclRefExpr(final /*const*/ ASTContext /*&*/ Ctx, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateKWLoc, 
      ValueDecl /*P*/ D, boolean RefersToEnclosingVariableOrCapture, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      NamedDecl /*P*/ FoundD, 
      /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
      QualType T, ExprValueKind VK) {
    // : Expr(DeclRefExprClass, T, VK, OK_Ordinary, false, false, false, false), TrailingObjects<DeclRefExpr, NestedNameSpecifierLoc, NamedDecl * , ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), D(D), Loc(NameInfo.getLoc()), DNLoc(NameInfo.getInfo()) 
    //START JInit
    super(StmtClass.DeclRefExprClass, new QualType(T), VK, ExprObjectKind.OK_Ordinary, false, false, false, false);
    $TrailingObjects();
    this.D = D;
    this.Loc = NameInfo.getLoc();
    this.DNLoc = new DeclarationNameLoc(NameInfo.getInfo$Const());
    //END JInit
    Unnamed_field.DeclRefExprBits.HasQualifier = $uint2uint_1bit(QualifierLoc.$bool() ? 1 : 0);
    if (QualifierLoc.$bool()) {
      // JAVA: MEMORY
      assert getTrailingObjects(NestedNameSpecifierLoc.class) != null;
      assert getTrailingObjects(NestedNameSpecifierLoc.class).$star() != null : "Why is not initialized?";
      getTrailingObjects(NestedNameSpecifierLoc.class).$set(/*FIXME:NEW_EXPR*//*new (getTrailingObjects<NestedNameSpecifierLoc>())*/ new NestedNameSpecifierLoc(QualifierLoc));
      NestedNameSpecifier /*P*/ NNS = QualifierLoc.getNestedNameSpecifier();
      if (NNS.isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (NNS.containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
    }
    Unnamed_field.DeclRefExprBits.HasFoundDecl = $uint2uint_1bit((FoundD != null) ? 1 : 0);
    if ((FoundD != null)) {
      this.<NamedDecl /*P*/ >getTrailingObjects(NamedDecl.class).$set(FoundD);
    }
    Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo
       = $uint2uint_1bit(((TemplateArgs != null) || TemplateKWLoc.isValid()) ? 1 : 0);
    Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture
       = RefersToEnclosingVariableOrCapture;
    if ((TemplateArgs != null)) {
      bool$ref Dependent = create_bool$ref(false);
      bool$ref InstantiationDependent = create_bool$ref(false);
      bool$ref ContainsUnexpandedParameterPack = create_bool$ref(false);
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc), $Deref(TemplateArgs), this.<TemplateArgumentLoc>getTrailingObjects(TemplateArgumentLoc.class), 
          Dependent, InstantiationDependent, ContainsUnexpandedParameterPack);
      assert (!Dependent.$deref()) : "built a DeclRefExpr with dependent template args";
      Unnamed_field.ExprBits.InstantiationDependent |= InstantiationDependent.$deref();
      Unnamed_field.ExprBits.ContainsUnexpandedParameterPack |= ContainsUnexpandedParameterPack.$deref();
    } else if (TemplateKWLoc.isValid()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc));
    }
    Unnamed_field.DeclRefExprBits.HadMultipleCandidates = false;
    
    computeDependence(Ctx);
  }

  
  /// \brief Construct an empty declaration reference expression.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::DeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 973,
   FQN="clang::DeclRefExpr::DeclRefExpr", NM="_ZN5clang11DeclRefExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private /*explicit*/ DeclRefExpr(EmptyShell Empty) {
    // : Expr(DeclRefExprClass, Empty), TrailingObjects<DeclRefExpr, NestedNameSpecifierLoc, NamedDecl * , ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), Loc(), DNLoc() 
    //START JInit
    super(StmtClass.DeclRefExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.Loc = new SourceLocation();
    this.DNLoc = new DeclarationNameLoc();
    //END JInit
  }

  
  /// \brief Computes the type- and value-dependence flags for this
  /// declaration reference expression.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::computeDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 306,
   FQN="clang::DeclRefExpr::computeDependence", NM="_ZN5clang11DeclRefExpr17computeDependenceERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr17computeDependenceERKNS_10ASTContextE")
  //</editor-fold>
  private void computeDependence(final /*const*/ ASTContext /*&*/ Ctx) {
    bool$ref TypeDependent = create_bool$ref(false);
    bool$ref ValueDependent = create_bool$ref(false);
    bool$ref InstantiationDependent = create_bool$ref(false);
    computeDeclRefDependence(Ctx, getDecl(), getType(), TypeDependent, 
        ValueDependent, InstantiationDependent);
    
    Unnamed_field.ExprBits.TypeDependent |= TypeDependent.$deref();
    Unnamed_field.ExprBits.ValueDependent |= ValueDependent.$deref();
    Unnamed_field.ExprBits.InstantiationDependent |= InstantiationDependent.$deref();
    
    // Is the declaration a parameter pack?
    if (getDecl().isParameterPack()) {
      Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::DeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 981,
   FQN="clang::DeclRefExpr::DeclRefExpr", NM="_ZN5clang11DeclRefExprC1EPNS_9ValueDeclEbNS_8QualTypeENS_13ExprValueKindENS_14SourceLocationERKNS_18DeclarationNameLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExprC1EPNS_9ValueDeclEbNS_8QualTypeENS_13ExprValueKindENS_14SourceLocationERKNS_18DeclarationNameLocE")
  //</editor-fold>
  public DeclRefExpr(ValueDecl /*P*/ D, boolean RefersToEnclosingVariableOrCapture, QualType T, 
      ExprValueKind VK, SourceLocation L) {
    this(D, RefersToEnclosingVariableOrCapture, T, 
      VK, L, 
      new DeclarationNameLoc());
  }
  public DeclRefExpr(ValueDecl /*P*/ D, boolean RefersToEnclosingVariableOrCapture, QualType T, 
      ExprValueKind VK, SourceLocation L, 
      final /*const*/ DeclarationNameLoc /*&*/ LocInfo/*= DeclarationNameLoc()*/) {
    // : Expr(DeclRefExprClass, T, VK, OK_Ordinary, false, false, false, false), TrailingObjects<DeclRefExpr, NestedNameSpecifierLoc, NamedDecl * , ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), D(D), Loc(L), DNLoc(LocInfo) 
    //START JInit
    super(StmtClass.DeclRefExprClass, new QualType(T), VK, ExprObjectKind.OK_Ordinary, false, false, false, false);
    $TrailingObjects();
    this.D = D;
    this.Loc = new SourceLocation(L);
    this.DNLoc = new DeclarationNameLoc(LocInfo);
    //END JInit
    Unnamed_field.DeclRefExprBits.HasQualifier = false;
    Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo = false;
    Unnamed_field.DeclRefExprBits.HasFoundDecl = false;
    Unnamed_field.DeclRefExprBits.HadMultipleCandidates = false;
    Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture
       = RefersToEnclosingVariableOrCapture;
    computeDependence(D.getASTContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 368,
   FQN="clang::DeclRefExpr::Create", NM="_ZN5clang11DeclRefExpr6CreateERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationEPNS_9ValueDeclEbS5_NS_8QualTypeENS_13ExprValueKindEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr6CreateERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationEPNS_9ValueDeclEbS5_NS_8QualTypeENS_13ExprValueKindEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static DeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ D, 
        boolean RefersToEnclosingVariableOrCapture, 
        SourceLocation NameLoc, 
        QualType T, 
        ExprValueKind VK) {
    return Create(Context, 
        QualifierLoc, 
        TemplateKWLoc, 
        D, 
        RefersToEnclosingVariableOrCapture, 
        NameLoc, 
        T, 
        VK, 
        (NamedDecl /*P*/ )null, 
        (/*const*/ TemplateArgumentListInfo /*P*/ )null);
  }
  public static DeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ D, 
        boolean RefersToEnclosingVariableOrCapture, 
        SourceLocation NameLoc, 
        QualType T, 
        ExprValueKind VK, 
        NamedDecl /*P*/ FoundD/*= null*/) {
    return Create(Context, 
        QualifierLoc, 
        TemplateKWLoc, 
        D, 
        RefersToEnclosingVariableOrCapture, 
        NameLoc, 
        T, 
        VK, 
        FoundD, 
        (/*const*/ TemplateArgumentListInfo /*P*/ )null);
  }
  public static DeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ D, 
        boolean RefersToEnclosingVariableOrCapture, 
        SourceLocation NameLoc, 
        QualType T, 
        ExprValueKind VK, 
        NamedDecl /*P*/ FoundD/*= null*/, 
        /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/) {
    return Create(Context, new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateKWLoc), D, 
        RefersToEnclosingVariableOrCapture, 
        new DeclarationNameInfo(D.getDeclName(), new SourceLocation(NameLoc)), 
        new QualType(T), VK, FoundD, TemplateArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*allocaction*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 384,
   FQN="clang::DeclRefExpr::Create", NM="_ZN5clang11DeclRefExpr6CreateERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationEPNS_9ValueDeclEbRKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr6CreateERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationEPNS_9ValueDeclEbRKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static DeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ D, 
        boolean RefersToEnclosingVariableOrCapture, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, 
        ExprValueKind VK) {
    return Create(Context, 
        QualifierLoc, 
        TemplateKWLoc, 
        D, 
        RefersToEnclosingVariableOrCapture, 
        NameInfo, 
        T, 
        VK, 
        (NamedDecl /*P*/ )null, 
        (/*const*/ TemplateArgumentListInfo /*P*/ )null);
  }
  public static DeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ D, 
        boolean RefersToEnclosingVariableOrCapture, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, 
        ExprValueKind VK, 
        NamedDecl /*P*/ FoundD/*= null*/) {
    return Create(Context, 
        QualifierLoc, 
        TemplateKWLoc, 
        D, 
        RefersToEnclosingVariableOrCapture, 
        NameInfo, 
        T, 
        VK, 
        FoundD, 
        (/*const*/ TemplateArgumentListInfo /*P*/ )null);
  }
  public static DeclRefExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ D, 
        boolean RefersToEnclosingVariableOrCapture, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, 
        ExprValueKind VK, 
        NamedDecl /*P*/ FoundD/*= null*/, 
        /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/) {
    // Filter out cases where the found Decl is the same as the value refenenced.
    if (D == FoundD) {
      FoundD = null;
    }
    final NamedDecl /*P*/ finalFoundD = FoundD ;
    boolean HasTemplateKWAndArgsInfo = (TemplateArgs != null) || TemplateKWLoc.isValid();
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(NestedNameSpecifierLoc.class, NamedDecl.class, ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, QualifierLoc.$bool() ? 1 : 0, (FoundD != null) ? 1 : 0, HasTemplateKWAndArgsInfo ? 1 : 0, (TemplateArgs != null) ? TemplateArgs.size() : 0);
    assert Size > 0 : "at least 1 for object itself";
    //assert Size == 1 : "FIXME: need to pass Memory into DeclRefExpr ctr for trailing objects";
    
    Object/*void P*/ _Mem = Context.Allocate$JavaRef(Size, alignOf(DeclRefExpr.class),
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>(QualifierLoc.$bool() ? 1 : 0, ()->new NestedNameSpecifierLoc()),
            new std.pairIntPtr<>((FoundD != null) ? 1 : 0, ()->null), // NamedDecl*
            new std.pairIntPtr<>(HasTemplateKWAndArgsInfo ? 1 : 0, ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>((TemplateArgs != null) ? TemplateArgs.size() : 0, ()->new TemplateArgumentLoc())
    );
    
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)-> {
        return new DeclRefExpr(Context, new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateKWLoc), D, 
                RefersToEnclosingVariableOrCapture, 
                NameInfo, finalFoundD, TemplateArgs, new QualType(T), VK);
     });
  }

  
  /// \brief Construct an empty declaration reference expression.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 412,
   FQN="clang::DeclRefExpr::CreateEmpty", NM="_ZN5clang11DeclRefExpr11CreateEmptyERKNS_10ASTContextEbbbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr11CreateEmptyERKNS_10ASTContextEbbbj")
  //</editor-fold>
  public static DeclRefExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ Context, 
             boolean HasQualifier, 
             boolean HasFoundDecl, 
             boolean HasTemplateKWAndArgsInfo, 
             /*uint*/int NumTemplateArgs) {
    assert (NumTemplateArgs == 0 || HasTemplateKWAndArgsInfo);
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(NestedNameSpecifierLoc.class, NamedDecl.class, ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, HasQualifier ? 1 : 0, HasFoundDecl ? 1 : 0, (HasTemplateKWAndArgsInfo ? 1 : 0), NumTemplateArgs);
    Object/*void P*/ _Mem = Context.Allocate$JavaRef(Size, alignOf(DeclRefExpr.class),
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>(HasQualifier ? 1 : 0, ()->new NestedNameSpecifierLoc()),
            new std.pairIntPtr<>(HasFoundDecl ? 1 : 0, ()->null), // NamedDecl*
            new std.pairIntPtr<>(HasTemplateKWAndArgsInfo ? 1 : 0, ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>(NumTemplateArgs, ()->new TemplateArgumentLoc())
    );
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new DeclRefExpr(new EmptyShell());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1017,
   FQN="clang::DeclRefExpr::getDecl", NM="_ZN5clang11DeclRefExpr7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr7getDeclEv")
  //</editor-fold>
  public ValueDecl /*P*/ getDecl() {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1018,
   FQN="clang::DeclRefExpr::getDecl", NM="_ZNK5clang11DeclRefExpr7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr7getDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ getDecl$Const() /*const*/ {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::setDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1019,
   FQN="clang::DeclRefExpr::setDecl", NM="_ZN5clang11DeclRefExpr7setDeclEPNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr7setDeclEPNS_9ValueDeclE")
  //</editor-fold>
  public void setDecl(ValueDecl /*P*/ NewD) {
    D = NewD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1021,
   FQN="clang::DeclRefExpr::getNameInfo", NM="_ZNK5clang11DeclRefExpr11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr11getNameInfoEv")
  //</editor-fold>
  public DeclarationNameInfo getNameInfo() /*const*/ {
    return new DeclarationNameInfo(getDecl$Const().getDeclName(), new SourceLocation(Loc), new DeclarationNameLoc(DNLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1025,
   FQN="clang::DeclRefExpr::getLocation", NM="_ZNK5clang11DeclRefExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1026,
   FQN="clang::DeclRefExpr::setLocation", NM="_ZN5clang11DeclRefExpr11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    Loc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 427,
   FQN="clang::DeclRefExpr::getLocStart", NM="_ZNK5clang11DeclRefExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    if (hasQualifier()) {
      return getQualifierLoc().getBeginLoc();
    }
    return getNameInfo().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 432,
   FQN="clang::DeclRefExpr::getLocEnd", NM="_ZNK5clang11DeclRefExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (hasExplicitTemplateArgs()) {
      return getRAngleLoc();
    }
    return getNameInfo().getLocEnd();
  }

  
  /// \brief Determine whether this declaration reference was preceded by a
  /// C++ nested-name-specifier, e.g., \c N::foo.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::hasQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1032,
   FQN="clang::DeclRefExpr::hasQualifier", NM="_ZNK5clang11DeclRefExpr12hasQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr12hasQualifierEv")
  //</editor-fold>
  public boolean hasQualifier() /*const*/ {
    return Unnamed_field.DeclRefExprBits.HasQualifier;
  }

  
  /// \brief If the name was qualified, retrieves the nested-name-specifier
  /// that precedes the name, with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getQualifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1036,
   FQN="clang::DeclRefExpr::getQualifierLoc", NM="_ZNK5clang11DeclRefExpr15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    if (!hasQualifier()) {
      return new NestedNameSpecifierLoc();
    }
    return new NestedNameSpecifierLoc($Deref(this.<NestedNameSpecifierLoc>getTrailingObjects$Const(NestedNameSpecifierLoc.class).$star()));
  }

  
  /// \brief If the name was qualified, retrieves the nested-name-specifier
  /// that precedes the name. Otherwise, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1044,
   FQN="clang::DeclRefExpr::getQualifier", NM="_ZNK5clang11DeclRefExpr12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return getQualifierLoc().getNestedNameSpecifier();
  }

  
  /// \brief Get the NamedDecl through which this reference occurred.
  ///
  /// This Decl may be different from the ValueDecl actually referred to in the
  /// presence of using declarations, etc. It always returns non-NULL, and may
  /// simple return the ValueDecl when appropriate.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getFoundDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1054,
   FQN="clang::DeclRefExpr::getFoundDecl", NM="_ZN5clang11DeclRefExpr12getFoundDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr12getFoundDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getFoundDecl() {
    return hasFoundDecl() ? this.<NamedDecl /*P*/ >getTrailingObjects(NamedDecl.class).$star() : D;
  }

  
  /// \brief Get the NamedDecl through which this reference occurred.
  /// See non-const variant.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getFoundDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1060,
   FQN="clang::DeclRefExpr::getFoundDecl", NM="_ZNK5clang11DeclRefExpr12getFoundDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr12getFoundDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getFoundDecl$Const() /*const*/ {
    return hasFoundDecl() ? this.<NamedDecl /*P*/ >getTrailingObjects$Const(NamedDecl.class).$star() : D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::hasTemplateKWAndArgsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1064,
   FQN="clang::DeclRefExpr::hasTemplateKWAndArgsInfo", NM="_ZNK5clang11DeclRefExpr24hasTemplateKWAndArgsInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr24hasTemplateKWAndArgsInfoEv")
  //</editor-fold>
  public boolean hasTemplateKWAndArgsInfo() /*const*/ {
    return Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo;
  }

  
  /// \brief Retrieve the location of the template keyword preceding
  /// this name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1070,
   FQN="clang::DeclRefExpr::getTemplateKeywordLoc", NM="_ZNK5clang11DeclRefExpr21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    if (!hasTemplateKWAndArgsInfo()) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().TemplateKWLoc);
  }

  
  /// \brief Retrieve the location of the left angle bracket starting the
  /// explicit template argument list following the name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1077,
   FQN="clang::DeclRefExpr::getLAngleLoc", NM="_ZNK5clang11DeclRefExpr12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    if (!hasTemplateKWAndArgsInfo()) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().LAngleLoc);
  }

  
  /// \brief Retrieve the location of the right angle bracket ending the
  /// explicit template argument list following the name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1084,
   FQN="clang::DeclRefExpr::getRAngleLoc", NM="_ZNK5clang11DeclRefExpr12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    if (!hasTemplateKWAndArgsInfo()) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().RAngleLoc);
  }

  
  /// \brief Determines whether the name in this declaration reference
  /// was preceded by the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::hasTemplateKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1091,
   FQN="clang::DeclRefExpr::hasTemplateKeyword", NM="_ZNK5clang11DeclRefExpr18hasTemplateKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr18hasTemplateKeywordEv")
  //</editor-fold>
  public boolean hasTemplateKeyword() /*const*/ {
    return getTemplateKeywordLoc().isValid();
  }

  
  /// \brief Determines whether this declaration reference was followed by an
  /// explicit template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::hasExplicitTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1095,
   FQN="clang::DeclRefExpr::hasExplicitTemplateArgs", NM="_ZNK5clang11DeclRefExpr23hasExplicitTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr23hasExplicitTemplateArgsEv")
  //</editor-fold>
  public boolean hasExplicitTemplateArgs() /*const*/ {
    return getLAngleLoc().isValid();
  }

  
  /// \brief Copies the template arguments (if present) into the given
  /// structure.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::copyTemplateArgumentsInto">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1099,
   FQN="clang::DeclRefExpr::copyTemplateArgumentsInto", NM="_ZNK5clang11DeclRefExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void copyTemplateArgumentsInto(final TemplateArgumentListInfo /*&*/ List) /*const*/ {
    if (hasExplicitTemplateArgs()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().copyInto(this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class), List);
    }
  }

  
  /// \brief Retrieve the template arguments provided as part of this
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1107,
   FQN="clang::DeclRefExpr::getTemplateArgs", NM="_ZNK5clang11DeclRefExpr15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return null;
    }
    
    return this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class);
  }

  
  /// \brief Retrieve the number of template arguments provided as part of this
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::getNumTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1116,
   FQN="clang::DeclRefExpr::getNumTemplateArgs", NM="_ZNK5clang11DeclRefExpr18getNumTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr18getNumTemplateArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return 0;
    }
    
    return this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().NumTemplateArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1123,
   FQN="clang::DeclRefExpr::template_arguments", NM="_ZNK5clang11DeclRefExpr18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgumentLoc> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgumentLoc>(getTemplateArgs(), getNumTemplateArgs(), false)/* }*/;
  }

  
  /// \brief Returns true if this expression refers to a function that
  /// was resolved from an overloaded set having size greater than 1.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::hadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1129,
   FQN="clang::DeclRefExpr::hadMultipleCandidates", NM="_ZNK5clang11DeclRefExpr21hadMultipleCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr21hadMultipleCandidatesEv")
  //</editor-fold>
  public boolean hadMultipleCandidates() /*const*/ {
    return Unnamed_field.DeclRefExprBits.HadMultipleCandidates;
  }

  /// \brief Sets the flag telling whether this expression refers to
  /// a function that was resolved from an overloaded set having size
  /// greater than 1.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::setHadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1135,
   FQN="clang::DeclRefExpr::setHadMultipleCandidates", NM="_ZN5clang11DeclRefExpr24setHadMultipleCandidatesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr24setHadMultipleCandidatesEb")
  //</editor-fold>
  public void setHadMultipleCandidates() {
    setHadMultipleCandidates(true);
  }
  public void setHadMultipleCandidates(boolean V/*= true*/) {
    Unnamed_field.DeclRefExprBits.HadMultipleCandidates = V;
  }

  
  /// \brief Does this DeclRefExpr refer to an enclosing local or a captured
  /// variable?
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::refersToEnclosingVariableOrCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1141,
   FQN="clang::DeclRefExpr::refersToEnclosingVariableOrCapture", NM="_ZNK5clang11DeclRefExpr34refersToEnclosingVariableOrCaptureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang11DeclRefExpr34refersToEnclosingVariableOrCaptureEv")
  //</editor-fold>
  public boolean refersToEnclosingVariableOrCapture() /*const*/ {
    return Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1145,
   FQN="clang::DeclRefExpr::classof", NM="_ZN5clang11DeclRefExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.DeclRefExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::DeclRefExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1150,
   FQN="clang::DeclRefExpr::children", NM="_ZN5clang11DeclRefExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang11DeclRefExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  TrailingObjects<DeclRefExpr, NestedNameSpecifierLoc, NamedDecl *, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }

  @Override public int getTrailingObjects$Offset(Class<?> clazz) {
    assert NestedNameSpecifierLoc.class == clazz
            || NamedDecl.class == clazz
            || ASTTemplateKWAndArgsInfo.class == clazz
            || TemplateArgumentLoc.class == clazz : "Unexpected class: " + clazz;
    int index = 0;
    if (NestedNameSpecifierLoc.class == clazz) {
      return index;
    }
    index += getNumTailingObject_OverloadToken$TrailingTy1();
    if (NamedDecl.class == clazz) {
      return index;
    }
    index += getNumTailingObject_OverloadToken$TrailingTy2();
    if (ASTTemplateKWAndArgsInfo.class == clazz) {
      return index;
    }
    return index + getNumTailingObject_OverloadToken$TrailingTy3();
  }

  @Override public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy1() {
    return numTrailingObjects_OverloadToken$NestedNameSpecifierLoc((OverloadToken<NestedNameSpecifierLoc>) null);
  }

  @Override public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy2() {
    return numTrailingObjects_OverloadToken$NamedDecl$P((OverloadToken<NamedDecl /*P*/>) null);
  }

  @Override public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy3() {
    return numTrailingObjects_OverloadToken$ASTTemplateKWAndArgsInfo((OverloadToken<ASTTemplateKWAndArgsInfo>) null);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + "D=" + D // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", DNLoc=" + DNLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
