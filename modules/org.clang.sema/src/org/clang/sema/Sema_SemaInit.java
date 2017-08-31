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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clank.support.aliases.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaInitStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaInit">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaFixItUtils ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang4Sema25PerformCopyInitializationERKNS_17InitializedEntityENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEEbb;_ZN5clang4Sema26ActOnDesignatedInitializerERNS_11DesignationENS_14SourceLocationEbNS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema28CanPerformCopyInitializationERKNS_17InitializedEntityENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema30CreateMaterializeTemporaryExprENS_8QualTypeEPNS_4ExprEb; -static-type=Sema_SemaInit -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaInit extends Sema_SemaFixItUtils {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


//===----------------------------------------------------------------------===//
// Initialization helper functions
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CanPerformCopyInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7820,
 FQN="clang::Sema::CanPerformCopyInitialization", NM="_ZN5clang4Sema28CanPerformCopyInitializationERKNS_17InitializedEntityENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang4Sema28CanPerformCopyInitializationERKNS_17InitializedEntityENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final boolean CanPerformCopyInitialization(final /*const*/ InitializedEntity /*&*/ Entity, 
                            ActionResultTTrue<Expr /*P*/ > Init) {
  InitializationSequence Seq = null;
  try {
    if (Init.isInvalid()) {
      return false;
    }
    
    Expr /*P*/ InitE = Init.get();
    assert ((InitE != null)) : "No initialization expression";
    
    InitializationKind Kind = InitializationKind.CreateCopy(InitE.getLocStart(), new SourceLocation());
    Seq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitE, true));
    return !Seq.Failed();
  } finally {
    if (Seq != null) { Seq.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformCopyInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7835,
 FQN="clang::Sema::PerformCopyInitialization", NM="_ZN5clang4Sema25PerformCopyInitializationERKNS_17InitializedEntityENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang4Sema25PerformCopyInitializationERKNS_17InitializedEntityENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEEbb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformCopyInitialization(final /*const*/ InitializedEntity /*&*/ Entity, 
                         SourceLocation EqualLoc, 
                         ActionResultTTrue<Expr /*P*/ > Init) {
  return PerformCopyInitialization(Entity, 
                         EqualLoc, 
                         Init, 
                         false, 
                         false);
}
public final ActionResultTTrue<Expr /*P*/ > PerformCopyInitialization(final /*const*/ InitializedEntity /*&*/ Entity, 
                         SourceLocation EqualLoc, 
                         ActionResultTTrue<Expr /*P*/ > Init, 
                         boolean TopLevelOfInitList/*= false*/) {
  return PerformCopyInitialization(Entity, 
                         EqualLoc, 
                         Init, 
                         TopLevelOfInitList, 
                         false);
}
public final ActionResultTTrue<Expr /*P*/ > PerformCopyInitialization(final /*const*/ InitializedEntity /*&*/ Entity, 
                         SourceLocation EqualLoc, 
                         ActionResultTTrue<Expr /*P*/ > Init, 
                         boolean TopLevelOfInitList/*= false*/, 
                         boolean AllowExplicit/*= false*/) {
  InitializationSequence Seq = null;
  try {
    if (Init.isInvalid()) {
      return ExprError();
    }
    
    Expr /*P*/ InitE = Init.get();
    assert ((InitE != null)) : "No initialization expression?";
    if (EqualLoc.isInvalid()) {
      EqualLoc.$assignMove(InitE.getLocStart());
    }
    
    InitializationKind Kind = InitializationKind.CreateCopy(InitE.getLocStart(), 
        new SourceLocation(EqualLoc), 
        AllowExplicit);
    Seq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitE, true), TopLevelOfInitList);
    
    ActionResultTTrue<Expr /*P*/ > Result = Seq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitE, true));
    
    return Result;
  } finally {
    if (Seq != null) { Seq.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDesignatedInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2752,
 FQN="clang::Sema::ActOnDesignatedInitializer", NM="_ZN5clang4Sema26ActOnDesignatedInitializerERNS_11DesignationENS_14SourceLocationEbNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang4Sema26ActOnDesignatedInitializerERNS_11DesignationENS_14SourceLocationEbNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnDesignatedInitializer(final Designation /*&*/ Desig, 
                          SourceLocation Loc, 
                          boolean GNUSyntax, 
                          ActionResultTTrue<Expr /*P*/ > Init) {
  /*typedef DesignatedInitExpr::Designator ASTDesignator*/
//  final class ASTDesignator extends DesignatedInitExpr.Designator{ };
  
  boolean Invalid = false;
  SmallVector<DesignatedInitExpr.Designator> Designators/*J*/= new SmallVector<DesignatedInitExpr.Designator>(32, new DesignatedInitExpr.Designator());
  SmallVector<Expr /*P*/ > InitExpressions/*J*/= new SmallVector<Expr /*P*/ >(32, (Expr /*P*/ )null);
  
  // Build designators and check array designator expressions.
  for (/*uint*/int Idx = 0; $less_uint(Idx, Desig.getNumDesignators()); ++Idx) {
    final /*const*/ Designator /*&*/ D = Desig.getDesignator(Idx);
    switch (D.getKind()) {
     case FieldDesignator:
      Designators.push_back(new DesignatedInitExpr.Designator(D.getField(), D.getDotLoc(), 
              D.getFieldLoc()));
      break;
     case ArrayDesignator:
      {
        Expr /*P*/ Index = ((/*static_cast*/Expr /*P*/ )(D.getArrayIndex()));
        APSInt IndexValue/*J*/= new APSInt();
        if (!Index.isTypeDependent() && !Index.isValueDependent()) {
          Index = CheckArrayDesignatorExpr(/*Deref*/$this(), Index, IndexValue).get();
        }
        if (!(Index != null)) {
          Invalid = true;
        } else {
          Designators.push_back(new DesignatedInitExpr.Designator(InitExpressions.size(), 
                  D.getLBracketLoc(), 
                  D.getRBracketLoc()));
          InitExpressions.push_back(Index);
        }
        break;
      }
     case ArrayRangeDesignator:
      {
        Expr /*P*/ StartIndex = ((/*static_cast*/Expr /*P*/ )(D.getArrayRangeStart()));
        Expr /*P*/ EndIndex = ((/*static_cast*/Expr /*P*/ )(D.getArrayRangeEnd()));
        APSInt StartValue/*J*/= new APSInt();
        APSInt EndValue/*J*/= new APSInt();
        boolean StartDependent = StartIndex.isTypeDependent()
           || StartIndex.isValueDependent();
        boolean EndDependent = EndIndex.isTypeDependent()
           || EndIndex.isValueDependent();
        if (!StartDependent) {
          StartIndex
             = CheckArrayDesignatorExpr(/*Deref*/$this(), StartIndex, StartValue).get();
        }
        if (!EndDependent) {
          EndIndex = CheckArrayDesignatorExpr(/*Deref*/$this(), EndIndex, EndValue).get();
        }
        if (!(StartIndex != null) || !(EndIndex != null)) {
          Invalid = true;
        } else {
          // Make sure we're comparing values with the same bit width.
          if (StartDependent || EndDependent) {
            // Nothing to compute.
          } else if ($greater_uint(StartValue.getBitWidth(), EndValue.getBitWidth())) {
            EndValue.$assignMove(EndValue.extend(StartValue.getBitWidth()));
          } else if ($less_uint(StartValue.getBitWidth(), EndValue.getBitWidth())) {
            StartValue.$assignMove(StartValue.extend(EndValue.getBitWidth()));
          }
          if (!StartDependent && !EndDependent && EndValue.$less(StartValue)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getEllipsisLoc(), diag.err_array_designator_empty_range)), 
                              StartValue.__toString(10)), EndValue.__toString(10)), 
                      StartIndex.getSourceRange()), EndIndex.getSourceRange()));
              Invalid = true;
            } finally {
              $c$.$destroy();
            }
          } else {
            Designators.push_back(new DesignatedInitExpr.Designator(InitExpressions.size(), 
                    D.getLBracketLoc(), 
                    D.getEllipsisLoc(), 
                    D.getRBracketLoc()));
            InitExpressions.push_back(StartIndex);
            InitExpressions.push_back(EndIndex);
          }
        }
        break;
      }
    }
  }
  if (Invalid || Init.isInvalid()) {
    return ExprError();
  }
  
  // Clear out the expressions within the designation.
  Desig.ClearExprs(/*Deref*/$this());
  
  DesignatedInitExpr /*P*/ DIE = DesignatedInitExpr.Create($this().Context, 
      new ArrayRef<DesignatedInitExpr.Designator>(Designators, false), 
      new ArrayRef<Expr /*P*/ >(InitExpressions, true), new SourceLocation(Loc), GNUSyntax, 
      Init.getAs(Expr.class));
  if (!$this().getLangOpts().C99) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DIE.getLocStart(), diag.ext_designated_init)), 
          DIE.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DIE);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateMaterializeTemporaryExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6191,
 FQN="clang::Sema::CreateMaterializeTemporaryExpr", NM="_ZN5clang4Sema30CreateMaterializeTemporaryExprENS_8QualTypeEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang4Sema30CreateMaterializeTemporaryExprENS_8QualTypeEPNS_4ExprEb")
//</editor-fold>
public final MaterializeTemporaryExpr /*P*/ CreateMaterializeTemporaryExpr(QualType T, Expr /*P*/ Temporary, 
                              boolean BoundToLvalueReference) {
  MaterializeTemporaryExpr /*P*/ MTE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new MaterializeTemporaryExpr(new QualType(T), Temporary, BoundToLvalueReference);
   });
  
  // Order an ExprWithCleanups for lifetime marks.
  //
  // TODO: It'll be good to have a single place to check the access of the
  // destructor and generate ExprWithCleanups for various uses. Currently these
  // are done in both CreateMaterializeTemporaryExpr and MaybeBindToTemporary,
  // but there may be a chance to merge them.
  $this().Cleanup.setExprNeedsCleanups(false);
  return MTE;
}

} // END OF class Sema_SemaInit
