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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.DeclContext.decl_iterator.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL13noteOverloadsRN5clang4SemaERKNS_17UnresolvedSetImplENS_14SourceLocationE;_ZL20IsCallableWithAppendPN5clang4ExprE;_ZL20IsRecordFullyDefinedPKN5clang13CXXRecordDeclERN4llvm8DenseMapIS2_bNS3_12DenseMapInfoIS2_EENS3_6detail12DenseMapPairIS2_bEEEESB_;_ZL21checkUndefinedButUsedRN5clang4SemaE;_ZL22ShouldRemoveFromUnusedPN5clang4SemaEPKNS_14DeclaratorDeclE;_ZL22notePlausibleOverloadsRN5clang4SemaENS_14SourceLocationERKNS_17UnresolvedSetImplEPFbNS_8QualTypeEE;_ZL31MethodsAndNestedClassesCompletePKN5clang13CXXRecordDeclERN4llvm8DenseMapIS2_bNS3_12DenseMapInfoIS2_EENS3_6detail12DenseMapPairIS2_bEEEE; -static-type=SemaStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaStatics {


/// \brief Used to prune the decls of Sema's UnusedFileScopedDecls vector.
//<editor-fold defaultstate="collapsed" desc="ShouldRemoveFromUnused">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 425,
 FQN="ShouldRemoveFromUnused", NM="_ZL22ShouldRemoveFromUnusedPN5clang4SemaEPKNS_14DeclaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL22ShouldRemoveFromUnusedPN5clang4SemaEPKNS_14DeclaratorDeclE")
//</editor-fold>
public static boolean ShouldRemoveFromUnused(Sema /*P*/ SemaRef, /*const*/ DeclaratorDecl /*P*/ D) {
  if (D.getMostRecentDecl$Const().isUsed()) {
    return true;
  }
  if (D.isExternallyVisible()) {
    return true;
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      // UnusedFileScopedDecls stores the first declaration.
      // The declaration may have become definition so check again.
      type$ref</*const*/ FunctionDecl /*P*/ > DeclToCheck = create_type$ref();
      if (FD.hasBody(DeclToCheck)) {
        return !SemaRef.ShouldWarnIfUnusedFileScopedDecl(DeclToCheck.$deref());
      }
      
      // Later redecls may add new information resulting in not having to warn,
      // so check again.
      DeclToCheck.$set(FD.getMostRecentDecl$Redeclarable$Const());
      if (DeclToCheck.$deref() != FD) {
        return !SemaRef.ShouldWarnIfUnusedFileScopedDecl(DeclToCheck.$deref());
      }
    }
  }
  {
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      // If a variable usable in constant expressions is referenced,
      // don't warn if it isn't used: if the value of a variable is required
      // for the computation of a constant expression, it doesn't make sense to
      // warn even if the variable isn't odr-used.  (isReferenced doesn't
      // precisely reflect that, but it's a decent approximation.)
      if (VD.isReferenced()
         && VD.isUsableInConstantExpressions(SemaRef.Context)) {
        return true;
      }
      
      // UnusedFileScopedDecls stores the first declaration.
      // The declaration may have become definition so check again.
      /*const*/ VarDecl /*P*/ DeclToCheck = VD.getDefinition$Const();
      if ((DeclToCheck != null)) {
        return !SemaRef.ShouldWarnIfUnusedFileScopedDecl(DeclToCheck);
      }
      
      // Later redecls may add new information resulting in not having to warn,
      // so check again.
      DeclToCheck = VD.getMostRecentDecl$Redeclarable$Const();
      if (DeclToCheck != VD) {
        return !SemaRef.ShouldWarnIfUnusedFileScopedDecl(DeclToCheck);
      }
    }
  }
  
  return false;
}


/// checkUndefinedButUsed - Check for undefined objects with internal linkage
/// or that are inline.
//<editor-fold defaultstate="collapsed" desc="checkUndefinedButUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 505,
 FQN="checkUndefinedButUsed", NM="_ZL21checkUndefinedButUsedRN5clang4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL21checkUndefinedButUsedRN5clang4SemaE")
//</editor-fold>
public static void checkUndefinedButUsed(final Sema /*&*/ S) {
  if (S.UndefinedButUsed.empty()) {
    return;
  }
  
  // Collect all the still-undefined entities with internal linkage.
  SmallVector<std.pair<NamedDecl /*P*/ , SourceLocation>> Undefined/*J*/= new SmallVector<std.pair<NamedDecl /*P*/ , SourceLocation>>(16, new std.pairPtrType<NamedDecl /*P*/ , SourceLocation>(null, new SourceLocation()));
  S.getUndefinedButUsed(Undefined);
  if (Undefined.empty()) {
    return;
  }
  
  for (type$ptr<std.pair<NamedDecl /*P*/ , SourceLocation>> I = $tryClone(Undefined.begin()), /*P*/ E = $tryClone(Undefined.end()); $noteq_ptr(I, E); I.$preInc()) {
    NamedDecl /*P*/ ND = I./*->*/$star().first;
    if (ND.hasAttr(DLLImportAttr.class) || ND.hasAttr(DLLExportAttr.class)) {
      // An exported function will always be emitted when defined, so even if
      // the function is inline, it doesn't have to be emitted in this TU. An
      // imported function implies that it has been exported somewhere else.
      continue;
    }
    if (!ND.isExternallyVisible()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), diag.warn_undefined_internal)), 
                isa_VarDecl(ND)), ND));
      } finally {
        $c$.$destroy();
      }
    } else {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
      if ((FD != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ///*J:(void)*/FD;
          assert (FD.getMostRecentDecl().isInlined()) : "used object requires definition but isn't inline or internal?";
          // FIXME: This is ill-formed; we should reject.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), diag.warn_undefined_inline)), ND));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          assert (cast_VarDecl(ND).getMostRecentDecl().isInline()) : "used var requires definition but isn't inline or internal?";
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), diag.err_undefined_inline_var)), ND));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (I./*->*/$star().second.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(I./*->*/$star().second), diag.note_used_here)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  S.UndefinedButUsed.clear();
}


/// \brief Returns true, if all methods and nested classes of the given
/// CXXRecordDecl are defined in this translation unit.
///
/// Should only be called from ActOnEndOfTranslationUnit so that all
/// definitions are actually read.
//<editor-fold defaultstate="collapsed" desc="MethodsAndNestedClassesComplete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 563,
 FQN="MethodsAndNestedClassesComplete", NM="_ZL31MethodsAndNestedClassesCompletePKN5clang13CXXRecordDeclERN4llvm8DenseMapIS2_bNS3_12DenseMapInfoIS2_EENS3_6detail12DenseMapPairIS2_bEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL31MethodsAndNestedClassesCompletePKN5clang13CXXRecordDeclERN4llvm8DenseMapIS2_bNS3_12DenseMapInfoIS2_EENS3_6detail12DenseMapPairIS2_bEEEE")
//</editor-fold>
public static boolean MethodsAndNestedClassesComplete(/*const*/ CXXRecordDecl /*P*/ RD, 
                               final DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ > /*&*/ MNCComplete) {
  DenseMapIteratorTypeBool</*const*/ CXXRecordDecl /*P*/ /*P*/> Cache = MNCComplete.find(RD);
  if (Cache.$noteq(/*NO_ITER_COPY*/MNCComplete.end())) {
    return Cache.$arrow().second;
  }
  if (!RD.isCompleteDefinition()) {
    return false;
  }
  boolean Complete = true;
  for (DeclContext.decl_iterator I = RD.decls_begin(), 
      E = RD.decls_end();
       $noteq_decl_iterator(/*NO_COPY*/I, /*NO_COPY*/E) && Complete; I.$preInc()) {
    {
      /*const*/ CXXMethodDecl /*P*/ M = dyn_cast_CXXMethodDecl(I.$star());
      if ((M != null)) {
        Complete = M.isDefined() || (M.isPure() && !isa_CXXDestructorDecl(M));
      } else {
        /*const*/ FunctionTemplateDecl /*P*/ F = dyn_cast_FunctionTemplateDecl(I.$star());
        if ((F != null)) {
          // If the template function is marked as late template parsed at this
          // point, it has not been instantiated and therefore we have not
          // performed semantic analysis on it yet, so we cannot know if the type
          // can be considered complete.
          Complete = !F.getTemplatedDecl().isLateTemplateParsed()
             && F.getTemplatedDecl().isDefined();
        } else {
          /*const*/ CXXRecordDecl /*P*/ R = dyn_cast_CXXRecordDecl(I.$star());
          if ((R != null)) {
            if (R.isInjectedClassName()) {
              continue;
            }
            if (R.hasDefinition()) {
              Complete = MethodsAndNestedClassesComplete(R.getDefinition(), 
                  MNCComplete);
            } else {
              Complete = false;
            }
          }
        }
      }
    }
  }
  MNCComplete.$set(RD, Complete);
  return Complete;
}


/// \brief Returns true, if the given CXXRecordDecl is fully defined in this
/// translation unit, i.e. all methods are defined or pure virtual and all
/// friends, friend functions and nested classes are fully defined in this
/// translation unit.
///
/// Should only be called from ActOnEndOfTranslationUnit so that all
/// definitions are actually read.
//<editor-fold defaultstate="collapsed" desc="IsRecordFullyDefined">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 604,
 FQN="IsRecordFullyDefined", NM="_ZL20IsRecordFullyDefinedPKN5clang13CXXRecordDeclERN4llvm8DenseMapIS2_bNS3_12DenseMapInfoIS2_EENS3_6detail12DenseMapPairIS2_bEEEESB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL20IsRecordFullyDefinedPKN5clang13CXXRecordDeclERN4llvm8DenseMapIS2_bNS3_12DenseMapInfoIS2_EENS3_6detail12DenseMapPairIS2_bEEEESB_")
//</editor-fold>
public static boolean IsRecordFullyDefined(/*const*/ CXXRecordDecl /*P*/ RD, 
                    final DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ > /*&*/ RecordsComplete, 
                    final DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ > /*&*/ MNCComplete) {
  DenseMapIteratorTypeBool</*const*/ CXXRecordDecl /*P*/ /*P*/> Cache = RecordsComplete.find(RD);
  if (Cache.$noteq(/*NO_ITER_COPY*/RecordsComplete.end())) {
    return Cache.$arrow().second;
  }
  boolean Complete = MethodsAndNestedClassesComplete(RD, MNCComplete);
  for (CXXRecordDecl.friend_iterator I = RD.friend_begin(), 
      E = RD.friend_end();
       I.$noteq(E) && Complete; I.$preInc()) {
    {
      // Check if friend classes and methods are complete.
      TypeSourceInfo /*P*/ TSI = (I.$star()).getFriendType();
      if ((TSI != null)) {
        {
          // Friend classes are available as the TypeSourceInfo of the FriendDecl.
          CXXRecordDecl /*P*/ FriendD = TSI.getType().$arrow().getAsCXXRecordDecl();
          if ((FriendD != null)) {
            Complete = MethodsAndNestedClassesComplete(FriendD, MNCComplete);
          } else {
            Complete = false;
          }
        }
      } else {
        {
          // Friend functions are available through the NamedDecl of FriendDecl.
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl((I.$star()).getFriendDecl());
          if ((FD != null)) {
            Complete = FD.isDefined();
          } else {
            // This is a template friend, give up.
            Complete = false;
          }
        }
      }
    }
  }
  RecordsComplete.$set(RD, Complete);
  return Complete;
}


/// \brief Give notes for a set of overloads.
///
/// A companion to tryExprAsCall. In cases when the name that the programmer
/// wrote was an overloaded function, we may be able to make some guesses about
/// plausible overloads based on their return types; such guesses can be handed
/// off to this method to be emitted as notes.
///
/// \param Overloads - The overloads to note.
/// \param FinalNoteLoc - If we've suppressed printing some overloads due to
///  -fshow-overloads=best, this is the location to attach to the note about too
///  many candidates. Typically this will be the location of the original
///  ill-formed expression.
//<editor-fold defaultstate="collapsed" desc="noteOverloads">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1400,
 FQN="noteOverloads", NM="_ZL13noteOverloadsRN5clang4SemaERKNS_17UnresolvedSetImplENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL13noteOverloadsRN5clang4SemaERKNS_17UnresolvedSetImplENS_14SourceLocationE")
//</editor-fold>
public static void noteOverloads(final Sema /*&*/ S, final /*const*/ UnresolvedSetImpl /*&*/ Overloads, 
             /*const*/ SourceLocation FinalNoteLoc) {
  int ShownOverloads = 0;
  int SuppressedOverloads = 0;
  for (UnresolvedSetIterator It = Overloads.begin$Const(), 
      DeclsEnd = Overloads.end$Const(); It.$noteq(DeclsEnd); It.$preInc()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: Magic number for max shown overloads stolen from
      // OverloadCandidateSet::NoteCandidates.
      if (ShownOverloads >= 4 && S.Diags.getShowOverloads() == OverloadsShown.Ovl_Best) {
        ++SuppressedOverloads;
        continue;
      }
      
      NamedDecl /*P*/ Fn = (It.$star()).getUnderlyingDecl();
      $c$.clean($c$.track(S.Diag(Fn.getLocation(), diag.note_possible_target_of_call)));
      ++ShownOverloads;
    } finally {
      $c$.$destroy();
    }
  }
  if ((SuppressedOverloads != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(FinalNoteLoc), diag.note_ovl_too_many_candidates)), 
          SuppressedOverloads));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="notePlausibleOverloads">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1423,
 FQN="notePlausibleOverloads", NM="_ZL22notePlausibleOverloadsRN5clang4SemaENS_14SourceLocationERKNS_17UnresolvedSetImplEPFbNS_8QualTypeEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL22notePlausibleOverloadsRN5clang4SemaENS_14SourceLocationERKNS_17UnresolvedSetImplEPFbNS_8QualTypeEE")
//</editor-fold>
public static void notePlausibleOverloads(final Sema /*&*/ S, SourceLocation Loc, 
                      final /*const*/ UnresolvedSetImpl /*&*/ Overloads, 
                      BoolPredicate<QualType> IsPlausibleResult) {
  if (!(IsPlausibleResult != null)) {
    noteOverloads(S, Overloads, new SourceLocation(Loc));
    /*JAVA:return*/return;
  }
  
  UnresolvedSet PlausibleOverloads/*J*/= new UnresolvedSet(2);
  for (UnresolvedSetIterator It = Overloads.begin$Const(), 
      DeclsEnd = Overloads.end$Const(); It.$noteq(DeclsEnd); It.$preInc()) {
    /*const*/ FunctionDecl /*P*/ OverloadDecl = cast_FunctionDecl(It.$star());
    QualType OverloadResultTy = OverloadDecl.getReturnType();
    if (IsPlausibleResult.$call(new QualType(OverloadResultTy))) {
      PlausibleOverloads.addDecl(It.getDecl());
    }
  }
  noteOverloads(S, PlausibleOverloads, new SourceLocation(Loc));
}


/// Determine whether the given expression can be called by just
/// putting parentheses after it.  Notably, expressions with unary
/// operators can't be because the unary operator will start parsing
/// outside the call.
//<editor-fold defaultstate="collapsed" desc="IsCallableWithAppend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1444,
 FQN="IsCallableWithAppend", NM="_ZL20IsCallableWithAppendPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZL20IsCallableWithAppendPN5clang4ExprE")
//</editor-fold>
public static boolean IsCallableWithAppend(Expr /*P*/ E) {
  E = E.IgnoreImplicit();
  return (!isa_CStyleCastExpr(E)
     && !isa_UnaryOperator(E)
     && !isa_BinaryOperator(E)
     && !isa_CXXOperatorCallExpr(E));
}

} // END OF class SemaStatics
