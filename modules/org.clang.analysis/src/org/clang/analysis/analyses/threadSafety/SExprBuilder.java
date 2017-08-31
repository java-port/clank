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

package org.clang.analysis.analyses.threadSafety;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import org.clang.analysis.analyses.threadSafety.*;
import static org.clang.analysis.analyses.threadSafety.til.ThreadSafetyTIL.ThreadSafetyTILGlobals.*;
import static org.clang.analysis.analyses.threadSafety.til.TilGlobals.*;
import static org.clang.analysis.impl.ThreadSafetyCommonStatics.*;
import org.clang.analysis.java.AnalysisJavaDifferentiators.*;
import org.clang.analysis.java.BaseVisitor;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


// Translate clang::Expr to til::SExpr.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 315,
 FQN="clang::threadSafety::SExprBuilder", NM="_ZN5clang12threadSafety12SExprBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilderE")
//</editor-fold>
public class SExprBuilder implements BaseVisitor, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Encapsulates the lexical context of a function call.  The lexical
  /// context includes the arguments to the call, including the implicit object
  /// argument.  When an attribute containing a mutex expression is attached to
  /// a method, the expression may refer to formal parameters of the method.
  /// Actual arguments must be substituted for formal parameters to derive
  /// the appropriate mutex expression in the lexical context where the function
  /// is called.  PrevCtx holds the context in which the arguments themselves
  /// should be evaluated; multiple calling contexts can be chained together
  /// by the lock_returned attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::CallingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 326,
   FQN="clang::threadSafety::SExprBuilder::CallingContext", NM="_ZN5clang12threadSafety12SExprBuilder14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder14CallingContextE")
  //</editor-fold>
  public static class/*struct*/ CallingContext {
    public CallingContext /*P*/ Prev; // The previous context; or 0 if none.
    public /*const*/ NamedDecl /*P*/ AttrDecl; // The decl to which the attr is attached.
    public /*const*/ Expr /*P*/ SelfArg; // Implicit object argument -- e.g. 'this'
    public /*uint*/int NumArgs; // Number of funArgs
    public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> FunArgs; // Function arguments
    public boolean SelfArrow; // is Self referred to with -> or .?
    
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::CallingContext::CallingContext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 334,
     FQN="clang::threadSafety::SExprBuilder::CallingContext::CallingContext", NM="_ZN5clang12threadSafety12SExprBuilder14CallingContextC1EPS2_PKNS_9NamedDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder14CallingContextC1EPS2_PKNS_9NamedDeclE")
    //</editor-fold>
    public CallingContext(CallingContext /*P*/ P) {
      this(P, (/*const*/ NamedDecl /*P*/ )null);
    }
    public CallingContext(CallingContext /*P*/ P, /*const*/ NamedDecl /*P*/ D/*= null*/) {
      // : Prev(P), AttrDecl(D), SelfArg(null), NumArgs(0), FunArgs(null), SelfArrow(false) 
      //START JInit
      this.Prev = P;
      this.AttrDecl = D;
      this.SelfArg = null;
      this.NumArgs = 0;
      this.FunArgs = null;
      this.SelfArrow = false;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private CallingContext(JD$CallingContext$P_NamedDecl$C$P INSTANCE, CallingContext callingContext, NamedDecl D) { this(callingContext, D); }
    
    private CallingContext(JD$CallingContext$P_NamedDecl$C$P INSTANCE, CallingContext Ctx) { this(Ctx); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Prev=" + "[CallingContext]" // NOI18N
                + ", AttrDecl=" + AttrDecl // NOI18N
                + ", SelfArg=" + SelfArg // NOI18N
                + ", NumArgs=" + NumArgs // NOI18N
                + ", FunArgs=" + FunArgs // NOI18N
                + ", SelfArrow=" + SelfArrow; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::SExprBuilder">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 340,
   FQN="clang::threadSafety::SExprBuilder::SExprBuilder", NM="_ZN5clang12threadSafety12SExprBuilderC1ENS0_3til12MemRegionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilderC1ENS0_3til12MemRegionRefE")
  //</editor-fold>
  public SExprBuilder(MemRegionRef A) {
    // : Arena(A), SelfVar(null), Scfg(null), SMap(), LVarIdxMap(), BlockMap(), BBInfo(), CurrentLVarMap(), CurrentArguments(), CurrentInstructions(), IncompleteArgs(), CurrentBB(null), CurrentBlockInfo(null) 
    //START JInit
    this.Arena = new MemRegionRef(A);
    this.SelfVar = null;
    this.Scfg = null;
    this.SMap = new DenseMap</*const*/ Stmt /*P*/ , SExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (SExpr /*P*/ )null);
    this.LVarIdxMap = new DenseMapTypeUInt</*const*/ ValueDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.BlockMap = new std.vector<BasicBlock /*P*/ >((BasicBlock /*P*/ )null);
    this.BBInfo = new std.vector<BlockInfo>(()->new BlockInfo());
    this.CurrentLVarMap = new CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > >();
    this.CurrentArguments = new std.vector<Phi /*P*/ >((Phi /*P*/ )null);
    this.CurrentInstructions = new std.vector<SExpr /*P*/ >((SExpr /*P*/ )null);
    this.IncompleteArgs = new std.vector<Phi /*P*/ >((Phi /*P*/ )null);
    this.CurrentBB = null;
    this.CurrentBlockInfo = null;
    //END JInit
    // FIXME: we don't always have a self-variable.
    SelfVar = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Variable((SExpr /*P*/ )null);
     });
    SelfVar.setKind(Variable.VariableKind.VK_SFun);
  }

  
  // Translate a clang expression in an attribute to a til::SExpr.
  // Constructs the context from D, DeclExp, and SelfDecl.
  
  // Translate a clang expression in an attribute to a til::SExpr.
  // Constructs the context from D, DeclExp, and SelfDecl.
  
  /// \brief Translate a clang expression in an attribute to a til::SExpr.
  /// Constructs the context from D, DeclExp, and SelfDecl.
  ///
  /// \param AttrExp The expression to translate.
  /// \param D       The declaration to which the attribute is attached.
  /// \param DeclExp An expression involving the Decl to which the attribute
  ///                is attached.  E.g. the call to a function.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateAttrExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 94,
   FQN="clang::threadSafety::SExprBuilder::translateAttrExpr", NM="_ZN5clang12threadSafety12SExprBuilder17translateAttrExprEPKNS_4ExprEPKNS_9NamedDeclES4_PNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17translateAttrExprEPKNS_4ExprEPKNS_9NamedDeclES4_PNS_7VarDeclE")
  //</editor-fold>
  public CapabilityExpr translateAttrExpr(/*const*/ Expr /*P*/ AttrExp, 
                   /*const*/ NamedDecl /*P*/ D, 
                   /*const*/ Expr /*P*/ DeclExp) {
    return translateAttrExpr(AttrExp, 
                   D, 
                   DeclExp, 
                   (VarDecl /*P*/ )null);
  }
  public CapabilityExpr translateAttrExpr(/*const*/ Expr /*P*/ AttrExp, 
                   /*const*/ NamedDecl /*P*/ D, 
                   /*const*/ Expr /*P*/ DeclExp, 
                   VarDecl /*P*/ SelfDecl/*= null*/) {
    // If we are processing a raw attribute expression, with no substitutions.
    if (!(DeclExp != null)) {
      return translateAttrExpr(AttrExp, (CallingContext /*P*/ )null);
    }
    
    CallingContext Ctx/*J*/= new CallingContext(JD$CallingContext$P_NamedDecl$C$P.INSTANCE, (CallingContext /*P*/ )null, D);
    {
      
      // Examine DeclExp to find SelfArg and FunArgs, which are used to substitute
      // for formal parameters when we call buildMutexID later.
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(DeclExp);
      if ((ME != null)) {
        Ctx.SelfArg = ME.getBase();
        Ctx.SelfArrow = ME.isArrow();
      } else {
        /*const*/ CXXMemberCallExpr /*P*/ CE = dyn_cast_CXXMemberCallExpr(DeclExp);
        if ((CE != null)) {
          Ctx.SelfArg = CE.getImplicitObjectArgument();
          Ctx.SelfArrow = isCalleeArrow(CE.getCallee$Const());
          Ctx.NumArgs = CE.getNumArgs();
          Ctx.FunArgs = $tryClone(CE.getArgs$Const());
        } else {
          /*const*/ CallExpr /*P*/ CE$1 = dyn_cast_CallExpr(DeclExp);
          if ((CE$1 != null)) {
            Ctx.NumArgs = CE$1.getNumArgs();
            Ctx.FunArgs = $tryClone(CE$1.getArgs$Const());
          } else {
            /*const*/ CXXConstructExpr /*P*/ CE$2 = dyn_cast_CXXConstructExpr(DeclExp);
            if ((CE$2 != null)) {
              Ctx.SelfArg = null; // Will be set below
              Ctx.NumArgs = CE$2.getNumArgs();
              Ctx.FunArgs = $tryClone(CE$2.getArgs$Const());
            } else if ((D != null) && isa_CXXDestructorDecl(D)) {
              // There's no such thing as a "destructor call" in the AST.
              Ctx.SelfArg = DeclExp;
            }
          }
        }
      }
    }
    
    // Hack to handle constructors, where self cannot be recovered from
    // the expression.
    if ((SelfDecl != null) && !(Ctx.SelfArg != null)) {
      DeclRefExpr SelfDRE/*J*/= new DeclRefExpr(SelfDecl, false, SelfDecl.getType(), ExprValueKind.VK_LValue, 
          SelfDecl.getLocation());
      Ctx.SelfArg = $AddrOf(SelfDRE);
      
      // If the attribute has no arguments, then assume the argument is "this".
      if (!(AttrExp != null)) {
        return translateAttrExpr(Ctx.SelfArg, (CallingContext /*P*/ )null);
      } else { // For most attributes.
        return translateAttrExpr(AttrExp, $AddrOf(Ctx));
      }
    }
    
    // If the attribute has no arguments, then assume the argument is "this".
    if (!(AttrExp != null)) {
      return translateAttrExpr(Ctx.SelfArg, (CallingContext /*P*/ )null);
    } else { // For most attributes.
      return translateAttrExpr(AttrExp, $AddrOf(Ctx));
    }
  }


  
  /// \brief Translate a clang expression in an attribute to a til::SExpr.
  // This assumes a CallingContext has already been created.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateAttrExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 151,
   FQN="clang::threadSafety::SExprBuilder::translateAttrExpr", NM="_ZN5clang12threadSafety12SExprBuilder17translateAttrExprEPKNS_4ExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17translateAttrExprEPKNS_4ExprEPNS1_14CallingContextE")
  //</editor-fold>
  public CapabilityExpr translateAttrExpr(/*const*/ Expr /*P*/ AttrExp, 
                   CallingContext /*P*/ Ctx) {
    if (!(AttrExp != null)) {
      return new CapabilityExpr((/*const*/ SExpr /*P*/ )null, false);
    }
    {
      
      /*const*/ StringLiteral /*P*/ SLit = dyn_cast_StringLiteral(AttrExp);
      if ((SLit != null)) {
        if ($eq_StringRef(SLit.getString(), /*STRINGREF_STR*/"*")) {
          // The "*" expr is a universal lock, which essentially turns off
          // checks until it is removed from the lockset.
          return new CapabilityExpr(/*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
                  return new Wildcard();
               }), false);
        } else {
          // Ignore other string literals for now.
          return new CapabilityExpr((/*const*/ SExpr /*P*/ )null, false);
        }
      }
    }
    
    boolean Neg = false;
    {
      /*const*/ CXXOperatorCallExpr /*P*/ OE = dyn_cast_CXXOperatorCallExpr(AttrExp);
      if ((OE != null)) {
        if (OE.getOperator() == OverloadedOperatorKind.OO_Exclaim) {
          Neg = true;
          AttrExp = OE.getArg$Const(0);
        }
      } else {
        /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(AttrExp);
        if ((UO != null)) {
          if (UO.getOpcode() == UnaryOperatorKind.UO_LNot) {
            Neg = true;
            AttrExp = UO.getSubExpr();
          }
        }
      }
    }
    
    SExpr /*P*/ E = translate(AttrExp, Ctx);
    
    // Trap mutex expressions like nullptr, or 0.
    // Any literal value is nonsense.
    if (!(E != null) || isa_Literal(E)) {
      return new CapabilityExpr((/*const*/ SExpr /*P*/ )null, false);
    }
    {
      
      // Hack to deal with smart pointers -- strip off top-level pointer casts.
      Cast /*P*/ CE = dyn_cast_or_null_Cast(E);
      if ((CE != null)) {
        if (CE.castOpcode() == TIL_CastOpcode.CAST_objToPtr) {
          return new CapabilityExpr(CE.expr(), Neg);
        }
      }
    }
    return new CapabilityExpr(E, Neg);
  }


  
  // Translate a clang statement or expression to a TIL expression.
  // Also performs substitution of variables; Ctx provides the context.
  // Dispatches on the type of S.
  
  // Translate a clang statement or expression to a TIL expression.
  // Also performs substitution of variables; Ctx provides the context.
  // Dispatches on the type of S.
  
  // Translate a clang statement or expression to a TIL expression.
  // Also performs substitution of variables; Ctx provides the context.
  // Dispatches on the type of S.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 198,
   FQN="clang::threadSafety::SExprBuilder::translate", NM="_ZN5clang12threadSafety12SExprBuilder9translateEPKNS_4StmtEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9translateEPKNS_4StmtEPNS1_14CallingContextE")
  //</editor-fold>
  public SExpr /*P*/ translate(/*const*/ Stmt /*P*/ S, CallingContext /*P*/ Ctx) {
    if (!(S != null)) {
      return null;
    }
    {
      
      // Check if S has already been translated and cached.
      // This handles the lookup of SSA names for DeclRefExprs here.
      SExpr /*P*/ E = lookupStmt(S);
      if ((E != null)) {
        return E;
      }
    }
    switch (S.getStmtClass()) {
     case DeclRefExprClass:
      return translateDeclRefExpr(cast_DeclRefExpr(S), Ctx);
     case CXXThisExprClass:
      return translateCXXThisExpr(cast_CXXThisExpr(S), Ctx);
     case MemberExprClass:
      return translateMemberExpr(cast_MemberExpr(S), Ctx);
     case CallExprClass:
      return translateCallExpr(cast_CallExpr(S), Ctx);
     case CXXMemberCallExprClass:
      return translateCXXMemberCallExpr(cast_CXXMemberCallExpr(S), Ctx);
     case CXXOperatorCallExprClass:
      return translateCXXOperatorCallExpr(cast_CXXOperatorCallExpr(S), Ctx);
     case UnaryOperatorClass:
      return translateUnaryOperator(cast_UnaryOperator(S), Ctx);
     case BinaryOperatorClass:
     case CompoundAssignOperatorClass:
      return translateBinaryOperator(cast_BinaryOperator(S), Ctx);
     case ArraySubscriptExprClass:
      return translateArraySubscriptExpr(cast_ArraySubscriptExpr(S), Ctx);
     case ConditionalOperatorClass:
      return translateAbstractConditionalOperator(cast_ConditionalOperator(S), Ctx);
     case BinaryConditionalOperatorClass:
      return translateAbstractConditionalOperator(cast_BinaryConditionalOperator(S), Ctx);
     case ParenExprClass:
      
      // We treat these as no-ops
      return translate(cast_ParenExpr(S).getSubExpr$Const(), Ctx);
     case ExprWithCleanupsClass:
      return translate(cast_ExprWithCleanups(S).getSubExpr$Const(), Ctx);
     case CXXBindTemporaryExprClass:
      return translate(cast_CXXBindTemporaryExpr(S).getSubExpr$Const(), Ctx);
     case CharacterLiteralClass:
     case CXXNullPtrLiteralExprClass:
     case GNUNullExprClass:
     case CXXBoolLiteralExprClass:
     case FloatingLiteralClass:
     case ImaginaryLiteralClass:
     case IntegerLiteralClass:
     case StringLiteralClass:
     case ObjCStringLiteralClass:
      
      // Collect all literals
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Literal(cast_Expr(S));
       });
     case DeclStmtClass:
      return translateDeclStmt(cast_DeclStmt(S), Ctx);
     default:
      break;
    }
    {
      /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(S);
      if ((CE != null)) {
        return translateCastExpr(CE, Ctx);
      }
    }
    
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Undefined(S);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::buildCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 77,
   FQN="clang::threadSafety::SExprBuilder::buildCFG", NM="_ZN5clang12threadSafety12SExprBuilder8buildCFGERNS0_9CFGWalkerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder8buildCFGERNS0_9CFGWalkerE")
  //</editor-fold>
  public SCFG /*P*/ buildCFG(final CFGWalker /*&*/ Walker) {
    Walker.walk(/*Deref*/this);
    return Scfg;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::lookupStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 70,
   FQN="clang::threadSafety::SExprBuilder::lookupStmt", NM="_ZN5clang12threadSafety12SExprBuilder10lookupStmtEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder10lookupStmtEPKNS_4StmtE")
  //</editor-fold>
  public SExpr /*P*/ lookupStmt(/*const*/ Stmt /*P*/ S) {
    DenseMapIterator</*const*/ Stmt /*P*/ , SExpr /*P*/ > It = SMap.find(S);
    if (It.$noteq(/*NO_ITER_COPY*/SMap.end())) {
      return It.$arrow().second;
    }
    return null;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::lookupBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 363,
   FQN="clang::threadSafety::SExprBuilder::lookupBlock", NM="_ZN5clang12threadSafety12SExprBuilder11lookupBlockEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder11lookupBlockEPKNS_8CFGBlockE")
  //</editor-fold>
  public BasicBlock /*P*/ lookupBlock(/*const*/ CFGBlock /*P*/ B) {
    return BlockMap.$at(B.getBlockID());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::getCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 367,
   FQN="clang::threadSafety::SExprBuilder::getCFG", NM="_ZNK5clang12threadSafety12SExprBuilder6getCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety12SExprBuilder6getCFGEv")
  //</editor-fold>
  public /*const*/ SCFG /*P*/ getCFG$Const() /*const*/ {
    return Scfg;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::getCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 368,
   FQN="clang::threadSafety::SExprBuilder::getCFG", NM="_ZN5clang12threadSafety12SExprBuilder6getCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder6getCFGEv")
  //</editor-fold>
  public SCFG /*P*/ getCFG() {
    return Scfg;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateDeclRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 266,
   FQN="clang::threadSafety::SExprBuilder::translateDeclRefExpr", NM="_ZN5clang12threadSafety12SExprBuilder20translateDeclRefExprEPKNS_11DeclRefExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder20translateDeclRefExprEPKNS_11DeclRefExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateDeclRefExpr(/*const*/ DeclRefExpr /*P*/ DRE, 
                      CallingContext /*P*/ Ctx) {
    /*const*/ ValueDecl /*P*/ VD = cast_ValueDecl(DRE.getDecl$Const().getCanonicalDecl$Const());
    {
      
      // Function parameters require substitution and/or renaming.
      /*const*/ ParmVarDecl /*P*/ PV = dyn_cast_or_null_ParmVarDecl(VD);
      if ((PV != null)) {
        /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(PV.getDeclContext$Const()).getCanonicalDecl$Const();
        /*uint*/int I = PV.getFunctionScopeIndex();
        if ((Ctx != null) && Native.$bool(Ctx.FunArgs) && FD == Ctx.AttrDecl.getCanonicalDecl$Const()) {
          // Substitute call arguments for references to function parameters
          assert ($less_uint(I, Ctx.NumArgs));
          return translate(Ctx.FunArgs.$at(I), Ctx.Prev);
        }
        // Map the param back to the param of the original function declaration
        // for consistent comparisons.
        VD = FD.getParamDecl$Const(I);
      }
    }
    
    // For non-local variables, treat it as a reference to a named object.
    ValueDecl /*P*/ VDfinal = VD;
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new LiteralPtr(VDfinal);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 290,
   FQN="clang::threadSafety::SExprBuilder::translateCXXThisExpr", NM="_ZN5clang12threadSafety12SExprBuilder20translateCXXThisExprEPKNS_11CXXThisExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder20translateCXXThisExprEPKNS_11CXXThisExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateCXXThisExpr(/*const*/ CXXThisExpr /*P*/ TE, 
                      CallingContext /*P*/ Ctx) {
    // Substitute for 'this'
    if ((Ctx != null) && (Ctx.SelfArg != null)) {
      return translate(Ctx.SelfArg, Ctx.Prev);
    }
    assert ((SelfVar != null)) : "We have no variable for 'this'!";
    return SelfVar;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateMemberExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 334,
   FQN="clang::threadSafety::SExprBuilder::translateMemberExpr", NM="_ZN5clang12threadSafety12SExprBuilder19translateMemberExprEPKNS_10MemberExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder19translateMemberExprEPKNS_10MemberExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateMemberExpr(/*const*/ MemberExpr /*P*/ ME, 
                     CallingContext /*P*/ Ctx) {
    SExpr /*P*/ BE = translate(ME.getBase(), Ctx);
    SExpr /*P*/ E = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new SApply(BE);
     });
    
    /*const*/ ValueDecl /*P*/ D = cast_ValueDecl(ME.getMemberDecl().getCanonicalDecl());
    {
      /*const*/ CXXMethodDecl /*P*/ VD = dyn_cast_CXXMethodDecl(D);
      if ((VD != null)) {
        D = getFirstVirtualDecl(VD);
      }
    }
    
    ValueDecl /*P*/ VDfinal = D;
    Project /*P*/ P = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Project(E, VDfinal);
     });
    if (hasCppPointerType(BE)) {
      P.setArrow(true);
    }
    return P;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 350,
   FQN="clang::threadSafety::SExprBuilder::translateCallExpr", NM="_ZN5clang12threadSafety12SExprBuilder17translateCallExprEPKNS_8CallExprEPNS1_14CallingContextEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17translateCallExprEPKNS_8CallExprEPNS1_14CallingContextEPKNS_4ExprE")
  //</editor-fold>
  private SExpr /*P*/ translateCallExpr(/*const*/ CallExpr /*P*/ CE, 
                   CallingContext /*P*/ Ctx) {
    return translateCallExpr(CE, 
                   Ctx, 
                   (/*const*/ Expr /*P*/ )null);
  }
  private SExpr /*P*/ translateCallExpr(/*const*/ CallExpr /*P*/ CE, 
                   CallingContext /*P*/ Ctx, 
                   /*const*/ Expr /*P*/ SelfE/*= null*/) {
    if (CapabilityExprMode) {
      // Handle LOCK_RETURNED
      /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const().getMostRecentDecl$Redeclarable$Const();
      {
        LockReturnedAttr /*P*/ At = FD.getAttr(LockReturnedAttr.class);
        if ((At != null)) {
          CallingContext LRCallCtx/*J*/= new CallingContext(JD$CallingContext$P_NamedDecl$C$P.INSTANCE, Ctx);
          LRCallCtx.AttrDecl = CE.getDirectCallee$Const();
          LRCallCtx.SelfArg = SelfE;
          LRCallCtx.NumArgs = CE.getNumArgs();
          LRCallCtx.FunArgs = $tryClone(CE.getArgs$Const());
          return ((/*const_cast*/SExpr /*P*/ )(translateAttrExpr(At.getArg(), $AddrOf(LRCallCtx)).sexpr()));
        }
      }
    }
    
    SExpr /*P*/ E = translate(CE.getCallee$Const(), Ctx);
    for (/*const*/ Expr /*P*/ Arg : CE.arguments$Const()) {
      SExpr /*P*/ A = translate(Arg, Ctx);
      SExpr /*P*/ Efinal = E;
      E = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Apply(Efinal, A);
       });
    }
    SExpr /*P*/ Efinal = E;
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Call(Efinal, CE);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 375,
   FQN="clang::threadSafety::SExprBuilder::translateCXXMemberCallExpr", NM="_ZN5clang12threadSafety12SExprBuilder26translateCXXMemberCallExprEPKNS_17CXXMemberCallExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder26translateCXXMemberCallExprEPKNS_17CXXMemberCallExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateCXXMemberCallExpr(/*const*/ CXXMemberCallExpr /*P*/ ME, CallingContext /*P*/ Ctx) {
    if (CapabilityExprMode) {
      // Ignore calls to get() on smart pointers.
      if ($eq_string$C_T$C$P(ME.getMethodDecl().getNameAsString(), /*KEEP_STR*/"get")
         && ME.getNumArgs() == 0) {
        SExpr /*P*/ E = translate(ME.getImplicitObjectArgument(), Ctx);
        return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
            return new Cast(TIL_CastOpcode.CAST_objToPtr, E);
         });
        // return E;
      }
    }
    return translateCallExpr(cast_CallExpr(ME), Ctx, 
        ME.getImplicitObjectArgument());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateCXXOperatorCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 390,
   FQN="clang::threadSafety::SExprBuilder::translateCXXOperatorCallExpr", NM="_ZN5clang12threadSafety12SExprBuilder28translateCXXOperatorCallExprEPKNS_19CXXOperatorCallExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder28translateCXXOperatorCallExprEPKNS_19CXXOperatorCallExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateCXXOperatorCallExpr(/*const*/ CXXOperatorCallExpr /*P*/ OCE, CallingContext /*P*/ Ctx) {
    if (CapabilityExprMode) {
      // Ignore operator * and operator -> on smart pointers.
      OverloadedOperatorKind k = OCE.getOperator();
      if (k == OverloadedOperatorKind.OO_Star || k == OverloadedOperatorKind.OO_Arrow) {
        SExpr /*P*/ E = translate(OCE.getArg$Const(0), Ctx);
        return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
            return new Cast(TIL_CastOpcode.CAST_objToPtr, E);
         });
        // return E;
      }
    }
    return translateCallExpr(cast_CallExpr(OCE), Ctx);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateUnaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 404,
   FQN="clang::threadSafety::SExprBuilder::translateUnaryOperator", NM="_ZN5clang12threadSafety12SExprBuilder22translateUnaryOperatorEPKNS_13UnaryOperatorEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder22translateUnaryOperatorEPKNS_13UnaryOperatorEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateUnaryOperator(/*const*/ UnaryOperator /*P*/ UO, 
                        CallingContext /*P*/ Ctx) {
    switch (UO.getOpcode()) {
     case UO_PostInc:
     case UO_PostDec:
     case UO_PreInc:
     case UO_PreDec:
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Undefined(UO);
       });
     case UO_AddrOf:
      {
        if (CapabilityExprMode) {
          {
            // interpret &Graph::mu_ as an existential.
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(UO.getSubExpr());
            if ((DRE != null)) {
              if (DRE.getDecl().isCXXInstanceMember()) {
                // This is a pointer-to-member expression, e.g. &MyClass::mu_.
                // We interpret this syntax specially, as a wildcard.
                Wildcard /*P*/ W = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
                    return new Wildcard();
                 });
                return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
                    return new Project(W, DRE.getDecl());
                 });
              }
            }
          }
        }
        // otherwise, & is a no-op
        return translate(UO.getSubExpr(), Ctx);
      }
     case UO_Deref:
     case UO_Plus:
      
      // We treat these as no-ops
      return translate(UO.getSubExpr(), Ctx);
     case UO_Minus:
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new UnaryOp(TIL_UnaryOpcode.UOP_Minus, translate(UO.getSubExpr(), Ctx));
       });
     case UO_Not:
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new UnaryOp(TIL_UnaryOpcode.UOP_BitNot, translate(UO.getSubExpr(), Ctx));
       });
     case UO_LNot:
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new UnaryOp(TIL_UnaryOpcode.UOP_LogicNot, translate(UO.getSubExpr(), Ctx));
       });
     case UO_Real:
     case UO_Imag:
     case UO_Extension:
     case UO_Coawait:
      
      // Currently unsupported
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Undefined(UO);
       });
    }
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Undefined(UO);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 454,
   FQN="clang::threadSafety::SExprBuilder::translateBinOp", NM="_ZN5clang12threadSafety12SExprBuilder14translateBinOpENS0_3til16TIL_BinaryOpcodeEPKNS_14BinaryOperatorEPNS1_14CallingContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder14translateBinOpENS0_3til16TIL_BinaryOpcodeEPKNS_14BinaryOperatorEPNS1_14CallingContextEb")
  //</editor-fold>
  private SExpr /*P*/ translateBinOp(TIL_BinaryOpcode Op, 
                /*const*/ BinaryOperator /*P*/ BO, 
                CallingContext /*P*/ Ctx) {
    return translateBinOp(Op, 
                BO, 
                Ctx, false);
  }
  private SExpr /*P*/ translateBinOp(TIL_BinaryOpcode Op, 
                /*const*/ BinaryOperator /*P*/ BO, 
                CallingContext /*P*/ Ctx, boolean Reverse/*= false*/) {
    SExpr /*P*/ E0 = translate(BO.getLHS(), Ctx);
    SExpr /*P*/ E1 = translate(BO.getRHS(), Ctx);
    if (Reverse) {
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new BinaryOp(Op, E1, E0);
       });
    } else {
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new BinaryOp(Op, E0, E1);
       });
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateBinAssign">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 465,
   FQN="clang::threadSafety::SExprBuilder::translateBinAssign", NM="_ZN5clang12threadSafety12SExprBuilder18translateBinAssignENS0_3til16TIL_BinaryOpcodeEPKNS_14BinaryOperatorEPNS1_14CallingContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder18translateBinAssignENS0_3til16TIL_BinaryOpcodeEPKNS_14BinaryOperatorEPNS1_14CallingContextEb")
  //</editor-fold>
  private SExpr /*P*/ translateBinAssign(TIL_BinaryOpcode Op, 
                    /*const*/ BinaryOperator /*P*/ BO, 
                    CallingContext /*P*/ Ctx) {
    return translateBinAssign(Op, 
                    BO, 
                    Ctx, 
                    false);
  }
  private SExpr /*P*/ translateBinAssign(TIL_BinaryOpcode Op, 
                    /*const*/ BinaryOperator /*P*/ BO, 
                    CallingContext /*P*/ Ctx, 
                    boolean Assign/*= false*/) {
    /*const*/ Expr /*P*/ LHS = BO.getLHS();
    /*const*/ Expr /*P*/ RHS = BO.getRHS();
    SExpr /*P*/ E0 = translate(LHS, Ctx);
    SExpr /*P*/ E1 = translate(RHS, Ctx);
    
    /*const*/ ValueDecl /*P*/ VD = null;
    SExpr /*P*/ CV = null;
    {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(LHS);
      if ((DRE != null)) {
        VD = DRE.getDecl$Const();
        CV = lookupVarDecl(VD);
      }
    }
    if (!Assign) {
      SExpr /*P*/ Arg = (CV != null) ? CV : /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Load(E0);
       });
      SExpr /*P*/ E1final = E1;
      E1 = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new BinaryOp(Op, Arg, E1final);
       });
      E1 = addStatement(E1, (/*const*/ Stmt /*P*/ )null, VD);
    }
    if ((VD != null) && (CV != null)) {
      return updateVarDecl(VD, E1);
    }
    SExpr /*P*/ E1final = E1;
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Store(E0, E1final);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 491,
   FQN="clang::threadSafety::SExprBuilder::translateBinaryOperator", NM="_ZN5clang12threadSafety12SExprBuilder23translateBinaryOperatorEPKNS_14BinaryOperatorEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder23translateBinaryOperatorEPKNS_14BinaryOperatorEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateBinaryOperator(/*const*/ BinaryOperator /*P*/ BO, 
                         CallingContext /*P*/ Ctx) {
    switch (BO.getOpcode()) {
     case BO_PtrMemD:
     case BO_PtrMemI:
      return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Undefined(BO);
       });
     case BO_Mul:
      return translateBinOp(TIL_BinaryOpcode.BOP_Mul, BO, Ctx);
     case BO_Div:
      return translateBinOp(TIL_BinaryOpcode.BOP_Div, BO, Ctx);
     case BO_Rem:
      return translateBinOp(TIL_BinaryOpcode.BOP_Rem, BO, Ctx);
     case BO_Add:
      return translateBinOp(TIL_BinaryOpcode.BOP_Add, BO, Ctx);
     case BO_Sub:
      return translateBinOp(TIL_BinaryOpcode.BOP_Sub, BO, Ctx);
     case BO_Shl:
      return translateBinOp(TIL_BinaryOpcode.BOP_Shl, BO, Ctx);
     case BO_Shr:
      return translateBinOp(TIL_BinaryOpcode.BOP_Shr, BO, Ctx);
     case BO_LT:
      return translateBinOp(TIL_BinaryOpcode.BOP_Lt, BO, Ctx);
     case BO_GT:
      return translateBinOp(TIL_BinaryOpcode.BOP_Lt, BO, Ctx, true);
     case BO_LE:
      return translateBinOp(TIL_BinaryOpcode.BOP_Leq, BO, Ctx);
     case BO_GE:
      return translateBinOp(TIL_BinaryOpcode.BOP_Leq, BO, Ctx, true);
     case BO_EQ:
      return translateBinOp(TIL_BinaryOpcode.BOP_Eq, BO, Ctx);
     case BO_NE:
      return translateBinOp(TIL_BinaryOpcode.BOP_Neq, BO, Ctx);
     case BO_And:
      return translateBinOp(TIL_BinaryOpcode.BOP_BitAnd, BO, Ctx);
     case BO_Xor:
      return translateBinOp(TIL_BinaryOpcode.BOP_BitXor, BO, Ctx);
     case BO_Or:
      return translateBinOp(TIL_BinaryOpcode.BOP_BitOr, BO, Ctx);
     case BO_LAnd:
      return translateBinOp(TIL_BinaryOpcode.BOP_LogicAnd, BO, Ctx);
     case BO_LOr:
      return translateBinOp(TIL_BinaryOpcode.BOP_LogicOr, BO, Ctx);
     case BO_Assign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Eq, BO, Ctx, true);
     case BO_MulAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Mul, BO, Ctx);
     case BO_DivAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Div, BO, Ctx);
     case BO_RemAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Rem, BO, Ctx);
     case BO_AddAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Add, BO, Ctx);
     case BO_SubAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Sub, BO, Ctx);
     case BO_ShlAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Shl, BO, Ctx);
     case BO_ShrAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_Shr, BO, Ctx);
     case BO_AndAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_BitAnd, BO, Ctx);
     case BO_XorAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_BitXor, BO, Ctx);
     case BO_OrAssign:
      return translateBinAssign(TIL_BinaryOpcode.BOP_BitOr, BO, Ctx);
     case BO_Comma:
      // The clang CFG should have already processed both sides.
      return translate(BO.getRHS(), Ctx);
    }
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Undefined(BO);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 536,
   FQN="clang::threadSafety::SExprBuilder::translateCastExpr", NM="_ZN5clang12threadSafety12SExprBuilder17translateCastExprEPKNS_8CastExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17translateCastExprEPKNS_8CastExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateCastExpr(/*const*/ CastExpr /*P*/ CE, 
                   CallingContext /*P*/ Ctx) {
    CastKind K = CE.getCastKind();
    switch (K) {
     case CK_LValueToRValue:
      {
        {
          /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CE.getSubExpr$Const());
          if ((DRE != null)) {
            SExpr /*P*/ E0 = lookupVarDecl(DRE.getDecl$Const());
            if ((E0 != null)) {
              return E0;
            }
          }
        }
        SExpr /*P*/ E0 = translate(CE.getSubExpr$Const(), Ctx);
        return E0;
        // FIXME!! -- get Load working properly
        // return new (Arena) til::Load(E0);
      }
     case CK_NoOp:
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
     case CK_ArrayToPointerDecay:
     case CK_FunctionToPointerDecay:
      {
        SExpr /*P*/ E0 = translate(CE.getSubExpr$Const(), Ctx);
        return E0;
      }
     default:
      {
        // FIXME: handle different kinds of casts.
        SExpr /*P*/ E0 = translate(CE.getSubExpr$Const(), Ctx);
        if (CapabilityExprMode) {
          return E0;
        }
        return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
            return new Cast(TIL_CastOpcode.CAST_none, E0);
         });
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 569,
   FQN="clang::threadSafety::SExprBuilder::translateArraySubscriptExpr", NM="_ZN5clang12threadSafety12SExprBuilder27translateArraySubscriptExprEPKNS_18ArraySubscriptExprEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder27translateArraySubscriptExprEPKNS_18ArraySubscriptExprEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateArraySubscriptExpr(/*const*/ ArraySubscriptExpr /*P*/ E, 
                             CallingContext /*P*/ Ctx) {
    SExpr /*P*/ E0 = translate(E.getBase$Const(), Ctx);
    SExpr /*P*/ E1 = translate(E.getIdx$Const(), Ctx);
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new ArrayIndex(E0, E1);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 577,
   FQN="clang::threadSafety::SExprBuilder::translateAbstractConditionalOperator", NM="_ZN5clang12threadSafety12SExprBuilder36translateAbstractConditionalOperatorEPKNS_27AbstractConditionalOperatorEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder36translateAbstractConditionalOperatorEPKNS_27AbstractConditionalOperatorEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ CO, CallingContext /*P*/ Ctx) {
    SExpr /*P*/ C = translate(CO.getCond(), Ctx);
    SExpr /*P*/ T = translate(CO.getTrueExpr(), Ctx);
    SExpr /*P*/ E = translate(CO.getFalseExpr(), Ctx);
    return /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new IfThenElse(C, T, E);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::translateDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 586,
   FQN="clang::threadSafety::SExprBuilder::translateDeclStmt", NM="_ZN5clang12threadSafety12SExprBuilder17translateDeclStmtEPKNS_8DeclStmtEPNS1_14CallingContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17translateDeclStmtEPKNS_8DeclStmtEPNS1_14CallingContextE")
  //</editor-fold>
  private SExpr /*P*/ translateDeclStmt(/*const*/ DeclStmt /*P*/ S, CallingContext /*P*/ Ctx) {
    DeclGroupRef DGrp = S.getDeclGroup$Const();
    for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(DGrp.begin()), /*P*/ /*P*/ E = $tryClone(DGrp.end()); $noteq_ptr(I, E); I.$preInc()) {
      {
        VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(I.$star());
        if ((VD != null)) {
          Expr /*P*/ E$1 = VD.getInit();
          SExpr /*P*/ SE = translate(E$1, Ctx);
          
          // Add local variables with trivial type to the variable map
          QualType T = VD.getType();
          if (T.isTrivialType(VD.getASTContext())) {
            return addVarDecl(VD, SE);
          } else {
            // TODO: add alloca
          }
        }
      }
    }
    return null;
  }


  
  // Map from statements in the clang CFG to SExprs in the til::SCFG.
  /*typedef llvm::DenseMap<const Stmt *, til::SExpr *> StatementMap*/
//  public final class StatementMap extends DenseMap</*const*/ Stmt /*P*/ , SExpr /*P*/ >{ };
  
  // Map from clang local variables to indices in a LVarDefinitionMap.
  /*typedef llvm::DenseMap<const ValueDecl *, unsigned int> LVarIndexMap*/
//  public final class LVarIndexMap extends DenseMapTypeUInt</*const*/ ValueDecl /*P*/ >{ };
  
  // Map from local variable indices to SSA variables (or constants).
  /*typedef std::pair<const ValueDecl *, til::SExpr *> NameVarPair*/
//  public final class NameVarPair extends std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ >{ };
  /*typedef CopyOnWriteVector<NameVarPair> LVarDefinitionMap*/
//  public final class LVarDefinitionMap extends CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 409,
   FQN="clang::threadSafety::SExprBuilder::BlockInfo", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoE")
  //</editor-fold>
  private static class/*struct*/ BlockInfo implements Destructors.ClassWithDestructor {
    public CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > > ExitMap;
    public boolean HasBackEdges;
    public /*uint*/int UnprocessedSuccessors; // Successors yet to be processed
    public /*uint*/int ProcessedPredecessors; // Predecessors already processed
    
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 415,
     FQN="clang::threadSafety::SExprBuilder::BlockInfo::BlockInfo", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoC1Ev")
    //</editor-fold>
    public BlockInfo() {
      // : ExitMap(), HasBackEdges(false), UnprocessedSuccessors(0), ProcessedPredecessors(0) 
      //START JInit
      this.ExitMap = new CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > >();
      this.HasBackEdges = false;
      this.UnprocessedSuccessors = 0;
      this.ProcessedPredecessors = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 418,
     FQN="clang::threadSafety::SExprBuilder::BlockInfo::BlockInfo", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoC1EOS2_")
    //</editor-fold>
    public BlockInfo(JD$Move _dparam, final BlockInfo /*&&*/RHS) {
      // : ExitMap(std::move(RHS.ExitMap)), HasBackEdges(RHS.HasBackEdges), UnprocessedSuccessors(RHS.UnprocessedSuccessors), ProcessedPredecessors(RHS.ProcessedPredecessors) 
      //START JInit
      this.ExitMap = new CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > >(JD$Move.INSTANCE, std.move(RHS.ExitMap));
      this.HasBackEdges = RHS.HasBackEdges;
      this.UnprocessedSuccessors = RHS.UnprocessedSuccessors;
      this.ProcessedPredecessors = RHS.ProcessedPredecessors;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 424,
     FQN="clang::threadSafety::SExprBuilder::BlockInfo::operator=", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoaSEOS2_")
    //</editor-fold>
    public BlockInfo /*&*/ $assignMove(final BlockInfo /*&&*/RHS) {
      if (this != $AddrOf(RHS)) {
        ExitMap.$assignMove(std.move(RHS.ExitMap));
        HasBackEdges = RHS.HasBackEdges;
        UnprocessedSuccessors = RHS.UnprocessedSuccessors;
        ProcessedPredecessors = RHS.ProcessedPredecessors;
      }
      return /*Deref*/this;
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 435,
     FQN="clang::threadSafety::SExprBuilder::BlockInfo::BlockInfo", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoC1ERKS2_")
    //</editor-fold>
    private BlockInfo(final /*const*/ BlockInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 436,
     FQN="clang::threadSafety::SExprBuilder::BlockInfo::operator=", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoaSERKS2_")
    //</editor-fold>
    private void $assign(final /*const*/ BlockInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::BlockInfo::~BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 409,
     FQN="clang::threadSafety::SExprBuilder::BlockInfo::~BlockInfo", NM="_ZN5clang12threadSafety12SExprBuilder9BlockInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder9BlockInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      ExitMap.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "ExitMap=" + ExitMap // NOI18N
                + ", HasBackEdges=" + HasBackEdges // NOI18N
                + ", UnprocessedSuccessors=" + UnprocessedSuccessors // NOI18N
                + ", ProcessedPredecessors=" + ProcessedPredecessors; // NOI18N
    }
  };
  
  // We implement the CFGVisitor API
  /*friend  class CFGWalker*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::enterCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 787,
   FQN="clang::threadSafety::SExprBuilder::enterCFG", NM="_ZN5clang12threadSafety12SExprBuilder8enterCFGEPNS_3CFGEPKNS_9NamedDeclEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder8enterCFGEPNS_3CFGEPKNS_9NamedDeclEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void enterCFG(CFG /*P*/ Cfg, /*const*/ NamedDecl /*P*/ D, 
          /*const*/ CFGBlock /*P*/ First) {
    // Perform initial setup operations.
    /*uint*/int NBlocks = Cfg.getNumBlockIDs();
    Scfg = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new SCFG(new MemRegionRef(Arena), NBlocks);
     });
    
    // allocate all basic blocks immediately, to handle forward references.
    BBInfo.resize(NBlocks);
    BlockMap.resize(NBlocks, (/*const*/ BasicBlock)null);
    // create map from clang blockID to til::BasicBlocks
    for (CFGBlock /*P*/ B : $Deref(Cfg)) {
      BasicBlock /*P*/ BB = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new BasicBlock(new MemRegionRef(Arena));
       });
      BB.reserveInstructions(B.size());
      BlockMap.$set(B.getBlockID(), BB);
    }
    
    CurrentBB = lookupBlock($AddrOf(Cfg.getEntry()));
    ArrayRef<ParmVarDecl /*P*/ > Parms = isa_ObjCMethodDecl(D) ? cast_ObjCMethodDecl(D).parameters() : cast_FunctionDecl(D).parameters$Const();
    for (ParmVarDecl /*P*/ Pm : Parms) {
      QualType T = Pm.getType();
      if (!T.isTrivialType(Pm.getASTContext())) {
        continue;
      }
      
      // Add parameters to local variable map.
      // FIXME: right now we emulate params with loads; that should be fixed.
      SExpr /*P*/ Lp = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new LiteralPtr(Pm);
       });
      SExpr /*P*/ Ld = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Load(Lp);
       });
      SExpr /*P*/ V = addStatement(Ld, (/*const*/ Stmt /*P*/ )null, Pm);
      addVarDecl(Pm, V);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::enterCFGBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 820,
   FQN="clang::threadSafety::SExprBuilder::enterCFGBlock", NM="_ZN5clang12threadSafety12SExprBuilder13enterCFGBlockEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder13enterCFGBlockEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void enterCFGBlock(/*const*/ CFGBlock /*P*/ B) {
    // Intialize TIL basic block and add it to the CFG.
    CurrentBB = lookupBlock(B);
    CurrentBB.reservePredecessors(B.pred_size());
    Scfg.add(CurrentBB);
    
    CurrentBlockInfo = $AddrOf(BBInfo.$at(B.getBlockID()));
    // CurrentLVarMap is moved to ExitMap on block exit.
    // FIXME: the entry block will hold function parameters.
    // assert(!CurrentLVarMap.valid() && "CurrentLVarMap already initialized.");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::visitPredecessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 444,
   FQN="clang::threadSafety::SExprBuilder::visitPredecessors", NM="_ZN5clang12threadSafety12SExprBuilder17visitPredecessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17visitPredecessorsEv")
  //</editor-fold>
  @Override public /*friend*//*private*/ boolean visitPredecessors() {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::handlePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 833,
   FQN="clang::threadSafety::SExprBuilder::handlePredecessor", NM="_ZN5clang12threadSafety12SExprBuilder17handlePredecessorEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17handlePredecessorEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handlePredecessor(/*const*/ CFGBlock /*P*/ Pred) {
    // Compute CurrentLVarMap on entry from ExitMaps of predecessors
    CurrentBB.addPredecessor(BlockMap.$at(Pred.getBlockID()));
    BlockInfo /*P*/ PredInfo = $AddrOf(BBInfo.$at(Pred.getBlockID()));
    assert ($greater_uint(PredInfo.UnprocessedSuccessors, 0));
    if (--PredInfo.UnprocessedSuccessors == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        mergeEntryMap($c$.track(new CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > >(JD$Move.INSTANCE, std.move(PredInfo.ExitMap)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        mergeEntryMap($c$.track(PredInfo.ExitMap.clone())); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    
    ++CurrentBlockInfo.ProcessedPredecessors;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::handlePredecessorBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 848,
   FQN="clang::threadSafety::SExprBuilder::handlePredecessorBackEdge", NM="_ZN5clang12threadSafety12SExprBuilder25handlePredecessorBackEdgeEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder25handlePredecessorBackEdgeEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handlePredecessorBackEdge(/*const*/ CFGBlock /*P*/ Pred) {
    mergeEntryMapBackEdge();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::enterCFGBlockBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 852,
   FQN="clang::threadSafety::SExprBuilder::enterCFGBlockBody", NM="_ZN5clang12threadSafety12SExprBuilder17enterCFGBlockBodyEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder17enterCFGBlockBodyEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void enterCFGBlockBody(/*const*/ CFGBlock /*P*/ B) {
    // The merge*() methods have created arguments.
    // Push those arguments onto the basic block.
    CurrentBB.arguments().reserve(((/*static_cast*//*uint*/int)(CurrentArguments.size())), new MemRegionRef(Arena));
    for (Phi /*P*/ A : CurrentArguments)  {
      CurrentBB.addArgument(A);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::handleStatement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 861,
   FQN="clang::threadSafety::SExprBuilder::handleStatement", NM="_ZN5clang12threadSafety12SExprBuilder15handleStatementEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder15handleStatementEPKNS_4StmtE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleStatement(/*const*/ Stmt /*P*/ S) {
    SExpr /*P*/ E = translate(S, (CallingContext /*P*/ )null);
    addStatement(E, S);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::handleDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 866,
   FQN="clang::threadSafety::SExprBuilder::handleDestructorCall", NM="_ZN5clang12threadSafety12SExprBuilder20handleDestructorCallEPKNS_7VarDeclEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder20handleDestructorCallEPKNS_7VarDeclEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleDestructorCall(/*const*/ VarDecl /*P*/ VD, 
                      /*const*/ CXXDestructorDecl /*P*/ DD) {
    SExpr /*P*/ Sf = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new LiteralPtr(VD);
     });
    SExpr /*P*/ Dr = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new LiteralPtr(DD);
     });
    SExpr /*P*/ Ap = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Apply(Dr, Sf);
     });
    SExpr /*P*/ E = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Call(Ap);
     });
    addStatement(E, (/*const*/ Stmt /*P*/ )null);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::exitCFGBlockBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 875,
   FQN="clang::threadSafety::SExprBuilder::exitCFGBlockBody", NM="_ZN5clang12threadSafety12SExprBuilder16exitCFGBlockBodyEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder16exitCFGBlockBodyEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void exitCFGBlockBody(/*const*/ CFGBlock /*P*/ B) {
    CurrentBB.instructions().reserve(((/*static_cast*//*uint*/int)(CurrentInstructions.size())), new MemRegionRef(Arena));
    for (SExpr /*P*/ V : CurrentInstructions)  {
      CurrentBB.addInstruction(V);
    }
    
    // Create an appropriate terminator
    /*uint*/int N = B.succ_size();
    type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > It = $tryClone(B.succ_begin$Const());
    if (N == 1) {
      BasicBlock /*P*/ BB = ((It.$star().$CFGBlock$P()) != null) ? lookupBlock(It.$star().$CFGBlock$P()) : null;
      // TODO: set index
      /*uint*/int Idx = (BB != null) ? BB.findPredecessorIndex(CurrentBB) : 0;
      Goto /*P*/ Tm = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Goto(BB, Idx);
       });
      CurrentBB.setTerminator(Tm);
    } else if (N == 2) {
      SExpr /*P*/ C = translate(B.getTerminatorCondition$Const(true), (CallingContext /*P*/ )null);
      BasicBlock /*P*/ BB1 = ((It.$star().$CFGBlock$P()) != null) ? lookupBlock(It.$star().$CFGBlock$P()) : null;
      It.$preInc();
      BasicBlock /*P*/ BB2 = ((It.$star().$CFGBlock$P()) != null) ? lookupBlock(It.$star().$CFGBlock$P()) : null;
      // FIXME: make sure these arent' critical edges.
      Branch /*P*/ Tm = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Branch(C, BB1, BB2);
       });
      CurrentBB.setTerminator(Tm);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::visitSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 451,
   FQN="clang::threadSafety::SExprBuilder::visitSuccessors", NM="_ZN5clang12threadSafety12SExprBuilder15visitSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder15visitSuccessorsEv")
  //</editor-fold>
  @Override public /*friend*//*private*/ boolean visitSuccessors() {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::handleSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 902,
   FQN="clang::threadSafety::SExprBuilder::handleSuccessor", NM="_ZN5clang12threadSafety12SExprBuilder15handleSuccessorEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder15handleSuccessorEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleSuccessor(/*const*/ CFGBlock /*P*/ Succ) {
    ++CurrentBlockInfo.UnprocessedSuccessors;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::handleSuccessorBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 906,
   FQN="clang::threadSafety::SExprBuilder::handleSuccessorBackEdge", NM="_ZN5clang12threadSafety12SExprBuilder23handleSuccessorBackEdgeEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder23handleSuccessorBackEdgeEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void handleSuccessorBackEdge(/*const*/ CFGBlock /*P*/ Succ) {
    mergePhiNodesBackEdge(Succ);
    ++BBInfo.$at(Succ.getBlockID()).ProcessedPredecessors;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::exitCFGBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 911,
   FQN="clang::threadSafety::SExprBuilder::exitCFGBlock", NM="_ZN5clang12threadSafety12SExprBuilder12exitCFGBlockEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder12exitCFGBlockEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void exitCFGBlock(/*const*/ CFGBlock /*P*/ B) {
    CurrentArguments.clear();
    CurrentInstructions.clear();
    CurrentBlockInfo.ExitMap.$assignMove(std.move(CurrentLVarMap));
    CurrentBB = null;
    CurrentBlockInfo = null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::exitCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 919,
   FQN="clang::threadSafety::SExprBuilder::exitCFG", NM="_ZN5clang12threadSafety12SExprBuilder7exitCFGEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder7exitCFGEPKNS_8CFGBlockE")
  //</editor-fold>
  @Override public /*friend*//*private*/ void exitCFG(/*const*/ CFGBlock /*P*/ Last) {
    for (Phi /*P*/ Ph : IncompleteArgs) {
      if (Ph.status() == Phi.Status.PH_Incomplete) {
        simplifyIncompleteArg(Ph);
      }
    }
    
    CurrentArguments.clear();
    CurrentInstructions.clear();
    IncompleteArgs.clear();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::insertStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 457,
   FQN="clang::threadSafety::SExprBuilder::insertStmt", NM="_ZN5clang12threadSafety12SExprBuilder10insertStmtEPKNS_4StmtEPNS0_3til5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder10insertStmtEPKNS_4StmtEPNS0_3til5SExprE")
  //</editor-fold>
  private void insertStmt(/*const*/ Stmt /*P*/ S, SExpr /*P*/ E) {
    SMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(S, E));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::getCurrentLVarDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 460,
   FQN="clang::threadSafety::SExprBuilder::getCurrentLVarDefinition", NM="_ZN5clang12threadSafety12SExprBuilder24getCurrentLVarDefinitionEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilder24getCurrentLVarDefinitionEPKNS_9ValueDeclE")
  //</editor-fold>
  private SExpr /*P*/ getCurrentLVarDefinition(/*const*/ ValueDecl /*P*/ VD) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  // If (E) is non-trivial, then add it to the current basic block, and
  // update the statement map so that S refers to E.  Returns a new variable
  // that refers to E.
  // If E is trivial returns E.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::addStatement">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 611,
   FQN="clang::threadSafety::SExprBuilder::addStatement", NM="_ZN5clang12threadSafety12SExprBuilder12addStatementEPNS0_3til5SExprEPKNS_4StmtEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder12addStatementEPNS0_3til5SExprEPKNS_4StmtEPKNS_9ValueDeclE")
  //</editor-fold>
  private SExpr /*P*/ addStatement(SExpr /*P*/ E, /*const*/ Stmt /*P*/ S) {
    return addStatement(E, S, 
              (/*const*/ ValueDecl /*P*/ )null);
  }
  private SExpr /*P*/ addStatement(SExpr /*P*/ E, /*const*/ Stmt /*P*/ S, 
              /*const*/ ValueDecl /*P*/ VD/*= null*/) {
    if (!(E != null) || !(CurrentBB != null) || (E.block() != null) || isTrivial(E)) {
      return E;
    }
    if ((VD != null)) {
      SExpr /*P*/ Efinal = E;
      E = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Variable(Efinal, VD);
       });
    }
    CurrentInstructions.push_back_T$C$R(E);
    if ((S != null)) {
      insertStmt(S, E);
    }
    return E;
  }


  
  // Returns the current value of VD, if known, and nullptr otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::lookupVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 624,
   FQN="clang::threadSafety::SExprBuilder::lookupVarDecl", NM="_ZN5clang12threadSafety12SExprBuilder13lookupVarDeclEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder13lookupVarDeclEPKNS_9ValueDeclE")
  //</editor-fold>
  private SExpr /*P*/ lookupVarDecl(/*const*/ ValueDecl /*P*/ VD) {
    DenseMapIteratorTypeUInt</*const*/ ValueDecl /*P*/ /*P*/> It = LVarIdxMap.find(VD);
    if (It.$noteq(/*NO_ITER_COPY*/LVarIdxMap.end())) {
      assert (CurrentLVarMap.$at(It.$arrow().second).first == VD);
      return CurrentLVarMap.$at(It.$arrow().second).second;
    }
    return null;
  }


  
  // Adds a new variable declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::addVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 644,
   FQN="clang::threadSafety::SExprBuilder::addVarDecl", NM="_ZN5clang12threadSafety12SExprBuilder10addVarDeclEPKNS_9ValueDeclEPNS0_3til5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder10addVarDeclEPKNS_9ValueDeclEPNS0_3til5SExprE")
  //</editor-fold>
  private SExpr /*P*/ addVarDecl(/*const*/ ValueDecl /*P*/ VD, SExpr /*P*/ E) {
    maybeUpdateVD(E, VD);
    LVarIdxMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(VD, CurrentLVarMap.size()));
    CurrentLVarMap.makeWritable();
    CurrentLVarMap.push_back(std.make_pair_Ptr_Ptr(VD, E));
    return E;
  }


  
  // Updates a current variable declaration.  (E.g. by assignment)
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::updateVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 653,
   FQN="clang::threadSafety::SExprBuilder::updateVarDecl", NM="_ZN5clang12threadSafety12SExprBuilder13updateVarDeclEPKNS_9ValueDeclEPNS0_3til5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder13updateVarDeclEPKNS_9ValueDeclEPNS0_3til5SExprE")
  //</editor-fold>
  private SExpr /*P*/ updateVarDecl(/*const*/ ValueDecl /*P*/ VD, SExpr /*P*/ E) {
    maybeUpdateVD(E, VD);
    DenseMapIteratorTypeUInt</*const*/ ValueDecl /*P*/ /*P*/> It = LVarIdxMap.find(VD);
    if (It.$eq(/*NO_ITER_COPY*/LVarIdxMap.end())) {
      SExpr /*P*/ Ptr = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new LiteralPtr(VD);
       });
      SExpr /*P*/ St = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
          return new Store(Ptr, E);
       });
      return St;
    }
    CurrentLVarMap.makeWritable();
    CurrentLVarMap.elem(It.$arrow().second).second = E;
    return E;
  }


  
  // Make a Phi node in the current block for the i^th variable in CurrentVarMap.
  // If E != null, sets Phi[CurrentBlockInfo->ArgIndex] = E.
  // If E == null, this is a backedge and will be set later.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::makePhiNodeVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 669,
   FQN="clang::threadSafety::SExprBuilder::makePhiNodeVar", NM="_ZN5clang12threadSafety12SExprBuilder14makePhiNodeVarEjjPNS0_3til5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder14makePhiNodeVarEjjPNS0_3til5SExprE")
  //</editor-fold>
  private void makePhiNodeVar(/*uint*/int i, /*uint*/int NPreds, SExpr /*P*/ E) {
    /*uint*/int ArgIndex = CurrentBlockInfo.ProcessedPredecessors;
    assert ($greater_uint(ArgIndex, 0) && $less_uint(ArgIndex, NPreds));
    
    SExpr /*P*/ CurrE = CurrentLVarMap.$at(i).second;
    if (CurrE.block() == CurrentBB) {
      // We already have a Phi node in the current block,
      // so just add the new variable to the Phi node.
      Phi /*P*/ Ph = dyn_cast_Phi(CurrE);
      assert ((Ph != null)) : "Expecting Phi node.";
      if ((E != null)) {
        Ph.values().$set(ArgIndex, E);
      }
      return;
    }
    
    // Make a new phi node: phi(..., E)
    // All phi args up to the current index are set to the current value.
    Phi /*P*/ Ph = /*NEW_EXPR [SExpr::new]*//*new (Arena)*/ SExpr.$new(Arena, (type$ptr<?> New$Mem)->{
        return new Phi(new MemRegionRef(Arena), NPreds);
     });
    Ph.values().setValues(NPreds, (SExpr /*P*/ /*const*/)null);
    for (/*uint*/int PIdx = 0; $less_uint(PIdx, ArgIndex); ++PIdx)  {
      Ph.values().$set(PIdx, CurrE);
    }
    if ((E != null)) {
      Ph.values().$set(ArgIndex, E);
    }
    Ph.setClangDecl(CurrentLVarMap.$at(i).first);
    // If E is from a back-edge, or either E or CurrE are incomplete, then
    // mark this node as incomplete; we may need to remove it later.
    if (!(E != null) || isIncompletePhi(E) || isIncompletePhi(CurrE)) {
      Ph.setStatus(Phi.Status.PH_Incomplete);
    }
    
    // Add Phi node to current block, and update CurrentLVarMap[i]
    CurrentArguments.push_back_T$C$R(Ph);
    if (Ph.status() == Phi.Status.PH_Incomplete) {
      IncompleteArgs.push_back_T$C$R(Ph);
    }
    
    CurrentLVarMap.makeWritable();
    CurrentLVarMap.elem(i).second = Ph;
  }


  
  // Merge values from Map into the current variable map.
  // This will construct Phi nodes in the current basic block as necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::mergeEntryMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 710,
   FQN="clang::threadSafety::SExprBuilder::mergeEntryMap", NM="_ZN5clang12threadSafety12SExprBuilder13mergeEntryMapENS0_17CopyOnWriteVectorISt4pairIPKNS_9ValueDeclEPNS0_3til5SExprEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder13mergeEntryMapENS0_17CopyOnWriteVectorISt4pairIPKNS_9ValueDeclEPNS0_3til5SExprEEEE")
  //</editor-fold>
  private void mergeEntryMap(CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > > Map) {
    assert ((CurrentBlockInfo != null)) : "Not processing a block!";
    if (!CurrentLVarMap.valid()) {
      // Steal Map, using copy-on-write.
      CurrentLVarMap.$assignMove(std.move(Map));
      return;
    }
    if (CurrentLVarMap.sameAs(Map)) {
      return; // Easy merge: maps from different predecessors are unchanged.
    }
    
    /*uint*/int NPreds = CurrentBB.numPredecessors();
    /*uint*/int ESz = CurrentLVarMap.size();
    /*uint*/int MSz = Map.size();
    /*uint*/int Sz = std.min_uint(ESz, MSz);
    
    for (/*uint*/int i = 0; $less_uint(i, Sz); ++i) {
      if (CurrentLVarMap.$at(i).first != Map.$at(i).first) {
        // We've reached the end of variables in common.
        CurrentLVarMap.makeWritable();
        CurrentLVarMap.downsize(i);
        break;
      }
      if (CurrentLVarMap.$at(i).second != Map.$at(i).second) {
        makePhiNodeVar(i, NPreds, Map.$at(i).second);
      }
    }
    if ($greater_uint(ESz, MSz)) {
      CurrentLVarMap.makeWritable();
      CurrentLVarMap.downsize(Map.size());
    }
  }


  
  // Merge a back edge into the current variable map.
  // This will create phi nodes for all variables in the variable map.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::mergeEntryMapBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 744,
   FQN="clang::threadSafety::SExprBuilder::mergeEntryMapBackEdge", NM="_ZN5clang12threadSafety12SExprBuilder21mergeEntryMapBackEdgeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder21mergeEntryMapBackEdgeEv")
  //</editor-fold>
  private void mergeEntryMapBackEdge() {
    // We don't have definitions for variables on the backedge, because we
    // haven't gotten that far in the CFG.  Thus, when encountering a back edge,
    // we conservatively create Phi nodes for all variables.  Unnecessary Phi
    // nodes will be marked as incomplete, and stripped out at the end.
    //
    // An Phi node is unnecessary if it only refers to itself and one other
    // variable, e.g. x = Phi(y, y, x)  can be reduced to x = y.
    assert ((CurrentBlockInfo != null)) : "Not processing a block!";
    if (CurrentBlockInfo.HasBackEdges) {
      return;
    }
    CurrentBlockInfo.HasBackEdges = true;
    
    CurrentLVarMap.makeWritable();
    /*uint*/int Sz = CurrentLVarMap.size();
    /*uint*/int NPreds = CurrentBB.numPredecessors();
    
    for (/*uint*/int i = 0; $less_uint(i, Sz); ++i) {
      makePhiNodeVar(i, NPreds, (SExpr /*P*/ )null);
    }
  }


  
  // Update the phi nodes that were initially created for a back edge
  // once the variable definitions have been computed.
  // I.e., merge the current variable map into the phi nodes for Blk.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::mergePhiNodesBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 771,
   FQN="clang::threadSafety::SExprBuilder::mergePhiNodesBackEdge", NM="_ZN5clang12threadSafety12SExprBuilder21mergePhiNodesBackEdgeEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety12SExprBuilder21mergePhiNodesBackEdgeEPKNS_8CFGBlockE")
  //</editor-fold>
  private void mergePhiNodesBackEdge(/*const*/ CFGBlock /*P*/ Blk) {
    BasicBlock /*P*/ BB = lookupBlock(Blk);
    /*uint*/int ArgIndex = BBInfo.$at(Blk.getBlockID()).ProcessedPredecessors;
    assert ($greater_uint(ArgIndex, 0) && $less_uint(ArgIndex, BB.numPredecessors()));
    
    for (SExpr /*P*/ PE : BB.arguments()) {
      Phi /*P*/ Ph = dyn_cast_or_null_Phi(PE);
      assert ((Ph != null)) : "Expecting Phi Node.";
      assert (Ph.values().$at(ArgIndex) == null) : "Wrong index for back edge.";
      
      SExpr /*P*/ E = lookupVarDecl(Ph.clangDecl());
      assert ((E != null)) : "Couldn't find local variable for Phi node.";
      Ph.values().$set(ArgIndex, E);
    }
  }


/*private:*/
  // Set to true when parsing capability expressions, which get translated
  // inaccurately in order to hack around smart pointers etc.
  private static /*const*/boolean CapabilityExprMode = true;
  
  private MemRegionRef Arena;
  private Variable /*P*/ SelfVar; // Variable to use for 'this'.  May be null.
  
  private SCFG /*P*/ Scfg;
  private DenseMap</*const*/ Stmt /*P*/ , SExpr /*P*/ > SMap; // Map from Stmt to TIL Variables
  private DenseMapTypeUInt</*const*/ ValueDecl /*P*/ > LVarIdxMap; // Indices of clang local vars.
  private std.vector<BasicBlock /*P*/ > BlockMap; // Map from clang to til BBs.
  private std.vector<BlockInfo> BBInfo; // Extra information per BB.
  // Indexed by clang BlockID.
  
  private CopyOnWriteVector<std.pair</*const*/ ValueDecl /*P*/ , SExpr /*P*/ > > CurrentLVarMap;
  private std.vector<Phi /*P*/ > CurrentArguments;
  private std.vector<SExpr /*P*/ > CurrentInstructions;
  private std.vector<Phi /*P*/ > IncompleteArgs;
  private BasicBlock /*P*/ CurrentBB;
  private BlockInfo /*P*/ CurrentBlockInfo;
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::SExprBuilder::~SExprBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 315,
   FQN="clang::threadSafety::SExprBuilder::~SExprBuilder", NM="_ZN5clang12threadSafety12SExprBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety12SExprBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IncompleteArgs.$destroy();
    CurrentInstructions.$destroy();
    CurrentArguments.$destroy();
    CurrentLVarMap.$destroy();
    BBInfo.$destroy();
    BlockMap.$destroy();
    LVarIdxMap.$destroy();
    SMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Arena=" + Arena // NOI18N
              + ", SelfVar=" + SelfVar // NOI18N
              + ", Scfg=" + Scfg // NOI18N
              + ", SMap=" + SMap // NOI18N
              + ", LVarIdxMap=" + LVarIdxMap // NOI18N
              + ", BlockMap=" + BlockMap // NOI18N
              + ", BBInfo=" + BBInfo // NOI18N
              + ", CurrentLVarMap=" + CurrentLVarMap // NOI18N
              + ", CurrentArguments=" + CurrentArguments // NOI18N
              + ", CurrentInstructions=" + CurrentInstructions // NOI18N
              + ", IncompleteArgs=" + IncompleteArgs // NOI18N
              + ", CurrentBB=" + CurrentBB // NOI18N
              + ", CurrentBlockInfo=" + CurrentBlockInfo; // NOI18N
  }
}
