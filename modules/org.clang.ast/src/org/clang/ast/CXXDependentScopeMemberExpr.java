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
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clank.java.std;
import org.llvm.adt.java.TrailingObjectsUtils;

/// \brief Represents a C++ member access expression where the actual
/// member referenced could not be resolved because the base
/// expression or the member name was dependent.
///
/// Like UnresolvedMemberExprs, these can be either implicit or
/// explicit accesses.  It is only possible to get one of these with
/// an implicit access if a qualifier is provided.
//<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3128,
 FQN="clang::CXXDependentScopeMemberExpr", NM="_ZN5clang27CXXDependentScopeMemberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExprE")
//</editor-fold>
public final class CXXDependentScopeMemberExpr extends /*public*/ Expr implements /*private*/ TrailingObjects2<CXXDependentScopeMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc> {
  /// \brief The expression for the base pointer or class reference,
  /// e.g., the \c x in x.f.  Can be null in implicit accesses.
  /*friend*/public Stmt /*P*/ Base;
  
  /// \brief The type of the base expression.  Never null, even for
  /// implicit accesses.
  /*friend*/public QualType BaseType;
  
  /// \brief Whether this member expression used the '->' operator or
  /// the '.' operator.
  /*friend*/public /*JBIT bool*/ boolean IsArrow /*: 1*/;
  
  /// \brief Whether this member expression has info for explicit template
  /// keyword and arguments.
  /*friend*/public /*JBIT bool*/ boolean HasTemplateKWAndArgsInfo /*: 1*/;
  
  /// \brief The location of the '->' or '.' operator.
  /*friend*/public SourceLocation OperatorLoc;
  
  /// \brief The nested-name-specifier that precedes the member name, if any.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief In a qualified member access expression such as t->Base::f, this
  /// member stores the resolves of name lookup in the context of the member
  /// access expression, to be used at instantiation time.
  ///
  /// FIXME: This member, along with the QualifierLoc, could
  /// be stuck into a structure that is optionally allocated at the end of
  /// the CXXDependentScopeMemberExpr, to save space in the common case.
  /*friend*/public NamedDecl /*P*/ FirstQualifierFoundInScope;
  
  /// \brief The member to which this member expression refers, which
  /// can be name, overloaded operator, or destructor.
  ///
  /// FIXME: could also be a template-id
  /*friend*/public DeclarationNameInfo MemberNameInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3170,
   FQN="clang::CXXDependentScopeMemberExpr::numTrailingObjects", NM="_ZNK5clang27CXXDependentScopeMemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<ASTTemplateKWAndArgsInfo> $Prm0) /*const*/ {
    return HasTemplateKWAndArgsInfo ? 1 : 0;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::CXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1108,
   FQN="clang::CXXDependentScopeMemberExpr::CXXDependentScopeMemberExpr", NM="_ZN5clang27CXXDependentScopeMemberExprC1ERKNS_10ASTContextEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_PNS_9NamedDeclENS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExprC1ERKNS_10ASTContextEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_PNS_9NamedDeclENS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  private CXXDependentScopeMemberExpr(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ Base, QualType BaseType, boolean IsArrow, 
      SourceLocation OperatorLoc, NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateKWLoc, NamedDecl /*P*/ FirstQualifierFoundInScope, 
      DeclarationNameInfo MemberNameInfo, 
      /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
    // : Expr(CXXDependentScopeMemberExprClass, C.DependentTy.operator QualType(), VK_LValue, OK_Ordinary, true, true, true, ((Base && Base->containsUnexpandedParameterPack()) || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->containsUnexpandedParameterPack()) || MemberNameInfo.containsUnexpandedParameterPack())), TrailingObjects<CXXDependentScopeMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), Base(Base), BaseType(BaseType), IsArrow(IsArrow), HasTemplateKWAndArgsInfo(TemplateArgs != null || TemplateKWLoc.isValid()), OperatorLoc(OperatorLoc), QualifierLoc(QualifierLoc), FirstQualifierFoundInScope(FirstQualifierFoundInScope), MemberNameInfo(MemberNameInfo) 
    //START JInit
    super(StmtClass.CXXDependentScopeMemberExprClass, C.DependentTy.$QualType(), ExprValueKind.VK_LValue, 
        ExprObjectKind.OK_Ordinary, true, true, true, 
        (((Base != null) && Base.containsUnexpandedParameterPack())
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().
            containsUnexpandedParameterPack())
           || MemberNameInfo.containsUnexpandedParameterPack()));
    $TrailingObjects();
    this.Base = Base;
    this.BaseType = new QualType(BaseType);
    this.IsArrow = IsArrow;
    this.HasTemplateKWAndArgsInfo = TemplateArgs != null
       || TemplateKWLoc.isValid();
    this.OperatorLoc = new SourceLocation(OperatorLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.FirstQualifierFoundInScope = FirstQualifierFoundInScope;
    this.MemberNameInfo = new DeclarationNameInfo(MemberNameInfo);
    //END JInit
    if ((TemplateArgs != null)) {
      bool$ref Dependent = create_bool$ref(true);
      bool$ref InstantiationDependent = create_bool$ref(true);
      bool$ref ContainsUnexpandedParameterPack = create_bool$ref(false);
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc), $Deref(TemplateArgs), this.<TemplateArgumentLoc>getTrailingObjects(TemplateArgumentLoc.class), 
          Dependent, InstantiationDependent, ContainsUnexpandedParameterPack);
      if (ContainsUnexpandedParameterPack.$deref()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
    } else if (TemplateKWLoc.isValid()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::CXXDependentScopeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3184,
   FQN="clang::CXXDependentScopeMemberExpr::CXXDependentScopeMemberExpr", NM="_ZN5clang27CXXDependentScopeMemberExprC1ERKNS_10ASTContextEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocEPNS_9NamedDeclENS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExprC1ERKNS_10ASTContextEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocEPNS_9NamedDeclENS_19DeclarationNameInfoE")
  //</editor-fold>
  public CXXDependentScopeMemberExpr(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ Base, 
      QualType BaseType, boolean IsArrow, 
      SourceLocation OperatorLoc, 
      NestedNameSpecifierLoc QualifierLoc, 
      NamedDecl /*P*/ FirstQualifierFoundInScope, 
      DeclarationNameInfo MemberNameInfo) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1142,
   FQN="clang::CXXDependentScopeMemberExpr::Create", NM="_ZN5clang27CXXDependentScopeMemberExpr6CreateERKNS_10ASTContextEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_PNS_9NamedDeclENS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExpr6CreateERKNS_10ASTContextEPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_PNS_9NamedDeclENS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static CXXDependentScopeMemberExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        Expr /*P*/ Base, QualType BaseType, boolean IsArrow, 
        SourceLocation OperatorLoc, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        NamedDecl /*P*/ FirstQualifierFoundInScope, 
        DeclarationNameInfo MemberNameInfo, 
        /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
    boolean HasTemplateKWAndArgsInfo = (TemplateArgs != null) || TemplateKWLoc.isValid();
    /*uint*/int NumTemplateArgs = (TemplateArgs != null) ? TemplateArgs.size() : 0;
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), NumTemplateArgs);
    
    Object/*void P*/ _Mem;
    if (false) {
      _Mem = C.Allocate(Size, alignOf(CXXDependentScopeMemberExpr.class));
    } else {
      //ASTTemplateKWAndArgsInfo, TemplateArgumentLoc
      _Mem = C.Allocate$JavaRef(Size, alignOf(CXXDependentScopeMemberExpr.class),
              new std.pairIntPtr<>(1, ()->null), // for this
              new std.pairIntPtr<>(HasTemplateKWAndArgsInfo ? 1 : 0, ()->new ASTTemplateKWAndArgsInfo()),
              new std.pairIntPtr<>(NumTemplateArgs, ()->new TemplateArgumentLoc())
      );
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CXXDependentScopeMemberExpr(C, Base, new QualType(BaseType), 
                IsArrow, new SourceLocation(OperatorLoc), 
                new NestedNameSpecifierLoc(QualifierLoc), 
                new SourceLocation(TemplateKWLoc), 
                FirstQualifierFoundInScope, 
                new DeclarationNameInfo(MemberNameInfo), TemplateArgs);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1166,
   FQN="clang::CXXDependentScopeMemberExpr::CreateEmpty", NM="_ZN5clang27CXXDependentScopeMemberExpr11CreateEmptyERKNS_10ASTContextEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExpr11CreateEmptyERKNS_10ASTContextEbj")
  //</editor-fold>
  public static CXXDependentScopeMemberExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             boolean HasTemplateKWAndArgsInfo, 
             /*uint*/int NumTemplateArgs) {
    assert (NumTemplateArgs == 0 || HasTemplateKWAndArgsInfo);
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), NumTemplateArgs);
    Object/*void P*/ _Mem;
    if (false) {
      _Mem = C.Allocate(Size, alignOf(CXXDependentScopeMemberExpr.class));
    } else {
      _Mem = C.Allocate$JavaRef(Size, alignOf(CXXDependentScopeMemberExpr.class),
              new std.pairIntPtr<>(1, ()->null), // for this
              new std.pairIntPtr<>(HasTemplateKWAndArgsInfo ? 1 : 0, ()->new ASTTemplateKWAndArgsInfo()),
              new std.pairIntPtr<>(NumTemplateArgs, ()->new TemplateArgumentLoc())
      );
    }
    CXXDependentScopeMemberExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CXXDependentScopeMemberExpr(C, (Expr /*P*/ )null, new QualType(), 
                false, new SourceLocation(), 
                new NestedNameSpecifierLoc(), 
                new SourceLocation(), (NamedDecl /*P*/ )null, 
                new DeclarationNameInfo(), (/*const*/ TemplateArgumentListInfo /*P*/ )null);
     });
    E.HasTemplateKWAndArgsInfo = HasTemplateKWAndArgsInfo;
    return E;
  }

  
  /// \brief True if this is an implicit access, i.e. one in which the
  /// member being accessed was not written in the source.  The source
  /// location of the operator is invalid in this case.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::isImplicitAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1185,
   FQN="clang::CXXDependentScopeMemberExpr::isImplicitAccess", NM="_ZNK5clang27CXXDependentScopeMemberExpr16isImplicitAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr16isImplicitAccessEv")
  //</editor-fold>
  public boolean isImplicitAccess() /*const*/ {
    if (!(Base != null)) {
      return true;
    }
    
    return cast_Expr(Base).isImplicitCXXThis();
  }

  
  /// \brief Retrieve the base object of this member expressions,
  /// e.g., the \c x in \c x.m.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3209,
   FQN="clang::CXXDependentScopeMemberExpr::getBase", NM="_ZNK5clang27CXXDependentScopeMemberExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() /*const*/ {
    assert (!isImplicitAccess());
    return cast_Expr(Base);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3214,
   FQN="clang::CXXDependentScopeMemberExpr::getBaseType", NM="_ZNK5clang27CXXDependentScopeMemberExpr11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr11getBaseTypeEv")
  //</editor-fold>
  public QualType getBaseType() /*const*/ {
    return new QualType(BaseType);
  }

  
  /// \brief Determine whether this member expression used the '->'
  /// operator; otherwise, it used the '.' operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3218,
   FQN="clang::CXXDependentScopeMemberExpr::isArrow", NM="_ZNK5clang27CXXDependentScopeMemberExpr7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return IsArrow;
  }

  
  /// \brief Retrieve the location of the '->' or '.' operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3221,
   FQN="clang::CXXDependentScopeMemberExpr::getOperatorLoc", NM="_ZNK5clang27CXXDependentScopeMemberExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OperatorLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the member
  /// name.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3225,
   FQN="clang::CXXDependentScopeMemberExpr::getQualifier", NM="_ZNK5clang27CXXDependentScopeMemberExpr12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the member
  /// name, with source location information.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3231,
   FQN="clang::CXXDependentScopeMemberExpr::getQualifierLoc", NM="_ZNK5clang27CXXDependentScopeMemberExpr15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the first part of the nested-name-specifier that was
  /// found in the scope of the member access expression when the member access
  /// was initially parsed.
  ///
  /// This function only returns a useful result when member access expression
  /// uses a qualified member name, e.g., "x.Base::f". Here, the declaration
  /// returned by this function describes what was found by unqualified name
  /// lookup for the identifier "Base" within the scope of the member access
  /// expression itself. At template instantiation time, this information is
  /// combined with the results of name lookup into the type of the object
  /// expression itself (the class type of x).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getFirstQualifierFoundInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3245,
   FQN="clang::CXXDependentScopeMemberExpr::getFirstQualifierFoundInScope", NM="_ZNK5clang27CXXDependentScopeMemberExpr29getFirstQualifierFoundInScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr29getFirstQualifierFoundInScopeEv")
  //</editor-fold>
  public NamedDecl /*P*/ getFirstQualifierFoundInScope() /*const*/ {
    return FirstQualifierFoundInScope;
  }

  
  /// \brief Retrieve the name of the member that this expression
  /// refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getMemberNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3251,
   FQN="clang::CXXDependentScopeMemberExpr::getMemberNameInfo", NM="_ZNK5clang27CXXDependentScopeMemberExpr17getMemberNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr17getMemberNameInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameInfo /*&*/ getMemberNameInfo() /*const*/ {
    return MemberNameInfo;
  }

  
  /// \brief Retrieve the name of the member that this expression
  /// refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3257,
   FQN="clang::CXXDependentScopeMemberExpr::getMember", NM="_ZNK5clang27CXXDependentScopeMemberExpr9getMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr9getMemberEv")
  //</editor-fold>
  public DeclarationName getMember() /*const*/ {
    return MemberNameInfo.getName();
  }

  
  // \brief Retrieve the location of the name of the member that this
  // expression refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3261,
   FQN="clang::CXXDependentScopeMemberExpr::getMemberLoc", NM="_ZNK5clang27CXXDependentScopeMemberExpr12getMemberLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr12getMemberLocEv")
  //</editor-fold>
  public SourceLocation getMemberLoc() /*const*/ {
    return MemberNameInfo.getLoc();
  }

  
  /// \brief Retrieve the location of the template keyword preceding the
  /// member name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3265,
   FQN="clang::CXXDependentScopeMemberExpr::getTemplateKeywordLoc", NM="_ZNK5clang27CXXDependentScopeMemberExpr21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().TemplateKWLoc);
  }

  
  /// \brief Retrieve the location of the left angle bracket starting the
  /// explicit template argument list following the member name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3272,
   FQN="clang::CXXDependentScopeMemberExpr::getLAngleLoc", NM="_ZNK5clang27CXXDependentScopeMemberExpr12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().LAngleLoc);
  }

  
  /// \brief Retrieve the location of the right angle bracket ending the
  /// explicit template argument list following the member name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3279,
   FQN="clang::CXXDependentScopeMemberExpr::getRAngleLoc", NM="_ZNK5clang27CXXDependentScopeMemberExpr12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().RAngleLoc);
  }

  
  /// Determines whether the member name was preceded by the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::hasTemplateKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3285,
   FQN="clang::CXXDependentScopeMemberExpr::hasTemplateKeyword", NM="_ZNK5clang27CXXDependentScopeMemberExpr18hasTemplateKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr18hasTemplateKeywordEv")
  //</editor-fold>
  public boolean hasTemplateKeyword() /*const*/ {
    return getTemplateKeywordLoc().isValid();
  }

  
  /// \brief Determines whether this member expression actually had a C++
  /// template argument list explicitly specified, e.g., x.f<int>.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::hasExplicitTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3289,
   FQN="clang::CXXDependentScopeMemberExpr::hasExplicitTemplateArgs", NM="_ZNK5clang27CXXDependentScopeMemberExpr23hasExplicitTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr23hasExplicitTemplateArgsEv")
  //</editor-fold>
  public boolean hasExplicitTemplateArgs() /*const*/ {
    return getLAngleLoc().isValid();
  }

  
  /// \brief Copies the template arguments (if present) into the given
  /// structure.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::copyTemplateArgumentsInto">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3293,
   FQN="clang::CXXDependentScopeMemberExpr::copyTemplateArgumentsInto", NM="_ZNK5clang27CXXDependentScopeMemberExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void copyTemplateArgumentsInto(final TemplateArgumentListInfo /*&*/ List) /*const*/ {
    if (hasExplicitTemplateArgs()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().copyInto(this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class), List);
    }
  }

  
  /// \brief Retrieve the template arguments provided as part of this
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3301,
   FQN="clang::CXXDependentScopeMemberExpr::getTemplateArgs", NM="_ZNK5clang27CXXDependentScopeMemberExpr15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return null;
    }
    
    return this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class);
  }

  
  /// \brief Retrieve the number of template arguments provided as part of this
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getNumTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3310,
   FQN="clang::CXXDependentScopeMemberExpr::getNumTemplateArgs", NM="_ZNK5clang27CXXDependentScopeMemberExpr18getNumTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr18getNumTemplateArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return 0;
    }
    
    return this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().NumTemplateArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3317,
   FQN="clang::CXXDependentScopeMemberExpr::template_arguments", NM="_ZNK5clang27CXXDependentScopeMemberExpr18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgumentLoc> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgumentLoc>(getTemplateArgs(), getNumTemplateArgs(), false)/* }*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3321,
   FQN="clang::CXXDependentScopeMemberExpr::getLocStart", NM="_ZNK5clang27CXXDependentScopeMemberExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    if (!isImplicitAccess()) {
      return Base.getLocStart();
    }
    if ((getQualifier() != null)) {
      return getQualifierLoc().getBeginLoc();
    }
    return MemberNameInfo.getBeginLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3329,
   FQN="clang::CXXDependentScopeMemberExpr::getLocEnd", NM="_ZNK5clang27CXXDependentScopeMemberExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang27CXXDependentScopeMemberExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (hasExplicitTemplateArgs()) {
      return getRAngleLoc();
    }
    return MemberNameInfo.getEndLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3335,
   FQN="clang::CXXDependentScopeMemberExpr::classof", NM="_ZN5clang27CXXDependentScopeMemberExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXDependentScopeMemberExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDependentScopeMemberExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3340,
   FQN="clang::CXXDependentScopeMemberExpr::children", NM="_ZN5clang27CXXDependentScopeMemberExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang27CXXDependentScopeMemberExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if (isImplicitAccess()) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Base))), new StmtIterator(create_type$ptr($AddrOf(Base)).$add(1)));
  }

  
  /*friend  TrailingObjects<CXXDependentScopeMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>*/
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
  }
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ASTTemplateKWAndArgsInfo.class
            || clazz == TemplateArgumentLoc.class;
    if (clazz == ASTTemplateKWAndArgsInfo.class) {
      return 0;
    }
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", BaseType=" + BaseType // NOI18N
              + ", IsArrow=" + IsArrow // NOI18N
              + ", HasTemplateKWAndArgsInfo=" + HasTemplateKWAndArgsInfo // NOI18N
              + ", OperatorLoc=" + OperatorLoc // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", FirstQualifierFoundInScope=" + FirstQualifierFoundInScope // NOI18N
              + ", MemberNameInfo=" + MemberNameInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
