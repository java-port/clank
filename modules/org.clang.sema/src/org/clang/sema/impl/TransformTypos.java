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

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.sema.impl.SemaExprCXXStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6742,
 FQN="(anonymous namespace)::TransformTypos", NM="_ZN12_GLOBAL__N_114TransformTyposE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTyposE")
//</editor-fold>
public class TransformTypos extends /*public*/ TreeTransform<TransformTypos> implements Destructors.ClassWithDestructor {
  /*typedef TreeTransform<TransformTypos> BaseTransform*/
//  public final class BaseTransform extends TreeTransform<TransformTypos>{ };
  
  private VarDecl /*P*/ InitDecl; // A decl to avoid as a correction because it is in the
  // process of being initialized.
  private Expr2ExprResult ExprFilter;
  private SmallSetVector<TypoExpr /*P*/ > TypoExprs;
  private SmallSetVector<TypoExpr /*P*/ > AmbiguousTypoExprs;
  private SmallDenseMap<TypoExpr /*P*/ , ActionResultTTrue<Expr /*P*/ >> TransformCache;
  private SmallDenseMap<OverloadExpr /*P*/ , Expr /*P*/ > OverloadResolution;
  
  /// \brief Emit diagnostics for all of the TypoExprs encountered.
  /// If the TypoExprs were successfully corrected, then the diagnostics should
  /// suggest the corrections. Otherwise the diagnostics will not suggest
  /// anything (having been passed an empty TypoCorrection).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::EmitAllDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6756,
   FQN="(anonymous namespace)::TransformTypos::EmitAllDiagnostics", NM="_ZN12_GLOBAL__N_114TransformTypos18EmitAllDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos18EmitAllDiagnosticsEv")
  //</editor-fold>
  private void EmitAllDiagnostics() {
    for (TypoExpr /*P*/ E : TypoExprs) {
      TypoExpr /*P*/ TE = cast_TypoExpr(E);
      final /*const*/ TypoExprState /*&*/ State = SemaRef.getTypoExprState(TE);
      if (State.DiagHandler != null) {
        TypoCorrection TC = new TypoCorrection(State.Consumer.$arrow().getCurrentCorrection());
        ActionResultTTrue<Expr /*P*/ > Replacement = new ActionResultTTrue<Expr /*P*/ >(TransformCache.$at_T1$C$R(TE));
        {
          
          // Extract the NamedDecl from the transformed TypoExpr and add it to the
          // TypoCorrection, replacing the existing decls. This ensures the right
          // NamedDecl is used in diagnostics e.g. in the case where overload
          // resolution was used to select one from several possible decls that
          // had been stored in the TypoCorrection.
          NamedDecl /*P*/ ND = getDeclFromExpr(Replacement.isInvalid() ? (Expr /*P*/ )null : Replacement.get());
          if ((ND != null)) {
            TC.setCorrectionDecl(ND);
          }
        }
        
        State.DiagHandler.$call(TC);
      }
      SemaRef.clearDelayedTypo(TE);
    }
  }

  
  /// \brief If corrections for the first TypoExpr have been exhausted for a
  /// given combination of the other TypoExprs, retry those corrections against
  /// the next combination of substitutions for the other TypoExprs by advancing
  /// to the next potential correction of the second TypoExpr. For the second
  /// and subsequent TypoExprs, if its stream of corrections has been exhausted,
  /// the stream is reset and the next TypoExpr's stream is advanced by one (a
  /// TypoExpr's correction stream is advanced by removing the TypoExpr from the
  /// TransformCache). Returns true if there is still any untried combinations
  /// of corrections.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::CheckAndAdvanceTypoExprCorrectionStreams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6788,
   FQN="(anonymous namespace)::TransformTypos::CheckAndAdvanceTypoExprCorrectionStreams", NM="_ZN12_GLOBAL__N_114TransformTypos40CheckAndAdvanceTypoExprCorrectionStreamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos40CheckAndAdvanceTypoExprCorrectionStreamsEv")
  //</editor-fold>
  private boolean CheckAndAdvanceTypoExprCorrectionStreams() {
    for (TypoExpr /*P*/ TE : TypoExprs) {
      final /*const*/ TypoExprState /*&*/ State = SemaRef.getTypoExprState(TE);
      TransformCache.erase(TE);
      if (!State.Consumer.$arrow().finished()) {
        return true;
      }
      State.Consumer.$arrow().resetCorrectionStream();
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::getDeclFromExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6799,
   FQN="(anonymous namespace)::TransformTypos::getDeclFromExpr", NM="_ZN12_GLOBAL__N_114TransformTypos15getDeclFromExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos15getDeclFromExprEPN5clang4ExprE")
  //</editor-fold>
  private NamedDecl /*P*/ getDeclFromExpr(Expr /*P*/ E) {
    {
      OverloadExpr /*P*/ OE = dyn_cast_or_null_OverloadExpr(E);
      if ((OE != null)) {
        E = OverloadResolution.$at_T1$C$R(OE);
      }
    }
    if (!(E != null)) {
      return null;
    }
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        return DRE.getFoundDecl();
      }
    }
    {
      MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
      if ((ME != null)) {
        return ME.getFoundDecl().$NamedDecl$P();
      }
    }
    // FIXME: Add any other expr types that could be be seen by the delayed typo
    // correction TreeTransform for which the corresponding TypoCorrection could
    // contain multiple decls.
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TryTransform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6815,
   FQN="(anonymous namespace)::TransformTypos::TryTransform", NM="_ZN12_GLOBAL__N_114TransformTypos12TryTransformEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos12TryTransformEPN5clang4ExprE")
  //</editor-fold>
  private ActionResultTTrue<Expr /*P*/ > TryTransform(Expr /*P*/ E) {
    Sema.SFINAETrap Trap = null;
    try {
      Trap/*J*/= new Sema.SFINAETrap(SemaRef);
      ActionResultTTrue<Expr /*P*/ > Res = TransformExpr(E);
      if (Trap.hasErrorOccurred() || Res.isInvalid()) {
        return ExprError();
      }
      
      return ExprFilter.$call(Res.get());
    } finally {
      if (Trap != null) { Trap.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TransformTypos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6825,
   FQN="(anonymous namespace)::TransformTypos::TransformTypos", NM="_ZN12_GLOBAL__N_114TransformTyposC1ERN5clang4SemaEPNS1_7VarDeclEN4llvm12function_refIFNS1_12ActionResultIPNS1_4ExprELb1EEESA_EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTyposC1ERN5clang4SemaEPNS1_7VarDeclEN4llvm12function_refIFNS1_12ActionResultIPNS1_4ExprELb1EEESA_EEE")
  //</editor-fold>
  public TransformTypos(final Sema /*&*/ SemaRef, VarDecl /*P*/ InitDecl, Expr2ExprResult Filter) {
    // : BaseTransform(SemaRef), InitDecl(InitDecl), ExprFilter(Filter), TypoExprs(), AmbiguousTypoExprs(), TransformCache(), OverloadResolution() 
    //START JInit
    super(SemaRef);
    this.InitDecl = InitDecl;
    this.ExprFilter = /*FuncArg*/Filter;
    this.TypoExprs = new SmallSetVector<TypoExpr /*P*/ >(2, (TypoExpr /*P*/ ) null);
    this.AmbiguousTypoExprs = new SmallSetVector<TypoExpr /*P*/ >(2, (TypoExpr /*P*/ ) null);
    this.TransformCache = new SmallDenseMap<TypoExpr /*P*/ , ActionResultTTrue<Expr /*P*/ >>(DenseMapInfo$LikePtr.$Info(), 2, new ActionResultTTrue<Expr /*P*/ >());
    this.OverloadResolution = new SmallDenseMap<OverloadExpr /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4, (Expr /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::RebuildCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6828,
   FQN="(anonymous namespace)::TransformTypos::RebuildCallExpr", NM="_ZN12_GLOBAL__N_114TransformTypos15RebuildCallExprEPN5clang4ExprENS1_14SourceLocationEN4llvm15MutableArrayRefIS3_EES4_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos15RebuildCallExprEPN5clang4ExprENS1_14SourceLocationEN4llvm15MutableArrayRefIS3_EES4_S3_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > RebuildCallExpr(Expr /*P*/ Callee, SourceLocation LParenLoc, 
                 MutableArrayRef<Expr /*P*/ > Args, 
                 SourceLocation RParenLoc) {
    return RebuildCallExpr(Callee, LParenLoc, 
                 Args, 
                 RParenLoc, 
                 (Expr /*P*/ )null);
  }
  public ActionResultTTrue<Expr /*P*/ > RebuildCallExpr(Expr /*P*/ Callee, SourceLocation LParenLoc, 
                 MutableArrayRef<Expr /*P*/ > Args, 
                 SourceLocation RParenLoc, 
                 Expr /*P*/ ExecConfig/*= null*/) {
    ActionResultTTrue<Expr /*P*/ > Result = super.RebuildCallExpr(Callee, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(Args), 
        new SourceLocation(RParenLoc), ExecConfig);
    {
      OverloadExpr /*P*/ OE = dyn_cast_OverloadExpr(Callee);
      if ((OE != null)) {
        if (Result.isUsable()) {
          Expr /*P*/ ResultCall = Result.get();
          {
            CXXBindTemporaryExpr /*P*/ BE = dyn_cast_CXXBindTemporaryExpr(ResultCall);
            if ((BE != null)) {
              ResultCall = BE.getSubExpr();
            }
          }
          {
            CallExpr /*P*/ CE = dyn_cast_CallExpr(ResultCall);
            if ((CE != null)) {
              OverloadResolution.$set(OE, CE.getCallee());
            }
          }
        }
      }
    }
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TransformLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6846,
   FQN="(anonymous namespace)::TransformTypos::TransformLambdaExpr", NM="_ZN12_GLOBAL__N_114TransformTypos19TransformLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos19TransformLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformLambdaExpr(LambdaExpr /*P*/ E) {
    return Owned(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TransformBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6848,
   FQN="(anonymous namespace)::TransformTypos::TransformBlockExpr", NM="_ZN12_GLOBAL__N_114TransformTypos18TransformBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos18TransformBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformBlockExpr(BlockExpr /*P*/ E) {
    return Owned(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TransformObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6850,
   FQN="(anonymous namespace)::TransformTypos::TransformObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_114TransformTypos28TransformObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos28TransformObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ E) {
    return Owned(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TransformObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6854,
   FQN="(anonymous namespace)::TransformTypos::TransformObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_114TransformTypos24TransformObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos24TransformObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    return Owned(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::Transform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6858,
   FQN="(anonymous namespace)::TransformTypos::Transform", NM="_ZN12_GLOBAL__N_114TransformTypos9TransformEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos9TransformEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > Transform(Expr /*P*/ E) {
    ActionResultTTrue<Expr /*P*/ > Res/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    while (true) {
      Res.$assignMove(TryTransform(E));
      
      // Exit if either the transform was valid or if there were no TypoExprs
      // to transform that still have any untried correction candidates..
      if (!Res.isInvalid()
         || !CheckAndAdvanceTypoExprCorrectionStreams()) {
        break;
      }
    }
    
    // Ensure none of the TypoExprs have multiple typo correction candidates
    // with the same edit length that pass all the checks and filters.
    // TODO: Properly handle various permutations of possible corrections when
    // there is more than one potentially ambiguous typo correction.
    // Also, disable typo correction while attempting the transform when
    // handling potentially ambiguous typo corrections as any new TypoExprs will
    // have been introduced by the application of one of the correction
    // candidates and add little to no value if corrected.
    SemaRef.DisableTypoCorrection = true;
    while (!AmbiguousTypoExprs.empty()) {
      TypoExpr /*P*/ TE = AmbiguousTypoExprs.back();
      ActionResultTTrue<Expr /*P*/ > Cached = new ActionResultTTrue<Expr /*P*/ >(TransformCache.$at_T1$C$R(TE));
      final /*const*/ TypoExprState /*&*/ State = SemaRef.getTypoExprState(TE);
      State.Consumer.$arrow().saveCurrentPosition();
      TransformCache.erase(TE);
      if (!TryTransform(E).isInvalid()) {
        State.Consumer.$arrow().resetCorrectionStream();
        TransformCache.erase(TE);
        Res.$assignMove(ExprError());
        break;
      }
      AmbiguousTypoExprs.remove(TE);
      State.Consumer.$arrow().restoreSavedPosition();
      TransformCache.$at_T1$C$R(TE).$assign(Cached);
    }
    SemaRef.DisableTypoCorrection = false;
    
    // Ensure that all of the TypoExprs within the current Expr have been found.
    if (!Res.isUsable()) {
      new FindTypoExprs(TypoExprs).TraverseStmt(E);
    }
    
    EmitAllDiagnostics();
    
    return Res;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::TransformTypoExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6906,
   FQN="(anonymous namespace)::TransformTypos::TransformTypoExpr", NM="_ZN12_GLOBAL__N_114TransformTypos17TransformTypoExprEPN5clang8TypoExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTypos17TransformTypoExprEPN5clang8TypoExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformTypoExpr(TypoExpr /*P*/ E) {
    // If the TypoExpr hasn't been seen before, record it. Otherwise, return the
    // cached transformation result if there is one and the TypoExpr isn't the
    // first one that was encountered.
    final ActionResultTTrue<Expr /*P*/ > /*&*/ CacheEntry = TransformCache.$at_T1$C$R(E);
    if (!TypoExprs.insert(E) && !CacheEntry.isUnset()) {
      return new ActionResultTTrue<Expr /*P*/ >(CacheEntry);
    }
    
    final /*const*/ TypoExprState /*&*/ State = SemaRef.getTypoExprState(E);
    assert (State.Consumer.$bool()) : "Cannot transform a cleared TypoExpr";
    {
      
      // For the first TypoExpr and an uncached TypoExpr, find the next likely
      // typo correction and return it.
      TypoCorrection TC;
      while ((TC = new TypoCorrection(State.Consumer.$arrow().getNextCorrection())).$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if ((InitDecl != null) && TC.getFoundDecl() == InitDecl) {
            continue;
          }
          ActionResultTTrue<Expr /*P*/ > NE = $c$.clean(State.RecoveryHandler != null ? State.RecoveryHandler.$call(SemaRef, E, $c$.track(new TypoCorrection(TC))) : attemptRecovery(SemaRef, State.Consumer.$star(), TC));
          if (!NE.isInvalid()) {
            TypoCorrection Next = null;
            try {
              // Check whether there may be a second viable correction with the same
              // edit distance; if so, remember this TypoExpr may have an ambiguous
              // correction so it can be more thoroughly vetted later.
              Next/*J*/= new TypoCorrection();
              if ((Next.$assign(State.Consumer.$arrow().peekNextCorrection())).$bool()
                 && Next.getEditDistance(false) == TC.getEditDistance(false)) {
                AmbiguousTypoExprs.insert(E);
              } else {
                AmbiguousTypoExprs.remove(E);
              }
              assert (!NE.isUnset()) : "Typo was transformed into a valid-but-null ExprResult";
              return new ActionResultTTrue<Expr /*P*/ >(CacheEntry.$assign(NE));
            } finally {
              if (Next != null) { Next.$destroy(); }
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    return new ActionResultTTrue<Expr /*P*/ >(CacheEntry.$assignMove(ExprError()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformTypos::~TransformTypos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6742,
   FQN="(anonymous namespace)::TransformTypos::~TransformTypos", NM="_ZN12_GLOBAL__N_114TransformTyposD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_114TransformTyposD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OverloadResolution.$destroy();
    TransformCache.$destroy();
    AmbiguousTypoExprs.$destroy();
    TypoExprs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "InitDecl=" + InitDecl // NOI18N
              + ", ExprFilter=" + ExprFilter // NOI18N
              + ", TypoExprs=" + TypoExprs // NOI18N
              + ", AmbiguousTypoExprs=" + AmbiguousTypoExprs // NOI18N
              + ", TransformCache=" + TransformCache // NOI18N
              + ", OverloadResolution=" + OverloadResolution // NOI18N
              + super.toString(); // NOI18N
  }
}
