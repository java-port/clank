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

package org.clang.sema;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 666,
 FQN="clang::sema::LambdaScopeInfo", NM="_ZN5clang4sema15LambdaScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfoE")
//</editor-fold>
public final class LambdaScopeInfo extends /*public*/ CapturingScopeInfo implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief The class that describes the lambda.
  public CXXRecordDecl /*P*/ Lambda;
  
  /// \brief The lambda's compiler-generated \c operator().
  public CXXMethodDecl /*P*/ CallOperator;
  
  /// \brief Source range covering the lambda introducer [...].
  public SourceRange IntroducerRange;
  
  /// \brief Source location of the '&' or '=' specifying the default capture
  /// type, if any.
  public SourceLocation CaptureDefaultLoc;
  
  /// \brief The number of captures in the \c Captures list that are
  /// explicit captures.
  public /*uint*/int NumExplicitCaptures;
  
  /// \brief Whether this is a mutable lambda.
  public boolean Mutable;
  
  /// \brief Whether the (empty) parameter list is explicit.
  public boolean ExplicitParams;
  
  /// \brief Whether any of the capture expressions requires cleanups.
  public CleanupInfo Cleanup;
  
  /// \brief Whether the lambda contains an unexpanded parameter pack.
  public boolean ContainsUnexpandedParameterPack;
  
  /// \brief If this is a generic lambda, use this as the depth of 
  /// each 'auto' parameter, during initial AST construction.
  public /*uint*/int AutoTemplateParameterDepth;
  
  /// \brief Store the list of the auto parameters for a generic lambda.
  /// If this is a generic lambda, store the list of the auto 
  /// parameters converted into TemplateTypeParmDecls into a vector
  /// that can be used to construct the generic lambda's template
  /// parameter list, during initial AST construction.
  public SmallVector<TemplateTypeParmDecl /*P*/ > AutoTemplateParams;
  
  /// If this is a generic lambda, and the template parameter
  /// list has been created (from the AutoTemplateParams) then
  /// store a reference to it (cache it to avoid reconstructing it).
  public TemplateParameterList /*P*/ GLTemplateParameterList;
  
  /// \brief Contains all variable-referring-expressions (i.e. DeclRefExprs
  ///  or MemberExprs) that refer to local variables in a generic lambda
  ///  or a lambda in a potentially-evaluated-if-used context.
  ///  
  ///  Potentially capturable variables of a nested lambda that might need 
  ///   to be captured by the lambda are housed here.  
  ///  This is specifically useful for generic lambdas or
  ///  lambdas within a a potentially evaluated-if-used context.
  ///  If an enclosing variable is named in an expression of a lambda nested
  ///  within a generic lambda, we don't always know know whether the variable 
  ///  will truly be odr-used (i.e. need to be captured) by that nested lambda,
  ///  until its instantiation. But we still need to capture it in the 
  ///  enclosing lambda if all intervening lambdas can capture the variable.
  public SmallVector<Expr /*P*/ > PotentiallyCapturingExprs;
  
  /// \brief Contains all variable-referring-expressions that refer
  ///  to local variables that are usable as constant expressions and
  ///  do not involve an odr-use (they may still need to be captured
  ///  if the enclosing full-expression is instantiation dependent).
  public SmallSetT$PLess$T$P<Expr /*P*/ > NonODRUsedCapturingExprs;
  
  public SourceLocation PotentialThisCaptureLocation;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::LambdaScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 737,
   FQN="clang::sema::LambdaScopeInfo::LambdaScopeInfo", NM="_ZN5clang4sema15LambdaScopeInfoC1ERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfoC1ERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public LambdaScopeInfo(final DiagnosticsEngine /*&*/ Diag) {
    // : CapturingScopeInfo(Diag, ImpCap_None), Lambda(null), CallOperator(null), IntroducerRange(), CaptureDefaultLoc(), NumExplicitCaptures(0), Mutable(false), ExplicitParams(false), Cleanup(), ContainsUnexpandedParameterPack(false), AutoTemplateParameterDepth(0), AutoTemplateParams(), GLTemplateParameterList(null), PotentiallyCapturingExprs(), NonODRUsedCapturingExprs(), PotentialThisCaptureLocation() 
    //START JInit
    super(Diag, ImplicitCaptureStyle.ImpCap_None);
    this.Lambda = null;
    this.CallOperator = null;
    this.IntroducerRange = new SourceRange();
    this.CaptureDefaultLoc = new SourceLocation();
    this.NumExplicitCaptures = 0;
    this.Mutable = false;
    this.ExplicitParams = false;
    this.Cleanup = /*{ */new CleanupInfo()/* }*/;
    this.ContainsUnexpandedParameterPack = false;
    this.AutoTemplateParameterDepth = 0;
    this.AutoTemplateParams = new SmallVector<TemplateTypeParmDecl /*P*/ >(4, (TemplateTypeParmDecl /*P*/ )null);
    this.GLTemplateParameterList = null;
    this.PotentiallyCapturingExprs = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    this.NonODRUsedCapturingExprs = new SmallSetT$PLess$T$P<Expr /*P*/ >(8);
    this.PotentialThisCaptureLocation = new SourceLocation();
    //END JInit
    Kind = ScopeKind.SK_Lambda;
  }

  
  /// \brief Note when all explicit captures have been added.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::finishedExplicitCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 747,
   FQN="clang::sema::LambdaScopeInfo::finishedExplicitCaptures", NM="_ZN5clang4sema15LambdaScopeInfo24finishedExplicitCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo24finishedExplicitCapturesEv")
  //</editor-fold>
  public void finishedExplicitCaptures() {
    NumExplicitCaptures = Captures.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 751,
   FQN="clang::sema::LambdaScopeInfo::classof", NM="_ZN5clang4sema15LambdaScopeInfo7classofEPKNS0_17FunctionScopeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo7classofEPKNS0_17FunctionScopeInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ FunctionScopeInfo /*P*/ FSI) {
    return FSI.Kind == ScopeKind.SK_Lambda;
  }

  
  ///
  /// \brief Add a variable that might potentially be captured by the 
  /// lambda and therefore the enclosing lambdas. 
  /// 
  /// This is also used by enclosing lambda's to speculatively capture 
  /// variables that nested lambda's - depending on their enclosing
  /// specialization - might need to capture.
  /// Consider:
  /// void f(int, int); <-- don't capture
  /// void f(const int&, double); <-- capture
  /// void foo() {
  ///   const int x = 10;
  ///   auto L = [=](auto a) { // capture 'x'
  ///      return [=](auto b) { 
  ///        f(x, a);  // we may or may not need to capture 'x'
  ///      };
  ///   };
  /// }
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::addPotentialCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 773,
   FQN="clang::sema::LambdaScopeInfo::addPotentialCapture", NM="_ZN5clang4sema15LambdaScopeInfo19addPotentialCaptureEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo19addPotentialCaptureEPNS_4ExprE")
  //</editor-fold>
  public void addPotentialCapture(Expr /*P*/ VarExpr) {
    assert (isa_DeclRefExpr(VarExpr) || isa_MemberExpr(VarExpr));
    PotentiallyCapturingExprs.push_back(VarExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::addPotentialThisCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 778,
   FQN="clang::sema::LambdaScopeInfo::addPotentialThisCapture", NM="_ZN5clang4sema15LambdaScopeInfo23addPotentialThisCaptureENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo23addPotentialThisCaptureENS_14SourceLocationE")
  //</editor-fold>
  public void addPotentialThisCapture(SourceLocation Loc) {
    PotentialThisCaptureLocation.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::hasPotentialThisCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 781,
   FQN="clang::sema::LambdaScopeInfo::hasPotentialThisCapture", NM="_ZNK5clang4sema15LambdaScopeInfo23hasPotentialThisCaptureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema15LambdaScopeInfo23hasPotentialThisCaptureEv")
  //</editor-fold>
  public boolean hasPotentialThisCapture() /*const*/ {
    return PotentialThisCaptureLocation.isValid();
  }

  
  /// \brief Mark a variable's reference in a lambda as non-odr using.
  ///
  /// For generic lambdas, if a variable is named in a potentially evaluated 
  /// expression, where the enclosing full expression is dependent then we 
  /// must capture the variable (given a default capture).
  /// This is accomplished by recording all references to variables 
  /// (DeclRefExprs or MemberExprs) within said nested lambda in its array of 
  /// PotentialCaptures. All such variables have to be captured by that lambda,
  /// except for as described below.
  /// If that variable is usable as a constant expression and is named in a 
  /// manner that does not involve its odr-use (e.g. undergoes 
  /// lvalue-to-rvalue conversion, or discarded) record that it is so. Upon the
  /// act of analyzing the enclosing full expression (ActOnFinishFullExpr)
  /// if we can determine that the full expression is not instantiation-
  /// dependent, then we can entirely avoid its capture. 
  ///
  ///   const int n = 0;
  ///   [&] (auto x) {
  ///     (void)+n + x;
  ///   };
  /// Interestingly, this strategy would involve a capture of n, even though 
  /// it's obviously not odr-used here, because the full-expression is 
  /// instantiation-dependent.  It could be useful to avoid capturing such
  /// variables, even when they are referred to in an instantiation-dependent
  /// expression, if we can unambiguously determine that they shall never be
  /// odr-used.  This would involve removal of the variable-referring-expression
  /// from the array of PotentialCaptures during the lvalue-to-rvalue 
  /// conversions.  But per the working draft N3797, (post-chicago 2013) we must
  /// capture such variables. 
  /// Before anyone is tempted to implement a strategy for not-capturing 'n',
  /// consider the insightful warning in: 
  ///    /cfe-commits/Week-of-Mon-20131104/092596.html
  /// "The problem is that the set of captures for a lambda is part of the ABI
  ///  (since lambda layout can be made visible through inline functions and the
  ///  like), and there are no guarantees as to which cases we'll manage to build
  ///  an lvalue-to-rvalue conversion in, when parsing a template -- some
  ///  seemingly harmless change elsewhere in Sema could cause us to start or stop
  ///  building such a node. So we need a rule that anyone can implement and get
  ///  exactly the same result".
  ///    
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::markVariableExprAsNonODRUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 825,
   FQN="clang::sema::LambdaScopeInfo::markVariableExprAsNonODRUsed", NM="_ZN5clang4sema15LambdaScopeInfo28markVariableExprAsNonODRUsedEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo28markVariableExprAsNonODRUsedEPNS_4ExprE")
  //</editor-fold>
  public void markVariableExprAsNonODRUsed(Expr /*P*/ CapturingVarExpr) {
    assert (isa_DeclRefExpr(CapturingVarExpr) || isa_MemberExpr(CapturingVarExpr));
    NonODRUsedCapturingExprs.insert(CapturingVarExpr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::isVariableExprMarkedAsNonODRUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 830,
   FQN="clang::sema::LambdaScopeInfo::isVariableExprMarkedAsNonODRUsed", NM="_ZNK5clang4sema15LambdaScopeInfo32isVariableExprMarkedAsNonODRUsedEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema15LambdaScopeInfo32isVariableExprMarkedAsNonODRUsedEPNS_4ExprE")
  //</editor-fold>
  public boolean isVariableExprMarkedAsNonODRUsed(Expr /*P*/ CapturingVarExpr) /*const*/ {
    assert (isa_DeclRefExpr(CapturingVarExpr) || isa_MemberExpr(CapturingVarExpr));
    return (NonODRUsedCapturingExprs.count(CapturingVarExpr) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::removePotentialCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 835,
   FQN="clang::sema::LambdaScopeInfo::removePotentialCapture", NM="_ZN5clang4sema15LambdaScopeInfo22removePotentialCaptureEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo22removePotentialCaptureEPNS_4ExprE")
  //</editor-fold>
  public void removePotentialCapture(Expr /*P*/ E) {
    PotentiallyCapturingExprs.erase(std.remove(PotentiallyCapturingExprs.begin(), 
            PotentiallyCapturingExprs.end(), E), 
        PotentiallyCapturingExprs.end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::clearPotentialCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 841,
   FQN="clang::sema::LambdaScopeInfo::clearPotentialCaptures", NM="_ZN5clang4sema15LambdaScopeInfo22clearPotentialCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfo22clearPotentialCapturesEv")
  //</editor-fold>
  public void clearPotentialCaptures() {
    PotentiallyCapturingExprs.clear();
    PotentialThisCaptureLocation.$assignMove(new SourceLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::getNumPotentialVariableCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 845,
   FQN="clang::sema::LambdaScopeInfo::getNumPotentialVariableCaptures", NM="_ZNK5clang4sema15LambdaScopeInfo31getNumPotentialVariableCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema15LambdaScopeInfo31getNumPotentialVariableCapturesEv")
  //</editor-fold>
  public /*uint*/int getNumPotentialVariableCaptures() /*const*/ {
    return PotentiallyCapturingExprs.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::hasPotentialCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 849,
   FQN="clang::sema::LambdaScopeInfo::hasPotentialCaptures", NM="_ZNK5clang4sema15LambdaScopeInfo20hasPotentialCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema15LambdaScopeInfo20hasPotentialCapturesEv")
  //</editor-fold>
  public boolean hasPotentialCaptures() /*const*/ {
    return (getNumPotentialVariableCaptures() != 0)
       || PotentialThisCaptureLocation.isValid();
  }

  
  // When passed the index, returns the VarDecl and Expr associated
  // with the index.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::getPotentialVariableCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 225,
   FQN="clang::sema::LambdaScopeInfo::getPotentialVariableCapture", NM="_ZNK5clang4sema15LambdaScopeInfo27getPotentialVariableCaptureEjRPNS_7VarDeclERPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema15LambdaScopeInfo27getPotentialVariableCaptureEjRPNS_7VarDeclERPNS_4ExprE")
  //</editor-fold>
  public void getPotentialVariableCapture(/*uint*/int Idx, final type$ref<VarDecl /*P*/ /*&*/> VD, 
                             final type$ref<Expr /*P*/ /*&*/> E) /*const*/ {
    assert ($less_uint(Idx, getNumPotentialVariableCaptures())) : "Index of potential capture must be within 0 to less than the number of captures!";
    E.$set(PotentiallyCapturingExprs.$at$Const(Idx));
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.$deref());
      if ((DRE != null)) {
        VD.$set(dyn_cast_VarDecl(DRE.getFoundDecl()));
      } else {
        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E.$deref());
        if ((ME != null)) {
          VD.$set(dyn_cast_VarDecl(ME.getMemberDecl()));
        } else {
          throw new llvm_unreachable("Only DeclRefExprs or MemberExprs should be added for potential captures");
        }
      }
    }
    assert Native.$bool(VD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::~LambdaScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 666,
   FQN="clang::sema::LambdaScopeInfo::~LambdaScopeInfo", NM="_ZN5clang4sema15LambdaScopeInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema15LambdaScopeInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    NonODRUsedCapturingExprs.$destroy();
    PotentiallyCapturingExprs.$destroy();
    AutoTemplateParams.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::LambdaScopeInfo::LambdaScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 666,
   FQN="clang::sema::LambdaScopeInfo::LambdaScopeInfo", NM="_ZN5clang4sema15LambdaScopeInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema15LambdaScopeInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LambdaScopeInfo(final /*const*/ LambdaScopeInfo /*&*/ $Prm0) {
    // : CapturingScopeInfo(), Lambda(.Lambda), CallOperator(.CallOperator), IntroducerRange(.IntroducerRange), CaptureDefaultLoc(.CaptureDefaultLoc), NumExplicitCaptures(.NumExplicitCaptures), Mutable(.Mutable), ExplicitParams(.ExplicitParams), Cleanup(.Cleanup), ContainsUnexpandedParameterPack(.ContainsUnexpandedParameterPack), AutoTemplateParameterDepth(.AutoTemplateParameterDepth), AutoTemplateParams(.AutoTemplateParams), GLTemplateParameterList(.GLTemplateParameterList), PotentiallyCapturingExprs(.PotentiallyCapturingExprs), NonODRUsedCapturingExprs(.NonODRUsedCapturingExprs), PotentialThisCaptureLocation(.PotentialThisCaptureLocation) 
    //START JInit
    super($Prm0);
    this.Lambda = $Prm0.Lambda;
    this.CallOperator = $Prm0.CallOperator;
    this.IntroducerRange = new SourceRange($Prm0.IntroducerRange);
    this.CaptureDefaultLoc = new SourceLocation($Prm0.CaptureDefaultLoc);
    this.NumExplicitCaptures = $Prm0.NumExplicitCaptures;
    this.Mutable = $Prm0.Mutable;
    this.ExplicitParams = $Prm0.ExplicitParams;
    this.Cleanup = new CleanupInfo($Prm0.Cleanup);
    this.ContainsUnexpandedParameterPack = $Prm0.ContainsUnexpandedParameterPack;
    this.AutoTemplateParameterDepth = $Prm0.AutoTemplateParameterDepth;
    this.AutoTemplateParams = new SmallVector<TemplateTypeParmDecl /*P*/ >($Prm0.AutoTemplateParams);
    this.GLTemplateParameterList = $Prm0.GLTemplateParameterList;
    this.PotentiallyCapturingExprs = new SmallVector<Expr /*P*/ >($Prm0.PotentiallyCapturingExprs);
    this.NonODRUsedCapturingExprs = new SmallSetT$PLess$T$P<Expr /*P*/ >($Prm0.NonODRUsedCapturingExprs);
    this.PotentialThisCaptureLocation = new SourceLocation($Prm0.PotentialThisCaptureLocation);
    //END JInit
  }

  @Override public String toString() {
    return "" + "Lambda=" + Lambda // NOI18N
              + ", CallOperator=" + CallOperator // NOI18N
              + ", IntroducerRange=" + IntroducerRange // NOI18N
              + ", CaptureDefaultLoc=" + CaptureDefaultLoc // NOI18N
              + ", NumExplicitCaptures=" + NumExplicitCaptures // NOI18N
              + ", Mutable=" + Mutable // NOI18N
              + ", ExplicitParams=" + ExplicitParams // NOI18N
              + ", Cleanup=" + Cleanup // NOI18N
              + ", ContainsUnexpandedParameterPack=" + ContainsUnexpandedParameterPack // NOI18N
              + ", AutoTemplateParameterDepth=" + AutoTemplateParameterDepth // NOI18N
              + ", AutoTemplateParams=" + AutoTemplateParams // NOI18N
              + ", GLTemplateParameterList=" + GLTemplateParameterList // NOI18N
              + ", PotentiallyCapturingExprs=" + PotentiallyCapturingExprs // NOI18N
              + ", NonODRUsedCapturingExprs=" + NonODRUsedCapturingExprs // NOI18N
              + ", PotentialThisCaptureLocation=" + PotentialThisCaptureLocation // NOI18N
              + super.toString(); // NOI18N
  }
}
