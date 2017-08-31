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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.basic.java.diagJava;
import static org.clang.sema.impl.JumpDiagnosticsStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// JumpScopeChecker - This object is used by Sema to diagnose invalid jumps
/// into VLA and other protected scopes.  For example, this rejects:
///    goto L;
///    int a[n];
///  L:
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 32,
 FQN="(anonymous namespace)::JumpScopeChecker", NM="_ZN12_GLOBAL__N_116JumpScopeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeCheckerE")
//</editor-fold>
public class JumpScopeChecker implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  
  /// Permissive - True when recovering from errors, in which case precautions
  /// are taken to handle incomplete scope information.
  private /*const*/boolean Permissive;
  
  /// GotoScope - This is a record that we use to keep track of all of the
  /// scopes that are introduced by VLAs and other things that scope jumps like
  /// gotos.  This scope tree has nothing to do with the source scope tree,
  /// because you can have multiple VLA scopes per compound statement, and most
  /// compound statements don't introduce any scopes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::GotoScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 44,
   FQN="(anonymous namespace)::JumpScopeChecker::GotoScope", NM="_ZN12_GLOBAL__N_116JumpScopeChecker9GotoScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker9GotoScopeE")
  //</editor-fold>
  private static class/*struct*/ GotoScope implements NativePOD<GotoScope> {
    /// ParentScope - The index in ScopeMap of the parent scope.  This is 0 for
    /// the parent scope is the function body.
    public /*uint*/int ParentScope;
    
    /// InDiag - The note to emit if there is a jump into this scope.
    public /*uint*/int InDiag;
    
    /// OutDiag - The note to emit if there is an indirect jump out
    /// of this scope.  Direct jumps always clean up their current scope
    /// in an orderly way.
    public /*uint*/int OutDiag;
    
    /// Loc - Location to emit the diagnostic.
    public SourceLocation Loc;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::GotoScope::GotoScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 60,
     FQN="(anonymous namespace)::JumpScopeChecker::GotoScope::GotoScope", NM="_ZN12_GLOBAL__N_116JumpScopeChecker9GotoScopeC1EjjjN5clang14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker9GotoScopeC1EjjjN5clang14SourceLocationE")
    //</editor-fold>
    public GotoScope(/*uint*/int parentScope, /*uint*/int InDiag, /*uint*/int OutDiag, 
        SourceLocation L) {
      // : ParentScope(parentScope), InDiag(InDiag), OutDiag(OutDiag), Loc(L) 
      //START JInit
      this.ParentScope = parentScope;
      this.InDiag = InDiag;
      this.OutDiag = OutDiag;
      this.Loc = new SourceLocation(L);
      //END JInit
    }

    @Override
    public GotoScope $assign(GotoScope $Prm0) {
      this.ParentScope = $Prm0.ParentScope;
      this.InDiag = $Prm0.InDiag;
      this.OutDiag = $Prm0.OutDiag;
      this.Loc = new SourceLocation($Prm0.Loc);
      return this;      
    }

    @Override public GotoScope clone() { 
      return new GotoScope(this.ParentScope, this.InDiag, this.OutDiag, this.Loc); 
    }
    
    @Override public String toString() {
      return "" + "ParentScope=" + ParentScope // NOI18N
                + ", InDiag=" + diagJava.$name(InDiag) // NOI18N
                + ", OutDiag=" + diagJava.$name(OutDiag) // NOI18N
                + ", Loc=" + Loc; // NOI18N
    }
  };
  
  private SmallVector<GotoScope> Scopes;
  private DenseMapTypeUInt<Stmt /*P*/ > LabelAndGotoScopes;
  private SmallVector<Stmt /*P*/ > Jumps;
  
  private SmallVector<IndirectGotoStmt /*P*/ > IndirectJumps;
  private SmallVector<LabelDecl /*P*/ > IndirectJumpTargets;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::JumpScopeChecker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 95,
   FQN="(anonymous namespace)::JumpScopeChecker::JumpScopeChecker", NM="_ZN12_GLOBAL__N_116JumpScopeCheckerC1EPN5clang4StmtERNS1_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeCheckerC1EPN5clang4StmtERNS1_4SemaE")
  //</editor-fold>
  public JumpScopeChecker(Stmt /*P*/ Body, final Sema /*&*/ s) {
    // : S(s), Permissive(s.hasAnyUnrecoverableErrorsInThisFunction()), Scopes(), LabelAndGotoScopes(), Jumps(), IndirectJumps(), IndirectJumpTargets() 
    //START JInit
    this./*&*/S=/*&*/s;
    this.Permissive = s.hasAnyUnrecoverableErrorsInThisFunction();
    this.Scopes = new SmallVector<GotoScope>(48, new GotoScope(0, 0, 0, new SourceLocation()));
    this.LabelAndGotoScopes = new DenseMapTypeUInt<Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.Jumps = new SmallVector<Stmt /*P*/ >(16, (Stmt /*P*/ )null);
    this.IndirectJumps = new SmallVector<IndirectGotoStmt /*P*/ >(4, (IndirectGotoStmt /*P*/ )null);
    this.IndirectJumpTargets = new SmallVector<LabelDecl /*P*/ >(4, (LabelDecl /*P*/ )null);
    //END JInit
    // Add a scope entry for function scope.
    Scopes.push_back(new GotoScope(~0/*U*/, ~0/*U*/, ~0/*U*/, new SourceLocation()));
    
    // Build information for the top level compound statement, so that we have a
    // defined scope record for every "goto" and label.
    uint$ref BodyParentScope = create_uint$ref(0);
    BuildScopeInformation(Body, BodyParentScope);
    
    // Check that all jumps we saw are kosher.
    VerifyJumps();
    VerifyIndirectJumps();
  }

/*private:*/
  
  /// \brief Build scope information for a declaration that is part of a DeclStmt.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::BuildScopeInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 216,
   FQN="(anonymous namespace)::JumpScopeChecker::BuildScopeInformation", NM="_ZN12_GLOBAL__N_116JumpScopeChecker21BuildScopeInformationEPN5clang4DeclERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker21BuildScopeInformationEPN5clang4DeclERj")
  //</editor-fold>
  private void BuildScopeInformation(Decl /*P*/ D, final uint$ref/*uint &*/ ParentScope) {
    // If this decl causes a new scope, push and switch to it.
    std.pairUIntUInt Diags = GetDiagForGotoScopeDecl(S, D);
    if ((Diags.first != 0) || (Diags.second != 0)) {
      Scopes.push_back(new GotoScope(ParentScope.$deref(), Diags.first, Diags.second, 
              D.getLocation()));
      ParentScope.$set(Scopes.size() - 1);
    }
    {
      
      // If the decl has an initializer, walk it with the potentially new
      // scope we just installed.
      VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        {
          Expr /*P*/ Init = VD.getInit();
          if ((Init != null)) {
            BuildScopeInformation(Init, ParentScope);
          }
        }
      }
    }
  }

  
  /// \brief Build scope information for a captured block literal variables.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::BuildScopeInformation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 233,
   FQN="(anonymous namespace)::JumpScopeChecker::BuildScopeInformation", NM="_ZN12_GLOBAL__N_116JumpScopeChecker21BuildScopeInformationEPN5clang7VarDeclEPKNS1_9BlockDeclERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker21BuildScopeInformationEPN5clang7VarDeclEPKNS1_9BlockDeclERj")
  //</editor-fold>
  private void BuildScopeInformation(VarDecl /*P*/ D, 
                       /*const*/ BlockDecl /*P*/ BDecl, 
                       final uint$ref/*uint &*/ ParentScope) {
    // exclude captured __block variables; there's no destructor
    // associated with the block literal for them.
    if (D.hasAttr(BlocksAttr.class)) {
      return;
    }
    QualType T = D.getType();
    QualType.DestructionKind destructKind = T.isDestructedType();
    if (destructKind != QualType.DestructionKind.DK_none) {
      std.pairUIntUInt Diags/*J*/= new std.pairUIntUInt();
      switch (destructKind) {
       case DK_cxx_destructor:
        Diags.$assignMove(new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_enters_block_captures_cxx_obj, 
                diag.note_exits_block_captures_cxx_obj));
        break;
       case DK_objc_strong_lifetime:
        Diags.$assignMove(new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_enters_block_captures_strong, 
                diag.note_exits_block_captures_strong));
        break;
       case DK_objc_weak_lifetime:
        Diags.$assignMove(new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, diag.note_enters_block_captures_weak, 
                diag.note_exits_block_captures_weak));
        break;
       case DK_none:
        throw new llvm_unreachable("non-lifetime captured variable");
      }
      SourceLocation Loc = D.getLocation();
      if (Loc.isInvalid()) {
        Loc.$assignMove(BDecl.getLocation());
      }
      Scopes.push_back(new GotoScope(ParentScope.$deref(), 
              Diags.first, Diags.second, new SourceLocation(Loc)));
      ParentScope.$set(Scopes.size() - 1);
    }
  }

  
  /// BuildScopeInformation - The statements from CI to CE are known to form a
  /// coherent VLA scope with a specified parent node.  Walk through the
  /// statements, adding any labels or gotos to LabelAndGotoScopes and recursively
  /// walking the AST as needed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::BuildScopeInformation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 273,
   FQN="(anonymous namespace)::JumpScopeChecker::BuildScopeInformation", NM="_ZN12_GLOBAL__N_116JumpScopeChecker21BuildScopeInformationEPN5clang4StmtERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker21BuildScopeInformationEPN5clang4StmtERj")
  //</editor-fold>
  private void BuildScopeInformation(Stmt /*P*/ S, 
                       final uint$ref/*uint &*/ origParentScope) {
    // If this is a statement, rather than an expression, scopes within it don't
    // propagate out into the enclosing scope.  Otherwise we have to worry
    // about block literals, which have the lifetime of their enclosing statement.
    uint$ref independentParentScope = create_uint$ref(origParentScope.$deref());
    final uint$ref/*uint &*/ ParentScope = ((isa_Expr(S) && !isa_StmtExpr(S)) ? origParentScope : independentParentScope);
    
    /*uint*/int StmtsToSkip = 0/*U*/;
    
    // If we found a label, remember that it is in ParentScope scope.
    switch (S.getStmtClass()) {
     case AddrLabelExprClass:
      IndirectJumpTargets.push_back(cast_AddrLabelExpr(S).getLabel());
      break;
     case IndirectGotoStmtClass:
      // "goto *&&lbl;" is a special case which we treat as equivalent
      // to a normal goto.  In addition, we don't calculate scope in the
      // operand (to avoid recording the address-of-label use), which
      // works only because of the restricted set of expressions which
      // we detect as constant targets.
      if ((cast_IndirectGotoStmt(S).getConstantTarget() != null)) {
        LabelAndGotoScopes.$set(S, ParentScope.$deref());
        Jumps.push_back(S);
        return;
      }
      
      LabelAndGotoScopes.$set(S, ParentScope.$deref());
      IndirectJumps.push_back(cast_IndirectGotoStmt(S));
      break;
     case SwitchStmtClass:
      {
        // Evaluate the C++17 init stmt and condition variable
        // before entering the scope of the switch statement.
        Stmt /*P*/ Init = cast_SwitchStmt(S).getInit();
        if ((Init != null)) {
          BuildScopeInformation(Init, ParentScope);
          ++StmtsToSkip;
        }
      }
      {
        VarDecl /*P*/ Var = cast_SwitchStmt(S).getConditionVariable();
        if ((Var != null)) {
          BuildScopeInformation(Var, ParentScope);
          ++StmtsToSkip;
        }
      }
     case GotoStmtClass:
      // Remember both what scope a goto is in as well as the fact that we have
      // it.  This makes the second scan not have to walk the AST again.
      LabelAndGotoScopes.$set(S, ParentScope.$deref());
      Jumps.push_back(S);
      break;
     case IfStmtClass:
      {
        IfStmt /*P*/ IS = cast_IfStmt(S);
        if (!IS.isConstexpr()) {
          break;
        }
        {
          
          VarDecl /*P*/ Var = IS.getConditionVariable();
          if ((Var != null)) {
            BuildScopeInformation(Var, ParentScope);
          }
        }
        
        // Cannot jump into the middle of the condition.
        uint$ref NewParentScope = create_uint$ref(Scopes.size());
        Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                diag.note_protected_by_constexpr_if, 0, 
                IS.getLocStart()));
        BuildScopeInformation(IS.getCond(), NewParentScope);
        
        // Jumps into either arm of an 'if constexpr' are not allowed.
        NewParentScope.$set(Scopes.size());
        Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                diag.note_protected_by_constexpr_if, 0, 
                IS.getLocStart()));
        BuildScopeInformation(IS.getThen(), NewParentScope);
        {
          Stmt /*P*/ Else = IS.getElse();
          if ((Else != null)) {
            NewParentScope.$set(Scopes.size());
            Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                    diag.note_protected_by_constexpr_if, 0, 
                    IS.getLocStart()));
            BuildScopeInformation(Else, NewParentScope);
          }
        }
        return;
      }
     case CXXTryStmtClass:
      {
        CXXTryStmt /*P*/ TS = cast_CXXTryStmt(S);
        {
          uint$ref NewParentScope = create_uint$ref(Scopes.size());
          Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                  diag.note_protected_by_cxx_try, 
                  diag.note_exits_cxx_try, 
                  TS.getSourceRange().getBegin()));
          {
            Stmt /*P*/ TryBlock = TS.getTryBlock();
            if ((TryBlock != null)) {
              BuildScopeInformation(TryBlock, NewParentScope);
            }
          }
        }
        
        // Jump from the catch into the try is not allowed either.
        for (/*uint*/int I = 0, E = TS.getNumHandlers(); I != E; ++I) {
          CXXCatchStmt /*P*/ CS = TS.getHandler(I);
          uint$ref NewParentScope = create_uint$ref(Scopes.size());
          Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                  diag.note_protected_by_cxx_catch, 
                  diag.note_exits_cxx_catch, 
                  CS.getSourceRange().getBegin()));
          BuildScopeInformation(CS.getHandlerBlock(), NewParentScope);
        }
        return;
      }
     case SEHTryStmtClass:
      {
        SEHTryStmt /*P*/ TS = cast_SEHTryStmt(S);
        {
          uint$ref NewParentScope = create_uint$ref(Scopes.size());
          Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                  diag.note_protected_by_seh_try, 
                  diag.note_exits_seh_try, 
                  TS.getSourceRange().getBegin()));
          {
            Stmt /*P*/ TryBlock = TS.getTryBlock();
            if ((TryBlock != null)) {
              BuildScopeInformation(TryBlock, NewParentScope);
            }
          }
        }
        {
          
          // Jump from __except or __finally into the __try are not allowed either.
          SEHExceptStmt /*P*/ Except = TS.getExceptHandler();
          if ((Except != null)) {
            uint$ref NewParentScope = create_uint$ref(Scopes.size());
            Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                    diag.note_protected_by_seh_except, 
                    diag.note_exits_seh_except, 
                    Except.getSourceRange().getBegin()));
            BuildScopeInformation(Except.getBlock(), NewParentScope);
          } else {
            SEHFinallyStmt /*P*/ Finally = TS.getFinallyHandler();
            if ((Finally != null)) {
              uint$ref NewParentScope = create_uint$ref(Scopes.size());
              Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                      diag.note_protected_by_seh_finally, 
                      diag.note_exits_seh_finally, 
                      Finally.getSourceRange().getBegin()));
              BuildScopeInformation(Finally.getBlock(), NewParentScope);
            }
          }
        }
        
        return;
      }
     case DeclStmtClass:
      {
        // If this is a declstmt with a VLA definition, it defines a scope from here
        // to the end of the containing context.
        DeclStmt /*P*/ DS = cast_DeclStmt(S);
        // The decl statement creates a scope if any of the decls in it are VLAs
        // or have the cleanup attribute.
        for (Decl /*P*/ I : DS.decls())  {
          BuildScopeInformation(I, origParentScope);
        }
        return;
      }
     case ObjCAtTryStmtClass:
      {
        // Disallow jumps into any part of an @try statement by pushing a scope and
        // walking all sub-stmts in that scope.
        ObjCAtTryStmt /*P*/ AT = cast_ObjCAtTryStmt(S);
        {
          uint$ref NewParentScope = create_uint$ref(Scopes.size());
          Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                  diag.note_protected_by_objc_try, 
                  diag.note_exits_objc_try, 
                  AT.getAtTryLoc()));
          {
            Stmt /*P*/ TryPart = AT.getTryBody();
            if ((TryPart != null)) {
              BuildScopeInformation(TryPart, NewParentScope);
            }
          }
        }
        
        // Jump from the catch to the finally or try is not valid.
        for (/*uint*/int I = 0, N = AT.getNumCatchStmts(); I != N; ++I) {
          ObjCAtCatchStmt /*P*/ AC = AT.getCatchStmt(I);
          uint$ref NewParentScope = create_uint$ref(Scopes.size());
          Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                  diag.note_protected_by_objc_catch, 
                  diag.note_exits_objc_catch, 
                  AC.getAtCatchLoc()));
          // @catches are nested and it isn't
          BuildScopeInformation(AC.getCatchBody(), NewParentScope);
        }
        {
          
          // Jump from the finally to the try or catch is not valid.
          ObjCAtFinallyStmt /*P*/ AF = AT.getFinallyStmt();
          if ((AF != null)) {
            uint$ref NewParentScope = create_uint$ref(Scopes.size());
            Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                    diag.note_protected_by_objc_finally, 
                    diag.note_exits_objc_finally, 
                    AF.getAtFinallyLoc()));
            BuildScopeInformation(AF, NewParentScope);
          }
        }
        
        return;
      }
     case ObjCAtSynchronizedStmtClass:
      {
        // Disallow jumps into the protected statement of an @synchronized, but
        // allow jumps into the object expression it protects.
        ObjCAtSynchronizedStmt /*P*/ AS = cast_ObjCAtSynchronizedStmt(S);
        // Recursively walk the AST for the @synchronized object expr, it is
        // evaluated in the normal scope.
        BuildScopeInformation(AS.getSynchExpr(), ParentScope);
        
        // Recursively walk the AST for the @synchronized part, protected by a new
        // scope.
        uint$ref NewParentScope = create_uint$ref(Scopes.size());
        Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                diag.note_protected_by_objc_synchronized, 
                diag.note_exits_objc_synchronized, 
                AS.getAtSynchronizedLoc()));
        BuildScopeInformation(AS.getSynchBody(), NewParentScope);
        return;
      }
     case ObjCAutoreleasePoolStmtClass:
      {
        // Disallow jumps into the protected statement of an @autoreleasepool.
        ObjCAutoreleasePoolStmt /*P*/ AS = cast_ObjCAutoreleasePoolStmt(S);
        // Recursively walk the AST for the @autoreleasepool part, protected by a
        // new scope.
        uint$ref NewParentScope = create_uint$ref(Scopes.size());
        Scopes.push_back(new GotoScope(ParentScope.$deref(), 
                diag.note_protected_by_objc_autoreleasepool, 
                diag.note_exits_objc_autoreleasepool, 
                AS.getAtLoc()));
        BuildScopeInformation(AS.getSubStmt(), NewParentScope);
        return;
      }
     case ExprWithCleanupsClass:
      {
        // Disallow jumps past full-expressions that use blocks with
        // non-trivial cleanups of their captures.  This is theoretically
        // implementable but a lot of work which we haven't felt up to doing.
        ExprWithCleanups /*P*/ EWC = cast_ExprWithCleanups(S);
        for (/*uint*/int i = 0, e = EWC.getNumObjects(); i != e; ++i) {
          /*const*/ BlockDecl /*P*/ BDecl = EWC.getObject(i);
          for (final /*const*/ BlockDecl.Capture /*&*/ CI : BDecl.captures()) {
            VarDecl /*P*/ variable = CI.getVariable();
            BuildScopeInformation(variable, BDecl, origParentScope);
          }
        }
        break;
      }
     case MaterializeTemporaryExprClass:
      {
        // Disallow jumps out of scopes containing temporaries lifetime-extended to
        // automatic storage duration.
        MaterializeTemporaryExpr /*P*/ MTE = cast_MaterializeTemporaryExpr(S);
        if (MTE.getStorageDuration() == StorageDuration.SD_Automatic) {
          SmallVector</*const*/ Expr /*P*/ > CommaLHS/*J*/= new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
          SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(4, new SubobjectAdjustment());
          /*const*/ Expr /*P*/ ExtendedObject = MTE.GetTemporaryExpr().skipRValueSubobjectAdjustments(CommaLHS, Adjustments);
          if ((ExtendedObject.getType().isDestructedType().getValue() != 0)) {
            Scopes.push_back(new GotoScope(ParentScope.$deref(), 0, 
                    diag.note_exits_temporary_dtor, 
                    ExtendedObject.getExprLoc()));
            origParentScope.$set(Scopes.size() - 1);
          }
        }
        break;
      }
     case CaseStmtClass:
     case DefaultStmtClass:
     case LabelStmtClass:
      LabelAndGotoScopes.$set(S, ParentScope.$deref());
      break;
     default:
      break;
    }
    
    for (Stmt /*P*/ SubStmt : S.children()) {
      if (!(SubStmt != null)) {
        continue;
      }
      if ((StmtsToSkip != 0)) {
        --StmtsToSkip;
        continue;
      }
      
      // Cases, labels, and defaults aren't "scope parents".  It's also
      // important to handle these iteratively instead of recursively in
      // order to avoid blowing out the stack.
      while (true) {
        Stmt /*P*/ Next;
        {
          CaseStmt /*P*/ CS = dyn_cast_CaseStmt(SubStmt);
          if ((CS != null)) {
            Next = CS.getSubStmt();
          } else {
            DefaultStmt /*P*/ DS = dyn_cast_DefaultStmt(SubStmt);
            if ((DS != null)) {
              Next = DS.getSubStmt();
            } else {
              LabelStmt /*P*/ LS = dyn_cast_LabelStmt(SubStmt);
              if ((LS != null)) {
                Next = LS.getSubStmt();
              } else {
                break;
              }
            }
          }
        }
        
        LabelAndGotoScopes.$set(SubStmt, ParentScope.$deref());
        SubStmt = Next;
      }
      
      // Recursively walk the AST.
      BuildScopeInformation(SubStmt, ParentScope);
    }
  }

  
  
  /// VerifyJumps - Verify each element of the Jumps array to see if they are
  /// valid, emitting diagnostics if not.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::VerifyJumps">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 576,
   FQN="(anonymous namespace)::JumpScopeChecker::VerifyJumps", NM="_ZN12_GLOBAL__N_116JumpScopeChecker11VerifyJumpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker11VerifyJumpsEv")
  //</editor-fold>
  private void VerifyJumps() {
    while (!Jumps.empty()) {
      Stmt /*P*/ Jump = Jumps.pop_back_val();
      {
        
        // With a goto,
        GotoStmt /*P*/ GS = dyn_cast_GotoStmt(Jump);
        if ((GS != null)) {
          // The label may not have a statement if it's coming from inline MS ASM.
          if ((GS.getLabel().getStmt() != null)) {
            CheckJump(GS, GS.getLabel().getStmt(), GS.getGotoLoc(), 
                diag.err_goto_into_protected_scope, 
                diag.ext_goto_into_protected_scope, 
                diag.warn_cxx98_compat_goto_into_protected_scope);
          }
          CheckGotoStmt(GS);
          continue;
        }
      }
      {
        
        // We only get indirect gotos here when they have a constant target.
        IndirectGotoStmt /*P*/ IGS = dyn_cast_IndirectGotoStmt(Jump);
        if ((IGS != null)) {
          LabelDecl /*P*/ Target = IGS.getConstantTarget();
          CheckJump(IGS, Target.getStmt(), IGS.getGotoLoc(), 
              diag.err_goto_into_protected_scope, 
              diag.ext_goto_into_protected_scope, 
              diag.warn_cxx98_compat_goto_into_protected_scope);
          continue;
        }
      }
      
      SwitchStmt /*P*/ SS = cast_SwitchStmt(Jump);
      for (SwitchCase /*P*/ SC = SS.getSwitchCaseList(); (SC != null);
           SC = SC.getNextSwitchCase()) {
        assert (Permissive || !(!(LabelAndGotoScopes.count(SC) != 0)));
        if (Permissive && (!(LabelAndGotoScopes.count(SC) != 0))) {
          continue;
        }
        SourceLocation Loc/*J*/= new SourceLocation();
        {
          CaseStmt /*P*/ CS = dyn_cast_CaseStmt(SC);
          if ((CS != null)) {
            Loc.$assignMove(CS.getLocStart());
          } else {
            DefaultStmt /*P*/ DS = dyn_cast_DefaultStmt(SC);
            if ((DS != null)) {
              Loc.$assignMove(DS.getLocStart());
            } else {
              Loc.$assignMove(SC.getLocStart());
            }
          }
        }
        CheckJump(SS, SC, new SourceLocation(Loc), diag.err_switch_into_protected_scope, 0, 
            diag.warn_cxx98_compat_switch_into_protected_scope);
      }
    }
  }

  
  /// VerifyIndirectJumps - Verify whether any possible indirect jump
  /// might cross a protection boundary.  Unlike direct jumps, indirect
  /// jumps count cleanups as protection boundaries:  since there's no
  /// way to know where the jump is going, we can't implicitly run the
  /// right cleanups the way we can with direct jumps.
  ///
  /// Thus, an indirect jump is "trivial" if it bypasses no
  /// initializations and no teardowns.  More formally, an indirect jump
  /// from A to B is trivial if the path out from A to DCA(A,B) is
  /// trivial and the path in from DCA(A,B) to B is trivial, where
  /// DCA(A,B) is the deepest common ancestor of A and B.
  /// Jump-triviality is transitive but asymmetric.
  ///
  /// A path in is trivial if none of the entered scopes have an InDiag.
  /// A path out is trivial is none of the exited scopes have an OutDiag.
  ///
  /// Under these definitions, this function checks that the indirect
  /// jump between A and B is trivial for every indirect goto statement A
  /// and every label B whose address was taken in the function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::VerifyIndirectJumps">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 640,
   FQN="(anonymous namespace)::JumpScopeChecker::VerifyIndirectJumps", NM="_ZN12_GLOBAL__N_116JumpScopeChecker19VerifyIndirectJumpsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker19VerifyIndirectJumpsEv")
  //</editor-fold>
  private void VerifyIndirectJumps() {
    BitVector Reachable = null;
    try {
      if (IndirectJumps.empty()) {
        return;
      }
      
      // If there aren't any address-of-label expressions in this function,
      // complain about the first indirect goto.
      if (IndirectJumpTargets.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(IndirectJumps.$at(0).getGotoLoc(), 
              diag.err_indirect_goto_without_addrlabel)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Collect a single representative of every scope containing an
      // indirect goto.  For most code bases, this substantially cuts
      // down on the number of jump sites we'll have to consider later.
      /*typedef std::pair<unsigned int, IndirectGotoStmt *> JumpScope*/
//      final class JumpScope extends std.pairUIntType<IndirectGotoStmt /*P*/ >{ };
      SmallVector<std.pairUIntType<IndirectGotoStmt /*P*/ >> JumpScopes/*J*/= new SmallVector<std.pairUIntType<IndirectGotoStmt /*P*/ >>(32, new std.pairUIntPtr<IndirectGotoStmt /*P*/ >());
      {
        DenseMapUIntType<IndirectGotoStmt /*P*/ > JumpScopesMap/*J*/= new DenseMapUIntType<IndirectGotoStmt /*P*/ >(DenseMapInfoUInt.$Info(), (IndirectGotoStmt /*P*/ )null);
        for (type$ptr<IndirectGotoStmt /*P*/ /*P*/> I = $tryClone(IndirectJumps.begin()), /*P*/ E = $tryClone(IndirectJumps.end()); $noteq_ptr(I, E); I.$preInc()) {
          IndirectGotoStmt /*P*/ IG = I.$star();
          assert (Permissive || !(!(LabelAndGotoScopes.count(IG) != 0)));
          if (Permissive && (!(LabelAndGotoScopes.count(IG) != 0))) {
            continue;
          }
          /*uint*/int IGScope = LabelAndGotoScopes.$at_T1$RR(IG);
          final type$ref<IndirectGotoStmt /*P*/ /*&*/> Entry = JumpScopesMap.ref$at(IGScope);
          if (!(Entry.$deref() != null)) {
            Entry.$set(IG);
          }
        }
        JumpScopes.reserve(JumpScopesMap.size());
        for (DenseMapIteratorUIntType<IndirectGotoStmt /*P*/> I = JumpScopesMap.begin(), E = JumpScopesMap.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
          JumpScopes.push_back(I.$star());
        }
      }
      
      // Collect a single representative of every scope containing a
      // label whose address was taken somewhere in the function.
      // For most code bases, there will be only one such scope.
      DenseMapUIntType<LabelDecl /*P*/ > TargetScopes/*J*/= new DenseMapUIntType<LabelDecl /*P*/ >(DenseMapInfoUInt.$Info(), (LabelDecl /*P*/ )null);
      for (type$ptr<LabelDecl /*P*/ /*P*/> I = $tryClone(IndirectJumpTargets.begin()), /*P*/ E = $tryClone(IndirectJumpTargets.end());
           $noteq_ptr(I, E); I.$preInc()) {
        LabelDecl /*P*/ TheLabel = I.$star();
        assert (Permissive || !(!(LabelAndGotoScopes.count(TheLabel.getStmt()) != 0)));
        if (Permissive && (!(LabelAndGotoScopes.count(TheLabel.getStmt()) != 0))) {
          continue;
        }
        /*uint*/int LabelScope = LabelAndGotoScopes.$at_T1$RR(TheLabel.getStmt());
        final type$ref<LabelDecl /*P*/ /*&*/> Target = TargetScopes.ref$at(LabelScope);
        if (!(Target.$deref() != null)) {
          Target.$set(TheLabel);
        }
      }
      
      // For each target scope, make sure it's trivially reachable from
      // every scope containing a jump site.
      //
      // A path between scopes always consists of exitting zero or more
      // scopes, then entering zero or more scopes.  We build a set of
      // of scopes S from which the target scope can be trivially
      // entered, then verify that every jump scope can be trivially
      // exitted to reach a scope in S.
      Reachable/*J*/= new BitVector(Scopes.size(), false);
      for (DenseMapIteratorUIntType<LabelDecl /*P*/> TI = TargetScopes.begin(), TE = TargetScopes.end(); TI.$noteq(/*NO_ITER_COPY*/TE); TI.$preInc()) {
        /*uint*/int TargetScope = TI.$arrow().first;
        LabelDecl /*P*/ TargetLabel = TI.$arrow().second;
        
        Reachable.reset();
        
        // Mark all the enclosing scopes from which you can safely jump
        // into the target scope.  'Min' will end up being the index of
        // the shallowest such scope.
        /*uint*/int Min = TargetScope;
        while (true) {
          Reachable.set(Min);
          
          // Don't go beyond the outermost scope.
          if (Min == 0) {
            break;
          }
          
          // Stop if we can't trivially enter the current scope.
          if ((Scopes.$at(Min).InDiag != 0)) {
            break;
          }
          
          Min = Scopes.$at(Min).ParentScope;
        }
        
        // Walk through all the jump sites, checking that they can trivially
        // reach this label scope.
        for (type$ptr<std.pairUIntType<IndirectGotoStmt /*P*/ >> I = $tryClone(JumpScopes.begin()), /*P*/ E = $tryClone(JumpScopes.end()); $noteq_ptr(I, E); I.$preInc()) {
          /*uint*/int Scope = I./*->*/$star().first;
          
          // Walk out the "scope chain" for this scope, looking for a scope
          // we've marked reachable.  For well-formed code this amortizes
          // to O(JumpScopes.size() / Scopes.size()):  we only iterate
          // when we see something unmarked, and in well-formed code we
          // mark everything we iterate past.
          boolean IsReachable = false;
          while (true) {
            if (Reachable.test(Scope)) {
              // If we find something reachable, mark all the scopes we just
              // walked through as reachable.
              for (/*uint*/int S = I./*->*/$star().first; S != Scope; S = Scopes.$at(S).ParentScope)  {
                Reachable.set(S);
              }
              IsReachable = true;
              break;
            }
            
            // Don't walk out if we've reached the top-level scope or we've
            // gotten shallower than the shallowest reachable scope.
            if (Scope == 0 || $less_uint(Scope, Min)) {
              break;
            }
            
            // Don't walk out through an out-diagnostic.
            if ((Scopes.$at(Scope).OutDiag != 0)) {
              break;
            }
            
            Scope = Scopes.$at(Scope).ParentScope;
          }
          
          // Only diagnose if we didn't find something.
          if (IsReachable) {
            continue;
          }
          
          DiagnoseIndirectJump(I./*->*/$star().second, I./*->*/$star().first, TargetLabel, TargetScope);
        }
      }
    } finally {
      if (Reachable != null) { Reachable.$destroy(); }
    }
  }

  
  /// Produce note diagnostics for a jump into a protected scope.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::NoteJumpIntoScopes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 786,
   FQN="(anonymous namespace)::JumpScopeChecker::NoteJumpIntoScopes", NM="_ZN12_GLOBAL__N_116JumpScopeChecker18NoteJumpIntoScopesEN4llvm8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker18NoteJumpIntoScopesEN4llvm8ArrayRefIjEE")
  //</editor-fold>
  private void NoteJumpIntoScopes(ArrayRefUInt ToScopes) {
    assert (Permissive || !(ToScopes.empty()));
    if (Permissive && (ToScopes.empty())) {
      return;
    }
    for (/*uint*/int I = 0, E = ToScopes.size(); I != E; ++I)  {
      if ((Scopes.$at(ToScopes.$at(I)).InDiag != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(new SourceLocation(Scopes.$at(ToScopes.$at(I)).Loc), Scopes.$at(ToScopes.$at(I)).InDiag)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  /// Diagnose an indirect jump which is known to cross scopes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::DiagnoseIndirectJump">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 795,
   FQN="(anonymous namespace)::JumpScopeChecker::DiagnoseIndirectJump", NM="_ZN12_GLOBAL__N_116JumpScopeChecker20DiagnoseIndirectJumpEPN5clang16IndirectGotoStmtEjPNS1_9LabelDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker20DiagnoseIndirectJumpEPN5clang16IndirectGotoStmtEjPNS1_9LabelDeclEj")
  //</editor-fold>
  private void DiagnoseIndirectJump(IndirectGotoStmt /*P*/ Jump, 
                      /*uint*/int JumpScope, 
                      LabelDecl /*P*/ Target, 
                      /*uint*/int TargetScope) {
    assert (Permissive || !(JumpScope == TargetScope));
    if (Permissive && (JumpScope == TargetScope)) {
      return;
    }
    
    /*uint*/int Common = GetDeepestCommonScope(JumpScope, TargetScope);
    bool$ref Diagnosed = create_bool$ref(false);
    
    // Walk out the scope chain until we reach the common ancestor.
    for (/*uint*/int I = JumpScope; I != Common; I = Scopes.$at(I).ParentScope)  {
      if ((Scopes.$at(I).OutDiag != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          DiagnoseIndirectJumpStmt(S, Jump, Target, Diagnosed);
          $c$.clean($c$.track(S.Diag(new SourceLocation(Scopes.$at(I).Loc), Scopes.$at(I).OutDiag)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    SmallVectorUInt ToScopesCXX98Compat/*J*/= new SmallVectorUInt(10, 0);
    
    // Now walk into the scopes containing the label whose address was taken.
    for (/*uint*/int I = TargetScope; I != Common; I = Scopes.$at(I).ParentScope)  {
      if (IsCXX98CompatWarning(S, Scopes.$at(I).InDiag)) {
        ToScopesCXX98Compat.push_back(I);
      } else if ((Scopes.$at(I).InDiag != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          DiagnoseIndirectJumpStmt(S, Jump, Target, Diagnosed);
          $c$.clean($c$.track(S.Diag(new SourceLocation(Scopes.$at(I).Loc), Scopes.$at(I).InDiag)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Diagnose this jump if it would be ill-formed in C++98.
    if (!Diagnosed.$deref() && !ToScopesCXX98Compat.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(Jump.getGotoLoc(), 
            diag.warn_cxx98_compat_indirect_goto_in_protected_scope)));
        $c$.clean($c$.track(S.Diag(Target.getStmt().getIdentLoc(), diag.note_indirect_goto_target)));
        NoteJumpIntoScopes(new ArrayRefUInt(ToScopesCXX98Compat));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// CheckJump - Validate that the specified jump statement is valid: that it is
  /// jumping within or out of its current scope, not into a deeper one.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::CheckJump">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 834,
   FQN="(anonymous namespace)::JumpScopeChecker::CheckJump", NM="_ZN12_GLOBAL__N_116JumpScopeChecker9CheckJumpEPN5clang4StmtES3_NS1_14SourceLocationEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker9CheckJumpEPN5clang4StmtES3_NS1_14SourceLocationEjjj")
  //</editor-fold>
  private void CheckJump(Stmt /*P*/ From, Stmt /*P*/ To, SourceLocation DiagLoc, 
           /*uint*/int JumpDiagError, /*uint*/int JumpDiagWarning, 
           /*uint*/int JumpDiagCXX98Compat) {
    assert (Permissive || !(!(LabelAndGotoScopes.count(From) != 0)));
    if (Permissive && (!(LabelAndGotoScopes.count(From) != 0))) {
      return;
    }
    assert Permissive || !(!(LabelAndGotoScopes.count(To) != 0));
    if ((Permissive && (!(LabelAndGotoScopes.count(To) != 0)))) {
      return;
    }
    
    /*uint*/int FromScope = LabelAndGotoScopes.$at_T1$C$R(From);
    /*uint*/int ToScope = LabelAndGotoScopes.$at_T1$C$R(To);
    
    // Common case: exactly the same scope, which is fine.
    if (FromScope == ToScope) {
      return;
    }
    
    // Warn on gotos out of __finally blocks.
    if (isa_GotoStmt(From) || isa_IndirectGotoStmt(From)) {
      // If FromScope > ToScope, FromScope is more nested and the jump goes to a
      // less nested scope.  Check if it crosses a __finally along the way.
      for (/*uint*/int I = FromScope; $greater_uint(I, ToScope); I = Scopes.$at(I).ParentScope) {
        if (Scopes.$at(I).InDiag == diag.note_protected_by_seh_finally) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(From.getLocStart(), diag.warn_jump_out_of_seh_finally)));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    /*uint*/int CommonScope = GetDeepestCommonScope(FromScope, ToScope);
    
    // It's okay to jump out from a nested scope.
    if (CommonScope == ToScope) {
      return;
    }
    
    // Pull out (and reverse) any scopes we might need to diagnose skipping.
    SmallVectorUInt ToScopesCXX98Compat/*J*/= new SmallVectorUInt(10, 0);
    SmallVectorUInt ToScopesError/*J*/= new SmallVectorUInt(10, 0);
    SmallVectorUInt ToScopesWarning/*J*/= new SmallVectorUInt(10, 0);
    for (/*uint*/int I = ToScope; I != CommonScope; I = Scopes.$at(I).ParentScope) {
      if (S.getLangOpts().MSVCCompat && JumpDiagWarning != 0
         && IsMicrosoftJumpWarning(JumpDiagError, Scopes.$at(I).InDiag)) {
        ToScopesWarning.push_back(I);
      } else if (IsCXX98CompatWarning(S, Scopes.$at(I).InDiag)) {
        ToScopesCXX98Compat.push_back(I);
      } else if ((Scopes.$at(I).InDiag != 0)) {
        ToScopesError.push_back(I);
      }
    }
    
    // Handle warnings.
    if (!ToScopesWarning.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(DiagLoc), JumpDiagWarning)));
        NoteJumpIntoScopes(new ArrayRefUInt(ToScopesWarning));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Handle errors.
    if (!ToScopesError.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(DiagLoc), JumpDiagError)));
        NoteJumpIntoScopes(new ArrayRefUInt(ToScopesError));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Handle -Wc++98-compat warnings if the jump is well-formed.
    if (ToScopesError.empty() && !ToScopesCXX98Compat.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(DiagLoc), JumpDiagCXX98Compat)));
        NoteJumpIntoScopes(new ArrayRefUInt(ToScopesCXX98Compat));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::CheckGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 898,
   FQN="(anonymous namespace)::JumpScopeChecker::CheckGotoStmt", NM="_ZN12_GLOBAL__N_116JumpScopeChecker13CheckGotoStmtEPN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker13CheckGotoStmtEPN5clang8GotoStmtE")
  //</editor-fold>
  private void CheckGotoStmt(GotoStmt /*P*/ GS) {
    if (GS.getLabel().isMSAsmLabel()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(GS.getGotoLoc(), diag.err_goto_ms_asm_label)), 
            GS.getLabel().getIdentifier()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(GS.getLabel().getLocation(), diag.note_goto_ms_asm_label)), 
            GS.getLabel().getIdentifier()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  
  /// GetDeepestCommonScope - Finds the innermost scope enclosing the
  /// two scopes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::GetDeepestCommonScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 112,
   FQN="(anonymous namespace)::JumpScopeChecker::GetDeepestCommonScope", NM="_ZN12_GLOBAL__N_116JumpScopeChecker21GetDeepestCommonScopeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeChecker21GetDeepestCommonScopeEjj")
  //</editor-fold>
  private /*uint*/int GetDeepestCommonScope(/*uint*/int A, /*uint*/int B) {
    while (A != B) {
      // Inner scopes are created after outer scopes and therefore have
      // higher indices.
      if ($less_uint(A, B)) {
        assert ($less_uint(Scopes.$at(B).ParentScope, B));
        B = Scopes.$at(B).ParentScope;
      } else {
        assert ($less_uint(Scopes.$at(A).ParentScope, A));
        A = Scopes.$at(A).ParentScope;
      }
    }
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JumpScopeChecker::~JumpScopeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp", line = 32,
   FQN="(anonymous namespace)::JumpScopeChecker::~JumpScopeChecker", NM="_ZN12_GLOBAL__N_116JumpScopeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/JumpDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116JumpScopeCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IndirectJumpTargets.$destroy();
    IndirectJumps.$destroy();
    Jumps.$destroy();
    LabelAndGotoScopes.$destroy();
    Scopes.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Permissive=" + Permissive // NOI18N
              + ", Scopes=" + Scopes // NOI18N
              + ", LabelAndGotoScopes=" + LabelAndGotoScopes // NOI18N
              + ", Jumps=" + Jumps // NOI18N
              + ", IndirectJumps=" + IndirectJumps // NOI18N
              + ", IndirectJumpTargets=" + IndirectJumpTargets; // NOI18N
  }
}
