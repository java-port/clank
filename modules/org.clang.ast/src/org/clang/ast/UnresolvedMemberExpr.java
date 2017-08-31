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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.impl.ExprCXXStatics.*;
import org.clank.java.std;
import org.llvm.support.TrailingObjects.*;


/// \brief Represents a C++ member access expression for which lookup
/// produced a set of overloaded functions.
///
/// The member access may be explicit or implicit:
/// \code
///    struct A {
///      int a, b;
///      int explicitAccess() { return this->a + this->A::b; }
///      int implicitAccess() { return a + A::b; }
///    };
/// \endcode
///
/// In the final AST, an explicit access always becomes a MemberExpr.
/// An implicit access may become either a MemberExpr or a
/// DeclRefExpr, depending on whether the member is static.
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3366,
 FQN="clang::UnresolvedMemberExpr", NM="_ZN5clang20UnresolvedMemberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExprE")
//</editor-fold>
public final class UnresolvedMemberExpr extends /*public*/ OverloadExpr implements /*private*/ TrailingObjects2<UnresolvedMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc> {
  /// \brief Whether this member expression used the '->' operator or
  /// the '.' operator.
  /*friend*/public /*JBIT bool*/ boolean IsArrow /*: 1*/;
  
  /// \brief Whether the lookup results contain an unresolved using
  /// declaration.
  /*friend*/public /*JBIT bool*/ boolean HasUnresolvedUsing /*: 1*/;
  
  /// \brief The expression for the base pointer or class reference,
  /// e.g., the \c x in x.f.
  ///
  /// This can be null if this is an 'unbased' member expression.
  /*friend*/public Stmt /*P*/ Base;
  
  /// \brief The type of the base expression; never null.
  /*friend*/public QualType BaseType;
  
  /// \brief The location of the '->' or '.' operator.
  /*friend*/public SourceLocation OperatorLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3390,
   FQN="clang::UnresolvedMemberExpr::numTrailingObjects", NM="_ZNK5clang20UnresolvedMemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<ASTTemplateKWAndArgsInfo> $Prm0) /*const*/ {
    return HasTemplateKWAndArgsInfo ? 1 : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::UnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1209,
   FQN="clang::UnresolvedMemberExpr::UnresolvedMemberExpr", NM="_ZN5clang20UnresolvedMemberExprC1ERKNS_10ASTContextEbPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_RKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESF_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExprC1ERKNS_10ASTContextEbPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_RKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESF_")
  //</editor-fold>
  private UnresolvedMemberExpr(final /*const*/ ASTContext /*&*/ C, 
      boolean HasUnresolvedUsing, 
      Expr /*P*/ Base, QualType BaseType, 
      boolean IsArrow, 
      SourceLocation OperatorLoc, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateKWLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, 
      /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
      UnresolvedSetIterator Begin, 
      UnresolvedSetIterator End) {
    // : OverloadExpr(UnresolvedMemberExprClass, C, QualifierLoc, TemplateKWLoc, MemberNameInfo, TemplateArgs, Begin, End, ((Base && Base->isTypeDependent()) || BaseType->isDependentType()), ((Base && Base->isInstantiationDependent()) || BaseType->isInstantiationDependentType()), ((Base && Base->containsUnexpandedParameterPack()) || BaseType->containsUnexpandedParameterPack())), TrailingObjects<UnresolvedMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), IsArrow(IsArrow), HasUnresolvedUsing(HasUnresolvedUsing), Base(Base), BaseType(BaseType), OperatorLoc(OperatorLoc) 
    //START JInit
    super(StmtClass.UnresolvedMemberExprClass, C, new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateKWLoc), 
        MemberNameInfo, TemplateArgs, new UnresolvedSetIterator(Begin), new UnresolvedSetIterator(End), 
        // Dependent
        (((Base != null) && Base.isTypeDependent())
           || BaseType.$arrow().isDependentType()), 
        (((Base != null) && Base.isInstantiationDependent())
           || BaseType.$arrow().isInstantiationDependentType()), 
        // Contains unexpanded parameter pack
        (((Base != null) && Base.containsUnexpandedParameterPack())
           || BaseType.$arrow().containsUnexpandedParameterPack()));
    $TrailingObjects();
    this.IsArrow = IsArrow;
    this.HasUnresolvedUsing = HasUnresolvedUsing;
    this.Base = Base;
    this.BaseType = new QualType(BaseType);
    this.OperatorLoc = new SourceLocation(OperatorLoc);
    //END JInit
    
    // Check whether all of the members are non-static member functions,
    // and if so, mark give this bound-member type instead of overload type.
    if (hasOnlyNonStaticMemberFunctions(new UnresolvedSetIterator(Begin), new UnresolvedSetIterator(End))) {
      setType(C.BoundMemberTy.$QualType());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::UnresolvedMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3403,
   FQN="clang::UnresolvedMemberExpr::UnresolvedMemberExpr", NM="_ZN5clang20UnresolvedMemberExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private UnresolvedMemberExpr(EmptyShell Empty) {
    // : OverloadExpr(UnresolvedMemberExprClass, Empty), TrailingObjects<UnresolvedMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), IsArrow(false), HasUnresolvedUsing(false), Base(null), BaseType(), OperatorLoc() 
    //START JInit
    super(StmtClass.UnresolvedMemberExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.IsArrow = false;
    this.HasUnresolvedUsing = false;
    this.Base = null;
    this.BaseType = new QualType();
    this.OperatorLoc = new SourceLocation();
    //END JInit
  }

  
  /*friend  TrailingObjects<UnresolvedMemberExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>*/
  /*friend  class OverloadExpr*/
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1246,
   FQN="clang::UnresolvedMemberExpr::Create", NM="_ZN5clang20UnresolvedMemberExpr6CreateERKNS_10ASTContextEbPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_RKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESF_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExpr6CreateERKNS_10ASTContextEbPNS_4ExprENS_8QualTypeEbNS_14SourceLocationENS_22NestedNameSpecifierLocES7_RKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESF_")
  //</editor-fold>
  public static UnresolvedMemberExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, boolean HasUnresolvedUsing, Expr /*P*/ Base, QualType BaseType, 
        boolean IsArrow, SourceLocation OperatorLoc, 
        NestedNameSpecifierLoc QualifierLoc, SourceLocation TemplateKWLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ MemberNameInfo, 
        /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, UnresolvedSetIterator Begin, 
        UnresolvedSetIterator End) {
    boolean HasTemplateKWAndArgsInfo = (TemplateArgs != null) || TemplateKWLoc.isValid();
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), (TemplateArgs != null) ? TemplateArgs.size() : 0);
    
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size, alignOf(UnresolvedMemberExpr.class),
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>((HasTemplateKWAndArgsInfo ? 1 : 0), ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>((TemplateArgs != null) ? TemplateArgs.size() : 0, ()->new TemplateArgumentLoc())
    );
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new UnresolvedMemberExpr(C, HasUnresolvedUsing, Base, new QualType(BaseType), IsArrow, new SourceLocation(OperatorLoc), new NestedNameSpecifierLoc(QualifierLoc), 
                new SourceLocation(TemplateKWLoc), MemberNameInfo, TemplateArgs, new UnresolvedSetIterator(Begin), new UnresolvedSetIterator(End));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1264,
   FQN="clang::UnresolvedMemberExpr::CreateEmpty", NM="_ZN5clang20UnresolvedMemberExpr11CreateEmptyERKNS_10ASTContextEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExpr11CreateEmptyERKNS_10ASTContextEbj")
  //</editor-fold>
  public static UnresolvedMemberExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             boolean HasTemplateKWAndArgsInfo, 
             /*uint*/int NumTemplateArgs) {
    assert (NumTemplateArgs == 0 || HasTemplateKWAndArgsInfo);
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), NumTemplateArgs);
    
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size, alignOf(UnresolvedMemberExpr.class),
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>((HasTemplateKWAndArgsInfo ? 1 : 0), ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>(NumTemplateArgs, ()->new TemplateArgumentLoc())
    );
    UnresolvedMemberExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new UnresolvedMemberExpr(new EmptyShell());
     });
    E.HasTemplateKWAndArgsInfo = HasTemplateKWAndArgsInfo;
    return E;
  }

  
  /// \brief True if this is an implicit access, i.e., one in which the
  /// member being accessed was not written in the source.
  ///
  /// The source location of the operator is invalid in this case.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::isImplicitAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1239,
   FQN="clang::UnresolvedMemberExpr::isImplicitAccess", NM="_ZNK5clang20UnresolvedMemberExpr16isImplicitAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr16isImplicitAccessEv")
  //</editor-fold>
  public boolean isImplicitAccess() /*const*/ {
    if (!(Base != null)) {
      return true;
    }
    
    return cast_Expr(Base).isImplicitCXXThis();
  }

  
  /// \brief Retrieve the base object of this member expressions,
  /// e.g., the \c x in \c x.m.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3434,
   FQN="clang::UnresolvedMemberExpr::getBase", NM="_ZN5clang20UnresolvedMemberExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() {
    assert (!isImplicitAccess());
    return cast_Expr(Base);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3438,
   FQN="clang::UnresolvedMemberExpr::getBase", NM="_ZNK5clang20UnresolvedMemberExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr7getBaseEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getBase$Const() /*const*/ {
    assert (!isImplicitAccess());
    return cast_Expr(Base);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3443,
   FQN="clang::UnresolvedMemberExpr::getBaseType", NM="_ZNK5clang20UnresolvedMemberExpr11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr11getBaseTypeEv")
  //</editor-fold>
  public QualType getBaseType() /*const*/ {
    return new QualType(BaseType);
  }

  
  /// \brief Determine whether the lookup results contain an unresolved using
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::hasUnresolvedUsing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3447,
   FQN="clang::UnresolvedMemberExpr::hasUnresolvedUsing", NM="_ZNK5clang20UnresolvedMemberExpr18hasUnresolvedUsingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr18hasUnresolvedUsingEv")
  //</editor-fold>
  public boolean hasUnresolvedUsing() /*const*/ {
    return HasUnresolvedUsing;
  }

  
  /// \brief Determine whether this member expression used the '->'
  /// operator; otherwise, it used the '.' operator.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3451,
   FQN="clang::UnresolvedMemberExpr::isArrow", NM="_ZNK5clang20UnresolvedMemberExpr7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return IsArrow;
  }

  
  /// \brief Retrieve the location of the '->' or '.' operator.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3454,
   FQN="clang::UnresolvedMemberExpr::getOperatorLoc", NM="_ZNK5clang20UnresolvedMemberExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OperatorLoc);
  }

  
  /// \brief Retrieve the naming class of this lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1279,
   FQN="clang::UnresolvedMemberExpr::getNamingClass", NM="_ZNK5clang20UnresolvedMemberExpr14getNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr14getNamingClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getNamingClass() /*const*/ {
    // Unlike for UnresolvedLookupExpr, it is very easy to re-derive this.
    
    // If there was a nested name specifier, it names the naming class.
    // It can't be dependent: after all, we were actually able to do the
    // lookup.
    CXXRecordDecl /*P*/ Record = null;
    NestedNameSpecifier /*P*/ NNS = getQualifier();
    if ((NNS != null) && NNS.getKind() != NestedNameSpecifier.SpecifierKind.Super) {
      /*const*/ Type /*P*/ T = getQualifier().getAsType();
      assert ((T != null)) : "qualifier in member expression does not name type";
      Record = T.getAsCXXRecordDecl();
      assert ((Record != null)) : "qualifier in member expression does not name record";
    } else {
      QualType BaseType = getBaseType().getNonReferenceType();
      if (isArrow()) {
        /*const*/ PointerType /*P*/ PT = BaseType.$arrow().getAs(PointerType.class);
        assert ((PT != null)) : "base of arrow member access is not pointer";
        BaseType.$assignMove(PT.getPointeeType());
      }
      
      Record = BaseType.$arrow().getAsCXXRecordDecl();
      assert ((Record != null)) : "base of member expression does not name record";
    }
    
    return Record;
  }

  
  /// \brief Retrieve the full name info for the member that this expression
  /// refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getMemberNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3461,
   FQN="clang::UnresolvedMemberExpr::getMemberNameInfo", NM="_ZNK5clang20UnresolvedMemberExpr17getMemberNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr17getMemberNameInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameInfo /*&*/ getMemberNameInfo() /*const*/ {
    return getNameInfo();
  }

  
  /// \brief Retrieve the name of the member that this expression
  /// refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getMemberName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3465,
   FQN="clang::UnresolvedMemberExpr::getMemberName", NM="_ZNK5clang20UnresolvedMemberExpr13getMemberNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr13getMemberNameEv")
  //</editor-fold>
  public DeclarationName getMemberName() /*const*/ {
    return getName();
  }

  
  // \brief Retrieve the location of the name of the member that this
  // expression refers to.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3469,
   FQN="clang::UnresolvedMemberExpr::getMemberLoc", NM="_ZNK5clang20UnresolvedMemberExpr12getMemberLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr12getMemberLocEv")
  //</editor-fold>
  public SourceLocation getMemberLoc() /*const*/ {
    return getNameLoc();
  }

  
  // \brief Return the preferred location (the member name) for the arrow when
  // diagnosing a problem with this expression.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3473,
   FQN="clang::UnresolvedMemberExpr::getExprLoc", NM="_ZNK5clang20UnresolvedMemberExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return getMemberLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3475,
   FQN="clang::UnresolvedMemberExpr::getLocStart", NM="_ZNK5clang20UnresolvedMemberExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    if (!isImplicitAccess()) {
      return Base.getLocStart();
    }
    {
      NestedNameSpecifierLoc l = getQualifierLoc();
      if (l.$bool()) {
        return l.getBeginLoc();
      }
    }
    return getMemberNameInfo().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3482,
   FQN="clang::UnresolvedMemberExpr::getLocEnd", NM="_ZNK5clang20UnresolvedMemberExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedMemberExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (hasExplicitTemplateArgs()) {
      return getRAngleLoc();
    }
    return getMemberNameInfo().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3488,
   FQN="clang::UnresolvedMemberExpr::classof", NM="_ZN5clang20UnresolvedMemberExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.UnresolvedMemberExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedMemberExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3493,
   FQN="clang::UnresolvedMemberExpr::children", NM="_ZN5clang20UnresolvedMemberExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedMemberExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    if (isImplicitAccess()) {
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Base))), new StmtIterator(create_type$ptr($AddrOf(Base)).$add(1)));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
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
    return "" + "IsArrow=" + IsArrow // NOI18N
              + ", HasUnresolvedUsing=" + HasUnresolvedUsing // NOI18N
              + ", Base=" + Base // NOI18N
              + ", BaseType=" + BaseType // NOI18N
              + ", OperatorLoc=" + OperatorLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
