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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGStmtStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZL16getAsmSrcLocInfoPKN5clang13StringLiteralERNS_7CodeGen15CodeGenFunctionE;_ZL18SimplifyConstraintPKcRKN5clang10TargetInfoEPN4llvm15SmallVectorImplINS2_14ConstraintInfoEEE;_ZL22AddVariableConstraintsRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKN5clang4ExprERKNS7_10TargetInfoERNS7_7CodeGen13CodeGenModuleERKNS7_7AsmStmtEb;_ZL24CollectStatementsForCasePKN5clang4StmtEPKNS_10SwitchCaseERbRN4llvm15SmallVectorImplIS2_EE;_ZL26FindCaseStatementsForValueRKN5clang10SwitchStmtERKN4llvm6APSIntERNS3_15SmallVectorImplIPKNS_4StmtEEERNS_10ASTContextERPKNS_10SwitchCaseE;_ZL22AddVariableConstraintsRKSsRKN5clang4ExprERKNS1_10TargetInfoERNS1_7CodeGen13CodeGenModuleERKNS1_7AsmStmtEb; -static-type=CGStmtStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGStmtStatics {

/// AddVariableConstraints - Look at AsmExpr and if it is a variable declared
/// as using a particular register add that as a constraint that will be used
/// in this asm stmt.
//<editor-fold defaultstate="collapsed" desc="AddVariableConstraints">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1673,
 FQN="AddVariableConstraints", NM="_ZL22AddVariableConstraintsRKSsRKN5clang4ExprERKNS1_10TargetInfoERNS1_7CodeGen13CodeGenModuleERKNS1_7AsmStmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZL22AddVariableConstraintsRKSsRKN5clang4ExprERKNS1_10TargetInfoERNS1_7CodeGen13CodeGenModuleERKNS1_7AsmStmtEb")
//</editor-fold>
public static std.string AddVariableConstraints(final /*const*/std.string/*&*/ Constraint, final /*const*/ Expr /*&*/ AsmExpr, 
                      final /*const*/ TargetInfo /*&*/ Target, final CodeGenModule /*&*/ CGM, 
                      final /*const*/ AsmStmt /*&*/ Stmt, /*const*/boolean EarlyClobber) {
  TargetInfo.ConstraintInfo Info = null;
  try {
    /*const*/ DeclRefExpr /*P*/ AsmDeclRef = dyn_cast_DeclRefExpr(/*AddrOf*/AsmExpr);
    if (!(AsmDeclRef != null)) {
      return new std.string(Constraint);
    }
    final /*const*/ ValueDecl /*&*/ Value = /*Deref*/AsmDeclRef.getDecl$Const();
    /*const*/ VarDecl /*P*/ Variable = dyn_cast_VarDecl(/*AddrOf*/Value);
    if (!(Variable != null)) {
      return new std.string(Constraint);
    }
    if (Variable.getStorageClass() != StorageClass.SC_Register) {
      return new std.string(Constraint);
    }
    AsmLabelAttr /*P*/ Attr = Variable.getAttr(AsmLabelAttr.class);
    if (!(Attr != null)) {
      return new std.string(Constraint);
    }
    StringRef Register = Attr.getLabel();
    assert (Target.isValidGCCRegisterName(new StringRef(Register)));
    // We're using validateOutputConstraint here because we only care if
    // this is a register constraint.
    Info/*J*/= new TargetInfo.ConstraintInfo(new StringRef(Constraint), new StringRef(/*KEEP_STR*/$EMPTY));
    if (Target.validateOutputConstraint(Info)
       && !Info.allowsRegister()) {
      CGM.ErrorUnsupported(/*AddrOf*/Stmt, $__asm__);
      return new std.string(Constraint);
    }
    // Canonicalize the register here before returning it.
    Register.$assignMove(Target.getNormalizedGCCRegisterName(new StringRef(Register)));
    return $add_string_T$C$P($add_T$C$P_string((EarlyClobber ? $("&{") : $LCURLY), Register.str()), /*KEEP_STR*/"}");
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="CollectStatementsForCase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1293,
 FQN="CollectStatementsForCase", NM="_ZL24CollectStatementsForCasePKN5clang4StmtEPKNS_10SwitchCaseERbRN4llvm15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZL24CollectStatementsForCasePKN5clang4StmtEPKNS_10SwitchCaseERbRN4llvm15SmallVectorImplIS2_EE")
//</editor-fold>
public static CSFC_Result CollectStatementsForCase(/*const*/ Stmt /*P*/ S, 
                        /*const*/ SwitchCase /*P*/ Case, 
                        final bool$ref/*bool &*/ FoundCase, 
                        final SmallVectorImpl</*const*/ Stmt /*P*/ > /*&*/ ResultStmts) {
  // If this is a null statement, just succeed.
  if (!(S != null)) {
    return (Case != null) ? CSFC_Result.CSFC_Success : CSFC_Result.CSFC_FallThrough;
  }
  {
    
    // If this is the switchcase (case 4: or default) that we're looking for, then
    // we're in business.  Just add the substatement.
    /*const*/ SwitchCase /*P*/ SC = dyn_cast_SwitchCase(S);
    if ((SC != null)) {
      if (S == Case) {
        FoundCase.$set(true);
        return CollectStatementsForCase(SC.getSubStmt$Const(), (/*const*/ SwitchCase /*P*/ )null, FoundCase, 
            ResultStmts);
      }
      
      // Otherwise, this is some other case or default statement, just ignore it.
      return CollectStatementsForCase(SC.getSubStmt$Const(), Case, FoundCase, 
          ResultStmts);
    }
  }
  
  // If we are in the live part of the code and we found our break statement,
  // return a success!
  if (!(Case != null) && isa_BreakStmt(S)) {
    return CSFC_Result.CSFC_Success;
  }
  {
    
    // If this is a switch statement, then it might contain the SwitchCase, the
    // break, or neither.
    /*const*/ CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(S);
    if ((CS != null)) {
      // Handle this as two cases: we might be looking for the SwitchCase (if so
      // the skipped statements must be skippable) or we might already have it.
      type$ptr<Stmt /*P*/ /*const*/ /*P*/> I = $tryClone(CS.body_begin$Const());
      type$ptr<Stmt /*P*/ /*const*/ /*P*/> E = $tryClone(CS.body_end$Const());
      if ((Case != null)) {
        // Keep track of whether we see a skipped declaration.  The code could be
        // using the declaration even if it is skipped, so we can't optimize out
        // the decl if the kept statements might refer to it.
        boolean HadSkippedDecl = false;
        
        // If we're looking for the case, just see if we can skip each of the
        // substatements.
        for (; (Case != null) && $noteq_ptr(I, E); I.$preInc()) {
          HadSkippedDecl |= isa_DeclStmt(I.$star());
          switch (CollectStatementsForCase(I.$star(), Case, FoundCase, ResultStmts)) {
           case CSFC_Failure:
            return CSFC_Result.CSFC_Failure;
           case CSFC_Success:
            // A successful result means that either 1) that the statement doesn't
            // have the case and is skippable, or 2) does contain the case value
            // and also contains the break to exit the switch.  In the later case,
            // we just verify the rest of the statements are elidable.
            if (FoundCase.$deref()) {
              // If we found the case and skipped declarations, we can't do the
              // optimization.
              if (HadSkippedDecl) {
                return CSFC_Result.CSFC_Failure;
              }
              
              for (I.$preInc(); $noteq_ptr(I, E); I.$preInc())  {
                if (CodeGenFunction.ContainsLabel(I.$star(), true)) {
                  return CSFC_Result.CSFC_Failure;
                }
              }
              return CSFC_Result.CSFC_Success;
            }
            break;
           case CSFC_FallThrough:
            // If we have a fallthrough condition, then we must have found the
            // case started to include statements.  Consider the rest of the
            // statements in the compound statement as candidates for inclusion.
            assert (FoundCase.$deref()) : "Didn't find case but returned fallthrough?";
            // We recursively found Case, so we're not looking for it anymore.
            Case = null;
            
            // If we found the case and skipped declarations, we can't do the
            // optimization.
            if (HadSkippedDecl) {
              return CSFC_Result.CSFC_Failure;
            }
            break;
          }
        }
      }
      
      // If we have statements in our range, then we know that the statements are
      // live and need to be added to the set of statements we're tracking.
      for (; $noteq_ptr(I, E); I.$preInc()) {
        switch (CollectStatementsForCase(I.$star(), (/*const*/ SwitchCase /*P*/ )null, FoundCase, ResultStmts)) {
         case CSFC_Failure:
          return CSFC_Result.CSFC_Failure;
         case CSFC_FallThrough:
          // A fallthrough result means that the statement was simple and just
          // included in ResultStmt, keep adding them afterwards.
          break;
         case CSFC_Success:
          // A successful result means that we found the break statement and
          // stopped statement inclusion.  We just ensure that any leftover stmts
          // are skippable and return success ourselves.
          for (I.$preInc(); $noteq_ptr(I, E); I.$preInc())  {
            if (CodeGenFunction.ContainsLabel(I.$star(), true)) {
              return CSFC_Result.CSFC_Failure;
            }
          }
          return CSFC_Result.CSFC_Success;
        }
      }
      
      return (Case != null) ? CSFC_Result.CSFC_Success : CSFC_Result.CSFC_FallThrough;
    }
  }
  
  // Okay, this is some other statement that we don't handle explicitly, like a
  // for statement or increment etc.  If we are skipping over this statement,
  // just verify it doesn't have labels, which would make it invalid to elide.
  if ((Case != null)) {
    if (CodeGenFunction.ContainsLabel(S, true)) {
      return CSFC_Result.CSFC_Failure;
    }
    return CSFC_Result.CSFC_Success;
  }
  
  // Otherwise, we want to include this statement.  Everything is cool with that
  // so long as it doesn't contain a break out of the switch we're in.
  if (CodeGenFunction.containsBreak(S)) {
    return CSFC_Result.CSFC_Failure;
  }
  
  // Otherwise, everything is great.  Include the statement and tell the caller
  // that we fall through and include the next statement as well.
  ResultStmts.push_back(S);
  return CSFC_Result.CSFC_FallThrough;
}


/// FindCaseStatementsForValue - Find the case statement being jumped to and
/// then invoke CollectStatementsForCase to find the list of statements to emit
/// for a switch on constant.  See the comment above CollectStatementsForCase
/// for more details.
//<editor-fold defaultstate="collapsed" desc="FindCaseStatementsForValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1419,
 FQN="FindCaseStatementsForValue", NM="_ZL26FindCaseStatementsForValueRKN5clang10SwitchStmtERKN4llvm6APSIntERNS3_15SmallVectorImplIPKNS_4StmtEEERNS_10ASTContextERPKNS_10SwitchCaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZL26FindCaseStatementsForValueRKN5clang10SwitchStmtERKN4llvm6APSIntERNS3_15SmallVectorImplIPKNS_4StmtEEERNS_10ASTContextERPKNS_10SwitchCaseE")
//</editor-fold>
public static boolean FindCaseStatementsForValue(final /*const*/ SwitchStmt /*&*/ S, 
                          final /*const*/ APSInt /*&*/ ConstantCondValue, 
                          final SmallVectorImpl</*const*/ Stmt /*P*/ > /*&*/ ResultStmts, 
                          final ASTContext /*&*/ C, 
                          final type$ref</*const*/ SwitchCase /*P*/ /*&*/> ResultCase) {
  // First step, find the switch case that is being branched to.  We can do this
  // efficiently by scanning the SwitchCase list.
  /*const*/ SwitchCase /*P*/ Case = S.getSwitchCaseList$Const();
  /*const*/ DefaultStmt /*P*/ DefaultCase = null;
  
  for (; (Case != null); Case = Case.getNextSwitchCase$Const()) {
    {
      // It's either a default or case.  Just remember the default statement in
      // case we're not jumping to any numbered cases.
      /*const*/ DefaultStmt /*P*/ DS = dyn_cast_DefaultStmt(Case);
      if ((DS != null)) {
        DefaultCase = DS;
        continue;
      }
    }
    
    // Check to see if this case is the one we're looking for.
    /*const*/ CaseStmt /*P*/ CS = cast_CaseStmt(Case);
    // Don't handle case ranges yet.
    if ((CS.getRHS$Const() != null)) {
      return false;
    }
    
    // If we found our case, remember it as 'case'.
    if (CS.getLHS$Const().EvaluateKnownConstInt(C).$eq(ConstantCondValue)) {
      break;
    }
  }
  
  // If we didn't find a matching case, we use a default if it exists, or we
  // elide the whole switch body!
  if (!(Case != null)) {
    // It is safe to elide the body of the switch if it doesn't contain labels
    // etc.  If it is safe, return successfully with an empty ResultStmts list.
    if (!(DefaultCase != null)) {
      return !CodeGenFunction.ContainsLabel(/*AddrOf*/S);
    }
    Case = DefaultCase;
  }
  
  // Ok, we know which case is being jumped to, try to collect all the
  // statements that follow it.  This can fail for a variety of reasons.  Also,
  // check to see that the recursive walk actually found our case statement.
  // Insane cases like this can fail to find it in the recursive walk since we
  // don't handle every stmt kind:
  // switch (4) {
  //   while (1) {
  //     case 4: ...
  bool$ref FoundCase = create_bool$ref(false);
  ResultCase.$set(Case);
  return CollectStatementsForCase(S.getBody$Const(), Case, FoundCase, 
      ResultStmts) != CSFC_Result.CSFC_Failure
     && FoundCase.$deref();
}

//<editor-fold defaultstate="collapsed" desc="SimplifyConstraint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1620,
 FQN="SimplifyConstraint", NM="_ZL18SimplifyConstraintPKcRKN5clang10TargetInfoEPN4llvm15SmallVectorImplINS2_14ConstraintInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZL18SimplifyConstraintPKcRKN5clang10TargetInfoEPN4llvm15SmallVectorImplINS2_14ConstraintInfoEEE")
//</editor-fold>
public static std.string SimplifyConstraint(/*const*/char$ptr/*char P*/ Constraint, final /*const*/ TargetInfo /*&*/ Target) {
  return SimplifyConstraint(Constraint, Target, 
                  (SmallVectorImpl<TargetInfo.ConstraintInfo> /*P*/ )null);
}
public static std.string SimplifyConstraint(/*const*/char$ptr/*char P*/ Constraint, final /*const*/ TargetInfo /*&*/ Target, 
                  SmallVectorImpl<TargetInfo.ConstraintInfo> /*P*/ OutCons/*= null*/) {
  std.string Result/*J*/= new std.string();
  while ((Constraint.$star() != 0)) {
    switch (Constraint.$star()) {
     default:
      Result.$addassign(Target.convertConstraint(Constraint));
      break;
     case '*':
     case '?':
     case '!':
     case '=': // Will see this and the following in mult-alt constraints.
     case '+':
      break;
     case '#': // Ignore the rest of the constraint alternative.
      while ((Constraint.$at(1) != 0) && Constraint.$at(1) != $$COMMA) {
        Constraint.$postInc();
      }
      break;
     case '&':
     case '%':
      Result.$addassign_T(Constraint.$star());
      while ((Constraint.$at(1) != 0) && Constraint.$at(1) == Constraint.$star()) {
        Constraint.$postInc();
      }
      break;
     case ',':
      Result.$addassign_T$C$P(/*KEEP_STR*/"|");
      break;
     case 'g':
      Result.$addassign_T$C$P(/*KEEP_STR*/"imr");
      break;
     case '[':
      {
        assert ((OutCons != null)) : "Must pass output names to constraints with a symbolic name";
        uint$ref Index = create_uint$ref();
        boolean result = Target.resolveSymbolicName(Constraint, new ArrayRef<TargetInfo.ConstraintInfo>(/*Deref*/OutCons, false), Index);
        assert (result) : "Could not resolve symbolic name";
        ///*J:(void)*/result;
        Result.$addassign(llvm.utostr($uint2ulong(Index.$deref())));
        break;
      }
    }
    
    Constraint.$postInc();
  }
  
  return Result;
}


/// getAsmSrcLocInfo - Return the !srcloc metadata node to attach to an inline
/// asm call instruction.  The !srcloc MDNode contains a list of constant
/// integers which are the source locations of the start of each line in the
/// asm.
//<editor-fold defaultstate="collapsed" desc="getAsmSrcLocInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1764,
 FQN="getAsmSrcLocInfo", NM="_ZL16getAsmSrcLocInfoPKN5clang13StringLiteralERNS_7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZL16getAsmSrcLocInfoPKN5clang13StringLiteralERNS_7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static MDNode /*P*/ getAsmSrcLocInfo(/*const*/ StringLiteral /*P*/ Str, 
                final CodeGenFunction /*&*/ CGF) {
  SmallVector<Metadata /*P*/ > Locs/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  // Add the location of the first line to the MDNode.
  Locs.push_back(ConstantAsMetadata.get(ConstantInt.get(CGF.Int32Ty, $uint2ulong(Str.getLocStart().getRawEncoding()))));
  StringRef StrVal = Str.getString();
  if (!StrVal.empty()) {
    final /*const*/ SourceManager /*&*/ SM = CGF.CGM.getContext().getSourceManager();
    final /*const*/ LangOptions /*&*/ LangOpts = CGF.CGM.getLangOpts();
    uint$ptr StartToken = create_uint$ptr(0);
    uint$ptr ByteOffset = create_uint$ptr(0);
    
    // Add the location of the start of each subsequent line of the asm to the
    // MDNode.
    for (/*uint*/int i = 0, e = StrVal.size() - 1; i != e; ++i) {
      if (StrVal.$at(i) != $$LF) {
        continue;
      }
      SourceLocation LineLoc = Str.getLocationOfByte(i + 1, SM, LangOpts, CGF.getTarget(), /*AddrOf*/StartToken, /*AddrOf*/ByteOffset);
      Locs.push_back(ConstantAsMetadata.get(ConstantInt.get(CGF.Int32Ty, $uint2ulong(LineLoc.getRawEncoding()))));
    }
  }
  
  return MDNode.get(CGF.getLLVMContext(), new ArrayRef<Metadata /*P*/ >(Locs, true));
}

} // END OF class CGStmtStatics
