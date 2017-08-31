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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief A reference to an overloaded function set, either an
/// \c UnresolvedLookupExpr or an \c UnresolvedMemberExpr.
//<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*TrailingObjects*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2483,
 FQN="clang::OverloadExpr", NM="_ZN5clang12OverloadExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExprE")
//</editor-fold>
public abstract class OverloadExpr extends /*public*/ Expr {
  /// \brief The common name of these declarations.
  /*friend*/public DeclarationNameInfo NameInfo;
  
  /// \brief The nested-name-specifier that qualifies the name, if any.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// The results.  These are undesugared, which is to say, they may
  /// include UsingShadowDecls.  Access is relative to the naming
  /// class.
  // FIXME: Allocate this data after the OverloadExpr subclass.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<DeclAccessPair /*P*/> Results;
  private /*uint*/int NumResults;
/*protected:*/
  /// \brief Whether the name includes info for explicit template
  /// keyword and arguments.
  /*friend*/public boolean HasTemplateKWAndArgsInfo;
  
  /// \brief Return the optional template keyword and arguments info.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getTrailingASTTemplateKWAndArgsInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3500,
   FQN="clang::OverloadExpr::getTrailingASTTemplateKWAndArgsInfo", NM="_ZN5clang12OverloadExpr35getTrailingASTTemplateKWAndArgsInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr35getTrailingASTTemplateKWAndArgsInfoEv")
  //</editor-fold>
  /*friend*/public /*inline*/ ASTTemplateKWAndArgsInfo /*P*/ getTrailingASTTemplateKWAndArgsInfo() {
    if (!HasTemplateKWAndArgsInfo) {
      return null;
    }
    if (isa_UnresolvedLookupExpr(this)) {
      return cast_UnresolvedLookupExpr(this).
          <ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star();
    } else {
      return cast_UnresolvedMemberExpr(this).
          <ASTTemplateKWAndArgsInfo>getTrailingObjects(ASTTemplateKWAndArgsInfo.class).$star();
    }
  }
 // defined far below.
  
  /// \brief Return the optional template keyword and arguments info.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getTrailingASTTemplateKWAndArgsInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2507,
   FQN="clang::OverloadExpr::getTrailingASTTemplateKWAndArgsInfo", NM="_ZNK5clang12OverloadExpr35getTrailingASTTemplateKWAndArgsInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr35getTrailingASTTemplateKWAndArgsInfoEv")
  //</editor-fold>
  protected /*const*/ ASTTemplateKWAndArgsInfo /*P*/ getTrailingASTTemplateKWAndArgsInfo$Const() /*const*/ {
    return ((/*const_cast*/OverloadExpr /*P*/ )(this)).
        getTrailingASTTemplateKWAndArgsInfo();
  }

  
  /// Return the optional template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getTrailingTemplateArgumentLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3513,
   FQN="clang::OverloadExpr::getTrailingTemplateArgumentLoc", NM="_ZN5clang12OverloadExpr30getTrailingTemplateArgumentLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr30getTrailingTemplateArgumentLocEv")
  //</editor-fold>
  /*friend*/public /*inline*/ type$ptr<TemplateArgumentLoc/*P*/> getTrailingTemplateArgumentLoc() {
    if (isa_UnresolvedLookupExpr(this)) {
      return cast_UnresolvedLookupExpr(this).
          <TemplateArgumentLoc>getTrailingObjects(TemplateArgumentLoc.class);
    } else {
      return cast_UnresolvedMemberExpr(this).
          <TemplateArgumentLoc>getTrailingObjects(TemplateArgumentLoc.class);
    }
  }
 // defined far below
  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::OverloadExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this + Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 250,
   FQN="clang::OverloadExpr::OverloadExpr", NM="_ZN5clang12OverloadExprC1ENS_4Stmt9StmtClassERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESE_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExprC1ENS_4Stmt9StmtClassERKNS_10ASTContextENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESE_bbb")
  //</editor-fold>
  protected OverloadExpr(StmtClass K, final /*const*/ ASTContext /*&*/ C, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateKWLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
      UnresolvedSetIterator Begin, 
      UnresolvedSetIterator End, 
      boolean KnownDependent, 
      boolean KnownInstantiationDependent, 
      boolean KnownContainsUnexpandedParameterPack) {
    // : Expr(K, C.OverloadTy.operator QualType(), VK_LValue, OK_Ordinary, KnownDependent, KnownDependent, (KnownInstantiationDependent || NameInfo.isInstantiationDependent() || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->isInstantiationDependent())), (KnownContainsUnexpandedParameterPack || NameInfo.containsUnexpandedParameterPack() || (QualifierLoc.operator bool() && QualifierLoc.getNestedNameSpecifier()->containsUnexpandedParameterPack()))), NameInfo(NameInfo), QualifierLoc(QualifierLoc), Results(null), NumResults(End - Begin), HasTemplateKWAndArgsInfo(TemplateArgs != null || TemplateKWLoc.isValid()) 
    //START JInit
    super(K, C.OverloadTy.$QualType(), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, KnownDependent, 
        KnownDependent, 
        (KnownInstantiationDependent
           || NameInfo.isInstantiationDependent()
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().isInstantiationDependent())), 
        (KnownContainsUnexpandedParameterPack
           || NameInfo.containsUnexpandedParameterPack()
           || (QualifierLoc.$bool()
           && QualifierLoc.getNestedNameSpecifier().
            containsUnexpandedParameterPack())));
    this.NameInfo = new DeclarationNameInfo(NameInfo);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.Results = create_type$ptr();
    this.NumResults = End.$sub(Begin);
    this.HasTemplateKWAndArgsInfo = TemplateArgs != null
       || TemplateKWLoc.isValid();
    //END JInit
    NumResults = End.$sub(Begin);
    if ((NumResults != 0)) {
      // Determine whether this expression is type-dependent.
      for (UnresolvedSetIterator I = new UnresolvedSetIterator(Begin); I.$noteq(End); I.$preInc()) {
        if ((I.$star()).getDeclContext().isDependentContext()
           || isa_UnresolvedUsingValueDecl(I.$star())) {
          Unnamed_field.ExprBits.TypeDependent = true;
          Unnamed_field.ExprBits.ValueDependent = true;
          Unnamed_field.ExprBits.InstantiationDependent = true;
        }
      }
      
      if (false) {
        Results = ((/*static_cast*/type$ptr/*<DeclAccessPair P>*/ )(C.Allocate($sizeof_DeclAccessPair() * NumResults, 
          llvm.<DeclAccessPair>alignOf(DeclAccessPair.class))));
        memcpy(Results, Begin.I, NumResults * $sizeof_DeclAccessPair(), false);
      } else { // JAVA
        Results = ((/*static_cast*/type$ptr<DeclAccessPair /*P*/>)(C.Allocate$JavaRef(/*JAVA $sizeof_DeclAccessPair()*/1 * NumResults, 
          /*JAVA: llvm.<DeclAccessPair>alignOf(DeclAccessPair.class)*/1)));
        memcpy(Results, Begin.I, NumResults * (true ? /*JAVA*/1 : $sizeof_DeclAccessPair()), false);
      }
    }
    
    // If we have explicit template arguments, check for dependent
    // template arguments and whether they contain any unexpanded pack
    // expansions.
    if ((TemplateArgs != null)) {
      bool$ref Dependent = create_bool$ref(false);
      bool$ref InstantiationDependent = create_bool$ref(false);
      bool$ref ContainsUnexpandedParameterPack = create_bool$ref(false);
      getTrailingASTTemplateKWAndArgsInfo().initializeFrom(new SourceLocation(TemplateKWLoc), $Deref(TemplateArgs), getTrailingTemplateArgumentLoc(), 
          Dependent, InstantiationDependent, ContainsUnexpandedParameterPack);
      if (Dependent.$deref()) {
        Unnamed_field.ExprBits.TypeDependent = true;
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (InstantiationDependent.$deref()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (ContainsUnexpandedParameterPack.$deref()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
    } else if (TemplateKWLoc.isValid()) {
      getTrailingASTTemplateKWAndArgsInfo().initializeFrom(new SourceLocation(TemplateKWLoc));
    }
    if (isTypeDependent()) {
      setType(C.DependentTy.$QualType());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::OverloadExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2525,
   FQN="clang::OverloadExpr::OverloadExpr", NM="_ZN5clang12OverloadExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  protected OverloadExpr(StmtClass K, EmptyShell Empty) {
    // : Expr(K, Empty), NameInfo(), QualifierLoc(), Results(null), NumResults(0), HasTemplateKWAndArgsInfo(false) 
    //START JInit
    super(K, new EmptyShell(Empty));
    this.NameInfo = new DeclarationNameInfo();
    this.QualifierLoc = new NestedNameSpecifierLoc();
    this.Results = create_type$ptr();
    this.NumResults = 0;
    this.HasTemplateKWAndArgsInfo = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::initializeResults">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 320,
   FQN="clang::OverloadExpr::initializeResults", NM="_ZN5clang12OverloadExpr17initializeResultsERKNS_10ASTContextENS_21UnresolvedSetIteratorES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr17initializeResultsERKNS_10ASTContextENS_21UnresolvedSetIteratorES4_")
  //</editor-fold>
  /*friend*/public void initializeResults(final /*const*/ ASTContext /*&*/ C, 
                   UnresolvedSetIterator Begin, 
                   UnresolvedSetIterator End) {
    assert ((Results.$isNull())) : "Results already initialized!";
    NumResults = End.$sub(Begin);
    if ((NumResults != 0)) {
      if (false) {
        Results = ((/*static_cast*/type$ptr/*<DeclAccessPair P>*/ )(C.Allocate($sizeof_DeclAccessPair() * NumResults, 
            llvm.<DeclAccessPair>alignOf(DeclAccessPair.class))));
      } else {
        Results = ((/*static_cast*/type$ptr/*<DeclAccessPair P>*/ )(C.Allocate$JavaRef(/*$sizeof_DeclAccessPair()*/1 * NumResults, 
            llvm.<DeclAccessPair>alignOf(DeclAccessPair.class))));
      }
      memcpy(Results, Begin.I, NumResults * (true/*JAVA*/ ? 1 : $sizeof_DeclAccessPair()), false);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::FindResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2534,
   FQN="clang::OverloadExpr::FindResult", NM="_ZN5clang12OverloadExpr10FindResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr10FindResultE")
  //</editor-fold>
  public static class/*struct*/ FindResult {
    public OverloadExpr /*P*/ Expression;
    public boolean IsAddressOfOperand;
    public boolean HasFormOfMemberPointer;
    //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::FindResult::FindResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2534,
     FQN="clang::OverloadExpr::FindResult::FindResult", NM="_ZN5clang12OverloadExpr10FindResultC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr10FindResultC1Ev")
    //</editor-fold>
    public /*inline*/ FindResult() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::FindResult::FindResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2534,
     FQN="clang::OverloadExpr::FindResult::FindResult", NM="_ZN5clang12OverloadExpr10FindResultC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr10FindResultC1EOS1_")
    //</editor-fold>
    public /*inline*/ FindResult(JD$Move _dparam, final FindResult /*&&*/$Prm0) {
      // : Expression(static_cast<FindResult &&>().Expression), IsAddressOfOperand(static_cast<FindResult &&>().IsAddressOfOperand), HasFormOfMemberPointer(static_cast<FindResult &&>().HasFormOfMemberPointer) 
      //START JInit
      this.Expression = $Prm0.Expression;
      this.IsAddressOfOperand = $Prm0.IsAddressOfOperand;
      this.HasFormOfMemberPointer = $Prm0.HasFormOfMemberPointer;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::FindResult::~FindResult">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2534,
     FQN="clang::OverloadExpr::FindResult::~FindResult", NM="_ZN5clang12OverloadExpr10FindResultD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang12OverloadExpr10FindResultD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    @Override public String toString() {
      return "" + "Expression=" + Expression // NOI18N
                + ", IsAddressOfOperand=" + IsAddressOfOperand // NOI18N
                + ", HasFormOfMemberPointer=" + HasFormOfMemberPointer; // NOI18N
    }
  };
  
  /// \brief Finds the overloaded expression in the given expression \p E of
  /// OverloadTy.
  ///
  /// \return the expression (which must be there) and true if it has
  /// the particular form of a member pointer expression
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2545,
   FQN="clang::OverloadExpr::find", NM="_ZN5clang12OverloadExpr4findEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr4findEPNS_4ExprE")
  //</editor-fold>
  public static FindResult find(Expr /*P*/ E) {
    assert (E.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Overload.getValue()));
    
    FindResult Result/*J*/= new FindResult();
    
    E = E.IgnoreParens();
    if (isa_UnaryOperator(E)) {
      assert (cast_UnaryOperator(E).getOpcode() == UnaryOperatorKind.UO_AddrOf);
      E = cast_UnaryOperator(E).getSubExpr();
      OverloadExpr /*P*/ Ovl = cast_OverloadExpr(E.IgnoreParens());
      
      Result.HasFormOfMemberPointer = (E == Ovl && (Ovl.getQualifier() != null));
      Result.IsAddressOfOperand = true;
      Result.Expression = Ovl;
    } else {
      Result.HasFormOfMemberPointer = false;
      Result.IsAddressOfOperand = false;
      Result.Expression = cast_OverloadExpr(E);
    }
    
    return Result;
  }

  
  /// \brief Gets the naming class of this lookup, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 334,
   FQN="clang::OverloadExpr::getNamingClass", NM="_ZNK5clang12OverloadExpr14getNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr14getNamingClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getNamingClass() /*const*/ {
    if (isa_UnresolvedLookupExpr(this)) {
      return cast_UnresolvedLookupExpr(this).getNamingClass();
    } else {
      return cast_UnresolvedMemberExpr(this).getNamingClass();
    }
  }

  
  /*typedef UnresolvedSetImpl::iterator decls_iterator*/
//  public final class decls_iterator extends UnresolvedSetIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::decls_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2572,
   FQN="clang::OverloadExpr::decls_begin", NM="_ZNK5clang12OverloadExpr11decls_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr11decls_beginEv")
  //</editor-fold>
  public UnresolvedSetIterator decls_begin() /*const*/ {
    return new UnresolvedSetIterator(JD$DeclAccessPair$P.INSTANCE, Results);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::decls_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2573,
   FQN="clang::OverloadExpr::decls_end", NM="_ZNK5clang12OverloadExpr9decls_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr9decls_endEv")
  //</editor-fold>
  public UnresolvedSetIterator decls_end() /*const*/ {
    return new UnresolvedSetIterator(JD$DeclAccessPair$P.INSTANCE, Results.$add(NumResults));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2576,
   FQN="clang::OverloadExpr::decls", NM="_ZNK5clang12OverloadExpr5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr5declsEv")
  //</editor-fold>
  public iterator_range<NamedDecl /*P*/ > decls() /*const*/ {
    return llvm.make_range(decls_begin(), decls_end());
  }

  
  /// \brief Gets the number of declarations in the unresolved set.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getNumDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2581,
   FQN="clang::OverloadExpr::getNumDecls", NM="_ZNK5clang12OverloadExpr11getNumDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr11getNumDeclsEv")
  //</editor-fold>
  public /*uint*/int getNumDecls() /*const*/ {
    return NumResults;
  }

  
  /// \brief Gets the full name info.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2584,
   FQN="clang::OverloadExpr::getNameInfo", NM="_ZNK5clang12OverloadExpr11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr11getNameInfoEv")
  //</editor-fold>
  public /*const*/ DeclarationNameInfo /*&*/ getNameInfo() /*const*/ {
    return NameInfo;
  }

  
  /// \brief Gets the name looked up.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2587,
   FQN="clang::OverloadExpr::getName", NM="_ZNK5clang12OverloadExpr7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr7getNameEv")
  //</editor-fold>
  public DeclarationName getName() /*const*/ {
    return NameInfo.getName();
  }

  
  /// \brief Gets the location of the name.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2590,
   FQN="clang::OverloadExpr::getNameLoc", NM="_ZNK5clang12OverloadExpr10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return NameInfo.getLoc();
  }

  
  /// \brief Fetches the nested-name qualifier, if one was given.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2593,
   FQN="clang::OverloadExpr::getQualifier", NM="_ZNK5clang12OverloadExpr12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  /// \brief Fetches the nested-name qualifier with source-location
  /// information, if one was given.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2599,
   FQN="clang::OverloadExpr::getQualifierLoc", NM="_ZNK5clang12OverloadExpr15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the location of the template keyword preceding
  /// this name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2603,
   FQN="clang::OverloadExpr::getTemplateKeywordLoc", NM="_ZNK5clang12OverloadExpr21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(getTrailingASTTemplateKWAndArgsInfo$Const().TemplateKWLoc);
  }

  
  /// \brief Retrieve the location of the left angle bracket starting the
  /// explicit template argument list following the name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2610,
   FQN="clang::OverloadExpr::getLAngleLoc", NM="_ZNK5clang12OverloadExpr12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(getTrailingASTTemplateKWAndArgsInfo$Const().LAngleLoc);
  }

  
  /// \brief Retrieve the location of the right angle bracket ending the
  /// explicit template argument list following the name, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2617,
   FQN="clang::OverloadExpr::getRAngleLoc", NM="_ZNK5clang12OverloadExpr12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    if (!HasTemplateKWAndArgsInfo) {
      return new SourceLocation();
    }
    return new SourceLocation(getTrailingASTTemplateKWAndArgsInfo$Const().RAngleLoc);
  }

  
  /// \brief Determines whether the name was preceded by the template keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::hasTemplateKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2623,
   FQN="clang::OverloadExpr::hasTemplateKeyword", NM="_ZNK5clang12OverloadExpr18hasTemplateKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr18hasTemplateKeywordEv")
  //</editor-fold>
  public boolean hasTemplateKeyword() /*const*/ {
    return getTemplateKeywordLoc().isValid();
  }

  
  /// \brief Determines whether this expression had explicit template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::hasExplicitTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2626,
   FQN="clang::OverloadExpr::hasExplicitTemplateArgs", NM="_ZNK5clang12OverloadExpr23hasExplicitTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr23hasExplicitTemplateArgsEv")
  //</editor-fold>
  public boolean hasExplicitTemplateArgs() /*const*/ {
    return getLAngleLoc().isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2628,
   FQN="clang::OverloadExpr::getTemplateArgs", NM="_ZNK5clang12OverloadExpr15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return null;
    }
    return ((/*const_cast*/OverloadExpr /*P*/ )(this)).getTrailingTemplateArgumentLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::getNumTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2634,
   FQN="clang::OverloadExpr::getNumTemplateArgs", NM="_ZNK5clang12OverloadExpr18getNumTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr18getNumTemplateArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateArgs() /*const*/ {
    if (!hasExplicitTemplateArgs()) {
      return 0;
    }
    
    return getTrailingASTTemplateKWAndArgsInfo$Const().NumTemplateArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::template_arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2641,
   FQN="clang::OverloadExpr::template_arguments", NM="_ZNK5clang12OverloadExpr18template_argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr18template_argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgumentLoc> template_arguments() /*const*/ {
    return /*{ */new ArrayRef<TemplateArgumentLoc>(getTemplateArgs(), getNumTemplateArgs(), false)/* }*/;
  }

  
  /// \brief Copies the template arguments into the given structure.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::copyTemplateArgumentsInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2646,
   FQN="clang::OverloadExpr::copyTemplateArgumentsInto", NM="_ZNK5clang12OverloadExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang12OverloadExpr25copyTemplateArgumentsIntoERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void copyTemplateArgumentsInto(final TemplateArgumentListInfo /*&*/ List) /*const*/ {
    if (hasExplicitTemplateArgs()) {
      getTrailingASTTemplateKWAndArgsInfo$Const().copyInto(getTemplateArgs(), List);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2651,
   FQN="clang::OverloadExpr::classof", NM="_ZN5clang12OverloadExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang12OverloadExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.UnresolvedLookupExprClass
       || T.getStmtClass() == StmtClass.UnresolvedMemberExprClass;
  }

  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public final type$ptr<?> $TrailingObjects() {
    return $this$plus1();
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NameInfo=" + NameInfo // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", Results=" + Results // NOI18N
              + ", NumResults=" + NumResults // NOI18N
              + ", HasTemplateKWAndArgsInfo=" + HasTemplateKWAndArgsInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
