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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.llvm.*;
import org.clang.basic.target.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.sema.impl.SemaStmtAsmStatics.*;
import org.llvm.mc.mcparser.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaStmtAsm">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaStmt ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema14ActOnMSAsmStmtENS_14SourceLocationES1_N4llvm8ArrayRefINS_5TokenEEENS2_9StringRefEjjNS3_IS6_EES7_NS3_IPNS_4ExprEEES1_;_ZN5clang4Sema15ActOnGCCAsmStmtENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEN4llvm15MutableArrayRefIPNS_4ExprEEES9_S8_S9_S1_;_ZN5clang4Sema20LookupInlineAsmFieldEN4llvm9StringRefES2_RjNS_14SourceLocationE;_ZN5clang4Sema21GetOrCreateMSAsmLabelEN4llvm9StringRefENS_14SourceLocationEb;_ZN5clang4Sema25LookupInlineAsmIdentifierERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdERN4llvm23InlineAsmIdentifierInfoEb;_ZN5clang4Sema27LookupInlineAsmVarDeclFieldEPNS_4ExprEN4llvm9StringRefERNS3_23InlineAsmIdentifierInfoENS_14SourceLocationE; -static-type=Sema_SemaStmtAsm -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaStmtAsm extends Sema_SemaStmt {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnGCCAsmStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 141,
 FQN="clang::Sema::ActOnGCCAsmStmt", NM="_ZN5clang4Sema15ActOnGCCAsmStmtENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEN4llvm15MutableArrayRefIPNS_4ExprEEES9_S8_S9_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema15ActOnGCCAsmStmtENS_14SourceLocationEbbjjPPNS_14IdentifierInfoEN4llvm15MutableArrayRefIPNS_4ExprEEES9_S8_S9_S1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnGCCAsmStmt(SourceLocation AsmLoc, boolean IsSimple, 
               boolean IsVolatile, /*uint*/int NumOutputs, 
               /*uint*/int NumInputs, type$ptr<IdentifierInfo /*P*/ /*P*/> Names, 
               MutableArrayRef<Expr /*P*/ > constraints, MutableArrayRef<Expr /*P*/ > Exprs, 
               Expr /*P*/ asmString, MutableArrayRef<Expr /*P*/ > clobbers, 
               SourceLocation RParenLoc) {
  SmallVector<TargetInfo.ConstraintInfo> OutputConstraintInfos = null;
  SmallVector<TargetInfo.ConstraintInfo> InputConstraintInfos = null;
  SmallVector<GCCAsmStmt.AsmStringPiece> Pieces = null;
  try {
    /*uint*/int NumClobbers = clobbers.size();
    type$ptr<StringLiteral /*P*/ /*P*/> Constraints = $tryClone(((type$ptr<StringLiteral /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, constraints.data())));
    StringLiteral /*P*/ AsmString = cast_StringLiteral(asmString);
    type$ptr<StringLiteral /*P*/ /*P*/> Clobbers = $tryClone(((type$ptr<StringLiteral /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, clobbers.data())));
    
    OutputConstraintInfos/*J*/= new SmallVector<TargetInfo.ConstraintInfo>(4, new TargetInfo.ConstraintInfo());
    
    // The parser verifies that there is a string literal here.
    assert (AsmString.isAscii());
    
    // If we're compiling CUDA file and function attributes indicate that it's not
    // for this compilation side, skip all the checks.
    if (!DeclAttrsMatchCUDAMode($this().getLangOpts(), $this().getCurFunctionDecl())) {
      GCCAsmStmt /*P*/ NS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new GCCAsmStmt($this().Context, new SourceLocation(AsmLoc), IsSimple, IsVolatile, NumOutputs, NumInputs, Names, 
          Constraints, Exprs.data(), AsmString, NumClobbers, Clobbers, new SourceLocation(RParenLoc)));
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, NS);
    }
    
    for (/*uint*/int i = 0; i != NumOutputs; i++) {
      TargetInfo.ConstraintInfo Info = null;
      try {
        StringLiteral /*P*/ Literal = Constraints.$at(i);
        assert (Literal.isAscii());
        
        StringRef OutputName/*J*/= new StringRef();
        if ((Names.$at(i) != null)) {
          OutputName.$assignMove(Names.$at(i).getName());
        }
        
        Info/*J*/= new TargetInfo.ConstraintInfo(Literal.getString(), new StringRef(OutputName));
        if (!$this().Context.getTargetInfo().validateOutputConstraint(Info)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Literal.getLocStart(), 
                        diag.err_asm_invalid_output_constraint)), 
                    Info.getConstraintStr())));
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResultTTrue<Expr /*P*/ > ER = $this().CheckPlaceholderExpr(Exprs.$at(i));
        if (ER.isInvalid()) {
          return StmtError();
        }
        Exprs.$set(i, ER.get());
        
        // Check that the output exprs are valid lvalues.
        Expr /*P*/ OutputExpr = Exprs.$at(i);
        
        // Referring to parameters is not allowed in naked functions.
        if (CheckNakedParmReference(OutputExpr, /*Deref*/$this())) {
          return StmtError();
        }
        
        // Check that the output expression is compatible with memory constraint.
        if (Info.allowsMemory()
           && checkExprMemoryConstraintCompat(/*Deref*/$this(), OutputExpr, Info, false)) {
          return StmtError();
        }
        
        OutputConstraintInfos.push_back_T$C$R(Info);
        
        // If this is dependent, just continue.
        if (OutputExpr.isTypeDependent()) {
          continue;
        }
        
        Expr.isModifiableLvalueResult IsLV = OutputExpr.isModifiableLvalue($this().Context, /*Loc=*/ (type$ptr<SourceLocation> /*P*/ )null);
        switch (IsLV) {
         case MLV_Valid:
          // Cool, this is an lvalue.
          break;
         case MLV_ArrayType:
          // This is OK too.
          break;
         case MLV_LValueCast:
          {
            /*const*/ Expr /*P*/ LVal = OutputExpr.IgnoreParenNoopCasts($this().Context);
            if (!$this().getLangOpts().HeinousExtensions) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LVal.getLocStart(), diag.err_invalid_asm_cast_lvalue)), 
                    OutputExpr.getSourceRange()));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LVal.getLocStart(), diag.warn_invalid_asm_cast_lvalue)), 
                    OutputExpr.getSourceRange()));
              } finally {
                $c$.$destroy();
              }
            }
            // Accept, even if we emitted an error diagnostic.
            break;
          }
         case MLV_IncompleteType:
         case MLV_IncompleteVoidType:
          if ($this().RequireCompleteType(OutputExpr.getLocStart(), Exprs.$at(i).getType(), 
              diag.err_dereference_incomplete_type)) {
            return StmtError();
          }
         default:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OutputExpr.getLocStart(), 
                          diag.err_asm_invalid_lvalue_in_output)), 
                      OutputExpr.getSourceRange())));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        /*uint*/int Size = $ulong2uint($this().Context.getTypeSize(OutputExpr.getType()));
        if (!$this().Context.getTargetInfo().validateOutputSize(Literal.getString(), 
            Size)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OutputExpr.getLocStart(), 
                        diag.err_asm_invalid_output_size)), 
                    Info.getConstraintStr())));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    InputConstraintInfos/*J*/= new SmallVector<TargetInfo.ConstraintInfo>(4, new TargetInfo.ConstraintInfo());
    
    for (/*uint*/int i = NumOutputs, e = NumOutputs + NumInputs; i != e; i++) {
      TargetInfo.ConstraintInfo Info = null;
      try {
        StringLiteral /*P*/ Literal = Constraints.$at(i);
        assert (Literal.isAscii());
        
        StringRef InputName/*J*/= new StringRef();
        if ((Names.$at(i) != null)) {
          InputName.$assignMove(Names.$at(i).getName());
        }
        
        Info/*J*/= new TargetInfo.ConstraintInfo(Literal.getString(), new StringRef(InputName));
        if (!$this().Context.getTargetInfo().validateInputConstraint(new MutableArrayRef<TargetInfo.ConstraintInfo>(OutputConstraintInfos, false), 
            Info)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Literal.getLocStart(), 
                        diag.err_asm_invalid_input_constraint)), 
                    Info.getConstraintStr())));
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResultTTrue<Expr /*P*/ > ER = $this().CheckPlaceholderExpr(Exprs.$at(i));
        if (ER.isInvalid()) {
          return StmtError();
        }
        Exprs.$set(i, ER.get());
        
        Expr /*P*/ InputExpr = Exprs.$at(i);
        
        // Referring to parameters is not allowed in naked functions.
        if (CheckNakedParmReference(InputExpr, /*Deref*/$this())) {
          return StmtError();
        }
        
        // Check that the input expression is compatible with memory constraint.
        if (Info.allowsMemory()
           && checkExprMemoryConstraintCompat(/*Deref*/$this(), InputExpr, Info, true)) {
          return StmtError();
        }
        
        // Only allow void types for memory constraints.
        if (Info.allowsMemory() && !Info.allowsRegister()) {
          if (CheckAsmLValue(InputExpr, /*Deref*/$this())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(InputExpr.getLocStart(), 
                              diag.err_asm_invalid_lvalue_in_input)), 
                          Info.getConstraintStr()), 
                      InputExpr.getSourceRange())));
            } finally {
              $c$.$destroy();
            }
          }
        } else if (Info.requiresImmediateConstant() && !Info.allowsRegister()) {
          if (!InputExpr.isValueDependent()) {
            APSInt Result/*J*/= new APSInt();
            if (!InputExpr.EvaluateAsInt(Result, $this().Context)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(InputExpr.getLocStart(), diag.err_asm_immediate_expected)), 
                            Info.getConstraintStr()), InputExpr.getSourceRange())));
              } finally {
                $c$.$destroy();
              }
            }
            if (!Info.isValidAsmImmediate(Result)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(InputExpr.getLocStart(), 
                                    diag.err_invalid_asm_value_for_constraint)), 
                                Result.__toString(10)), Info.getConstraintStr()), 
                        InputExpr.getSourceRange())));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } else {
          ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultFunctionArrayLvalueConversion(Exprs.$at(i));
          if (Result.isInvalid()) {
            return StmtError();
          }
          
          Exprs.$set(i, Result.get());
        }
        if (Info.allowsRegister()) {
          if (InputExpr.getType().$arrow().isVoidType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(InputExpr.getLocStart(), 
                                  diag.err_asm_invalid_type_in_input)), 
                              InputExpr.getType()), Info.getConstraintStr()), 
                      InputExpr.getSourceRange())));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        InputConstraintInfos.push_back_T$C$R(Info);
        
        /*const*/ Type /*P*/ Ty = Exprs.$at(i).getType().getTypePtr();
        if (Ty.isDependentType()) {
          continue;
        }
        if (!Ty.isVoidType() || !Info.allowsMemory()) {
          if ($this().RequireCompleteType(InputExpr.getLocStart(), Exprs.$at(i).getType(), 
              diag.err_dereference_incomplete_type)) {
            return StmtError();
          }
        }
        
        /*uint*/int Size = $ulong2uint($this().Context.getTypeSize(Ty));
        if (!$this().Context.getTargetInfo().validateInputSize(Literal.getString(), 
            Size)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(InputExpr.getLocStart(), 
                        diag.err_asm_invalid_input_size)), 
                    Info.getConstraintStr())));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    // Check that the clobbers are valid.
    for (/*uint*/int i = 0; i != NumClobbers; i++) {
      StringLiteral /*P*/ Literal = Clobbers.$at(i);
      assert (Literal.isAscii());
      
      StringRef Clobber = Literal.getString();
      if (!$this().Context.getTargetInfo().isValidClobber(new StringRef(Clobber))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Literal.getLocStart(), 
                      diag.err_asm_unknown_register_name)), Clobber)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    GCCAsmStmt /*P*/ NS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new GCCAsmStmt($this().Context, new SourceLocation(AsmLoc), IsSimple, IsVolatile, NumOutputs, 
        NumInputs, Names, Constraints, Exprs.data(), 
        AsmString, NumClobbers, Clobbers, new SourceLocation(RParenLoc)));
    // Validate the asm string, ensuring it makes sense given the operands we
    // have.
    Pieces/*J*/= new SmallVector<GCCAsmStmt.AsmStringPiece>(8, new GCCAsmStmt.AsmStringPiece());
    uint$ref DiagOffs = create_uint$ref();
    {
      /*uint*/int DiagID = NS.AnalyzeAsmString(Pieces, $this().Context, DiagOffs);
      if ((DiagID != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag($this().getLocationOfStringLiteralByte(AsmString, DiagOffs.$deref()), DiagID)), 
              AsmString.getSourceRange()));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Validate constraints and modifiers.
    for (/*uint*/int i = 0, e = Pieces.size(); i != e; ++i) {
      final GCCAsmStmt.AsmStringPiece /*&*/ Piece = Pieces.$at(i);
      if (!Piece.isOperand()) {
        continue;
      }
      
      // Look for the correct constraint index.
      /*uint*/int ConstraintIdx = Piece.getOperandNo();
      /*uint*/int NumOperands = NS.getNumOutputs() + NS.getNumInputs();
      
      // Look for the (ConstraintIdx - NumOperands + 1)th constraint with
      // modifier '+'.
      if ($greatereq_uint(ConstraintIdx, NumOperands)) {
        /*uint*/int I = 0;
        /*uint*/int E = NS.getNumOutputs();
        
        for (/*uint*/int Cnt = ConstraintIdx - NumOperands; I != E; ++I)  {
          if (OutputConstraintInfos.$at(I).isReadWrite() && Cnt-- == 0) {
            ConstraintIdx = I;
            break;
          }
        }
        assert (I != E) : "Invalid operand number should have been caught in  AnalyzeAsmString";
      }
      
      // Now that we have the right indexes go ahead and check.
      StringLiteral /*P*/ Literal = Constraints.$at(ConstraintIdx);
      /*const*/ Type /*P*/ Ty = Exprs.$at(ConstraintIdx).getType().getTypePtr();
      if (Ty.isDependentType() || Ty.isIncompleteType()) {
        continue;
      }
      
      /*uint*/int Size = $ulong2uint($this().Context.getTypeSize(Ty));
      std.string SuggestedModifier/*J*/= new std.string();
      if (!$this().Context.getTargetInfo().validateConstraintModifier(Literal.getString(), Piece.getModifier(), Size, 
          SuggestedModifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Exprs.$at(ConstraintIdx).getLocStart(), 
              diag.warn_asm_mismatched_size_modifier)));
          if (!SuggestedModifier.empty()) {
            SemaDiagnosticBuilder B = null;
            try {
              /*FIXME: Initializer produces not destroyed temporary!*/B = $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Piece.getRange().getBegin(), 
                          diag.note_asm_missing_constraint_modifier)), 
                      SuggestedModifier)));
              SuggestedModifier.$assignMove($add_string_string$C($add_T$C$P_string$C(/*KEEP_STR*/"%", SuggestedModifier), Piece.getString()));
              B.AddFixItHint(FixItHint.CreateReplacement(Piece.getRange(), 
                      new StringRef(SuggestedModifier)));
            } finally {
              if (B != null) { B.$destroy(); }
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Validate tied input operands for type mismatches.
    /*uint*/int NumAlternatives = ~0/*U*/;
    for (/*uint*/int i = 0, e = OutputConstraintInfos.size(); i != e; ++i) {
      final TargetInfo.ConstraintInfo /*&*/ Info = OutputConstraintInfos.$at(i);
      StringRef ConstraintStr = new StringRef(Info.getConstraintStr());
      /*uint*/int AltCount = ConstraintStr.count($$COMMA) + 1;
      if (NumAlternatives == ~0/*U*/) {
        NumAlternatives = AltCount;
      } else if (NumAlternatives != AltCount) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NS.getOutputExpr(i).getLocStart(), 
                          diag.err_asm_unexpected_constraint_alternatives)), 
                      NumAlternatives), AltCount)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    SmallVectorUInt InputMatchedToOutput/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 4, OutputConstraintInfos.size(), 
        ~0/*U*/, 0);
    for (/*uint*/int i = 0, e = InputConstraintInfos.size(); i != e; ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        final TargetInfo.ConstraintInfo /*&*/ Info = InputConstraintInfos.$at(i);
        StringRef ConstraintStr = new StringRef(Info.getConstraintStr());
        /*uint*/int AltCount = ConstraintStr.count($$COMMA) + 1;
        if (NumAlternatives == ~0/*U*/) {
          NumAlternatives = AltCount;
        } else if (NumAlternatives != AltCount) {
          return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NS.getInputExpr(i).getLocStart(), 
                          diag.err_asm_unexpected_constraint_alternatives)), 
                      NumAlternatives), AltCount)));
        }
        
        // If this is a tied constraint, verify that the output and input have
        // either exactly the same type, or that they are int/ptr operands with the
        // same size (int/long, int*/long, are ok etc).
        if (!Info.hasTiedOperand()) {
          continue;
        }
        
        /*uint*/int TiedTo = Info.getTiedOperand();
        /*uint*/int InputOpNo = i + NumOutputs;
        Expr /*P*/ OutputExpr = Exprs.$at(TiedTo);
        Expr /*P*/ InputExpr = Exprs.$at(InputOpNo);
        
        // Make sure no more than one input constraint matches each output.
        assert ($less_uint(TiedTo, InputMatchedToOutput.size())) : "TiedTo value out of range";
        if (InputMatchedToOutput.$at(TiedTo) != ~0/*U*/) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NS.getInputExpr(i).getLocStart(), 
                  diag.err_asm_input_duplicate_match)), 
              TiedTo));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NS.getInputExpr(InputMatchedToOutput.$at(TiedTo)).getLocStart(), 
                  diag.note_asm_input_duplicate_first)), 
              TiedTo));
          return StmtError();
        }
        InputMatchedToOutput.$set(TiedTo, i);
        if (OutputExpr.isTypeDependent() || InputExpr.isTypeDependent()) {
          continue;
        }
        
        QualType InTy = InputExpr.getType();
        QualType OutTy = OutputExpr.getType();
        if ($this().Context.hasSameType(new QualType(InTy), new QualType(OutTy))) {
          continue; // All types can be tied to themselves.
        }
        
        // Decide if the input and output are in the same domain (integer/ptr or
        // floating point.
        final class/*enum*/ AsmDomain {
          private static final /*uint*/int AD_Int = 0;
          private static final /*uint*/int AD_FP = AD_Int + 1;
          private static final /*uint*/int AD_Other = AD_FP + 1;
        }/* AsmDomain*//*uint*/int InputDomain;
        /* AsmDomain*//*uint*/int OutputDomain;
        if (InTy.$arrow().isIntegerType() || InTy.$arrow().isPointerType()) {
          InputDomain = AsmDomain.AD_Int;
        } else if (InTy.$arrow().isRealFloatingType()) {
          InputDomain = AsmDomain.AD_FP;
        } else {
          InputDomain = AsmDomain.AD_Other;
        }
        if (OutTy.$arrow().isIntegerType() || OutTy.$arrow().isPointerType()) {
          OutputDomain = AsmDomain.AD_Int;
        } else if (OutTy.$arrow().isRealFloatingType()) {
          OutputDomain = AsmDomain.AD_FP;
        } else {
          OutputDomain = AsmDomain.AD_Other;
        }
        
        // They are ok if they are the same size and in the same domain.  This
        // allows tying things like:
        //   void* to int*
        //   void* to int            if they are the same size.
        //   double to long double   if they are the same size.
        //
        long/*uint64_t*/ OutSize = $this().Context.getTypeSize(new QualType(OutTy));
        long/*uint64_t*/ InSize = $this().Context.getTypeSize(new QualType(InTy));
        if (OutSize == InSize && InputDomain == OutputDomain
           && InputDomain != AsmDomain.AD_Other) {
          continue;
        }
        
        // If the smaller input/output operand is not mentioned in the asm string,
        // then we can promote the smaller one to a larger input and the asm string
        // won't notice.
        boolean SmallerValueMentioned = false;
        
        // If this is a reference to the input and if the input was the smaller
        // one, then we have to reject this asm.
        if (isOperandMentioned(InputOpNo, new ArrayRef<GCCAsmStmt.AsmStringPiece>(Pieces, false))) {
          // This is a use in the asm string of the smaller operand.  Since we
          // codegen this by promoting to a wider value, the asm will get printed
          // "wrong".
          SmallerValueMentioned |= $less_ulong(InSize, OutSize);
        }
        if (isOperandMentioned(TiedTo, new ArrayRef<GCCAsmStmt.AsmStringPiece>(Pieces, false))) {
          // If this is a reference to the output, and if the output is the larger
          // value, then it's ok because we'll promote the input to the larger type.
          SmallerValueMentioned |= $less_ulong(OutSize, InSize);
        }
        
        // If the smaller value wasn't mentioned in the asm string, and if the
        // output was a register, just extend the shorter one to the size of the
        // larger one.
        if (!SmallerValueMentioned && InputDomain != AsmDomain.AD_Other
           && OutputConstraintInfos.$at(TiedTo).allowsRegister()) {
          continue;
        }
        
        // Either both of the operands were mentioned or the smaller one was
        // mentioned.  One more special case that we'll allow: if the tied input is
        // integer, unmentioned, and is a constant, then we'll allow truncating it
        // down to the size of the destination.
        if (InputDomain == AsmDomain.AD_Int && OutputDomain == AsmDomain.AD_Int
           && !isOperandMentioned(InputOpNo, new ArrayRef<GCCAsmStmt.AsmStringPiece>(Pieces, false))
           && InputExpr.isEvaluatable($this().Context)) {
          CastKind castKind = (OutTy.$arrow().isBooleanType() ? CastKind.CK_IntegralToBoolean : CastKind.CK_IntegralCast);
          InputExpr = $this().ImpCastExprToType(InputExpr, new QualType(OutTy), castKind).get();
          Exprs.$set(InputOpNo, InputExpr);
          NS.setInputExpr(i, InputExpr);
          continue;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(InputExpr.getLocStart(), 
                            diag.err_asm_tying_incompatible_types)), 
                        InTy), OutTy), OutputExpr.getSourceRange()), 
            InputExpr.getSourceRange()));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    }
    
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, NS);
  } finally {
    if (Pieces != null) { Pieces.$destroy(); }
    if (InputConstraintInfos != null) { InputConstraintInfos.$destroy(); }
    if (OutputConstraintInfos != null) { OutputConstraintInfos.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupInlineAsmIdentifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 561,
 FQN="clang::Sema::LookupInlineAsmIdentifier", NM="_ZN5clang4Sema25LookupInlineAsmIdentifierERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdERN4llvm23InlineAsmIdentifierInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema25LookupInlineAsmIdentifierERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdERN4llvm23InlineAsmIdentifierInfoEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > LookupInlineAsmIdentifier(final CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         final UnqualifiedId /*&*/ Id, 
                         final InlineAsmIdentifierInfo /*&*/ Info, 
                         boolean IsUnevaluatedContext) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Info.clear();
    if (IsUnevaluatedContext) {
      $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.UnevaluatedAbstract, 
          ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
    }
    
    ActionResultTTrue<Expr /*P*/ > Result = $c$.clean($this().ActOnIdExpression($this().getCurScope(), SS, new SourceLocation(TemplateKWLoc), Id, 
        /*trailing lparen*/ false, 
        /*is & operand*/ false, 
        /*CorrectionCandidateCallback=*/ $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$NullPtr.INSTANCE, null)), 
        /*IsInlineAsmIdentifier=*/ true));
    if (IsUnevaluatedContext) {
      $this().PopExpressionEvaluationContext();
    }
    if (!Result.isUsable()) {
      return Result;
    }
    
    Result.$assignMove($this().CheckPlaceholderExpr(Result.get()));
    if (!Result.isUsable()) {
      return Result;
    }
    
    // Referring to parameters is not allowed in naked functions.
    if (CheckNakedParmReference(Result.get(), /*Deref*/$this())) {
      return ExprError();
    }
    
    QualType T = Result.get().getType();
    if (T.$arrow().isDependentType()) {
      return Result;
    }
    
    // Any sort of function type is fine.
    if (T.$arrow().isFunctionType()) {
      return Result;
    }
    
    // Otherwise, it needs to be a complete type.
    if ($this().RequireCompleteExprType(Result.get(), diag.err_asm_incomplete_type)) {
      return ExprError();
    }
    
    fillInlineAsmTypeInfo($this().Context, new QualType(T), Info);
    
    // We can work with the expression as long as it's not an r-value.
    if (!Result.get().isRValue()) {
      Info.IsVarDecl = true;
    }
    
    return Result;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupInlineAsmField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 615,
 FQN="clang::Sema::LookupInlineAsmField", NM="_ZN5clang4Sema20LookupInlineAsmFieldEN4llvm9StringRefES2_RjNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema20LookupInlineAsmFieldEN4llvm9StringRefES2_RjNS_14SourceLocationE")
//</editor-fold>
public final boolean LookupInlineAsmField(StringRef Base, StringRef Member, 
                    final uint$ref/*uint &*/ Offset, SourceLocation AsmLoc) {
  LookupResult BaseResult = null;
  try {
    Offset.$set(0);
    SmallVector<StringRef> Members/*J*/= new SmallVector<StringRef>(2, new StringRef());
    Member.split(Members, /*STRINGREF_STR*/".");
    
    BaseResult/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf($this().Context.Idents.get(/*NO_COPY*/Base))), new SourceLocation(), 
        LookupNameKind.LookupOrdinaryName);
    if (!$this().LookupName(BaseResult, $this().getCurScope())) {
      return true;
    }
    if (!BaseResult.isSingleResult()) {
      return true;
    }
    NamedDecl /*P*/ FoundDecl = BaseResult.getFoundDecl();
    for (StringRef NextMember : Members) {
      LookupResult FieldResult = null;
      try {
        /*const*/ RecordType /*P*/ RT = null;
        {
          VarDecl /*P*/ VD = dyn_cast_VarDecl(FoundDecl);
          if ((VD != null)) {
            RT = VD.getType().$arrow().getAs$RecordType();
          } else {
            TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(FoundDecl);
            if ((TD != null)) {
              $this().MarkAnyDeclReferenced(TD.getLocation(), TD, /*OdrUse=*/ false);
              RT = TD.getUnderlyingType().$arrow().getAs$RecordType();
            } else {
              TypeDecl /*P*/ TD$1 = dyn_cast_TypeDecl(FoundDecl);
              if ((TD$1 != null)) {
                RT = TD$1.getTypeForDecl().getAs$RecordType();
              } else {
                FieldDecl /*P*/ TD$2 = dyn_cast_FieldDecl(FoundDecl);
                if ((TD$2 != null)) {
                  RT = TD$2.getType().$arrow().getAs$RecordType();
                }
              }
            }
          }
        }
        if (!(RT != null)) {
          return true;
        }
        if ($this().RequireCompleteType(new SourceLocation(AsmLoc), new QualType(RT, 0), 
            diag.err_asm_incomplete_type)) {
          return true;
        }
        
        FieldResult/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf($this().Context.Idents.get(/*NO_COPY*/NextMember))), 
            new SourceLocation(), LookupNameKind.LookupMemberName);
        if (!$this().LookupQualifiedName(FieldResult, RT.getDecl())) {
          return true;
        }
        if (!FieldResult.isSingleResult()) {
          return true;
        }
        FoundDecl = FieldResult.getFoundDecl();
        
        // FIXME: Handle IndirectFieldDecl?
        FieldDecl /*P*/ FD = dyn_cast_FieldDecl(FoundDecl);
        if (!(FD != null)) {
          return true;
        }
        
        final /*const*/ ASTRecordLayout /*&*/ RL = $this().Context.getASTRecordLayout(RT.getDecl());
        /*uint*/int i = FD.getFieldIndex();
        CharUnits Result = $this().Context.toCharUnitsFromBits(RL.getFieldOffset(i));
        Offset.$set$addassign((/*uint*/int)$long2uint(Result.getQuantity()));
      } finally {
        if (FieldResult != null) { FieldResult.$destroy(); }
      }
    }
    
    return false;
  } finally {
    if (BaseResult != null) { BaseResult.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupInlineAsmVarDeclField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 672,
 FQN="clang::Sema::LookupInlineAsmVarDeclField", NM="_ZN5clang4Sema27LookupInlineAsmVarDeclFieldEPNS_4ExprEN4llvm9StringRefERNS3_23InlineAsmIdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema27LookupInlineAsmVarDeclFieldEPNS_4ExprEN4llvm9StringRefERNS3_23InlineAsmIdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > LookupInlineAsmVarDeclField(Expr /*P*/ E, StringRef Member, 
                           final InlineAsmIdentifierInfo /*&*/ Info, 
                           SourceLocation AsmLoc) {
  LookupResult FieldResult = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Info.clear();
    
    QualType T = E.getType();
    if (T.$arrow().isDependentType()) {
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo();
      NameInfo.setLoc(new SourceLocation(AsmLoc));
      NameInfo.setName(new DeclarationName($AddrOf($this().Context.Idents.get(/*NO_COPY*/Member))));
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDependentScopeMemberExpr.Create($this().Context, E, new QualType(T), /*IsArrow=*/ false, new SourceLocation(AsmLoc), new NestedNameSpecifierLoc(), 
              new SourceLocation(), 
              /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, new DeclarationNameInfo(NameInfo), /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null));
    }
    
    /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
    // FIXME: Diagnose this as field access into a scalar type.
    if (!(RT != null)) {
      return new ActionResultTTrue<Expr /*P*/ >();
    }
    
    FieldResult/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf($this().Context.Idents.get(/*NO_COPY*/Member))), new SourceLocation(AsmLoc), 
        LookupNameKind.LookupMemberName);
    if (!$this().LookupQualifiedName(FieldResult, RT.getDecl())) {
      return new ActionResultTTrue<Expr /*P*/ >();
    }
    
    // Only normal and indirect field results will work.
    ValueDecl /*P*/ FD = dyn_cast_FieldDecl(FieldResult.getFoundDecl());
    if (!(FD != null)) {
      FD = dyn_cast_IndirectFieldDecl(FieldResult.getFoundDecl());
    }
    if (!(FD != null)) {
      return new ActionResultTTrue<Expr /*P*/ >();
    }
    
    // Make an Expr to thread through OpDecl.
    ActionResultTTrue<Expr /*P*/ > Result = $c$.clean($this().BuildMemberReferenceExpr2(E, E.getType(), new SourceLocation(AsmLoc), /*IsArrow=*/ false, $c$.track(new CXXScopeSpec()), 
        new SourceLocation(), (NamedDecl /*P*/ )null, FieldResult, (/*const*/ TemplateArgumentListInfo /*P*/ )null, (/*const*/ Scope /*P*/ )null));
    if (Result.isInvalid()) {
      return Result;
    }
    Info.OpDecl = Result.get();
    
    fillInlineAsmTypeInfo($this().Context, Result.get().getType(), Info);
    
    // Fields are "variables" as far as inline assembly is concerned.
    Info.IsVarDecl = true;
    
    return Result;
  } finally {
    if (FieldResult != null) { FieldResult.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMSAsmStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 723,
 FQN="clang::Sema::ActOnMSAsmStmt", NM="_ZN5clang4Sema14ActOnMSAsmStmtENS_14SourceLocationES1_N4llvm8ArrayRefINS_5TokenEEENS2_9StringRefEjjNS3_IS6_EES7_NS3_IPNS_4ExprEEES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema14ActOnMSAsmStmtENS_14SourceLocationES1_N4llvm8ArrayRefINS_5TokenEEENS2_9StringRefEjjNS3_IS6_EES7_NS3_IPNS_4ExprEEES1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnMSAsmStmt(SourceLocation AsmLoc, SourceLocation LBraceLoc, 
              ArrayRefToken AsmToks, 
              StringRef AsmString, 
              /*uint*/int NumOutputs, /*uint*/int NumInputs, 
              ArrayRef<StringRef> Constraints, 
              ArrayRef<StringRef> Clobbers, 
              ArrayRef<Expr /*P*/ > Exprs, 
              SourceLocation EndLoc) {
  boolean IsSimple = (NumOutputs != 0 || NumInputs != 0);
  $this().getCurFunction().setHasBranchProtectedScope();
  MSAsmStmt /*P*/ NS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new MSAsmStmt($this().Context, new SourceLocation(AsmLoc), new SourceLocation(LBraceLoc), IsSimple, 
      /*IsVolatile*/ true, new ArrayRefToken(AsmToks), NumOutputs, NumInputs, 
      new ArrayRef<StringRef>(Constraints), new ArrayRef<Expr /*P*/ >(Exprs), new StringRef(AsmString), 
      new ArrayRef<StringRef>(Clobbers), new SourceLocation(EndLoc)));
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, NS);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetOrCreateMSAsmLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp", line = 741,
 FQN="clang::Sema::GetOrCreateMSAsmLabel", NM="_ZN5clang4Sema21GetOrCreateMSAsmLabelEN4llvm9StringRefENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmtAsm.cpp -nm=_ZN5clang4Sema21GetOrCreateMSAsmLabelEN4llvm9StringRefENS_14SourceLocationEb")
//</editor-fold>
public final LabelDecl /*P*/ GetOrCreateMSAsmLabel(StringRef ExternalLabelName, 
                     SourceLocation Location, 
                     boolean AlwaysCreate) {
  LabelDecl /*P*/ Label = $this().LookupOrCreateLabel($this().PP.getIdentifierInfo(new StringRef(ExternalLabelName)), 
      new SourceLocation(Location));
  if (Label.isMSAsmLabel()) {
    // If we have previously created this label implicitly, mark it as used.
    Label.markUsed($this().Context);
  } else {
    raw_string_ostream OS = null;
    try {
      // Otherwise, insert it, but only resolve it if we have seen the label itself.
      std.string InternalName/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(InternalName);
      // Create an internal name for the label.  The name should not be a valid mangled
      // name, and should be unique.  We use a dot to make the name an invalid mangled
      // name.
      OS.$out(/*KEEP_STR*/"__MSASMLABEL_.").$out_uint($this().MSAsmLabelNameCounter++).$out(/*KEEP_STR*/"__");
      for (/*const*/char$ptr/*char P*/ it = $tryClone(ExternalLabelName.begin()); $noteq_ptr(it, ExternalLabelName.end());
           it.$preInc()) {
        OS.$out_char(it.$star());
        if (it.$star() == $$DOLLAR) {
          // We escape '$' in asm strings by replacing it with "$$"
          OS.$out_char($$DOLLAR);
        }
      }
      Label.setMSAsmLabel(new StringRef(OS.str()));
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }
  if (AlwaysCreate) {
    // The label might have been created implicitly from a previously encountered
    // goto statement.  So, for both newly created and looked up labels, we mark
    // them as resolved.
    Label.setMSAsmLabelResolved();
  }
  // Adjust their location for being able to generate accurate diagnostics.
  Label.setLocation(new SourceLocation(Location));
  
  return Label;
}

} // END OF class Sema_SemaStmtAsm
