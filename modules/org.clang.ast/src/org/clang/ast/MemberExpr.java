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
import static org.clang.ast.DeclarationName.*;
import org.clank.java.std;
import org.llvm.adt.java.TrailingObjectsUtils;
import org.llvm.support.TrailingObjects.*;


/// MemberExpr - [C99 6.5.2.3] Structure and Union Members.  X->F and X.F.
///
//<editor-fold defaultstate="collapsed" desc="clang::MemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2315,
 FQN="clang::MemberExpr", NM="_ZN5clang10MemberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExprE")
//</editor-fold>
public final class MemberExpr extends /*public*/ Expr implements /*private*/ TrailingObjects3<MemberExpr, MemberExprNameQualifier, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc> {
  /// Base - the expression for the base pointer or structure references.  In
  /// X.F, this is "X".
  private Stmt /*P*/ Base;
  
  /// MemberDecl - This is the decl being referenced by the field/member name.
  /// In X.F, this is the decl referenced by F.
  private ValueDecl /*P*/ MemberDecl;
  
  /// MemberDNLoc - Provides source/type location info for the
  /// declaration name embedded in MemberDecl.
  /*friend*/public DeclarationNameLoc MemberDNLoc;
  
  /// MemberLoc - This is the location of the member name.
  private SourceLocation MemberLoc;
  
  /// This is the location of the -> or . in the expression.
  private SourceLocation OperatorLoc;
  
  /// IsArrow - True if this is "X->F", false if this is "X.F".
  private /*JBIT bool*/ boolean IsArrow /*: 1*/;
  
  /// \brief True if this member expression used a nested-name-specifier to
  /// refer to the member, e.g., "x->Base::f", or found its member via a using
  /// declaration.  When true, a MemberExprNameQualifier
  /// structure is allocated immediately after the MemberExpr.
  private /*JBIT bool*/ boolean HasQualifierOrFoundDecl /*: 1*/;
  
  /// \brief True if this member expression specified a template keyword
  /// and/or a template argument list explicitly, e.g., x->f<int>,
  /// x->template f, x->template f<int>.
  /// When true, an ASTTemplateKWAndArgsInfo structure and its
  /// TemplateArguments (if any) are present.
  /*friend*/public /*JBIT bool*/ boolean HasTemplateKWAndArgsInfo /*: 1*/;
  
  /// \brief True if this member expression refers to a method that
  /// was resolved from an overloaded set having size greater than 1.
  private /*JBIT bool*/ boolean HadMultipleCandidates /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2358,
   FQN="clang::MemberExpr::numTrailingObjects", NM="_ZNK5clang10MemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_23MemberExprNameQualifierEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_23MemberExprNameQualifierEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$MemberExprNameQualifier(OverloadToken<MemberExprNameQualifier> $Prm0) /*const*/ {
    return HasQualifierOrFoundDecl ? 1 : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2362,
   FQN="clang::MemberExpr::numTrailingObjects", NM="_ZNK5clang10MemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$ASTTemplateKWAndArgsInfo(OverloadToken<ASTTemplateKWAndArgsInfo> $Prm0) /*const*/ {
    return HasTemplateKWAndArgsInfo ? 1 : 0;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::MemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2367,
   FQN="clang::MemberExpr::MemberExpr", NM="_ZN5clang10MemberExprC1EPNS_4ExprEbNS_14SourceLocationEPNS_9ValueDeclERKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExprC1EPNS_4ExprEbNS_14SourceLocationEPNS_9ValueDeclERKNS_19DeclarationNameInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE")
  //</editor-fold>
  public MemberExpr(Expr /*P*/ base, boolean isarrow, SourceLocation operatorloc, 
      ValueDecl /*P*/ memberdecl, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      QualType ty, ExprValueKind VK, ExprObjectKind OK) {
    // : Expr(MemberExprClass, ty, VK, OK, base->isTypeDependent(), base->isValueDependent(), base->isInstantiationDependent(), base->containsUnexpandedParameterPack()), TrailingObjects<MemberExpr, MemberExprNameQualifier, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), Base(base), MemberDecl(memberdecl), MemberDNLoc(NameInfo.getInfo()), MemberLoc(NameInfo.getLoc()), OperatorLoc(operatorloc), IsArrow(isarrow), HasQualifierOrFoundDecl(false), HasTemplateKWAndArgsInfo(false), HadMultipleCandidates(false) 
    //START JInit
    super(StmtClass.MemberExprClass, new QualType(ty), VK, OK, base.isTypeDependent(), 
        base.isValueDependent(), base.isInstantiationDependent(), 
        base.containsUnexpandedParameterPack());
    $TrailingObjects();
    this.Base = base;
    this.MemberDecl = memberdecl;
    this.MemberDNLoc = new DeclarationNameLoc(NameInfo.getInfo$Const());
    this.MemberLoc = NameInfo.getLoc();
    this.OperatorLoc = new SourceLocation(operatorloc);
    this.IsArrow = isarrow;
    this.HasQualifierOrFoundDecl = false;
    this.HasTemplateKWAndArgsInfo = false;
    this.HadMultipleCandidates = false;
    //END JInit
    assert ($eq_DeclarationName(memberdecl.getDeclName(), NameInfo.getName()));
  }

  
  // NOTE: this constructor should be used only when it is known that
  // the member name can not provide additional syntactic info
  // (i.e., source locations for C++ operator names or type source info
  // for constructors, destructors and conversion operators).
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::MemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2384,
   FQN="clang::MemberExpr::MemberExpr", NM="_ZN5clang10MemberExprC1EPNS_4ExprEbNS_14SourceLocationEPNS_9ValueDeclES3_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExprC1EPNS_4ExprEbNS_14SourceLocationEPNS_9ValueDeclES3_NS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE")
  //</editor-fold>
  public MemberExpr(Expr /*P*/ base, boolean isarrow, SourceLocation operatorloc, 
      ValueDecl /*P*/ memberdecl, SourceLocation l, QualType ty, 
      ExprValueKind VK, ExprObjectKind OK) {
    // : Expr(MemberExprClass, ty, VK, OK, base->isTypeDependent(), base->isValueDependent(), base->isInstantiationDependent(), base->containsUnexpandedParameterPack()), TrailingObjects<MemberExpr, MemberExprNameQualifier, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), Base(base), MemberDecl(memberdecl), MemberDNLoc(), MemberLoc(l), OperatorLoc(operatorloc), IsArrow(isarrow), HasQualifierOrFoundDecl(false), HasTemplateKWAndArgsInfo(false), HadMultipleCandidates(false) 
    //START JInit
    super(StmtClass.MemberExprClass, new QualType(ty), VK, OK, base.isTypeDependent(), 
        base.isValueDependent(), base.isInstantiationDependent(), 
        base.containsUnexpandedParameterPack());
    $TrailingObjects();
    this.Base = base;
    this.MemberDecl = memberdecl;
    this.MemberDNLoc = new DeclarationNameLoc();
    this.MemberLoc = new SourceLocation(l);
    this.OperatorLoc = new SourceLocation(operatorloc);
    this.IsArrow = isarrow;
    this.HasQualifierOrFoundDecl = false;
    this.HasTemplateKWAndArgsInfo = false;
    this.HadMultipleCandidates = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1402,
   FQN="clang::MemberExpr::Create", NM="_ZN5clang10MemberExpr6CreateERKNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationENS_22NestedNameSpecifierLocES6_PNS_9ValueDeclENS_14DeclAccessPairENS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr6CreateERKNS_10ASTContextEPNS_4ExprEbNS_14SourceLocationENS_22NestedNameSpecifierLocES6_PNS_9ValueDeclENS_14DeclAccessPairENS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_8QualTypeENS_13ExprValueKindENS_14ExprObjectKindE")
  //</editor-fold>
  public static MemberExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ base, boolean isarrow, SourceLocation OperatorLoc, 
        NestedNameSpecifierLoc QualifierLoc, SourceLocation TemplateKWLoc, 
        ValueDecl /*P*/ memberdecl, DeclAccessPair founddecl, 
        DeclarationNameInfo nameinfo, /*const*/ TemplateArgumentListInfo /*P*/ targs, 
        QualType ty, ExprValueKind vk, ExprObjectKind ok) {
    
    boolean hasQualOrFound = (QualifierLoc.$bool()
       || founddecl.getDecl() != memberdecl
       || founddecl.getAccess() != memberdecl.getAccess());
    
    boolean HasTemplateKWAndArgsInfo = (targs != null) || TemplateKWLoc.isValid();
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(MemberExprNameQualifier.class, ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, hasQualOrFound ? 1 : 0, HasTemplateKWAndArgsInfo ? 1 : 0, (targs != null) ? targs.size() : 0);
    
    // JAVA: MEMORY
    type$ptr<?> Mem;
    if (false) {
      /*void P*/ Mem = (type$ptr)(Object)C.Allocate(Size, alignOf(MemberExpr.class));
    } else {
      Mem = C.Allocate$JavaRef(Size, 1,
              new std.pairIntPtr<>(1, ()->null), // this
              new std.pairIntPtr<>(hasQualOrFound ? 1 : 0, ()->new MemberExprNameQualifier()), // MemberExprNameQualifier
              new std.pairIntPtr<>(HasTemplateKWAndArgsInfo ? 1 : 0, ()->new ASTTemplateKWAndArgsInfo()), // ASTTemplateKWAndArgsInfo
              new std.pairIntPtr<>((targs != null) ? targs.size() : 0, ()->new TemplateArgumentLoc()) // TemplateArgumentLoc
      );
    }
    MemberExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new MemberExpr(base, isarrow, new SourceLocation(OperatorLoc), memberdecl, nameinfo, new QualType(ty), vk, ok);
     });
    if (hasQualOrFound) {
      // FIXME: Wrong. We should be looking at the member declaration we found.
      if (QualifierLoc.$bool() && QualifierLoc.getNestedNameSpecifier().isDependent()) {
        E.setValueDependent(true);
        E.setTypeDependent(true);
        E.setInstantiationDependent(true);
      } else if (QualifierLoc.$bool()
         && QualifierLoc.getNestedNameSpecifier().isInstantiationDependent()) {
        E.setInstantiationDependent(true);
      }
      
      E.HasQualifierOrFoundDecl = true;
      
      type$ptr<MemberExprNameQualifier /*P*/> NQ = E.<MemberExprNameQualifier>getTrailingObjects(MemberExprNameQualifier.class);
      NQ.$star().QualifierLoc.$assign(QualifierLoc);
      NQ.$star().FoundDecl.$assign(founddecl);
    }
    
    E.HasTemplateKWAndArgsInfo = ((targs != null) || TemplateKWLoc.isValid());
    if ((targs != null)) {
      bool$ref Dependent = create_bool$ref(false);
      bool$ref InstantiationDependent = create_bool$ref(false);
      bool$ref ContainsUnexpandedParameterPack = create_bool$ref(false);
      E.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc), $Deref(targs), E.<TemplateArgumentLoc>getTrailingObjects(TemplateArgumentLoc.class), 
          Dependent, InstantiationDependent, ContainsUnexpandedParameterPack);
      if (InstantiationDependent.$deref()) {
        E.setInstantiationDependent(true);
      }
    } else if (TemplateKWLoc.isValid()) {
      E.<ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star().initializeFrom(new SourceLocation(TemplateKWLoc));
    }
    
    return E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2404,
   FQN="clang::MemberExpr::setBase", NM="_ZN5clang10MemberExpr7setBaseEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr7setBaseEPNS_4ExprE")
  //</editor-fold>
  public void setBase(Expr /*P*/ E) {
    Base = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2405,
   FQN="clang::MemberExpr::getBase", NM="_ZNK5clang10MemberExpr7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr7getBaseEv")
  //</editor-fold>
  public Expr /*P*/ getBase() /*const*/ {
    return cast_Expr(Base);
  }

  
  /// \brief Retrieve the member declaration to which this expression refers.
  ///
  /// The returned declaration will either be a FieldDecl or (in C++)
  /// a CXXMethodDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getMemberDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2411,
   FQN="clang::MemberExpr::getMemberDecl", NM="_ZNK5clang10MemberExpr13getMemberDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr13getMemberDeclEv")
  //</editor-fold>
  public ValueDecl /*P*/ getMemberDecl() /*const*/ {
    return MemberDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::setMemberDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2412,
   FQN="clang::MemberExpr::setMemberDecl", NM="_ZN5clang10MemberExpr13setMemberDeclEPNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr13setMemberDeclEPNS_9ValueDeclE")
  //</editor-fold>
  public void setMemberDecl(ValueDecl /*P*/ D) {
    MemberDecl = D;
  }

  
  /// \brief Retrieves the declaration found by lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getFoundDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2415,
   FQN="clang::MemberExpr::getFoundDecl", NM="_ZNK5clang10MemberExpr12getFoundDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr12getFoundDeclEv")
  //</editor-fold>
  public DeclAccessPair getFoundDecl() /*const*/ {
    if (!HasQualifierOrFoundDecl) {
      return DeclAccessPair.make(getMemberDecl(), 
          getMemberDecl().getAccess());
    }
    return new DeclAccessPair(this.<MemberExprNameQualifier>getTrailingObjects$Const(MemberExprNameQualifier.class).$star().FoundDecl);
  }

  
  /// \brief Determines whether this member expression actually had
  /// a C++ nested-name-specifier prior to the name of the member, e.g.,
  /// x->Base::foo.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::hasQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2425,
   FQN="clang::MemberExpr::hasQualifier", NM="_ZNK5clang10MemberExpr12hasQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr12hasQualifierEv")
  //</editor-fold>
  public boolean hasQualifier() /*const*/ {
    return getQualifier() != null;
  }

  
  /// \brief If the member name was qualified, retrieves the
  /// nested-name-specifier that precedes the member name, with source-location
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getQualifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2430,
   FQN="clang::MemberExpr::getQualifierLoc", NM="_ZNK5clang10MemberExpr15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    if (!HasQualifierOrFoundDecl) {
      return new NestedNameSpecifierLoc();
    }
    
    return new NestedNameSpecifierLoc(this.<MemberExprNameQualifier>getTrailingObjects$Const(MemberExprNameQualifier.class).$star().QualifierLoc);
  }

  
  /// \brief If the member name was qualified, retrieves the
  /// nested-name-specifier that precedes the member name. Otherwise, returns
  /// NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2440,
   FQN="clang::MemberExpr::getQualifier", NM="_ZNK5clang10MemberExpr12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return getQualifierLoc().getNestedNameSpecifier();
  }

  
  /// \brief Retrieve the location of the template keyword preceding
  /// the member name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2446,
   FQN="clang::MemberExpr::getTemplateKeywordLoc", NM="_ZNK5clang10MemberExpr21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().TemplateKWLoc);
  }

  
  /// \brief Retrieve the location of the left angle bracket starting the
  /// explicit template argument list following the member name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2453,
   FQN="clang::MemberExpr::getLAngleLoc", NM="_ZNK5clang10MemberExpr12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().LAngleLoc);
  }

  
  /// \brief Retrieve the location of the right angle bracket ending the
  /// explicit template argument list following the member name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2460,
   FQN="clang::MemberExpr::getRAngleLoc", NM="_ZNK5clang10MemberExpr12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().RAngleLoc);
  }

  
  /// Determines whether the member name was preceded by the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::hasTemplateKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2466,
   FQN="clang::MemberExpr::hasTemplateKeyword", NM="_ZNK5clang10MemberExpr18hasTemplateKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr18hasTemplateKeywordEv")
  //</editor-fold>
  public boolean hasTemplateKeyword() /*const*/ {
    return getTemplateKeywordLoc().isValid();
  }

  
  /// \brief Determines whether the member name was followed by an
  /// explicit template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::hasExplicitTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2470,
   FQN="clang::MemberExpr::hasExplicitTemplateArgs", NM="_ZNK5clang10MemberExpr23hasExplicitTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr23hasExplicitTemplateArgsEv")
  //</editor-fold>
  public boolean hasExplicitTemplateArgs() /*const*/ {
    return getLAngleLoc().isValid();
  }

  
  /// \brief Copies the template arguments (if present) into the given
  /// structure.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::copyTemplateArgumentsInto">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2474,
   FQN="clang::MemberExpr::copyTemplateArgumentsInto", NM="_ZNK5clang10MemberExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void copyTemplateArgumentsInto(final TemplateArgumentListInfo /*&*/ List) /*const*/ {
    if (hasExplicitTemplateArgs()) {
      this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().copyInto(this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class), List);
    }
  }

  
  /// \brief Retrieve the template arguments provided as part of this
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2482,
   FQN="clang::MemberExpr::getTemplateArgs", NM="_ZNK5clang10MemberExpr15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return null;
    }
    
    return this.<TemplateArgumentLoc>getTrailingObjects$Const(TemplateArgumentLoc.class);
  }

  
  /// \brief Retrieve the number of template arguments provided as part of this
  /// template-id.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getNumTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2491,
   FQN="clang::MemberExpr::getNumTemplateArgs", NM="_ZNK5clang10MemberExpr18getNumTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr18getNumTemplateArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return 0;
    }
    
    return this.<ASTTemplateKWAndArgsInfo>getTrailingObjects$Const(ASTTemplateKWAndArgsInfo.class).$star().NumTemplateArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2498,
   FQN="clang::MemberExpr::template_arguments", NM="_ZNK5clang10MemberExpr18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgumentLoc> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgumentLoc>(getTemplateArgs(), getNumTemplateArgs(), false)/* }*/;
  }

  
  /// \brief Retrieve the member declaration name info.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getMemberNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2503,
   FQN="clang::MemberExpr::getMemberNameInfo", NM="_ZNK5clang10MemberExpr17getMemberNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr17getMemberNameInfoEv")
  //</editor-fold>
  public DeclarationNameInfo getMemberNameInfo() /*const*/ {
    return new DeclarationNameInfo(MemberDecl.getDeclName(), 
        new SourceLocation(MemberLoc), new DeclarationNameLoc(MemberDNLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2508,
   FQN="clang::MemberExpr::getOperatorLoc", NM="_ZNK5clang10MemberExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(OperatorLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::isArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2510,
   FQN="clang::MemberExpr::isArrow", NM="_ZNK5clang10MemberExpr7isArrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr7isArrowEv")
  //</editor-fold>
  public boolean isArrow() /*const*/ {
    return IsArrow;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::setArrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2511,
   FQN="clang::MemberExpr::setArrow", NM="_ZN5clang10MemberExpr8setArrowEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr8setArrowEb")
  //</editor-fold>
  public void setArrow(boolean A) {
    IsArrow = A;
  }

  
  /// getMemberLoc - Return the location of the "member", in X->F, it is the
  /// location of 'F'.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2515,
   FQN="clang::MemberExpr::getMemberLoc", NM="_ZNK5clang10MemberExpr12getMemberLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr12getMemberLocEv")
  //</editor-fold>
  public SourceLocation getMemberLoc() /*const*/ {
    return new SourceLocation(MemberLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::setMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2516,
   FQN="clang::MemberExpr::setMemberLoc", NM="_ZN5clang10MemberExpr12setMemberLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr12setMemberLocENS_14SourceLocationE")
  //</editor-fold>
  public void setMemberLoc(SourceLocation L) {
    MemberLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1462,
   FQN="clang::MemberExpr::getLocStart", NM="_ZNK5clang10MemberExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    if (isImplicitAccess()) {
      if (hasQualifier()) {
        return getQualifierLoc().getBeginLoc();
      }
      return new SourceLocation(MemberLoc);
    }
    
    // FIXME: We don't want this to happen. Rather, we should be able to
    // detect all kinds of implicit accesses more cleanly.
    SourceLocation BaseStartLoc = getBase().getLocStart();
    if (BaseStartLoc.isValid()) {
      return BaseStartLoc;
    }
    return new SourceLocation(MemberLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1476,
   FQN="clang::MemberExpr::getLocEnd", NM="_ZNK5clang10MemberExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    SourceLocation EndLoc = getMemberNameInfo().getEndLoc();
    if (hasExplicitTemplateArgs()) {
      EndLoc.$assignMove(getRAngleLoc());
    } else if (EndLoc.isInvalid()) {
      EndLoc.$assignMove(getBase().getLocEnd());
    }
    return EndLoc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2521,
   FQN="clang::MemberExpr::getExprLoc", NM="_ZNK5clang10MemberExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(MemberLoc);
  }

  
  /// \brief Determine whether the base of this explicit is implicit.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::isImplicitAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2524,
   FQN="clang::MemberExpr::isImplicitAccess", NM="_ZNK5clang10MemberExpr16isImplicitAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr16isImplicitAccessEv")
  //</editor-fold>
  public boolean isImplicitAccess() /*const*/ {
    return (getBase() != null) && getBase().isImplicitCXXThis();
  }

  
  /// \brief Returns true if this member expression refers to a method that
  /// was resolved from an overloaded set having size greater than 1.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::hadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2530,
   FQN="clang::MemberExpr::hadMultipleCandidates", NM="_ZNK5clang10MemberExpr21hadMultipleCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr21hadMultipleCandidatesEv")
  //</editor-fold>
  public boolean hadMultipleCandidates() /*const*/ {
    return HadMultipleCandidates;
  }

  /// \brief Sets the flag telling whether this expression refers to
  /// a method that was resolved from an overloaded set having size
  /// greater than 1.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::setHadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2536,
   FQN="clang::MemberExpr::setHadMultipleCandidates", NM="_ZN5clang10MemberExpr24setHadMultipleCandidatesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr24setHadMultipleCandidatesEb")
  //</editor-fold>
  public void setHadMultipleCandidates() {
    setHadMultipleCandidates(true);
  }
  public void setHadMultipleCandidates(boolean V/*= true*/) {
    HadMultipleCandidates = V;
  }

  
  /// \brief Returns true if virtual dispatch is performed.
  /// If the member access is fully qualified, (i.e. X::f()), virtual
  /// dispatching is not performed. In -fapple-kext mode qualified
  /// calls to virtual method will still go through the vtable.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::performsVirtualDispatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2544,
   FQN="clang::MemberExpr::performsVirtualDispatch", NM="_ZNK5clang10MemberExpr23performsVirtualDispatchERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10MemberExpr23performsVirtualDispatchERKNS_11LangOptionsE")
  //</editor-fold>
  public boolean performsVirtualDispatch(final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    return LO.AppleKext || !hasQualifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2548,
   FQN="clang::MemberExpr::classof", NM="_ZN5clang10MemberExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.MemberExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::MemberExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2553,
   FQN="clang::MemberExpr::children", NM="_ZN5clang10MemberExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10MemberExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Base))), new StmtIterator(create_type$ptr($AddrOf(Base)).$add(1)));
  }

  
  /*friend  TrailingObjects<MemberExpr, MemberExprNameQualifier, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>*/
  /*friend  class ASTReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects_OverloadToken$MemberExprNameQualifier((OverloadToken<MemberExprNameQualifier>)null); 
  }
  
  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { 
    return numTrailingObjects_OverloadToken$ASTTemplateKWAndArgsInfo((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
  }
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == MemberExprNameQualifier.class
            || clazz == ASTTemplateKWAndArgsInfo.class
            || clazz == TemplateArgumentLoc.class;
    if (clazz == MemberExprNameQualifier.class) {
      return 0;
    } else if (clazz == ASTTemplateKWAndArgsInfo.class) {
      return getNumTailingObject_OverloadToken$TrailingTy1();
    }
    return getNumTailingObject_OverloadToken$TrailingTy1() + getNumTailingObject_OverloadToken$TrailingTy2();
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", MemberDecl=" + MemberDecl // NOI18N
              + ", MemberDNLoc=" + MemberDNLoc // NOI18N
              + ", MemberLoc=" + MemberLoc // NOI18N
              + ", OperatorLoc=" + OperatorLoc // NOI18N
              + ", IsArrow=" + IsArrow // NOI18N
              + ", HasQualifierOrFoundDecl=" + HasQualifierOrFoundDecl // NOI18N
              + ", HasTemplateKWAndArgsInfo=" + HasTemplateKWAndArgsInfo // NOI18N
              + ", HadMultipleCandidates=" + HadMultipleCandidates // NOI18N
              + super.toString(); // NOI18N
  }
}
